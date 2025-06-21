package com.jd.ad.sdk.jad_uh;

@android.annotation.SuppressLint({"ApplySharedPref"})
/* loaded from: classes23.dex */
public final class jad_dq {
    public static final java.util.Map<java.lang.String, com.jd.ad.sdk.jad_uh.jad_dq> jad_bo = new java.util.HashMap();
    public final android.content.SharedPreferences jad_an;

    public jad_dq(java.lang.String str, int i) {
        this.jad_an = com.jd.ad.sdk.jad_fq.jad_cp.jad_an().getSharedPreferences(str, i);
    }

    public static com.jd.ad.sdk.jad_uh.jad_dq jad_an(java.lang.String str) {
        boolean z;
        int length = str.length();
        int i = 0;
        while (true) {
            if (i >= length) {
                z = true;
                break;
            }
            if (!java.lang.Character.isWhitespace(str.charAt(i))) {
                z = false;
                break;
            }
            i++;
        }
        if (z) {
            str = "spUtils";
        }
        java.util.Map<java.lang.String, com.jd.ad.sdk.jad_uh.jad_dq> map = jad_bo;
        com.jd.ad.sdk.jad_uh.jad_dq jad_dqVar = (com.jd.ad.sdk.jad_uh.jad_dq) ((java.util.HashMap) map).get(str);
        if (jad_dqVar == null) {
            synchronized (com.jd.ad.sdk.jad_uh.jad_dq.class) {
                jad_dqVar = (com.jd.ad.sdk.jad_uh.jad_dq) ((java.util.HashMap) map).get(str);
                if (jad_dqVar == null) {
                    jad_dqVar = new com.jd.ad.sdk.jad_uh.jad_dq(str, 0);
                    ((java.util.HashMap) map).put(str, jad_dqVar);
                }
            }
        }
        return jad_dqVar;
    }
}
