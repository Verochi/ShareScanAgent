package com.alimm.tanx.core.net.okhttp;

/* loaded from: classes.dex */
public class OkHttpNetWorkImpl<T> implements com.alimm.tanx.core.net.INetWork<T>, com.alimm.tanx.core.utils.NotConfused {
    private static final java.lang.String TAG = "OkHttpNetWorkImpl";
    long netTime = 0;

    /* renamed from: com.alimm.tanx.core.net.okhttp.OkHttpNetWorkImpl$1, reason: invalid class name */
    public class AnonymousClass1 implements com.alimm.tanx.core.net.okhttp.callback.ResultCall {
        final /* synthetic */ com.alimm.tanx.core.net.callback.NetWorkCallBack tanxc_do;
        final /* synthetic */ java.lang.Class tanxc_for;
        final /* synthetic */ boolean tanxc_if;

        public AnonymousClass1(com.alimm.tanx.core.net.callback.NetWorkCallBack netWorkCallBack, boolean z, java.lang.Class cls) {
            this.tanxc_do = netWorkCallBack;
            this.tanxc_if = z;
            this.tanxc_for = cls;
        }

        @Override // com.alimm.tanx.core.net.okhttp.callback.ResultCall
        public void inProgress(float f) {
        }

        @Override // com.alimm.tanx.core.net.okhttp.callback.ResultCall
        public void onAfter() {
        }

        @Override // com.alimm.tanx.core.net.okhttp.callback.ResultCall
        public void onBefore() {
        }

        @Override // com.alimm.tanx.core.net.okhttp.callback.ResultCall
        public void onError(int i, java.lang.String str) {
            com.alimm.tanx.core.net.callback.NetWorkCallBack netWorkCallBack = this.tanxc_do;
            if (netWorkCallBack != null) {
                netWorkCallBack.error(i, "", str);
            }
            com.alimm.tanx.core.utils.LogUtils.e(com.alimm.tanx.core.net.okhttp.OkHttpNetWorkImpl.TAG, str, "OkHttp");
            com.alimm.tanx.core.ut.impl.TanxBaseUt.utError(i, com.alimm.tanx.core.net.okhttp.OkHttpNetWorkImpl.TAG, str, "OkHttp");
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.alimm.tanx.core.net.okhttp.callback.ResultCall
        public void onSuccess(java.lang.String str) {
            com.alimm.tanx.core.net.callback.NetWorkCallBack netWorkCallBack = this.tanxc_do;
            if (netWorkCallBack != 0) {
                try {
                    if (this.tanxc_if) {
                        netWorkCallBack.succ(com.alibaba.fastjson.JSON.parseObject(str, this.tanxc_for));
                    } else {
                        netWorkCallBack.succ(str);
                    }
                } catch (java.lang.Exception e) {
                    onError(com.alimm.tanx.core.ut.UtErrorCode.NETWORK_ERROR.getIntCode(), e.getMessage());
                    e.printStackTrace();
                }
            }
        }
    }

    /* renamed from: com.alimm.tanx.core.net.okhttp.OkHttpNetWorkImpl$2, reason: invalid class name */
    public class AnonymousClass2 implements com.alimm.tanx.core.net.okhttp.callback.ResultCall {
        final /* synthetic */ long tanxc_do;
        final /* synthetic */ com.alimm.tanx.core.net.bean.RequestBean tanxc_for;
        final /* synthetic */ com.alimm.tanx.core.net.callback.NetWorkCallBack tanxc_if;
        final /* synthetic */ boolean tanxc_int;
        final /* synthetic */ java.lang.Class tanxc_new;

        public AnonymousClass2(long j, com.alimm.tanx.core.net.callback.NetWorkCallBack netWorkCallBack, com.alimm.tanx.core.net.bean.RequestBean requestBean, boolean z, java.lang.Class cls) {
            this.tanxc_do = j;
            this.tanxc_if = netWorkCallBack;
            this.tanxc_for = requestBean;
            this.tanxc_int = z;
            this.tanxc_new = cls;
        }

        @Override // com.alimm.tanx.core.net.okhttp.callback.ResultCall
        public void inProgress(float f) {
        }

        @Override // com.alimm.tanx.core.net.okhttp.callback.ResultCall
        public void onAfter() {
        }

        @Override // com.alimm.tanx.core.net.okhttp.callback.ResultCall
        public void onBefore() {
        }

