package com.google.common.collect;

@com.google.common.annotations.Beta
@com.google.common.annotations.GwtCompatible
/* loaded from: classes22.dex */
public final class Comparators {
    public static <T> boolean isInOrder(java.lang.Iterable<? extends T> iterable, java.util.Comparator<T> comparator) {
        com.google.common.base.Preconditions.checkNotNull(comparator);
        java.util.Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return true;
        }
        T next = it.next();
        while (it.hasNext()) {
            T next2 = it.next();
            if (comparator.compare(next, next2) > 0) {
                return false;
            }
            next = next2;
        }
        return true;
    }

    public static <T> boolean isInStrictOrder(java.lang.Iterable<? extends T> iterable, java.util.Comparator<T> comparator) {
        com.google.common.base.Preconditions.checkNotNull(comparator);
        java.util.Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return true;
        }
        T next = it.next();
        while (it.hasNext()) {
            T next2 = it.next();
            if (comparator.compare(next, next2) >= 0) {
                return false;
            }
            next = next2;
        }
        return true;
    }

    public static <T, S extends T> java.util.Comparator<java.lang.Iterable<S>> lexicographical(java.util.Comparator<T> comparator) {
        return new com.google.common.collect.LexicographicalOrdering((java.util.Comparator) com.google.common.base.Preconditions.checkNotNull(comparator));
    }
}
