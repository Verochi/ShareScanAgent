package com.getui.gtc.extension.distribution.gbd.d;

/* loaded from: classes22.dex */
public final class i {
    public static java.lang.String a = null;
    public static java.lang.String b = null;
    private static java.lang.String c = "HZ";

    public static java.lang.String a() {
        a = android.text.TextUtils.isEmpty(a) ? "https://c-hzgt2.getui.com/api.php" : a;
        return a + "?format=json&t=1";
    }

    private static void a(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        com.getui.gtc.extension.distribution.gbd.d.c.b = str;
        c = str;
    }

    public static java.lang.String b() {
        b = android.text.TextUtils.isEmpty(b) ? "https://sdk-open-phone.getui.com/api.php" : b;
        java.lang.String country = java.util.Locale.getDefault().getCountry();
        if (!country.equalsIgnoreCase("CN")) {
            b = country.equalsIgnoreCase("TH") ? gtc.gbd.a.k : gtc.gbd.a.j;
        }
        return b + "?format=json&t=1";
    }

    public static java.lang.String c() {
        return c;
    }
}
