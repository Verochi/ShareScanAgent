package com.alimm.tanx.core.net.bean;

/* loaded from: classes.dex */
public class RequestBean extends com.alimm.tanx.core.ad.bean.BaseBean {
    private int cacheOfflineTime;
    private int cacheOnlineTime;
    private java.util.Map<java.lang.String, java.lang.String> heads;
    private java.lang.String json;
    private boolean onlyOneNet;
    private boolean overrideError;
    private java.util.Map<java.lang.String, java.lang.String> params;
    private java.lang.String tag;
    private int tryAgainCount;
    private java.lang.String url;

    public static class Builder implements com.alimm.tanx.core.utils.NotConfused {
        private java.lang.String tag;
        private final boolean onlyOneNet = false;
        private final int tryAgainCount = 3;
        private final int cacheOfflineTime = 0;
        private final int cacheOnlineTime = 0;
        private final boolean overrideError = false;
    }

    public com.alimm.tanx.core.net.bean.RequestBean build() {
        com.alimm.tanx.core.net.bean.RequestBean.Builder builder = new com.alimm.tanx.core.net.bean.RequestBean.Builder();
        this.cacheOfflineTime = builder.cacheOfflineTime;
        this.onlyOneNet = builder.onlyOneNet;
        this.cacheOfflineTime = builder.cacheOfflineTime;
        this.cacheOnlineTime = builder.cacheOnlineTime;
        this.overrideError = builder.overrideError;
        return this;
    }

    public int getCacheOfflineTime() {
        return this.cacheOfflineTime;
    }

    public int getCacheOnlineTime() {
        return this.cacheOnlineTime;
    }

    public java.util.Map<java.lang.String, java.lang.String> getHeads() {
        return this.heads;
    }

    public java.lang.String getJson() {
        return this.json;
    }

    public java.util.Map<java.lang.String, java.lang.String> getParams() {
        return this.params;
    }

    public java.lang.String getTag() {
        return this.tag;
    }

    public int getTryAgainCount() {
        return this.tryAgainCount;
    }

    public java.lang.String getUrl() {
        return this.url;
    }

    public boolean isOnlyOneNet() {
        return this.onlyOneNet;
    }

    public boolean isOverrideError() {
        return this.overrideError;
    }

    public com.alimm.tanx.core.net.bean.RequestBean setCacheOfflineTime(int i) {
        this.cacheOfflineTime = i;
        return this;
    }

    public com.alimm.tanx.core.net.bean.RequestBean setCacheOnlineTime(int i) {
        this.cacheOnlineTime = i;
        return this;
    }

    public com.alimm.tanx.core.net.bean.RequestBean setHeads(java.util.Map<java.lang.String, java.lang.String> map) {
        this.heads = map;
        return this;
    }

    public void setJson(java.lang.String str) {
        this.json = str;
    }

    public com.alimm.tanx.core.net.bean.RequestBean setOnlyOneNet(boolean z) {
        this.onlyOneNet = z;
        return this;
    }

    public com.alimm.tanx.core.net.bean.RequestBean setOverrideError(boolean z) {
        this.overrideError = z;
        return this;
    }

    public com.alimm.tanx.core.net.bean.RequestBean setParams(java.util.Map<java.lang.String, java.lang.String> map) {
        this.params = map;
        return this;
    }

    public com.alimm.tanx.core.net.bean.RequestBean setTag(java.lang.String str) {
        this.tag = str;
        return this;
    }

    public com.alimm.tanx.core.net.bean.RequestBean setTryAgainCount(int i) {
        this.tryAgainCount = i;
        return this;
    }

    public com.alimm.tanx.core.net.bean.RequestBean setUrl(java.lang.String str) {
        this.url = str;
        return this;
    }

    public java.lang.String toString() {
        return "RequestBean{url='" + this.url + "', heads=" + this.heads + ", params=" + this.params + ", tag='" + this.tag + "', cacheOfflineTime=" + this.cacheOfflineTime + ", cacheOnlineTime=" + this.cacheOnlineTime + ", onlyOneNet=" + this.onlyOneNet + ", tryAgainCount=" + this.tryAgainCount + ", overrideError=" + this.overrideError + ", json='" + this.json + "'} ";
    }
}
