package com.bumptech.glide.util.pool;

/* loaded from: classes.dex */
public final class GlideTrace {
    private static final int MAX_LENGTH = 127;
    private static final boolean TRACING_ENABLED = false;

    private GlideTrace() {
    }

    public static void beginSection(java.lang.String str) {
    }

    public static void beginSectionFormat(java.lang.String str, java.lang.Object obj) {
    }

    public static void beginSectionFormat(java.lang.String str, java.lang.Object obj, java.lang.Object obj2) {
    }

    public static void beginSectionFormat(java.lang.String str, java.lang.Object obj, java.lang.Object obj2, java.lang.Object obj3) {
    }

    public static void endSection() {
    }

    private static java.lang.String truncateTag(java.lang.String str) {
        return str.length() > 127 ? str.substring(0, 126) : str;
    }
}
