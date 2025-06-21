package com.bytedance.pangle.activity;

@androidx.annotation.Keep
/* loaded from: classes12.dex */
public abstract class GeneratePluginAppCompatActivity extends androidx.appcompat.app.AppCompatActivity implements com.bytedance.pangle.activity.IPluginActivity {
    boolean hasInit = true;
    public com.bytedance.pangle.plugin.Plugin mPlugin;
    public com.bytedance.pangle.activity.GenerateProxyAppCompatActivity mProxyActivity;

    @Override // com.bytedance.pangle.activity.IPluginActivity
    public void _requestPermissions(java.lang.String[] strArr, int i) {
        this.mProxyActivity.requestPermissions(strArr, i);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void addContentView(android.view.View view, android.view.ViewGroup.LayoutParams layoutParams) {
        this.mProxyActivity.zeusSuperAddContentView(view, layoutParams);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(android.content.Context context) {
        super.attachBaseContext(context);
        com.bytedance.pangle.util.a.a(this, this.mProxyActivity);
    }

    @Override // android.app.Activity
    public void closeContextMenu() {
        this.mProxyActivity.zeusSuperCloseContextMenu();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity
    public void closeOptionsMenu() {
        this.mProxyActivity.zeusSuperCloseOptionsMenu();
    }

    public boolean convertToTranslucent(android.app.Activity.TranslucentConversionListener translucentConversionListener, android.app.ActivityOptions activityOptions) {
        return this.mProxyActivity.zeusSuperConvertToTranslucent(translucentConversionListener, activityOptions);
    }

    @Override // android.app.Activity
    public android.app.PendingIntent createPendingResult(int i, android.content.Intent intent, int i2) {
        return this.mProxyActivity.zeusSuperCreatePendingResult(i, intent, i2);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchGenericMotionEvent(android.view.MotionEvent motionEvent) {
        return this.mProxyActivity.zeusSuperDispatchGenericMotionEvent(motionEvent);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(android.view.KeyEvent keyEvent) {
        return this.mProxyActivity.zeusSuperDispatchKeyEvent(keyEvent);
    }

    @Override // androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyShortcutEvent(android.view.KeyEvent keyEvent) {
        return this.mProxyActivity.zeusSuperDispatchKeyShortcutEvent(keyEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchPopulateAccessibilityEvent(android.view.accessibility.AccessibilityEvent accessibilityEvent) {
        return this.mProxyActivity.zeusSuperDispatchPopulateAccessibilityEvent(accessibilityEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(android.view.MotionEvent motionEvent) {
        return this.mProxyActivity.zeusSuperDispatchTouchEvent(motionEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTrackballEvent(android.view.MotionEvent motionEvent) {
        return this.mProxyActivity.zeusSuperDispatchTrackballEvent(motionEvent);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void dump(java.lang.String str, java.io.FileDescriptor fileDescriptor, java.io.PrintWriter printWriter, java.lang.String[] strArr) {
        this.mProxyActivity.zeusSuperDump(str, fileDescriptor, printWriter, strArr);
    }

    @Override // android.app.Activity
    public void enterPictureInPictureMode() {
        this.mProxyActivity.zeusSuperEnterPictureInPictureMode();
    }

    @Override // android.app.Activity
    public boolean enterPictureInPictureMode(android.app.PictureInPictureParams pictureInPictureParams) {
        return this.mProxyActivity.zeusSuperEnterPictureInPictureMode(pictureInPictureParams);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity
    public android.view.View findViewById(int i) {
        return this.mProxyActivity.zeusSuperFindViewById(i);
    }

    @Override // android.app.Activity
    public void finish() {
        this.mProxyActivity.zeusSuperFinish();
    }

    @Override // android.app.Activity
    public void finishActivity(int i) {
        this.mProxyActivity.zeusSuperFinishActivity(i);
    }

    @Override // android.app.Activity
    public void finishActivityFromChild(android.app.Activity activity, int i) {
        this.mProxyActivity.zeusSuperFinishActivityFromChild(activity, i);
    }

    @Override // android.app.Activity
    public void finishAffinity() {
        this.mProxyActivity.zeusSuperFinishAffinity();
    }

    @Override // android.app.Activity
    public void finishAfterTransition() {
        this.mProxyActivity.zeusSuperFinishAfterTransition();
    }

    @Override // android.app.Activity
    public void finishAndRemoveTask() {
        this.mProxyActivity.zeusSuperFinishAndRemoveTask();
    }

    @Override // android.app.Activity
    public void finishFromChild(android.app.Activity activity) {
        this.mProxyActivity.zeusSuperFinishFromChild(activity);
    }

    @Override // android.app.Activity
    public android.app.ActionBar getActionBar() {
        return this.mProxyActivity.zeusSuperGetActionBar();
    }

    @Override // android.app.Activity
    public android.content.ComponentName getCallingActivity() {
        return this.mProxyActivity.zeusSuperGetCallingActivity();
    }

    @Override // android.app.Activity
    public java.lang.String getCallingPackage() {
        return this.mProxyActivity.zeusSuperGetCallingPackage();
    }

    @Override // android.app.Activity
    public int getChangingConfigurations() {
        return this.mProxyActivity.zeusSuperGetChangingConfigurations();
    }

    @Override // android.app.Activity
    public android.content.ComponentName getComponentName() {
        return this.mProxyActivity.zeusSuperGetComponentName();
    }

    @Override // android.app.Activity
    public android.transition.Scene getContentScene() {
        return this.mProxyActivity.zeusSuperGetContentScene();
    }

    @Override // android.app.Activity
    public android.transition.TransitionManager getContentTransitionManager() {
        return this.mProxyActivity.zeusSuperGetContentTransitionManager();
    }

    @Override // android.app.Activity
    public android.view.View getCurrentFocus() {
        return this.mProxyActivity.zeusSuperGetCurrentFocus();
    }

    @Override // android.app.Activity
    public android.app.FragmentManager getFragmentManager() {
        return this.mProxyActivity.zeusSuperGetFragmentManager();
    }

    @Override // android.app.Activity
    public android.content.Intent getIntent() {
        return this.mProxyActivity.zeusSuperGetIntent();
    }

    @Override // android.app.Activity
    public java.lang.Object getLastNonConfigurationInstance() {
        return this.mProxyActivity.zeusSuperGetLastNonConfigurationInstance();
    }

    @Override // android.app.Activity
    public android.view.LayoutInflater getLayoutInflater() {
        return this.mProxyActivity.zeusSuperGetLayoutInflater();
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.lifecycle.LifecycleOwner
    public androidx.lifecycle.Lifecycle getLifecycle() {
        if (!this.hasInit) {
            try {
                androidx.lifecycle.LifecycleRegistry lifecycleRegistry = new androidx.lifecycle.LifecycleRegistry(this);
                try {
                    java.lang.reflect.Field declaredField = androidx.lifecycle.LifecycleRegistry.class.getDeclaredField("mEnforceMainThread");
                    declaredField.setAccessible(true);
                    declaredField.set(lifecycleRegistry, java.lang.Boolean.FALSE);
                } catch (java.lang.Throwable unused) {
                }
                return lifecycleRegistry;
            } catch (java.lang.Throwable unused2) {
            }
        }
        return super.getLifecycle();
    }

    @Override // android.app.Activity
    public android.app.LoaderManager getLoaderManager() {
        return this.mProxyActivity.zeusSuperGetLoaderManager();
    }

    @Override // android.app.Activity
    public java.lang.String getLocalClassName() {
        return this.mProxyActivity.zeusSuperGetLocalClassName();
    }

    @Override // android.app.Activity
    public int getMaxNumPictureInPictureActions() {
        return this.mProxyActivity.zeusSuperGetMaxNumPictureInPictureActions();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity
    public android.view.MenuInflater getMenuInflater() {
        return this.mProxyActivity.zeusSuperGetMenuInflater();
    }

    @Override // android.app.Activity
    public android.content.Intent getParentActivityIntent() {
        return this.mProxyActivity.zeusSuperGetParentActivityIntent();
    }

    @Override // android.app.Activity
    public android.content.SharedPreferences getPreferences(int i) {
        return this.mProxyActivity.zeusSuperGetPreferences(i);
    }

    @Override // android.app.Activity
    public android.net.Uri getReferrer() {
        return this.mProxyActivity.zeusSuperGetReferrer();
    }

    @Override // android.app.Activity
    public int getRequestedOrientation() {
        return this.mProxyActivity.zeusSuperGetRequestedOrientation();
    }

    @Override // androidx.appcompat.app.AppCompatActivity
    public androidx.appcompat.app.ActionBar getSupportActionBar() {
        return this.mProxyActivity.zeusSuperGetSupportActionBar();
    }

    @Override // androidx.fragment.app.FragmentActivity
    public androidx.fragment.app.FragmentManager getSupportFragmentManager() {
        return this.mProxyActivity.zeusSuperGetSupportFragmentManager();
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public java.lang.Object getSystemService(java.lang.String str) {
        return this.mProxyActivity.zeusSuperGetSystemService(str);
    }

    @Override // android.app.Activity
    public int getTaskId() {
        return this.mProxyActivity.zeusSuperGetTaskId();
    }

    @Override // android.app.Activity
    public android.app.VoiceInteractor getVoiceInteractor() {
        return this.mProxyActivity.zeusSuperGetVoiceInteractor();
    }

    @Override // android.app.Activity
    public android.view.Window getWindow() {
        return this.mProxyActivity.zeusSuperGetWindow();
    }

    @Override // android.app.Activity
    public android.view.WindowManager getWindowManager() {
        return this.mProxyActivity.zeusSuperGetWindowManager();
    }

    @Override // android.app.Activity
    public boolean hasWindowFocus() {
        return this.mProxyActivity.zeusSuperHasWindowFocus();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity
    public void invalidateOptionsMenu() {
        this.mProxyActivity.zeusSuperInvalidateOptionsMenu();
    }

    @Override // android.app.Activity
    public boolean isActivityTransitionRunning() {
        return this.mProxyActivity.zeusSuperIsActivityTransitionRunning();
    }

    @Override // android.app.Activity
    public boolean isChangingConfigurations() {
        return this.mProxyActivity.zeusSuperIsChangingConfigurations();
    }

    @Override // android.app.Activity
    public boolean isDestroyed() {
        return this.mProxyActivity.zeusSuperIsDestroyed();
    }

    @Override // android.app.Activity
    public boolean isFinishing() {
        return this.mProxyActivity.zeusSuperIsFinishing();
    }

    @Override // android.app.Activity
    public boolean isImmersive() {
        return this.mProxyActivity.zeusSuperIsImmersive();
    }

    @Override // android.app.Activity
    public boolean isInMultiWindowMode() {
        return this.mProxyActivity.zeusSuperIsInMultiWindowMode();
    }

    @Override // android.app.Activity
    public boolean isInPictureInPictureMode() {
        return this.mProxyActivity.zeusSuperIsInPictureInPictureMode();
    }

    @Override // android.app.Activity
    public boolean isLocalVoiceInteractionSupported() {
        return this.mProxyActivity.zeusSuperIsLocalVoiceInteractionSupported();
    }

    @Override // android.app.Activity
    public boolean isTaskRoot() {
        return this.mProxyActivity.zeusSuperIsTaskRoot();
    }

    @Override // android.app.Activity
    public boolean isVoiceInteraction() {
        return this.mProxyActivity.zeusSuperIsVoiceInteraction();
    }

    @Override // android.app.Activity
    public boolean isVoiceInteractionRoot() {
        return this.mProxyActivity.zeusSuperIsVoiceInteractionRoot();
    }

    @Override // android.app.Activity
    public boolean moveTaskToBack(boolean z) {
        return this.mProxyActivity.zeusSuperMoveTaskToBack(z);
    }

    @Override // android.app.Activity
    public boolean navigateUpTo(android.content.Intent intent) {
        return this.mProxyActivity.zeusSuperNavigateUpTo(intent);
    }

    @Override // android.app.Activity
    public boolean navigateUpToFromChild(android.app.Activity activity, android.content.Intent intent) {
        return this.mProxyActivity.zeusSuperNavigateUpToFromChild(activity, intent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onActionModeFinished(android.view.ActionMode actionMode) {
        this.mProxyActivity.zeusSuperOnActionModeFinished(actionMode);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onActionModeStarted(android.view.ActionMode actionMode) {
        this.mProxyActivity.zeusSuperOnActionModeStarted(actionMode);
    }

    @Override // android.app.Activity
    public void onActivityReenter(int i, android.content.Intent intent) {
        this.mProxyActivity.zeusSuperOnActivityReenter(i, intent);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, android.content.Intent intent) {
        this.mProxyActivity.zeusSuperOnActivityResult(i, i2, intent);
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper
    public void onApplyThemeResource(android.content.res.Resources.Theme theme, int i, boolean z) {
        this.mProxyActivity.zeusSuperOnApplyThemeResource(theme, i, z);
    }

    @Override // android.app.Activity
    public void onAttachFragment(android.app.Fragment fragment) {
        this.mProxyActivity.zeusSuperOnAttachFragment(fragment);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        this.mProxyActivity.zeusSuperOnAttachedToWindow();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        this.mProxyActivity.zeusSuperOnBackPressed();
    }

    @Override // android.app.Activity
    public void onChildTitleChanged(android.app.Activity activity, java.lang.CharSequence charSequence) {
        this.mProxyActivity.zeusSuperOnChildTitleChanged(activity, charSequence);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(android.content.res.Configuration configuration) {
        this.mProxyActivity.zeusSuperOnConfigurationChanged(configuration);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.Window.Callback
    public void onContentChanged() {
        this.mProxyActivity.zeusSuperOnContentChanged();
    }

    @Override // android.app.Activity
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public boolean onContextItemSelected(android.view.MenuItem menuItem) {
        boolean zeusSuperOnContextItemSelected = this.mProxyActivity.zeusSuperOnContextItemSelected(menuItem);
        com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackMenuItem(this, menuItem);
        return zeusSuperOnContextItemSelected;
    }

    @Override // android.app.Activity
    public void onContextMenuClosed(android.view.Menu menu) {
        this.mProxyActivity.zeusSuperOnContextMenuClosed(menu);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(android.os.Bundle bundle) {
        this.mProxyActivity.zeusSuperOnCreate(bundle);
        com.bytedance.pangle.res.b.a(getLayoutInflater());
    }

    @Override // android.app.Activity
    public void onCreate(android.os.Bundle bundle, android.os.PersistableBundle persistableBundle) {
        this.mProxyActivity.zeusSuperOnCreate(bundle, persistableBundle);
    }

    @Override // android.app.Activity, android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(android.view.ContextMenu contextMenu, android.view.View view, android.view.ContextMenu.ContextMenuInfo contextMenuInfo) {
        this.mProxyActivity.zeusSuperOnCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    @Override // android.app.Activity
    public java.lang.CharSequence onCreateDescription() {
        return this.mProxyActivity.zeusSuperOnCreateDescription();
    }

    @Override // android.app.Activity
    public android.app.Dialog onCreateDialog(int i) {
        return this.mProxyActivity.zeusSuperOnCreateDialog(i);
    }

    @Override // android.app.Activity
    public android.app.Dialog onCreateDialog(int i, android.os.Bundle bundle) {
        return this.mProxyActivity.zeusSuperOnCreateDialog(i, bundle);
    }

    @Override // android.app.Activity
    public void onCreateNavigateUpTaskStack(android.app.TaskStackBuilder taskStackBuilder) {
        this.mProxyActivity.zeusSuperOnCreateNavigateUpTaskStack(taskStackBuilder);
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        return this.mProxyActivity.zeusSuperOnCreateOptionsMenu(menu);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, android.view.Window.Callback
    public boolean onCreatePanelMenu(int i, android.view.Menu menu) {
        return this.mProxyActivity.zeusSuperOnCreatePanelMenu(i, menu);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public android.view.View onCreatePanelView(int i) {
        return this.mProxyActivity.zeusSuperOnCreatePanelView(i);
    }

    @Override // android.app.Activity
    public boolean onCreateThumbnail(android.graphics.Bitmap bitmap, android.graphics.Canvas canvas) {
        return this.mProxyActivity.zeusSuperOnCreateThumbnail(bitmap, canvas);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, android.view.LayoutInflater.Factory2
    public android.view.View onCreateView(android.view.View view, java.lang.String str, android.content.Context context, android.util.AttributeSet attributeSet) {
        return this.mProxyActivity.zeusSuperOnCreateView(view, str, context, attributeSet);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, android.view.LayoutInflater.Factory
    public android.view.View onCreateView(java.lang.String str, android.content.Context context, android.util.AttributeSet attributeSet) {
        return this.mProxyActivity.zeusSuperOnCreateView(str, context, attributeSet);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        this.mProxyActivity.zeusSuperOnDestroy();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onDetachedFromWindow() {
        this.mProxyActivity.zeusSuperOnDetachedFromWindow();
    }

    @Override // android.app.Activity
    public void onEnterAnimationComplete() {
        this.mProxyActivity.zeusSuperOnEnterAnimationComplete();
    }

    @Override // android.app.Activity
    public boolean onGenericMotionEvent(android.view.MotionEvent motionEvent) {
        return this.mProxyActivity.zeusSuperOnGenericMotionEvent(motionEvent);
    }

    @Override // android.app.Activity
    public void onGetDirectActions(android.os.CancellationSignal cancellationSignal, java.util.function.Consumer consumer) {
        this.mProxyActivity.zeusSuperOnGetDirectActions(cancellationSignal, consumer);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, android.view.KeyEvent keyEvent) {
        return this.mProxyActivity.zeusSuperOnKeyDown(i, keyEvent);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyLongPress(int i, android.view.KeyEvent keyEvent) {
        return this.mProxyActivity.zeusSuperOnKeyLongPress(i, keyEvent);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyMultiple(int i, int i2, android.view.KeyEvent keyEvent) {
        return this.mProxyActivity.zeusSuperOnKeyMultiple(i, i2, keyEvent);
    }

    @Override // android.app.Activity
    public boolean onKeyShortcut(int i, android.view.KeyEvent keyEvent) {
        return this.mProxyActivity.zeusSuperOnKeyShortcut(i, keyEvent);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, android.view.KeyEvent keyEvent) {
        return this.mProxyActivity.zeusSuperOnKeyUp(i, keyEvent);
    }

    @Override // android.app.Activity
    public void onLocalVoiceInteractionStarted() {
        this.mProxyActivity.zeusSuperOnLocalVoiceInteractionStarted();
    }

    @Override // android.app.Activity
    public void onLocalVoiceInteractionStopped() {
        this.mProxyActivity.zeusSuperOnLocalVoiceInteractionStopped();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onLowMemory() {
        this.mProxyActivity.zeusSuperOnLowMemory();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.Window.Callback
    public boolean onMenuOpened(int i, android.view.Menu menu) {
        return this.mProxyActivity.zeusSuperOnMenuOpened(i, menu);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onMultiWindowModeChanged(boolean z) {
        this.mProxyActivity.zeusSuperOnMultiWindowModeChanged(z);
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean z, android.content.res.Configuration configuration) {
        this.mProxyActivity.zeusSuperOnMultiWindowModeChanged(z, configuration);
    }

    @Override // android.app.Activity
    public boolean onNavigateUp() {
        return this.mProxyActivity.zeusSuperOnNavigateUp();
    }

    @Override // android.app.Activity
    public boolean onNavigateUpFromChild(android.app.Activity activity) {
        return this.mProxyActivity.zeusSuperOnNavigateUpFromChild(activity);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onNewIntent(android.content.Intent intent) {
        this.mProxyActivity.zeusSuperOnNewIntent(intent);
    }

    @Override // android.app.Activity
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public boolean onOptionsItemSelected(android.view.MenuItem menuItem) {
        boolean zeusSuperOnOptionsItemSelected = this.mProxyActivity.zeusSuperOnOptionsItemSelected(menuItem);
        com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackMenuItem(this, menuItem);
        return zeusSuperOnOptionsItemSelected;
    }

    @Override // android.app.Activity
    public void onOptionsMenuClosed(android.view.Menu menu) {
        this.mProxyActivity.zeusSuperOnOptionsMenuClosed(menu);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i, android.view.Menu menu) {
        this.mProxyActivity.zeusSuperOnPanelClosed(i, menu);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        this.mProxyActivity.zeusSuperOnPause();
    }

    @Override // android.app.Activity
    public void onPerformDirectAction(java.lang.String str, android.os.Bundle bundle, android.os.CancellationSignal cancellationSignal, java.util.function.Consumer consumer) {
        this.mProxyActivity.zeusSuperOnPerformDirectAction(str, bundle, cancellationSignal, consumer);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPictureInPictureModeChanged(boolean z) {
        this.mProxyActivity.zeusSuperOnPictureInPictureModeChanged(z);
    }

    @Override // android.app.Activity
    public void onPictureInPictureModeChanged(boolean z, android.content.res.Configuration configuration) {
        this.mProxyActivity.zeusSuperOnPictureInPictureModeChanged(z, configuration);
    }

    @Override // android.app.Activity
    public boolean onPictureInPictureRequested() {
        return this.mProxyActivity.zeusSuperOnPictureInPictureRequested();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity
    public void onPostCreate(android.os.Bundle bundle) {
        this.mProxyActivity.zeusSuperOnPostCreate(bundle);
    }

    @Override // android.app.Activity
    public void onPostCreate(android.os.Bundle bundle, android.os.PersistableBundle persistableBundle) {
        this.mProxyActivity.zeusSuperOnPostCreate(bundle, persistableBundle);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPostResume() {
        this.mProxyActivity.zeusSuperOnPostResume();
    }

    @Override // android.app.Activity
    public void onPrepareDialog(int i, android.app.Dialog dialog) {
        this.mProxyActivity.zeusSuperOnPrepareDialog(i, dialog);
    }

    @Override // android.app.Activity
    public void onPrepareDialog(int i, android.app.Dialog dialog, android.os.Bundle bundle) {
        this.mProxyActivity.zeusSuperOnPrepareDialog(i, dialog, bundle);
    }

    @Override // android.app.Activity
    public void onPrepareNavigateUpTaskStack(android.app.TaskStackBuilder taskStackBuilder) {
        this.mProxyActivity.zeusSuperOnPrepareNavigateUpTaskStack(taskStackBuilder);
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(android.view.Menu menu) {
        return this.mProxyActivity.zeusSuperOnPrepareOptionsMenu(menu);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, android.view.Window.Callback
    public boolean onPreparePanel(int i, android.view.View view, android.view.Menu menu) {
        return this.mProxyActivity.zeusSuperOnPreparePanel(i, view, menu);
    }

    @Override // android.app.Activity
    public void onProvideAssistContent(android.app.assist.AssistContent assistContent) {
        this.mProxyActivity.zeusSuperOnProvideAssistContent(assistContent);
    }

    @Override // android.app.Activity
    public void onProvideAssistData(android.os.Bundle bundle) {
        this.mProxyActivity.zeusSuperOnProvideAssistData(bundle);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onProvideKeyboardShortcuts(java.util.List list, android.view.Menu menu, int i) {
        this.mProxyActivity.zeusSuperOnProvideKeyboardShortcuts(list, menu, i);
    }

    @Override // android.app.Activity
    public android.net.Uri onProvideReferrer() {
        return this.mProxyActivity.zeusSuperOnProvideReferrer();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, java.lang.String[] strArr, int[] iArr) {
        this.mProxyActivity.zeusSuperOnRequestPermissionsResult(i, strArr, iArr);
    }

    @Override // android.app.Activity
    public void onRestart() {
        this.mProxyActivity.zeusSuperOnRestart();
    }

    @Override // android.app.Activity
    public void onRestoreInstanceState(android.os.Bundle bundle) {
        try {
            this.mProxyActivity.zeusSuperOnRestoreInstanceState(bundle);
        } catch (java.lang.Throwable unused) {
        }
    }

    @Override // android.app.Activity
    public void onRestoreInstanceState(android.os.Bundle bundle, android.os.PersistableBundle persistableBundle) {
        try {
            this.mProxyActivity.zeusSuperOnRestoreInstanceState(bundle, persistableBundle);
        } catch (java.lang.Throwable unused) {
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        this.mProxyActivity.zeusSuperOnResume();
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(android.os.Bundle bundle) {
        this.mProxyActivity.zeusSuperOnSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(android.os.Bundle bundle, android.os.PersistableBundle persistableBundle) {
        this.mProxyActivity.zeusSuperOnSaveInstanceState(bundle, persistableBundle);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onSearchRequested() {
        return this.mProxyActivity.zeusSuperOnSearchRequested();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onSearchRequested(android.view.SearchEvent searchEvent) {
        return this.mProxyActivity.zeusSuperOnSearchRequested(searchEvent);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        this.mProxyActivity.zeusSuperOnStart();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStateNotSaved() {
        this.mProxyActivity.zeusSuperOnStateNotSaved();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        this.mProxyActivity.zeusSuperOnStop();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity
    public void onTitleChanged(java.lang.CharSequence charSequence, int i) {
        this.mProxyActivity.zeusSuperOnTitleChanged(charSequence, i);
    }

    @Override // android.app.Activity
    public void onTopResumedActivityChanged(boolean z) {
        this.mProxyActivity.zeusSuperOnTopResumedActivityChanged(z);
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        return this.mProxyActivity.zeusSuperOnTouchEvent(motionEvent);
    }

    @Override // android.app.Activity
    public boolean onTrackballEvent(android.view.MotionEvent motionEvent) {
        return this.mProxyActivity.zeusSuperOnTrackballEvent(motionEvent);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        this.mProxyActivity.zeusSuperOnTrimMemory(i);
    }

    @Override // android.app.Activity
    public void onUserInteraction() {
        this.mProxyActivity.zeusSuperOnUserInteraction();
    }

    @Override // android.app.Activity
    public void onUserLeaveHint() {
        this.mProxyActivity.zeusSuperOnUserLeaveHint();
    }

    @Override // android.app.Activity
    public void onVisibleBehindCanceled() {
        this.mProxyActivity.zeusSuperOnVisibleBehindCanceled();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowAttributesChanged(android.view.WindowManager.LayoutParams layoutParams) {
        this.mProxyActivity.zeusSuperOnWindowAttributesChanged(layoutParams);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        this.mProxyActivity.zeusSuperOnWindowFocusChanged(z);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public android.view.ActionMode onWindowStartingActionMode(android.view.ActionMode.Callback callback) {
        return this.mProxyActivity.zeusSuperOnWindowStartingActionMode(callback);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public android.view.ActionMode onWindowStartingActionMode(android.view.ActionMode.Callback callback, int i) {
        return this.mProxyActivity.zeusSuperOnWindowStartingActionMode(callback, i);
    }

    @Override // android.app.Activity
    public void openContextMenu(android.view.View view) {
        this.mProxyActivity.zeusSuperOpenContextMenu(view);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity
    public void openOptionsMenu() {
        this.mProxyActivity.zeusSuperOpenOptionsMenu();
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        this.mProxyActivity.zeusSuperOverridePendingTransition(i, i2);
    }

    @Override // android.app.Activity
    public void postponeEnterTransition() {
        this.mProxyActivity.zeusSuperPostponeEnterTransition();
    }

    @Override // android.app.Activity
    public void recreate() {
        this.mProxyActivity.zeusSuperRecreate();
    }

    @Override // android.app.Activity
    public void registerActivityLifecycleCallbacks(android.app.Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        this.mProxyActivity.zeusSuperRegisterActivityLifecycleCallbacks(activityLifecycleCallbacks);
    }

    @Override // android.app.Activity
    public void registerForContextMenu(android.view.View view) {
        this.mProxyActivity.zeusSuperRegisterForContextMenu(view);
    }

    @Override // android.app.Activity
    public boolean releaseInstance() {
        return this.mProxyActivity.zeusSuperReleaseInstance();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void reportFullyDrawn() {
        this.mProxyActivity.zeusSuperReportFullyDrawn();
    }

    @Override // android.app.Activity
    public android.view.DragAndDropPermissions requestDragAndDropPermissions(android.view.DragEvent dragEvent) {
        return this.mProxyActivity.zeusSuperRequestDragAndDropPermissions(dragEvent);
    }

    @Override // android.app.Activity
    public boolean requestVisibleBehind(boolean z) {
        return this.mProxyActivity.zeusSuperRequestVisibleBehind(z);
    }

    @Override // android.app.Activity
    public void setActionBar(android.widget.Toolbar toolbar) {
        this.mProxyActivity.zeusSuperSetActionBar(toolbar);
    }

    @Override // android.app.Activity
    public void setContentTransitionManager(android.transition.TransitionManager transitionManager) {
        this.mProxyActivity.zeusSuperSetContentTransitionManager(transitionManager);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(int i) {
        com.bytedance.pangle.transform.ZeusTransformUtils.clearConstructorCache();
        this.mProxyActivity.zeusSuperSetContentView(i);
        com.bytedance.pangle.transform.ZeusTransformUtils.clearConstructorCache();
        com.bytedance.pangle.activity.c.a(this, findViewById(android.R.id.content));
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(android.view.View view) {
        this.mProxyActivity.zeusSuperSetContentView(view);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(android.view.View view, android.view.ViewGroup.LayoutParams layoutParams) {
        this.mProxyActivity.zeusSuperSetContentView(view, layoutParams);
    }

    @Override // android.app.Activity
    public void setEnterSharedElementCallback(android.app.SharedElementCallback sharedElementCallback) {
        this.mProxyActivity.zeusSuperSetEnterSharedElementCallback(sharedElementCallback);
    }

    @Override // android.app.Activity
    public void setExitSharedElementCallback(android.app.SharedElementCallback sharedElementCallback) {
        this.mProxyActivity.zeusSuperSetExitSharedElementCallback(sharedElementCallback);
    }

    @Override // android.app.Activity
    public void setFinishOnTouchOutside(boolean z) {
        this.mProxyActivity.zeusSuperSetFinishOnTouchOutside(z);
    }

    @Override // android.app.Activity
    public void setImmersive(boolean z) {
        this.mProxyActivity.zeusSuperSetImmersive(z);
    }

    @Override // android.app.Activity
    public void setInheritShowWhenLocked(boolean z) {
        this.mProxyActivity.zeusSuperSetInheritShowWhenLocked(z);
    }

    @Override // android.app.Activity
    public void setIntent(android.content.Intent intent) {
        this.mProxyActivity.zeusSuperSetIntent(intent);
    }

    @Override // android.app.Activity
    public void setLocusContext(android.content.LocusId locusId, android.os.Bundle bundle) {
        this.mProxyActivity.zeusSuperSetLocusContext(locusId, bundle);
    }

    @Override // android.app.Activity
    public void setPictureInPictureParams(android.app.PictureInPictureParams pictureInPictureParams) {
        this.mProxyActivity.zeusSuperSetPictureInPictureParams(pictureInPictureParams);
    }

    @Override // com.bytedance.pangle.activity.IPluginActivity
    public void setPluginProxyActivity(com.bytedance.pangle.activity.b bVar, com.bytedance.pangle.plugin.Plugin plugin) {
        this.mProxyActivity = (com.bytedance.pangle.activity.GenerateProxyAppCompatActivity) bVar;
        this.mPlugin = plugin;
    }

    @Override // com.bytedance.pangle.activity.IPluginActivity
    public void setProxyTheme2Plugin(int i) {
        try {
            super.setTheme(i);
        } catch (java.lang.Exception unused) {
        }
    }

    @Override // android.app.Activity
    public void setRequestedOrientation(int i) {
        this.mProxyActivity.zeusSuperSetRequestedOrientation(i);
    }

    @Override // android.app.Activity
    public void setShowWhenLocked(boolean z) {
        this.mProxyActivity.zeusSuperSetShowWhenLocked(z);
    }

    @Override // android.app.Activity
    public void setTaskDescription(android.app.ActivityManager.TaskDescription taskDescription) {
        this.mProxyActivity.zeusSuperSetTaskDescription(taskDescription);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public void setTheme(int i) {
        this.mProxyActivity.zeusSuperSetTheme(i);
    }

    @Override // android.app.Activity
    public void setTitle(int i) {
        this.mProxyActivity.zeusSuperSetTitle(i);
    }

    @Override // android.app.Activity
    public void setTitle(java.lang.CharSequence charSequence) {
        this.mProxyActivity.zeusSuperSetTitle(charSequence);
    }

    @Override // android.app.Activity
    public void setTitleColor(int i) {
        this.mProxyActivity.zeusSuperSetTitleColor(i);
    }

    @Override // android.app.Activity
    public boolean setTranslucent(boolean z) {
        return this.mProxyActivity.zeusSuperSetTranslucent(z);
    }

    @Override // android.app.Activity
    public void setTurnScreenOn(boolean z) {
        this.mProxyActivity.zeusSuperSetTurnScreenOn(z);
    }

    @Override // android.app.Activity
    public void setVisible(boolean z) {
        this.mProxyActivity.zeusSuperSetVisible(z);
    }

    @Override // android.app.Activity
    public void setVrModeEnabled(boolean z, android.content.ComponentName componentName) {
        this.mProxyActivity.zeusSuperSetVrModeEnabled(z, componentName);
    }

    @Override // android.app.Activity
    public boolean shouldShowRequestPermissionRationale(java.lang.String str) {
        return this.mProxyActivity.zeusSuperShouldShowRequestPermissionRationale(str);
    }

    @Override // android.app.Activity
    public boolean shouldUpRecreateTask(android.content.Intent intent) {
        return this.mProxyActivity.zeusSuperShouldUpRecreateTask(intent);
    }

    @Override // android.app.Activity
    public boolean showAssist(android.os.Bundle bundle) {
        return this.mProxyActivity.zeusSuperShowAssist(bundle);
    }

    @Override // android.app.Activity
    public void showLockTaskEscapeMessage() {
        this.mProxyActivity.zeusSuperShowLockTaskEscapeMessage();
    }

    @Override // android.app.Activity
    public android.view.ActionMode startActionMode(android.view.ActionMode.Callback callback) {
        return this.mProxyActivity.zeusSuperStartActionMode(callback);
    }

    @Override // android.app.Activity
    public android.view.ActionMode startActionMode(android.view.ActionMode.Callback callback, int i) {
        return this.mProxyActivity.zeusSuperStartActionMode(callback, i);
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivities(android.content.Intent[] intentArr) {
        this.mProxyActivity.zeusSuperStartActivities(intentArr);
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivities(android.content.Intent[] intentArr, android.os.Bundle bundle) {
        this.mProxyActivity.zeusSuperStartActivities(intentArr, bundle);
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivity(android.content.Intent intent) {
        this.mProxyActivity.zeusSuperStartActivity(intent);
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivity(android.content.Intent intent, android.os.Bundle bundle) {
        this.mProxyActivity.zeusSuperStartActivity(intent, bundle);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(android.content.Intent intent, int i) {
        this.mProxyActivity.zeusSuperStartActivityForResult(intent, i);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(android.content.Intent intent, int i, android.os.Bundle bundle) {
        this.mProxyActivity.zeusSuperStartActivityForResult(intent, i, bundle);
    }

    public void startActivityForResult(java.lang.String str, android.content.Intent intent, int i, android.os.Bundle bundle) {
        this.mProxyActivity.startActivityForResult(str, intent, i, bundle);
    }

    @Override // android.app.Activity
    public void startActivityFromChild(android.app.Activity activity, android.content.Intent intent, int i) {
        this.mProxyActivity.zeusSuperStartActivityFromChild(activity, intent, i);
    }

    @Override // android.app.Activity
    public void startActivityFromChild(android.app.Activity activity, android.content.Intent intent, int i, android.os.Bundle bundle) {
        this.mProxyActivity.zeusSuperStartActivityFromChild(activity, intent, i, bundle);
    }

    @Override // android.app.Activity
    public void startActivityFromFragment(android.app.Fragment fragment, android.content.Intent intent, int i) {
        this.mProxyActivity.zeusSuperStartActivityFromFragment(fragment, intent, i);
    }

    @Override // android.app.Activity
    public void startActivityFromFragment(android.app.Fragment fragment, android.content.Intent intent, int i, android.os.Bundle bundle) {
        this.mProxyActivity.zeusSuperStartActivityFromFragment(fragment, intent, i, bundle);
    }

    @Override // android.app.Activity
    public boolean startActivityIfNeeded(android.content.Intent intent, int i) {
        return this.mProxyActivity.zeusSuperStartActivityIfNeeded(intent, i);
    }

    @Override // android.app.Activity
    public boolean startActivityIfNeeded(android.content.Intent intent, int i, android.os.Bundle bundle) {
        return this.mProxyActivity.zeusSuperStartActivityIfNeeded(intent, i, bundle);
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startIntentSender(android.content.IntentSender intentSender, android.content.Intent intent, int i, int i2, int i3) {
        this.mProxyActivity.zeusSuperStartIntentSender(intentSender, intent, i, i2, i3);
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startIntentSender(android.content.IntentSender intentSender, android.content.Intent intent, int i, int i2, int i3, android.os.Bundle bundle) {
        this.mProxyActivity.zeusSuperStartIntentSender(intentSender, intent, i, i2, i3, bundle);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startIntentSenderForResult(android.content.IntentSender intentSender, int i, android.content.Intent intent, int i2, int i3, int i4) {
        this.mProxyActivity.zeusSuperStartIntentSenderForResult(intentSender, i, intent, i2, i3, i4);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startIntentSenderForResult(android.content.IntentSender intentSender, int i, android.content.Intent intent, int i2, int i3, int i4, android.os.Bundle bundle) {
        this.mProxyActivity.zeusSuperStartIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
    }

    @Override // android.app.Activity
    public void startIntentSenderFromChild(android.app.Activity activity, android.content.IntentSender intentSender, int i, android.content.Intent intent, int i2, int i3, int i4) {
        this.mProxyActivity.zeusSuperStartIntentSenderFromChild(activity, intentSender, i, intent, i2, i3, i4);
    }

    @Override // android.app.Activity
    public void startIntentSenderFromChild(android.app.Activity activity, android.content.IntentSender intentSender, int i, android.content.Intent intent, int i2, int i3, int i4, android.os.Bundle bundle) {
        this.mProxyActivity.zeusSuperStartIntentSenderFromChild(activity, intentSender, i, intent, i2, i3, i4, bundle);
    }

    @Override // android.app.Activity
    public void startLocalVoiceInteraction(android.os.Bundle bundle) {
        this.mProxyActivity.zeusSuperStartLocalVoiceInteraction(bundle);
    }

    @Override // android.app.Activity
    public void startLockTask() {
        this.mProxyActivity.zeusSuperStartLockTask();
    }

    @Override // android.app.Activity
    public void startManagingCursor(android.database.Cursor cursor) {
        this.mProxyActivity.zeusSuperStartManagingCursor(cursor);
    }

    @Override // android.app.Activity
    public boolean startNextMatchingActivity(android.content.Intent intent) {
        return this.mProxyActivity.zeusSuperStartNextMatchingActivity(intent);
    }

    @Override // android.app.Activity
    public boolean startNextMatchingActivity(android.content.Intent intent, android.os.Bundle bundle) {
        return this.mProxyActivity.zeusSuperStartNextMatchingActivity(intent, bundle);
    }

    @Override // android.app.Activity
    public void startPostponedEnterTransition() {
        this.mProxyActivity.zeusSuperStartPostponedEnterTransition();
    }

    @Override // android.app.Activity
    public void startSearch(java.lang.String str, boolean z, android.os.Bundle bundle, boolean z2) {
        this.mProxyActivity.zeusSuperStartSearch(str, z, bundle, z2);
    }

    @Override // android.app.Activity
    public void stopLocalVoiceInteraction() {
        this.mProxyActivity.zeusSuperStopLocalVoiceInteraction();
    }

    @Override // android.app.Activity
    public void stopLockTask() {
        this.mProxyActivity.zeusSuperStopLockTask();
    }

    @Override // android.app.Activity
    public void stopManagingCursor(android.database.Cursor cursor) {
        this.mProxyActivity.zeusSuperStopManagingCursor(cursor);
    }

    @Override // android.app.Activity
    public void takeKeyEvents(boolean z) {
        this.mProxyActivity.zeusSuperTakeKeyEvents(z);
    }

    @Override // android.app.Activity
    public void triggerSearch(java.lang.String str, android.os.Bundle bundle) {
        this.mProxyActivity.zeusSuperTriggerSearch(str, bundle);
    }

    @Override // android.app.Activity
    public void unregisterActivityLifecycleCallbacks(android.app.Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        this.mProxyActivity.zeusSuperUnregisterActivityLifecycleCallbacks(activityLifecycleCallbacks);
    }

    @Override // android.app.Activity
    public void unregisterForContextMenu(android.view.View view) {
        this.mProxyActivity.zeusSuperUnregisterForContextMenu(view);
    }
}
