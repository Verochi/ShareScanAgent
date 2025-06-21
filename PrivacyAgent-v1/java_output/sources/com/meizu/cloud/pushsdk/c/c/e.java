package com.meizu.cloud.pushsdk.c.c;

/* loaded from: classes23.dex */
public class e implements com.meizu.cloud.pushsdk.c.c.a {

    /* renamed from: com.meizu.cloud.pushsdk.c.c.e$1, reason: invalid class name */
    public static class AnonymousClass1 extends com.meizu.cloud.pushsdk.c.c.l {
        final /* synthetic */ java.net.HttpURLConnection a;
        final /* synthetic */ com.meizu.cloud.pushsdk.c.g.d b;

        public AnonymousClass1(java.net.HttpURLConnection httpURLConnection, com.meizu.cloud.pushsdk.c.g.d dVar) {
            this.a = httpURLConnection;
            this.b = dVar;
        }

        @Override // com.meizu.cloud.pushsdk.c.c.l
        public com.meizu.cloud.pushsdk.c.g.d a() {
            return this.b;
        }
    }

    private static com.meizu.cloud.pushsdk.c.c.l a(java.net.HttpURLConnection httpURLConnection) throws java.io.IOException {
        if (httpURLConnection.getDoInput()) {
            return new com.meizu.cloud.pushsdk.c.c.e.AnonymousClass1(httpURLConnection, com.meizu.cloud.pushsdk.c.g.g.a(com.meizu.cloud.pushsdk.c.g.g.a(a(httpURLConnection.getResponseCode()) ? httpURLConnection.getInputStream() : httpURLConnection.getErrorStream())));
        }
        return null;
    }

    private static void a(java.net.HttpURLConnection httpURLConnection, com.meizu.cloud.pushsdk.c.c.i iVar) throws java.io.IOException {
        java.lang.String str;
        java.lang.String str2;
        int c = iVar.c();
        if (c != 0) {
            if (c == 1) {
                str2 = "POST";
            } else if (c == 2) {
                str2 = "PUT";
            } else if (c == 3) {
                str = "DELETE";
            } else if (c == 4) {
                str = "HEAD";
            } else {
                if (c != 5) {
                    throw new java.lang.IllegalStateException("Unknown method type.");
                }
                str2 = "PATCH";
            }
            httpURLConnection.setRequestMethod(str2);
            b(httpURLConnection, iVar);
            return;
        }
        str = "GET";
        httpURLConnection.setRequestMethod(str);
    }

    public static boolean a(int i) {
        return i >= 200 && i < 300;
    }

    private java.net.HttpURLConnection b(com.meizu.cloud.pushsdk.c.c.i iVar) throws java.io.IOException {
        java.net.URL url = new java.net.URL(iVar.a().toString());
        if (com.meizu.cloud.pushsdk.util.MinSdkChecker.isSupportNotificationChannel()) {
            android.net.TrafficStats.setThreadStatsTag(2006537699);
        }
        java.net.HttpURLConnection a = a(url);
        a.setConnectTimeout(60000);
        a.setReadTimeout(60000);
        a.setUseCaches(false);
        a.setDoInput(true);
        return a;
    }

    private static void b(java.net.HttpURLConnection httpURLConnection, com.meizu.cloud.pushsdk.c.c.i iVar) throws java.io.IOException {
        com.meizu.cloud.pushsdk.c.c.j e = iVar.e();
        if (e != null) {
            httpURLConnection.setDoOutput(true);
            httpURLConnection.addRequestProperty("Content-Type", e.a().toString());
            com.meizu.cloud.pushsdk.c.g.c a = com.meizu.cloud.pushsdk.c.g.g.a(com.meizu.cloud.pushsdk.c.g.g.a(httpURLConnection.getOutputStream()));
            e.a(a);
            a.close();
        }
    }

    @Override // com.meizu.cloud.pushsdk.c.c.a
    public com.meizu.cloud.pushsdk.c.c.k a(com.meizu.cloud.pushsdk.c.c.i iVar) throws java.io.IOException {
        java.net.HttpURLConnection b = b(iVar);
        for (java.lang.String str : iVar.d().b()) {
            java.lang.String a = iVar.a(str);
            com.meizu.cloud.pushsdk.c.a.a.b("current header name " + str + " value " + a);
            b.addRequestProperty(str, a);
        }
        a(b, iVar);
        return new com.meizu.cloud.pushsdk.c.c.k.a().a(b.getResponseCode()).a(iVar.d()).a(b.getResponseMessage()).a(iVar).a(a(b)).a();
    }

    public java.net.HttpURLConnection a(java.net.URL url) throws java.io.IOException {
        java.net.HttpURLConnection httpURLConnection = (java.net.HttpURLConnection) url.openConnection();
        httpURLConnection.setInstanceFollowRedirects(java.net.HttpURLConnection.getFollowRedirects());
        return httpURLConnection;
    }
}
