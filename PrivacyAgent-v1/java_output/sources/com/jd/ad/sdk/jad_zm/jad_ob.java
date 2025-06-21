package com.jd.ad.sdk.jad_zm;

/* loaded from: classes23.dex */
public class jad_ob implements java.io.Closeable {
    public java.lang.String jad_an;
    public java.io.BufferedInputStream jad_bo;

    public jad_ob(java.lang.String str, java.io.BufferedInputStream bufferedInputStream) {
        this.jad_an = str;
        this.jad_bo = bufferedInputStream;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.jad_bo.close();
    }

    public java.lang.String jad_bo() {
        java.lang.String str;
        java.lang.String str2 = this.jad_an;
        java.util.TimeZone timeZone = com.jd.ad.sdk.jad_zm.jad_fs.jad_bo;
        if (!android.text.TextUtils.isEmpty(str2) && !android.text.TextUtils.isEmpty("charset")) {
            java.util.StringTokenizer stringTokenizer = new java.util.StringTokenizer(str2, com.alipay.sdk.m.u.i.b);
            while (stringTokenizer.hasMoreElements()) {
                java.lang.String nextToken = stringTokenizer.nextToken();
                int indexOf = nextToken.indexOf(61);
                if (indexOf > 0 && "charset".equalsIgnoreCase(nextToken.substring(0, indexOf).trim())) {
                    str = nextToken.substring(indexOf + 1).trim();
                    break;
                }
            }
        }
        str = "UTF-8";
        return android.text.TextUtils.isEmpty(str) ? new java.lang.String(com.jd.ad.sdk.jad_fq.jad_jt.jad_an(this.jad_bo), java.nio.charset.StandardCharsets.UTF_8) : new java.lang.String(com.jd.ad.sdk.jad_fq.jad_jt.jad_an(this.jad_bo), str);
    }
}
