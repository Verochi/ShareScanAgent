package com.google.common.base;

@com.google.common.annotations.GwtIncompatible
/* loaded from: classes22.dex */
public final class Defaults {
    public static final java.lang.Double a = java.lang.Double.valueOf(0.0d);
    public static final java.lang.Float b = java.lang.Float.valueOf(0.0f);

    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    public static <T> T defaultValue(java.lang.Class<T> cls) {
        com.google.common.base.Preconditions.checkNotNull(cls);
        if (cls == java.lang.Boolean.TYPE) {
            return (T) java.lang.Boolean.FALSE;
        }
        if (cls == java.lang.Character.TYPE) {
            return (T) (char) 0;
        }
        if (cls == java.lang.Byte.TYPE) {
            return (T) (byte) 0;
        }
        if (cls == java.lang.Short.TYPE) {
            return (T) (short) 0;
        }
        if (cls == java.lang.Integer.TYPE) {
            return (T) 0;
        }
        if (cls == java.lang.Long.TYPE) {
            return (T) 0L;
        }
        if (cls == java.lang.Float.TYPE) {
            return (T) b;
        }
        if (cls == java.lang.Double.TYPE) {
            return (T) a;
        }
        return null;
    }
}
