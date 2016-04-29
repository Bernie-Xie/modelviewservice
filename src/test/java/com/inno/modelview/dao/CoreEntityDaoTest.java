package com.inno.modelview.dao;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;

import com.inno.modelview.SetUp;
import com.inno.modelview.dao.impl.CoreEntityDao;

public class CoreEntityDaoTest {
	
	ApplicationContext applicationContext;
	ICoreEntityDao coreEntityDao;

	@Before
	public void setUp() throws Exception {
		this.applicationContext = SetUp.loadSpringContext();
		coreEntityDao = (ICoreEntityDao)applicationContext.getBean("coreEntityDao");
	}
	
	
	@Test
	public void testetCoreEntityById(){
		assertNotNull(coreEntityDao);
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
