package com.getui.gs.e;

/* loaded from: classes22.dex */
public final class b {
    public static void a(java.lang.String str) throws java.lang.Throwable {
        java.lang.String server;
        do {
            server = com.getui.gtc.server.ServerManager.getServer("ido.as");
            try {
                com.getui.gtc.base.http.Response execute = com.getui.gs.e.d.a.newCall(new com.getui.gtc.base.http.Request.Builder().cryptInterceptor(com.getui.gs.e.d.a(com.getui.gs.c.a.a("sdk.ido.bind.encrypt.enable", true))).url(java.lang.String.format("%s/sdk/v2/bd", server)).method("POST").body(com.getui.gtc.base.http.RequestBody.create(com.getui.gtc.base.http.MediaType.parse("application/json; charset=utf-8"), str)).tag("bind action").build()).execute();
                int code = execute.code();
                java.lang.String message = execute.message();
                if (code == 200) {
                    java.lang.String string = execute.body().string();
                    if (!com.getui.gs.e.d.a(string).a()) {
                        throw new java.lang.RuntimeException("response body: ".concat(java.lang.String.valueOf(string)));
                    }
                    com.getui.gs.g.c.a(true);
                    return;
                }
                throw new java.io.IOException("response code: " + code + ", message: " + message);
            } catch (java.lang.Throwable th) {
                com.getui.gs.g.c.a(false);
                if (!(th instanceof java.io.IOException)) {
                    break;
                }
                throw th;
            }
        } while (com.getui.gtc.server.ServerManager.switchServer("ido.as", server));
        throw th;
    }
}
