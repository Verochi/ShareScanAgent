package androidx.databinding;

/* loaded from: classes.dex */
public class MapChangeRegistry extends androidx.databinding.CallbackRegistry<androidx.databinding.ObservableMap.OnMapChangedCallback, androidx.databinding.ObservableMap, java.lang.Object> {
    private static androidx.databinding.CallbackRegistry.NotifierCallback<androidx.databinding.ObservableMap.OnMapChangedCallback, androidx.databinding.ObservableMap, java.lang.Object> NOTIFIER_CALLBACK = new androidx.databinding.MapChangeRegistry.AnonymousClass1();

    /* renamed from: androidx.databinding.MapChangeRegistry$1, reason: invalid class name */
    public class AnonymousClass1 extends androidx.databinding.CallbackRegistry.NotifierCallback<androidx.databinding.ObservableMap.OnMapChangedCallback, androidx.databinding.ObservableMap, java.lang.Object> {
        @Override // androidx.databinding.CallbackRegistry.NotifierCallback
        public void onNotifyCallback(androidx.databinding.ObservableMap.OnMapChangedCallback onMapChangedCallback, androidx.databinding.ObservableMap observableMap, int i, java.lang.Object obj) {
            onMapChangedCallback.onMapChanged(observableMap, obj);
        }
    }

    public MapChangeRegistry() {
        super(NOTIFIER_CALLBACK);
    }

    public void notifyChange(@androidx.annotation.NonNull androidx.databinding.ObservableMap observableMap, @androidx.annotation.Nullable java.lang.Object obj) {
        notifyCallbacks(observableMap, 0, obj);
    }
}
