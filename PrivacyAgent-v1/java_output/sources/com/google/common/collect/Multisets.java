package com.google.common.collect;

@com.google.common.annotations.GwtCompatible
/* loaded from: classes22.dex */
public final class Multisets {

    /* JADX INFO: Add missing generic type declarations: [E] */
    /* renamed from: com.google.common.collect.Multisets$1, reason: invalid class name */
    public static class AnonymousClass1<E> extends com.google.common.collect.Multisets.ViewMultiset<E> {
        public final /* synthetic */ com.google.common.collect.Multiset n;
        public final /* synthetic */ com.google.common.collect.Multiset t;

        /* renamed from: com.google.common.collect.Multisets$1$1, reason: invalid class name and collision with other inner class name */
        public class C03441 extends com.google.common.collect.AbstractIterator<com.google.common.collect.Multiset.Entry<E>> {
            public final /* synthetic */ java.util.Iterator u;
            public final /* synthetic */ java.util.Iterator v;

            public C03441(java.util.Iterator it, java.util.Iterator it2) {
                this.u = it;
                this.v = it2;
            }

            @Override // com.google.common.collect.AbstractIterator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public com.google.common.collect.Multiset.Entry<E> computeNext() {
                if (this.u.hasNext()) {
                    com.google.common.collect.Multiset.Entry entry = (com.google.common.collect.Multiset.Entry) this.u.next();
                    java.lang.Object element = entry.getElement();
                    return com.google.common.collect.Multisets.immutableEntry(element, java.lang.Math.max(entry.getCount(), com.google.common.collect.Multisets.AnonymousClass1.this.t.count(element)));
                }
                while (this.v.hasNext()) {
                    com.google.common.collect.Multiset.Entry entry2 = (com.google.common.collect.Multiset.Entry) this.v.next();
                    java.lang.Object element2 = entry2.getElement();
                    if (!com.google.common.collect.Multisets.AnonymousClass1.this.n.contains(element2)) {
                        return com.google.common.collect.Multisets.immutableEntry(element2, entry2.getCount());
                    }
                }
                return endOfData();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(com.google.common.collect.Multiset multiset, com.google.common.collect.Multiset multiset2) {
            super(null);
            this.n = multiset;
            this.t = multiset2;
        }

        @Override // com.google.common.collect.AbstractMultiset, java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
        public boolean contains(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            return this.n.contains(obj) || this.t.contains(obj);
        }

        @Override // com.google.common.collect.Multiset
        public int count(java.lang.Object obj) {
            return java.lang.Math.max(this.n.count(obj), this.t.count(obj));
        }

        @Override // com.google.common.collect.AbstractMultiset
        public java.util.Set<E> createElementSet() {
            return com.google.common.collect.Sets.union(this.n.elementSet(), this.t.elementSet());
        }

        @Override // com.google.common.collect.AbstractMultiset
        public java.util.Iterator<E> elementIterator() {
            throw new java.lang.AssertionError("should never be called");
        }

        @Override // com.google.common.collect.AbstractMultiset
        public java.util.Iterator<com.google.common.collect.Multiset.Entry<E>> entryIterator() {
            return new com.google.common.collect.Multisets.AnonymousClass1.C03441(this.n.entrySet().iterator(), this.t.entrySet().iterator());
        }

        @Override // com.google.common.collect.AbstractMultiset, java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return this.n.isEmpty() && this.t.isEmpty();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [E] */
    /* renamed from: com.google.common.collect.Multisets$2, reason: invalid class name */
    public static class AnonymousClass2<E> extends com.google.common.collect.Multisets.ViewMultiset<E> {
        public final /* synthetic */ com.google.common.collect.Multiset n;
        public final /* synthetic */ com.google.common.collect.Multiset t;

        /* renamed from: com.google.common.collect.Multisets$2$1, reason: invalid class name */
        public class AnonymousClass1 extends com.google.common.collect.AbstractIterator<com.google.common.collect.Multiset.Entry<E>> {
            public final /* synthetic */ java.util.Iterator u;

            public AnonymousClass1(java.util.Iterator it) {
                this.u = it;
            }

            @Override // com.google.common.collect.AbstractIterator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public com.google.common.collect.Multiset.Entry<E> computeNext() {
                while (this.u.hasNext()) {
                    com.google.common.collect.Multiset.Entry entry = (com.google.common.collect.Multiset.Entry) this.u.next();
                    java.lang.Object element = entry.getElement();
                    int min = java.lang.Math.min(entry.getCount(), com.google.common.collect.Multisets.AnonymousClass2.this.t.count(element));
                    if (min > 0) {
                        return com.google.common.collect.Multisets.immutableEntry(element, min);
                    }
                }
                return endOfData();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(com.google.common.collect.Multiset multiset, com.google.common.collect.Multiset multiset2) {
            super(null);
            this.n = multiset;
            this.t = multiset2;
        }

