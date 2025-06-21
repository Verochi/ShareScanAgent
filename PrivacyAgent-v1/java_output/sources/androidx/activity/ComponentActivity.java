package androidx.activity;

/* loaded from: classes.dex */
public class ComponentActivity extends androidx.core.app.ComponentActivity implements androidx.activity.contextaware.ContextAware, androidx.lifecycle.ViewModelStoreOwner, androidx.lifecycle.HasDefaultViewModelProviderFactory, androidx.savedstate.SavedStateRegistryOwner, androidx.activity.OnBackPressedDispatcherOwner, androidx.activity.result.ActivityResultRegistryOwner, androidx.activity.result.ActivityResultCaller {
    private final androidx.activity.result.ActivityResultRegistry mActivityResultRegistry;

    @androidx.annotation.LayoutRes
    private int mContentLayoutId;
    final androidx.activity.contextaware.ContextAwareHelper mContextAwareHelper;
    private androidx.lifecycle.ViewModelProvider.Factory mDefaultFactory;
    private final androidx.lifecycle.LifecycleRegistry mLifecycleRegistry;
    private final java.util.concurrent.atomic.AtomicInteger mNextLocalRequestCode;
    private final androidx.activity.OnBackPressedDispatcher mOnBackPressedDispatcher;
    final androidx.savedstate.SavedStateRegistryController mSavedStateRegistryController;
    private androidx.lifecycle.ViewModelStore mViewModelStore;

    /* renamed from: androidx.activity.ComponentActivity$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                androidx.activity.ComponentActivity.super.onBackPressed();
            } catch (java.lang.IllegalStateException e) {
                if (!android.text.TextUtils.equals(e.getMessage(), "Can not perform this action after onSaveInstanceState")) {
                    throw e;
                }
            }
        }
    }

    /* renamed from: androidx.activity.ComponentActivity$2, reason: invalid class name */
    public class AnonymousClass2 extends androidx.activity.result.ActivityResultRegistry {

        /* renamed from: androidx.activity.ComponentActivity$2$1, reason: invalid class name */
        public class AnonymousClass1 implements java.lang.Runnable {
            final /* synthetic */ int val$requestCode;
            final /* synthetic */ androidx.activity.result.contract.ActivityResultContract.SynchronousResult val$synchronousResult;

            public AnonymousClass1(int i, androidx.activity.result.contract.ActivityResultContract.SynchronousResult synchronousResult) {
                this.val$requestCode = i;
                this.val$synchronousResult = synchronousResult;
            }

            @Override // java.lang.Runnable
            public void run() {
                androidx.activity.ComponentActivity.AnonymousClass2.this.dispatchResult(this.val$requestCode, this.val$synchronousResult.getValue());
            }
        }

        /* renamed from: androidx.activity.ComponentActivity$2$2, reason: invalid class name and collision with other inner class name */
        public class RunnableC00002 implements java.lang.Runnable {
            final /* synthetic */ android.content.IntentSender.SendIntentException val$e;
            final /* synthetic */ int val$requestCode;

            public RunnableC00002(int i, android.content.IntentSender.SendIntentException sendIntentException) {
                this.val$requestCode = i;
                this.val$e = sendIntentException;
            }

            @Override // java.lang.Runnable
            public void run() {
                androidx.activity.ComponentActivity.AnonymousClass2.this.dispatchResult(this.val$requestCode, 0, new android.content.Intent().setAction(androidx.activity.result.contract.ActivityResultContracts.StartIntentSenderForResult.ACTION_INTENT_SENDER_REQUEST).putExtra(androidx.activity.result.contract.ActivityResultContracts.StartIntentSenderForResult.EXTRA_SEND_INTENT_EXCEPTION, this.val$e));
            }
        }

        public AnonymousClass2() {
        }

