package com.mengxuegu.springboot.entities;

import java.util.Date;

/**
 * 供应商实体类
 * @Title: ProviderMapper
 * @Description: com.mengxuegu.springboot.entities
 * @Auther: www.mengxuegu.com
 * @Version: 1.0
 */

public class Provider {
    private Integer pid;
    //供应商编码
    private String providerCode;
    //供应商名称
    private String providerName;
    //联系人
    private String people;
    //联系电话
    private String phone;
    //联系地址
    private String address;
    //传真
    private String fax;
    //描述
    private String describes;
    // 创建时间
    private Date createDate;

    public Provider() {
    }

    public Provider(Integer pid, String providerCode, String providerName, String people, String phone, String address, String fax, String describes) {
        this.pid = pid;
        this.providerCode = providerCode;
        this.providerName = providerName;
        this.people = people;
        this.phone = phone;
        this.address = address;
        this.fax = fax;
        this.describes = describes;
        this.createDate = new Date();
    }

    @Override
    public String toString() {
        return "ProviderMapper{" +
                "pid=" + pid +
                ", providerCode='" + providerCode + '\'' +
                ", providerName='" + providerName + '\'' +
                ", people='" + people + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", fax='" + fax + '\'' +
                ", describe='" + describes + '\'' +
                ", createDate=" + createDate +
                '}';
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getProviderCode() {
        return providerCode;
    }

    public void setProviderCode(String providerCode) {
        this.providerCode = providerCode;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public String getPeople() {
        return people;
    }

    public void setPeople(String people) {
        this.people = people;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getDescribes() {
        return describes;
    }

    public void setDescribes(String describes) {
        this.describes = describes;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date date) {
        this.createDate = date;
    }
}
