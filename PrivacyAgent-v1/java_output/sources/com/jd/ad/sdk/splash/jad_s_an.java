package com.jd.ad.sdk.splash;

/* loaded from: classes23.dex */
public class jad_s_an implements com.jd.ad.sdk.bl.dynamicrender.DynamicRenderView.IDynamicRenderCallback {
    public java.lang.ref.WeakReference<android.content.Context> jad_s_an;
    public final com.jd.ad.sdk.dl.model.JADSlot jad_s_bo;
    public java.lang.String jad_s_cp;
    public java.lang.String jad_s_dq;
    public java.lang.String jad_s_er;
    public int jad_s_fs;
    public com.jd.ad.sdk.splash.jad_s_an.jad_s_cp jad_s_hu;
    public android.view.View jad_s_iv;
    public android.view.View jad_s_jt;
    public int jad_s_jw;
    public com.jd.ad.sdk.splash.JADSplashSkipView jad_s_kx;
    public com.jd.ad.sdk.splash.JADSplashCountDownListener jad_s_ly;
    public com.jd.ad.sdk.splash.JADSplashVideoListener jad_s_mz;
    public boolean jad_s_na;
    public boolean jad_s_ob;
    public com.jd.ad.sdk.jad_s_an.jad_s_jw jad_s_pc;
    public int jad_s_re;
    public int jad_s_sf;
    public int jad_s_tg;
    public long jad_s_qd = 0;
    public android.os.Handler jad_s_uh = null;
    public boolean jad_s_vi = false;
    public com.jd.ad.sdk.bl.video.listener.OnVideoRenderListener jad_s_wj = null;
    public com.jd.ad.sdk.bl.video.listener.VideoLoadListener jad_s_xk = null;

    /* renamed from: com.jd.ad.sdk.splash.jad_s_an$jad_s_an, reason: collision with other inner class name */
    public class C0416jad_s_an implements com.jd.ad.sdk.fdt.imageloader.OnImageLoadListener {
        public final /* synthetic */ android.widget.ImageView jad_s_an;
        public final /* synthetic */ android.view.View jad_s_bo;

        public C0416jad_s_an(android.widget.ImageView imageView, android.view.View view) {
            this.jad_s_an = imageView;
            this.jad_s_bo = view;
        }

        @Override // com.jd.ad.sdk.fdt.imageloader.OnImageLoadListener
        public void onLoadFailed(int i, java.lang.String str, @androidx.annotation.Nullable android.graphics.drawable.Drawable drawable) {
            com.jd.ad.sdk.splash.jad_s_an jad_s_anVar = com.jd.ad.sdk.splash.jad_s_an.this;
            com.jd.ad.sdk.dl.error.JADError jADError = com.jd.ad.sdk.dl.error.JADError.RENDER_IMAGE_LOAD_FAIL_ERROR;
            com.jd.ad.sdk.mdt.servicemediator.JADMediator.getInstance().getEventService().reportRenderFailedEvent(com.jd.ad.sdk.splash.jad_s_an.this.jad_s_er, jADError.getCode(), jad_s_anVar.jad_s_an(jADError.getMessage(new java.lang.String[0])), com.jd.ad.sdk.splash.jad_s_an.this.jad_s_fs);
            com.jd.ad.sdk.splash.jad_s_an.jad_s_an(com.jd.ad.sdk.splash.jad_s_an.this, jADError.getCode(), jADError.getMessage(new java.lang.String[0]));
        }

        @Override // com.jd.ad.sdk.fdt.imageloader.OnImageLoadListener
        public void onLoadSuccess(@androidx.annotation.NonNull android.graphics.drawable.Drawable drawable) {
            android.widget.ImageView imageView = this.jad_s_an;
            if (imageView != null) {
                imageView.setImageDrawable(drawable);
            }
            com.jd.ad.sdk.splash.jad_s_an.this.jad_s_an(this.jad_s_bo, 1);
        }
    }

    public class jad_s_bo implements android.view.View.OnTouchListener {
        public jad_s_bo(com.jd.ad.sdk.splash.jad_s_an jad_s_anVar) {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(android.view.View view, android.view.MotionEvent motionEvent) {
            return true;
        }
    }

