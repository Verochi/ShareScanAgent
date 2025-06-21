package com.ss.android.downloadlib.bt;

/* loaded from: classes19.dex */
public class es {
    private static java.util.Map<java.lang.String, com.ss.android.downloadlib.bt.es.vw> vw = java.util.Collections.synchronizedMap(new java.util.HashMap());

    public interface vw {
        void vw();

        void vw(java.lang.String str);
    }

    private static com.ss.android.downloadlib.bt.es.vw t(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        return vw.remove(str);
    }

    public static void vw(java.lang.String str) {
        com.ss.android.downloadlib.bt.es.vw t;
        if (android.text.TextUtils.isEmpty(str) || (t = t(str)) == null) {
            return;
        }
        t.vw();
    }

    private static void vw(java.lang.String str, com.ss.android.downloadlib.bt.es.vw vwVar) {
        if (android.text.TextUtils.isEmpty(str) || vwVar == null) {
            return;
        }
        vw.put(str, vwVar);
    }

    public static void vw(java.lang.String str, java.lang.String str2) {
        com.ss.android.downloadlib.bt.es.vw t;
        if (android.text.TextUtils.isEmpty(str) || (t = t(str)) == null) {
            return;
        }
        t.vw(str2);
    }

    public static void vw(java.lang.String[] strArr, com.ss.android.downloadlib.bt.es.vw vwVar) {
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        java.lang.String valueOf = java.lang.String.valueOf(java.lang.System.currentTimeMillis());
        vw(valueOf, vwVar);
        com.ss.android.downloadlib.activity.TTDelegateActivity.vw(valueOf, strArr);
    }

    public static boolean wg(java.lang.String str) {
        return com.ss.android.downloadlib.addownload.z.yl().vw(com.ss.android.downloadlib.addownload.z.getContext(), str);
    }
}
