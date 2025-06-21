package com.google.common.util.concurrent;

@com.google.common.annotations.GwtCompatible(emulated = true)
/* loaded from: classes22.dex */
public final class Uninterruptibles {
    @com.google.common.annotations.GwtIncompatible
    public static void awaitUninterruptibly(java.util.concurrent.CountDownLatch countDownLatch) {
        boolean z = false;
        while (true) {
            try {
                countDownLatch.await();
                break;
            } catch (java.lang.InterruptedException unused) {
                z = true;
            } catch (java.lang.Throwable th) {
                if (z) {
                    java.lang.Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z) {
            java.lang.Thread.currentThread().interrupt();
        }
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    @com.google.common.annotations.GwtIncompatible
    public static boolean awaitUninterruptibly(java.util.concurrent.CountDownLatch countDownLatch, long j, java.util.concurrent.TimeUnit timeUnit) {
        boolean z = false;
        try {
            long nanos = timeUnit.toNanos(j);
            while (true) {
                try {
                    break;
                } catch (java.lang.InterruptedException unused) {
                    z = true;
                    nanos = (java.lang.System.nanoTime() + nanos) - java.lang.System.nanoTime();
                }
            }
            return countDownLatch.await(nanos, java.util.concurrent.TimeUnit.NANOSECONDS);
        } finally {
            if (z) {
                java.lang.Thread.currentThread().interrupt();
            }
        }
    }

    @com.google.common.annotations.GwtIncompatible
    public static boolean awaitUninterruptibly(java.util.concurrent.locks.Condition condition, long j, java.util.concurrent.TimeUnit timeUnit) {
        boolean z = false;
        try {
            long nanos = timeUnit.toNanos(j);
            while (true) {
                try {
                    break;
                } catch (java.lang.InterruptedException unused) {
                    z = true;
                    nanos = (java.lang.System.nanoTime() + nanos) - java.lang.System.nanoTime();
                }
            }
            return condition.await(nanos, java.util.concurrent.TimeUnit.NANOSECONDS);
        } finally {
            if (z) {
                java.lang.Thread.currentThread().interrupt();
            }
        }
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public static <V> V getUninterruptibly(java.util.concurrent.Future<V> future) throws java.util.concurrent.ExecutionException {
        V v;
        boolean z = false;
        while (true) {
            try {
                v = future.get();
                break;
            } catch (java.lang.InterruptedException unused) {
                z = true;
            } catch (java.lang.Throwable th) {
                if (z) {
                    java.lang.Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z) {
            java.lang.Thread.currentThread().interrupt();
        }
        return v;
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    @com.google.common.annotations.GwtIncompatible
    public static <V> V getUninterruptibly(java.util.concurrent.Future<V> future, long j, java.util.concurrent.TimeUnit timeUnit) throws java.util.concurrent.ExecutionException, java.util.concurrent.TimeoutException {
        boolean z = false;
        try {
            long nanos = timeUnit.toNanos(j);
            while (true) {
                try {
                    break;
                } catch (java.lang.InterruptedException unused) {
                    z = true;
                    nanos = (java.lang.System.nanoTime() + nanos) - java.lang.System.nanoTime();
                }
            }
            return future.get(nanos, java.util.concurrent.TimeUnit.NANOSECONDS);
        } finally {
            if (z) {
                java.lang.Thread.currentThread().interrupt();
            }
        }
    }

    @com.google.common.annotations.GwtIncompatible
    public static void joinUninterruptibly(java.lang.Thread thread) {
        boolean z = false;
        while (true) {
            try {
                thread.join();
                break;
            } catch (java.lang.InterruptedException unused) {
                z = true;
            } catch (java.lang.Throwable th) {
                if (z) {
                    java.lang.Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z) {
            java.lang.Thread.currentThread().interrupt();
        }
    }

    @com.google.common.annotations.GwtIncompatible
    public static void joinUninterruptibly(java.lang.Thread thread, long j, java.util.concurrent.TimeUnit timeUnit) {
        com.google.common.base.Preconditions.checkNotNull(thread);
        boolean z = false;
        try {
            long nanos = timeUnit.toNanos(j);
            long nanoTime = java.lang.System.nanoTime() + nanos;
            while (true) {
                try {
                    java.util.concurrent.TimeUnit.NANOSECONDS.timedJoin(thread, nanos);
                    break;
                } catch (java.lang.InterruptedException unused) {
                    z = true;
                    nanos = nanoTime - java.lang.System.nanoTime();
                }
            }
        } finally {
            if (z) {
                java.lang.Thread.currentThread().interrupt();
            }
        }
    }

    @com.google.common.annotations.GwtIncompatible
    public static <E> void putUninterruptibly(java.util.concurrent.BlockingQueue<E> blockingQueue, E e) {
        boolean z = false;
        while (true) {
            try {
                blockingQueue.put(e);
                break;
            } catch (java.lang.InterruptedException unused) {
                z = true;
            } catch (java.lang.Throwable th) {
                if (z) {
                    java.lang.Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z) {
            java.lang.Thread.currentThread().interrupt();
        }
    }

    @com.google.common.annotations.GwtIncompatible
    public static void sleepUninterruptibly(long j, java.util.concurrent.TimeUnit timeUnit) {
        boolean z = false;
        try {
            long nanos = timeUnit.toNanos(j);
            long nanoTime = java.lang.System.nanoTime() + nanos;
            while (true) {
                try {
                    java.util.concurrent.TimeUnit.NANOSECONDS.sleep(nanos);
                    break;
                } catch (java.lang.InterruptedException unused) {
                    z = true;
                    nanos = nanoTime - java.lang.System.nanoTime();
                }
            }
        } finally {
            if (z) {
                java.lang.Thread.currentThread().interrupt();
            }
        }
    }

    @com.google.common.annotations.GwtIncompatible
    public static <E> E takeUninterruptibly(java.util.concurrent.BlockingQueue<E> blockingQueue) {
        E take;
        boolean z = false;
        while (true) {
            try {
                take = blockingQueue.take();
                break;
            } catch (java.lang.InterruptedException unused) {
                z = true;
            } catch (java.lang.Throwable th) {
                if (z) {
                    java.lang.Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z) {
            java.lang.Thread.currentThread().interrupt();
        }
        return take;
    }

    @com.google.common.annotations.GwtIncompatible
    public static boolean tryAcquireUninterruptibly(java.util.concurrent.Semaphore semaphore, int i, long j, java.util.concurrent.TimeUnit timeUnit) {
        boolean z = false;
        try {
            long nanos = timeUnit.toNanos(j);
            while (true) {
                try {
                    break;
                } catch (java.lang.InterruptedException unused) {
                    z = true;
                    nanos = (java.lang.System.nanoTime() + nanos) - java.lang.System.nanoTime();
                }
            }
            return semaphore.tryAcquire(i, nanos, java.util.concurrent.TimeUnit.NANOSECONDS);
        } finally {
            if (z) {
                java.lang.Thread.currentThread().interrupt();
            }
        }
    }

    @com.google.common.annotations.GwtIncompatible
    public static boolean tryAcquireUninterruptibly(java.util.concurrent.Semaphore semaphore, long j, java.util.concurrent.TimeUnit timeUnit) {
        return tryAcquireUninterruptibly(semaphore, 1, j, timeUnit);
    }
}
