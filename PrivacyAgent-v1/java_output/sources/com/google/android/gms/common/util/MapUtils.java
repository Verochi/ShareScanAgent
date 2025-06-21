package com.google.android.gms.common.util;

@com.google.android.gms.common.annotation.KeepForSdk
/* loaded from: classes22.dex */
public class MapUtils {
    @com.google.android.gms.common.annotation.KeepForSdk
    public static void writeStringMapToJson(@androidx.annotation.RecentlyNonNull java.lang.StringBuilder sb, @androidx.annotation.RecentlyNonNull java.util.HashMap<java.lang.String, java.lang.String> hashMap) {
        sb.append("{");
        boolean z = true;
        for (java.lang.String str : hashMap.keySet()) {
            if (z) {
                z = false;
            } else {
                sb.append(",");
            }
            java.lang.String str2 = hashMap.get(str);
            sb.append("\"");
            sb.append(str);
            sb.append("\":");
            if (str2 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append("\"");
                sb.append(str2);
                sb.append("\"");
            }
        }
        sb.append(com.alipay.sdk.m.u.i.d);
    }
}
