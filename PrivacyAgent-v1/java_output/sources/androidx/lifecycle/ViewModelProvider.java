package androidx.lifecycle;

@kotlin.Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001:\u0005\u0014\u0015\u0016\u0017\u0018B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u0015\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\nJ&\u0010\u000b\u001a\u0002H\f\"\b\b\u0000\u0010\f*\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\f0\u000fH\u0097\u0002¢\u0006\u0002\u0010\u0010J.\u0010\u000b\u001a\u0002H\f\"\b\b\u0000\u0010\f*\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00122\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\f0\u000fH\u0097\u0002¢\u0006\u0002\u0010\u0013R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Landroidx/lifecycle/ViewModelProvider;", "", "owner", "Landroidx/lifecycle/ViewModelStoreOwner;", "(Landroidx/lifecycle/ViewModelStoreOwner;)V", "factory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "(Landroidx/lifecycle/ViewModelStoreOwner;Landroidx/lifecycle/ViewModelProvider$Factory;)V", "store", "Landroidx/lifecycle/ViewModelStore;", "(Landroidx/lifecycle/ViewModelStore;Landroidx/lifecycle/ViewModelProvider$Factory;)V", com.ss.android.socialbase.downloader.constants.MonitorConstants.CONNECT_TYPE_GET, androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "key", "", "(Ljava/lang/String;Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "AndroidViewModelFactory", "Factory", "KeyedFactory", "NewInstanceFactory", "OnRequeryFactory", "lifecycle-viewmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public class ViewModelProvider {

    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.ViewModelProvider.Factory factory;

    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.ViewModelStore store;

    @kotlin.Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J%\u0010\u0005\u001a\u0002H\u0006\"\b\b\u0000\u0010\u0006*\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00060\tH\u0016¢\u0006\u0002\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Landroidx/lifecycle/ViewModelProvider$AndroidViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$NewInstanceFactory;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "create", androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "Companion", "lifecycle-viewmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static class AndroidViewModelFactory extends androidx.lifecycle.ViewModelProvider.NewInstanceFactory {

        /* renamed from: Companion, reason: from kotlin metadata */
        @org.jetbrains.annotations.NotNull
        public static final androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion INSTANCE = new androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion(null);

        @org.jetbrains.annotations.NotNull
        public static final java.lang.String DEFAULT_KEY = "androidx.lifecycle.ViewModelProvider.DefaultKey";

        @org.jetbrains.annotations.Nullable
        private static androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory sInstance;

        @org.jetbrains.annotations.NotNull
        private final android.app.Application application;

        @kotlin.Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0000¢\u0006\u0002\b\u000bJ\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000eH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Landroidx/lifecycle/ViewModelProvider$AndroidViewModelFactory$Companion;", "", "()V", "DEFAULT_KEY", "", "sInstance", "Landroidx/lifecycle/ViewModelProvider$AndroidViewModelFactory;", "defaultFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "owner", "Landroidx/lifecycle/ViewModelStoreOwner;", "defaultFactory$lifecycle_viewmodel_release", "getInstance", "application", "Landroid/app/Application;", "lifecycle-viewmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @org.jetbrains.annotations.NotNull
            public final androidx.lifecycle.ViewModelProvider.Factory defaultFactory$lifecycle_viewmodel_release(@org.jetbrains.annotations.NotNull androidx.lifecycle.ViewModelStoreOwner owner) {
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(owner, "owner");
                if (!(owner instanceof androidx.lifecycle.HasDefaultViewModelProviderFactory)) {
                    return androidx.lifecycle.ViewModelProvider.NewInstanceFactory.INSTANCE.getInstance();
                }
                androidx.lifecycle.ViewModelProvider.Factory defaultViewModelProviderFactory = ((androidx.lifecycle.HasDefaultViewModelProviderFactory) owner).getDefaultViewModelProviderFactory();
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory, "owner.defaultViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }

            @kotlin.jvm.JvmStatic
            @org.jetbrains.annotations.NotNull
            public final androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory getInstance(@org.jetbrains.annotations.NotNull android.app.Application application) {
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(application, "application");
                if (androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.sInstance == null) {
                    androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.sInstance = new androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory(application);
                }
                androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory androidViewModelFactory = androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.sInstance;
                kotlin.jvm.internal.Intrinsics.checkNotNull(androidViewModelFactory);
                return androidViewModelFactory;
            }
        }

        public AndroidViewModelFactory(@org.jetbrains.annotations.NotNull android.app.Application application) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(application, "application");
            this.application = application;
        }

        @kotlin.jvm.JvmStatic
        @org.jetbrains.annotations.NotNull
        public static final androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory getInstance(@org.jetbrains.annotations.NotNull android.app.Application application) {
            return INSTANCE.getInstance(application);
        }

        @Override // androidx.lifecycle.ViewModelProvider.NewInstanceFactory, androidx.lifecycle.ViewModelProvider.Factory
        @org.jetbrains.annotations.NotNull
        public <T extends androidx.lifecycle.ViewModel> T create(@org.jetbrains.annotations.NotNull java.lang.Class<T> modelClass) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(modelClass, "modelClass");
            if (!androidx.lifecycle.AndroidViewModel.class.isAssignableFrom(modelClass)) {
                return (T) super.create(modelClass);
            }
            try {
                T newInstance = modelClass.getConstructor(android.app.Application.class).newInstance(this.application);
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(newInstance, "{\n                try {\n…          }\n            }");
                return newInstance;
            } catch (java.lang.IllegalAccessException e) {
                throw new java.lang.RuntimeException(kotlin.jvm.internal.Intrinsics.stringPlus("Cannot create an instance of ", modelClass), e);
            } catch (java.lang.InstantiationException e2) {
                throw new java.lang.RuntimeException(kotlin.jvm.internal.Intrinsics.stringPlus("Cannot create an instance of ", modelClass), e2);
            } catch (java.lang.NoSuchMethodException e3) {
                throw new java.lang.RuntimeException(kotlin.jvm.internal.Intrinsics.stringPlus("Cannot create an instance of ", modelClass), e3);
            } catch (java.lang.reflect.InvocationTargetException e4) {
                throw new java.lang.RuntimeException(kotlin.jvm.internal.Intrinsics.stringPlus("Cannot create an instance of ", modelClass), e4);
            }
        }
    }

    @kotlin.Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J%\u0010\u0002\u001a\u0002H\u0003\"\b\b\u0000\u0010\u0003*\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0006H&¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/lifecycle/ViewModelProvider$Factory;", "", "create", androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "lifecycle-viewmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface Factory {
        @org.jetbrains.annotations.NotNull
        <T extends androidx.lifecycle.ViewModel> T create(@org.jetbrains.annotations.NotNull java.lang.Class<T> modelClass);
    }

    @kotlin.Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b'\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J%\u0010\u0004\u001a\u0002H\u0005\"\b\b\u0000\u0010\u0005*\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00050\bH\u0016¢\u0006\u0002\u0010\tJ-\u0010\u0004\u001a\u0002H\u0005\"\b\b\u0000\u0010\u0005*\u00020\u00062\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00050\bH&¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"Landroidx/lifecycle/ViewModelProvider$KeyedFactory;", "Landroidx/lifecycle/ViewModelProvider$OnRequeryFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "()V", "create", androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "key", "", "(Ljava/lang/String;Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "lifecycle-viewmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public static abstract class KeyedFactory extends androidx.lifecycle.ViewModelProvider.OnRequeryFactory implements androidx.lifecycle.ViewModelProvider.Factory {
        @org.jetbrains.annotations.NotNull
        public <T extends androidx.lifecycle.ViewModel> T create(@org.jetbrains.annotations.NotNull java.lang.Class<T> modelClass) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(modelClass, "modelClass");
            throw new java.lang.UnsupportedOperationException("create(String, Class<?>) must be called on implementations of KeyedFactory");
        }

        @org.jetbrains.annotations.NotNull
        public abstract <T extends androidx.lifecycle.ViewModel> T create(@org.jetbrains.annotations.NotNull java.lang.String key, @org.jetbrains.annotations.NotNull java.lang.Class<T> modelClass);
    }

    @kotlin.Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0002J%\u0010\u0003\u001a\u0002H\u0004\"\b\b\u0000\u0010\u0004*\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0007H\u0016¢\u0006\u0002\u0010\b¨\u0006\n"}, d2 = {"Landroidx/lifecycle/ViewModelProvider$NewInstanceFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "()V", "create", androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "Companion", "lifecycle-viewmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static class NewInstanceFactory implements androidx.lifecycle.ViewModelProvider.Factory {

        /* renamed from: Companion, reason: from kotlin metadata */
        @org.jetbrains.annotations.NotNull
        public static final androidx.lifecycle.ViewModelProvider.NewInstanceFactory.Companion INSTANCE = new androidx.lifecycle.ViewModelProvider.NewInstanceFactory.Companion(null);

        @org.jetbrains.annotations.Nullable
        private static androidx.lifecycle.ViewModelProvider.NewInstanceFactory sInstance;

        @kotlin.Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u00048GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Landroidx/lifecycle/ViewModelProvider$NewInstanceFactory$Companion;", "", "()V", "instance", "Landroidx/lifecycle/ViewModelProvider$NewInstanceFactory;", "getInstance$annotations", "getInstance", "()Landroidx/lifecycle/ViewModelProvider$NewInstanceFactory;", "sInstance", "lifecycle-viewmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @kotlin.jvm.JvmStatic
            public static /* synthetic */ void getInstance$annotations() {
            }

            @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
            @org.jetbrains.annotations.NotNull
            public final androidx.lifecycle.ViewModelProvider.NewInstanceFactory getInstance() {
                if (androidx.lifecycle.ViewModelProvider.NewInstanceFactory.sInstance == null) {
                    androidx.lifecycle.ViewModelProvider.NewInstanceFactory.sInstance = new androidx.lifecycle.ViewModelProvider.NewInstanceFactory();
                }
                androidx.lifecycle.ViewModelProvider.NewInstanceFactory newInstanceFactory = androidx.lifecycle.ViewModelProvider.NewInstanceFactory.sInstance;
                kotlin.jvm.internal.Intrinsics.checkNotNull(newInstanceFactory);
                return newInstanceFactory;
            }
        }

        @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
        @org.jetbrains.annotations.NotNull
        public static final androidx.lifecycle.ViewModelProvider.NewInstanceFactory getInstance() {
            return INSTANCE.getInstance();
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        @org.jetbrains.annotations.NotNull
        public <T extends androidx.lifecycle.ViewModel> T create(@org.jetbrains.annotations.NotNull java.lang.Class<T> modelClass) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(modelClass, "modelClass");
            try {
                T newInstance = modelClass.newInstance();
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(newInstance, "{\n                modelC…wInstance()\n            }");
                return newInstance;
            } catch (java.lang.IllegalAccessException e) {
                throw new java.lang.RuntimeException(kotlin.jvm.internal.Intrinsics.stringPlus("Cannot create an instance of ", modelClass), e);
            } catch (java.lang.InstantiationException e2) {
                throw new java.lang.RuntimeException(kotlin.jvm.internal.Intrinsics.stringPlus("Cannot create an instance of ", modelClass), e2);
            }
        }
    }

    @kotlin.Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Landroidx/lifecycle/ViewModelProvider$OnRequeryFactory;", "", "()V", "onRequery", "", "viewModel", "Landroidx/lifecycle/ViewModel;", "lifecycle-viewmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public static class OnRequeryFactory {
        public void onRequery(@org.jetbrains.annotations.NotNull androidx.lifecycle.ViewModel viewModel) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        }
    }

    public ViewModelProvider(@org.jetbrains.annotations.NotNull androidx.lifecycle.ViewModelStore store, @org.jetbrains.annotations.NotNull androidx.lifecycle.ViewModelProvider.Factory factory) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(store, "store");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(factory, "factory");
        this.store = store;
        this.factory = factory;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ViewModelProvider(@org.jetbrains.annotations.NotNull androidx.lifecycle.ViewModelStoreOwner owner) {
        this(r0, androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.INSTANCE.defaultFactory$lifecycle_viewmodel_release(owner));
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(owner, "owner");
        androidx.lifecycle.ViewModelStore viewModelStore = owner.getViewModelStore();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(viewModelStore, "owner.viewModelStore");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ViewModelProvider(@org.jetbrains.annotations.NotNull androidx.lifecycle.ViewModelStoreOwner owner, @org.jetbrains.annotations.NotNull androidx.lifecycle.ViewModelProvider.Factory factory) {
        this(r2, factory);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(owner, "owner");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(factory, "factory");
        androidx.lifecycle.ViewModelStore viewModelStore = owner.getViewModelStore();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(viewModelStore, "owner.viewModelStore");
    }

    @androidx.annotation.MainThread
    @org.jetbrains.annotations.NotNull
    public <T extends androidx.lifecycle.ViewModel> T get(@org.jetbrains.annotations.NotNull java.lang.Class<T> modelClass) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(modelClass, "modelClass");
        java.lang.String canonicalName = modelClass.getCanonicalName();
        if (canonicalName != null) {
            return (T) get(kotlin.jvm.internal.Intrinsics.stringPlus("androidx.lifecycle.ViewModelProvider.DefaultKey:", canonicalName), modelClass);
        }
        throw new java.lang.IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    @androidx.annotation.MainThread
    @org.jetbrains.annotations.NotNull
    public <T extends androidx.lifecycle.ViewModel> T get(@org.jetbrains.annotations.NotNull java.lang.String key, @org.jetbrains.annotations.NotNull java.lang.Class<T> modelClass) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(key, "key");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(modelClass, "modelClass");
        T viewModel = (T) this.store.get(key);
        if (!modelClass.isInstance(viewModel)) {
            androidx.lifecycle.ViewModelProvider.Factory factory = this.factory;
            T viewModel2 = factory instanceof androidx.lifecycle.ViewModelProvider.KeyedFactory ? (T) ((androidx.lifecycle.ViewModelProvider.KeyedFactory) factory).create(key, modelClass) : (T) factory.create(modelClass);
            this.store.put(key, viewModel2);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(viewModel2, "viewModel");
            return viewModel2;
        }
        java.lang.Object obj = this.factory;
        androidx.lifecycle.ViewModelProvider.OnRequeryFactory onRequeryFactory = obj instanceof androidx.lifecycle.ViewModelProvider.OnRequeryFactory ? (androidx.lifecycle.ViewModelProvider.OnRequeryFactory) obj : null;
        if (onRequeryFactory != null) {
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(viewModel, "viewModel");
            onRequeryFactory.onRequery(viewModel);
        }
        if (viewModel != null) {
            return viewModel;
        }
        throw new java.lang.NullPointerException("null cannot be cast to non-null type T of androidx.lifecycle.ViewModelProvider.get");
    }
}
