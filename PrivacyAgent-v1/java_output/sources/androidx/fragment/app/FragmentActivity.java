package androidx.fragment.app;

/* loaded from: classes.dex */
public class FragmentActivity extends androidx.activity.ComponentActivity implements androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback, androidx.core.app.ActivityCompat.RequestPermissionsRequestCodeValidator {
    static final java.lang.String FRAGMENTS_TAG = "android:support:fragments";
    boolean mCreated;
    final androidx.lifecycle.LifecycleRegistry mFragmentLifecycleRegistry;
    final androidx.fragment.app.FragmentController mFragments;
    boolean mResumed;
    boolean mStopped;

    /* renamed from: androidx.fragment.app.FragmentActivity$1, reason: invalid class name */
    public class AnonymousClass1 implements androidx.savedstate.SavedStateRegistry.SavedStateProvider {
        public AnonymousClass1() {
        }

        @Override // androidx.savedstate.SavedStateRegistry.SavedStateProvider
        @androidx.annotation.NonNull
        public android.os.Bundle saveState() {
            android.os.Bundle bundle = new android.os.Bundle();
            androidx.fragment.app.FragmentActivity.this.markFragmentsCreated();
            androidx.fragment.app.FragmentActivity.this.mFragmentLifecycleRegistry.handleLifecycleEvent(androidx.lifecycle.Lifecycle.Event.ON_STOP);
            android.os.Parcelable saveAllState = androidx.fragment.app.FragmentActivity.this.mFragments.saveAllState();
            if (saveAllState != null) {
                bundle.putParcelable(androidx.fragment.app.FragmentActivity.FRAGMENTS_TAG, saveAllState);
            }
            return bundle;
        }
    }

    /* renamed from: androidx.fragment.app.FragmentActivity$2, reason: invalid class name */
    public class AnonymousClass2 implements androidx.activity.contextaware.OnContextAvailableListener {
        public AnonymousClass2() {
        }

        @Override // androidx.activity.contextaware.OnContextAvailableListener
        public void onContextAvailable(@androidx.annotation.NonNull android.content.Context context) {
            androidx.fragment.app.FragmentActivity.this.mFragments.attachHost(null);
            android.os.Bundle consumeRestoredStateForKey = androidx.fragment.app.FragmentActivity.this.getSavedStateRegistry().consumeRestoredStateForKey(androidx.fragment.app.FragmentActivity.FRAGMENTS_TAG);
            if (consumeRestoredStateForKey != null) {
                androidx.fragment.app.FragmentActivity.this.mFragments.restoreSaveState(consumeRestoredStateForKey.getParcelable(androidx.fragment.app.FragmentActivity.FRAGMENTS_TAG));
            }
        }
    }

    public class HostCallbacks extends androidx.fragment.app.FragmentHostCallback<androidx.fragment.app.FragmentActivity> implements androidx.lifecycle.ViewModelStoreOwner, androidx.activity.OnBackPressedDispatcherOwner, androidx.activity.result.ActivityResultRegistryOwner, androidx.fragment.app.FragmentOnAttachListener {
        public HostCallbacks() {
            super(androidx.fragment.app.FragmentActivity.this);
        }

        @Override // androidx.activity.result.ActivityResultRegistryOwner
        @androidx.annotation.NonNull
        public androidx.activity.result.ActivityResultRegistry getActivityResultRegistry() {
            return androidx.fragment.app.FragmentActivity.this.getActivityResultRegistry();
        }

        @Override // androidx.lifecycle.LifecycleOwner
        @androidx.annotation.NonNull
        public androidx.lifecycle.Lifecycle getLifecycle() {
            return androidx.fragment.app.FragmentActivity.this.mFragmentLifecycleRegistry;
        }

        @Override // androidx.activity.OnBackPressedDispatcherOwner
        @androidx.annotation.NonNull
        public androidx.activity.OnBackPressedDispatcher getOnBackPressedDispatcher() {
            return androidx.fragment.app.FragmentActivity.this.getOnBackPressedDispatcher();
        }

