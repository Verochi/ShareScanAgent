package com.jd.ad.sdk.jad_zi;

/* loaded from: classes23.dex */
public class jad_er implements com.jd.ad.sdk.mdt.service.JADDynamicRenderService {
    @Override // com.jd.ad.sdk.mdt.service.JADDynamicRenderService
    public com.jd.ad.sdk.bl.dynamicrender.DynamicRenderView createDynamicView(android.content.Context context, @androidx.annotation.NonNull java.lang.String str, @androidx.annotation.NonNull com.jd.ad.sdk.dl.model.JADSlot jADSlot, com.jd.ad.sdk.bl.dynamicrender.DynamicRenderView.IDynamicRenderCallback iDynamicRenderCallback) {
        com.jd.ad.sdk.dl.addata.JADMaterialData jADMaterialData;
        java.util.List<java.lang.String> imageUrls;
        try {
            java.lang.String str2 = jADSlot.getDynamicRenderTemplateHelper().jad_cp;
            try {
                if (android.text.TextUtils.isEmpty(str2)) {
                    throw new java.lang.Exception("dynamic render templateJSON is null");
                }
                int dip2px = (int) com.jd.ad.sdk.fdt.utils.ScreenUtils.dip2px(context, jADSlot.getWidth());
                int dip2px2 = (int) com.jd.ad.sdk.fdt.utils.ScreenUtils.dip2px(context, jADSlot.getHeight());
                java.util.ArrayList arrayList = new java.util.ArrayList(java.util.Arrays.asList("sdkSkipButton", "sdkSkipArea", "sdkLogo", "sdkStaticSkipButton"));
                java.util.ArrayList arrayList2 = new java.util.ArrayList(java.util.Arrays.asList("sdkLimitClickArea", "sdkSkipInformation", "sdkInteractiveShake", "sdkLimitSlideArea"));
                java.util.ArrayList arrayList3 = new java.util.ArrayList();
                if (jADSlot.isHideSkip()) {
                    arrayList3.add("sdkStaticSkipButton");
                    arrayList3.add("sdkSkipButton");
                    arrayList3.add("sdkSkipArea");
                }
                if (!jADSlot.isHideSkip() && jADSlot.getSkipTime() <= 5) {
                    arrayList3.add("sdkStaticSkipButton");
                }
                java.util.List<com.jd.ad.sdk.dl.addata.JADMaterialData> jADMaterialDataList = com.jd.ad.sdk.mdt.servicemediator.JADMediator.getInstance().getAdService().getJADMaterialDataList(str);
                if (jADMaterialDataList != null && jADMaterialDataList.size() > 0 && (jADMaterialData = com.jd.ad.sdk.mdt.servicemediator.JADMediator.getInstance().getAdService().getJADMaterialDataList(str).get(0)) != null && (imageUrls = jADMaterialData.getImageUrls()) != null && imageUrls.size() > 0) {
                    java.lang.String str3 = imageUrls.get(0);
                    if (android.text.TextUtils.isEmpty(str3)) {
                        return null;
                    }
                    java.lang.String str4 = com.jd.ad.sdk.jad_na.jad_cp.jad_an.jad_an.jad_an.get(str);
                    if (android.text.TextUtils.isEmpty(str4)) {
                        str4 = "";
                    }
                    com.jd.ad.sdk.jad_na.jad_bo jad_boVar = com.jd.ad.sdk.jad_na.jad_bo.jad_an.jad_an;
                    com.jd.ad.sdk.jad_yl.jad_fs jad_cp = jad_boVar.jad_cp(str4);
                    int i = jad_cp == null ? 0 : jad_cp.jad_jt;
                    com.jd.ad.sdk.jad_yl.jad_fs jad_cp2 = jad_boVar.jad_cp(str4);
                    int i2 = jad_cp2 == null ? 0 : jad_cp2.jad_hu;
                    com.jd.ad.sdk.bl.dynamicrender.DynamicRenderView.jad_fs jad_fsVar = new com.jd.ad.sdk.bl.dynamicrender.DynamicRenderView.jad_fs();
                    jad_fsVar.jad_bo = dip2px;
                    jad_fsVar.jad_cp = dip2px2;
                    jad_fsVar.jad_jw = str3;
                    jad_fsVar.jad_kx = i;
                    jad_fsVar.jad_ly = i2;
                    jad_fsVar.jad_mz = jADSlot.getSkipTime();
                    jad_fsVar.jad_dq = arrayList;
                    jad_fsVar.jad_er = arrayList2;
                    jad_fsVar.jad_fs = arrayList3;
                    jad_fsVar.jad_an = str2;
                    jad_fsVar.jad_jt = iDynamicRenderCallback;
                    jad_fsVar.jad_hu = jADSlot.getEventInteractionType();
                    jad_fsVar.jad_iv = jADSlot.getModelClickAreaType();
                    com.jd.ad.sdk.bl.dynamicrender.DynamicRenderView dynamicRenderView = new com.jd.ad.sdk.bl.dynamicrender.DynamicRenderView(context, jad_fsVar);
                    java.lang.Exception loadImagesException = dynamicRenderView.getLoadImagesException();
                    if (loadImagesException != null) {
                        throw loadImagesException;
                    }
                    java.lang.Exception dynamicInitException = dynamicRenderView.getDynamicInitException();
                    if (dynamicInitException == null) {
                        return dynamicRenderView;
                    }
                    throw dynamicInitException;
                }
                return null;
            } catch (java.lang.Throwable th) {
                th = th;
                int sen = jADSlot != null ? jADSlot.getSen() : 0;
                java.lang.Exception exc = new java.lang.Exception("dynamic render view init error", th);
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
                    int optInt = jSONObject.optInt("code");
                    com.jd.ad.sdk.jad_xk.jad_fs.jad_an("", 5, optInt, jSONObject.optString("msg"), sen);
                    com.jd.ad.sdk.logger.Logger.w(optInt + ": dynamic render view error：" + android.util.Log.getStackTraceString(exc), new java.lang.Object[0]);
                    return null;
                } finally {
                    jSONObject.put("code", code);
                    jSONObject.put("msg", message);
                }
                int optInt2 = jSONObject.optInt("code");
                com.jd.ad.sdk.jad_xk.jad_fs.jad_an("", 5, optInt2, jSONObject.optString("msg"), sen);
                com.jd.ad.sdk.logger.Logger.w(optInt2 + ": dynamic render view error：" + android.util.Log.getStackTraceString(exc), new java.lang.Object[0]);
                return null;
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
    }

    @Override // com.jd.ad.sdk.mdt.service.JADDynamicRenderService
    public void registerAdViewClick(android.content.Context context, com.jd.ad.sdk.bl.dynamicrender.DynamicRenderView dynamicRenderView, com.jd.ad.sdk.bl.dynamicrender.listener.IDynamicInteractionListener iDynamicInteractionListener) {
        dynamicRenderView.jad_an("sdkSkipArea", new com.jd.ad.sdk.jad_zi.jad_cp(this, "sdkSkipArea", iDynamicInteractionListener));
        int adAnimationType = dynamicRenderView.getAdAnimationType();
        java.lang.String str = adAnimationType == 1 ? "sdkMaterialImage" : "sdkLimitClickArea";
        if (adAnimationType == 3) {
            str = "sdkLimitSlideArea";
        }
        if (adAnimationType == 2) {
            str = "sdkInteractiveShake";
        }
        com.jd.ad.sdk.jad_zi.jad_dq jad_dqVar = new com.jd.ad.sdk.jad_zi.jad_dq(this, str, str, adAnimationType, iDynamicInteractionListener);
        dynamicRenderView.jad_xk = str;
        dynamicRenderView.jad_an(str, jad_dqVar);
    }
}
