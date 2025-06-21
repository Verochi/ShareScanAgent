package androidx.lifecycle;

/* loaded from: classes.dex */
public interface DefaultLifecycleObserver extends androidx.lifecycle.FullLifecycleObserver {
    @Override // androidx.lifecycle.FullLifecycleObserver
    void onCreate(@androidx.annotation.NonNull androidx.lifecycle.LifecycleOwner lifecycleOwner);

    @Override // androidx.lifecycle.FullLifecycleObserver
    void onDestroy(@androidx.annotation.NonNull androidx.lifecycle.LifecycleOwner lifecycleOwner);

    @Override // androidx.lifecycle.FullLifecycleObserver
    void onPause(@androidx.annotation.NonNull androidx.lifecycle.LifecycleOwner lifecycleOwner);

    @Override // androidx.lifecycle.FullLifecycleObserver
    void onResume(@androidx.annotation.NonNull androidx.lifecycle.LifecycleOwner lifecycleOwner);

    @Override // androidx.lifecycle.FullLifecycleObserver
    void onStart(@androidx.annotation.NonNull androidx.lifecycle.LifecycleOwner lifecycleOwner);

    @Override // androidx.lifecycle.FullLifecycleObserver
    void onStop(@androidx.annotation.NonNull androidx.lifecycle.LifecycleOwner lifecycleOwner);
}