        @Override // androidx.lifecycle.ViewModelStoreOwner
        @androidx.annotation.NonNull
        public androidx.lifecycle.ViewModelStore getViewModelStore() {
            return androidx.fragment.app.FragmentActivity.this.getViewModelStore();
        }

        @Override // androidx.fragment.app.FragmentOnAttachListener
        public void onAttachFragment(@androidx.annotation.NonNull androidx.fragment.app.FragmentManager fragmentManager, @androidx.annotation.NonNull androidx.fragment.app.Fragment fragment) {
            androidx.fragment.app.FragmentActivity.this.onAttachFragment(fragment);
        }

        @Override // androidx.fragment.app.FragmentHostCallback
        public void onDump(@androidx.annotation.NonNull java.lang.String str, @androidx.annotation.Nullable java.io.FileDescriptor fileDescriptor, @androidx.annotation.NonNull java.io.PrintWriter printWriter, @androidx.annotation.Nullable java.lang.String[] strArr) {
            androidx.fragment.app.FragmentActivity.this.dump(str, fileDescriptor, printWriter, strArr);
        }

        @Override // androidx.fragment.app.FragmentHostCallback, androidx.fragment.app.FragmentContainer
        @androidx.annotation.Nullable
        public android.view.View onFindViewById(int i) {
            return androidx.fragment.app.FragmentActivity.this.findViewById(i);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.fragment.app.FragmentHostCallback
        public androidx.fragment.app.FragmentActivity onGetHost() {
            return androidx.fragment.app.FragmentActivity.this;
        }

        @Override // androidx.fragment.app.FragmentHostCallback
        @androidx.annotation.NonNull
        public android.view.LayoutInflater onGetLayoutInflater() {
            return androidx.fragment.app.FragmentActivity.this.getLayoutInflater().cloneInContext(androidx.fragment.app.FragmentActivity.this);
        }

        @Override // androidx.fragment.app.FragmentHostCallback
        public int onGetWindowAnimations() {
            android.view.Window window = androidx.fragment.app.FragmentActivity.this.getWindow();
            if (window == null) {
                return 0;
            }
            return window.getAttributes().windowAnimations;
        }

        @Override // androidx.fragment.app.FragmentHostCallback, androidx.fragment.app.FragmentContainer
        public boolean onHasView() {
            android.view.Window window = androidx.fragment.app.FragmentActivity.this.getWindow();
            return (window == null || window.peekDecorView() == null) ? false : true;
        }

        @Override // androidx.fragment.app.FragmentHostCallback
        public boolean onHasWindowAnimations() {
            return androidx.fragment.app.FragmentActivity.this.getWindow() != null;
        }

        @Override // androidx.fragment.app.FragmentHostCallback
        public boolean onShouldSaveFragmentState(@androidx.annotation.NonNull androidx.fragment.app.Fragment fragment) {
            return !androidx.fragment.app.FragmentActivity.this.isFinishing();
        }

        @Override // androidx.fragment.app.FragmentHostCallback
        public boolean onShouldShowRequestPermissionRationale(@androidx.annotation.NonNull java.lang.String str) {
            return androidx.core.app.ActivityCompat.shouldShowRequestPermissionRationale(androidx.fragment.app.FragmentActivity.this, str);
        }

        @Override // androidx.fragment.app.FragmentHostCallback
        public void onSupportInvalidateOptionsMenu() {
            androidx.fragment.app.FragmentActivity.this.supportInvalidateOptionsMenu();
        }
    }

    public FragmentActivity() {
        this.mFragments = androidx.fragment.app.FragmentController.createController(new androidx.fragment.app.FragmentActivity.HostCallbacks());
        this.mFragmentLifecycleRegistry = new androidx.lifecycle.LifecycleRegistry(this);
        this.mStopped = true;
        init();
    }

    @androidx.annotation.ContentView
    public FragmentActivity(@androidx.annotation.LayoutRes int i) {
        super(i);
        this.mFragments = androidx.fragment.app.FragmentController.createController(new androidx.fragment.app.FragmentActivity.HostCallbacks());
        this.mFragmentLifecycleRegistry = new androidx.lifecycle.LifecycleRegistry(this);
        this.mStopped = true;
        init();
    }

