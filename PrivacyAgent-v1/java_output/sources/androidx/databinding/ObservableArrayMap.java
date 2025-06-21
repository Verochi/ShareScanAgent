package androidx.databinding;

/* loaded from: classes.dex */
public class ObservableArrayMap<K, V> extends androidx.collection.ArrayMap<K, V> implements androidx.databinding.ObservableMap<K, V> {
    private transient androidx.databinding.MapChangeRegistry mListeners;

    private void notifyChange(java.lang.Object obj) {
        androidx.databinding.MapChangeRegistry mapChangeRegistry = this.mListeners;
        if (mapChangeRegistry != null) {
            mapChangeRegistry.notifyCallbacks(this, 0, obj);
        }
    }

    @Override // androidx.databinding.ObservableMap
    public void addOnMapChangedCallback(androidx.databinding.ObservableMap.OnMapChangedCallback<? extends androidx.databinding.ObservableMap<K, V>, K, V> onMapChangedCallback) {
        if (this.mListeners == null) {
            this.mListeners = new androidx.databinding.MapChangeRegistry();
        }
        this.mListeners.add(onMapChangedCallback);
    }

    @Override // androidx.collection.SimpleArrayMap, java.util.Map
    public void clear() {
        if (isEmpty()) {
            return;
        }
        super.clear();
        notifyChange(null);
    }

    @Override // androidx.collection.SimpleArrayMap, java.util.Map
    public V put(K k, V v) {
        super.put(k, v);
        notifyChange(k);
        return v;
    }

    @Override // androidx.collection.ArrayMap
    public boolean removeAll(java.util.Collection<?> collection) {
        java.util.Iterator<?> it = collection.iterator();
        boolean z = false;
        while (it.hasNext()) {
            int indexOfKey = indexOfKey(it.next());
            if (indexOfKey >= 0) {
                removeAt(indexOfKey);
                z = true;
            }
        }
        return z;
    }

    @Override // androidx.collection.SimpleArrayMap
    public V removeAt(int i) {
        K keyAt = keyAt(i);
        V v = (V) super.removeAt(i);
        if (v != null) {
            notifyChange(keyAt);
        }
        return v;
    }

    @Override // androidx.databinding.ObservableMap
    public void removeOnMapChangedCallback(androidx.databinding.ObservableMap.OnMapChangedCallback<? extends androidx.databinding.ObservableMap<K, V>, K, V> onMapChangedCallback) {
        androidx.databinding.MapChangeRegistry mapChangeRegistry = this.mListeners;
        if (mapChangeRegistry != null) {
            mapChangeRegistry.remove(onMapChangedCallback);
        }
    }

    @Override // androidx.collection.ArrayMap
    public boolean retainAll(java.util.Collection<?> collection) {
        boolean z = false;
        for (int size = size() - 1; size >= 0; size--) {
            if (!collection.contains(keyAt(size))) {
                removeAt(size);
                z = true;
            }
        }
        return z;
    }

    @Override // androidx.collection.SimpleArrayMap
    public V setValueAt(int i, V v) {
        K keyAt = keyAt(i);
        V v2 = (V) super.setValueAt(i, v);
        notifyChange(keyAt);
        return v2;
    }
}
