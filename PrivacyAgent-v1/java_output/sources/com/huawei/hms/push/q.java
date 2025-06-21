package com.huawei.hms.push;

/* loaded from: classes22.dex */
public class q {
    public static int a() {
        return d() ? 603979776 : 536870912;
    }

    public static long a(java.lang.String str) {
        if (str == null) {
            str = "";
        }
        try {
            java.util.Date date = new java.util.Date();
            int hours = (date.getHours() * 2) + (date.getMinutes() / 30);
            java.lang.String concat = str.concat(str);
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("startIndex is ");
            sb.append(hours);
            sb.append(",ap is:");
            sb.append(concat);
            sb.append(",length is:");
            sb.append(concat.length());
            com.huawei.hms.support.log.HMSLog.i("PushSelfShowLog", sb.toString());
            int length = concat.length();
            for (int i = hours; i < length; i++) {
                if (concat.charAt(i) != '0') {
                    long minutes = (((i - hours) * 30) - (date.getMinutes() % 30)) * 60000;
                    java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                    sb2.append("startIndex is:");
                    sb2.append(hours);
                    sb2.append(" i is:");
                    sb2.append(i);
                    sb2.append(" delay:");
                    sb2.append(minutes);
                    com.huawei.hms.support.log.HMSLog.d("PushSelfShowLog", sb2.toString());
                    if (minutes >= 0) {
                        return minutes;
                    }
                    return 0L;
                }
            }
        } catch (java.lang.Exception e) {
            com.huawei.hms.support.log.HMSLog.e("PushSelfShowLog", "error ", e);
        }
        return 0L;
    }

    public static java.lang.Boolean a(android.content.Context context, java.lang.String str, android.content.Intent intent) {
        try {
            java.util.List<android.content.pm.ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
            if (queryIntentActivities != null && queryIntentActivities.size() > 0) {
                int size = queryIntentActivities.size();
                for (int i = 0; i < size; i++) {
                    if (queryIntentActivities.get(i).activityInfo != null && str.equals(queryIntentActivities.get(i).activityInfo.applicationInfo.packageName)) {
                        return java.lang.Boolean.TRUE;
                    }
                }
            }
        } catch (java.lang.Exception e) {
            com.huawei.hms.support.log.HMSLog.e("PushSelfShowLog", e.toString(), e);
        }
        return java.lang.Boolean.FALSE;
    }

    public static java.lang.String a(android.content.Context context, java.lang.String str) {
        try {
            android.content.pm.PackageManager packageManager = context.getPackageManager();
            return packageManager.getApplicationLabel(packageManager.getApplicationInfo(str, 128)).toString();
        } catch (android.content.pm.PackageManager.NameNotFoundException unused) {
            com.huawei.hms.support.log.HMSLog.i("PushSelfShowLog", "get the app name of package:" + str + " failed.");
            return null;
        }
    }

    public static void a(android.content.Context context, int i) {
        if (context == null) {
            com.huawei.hms.support.log.HMSLog.e("PushSelfShowLog", com.anythink.expressad.foundation.g.b.b.a);
            return;
        }
        try {
            android.app.NotificationManager notificationManager = (android.app.NotificationManager) context.getSystemService(com.huawei.hms.push.constant.RemoteMessageConst.NOTIFICATION);
            if (notificationManager != null) {
                notificationManager.cancel(i);
            }
        } catch (java.lang.Exception e) {
            com.huawei.hms.support.log.HMSLog.e("PushSelfShowLog", "removeNotifiCationById err:" + e.toString());
        }
    }

    public static void a(android.content.Context context, android.content.Intent intent) {
        try {
            int intExtra = intent.getIntExtra("selfshow_auto_clear_id", 0);
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("setDelayAlarm(cancel) alarmNotityId ");
            sb.append(intExtra);
            com.huawei.hms.support.log.HMSLog.d("PushSelfShowLog", sb.toString());
            if (intExtra == 0) {
                return;
            }
            android.content.Intent intent2 = new android.content.Intent("com.huawei.intent.action.PUSH_DELAY_NOTIFY");
            intent2.setPackage(context.getPackageName()).setFlags(32);
            android.app.AlarmManager alarmManager = (android.app.AlarmManager) context.getSystemService(androidx.core.app.NotificationCompat.CATEGORY_ALARM);
            android.app.PendingIntent broadcast = android.app.PendingIntent.getBroadcast(context, intExtra, intent2, a());
            if (broadcast == null || alarmManager == null) {
                com.huawei.hms.support.log.HMSLog.d("PushSelfShowLog", "alarm not exist");
            } else {
                com.huawei.hms.support.log.HMSLog.d("PushSelfShowLog", "alarm cancel");
                alarmManager.cancel(broadcast);
            }
        } catch (java.lang.Exception e) {
            com.huawei.hms.support.log.HMSLog.e("PushSelfShowLog", "cancelAlarm err:" + e.toString());
        }
    }

    public static void a(android.content.Context context, android.content.Intent intent, long j) {
        try {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("enter setAPDelayAlarm(interval:");
            sb.append(j);
            sb.append("ms.");
            com.huawei.hms.support.log.HMSLog.d("PushSelfShowLog", sb.toString());
            android.app.AlarmManager alarmManager = (android.app.AlarmManager) context.getSystemService(androidx.core.app.NotificationCompat.CATEGORY_ALARM);
            if (alarmManager != null) {
                alarmManager.set(0, java.lang.System.currentTimeMillis() + j, android.app.PendingIntent.getBroadcast(context, (int) (java.lang.System.currentTimeMillis() / 1000), intent, b()));
            }
        } catch (java.lang.Exception e) {
            com.huawei.hms.support.log.HMSLog.w("PushSelfShowLog", "set DelayAlarm error" + e.toString());
        }
    }

    public static boolean a(android.content.Context context) {
        return "com.huawei.hwid".equals(context.getPackageName());
    }

    public static int b() {
        return c() ? 67108864 : 134217728;
    }

    public static android.content.Intent b(android.content.Context context, java.lang.String str) {
        try {
            return context.getPackageManager().getLaunchIntentForPackage(str);
        } catch (java.lang.Exception unused) {
            com.huawei.hms.support.log.HMSLog.w("PushSelfShowLog", str + " not have launch activity");
            return null;
        }
    }

    public static boolean c() {
        return android.os.Build.VERSION.SDK_INT >= 23;
    }

    public static boolean c(android.content.Context context, java.lang.String str) {
        if (context != null && str != null && !"".equals(str)) {
            try {
                if (context.getPackageManager().getApplicationInfo(str, 8192) == null) {
                    return false;
                }
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append(str);
                sb.append(" is installed");
                com.huawei.hms.support.log.HMSLog.d("PushSelfShowLog", sb.toString());
                return true;
            } catch (java.lang.Exception unused) {
            }
        }
        return false;
    }

    public static boolean d() {
        return android.os.Build.VERSION.SDK_INT >= 30;
    }

    public static boolean e() {
        return true;
    }
}
