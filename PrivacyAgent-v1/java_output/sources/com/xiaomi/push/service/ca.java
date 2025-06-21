package com.xiaomi.push.service;

/* loaded from: classes19.dex */
class ca {
    private static final int[] a = {1, 2, 4, 8, 16};
    private static final android.util.SparseArray<com.xiaomi.push.service.ab.a<java.lang.String, java.lang.String, java.lang.String>> b = new com.xiaomi.push.service.cb();
    private static final android.util.SparseArray<java.lang.Integer> c = new com.xiaomi.push.service.cc();

    public static int a(java.lang.String str, java.lang.String str2) {
        int i = a(str, str2, 8) ? 8 : 0;
        if (a(str, str2, 16)) {
            i |= 16;
        }
        if (a(str, str2, 1)) {
            i |= 1;
        }
        if (a(str, str2, 2)) {
            i |= 2;
        }
        return a(str, str2, 4) ? i | 4 : i;
    }

    public static void a(android.content.Context context, java.lang.String str) {
        java.util.List<android.app.NotificationChannel> b2;
        if (!com.xiaomi.push.iu.a(context) || android.text.TextUtils.isEmpty(str) || (b2 = com.xiaomi.push.service.aa.a(context, str).b()) == null) {
            return;
        }
        synchronized (com.xiaomi.push.service.ca.class) {
            android.content.SharedPreferences sharedPreferences = context.getSharedPreferences("ch_permission_cache_file", 0);
            java.util.ArrayList arrayList = new java.util.ArrayList();
            java.util.Iterator<android.app.NotificationChannel> it = b2.iterator();
            while (it.hasNext()) {
                java.lang.String str2 = (java.lang.String) com.xiaomi.push.aj.a(it.next(), "mId");
                if (!android.text.TextUtils.isEmpty(str2) && sharedPreferences.contains(str2)) {
                    arrayList.add(str2);
                }
            }
            if (arrayList.size() > 0) {
                a(sharedPreferences, arrayList);
            }
        }
    }

    public static void a(android.content.Context context, java.lang.String str, java.lang.String str2, int i, java.lang.String str3, boolean z, int i2) {
        if (!com.xiaomi.push.iu.a(context) || android.text.TextUtils.isEmpty(str3) || android.text.TextUtils.isEmpty(str2) || android.text.TextUtils.isEmpty(str)) {
            if (com.xiaomi.push.iu.a(context)) {
                com.xiaomi.channel.commonutils.logger.b.a("ChannelPC: can`t setup permission with permissionCode:" + java.lang.String.valueOf(str3) + " channelId:" + java.lang.String.valueOf(str2) + " targetPkg:" + str);
                return;
            }
            return;
        }
        int a2 = com.xiaomi.push.jd.a(str3, 0);
        boolean z2 = i >= 4 || (a2 & 2) > 0 || (a2 & 1) > 0 || (a2 & 8) > 0 || (a2 & 16) > 0;
        if (z) {
            a(str, str2, a2, i2);
            if (z2) {
                synchronized (com.xiaomi.push.service.ca.class) {
                    a(context.getSharedPreferences("ch_permission_cache_file", 0), a2, str2);
                }
                return;
            }
            return;
        }
        synchronized (com.xiaomi.push.service.ca.class) {
            android.content.SharedPreferences sharedPreferences = context.getSharedPreferences("ch_permission_cache_file", 0);
            if (z2 || sharedPreferences.contains(str2)) {
                if (sharedPreferences.getInt(str2, 0) != a2) {
                    a(str, str2, a2, i2);
                }
                if (z2) {
                    a(sharedPreferences, a2, str2);
                } else {
                    a(sharedPreferences, new com.xiaomi.push.service.cd(str2));
                }
            }
        }
    }

    private static void a(android.content.SharedPreferences sharedPreferences, int i, java.lang.String str) {
        sharedPreferences.edit().putInt(str, i).commit();
    }

    private static void a(android.content.SharedPreferences sharedPreferences, java.util.List<java.lang.String> list) {
        android.content.SharedPreferences.Editor edit = sharedPreferences.edit();
        java.util.Iterator<java.lang.String> it = list.iterator();
        while (it.hasNext()) {
            edit.remove(it.next());
        }
        edit.commit();
    }

    public static void a(java.lang.String str, java.lang.String str2, int i, int i2) {
        for (int i3 : a) {
            if ((c.get(i3).intValue() & i2) == 0) {
                a(str, str2, i3, (i & i3) > 0);
            } else {
                com.xiaomi.channel.commonutils.logger.b.a("ChannelPermissions.grantPermission:" + str + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + str2 + ": <" + i3 + "> :stoped by userLock");
            }
        }
    }

    private static void a(java.lang.String str, java.lang.String str2, int i, boolean z) {
        com.xiaomi.channel.commonutils.logger.b.a("ChannelPermissions.grantPermission:" + str + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + str2 + ": <" + i + com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER + z + "> :" + com.xiaomi.push.service.ab.a(com.xiaomi.push.jc.a(), str, str2, b.get(i), z));
    }

    private static boolean a(java.lang.String str, java.lang.String str2, int i) {
        boolean z = com.xiaomi.push.service.ab.a(com.xiaomi.push.jc.a(), str, str2, b.get(i)) == 1;
        com.xiaomi.channel.commonutils.logger.b.a("ChannelPermissions.checkPermission:" + str + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + str2 + ": <" + i + com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER + z + ">");
        return z;
    }
}
