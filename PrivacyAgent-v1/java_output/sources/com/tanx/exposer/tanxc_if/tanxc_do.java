package com.tanx.exposer.tanxc_if;

/* loaded from: classes19.dex */
public class tanxc_do {
    public static boolean tanxc_do;

    public static java.lang.String a(java.lang.String str, java.lang.String... strArr) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("[");
        sb.append(str);
        sb.append("] ");
        for (java.lang.String str2 : strArr) {
            if (!android.text.TextUtils.isEmpty(str2)) {
                sb.append(str2);
            }
        }
        return sb.toString();
    }

    public static void tanxc_do(java.lang.String str, java.lang.String str2) {
        if (tanxc_do) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("[");
            sb.append(str);
            sb.append("] ");
            sb.append(str2);
        }
    }

    public static void tanxc_do(java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        if (tanxc_do) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("[");
            sb.append(str);
            sb.append("] ");
            sb.append(str2);
        }
    }

    public static void tanxc_do(java.lang.String str, java.util.Map<java.lang.String, java.lang.Object> map) {
        if (tanxc_do) {
            new org.json.JSONObject(map);
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("[");
            sb.append(str);
            sb.append("] ");
            sb.append(new org.json.JSONObject(map).toString());
        }
    }

    public static void tanxc_do(java.lang.String str, java.lang.String... strArr) {
        if (tanxc_do) {
            a(str, strArr);
        }
    }

    public static void tanxc_do(boolean z) {
        tanxc_do = z;
    }
}
