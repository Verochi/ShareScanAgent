package com.google.common.io;

@com.google.common.annotations.Beta
@com.google.common.annotations.GwtIncompatible
/* loaded from: classes22.dex */
public final class Closeables {

    @com.google.common.annotations.VisibleForTesting
    public static final java.util.logging.Logger a = java.util.logging.Logger.getLogger(com.google.common.io.Closeables.class.getName());

    public static void close(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.io.Closeable closeable, boolean z) throws java.io.IOException {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (java.io.IOException e) {
            if (!z) {
                throw e;
            }
            a.log(java.util.logging.Level.WARNING, "IOException thrown while closing Closeable.", (java.lang.Throwable) e);
        }
    }

    public static void closeQuietly(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.io.InputStream inputStream) {
        try {
            close(inputStream, true);
        } catch (java.io.IOException e) {
            throw new java.lang.AssertionError(e);
        }
    }

    public static void closeQuietly(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.io.Reader reader) {
        try {
            close(reader, true);
        } catch (java.io.IOException e) {
            throw new java.lang.AssertionError(e);
        }
    }
}
