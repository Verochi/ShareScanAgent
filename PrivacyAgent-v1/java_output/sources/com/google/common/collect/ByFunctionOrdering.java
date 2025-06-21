package com.google.common.collect;

@com.google.common.annotations.GwtCompatible(serializable = true)
/* loaded from: classes22.dex */
final class ByFunctionOrdering<F, T> extends com.google.common.collect.Ordering<F> implements java.io.Serializable {
    private static final long serialVersionUID = 0;
    final com.google.common.base.Function<F, ? extends T> function;
    final com.google.common.collect.Ordering<T> ordering;

    public ByFunctionOrdering(com.google.common.base.Function<F, ? extends T> function, com.google.common.collect.Ordering<T> ordering) {
        this.function = (com.google.common.base.Function) com.google.common.base.Preconditions.checkNotNull(function);
        this.ordering = (com.google.common.collect.Ordering) com.google.common.base.Preconditions.checkNotNull(ordering);
    }

    @Override // com.google.common.collect.Ordering, java.util.Comparator
    public int compare(F f, F f2) {
        return this.ordering.compare(this.function.apply(f), this.function.apply(f2));
    }

    @Override // java.util.Comparator
    public boolean equals(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof com.google.common.collect.ByFunctionOrdering)) {
            return false;
        }
        com.google.common.collect.ByFunctionOrdering byFunctionOrdering = (com.google.common.collect.ByFunctionOrdering) obj;
        return this.function.equals(byFunctionOrdering.function) && this.ordering.equals(byFunctionOrdering.ordering);
    }

    public int hashCode() {
        return com.google.common.base.Objects.hashCode(this.function, this.ordering);
    }

    public java.lang.String toString() {
        return this.ordering + ".onResultOf(" + this.function + ")";
    }
}
