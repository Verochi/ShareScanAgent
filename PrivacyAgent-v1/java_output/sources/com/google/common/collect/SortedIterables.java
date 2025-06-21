package com.google.common.collect;

@com.google.common.annotations.GwtCompatible
/* loaded from: classes22.dex */
final class SortedIterables {
    public static <E> java.util.Comparator<? super E> a(java.util.SortedSet<E> sortedSet) {
        java.util.Comparator<? super E> comparator = sortedSet.comparator();
        return comparator == null ? com.google.common.collect.Ordering.natural() : comparator;
    }

    public static boolean b(java.util.Comparator<?> comparator, java.lang.Iterable<?> iterable) {
        java.util.Comparator comparator2;
        com.google.common.base.Preconditions.checkNotNull(comparator);
        com.google.common.base.Preconditions.checkNotNull(iterable);
        if (iterable instanceof java.util.SortedSet) {
            comparator2 = a((java.util.SortedSet) iterable);
        } else {
            if (!(iterable instanceof com.google.common.collect.SortedIterable)) {
                return false;
            }
            comparator2 = ((com.google.common.collect.SortedIterable) iterable).comparator();
        }
        return comparator.equals(comparator2);
    }
}
