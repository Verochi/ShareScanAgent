package androidx.lifecycle;

/* loaded from: classes.dex */
public abstract class AbstractSavedStateViewModelFactory extends androidx.lifecycle.ViewModelProvider.KeyedFactory {
    static final java.lang.String TAG_SAVED_STATE_HANDLE_CONTROLLER = "androidx.lifecycle.savedstate.vm.tag";
    private final android.os.Bundle mDefaultArgs;
    private final androidx.lifecycle.Lifecycle mLifecycle;
    private final androidx.savedstate.SavedStateRegistry mSavedStateRegistry;

    public AbstractSavedStateViewModelFactory(@androidx.annotation.NonNull androidx.savedstate.SavedStateRegistryOwner savedStateRegistryOwner, @androidx.annotation.Nullable android.os.Bundle bundle) {
        this.mSavedStateRegistry = savedStateRegistryOwner.getSavedStateRegistry();
        this.mLifecycle = savedStateRegistryOwner.getLifecycle();
        this.mDefaultArgs = bundle;
    }

    @Override // androidx.lifecycle.ViewModelProvider.KeyedFactory, androidx.lifecycle.ViewModelProvider.Factory
    @androidx.annotation.NonNull
    public final <T extends androidx.lifecycle.ViewModel> T create(@androidx.annotation.NonNull java.lang.Class<T> cls) {
        java.lang.String canonicalName = cls.getCanonicalName();
        if (canonicalName != null) {
            return (T) create(canonicalName, cls);
        }
        throw new java.lang.IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    @Override // androidx.lifecycle.ViewModelProvider.KeyedFactory
    @androidx.annotation.NonNull
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public final <T extends androidx.lifecycle.ViewModel> T create(@androidx.annotation.NonNull java.lang.String str, @androidx.annotation.NonNull java.lang.Class<T> cls) {
        androidx.lifecycle.SavedStateHandleController create = androidx.lifecycle.SavedStateHandleController.create(this.mSavedStateRegistry, this.mLifecycle, str, this.mDefaultArgs);
        T t = (T) create(str, cls, create.getHandle());
        t.setTagIfAbsent(TAG_SAVED_STATE_HANDLE_CONTROLLER, create);
        return t;
    }

    @androidx.annotation.NonNull
    public abstract <T extends androidx.lifecycle.ViewModel> T create(@androidx.annotation.NonNull java.lang.String str, @androidx.annotation.NonNull java.lang.Class<T> cls, @androidx.annotation.NonNull androidx.lifecycle.SavedStateHandle savedStateHandle);

    @Override // androidx.lifecycle.ViewModelProvider.OnRequeryFactory
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public void onRequery(@androidx.annotation.NonNull androidx.lifecycle.ViewModel viewModel) {
        androidx.lifecycle.SavedStateHandleController.attachHandleIfNeeded(viewModel, this.mSavedStateRegistry, this.mLifecycle);
    }
}
