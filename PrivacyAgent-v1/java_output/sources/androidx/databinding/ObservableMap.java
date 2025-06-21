package androidx.databinding;

/* loaded from: classes.dex */
public interface ObservableMap<K, V> extends java.util.Map<K, V> {

    public static abstract class OnMapChangedCallback<T extends androidx.databinding.ObservableMap<K, V>, K, V> {
        public abstract void onMapChanged(T t, K k);
    }

    void addOnMapChangedCallback(androidx.databinding.ObservableMap.OnMapChangedCallback<? extends androidx.databinding.ObservableMap<K, V>, K, V> onMapChangedCallback);

    void removeOnMapChangedCallback(androidx.databinding.ObservableMap.OnMapChangedCallback<? extends androidx.databinding.ObservableMap<K, V>, K, V> onMapChangedCallback);
}
