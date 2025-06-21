package com.google.common.util.concurrent;

@com.google.common.annotations.GwtIncompatible
/* loaded from: classes22.dex */
public final class UncaughtExceptionHandlers {

    @com.google.common.annotations.VisibleForTesting
    public static final class Exiter implements java.lang.Thread.UncaughtExceptionHandler {
        public static final java.util.logging.Logger b = java.util.logging.Logger.getLogger(com.google.common.util.concurrent.UncaughtExceptionHandlers.Exiter.class.getName());
        public final java.lang.Runtime a;

        public Exiter(java.lang.Runtime runtime) {
            this.a = runtime;
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(java.lang.Thread thread, java.lang.Throwable th) {
            try {
                b.log(java.util.logging.Level.SEVERE, java.lang.String.format(java.util.Locale.ROOT, "Caught an exception in %s.  Shutting down.", thread), th);
            } finally {
                try {
                } finally {
                }
            }
        }
    }

    public static java.lang.Thread.UncaughtExceptionHandler systemExit() {
        return new com.google.common.util.concurrent.UncaughtExceptionHandlers.Exiter(java.lang.Runtime.getRuntime());
    }
}