    private void init() {
        getSavedStateRegistry().registerSavedStateProvider(FRAGMENTS_TAG, new androidx.fragment.app.FragmentActivity.AnonymousClass1());
        addOnContextAvailableListener(new androidx.fragment.app.FragmentActivity.AnonymousClass2());
    }

    private static boolean markState(androidx.fragment.app.FragmentManager fragmentManager, androidx.lifecycle.Lifecycle.State state) {
        boolean z = false;
        for (androidx.fragment.app.Fragment fragment : fragmentManager.getFragments()) {
            if (fragment != null) {
                if (fragment.getHost() != null) {
                    z |= markState(fragment.getChildFragmentManager(), state);
                }
                androidx.fragment.app.FragmentViewLifecycleOwner fragmentViewLifecycleOwner = fragment.mViewLifecycleOwner;
                if (fragmentViewLifecycleOwner != null && fragmentViewLifecycleOwner.getLifecycle().getCurrentState().isAtLeast(androidx.lifecycle.Lifecycle.State.STARTED)) {
                    fragment.mViewLifecycleOwner.setCurrentState(state);
                    z = true;
                }
                if (fragment.mLifecycleRegistry.getCurrentState().isAtLeast(androidx.lifecycle.Lifecycle.State.STARTED)) {
                    fragment.mLifecycleRegistry.setCurrentState(state);
                    z = true;
                }
            }
        }
        return z;
    }

    @androidx.annotation.Nullable
    public final android.view.View dispatchFragmentsOnCreateView(@androidx.annotation.Nullable android.view.View view, @androidx.annotation.NonNull java.lang.String str, @androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull android.util.AttributeSet attributeSet) {
        return this.mFragments.onCreateView(view, str, context, attributeSet);
    }

    @Override // android.app.Activity
    public void dump(@androidx.annotation.NonNull java.lang.String str, @androidx.annotation.Nullable java.io.FileDescriptor fileDescriptor, @androidx.annotation.NonNull java.io.PrintWriter printWriter, @androidx.annotation.Nullable java.lang.String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        printWriter.print(str);
        printWriter.print("Local FragmentActivity ");
        printWriter.print(java.lang.Integer.toHexString(java.lang.System.identityHashCode(this)));
        printWriter.println(" State:");
        java.lang.String str2 = str + "  ";
        printWriter.print(str2);
        printWriter.print("mCreated=");
        printWriter.print(this.mCreated);
        printWriter.print(" mResumed=");
        printWriter.print(this.mResumed);
        printWriter.print(" mStopped=");
        printWriter.print(this.mStopped);
        if (getApplication() != null) {
            androidx.loader.app.LoaderManager.getInstance(this).dump(str2, fileDescriptor, printWriter, strArr);
        }
        this.mFragments.getSupportFragmentManager().dump(str, fileDescriptor, printWriter, strArr);
    }

    @androidx.annotation.NonNull
    public androidx.fragment.app.FragmentManager getSupportFragmentManager() {
        return this.mFragments.getSupportFragmentManager();
    }

    @androidx.annotation.NonNull
    @java.lang.Deprecated
    public androidx.loader.app.LoaderManager getSupportLoaderManager() {
        return androidx.loader.app.LoaderManager.getInstance(this);
    }

