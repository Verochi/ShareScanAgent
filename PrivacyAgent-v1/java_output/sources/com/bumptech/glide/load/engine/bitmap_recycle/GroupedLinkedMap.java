package com.bumptech.glide.load.engine.bitmap_recycle;

/* loaded from: classes.dex */
class GroupedLinkedMap<K extends com.bumptech.glide.load.engine.bitmap_recycle.Poolable, V> {
    private final com.bumptech.glide.load.engine.bitmap_recycle.GroupedLinkedMap.LinkedEntry<K, V> head = new com.bumptech.glide.load.engine.bitmap_recycle.GroupedLinkedMap.LinkedEntry<>();
    private final java.util.Map<K, com.bumptech.glide.load.engine.bitmap_recycle.GroupedLinkedMap.LinkedEntry<K, V>> keyToEntry = new java.util.HashMap();

    public static class LinkedEntry<K, V> {
        final K key;
        com.bumptech.glide.load.engine.bitmap_recycle.GroupedLinkedMap.LinkedEntry<K, V> next;
        com.bumptech.glide.load.engine.bitmap_recycle.GroupedLinkedMap.LinkedEntry<K, V> prev;
        private java.util.List<V> values;

        public LinkedEntry() {
            this(null);
        }

        public LinkedEntry(K k) {
            this.prev = this;
            this.next = this;
            this.key = k;
        }

        public void add(V v) {
            if (this.values == null) {
                this.values = new java.util.ArrayList();
            }
            this.values.add(v);
        }

        @androidx.annotation.Nullable
        public V removeLast() {
            int size = size();
            if (size > 0) {
                return this.values.remove(size - 1);
            }
            return null;
        }

        public int size() {
            java.util.List<V> list = this.values;
            if (list != null) {
                return list.size();
            }
            return 0;
        }
    }

    private void makeHead(com.bumptech.glide.load.engine.bitmap_recycle.GroupedLinkedMap.LinkedEntry<K, V> linkedEntry) {
        removeEntry(linkedEntry);
        com.bumptech.glide.load.engine.bitmap_recycle.GroupedLinkedMap.LinkedEntry<K, V> linkedEntry2 = this.head;
        linkedEntry.prev = linkedEntry2;
        linkedEntry.next = linkedEntry2.next;
        updateEntry(linkedEntry);
    }

    private void makeTail(com.bumptech.glide.load.engine.bitmap_recycle.GroupedLinkedMap.LinkedEntry<K, V> linkedEntry) {
        removeEntry(linkedEntry);
        com.bumptech.glide.load.engine.bitmap_recycle.GroupedLinkedMap.LinkedEntry<K, V> linkedEntry2 = this.head;
        linkedEntry.prev = linkedEntry2.prev;
        linkedEntry.next = linkedEntry2;
        updateEntry(linkedEntry);
    }

    private static <K, V> void removeEntry(com.bumptech.glide.load.engine.bitmap_recycle.GroupedLinkedMap.LinkedEntry<K, V> linkedEntry) {
        com.bumptech.glide.load.engine.bitmap_recycle.GroupedLinkedMap.LinkedEntry<K, V> linkedEntry2 = linkedEntry.prev;
        linkedEntry2.next = linkedEntry.next;
        linkedEntry.next.prev = linkedEntry2;
    }

    private static <K, V> void updateEntry(com.bumptech.glide.load.engine.bitmap_recycle.GroupedLinkedMap.LinkedEntry<K, V> linkedEntry) {
        linkedEntry.next.prev = linkedEntry;
        linkedEntry.prev.next = linkedEntry;
    }

    @androidx.annotation.Nullable
    public V get(K k) {
        com.bumptech.glide.load.engine.bitmap_recycle.GroupedLinkedMap.LinkedEntry<K, V> linkedEntry = this.keyToEntry.get(k);
        if (linkedEntry == null) {
            linkedEntry = new com.bumptech.glide.load.engine.bitmap_recycle.GroupedLinkedMap.LinkedEntry<>(k);
            this.keyToEntry.put(k, linkedEntry);
        } else {
            k.offer();
        }
        makeHead(linkedEntry);
        return linkedEntry.removeLast();
    }

    public void put(K k, V v) {
        com.bumptech.glide.load.engine.bitmap_recycle.GroupedLinkedMap.LinkedEntry<K, V> linkedEntry = this.keyToEntry.get(k);
        if (linkedEntry == null) {
            linkedEntry = new com.bumptech.glide.load.engine.bitmap_recycle.GroupedLinkedMap.LinkedEntry<>(k);
            makeTail(linkedEntry);
            this.keyToEntry.put(k, linkedEntry);
        } else {
            k.offer();
        }
        linkedEntry.add(v);
    }

    @androidx.annotation.Nullable
    public V removeLast() {
        for (com.bumptech.glide.load.engine.bitmap_recycle.GroupedLinkedMap.LinkedEntry linkedEntry = this.head.prev; !linkedEntry.equals(this.head); linkedEntry = linkedEntry.prev) {
            V v = (V) linkedEntry.removeLast();
            if (v != null) {
                return v;
            }
            removeEntry(linkedEntry);
            this.keyToEntry.remove(linkedEntry.key);
            ((com.bumptech.glide.load.engine.bitmap_recycle.Poolable) linkedEntry.key).offer();
        }
        return null;
    }

    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("GroupedLinkedMap( ");
        com.bumptech.glide.load.engine.bitmap_recycle.GroupedLinkedMap.LinkedEntry linkedEntry = this.head.next;
        boolean z = false;
        while (!linkedEntry.equals(this.head)) {
            sb.append('{');
            sb.append(linkedEntry.key);
            sb.append(':');
            sb.append(linkedEntry.size());
            sb.append("}, ");
            linkedEntry = linkedEntry.next;
            z = true;
        }
        if (z) {
            sb.delete(sb.length() - 2, sb.length());
        }
        sb.append(" )");
        return sb.toString();
    }
}