        @Override // androidx.activity.result.ActivityResultRegistry
        public <I, O> void onLaunch(int i, @androidx.annotation.NonNull androidx.activity.result.contract.ActivityResultContract<I, O> activityResultContract, I i2, @androidx.annotation.Nullable androidx.core.app.ActivityOptionsCompat activityOptionsCompat) {
            android.os.Bundle bundle;
            androidx.activity.ComponentActivity componentActivity = androidx.activity.ComponentActivity.this;
            androidx.activity.result.contract.ActivityResultContract.SynchronousResult<O> synchronousResult = activityResultContract.getSynchronousResult(componentActivity, i2);
            if (synchronousResult != null) {
                new android.os.Handler(android.os.Looper.getMainLooper()).post(new androidx.activity.ComponentActivity.AnonymousClass2.AnonymousClass1(i, synchronousResult));
                return;
            }
            android.content.Intent createIntent = activityResultContract.createIntent(componentActivity, i2);
            if (createIntent.getExtras() != null && createIntent.getExtras().getClassLoader() == null) {
                createIntent.setExtrasClassLoader(componentActivity.getClassLoader());
            }
            if (createIntent.hasExtra(androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult.EXTRA_ACTIVITY_OPTIONS_BUNDLE)) {
                android.os.Bundle bundleExtra = createIntent.getBundleExtra(androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult.EXTRA_ACTIVITY_OPTIONS_BUNDLE);
                createIntent.removeExtra(androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult.EXTRA_ACTIVITY_OPTIONS_BUNDLE);
                bundle = bundleExtra;
            } else {
                bundle = activityOptionsCompat != null ? activityOptionsCompat.toBundle() : null;
            }
            if (androidx.activity.result.contract.ActivityResultContracts.RequestMultiplePermissions.ACTION_REQUEST_PERMISSIONS.equals(createIntent.getAction())) {
                java.lang.String[] stringArrayExtra = createIntent.getStringArrayExtra(androidx.activity.result.contract.ActivityResultContracts.RequestMultiplePermissions.EXTRA_PERMISSIONS);
                if (stringArrayExtra == null) {
                    stringArrayExtra = new java.lang.String[0];
                }
                androidx.core.app.ActivityCompat.requestPermissions(componentActivity, stringArrayExtra, i);
                return;
            }
            if (!androidx.activity.result.contract.ActivityResultContracts.StartIntentSenderForResult.ACTION_INTENT_SENDER_REQUEST.equals(createIntent.getAction())) {
                androidx.core.app.ActivityCompat.startActivityForResult(componentActivity, createIntent, i, bundle);
                return;
            }
            androidx.activity.result.IntentSenderRequest intentSenderRequest = (androidx.activity.result.IntentSenderRequest) createIntent.getParcelableExtra(androidx.activity.result.contract.ActivityResultContracts.StartIntentSenderForResult.EXTRA_INTENT_SENDER_REQUEST);
            try {
                androidx.core.app.ActivityCompat.startIntentSenderForResult(componentActivity, intentSenderRequest.getIntentSender(), i, intentSenderRequest.getFillInIntent(), intentSenderRequest.getFlagsMask(), intentSenderRequest.getFlagsValues(), 0, bundle);
            } catch (android.content.IntentSender.SendIntentException e) {
                new android.os.Handler(android.os.Looper.getMainLooper()).post(new androidx.activity.ComponentActivity.AnonymousClass2.RunnableC00002(i, e));
            }
        }
    }

    /* renamed from: androidx.activity.ComponentActivity$3, reason: invalid class name */
    public class AnonymousClass3 implements androidx.lifecycle.LifecycleEventObserver {
        public AnonymousClass3() {
        }

        @Override // androidx.lifecycle.LifecycleEventObserver
        public void onStateChanged(@androidx.annotation.NonNull androidx.lifecycle.LifecycleOwner lifecycleOwner, @androidx.annotation.NonNull androidx.lifecycle.Lifecycle.Event event) {
            if (event == androidx.lifecycle.Lifecycle.Event.ON_STOP) {
                android.view.Window window = androidx.activity.ComponentActivity.this.getWindow();
                android.view.View peekDecorView = window != null ? window.peekDecorView() : null;
                if (peekDecorView != null) {
                    peekDecorView.cancelPendingInputEvents();
                }
            }
        }
    }

