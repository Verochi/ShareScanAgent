package me.leolin.shortcutbadger.impl;

/* loaded from: classes16.dex */
public class OPPOHomeBader implements me.leolin.shortcutbadger.Badger {
    public static int a = -1;

    public final boolean a(java.lang.Object obj) {
        return obj == null || obj.toString().equals("") || obj.toString().trim().equals(com.igexin.push.core.b.m);
    }

    public final java.lang.Object b(java.lang.Class cls, java.lang.String str, java.lang.Class[] clsArr, java.lang.Object[] objArr) {
        java.lang.reflect.Method d;
        if (cls == null || a(str) || (d = d(cls, str, clsArr)) == null) {
            return null;
        }
        d.setAccessible(true);
        try {
            return d.invoke(null, objArr);
        } catch (java.lang.IllegalAccessException | java.lang.reflect.InvocationTargetException unused) {
            return null;
        }
    }

    public final java.lang.Class c(java.lang.String str) {
        try {
            return java.lang.Class.forName(str);
        } catch (java.lang.ClassNotFoundException unused) {
            return null;
        }
    }

    public final java.lang.reflect.Method d(java.lang.Class cls, java.lang.String str, java.lang.Class[] clsArr) {
        if (cls == null || a(str)) {
            return null;
        }
        try {
            try {
                cls.getMethods();
                cls.getDeclaredMethods();
                return cls.getDeclaredMethod(str, clsArr);
            } catch (java.lang.Exception unused) {
                if (cls.getSuperclass() != null) {
                    return d(cls.getSuperclass(), str, clsArr);
                }
                return null;
            }
        } catch (java.lang.Exception unused2) {
            return cls.getMethod(str, clsArr);
        }
    }

    public final int e() {
        int i;
        int i2 = a;
        if (i2 >= 0) {
            return i2;
        }
        try {
            i = ((java.lang.Integer) b(c("com.color.os.ColorBuild"), "getColorOSVERSION", null, null)).intValue();
        } catch (java.lang.Exception unused) {
            i = 0;
        }
        if (i == 0) {
            try {
                java.lang.String f = f("ro.build.version.opporom");
                if (f.startsWith("V1.4")) {
                    return 3;
                }
                if (f.startsWith("V2.0")) {
                    return 4;
                }
                if (f.startsWith("V2.1")) {
                    return 5;
                }
            } catch (java.lang.Exception unused2) {
            }
        }
        a = i;
        return i;
    }

    @Override // me.leolin.shortcutbadger.Badger
    @android.annotation.TargetApi(11)
    public void executeBadge(android.content.Context context, android.content.ComponentName componentName, int i) throws me.leolin.shortcutbadger.ShortcutBadgeException {
        if (i == 0) {
            i = -1;
        }
        android.content.Intent intent = new android.content.Intent("com.oppo.unsettledevent");
        intent.putExtra("pakeageName", componentName.getPackageName());
        intent.putExtra("number", i);
        intent.putExtra("upgradeNumber", i);
        if (me.leolin.shortcutbadger.util.BroadcastHelper.canResolveBroadcast(context, intent)) {
            context.sendBroadcast(intent);
        } else if (e() == 6) {
            android.os.Bundle bundle = new android.os.Bundle();
            bundle.putInt("app_badge_count", i);
            context.getContentResolver().call(android.net.Uri.parse("content://com.android.badge/badge"), "setAppBadgeCount", (java.lang.String) null, bundle);
        }
    }

    public final java.lang.String f(java.lang.String str) {
        java.io.BufferedReader bufferedReader;
        java.io.BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(java.lang.Runtime.getRuntime().exec("getprop " + str).getInputStream()), 1024);
            try {
                java.lang.String readLine = bufferedReader.readLine();
                bufferedReader.close();
                me.leolin.shortcutbadger.util.CloseHelper.closeQuietly(bufferedReader);
                return readLine;
            } catch (java.io.IOException unused) {
                me.leolin.shortcutbadger.util.CloseHelper.closeQuietly(bufferedReader);
                return null;
            } catch (java.lang.Throwable th) {
                th = th;
                bufferedReader2 = bufferedReader;
                me.leolin.shortcutbadger.util.CloseHelper.closeQuietly(bufferedReader2);
                throw th;
            }
        } catch (java.io.IOException unused2) {
            bufferedReader = null;
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
    }

    @Override // me.leolin.shortcutbadger.Badger
    public java.util.List<java.lang.String> getSupportLaunchers() {
        return java.util.Collections.singletonList("com.oppo.launcher");
    }
}
