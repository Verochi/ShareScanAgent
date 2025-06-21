package com.jd.ad.sdk.jad_jt;

/* loaded from: classes23.dex */
public class jad_hu {
    /* JADX WARN: Can't wrap try/catch for region: R(13:2|3|4|(2:5|6)|(9:25|(1:27)(4:29|30|31|32)|9|10|11|(1:13)(2:20|(1:22)(1:23))|14|15|17)|8|9|10|11|(0)(0)|14|15|17) */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0178 A[Catch: Exception -> 0x018e, TryCatch #1 {Exception -> 0x018e, blocks: (B:11:0x0171, B:20:0x0178, B:22:0x0180, B:23:0x0185), top: B:10:0x0171 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static java.lang.String jad_an() {
        java.lang.String str;
        java.lang.String str2 = "NA";
        try {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("vsn");
            sb.append(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
            if (com.jd.ad.sdk.jad_qd.jad_an.jad_an("antiSDKVersion", true)) {
                com.jd.ad.sdk.jad_uh.jad_an jad_anVar = com.jd.ad.sdk.jad_uh.jad_an.jad_bo.jad_an;
                if (jad_anVar.jad_an("antiSDKVersion", true)) {
                    str = jad_anVar.jad_dq("antiSDKVersion");
                } else {
                    try {
                        jad_anVar.jad_bo("antiSDKVersion", "0.0.4");
                    } catch (java.lang.Exception unused) {
                    }
                    str = "0.0.4";
                }
                sb.append(str);
                sb.append("|");
                sb.append("pip");
                sb.append(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
                sb.append(com.jd.ad.sdk.jad_qd.jad_an.jad_yl());
                sb.append("|");
                sb.append("qem");
                sb.append(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
                sb.append(com.jd.ad.sdk.jad_qd.jad_an.jad_xk());
                sb.append("|");
                sb.append("awa");
                sb.append(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
                sb.append(com.jd.ad.sdk.jad_qd.jad_an.jad_bo());
                sb.append("|");
                sb.append("lau");
                sb.append(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
                sb.append(com.jd.ad.sdk.jad_qd.jad_an.jad_kx());
                sb.append("|");
                sb.append("dne");
                sb.append(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
                sb.append(com.jd.ad.sdk.jad_qd.jad_an.jad_jt());
                sb.append("|");
                sb.append("bra");
                sb.append(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
                sb.append(com.jd.ad.sdk.jad_qd.jad_an.jad_fs());
                sb.append("|");
                sb.append("sid");
                sb.append(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
                sb.append("NA");
                sb.append("|");
                sb.append("bsi");
                sb.append(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
                sb.append("NA");
                sb.append("|");
                sb.append("vpc");
                sb.append(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
                sb.append(com.jd.ad.sdk.jad_qd.jad_an.jad_cn());
                sb.append("|");
                sb.append("bri");
                sb.append(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
                sb.append(com.jd.ad.sdk.jad_qd.jad_an.jad_re());
                sb.append("|");
                sb.append("rss");
                sb.append(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
                sb.append("NA");
                sb.append("|");
                sb.append("blu");
                sb.append(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
                sb.append("NA");
                sb.append("|");
                sb.append("pro");
                sb.append(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
                sb.append(com.jd.ad.sdk.jad_qd.jad_an.jad_pc());
                sb.append("|");
                sb.append("bat");
                sb.append(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
                sb.append(com.jd.ad.sdk.jad_qd.jad_an.jad_cp());
                sb.append("|");
                sb.append("hoo");
                sb.append(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
                sb.append(com.jd.ad.sdk.jad_qd.jad_an.jad_vi());
                sb.append("|");
                sb.append(com.igexin.sdk.PushBuildConfig.sdk_conf_channelid);
                sb.append(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
                sb.append(com.jd.ad.sdk.jad_qd.jad_an.jad_wj());
                sb.append("|");
                sb.append("dbg");
                sb.append(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
                sb.append(com.jd.ad.sdk.jad_qd.jad_an.jad_sf());
                sb.append("|");
                sb.append("clo");
                sb.append(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
                sb.append("NA");
                sb.append("|");
                sb.append("ane");
                sb.append(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
                if (!com.jd.ad.sdk.jad_qd.jad_an.jad_an("appname", true)) {
                    com.jd.ad.sdk.jad_uh.jad_an jad_anVar2 = com.jd.ad.sdk.jad_uh.jad_an.jad_bo.jad_an;
                    if (jad_anVar2.jad_an("appname", true)) {
                        str2 = jad_anVar2.jad_dq("appname");
                    } else {
                        str2 = com.jd.android.sdk.coreinfo.CoreInfo.App.getAppName(com.jd.ad.sdk.jad_il.jad_an.jad_an);
                        jad_anVar2.jad_bo("appname", str2);
                    }
                }
                sb.append(str2);
                sb.append("|");
                sb.append("pac");
                sb.append(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
                sb.append(com.jd.ad.sdk.jad_qd.jad_an.jad_an());
                sb.append("|");
                sb.append("soa");
                sb.append(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
                sb.append(com.jd.ad.sdk.jad_qd.jad_an.jad_qd());
                return sb.toString();
            }
            str = "NA";
            sb.append(str);
            sb.append("|");
            sb.append("pip");
            sb.append(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
            sb.append(com.jd.ad.sdk.jad_qd.jad_an.jad_yl());
            sb.append("|");
            sb.append("qem");
            sb.append(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
            sb.append(com.jd.ad.sdk.jad_qd.jad_an.jad_xk());
            sb.append("|");
            sb.append("awa");
            sb.append(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
            sb.append(com.jd.ad.sdk.jad_qd.jad_an.jad_bo());
            sb.append("|");
            sb.append("lau");
            sb.append(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
            sb.append(com.jd.ad.sdk.jad_qd.jad_an.jad_kx());
            sb.append("|");
            sb.append("dne");
            sb.append(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
            sb.append(com.jd.ad.sdk.jad_qd.jad_an.jad_jt());
            sb.append("|");
            sb.append("bra");
            sb.append(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
            sb.append(com.jd.ad.sdk.jad_qd.jad_an.jad_fs());
            sb.append("|");
            sb.append("sid");
            sb.append(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
            sb.append("NA");
            sb.append("|");
            sb.append("bsi");
            sb.append(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
            sb.append("NA");
            sb.append("|");
            sb.append("vpc");
            sb.append(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
            sb.append(com.jd.ad.sdk.jad_qd.jad_an.jad_cn());
            sb.append("|");
            sb.append("bri");
            sb.append(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
            sb.append(com.jd.ad.sdk.jad_qd.jad_an.jad_re());
            sb.append("|");
            sb.append("rss");
            sb.append(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
            sb.append("NA");
            sb.append("|");
            sb.append("blu");
            sb.append(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
            sb.append("NA");
            sb.append("|");
            sb.append("pro");
            sb.append(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
            sb.append(com.jd.ad.sdk.jad_qd.jad_an.jad_pc());
            sb.append("|");
            sb.append("bat");
            sb.append(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
            sb.append(com.jd.ad.sdk.jad_qd.jad_an.jad_cp());
            sb.append("|");
            sb.append("hoo");
            sb.append(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
            sb.append(com.jd.ad.sdk.jad_qd.jad_an.jad_vi());
            sb.append("|");
            sb.append(com.igexin.sdk.PushBuildConfig.sdk_conf_channelid);
            sb.append(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
            sb.append(com.jd.ad.sdk.jad_qd.jad_an.jad_wj());
            sb.append("|");
            sb.append("dbg");
            sb.append(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
            sb.append(com.jd.ad.sdk.jad_qd.jad_an.jad_sf());
            sb.append("|");
            sb.append("clo");
            sb.append(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
            sb.append("NA");
            sb.append("|");
            sb.append("ane");
            sb.append(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
            if (!com.jd.ad.sdk.jad_qd.jad_an.jad_an("appname", true)) {
            }
            sb.append(str2);
            sb.append("|");
            sb.append("pac");
            sb.append(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
            sb.append(com.jd.ad.sdk.jad_qd.jad_an.jad_an());
            sb.append("|");
            sb.append("soa");
            sb.append(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
            sb.append(com.jd.ad.sdk.jad_qd.jad_an.jad_qd());
            return sb.toString();
        } catch (java.lang.Exception unused2) {
            return "";
        }
    }

    public static java.lang.String jad_an(com.jd.ad.sdk.jad_pc.jad_cp jad_cpVar, java.lang.String str) {
        if (jad_cpVar == null) {
            return "";
        }
        com.jd.ad.sdk.jad_yl.jad_an jad_an = com.jd.ad.sdk.jad_ob.jad_jt.jad_an(str);
        if (!(jad_an != null && jad_an.jad_cp == 4)) {
            com.jd.ad.sdk.logger.Logger.i("The url is currently in a online environment ", new java.lang.Object[0]);
            return jad_cpVar.jad_an.jad_an;
        }
        java.lang.String str2 = jad_cpVar.jad_an.jad_bo;
        com.jd.ad.sdk.logger.Logger.w("The url is currently in a non-online environment ", new java.lang.Object[0]);
        return str2;
    }

    public static org.json.JSONArray jad_an(com.jd.ad.sdk.dl.model.JADSlot jADSlot) {
        org.json.JSONArray jad_bo;
        org.json.JSONArray jSONArray = new org.json.JSONArray();
        java.lang.Object[] objArr = new java.lang.String[0];
        if (!android.text.TextUtils.isEmpty(jADSlot.getSlotID())) {
            objArr = jADSlot.getSlotID().split(",");
        }
        for (java.lang.Object obj : objArr) {
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            jSONObject.put("id", com.jd.ad.sdk.fdt.utils.UUIDUtils.uuid());
            jSONObject.put("tagid", obj);
            org.json.JSONObject jSONObject2 = new org.json.JSONObject();
            jSONObject2.put(com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.WIDTH, jADSlot.getAdImageWidth());
            jSONObject2.put("h", jADSlot.getAdImageHeight());
            jSONObject2.put(me.leolin.shortcutbadger.impl.NewHtcHomeBadger.COUNT, 1);
            jSONObject2.put("imgnum", 1);
            jSONObject.put(com.anythink.expressad.foundation.g.a.f.a, jSONObject2);
            jSONObject.put("isdeeplink", true);
            jSONObject.put("secure", 1);
            if (jADSlot.getDynamicRenderTemplateHelper() != null && (jad_bo = jADSlot.getDynamicRenderTemplateHelper().jad_bo()) != null && jad_bo.length() > 0) {
                jSONObject.put("template_list", jADSlot.getDynamicRenderTemplateHelper().jad_bo());
            }
            jSONObject.put("render_form", jADSlot.isFromNativeAd() ? 1 : 0);
            jSONObject.put("display_scene", jADSlot.getDisplayScene());
            jSONArray.put(jSONObject);
        }
        return jSONArray;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:75:0x01f2
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1179)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    /* JADX WARN: Removed duplicated region for block: B:22:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0240 A[Catch: Exception -> 0x023e, TryCatch #2 {Exception -> 0x023e, blocks: (B:41:0x0236, B:47:0x0240, B:49:0x0248), top: B:40:0x0236 }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0204 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01da A[Catch: Exception -> 0x01f2, TryCatch #12 {Exception -> 0x01f2, blocks: (B:33:0x01d1, B:76:0x01da, B:78:0x01e2, B:79:0x01e9), top: B:32:0x01d1 }] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01b4 A[Catch: Exception -> 0x01c8, TryCatch #9 {Exception -> 0x01c8, blocks: (B:27:0x01ab, B:86:0x01b4, B:89:0x01bf), top: B:26:0x01ab }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static org.json.JSONObject jad_an(android.content.Context r17) {
        /*
            Method dump skipped, instructions count: 731
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jd.ad.sdk.jad_jt.jad_hu.jad_an(android.content.Context):org.json.JSONObject");
    }

    public static byte[] jad_bo(@androidx.annotation.NonNull com.jd.ad.sdk.dl.model.JADSlot jADSlot) {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        boolean z = true;
        try {
            jSONObject.put("id", jADSlot.getRequestId());
            jSONObject.put("version", "4.1");
            jSONObject.put(com.umeng.analytics.pro.ay.c, jad_an(jADSlot));
            org.json.JSONObject jSONObject2 = new org.json.JSONObject();
            jSONObject2.put("id", com.jd.ad.sdk.bl.initsdk.JADYunSdk.getAppId());
            jSONObject2.put(com.bytedance.sdk.openadsdk.live.TTLiveConstants.BUNDLE_KEY, com.jd.ad.sdk.jad_qd.jad_jw.jad_an(com.jd.ad.sdk.jad_fq.jad_cp.jad_an()));
            jSONObject2.put("sdkversion", "2.6.20");
            jSONObject.put("app", jSONObject2);
            jSONObject.put(com.alipay.sdk.m.p.e.p, jad_an(com.jd.ad.sdk.jad_fq.jad_cp.jad_an()));
            jSONObject.put("anti", jad_an());
        } catch (java.lang.Exception e) {
            java.lang.String requestId = jADSlot != null ? jADSlot.getRequestId() : "";
            int i = com.jd.ad.sdk.jad_wj.jad_an.GW_REQUEST_JSON_ERROR.jad_an;
            java.lang.String slotID = jADSlot != null ? jADSlot.getSlotID() : "";
            int adType = jADSlot != null ? jADSlot.getAdType() : 0;
            java.lang.String jad_an = com.jd.ad.sdk.jad_wj.jad_an.GW_REQUEST_OTHER_ERROR.jad_an(e.getMessage());
            org.json.JSONObject jSONObject3 = new org.json.JSONObject();
            com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject3, "pid", slotID);
            com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject3, "adt", java.lang.Integer.valueOf(adType));
            com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject3, "error", jad_an);
            com.jd.ad.sdk.jad_xk.jad_fs.jad_an(requestId, 3, i, jSONObject3.toString(), jADSlot != null ? jADSlot.getSen() : 0);
        }
        com.jd.ad.sdk.logger.Logger.d("Gateway API Request: " + jSONObject);
        java.lang.String jSONObject4 = jSONObject.toString();
        com.jd.ad.sdk.jad_pc.jad_an jad_an2 = com.jd.ad.sdk.jad_re.jad_an.jad_an();
        if (jad_an2 != null && "1".equals(jad_an2.jad_bo)) {
            z = false;
        }
        if (z) {
            jSONObject4 = com.jd.ad.sdk.fdt.utils.ANEProxy.jd(jSONObject.toString());
            if (android.text.TextUtils.isEmpty(jSONObject4)) {
                return null;
            }
        }
        return jSONObject4.getBytes(java.nio.charset.StandardCharsets.UTF_8);
    }
}
