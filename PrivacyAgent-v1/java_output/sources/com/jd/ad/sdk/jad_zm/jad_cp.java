package com.jd.ad.sdk.jad_zm;

/* loaded from: classes23.dex */
public class jad_cp extends com.jd.ad.sdk.jad_zm.jad_dq implements java.lang.Runnable {
    public com.jd.ad.sdk.jad_zm.jad_cp.jad_an jad_cp;

    public interface jad_an {
    }

    public jad_cp(com.jd.ad.sdk.jad_zm.jad_ly jad_lyVar) {
        super(jad_lyVar);
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            com.jd.ad.sdk.jad_zm.jad_an jad_anVar = this.jad_bo;
            if (jad_anVar == null) {
                com.jd.ad.sdk.jad_zm.jad_cp.jad_an jad_anVar2 = this.jad_cp;
                if (jad_anVar2 != null) {
                    com.jd.ad.sdk.jad_cn.jad_an jad_anVar3 = com.jd.ad.sdk.jad_cn.jad_an.NET_CONNECTION_IS_NULL_ERROR;
                    ((com.jd.ad.sdk.jad_zm.jad_jw) jad_anVar2).jad_an(jad_anVar3.jad_an, jad_anVar3.jad_an(new java.lang.String[0]));
                }
                com.jd.ad.sdk.jad_zm.jad_an jad_anVar4 = this.jad_bo;
                if (jad_anVar4 != null) {
                    try {
                        jad_anVar4.jad_an();
                        return;
                    } catch (java.lang.Exception e) {
                        com.jd.ad.sdk.logger.Logger.w("Exception while async req: ", e.getMessage());
                        return;
                    }
                }
                return;
            }
            com.jd.ad.sdk.jad_zm.jad_mz jad_bo = jad_anVar.jad_bo(this.jad_an);
            if (jad_bo == null) {
                com.jd.ad.sdk.jad_zm.jad_cp.jad_an jad_anVar5 = this.jad_cp;
                if (jad_anVar5 != null) {
                    com.jd.ad.sdk.jad_cn.jad_an jad_anVar6 = com.jd.ad.sdk.jad_cn.jad_an.NET_HTTP_RESPONSE_IS_NULL_ERROR;
                    ((com.jd.ad.sdk.jad_zm.jad_jw) jad_anVar5).jad_an(jad_anVar6.jad_an, jad_anVar6.jad_an(new java.lang.String[0]));
                }
            } else {
                com.jd.ad.sdk.jad_zm.jad_cp.jad_an jad_anVar7 = this.jad_cp;
                if (jad_anVar7 != null) {
                    com.jd.ad.sdk.jad_zm.jad_ly.jad_an jad_anVar8 = ((com.jd.ad.sdk.jad_zm.jad_jw) jad_anVar7).jad_an.jad_hu;
                    if (jad_anVar8 != null) {
                        jad_anVar8.jad_an(jad_bo);
                    } else {
                        jad_bo.close();
                    }
                }
            }
            com.jd.ad.sdk.jad_zm.jad_an jad_anVar9 = this.jad_bo;
            if (jad_anVar9 != null) {
                try {
                    jad_anVar9.jad_an();
                } catch (java.lang.Exception e2) {
                    com.jd.ad.sdk.logger.Logger.w("Exception while async req: ", e2.getMessage());
                }
            }
        } catch (java.lang.Throwable th) {
            try {
                com.jd.ad.sdk.jad_zm.jad_cp.jad_an jad_anVar10 = this.jad_cp;
                if (jad_anVar10 == null) {
                    com.jd.ad.sdk.jad_zm.jad_an jad_anVar11 = this.jad_bo;
                    if (jad_anVar11 != null) {
                        try {
                            jad_anVar11.jad_an();
                            return;
                        } catch (java.lang.Exception e3) {
                            com.jd.ad.sdk.logger.Logger.w("Exception while async req: ", e3.getMessage());
                            return;
                        }
                    }
                    return;
                }
                com.jd.ad.sdk.jad_cn.jad_an jad_anVar12 = com.jd.ad.sdk.jad_cn.jad_an.NET_HTTP_OTHER_ERROR;
                ((com.jd.ad.sdk.jad_zm.jad_jw) jad_anVar10).jad_an(jad_anVar12.jad_an, jad_anVar12.jad_an(th.getMessage()));
                com.jd.ad.sdk.jad_zm.jad_an jad_anVar13 = this.jad_bo;
                if (jad_anVar13 != null) {
                    try {
                        jad_anVar13.jad_an();
                    } catch (java.lang.Exception e4) {
                        com.jd.ad.sdk.logger.Logger.w("Exception while async req: ", e4.getMessage());
                    }
                }
            } catch (java.lang.Throwable th2) {
                com.jd.ad.sdk.jad_zm.jad_an jad_anVar14 = this.jad_bo;
                if (jad_anVar14 != null) {
                    try {
                        jad_anVar14.jad_an();
                    } catch (java.lang.Exception e5) {
                        com.jd.ad.sdk.logger.Logger.w("Exception while async req: ", e5.getMessage());
                    }
                }
                throw th2;
            }
        }
    }
}
