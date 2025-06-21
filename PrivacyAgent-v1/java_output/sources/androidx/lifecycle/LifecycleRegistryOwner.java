package androidx.lifecycle;

@java.lang.Deprecated
/* loaded from: classes.dex */
public interface LifecycleRegistryOwner extends androidx.lifecycle.LifecycleOwner {
    @Override // androidx.lifecycle.LifecycleOwner
    @androidx.annotation.NonNull
    /* bridge */ /* synthetic */ androidx.lifecycle.Lifecycle getLifecycle();

    @Override // androidx.lifecycle.LifecycleOwner
    @androidx.annotation.NonNull
    androidx.lifecycle.LifecycleRegistry getLifecycle();
}
