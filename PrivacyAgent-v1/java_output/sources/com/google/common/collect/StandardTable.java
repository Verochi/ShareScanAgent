package com.google.common.collect;

@com.google.common.annotations.GwtCompatible
/* loaded from: classes22.dex */
class StandardTable<R, C, V> extends com.google.common.collect.AbstractTable<R, C, V> implements java.io.Serializable {
    private static final long serialVersionUID = 0;

    @com.google.common.collect.GwtTransient
    final java.util.Map<R, java.util.Map<C, V>> backingMap;

    @org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl
    private transient java.util.Set<C> columnKeySet;

    @org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl
    private transient com.google.common.collect.StandardTable<R, C, V>.ColumnMap columnMap;

    @com.google.common.collect.GwtTransient
    final com.google.common.base.Supplier<? extends java.util.Map<C, V>> factory;

    @org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl
    private transient java.util.Map<R, java.util.Map<C, V>> rowMap;

    public class CellIterator implements java.util.Iterator<com.google.common.collect.Table.Cell<R, C, V>> {
        public final java.util.Iterator<java.util.Map.Entry<R, java.util.Map<C, V>>> n;

        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        public java.util.Map.Entry<R, java.util.Map<C, V>> t;
        public java.util.Iterator<java.util.Map.Entry<C, V>> u;

        public CellIterator() {
            this.n = com.google.common.collect.StandardTable.this.backingMap.entrySet().iterator();
            this.u = com.google.common.collect.Iterators.h();
        }

        public /* synthetic */ CellIterator(com.google.common.collect.StandardTable standardTable, com.google.common.collect.StandardTable.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // java.util.Iterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.google.common.collect.Table.Cell<R, C, V> next() {
            if (!this.u.hasNext()) {
                java.util.Map.Entry<R, java.util.Map<C, V>> next = this.n.next();
                this.t = next;
                this.u = next.getValue().entrySet().iterator();
            }
            java.util.Map.Entry<C, V> next2 = this.u.next();
            return com.google.common.collect.Tables.immutableCell(this.t.getKey(), next2.getKey(), next2.getValue());
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.n.hasNext() || this.u.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            this.u.remove();
            if (this.t.getValue().isEmpty()) {
                this.n.remove();
                this.t = null;
            }
        }
    }

    public class Column extends com.google.common.collect.Maps.ViewCachingAbstractMap<R, V> {
        public final C v;

        public class EntrySet extends com.google.common.collect.Sets.ImprovedAbstractSet<java.util.Map.Entry<R, V>> {
            public EntrySet() {
            }

