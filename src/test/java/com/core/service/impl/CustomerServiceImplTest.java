package com.core.service.impl;

import com.core.bean.Customer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/** 
* CustomerServiceImpl Tester. 
* 
* @author <Authors name> 
* @since <pre>Ê®¶þÔÂ 20, 2018</pre> 
* @version 1.0 
*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext-dao.xml","classpath:applicationContext-service.xml"})
public class CustomerServiceImplTest { 

@Autowired
private CustomerServiceImpl customerServiceImpl;

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: findCustomerList(Integer page, Integer rows, String custName, String custSource, String custIndustry, String custLevel) 
* 
*/ 
@Test
public void testFindCustomerList() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: getCustomerById(Long id) 
* 
*/ 
@Test
public void testGetCustomerById() throws Exception { 
//TODO: Test goes here...
    Long id=Long.valueOf(200);
    Customer cus=customerServiceImpl.getCustomerById(id);
    System.out.println(cus);
} 

/** 
* 
* Method: updateCustomer(Customer customer) 
* 
*/ 
@Test
public void testUpdateCustomer() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: deleteCustomer(Long id) 
* 
*/ 
@Test
public void testDeleteCustomer() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: insertCustomer(String cust_name, String cust_source, String cust_industry, String cust_level, String cust_linkman, String cust_phone, String cust_mobile, String cust_zipcode, String cust_address) 
* 
*/ 
@Test
public void testInsertCustomer() throws Exception { 
//TODO: Test goes here... 
} 


} 
