package androidx.lifecycle;

/* loaded from: classes.dex */
interface FullLifecycleObserver extends androidx.lifecycle.LifecycleObserver {
    void onCreate(androidx.lifecycle.LifecycleOwner lifecycleOwner);

    void onDestroy(androidx.lifecycle.LifecycleOwner lifecycleOwner);

    void onPause(androidx.lifecycle.LifecycleOwner lifecycleOwner);

    void onResume(androidx.lifecycle.LifecycleOwner lifecycleOwner);

    void onStart(androidx.lifecycle.LifecycleOwner lifecycleOwner);

    void onStop(androidx.lifecycle.LifecycleOwner lifecycleOwner);
}
