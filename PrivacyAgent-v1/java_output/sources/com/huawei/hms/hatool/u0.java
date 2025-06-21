package com.huawei.hms.hatool;

/* loaded from: classes22.dex */
public abstract class u0 {
    public static long a(java.lang.String str, long j) {
        try {
            java.text.SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat(str, java.util.Locale.getDefault());
            return simpleDateFormat.parse(simpleDateFormat.format(java.lang.Long.valueOf(j))).getTime();
        } catch (java.text.ParseException unused) {
            com.huawei.hms.hatool.y.f("hmsSdk/stringUtil", "getMillisOfDate(): Time conversion Exception !");
            return 0L;
        }
    }

    public static android.util.Pair<java.lang.String, java.lang.String> a(java.lang.String str) {
        java.lang.String str2;
        java.lang.String str3;
        if ("_default_config_tag".equals(str)) {
            return new android.util.Pair<>(str, "");
        }
        java.lang.String[] split = str.split(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        if (split.length > 2) {
            str3 = split[split.length - 1];
            str2 = str.substring(0, (str.length() - str3.length()) - 1);
        } else {
            str2 = split[0];
            str3 = split[1];
        }
        return new android.util.Pair<>(str2, str3);
    }

    public static java.lang.String a(int i) {
        return i != 0 ? i != 1 ? i != 2 ? i != 3 ? "alltype" : "diffprivacy" : "preins" : "maint" : "oper";
    }

    public static java.lang.String a(java.lang.String str, java.lang.String str2) {
        if ("_default_config_tag".equals(str)) {
            return str;
        }
        return str + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + str2;
    }

    public static java.lang.String a(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        if ("_default_config_tag".equals(str)) {
            return "_default_config_tag#" + str3;
        }
        return str + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + str2 + "#" + str3;
    }

    public static java.util.Set<java.lang.String> a(java.util.Set<java.lang.String> set) {
        if (set == null || set.size() == 0) {
            return new java.util.HashSet();
        }
        java.util.HashSet hashSet = new java.util.HashSet();
        for (java.lang.String str : set) {
            if ("_default_config_tag".equals(str)) {
                hashSet.add("_default_config_tag");
            } else {
                java.lang.String str2 = str + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + "oper";
                java.lang.String str3 = str + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + "maint";
                java.lang.String str4 = str + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + "diffprivacy";
                hashSet.add(str2);
                hashSet.add(str3);
                hashSet.add(str4);
            }
        }
        return hashSet;
    }
}
