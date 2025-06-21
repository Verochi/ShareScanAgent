package com.xiaomi.push.service;

/* loaded from: classes19.dex */
public final class cj {
    public static com.xiaomi.push.hm a(com.xiaomi.push.hh hhVar) {
        byte[] a = hhVar.a();
        com.xiaomi.push.hm hmVar = new com.xiaomi.push.hm();
        try {
            com.xiaomi.push.hv.a(hmVar, a);
            return hmVar;
        } catch (com.xiaomi.push.ia unused) {
            return null;
        }
    }

    public static void a(android.content.Context context, java.lang.String str, java.lang.String str2) {
        if (context == null || android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(str2)) {
            return;
        }
        context.getSharedPreferences("mipush_apps_scrt", 0).edit().putString(str, str2).apply();
    }

    public static byte[] a(byte[] bArr, java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            com.xiaomi.channel.commonutils.logger.b.a("secret is empty, return null");
            return null;
        }
        try {
            return com.xiaomi.push.hb.b(com.xiaomi.push.al.b(str), bArr);
        } catch (java.lang.Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a("encryption error. ", e);
            return null;
        }
    }

    public static byte[] b(byte[] bArr, java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            com.xiaomi.channel.commonutils.logger.b.a("secret is empty, return null");
            return null;
        }
        try {
            return com.xiaomi.push.hb.a(com.xiaomi.push.al.b(str), bArr);
        } catch (java.lang.Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a("dencryption error. ", e);
            return null;
        }
    }
}
