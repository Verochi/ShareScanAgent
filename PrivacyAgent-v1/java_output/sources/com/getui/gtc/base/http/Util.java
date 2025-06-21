package com.getui.gtc.base.http;

/* loaded from: classes22.dex */
public class Util {
    public static final java.nio.charset.Charset UTF_8 = java.nio.charset.Charset.forName("UTF-8");

    public static int checkDuration(java.lang.String str, long j, java.util.concurrent.TimeUnit timeUnit) {
        if (j < 0) {
            throw new java.lang.IllegalArgumentException(str + " < 0");
        }
        if (timeUnit == null) {
            throw new java.lang.NullPointerException("unit == null");
        }
        long millis = timeUnit.toMillis(j);
        if (millis > 2147483647L) {
            throw new java.lang.IllegalArgumentException(str + " too large.");
        }
        if (millis != 0 || j <= 0) {
            return (int) millis;
        }
        throw new java.lang.IllegalArgumentException(str + " too small.");
    }

    public static void checkHeaderItem(java.lang.String str, java.lang.String str2) {
        if (str == null) {
            throw new java.lang.NullPointerException("name == null");
        }
        if (str.isEmpty()) {
            throw new java.lang.IllegalArgumentException("name is empty");
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt <= ' ' || charAt >= 127) {
                throw new java.lang.IllegalArgumentException(java.lang.String.format(java.util.Locale.US, "Unexpected char %#04x at %d in header name: %s", java.lang.Integer.valueOf(charAt), java.lang.Integer.valueOf(i), str));
            }
        }
        if (str2 == null) {
            throw new java.lang.NullPointerException("value for name " + str + " == null");
        }
        int length2 = str2.length();
        for (int i2 = 0; i2 < length2; i2++) {
            char charAt2 = str2.charAt(i2);
            if ((charAt2 <= 31 && charAt2 != '\t') || charAt2 >= 127) {
                throw new java.lang.IllegalArgumentException(java.lang.String.format(java.util.Locale.US, "Unexpected char %#04x at %d in %s value: %s", java.lang.Integer.valueOf(charAt2), java.lang.Integer.valueOf(i2), str, str2));
            }
        }
    }

    public static void checkOffsetAndCount(long j, long j2, long j3) {
        if ((j2 | j3) < 0 || j2 > j || j - j2 < j3) {
            throw new java.lang.ArrayIndexOutOfBoundsException();
        }
    }

    public static void closeQuietly(java.io.Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (java.lang.RuntimeException e) {
                throw e;
            } catch (java.lang.Throwable unused) {
            }
        }
    }

    public static <T> java.util.List<T> immutableList(java.util.List<T> list) {
        return java.util.Collections.unmodifiableList(new java.util.ArrayList(list));
    }

    public static <T> java.util.List<T> immutableList(T... tArr) {
        return java.util.Collections.unmodifiableList(java.util.Arrays.asList((java.lang.Object[]) tArr.clone()));
    }

    public static <K, V> java.util.Map<K, V> immutableMap(java.util.Map<K, V> map) {
        return map.isEmpty() ? java.util.Collections.emptyMap() : java.util.Collections.unmodifiableMap(new java.util.LinkedHashMap(map));
    }
}
