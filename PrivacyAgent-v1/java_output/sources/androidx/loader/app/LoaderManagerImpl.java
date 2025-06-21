package androidx.loader.app;

/* loaded from: classes.dex */
class LoaderManagerImpl extends androidx.loader.app.LoaderManager {
    static boolean DEBUG = false;
    static final java.lang.String TAG = "LoaderManager";

    @androidx.annotation.NonNull
    private final androidx.lifecycle.LifecycleOwner mLifecycleOwner;

    @androidx.annotation.NonNull
    private final androidx.loader.app.LoaderManagerImpl.LoaderViewModel mLoaderViewModel;

    public static class LoaderInfo<D> extends androidx.lifecycle.MutableLiveData<D> implements androidx.loader.content.Loader.OnLoadCompleteListener<D> {

        @androidx.annotation.Nullable
        private final android.os.Bundle mArgs;
        private final int mId;
        private androidx.lifecycle.LifecycleOwner mLifecycleOwner;

        @androidx.annotation.NonNull
        private final androidx.loader.content.Loader<D> mLoader;
        private androidx.loader.app.LoaderManagerImpl.LoaderObserver<D> mObserver;
        private androidx.loader.content.Loader<D> mPriorLoader;

        public LoaderInfo(int i, @androidx.annotation.Nullable android.os.Bundle bundle, @androidx.annotation.NonNull androidx.loader.content.Loader<D> loader, @androidx.annotation.Nullable androidx.loader.content.Loader<D> loader2) {
            this.mId = i;
            this.mArgs = bundle;
            this.mLoader = loader;
            this.mPriorLoader = loader2;
            loader.registerListener(i, this);
        }

        @androidx.annotation.MainThread
        public androidx.loader.content.Loader<D> destroy(boolean z) {
            if (androidx.loader.app.LoaderManagerImpl.DEBUG) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("  Destroying: ");
                sb.append(this);
            }
            this.mLoader.cancelLoad();
            this.mLoader.abandon();
            androidx.loader.app.LoaderManagerImpl.LoaderObserver<D> loaderObserver = this.mObserver;
            if (loaderObserver != null) {
                removeObserver(loaderObserver);
                if (z) {
                    loaderObserver.reset();
                }
            }
            this.mLoader.unregisterListener(this);
            if ((loaderObserver == null || loaderObserver.hasDeliveredData()) && !z) {
                return this.mLoader;
            }
            this.mLoader.reset();
            return this.mPriorLoader;
        }

        public void dump(java.lang.String str, java.io.FileDescriptor fileDescriptor, java.io.PrintWriter printWriter, java.lang.String[] strArr) {
            printWriter.print(str);
            printWriter.print("mId=");
            printWriter.print(this.mId);
            printWriter.print(" mArgs=");
            printWriter.println(this.mArgs);
            printWriter.print(str);
            printWriter.print("mLoader=");
            printWriter.println(this.mLoader);
            this.mLoader.dump(str + "  ", fileDescriptor, printWriter, strArr);
            if (this.mObserver != null) {
                printWriter.print(str);
                printWriter.print("mCallbacks=");
                printWriter.println(this.mObserver);
                this.mObserver.dump(str + "  ", printWriter);
            }
            printWriter.print(str);
            printWriter.print("mData=");
            printWriter.println(getLoader().dataToString(getValue()));
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.println(hasActiveObservers());
        }

        @androidx.annotation.NonNull
        public androidx.loader.content.Loader<D> getLoader() {
            return this.mLoader;
        }

        public boolean isCallbackWaitingForData() {
            androidx.loader.app.LoaderManagerImpl.LoaderObserver<D> loaderObserver;
            return (!hasActiveObservers() || (loaderObserver = this.mObserver) == null || loaderObserver.hasDeliveredData()) ? false : true;
        }

