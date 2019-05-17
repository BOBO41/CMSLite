package com.xiang.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration   
(locations = {
		"/spring/spring-context-config.xml",
		"/spring/spring-context-ehcache.xml",
	"/spring/spring-context-redis.xml",
	"/spring/spring-context-database.xml",
	"/spring/spring-context-shiro.xml",
	"/spring/spring-context-vesta.xml"})
@ActiveProfiles("development")
@Transactional
public class BaseJunit4Test {

	@Test
	public void test() {
		
	}
}
