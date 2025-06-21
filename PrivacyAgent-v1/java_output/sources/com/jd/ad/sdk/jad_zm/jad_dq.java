package com.jd.ad.sdk.jad_zm;

/* loaded from: classes23.dex */
public abstract class jad_dq {
    public com.jd.ad.sdk.jad_zm.jad_ly jad_an;
    public com.jd.ad.sdk.jad_zm.jad_an jad_bo;

    public jad_dq(com.jd.ad.sdk.jad_zm.jad_ly jad_lyVar) {
        try {
            this.jad_an = jad_lyVar;
            java.lang.String protocol = new java.net.URL(jad_lyVar.jad_an()).getProtocol();
            if (jad_bo(protocol)) {
                this.jad_bo = jad_an(protocol);
                return;
            }
            throw new java.lang.IllegalArgumentException("Invalid protocol: " + protocol);
        } catch (java.lang.Throwable th) {
            com.jd.ad.sdk.logger.Logger.w("Exception while creating base task", th.getMessage());
            throw new com.jd.ad.sdk.jad_do.jad_an(th);
        }
    }

    public final com.jd.ad.sdk.jad_zm.jad_an jad_an(java.lang.String str) {
        if (com.alipay.sdk.m.l.a.q.equalsIgnoreCase(str)) {
            return new com.jd.ad.sdk.jad_zm.jad_jt();
        }
        if ("https".equalsIgnoreCase(str)) {
            return new com.jd.ad.sdk.jad_zm.jad_iv();
        }
        throw new java.lang.IllegalArgumentException("Unsupported protocol: " + str);
    }

    public final boolean jad_bo(java.lang.String str) {
        return com.alipay.sdk.m.l.a.q.equalsIgnoreCase(str) || "https".equalsIgnoreCase(str);
    }
}
