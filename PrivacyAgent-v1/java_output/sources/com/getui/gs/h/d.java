package com.getui.gs.h;

/* loaded from: classes22.dex */
public final class d {
    private static final java.util.Map<java.lang.String, java.lang.String> a = new com.getui.gs.h.d.AnonymousClass1();

    /* renamed from: com.getui.gs.h.d$1, reason: invalid class name */
    public static class AnonymousClass1 extends java.util.HashMap<java.lang.String, java.lang.String> {
        public AnonymousClass1() {
            put("46000", "中国移动");
            put("46002", "中国移动");
            put("46007", "中国移动");
            put("46008", "中国移动");
            put("46001", "中国联通");
            put("46006", "中国联通");
            put("46009", "中国联通");
            put("46003", "中国电信");
            put("46005", "中国电信");
            put("46011", "中国电信");
            put("46004", "中国卫通");
            put("46020", "中国铁通");
        }
    }

    public static java.lang.String a() {
        return com.getui.gtc.base.util.CommonUtil.isAppForeground() ? "1" : "0";
    }

    public static java.lang.String a(android.content.pm.PackageItemInfo packageItemInfo, java.lang.String str) {
        if (packageItemInfo != null) {
            try {
                if (!android.text.TextUtils.isEmpty(str)) {
                    return packageItemInfo.metaData.getString(str);
                }
            } catch (java.lang.Throwable th) {
                com.getui.gs.h.b.a(th);
            }
        }
        return null;
    }

    public static <E> java.lang.String a(java.util.List<E> list, int i, int i2) {
        if (list == null || list.isEmpty()) {
            return "[]";
        }
        int max = java.lang.Math.max(i, 0);
        int min = java.lang.Math.min(i2, list.size() - 1);
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append('[');
        while (true) {
            if (max > min) {
                break;
            }
            sb.append(list.get(max));
            if (max == min) {
                sb.append(']');
                break;
            }
            sb.append(',');
            sb.append(' ');
            max++;
        }
        return sb.toString();
    }

    public static java.text.SimpleDateFormat a(java.lang.String str) {
        java.text.SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat(str, java.util.Locale.CHINA);
        simpleDateFormat.setTimeZone(java.util.TimeZone.getTimeZone("Asia/Shanghai"));
        return simpleDateFormat;
    }

    public static boolean a(android.content.Context context) {
        try {
            if (android.os.Build.VERSION.SDK_INT >= 24) {
                return ((java.lang.Boolean) android.app.NotificationManager.class.getDeclaredMethod("areNotificationsEnabled", new java.lang.Class[0]).invoke((android.app.NotificationManager) context.getSystemService(com.huawei.hms.push.constant.RemoteMessageConst.NOTIFICATION), new java.lang.Object[0])).booleanValue();
            }
            android.app.AppOpsManager appOpsManager = (android.app.AppOpsManager) context.getSystemService("appops");
            android.content.pm.ApplicationInfo applicationInfo = context.getApplicationInfo();
            java.lang.String packageName = context.getApplicationContext().getPackageName();
            int i = applicationInfo.uid;
            java.lang.Class<?> cls = java.lang.Class.forName(android.app.AppOpsManager.class.getName());
            java.lang.Class<?> cls2 = java.lang.Integer.TYPE;
            java.lang.reflect.Method method = cls.getMethod("checkOpNoThrow", cls2, cls2, java.lang.String.class);
            method.setAccessible(true);
            return ((java.lang.Integer) method.invoke(appOpsManager, java.lang.Integer.valueOf(((java.lang.Integer) cls.getDeclaredField("OP_POST_NOTIFICATION").get(java.lang.Integer.class)).intValue()), java.lang.Integer.valueOf(i), packageName)).intValue() == 0;
        } catch (java.lang.Throwable th) {
            com.getui.gs.h.b.a.a.a.w(th);
            return true;
        }
    }

    public static java.lang.String b(android.content.Context context) {
        try {
            java.lang.Object invoke = com.igexin.sdk.PushManager.class.getDeclaredMethod("getClientid", android.content.Context.class).invoke(com.igexin.sdk.PushManager.class.getDeclaredMethod("getInstance", new java.lang.Class[0]).invoke(null, new java.lang.Object[0]), context);
            return invoke != null ? (java.lang.String) invoke : "";
        } catch (java.lang.Throwable unused) {
            return "";
        }
    }
}
