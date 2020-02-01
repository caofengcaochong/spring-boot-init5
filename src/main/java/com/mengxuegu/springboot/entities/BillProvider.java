package com.mengxuegu.springboot.entities;

public class BillProvider extends Bill {
    private String ProviderName;

    public String getProviderName() {
        return ProviderName;
    }

    public void setProviderName(String providerName) {
        ProviderName = providerName;
    }

    @Override
    public String toString() {
        return "BillProvider{" +
                "ProviderName='" + ProviderName + '\'' + " "+super.toString()+
                '}';
    }
}
