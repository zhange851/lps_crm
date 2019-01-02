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
    // ����dao����
    @Autowired
    private CustomerDao customerDao;
    @Autowired
    private BaseDictDao baseDictDao;


    public Page<Customer> findCustomerList(Integer page, Integer rows,
                                           String custName, String custSource, String custIndustry, String custLevel) {
        Customer customer = new Customer();
        //�жϿͻ�����(��˾����)
        if(StringUtils.isNotBlank(custName)){
            customer.setCust_name(custName);
        }
        //�жϿͻ���Ϣ��Դ
        if(StringUtils.isNotBlank(custSource)){
            customer.setCust_source(custSource);
        }
        //�жϿͻ�������ҵ
        if(StringUtils.isNotBlank(custIndustry)){
            customer.setCust_industry(custIndustry);
        }
        //�жϿͻ�����
        if(StringUtils.isNotBlank(custLevel)){
            customer.setCust_level(custLevel);
        }
        //��ǰҳ
        customer.setStart((page-1) * rows) ;
        //ÿҳ��
        customer.setRows(rows);
        //��ѯ�ͻ��б�
        List<Customer> customers = customerDao.selectCustomerList(customer);
        //��ѯ�ͻ��б��ܼ�¼��
        Integer count = customerDao.selectCustomerListCount(customer);
        //����Page���ض���
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
