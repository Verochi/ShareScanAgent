package com.xiaomi.push.service;

@android.annotation.TargetApi(24)
/* loaded from: classes19.dex */
final class y {
    private static com.xiaomi.push.service.y a = new com.xiaomi.push.service.y();

    public class a {
        java.util.List<com.xiaomi.push.service.y.b> a;
        java.util.List<com.xiaomi.push.service.y.b> b;

        private a() {
            this.a = new java.util.ArrayList();
            this.b = new java.util.ArrayList();
        }

        public /* synthetic */ a(com.xiaomi.push.service.y yVar, byte b) {
            this();
        }
    }

    public class b {
        int a;
        android.app.Notification b;

        public b(int i, android.app.Notification notification) {
            this.a = i;
            this.b = notification;
        }

        public final java.lang.String toString() {
            return "id:" + this.a;
        }
    }

    private y() {
    }

    private static int a(java.lang.String str, java.lang.String str2) {
        return ("GroupSummary" + str + str2).hashCode();
    }

    public static com.xiaomi.push.service.y a() {
        return a;
    }

    private static java.lang.String a(android.app.Notification notification) {
        android.os.Bundle bundle;
        if (notification == null || (bundle = notification.extras) == null) {
            return null;
        }
        return bundle.getString("push_src_group_name");
    }

    private static java.util.List<android.service.notification.StatusBarNotification> a(com.xiaomi.push.service.aa aaVar) {
        java.util.List<android.service.notification.StatusBarNotification> c = aaVar != null ? aaVar.c() : null;
        if (c == null || c.size() == 0) {
            return null;
        }
        return c;
    }

    public static void a(android.content.Context context, int i, android.app.Notification notification) {
        android.app.Notification.Builder recoverBuilder;
        java.lang.String str;
        java.lang.String d = com.xiaomi.push.service.ab.d(notification);
        if (android.text.TextUtils.isEmpty(d)) {
            str = "group restore not extract pkg from notification:".concat(java.lang.String.valueOf(i));
        } else {
            com.xiaomi.push.service.aa a2 = com.xiaomi.push.service.aa.a(context, d);
            java.util.List<android.service.notification.StatusBarNotification> a3 = a(a2);
            if (a3 != null) {
                for (android.service.notification.StatusBarNotification statusBarNotification : a3) {
                    android.app.Notification notification2 = statusBarNotification.getNotification();
                    if (notification2 != null && d(notification2) && statusBarNotification.getId() != i) {
                        recoverBuilder = android.app.Notification.Builder.recoverBuilder(context, statusBarNotification.getNotification());
                        recoverBuilder.setGroup(a(notification2));
                        com.xiaomi.push.service.ab.a(recoverBuilder, c(notification2));
                        a2.a(statusBarNotification.getId(), recoverBuilder.build());
                        com.xiaomi.channel.commonutils.logger.b.b("group restore notification:" + statusBarNotification.getId());
                    }
                }
                return;
            }
            str = "group restore not get notifications";
        }
        com.xiaomi.channel.commonutils.logger.b.a(str);
    }

    public static boolean a(android.content.Context context) {
        if (b(context) && com.xiaomi.push.service.aa.a(context)) {
            return com.xiaomi.push.service.ad.a(context).a(com.xiaomi.push.gp.LatestNotificationNotIntoGroupSwitch.bw, false);
        }
        return false;
    }

    private static java.lang.String b(android.app.Notification notification) {
        if (notification == null) {
            return null;
        }
        return d(notification) ? a(notification) : notification.getGroup();
    }

    public static boolean b() {
        return android.os.Build.VERSION.SDK_INT >= 24;
    }

    public static boolean b(android.content.Context context) {
        return com.xiaomi.push.service.ad.a(context).a(com.xiaomi.push.gp.NotificationAutoGroupSwitch.bw, true);
    }

    private static boolean c(android.app.Notification notification) {
        if (notification == null) {
            return false;
        }
        java.lang.Object a2 = com.xiaomi.push.aj.a((java.lang.Object) notification, "isGroupSummary", (java.lang.Object[]) null);
        if (a2 instanceof java.lang.Boolean) {
            return ((java.lang.Boolean) a2).booleanValue();
        }
        return false;
    }

    private static boolean d(android.app.Notification notification) {
        android.os.Bundle bundle;
        if (notification == null || notification.getGroup() == null || (bundle = notification.extras) == null) {
            return false;
        }
        return notification.getGroup().equals(java.lang.String.format("pushmask_%s_%s", java.lang.Long.valueOf(bundle.getLong("push_src_group_time")), a(notification)));
    }

