package com.google.common.base;

@com.google.common.annotations.GwtCompatible
/* loaded from: classes22.dex */
public final class Stopwatch {
    public final com.google.common.base.Ticker a;
    public boolean b;
    public long c;
    public long d;

    /* renamed from: com.google.common.base.Stopwatch$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[java.util.concurrent.TimeUnit.values().length];
            a = iArr;
            try {
                iArr[java.util.concurrent.TimeUnit.NANOSECONDS.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                a[java.util.concurrent.TimeUnit.MICROSECONDS.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                a[java.util.concurrent.TimeUnit.MILLISECONDS.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                a[java.util.concurrent.TimeUnit.SECONDS.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
            try {
                a[java.util.concurrent.TimeUnit.MINUTES.ordinal()] = 5;
            } catch (java.lang.NoSuchFieldError unused5) {
            }
            try {
                a[java.util.concurrent.TimeUnit.HOURS.ordinal()] = 6;
            } catch (java.lang.NoSuchFieldError unused6) {
            }
            try {
                a[java.util.concurrent.TimeUnit.DAYS.ordinal()] = 7;
            } catch (java.lang.NoSuchFieldError unused7) {
            }
        }
    }

    public Stopwatch() {
        this.a = com.google.common.base.Ticker.systemTicker();
    }

    public Stopwatch(com.google.common.base.Ticker ticker) {
        this.a = (com.google.common.base.Ticker) com.google.common.base.Preconditions.checkNotNull(ticker, com.huawei.hms.push.constant.RemoteMessageConst.Notification.TICKER);
    }

    public static java.lang.String a(java.util.concurrent.TimeUnit timeUnit) {
        switch (com.google.common.base.Stopwatch.AnonymousClass1.a[timeUnit.ordinal()]) {
            case 1:
                return com.meizu.cloud.pushsdk.notification.model.NotificationStyle.NOTIFICATION_STYLE;
            case 2:
                return "μs";
            case 3:
                return "ms";
            case 4:
                return "s";
            case 5:
                return org.apache.tools.ant.types.selectors.DepthSelector.MIN_KEY;
            case 6:
                return "h";
            case 7:
                return "d";
            default:
                throw new java.lang.AssertionError();
        }
    }

    public static java.util.concurrent.TimeUnit b(long j) {
        java.util.concurrent.TimeUnit timeUnit = java.util.concurrent.TimeUnit.DAYS;
        java.util.concurrent.TimeUnit timeUnit2 = java.util.concurrent.TimeUnit.NANOSECONDS;
        if (timeUnit.convert(j, timeUnit2) > 0) {
            return timeUnit;
        }
        java.util.concurrent.TimeUnit timeUnit3 = java.util.concurrent.TimeUnit.HOURS;
        if (timeUnit3.convert(j, timeUnit2) > 0) {
            return timeUnit3;
        }
        java.util.concurrent.TimeUnit timeUnit4 = java.util.concurrent.TimeUnit.MINUTES;
        if (timeUnit4.convert(j, timeUnit2) > 0) {
            return timeUnit4;
        }
        java.util.concurrent.TimeUnit timeUnit5 = java.util.concurrent.TimeUnit.SECONDS;
        if (timeUnit5.convert(j, timeUnit2) > 0) {
            return timeUnit5;
        }
        java.util.concurrent.TimeUnit timeUnit6 = java.util.concurrent.TimeUnit.MILLISECONDS;
        if (timeUnit6.convert(j, timeUnit2) > 0) {
            return timeUnit6;
        }
        java.util.concurrent.TimeUnit timeUnit7 = java.util.concurrent.TimeUnit.MICROSECONDS;
        return timeUnit7.convert(j, timeUnit2) > 0 ? timeUnit7 : timeUnit2;
    }

    public static com.google.common.base.Stopwatch createStarted() {
        return new com.google.common.base.Stopwatch().start();
    }

    public static com.google.common.base.Stopwatch createStarted(com.google.common.base.Ticker ticker) {
        return new com.google.common.base.Stopwatch(ticker).start();
    }

    public static com.google.common.base.Stopwatch createUnstarted() {
        return new com.google.common.base.Stopwatch();
    }

    public static com.google.common.base.Stopwatch createUnstarted(com.google.common.base.Ticker ticker) {
        return new com.google.common.base.Stopwatch(ticker);
    }

    public final long c() {
        return this.b ? (this.a.read() - this.d) + this.c : this.c;
    }

    public long elapsed(java.util.concurrent.TimeUnit timeUnit) {
        return timeUnit.convert(c(), java.util.concurrent.TimeUnit.NANOSECONDS);
    }

    public boolean isRunning() {
        return this.b;
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public com.google.common.base.Stopwatch reset() {
        this.c = 0L;
        this.b = false;
        return this;
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public com.google.common.base.Stopwatch start() {
        com.google.common.base.Preconditions.checkState(!this.b, "This stopwatch is already running.");
        this.b = true;
        this.d = this.a.read();
        return this;
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public com.google.common.base.Stopwatch stop() {
        long read = this.a.read();
        com.google.common.base.Preconditions.checkState(this.b, "This stopwatch is already stopped.");
        this.b = false;
        this.c += read - this.d;
        return this;
    }

    public java.lang.String toString() {
        long c = c();
        java.util.concurrent.TimeUnit b = b(c);
        return com.google.common.base.Platform.c(c / java.util.concurrent.TimeUnit.NANOSECONDS.convert(1L, b)) + " " + a(b);
    }
}
