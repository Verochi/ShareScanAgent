package com.google.common.base;

@com.google.common.annotations.GwtCompatible
/* loaded from: classes22.dex */
public abstract class Converter<A, B> implements com.google.common.base.Function<A, B> {
    private final boolean handleNullAutomatically;

    @com.google.errorprone.annotations.concurrent.LazyInit
    @org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl
    private transient com.google.common.base.Converter<B, A> reverse;

    /* renamed from: com.google.common.base.Converter$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Iterable<B> {
        public final /* synthetic */ java.lang.Iterable n;

        /* renamed from: com.google.common.base.Converter$1$1, reason: invalid class name and collision with other inner class name */
        public class C03341 implements java.util.Iterator<B> {
            public final java.util.Iterator<? extends A> n;

            public C03341() {
                this.n = com.google.common.base.Converter.AnonymousClass1.this.n.iterator();
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.n.hasNext();
            }

            @Override // java.util.Iterator
            public B next() {
                return (B) com.google.common.base.Converter.this.convert(this.n.next());
            }

            @Override // java.util.Iterator
            public void remove() {
                this.n.remove();
            }
        }

        public AnonymousClass1(java.lang.Iterable iterable) {
            this.n = iterable;
        }

        @Override // java.lang.Iterable
        public java.util.Iterator<B> iterator() {
            return new com.google.common.base.Converter.AnonymousClass1.C03341();
        }
    }

    public static final class ConverterComposition<A, B, C> extends com.google.common.base.Converter<A, C> implements java.io.Serializable {
        private static final long serialVersionUID = 0;
        final com.google.common.base.Converter<A, B> first;
        final com.google.common.base.Converter<B, C> second;

        public ConverterComposition(com.google.common.base.Converter<A, B> converter, com.google.common.base.Converter<B, C> converter2) {
            this.first = converter;
            this.second = converter2;
        }

        @Override // com.google.common.base.Converter
        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        public A correctedDoBackward(@org.checkerframework.checker.nullness.compatqual.NullableDecl C c) {
            return (A) this.first.correctedDoBackward(this.second.correctedDoBackward(c));
        }

        @Override // com.google.common.base.Converter
        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        public C correctedDoForward(@org.checkerframework.checker.nullness.compatqual.NullableDecl A a) {
            return (C) this.second.correctedDoForward(this.first.correctedDoForward(a));
        }

        @Override // com.google.common.base.Converter
        public A doBackward(C c) {
            throw new java.lang.AssertionError();
        }

        @Override // com.google.common.base.Converter
        public C doForward(A a) {
            throw new java.lang.AssertionError();
        }

        @Override // com.google.common.base.Converter, com.google.common.base.Function
        public boolean equals(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            if (!(obj instanceof com.google.common.base.Converter.ConverterComposition)) {
                return false;
            }
            com.google.common.base.Converter.ConverterComposition converterComposition = (com.google.common.base.Converter.ConverterComposition) obj;
            return this.first.equals(converterComposition.first) && this.second.equals(converterComposition.second);
        }

        public int hashCode() {
            return (this.first.hashCode() * 31) + this.second.hashCode();
        }

        public java.lang.String toString() {
            return this.first + ".andThen(" + this.second + ")";
        }
    }

    public static final class FunctionBasedConverter<A, B> extends com.google.common.base.Converter<A, B> implements java.io.Serializable {
        private final com.google.common.base.Function<? super B, ? extends A> backwardFunction;
        private final com.google.common.base.Function<? super A, ? extends B> forwardFunction;

        private FunctionBasedConverter(com.google.common.base.Function<? super A, ? extends B> function, com.google.common.base.Function<? super B, ? extends A> function2) {
            this.forwardFunction = (com.google.common.base.Function) com.google.common.base.Preconditions.checkNotNull(function);
            this.backwardFunction = (com.google.common.base.Function) com.google.common.base.Preconditions.checkNotNull(function2);
        }

        public /* synthetic */ FunctionBasedConverter(com.google.common.base.Function function, com.google.common.base.Function function2, com.google.common.base.Converter.AnonymousClass1 anonymousClass1) {
            this(function, function2);
        }

        @Override // com.google.common.base.Converter
        public A doBackward(B b) {
            return this.backwardFunction.apply(b);
        }

        @Override // com.google.common.base.Converter
        public B doForward(A a) {
            return this.forwardFunction.apply(a);
        }

        @Override // com.google.common.base.Converter, com.google.common.base.Function
        public boolean equals(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            if (!(obj instanceof com.google.common.base.Converter.FunctionBasedConverter)) {
                return false;
            }
            com.google.common.base.Converter.FunctionBasedConverter functionBasedConverter = (com.google.common.base.Converter.FunctionBasedConverter) obj;
            return this.forwardFunction.equals(functionBasedConverter.forwardFunction) && this.backwardFunction.equals(functionBasedConverter.backwardFunction);
        }

        public int hashCode() {
            return (this.forwardFunction.hashCode() * 31) + this.backwardFunction.hashCode();
        }

        public java.lang.String toString() {
            return "Converter.from(" + this.forwardFunction + ", " + this.backwardFunction + ")";
        }
    }

    public static final class IdentityConverter<T> extends com.google.common.base.Converter<T, T> implements java.io.Serializable {
        static final com.google.common.base.Converter.IdentityConverter INSTANCE = new com.google.common.base.Converter.IdentityConverter();
        private static final long serialVersionUID = 0;

        private IdentityConverter() {
        }

        private java.lang.Object readResolve() {
            return INSTANCE;
        }

        @Override // com.google.common.base.Converter
        public <S> com.google.common.base.Converter<T, S> doAndThen(com.google.common.base.Converter<T, S> converter) {
            return (com.google.common.base.Converter) com.google.common.base.Preconditions.checkNotNull(converter, "otherConverter");
        }

        @Override // com.google.common.base.Converter
        public T doBackward(T t) {
            return t;
        }

        @Override // com.google.common.base.Converter
        public T doForward(T t) {
            return t;
        }

        @Override // com.google.common.base.Converter
        public com.google.common.base.Converter.IdentityConverter<T> reverse() {
            return this;
        }

        public java.lang.String toString() {
            return "Converter.identity()";
        }
    }

    public static final class ReverseConverter<A, B> extends com.google.common.base.Converter<B, A> implements java.io.Serializable {
        private static final long serialVersionUID = 0;
        final com.google.common.base.Converter<A, B> original;

        public ReverseConverter(com.google.common.base.Converter<A, B> converter) {
            this.original = converter;
        }

        @Override // com.google.common.base.Converter
        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        public B correctedDoBackward(@org.checkerframework.checker.nullness.compatqual.NullableDecl A a) {
            return this.original.correctedDoForward(a);
        }

        @Override // com.google.common.base.Converter
        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        public A correctedDoForward(@org.checkerframework.checker.nullness.compatqual.NullableDecl B b) {
            return this.original.correctedDoBackward(b);
        }

        @Override // com.google.common.base.Converter
        public B doBackward(A a) {
            throw new java.lang.AssertionError();
        }

        @Override // com.google.common.base.Converter
        public A doForward(B b) {
            throw new java.lang.AssertionError();
        }

        @Override // com.google.common.base.Converter, com.google.common.base.Function
        public boolean equals(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            if (obj instanceof com.google.common.base.Converter.ReverseConverter) {
                return this.original.equals(((com.google.common.base.Converter.ReverseConverter) obj).original);
            }
            return false;
        }

        public int hashCode() {
            return ~this.original.hashCode();
        }

        @Override // com.google.common.base.Converter
        public com.google.common.base.Converter<A, B> reverse() {
            return this.original;
        }

        public java.lang.String toString() {
            return this.original + ".reverse()";
        }
    }

    public Converter() {
        this(true);
    }

    public Converter(boolean z) {
        this.handleNullAutomatically = z;
    }

    public static <A, B> com.google.common.base.Converter<A, B> from(com.google.common.base.Function<? super A, ? extends B> function, com.google.common.base.Function<? super B, ? extends A> function2) {
        return new com.google.common.base.Converter.FunctionBasedConverter(function, function2, null);
    }

    public static <T> com.google.common.base.Converter<T, T> identity() {
        return com.google.common.base.Converter.IdentityConverter.INSTANCE;
    }

    public final <C> com.google.common.base.Converter<A, C> andThen(com.google.common.base.Converter<B, C> converter) {
        return doAndThen(converter);
    }

    @Override // com.google.common.base.Function
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    @java.lang.Deprecated
    public final B apply(@org.checkerframework.checker.nullness.compatqual.NullableDecl A a) {
        return convert(a);
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    public final B convert(@org.checkerframework.checker.nullness.compatqual.NullableDecl A a) {
        return correctedDoForward(a);
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public java.lang.Iterable<B> convertAll(java.lang.Iterable<? extends A> iterable) {
        com.google.common.base.Preconditions.checkNotNull(iterable, "fromIterable");
        return new com.google.common.base.Converter.AnonymousClass1(iterable);
    }

    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    public A correctedDoBackward(@org.checkerframework.checker.nullness.compatqual.NullableDecl B b) {
        if (!this.handleNullAutomatically) {
            return doBackward(b);
        }
        if (b == null) {
            return null;
        }
        return (A) com.google.common.base.Preconditions.checkNotNull(doBackward(b));
    }

    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    public B correctedDoForward(@org.checkerframework.checker.nullness.compatqual.NullableDecl A a) {
        if (!this.handleNullAutomatically) {
            return doForward(a);
        }
        if (a == null) {
            return null;
        }
        return (B) com.google.common.base.Preconditions.checkNotNull(doForward(a));
    }

    public <C> com.google.common.base.Converter<A, C> doAndThen(com.google.common.base.Converter<B, C> converter) {
        return new com.google.common.base.Converter.ConverterComposition(this, (com.google.common.base.Converter) com.google.common.base.Preconditions.checkNotNull(converter));
    }

    @com.google.errorprone.annotations.ForOverride
    public abstract A doBackward(B b);

    @com.google.errorprone.annotations.ForOverride
    public abstract B doForward(A a);

    @Override // com.google.common.base.Function
    public boolean equals(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        return super.equals(obj);
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public com.google.common.base.Converter<B, A> reverse() {
        com.google.common.base.Converter<B, A> converter = this.reverse;
        if (converter != null) {
            return converter;
        }
        com.google.common.base.Converter.ReverseConverter reverseConverter = new com.google.common.base.Converter.ReverseConverter(this);
        this.reverse = reverseConverter;
        return reverseConverter;
    }
}
