package com.google.common.graph;

/* loaded from: classes22.dex */
final class DirectedGraphConnections<N, V> implements com.google.common.graph.GraphConnections<N, V> {
    public static final java.lang.Object d = new java.lang.Object();
    public final java.util.Map<N, java.lang.Object> a;
    public int b;
    public int c;

    /* renamed from: com.google.common.graph.DirectedGraphConnections$1, reason: invalid class name */
    public class AnonymousClass1 extends java.util.AbstractSet<N> {

        /* renamed from: com.google.common.graph.DirectedGraphConnections$1$1, reason: invalid class name and collision with other inner class name */
        public class C03521 extends com.google.common.collect.AbstractIterator<N> {
            public final /* synthetic */ java.util.Iterator u;

            public C03521(java.util.Iterator it) {
                this.u = it;
            }

            @Override // com.google.common.collect.AbstractIterator
            public N computeNext() {
                while (this.u.hasNext()) {
                    java.util.Map.Entry entry = (java.util.Map.Entry) this.u.next();
                    if (com.google.common.graph.DirectedGraphConnections.n(entry.getValue())) {
                        return (N) entry.getKey();
                    }
                }
                return endOfData();
            }
        }

        public AnonymousClass1() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.google.common.collect.UnmodifiableIterator<N> iterator() {
            return new com.google.common.graph.DirectedGraphConnections.AnonymousClass1.C03521(com.google.common.graph.DirectedGraphConnections.this.a.entrySet().iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            return com.google.common.graph.DirectedGraphConnections.n(com.google.common.graph.DirectedGraphConnections.this.a.get(obj));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return com.google.common.graph.DirectedGraphConnections.this.b;
        }
    }

    /* renamed from: com.google.common.graph.DirectedGraphConnections$2, reason: invalid class name */
    public class AnonymousClass2 extends java.util.AbstractSet<N> {

        /* renamed from: com.google.common.graph.DirectedGraphConnections$2$1, reason: invalid class name */
        public class AnonymousClass1 extends com.google.common.collect.AbstractIterator<N> {
            public final /* synthetic */ java.util.Iterator u;

            public AnonymousClass1(java.util.Iterator it) {
                this.u = it;
            }

            @Override // com.google.common.collect.AbstractIterator
            public N computeNext() {
                while (this.u.hasNext()) {
                    java.util.Map.Entry entry = (java.util.Map.Entry) this.u.next();
                    if (com.google.common.graph.DirectedGraphConnections.o(entry.getValue())) {
                        return (N) entry.getKey();
                    }
                }
                return endOfData();
            }
        }

        public AnonymousClass2() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.google.common.collect.UnmodifiableIterator<N> iterator() {
            return new com.google.common.graph.DirectedGraphConnections.AnonymousClass2.AnonymousClass1(com.google.common.graph.DirectedGraphConnections.this.a.entrySet().iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            return com.google.common.graph.DirectedGraphConnections.o(com.google.common.graph.DirectedGraphConnections.this.a.get(obj));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return com.google.common.graph.DirectedGraphConnections.this.c;
        }
    }

    public static final class PredAndSucc {
        public final java.lang.Object a;

        public PredAndSucc(java.lang.Object obj) {
            this.a = obj;
        }
    }

    public DirectedGraphConnections(java.util.Map<N, java.lang.Object> map, int i, int i2) {
        this.a = (java.util.Map) com.google.common.base.Preconditions.checkNotNull(map);
        this.b = com.google.common.graph.Graphs.b(i);
        this.c = com.google.common.graph.Graphs.b(i2);
        com.google.common.base.Preconditions.checkState(i <= map.size() && i2 <= map.size());
    }

    public static boolean n(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        return obj == d || (obj instanceof com.google.common.graph.DirectedGraphConnections.PredAndSucc);
    }

    public static boolean o(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        return (obj == d || obj == null) ? false : true;
    }

