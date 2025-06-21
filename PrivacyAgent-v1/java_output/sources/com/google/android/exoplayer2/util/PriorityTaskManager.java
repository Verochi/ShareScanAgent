package com.google.android.exoplayer2.util;

/* loaded from: classes22.dex */
public final class PriorityTaskManager {
    public final java.lang.Object a = new java.lang.Object();
    public final java.util.PriorityQueue<java.lang.Integer> b = new java.util.PriorityQueue<>(10, java.util.Collections.reverseOrder());
    public int c = Integer.MIN_VALUE;

    public static class PriorityTooLowException extends java.io.IOException {
        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public PriorityTooLowException(int i, int i2) {
            super(r0.toString());
            java.lang.StringBuilder sb = new java.lang.StringBuilder(60);
            sb.append("Priority too low [priority=");
            sb.append(i);
            sb.append(", highest=");
            sb.append(i2);
            sb.append("]");
        }
    }

    public void add(int i) {
        synchronized (this.a) {
            this.b.add(java.lang.Integer.valueOf(i));
            this.c = java.lang.Math.max(this.c, i);
        }
    }

    public void proceed(int i) throws java.lang.InterruptedException {
        synchronized (this.a) {
            while (this.c != i) {
                this.a.wait();
            }
        }
    }

    public boolean proceedNonBlocking(int i) {
        boolean z;
        synchronized (this.a) {
            z = this.c == i;
        }
        return z;
    }

    public void proceedOrThrow(int i) throws com.google.android.exoplayer2.util.PriorityTaskManager.PriorityTooLowException {
        synchronized (this.a) {
            if (this.c != i) {
                throw new com.google.android.exoplayer2.util.PriorityTaskManager.PriorityTooLowException(i, this.c);
            }
        }
    }

    public void remove(int i) {
        synchronized (this.a) {
            this.b.remove(java.lang.Integer.valueOf(i));
            this.c = this.b.isEmpty() ? Integer.MIN_VALUE : ((java.lang.Integer) com.google.android.exoplayer2.util.Util.castNonNull(this.b.peek())).intValue();
            this.a.notifyAll();
        }
    }
}