        @Override // com.google.common.collect.Multiset
        public int count(java.lang.Object obj) {
            int count = this.n.count(obj);
            if (count == 0) {
                return 0;
            }
            return java.lang.Math.min(count, this.t.count(obj));
        }

        @Override // com.google.common.collect.AbstractMultiset
        public java.util.Set<E> createElementSet() {
            return com.google.common.collect.Sets.intersection(this.n.elementSet(), this.t.elementSet());
        }

        @Override // com.google.common.collect.AbstractMultiset
        public java.util.Iterator<E> elementIterator() {
            throw new java.lang.AssertionError("should never be called");
        }

        @Override // com.google.common.collect.AbstractMultiset
        public java.util.Iterator<com.google.common.collect.Multiset.Entry<E>> entryIterator() {
            return new com.google.common.collect.Multisets.AnonymousClass2.AnonymousClass1(this.n.entrySet().iterator());
        }
    }

    /* JADX INFO: Add missing generic type declarations: [E] */
    /* renamed from: com.google.common.collect.Multisets$3, reason: invalid class name */
    public static class AnonymousClass3<E> extends com.google.common.collect.Multisets.ViewMultiset<E> {
        public final /* synthetic */ com.google.common.collect.Multiset n;
        public final /* synthetic */ com.google.common.collect.Multiset t;

        /* renamed from: com.google.common.collect.Multisets$3$1, reason: invalid class name */
        public class AnonymousClass1 extends com.google.common.collect.AbstractIterator<com.google.common.collect.Multiset.Entry<E>> {
            public final /* synthetic */ java.util.Iterator u;
            public final /* synthetic */ java.util.Iterator v;

            public AnonymousClass1(java.util.Iterator it, java.util.Iterator it2) {
                this.u = it;
                this.v = it2;
            }

            @Override // com.google.common.collect.AbstractIterator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public com.google.common.collect.Multiset.Entry<E> computeNext() {
                if (this.u.hasNext()) {
                    com.google.common.collect.Multiset.Entry entry = (com.google.common.collect.Multiset.Entry) this.u.next();
                    java.lang.Object element = entry.getElement();
                    return com.google.common.collect.Multisets.immutableEntry(element, entry.getCount() + com.google.common.collect.Multisets.AnonymousClass3.this.t.count(element));
                }
                while (this.v.hasNext()) {
                    com.google.common.collect.Multiset.Entry entry2 = (com.google.common.collect.Multiset.Entry) this.v.next();
                    java.lang.Object element2 = entry2.getElement();
                    if (!com.google.common.collect.Multisets.AnonymousClass3.this.n.contains(element2)) {
                        return com.google.common.collect.Multisets.immutableEntry(element2, entry2.getCount());
                    }
                }
                return endOfData();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(com.google.common.collect.Multiset multiset, com.google.common.collect.Multiset multiset2) {
            super(null);
            this.n = multiset;
            this.t = multiset2;
        }

        @Override // com.google.common.collect.AbstractMultiset, java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
        public boolean contains(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            return this.n.contains(obj) || this.t.contains(obj);
        }

        @Override // com.google.common.collect.Multiset
        public int count(java.lang.Object obj) {
            return this.n.count(obj) + this.t.count(obj);
        }

        @Override // com.google.common.collect.AbstractMultiset
        public java.util.Set<E> createElementSet() {
            return com.google.common.collect.Sets.union(this.n.elementSet(), this.t.elementSet());
        }

        @Override // com.google.common.collect.AbstractMultiset
        public java.util.Iterator<E> elementIterator() {
            throw new java.lang.AssertionError("should never be called");
        }

        @Override // com.google.common.collect.AbstractMultiset
        public java.util.Iterator<com.google.common.collect.Multiset.Entry<E>> entryIterator() {
            return new com.google.common.collect.Multisets.AnonymousClass3.AnonymousClass1(this.n.entrySet().iterator(), this.t.entrySet().iterator());
        }

        @Override // com.google.common.collect.AbstractMultiset, java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return this.n.isEmpty() && this.t.isEmpty();
        }

        @Override // com.google.common.collect.Multisets.ViewMultiset, java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
        public int size() {
            return com.google.common.math.IntMath.saturatedAdd(this.n.size(), this.t.size());
        }
    }

