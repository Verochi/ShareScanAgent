package androidx.savedstate;

@android.annotation.SuppressLint({"RestrictedApi"})
/* loaded from: classes.dex */
public final class SavedStateRegistry {
    private static final java.lang.String SAVED_COMPONENTS_KEY = "androidx.lifecycle.BundlableSavedStateRegistry.key";
    private androidx.savedstate.Recreator.SavedStateProvider mRecreatorProvider;
    private boolean mRestored;

    @androidx.annotation.Nullable
    private android.os.Bundle mRestoredState;
    private androidx.arch.core.internal.SafeIterableMap<java.lang.String, androidx.savedstate.SavedStateRegistry.SavedStateProvider> mComponents = new androidx.arch.core.internal.SafeIterableMap<>();
    boolean mAllowingSavingState = true;

    /* renamed from: androidx.savedstate.SavedStateRegistry$1, reason: invalid class name */
    public class AnonymousClass1 implements androidx.lifecycle.GenericLifecycleObserver {
        public AnonymousClass1() {
        }

        @Override // androidx.lifecycle.LifecycleEventObserver
        public void onStateChanged(androidx.lifecycle.LifecycleOwner lifecycleOwner, androidx.lifecycle.Lifecycle.Event event) {
            if (event == androidx.lifecycle.Lifecycle.Event.ON_START) {
                androidx.savedstate.SavedStateRegistry.this.mAllowingSavingState = true;
            } else if (event == androidx.lifecycle.Lifecycle.Event.ON_STOP) {
                androidx.savedstate.SavedStateRegistry.this.mAllowingSavingState = false;
            }
        }
    }

    public interface AutoRecreated {
        void onRecreated(@androidx.annotation.NonNull androidx.savedstate.SavedStateRegistryOwner savedStateRegistryOwner);
    }

    public interface SavedStateProvider {
        @androidx.annotation.NonNull
        android.os.Bundle saveState();
    }

    @androidx.annotation.Nullable
    @androidx.annotation.MainThread
    public android.os.Bundle consumeRestoredStateForKey(@androidx.annotation.NonNull java.lang.String str) {
        if (!this.mRestored) {
            throw new java.lang.IllegalStateException("You can consumeRestoredStateForKey only after super.onCreate of corresponding component");
        }
        android.os.Bundle bundle = this.mRestoredState;
        if (bundle == null) {
            return null;
        }
        android.os.Bundle bundle2 = bundle.getBundle(str);
        this.mRestoredState.remove(str);
        if (this.mRestoredState.isEmpty()) {
            this.mRestoredState = null;
        }
        return bundle2;
    }

    @androidx.annotation.MainThread
    public boolean isRestored() {
        return this.mRestored;
    }

    @androidx.annotation.MainThread
    public void performRestore(@androidx.annotation.NonNull androidx.lifecycle.Lifecycle lifecycle, @androidx.annotation.Nullable android.os.Bundle bundle) {
        if (this.mRestored) {
            throw new java.lang.IllegalStateException("SavedStateRegistry was already restored.");
        }
        if (bundle != null) {
            this.mRestoredState = bundle.getBundle(SAVED_COMPONENTS_KEY);
        }
        lifecycle.addObserver(new androidx.savedstate.SavedStateRegistry.AnonymousClass1());
        this.mRestored = true;
    }

    @androidx.annotation.MainThread
    public void performSave(@androidx.annotation.NonNull android.os.Bundle bundle) {
        android.os.Bundle bundle2 = new android.os.Bundle();
        android.os.Bundle bundle3 = this.mRestoredState;
        if (bundle3 != null) {
            bundle2.putAll(bundle3);
        }
        androidx.arch.core.internal.SafeIterableMap<java.lang.String, androidx.savedstate.SavedStateRegistry.SavedStateProvider>.IteratorWithAdditions iteratorWithAdditions = this.mComponents.iteratorWithAdditions();
        while (iteratorWithAdditions.hasNext()) {
            java.util.Map.Entry next = iteratorWithAdditions.next();
            bundle2.putBundle((java.lang.String) next.getKey(), ((androidx.savedstate.SavedStateRegistry.SavedStateProvider) next.getValue()).saveState());
        }
        bundle.putBundle(SAVED_COMPONENTS_KEY, bundle2);
    }

    @androidx.annotation.MainThread
    public void registerSavedStateProvider(@androidx.annotation.NonNull java.lang.String str, @androidx.annotation.NonNull androidx.savedstate.SavedStateRegistry.SavedStateProvider savedStateProvider) {
        if (this.mComponents.putIfAbsent(str, savedStateProvider) != null) {
            throw new java.lang.IllegalArgumentException("SavedStateProvider with the given key is already registered");
        }
    }

    @androidx.annotation.MainThread
    public void runOnNextRecreation(@androidx.annotation.NonNull java.lang.Class<? extends androidx.savedstate.SavedStateRegistry.AutoRecreated> cls) {
        if (!this.mAllowingSavingState) {
            throw new java.lang.IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
        if (this.mRecreatorProvider == null) {
            this.mRecreatorProvider = new androidx.savedstate.Recreator.SavedStateProvider(this);
        }
        try {
            cls.getDeclaredConstructor(new java.lang.Class[0]);
            this.mRecreatorProvider.add(cls.getName());
        } catch (java.lang.NoSuchMethodException e) {
            throw new java.lang.IllegalArgumentException("Class" + cls.getSimpleName() + " must have default constructor in order to be automatically recreated", e);
        }
    }

    @androidx.annotation.MainThread
    public void unregisterSavedStateProvider(@androidx.annotation.NonNull java.lang.String str) {
        this.mComponents.remove(str);
    }
}
