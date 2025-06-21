package com.xiaomi.push;

/* loaded from: classes19.dex */
public final class iu {
    private static volatile int a = 0;
    private static int b = -1;
    private static java.util.Map<java.lang.String, com.xiaomi.push.iy> c;

    public static java.lang.String a(android.content.Intent intent) {
        if (intent == null) {
            return null;
        }
        return intent.toString() + " " + a(intent.getExtras());
    }

    private static java.lang.String a(android.os.Bundle bundle) {
        java.lang.String a2;
        java.lang.StringBuilder sb = new java.lang.StringBuilder("Bundle[");
        if (bundle == null) {
            sb.append(com.igexin.push.core.b.m);
        } else {
            boolean z = true;
            for (java.lang.String str : bundle.keySet()) {
                if (!z) {
                    sb.append(", ");
                }
                sb.append(str);
                sb.append(com.alipay.sdk.m.n.a.h);
                java.lang.Object obj = bundle.get(str);
                if (obj instanceof int[]) {
                    a2 = java.util.Arrays.toString((int[]) obj);
                } else if (obj instanceof byte[]) {
                    a2 = java.util.Arrays.toString((byte[]) obj);
                } else if (obj instanceof boolean[]) {
                    a2 = java.util.Arrays.toString((boolean[]) obj);
                } else if (obj instanceof short[]) {
                    a2 = java.util.Arrays.toString((short[]) obj);
                } else if (obj instanceof long[]) {
                    a2 = java.util.Arrays.toString((long[]) obj);
                } else if (obj instanceof float[]) {
                    a2 = java.util.Arrays.toString((float[]) obj);
                } else if (obj instanceof double[]) {
                    a2 = java.util.Arrays.toString((double[]) obj);
                } else if (obj instanceof java.lang.String[]) {
                    a2 = java.util.Arrays.toString((java.lang.String[]) obj);
                } else if (obj instanceof java.lang.CharSequence[]) {
                    a2 = java.util.Arrays.toString((java.lang.CharSequence[]) obj);
                } else if (obj instanceof android.os.Parcelable[]) {
                    a2 = java.util.Arrays.toString((android.os.Parcelable[]) obj);
                } else if (obj instanceof android.os.Bundle) {
                    a2 = a((android.os.Bundle) obj);
                } else {
                    sb.append(obj);
                    z = false;
                }
                sb.append(a2);
                z = false;
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public static java.lang.String a(java.lang.String str) {
        try {
            try {
                return (java.lang.String) com.xiaomi.push.aj.a("android.os.SystemProperties", com.ss.android.socialbase.downloader.constants.MonitorConstants.CONNECT_TYPE_GET, str, "");
            } catch (java.lang.Exception e) {
                com.xiaomi.channel.commonutils.logger.b.d("fail to get property. ".concat(java.lang.String.valueOf(e)));
                return null;
            }
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }

    public static boolean a() {
        return k() == 1;
    }

    public static boolean a(android.content.Context context) {
        return context != null && "com.xiaomi.xmsf".equals(context.getPackageName());
    }

    public static int b(android.content.Context context) {
        try {
            return context.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 0).versionCode;
        } catch (java.lang.Exception unused) {
            return 0;
        }
    }

    public static com.xiaomi.push.iy b(java.lang.String str) {
        if (c == null) {
            java.util.HashMap hashMap = new java.util.HashMap();
            c = hashMap;
            hashMap.put("CN", com.xiaomi.push.iy.China);
            java.util.Map<java.lang.String, com.xiaomi.push.iy> map = c;
            com.xiaomi.push.iy iyVar = com.xiaomi.push.iy.Europe;
            map.put("FI", iyVar);
            c.put("SE", iyVar);
            c.put("NO", iyVar);
            c.put("FO", iyVar);
            c.put("EE", iyVar);
            c.put("LV", iyVar);
            c.put("LT", iyVar);
            c.put("BY", iyVar);
            c.put("MD", iyVar);
            c.put("UA", iyVar);
            c.put("PL", iyVar);
            c.put("CZ", iyVar);
            c.put("SK", iyVar);
            c.put("HU", iyVar);
            c.put("DE", iyVar);
            c.put("AT", iyVar);
            c.put("CH", iyVar);
            c.put("LI", iyVar);
            c.put("GB", iyVar);
            c.put("IE", iyVar);
            c.put("NL", iyVar);
            c.put("BE", iyVar);
            c.put("LU", iyVar);
            c.put("FR", iyVar);
            c.put("RO", iyVar);
            c.put("BG", iyVar);
            c.put("RS", iyVar);
            c.put("MK", iyVar);
            c.put("AL", iyVar);
            c.put("GR", iyVar);
            c.put("SI", iyVar);
            c.put("HR", iyVar);
            c.put("IT", iyVar);
            c.put("SM", iyVar);
            c.put("MT", iyVar);
            c.put("ES", iyVar);
            c.put(com.igexin.assist.sdk.AssistPushConsts.MSG_VALUE_PAYLOAD, iyVar);
            c.put("AD", iyVar);
            c.put("CY", iyVar);
            c.put("DK", iyVar);
            c.put("IS", iyVar);
            c.put("UK", iyVar);
            c.put("EL", iyVar);
            c.put("RU", com.xiaomi.push.iy.Russia);
            c.put(com.anythink.core.api.ATCountryCode.INDIA, com.xiaomi.push.iy.India);
        }
        com.xiaomi.push.iy iyVar2 = c.get(str.toUpperCase());
        return iyVar2 == null ? com.xiaomi.push.iy.Global : iyVar2;
    }

    public static boolean b() {
        return k() == 2;
    }

    public static java.lang.String c() {
        int b2 = com.xiaomi.push.jc.b();
        return (!a() || b2 <= 0) ? "" : b2 < 2 ? "alpha" : b2 < 3 ? "development" : "stable";
    }

    public static boolean d() {
        if (b < 0) {
            b = !l() ? 1 : 0;
        }
        return b > 0;
    }

    public static java.lang.String e() {
        java.lang.String a2 = com.xiaomi.push.jb.a("ro.miui.region", "");
        if (android.text.TextUtils.isEmpty(a2)) {
            a2 = com.xiaomi.push.jb.a("persist.sys.oppo.region", "");
        }
        if (android.text.TextUtils.isEmpty(a2)) {
            a2 = com.xiaomi.push.jb.a("ro.oppo.regionmark", "");
        }
        if (android.text.TextUtils.isEmpty(a2)) {
            a2 = com.xiaomi.push.jb.a("ro.vendor.oplus.regionmark", "");
        }
        if (android.text.TextUtils.isEmpty(a2)) {
            a2 = com.xiaomi.push.jb.a("ro.hw.country", "");
        }
        if (android.text.TextUtils.isEmpty(a2)) {
            a2 = com.xiaomi.push.jb.a("ro.csc.countryiso_code", "");
        }
        if (android.text.TextUtils.isEmpty(a2)) {
            a2 = com.xiaomi.push.jb.a("ro.product.country.region", "");
            if (!android.text.TextUtils.isEmpty(a2)) {
                java.lang.String[] split = a2.split(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                if (split.length > 0) {
                    a2 = split[0];
                }
            }
        }
        if (android.text.TextUtils.isEmpty(a2)) {
            a2 = com.xiaomi.push.jb.a("gsm.vivo.countrycode", "");
        }
        if (android.text.TextUtils.isEmpty(a2)) {
            a2 = com.xiaomi.push.jb.a("persist.sys.oem.region", "");
        }
        if (android.text.TextUtils.isEmpty(a2)) {
            a2 = com.xiaomi.push.jb.a("ro.product.locale.region", "");
        }
        if (android.text.TextUtils.isEmpty(a2)) {
            a2 = com.xiaomi.push.jb.a("persist.sys.country", "");
        }
        if (!android.text.TextUtils.isEmpty(a2)) {
            com.xiaomi.channel.commonutils.logger.b.a("get region from system, region = ".concat(java.lang.String.valueOf(a2)));
        }
        if (!android.text.TextUtils.isEmpty(a2)) {
            return a2;
        }
        java.lang.String country = java.util.Locale.getDefault().getCountry();
        com.xiaomi.channel.commonutils.logger.b.a("locale.default.country = ".concat(java.lang.String.valueOf(country)));
        return country;
    }

    public static boolean f() {
        return !com.xiaomi.push.iy.China.name().equalsIgnoreCase(b(e()).name());
    }

    public static int g() {
        java.lang.String a2 = a(com.igexin.assist.control.xiaomi.XmSystemUtils.KEY_VERSION_CODE);
        if (android.text.TextUtils.isEmpty(a2) || !android.text.TextUtils.isDigitsOnly(a2)) {
            return 0;
        }
        return java.lang.Integer.parseInt(a2);
    }

    public static java.lang.String h() {
        return a(com.igexin.assist.control.xiaomi.XmSystemUtils.KEY_VERSION_MIUI);
    }

    public static java.lang.String i() {
        return a("ro.build.characteristics");
    }

    public static java.lang.String j() {
        return a("ro.product.manufacturer");
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static int k() {
        int i;
        boolean z;
        if (a == 0) {
            try {
                i = 1;
            } catch (java.lang.Throwable th) {
                com.xiaomi.channel.commonutils.logger.b.a("get isMIUI failed", th);
                a = 0;
            }
            if (android.text.TextUtils.isEmpty(a(com.igexin.assist.control.xiaomi.XmSystemUtils.KEY_VERSION_CODE)) && android.text.TextUtils.isEmpty(a(com.igexin.assist.control.xiaomi.XmSystemUtils.KEY_VERSION_MIUI))) {
                z = false;
                if (z) {
                    i = 2;
                }
                a = i;
                com.xiaomi.channel.commonutils.logger.b.b("isMIUI's value is: " + a);
            }
            z = true;
            if (z) {
            }
            a = i;
            com.xiaomi.channel.commonutils.logger.b.b("isMIUI's value is: " + a);
        }
        return a;
    }

    private static boolean l() {
        java.lang.String str = "";
        try {
            str = com.xiaomi.push.jb.a(com.igexin.assist.control.xiaomi.XmSystemUtils.KEY_VERSION_CODE, "");
        } catch (java.lang.Exception unused) {
        }
        return !android.text.TextUtils.isEmpty(str);
    }
}
