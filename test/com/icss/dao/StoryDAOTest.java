package com.icss.dao;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

import com.icss.po.Story;

public class StoryDAOTest {
	
	private StoryDAO dao = new StoryDAO();
	Story story = new Story();
    
	@Ignore
	@Test
	public void testAddStory() throws Exception {
		story.setStoryName(null);
		story.setStoryContent(null);
		story.setPicture(null);
		story.setCreateTime(null);
		dao.add(story);
	}
    
	@Ignore
	@Test
	public void testModifyStory() throws Exception {
		story.setStoryName(null);
		story.setStoryContent(null);
		story.setPicture(null);
		story.setCreateTime(null);
		story.setStoryId(null);
		dao.modify(story);
	}
    
	@Ignore
	@Test
	public void testDeleteStory() throws Exception {
		story.setStoryId(null);
		dao.delete(story);
	}
    
	@Ignore
	@Test
	public void testFindAll() throws Exception {
		System.out.println(dao.findAll().size());
	}
    @Ignore
	@Test
	public void testFindByIdStory() throws Exception {
		story.setStoryId(1);
		System.out.println(dao.findById(story).getStoryId());
	}

}
