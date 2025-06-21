package com.jd.ad.sdk.bl.dynamicrender;

/* loaded from: classes23.dex */
public class DynamicRenderView extends android.widget.FrameLayout {
    public static final /* synthetic */ int jad_sd = 0;
    public double jad_an;
    public double jad_bo;
    public com.jd.ad.sdk.bl.dynamicrender.DynamicRenderView.IDynamicRenderCallback jad_cn;
    public double jad_cp;
    public com.jd.ad.sdk.bl.dynamicrender.listener.IDynamicCountdownListener jad_do;
    public double jad_dq;
    public int jad_ep;
    public double jad_er;
    public final java.util.concurrent.CountDownLatch jad_fq;
    public boolean jad_fs;
    public boolean jad_gr;
    public java.lang.Exception jad_hs;
    public com.jd.ad.sdk.bl.dynamicrender.ShakeListener jad_hu;
    public java.lang.Exception jad_it;
    public java.lang.String jad_iv;
    public int jad_jt;
    public int jad_ju;
    public double jad_jw;
    public float jad_kv;
    public double jad_kx;
    public float jad_lw;
    public java.lang.String jad_ly;
    public float jad_mx;
    public double jad_mz;
    public double jad_na;
    public float jad_ny;
    public int jad_ob;
    public float jad_oz;
    public boolean jad_pa;
    public int jad_pc;
    public com.jd.ad.sdk.bl.dynamicrender.DynamicRenderView.jad_er jad_qb;
    public int jad_qd;
    public final java.lang.Runnable jad_rc;
    public int jad_re;
    public com.jd.ad.sdk.lottie.LottieAnimationView jad_sf;
    public java.util.List<java.lang.String> jad_tg;
    public java.util.List<java.lang.String> jad_uh;
    public java.util.List<java.lang.String> jad_vi;
    public final java.util.Map<java.lang.String, com.jd.ad.sdk.jad_hu.jad_an> jad_wj;
    public java.lang.String jad_xk;
    public final org.json.JSONObject jad_yl;
    public final java.util.Map<java.lang.String, android.graphics.Bitmap> jad_zm;

    public interface IDynamicRenderCallback {
        void onAnimationEnd();

        void onDynamicRenderFailed(int i, java.lang.String str);

        void onDynamicRenderSuccess(android.view.View view);

        void onFullLottieViewClick(android.content.Context context);
    }

