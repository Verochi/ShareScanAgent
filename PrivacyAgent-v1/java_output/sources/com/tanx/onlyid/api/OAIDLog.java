package com.tanx.onlyid.api;

/* loaded from: classes19.dex */
public final class OAIDLog {
    public static boolean a;

    public static void enable(boolean z) {
        a = z;
    }

    public static void print(java.lang.Object obj) {
        if (a) {
            if (obj == null) {
                obj = "<null>";
            }
            obj.toString();
        }
    }

    public static void print(java.lang.String str, java.lang.String str2) {
        if (a) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("TanxSDK-OnlyId - ");
            sb.append(str);
        }
    }
}
