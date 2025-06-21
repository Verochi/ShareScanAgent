package com.bytedance.pangle.wrapper;

@androidx.annotation.Keep
/* loaded from: classes22.dex */
public abstract class GenerateActivityWrapper extends android.app.Activity implements com.bytedance.pangle.wrapper.a {
    public android.app.Activity mOriginActivity;
    public com.bytedance.pangle.PluginContext pluginContext;

    @Override // android.app.Activity
    public void addContentView(android.view.View view, android.view.ViewGroup.LayoutParams layoutParams) {
        this.mOriginActivity.addContentView(view, layoutParams);
    }

    @Override // android.app.Activity
    public void closeContextMenu() {
        this.mOriginActivity.closeContextMenu();
    }

    @Override // android.app.Activity
    public void closeOptionsMenu() {
        this.mOriginActivity.closeOptionsMenu();
    }

    @Override // android.app.Activity
    public android.app.PendingIntent createPendingResult(int i, android.content.Intent intent, int i2) {
        return this.mOriginActivity.createPendingResult(i, intent, i2);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchGenericMotionEvent(android.view.MotionEvent motionEvent) {
        return this.mOriginActivity.dispatchGenericMotionEvent(motionEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(android.view.KeyEvent keyEvent) {
        return this.mOriginActivity.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyShortcutEvent(android.view.KeyEvent keyEvent) {
        return this.mOriginActivity.dispatchKeyShortcutEvent(keyEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchPopulateAccessibilityEvent(android.view.accessibility.AccessibilityEvent accessibilityEvent) {
        return this.mOriginActivity.dispatchPopulateAccessibilityEvent(accessibilityEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(android.view.MotionEvent motionEvent) {
        return this.mOriginActivity.dispatchTouchEvent(motionEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTrackballEvent(android.view.MotionEvent motionEvent) {
        return this.mOriginActivity.dispatchTrackballEvent(motionEvent);
    }

    @Override // android.app.Activity
    public void dump(java.lang.String str, java.io.FileDescriptor fileDescriptor, java.io.PrintWriter printWriter, java.lang.String[] strArr) {
        this.mOriginActivity.dump(str, fileDescriptor, printWriter, strArr);
    }

    @Override // android.app.Activity
    public void enterPictureInPictureMode() {
        this.mOriginActivity.enterPictureInPictureMode();
    }

    @Override // android.app.Activity
    public boolean enterPictureInPictureMode(android.app.PictureInPictureParams pictureInPictureParams) {
        boolean enterPictureInPictureMode;
        enterPictureInPictureMode = this.mOriginActivity.enterPictureInPictureMode(pictureInPictureParams);
        return enterPictureInPictureMode;
    }

    @Override // android.app.Activity
    public android.view.View findViewById(int i) {
        return this.mOriginActivity.findViewById(i);
    }

    @Override // android.app.Activity
    public void finish() {
        this.mOriginActivity.finish();
    }

    @Override // android.app.Activity
    public void finishActivity(int i) {
        this.mOriginActivity.finishActivity(i);
    }

    @Override // android.app.Activity
    public void finishActivityFromChild(android.app.Activity activity, int i) {
        this.mOriginActivity.finishActivityFromChild(activity, i);
    }

    @Override // android.app.Activity
    public void finishAffinity() {
        this.mOriginActivity.finishAffinity();
    }

    @Override // android.app.Activity
    public void finishAfterTransition() {
        this.mOriginActivity.finishAfterTransition();
    }

    @Override // android.app.Activity
    public void finishAndRemoveTask() {
        this.mOriginActivity.finishAndRemoveTask();
    }

    @Override // android.app.Activity
    public void finishFromChild(android.app.Activity activity) {
        this.mOriginActivity.finishFromChild(activity);
    }

    @Override // android.app.Activity
    public android.app.ActionBar getActionBar() {
        return this.mOriginActivity.getActionBar();
    }

    @Override // android.app.Activity
    public android.content.ComponentName getCallingActivity() {
        return this.mOriginActivity.getCallingActivity();
    }

    @Override // android.app.Activity
    public java.lang.String getCallingPackage() {
        return this.mOriginActivity.getCallingPackage();
    }

    @Override // android.app.Activity
    public int getChangingConfigurations() {
        return this.mOriginActivity.getChangingConfigurations();
    }

    @Override // android.app.Activity
    public android.content.ComponentName getComponentName() {
        return this.mOriginActivity.getComponentName();
    }

    @Override // android.app.Activity
    public android.transition.Scene getContentScene() {
        return this.mOriginActivity.getContentScene();
    }

    @Override // android.app.Activity
    public android.transition.TransitionManager getContentTransitionManager() {
        return this.mOriginActivity.getContentTransitionManager();
    }

    @Override // android.app.Activity
    public android.view.View getCurrentFocus() {
        return this.mOriginActivity.getCurrentFocus();
    }

    @Override // android.app.Activity
    public android.app.FragmentManager getFragmentManager() {
        return this.mOriginActivity.getFragmentManager();
    }

    @Override // android.app.Activity
    public android.content.Intent getIntent() {
        return this.mOriginActivity.getIntent();
    }

    @Override // android.app.Activity
    public java.lang.Object getLastNonConfigurationInstance() {
        return this.mOriginActivity.getLastNonConfigurationInstance();
    }

    @Override // android.app.Activity
    public android.view.LayoutInflater getLayoutInflater() {
        return this.mOriginActivity.getLayoutInflater();
    }

    @Override // android.app.Activity
    public android.app.LoaderManager getLoaderManager() {
        return this.mOriginActivity.getLoaderManager();
    }

    @Override // android.app.Activity
    public java.lang.String getLocalClassName() {
        return this.mOriginActivity.getLocalClassName();
    }

    @Override // android.app.Activity
    public int getMaxNumPictureInPictureActions() {
        int maxNumPictureInPictureActions;
        maxNumPictureInPictureActions = this.mOriginActivity.getMaxNumPictureInPictureActions();
        return maxNumPictureInPictureActions;
    }

    @Override // android.app.Activity
    public android.view.MenuInflater getMenuInflater() {
        return this.mOriginActivity.getMenuInflater();
    }

    @Override // android.app.Activity
    public android.content.Intent getParentActivityIntent() {
        return this.mOriginActivity.getParentActivityIntent();
    }

    @Override // android.app.Activity
    public android.content.SharedPreferences getPreferences(int i) {
        return this.mOriginActivity.getPreferences(i);
    }

    @Override // android.app.Activity
    public android.net.Uri getReferrer() {
        android.net.Uri referrer;
        referrer = this.mOriginActivity.getReferrer();
        return referrer;
    }

    @Override // android.app.Activity
    public int getRequestedOrientation() {
        return this.mOriginActivity.getRequestedOrientation();
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public java.lang.Object getSystemService(java.lang.String str) {
        return this.pluginContext.getSystemService(str);
    }

    @Override // android.app.Activity
    public int getTaskId() {
        return this.mOriginActivity.getTaskId();
    }

    @Override // android.app.Activity
    public android.app.VoiceInteractor getVoiceInteractor() {
        android.app.VoiceInteractor voiceInteractor;
        voiceInteractor = this.mOriginActivity.getVoiceInteractor();
        return voiceInteractor;
    }

    @Override // android.app.Activity
    public android.view.Window getWindow() {
        return this.mOriginActivity.getWindow();
    }

    @Override // android.app.Activity
    public android.view.WindowManager getWindowManager() {
        return this.mOriginActivity.getWindowManager();
    }

    @Override // android.app.Activity
    public boolean hasWindowFocus() {
        return this.mOriginActivity.hasWindowFocus();
    }

    public int hashCode() {
        return this.mOriginActivity.hashCode();
    }

    @Override // android.app.Activity
    public void invalidateOptionsMenu() {
        this.mOriginActivity.invalidateOptionsMenu();
    }

    @Override // android.app.Activity
    public boolean isActivityTransitionRunning() {
        boolean isActivityTransitionRunning;
        isActivityTransitionRunning = this.mOriginActivity.isActivityTransitionRunning();
        return isActivityTransitionRunning;
    }

    @Override // android.app.Activity
    public boolean isChangingConfigurations() {
        return this.mOriginActivity.isChangingConfigurations();
    }

    @Override // android.app.Activity
    public boolean isDestroyed() {
        return this.mOriginActivity.isDestroyed();
    }

    @Override // android.app.Activity
    public boolean isFinishing() {
        return this.mOriginActivity.isFinishing();
    }

    @Override // android.app.Activity
    public boolean isImmersive() {
        return this.mOriginActivity.isImmersive();
    }

    @Override // android.app.Activity
    public boolean isInMultiWindowMode() {
        boolean isInMultiWindowMode;
        isInMultiWindowMode = this.mOriginActivity.isInMultiWindowMode();
        return isInMultiWindowMode;
    }

    @Override // android.app.Activity
    public boolean isInPictureInPictureMode() {
        boolean isInPictureInPictureMode;
        isInPictureInPictureMode = this.mOriginActivity.isInPictureInPictureMode();
        return isInPictureInPictureMode;
    }

    @Override // android.app.Activity
    public boolean isLocalVoiceInteractionSupported() {
        boolean isLocalVoiceInteractionSupported;
        isLocalVoiceInteractionSupported = this.mOriginActivity.isLocalVoiceInteractionSupported();
        return isLocalVoiceInteractionSupported;
    }

    @Override // android.app.Activity
    public boolean isTaskRoot() {
        return this.mOriginActivity.isTaskRoot();
    }

    @Override // android.app.Activity
    public boolean isVoiceInteraction() {
        boolean isVoiceInteraction;
        isVoiceInteraction = this.mOriginActivity.isVoiceInteraction();
        return isVoiceInteraction;
    }

    @Override // android.app.Activity
    public boolean isVoiceInteractionRoot() {
        boolean isVoiceInteractionRoot;
        isVoiceInteractionRoot = this.mOriginActivity.isVoiceInteractionRoot();
        return isVoiceInteractionRoot;
    }

    @Override // android.app.Activity
    public boolean moveTaskToBack(boolean z) {
        return this.mOriginActivity.moveTaskToBack(z);
    }

    @Override // android.app.Activity
    public boolean navigateUpTo(android.content.Intent intent) {
        return this.mOriginActivity.navigateUpTo(intent);
    }

    @Override // android.app.Activity
    public boolean navigateUpToFromChild(android.app.Activity activity, android.content.Intent intent) {
        return this.mOriginActivity.navigateUpToFromChild(activity, intent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onActionModeFinished(android.view.ActionMode actionMode) {
        this.mOriginActivity.onActionModeFinished(actionMode);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onActionModeStarted(android.view.ActionMode actionMode) {
        this.mOriginActivity.onActionModeStarted(actionMode);
    }

    @Override // android.app.Activity
    public void onActivityReenter(int i, android.content.Intent intent) {
        this.mOriginActivity.onActivityReenter(i, intent);
    }

    @Override // android.app.Activity
    public void onAttachFragment(android.app.Fragment fragment) {
        this.mOriginActivity.onAttachFragment(fragment);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        this.mOriginActivity.onAttachedToWindow();
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        this.mOriginActivity.onBackPressed();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(android.content.res.Configuration configuration) {
        this.mOriginActivity.onConfigurationChanged(configuration);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onContentChanged() {
        this.mOriginActivity.onContentChanged();
    }

    @Override // android.app.Activity
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public boolean onContextItemSelected(android.view.MenuItem menuItem) {
        boolean onContextItemSelected = this.mOriginActivity.onContextItemSelected(menuItem);
        com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackMenuItem(this, menuItem);
        return onContextItemSelected;
    }

    @Override // android.app.Activity
    public void onContextMenuClosed(android.view.Menu menu) {
        this.mOriginActivity.onContextMenuClosed(menu);
    }

    @Override // android.app.Activity
    public void onCreate(android.os.Bundle bundle, android.os.PersistableBundle persistableBundle) {
        this.mOriginActivity.onCreate(bundle, persistableBundle);
    }

    @Override // android.app.Activity, android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(android.view.ContextMenu contextMenu, android.view.View view, android.view.ContextMenu.ContextMenuInfo contextMenuInfo) {
        this.mOriginActivity.onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    @Override // android.app.Activity
    public java.lang.CharSequence onCreateDescription() {
        return this.mOriginActivity.onCreateDescription();
    }

    @Override // android.app.Activity
    public void onCreateNavigateUpTaskStack(android.app.TaskStackBuilder taskStackBuilder) {
        this.mOriginActivity.onCreateNavigateUpTaskStack(taskStackBuilder);
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        return this.mOriginActivity.onCreateOptionsMenu(menu);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onCreatePanelMenu(int i, android.view.Menu menu) {
        return this.mOriginActivity.onCreatePanelMenu(i, menu);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public android.view.View onCreatePanelView(int i) {
        return this.mOriginActivity.onCreatePanelView(i);
    }

    @Override // android.app.Activity
    public boolean onCreateThumbnail(android.graphics.Bitmap bitmap, android.graphics.Canvas canvas) {
        return this.mOriginActivity.onCreateThumbnail(bitmap, canvas);
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory2
    public android.view.View onCreateView(android.view.View view, java.lang.String str, android.content.Context context, android.util.AttributeSet attributeSet) {
        return this.mOriginActivity.onCreateView(view, str, context, attributeSet);
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory
    public android.view.View onCreateView(java.lang.String str, android.content.Context context, android.util.AttributeSet attributeSet) {
        return this.mOriginActivity.onCreateView(str, context, attributeSet);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onDetachedFromWindow() {
        this.mOriginActivity.onDetachedFromWindow();
    }

    @Override // android.app.Activity
    public void onEnterAnimationComplete() {
        this.mOriginActivity.onEnterAnimationComplete();
    }

    @Override // android.app.Activity
    public boolean onGenericMotionEvent(android.view.MotionEvent motionEvent) {
        return this.mOriginActivity.onGenericMotionEvent(motionEvent);
    }

    @Override // android.app.Activity
    public void onGetDirectActions(android.os.CancellationSignal cancellationSignal, java.util.function.Consumer consumer) {
        this.mOriginActivity.onGetDirectActions(cancellationSignal, consumer);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, android.view.KeyEvent keyEvent) {
        return this.mOriginActivity.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyLongPress(int i, android.view.KeyEvent keyEvent) {
        return this.mOriginActivity.onKeyLongPress(i, keyEvent);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyMultiple(int i, int i2, android.view.KeyEvent keyEvent) {
        return this.mOriginActivity.onKeyMultiple(i, i2, keyEvent);
    }

    @Override // android.app.Activity
    public boolean onKeyShortcut(int i, android.view.KeyEvent keyEvent) {
        return this.mOriginActivity.onKeyShortcut(i, keyEvent);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, android.view.KeyEvent keyEvent) {
        return this.mOriginActivity.onKeyUp(i, keyEvent);
    }

    @Override // android.app.Activity
    public void onLocalVoiceInteractionStarted() {
        this.mOriginActivity.onLocalVoiceInteractionStarted();
    }

    @Override // android.app.Activity
    public void onLocalVoiceInteractionStopped() {
        this.mOriginActivity.onLocalVoiceInteractionStopped();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onLowMemory() {
        this.mOriginActivity.onLowMemory();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i, android.view.MenuItem menuItem) {
        return this.mOriginActivity.onMenuItemSelected(i, menuItem);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuOpened(int i, android.view.Menu menu) {
        return this.mOriginActivity.onMenuOpened(i, menu);
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean z) {
        this.mOriginActivity.onMultiWindowModeChanged(z);
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean z, android.content.res.Configuration configuration) {
        this.mOriginActivity.onMultiWindowModeChanged(z, configuration);
    }

    @Override // android.app.Activity
    public boolean onNavigateUp() {
        return this.mOriginActivity.onNavigateUp();
    }

    @Override // android.app.Activity
    public boolean onNavigateUpFromChild(android.app.Activity activity) {
        return this.mOriginActivity.onNavigateUpFromChild(activity);
    }

    @Override // android.app.Activity
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onNewIntent(android.content.Intent intent) {
        super.onNewIntent(intent);
        com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper.onNewIntent(this, intent);
    }

    @Override // android.app.Activity
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public boolean onOptionsItemSelected(android.view.MenuItem menuItem) {
        boolean onOptionsItemSelected = this.mOriginActivity.onOptionsItemSelected(menuItem);
        com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackMenuItem(this, menuItem);
        return onOptionsItemSelected;
    }

    @Override // android.app.Activity
    public void onOptionsMenuClosed(android.view.Menu menu) {
        this.mOriginActivity.onOptionsMenuClosed(menu);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i, android.view.Menu menu) {
        this.mOriginActivity.onPanelClosed(i, menu);
    }

    @Override // android.app.Activity
    public void onPerformDirectAction(java.lang.String str, android.os.Bundle bundle, android.os.CancellationSignal cancellationSignal, java.util.function.Consumer consumer) {
        this.mOriginActivity.onPerformDirectAction(str, bundle, cancellationSignal, consumer);
    }

    @Override // android.app.Activity
    public void onPictureInPictureModeChanged(boolean z) {
        this.mOriginActivity.onPictureInPictureModeChanged(z);
    }

    @Override // android.app.Activity
    public void onPictureInPictureModeChanged(boolean z, android.content.res.Configuration configuration) {
        this.mOriginActivity.onPictureInPictureModeChanged(z, configuration);
    }

    @Override // android.app.Activity
    public boolean onPictureInPictureRequested() {
        boolean onPictureInPictureRequested;
        onPictureInPictureRequested = this.mOriginActivity.onPictureInPictureRequested();
        return onPictureInPictureRequested;
    }

    @Override // android.app.Activity
    public void onPostCreate(android.os.Bundle bundle, android.os.PersistableBundle persistableBundle) {
        this.mOriginActivity.onPostCreate(bundle, persistableBundle);
    }

    @Override // android.app.Activity
    public void onPrepareNavigateUpTaskStack(android.app.TaskStackBuilder taskStackBuilder) {
        this.mOriginActivity.onPrepareNavigateUpTaskStack(taskStackBuilder);
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(android.view.Menu menu) {
        return this.mOriginActivity.onPrepareOptionsMenu(menu);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onPreparePanel(int i, android.view.View view, android.view.Menu menu) {
        return this.mOriginActivity.onPreparePanel(i, view, menu);
    }

    @Override // android.app.Activity
    public void onProvideAssistContent(android.app.assist.AssistContent assistContent) {
        this.mOriginActivity.onProvideAssistContent(assistContent);
    }

    @Override // android.app.Activity
    public void onProvideAssistData(android.os.Bundle bundle) {
        this.mOriginActivity.onProvideAssistData(bundle);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onProvideKeyboardShortcuts(java.util.List list, android.view.Menu menu, int i) {
        this.mOriginActivity.onProvideKeyboardShortcuts(list, menu, i);
    }

    @Override // android.app.Activity
    public android.net.Uri onProvideReferrer() {
        android.net.Uri onProvideReferrer;
        onProvideReferrer = this.mOriginActivity.onProvideReferrer();
        return onProvideReferrer;
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, java.lang.String[] strArr, int[] iArr) {
        this.mOriginActivity.onRequestPermissionsResult(i, strArr, iArr);
    }

    @Override // android.app.Activity
    public void onRestoreInstanceState(android.os.Bundle bundle, android.os.PersistableBundle persistableBundle) {
        this.mOriginActivity.onRestoreInstanceState(bundle, persistableBundle);
    }

    @Override // android.app.Activity
    public java.lang.Object onRetainNonConfigurationInstance() {
        return this.mOriginActivity.onRetainNonConfigurationInstance();
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(android.os.Bundle bundle, android.os.PersistableBundle persistableBundle) {
        this.mOriginActivity.onSaveInstanceState(bundle, persistableBundle);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onSearchRequested() {
        return this.mOriginActivity.onSearchRequested();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onSearchRequested(android.view.SearchEvent searchEvent) {
        boolean onSearchRequested;
        onSearchRequested = this.mOriginActivity.onSearchRequested(searchEvent);
        return onSearchRequested;
    }

    @Override // android.app.Activity
    public void onStateNotSaved() {
        this.mOriginActivity.onStateNotSaved();
    }

    @Override // android.app.Activity
    public void onTopResumedActivityChanged(boolean z) {
        this.mOriginActivity.onTopResumedActivityChanged(z);
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        return this.mOriginActivity.onTouchEvent(motionEvent);
    }

    @Override // android.app.Activity
    public boolean onTrackballEvent(android.view.MotionEvent motionEvent) {
        return this.mOriginActivity.onTrackballEvent(motionEvent);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        this.mOriginActivity.onTrimMemory(i);
    }

    @Override // android.app.Activity
    public void onUserInteraction() {
        this.mOriginActivity.onUserInteraction();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowAttributesChanged(android.view.WindowManager.LayoutParams layoutParams) {
        this.mOriginActivity.onWindowAttributesChanged(layoutParams);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        this.mOriginActivity.onWindowFocusChanged(z);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public android.view.ActionMode onWindowStartingActionMode(android.view.ActionMode.Callback callback) {
        return this.mOriginActivity.onWindowStartingActionMode(callback);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public android.view.ActionMode onWindowStartingActionMode(android.view.ActionMode.Callback callback, int i) {
        android.view.ActionMode onWindowStartingActionMode;
        onWindowStartingActionMode = this.mOriginActivity.onWindowStartingActionMode(callback, i);
        return onWindowStartingActionMode;
    }

    @Override // android.app.Activity
    public void openContextMenu(android.view.View view) {
        this.mOriginActivity.openContextMenu(view);
    }

    @Override // android.app.Activity
    public void openOptionsMenu() {
        this.mOriginActivity.openOptionsMenu();
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        this.mOriginActivity.overridePendingTransition(i, i2);
    }

    @Override // android.app.Activity
    public void postponeEnterTransition() {
        this.mOriginActivity.postponeEnterTransition();
    }

    @Override // android.app.Activity
    public void recreate() {
        this.mOriginActivity.recreate();
    }

    @Override // android.app.Activity
    public void registerActivityLifecycleCallbacks(android.app.Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        this.mOriginActivity.registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
    }

    @Override // android.app.Activity
    public void registerForContextMenu(android.view.View view) {
        this.mOriginActivity.registerForContextMenu(view);
    }

    @Override // android.app.Activity
    public boolean releaseInstance() {
        return this.mOriginActivity.releaseInstance();
    }

    @Override // android.app.Activity
    public void reportFullyDrawn() {
        this.mOriginActivity.reportFullyDrawn();
    }

    @Override // android.app.Activity
    public android.view.DragAndDropPermissions requestDragAndDropPermissions(android.view.DragEvent dragEvent) {
        android.view.DragAndDropPermissions requestDragAndDropPermissions;
        requestDragAndDropPermissions = this.mOriginActivity.requestDragAndDropPermissions(dragEvent);
        return requestDragAndDropPermissions;
    }

    @Override // android.app.Activity
    public boolean requestVisibleBehind(boolean z) {
        return this.mOriginActivity.requestVisibleBehind(z);
    }

    @Override // android.app.Activity
    public void setActionBar(android.widget.Toolbar toolbar) {
        this.mOriginActivity.setActionBar(toolbar);
    }

    @Override // android.app.Activity
    public void setContentTransitionManager(android.transition.TransitionManager transitionManager) {
        this.mOriginActivity.setContentTransitionManager(transitionManager);
    }

    @Override // android.app.Activity
    public void setContentView(int i) {
        this.mOriginActivity.setContentView(i);
    }

    @Override // android.app.Activity
    public void setContentView(android.view.View view) {
        this.mOriginActivity.setContentView(view);
    }

    @Override // android.app.Activity
    public void setContentView(android.view.View view, android.view.ViewGroup.LayoutParams layoutParams) {
        this.mOriginActivity.setContentView(view, layoutParams);
    }

    @Override // android.app.Activity
    public void setEnterSharedElementCallback(android.app.SharedElementCallback sharedElementCallback) {
        this.mOriginActivity.setEnterSharedElementCallback(sharedElementCallback);
    }

    @Override // android.app.Activity
    public void setExitSharedElementCallback(android.app.SharedElementCallback sharedElementCallback) {
        this.mOriginActivity.setExitSharedElementCallback(sharedElementCallback);
    }

    @Override // android.app.Activity
    public void setFinishOnTouchOutside(boolean z) {
        this.mOriginActivity.setFinishOnTouchOutside(z);
    }

    @Override // android.app.Activity
    public void setImmersive(boolean z) {
        this.mOriginActivity.setImmersive(z);
    }

    @Override // android.app.Activity
    public void setInheritShowWhenLocked(boolean z) {
        this.mOriginActivity.setInheritShowWhenLocked(z);
    }

    @Override // android.app.Activity
    public void setIntent(android.content.Intent intent) {
        this.mOriginActivity.setIntent(intent);
    }

    @Override // android.app.Activity
    public void setLocusContext(android.content.LocusId locusId, android.os.Bundle bundle) {
        this.mOriginActivity.setLocusContext(locusId, bundle);
    }

    @Override // android.app.Activity
    public void setPictureInPictureParams(android.app.PictureInPictureParams pictureInPictureParams) {
        this.mOriginActivity.setPictureInPictureParams(pictureInPictureParams);
    }

    @Override // android.app.Activity
    public void setRequestedOrientation(int i) {
        this.mOriginActivity.setRequestedOrientation(i);
    }

    @Override // android.app.Activity
    public void setShowWhenLocked(boolean z) {
        this.mOriginActivity.setShowWhenLocked(z);
    }

    @Override // android.app.Activity
    public void setTaskDescription(android.app.ActivityManager.TaskDescription taskDescription) {
        this.mOriginActivity.setTaskDescription(taskDescription);
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public void setTheme(int i) {
        this.mOriginActivity.setTheme(i);
    }

    @Override // android.app.Activity
    public void setTitle(int i) {
        this.mOriginActivity.setTitle(i);
    }

    @Override // android.app.Activity
    public void setTitle(java.lang.CharSequence charSequence) {
        this.mOriginActivity.setTitle(charSequence);
    }

    @Override // android.app.Activity
    public void setTitleColor(int i) {
        this.mOriginActivity.setTitleColor(i);
    }

    @Override // android.app.Activity
    public boolean setTranslucent(boolean z) {
        boolean translucent;
        translucent = this.mOriginActivity.setTranslucent(z);
        return translucent;
    }

    @Override // android.app.Activity
    public void setTurnScreenOn(boolean z) {
        this.mOriginActivity.setTurnScreenOn(z);
    }

    @Override // android.app.Activity
    public void setVisible(boolean z) {
        this.mOriginActivity.setVisible(z);
    }

    @Override // android.app.Activity
    public void setVrModeEnabled(boolean z, android.content.ComponentName componentName) {
        this.mOriginActivity.setVrModeEnabled(z, componentName);
    }

    @Override // com.bytedance.pangle.wrapper.a
    public void setWrapperActivityTheme(int i) {
        try {
            super.setTheme(i);
        } catch (java.lang.Exception unused) {
        }
    }

    @Override // android.app.Activity
    public boolean shouldShowRequestPermissionRationale(java.lang.String str) {
        boolean shouldShowRequestPermissionRationale;
        shouldShowRequestPermissionRationale = this.mOriginActivity.shouldShowRequestPermissionRationale(str);
        return shouldShowRequestPermissionRationale;
    }

    @Override // android.app.Activity
    public boolean shouldUpRecreateTask(android.content.Intent intent) {
        return this.mOriginActivity.shouldUpRecreateTask(intent);
    }

    @Override // android.app.Activity
    public boolean showAssist(android.os.Bundle bundle) {
        boolean showAssist;
        showAssist = this.mOriginActivity.showAssist(bundle);
        return showAssist;
    }

    @Override // android.app.Activity
    public void showLockTaskEscapeMessage() {
        this.mOriginActivity.showLockTaskEscapeMessage();
    }

    @Override // android.app.Activity
    public android.view.ActionMode startActionMode(android.view.ActionMode.Callback callback) {
        return this.mOriginActivity.startActionMode(callback);
    }

    @Override // android.app.Activity
    public android.view.ActionMode startActionMode(android.view.ActionMode.Callback callback, int i) {
        android.view.ActionMode startActionMode;
        startActionMode = this.mOriginActivity.startActionMode(callback, i);
        return startActionMode;
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivities(android.content.Intent[] intentArr) {
        this.mOriginActivity.startActivities(intentArr);
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivities(android.content.Intent[] intentArr, android.os.Bundle bundle) {
        this.mOriginActivity.startActivities(intentArr, bundle);
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivity(android.content.Intent intent) {
        this.mOriginActivity.startActivity(intent);
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivity(android.content.Intent intent, android.os.Bundle bundle) {
        this.mOriginActivity.startActivity(intent, bundle);
    }

    @Override // android.app.Activity
    public void startActivityForResult(android.content.Intent intent, int i) {
        this.mOriginActivity.startActivityForResult(intent, i);
    }

    @Override // android.app.Activity
    public void startActivityForResult(android.content.Intent intent, int i, android.os.Bundle bundle) {
        this.mOriginActivity.startActivityForResult(intent, i, bundle);
    }

    @Override // android.app.Activity
    public void startActivityFromChild(android.app.Activity activity, android.content.Intent intent, int i) {
        this.mOriginActivity.startActivityFromChild(activity, intent, i);
    }

    @Override // android.app.Activity
    public void startActivityFromChild(android.app.Activity activity, android.content.Intent intent, int i, android.os.Bundle bundle) {
        this.mOriginActivity.startActivityFromChild(activity, intent, i, bundle);
    }

    @Override // android.app.Activity
    public void startActivityFromFragment(android.app.Fragment fragment, android.content.Intent intent, int i) {
        this.mOriginActivity.startActivityFromFragment(fragment, intent, i);
    }

    @Override // android.app.Activity
    public void startActivityFromFragment(android.app.Fragment fragment, android.content.Intent intent, int i, android.os.Bundle bundle) {
        this.mOriginActivity.startActivityFromFragment(fragment, intent, i, bundle);
    }

    @Override // android.app.Activity
    public boolean startActivityIfNeeded(android.content.Intent intent, int i) {
        return this.mOriginActivity.startActivityIfNeeded(intent, i);
    }

    @Override // android.app.Activity
    public boolean startActivityIfNeeded(android.content.Intent intent, int i, android.os.Bundle bundle) {
        return this.mOriginActivity.startActivityIfNeeded(intent, i, bundle);
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startIntentSender(android.content.IntentSender intentSender, android.content.Intent intent, int i, int i2, int i3) {
        this.mOriginActivity.startIntentSender(intentSender, intent, i, i2, i3);
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startIntentSender(android.content.IntentSender intentSender, android.content.Intent intent, int i, int i2, int i3, android.os.Bundle bundle) {
        this.mOriginActivity.startIntentSender(intentSender, intent, i, i2, i3, bundle);
    }

    @Override // android.app.Activity
    public void startIntentSenderForResult(android.content.IntentSender intentSender, int i, android.content.Intent intent, int i2, int i3, int i4) {
        this.mOriginActivity.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4);
    }

    @Override // android.app.Activity
    public void startIntentSenderForResult(android.content.IntentSender intentSender, int i, android.content.Intent intent, int i2, int i3, int i4, android.os.Bundle bundle) {
        this.mOriginActivity.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
    }

    @Override // android.app.Activity
    public void startIntentSenderFromChild(android.app.Activity activity, android.content.IntentSender intentSender, int i, android.content.Intent intent, int i2, int i3, int i4) {
        this.mOriginActivity.startIntentSenderFromChild(activity, intentSender, i, intent, i2, i3, i4);
    }

    @Override // android.app.Activity
    public void startIntentSenderFromChild(android.app.Activity activity, android.content.IntentSender intentSender, int i, android.content.Intent intent, int i2, int i3, int i4, android.os.Bundle bundle) {
        this.mOriginActivity.startIntentSenderFromChild(activity, intentSender, i, intent, i2, i3, i4, bundle);
    }

    @Override // android.app.Activity
    public void startLocalVoiceInteraction(android.os.Bundle bundle) {
        this.mOriginActivity.startLocalVoiceInteraction(bundle);
    }

    @Override // android.app.Activity
    public void startLockTask() {
        this.mOriginActivity.startLockTask();
    }

    @Override // android.app.Activity
    public void startManagingCursor(android.database.Cursor cursor) {
        this.mOriginActivity.startManagingCursor(cursor);
    }

    @Override // android.app.Activity
    public boolean startNextMatchingActivity(android.content.Intent intent) {
        return this.mOriginActivity.startNextMatchingActivity(intent);
    }

    @Override // android.app.Activity
    public boolean startNextMatchingActivity(android.content.Intent intent, android.os.Bundle bundle) {
        return this.mOriginActivity.startNextMatchingActivity(intent, bundle);
    }

    @Override // android.app.Activity
    public void startPostponedEnterTransition() {
        this.mOriginActivity.startPostponedEnterTransition();
    }

    @Override // android.app.Activity
    public void startSearch(java.lang.String str, boolean z, android.os.Bundle bundle, boolean z2) {
        this.mOriginActivity.startSearch(str, z, bundle, z2);
    }

    @Override // android.app.Activity
    public void stopLocalVoiceInteraction() {
        this.mOriginActivity.stopLocalVoiceInteraction();
    }

    @Override // android.app.Activity
    public void stopLockTask() {
        this.mOriginActivity.stopLockTask();
    }

    @Override // android.app.Activity
    public void stopManagingCursor(android.database.Cursor cursor) {
        this.mOriginActivity.stopManagingCursor(cursor);
    }

    @Override // android.app.Activity
    public void takeKeyEvents(boolean z) {
        this.mOriginActivity.takeKeyEvents(z);
    }

    @Override // android.app.Activity
    public void triggerSearch(java.lang.String str, android.os.Bundle bundle) {
        this.mOriginActivity.triggerSearch(str, bundle);
    }

    @Override // android.app.Activity
    public void unregisterActivityLifecycleCallbacks(android.app.Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        this.mOriginActivity.unregisterActivityLifecycleCallbacks(activityLifecycleCallbacks);
    }

    @Override // android.app.Activity
    public void unregisterForContextMenu(android.view.View view) {
        this.mOriginActivity.unregisterForContextMenu(view);
    }
}
