package com.google.common.base;

@com.google.common.annotations.GwtCompatible
/* loaded from: classes22.dex */
abstract class AbstractIterator<T> implements java.util.Iterator<T> {
    public com.google.common.base.AbstractIterator.State n = com.google.common.base.AbstractIterator.State.NOT_READY;

    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    public T t;

    /* renamed from: com.google.common.base.AbstractIterator$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[com.google.common.base.AbstractIterator.State.values().length];
            a = iArr;
            try {
                iArr[com.google.common.base.AbstractIterator.State.READY.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                a[com.google.common.base.AbstractIterator.State.DONE.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
        }
    }

    public enum State {
        READY,
        NOT_READY,
        DONE,
        FAILED
    }

    public abstract T a();

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    public final T b() {
        this.n = com.google.common.base.AbstractIterator.State.DONE;
        return null;
    }

    public final boolean c() {
        this.n = com.google.common.base.AbstractIterator.State.FAILED;
        this.t = a();
        if (this.n == com.google.common.base.AbstractIterator.State.DONE) {
            return false;
        }
        this.n = com.google.common.base.AbstractIterator.State.READY;
        return true;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        com.google.common.base.Preconditions.checkState(this.n != com.google.common.base.AbstractIterator.State.FAILED);
        int i = com.google.common.base.AbstractIterator.AnonymousClass1.a[this.n.ordinal()];
        if (i == 1) {
            return true;
        }
        if (i != 2) {
            return c();
        }
        return false;
    }

    @Override // java.util.Iterator
    public final T next() {
        if (!hasNext()) {
            throw new java.util.NoSuchElementException();
        }
        this.n = com.google.common.base.AbstractIterator.State.NOT_READY;
        T t = this.t;
        this.t = null;
        return t;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new java.lang.UnsupportedOperationException();
    }
}