    public static <N, V> com.google.common.graph.DirectedGraphConnections<N, V> p() {
        return new com.google.common.graph.DirectedGraphConnections<>(new java.util.HashMap(4, 1.0f), 0, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <N, V> com.google.common.graph.DirectedGraphConnections<N, V> q(java.util.Set<N> set, java.util.Map<N, V> map) {
        java.util.HashMap hashMap = new java.util.HashMap();
        hashMap.putAll(map);
        for (N n : set) {
            java.lang.Object put = hashMap.put(n, d);
            if (put != null) {
                hashMap.put(n, new com.google.common.graph.DirectedGraphConnections.PredAndSucc(put));
            }
        }
        return new com.google.common.graph.DirectedGraphConnections<>(com.google.common.collect.ImmutableMap.copyOf((java.util.Map) hashMap), set.size(), map.size());
    }

    @Override // com.google.common.graph.GraphConnections
    public java.util.Set<N> a() {
        return java.util.Collections.unmodifiableSet(this.a.keySet());
    }

    @Override // com.google.common.graph.GraphConnections
    public java.util.Set<N> b() {
        return new com.google.common.graph.DirectedGraphConnections.AnonymousClass2();
    }

    @Override // com.google.common.graph.GraphConnections
    public java.util.Set<N> c() {
        return new com.google.common.graph.DirectedGraphConnections.AnonymousClass1();
    }

    @Override // com.google.common.graph.GraphConnections
    public void d(N n, V v) {
        java.util.Map<N, java.lang.Object> map = this.a;
        java.lang.Object obj = d;
        java.lang.Object put = map.put(n, obj);
        if (put == null) {
            int i = this.b + 1;
            this.b = i;
            com.google.common.graph.Graphs.d(i);
        } else if (put instanceof com.google.common.graph.DirectedGraphConnections.PredAndSucc) {
            this.a.put(n, put);
        } else if (put != obj) {
            this.a.put(n, new com.google.common.graph.DirectedGraphConnections.PredAndSucc(put));
            int i2 = this.b + 1;
            this.b = i2;
            com.google.common.graph.Graphs.d(i2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.GraphConnections
    public V e(N n) {
        V v = (V) this.a.get(n);
        if (v == d) {
            return null;
        }
        return v instanceof com.google.common.graph.DirectedGraphConnections.PredAndSucc ? (V) ((com.google.common.graph.DirectedGraphConnections.PredAndSucc) v).a : v;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.GraphConnections
    public V f(java.lang.Object obj) {
        java.lang.Object obj2;
        V v = (V) this.a.get(obj);
        if (v == 0 || v == (obj2 = d)) {
            return null;
        }
        if (v instanceof com.google.common.graph.DirectedGraphConnections.PredAndSucc) {
            this.a.put(obj, obj2);
            int i = this.c - 1;
            this.c = i;
            com.google.common.graph.Graphs.b(i);
            return (V) ((com.google.common.graph.DirectedGraphConnections.PredAndSucc) v).a;
        }
        this.a.remove(obj);
        int i2 = this.c - 1;
        this.c = i2;
        com.google.common.graph.Graphs.b(i2);
        return v;
    }

    @Override // com.google.common.graph.GraphConnections
    public void g(N n) {
        java.lang.Object obj = this.a.get(n);
        if (obj == d) {
            this.a.remove(n);
            int i = this.b - 1;
            this.b = i;
            com.google.common.graph.Graphs.b(i);
            return;
        }
        if (obj instanceof com.google.common.graph.DirectedGraphConnections.PredAndSucc) {
            this.a.put(n, ((com.google.common.graph.DirectedGraphConnections.PredAndSucc) obj).a);
            int i2 = this.b - 1;
            this.b = i2;
            com.google.common.graph.Graphs.b(i2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.GraphConnections
    public V h(N n, V v) {
        V v2 = (V) this.a.put(n, v);
        if (v2 == 0) {
            int i = this.c + 1;
            this.c = i;
            com.google.common.graph.Graphs.d(i);
            return null;
        }
        if (v2 instanceof com.google.common.graph.DirectedGraphConnections.PredAndSucc) {
            this.a.put(n, new com.google.common.graph.DirectedGraphConnections.PredAndSucc(v));
            return (V) ((com.google.common.graph.DirectedGraphConnections.PredAndSucc) v2).a;
        }
        if (v2 != d) {
            return v2;
        }
        this.a.put(n, new com.google.common.graph.DirectedGraphConnections.PredAndSucc(v));
        int i2 = this.c + 1;
        this.c = i2;
        com.google.common.graph.Graphs.d(i2);
        return null;
    }
}
