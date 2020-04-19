package org.fkit.customer.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.fkit.customer.bean.Customer;
import org.fkit.customer.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Resource
    private CustomerService customerService;

    @RequestMapping("/findAll")
    public String findAll(Model model,
                          @RequestParam(required = false,defaultValue="1",value="pageNum")Integer pageNum,
                          @RequestParam(defaultValue="6",value="pageSize")Integer pageSize){

        //1.引入分页插件,pageNum是第几页，pageSize是每页显示多少条,默认查询总数count
        PageHelper.startPage(pageNum,pageSize);
        //2.紧跟的查询就是一个分页查询-必须紧跟.后面的其他查询不会被分页，除非再次调用PageHelper.startPage
        try {
            List<Customer> customers=customerService.findAll();
            System.out.println("分页数据："+customers);
            //3.使用PageInfo包装查询后的结果,5是连续显示的条数,结果list类型是Page<E>
            PageInfo<Customer> pageInfo = new PageInfo<Customer>(customers,pageSize);
            //4.使用model/map/modelandview等带回前端
            model.addAttribute("customers",customers);
            model.addAttribute("pageInfo",pageInfo);
            model.addAttribute("pageNum",pageInfo.getPageNum());
            model.addAttribute("pageSize",pageInfo.getPageSize());
            model.addAttribute("total",pageInfo.getTotal());
            model.addAttribute("pages",pageInfo.getPages());
            model.addAttribute("hasPreviousPage",pageInfo.isHasPreviousPage());
            model.addAttribute("firstPage",pageInfo.isIsFirstPage());
            model.addAttribute("lastPage",pageInfo.isIsLastPage());
            model.addAttribute("nextPage",pageInfo.isHasNextPage());
            model.addAttribute("prePage",pageInfo.getPrePage());
            model.addAttribute("startRow",pageInfo.getStartRow());
            model.addAttribute("endRow",pageInfo.getEndRow());
            model.addAttribute("navigatepageNums",pageInfo.getNavigatepageNums());
        }finally {
            PageHelper.clearPage(); //清理 ThreadLocal 存储的分页参数,保证线程安全
        }
        return "customer";
    }

    @RequestMapping("/findLike")
    public String findLike(String cust_name,String cust_industry,Model model){
        List<Customer> customers=customerService.findNameAndIndustry(cust_name,cust_industry);
        model.addAttribute("customers",customers);
        return "customer";
    }

    @RequestMapping("/insertCustomer")
    public String insertCustomer(Customer customer){
        int ok=customerService.insertCustomer(customer);
        if (ok>0){
            return "OK";
        }else{
            return "FALL";
        }
    }

    @RequestMapping("/editCustomer")
    @ResponseBody
    public Customer editCust(Integer cust_id){
        Customer customer=customerService.editCustomer(cust_id);
        return customer;
    }

    @RequestMapping("/updateCustomer")
    @ResponseBody
    public String updateCust(Customer customer){
        int ok=customerService.updateCustomer(customer);
        if (ok>0) {
            return "OK";
        }else {
            return "FALL";
        }
    }

    @RequestMapping("/deleteCustomer")
    @ResponseBody
    public String deleteCust(Integer cust_id){
        System.out.println(cust_id);
        int ok=customerService.deleteCustomer(cust_id);
        if (ok>0){
            return "OK";
        }else{
            return "FALL";
        }
    }
}
