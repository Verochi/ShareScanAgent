package com.google.common.collect;

@com.google.common.annotations.GwtCompatible(emulated = true)
/* loaded from: classes22.dex */
abstract class AbstractMapBasedMultiset<E> extends com.google.common.collect.AbstractMultiset<E> implements java.io.Serializable {

    @com.google.common.annotations.GwtIncompatible
    private static final long serialVersionUID = 0;
    transient com.google.common.collect.ObjectCountHashMap<E> backingMap;
    transient long size;

    /* renamed from: com.google.common.collect.AbstractMapBasedMultiset$1, reason: invalid class name */
    public class AnonymousClass1 extends com.google.common.collect.AbstractMapBasedMultiset<E>.Itr<E> {
        public AnonymousClass1() {
            super();
        }

        @Override // com.google.common.collect.AbstractMapBasedMultiset.Itr
        public E b(int i) {
            return com.google.common.collect.AbstractMapBasedMultiset.this.backingMap.i(i);
        }
    }

    /* renamed from: com.google.common.collect.AbstractMapBasedMultiset$2, reason: invalid class name */
    public class AnonymousClass2 extends com.google.common.collect.AbstractMapBasedMultiset<E>.Itr<com.google.common.collect.Multiset.Entry<E>> {
        public AnonymousClass2() {
            super();
        }

        @Override // com.google.common.collect.AbstractMapBasedMultiset.Itr
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public com.google.common.collect.Multiset.Entry<E> b(int i) {
            return com.google.common.collect.AbstractMapBasedMultiset.this.backingMap.g(i);
        }
    }

    public abstract class Itr<T> implements java.util.Iterator<T> {
        public int n;
        public int t = -1;
        public int u;

        public Itr() {
            this.n = com.google.common.collect.AbstractMapBasedMultiset.this.backingMap.e();
            this.u = com.google.common.collect.AbstractMapBasedMultiset.this.backingMap.d;
        }

        public final void a() {
            if (com.google.common.collect.AbstractMapBasedMultiset.this.backingMap.d != this.u) {
                throw new java.util.ConcurrentModificationException();
            }
        }

        public abstract T b(int i);

        @Override // java.util.Iterator
        public boolean hasNext() {
            a();
            return this.n >= 0;
        }

        @Override // java.util.Iterator
        public T next() {
            if (!hasNext()) {
                throw new java.util.NoSuchElementException();
            }
            T b = b(this.n);
            int i = this.n;
            this.t = i;
            this.n = com.google.common.collect.AbstractMapBasedMultiset.this.backingMap.s(i);
            return b;
        }

        @Override // java.util.Iterator
        public void remove() {
            a();
            com.google.common.collect.CollectPreconditions.e(this.t != -1);
            com.google.common.collect.AbstractMapBasedMultiset.this.size -= r0.backingMap.x(this.t);
            this.n = com.google.common.collect.AbstractMapBasedMultiset.this.backingMap.t(this.n, this.t);
            this.t = -1;
            this.u = com.google.common.collect.AbstractMapBasedMultiset.this.backingMap.d;
        }
    }

    public AbstractMapBasedMultiset(int i) {
        init(i);
    }

    @com.google.common.annotations.GwtIncompatible
    private void readObject(java.io.ObjectInputStream objectInputStream) throws java.io.IOException, java.lang.ClassNotFoundException {
        objectInputStream.defaultReadObject();
        int h = com.google.common.collect.Serialization.h(objectInputStream);
        init(3);
        com.google.common.collect.Serialization.g(this, objectInputStream, h);
    }

    @com.google.common.annotations.GwtIncompatible
    private void writeObject(java.io.ObjectOutputStream objectOutputStream) throws java.io.IOException {
        objectOutputStream.defaultWriteObject();
        com.google.common.collect.Serialization.k(this, objectOutputStream);
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public final int add(@org.checkerframework.checker.nullness.compatqual.NullableDecl E e, int i) {
        if (i == 0) {
            return count(e);
        }
        com.google.common.base.Preconditions.checkArgument(i > 0, "occurrences cannot be negative: %s", i);
        int m = this.backingMap.m(e);
        if (m == -1) {
            this.backingMap.u(e, i);
            this.size += i;
            return 0;
        }
        int k = this.backingMap.k(m);
        long j = i;
        long j2 = k + j;
        com.google.common.base.Preconditions.checkArgument(j2 <= 2147483647L, "too many occurrences: %s", j2);
        this.backingMap.B(m, (int) j2);
        this.size += j;
        return k;
    }

    public void addTo(com.google.common.collect.Multiset<? super E> multiset) {
        com.google.common.base.Preconditions.checkNotNull(multiset);
        int e = this.backingMap.e();
        while (e >= 0) {
            multiset.add(this.backingMap.i(e), this.backingMap.k(e));
            e = this.backingMap.s(e);
        }
    }

    @Override // com.google.common.collect.AbstractMultiset, java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        this.backingMap.a();
        this.size = 0L;
    }

    @Override // com.google.common.collect.Multiset
    public final int count(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        return this.backingMap.f(obj);
    }

    @Override // com.google.common.collect.AbstractMultiset
    public final int distinctElements() {
        return this.backingMap.C();
    }

    @Override // com.google.common.collect.AbstractMultiset
    public final java.util.Iterator<E> elementIterator() {
        return new com.google.common.collect.AbstractMapBasedMultiset.AnonymousClass1();
    }

    @Override // com.google.common.collect.AbstractMultiset
    public final java.util.Iterator<com.google.common.collect.Multiset.Entry<E>> entryIterator() {
        return new com.google.common.collect.AbstractMapBasedMultiset.AnonymousClass2();
    }

    public abstract void init(int i);

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, com.google.common.collect.Multiset
    public final java.util.Iterator<E> iterator() {
        return com.google.common.collect.Multisets.h(this);
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public final int remove(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj, int i) {
        if (i == 0) {
            return count(obj);
        }
        com.google.common.base.Preconditions.checkArgument(i > 0, "occurrences cannot be negative: %s", i);
        int m = this.backingMap.m(obj);
        if (m == -1) {
            return 0;
        }
        int k = this.backingMap.k(m);
        if (k > i) {
            this.backingMap.B(m, k - i);
        } else {
            this.backingMap.x(m);
            i = k;
        }
        this.size -= i;
        return k;
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public final int setCount(@org.checkerframework.checker.nullness.compatqual.NullableDecl E e, int i) {
        com.google.common.collect.CollectPreconditions.b(i, me.leolin.shortcutbadger.impl.NewHtcHomeBadger.COUNT);
        com.google.common.collect.ObjectCountHashMap<E> objectCountHashMap = this.backingMap;
        int v = i == 0 ? objectCountHashMap.v(e) : objectCountHashMap.u(e, i);
        this.size += i - v;
        return v;
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    public final boolean setCount(@org.checkerframework.checker.nullness.compatqual.NullableDecl E e, int i, int i2) {
        com.google.common.collect.CollectPreconditions.b(i, "oldCount");
        com.google.common.collect.CollectPreconditions.b(i2, "newCount");
        int m = this.backingMap.m(e);
        if (m == -1) {
            if (i != 0) {
                return false;
            }
            if (i2 > 0) {
                this.backingMap.u(e, i2);
                this.size += i2;
            }
            return true;
        }
        if (this.backingMap.k(m) != i) {
            return false;
        }
        if (i2 == 0) {
            this.backingMap.x(m);
            this.size -= i;
        } else {
            this.backingMap.B(m, i2);
            this.size += i2 - i;
        }
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    public final int size() {
        return com.google.common.primitives.Ints.saturatedCast(this.size);
    }
}
