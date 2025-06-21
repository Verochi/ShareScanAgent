package com.google.common.collect;

@com.google.common.annotations.GwtCompatible(emulated = true, serializable = true)
/* loaded from: classes22.dex */
public class LinkedListMultimap<K, V> extends com.google.common.collect.AbstractMultimap<K, V> implements com.google.common.collect.ListMultimap<K, V>, java.io.Serializable {

    @com.google.common.annotations.GwtIncompatible
    private static final long serialVersionUID = 0;

    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    private transient com.google.common.collect.LinkedListMultimap.Node<K, V> head;
    private transient java.util.Map<K, com.google.common.collect.LinkedListMultimap.KeyList<K, V>> keyToKeyList;
    private transient int modCount;
    private transient int size;

    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    private transient com.google.common.collect.LinkedListMultimap.Node<K, V> tail;

    /* renamed from: com.google.common.collect.LinkedListMultimap$1, reason: invalid class name */
    public class AnonymousClass1 extends java.util.AbstractSequentialList<V> {
        public final /* synthetic */ java.lang.Object n;

        public AnonymousClass1(java.lang.Object obj) {
            this.n = obj;
        }

        @Override // java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
        public java.util.ListIterator<V> listIterator(int i) {
            return new com.google.common.collect.LinkedListMultimap.ValueForKeyIterator(this.n, i);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            com.google.common.collect.LinkedListMultimap.KeyList keyList = (com.google.common.collect.LinkedListMultimap.KeyList) com.google.common.collect.LinkedListMultimap.this.keyToKeyList.get(this.n);
            if (keyList == null) {
                return 0;
            }
            return keyList.c;
        }
    }

    /* renamed from: com.google.common.collect.LinkedListMultimap$1EntriesImpl, reason: invalid class name */
    public class C1EntriesImpl extends java.util.AbstractSequentialList<java.util.Map.Entry<K, V>> {
        public C1EntriesImpl() {
        }

        @Override // java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
        public java.util.ListIterator<java.util.Map.Entry<K, V>> listIterator(int i) {
            return new com.google.common.collect.LinkedListMultimap.NodeIterator(i);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return com.google.common.collect.LinkedListMultimap.this.size;
        }
    }

