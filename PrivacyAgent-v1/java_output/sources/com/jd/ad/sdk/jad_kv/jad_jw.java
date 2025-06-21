package com.jd.ad.sdk.jad_kv;

/* loaded from: classes23.dex */
public class jad_jw implements com.jd.ad.sdk.jad_kv.jad_dq<java.io.InputStream> {

    @androidx.annotation.VisibleForTesting
    public static final com.jd.ad.sdk.jad_kv.jad_jw.jad_bo jad_fs = new com.jd.ad.sdk.jad_kv.jad_jw.jad_an();
    public final com.jd.ad.sdk.jad_qb.jad_jt jad_an;
    public final int jad_bo;
    public java.net.HttpURLConnection jad_cp;
    public java.io.InputStream jad_dq;
    public volatile boolean jad_er;

    public static class jad_an implements com.jd.ad.sdk.jad_kv.jad_jw.jad_bo {
    }

    public interface jad_bo {
    }

    @androidx.annotation.VisibleForTesting
    public jad_jw(com.jd.ad.sdk.jad_qb.jad_jt jad_jtVar, int i, com.jd.ad.sdk.jad_kv.jad_jw.jad_bo jad_boVar) {
        this.jad_an = jad_jtVar;
        this.jad_bo = i;
    }

    public static int jad_an(java.net.HttpURLConnection httpURLConnection) {
        try {
            return httpURLConnection.getResponseCode();
        } catch (java.io.IOException e) {
            if (!android.util.Log.isLoggable("HttpUrlFetcher", 3)) {
                return -1;
            }
            com.jd.ad.sdk.logger.Logger.d("HttpUrlFetcher", "Failed to get a response code", e);
            return -1;
        }
    }

