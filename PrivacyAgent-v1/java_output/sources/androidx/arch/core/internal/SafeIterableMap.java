package androidx.arch.core.internal;

@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class SafeIterableMap<K, V> implements java.lang.Iterable<java.util.Map.Entry<K, V>> {
    private androidx.arch.core.internal.SafeIterableMap.Entry<K, V> mEnd;
    private java.util.WeakHashMap<androidx.arch.core.internal.SafeIterableMap.SupportRemove<K, V>, java.lang.Boolean> mIterators = new java.util.WeakHashMap<>();
    private int mSize = 0;
    androidx.arch.core.internal.SafeIterableMap.Entry<K, V> mStart;

    public static class AscendingIterator<K, V> extends androidx.arch.core.internal.SafeIterableMap.ListIterator<K, V> {
        public AscendingIterator(androidx.arch.core.internal.SafeIterableMap.Entry<K, V> entry, androidx.arch.core.internal.SafeIterableMap.Entry<K, V> entry2) {
            super(entry, entry2);
        }

        @Override // androidx.arch.core.internal.SafeIterableMap.ListIterator
        public androidx.arch.core.internal.SafeIterableMap.Entry<K, V> backward(androidx.arch.core.internal.SafeIterableMap.Entry<K, V> entry) {
            return entry.mPrevious;
        }

        @Override // androidx.arch.core.internal.SafeIterableMap.ListIterator
        public androidx.arch.core.internal.SafeIterableMap.Entry<K, V> forward(androidx.arch.core.internal.SafeIterableMap.Entry<K, V> entry) {
            return entry.mNext;
        }
    }

    public static class DescendingIterator<K, V> extends androidx.arch.core.internal.SafeIterableMap.ListIterator<K, V> {
        public DescendingIterator(androidx.arch.core.internal.SafeIterableMap.Entry<K, V> entry, androidx.arch.core.internal.SafeIterableMap.Entry<K, V> entry2) {
            super(entry, entry2);
        }

        @Override // androidx.arch.core.internal.SafeIterableMap.ListIterator
        public androidx.arch.core.internal.SafeIterableMap.Entry<K, V> backward(androidx.arch.core.internal.SafeIterableMap.Entry<K, V> entry) {
            return entry.mNext;
        }

        @Override // androidx.arch.core.internal.SafeIterableMap.ListIterator
        public androidx.arch.core.internal.SafeIterableMap.Entry<K, V> forward(androidx.arch.core.internal.SafeIterableMap.Entry<K, V> entry) {
            return entry.mPrevious;
        }
    }

    public static class Entry<K, V> implements java.util.Map.Entry<K, V> {

        @androidx.annotation.NonNull
        final K mKey;
        androidx.arch.core.internal.SafeIterableMap.Entry<K, V> mNext;
        androidx.arch.core.internal.SafeIterableMap.Entry<K, V> mPrevious;

        @androidx.annotation.NonNull
        final V mValue;

        public Entry(@androidx.annotation.NonNull K k, @androidx.annotation.NonNull V v) {
            this.mKey = k;
            this.mValue = v;
        }

        @Override // java.util.Map.Entry
        public boolean equals(java.lang.Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof androidx.arch.core.internal.SafeIterableMap.Entry)) {
                return false;
            }
            androidx.arch.core.internal.SafeIterableMap.Entry entry = (androidx.arch.core.internal.SafeIterableMap.Entry) obj;
            return this.mKey.equals(entry.mKey) && this.mValue.equals(entry.mValue);
        }

        @Override // java.util.Map.Entry
        @androidx.annotation.NonNull
        public K getKey() {
            return this.mKey;
        }

        @Override // java.util.Map.Entry
        @androidx.annotation.NonNull
        public V getValue() {
            return this.mValue;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            return this.mKey.hashCode() ^ this.mValue.hashCode();
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            throw new java.lang.UnsupportedOperationException("An entry modification is not supported");
        }

        public java.lang.String toString() {
            return this.mKey + com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER + this.mValue;
        }
    }

    public class IteratorWithAdditions implements java.util.Iterator<java.util.Map.Entry<K, V>>, androidx.arch.core.internal.SafeIterableMap.SupportRemove<K, V> {
        private boolean mBeforeStart = true;
        private androidx.arch.core.internal.SafeIterableMap.Entry<K, V> mCurrent;

        public IteratorWithAdditions() {
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.mBeforeStart) {
                return androidx.arch.core.internal.SafeIterableMap.this.mStart != null;
            }
            androidx.arch.core.internal.SafeIterableMap.Entry<K, V> entry = this.mCurrent;
            return (entry == null || entry.mNext == null) ? false : true;
        }

        @Override // java.util.Iterator
        public java.util.Map.Entry<K, V> next() {
            if (this.mBeforeStart) {
                this.mBeforeStart = false;
                this.mCurrent = androidx.arch.core.internal.SafeIterableMap.this.mStart;
            } else {
                androidx.arch.core.internal.SafeIterableMap.Entry<K, V> entry = this.mCurrent;
                this.mCurrent = entry != null ? entry.mNext : null;
            }
            return this.mCurrent;
        }

        @Override // androidx.arch.core.internal.SafeIterableMap.SupportRemove
        public void supportRemove(@androidx.annotation.NonNull androidx.arch.core.internal.SafeIterableMap.Entry<K, V> entry) {
            androidx.arch.core.internal.SafeIterableMap.Entry<K, V> entry2 = this.mCurrent;
            if (entry == entry2) {
                androidx.arch.core.internal.SafeIterableMap.Entry<K, V> entry3 = entry2.mPrevious;
                this.mCurrent = entry3;
                this.mBeforeStart = entry3 == null;
            }
        }
    }

    public static abstract class ListIterator<K, V> implements java.util.Iterator<java.util.Map.Entry<K, V>>, androidx.arch.core.internal.SafeIterableMap.SupportRemove<K, V> {
        androidx.arch.core.internal.SafeIterableMap.Entry<K, V> mExpectedEnd;
        androidx.arch.core.internal.SafeIterableMap.Entry<K, V> mNext;

        public ListIterator(androidx.arch.core.internal.SafeIterableMap.Entry<K, V> entry, androidx.arch.core.internal.SafeIterableMap.Entry<K, V> entry2) {
            this.mExpectedEnd = entry2;
            this.mNext = entry;
        }

        private androidx.arch.core.internal.SafeIterableMap.Entry<K, V> nextNode() {
            androidx.arch.core.internal.SafeIterableMap.Entry<K, V> entry = this.mNext;
            androidx.arch.core.internal.SafeIterableMap.Entry<K, V> entry2 = this.mExpectedEnd;
            if (entry == entry2 || entry2 == null) {
                return null;
            }
            return forward(entry);
        }

        public abstract androidx.arch.core.internal.SafeIterableMap.Entry<K, V> backward(androidx.arch.core.internal.SafeIterableMap.Entry<K, V> entry);

        public abstract androidx.arch.core.internal.SafeIterableMap.Entry<K, V> forward(androidx.arch.core.internal.SafeIterableMap.Entry<K, V> entry);

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.mNext != null;
        }

        @Override // java.util.Iterator
        public java.util.Map.Entry<K, V> next() {
            androidx.arch.core.internal.SafeIterableMap.Entry<K, V> entry = this.mNext;
            this.mNext = nextNode();
            return entry;
        }

        @Override // androidx.arch.core.internal.SafeIterableMap.SupportRemove
        public void supportRemove(@androidx.annotation.NonNull androidx.arch.core.internal.SafeIterableMap.Entry<K, V> entry) {
            if (this.mExpectedEnd == entry && entry == this.mNext) {
                this.mNext = null;
                this.mExpectedEnd = null;
            }
            androidx.arch.core.internal.SafeIterableMap.Entry<K, V> entry2 = this.mExpectedEnd;
            if (entry2 == entry) {
                this.mExpectedEnd = backward(entry2);
            }
            if (this.mNext == entry) {
                this.mNext = nextNode();
            }
        }
    }

    public interface SupportRemove<K, V> {
        void supportRemove(@androidx.annotation.NonNull androidx.arch.core.internal.SafeIterableMap.Entry<K, V> entry);
    }

    public java.util.Iterator<java.util.Map.Entry<K, V>> descendingIterator() {
        androidx.arch.core.internal.SafeIterableMap.DescendingIterator descendingIterator = new androidx.arch.core.internal.SafeIterableMap.DescendingIterator(this.mEnd, this.mStart);
        this.mIterators.put(descendingIterator, java.lang.Boolean.FALSE);
        return descendingIterator;
    }

    public java.util.Map.Entry<K, V> eldest() {
        return this.mStart;
    }

    public boolean equals(java.lang.Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof androidx.arch.core.internal.SafeIterableMap)) {
            return false;
        }
        androidx.arch.core.internal.SafeIterableMap safeIterableMap = (androidx.arch.core.internal.SafeIterableMap) obj;
        if (size() != safeIterableMap.size()) {
            return false;
        }
        java.util.Iterator<java.util.Map.Entry<K, V>> it = iterator();
        java.util.Iterator<java.util.Map.Entry<K, V>> it2 = safeIterableMap.iterator();
        while (it.hasNext() && it2.hasNext()) {
            java.util.Map.Entry<K, V> next = it.next();
            java.util.Map.Entry<K, V> next2 = it2.next();
            if ((next == null && next2 != null) || (next != null && !next.equals(next2))) {
                return false;
            }
        }
        return (it.hasNext() || it2.hasNext()) ? false : true;
    }

    public androidx.arch.core.internal.SafeIterableMap.Entry<K, V> get(K k) {
        androidx.arch.core.internal.SafeIterableMap.Entry<K, V> entry = this.mStart;
        while (entry != null && !entry.mKey.equals(k)) {
            entry = entry.mNext;
        }
        return entry;
    }

    public int hashCode() {
        java.util.Iterator<java.util.Map.Entry<K, V>> it = iterator();
        int i = 0;
        while (it.hasNext()) {
            i += it.next().hashCode();
        }
        return i;
    }

    @Override // java.lang.Iterable
    @androidx.annotation.NonNull
    public java.util.Iterator<java.util.Map.Entry<K, V>> iterator() {
        androidx.arch.core.internal.SafeIterableMap.AscendingIterator ascendingIterator = new androidx.arch.core.internal.SafeIterableMap.AscendingIterator(this.mStart, this.mEnd);
        this.mIterators.put(ascendingIterator, java.lang.Boolean.FALSE);
        return ascendingIterator;
    }

    public androidx.arch.core.internal.SafeIterableMap<K, V>.IteratorWithAdditions iteratorWithAdditions() {
        androidx.arch.core.internal.SafeIterableMap<K, V>.IteratorWithAdditions iteratorWithAdditions = new androidx.arch.core.internal.SafeIterableMap.IteratorWithAdditions();
        this.mIterators.put(iteratorWithAdditions, java.lang.Boolean.FALSE);
        return iteratorWithAdditions;
    }

    public java.util.Map.Entry<K, V> newest() {
        return this.mEnd;
    }

    public androidx.arch.core.internal.SafeIterableMap.Entry<K, V> put(@androidx.annotation.NonNull K k, @androidx.annotation.NonNull V v) {
        androidx.arch.core.internal.SafeIterableMap.Entry<K, V> entry = new androidx.arch.core.internal.SafeIterableMap.Entry<>(k, v);
        this.mSize++;
        androidx.arch.core.internal.SafeIterableMap.Entry<K, V> entry2 = this.mEnd;
        if (entry2 == null) {
            this.mStart = entry;
            this.mEnd = entry;
            return entry;
        }
        entry2.mNext = entry;
        entry.mPrevious = entry2;
        this.mEnd = entry;
        return entry;
    }

    public V putIfAbsent(@androidx.annotation.NonNull K k, @androidx.annotation.NonNull V v) {
        androidx.arch.core.internal.SafeIterableMap.Entry<K, V> entry = get(k);
        if (entry != null) {
            return entry.mValue;
        }
        put(k, v);
        return null;
    }

    public V remove(@androidx.annotation.NonNull K k) {
        androidx.arch.core.internal.SafeIterableMap.Entry<K, V> entry = get(k);
        if (entry == null) {
            return null;
        }
        this.mSize--;
        if (!this.mIterators.isEmpty()) {
            java.util.Iterator<androidx.arch.core.internal.SafeIterableMap.SupportRemove<K, V>> it = this.mIterators.keySet().iterator();
            while (it.hasNext()) {
                it.next().supportRemove(entry);
            }
        }
        androidx.arch.core.internal.SafeIterableMap.Entry<K, V> entry2 = entry.mPrevious;
        if (entry2 != null) {
            entry2.mNext = entry.mNext;
        } else {
            this.mStart = entry.mNext;
        }
        androidx.arch.core.internal.SafeIterableMap.Entry<K, V> entry3 = entry.mNext;
        if (entry3 != null) {
            entry3.mPrevious = entry2;
        } else {
            this.mEnd = entry2;
        }
        entry.mNext = null;
        entry.mPrevious = null;
        return entry.mValue;
    }

    public int size() {
        return this.mSize;
    }

    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("[");
        java.util.Iterator<java.util.Map.Entry<K, V>> it = iterator();
        while (it.hasNext()) {
            sb.append(it.next().toString());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
