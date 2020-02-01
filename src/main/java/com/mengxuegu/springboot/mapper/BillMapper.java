package com.mengxuegu.springboot.mapper;


import com.mengxuegu.springboot.entities.Bill;
import com.mengxuegu.springboot.entities.BillProvider;
import com.mengxuegu.springboot.entities.Provider;

import java.util.List;

public interface BillMapper {

    List<BillProvider> getBills(Bill bill);
    BillProvider getBillByBid(Integer bid);
    int addBill(Bill bill);
    int updateBill(Bill bill);
    int deleteBillByBid(Integer bid);
}
