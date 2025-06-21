package com.getui.gs.e;

/* loaded from: classes22.dex */
public final class h {
    public static void a(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) throws java.lang.Throwable {
        com.getui.gtc.base.http.Response execute = com.getui.gs.e.d.a.newCall(new com.getui.gtc.base.http.Request.Builder().cryptInterceptor(com.getui.gs.e.d.a(com.getui.gs.c.a.a("sdk.ido.type20.encrypt.enable", true))).url(java.lang.String.format(str2, str)).method("POST").body(com.getui.gtc.base.http.RequestBody.create(com.getui.gtc.base.http.MediaType.parse("application/json; charset=utf-8"), str4)).tag("upload type ".concat(java.lang.String.valueOf(str3))).build()).execute();
        int code = execute.code();
        java.lang.String message = execute.message();
        if (code == 200) {
            java.lang.String string = execute.body().string();
            if (!com.getui.gs.e.d.a(string).a()) {
                throw new java.lang.RuntimeException("response body: ".concat(java.lang.String.valueOf(string)));
            }
            com.getui.gtc.server.ServerManager.confirmServer("ido.as", str);
            return;
        }
        throw new java.io.IOException("response code: " + code + ", message: " + message);
    }
}
