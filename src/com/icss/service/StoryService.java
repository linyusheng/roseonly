package com.icss.service;

import java.util.List;

import com.icss.dao.StoryDAO;
import com.icss.po.Story;

public class StoryService {
    
	private StoryDAO storyDAO = new StoryDAO(); 
	
	/**
	 * 功能：添加故事
	 * @param story
	 * @throws Exception
	 */
	public void addStory(Story story) throws Exception{
		storyDAO.add(story);
	}
	
	/**
	 * 功能：修改故事
	 * @param story
	 * @throws Exception
	 */
	public void modifyStory(Story story) throws Exception{
		storyDAO.modify(story);
	}
	
	/**
	 * 功能：删除故事
	 * @param story
	 * @throws Exception
	 */
	public void deleteStory(Story story) throws Exception{
		storyDAO.delete(story);
	}
	
	/**
	 * 功能：获取所有故事
	 * @param story
	 * @return
	 * @throws Exception
	 */
	public List<Story> findAllStory(Story story) throws Exception{
		return storyDAO.findAll();
	}
	
	/**
	 * 功能：通过故事ID获取故事
	 * @param story
	 * @return
	 * @throws Exception
	 */
	public Story findByStoryId(Story story) throws Exception{
		return storyDAO.findById(story);
	}
}
