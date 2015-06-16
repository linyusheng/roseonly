package com.icss.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import com.icss.po.Order;
import com.icss.vo.OrderVO;
import com.icss.vo.PageVO;

public class OrderDAO extends DAOSupport<Order>{

	@Override
	public void add(Order vo) throws Exception {
		// TODO Auto-generated method stub
		String sql = "insert into t_order values(null,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		db.execute(sql, vo.getUserId(),vo.getRoseId(),vo.getRecInfoId(),
				vo.getOrderNo(),vo.getOrderName(),vo.getMoney(),vo.getStatus(),
				vo.getStartTime(),vo.getEndTime(),vo.getNum(),
				vo.getcTime(),vo.getSigns(),vo.getBless());
	}

	@Override
	public void modify(Order vo) throws Exception {
		// TODO Auto-generated method stub
		String sql = "update t_order set userId = ?,roseId = ?, recInfoId = ?,orderNo = ?," +
				"orderName = ?,money = ?,status = ?,startTime = ?,endTime = ?,num = ?,cTime = ?,signs = ?,bless = ? where orderId = ?";
		db.execute(sql, vo.getUserId(),vo.getRoseId(),vo.getRecInfoId(),
				vo.getOrderNo(),vo.getOrderName(),vo.getMoney(),vo.getStatus(),
				vo.getStartTime(),vo.getEndTime(),vo.getNum(),
				vo.getcTime(),vo.getSigns(),vo.getBless(),vo.getOrderId());
	}

	@Override
	public void delete(Order vo) throws Exception {
		// TODO Auto-generated method stub
		String sql = "delete from t_order where orderId = ?";
		db.execute(sql, vo.getOrderId());
	}

	@Override
	public List<Order> findAll() throws Exception {
		// TODO Auto-generated method stub
		String sql = "select * from t_order";
		return db.list(sql, new Order());
	}
	
	@Override
	public Order findById(Order vo) throws Exception {
		// TODO Auto-generated method stub
		String sql = "select * from t_order where orderId = ?";
		return db.get(sql, new Order(),vo.getOrderId());
	}
	/**
	 * 提交订单
	 * @throws Exception
	 */
	public void submitOrder(List<Order> list,Integer userId) throws Exception{
		Connection con = db.getConnectin();
		con.setAutoCommit(false);
		PreparedStatement ps = null;
		//System.out.println("order:"+list.size());
		try {
			//批量添加订单
			String add = "insert into t_order values(null,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			ps = con.prepareStatement(add);
			for (Order order : list) {
				ps.setInt(1, order.getUserId());
				ps.setInt(2, order.getRoseId());
				ps.setInt(3, order.getRecInfoId());
				ps.setString(4, order.getOrderNo());
				ps.setString(5, order.getOrderName());
				ps.setFloat(6, order.getMoney());
				ps.setString(7, order.getStatus());
				ps.setTimestamp(8, order.getStartTime());
				ps.setTimestamp(9, order.getEndTime());
				ps.setInt(10, order.getNum());
				ps.setTimestamp(11, order.getcTime());
				ps.setString(12, order.getSigns());
				ps.setString(13, order.getBless());
				ps.addBatch();
			}
			System.out.println("add:"+ps.executeBatch().length);
			//删除用户的购物车
			String delete = "delete from t_shopping where userId = "+ userId;
			ps.executeUpdate(delete);
			//批量更新商品
			String update = "update t_rose set roseNum=(select roseNum)-? where roseId=?";
			ps = con.prepareStatement(update);
			for(Order order : list){
				ps.setInt(1, order.getNum());
				ps.setInt(2, order.getRoseId());
				ps.addBatch();
			}
			System.out.println("update:"+ps.executeBatch());
			con.commit();
		} catch (Exception e) {
			e.printStackTrace();
			con.rollback();
		}finally{
			ps.close();
			con.close();
		}
		
	}
	/**
	 * 查找用户订单
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public List<OrderVO> findByUserId(Integer userId) throws Exception{
		String sql = "SELECT o.*,u.account,r.roseName,r.picture,r.rosePrice,a.consignee,a.address,a.area,a.city,a.privince,a.mobile,a.postcode ";
		sql += "FROM t_order AS o,t_rose AS r,t_recinfo AS a,t_user AS u ";
		sql += "WHERE o.roseId=r.roseId AND o.recInfoId=a.recInfoId AND o.userId=u.userId AND o.userId=? ";
		sql += "ORDER By orderId DESC";
		return db.list(sql, new OrderVO(), userId);
	}
	/**
	 * 查询所有订单
	 * @return
	 * @throws Exception
	 */
	public PageVO<OrderVO> getAllOrder(PageVO<OrderVO> pageVO) throws Exception{
		String sql = "SELECT o.*,u.account,r.roseName,r.picture,r.rosePrice,a.consignee,a.address,a.area,a.city,a.privince,a.mobile,a.postcode ";
		sql += "FROM t_order AS o,t_rose AS r,t_recinfo AS a,t_user AS u ";
		sql += "WHERE o.roseId=r.roseId AND o.recInfoId=a.recInfoId AND o.userId=u.userId ";
		sql += "ORDER By orderId DESC";
		return page(sql, pageVO.getPage(), pageVO.getRowMax(), new OrderVO());
	}
}