    public interface jad_s_cp {
    }

    public jad_s_an(android.content.Context context, com.jd.ad.sdk.dl.model.JADSlot jADSlot, java.lang.String str, java.lang.String str2) {
        this.jad_s_cp = "";
        this.jad_s_dq = "";
        this.jad_s_er = "";
        this.jad_s_fs = 0;
        if (context == null) {
            com.jd.ad.sdk.logger.Logger.w("Context can not be null !!!", new java.lang.Object[0]);
        } else {
            this.jad_s_an = new java.lang.ref.WeakReference<>(context);
        }
        this.jad_s_bo = jADSlot;
        if (jADSlot != null) {
            this.jad_s_er = jADSlot.getRequestId();
            this.jad_s_fs = jADSlot.getSen();
        }
        this.jad_s_dq = str;
        this.jad_s_cp = str2;
    }

    public static float jad_s_an(com.jd.ad.sdk.splash.jad_s_an jad_s_anVar, float f) {
        jad_s_anVar.getClass();
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("xlog--transferDuration:");
        sb.append(f);
        sb.append(",result: ");
        float f2 = f / 1000.0f;
        sb.append(f2);
        com.jd.ad.sdk.logger.Logger.d(sb.toString());
        return f2;
    }

    public static void jad_s_an(com.jd.ad.sdk.splash.jad_s_an jad_s_anVar) {
        com.jd.ad.sdk.splash.jad_s_an.jad_s_cp jad_s_cpVar = jad_s_anVar.jad_s_hu;
        if (jad_s_cpVar != null) {
            com.jd.ad.sdk.splash.JADSplash.jad_s_er jad_s_erVar = (com.jd.ad.sdk.splash.JADSplash.jad_s_er) jad_s_cpVar;
            com.jd.ad.sdk.splash.JADSplash.this.callbackAdCloseOnUiThread();
            com.jd.ad.sdk.splash.JADSplash.this.destroy();
        }
    }

    public static void jad_s_an(com.jd.ad.sdk.splash.jad_s_an jad_s_anVar, int i) {
        com.jd.ad.sdk.splash.jad_s_an.jad_s_cp jad_s_cpVar = jad_s_anVar.jad_s_hu;
        if (jad_s_cpVar != null) {
            com.jd.ad.sdk.splash.JADSplash.this.callbackAdCountDownOnUiThread(i);
        }
    }

    public static void jad_s_an(com.jd.ad.sdk.splash.jad_s_an jad_s_anVar, int i, java.lang.String str) {
        com.jd.ad.sdk.splash.jad_s_an.jad_s_cp jad_s_cpVar = jad_s_anVar.jad_s_hu;
        if (jad_s_cpVar != null) {
            com.jd.ad.sdk.splash.JADSplash.this.callbackAdRenderFailedOnUiThread(i, str);
        }
    }

    public static void jad_s_an(com.jd.ad.sdk.splash.jad_s_an jad_s_anVar, android.content.Context context, android.view.View view, int i, int i2, int i3) {
        jad_s_anVar.jad_s_tg = i;
        jad_s_anVar.jad_s_re = i2;
        jad_s_anVar.jad_s_sf = i3;
        if (jad_s_anVar.jad_s_jt != null) {
            com.jd.ad.sdk.mdt.servicemediator.JADMediator.getInstance().getExposureService().setViewForceExposure(jad_s_anVar.jad_s_dq);
        }
        int onViewClicked = com.jd.ad.sdk.mdt.servicemediator.JADMediator.getInstance().getTouchService().onViewClicked(context, view, jad_s_anVar.jad_s_dq);
        com.jd.ad.sdk.splash.jad_s_an.jad_s_cp jad_s_cpVar = jad_s_anVar.jad_s_hu;
        if (jad_s_cpVar != null) {
            com.jd.ad.sdk.splash.JADSplash.jad_s_er jad_s_erVar = (com.jd.ad.sdk.splash.JADSplash.jad_s_er) jad_s_cpVar;
            com.jd.ad.sdk.splash.JADSplash.this.reportClickEvent(onViewClicked, i, i2, i3);
            com.jd.ad.sdk.splash.JADSplash.this.callbackAdClickOnUiThread();
        }
    }

