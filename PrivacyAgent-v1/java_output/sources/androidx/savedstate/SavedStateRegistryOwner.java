package androidx.savedstate;

/* loaded from: classes.dex */
public interface SavedStateRegistryOwner extends androidx.lifecycle.LifecycleOwner {
    @androidx.annotation.NonNull
    androidx.savedstate.SavedStateRegistry getSavedStateRegistry();
}
