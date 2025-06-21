package com.igexin.push.h;

/* loaded from: classes23.dex */
public final class o {
    public static final java.lang.String a = "us";
    public static final java.lang.String b = "ups";
    public static final java.lang.String c = "uis";
    public static final java.lang.String d = "ua";
    public static final java.lang.String e = "sc";
    public static final java.lang.String f = "it";
    public static final java.lang.String g = "logkey2";
    public static final java.lang.String h = "hwBadgeNum";
    public static final java.lang.String i = "vivoBadgeNum";
    public static final java.lang.String j = "oppoBadgeNum";
    public static java.lang.String k = "idvph";
    public static final java.lang.String l = "lkm";
    public static final java.lang.String m = "emgph";
    public static final java.lang.String n = "secnph";
    private static final java.lang.String o = "SpUtils";
    private static final java.lang.String p = "getui_sp";

    /* JADX WARN: Removed duplicated region for block: B:17:0x007f A[Catch: all -> 0x00e4, TryCatch #0 {all -> 0x00e4, blocks: (B:3:0x000a, B:49:0x002e, B:5:0x0050, B:7:0x0056, B:9:0x0064, B:11:0x006c, B:13:0x0072, B:14:0x0076, B:15:0x0079, B:17:0x007f, B:19:0x0093, B:21:0x009b, B:23:0x00a1, B:24:0x00a5, B:25:0x00a8, B:27:0x00ae, B:29:0x00c2, B:30:0x00c5, B:32:0x00cb, B:34:0x00e0), top: B:2:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00ae A[Catch: all -> 0x00e4, TryCatch #0 {all -> 0x00e4, blocks: (B:3:0x000a, B:49:0x002e, B:5:0x0050, B:7:0x0056, B:9:0x0064, B:11:0x006c, B:13:0x0072, B:14:0x0076, B:15:0x0079, B:17:0x007f, B:19:0x0093, B:21:0x009b, B:23:0x00a1, B:24:0x00a5, B:25:0x00a8, B:27:0x00ae, B:29:0x00c2, B:30:0x00c5, B:32:0x00cb, B:34:0x00e0), top: B:2:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00cb A[Catch: all -> 0x00e4, TryCatch #0 {all -> 0x00e4, blocks: (B:3:0x000a, B:49:0x002e, B:5:0x0050, B:7:0x0056, B:9:0x0064, B:11:0x006c, B:13:0x0072, B:14:0x0076, B:15:0x0079, B:17:0x007f, B:19:0x0093, B:21:0x009b, B:23:0x00a1, B:24:0x00a5, B:25:0x00a8, B:27:0x00ae, B:29:0x00c2, B:30:0x00c5, B:32:0x00cb, B:34:0x00e0), top: B:2:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:39:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0056 A[Catch: all -> 0x00e4, TryCatch #0 {all -> 0x00e4, blocks: (B:3:0x000a, B:49:0x002e, B:5:0x0050, B:7:0x0056, B:9:0x0064, B:11:0x006c, B:13:0x0072, B:14:0x0076, B:15:0x0079, B:17:0x007f, B:19:0x0093, B:21:0x009b, B:23:0x00a1, B:24:0x00a5, B:25:0x00a8, B:27:0x00ae, B:29:0x00c2, B:30:0x00c5, B:32:0x00cb, B:34:0x00e0), top: B:2:0x000a }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(android.content.Context context, android.content.Intent intent) {
        java.lang.String str;
        java.lang.Throwable th;
        try {
            java.lang.String str2 = (java.lang.String) b(context, "us", "");
            if (!android.text.TextUtils.isEmpty(str2)) {
                try {
                    if (com.igexin.sdk.PushService.class.isAssignableFrom(java.lang.Class.forName(str2))) {
                        try {
                            a(context, "us", "");
                            str2 = "";
                        } catch (java.lang.Throwable th2) {
                            th = th2;
                            str = "";
                            com.igexin.c.a.c.a.a(o, th.toString());
                            com.igexin.c.a.c.a.a("SpUtils|" + th.toString(), new java.lang.Object[0]);
                            str2 = str;
                            if (intent.hasExtra("us")) {
                            }
                            if (intent.hasExtra(b)) {
                            }
                            if (intent.hasExtra("uis")) {
                            }
                            if (intent.hasExtra("ua")) {
                            }
                        }
                    }
                } catch (java.lang.Throwable th3) {
                    str = str2;
                    th = th3;
                }
            }
            if (intent.hasExtra("us")) {
                java.lang.String b2 = com.igexin.c.b.a.b(intent.getStringExtra("us"), "");
                if (!str2.equals(b2)) {
                    if (!com.igexin.push.core.b.ao.equals(b2)) {
                        a(context, "us", b2);
                    } else if (!android.text.TextUtils.isEmpty(str2)) {
                        a(context, "us", "");
                    }
                }
            }
            if (intent.hasExtra(b)) {
                java.lang.String b3 = com.igexin.c.b.a.b(intent.getStringExtra(b), "");
                java.lang.String str3 = (java.lang.String) b(context, b, "");
                if (!str3.equals(b3)) {
                    if (!com.igexin.push.core.b.ao.equals(b3)) {
                        a(context, b, b3);
                    } else if (!android.text.TextUtils.isEmpty(str3)) {
                        a(context, b, "");
                    }
                }
            }
            if (intent.hasExtra("uis")) {
                java.lang.String str4 = (java.lang.String) b(context, "uis", "");
                java.lang.String b4 = com.igexin.c.b.a.b(intent.getStringExtra("uis"), "");
                if (!str4.equals(b4)) {
                    a(context, "uis", b4);
                }
            }
            if (intent.hasExtra("ua")) {
                return;
            }
            com.igexin.push.core.ServiceManager.getInstance();
            java.lang.String d2 = com.igexin.push.core.ServiceManager.d(context);
            java.lang.String b5 = com.igexin.c.b.a.b(intent.getStringExtra("ua"), "");
            if (d2.equals(b5)) {
                return;
            }
            a(context, "ua", b5);
        } catch (java.lang.Throwable th4) {
            com.igexin.c.a.c.a.a(th4);
        }
    }

    public static void a(android.content.Context context, java.lang.String str, java.lang.Object obj) {
        android.content.SharedPreferences.Editor edit = context.getApplicationContext().getSharedPreferences(p, 0).edit();
        if (obj instanceof java.lang.String) {
            edit.putString(str, (java.lang.String) obj);
        } else if (obj instanceof java.lang.Integer) {
            edit.putInt(str, ((java.lang.Integer) obj).intValue());
        } else if (obj instanceof java.lang.Boolean) {
            edit.putBoolean(str, ((java.lang.Boolean) obj).booleanValue());
        } else if (obj instanceof java.lang.Float) {
            edit.putFloat(str, ((java.lang.Float) obj).floatValue());
        } else if (obj instanceof java.lang.Long) {
            edit.putLong(str, ((java.lang.Long) obj).longValue());
        }
        edit.apply();
    }

    public static boolean a(android.content.Context context) {
        try {
            java.lang.String str = (java.lang.String) b(context, "us", "");
            if (android.text.TextUtils.isEmpty(str)) {
                return false;
            }
            java.lang.Class.forName(str);
            return true;
        } catch (java.lang.Exception e2) {
            com.igexin.c.a.c.a.a(o, e2.toString());
            com.igexin.c.a.c.a.a("SpUtils|" + e2.toString(), new java.lang.Object[0]);
            return false;
        }
    }

    public static java.lang.Object b(android.content.Context context, java.lang.String str, java.lang.Object obj) {
        android.content.SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(p, 0);
        return obj instanceof java.lang.String ? sharedPreferences.getString(str, (java.lang.String) obj) : obj instanceof java.lang.Integer ? java.lang.Integer.valueOf(sharedPreferences.getInt(str, ((java.lang.Integer) obj).intValue())) : obj instanceof java.lang.Boolean ? java.lang.Boolean.valueOf(sharedPreferences.getBoolean(str, ((java.lang.Boolean) obj).booleanValue())) : obj instanceof java.lang.Float ? java.lang.Float.valueOf(sharedPreferences.getFloat(str, ((java.lang.Float) obj).floatValue())) : obj instanceof java.lang.Long ? java.lang.Long.valueOf(sharedPreferences.getLong(str, ((java.lang.Long) obj).longValue())) : obj;
    }
}