    /* JADX INFO: Add missing generic type declarations: [E] */
    /* renamed from: com.google.common.collect.Multisets$4, reason: invalid class name */
    public static class AnonymousClass4<E> extends com.google.common.collect.Multisets.ViewMultiset<E> {
        public final /* synthetic */ com.google.common.collect.Multiset n;
        public final /* synthetic */ com.google.common.collect.Multiset t;

        /* renamed from: com.google.common.collect.Multisets$4$1, reason: invalid class name */
        public class AnonymousClass1 extends com.google.common.collect.AbstractIterator<E> {
            public final /* synthetic */ java.util.Iterator u;

            public AnonymousClass1(java.util.Iterator it) {
                this.u = it;
            }

            @Override // com.google.common.collect.AbstractIterator
            public E computeNext() {
                while (this.u.hasNext()) {
                    com.google.common.collect.Multiset.Entry entry = (com.google.common.collect.Multiset.Entry) this.u.next();
                    E e = (E) entry.getElement();
                    if (entry.getCount() > com.google.common.collect.Multisets.AnonymousClass4.this.t.count(e)) {
                        return e;
                    }
                }
                return endOfData();
            }
        }

        /* renamed from: com.google.common.collect.Multisets$4$2, reason: invalid class name */
        public class AnonymousClass2 extends com.google.common.collect.AbstractIterator<com.google.common.collect.Multiset.Entry<E>> {
            public final /* synthetic */ java.util.Iterator u;

            public AnonymousClass2(java.util.Iterator it) {
                this.u = it;
            }

            @Override // com.google.common.collect.AbstractIterator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public com.google.common.collect.Multiset.Entry<E> computeNext() {
                while (this.u.hasNext()) {
                    com.google.common.collect.Multiset.Entry entry = (com.google.common.collect.Multiset.Entry) this.u.next();
                    java.lang.Object element = entry.getElement();
                    int count = entry.getCount() - com.google.common.collect.Multisets.AnonymousClass4.this.t.count(element);
                    if (count > 0) {
                        return com.google.common.collect.Multisets.immutableEntry(element, count);
                    }
                }
                return endOfData();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(com.google.common.collect.Multiset multiset, com.google.common.collect.Multiset multiset2) {
            super(null);
            this.n = multiset;
            this.t = multiset2;
        }

        @Override // com.google.common.collect.Multisets.ViewMultiset, com.google.common.collect.AbstractMultiset, java.util.AbstractCollection, java.util.Collection
        public void clear() {
            throw new java.lang.UnsupportedOperationException();
        }

        @Override // com.google.common.collect.Multiset
        public int count(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            int count = this.n.count(obj);
            if (count == 0) {
                return 0;
            }
            return java.lang.Math.max(0, count - this.t.count(obj));
        }

        @Override // com.google.common.collect.Multisets.ViewMultiset, com.google.common.collect.AbstractMultiset
        public int distinctElements() {
            return com.google.common.collect.Iterators.size(entryIterator());
        }

        @Override // com.google.common.collect.AbstractMultiset
        public java.util.Iterator<E> elementIterator() {
            return new com.google.common.collect.Multisets.AnonymousClass4.AnonymousClass1(this.n.entrySet().iterator());
        }

        @Override // com.google.common.collect.AbstractMultiset
        public java.util.Iterator<com.google.common.collect.Multiset.Entry<E>> entryIterator() {
            return new com.google.common.collect.Multisets.AnonymousClass4.AnonymousClass2(this.n.entrySet().iterator());
        }
    }

    /* JADX INFO: Add missing generic type declarations: [E] */
    /* renamed from: com.google.common.collect.Multisets$5, reason: invalid class name */
    public static class AnonymousClass5<E> extends com.google.common.collect.TransformedIterator<com.google.common.collect.Multiset.Entry<E>, E> {
        public AnonymousClass5(java.util.Iterator it) {
            super(it);
        }

        @Override // com.google.common.collect.TransformedIterator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public E a(com.google.common.collect.Multiset.Entry<E> entry) {
            return entry.getElement();
        }
    }

    public static abstract class AbstractEntry<E> implements com.google.common.collect.Multiset.Entry<E> {
        @Override // com.google.common.collect.Multiset.Entry
        public boolean equals(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            if (!(obj instanceof com.google.common.collect.Multiset.Entry)) {
                return false;
            }
            com.google.common.collect.Multiset.Entry entry = (com.google.common.collect.Multiset.Entry) obj;
            return getCount() == entry.getCount() && com.google.common.base.Objects.equal(getElement(), entry.getElement());
        }

        @Override // com.google.common.collect.Multiset.Entry
        public int hashCode() {
            E element = getElement();
            return (element == null ? 0 : element.hashCode()) ^ getCount();
        }

