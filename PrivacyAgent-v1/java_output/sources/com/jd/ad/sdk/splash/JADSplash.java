package com.jd.ad.sdk.splash;

/* loaded from: classes23.dex */
public class JADSplash implements com.jd.ad.sdk.bl.adload.IJADBase, com.jd.ad.sdk.bl.adload.JADAdLoadListener, com.jd.ad.sdk.splash.jad_s_fs.jad_s_an, com.jd.ad.sdk.bl.preload.PreloadAdDataCacheUsageManager.UseCacheCounterFinishCallback {
    private int dstp;
    private int mAttachActivityHashCode;
    private java.lang.ref.WeakReference<android.content.Context> mContextWf;
    private java.lang.String mInstanceId;
    private com.jd.ad.sdk.splash.jad_s_an.jad_s_cp mInteractionListener;
    private com.jd.ad.sdk.splash.JADSplashCountDownListener mJADCountDownListener;
    private com.jd.ad.sdk.splash.JADSplashListener mJADListener;
    private final com.jd.ad.sdk.splash.jad_s_fs mJADSplashTolerateManager;
    private com.jd.ad.sdk.splash.JADSplashVideoListener mJADSplashVideoListener;
    private com.jd.ad.sdk.fdt.utils.ActLifecycle.OnLifecycleChangeListener mLifeChangeListener;
    private com.jd.ad.sdk.dl.model.JADSlot mSlot;
    private com.jd.ad.sdk.splash.jad_s_an mSplashAdRender;
    private int srtp;
    private int mSplashStylePlanType = 0;
    private int mSplashClickAreaValue = 100;
    private long mRemainTolerateTime = 0;

