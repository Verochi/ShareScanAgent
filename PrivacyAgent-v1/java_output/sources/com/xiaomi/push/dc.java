package com.xiaomi.push;

/* loaded from: classes19.dex */
final class dc implements com.xiaomi.push.dh {
    @Override // com.xiaomi.push.dh
    public final void a(android.content.Context context, android.content.Intent intent, java.lang.String str) {
        if (context == null || !(context instanceof android.app.Activity) || intent == null) {
            com.xiaomi.push.cz.a(context, "activity", 1008, "B receive incorrect message");
            return;
        }
        android.app.Activity activity = (android.app.Activity) context;
        java.lang.String stringExtra = intent.getStringExtra("awake_info");
        if (android.text.TextUtils.isEmpty(stringExtra)) {
            com.xiaomi.push.cz.a(activity.getApplicationContext(), "activity", 1008, "B get incorrect message");
            return;
        }
        java.lang.String b = com.xiaomi.push.cy.b(stringExtra);
        boolean isEmpty = android.text.TextUtils.isEmpty(b);
        android.content.Context applicationContext = activity.getApplicationContext();
        if (isEmpty) {
            com.xiaomi.push.cz.a(applicationContext, "activity", 1008, "B get incorrect message");
        } else {
            com.xiaomi.push.cz.a(applicationContext, b, 1007, "play with activity successfully");
        }
    }

    @Override // com.xiaomi.push.dh
    public final void a(android.content.Context context, com.xiaomi.push.dd ddVar) {
        if (ddVar == null) {
            com.xiaomi.push.cz.a(context, "activity", 1008, "A receive incorrect message");
            return;
        }
        java.lang.String str = ddVar.a;
        java.lang.String str2 = ddVar.b;
        java.lang.String str3 = ddVar.d;
        int i = ddVar.e;
        if (context == null || android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(str2) || android.text.TextUtils.isEmpty(str3)) {
            if (android.text.TextUtils.isEmpty(str3)) {
                com.xiaomi.push.cz.a(context, "activity", 1008, "argument error");
                return;
            } else {
                com.xiaomi.push.cz.a(context, str3, 1008, "argument error");
                return;
            }
        }
        if (!com.xiaomi.push.service.ch.b(context, str, str2)) {
            com.xiaomi.push.cz.a(context, str3, 1003, "B is not ready");
            return;
        }
        com.xiaomi.push.cz.a(context, str3, 1002, "B is ready");
        com.xiaomi.push.cz.a(context, str3, 1004, "A is ready");
        android.content.Intent intent = new android.content.Intent(str2);
        intent.setPackage(str);
        intent.putExtra("awake_info", com.xiaomi.push.cy.a(str3));
        intent.addFlags(276824064);
        intent.setAction(str2);
        if (i == 1) {
            try {
                if (!com.xiaomi.push.de.b(context)) {
                    com.xiaomi.push.cz.a(context, str3, 1008, "A not in foreground");
                    return;
                }
            } catch (java.lang.Exception e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
                com.xiaomi.push.cz.a(context, str3, 1008, "A meet a exception when help B's activity");
                return;
            }
        }
        context.startActivity(intent);
        com.xiaomi.push.cz.a(context, str3, 1005, "A is successful");
        com.xiaomi.push.cz.a(context, str3, 1006, "The job is finished");
    }
}
