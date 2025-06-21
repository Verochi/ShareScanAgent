package com.google.common.collect;

@com.google.common.annotations.Beta
@com.google.common.annotations.GwtCompatible
/* loaded from: classes22.dex */
public final class MinMaxPriorityQueue<E> extends java.util.AbstractQueue<E> {
    public final com.google.common.collect.MinMaxPriorityQueue<E>.Heap n;
    public final com.google.common.collect.MinMaxPriorityQueue<E>.Heap t;

    @com.google.common.annotations.VisibleForTesting
    public final int u;
    public java.lang.Object[] v;
    public int w;
    public int x;

    @com.google.common.annotations.Beta
    public static final class Builder<B> {
        public final java.util.Comparator<B> a;
        public int b;
        public int c;

        public Builder(java.util.Comparator<B> comparator) {
            this.b = -1;
            this.c = Integer.MAX_VALUE;
            this.a = (java.util.Comparator) com.google.common.base.Preconditions.checkNotNull(comparator);
        }

        public /* synthetic */ Builder(java.util.Comparator comparator, com.google.common.collect.MinMaxPriorityQueue.AnonymousClass1 anonymousClass1) {
            this(comparator);
        }

        public final <T extends B> com.google.common.collect.Ordering<T> c() {
            return com.google.common.collect.Ordering.from(this.a);
        }

        public <T extends B> com.google.common.collect.MinMaxPriorityQueue<T> create() {
            return create(java.util.Collections.emptySet());
        }

        public <T extends B> com.google.common.collect.MinMaxPriorityQueue<T> create(java.lang.Iterable<? extends T> iterable) {
            com.google.common.collect.MinMaxPriorityQueue<T> minMaxPriorityQueue = new com.google.common.collect.MinMaxPriorityQueue<>(this, com.google.common.collect.MinMaxPriorityQueue.k(this.b, this.c, iterable), null);
            java.util.Iterator<? extends T> it = iterable.iterator();
            while (it.hasNext()) {
                minMaxPriorityQueue.offer(it.next());
            }
            return minMaxPriorityQueue;
        }

        @com.google.errorprone.annotations.CanIgnoreReturnValue
        public com.google.common.collect.MinMaxPriorityQueue.Builder<B> expectedSize(int i) {
            com.google.common.base.Preconditions.checkArgument(i >= 0);
            this.b = i;
            return this;
        }

        @com.google.errorprone.annotations.CanIgnoreReturnValue
        public com.google.common.collect.MinMaxPriorityQueue.Builder<B> maximumSize(int i) {
            com.google.common.base.Preconditions.checkArgument(i > 0);
            this.c = i;
            return this;
        }
    }

    public class Heap {
        public final com.google.common.collect.Ordering<E> a;

        @com.google.j2objc.annotations.Weak
        @org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl
        public com.google.common.collect.MinMaxPriorityQueue<E>.Heap b;

        public Heap(com.google.common.collect.Ordering<E> ordering) {
            this.a = ordering;
        }

        public void a(int i, E e) {
            com.google.common.collect.MinMaxPriorityQueue.Heap heap;
            int e2 = e(i, e);
            if (e2 == i) {
                e2 = i;
                heap = this;
            } else {
                heap = this.b;
            }
            heap.b(e2, e);
        }

        @com.google.errorprone.annotations.CanIgnoreReturnValue
        public int b(int i, E e) {
            while (i > 2) {
                int j = j(i);
                java.lang.Object f = com.google.common.collect.MinMaxPriorityQueue.this.f(j);
                if (this.a.compare(f, e) <= 0) {
                    break;
                }
                com.google.common.collect.MinMaxPriorityQueue.this.v[i] = f;
                i = j;
            }
            com.google.common.collect.MinMaxPriorityQueue.this.v[i] = e;
            return i;
        }

        public int c(int i, int i2) {
            return this.a.compare(com.google.common.collect.MinMaxPriorityQueue.this.f(i), com.google.common.collect.MinMaxPriorityQueue.this.f(i2));
        }

        public int d(int i, E e) {
            int h = h(i);
            if (h <= 0 || this.a.compare(com.google.common.collect.MinMaxPriorityQueue.this.f(h), e) >= 0) {
                return e(i, e);
            }
            com.google.common.collect.MinMaxPriorityQueue.this.v[i] = com.google.common.collect.MinMaxPriorityQueue.this.f(h);
            com.google.common.collect.MinMaxPriorityQueue.this.v[h] = e;
            return h;
        }

