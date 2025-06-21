package com.umeng.pagesdk;

/* loaded from: classes19.dex */
public final class d {
    private static java.util.Map<java.lang.String, java.util.Map> a = new java.util.HashMap();
    private static com.umeng.pagesdk.c b;

    /* renamed from: com.umeng.pagesdk.d$1, reason: invalid class name */
    public static class AnonymousClass1 implements com.umeng.pagesdk.b.InterfaceC0528b {
        final /* synthetic */ org.json.JSONObject a;

        public AnonymousClass1(org.json.JSONObject jSONObject) {
            this.a = jSONObject;
        }

        @Override // com.umeng.pagesdk.b.InterfaceC0528b
        public final void a(com.umeng.pagesdk.a aVar) {
            try {
                this.a.put("te", aVar.c);
                this.a.put("le", aVar.a);
                com.efs.sdk.base.protocol.record.EfsJSONLog efsJSONLog = new com.efs.sdk.base.protocol.record.EfsJSONLog("pageperf");
                efsJSONLog.put("page", this.a);
                com.efs.sdk.base.EfsReporter reporter = com.umeng.pagesdk.PageManger.getReporter();
                if (reporter != null) {
                    reporter.send(efsJSONLog);
                }
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static void a(java.lang.String str) {
        java.util.Map map;
        if (android.text.TextUtils.isEmpty(str) || (map = a.get(str)) == null || (r0 = map.entrySet().iterator()) == null) {
            return;
        }
        org.json.JSONArray jSONArray = null;
        for (java.util.Map.Entry entry : map.entrySet()) {
            if (entry != null) {
                java.lang.String str2 = (java.lang.String) entry.getKey();
                java.lang.Long[] lArr = (java.lang.Long[]) entry.getValue();
                if (!android.text.TextUtils.isEmpty(str2) && lArr != null && lArr.length >= 2) {
                    org.json.JSONObject jSONObject = new org.json.JSONObject();
                    try {
                        jSONObject.put("mN", str2);
                        jSONObject.put("mBT", lArr[0]);
                        jSONObject.put("mET", lArr[1]);
                        if (jSONArray == null) {
                            jSONArray = new org.json.JSONArray();
                        }
                        jSONArray.put(jSONObject);
                    } catch (org.json.JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        if (jSONArray != null) {
            org.json.JSONObject jSONObject2 = new org.json.JSONObject();
            try {
                jSONObject2.put("pN", str);
                jSONObject2.put("pL", jSONArray);
                com.umeng.pagesdk.b.a(com.umeng.pagesdk.PageManger.getApplicationContext()).a(new com.umeng.pagesdk.d.AnonymousClass1(jSONObject2));
            } catch (org.json.JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void a(java.lang.String str, java.lang.String str2, boolean z) {
        if (android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(str2)) {
            java.lang.String str3 = com.umeng.pagesdk.PageManger.TAG;
            return;
        }
        if (!com.umeng.pagesdk.PageManger.isInit()) {
            java.lang.String str4 = com.umeng.pagesdk.PageManger.TAG;
            return;
        }
        com.umeng.pagesdk.PageConfigManger pageConfigManger = com.umeng.pagesdk.PageManger.getPageConfigManger();
        if (pageConfigManger == null || !pageConfigManger.enableTracer()) {
            java.lang.String str5 = com.umeng.pagesdk.PageManger.TAG;
            return;
        }
        if (z) {
            str2 = "UM_".concat(java.lang.String.valueOf(str2));
        }
        if (a.containsKey(str)) {
            java.util.Map map = a.get(str);
            if (map == null) {
                java.lang.String str6 = com.umeng.pagesdk.PageManger.TAG;
                return;
            }
            if (map.containsKey(str2)) {
                return;
            }
            if (com.umeng.pagesdk.PageManger.isDebug) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder("tracePageBegin. begin add method. ");
                sb.append(str2);
                sb.append(" - ");
                sb.append(str);
            }
            if (z || map.size() <= 6) {
                java.lang.Long[] lArr = new java.lang.Long[2];
                lArr[0] = java.lang.Long.valueOf(java.lang.System.currentTimeMillis());
                map.put(str2, lArr);
                return;
            } else {
                if (com.umeng.pagesdk.PageManger.isDebug) {
                    java.lang.StringBuilder sb2 = new java.lang.StringBuilder("tracePageBegin. user trace number of transfinite. ");
                    sb2.append(str2);
                    sb2.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                    sb2.append(str);
                    return;
                }
                return;
            }
        }
        if (str2.equals("UM_onCreate")) {
            if (com.umeng.pagesdk.PageManger.isDebug) {
                java.lang.StringBuilder sb3 = new java.lang.StringBuilder("tracePageBegin. begin add onCreate. ");
                sb3.append(str2);
                sb3.append(" - ");
                sb3.append(str);
            }
            java.lang.Long[] lArr2 = new java.lang.Long[2];
            lArr2[0] = java.lang.Long.valueOf(java.lang.System.currentTimeMillis());
            java.util.HashMap hashMap = new java.util.HashMap();
            hashMap.put(str2, lArr2);
            a.put(str, hashMap);
            com.umeng.pagesdk.c cVar = b;
            if (cVar != null) {
                cVar.b();
                com.umeng.pagesdk.c cVar2 = b;
                cVar2.j = str;
                cVar2.a();
                return;
            }
            com.umeng.pagesdk.c cVar3 = new com.umeng.pagesdk.c(com.umeng.pagesdk.PageManger.getApplicationContext());
            b = cVar3;
            cVar3.j = str;
            cVar3.a();
        }
    }

    public static void b(java.lang.String str, java.lang.String str2, boolean z) {
        if (android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(str2)) {
            java.lang.String str3 = com.umeng.pagesdk.PageManger.TAG;
            return;
        }
        if (!com.umeng.pagesdk.PageManger.isInit()) {
            java.lang.String str4 = com.umeng.pagesdk.PageManger.TAG;
            return;
        }
        com.umeng.pagesdk.PageConfigManger pageConfigManger = com.umeng.pagesdk.PageManger.getPageConfigManger();
        if (pageConfigManger == null || !pageConfigManger.enableTracer()) {
            java.lang.String str5 = com.umeng.pagesdk.PageManger.TAG;
            return;
        }
        if (z) {
            str2 = "UM_".concat(java.lang.String.valueOf(str2));
        }
        if (!a.containsKey(str)) {
            if (str2.equals("UM_onPause")) {
                if (com.umeng.pagesdk.PageManger.isDebug) {
                    "tracePageEnd. onPause stop fps. ".concat(java.lang.String.valueOf(str));
                }
                com.umeng.pagesdk.c cVar = b;
                if (cVar != null) {
                    cVar.b();
                    return;
                }
                return;
            }
            return;
        }
        java.util.Map map = a.get(str);
        if (map == null) {
            if (com.umeng.pagesdk.PageManger.isDebug) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder("tracePageEnd. ");
                sb.append(str);
                sb.append(" is null in pageMap!");
                return;
            }
            return;
        }
        if (!map.containsKey(str2)) {
            if (com.umeng.pagesdk.PageManger.isDebug) {
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder("tracePageEnd. ");
                sb2.append(str2);
                sb2.append(" non-exist in ");
                sb2.append(str);
                sb2.append(" map!");
                return;
            }
            return;
        }
        java.lang.Long[] lArr = (java.lang.Long[]) map.get(str2);
        if (lArr.length >= 2) {
            lArr[1] = java.lang.Long.valueOf(java.lang.System.currentTimeMillis());
        }
        if (str2.equals("UM_onResume")) {
            if (com.umeng.pagesdk.PageManger.isDebug) {
                "tracePageEnd. onResume save data. ".concat(java.lang.String.valueOf(str));
            }
            a(str);
            if (android.text.TextUtils.isEmpty(str) || !a.containsKey(str)) {
                return;
            }
            a.remove(str);
            return;
        }
        if (str2.equals("UM_onPause")) {
            if (com.umeng.pagesdk.PageManger.isDebug) {
                "tracePageEnd. onPause stop fps. ".concat(java.lang.String.valueOf(str));
            }
            com.umeng.pagesdk.c cVar2 = b;
            if (cVar2 != null) {
                cVar2.b();
                b = null;
            }
        }
    }
}
