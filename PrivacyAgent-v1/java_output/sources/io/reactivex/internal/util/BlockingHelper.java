package io.reactivex.internal.util;

/* loaded from: classes13.dex */
public final class BlockingHelper {
    public BlockingHelper() {
        throw new java.lang.IllegalStateException("No instances!");
    }

    public static void awaitForComplete(java.util.concurrent.CountDownLatch countDownLatch, io.reactivex.disposables.Disposable disposable) {
        if (countDownLatch.getCount() == 0) {
            return;
        }
        try {
            verifyNonBlocking();
            countDownLatch.await();
        } catch (java.lang.InterruptedException e) {
            disposable.dispose();
            java.lang.Thread.currentThread().interrupt();
            throw new java.lang.IllegalStateException("Interrupted while waiting for subscription to complete.", e);
        }
    }

    public static void verifyNonBlocking() {
        if (io.reactivex.plugins.RxJavaPlugins.isFailOnNonBlockingScheduler()) {
            if ((java.lang.Thread.currentThread() instanceof io.reactivex.internal.schedulers.NonBlockingThread) || io.reactivex.plugins.RxJavaPlugins.onBeforeBlocking()) {
                throw new java.lang.IllegalStateException("Attempt to block on a Scheduler " + java.lang.Thread.currentThread().getName() + " that doesn't support blocking operators as they may lead to deadlock");
            }
        }
    }
}
