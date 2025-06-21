package com.google.common.base;

@com.google.common.annotations.GwtCompatible(serializable = true)
/* loaded from: classes22.dex */
public abstract class Optional<T> implements java.io.Serializable {
    private static final long serialVersionUID = 0;

    /* renamed from: com.google.common.base.Optional$1, reason: invalid class name */
    public static class AnonymousClass1 implements java.lang.Iterable<T> {
        public final /* synthetic */ java.lang.Iterable n;

        /* renamed from: com.google.common.base.Optional$1$1, reason: invalid class name and collision with other inner class name */
        public class C03351 extends com.google.common.base.AbstractIterator<T> {
            public final java.util.Iterator<? extends com.google.common.base.Optional<? extends T>> u;

            public C03351() {
                this.u = (java.util.Iterator) com.google.common.base.Preconditions.checkNotNull(com.google.common.base.Optional.AnonymousClass1.this.n.iterator());
            }

            @Override // com.google.common.base.AbstractIterator
            public T a() {
                while (this.u.hasNext()) {
                    com.google.common.base.Optional<? extends T> next = this.u.next();
                    if (next.isPresent()) {
                        return next.get();
                    }
                }
                return b();
            }
        }

        public AnonymousClass1(java.lang.Iterable iterable) {
            this.n = iterable;
        }

        @Override // java.lang.Iterable
        public java.util.Iterator<T> iterator() {
            return new com.google.common.base.Optional.AnonymousClass1.C03351();
        }
    }

    public static <T> com.google.common.base.Optional<T> absent() {
        return com.google.common.base.Absent.withType();
    }

    public static <T> com.google.common.base.Optional<T> fromNullable(@org.checkerframework.checker.nullness.compatqual.NullableDecl T t) {
        return t == null ? absent() : new com.google.common.base.Present(t);
    }

    public static <T> com.google.common.base.Optional<T> of(T t) {
        return new com.google.common.base.Present(com.google.common.base.Preconditions.checkNotNull(t));
    }

    @com.google.common.annotations.Beta
    public static <T> java.lang.Iterable<T> presentInstances(java.lang.Iterable<? extends com.google.common.base.Optional<? extends T>> iterable) {
        com.google.common.base.Preconditions.checkNotNull(iterable);
        return new com.google.common.base.Optional.AnonymousClass1(iterable);
    }

    public abstract java.util.Set<T> asSet();

    public abstract boolean equals(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj);

    public abstract T get();

    public abstract int hashCode();

    public abstract boolean isPresent();

    public abstract com.google.common.base.Optional<T> or(com.google.common.base.Optional<? extends T> optional);

    @com.google.common.annotations.Beta
    public abstract T or(com.google.common.base.Supplier<? extends T> supplier);

    public abstract T or(T t);

    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    public abstract T orNull();

    public abstract java.lang.String toString();

    public abstract <V> com.google.common.base.Optional<V> transform(com.google.common.base.Function<? super T, V> function);
}
