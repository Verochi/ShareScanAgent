package com.google.common.util.concurrent;

@com.google.errorprone.annotations.CanIgnoreReturnValue
@com.google.common.annotations.GwtIncompatible
/* loaded from: classes22.dex */
public final class ThreadFactoryBuilder {
    public java.lang.String a = null;
    public java.lang.Boolean b = null;
    public java.lang.Integer c = null;
    public java.lang.Thread.UncaughtExceptionHandler d = null;
    public java.util.concurrent.ThreadFactory e = null;

    /* renamed from: com.google.common.util.concurrent.ThreadFactoryBuilder$1, reason: invalid class name */
    public static class AnonymousClass1 implements java.util.concurrent.ThreadFactory {
        public final /* synthetic */ java.util.concurrent.ThreadFactory n;
        public final /* synthetic */ java.lang.String t;
        public final /* synthetic */ java.util.concurrent.atomic.AtomicLong u;
        public final /* synthetic */ java.lang.Boolean v;
        public final /* synthetic */ java.lang.Integer w;
        public final /* synthetic */ java.lang.Thread.UncaughtExceptionHandler x;

        public AnonymousClass1(java.util.concurrent.ThreadFactory threadFactory, java.lang.String str, java.util.concurrent.atomic.AtomicLong atomicLong, java.lang.Boolean bool, java.lang.Integer num, java.lang.Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
            this.n = threadFactory;
            this.t = str;
            this.u = atomicLong;
            this.v = bool;
            this.w = num;
            this.x = uncaughtExceptionHandler;
        }

        @Override // java.util.concurrent.ThreadFactory
        public java.lang.Thread newThread(java.lang.Runnable runnable) {
            java.lang.Thread newThread = this.n.newThread(runnable);
            java.lang.String str = this.t;
            if (str != null) {
                newThread.setName(com.google.common.util.concurrent.ThreadFactoryBuilder.c(str, java.lang.Long.valueOf(this.u.getAndIncrement())));
            }
            java.lang.Boolean bool = this.v;
            if (bool != null) {
                newThread.setDaemon(bool.booleanValue());
            }
            java.lang.Integer num = this.w;
            if (num != null) {
                newThread.setPriority(num.intValue());
            }
            java.lang.Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.x;
            if (uncaughtExceptionHandler != null) {
                newThread.setUncaughtExceptionHandler(uncaughtExceptionHandler);
            }
            return newThread;
        }
    }

    public static java.util.concurrent.ThreadFactory b(com.google.common.util.concurrent.ThreadFactoryBuilder threadFactoryBuilder) {
        java.lang.String str = threadFactoryBuilder.a;
        java.lang.Boolean bool = threadFactoryBuilder.b;
        java.lang.Integer num = threadFactoryBuilder.c;
        java.lang.Thread.UncaughtExceptionHandler uncaughtExceptionHandler = threadFactoryBuilder.d;
        java.util.concurrent.ThreadFactory threadFactory = threadFactoryBuilder.e;
        if (threadFactory == null) {
            threadFactory = java.util.concurrent.Executors.defaultThreadFactory();
        }
        return new com.google.common.util.concurrent.ThreadFactoryBuilder.AnonymousClass1(threadFactory, str, str != null ? new java.util.concurrent.atomic.AtomicLong(0L) : null, bool, num, uncaughtExceptionHandler);
    }

    public static java.lang.String c(java.lang.String str, java.lang.Object... objArr) {
        return java.lang.String.format(java.util.Locale.ROOT, str, objArr);
    }

    @com.google.errorprone.annotations.CheckReturnValue
    public java.util.concurrent.ThreadFactory build() {
        return b(this);
    }

    public com.google.common.util.concurrent.ThreadFactoryBuilder setDaemon(boolean z) {
        this.b = java.lang.Boolean.valueOf(z);
        return this;
    }

    public com.google.common.util.concurrent.ThreadFactoryBuilder setNameFormat(java.lang.String str) {
        c(str, 0);
        this.a = str;
        return this;
    }

    public com.google.common.util.concurrent.ThreadFactoryBuilder setPriority(int i) {
        com.google.common.base.Preconditions.checkArgument(i >= 1, "Thread priority (%s) must be >= %s", i, 1);
        com.google.common.base.Preconditions.checkArgument(i <= 10, "Thread priority (%s) must be <= %s", i, 10);
        this.c = java.lang.Integer.valueOf(i);
        return this;
    }

    public com.google.common.util.concurrent.ThreadFactoryBuilder setThreadFactory(java.util.concurrent.ThreadFactory threadFactory) {
        this.e = (java.util.concurrent.ThreadFactory) com.google.common.base.Preconditions.checkNotNull(threadFactory);
        return this;
    }

    public com.google.common.util.concurrent.ThreadFactoryBuilder setUncaughtExceptionHandler(java.lang.Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.d = (java.lang.Thread.UncaughtExceptionHandler) com.google.common.base.Preconditions.checkNotNull(uncaughtExceptionHandler);
        return this;
    }
}
