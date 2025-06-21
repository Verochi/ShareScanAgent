package com.vivo.push.util;

/* loaded from: classes19.dex */
public final class j {
    private static java.lang.reflect.Method e;
    public static final boolean a = b("rom_1.0");
    public static final boolean b = b("rom_2.0");
    public static final boolean c = b("rom_2.5");
    public static final boolean d = b("rom_3.0");
    private static java.lang.String f = null;
    private static java.lang.String g = null;

    public static synchronized java.lang.String a() {
        synchronized (com.vivo.push.util.j.class) {
            if (f == null && g == null) {
                try {
                    java.lang.reflect.Method declaredMethod = java.lang.Class.forName("android.os.SystemProperties").getDeclaredMethod(com.ss.android.socialbase.downloader.constants.MonitorConstants.CONNECT_TYPE_GET, java.lang.String.class, java.lang.String.class);
                    e = declaredMethod;
                    declaredMethod.setAccessible(true);
                    f = (java.lang.String) e.invoke(null, "ro.vivo.rom", "@><@");
                    g = (java.lang.String) e.invoke(null, "ro.vivo.rom.version", "@><@");
                } catch (java.lang.Exception unused) {
                    com.vivo.push.util.p.b("Device", "getRomCode error");
                }
            }
            com.vivo.push.util.p.d("Device", "sRomProperty1 : " + f + " ; sRomProperty2 : " + g);
            java.lang.String a2 = a(f);
            if (!android.text.TextUtils.isEmpty(a2)) {
                return a2;
            }
            java.lang.String a3 = a(g);
            boolean isEmpty = android.text.TextUtils.isEmpty(a3);
            if (isEmpty) {
                return null;
            }
            return a3;
        }
    }

    private static java.lang.String a(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        java.util.regex.Matcher matcher = java.util.regex.Pattern.compile("rom_([\\d]*).?([\\d]*)", 2).matcher(str);
        if (!matcher.find()) {
            return null;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(matcher.group(1));
        sb.append(android.text.TextUtils.isEmpty(matcher.group(2)) ? "0" : matcher.group(2).substring(0, 1));
        return sb.toString();
    }

    public static java.lang.String a(java.lang.String str, java.lang.String str2) {
        java.lang.String str3;
        try {
            str3 = (java.lang.String) java.lang.Class.forName("android.os.SystemProperties").getMethod(com.ss.android.socialbase.downloader.constants.MonitorConstants.CONNECT_TYPE_GET, java.lang.String.class).invoke(null, str);
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
            str3 = str2;
        }
        return (str3 == null || str3.length() == 0) ? str2 : str3;
    }

    public static boolean b() {
        java.lang.String str = android.os.Build.MANUFACTURER;
        if (android.text.TextUtils.isEmpty(str)) {
            com.vivo.push.util.p.d("Device", "Build.MANUFACTURER is null");
            return false;
        }
        com.vivo.push.util.p.d("Device", "Build.MANUFACTURER is " + str);
        return str.toLowerCase().contains("bbk") || str.toLowerCase().startsWith(com.igexin.assist.util.AssistUtils.BRAND_VIVO);
    }

    private static boolean b(java.lang.String str) {
        java.lang.String b2 = com.vivo.push.util.z.b("ro.vivo.rom", "");
        java.lang.String b3 = com.vivo.push.util.z.b("ro.vivo.rom.version", "");
        com.vivo.push.util.p.d("Device", "ro.vivo.rom = " + b2 + " ; ro.vivo.rom.version = " + b3);
        if (b2 == null || !b2.contains(str)) {
            return b3 != null && b3.contains(str);
        }
        return true;
    }
}
