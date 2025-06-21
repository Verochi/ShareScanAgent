package com.alimm.tanx.core.ad.bean;

/* loaded from: classes.dex */
public class MediaRenderingMode extends com.alimm.tanx.core.ad.bean.BaseBean {

    @com.alibaba.fastjson.annotation.JSONField(name = "ad_color")
    private java.lang.String adColor;

    @com.alibaba.fastjson.annotation.JSONField(name = "ad_size")
    private java.lang.String adSize;

    @com.alibaba.fastjson.annotation.JSONField(name = "adv_color")
    private java.lang.String advColor;

    @com.alibaba.fastjson.annotation.JSONField(name = "adv_size")
    private java.lang.String advSize;

    @com.alibaba.fastjson.annotation.JSONField(name = "bg_color")
    private java.lang.String bgColor;

    @com.alibaba.fastjson.annotation.JSONField(name = "pic_radius")
    private java.lang.String picRadius;

    @com.alibaba.fastjson.annotation.JSONField(serialize = false)
    private java.lang.String serverTitleSize;

    @com.alibaba.fastjson.annotation.JSONField(name = "title_color")
    private java.lang.String titleColor;

    @com.alibaba.fastjson.annotation.JSONField(name = "title_size")
    private java.lang.String titleSize;

    public MediaRenderingMode() {
    }

    public MediaRenderingMode(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, java.lang.String str6, java.lang.String str7, java.lang.String str8) {
        this.titleSize = str;
        this.titleColor = str2;
        this.adSize = str3;
        this.adColor = str4;
        this.advSize = str5;
        this.advColor = str6;
        this.bgColor = str7;
        this.picRadius = str8;
    }

    private int dp2px(android.content.Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public java.lang.String getAdColor() {
        return this.adColor;
    }

    public java.lang.String getAdSize() {
        return this.adSize;
    }

    public int getAdSize2Int() {
        try {
            return !android.text.TextUtils.isEmpty(this.adSize) ? java.lang.Integer.parseInt(this.adSize) : java.lang.Integer.parseInt("5");
        } catch (java.lang.Exception e) {
            com.alimm.tanx.core.utils.LogUtils.e(e);
            return -1;
        }
    }

    public java.lang.String getAdvColor() {
        return this.advColor;
    }

    public java.lang.String getAdvSize() {
        return this.advSize;
    }

    public int getAdvSize2Int() {
        try {
            return !android.text.TextUtils.isEmpty(this.advSize) ? java.lang.Integer.parseInt(this.advSize) : java.lang.Integer.parseInt("5");
        } catch (java.lang.Exception e) {
            com.alimm.tanx.core.utils.LogUtils.e(e);
            return -1;
        }
    }

    public java.lang.String getBgColor() {
        return this.bgColor;
    }

    public java.lang.String getPicRadius() {
        return this.picRadius;
    }

    public int getPicRadius2Int(android.content.Context context) {
        int i = -1;
        try {
            i = java.lang.Integer.parseInt("4");
            if (!android.text.TextUtils.isEmpty(this.picRadius)) {
                i = java.lang.Integer.parseInt(this.picRadius);
            }
            return dp2px(context, i);
        } catch (java.lang.Exception e) {
            com.alimm.tanx.core.utils.LogUtils.e(e);
            return i;
        }
    }

    public java.lang.String getServerTitleSize() {
        return this.serverTitleSize;
    }

    public java.lang.String getTitleColor() {
        return this.titleColor;
    }

    public java.lang.String getTitleSize() {
        return this.titleSize;
    }

    public int getTitleSize2Int() {
        try {
            return !android.text.TextUtils.isEmpty(this.titleSize) ? java.lang.Integer.parseInt(this.titleSize) : java.lang.Integer.parseInt("8");
        } catch (java.lang.Exception e) {
            com.alimm.tanx.core.utils.LogUtils.e(e);
            return -1;
        }
    }

    public void setAdColor(java.lang.String str) {
        this.adColor = str;
    }

    public void setAdSize(java.lang.String str) {
        this.adSize = str;
    }

    public void setAdvColor(java.lang.String str) {
        this.advColor = str;
    }

    public void setAdvSize(java.lang.String str) {
        this.advSize = str;
    }

    public void setBgColor(java.lang.String str) {
        this.bgColor = str;
    }

    public void setPicRadius(java.lang.String str) {
        this.picRadius = str;
    }

    public void setServerTitleSize(java.lang.String str) {
        this.serverTitleSize = str;
    }

    public void setTitleColor(java.lang.String str) {
        this.titleColor = str;
    }

    public void setTitleSize(java.lang.String str) {
        this.titleSize = str;
    }

    public java.lang.String toString() {
        return "MediaRenderingMode{titleSize='" + this.titleSize + "', serverTitleSize='" + this.serverTitleSize + "', titleColor='" + this.titleColor + "', adSize='" + this.adSize + "', adColor='" + this.adColor + "', advSize='" + this.advSize + "', advColor='" + this.advColor + "', bgColor='" + this.bgColor + "', picRadius='" + this.picRadius + "'} " + super.toString();
    }
}
