package com.google.common.collect;

@com.google.common.annotations.GwtIncompatible
/* loaded from: classes22.dex */
abstract class AbstractRangeSet<C extends java.lang.Comparable> implements com.google.common.collect.RangeSet<C> {
    @Override // com.google.common.collect.RangeSet
    public void add(com.google.common.collect.Range<C> range) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override // com.google.common.collect.RangeSet
    public void addAll(com.google.common.collect.RangeSet<C> rangeSet) {
        addAll(rangeSet.asRanges());
    }

    @Override // com.google.common.collect.RangeSet
    public void addAll(java.lang.Iterable<com.google.common.collect.Range<C>> iterable) {
        java.util.Iterator<com.google.common.collect.Range<C>> it = iterable.iterator();
        while (it.hasNext()) {
            add(it.next());
        }
    }

    @Override // com.google.common.collect.RangeSet
    public void clear() {
        remove(com.google.common.collect.Range.all());
    }

    @Override // com.google.common.collect.RangeSet
    public boolean contains(C c) {
        return rangeContaining(c) != null;
    }

    @Override // com.google.common.collect.RangeSet
    public abstract boolean encloses(com.google.common.collect.Range<C> range);

    @Override // com.google.common.collect.RangeSet
    public boolean enclosesAll(com.google.common.collect.RangeSet<C> rangeSet) {
        return enclosesAll(rangeSet.asRanges());
    }

    @Override // com.google.common.collect.RangeSet
    public boolean enclosesAll(java.lang.Iterable<com.google.common.collect.Range<C>> iterable) {
        java.util.Iterator<com.google.common.collect.Range<C>> it = iterable.iterator();
        while (it.hasNext()) {
            if (!encloses(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.common.collect.RangeSet
    public boolean equals(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof com.google.common.collect.RangeSet) {
            return asRanges().equals(((com.google.common.collect.RangeSet) obj).asRanges());
        }
        return false;
    }

    @Override // com.google.common.collect.RangeSet
    public final int hashCode() {
        return asRanges().hashCode();
    }

    @Override // com.google.common.collect.RangeSet
    public boolean intersects(com.google.common.collect.Range<C> range) {
        return !subRangeSet(range).isEmpty();
    }

    @Override // com.google.common.collect.RangeSet
    public boolean isEmpty() {
        return asRanges().isEmpty();
    }

    @Override // com.google.common.collect.RangeSet
    public abstract com.google.common.collect.Range<C> rangeContaining(C c);

    @Override // com.google.common.collect.RangeSet
    public void remove(com.google.common.collect.Range<C> range) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override // com.google.common.collect.RangeSet
    public void removeAll(com.google.common.collect.RangeSet<C> rangeSet) {
        removeAll(rangeSet.asRanges());
    }

    @Override // com.google.common.collect.RangeSet
    public void removeAll(java.lang.Iterable<com.google.common.collect.Range<C>> iterable) {
        java.util.Iterator<com.google.common.collect.Range<C>> it = iterable.iterator();
        while (it.hasNext()) {
            remove(it.next());
        }
    }

    @Override // com.google.common.collect.RangeSet
    public final java.lang.String toString() {
        return asRanges().toString();
    }
}