    /* renamed from: com.google.common.collect.LinkedListMultimap$1KeySetImpl, reason: invalid class name */
    public class C1KeySetImpl extends com.google.common.collect.Sets.ImprovedAbstractSet<K> {
        public C1KeySetImpl() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(java.lang.Object obj) {
            return com.google.common.collect.LinkedListMultimap.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public java.util.Iterator<K> iterator() {
            return new com.google.common.collect.LinkedListMultimap.DistinctKeyIterator(com.google.common.collect.LinkedListMultimap.this, null);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(java.lang.Object obj) {
            return !com.google.common.collect.LinkedListMultimap.this.removeAll(obj).isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return com.google.common.collect.LinkedListMultimap.this.keyToKeyList.size();
        }
    }

    /* renamed from: com.google.common.collect.LinkedListMultimap$1ValuesImpl, reason: invalid class name */
    public class C1ValuesImpl extends java.util.AbstractSequentialList<V> {

        /* renamed from: com.google.common.collect.LinkedListMultimap$1ValuesImpl$1, reason: invalid class name */
        public class AnonymousClass1 extends com.google.common.collect.TransformedListIterator<java.util.Map.Entry<K, V>, V> {
            public final /* synthetic */ com.google.common.collect.LinkedListMultimap.NodeIterator t;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(java.util.ListIterator listIterator, com.google.common.collect.LinkedListMultimap.NodeIterator nodeIterator) {
                super(listIterator);
                this.t = nodeIterator;
            }

            @Override // com.google.common.collect.TransformedIterator
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public V a(java.util.Map.Entry<K, V> entry) {
                return entry.getValue();
            }

            @Override // com.google.common.collect.TransformedListIterator, java.util.ListIterator
            public void set(V v) {
                this.t.f(v);
            }
        }

        public C1ValuesImpl() {
        }

        @Override // java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
        public java.util.ListIterator<V> listIterator(int i) {
            com.google.common.collect.LinkedListMultimap.NodeIterator nodeIterator = new com.google.common.collect.LinkedListMultimap.NodeIterator(i);
            return new com.google.common.collect.LinkedListMultimap.C1ValuesImpl.AnonymousClass1(nodeIterator, nodeIterator);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return com.google.common.collect.LinkedListMultimap.this.size;
        }
    }

    public class DistinctKeyIterator implements java.util.Iterator<K> {
        public final java.util.Set<K> n;
        public com.google.common.collect.LinkedListMultimap.Node<K, V> t;

        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        public com.google.common.collect.LinkedListMultimap.Node<K, V> u;
        public int v;

        public DistinctKeyIterator() {
            this.n = com.google.common.collect.Sets.newHashSetWithExpectedSize(com.google.common.collect.LinkedListMultimap.this.keySet().size());
            this.t = com.google.common.collect.LinkedListMultimap.this.head;
            this.v = com.google.common.collect.LinkedListMultimap.this.modCount;
        }

        public /* synthetic */ DistinctKeyIterator(com.google.common.collect.LinkedListMultimap linkedListMultimap, com.google.common.collect.LinkedListMultimap.AnonymousClass1 anonymousClass1) {
            this();
        }

        public final void a() {
            if (com.google.common.collect.LinkedListMultimap.this.modCount != this.v) {
                throw new java.util.ConcurrentModificationException();
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            a();
            return this.t != null;
        }

        @Override // java.util.Iterator
        public K next() {
            com.google.common.collect.LinkedListMultimap.Node<K, V> node;
            a();
            com.google.common.collect.LinkedListMultimap.checkElement(this.t);
            com.google.common.collect.LinkedListMultimap.Node<K, V> node2 = this.t;
            this.u = node2;
            this.n.add(node2.n);
            do {
                node = this.t.u;
                this.t = node;
                if (node == null) {
                    break;
                }
            } while (!this.n.add(node.n));
            return this.u.n;
        }

        @Override // java.util.Iterator
        public void remove() {
            a();
            com.google.common.collect.CollectPreconditions.e(this.u != null);
            com.google.common.collect.LinkedListMultimap.this.removeAllNodes(this.u.n);
            this.u = null;
            this.v = com.google.common.collect.LinkedListMultimap.this.modCount;
        }
    }

    public static class KeyList<K, V> {
        public com.google.common.collect.LinkedListMultimap.Node<K, V> a;
        public com.google.common.collect.LinkedListMultimap.Node<K, V> b;
        public int c;

        public KeyList(com.google.common.collect.LinkedListMultimap.Node<K, V> node) {
            this.a = node;
            this.b = node;
            node.x = null;
            node.w = null;
            this.c = 1;
        }
    }

    public static final class Node<K, V> extends com.google.common.collect.AbstractMapEntry<K, V> {

        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        public final K n;

        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        public V t;

        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        public com.google.common.collect.LinkedListMultimap.Node<K, V> u;

        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        public com.google.common.collect.LinkedListMultimap.Node<K, V> v;

        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        public com.google.common.collect.LinkedListMultimap.Node<K, V> w;

        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        public com.google.common.collect.LinkedListMultimap.Node<K, V> x;

        public Node(@org.checkerframework.checker.nullness.compatqual.NullableDecl K k, @org.checkerframework.checker.nullness.compatqual.NullableDecl V v) {
            this.n = k;
            this.t = v;
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        public K getKey() {
            return this.n;
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        public V getValue() {
            return this.t;
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        public V setValue(@org.checkerframework.checker.nullness.compatqual.NullableDecl V v) {
            V v2 = this.t;
            this.t = v;
            return v2;
        }
    }

    public class NodeIterator implements java.util.ListIterator<java.util.Map.Entry<K, V>> {
        public int n;

        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        public com.google.common.collect.LinkedListMultimap.Node<K, V> t;

        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        public com.google.common.collect.LinkedListMultimap.Node<K, V> u;

        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        public com.google.common.collect.LinkedListMultimap.Node<K, V> v;
        public int w;

        public NodeIterator(int i) {
            this.w = com.google.common.collect.LinkedListMultimap.this.modCount;
            int size = com.google.common.collect.LinkedListMultimap.this.size();
            com.google.common.base.Preconditions.checkPositionIndex(i, size);
            if (i < size / 2) {
                this.t = com.google.common.collect.LinkedListMultimap.this.head;
                while (true) {
                    int i2 = i - 1;
                    if (i <= 0) {
                        break;
                    }
                    next();
                    i = i2;
                }
            } else {
                this.v = com.google.common.collect.LinkedListMultimap.this.tail;
                this.n = size;
                while (true) {
                    int i3 = i + 1;
                    if (i >= size) {
                        break;
                    }
                    previous();
                    i = i3;
                }
            }
            this.u = null;
        }

        @Override // java.util.ListIterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void add(java.util.Map.Entry<K, V> entry) {
            throw new java.lang.UnsupportedOperationException();
        }

        public final void b() {
            if (com.google.common.collect.LinkedListMultimap.this.modCount != this.w) {
                throw new java.util.ConcurrentModificationException();
            }
        }

        @Override // java.util.ListIterator, java.util.Iterator
        @com.google.errorprone.annotations.CanIgnoreReturnValue
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public com.google.common.collect.LinkedListMultimap.Node<K, V> next() {
            b();
            com.google.common.collect.LinkedListMultimap.checkElement(this.t);
            com.google.common.collect.LinkedListMultimap.Node<K, V> node = this.t;
            this.u = node;
            this.v = node;
            this.t = node.u;
            this.n++;
            return node;
        }

        @Override // java.util.ListIterator
        @com.google.errorprone.annotations.CanIgnoreReturnValue
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public com.google.common.collect.LinkedListMultimap.Node<K, V> previous() {
            b();
            com.google.common.collect.LinkedListMultimap.checkElement(this.v);
            com.google.common.collect.LinkedListMultimap.Node<K, V> node = this.v;
            this.u = node;
            this.t = node;
            this.v = node.v;
            this.n--;
            return node;
        }

        @Override // java.util.ListIterator
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void set(java.util.Map.Entry<K, V> entry) {
            throw new java.lang.UnsupportedOperationException();
        }

        public void f(V v) {
            com.google.common.base.Preconditions.checkState(this.u != null);
            this.u.t = v;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            b();
            return this.t != null;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            b();
            return this.v != null;
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.n;
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.n - 1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            b();
            com.google.common.collect.CollectPreconditions.e(this.u != null);
            com.google.common.collect.LinkedListMultimap.Node<K, V> node = this.u;
            if (node != this.t) {
                this.v = node.v;
                this.n--;
            } else {
                this.t = node.u;
            }
            com.google.common.collect.LinkedListMultimap.this.removeNode(node);
            this.u = null;
            this.w = com.google.common.collect.LinkedListMultimap.this.modCount;
        }
    }

    public class ValueForKeyIterator implements java.util.ListIterator<V> {

        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        public final java.lang.Object n;
        public int t;

        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        public com.google.common.collect.LinkedListMultimap.Node<K, V> u;

        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        public com.google.common.collect.LinkedListMultimap.Node<K, V> v;

        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        public com.google.common.collect.LinkedListMultimap.Node<K, V> w;

        public ValueForKeyIterator(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            this.n = obj;
            com.google.common.collect.LinkedListMultimap.KeyList keyList = (com.google.common.collect.LinkedListMultimap.KeyList) com.google.common.collect.LinkedListMultimap.this.keyToKeyList.get(obj);
            this.u = keyList == null ? null : keyList.a;
        }

        public ValueForKeyIterator(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj, int i) {
            com.google.common.collect.LinkedListMultimap.KeyList keyList = (com.google.common.collect.LinkedListMultimap.KeyList) com.google.common.collect.LinkedListMultimap.this.keyToKeyList.get(obj);
            int i2 = keyList == null ? 0 : keyList.c;
            com.google.common.base.Preconditions.checkPositionIndex(i, i2);
            if (i < i2 / 2) {
                this.u = keyList == null ? null : keyList.a;
                while (true) {
                    int i3 = i - 1;
                    if (i <= 0) {
                        break;
                    }
                    next();
                    i = i3;
                }
            } else {
                this.w = keyList == null ? null : keyList.b;
                this.t = i2;
                while (true) {
                    int i4 = i + 1;
                    if (i >= i2) {
                        break;
                    }
                    previous();
                    i = i4;
                }
            }
            this.n = obj;
            this.v = null;
        }

        @Override // java.util.ListIterator
        public void add(V v) {
            this.w = com.google.common.collect.LinkedListMultimap.this.addNode(this.n, v, this.u);
            this.t++;
            this.v = null;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.u != null;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.w != null;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        @com.google.errorprone.annotations.CanIgnoreReturnValue
        public V next() {
            com.google.common.collect.LinkedListMultimap.checkElement(this.u);
            com.google.common.collect.LinkedListMultimap.Node<K, V> node = this.u;
            this.v = node;
            this.w = node;
            this.u = node.w;
            this.t++;
            return node.t;
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.t;
        }

        @Override // java.util.ListIterator
        @com.google.errorprone.annotations.CanIgnoreReturnValue
        public V previous() {
            com.google.common.collect.LinkedListMultimap.checkElement(this.w);
            com.google.common.collect.LinkedListMultimap.Node<K, V> node = this.w;
            this.v = node;
            this.u = node;
            this.w = node.x;
            this.t--;
            return node.t;
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.t - 1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            com.google.common.collect.CollectPreconditions.e(this.v != null);
            com.google.common.collect.LinkedListMultimap.Node<K, V> node = this.v;
            if (node != this.u) {
                this.w = node.x;
                this.t--;
            } else {
                this.u = node.w;
            }
            com.google.common.collect.LinkedListMultimap.this.removeNode(node);
            this.v = null;
        }

        @Override // java.util.ListIterator
        public void set(V v) {
            com.google.common.base.Preconditions.checkState(this.v != null);
            this.v.t = v;
        }
    }

    public LinkedListMultimap() {
        this(12);
    }

    private LinkedListMultimap(int i) {
        this.keyToKeyList = com.google.common.collect.Platform.c(i);
    }

    private LinkedListMultimap(com.google.common.collect.Multimap<? extends K, ? extends V> multimap) {
        this(multimap.keySet().size());
        putAll(multimap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public com.google.common.collect.LinkedListMultimap.Node<K, V> addNode(@org.checkerframework.checker.nullness.compatqual.NullableDecl K k, @org.checkerframework.checker.nullness.compatqual.NullableDecl V v, @org.checkerframework.checker.nullness.compatqual.NullableDecl com.google.common.collect.LinkedListMultimap.Node<K, V> node) {
        com.google.common.collect.LinkedListMultimap.Node<K, V> node2 = new com.google.common.collect.LinkedListMultimap.Node<>(k, v);
        if (this.head == null) {
            this.tail = node2;
            this.head = node2;
            this.keyToKeyList.put(k, new com.google.common.collect.LinkedListMultimap.KeyList<>(node2));
            this.modCount++;
        } else if (node == null) {
            com.google.common.collect.LinkedListMultimap.Node<K, V> node3 = this.tail;
            node3.u = node2;
            node2.v = node3;
            this.tail = node2;
            com.google.common.collect.LinkedListMultimap.KeyList<K, V> keyList = this.keyToKeyList.get(k);
            if (keyList == null) {
                this.keyToKeyList.put(k, new com.google.common.collect.LinkedListMultimap.KeyList<>(node2));
                this.modCount++;
            } else {
                keyList.c++;
                com.google.common.collect.LinkedListMultimap.Node<K, V> node4 = keyList.b;
                node4.w = node2;
                node2.x = node4;
                keyList.b = node2;
            }
        } else {
            this.keyToKeyList.get(k).c++;
            node2.v = node.v;
            node2.x = node.x;
            node2.u = node;
            node2.w = node;
            com.google.common.collect.LinkedListMultimap.Node<K, V> node5 = node.x;
            if (node5 == null) {
                this.keyToKeyList.get(k).a = node2;
            } else {
                node5.w = node2;
            }
            com.google.common.collect.LinkedListMultimap.Node<K, V> node6 = node.v;
            if (node6 == null) {
                this.head = node2;
            } else {
                node6.u = node2;
            }
            node.v = node2;
            node.x = node2;
        }
        this.size++;
        return node2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void checkElement(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        if (obj == null) {
            throw new java.util.NoSuchElementException();
        }
    }

    public static <K, V> com.google.common.collect.LinkedListMultimap<K, V> create() {
        return new com.google.common.collect.LinkedListMultimap<>();
    }

    public static <K, V> com.google.common.collect.LinkedListMultimap<K, V> create(int i) {
        return new com.google.common.collect.LinkedListMultimap<>(i);
    }

    public static <K, V> com.google.common.collect.LinkedListMultimap<K, V> create(com.google.common.collect.Multimap<? extends K, ? extends V> multimap) {
        return new com.google.common.collect.LinkedListMultimap<>(multimap);
    }

    private java.util.List<V> getCopy(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        return java.util.Collections.unmodifiableList(com.google.common.collect.Lists.newArrayList(new com.google.common.collect.LinkedListMultimap.ValueForKeyIterator(obj)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @com.google.common.annotations.GwtIncompatible
    private void readObject(java.io.ObjectInputStream objectInputStream) throws java.io.IOException, java.lang.ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.keyToKeyList = com.google.common.collect.CompactLinkedHashMap.create();
        int readInt = objectInputStream.readInt();
        for (int i = 0; i < readInt; i++) {
            put(objectInputStream.readObject(), objectInputStream.readObject());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeAllNodes(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        com.google.common.collect.Iterators.c(new com.google.common.collect.LinkedListMultimap.ValueForKeyIterator(obj));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeNode(com.google.common.collect.LinkedListMultimap.Node<K, V> node) {
        com.google.common.collect.LinkedListMultimap.Node<K, V> node2 = node.v;
        if (node2 != null) {
            node2.u = node.u;
        } else {
            this.head = node.u;
        }
        com.google.common.collect.LinkedListMultimap.Node<K, V> node3 = node.u;
        if (node3 != null) {
            node3.v = node2;
        } else {
            this.tail = node2;
        }
        if (node.x == null && node.w == null) {
            this.keyToKeyList.remove(node.n).c = 0;
            this.modCount++;
        } else {
            com.google.common.collect.LinkedListMultimap.KeyList<K, V> keyList = this.keyToKeyList.get(node.n);
            keyList.c--;
            com.google.common.collect.LinkedListMultimap.Node<K, V> node4 = node.x;
            if (node4 == null) {
                keyList.a = node.w;
            } else {
                node4.w = node.w;
            }
            com.google.common.collect.LinkedListMultimap.Node<K, V> node5 = node.w;
            if (node5 == null) {
                keyList.b = node4;
            } else {
                node5.x = node4;
            }
        }
        this.size--;
    }

    @com.google.common.annotations.GwtIncompatible
    private void writeObject(java.io.ObjectOutputStream objectOutputStream) throws java.io.IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(size());
        for (java.util.Map.Entry<K, V> entry : entries()) {
            objectOutputStream.writeObject(entry.getKey());
            objectOutputStream.writeObject(entry.getValue());
        }
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public /* bridge */ /* synthetic */ java.util.Map asMap() {
        return super.asMap();
    }

    @Override // com.google.common.collect.Multimap
    public void clear() {
        this.head = null;
        this.tail = null;
        this.keyToKeyList.clear();
        this.size = 0;
        this.modCount++;
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ boolean containsEntry(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj2) {
        return super.containsEntry(obj, obj2);
    }

    @Override // com.google.common.collect.Multimap
    public boolean containsKey(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        return this.keyToKeyList.containsKey(obj);
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public boolean containsValue(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        return values().contains(obj);
    }

    @Override // com.google.common.collect.AbstractMultimap
    public java.util.Map<K, java.util.Collection<V>> createAsMap() {
        return new com.google.common.collect.Multimaps.AsMap(this);
    }

    @Override // com.google.common.collect.AbstractMultimap
    public java.util.List<java.util.Map.Entry<K, V>> createEntries() {
        return new com.google.common.collect.LinkedListMultimap.C1EntriesImpl();
    }

    @Override // com.google.common.collect.AbstractMultimap
    public java.util.Set<K> createKeySet() {
        return new com.google.common.collect.LinkedListMultimap.C1KeySetImpl();
    }

    @Override // com.google.common.collect.AbstractMultimap
    public com.google.common.collect.Multiset<K> createKeys() {
        return new com.google.common.collect.Multimaps.Keys(this);
    }

    @Override // com.google.common.collect.AbstractMultimap
    public java.util.List<V> createValues() {
        return new com.google.common.collect.LinkedListMultimap.C1ValuesImpl();
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public java.util.List<java.util.Map.Entry<K, V>> entries() {
        return (java.util.List) super.entries();
    }

    @Override // com.google.common.collect.AbstractMultimap
    public java.util.Iterator<java.util.Map.Entry<K, V>> entryIterator() {
        throw new java.lang.AssertionError("should never be called");
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public /* bridge */ /* synthetic */ boolean equals(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        return super.equals(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ java.util.Collection get(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        return get((com.google.common.collect.LinkedListMultimap<K, V>) obj);
    }

    @Override // com.google.common.collect.Multimap
    public java.util.List<V> get(@org.checkerframework.checker.nullness.compatqual.NullableDecl K k) {
        return new com.google.common.collect.LinkedListMultimap.AnonymousClass1(k);
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public boolean isEmpty() {
        return this.head == null;
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ java.util.Set keySet() {
        return super.keySet();
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ com.google.common.collect.Multiset keys() {
        return super.keys();
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public boolean put(@org.checkerframework.checker.nullness.compatqual.NullableDecl K k, @org.checkerframework.checker.nullness.compatqual.NullableDecl V v) {
        addNode(k, v, null);
        return true;
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ boolean putAll(com.google.common.collect.Multimap multimap) {
        return super.putAll(multimap);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ boolean putAll(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj, java.lang.Iterable iterable) {
        return super.putAll(obj, iterable);
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ boolean remove(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj2) {
        return super.remove(obj, obj2);
    }

    @Override // com.google.common.collect.Multimap
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public java.util.List<V> removeAll(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        java.util.List<V> copy = getCopy(obj);
        removeAllNodes(obj);
        return copy;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ java.util.Collection replaceValues(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj, java.lang.Iterable iterable) {
        return replaceValues((com.google.common.collect.LinkedListMultimap<K, V>) obj, iterable);
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public java.util.List<V> replaceValues(@org.checkerframework.checker.nullness.compatqual.NullableDecl K k, java.lang.Iterable<? extends V> iterable) {
        java.util.List<V> copy = getCopy(k);
        com.google.common.collect.LinkedListMultimap.ValueForKeyIterator valueForKeyIterator = new com.google.common.collect.LinkedListMultimap.ValueForKeyIterator(k);
        java.util.Iterator<? extends V> it = iterable.iterator();
        while (valueForKeyIterator.hasNext() && it.hasNext()) {
            valueForKeyIterator.next();
            valueForKeyIterator.set(it.next());
        }
        while (valueForKeyIterator.hasNext()) {
            valueForKeyIterator.next();
            valueForKeyIterator.remove();
        }
        while (it.hasNext()) {
            valueForKeyIterator.add(it.next());
        }
        return copy;
    }

    @Override // com.google.common.collect.Multimap
    public int size() {
        return this.size;
    }

    @Override // com.google.common.collect.AbstractMultimap
    public /* bridge */ /* synthetic */ java.lang.String toString() {
        return super.toString();
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public java.util.List<V> values() {
        return (java.util.List) super.values();
    }
}
