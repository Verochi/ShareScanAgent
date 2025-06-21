package com.google.common.graph;

/* loaded from: classes22.dex */
abstract class MultiEdgesConnecting<E> extends java.util.AbstractSet<E> {
    public final java.util.Map<E, ?> n;
    public final java.lang.Object t;

    /* renamed from: com.google.common.graph.MultiEdgesConnecting$1, reason: invalid class name */
    public class AnonymousClass1 extends com.google.common.collect.AbstractIterator<E> {
        public final /* synthetic */ java.util.Iterator u;

        public AnonymousClass1(java.util.Iterator it) {
            this.u = it;
        }

        @Override // com.google.common.collect.AbstractIterator
        public E computeNext() {
            while (this.u.hasNext()) {
                java.util.Map.Entry entry = (java.util.Map.Entry) this.u.next();
                if (com.google.common.graph.MultiEdgesConnecting.this.t.equals(entry.getValue())) {
                    return (E) entry.getKey();
                }
            }
            return endOfData();
        }
    }

    public MultiEdgesConnecting(java.util.Map<E, ?> map, java.lang.Object obj) {
        this.n = (java.util.Map) com.google.common.base.Preconditions.checkNotNull(map);
        this.t = com.google.common.base.Preconditions.checkNotNull(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public com.google.common.collect.UnmodifiableIterator<E> iterator() {
        return new com.google.common.graph.MultiEdgesConnecting.AnonymousClass1(this.n.entrySet().iterator());
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        return this.t.equals(this.n.get(obj));
    }
}
