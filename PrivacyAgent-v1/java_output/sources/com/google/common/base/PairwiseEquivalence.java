package com.google.common.base;

@com.google.common.annotations.GwtCompatible(serializable = true)
/* loaded from: classes22.dex */
final class PairwiseEquivalence<T> extends com.google.common.base.Equivalence<java.lang.Iterable<T>> implements java.io.Serializable {
    private static final long serialVersionUID = 1;
    final com.google.common.base.Equivalence<? super T> elementEquivalence;

    public PairwiseEquivalence(com.google.common.base.Equivalence<? super T> equivalence) {
        this.elementEquivalence = (com.google.common.base.Equivalence) com.google.common.base.Preconditions.checkNotNull(equivalence);
    }

    @Override // com.google.common.base.Equivalence
    public boolean doEquivalent(java.lang.Iterable<T> iterable, java.lang.Iterable<T> iterable2) {
        java.util.Iterator<T> it = iterable.iterator();
        java.util.Iterator<T> it2 = iterable2.iterator();
        while (it.hasNext() && it2.hasNext()) {
            if (!this.elementEquivalence.equivalent(it.next(), it2.next())) {
                return false;
            }
        }
        return (it.hasNext() || it2.hasNext()) ? false : true;
    }

    @Override // com.google.common.base.Equivalence
    public int doHash(java.lang.Iterable<T> iterable) {
        java.util.Iterator<T> it = iterable.iterator();
        int i = 78721;
        while (it.hasNext()) {
            i = (i * 24943) + this.elementEquivalence.hash(it.next());
        }
        return i;
    }

    public boolean equals(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        if (obj instanceof com.google.common.base.PairwiseEquivalence) {
            return this.elementEquivalence.equals(((com.google.common.base.PairwiseEquivalence) obj).elementEquivalence);
        }
        return false;
    }

    public int hashCode() {
        return this.elementEquivalence.hashCode() ^ 1185147655;
    }

    public java.lang.String toString() {
        return this.elementEquivalence + ".pairwise()";
    }
}