        public int e(int i, E e) {
            int m;
            if (i == 0) {
                com.google.common.collect.MinMaxPriorityQueue.this.v[0] = e;
                return 0;
            }
            int l = l(i);
            java.lang.Object f = com.google.common.collect.MinMaxPriorityQueue.this.f(l);
            if (l != 0 && (m = m(l(l))) != l && k(m) >= com.google.common.collect.MinMaxPriorityQueue.this.w) {
                java.lang.Object f2 = com.google.common.collect.MinMaxPriorityQueue.this.f(m);
                if (this.a.compare(f2, f) < 0) {
                    l = m;
                    f = f2;
                }
            }
            if (this.a.compare(f, e) >= 0) {
                com.google.common.collect.MinMaxPriorityQueue.this.v[i] = e;
                return i;
            }
            com.google.common.collect.MinMaxPriorityQueue.this.v[i] = f;
            com.google.common.collect.MinMaxPriorityQueue.this.v[l] = e;
            return l;
        }

        public int f(int i) {
            while (true) {
                int i2 = i(i);
                if (i2 <= 0) {
                    return i;
                }
                com.google.common.collect.MinMaxPriorityQueue.this.v[i] = com.google.common.collect.MinMaxPriorityQueue.this.f(i2);
                i = i2;
            }
        }

        public int g(int i, int i2) {
            if (i >= com.google.common.collect.MinMaxPriorityQueue.this.w) {
                return -1;
            }
            com.google.common.base.Preconditions.checkState(i > 0);
            int min = java.lang.Math.min(i, com.google.common.collect.MinMaxPriorityQueue.this.w - i2) + i2;
            for (int i3 = i + 1; i3 < min; i3++) {
                if (c(i3, i) < 0) {
                    i = i3;
                }
            }
            return i;
        }

        public int h(int i) {
            return g(k(i), 2);
        }

        public int i(int i) {
            int k = k(i);
            if (k < 0) {
                return -1;
            }
            return g(k(k), 4);
        }

        public final int j(int i) {
            return l(l(i));
        }

        public final int k(int i) {
            return (i * 2) + 1;
        }

        public final int l(int i) {
            return (i - 1) / 2;
        }

        public final int m(int i) {
            return (i * 2) + 2;
        }

        public int n(E e) {
            int m;
            int l = l(com.google.common.collect.MinMaxPriorityQueue.this.w);
            if (l != 0 && (m = m(l(l))) != l && k(m) >= com.google.common.collect.MinMaxPriorityQueue.this.w) {
                java.lang.Object f = com.google.common.collect.MinMaxPriorityQueue.this.f(m);
                if (this.a.compare(f, e) < 0) {
                    com.google.common.collect.MinMaxPriorityQueue.this.v[m] = e;
                    com.google.common.collect.MinMaxPriorityQueue.this.v[com.google.common.collect.MinMaxPriorityQueue.this.w] = f;
                    return m;
                }
            }
            return com.google.common.collect.MinMaxPriorityQueue.this.w;
        }

        public com.google.common.collect.MinMaxPriorityQueue.MoveDesc<E> o(int i, int i2, E e) {
            int d = d(i2, e);
            if (d == i2) {
                return null;
            }
            java.lang.Object f = d < i ? com.google.common.collect.MinMaxPriorityQueue.this.f(i) : com.google.common.collect.MinMaxPriorityQueue.this.f(l(i));
            if (this.b.b(d, e) < i) {
                return new com.google.common.collect.MinMaxPriorityQueue.MoveDesc<>(e, f);
            }
            return null;
        }
    }

    public static class MoveDesc<E> {
        public final E a;
        public final E b;

        public MoveDesc(E e, E e2) {
            this.a = e;
            this.b = e2;
        }
    }

    public class QueueIterator implements java.util.Iterator<E> {
        public int n;
        public int t;
        public int u;

        @org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl
        public java.util.Queue<E> v;

        @org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl
        public java.util.List<E> w;

        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        public E x;
        public boolean y;

        public QueueIterator() {
            this.n = -1;
            this.t = -1;
            this.u = com.google.common.collect.MinMaxPriorityQueue.this.x;
        }

        public /* synthetic */ QueueIterator(com.google.common.collect.MinMaxPriorityQueue minMaxPriorityQueue, com.google.common.collect.MinMaxPriorityQueue.AnonymousClass1 anonymousClass1) {
            this();
        }

        public final void a() {
            if (com.google.common.collect.MinMaxPriorityQueue.this.x != this.u) {
                throw new java.util.ConcurrentModificationException();
            }
        }