        public void markForRedelivery() {
            androidx.lifecycle.LifecycleOwner lifecycleOwner = this.mLifecycleOwner;
            androidx.loader.app.LoaderManagerImpl.LoaderObserver<D> loaderObserver = this.mObserver;
            if (lifecycleOwner == null || loaderObserver == null) {
                return;
            }
            super.removeObserver(loaderObserver);
            observe(lifecycleOwner, loaderObserver);
        }

        @Override // androidx.lifecycle.LiveData
        public void onActive() {
            if (androidx.loader.app.LoaderManagerImpl.DEBUG) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("  Starting: ");
                sb.append(this);
            }
            this.mLoader.startLoading();
        }

        @Override // androidx.lifecycle.LiveData
        public void onInactive() {
            if (androidx.loader.app.LoaderManagerImpl.DEBUG) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("  Stopping: ");
                sb.append(this);
            }
            this.mLoader.stopLoading();
        }

        @Override // androidx.loader.content.Loader.OnLoadCompleteListener
        public void onLoadComplete(@androidx.annotation.NonNull androidx.loader.content.Loader<D> loader, @androidx.annotation.Nullable D d) {
            if (androidx.loader.app.LoaderManagerImpl.DEBUG) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("onLoadComplete: ");
                sb.append(this);
            }
            if (android.os.Looper.myLooper() == android.os.Looper.getMainLooper()) {
                setValue(d);
            } else {
                java.lang.String str = androidx.loader.app.LoaderManagerImpl.TAG;
                postValue(d);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.lifecycle.LiveData
        public void removeObserver(@androidx.annotation.NonNull androidx.lifecycle.Observer<? super D> observer) {
            super.removeObserver(observer);
            this.mLifecycleOwner = null;
            this.mObserver = null;
        }

        @androidx.annotation.NonNull
        @androidx.annotation.MainThread
        public androidx.loader.content.Loader<D> setCallback(@androidx.annotation.NonNull androidx.lifecycle.LifecycleOwner lifecycleOwner, @androidx.annotation.NonNull androidx.loader.app.LoaderManager.LoaderCallbacks<D> loaderCallbacks) {
            androidx.loader.app.LoaderManagerImpl.LoaderObserver<D> loaderObserver = new androidx.loader.app.LoaderManagerImpl.LoaderObserver<>(this.mLoader, loaderCallbacks);
            observe(lifecycleOwner, loaderObserver);
            androidx.loader.app.LoaderManagerImpl.LoaderObserver<D> loaderObserver2 = this.mObserver;
            if (loaderObserver2 != null) {
                removeObserver(loaderObserver2);
            }
            this.mLifecycleOwner = lifecycleOwner;
            this.mObserver = loaderObserver;
            return this.mLoader;
        }

        @Override // androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
        public void setValue(D d) {
            super.setValue(d);
            androidx.loader.content.Loader<D> loader = this.mPriorLoader;
            if (loader != null) {
                loader.reset();
                this.mPriorLoader = null;
            }
        }

        public java.lang.String toString() {
            java.lang.StringBuilder sb = new java.lang.StringBuilder(64);
            sb.append("LoaderInfo{");
            sb.append(java.lang.Integer.toHexString(java.lang.System.identityHashCode(this)));
            sb.append(" #");
            sb.append(this.mId);
            sb.append(" : ");
            androidx.core.util.DebugUtils.buildShortClassTag(this.mLoader, sb);
            sb.append("}}");
            return sb.toString();
        }
    }

    public static class LoaderObserver<D> implements androidx.lifecycle.Observer<D> {

        @androidx.annotation.NonNull
        private final androidx.loader.app.LoaderManager.LoaderCallbacks<D> mCallback;
        private boolean mDeliveredData = false;

        @androidx.annotation.NonNull
        private final androidx.loader.content.Loader<D> mLoader;

        public LoaderObserver(@androidx.annotation.NonNull androidx.loader.content.Loader<D> loader, @androidx.annotation.NonNull androidx.loader.app.LoaderManager.LoaderCallbacks<D> loaderCallbacks) {
            this.mLoader = loader;
            this.mCallback = loaderCallbacks;
        }

        public void dump(java.lang.String str, java.io.PrintWriter printWriter) {
            printWriter.print(str);
            printWriter.print("mDeliveredData=");
            printWriter.println(this.mDeliveredData);
        }

        public boolean hasDeliveredData() {
            return this.mDeliveredData;
        }

        @Override // androidx.lifecycle.Observer
        public void onChanged(@androidx.annotation.Nullable D d) {
            if (androidx.loader.app.LoaderManagerImpl.DEBUG) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("  onLoadFinished in ");
                sb.append(this.mLoader);
                sb.append(": ");
                sb.append(this.mLoader.dataToString(d));
            }
            this.mCallback.onLoadFinished(this.mLoader, d);
            this.mDeliveredData = true;
        }

        @androidx.annotation.MainThread
        public void reset() {
            if (this.mDeliveredData) {
                if (androidx.loader.app.LoaderManagerImpl.DEBUG) {
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    sb.append("  Resetting: ");
                    sb.append(this.mLoader);
                }
                this.mCallback.onLoaderReset(this.mLoader);
            }
        }

        public java.lang.String toString() {
            return this.mCallback.toString();
        }
    }

    public static class LoaderViewModel extends androidx.lifecycle.ViewModel {
        private static final androidx.lifecycle.ViewModelProvider.Factory FACTORY = new androidx.loader.app.LoaderManagerImpl.LoaderViewModel.AnonymousClass1();
        private androidx.collection.SparseArrayCompat<androidx.loader.app.LoaderManagerImpl.LoaderInfo> mLoaders = new androidx.collection.SparseArrayCompat<>();
        private boolean mCreatingLoader = false;

        /* renamed from: androidx.loader.app.LoaderManagerImpl$LoaderViewModel$1, reason: invalid class name */
        public static class AnonymousClass1 implements androidx.lifecycle.ViewModelProvider.Factory {
            @Override // androidx.lifecycle.ViewModelProvider.Factory
            @androidx.annotation.NonNull
            public <T extends androidx.lifecycle.ViewModel> T create(@androidx.annotation.NonNull java.lang.Class<T> cls) {
                return new androidx.loader.app.LoaderManagerImpl.LoaderViewModel();
            }
        }

        @androidx.annotation.NonNull
        public static androidx.loader.app.LoaderManagerImpl.LoaderViewModel getInstance(androidx.lifecycle.ViewModelStore viewModelStore) {
            return (androidx.loader.app.LoaderManagerImpl.LoaderViewModel) new androidx.lifecycle.ViewModelProvider(viewModelStore, FACTORY).get(androidx.loader.app.LoaderManagerImpl.LoaderViewModel.class);
        }

        public void dump(java.lang.String str, java.io.FileDescriptor fileDescriptor, java.io.PrintWriter printWriter, java.lang.String[] strArr) {
            if (this.mLoaders.size() > 0) {
                printWriter.print(str);
                printWriter.println("Loaders:");
                java.lang.String str2 = str + "    ";
                for (int i = 0; i < this.mLoaders.size(); i++) {
                    androidx.loader.app.LoaderManagerImpl.LoaderInfo valueAt = this.mLoaders.valueAt(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(this.mLoaders.keyAt(i));
                    printWriter.print(": ");
                    printWriter.println(valueAt.toString());
                    valueAt.dump(str2, fileDescriptor, printWriter, strArr);
                }
            }
        }

        public void finishCreatingLoader() {
            this.mCreatingLoader = false;
        }

        public <D> androidx.loader.app.LoaderManagerImpl.LoaderInfo<D> getLoader(int i) {
            return this.mLoaders.get(i);
        }

        public boolean hasRunningLoaders() {
            int size = this.mLoaders.size();
            for (int i = 0; i < size; i++) {
                if (this.mLoaders.valueAt(i).isCallbackWaitingForData()) {
                    return true;
                }
            }
            return false;
        }

        public boolean isCreatingLoader() {
            return this.mCreatingLoader;
        }

        public void markForRedelivery() {
            int size = this.mLoaders.size();
            for (int i = 0; i < size; i++) {
                this.mLoaders.valueAt(i).markForRedelivery();
            }
        }

        @Override // androidx.lifecycle.ViewModel
        public void onCleared() {
            super.onCleared();
            int size = this.mLoaders.size();
            for (int i = 0; i < size; i++) {
                this.mLoaders.valueAt(i).destroy(true);
            }
            this.mLoaders.clear();
        }

        public void putLoader(int i, @androidx.annotation.NonNull androidx.loader.app.LoaderManagerImpl.LoaderInfo loaderInfo) {
            this.mLoaders.put(i, loaderInfo);
        }

        public void removeLoader(int i) {
            this.mLoaders.remove(i);
        }

        public void startCreatingLoader() {
            this.mCreatingLoader = true;
        }
    }

    public LoaderManagerImpl(@androidx.annotation.NonNull androidx.lifecycle.LifecycleOwner lifecycleOwner, @androidx.annotation.NonNull androidx.lifecycle.ViewModelStore viewModelStore) {
        this.mLifecycleOwner = lifecycleOwner;
        this.mLoaderViewModel = androidx.loader.app.LoaderManagerImpl.LoaderViewModel.getInstance(viewModelStore);
    }

    @androidx.annotation.NonNull
    @androidx.annotation.MainThread
    private <D> androidx.loader.content.Loader<D> createAndInstallLoader(int i, @androidx.annotation.Nullable android.os.Bundle bundle, @androidx.annotation.NonNull androidx.loader.app.LoaderManager.LoaderCallbacks<D> loaderCallbacks, @androidx.annotation.Nullable androidx.loader.content.Loader<D> loader) {
        try {
            this.mLoaderViewModel.startCreatingLoader();
            androidx.loader.content.Loader<D> onCreateLoader = loaderCallbacks.onCreateLoader(i, bundle);
            if (onCreateLoader == null) {
                throw new java.lang.IllegalArgumentException("Object returned from onCreateLoader must not be null");
            }
            if (onCreateLoader.getClass().isMemberClass() && !java.lang.reflect.Modifier.isStatic(onCreateLoader.getClass().getModifiers())) {
                throw new java.lang.IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + onCreateLoader);
            }
            androidx.loader.app.LoaderManagerImpl.LoaderInfo loaderInfo = new androidx.loader.app.LoaderManagerImpl.LoaderInfo(i, bundle, onCreateLoader, loader);
            if (DEBUG) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("  Created new loader ");
                sb.append(loaderInfo);
            }
            this.mLoaderViewModel.putLoader(i, loaderInfo);
            this.mLoaderViewModel.finishCreatingLoader();
            return loaderInfo.setCallback(this.mLifecycleOwner, loaderCallbacks);
        } catch (java.lang.Throwable th) {
            this.mLoaderViewModel.finishCreatingLoader();
            throw th;
        }
    }

    @Override // androidx.loader.app.LoaderManager
    @androidx.annotation.MainThread
    public void destroyLoader(int i) {
        if (this.mLoaderViewModel.isCreatingLoader()) {
            throw new java.lang.IllegalStateException("Called while creating a loader");
        }
        if (android.os.Looper.getMainLooper() != android.os.Looper.myLooper()) {
            throw new java.lang.IllegalStateException("destroyLoader must be called on the main thread");
        }
        if (DEBUG) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("destroyLoader in ");
            sb.append(this);
            sb.append(" of ");
            sb.append(i);
        }
        androidx.loader.app.LoaderManagerImpl.LoaderInfo loader = this.mLoaderViewModel.getLoader(i);
        if (loader != null) {
            loader.destroy(true);
            this.mLoaderViewModel.removeLoader(i);
        }
    }

    @Override // androidx.loader.app.LoaderManager
    @java.lang.Deprecated
    public void dump(java.lang.String str, java.io.FileDescriptor fileDescriptor, java.io.PrintWriter printWriter, java.lang.String[] strArr) {
        this.mLoaderViewModel.dump(str, fileDescriptor, printWriter, strArr);
    }

    @Override // androidx.loader.app.LoaderManager
    @androidx.annotation.Nullable
    public <D> androidx.loader.content.Loader<D> getLoader(int i) {
        if (this.mLoaderViewModel.isCreatingLoader()) {
            throw new java.lang.IllegalStateException("Called while creating a loader");
        }
        androidx.loader.app.LoaderManagerImpl.LoaderInfo<D> loader = this.mLoaderViewModel.getLoader(i);
        if (loader != null) {
            return loader.getLoader();
        }
        return null;
    }

    @Override // androidx.loader.app.LoaderManager
    public boolean hasRunningLoaders() {
        return this.mLoaderViewModel.hasRunningLoaders();
    }

    @Override // androidx.loader.app.LoaderManager
    @androidx.annotation.NonNull
    @androidx.annotation.MainThread
    public <D> androidx.loader.content.Loader<D> initLoader(int i, @androidx.annotation.Nullable android.os.Bundle bundle, @androidx.annotation.NonNull androidx.loader.app.LoaderManager.LoaderCallbacks<D> loaderCallbacks) {
        if (this.mLoaderViewModel.isCreatingLoader()) {
            throw new java.lang.IllegalStateException("Called while creating a loader");
        }
        if (android.os.Looper.getMainLooper() != android.os.Looper.myLooper()) {
            throw new java.lang.IllegalStateException("initLoader must be called on the main thread");
        }
        androidx.loader.app.LoaderManagerImpl.LoaderInfo<D> loader = this.mLoaderViewModel.getLoader(i);
        if (DEBUG) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("initLoader in ");
            sb.append(this);
            sb.append(": args=");
            sb.append(bundle);
        }
        if (loader == null) {
            return createAndInstallLoader(i, bundle, loaderCallbacks, null);
        }
        if (DEBUG) {
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
            sb2.append("  Re-using existing loader ");
            sb2.append(loader);
        }
        return loader.setCallback(this.mLifecycleOwner, loaderCallbacks);
    }

    @Override // androidx.loader.app.LoaderManager
    public void markForRedelivery() {
        this.mLoaderViewModel.markForRedelivery();
    }

    @Override // androidx.loader.app.LoaderManager
    @androidx.annotation.NonNull
    @androidx.annotation.MainThread
    public <D> androidx.loader.content.Loader<D> restartLoader(int i, @androidx.annotation.Nullable android.os.Bundle bundle, @androidx.annotation.NonNull androidx.loader.app.LoaderManager.LoaderCallbacks<D> loaderCallbacks) {
        if (this.mLoaderViewModel.isCreatingLoader()) {
            throw new java.lang.IllegalStateException("Called while creating a loader");
        }
        if (android.os.Looper.getMainLooper() != android.os.Looper.myLooper()) {
            throw new java.lang.IllegalStateException("restartLoader must be called on the main thread");
        }
        if (DEBUG) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("restartLoader in ");
            sb.append(this);
            sb.append(": args=");
            sb.append(bundle);
        }
        androidx.loader.app.LoaderManagerImpl.LoaderInfo<D> loader = this.mLoaderViewModel.getLoader(i);
        return createAndInstallLoader(i, bundle, loaderCallbacks, loader != null ? loader.destroy(false) : null);
    }

    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(java.lang.Integer.toHexString(java.lang.System.identityHashCode(this)));
        sb.append(" in ");
        androidx.core.util.DebugUtils.buildShortClassTag(this.mLifecycleOwner, sb);
        sb.append("}}");
        return sb.toString();
    }
}
