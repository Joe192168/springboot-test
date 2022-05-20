package com.junit;

import com.test.HelloWorld;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HelloWorldTest2 {
 	private HelloWorld hw;
 
 	@Before
 	public void setUp() {
 		hw = new HelloWorld();
 	}
 
 	@Test(expected=NumberFormatException.class)
 	// 1.测试没有返回值,有别于junit3的使用，更加方便
 	public void testHello() {
 		hw.sayHello();
 	}
 	@Test
 	public void testWorld() {
 		hw.sayWorld();
 	}
 	
 	@Test
 	// 2.测试有返回值的方法
 	// 返回字符串
 	public void testSay() {
		Assert.assertEquals("测试失败", hw.say(), "hello world!");
 	}
 	
 	@Test
 	// 返回对象
 	public void testObj() {
		Assert.assertNull("测试对象不为空", null);
		Assert.assertNotNull("测试对象为空", new String());
 	}
 
 	@After
 	public void tearDown() throws Exception {
 		hw = null;
 	}
 
}