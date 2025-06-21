package androidx.fragment.app;

/* loaded from: classes.dex */
public class FragmentController {
    private final androidx.fragment.app.FragmentHostCallback<?> mHost;

    private FragmentController(androidx.fragment.app.FragmentHostCallback<?> fragmentHostCallback) {
        this.mHost = fragmentHostCallback;
    }

    @androidx.annotation.NonNull
    public static androidx.fragment.app.FragmentController createController(@androidx.annotation.NonNull androidx.fragment.app.FragmentHostCallback<?> fragmentHostCallback) {
        return new androidx.fragment.app.FragmentController((androidx.fragment.app.FragmentHostCallback) androidx.core.util.Preconditions.checkNotNull(fragmentHostCallback, "callbacks == null"));
    }

    public void attachHost(@androidx.annotation.Nullable androidx.fragment.app.Fragment fragment) {
        androidx.fragment.app.FragmentHostCallback<?> fragmentHostCallback = this.mHost;
        fragmentHostCallback.mFragmentManager.attachController(fragmentHostCallback, fragmentHostCallback, fragment);
    }

    public void dispatchActivityCreated() {
        this.mHost.mFragmentManager.dispatchActivityCreated();
    }

    public void dispatchConfigurationChanged(@androidx.annotation.NonNull android.content.res.Configuration configuration) {
        this.mHost.mFragmentManager.dispatchConfigurationChanged(configuration);
    }

    public boolean dispatchContextItemSelected(@androidx.annotation.NonNull android.view.MenuItem menuItem) {
        return this.mHost.mFragmentManager.dispatchContextItemSelected(menuItem);
    }

    public void dispatchCreate() {
        this.mHost.mFragmentManager.dispatchCreate();
    }

    public boolean dispatchCreateOptionsMenu(@androidx.annotation.NonNull android.view.Menu menu, @androidx.annotation.NonNull android.view.MenuInflater menuInflater) {
        return this.mHost.mFragmentManager.dispatchCreateOptionsMenu(menu, menuInflater);
    }

    public void dispatchDestroy() {
        this.mHost.mFragmentManager.dispatchDestroy();
    }

    public void dispatchDestroyView() {
        this.mHost.mFragmentManager.dispatchDestroyView();
    }

    public void dispatchLowMemory() {
        this.mHost.mFragmentManager.dispatchLowMemory();
    }

    public void dispatchMultiWindowModeChanged(boolean z) {
        this.mHost.mFragmentManager.dispatchMultiWindowModeChanged(z);
    }

    public boolean dispatchOptionsItemSelected(@androidx.annotation.NonNull android.view.MenuItem menuItem) {
        return this.mHost.mFragmentManager.dispatchOptionsItemSelected(menuItem);
    }

    public void dispatchOptionsMenuClosed(@androidx.annotation.NonNull android.view.Menu menu) {
        this.mHost.mFragmentManager.dispatchOptionsMenuClosed(menu);
    }

    public void dispatchPause() {
        this.mHost.mFragmentManager.dispatchPause();
    }

    public void dispatchPictureInPictureModeChanged(boolean z) {
        this.mHost.mFragmentManager.dispatchPictureInPictureModeChanged(z);
    }

    public boolean dispatchPrepareOptionsMenu(@androidx.annotation.NonNull android.view.Menu menu) {
        return this.mHost.mFragmentManager.dispatchPrepareOptionsMenu(menu);
    }

    @java.lang.Deprecated
    public void dispatchReallyStop() {
    }

    public void dispatchResume() {
        this.mHost.mFragmentManager.dispatchResume();
    }

    public void dispatchStart() {
        this.mHost.mFragmentManager.dispatchStart();
    }

    public void dispatchStop() {
        this.mHost.mFragmentManager.dispatchStop();
    }

    @java.lang.Deprecated
    public void doLoaderDestroy() {
    }

    @java.lang.Deprecated
    public void doLoaderRetain() {
    }

    @java.lang.Deprecated
    public void doLoaderStart() {
    }

    @java.lang.Deprecated
    public void doLoaderStop(boolean z) {
    }

    @java.lang.Deprecated
    public void dumpLoaders(@androidx.annotation.NonNull java.lang.String str, @androidx.annotation.Nullable java.io.FileDescriptor fileDescriptor, @androidx.annotation.NonNull java.io.PrintWriter printWriter, @androidx.annotation.Nullable java.lang.String[] strArr) {
    }

    public boolean execPendingActions() {
        return this.mHost.mFragmentManager.execPendingActions(true);
    }

