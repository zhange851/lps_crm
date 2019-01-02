package com.core.service;

import com.core.bean.Customer;
import com.core.util.Page;

public interface CustomerService {

    // 查询客户列表
    public Page<Customer> findCustomerList(Integer page, Integer rows,
                                           String custName, String custSource, String custIndustry, String custLevel);

    public Customer getCustomerById(Long id);

    public void updateCustomer(Customer customer);

    public void deleteCustomer(Long id);

    public void insertCustomer(String cust_name, String cust_source, String cust_industry,
                               String cust_level, String cust_linkman, String cust_phone,
                               String cust_mobile, String cust_zipcode, String cust_address);
    public  void updateCustomerNew(String cust_id, String cust_name, String cust_source, String cust_industry,
                                   String cust_level, String cust_linkman, String cust_phone,
                                   String cust_mobile, String cust_zipcode, String cust_address);
}