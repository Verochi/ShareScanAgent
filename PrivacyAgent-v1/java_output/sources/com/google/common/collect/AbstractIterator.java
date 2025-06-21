package com.google.common.collect;

@com.google.common.annotations.GwtCompatible
/* loaded from: classes22.dex */
public abstract class AbstractIterator<T> extends com.google.common.collect.UnmodifiableIterator<T> {
    public com.google.common.collect.AbstractIterator.State n = com.google.common.collect.AbstractIterator.State.NOT_READY;

    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    public T t;

    /* renamed from: com.google.common.collect.AbstractIterator$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[com.google.common.collect.AbstractIterator.State.values().length];
            a = iArr;
            try {
                iArr[com.google.common.collect.AbstractIterator.State.DONE.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                a[com.google.common.collect.AbstractIterator.State.READY.ordinal()] = 2;
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

    public final boolean a() {
        this.n = com.google.common.collect.AbstractIterator.State.FAILED;
        this.t = computeNext();
        if (this.n == com.google.common.collect.AbstractIterator.State.DONE) {
            return false;
        }
        this.n = com.google.common.collect.AbstractIterator.State.READY;
        return true;
    }

    public abstract T computeNext();

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public final T endOfData() {
        this.n = com.google.common.collect.AbstractIterator.State.DONE;
        return null;
    }

    @Override // java.util.Iterator
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public final boolean hasNext() {
        com.google.common.base.Preconditions.checkState(this.n != com.google.common.collect.AbstractIterator.State.FAILED);
        int i = com.google.common.collect.AbstractIterator.AnonymousClass1.a[this.n.ordinal()];
        if (i == 1) {
            return false;
        }
        if (i != 2) {
            return a();
        }
        return true;
    }

    @Override // java.util.Iterator
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public final T next() {
        if (!hasNext()) {
            throw new java.util.NoSuchElementException();
        }
        this.n = com.google.common.collect.AbstractIterator.State.NOT_READY;
        T t = this.t;
        this.t = null;
        return t;
    }

    public final T peek() {
        if (hasNext()) {
            return this.t;
        }
        throw new java.util.NoSuchElementException();
    }
}
