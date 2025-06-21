package com.aliyun.common.whitelist;

/* loaded from: classes.dex */
public class WhiteItem {
    private java.lang.String mDevice;
    private com.aliyun.common.whitelist.PropertyValueExchanger mPropertyValueExchanger = new com.aliyun.common.whitelist.PropertyValueExchanger();

    public WhiteItem(java.lang.String str) {
        this.mDevice = str;
    }

    public java.lang.String getDevice() {
        return this.mDevice;
    }

    public com.aliyun.common.whitelist.PropertyValueExchanger getPropertyValueExchanger() {
        return this.mPropertyValueExchanger;
    }

    public void setDevice(java.lang.String str) {
        this.mDevice = str;
    }

    public void setPropertyValueExchanger(com.aliyun.common.whitelist.PropertyValueExchanger propertyValueExchanger) {
        this.mPropertyValueExchanger = propertyValueExchanger;
    }
}
