package com.xiaomi.push;

/* loaded from: classes19.dex */
final class dj implements com.xiaomi.push.dh {
    @Override // com.xiaomi.push.dh
    public final void a(android.content.Context context, android.content.Intent intent, java.lang.String str) {
        try {
            if (android.text.TextUtils.isEmpty(str) || context == null) {
                com.xiaomi.push.cz.a(context, com.umeng.analytics.pro.f.M, 1008, "B get a incorrect message");
                return;
            }
            java.lang.String[] split = str.split(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR);
            if (split.length <= 0 || android.text.TextUtils.isEmpty(split[split.length - 1])) {
                com.xiaomi.push.cz.a(context, com.umeng.analytics.pro.f.M, 1008, "B get a incorrect message");
                return;
            }
            java.lang.String str2 = split[split.length - 1];
            if (android.text.TextUtils.isEmpty(str2)) {
                com.xiaomi.push.cz.a(context, com.umeng.analytics.pro.f.M, 1008, "B get a incorrect message");
                return;
            }
            java.lang.String decode = android.net.Uri.decode(str2);
            if (android.text.TextUtils.isEmpty(decode)) {
                com.xiaomi.push.cz.a(context, com.umeng.analytics.pro.f.M, 1008, "B get a incorrect message");
                return;
            }
            java.lang.String b = com.xiaomi.push.cy.b(decode);
            if (android.text.TextUtils.isEmpty(b)) {
                com.xiaomi.push.cz.a(context, com.umeng.analytics.pro.f.M, 1008, "B get a incorrect message");
            } else {
                com.xiaomi.push.cz.a(context, b, 1007, "play with provider successfully");
            }
        } catch (java.lang.Exception e) {
            com.xiaomi.push.cz.a(context, com.umeng.analytics.pro.f.M, 1008, "B meet a exception" + e.getMessage());
        }
    }

    @Override // com.xiaomi.push.dh
    public final void a(android.content.Context context, com.xiaomi.push.dd ddVar) {
        if (ddVar == null) {
            com.xiaomi.push.cz.a(context, com.umeng.analytics.pro.f.M, 1008, "A receive incorrect message");
            return;
        }
        java.lang.String str = ddVar.b;
        java.lang.String str2 = ddVar.d;
        int i = ddVar.e;
        if (context == null || android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(str2)) {
            if (android.text.TextUtils.isEmpty(str2)) {
                com.xiaomi.push.cz.a(context, com.umeng.analytics.pro.f.M, 1008, "argument error");
                return;
            } else {
                com.xiaomi.push.cz.a(context, str2, 1008, "argument error");
                return;
            }
        }
        if (!com.xiaomi.push.service.ch.b(context, str)) {
            com.xiaomi.push.cz.a(context, str2, 1003, "B is not ready");
            return;
        }
        com.xiaomi.push.cz.a(context, str2, 1002, "B is ready");
        com.xiaomi.push.cz.a(context, str2, 1004, "A is ready");
        java.lang.String a = com.xiaomi.push.cy.a(str2);
        try {
            if (android.text.TextUtils.isEmpty(a)) {
                com.xiaomi.push.cz.a(context, str2, 1008, "info is empty");
                return;
            }
            if (i == 1 && !com.xiaomi.push.de.b(context)) {
                com.xiaomi.push.cz.a(context, str2, 1008, "A not in foreground");
                return;
            }
            java.lang.String type = context.getContentResolver().getType(android.net.Uri.parse("content://".concat(java.lang.String.valueOf(str))).buildUpon().appendPath(a).build());
            if (android.text.TextUtils.isEmpty(type) || !"success".equals(type)) {
                com.xiaomi.push.cz.a(context, str2, 1008, "A is fail to help B's provider");
            } else {
                com.xiaomi.push.cz.a(context, str2, 1005, "A is successful");
                com.xiaomi.push.cz.a(context, str2, 1006, "The job is finished");
            }
        } catch (java.lang.Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            com.xiaomi.push.cz.a(context, str2, 1008, "A meet a exception when help B's provider");
        }
    }
}
