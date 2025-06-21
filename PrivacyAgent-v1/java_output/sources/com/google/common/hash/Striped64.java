package com.google.common.hash;

@com.google.common.annotations.GwtIncompatible
/* loaded from: classes22.dex */
abstract class Striped64 extends java.lang.Number {
    private static final sun.misc.Unsafe UNSAFE;
    private static final long baseOffset;
    private static final long busyOffset;
    volatile transient long base;
    volatile transient int busy;

    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    volatile transient com.google.common.hash.Striped64.Cell[] cells;
    static final java.lang.ThreadLocal<int[]> threadHashCode = new java.lang.ThreadLocal<>();
    static final java.util.Random rng = new java.util.Random();
    static final int NCPU = java.lang.Runtime.getRuntime().availableProcessors();

    /* renamed from: com.google.common.hash.Striped64$1, reason: invalid class name */
    public static class AnonymousClass1 implements java.security.PrivilegedExceptionAction<sun.misc.Unsafe> {
        @Override // java.security.PrivilegedExceptionAction
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public sun.misc.Unsafe run() throws java.lang.Exception {
            for (java.lang.reflect.Field field : sun.misc.Unsafe.class.getDeclaredFields()) {
                field.setAccessible(true);
                java.lang.Object obj = field.get(null);
                if (sun.misc.Unsafe.class.isInstance(obj)) {
                    return (sun.misc.Unsafe) sun.misc.Unsafe.class.cast(obj);
                }
            }
            throw new java.lang.NoSuchFieldError("the Unsafe");
        }
    }

    public static final class Cell {
        public static final sun.misc.Unsafe b;
        public static final long c;
        public volatile long a;

        static {
            try {
                sun.misc.Unsafe unsafe = com.google.common.hash.Striped64.getUnsafe();
                b = unsafe;
                c = unsafe.objectFieldOffset(com.google.common.hash.Striped64.Cell.class.getDeclaredField("a"));
            } catch (java.lang.Exception e) {
                throw new java.lang.Error(e);
            }
        }

        public Cell(long j) {
            this.a = j;
        }

        public final boolean a(long j, long j2) {
            return b.compareAndSwapLong(this, c, j, j2);
        }
    }

    static {
        try {
            sun.misc.Unsafe unsafe = getUnsafe();
            UNSAFE = unsafe;
            baseOffset = unsafe.objectFieldOffset(com.google.common.hash.Striped64.class.getDeclaredField("base"));
            busyOffset = unsafe.objectFieldOffset(com.google.common.hash.Striped64.class.getDeclaredField("busy"));
        } catch (java.lang.Exception e) {
            throw new java.lang.Error(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static sun.misc.Unsafe getUnsafe() {
        try {
            try {
                return sun.misc.Unsafe.getUnsafe();
            } catch (java.security.PrivilegedActionException e) {
                throw new java.lang.RuntimeException("Could not initialize intrinsics", e.getCause());
            }
        } catch (java.lang.SecurityException unused) {
            return (sun.misc.Unsafe) java.security.AccessController.doPrivileged(new com.google.common.hash.Striped64.AnonymousClass1());
        }
    }

    final boolean casBase(long j, long j2) {
        return UNSAFE.compareAndSwapLong(this, baseOffset, j, j2);
    }

    final boolean casBusy() {
        return UNSAFE.compareAndSwapInt(this, busyOffset, 0, 1);
    }

    abstract long fn(long j, long j2);

    final void internalReset(long j) {
        com.google.common.hash.Striped64.Cell[] cellArr = this.cells;
        this.base = j;
        if (cellArr != null) {
            for (com.google.common.hash.Striped64.Cell cell : cellArr) {
                if (cell != null) {
                    cell.a = j;
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x00ee A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0023 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    final void retryUpdate(long j, @org.checkerframework.checker.nullness.compatqual.NullableDecl int[] iArr, boolean z) {
        int i;
        int[] iArr2;
        boolean z2;
        int length;
        boolean z3;
        int length2;
        if (iArr == null) {
            iArr2 = new int[1];
            threadHashCode.set(iArr2);
            i = rng.nextInt();
            if (i == 0) {
                i = 1;
            }
            iArr2[0] = i;
        } else {
            i = iArr[0];
            iArr2 = iArr;
        }
        int i2 = i;
        boolean z4 = false;
        boolean z5 = z;
        while (true) {
            com.google.common.hash.Striped64.Cell[] cellArr = this.cells;
            if (cellArr != null && (length = cellArr.length) > 0) {
                com.google.common.hash.Striped64.Cell cell = cellArr[(length - 1) & i2];
                if (cell == null) {
                    if (this.busy == 0) {
                        com.google.common.hash.Striped64.Cell cell2 = new com.google.common.hash.Striped64.Cell(j);
                        if (this.busy == 0 && casBusy()) {
                            try {
                                com.google.common.hash.Striped64.Cell[] cellArr2 = this.cells;
                                if (cellArr2 != null && (length2 = cellArr2.length) > 0) {
                                    int i3 = (length2 - 1) & i2;
                                    if (cellArr2[i3] == null) {
                                        cellArr2[i3] = cell2;
                                        z3 = true;
                                        if (!z3) {
                                            return;
                                        }
                                    }
                                }
                                z3 = false;
                                if (!z3) {
                                }
                            } finally {
                            }
                        }
                    }
                    z4 = false;
                } else if (z5) {
                    long j2 = cell.a;
                    if (cell.a(j2, fn(j2, j))) {
                        return;
                    }
                    if (length < NCPU && this.cells == cellArr) {
                        if (!z4) {
                            z4 = true;
                        } else if (this.busy == 0 && casBusy()) {
                            try {
                                if (this.cells == cellArr) {
                                    com.google.common.hash.Striped64.Cell[] cellArr3 = new com.google.common.hash.Striped64.Cell[length << 1];
                                    for (int i4 = 0; i4 < length; i4++) {
                                        cellArr3[i4] = cellArr[i4];
                                    }
                                    this.cells = cellArr3;
                                }
                                this.busy = 0;
                                z4 = false;
                            } finally {
                            }
                        }
                    }
                    z4 = false;
                } else {
                    z5 = true;
                }
                int i5 = i2 ^ (i2 << 13);
                int i6 = i5 ^ (i5 >>> 17);
                i2 = i6 ^ (i6 << 5);
                iArr2[0] = i2;
            } else if (this.busy == 0 && this.cells == cellArr && casBusy()) {
                try {
                    if (this.cells == cellArr) {
                        com.google.common.hash.Striped64.Cell[] cellArr4 = new com.google.common.hash.Striped64.Cell[2];
                        cellArr4[i2 & 1] = new com.google.common.hash.Striped64.Cell(j);
                        this.cells = cellArr4;
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z2) {
                        return;
                    }
                } finally {
                }
            } else {
                long j3 = this.base;
                if (casBase(j3, fn(j3, j))) {
                    return;
                }
            }
        }
    }
}
