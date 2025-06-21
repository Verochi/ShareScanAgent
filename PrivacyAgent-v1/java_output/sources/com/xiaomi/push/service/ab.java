package com.xiaomi.push.service;

/* loaded from: classes19.dex */
public final class ab {
    private static final java.lang.String[] g = {"com.mi.globalbrowser", "com.android.browser"};
    private static java.lang.String h = null;
    public static final com.xiaomi.push.service.ab.a<java.lang.String, java.lang.String, java.lang.String> a = new com.xiaomi.push.service.ab.a<>("setSound", "canSound", "canSound", (byte) 0);
    public static final com.xiaomi.push.service.ab.a<java.lang.String, java.lang.String, java.lang.String> b = new com.xiaomi.push.service.ab.a<>("setVibrate", "canVibrate", "canVibrate", (byte) 0);
    public static final com.xiaomi.push.service.ab.a<java.lang.String, java.lang.String, java.lang.String> c = new com.xiaomi.push.service.ab.a<>("setLights", "canLights", "canLights", (byte) 0);
    public static final com.xiaomi.push.service.ab.a<java.lang.String, java.lang.String, java.lang.String> d = new com.xiaomi.push.service.ab.a<>("setShowOnKeyguard", "canShowOnKeyguard", "canShowOnKeyguard", (byte) 0);
    public static final com.xiaomi.push.service.ab.a<java.lang.String, java.lang.String, java.lang.String> e = new com.xiaomi.push.service.ab.a<>("setFloat", "canFloat", "canShowFloat", (byte) 0);
    public static final com.xiaomi.push.service.ab.a<java.lang.String, java.lang.String, java.lang.String> f = new com.xiaomi.push.service.ab.a<>("setShowBadge", "canShowBadge", "canShowBadge", (byte) 0);

    public static class a<F, S, T> {
        F a;
        S b;
        T c;

        private a(F f, S s2, T t) {
            this.a = f;
            this.b = s2;
            this.c = t;
        }

        public /* synthetic */ a(java.lang.Object obj, java.lang.Object obj2, java.lang.Object obj3, byte b) {
            this(obj, obj2, obj3);
        }
    }

    public static int a(android.content.Context context, java.lang.String str) {
        return com.xiaomi.push.ga.f(context, str);
    }

    public static int a(android.content.Context context, java.lang.String str, java.lang.String str2, com.xiaomi.push.service.ab.a<java.lang.String, java.lang.String, java.lang.String> aVar) {
        if (aVar == null) {
            return -1;
        }
        try {
            android.os.Bundle a2 = a(context, aVar.b, str, str2, (android.os.Bundle) null);
            if (a2 == null || !a2.containsKey(aVar.c)) {
                return -1;
            }
            return a2.getBoolean(aVar.c) ? 1 : 0;
        } catch (java.lang.Exception unused) {
            return -1;
        }
    }

    private static android.os.Bundle a(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3, android.os.Bundle bundle) {
        if (context == null || android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(str2)) {
            throw new java.lang.IllegalArgumentException("call notification provider failed!");
        }
        android.os.Bundle bundle2 = new android.os.Bundle();
        bundle2.putString("package", str2);
        if (!android.text.TextUtils.isEmpty(str3)) {
            bundle2.putString("channel_id", str3);
        }
        if (bundle != null) {
            bundle2.putAll(bundle);
        }
        return context.getContentResolver().call(android.net.Uri.parse("content://statusbar.notification"), str, (java.lang.String) null, bundle2);
    }

    public static <T> T a(java.lang.Object obj, java.lang.String str, T t) {
        T t2;
        try {
        } catch (java.lang.Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.a("get value error ".concat(java.lang.String.valueOf(e2)));
        }
        if (obj instanceof android.app.Notification) {
            t2 = (T) b((android.app.Notification) obj, str);
        } else if (obj instanceof java.util.Map) {
            t2 = (T) ((java.util.Map) obj).get(str);
        } else if (obj instanceof android.os.Bundle) {
            t2 = (T) ((android.os.Bundle) obj).get(str);
        } else {
            com.xiaomi.channel.commonutils.logger.b.a("not support get value from classType:".concat(java.lang.String.valueOf(obj)));
            t2 = null;
        }
        return t2 == null ? t : t2;
    }

