package androidx.appcompat.app;

/* loaded from: classes.dex */
public class AppCompatActivity extends androidx.fragment.app.FragmentActivity implements androidx.appcompat.app.AppCompatCallback, androidx.core.app.TaskStackBuilder.SupportParentable, androidx.appcompat.app.ActionBarDrawerToggle.DelegateProvider {
    private static final java.lang.String DELEGATE_TAG = "androidx:appcompat";
    private androidx.appcompat.app.AppCompatDelegate mDelegate;
    private android.content.res.Resources mResources;

    /* renamed from: androidx.appcompat.app.AppCompatActivity$1, reason: invalid class name */
    public class AnonymousClass1 implements androidx.savedstate.SavedStateRegistry.SavedStateProvider {
        public AnonymousClass1() {
        }

        @Override // androidx.savedstate.SavedStateRegistry.SavedStateProvider
        @androidx.annotation.NonNull
        public android.os.Bundle saveState() {
            android.os.Bundle bundle = new android.os.Bundle();
            androidx.appcompat.app.AppCompatActivity.this.getDelegate().onSaveInstanceState(bundle);
            return bundle;
        }
    }

    /* renamed from: androidx.appcompat.app.AppCompatActivity$2, reason: invalid class name */
    public class AnonymousClass2 implements androidx.activity.contextaware.OnContextAvailableListener {
        public AnonymousClass2() {
        }

        @Override // androidx.activity.contextaware.OnContextAvailableListener
        public void onContextAvailable(@androidx.annotation.NonNull android.content.Context context) {
            androidx.appcompat.app.AppCompatDelegate delegate = androidx.appcompat.app.AppCompatActivity.this.getDelegate();
            delegate.installViewFactory();
            delegate.onCreate(androidx.appcompat.app.AppCompatActivity.this.getSavedStateRegistry().consumeRestoredStateForKey(androidx.appcompat.app.AppCompatActivity.DELEGATE_TAG));
        }
    }

    public AppCompatActivity() {
        initDelegate();
    }

    @androidx.annotation.ContentView
    public AppCompatActivity(@androidx.annotation.LayoutRes int i) {
        super(i);
        initDelegate();
    }

    private void initDelegate() {
        getSavedStateRegistry().registerSavedStateProvider(DELEGATE_TAG, new androidx.appcompat.app.AppCompatActivity.AnonymousClass1());
        addOnContextAvailableListener(new androidx.appcompat.app.AppCompatActivity.AnonymousClass2());
    }

    private void initViewTreeOwners() {
        androidx.lifecycle.ViewTreeLifecycleOwner.set(getWindow().getDecorView(), this);
        androidx.lifecycle.ViewTreeViewModelStoreOwner.set(getWindow().getDecorView(), this);
        androidx.savedstate.ViewTreeSavedStateRegistryOwner.set(getWindow().getDecorView(), this);
    }

