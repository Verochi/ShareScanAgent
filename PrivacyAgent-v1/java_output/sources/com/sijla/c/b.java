package com.sijla.c;

/* loaded from: classes19.dex */
final class b implements java.lang.Runnable {
    private /* synthetic */ android.app.Application a;

    public b(android.app.Application application) {
        this.a = application;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0060, code lost:
    
        if (java.lang.Math.abs((java.lang.System.currentTimeMillis() / 1000) - (r2.lastModified() / 1000)) > com.sijla.c.d.a.optInt("cfgitl", 28800)) goto L10;
     */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void run() {
        org.json.JSONObject d;
        android.app.Application application = this.a;
        try {
            java.lang.String str = com.sijla.h.a.d.f(application) + "config";
            java.io.File file = new java.io.File(str);
            java.io.File file2 = new java.io.File(str + ".gz");
            if (!file.exists() || !file.isFile()) {
                com.sijla.h.j.a(application, "cfgver", "");
            }
            com.sijla.c.a.a(application, file2);
            if (!file.exists() || file.isDirectory()) {
                return;
            }
            try {
                java.lang.String trim = com.sijla.h.a.e.b(file).trim();
                if (com.sijla.h.c.a(trim) || (d = com.sijla.h.c.d(trim)) == null) {
                    return;
                }
                java.lang.String optString = d.optString("version", "");
                com.sijla.c.d.b = optString;
                com.sijla.h.j.a(application, "cfgver", optString);
                org.json.JSONObject optJSONObject = d.optJSONObject("base");
                if (optJSONObject != null) {
                    com.sijla.c.d.a = optJSONObject;
                }
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }
}
