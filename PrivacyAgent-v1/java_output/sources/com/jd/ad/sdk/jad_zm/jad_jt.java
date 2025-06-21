package com.jd.ad.sdk.jad_zm;

/* loaded from: classes23.dex */
public class jad_jt extends com.jd.ad.sdk.jad_zm.jad_an {
    public java.net.HttpURLConnection jad_bo;

    @Override // com.jd.ad.sdk.jad_zm.jad_an
    public java.net.URLConnection jad_an(com.jd.ad.sdk.jad_zm.jad_ly jad_lyVar) {
        java.net.HttpURLConnection httpURLConnection = (java.net.HttpURLConnection) new java.net.URL(jad_lyVar.jad_er).openConnection();
        this.jad_bo = httpURLConnection;
        httpURLConnection.setConnectTimeout(jad_lyVar.jad_cp);
        this.jad_bo.setReadTimeout(jad_lyVar.jad_dq);
        this.jad_bo.setInstanceFollowRedirects(jad_lyVar.jad_jt);
        int i = jad_lyVar.jad_an;
        this.jad_bo.setRequestMethod(com.jd.ad.sdk.jad_zm.jad_kx.jad_an(i));
        this.jad_bo.setDoInput(true);
        this.jad_bo.setDoOutput(com.jd.ad.sdk.jad_jt.jad_fs.jad_an(i, 2));
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
        this.jad_bo.connect();
        return this.jad_bo;
    }

    @Override // com.jd.ad.sdk.jad_zm.jad_an
    public void jad_an() {
        java.net.HttpURLConnection httpURLConnection = this.jad_bo;
        if (httpURLConnection != null) {
            java.io.InputStream inputStream = httpURLConnection.getInputStream();
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
