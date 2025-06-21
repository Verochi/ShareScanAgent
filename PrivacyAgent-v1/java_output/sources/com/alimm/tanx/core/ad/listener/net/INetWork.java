package com.alimm.tanx.core.ad.listener.net;

/* loaded from: classes.dex */
public interface INetWork<T> {
    void cancelOkHttpTag(java.lang.String str);

    void sendHttpDownload(com.alimm.tanx.core.net.bean.RequestBean requestBean, com.alimm.tanx.core.net.okhttp.callback.OnDownloadListener onDownloadListener);

    void sendHttpGet(com.alimm.tanx.core.net.bean.RequestBean requestBean, java.lang.Class<T> cls, com.alimm.tanx.core.net.callback.NetWorkCallBack netWorkCallBack);

    void sendHttpGet(com.alimm.tanx.core.net.bean.RequestBean requestBean, java.lang.Class<T> cls, boolean z, boolean z2, com.alimm.tanx.core.net.callback.NetWorkCallBack netWorkCallBack);

    void sendHttpPost(com.alimm.tanx.core.net.bean.RequestBean requestBean, java.lang.Class<T> cls, com.alimm.tanx.core.net.callback.NetWorkCallBack netWorkCallBack);

    T sendSyncHttpPost2Gzip(com.alimm.tanx.core.net.bean.RequestBean requestBean, java.lang.Class<T> cls);
}
