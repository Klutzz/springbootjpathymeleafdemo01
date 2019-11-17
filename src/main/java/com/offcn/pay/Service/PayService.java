package com.offcn.pay.Service;

public interface PayService {

    public void weixinPay();

    public String queryStatus(String out_trade_no);
}
