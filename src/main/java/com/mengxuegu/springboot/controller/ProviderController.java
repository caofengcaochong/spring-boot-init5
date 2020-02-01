package com.mengxuegu.springboot.controller;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.mengxuegu.springboot.dao.ProviderDao;
import com.mengxuegu.springboot.entities.Provider;
import com.mengxuegu.springboot.mapper.ProviderMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;


import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@Controller
public class ProviderController {

    Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private ProviderDao providerDao;
    @Autowired
    private ProviderMapper providerMapper;
    @GetMapping("/providers")
    public String list(Map<String,Object> map,Provider provider){
        logger.info("provider has searched:"+provider.getProviderName());
//        Collection<Provider> providers = providerDao.getAll(providerName);
        List<Provider> providers = providerMapper.getProviders(provider);
        map.put("providers",providers);
        map.put("providerName",provider.getProviderName());
        return "provider/list";
    }

    @GetMapping("/provider/{pid}")
    public String view(@PathVariable("pid") Integer pid,@RequestParam(value = "type",defaultValue = "view")String type, Map<String,Object> map){
//        Provider provider = providerDao.getProvider(pid);
        Provider provider= providerMapper.getProviderByPid(pid);
        map.put("provider",provider);
       // return "provider/view";
        return "provider/"+type;
    }

    @PutMapping("/provider")
    public String update(Provider provider){
        logger.info("修改信息");
//        providerDao.save(provider);
        providerMapper.UpdateProvider(provider);
        return "redirect:/providers";
    }

//    @Transactional
    @GetMapping("/provider")
    public String toAddPage() {
        return "provider/add";
    }

    @PostMapping("/provider")
    public String add(Provider provider) {
        logger.info("新增");
        System.out.println("nihao");
//        providerDao.save(provider);
        providerMapper.addProvider(provider);
        return "redirect:/providers";
    }


    @DeleteMapping("/provider/{pid}")
    public String delete(@PathVariable("pid")Integer pid){
        logger.info("删除:pid"+pid);
//        providerDao.delete(pid);
        providerMapper.deleteProviderByPid(pid);
        return "redirect:/providers";
    }
}
