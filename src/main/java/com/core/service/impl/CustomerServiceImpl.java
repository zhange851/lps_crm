package com.core.service.impl;

import com.core.bean.Customer;
import com.core.dao.BaseDictDao;
import com.core.dao.CustomerDao;
import com.core.service.CustomerService;
import com.core.util.Page;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service("CustomerService")
@Transactional
public class CustomerServiceImpl implements CustomerService {
    // 定义dao属性
    @Autowired
    private CustomerDao customerDao;
    @Autowired
    private BaseDictDao baseDictDao;


    public Page<Customer> findCustomerList(Integer page, Integer rows,
                                           String custName, String custSource, String custIndustry, String custLevel) {
        Customer customer = new Customer();
        //判断客户名称(公司名称)
        if(StringUtils.isNotBlank(custName)){
            customer.setCust_name(custName);
        }
        //判断客户信息来源
        if(StringUtils.isNotBlank(custSource)){
            customer.setCust_source(custSource);
        }
        //判断客户所属行业
        if(StringUtils.isNotBlank(custIndustry)){
            customer.setCust_industry(custIndustry);
        }
        //判断客户级别
        if(StringUtils.isNotBlank(custLevel)){
            customer.setCust_level(custLevel);
        }
        //当前页
        customer.setStart((page-1) * rows) ;
        //每页数
        customer.setRows(rows);
        //查询客户列表
        List<Customer> customers = customerDao.selectCustomerList(customer);
        //查询客户列表总记录数
        Integer count = customerDao.selectCustomerListCount(customer);
        //创建Page返回对象
        Page<Customer> result = new Page<>();
        result.setPage(page);
        result.setRows(customers);
        result.setSize(rows);
        result.setTotal(count);
        return result;

    }
    public Customer getCustomerById(Long id) {

        Customer customer = customerDao.getCustomerById(id);
        return customer;

    }
    public void updateCustomer(Customer customer) {
        customerDao.updateCustomer(customer);

    }
    public void deleteCustomer(Long id) {
        customerDao.deleteCustomer(id);

    }
    public void insertCustomer(String cust_name, String cust_source, String cust_industry,
                               String cust_level, String cust_linkman, String cust_phone,
                               String cust_mobile, String cust_zipcode, String cust_address){
        customerDao.insertCustomer(cust_name, cust_source, cust_industry, cust_level, cust_linkman, cust_phone,
                cust_mobile, cust_zipcode, cust_address);
    }
    public  void updateCustomerNew(String cust_id, String cust_name, String cust_source, String cust_industry,
                                   String cust_level, String cust_linkman, String cust_phone,
                                   String cust_mobile, String cust_zipcode, String cust_address){
        customerDao.updateCustomerNew(cust_id, cust_name, cust_source, cust_industry, cust_level, cust_linkman, cust_phone, cust_mobile, cust_zipcode, cust_address);
    }
}
