package com.alimm.tanx.core.ut.core;

/* loaded from: classes.dex */
public interface IUserReport {
    public static final java.lang.String TAG = "UserReport :";

    void send(com.alimm.tanx.core.ut.bean.UtItemBean utItemBean);

    void send(java.util.List<com.alimm.tanx.core.ut.bean.UtItemBean> list);
}