    private boolean performMenuItemShortcut(android.view.KeyEvent keyEvent) {
        android.view.Window window;
        return (android.os.Build.VERSION.SDK_INT >= 26 || keyEvent.isCtrlPressed() || android.view.KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState()) || keyEvent.getRepeatCount() != 0 || android.view.KeyEvent.isModifierKey(keyEvent.getKeyCode()) || (window = getWindow()) == null || window.getDecorView() == null || !window.getDecorView().dispatchKeyShortcutEvent(keyEvent)) ? false : true;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void addContentView(android.view.View view, android.view.ViewGroup.LayoutParams layoutParams) {
        initViewTreeOwners();
        getDelegate().addContentView(view, layoutParams);
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(android.content.Context context) {
        super.attachBaseContext(getDelegate().attachBaseContext2(context));
    }

    @Override // android.app.Activity
    public void closeOptionsMenu() {
        androidx.appcompat.app.ActionBar supportActionBar = getSupportActionBar();
        if (getWindow().hasFeature(0)) {
            if (supportActionBar == null || !supportActionBar.closeOptionsMenu()) {
                super.closeOptionsMenu();
            }
        }
    }

    @Override // androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(android.view.KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        androidx.appcompat.app.ActionBar supportActionBar = getSupportActionBar();
        if (keyCode == 82 && supportActionBar != null && supportActionBar.onMenuKeyEvent(keyEvent)) {
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Activity
    public <T extends android.view.View> T findViewById(@androidx.annotation.IdRes int i) {
        return (T) getDelegate().findViewById(i);
    }

    @androidx.annotation.NonNull
    public androidx.appcompat.app.AppCompatDelegate getDelegate() {
        if (this.mDelegate == null) {
            this.mDelegate = androidx.appcompat.app.AppCompatDelegate.create(this, this);
        }
        return this.mDelegate;
    }

    @Override // androidx.appcompat.app.ActionBarDrawerToggle.DelegateProvider
    @androidx.annotation.Nullable
    public androidx.appcompat.app.ActionBarDrawerToggle.Delegate getDrawerToggleDelegate() {
        return getDelegate().getDrawerToggleDelegate();
    }

    @Override // android.app.Activity
    @androidx.annotation.NonNull
    public android.view.MenuInflater getMenuInflater() {
        return getDelegate().getMenuInflater();
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public android.content.res.Resources getResources() {
        if (this.mResources == null && androidx.appcompat.widget.VectorEnabledTintResources.shouldBeUsed()) {
            this.mResources = new androidx.appcompat.widget.VectorEnabledTintResources(this, super.getResources());
        }
        android.content.res.Resources resources = this.mResources;
        return resources == null ? super.getResources() : resources;
    }

    @androidx.annotation.Nullable
    public androidx.appcompat.app.ActionBar getSupportActionBar() {
        return getDelegate().getSupportActionBar();
    }

    @Override // androidx.core.app.TaskStackBuilder.SupportParentable
    @androidx.annotation.Nullable
    public android.content.Intent getSupportParentActivityIntent() {
        return androidx.core.app.NavUtils.getParentActivityIntent(this);
    }

    @Override // android.app.Activity
    public void invalidateOptionsMenu() {
        getDelegate().invalidateOptionsMenu();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(@androidx.annotation.NonNull android.content.res.Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.mResources != null) {
            this.mResources.updateConfiguration(configuration, super.getResources().getDisplayMetrics());
        }
        getDelegate().onConfigurationChanged(configuration);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onContentChanged() {
        onSupportContentChanged();
    }

    public void onCreateSupportNavigateUpTaskStack(@androidx.annotation.NonNull androidx.core.app.TaskStackBuilder taskStackBuilder) {
        taskStackBuilder.addParentStack(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        getDelegate().onDestroy();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, android.view.KeyEvent keyEvent) {
        if (performMenuItemShortcut(keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, android.view.Window.Callback
    public final boolean onMenuItemSelected(int i, @androidx.annotation.NonNull android.view.MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        androidx.appcompat.app.ActionBar supportActionBar = getSupportActionBar();
        if (menuItem.getItemId() != 16908332 || supportActionBar == null || (supportActionBar.getDisplayOptions() & 4) == 0) {
            return false;
        }
        return onSupportNavigateUp();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuOpened(int i, android.view.Menu menu) {
        return super.onMenuOpened(i, menu);
    }

    public void onNightModeChanged(int i) {
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i, @androidx.annotation.NonNull android.view.Menu menu) {
        super.onPanelClosed(i, menu);
    }

    @Override // android.app.Activity
    public void onPostCreate(@androidx.annotation.Nullable android.os.Bundle bundle) {
        super.onPostCreate(bundle);
        getDelegate().onPostCreate(bundle);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        getDelegate().onPostResume();
    }

    public void onPrepareSupportNavigateUpTaskStack(@androidx.annotation.NonNull androidx.core.app.TaskStackBuilder taskStackBuilder) {
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        getDelegate().onStart();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        getDelegate().onStop();
    }

    @Override // androidx.appcompat.app.AppCompatCallback
    @androidx.annotation.CallSuper
    public void onSupportActionModeFinished(@androidx.annotation.NonNull androidx.appcompat.view.ActionMode actionMode) {
    }

    @Override // androidx.appcompat.app.AppCompatCallback
    @androidx.annotation.CallSuper
    public void onSupportActionModeStarted(@androidx.annotation.NonNull androidx.appcompat.view.ActionMode actionMode) {
    }

    @java.lang.Deprecated
    public void onSupportContentChanged() {
    }

    public boolean onSupportNavigateUp() {
        android.content.Intent supportParentActivityIntent = getSupportParentActivityIntent();
        if (supportParentActivityIntent == null) {
            return false;
        }
        if (!supportShouldUpRecreateTask(supportParentActivityIntent)) {
            supportNavigateUpTo(supportParentActivityIntent);
            return true;
        }
        androidx.core.app.TaskStackBuilder create = androidx.core.app.TaskStackBuilder.create(this);
        onCreateSupportNavigateUpTaskStack(create);
        onPrepareSupportNavigateUpTaskStack(create);
        create.startActivities();
        try {
            androidx.core.app.ActivityCompat.finishAffinity(this);
            return true;
        } catch (java.lang.IllegalStateException unused) {
            finish();
            return true;
        }
    }

    @Override // android.app.Activity
    public void onTitleChanged(java.lang.CharSequence charSequence, int i) {
        super.onTitleChanged(charSequence, i);
        getDelegate().setTitle(charSequence);
    }

    @Override // androidx.appcompat.app.AppCompatCallback
    @androidx.annotation.Nullable
    public androidx.appcompat.view.ActionMode onWindowStartingSupportActionMode(@androidx.annotation.NonNull androidx.appcompat.view.ActionMode.Callback callback) {
        return null;
    }

    @Override // android.app.Activity
    public void openOptionsMenu() {
        androidx.appcompat.app.ActionBar supportActionBar = getSupportActionBar();
        if (getWindow().hasFeature(0)) {
            if (supportActionBar == null || !supportActionBar.openOptionsMenu()) {
                super.openOptionsMenu();
            }
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(@androidx.annotation.LayoutRes int i) {
        initViewTreeOwners();
        getDelegate().setContentView(i);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(android.view.View view) {
        initViewTreeOwners();
        getDelegate().setContentView(view);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(android.view.View view, android.view.ViewGroup.LayoutParams layoutParams) {
        initViewTreeOwners();
        getDelegate().setContentView(view, layoutParams);
    }

    public void setSupportActionBar(@androidx.annotation.Nullable androidx.appcompat.widget.Toolbar toolbar) {
        getDelegate().setSupportActionBar(toolbar);
    }

    @java.lang.Deprecated
    public void setSupportProgress(int i) {
    }

    @java.lang.Deprecated
    public void setSupportProgressBarIndeterminate(boolean z) {
    }

    @java.lang.Deprecated
    public void setSupportProgressBarIndeterminateVisibility(boolean z) {
    }

    @java.lang.Deprecated
    public void setSupportProgressBarVisibility(boolean z) {
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public void setTheme(@androidx.annotation.StyleRes int i) {
        super.setTheme(i);
        getDelegate().setTheme(i);
    }

    @androidx.annotation.Nullable
    public androidx.appcompat.view.ActionMode startSupportActionMode(@androidx.annotation.NonNull androidx.appcompat.view.ActionMode.Callback callback) {
        return getDelegate().startSupportActionMode(callback);
    }

    @Override // androidx.fragment.app.FragmentActivity
    public void supportInvalidateOptionsMenu() {
        getDelegate().invalidateOptionsMenu();
    }

    public void supportNavigateUpTo(@androidx.annotation.NonNull android.content.Intent intent) {
        androidx.core.app.NavUtils.navigateUpTo(this, intent);
    }

    public boolean supportRequestWindowFeature(int i) {
        return getDelegate().requestWindowFeature(i);
    }

    public boolean supportShouldUpRecreateTask(@androidx.annotation.NonNull android.content.Intent intent) {
        return androidx.core.app.NavUtils.shouldUpRecreateTask(this, intent);
    }
}