        @Override // com.alimm.tanx.core.net.okhttp.callback.ResultCall
        public void onError(int i, java.lang.String str) {
            com.alimm.tanx.core.net.okhttp.OkHttpNetWorkImpl.this.netTime = java.lang.System.currentTimeMillis() - this.tanxc_do;
            com.alimm.tanx.core.utils.LogUtils.d("splashTimeConsuming", "netTimeAll onError->" + com.alimm.tanx.core.net.okhttp.OkHttpNetWorkImpl.this.netTime);
            com.alimm.tanx.core.net.callback.NetWorkCallBack netWorkCallBack = this.tanxc_if;
            if (netWorkCallBack != null) {
                netWorkCallBack.error(i, "", str);
            }
            com.alimm.tanx.core.utils.LogUtils.e(com.alimm.tanx.core.net.okhttp.OkHttpNetWorkImpl.TAG, str, "OkHttp");
            com.alimm.tanx.core.ut.impl.TanxBaseUt.utNetError(i, com.alimm.tanx.core.net.okhttp.OkHttpNetWorkImpl.TAG, new com.alimm.tanx.core.ut.bean.UtErrorBean(this.tanxc_for, i, str), "OkHttp");
        }

        @Override // com.alimm.tanx.core.net.okhttp.callback.ResultCall
        public void onSuccess(java.lang.String str) {
            com.alimm.tanx.core.utils.LogUtils.d(com.alimm.tanx.core.net.okhttp.OkHttpNetWorkImpl.TAG, "当前线程post onSuccess：" + java.lang.Thread.currentThread().getName());
            com.alimm.tanx.core.net.okhttp.OkHttpNetWorkImpl.this.netTime = java.lang.System.currentTimeMillis() - this.tanxc_do;
            com.alimm.tanx.core.utils.LogUtils.d("splashTimeConsuming", "netTimeAll onSuccess->" + com.alimm.tanx.core.net.okhttp.OkHttpNetWorkImpl.this.netTime);
            com.alimm.tanx.core.utils.LogUtils.d(com.alimm.tanx.core.net.okhttp.OkHttpNetWorkImpl.TAG, str);
            if (this.tanxc_if != null) {
                try {
                    if (android.text.TextUtils.isEmpty(str)) {
                        onError(com.alimm.tanx.core.ut.UtErrorCode.DATA_PARSE_ERROR.getIntCode(), "response:" + str);
                    } else if (this.tanxc_int) {
                        com.alimm.tanx.core.utils.LogUtils.d(com.alimm.tanx.core.net.okhttp.OkHttpNetWorkImpl.TAG, "AdResp decrypt before-> " + str);
                        java.lang.String decrypt = com.alimm.tanx.core.utils.EncryptUtils.decrypt(str);
                        com.alimm.tanx.core.utils.LogUtils.d(com.alimm.tanx.core.net.okhttp.OkHttpNetWorkImpl.TAG, "AdResp decrypt -> " + decrypt);
                        if (android.text.TextUtils.isEmpty(decrypt)) {
                            onError(com.alimm.tanx.core.ut.UtErrorCode.DECRYPT_ERROR.getIntCode(), "decrypt error:" + str);
                        } else {
                            com.alimm.tanx.core.net.okhttp.OkHttpNetWorkImpl.this.succCallBack(this.tanxc_new, decrypt, this.tanxc_if);
                        }
                    } else {
                        com.alimm.tanx.core.net.okhttp.OkHttpNetWorkImpl.this.succCallBack(this.tanxc_new, str, this.tanxc_if);
                        com.alimm.tanx.core.utils.LogUtils.d(com.alimm.tanx.core.net.okhttp.OkHttpNetWorkImpl.TAG, "AdResp noDecrypt-> " + str);
                    }
                } catch (java.lang.Exception e) {
                    onError(com.alimm.tanx.core.ut.UtErrorCode.NETWORK_ERROR.getIntCode(), com.alimm.tanx.core.utils.LogUtils.getStackTraceMessage(e));
                    e.printStackTrace();
                }
            }
        }
    }

    private java.lang.String getTag(com.alimm.tanx.core.net.bean.RequestBean requestBean) {
        if (!android.text.TextUtils.isEmpty(requestBean.getTag())) {
            return requestBean.getTag();
        }
        return java.lang.System.currentTimeMillis() + "";
    }

    private java.lang.String getTag(com.alimm.tanx.core.net.bean.RequestBean requestBean, com.alimm.tanx.core.net.callback.NetWorkCallBack netWorkCallBack) {
        return android.text.TextUtils.isEmpty(requestBean.getTag()) ? netWorkCallBack != null ? netWorkCallBack.getClass().toString() : "" : requestBean.getTag();
    }

    private java.lang.String getTag(com.alimm.tanx.core.net.bean.RequestBean requestBean, com.alimm.tanx.core.net.okhttp.callback.OnDownloadListener onDownloadListener) {
        return android.text.TextUtils.isEmpty(requestBean.getTag()) ? onDownloadListener != null ? onDownloadListener.getClass().toString() : "" : requestBean.getTag();
    }

