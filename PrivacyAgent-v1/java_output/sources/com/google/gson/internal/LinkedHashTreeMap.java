package com.google.gson.internal;

/* loaded from: classes22.dex */
public final class LinkedHashTreeMap<K, V> extends java.util.AbstractMap<K, V> implements java.io.Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final java.util.Comparator<java.lang.Comparable> NATURAL_ORDER = new com.google.gson.internal.LinkedHashTreeMap.AnonymousClass1();
    java.util.Comparator<? super K> comparator;
    private com.google.gson.internal.LinkedHashTreeMap<K, V>.EntrySet entrySet;
    final com.google.gson.internal.LinkedHashTreeMap.Node<K, V> header;
    private com.google.gson.internal.LinkedHashTreeMap<K, V>.KeySet keySet;
    int modCount;
    int size;
    com.google.gson.internal.LinkedHashTreeMap.Node<K, V>[] table;
    int threshold;

    /* renamed from: com.google.gson.internal.LinkedHashTreeMap$1, reason: invalid class name */
    public class AnonymousClass1 implements java.util.Comparator<java.lang.Comparable> {
        @Override // java.util.Comparator
        public int compare(java.lang.Comparable comparable, java.lang.Comparable comparable2) {
            return comparable.compareTo(comparable2);
        }
    }

    public static final class AvlBuilder<K, V> {
        private int leavesSkipped;
        private int leavesToSkip;
        private int size;
        private com.google.gson.internal.LinkedHashTreeMap.Node<K, V> stack;

        public void add(com.google.gson.internal.LinkedHashTreeMap.Node<K, V> node) {
            node.right = null;
            node.parent = null;
            node.left = null;
            node.height = 1;
            int i = this.leavesToSkip;
            if (i > 0) {
                int i2 = this.size;
                if ((i2 & 1) == 0) {
                    this.size = i2 + 1;
                    this.leavesToSkip = i - 1;
                    this.leavesSkipped++;
                }
            }
            node.parent = this.stack;
            this.stack = node;
            int i3 = this.size + 1;
            this.size = i3;
            int i4 = this.leavesToSkip;
            if (i4 > 0 && (i3 & 1) == 0) {
                this.size = i3 + 1;
                this.leavesToSkip = i4 - 1;
                this.leavesSkipped++;
            }
            int i5 = 4;
            while (true) {
                int i6 = i5 - 1;
                if ((this.size & i6) != i6) {
                    return;
                }
                int i7 = this.leavesSkipped;
                if (i7 == 0) {
                    com.google.gson.internal.LinkedHashTreeMap.Node<K, V> node2 = this.stack;
                    com.google.gson.internal.LinkedHashTreeMap.Node<K, V> node3 = node2.parent;
                    com.google.gson.internal.LinkedHashTreeMap.Node<K, V> node4 = node3.parent;
                    node3.parent = node4.parent;
                    this.stack = node3;
                    node3.left = node4;
                    node3.right = node2;
                    node3.height = node2.height + 1;
                    node4.parent = node3;
                    node2.parent = node3;
                } else if (i7 == 1) {
                    com.google.gson.internal.LinkedHashTreeMap.Node<K, V> node5 = this.stack;
                    com.google.gson.internal.LinkedHashTreeMap.Node<K, V> node6 = node5.parent;
                    this.stack = node6;
                    node6.right = node5;
                    node6.height = node5.height + 1;
                    node5.parent = node6;
                    this.leavesSkipped = 0;
                } else if (i7 == 2) {
                    this.leavesSkipped = 0;
                }
                i5 *= 2;
            }
        }

        public void reset(int i) {
            this.leavesToSkip = ((java.lang.Integer.highestOneBit(i) * 2) - 1) - i;
            this.size = 0;
            this.leavesSkipped = 0;
            this.stack = null;
        }

        public com.google.gson.internal.LinkedHashTreeMap.Node<K, V> root() {
            com.google.gson.internal.LinkedHashTreeMap.Node<K, V> node = this.stack;
            if (node.parent == null) {
                return node;
            }
            throw new java.lang.IllegalStateException();
        }
    }

    public static class AvlIterator<K, V> {
        private com.google.gson.internal.LinkedHashTreeMap.Node<K, V> stackTop;

        public com.google.gson.internal.LinkedHashTreeMap.Node<K, V> next() {
            com.google.gson.internal.LinkedHashTreeMap.Node<K, V> node = this.stackTop;
            if (node == null) {
                return null;
            }
            com.google.gson.internal.LinkedHashTreeMap.Node<K, V> node2 = node.parent;
            node.parent = null;
            com.google.gson.internal.LinkedHashTreeMap.Node<K, V> node3 = node.right;
            while (true) {
                com.google.gson.internal.LinkedHashTreeMap.Node<K, V> node4 = node2;
                node2 = node3;
                if (node2 == null) {
                    this.stackTop = node4;
                    return node;
                }
                node2.parent = node4;
                node3 = node2.left;
            }
        }

        public void reset(com.google.gson.internal.LinkedHashTreeMap.Node<K, V> node) {
            com.google.gson.internal.LinkedHashTreeMap.Node<K, V> node2 = null;
            while (node != null) {
                node.parent = node2;
                node2 = node;
                node = node.left;
            }
            this.stackTop = node2;
        }
    }

    public final class EntrySet extends java.util.AbstractSet<java.util.Map.Entry<K, V>> {

        /* renamed from: com.google.gson.internal.LinkedHashTreeMap$EntrySet$1, reason: invalid class name */
        public class AnonymousClass1 extends com.google.gson.internal.LinkedHashTreeMap<K, V>.LinkedTreeMapIterator<java.util.Map.Entry<K, V>> {
            public AnonymousClass1() {
                super();
            }

            @Override // java.util.Iterator
            public java.util.Map.Entry<K, V> next() {
                return nextNode();
            }
        }

        public EntrySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            com.google.gson.internal.LinkedHashTreeMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(java.lang.Object obj) {
            return (obj instanceof java.util.Map.Entry) && com.google.gson.internal.LinkedHashTreeMap.this.findByEntry((java.util.Map.Entry) obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public java.util.Iterator<java.util.Map.Entry<K, V>> iterator() {
            return new com.google.gson.internal.LinkedHashTreeMap.EntrySet.AnonymousClass1();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(java.lang.Object obj) {
            com.google.gson.internal.LinkedHashTreeMap.Node<K, V> findByEntry;
            if (!(obj instanceof java.util.Map.Entry) || (findByEntry = com.google.gson.internal.LinkedHashTreeMap.this.findByEntry((java.util.Map.Entry) obj)) == null) {
                return false;
            }
            com.google.gson.internal.LinkedHashTreeMap.this.removeInternal(findByEntry, true);
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return com.google.gson.internal.LinkedHashTreeMap.this.size;
        }
    }

    public final class KeySet extends java.util.AbstractSet<K> {

        /* renamed from: com.google.gson.internal.LinkedHashTreeMap$KeySet$1, reason: invalid class name */
        public class AnonymousClass1 extends com.google.gson.internal.LinkedHashTreeMap<K, V>.LinkedTreeMapIterator<K> {
            public AnonymousClass1() {
                super();
            }

            @Override // java.util.Iterator
            public K next() {
                return nextNode().key;
            }
        }

        public KeySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            com.google.gson.internal.LinkedHashTreeMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(java.lang.Object obj) {
            return com.google.gson.internal.LinkedHashTreeMap.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public java.util.Iterator<K> iterator() {
            return new com.google.gson.internal.LinkedHashTreeMap.KeySet.AnonymousClass1();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(java.lang.Object obj) {
            return com.google.gson.internal.LinkedHashTreeMap.this.removeInternalByKey(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return com.google.gson.internal.LinkedHashTreeMap.this.size;
        }
    }

    public abstract class LinkedTreeMapIterator<T> implements java.util.Iterator<T> {
        int expectedModCount;
        com.google.gson.internal.LinkedHashTreeMap.Node<K, V> lastReturned = null;
        com.google.gson.internal.LinkedHashTreeMap.Node<K, V> next;

        public LinkedTreeMapIterator() {
            this.next = com.google.gson.internal.LinkedHashTreeMap.this.header.next;
            this.expectedModCount = com.google.gson.internal.LinkedHashTreeMap.this.modCount;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.next != com.google.gson.internal.LinkedHashTreeMap.this.header;
        }

        public final com.google.gson.internal.LinkedHashTreeMap.Node<K, V> nextNode() {
            com.google.gson.internal.LinkedHashTreeMap.Node<K, V> node = this.next;
            com.google.gson.internal.LinkedHashTreeMap linkedHashTreeMap = com.google.gson.internal.LinkedHashTreeMap.this;
            if (node == linkedHashTreeMap.header) {
                throw new java.util.NoSuchElementException();
            }
            if (linkedHashTreeMap.modCount != this.expectedModCount) {
                throw new java.util.ConcurrentModificationException();
            }
            this.next = node.next;
            this.lastReturned = node;
            return node;
        }

        @Override // java.util.Iterator
        public final void remove() {
            com.google.gson.internal.LinkedHashTreeMap.Node<K, V> node = this.lastReturned;
            if (node == null) {
                throw new java.lang.IllegalStateException();
            }
            com.google.gson.internal.LinkedHashTreeMap.this.removeInternal(node, true);
            this.lastReturned = null;
            this.expectedModCount = com.google.gson.internal.LinkedHashTreeMap.this.modCount;
        }
    }

    public static final class Node<K, V> implements java.util.Map.Entry<K, V> {
        final int hash;
        int height;
        final K key;
        com.google.gson.internal.LinkedHashTreeMap.Node<K, V> left;
        com.google.gson.internal.LinkedHashTreeMap.Node<K, V> next;
        com.google.gson.internal.LinkedHashTreeMap.Node<K, V> parent;
        com.google.gson.internal.LinkedHashTreeMap.Node<K, V> prev;
        com.google.gson.internal.LinkedHashTreeMap.Node<K, V> right;
        V value;

        public Node() {
            this.key = null;
            this.hash = -1;
            this.prev = this;
            this.next = this;
        }

        public Node(com.google.gson.internal.LinkedHashTreeMap.Node<K, V> node, K k, int i, com.google.gson.internal.LinkedHashTreeMap.Node<K, V> node2, com.google.gson.internal.LinkedHashTreeMap.Node<K, V> node3) {
            this.parent = node;
            this.key = k;
            this.hash = i;
            this.height = 1;
            this.next = node2;
            this.prev = node3;
            node3.next = this;
            node2.prev = this;
        }

        @Override // java.util.Map.Entry
        public boolean equals(java.lang.Object obj) {
            if (!(obj instanceof java.util.Map.Entry)) {
                return false;
            }
            java.util.Map.Entry entry = (java.util.Map.Entry) obj;
            K k = this.key;
            if (k == null) {
                if (entry.getKey() != null) {
                    return false;
                }
            } else if (!k.equals(entry.getKey())) {
                return false;
            }
            V v = this.value;
            if (v == null) {
                if (entry.getValue() != null) {
                    return false;
                }
            } else if (!v.equals(entry.getValue())) {
                return false;
            }
            return true;
        }

        public com.google.gson.internal.LinkedHashTreeMap.Node<K, V> first() {
            com.google.gson.internal.LinkedHashTreeMap.Node<K, V> node = this;
            for (com.google.gson.internal.LinkedHashTreeMap.Node<K, V> node2 = this.left; node2 != null; node2 = node2.left) {
                node = node2;
            }
            return node;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.key;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.value;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            K k = this.key;
            int hashCode = k == null ? 0 : k.hashCode();
            V v = this.value;
            return hashCode ^ (v != null ? v.hashCode() : 0);
        }

        public com.google.gson.internal.LinkedHashTreeMap.Node<K, V> last() {
            com.google.gson.internal.LinkedHashTreeMap.Node<K, V> node = this;
            for (com.google.gson.internal.LinkedHashTreeMap.Node<K, V> node2 = this.right; node2 != null; node2 = node2.right) {
                node = node2;
            }
            return node;
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            V v2 = this.value;
            this.value = v;
            return v2;
        }

        public java.lang.String toString() {
            return this.key + com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER + this.value;
        }
    }

    public LinkedHashTreeMap() {
        this(NATURAL_ORDER);
    }

    public LinkedHashTreeMap(java.util.Comparator<? super K> comparator) {
        this.size = 0;
        this.modCount = 0;
        this.comparator = comparator == null ? NATURAL_ORDER : comparator;
        this.header = new com.google.gson.internal.LinkedHashTreeMap.Node<>();
        com.google.gson.internal.LinkedHashTreeMap.Node<K, V>[] nodeArr = new com.google.gson.internal.LinkedHashTreeMap.Node[16];
        this.table = nodeArr;
        this.threshold = (nodeArr.length / 2) + (nodeArr.length / 4);
    }

    private void doubleCapacity() {
        com.google.gson.internal.LinkedHashTreeMap.Node<K, V>[] doubleCapacity = doubleCapacity(this.table);
        this.table = doubleCapacity;
        this.threshold = (doubleCapacity.length / 2) + (doubleCapacity.length / 4);
    }

    public static <K, V> com.google.gson.internal.LinkedHashTreeMap.Node<K, V>[] doubleCapacity(com.google.gson.internal.LinkedHashTreeMap.Node<K, V>[] nodeArr) {
        int length = nodeArr.length;
        com.google.gson.internal.LinkedHashTreeMap.Node<K, V>[] nodeArr2 = new com.google.gson.internal.LinkedHashTreeMap.Node[length * 2];
        com.google.gson.internal.LinkedHashTreeMap.AvlIterator avlIterator = new com.google.gson.internal.LinkedHashTreeMap.AvlIterator();
        com.google.gson.internal.LinkedHashTreeMap.AvlBuilder avlBuilder = new com.google.gson.internal.LinkedHashTreeMap.AvlBuilder();
        com.google.gson.internal.LinkedHashTreeMap.AvlBuilder avlBuilder2 = new com.google.gson.internal.LinkedHashTreeMap.AvlBuilder();
        for (int i = 0; i < length; i++) {
            com.google.gson.internal.LinkedHashTreeMap.Node<K, V> node = nodeArr[i];
            if (node != null) {
                avlIterator.reset(node);
                int i2 = 0;
                int i3 = 0;
                while (true) {
                    com.google.gson.internal.LinkedHashTreeMap.Node<K, V> next = avlIterator.next();
                    if (next == null) {
                        break;
                    }
                    if ((next.hash & length) == 0) {
                        i2++;
                    } else {
                        i3++;
                    }
                }
                avlBuilder.reset(i2);
                avlBuilder2.reset(i3);
                avlIterator.reset(node);
                while (true) {
                    com.google.gson.internal.LinkedHashTreeMap.Node<K, V> next2 = avlIterator.next();
                    if (next2 == null) {
                        break;
                    }
                    if ((next2.hash & length) == 0) {
                        avlBuilder.add(next2);
                    } else {
                        avlBuilder2.add(next2);
                    }
                }
                nodeArr2[i] = i2 > 0 ? avlBuilder.root() : null;
                nodeArr2[i + length] = i3 > 0 ? avlBuilder2.root() : null;
            }
        }
        return nodeArr2;
    }

    private boolean equal(java.lang.Object obj, java.lang.Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    private void rebalance(com.google.gson.internal.LinkedHashTreeMap.Node<K, V> node, boolean z) {
        while (node != null) {
            com.google.gson.internal.LinkedHashTreeMap.Node<K, V> node2 = node.left;
            com.google.gson.internal.LinkedHashTreeMap.Node<K, V> node3 = node.right;
            int i = node2 != null ? node2.height : 0;
            int i2 = node3 != null ? node3.height : 0;
            int i3 = i - i2;
            if (i3 == -2) {
                com.google.gson.internal.LinkedHashTreeMap.Node<K, V> node4 = node3.left;
                com.google.gson.internal.LinkedHashTreeMap.Node<K, V> node5 = node3.right;
                int i4 = (node4 != null ? node4.height : 0) - (node5 != null ? node5.height : 0);
                if (i4 == -1 || (i4 == 0 && !z)) {
                    rotateLeft(node);
                } else {
                    rotateRight(node3);
                    rotateLeft(node);
                }
                if (z) {
                    return;
                }
            } else if (i3 == 2) {
                com.google.gson.internal.LinkedHashTreeMap.Node<K, V> node6 = node2.left;
                com.google.gson.internal.LinkedHashTreeMap.Node<K, V> node7 = node2.right;
                int i5 = (node6 != null ? node6.height : 0) - (node7 != null ? node7.height : 0);
                if (i5 == 1 || (i5 == 0 && !z)) {
                    rotateRight(node);
                } else {
                    rotateLeft(node2);
                    rotateRight(node);
                }
                if (z) {
                    return;
                }
            } else if (i3 == 0) {
                node.height = i + 1;
                if (z) {
                    return;
                }
            } else {
                node.height = java.lang.Math.max(i, i2) + 1;
                if (!z) {
                    return;
                }
            }
            node = node.parent;
        }
    }

    private void replaceInParent(com.google.gson.internal.LinkedHashTreeMap.Node<K, V> node, com.google.gson.internal.LinkedHashTreeMap.Node<K, V> node2) {
        com.google.gson.internal.LinkedHashTreeMap.Node<K, V> node3 = node.parent;
        node.parent = null;
        if (node2 != null) {
            node2.parent = node3;
        }
        if (node3 == null) {
            int i = node.hash;
            this.table[i & (r0.length - 1)] = node2;
        } else if (node3.left == node) {
            node3.left = node2;
        } else {
            node3.right = node2;
        }
    }

    private void rotateLeft(com.google.gson.internal.LinkedHashTreeMap.Node<K, V> node) {
        com.google.gson.internal.LinkedHashTreeMap.Node<K, V> node2 = node.left;
        com.google.gson.internal.LinkedHashTreeMap.Node<K, V> node3 = node.right;
        com.google.gson.internal.LinkedHashTreeMap.Node<K, V> node4 = node3.left;
        com.google.gson.internal.LinkedHashTreeMap.Node<K, V> node5 = node3.right;
        node.right = node4;
        if (node4 != null) {
            node4.parent = node;
        }
        replaceInParent(node, node3);
        node3.left = node;
        node.parent = node3;
        int max = java.lang.Math.max(node2 != null ? node2.height : 0, node4 != null ? node4.height : 0) + 1;
        node.height = max;
        node3.height = java.lang.Math.max(max, node5 != null ? node5.height : 0) + 1;
    }

    private void rotateRight(com.google.gson.internal.LinkedHashTreeMap.Node<K, V> node) {
        com.google.gson.internal.LinkedHashTreeMap.Node<K, V> node2 = node.left;
        com.google.gson.internal.LinkedHashTreeMap.Node<K, V> node3 = node.right;
        com.google.gson.internal.LinkedHashTreeMap.Node<K, V> node4 = node2.left;
        com.google.gson.internal.LinkedHashTreeMap.Node<K, V> node5 = node2.right;
        node.left = node5;
        if (node5 != null) {
            node5.parent = node;
        }
        replaceInParent(node, node2);
        node2.right = node;
        node.parent = node2;
        int max = java.lang.Math.max(node3 != null ? node3.height : 0, node5 != null ? node5.height : 0) + 1;
        node.height = max;
        node2.height = java.lang.Math.max(max, node4 != null ? node4.height : 0) + 1;
    }

    private static int secondaryHash(int i) {
        int i2 = i ^ ((i >>> 20) ^ (i >>> 12));
        return (i2 >>> 4) ^ ((i2 >>> 7) ^ i2);
    }

    private java.lang.Object writeReplace() throws java.io.ObjectStreamException {
        return new java.util.LinkedHashMap(this);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        java.util.Arrays.fill(this.table, (java.lang.Object) null);
        this.size = 0;
        this.modCount++;
        com.google.gson.internal.LinkedHashTreeMap.Node<K, V> node = this.header;
        com.google.gson.internal.LinkedHashTreeMap.Node<K, V> node2 = node.next;
        while (node2 != node) {
            com.google.gson.internal.LinkedHashTreeMap.Node<K, V> node3 = node2.next;
            node2.prev = null;
            node2.next = null;
            node2 = node3;
        }
        node.prev = node;
        node.next = node;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(java.lang.Object obj) {
        return findByObject(obj) != null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public java.util.Set<java.util.Map.Entry<K, V>> entrySet() {
        com.google.gson.internal.LinkedHashTreeMap<K, V>.EntrySet entrySet = this.entrySet;
        if (entrySet != null) {
            return entrySet;
        }
        com.google.gson.internal.LinkedHashTreeMap<K, V>.EntrySet entrySet2 = new com.google.gson.internal.LinkedHashTreeMap.EntrySet();
        this.entrySet = entrySet2;
        return entrySet2;
    }

    public com.google.gson.internal.LinkedHashTreeMap.Node<K, V> find(K k, boolean z) {
        com.google.gson.internal.LinkedHashTreeMap.Node<K, V> node;
        int i;
        com.google.gson.internal.LinkedHashTreeMap.Node<K, V> node2;
        java.util.Comparator<? super K> comparator = this.comparator;
        com.google.gson.internal.LinkedHashTreeMap.Node<K, V>[] nodeArr = this.table;
        int secondaryHash = secondaryHash(k.hashCode());
        int length = (nodeArr.length - 1) & secondaryHash;
        com.google.gson.internal.LinkedHashTreeMap.Node<K, V> node3 = nodeArr[length];
        if (node3 != null) {
            java.lang.Comparable comparable = comparator == NATURAL_ORDER ? (java.lang.Comparable) k : null;
            while (true) {
                int compareTo = comparable != null ? comparable.compareTo(node3.key) : comparator.compare(k, node3.key);
                if (compareTo == 0) {
                    return node3;
                }
                com.google.gson.internal.LinkedHashTreeMap.Node<K, V> node4 = compareTo < 0 ? node3.left : node3.right;
                if (node4 == null) {
                    node = node3;
                    i = compareTo;
                    break;
                }
                node3 = node4;
            }
        } else {
            node = node3;
            i = 0;
        }
        if (!z) {
            return null;
        }
        com.google.gson.internal.LinkedHashTreeMap.Node<K, V> node5 = this.header;
        if (node != null) {
            node2 = new com.google.gson.internal.LinkedHashTreeMap.Node<>(node, k, secondaryHash, node5, node5.prev);
            if (i < 0) {
                node.left = node2;
            } else {
                node.right = node2;
            }
            rebalance(node, true);
        } else {
            if (comparator == NATURAL_ORDER && !(k instanceof java.lang.Comparable)) {
                throw new java.lang.ClassCastException(k.getClass().getName() + " is not Comparable");
            }
            node2 = new com.google.gson.internal.LinkedHashTreeMap.Node<>(node, k, secondaryHash, node5, node5.prev);
            nodeArr[length] = node2;
        }
        int i2 = this.size;
        this.size = i2 + 1;
        if (i2 > this.threshold) {
            doubleCapacity();
        }
        this.modCount++;
        return node2;
    }

    public com.google.gson.internal.LinkedHashTreeMap.Node<K, V> findByEntry(java.util.Map.Entry<?, ?> entry) {
        com.google.gson.internal.LinkedHashTreeMap.Node<K, V> findByObject = findByObject(entry.getKey());
        if (findByObject != null && equal(findByObject.value, entry.getValue())) {
            return findByObject;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public com.google.gson.internal.LinkedHashTreeMap.Node<K, V> findByObject(java.lang.Object obj) {
        if (obj == 0) {
            return null;
        }
        try {
            return find(obj, false);
        } catch (java.lang.ClassCastException unused) {
            return null;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(java.lang.Object obj) {
        com.google.gson.internal.LinkedHashTreeMap.Node<K, V> findByObject = findByObject(obj);
        if (findByObject != null) {
            return findByObject.value;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public java.util.Set<K> keySet() {
        com.google.gson.internal.LinkedHashTreeMap<K, V>.KeySet keySet = this.keySet;
        if (keySet != null) {
            return keySet;
        }
        com.google.gson.internal.LinkedHashTreeMap<K, V>.KeySet keySet2 = new com.google.gson.internal.LinkedHashTreeMap.KeySet();
        this.keySet = keySet2;
        return keySet2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k, V v) {
        if (k == null) {
            throw new java.lang.NullPointerException("key == null");
        }
        com.google.gson.internal.LinkedHashTreeMap.Node<K, V> find = find(k, true);
        V v2 = find.value;
        find.value = v;
        return v2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(java.lang.Object obj) {
        com.google.gson.internal.LinkedHashTreeMap.Node<K, V> removeInternalByKey = removeInternalByKey(obj);
        if (removeInternalByKey != null) {
            return removeInternalByKey.value;
        }
        return null;
    }

    public void removeInternal(com.google.gson.internal.LinkedHashTreeMap.Node<K, V> node, boolean z) {
        int i;
        if (z) {
            com.google.gson.internal.LinkedHashTreeMap.Node<K, V> node2 = node.prev;
            node2.next = node.next;
            node.next.prev = node2;
            node.prev = null;
            node.next = null;
        }
        com.google.gson.internal.LinkedHashTreeMap.Node<K, V> node3 = node.left;
        com.google.gson.internal.LinkedHashTreeMap.Node<K, V> node4 = node.right;
        com.google.gson.internal.LinkedHashTreeMap.Node<K, V> node5 = node.parent;
        int i2 = 0;
        if (node3 == null || node4 == null) {
            if (node3 != null) {
                replaceInParent(node, node3);
                node.left = null;
            } else if (node4 != null) {
                replaceInParent(node, node4);
                node.right = null;
            } else {
                replaceInParent(node, null);
            }
            rebalance(node5, false);
            this.size--;
            this.modCount++;
            return;
        }
        com.google.gson.internal.LinkedHashTreeMap.Node<K, V> last = node3.height > node4.height ? node3.last() : node4.first();
        removeInternal(last, false);
        com.google.gson.internal.LinkedHashTreeMap.Node<K, V> node6 = node.left;
        if (node6 != null) {
            i = node6.height;
            last.left = node6;
            node6.parent = last;
            node.left = null;
        } else {
            i = 0;
        }
        com.google.gson.internal.LinkedHashTreeMap.Node<K, V> node7 = node.right;
        if (node7 != null) {
            i2 = node7.height;
            last.right = node7;
            node7.parent = last;
            node.right = null;
        }
        last.height = java.lang.Math.max(i, i2) + 1;
        replaceInParent(node, last);
    }

    public com.google.gson.internal.LinkedHashTreeMap.Node<K, V> removeInternalByKey(java.lang.Object obj) {
        com.google.gson.internal.LinkedHashTreeMap.Node<K, V> findByObject = findByObject(obj);
        if (findByObject != null) {
            removeInternal(findByObject, true);
        }
        return findByObject;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.size;
    }
}