            public /* synthetic */ EntrySet(com.google.common.collect.StandardTable.Column column, com.google.common.collect.StandardTable.AnonymousClass1 anonymousClass1) {
                this();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public void clear() {
                com.google.common.collect.StandardTable.Column.this.e(com.google.common.base.Predicates.alwaysTrue());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(java.lang.Object obj) {
                if (!(obj instanceof java.util.Map.Entry)) {
                    return false;
                }
                java.util.Map.Entry entry = (java.util.Map.Entry) obj;
                return com.google.common.collect.StandardTable.this.containsMapping(entry.getKey(), com.google.common.collect.StandardTable.Column.this.v, entry.getValue());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean isEmpty() {
                com.google.common.collect.StandardTable.Column column = com.google.common.collect.StandardTable.Column.this;
                return !com.google.common.collect.StandardTable.this.containsColumn(column.v);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public java.util.Iterator<java.util.Map.Entry<R, V>> iterator() {
                return new com.google.common.collect.StandardTable.Column.EntrySetIterator(com.google.common.collect.StandardTable.Column.this, null);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(java.lang.Object obj) {
                if (!(obj instanceof java.util.Map.Entry)) {
                    return false;
                }
                java.util.Map.Entry entry = (java.util.Map.Entry) obj;
                return com.google.common.collect.StandardTable.this.removeMapping(entry.getKey(), com.google.common.collect.StandardTable.Column.this.v, entry.getValue());
            }

            @Override // com.google.common.collect.Sets.ImprovedAbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean retainAll(java.util.Collection<?> collection) {
                return com.google.common.collect.StandardTable.Column.this.e(com.google.common.base.Predicates.not(com.google.common.base.Predicates.in(collection)));
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                java.util.Iterator<java.util.Map<C, V>> it = com.google.common.collect.StandardTable.this.backingMap.values().iterator();
                int i = 0;
                while (it.hasNext()) {
                    if (it.next().containsKey(com.google.common.collect.StandardTable.Column.this.v)) {
                        i++;
                    }
                }
                return i;
            }
        }

        public class EntrySetIterator extends com.google.common.collect.AbstractIterator<java.util.Map.Entry<R, V>> {
            public final java.util.Iterator<java.util.Map.Entry<R, java.util.Map<C, V>>> u;

            /* renamed from: com.google.common.collect.StandardTable$Column$EntrySetIterator$1EntryImpl, reason: invalid class name */
            public class C1EntryImpl extends com.google.common.collect.AbstractMapEntry<R, V> {
                public final /* synthetic */ java.util.Map.Entry n;

                public C1EntryImpl(java.util.Map.Entry entry) {
                    this.n = entry;
                }

                @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
                public R getKey() {
                    return (R) this.n.getKey();
                }

                @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
                public V getValue() {
                    return (V) ((java.util.Map) this.n.getValue()).get(com.google.common.collect.StandardTable.Column.this.v);
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
                public V setValue(V v) {
                    return (V) ((java.util.Map) this.n.getValue()).put(com.google.common.collect.StandardTable.Column.this.v, com.google.common.base.Preconditions.checkNotNull(v));
                }
            }

            public EntrySetIterator() {
                this.u = com.google.common.collect.StandardTable.this.backingMap.entrySet().iterator();
            }

            public /* synthetic */ EntrySetIterator(com.google.common.collect.StandardTable.Column column, com.google.common.collect.StandardTable.AnonymousClass1 anonymousClass1) {
                this();
            }

            @Override // com.google.common.collect.AbstractIterator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public java.util.Map.Entry<R, V> computeNext() {
                while (this.u.hasNext()) {
                    java.util.Map.Entry<R, java.util.Map<C, V>> next = this.u.next();
                    if (next.getValue().containsKey(com.google.common.collect.StandardTable.Column.this.v)) {
                        return new com.google.common.collect.StandardTable.Column.EntrySetIterator.C1EntryImpl(next);
                    }
                }
                return endOfData();
            }
        }

        public class KeySet extends com.google.common.collect.Maps.KeySet<R, V> {
            public KeySet() {
                super(com.google.common.collect.StandardTable.Column.this);
            }

            @Override // com.google.common.collect.Maps.KeySet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(java.lang.Object obj) {
                com.google.common.collect.StandardTable.Column column = com.google.common.collect.StandardTable.Column.this;
                return com.google.common.collect.StandardTable.this.contains(obj, column.v);
            }

            @Override // com.google.common.collect.Maps.KeySet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(java.lang.Object obj) {
                com.google.common.collect.StandardTable.Column column = com.google.common.collect.StandardTable.Column.this;
                return com.google.common.collect.StandardTable.this.remove(obj, column.v) != null;
            }

            @Override // com.google.common.collect.Sets.ImprovedAbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean retainAll(java.util.Collection<?> collection) {
                return com.google.common.collect.StandardTable.Column.this.e(com.google.common.collect.Maps.y(com.google.common.base.Predicates.not(com.google.common.base.Predicates.in(collection))));
            }
        }

        public class Values extends com.google.common.collect.Maps.Values<R, V> {
            public Values() {
                super(com.google.common.collect.StandardTable.Column.this);
            }

            @Override // com.google.common.collect.Maps.Values, java.util.AbstractCollection, java.util.Collection
            public boolean remove(java.lang.Object obj) {
                return obj != null && com.google.common.collect.StandardTable.Column.this.e(com.google.common.collect.Maps.S(com.google.common.base.Predicates.equalTo(obj)));
            }

            @Override // com.google.common.collect.Maps.Values, java.util.AbstractCollection, java.util.Collection
            public boolean removeAll(java.util.Collection<?> collection) {
                return com.google.common.collect.StandardTable.Column.this.e(com.google.common.collect.Maps.S(com.google.common.base.Predicates.in(collection)));
            }

