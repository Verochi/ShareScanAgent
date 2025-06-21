package com.anythink.core.api;

/* loaded from: classes12.dex */
public class AdError {
    protected java.lang.String code;
    protected java.lang.String desc;
    protected java.lang.String itemsErrorInfo = "";
    protected java.lang.String platformCode;
    protected java.lang.String platformMSG;

    public AdError(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        this.code = str;
        this.desc = str2;
        this.platformCode = str3;
        this.platformMSG = str4;
    }

    public java.lang.String getCode() {
        return this.code;
    }

    public java.lang.String getDesc() {
        return this.desc;
    }

    public java.lang.String getFullErrorInfo() {
        if (!android.text.TextUtils.isEmpty(this.itemsErrorInfo)) {
            return "\ncode[ " + this.code + " ]\ndesc[ " + this.desc + " ]\ndetail[ " + this.itemsErrorInfo + " \n]";
        }
        return "code:[ " + this.code + " ]desc:[ " + this.desc + " ]platformCode:[ " + this.platformCode + " ]platformMSG:[ " + this.platformMSG + " ]";
    }

    public java.lang.String getPlatformCode() {
        return this.platformCode;
    }

    public java.lang.String getPlatformMSG() {
        return this.platformMSG;
    }

    public java.lang.String printStackTrace() {
        return "code:[ " + this.code + " ]desc:[ " + this.desc + " ]platformCode:[ " + this.platformCode + " ]platformMSG:[ " + this.platformMSG + " ]";
    }

    public void putNetworkErrorMsg(java.lang.String str, int i, java.lang.String str2, com.anythink.core.api.AdError adError) {
        this.platformCode = adError.platformCode;
        this.platformMSG = adError.platformMSG;
        this.itemsErrorInfo += "\n  { ad_source_id[ " + str + " ];network_firm_id[ " + i + " ];network_name=[ " + str2 + " ];network_error:[ " + adError.printStackTrace() + " ] }";
    }

    public java.lang.String toString() {
        return printStackTrace();
    }
}
