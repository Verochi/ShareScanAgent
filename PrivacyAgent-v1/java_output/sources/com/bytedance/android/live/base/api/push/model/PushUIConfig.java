package com.bytedance.android.live.base.api.push.model;

/* loaded from: classes.dex */
public class PushUIConfig {
    public static final long dismissTime = 5000;
    private java.lang.Integer horizontalMargin = null;
    private java.lang.Integer topMargin = null;
    private java.lang.Integer textColor = null;
    private java.lang.Integer liveColor = null;
    private java.lang.Float borderRadiusWidth = null;
    private java.lang.Integer bgColor = null;

    public java.lang.Integer getBgColor() {
        return this.bgColor;
    }

    public java.lang.Float getBorderRadiusWidth() {
        return this.borderRadiusWidth;
    }

    public java.lang.Integer getHorizontalMargin() {
        return this.horizontalMargin;
    }

    public java.lang.Integer getLiveColor() {
        return this.liveColor;
    }

    public java.lang.Integer getTextColor() {
        return this.textColor;
    }

    public java.lang.Integer getTopMargin() {
        return this.topMargin;
    }

    public void setBgColor(java.lang.Integer num) {
        this.bgColor = num;
    }

    public void setBorderRadiusWidth(java.lang.Float f) {
        this.borderRadiusWidth = f;
    }

    public void setHorizontalMargin(java.lang.Integer num) {
        this.horizontalMargin = num;
    }

    public void setLiveColor(java.lang.Integer num) {
        this.liveColor = num;
    }

    public void setTextColor(java.lang.Integer num) {
        this.textColor = num;
    }

    public void setTopMargin(java.lang.Integer num) {
        this.topMargin = num;
    }
}
