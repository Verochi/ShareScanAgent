package com.google.common.graph;

@com.google.errorprone.annotations.Immutable
@com.google.common.annotations.Beta
/* loaded from: classes22.dex */
public final class ElementOrder<T> {
    public final com.google.common.graph.ElementOrder.Type a;

    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    public final java.util.Comparator<T> b;

    /* renamed from: com.google.common.graph.ElementOrder$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[com.google.common.graph.ElementOrder.Type.values().length];
            a = iArr;
            try {
                iArr[com.google.common.graph.ElementOrder.Type.UNORDERED.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                a[com.google.common.graph.ElementOrder.Type.INSERTION.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                a[com.google.common.graph.ElementOrder.Type.SORTED.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
        }
    }

    public enum Type {
        UNORDERED,
        INSERTION,
        SORTED
    }

    public ElementOrder(com.google.common.graph.ElementOrder.Type type, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.util.Comparator<T> comparator) {
        this.a = (com.google.common.graph.ElementOrder.Type) com.google.common.base.Preconditions.checkNotNull(type);
        this.b = comparator;
        com.google.common.base.Preconditions.checkState((type == com.google.common.graph.ElementOrder.Type.SORTED) == (comparator != null));
    }

    public static <S> com.google.common.graph.ElementOrder<S> insertion() {
        return new com.google.common.graph.ElementOrder<>(com.google.common.graph.ElementOrder.Type.INSERTION, null);
    }

    public static <S extends java.lang.Comparable<? super S>> com.google.common.graph.ElementOrder<S> natural() {
        return new com.google.common.graph.ElementOrder<>(com.google.common.graph.ElementOrder.Type.SORTED, com.google.common.collect.Ordering.natural());
    }

    public static <S> com.google.common.graph.ElementOrder<S> sorted(java.util.Comparator<S> comparator) {
        return new com.google.common.graph.ElementOrder<>(com.google.common.graph.ElementOrder.Type.SORTED, comparator);
    }

    public static <S> com.google.common.graph.ElementOrder<S> unordered() {
        return new com.google.common.graph.ElementOrder<>(com.google.common.graph.ElementOrder.Type.UNORDERED, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T1 extends T> com.google.common.graph.ElementOrder<T1> a() {
        return this;
    }

    public <K extends T, V> java.util.Map<K, V> b(int i) {
        int i2 = com.google.common.graph.ElementOrder.AnonymousClass1.a[this.a.ordinal()];
        if (i2 == 1) {
            return com.google.common.collect.Maps.newHashMapWithExpectedSize(i);
        }
        if (i2 == 2) {
            return com.google.common.collect.Maps.newLinkedHashMapWithExpectedSize(i);
        }
        if (i2 == 3) {
            return com.google.common.collect.Maps.newTreeMap(comparator());
        }
        throw new java.lang.AssertionError();
    }

    public java.util.Comparator<T> comparator() {
        java.util.Comparator<T> comparator = this.b;
        if (comparator != null) {
            return comparator;
        }
        throw new java.lang.UnsupportedOperationException("This ordering does not define a comparator.");
    }

    public boolean equals(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof com.google.common.graph.ElementOrder)) {
            return false;
        }
        com.google.common.graph.ElementOrder elementOrder = (com.google.common.graph.ElementOrder) obj;
        return this.a == elementOrder.a && com.google.common.base.Objects.equal(this.b, elementOrder.b);
    }

    public int hashCode() {
        return com.google.common.base.Objects.hashCode(this.a, this.b);
    }

    public java.lang.String toString() {
        com.google.common.base.MoreObjects.ToStringHelper add = com.google.common.base.MoreObjects.toStringHelper(this).add("type", this.a);
        java.util.Comparator<T> comparator = this.b;
        if (comparator != null) {
            add.add("comparator", comparator);
        }
        return add.toString();
    }

    public com.google.common.graph.ElementOrder.Type type() {
        return this.a;
    }
}