    public class jad_s_an implements java.lang.Runnable {
        public jad_s_an() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.jd.ad.sdk.splash.JADSplash.this.onAdCloseCallback();
        }
    }

    public class jad_s_bo implements java.lang.Runnable {
        public final /* synthetic */ int jad_s_an;

        public jad_s_bo(int i) {
            this.jad_s_an = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.jd.ad.sdk.splash.JADSplash.this.onAdCountDownCallback(this.jad_s_an);
        }
    }

    public class jad_s_cp implements com.jd.ad.sdk.fdt.utils.ActLifecycle.OnLifecycleChangeListener {
        public jad_s_cp() {
        }

        @Override // com.jd.ad.sdk.fdt.utils.ActLifecycle.OnLifecycleChangeListener
        public void onActivityDestroyed(@androidx.annotation.NonNull android.app.Activity activity) {
            if (activity.hashCode() == com.jd.ad.sdk.splash.JADSplash.this.mAttachActivityHashCode) {
                com.jd.ad.sdk.splash.JADSplash.this.destroy();
            }
        }

        @Override // com.jd.ad.sdk.fdt.utils.ActLifecycle.OnLifecycleChangeListener
        public void onActivityPaused(@androidx.annotation.NonNull android.app.Activity activity) {
            if (activity.hashCode() != com.jd.ad.sdk.splash.JADSplash.this.mAttachActivityHashCode || com.jd.ad.sdk.splash.JADSplash.this.mSplashAdRender == null) {
                return;
            }
            com.jd.ad.sdk.splash.JADSplash.this.mSplashAdRender.jad_s_vi = true;
        }

        @Override // com.jd.ad.sdk.fdt.utils.ActLifecycle.OnLifecycleChangeListener
        public void onActivityResumed(@androidx.annotation.NonNull android.app.Activity activity) {
            if (activity.hashCode() != com.jd.ad.sdk.splash.JADSplash.this.mAttachActivityHashCode || com.jd.ad.sdk.splash.JADSplash.this.mSplashAdRender == null) {
                return;
            }
            com.jd.ad.sdk.splash.JADSplash.this.mSplashAdRender.jad_s_vi = false;
        }

        @Override // com.jd.ad.sdk.fdt.utils.ActLifecycle.OnLifecycleChangeListener
        public /* synthetic */ void onActivityStopped(android.app.Activity activity) {
            defpackage.x3.c(this, activity);
        }
    }

    public class jad_s_dq implements java.lang.Runnable {
        public jad_s_dq() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.jd.ad.sdk.splash.JADSplash.this.startRender();
        }
    }

    public class jad_s_er implements com.jd.ad.sdk.splash.jad_s_an.jad_s_cp {
        public jad_s_er() {
        }
    }

    public class jad_s_fs implements java.lang.Runnable {
        public jad_s_fs() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.jd.ad.sdk.splash.JADSplash.this.onAdLoadCallback();
        }
    }

    public class jad_s_hu implements java.lang.Runnable {
        public final /* synthetic */ android.view.View jad_s_an;

        public jad_s_hu(android.view.View view) {
            this.jad_s_an = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.jd.ad.sdk.splash.JADSplash.this.onAdRenderSucCallback(this.jad_s_an);
        }
    }

    public class jad_s_iv implements java.lang.Runnable {
        public final /* synthetic */ int jad_s_an;
        public final /* synthetic */ java.lang.String jad_s_bo;

        public jad_s_iv(int i, java.lang.String str) {
            this.jad_s_an = i;
            this.jad_s_bo = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.jd.ad.sdk.splash.JADSplash.this.onAdRenderFailedCallback(this.jad_s_an, this.jad_s_bo);
        }
    }

    public class jad_s_jt implements java.lang.Runnable {
        public final /* synthetic */ int jad_s_an;
        public final /* synthetic */ java.lang.String jad_s_bo;

        public jad_s_jt(int i, java.lang.String str) {
            this.jad_s_an = i;
            this.jad_s_bo = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.jd.ad.sdk.splash.JADSplash.this.onAdLoadFailedCallback(this.jad_s_an, this.jad_s_bo);
        }
    }

    public class jad_s_jw implements java.lang.Runnable {
        public jad_s_jw() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.jd.ad.sdk.splash.JADSplash.this.onAdClickCallback();
        }
    }

    public class jad_s_kx implements java.lang.Runnable {
        public jad_s_kx() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.jd.ad.sdk.splash.JADSplash.this.onAdShowedCallback();
        }
    }

    public JADSplash(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull com.jd.ad.sdk.dl.model.JADSlot jADSlot) {
        this.dstp = 0;
        this.srtp = 0;
        this.mInstanceId = "";
        this.mAttachActivityHashCode = -1;
        if (context == null) {
            com.jd.ad.sdk.logger.Logger.w("Context can not be null !!!", new java.lang.Object[0]);
        } else {
            this.mContextWf = new java.lang.ref.WeakReference<>(context);
            if (context instanceof android.app.Activity) {
                this.mAttachActivityHashCode = context.hashCode();
            }
        }
        this.mInstanceId = com.jd.ad.sdk.fdt.utils.UUIDUtils.uuid();
        if (jADSlot == null) {
            com.jd.ad.sdk.logger.Logger.w("JADSlot can not be null !!!", new java.lang.Object[0]);
        } else {
            this.mSlot = jADSlot;
            com.jd.ad.sdk.mdt.servicemediator.JADMediator.getInstance().getInitService().createDefaultAdInstance(jADSlot);
            this.dstp = com.jd.ad.sdk.mdt.servicemediator.JADMediator.getInstance().getInitService().getDs(this.mSlot.getSlotID());
            this.srtp = com.jd.ad.sdk.mdt.servicemediator.JADMediator.getInstance().getInitService().getR(this.mSlot.getSlotID());
        }
        com.jd.ad.sdk.mdt.servicemediator.JADMediator.getInstance().getAdService().registerAd(this.mInstanceId);
        this.mJADSplashTolerateManager = getTolerateWidget(jADSlot.getTolerateTime());
        initActLifeListener();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void calculateClickArea() {
        android.view.View view;
        try {
            com.jd.ad.sdk.dl.model.JADSlot jADSlot = this.mSlot;
            if (jADSlot == null) {
                return;
            }
            if (jADSlot.getRem() == 3) {
                this.mSplashStylePlanType = 6;
                com.jd.ad.sdk.splash.jad_s_an jad_s_anVar = this.mSplashAdRender;
                if (jad_s_anVar != null && jad_s_anVar.jad_s_cp() != null) {
                    this.mSplashClickAreaValue = this.mSplashAdRender.jad_s_cp().getAdClickAreaValue();
                }
                this.mSlot.setSspt(this.mSplashStylePlanType);
                this.mSlot.setScav(this.mSplashClickAreaValue);
                return;
            }
            com.jd.ad.sdk.splash.jad_s_an jad_s_anVar2 = this.mSplashAdRender;
            if (jad_s_anVar2 != null && jad_s_anVar2.jad_s_iv != null && (view = jad_s_anVar2.jad_s_jt) != null) {
                this.mSplashStylePlanType = jad_s_anVar2.jad_s_jw;
                int measuredWidth = (int) (view.getMeasuredWidth() * this.mSplashAdRender.jad_s_jt.getMeasuredHeight());
                int measuredWidth2 = this.mSplashAdRender.jad_s_iv.getMeasuredWidth() * this.mSplashAdRender.jad_s_iv.getMeasuredHeight();
                if (measuredWidth > 0) {
                    this.mSplashClickAreaValue = (measuredWidth2 * 100) / measuredWidth;
                }
                this.mSlot.setSspt(this.mSplashStylePlanType);
                this.mSlot.setScav(this.mSplashClickAreaValue);
            }
        } catch (java.lang.Exception e) {
            com.jd.ad.sdk.logger.Logger.w("Exception while calculate area: " + e.getMessage(), new java.lang.Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callbackAdClickOnUiThread() {
        com.jd.ad.sdk.fdt.utils.HandlerUtils.runOnUiThread(new com.jd.ad.sdk.splash.JADSplash.jad_s_jw());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callbackAdCloseOnUiThread() {
        com.jd.ad.sdk.fdt.utils.HandlerUtils.runOnUiThread(new com.jd.ad.sdk.splash.JADSplash.jad_s_an());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callbackAdCountDownOnUiThread(int i) {
        com.jd.ad.sdk.fdt.utils.HandlerUtils.runOnUiThread(new com.jd.ad.sdk.splash.JADSplash.jad_s_bo(i));
    }

    private void callbackAdLoadFailedOnUiThread(int i, java.lang.String str) {
        com.jd.ad.sdk.fdt.utils.HandlerUtils.runOnUiThread(new com.jd.ad.sdk.splash.JADSplash.jad_s_jt(i, str));
    }

    private void callbackAdLoadOnUiThread() {
        com.jd.ad.sdk.fdt.utils.HandlerUtils.runOnUiThread(new com.jd.ad.sdk.splash.JADSplash.jad_s_fs());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callbackAdReadyOnUiThread(android.view.View view) {
        reportRenderSuccessEvent();
        com.jd.ad.sdk.fdt.utils.HandlerUtils.runOnUiThread(new com.jd.ad.sdk.splash.JADSplash.jad_s_hu(view));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callbackAdRenderFailedOnUiThread(int i, java.lang.String str) {
        com.jd.ad.sdk.fdt.utils.HandlerUtils.runOnUiThread(new com.jd.ad.sdk.splash.JADSplash.jad_s_iv(i, str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callbackAdShowedOnUiThread() {
        com.jd.ad.sdk.fdt.utils.HandlerUtils.runOnUiThread(new com.jd.ad.sdk.splash.JADSplash.jad_s_kx());
    }

    private void doAfterPreloadFinished() {
        com.jd.ad.sdk.mdt.servicemediator.JADMediator.getInstance().getAdService().unregisterAdPreloader(this.mInstanceId, this.mSlot);
        com.jd.ad.sdk.mdt.servicemediator.JADMediator.getInstance().getAdService().unregisterAd(this.mInstanceId);
    }

    private int getAdType() {
        return 1;
    }

    @androidx.annotation.Nullable
    private android.content.Context getAppContext() {
        java.lang.ref.WeakReference<android.content.Context> weakReference = this.mContextWf;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    private int getDisplayScene() {
        return 4;
    }

    private java.lang.String getImageUrl() {
        return (getJADMaterialData() == null || getJADMaterialData().getImageUrls() == null || getJADMaterialData().getImageUrls().isEmpty()) ? "" : getJADMaterialData().getImageUrls().get(0);
    }

    private java.lang.String getTolerateTimeFinishErin(java.lang.String str) {
        java.lang.String str2;
        float f;
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        com.jd.ad.sdk.dl.model.JADSlot jADSlot = this.mSlot;
        if (jADSlot != null) {
            str2 = jADSlot.getSlotID();
            f = this.mSlot.getTolerateTime();
        } else {
            str2 = "";
            f = 0.0f;
        }
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "pid", str2);
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "adt", java.lang.Integer.valueOf(getAdType()));
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "toti", java.lang.Float.valueOf(f));
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "error", str);
        return jSONObject.toString();
    }

    private com.jd.ad.sdk.splash.jad_s_fs getTolerateWidget(float f) {
        com.jd.ad.sdk.splash.jad_s_fs jad_s_fsVar = new com.jd.ad.sdk.splash.jad_s_fs(f);
        jad_s_fsVar.jad_s_dq = this;
        return jad_s_fsVar;
    }

    private void initActLifeListener() {
        if (this.mAttachActivityHashCode != -1) {
            com.jd.ad.sdk.splash.JADSplash.jad_s_cp jad_s_cpVar = new com.jd.ad.sdk.splash.JADSplash.jad_s_cp();
            this.mLifeChangeListener = jad_s_cpVar;
            com.jd.ad.sdk.fdt.utils.ActLifecycle.addLifecycleListener(jad_s_cpVar);
        }
    }

    private void initInteractionListener() {
        this.mInteractionListener = new com.jd.ad.sdk.splash.JADSplash.jad_s_er();
    }

    private void notifyRender() {
        com.jd.ad.sdk.fdt.utils.HandlerUtils.runOnUiThread(new com.jd.ad.sdk.splash.JADSplash.jad_s_dq());
    }

    /* JADX INFO: Access modifiers changed from: private */
    @androidx.annotation.UiThread
    public void onAdClickCallback() {
        com.jd.ad.sdk.logger.Logger.d("seven_back=====onAdClickCallback====TYPE=" + getAdType());
        if (android.os.Looper.getMainLooper() != android.os.Looper.myLooper()) {
            com.jd.ad.sdk.logger.Logger.d("seven_back===thread error!!");
        }
        com.jd.ad.sdk.splash.JADSplashListener jADSplashListener = this.mJADListener;
        if (jADSplashListener != null) {
            jADSplashListener.onClick();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @androidx.annotation.UiThread
    public void onAdCloseCallback() {
        com.jd.ad.sdk.logger.Logger.d("seven_back=====onAdCloseCallback====TYPE=" + getAdType());
        if (android.os.Looper.getMainLooper() != android.os.Looper.myLooper()) {
            com.jd.ad.sdk.logger.Logger.d("seven_back===thread error!!");
        }
        com.jd.ad.sdk.splash.jad_s_fs jad_s_fsVar = this.mJADSplashTolerateManager;
        if (jad_s_fsVar != null) {
            jad_s_fsVar.jad_s_an();
        }
        com.jd.ad.sdk.splash.JADSplashListener jADSplashListener = this.mJADListener;
        if (jADSplashListener != null) {
            jADSplashListener.onClose();
        }
        this.mJADListener = null;
        destroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @androidx.annotation.UiThread
    public void onAdCountDownCallback(int i) {
        com.jd.ad.sdk.logger.Logger.d("seven_back=====onAdCountDownCallback====TYPE=" + getAdType());
        if (android.os.Looper.getMainLooper() != android.os.Looper.myLooper()) {
            com.jd.ad.sdk.logger.Logger.d("seven_back===thread error!!");
        }
        com.jd.ad.sdk.splash.JADSplashCountDownListener jADSplashCountDownListener = this.mJADCountDownListener;
        if (jADSplashCountDownListener != null) {
            jADSplashCountDownListener.onCountdown(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @androidx.annotation.UiThread
    public void onAdLoadCallback() {
        com.jd.ad.sdk.logger.Logger.d("seven_back=====onAdLoadCallback====TYPE=" + getAdType());
        if (android.os.Looper.getMainLooper() != android.os.Looper.myLooper()) {
            com.jd.ad.sdk.logger.Logger.w("The current thread is not the main thread!!", new java.lang.Object[0]);
        }
        com.jd.ad.sdk.splash.jad_s_fs jad_s_fsVar = this.mJADSplashTolerateManager;
        if (jad_s_fsVar != null) {
            jad_s_fsVar.jad_s_an = true;
        }
        com.jd.ad.sdk.splash.JADSplashListener jADSplashListener = this.mJADListener;
        if (jADSplashListener != null) {
            jADSplashListener.onLoadSuccess();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @androidx.annotation.UiThread
    public void onAdLoadFailedCallback(int i, java.lang.String str) {
        com.jd.ad.sdk.logger.Logger.d("seven_back=====onAdLoadFailedCallback====TYPE=" + getAdType() + ",code=" + i + ",error=" + str);
        if (android.os.Looper.getMainLooper() != android.os.Looper.myLooper()) {
            com.jd.ad.sdk.logger.Logger.d("seven_back===thread error!!");
        }
        com.jd.ad.sdk.splash.jad_s_fs jad_s_fsVar = this.mJADSplashTolerateManager;
        if (jad_s_fsVar != null) {
            jad_s_fsVar.jad_s_an();
        }
        if (this.mSlot != null) {
            com.jd.ad.sdk.mdt.servicemediator.JADMediator.getInstance().getAdService().printRequestData(this.mSlot);
        }
        if (android.text.TextUtils.isEmpty(str)) {
            str = com.jd.ad.sdk.dl.error.JADError.DEFAULT_ERROR.getMessage(new java.lang.String[0]);
        }
        com.jd.ad.sdk.splash.JADSplashListener jADSplashListener = this.mJADListener;
        if (jADSplashListener != null) {
            jADSplashListener.onLoadFailure(i, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @androidx.annotation.UiThread
    public void onAdRenderFailedCallback(int i, java.lang.String str) {
        com.jd.ad.sdk.logger.Logger.d("seven_back=====onAdRenderFailedCallback====TYPE=" + getAdType() + ",code=" + i + ",error=" + str);
        if (android.os.Looper.getMainLooper() != android.os.Looper.myLooper()) {
            com.jd.ad.sdk.logger.Logger.d("seven_back===thread error!!");
        }
        com.jd.ad.sdk.splash.jad_s_fs jad_s_fsVar = this.mJADSplashTolerateManager;
        if (jad_s_fsVar != null) {
            jad_s_fsVar.jad_s_an();
        }
        if (android.text.TextUtils.isEmpty(str)) {
            str = com.jd.ad.sdk.dl.error.JADError.DEFAULT_ERROR.getMessage(new java.lang.String[0]);
        }
        com.jd.ad.sdk.splash.JADSplashListener jADSplashListener = this.mJADListener;
        if (jADSplashListener != null) {
            jADSplashListener.onRenderFailure(i, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @androidx.annotation.UiThread
    public void onAdRenderSucCallback(android.view.View view) {
        com.jd.ad.sdk.logger.Logger.d("seven_back=====onAdRenderCallback====TYPE=" + getAdType());
        if (android.os.Looper.getMainLooper() != android.os.Looper.myLooper()) {
            com.jd.ad.sdk.logger.Logger.w("seven_back===thread error!!", new java.lang.Object[0]);
        }
        if (view != null) {
            if (view.getParent() instanceof android.view.ViewGroup) {
                ((android.view.ViewGroup) view.getParent()).removeView(view);
            }
            com.jd.ad.sdk.splash.jad_s_fs jad_s_fsVar = this.mJADSplashTolerateManager;
            if (jad_s_fsVar != null) {
                jad_s_fsVar.jad_s_an();
            }
            com.jd.ad.sdk.splash.JADSplashListener jADSplashListener = this.mJADListener;
            if (jADSplashListener != null) {
                jADSplashListener.onRenderSuccess(view);
                return;
            }
            return;
        }
        if (this.mSlot != null) {
            com.jd.ad.sdk.mdt.service.JADEventService eventService = com.jd.ad.sdk.mdt.servicemediator.JADMediator.getInstance().getEventService();
            java.lang.String requestId = this.mSlot.getRequestId();
            com.jd.ad.sdk.dl.error.JADError jADError = com.jd.ad.sdk.dl.error.JADError.RENDER_AD_VIEW_IS_NULL_ERROR;
            eventService.reportRenderFailedEvent(requestId, jADError.getCode(), jADError.getMessage(new java.lang.String[0]), this.mSlot.getSen());
        }
        com.jd.ad.sdk.splash.jad_s_fs jad_s_fsVar2 = this.mJADSplashTolerateManager;
        if (jad_s_fsVar2 != null) {
            jad_s_fsVar2.jad_s_an();
        }
        com.jd.ad.sdk.splash.JADSplashListener jADSplashListener2 = this.mJADListener;
        if (jADSplashListener2 != null) {
            com.jd.ad.sdk.dl.error.JADError jADError2 = com.jd.ad.sdk.dl.error.JADError.RENDER_AD_VIEW_IS_NULL_ERROR;
            jADSplashListener2.onRenderFailure(jADError2.getCode(), jADError2.getMessage(new java.lang.String[0]));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @androidx.annotation.UiThread
    public void onAdShowedCallback() {
        com.jd.ad.sdk.logger.Logger.d("seven_back=====onAdShowedCallback====TYPE=" + getAdType());
        if (android.os.Looper.getMainLooper() != android.os.Looper.myLooper()) {
            com.jd.ad.sdk.logger.Logger.d("seven_back===thread error!!");
        }
        com.jd.ad.sdk.splash.JADSplashListener jADSplashListener = this.mJADListener;
        if (jADSplashListener != null) {
            jADSplashListener.onExposure();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportClickEvent(int i, int i2, int i3, int i4) {
        com.jd.ad.sdk.dl.model.JADSlot jADSlot;
        if (i == -2 || (jADSlot = this.mSlot) == null) {
            return;
        }
        jADSlot.setClickTime(java.lang.System.currentTimeMillis());
        long clickTime = this.mSlot.getClickTime() - this.mSlot.getLoadTime();
        long clickTime2 = this.mSlot.getClickTime() - this.mSlot.getLoadSucTime();
        long clickTime3 = this.mSlot.getClickTime() - this.mSlot.getShowTime();
        if (this.mSlot.getAdDataRequestSourceType() == 1 || this.mSlot.getAdDataRequestSourceType() == 2) {
            com.jd.ad.sdk.mdt.servicemediator.JADMediator.getInstance().getEventService().reportPreloadClickEvent(this.mSlot.getRequestId(), this.mSlot.getSlotID(), getAdType(), this.mSlot.getTemplateId(), this.mSlot.getSen(), i2, i, clickTime, clickTime2, clickTime3, this.mSplashStylePlanType, this.mSplashClickAreaValue, this.mSlot.getEventInteractionType(), i4, this.mSlot.getModelClickAreaType(), this.dstp, this.srtp);
        } else {
            com.jd.ad.sdk.mdt.servicemediator.JADMediator.getInstance().getEventService().reportClickEvent(this.mSlot.getRequestId(), this.mSlot.getSlotID(), getAdType(), this.mSlot.getTemplateId(), this.mSlot.getSen(), i2, i, clickTime, clickTime2, clickTime3, this.mSplashStylePlanType, this.mSplashClickAreaValue, this.mSlot.getEventInteractionType(), i4, this.mSlot.getModelClickAreaType(), this.dstp, this.srtp);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportCloseEvent(int i) {
        com.jd.ad.sdk.dl.model.JADSlot jADSlot = this.mSlot;
        if (jADSlot == null) {
            return;
        }
        jADSlot.setClickTime(java.lang.System.currentTimeMillis());
        long clickTime = this.mSlot.getClickTime() - this.mSlot.getLoadTime();
        long clickTime2 = this.mSlot.getClickTime() - this.mSlot.getLoadSucTime();
        long clickTime3 = this.mSlot.getClickTime() - this.mSlot.getShowTime();
        if (this.mSlot.getAdDataRequestSourceType() == 1 || this.mSlot.getAdDataRequestSourceType() == 2) {
            com.jd.ad.sdk.mdt.servicemediator.JADMediator.getInstance().getEventService().reportPreloadCloseEvent(this.mSlot.getRequestId(), this.mSlot.getSlotID(), getAdType(), this.mSlot.getTemplateId(), this.mSlot.getSen(), this.mSlot.getRem(), -1, clickTime, clickTime2, clickTime3, this.mSplashStylePlanType, this.mSplashClickAreaValue, i, this.dstp, this.srtp);
        } else {
            com.jd.ad.sdk.mdt.servicemediator.JADMediator.getInstance().getEventService().reportCloseEvent(this.mSlot.getRequestId(), this.mSlot.getSlotID(), getAdType(), this.mSlot.getTemplateId(), this.mSlot.getSen(), this.mSlot.getRem(), -1, clickTime, clickTime2, clickTime3, this.mSplashStylePlanType, this.mSplashClickAreaValue, i, this.dstp, this.srtp);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportDelayExposureEvent(java.lang.String str, int i, int i2) {
        com.jd.ad.sdk.dl.model.JADSlot jADSlot = this.mSlot;
        if (jADSlot == null) {
            return;
        }
        jADSlot.setDelayShowTime(java.lang.System.currentTimeMillis());
        long delayShowTime = this.mSlot.getDelayShowTime() - this.mSlot.getLoadTime();
        long delayShowTime2 = this.mSlot.getDelayShowTime() - this.mSlot.getLoadSucTime();
        this.mSlot.setSedu(delayShowTime);
        this.mSlot.setDedu(delayShowTime2);
        this.mSlot.setSspt(this.mSplashStylePlanType);
        this.mSlot.setScav(this.mSplashClickAreaValue);
        this.mSlot.setExposureExtend(str);
        this.mSlot.setDstp(this.dstp);
        this.mSlot.setSrtp(this.srtp);
        int eventInteractionType = this.mSlot.getEventInteractionType();
        int modelClickAreaType = this.mSlot.getModelClickAreaType();
        if (this.mSlot.getAdDataRequestSourceType() == 1 || this.mSlot.getAdDataRequestSourceType() == 2) {
            com.jd.ad.sdk.mdt.servicemediator.JADMediator.getInstance().getEventService().reportPreloadExposureEvent(this.mSlot.getRequestId(), this.mSlot.getSlotID(), getAdType(), this.mSlot.getTemplateId(), this.mSlot.getSen(), i2, i, delayShowTime, delayShowTime2, this.mSplashStylePlanType, this.mSplashClickAreaValue, eventInteractionType, modelClickAreaType, str, this.dstp, this.srtp);
        } else {
            com.jd.ad.sdk.mdt.servicemediator.JADMediator.getInstance().getEventService().reportExposureEvent(this.mSlot.getRequestId(), this.mSlot.getSlotID(), getAdType(), this.mSlot.getTemplateId(), this.mSlot.getSen(), i2, i, delayShowTime, delayShowTime2, this.mSplashStylePlanType, this.mSplashClickAreaValue, eventInteractionType, modelClickAreaType, str, this.dstp, this.srtp);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportExposureEvent(java.lang.String str, int i, int i2) {
        com.jd.ad.sdk.dl.model.JADSlot jADSlot = this.mSlot;
        if (jADSlot == null) {
            return;
        }
        jADSlot.setShowTime(java.lang.System.currentTimeMillis());
        long showTime = this.mSlot.getShowTime() - this.mSlot.getLoadTime();
        long showTime2 = this.mSlot.getShowTime() - this.mSlot.getLoadSucTime();
        this.mSlot.setSedu(showTime);
        this.mSlot.setDedu(showTime2);
        this.mSlot.setSspt(this.mSplashStylePlanType);
        this.mSlot.setScav(this.mSplashClickAreaValue);
        this.mSlot.setExposureExtend(str);
        this.mSlot.setDstp(this.dstp);
        this.mSlot.setSrtp(this.srtp);
        int eventInteractionType = this.mSlot.getEventInteractionType();
        int modelClickAreaType = this.mSlot.getModelClickAreaType();
        if (this.mSlot.getAdDataRequestSourceType() == 1 || this.mSlot.getAdDataRequestSourceType() == 2) {
            com.jd.ad.sdk.mdt.servicemediator.JADMediator.getInstance().getEventService().reportPreloadExposureEvent(this.mSlot.getRequestId(), this.mSlot.getSlotID(), getAdType(), this.mSlot.getTemplateId(), this.mSlot.getSen(), i2, i, showTime, showTime2, this.mSplashStylePlanType, this.mSplashClickAreaValue, eventInteractionType, modelClickAreaType, str, this.dstp, this.srtp);
        } else {
            com.jd.ad.sdk.mdt.servicemediator.JADMediator.getInstance().getEventService().reportExposureEvent(this.mSlot.getRequestId(), this.mSlot.getSlotID(), getAdType(), this.mSlot.getTemplateId(), this.mSlot.getSen(), i2, i, showTime, showTime2, this.mSplashStylePlanType, this.mSplashClickAreaValue, eventInteractionType, modelClickAreaType, str, this.dstp, this.srtp);
        }
    }

    private void reportRenderSuccessEvent() {
        long j;
        com.jd.ad.sdk.dl.model.JADSlot jADSlot = this.mSlot;
        if (jADSlot == null) {
            return;
        }
        jADSlot.setRenderSucTime(java.lang.System.currentTimeMillis());
        long renderSucTime = this.mSlot.getRenderSucTime() - this.mSlot.getLoadTime();
        long dynamicRenderViewInitSuccessTime = this.mSlot.getDynamicRenderViewInitSuccessTime();
        if (dynamicRenderViewInitSuccessTime > 0) {
            long loadTime = dynamicRenderViewInitSuccessTime - this.mSlot.getLoadTime();
            com.jd.ad.sdk.logger.Logger.d("dynamic render view init time:" + loadTime);
            j = loadTime;
        } else {
            j = 0;
        }
        if (this.mSlot.getAdDataRequestSourceType() == 1 || this.mSlot.getAdDataRequestSourceType() == 2) {
            com.jd.ad.sdk.mdt.servicemediator.JADMediator.getInstance().getEventService().reportPreloadRenderSuccessEvent(this.mSlot.getRequestId(), this.mSlot.getSlotID(), getAdType(), this.mSlot.getTemplateId(), this.mSlot.getSen(), this.mSlot.getRem(), renderSucTime, j, this.mSlot.getEventInteractionType(), this.mSlot.getModelClickAreaType(), this.mSlot.getMediaSpecSetType(), this.dstp, this.srtp);
        } else {
            com.jd.ad.sdk.mdt.servicemediator.JADMediator.getInstance().getEventService().reportRenderSuccessEvent(this.mSlot.getRequestId(), this.mSlot.getSlotID(), getAdType(), this.mSlot.getTemplateId(), this.mSlot.getSen(), this.mSlot.getRem(), renderSucTime, j, this.mSlot.getEventInteractionType(), this.mSlot.getModelClickAreaType(), this.mSlot.getMediaSpecSetType(), this.dstp, this.srtp);
        }
    }

    private void startPreloadAdDataTimeCounter() {
        com.jd.ad.sdk.bl.preload.PreloadAdDataCacheUsageManager preloadAdDataCacheUsageManager = new com.jd.ad.sdk.bl.preload.PreloadAdDataCacheUsageManager();
        preloadAdDataCacheUsageManager.setCounterFinishCallback(this);
        preloadAdDataCacheUsageManager.startPreloadAdDataCacheUsageTimeCounter();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startRender() {
        com.jd.ad.sdk.dl.model.JADSlot jADSlot;
        int i;
        this.mSplashAdRender = new com.jd.ad.sdk.splash.jad_s_an(getAppContext(), this.mSlot, this.mInstanceId, getImageUrl());
        initInteractionListener();
        com.jd.ad.sdk.splash.jad_s_an jad_s_anVar = this.mSplashAdRender;
        jad_s_anVar.jad_s_hu = this.mInteractionListener;
        com.jd.ad.sdk.splash.JADSplashCountDownListener jADSplashCountDownListener = this.mJADCountDownListener;
        if (jADSplashCountDownListener != null) {
            jad_s_anVar.jad_s_ly = jADSplashCountDownListener;
        }
        com.jd.ad.sdk.splash.JADSplashVideoListener jADSplashVideoListener = this.mJADSplashVideoListener;
        if (jADSplashVideoListener != null) {
            jad_s_anVar.jad_s_mz = jADSplashVideoListener;
        }
        com.jd.ad.sdk.splash.jad_s_fs jad_s_fsVar = this.mJADSplashTolerateManager;
        if (jad_s_fsVar != null) {
            this.mRemainTolerateTime = (long) ((jad_s_fsVar.jad_s_bo * 1000.0f) - (java.lang.System.currentTimeMillis() - jad_s_fsVar.jad_s_er));
        }
        com.jd.ad.sdk.splash.jad_s_an jad_s_anVar2 = this.mSplashAdRender;
        jad_s_anVar2.jad_s_qd = this.mRemainTolerateTime;
        if (jad_s_anVar2.jad_s_bo == null) {
            com.jd.ad.sdk.mdt.service.JADEventService eventService = com.jd.ad.sdk.mdt.servicemediator.JADMediator.getInstance().getEventService();
            java.lang.String str = jad_s_anVar2.jad_s_er;
            com.jd.ad.sdk.dl.error.JADError jADError = com.jd.ad.sdk.dl.error.JADError.RENDER_CREATE_AD_VIEW_FAIL_ERROR;
            eventService.reportRenderFailedEvent(str, jADError.getCode(), jADError.getMessage(new java.lang.String[0]), jad_s_anVar2.jad_s_fs);
            jad_s_anVar2.jad_s_an(jADError.getCode(), jADError.getMessage(new java.lang.String[0]));
            return;
        }
        if (jad_s_anVar2.jad_s_an() == null) {
            com.jd.ad.sdk.mdt.service.JADEventService eventService2 = com.jd.ad.sdk.mdt.servicemediator.JADMediator.getInstance().getEventService();
            java.lang.String str2 = jad_s_anVar2.jad_s_er;
            com.jd.ad.sdk.dl.error.JADError jADError2 = com.jd.ad.sdk.dl.error.JADError.RENDER_CREATE_AD_VIEW_FAIL_ERROR;
            eventService2.reportRenderFailedEvent(str2, jADError2.getCode(), jADError2.getMessage(new java.lang.String[0]), jad_s_anVar2.jad_s_fs);
            jad_s_anVar2.jad_s_an(jADError2.getCode(), jADError2.getMessage(new java.lang.String[0]));
            return;
        }
        if (jad_s_anVar2.jad_s_bo.getMediaSpecSetType() != 10009) {
            android.content.Context jad_s_an2 = jad_s_anVar2.jad_s_an();
            com.jd.ad.sdk.dl.error.JADError jADError3 = com.jd.ad.sdk.dl.error.JADError.RENDER_CREATE_AD_VIEW_FAIL_ERROR;
            int code = jADError3.getCode();
            java.lang.String message = jADError3.getMessage(new java.lang.String[0]);
            if (jad_s_an2 == null || (jADSlot = jad_s_anVar2.jad_s_bo) == null) {
                com.jd.ad.sdk.mdt.servicemediator.JADMediator.getInstance().getEventService().reportRenderFailedEvent(jad_s_anVar2.jad_s_er, code, message, jad_s_anVar2.jad_s_fs);
                jad_s_anVar2.jad_s_an(code, message);
                return;
            }
            if (jADSlot.getDynamicRenderTemplateHelper() == null) {
                jad_s_anVar2.onDynamicRenderFailed(code, message);
                return;
            }
            try {
                if (com.jd.ad.sdk.mdt.servicemediator.JADMediator.getInstance().getDynamicRenderService().createDynamicView(jad_s_an2, jad_s_anVar2.jad_s_dq, jad_s_anVar2.jad_s_bo, jad_s_anVar2) == null) {
                    com.jd.ad.sdk.dl.error.JADError jADError4 = com.jd.ad.sdk.dl.error.JADError.RENDER_IMAGE_LOAD_FAIL_ERROR;
                    jad_s_anVar2.onDynamicRenderFailed(jADError4.getCode(), jADError4.getMessage(new java.lang.String[0]));
                } else {
                    jad_s_anVar2.jad_s_bo.setDynamicRenderViewInitSuccessTime(java.lang.System.currentTimeMillis());
                    jad_s_anVar2.jad_s_bo.setRem(3);
                }
                return;
            } catch (java.lang.Throwable th) {
                try {
                    java.lang.Exception exc = new java.lang.Exception("dynamic render view init error", th);
                    org.json.JSONObject jad_s_an3 = jad_s_anVar2.jad_s_an(exc);
                    int optInt = jad_s_an3.optInt("code");
                    com.jd.ad.sdk.mdt.servicemediator.JADMediator.getInstance().getEventService().reportRenderFailedEvent(jad_s_anVar2.jad_s_er, optInt, jad_s_an3.optString("msg"), jad_s_anVar2.jad_s_fs);
                    com.jd.ad.sdk.logger.Logger.d(optInt + ": " + android.util.Log.getStackTraceString(exc));
                } catch (java.lang.Exception e) {
                    com.jd.ad.sdk.logger.Logger.d(android.util.Log.getStackTraceString(e));
                }
                jad_s_anVar2.onDynamicRenderFailed(code, message);
                return;
            }
        }
        jad_s_anVar2.jad_s_ob = true;
        android.content.Context jad_s_an4 = jad_s_anVar2.jad_s_an();
        com.jd.ad.sdk.dl.error.JADError jADError5 = com.jd.ad.sdk.dl.error.JADError.RENDER_CREATE_AD_VIEW_FAIL_ERROR;
        int code2 = jADError5.getCode();
        java.lang.String message2 = jADError5.getMessage(new java.lang.String[0]);
        if (jad_s_an4 == null || jad_s_anVar2.jad_s_bo == null) {
            com.jd.ad.sdk.mdt.servicemediator.JADMediator.getInstance().getEventService().reportRenderFailedEvent(jad_s_anVar2.jad_s_er, code2, message2, jad_s_anVar2.jad_s_fs);
            jad_s_anVar2.jad_s_an(code2, message2);
            return;
        }
        try {
            if (jad_s_anVar2.jad_s_wj == null) {
                jad_s_anVar2.jad_s_wj = new com.jd.ad.sdk.jad_s_an.jad_s_cp(jad_s_anVar2);
            }
            if (jad_s_anVar2.jad_s_xk == null) {
                jad_s_anVar2.jad_s_xk = new com.jd.ad.sdk.jad_s_an.jad_s_dq(jad_s_anVar2);
            }
            i = code2;
            try {
                if (com.jd.ad.sdk.mdt.servicemediator.JADMediator.getInstance().getVideoRenderService().createVideoRendView(jad_s_an4, jad_s_anVar2.jad_s_dq, jad_s_anVar2.jad_s_bo, jad_s_anVar2.jad_s_qd, jad_s_anVar2.jad_s_wj, jad_s_anVar2.jad_s_xk) == null) {
                    com.jd.ad.sdk.dl.error.JADError jADError6 = com.jd.ad.sdk.dl.error.JADError.RENDER_VIDEO_FAIL_ERROR;
                    jad_s_anVar2.jad_s_bo(jADError6.getCode(), jADError6.getMessage(new java.lang.String[0]));
                } else {
                    jad_s_anVar2.jad_s_bo.setRem(1);
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
                try {
                    java.lang.Exception exc2 = new java.lang.Exception("video render view init error", th);
                    org.json.JSONObject jad_s_an5 = jad_s_anVar2.jad_s_an(exc2);
                    int optInt2 = jad_s_an5.optInt("code");
                    com.jd.ad.sdk.mdt.servicemediator.JADMediator.getInstance().getEventService().reportRenderFailedEvent(jad_s_anVar2.jad_s_er, optInt2, jad_s_an5.optString("msg"), jad_s_anVar2.jad_s_fs);
                    com.jd.ad.sdk.logger.Logger.d(optInt2 + ": " + android.util.Log.getStackTraceString(exc2));
                } catch (java.lang.Exception e2) {
                    com.jd.ad.sdk.logger.Logger.d(android.util.Log.getStackTraceString(e2));
                }
                jad_s_anVar2.jad_s_bo(i, message2);
            }
        } catch (java.lang.Throwable th3) {
            th = th3;
            i = code2;
        }
    }

    public void bindActivity(android.app.Activity activity) {
        if (activity != null) {
            this.mAttachActivityHashCode = activity.hashCode();
        }
    }

    public void destroy() {
        com.jd.ad.sdk.splash.jad_s_an jad_s_anVar = this.mSplashAdRender;
        if (jad_s_anVar != null) {
            try {
                com.jd.ad.sdk.mdt.servicemediator.JADMediator.getInstance().getTouchService().unregisterTouchView(jad_s_anVar.jad_s_dq);
                com.jd.ad.sdk.mdt.servicemediator.JADMediator.getInstance().getExposureService().unregisterExposureView(jad_s_anVar.jad_s_dq);
                if (jad_s_anVar.jad_s_cp() != null) {
                    jad_s_anVar.jad_s_cp().destroy();
                }
                android.view.View view = jad_s_anVar.jad_s_jt;
                if (((view == null || !(view instanceof com.jd.ad.sdk.bl.video.VideoRenderView)) ? null : (com.jd.ad.sdk.bl.video.VideoRenderView) view) != null) {
                    ((view == null || !(view instanceof com.jd.ad.sdk.bl.video.VideoRenderView)) ? null : (com.jd.ad.sdk.bl.video.VideoRenderView) view).destroy();
                }
                android.os.Handler handler = jad_s_anVar.jad_s_uh;
                if (handler != null) {
                    handler.removeCallbacksAndMessages(null);
                    jad_s_anVar.jad_s_uh = null;
                }
                jad_s_anVar.jad_s_jt = null;
                jad_s_anVar.jad_s_iv = null;
                jad_s_anVar.jad_s_hu = null;
            } catch (java.lang.Exception e) {
                com.jd.ad.sdk.logger.Logger.w("Exception while destroy: " + e.getMessage(), new java.lang.Object[0]);
            }
            this.mSplashAdRender = null;
        }
        this.mJADListener = null;
        if (this.mInteractionListener != null) {
            this.mInteractionListener = null;
        }
        com.jd.ad.sdk.mdt.servicemediator.JADMediator.getInstance().getAdService().removeData(this.mInstanceId);
        com.jd.ad.sdk.mdt.servicemediator.JADMediator.getInstance().getAdService().unregisterAd(this.mInstanceId);
        com.jd.ad.sdk.fdt.utils.ActLifecycle.OnLifecycleChangeListener onLifecycleChangeListener = this.mLifeChangeListener;
        if (onLifecycleChangeListener != null) {
            com.jd.ad.sdk.fdt.utils.ActLifecycle.removeLifecycleListener(onLifecycleChangeListener);
            this.mLifeChangeListener = null;
        }
    }

    public java.lang.String getErin(java.lang.String str) {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        com.jd.ad.sdk.dl.model.JADSlot jADSlot = this.mSlot;
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "pid", jADSlot != null ? jADSlot.getSlotID() : "");
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "adt", java.lang.Integer.valueOf(getAdType()));
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "error", str);
        return jSONObject.toString();
    }

    public final com.jd.ad.sdk.dl.model.IJADExtra getJADExtra() {
        return com.jd.ad.sdk.mdt.servicemediator.JADMediator.getInstance().getAdService().getJADExtra(this.mInstanceId);
    }

    @androidx.annotation.Nullable
    public com.jd.ad.sdk.dl.addata.JADMaterialData getJADMaterialData() {
        java.util.List<com.jd.ad.sdk.dl.addata.JADMaterialData> jADMaterialDataList = com.jd.ad.sdk.mdt.servicemediator.JADMediator.getInstance().getAdService().getJADMaterialDataList(this.mInstanceId);
        if (jADMaterialDataList == null || jADMaterialDataList.isEmpty() || jADMaterialDataList.get(0) == null) {
            return null;
        }
        return jADMaterialDataList.get(0);
    }

    public boolean isMaterialMetaPreload() {
        com.jd.ad.sdk.splash.jad_s_an jad_s_anVar = this.mSplashAdRender;
        if (jad_s_anVar != null) {
            return jad_s_anVar.jad_s_na;
        }
        return false;
    }

    public boolean isMaterialMetaVideo() {
        com.jd.ad.sdk.splash.jad_s_an jad_s_anVar = this.mSplashAdRender;
        if (jad_s_anVar != null) {
            return jad_s_anVar.jad_s_ob;
        }
        return false;
    }

    public final void loadAd(com.jd.ad.sdk.splash.JADSplashListener jADSplashListener) {
        android.os.Handler handler;
        this.mJADListener = jADSplashListener;
        java.lang.String uuid = com.jd.ad.sdk.fdt.utils.UUIDUtils.uuid();
        if (this.mSlot == null) {
            com.jd.ad.sdk.mdt.service.JADEventService eventService = com.jd.ad.sdk.mdt.servicemediator.JADMediator.getInstance().getEventService();
            com.jd.ad.sdk.dl.error.JADError jADError = com.jd.ad.sdk.dl.error.JADError.GW_REQUEST_SLOT_IS_NULL_ERROR;
            eventService.reportRequestErrorEvent(uuid, jADError.getCode(), getErin(jADError.getMessage(new java.lang.String[0])));
            callbackAdLoadFailedOnUiThread(jADError.getCode(), jADError.getMessage(new java.lang.String[0]));
            return;
        }
        com.jd.ad.sdk.splash.jad_s_fs jad_s_fsVar = this.mJADSplashTolerateManager;
        if (jad_s_fsVar != null && (handler = jad_s_fsVar.jad_s_cp) != null) {
            handler.sendEmptyMessageDelayed(1, (long) (jad_s_fsVar.jad_s_bo * 1000.0f));
            jad_s_fsVar.jad_s_er = java.lang.System.currentTimeMillis();
        }
        startPreloadAdDataTimeCounter();
        this.mSlot.setRequestId(uuid);
        this.mSlot.setLoadTime(java.lang.System.currentTimeMillis());
        this.mSlot.setAdType(getAdType());
        this.mSlot.setDisplayScene(getDisplayScene());
        this.mSlot.setFromNativeAd(false);
        this.mSlot.setAdDataRequestSourceType(0);
        com.jd.ad.sdk.mdt.servicemediator.JADMediator.getInstance().getAdService().loadAd(this.mInstanceId, this.mSlot, this);
    }

    @Override // com.jd.ad.sdk.splash.jad_s_fs.jad_s_an
    public void onCounterFinish() {
        java.lang.String str;
        int i;
        if (this.mJADSplashTolerateManager != null) {
            com.jd.ad.sdk.dl.model.JADSlot jADSlot = this.mSlot;
            if (jADSlot != null) {
                str = jADSlot.getRequestId();
                i = this.mSlot.getSen();
            } else {
                str = "";
                i = 0;
            }
            if (this.mJADSplashTolerateManager.jad_s_an) {
                com.jd.ad.sdk.mdt.service.JADEventService eventService = com.jd.ad.sdk.mdt.servicemediator.JADMediator.getInstance().getEventService();
                com.jd.ad.sdk.dl.error.JADError jADError = com.jd.ad.sdk.dl.error.JADError.RENDER_TOLERATE_TIME_ERROR;
                eventService.reportRenderFailedEvent(str, jADError.getCode(), getTolerateTimeFinishErin(jADError.getMessage(new java.lang.String[0])), i);
                onAdRenderFailedCallback(jADError.getCode(), getTolerateTimeFinishErin(jADError.getMessage(new java.lang.String[0])));
            } else {
                com.jd.ad.sdk.mdt.service.JADEventService eventService2 = com.jd.ad.sdk.mdt.servicemediator.JADMediator.getInstance().getEventService();
                com.jd.ad.sdk.dl.error.JADError jADError2 = com.jd.ad.sdk.dl.error.JADError.GW_RESPONSE_TOLERATE_TIME_ERROR;
                eventService2.reportRequestErrorEvent(str, jADError2.getCode(), getTolerateTimeFinishErin(jADError2.getMessage(new java.lang.String[0])));
                onAdLoadFailedCallback(jADError2.getCode(), getTolerateTimeFinishErin(jADError2.getMessage(new java.lang.String[0])));
            }
            this.mJADListener = null;
        }
    }

    @Override // com.jd.ad.sdk.bl.adload.JADAdLoadListener
    public void onLoadFailure(int i, java.lang.String str) {
        com.jd.ad.sdk.dl.model.JADSlot jADSlot = this.mSlot;
        if (jADSlot == null || jADSlot.getAdDataRequestSourceType() != 1) {
            callbackAdLoadFailedOnUiThread(i, str);
        } else {
            doAfterPreloadFinished();
        }
    }

    @Override // com.jd.ad.sdk.bl.adload.JADAdLoadListener
    public void onLoadSuccess() {
        com.jd.ad.sdk.dl.model.JADSlot jADSlot = this.mSlot;
        if (jADSlot != null && jADSlot.getAdDataRequestSourceType() == 1) {
            doAfterPreloadFinished();
        } else {
            callbackAdLoadOnUiThread();
            notifyRender();
        }
    }

    @Override // com.jd.ad.sdk.bl.preload.PreloadAdDataCacheUsageManager.UseCacheCounterFinishCallback
    public void onUseCacheCounterFinish() {
        com.jd.ad.sdk.mdt.servicemediator.JADMediator.getInstance().getAdService().loadAdFromCache(this.mInstanceId, this.mSlot, this);
    }

    public void onUserCancelJdJump() {
        com.jd.ad.sdk.splash.jad_s_an jad_s_anVar = this.mSplashAdRender;
        if (jad_s_anVar == null || com.jd.ad.sdk.mdt.servicemediator.JADMediator.getInstance().getInitService().isForbidModelToH5()) {
            return;
        }
        if (com.jd.ad.sdk.mdt.servicemediator.JADMediator.getInstance().getInitService().getNeedCheckMediaClickH5() != 1) {
            if (jad_s_anVar.jad_s_uh == null) {
                jad_s_anVar.jad_s_uh = new android.os.Handler(android.os.Looper.getMainLooper());
            }
            jad_s_anVar.jad_s_uh.postDelayed(new com.jd.ad.sdk.splash.jad_s_bo(jad_s_anVar), com.jd.ad.sdk.mdt.servicemediator.JADMediator.getInstance().getInitService().getJumpToH5DelayTime());
            return;
        }
        int onUserCancelJdJump = com.jd.ad.sdk.mdt.servicemediator.JADMediator.getInstance().getTouchService().onUserCancelJdJump(jad_s_anVar.jad_s_an(), jad_s_anVar.jad_s_dq);
        com.jd.ad.sdk.splash.jad_s_an.jad_s_cp jad_s_cpVar = jad_s_anVar.jad_s_hu;
        if (jad_s_cpVar != null) {
            com.jd.ad.sdk.splash.JADSplash.this.reportClickEvent(onUserCancelJdJump, jad_s_anVar.jad_s_tg, jad_s_anVar.jad_s_re, jad_s_anVar.jad_s_sf);
        }
    }

    public void preloadAd() {
        java.lang.String uuid = com.jd.ad.sdk.fdt.utils.UUIDUtils.uuid();
        com.jd.ad.sdk.dl.model.JADSlot jADSlot = this.mSlot;
        if (jADSlot == null) {
            com.jd.ad.sdk.mdt.service.JADEventService eventService = com.jd.ad.sdk.mdt.servicemediator.JADMediator.getInstance().getEventService();
            com.jd.ad.sdk.dl.error.JADError jADError = com.jd.ad.sdk.dl.error.JADError.GW_REQUEST_SLOT_IS_NULL_ERROR;
            eventService.reportRequestErrorEvent(uuid, jADError.getCode(), getErin(jADError.getMessage(new java.lang.String[0])));
            return;
        }
        jADSlot.setRequestId(uuid);
        this.mSlot.setLoadTime(java.lang.System.currentTimeMillis());
        this.mSlot.setAdType(getAdType());
        this.mSlot.setDisplayScene(getDisplayScene());
        this.mSlot.setFromNativeAd(false);
        this.mSlot.setAdDataRequestSourceType(1);
        com.jd.ad.sdk.mdt.servicemediator.JADMediator.getInstance().getAdService().loadAd(this.mInstanceId, this.mSlot, this);
    }

    public final void removeSplashView() {
        com.jd.ad.sdk.splash.jad_s_an jad_s_anVar = this.mSplashAdRender;
        if (jad_s_anVar != null) {
            com.jd.ad.sdk.fdt.utils.HandlerUtils.runOnUiThread(new com.jd.ad.sdk.splash.jad_s_dq(jad_s_anVar));
        }
    }

    public void setCountDownListener(com.jd.ad.sdk.splash.JADSplashCountDownListener jADSplashCountDownListener) {
        this.mJADCountDownListener = jADSplashCountDownListener;
    }

    public void setSplashVideoListener(com.jd.ad.sdk.splash.JADSplashVideoListener jADSplashVideoListener) {
        this.mJADSplashVideoListener = jADSplashVideoListener;
    }
}
