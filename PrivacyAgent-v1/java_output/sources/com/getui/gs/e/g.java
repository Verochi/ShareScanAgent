package com.getui.gs.e;

/* loaded from: classes22.dex */
public final class g {
    public static void a(int i, java.lang.String str, java.lang.String str2, java.util.List<com.getui.gs.g.e> list, int i2, int i3) throws java.lang.Throwable {
        java.lang.String server;
        do {
            org.json.JSONObject a = com.getui.gs.e.d.a();
            a.put("action", "upload");
            a.put("manufacturer", com.getui.gs.h.a.a.d());
            a.put(com.vivo.push.PushClientConstants.TAG_PKG_NAME, com.getui.gs.a.d.g());
            a.put("phoneModel", com.getui.gs.h.a.a.a());
            org.json.JSONArray jSONArray = new org.json.JSONArray();
            int min = java.lang.Math.min(i3, list.size() - 1);
            for (int max = java.lang.Math.max(i2, 0); max <= min; max++) {
                com.getui.gs.g.e eVar = list.get(max);
                int i4 = eVar.c;
                org.json.JSONObject jSONObject = new org.json.JSONObject();
                jSONObject.put("type", i4);
                if (i4 == 11) {
                    jSONObject.put("isForeground", android.text.TextUtils.isEmpty(eVar.g) ? com.getui.gs.h.d.a() : eVar.g);
                }
                jSONObject.put("systemVersion", android.text.TextUtils.isEmpty(eVar.i) ? com.getui.gs.h.a.a.b() : eVar.i);
                jSONObject.put(com.heytap.mcssdk.constant.b.C, android.text.TextUtils.isEmpty(eVar.j) ? com.getui.gs.a.d.i() : eVar.j);
                jSONObject.put("sessionId", eVar.e);
                jSONObject.put(com.huawei.hms.push.constant.RemoteMessageConst.Notification.CHANNEL_ID, android.text.TextUtils.isEmpty(eVar.h) ? com.getui.gs.a.d.h() : eVar.h);
                jSONObject.put(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_VERSION_NAME, android.text.TextUtils.isEmpty(eVar.f) ? com.getui.gs.a.d.f() : eVar.f);
                jSONObject.put("sessionData", android.util.Base64.encodeToString(eVar.d.getBytes("UTF-8"), 0));
                org.json.JSONObject jSONObject2 = eVar.k;
                jSONObject2.put(com.liulishuo.filedownloader.model.FileDownloadModel.TOTAL, com.getui.gs.g.c.a(i4, jSONObject2.getString(com.liulishuo.filedownloader.model.FileDownloadModel.TOTAL)));
                jSONObject.put(com.umeng.analytics.pro.bo.aA, jSONObject2);
                jSONArray.put(jSONObject);
            }
            a.put("data", jSONArray);
            java.lang.String jSONObject3 = a.toString();
            server = com.getui.gtc.server.ServerManager.getServer("ido.as");
            int i5 = (i3 - i2) + 1;
            try {
                try {
                    com.getui.gtc.base.http.Response execute = com.getui.gs.e.d.a.newCall(new com.getui.gtc.base.http.Request.Builder().cryptInterceptor(com.getui.gs.e.d.a(com.getui.gs.c.a.a(i == 11 ? "sdk.ido.type11.encrypt.enable" : "sdk.ido.type8.encrypt.enable", true))).url(java.lang.String.format(str, server)).method("POST").body(com.getui.gtc.base.http.RequestBody.create(com.getui.gtc.base.http.MediaType.parse("application/json; charset=utf-8"), jSONObject3)).tag("upload type ".concat(java.lang.String.valueOf(str2))).build()).execute();
                    int code = execute.code();
                    java.lang.String message = execute.message();
                    if (code != 200) {
                        throw new java.io.IOException("response code: " + code + ", message: " + message);
                    }
                    java.lang.String string = execute.body().string();
                    if (!com.getui.gs.e.d.a(string).a()) {
                        throw new java.lang.RuntimeException("response body: ".concat(java.lang.String.valueOf(string)));
                    }
                    com.getui.gtc.server.ServerManager.confirmServer("ido.as", server);
                    com.getui.gs.g.c.a(i, true, i5);
                    return;
                } catch (java.lang.Throwable th) {
                    th = th;
                    com.getui.gs.g.c.a(i, false, i5);
                    if (!(th instanceof java.io.IOException)) {
                        break;
                    }
                    throw th;
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
            }
        } while (com.getui.gtc.server.ServerManager.switchServer("ido.as", server));
        throw th;
    }
}
