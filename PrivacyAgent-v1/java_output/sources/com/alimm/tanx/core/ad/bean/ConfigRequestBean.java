package com.alimm.tanx.core.ad.bean;

/* loaded from: classes.dex */
public class ConfigRequestBean extends com.alimm.tanx.core.ad.bean.RequestBaseBean {
    private java.lang.Long config_id;
    public com.alimm.tanx.core.ad.bean.ConfigRequestBean.AdDeviceBean device;
    public java.lang.String ext = "";
    public java.lang.String md5_app_key;
    public java.lang.String req_Id;
    public com.alimm.tanx.core.ad.bean.ConfigRequestBean.AdUserBean user;
    private java.lang.Long version;

    public static class AdDeviceBean extends com.alimm.tanx.core.ad.bean.RequestBaseBean.AdDeviceBean {
        public java.lang.Integer os;
    }

    public static class AdUserBean extends com.alimm.tanx.core.ad.bean.BaseBean {
        public java.lang.String app_key;
    }
}
