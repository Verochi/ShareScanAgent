package com.jd.ad.sdk.jad_qd;

/* loaded from: classes23.dex */
public class jad_hu {
    public static java.lang.String jad_an() {
        java.lang.String str = "";
        if (!com.jd.ad.sdk.jad_qd.jad_fs.jad_an.jad_an.jad_an("osVersion")) {
            return "";
        }
        com.jd.ad.sdk.jad_uh.jad_an jad_anVar = com.jd.ad.sdk.jad_uh.jad_an.jad_bo.jad_an;
        if (jad_anVar.jad_an("osVersion", true)) {
            str = jad_anVar.jad_dq("osVersion");
        } else {
            str = android.os.Build.VERSION.RELEASE;
            jad_anVar.jad_bo("osVersion", str);
        }
        return str;
    }

    public static java.lang.String jad_bo() {
        java.lang.String str = "";
        if (!com.jd.ad.sdk.jad_qd.jad_fs.jad_an.jad_an.jad_an("osUpdateTime")) {
            return "";
        }
        com.jd.ad.sdk.jad_uh.jad_an jad_anVar = com.jd.ad.sdk.jad_uh.jad_an.jad_bo.jad_an;
        if (jad_anVar.jad_an("osUpdateTime", true)) {
            str = jad_anVar.jad_dq("osUpdateTime");
        } else {
            str = "" + android.os.Build.TIME;
            jad_anVar.jad_bo("osUpdateTime", str);
        }
        return str;
    }

    public static java.lang.String jad_cp() {
        if (!com.jd.ad.sdk.jad_qd.jad_fs.jad_an.jad_an.jad_an("osApiVersion")) {
            return "";
        }
        com.jd.ad.sdk.jad_uh.jad_an jad_anVar = com.jd.ad.sdk.jad_uh.jad_an.jad_bo.jad_an;
        if (jad_anVar.jad_an("osApiVersion", true)) {
            return jad_anVar.jad_dq("osApiVersion");
        }
        java.lang.StringBuilder jad_an = com.jd.ad.sdk.jad_bo.jad_bo.jad_an("");
        jad_an.append(android.os.Build.VERSION.SDK_INT);
        java.lang.String sb = jad_an.toString();
        jad_anVar.jad_bo("osApiVersion", sb);
        return sb;
    }

    public static java.lang.String jad_dq() {
        java.lang.String str = "";
        if (!com.jd.ad.sdk.jad_qd.jad_fs.jad_an.jad_an.jad_an("ua")) {
            return "";
        }
        com.jd.ad.sdk.jad_uh.jad_an jad_anVar = com.jd.ad.sdk.jad_uh.jad_an.jad_bo.jad_an;
        if (jad_anVar.jad_an("ua", true)) {
            str = jad_anVar.jad_dq("ua");
        } else {
            str = java.lang.System.getProperty("http.agent") + " JADYunSDK/2.6.20";
            jad_anVar.jad_bo("ua", str);
        }
        return str;
    }

    public static synchronized int jad_er() {
        int i;
        synchronized (com.jd.ad.sdk.jad_qd.jad_hu.class) {
            if (!com.jd.ad.sdk.jad_qd.jad_fs.jad_an.jad_an.jad_an("jdAppInstalled")) {
                return -1;
            }
            com.jd.ad.sdk.jad_uh.jad_an jad_anVar = com.jd.ad.sdk.jad_uh.jad_an.jad_bo.jad_an;
            if (jad_anVar.jad_an("jdAppInstalled", true)) {
                i = jad_anVar.jad_cp("jdAppInstalled");
            } else {
                boolean jad_an = com.jd.ad.sdk.jad_fq.jad_bo.jad_an("com.jingdong.app.mall");
                jad_anVar.jad_bo("jdAppInstalled", java.lang.Integer.valueOf(jad_an ? 1 : 0));
                i = jad_an ? 1 : 0;
            }
            return i;
        }
    }

    public static int jad_fs() {
        if (!com.jd.ad.sdk.jad_qd.jad_fs.jad_an.jad_an.jad_an("tbAppInstalled")) {
            return -1;
        }
        com.jd.ad.sdk.jad_uh.jad_an jad_anVar = com.jd.ad.sdk.jad_uh.jad_an.jad_bo.jad_an;
        if (jad_anVar.jad_an("tbAppInstalled", true)) {
            return jad_anVar.jad_cp("tbAppInstalled");
        }
        boolean jad_an = com.jd.ad.sdk.jad_fq.jad_bo.jad_an("com.taobao.taobao");
        jad_anVar.jad_bo("tbAppInstalled", java.lang.Integer.valueOf(jad_an ? 1 : 0));
        return jad_an ? 1 : 0;
    }

    public static int jad_jt() {
        if (!com.jd.ad.sdk.jad_qd.jad_fs.jad_an.jad_an.jad_an("wcAppInstalled")) {
            return -1;
        }
        com.jd.ad.sdk.jad_uh.jad_an jad_anVar = com.jd.ad.sdk.jad_uh.jad_an.jad_bo.jad_an;
        if (jad_anVar.jad_an("wcAppInstalled", true)) {
            return jad_anVar.jad_cp("wcAppInstalled");
        }
        boolean jad_an = com.jd.ad.sdk.jad_fq.jad_bo.jad_an("com.tencent.mm");
        jad_anVar.jad_bo("wcAppInstalled", java.lang.Integer.valueOf(jad_an ? 1 : 0));
        return jad_an ? 1 : 0;
    }
}
