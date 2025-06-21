package androidx.lifecycle;

/* loaded from: classes.dex */
public interface LifecycleEventObserver extends androidx.lifecycle.LifecycleObserver {
    void onStateChanged(@androidx.annotation.NonNull androidx.lifecycle.LifecycleOwner lifecycleOwner, @androidx.annotation.NonNull androidx.lifecycle.Lifecycle.Event event);
}
