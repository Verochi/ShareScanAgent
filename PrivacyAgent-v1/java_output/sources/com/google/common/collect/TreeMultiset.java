package com.google.common.collect;

@com.google.common.annotations.GwtCompatible(emulated = true)
/* loaded from: classes22.dex */
public final class TreeMultiset<E> extends com.google.common.collect.AbstractSortedMultiset<E> implements java.io.Serializable {

    @com.google.common.annotations.GwtIncompatible
    private static final long serialVersionUID = 1;
    private final transient com.google.common.collect.TreeMultiset.AvlNode<E> header;
    private final transient com.google.common.collect.GeneralRange<E> range;
    private final transient com.google.common.collect.TreeMultiset.Reference<com.google.common.collect.TreeMultiset.AvlNode<E>> rootReference;

    /* renamed from: com.google.common.collect.TreeMultiset$1, reason: invalid class name */
    public class AnonymousClass1 extends com.google.common.collect.Multisets.AbstractEntry<E> {
        public final /* synthetic */ com.google.common.collect.TreeMultiset.AvlNode n;

        public AnonymousClass1(com.google.common.collect.TreeMultiset.AvlNode avlNode) {
            this.n = avlNode;
        }

        @Override // com.google.common.collect.Multiset.Entry
        public int getCount() {
            int x = this.n.x();
            return x == 0 ? com.google.common.collect.TreeMultiset.this.count(getElement()) : x;
        }

        @Override // com.google.common.collect.Multiset.Entry
        public E getElement() {
            return (E) this.n.y();
        }
    }

    /* renamed from: com.google.common.collect.TreeMultiset$2, reason: invalid class name */
    public class AnonymousClass2 implements java.util.Iterator<com.google.common.collect.Multiset.Entry<E>> {
        public com.google.common.collect.TreeMultiset.AvlNode<E> n;

        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        public com.google.common.collect.Multiset.Entry<E> t;

        public AnonymousClass2() {
            this.n = com.google.common.collect.TreeMultiset.this.firstNode();
        }

