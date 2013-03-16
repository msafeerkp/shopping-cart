package org.spinach.cart.reposotry;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.spinach.cart.domain.City;
import org.spinach.cart.domain.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@Profile("test")
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("test")
public class CityRepositoryTest {

	@Resource
	Country country;
	/**
	 * @param args
	 */
	@Test
	public void Add() {
		country.setCountryName("India");
		country.add(country);
	}

}