    /* renamed from: androidx.activity.ComponentActivity$4, reason: invalid class name */
    public class AnonymousClass4 implements androidx.lifecycle.LifecycleEventObserver {
        public AnonymousClass4() {
        }

        @Override // androidx.lifecycle.LifecycleEventObserver
        public void onStateChanged(@androidx.annotation.NonNull androidx.lifecycle.LifecycleOwner lifecycleOwner, @androidx.annotation.NonNull androidx.lifecycle.Lifecycle.Event event) {
            if (event == androidx.lifecycle.Lifecycle.Event.ON_DESTROY) {
                androidx.activity.ComponentActivity.this.mContextAwareHelper.clearAvailableContext();
                if (androidx.activity.ComponentActivity.this.isChangingConfigurations()) {
                    return;
                }
                androidx.activity.ComponentActivity.this.getViewModelStore().clear();
            }
        }
    }

    /* renamed from: androidx.activity.ComponentActivity$5, reason: invalid class name */
    public class AnonymousClass5 implements androidx.lifecycle.LifecycleEventObserver {
        public AnonymousClass5() {
        }

        @Override // androidx.lifecycle.LifecycleEventObserver
        public void onStateChanged(@androidx.annotation.NonNull androidx.lifecycle.LifecycleOwner lifecycleOwner, @androidx.annotation.NonNull androidx.lifecycle.Lifecycle.Event event) {
            androidx.activity.ComponentActivity.this.ensureViewModelStore();
            androidx.activity.ComponentActivity.this.getLifecycle().removeObserver(this);
        }
    }

    public static final class NonConfigurationInstances {
        java.lang.Object custom;
        androidx.lifecycle.ViewModelStore viewModelStore;
    }

    public ComponentActivity() {
        this.mContextAwareHelper = new androidx.activity.contextaware.ContextAwareHelper();
        this.mLifecycleRegistry = new androidx.lifecycle.LifecycleRegistry(this);
        this.mSavedStateRegistryController = androidx.savedstate.SavedStateRegistryController.create(this);
        this.mOnBackPressedDispatcher = new androidx.activity.OnBackPressedDispatcher(new androidx.activity.ComponentActivity.AnonymousClass1());
        this.mNextLocalRequestCode = new java.util.concurrent.atomic.AtomicInteger();
        this.mActivityResultRegistry = new androidx.activity.ComponentActivity.AnonymousClass2();
        if (getLifecycle() == null) {
            throw new java.lang.IllegalStateException("getLifecycle() returned null in ComponentActivity's constructor. Please make sure you are lazily constructing your Lifecycle in the first call to getLifecycle() rather than relying on field initialization.");
        }
        int i = android.os.Build.VERSION.SDK_INT;
        getLifecycle().addObserver(new androidx.activity.ComponentActivity.AnonymousClass3());
        getLifecycle().addObserver(new androidx.activity.ComponentActivity.AnonymousClass4());
        getLifecycle().addObserver(new androidx.activity.ComponentActivity.AnonymousClass5());
        if (i <= 23) {
            getLifecycle().addObserver(new androidx.activity.ImmLeaksCleaner(this));
        }
    }

    @androidx.annotation.ContentView
    public ComponentActivity(@androidx.annotation.LayoutRes int i) {
        this();
        this.mContentLayoutId = i;
    }

    private void initViewTreeOwners() {
        androidx.lifecycle.ViewTreeLifecycleOwner.set(getWindow().getDecorView(), this);
        androidx.lifecycle.ViewTreeViewModelStoreOwner.set(getWindow().getDecorView(), this);
        androidx.savedstate.ViewTreeSavedStateRegistryOwner.set(getWindow().getDecorView(), this);
    }

