package com.google.common.base;

@com.google.common.annotations.GwtCompatible
/* loaded from: classes22.dex */
public abstract class Equivalence<T> {

    public static final class Equals extends com.google.common.base.Equivalence<java.lang.Object> implements java.io.Serializable {
        static final com.google.common.base.Equivalence.Equals INSTANCE = new com.google.common.base.Equivalence.Equals();
        private static final long serialVersionUID = 1;

        private java.lang.Object readResolve() {
            return INSTANCE;
        }

        @Override // com.google.common.base.Equivalence
        public boolean doEquivalent(java.lang.Object obj, java.lang.Object obj2) {
            return obj.equals(obj2);
        }

        @Override // com.google.common.base.Equivalence
        public int doHash(java.lang.Object obj) {
            return obj.hashCode();
        }
    }

    public static final class EquivalentToPredicate<T> implements com.google.common.base.Predicate<T>, java.io.Serializable {
        private static final long serialVersionUID = 0;
        private final com.google.common.base.Equivalence<T> equivalence;

        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        private final T target;

        public EquivalentToPredicate(com.google.common.base.Equivalence<T> equivalence, @org.checkerframework.checker.nullness.compatqual.NullableDecl T t) {
            this.equivalence = (com.google.common.base.Equivalence) com.google.common.base.Preconditions.checkNotNull(equivalence);
            this.target = t;
        }

        @Override // com.google.common.base.Predicate
        public boolean apply(@org.checkerframework.checker.nullness.compatqual.NullableDecl T t) {
            return this.equivalence.equivalent(t, this.target);
        }

        @Override // com.google.common.base.Predicate
        public boolean equals(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof com.google.common.base.Equivalence.EquivalentToPredicate)) {
                return false;
            }
            com.google.common.base.Equivalence.EquivalentToPredicate equivalentToPredicate = (com.google.common.base.Equivalence.EquivalentToPredicate) obj;
            return this.equivalence.equals(equivalentToPredicate.equivalence) && com.google.common.base.Objects.equal(this.target, equivalentToPredicate.target);
        }

        public int hashCode() {
            return com.google.common.base.Objects.hashCode(this.equivalence, this.target);
        }

        public java.lang.String toString() {
            return this.equivalence + ".equivalentTo(" + this.target + ")";
        }
    }

    public static final class Identity extends com.google.common.base.Equivalence<java.lang.Object> implements java.io.Serializable {
        static final com.google.common.base.Equivalence.Identity INSTANCE = new com.google.common.base.Equivalence.Identity();
        private static final long serialVersionUID = 1;

        private java.lang.Object readResolve() {
            return INSTANCE;
        }

        @Override // com.google.common.base.Equivalence
        public boolean doEquivalent(java.lang.Object obj, java.lang.Object obj2) {
            return false;
        }

        @Override // com.google.common.base.Equivalence
        public int doHash(java.lang.Object obj) {
            return java.lang.System.identityHashCode(obj);
        }
    }

    public static final class Wrapper<T> implements java.io.Serializable {
        private static final long serialVersionUID = 0;
        private final com.google.common.base.Equivalence<? super T> equivalence;

        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        private final T reference;

        private Wrapper(com.google.common.base.Equivalence<? super T> equivalence, @org.checkerframework.checker.nullness.compatqual.NullableDecl T t) {
            this.equivalence = (com.google.common.base.Equivalence) com.google.common.base.Preconditions.checkNotNull(equivalence);
            this.reference = t;
        }

        public /* synthetic */ Wrapper(com.google.common.base.Equivalence equivalence, java.lang.Object obj, com.google.common.base.Equivalence.AnonymousClass1 anonymousClass1) {
            this(equivalence, obj);
        }

        public boolean equals(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof com.google.common.base.Equivalence.Wrapper)) {
                return false;
            }
            com.google.common.base.Equivalence.Wrapper wrapper = (com.google.common.base.Equivalence.Wrapper) obj;
            if (this.equivalence.equals(wrapper.equivalence)) {
                return this.equivalence.equivalent(this.reference, wrapper.reference);
            }
            return false;
        }

        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        public T get() {
            return this.reference;
        }

        public int hashCode() {
            return this.equivalence.hash(this.reference);
        }

        public java.lang.String toString() {
            return this.equivalence + ".wrap(" + this.reference + ")";
        }
    }

    public static com.google.common.base.Equivalence<java.lang.Object> equals() {
        return com.google.common.base.Equivalence.Equals.INSTANCE;
    }

    public static com.google.common.base.Equivalence<java.lang.Object> identity() {
        return com.google.common.base.Equivalence.Identity.INSTANCE;
    }

    @com.google.errorprone.annotations.ForOverride
    public abstract boolean doEquivalent(T t, T t2);

    @com.google.errorprone.annotations.ForOverride
    public abstract int doHash(T t);

    public final boolean equivalent(@org.checkerframework.checker.nullness.compatqual.NullableDecl T t, @org.checkerframework.checker.nullness.compatqual.NullableDecl T t2) {
        if (t == t2) {
            return true;
        }
        if (t == null || t2 == null) {
            return false;
        }
        return doEquivalent(t, t2);
    }

    public final com.google.common.base.Predicate<T> equivalentTo(@org.checkerframework.checker.nullness.compatqual.NullableDecl T t) {
        return new com.google.common.base.Equivalence.EquivalentToPredicate(this, t);
    }

    public final int hash(@org.checkerframework.checker.nullness.compatqual.NullableDecl T t) {
        if (t == null) {
            return 0;
        }
        return doHash(t);
    }

    public final <F> com.google.common.base.Equivalence<F> onResultOf(com.google.common.base.Function<F, ? extends T> function) {
        return new com.google.common.base.FunctionalEquivalence(function, this);
    }

    @com.google.common.annotations.GwtCompatible(serializable = true)
    public final <S extends T> com.google.common.base.Equivalence<java.lang.Iterable<S>> pairwise() {
        return new com.google.common.base.PairwiseEquivalence(this);
    }

    public final <S extends T> com.google.common.base.Equivalence.Wrapper<S> wrap(@org.checkerframework.checker.nullness.compatqual.NullableDecl S s2) {
        return new com.google.common.base.Equivalence.Wrapper<>(this, s2, null);
    }
}
