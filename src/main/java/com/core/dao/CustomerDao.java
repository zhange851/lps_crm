package com.core.dao;

import com.core.bean.Customer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustomerDao {

    List<Customer> selectCustomerList(Customer customer);
    Integer selectCustomerListCount(Customer customer);
    Customer getCustomerById(Long id);
    void updateCustomer(Customer customer);
    void insertCustomer(@Param("cust_name")String cust_name, @Param("cust_source")String cust_source, @Param("cust_industry")String cust_industry,
                        @Param("cust_level")String cust_level, @Param("cust_linkman")String cust_linkman, @Param("cust_phone")String cust_phone,
                        @Param("cust_mobile")String cust_mobile, @Param("cust_zipcode")String cust_zipcode, @Param("cust_address")String cust_address);
    void updateCustomerNew(@Param("cust_id") String cust_id, @Param("cust_name")String cust_name, @Param("cust_source")String cust_source, @Param("cust_industry")String cust_industry,
                           @Param("cust_level")String cust_level, @Param("cust_linkman")String cust_linkman, @Param("cust_phone")String cust_phone,
                           @Param("cust_mobile")String cust_mobile, @Param("cust_zipcode")String cust_zipcode, @Param("cust_address")String cust_address);
    void deleteCustomer(Long id);

}