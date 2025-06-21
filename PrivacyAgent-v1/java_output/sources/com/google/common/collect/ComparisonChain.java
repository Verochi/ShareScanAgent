package com.google.common.collect;

@com.google.common.annotations.GwtCompatible
/* loaded from: classes22.dex */
public abstract class ComparisonChain {
    public static final com.google.common.collect.ComparisonChain a = new com.google.common.collect.ComparisonChain.AnonymousClass1();
    public static final com.google.common.collect.ComparisonChain b = new com.google.common.collect.ComparisonChain.InactiveComparisonChain(-1);
    public static final com.google.common.collect.ComparisonChain c = new com.google.common.collect.ComparisonChain.InactiveComparisonChain(1);

    /* renamed from: com.google.common.collect.ComparisonChain$1, reason: invalid class name */
    public static class AnonymousClass1 extends com.google.common.collect.ComparisonChain {
        public AnonymousClass1() {
            super(null);
        }

        @Override // com.google.common.collect.ComparisonChain
        public com.google.common.collect.ComparisonChain compare(double d, double d2) {
            return d(java.lang.Double.compare(d, d2));
        }

        @Override // com.google.common.collect.ComparisonChain
        public com.google.common.collect.ComparisonChain compare(float f, float f2) {
            return d(java.lang.Float.compare(f, f2));
        }

        @Override // com.google.common.collect.ComparisonChain
        public com.google.common.collect.ComparisonChain compare(int i, int i2) {
            return d(com.google.common.primitives.Ints.compare(i, i2));
        }

        @Override // com.google.common.collect.ComparisonChain
        public com.google.common.collect.ComparisonChain compare(long j, long j2) {
            return d(com.google.common.primitives.Longs.compare(j, j2));
        }

        @Override // com.google.common.collect.ComparisonChain
        public com.google.common.collect.ComparisonChain compare(java.lang.Comparable comparable, java.lang.Comparable comparable2) {
            return d(comparable.compareTo(comparable2));
        }

        @Override // com.google.common.collect.ComparisonChain
        public <T> com.google.common.collect.ComparisonChain compare(@org.checkerframework.checker.nullness.compatqual.NullableDecl T t, @org.checkerframework.checker.nullness.compatqual.NullableDecl T t2, java.util.Comparator<T> comparator) {
            return d(comparator.compare(t, t2));
        }

        @Override // com.google.common.collect.ComparisonChain
        public com.google.common.collect.ComparisonChain compareFalseFirst(boolean z, boolean z2) {
            return d(com.google.common.primitives.Booleans.compare(z, z2));
        }

        @Override // com.google.common.collect.ComparisonChain
        public com.google.common.collect.ComparisonChain compareTrueFirst(boolean z, boolean z2) {
            return d(com.google.common.primitives.Booleans.compare(z2, z));
        }

        public com.google.common.collect.ComparisonChain d(int i) {
            return i < 0 ? com.google.common.collect.ComparisonChain.b : i > 0 ? com.google.common.collect.ComparisonChain.c : com.google.common.collect.ComparisonChain.a;
        }

        @Override // com.google.common.collect.ComparisonChain
        public int result() {
            return 0;
        }
    }

    public static final class InactiveComparisonChain extends com.google.common.collect.ComparisonChain {
        public final int d;

        public InactiveComparisonChain(int i) {
            super(null);
            this.d = i;
        }

        @Override // com.google.common.collect.ComparisonChain
        public com.google.common.collect.ComparisonChain compare(double d, double d2) {
            return this;
        }

        @Override // com.google.common.collect.ComparisonChain
        public com.google.common.collect.ComparisonChain compare(float f, float f2) {
            return this;
        }

        @Override // com.google.common.collect.ComparisonChain
        public com.google.common.collect.ComparisonChain compare(int i, int i2) {
            return this;
        }

        @Override // com.google.common.collect.ComparisonChain
        public com.google.common.collect.ComparisonChain compare(long j, long j2) {
            return this;
        }

        @Override // com.google.common.collect.ComparisonChain
        public com.google.common.collect.ComparisonChain compare(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Comparable comparable, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Comparable comparable2) {
            return this;
        }

        @Override // com.google.common.collect.ComparisonChain
        public <T> com.google.common.collect.ComparisonChain compare(@org.checkerframework.checker.nullness.compatqual.NullableDecl T t, @org.checkerframework.checker.nullness.compatqual.NullableDecl T t2, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.util.Comparator<T> comparator) {
            return this;
        }

        @Override // com.google.common.collect.ComparisonChain
        public com.google.common.collect.ComparisonChain compareFalseFirst(boolean z, boolean z2) {
            return this;
        }

        @Override // com.google.common.collect.ComparisonChain
        public com.google.common.collect.ComparisonChain compareTrueFirst(boolean z, boolean z2) {
            return this;
        }

        @Override // com.google.common.collect.ComparisonChain
        public int result() {
            return this.d;
        }
    }

    public ComparisonChain() {
    }

    public /* synthetic */ ComparisonChain(com.google.common.collect.ComparisonChain.AnonymousClass1 anonymousClass1) {
        this();
    }

    public static com.google.common.collect.ComparisonChain start() {
        return a;
    }

    public abstract com.google.common.collect.ComparisonChain compare(double d, double d2);

    public abstract com.google.common.collect.ComparisonChain compare(float f, float f2);

    public abstract com.google.common.collect.ComparisonChain compare(int i, int i2);

    public abstract com.google.common.collect.ComparisonChain compare(long j, long j2);

    @java.lang.Deprecated
    public final com.google.common.collect.ComparisonChain compare(java.lang.Boolean bool, java.lang.Boolean bool2) {
        return compareFalseFirst(bool.booleanValue(), bool2.booleanValue());
    }

    public abstract com.google.common.collect.ComparisonChain compare(java.lang.Comparable<?> comparable, java.lang.Comparable<?> comparable2);

    public abstract <T> com.google.common.collect.ComparisonChain compare(@org.checkerframework.checker.nullness.compatqual.NullableDecl T t, @org.checkerframework.checker.nullness.compatqual.NullableDecl T t2, java.util.Comparator<T> comparator);

    public abstract com.google.common.collect.ComparisonChain compareFalseFirst(boolean z, boolean z2);

    public abstract com.google.common.collect.ComparisonChain compareTrueFirst(boolean z, boolean z2);

    public abstract int result();
}
