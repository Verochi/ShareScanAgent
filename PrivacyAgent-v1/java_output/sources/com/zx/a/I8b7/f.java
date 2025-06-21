package com.zx.a.I8b7;

/* loaded from: classes19.dex */
public class f implements java.lang.Runnable {

    public class a implements com.zx.a.I8b7.m2.b {
        public a(com.zx.a.I8b7.f fVar) {
        }

        @Override // com.zx.a.I8b7.m2.b
        public void a() {
        }

        @Override // com.zx.a.I8b7.m2.b
        public void a(int i, java.lang.String str) {
        }

        @Override // com.zx.a.I8b7.m2.b
        public void a(android.net.Network network) {
            try {
                java.net.HttpURLConnection httpURLConnection = (java.net.HttpURLConnection) network.openConnection(new java.net.URL("https://zxid-m.mobileservice.cn/sdk/ext/pconfig"));
                com.zx.a.I8b7.i0.a(httpURLConnection);
                byte[] bArr = new byte[16];
                new java.security.SecureRandom().nextBytes(bArr);
                com.zx.a.I8b7.p.b(bArr, com.zx.a.I8b7.m3.a(com.zx.a.I8b7.m3.h));
                java.util.HashMap<java.lang.String, java.lang.String> b = com.zx.a.I8b7.i0.b(new java.lang.String(android.util.Base64.encode(bArr, 2), java.nio.charset.StandardCharsets.UTF_8));
                httpURLConnection.setRequestMethod("POST");
                for (java.lang.String str : b.keySet()) {
                    httpURLConnection.setRequestProperty(str, b.get(str));
                }
                httpURLConnection.setRequestProperty("Content-type", "application/json; charset=UTF-8");
                httpURLConnection.setRequestProperty("Charset", "UTF-8");
                httpURLConnection.connect();
                org.json.JSONObject jSONObject = new org.json.JSONObject();
                java.io.BufferedWriter bufferedWriter = new java.io.BufferedWriter(new java.io.OutputStreamWriter(httpURLConnection.getOutputStream(), "UTF-8"));
                bufferedWriter.write(jSONObject.toString());
                bufferedWriter.close();
                com.zx.a.I8b7.r2.a(com.zx.a.I8b7.u1.a(com.zx.a.I8b7.x0.b("text/json; charset=utf-8"), httpURLConnection.getContentLength(), httpURLConnection.getResponseCode() == 200 ? httpURLConnection.getInputStream() : httpURLConnection.getErrorStream()).b());
                httpURLConnection.disconnect();
            } catch (java.lang.Throwable th) {
                com.zx.a.I8b7.r2.a(th.getMessage());
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            com.zx.a.I8b7.m2.c.a.a(new com.zx.a.I8b7.f.a(this));
        } catch (java.lang.Throwable th) {
            com.zx.a.I8b7.r2.a(th);
        }
    }
}
