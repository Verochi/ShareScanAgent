package com.bytedance.pangle.activity;

@androidx.annotation.Keep
/* loaded from: classes12.dex */
public abstract class GenerateProxyActivity extends android.app.Activity implements com.bytedance.pangle.activity.b {
    public com.bytedance.pangle.plugin.Plugin mPlugin;
    public com.bytedance.pangle.activity.GeneratePluginActivity mTargetActivity;

    @Override // android.app.Activity
    public void addContentView(android.view.View view, android.view.ViewGroup.LayoutParams layoutParams) {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.addContentView(view, layoutParams);
        } else {
            super.addContentView(view, layoutParams);
        }
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(android.content.Context context) {
        com.bytedance.pangle.activity.c.a(this, context);
    }

    @Override // android.app.Activity
    public void closeContextMenu() {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.closeContextMenu();
        } else {
            super.closeContextMenu();
        }
    }

    @Override // android.app.Activity
    public void closeOptionsMenu() {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.closeOptionsMenu();
        } else {
            super.closeOptionsMenu();
        }
    }

    @Override // android.app.Activity
    public android.app.PendingIntent createPendingResult(int i, android.content.Intent intent, int i2) {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.createPendingResult(i, intent, i2) : super.createPendingResult(i, intent, i2);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchGenericMotionEvent(android.view.MotionEvent motionEvent) {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.dispatchGenericMotionEvent(motionEvent) : super.dispatchGenericMotionEvent(motionEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(android.view.KeyEvent keyEvent) {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.dispatchKeyEvent(keyEvent) : super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyShortcutEvent(android.view.KeyEvent keyEvent) {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.dispatchKeyShortcutEvent(keyEvent) : super.dispatchKeyShortcutEvent(keyEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchPopulateAccessibilityEvent(android.view.accessibility.AccessibilityEvent accessibilityEvent) {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.dispatchPopulateAccessibilityEvent(accessibilityEvent) : super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(android.view.MotionEvent motionEvent) {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.dispatchTouchEvent(motionEvent) : super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTrackballEvent(android.view.MotionEvent motionEvent) {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.dispatchTrackballEvent(motionEvent) : super.dispatchTrackballEvent(motionEvent);
    }

    @Override // android.app.Activity
    public void dump(java.lang.String str, java.io.FileDescriptor fileDescriptor, java.io.PrintWriter printWriter, java.lang.String[] strArr) {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.dump(str, fileDescriptor, printWriter, strArr);
        } else {
            super.dump(str, fileDescriptor, printWriter, strArr);
        }
    }

    @Override // android.app.Activity
    public void enterPictureInPictureMode() {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.enterPictureInPictureMode();
        } else {
            super.enterPictureInPictureMode();
        }
    }

    @Override // android.app.Activity
    public boolean enterPictureInPictureMode(android.app.PictureInPictureParams pictureInPictureParams) {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.enterPictureInPictureMode(pictureInPictureParams) : super.enterPictureInPictureMode(pictureInPictureParams);
    }

    @Override // android.app.Activity
    public android.view.View findViewById(int i) {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.findViewById(i) : super.findViewById(i);
    }

    @Override // android.app.Activity, com.bytedance.pangle.activity.b
    public void finish() {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.finish();
        } else {
            super.finish();
        }
    }

    @Override // android.app.Activity
    public void finishActivity(int i) {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.finishActivity(i);
        } else {
            super.finishActivity(i);
        }
    }

    @Override // android.app.Activity
    public void finishActivityFromChild(android.app.Activity activity, int i) {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.finishActivityFromChild(activity, i);
        } else {
            super.finishActivityFromChild(activity, i);
        }
    }

    @Override // android.app.Activity
    public void finishAffinity() {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.finishAffinity();
        } else {
            super.finishAffinity();
        }
    }

    @Override // android.app.Activity
    public void finishAfterTransition() {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.finishAfterTransition();
        } else {
            super.finishAfterTransition();
        }
    }

    @Override // android.app.Activity
    public void finishAndRemoveTask() {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.finishAndRemoveTask();
        } else {
            super.finishAndRemoveTask();
        }
    }

    @Override // android.app.Activity
    public void finishFromChild(android.app.Activity activity) {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.finishFromChild(activity);
        } else {
            super.finishFromChild(activity);
        }
    }

    @Override // android.app.Activity
    public android.app.ActionBar getActionBar() {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.getActionBar() : super.getActionBar();
    }

    @Override // android.app.Activity
    public android.content.ComponentName getCallingActivity() {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.getCallingActivity() : super.getCallingActivity();
    }

    @Override // android.app.Activity
    public java.lang.String getCallingPackage() {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.getCallingPackage() : super.getCallingPackage();
    }

    @Override // android.app.Activity
    public int getChangingConfigurations() {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.getChangingConfigurations() : super.getChangingConfigurations();
    }

    @Override // android.app.Activity
    public android.content.ComponentName getComponentName() {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.getComponentName() : super.getComponentName();
    }

    @Override // android.app.Activity
    public android.transition.Scene getContentScene() {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.getContentScene() : super.getContentScene();
    }

    @Override // android.app.Activity
    public android.transition.TransitionManager getContentTransitionManager() {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.getContentTransitionManager() : super.getContentTransitionManager();
    }

    @Override // android.app.Activity
    public android.view.View getCurrentFocus() {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.getCurrentFocus() : super.getCurrentFocus();
    }

    @Override // android.app.Activity
    public android.app.FragmentManager getFragmentManager() {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.getFragmentManager() : super.getFragmentManager();
    }

    @Override // android.app.Activity, com.bytedance.pangle.activity.b
    public android.content.Intent getIntent() {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.getIntent() : super.getIntent();
    }

    @Override // android.app.Activity
    public java.lang.Object getLastNonConfigurationInstance() {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.getLastNonConfigurationInstance() : super.getLastNonConfigurationInstance();
    }

    @Override // android.app.Activity
    public android.view.LayoutInflater getLayoutInflater() {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.getLayoutInflater() : super.getLayoutInflater();
    }

    @Override // android.app.Activity
    public android.app.LoaderManager getLoaderManager() {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.getLoaderManager() : super.getLoaderManager();
    }

    @Override // android.app.Activity
    public java.lang.String getLocalClassName() {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.getLocalClassName() : super.getLocalClassName();
    }

    @Override // android.app.Activity
    public int getMaxNumPictureInPictureActions() {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.getMaxNumPictureInPictureActions() : super.getMaxNumPictureInPictureActions();
    }

    @Override // android.app.Activity
    public android.view.MenuInflater getMenuInflater() {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.getMenuInflater() : super.getMenuInflater();
    }

    @Override // android.app.Activity
    public android.content.Intent getParentActivityIntent() {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.getParentActivityIntent() : super.getParentActivityIntent();
    }

    @Override // com.bytedance.pangle.activity.b
    public com.bytedance.pangle.plugin.Plugin getPlugin() {
        return this.mPlugin;
    }

    public abstract java.lang.String getPluginPkgName();

    @Override // android.app.Activity
    public android.content.SharedPreferences getPreferences(int i) {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.getPreferences(i) : super.getPreferences(i);
    }

    @Override // android.app.Activity
    public android.net.Uri getReferrer() {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.getReferrer() : super.getReferrer();
    }

    @Override // android.app.Activity
    public int getRequestedOrientation() {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.getRequestedOrientation() : super.getRequestedOrientation();
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public java.lang.Object getSystemService(java.lang.String str) {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.getSystemService(str) : super.getSystemService(str);
    }

    @Override // android.app.Activity
    public int getTaskId() {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.getTaskId() : super.getTaskId();
    }

    @Override // android.app.Activity
    public android.app.VoiceInteractor getVoiceInteractor() {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.getVoiceInteractor() : super.getVoiceInteractor();
    }

    @Override // android.app.Activity
    public android.view.Window getWindow() {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.getWindow() : super.getWindow();
    }

    @Override // android.app.Activity
    public android.view.WindowManager getWindowManager() {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.getWindowManager() : super.getWindowManager();
    }

    @Override // android.app.Activity
    public boolean hasWindowFocus() {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.hasWindowFocus() : super.hasWindowFocus();
    }

    @Override // android.app.Activity
    public void invalidateOptionsMenu() {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.invalidateOptionsMenu();
        } else {
            super.invalidateOptionsMenu();
        }
    }

    @Override // android.app.Activity
    public boolean isActivityTransitionRunning() {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.isActivityTransitionRunning() : super.isActivityTransitionRunning();
    }

    @Override // android.app.Activity
    public boolean isChangingConfigurations() {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.isChangingConfigurations() : super.isChangingConfigurations();
    }

    @Override // android.app.Activity
    public boolean isDestroyed() {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.isDestroyed() : super.isDestroyed();
    }

    @Override // android.app.Activity
    public boolean isFinishing() {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.isFinishing() : super.isFinishing();
    }

    @Override // android.app.Activity
    public boolean isImmersive() {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.isImmersive() : super.isImmersive();
    }

    @Override // android.app.Activity
    public boolean isInMultiWindowMode() {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.isInMultiWindowMode() : super.isInMultiWindowMode();
    }

    @Override // android.app.Activity
    public boolean isInPictureInPictureMode() {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.isInPictureInPictureMode() : super.isInPictureInPictureMode();
    }

    @Override // android.app.Activity
    public boolean isLocalVoiceInteractionSupported() {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.isLocalVoiceInteractionSupported() : super.isLocalVoiceInteractionSupported();
    }

    @Override // android.app.Activity
    public boolean isTaskRoot() {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.isTaskRoot() : super.isTaskRoot();
    }

    @Override // android.app.Activity
    public boolean isVoiceInteraction() {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.isVoiceInteraction() : super.isVoiceInteraction();
    }

    @Override // android.app.Activity
    public boolean isVoiceInteractionRoot() {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.isVoiceInteractionRoot() : super.isVoiceInteractionRoot();
    }

    @Override // android.app.Activity
    public boolean moveTaskToBack(boolean z) {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.moveTaskToBack(z) : super.moveTaskToBack(z);
    }

    @Override // android.app.Activity
    public boolean navigateUpTo(android.content.Intent intent) {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.navigateUpTo(intent) : super.navigateUpTo(intent);
    }

    @Override // android.app.Activity
    public boolean navigateUpToFromChild(android.app.Activity activity, android.content.Intent intent) {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.navigateUpToFromChild(activity, intent) : super.navigateUpToFromChild(activity, intent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onActionModeFinished(android.view.ActionMode actionMode) {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.onActionModeFinished(actionMode);
        } else {
            super.onActionModeFinished(actionMode);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onActionModeStarted(android.view.ActionMode actionMode) {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.onActionModeStarted(actionMode);
        } else {
            super.onActionModeStarted(actionMode);
        }
    }

    @Override // android.app.Activity
    public void onActivityReenter(int i, android.content.Intent intent) {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.onActivityReenter(i, intent);
        } else {
            super.onActivityReenter(i, intent);
        }
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, android.content.Intent intent) {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.onActivityResult(i, i2, intent);
        } else {
            super.onActivityResult(i, i2, intent);
        }
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper
    public void onApplyThemeResource(android.content.res.Resources.Theme theme, int i, boolean z) {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.onApplyThemeResource(theme, i, z);
        } else {
            super.onApplyThemeResource(theme, i, z);
        }
    }

    @Override // android.app.Activity
    public void onAttachFragment(android.app.Fragment fragment) {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.onAttachFragment(fragment);
        } else {
            super.onAttachFragment(fragment);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.onAttachedToWindow();
        } else {
            super.onAttachedToWindow();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.onBackPressed();
        } else {
            super.onBackPressed();
        }
    }

    @Override // android.app.Activity
    public void onChildTitleChanged(android.app.Activity activity, java.lang.CharSequence charSequence) {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.onChildTitleChanged(activity, charSequence);
        } else {
            super.onChildTitleChanged(activity, charSequence);
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(android.content.res.Configuration configuration) {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.onConfigurationChanged(configuration);
        } else {
            super.onConfigurationChanged(configuration);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onContentChanged() {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.onContentChanged();
        } else {
            super.onContentChanged();
        }
    }

    @Override // android.app.Activity
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public boolean onContextItemSelected(android.view.MenuItem menuItem) {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            boolean onContextItemSelected = generatePluginActivity.onContextItemSelected(menuItem);
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackMenuItem(this, menuItem);
            return onContextItemSelected;
        }
        boolean onContextItemSelected2 = super.onContextItemSelected(menuItem);
        com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackMenuItem(this, menuItem);
        return onContextItemSelected2;
    }

    @Override // android.app.Activity
    public void onContextMenuClosed(android.view.Menu menu) {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.onContextMenuClosed(menu);
        } else {
            super.onContextMenuClosed(menu);
        }
    }

    @Override // android.app.Activity
    public void onCreate(android.os.Bundle bundle) {
        com.bytedance.pangle.activity.c.a(this, bundle);
    }

    @Override // android.app.Activity
    public void onCreate(android.os.Bundle bundle, android.os.PersistableBundle persistableBundle) {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.onCreate(bundle, persistableBundle);
        } else {
            super.onCreate(bundle, persistableBundle);
        }
    }

    @Override // android.app.Activity, android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(android.view.ContextMenu contextMenu, android.view.View view, android.view.ContextMenu.ContextMenuInfo contextMenuInfo) {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        } else {
            super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        }
    }

    @Override // android.app.Activity
    public java.lang.CharSequence onCreateDescription() {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.onCreateDescription() : super.onCreateDescription();
    }

    @Override // android.app.Activity
    public android.app.Dialog onCreateDialog(int i) {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.onCreateDialog(i) : super.onCreateDialog(i);
    }

    @Override // android.app.Activity
    public android.app.Dialog onCreateDialog(int i, android.os.Bundle bundle) {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.onCreateDialog(i, bundle) : super.onCreateDialog(i, bundle);
    }

    @Override // android.app.Activity
    public void onCreateNavigateUpTaskStack(android.app.TaskStackBuilder taskStackBuilder) {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.onCreateNavigateUpTaskStack(taskStackBuilder);
        } else {
            super.onCreateNavigateUpTaskStack(taskStackBuilder);
        }
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.onCreateOptionsMenu(menu) : super.onCreateOptionsMenu(menu);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onCreatePanelMenu(int i, android.view.Menu menu) {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.onCreatePanelMenu(i, menu) : super.onCreatePanelMenu(i, menu);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public android.view.View onCreatePanelView(int i) {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.onCreatePanelView(i) : super.onCreatePanelView(i);
    }

    @Override // android.app.Activity
    public boolean onCreateThumbnail(android.graphics.Bitmap bitmap, android.graphics.Canvas canvas) {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.onCreateThumbnail(bitmap, canvas) : super.onCreateThumbnail(bitmap, canvas);
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory2
    public android.view.View onCreateView(android.view.View view, java.lang.String str, android.content.Context context, android.util.AttributeSet attributeSet) {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.onCreateView(view, str, context, attributeSet) : super.onCreateView(view, str, context, attributeSet);
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory
    public android.view.View onCreateView(java.lang.String str, android.content.Context context, android.util.AttributeSet attributeSet) {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.onCreateView(str, context, attributeSet) : super.onCreateView(str, context, attributeSet);
    }

    @Override // android.app.Activity
    public void onDestroy() {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.onDestroy();
        } else {
            super.onDestroy();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onDetachedFromWindow() {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.onDetachedFromWindow();
        } else {
            super.onDetachedFromWindow();
        }
    }

    @Override // android.app.Activity
    public void onEnterAnimationComplete() {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.onEnterAnimationComplete();
        } else {
            super.onEnterAnimationComplete();
        }
    }

    @Override // android.app.Activity
    public boolean onGenericMotionEvent(android.view.MotionEvent motionEvent) {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.onGenericMotionEvent(motionEvent) : super.onGenericMotionEvent(motionEvent);
    }

    @Override // android.app.Activity
    public void onGetDirectActions(android.os.CancellationSignal cancellationSignal, java.util.function.Consumer consumer) {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.onGetDirectActions(cancellationSignal, consumer);
        } else {
            super.onGetDirectActions(cancellationSignal, consumer);
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, android.view.KeyEvent keyEvent) {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.onKeyDown(i, keyEvent) : super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyLongPress(int i, android.view.KeyEvent keyEvent) {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.onKeyLongPress(i, keyEvent) : super.onKeyLongPress(i, keyEvent);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyMultiple(int i, int i2, android.view.KeyEvent keyEvent) {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.onKeyMultiple(i, i2, keyEvent) : super.onKeyMultiple(i, i2, keyEvent);
    }

    @Override // android.app.Activity
    public boolean onKeyShortcut(int i, android.view.KeyEvent keyEvent) {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.onKeyShortcut(i, keyEvent) : super.onKeyShortcut(i, keyEvent);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, android.view.KeyEvent keyEvent) {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.onKeyUp(i, keyEvent) : super.onKeyUp(i, keyEvent);
    }

    @Override // android.app.Activity
    public void onLocalVoiceInteractionStarted() {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.onLocalVoiceInteractionStarted();
        } else {
            super.onLocalVoiceInteractionStarted();
        }
    }

    @Override // android.app.Activity
    public void onLocalVoiceInteractionStopped() {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.onLocalVoiceInteractionStopped();
        } else {
            super.onLocalVoiceInteractionStopped();
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onLowMemory() {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.onLowMemory();
        } else {
            super.onLowMemory();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuOpened(int i, android.view.Menu menu) {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.onMenuOpened(i, menu) : super.onMenuOpened(i, menu);
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean z) {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.onMultiWindowModeChanged(z);
        } else {
            super.onMultiWindowModeChanged(z);
        }
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean z, android.content.res.Configuration configuration) {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.onMultiWindowModeChanged(z, configuration);
        } else {
            super.onMultiWindowModeChanged(z, configuration);
        }
    }

    @Override // android.app.Activity
    public boolean onNavigateUp() {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.onNavigateUp() : super.onNavigateUp();
    }

    @Override // android.app.Activity
    public boolean onNavigateUpFromChild(android.app.Activity activity) {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.onNavigateUpFromChild(activity) : super.onNavigateUpFromChild(activity);
    }

    @Override // android.app.Activity
    public void onNewIntent(android.content.Intent intent) {
        com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper.onNewIntent(this, intent);
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.onNewIntent(intent);
        } else {
            super.onNewIntent(intent);
        }
    }

    @Override // android.app.Activity
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public boolean onOptionsItemSelected(android.view.MenuItem menuItem) {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            boolean onOptionsItemSelected = generatePluginActivity.onOptionsItemSelected(menuItem);
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackMenuItem(this, menuItem);
            return onOptionsItemSelected;
        }
        boolean onOptionsItemSelected2 = super.onOptionsItemSelected(menuItem);
        com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackMenuItem(this, menuItem);
        return onOptionsItemSelected2;
    }

    @Override // android.app.Activity
    public void onOptionsMenuClosed(android.view.Menu menu) {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.onOptionsMenuClosed(menu);
        } else {
            super.onOptionsMenuClosed(menu);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i, android.view.Menu menu) {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.onPanelClosed(i, menu);
        } else {
            super.onPanelClosed(i, menu);
        }
    }

    @Override // android.app.Activity
    public void onPause() {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.onPause();
        } else {
            super.onPause();
        }
    }

    @Override // android.app.Activity
    public void onPerformDirectAction(java.lang.String str, android.os.Bundle bundle, android.os.CancellationSignal cancellationSignal, java.util.function.Consumer consumer) {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.onPerformDirectAction(str, bundle, cancellationSignal, consumer);
        } else {
            super.onPerformDirectAction(str, bundle, cancellationSignal, consumer);
        }
    }

    @Override // android.app.Activity
    public void onPictureInPictureModeChanged(boolean z) {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.onPictureInPictureModeChanged(z);
        } else {
            super.onPictureInPictureModeChanged(z);
        }
    }

    @Override // android.app.Activity
    public void onPictureInPictureModeChanged(boolean z, android.content.res.Configuration configuration) {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.onPictureInPictureModeChanged(z, configuration);
        } else {
            super.onPictureInPictureModeChanged(z, configuration);
        }
    }

    @Override // android.app.Activity
    public boolean onPictureInPictureRequested() {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.onPictureInPictureRequested() : super.onPictureInPictureRequested();
    }

    @Override // android.app.Activity
    public void onPostCreate(android.os.Bundle bundle) {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.onPostCreate(bundle);
        } else {
            super.onPostCreate(bundle);
        }
    }

    @Override // android.app.Activity
    public void onPostCreate(android.os.Bundle bundle, android.os.PersistableBundle persistableBundle) {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.onPostCreate(bundle, persistableBundle);
        } else {
            super.onPostCreate(bundle, persistableBundle);
        }
    }

    @Override // android.app.Activity
    public void onPostResume() {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.onPostResume();
        } else {
            super.onPostResume();
        }
    }

    @Override // android.app.Activity
    public void onPrepareDialog(int i, android.app.Dialog dialog) {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.onPrepareDialog(i, dialog);
        } else {
            super.onPrepareDialog(i, dialog);
        }
    }

    @Override // android.app.Activity
    public void onPrepareDialog(int i, android.app.Dialog dialog, android.os.Bundle bundle) {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.onPrepareDialog(i, dialog, bundle);
        } else {
            super.onPrepareDialog(i, dialog, bundle);
        }
    }

    @Override // android.app.Activity
    public void onPrepareNavigateUpTaskStack(android.app.TaskStackBuilder taskStackBuilder) {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.onPrepareNavigateUpTaskStack(taskStackBuilder);
        } else {
            super.onPrepareNavigateUpTaskStack(taskStackBuilder);
        }
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(android.view.Menu menu) {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.onPrepareOptionsMenu(menu) : super.onPrepareOptionsMenu(menu);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onPreparePanel(int i, android.view.View view, android.view.Menu menu) {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.onPreparePanel(i, view, menu) : super.onPreparePanel(i, view, menu);
    }

    @Override // android.app.Activity
    public void onProvideAssistContent(android.app.assist.AssistContent assistContent) {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.onProvideAssistContent(assistContent);
        } else {
            super.onProvideAssistContent(assistContent);
        }
    }

    @Override // android.app.Activity
    public void onProvideAssistData(android.os.Bundle bundle) {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.onProvideAssistData(bundle);
        } else {
            super.onProvideAssistData(bundle);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onProvideKeyboardShortcuts(java.util.List list, android.view.Menu menu, int i) {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.onProvideKeyboardShortcuts(list, menu, i);
        } else {
            super.onProvideKeyboardShortcuts(list, menu, i);
        }
    }

    @Override // android.app.Activity
    public android.net.Uri onProvideReferrer() {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.onProvideReferrer() : super.onProvideReferrer();
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, java.lang.String[] strArr, int[] iArr) {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.onRequestPermissionsResult(i, strArr, iArr);
        } else {
            super.onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    @Override // android.app.Activity
    public void onRestart() {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.onRestart();
        } else {
            super.onRestart();
        }
    }

    @Override // android.app.Activity
    public void onRestoreInstanceState(android.os.Bundle bundle) {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.onRestoreInstanceState(bundle);
        } else {
            super.onRestoreInstanceState(bundle);
        }
    }

    @Override // android.app.Activity
    public void onRestoreInstanceState(android.os.Bundle bundle, android.os.PersistableBundle persistableBundle) {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.onRestoreInstanceState(bundle, persistableBundle);
        } else {
            super.onRestoreInstanceState(bundle, persistableBundle);
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.onResume();
        } else {
            super.onResume();
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(android.os.Bundle bundle) {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.onSaveInstanceState(bundle);
        } else {
            super.onSaveInstanceState(bundle);
        }
        bundle.clear();
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(android.os.Bundle bundle, android.os.PersistableBundle persistableBundle) {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.onSaveInstanceState(bundle, persistableBundle);
        } else {
            super.onSaveInstanceState(bundle, persistableBundle);
        }
        bundle.clear();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onSearchRequested() {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.onSearchRequested() : super.onSearchRequested();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onSearchRequested(android.view.SearchEvent searchEvent) {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.onSearchRequested(searchEvent) : super.onSearchRequested(searchEvent);
    }

    @Override // android.app.Activity
    public void onStart() {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.onStart();
        } else {
            super.onStart();
        }
    }

    @Override // android.app.Activity
    public void onStateNotSaved() {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.onStateNotSaved();
        } else {
            super.onStateNotSaved();
        }
    }

    @Override // android.app.Activity
    public void onStop() {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.onStop();
        } else {
            super.onStop();
        }
    }

    @Override // android.app.Activity
    public void onTitleChanged(java.lang.CharSequence charSequence, int i) {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.onTitleChanged(charSequence, i);
        } else {
            super.onTitleChanged(charSequence, i);
        }
    }

    @Override // android.app.Activity
    public void onTopResumedActivityChanged(boolean z) {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.onTopResumedActivityChanged(z);
        } else {
            super.onTopResumedActivityChanged(z);
        }
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.onTouchEvent(motionEvent) : super.onTouchEvent(motionEvent);
    }

    @Override // android.app.Activity
    public boolean onTrackballEvent(android.view.MotionEvent motionEvent) {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.onTrackballEvent(motionEvent) : super.onTrackballEvent(motionEvent);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.onTrimMemory(i);
        } else {
            super.onTrimMemory(i);
        }
    }

    @Override // android.app.Activity
    public void onUserInteraction() {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.onUserInteraction();
        } else {
            super.onUserInteraction();
        }
    }

    @Override // android.app.Activity
    public void onUserLeaveHint() {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.onUserLeaveHint();
        } else {
            super.onUserLeaveHint();
        }
    }

    @Override // android.app.Activity
    public void onVisibleBehindCanceled() {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.onVisibleBehindCanceled();
        } else {
            super.onVisibleBehindCanceled();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowAttributesChanged(android.view.WindowManager.LayoutParams layoutParams) {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.onWindowAttributesChanged(layoutParams);
        } else {
            super.onWindowAttributesChanged(layoutParams);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.onWindowFocusChanged(z);
        } else {
            super.onWindowFocusChanged(z);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public android.view.ActionMode onWindowStartingActionMode(android.view.ActionMode.Callback callback) {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.onWindowStartingActionMode(callback) : super.onWindowStartingActionMode(callback);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public android.view.ActionMode onWindowStartingActionMode(android.view.ActionMode.Callback callback, int i) {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.onWindowStartingActionMode(callback, i) : super.onWindowStartingActionMode(callback, i);
    }

    @Override // android.app.Activity
    public void openContextMenu(android.view.View view) {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.openContextMenu(view);
        } else {
            super.openContextMenu(view);
        }
    }

    @Override // android.app.Activity
    public void openOptionsMenu() {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.openOptionsMenu();
        } else {
            super.openOptionsMenu();
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.overridePendingTransition(i, i2);
        } else {
            super.overridePendingTransition(i, i2);
        }
    }

    @Override // android.app.Activity
    public void postponeEnterTransition() {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.postponeEnterTransition();
        } else {
            super.postponeEnterTransition();
        }
    }

    @Override // android.app.Activity
    public void recreate() {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.recreate();
        } else {
            super.recreate();
        }
    }

    @Override // android.app.Activity
    public void registerActivityLifecycleCallbacks(android.app.Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
        } else {
            super.registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
        }
    }

    @Override // android.app.Activity
    public void registerForContextMenu(android.view.View view) {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.registerForContextMenu(view);
        } else {
            super.registerForContextMenu(view);
        }
    }

    @Override // android.app.Activity
    public boolean releaseInstance() {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.releaseInstance() : super.releaseInstance();
    }

    @Override // android.app.Activity
    public void reportFullyDrawn() {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.reportFullyDrawn();
        } else {
            super.reportFullyDrawn();
        }
    }

    @Override // android.app.Activity
    public android.view.DragAndDropPermissions requestDragAndDropPermissions(android.view.DragEvent dragEvent) {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.requestDragAndDropPermissions(dragEvent) : super.requestDragAndDropPermissions(dragEvent);
    }

    @Override // android.app.Activity
    public boolean requestVisibleBehind(boolean z) {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.requestVisibleBehind(z) : super.requestVisibleBehind(z);
    }

    @Override // android.app.Activity
    public void setActionBar(android.widget.Toolbar toolbar) {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.setActionBar(toolbar);
        } else {
            super.setActionBar(toolbar);
        }
    }

    @Override // android.app.Activity
    public void setContentTransitionManager(android.transition.TransitionManager transitionManager) {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.setContentTransitionManager(transitionManager);
        } else {
            super.setContentTransitionManager(transitionManager);
        }
    }

    @Override // android.app.Activity
    public void setContentView(int i) {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.setContentView(i);
        } else {
            super.setContentView(i);
        }
    }

    @Override // android.app.Activity
    public void setContentView(android.view.View view) {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.setContentView(view);
        } else {
            super.setContentView(view);
        }
    }

    @Override // android.app.Activity
    public void setContentView(android.view.View view, android.view.ViewGroup.LayoutParams layoutParams) {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.setContentView(view, layoutParams);
        } else {
            super.setContentView(view, layoutParams);
        }
    }

    @Override // android.app.Activity
    public void setEnterSharedElementCallback(android.app.SharedElementCallback sharedElementCallback) {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.setEnterSharedElementCallback(sharedElementCallback);
        } else {
            super.setEnterSharedElementCallback(sharedElementCallback);
        }
    }

    @Override // android.app.Activity
    public void setExitSharedElementCallback(android.app.SharedElementCallback sharedElementCallback) {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.setExitSharedElementCallback(sharedElementCallback);
        } else {
            super.setExitSharedElementCallback(sharedElementCallback);
        }
    }

    @Override // android.app.Activity
    public void setFinishOnTouchOutside(boolean z) {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.setFinishOnTouchOutside(z);
        } else {
            super.setFinishOnTouchOutside(z);
        }
    }

    @Override // android.app.Activity
    public void setImmersive(boolean z) {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.setImmersive(z);
        } else {
            super.setImmersive(z);
        }
    }

    @Override // android.app.Activity
    public void setInheritShowWhenLocked(boolean z) {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.setInheritShowWhenLocked(z);
        } else {
            super.setInheritShowWhenLocked(z);
        }
    }

    @Override // android.app.Activity
    public void setIntent(android.content.Intent intent) {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.setIntent(intent);
        } else {
            super.setIntent(intent);
        }
    }

    @Override // android.app.Activity
    public void setLocusContext(android.content.LocusId locusId, android.os.Bundle bundle) {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.setLocusContext(locusId, bundle);
        } else {
            super.setLocusContext(locusId, bundle);
        }
    }

    @Override // android.app.Activity
    public void setPictureInPictureParams(android.app.PictureInPictureParams pictureInPictureParams) {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.setPictureInPictureParams(pictureInPictureParams);
        } else {
            super.setPictureInPictureParams(pictureInPictureParams);
        }
    }

    @Override // com.bytedance.pangle.activity.b
    public void setPlugin(com.bytedance.pangle.plugin.Plugin plugin) {
        this.mPlugin = plugin;
    }

    @Override // android.app.Activity
    public void setRequestedOrientation(int i) {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.setRequestedOrientation(i);
        } else {
            super.setRequestedOrientation(i);
        }
    }

    @Override // android.app.Activity
    public void setShowWhenLocked(boolean z) {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.setShowWhenLocked(z);
        } else {
            super.setShowWhenLocked(z);
        }
    }

    @Override // com.bytedance.pangle.activity.b
    public void setTargetActivity(com.bytedance.pangle.activity.IPluginActivity iPluginActivity) {
        this.mTargetActivity = (com.bytedance.pangle.activity.GeneratePluginActivity) iPluginActivity;
    }

    @Override // android.app.Activity
    public void setTaskDescription(android.app.ActivityManager.TaskDescription taskDescription) {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.setTaskDescription(taskDescription);
        } else {
            super.setTaskDescription(taskDescription);
        }
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public void setTheme(int i) {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.setTheme(i);
        } else {
            super.setTheme(i);
        }
    }

    @Override // android.app.Activity
    public void setTitle(int i) {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.setTitle(i);
        } else {
            super.setTitle(i);
        }
    }

    @Override // android.app.Activity
    public void setTitle(java.lang.CharSequence charSequence) {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.setTitle(charSequence);
        } else {
            super.setTitle(charSequence);
        }
    }

    @Override // android.app.Activity
    public void setTitleColor(int i) {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.setTitleColor(i);
        } else {
            super.setTitleColor(i);
        }
    }

    @Override // android.app.Activity
    public boolean setTranslucent(boolean z) {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.setTranslucent(z) : super.setTranslucent(z);
    }

    @Override // android.app.Activity
    public void setTurnScreenOn(boolean z) {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.setTurnScreenOn(z);
        } else {
            super.setTurnScreenOn(z);
        }
    }

    @Override // android.app.Activity
    public void setVisible(boolean z) {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.setVisible(z);
        } else {
            super.setVisible(z);
        }
    }

    @Override // android.app.Activity
    public void setVrModeEnabled(boolean z, android.content.ComponentName componentName) {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.setVrModeEnabled(z, componentName);
        } else {
            super.setVrModeEnabled(z, componentName);
        }
    }

    @Override // android.app.Activity
    public boolean shouldShowRequestPermissionRationale(java.lang.String str) {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.shouldShowRequestPermissionRationale(str) : super.shouldShowRequestPermissionRationale(str);
    }

    @Override // android.app.Activity
    public boolean shouldUpRecreateTask(android.content.Intent intent) {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.shouldUpRecreateTask(intent) : super.shouldUpRecreateTask(intent);
    }

    @Override // android.app.Activity
    public boolean showAssist(android.os.Bundle bundle) {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.showAssist(bundle) : super.showAssist(bundle);
    }

    @Override // android.app.Activity
    public void showLockTaskEscapeMessage() {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.showLockTaskEscapeMessage();
        } else {
            super.showLockTaskEscapeMessage();
        }
    }

    @Override // android.app.Activity
    public android.view.ActionMode startActionMode(android.view.ActionMode.Callback callback) {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.startActionMode(callback) : super.startActionMode(callback);
    }

    @Override // android.app.Activity
    public android.view.ActionMode startActionMode(android.view.ActionMode.Callback callback, int i) {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.startActionMode(callback, i) : super.startActionMode(callback, i);
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivities(android.content.Intent[] intentArr) {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.startActivities(intentArr);
        } else {
            super.startActivities(intentArr);
        }
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivities(android.content.Intent[] intentArr, android.os.Bundle bundle) {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.startActivities(intentArr, bundle);
        } else {
            super.startActivities(intentArr, bundle);
        }
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivity(android.content.Intent intent) {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.startActivity(intent);
        } else {
            super.startActivity(intent);
        }
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivity(android.content.Intent intent, android.os.Bundle bundle) {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.startActivity(intent, bundle);
        } else {
            super.startActivity(intent, bundle);
        }
    }

    @Override // android.app.Activity
    public void startActivityForResult(android.content.Intent intent, int i) {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.startActivityForResult(intent, i);
        } else {
            super.startActivityForResult(intent, i);
        }
    }

    @Override // android.app.Activity
    public void startActivityForResult(android.content.Intent intent, int i, android.os.Bundle bundle) {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.startActivityForResult(intent, i, bundle);
        } else {
            super.startActivityForResult(intent, i, bundle);
        }
    }

    public void startActivityForResult(java.lang.String str, android.content.Intent intent, int i, android.os.Bundle bundle) {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.startActivityForResult(intent, i, bundle);
        } else {
            super.startActivityForResult(intent, i, bundle);
        }
    }

    @Override // android.app.Activity
    public void startActivityFromChild(android.app.Activity activity, android.content.Intent intent, int i) {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.startActivityFromChild(activity, intent, i);
        } else {
            super.startActivityFromChild(activity, intent, i);
        }
    }

    @Override // android.app.Activity
    public void startActivityFromChild(android.app.Activity activity, android.content.Intent intent, int i, android.os.Bundle bundle) {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.startActivityFromChild(activity, intent, i, bundle);
        } else {
            super.startActivityFromChild(activity, intent, i, bundle);
        }
    }

    @Override // android.app.Activity
    public void startActivityFromFragment(android.app.Fragment fragment, android.content.Intent intent, int i) {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.startActivityFromFragment(fragment, intent, i);
        } else {
            super.startActivityFromFragment(fragment, intent, i);
        }
    }

    @Override // android.app.Activity
    public void startActivityFromFragment(android.app.Fragment fragment, android.content.Intent intent, int i, android.os.Bundle bundle) {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.startActivityFromFragment(fragment, intent, i, bundle);
        } else {
            super.startActivityFromFragment(fragment, intent, i, bundle);
        }
    }

    @Override // android.app.Activity
    public boolean startActivityIfNeeded(android.content.Intent intent, int i) {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.startActivityIfNeeded(intent, i) : super.startActivityIfNeeded(intent, i);
    }

    @Override // android.app.Activity
    public boolean startActivityIfNeeded(android.content.Intent intent, int i, android.os.Bundle bundle) {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.startActivityIfNeeded(intent, i, bundle) : super.startActivityIfNeeded(intent, i, bundle);
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startIntentSender(android.content.IntentSender intentSender, android.content.Intent intent, int i, int i2, int i3) {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.startIntentSender(intentSender, intent, i, i2, i3);
        } else {
            super.startIntentSender(intentSender, intent, i, i2, i3);
        }
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startIntentSender(android.content.IntentSender intentSender, android.content.Intent intent, int i, int i2, int i3, android.os.Bundle bundle) {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.startIntentSender(intentSender, intent, i, i2, i3, bundle);
        } else {
            super.startIntentSender(intentSender, intent, i, i2, i3, bundle);
        }
    }

    @Override // android.app.Activity
    public void startIntentSenderForResult(android.content.IntentSender intentSender, int i, android.content.Intent intent, int i2, int i3, int i4) {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4);
        } else {
            super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4);
        }
    }

    @Override // android.app.Activity
    public void startIntentSenderForResult(android.content.IntentSender intentSender, int i, android.content.Intent intent, int i2, int i3, int i4, android.os.Bundle bundle) {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
        } else {
            super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
        }
    }

    @Override // android.app.Activity
    public void startIntentSenderFromChild(android.app.Activity activity, android.content.IntentSender intentSender, int i, android.content.Intent intent, int i2, int i3, int i4) {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.startIntentSenderFromChild(activity, intentSender, i, intent, i2, i3, i4);
        } else {
            super.startIntentSenderFromChild(activity, intentSender, i, intent, i2, i3, i4);
        }
    }

    @Override // android.app.Activity
    public void startIntentSenderFromChild(android.app.Activity activity, android.content.IntentSender intentSender, int i, android.content.Intent intent, int i2, int i3, int i4, android.os.Bundle bundle) {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.startIntentSenderFromChild(activity, intentSender, i, intent, i2, i3, i4, bundle);
        } else {
            super.startIntentSenderFromChild(activity, intentSender, i, intent, i2, i3, i4, bundle);
        }
    }

    @Override // android.app.Activity
    public void startLocalVoiceInteraction(android.os.Bundle bundle) {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.startLocalVoiceInteraction(bundle);
        } else {
            super.startLocalVoiceInteraction(bundle);
        }
    }

    @Override // android.app.Activity
    public void startLockTask() {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.startLockTask();
        } else {
            super.startLockTask();
        }
    }

    @Override // android.app.Activity
    public void startManagingCursor(android.database.Cursor cursor) {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.startManagingCursor(cursor);
        } else {
            super.startManagingCursor(cursor);
        }
    }

    @Override // android.app.Activity
    public boolean startNextMatchingActivity(android.content.Intent intent) {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.startNextMatchingActivity(intent) : super.startNextMatchingActivity(intent);
    }

    @Override // android.app.Activity
    public boolean startNextMatchingActivity(android.content.Intent intent, android.os.Bundle bundle) {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        return generatePluginActivity != null ? generatePluginActivity.startNextMatchingActivity(intent, bundle) : super.startNextMatchingActivity(intent, bundle);
    }

    @Override // android.app.Activity
    public void startPostponedEnterTransition() {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.startPostponedEnterTransition();
        } else {
            super.startPostponedEnterTransition();
        }
    }

    @Override // android.app.Activity
    public void startSearch(java.lang.String str, boolean z, android.os.Bundle bundle, boolean z2) {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.startSearch(str, z, bundle, z2);
        } else {
            super.startSearch(str, z, bundle, z2);
        }
    }

    @Override // android.app.Activity
    public void stopLocalVoiceInteraction() {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.stopLocalVoiceInteraction();
        } else {
            super.stopLocalVoiceInteraction();
        }
    }

    @Override // android.app.Activity
    public void stopLockTask() {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.stopLockTask();
        } else {
            super.stopLockTask();
        }
    }

    @Override // android.app.Activity
    public void stopManagingCursor(android.database.Cursor cursor) {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.stopManagingCursor(cursor);
        } else {
            super.stopManagingCursor(cursor);
        }
    }

    @Override // android.app.Activity
    public void takeKeyEvents(boolean z) {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.takeKeyEvents(z);
        } else {
            super.takeKeyEvents(z);
        }
    }

    @Override // android.app.Activity
    public void triggerSearch(java.lang.String str, android.os.Bundle bundle) {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.triggerSearch(str, bundle);
        } else {
            super.triggerSearch(str, bundle);
        }
    }

    @Override // android.app.Activity
    public void unregisterActivityLifecycleCallbacks(android.app.Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.unregisterActivityLifecycleCallbacks(activityLifecycleCallbacks);
        } else {
            super.unregisterActivityLifecycleCallbacks(activityLifecycleCallbacks);
        }
    }

    @Override // android.app.Activity
    public void unregisterForContextMenu(android.view.View view) {
        com.bytedance.pangle.activity.GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
        if (generatePluginActivity != null) {
            generatePluginActivity.unregisterForContextMenu(view);
        } else {
            super.unregisterForContextMenu(view);
        }
    }

    public void zeusSuperAddContentView(android.view.View view, android.view.ViewGroup.LayoutParams layoutParams) {
        super.addContentView(view, layoutParams);
    }

    @Override // com.bytedance.pangle.activity.b
    public void zeusSuperAttachBaseContext(android.content.Context context) {
        super.attachBaseContext(context);
    }

    public void zeusSuperCloseContextMenu() {
        super.closeContextMenu();
    }

    public void zeusSuperCloseOptionsMenu() {
        super.closeOptionsMenu();
    }

    public boolean zeusSuperConvertToTranslucent(android.app.Activity.TranslucentConversionListener translucentConversionListener, android.app.ActivityOptions activityOptions) {
        try {
            java.lang.reflect.Method declaredMethod = android.app.Activity.class.getDeclaredMethod("convertToTranslucent", java.lang.Class.forName("android.app.Activity$TranslucentConversionListener"), android.app.ActivityOptions.class);
            declaredMethod.setAccessible(true);
            return ((java.lang.Boolean) declaredMethod.invoke(this, translucentConversionListener, activityOptions)).booleanValue();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public android.app.PendingIntent zeusSuperCreatePendingResult(int i, android.content.Intent intent, int i2) {
        return super.createPendingResult(i, intent, i2);
    }

    public boolean zeusSuperDispatchGenericMotionEvent(android.view.MotionEvent motionEvent) {
        return super.dispatchGenericMotionEvent(motionEvent);
    }

    public boolean zeusSuperDispatchKeyEvent(android.view.KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    public boolean zeusSuperDispatchKeyShortcutEvent(android.view.KeyEvent keyEvent) {
        return super.dispatchKeyShortcutEvent(keyEvent);
    }

    public boolean zeusSuperDispatchPopulateAccessibilityEvent(android.view.accessibility.AccessibilityEvent accessibilityEvent) {
        return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
    }

    public boolean zeusSuperDispatchTouchEvent(android.view.MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    public boolean zeusSuperDispatchTrackballEvent(android.view.MotionEvent motionEvent) {
        return super.dispatchTrackballEvent(motionEvent);
    }

    public void zeusSuperDump(java.lang.String str, java.io.FileDescriptor fileDescriptor, java.io.PrintWriter printWriter, java.lang.String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
    }

    public void zeusSuperEnterPictureInPictureMode() {
        super.enterPictureInPictureMode();
    }

    public boolean zeusSuperEnterPictureInPictureMode(android.app.PictureInPictureParams pictureInPictureParams) {
        return super.enterPictureInPictureMode(pictureInPictureParams);
    }

    public android.view.View zeusSuperFindViewById(int i) {
        return super.findViewById(i);
    }

    public void zeusSuperFinish() {
        super.finish();
    }

    public void zeusSuperFinishActivity(int i) {
        super.finishActivity(i);
    }

    public void zeusSuperFinishActivityFromChild(android.app.Activity activity, int i) {
        super.finishActivityFromChild(activity, i);
    }

    public void zeusSuperFinishAffinity() {
        super.finishAffinity();
    }

    public void zeusSuperFinishAfterTransition() {
        super.finishAfterTransition();
    }

    public void zeusSuperFinishAndRemoveTask() {
        super.finishAndRemoveTask();
    }

    public void zeusSuperFinishFromChild(android.app.Activity activity) {
        super.finishFromChild(activity);
    }

    public android.app.ActionBar zeusSuperGetActionBar() {
        return super.getActionBar();
    }

    public android.content.ComponentName zeusSuperGetCallingActivity() {
        return super.getCallingActivity();
    }

    public java.lang.String zeusSuperGetCallingPackage() {
        return super.getCallingPackage();
    }

    public int zeusSuperGetChangingConfigurations() {
        return super.getChangingConfigurations();
    }

    public android.content.ComponentName zeusSuperGetComponentName() {
        return super.getComponentName();
    }

    public android.transition.Scene zeusSuperGetContentScene() {
        return super.getContentScene();
    }

    public android.transition.TransitionManager zeusSuperGetContentTransitionManager() {
        return super.getContentTransitionManager();
    }

    public android.view.View zeusSuperGetCurrentFocus() {
        return super.getCurrentFocus();
    }

    public android.app.FragmentManager zeusSuperGetFragmentManager() {
        return super.getFragmentManager();
    }

    public android.content.Intent zeusSuperGetIntent() {
        return super.getIntent();
    }

    public java.lang.Object zeusSuperGetLastNonConfigurationInstance() {
        return super.getLastNonConfigurationInstance();
    }

    public android.view.LayoutInflater zeusSuperGetLayoutInflater() {
        return super.getLayoutInflater();
    }

    public android.app.LoaderManager zeusSuperGetLoaderManager() {
        return super.getLoaderManager();
    }

    public java.lang.String zeusSuperGetLocalClassName() {
        return super.getLocalClassName();
    }

    public int zeusSuperGetMaxNumPictureInPictureActions() {
        return super.getMaxNumPictureInPictureActions();
    }

    public android.view.MenuInflater zeusSuperGetMenuInflater() {
        return super.getMenuInflater();
    }

    public android.content.Intent zeusSuperGetParentActivityIntent() {
        return super.getParentActivityIntent();
    }

    public android.content.SharedPreferences zeusSuperGetPreferences(int i) {
        return super.getPreferences(i);
    }

    public android.net.Uri zeusSuperGetReferrer() {
        return super.getReferrer();
    }

    public int zeusSuperGetRequestedOrientation() {
        return super.getRequestedOrientation();
    }

    public java.lang.Object zeusSuperGetSystemService(java.lang.String str) {
        return super.getSystemService(str);
    }

    public int zeusSuperGetTaskId() {
        return super.getTaskId();
    }

    public android.app.VoiceInteractor zeusSuperGetVoiceInteractor() {
        return super.getVoiceInteractor();
    }

    public android.view.Window zeusSuperGetWindow() {
        return super.getWindow();
    }

    public android.view.WindowManager zeusSuperGetWindowManager() {
        return super.getWindowManager();
    }

    public boolean zeusSuperHasWindowFocus() {
        return super.hasWindowFocus();
    }

    public void zeusSuperInvalidateOptionsMenu() {
        super.invalidateOptionsMenu();
    }

    public boolean zeusSuperIsActivityTransitionRunning() {
        return super.isActivityTransitionRunning();
    }

    public boolean zeusSuperIsChangingConfigurations() {
        return super.isChangingConfigurations();
    }

    public boolean zeusSuperIsDestroyed() {
        return super.isDestroyed();
    }

    public boolean zeusSuperIsFinishing() {
        return super.isFinishing();
    }

    public boolean zeusSuperIsImmersive() {
        return super.isImmersive();
    }

    public boolean zeusSuperIsInMultiWindowMode() {
        return super.isInMultiWindowMode();
    }

    public boolean zeusSuperIsInPictureInPictureMode() {
        return super.isInPictureInPictureMode();
    }

    public boolean zeusSuperIsLocalVoiceInteractionSupported() {
        return super.isLocalVoiceInteractionSupported();
    }

    public boolean zeusSuperIsTaskRoot() {
        return super.isTaskRoot();
    }

    public boolean zeusSuperIsVoiceInteraction() {
        return super.isVoiceInteraction();
    }

    public boolean zeusSuperIsVoiceInteractionRoot() {
        return super.isVoiceInteractionRoot();
    }

    public boolean zeusSuperMoveTaskToBack(boolean z) {
        return super.moveTaskToBack(z);
    }

    public boolean zeusSuperNavigateUpTo(android.content.Intent intent) {
        return super.navigateUpTo(intent);
    }

    public boolean zeusSuperNavigateUpToFromChild(android.app.Activity activity, android.content.Intent intent) {
        return super.navigateUpToFromChild(activity, intent);
    }

    public void zeusSuperOnActionModeFinished(android.view.ActionMode actionMode) {
        super.onActionModeFinished(actionMode);
    }

    public void zeusSuperOnActionModeStarted(android.view.ActionMode actionMode) {
        super.onActionModeStarted(actionMode);
    }

    public void zeusSuperOnActivityReenter(int i, android.content.Intent intent) {
        super.onActivityReenter(i, intent);
    }

    public void zeusSuperOnActivityResult(int i, int i2, android.content.Intent intent) {
        super.onActivityResult(i, i2, intent);
    }

    public void zeusSuperOnApplyThemeResource(android.content.res.Resources.Theme theme, int i, boolean z) {
        super.onApplyThemeResource(theme, i, z);
    }

    public void zeusSuperOnAttachFragment(android.app.Fragment fragment) {
        super.onAttachFragment(fragment);
    }

    public void zeusSuperOnAttachedToWindow() {
        super.onAttachedToWindow();
    }

    public void zeusSuperOnBackPressed() {
        super.onBackPressed();
    }

    public void zeusSuperOnChildTitleChanged(android.app.Activity activity, java.lang.CharSequence charSequence) {
        super.onChildTitleChanged(activity, charSequence);
    }

    public void zeusSuperOnConfigurationChanged(android.content.res.Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    public void zeusSuperOnContentChanged() {
        super.onContentChanged();
    }

    public boolean zeusSuperOnContextItemSelected(android.view.MenuItem menuItem) {
        return super.onContextItemSelected(menuItem);
    }

    public void zeusSuperOnContextMenuClosed(android.view.Menu menu) {
        super.onContextMenuClosed(menu);
    }

    @Override // com.bytedance.pangle.activity.b
    public void zeusSuperOnCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
    }

    public void zeusSuperOnCreate(android.os.Bundle bundle, android.os.PersistableBundle persistableBundle) {
        super.onCreate(bundle, persistableBundle);
    }

    public void zeusSuperOnCreateContextMenu(android.view.ContextMenu contextMenu, android.view.View view, android.view.ContextMenu.ContextMenuInfo contextMenuInfo) {
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    public java.lang.CharSequence zeusSuperOnCreateDescription() {
        return super.onCreateDescription();
    }

    public android.app.Dialog zeusSuperOnCreateDialog(int i) {
        return super.onCreateDialog(i);
    }

    public android.app.Dialog zeusSuperOnCreateDialog(int i, android.os.Bundle bundle) {
        return super.onCreateDialog(i, bundle);
    }

    public void zeusSuperOnCreateNavigateUpTaskStack(android.app.TaskStackBuilder taskStackBuilder) {
        super.onCreateNavigateUpTaskStack(taskStackBuilder);
    }

    public boolean zeusSuperOnCreateOptionsMenu(android.view.Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    public boolean zeusSuperOnCreatePanelMenu(int i, android.view.Menu menu) {
        return super.onCreatePanelMenu(i, menu);
    }

    public android.view.View zeusSuperOnCreatePanelView(int i) {
        return super.onCreatePanelView(i);
    }

    public boolean zeusSuperOnCreateThumbnail(android.graphics.Bitmap bitmap, android.graphics.Canvas canvas) {
        return super.onCreateThumbnail(bitmap, canvas);
    }

    public android.view.View zeusSuperOnCreateView(android.view.View view, java.lang.String str, android.content.Context context, android.util.AttributeSet attributeSet) {
        return super.onCreateView(view, str, context, attributeSet);
    }

    public android.view.View zeusSuperOnCreateView(java.lang.String str, android.content.Context context, android.util.AttributeSet attributeSet) {
        return super.onCreateView(str, context, attributeSet);
    }

    public void zeusSuperOnDestroy() {
        super.onDestroy();
    }

    public void zeusSuperOnDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public void zeusSuperOnEnterAnimationComplete() {
        super.onEnterAnimationComplete();
    }

    public boolean zeusSuperOnGenericMotionEvent(android.view.MotionEvent motionEvent) {
        return super.onGenericMotionEvent(motionEvent);
    }

    public void zeusSuperOnGetDirectActions(android.os.CancellationSignal cancellationSignal, java.util.function.Consumer consumer) {
        super.onGetDirectActions(cancellationSignal, consumer);
    }

    public boolean zeusSuperOnKeyDown(int i, android.view.KeyEvent keyEvent) {
        return super.onKeyDown(i, keyEvent);
    }

    public boolean zeusSuperOnKeyLongPress(int i, android.view.KeyEvent keyEvent) {
        return super.onKeyLongPress(i, keyEvent);
    }

    public boolean zeusSuperOnKeyMultiple(int i, int i2, android.view.KeyEvent keyEvent) {
        return super.onKeyMultiple(i, i2, keyEvent);
    }

    public boolean zeusSuperOnKeyShortcut(int i, android.view.KeyEvent keyEvent) {
        return super.onKeyShortcut(i, keyEvent);
    }

    public boolean zeusSuperOnKeyUp(int i, android.view.KeyEvent keyEvent) {
        return super.onKeyUp(i, keyEvent);
    }

    public void zeusSuperOnLocalVoiceInteractionStarted() {
        super.onLocalVoiceInteractionStarted();
    }

    public void zeusSuperOnLocalVoiceInteractionStopped() {
        super.onLocalVoiceInteractionStopped();
    }

    public void zeusSuperOnLowMemory() {
        super.onLowMemory();
    }

    public boolean zeusSuperOnMenuOpened(int i, android.view.Menu menu) {
        return super.onMenuOpened(i, menu);
    }

    public void zeusSuperOnMultiWindowModeChanged(boolean z) {
        super.onMultiWindowModeChanged(z);
    }

    public void zeusSuperOnMultiWindowModeChanged(boolean z, android.content.res.Configuration configuration) {
        super.onMultiWindowModeChanged(z, configuration);
    }

    public boolean zeusSuperOnNavigateUp() {
        return super.onNavigateUp();
    }

    public boolean zeusSuperOnNavigateUpFromChild(android.app.Activity activity) {
        return super.onNavigateUpFromChild(activity);
    }

    public void zeusSuperOnNewIntent(android.content.Intent intent) {
        super.onNewIntent(intent);
    }

    public boolean zeusSuperOnOptionsItemSelected(android.view.MenuItem menuItem) {
        return super.onOptionsItemSelected(menuItem);
    }

    public void zeusSuperOnOptionsMenuClosed(android.view.Menu menu) {
        super.onOptionsMenuClosed(menu);
    }

    public void zeusSuperOnPanelClosed(int i, android.view.Menu menu) {
        super.onPanelClosed(i, menu);
    }

    public void zeusSuperOnPause() {
        super.onPause();
    }

    public void zeusSuperOnPerformDirectAction(java.lang.String str, android.os.Bundle bundle, android.os.CancellationSignal cancellationSignal, java.util.function.Consumer consumer) {
        super.onPerformDirectAction(str, bundle, cancellationSignal, consumer);
    }

    public void zeusSuperOnPictureInPictureModeChanged(boolean z) {
        super.onPictureInPictureModeChanged(z);
    }

    public void zeusSuperOnPictureInPictureModeChanged(boolean z, android.content.res.Configuration configuration) {
        super.onPictureInPictureModeChanged(z, configuration);
    }

    public boolean zeusSuperOnPictureInPictureRequested() {
        return super.onPictureInPictureRequested();
    }

    public void zeusSuperOnPostCreate(android.os.Bundle bundle) {
        super.onPostCreate(bundle);
    }

    public void zeusSuperOnPostCreate(android.os.Bundle bundle, android.os.PersistableBundle persistableBundle) {
        super.onPostCreate(bundle, persistableBundle);
    }

    public void zeusSuperOnPostResume() {
        super.onPostResume();
    }

    public void zeusSuperOnPrepareDialog(int i, android.app.Dialog dialog) {
        super.onPrepareDialog(i, dialog);
    }

    public void zeusSuperOnPrepareDialog(int i, android.app.Dialog dialog, android.os.Bundle bundle) {
        super.onPrepareDialog(i, dialog, bundle);
    }

    public void zeusSuperOnPrepareNavigateUpTaskStack(android.app.TaskStackBuilder taskStackBuilder) {
        super.onPrepareNavigateUpTaskStack(taskStackBuilder);
    }

    public boolean zeusSuperOnPrepareOptionsMenu(android.view.Menu menu) {
        return super.onPrepareOptionsMenu(menu);
    }

    public boolean zeusSuperOnPreparePanel(int i, android.view.View view, android.view.Menu menu) {
        return super.onPreparePanel(i, view, menu);
    }

    public void zeusSuperOnProvideAssistContent(android.app.assist.AssistContent assistContent) {
        super.onProvideAssistContent(assistContent);
    }

    public void zeusSuperOnProvideAssistData(android.os.Bundle bundle) {
        super.onProvideAssistData(bundle);
    }

    public void zeusSuperOnProvideKeyboardShortcuts(java.util.List list, android.view.Menu menu, int i) {
        super.onProvideKeyboardShortcuts(list, menu, i);
    }

    public android.net.Uri zeusSuperOnProvideReferrer() {
        return super.onProvideReferrer();
    }

    public void zeusSuperOnRequestPermissionsResult(int i, java.lang.String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
    }

    public void zeusSuperOnRestart() {
        super.onRestart();
    }

    public void zeusSuperOnRestoreInstanceState(android.os.Bundle bundle) {
        super.onRestoreInstanceState(bundle);
    }

    public void zeusSuperOnRestoreInstanceState(android.os.Bundle bundle, android.os.PersistableBundle persistableBundle) {
        super.onRestoreInstanceState(bundle, persistableBundle);
    }

    public void zeusSuperOnResume() {
        super.onResume();
    }

    public void zeusSuperOnSaveInstanceState(android.os.Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    public void zeusSuperOnSaveInstanceState(android.os.Bundle bundle, android.os.PersistableBundle persistableBundle) {
        super.onSaveInstanceState(bundle, persistableBundle);
    }

    public boolean zeusSuperOnSearchRequested() {
        return super.onSearchRequested();
    }

    public boolean zeusSuperOnSearchRequested(android.view.SearchEvent searchEvent) {
        return super.onSearchRequested(searchEvent);
    }

    public void zeusSuperOnStart() {
        super.onStart();
    }

    public void zeusSuperOnStateNotSaved() {
        super.onStateNotSaved();
    }

    public void zeusSuperOnStop() {
        super.onStop();
    }

    public void zeusSuperOnTitleChanged(java.lang.CharSequence charSequence, int i) {
        super.onTitleChanged(charSequence, i);
    }

    public void zeusSuperOnTopResumedActivityChanged(boolean z) {
        super.onTopResumedActivityChanged(z);
    }

    public boolean zeusSuperOnTouchEvent(android.view.MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public boolean zeusSuperOnTrackballEvent(android.view.MotionEvent motionEvent) {
        return super.onTrackballEvent(motionEvent);
    }

    public void zeusSuperOnTrimMemory(int i) {
        super.onTrimMemory(i);
    }

    public void zeusSuperOnUserInteraction() {
        super.onUserInteraction();
    }

    public void zeusSuperOnUserLeaveHint() {
        super.onUserLeaveHint();
    }

    public void zeusSuperOnVisibleBehindCanceled() {
        super.onVisibleBehindCanceled();
    }

    public void zeusSuperOnWindowAttributesChanged(android.view.WindowManager.LayoutParams layoutParams) {
        super.onWindowAttributesChanged(layoutParams);
    }

    public void zeusSuperOnWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
    }

    public android.view.ActionMode zeusSuperOnWindowStartingActionMode(android.view.ActionMode.Callback callback) {
        return super.onWindowStartingActionMode(callback);
    }

    public android.view.ActionMode zeusSuperOnWindowStartingActionMode(android.view.ActionMode.Callback callback, int i) {
        return super.onWindowStartingActionMode(callback, i);
    }

    public void zeusSuperOpenContextMenu(android.view.View view) {
        super.openContextMenu(view);
    }

    public void zeusSuperOpenOptionsMenu() {
        super.openOptionsMenu();
    }

    public void zeusSuperOverridePendingTransition(int i, int i2) {
        super.overridePendingTransition(i, i2);
    }

    public void zeusSuperPostponeEnterTransition() {
        super.postponeEnterTransition();
    }

    public void zeusSuperRecreate() {
        super.recreate();
    }

    public void zeusSuperRegisterActivityLifecycleCallbacks(android.app.Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        super.registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
    }

    public void zeusSuperRegisterForContextMenu(android.view.View view) {
        super.registerForContextMenu(view);
    }

    public boolean zeusSuperReleaseInstance() {
        return super.releaseInstance();
    }

    public void zeusSuperReportFullyDrawn() {
        super.reportFullyDrawn();
    }

    public android.view.DragAndDropPermissions zeusSuperRequestDragAndDropPermissions(android.view.DragEvent dragEvent) {
        return super.requestDragAndDropPermissions(dragEvent);
    }

    public boolean zeusSuperRequestVisibleBehind(boolean z) {
        return super.requestVisibleBehind(z);
    }

    public void zeusSuperSetActionBar(android.widget.Toolbar toolbar) {
        super.setActionBar(toolbar);
    }

    public void zeusSuperSetContentTransitionManager(android.transition.TransitionManager transitionManager) {
        super.setContentTransitionManager(transitionManager);
    }

    public void zeusSuperSetContentView(int i) {
        super.setContentView(i);
    }

    public void zeusSuperSetContentView(android.view.View view) {
        super.setContentView(view);
    }

    public void zeusSuperSetContentView(android.view.View view, android.view.ViewGroup.LayoutParams layoutParams) {
        super.setContentView(view, layoutParams);
    }

    public void zeusSuperSetEnterSharedElementCallback(android.app.SharedElementCallback sharedElementCallback) {
        super.setEnterSharedElementCallback(sharedElementCallback);
    }

    public void zeusSuperSetExitSharedElementCallback(android.app.SharedElementCallback sharedElementCallback) {
        super.setExitSharedElementCallback(sharedElementCallback);
    }

    public void zeusSuperSetFinishOnTouchOutside(boolean z) {
        super.setFinishOnTouchOutside(z);
    }

    public void zeusSuperSetImmersive(boolean z) {
        super.setImmersive(z);
    }

    public void zeusSuperSetInheritShowWhenLocked(boolean z) {
        super.setInheritShowWhenLocked(z);
    }

    public void zeusSuperSetIntent(android.content.Intent intent) {
        super.setIntent(intent);
    }

    public void zeusSuperSetLocusContext(android.content.LocusId locusId, android.os.Bundle bundle) {
        super.setLocusContext(locusId, bundle);
    }

    public void zeusSuperSetPictureInPictureParams(android.app.PictureInPictureParams pictureInPictureParams) {
        super.setPictureInPictureParams(pictureInPictureParams);
    }

    public void zeusSuperSetRequestedOrientation(int i) {
        super.setRequestedOrientation(i);
    }

    public void zeusSuperSetShowWhenLocked(boolean z) {
        super.setShowWhenLocked(z);
    }

    public void zeusSuperSetTaskDescription(android.app.ActivityManager.TaskDescription taskDescription) {
        super.setTaskDescription(taskDescription);
    }

    @Override // com.bytedance.pangle.activity.b
    public void zeusSuperSetTheme(int i) {
        super.setTheme(i);
    }

    public void zeusSuperSetTitle(int i) {
        super.setTitle(i);
    }

    public void zeusSuperSetTitle(java.lang.CharSequence charSequence) {
        super.setTitle(charSequence);
    }

    public void zeusSuperSetTitleColor(int i) {
        super.setTitleColor(i);
    }

    public boolean zeusSuperSetTranslucent(boolean z) {
        return super.setTranslucent(z);
    }

    public void zeusSuperSetTurnScreenOn(boolean z) {
        super.setTurnScreenOn(z);
    }

    public void zeusSuperSetVisible(boolean z) {
        super.setVisible(z);
    }

    public void zeusSuperSetVrModeEnabled(boolean z, android.content.ComponentName componentName) {
        super.setVrModeEnabled(z, componentName);
    }

    public boolean zeusSuperShouldShowRequestPermissionRationale(java.lang.String str) {
        return super.shouldShowRequestPermissionRationale(str);
    }

    public boolean zeusSuperShouldUpRecreateTask(android.content.Intent intent) {
        return super.shouldUpRecreateTask(intent);
    }

    public boolean zeusSuperShowAssist(android.os.Bundle bundle) {
        return super.showAssist(bundle);
    }

    public void zeusSuperShowLockTaskEscapeMessage() {
        super.showLockTaskEscapeMessage();
    }

    public android.view.ActionMode zeusSuperStartActionMode(android.view.ActionMode.Callback callback) {
        return super.startActionMode(callback);
    }

    public android.view.ActionMode zeusSuperStartActionMode(android.view.ActionMode.Callback callback, int i) {
        return super.startActionMode(callback, i);
    }

    public void zeusSuperStartActivities(android.content.Intent[] intentArr) {
        super.startActivities(intentArr);
    }

    public void zeusSuperStartActivities(android.content.Intent[] intentArr, android.os.Bundle bundle) {
        super.startActivities(intentArr, bundle);
    }

    public void zeusSuperStartActivity(android.content.Intent intent) {
        super.startActivity(intent);
    }

    public void zeusSuperStartActivity(android.content.Intent intent, android.os.Bundle bundle) {
        super.startActivity(intent, bundle);
    }

    public void zeusSuperStartActivityForResult(android.content.Intent intent, int i) {
        super.startActivityForResult(intent, i);
    }

    public void zeusSuperStartActivityForResult(android.content.Intent intent, int i, android.os.Bundle bundle) {
        super.startActivityForResult(intent, i, bundle);
    }

    public void zeusSuperStartActivityFromChild(android.app.Activity activity, android.content.Intent intent, int i) {
        super.startActivityFromChild(activity, intent, i);
    }

    public void zeusSuperStartActivityFromChild(android.app.Activity activity, android.content.Intent intent, int i, android.os.Bundle bundle) {
        super.startActivityFromChild(activity, intent, i, bundle);
    }

    public void zeusSuperStartActivityFromFragment(android.app.Fragment fragment, android.content.Intent intent, int i) {
        super.startActivityFromFragment(fragment, intent, i);
    }

    public void zeusSuperStartActivityFromFragment(android.app.Fragment fragment, android.content.Intent intent, int i, android.os.Bundle bundle) {
        super.startActivityFromFragment(fragment, intent, i, bundle);
    }

    public boolean zeusSuperStartActivityIfNeeded(android.content.Intent intent, int i) {
        return super.startActivityIfNeeded(intent, i);
    }

    public boolean zeusSuperStartActivityIfNeeded(android.content.Intent intent, int i, android.os.Bundle bundle) {
        return super.startActivityIfNeeded(intent, i, bundle);
    }

    public void zeusSuperStartIntentSender(android.content.IntentSender intentSender, android.content.Intent intent, int i, int i2, int i3) {
        super.startIntentSender(intentSender, intent, i, i2, i3);
    }

    public void zeusSuperStartIntentSender(android.content.IntentSender intentSender, android.content.Intent intent, int i, int i2, int i3, android.os.Bundle bundle) {
        super.startIntentSender(intentSender, intent, i, i2, i3, bundle);
    }

    public void zeusSuperStartIntentSenderForResult(android.content.IntentSender intentSender, int i, android.content.Intent intent, int i2, int i3, int i4) {
        super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4);
    }

    public void zeusSuperStartIntentSenderForResult(android.content.IntentSender intentSender, int i, android.content.Intent intent, int i2, int i3, int i4, android.os.Bundle bundle) {
        super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
    }

    public void zeusSuperStartIntentSenderFromChild(android.app.Activity activity, android.content.IntentSender intentSender, int i, android.content.Intent intent, int i2, int i3, int i4) {
        super.startIntentSenderFromChild(activity, intentSender, i, intent, i2, i3, i4);
    }

    public void zeusSuperStartIntentSenderFromChild(android.app.Activity activity, android.content.IntentSender intentSender, int i, android.content.Intent intent, int i2, int i3, int i4, android.os.Bundle bundle) {
        super.startIntentSenderFromChild(activity, intentSender, i, intent, i2, i3, i4, bundle);
    }

    public void zeusSuperStartLocalVoiceInteraction(android.os.Bundle bundle) {
        super.startLocalVoiceInteraction(bundle);
    }

    public void zeusSuperStartLockTask() {
        super.startLockTask();
    }

    public void zeusSuperStartManagingCursor(android.database.Cursor cursor) {
        super.startManagingCursor(cursor);
    }

    public boolean zeusSuperStartNextMatchingActivity(android.content.Intent intent) {
        return super.startNextMatchingActivity(intent);
    }

    public boolean zeusSuperStartNextMatchingActivity(android.content.Intent intent, android.os.Bundle bundle) {
        return super.startNextMatchingActivity(intent, bundle);
    }

    public void zeusSuperStartPostponedEnterTransition() {
        super.startPostponedEnterTransition();
    }

    public void zeusSuperStartSearch(java.lang.String str, boolean z, android.os.Bundle bundle, boolean z2) {
        super.startSearch(str, z, bundle, z2);
    }

    public void zeusSuperStopLocalVoiceInteraction() {
        super.stopLocalVoiceInteraction();
    }

    public void zeusSuperStopLockTask() {
        super.stopLockTask();
    }

    public void zeusSuperStopManagingCursor(android.database.Cursor cursor) {
        super.stopManagingCursor(cursor);
    }

    public void zeusSuperTakeKeyEvents(boolean z) {
        super.takeKeyEvents(z);
    }

    public void zeusSuperTriggerSearch(java.lang.String str, android.os.Bundle bundle) {
        super.triggerSearch(str, bundle);
    }

    public void zeusSuperUnregisterActivityLifecycleCallbacks(android.app.Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        super.unregisterActivityLifecycleCallbacks(activityLifecycleCallbacks);
    }

    public void zeusSuperUnregisterForContextMenu(android.view.View view) {
        super.unregisterForContextMenu(view);
    }
}
