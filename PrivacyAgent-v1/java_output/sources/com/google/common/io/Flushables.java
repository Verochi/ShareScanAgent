package com.google.common.io;

@com.google.common.annotations.Beta
@com.google.common.annotations.GwtIncompatible
/* loaded from: classes22.dex */
public final class Flushables {
    public static final java.util.logging.Logger a = java.util.logging.Logger.getLogger(com.google.common.io.Flushables.class.getName());

    public static void flush(java.io.Flushable flushable, boolean z) throws java.io.IOException {
        try {
            flushable.flush();
        } catch (java.io.IOException e) {
            if (!z) {
                throw e;
            }
            a.log(java.util.logging.Level.WARNING, "IOException thrown while flushing Flushable.", (java.lang.Throwable) e);
        }
    }

    public static void flushQuietly(java.io.Flushable flushable) {
        try {
            flush(flushable, true);
        } catch (java.io.IOException e) {
            a.log(java.util.logging.Level.SEVERE, "IOException should not have been thrown.", (java.lang.Throwable) e);
        }
    }
}
