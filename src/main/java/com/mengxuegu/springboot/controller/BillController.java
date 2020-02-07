package com.mengxuegu.springboot.controller;

import com.mengxuegu.springboot.dao.ProviderDao;
import com.mengxuegu.springboot.entities.Bill;
import com.mengxuegu.springboot.entities.BillProvider;
import com.mengxuegu.springboot.entities.Provider;
import com.mengxuegu.springboot.mapper.BillMapper;
import com.mengxuegu.springboot.mapper.ProviderMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
public class BillController {

    Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private ProviderDao providerDao;
    @Autowired
    private ProviderMapper providerMapper;
    @Autowired
    private BillMapper billMapper;
    @GetMapping("/bills")
    public String list(Map<String,Object> map,Bill bill){
        logger.info("provider has searched:"+bill.getBillName());
        System.out.println("nihao");
//        Collection<Provider> providers = providerDao.getAll(providerName);
//        List<Provider> providers = providerMapper.getProviders(provider);
        List<BillProvider> billProviders = billMapper.getBills(bill);
        map.put("billProviders",billProviders);
        map.put("billName",bill.getBillName());
        map.put("pid",bill.getPid());
        map.put("pay",bill.getPay());
        map.put("providers",providerMapper.getProviders(null));
        return "bill/list";
    }

    @GetMapping("/bill/{bid}")
    public String view(@PathVariable("bid") Integer bid,@RequestParam(value = "type",defaultValue = "view")String type, Map<String,Object> map){
//        Provider provider = providerDao.getProvider(pid);
//        Provider provider= providerMapper.getProviderByPid(pid);
        if("update".equals(type)) {
            map.put("providers",providerMapper.getProviders(null));
        }
        BillProvider billProvider= billMapper.getBillByBid(bid);
        map.put("billProvider",billProvider);
       // return "provider/view";
        return "bill/"+type;
    }

    @PutMapping("/bill")
    public String update(Bill bill){
        logger.info("修改信息");
//        providerDao.save(provider);
//        providerMapper.UpdateProvider(provider);
        billMapper.updateBill(bill);
        return "redirect:/bills";
    }


    @GetMapping("/bill")
    public String toAddPage(Map<String,Object> map)
    {
        map.put("providers",providerMapper.getProviders(null));
        return "bill/add";
    }

    @PostMapping("/bill")
    public String add(Bill bill) {
        logger.info("新增");
//        providerMapper.addProvider(provider);
        billMapper.addBill(bill);
        return "redirect:/bills";
    }


    @DeleteMapping("/bill/{bid}")
    public String delete(@PathVariable("bid")Integer bid){
        logger.info("删除:pid"+bid);
//        providerDao.delete(pid);
//        providerMapper.deleteProviderByPid(pid);
        billMapper.deleteBillByBid(bid);
        return "redirect:/bills";
    }
}
