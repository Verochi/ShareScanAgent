package com.google.common.collect;

@com.google.common.annotations.Beta
@com.google.common.annotations.GwtIncompatible
/* loaded from: classes22.dex */
public final class Interners {

    public static class InternerBuilder {
        public final com.google.common.collect.MapMaker a;
        public boolean b;

        public InternerBuilder() {
            this.a = new com.google.common.collect.MapMaker();
            this.b = true;
        }

        public /* synthetic */ InternerBuilder(com.google.common.collect.Interners.AnonymousClass1 anonymousClass1) {
            this();
        }

        public <E> com.google.common.collect.Interner<E> build() {
            if (!this.b) {
                this.a.weakKeys();
            }
            return new com.google.common.collect.Interners.InternerImpl(this.a, null);
        }

        public com.google.common.collect.Interners.InternerBuilder concurrencyLevel(int i) {
            this.a.concurrencyLevel(i);
            return this;
        }

        public com.google.common.collect.Interners.InternerBuilder strong() {
            this.b = true;
            return this;
        }

        @com.google.common.annotations.GwtIncompatible("java.lang.ref.WeakReference")
        public com.google.common.collect.Interners.InternerBuilder weak() {
            this.b = false;
            return this;
        }
    }

    public static class InternerFunction<E> implements com.google.common.base.Function<E, E> {
        public final com.google.common.collect.Interner<E> n;

        public InternerFunction(com.google.common.collect.Interner<E> interner) {
            this.n = interner;
        }

        @Override // com.google.common.base.Function
        public E apply(E e) {
            return this.n.intern(e);
        }

        @Override // com.google.common.base.Function
        public boolean equals(java.lang.Object obj) {
            if (obj instanceof com.google.common.collect.Interners.InternerFunction) {
                return this.n.equals(((com.google.common.collect.Interners.InternerFunction) obj).n);
            }
            return false;
        }

        public int hashCode() {
            return this.n.hashCode();
        }
    }

    @com.google.common.annotations.VisibleForTesting
    public static final class InternerImpl<E> implements com.google.common.collect.Interner<E> {

        @com.google.common.annotations.VisibleForTesting
        public final com.google.common.collect.MapMakerInternalMap<E, com.google.common.collect.MapMaker.Dummy, ?, ?> a;

        public InternerImpl(com.google.common.collect.MapMaker mapMaker) {
            this.a = com.google.common.collect.MapMakerInternalMap.createWithDummyValues(mapMaker.f(com.google.common.base.Equivalence.equals()));
        }

        public /* synthetic */ InternerImpl(com.google.common.collect.MapMaker mapMaker, com.google.common.collect.Interners.AnonymousClass1 anonymousClass1) {
            this(mapMaker);
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [com.google.common.collect.MapMakerInternalMap$InternalEntry] */
        @Override // com.google.common.collect.Interner
        public E intern(E e) {
            E e2;
            do {
                ?? entry = this.a.getEntry(e);
                if (entry != 0 && (e2 = (E) entry.getKey()) != null) {
                    return e2;
                }
            } while (this.a.putIfAbsent(e, com.google.common.collect.MapMaker.Dummy.VALUE) != null);
            return e;
        }
    }

    public static <E> com.google.common.base.Function<E, E> asFunction(com.google.common.collect.Interner<E> interner) {
        return new com.google.common.collect.Interners.InternerFunction((com.google.common.collect.Interner) com.google.common.base.Preconditions.checkNotNull(interner));
    }

    public static com.google.common.collect.Interners.InternerBuilder newBuilder() {
        return new com.google.common.collect.Interners.InternerBuilder(null);
    }

    public static <E> com.google.common.collect.Interner<E> newStrongInterner() {
        return newBuilder().strong().build();
    }

    @com.google.common.annotations.GwtIncompatible("java.lang.ref.WeakReference")
    public static <E> com.google.common.collect.Interner<E> newWeakInterner() {
        return newBuilder().weak().build();
    }
}
