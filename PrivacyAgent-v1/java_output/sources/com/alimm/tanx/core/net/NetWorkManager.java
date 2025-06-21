package com.alimm.tanx.core.net;

/* loaded from: classes.dex */
public class NetWorkManager<T> implements com.alimm.tanx.core.net.INetWork<T>, com.alimm.tanx.core.utils.NotConfused {
    private static final java.lang.String TAG = "NetWorkManager";
    private static com.alimm.tanx.core.net.INetWork iNetWork;
    private static com.alimm.tanx.core.net.NetWorkManager instance;

    public NetWorkManager() {
    }

    public NetWorkManager(com.alimm.tanx.core.net.INetWork iNetWork2) {
        iNetWork = iNetWork2;
    }

    public static com.alimm.tanx.core.net.NetWorkManager getInstance() {
        if (instance == null) {
            synchronized (com.alimm.tanx.core.net.NetWorkManager.class) {
                if (instance == null) {
                    instance = new com.alimm.tanx.core.net.NetWorkManager(com.alimm.tanx.core.TanxCoreManager.getInstance().getTanxCoreInstanceConfig().getNetWork());
                }
            }
        }
        return instance;
    }

    @Override // com.alimm.tanx.core.net.INetWork
    public void cancelOkHttpTag(java.lang.String str) {
        com.alimm.tanx.core.net.INetWork iNetWork2 = iNetWork;
        if (iNetWork2 != null) {
            iNetWork2.cancelOkHttpTag(str);
        } else {
            com.alimm.tanx.core.utils.LogUtils.e(TAG, "iNetWork == null,清设置请求网络库实例");
            com.alimm.tanx.core.ut.impl.TanxBaseUt.utError(com.alimm.tanx.core.ut.UtErrorCode.ERROR_LOGIC.getIntCode(), TAG, "cancelOkHttpTag ->iNetWork == null,清设置请求网络库实例", "");
        }
    }

    @Override // com.alimm.tanx.core.net.INetWork
    public void sendHttpDownload(com.alimm.tanx.core.net.bean.RequestBean requestBean, com.alimm.tanx.core.net.okhttp.callback.OnDownloadListener onDownloadListener) {
        com.alimm.tanx.core.net.INetWork iNetWork2 = iNetWork;
        if (iNetWork2 != null) {
            iNetWork2.sendHttpDownload(requestBean, onDownloadListener);
        } else {
            com.alimm.tanx.core.utils.LogUtils.e(TAG, "iNetWork == null,清设置请求网络库实例");
            com.alimm.tanx.core.ut.impl.TanxBaseUt.utError(com.alimm.tanx.core.ut.UtErrorCode.ERROR_LOGIC.getIntCode(), TAG, "sendHttpDownload->iNetWork == null,清设置请求网络库实例", "");
        }
    }

    @Override // com.alimm.tanx.core.net.INetWork
    public void sendHttpGet(com.alimm.tanx.core.net.bean.RequestBean requestBean, java.lang.Class cls, com.alimm.tanx.core.net.callback.NetWorkCallBack netWorkCallBack) {
        com.alimm.tanx.core.net.INetWork iNetWork2 = iNetWork;
        if (iNetWork2 != null) {
            iNetWork2.sendHttpGet(requestBean, cls, netWorkCallBack);
        } else {
            com.alimm.tanx.core.utils.LogUtils.e(TAG, "iNetWork == null,清设置请求网络库实例");
            com.alimm.tanx.core.ut.impl.TanxBaseUt.utError(com.alimm.tanx.core.ut.UtErrorCode.ERROR_LOGIC.getIntCode(), TAG, "sendHttpGet->iNetWork == null,清设置请求网络库实例", "");
        }
    }

    @Override // com.alimm.tanx.core.net.INetWork
    public void sendHttpGet(com.alimm.tanx.core.net.bean.RequestBean requestBean, java.lang.Class cls, boolean z, boolean z2, com.alimm.tanx.core.net.callback.NetWorkCallBack netWorkCallBack) {
        com.alimm.tanx.core.net.INetWork iNetWork2 = iNetWork;
        if (iNetWork2 != null) {
            iNetWork2.sendHttpGet(requestBean, cls, z, z2, netWorkCallBack);
        } else {
            com.alimm.tanx.core.utils.LogUtils.e(TAG, "iNetWork == null,清设置请求网络库实例");
            com.alimm.tanx.core.ut.impl.TanxBaseUt.utError(com.alimm.tanx.core.ut.UtErrorCode.ERROR_LOGIC.getIntCode(), TAG, "sendHttpGet->iNetWork == null,清设置请求网络库实例", "");
        }
    }

    @Override // com.alimm.tanx.core.net.INetWork
    public void sendHttpPost(com.alimm.tanx.core.net.bean.RequestBean requestBean, java.lang.Class cls, com.alimm.tanx.core.net.callback.NetWorkCallBack netWorkCallBack) {
        sendHttpPost(requestBean, cls, true, netWorkCallBack);
    }

    @Override // com.alimm.tanx.core.net.INetWork
    public void sendHttpPost(com.alimm.tanx.core.net.bean.RequestBean requestBean, java.lang.Class<T> cls, boolean z, com.alimm.tanx.core.net.callback.NetWorkCallBack netWorkCallBack) {
        com.alimm.tanx.core.net.INetWork iNetWork2 = iNetWork;
        if (iNetWork2 != null) {
            iNetWork2.sendHttpPost(requestBean, cls, z, netWorkCallBack);
        } else {
            com.alimm.tanx.core.utils.LogUtils.e(TAG, "iNetWork == null,清设置请求网络库实例");
            com.alimm.tanx.core.ut.impl.TanxBaseUt.utError(com.alimm.tanx.core.ut.UtErrorCode.ERROR_LOGIC.getIntCode(), TAG, "sendHttpPost->iNetWork == null,清设置请求网络库实例", "");
        }
    }

    @Override // com.alimm.tanx.core.net.INetWork
    public T sendSyncHttpPost2Gzip(com.alimm.tanx.core.net.bean.RequestBean requestBean, java.lang.Class<T> cls) {
        com.alimm.tanx.core.net.INetWork iNetWork2 = iNetWork;
        if (iNetWork2 != null) {
            return (T) iNetWork2.sendSyncHttpPost2Gzip(requestBean, cls);
        }
        com.alimm.tanx.core.utils.LogUtils.e(TAG, "iNetWork == null,清设置请求网络库实例");
        com.alimm.tanx.core.ut.impl.TanxBaseUt.utError(com.alimm.tanx.core.ut.UtErrorCode.ERROR_LOGIC.getIntCode(), TAG, "sendSyncHttpPost2Gzip->iNetWork == null,清设置请求网络库实例", "");
        return null;
    }

    public void setINetWork(com.alimm.tanx.core.net.INetWork iNetWork2) {
        iNetWork = iNetWork2;
    }
}
