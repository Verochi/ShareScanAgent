package com.vivo.push.util;

/* loaded from: classes19.dex */
public final class e {
    public static boolean a(long j, java.util.HashMap<java.lang.String, java.lang.String> hashMap) {
        com.vivo.push.b.x xVar = new com.vivo.push.b.x(j);
        xVar.a(hashMap);
        xVar.d();
        com.vivo.push.e.a().a(xVar);
        return true;
    }

    public static boolean a(android.content.Context context, long j, long j2) {
        com.vivo.push.util.p.d("ClientReportUtil", "report message: " + j + ", reportType: " + j2);
        com.vivo.push.b.x xVar = new com.vivo.push.b.x(j2);
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        hashMap.put(com.heytap.mcssdk.constant.b.c, java.lang.String.valueOf(j));
        java.lang.String b = com.vivo.push.util.z.b(context, context.getPackageName());
        if (!android.text.TextUtils.isEmpty(b)) {
            hashMap.put("remoteAppId", b);
        }
        xVar.a(hashMap);
        com.vivo.push.e.a().a(xVar);
        return true;
    }
}
