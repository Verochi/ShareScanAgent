package com.sina.weibo.sdk.b;

/* loaded from: classes19.dex */
public abstract class c<Params, Progress, Result> {
    final com.sina.weibo.sdk.b.c.d<Params, Result> R;
    public final java.util.concurrent.FutureTask<Result> S;
    Params[] U;
    volatile int Q = com.sina.weibo.sdk.b.c.b.Z;
    int T = 5;
    android.os.Handler x = new com.sina.weibo.sdk.b.c.AnonymousClass1(android.os.Looper.getMainLooper());

    /* renamed from: com.sina.weibo.sdk.b.c$1, reason: invalid class name */
    public class AnonymousClass1 extends android.os.Handler {
        public AnonymousClass1(android.os.Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(android.os.Message message) {
            com.sina.weibo.sdk.b.c.a aVar = (com.sina.weibo.sdk.b.c.a) message.obj;
            if (message.what != 1) {
                return;
            }
            com.sina.weibo.sdk.b.c.a(aVar.X, aVar.Y[0]);
            message.obj = null;
        }
    }

    /* renamed from: com.sina.weibo.sdk.b.c$2, reason: invalid class name */
    public class AnonymousClass2 extends com.sina.weibo.sdk.b.c.d<Params, Result> {
        public AnonymousClass2() {
            super((byte) 0);
        }

        @Override // java.util.concurrent.Callable
        public final Result call() {
            android.os.Process.setThreadPriority(com.sina.weibo.sdk.b.c.this.T);
            return (Result) com.sina.weibo.sdk.b.c.this.o();
        }
    }

    /* renamed from: com.sina.weibo.sdk.b.c$3, reason: invalid class name */
    public class AnonymousClass3 extends com.sina.weibo.sdk.b.c<Params, Progress, Result>.AbstractC0465c {
        public AnonymousClass3(com.sina.weibo.sdk.b.c.d dVar) {
            super(dVar);
        }

        @Override // java.lang.Comparable
        public final int compareTo(java.lang.Object obj) {
            return 0;
        }

        @Override // java.util.concurrent.FutureTask
        public final void done() {
            try {
                Result result = get();
                com.sina.weibo.sdk.b.c cVar = com.sina.weibo.sdk.b.c.this;
                cVar.x.obtainMessage(1, new com.sina.weibo.sdk.b.c.a(cVar, result)).sendToTarget();
            } catch (java.lang.InterruptedException unused) {
                throw new java.lang.RuntimeException("An error occur while execute doInBackground().");
            } catch (java.util.concurrent.CancellationException unused2) {
                com.sina.weibo.sdk.b.c.this.x.obtainMessage(3, new com.sina.weibo.sdk.b.c.a(com.sina.weibo.sdk.b.c.this, null)).sendToTarget();
            } catch (java.util.concurrent.ExecutionException unused3) {
                throw new java.lang.RuntimeException("An error occur while execute doInBackground().");
            }
        }
    }

    /* renamed from: com.sina.weibo.sdk.b.c$4, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] W;

        static {
            int[] iArr = new int[com.sina.weibo.sdk.b.c.b.p().length];
            W = iArr;
            try {
                iArr[com.sina.weibo.sdk.b.c.b.aa - 1] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                W[com.sina.weibo.sdk.b.c.b.ab - 1] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
        }
    }

    public static class a<Data> {
        final com.sina.weibo.sdk.b.c X;
        final Data[] Y;

        public a(com.sina.weibo.sdk.b.c cVar, Data... dataArr) {
            this.X = cVar;
            this.Y = dataArr;
        }
    }

    /* JADX WARN: $VALUES field not found */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    public static final class b {
        public static final int Z = 1;
        public static final int aa = 2;
        public static final int ab = 3;
        private static final /* synthetic */ int[] ac = {1, 2, 3};

        public static int[] p() {
            return (int[]) ac.clone();
        }
    }

    /* renamed from: com.sina.weibo.sdk.b.c$c, reason: collision with other inner class name */
    public abstract class AbstractC0465c extends java.util.concurrent.FutureTask<Result> implements java.lang.Comparable<java.lang.Object> {
        int priority;

        public AbstractC0465c(com.sina.weibo.sdk.b.c.d dVar) {
            super(dVar);
            this.priority = dVar.priority;
        }
    }

    public static abstract class d<Params, Result> implements java.util.concurrent.Callable<Result> {
        Params[] ad;
        int priority;

        private d() {
            this.priority = 10;
        }

        public /* synthetic */ d(byte b) {
            this();
        }
    }

    public c() {
        com.sina.weibo.sdk.b.c.AnonymousClass2 anonymousClass2 = new com.sina.weibo.sdk.b.c.AnonymousClass2();
        this.R = anonymousClass2;
        this.S = new com.sina.weibo.sdk.b.c.AnonymousClass3(anonymousClass2);
    }

    public static /* synthetic */ void a(com.sina.weibo.sdk.b.c cVar, java.lang.Object obj) {
        cVar.onPostExecute(obj);
        cVar.Q = com.sina.weibo.sdk.b.c.b.ab;
    }

    public abstract Result o();

    public void onPostExecute(Result result) {
    }
}