        @Override // java.util.Iterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.google.common.collect.Multiset.Entry<E> next() {
            if (!hasNext()) {
                throw new java.util.NoSuchElementException();
            }
            com.google.common.collect.Multiset.Entry<E> wrapEntry = com.google.common.collect.TreeMultiset.this.wrapEntry(this.n);
            this.t = wrapEntry;
            if (this.n.i == com.google.common.collect.TreeMultiset.this.header) {
                this.n = null;
            } else {
                this.n = this.n.i;
            }
            return wrapEntry;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.n == null) {
                return false;
            }
            if (!com.google.common.collect.TreeMultiset.this.range.tooHigh(this.n.y())) {
                return true;
            }
            this.n = null;
            return false;
        }

        @Override // java.util.Iterator
        public void remove() {
            com.google.common.collect.CollectPreconditions.e(this.t != null);
            com.google.common.collect.TreeMultiset.this.setCount(this.t.getElement(), 0);
            this.t = null;
        }
    }

    /* renamed from: com.google.common.collect.TreeMultiset$3, reason: invalid class name */
    public class AnonymousClass3 implements java.util.Iterator<com.google.common.collect.Multiset.Entry<E>> {
        public com.google.common.collect.TreeMultiset.AvlNode<E> n;
        public com.google.common.collect.Multiset.Entry<E> t = null;

        public AnonymousClass3() {
            this.n = com.google.common.collect.TreeMultiset.this.lastNode();
        }

        @Override // java.util.Iterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.google.common.collect.Multiset.Entry<E> next() {
            if (!hasNext()) {
                throw new java.util.NoSuchElementException();
            }
            com.google.common.collect.Multiset.Entry<E> wrapEntry = com.google.common.collect.TreeMultiset.this.wrapEntry(this.n);
            this.t = wrapEntry;
            if (this.n.h == com.google.common.collect.TreeMultiset.this.header) {
                this.n = null;
            } else {
                this.n = this.n.h;
            }
            return wrapEntry;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.n == null) {
                return false;
            }
            if (!com.google.common.collect.TreeMultiset.this.range.tooLow(this.n.y())) {
                return true;
            }
            this.n = null;
            return false;
        }

        @Override // java.util.Iterator
        public void remove() {
            com.google.common.collect.CollectPreconditions.e(this.t != null);
            com.google.common.collect.TreeMultiset.this.setCount(this.t.getElement(), 0);
            this.t = null;
        }
    }

    /* renamed from: com.google.common.collect.TreeMultiset$4, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass4 {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[com.google.common.collect.BoundType.values().length];
            a = iArr;
            try {
                iArr[com.google.common.collect.BoundType.OPEN.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                a[com.google.common.collect.BoundType.CLOSED.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static abstract class Aggregate {
        private static final /* synthetic */ com.google.common.collect.TreeMultiset.Aggregate[] $VALUES;
        public static final com.google.common.collect.TreeMultiset.Aggregate DISTINCT;
        public static final com.google.common.collect.TreeMultiset.Aggregate SIZE;

        /* renamed from: com.google.common.collect.TreeMultiset$Aggregate$1, reason: invalid class name */
        public enum AnonymousClass1 extends com.google.common.collect.TreeMultiset.Aggregate {
            public AnonymousClass1(java.lang.String str, int i) {
                super(str, i, null);
            }

            @Override // com.google.common.collect.TreeMultiset.Aggregate
            public int nodeAggregate(com.google.common.collect.TreeMultiset.AvlNode<?> avlNode) {
                return avlNode.b;
            }

            @Override // com.google.common.collect.TreeMultiset.Aggregate
            public long treeAggregate(@org.checkerframework.checker.nullness.compatqual.NullableDecl com.google.common.collect.TreeMultiset.AvlNode<?> avlNode) {
                if (avlNode == null) {
                    return 0L;
                }
                return avlNode.d;
            }
        }

        /* renamed from: com.google.common.collect.TreeMultiset$Aggregate$2, reason: invalid class name */
        public enum AnonymousClass2 extends com.google.common.collect.TreeMultiset.Aggregate {
            public AnonymousClass2(java.lang.String str, int i) {
                super(str, i, null);
            }

            @Override // com.google.common.collect.TreeMultiset.Aggregate
            public int nodeAggregate(com.google.common.collect.TreeMultiset.AvlNode<?> avlNode) {
                return 1;
            }

            @Override // com.google.common.collect.TreeMultiset.Aggregate
            public long treeAggregate(@org.checkerframework.checker.nullness.compatqual.NullableDecl com.google.common.collect.TreeMultiset.AvlNode<?> avlNode) {
                if (avlNode == null) {
                    return 0L;
                }
                return avlNode.c;
            }
        }

        static {
            com.google.common.collect.TreeMultiset.Aggregate.AnonymousClass1 anonymousClass1 = new com.google.common.collect.TreeMultiset.Aggregate.AnonymousClass1("SIZE", 0);
            SIZE = anonymousClass1;
            com.google.common.collect.TreeMultiset.Aggregate.AnonymousClass2 anonymousClass2 = new com.google.common.collect.TreeMultiset.Aggregate.AnonymousClass2("DISTINCT", 1);
            DISTINCT = anonymousClass2;
            $VALUES = new com.google.common.collect.TreeMultiset.Aggregate[]{anonymousClass1, anonymousClass2};
        }

        private Aggregate(java.lang.String str, int i) {
        }

        public /* synthetic */ Aggregate(java.lang.String str, int i, com.google.common.collect.TreeMultiset.AnonymousClass1 anonymousClass1) {
            this(str, i);
        }

        public static com.google.common.collect.TreeMultiset.Aggregate valueOf(java.lang.String str) {
            return (com.google.common.collect.TreeMultiset.Aggregate) java.lang.Enum.valueOf(com.google.common.collect.TreeMultiset.Aggregate.class, str);
        }

        public static com.google.common.collect.TreeMultiset.Aggregate[] values() {
            return (com.google.common.collect.TreeMultiset.Aggregate[]) $VALUES.clone();
        }

        public abstract int nodeAggregate(com.google.common.collect.TreeMultiset.AvlNode<?> avlNode);

        public abstract long treeAggregate(@org.checkerframework.checker.nullness.compatqual.NullableDecl com.google.common.collect.TreeMultiset.AvlNode<?> avlNode);
    }

    public static final class AvlNode<E> {

        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        public final E a;
        public int b;
        public int c;
        public long d;
        public int e;

        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        public com.google.common.collect.TreeMultiset.AvlNode<E> f;

        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        public com.google.common.collect.TreeMultiset.AvlNode<E> g;

        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        public com.google.common.collect.TreeMultiset.AvlNode<E> h;

        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        public com.google.common.collect.TreeMultiset.AvlNode<E> i;

        public AvlNode(@org.checkerframework.checker.nullness.compatqual.NullableDecl E e, int i) {
            com.google.common.base.Preconditions.checkArgument(i > 0);
            this.a = e;
            this.b = i;
            this.d = i;
            this.c = 1;
            this.e = 1;
            this.f = null;
            this.g = null;
        }

        public static long L(@org.checkerframework.checker.nullness.compatqual.NullableDecl com.google.common.collect.TreeMultiset.AvlNode<?> avlNode) {
            if (avlNode == null) {
                return 0L;
            }
            return avlNode.d;
        }

        public static int z(@org.checkerframework.checker.nullness.compatqual.NullableDecl com.google.common.collect.TreeMultiset.AvlNode<?> avlNode) {
            if (avlNode == null) {
                return 0;
            }
            return avlNode.e;
        }

        public final com.google.common.collect.TreeMultiset.AvlNode<E> A() {
            int s2 = s();
            if (s2 == -2) {
                if (this.g.s() > 0) {
                    this.g = this.g.I();
                }
                return H();
            }
            if (s2 != 2) {
                C();
                return this;
            }
            if (this.f.s() < 0) {
                this.f = this.f.H();
            }
            return I();
        }

        public final void B() {
            D();
            C();
        }

        public final void C() {
            this.e = java.lang.Math.max(z(this.f), z(this.g)) + 1;
        }

        public final void D() {
            this.c = com.google.common.collect.TreeMultiset.distinctElements(this.f) + 1 + com.google.common.collect.TreeMultiset.distinctElements(this.g);
            this.d = this.b + L(this.f) + L(this.g);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public com.google.common.collect.TreeMultiset.AvlNode<E> E(java.util.Comparator<? super E> comparator, @org.checkerframework.checker.nullness.compatqual.NullableDecl E e, int i, int[] iArr) {
            int compare = comparator.compare(e, this.a);
            if (compare < 0) {
                com.google.common.collect.TreeMultiset.AvlNode<E> avlNode = this.f;
                if (avlNode == null) {
                    iArr[0] = 0;
                    return this;
                }
                this.f = avlNode.E(comparator, e, i, iArr);
                int i2 = iArr[0];
                if (i2 > 0) {
                    if (i >= i2) {
                        this.c--;
                        this.d -= i2;
                    } else {
                        this.d -= i;
                    }
                }
                return i2 == 0 ? this : A();
            }
            if (compare <= 0) {
                int i3 = this.b;
                iArr[0] = i3;
                if (i >= i3) {
                    return v();
                }
                this.b = i3 - i;
                this.d -= i;
                return this;
            }
            com.google.common.collect.TreeMultiset.AvlNode<E> avlNode2 = this.g;
            if (avlNode2 == null) {
                iArr[0] = 0;
                return this;
            }
            this.g = avlNode2.E(comparator, e, i, iArr);
            int i4 = iArr[0];
            if (i4 > 0) {
                if (i >= i4) {
                    this.c--;
                    this.d -= i4;
                } else {
                    this.d -= i;
                }
            }
            return A();
        }

        public final com.google.common.collect.TreeMultiset.AvlNode<E> F(com.google.common.collect.TreeMultiset.AvlNode<E> avlNode) {
            com.google.common.collect.TreeMultiset.AvlNode<E> avlNode2 = this.g;
            if (avlNode2 == null) {
                return this.f;
            }
            this.g = avlNode2.F(avlNode);
            this.c--;
            this.d -= avlNode.b;
            return A();
        }

        public final com.google.common.collect.TreeMultiset.AvlNode<E> G(com.google.common.collect.TreeMultiset.AvlNode<E> avlNode) {
            com.google.common.collect.TreeMultiset.AvlNode<E> avlNode2 = this.f;
            if (avlNode2 == null) {
                return this.g;
            }
            this.f = avlNode2.G(avlNode);
            this.c--;
            this.d -= avlNode.b;
            return A();
        }

        public final com.google.common.collect.TreeMultiset.AvlNode<E> H() {
            com.google.common.base.Preconditions.checkState(this.g != null);
            com.google.common.collect.TreeMultiset.AvlNode<E> avlNode = this.g;
            this.g = avlNode.f;
            avlNode.f = this;
            avlNode.d = this.d;
            avlNode.c = this.c;
            B();
            avlNode.C();
            return avlNode;
        }

        public final com.google.common.collect.TreeMultiset.AvlNode<E> I() {
            com.google.common.base.Preconditions.checkState(this.f != null);
            com.google.common.collect.TreeMultiset.AvlNode<E> avlNode = this.f;
            this.f = avlNode.g;
            avlNode.g = this;
            avlNode.d = this.d;
            avlNode.c = this.c;
            B();
            avlNode.C();
            return avlNode;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public com.google.common.collect.TreeMultiset.AvlNode<E> J(java.util.Comparator<? super E> comparator, @org.checkerframework.checker.nullness.compatqual.NullableDecl E e, int i, int i2, int[] iArr) {
            int compare = comparator.compare(e, this.a);
            if (compare < 0) {
                com.google.common.collect.TreeMultiset.AvlNode<E> avlNode = this.f;
                if (avlNode == null) {
                    iArr[0] = 0;
                    return (i != 0 || i2 <= 0) ? this : q(e, i2);
                }
                this.f = avlNode.J(comparator, e, i, i2, iArr);
                int i3 = iArr[0];
                if (i3 == i) {
                    if (i2 == 0 && i3 != 0) {
                        this.c--;
                    } else if (i2 > 0 && i3 == 0) {
                        this.c++;
                    }
                    this.d += i2 - i3;
                }
                return A();
            }
            if (compare <= 0) {
                int i4 = this.b;
                iArr[0] = i4;
                if (i == i4) {
                    if (i2 == 0) {
                        return v();
                    }
                    this.d += i2 - i4;
                    this.b = i2;
                }
                return this;
            }
            com.google.common.collect.TreeMultiset.AvlNode<E> avlNode2 = this.g;
            if (avlNode2 == null) {
                iArr[0] = 0;
                return (i != 0 || i2 <= 0) ? this : r(e, i2);
            }
            this.g = avlNode2.J(comparator, e, i, i2, iArr);
            int i5 = iArr[0];
            if (i5 == i) {
                if (i2 == 0 && i5 != 0) {
                    this.c--;
                } else if (i2 > 0 && i5 == 0) {
                    this.c++;
                }
                this.d += i2 - i5;
            }
            return A();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public com.google.common.collect.TreeMultiset.AvlNode<E> K(java.util.Comparator<? super E> comparator, @org.checkerframework.checker.nullness.compatqual.NullableDecl E e, int i, int[] iArr) {
            int compare = comparator.compare(e, this.a);
            if (compare < 0) {
                com.google.common.collect.TreeMultiset.AvlNode<E> avlNode = this.f;
                if (avlNode == null) {
                    iArr[0] = 0;
                    return i > 0 ? q(e, i) : this;
                }
                this.f = avlNode.K(comparator, e, i, iArr);
                if (i == 0 && iArr[0] != 0) {
                    this.c--;
                } else if (i > 0 && iArr[0] == 0) {
                    this.c++;
                }
                this.d += i - iArr[0];
                return A();
            }
            if (compare <= 0) {
                iArr[0] = this.b;
                if (i == 0) {
                    return v();
                }
                this.d += i - r3;
                this.b = i;
                return this;
            }
            com.google.common.collect.TreeMultiset.AvlNode<E> avlNode2 = this.g;
            if (avlNode2 == null) {
                iArr[0] = 0;
                return i > 0 ? r(e, i) : this;
            }
            this.g = avlNode2.K(comparator, e, i, iArr);
            if (i == 0 && iArr[0] != 0) {
                this.c--;
            } else if (i > 0 && iArr[0] == 0) {
                this.c++;
            }
            this.d += i - iArr[0];
            return A();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public com.google.common.collect.TreeMultiset.AvlNode<E> p(java.util.Comparator<? super E> comparator, @org.checkerframework.checker.nullness.compatqual.NullableDecl E e, int i, int[] iArr) {
            int compare = comparator.compare(e, this.a);
            if (compare < 0) {
                com.google.common.collect.TreeMultiset.AvlNode<E> avlNode = this.f;
                if (avlNode == null) {
                    iArr[0] = 0;
                    return q(e, i);
                }
                int i2 = avlNode.e;
                com.google.common.collect.TreeMultiset.AvlNode<E> p = avlNode.p(comparator, e, i, iArr);
                this.f = p;
                if (iArr[0] == 0) {
                    this.c++;
                }
                this.d += i;
                return p.e == i2 ? this : A();
            }
            if (compare <= 0) {
                int i3 = this.b;
                iArr[0] = i3;
                long j = i;
                com.google.common.base.Preconditions.checkArgument(((long) i3) + j <= 2147483647L);
                this.b += i;
                this.d += j;
                return this;
            }
            com.google.common.collect.TreeMultiset.AvlNode<E> avlNode2 = this.g;
            if (avlNode2 == null) {
                iArr[0] = 0;
                return r(e, i);
            }
            int i4 = avlNode2.e;
            com.google.common.collect.TreeMultiset.AvlNode<E> p2 = avlNode2.p(comparator, e, i, iArr);
            this.g = p2;
            if (iArr[0] == 0) {
                this.c++;
            }
            this.d += i;
            return p2.e == i4 ? this : A();
        }

        public final com.google.common.collect.TreeMultiset.AvlNode<E> q(E e, int i) {
            com.google.common.collect.TreeMultiset.AvlNode<E> avlNode = new com.google.common.collect.TreeMultiset.AvlNode<>(e, i);
            this.f = avlNode;
            com.google.common.collect.TreeMultiset.successor(this.h, avlNode, this);
            this.e = java.lang.Math.max(2, this.e);
            this.c++;
            this.d += i;
            return this;
        }

        public final com.google.common.collect.TreeMultiset.AvlNode<E> r(E e, int i) {
            com.google.common.collect.TreeMultiset.AvlNode<E> avlNode = new com.google.common.collect.TreeMultiset.AvlNode<>(e, i);
            this.g = avlNode;
            com.google.common.collect.TreeMultiset.successor(this, avlNode, this.i);
            this.e = java.lang.Math.max(2, this.e);
            this.c++;
            this.d += i;
            return this;
        }

        public final int s() {
            return z(this.f) - z(this.g);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        public final com.google.common.collect.TreeMultiset.AvlNode<E> t(java.util.Comparator<? super E> comparator, E e) {
            int compare = comparator.compare(e, this.a);
            if (compare < 0) {
                com.google.common.collect.TreeMultiset.AvlNode<E> avlNode = this.f;
                return avlNode == null ? this : (com.google.common.collect.TreeMultiset.AvlNode) com.google.common.base.MoreObjects.firstNonNull(avlNode.t(comparator, e), this);
            }
            if (compare == 0) {
                return this;
            }
            com.google.common.collect.TreeMultiset.AvlNode<E> avlNode2 = this.g;
            if (avlNode2 == null) {
                return null;
            }
            return avlNode2.t(comparator, e);
        }

        public java.lang.String toString() {
            return com.google.common.collect.Multisets.immutableEntry(y(), x()).toString();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int u(java.util.Comparator<? super E> comparator, E e) {
            int compare = comparator.compare(e, this.a);
            if (compare < 0) {
                com.google.common.collect.TreeMultiset.AvlNode<E> avlNode = this.f;
                if (avlNode == null) {
                    return 0;
                }
                return avlNode.u(comparator, e);
            }
            if (compare <= 0) {
                return this.b;
            }
            com.google.common.collect.TreeMultiset.AvlNode<E> avlNode2 = this.g;
            if (avlNode2 == null) {
                return 0;
            }
            return avlNode2.u(comparator, e);
        }

        public final com.google.common.collect.TreeMultiset.AvlNode<E> v() {
            int i = this.b;
            this.b = 0;
            com.google.common.collect.TreeMultiset.successor(this.h, this.i);
            com.google.common.collect.TreeMultiset.AvlNode<E> avlNode = this.f;
            if (avlNode == null) {
                return this.g;
            }
            com.google.common.collect.TreeMultiset.AvlNode<E> avlNode2 = this.g;
            if (avlNode2 == null) {
                return avlNode;
            }
            if (avlNode.e >= avlNode2.e) {
                com.google.common.collect.TreeMultiset.AvlNode<E> avlNode3 = this.h;
                avlNode3.f = avlNode.F(avlNode3);
                avlNode3.g = this.g;
                avlNode3.c = this.c - 1;
                avlNode3.d = this.d - i;
                return avlNode3.A();
            }
            com.google.common.collect.TreeMultiset.AvlNode<E> avlNode4 = this.i;
            avlNode4.g = avlNode2.G(avlNode4);
            avlNode4.f = this.f;
            avlNode4.c = this.c - 1;
            avlNode4.d = this.d - i;
            return avlNode4.A();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        public final com.google.common.collect.TreeMultiset.AvlNode<E> w(java.util.Comparator<? super E> comparator, E e) {
            int compare = comparator.compare(e, this.a);
            if (compare > 0) {
                com.google.common.collect.TreeMultiset.AvlNode<E> avlNode = this.g;
                return avlNode == null ? this : (com.google.common.collect.TreeMultiset.AvlNode) com.google.common.base.MoreObjects.firstNonNull(avlNode.w(comparator, e), this);
            }
            if (compare == 0) {
                return this;
            }
            com.google.common.collect.TreeMultiset.AvlNode<E> avlNode2 = this.f;
            if (avlNode2 == null) {
                return null;
            }
            return avlNode2.w(comparator, e);
        }

        public int x() {
            return this.b;
        }

        public E y() {
            return this.a;
        }
    }

    public static final class Reference<T> {

        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        public T a;

        public Reference() {
        }

        public /* synthetic */ Reference(com.google.common.collect.TreeMultiset.AnonymousClass1 anonymousClass1) {
            this();
        }

        public void a(@org.checkerframework.checker.nullness.compatqual.NullableDecl T t, T t2) {
            if (this.a != t) {
                throw new java.util.ConcurrentModificationException();
            }
            this.a = t2;
        }

        public void b() {
            this.a = null;
        }

        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        public T c() {
            return this.a;
        }
    }

    public TreeMultiset(com.google.common.collect.TreeMultiset.Reference<com.google.common.collect.TreeMultiset.AvlNode<E>> reference, com.google.common.collect.GeneralRange<E> generalRange, com.google.common.collect.TreeMultiset.AvlNode<E> avlNode) {
        super(generalRange.comparator());
        this.rootReference = reference;
        this.range = generalRange;
        this.header = avlNode;
    }

    public TreeMultiset(java.util.Comparator<? super E> comparator) {
        super(comparator);
        this.range = com.google.common.collect.GeneralRange.all(comparator);
        com.google.common.collect.TreeMultiset.AvlNode<E> avlNode = new com.google.common.collect.TreeMultiset.AvlNode<>(null, 1);
        this.header = avlNode;
        successor(avlNode, avlNode);
        this.rootReference = new com.google.common.collect.TreeMultiset.Reference<>(null);
    }

    private long aggregateAboveRange(com.google.common.collect.TreeMultiset.Aggregate aggregate, @org.checkerframework.checker.nullness.compatqual.NullableDecl com.google.common.collect.TreeMultiset.AvlNode<E> avlNode) {
        long treeAggregate;
        long aggregateAboveRange;
        if (avlNode == null) {
            return 0L;
        }
        int compare = comparator().compare(this.range.getUpperEndpoint(), avlNode.a);
        if (compare > 0) {
            return aggregateAboveRange(aggregate, avlNode.g);
        }
        if (compare == 0) {
            int i = com.google.common.collect.TreeMultiset.AnonymousClass4.a[this.range.getUpperBoundType().ordinal()];
            if (i != 1) {
                if (i == 2) {
                    return aggregate.treeAggregate(avlNode.g);
                }
                throw new java.lang.AssertionError();
            }
            treeAggregate = aggregate.nodeAggregate(avlNode);
            aggregateAboveRange = aggregate.treeAggregate(avlNode.g);
        } else {
            treeAggregate = aggregate.treeAggregate(avlNode.g) + aggregate.nodeAggregate(avlNode);
            aggregateAboveRange = aggregateAboveRange(aggregate, avlNode.f);
        }
        return treeAggregate + aggregateAboveRange;
    }

    private long aggregateBelowRange(com.google.common.collect.TreeMultiset.Aggregate aggregate, @org.checkerframework.checker.nullness.compatqual.NullableDecl com.google.common.collect.TreeMultiset.AvlNode<E> avlNode) {
        long treeAggregate;
        long aggregateBelowRange;
        if (avlNode == null) {
            return 0L;
        }
        int compare = comparator().compare(this.range.getLowerEndpoint(), avlNode.a);
        if (compare < 0) {
            return aggregateBelowRange(aggregate, avlNode.f);
        }
        if (compare == 0) {
            int i = com.google.common.collect.TreeMultiset.AnonymousClass4.a[this.range.getLowerBoundType().ordinal()];
            if (i != 1) {
                if (i == 2) {
                    return aggregate.treeAggregate(avlNode.f);
                }
                throw new java.lang.AssertionError();
            }
            treeAggregate = aggregate.nodeAggregate(avlNode);
            aggregateBelowRange = aggregate.treeAggregate(avlNode.f);
        } else {
            treeAggregate = aggregate.treeAggregate(avlNode.f) + aggregate.nodeAggregate(avlNode);
            aggregateBelowRange = aggregateBelowRange(aggregate, avlNode.g);
        }
        return treeAggregate + aggregateBelowRange;
    }

    private long aggregateForEntries(com.google.common.collect.TreeMultiset.Aggregate aggregate) {
        com.google.common.collect.TreeMultiset.AvlNode<E> c = this.rootReference.c();
        long treeAggregate = aggregate.treeAggregate(c);
        if (this.range.hasLowerBound()) {
            treeAggregate -= aggregateBelowRange(aggregate, c);
        }
        return this.range.hasUpperBound() ? treeAggregate - aggregateAboveRange(aggregate, c) : treeAggregate;
    }

    public static <E extends java.lang.Comparable> com.google.common.collect.TreeMultiset<E> create() {
        return new com.google.common.collect.TreeMultiset<>(com.google.common.collect.Ordering.natural());
    }

    public static <E extends java.lang.Comparable> com.google.common.collect.TreeMultiset<E> create(java.lang.Iterable<? extends E> iterable) {
        com.google.common.collect.TreeMultiset<E> create = create();
        com.google.common.collect.Iterables.addAll(create, iterable);
        return create;
    }

    public static <E> com.google.common.collect.TreeMultiset<E> create(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.util.Comparator<? super E> comparator) {
        return comparator == null ? new com.google.common.collect.TreeMultiset<>(com.google.common.collect.Ordering.natural()) : new com.google.common.collect.TreeMultiset<>(comparator);
    }

    public static int distinctElements(@org.checkerframework.checker.nullness.compatqual.NullableDecl com.google.common.collect.TreeMultiset.AvlNode<?> avlNode) {
        if (avlNode == null) {
            return 0;
        }
        return avlNode.c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    public com.google.common.collect.TreeMultiset.AvlNode<E> firstNode() {
        com.google.common.collect.TreeMultiset.AvlNode<E> avlNode;
        if (this.rootReference.c() == null) {
            return null;
        }
        if (this.range.hasLowerBound()) {
            E lowerEndpoint = this.range.getLowerEndpoint();
            avlNode = this.rootReference.c().t(comparator(), lowerEndpoint);
            if (avlNode == null) {
                return null;
            }
            if (this.range.getLowerBoundType() == com.google.common.collect.BoundType.OPEN && comparator().compare(lowerEndpoint, avlNode.y()) == 0) {
                avlNode = avlNode.i;
            }
        } else {
            avlNode = this.header.i;
        }
        if (avlNode == this.header || !this.range.contains(avlNode.y())) {
            return null;
        }
        return avlNode;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    public com.google.common.collect.TreeMultiset.AvlNode<E> lastNode() {
        com.google.common.collect.TreeMultiset.AvlNode<E> avlNode;
        if (this.rootReference.c() == null) {
            return null;
        }
        if (this.range.hasUpperBound()) {
            E upperEndpoint = this.range.getUpperEndpoint();
            avlNode = this.rootReference.c().w(comparator(), upperEndpoint);
            if (avlNode == null) {
                return null;
            }
            if (this.range.getUpperBoundType() == com.google.common.collect.BoundType.OPEN && comparator().compare(upperEndpoint, avlNode.y()) == 0) {
                avlNode = avlNode.h;
            }
        } else {
            avlNode = this.header.h;
        }
        if (avlNode == this.header || !this.range.contains(avlNode.y())) {
            return null;
        }
        return avlNode;
    }

    @com.google.common.annotations.GwtIncompatible
    private void readObject(java.io.ObjectInputStream objectInputStream) throws java.io.IOException, java.lang.ClassNotFoundException {
        objectInputStream.defaultReadObject();
        java.util.Comparator comparator = (java.util.Comparator) objectInputStream.readObject();
        com.google.common.collect.Serialization.a(com.google.common.collect.AbstractSortedMultiset.class, "comparator").b(this, comparator);
        com.google.common.collect.Serialization.a(com.google.common.collect.TreeMultiset.class, "range").b(this, com.google.common.collect.GeneralRange.all(comparator));
        com.google.common.collect.Serialization.a(com.google.common.collect.TreeMultiset.class, "rootReference").b(this, new com.google.common.collect.TreeMultiset.Reference(null));
        com.google.common.collect.TreeMultiset.AvlNode avlNode = new com.google.common.collect.TreeMultiset.AvlNode(null, 1);
        com.google.common.collect.Serialization.a(com.google.common.collect.TreeMultiset.class, "header").b(this, avlNode);
        successor(avlNode, avlNode);
        com.google.common.collect.Serialization.f(this, objectInputStream);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T> void successor(com.google.common.collect.TreeMultiset.AvlNode<T> avlNode, com.google.common.collect.TreeMultiset.AvlNode<T> avlNode2) {
        avlNode.i = avlNode2;
        avlNode2.h = avlNode;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T> void successor(com.google.common.collect.TreeMultiset.AvlNode<T> avlNode, com.google.common.collect.TreeMultiset.AvlNode<T> avlNode2, com.google.common.collect.TreeMultiset.AvlNode<T> avlNode3) {
        successor(avlNode, avlNode2);
        successor(avlNode2, avlNode3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.google.common.collect.Multiset.Entry<E> wrapEntry(com.google.common.collect.TreeMultiset.AvlNode<E> avlNode) {
        return new com.google.common.collect.TreeMultiset.AnonymousClass1(avlNode);
    }

    @com.google.common.annotations.GwtIncompatible
    private void writeObject(java.io.ObjectOutputStream objectOutputStream) throws java.io.IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(elementSet().comparator());
        com.google.common.collect.Serialization.k(this, objectOutputStream);
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public int add(@org.checkerframework.checker.nullness.compatqual.NullableDecl E e, int i) {
        com.google.common.collect.CollectPreconditions.b(i, "occurrences");
        if (i == 0) {
            return count(e);
        }
        com.google.common.base.Preconditions.checkArgument(this.range.contains(e));
        com.google.common.collect.TreeMultiset.AvlNode<E> c = this.rootReference.c();
        if (c != null) {
            int[] iArr = new int[1];
            this.rootReference.a(c, c.p(comparator(), e, i, iArr));
            return iArr[0];
        }
        comparator().compare(e, e);
        com.google.common.collect.TreeMultiset.AvlNode<E> avlNode = new com.google.common.collect.TreeMultiset.AvlNode<>(e, i);
        com.google.common.collect.TreeMultiset.AvlNode<E> avlNode2 = this.header;
        successor(avlNode2, avlNode, avlNode2);
        this.rootReference.a(c, avlNode);
        return 0;
    }

    @Override // com.google.common.collect.AbstractMultiset, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        if (this.range.hasLowerBound() || this.range.hasUpperBound()) {
            com.google.common.collect.Iterators.c(entryIterator());
            return;
        }
        com.google.common.collect.TreeMultiset.AvlNode<E> avlNode = this.header.i;
        while (true) {
            com.google.common.collect.TreeMultiset.AvlNode<E> avlNode2 = this.header;
            if (avlNode == avlNode2) {
                successor(avlNode2, avlNode2);
                this.rootReference.b();
                return;
            }
            com.google.common.collect.TreeMultiset.AvlNode<E> avlNode3 = avlNode.i;
            avlNode.b = 0;
            avlNode.f = null;
            avlNode.g = null;
            avlNode.h = null;
            avlNode.i = null;
            avlNode = avlNode3;
        }
    }

    @Override // com.google.common.collect.AbstractSortedMultiset, com.google.common.collect.SortedMultiset, com.google.common.collect.SortedIterable
    public /* bridge */ /* synthetic */ java.util.Comparator comparator() {
        return super.comparator();
    }

    @Override // com.google.common.collect.AbstractMultiset, java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ boolean contains(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        return super.contains(obj);
    }

    @Override // com.google.common.collect.Multiset
    public int count(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        try {
            com.google.common.collect.TreeMultiset.AvlNode<E> c = this.rootReference.c();
            if (this.range.contains(obj) && c != null) {
                return c.u(comparator(), obj);
            }
        } catch (java.lang.ClassCastException | java.lang.NullPointerException unused) {
        }
        return 0;
    }

    @Override // com.google.common.collect.AbstractSortedMultiset
    public java.util.Iterator<com.google.common.collect.Multiset.Entry<E>> descendingEntryIterator() {
        return new com.google.common.collect.TreeMultiset.AnonymousClass3();
    }

    @Override // com.google.common.collect.AbstractSortedMultiset, com.google.common.collect.SortedMultiset
    public /* bridge */ /* synthetic */ com.google.common.collect.SortedMultiset descendingMultiset() {
        return super.descendingMultiset();
    }

    @Override // com.google.common.collect.AbstractMultiset
    public int distinctElements() {
        return com.google.common.primitives.Ints.saturatedCast(aggregateForEntries(com.google.common.collect.TreeMultiset.Aggregate.DISTINCT));
    }

    @Override // com.google.common.collect.AbstractMultiset
    public java.util.Iterator<E> elementIterator() {
        return com.google.common.collect.Multisets.e(entryIterator());
    }

    @Override // com.google.common.collect.AbstractSortedMultiset, com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ java.util.NavigableSet elementSet() {
        return super.elementSet();
    }

    @Override // com.google.common.collect.AbstractMultiset
    public java.util.Iterator<com.google.common.collect.Multiset.Entry<E>> entryIterator() {
        return new com.google.common.collect.TreeMultiset.AnonymousClass2();
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ java.util.Set entrySet() {
        return super.entrySet();
    }

    @Override // com.google.common.collect.AbstractSortedMultiset, com.google.common.collect.SortedMultiset
    public /* bridge */ /* synthetic */ com.google.common.collect.Multiset.Entry firstEntry() {
        return super.firstEntry();
    }

    @Override // com.google.common.collect.SortedMultiset
    public com.google.common.collect.SortedMultiset<E> headMultiset(@org.checkerframework.checker.nullness.compatqual.NullableDecl E e, com.google.common.collect.BoundType boundType) {
        return new com.google.common.collect.TreeMultiset(this.rootReference, this.range.intersect(com.google.common.collect.GeneralRange.upTo(comparator(), e, boundType)), this.header);
    }

    @Override // com.google.common.collect.AbstractMultiset, java.util.AbstractCollection, java.util.Collection
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, com.google.common.collect.Multiset
    public java.util.Iterator<E> iterator() {
        return com.google.common.collect.Multisets.h(this);
    }

    @Override // com.google.common.collect.AbstractSortedMultiset, com.google.common.collect.SortedMultiset
    public /* bridge */ /* synthetic */ com.google.common.collect.Multiset.Entry lastEntry() {
        return super.lastEntry();
    }

    @Override // com.google.common.collect.AbstractSortedMultiset, com.google.common.collect.SortedMultiset
    public /* bridge */ /* synthetic */ com.google.common.collect.Multiset.Entry pollFirstEntry() {
        return super.pollFirstEntry();
    }

    @Override // com.google.common.collect.AbstractSortedMultiset, com.google.common.collect.SortedMultiset
    public /* bridge */ /* synthetic */ com.google.common.collect.Multiset.Entry pollLastEntry() {
        return super.pollLastEntry();
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public int remove(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj, int i) {
        com.google.common.collect.CollectPreconditions.b(i, "occurrences");
        if (i == 0) {
            return count(obj);
        }
        com.google.common.collect.TreeMultiset.AvlNode<E> c = this.rootReference.c();
        int[] iArr = new int[1];
        try {
            if (this.range.contains(obj) && c != null) {
                this.rootReference.a(c, c.E(comparator(), obj, i, iArr));
                return iArr[0];
            }
        } catch (java.lang.ClassCastException | java.lang.NullPointerException unused) {
        }
        return 0;
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public int setCount(@org.checkerframework.checker.nullness.compatqual.NullableDecl E e, int i) {
        com.google.common.collect.CollectPreconditions.b(i, me.leolin.shortcutbadger.impl.NewHtcHomeBadger.COUNT);
        if (!this.range.contains(e)) {
            com.google.common.base.Preconditions.checkArgument(i == 0);
            return 0;
        }
        com.google.common.collect.TreeMultiset.AvlNode<E> c = this.rootReference.c();
        if (c == null) {
            if (i > 0) {
                add(e, i);
            }
            return 0;
        }
        int[] iArr = new int[1];
        this.rootReference.a(c, c.K(comparator(), e, i, iArr));
        return iArr[0];
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public boolean setCount(@org.checkerframework.checker.nullness.compatqual.NullableDecl E e, int i, int i2) {
        com.google.common.collect.CollectPreconditions.b(i2, "newCount");
        com.google.common.collect.CollectPreconditions.b(i, "oldCount");
        com.google.common.base.Preconditions.checkArgument(this.range.contains(e));
        com.google.common.collect.TreeMultiset.AvlNode<E> c = this.rootReference.c();
        if (c != null) {
            int[] iArr = new int[1];
            this.rootReference.a(c, c.J(comparator(), e, i, i2, iArr));
            return iArr[0] == i;
        }
        if (i != 0) {
            return false;
        }
        if (i2 > 0) {
            add(e, i2);
        }
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    public int size() {
        return com.google.common.primitives.Ints.saturatedCast(aggregateForEntries(com.google.common.collect.TreeMultiset.Aggregate.SIZE));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractSortedMultiset, com.google.common.collect.SortedMultiset
    public /* bridge */ /* synthetic */ com.google.common.collect.SortedMultiset subMultiset(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj, com.google.common.collect.BoundType boundType, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj2, com.google.common.collect.BoundType boundType2) {
        return super.subMultiset(obj, boundType, obj2, boundType2);
    }

    @Override // com.google.common.collect.SortedMultiset
    public com.google.common.collect.SortedMultiset<E> tailMultiset(@org.checkerframework.checker.nullness.compatqual.NullableDecl E e, com.google.common.collect.BoundType boundType) {
        return new com.google.common.collect.TreeMultiset(this.rootReference, this.range.intersect(com.google.common.collect.GeneralRange.downTo(comparator(), e, boundType)), this.header);
    }
}
