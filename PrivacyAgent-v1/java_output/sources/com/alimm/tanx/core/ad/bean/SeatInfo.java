package com.alimm.tanx.core.ad.bean;

/* loaded from: classes.dex */
public class SeatInfo extends com.alimm.tanx.core.ad.bean.BaseBean {

    @com.alibaba.fastjson.annotation.JSONField(serialize = false)
    private java.util.List<com.alimm.tanx.core.ad.bean.BidInfo> bidList;

    @com.alibaba.fastjson.annotation.JSONField(name = "id")
    private int id;

    @com.alibaba.fastjson.annotation.JSONField(name = com.umeng.analytics.pro.bo.aC)
    private java.util.List<java.lang.String> rawBidList;

    public java.util.List<com.alimm.tanx.core.ad.bean.BidInfo> getBidList() {
        return java.util.Collections.synchronizedList(this.bidList);
    }

    public int getId() {
        return this.id;
    }

    public java.util.List<java.lang.String> getRawBidList() {
        return this.rawBidList;
    }

    public com.alimm.tanx.core.ad.bean.SeatInfo setBidList(java.util.List<com.alimm.tanx.core.ad.bean.BidInfo> list) {
        this.bidList = list;
        return this;
    }

    public void setId(int i) {
        this.id = i;
    }

    public void setRawBidList(java.util.List<java.lang.String> list) {
        this.rawBidList = list;
    }
}
