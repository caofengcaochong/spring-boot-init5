package com.mengxuegu.springboot;


import com.mengxuegu.springboot.entities.Bill;
import com.mengxuegu.springboot.entities.BillProvider;
import com.mengxuegu.springboot.entities.Provider;
import com.mengxuegu.springboot.mapper.BillMapper;
import com.mengxuegu.springboot.mapper.ProviderMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootInit5ApplicationTests {

    @Autowired
    ProviderMapper providerMapper;
    @Autowired
    BillMapper billMapper;

    @Test
    public void contextLoads() {

//		providers.stream().forEach(System.out::print);
    }

    @Test
    public void test001() {
//	Provider provider = new Provider();
//	provider.setProviderName("B货");
//	List<Provider> providers = providerMapper.getProviders(provider);
//	System.out.println(providers.size()+provider.getProviderName());
//	providers.stream().forEach(System.out::print);
//	Provider provider1 = providerMapper.getProviderByPid(1);
//	System.out.println(provider1);
//	Provider provider = new Provider(null,"1223","341","1341","1341","1341","2342","fde");
//	providerMapper.addProvider(provider);
//	provider.setProviderName("nihao");
//	provider.setPid(17);
//	providerMapper.UpdateProvider(provider);
        providerMapper.deleteProviderByPid(17);
    }

    @Test
    public void testBill() {
//        BillProvider bill = billMapper.getBillByBid(1);
//        System.out.println(bill);

        billMapper.deleteBillByBid(7);
//        bill.setBillName("ESC包年云服务");
//        bill.setBillCode("13412");
//        bill.setBillCom("13412");
//        bill.setBillNum(1231);
//        bill.setMoney(5000.00);
//        bill.setPay(1);
//        bill.setPid(2);
//        List<BillProvider> bills = billMapper.getBills(bill);
//        bills.stream().forEach(System.out::print);

//        billMapper.addBill(bill);
    }

}
