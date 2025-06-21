package com.xiaomi.push;

/* loaded from: classes19.dex */
final class dl implements com.xiaomi.push.dh {
    @Override // com.xiaomi.push.dh
    public final void a(android.content.Context context, android.content.Intent intent, java.lang.String str) {
        if (context == null || !(context instanceof android.app.Service)) {
            return;
        }
        android.app.Service service = (android.app.Service) context;
        if ("com.xiaomi.mipush.sdk.WAKEUP".equals(intent.getAction())) {
            java.lang.String stringExtra = intent.getStringExtra("waker_pkgname");
            java.lang.String stringExtra2 = intent.getStringExtra("awake_info");
            if (android.text.TextUtils.isEmpty(stringExtra)) {
                com.xiaomi.push.cz.a(service.getApplicationContext(), "service", 1007, "old version message");
                return;
            }
            if (android.text.TextUtils.isEmpty(stringExtra2)) {
                com.xiaomi.push.cz.a(service.getApplicationContext(), stringExtra, 1007, "play with service ");
                return;
            }
            java.lang.String b = com.xiaomi.push.cy.b(stringExtra2);
            boolean isEmpty = android.text.TextUtils.isEmpty(b);
            android.content.Context applicationContext = service.getApplicationContext();
            if (isEmpty) {
                com.xiaomi.push.cz.a(applicationContext, "service", 1008, "B get a incorrect message");
            } else {
                com.xiaomi.push.cz.a(applicationContext, b, 1007, "old version message ");
            }
        }
    }

    @Override // com.xiaomi.push.dh
    public final void a(android.content.Context context, com.xiaomi.push.dd ddVar) {
        if (ddVar != null) {
            java.lang.String str = ddVar.a;
            java.lang.String str2 = ddVar.c;
            java.lang.String str3 = ddVar.d;
            if (context == null || android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(str2)) {
                if (android.text.TextUtils.isEmpty(str3)) {
                    com.xiaomi.push.cz.a(context, "service", 1008, "argument error");
                    return;
                } else {
                    com.xiaomi.push.cz.a(context, str3, 1008, "argument error");
                    return;
                }
            }
            if (!com.xiaomi.push.service.ch.a(context, str)) {
                com.xiaomi.push.cz.a(context, str3, 1003, "B is not ready");
                return;
            }
            com.xiaomi.push.cz.a(context, str3, 1002, "B is ready");
            com.xiaomi.push.cz.a(context, str3, 1004, "A is ready");
            try {
                android.content.Intent intent = new android.content.Intent();
                intent.setClassName(str, str2);
                intent.setAction("com.xiaomi.mipush.sdk.WAKEUP");
                intent.putExtra("waker_pkgname", context.getPackageName());
                intent.putExtra("awake_info", com.xiaomi.push.cy.a(str3));
                if (context.startService(intent) == null) {
                    com.xiaomi.push.cz.a(context, str3, 1008, "A is fail to help B's service");
                } else {
                    com.xiaomi.push.cz.a(context, str3, 1005, "A is successful");
                    com.xiaomi.push.cz.a(context, str3, 1006, "The job is finished");
                }
            } catch (java.lang.Exception e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
                com.xiaomi.push.cz.a(context, str3, 1008, "A meet a exception when help B's service");
            }
        }
    }
}
