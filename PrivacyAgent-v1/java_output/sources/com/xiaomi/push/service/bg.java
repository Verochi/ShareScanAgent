package com.xiaomi.push.service;

/* loaded from: classes19.dex */
public final class bg {
    @android.annotation.TargetApi(19)
    private static android.app.Notification a(android.app.Notification notification, int i, java.lang.String str, com.xiaomi.push.service.aa aaVar) {
        if (notification != null) {
            if (!str.equals(notification.extras.getString("message_id"))) {
                notification = null;
            }
            return notification;
        }
        java.util.List<android.service.notification.StatusBarNotification> c = aaVar.c();
        if (c == null) {
            return null;
        }
        for (android.service.notification.StatusBarNotification statusBarNotification : c) {
            android.app.Notification notification2 = statusBarNotification.getNotification();
            java.lang.String string = notification2.extras.getString("message_id");
            if (i == statusBarNotification.getId() && str.equals(string)) {
                return notification2;
            }
        }
        return null;
    }

    private static com.xiaomi.push.m.a a(android.content.Context context, java.lang.String str, int i, java.lang.String str2) {
        return new com.xiaomi.push.service.bh(i, str2, context, str);
    }

    public static java.lang.String a(int i, java.lang.String str) {
        return "n_top_update_" + i + "_" + str;
    }

    @android.annotation.TargetApi(19)
    public static void a(android.content.Context context, java.lang.String str, int i, java.lang.String str2, android.app.Notification notification) {
        com.xiaomi.push.service.aa a;
        android.app.Notification a2;
        int groupAlertBehavior;
        android.app.Notification.Builder recoverBuilder;
        if (context == null || android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(str2) || android.os.Build.VERSION.SDK_INT < 26 || (a2 = a(notification, i, str2, (a = com.xiaomi.push.service.aa.a(context, str)))) == null) {
            return;
        }
        boolean z = notification != null;
        groupAlertBehavior = a2.getGroupAlertBehavior();
        if (groupAlertBehavior != 1) {
            com.xiaomi.push.aj.a((java.lang.Object) a2, "mGroupAlertBehavior", (java.lang.Object) 1);
        }
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        long j = a2.extras.getLong("mipush_org_when", 0L);
        int i2 = a2.extras.getInt("mipush_n_top_fre", 0);
        int i3 = a2.extras.getInt("mipush_n_top_prd", 0);
        if (i3 <= 0 || i3 < i2) {
            return;
        }
        long j2 = (i3 * 1000) + j;
        int min = (j >= currentTimeMillis || currentTimeMillis >= j2) ? 0 : i2 > 0 ? (int) java.lang.Math.min((j2 - currentTimeMillis) / 1000, i2) : i3;
        if (!z) {
            if (min > 0) {
                a2.when = currentTimeMillis;
                com.xiaomi.channel.commonutils.logger.b.a("update top notification: ".concat(java.lang.String.valueOf(str2)));
                a.a(i, a2);
            } else {
                recoverBuilder = android.app.Notification.Builder.recoverBuilder(context, a2);
                recoverBuilder.setPriority(0);
                recoverBuilder.setWhen(currentTimeMillis);
                android.os.Bundle extras = recoverBuilder.getExtras();
                if (extras != null) {
                    extras.remove("mipush_n_top_flag");
                    extras.remove("mipush_org_when");
                    extras.remove("mipush_n_top_fre");
                    extras.remove("mipush_n_top_prd");
                    recoverBuilder.setExtras(extras);
                }
                com.xiaomi.channel.commonutils.logger.b.a("update top notification to common: ".concat(java.lang.String.valueOf(str2)));
                a.a(i, recoverBuilder.build());
            }
        }
        if (min > 0) {
            com.xiaomi.channel.commonutils.logger.b.a("schedule top notification next update delay: ".concat(java.lang.String.valueOf(min)));
            com.xiaomi.push.m.a(context).a(a(i, str2));
            com.xiaomi.push.m.a(context).a(a(context, str, i, str2), min);
        }
    }
}
