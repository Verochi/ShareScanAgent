package androidx.lifecycle;

/* loaded from: classes.dex */
public final class SavedStateViewModelFactory extends androidx.lifecycle.ViewModelProvider.KeyedFactory {
    private static final java.lang.Class<?>[] ANDROID_VIEWMODEL_SIGNATURE = {android.app.Application.class, androidx.lifecycle.SavedStateHandle.class};
    private static final java.lang.Class<?>[] VIEWMODEL_SIGNATURE = {androidx.lifecycle.SavedStateHandle.class};
    private final android.app.Application mApplication;
    private final android.os.Bundle mDefaultArgs;
    private final androidx.lifecycle.ViewModelProvider.Factory mFactory;
    private final androidx.lifecycle.Lifecycle mLifecycle;
    private final androidx.savedstate.SavedStateRegistry mSavedStateRegistry;

    public SavedStateViewModelFactory(@androidx.annotation.Nullable android.app.Application application, @androidx.annotation.NonNull androidx.savedstate.SavedStateRegistryOwner savedStateRegistryOwner) {
        this(application, savedStateRegistryOwner, null);
    }

    @android.annotation.SuppressLint({"LambdaLast"})
    public SavedStateViewModelFactory(@androidx.annotation.Nullable android.app.Application application, @androidx.annotation.NonNull androidx.savedstate.SavedStateRegistryOwner savedStateRegistryOwner, @androidx.annotation.Nullable android.os.Bundle bundle) {
        this.mSavedStateRegistry = savedStateRegistryOwner.getSavedStateRegistry();
        this.mLifecycle = savedStateRegistryOwner.getLifecycle();
        this.mDefaultArgs = bundle;
        this.mApplication = application;
        this.mFactory = application != null ? androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.getInstance(application) : androidx.lifecycle.ViewModelProvider.NewInstanceFactory.getInstance();
    }

    private static <T> java.lang.reflect.Constructor<T> findMatchingConstructor(java.lang.Class<T> cls, java.lang.Class<?>[] clsArr) {
        for (java.lang.Object obj : cls.getConstructors()) {
            java.lang.reflect.Constructor<T> constructor = (java.lang.reflect.Constructor<T>) obj;
            if (java.util.Arrays.equals(clsArr, constructor.getParameterTypes())) {
                return constructor;
            }
        }
        return null;
    }

    @Override // androidx.lifecycle.ViewModelProvider.KeyedFactory, androidx.lifecycle.ViewModelProvider.Factory
    @androidx.annotation.NonNull
    public <T extends androidx.lifecycle.ViewModel> T create(@androidx.annotation.NonNull java.lang.Class<T> cls) {
        java.lang.String canonicalName = cls.getCanonicalName();
        if (canonicalName != null) {
            return (T) create(canonicalName, cls);
        }
        throw new java.lang.IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    @Override // androidx.lifecycle.ViewModelProvider.KeyedFactory
    @androidx.annotation.NonNull
    public <T extends androidx.lifecycle.ViewModel> T create(@androidx.annotation.NonNull java.lang.String str, @androidx.annotation.NonNull java.lang.Class<T> cls) {
        T t;
        boolean isAssignableFrom = androidx.lifecycle.AndroidViewModel.class.isAssignableFrom(cls);
        java.lang.reflect.Constructor findMatchingConstructor = (!isAssignableFrom || this.mApplication == null) ? findMatchingConstructor(cls, VIEWMODEL_SIGNATURE) : findMatchingConstructor(cls, ANDROID_VIEWMODEL_SIGNATURE);
        if (findMatchingConstructor == null) {
            return (T) this.mFactory.create(cls);
        }
        androidx.lifecycle.SavedStateHandleController create = androidx.lifecycle.SavedStateHandleController.create(this.mSavedStateRegistry, this.mLifecycle, str, this.mDefaultArgs);
        if (isAssignableFrom) {
            try {
                android.app.Application application = this.mApplication;
                if (application != null) {
                    t = (T) findMatchingConstructor.newInstance(application, create.getHandle());
                    t.setTagIfAbsent("androidx.lifecycle.savedstate.vm.tag", create);
                    return t;
                }
            } catch (java.lang.IllegalAccessException e) {
                throw new java.lang.RuntimeException("Failed to access " + cls, e);
            } catch (java.lang.InstantiationException e2) {
                throw new java.lang.RuntimeException("A " + cls + " cannot be instantiated.", e2);
            } catch (java.lang.reflect.InvocationTargetException e3) {
                throw new java.lang.RuntimeException("An exception happened in constructor of " + cls, e3.getCause());
            }
        }
        t = (T) findMatchingConstructor.newInstance(create.getHandle());
        t.setTagIfAbsent("androidx.lifecycle.savedstate.vm.tag", create);
        return t;
    }

    @Override // androidx.lifecycle.ViewModelProvider.OnRequeryFactory
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public void onRequery(@androidx.annotation.NonNull androidx.lifecycle.ViewModel viewModel) {
        androidx.lifecycle.SavedStateHandleController.attachHandleIfNeeded(viewModel, this.mSavedStateRegistry, this.mLifecycle);
    }
}