    public final java.io.InputStream jad_an(java.net.URL url, int i, java.net.URL url2, java.util.Map<java.lang.String, java.lang.String> map) {
        java.io.InputStream inputStream;
        if (i >= 5) {
            throw new com.jd.ad.sdk.jad_ju.jad_er("Too many (> 5) redirects!", -1, null);
        }
        if (url2 != null) {
            try {
                if (url.toURI().equals(url2.toURI())) {
                    throw new com.jd.ad.sdk.jad_ju.jad_er("In re-direct loop", -1, null);
                }
            } catch (java.net.URISyntaxException unused) {
            }
        }
        try {
            java.net.HttpURLConnection httpURLConnection = (java.net.HttpURLConnection) url.openConnection();
            for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : map.entrySet()) {
                httpURLConnection.addRequestProperty(entry.getKey(), entry.getValue());
            }
            httpURLConnection.setConnectTimeout(this.jad_bo);
            httpURLConnection.setReadTimeout(this.jad_bo);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setInstanceFollowRedirects(false);
            this.jad_cp = httpURLConnection;
            try {
                httpURLConnection.connect();
                this.jad_dq = this.jad_cp.getInputStream();
                if (this.jad_er) {
                    return null;
                }
                int jad_an2 = jad_an(this.jad_cp);
                int i2 = jad_an2 / 100;
                if (i2 == 2) {
                    java.net.HttpURLConnection httpURLConnection2 = this.jad_cp;
                    try {
                        if (android.text.TextUtils.isEmpty(httpURLConnection2.getContentEncoding())) {
                            inputStream = new com.jd.ad.sdk.jad_ir.jad_cp(httpURLConnection2.getInputStream(), httpURLConnection2.getContentLength());
                        } else {
                            if (android.util.Log.isLoggable("HttpUrlFetcher", 3)) {
                                com.jd.ad.sdk.logger.Logger.d("HttpUrlFetcher", "Got non empty content encoding: " + httpURLConnection2.getContentEncoding());
                            }
                            inputStream = httpURLConnection2.getInputStream();
                        }
                        this.jad_dq = inputStream;
                        return inputStream;
                    } catch (java.io.IOException e) {
                        throw new com.jd.ad.sdk.jad_ju.jad_er("Failed to obtain InputStream", jad_an(httpURLConnection2), e);
                    }
                }
                if (!(i2 == 3)) {
                    if (jad_an2 == -1) {
                        throw new com.jd.ad.sdk.jad_ju.jad_er("Http request failed", jad_an2, null);
                    }
                    try {
                        throw new com.jd.ad.sdk.jad_ju.jad_er(this.jad_cp.getResponseMessage(), jad_an2, null);
                    } catch (java.io.IOException e2) {
                        throw new com.jd.ad.sdk.jad_ju.jad_er("Failed to get a response message", jad_an2, e2);
                    }
                }
                java.lang.String headerField = this.jad_cp.getHeaderField("Location");
                if (android.text.TextUtils.isEmpty(headerField)) {
                    throw new com.jd.ad.sdk.jad_ju.jad_er("Received empty or null redirect url", jad_an2, null);
                }
                try {
                    java.net.URL url3 = new java.net.URL(url, headerField);
                    jad_bo();
                    return jad_an(url3, i + 1, url, map);
                } catch (java.net.MalformedURLException e3) {
                    throw new com.jd.ad.sdk.jad_ju.jad_er("Bad redirect url: " + headerField, jad_an2, e3);
                }
            } catch (java.io.IOException e4) {
                throw new com.jd.ad.sdk.jad_ju.jad_er("Failed to connect or obtain data", jad_an(this.jad_cp), e4);
            }
        } catch (java.io.IOException e5) {
            throw new com.jd.ad.sdk.jad_ju.jad_er("URL.openConnection threw", 0, e5);
        }
    }

    @Override // com.jd.ad.sdk.jad_kv.jad_dq
    @androidx.annotation.NonNull
    public java.lang.Class<java.io.InputStream> jad_an() {
        return java.io.InputStream.class;
    }

    @Override // com.jd.ad.sdk.jad_kv.jad_dq
    public void jad_an(@androidx.annotation.NonNull com.jd.ad.sdk.jad_gr.jad_jt jad_jtVar, @androidx.annotation.NonNull com.jd.ad.sdk.jad_kv.jad_dq.jad_an<? super java.io.InputStream> jad_anVar) {
        long jad_an2 = com.jd.ad.sdk.jad_ir.jad_jt.jad_an();
        try {
            try {
                jad_anVar.jad_an((com.jd.ad.sdk.jad_kv.jad_dq.jad_an<? super java.io.InputStream>) jad_an(this.jad_an.jad_bo(), 0, null, this.jad_an.jad_bo.jad_an()));
                if (android.util.Log.isLoggable("HttpUrlFetcher", 2)) {
                    java.lang.StringBuilder jad_an3 = com.jd.ad.sdk.jad_gr.jad_ly.jad_an("Finished http url fetcher fetch in ");
                    jad_an3.append(com.jd.ad.sdk.jad_ir.jad_jt.jad_an(jad_an2));
                    com.jd.ad.sdk.logger.Logger.v("HttpUrlFetcher", jad_an3.toString());
                }
            } catch (java.io.IOException e) {
                if (android.util.Log.isLoggable("HttpUrlFetcher", 3)) {
                    com.jd.ad.sdk.logger.Logger.d("HttpUrlFetcher", "Failed to load data for url", e);
                }
                jad_anVar.jad_an((java.lang.Exception) e);
                if (android.util.Log.isLoggable("HttpUrlFetcher", 2)) {
                    java.lang.StringBuilder jad_an4 = com.jd.ad.sdk.jad_gr.jad_ly.jad_an("Finished http url fetcher fetch in ");
                    jad_an4.append(com.jd.ad.sdk.jad_ir.jad_jt.jad_an(jad_an2));
                    com.jd.ad.sdk.logger.Logger.v("HttpUrlFetcher", jad_an4.toString());
                }
            }
        } catch (java.lang.Throwable th) {
            if (android.util.Log.isLoggable("HttpUrlFetcher", 2)) {
                java.lang.StringBuilder jad_an5 = com.jd.ad.sdk.jad_gr.jad_ly.jad_an("Finished http url fetcher fetch in ");
                jad_an5.append(com.jd.ad.sdk.jad_ir.jad_jt.jad_an(jad_an2));
                com.jd.ad.sdk.logger.Logger.v("HttpUrlFetcher", jad_an5.toString());
            }
            throw th;
        }
    }

    @Override // com.jd.ad.sdk.jad_kv.jad_dq
    public void jad_bo() {
        java.io.InputStream inputStream = this.jad_dq;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (java.io.IOException unused) {
            }
        }
        java.net.HttpURLConnection httpURLConnection = this.jad_cp;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
        this.jad_cp = null;
    }

    @Override // com.jd.ad.sdk.jad_kv.jad_dq
    public void jad_cp() {
        this.jad_er = true;
    }

    @Override // com.jd.ad.sdk.jad_kv.jad_dq
    @androidx.annotation.NonNull
    public com.jd.ad.sdk.jad_ju.jad_an jad_dq() {
        return com.jd.ad.sdk.jad_ju.jad_an.REMOTE;
    }
}