    @Override // android.app.Activity
    public void addContentView(@android.annotation.SuppressLint({"UnknownNullness", "MissingNullability"}) android.view.View view, @android.annotation.SuppressLint({"UnknownNullness", "MissingNullability"}) android.view.ViewGroup.LayoutParams layoutParams) {
        initViewTreeOwners();
        super.addContentView(view, layoutParams);
    }

    @Override // androidx.activity.contextaware.ContextAware
    public final void addOnContextAvailableListener(@androidx.annotation.NonNull androidx.activity.contextaware.OnContextAvailableListener onContextAvailableListener) {
        this.mContextAwareHelper.addOnContextAvailableListener(onContextAvailableListener);
    }

    public void ensureViewModelStore() {
        if (this.mViewModelStore == null) {
            androidx.activity.ComponentActivity.NonConfigurationInstances nonConfigurationInstances = (androidx.activity.ComponentActivity.NonConfigurationInstances) getLastNonConfigurationInstance();
            if (nonConfigurationInstances != null) {
                this.mViewModelStore = nonConfigurationInstances.viewModelStore;
            }
            if (this.mViewModelStore == null) {
                this.mViewModelStore = new androidx.lifecycle.ViewModelStore();
            }
        }
    }

    @Override // androidx.activity.result.ActivityResultRegistryOwner
    @androidx.annotation.NonNull
    public final androidx.activity.result.ActivityResultRegistry getActivityResultRegistry() {
        return this.mActivityResultRegistry;
    }

    @Override // androidx.lifecycle.HasDefaultViewModelProviderFactory
    @androidx.annotation.NonNull
    public androidx.lifecycle.ViewModelProvider.Factory getDefaultViewModelProviderFactory() {
        if (getApplication() == null) {
            throw new java.lang.IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
        }
        if (this.mDefaultFactory == null) {
            this.mDefaultFactory = new androidx.lifecycle.SavedStateViewModelFactory(getApplication(), this, getIntent() != null ? getIntent().getExtras() : null);
        }
        return this.mDefaultFactory;
    }

    @androidx.annotation.Nullable
    @java.lang.Deprecated
    public java.lang.Object getLastCustomNonConfigurationInstance() {
        androidx.activity.ComponentActivity.NonConfigurationInstances nonConfigurationInstances = (androidx.activity.ComponentActivity.NonConfigurationInstances) getLastNonConfigurationInstance();
        if (nonConfigurationInstances != null) {
            return nonConfigurationInstances.custom;
        }
        return null;
    }

    @Override // androidx.core.app.ComponentActivity, androidx.lifecycle.LifecycleOwner
    @androidx.annotation.NonNull
    public androidx.lifecycle.Lifecycle getLifecycle() {
        return this.mLifecycleRegistry;
    }

    @Override // androidx.activity.OnBackPressedDispatcherOwner
    @androidx.annotation.NonNull
    public final androidx.activity.OnBackPressedDispatcher getOnBackPressedDispatcher() {
        return this.mOnBackPressedDispatcher;
    }

    @Override // androidx.savedstate.SavedStateRegistryOwner
    @androidx.annotation.NonNull
    public final androidx.savedstate.SavedStateRegistry getSavedStateRegistry() {
        return this.mSavedStateRegistryController.getSavedStateRegistry();
    }

    @Override // androidx.lifecycle.ViewModelStoreOwner
    @androidx.annotation.NonNull
    public androidx.lifecycle.ViewModelStore getViewModelStore() {
        if (getApplication() == null) {
            throw new java.lang.IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
        }
        ensureViewModelStore();
        return this.mViewModelStore;
    }

    @Override // android.app.Activity
    @androidx.annotation.CallSuper
    @java.lang.Deprecated
    public void onActivityResult(int i, int i2, @androidx.annotation.Nullable android.content.Intent intent) {
        if (this.mActivityResultRegistry.dispatchResult(i, i2, intent)) {
            return;
        }
        super.onActivityResult(i, i2, intent);
    }

