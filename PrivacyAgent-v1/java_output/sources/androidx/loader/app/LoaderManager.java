package androidx.loader.app;

/* loaded from: classes.dex */
public abstract class LoaderManager {

    public interface LoaderCallbacks<D> {
        @androidx.annotation.NonNull
        @androidx.annotation.MainThread
        androidx.loader.content.Loader<D> onCreateLoader(int i, @androidx.annotation.Nullable android.os.Bundle bundle);

        @androidx.annotation.MainThread
        void onLoadFinished(@androidx.annotation.NonNull androidx.loader.content.Loader<D> loader, D d);

        @androidx.annotation.MainThread
        void onLoaderReset(@androidx.annotation.NonNull androidx.loader.content.Loader<D> loader);
    }

    public static void enableDebugLogging(boolean z) {
        androidx.loader.app.LoaderManagerImpl.DEBUG = z;
    }

    @androidx.annotation.NonNull
    public static <T extends androidx.lifecycle.LifecycleOwner & androidx.lifecycle.ViewModelStoreOwner> androidx.loader.app.LoaderManager getInstance(@androidx.annotation.NonNull T t) {
        return new androidx.loader.app.LoaderManagerImpl(t, t.getViewModelStore());
    }

    @androidx.annotation.MainThread
    public abstract void destroyLoader(int i);

    @java.lang.Deprecated
    public abstract void dump(java.lang.String str, java.io.FileDescriptor fileDescriptor, java.io.PrintWriter printWriter, java.lang.String[] strArr);

    @androidx.annotation.Nullable
    public abstract <D> androidx.loader.content.Loader<D> getLoader(int i);

    public boolean hasRunningLoaders() {
        return false;
    }

    @androidx.annotation.NonNull
    @androidx.annotation.MainThread
    public abstract <D> androidx.loader.content.Loader<D> initLoader(int i, @androidx.annotation.Nullable android.os.Bundle bundle, @androidx.annotation.NonNull androidx.loader.app.LoaderManager.LoaderCallbacks<D> loaderCallbacks);

    public abstract void markForRedelivery();

    @androidx.annotation.NonNull
    @androidx.annotation.MainThread
    public abstract <D> androidx.loader.content.Loader<D> restartLoader(int i, @androidx.annotation.Nullable android.os.Bundle bundle, @androidx.annotation.NonNull androidx.loader.app.LoaderManager.LoaderCallbacks<D> loaderCallbacks);
}