            @Override // com.google.common.collect.Maps.Values, java.util.AbstractCollection, java.util.Collection
            public boolean retainAll(java.util.Collection<?> collection) {
                return com.google.common.collect.StandardTable.Column.this.e(com.google.common.collect.Maps.S(com.google.common.base.Predicates.not(com.google.common.base.Predicates.in(collection))));
            }
        }

        public Column(C c) {
            this.v = (C) com.google.common.base.Preconditions.checkNotNull(c);
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap
        public java.util.Set<java.util.Map.Entry<R, V>> a() {
            return new com.google.common.collect.StandardTable.Column.EntrySet(this, null);
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap
        /* renamed from: b */
        public java.util.Set<R> h() {
            return new com.google.common.collect.StandardTable.Column.KeySet();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(java.lang.Object obj) {
            return com.google.common.collect.StandardTable.this.contains(obj, this.v);
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap
        public java.util.Collection<V> d() {
            return new com.google.common.collect.StandardTable.Column.Values();
        }

        @com.google.errorprone.annotations.CanIgnoreReturnValue
        public boolean e(com.google.common.base.Predicate<? super java.util.Map.Entry<R, V>> predicate) {
            java.util.Iterator<java.util.Map.Entry<R, java.util.Map<C, V>>> it = com.google.common.collect.StandardTable.this.backingMap.entrySet().iterator();
            boolean z = false;
            while (it.hasNext()) {
                java.util.Map.Entry<R, java.util.Map<C, V>> next = it.next();
                java.util.Map<C, V> value = next.getValue();
                V v = value.get(this.v);
                if (v != null && predicate.apply(com.google.common.collect.Maps.immutableEntry(next.getKey(), v))) {
                    value.remove(this.v);
                    if (value.isEmpty()) {
                        it.remove();
                    }
                    z = true;
                }
            }
            return z;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V get(java.lang.Object obj) {
            return (V) com.google.common.collect.StandardTable.this.get(obj, this.v);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V put(R r, V v) {
            return (V) com.google.common.collect.StandardTable.this.put(r, this.v, v);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V remove(java.lang.Object obj) {
            return (V) com.google.common.collect.StandardTable.this.remove(obj, this.v);
        }
    }

    public class ColumnKeyIterator extends com.google.common.collect.AbstractIterator<C> {
        public final java.util.Map<C, V> u;
        public final java.util.Iterator<java.util.Map<C, V>> v;
        public java.util.Iterator<java.util.Map.Entry<C, V>> w;

        public ColumnKeyIterator() {
            this.u = com.google.common.collect.StandardTable.this.factory.get();
            this.v = com.google.common.collect.StandardTable.this.backingMap.values().iterator();
            this.w = com.google.common.collect.Iterators.f();
        }

        public /* synthetic */ ColumnKeyIterator(com.google.common.collect.StandardTable standardTable, com.google.common.collect.StandardTable.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.google.common.collect.AbstractIterator
        public C computeNext() {
            while (true) {
                if (this.w.hasNext()) {
                    java.util.Map.Entry<C, V> next = this.w.next();
                    if (!this.u.containsKey(next.getKey())) {
                        this.u.put(next.getKey(), next.getValue());
                        return next.getKey();
                    }
                } else {
                    if (!this.v.hasNext()) {
                        return endOfData();
                    }
                    this.w = this.v.next().entrySet().iterator();
                }
            }
        }
    }

    public class ColumnKeySet extends com.google.common.collect.StandardTable<R, C, V>.TableSet<C> {
        public ColumnKeySet() {
            super(com.google.common.collect.StandardTable.this, null);
        }

        public /* synthetic */ ColumnKeySet(com.google.common.collect.StandardTable standardTable, com.google.common.collect.StandardTable.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(java.lang.Object obj) {
            return com.google.common.collect.StandardTable.this.containsColumn(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public java.util.Iterator<C> iterator() {
            return com.google.common.collect.StandardTable.this.createColumnKeyIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(java.lang.Object obj) {
            boolean z = false;
            if (obj == null) {
                return false;
            }
            java.util.Iterator<java.util.Map<C, V>> it = com.google.common.collect.StandardTable.this.backingMap.values().iterator();
            while (it.hasNext()) {
                java.util.Map<C, V> next = it.next();
                if (next.keySet().remove(obj)) {
                    if (next.isEmpty()) {
                        it.remove();
                    }
                    z = true;
                }
            }
            return z;
        }

        @Override // com.google.common.collect.Sets.ImprovedAbstractSet, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean removeAll(java.util.Collection<?> collection) {
            com.google.common.base.Preconditions.checkNotNull(collection);
            java.util.Iterator<java.util.Map<C, V>> it = com.google.common.collect.StandardTable.this.backingMap.values().iterator();
            boolean z = false;
            while (it.hasNext()) {
                java.util.Map<C, V> next = it.next();
                if (com.google.common.collect.Iterators.removeAll(next.keySet().iterator(), collection)) {
                    if (next.isEmpty()) {
                        it.remove();
                    }
                    z = true;
                }
            }
            return z;
        }

        @Override // com.google.common.collect.Sets.ImprovedAbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean retainAll(java.util.Collection<?> collection) {
            com.google.common.base.Preconditions.checkNotNull(collection);
            java.util.Iterator<java.util.Map<C, V>> it = com.google.common.collect.StandardTable.this.backingMap.values().iterator();
            boolean z = false;
            while (it.hasNext()) {
                java.util.Map<C, V> next = it.next();
                if (next.keySet().retainAll(collection)) {
                    if (next.isEmpty()) {
                        it.remove();
                    }
                    z = true;
                }
            }
            return z;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return com.google.common.collect.Iterators.size(iterator());
        }
    }

    public class ColumnMap extends com.google.common.collect.Maps.ViewCachingAbstractMap<C, java.util.Map<R, V>> {

        public class ColumnMapEntrySet extends com.google.common.collect.StandardTable<R, C, V>.TableSet<java.util.Map.Entry<C, java.util.Map<R, V>>> {

            /* renamed from: com.google.common.collect.StandardTable$ColumnMap$ColumnMapEntrySet$1, reason: invalid class name */
            public class AnonymousClass1 implements com.google.common.base.Function<C, java.util.Map<R, V>> {
                public AnonymousClass1() {
                }

                @Override // com.google.common.base.Function
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public java.util.Map<R, V> apply(C c) {
                    return com.google.common.collect.StandardTable.this.column(c);
                }
            }

            public ColumnMapEntrySet() {
                super(com.google.common.collect.StandardTable.this, null);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(java.lang.Object obj) {
                if (!(obj instanceof java.util.Map.Entry)) {
                    return false;
                }
                java.util.Map.Entry entry = (java.util.Map.Entry) obj;
                if (!com.google.common.collect.StandardTable.this.containsColumn(entry.getKey())) {
                    return false;
                }
                return com.google.common.collect.StandardTable.ColumnMap.this.get(entry.getKey()).equals(entry.getValue());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public java.util.Iterator<java.util.Map.Entry<C, java.util.Map<R, V>>> iterator() {
                return com.google.common.collect.Maps.i(com.google.common.collect.StandardTable.this.columnKeySet(), new com.google.common.collect.StandardTable.ColumnMap.ColumnMapEntrySet.AnonymousClass1());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(java.lang.Object obj) {
                if (!contains(obj)) {
                    return false;
                }
                com.google.common.collect.StandardTable.this.removeColumn(((java.util.Map.Entry) obj).getKey());
                return true;
            }

            @Override // com.google.common.collect.Sets.ImprovedAbstractSet, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean removeAll(java.util.Collection<?> collection) {
                com.google.common.base.Preconditions.checkNotNull(collection);
                return com.google.common.collect.Sets.e(this, collection.iterator());
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.Sets.ImprovedAbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean retainAll(java.util.Collection<?> collection) {
                com.google.common.base.Preconditions.checkNotNull(collection);
                java.util.Iterator it = com.google.common.collect.Lists.newArrayList(com.google.common.collect.StandardTable.this.columnKeySet().iterator()).iterator();
                boolean z = false;
                while (it.hasNext()) {
                    java.lang.Object next = it.next();
                    if (!collection.contains(com.google.common.collect.Maps.immutableEntry(next, com.google.common.collect.StandardTable.this.column(next)))) {
                        com.google.common.collect.StandardTable.this.removeColumn(next);
                        z = true;
                    }
                }
                return z;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return com.google.common.collect.StandardTable.this.columnKeySet().size();
            }
        }

        public class ColumnMapValues extends com.google.common.collect.Maps.Values<C, java.util.Map<R, V>> {
            public ColumnMapValues() {
                super(com.google.common.collect.StandardTable.ColumnMap.this);
            }

            @Override // com.google.common.collect.Maps.Values, java.util.AbstractCollection, java.util.Collection
            public boolean remove(java.lang.Object obj) {
                for (java.util.Map.Entry<C, java.util.Map<R, V>> entry : com.google.common.collect.StandardTable.ColumnMap.this.entrySet()) {
                    if (entry.getValue().equals(obj)) {
                        com.google.common.collect.StandardTable.this.removeColumn(entry.getKey());
                        return true;
                    }
                }
                return false;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.Maps.Values, java.util.AbstractCollection, java.util.Collection
            public boolean removeAll(java.util.Collection<?> collection) {
                com.google.common.base.Preconditions.checkNotNull(collection);
                java.util.Iterator it = com.google.common.collect.Lists.newArrayList(com.google.common.collect.StandardTable.this.columnKeySet().iterator()).iterator();
                boolean z = false;
                while (it.hasNext()) {
                    java.lang.Object next = it.next();
                    if (collection.contains(com.google.common.collect.StandardTable.this.column(next))) {
                        com.google.common.collect.StandardTable.this.removeColumn(next);
                        z = true;
                    }
                }
                return z;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.Maps.Values, java.util.AbstractCollection, java.util.Collection
            public boolean retainAll(java.util.Collection<?> collection) {
                com.google.common.base.Preconditions.checkNotNull(collection);
                java.util.Iterator it = com.google.common.collect.Lists.newArrayList(com.google.common.collect.StandardTable.this.columnKeySet().iterator()).iterator();
                boolean z = false;
                while (it.hasNext()) {
                    java.lang.Object next = it.next();
                    if (!collection.contains(com.google.common.collect.StandardTable.this.column(next))) {
                        com.google.common.collect.StandardTable.this.removeColumn(next);
                        z = true;
                    }
                }
                return z;
            }
        }

        public ColumnMap() {
        }

        public /* synthetic */ ColumnMap(com.google.common.collect.StandardTable standardTable, com.google.common.collect.StandardTable.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap
        public java.util.Set<java.util.Map.Entry<C, java.util.Map<R, V>>> a() {
            return new com.google.common.collect.StandardTable.ColumnMap.ColumnMapEntrySet();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(java.lang.Object obj) {
            return com.google.common.collect.StandardTable.this.containsColumn(obj);
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap
        public java.util.Collection<java.util.Map<R, V>> d() {
            return new com.google.common.collect.StandardTable.ColumnMap.ColumnMapValues();
        }

        @Override // java.util.AbstractMap, java.util.Map
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public java.util.Map<R, V> get(java.lang.Object obj) {
            if (com.google.common.collect.StandardTable.this.containsColumn(obj)) {
                return com.google.common.collect.StandardTable.this.column(obj);
            }
            return null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public java.util.Map<R, V> remove(java.lang.Object obj) {
            if (com.google.common.collect.StandardTable.this.containsColumn(obj)) {
                return com.google.common.collect.StandardTable.this.removeColumn(obj);
            }
            return null;
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap, java.util.AbstractMap, java.util.Map
        /* renamed from: keySet */
        public java.util.Set<C> i() {
            return com.google.common.collect.StandardTable.this.columnKeySet();
        }
    }

    public class Row extends com.google.common.collect.Maps.IteratorBasedAbstractMap<C, V> {
        public final R n;

        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        public java.util.Map<C, V> t;

        /* renamed from: com.google.common.collect.StandardTable$Row$1, reason: invalid class name */
        public class AnonymousClass1 implements java.util.Iterator<java.util.Map.Entry<C, V>> {
            public final /* synthetic */ java.util.Iterator n;

            public AnonymousClass1(java.util.Iterator it) {
                this.n = it;
            }

            @Override // java.util.Iterator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public java.util.Map.Entry<C, V> next() {
                return com.google.common.collect.StandardTable.Row.this.f((java.util.Map.Entry) this.n.next());
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.n.hasNext();
            }

            @Override // java.util.Iterator
            public void remove() {
                this.n.remove();
                com.google.common.collect.StandardTable.Row.this.e();
            }
        }

        /* renamed from: com.google.common.collect.StandardTable$Row$2, reason: invalid class name */
        public class AnonymousClass2 extends com.google.common.collect.ForwardingMapEntry<C, V> {
            public final /* synthetic */ java.util.Map.Entry n;

            public AnonymousClass2(java.util.Map.Entry entry) {
                this.n = entry;
            }

            @Override // com.google.common.collect.ForwardingMapEntry, com.google.common.collect.ForwardingObject
            public java.util.Map.Entry<C, V> delegate() {
                return this.n;
            }

            @Override // com.google.common.collect.ForwardingMapEntry, java.util.Map.Entry
            public boolean equals(java.lang.Object obj) {
                return standardEquals(obj);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.ForwardingMapEntry, java.util.Map.Entry
            public V setValue(V v) {
                return (V) super.setValue(com.google.common.base.Preconditions.checkNotNull(v));
            }
        }

        public Row(R r) {
            this.n = (R) com.google.common.base.Preconditions.checkNotNull(r);
        }

        @Override // com.google.common.collect.Maps.IteratorBasedAbstractMap
        public java.util.Iterator<java.util.Map.Entry<C, V>> a() {
            java.util.Map<C, V> b = b();
            return b == null ? com.google.common.collect.Iterators.h() : new com.google.common.collect.StandardTable.Row.AnonymousClass1(b.entrySet().iterator());
        }

        public java.util.Map<C, V> b() {
            java.util.Map<C, V> map = this.t;
            if (map != null && (!map.isEmpty() || !com.google.common.collect.StandardTable.this.backingMap.containsKey(this.n))) {
                return this.t;
            }
            java.util.Map<C, V> d = d();
            this.t = d;
            return d;
        }

        @Override // com.google.common.collect.Maps.IteratorBasedAbstractMap, java.util.AbstractMap, java.util.Map
        public void clear() {
            java.util.Map<C, V> b = b();
            if (b != null) {
                b.clear();
            }
            e();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(java.lang.Object obj) {
            java.util.Map<C, V> b = b();
            return (obj == null || b == null || !com.google.common.collect.Maps.F(b, obj)) ? false : true;
        }

        public java.util.Map<C, V> d() {
            return com.google.common.collect.StandardTable.this.backingMap.get(this.n);
        }

        public void e() {
            if (b() == null || !this.t.isEmpty()) {
                return;
            }
            com.google.common.collect.StandardTable.this.backingMap.remove(this.n);
            this.t = null;
        }

        public java.util.Map.Entry<C, V> f(java.util.Map.Entry<C, V> entry) {
            return new com.google.common.collect.StandardTable.Row.AnonymousClass2(entry);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V get(java.lang.Object obj) {
            java.util.Map<C, V> b = b();
            if (obj == null || b == null) {
                return null;
            }
            return (V) com.google.common.collect.Maps.G(b, obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V put(C c, V v) {
            com.google.common.base.Preconditions.checkNotNull(c);
            com.google.common.base.Preconditions.checkNotNull(v);
            java.util.Map<C, V> map = this.t;
            return (map == null || map.isEmpty()) ? (V) com.google.common.collect.StandardTable.this.put(this.n, c, v) : this.t.put(c, v);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V remove(java.lang.Object obj) {
            java.util.Map<C, V> b = b();
            if (b == null) {
                return null;
            }
            V v = (V) com.google.common.collect.Maps.H(b, obj);
            e();
            return v;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            java.util.Map<C, V> b = b();
            if (b == null) {
                return 0;
            }
            return b.size();
        }
    }

    public class RowMap extends com.google.common.collect.Maps.ViewCachingAbstractMap<R, java.util.Map<C, V>> {

        public class EntrySet extends com.google.common.collect.StandardTable<R, C, V>.TableSet<java.util.Map.Entry<R, java.util.Map<C, V>>> {

            /* renamed from: com.google.common.collect.StandardTable$RowMap$EntrySet$1, reason: invalid class name */
            public class AnonymousClass1 implements com.google.common.base.Function<R, java.util.Map<C, V>> {
                public AnonymousClass1() {
                }

                @Override // com.google.common.base.Function
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public java.util.Map<C, V> apply(R r) {
                    return com.google.common.collect.StandardTable.this.row(r);
                }
            }

            public EntrySet() {
                super(com.google.common.collect.StandardTable.this, null);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(java.lang.Object obj) {
                if (!(obj instanceof java.util.Map.Entry)) {
                    return false;
                }
                java.util.Map.Entry entry = (java.util.Map.Entry) obj;
                return entry.getKey() != null && (entry.getValue() instanceof java.util.Map) && com.google.common.collect.Collections2.g(com.google.common.collect.StandardTable.this.backingMap.entrySet(), entry);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public java.util.Iterator<java.util.Map.Entry<R, java.util.Map<C, V>>> iterator() {
                return com.google.common.collect.Maps.i(com.google.common.collect.StandardTable.this.backingMap.keySet(), new com.google.common.collect.StandardTable.RowMap.EntrySet.AnonymousClass1());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(java.lang.Object obj) {
                if (!(obj instanceof java.util.Map.Entry)) {
                    return false;
                }
                java.util.Map.Entry entry = (java.util.Map.Entry) obj;
                return entry.getKey() != null && (entry.getValue() instanceof java.util.Map) && com.google.common.collect.StandardTable.this.backingMap.entrySet().remove(entry);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return com.google.common.collect.StandardTable.this.backingMap.size();
            }
        }

        public RowMap() {
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap
        public java.util.Set<java.util.Map.Entry<R, java.util.Map<C, V>>> a() {
            return new com.google.common.collect.StandardTable.RowMap.EntrySet();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(java.lang.Object obj) {
            return com.google.common.collect.StandardTable.this.containsRow(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public java.util.Map<C, V> get(java.lang.Object obj) {
            if (com.google.common.collect.StandardTable.this.containsRow(obj)) {
                return com.google.common.collect.StandardTable.this.row(obj);
            }
            return null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public java.util.Map<C, V> remove(java.lang.Object obj) {
            if (obj == null) {
                return null;
            }
            return com.google.common.collect.StandardTable.this.backingMap.remove(obj);
        }
    }

    public abstract class TableSet<T> extends com.google.common.collect.Sets.ImprovedAbstractSet<T> {
        public TableSet() {
        }

        public /* synthetic */ TableSet(com.google.common.collect.StandardTable standardTable, com.google.common.collect.StandardTable.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            com.google.common.collect.StandardTable.this.backingMap.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return com.google.common.collect.StandardTable.this.backingMap.isEmpty();
        }
    }

    public StandardTable(java.util.Map<R, java.util.Map<C, V>> map, com.google.common.base.Supplier<? extends java.util.Map<C, V>> supplier) {
        this.backingMap = map;
        this.factory = supplier;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean containsMapping(java.lang.Object obj, java.lang.Object obj2, java.lang.Object obj3) {
        return obj3 != null && obj3.equals(get(obj, obj2));
    }

    private java.util.Map<C, V> getOrCreate(R r) {
        java.util.Map<C, V> map = this.backingMap.get(r);
        if (map != null) {
            return map;
        }
        java.util.Map<C, V> map2 = this.factory.get();
        this.backingMap.put(r, map2);
        return map2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public java.util.Map<R, V> removeColumn(java.lang.Object obj) {
        java.util.LinkedHashMap linkedHashMap = new java.util.LinkedHashMap();
        java.util.Iterator<java.util.Map.Entry<R, java.util.Map<C, V>>> it = this.backingMap.entrySet().iterator();
        while (it.hasNext()) {
            java.util.Map.Entry<R, java.util.Map<C, V>> next = it.next();
            V remove = next.getValue().remove(obj);
            if (remove != null) {
                linkedHashMap.put(next.getKey(), remove);
                if (next.getValue().isEmpty()) {
                    it.remove();
                }
            }
        }
        return linkedHashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean removeMapping(java.lang.Object obj, java.lang.Object obj2, java.lang.Object obj3) {
        if (!containsMapping(obj, obj2, obj3)) {
            return false;
        }
        remove(obj, obj2);
        return true;
    }

    @Override // com.google.common.collect.AbstractTable
    public java.util.Iterator<com.google.common.collect.Table.Cell<R, C, V>> cellIterator() {
        return new com.google.common.collect.StandardTable.CellIterator(this, null);
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public java.util.Set<com.google.common.collect.Table.Cell<R, C, V>> cellSet() {
        return super.cellSet();
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public void clear() {
        this.backingMap.clear();
    }

    @Override // com.google.common.collect.Table
    public java.util.Map<R, V> column(C c) {
        return new com.google.common.collect.StandardTable.Column(c);
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public java.util.Set<C> columnKeySet() {
        java.util.Set<C> set = this.columnKeySet;
        if (set != null) {
            return set;
        }
        com.google.common.collect.StandardTable.ColumnKeySet columnKeySet = new com.google.common.collect.StandardTable.ColumnKeySet(this, null);
        this.columnKeySet = columnKeySet;
        return columnKeySet;
    }

    @Override // com.google.common.collect.Table
    public java.util.Map<C, java.util.Map<R, V>> columnMap() {
        com.google.common.collect.StandardTable<R, C, V>.ColumnMap columnMap = this.columnMap;
        if (columnMap != null) {
            return columnMap;
        }
        com.google.common.collect.StandardTable<R, C, V>.ColumnMap columnMap2 = new com.google.common.collect.StandardTable.ColumnMap(this, null);
        this.columnMap = columnMap2;
        return columnMap2;
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public boolean contains(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj2) {
        return (obj == null || obj2 == null || !super.contains(obj, obj2)) ? false : true;
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public boolean containsColumn(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        if (obj == null) {
            return false;
        }
        java.util.Iterator<java.util.Map<C, V>> it = this.backingMap.values().iterator();
        while (it.hasNext()) {
            if (com.google.common.collect.Maps.F(it.next(), obj)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public boolean containsRow(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        return obj != null && com.google.common.collect.Maps.F(this.backingMap, obj);
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public boolean containsValue(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        return obj != null && super.containsValue(obj);
    }

    public java.util.Iterator<C> createColumnKeyIterator() {
        return new com.google.common.collect.StandardTable.ColumnKeyIterator(this, null);
    }

    public java.util.Map<R, java.util.Map<C, V>> createRowMap() {
        return new com.google.common.collect.StandardTable.RowMap();
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public V get(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj2) {
        if (obj == null || obj2 == null) {
            return null;
        }
        return (V) super.get(obj, obj2);
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public boolean isEmpty() {
        return this.backingMap.isEmpty();
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public V put(R r, C c, V v) {
        com.google.common.base.Preconditions.checkNotNull(r);
        com.google.common.base.Preconditions.checkNotNull(c);
        com.google.common.base.Preconditions.checkNotNull(v);
        return getOrCreate(r).put(c, v);
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public V remove(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj2) {
        java.util.Map map;
        if (obj == null || obj2 == null || (map = (java.util.Map) com.google.common.collect.Maps.G(this.backingMap, obj)) == null) {
            return null;
        }
        V v = (V) map.remove(obj2);
        if (map.isEmpty()) {
            this.backingMap.remove(obj);
        }
        return v;
    }

    @Override // com.google.common.collect.Table
    public java.util.Map<C, V> row(R r) {
        return new com.google.common.collect.StandardTable.Row(r);
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public java.util.Set<R> rowKeySet() {
        return rowMap().keySet();
    }

    @Override // com.google.common.collect.Table
    public java.util.Map<R, java.util.Map<C, V>> rowMap() {
        java.util.Map<R, java.util.Map<C, V>> map = this.rowMap;
        if (map != null) {
            return map;
        }
        java.util.Map<R, java.util.Map<C, V>> createRowMap = createRowMap();
        this.rowMap = createRowMap;
        return createRowMap;
    }

    @Override // com.google.common.collect.Table
    public int size() {
        java.util.Iterator<java.util.Map<C, V>> it = this.backingMap.values().iterator();
        int i = 0;
        while (it.hasNext()) {
            i += it.next().size();
        }
        return i;
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public java.util.Collection<V> values() {
        return super.values();
    }
}