    @androidx.annotation.Nullable
    public androidx.fragment.app.Fragment findFragmentByWho(@androidx.annotation.NonNull java.lang.String str) {
        return this.mHost.mFragmentManager.findFragmentByWho(str);
    }

    @androidx.annotation.NonNull
    public java.util.List<androidx.fragment.app.Fragment> getActiveFragments(@android.annotation.SuppressLint({"UnknownNullness"}) java.util.List<androidx.fragment.app.Fragment> list) {
        return this.mHost.mFragmentManager.getActiveFragments();
    }

    public int getActiveFragmentsCount() {
        return this.mHost.mFragmentManager.getActiveFragmentCount();
    }

    @androidx.annotation.NonNull
    public androidx.fragment.app.FragmentManager getSupportFragmentManager() {
        return this.mHost.mFragmentManager;
    }

    @android.annotation.SuppressLint({"UnknownNullness"})
    @java.lang.Deprecated
    public androidx.loader.app.LoaderManager getSupportLoaderManager() {
        throw new java.lang.UnsupportedOperationException("Loaders are managed separately from FragmentController, use LoaderManager.getInstance() to obtain a LoaderManager.");
    }

    public void noteStateNotSaved() {
        this.mHost.mFragmentManager.noteStateNotSaved();
    }

    @androidx.annotation.Nullable
    public android.view.View onCreateView(@androidx.annotation.Nullable android.view.View view, @androidx.annotation.NonNull java.lang.String str, @androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull android.util.AttributeSet attributeSet) {
        return this.mHost.mFragmentManager.getLayoutInflaterFactory().onCreateView(view, str, context, attributeSet);
    }

    @java.lang.Deprecated
    public void reportLoaderStart() {
    }

    @java.lang.Deprecated
    public void restoreAllState(@androidx.annotation.Nullable android.os.Parcelable parcelable, @androidx.annotation.Nullable androidx.fragment.app.FragmentManagerNonConfig fragmentManagerNonConfig) {
        this.mHost.mFragmentManager.restoreAllState(parcelable, fragmentManagerNonConfig);
    }

    @java.lang.Deprecated
    public void restoreAllState(@androidx.annotation.Nullable android.os.Parcelable parcelable, @androidx.annotation.Nullable java.util.List<androidx.fragment.app.Fragment> list) {
        this.mHost.mFragmentManager.restoreAllState(parcelable, new androidx.fragment.app.FragmentManagerNonConfig(list, null, null));
    }

    @java.lang.Deprecated
    public void restoreLoaderNonConfig(@android.annotation.SuppressLint({"UnknownNullness"}) androidx.collection.SimpleArrayMap<java.lang.String, androidx.loader.app.LoaderManager> simpleArrayMap) {
    }

    public void restoreSaveState(@androidx.annotation.Nullable android.os.Parcelable parcelable) {
        androidx.fragment.app.FragmentHostCallback<?> fragmentHostCallback = this.mHost;
        if (!(fragmentHostCallback instanceof androidx.lifecycle.ViewModelStoreOwner)) {
            throw new java.lang.IllegalStateException("Your FragmentHostCallback must implement ViewModelStoreOwner to call restoreSaveState(). Call restoreAllState()  if you're still using retainNestedNonConfig().");
        }
        fragmentHostCallback.mFragmentManager.restoreSaveState(parcelable);
    }

    @androidx.annotation.Nullable
    @java.lang.Deprecated
    public androidx.collection.SimpleArrayMap<java.lang.String, androidx.loader.app.LoaderManager> retainLoaderNonConfig() {
        return null;
    }

    @androidx.annotation.Nullable
    @java.lang.Deprecated
    public androidx.fragment.app.FragmentManagerNonConfig retainNestedNonConfig() {
        return this.mHost.mFragmentManager.retainNonConfig();
    }

    @androidx.annotation.Nullable
    @java.lang.Deprecated
    public java.util.List<androidx.fragment.app.Fragment> retainNonConfig() {
        androidx.fragment.app.FragmentManagerNonConfig retainNonConfig = this.mHost.mFragmentManager.retainNonConfig();
        if (retainNonConfig == null || retainNonConfig.getFragments() == null) {
            return null;
        }
        return new java.util.ArrayList(retainNonConfig.getFragments());
    }

    @androidx.annotation.Nullable
    public android.os.Parcelable saveAllState() {
        return this.mHost.mFragmentManager.saveAllState();
    }
}
