package com.alimm.tanx.core.ut;

/* loaded from: classes.dex */
public class BiddingBean extends com.alimm.tanx.core.ad.bean.BaseBean {
    private java.lang.String biddingPrice;
    private java.lang.String creative_id;
    private java.lang.String is_suc;
    private java.lang.String pid;
    private java.lang.String price;
    private java.lang.String reqId;
    private java.lang.String sessionId;
    private java.lang.String template_id;

    public java.lang.String getBiddingPrice() {
        return this.biddingPrice;
    }

    public java.lang.String getCreative_id() {
        return this.creative_id;
    }

    public java.lang.String getIs_suc() {
        return this.is_suc;
    }

    public java.lang.String getPid() {
        return this.pid;
    }

    public java.lang.String getPrice() {
        return this.price;
    }

    public java.lang.String getReqId() {
        return this.reqId;
    }

    public java.lang.String getSessionId() {
        return this.sessionId;
    }

    public java.lang.String getTemplate_id() {
        return this.template_id;
    }

    public void setBiddingPrice(java.lang.String str) {
        this.biddingPrice = str;
    }

    public void setCreative_id(java.lang.String str) {
        this.creative_id = str;
    }

    public void setIs_suc(java.lang.String str) {
        this.is_suc = str;
    }

    public void setPid(java.lang.String str) {
        this.pid = str;
    }

    public void setPrice(java.lang.String str) {
        this.price = str;
    }

    public void setReqId(java.lang.String str) {
        this.reqId = str;
    }

    public void setSessionId(java.lang.String str) {
        this.sessionId = str;
    }

    public void setTemplate_id(java.lang.String str) {
        this.template_id = str;
    }

    public java.lang.String toString() {
        return "BiddingBean{pid='" + this.pid + "', reqId='" + this.reqId + "', template_id='" + this.template_id + "', creative_id='" + this.creative_id + "', is_suc='" + this.is_suc + "', price='" + this.price + "', biddingPrice='" + this.biddingPrice + "', sessionId='" + this.sessionId + "'} " + super.toString();
    }
}
