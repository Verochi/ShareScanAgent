package com.jd.ad.sdk.bl.dynamicrender;

/* loaded from: classes23.dex */
public class DynamicRenderTemplateHelper {
    public static com.jd.ad.sdk.jad_hu.jad_bo jad_dq;
    public final java.lang.String jad_an;
    public final java.util.List<com.jd.ad.sdk.jad_hu.jad_cp> jad_bo;
    public java.lang.String jad_cp;

    public class jad_an implements java.lang.Runnable {
        public final /* synthetic */ com.jd.ad.sdk.jad_hu.jad_cp jad_an;

        public jad_an(com.jd.ad.sdk.bl.dynamicrender.DynamicRenderTemplateHelper dynamicRenderTemplateHelper, com.jd.ad.sdk.jad_hu.jad_cp jad_cpVar) {
            this.jad_an = jad_cpVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.jd.ad.sdk.jad_qd.jad_jw.jad_dq(com.jd.ad.sdk.jad_fq.jad_cp.jad_an())) {
                com.jd.ad.sdk.bl.dynamicrender.DynamicRenderTemplateHelper.jad_dq.jad_an(this.jad_an);
                return;
            }
            com.jd.ad.sdk.jad_hu.jad_cp jad_cpVar = this.jad_an;
            java.util.List<java.lang.String> list = com.jd.ad.sdk.jad_tg.jad_an.jad_an;
            if (jad_cpVar == null) {
                return;
            }
            try {
                android.content.ContentResolver jad_an = com.jd.ad.sdk.jad_tg.jad_an.jad_an();
                if (jad_an == null) {
                    return;
                }
                android.net.Uri parse = android.net.Uri.parse(com.jd.ad.sdk.jad_tg.jad_an.jad_bo() + "db_dynamic_render" + net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR + "update");
                android.content.ContentValues contentValues = new android.content.ContentValues();
                contentValues.put("_id", java.lang.Integer.valueOf(jad_cpVar.jad_an));
                contentValues.put("templateID", java.lang.Integer.valueOf(jad_cpVar.jad_cp));
                contentValues.put("templateUpdateTimeStamp", jad_cpVar.jad_dq);
                contentValues.put("templateJSON", jad_cpVar.jad_er);
                contentValues.put("timeStampInterval", jad_cpVar.jad_fs);
                contentValues.put("appIdPid", jad_cpVar.jad_bo);
                jad_an.update(parse, contentValues, null, null);
            } catch (java.lang.Exception e) {
                com.jd.ad.sdk.logger.Logger.w("Exception while multi process update template: ", e.getMessage());
            }
        }
    }

    public DynamicRenderTemplateHelper(android.content.Context context, java.lang.String str) {
        this.jad_an = str;
        if (!com.jd.ad.sdk.jad_qd.jad_jw.jad_dq(context)) {
            this.jad_bo = com.jd.ad.sdk.jad_tg.jad_an.jad_cp(str);
            return;
        }
        if (jad_dq == null) {
            com.jd.ad.sdk.jad_hu.jad_bo jad_an2 = com.jd.ad.sdk.jad_hu.jad_bo.jad_an(context, "jaddb.db", 2);
            jad_dq = jad_an2;
            jad_an2.jad_cp();
        }
        this.jad_bo = jad_dq.jad_an(str);
    }

    public static boolean jad_an() {
        com.jd.ad.sdk.jad_pc.jad_an jad_an2 = com.jd.ad.sdk.jad_re.jad_an.jad_an();
        return jad_an2 != null && "1".equals(jad_an2.jad_na);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x003b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void jad_an(java.lang.String str) {
        com.jd.ad.sdk.jad_yl.jad_jt jad_an2;
        com.jd.ad.sdk.jad_yl.jad_iv jad_ivVar;
        com.jd.ad.sdk.jad_yl.jad_hu jad_huVar;
        java.util.List<com.jd.ad.sdk.jad_yl.jad_dq> list;
        com.jd.ad.sdk.jad_yl.jad_dq jad_dqVar;
        com.jd.ad.sdk.jad_yl.jad_cp jad_cpVar;
        com.jd.ad.sdk.jad_hu.jad_cp jad_cpVar2 = null;
        if (!android.text.TextUtils.isEmpty(str)) {
            try {
                jad_an2 = com.jd.ad.sdk.jad_yl.jad_jt.jad_an(str);
            } catch (org.json.JSONException e) {
                e.printStackTrace();
            }
            jad_ivVar = (jad_an2 == null || (jad_huVar = jad_an2.jad_cp) == null || (list = jad_huVar.jad_an) == null || list.isEmpty() || (jad_dqVar = list.get(0)) == null || (jad_cpVar = jad_dqVar.jad_bo) == null) ? null : jad_cpVar.jad_bo;
            if (jad_ivVar == null) {
                return;
            }
            int i = jad_ivVar.jad_an;
            java.lang.String str2 = jad_ivVar.jad_bo;
            java.lang.String str3 = jad_ivVar.jad_cp;
            if (i == -1) {
                com.jd.ad.sdk.jad_wj.jad_an jad_anVar = com.jd.ad.sdk.jad_wj.jad_an.RENDER_DYNAMIC_GW_RESPONSE_TEMPLATE_ID_NULL_ERROR;
                com.jd.ad.sdk.jad_xk.jad_fs.jad_an("", 10, jad_anVar.jad_an, jad_anVar.jad_an(new java.lang.String[0]), 0);
            } else if (this.jad_bo.size() != 0) {
                java.util.Iterator<com.jd.ad.sdk.jad_hu.jad_cp> it = this.jad_bo.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    com.jd.ad.sdk.jad_hu.jad_cp next = it.next();
                    if (next.jad_cp == i) {
                        jad_cpVar2 = next;
                        break;
                    }
                }
            }
            if (!android.text.TextUtils.isEmpty(str3)) {
                this.jad_cp = str3;
                if (jad_cpVar2 == null) {
                    jad_cpVar2 = new com.jd.ad.sdk.jad_hu.jad_cp(0, this.jad_an, i, str2, str3, java.lang.System.currentTimeMillis() + "");
                } else {
                    jad_cpVar2.jad_er = str3;
                    if (!android.text.TextUtils.isEmpty(str2)) {
                        jad_cpVar2.jad_dq = str2;
                    }
                    jad_cpVar2.jad_fs = java.lang.System.currentTimeMillis() + "";
                }
            } else {
                if (jad_cpVar2 == null) {
                    if (i == -1) {
                        return;
                    }
                    com.jd.ad.sdk.jad_wj.jad_an jad_anVar2 = com.jd.ad.sdk.jad_wj.jad_an.RENDER_DYNAMIC_LOCAL_TEMPLATE_NULL_ERROR;
                    com.jd.ad.sdk.jad_xk.jad_fs.jad_an("", 10, jad_anVar2.jad_an, jad_anVar2.jad_an(new java.lang.String[0]), 0);
                    return;
                }
                java.lang.String str4 = jad_cpVar2.jad_er;
                if (android.text.TextUtils.isEmpty(str4)) {
                    com.jd.ad.sdk.jad_wj.jad_an jad_anVar3 = com.jd.ad.sdk.jad_wj.jad_an.RENDER_DYNAMIC_LOCAL_TEMPLATE_JSON_NULL_ERROR;
                    com.jd.ad.sdk.jad_xk.jad_fs.jad_an("", 10, jad_anVar3.jad_an, jad_anVar3.jad_an(new java.lang.String[0]), 0);
                    return;
                } else {
                    this.jad_cp = str4;
                    jad_cpVar2.jad_fs = java.lang.System.currentTimeMillis() + "";
                }
            }
            if (jad_cpVar2 != null) {
                com.jd.ad.sdk.fdt.thread.WorkExecutor.execute(new com.jd.ad.sdk.bl.dynamicrender.DynamicRenderTemplateHelper.jad_an(this, jad_cpVar2));
                return;
            }
            return;
        }
        jad_an2 = null;
        if (jad_an2 == null) {
            if (jad_ivVar == null) {
            }
        }
        if (jad_ivVar == null) {
        }
    }

    public org.json.JSONArray jad_bo() {
        if (this.jad_bo == null) {
            return null;
        }
        org.json.JSONArray jSONArray = new org.json.JSONArray();
        for (com.jd.ad.sdk.jad_hu.jad_cp jad_cpVar : this.jad_bo) {
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            jSONObject.put(com.alimm.tanx.core.ad.event.track.expose.ExposeManager.UtArgsNames.templateId, jad_cpVar.jad_cp);
            jSONObject.put("template_update_timestamp", jad_cpVar.jad_dq);
            jSONArray.put(jSONObject);
        }
        return jSONArray;
    }
}
