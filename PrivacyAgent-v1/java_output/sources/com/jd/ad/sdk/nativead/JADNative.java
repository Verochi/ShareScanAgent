package com.jd.ad.sdk.nativead;

/* loaded from: classes23.dex */
public class JADNative implements com.jd.ad.sdk.bl.adload.IJADBase {
    private java.lang.ref.WeakReference<android.app.Activity> mActivityRef;
    private com.jd.ad.sdk.jad_n_an.jad_n_iv mAdViewController;
    private java.lang.String mInstanceId;
    private com.jd.ad.sdk.dl.model.IJADExtra mJADExtra;
    private com.jd.ad.sdk.nativead.JADNativeLoadListener mLoadListener;
    private java.util.List<com.jd.ad.sdk.dl.addata.JADMaterialData> mMaterialDataList;
    private final com.jd.ad.sdk.dl.model.JADSlot mSlot;
    private com.jd.ad.sdk.dl.event.JADVideoReporter mVideoReporter;

    public class jad_n_an implements com.jd.ad.sdk.bl.adload.JADAdLoadListener {
        public jad_n_an() {
        }

        @Override // com.jd.ad.sdk.bl.adload.JADAdLoadListener
        public void onLoadFailure(int i, java.lang.String str) {
            com.jd.ad.sdk.nativead.JADNative jADNative = com.jd.ad.sdk.nativead.JADNative.this;
            jADNative.callbackAdLoadFailedOnUiThread(jADNative.mLoadListener, i, str);
        }

        @Override // com.jd.ad.sdk.bl.adload.JADAdLoadListener
        public void onLoadSuccess() {
            com.jd.ad.sdk.nativead.JADNative jADNative = com.jd.ad.sdk.nativead.JADNative.this;
            jADNative.callbackAdLoadOnUiThread(jADNative.mLoadListener);
        }
    }

    public class jad_n_bo implements java.lang.Runnable {
        public final /* synthetic */ com.jd.ad.sdk.nativead.JADNativeLoadListener jad_n_an;

        public jad_n_bo(com.jd.ad.sdk.nativead.JADNativeLoadListener jADNativeLoadListener) {
            this.jad_n_an = jADNativeLoadListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.jd.ad.sdk.nativead.JADNative.this.onAdLoadCallback(this.jad_n_an);
        }
    }

    public class jad_n_cp implements java.lang.Runnable {
        public final /* synthetic */ com.jd.ad.sdk.nativead.JADNativeLoadListener jad_n_an;
        public final /* synthetic */ int jad_n_bo;
        public final /* synthetic */ java.lang.String jad_n_cp;

        public jad_n_cp(com.jd.ad.sdk.nativead.JADNativeLoadListener jADNativeLoadListener, int i, java.lang.String str) {
            this.jad_n_an = jADNativeLoadListener;
            this.jad_n_bo = i;
            this.jad_n_cp = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.jd.ad.sdk.nativead.JADNative.this.onAdLoadFailedCallback(this.jad_n_an, this.jad_n_bo, this.jad_n_cp);
        }
    }