    @Override // android.app.Activity
    @androidx.annotation.MainThread
    public void onBackPressed() {
        this.mOnBackPressedDispatcher.onBackPressed();
    }

    @Override // androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@androidx.annotation.Nullable android.os.Bundle bundle) {
        this.mSavedStateRegistryController.performRestore(bundle);
        this.mContextAwareHelper.dispatchOnContextAvailable(this);
        super.onCreate(bundle);
        this.mActivityResultRegistry.onRestoreInstanceState(bundle);
        androidx.lifecycle.ReportFragment.injectIfNeededIn(this);
        int i = this.mContentLayoutId;
        if (i != 0) {
            setContentView(i);
        }
    }

    @Override // android.app.Activity
    @androidx.annotation.CallSuper
    @java.lang.Deprecated
    public void onRequestPermissionsResult(int i, @androidx.annotation.NonNull java.lang.String[] strArr, @androidx.annotation.NonNull int[] iArr) {
        if (this.mActivityResultRegistry.dispatchResult(i, -1, new android.content.Intent().putExtra(androidx.activity.result.contract.ActivityResultContracts.RequestMultiplePermissions.EXTRA_PERMISSIONS, strArr).putExtra(androidx.activity.result.contract.ActivityResultContracts.RequestMultiplePermissions.EXTRA_PERMISSION_GRANT_RESULTS, iArr)) || android.os.Build.VERSION.SDK_INT < 23) {
            return;
        }
        super.onRequestPermissionsResult(i, strArr, iArr);
    }

    @androidx.annotation.Nullable
    @java.lang.Deprecated
    public java.lang.Object onRetainCustomNonConfigurationInstance() {
        return null;
    }

    @Override // android.app.Activity
    @androidx.annotation.Nullable
    public final java.lang.Object onRetainNonConfigurationInstance() {
        androidx.activity.ComponentActivity.NonConfigurationInstances nonConfigurationInstances;
        java.lang.Object onRetainCustomNonConfigurationInstance = onRetainCustomNonConfigurationInstance();
        androidx.lifecycle.ViewModelStore viewModelStore = this.mViewModelStore;
        if (viewModelStore == null && (nonConfigurationInstances = (androidx.activity.ComponentActivity.NonConfigurationInstances) getLastNonConfigurationInstance()) != null) {
            viewModelStore = nonConfigurationInstances.viewModelStore;
        }
        if (viewModelStore == null && onRetainCustomNonConfigurationInstance == null) {
            return null;
        }
        androidx.activity.ComponentActivity.NonConfigurationInstances nonConfigurationInstances2 = new androidx.activity.ComponentActivity.NonConfigurationInstances();
        nonConfigurationInstances2.custom = onRetainCustomNonConfigurationInstance;
        nonConfigurationInstances2.viewModelStore = viewModelStore;
        return nonConfigurationInstances2;
    }

    @Override // androidx.core.app.ComponentActivity, android.app.Activity
    @androidx.annotation.CallSuper
    public void onSaveInstanceState(@androidx.annotation.NonNull android.os.Bundle bundle) {
        androidx.lifecycle.Lifecycle lifecycle = getLifecycle();
        if (lifecycle instanceof androidx.lifecycle.LifecycleRegistry) {
            ((androidx.lifecycle.LifecycleRegistry) lifecycle).setCurrentState(androidx.lifecycle.Lifecycle.State.CREATED);
        }
        super.onSaveInstanceState(bundle);
        this.mSavedStateRegistryController.performSave(bundle);
        this.mActivityResultRegistry.onSaveInstanceState(bundle);
    }

    @Override // androidx.activity.contextaware.ContextAware
    @androidx.annotation.Nullable
    public android.content.Context peekAvailableContext() {
        return this.mContextAwareHelper.peekAvailableContext();
    }

    @Override // androidx.activity.result.ActivityResultCaller
    @androidx.annotation.NonNull
    public final <I, O> androidx.activity.result.ActivityResultLauncher<I> registerForActivityResult(@androidx.annotation.NonNull androidx.activity.result.contract.ActivityResultContract<I, O> activityResultContract, @androidx.annotation.NonNull androidx.activity.result.ActivityResultCallback<O> activityResultCallback) {
        return registerForActivityResult(activityResultContract, this.mActivityResultRegistry, activityResultCallback);
    }

    @Override // androidx.activity.result.ActivityResultCaller
    @androidx.annotation.NonNull
    public final <I, O> androidx.activity.result.ActivityResultLauncher<I> registerForActivityResult(@androidx.annotation.NonNull androidx.activity.result.contract.ActivityResultContract<I, O> activityResultContract, @androidx.annotation.NonNull androidx.activity.result.ActivityResultRegistry activityResultRegistry, @androidx.annotation.NonNull androidx.activity.result.ActivityResultCallback<O> activityResultCallback) {
        return activityResultRegistry.register("activity_rq#" + this.mNextLocalRequestCode.getAndIncrement(), this, activityResultContract, activityResultCallback);
    }

    @Override // androidx.activity.contextaware.ContextAware
    public final void removeOnContextAvailableListener(@androidx.annotation.NonNull androidx.activity.contextaware.OnContextAvailableListener onContextAvailableListener) {
        this.mContextAwareHelper.removeOnContextAvailableListener(onContextAvailableListener);
    }

    @Override // android.app.Activity
    public void reportFullyDrawn() {
        try {
            if (androidx.tracing.Trace.isEnabled()) {
                androidx.tracing.Trace.beginSection("reportFullyDrawn() for " + getComponentName());
            }
            super.reportFullyDrawn();
        } finally {
            androidx.tracing.Trace.endSection();
        }
    }

    @Override // android.app.Activity
    public void setContentView(@androidx.annotation.LayoutRes int i) {
        initViewTreeOwners();
        super.setContentView(i);
    }

    @Override // android.app.Activity
    public void setContentView(@android.annotation.SuppressLint({"UnknownNullness", "MissingNullability"}) android.view.View view) {
        initViewTreeOwners();
        super.setContentView(view);
    }

    @Override // android.app.Activity
    public void setContentView(@android.annotation.SuppressLint({"UnknownNullness", "MissingNullability"}) android.view.View view, @android.annotation.SuppressLint({"UnknownNullness", "MissingNullability"}) android.view.ViewGroup.LayoutParams layoutParams) {
        initViewTreeOwners();
        super.setContentView(view, layoutParams);
    }

    @Override // android.app.Activity
    @java.lang.Deprecated
    public void startActivityForResult(@android.annotation.SuppressLint({"UnknownNullness"}) android.content.Intent intent, int i) {
        super.startActivityForResult(intent, i);
    }

    @Override // android.app.Activity
    @java.lang.Deprecated
    public void startActivityForResult(@android.annotation.SuppressLint({"UnknownNullness"}) android.content.Intent intent, int i, @androidx.annotation.Nullable android.os.Bundle bundle) {
        super.startActivityForResult(intent, i, bundle);
    }

    @Override // android.app.Activity
    @java.lang.Deprecated
    public void startIntentSenderForResult(@android.annotation.SuppressLint({"UnknownNullness"}) android.content.IntentSender intentSender, int i, @androidx.annotation.Nullable android.content.Intent intent, int i2, int i3, int i4) throws android.content.IntentSender.SendIntentException {
        super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4);
    }

    @Override // android.app.Activity
    @java.lang.Deprecated
    public void startIntentSenderForResult(@android.annotation.SuppressLint({"UnknownNullness"}) android.content.IntentSender intentSender, int i, @androidx.annotation.Nullable android.content.Intent intent, int i2, int i3, int i4, @androidx.annotation.Nullable android.os.Bundle bundle) throws android.content.IntentSender.SendIntentException {
        super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
    }
}
