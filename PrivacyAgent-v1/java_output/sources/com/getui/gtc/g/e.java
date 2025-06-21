package com.getui.gtc.g;

/* loaded from: classes22.dex */
public final class e {
    private static int a;

    /* renamed from: com.getui.gtc.g.e$1, reason: invalid class name */
    public static class AnonymousClass1 implements com.getui.gtc.base.http.Call.Callback {
        final /* synthetic */ java.lang.String a;
        final /* synthetic */ java.lang.String b;
        final /* synthetic */ com.getui.gtc.g.e.a c;

        public AnonymousClass1(java.lang.String str, java.lang.String str2, com.getui.gtc.g.e.a aVar) {
            this.a = str;
            this.b = str2;
            this.c = aVar;
        }

        @Override // com.getui.gtc.base.http.Call.Callback
        public final void onFailure(com.getui.gtc.base.http.Call call, java.lang.Exception exc) {
            com.getui.gtc.h.c.a.b("Failed! = " + call.request().url());
            com.getui.gtc.h.c.a.b(exc);
            if (com.getui.gtc.g.e.a < 3) {
                com.getui.gtc.g.e.b();
                try {
                    java.lang.Thread.sleep(com.getui.gtc.g.e.a * 5000);
                } catch (java.lang.InterruptedException unused) {
                }
                com.getui.gtc.g.e.a(this.a, this.b, this.c);
            }
        }

        @Override // com.getui.gtc.base.http.Call.Callback
        public final void onResponse(com.getui.gtc.base.http.Call call, com.getui.gtc.base.http.Response response) {
            com.getui.gtc.g.e.c();
            byte[] body = response.getBody();
            try {
                byte[] decode = android.util.Base64.decode(this.b, 2);
                java.lang.String str = new java.lang.String(com.getui.gtc.base.crypt.CryptTools.decrypt("AES/CFB/NOPADDING", com.getui.gtc.base.crypt.CryptTools.wrapperKey("AES", decode), new javax.crypto.spec.IvParameterSpec(com.getui.gtc.base.crypt.CryptTools.digest("MD5", decode)), body));
                com.getui.gtc.h.c.a.a("fetch servers from " + call.request().url() + " :" + str);
                com.getui.gtc.g.e.a aVar = this.c;
                if (aVar != null) {
                    aVar.a(str);
                }
            } catch (java.lang.Throwable th) {
                com.getui.gtc.h.c.a.b(th);
            }
        }
    }

    public interface a {
        void a(java.lang.String str);
    }

    public static void a(java.lang.String str, java.lang.String str2, com.getui.gtc.g.e.a aVar) {
        com.getui.gtc.g.d.a.newCall(new com.getui.gtc.base.http.Request.Builder().url(str).method("GET").logFlags(1).tag("fetch servers").build()).enqueue(new com.getui.gtc.g.e.AnonymousClass1(str, str2, aVar));
    }

    public static /* synthetic */ int b() {
        int i = a;
        a = i + 1;
        return i;
    }

    public static /* synthetic */ int c() {
        a = 0;
        return 0;
    }
}
