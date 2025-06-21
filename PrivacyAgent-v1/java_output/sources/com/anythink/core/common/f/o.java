package com.anythink.core.common.f;

/* loaded from: classes12.dex */
public class o {
    public com.anythink.core.api.ATBiddingNotice biddingNotice;
    public com.anythink.core.api.ATAdConst.CURRENCY currency;
    public java.lang.String displayNoticeUrl;
    public java.lang.String errorMsg;
    protected boolean isSuccess;
    public java.lang.String loseNoticeUrl;
    public double originPrice;
    protected double price;
    protected double sortPrice;
    public java.lang.String token;
    public int useType;
    public java.lang.String winNoticeUrl;

    public o(boolean z, double d, double d2, java.lang.String str, com.anythink.core.api.ATBiddingNotice aTBiddingNotice, java.lang.String str2, com.anythink.core.api.ATAdConst.CURRENCY currency) {
        this(z, d2, str, aTBiddingNotice, str2, currency);
        this.sortPrice = d;
    }

    public o(boolean z, double d, java.lang.String str, com.anythink.core.api.ATBiddingNotice aTBiddingNotice, java.lang.String str2, com.anythink.core.api.ATAdConst.CURRENCY currency) {
        this.useType = 1;
        this.isSuccess = z;
        this.originPrice = d;
        this.price = d;
        this.sortPrice = d;
        this.token = str;
        this.biddingNotice = aTBiddingNotice;
        this.errorMsg = str2;
        this.currency = currency;
    }

    public o(boolean z, double d, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, com.anythink.core.api.ATAdConst.CURRENCY currency) {
        this.useType = 1;
        this.isSuccess = z;
        this.originPrice = d;
        this.price = d;
        this.sortPrice = d;
        this.token = str;
        this.winNoticeUrl = str2;
        this.loseNoticeUrl = str3;
        this.displayNoticeUrl = str4;
        this.errorMsg = str5;
        this.currency = currency;
    }

    public double getPrice() {
        return this.price;
    }

    public double getSortPrice() {
        return this.sortPrice;
    }

    public boolean isSamePrice() {
        return this.sortPrice == this.originPrice;
    }

    public boolean isSuccessWithUseType() {
        return this.isSuccess && this.useType == 1;
    }

    public void setBiddingNotice(com.anythink.core.api.ATBiddingNotice aTBiddingNotice) {
        this.biddingNotice = aTBiddingNotice;
    }

    public void setPrice(double d) {
        this.price = d;
    }

    public void setSortPrice(double d) {
        this.sortPrice = d;
    }
}
