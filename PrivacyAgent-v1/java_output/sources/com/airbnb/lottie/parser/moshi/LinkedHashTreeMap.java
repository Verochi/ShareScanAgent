package com.airbnb.lottie.parser.moshi;

/* loaded from: classes.dex */
final class LinkedHashTreeMap<K, V> extends java.util.AbstractMap<K, V> implements java.io.Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final java.util.Comparator<java.lang.Comparable> NATURAL_ORDER = new com.airbnb.lottie.parser.moshi.LinkedHashTreeMap.AnonymousClass1();
    java.util.Comparator<? super K> comparator;
    private com.airbnb.lottie.parser.moshi.LinkedHashTreeMap<K, V>.EntrySet entrySet;
    final com.airbnb.lottie.parser.moshi.LinkedHashTreeMap.Node<K, V> header;
    private com.airbnb.lottie.parser.moshi.LinkedHashTreeMap<K, V>.KeySet keySet;
    int modCount;
    int size;
    com.airbnb.lottie.parser.moshi.LinkedHashTreeMap.Node<K, V>[] table;
    int threshold;

    /* renamed from: com.airbnb.lottie.parser.moshi.LinkedHashTreeMap$1, reason: invalid class name */
    public class AnonymousClass1 implements java.util.Comparator<java.lang.Comparable> {
        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(java.lang.Comparable comparable, java.lang.Comparable comparable2) {
            return comparable.compareTo(comparable2);
        }
    }

    public static final class AvlBuilder<K, V> {
        public com.airbnb.lottie.parser.moshi.LinkedHashTreeMap.Node<K, V> a;
        public int b;
        public int c;
        public int d;

        public void a(com.airbnb.lottie.parser.moshi.LinkedHashTreeMap.Node<K, V> node) {
            node.u = null;
            node.n = null;
            node.t = null;
            node.A = 1;
            int i = this.b;
            if (i > 0) {
                int i2 = this.d;
                if ((i2 & 1) == 0) {
                    this.d = i2 + 1;
                    this.b = i - 1;
                    this.c++;
                }
            }
            node.n = this.a;
            this.a = node;
            int i3 = this.d + 1;
            this.d = i3;
            int i4 = this.b;
            if (i4 > 0 && (i3 & 1) == 0) {
                this.d = i3 + 1;
                this.b = i4 - 1;
                this.c++;
            }
            int i5 = 4;
            while (true) {
                int i6 = i5 - 1;
                if ((this.d & i6) != i6) {
                    return;
                }
                int i7 = this.c;
                if (i7 == 0) {
                    com.airbnb.lottie.parser.moshi.LinkedHashTreeMap.Node<K, V> node2 = this.a;
                    com.airbnb.lottie.parser.moshi.LinkedHashTreeMap.Node<K, V> node3 = node2.n;
                    com.airbnb.lottie.parser.moshi.LinkedHashTreeMap.Node<K, V> node4 = node3.n;
                    node3.n = node4.n;
                    this.a = node3;
                    node3.t = node4;
                    node3.u = node2;
                    node3.A = node2.A + 1;
                    node4.n = node3;
                    node2.n = node3;
                } else if (i7 == 1) {
                    com.airbnb.lottie.parser.moshi.LinkedHashTreeMap.Node<K, V> node5 = this.a;
                    com.airbnb.lottie.parser.moshi.LinkedHashTreeMap.Node<K, V> node6 = node5.n;
                    this.a = node6;
                    node6.u = node5;
                    node6.A = node5.A + 1;
                    node5.n = node6;
                    this.c = 0;
                } else if (i7 == 2) {
                    this.c = 0;
                }
                i5 *= 2;
            }
        }

        public void b(int i) {
            this.b = ((java.lang.Integer.highestOneBit(i) * 2) - 1) - i;
            this.d = 0;
            this.c = 0;
            this.a = null;
        }

        public com.airbnb.lottie.parser.moshi.LinkedHashTreeMap.Node<K, V> c() {
            com.airbnb.lottie.parser.moshi.LinkedHashTreeMap.Node<K, V> node = this.a;
            if (node.n == null) {
                return node;
            }
            throw new java.lang.IllegalStateException();
        }
    }

    public static class AvlIterator<K, V> {
        public com.airbnb.lottie.parser.moshi.LinkedHashTreeMap.Node<K, V> a;

        public com.airbnb.lottie.parser.moshi.LinkedHashTreeMap.Node<K, V> a() {
            com.airbnb.lottie.parser.moshi.LinkedHashTreeMap.Node<K, V> node = this.a;
            if (node == null) {
                return null;
            }
            com.airbnb.lottie.parser.moshi.LinkedHashTreeMap.Node<K, V> node2 = node.n;
            node.n = null;
            com.airbnb.lottie.parser.moshi.LinkedHashTreeMap.Node<K, V> node3 = node.u;
            while (true) {
                com.airbnb.lottie.parser.moshi.LinkedHashTreeMap.Node<K, V> node4 = node2;
                node2 = node3;
                if (node2 == null) {
                    this.a = node4;
                    return node;
                }
                node2.n = node4;
                node3 = node2.t;
            }
        }

        public void b(com.airbnb.lottie.parser.moshi.LinkedHashTreeMap.Node<K, V> node) {
            com.airbnb.lottie.parser.moshi.LinkedHashTreeMap.Node<K, V> node2 = null;
            while (node != null) {
                node.n = node2;
                node2 = node;
                node = node.t;
            }
            this.a = node2;
        }
    }

    public final class EntrySet extends java.util.AbstractSet<java.util.Map.Entry<K, V>> {

        /* renamed from: com.airbnb.lottie.parser.moshi.LinkedHashTreeMap$EntrySet$1, reason: invalid class name */
        public class AnonymousClass1 extends com.airbnb.lottie.parser.moshi.LinkedHashTreeMap<K, V>.LinkedTreeMapIterator<java.util.Map.Entry<K, V>> {
            public AnonymousClass1() {
                super();
            }

            @Override // java.util.Iterator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public java.util.Map.Entry<K, V> next() {
                return a();
            }
        }

        public EntrySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            com.airbnb.lottie.parser.moshi.LinkedHashTreeMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(java.lang.Object obj) {
            return (obj instanceof java.util.Map.Entry) && com.airbnb.lottie.parser.moshi.LinkedHashTreeMap.this.findByEntry((java.util.Map.Entry) obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public java.util.Iterator<java.util.Map.Entry<K, V>> iterator() {
            return new com.airbnb.lottie.parser.moshi.LinkedHashTreeMap.EntrySet.AnonymousClass1();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(java.lang.Object obj) {
            com.airbnb.lottie.parser.moshi.LinkedHashTreeMap.Node<K, V> findByEntry;
            if (!(obj instanceof java.util.Map.Entry) || (findByEntry = com.airbnb.lottie.parser.moshi.LinkedHashTreeMap.this.findByEntry((java.util.Map.Entry) obj)) == null) {
                return false;
            }
            com.airbnb.lottie.parser.moshi.LinkedHashTreeMap.this.removeInternal(findByEntry, true);
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return com.airbnb.lottie.parser.moshi.LinkedHashTreeMap.this.size;
        }
    }

    public final class KeySet extends java.util.AbstractSet<K> {

        /* renamed from: com.airbnb.lottie.parser.moshi.LinkedHashTreeMap$KeySet$1, reason: invalid class name */
        public class AnonymousClass1 extends com.airbnb.lottie.parser.moshi.LinkedHashTreeMap<K, V>.LinkedTreeMapIterator<K> {
            public AnonymousClass1() {
                super();
            }

            @Override // java.util.Iterator
            public K next() {
                return a().x;
            }
        }

        public KeySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            com.airbnb.lottie.parser.moshi.LinkedHashTreeMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(java.lang.Object obj) {
            return com.airbnb.lottie.parser.moshi.LinkedHashTreeMap.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public java.util.Iterator<K> iterator() {
            return new com.airbnb.lottie.parser.moshi.LinkedHashTreeMap.KeySet.AnonymousClass1();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(java.lang.Object obj) {
            return com.airbnb.lottie.parser.moshi.LinkedHashTreeMap.this.removeInternalByKey(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return com.airbnb.lottie.parser.moshi.LinkedHashTreeMap.this.size;
        }
    }

    public abstract class LinkedTreeMapIterator<T> implements java.util.Iterator<T> {
        public com.airbnb.lottie.parser.moshi.LinkedHashTreeMap.Node<K, V> n;
        public com.airbnb.lottie.parser.moshi.LinkedHashTreeMap.Node<K, V> t = null;
        public int u;

        public LinkedTreeMapIterator() {
            this.n = com.airbnb.lottie.parser.moshi.LinkedHashTreeMap.this.header.v;
            this.u = com.airbnb.lottie.parser.moshi.LinkedHashTreeMap.this.modCount;
        }

        public final com.airbnb.lottie.parser.moshi.LinkedHashTreeMap.Node<K, V> a() {
            com.airbnb.lottie.parser.moshi.LinkedHashTreeMap.Node<K, V> node = this.n;
            com.airbnb.lottie.parser.moshi.LinkedHashTreeMap linkedHashTreeMap = com.airbnb.lottie.parser.moshi.LinkedHashTreeMap.this;
            if (node == linkedHashTreeMap.header) {
                throw new java.util.NoSuchElementException();
            }
            if (linkedHashTreeMap.modCount != this.u) {
                throw new java.util.ConcurrentModificationException();
            }
            this.n = node.v;
            this.t = node;
            return node;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.n != com.airbnb.lottie.parser.moshi.LinkedHashTreeMap.this.header;
        }

        @Override // java.util.Iterator
        public final void remove() {
            com.airbnb.lottie.parser.moshi.LinkedHashTreeMap.Node<K, V> node = this.t;
            if (node == null) {
                throw new java.lang.IllegalStateException();
            }
            com.airbnb.lottie.parser.moshi.LinkedHashTreeMap.this.removeInternal(node, true);
            this.t = null;
            this.u = com.airbnb.lottie.parser.moshi.LinkedHashTreeMap.this.modCount;
        }
    }

    public static final class Node<K, V> implements java.util.Map.Entry<K, V> {
        public int A;
        public com.airbnb.lottie.parser.moshi.LinkedHashTreeMap.Node<K, V> n;
        public com.airbnb.lottie.parser.moshi.LinkedHashTreeMap.Node<K, V> t;
        public com.airbnb.lottie.parser.moshi.LinkedHashTreeMap.Node<K, V> u;
        public com.airbnb.lottie.parser.moshi.LinkedHashTreeMap.Node<K, V> v;
        public com.airbnb.lottie.parser.moshi.LinkedHashTreeMap.Node<K, V> w;
        public final K x;
        public final int y;
        public V z;

        public Node() {
            this.x = null;
            this.y = -1;
            this.w = this;
            this.v = this;
        }

        public Node(com.airbnb.lottie.parser.moshi.LinkedHashTreeMap.Node<K, V> node, K k, int i, com.airbnb.lottie.parser.moshi.LinkedHashTreeMap.Node<K, V> node2, com.airbnb.lottie.parser.moshi.LinkedHashTreeMap.Node<K, V> node3) {
            this.n = node;
            this.x = k;
            this.y = i;
            this.A = 1;
            this.v = node2;
            this.w = node3;
            node3.v = this;
            node2.w = this;
        }

        public com.airbnb.lottie.parser.moshi.LinkedHashTreeMap.Node<K, V> a() {
            com.airbnb.lottie.parser.moshi.LinkedHashTreeMap.Node<K, V> node = this;
            for (com.airbnb.lottie.parser.moshi.LinkedHashTreeMap.Node<K, V> node2 = this.t; node2 != null; node2 = node2.t) {
                node = node2;
            }
            return node;
        }

        public com.airbnb.lottie.parser.moshi.LinkedHashTreeMap.Node<K, V> b() {
            com.airbnb.lottie.parser.moshi.LinkedHashTreeMap.Node<K, V> node = this;
            for (com.airbnb.lottie.parser.moshi.LinkedHashTreeMap.Node<K, V> node2 = this.u; node2 != null; node2 = node2.u) {
                node = node2;
            }
            return node;
        }

        @Override // java.util.Map.Entry
        public boolean equals(java.lang.Object obj) {
            if (!(obj instanceof java.util.Map.Entry)) {
                return false;
            }
            java.util.Map.Entry entry = (java.util.Map.Entry) obj;
            K k = this.x;
            if (k == null) {
                if (entry.getKey() != null) {
                    return false;
                }
            } else if (!k.equals(entry.getKey())) {
                return false;
            }
            V v = this.z;
            if (v == null) {
                if (entry.getValue() != null) {
                    return false;
                }
            } else if (!v.equals(entry.getValue())) {
                return false;
            }
            return true;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.x;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.z;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            K k = this.x;
            int hashCode = k == null ? 0 : k.hashCode();
            V v = this.z;
            return hashCode ^ (v != null ? v.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            V v2 = this.z;
            this.z = v;
            return v2;
        }

        public java.lang.String toString() {
            return this.x + com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER + this.z;
        }
    }

    public LinkedHashTreeMap() {
        this(null);
    }

    public LinkedHashTreeMap(java.util.Comparator<? super K> comparator) {
        this.size = 0;
        this.modCount = 0;
        this.comparator = comparator == null ? NATURAL_ORDER : comparator;
        this.header = new com.airbnb.lottie.parser.moshi.LinkedHashTreeMap.Node<>();
        com.airbnb.lottie.parser.moshi.LinkedHashTreeMap.Node<K, V>[] nodeArr = new com.airbnb.lottie.parser.moshi.LinkedHashTreeMap.Node[16];
        this.table = nodeArr;
        this.threshold = (nodeArr.length / 2) + (nodeArr.length / 4);
    }

    private void doubleCapacity() {
        com.airbnb.lottie.parser.moshi.LinkedHashTreeMap.Node<K, V>[] doubleCapacity = doubleCapacity(this.table);
        this.table = doubleCapacity;
        this.threshold = (doubleCapacity.length / 2) + (doubleCapacity.length / 4);
    }

    public static <K, V> com.airbnb.lottie.parser.moshi.LinkedHashTreeMap.Node<K, V>[] doubleCapacity(com.airbnb.lottie.parser.moshi.LinkedHashTreeMap.Node<K, V>[] nodeArr) {
        int length = nodeArr.length;
        com.airbnb.lottie.parser.moshi.LinkedHashTreeMap.Node<K, V>[] nodeArr2 = new com.airbnb.lottie.parser.moshi.LinkedHashTreeMap.Node[length * 2];
        com.airbnb.lottie.parser.moshi.LinkedHashTreeMap.AvlIterator avlIterator = new com.airbnb.lottie.parser.moshi.LinkedHashTreeMap.AvlIterator();
        com.airbnb.lottie.parser.moshi.LinkedHashTreeMap.AvlBuilder avlBuilder = new com.airbnb.lottie.parser.moshi.LinkedHashTreeMap.AvlBuilder();
        com.airbnb.lottie.parser.moshi.LinkedHashTreeMap.AvlBuilder avlBuilder2 = new com.airbnb.lottie.parser.moshi.LinkedHashTreeMap.AvlBuilder();
        for (int i = 0; i < length; i++) {
            com.airbnb.lottie.parser.moshi.LinkedHashTreeMap.Node<K, V> node = nodeArr[i];
            if (node != null) {
                avlIterator.b(node);
                int i2 = 0;
                int i3 = 0;
                while (true) {
                    com.airbnb.lottie.parser.moshi.LinkedHashTreeMap.Node<K, V> a = avlIterator.a();
                    if (a == null) {
                        break;
                    }
                    if ((a.y & length) == 0) {
                        i2++;
                    } else {
                        i3++;
                    }
                }
                avlBuilder.b(i2);
                avlBuilder2.b(i3);
                avlIterator.b(node);
                while (true) {
                    com.airbnb.lottie.parser.moshi.LinkedHashTreeMap.Node<K, V> a2 = avlIterator.a();
                    if (a2 == null) {
                        break;
                    }
                    if ((a2.y & length) == 0) {
                        avlBuilder.a(a2);
                    } else {
                        avlBuilder2.a(a2);
                    }
                }
                nodeArr2[i] = i2 > 0 ? avlBuilder.c() : null;
                nodeArr2[i + length] = i3 > 0 ? avlBuilder2.c() : null;
            }
        }
        return nodeArr2;
    }

    private boolean equal(java.lang.Object obj, java.lang.Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    private void rebalance(com.airbnb.lottie.parser.moshi.LinkedHashTreeMap.Node<K, V> node, boolean z) {
        while (node != null) {
            com.airbnb.lottie.parser.moshi.LinkedHashTreeMap.Node<K, V> node2 = node.t;
            com.airbnb.lottie.parser.moshi.LinkedHashTreeMap.Node<K, V> node3 = node.u;
            int i = node2 != null ? node2.A : 0;
            int i2 = node3 != null ? node3.A : 0;
            int i3 = i - i2;
            if (i3 == -2) {
                com.airbnb.lottie.parser.moshi.LinkedHashTreeMap.Node<K, V> node4 = node3.t;
                com.airbnb.lottie.parser.moshi.LinkedHashTreeMap.Node<K, V> node5 = node3.u;
                int i4 = (node4 != null ? node4.A : 0) - (node5 != null ? node5.A : 0);
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
                com.airbnb.lottie.parser.moshi.LinkedHashTreeMap.Node<K, V> node6 = node2.t;
                com.airbnb.lottie.parser.moshi.LinkedHashTreeMap.Node<K, V> node7 = node2.u;
                int i5 = (node6 != null ? node6.A : 0) - (node7 != null ? node7.A : 0);
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
                node.A = i + 1;
                if (z) {
                    return;
                }
            } else {
                node.A = java.lang.Math.max(i, i2) + 1;
                if (!z) {
                    return;
                }
            }
            node = node.n;
        }
    }

    private void replaceInParent(com.airbnb.lottie.parser.moshi.LinkedHashTreeMap.Node<K, V> node, com.airbnb.lottie.parser.moshi.LinkedHashTreeMap.Node<K, V> node2) {
        com.airbnb.lottie.parser.moshi.LinkedHashTreeMap.Node<K, V> node3 = node.n;
        node.n = null;
        if (node2 != null) {
            node2.n = node3;
        }
        if (node3 == null) {
            int i = node.y;
            this.table[i & (r0.length - 1)] = node2;
        } else if (node3.t == node) {
            node3.t = node2;
        } else {
            node3.u = node2;
        }
    }

    private void rotateLeft(com.airbnb.lottie.parser.moshi.LinkedHashTreeMap.Node<K, V> node) {
        com.airbnb.lottie.parser.moshi.LinkedHashTreeMap.Node<K, V> node2 = node.t;
        com.airbnb.lottie.parser.moshi.LinkedHashTreeMap.Node<K, V> node3 = node.u;
        com.airbnb.lottie.parser.moshi.LinkedHashTreeMap.Node<K, V> node4 = node3.t;
        com.airbnb.lottie.parser.moshi.LinkedHashTreeMap.Node<K, V> node5 = node3.u;
        node.u = node4;
        if (node4 != null) {
            node4.n = node;
        }
        replaceInParent(node, node3);
        node3.t = node;
        node.n = node3;
        int max = java.lang.Math.max(node2 != null ? node2.A : 0, node4 != null ? node4.A : 0) + 1;
        node.A = max;
        node3.A = java.lang.Math.max(max, node5 != null ? node5.A : 0) + 1;
    }

    private void rotateRight(com.airbnb.lottie.parser.moshi.LinkedHashTreeMap.Node<K, V> node) {
        com.airbnb.lottie.parser.moshi.LinkedHashTreeMap.Node<K, V> node2 = node.t;
        com.airbnb.lottie.parser.moshi.LinkedHashTreeMap.Node<K, V> node3 = node.u;
        com.airbnb.lottie.parser.moshi.LinkedHashTreeMap.Node<K, V> node4 = node2.t;
        com.airbnb.lottie.parser.moshi.LinkedHashTreeMap.Node<K, V> node5 = node2.u;
        node.t = node5;
        if (node5 != null) {
            node5.n = node;
        }
        replaceInParent(node, node2);
        node2.u = node;
        node.n = node2;
        int max = java.lang.Math.max(node3 != null ? node3.A : 0, node5 != null ? node5.A : 0) + 1;
        node.A = max;
        node2.A = java.lang.Math.max(max, node4 != null ? node4.A : 0) + 1;
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
        com.airbnb.lottie.parser.moshi.LinkedHashTreeMap.Node<K, V> node = this.header;
        com.airbnb.lottie.parser.moshi.LinkedHashTreeMap.Node<K, V> node2 = node.v;
        while (node2 != node) {
            com.airbnb.lottie.parser.moshi.LinkedHashTreeMap.Node<K, V> node3 = node2.v;
            node2.w = null;
            node2.v = null;
            node2 = node3;
        }
        node.w = node;
        node.v = node;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(java.lang.Object obj) {
        return findByObject(obj) != null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public java.util.Set<java.util.Map.Entry<K, V>> entrySet() {
        com.airbnb.lottie.parser.moshi.LinkedHashTreeMap<K, V>.EntrySet entrySet = this.entrySet;
        if (entrySet != null) {
            return entrySet;
        }
        com.airbnb.lottie.parser.moshi.LinkedHashTreeMap<K, V>.EntrySet entrySet2 = new com.airbnb.lottie.parser.moshi.LinkedHashTreeMap.EntrySet();
        this.entrySet = entrySet2;
        return entrySet2;
    }

    public com.airbnb.lottie.parser.moshi.LinkedHashTreeMap.Node<K, V> find(K k, boolean z) {
        com.airbnb.lottie.parser.moshi.LinkedHashTreeMap.Node<K, V> node;
        int i;
        com.airbnb.lottie.parser.moshi.LinkedHashTreeMap.Node<K, V> node2;
        java.util.Comparator<? super K> comparator = this.comparator;
        com.airbnb.lottie.parser.moshi.LinkedHashTreeMap.Node<K, V>[] nodeArr = this.table;
        int secondaryHash = secondaryHash(k.hashCode());
        int length = (nodeArr.length - 1) & secondaryHash;
        com.airbnb.lottie.parser.moshi.LinkedHashTreeMap.Node<K, V> node3 = nodeArr[length];
        if (node3 != null) {
            java.lang.Comparable comparable = comparator == NATURAL_ORDER ? (java.lang.Comparable) k : null;
            while (true) {
                int compareTo = comparable != null ? comparable.compareTo(node3.x) : comparator.compare(k, node3.x);
                if (compareTo == 0) {
                    return node3;
                }
                com.airbnb.lottie.parser.moshi.LinkedHashTreeMap.Node<K, V> node4 = compareTo < 0 ? node3.t : node3.u;
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
        com.airbnb.lottie.parser.moshi.LinkedHashTreeMap.Node<K, V> node5 = this.header;
        if (node != null) {
            node2 = new com.airbnb.lottie.parser.moshi.LinkedHashTreeMap.Node<>(node, k, secondaryHash, node5, node5.w);
            if (i < 0) {
                node.t = node2;
            } else {
                node.u = node2;
            }
            rebalance(node, true);
        } else {
            if (comparator == NATURAL_ORDER && !(k instanceof java.lang.Comparable)) {
                throw new java.lang.ClassCastException(k.getClass().getName() + " is not Comparable");
            }
            node2 = new com.airbnb.lottie.parser.moshi.LinkedHashTreeMap.Node<>(node, k, secondaryHash, node5, node5.w);
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

    public com.airbnb.lottie.parser.moshi.LinkedHashTreeMap.Node<K, V> findByEntry(java.util.Map.Entry<?, ?> entry) {
        com.airbnb.lottie.parser.moshi.LinkedHashTreeMap.Node<K, V> findByObject = findByObject(entry.getKey());
        if (findByObject != null && equal(findByObject.z, entry.getValue())) {
            return findByObject;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public com.airbnb.lottie.parser.moshi.LinkedHashTreeMap.Node<K, V> findByObject(java.lang.Object obj) {
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
        com.airbnb.lottie.parser.moshi.LinkedHashTreeMap.Node<K, V> findByObject = findByObject(obj);
        if (findByObject != null) {
            return findByObject.z;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public java.util.Set<K> keySet() {
        com.airbnb.lottie.parser.moshi.LinkedHashTreeMap<K, V>.KeySet keySet = this.keySet;
        if (keySet != null) {
            return keySet;
        }
        com.airbnb.lottie.parser.moshi.LinkedHashTreeMap<K, V>.KeySet keySet2 = new com.airbnb.lottie.parser.moshi.LinkedHashTreeMap.KeySet();
        this.keySet = keySet2;
        return keySet2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k, V v) {
        if (k == null) {
            throw new java.lang.NullPointerException("key == null");
        }
        com.airbnb.lottie.parser.moshi.LinkedHashTreeMap.Node<K, V> find = find(k, true);
        V v2 = find.z;
        find.z = v;
        return v2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(java.lang.Object obj) {
        com.airbnb.lottie.parser.moshi.LinkedHashTreeMap.Node<K, V> removeInternalByKey = removeInternalByKey(obj);
        if (removeInternalByKey != null) {
            return removeInternalByKey.z;
        }
        return null;
    }

    public void removeInternal(com.airbnb.lottie.parser.moshi.LinkedHashTreeMap.Node<K, V> node, boolean z) {
        int i;
        if (z) {
            com.airbnb.lottie.parser.moshi.LinkedHashTreeMap.Node<K, V> node2 = node.w;
            node2.v = node.v;
            node.v.w = node2;
            node.w = null;
            node.v = null;
        }
        com.airbnb.lottie.parser.moshi.LinkedHashTreeMap.Node<K, V> node3 = node.t;
        com.airbnb.lottie.parser.moshi.LinkedHashTreeMap.Node<K, V> node4 = node.u;
        com.airbnb.lottie.parser.moshi.LinkedHashTreeMap.Node<K, V> node5 = node.n;
        int i2 = 0;
        if (node3 == null || node4 == null) {
            if (node3 != null) {
                replaceInParent(node, node3);
                node.t = null;
            } else if (node4 != null) {
                replaceInParent(node, node4);
                node.u = null;
            } else {
                replaceInParent(node, null);
            }
            rebalance(node5, false);
            this.size--;
            this.modCount++;
            return;
        }
        com.airbnb.lottie.parser.moshi.LinkedHashTreeMap.Node<K, V> b = node3.A > node4.A ? node3.b() : node4.a();
        removeInternal(b, false);
        com.airbnb.lottie.parser.moshi.LinkedHashTreeMap.Node<K, V> node6 = node.t;
        if (node6 != null) {
            i = node6.A;
            b.t = node6;
            node6.n = b;
            node.t = null;
        } else {
            i = 0;
        }
        com.airbnb.lottie.parser.moshi.LinkedHashTreeMap.Node<K, V> node7 = node.u;
        if (node7 != null) {
            i2 = node7.A;
            b.u = node7;
            node7.n = b;
            node.u = null;
        }
        b.A = java.lang.Math.max(i, i2) + 1;
        replaceInParent(node, b);
    }

    public com.airbnb.lottie.parser.moshi.LinkedHashTreeMap.Node<K, V> removeInternalByKey(java.lang.Object obj) {
        com.airbnb.lottie.parser.moshi.LinkedHashTreeMap.Node<K, V> findByObject = findByObject(obj);
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
