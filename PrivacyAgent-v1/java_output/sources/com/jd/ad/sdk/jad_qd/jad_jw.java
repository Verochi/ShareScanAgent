package com.jd.ad.sdk.jad_qd;

/* loaded from: classes23.dex */
public class jad_jw {
    /* JADX WARN: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static java.lang.String jad_an() {
        java.lang.String str;
        java.lang.String str2;
        try {
            com.jd.ad.sdk.jad_qd.jad_fs jad_fsVar = com.jd.ad.sdk.jad_qd.jad_fs.jad_an.jad_an;
            if (android.text.TextUtils.isEmpty(jad_fsVar.jad_bo)) {
                str = (java.lang.String) com.jd.ad.sdk.jad_uh.jad_an.jad_bo.jad_an.jad_an("didCustom", java.lang.String.class);
                if (!android.text.TextUtils.isEmpty(str)) {
                    jad_fsVar.jad_bo = str;
                    return android.text.TextUtils.isEmpty(str) ? str : "";
                }
                str2 = "";
            } else {
                str2 = jad_fsVar.jad_bo;
            }
            str = str2;
            if (android.text.TextUtils.isEmpty(str)) {
            }
        } catch (java.lang.Exception unused) {
            return "";
        }
    }

    public static java.lang.String jad_an(android.content.Context context) {
        java.lang.String str = "";
        if (!com.jd.ad.sdk.jad_qd.jad_fs.jad_an.jad_an.jad_an(com.bytedance.sdk.openadsdk.live.TTLiveConstants.BUNDLE_KEY)) {
            return "";
        }
        com.jd.ad.sdk.jad_uh.jad_an jad_anVar = com.jd.ad.sdk.jad_uh.jad_an.jad_bo.jad_an;
        if (jad_anVar.jad_an(com.bytedance.sdk.openadsdk.live.TTLiveConstants.BUNDLE_KEY, true)) {
            str = jad_anVar.jad_dq(com.bytedance.sdk.openadsdk.live.TTLiveConstants.BUNDLE_KEY);
        } else if (context != null) {
            str = context.getPackageName();
            jad_anVar.jad_bo(com.bytedance.sdk.openadsdk.live.TTLiveConstants.BUNDLE_KEY, str);
        }
        return str;
    }

    public static java.lang.String jad_bo() {
        try {
            com.jd.ad.sdk.jad_qd.jad_fs jad_fsVar = com.jd.ad.sdk.jad_qd.jad_fs.jad_an.jad_an;
            if (!jad_fsVar.jad_an("oidCustom")) {
                return "";
            }
            java.lang.String jad_bo = jad_fsVar.jad_bo();
            try {
                if (android.text.TextUtils.isEmpty(jad_bo)) {
                    return "";
                }
            } catch (java.lang.Exception unused) {
            }
            return jad_bo;
        } catch (java.lang.Exception unused2) {
            return "";
        }
    }

    public static java.lang.String jad_bo(android.content.Context context) {
        java.lang.String str = "";
        if (!com.jd.ad.sdk.jad_qd.jad_fs.jad_an.jad_an.jad_an(com.umeng.analytics.pro.bo.P)) {
            return "";
        }
        com.jd.ad.sdk.jad_uh.jad_an jad_anVar = com.jd.ad.sdk.jad_uh.jad_an.jad_bo.jad_an;
        if (jad_anVar.jad_an(com.umeng.analytics.pro.bo.P, true)) {
            str = (java.lang.String) jad_anVar.jad_bo(com.umeng.analytics.pro.bo.P);
        } else if (context != null) {
            str = com.jd.ad.sdk.jad_fq.jad_hu.jad_an(context);
            jad_anVar.jad_bo(com.umeng.analytics.pro.bo.P, str);
        }
        return str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0054, code lost:
    
        r1 = r3.processName;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static java.lang.String jad_cp(android.content.Context context) {
        java.lang.String str = "";
        try {
            if (!com.jd.ad.sdk.jad_qd.jad_fs.jad_an.jad_an.jad_an("processName")) {
                return "jad_process_default";
            }
            if (!com.jd.ad.sdk.bl.initsdk.JADYunSdk.isSupportMultiProcess()) {
                return jad_an(context);
            }
            com.jd.ad.sdk.jad_uh.jad_an jad_anVar = com.jd.ad.sdk.jad_uh.jad_an.jad_bo.jad_an;
            if (jad_anVar.jad_an("processName", true)) {
                return jad_anVar.jad_dq("processName");
            }
            if (context == null) {
                return "";
            }
            try {
                int myPid = android.os.Process.myPid();
                java.util.List<android.app.ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((android.app.ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
                if (runningAppProcesses != null) {
                    java.util.Iterator<android.app.ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        android.app.ActivityManager.RunningAppProcessInfo next = it.next();
                        if (next != null && next.pid == myPid) {
                            break;
                        }
                    }
                }
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
            if (android.text.TextUtils.isEmpty(str)) {
                return str;
            }
            com.jd.ad.sdk.jad_uh.jad_an.jad_bo.jad_an.jad_bo("processName", str);
            return str;
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static boolean jad_dq(android.content.Context context) {
        if (!com.jd.ad.sdk.jad_qd.jad_fs.jad_an.jad_an.jad_an("processName") || !com.jd.ad.sdk.bl.initsdk.JADYunSdk.isSupportMultiProcess()) {
            return true;
        }
        java.lang.String jad_cp = jad_cp(context);
        java.lang.String jad_an = jad_an(context);
        if (android.text.TextUtils.isEmpty(jad_an)) {
            jad_an = context.getPackageName();
        }
        if (!android.text.TextUtils.isEmpty(jad_an) && !android.text.TextUtils.isEmpty(jad_cp)) {
            if (!jad_an.equals(jad_cp)) {
                return false;
            }
        }
        return true;
    }
}