    public static java.lang.String a(android.app.Notification notification) {
        java.lang.CharSequence charSequence;
        android.os.Bundle bundle = notification.extras;
        if (bundle != null) {
            charSequence = bundle.getCharSequence(androidx.core.app.NotificationCompat.EXTRA_TITLE);
            if (android.text.TextUtils.isEmpty(charSequence)) {
                charSequence = notification.extras.getCharSequence(androidx.core.app.NotificationCompat.EXTRA_TITLE_BIG);
            }
            if (android.text.TextUtils.isEmpty(charSequence)) {
                charSequence = notification.extras.getCharSequence("mipush.customTitle");
            }
        } else {
            charSequence = null;
        }
        return charSequence != null ? charSequence.toString() : "";
    }

    public static java.lang.String a(java.lang.Object obj) {
        return (java.lang.String) a(obj, "msg_busi_type", "");
    }

    public static void a(android.app.Notification notification, int i) {
        try {
            android.os.Bundle bundle = notification.extras;
            if (bundle != null) {
                bundle.putInt("miui.messageCount", i);
            }
            java.lang.Object a2 = com.xiaomi.push.aj.a(notification, "extraNotification");
            if (a2 != null) {
                com.xiaomi.push.aj.a(a2, "setMessageCount", java.lang.Integer.valueOf(i));
            }
        } catch (java.lang.Exception unused) {
        }
    }

    public static void a(android.app.Notification notification, int i, int i2) {
        if (notification != null) {
            if (notification.extras == null) {
                notification.extras = new android.os.Bundle();
            }
            notification.extras.putInt("is_priority", i);
            notification.extras.putInt("mipush_class", i2);
        }
    }

    public static void a(android.app.Notification notification, java.lang.String str) {
        try {
            android.os.Bundle bundle = notification.extras;
            if (bundle != null) {
                bundle.putString(com.huawei.hms.support.hianalytics.HiAnalyticsConstant.BI_KEY_TARGET_PACKAGE, str);
            }
            java.lang.Object a2 = com.xiaomi.push.aj.a(notification, "extraNotification");
            if (a2 != null) {
                com.xiaomi.push.aj.a(a2, "setTargetPkg", str);
            }
        } catch (java.lang.Exception unused) {
        }
    }

    public static void a(android.app.Notification notification, boolean z) {
        try {
            android.os.Bundle bundle = notification.extras;
            if (bundle != null) {
                bundle.putBoolean("miui.enableFloat", z);
            }
            java.lang.Object a2 = com.xiaomi.push.aj.a(notification, "extraNotification");
            if (a2 != null) {
                com.xiaomi.push.aj.a(a2, "setEnableFloat", java.lang.Boolean.valueOf(z));
            }
        } catch (java.lang.Exception unused) {
        }
    }

