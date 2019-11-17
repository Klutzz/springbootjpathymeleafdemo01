package com.offcn.pay.Service.impl;

import com.offcn.pay.Service.PayService;

public class PayServiceImpl implements PayService {
    @Override
    public void weixinPay() {
        System.out.println("支付功能");
    }

    @Override
    public String queryStatus(String out_trade_no) {
        return "支付状态";
    }
}
