package com.google.android.gms.common.util;

@com.google.android.gms.common.annotation.KeepForSdk
/* loaded from: classes22.dex */
public class HttpUtils {
    public static final java.util.regex.Pattern a = java.util.regex.Pattern.compile("^(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}$");
    public static final java.util.regex.Pattern b = java.util.regex.Pattern.compile("^(?:[0-9a-fA-F]{1,4}:){7}[0-9a-fA-F]{1,4}$");
    public static final java.util.regex.Pattern c = java.util.regex.Pattern.compile("^((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)::((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)$");

    public static java.lang.String a(java.lang.String str, java.lang.String str2) {
        if (str2 == null) {
            str2 = "ISO-8859-1";
        }
        try {
            return java.net.URLDecoder.decode(str, str2);
        } catch (java.io.UnsupportedEncodingException e) {
            throw new java.lang.IllegalArgumentException(e);
        }
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public static java.util.Map<java.lang.String, java.lang.String> parse(@androidx.annotation.RecentlyNonNull java.net.URI uri, @androidx.annotation.RecentlyNonNull java.lang.String str) {
        java.util.Map<java.lang.String, java.lang.String> emptyMap = java.util.Collections.emptyMap();
        java.lang.String rawQuery = uri.getRawQuery();
        if (rawQuery != null && rawQuery.length() > 0) {
            emptyMap = new java.util.HashMap<>();
            java.util.Scanner scanner = new java.util.Scanner(rawQuery);
            scanner.useDelimiter("&");
            while (scanner.hasNext()) {
                java.lang.String[] split = scanner.next().split(com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER);
                if (split.length == 0 || split.length > 2) {
                    throw new java.lang.IllegalArgumentException("bad parameter");
                }
                emptyMap.put(a(split[0], str), split.length == 2 ? a(split[1], str) : null);
            }
        }
        return emptyMap;
    }
}
