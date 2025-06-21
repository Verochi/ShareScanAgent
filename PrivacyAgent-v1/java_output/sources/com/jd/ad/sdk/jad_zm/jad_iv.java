package com.jd.ad.sdk.jad_zm;

/* loaded from: classes23.dex */
public final class jad_iv extends com.jd.ad.sdk.jad_zm.jad_an {
    public static java.lang.String[] jad_cp = new java.lang.String[0];
    public javax.net.ssl.HttpsURLConnection jad_bo;

    @Override // com.jd.ad.sdk.jad_zm.jad_an
    public java.net.URLConnection jad_an(com.jd.ad.sdk.jad_zm.jad_ly jad_lyVar) {
        javax.net.ssl.HttpsURLConnection httpsURLConnection = (javax.net.ssl.HttpsURLConnection) new java.net.URL(jad_lyVar.jad_er).openConnection();
        this.jad_bo = httpsURLConnection;
        httpsURLConnection.setConnectTimeout(jad_lyVar.jad_cp);
        this.jad_bo.setReadTimeout(jad_lyVar.jad_dq);
        this.jad_bo.setInstanceFollowRedirects(jad_lyVar.jad_jt);
        int i = jad_lyVar.jad_an;
        this.jad_bo.setRequestMethod(com.jd.ad.sdk.jad_zm.jad_kx.jad_an(i));
        this.jad_bo.setDoInput(true);
        this.jad_bo.setDoOutput(com.jd.ad.sdk.jad_jt.jad_fs.jad_an(i, 2));
        this.jad_bo.setUseCaches(false);
        com.jd.ad.sdk.jad_zm.jad_fs jad_fsVar = jad_lyVar.jad_bo;
        if (jad_fsVar != null) {
            java.util.List<java.lang.String> list = jad_fsVar.jad_an.get(com.google.common.net.HttpHeaders.CONNECTION);
            if (list != null && !list.isEmpty()) {
                jad_fsVar.jad_bo(com.google.common.net.HttpHeaders.CONNECTION, list.get(0));
            }
            for (java.util.Map.Entry entry : ((java.util.LinkedHashMap) com.jd.ad.sdk.jad_zm.jad_fs.jad_an(jad_fsVar)).entrySet()) {
                this.jad_bo.setRequestProperty((java.lang.String) entry.getKey(), (java.lang.String) entry.getValue());
            }
        }
        this.jad_bo.setSSLSocketFactory(new com.jd.ad.sdk.jad_zm.jad_na(com.jd.ad.sdk.jad_fq.jad_cp.jad_an()));
        this.jad_bo.setHostnameVerifier(new com.jd.ad.sdk.jad_zm.jad_hu());
        this.jad_bo.connect();
        return this.jad_bo;
    }

    @Override // com.jd.ad.sdk.jad_zm.jad_an
    public void jad_an() {
        javax.net.ssl.HttpsURLConnection httpsURLConnection = this.jad_bo;
        if (httpsURLConnection != null) {
            java.io.InputStream inputStream = httpsURLConnection.getInputStream();
            if (inputStream != null) {
                inputStream.close();
            }
            this.jad_bo.disconnect();
        }
    }

    @Override // com.jd.ad.sdk.jad_zm.jad_an
    public int jad_bo() {
        return this.jad_bo.getResponseCode();
    }
}