    public final void b(android.content.Context context, int i, android.app.Notification notification) {
        int i2;
        java.lang.String str;
        android.app.Notification.Builder defaults;
        android.graphics.drawable.Icon createWithResource;
        android.app.Notification.Builder smallIcon;
        java.lang.String channelId;
        java.lang.String str2;
        java.lang.String d = com.xiaomi.push.service.ab.d(notification);
        if (android.text.TextUtils.isEmpty(d)) {
            str2 = "group auto not extract pkg from notification:".concat(java.lang.String.valueOf(i));
        } else {
            java.util.List<android.service.notification.StatusBarNotification> a2 = a(com.xiaomi.push.service.aa.a(context, d));
            if (a2 != null) {
                java.lang.String b2 = b(notification);
                java.util.HashMap hashMap = new java.util.HashMap();
                java.util.Iterator<android.service.notification.StatusBarNotification> it = a2.iterator();
                while (true) {
                    i2 = 0;
                    if (!it.hasNext()) {
                        break;
                    }
                    android.service.notification.StatusBarNotification next = it.next();
                    if (next.getNotification() != null && next.getId() != i) {
                        java.lang.String b3 = b(next.getNotification());
                        com.xiaomi.push.service.y.a aVar = (com.xiaomi.push.service.y.a) hashMap.get(b3);
                        if (aVar == null) {
                            aVar = new com.xiaomi.push.service.y.a(this, (byte) 0);
                            hashMap.put(b3, aVar);
                        }
                        (c(next.getNotification()) ? aVar.b : aVar.a).add(new com.xiaomi.push.service.y.b(next.getId(), next.getNotification()));
                    }
                }
                for (java.util.Map.Entry entry : hashMap.entrySet()) {
                    java.lang.String str3 = (java.lang.String) entry.getKey();
                    if (!android.text.TextUtils.isEmpty(str3)) {
                        com.xiaomi.push.service.y.a aVar2 = (com.xiaomi.push.service.y.a) entry.getValue();
                        if (str3.equals(b2) && !d(notification)) {
                            (c(notification) ? aVar2.b : aVar2.a).add(new com.xiaomi.push.service.y.b(i, notification));
                        }
                        int size = aVar2.a.size();
                        if (aVar2.b.size() <= 0) {
                            if (size >= 2) {
                                android.app.Notification notification2 = aVar2.a.get(i2).b;
                                try {
                                    if (android.text.TextUtils.isEmpty(str3)) {
                                        str = "group show summary group is null";
                                    } else {
                                        int a3 = com.xiaomi.push.service.ab.a(context, d);
                                        if (a3 == 0) {
                                            str = "group show summary not get icon from ".concat(java.lang.String.valueOf(d));
                                        } else {
                                            com.xiaomi.push.service.aa a4 = com.xiaomi.push.service.aa.a(context, d);
                                            if (android.os.Build.VERSION.SDK_INT >= 26) {
                                                channelId = notification2.getChannelId();
                                                java.lang.String b4 = com.xiaomi.push.service.aa.b(channelId, "groupSummary");
                                                android.app.NotificationChannel b5 = a4.b(b4);
                                                if ("groupSummary".equals(b4) && b5 == null) {
                                                    try {
                                                        a4.a(new android.app.NotificationChannel(b4, "group_summary", 3));
                                                    } catch (java.lang.Exception e) {
                                                        e = e;
                                                        i2 = 0;
                                                        com.xiaomi.channel.commonutils.logger.b.a("group show summary error ".concat(java.lang.String.valueOf(e)));
                                                    }
                                                }
                                                defaults = new android.app.Notification.Builder(context, b4);
                                                i2 = 0;
                                            } else {
                                                i2 = 0;
                                                defaults = new android.app.Notification.Builder(context).setPriority(0).setDefaults(-1);
                                            }
                                            com.xiaomi.push.service.ab.a(defaults, true);
                                            android.app.Notification.Builder contentText = defaults.setContentTitle("GroupSummary").setContentText("GroupSummary");
                                            createWithResource = android.graphics.drawable.Icon.createWithResource(d, a3);
                                            smallIcon = contentText.setSmallIcon(createWithResource);
                                            android.app.Notification build = smallIcon.setAutoCancel(true).setGroup(str3).setGroupSummary(true).build();
                                            if (!com.xiaomi.push.iu.d() && "com.xiaomi.xmsf".equals(context.getPackageName())) {
                                                com.xiaomi.push.service.ab.a(build, d);
                                            }
                                            int a5 = a(d, str3);
                                            a4.a(a5, build);
                                            com.xiaomi.channel.commonutils.logger.b.b("group show summary notify:".concat(java.lang.String.valueOf(a5)));
                                        }
                                    }
                                    com.xiaomi.channel.commonutils.logger.b.a(str);
                                } catch (java.lang.Exception e2) {
                                    e = e2;
                                }
                            }
                        } else if (size <= 0) {
                            com.xiaomi.channel.commonutils.logger.b.b("group cancel summary:".concat(str3));
                            com.xiaomi.push.service.aa.a(context, d).a(a(d, str3));
                        }
                    }
                }
                return;
            }
            str2 = "group auto not get notifications";
        }
        com.xiaomi.channel.commonutils.logger.b.a(str2);
    }
}
