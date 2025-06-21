package com.getui.gtc.g;

/* loaded from: classes22.dex */
public final class a {
    public static void a(java.lang.String str, int i) throws java.lang.Exception {
        while (true) {
            java.lang.String server = com.getui.gtc.server.ServerManager.getServer("gtc.bs");
            try {
                com.getui.gtc.base.http.Request.Builder method = new com.getui.gtc.base.http.Request.Builder().url(java.lang.String.format("%s/api.php?format=json&t=1", server)).method("POST");
                com.getui.gtc.base.http.MediaType parse = com.getui.gtc.base.http.MediaType.parse("application/json; charset=utf-8");
                org.json.JSONObject jSONObject = new org.json.JSONObject();
                jSONObject.put("action", "upload_BI");
                jSONObject.put("BIType", java.lang.String.valueOf(i));
                jSONObject.put("cid", com.getui.gtc.c.b.d);
                jSONObject.put("BIData", new java.lang.String(com.getui.gtc.base.util.io.IOUtils.encode(str.getBytes(), 0), "UTF-8"));
                com.getui.gtc.base.http.Request build = method.body(com.getui.gtc.base.http.RequestBody.create(parse, jSONObject.toString())).cryptInterceptor(new com.getui.gtc.base.http.crypt.GtRASCryptoInterceptor(com.getui.gtc.c.b.i, com.getui.gtc.c.b.h)).tag("type" + i + " task ").build();
                com.getui.gtc.h.c.a.a("type " + i + " data: " + str);
                com.getui.gtc.base.http.Response execute = com.getui.gtc.g.d.a.newCall(build).execute();
                com.getui.gtc.server.ServerManager.confirmServer("gtc.bs", server);
                execute.close();
                return;
            } catch (java.lang.Exception e) {
                com.getui.gtc.h.c.a.b("type " + i + " error : " + e.getMessage());
                if (!(e instanceof java.io.IOException) || !com.getui.gtc.server.ServerManager.switchServer("gtc.bs", server)) {
                    throw e;
                }
                com.getui.gtc.h.c.a.b("type " + i + " failed with server: " + server + ", try again with: " + com.getui.gtc.server.ServerManager.getServer("gtc.bs"));
            }
        }
        throw e;
    }
}
