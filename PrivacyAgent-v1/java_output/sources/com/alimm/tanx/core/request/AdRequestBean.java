package com.alimm.tanx.core.request;

/* loaded from: classes.dex */
public class AdRequestBean extends com.alimm.tanx.core.ad.bean.RequestBaseBean {
    public com.alimm.tanx.core.request.AdRequestBean.AdContentBean content;
    public java.lang.String ext = "";
    public boolean https_required;
    public java.util.List<com.alimm.tanx.core.request.AdRequestBean.AdImpBean> imp;
    public int render_type;

    @com.alibaba.fastjson.annotation.JSONField(serialize = false)
    public com.alimm.tanx.core.request.TanxAdSlot tanxAdSlot;
    public com.alimm.tanx.core.request.AdRequestBean.AdUserBean user;
    public int version;

    public static class AdContentBean extends com.alimm.tanx.core.ad.bean.BaseBean {
        public java.util.List<java.lang.String> category;
        public java.util.List<java.lang.String> keywords;
        public java.util.List<java.lang.String> query_term;
        public java.util.List<java.lang.String> suggestion;
        public java.lang.String title;
    }

    public static class AdImpBean extends com.alimm.tanx.core.ad.bean.BaseBean {
        public java.lang.String id;
        public java.lang.String[] native_template_id;
        public java.lang.String pid;
        public int pos;
        public int slot_num;
    }

    public static class AdUserBean extends com.alimm.tanx.core.ad.bean.BaseBean {
        public java.lang.String media_uid;
        public java.util.Map<java.lang.String, java.util.List<java.lang.String>> user_tag;
    }

    public com.alimm.tanx.core.request.AdRequestBean build(com.alimm.tanx.core.request.TanxAdSlot tanxAdSlot) {
        this.tanxAdSlot = tanxAdSlot;
        return this;
    }
}
