package com.google.common.collect;

@com.google.common.annotations.GwtCompatible(serializable = true)
/* loaded from: classes22.dex */
final class LexicographicalOrdering<T> extends com.google.common.collect.Ordering<java.lang.Iterable<T>> implements java.io.Serializable {
    private static final long serialVersionUID = 0;
    final java.util.Comparator<? super T> elementOrder;

    public LexicographicalOrdering(java.util.Comparator<? super T> comparator) {
        this.elementOrder = comparator;
    }

    @Override // com.google.common.collect.Ordering, java.util.Comparator
    public int compare(java.lang.Iterable<T> iterable, java.lang.Iterable<T> iterable2) {
        java.util.Iterator<T> it = iterable.iterator();
        java.util.Iterator<T> it2 = iterable2.iterator();
        while (it.hasNext()) {
            if (!it2.hasNext()) {
                return 1;
            }
            int compare = this.elementOrder.compare(it.next(), it2.next());
            if (compare != 0) {
                return compare;
            }
        }
        return it2.hasNext() ? -1 : 0;
    }

    @Override // java.util.Comparator
    public boolean equals(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof com.google.common.collect.LexicographicalOrdering) {
            return this.elementOrder.equals(((com.google.common.collect.LexicographicalOrdering) obj).elementOrder);
        }
        return false;
    }

    public int hashCode() {
        return this.elementOrder.hashCode() ^ 2075626741;
    }

    public java.lang.String toString() {
        return this.elementOrder + ".lexicographical()";
    }
}
