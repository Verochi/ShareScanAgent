package androidx.lifecycle;

/* loaded from: classes.dex */
public final class ProcessLifecycleInitializer implements androidx.startup.Initializer<androidx.lifecycle.LifecycleOwner> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.startup.Initializer
    @androidx.annotation.NonNull
    public androidx.lifecycle.LifecycleOwner create(@androidx.annotation.NonNull android.content.Context context) {
        androidx.lifecycle.LifecycleDispatcher.init(context);
        androidx.lifecycle.ProcessLifecycleOwner.init(context);
        return androidx.lifecycle.ProcessLifecycleOwner.get();
    }

    @Override // androidx.startup.Initializer
    @androidx.annotation.NonNull
    public java.util.List<java.lang.Class<? extends androidx.startup.Initializer<?>>> dependencies() {
        return java.util.Collections.emptyList();
    }
}