        @Override // com.google.common.collect.Multiset.Entry
        public java.lang.String toString() {
            java.lang.String valueOf = java.lang.String.valueOf(getElement());
            int count = getCount();
            if (count == 1) {
                return valueOf;
            }
            return valueOf + " x " + count;
        }
    }

    public static final class DecreasingCount implements java.util.Comparator<com.google.common.collect.Multiset.Entry<?>> {
        public static final com.google.common.collect.Multisets.DecreasingCount n = new com.google.common.collect.Multisets.DecreasingCount();

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(com.google.common.collect.Multiset.Entry<?> entry, com.google.common.collect.Multiset.Entry<?> entry2) {
            return entry2.getCount() - entry.getCount();
        }
    }

    public static abstract class ElementSet<E> extends com.google.common.collect.Sets.ImprovedAbstractSet<E> {
        public abstract com.google.common.collect.Multiset<E> a();

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            a().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(java.lang.Object obj) {
            return a().contains(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean containsAll(java.util.Collection<?> collection) {
            return a().containsAll(collection);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return a().isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public abstract java.util.Iterator<E> iterator();

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(java.lang.Object obj) {
            return a().remove(obj, Integer.MAX_VALUE) > 0;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return a().entrySet().size();
        }
    }

    public static abstract class EntrySet<E> extends com.google.common.collect.Sets.ImprovedAbstractSet<com.google.common.collect.Multiset.Entry<E>> {
        public abstract com.google.common.collect.Multiset<E> a();

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            a().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            if (!(obj instanceof com.google.common.collect.Multiset.Entry)) {
                return false;
            }
            com.google.common.collect.Multiset.Entry entry = (com.google.common.collect.Multiset.Entry) obj;
            return entry.getCount() > 0 && a().count(entry.getElement()) == entry.getCount();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(java.lang.Object obj) {
            if (obj instanceof com.google.common.collect.Multiset.Entry) {
                com.google.common.collect.Multiset.Entry entry = (com.google.common.collect.Multiset.Entry) obj;
                java.lang.Object element = entry.getElement();
                int count = entry.getCount();
                if (count != 0) {
                    return a().setCount(element, count, 0);
                }
            }
            return false;
        }
    }

    public static final class FilteredMultiset<E> extends com.google.common.collect.Multisets.ViewMultiset<E> {
        public final com.google.common.collect.Multiset<E> n;
        public final com.google.common.base.Predicate<? super E> t;

        /* renamed from: com.google.common.collect.Multisets$FilteredMultiset$1, reason: invalid class name */
        public class AnonymousClass1 implements com.google.common.base.Predicate<com.google.common.collect.Multiset.Entry<E>> {
            public AnonymousClass1() {
            }

            @Override // com.google.common.base.Predicate
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public boolean apply(com.google.common.collect.Multiset.Entry<E> entry) {
                return com.google.common.collect.Multisets.FilteredMultiset.this.t.apply(entry.getElement());
            }
        }

        public FilteredMultiset(com.google.common.collect.Multiset<E> multiset, com.google.common.base.Predicate<? super E> predicate) {
            super(null);
            this.n = (com.google.common.collect.Multiset) com.google.common.base.Preconditions.checkNotNull(multiset);
            this.t = (com.google.common.base.Predicate) com.google.common.base.Preconditions.checkNotNull(predicate);
        }

        @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
        public int add(@org.checkerframework.checker.nullness.compatqual.NullableDecl E e, int i) {
            com.google.common.base.Preconditions.checkArgument(this.t.apply(e), "Element %s does not match predicate %s", e, this.t);
            return this.n.add(e, i);
        }

        @Override // com.google.common.collect.Multiset
        public int count(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            int count = this.n.count(obj);
            if (count <= 0 || !this.t.apply(obj)) {
                return 0;
            }
            return count;
        }

        @Override // com.google.common.collect.AbstractMultiset
        public java.util.Set<E> createElementSet() {
            return com.google.common.collect.Sets.filter(this.n.elementSet(), this.t);
        }

        @Override // com.google.common.collect.AbstractMultiset
        public java.util.Set<com.google.common.collect.Multiset.Entry<E>> createEntrySet() {
            return com.google.common.collect.Sets.filter(this.n.entrySet(), new com.google.common.collect.Multisets.FilteredMultiset.AnonymousClass1());
        }

        @Override // com.google.common.collect.AbstractMultiset
        public java.util.Iterator<E> elementIterator() {
            throw new java.lang.AssertionError("should never be called");
        }

        @Override // com.google.common.collect.AbstractMultiset
        public java.util.Iterator<com.google.common.collect.Multiset.Entry<E>> entryIterator() {
            throw new java.lang.AssertionError("should never be called");
        }

        @Override // com.google.common.collect.Multisets.ViewMultiset, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, com.google.common.collect.Multiset
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public com.google.common.collect.UnmodifiableIterator<E> iterator() {
            return com.google.common.collect.Iterators.filter(this.n.iterator(), this.t);
        }

        @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
        public int remove(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj, int i) {
            com.google.common.collect.CollectPreconditions.b(i, "occurrences");
            if (i == 0) {
                return count(obj);
            }
            if (contains(obj)) {
                return this.n.remove(obj, i);
            }
            return 0;
        }
    }

    public static class ImmutableEntry<E> extends com.google.common.collect.Multisets.AbstractEntry<E> implements java.io.Serializable {
        private static final long serialVersionUID = 0;
        private final int count;

        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        private final E element;

        public ImmutableEntry(@org.checkerframework.checker.nullness.compatqual.NullableDecl E e, int i) {
            this.element = e;
            this.count = i;
            com.google.common.collect.CollectPreconditions.b(i, me.leolin.shortcutbadger.impl.NewHtcHomeBadger.COUNT);
        }

        @Override // com.google.common.collect.Multiset.Entry
        public final int getCount() {
            return this.count;
        }

        @Override // com.google.common.collect.Multiset.Entry
        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        public final E getElement() {
            return this.element;
        }

        public com.google.common.collect.Multisets.ImmutableEntry<E> nextInBucket() {
            return null;
        }
    }

    public static final class MultisetIteratorImpl<E> implements java.util.Iterator<E> {
        public final com.google.common.collect.Multiset<E> n;
        public final java.util.Iterator<com.google.common.collect.Multiset.Entry<E>> t;

        @org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl
        public com.google.common.collect.Multiset.Entry<E> u;
        public int v;
        public int w;
        public boolean x;

        public MultisetIteratorImpl(com.google.common.collect.Multiset<E> multiset, java.util.Iterator<com.google.common.collect.Multiset.Entry<E>> it) {
            this.n = multiset;
            this.t = it;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.v > 0 || this.t.hasNext();
        }

        @Override // java.util.Iterator
        public E next() {
            if (!hasNext()) {
                throw new java.util.NoSuchElementException();
            }
            if (this.v == 0) {
                com.google.common.collect.Multiset.Entry<E> next = this.t.next();
                this.u = next;
                int count = next.getCount();
                this.v = count;
                this.w = count;
            }
            this.v--;
            this.x = true;
            return this.u.getElement();
        }

        @Override // java.util.Iterator
        public void remove() {
            com.google.common.collect.CollectPreconditions.e(this.x);
            if (this.w == 1) {
                this.t.remove();
            } else {
                this.n.remove(this.u.getElement());
            }
            this.w--;
            this.x = false;
        }
    }

    public static class UnmodifiableMultiset<E> extends com.google.common.collect.ForwardingMultiset<E> implements java.io.Serializable {
        private static final long serialVersionUID = 0;
        final com.google.common.collect.Multiset<? extends E> delegate;

        @org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl
        transient java.util.Set<E> elementSet;

        @org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl
        transient java.util.Set<com.google.common.collect.Multiset.Entry<E>> entrySet;

        public UnmodifiableMultiset(com.google.common.collect.Multiset<? extends E> multiset) {
            this.delegate = multiset;
        }

        @Override // com.google.common.collect.ForwardingMultiset, com.google.common.collect.Multiset
        public int add(E e, int i) {
            throw new java.lang.UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Queue
        public boolean add(E e) {
            throw new java.lang.UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection
        public boolean addAll(java.util.Collection<? extends E> collection) {
            throw new java.lang.UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public void clear() {
            throw new java.lang.UnsupportedOperationException();
        }

        public java.util.Set<E> createElementSet() {
            return java.util.Collections.unmodifiableSet(this.delegate.elementSet());
        }

        @Override // com.google.common.collect.ForwardingMultiset, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        public com.google.common.collect.Multiset<E> delegate() {
            return this.delegate;
        }

        @Override // com.google.common.collect.ForwardingMultiset, com.google.common.collect.Multiset
        public java.util.Set<E> elementSet() {
            java.util.Set<E> set = this.elementSet;
            if (set != null) {
                return set;
            }
            java.util.Set<E> createElementSet = createElementSet();
            this.elementSet = createElementSet;
            return createElementSet;
        }

        @Override // com.google.common.collect.ForwardingMultiset, com.google.common.collect.Multiset
        public java.util.Set<com.google.common.collect.Multiset.Entry<E>> entrySet() {
            java.util.Set<com.google.common.collect.Multiset.Entry<E>> set = this.entrySet;
            if (set != null) {
                return set;
            }
            java.util.Set<com.google.common.collect.Multiset.Entry<E>> unmodifiableSet = java.util.Collections.unmodifiableSet(this.delegate.entrySet());
            this.entrySet = unmodifiableSet;
            return unmodifiableSet;
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public java.util.Iterator<E> iterator() {
            return com.google.common.collect.Iterators.unmodifiableIterator(this.delegate.iterator());
        }

        @Override // com.google.common.collect.ForwardingMultiset, com.google.common.collect.Multiset
        public int remove(java.lang.Object obj, int i) {
            throw new java.lang.UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public boolean remove(java.lang.Object obj) {
            throw new java.lang.UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public boolean removeAll(java.util.Collection<?> collection) {
            throw new java.lang.UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public boolean retainAll(java.util.Collection<?> collection) {
            throw new java.lang.UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingMultiset, com.google.common.collect.Multiset
        public int setCount(E e, int i) {
            throw new java.lang.UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingMultiset, com.google.common.collect.Multiset
        public boolean setCount(E e, int i, int i2) {
            throw new java.lang.UnsupportedOperationException();
        }
    }

    public static abstract class ViewMultiset<E> extends com.google.common.collect.AbstractMultiset<E> {
        public ViewMultiset() {
        }

        public /* synthetic */ ViewMultiset(com.google.common.collect.Multisets.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.google.common.collect.AbstractMultiset, java.util.AbstractCollection, java.util.Collection
        public void clear() {
            elementSet().clear();
        }

        @Override // com.google.common.collect.AbstractMultiset
        public int distinctElements() {
            return elementSet().size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, com.google.common.collect.Multiset
        public java.util.Iterator<E> iterator() {
            return com.google.common.collect.Multisets.h(this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
        public int size() {
            return com.google.common.collect.Multisets.i(this);
        }
    }

    public static <E> boolean a(com.google.common.collect.Multiset<E> multiset, com.google.common.collect.AbstractMapBasedMultiset<? extends E> abstractMapBasedMultiset) {
        if (abstractMapBasedMultiset.isEmpty()) {
            return false;
        }
        abstractMapBasedMultiset.addTo(multiset);
        return true;
    }

    public static <E> boolean b(com.google.common.collect.Multiset<E> multiset, com.google.common.collect.Multiset<? extends E> multiset2) {
        if (multiset2 instanceof com.google.common.collect.AbstractMapBasedMultiset) {
            return a(multiset, (com.google.common.collect.AbstractMapBasedMultiset) multiset2);
        }
        if (multiset2.isEmpty()) {
            return false;
        }
        for (com.google.common.collect.Multiset.Entry<? extends E> entry : multiset2.entrySet()) {
            multiset.add(entry.getElement(), entry.getCount());
        }
        return true;
    }

    public static <E> boolean c(com.google.common.collect.Multiset<E> multiset, java.util.Collection<? extends E> collection) {
        com.google.common.base.Preconditions.checkNotNull(multiset);
        com.google.common.base.Preconditions.checkNotNull(collection);
        if (collection instanceof com.google.common.collect.Multiset) {
            return b(multiset, d(collection));
        }
        if (collection.isEmpty()) {
            return false;
        }
        return com.google.common.collect.Iterators.addAll(multiset, collection.iterator());
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public static boolean containsOccurrences(com.google.common.collect.Multiset<?> multiset, com.google.common.collect.Multiset<?> multiset2) {
        com.google.common.base.Preconditions.checkNotNull(multiset);
        com.google.common.base.Preconditions.checkNotNull(multiset2);
        for (com.google.common.collect.Multiset.Entry<?> entry : multiset2.entrySet()) {
            if (multiset.count(entry.getElement()) < entry.getCount()) {
                return false;
            }
        }
        return true;
    }

    @com.google.common.annotations.Beta
    public static <E> com.google.common.collect.ImmutableMultiset<E> copyHighestCountFirst(com.google.common.collect.Multiset<E> multiset) {
        com.google.common.collect.Multiset.Entry[] entryArr = (com.google.common.collect.Multiset.Entry[]) multiset.entrySet().toArray(new com.google.common.collect.Multiset.Entry[0]);
        java.util.Arrays.sort(entryArr, com.google.common.collect.Multisets.DecreasingCount.n);
        return com.google.common.collect.ImmutableMultiset.copyFromEntries(java.util.Arrays.asList(entryArr));
    }

    public static <T> com.google.common.collect.Multiset<T> d(java.lang.Iterable<T> iterable) {
        return (com.google.common.collect.Multiset) iterable;
    }

    @com.google.common.annotations.Beta
    public static <E> com.google.common.collect.Multiset<E> difference(com.google.common.collect.Multiset<E> multiset, com.google.common.collect.Multiset<?> multiset2) {
        com.google.common.base.Preconditions.checkNotNull(multiset);
        com.google.common.base.Preconditions.checkNotNull(multiset2);
        return new com.google.common.collect.Multisets.AnonymousClass4(multiset, multiset2);
    }

    public static <E> java.util.Iterator<E> e(java.util.Iterator<com.google.common.collect.Multiset.Entry<E>> it) {
        return new com.google.common.collect.Multisets.AnonymousClass5(it);
    }

    public static boolean f(com.google.common.collect.Multiset<?> multiset, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        if (obj == multiset) {
            return true;
        }
        if (obj instanceof com.google.common.collect.Multiset) {
            com.google.common.collect.Multiset multiset2 = (com.google.common.collect.Multiset) obj;
            if (multiset.size() == multiset2.size() && multiset.entrySet().size() == multiset2.entrySet().size()) {
                for (com.google.common.collect.Multiset.Entry entry : multiset2.entrySet()) {
                    if (multiset.count(entry.getElement()) != entry.getCount()) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    @com.google.common.annotations.Beta
    public static <E> com.google.common.collect.Multiset<E> filter(com.google.common.collect.Multiset<E> multiset, com.google.common.base.Predicate<? super E> predicate) {
        if (!(multiset instanceof com.google.common.collect.Multisets.FilteredMultiset)) {
            return new com.google.common.collect.Multisets.FilteredMultiset(multiset, predicate);
        }
        com.google.common.collect.Multisets.FilteredMultiset filteredMultiset = (com.google.common.collect.Multisets.FilteredMultiset) multiset;
        return new com.google.common.collect.Multisets.FilteredMultiset(filteredMultiset.n, com.google.common.base.Predicates.and(filteredMultiset.t, predicate));
    }

    public static int g(java.lang.Iterable<?> iterable) {
        if (iterable instanceof com.google.common.collect.Multiset) {
            return ((com.google.common.collect.Multiset) iterable).elementSet().size();
        }
        return 11;
    }

    public static <E> java.util.Iterator<E> h(com.google.common.collect.Multiset<E> multiset) {
        return new com.google.common.collect.Multisets.MultisetIteratorImpl(multiset, multiset.entrySet().iterator());
    }

    public static int i(com.google.common.collect.Multiset<?> multiset) {
        long j = 0;
        while (multiset.entrySet().iterator().hasNext()) {
            j += r4.next().getCount();
        }
        return com.google.common.primitives.Ints.saturatedCast(j);
    }

    public static <E> com.google.common.collect.Multiset.Entry<E> immutableEntry(@org.checkerframework.checker.nullness.compatqual.NullableDecl E e, int i) {
        return new com.google.common.collect.Multisets.ImmutableEntry(e, i);
    }

    public static <E> com.google.common.collect.Multiset<E> intersection(com.google.common.collect.Multiset<E> multiset, com.google.common.collect.Multiset<?> multiset2) {
        com.google.common.base.Preconditions.checkNotNull(multiset);
        com.google.common.base.Preconditions.checkNotNull(multiset2);
        return new com.google.common.collect.Multisets.AnonymousClass2(multiset, multiset2);
    }

    public static boolean j(com.google.common.collect.Multiset<?> multiset, java.util.Collection<?> collection) {
        if (collection instanceof com.google.common.collect.Multiset) {
            collection = ((com.google.common.collect.Multiset) collection).elementSet();
        }
        return multiset.elementSet().removeAll(collection);
    }

    public static boolean k(com.google.common.collect.Multiset<?> multiset, java.util.Collection<?> collection) {
        com.google.common.base.Preconditions.checkNotNull(collection);
        if (collection instanceof com.google.common.collect.Multiset) {
            collection = ((com.google.common.collect.Multiset) collection).elementSet();
        }
        return multiset.elementSet().retainAll(collection);
    }

    public static <E> boolean l(com.google.common.collect.Multiset<E> multiset, com.google.common.collect.Multiset<?> multiset2) {
        com.google.common.base.Preconditions.checkNotNull(multiset);
        com.google.common.base.Preconditions.checkNotNull(multiset2);
        java.util.Iterator<com.google.common.collect.Multiset.Entry<E>> it = multiset.entrySet().iterator();
        boolean z = false;
        while (it.hasNext()) {
            com.google.common.collect.Multiset.Entry<E> next = it.next();
            int count = multiset2.count(next.getElement());
            if (count == 0) {
                it.remove();
            } else if (count < next.getCount()) {
                multiset.setCount(next.getElement(), count);
            }
            z = true;
        }
        return z;
    }

    public static <E> int m(com.google.common.collect.Multiset<E> multiset, E e, int i) {
        com.google.common.collect.CollectPreconditions.b(i, me.leolin.shortcutbadger.impl.NewHtcHomeBadger.COUNT);
        int count = multiset.count(e);
        int i2 = i - count;
        if (i2 > 0) {
            multiset.add(e, i2);
        } else if (i2 < 0) {
            multiset.remove(e, -i2);
        }
        return count;
    }

    public static <E> boolean n(com.google.common.collect.Multiset<E> multiset, E e, int i, int i2) {
        com.google.common.collect.CollectPreconditions.b(i, "oldCount");
        com.google.common.collect.CollectPreconditions.b(i2, "newCount");
        if (multiset.count(e) != i) {
            return false;
        }
        multiset.setCount(e, i2);
        return true;
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public static boolean removeOccurrences(com.google.common.collect.Multiset<?> multiset, com.google.common.collect.Multiset<?> multiset2) {
        com.google.common.base.Preconditions.checkNotNull(multiset);
        com.google.common.base.Preconditions.checkNotNull(multiset2);
        java.util.Iterator<com.google.common.collect.Multiset.Entry<?>> it = multiset.entrySet().iterator();
        boolean z = false;
        while (it.hasNext()) {
            com.google.common.collect.Multiset.Entry<?> next = it.next();
            int count = multiset2.count(next.getElement());
            if (count >= next.getCount()) {
                it.remove();
            } else if (count > 0) {
                multiset.remove(next.getElement(), count);
            }
            z = true;
        }
        return z;
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public static boolean removeOccurrences(com.google.common.collect.Multiset<?> multiset, java.lang.Iterable<?> iterable) {
        if (iterable instanceof com.google.common.collect.Multiset) {
            return removeOccurrences(multiset, (com.google.common.collect.Multiset<?>) iterable);
        }
        com.google.common.base.Preconditions.checkNotNull(multiset);
        com.google.common.base.Preconditions.checkNotNull(iterable);
        java.util.Iterator<?> it = iterable.iterator();
        boolean z = false;
        while (it.hasNext()) {
            z |= multiset.remove(it.next());
        }
        return z;
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public static boolean retainOccurrences(com.google.common.collect.Multiset<?> multiset, com.google.common.collect.Multiset<?> multiset2) {
        return l(multiset, multiset2);
    }

    @com.google.common.annotations.Beta
    public static <E> com.google.common.collect.Multiset<E> sum(com.google.common.collect.Multiset<? extends E> multiset, com.google.common.collect.Multiset<? extends E> multiset2) {
        com.google.common.base.Preconditions.checkNotNull(multiset);
        com.google.common.base.Preconditions.checkNotNull(multiset2);
        return new com.google.common.collect.Multisets.AnonymousClass3(multiset, multiset2);
    }

    @com.google.common.annotations.Beta
    public static <E> com.google.common.collect.Multiset<E> union(com.google.common.collect.Multiset<? extends E> multiset, com.google.common.collect.Multiset<? extends E> multiset2) {
        com.google.common.base.Preconditions.checkNotNull(multiset);
        com.google.common.base.Preconditions.checkNotNull(multiset2);
        return new com.google.common.collect.Multisets.AnonymousClass1(multiset, multiset2);
    }

    @java.lang.Deprecated
    public static <E> com.google.common.collect.Multiset<E> unmodifiableMultiset(com.google.common.collect.ImmutableMultiset<E> immutableMultiset) {
        return (com.google.common.collect.Multiset) com.google.common.base.Preconditions.checkNotNull(immutableMultiset);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <E> com.google.common.collect.Multiset<E> unmodifiableMultiset(com.google.common.collect.Multiset<? extends E> multiset) {
        return ((multiset instanceof com.google.common.collect.Multisets.UnmodifiableMultiset) || (multiset instanceof com.google.common.collect.ImmutableMultiset)) ? multiset : new com.google.common.collect.Multisets.UnmodifiableMultiset((com.google.common.collect.Multiset) com.google.common.base.Preconditions.checkNotNull(multiset));
    }

    @com.google.common.annotations.Beta
    public static <E> com.google.common.collect.SortedMultiset<E> unmodifiableSortedMultiset(com.google.common.collect.SortedMultiset<E> sortedMultiset) {
        return new com.google.common.collect.UnmodifiableSortedMultiset((com.google.common.collect.SortedMultiset) com.google.common.base.Preconditions.checkNotNull(sortedMultiset));
    }
}
