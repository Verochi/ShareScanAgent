package com.efs.sdk.pa.a;

/* loaded from: classes22.dex */
public final class a {
    volatile boolean a;
    final android.os.Handler b;
    final java.lang.Thread c;
    long d;
    long e;
    boolean f;
    android.os.Handler g;
    com.efs.sdk.pa.PAANRListener h;
    long i;
    long j;
    final long k;
    boolean l;
    final java.lang.Runnable m;
    final java.lang.Runnable n;
    private android.os.HandlerThread o;
    private android.app.Application p;

    /* renamed from: com.efs.sdk.pa.a.a$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        public AnonymousClass1() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:30:0x006c, code lost:
        
            if (com.efs.sdk.pa.a.a.a(r1) != false) goto L24;
         */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void run() {
            com.efs.sdk.pa.PAANRListener pAANRListener;
            if (com.efs.sdk.pa.a.a.this.f) {
                return;
            }
            long uptimeMillis = android.os.SystemClock.uptimeMillis();
            com.efs.sdk.pa.a.a aVar = com.efs.sdk.pa.a.a.this;
            long j = uptimeMillis - aVar.j;
            if (j > aVar.k && (pAANRListener = aVar.h) != null) {
                pAANRListener.unexcept(java.lang.Long.valueOf(j));
            }
            if (com.efs.sdk.pa.a.a.this.a) {
                com.efs.sdk.pa.a.a aVar2 = com.efs.sdk.pa.a.a.this;
                aVar2.i = 0L;
                aVar2.a = false;
                com.efs.sdk.pa.a.a aVar3 = com.efs.sdk.pa.a.a.this;
                aVar3.b.postAtFrontOfQueue(aVar3.n);
            } else {
                com.efs.sdk.pa.a.a aVar4 = com.efs.sdk.pa.a.a.this;
                aVar4.i++;
                if (!aVar4.a) {
                    com.efs.sdk.pa.a.a aVar5 = com.efs.sdk.pa.a.a.this;
                    long j2 = aVar5.i;
                    long j3 = aVar5.e;
                    if (j2 >= j3 && j2 == j3) {
                        java.lang.StringBuilder sb = new java.lang.StringBuilder();
                        if (aVar5.l) {
                            sb.append(com.efs.sdk.pa.a.a.a(aVar5.c));
                        }
                        if (aVar5.h != null && sb.length() > 0) {
                            aVar5.h.anrStack(sb.toString());
                        }
                    }
                }
            }
            com.efs.sdk.pa.a.a.this.j = android.os.SystemClock.uptimeMillis();
            com.efs.sdk.pa.a.a aVar6 = com.efs.sdk.pa.a.a.this;
            aVar6.g.postDelayed(aVar6.m, aVar6.d);
        }
    }

    /* renamed from: com.efs.sdk.pa.a.a$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        public AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.efs.sdk.pa.a.a.this.a = true;
        }
    }

    public a(android.app.Application application, long j) {
        this(application, j, true);
    }

    public a(android.app.Application application, long j, boolean z) {
        this.a = true;
        this.e = 4L;
        this.f = true;
        this.i = 0L;
        this.m = new com.efs.sdk.pa.a.a.AnonymousClass1();
        this.n = new com.efs.sdk.pa.a.a.AnonymousClass2();
        this.k = j;
        this.p = application;
        this.l = z;
        long j2 = ((long) (j * 0.8f)) / this.e;
        this.d = j2;
        if (j2 < 100) {
            this.d = 100L;
            this.e = j / 100;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder("anrTrace, final mAnrBeatTime:");
        sb.append(this.d);
        sb.append(", mAnrBeatRate:");
        sb.append(this.d);
        this.c = android.os.Looper.getMainLooper().getThread();
        this.b = new android.os.Handler(android.os.Looper.getMainLooper());
        android.os.HandlerThread handlerThread = new android.os.HandlerThread("ANR HANDLER THREAD");
        this.o = handlerThread;
        handlerThread.start();
        this.g = new android.os.Handler(this.o.getLooper());
    }

    public static java.lang.String a(java.lang.Thread thread) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        java.lang.StackTraceElement[] stackTrace = thread.getStackTrace();
        sb.append(thread.getName());
        sb.append(" ");
        sb.append(thread.getPriority());
        sb.append(" ");
        sb.append(thread.getState());
        sb.append("\n");
        for (java.lang.StackTraceElement stackTraceElement : stackTrace) {
            java.lang.String stackTraceElement2 = stackTraceElement.toString();
            sb.append("  at  ");
            sb.append(stackTraceElement2);
            sb.append('\n');
        }
        sb.append("\n");
        return sb.toString();
    }

    public static boolean a(java.lang.StringBuilder sb) {
        java.util.Set<java.util.Map.Entry<java.lang.Thread, java.lang.StackTraceElement[]>> entrySet = java.lang.Thread.getAllStackTraces().entrySet();
        if (entrySet.size() == 0) {
            return false;
        }
        boolean z = false;
        for (java.util.Map.Entry<java.lang.Thread, java.lang.StackTraceElement[]> entry : entrySet) {
            java.lang.Thread key = entry.getKey();
            java.lang.StackTraceElement[] value = entry.getValue();
            if (key.getId() == android.os.Looper.getMainLooper().getThread().getId()) {
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                sb2.append(key.getName());
                sb2.append(" ");
                sb2.append(key.getPriority());
                sb2.append(" ");
                sb2.append(key.getState());
                sb2.append("\n");
                for (java.lang.StackTraceElement stackTraceElement : value) {
                    java.lang.String stackTraceElement2 = stackTraceElement.toString();
                    sb2.append("  at  ");
                    sb2.append(stackTraceElement2);
                    sb2.append('\n');
                }
                sb2.append("\n");
                sb.insert(0, (java.lang.CharSequence) sb2);
                z = true;
            } else {
                sb.append(key.getName());
                sb.append(" ");
                sb.append(key.getPriority());
                sb.append(" ");
                sb.append(key.getState());
                sb.append("\n");
                for (java.lang.StackTraceElement stackTraceElement3 : value) {
                    java.lang.String stackTraceElement4 = stackTraceElement3.toString();
                    sb.append("  at  ");
                    sb.append(stackTraceElement4);
                    sb.append('\n');
                }
                sb.append("\n");
            }
        }
        if (!z) {
            sb.insert(0, a(android.os.Looper.getMainLooper().getThread()));
        }
        return true;
    }
}
