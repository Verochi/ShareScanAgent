package com.getui.gs.e;

/* loaded from: classes22.dex */
public final class c {
    /* JADX WARN: Removed duplicated region for block: B:57:0x0214  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x021c A[EDGE_INSN: B:62:0x021c->B:60:0x021c BREAK  A[LOOP:0: B:2:0x0006->B:61:?], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(com.getui.gs.d.a.EnumC0289a enumC0289a, java.lang.String str, java.lang.String str2, java.util.List<com.getui.gs.d.a> list, int i, int i2) throws java.lang.Throwable {
        java.lang.String server;
        com.getui.gs.b.e eVar;
        do {
            org.json.JSONObject a = com.getui.gs.e.d.a();
            org.json.JSONArray jSONArray = new org.json.JSONArray();
            a.put("data", jSONArray);
            int min = java.lang.Math.min(i2, list.size() - 1);
            for (int max = java.lang.Math.max(i, 0); max <= min; max++) {
                org.json.JSONObject jSONObject = new org.json.JSONObject();
                jSONArray.put(jSONObject);
                com.getui.gs.d.a aVar = list.get(max);
                if (aVar != null) {
                    com.getui.gs.d.a.EnumC0289a enumC0289a2 = aVar.d;
                    org.json.JSONObject jSONObject2 = aVar.e;
                    a(jSONObject2, "$app_version", com.getui.gs.a.d.f());
                    a(jSONObject2, "$channelId", com.getui.gs.a.d.h());
                    a(jSONObject2, "$lib_version", com.getui.gs.a.d.i());
                    a(jSONObject2, "$manufacturer", com.getui.gs.h.a.a.d());
                    a(jSONObject2, "$model", android.text.TextUtils.isEmpty(com.getui.gs.h.a.a.a()) ? "" : com.getui.gs.h.a.a.a().trim());
                    a(jSONObject2, "$os", "Android");
                    a(jSONObject2, "$os_version", com.getui.gs.h.a.a.b());
                    a(jSONObject2, "$package_name", com.getui.gs.a.d.g());
                    if (enumC0289a2 == com.getui.gs.d.a.EnumC0289a.TYPE_PROFILE) {
                        android.util.DisplayMetrics displayMetrics = com.getui.gs.a.d.a().getResources().getDisplayMetrics();
                        a(jSONObject2, "$screen_height", java.lang.Integer.valueOf(displayMetrics.heightPixels));
                        a(jSONObject2, "$screen_width", java.lang.Integer.valueOf(displayMetrics.widthPixels));
                        eVar = com.getui.gs.b.e.a.a;
                        a(jSONObject2, "$firstvisittime", com.getui.gs.h.d.a("yyyy-MM-dd HH:mm:ss").format(new java.util.Date(eVar.a.a())));
                    } else if (enumC0289a2 == com.getui.gs.d.a.EnumC0289a.TYPE_NORMAL || enumC0289a2 == com.getui.gs.d.a.EnumC0289a.TYPE_DURATION) {
                        java.lang.String f = com.getui.gs.h.a.a.f();
                        a(jSONObject2, "$wifi", java.lang.Boolean.valueOf(!android.text.TextUtils.isEmpty(f) && "WIFI".equals(f)));
                        a(jSONObject2, "$network_type", f);
                        a(jSONObject2, "$carrier", com.getui.gs.h.a.a.e());
                    }
                }
                if (aVar.d != com.getui.gs.d.a.EnumC0289a.TYPE_PROFILE) {
                    jSONObject.put(com.heytap.mcssdk.constant.b.k, aVar.b);
                }
                jSONObject.put(org.apache.tools.ant.types.selectors.DateSelector.DATETIME_KEY, aVar.c);
                jSONObject.put("sessionId", aVar.f);
                jSONObject.put("ext", aVar.h);
                jSONObject.put("isForeground", aVar.g);
                jSONObject.put("properties", aVar.e);
                org.json.JSONObject jSONObject3 = aVar.i;
                jSONObject3.put(com.liulishuo.filedownloader.model.FileDownloadModel.TOTAL, com.getui.gs.g.c.a(aVar.d, jSONObject3.getString(com.liulishuo.filedownloader.model.FileDownloadModel.TOTAL)));
                jSONObject.put(com.umeng.analytics.pro.bo.aA, jSONObject3);
            }
            java.lang.String jSONObject4 = a.toString();
            server = com.getui.gtc.server.ServerManager.getServer("ido.as");
            int i3 = (i2 - i) + 1;
            try {
                try {
                    try {
                        com.getui.gtc.base.http.Response execute = com.getui.gs.e.d.a.newCall(new com.getui.gtc.base.http.Request.Builder().cryptInterceptor(com.getui.gs.e.d.a(com.getui.gs.c.a.a(enumC0289a == com.getui.gs.d.a.EnumC0289a.TYPE_PROFILE ? "sdk.ido.type14.encrypt.enable" : "sdk.ido.type13.encrypt.enable", true))).url(java.lang.String.format(str, server)).method("POST").body(com.getui.gtc.base.http.RequestBody.create(com.getui.gtc.base.http.MediaType.parse("application/json; charset=utf-8"), jSONObject4)).tag(str2).build()).execute();
                        int code = execute.code();
                        java.lang.String message = execute.message();
                        if (code == 200) {
                            java.lang.String string = execute.body().string();
                            if (!com.getui.gs.e.d.a(string).a()) {
                                throw new java.lang.RuntimeException("response body: ".concat(java.lang.String.valueOf(string)));
                            }
                            com.getui.gs.g.c.a(enumC0289a, true, i3);
                            return;
                        }
                        throw new java.io.IOException("response code: " + code + ", message: " + message);
                    } catch (java.lang.Throwable th) {
                        th = th;
                        com.getui.gs.g.c.a(enumC0289a, false, i3);
                        if (th instanceof java.io.IOException) {
                            break;
                        }
                        throw th;
                    }
                } catch (java.lang.Throwable th2) {
                    th = th2;
                    com.getui.gs.g.c.a(enumC0289a, false, i3);
                    if (th instanceof java.io.IOException) {
                    }
                    throw th;
                }
            } catch (java.lang.Throwable th3) {
                th = th3;
            }
        } while (com.getui.gtc.server.ServerManager.switchServer("ido.as", server));
        throw th;
    }

    private static void a(org.json.JSONObject jSONObject, java.lang.String str, java.lang.Object obj) throws org.json.JSONException {
        if (jSONObject == null || jSONObject.has(str)) {
            return;
        }
        jSONObject.put(str, obj);
    }
}
