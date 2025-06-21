package com.meizu.cloud.pushsdk.notification.c;

/* loaded from: classes23.dex */
public class b {
    private static java.lang.reflect.Field a;
    private static java.lang.reflect.Field b;
    private static java.lang.reflect.Field c;
    private static final java.lang.Object d = new java.lang.Object();
    private static final java.util.Map<java.lang.String, java.util.Set<java.lang.String>> e = new java.util.concurrent.ConcurrentHashMap();
    private static java.util.Map<java.lang.String, android.net.Uri> f;

    static {
        try {
            a = android.app.Notification.class.getDeclaredField("mFlymeNotification");
            java.lang.reflect.Field declaredField = java.lang.Class.forName("android.app.NotificationExt").getDeclaredField("internalApp");
            b = declaredField;
            declaredField.setAccessible(true);
            java.lang.reflect.Field declaredField2 = android.app.Notification.class.getDeclaredField("replyIntent");
            c = declaredField2;
            declaredField2.setAccessible(true);
        } catch (java.lang.ClassNotFoundException e2) {
            e2.printStackTrace();
        } catch (java.lang.NoSuchFieldException e3) {
            com.meizu.cloud.pushinternal.DebugLogger.e("NotificationUtils", "init NotificationUtils error " + e3.getMessage());
        }
    }

    public static void a(android.app.Notification notification, android.app.PendingIntent pendingIntent) {
        java.lang.reflect.Field field = c;
        if (field != null) {
            try {
                field.set(notification, pendingIntent);
            } catch (java.lang.IllegalAccessException e2) {
                com.meizu.cloud.pushinternal.DebugLogger.e("NotificationUtils", "setReplyIntent error " + e2.getMessage());
            }
        }
    }

    public static void a(android.app.Notification notification, boolean z) {
        java.lang.reflect.Field field = a;
        if (field == null || b == null) {
            return;
        }
        try {
            b.set(field.get(notification), java.lang.Integer.valueOf(z ? 1 : 0));
        } catch (java.lang.IllegalAccessException e2) {
            com.meizu.cloud.pushinternal.DebugLogger.e("NotificationUtils", "setInternalApp error " + e2.getMessage());
        }
    }

    public static void a(android.content.Context context) {
        android.app.NotificationManager notificationManager = (android.app.NotificationManager) context.getSystemService(com.huawei.hms.push.constant.RemoteMessageConst.NOTIFICATION);
        if (notificationManager != null) {
            notificationManager.cancelAll();
        }
    }

    public static void a(android.content.Context context, java.lang.String str) {
        java.util.Set<java.lang.String> set;
        android.app.NotificationManager notificationManager = (android.app.NotificationManager) context.getSystemService(com.huawei.hms.push.constant.RemoteMessageConst.NOTIFICATION);
        if (notificationManager == null || android.text.TextUtils.isEmpty(str) || (set = e.get(str)) == null) {
            return;
        }
        for (java.lang.String str2 : set) {
            com.meizu.cloud.pushinternal.DebugLogger.i("NotificationUtils", "clear notifyId " + str2 + " notification");
            notificationManager.cancel(java.lang.Integer.parseInt(str2));
        }
        set.clear();
    }

    public static void a(android.content.Context context, java.lang.String str, int i) {
        android.app.NotificationManager notificationManager = (android.app.NotificationManager) context.getSystemService(com.huawei.hms.push.constant.RemoteMessageConst.NOTIFICATION);
        if (notificationManager != null) {
            com.meizu.cloud.pushinternal.DebugLogger.i("NotificationUtils", "clear clearNotification notifyId " + i);
            notificationManager.cancel(i);
            java.util.Set<java.lang.String> set = e.get(str);
            if (set != null) {
                set.remove(java.lang.String.valueOf(i));
            }
        }
    }

    public static boolean a(android.content.Context context, java.lang.String str, java.lang.String str2) {
        synchronized (d) {
            if (android.text.TextUtils.isEmpty(str2)) {
                return false;
            }
            int i = com.meizu.cloud.pushsdk.util.b.i(context, str, str2);
            com.meizu.cloud.pushinternal.DebugLogger.e("NotificationUtils", "removeNotifyKey " + str2 + " notifyId " + i);
            c(context, str, i);
            return com.meizu.cloud.pushsdk.util.b.j(context, str, str2);
        }
    }

    public static android.net.Uri b(android.content.Context context, java.lang.String str) {
        if (context == null || android.text.TextUtils.isEmpty(str) || android.media.RingtoneManager.getActualDefaultRingtoneUri(context, 2) == null) {
            return null;
        }
        if (f == null) {
            b(context);
        }
        java.util.Map<java.lang.String, android.net.Uri> map = f;
        if (map != null && map.size() != 0) {
            return f.get(str.toLowerCase());
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x007e, code lost:
    
        if (0 == 0) goto L31;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static synchronized void b(android.content.Context context) {
        synchronized (com.meizu.cloud.pushsdk.notification.c.b.class) {
            if (f != null) {
                return;
            }
            android.database.Cursor cursor = null;
            try {
                try {
                    android.media.RingtoneManager ringtoneManager = new android.media.RingtoneManager(context);
                    ringtoneManager.setType(2);
                    cursor = ringtoneManager.getCursor();
                } catch (java.lang.Exception e2) {
                    com.meizu.cloud.pushinternal.DebugLogger.e("NotificationUtils", "get ringtone info error, " + e2.getMessage());
                }
                if (cursor == null) {
                    return;
                }
                f = new java.util.HashMap(cursor.getCount());
                for (boolean moveToFirst = cursor.moveToFirst(); moveToFirst; moveToFirst = cursor.moveToNext()) {
                    java.lang.String string = cursor.getString(1);
                    android.net.Uri withAppendedId = android.content.ContentUris.withAppendedId(android.net.Uri.parse(cursor.getString(2)), cursor.getLong(0));
                    if (!android.text.TextUtils.isEmpty(string) && withAppendedId != null) {
                        f.put(string.toLowerCase(), withAppendedId);
                    }
                }
                cursor.close();
            } finally {
                if (0 != 0) {
                    cursor.close();
                }
            }
        }
    }

    public static void b(android.content.Context context, java.lang.String str, int i) {
        java.util.Map<java.lang.String, java.util.Set<java.lang.String>> map = e;
        java.util.Set<java.lang.String> set = map.get(str);
        com.meizu.cloud.pushinternal.DebugLogger.i("NotificationUtils", "store notifyId " + i);
        if (set != null) {
            set.add(java.lang.String.valueOf(i));
            return;
        }
        java.util.HashSet hashSet = new java.util.HashSet();
        hashSet.add(java.lang.String.valueOf(i));
        map.put(str, hashSet);
    }

    public static void c(android.content.Context context, java.lang.String str, int i) {
        java.util.Set<java.lang.String> set = e.get(str);
        if (set != null) {
            set.remove(java.lang.String.valueOf(i));
            com.meizu.cloud.pushinternal.DebugLogger.i("NotificationUtils", "remove notifyId " + i);
        }
    }
}