        public final boolean b(java.lang.Iterable<E> iterable, E e) {
            java.util.Iterator<E> it = iterable.iterator();
            while (it.hasNext()) {
                if (it.next() == e) {
                    it.remove();
                    return true;
                }
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void c(int i) {
            if (this.t < i) {
                if (this.w != null) {
                    while (i < com.google.common.collect.MinMaxPriorityQueue.this.size() && b(this.w, com.google.common.collect.MinMaxPriorityQueue.this.f(i))) {
                        i++;
                    }
                }
                this.t = i;
            }
        }

        public final boolean d(java.lang.Object obj) {
            for (int i = 0; i < com.google.common.collect.MinMaxPriorityQueue.this.w; i++) {
                if (com.google.common.collect.MinMaxPriorityQueue.this.v[i] == obj) {
                    com.google.common.collect.MinMaxPriorityQueue.this.n(i);
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            a();
            c(this.n + 1);
            if (this.t < com.google.common.collect.MinMaxPriorityQueue.this.size()) {
                return true;
            }
            java.util.Queue<E> queue = this.v;
            return (queue == null || queue.isEmpty()) ? false : true;
        }

        @Override // java.util.Iterator
        public E next() {
            a();
            c(this.n + 1);
            if (this.t < com.google.common.collect.MinMaxPriorityQueue.this.size()) {
                int i = this.t;
                this.n = i;
                this.y = true;
                return (E) com.google.common.collect.MinMaxPriorityQueue.this.f(i);
            }
            if (this.v != null) {
                this.n = com.google.common.collect.MinMaxPriorityQueue.this.size();
                E poll = this.v.poll();
                this.x = poll;
                if (poll != null) {
                    this.y = true;
                    return poll;
                }
            }
            throw new java.util.NoSuchElementException("iterator moved past last element in queue.");
        }

        @Override // java.util.Iterator
        public void remove() {
            com.google.common.collect.CollectPreconditions.e(this.y);
            a();
            this.y = false;
            this.u++;
            if (this.n >= com.google.common.collect.MinMaxPriorityQueue.this.size()) {
                com.google.common.base.Preconditions.checkState(d(this.x));
                this.x = null;
                return;
            }
            com.google.common.collect.MinMaxPriorityQueue.MoveDesc<E> n = com.google.common.collect.MinMaxPriorityQueue.this.n(this.n);
            if (n != null) {
                if (this.v == null) {
                    this.v = new java.util.ArrayDeque();
                    this.w = new java.util.ArrayList(3);
                }
                if (!b(this.w, n.a)) {
                    this.v.add(n.a);
                }
                if (!b(this.v, n.b)) {
                    this.w.add(n.b);
                }
            }
            this.n--;
            this.t--;
        }
    }

    public MinMaxPriorityQueue(com.google.common.collect.MinMaxPriorityQueue.Builder<? super E> builder, int i) {
        com.google.common.collect.Ordering c = builder.c();
        com.google.common.collect.MinMaxPriorityQueue<E>.Heap heap = new com.google.common.collect.MinMaxPriorityQueue.Heap(c);
        this.n = heap;
        com.google.common.collect.MinMaxPriorityQueue<E>.Heap heap2 = new com.google.common.collect.MinMaxPriorityQueue.Heap(c.reverse());
        this.t = heap2;
        heap.b = heap2;
        heap2.b = heap;
        this.u = builder.c;
        this.v = new java.lang.Object[i];
    }

    public /* synthetic */ MinMaxPriorityQueue(com.google.common.collect.MinMaxPriorityQueue.Builder builder, int i, com.google.common.collect.MinMaxPriorityQueue.AnonymousClass1 anonymousClass1) {
        this(builder, i);
    }

    public static <E extends java.lang.Comparable<E>> com.google.common.collect.MinMaxPriorityQueue<E> create() {
        return new com.google.common.collect.MinMaxPriorityQueue.Builder(com.google.common.collect.Ordering.natural(), null).create();
    }

    public static <E extends java.lang.Comparable<E>> com.google.common.collect.MinMaxPriorityQueue<E> create(java.lang.Iterable<? extends E> iterable) {
        return new com.google.common.collect.MinMaxPriorityQueue.Builder(com.google.common.collect.Ordering.natural(), null).create(iterable);
    }

    public static int e(int i, int i2) {
        return java.lang.Math.min(i - 1, i2) + 1;
    }

    public static com.google.common.collect.MinMaxPriorityQueue.Builder<java.lang.Comparable> expectedSize(int i) {
        return new com.google.common.collect.MinMaxPriorityQueue.Builder(com.google.common.collect.Ordering.natural(), null).expectedSize(i);
    }

    @com.google.common.annotations.VisibleForTesting
    public static int k(int i, int i2, java.lang.Iterable<?> iterable) {
        if (i == -1) {
            i = 11;
        }
        if (iterable instanceof java.util.Collection) {
            i = java.lang.Math.max(i, ((java.util.Collection) iterable).size());
        }
        return e(i, i2);
    }

    @com.google.common.annotations.VisibleForTesting
    public static boolean l(int i) {
        int i2 = ~(~(i + 1));
        com.google.common.base.Preconditions.checkState(i2 > 0, "negative index");
        return (1431655765 & i2) > (i2 & (-1431655766));
    }

    public static com.google.common.collect.MinMaxPriorityQueue.Builder<java.lang.Comparable> maximumSize(int i) {
        return new com.google.common.collect.MinMaxPriorityQueue.Builder(com.google.common.collect.Ordering.natural(), null).maximumSize(i);
    }

    public static <B> com.google.common.collect.MinMaxPriorityQueue.Builder<B> orderedBy(java.util.Comparator<B> comparator) {
        return new com.google.common.collect.MinMaxPriorityQueue.Builder<>(comparator, null);
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection, java.util.Queue
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public boolean add(E e) {
        offer(e);
        return true;
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public boolean addAll(java.util.Collection<? extends E> collection) {
        java.util.Iterator<? extends E> it = collection.iterator();
        boolean z = false;
        while (it.hasNext()) {
            offer(it.next());
            z = true;
        }
        return z;
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        for (int i = 0; i < this.w; i++) {
            this.v[i] = null;
        }
        this.w = 0;
    }

    public java.util.Comparator<? super E> comparator() {
        return this.n.a;
    }

    public final int d() {
        int length = this.v.length;
        return e(length < 64 ? (length + 1) * 2 : com.google.common.math.IntMath.checkedMultiply(length / 2, 3), this.u);
    }

    public E f(int i) {
        return (E) this.v[i];
    }

    public final com.google.common.collect.MinMaxPriorityQueue.MoveDesc<E> g(int i, E e) {
        com.google.common.collect.MinMaxPriorityQueue<E>.Heap j = j(i);
        int f = j.f(i);
        int b = j.b(f, e);
        if (b == f) {
            return j.o(i, f, e);
        }
        if (b < i) {
            return new com.google.common.collect.MinMaxPriorityQueue.MoveDesc<>(e, f(i));
        }
        return null;
    }

    public final int h() {
        int i = this.w;
        if (i != 1) {
            return (i == 2 || this.t.c(1, 2) <= 0) ? 1 : 2;
        }
        return 0;
    }

    public final void i() {
        if (this.w > this.v.length) {
            java.lang.Object[] objArr = new java.lang.Object[d()];
            java.lang.Object[] objArr2 = this.v;
            java.lang.System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
            this.v = objArr;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public java.util.Iterator<E> iterator() {
        return new com.google.common.collect.MinMaxPriorityQueue.QueueIterator(this, null);
    }

    public final com.google.common.collect.MinMaxPriorityQueue<E>.Heap j(int i) {
        return l(i) ? this.n : this.t;
    }

    public final E m(int i) {
        E f = f(i);
        n(i);
        return f;
    }

    @com.google.common.annotations.VisibleForTesting
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public com.google.common.collect.MinMaxPriorityQueue.MoveDesc<E> n(int i) {
        com.google.common.base.Preconditions.checkPositionIndex(i, this.w);
        this.x++;
        int i2 = this.w - 1;
        this.w = i2;
        if (i2 == i) {
            this.v[i2] = null;
            return null;
        }
        E f = f(i2);
        int n = j(this.w).n(f);
        if (n == i) {
            this.v[this.w] = null;
            return null;
        }
        E f2 = f(this.w);
        this.v[this.w] = null;
        com.google.common.collect.MinMaxPriorityQueue.MoveDesc<E> g = g(i, f2);
        return n < i ? g == null ? new com.google.common.collect.MinMaxPriorityQueue.MoveDesc<>(f, f2) : new com.google.common.collect.MinMaxPriorityQueue.MoveDesc<>(f, g.b) : g;
    }

    @Override // java.util.Queue
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public boolean offer(E e) {
        com.google.common.base.Preconditions.checkNotNull(e);
        this.x++;
        int i = this.w;
        this.w = i + 1;
        i();
        j(i).a(i, e);
        return this.w <= this.u || pollLast() != e;
    }

    @Override // java.util.Queue
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return f(0);
    }

    public E peekFirst() {
        return peek();
    }

    public E peekLast() {
        if (isEmpty()) {
            return null;
        }
        return f(h());
    }

    @Override // java.util.Queue
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public E poll() {
        if (isEmpty()) {
            return null;
        }
        return m(0);
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public E pollFirst() {
        return poll();
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public E pollLast() {
        if (isEmpty()) {
            return null;
        }
        return m(h());
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public E removeFirst() {
        return remove();
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public E removeLast() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException();
        }
        return m(h());
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        return this.w;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public java.lang.Object[] toArray() {
        int i = this.w;
        java.lang.Object[] objArr = new java.lang.Object[i];
        java.lang.System.arraycopy(this.v, 0, objArr, 0, i);
        return objArr;
    }
}
