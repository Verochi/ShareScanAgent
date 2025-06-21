package com.jd.ad.sdk.jad_re;

/* loaded from: classes23.dex */
public class jad_an {
    public static com.jd.ad.sdk.jad_pc.jad_cp jad_an;

    @androidx.annotation.Nullable
    public static com.jd.ad.sdk.jad_pc.jad_an jad_an() {
        com.jd.ad.sdk.jad_pc.jad_cp jad_cp = jad_cp();
        if (jad_cp == null) {
            return null;
        }
        return jad_cp.jad_iv;
    }

    public static boolean jad_bo() {
        com.jd.ad.sdk.jad_uh.jad_an jad_anVar = com.jd.ad.sdk.jad_uh.jad_an.jad_bo.jad_an;
        jad_anVar.getClass();
        java.lang.String str = "";
        if (!android.text.TextUtils.isEmpty("Config")) {
            java.lang.StringBuilder jad_an2 = com.jd.ad.sdk.jad_bo.jad_bo.jad_an("Config");
            jad_an2.append(com.jd.ad.sdk.bl.initsdk.JADYunSdk.getAppId());
            java.lang.String jad_an3 = jad_anVar.jad_an(jad_an2.toString());
            if (!android.text.TextUtils.isEmpty(jad_an3)) {
                str = jad_an3;
            }
        }
        if (android.text.TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            jad_an = com.jd.ad.sdk.jad_pc.jad_cp.jad_an(new org.json.JSONObject(str));
        } catch (java.lang.Exception e) {
            java.lang.StringBuilder jad_an4 = com.jd.ad.sdk.jad_bo.jad_bo.jad_an("Exception while read config cache: ");
            jad_an4.append(e.getMessage());
            com.jd.ad.sdk.logger.Logger.d(jad_an4.toString());
        }
        return jad_an != null;
    }

    @androidx.annotation.Nullable
    public static com.jd.ad.sdk.jad_pc.jad_cp jad_cp() {
        if (jad_bo()) {
            return jad_an;
        }
        com.jd.ad.sdk.jad_pc.jad_cp jad_cpVar = new com.jd.ad.sdk.jad_pc.jad_cp();
        com.jd.ad.sdk.jad_pc.jad_bo jad_boVar = new com.jd.ad.sdk.jad_pc.jad_bo();
        jad_boVar.jad_an = com.jd.ad.sdk.jad_fq.jad_fs.jad_an("aHR0cHM6Ly9kc3AteC5qZC5jb20vYWR4L3Nkaw==");
        jad_boVar.jad_bo = com.jd.ad.sdk.jad_fq.jad_fs.jad_an("aHR0cHM6Ly9kc3AtdGVzdC14LmpkLmNvbS9hZHgvc2Rr");
        jad_cpVar.jad_an = jad_boVar;
        com.jd.ad.sdk.jad_pc.jad_dq jad_dqVar = new com.jd.ad.sdk.jad_pc.jad_dq();
        jad_dqVar.jad_cp = 0;
        jad_dqVar.jad_bo = 1;
        jad_dqVar.jad_an = com.jd.ad.sdk.jad_fq.jad_fs.jad_an("aHR0cHM6Ly94bG9nLmpkLmNvbS92MS9hbg==");
        jad_cpVar.jad_bo = jad_dqVar;
        jad_cpVar.jad_dq = 5000L;
        java.util.ArrayList arrayList = new java.util.ArrayList(1);
        com.jd.ad.sdk.jad_pc.jad_fs jad_fsVar = new com.jd.ad.sdk.jad_pc.jad_fs();
        jad_fsVar.jad_an = 1;
        jad_fsVar.jad_bo = "Audience";
        jad_fsVar.jad_cp = com.jd.ad.sdk.bl.initsdk.JADYunSdk.getAppId();
        arrayList.add(jad_fsVar);
        jad_cpVar.jad_cp = arrayList;
        return jad_cpVar;
    }
}
