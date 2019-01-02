package com.core.controller;

import com.core.bean.BaseDict;
import com.core.bean.Customer;
import com.core.service.CustomerService;
import com.core.service.SystemService;
import com.core.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;

import java.util.List;

@Controller
public class CustomerController {
    // 依赖注入
    @Autowired
    private CustomerService customerService;
    @Autowired
    private SystemService systemService;
    @Value("${customer.from.type}")
    private String FROM_TYPE;
    @Value("${customer.industry.type}")
    private String INDUSTRY_TYPE;
    @Value("${customer.level.type}")
    private String LEVEL_TYPE;

    @RequestMapping(value = "/customer")
    public String showCumtomer() {
        return "redirect:/customer/list.do";
        //return "Customer";
    }

    // 客户列表
    @RequestMapping(value = "/customer/list")
    public String list(@RequestParam(defaultValue="1")Integer page, @RequestParam(defaultValue="10")Integer rows,
                       String custName, String custSource, String custIndustry, String custLevel, Model model) {

        Page<Customer> customers = customerService.findCustomerList(page, rows, custName, custSource, custIndustry,
                custLevel);
        model.addAttribute("page", customers);
        //客户来源
        List<BaseDict> fromType = systemService.findBaseDictListByType(FROM_TYPE);
        //客户所属行业
        List<BaseDict> industryType = systemService.findBaseDictListByType(INDUSTRY_TYPE);
        //客户级别
        List<BaseDict> levelType = systemService.findBaseDictListByType(LEVEL_TYPE);
        model.addAttribute("fromType", fromType);
        model.addAttribute("industryType", industryType);
        model.addAttribute("levelType", levelType);
        //参数回显
        model.addAttribute("custName", custName);
        model.addAttribute("custSource", custSource);
        model.addAttribute("custIndustry", custIndustry);
        model.addAttribute("custLevel", custLevel);
        return "Customer";
    }

    @RequestMapping("/customer/edit")
    public String getCustomerById(String custId, Model model) {
        Long id=Long.valueOf(custId);
        Customer customer = customerService.getCustomerById(id);
        //客户来源
        List<BaseDict> fromType = systemService.findBaseDictListByType(FROM_TYPE);
        //客户所属行业
        List<BaseDict> industryType = systemService.findBaseDictListByType(INDUSTRY_TYPE);
        //客户级别
        List<BaseDict> levelType = systemService.findBaseDictListByType(LEVEL_TYPE);
        model.addAttribute("fromType", fromType);
        model.addAttribute("industryType", industryType);
        model.addAttribute("levelType", levelType);
        if(id == 0)
            return "New";
        else{
            model.addAttribute("custCell", customer);
            return "Edit";
        }
    }

    @RequestMapping("/customer/edit_tan")
    @ResponseBody
    public Customer getCustomerByIdTan(String custId){
        Long id = Long.valueOf(custId);
        Customer customer = customerService.getCustomerById(id);
        return customer;
    }

    @RequestMapping("/customer/query")
    public String queryCustomerById(String custId, Model model){
        Long id=Long.valueOf(custId);
        Customer customer= customerService.getCustomerById(id);
        model.addAttribute("custCell", customer);
        return "Query";
    }

    @RequestMapping("/customer/update")
    @ResponseBody
    public String customerUpdate(Customer customer) {
        customerService.updateCustomer(customer);
        return "OK";
    }
    @RequestMapping("/customer/delete")
    @ResponseBody
    public String customerDelete(Long id) {
        customerService.deleteCustomer(id);
        return "OK";
    }
    @RequestMapping("/customer/insert")
    public String customerInsert(String cust_name, String cust_source, String cust_industry,
                                 String cust_level, String cust_linkman, String cust_phone,
                                 String cust_mobile, String cust_zipcode, String cust_address){
        customerService.insertCustomer(cust_name, cust_source, cust_industry, cust_level, cust_linkman, cust_phone, cust_mobile,
                cust_zipcode, cust_address);
        return "redirect:/customer/list.do";
    }

    @RequestMapping("/customer/insert_tan")
    @ResponseBody
    public String customerInsertTan(String cust_name, String cust_source, String cust_industry,
                                 String cust_level, String cust_linkman, String cust_phone,
                                 String cust_mobile, String cust_zipcode, String cust_address){
        customerService.insertCustomer(cust_name, cust_source, cust_industry, cust_level, cust_linkman, cust_phone, cust_mobile,
                cust_zipcode, cust_address);
        return "OK";
    }

    @RequestMapping("/customer/updateNew")
    public String customerUpdateNew(String cust_id, String cust_name, String cust_source, String cust_industry,
                                    String cust_level, String cust_linkman, String cust_phone,
                                    String cust_mobile, String cust_zipcode, String cust_address){
        customerService.updateCustomerNew(cust_id, cust_name, cust_source, cust_industry, cust_level, cust_linkman, cust_phone, cust_mobile,
                cust_zipcode, cust_address);
        return  "redirect:/customer/list.do";
    }
}
