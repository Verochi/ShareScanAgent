package com.getui.gtc.g;

/* loaded from: classes22.dex */
public final class c {

    /* renamed from: com.getui.gtc.g.c$1, reason: invalid class name */
    public static class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ java.lang.String a;
        final /* synthetic */ com.getui.gtc.g.c.a b;

        public AnonymousClass1(java.lang.String str, com.getui.gtc.g.c.a aVar) {
            this.a = str;
            this.b = aVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                java.lang.String a = com.getui.gtc.g.c.a(this.a);
                com.getui.gtc.g.c.a aVar = this.b;
                if (aVar != null) {
                    aVar.a(a);
                }
            } catch (java.lang.Throwable th) {
                com.getui.gtc.h.c.a.c("register gtcId failed: " + th.getMessage());
            }
        }
    }

    public interface a {
        void a(java.lang.String str);
    }

    public static java.lang.String a(java.lang.String str) throws java.lang.Exception {
        com.getui.gtc.h.d.b unused;
        com.getui.gtc.h.d.b unused2;
        com.getui.gtc.h.d.b unused3;
        com.getui.gtc.h.d.b unused4;
        while (true) {
            java.lang.String server = com.getui.gtc.server.ServerManager.getServer("gtc.as");
            try {
                org.json.JSONObject jSONObject = new org.json.JSONObject();
                jSONObject.put("version", "1.0");
                org.json.JSONObject jSONObject2 = new org.json.JSONObject();
                jSONObject.put("data", jSONObject2);
                if (!android.text.TextUtils.isEmpty(str)) {
                    jSONObject2.put("gtcid", str);
                }
                unused = com.getui.gtc.h.d.b.C0330b.a;
                com.getui.gtc.dim.DimRequest.Builder key = new com.getui.gtc.dim.DimRequest.Builder().key(com.getui.gtc.extension.distribution.gbd.f.e.b.k);
                com.getui.gtc.dim.Caller caller = com.getui.gtc.dim.Caller.UNKNOWN;
                java.lang.String str2 = (java.lang.String) com.getui.gtc.dim.DimManager.getInstance().get(key.caller(caller).useExpiredCacheForReserve(true).build());
                if (!android.text.TextUtils.isEmpty(str2)) {
                    jSONObject2.put("oaid", str2);
                }
                if ("HONOR".equalsIgnoreCase(android.os.Build.MANUFACTURER)) {
                    unused2 = com.getui.gtc.h.d.b.C0330b.a;
                    java.lang.String str3 = (java.lang.String) com.getui.gtc.dim.DimManager.getInstance().get(new com.getui.gtc.dim.DimRequest.Builder().key(com.getui.gtc.extension.distribution.gbd.f.e.b.l).caller(caller).build());
                    if (!android.text.TextUtils.isEmpty(str3)) {
                        jSONObject2.put("oaid2", str3);
                    }
                }
                jSONObject2.put("gtAppid", com.getui.gtc.c.b.a);
                jSONObject2.put(com.vivo.push.PushClientConstants.TAG_PKG_NAME, com.getui.gtc.base.GtcProvider.context().getPackageName());
                jSONObject2.put("os", com.aliyun.vod.log.core.AliyunLogCommon.OPERATION_SYSTEM);
                unused3 = com.getui.gtc.h.d.b.C0330b.a;
                java.lang.String str4 = (java.lang.String) com.getui.gtc.dim.DimManager.getInstance().get(new com.getui.gtc.dim.DimRequest.Builder().key(com.getui.gtc.extension.distribution.gbd.f.e.b.q).caller(caller).useExpiredCacheForReserve(true).build());
                if (!android.text.TextUtils.isEmpty(str4)) {
                    jSONObject2.put("androidAid", str4);
                }
                unused4 = com.getui.gtc.h.d.b.C0330b.a;
                java.lang.String str5 = (java.lang.String) com.getui.gtc.dim.DimManager.getInstance().get(new com.getui.gtc.dim.DimRequest.Builder().key(com.getui.gtc.extension.distribution.gbd.f.e.b.f330s).caller(caller).useExpiredCacheForReserve(true).build());
                if (!android.text.TextUtils.isEmpty(str5)) {
                    jSONObject2.put("phoneModel", str5);
                }
                org.json.JSONObject jSONObject3 = new org.json.JSONObject(com.getui.gtc.g.d.a.newCall(new com.getui.gtc.base.http.Request.Builder().url(java.lang.String.format("%s/cidserver/getcid", server)).method("POST").body(com.getui.gtc.base.http.RequestBody.create(com.getui.gtc.base.http.MediaType.parse("application/json; charset=utf-8"), jSONObject.toString())).cryptInterceptor(new com.getui.gtc.base.http.crypt.PtRASCryptoInterceptor(com.getui.gtc.c.b.i, com.getui.gtc.c.b.h)).tag("register gtcid").build()).execute().body().string());
                int i = jSONObject3.getInt("errno");
                java.lang.String string = jSONObject3.getString("errmsg");
                if (i == 0) {
                    return jSONObject3.getJSONObject("data").getString("gtcid");
                }
                throw new java.lang.Exception(string);
            } catch (java.lang.Throwable th) {
                if (!(th instanceof java.io.IOException) || !com.getui.gtc.server.ServerManager.switchServer("gtc.as", server)) {
                    throw th;
                }
                com.getui.gtc.h.c.a.c("register gtcId failed with server: " + server + ", try again with: " + com.getui.gtc.server.ServerManager.getServer("gtc.as"));
            }
        }
    }

    public static void a(java.lang.String str, com.getui.gtc.g.c.a aVar) {
        com.getui.gtc.base.util.ScheduleQueue.getInstance().addSchedule(new com.getui.gtc.g.c.AnonymousClass1(str, aVar));
    }
}
