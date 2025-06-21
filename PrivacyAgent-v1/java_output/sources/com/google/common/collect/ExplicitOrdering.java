package com.google.common.collect;

@com.google.common.annotations.GwtCompatible(serializable = true)
/* loaded from: classes22.dex */
final class ExplicitOrdering<T> extends com.google.common.collect.Ordering<T> implements java.io.Serializable {
    private static final long serialVersionUID = 0;
    final com.google.common.collect.ImmutableMap<T, java.lang.Integer> rankMap;

    public ExplicitOrdering(com.google.common.collect.ImmutableMap<T, java.lang.Integer> immutableMap) {
        this.rankMap = immutableMap;
    }

    public ExplicitOrdering(java.util.List<T> list) {
        this(com.google.common.collect.Maps.u(list));
    }

    private int rank(T t) {
        java.lang.Integer num = this.rankMap.get(t);
        if (num != null) {
            return num.intValue();
        }
        throw new com.google.common.collect.Ordering.IncomparableValueException(t);
    }

    @Override // com.google.common.collect.Ordering, java.util.Comparator
    public int compare(T t, T t2) {
        return rank(t) - rank(t2);
    }

    @Override // java.util.Comparator
    public boolean equals(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        if (obj instanceof com.google.common.collect.ExplicitOrdering) {
            return this.rankMap.equals(((com.google.common.collect.ExplicitOrdering) obj).rankMap);
        }
        return false;
    }

    public int hashCode() {
        return this.rankMap.hashCode();
    }

    public java.lang.String toString() {
        return "Ordering.explicit(" + this.rankMap.keySet() + ")";
    }
}
