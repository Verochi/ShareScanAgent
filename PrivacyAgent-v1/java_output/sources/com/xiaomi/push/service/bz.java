package com.xiaomi.push.service;

/* loaded from: classes19.dex */
public final class bz {
    private static java.util.List<com.xiaomi.push.service.bz.a> a = new java.util.concurrent.CopyOnWriteArrayList();

    public static class a {
        public final java.lang.String a;
        public final long b;
        public final int c;
        public final android.app.Notification.Action[] d;

        public a(java.lang.String str, long j, int i, android.app.Notification.Action[] actionArr) {
            this.a = str;
            this.b = j;
            this.c = i;
            this.d = actionArr;
        }
    }

    public static void a(android.content.Context context, android.service.notification.StatusBarNotification statusBarNotification, int i) {
        if (!com.xiaomi.push.iu.a(context) || i <= 0 || statusBarNotification == null) {
            return;
        }
        a.add(new com.xiaomi.push.service.bz.a(statusBarNotification.getKey(), android.os.SystemClock.elapsedRealtime(), i, com.xiaomi.push.service.ab.c(statusBarNotification.getNotification())));
        for (int size = a.size() - 1; size >= 0; size--) {
            com.xiaomi.push.service.bz.a aVar = a.get(size);
            if (android.os.SystemClock.elapsedRealtime() - aVar.b > 5000) {
                a.remove(aVar);
            }
        }
        if (a.size() > 10) {
            a.remove(0);
        }
    }
}
