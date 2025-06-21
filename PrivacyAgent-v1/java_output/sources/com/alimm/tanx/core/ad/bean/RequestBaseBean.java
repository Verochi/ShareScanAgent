package com.alimm.tanx.core.ad.bean;

/* loaded from: classes.dex */
public class RequestBaseBean extends com.alimm.tanx.core.ad.bean.BaseBean {
    public com.alimm.tanx.core.ad.bean.RequestBaseBean.AdAppBean app;
    public com.alimm.tanx.core.ad.bean.RequestBaseBean.AdDeviceBean device;
    public java.lang.String id;

    public static class AdAppBean extends com.alimm.tanx.core.ad.bean.BaseBean {
        public java.lang.String app_name;
        public java.lang.String app_version;
        public java.lang.String package_name;
        public java.lang.String sdk_version;
    }

    public static class AdDeviceBean extends com.alimm.tanx.core.ad.bean.BaseBean {
        public java.lang.String ali_aaid;
        public java.lang.String android_id;
        public java.lang.String brand;
        public java.lang.String clientId;
        public int device_type;
        public java.lang.String guid;
        public int height;
        public java.lang.String imei;
        public java.util.List<java.lang.String> installed_app;
        public java.lang.String model;
        public int network;
        public java.lang.String oaid;
        public int operator;
        public int orientation;
        public java.lang.String os;
        public java.lang.String osv;
        public int pixel_ratio;
        public java.lang.String pseudoId;
        public java.lang.String user_agent;
        public java.lang.String widevineId;
        public int width;
    }
}
