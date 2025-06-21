package me.leolin.shortcutbadger;

/* loaded from: classes16.dex */
public final class ShortcutBadger {
    public static final java.util.List<java.lang.Class<? extends me.leolin.shortcutbadger.Badger>> a;
    public static volatile java.lang.Boolean b;
    public static final java.lang.Object c;
    public static me.leolin.shortcutbadger.Badger d;
    public static android.content.ComponentName e;

    static {
        java.util.LinkedList linkedList = new java.util.LinkedList();
        a = linkedList;
        c = new java.lang.Object();
        linkedList.add(me.leolin.shortcutbadger.impl.AdwHomeBadger.class);
        linkedList.add(me.leolin.shortcutbadger.impl.ApexHomeBadger.class);
        linkedList.add(me.leolin.shortcutbadger.impl.NewHtcHomeBadger.class);
        linkedList.add(me.leolin.shortcutbadger.impl.NovaHomeBadger.class);
        linkedList.add(me.leolin.shortcutbadger.impl.SonyHomeBadger.class);
        linkedList.add(me.leolin.shortcutbadger.impl.AsusHomeBadger.class);
        linkedList.add(me.leolin.shortcutbadger.impl.HuaweiHomeBadger.class);
        linkedList.add(me.leolin.shortcutbadger.impl.HonorHomeBadger.class);
        linkedList.add(me.leolin.shortcutbadger.impl.OPPOHomeBader.class);
        linkedList.add(me.leolin.shortcutbadger.impl.SamsungHomeBadger.class);
        linkedList.add(me.leolin.shortcutbadger.impl.ZukHomeBadger.class);
        linkedList.add(me.leolin.shortcutbadger.impl.VivoHomeBadger.class);
        linkedList.add(me.leolin.shortcutbadger.impl.EverythingMeHomeBadger.class);
    }

    public static boolean a(android.content.Context context) {
        android.content.pm.ActivityInfo activityInfo;
        me.leolin.shortcutbadger.Badger badger;
        android.content.Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
        if (launchIntentForPackage == null) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("Unable to find launch intent for package ");
            sb.append(context.getPackageName());
            return false;
        }
        e = launchIntentForPackage.getComponent();
        android.content.Intent intent = new android.content.Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.HOME");
        android.content.pm.ResolveInfo resolveActivity = context.getPackageManager().resolveActivity(intent, 65536);
        if (resolveActivity == null || (activityInfo = resolveActivity.activityInfo) == null || android.text.TextUtils.isEmpty(activityInfo.name) || resolveActivity.activityInfo.name.toLowerCase().contains("resolver")) {
            return false;
        }
        java.lang.String str = resolveActivity.activityInfo.packageName;
        java.util.Iterator<java.lang.Class<? extends me.leolin.shortcutbadger.Badger>> it = a.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            try {
                badger = it.next().newInstance();
            } catch (java.lang.Exception unused) {
                badger = null;
            }
            if (badger != null && badger.getSupportLaunchers().contains(str)) {
                d = badger;
                break;
            }
        }
        if (d != null) {
            return true;
        }
        java.lang.String str2 = android.os.Build.MANUFACTURER;
        if (str2.equalsIgnoreCase("ZUK")) {
            d = new me.leolin.shortcutbadger.impl.ZukHomeBadger();
            return true;
        }
        if (str2.equalsIgnoreCase(com.ss.android.download.api.constant.BaseConstants.ROM_OPPO_UPPER_CONSTANT)) {
            d = new me.leolin.shortcutbadger.impl.OPPOHomeBader();
            return true;
        }
        if (str2.equalsIgnoreCase("VIVO")) {
            d = new me.leolin.shortcutbadger.impl.VivoHomeBadger();
            return true;
        }
        d = new me.leolin.shortcutbadger.impl.DefaultBadger();
        return true;
    }

    public static boolean applyCount(android.content.Context context, int i) {
        try {
            applyCountOrThrow(context, i);
            return true;
        } catch (me.leolin.shortcutbadger.ShortcutBadgeException unused) {
            return false;
        }
    }

    public static void applyCountOrThrow(android.content.Context context, int i) throws me.leolin.shortcutbadger.ShortcutBadgeException {
        if (d == null && !a(context)) {
            throw new me.leolin.shortcutbadger.ShortcutBadgeException("No default launcher available");
        }
        try {
            d.executeBadge(context, e, i);
        } catch (java.lang.Exception e2) {
            throw new me.leolin.shortcutbadger.ShortcutBadgeException("Unable to execute badge", e2);
        }
    }

    public static void applyNotification(android.content.Context context, android.app.Notification notification, int i) {
        if (android.os.Build.MANUFACTURER.equalsIgnoreCase("Xiaomi")) {
            try {
                java.lang.Object obj = notification.getClass().getDeclaredField("extraNotification").get(notification);
                obj.getClass().getDeclaredMethod("setMessageCount", java.lang.Integer.TYPE).invoke(obj, java.lang.Integer.valueOf(i));
            } catch (java.lang.Exception unused) {
            }
        }
    }

    public static boolean isBadgeCounterSupported(android.content.Context context) {
        if (b == null) {
            synchronized (c) {
                if (b == null) {
                    java.lang.String str = null;
                    for (int i = 0; i < 3; i++) {
                        try {
                            java.lang.StringBuilder sb = new java.lang.StringBuilder();
                            sb.append("Checking if platform supports badge counters, attempt ");
                            sb.append(java.lang.String.format("%d/%d.", java.lang.Integer.valueOf(i + 1), 3));
                        } catch (java.lang.Exception e2) {
                            str = e2.getMessage();
                        }
                        if (a(context)) {
                            d.executeBadge(context, e, 0);
                            b = java.lang.Boolean.TRUE;
                            break;
                        }
                        str = "Failed to initialize the badge counter.";
                    }
                    if (b == null) {
                        java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                        sb2.append("Badge counter seems not supported for this platform: ");
                        sb2.append(str);
                        b = java.lang.Boolean.FALSE;
                    }
                }
            }
        }
        return b.booleanValue();
    }

    public static boolean removeCount(android.content.Context context) {
        return applyCount(context, 0);
    }

    public static void removeCountOrThrow(android.content.Context context) throws me.leolin.shortcutbadger.ShortcutBadgeException {
        applyCountOrThrow(context, 0);
    }
}
