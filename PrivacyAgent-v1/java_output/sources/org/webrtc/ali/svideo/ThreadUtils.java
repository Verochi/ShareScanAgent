package org.webrtc.ali.svideo;

/* loaded from: classes26.dex */
public class ThreadUtils {
    private static android.os.Handler sMainHandler;

    /* renamed from: org.webrtc.ali.svideo.ThreadUtils$1, reason: invalid class name */
    public static class AnonymousClass1 implements org.webrtc.ali.svideo.ThreadUtils.BlockingOperation {
        final /* synthetic */ java.lang.Thread val$thread;

        public AnonymousClass1(java.lang.Thread thread) {
            this.val$thread = thread;
        }

        @Override // org.webrtc.ali.svideo.ThreadUtils.BlockingOperation
        public void run() throws java.lang.InterruptedException {
            this.val$thread.join();
        }
    }

    /* renamed from: org.webrtc.ali.svideo.ThreadUtils$1CaughtException, reason: invalid class name */
    public class C1CaughtException {
        java.lang.Exception e;
    }

    /* renamed from: org.webrtc.ali.svideo.ThreadUtils$2, reason: invalid class name */
    public static class AnonymousClass2 implements org.webrtc.ali.svideo.ThreadUtils.BlockingOperation {
        final /* synthetic */ java.util.concurrent.CountDownLatch val$latch;

        public AnonymousClass2(java.util.concurrent.CountDownLatch countDownLatch) {
            this.val$latch = countDownLatch;
        }

        @Override // org.webrtc.ali.svideo.ThreadUtils.BlockingOperation
        public void run() throws java.lang.InterruptedException {
            this.val$latch.await();
        }
    }

    /* renamed from: org.webrtc.ali.svideo.ThreadUtils$3, reason: invalid class name */
    public static class AnonymousClass3 implements org.webrtc.ali.svideo.ThreadUtils.BlockingOperation {
        final /* synthetic */ java.lang.Object val$object;

        public AnonymousClass3(java.lang.Object obj) {
            this.val$object = obj;
        }

        @Override // org.webrtc.ali.svideo.ThreadUtils.BlockingOperation
        public void run() throws java.lang.InterruptedException {
            this.val$object.wait();
        }
    }

    /* renamed from: org.webrtc.ali.svideo.ThreadUtils$4, reason: invalid class name */
    public static class AnonymousClass4 implements java.lang.Runnable {
        final /* synthetic */ java.util.concurrent.CountDownLatch val$barrier;
        final /* synthetic */ java.util.concurrent.Callable val$callable;
        final /* synthetic */ org.webrtc.ali.svideo.ThreadUtils.C1CaughtException val$caughtException;
        final /* synthetic */ java.lang.Object[] val$result;

