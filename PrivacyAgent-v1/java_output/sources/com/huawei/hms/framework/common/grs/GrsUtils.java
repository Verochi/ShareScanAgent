package com.huawei.hms.framework.common.grs;

/* loaded from: classes22.dex */
public class GrsUtils {
    private static final int GRS_KEY_INDEX = 1;
    private static final int GRS_PATH_INDEX = 2;
    private static final java.lang.String GRS_SCHEMA = "grs://";
    private static final int GRS_SERVICE_INDEX = 0;
    private static final int MAX_GRS_SPLIT = 3;
    private static final java.lang.String SEPARATOR = "/";

    public static java.lang.String fixResult(java.lang.String[] strArr, java.lang.String str) {
        if (strArr.length <= 2) {
            return str;
        }
        if (str.endsWith("/")) {
            return str + strArr[2];
        }
        return str + "/" + strArr[2];
    }

    public static boolean isGRSSchema(java.lang.String str) {
        return str != null && str.startsWith(GRS_SCHEMA);
    }

    public static java.lang.String[] parseGRSSchema(java.lang.String str) {
        java.lang.String[] split = com.huawei.hms.framework.common.StringUtils.substring(str, str.toLowerCase(java.util.Locale.ENGLISH).indexOf(GRS_SCHEMA) + 6).split("/", 3);
        return split.length == 1 ? new java.lang.String[]{split[0], "ROOT"} : split;
    }

    public static java.lang.String[] parseParams(java.lang.String str) {
        if (str.endsWith("/")) {
            str = com.huawei.hms.framework.common.StringUtils.substring(str, str.indexOf(GRS_SCHEMA), str.length() - 1);
        }
        return parseGRSSchema(str);
    }
}
