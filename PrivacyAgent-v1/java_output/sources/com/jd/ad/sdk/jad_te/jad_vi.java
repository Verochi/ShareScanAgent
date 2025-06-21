package com.jd.ad.sdk.jad_te;

/* loaded from: classes23.dex */
public final class jad_vi {
    public static final android.graphics.Paint jad_an = new android.graphics.Paint(6);
    public static final java.util.concurrent.locks.Lock jad_bo;

    public static final class jad_an implements java.util.concurrent.locks.Lock {
        @Override // java.util.concurrent.locks.Lock
        public void lock() {
        }

        @Override // java.util.concurrent.locks.Lock
        public void lockInterruptibly() {
        }

        @Override // java.util.concurrent.locks.Lock
        @androidx.annotation.NonNull
        public java.util.concurrent.locks.Condition newCondition() {
            throw new java.lang.UnsupportedOperationException("Should not be called");
        }

        @Override // java.util.concurrent.locks.Lock
        public boolean tryLock() {
            return true;
        }

        @Override // java.util.concurrent.locks.Lock
        public boolean tryLock(long j, @androidx.annotation.NonNull java.util.concurrent.TimeUnit timeUnit) {
            return true;
        }

        @Override // java.util.concurrent.locks.Lock
        public void unlock() {
        }
    }

    static {
        new android.graphics.Paint(7);
        jad_bo = new java.util.HashSet(java.util.Arrays.asList("XT1085", "XT1092", "XT1093", "XT1094", "XT1095", "XT1096", "XT1097", "XT1098", "XT1031", "XT1028", "XT937C", "XT1032", "XT1008", "XT1033", "XT1035", "XT1034", "XT939G", "XT1039", "XT1040", "XT1042", "XT1045", "XT1063", "XT1064", "XT1068", "XT1069", "XT1072", "XT1077", "XT1078", "XT1079")).contains(android.os.Build.MODEL) ? new java.util.concurrent.locks.ReentrantLock() : new com.jd.ad.sdk.jad_te.jad_vi.jad_an();
        new android.graphics.Paint(7).setXfermode(new android.graphics.PorterDuffXfermode(android.graphics.PorterDuff.Mode.SRC_IN));
    }
}