        public AnonymousClass4(java.lang.Object[] objArr, java.util.concurrent.Callable callable, org.webrtc.ali.svideo.ThreadUtils.C1CaughtException c1CaughtException, java.util.concurrent.CountDownLatch countDownLatch) {
            this.val$result = objArr;
            this.val$callable = callable;
            this.val$caughtException = c1CaughtException;
            this.val$barrier = countDownLatch;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.val$result[0] = this.val$callable.call();
            } catch (java.lang.Exception e) {
                this.val$caughtException.e = e;
            }
            this.val$barrier.countDown();
        }
    }

    /* renamed from: org.webrtc.ali.svideo.ThreadUtils$5, reason: invalid class name */
    public static class AnonymousClass5 implements java.util.concurrent.Callable<java.lang.Void> {
        final /* synthetic */ java.lang.Runnable val$runner;

        public AnonymousClass5(java.lang.Runnable runnable) {
            this.val$runner = runnable;
        }

        @Override // java.util.concurrent.Callable
        public java.lang.Void call() {
            this.val$runner.run();
            return null;
        }
    }

    public interface BlockingOperation {
        void run() throws java.lang.InterruptedException;
    }

    public static class ThreadChecker {
        private java.lang.Thread thread = java.lang.Thread.currentThread();

        public void checkIsOnValidThread() {
            if (this.thread == null) {
                this.thread = java.lang.Thread.currentThread();
            }
            if (java.lang.Thread.currentThread() != this.thread) {
                throw new java.lang.IllegalStateException("Wrong thread");
            }
        }

        public void detachThread() {
            this.thread = null;
        }
    }

    public static void awaitUninterruptibly(java.util.concurrent.CountDownLatch countDownLatch) {
        executeUninterruptibly(new org.webrtc.ali.svideo.ThreadUtils.AnonymousClass2(countDownLatch));
    }

    public static boolean awaitUninterruptibly(java.util.concurrent.CountDownLatch countDownLatch, long j) {
        long elapsedRealtime = android.os.SystemClock.elapsedRealtime();
        boolean z = false;
        long j2 = j;
        boolean z2 = false;
        do {
            try {
                z = countDownLatch.await(j2, java.util.concurrent.TimeUnit.MILLISECONDS);
                break;
            } catch (java.lang.InterruptedException unused) {
                j2 = j - (android.os.SystemClock.elapsedRealtime() - elapsedRealtime);
                z2 = true;
            }
        } while (j2 > 0);
        if (z2) {
            java.lang.Thread.currentThread().interrupt();
        }
        return z;
    }

    public static void checkIsOnMainThread() {
        if (java.lang.Thread.currentThread() != android.os.Looper.getMainLooper().getThread()) {
            throw new java.lang.IllegalStateException("Not on main thread!");
        }
    }

    public static java.lang.StackTraceElement[] concatStackTraces(java.lang.StackTraceElement[] stackTraceElementArr, java.lang.StackTraceElement[] stackTraceElementArr2) {
        java.lang.StackTraceElement[] stackTraceElementArr3 = new java.lang.StackTraceElement[stackTraceElementArr.length + stackTraceElementArr2.length];
        java.lang.System.arraycopy(stackTraceElementArr, 0, stackTraceElementArr3, 0, stackTraceElementArr.length);
        java.lang.System.arraycopy(stackTraceElementArr2, 0, stackTraceElementArr3, stackTraceElementArr.length, stackTraceElementArr2.length);
        return stackTraceElementArr3;
    }

    public static void executeUninterruptibly(org.webrtc.ali.svideo.ThreadUtils.BlockingOperation blockingOperation) {
        boolean z = false;
        while (true) {
            try {
                blockingOperation.run();
                break;
            } catch (java.lang.InterruptedException unused) {
                z = true;
            }
        }
        if (z) {
            java.lang.Thread.currentThread().interrupt();
        }
    }

    public static <V> V invokeAtFrontUninterruptibly(android.os.Handler handler, java.util.concurrent.Callable<V> callable) {
        if (handler.getLooper().getThread() == java.lang.Thread.currentThread()) {
            try {
                return callable.call();
            } catch (java.lang.Exception e) {
                throw new java.lang.RuntimeException(e);
            }
        }
        java.lang.Object[] objArr = new java.lang.Object[1];
        org.webrtc.ali.svideo.ThreadUtils.C1CaughtException c1CaughtException = new org.webrtc.ali.svideo.ThreadUtils.C1CaughtException();
        java.util.concurrent.CountDownLatch countDownLatch = new java.util.concurrent.CountDownLatch(1);
        handler.post(new org.webrtc.ali.svideo.ThreadUtils.AnonymousClass4(objArr, callable, c1CaughtException, countDownLatch));
        awaitUninterruptibly(countDownLatch);
        if (c1CaughtException.e == null) {
            return (V) objArr[0];
        }
        java.lang.RuntimeException runtimeException = new java.lang.RuntimeException(c1CaughtException.e);
        runtimeException.setStackTrace(concatStackTraces(c1CaughtException.e.getStackTrace(), runtimeException.getStackTrace()));
        throw runtimeException;
    }

    public static void invokeAtFrontUninterruptibly(android.os.Handler handler, java.lang.Runnable runnable) {
        invokeAtFrontUninterruptibly(handler, new org.webrtc.ali.svideo.ThreadUtils.AnonymousClass5(runnable));
    }

    public static boolean isOnUiThread() {
        return android.os.Looper.getMainLooper().getThread() == java.lang.Thread.currentThread();
    }

    public static void joinUninterruptibly(java.lang.Thread thread) {
        executeUninterruptibly(new org.webrtc.ali.svideo.ThreadUtils.AnonymousClass1(thread));
    }

    public static boolean joinUninterruptibly(java.lang.Thread thread, long j) {
        long elapsedRealtime = android.os.SystemClock.elapsedRealtime();
        boolean z = false;
        long j2 = j;
        while (j2 > 0) {
            try {
                thread.join(j2);
                break;
            } catch (java.lang.InterruptedException unused) {
                j2 = j - (android.os.SystemClock.elapsedRealtime() - elapsedRealtime);
                z = true;
            }
        }
        if (z) {
            java.lang.Thread.currentThread().interrupt();
        }
        return !thread.isAlive();
    }

    public static void postOnUiThread(java.lang.Runnable runnable, long j) {
        synchronized (org.webrtc.ali.svideo.ThreadUtils.class) {
            if (sMainHandler == null) {
                sMainHandler = new android.os.Handler(android.os.Looper.getMainLooper());
            }
        }
        sMainHandler.postDelayed(runnable, j);
    }

    public static void runOnUiThread(java.lang.Runnable runnable) {
        synchronized (org.webrtc.ali.svideo.ThreadUtils.class) {
            if (sMainHandler == null) {
                sMainHandler = new android.os.Handler(android.os.Looper.getMainLooper());
            }
        }
        sMainHandler.post(runnable);
    }

    public static void waitUninterruptibly(java.lang.Object obj) {
        executeUninterruptibly(new org.webrtc.ali.svideo.ThreadUtils.AnonymousClass3(obj));
    }
}
