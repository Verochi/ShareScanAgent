package com.aliyun.common.utils;

/* loaded from: classes.dex */
public class UriUtil {
    public static final java.lang.String ASSETS = "assets";
    public static final java.lang.String FILE = "file";
    public static final java.lang.String MULI_SPLIT = ",";
    public static final java.lang.String PROVIDER = "content";
    public static final java.lang.String QUERY_CATEGORY = "category";
    public static final java.lang.String QUERY_ID = "id";
    public static final java.lang.String QUERY_TYPE = "type";
    public static final java.lang.String QUPAI_ASSETS = "qupai-assets";

    public static java.lang.String formatAssetURI(int i, int i2) {
        return java.lang.String.format("%s://?type=%d&id=%d", "qupai-assets", java.lang.Integer.valueOf(i), java.lang.Integer.valueOf(i2));
    }

    public static java.lang.String formatProvideURI(int[] iArr, java.lang.String str) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (int i : iArr) {
            sb.append(i);
            sb.append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        return java.lang.String.format("%s://%s?category=%s", "content", str, sb.toString());
    }

    public static boolean getQueryB(android.net.Uri uri, java.lang.String str, boolean z) {
        java.lang.String queryParameter = uri.getQueryParameter(str);
        if (queryParameter == null) {
            return z;
        }
        try {
            return java.lang.Boolean.parseBoolean(queryParameter);
        } catch (java.lang.Throwable unused) {
            return z;
        }
    }

    public static <E extends java.lang.Enum<E>> E getQueryE(android.net.Uri uri, java.lang.String str, E e) {
        if (uri.getQueryParameter(str) == null) {
            return e;
        }
        try {
            return (E) java.lang.Enum.valueOf(e.getDeclaringClass(), str);
        } catch (java.lang.Throwable unused) {
            return e;
        }
    }

    public static int getQueryI(android.net.Uri uri, java.lang.String str, int i) {
        java.lang.String queryParameter = uri.getQueryParameter(str);
        if (queryParameter == null) {
            return i;
        }
        try {
            return java.lang.Integer.parseInt(queryParameter);
        } catch (java.lang.Throwable unused) {
            return i;
        }
    }

    public static int[] getQueryIA(android.net.Uri uri) {
        java.lang.String queryParameter = uri.getQueryParameter("category");
        if (queryParameter == null) {
            return null;
        }
        java.lang.String[] split = queryParameter.split(",");
        int[] iArr = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            iArr[i] = java.lang.Integer.parseInt(split[i]);
        }
        return iArr;
    }

    public static long getQueryL(android.net.Uri uri, java.lang.String str, long j) {
        java.lang.String queryParameter = uri.getQueryParameter(str);
        if (queryParameter == null) {
            return j;
        }
        try {
            return java.lang.Long.parseLong(queryParameter);
        } catch (java.lang.Throwable unused) {
            return j;
        }
    }
}