    public static void a(android.content.Context context, java.lang.String str, android.content.Intent intent) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (!android.text.TextUtils.isEmpty(str)) {
            arrayList.add(str);
        }
        arrayList.addAll(java.util.Arrays.asList(g));
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            java.lang.String str2 = (java.lang.String) arrayList.get(i);
            if (!android.text.TextUtils.isEmpty(str2)) {
                android.content.Intent intent2 = new android.content.Intent(intent);
                intent2.setPackage(str2);
                try {
                    if (context.getPackageManager().resolveActivity(intent2, 65536) != null) {
                        intent.setPackage(str2);
                        break;
                    }
                    continue;
                } catch (java.lang.Exception e2) {
                    com.xiaomi.channel.commonutils.logger.b.a("can't match url intent. ".concat(java.lang.String.valueOf(e2)));
                }
            }
        }
        intent.setPackage(intent.getPackage());
    }

    public static void a(java.util.Map<java.lang.String, java.lang.String> map, android.os.Bundle bundle, java.lang.String str) {
        if (map == null || bundle == null || android.text.TextUtils.isEmpty(str)) {
            com.xiaomi.channel.commonutils.logger.b.a("cp map to b fail:".concat(java.lang.String.valueOf(str)));
        } else if (android.text.TextUtils.isEmpty(map.get(str))) {
            bundle.remove(str);
        } else {
            bundle.putString(str, map.get(str));
        }
    }

    public static boolean a(android.app.Notification.Builder builder, boolean z) {
        if (android.os.Build.VERSION.SDK_INT >= 26) {
            builder.setGroupAlertBehavior(z ? 2 : 1);
            return true;
        }
        com.xiaomi.channel.commonutils.logger.b.b("not support setGroupAlertBehavior");
        return false;
    }

    public static boolean a(android.content.ContentResolver contentResolver) {
        int b2 = b(contentResolver);
        return b2 == 1 || b2 == 2;
    }

    public static boolean a(android.content.Context context, java.lang.String str, java.lang.String str2, com.xiaomi.push.service.ab.a<java.lang.String, java.lang.String, java.lang.String> aVar, boolean z) {
        if (aVar != null) {
            try {
                android.os.Bundle bundle = new android.os.Bundle();
                bundle.putBoolean(aVar.c, z);
                a(context, aVar.a, str, str2, bundle);
                return true;
            } catch (java.lang.Exception unused) {
            }
        }
        return false;
    }

    public static boolean a(java.util.Map<java.lang.String, java.lang.String> map) {
        return java.lang.Boolean.parseBoolean((java.lang.String) a(map, "not_suppress", com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_TRUE));
    }

    private static int b(android.content.ContentResolver contentResolver) {
        try {
            return android.provider.Settings.Global.getInt(contentResolver, "user_aggregate", 0);
        } catch (java.lang.Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.a("get user aggregate failed, ".concat(java.lang.String.valueOf(e2)));
            return 0;
        }
    }

    private static <T> T b(android.app.Notification notification, java.lang.String str) {
        android.os.Bundle bundle = notification.extras;
        if (bundle == null) {
            return null;
        }
        try {
            return (T) bundle.get(str);
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    public static java.lang.String b(android.app.Notification notification) {
        java.lang.CharSequence charSequence;
        android.os.Bundle bundle = notification.extras;
        if (bundle != null) {
            charSequence = bundle.getCharSequence(androidx.core.app.NotificationCompat.EXTRA_TEXT);
            if (android.text.TextUtils.isEmpty(charSequence)) {
                charSequence = notification.extras.getCharSequence(androidx.core.app.NotificationCompat.EXTRA_BIG_TEXT);
            }
            if (android.text.TextUtils.isEmpty(charSequence)) {
                charSequence = notification.extras.getCharSequence("mipush.customContent");
            }
        } else {
            charSequence = null;
        }
        return charSequence != null ? charSequence.toString() : "";
    }

    public static void b(android.app.Notification notification, boolean z) {
        try {
            android.os.Bundle bundle = notification.extras;
            if (bundle != null) {
                bundle.putBoolean("miui.enableKeyguard", z);
            }
            java.lang.Object a2 = com.xiaomi.push.aj.a(notification, "extraNotification");
            if (a2 != null) {
                com.xiaomi.push.aj.a(a2, "setEnableKeyguard", java.lang.Boolean.valueOf(z));
            }
        } catch (java.lang.Exception unused) {
        }
    }

    public static android.app.Notification.Action[] c(android.app.Notification notification) {
        android.os.Parcelable[] parcelableArray;
        android.app.Notification.Action[] actionArr = notification.actions;
        if (actionArr != null) {
            return actionArr;
        }
        android.os.Bundle bundle = notification.extras;
        if (bundle == null || (parcelableArray = bundle.getParcelableArray("mipush.customActions")) == null) {
            return null;
        }
        return (android.app.Notification.Action[]) java.util.Arrays.copyOf(parcelableArray, parcelableArray.length, android.app.Notification.Action[].class);
    }

    public static java.lang.String d(android.app.Notification notification) {
        java.lang.Object a2;
        try {
            android.os.Bundle bundle = notification.extras;
            r0 = bundle != null ? bundle.getString(com.huawei.hms.support.hianalytics.HiAnalyticsConstant.BI_KEY_TARGET_PACKAGE) : null;
            return (!android.text.TextUtils.isEmpty(r0) || (a2 = com.xiaomi.push.aj.a(notification, "extraNotification")) == null) ? r0 : (java.lang.String) com.xiaomi.push.aj.a(a2, "getTargetPkg", new java.lang.Object[0]);
        } catch (java.lang.Exception unused) {
            return r0;
        }
    }
}
