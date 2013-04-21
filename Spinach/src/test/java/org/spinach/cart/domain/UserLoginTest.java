package org.spinach.cart.domain;

import javax.annotation.Resource;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.spinach.cart.exception.CartException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class UserLoginTest {
	
	private static Logger logger = Logger.getLogger(UserLoginTest.class);
	@Resource
	private UserLogin userLogin;
	
	public UserLogin getUserLogin() {
		return userLogin;
	}

	public void setUserLogin(UserLogin userLogin) {
		this.userLogin = userLogin;
	}

	@Test
	public void isExistAndActive() throws CartException{
		logger.info(ReflectionToStringBuilder.toString(userLogin.isExistAndActive("msafeer@gmail.com", "N"),ToStringStyle.MULTI_LINE_STYLE));
	}
}
