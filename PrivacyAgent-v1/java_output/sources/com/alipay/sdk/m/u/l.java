package com.alipay.sdk.m.u;

/* loaded from: classes.dex */
public class l {
    public static final java.lang.String a = "resultStatus";
    public static final java.lang.String b = "memo";
    public static final java.lang.String c = "result";

    public static java.lang.String a(java.lang.String str, java.lang.String str2) {
        try {
            java.util.regex.Matcher matcher = java.util.regex.Pattern.compile("(^|;)" + str2 + "=\\{([^}]*?)\\}").matcher(str);
            if (matcher.find()) {
                return matcher.group(2);
            }
        } catch (java.lang.Throwable th) {
            com.alipay.sdk.m.u.e.a(th);
        }
        return "?";
    }

    public static java.util.Map<java.lang.String, java.lang.String> a() {
        com.alipay.sdk.m.j.c b2 = com.alipay.sdk.m.j.c.b(com.alipay.sdk.m.j.c.CANCELED.b());
        java.util.HashMap hashMap = new java.util.HashMap();
        hashMap.put(a, java.lang.Integer.toString(b2.b()));
        hashMap.put(b, b2.a());
        hashMap.put("result", "");
        return hashMap;
    }

    public static java.util.Map<java.lang.String, java.lang.String> a(com.alipay.sdk.m.s.a aVar, java.lang.String str) {
        java.util.Map<java.lang.String, java.lang.String> a2 = a();
        try {
            return a(str);
        } catch (java.lang.Throwable th) {
            com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.q, th);
            return a2;
        }
    }

    public static java.util.Map<java.lang.String, java.lang.String> a(java.lang.String str) {
        java.lang.String[] split = str.split(com.alipay.sdk.m.u.i.b);
        java.util.HashMap hashMap = new java.util.HashMap();
        for (java.lang.String str2 : split) {
            java.lang.String substring = str2.substring(0, str2.indexOf("={"));
            hashMap.put(substring, b(str2, substring));
        }
        return hashMap;
    }

    public static java.lang.String b(java.lang.String str, java.lang.String str2) {
        java.lang.String str3 = str2 + "={";
        return str.substring(str.indexOf(str3) + str3.length(), str.lastIndexOf(com.alipay.sdk.m.u.i.d));
    }
}
