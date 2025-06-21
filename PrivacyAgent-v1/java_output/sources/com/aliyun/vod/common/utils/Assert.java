package com.aliyun.vod.common.utils;

/* loaded from: classes12.dex */
public class Assert {
    public static void assertEquals(int i, int i2) {
        assertEquals(java.lang.Integer.valueOf(i), java.lang.Integer.valueOf(i2));
    }

    public static void assertEquals(java.lang.Object obj, java.lang.Object obj2) {
        if (obj == obj2) {
            return;
        }
        if (obj == null || obj2 == null || !obj.equals(obj2)) {
            throw new java.lang.AssertionError("expected " + obj + ", got " + obj2);
        }
    }

    public static void assertFalse(java.lang.Object obj) {
        assertEquals(java.lang.Boolean.FALSE, obj);
    }

    public static void assertGreaterThan(int i, int i2) {
        if (i > i2) {
            return;
        }
        throw new java.lang.AssertionError("unexpected " + i + " <= " + i2);
    }

    public static void assertLessOrEqual(int i, int i2) {
        if (i <= i2) {
            return;
        }
        throw new java.lang.AssertionError("unexpected " + i + " > " + i2);
    }

    public static void assertNotEquals(java.lang.Object obj, java.lang.Object obj2) {
        if (obj.equals(obj2)) {
            throw new java.lang.AssertionError("unexpected equality: " + obj2);
        }
    }

    public static void assertNotNull(java.lang.Object obj) {
        if (obj == null) {
            throw new java.lang.AssertionError("unexpected null");
        }
    }

    public static void assertNotSame(java.lang.Object obj, java.lang.Object obj2) {
        if (obj != obj2) {
            return;
        }
        throw new java.lang.AssertionError("unexpected " + obj2);
    }

    public static void assertNull(java.lang.Object obj) {
        assertEquals((java.lang.Object) null, obj);
    }

    public static void assertSame(java.lang.Object obj, java.lang.Object obj2) {
        if (obj == obj2) {
            return;
        }
        throw new java.lang.AssertionError("expected " + obj + ", got " + obj2);
    }

    public static void assertTrue(java.lang.Object obj) {
        assertEquals(java.lang.Boolean.TRUE, obj);
    }

    public static <T> T fail() {
        throw new java.lang.AssertionError("failure");
    }

    public static <T> T fail(java.lang.Object obj) {
        throw new java.lang.AssertionError(obj);
    }
}