    public static void jad_s_an(com.jd.ad.sdk.splash.jad_s_an jad_s_anVar, android.view.View view) {
        jad_s_anVar.getClass();
        com.jd.ad.sdk.mdt.servicemediator.JADMediator.getInstance().getExposureService().setViewForceExposure(jad_s_anVar.jad_s_dq);
        com.jd.ad.sdk.splash.jad_s_an.jad_s_cp jad_s_cpVar = jad_s_anVar.jad_s_hu;
        if (jad_s_cpVar != null) {
            com.jd.ad.sdk.splash.JADSplash.jad_s_er jad_s_erVar = (com.jd.ad.sdk.splash.JADSplash.jad_s_er) jad_s_cpVar;
            com.jd.ad.sdk.splash.JADSplash.this.reportCloseEvent(com.jd.ad.sdk.dl.common.CommonConstants.ClickFrom.CLOSE.ordinal());
            if (view != null) {
                com.jd.ad.sdk.splash.JADSplash.this.callbackAdCloseOnUiThread();
            }
        }
    }

    public static void jad_s_an(com.jd.ad.sdk.splash.jad_s_an jad_s_anVar, android.view.View view, boolean z, java.lang.String str, int i, int i2) {
        com.jd.ad.sdk.splash.jad_s_an.jad_s_cp jad_s_cpVar = jad_s_anVar.jad_s_hu;
        if (jad_s_cpVar != null) {
            com.jd.ad.sdk.splash.JADSplash.jad_s_er jad_s_erVar = (com.jd.ad.sdk.splash.JADSplash.jad_s_er) jad_s_cpVar;
            com.jd.ad.sdk.splash.JADSplash.this.calculateClickArea();
            if (!z) {
                com.jd.ad.sdk.splash.JADSplash.this.reportExposureEvent(str, i, i2);
            } else {
                com.jd.ad.sdk.splash.JADSplash.this.reportDelayExposureEvent(str, i, i2);
                com.jd.ad.sdk.splash.JADSplash.this.callbackAdShowedOnUiThread();
            }
        }
    }

