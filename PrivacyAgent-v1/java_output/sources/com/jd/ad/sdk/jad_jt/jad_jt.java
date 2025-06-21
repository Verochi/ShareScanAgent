package com.jd.ad.sdk.jad_jt;

/* loaded from: classes23.dex */
public class jad_jt {
    public int jad_an = 0;
    public com.jd.ad.sdk.bl.dynamicrender.DynamicRenderTemplateHelper jad_bo = null;

    public static void jad_an(com.jd.ad.sdk.jad_jt.jad_jt jad_jtVar, com.jd.ad.sdk.bl.adload.JADAdLoadListener jADAdLoadListener, int i) {
        jad_jtVar.getClass();
        if (jADAdLoadListener == null) {
            return;
        }
        if (i == 2) {
            if (jad_jtVar.jad_an != 1) {
                jad_jtVar.jad_an = 2;
                jADAdLoadListener.onLoadSuccess();
                return;
            }
            return;
        }
        if (jad_jtVar.jad_an != 2) {
            jad_jtVar.jad_an = 1;
            jADAdLoadListener.onLoadSuccess();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x00a5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void jad_an(com.jd.ad.sdk.jad_jt.jad_jt jad_jtVar, com.jd.ad.sdk.dl.model.JADSlot jADSlot) {
        boolean z;
        int i;
        int i2;
        int i3;
        int templateId;
        jad_jtVar.getClass();
        int i4 = 0;
        if (jADSlot.isFromNativeAd()) {
            jADSlot.setRem(2);
        } else {
            int adType = jADSlot.getAdType();
            synchronized (jad_jtVar) {
                com.jd.ad.sdk.jad_pc.jad_an jad_an = com.jd.ad.sdk.jad_re.jad_an.jad_an();
                if (jad_an != null) {
                    if ("1".equals(jad_an.jad_na)) {
                        z = true;
                    }
                }
                z = 1 != adType;
            }
            if (z) {
                jADSlot.setRem(1);
            } else {
                java.lang.String str = com.jd.ad.sdk.bl.initsdk.JADYunSdk.getAppId() + jADSlot.getSlotID();
                if (jad_jtVar.jad_bo == null) {
                    jad_jtVar.jad_bo = new com.jd.ad.sdk.bl.dynamicrender.DynamicRenderTemplateHelper(com.jd.ad.sdk.jad_fq.jad_cp.jad_an(), str);
                }
                jADSlot.setDynamicRenderTemplateHelper(jad_jtVar.jad_bo);
                jADSlot.setRem(3);
            }
        }
        try {
            i3 = java.lang.Math.round(jADSlot.getWidth());
        } catch (java.lang.Exception unused) {
        }
        try {
            i2 = java.lang.Math.round(jADSlot.getHeight());
        } catch (java.lang.Exception unused2) {
            i4 = i3;
            i = 0;
            int i5 = i4;
            i2 = i;
            i3 = i5;
            jADSlot.setAdImageWidth(i3);
            jADSlot.setAdImageHeight(i2);
            jADSlot.getSlotID();
            jADSlot.getAdType();
            jADSlot.isFromNativeAd();
            synchronized (jad_jtVar) {
            }
        }
        try {
            if (jADSlot.getRem() == 2) {
                i3 = java.lang.Math.round(jADSlot.getAdImageWidth());
                i2 = java.lang.Math.round(jADSlot.getAdImageHeight());
            }
        } catch (java.lang.Exception unused3) {
            i4 = i3;
            i = i2;
            int i52 = i4;
            i2 = i;
            i3 = i52;
            jADSlot.setAdImageWidth(i3);
            jADSlot.setAdImageHeight(i2);
            jADSlot.getSlotID();
            jADSlot.getAdType();
            jADSlot.isFromNativeAd();
            synchronized (jad_jtVar) {
            }
        }
        jADSlot.setAdImageWidth(i3);
        jADSlot.setAdImageHeight(i2);
        jADSlot.getSlotID();
        jADSlot.getAdType();
        jADSlot.isFromNativeAd();
        synchronized (jad_jtVar) {
            templateId = com.jd.ad.sdk.dl.common.CommonConstants.AdTmp.TEMPLATE_UNKNOWN.getTemplateId();
        }
        jADSlot.setTemplateId(templateId);
        jADSlot.setSen(com.jd.ad.sdk.mdt.servicemediator.JADMediator.getInstance().getInitService().getSen(jADSlot.getSlotID()));
    }

    public static void jad_an(com.jd.ad.sdk.jad_jt.jad_jt jad_jtVar, com.jd.ad.sdk.dl.model.JADSlot jADSlot, java.lang.String str) {
        android.app.Application jad_an;
        android.app.Application jad_an2;
        java.util.Map<java.lang.String, com.jd.ad.sdk.jad_lu.jad_na> jad_an3;
        com.jd.ad.sdk.jad_lu.jad_na jad_naVar;
        jad_jtVar.getClass();
        java.lang.String str2 = com.jd.ad.sdk.bl.initsdk.JADYunSdk.getAppId() + jADSlot.getSlotID();
        com.jd.ad.sdk.jad_kx.jad_er jad_erVar = com.jd.ad.sdk.jad_kx.jad_er.jad_an.jad_an;
        if (jad_erVar.jad_bo(str2)) {
            return;
        }
        com.jd.ad.sdk.jad_kx.jad_cp jad_cpVar = new com.jd.ad.sdk.jad_kx.jad_cp(0, str2, jADSlot.getRequestId(), str, java.lang.System.currentTimeMillis() + "");
        com.jd.ad.sdk.jad_kx.jad_fs jad_fsVar = jad_erVar.jad_bo;
        if (jad_fsVar != null) {
            synchronized (jad_fsVar) {
                java.util.ArrayList<com.jd.ad.sdk.jad_kx.jad_cp> arrayList = jad_fsVar.jad_an.get(str2);
                if (arrayList == null) {
                    arrayList = new java.util.ArrayList<>();
                }
                arrayList.add(jad_cpVar);
                jad_fsVar.jad_an.put(str2, arrayList);
            }
        }
        if (jad_erVar.jad_jt) {
            com.jd.ad.sdk.jad_kx.jad_an jad_anVar = jad_erVar.jad_an;
            if (jad_anVar != null) {
                jad_anVar.jad_an(jad_cpVar);
            }
        } else {
            synchronized (com.jd.ad.sdk.jad_tg.jad_an.class) {
                java.lang.String str3 = com.jd.ad.sdk.jad_tg.jad_an.jad_bo() + "db_preload_ad" + net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR + "update";
                try {
                    android.content.ContentResolver jad_an4 = com.jd.ad.sdk.jad_tg.jad_an.jad_an();
                    if (jad_an4 != null) {
                        jad_an4.update(android.net.Uri.parse(str3), com.jd.ad.sdk.jad_tg.jad_an.jad_an(jad_cpVar), null, null);
                    }
                } catch (java.lang.Throwable th) {
                    com.jd.ad.sdk.logger.Logger.w("Exception while saving preload ad data: ", th.getMessage());
                }
            }
        }
        if (jADSlot.getDynamicRenderTemplateHelper() != null) {
            jADSlot.getDynamicRenderTemplateHelper().jad_an(str);
            java.lang.String jad_bo = com.jd.ad.sdk.jad_na.jad_bo.jad_an.jad_an.jad_bo(str);
            java.lang.String str4 = jADSlot.getDynamicRenderTemplateHelper().jad_cp;
            if (android.text.TextUtils.isEmpty(str4) || android.text.TextUtils.isEmpty(jad_bo)) {
                return;
            }
            try {
                android.app.Application jad_an5 = com.jd.ad.sdk.jad_fq.jad_cp.jad_an();
                if (jad_an5 != null && (jad_an3 = jad_jtVar.jad_an(new org.json.JSONObject(str4), jad_bo)) != null && !jad_an3.isEmpty()) {
                    java.util.Iterator<java.lang.String> it = jad_an3.keySet().iterator();
                    while (it.hasNext() && (jad_naVar = jad_an3.get(it.next())) != null) {
                        com.jd.ad.sdk.jad_gr.jad_cp.jad_bo(jad_an5).jad_an(jad_naVar.jad_dq).jad_an(com.jd.ad.sdk.jad_mx.jad_ly.jad_bo).jad_bo(new com.jd.ad.sdk.jad_jt.jad_er(jad_jtVar)).jad_dq();
                    }
                    return;
                }
                return;
            } catch (java.lang.Exception unused) {
                return;
            }
        }
        com.jd.ad.sdk.jad_na.jad_bo jad_boVar = com.jd.ad.sdk.jad_na.jad_bo.jad_an.jad_an;
        com.jd.ad.sdk.jad_yl.jad_cp jad_an6 = jad_boVar.jad_an(str);
        if ((jad_an6 != null ? jad_an6.jad_cp : 0) != 10005) {
            java.lang.String jad_bo2 = jad_boVar.jad_bo(str);
            if (android.text.TextUtils.isEmpty(jad_bo2) || (jad_an = com.jd.ad.sdk.jad_fq.jad_cp.jad_an()) == null) {
                return;
            }
            com.jd.ad.sdk.jad_gr.jad_cp.jad_bo(jad_an).jad_an(jad_bo2).jad_an(com.jd.ad.sdk.jad_mx.jad_ly.jad_bo).jad_bo(new com.jd.ad.sdk.jad_jt.jad_cp(jad_jtVar)).jad_dq();
            return;
        }
        com.jd.ad.sdk.jad_yl.jad_fs jad_cp = jad_boVar.jad_cp(str);
        java.util.List<com.jd.ad.sdk.jad_yl.jad_er> list = jad_cp != null ? jad_cp.jad_fs : null;
        if (list == null || list.size() != 3 || (jad_an2 = com.jd.ad.sdk.jad_fq.jad_cp.jad_an()) == null) {
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != null && !android.text.TextUtils.isEmpty(list.get(i).jad_an)) {
                com.jd.ad.sdk.jad_gr.jad_cp.jad_bo(jad_an2).jad_an(list.get(i).jad_an).jad_an(com.jd.ad.sdk.jad_mx.jad_ly.jad_bo).jad_bo(new com.jd.ad.sdk.jad_jt.jad_dq(jad_jtVar)).jad_dq();
            }
        }
    }

    public static void jad_an(com.jd.ad.sdk.jad_jt.jad_jt jad_jtVar, java.lang.String str, java.lang.String str2) {
        com.jd.ad.sdk.jad_yl.jad_hu jad_huVar;
        java.util.List<com.jd.ad.sdk.jad_yl.jad_dq> list;
        com.jd.ad.sdk.jad_yl.jad_dq jad_dqVar;
        jad_jtVar.getClass();
        com.jd.ad.sdk.dl.model.JADExtra jADExtra = new com.jd.ad.sdk.dl.model.JADExtra();
        com.jd.ad.sdk.jad_yl.jad_jt jad_jtVar2 = null;
        if (!android.text.TextUtils.isEmpty(str2)) {
            try {
                jad_jtVar2 = com.jd.ad.sdk.jad_yl.jad_jt.jad_an(str2);
            } catch (org.json.JSONException e) {
                e.printStackTrace();
            }
        }
        jADExtra.setPrice((jad_jtVar2 == null || (jad_huVar = jad_jtVar2.jad_cp) == null || (list = jad_huVar.jad_an) == null || list.isEmpty() || (jad_dqVar = list.get(0)) == null) ? 0.0d : jad_dqVar.jad_an);
        com.jd.ad.sdk.jad_na.jad_cp jad_cpVar = com.jd.ad.sdk.jad_na.jad_cp.jad_an.jad_an;
        jad_cpVar.jad_bo.put(str, jADExtra);
        jad_cpVar.jad_an.put(str, str2);
    }

    public static void jad_bo(com.jd.ad.sdk.jad_jt.jad_jt jad_jtVar, com.jd.ad.sdk.dl.model.JADSlot jADSlot) {
        jad_jtVar.getClass();
        if (jADSlot == null) {
            return;
        }
        jADSlot.setLoadSucTime(java.lang.System.currentTimeMillis());
        java.lang.String requestId = jADSlot.getRequestId();
        java.lang.String slotID = jADSlot.getSlotID();
        int adType = jADSlot.getAdType();
        int sen = jADSlot.getSen();
        int rem = jADSlot.getRem();
        int templateId = jADSlot.getTemplateId();
        long loadSucTime = jADSlot.getLoadSucTime() - jADSlot.getLoadTime();
        int eventInteractionType = jADSlot.getEventInteractionType();
        int modelClickAreaType = jADSlot.getModelClickAreaType();
        int mediaSpecSetType = jADSlot.getMediaSpecSetType();
        int ds = com.jd.ad.sdk.mdt.servicemediator.JADMediator.getInstance().getInitService().getDs(jADSlot.getSlotID());
        int r = com.jd.ad.sdk.mdt.servicemediator.JADMediator.getInstance().getInitService().getR(jADSlot.getSlotID());
        if (jADSlot.getAdDataRequestSourceType() == 1 || jADSlot.getAdDataRequestSourceType() == 2) {
            com.jd.ad.sdk.mdt.servicemediator.JADMediator.getInstance().getEventService().reportPreloadResponseEvent(requestId, slotID, adType, templateId, sen, rem, loadSucTime, eventInteractionType, modelClickAreaType, mediaSpecSetType, ds, r);
        } else {
            com.jd.ad.sdk.mdt.servicemediator.JADMediator.getInstance().getEventService().reportResponseEvent(requestId, slotID, adType, templateId, sen, rem, loadSucTime, eventInteractionType, modelClickAreaType, mediaSpecSetType, ds, r);
        }
    }

    public final java.lang.String jad_an(java.lang.String str, int i, java.lang.String str2) {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "pid", str);
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "adt", java.lang.Integer.valueOf(i));
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "error", str2);
        return jSONObject.toString();
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

    public final void jad_an(com.jd.ad.sdk.bl.adload.JADAdLoadListener jADAdLoadListener, int i, java.lang.String str) {
        if (jADAdLoadListener == null) {
            return;
        }
        if (android.text.TextUtils.isEmpty(str)) {
            str = com.jd.ad.sdk.dl.error.JADError.DEFAULT_ERROR.getMessage(new java.lang.String[0]);
        }
        if (this.jad_an != 2) {
            jADAdLoadListener.onLoadFailure(i, str);
        }
    }

    public final boolean jad_an(@androidx.annotation.NonNull com.jd.ad.sdk.dl.model.JADSlot jADSlot, @androidx.annotation.NonNull com.jd.ad.sdk.bl.adload.JADAdLoadListener jADAdLoadListener) {
        int i;
        int i2;
        com.jd.ad.sdk.jad_wj.jad_an jad_anVar;
        if (android.text.TextUtils.isEmpty(jADSlot.getSlotID())) {
            com.jd.ad.sdk.mdt.service.JADEventService eventService = com.jd.ad.sdk.mdt.servicemediator.JADMediator.getInstance().getEventService();
            java.lang.String requestId = jADSlot.getRequestId();
            com.jd.ad.sdk.jad_wj.jad_an jad_anVar2 = com.jd.ad.sdk.jad_wj.jad_an.GW_REQUEST_SLOT_ID_IS_NULL_ERROR;
            eventService.reportRequestErrorEvent(requestId, jad_anVar2.jad_an, jad_an(jADSlot.getSlotID(), jADSlot.getAdType(), jad_anVar2.jad_an(new java.lang.String[0])));
            jad_an(jADAdLoadListener, jad_anVar2.jad_an, jad_anVar2.jad_an(new java.lang.String[0]));
            return false;
        }
        if (jADSlot.getAdDataRequestSourceType() == 1) {
            com.jd.ad.sdk.jad_pc.jad_an jad_an = com.jd.ad.sdk.jad_re.jad_an.jad_an();
            if (jad_an != null && jad_an.jad_pc == 1) {
                com.jd.ad.sdk.mdt.service.JADEventService eventService2 = com.jd.ad.sdk.mdt.servicemediator.JADMediator.getInstance().getEventService();
                java.lang.String requestId2 = jADSlot.getRequestId();
                com.jd.ad.sdk.jad_wj.jad_an jad_anVar3 = com.jd.ad.sdk.jad_wj.jad_an.GW_REQUEST_FORBID_PRELOAD_ERROR;
                eventService2.reportExceptionEvent(requestId2, jad_anVar3.jad_an, jad_anVar3.jad_an(new java.lang.String[0]));
                com.jd.ad.sdk.logger.Logger.d("preload 禁用预加载接口功能 - 中断网络请求");
                return false;
            }
            if (com.jd.ad.sdk.jad_kx.jad_er.jad_an.jad_an.jad_bo(com.jd.ad.sdk.bl.initsdk.JADYunSdk.getAppId() + jADSlot.getSlotID())) {
                com.jd.ad.sdk.mdt.service.JADEventService eventService3 = com.jd.ad.sdk.mdt.servicemediator.JADMediator.getInstance().getEventService();
                java.lang.String requestId3 = jADSlot.getRequestId();
                com.jd.ad.sdk.jad_wj.jad_an jad_anVar4 = com.jd.ad.sdk.jad_wj.jad_an.GW_REQUEST_PRELOAD_AD_DARA_EXCEEDED_UPPER_LIMIT_ERROR;
                eventService3.reportRequestErrorEvent(requestId3, jad_anVar4.jad_an, jad_an(jADSlot.getSlotID(), jADSlot.getAdType(), jad_anVar4.jad_an(new java.lang.String[0])));
                jad_an(jADAdLoadListener, jad_anVar4.jad_an, jad_anVar4.jad_an(new java.lang.String[0]));
                return false;
            }
        }
        int adType = jADSlot.getAdType();
        java.lang.String slotID = jADSlot.getSlotID();
        boolean isFromNativeAd = jADSlot.isFromNativeAd();
        com.jd.ad.sdk.jad_ob.jad_dq jad_dqVar = com.jd.ad.sdk.jad_ob.jad_dq.jad_an.jad_an;
        boolean jad_an2 = jad_dqVar.jad_an(jad_dqVar.jad_an(isFromNativeAd, adType), slotID);
        char c = 2;
        if (jad_an2) {
            int adType2 = jADSlot.getAdType();
            boolean isFromNativeAd2 = jADSlot.isFromNativeAd();
            synchronized (this) {
                if (adType2 != 1) {
                    if (adType2 != 2) {
                        c = 4;
                        if (adType2 == 4) {
                            c = isFromNativeAd2 ? (char) 7 : (char) 3;
                        } else if (adType2 != 5) {
                            c = 65535;
                        } else if (isFromNativeAd2) {
                            c = '\b';
                        }
                    } else {
                        c = isFromNativeAd2 ? '\t' : (char) 5;
                    }
                } else if (isFromNativeAd2) {
                    c = 6;
                }
                switch (c) {
                    case 2:
                        jad_anVar = com.jd.ad.sdk.jad_wj.jad_an.GW_REQUEST_TEMPLATE_SPLASH_FORBIDDEN_ERROR;
                        break;
                    case 3:
                        jad_anVar = com.jd.ad.sdk.jad_wj.jad_an.GW_REQUEST_TEMPLATE_INTERSTITIAL_FORBIDDEN_ERROR;
                        break;
                    case 4:
                        jad_anVar = com.jd.ad.sdk.jad_wj.jad_an.GW_REQUEST_TEMPLATE_BANNER_FORBIDDEN_ERROR;
                        break;
                    case 5:
                        jad_anVar = com.jd.ad.sdk.jad_wj.jad_an.GW_REQUEST_TEMPLATE_FEED_FORBIDDEN_ERROR;
                        break;
                    case 6:
                        jad_anVar = com.jd.ad.sdk.jad_wj.jad_an.GW_REQUEST_NATIVE_SPLASH_FORBIDDEN_ERROR;
                        break;
                    case 7:
                        jad_anVar = com.jd.ad.sdk.jad_wj.jad_an.GW_REQUEST_NATIVE_INTERSTITIAL_FORBIDDEN_ERROR;
                        break;
                    case '\b':
                        jad_anVar = com.jd.ad.sdk.jad_wj.jad_an.GW_REQUEST_NATIVE_BANNER_FORBIDDEN_ERROR;
                        break;
                    case '\t':
                        jad_anVar = com.jd.ad.sdk.jad_wj.jad_an.GW_REQUEST_NATIVE_FEED_FORBIDDEN_ERROR;
                        break;
                    default:
                        jad_anVar = com.jd.ad.sdk.jad_wj.jad_an.GW_REQUEST_FORBIDDEN_ERROR;
                        break;
                }
            }
            com.jd.ad.sdk.mdt.servicemediator.JADMediator.getInstance().getEventService().reportRequestErrorEvent(jADSlot.getRequestId(), jad_anVar.jad_an, jad_an(jADSlot.getSlotID(), jADSlot.getAdType(), jad_anVar.jad_an(new java.lang.String[0])));
            jad_an(jADAdLoadListener, jad_anVar.jad_an, jad_anVar.jad_an(new java.lang.String[0]));
            return false;
        }
        com.jd.ad.sdk.bl.initsdk.JADPrivateController privateController = com.jd.ad.sdk.bl.initsdk.JADYunSdk.getPrivateController();
        if (privateController == null) {
            com.jd.ad.sdk.logger.Logger.w("oaid获取不正常，请注意实现oaid接口", new java.lang.Object[0]);
        } else if (android.text.TextUtils.isEmpty(privateController.getOaid())) {
            com.jd.ad.sdk.logger.Logger.w("oaid获取不正常，请注意实现oaid接口", new java.lang.Object[0]);
        } else {
            com.jd.ad.sdk.logger.Logger.i("oaid获取正常", new java.lang.Object[0]);
        }
        try {
            i = java.lang.Math.round(jADSlot.getWidth());
        } catch (java.lang.Exception unused) {
            i = 0;
        }
        try {
            i2 = java.lang.Math.round(jADSlot.getHeight());
            try {
                if (jADSlot.isFromNativeAd()) {
                    i = java.lang.Math.round(jADSlot.getAdImageWidth());
                    i2 = java.lang.Math.round(jADSlot.getAdImageHeight());
                }
            } catch (java.lang.Exception unused2) {
            }
        } catch (java.lang.Exception unused3) {
            i2 = 0;
            if (i <= 0) {
            }
            com.jd.ad.sdk.mdt.service.JADEventService eventService4 = com.jd.ad.sdk.mdt.servicemediator.JADMediator.getInstance().getEventService();
            java.lang.String requestId4 = jADSlot.getRequestId();
            com.jd.ad.sdk.jad_wj.jad_an jad_anVar5 = com.jd.ad.sdk.jad_wj.jad_an.GW_REQUEST_SIZE_ERROR;
            int i3 = jad_anVar5.jad_an;
            java.lang.String slotID2 = jADSlot.getSlotID();
            int adType3 = jADSlot.getAdType();
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "pid", slotID2);
            com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "adt", java.lang.Integer.valueOf(adType3));
            com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "plwd", java.lang.Float.valueOf(i));
            com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "plht", java.lang.Float.valueOf(i2));
            com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "error", jad_anVar5.jad_an(new java.lang.String[0]));
            eventService4.reportRequestErrorEvent(requestId4, i3, jSONObject.toString());
            jad_an(jADAdLoadListener, jad_anVar5.jad_an, jad_anVar5.jad_an("(" + i + " , " + i2 + ")"));
            return false;
        }
        if (i <= 0 && (jADSlot.getAdType() == 2 || i2 > 0)) {
            return true;
        }
        com.jd.ad.sdk.mdt.service.JADEventService eventService42 = com.jd.ad.sdk.mdt.servicemediator.JADMediator.getInstance().getEventService();
        java.lang.String requestId42 = jADSlot.getRequestId();
        com.jd.ad.sdk.jad_wj.jad_an jad_anVar52 = com.jd.ad.sdk.jad_wj.jad_an.GW_REQUEST_SIZE_ERROR;
        int i32 = jad_anVar52.jad_an;
        java.lang.String slotID22 = jADSlot.getSlotID();
        int adType32 = jADSlot.getAdType();
        org.json.JSONObject jSONObject2 = new org.json.JSONObject();
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject2, "pid", slotID22);
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject2, "adt", java.lang.Integer.valueOf(adType32));
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject2, "plwd", java.lang.Float.valueOf(i));
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject2, "plht", java.lang.Float.valueOf(i2));
        com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject2, "error", jad_anVar52.jad_an(new java.lang.String[0]));
        eventService42.reportRequestErrorEvent(requestId42, i32, jSONObject2.toString());
        jad_an(jADAdLoadListener, jad_anVar52.jad_an, jad_anVar52.jad_an("(" + i + " , " + i2 + ")"));
        return false;
    }
}