    public JADNative(@androidx.annotation.NonNull com.jd.ad.sdk.dl.model.JADSlot jADSlot) {
        this.mInstanceId = "";
        this.mInstanceId = com.jd.ad.sdk.fdt.utils.UUIDUtils.uuid();
        com.jd.ad.sdk.mdt.servicemediator.JADMediator.getInstance().getAdService().registerAd(this.mInstanceId);
        com.jd.ad.sdk.mdt.servicemediator.JADMediator.getInstance().getInitService().createDefaultAdInstance(jADSlot);
        this.mSlot = jADSlot;
        this.mAdViewController = new com.jd.ad.sdk.jad_n_an.jad_n_iv();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callbackAdLoadFailedOnUiThread(com.jd.ad.sdk.nativead.JADNativeLoadListener jADNativeLoadListener, int i, java.lang.String str) {
        com.jd.ad.sdk.fdt.utils.HandlerUtils.runOnUiThread(new com.jd.ad.sdk.nativead.JADNative.jad_n_cp(jADNativeLoadListener, i, str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callbackAdLoadOnUiThread(com.jd.ad.sdk.nativead.JADNativeLoadListener jADNativeLoadListener) {
        com.jd.ad.sdk.fdt.utils.HandlerUtils.runOnUiThread(new com.jd.ad.sdk.nativead.JADNative.jad_n_bo(jADNativeLoadListener));
    }

    private int getRenderMode() {
        return 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onAdLoadCallback(com.jd.ad.sdk.nativead.JADNativeLoadListener jADNativeLoadListener) {
        if (jADNativeLoadListener != null) {
            jADNativeLoadListener.onLoadSuccess();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onAdLoadFailedCallback(com.jd.ad.sdk.nativead.JADNativeLoadListener jADNativeLoadListener, int i, java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            str = com.jd.ad.sdk.dl.error.JADError.DEFAULT_ERROR.getMessage(new java.lang.String[0]);
        }
        if (jADNativeLoadListener != null) {
            jADNativeLoadListener.onLoadFailure(i, str);
        }
    }

    public void destroy() {
        com.jd.ad.sdk.jad_n_an.jad_n_iv jad_n_ivVar = this.mAdViewController;
        if (jad_n_ivVar != null) {
            jad_n_ivVar.jad_n_an();
            this.mAdViewController = null;
        }
        java.util.List<com.jd.ad.sdk.dl.addata.JADMaterialData> list = this.mMaterialDataList;
        if (list != null && list.size() > 0) {
            this.mMaterialDataList.clear();
            this.mMaterialDataList = null;
        }
        if (this.mVideoReporter != null) {
            this.mVideoReporter = null;
        }
        com.jd.ad.sdk.mdt.servicemediator.JADMediator.getInstance().getAdService().removeData(this.mInstanceId);
        com.jd.ad.sdk.mdt.servicemediator.JADMediator.getInstance().getAdService().unregisterAd(this.mInstanceId);
    }

    @androidx.annotation.Nullable
    public android.app.Activity getActivity() {
        java.lang.ref.WeakReference<android.app.Activity> weakReference = this.mActivityRef;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @androidx.annotation.Nullable
    public java.util.List<com.jd.ad.sdk.dl.addata.JADMaterialData> getDataList() {
        java.util.List<com.jd.ad.sdk.dl.addata.JADMaterialData> list = this.mMaterialDataList;
        if (list == null || list.size() == 0) {
            this.mMaterialDataList = com.jd.ad.sdk.mdt.servicemediator.JADMediator.getInstance().getAdService().getJADMaterialDataList(this.mInstanceId);
        }
        return this.mMaterialDataList;
    }

    public int getDisplayScene(int i) {
        if (i == 1) {
            return 4;
        }
        if (i == 2) {
            return 64;
        }
        if (i != 4) {
            return i != 5 ? 0 : 1;
        }
        return 2;
    }

    public java.lang.String getErin(@androidx.annotation.NonNull java.lang.String str, int i, @androidx.annotation.NonNull java.lang.String str2) {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "pid", str);
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "adt", java.lang.Integer.valueOf(i));
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "error", str2);
        return jSONObject.toString();
    }

    public java.lang.String getInstanceId() {
        return this.mInstanceId;
    }

    @androidx.annotation.NonNull
    public com.jd.ad.sdk.dl.model.IJADExtra getJADExtra() {
        if (this.mJADExtra == null) {
            this.mJADExtra = com.jd.ad.sdk.mdt.servicemediator.JADMediator.getInstance().getAdService().getJADExtra(this.mInstanceId);
        }
        return this.mJADExtra;
    }

    public com.jd.ad.sdk.dl.event.JADVideoReporter getJADVideoReporter() {
        if (this.mVideoReporter == null) {
            this.mVideoReporter = new com.jd.ad.sdk.jad_n_an.jad_n_dq(this.mSlot);
        }
        return this.mVideoReporter;
    }

    public int getMediaSpecSetType() {
        return this.mSlot.getMediaSpecSetType();
    }

    public com.jd.ad.sdk.dl.model.JADSlot getSlot() {
        return this.mSlot;
    }

    public void loadAd(@androidx.annotation.NonNull com.jd.ad.sdk.nativead.JADNativeLoadListener jADNativeLoadListener) {
        this.mLoadListener = jADNativeLoadListener;
        java.lang.String uuid = com.jd.ad.sdk.fdt.utils.UUIDUtils.uuid();
        com.jd.ad.sdk.dl.model.JADSlot jADSlot = this.mSlot;
        if (jADSlot == null) {
            com.jd.ad.sdk.mdt.service.JADEventService eventService = com.jd.ad.sdk.mdt.servicemediator.JADMediator.getInstance().getEventService();
            com.jd.ad.sdk.dl.error.JADError jADError = com.jd.ad.sdk.dl.error.JADError.GW_REQUEST_SLOT_IS_NULL_ERROR;
            eventService.reportRequestErrorEvent(uuid, jADError.getCode(), getErin("", 0, jADError.getMessage(new java.lang.String[0])));
            callbackAdLoadFailedOnUiThread(this.mLoadListener, jADError.getCode(), jADError.getMessage(new java.lang.String[0]));
            return;
        }
        jADSlot.setRequestId(uuid);
        this.mSlot.setLoadTime(java.lang.System.currentTimeMillis());
        if (this.mSlot.getAdType() == 0) {
            com.jd.ad.sdk.mdt.service.JADEventService eventService2 = com.jd.ad.sdk.mdt.servicemediator.JADMediator.getInstance().getEventService();
            com.jd.ad.sdk.dl.error.JADError jADError2 = com.jd.ad.sdk.dl.error.JADError.GW_REQUEST_AD_TYPE_IS_NOT_SET_ERROR;
            eventService2.reportRequestErrorEvent(uuid, jADError2.getCode(), getErin(this.mSlot.getSlotID(), 0, jADError2.getMessage(new java.lang.String[0])));
            callbackAdLoadFailedOnUiThread(this.mLoadListener, jADError2.getCode(), jADError2.getMessage(new java.lang.String[0]));
            return;
        }
        com.jd.ad.sdk.dl.model.JADSlot jADSlot2 = this.mSlot;
        jADSlot2.setDisplayScene(getDisplayScene(jADSlot2.getAdType()));
        this.mSlot.setFromNativeAd(true);
        com.jd.ad.sdk.mdt.servicemediator.JADMediator.getInstance().getAdService().loadAd(this.mInstanceId, this.mSlot, new com.jd.ad.sdk.nativead.JADNative.jad_n_an());
    }

    public void onUserCancelJdJump() {
        com.jd.ad.sdk.jad_n_an.jad_n_iv jad_n_ivVar = this.mAdViewController;
        if (jad_n_ivVar == null || com.jd.ad.sdk.mdt.servicemediator.JADMediator.getInstance().getInitService().isForbidModelToH5()) {
            return;
        }
        if (com.jd.ad.sdk.mdt.servicemediator.JADMediator.getInstance().getInitService().getNeedCheckMediaClickH5() == 1) {
            jad_n_ivVar.jad_n_an(com.jd.ad.sdk.mdt.servicemediator.JADMediator.getInstance().getTouchService().onUserCancelJdJump(jad_n_ivVar.jad_n_fs.getContext(), jad_n_ivVar.jad_n_an.getInstanceId()));
            return;
        }
        if (jad_n_ivVar.jad_n_ob == null) {
            jad_n_ivVar.jad_n_ob = new android.os.Handler(android.os.Looper.getMainLooper());
        }
        jad_n_ivVar.jad_n_ob.postDelayed(new com.jd.ad.sdk.jad_n_an.jad_n_er(jad_n_ivVar), com.jd.ad.sdk.mdt.servicemediator.JADMediator.getInstance().getInitService().getJumpToH5DelayTime());
    }

    public void registerNativeView(@androidx.annotation.NonNull android.app.Activity activity, @androidx.annotation.NonNull android.view.ViewGroup viewGroup, @androidx.annotation.NonNull java.util.List<android.view.View> list, @androidx.annotation.Nullable java.util.List<android.view.View> list2, @androidx.annotation.NonNull com.jd.ad.sdk.nativead.JADNativeInteractionListener jADNativeInteractionListener) {
        android.app.Application.ActivityLifecycleCallbacks activityLifecycleCallbacks;
        com.jd.ad.sdk.nativead.JADNative jADNative;
        float feedShakeSensitivityValue;
        float feedShakeAngleValue;
        float feedShakeTimeValue;
        boolean z;
        com.jd.ad.sdk.nativead.JADNative jADNative2;
        this.mActivityRef = new java.lang.ref.WeakReference<>(activity);
        if (this.mAdViewController == null) {
            this.mAdViewController = new com.jd.ad.sdk.jad_n_an.jad_n_iv();
        }
        com.jd.ad.sdk.jad_n_an.jad_n_iv jad_n_ivVar = this.mAdViewController;
        jad_n_ivVar.getClass();
        jad_n_ivVar.jad_n_ly = com.jd.ad.sdk.mdt.servicemediator.JADMediator.getInstance().getFoundationService().getApplication();
        jad_n_ivVar.jad_n_mz = getActivity() != null ? getActivity().hashCode() : -1;
        jad_n_ivVar.jad_n_an = this;
        jad_n_ivVar.jad_n_fs = viewGroup;
        jad_n_ivVar.jad_n_jt = list;
        jad_n_ivVar.jad_n_bo = jADNativeInteractionListener;
        if (jADNativeInteractionListener != null) {
            jad_n_ivVar.jad_n_cp(viewGroup);
            if (viewGroup != null && (jADNative2 = jad_n_ivVar.jad_n_an) != null && jADNative2.getSlot() != null) {
                com.jd.ad.sdk.mdt.servicemediator.JADMediator.getInstance().getExposureService().registerExposureView(jad_n_ivVar.jad_n_an.getInstanceId());
                if (jad_n_ivVar.jad_n_an.getSlot().getEventInteractionType() == 1) {
                    com.jd.ad.sdk.mdt.servicemediator.JADMediator.getInstance().getExposureService().registerNativeExposureFeedShakeView(jad_n_ivVar.jad_n_an.getInstanceId(), viewGroup);
                }
                com.jd.ad.sdk.mdt.servicemediator.JADMediator.getInstance().getExposureService().setViewExposureCallback(jad_n_ivVar.jad_n_an.getInstanceId(), jad_n_ivVar.jad_n_an.getSlot().getAdType(), viewGroup, new com.jd.ad.sdk.jad_n_an.jad_n_hu(jad_n_ivVar, viewGroup));
            }
            com.jd.ad.sdk.nativead.JADNative jADNative3 = jad_n_ivVar.jad_n_an;
            if (jADNative3 == null || jADNative3.getSlot() == null) {
                return;
            }
            boolean z2 = jad_n_ivVar.jad_n_an.getSlot().getAdType() == 4;
            try {
                for (android.view.View view : list) {
                    if (view != null) {
                        view.setOnClickListener(new com.jd.ad.sdk.jad_n_an.jad_n_jw(jad_n_ivVar, view, z2));
                        jad_n_ivVar.jad_n_cp(view);
                    }
                }
            } catch (java.lang.Exception e) {
                com.jd.ad.sdk.logger.Logger.w("Exception while click:" + e.getMessage(), new java.lang.Object[0]);
            }
            if (jad_n_ivVar.jad_n_an.getSlot().getAdType() == 1) {
                com.jd.ad.sdk.nativead.JADNative jADNative4 = jad_n_ivVar.jad_n_an;
                if (jADNative4 != null) {
                    com.jd.ad.sdk.jad_n_an.jad_n_an jad_n_anVar = new com.jd.ad.sdk.jad_n_an.jad_n_an(jADNative4);
                    if (jad_n_ivVar.jad_n_an.getSlot() != null) {
                        jad_n_anVar.jad_n_an = jad_n_ivVar.jad_n_an.getSlot().getSkipTime();
                    }
                    com.jd.ad.sdk.nativead.JADNativeInteractionListener jADNativeInteractionListener2 = jad_n_ivVar.jad_n_bo;
                    if (jADNativeInteractionListener2 != null && (jADNativeInteractionListener2 instanceof com.jd.ad.sdk.nativead.JADNativeSplashInteractionListener)) {
                        jad_n_anVar.jad_n_cp = new java.lang.ref.WeakReference<>((com.jd.ad.sdk.nativead.JADNativeSplashInteractionListener) jADNativeInteractionListener2);
                        jad_n_anVar.jad_n_bo = new com.jd.ad.sdk.jad_n_an.jad_n_kx(jad_n_ivVar);
                    }
                    if (list2 != null && !list2.isEmpty()) {
                        for (android.view.View view2 : list2) {
                            if (view2 != null) {
                                jad_n_ivVar.jad_n_cp(view2);
                                jad_n_anVar.jad_n_hu = view2;
                                view2.addOnAttachStateChangeListener(new com.jd.ad.sdk.jad_n_an.jad_n_bo(jad_n_anVar));
                                android.view.View view3 = jad_n_anVar.jad_n_hu;
                                if (view3 == null ? false : androidx.core.view.ViewCompat.isAttachedToWindow(view3)) {
                                    com.jd.ad.sdk.logger.Logger.d("Native ad setSkipView startCount");
                                    jad_n_anVar.jad_n_an();
                                }
                                view2.setOnClickListener(new com.jd.ad.sdk.jad_n_an.jad_n_ly(jad_n_ivVar, jad_n_anVar));
                            }
                        }
                    }
                }
            } else if (list2 != null && !list2.isEmpty()) {
                for (android.view.View view4 : list2) {
                    if (view4 != null) {
                        try {
                            view4.setOnClickListener(new com.jd.ad.sdk.jad_n_an.jad_n_mz(jad_n_ivVar));
                        } catch (java.lang.Exception e2) {
                            com.jd.ad.sdk.logger.Logger.w("Exception while click:" + e2.getMessage(), new java.lang.Object[0]);
                        }
                        jad_n_ivVar.jad_n_cp(view4);
                    }
                }
            }
            if (getSlot().getEventInteractionType() == 1 && jad_n_ivVar.jad_n_fs != null && (jADNative = jad_n_ivVar.jad_n_an) != null && jADNative.getSlot() != null) {
                if (jad_n_ivVar.jad_n_an.getSlot().getAdType() == 1) {
                    feedShakeSensitivityValue = com.jd.ad.sdk.mdt.servicemediator.JADMediator.getInstance().getInitService().getShakeSensitivityValue();
                    feedShakeAngleValue = com.jd.ad.sdk.mdt.servicemediator.JADMediator.getInstance().getInitService().getShakeAngleValue();
                    feedShakeTimeValue = com.jd.ad.sdk.mdt.servicemediator.JADMediator.getInstance().getInitService().getShakeTimeValue();
                    z = true;
                } else {
                    feedShakeSensitivityValue = com.jd.ad.sdk.mdt.servicemediator.JADMediator.getInstance().getInitService().getFeedShakeSensitivityValue();
                    feedShakeAngleValue = com.jd.ad.sdk.mdt.servicemediator.JADMediator.getInstance().getInitService().getFeedShakeAngleValue();
                    feedShakeTimeValue = com.jd.ad.sdk.mdt.servicemediator.JADMediator.getInstance().getInitService().getFeedShakeTimeValue();
                    z = false;
                }
                jad_n_ivVar.jad_n_jt();
                float f = (feedShakeSensitivityValue == 0.0f && feedShakeAngleValue == 0.0f) ? 15.0f : feedShakeSensitivityValue;
                com.jd.ad.sdk.jad_n_an.jad_n_fs jad_n_fsVar = new com.jd.ad.sdk.jad_n_an.jad_n_fs(jad_n_ivVar, jad_n_ivVar.jad_n_fs.getContext(), f, feedShakeAngleValue, feedShakeTimeValue, z, f, feedShakeAngleValue, feedShakeTimeValue);
                jad_n_ivVar.jad_n_kx = jad_n_fsVar;
                jad_n_fsVar.register();
            }
            if (getSlot().getEventInteractionType() == 2 && jad_n_ivVar.jad_n_fs != null) {
                float[] fArr = {0.0f, 0.0f};
                float[] fArr2 = {0.0f, 0.0f};
                float swipeLength = com.jd.ad.sdk.mdt.servicemediator.JADMediator.getInstance().getInitService().getSwipeLength();
                float swipeAngle = com.jd.ad.sdk.mdt.servicemediator.JADMediator.getInstance().getInitService().getSwipeAngle();
                jad_n_ivVar.jad_n_fs.setOnTouchListener(new com.jd.ad.sdk.jad_n_an.jad_n_jt(jad_n_ivVar, fArr, fArr2, swipeLength <= 0.0f ? 1.0f : swipeLength, swipeAngle <= 0.0f ? 45.0f : swipeAngle));
            }
        }
        jad_n_ivVar.jad_n_hu = com.jd.ad.sdk.mdt.servicemediator.JADMediator.getInstance().getInitService().getDs(jad_n_ivVar.jad_n_fs());
        jad_n_ivVar.jad_n_iv = com.jd.ad.sdk.mdt.servicemediator.JADMediator.getInstance().getInitService().getR(jad_n_ivVar.jad_n_fs());
        android.app.Application application = jad_n_ivVar.jad_n_ly;
        if (application == null || -1 == jad_n_ivVar.jad_n_mz || (activityLifecycleCallbacks = jad_n_ivVar.jad_n_qd) == null) {
            return;
        }
        application.unregisterActivityLifecycleCallbacks(activityLifecycleCallbacks);
        jad_n_ivVar.jad_n_ly.registerActivityLifecycleCallbacks(jad_n_ivVar.jad_n_qd);
    }
}
