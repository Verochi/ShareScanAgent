package com.alimm.tanx.ui.request;

/* loaded from: classes.dex */
public class NewAdRequestBean extends com.alimm.tanx.core.ad.bean.BaseBean {
    public com.alimm.tanx.ui.request.NewAdRequestBean.AdAppBean app;
    public com.alimm.tanx.ui.request.NewAdRequestBean.AdContentBean content;
    public com.alimm.tanx.ui.request.NewAdRequestBean.AdDeviceBean device;
    public boolean https_required;
    public java.lang.String id;
    public java.util.List<com.alimm.tanx.ui.request.NewAdRequestBean.AdImpBean> imp;
    public int render_type;
    public int version;

    public static class AdAppBean extends com.alimm.tanx.core.ad.bean.BaseBean {
        public java.lang.String app_name;
        public java.lang.String app_version;
        public java.lang.String package_name;
        public java.lang.String sdk_version;
    }

    public static class AdContentBean extends com.alimm.tanx.core.ad.bean.BaseBean {
        public java.util.List<java.lang.String> category;
        public java.util.List<java.lang.String> keywords;
        public java.util.List<java.lang.String> query_term;
        public java.util.List<java.lang.String> suggestion;
        public java.lang.String title;
    }

    public static class AdDeviceBean extends com.alimm.tanx.core.ad.bean.BaseBean {
        public java.lang.String ali_aaid;
        public java.lang.String android_id;
        public java.lang.String brand;
        public java.lang.String clientId;
        public int device_type;
        public com.alimm.tanx.ui.request.NewAdRequestBean.AdGeoBean geo;
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

    public static class AdGeoBean extends com.alimm.tanx.core.ad.bean.BaseBean {
        public double lat;
        public double lon;
    }

    public static class AdImpBean extends com.alimm.tanx.core.ad.bean.BaseBean {
        public java.lang.String id;
        public java.lang.String[] native_template_id;
        public java.lang.String pid;
        public int pos;
        public int slot_num;
    }
}