    public class jad_an implements java.lang.Runnable {
        public jad_an() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.jd.ad.sdk.bl.dynamicrender.DynamicRenderView dynamicRenderView = com.jd.ad.sdk.bl.dynamicrender.DynamicRenderView.this;
            com.jd.ad.sdk.bl.dynamicrender.listener.IDynamicCountdownListener iDynamicCountdownListener = dynamicRenderView.jad_do;
            if (iDynamicCountdownListener != null) {
                iDynamicCountdownListener.onAdCountdown(dynamicRenderView.jad_ep);
            }
            com.jd.ad.sdk.bl.dynamicrender.DynamicRenderView dynamicRenderView2 = com.jd.ad.sdk.bl.dynamicrender.DynamicRenderView.this;
            if (dynamicRenderView2.jad_fs) {
                dynamicRenderView2.jad_ep--;
            }
            if (dynamicRenderView2.jad_ep > 0) {
                dynamicRenderView2.postDelayed(dynamicRenderView2.jad_rc, 1000L);
            } else {
                dynamicRenderView2.removeCallbacks(dynamicRenderView2.jad_rc);
            }
        }
    }

    public class jad_bo extends com.jd.ad.sdk.jad_fo.jad_an<android.graphics.Bitmap> {
        public final /* synthetic */ com.jd.ad.sdk.jad_lu.jad_na jad_dq;
        public final /* synthetic */ java.util.Map jad_er;

        public jad_bo(com.jd.ad.sdk.jad_lu.jad_na jad_naVar, java.util.Map map) {
            this.jad_dq = jad_naVar;
            this.jad_er = map;
        }

        @Override // com.jd.ad.sdk.jad_fo.jad_er
        public void jad_an(@androidx.annotation.Nullable android.graphics.drawable.Drawable drawable) {
        }

        @Override // com.jd.ad.sdk.jad_fo.jad_er
        public void jad_an(@androidx.annotation.NonNull java.lang.Object obj, @androidx.annotation.Nullable com.jd.ad.sdk.jad_gp.jad_bo jad_boVar) {
            com.jd.ad.sdk.jad_lu.jad_na jad_naVar = this.jad_dq;
            com.jd.ad.sdk.bl.dynamicrender.DynamicRenderView.this.jad_zm.put(this.jad_dq.jad_cp, com.jd.ad.sdk.jad_hu.jad_hu.jad_an((android.graphics.Bitmap) obj, jad_naVar.jad_an, jad_naVar.jad_bo));
            java.util.Map map = this.jad_er;
            if (map == null || map.size() != com.jd.ad.sdk.bl.dynamicrender.DynamicRenderView.this.jad_zm.size()) {
                return;
            }
            try {
                com.jd.ad.sdk.bl.dynamicrender.DynamicRenderView.this.jad_fq.await();
                com.jd.ad.sdk.bl.dynamicrender.DynamicRenderView dynamicRenderView = com.jd.ad.sdk.bl.dynamicrender.DynamicRenderView.this;
                com.jd.ad.sdk.bl.dynamicrender.DynamicRenderView.IDynamicRenderCallback iDynamicRenderCallback = dynamicRenderView.jad_cn;
                if (iDynamicRenderCallback != null) {
                    if (dynamicRenderView.jad_gr) {
                        iDynamicRenderCallback.onDynamicRenderSuccess(dynamicRenderView);
                    } else {
                        com.jd.ad.sdk.dl.error.JADError jADError = com.jd.ad.sdk.dl.error.JADError.RENDER_IMAGE_LOAD_FAIL_ERROR;
                        iDynamicRenderCallback.onDynamicRenderFailed(jADError.getCode(), jADError.getMessage(new java.lang.String[0]));
                    }
                }
            } catch (java.lang.Exception unused) {
                com.jd.ad.sdk.bl.dynamicrender.DynamicRenderView.IDynamicRenderCallback iDynamicRenderCallback2 = com.jd.ad.sdk.bl.dynamicrender.DynamicRenderView.this.jad_cn;
                if (iDynamicRenderCallback2 != null) {
                    com.jd.ad.sdk.dl.error.JADError jADError2 = com.jd.ad.sdk.dl.error.JADError.RENDER_IMAGE_LOAD_FAIL_ERROR;
                    iDynamicRenderCallback2.onDynamicRenderFailed(jADError2.getCode(), jADError2.getMessage(new java.lang.String[0]));
                }
            }
        }

        @Override // com.jd.ad.sdk.jad_fo.jad_an, com.jd.ad.sdk.jad_fo.jad_er
        public void jad_cp(@androidx.annotation.Nullable android.graphics.drawable.Drawable drawable) {
            com.jd.ad.sdk.bl.dynamicrender.DynamicRenderView.IDynamicRenderCallback iDynamicRenderCallback;
            com.jd.ad.sdk.bl.dynamicrender.DynamicRenderView dynamicRenderView = com.jd.ad.sdk.bl.dynamicrender.DynamicRenderView.this;
            if (dynamicRenderView.jad_pa || (iDynamicRenderCallback = dynamicRenderView.jad_cn) == null) {
                return;
            }
            dynamicRenderView.jad_pa = true;
            com.jd.ad.sdk.dl.error.JADError jADError = com.jd.ad.sdk.dl.error.JADError.RENDER_IMAGE_LOAD_FAIL_ERROR;
            iDynamicRenderCallback.onDynamicRenderFailed(jADError.getCode(), jADError.getMessage(new java.lang.String[0]));
        }
    }

    public class jad_cp implements java.lang.Runnable {
        public final /* synthetic */ android.content.Context jad_an;

        public jad_cp(android.content.Context context) {
            this.jad_an = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.jd.ad.sdk.bl.dynamicrender.DynamicRenderView dynamicRenderView;
            com.jd.ad.sdk.lottie.LottieAnimationView lottieAnimationView;
            try {
            } catch (java.lang.Exception e) {
                java.lang.Thread.currentThread().interrupt();
                com.jd.ad.sdk.bl.dynamicrender.DynamicRenderView.this.jad_gr = false;
                com.jd.ad.sdk.bl.dynamicrender.DynamicRenderView dynamicRenderView2 = com.jd.ad.sdk.bl.dynamicrender.DynamicRenderView.this;
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                com.jd.ad.sdk.jad_wj.jad_an jad_anVar = com.jd.ad.sdk.jad_wj.jad_an.RENDER_DYNAMIC_VIEW_INIT_LOTTIE_PARSE_ERROR;
                sb.append(jad_anVar.jad_an);
                sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                sb.append(jad_anVar.jad_an(new java.lang.String[0]));
                dynamicRenderView2.jad_it = new java.lang.Exception(sb.toString(), e);
                dynamicRenderView = com.jd.ad.sdk.bl.dynamicrender.DynamicRenderView.this;
            }
            try {
                try {
                    com.jd.ad.sdk.bl.dynamicrender.DynamicRenderView dynamicRenderView3 = com.jd.ad.sdk.bl.dynamicrender.DynamicRenderView.this;
                    com.jd.ad.sdk.jad_lu.jad_sf<com.jd.ad.sdk.jad_lu.jad_jt> jad_an = com.jd.ad.sdk.jad_lu.jad_hu.jad_an(com.jd.ad.sdk.bl.dynamicrender.DynamicRenderView.jad_an(com.jd.ad.sdk.bl.dynamicrender.DynamicRenderView.this, dynamicRenderView3.jad_an(this.jad_an, dynamicRenderView3.jad_iv, dynamicRenderView3.jad_ly, dynamicRenderView3.jad_ob, dynamicRenderView3)), (java.lang.String) null);
                    java.lang.Throwable th = jad_an.jad_bo;
                    if (th != null) {
                        com.jd.ad.sdk.bl.dynamicrender.DynamicRenderView.this.jad_gr = false;
                        com.jd.ad.sdk.bl.dynamicrender.DynamicRenderView dynamicRenderView4 = com.jd.ad.sdk.bl.dynamicrender.DynamicRenderView.this;
                        java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                        com.jd.ad.sdk.jad_wj.jad_an jad_anVar2 = com.jd.ad.sdk.jad_wj.jad_an.RENDER_DYNAMIC_VIEW_INIT_LOTTIE_PARSE_ERROR;
                        sb2.append(jad_anVar2.jad_an);
                        sb2.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                        sb2.append(jad_anVar2.jad_an(new java.lang.String[0]));
                        dynamicRenderView4.jad_it = new java.lang.Exception(sb2.toString(), th);
                    } else {
                        com.jd.ad.sdk.jad_lu.jad_jt jad_jtVar = jad_an.jad_an;
                        if (jad_jtVar == null) {
                            com.jd.ad.sdk.bl.dynamicrender.DynamicRenderView.this.jad_gr = false;
                            com.jd.ad.sdk.bl.dynamicrender.DynamicRenderView dynamicRenderView5 = com.jd.ad.sdk.bl.dynamicrender.DynamicRenderView.this;
                            java.lang.StringBuilder sb3 = new java.lang.StringBuilder();
                            com.jd.ad.sdk.jad_wj.jad_an jad_anVar3 = com.jd.ad.sdk.jad_wj.jad_an.RENDER_DYNAMIC_VIEW_INIT_LOTTIE_PARSE_ERROR;
                            sb3.append(jad_anVar3.jad_an);
                            sb3.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                            sb3.append(jad_anVar3.jad_an(new java.lang.String[0]));
                            dynamicRenderView5.jad_it = new java.lang.Exception(sb3.toString());
                        } else {
                            com.jd.ad.sdk.bl.dynamicrender.DynamicRenderView.this.jad_sf.setComposition(jad_jtVar);
                            com.jd.ad.sdk.bl.dynamicrender.DynamicRenderView.jad_an(com.jd.ad.sdk.bl.dynamicrender.DynamicRenderView.this, this.jad_an);
                            com.jd.ad.sdk.lottie.LottieAnimationView lottieAnimationView2 = com.jd.ad.sdk.bl.dynamicrender.DynamicRenderView.this.jad_sf;
                            if (lottieAnimationView2 != null) {
                                try {
                                    lottieAnimationView2.setFontAssetDelegate(new com.jd.ad.sdk.jad_hu.jad_er());
                                } catch (java.lang.Exception e2) {
                                    e2.printStackTrace();
                                }
                            }
                            com.jd.ad.sdk.bl.dynamicrender.DynamicRenderView dynamicRenderView6 = com.jd.ad.sdk.bl.dynamicrender.DynamicRenderView.this;
                            com.jd.ad.sdk.lottie.LottieAnimationView lottieAnimationView3 = dynamicRenderView6.jad_sf;
                            android.content.Context context = this.jad_an;
                            java.util.Map<java.lang.String, android.graphics.Bitmap> map = dynamicRenderView6.jad_zm;
                            if (lottieAnimationView3 != null && context != null) {
                                lottieAnimationView3.setImageAssetDelegate(new com.jd.ad.sdk.jad_hu.jad_jt(map, context));
                            }
                            com.jd.ad.sdk.bl.dynamicrender.DynamicRenderView dynamicRenderView7 = com.jd.ad.sdk.bl.dynamicrender.DynamicRenderView.this;
                            android.content.Context context2 = this.jad_an;
                            com.jd.ad.sdk.lottie.LottieAnimationView lottieAnimationView4 = dynamicRenderView7.jad_sf;
                            if (lottieAnimationView4 != null && context2 != null) {
                                lottieAnimationView4.jad_er.jad_cp.jad_bo.add(new com.jd.ad.sdk.bl.dynamicrender.jad_an(dynamicRenderView7, context2));
                            }
                            com.jd.ad.sdk.bl.dynamicrender.DynamicRenderView dynamicRenderView8 = com.jd.ad.sdk.bl.dynamicrender.DynamicRenderView.this;
                            double d = dynamicRenderView8.jad_kx;
                            if (d > 0.0d) {
                                double d2 = dynamicRenderView8.jad_er;
                                if (d2 > 0.0d && dynamicRenderView8.jad_jw / d != dynamicRenderView8.jad_dq / d2 && (lottieAnimationView = dynamicRenderView8.jad_sf) != null) {
                                    lottieAnimationView.setScaleType(android.widget.ImageView.ScaleType.FIT_XY);
                                }
                            }
                            com.jd.ad.sdk.bl.dynamicrender.DynamicRenderView.jad_an(com.jd.ad.sdk.bl.dynamicrender.DynamicRenderView.this);
                        }
                    }
                    dynamicRenderView = com.jd.ad.sdk.bl.dynamicrender.DynamicRenderView.this;
                    dynamicRenderView.jad_fq.countDown();
                } catch (java.lang.Exception e3) {
                    java.lang.StringBuilder sb4 = new java.lang.StringBuilder();
                    com.jd.ad.sdk.jad_wj.jad_an jad_anVar4 = com.jd.ad.sdk.jad_wj.jad_an.RENDER_DYNAMIC_VIEW_INIT_VAR_REPLACE_ERROR;
                    sb4.append(jad_anVar4.jad_an);
                    sb4.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                    sb4.append(jad_anVar4.jad_an(new java.lang.String[0]));
                    throw new java.lang.Exception(sb4.toString(), e3);
                }
            } catch (java.lang.Throwable th2) {
                com.jd.ad.sdk.bl.dynamicrender.DynamicRenderView.this.jad_fq.countDown();
                throw th2;
            }
        }
    }

    public class jad_dq implements java.lang.Runnable {
        public final /* synthetic */ com.jd.ad.sdk.bl.dynamicrender.DynamicRenderView jad_an;
        public final /* synthetic */ android.content.Context jad_bo;
        public final /* synthetic */ org.json.JSONObject jad_cp;
        public final /* synthetic */ java.lang.String jad_dq;

        public jad_dq(com.jd.ad.sdk.bl.dynamicrender.DynamicRenderView dynamicRenderView, com.jd.ad.sdk.bl.dynamicrender.DynamicRenderView dynamicRenderView2, android.content.Context context, org.json.JSONObject jSONObject, java.lang.String str) {
            this.jad_an = dynamicRenderView2;
            this.jad_bo = context;
            this.jad_cp = jSONObject;
            this.jad_dq = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                com.jd.ad.sdk.bl.dynamicrender.DynamicRenderView dynamicRenderView = this.jad_an;
                if (dynamicRenderView != null) {
                    dynamicRenderView.jad_an(this.jad_bo, this.jad_cp, this.jad_dq);
                }
            } catch (java.lang.Exception unused) {
                java.lang.Thread.currentThread().interrupt();
            }
        }
    }

    public class jad_er implements com.jd.ad.sdk.fdt.utils.ActLifecycle.jad_an {
        public jad_er() {
        }

        @Override // com.jd.ad.sdk.fdt.utils.ActLifecycle.jad_an
        public void jad_an() {
        }

        @Override // com.jd.ad.sdk.fdt.utils.ActLifecycle.jad_an
        public void jad_bo() {
            com.jd.ad.sdk.bl.dynamicrender.DynamicRenderView dynamicRenderView = com.jd.ad.sdk.bl.dynamicrender.DynamicRenderView.this;
            int i = com.jd.ad.sdk.bl.dynamicrender.DynamicRenderView.jad_sd;
            dynamicRenderView.jad_dq();
        }
    }

    public static class jad_fs {
        public java.lang.String jad_an;
        public float jad_bo;
        public float jad_cp;
        public java.util.List<java.lang.String> jad_dq = new java.util.ArrayList();
        public java.util.List<java.lang.String> jad_er = new java.util.ArrayList();
        public java.util.List<java.lang.String> jad_fs = new java.util.ArrayList();
        public int jad_hu;
        public int jad_iv;
        public com.jd.ad.sdk.bl.dynamicrender.DynamicRenderView.IDynamicRenderCallback jad_jt;
        public java.lang.String jad_jw;
        public float jad_kx;
        public float jad_ly;
        public int jad_mz;
    }

    public DynamicRenderView(android.content.Context context, com.jd.ad.sdk.bl.dynamicrender.DynamicRenderView.jad_fs jad_fsVar) {
        super(context);
        this.jad_an = 1.0d;
        this.jad_bo = 1.0d;
        this.jad_cp = 1.0d;
        this.jad_fs = true;
        this.jad_jt = 0;
        this.jad_tg = new java.util.ArrayList();
        this.jad_uh = new java.util.ArrayList();
        this.jad_vi = new java.util.ArrayList();
        this.jad_wj = new java.util.HashMap();
        this.jad_yl = new org.json.JSONObject();
        this.jad_zm = new java.util.HashMap();
        this.jad_gr = true;
        this.jad_hs = null;
        this.jad_it = null;
        this.jad_ju = 100;
        this.jad_kv = 0.0f;
        this.jad_lw = 1.0f;
        this.jad_mx = 0.0f;
        this.jad_ny = 0.0f;
        this.jad_oz = 45.0f;
        this.jad_pa = false;
        this.jad_rc = new com.jd.ad.sdk.bl.dynamicrender.DynamicRenderView.jad_an();
        jad_bo();
        jad_an();
        this.jad_fq = new java.util.concurrent.CountDownLatch(1);
        jad_an(jad_fsVar, context);
        jad_an(context);
    }

    public static java.lang.String jad_an(com.jd.ad.sdk.bl.dynamicrender.DynamicRenderView dynamicRenderView, int i, int i2) {
        java.util.Iterator<java.lang.String> it = dynamicRenderView.jad_wj.keySet().iterator();
        com.jd.ad.sdk.jad_hu.jad_an jad_anVar = null;
        while (it.hasNext()) {
            com.jd.ad.sdk.jad_hu.jad_an jad_anVar2 = dynamicRenderView.jad_wj.get(it.next());
            if (jad_anVar2 != null && jad_anVar2.jad_bo.contains(i, i2)) {
                if (jad_anVar != null) {
                    if (jad_anVar.jad_cp > jad_anVar2.jad_cp) {
                    }
                }
                jad_anVar = jad_anVar2;
            }
        }
        return jad_anVar == null ? "" : jad_anVar.jad_an;
    }

    public static java.lang.String jad_an(com.jd.ad.sdk.bl.dynamicrender.DynamicRenderView dynamicRenderView, java.lang.String str) {
        java.lang.String str2;
        java.lang.String str3;
        java.lang.String str4;
        org.json.JSONObject jSONObject;
        org.json.JSONArray jSONArray;
        int i;
        java.lang.String str5 = "a";
        java.lang.String str6 = "layers";
        java.lang.String str7 = "k";
        dynamicRenderView.getClass();
        int i2 = 0;
        try {
            org.json.JSONObject jSONObject2 = new org.json.JSONObject(str);
            dynamicRenderView.jad_cp();
            dynamicRenderView.setTransformParams(jSONObject2);
            org.json.JSONArray jSONArray2 = jSONObject2.getJSONArray("layers");
            org.json.JSONArray jSONArray3 = new org.json.JSONArray();
            int i3 = 0;
            while (i3 < jSONArray2.length()) {
                org.json.JSONObject jSONObject3 = jSONArray2.getJSONObject(i3);
                java.lang.String str8 = (java.lang.String) jSONObject3.get("nm");
                if (dynamicRenderView.jad_vi.contains(str8)) {
                    str2 = str5;
                    str3 = str6;
                    str4 = str7;
                    jSONObject = jSONObject2;
                    jSONArray = jSONArray2;
                } else {
                    org.json.JSONObject jSONObject4 = jSONObject3.getJSONObject(com.bytedance.sdk.openadsdk.mediation.MediationConstant.ADN_KS);
                    org.json.JSONArray jSONArray4 = jSONObject4.getJSONObject("p").getJSONArray(str7);
                    org.json.JSONArray jSONArray5 = jSONObject4.getJSONObject("s").getJSONArray(str7);
                    org.json.JSONArray jSONArray6 = jSONObject4.getJSONObject(str5).getJSONArray(str7);
                    double d = jSONArray5.getDouble(i2);
                    double d2 = jSONArray5.getDouble(1);
                    jSONObject = jSONObject2;
                    if (dynamicRenderView.jad_tg.contains(str8)) {
                        jSONArray = jSONArray2;
                        jSONArray5.put(0, dynamicRenderView.jad_an * d);
                        jSONArray5.put(1, dynamicRenderView.jad_bo * d2);
                        dynamicRenderView.setFixedLayerPosition(jSONArray4);
                    } else {
                        jSONArray = jSONArray2;
                    }
                    if (dynamicRenderView.jad_uh.contains(str8)) {
                        jSONArray5.put(1, dynamicRenderView.jad_cp * d2);
                        org.json.JSONArray jSONArray7 = jSONObject4.getJSONObject(str5).getJSONArray(str7);
                        str2 = str5;
                        str3 = str6;
                        str4 = str7;
                        jSONArray4.put(1, java.lang.Double.valueOf(java.lang.Double.valueOf(jSONArray4.getDouble(1)).doubleValue() - (jSONArray7.getDouble(1) * (dynamicRenderView.jad_cp - 1.0d))));
                    } else {
                        str2 = str5;
                        str3 = str6;
                        str4 = str7;
                    }
                    if ("sdkMaterialImage".equals(str8)) {
                        double d3 = dynamicRenderView.jad_mz;
                        if (d3 != 0.0d) {
                            double d4 = dynamicRenderView.jad_jw;
                            if (d4 != 0.0d) {
                                double d5 = ((dynamicRenderView.jad_kx / d4) / (dynamicRenderView.jad_na / d3)) * d;
                                double d6 = 100.0d;
                                if (d5 < 100.0d) {
                                    i = 0;
                                    d6 = (100.0d / d5) * 100.0d;
                                    d5 = 100.0d;
                                } else {
                                    i = 0;
                                }
                                jSONArray5.put(i, d5);
                                jSONArray5.put(1, d6);
                            }
                        }
                    }
                    org.json.JSONObject jSONObject5 = new org.json.JSONObject();
                    jSONObject5.put("index", i3);
                    jSONObject5.put("rect", dynamicRenderView.jad_an(jSONArray4, jSONArray6, jSONObject3, jSONArray5));
                    dynamicRenderView.jad_yl.put(str8, jSONObject5);
                    jSONArray3.put(jSONObject3);
                }
                i3++;
                str5 = str2;
                str6 = str3;
                str7 = str4;
                jSONObject2 = jSONObject;
                jSONArray2 = jSONArray;
                i2 = 0;
            }
            org.json.JSONObject jSONObject6 = jSONObject2;
            jSONObject6.put(str6, jSONArray3);
            return jSONObject6.toString();
        } catch (java.lang.Exception e) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            com.jd.ad.sdk.jad_wj.jad_an jad_anVar = com.jd.ad.sdk.jad_wj.jad_an.RENDER_DYNAMIC_VIEW_INIT_JSON_PARSE_ERROR;
            sb.append(jad_anVar.jad_an);
            sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER);
            sb.append(jad_anVar.jad_an(new java.lang.String[0]));
            throw new java.lang.Exception(sb.toString(), e);
        }
    }

    public static void jad_an(com.jd.ad.sdk.bl.dynamicrender.DynamicRenderView dynamicRenderView) {
        android.view.ViewGroup.LayoutParams layoutParams = dynamicRenderView.getLayoutParams();
        int i = (int) dynamicRenderView.jad_jw;
        int i2 = (int) dynamicRenderView.jad_kx;
        if (layoutParams == null) {
            layoutParams = new android.widget.FrameLayout.LayoutParams(i, i2);
        } else {
            layoutParams.height = i2;
            layoutParams.width = i;
        }
        dynamicRenderView.setLayoutParams(layoutParams);
    }

    public static void jad_an(com.jd.ad.sdk.bl.dynamicrender.DynamicRenderView dynamicRenderView, android.content.Context context) {
        com.jd.ad.sdk.lottie.LottieAnimationView lottieAnimationView = dynamicRenderView.jad_sf;
        if (lottieAnimationView == null) {
            return;
        }
        lottieAnimationView.setOnTouchListener(new com.jd.ad.sdk.jad_hu.jad_iv(dynamicRenderView, context));
        dynamicRenderView.jad_sf.setOnClickListener(new com.jd.ad.sdk.bl.dynamicrender.jad_bo(dynamicRenderView, context));
    }

    public static boolean jad_an(com.jd.ad.sdk.bl.dynamicrender.DynamicRenderView dynamicRenderView, android.view.View view) {
        dynamicRenderView.getClass();
        return view != null && view.getGlobalVisibleRect(new android.graphics.Rect()) && view.isShown();
    }

    private void setCanvasWH(org.json.JSONObject jSONObject) {
        this.jad_dq = jSONObject.getInt(com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.WIDTH);
        this.jad_er = jSONObject.getInt("h");
    }

    private void setFixedLayerPosition(org.json.JSONArray jSONArray) {
        java.lang.Double valueOf;
        java.lang.Double valueOf2;
        java.lang.Double valueOf3 = java.lang.Double.valueOf(jSONArray.getDouble(0));
        java.lang.Double valueOf4 = java.lang.Double.valueOf(jSONArray.getDouble(1));
        if (valueOf3.doubleValue() > this.jad_dq / 2.0d) {
            double doubleValue = valueOf3.doubleValue();
            double d = this.jad_an;
            valueOf = java.lang.Double.valueOf((doubleValue * d) - ((d - 1.0d) * this.jad_dq));
        } else {
            valueOf = java.lang.Double.valueOf(valueOf3.doubleValue() * this.jad_an);
        }
        if (valueOf4.doubleValue() > this.jad_er / 2.0d) {
            double doubleValue2 = valueOf4.doubleValue();
            double d2 = this.jad_bo;
            valueOf2 = java.lang.Double.valueOf((doubleValue2 * d2) - ((d2 - 1.0d) * this.jad_er));
        } else {
            valueOf2 = java.lang.Double.valueOf(valueOf4.doubleValue() * this.jad_bo);
        }
        jSONArray.put(0, valueOf);
        jSONArray.put(1, valueOf2);
    }

    private void setTransformParams(org.json.JSONObject jSONObject) {
        setCanvasWH(jSONObject);
        int i = this.jad_pc;
        double d = this.jad_dq;
        if (d > 0.0d && i > 0) {
            double d2 = this.jad_jw;
            if (d2 > 0.0d) {
                double d3 = d / i;
                this.jad_an = (d / d3) / d2;
                this.jad_bo = (this.jad_er / d3) / this.jad_kx;
            }
        }
        double d4 = this.jad_kx;
        if (d4 <= 0.0d || d <= 0.0d) {
            return;
        }
        double d5 = this.jad_er;
        if (d5 <= 0.0d) {
            return;
        }
        this.jad_cp = (this.jad_jw / d4) / (d / d5);
    }

    public void destroy() {
        try {
            jad_dq();
            com.jd.ad.sdk.bl.dynamicrender.DynamicRenderView.jad_er jad_erVar = this.jad_qb;
            java.util.concurrent.CopyOnWriteArrayList<com.jd.ad.sdk.fdt.utils.ActLifecycle.jad_an> copyOnWriteArrayList = com.jd.ad.sdk.fdt.utils.ActLifecycle.jad_bo;
            if (jad_erVar != null) {
                com.jd.ad.sdk.fdt.utils.ActLifecycle.jad_bo.remove(jad_erVar);
            }
            this.jad_qb = null;
        } catch (java.lang.Exception unused) {
        }
    }

    public int getAdAnimationType() {
        return this.jad_jt;
    }

    public int getAdClickAreaValue() {
        return this.jad_ju;
    }

    public java.lang.Exception getDynamicInitException() {
        return this.jad_it;
    }

    public java.lang.Exception getLoadImagesException() {
        return this.jad_hs;
    }

    public com.jd.ad.sdk.lottie.LottieAnimationView getLottieView() {
        return this.jad_sf;
    }

    public final android.graphics.Rect jad_an(org.json.JSONArray jSONArray, org.json.JSONArray jSONArray2, org.json.JSONObject jSONObject, org.json.JSONArray jSONArray3) {
        java.lang.Double valueOf;
        java.lang.Double valueOf2;
        double d = this.jad_dq;
        double d2 = d > 0.0d ? this.jad_jw / d : 1.0d;
        double d3 = this.jad_er;
        double d4 = d3 > 0.0d ? this.jad_kx / d3 : 1.0d;
        if (jSONObject.getInt(com.alipay.sdk.m.s.a.f86s) == 1) {
            valueOf = java.lang.Double.valueOf(jSONObject.getDouble("sw"));
            valueOf2 = java.lang.Double.valueOf(jSONObject.getDouble(com.anythink.expressad.foundation.d.d.t));
        } else {
            valueOf = java.lang.Double.valueOf(jSONObject.getDouble(com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.WIDTH));
            valueOf2 = java.lang.Double.valueOf(jSONObject.getDouble("h"));
        }
        double d5 = jSONArray3.getDouble(0) / 100.0d;
        double d6 = jSONArray3.getDouble(1) / 100.0d;
        int i = (int) (((jSONArray.getDouble(0) - jSONArray2.getDouble(0)) - ((d5 - 1.0d) * (valueOf.doubleValue() / 2.0d))) * d2);
        int i2 = (int) (((jSONArray.getDouble(1) - jSONArray2.getDouble(1)) - ((d6 - 1.0d) * (valueOf2.doubleValue() / 2.0d))) * d4);
        return new android.graphics.Rect(i, i2, ((int) (valueOf.doubleValue() * d5 * d2)) + i, ((int) (valueOf2.doubleValue() * d6 * d4)) + i2);
    }

    public java.lang.String jad_an(android.content.Context context, java.lang.String str, java.lang.String str2, int i, com.jd.ad.sdk.bl.dynamicrender.DynamicRenderView dynamicRenderView) {
        org.json.JSONObject jSONObject = new org.json.JSONObject(str);
        com.jd.ad.sdk.fdt.thread.WorkExecutor.execute(new com.jd.ad.sdk.bl.dynamicrender.DynamicRenderView.jad_dq(this, dynamicRenderView, context, jSONObject, str2));
        int optInt = jSONObject.optInt(com.anythink.expressad.video.dynview.a.a.U);
        if (i > 5) {
            org.json.JSONArray jSONArray = jSONObject.getJSONArray("layers");
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                org.json.JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                java.lang.String string = jSONObject2.getString("nm");
                int i3 = (i - 5) * optInt;
                if (string.equals("sdkStaticSkipButton")) {
                    jSONObject2.put("op", i3);
                }
                if (string.equals("sdkSkipButton")) {
                    jSONObject2.put("ip", i3);
                }
            }
            str = jSONObject.toString();
        }
        org.json.JSONObject optJSONObject = jSONObject.optJSONObject("countDownTemplate");
        if (optJSONObject != null) {
            java.lang.String jSONObject3 = optJSONObject.toString();
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            int i4 = i <= 5 ? i : 5;
            for (int i5 = i4; i5 > 0; i5--) {
                java.lang.StringBuilder jad_an2 = com.jd.ad.sdk.jad_bo.jad_bo.jad_an("");
                int i6 = (i - i5) * optInt;
                jad_an2.append(i6);
                java.lang.String replace = jSONObject3.replace("${startTime}", jad_an2.toString());
                java.lang.StringBuilder jad_an3 = com.jd.ad.sdk.jad_bo.jad_bo.jad_an("");
                jad_an3.append(i6 + optInt);
                java.lang.String replaceAll = replace.replace("${endTime}", jad_an3.toString()).replaceAll("\\$\\{count\\}", "" + i5);
                if (i5 != i4) {
                    sb.append(",");
                }
                sb.append(replaceAll);
            }
            str = str.replace("\"${countDown}\"", sb.toString());
        }
        int i7 = i * optInt;
        return str.replace("${materialImage}", str2).replace("${totalTime}", "" + i7);
    }

    public final java.util.Map<java.lang.String, com.jd.ad.sdk.jad_lu.jad_na> jad_an(org.json.JSONObject jSONObject, java.lang.String str) {
        int length;
        org.json.JSONArray jSONArray = jSONObject.getJSONArray("assets");
        if (jSONArray == null || (length = jSONArray.length()) == 0) {
            return null;
        }
        java.util.HashMap hashMap = new java.util.HashMap();
        for (int i = 0; i < length; i++) {
            org.json.JSONObject optJSONObject = jSONArray.optJSONObject(i);
            java.lang.String optString = optJSONObject.optString("p");
            java.lang.String optString2 = optJSONObject.optString(com.umeng.analytics.pro.bo.aN);
            java.lang.String optString3 = optJSONObject.optString("id");
            int optInt = optJSONObject.optInt(com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.WIDTH);
            int optInt2 = optJSONObject.optInt("h");
            if (!android.text.TextUtils.isEmpty(optString)) {
                hashMap.put(optString3, new com.jd.ad.sdk.jad_lu.jad_na(optInt, optInt2, optString3, optString.equals("${materialImage}") ? str : optString, optString2));
            }
        }
        return hashMap;
    }

    public final void jad_an() {
        com.jd.ad.sdk.jad_pc.jad_an jad_an2 = com.jd.ad.sdk.jad_re.jad_an.jad_an();
        if (jad_an2 == null) {
            return;
        }
        this.jad_kv = jad_an2.jad_cp;
        float f = jad_an2.jad_dq;
        this.jad_lw = f;
        float f2 = jad_an2.jad_jw;
        this.jad_oz = f2;
        this.jad_mx = jad_an2.jad_er;
        this.jad_ny = jad_an2.jad_fs;
        if (f <= 0.0f) {
            this.jad_lw = 1.0f;
        }
        if (f2 <= 0.0f) {
            this.jad_oz = 45.0f;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void jad_an(android.content.Context context) {
        try {
            android.view.View inflate = android.view.LayoutInflater.from(context).inflate(com.jd.ad.sdk.R.layout.jad_dynamic_render_layout, (android.view.ViewGroup) null);
            com.jd.ad.sdk.lottie.LottieAnimationView lottieAnimationView = (com.jd.ad.sdk.lottie.LottieAnimationView) inflate.findViewById(com.jd.ad.sdk.R.id.animation_view);
            this.jad_sf = lottieAnimationView;
            lottieAnimationView.setCacheComposition(false);
            addView(inflate);
            com.jd.ad.sdk.fdt.thread.WorkExecutor.execute(new com.jd.ad.sdk.bl.dynamicrender.DynamicRenderView.jad_cp(context));
        } finally {
        }
    }

    public void jad_an(android.content.Context context, org.json.JSONObject jSONObject, java.lang.String str) {
        try {
            java.util.Map<java.lang.String, com.jd.ad.sdk.jad_lu.jad_na> jad_an2 = jad_an(jSONObject, str);
            if (jad_an2 != null && !jad_an2.isEmpty()) {
                this.jad_pa = false;
                java.util.Iterator<java.lang.String> it = jad_an2.keySet().iterator();
                while (it.hasNext()) {
                    com.jd.ad.sdk.jad_lu.jad_na jad_naVar = jad_an2.get(it.next());
                    if (jad_naVar == null) {
                        com.jd.ad.sdk.bl.dynamicrender.DynamicRenderView.IDynamicRenderCallback iDynamicRenderCallback = this.jad_cn;
                        if (iDynamicRenderCallback != null) {
                            com.jd.ad.sdk.dl.error.JADError jADError = com.jd.ad.sdk.dl.error.JADError.RENDER_IMAGE_LOAD_FAIL_ERROR;
                            iDynamicRenderCallback.onDynamicRenderFailed(jADError.getCode(), jADError.getMessage(new java.lang.String[0]));
                            return;
                        }
                        return;
                    }
                    com.jd.ad.sdk.jad_gr.jad_cp.jad_bo(context).jad_er().jad_an(com.jd.ad.sdk.jad_mx.jad_ly.jad_bo).jad_an(jad_naVar.jad_dq).jad_an((com.jd.ad.sdk.jad_gr.jad_iv) new com.jd.ad.sdk.bl.dynamicrender.DynamicRenderView.jad_bo(jad_naVar, jad_an2));
                }
                return;
            }
            if (!this.jad_gr) {
                com.jd.ad.sdk.bl.dynamicrender.DynamicRenderView.IDynamicRenderCallback iDynamicRenderCallback2 = this.jad_cn;
                if (iDynamicRenderCallback2 != null) {
                    com.jd.ad.sdk.dl.error.JADError jADError2 = com.jd.ad.sdk.dl.error.JADError.RENDER_IMAGE_LOAD_FAIL_ERROR;
                    iDynamicRenderCallback2.onDynamicRenderFailed(jADError2.getCode(), jADError2.getMessage(new java.lang.String[0]));
                    return;
                }
                return;
            }
            this.jad_fq.await();
            com.jd.ad.sdk.bl.dynamicrender.DynamicRenderView.IDynamicRenderCallback iDynamicRenderCallback3 = this.jad_cn;
            if (iDynamicRenderCallback3 == null || !this.jad_gr) {
                return;
            }
            iDynamicRenderCallback3.onDynamicRenderSuccess(this);
        } catch (java.lang.Exception e) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            com.jd.ad.sdk.jad_wj.jad_an jad_anVar = com.jd.ad.sdk.jad_wj.jad_an.RENDER_DYNAMIC_VIEW_INIT_LOAD_IMAGES_ERROR;
            sb.append(jad_anVar.jad_an);
            sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER);
            sb.append(jad_anVar.jad_an(new java.lang.String[0]));
            this.jad_hs = new java.lang.Exception(sb.toString(), e);
        }
    }

    public final void jad_an(com.jd.ad.sdk.bl.dynamicrender.DynamicRenderView.jad_fs jad_fsVar, android.content.Context context) {
        this.jad_iv = jad_fsVar.jad_an;
        this.jad_jw = jad_fsVar.jad_bo;
        this.jad_kx = jad_fsVar.jad_cp;
        this.jad_ly = jad_fsVar.jad_jw;
        this.jad_mz = jad_fsVar.jad_kx;
        this.jad_na = jad_fsVar.jad_ly;
        int i = jad_fsVar.jad_mz;
        this.jad_ob = i;
        this.jad_ep = i;
        this.jad_tg = jad_fsVar.jad_dq;
        this.jad_uh = jad_fsVar.jad_er;
        this.jad_vi = jad_fsVar.jad_fs;
        this.jad_cn = jad_fsVar.jad_jt;
        this.jad_pc = com.jd.ad.sdk.fdt.utils.ScreenUtils.getPhoneWidth(context);
        this.jad_qd = jad_fsVar.jad_hu;
        this.jad_re = jad_fsVar.jad_iv;
    }

    public void jad_an(java.lang.String str, com.jd.ad.sdk.jad_hu.jad_an jad_anVar) {
        try {
            org.json.JSONObject optJSONObject = this.jad_yl.optJSONObject(str);
            if (optJSONObject == null) {
                com.jd.ad.sdk.logger.Logger.d("动态化渲染不阻断问题：" + str + "不存在");
                return;
            }
            int i = optJSONObject.getInt("index");
            android.graphics.Rect rect = (android.graphics.Rect) optJSONObject.get("rect");
            jad_anVar.jad_cp = i;
            jad_anVar.jad_bo = rect;
            this.jad_wj.put(str, jad_anVar);
            if (str.equals(this.jad_xk)) {
                int width = rect.width();
                int height = rect.height();
                int i2 = (int) (this.jad_jw * this.jad_kx);
                if (i2 > 0) {
                    this.jad_ju = ((width * height) * 100) / i2;
                }
            }
        } catch (java.lang.Exception e) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            com.jd.ad.sdk.jad_wj.jad_an jad_anVar2 = com.jd.ad.sdk.jad_wj.jad_an.RENDER_DYNAMIC_VIEW_INIT_ADD_EVENT_ERROR;
            sb.append(jad_anVar2.jad_an);
            sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER);
            sb.append(jad_anVar2.jad_an(new java.lang.String[0]));
            throw new java.lang.Exception(sb.toString(), e);
        }
    }

    public final void jad_bo() {
        com.jd.ad.sdk.bl.dynamicrender.DynamicRenderView.jad_er jad_erVar = new com.jd.ad.sdk.bl.dynamicrender.DynamicRenderView.jad_er();
        this.jad_qb = jad_erVar;
        com.jd.ad.sdk.fdt.utils.ActLifecycle.jad_an(jad_erVar);
    }

    public final void jad_cp() {
        if (this.jad_qd == com.jd.ad.sdk.dl.common.CommonConstants.AdTriggerSourceType.CLICK.ordinal()) {
            if (this.jad_re == com.jd.ad.sdk.dl.common.CommonConstants.ClickAreaType.FULL_SCREEN_CLICK.getTemplateId()) {
                this.jad_jt = 1;
                return;
            } else {
                this.jad_jt = 0;
                return;
            }
        }
        if (this.jad_qd == com.jd.ad.sdk.dl.common.CommonConstants.AdTriggerSourceType.SHAKE.ordinal()) {
            this.jad_jt = 2;
        } else if (this.jad_qd == com.jd.ad.sdk.dl.common.CommonConstants.AdTriggerSourceType.SLIDE_UP.ordinal()) {
            this.jad_jt = 3;
        }
    }

    public final void jad_dq() {
        com.jd.ad.sdk.bl.dynamicrender.ShakeListener shakeListener = this.jad_hu;
        if (shakeListener != null) {
            shakeListener.unregister();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.jd.ad.sdk.lottie.LottieAnimationView lottieAnimationView = this.jad_sf;
        if (lottieAnimationView != null) {
            lottieAnimationView.destroyDrawingCache();
            this.jad_sf = null;
        }
        jad_dq();
        com.jd.ad.sdk.bl.dynamicrender.DynamicRenderView.jad_er jad_erVar = this.jad_qb;
        java.util.concurrent.CopyOnWriteArrayList<com.jd.ad.sdk.fdt.utils.ActLifecycle.jad_an> copyOnWriteArrayList = com.jd.ad.sdk.fdt.utils.ActLifecycle.jad_bo;
        if (jad_erVar != null) {
            com.jd.ad.sdk.fdt.utils.ActLifecycle.jad_bo.remove(jad_erVar);
        }
        this.jad_qb = null;
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        this.jad_fs = z;
        if (!z) {
            removeCallbacks(this.jad_rc);
        } else if (this.jad_do != null && this.jad_ep > 0) {
            post(this.jad_rc);
        }
        if (!this.jad_fs) {
            jad_dq();
            return;
        }
        com.jd.ad.sdk.bl.dynamicrender.ShakeListener shakeListener = this.jad_hu;
        if (shakeListener != null) {
            shakeListener.register();
        }
    }

    public void play() {
        com.jd.ad.sdk.lottie.LottieAnimationView lottieAnimationView = this.jad_sf;
        if (lottieAnimationView != null) {
            lottieAnimationView.jad_dq();
        } else {
            com.jd.ad.sdk.jad_wj.jad_an jad_anVar = com.jd.ad.sdk.jad_wj.jad_an.RENDER_DYNAMIC_VIEW_PLAY_ERROR;
            com.jd.ad.sdk.jad_xk.jad_fs.jad_an("", jad_anVar.jad_an, jad_anVar.jad_an(new java.lang.String[0]));
        }
    }

    public void startCount(@androidx.annotation.NonNull com.jd.ad.sdk.bl.dynamicrender.listener.IDynamicCountdownListener iDynamicCountdownListener) {
        if (iDynamicCountdownListener == null) {
            return;
        }
        this.jad_do = iDynamicCountdownListener;
        int i = this.jad_ep;
        if (i < 1 || i > 30) {
            this.jad_ep = 5;
        }
        java.lang.Runnable runnable = this.jad_rc;
        if (runnable != null) {
            post(runnable);
        }
    }
}
