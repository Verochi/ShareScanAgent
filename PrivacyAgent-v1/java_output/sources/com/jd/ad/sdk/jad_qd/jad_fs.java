package com.jd.ad.sdk.jad_qd;

/* loaded from: classes23.dex */
public class jad_fs {
    public com.jd.ad.sdk.bl.initsdk.JADPrivateController jad_jw;
    public java.lang.String jad_an = "";
    public java.lang.String jad_bo = "";
    public java.lang.String jad_cp = "0.0.0.0";
    public com.jd.ad.sdk.dl.baseinfo.JADLocation jad_dq = new com.jd.ad.sdk.dl.baseinfo.JADLocation();
    public boolean jad_er = true;
    public boolean jad_fs = true;
    public boolean jad_jt = true;
    public final java.util.concurrent.CopyOnWriteArrayList<java.lang.String> jad_hu = new java.util.concurrent.CopyOnWriteArrayList<>();
    public final java.util.concurrent.CopyOnWriteArrayList<java.lang.String> jad_iv = new java.util.concurrent.CopyOnWriteArrayList<>();

    public static class jad_an {
        public static final com.jd.ad.sdk.jad_qd.jad_fs jad_an = new com.jd.ad.sdk.jad_qd.jad_fs();
    }

    public java.lang.String jad_an() {
        if (!android.text.TextUtils.isEmpty(this.jad_cp) && !"0.0.0.0".equals(this.jad_cp)) {
            return this.jad_cp;
        }
        java.lang.String str = (java.lang.String) com.jd.ad.sdk.jad_uh.jad_an.jad_bo.jad_an.jad_an("ipCustom", java.lang.String.class);
        if (!android.text.TextUtils.isEmpty(str)) {
            java.lang.String str2 = new java.lang.String(android.util.Base64.decode(str.getBytes(), 10));
            if (!android.text.TextUtils.isEmpty(str2)) {
                return str2;
            }
        }
        return "0.0.0.0";
    }

    public boolean jad_an(java.lang.String str) {
        return this.jad_hu.contains(str) && (this.jad_iv.contains(str) ^ true);
    }

    public java.lang.String jad_bo() {
        if (!android.text.TextUtils.isEmpty(this.jad_an)) {
            return this.jad_an;
        }
        com.jd.ad.sdk.bl.initsdk.JADPrivateController jADPrivateController = this.jad_jw;
        if (jADPrivateController != null) {
            java.lang.String oaid = jADPrivateController.getOaid();
            this.jad_an = oaid;
            if (!android.text.TextUtils.isEmpty(oaid)) {
                com.jd.ad.sdk.jad_uh.jad_an.jad_bo.jad_an.jad_an("oidCustom", this.jad_an);
                return this.jad_an;
            }
        }
        java.lang.String jad_an2 = com.jd.ad.sdk.jad_uh.jad_an.jad_bo.jad_an.jad_an("oidCustom");
        this.jad_an = jad_an2;
        return jad_an2;
    }
}
