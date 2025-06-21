package com.xiaomi.push;

/* loaded from: classes19.dex */
final class dk implements com.xiaomi.push.dh {
    @Override // com.xiaomi.push.dh
    public final void a(android.content.Context context, android.content.Intent intent, java.lang.String str) {
        if (context == null || !(context instanceof android.app.Service)) {
            com.xiaomi.push.cz.a(context, "service", 1008, "A receive incorrect message");
            return;
        }
        android.app.Service service = (android.app.Service) context;
        java.lang.String stringExtra = intent.getStringExtra("awake_info");
        if (android.text.TextUtils.isEmpty(stringExtra)) {
            com.xiaomi.push.cz.a(service.getApplicationContext(), "service", 1008, "B get a incorrect message");
            return;
        }
        java.lang.String b = com.xiaomi.push.cy.b(stringExtra);
        boolean isEmpty = android.text.TextUtils.isEmpty(b);
        android.content.Context applicationContext = service.getApplicationContext();
        if (isEmpty) {
            com.xiaomi.push.cz.a(applicationContext, "service", 1008, "B get a incorrect message");
        } else {
            com.xiaomi.push.cz.a(applicationContext, b, 1007, "play with service successfully");
        }
    }

    @Override // com.xiaomi.push.dh
    public final void a(android.content.Context context, com.xiaomi.push.dd ddVar) {
        if (ddVar == null) {
            com.xiaomi.push.cz.a(context, "service", 1008, "A receive incorrect message");
            return;
        }
        java.lang.String str = ddVar.a;
        java.lang.String str2 = ddVar.b;
        java.lang.String str3 = ddVar.d;
        int i = ddVar.e;
        if (context == null || android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(str2) || android.text.TextUtils.isEmpty(str3)) {
            if (android.text.TextUtils.isEmpty(str3)) {
                com.xiaomi.push.cz.a(context, "service", 1008, "argument error");
                return;
            } else {
                com.xiaomi.push.cz.a(context, str3, 1008, "argument error");
                return;
            }
        }
        if (!com.xiaomi.push.service.ch.a(context, str, str2)) {
            com.xiaomi.push.cz.a(context, str3, 1003, "B is not ready");
            return;
        }
        com.xiaomi.push.cz.a(context, str3, 1002, "B is ready");
        com.xiaomi.push.cz.a(context, str3, 1004, "A is ready");
        try {
            android.content.Intent intent = new android.content.Intent();
            intent.setAction(str2);
            intent.setPackage(str);
            intent.putExtra("awake_info", com.xiaomi.push.cy.a(str3));
            if (i == 1 && !com.xiaomi.push.de.b(context)) {
                com.xiaomi.push.cz.a(context, str3, 1008, "A not in foreground");
            } else if (context.startService(intent) == null) {
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
