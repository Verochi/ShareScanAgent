package com.alimm.tanx.core.ad.model;

/* loaded from: classes.dex */
public abstract class BaseModel implements com.alimm.tanx.core.ad.listener.model.IModel, com.alimm.tanx.core.utils.NotConfused, java.lang.Runnable {
    protected com.alimm.tanx.core.request.TanxAdSlot adSlot;
    protected com.alimm.tanx.core.ad.bean.BidInfo bidInfo;
    protected boolean hasRequest;
    protected boolean hasTimeOut;
    protected boolean isCancel;
    protected com.alimm.tanx.core.ad.loader.ITanxRequestLoader.ITanxRequestListener requestListener;
    private final java.lang.String TAG = "BaseModel";
    protected android.os.Handler handler = new android.os.Handler(android.os.Looper.getMainLooper());

    /* renamed from: com.alimm.tanx.core.ad.model.BaseModel$1, reason: invalid class name */
    public class AnonymousClass1 implements com.alimm.tanx.core.net.callback.NetWorkCallBack<com.alimm.tanx.core.ad.bean.AdInfo> {
        final /* synthetic */ com.alimm.tanx.core.ad.loader.ITanxRequestLoader.ITanxRequestListener tanxc_do;

        public AnonymousClass1(com.alimm.tanx.core.ad.loader.ITanxRequestLoader.ITanxRequestListener iTanxRequestListener) {
            this.tanxc_do = iTanxRequestListener;
        }

        @Override // com.alimm.tanx.core.net.callback.NetWorkCallBack
        public void error(int i, java.lang.String str, java.lang.String str2) {
            com.alimm.tanx.core.utils.LogUtils.e("BaseModel", "发起请求 error=" + str2);
            com.alimm.tanx.core.ad.model.BaseModel baseModel = com.alimm.tanx.core.ad.model.BaseModel.this;
            if (baseModel.isCancel || baseModel.hasTimeOut) {
                return;
            }
            com.alimm.tanx.core.ad.loader.ITanxRequestLoader.ITanxRequestListener iTanxRequestListener = this.tanxc_do;
            if (iTanxRequestListener != null) {
                iTanxRequestListener.onError(new com.alimm.tanx.core.request.TanxError(str, i, str2));
            }
            com.alimm.tanx.core.ad.model.BaseModel.this.cancel();
            com.alimm.tanx.core.ad.model.BaseModel.this.timerCancelNotify(null, true, 0);
        }

        @Override // com.alimm.tanx.core.net.callback.NetWorkCallBack
        /* renamed from: tanxc_do, reason: merged with bridge method [inline-methods] */
        public void succ(com.alimm.tanx.core.ad.bean.AdInfo adInfo) {
            com.alimm.tanx.core.utils.LogUtils.d("BaseModel", "发起请求 isCancel=" + com.alimm.tanx.core.ad.model.BaseModel.this.isCancel + "--- hasTimeOut= " + com.alimm.tanx.core.ad.model.BaseModel.this.hasTimeOut);
            com.alimm.tanx.core.ad.model.BaseModel.this.requestSucc(adInfo);
        }
    }

    @Override // com.alimm.tanx.core.ad.listener.model.IModel
    public void cancel() {
        this.isCancel = true;
        android.os.Handler handler = this.handler;
        if (handler != null) {
            handler.removeCallbacks(this);
        }
        com.alimm.tanx.core.utils.LogUtils.d("BaseModel", "计时器取消");
    }

    public void checkSuccess(com.alimm.tanx.core.ad.bean.AdInfo adInfo) {
        if (adInfo != null) {
            onSuccess(adInfo);
            return;
        }
        com.alimm.tanx.core.ad.loader.ITanxRequestLoader.ITanxRequestListener iTanxRequestListener = this.requestListener;
        if (iTanxRequestListener != null) {
            iTanxRequestListener.onError(new com.alimm.tanx.core.request.TanxError(com.alimm.tanx.core.request.TanxError.ERROR_ADINFO_NULL));
        }
    }

    public abstract java.lang.String getScene();

    public abstract void onSuccess(com.alimm.tanx.core.ad.bean.AdInfo adInfo);

    public void requestSucc(com.alimm.tanx.core.ad.bean.AdInfo adInfo) {
        if (this.isCancel || this.hasTimeOut) {
            return;
        }
        checkSuccess(adInfo);
        cancel();
        timerCancelNotify(adInfo, true, 0);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.hasTimeOut = true;
        com.alimm.tanx.core.ad.loader.ITanxRequestLoader.ITanxRequestListener iTanxRequestListener = this.requestListener;
        if (iTanxRequestListener != null) {
            iTanxRequestListener.onTimeOut();
            com.alimm.tanx.core.utils.LogUtils.d("BaseModel", "计时器达到超时");
        }
        timerCancelNotify(null, false, com.alimm.tanx.core.ut.UtErrorCode.TIMER_OUT.getIntCode());
    }

    @Override // com.alimm.tanx.core.ad.listener.model.IModel
    public void sendRequest(com.alimm.tanx.core.request.TanxAdSlot tanxAdSlot, com.alimm.tanx.core.ad.loader.ITanxRequestLoader.ITanxRequestListener iTanxRequestListener) {
        sendRequest(tanxAdSlot, iTanxRequestListener, 0L);
    }

    @Override // com.alimm.tanx.core.ad.listener.model.IModel
    public void sendRequest(com.alimm.tanx.core.request.TanxAdSlot tanxAdSlot, com.alimm.tanx.core.ad.loader.ITanxRequestLoader.ITanxRequestListener iTanxRequestListener, long j) {
        this.adSlot = tanxAdSlot;
        this.requestListener = iTanxRequestListener;
        com.alimm.tanx.core.utils.LogUtils.d("BaseModel", "发起请求 hasRequest=" + this.hasRequest);
        if (this.hasRequest) {
            throw new java.lang.IllegalStateException("has request");
        }
        this.hasRequest = true;
        startTimer(j);
        new com.alimm.tanx.core.request.AdRequest().request(new com.alimm.tanx.core.request.AdRequestBean().build(tanxAdSlot), (com.alimm.tanx.core.net.callback.NetWorkCallBack<com.alimm.tanx.core.ad.bean.AdInfo>) new com.alimm.tanx.core.ad.model.BaseModel.AnonymousClass1(iTanxRequestListener));
    }

    public void startTimer(long j) {
        com.alimm.tanx.core.utils.LogUtils.d("BaseModel", "启动计时器 timeOut=" + j);
        if (j > 0) {
            this.handler.postDelayed(this, j);
        }
    }

    public abstract void timerCancelNotify(com.alimm.tanx.core.ad.bean.AdInfo adInfo, boolean z, int i);
}
