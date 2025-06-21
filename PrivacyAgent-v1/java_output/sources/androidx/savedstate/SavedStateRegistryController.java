package androidx.savedstate;

/* loaded from: classes.dex */
public final class SavedStateRegistryController {
    private final androidx.savedstate.SavedStateRegistryOwner mOwner;
    private final androidx.savedstate.SavedStateRegistry mRegistry = new androidx.savedstate.SavedStateRegistry();

    private SavedStateRegistryController(androidx.savedstate.SavedStateRegistryOwner savedStateRegistryOwner) {
        this.mOwner = savedStateRegistryOwner;
    }

    @androidx.annotation.NonNull
    public static androidx.savedstate.SavedStateRegistryController create(@androidx.annotation.NonNull androidx.savedstate.SavedStateRegistryOwner savedStateRegistryOwner) {
        return new androidx.savedstate.SavedStateRegistryController(savedStateRegistryOwner);
    }

    @androidx.annotation.NonNull
    public androidx.savedstate.SavedStateRegistry getSavedStateRegistry() {
        return this.mRegistry;
    }

    @androidx.annotation.MainThread
    public void performRestore(@androidx.annotation.Nullable android.os.Bundle bundle) {
        androidx.lifecycle.Lifecycle lifecycle = this.mOwner.getLifecycle();
        if (lifecycle.getCurrentState() != androidx.lifecycle.Lifecycle.State.INITIALIZED) {
            throw new java.lang.IllegalStateException("Restarter must be created only during owner's initialization stage");
        }
        lifecycle.addObserver(new androidx.savedstate.Recreator(this.mOwner));
        this.mRegistry.performRestore(lifecycle, bundle);
    }

    @androidx.annotation.MainThread
    public void performSave(@androidx.annotation.NonNull android.os.Bundle bundle) {
        this.mRegistry.performSave(bundle);
    }
}