    private boolean isNull(com.alimm.tanx.core.net.bean.RequestBean requestBean, com.alimm.tanx.core.net.callback.NetWorkCallBack netWorkCallBack) {
        if (requestBean != null) {
            return false;
        }
        if (netWorkCallBack == null) {
            return true;
        }
        com.alimm.tanx.core.ut.UtErrorCode utErrorCode = com.alimm.tanx.core.ut.UtErrorCode.NETWORK_PARAM_ERROR;
        netWorkCallBack.error(utErrorCode.getIntCode(), "", utErrorCode.getMsg());
        return true;
    }

    private boolean isNull(com.alimm.tanx.core.net.bean.RequestBean requestBean, com.alimm.tanx.core.net.okhttp.callback.OnDownloadListener onDownloadListener) {
        if (requestBean != null) {
            return false;
        }
        if (onDownloadListener == null) {
            return true;
        }
        com.alimm.tanx.core.ut.UtErrorCode utErrorCode = com.alimm.tanx.core.ut.UtErrorCode.NETWORK_PARAM_ERROR;
        onDownloadListener.onDownloadFailed(utErrorCode.getIntCode(), "downLoad接口请求参数判空:" + utErrorCode.getMsg());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$succCallBack$13(com.alimm.tanx.core.net.callback.NetWorkCallBack netWorkCallBack, java.lang.Object obj, java.lang.String str) {
        com.alimm.tanx.core.utils.LogUtils.d(TAG, "当前线程post succCallBack：" + java.lang.Thread.currentThread().getName());
        if (netWorkCallBack instanceof com.alimm.tanx.core.net.callback.AdNetWorkCallBack) {
            ((com.alimm.tanx.core.net.callback.AdNetWorkCallBack) netWorkCallBack).succ(obj, str);
        } else {
            netWorkCallBack.succ(obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void succCallBack(java.lang.Class<T> cls, java.lang.String str, com.alimm.tanx.core.net.callback.NetWorkCallBack netWorkCallBack) {
        com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_do().tanxc_for().post(new defpackage.tu1(netWorkCallBack, com.alibaba.fastjson.JSON.parseObject(str, cls), str));
    }

    @Override // com.alimm.tanx.core.net.INetWork
    public void cancelOkHttpTag(java.lang.String str) {
        if (!android.text.TextUtils.isEmpty(str)) {
            com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_do().tanxc_do(str);
        } else {
            com.alimm.tanx.core.utils.LogUtils.e("OkHttp ", "tag为空，无法cancelOkHttpTag");
            com.alimm.tanx.core.ut.impl.TanxBaseUt.utError(com.alimm.tanx.core.ut.UtErrorCode.ERROR_LOGIC.getIntCode(), "OkHttp ", "tag为空，无法cancelOkHttpTag", "");
        }
    }

    @Override // com.alimm.tanx.core.net.INetWork
    public void sendHttpDownload(com.alimm.tanx.core.net.bean.RequestBean requestBean, com.alimm.tanx.core.net.okhttp.callback.OnDownloadListener onDownloadListener) {
        try {
            if (isNull(requestBean, onDownloadListener)) {
                return;
            }
            com.alimm.tanx.core.net.bean.DownLoadRequestBean downLoadRequestBean = (com.alimm.tanx.core.net.bean.DownLoadRequestBean) requestBean;
            com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_try().tanxc_for(downLoadRequestBean.getUrl()).tanxc_int(getTag(downLoadRequestBean, onDownloadListener)).tanxc_do(downLoadRequestBean.getPath()).tanxc_if(downLoadRequestBean.getFileName()).tanxc_do(downLoadRequestBean.isResume()).tanxc_do().tanxc_do(onDownloadListener);
        } catch (java.lang.Exception e) {
            com.alimm.tanx.core.utils.LogUtils.e("sendHttpDownload", e);
            com.alimm.tanx.core.ut.UtErrorCode utErrorCode = com.alimm.tanx.core.ut.UtErrorCode.OK_HTTP_ERROR;
            onDownloadListener.onDownloadFailed(utErrorCode.getIntCode(), utErrorCode.getMsg() + "  " + com.alimm.tanx.core.utils.LogUtils.getStackTraceMessage(e));
        }
    }

    @Override // com.alimm.tanx.core.net.INetWork
    public void sendHttpGet(com.alimm.tanx.core.net.bean.RequestBean requestBean, java.lang.Class cls, com.alimm.tanx.core.net.callback.NetWorkCallBack netWorkCallBack) {
        sendHttpGet(requestBean, cls, true, true, netWorkCallBack);
    }

    @Override // com.alimm.tanx.core.net.INetWork
    public void sendHttpGet(com.alimm.tanx.core.net.bean.RequestBean requestBean, java.lang.Class cls, boolean z, boolean z2, com.alimm.tanx.core.net.callback.NetWorkCallBack netWorkCallBack) {
        try {
            if (isNull(requestBean, netWorkCallBack)) {
                return;
            }
            com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_new().tanxc_do(requestBean.getUrl()).tanxc_if(getTag(requestBean, netWorkCallBack)).tanxc_do(requestBean.getHeads()).tanxc_if(requestBean.getParams()).tanxc_if(requestBean.getCacheOfflineTime()).tanxc_do(requestBean.getCacheOnlineTime()).tanxc_do(requestBean.isOnlyOneNet()).tanxc_for(requestBean.getTryAgainCount()).tanxc_do().tanxc_do(new com.alimm.tanx.core.net.okhttp.OkHttpNetWorkImpl.AnonymousClass1(netWorkCallBack, z2, cls));
        } catch (java.lang.Exception e) {
            com.alimm.tanx.core.utils.LogUtils.e("sendHttpGet", e);
            com.alimm.tanx.core.ut.UtErrorCode utErrorCode = com.alimm.tanx.core.ut.UtErrorCode.OK_HTTP_ERROR;
            netWorkCallBack.error(utErrorCode.getIntCode(), "", utErrorCode.getMsg() + "  " + com.alimm.tanx.core.utils.LogUtils.getStackTraceMessage(e));
        }
    }

    @Override // com.alimm.tanx.core.net.INetWork
    public void sendHttpPost(com.alimm.tanx.core.net.bean.RequestBean requestBean, java.lang.Class cls, com.alimm.tanx.core.net.callback.NetWorkCallBack netWorkCallBack) {
        sendHttpPost(requestBean, cls, true, netWorkCallBack);
    }

    @Override // com.alimm.tanx.core.net.INetWork
    public void sendHttpPost(com.alimm.tanx.core.net.bean.RequestBean requestBean, java.lang.Class<T> cls, boolean z, com.alimm.tanx.core.net.callback.NetWorkCallBack netWorkCallBack) {
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        this.netTime = 0L;
        try {
            if (isNull(requestBean, netWorkCallBack)) {
                return;
            }
            com.alimm.tanx.core.utils.LogUtils.d(TAG, "当前线程post：" + java.lang.Thread.currentThread().getName());
            com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_if(false).tanxc_do(requestBean.getUrl()).tanxc_if(getTag(requestBean, netWorkCallBack)).tanxc_do(requestBean.getHeads()).tanxc_if(requestBean.getParams()).tanxc_for(z ? com.alimm.tanx.core.utils.EncryptUtils.encrypt(requestBean.getJson()) : requestBean.getJson()).tanxc_if(requestBean.isOnlyOneNet()).tanxc_do(requestBean.getTryAgainCount()).tanxc_do().tanxc_do(new com.alimm.tanx.core.net.okhttp.OkHttpNetWorkImpl.AnonymousClass2(currentTimeMillis, netWorkCallBack, requestBean, z, cls));
        } catch (java.lang.Exception e) {
            com.alimm.tanx.core.utils.LogUtils.e("sendHttpPost", e);
            com.alimm.tanx.core.ut.UtErrorCode utErrorCode = com.alimm.tanx.core.ut.UtErrorCode.OK_HTTP_ERROR;
            netWorkCallBack.error(utErrorCode.getIntCode(), "", utErrorCode.getMsg() + "  " + com.alimm.tanx.core.utils.LogUtils.getStackTraceMessage(e));
        }
    }

    @Override // com.alimm.tanx.core.net.INetWork
    public T sendSyncHttpPost2Gzip(com.alimm.tanx.core.net.bean.RequestBean requestBean, java.lang.Class<T> cls) {
        java.lang.String string;
        if (requestBean == null) {
            return null;
        }
        try {
            okhttp3.Response tanxc_do = com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_if(true).tanxc_do(requestBean.getUrl()).tanxc_if(getTag(requestBean)).tanxc_do(requestBean.getHeads()).tanxc_if(requestBean.getParams()).tanxc_for(com.alimm.tanx.core.utils.EncryptUtils.encrypt(requestBean.getJson(), false)).tanxc_if(requestBean.isOnlyOneNet()).tanxc_do(requestBean.getTryAgainCount()).tanxc_do().tanxc_do(false);
            if (tanxc_do != null) {
                java.lang.String str = "";
                if (tanxc_do.body() != null && (string = tanxc_do.body().string()) != null) {
                    str = string;
                }
                com.alimm.tanx.core.utils.LogUtils.d(TAG, "result:->" + str);
                java.lang.String decrypt = com.alimm.tanx.core.utils.EncryptUtils.decrypt(str, false);
                if (!android.text.TextUtils.isEmpty(decrypt)) {
                    return (T) com.alibaba.fastjson.JSON.parseObject(decrypt, cls);
                }
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            com.alimm.tanx.core.utils.LogUtils.e("sendSyncHttpPost2Gzip", e);
        }
        return null;
    }
}
