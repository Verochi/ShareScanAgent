package com.huawei.agconnect.config.impl;

/* loaded from: classes22.dex */
public final class Utils {
    public static final java.lang.String DEFAULT_NAME = "DEFAULT_INSTANCE";

    public static void closeQuietly(java.io.Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (java.io.IOException unused) {
            }
        }
    }

    public static void copy(java.io.Reader reader, java.io.Writer writer) throws java.io.IOException {
        copy(reader, writer, new char[4096]);
    }

    public static void copy(java.io.Reader reader, java.io.Writer writer, char[] cArr) throws java.io.IOException {
        while (true) {
            int read = reader.read(cArr);
            if (-1 == read) {
                return;
            } else {
                writer.write(cArr, 0, read);
            }
        }
    }

    public static java.util.Map<java.lang.String, java.lang.String> fixKeyPathMap(java.util.Map<java.lang.String, java.lang.String> map) {
        java.util.HashMap hashMap = new java.util.HashMap();
        for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : map.entrySet()) {
            hashMap.put(fixPath(entry.getKey()), entry.getValue());
        }
        return hashMap;
    }

    public static java.lang.String fixPath(java.lang.String str) {
        int i = 0;
        if (str.length() > 0) {
            while (str.charAt(i) == '/') {
                i++;
            }
        }
        return net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR + str.substring(i);
    }

    public static com.huawei.agconnect.AGCRoutePolicy getRoutePolicyFromJson(java.lang.String str, java.lang.String str2) {
        if (str != null) {
            switch (str) {
                case "CN":
                    return com.huawei.agconnect.AGCRoutePolicy.CHINA;
                case "DE":
                    return com.huawei.agconnect.AGCRoutePolicy.GERMANY;
                case "RU":
                    return com.huawei.agconnect.AGCRoutePolicy.RUSSIA;
                case "SG":
                    return com.huawei.agconnect.AGCRoutePolicy.SINGAPORE;
            }
        }
        if (str2 != null) {
            if (str2.contains("connect-drcn")) {
                return com.huawei.agconnect.AGCRoutePolicy.CHINA;
            }
            if (str2.contains("connect-dre")) {
                return com.huawei.agconnect.AGCRoutePolicy.GERMANY;
            }
            if (str2.contains("connect-drru")) {
                return com.huawei.agconnect.AGCRoutePolicy.RUSSIA;
            }
            if (str2.contains("connect-dra")) {
                return com.huawei.agconnect.AGCRoutePolicy.SINGAPORE;
            }
        }
        return com.huawei.agconnect.AGCRoutePolicy.UNKNOWN;
    }

    public static java.lang.String toString(java.io.InputStream inputStream, java.lang.String str) throws java.io.UnsupportedEncodingException, java.io.IOException {
        java.io.StringWriter stringWriter = new java.io.StringWriter();
        copy(new java.io.InputStreamReader(inputStream, str), stringWriter);
        return stringWriter.toString();
    }
}