    public void markFragmentsCreated() {
        while (markState(getSupportFragmentManager(), androidx.lifecycle.Lifecycle.State.CREATED)) {
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    @androidx.annotation.CallSuper
    public void onActivityResult(int i, int i2, @androidx.annotation.Nullable android.content.Intent intent) {
        this.mFragments.noteStateNotSaved();
        super.onActivityResult(i, i2, intent);
    }

    @androidx.annotation.MainThread
    @java.lang.Deprecated
    public void onAttachFragment(@androidx.annotation.NonNull androidx.fragment.app.Fragment fragment) {
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(@androidx.annotation.NonNull android.content.res.Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.mFragments.noteStateNotSaved();
        this.mFragments.dispatchConfigurationChanged(configuration);
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@androidx.annotation.Nullable android.os.Bundle bundle) {
        super.onCreate(bundle);
        this.mFragmentLifecycleRegistry.handleLifecycleEvent(androidx.lifecycle.Lifecycle.Event.ON_CREATE);
        this.mFragments.dispatchCreate();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onCreatePanelMenu(int i, @androidx.annotation.NonNull android.view.Menu menu) {
        return i == 0 ? super.onCreatePanelMenu(i, menu) | this.mFragments.dispatchCreateOptionsMenu(menu, getMenuInflater()) : super.onCreatePanelMenu(i, menu);
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory2
    @androidx.annotation.Nullable
    public android.view.View onCreateView(@androidx.annotation.Nullable android.view.View view, @androidx.annotation.NonNull java.lang.String str, @androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull android.util.AttributeSet attributeSet) {
        android.view.View dispatchFragmentsOnCreateView = dispatchFragmentsOnCreateView(view, str, context, attributeSet);
        return dispatchFragmentsOnCreateView == null ? super.onCreateView(view, str, context, attributeSet) : dispatchFragmentsOnCreateView;
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory
    @androidx.annotation.Nullable
    public android.view.View onCreateView(@androidx.annotation.NonNull java.lang.String str, @androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull android.util.AttributeSet attributeSet) {
        android.view.View dispatchFragmentsOnCreateView = dispatchFragmentsOnCreateView(null, str, context, attributeSet);
        return dispatchFragmentsOnCreateView == null ? super.onCreateView(str, context, attributeSet) : dispatchFragmentsOnCreateView;
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.mFragments.dispatchDestroy();
        this.mFragmentLifecycleRegistry.handleLifecycleEvent(androidx.lifecycle.Lifecycle.Event.ON_DESTROY);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        this.mFragments.dispatchLowMemory();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i, @androidx.annotation.NonNull android.view.MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        if (i == 0) {
            return this.mFragments.dispatchOptionsItemSelected(menuItem);
        }
        if (i != 6) {
            return false;
        }
        return this.mFragments.dispatchContextItemSelected(menuItem);
    }

    @Override // android.app.Activity
    @androidx.annotation.CallSuper
    public void onMultiWindowModeChanged(boolean z) {
        this.mFragments.dispatchMultiWindowModeChanged(z);
    }

    @Override // androidx.core.app.ComponentActivity, android.app.Activity
    @androidx.annotation.CallSuper
    public void onNewIntent(@android.annotation.SuppressLint({"UnknownNullness"}) android.content.Intent intent) {
        super.onNewIntent(intent);
        this.mFragments.noteStateNotSaved();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i, @androidx.annotation.NonNull android.view.Menu menu) {
        if (i == 0) {
            this.mFragments.dispatchOptionsMenuClosed(menu);
        }
        super.onPanelClosed(i, menu);
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        this.mResumed = false;
        this.mFragments.dispatchPause();
        this.mFragmentLifecycleRegistry.handleLifecycleEvent(androidx.lifecycle.Lifecycle.Event.ON_PAUSE);
    }

    @Override // android.app.Activity
    @androidx.annotation.CallSuper
    public void onPictureInPictureModeChanged(boolean z) {
        this.mFragments.dispatchPictureInPictureModeChanged(z);
    }

    @Override // android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        onResumeFragments();
    }

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @java.lang.Deprecated
    public boolean onPrepareOptionsPanel(@androidx.annotation.Nullable android.view.View view, @androidx.annotation.NonNull android.view.Menu menu) {
        return super.onPreparePanel(0, view, menu);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onPreparePanel(int i, @androidx.annotation.Nullable android.view.View view, @androidx.annotation.NonNull android.view.Menu menu) {
        return i == 0 ? onPrepareOptionsPanel(view, menu) | this.mFragments.dispatchPrepareOptionsMenu(menu) : super.onPreparePanel(i, view, menu);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    @androidx.annotation.CallSuper
    public void onRequestPermissionsResult(int i, @androidx.annotation.NonNull java.lang.String[] strArr, @androidx.annotation.NonNull int[] iArr) {
        this.mFragments.noteStateNotSaved();
        super.onRequestPermissionsResult(i, strArr, iArr);
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        this.mResumed = true;
        this.mFragments.noteStateNotSaved();
        this.mFragments.execPendingActions();
    }

    public void onResumeFragments() {
        this.mFragmentLifecycleRegistry.handleLifecycleEvent(androidx.lifecycle.Lifecycle.Event.ON_RESUME);
        this.mFragments.dispatchResume();
    }

    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
        this.mStopped = false;
        if (!this.mCreated) {
            this.mCreated = true;
            this.mFragments.dispatchActivityCreated();
        }
        this.mFragments.noteStateNotSaved();
        this.mFragments.execPendingActions();
        this.mFragmentLifecycleRegistry.handleLifecycleEvent(androidx.lifecycle.Lifecycle.Event.ON_START);
        this.mFragments.dispatchStart();
    }

    @Override // android.app.Activity
    public void onStateNotSaved() {
        this.mFragments.noteStateNotSaved();
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        this.mStopped = true;
        markFragmentsCreated();
        this.mFragments.dispatchStop();
        this.mFragmentLifecycleRegistry.handleLifecycleEvent(androidx.lifecycle.Lifecycle.Event.ON_STOP);
    }

    public void setEnterSharedElementCallback(@androidx.annotation.Nullable androidx.core.app.SharedElementCallback sharedElementCallback) {
        androidx.core.app.ActivityCompat.setEnterSharedElementCallback(this, sharedElementCallback);
    }

    public void setExitSharedElementCallback(@androidx.annotation.Nullable androidx.core.app.SharedElementCallback sharedElementCallback) {
        androidx.core.app.ActivityCompat.setExitSharedElementCallback(this, sharedElementCallback);
    }

    public void startActivityFromFragment(@androidx.annotation.NonNull androidx.fragment.app.Fragment fragment, @android.annotation.SuppressLint({"UnknownNullness"}) android.content.Intent intent, int i) {
        startActivityFromFragment(fragment, intent, i, (android.os.Bundle) null);
    }

    public void startActivityFromFragment(@androidx.annotation.NonNull androidx.fragment.app.Fragment fragment, @android.annotation.SuppressLint({"UnknownNullness"}) android.content.Intent intent, int i, @androidx.annotation.Nullable android.os.Bundle bundle) {
        if (i == -1) {
            androidx.core.app.ActivityCompat.startActivityForResult(this, intent, -1, bundle);
        } else {
            fragment.startActivityForResult(intent, i, bundle);
        }
    }

    @java.lang.Deprecated
    public void startIntentSenderFromFragment(@androidx.annotation.NonNull androidx.fragment.app.Fragment fragment, @android.annotation.SuppressLint({"UnknownNullness"}) android.content.IntentSender intentSender, int i, @androidx.annotation.Nullable android.content.Intent intent, int i2, int i3, int i4, @androidx.annotation.Nullable android.os.Bundle bundle) throws android.content.IntentSender.SendIntentException {
        if (i == -1) {
            androidx.core.app.ActivityCompat.startIntentSenderForResult(this, intentSender, i, intent, i2, i3, i4, bundle);
        } else {
            fragment.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
        }
    }

    public void supportFinishAfterTransition() {
        androidx.core.app.ActivityCompat.finishAfterTransition(this);
    }

    @java.lang.Deprecated
    public void supportInvalidateOptionsMenu() {
        invalidateOptionsMenu();
    }

    public void supportPostponeEnterTransition() {
        androidx.core.app.ActivityCompat.postponeEnterTransition(this);
    }

    public void supportStartPostponedEnterTransition() {
        androidx.core.app.ActivityCompat.startPostponedEnterTransition(this);
    }

    @Override // androidx.core.app.ActivityCompat.RequestPermissionsRequestCodeValidator
    @java.lang.Deprecated
    public final void validateRequestPermissionsRequestCode(int i) {
    }
}