    @androidx.annotation.Nullable
    public final android.content.Context jad_s_an() {
        java.lang.ref.WeakReference<android.content.Context> weakReference = this.jad_s_an;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public java.lang.String jad_s_an(java.lang.String str) {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        com.jd.ad.sdk.dl.model.JADSlot jADSlot = this.jad_s_bo;
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "pid", jADSlot != null ? jADSlot.getSlotID() : "");
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "adt", 1);
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "error", str);
        return jSONObject.toString();
    }

    public org.json.JSONObject jad_s_an(java.lang.Exception exc) {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        java.lang.String message = exc.getMessage();
        int code = com.jd.ad.sdk.dl.error.JADError.RENDER_DYNAMIC_VIEW_INIT_OTHER_ERROR.getCode();
        try {
            for (java.lang.Throwable cause = exc.getCause(); cause != null; cause = cause.getCause()) {
                java.lang.String message2 = cause.getMessage();
                if (android.text.TextUtils.isEmpty(message2) || !message2.startsWith("40")) {
                    message = message + "|" + message2;
                } else {
                    java.lang.String[] split = message2.split(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                    code = java.lang.Integer.parseInt(split[0]);
                    message = message + "|" + split[1];
                }
            }
        } catch (java.lang.Exception unused) {
            com.jd.ad.sdk.logger.Logger.d("错误信息拼接异常");
        } finally {
            jSONObject.put("code", code);
            jSONObject.put("msg", message);
        }
        return jSONObject;
    }

    public final void jad_s_an(int i, java.lang.String str) {
        com.jd.ad.sdk.splash.jad_s_an.jad_s_cp jad_s_cpVar = this.jad_s_hu;
        if (jad_s_cpVar != null) {
            com.jd.ad.sdk.splash.JADSplash.this.callbackAdRenderFailedOnUiThread(i, str);
        }
    }

    @android.annotation.SuppressLint({"InflateParams"})
    public final void jad_s_an(android.content.Context context, android.view.View view, android.widget.ImageView imageView) {
        if (context == null || this.jad_s_bo == null) {
            return;
        }
        android.widget.FrameLayout frameLayout = (android.widget.FrameLayout) view.findViewById(com.jd.ad.sdk.fdt.utils.ResourceUtils.getResourceId(jad_s_an(), "jad_splash_click_area_container", "id"));
        android.view.LayoutInflater from = android.view.LayoutInflater.from(context);
        int modelClickAreaType = this.jad_s_bo.getModelClickAreaType();
        int jad_s_an = com.jd.ad.sdk.jad_s_an.jad_s_iv.jad_s_an(modelClickAreaType == 1 ? 2 : modelClickAreaType == 2 ? 3 : modelClickAreaType == 3 ? 4 : modelClickAreaType == 4 ? 5 : 1);
        if (jad_s_an == 1) {
            frameLayout.addView(from.inflate(com.jd.ad.sdk.fdt.utils.ResourceUtils.getResourceId(context, "jad_splash_click_area_type1", "layout"), (android.view.ViewGroup) null), jad_s_bo());
            frameLayout.setVisibility(0);
            this.jad_s_iv = view;
            this.jad_s_jw = 1;
            return;
        }
        if (jad_s_an == 3) {
            frameLayout.setVisibility(8);
            this.jad_s_iv = view;
            this.jad_s_jw = 3;
        } else {
            if (jad_s_an == 4) {
                frameLayout.addView(from.inflate(com.jd.ad.sdk.fdt.utils.ResourceUtils.getResourceId(context, "jad_splash_click_area_type2", "layout"), (android.view.ViewGroup) null), jad_s_bo());
                frameLayout.setVisibility(0);
                this.jad_s_iv = view;
                this.jad_s_jw = 4;
                return;
            }
            android.view.View inflate = from.inflate(com.jd.ad.sdk.fdt.utils.ResourceUtils.getResourceId(context, "jad_splash_click_area_type2", "layout"), (android.view.ViewGroup) null);
            imageView.setOnTouchListener(new com.jd.ad.sdk.splash.jad_s_an.jad_s_bo(this));
            frameLayout.addView(inflate, jad_s_bo());
            frameLayout.setVisibility(0);
            this.jad_s_iv = inflate;
            this.jad_s_jw = 2;
        }
    }

    public final void jad_s_an(@androidx.annotation.NonNull android.view.View view, int i) {
        this.jad_s_jt = view;
        if (view != null) {
            com.jd.ad.sdk.mdt.servicemediator.JADMediator.getInstance().getExposureService().registerExposureView(this.jad_s_dq);
            android.view.View view2 = this.jad_s_jt;
            com.jd.ad.sdk.mdt.servicemediator.JADMediator.getInstance().getExposureService().setViewExposureCallback(this.jad_s_dq, 1, view2, new com.jd.ad.sdk.jad_s_an.jad_s_er(this, i, view2));
        }
        if (this.jad_s_iv != null) {
            com.jd.ad.sdk.mdt.servicemediator.JADMediator.getInstance().getTouchService().registerTouchView(this.jad_s_dq);
            if (i == 3) {
                try {
                    if (jad_s_an() != null) {
                        com.jd.ad.sdk.mdt.servicemediator.JADMediator.getInstance().getDynamicRenderService().registerAdViewClick(jad_s_an(), (com.jd.ad.sdk.bl.dynamicrender.DynamicRenderView) this.jad_s_jt, new com.jd.ad.sdk.jad_s_an.jad_s_fs(this));
                    }
                } catch (java.lang.Exception e) {
                    com.jd.ad.sdk.logger.Logger.d(android.util.Log.getStackTraceString(e));
                }
            } else if (this.jad_s_ob) {
                try {
                    if (jad_s_an() != null) {
                        com.jd.ad.sdk.mdt.servicemediator.JADMediator.getInstance().getVideoRenderService().registerAdViewClick(jad_s_an(), (com.jd.ad.sdk.bl.video.VideoRenderView) this.jad_s_jt, new com.jd.ad.sdk.jad_s_an.jad_s_jt(this));
                    }
                } catch (java.lang.Exception e2) {
                    com.jd.ad.sdk.logger.Logger.d(android.util.Log.getStackTraceString(e2));
                }
            } else {
                android.view.View view3 = this.jad_s_iv;
                if (view3 != null) {
                    view3.setClickable(true);
                    this.jad_s_iv.setOnTouchListener(new com.jd.ad.sdk.jad_s_an.jad_s_hu(this));
                    this.jad_s_iv.setOnClickListener(new com.jd.ad.sdk.jad_s_an.jad_s_an(this));
                }
            }
        }
        com.jd.ad.sdk.splash.jad_s_an.jad_s_cp jad_s_cpVar = this.jad_s_hu;
        if (jad_s_cpVar != null) {
            com.jd.ad.sdk.splash.JADSplash.this.callbackAdReadyOnUiThread(view);
        }
    }

    public final void jad_s_an(android.widget.ImageView imageView, android.view.View view) {
        if (jad_s_an() == null) {
            com.jd.ad.sdk.mdt.service.JADEventService eventService = com.jd.ad.sdk.mdt.servicemediator.JADMediator.getInstance().getEventService();
            java.lang.String str = this.jad_s_er;
            com.jd.ad.sdk.dl.error.JADError jADError = com.jd.ad.sdk.dl.error.JADError.RENDER_IMAGE_LOAD_FAIL_ERROR;
            eventService.reportRenderFailedEvent(str, jADError.getCode(), jad_s_an(jADError.getMessage(new java.lang.String[0])), this.jad_s_fs);
            jad_s_an(jADError.getCode(), jADError.getMessage(new java.lang.String[0]));
            return;
        }
        if (!android.text.TextUtils.isEmpty(this.jad_s_cp)) {
            com.jd.ad.sdk.mdt.servicemediator.JADMediator.getInstance().getFoundationService().loadImage(jad_s_an(), this.jad_s_cp, new com.jd.ad.sdk.splash.jad_s_an.C0416jad_s_an(imageView, view));
            return;
        }
        com.jd.ad.sdk.mdt.service.JADEventService eventService2 = com.jd.ad.sdk.mdt.servicemediator.JADMediator.getInstance().getEventService();
        java.lang.String str2 = this.jad_s_er;
        com.jd.ad.sdk.dl.error.JADError jADError2 = com.jd.ad.sdk.dl.error.JADError.RENDER_IMAGE_URL_IS_NULL_ERROR;
        eventService2.reportRenderFailedEvent(str2, jADError2.getCode(), jad_s_an(jADError2.getMessage(new java.lang.String[0])), this.jad_s_fs);
        jad_s_an(jADError2.getCode(), jADError2.getMessage(new java.lang.String[0]));
    }

    public final android.widget.FrameLayout.LayoutParams jad_s_bo() {
        return new android.widget.FrameLayout.LayoutParams(-1, -2);
    }

    public void jad_s_bo(int i, java.lang.String str) {
        try {
            com.jd.ad.sdk.mdt.servicemediator.JADMediator.getInstance().getEventService().reportRenderFailedEvent(this.jad_s_er, i, jad_s_an(str), this.jad_s_fs);
            com.jd.ad.sdk.splash.jad_s_an.jad_s_cp jad_s_cpVar = this.jad_s_hu;
            if (jad_s_cpVar != null) {
                com.jd.ad.sdk.splash.JADSplash.this.callbackAdRenderFailedOnUiThread(i, str);
            }
        } catch (java.lang.Exception e) {
            com.jd.ad.sdk.logger.Logger.d(android.util.Log.getStackTraceString(e));
        }
    }

    public com.jd.ad.sdk.bl.dynamicrender.DynamicRenderView jad_s_cp() {
        android.view.View view = this.jad_s_jt;
        if (view == null || !(view instanceof com.jd.ad.sdk.bl.dynamicrender.DynamicRenderView)) {
            return null;
        }
        return (com.jd.ad.sdk.bl.dynamicrender.DynamicRenderView) view;
    }

    @Override // com.jd.ad.sdk.bl.dynamicrender.DynamicRenderView.IDynamicRenderCallback
    public void onAnimationEnd() {
        com.jd.ad.sdk.splash.jad_s_an.jad_s_cp jad_s_cpVar = this.jad_s_hu;
        if (jad_s_cpVar != null) {
            com.jd.ad.sdk.splash.JADSplash.jad_s_er jad_s_erVar = (com.jd.ad.sdk.splash.JADSplash.jad_s_er) jad_s_cpVar;
            com.jd.ad.sdk.splash.JADSplash.this.callbackAdCloseOnUiThread();
            com.jd.ad.sdk.splash.JADSplash.this.destroy();
        }
    }

    @Override // com.jd.ad.sdk.bl.dynamicrender.DynamicRenderView.IDynamicRenderCallback
    public void onDynamicRenderFailed(int i, java.lang.String str) {
        if (jad_s_an() == null) {
            com.jd.ad.sdk.dl.error.JADError jADError = com.jd.ad.sdk.dl.error.JADError.RENDER_IMAGE_LOAD_FAIL_ERROR;
            com.jd.ad.sdk.mdt.servicemediator.JADMediator.getInstance().getEventService().reportRenderFailedEvent(this.jad_s_er, jADError.getCode(), jad_s_an(jADError.getMessage(new java.lang.String[0])), this.jad_s_fs);
            jad_s_an(jADError.getCode(), jADError.getMessage(new java.lang.String[0]));
            return;
        }
        android.content.Context jad_s_an = jad_s_an();
        com.jd.ad.sdk.dl.error.JADError jADError2 = com.jd.ad.sdk.dl.error.JADError.RENDER_CREATE_AD_VIEW_FAIL_ERROR;
        int code = jADError2.getCode();
        java.lang.String message = jADError2.getMessage(new java.lang.String[0]);
        if (jad_s_an == null || this.jad_s_bo == null) {
            com.jd.ad.sdk.mdt.servicemediator.JADMediator.getInstance().getEventService().reportRenderFailedEvent(this.jad_s_er, code, message, this.jad_s_fs);
            jad_s_an(code, message);
        }
        this.jad_s_bo.setRem(1);
        int templateId = this.jad_s_bo.getTemplateId();
        android.view.View view = null;
        if (templateId == com.jd.ad.sdk.dl.common.CommonConstants.AdTmp.TEMPLATE_SPLASH_SINGLE_IMAGE_4.getTemplateId() || templateId == com.jd.ad.sdk.dl.common.CommonConstants.AdTmp.TEMPLATE_SPLASH_SINGLE_IMAGE_8.getTemplateId()) {
            try {
                view = android.view.LayoutInflater.from(jad_s_an).inflate(com.jd.ad.sdk.fdt.utils.ResourceUtils.getResourceId(jad_s_an, "jad_splash_layout", "layout"), (android.view.ViewGroup) null);
            } catch (java.lang.Exception e) {
                com.jd.ad.sdk.logger.Logger.w("Exception while render: " + e, new java.lang.Object[0]);
            }
        } else {
            com.jd.ad.sdk.dl.error.JADError jADError3 = com.jd.ad.sdk.dl.error.JADError.RENDER_SPLASH_RESPONSE_TEMPLATE_ID_ERROR;
            code = jADError3.getCode();
            message = jADError3.getMessage(new java.lang.String[0]);
        }
        if (view == null) {
            com.jd.ad.sdk.mdt.servicemediator.JADMediator.getInstance().getEventService().reportRenderFailedEvent(this.jad_s_er, code, message, this.jad_s_fs);
            jad_s_an(code, message);
            return;
        }
        android.view.ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        int dip2px = (int) com.jd.ad.sdk.fdt.utils.ScreenUtils.dip2px(jad_s_an, this.jad_s_bo.getWidth());
        int dip2px2 = (int) com.jd.ad.sdk.fdt.utils.ScreenUtils.dip2px(jad_s_an, this.jad_s_bo.getHeight());
        if (layoutParams == null) {
            layoutParams = new android.widget.FrameLayout.LayoutParams(dip2px, dip2px2);
        } else {
            layoutParams.height = dip2px2;
            layoutParams.width = dip2px;
        }
        view.setLayoutParams(layoutParams);
        try {
            this.jad_s_kx = (com.jd.ad.sdk.splash.JADSplashSkipView) view.findViewById(com.jd.ad.sdk.fdt.utils.ResourceUtils.getResourceId(jad_s_an, "jad_splash_skip_btn", "id"));
        } catch (java.lang.Exception e2) {
            com.jd.ad.sdk.logger.Logger.d("Exception while render: " + e2);
        }
        if (this.jad_s_kx != null) {
            if (this.jad_s_bo.isHideSkip()) {
                this.jad_s_kx.setVisibility(8);
            } else {
                this.jad_s_kx.setVisibility(0);
            }
            com.jd.ad.sdk.splash.JADSplashSkipView jADSplashSkipView = this.jad_s_kx;
            int skipTime = this.jad_s_bo.getSkipTime();
            com.jd.ad.sdk.splash.jad_s_cp jad_s_cpVar = new com.jd.ad.sdk.splash.jad_s_cp(this);
            jADSplashSkipView.jad_s_an = skipTime;
            jADSplashSkipView.jad_s_bo = jad_s_cpVar;
            jADSplashSkipView.setOnClickListener(new com.jd.ad.sdk.splash.jad_s_er(jADSplashSkipView));
        }
        try {
            android.widget.ImageView imageView = (android.widget.ImageView) view.findViewById(com.jd.ad.sdk.fdt.utils.ResourceUtils.getResourceId(jad_s_an(), "jad_splash_image", "id"));
            jad_s_an(imageView, view);
            jad_s_an(jad_s_an(), view, imageView);
        } catch (java.lang.Exception e3) {
            com.jd.ad.sdk.mdt.service.JADEventService eventService = com.jd.ad.sdk.mdt.servicemediator.JADMediator.getInstance().getEventService();
            java.lang.String str2 = this.jad_s_er;
            com.jd.ad.sdk.dl.error.JADError jADError4 = com.jd.ad.sdk.dl.error.JADError.RENDER_CREATE_AD_VIEW_FAIL_ERROR;
            eventService.reportRenderFailedEvent(str2, jADError4.getCode(), jADError4.getMessage(e3.toString()), this.jad_s_fs);
            jad_s_an(jADError4.getCode(), jADError4.getMessage(e3.toString()));
        }
    }

    @Override // com.jd.ad.sdk.bl.dynamicrender.DynamicRenderView.IDynamicRenderCallback
    public void onDynamicRenderSuccess(android.view.View view) {
        try {
            com.jd.ad.sdk.dl.error.JADError jADError = com.jd.ad.sdk.dl.error.JADError.RENDER_CREATE_AD_VIEW_FAIL_ERROR;
            int code = jADError.getCode();
            java.lang.String message = jADError.getMessage(new java.lang.String[0]);
            if (view != null && this.jad_s_bo != null) {
                this.jad_s_iv = view;
                jad_s_an(view, 3);
                return;
            }
            com.jd.ad.sdk.mdt.servicemediator.JADMediator.getInstance().getEventService().reportRenderFailedEvent(this.jad_s_er, code, message, this.jad_s_fs);
            jad_s_an(code, message);
        } catch (java.lang.Exception e) {
            com.jd.ad.sdk.dl.error.JADError jADError2 = com.jd.ad.sdk.dl.error.JADError.RENDER_CREATE_AD_VIEW_FAIL_ERROR;
            jad_s_an(jADError2.getCode(), jADError2.getMessage(e.toString()));
        }
    }

    @Override // com.jd.ad.sdk.bl.dynamicrender.DynamicRenderView.IDynamicRenderCallback
    public /* synthetic */ void onFullLottieViewClick(android.content.Context context) {
        defpackage.f70.b(this, context);
    }
}
