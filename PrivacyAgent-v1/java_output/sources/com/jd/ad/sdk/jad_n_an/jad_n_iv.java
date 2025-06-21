package com.jd.ad.sdk.jad_n_an;

/* loaded from: classes23.dex */
public class jad_n_iv {
    public com.jd.ad.sdk.nativead.JADNative jad_n_an;
    public com.jd.ad.sdk.nativead.JADNativeInteractionListener jad_n_bo;
    public android.view.ViewGroup jad_n_fs;
    public java.util.List<android.view.View> jad_n_jt;
    public com.jd.ad.sdk.bl.dynamicrender.ShakeListener jad_n_kx;
    public android.app.Application jad_n_ly;
    public int jad_n_mz;
    public com.jd.ad.sdk.jad_n_an.jad_n_iv.jad_n_cp jad_n_na;
    public boolean jad_n_cp = false;
    public int jad_n_dq = 0;
    public int jad_n_er = 100;
    public int jad_n_hu = 0;
    public int jad_n_iv = 0;
    public int jad_n_jw = com.jd.ad.sdk.dl.common.CommonConstants.AdTriggerSourceType.CLICK.ordinal();
    public android.os.Handler jad_n_ob = null;
    public boolean jad_n_pc = false;
    public final android.app.Application.ActivityLifecycleCallbacks jad_n_qd = new com.jd.ad.sdk.jad_n_an.jad_n_iv.jad_n_bo();

    public class jad_n_an implements android.view.View.OnTouchListener {
        public jad_n_an() {
        }

        @Override // android.view.View.OnTouchListener
        @android.annotation.SuppressLint({"ClickableViewAccessibility"})
        public boolean onTouch(android.view.View view, android.view.MotionEvent motionEvent) {
            if (com.jd.ad.sdk.jad_n_an.jad_n_iv.this.jad_n_an == null) {
                return false;
            }
            com.jd.ad.sdk.mdt.servicemediator.JADMediator.getInstance().getTouchService().onViewTouch(view, motionEvent, com.jd.ad.sdk.jad_n_an.jad_n_iv.this.jad_n_an.getInstanceId());
            return false;
        }
    }

