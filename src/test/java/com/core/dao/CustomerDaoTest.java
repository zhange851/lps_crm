package com.core.dao;

import com.core.bean.Customer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext-dao.xml"})
public class CustomerDaoTest {

    @Resource
    private CustomerDao customerDao;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void selectCustomerList() {
    }

    @Test
    public void selectCustomerListCount() {
    }

    @Test
    public void getCustomerById() {
        Long id = Long.valueOf(200);
        Customer customer=customerDao.getCustomerById(id);
        System.out.println(customer);

    }

    @Test
    public void updateCustomer() {
    }

    @Test
    public void insertCustomer() {
    }

    @Test
    public void deleteCustomer() {
    }

    @Test
    public void updateCustomerNew() {
        customerDao.updateCustomerNew("200", "¿Ó≈‡Í…",null,null,null,null,
                "15922171985",null,null,null);
        Long id = Long.valueOf(200);
        Customer customer=customerDao.getCustomerById(id);
        System.out.println(customer);
    }
}