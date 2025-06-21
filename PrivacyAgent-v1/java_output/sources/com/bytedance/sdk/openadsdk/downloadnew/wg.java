package com.bytedance.sdk.openadsdk.downloadnew;

/* loaded from: classes22.dex */
public class wg {

    public static class vw {
        public int t;
        public java.net.HttpURLConnection v;
        public java.io.InputStream vw;
        public java.util.Map<java.lang.String, java.lang.String> wg;

        public vw(java.io.InputStream inputStream, java.util.Map<java.lang.String, java.lang.String> map, int i, java.net.HttpURLConnection httpURLConnection) {
            this.vw = inputStream;
            this.wg = map;
            this.t = i;
            this.v = httpURLConnection;
        }
    }

    public static com.bytedance.sdk.openadsdk.downloadnew.wg.vw vw(java.lang.String str, java.util.List<com.ss.android.socialbase.downloader.model.HttpHeader> list) throws java.io.IOException {
        int responseCode;
        java.util.HashMap hashMap = new java.util.HashMap();
        if (list != null && !list.isEmpty()) {
            for (com.ss.android.socialbase.downloader.model.HttpHeader httpHeader : list) {
                hashMap.put(httpHeader.getName(), httpHeader.getValue());
            }
        }
        java.net.HttpURLConnection vw2 = vw(str, hashMap);
        if (vw2 == null || (responseCode = vw2.getResponseCode()) < 200 || responseCode >= 300) {
            return null;
        }
        java.util.Map<java.lang.String, java.lang.String> vw3 = vw(vw2);
        java.io.InputStream inputStream = vw2.getInputStream();
        java.lang.String contentEncoding = vw2.getContentEncoding();
        if (!android.text.TextUtils.isEmpty(contentEncoding) && contentEncoding.contains("gzip")) {
            inputStream = new java.util.zip.GZIPInputStream(inputStream);
        }
        return new com.bytedance.sdk.openadsdk.downloadnew.wg.vw(inputStream, vw3, responseCode, vw2);
    }

    public static java.net.HttpURLConnection vw(java.lang.String str, java.util.Map<java.lang.String, java.lang.String> map) {
        java.net.HttpURLConnection httpURLConnection;
        java.net.HttpURLConnection httpURLConnection2 = null;
        if (android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            httpURLConnection = (java.net.HttpURLConnection) new java.net.URL(str).openConnection();
        } catch (java.lang.Exception unused) {
        }
        try {
            httpURLConnection.setInstanceFollowRedirects(false);
            httpURLConnection.setRequestProperty("accept", "*/*");
            httpURLConnection.setRequestProperty("connection", com.anythink.expressad.foundation.g.f.g.b.c);
            if (map != null && !map.isEmpty()) {
                for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : map.entrySet()) {
                    httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
                }
            }
            httpURLConnection.connect();
            int responseCode = httpURLConnection.getResponseCode();
            return ((responseCode < 200 || responseCode >= 300) && responseCode >= 300 && responseCode < 400) ? vw(httpURLConnection.getHeaderField("Location"), map) : httpURLConnection;
        } catch (java.lang.Exception unused2) {
            httpURLConnection2 = httpURLConnection;
            return httpURLConnection2;
        }
    }

    public static java.util.Map<java.lang.String, java.lang.String> vw(java.net.HttpURLConnection httpURLConnection) {
        java.util.HashMap hashMap = new java.util.HashMap();
        int size = httpURLConnection.getHeaderFields().size();
        for (int i = 0; i < size; i++) {
            hashMap.put(httpURLConnection.getHeaderFieldKey(i), httpURLConnection.getHeaderField(i));
        }
        return hashMap;
    }
}