    public class jad_n_bo implements android.app.Application.ActivityLifecycleCallbacks {
        public jad_n_bo() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(@androidx.annotation.NonNull android.app.Activity activity, @androidx.annotation.Nullable android.os.Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(@androidx.annotation.NonNull android.app.Activity activity) {
            android.app.Application.ActivityLifecycleCallbacks activityLifecycleCallbacks;
            int hashCode = activity.hashCode();
            com.jd.ad.sdk.jad_n_an.jad_n_iv jad_n_ivVar = com.jd.ad.sdk.jad_n_an.jad_n_iv.this;
            if (hashCode == jad_n_ivVar.jad_n_mz) {
                jad_n_ivVar.jad_n_an(true);
                com.jd.ad.sdk.jad_n_an.jad_n_iv jad_n_ivVar2 = com.jd.ad.sdk.jad_n_an.jad_n_iv.this;
                android.app.Application application = jad_n_ivVar2.jad_n_ly;
                if (application != null && (activityLifecycleCallbacks = jad_n_ivVar2.jad_n_qd) != null) {
                    application.unregisterActivityLifecycleCallbacks(activityLifecycleCallbacks);
                }
                com.jd.ad.sdk.jad_n_an.jad_n_iv.this.jad_n_an();
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(@androidx.annotation.NonNull android.app.Activity activity) {
            int hashCode = activity.hashCode();
            com.jd.ad.sdk.jad_n_an.jad_n_iv jad_n_ivVar = com.jd.ad.sdk.jad_n_an.jad_n_iv.this;
            if (hashCode == jad_n_ivVar.jad_n_mz) {
                jad_n_ivVar.jad_n_pc = true;
                com.jd.ad.sdk.jad_n_an.jad_n_iv.this.jad_n_an(false);
                com.jd.ad.sdk.jad_n_an.jad_n_iv.jad_n_bo(com.jd.ad.sdk.jad_n_an.jad_n_iv.this, false);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(@androidx.annotation.NonNull android.app.Activity activity) {
            int hashCode = activity.hashCode();
            com.jd.ad.sdk.jad_n_an.jad_n_iv jad_n_ivVar = com.jd.ad.sdk.jad_n_an.jad_n_iv.this;
            if (hashCode == jad_n_ivVar.jad_n_mz) {
                jad_n_ivVar.jad_n_pc = false;
                com.jd.ad.sdk.jad_n_an.jad_n_iv jad_n_ivVar2 = com.jd.ad.sdk.jad_n_an.jad_n_iv.this;
                if (jad_n_ivVar2.jad_n_cp) {
                    return;
                }
                jad_n_ivVar2.jad_n_jt();
                com.jd.ad.sdk.jad_n_an.jad_n_iv.jad_n_bo(com.jd.ad.sdk.jad_n_an.jad_n_iv.this, true);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(@androidx.annotation.NonNull android.app.Activity activity, @androidx.annotation.NonNull android.os.Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(@androidx.annotation.NonNull android.app.Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(@androidx.annotation.NonNull android.app.Activity activity) {
            int hashCode = activity.hashCode();
            com.jd.ad.sdk.jad_n_an.jad_n_iv jad_n_ivVar = com.jd.ad.sdk.jad_n_an.jad_n_iv.this;
            if (hashCode == jad_n_ivVar.jad_n_mz) {
                jad_n_ivVar.jad_n_pc = true;
                com.jd.ad.sdk.jad_n_an.jad_n_iv.this.jad_n_an(false);
                com.jd.ad.sdk.jad_n_an.jad_n_iv.jad_n_bo(com.jd.ad.sdk.jad_n_an.jad_n_iv.this, false);
            }
        }
    }

    @androidx.annotation.RequiresApi(api = 18)
    public class jad_n_cp implements android.view.ViewTreeObserver.OnWindowFocusChangeListener {
        public jad_n_cp() {
        }

        @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
        public void onWindowFocusChanged(boolean z) {
            com.jd.ad.sdk.jad_n_an.jad_n_iv jad_n_ivVar = com.jd.ad.sdk.jad_n_an.jad_n_iv.this;
            if (jad_n_ivVar.jad_n_cp) {
                return;
            }
            if (!z) {
                jad_n_ivVar.jad_n_hu();
                return;
            }
            com.jd.ad.sdk.bl.dynamicrender.ShakeListener shakeListener = jad_n_ivVar.jad_n_kx;
            if (shakeListener != null) {
                shakeListener.register();
            }
        }
    }

    public static int jad_n_an(com.jd.ad.sdk.jad_n_an.jad_n_iv jad_n_ivVar, float f, float f2, float f3) {
        jad_n_ivVar.getClass();
        com.jd.ad.sdk.dl.common.CommonConstants.AdTriggerSourceType adTriggerSourceType = com.jd.ad.sdk.dl.common.CommonConstants.AdTriggerSourceType.SHAKE;
        int ordinal = adTriggerSourceType.ordinal();
        return f3 > 0.0f ? (f <= 0.0f || f2 <= 0.0f) ? f > 0.0f ? com.jd.ad.sdk.dl.common.CommonConstants.AdTriggerSourceType.SHAKE_ACCELERATION_TIME.ordinal() : f2 > 0.0f ? com.jd.ad.sdk.dl.common.CommonConstants.AdTriggerSourceType.SHAKE_ANGLE_TIME.ordinal() : ordinal : com.jd.ad.sdk.dl.common.CommonConstants.AdTriggerSourceType.SHAKE_ALL.ordinal() : (f <= 0.0f || f2 <= 0.0f) ? f > 0.0f ? adTriggerSourceType.ordinal() : f2 > 0.0f ? com.jd.ad.sdk.dl.common.CommonConstants.AdTriggerSourceType.SHAKE_ANGLE.ordinal() : ordinal : com.jd.ad.sdk.dl.common.CommonConstants.AdTriggerSourceType.SHAKE_ACCELERATION_ANGLE.ordinal();
    }

    public static void jad_n_an(com.jd.ad.sdk.jad_n_an.jad_n_iv jad_n_ivVar, android.view.View view, boolean z) {
        long j;
        long j2;
        long j3;
        if (jad_n_ivVar.jad_n_cp) {
            return;
        }
        if (jad_n_ivVar.jad_n_an != null) {
            try {
                com.jd.ad.sdk.mdt.servicemediator.JADMediator.getInstance().getExposureService().setViewForceExposure(jad_n_ivVar.jad_n_an.getInstanceId());
                if (jad_n_ivVar.jad_n_an.getSlot() != null && jad_n_ivVar.jad_n_an.getSlot().getAdType() != 4) {
                    com.jd.ad.sdk.mdt.servicemediator.JADMediator.getInstance().getTouchService().unregisterTouchView(jad_n_ivVar.jad_n_an.getInstanceId());
                }
                if (jad_n_ivVar.jad_n_an.getSlot() != null && jad_n_ivVar.jad_n_an.getSlot().getAdType() == 2) {
                    com.jd.ad.sdk.mdt.servicemediator.JADMediator.getInstance().getExposureService().unregisterNativeExposureFeedShakeView(jad_n_ivVar.jad_n_an.getInstanceId());
                }
                jad_n_ivVar.jad_n_hu();
                jad_n_ivVar.jad_n_an(true);
            } catch (java.lang.Exception e) {
                com.jd.ad.sdk.logger.Logger.w("Exception while close: " + e.getMessage(), new java.lang.Object[0]);
            }
        }
        jad_n_ivVar.jad_n_cp = true;
        if (z) {
            java.lang.String jad_n_er = jad_n_ivVar.jad_n_er();
            java.lang.String jad_n_fs = jad_n_ivVar.jad_n_fs();
            int jad_n_bo2 = jad_n_ivVar.jad_n_bo();
            if (jad_n_ivVar.jad_n_dq() != null) {
                jad_n_ivVar.jad_n_dq().setClickTime(java.lang.System.currentTimeMillis());
                long clickTime = jad_n_ivVar.jad_n_dq().getClickTime() - jad_n_ivVar.jad_n_dq().getLoadTime();
                long clickTime2 = jad_n_ivVar.jad_n_dq().getClickTime() - jad_n_ivVar.jad_n_dq().getLoadSucTime();
                long clickTime3 = jad_n_ivVar.jad_n_dq().getClickTime() - jad_n_ivVar.jad_n_dq().getShowTime();
                jad_n_ivVar.jad_n_dq().setScdu(clickTime);
                jad_n_ivVar.jad_n_dq().setDcdu(clickTime2);
                jad_n_ivVar.jad_n_dq().setEcdu(clickTime3);
                j2 = clickTime2;
                j3 = clickTime3;
                j = clickTime;
            } else {
                j = 0;
                j2 = 0;
                j3 = 0;
            }
            com.jd.ad.sdk.mdt.servicemediator.JADMediator.getInstance().getEventService().reportCloseEvent(jad_n_er, jad_n_fs, jad_n_bo2, com.jd.ad.sdk.dl.common.CommonConstants.AdTmp.TEMPLATE_UNKNOWN.getTemplateId(), com.jd.ad.sdk.mdt.servicemediator.JADMediator.getInstance().getInitService().getSen(jad_n_fs), 2, -1, j, j2, j3, jad_n_ivVar.jad_n_dq, jad_n_ivVar.jad_n_er, com.jd.ad.sdk.dl.common.CommonConstants.ClickFrom.CLOSE.ordinal(), jad_n_ivVar.jad_n_hu, jad_n_ivVar.jad_n_iv);
        }
        com.jd.ad.sdk.nativead.JADNativeInteractionListener jADNativeInteractionListener = jad_n_ivVar.jad_n_bo;
        if (jADNativeInteractionListener != null) {
            jADNativeInteractionListener.onClose(view);
            jad_n_ivVar.jad_n_bo = null;
        }
    }

    public static void jad_n_an(com.jd.ad.sdk.jad_n_an.jad_n_iv jad_n_ivVar, boolean z, java.lang.String str, int i) {
        long j;
        long j2;
        int i2;
        long j3;
        long j4;
        int i3;
        java.util.List<android.view.View> list;
        android.view.View next;
        com.jd.ad.sdk.nativead.JADNative jADNative;
        jad_n_ivVar.getClass();
        try {
            jad_n_ivVar.jad_n_dq = 0;
            jad_n_ivVar.jad_n_er = 0;
            if (jad_n_ivVar.jad_n_fs != null && (list = jad_n_ivVar.jad_n_jt) != null && list.size() != 0) {
                com.jd.ad.sdk.nativead.JADNative jADNative2 = jad_n_ivVar.jad_n_an;
                if (jADNative2 == null || jADNative2.getSlot() == null || jad_n_ivVar.jad_n_an.getSlot().getAdType() == 1) {
                    java.util.Iterator<android.view.View> it = jad_n_ivVar.jad_n_jt.iterator();
                    int i4 = 0;
                    while (it.hasNext() && (next = it.next()) != null && (jADNative = jad_n_ivVar.jad_n_an) != null && jADNative.getSlot() != null) {
                        int measuredWidth = (int) (jad_n_ivVar.jad_n_fs.getMeasuredWidth() * jad_n_ivVar.jad_n_fs.getMeasuredHeight());
                        i4 += next.getMeasuredWidth() * next.getMeasuredHeight();
                        if (measuredWidth > 0) {
                            jad_n_ivVar.jad_n_er = (i4 * 100) / measuredWidth;
                            if (i4 < measuredWidth) {
                                jad_n_ivVar.jad_n_dq = 5;
                            } else {
                                jad_n_ivVar.jad_n_dq = 4;
                            }
                        } else {
                            jad_n_ivVar.jad_n_dq = 0;
                            jad_n_ivVar.jad_n_er = 0;
                        }
                        jad_n_ivVar.jad_n_an.getSlot().setSspt(jad_n_ivVar.jad_n_dq);
                        jad_n_ivVar.jad_n_an.getSlot().setScav(jad_n_ivVar.jad_n_er);
                    }
                } else {
                    jad_n_ivVar.jad_n_dq = 0;
                    jad_n_ivVar.jad_n_er = 100;
                    jad_n_ivVar.jad_n_an.getSlot().setSspt(jad_n_ivVar.jad_n_dq);
                    jad_n_ivVar.jad_n_an.getSlot().setScav(jad_n_ivVar.jad_n_er);
                }
            }
        } catch (java.lang.Exception e) {
            com.jd.ad.sdk.logger.Logger.w("Exception while calculate area: " + e.getMessage(), new java.lang.Object[0]);
        }
        if (!z) {
            java.lang.String jad_n_er = jad_n_ivVar.jad_n_er();
            java.lang.String jad_n_fs = jad_n_ivVar.jad_n_fs();
            int jad_n_bo2 = jad_n_ivVar.jad_n_bo();
            if (jad_n_ivVar.jad_n_dq() != null) {
                int modelClickAreaType = jad_n_ivVar.jad_n_dq().getModelClickAreaType();
                jad_n_ivVar.jad_n_dq().setShowTime(java.lang.System.currentTimeMillis());
                long showTime = jad_n_ivVar.jad_n_dq().getShowTime() - jad_n_ivVar.jad_n_dq().getLoadTime();
                long showTime2 = jad_n_ivVar.jad_n_dq().getShowTime() - jad_n_ivVar.jad_n_dq().getLoadSucTime();
                jad_n_ivVar.jad_n_dq().setSedu(showTime);
                jad_n_ivVar.jad_n_dq().setDedu(showTime2);
                jad_n_ivVar.jad_n_dq().setExposureExtend(str);
                jad_n_ivVar.jad_n_dq().setDstp(jad_n_ivVar.jad_n_hu);
                jad_n_ivVar.jad_n_dq().setSrtp(jad_n_ivVar.jad_n_iv);
                i2 = modelClickAreaType;
                j = showTime;
                j2 = showTime2;
            } else {
                j = 0;
                j2 = 0;
                i2 = 0;
            }
            com.jd.ad.sdk.mdt.servicemediator.JADMediator.getInstance().getEventService().reportExposureEvent(jad_n_er, jad_n_fs, jad_n_bo2, com.jd.ad.sdk.dl.common.CommonConstants.AdTmp.TEMPLATE_UNKNOWN.getTemplateId(), com.jd.ad.sdk.mdt.servicemediator.JADMediator.getInstance().getInitService().getSen(jad_n_fs), 2, i, j, j2, jad_n_ivVar.jad_n_dq, jad_n_ivVar.jad_n_er, jad_n_ivVar.jad_n_cp(), i2, str, jad_n_ivVar.jad_n_hu, jad_n_ivVar.jad_n_iv);
            return;
        }
        java.lang.String jad_n_er2 = jad_n_ivVar.jad_n_er();
        java.lang.String jad_n_fs2 = jad_n_ivVar.jad_n_fs();
        int jad_n_bo3 = jad_n_ivVar.jad_n_bo();
        if (jad_n_ivVar.jad_n_dq() != null) {
            int modelClickAreaType2 = jad_n_ivVar.jad_n_dq().getModelClickAreaType();
            jad_n_ivVar.jad_n_dq().setDelayShowTime(java.lang.System.currentTimeMillis());
            long delayShowTime = jad_n_ivVar.jad_n_dq().getDelayShowTime() - jad_n_ivVar.jad_n_dq().getLoadTime();
            long delayShowTime2 = jad_n_ivVar.jad_n_dq().getDelayShowTime() - jad_n_ivVar.jad_n_dq().getLoadSucTime();
            jad_n_ivVar.jad_n_dq().setSedu(delayShowTime);
            jad_n_ivVar.jad_n_dq().setDedu(delayShowTime2);
            jad_n_ivVar.jad_n_dq().setExposureExtend(str);
            jad_n_ivVar.jad_n_dq().setDstp(jad_n_ivVar.jad_n_hu);
            jad_n_ivVar.jad_n_dq().setSrtp(jad_n_ivVar.jad_n_iv);
            i3 = modelClickAreaType2;
            j3 = delayShowTime;
            j4 = delayShowTime2;
        } else {
            j3 = 0;
            j4 = 0;
            i3 = 0;
        }
        com.jd.ad.sdk.mdt.servicemediator.JADMediator.getInstance().getEventService().reportExposureEvent(jad_n_er2, jad_n_fs2, jad_n_bo3, com.jd.ad.sdk.dl.common.CommonConstants.AdTmp.TEMPLATE_UNKNOWN.getTemplateId(), com.jd.ad.sdk.mdt.servicemediator.JADMediator.getInstance().getInitService().getSen(jad_n_fs2), 2, i, j3, j4, jad_n_ivVar.jad_n_dq, jad_n_ivVar.jad_n_er, jad_n_ivVar.jad_n_cp(), i3, str, jad_n_ivVar.jad_n_hu, jad_n_ivVar.jad_n_iv);
        com.jd.ad.sdk.nativead.JADNativeInteractionListener jADNativeInteractionListener = jad_n_ivVar.jad_n_bo;
        if (jADNativeInteractionListener != null) {
            jADNativeInteractionListener.onExposure();
        }
    }

    public static boolean jad_n_an(com.jd.ad.sdk.jad_n_an.jad_n_iv jad_n_ivVar, android.content.Context context, java.lang.String str) {
        java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.ref.WeakReference<android.view.View>> nativeExposureFeedShakeViewMap;
        java.lang.ref.WeakReference<android.view.View> weakReference;
        jad_n_ivVar.getClass();
        if (context == null || android.text.TextUtils.isEmpty(str) || (nativeExposureFeedShakeViewMap = com.jd.ad.sdk.mdt.servicemediator.JADMediator.getInstance().getExposureService().getNativeExposureFeedShakeViewMap()) == null) {
            return false;
        }
        int screenWidth = com.jd.ad.sdk.dl.baseinfo.JADScreenInfoUtils.getScreenWidth(context) / 2;
        int screenHeight = com.jd.ad.sdk.dl.baseinfo.JADScreenInfoUtils.getScreenHeight(context) / 2;
        double d = Double.MAX_VALUE;
        java.lang.String str2 = "";
        for (java.lang.String str3 : nativeExposureFeedShakeViewMap.keySet()) {
            if (!android.text.TextUtils.isEmpty(str3) && (weakReference = nativeExposureFeedShakeViewMap.get(str3)) != null && weakReference.get() != null) {
                android.view.View view = weakReference.get();
                if (jad_n_ivVar.jad_n_an(view)) {
                    int[] iArr = new int[2];
                    view.getLocationOnScreen(iArr);
                    int i = iArr[0];
                    int i2 = iArr[1];
                    int width = view.getWidth();
                    int height = (view.getHeight() / 2) + i2;
                    int abs = java.lang.Math.abs(((width / 2) + i) - screenWidth);
                    int abs2 = java.lang.Math.abs(height - screenHeight);
                    double sqrt = java.lang.Math.sqrt((abs2 * abs2) + (abs * abs));
                    if (sqrt < d) {
                        str2 = str3;
                        d = sqrt;
                    }
                }
            }
        }
        com.jd.ad.sdk.nativead.JADNative jADNative = jad_n_ivVar.jad_n_an;
        return jADNative != null && str2.equals(jADNative.getInstanceId());
    }

    public static boolean jad_n_an(com.jd.ad.sdk.jad_n_an.jad_n_iv jad_n_ivVar, android.view.View view) {
        jad_n_ivVar.getClass();
        return view != null && view.getGlobalVisibleRect(new android.graphics.Rect()) && view.isShown();
    }

    public static void jad_n_bo(com.jd.ad.sdk.jad_n_an.jad_n_iv jad_n_ivVar, boolean z) {
        if (!z) {
            jad_n_ivVar.jad_n_hu();
            return;
        }
        com.jd.ad.sdk.bl.dynamicrender.ShakeListener shakeListener = jad_n_ivVar.jad_n_kx;
        if (shakeListener != null) {
            shakeListener.register();
        }
    }

    public void jad_n_an() {
        try {
            jad_n_hu();
            if (this.jad_n_kx != null) {
                this.jad_n_kx = null;
            }
            jad_n_an(true);
            if (this.jad_n_an != null) {
                com.jd.ad.sdk.mdt.servicemediator.JADMediator.getInstance().getExposureService().unregisterExposureView(this.jad_n_an.getInstanceId());
                com.jd.ad.sdk.mdt.servicemediator.JADMediator.getInstance().getTouchService().unregisterTouchView(this.jad_n_an.getInstanceId());
                if (this.jad_n_an.getSlot() != null && this.jad_n_an.getSlot().getAdType() == 2) {
                    com.jd.ad.sdk.mdt.servicemediator.JADMediator.getInstance().getExposureService().unregisterNativeExposureFeedShakeView(this.jad_n_an.getInstanceId());
                }
            }
            android.os.Handler handler = this.jad_n_ob;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
                this.jad_n_ob = null;
            }
            this.jad_n_bo = null;
            this.jad_n_an = null;
            this.jad_n_fs = null;
            this.jad_n_jt = null;
        } catch (java.lang.Exception e) {
            com.jd.ad.sdk.logger.Logger.w("Exception while destroy: " + e.getMessage(), new java.lang.Object[0]);
        }
    }

    public void jad_n_an(int i) {
        long j;
        long j2;
        long j3;
        int i2;
        if (i == -2) {
            return;
        }
        java.lang.String jad_n_er = jad_n_er();
        java.lang.String jad_n_fs = jad_n_fs();
        int jad_n_bo2 = jad_n_bo();
        int jad_n_cp2 = jad_n_cp();
        if (jad_n_dq() != null) {
            int modelClickAreaType = jad_n_dq().getModelClickAreaType();
            jad_n_dq().setClickTime(java.lang.System.currentTimeMillis());
            long clickTime = jad_n_dq().getClickTime() - jad_n_dq().getLoadTime();
            long clickTime2 = jad_n_dq().getClickTime() - jad_n_dq().getLoadSucTime();
            long clickTime3 = jad_n_dq().getClickTime() - jad_n_dq().getShowTime();
            jad_n_dq().setScdu(clickTime);
            jad_n_dq().setDcdu(clickTime2);
            jad_n_dq().setEcdu(clickTime3);
            jad_n_dq().setAtst(this.jad_n_jw);
            i2 = modelClickAreaType;
            j3 = clickTime3;
            j2 = clickTime2;
            j = clickTime;
        } else {
            j = 0;
            j2 = 0;
            j3 = 0;
            i2 = 0;
        }
        com.jd.ad.sdk.mdt.servicemediator.JADMediator.getInstance().getEventService().reportClickEvent(jad_n_er, jad_n_fs, jad_n_bo2, com.jd.ad.sdk.dl.common.CommonConstants.AdTmp.TEMPLATE_UNKNOWN.getTemplateId(), com.jd.ad.sdk.mdt.servicemediator.JADMediator.getInstance().getInitService().getSen(jad_n_fs), 2, i, j, j2, j3, this.jad_n_dq, this.jad_n_er, jad_n_cp2, this.jad_n_jw, i2, this.jad_n_hu, this.jad_n_iv);
    }

    public final void jad_n_an(boolean z) {
        android.view.ViewGroup viewGroup = this.jad_n_fs;
        if (viewGroup == null || this.jad_n_na == null) {
            return;
        }
        viewGroup.getViewTreeObserver().removeOnWindowFocusChangeListener(this.jad_n_na);
        if (z) {
            this.jad_n_na = null;
        }
    }

    public final boolean jad_n_an(android.view.View view) {
        if (view == null) {
            return false;
        }
        android.graphics.Rect rect = new android.graphics.Rect();
        if (!view.getGlobalVisibleRect(rect) || !view.isShown() || rect.top <= 0) {
            return false;
        }
        int width = rect.width() * rect.height();
        int height = view.getHeight() * view.getWidth();
        return ((width == 0 || height == 0) ? 0 : (int) (new java.math.BigDecimal(java.lang.String.valueOf(width)).divide(new java.math.BigDecimal(java.lang.String.valueOf(height)), 2, java.math.RoundingMode.HALF_UP).floatValue() * 100.0f)) == 100;
    }

    public final int jad_n_bo() {
        if (jad_n_dq() != null) {
            return jad_n_dq().getAdType();
        }
        return 0;
    }

    public final void jad_n_bo(android.view.View view) {
        if (view == null || this.jad_n_fs == null || this.jad_n_an == null) {
            return;
        }
        com.jd.ad.sdk.mdt.servicemediator.JADMediator.getInstance().getExposureService().setViewForceExposure(this.jad_n_an.getInstanceId());
        jad_n_an(com.jd.ad.sdk.mdt.servicemediator.JADMediator.getInstance().getTouchService().onViewClicked(view.getContext(), view, this.jad_n_an.getInstanceId()));
        com.jd.ad.sdk.nativead.JADNativeInteractionListener jADNativeInteractionListener = this.jad_n_bo;
        if (jADNativeInteractionListener != null) {
            jADNativeInteractionListener.onClick(view);
        }
    }

    public final int jad_n_cp() {
        return jad_n_dq() != null ? jad_n_dq().getEventInteractionType() : com.jd.ad.sdk.dl.common.CommonConstants.AdTriggerSourceType.CLICK.ordinal();
    }

    public final void jad_n_cp(android.view.View view) {
        if (view == null || this.jad_n_an == null) {
            return;
        }
        com.jd.ad.sdk.mdt.servicemediator.JADMediator.getInstance().getTouchService().registerTouchView(this.jad_n_an.getInstanceId());
        view.setClickable(true);
        view.setOnTouchListener(new com.jd.ad.sdk.jad_n_an.jad_n_iv.jad_n_an());
    }

    public final com.jd.ad.sdk.dl.model.JADSlot jad_n_dq() {
        com.jd.ad.sdk.nativead.JADNative jADNative = this.jad_n_an;
        if (jADNative != null) {
            return jADNative.getSlot();
        }
        return null;
    }

    public final java.lang.String jad_n_er() {
        com.jd.ad.sdk.nativead.JADNative jADNative = this.jad_n_an;
        return (jADNative == null || jADNative.getSlot() == null) ? "" : this.jad_n_an.getSlot().getRequestId();
    }

    public final java.lang.String jad_n_fs() {
        return jad_n_dq() != null ? jad_n_dq().getSlotID() : "";
    }

    public final void jad_n_hu() {
        com.jd.ad.sdk.bl.dynamicrender.ShakeListener shakeListener = this.jad_n_kx;
        if (shakeListener != null) {
            shakeListener.unregister();
        }
    }

    public final void jad_n_jt() {
        android.view.ViewGroup viewGroup = this.jad_n_fs;
        if (viewGroup != null && this.jad_n_na == null) {
            this.jad_n_na = new com.jd.ad.sdk.jad_n_an.jad_n_iv.jad_n_cp();
            viewGroup.getViewTreeObserver().addOnWindowFocusChangeListener(this.jad_n_na);
        }
    }
}
