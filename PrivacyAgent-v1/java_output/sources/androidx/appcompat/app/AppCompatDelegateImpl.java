package androidx.appcompat.app;

@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
class AppCompatDelegateImpl extends androidx.appcompat.app.AppCompatDelegate implements androidx.appcompat.view.menu.MenuBuilder.Callback, android.view.LayoutInflater.Factory2 {
    static final java.lang.String EXCEPTION_HANDLER_MESSAGE_SUFFIX = ". If the resource you are trying to use is a vector resource, you may be referencing it in an unsupported way. See AppCompatDelegate.setCompatVectorFromResourcesEnabled() for more info.";
    private static boolean sInstalledExceptionHandler;
    androidx.appcompat.app.ActionBar mActionBar;
    private androidx.appcompat.app.AppCompatDelegateImpl.ActionMenuPresenterCallback mActionMenuPresenterCallback;
    androidx.appcompat.view.ActionMode mActionMode;
    android.widget.PopupWindow mActionModePopup;
    androidx.appcompat.widget.ActionBarContextView mActionModeView;
    private boolean mActivityHandlesUiMode;
    private boolean mActivityHandlesUiModeChecked;
    final androidx.appcompat.app.AppCompatCallback mAppCompatCallback;
    private androidx.appcompat.app.AppCompatViewInflater mAppCompatViewInflater;
    private androidx.appcompat.app.AppCompatDelegateImpl.AppCompatWindowCallback mAppCompatWindowCallback;
    private androidx.appcompat.app.AppCompatDelegateImpl.AutoNightModeManager mAutoBatteryNightModeManager;
    private androidx.appcompat.app.AppCompatDelegateImpl.AutoNightModeManager mAutoTimeNightModeManager;
    private boolean mBaseContextAttached;
    private boolean mClosingActionMenu;
    final android.content.Context mContext;
    private boolean mCreated;
    private androidx.appcompat.widget.DecorContentParent mDecorContentParent;
    private boolean mEnableDefaultActionBarUp;
    androidx.core.view.ViewPropertyAnimatorCompat mFadeAnim;
    private boolean mFeatureIndeterminateProgress;
    private boolean mFeatureProgress;
    private boolean mHandleNativeActionModes;
    boolean mHasActionBar;
    final java.lang.Object mHost;
    int mInvalidatePanelMenuFeatures;
    boolean mInvalidatePanelMenuPosted;
    private final java.lang.Runnable mInvalidatePanelMenuRunnable;
    boolean mIsDestroyed;
    boolean mIsFloating;
    private androidx.appcompat.app.LayoutIncludeDetector mLayoutIncludeDetector;
    private int mLocalNightMode;
    private boolean mLongPressBackDown;
    android.view.MenuInflater mMenuInflater;
    boolean mOverlayActionBar;
    boolean mOverlayActionMode;
    private androidx.appcompat.app.AppCompatDelegateImpl.PanelMenuPresenterCallback mPanelMenuPresenterCallback;
    private androidx.appcompat.app.AppCompatDelegateImpl.PanelFeatureState[] mPanels;
    private androidx.appcompat.app.AppCompatDelegateImpl.PanelFeatureState mPreparedPanel;
    java.lang.Runnable mShowActionModePopup;
    private boolean mStarted;
    private android.view.View mStatusGuard;
    android.view.ViewGroup mSubDecor;
    private boolean mSubDecorInstalled;
    private android.graphics.Rect mTempRect1;
    private android.graphics.Rect mTempRect2;
    private int mThemeResId;
    private java.lang.CharSequence mTitle;
    private android.widget.TextView mTitleView;
    android.view.Window mWindow;
    boolean mWindowNoTitle;
    private static final androidx.collection.SimpleArrayMap<java.lang.String, java.lang.Integer> sLocalNightModes = new androidx.collection.SimpleArrayMap<>();
    private static final boolean IS_PRE_LOLLIPOP = false;
    private static final int[] sWindowBackgroundStyleable = {android.R.attr.windowBackground};
    private static final boolean sCanReturnDifferentContext = !"robolectric".equals(android.os.Build.FINGERPRINT);
    private static final boolean sCanApplyOverrideConfiguration = true;

    /* renamed from: androidx.appcompat.app.AppCompatDelegateImpl$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Thread.UncaughtExceptionHandler {
        final /* synthetic */ java.lang.Thread.UncaughtExceptionHandler val$defHandler;

        public AnonymousClass1(java.lang.Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
            this.val$defHandler = uncaughtExceptionHandler;
        }

        private boolean shouldWrapException(java.lang.Throwable th) {
            java.lang.String message;
            if (!(th instanceof android.content.res.Resources.NotFoundException) || (message = th.getMessage()) == null) {
                return false;
            }
            return message.contains(com.anythink.expressad.foundation.h.i.c) || message.contains("Drawable");
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(@androidx.annotation.NonNull java.lang.Thread thread, @androidx.annotation.NonNull java.lang.Throwable th) {
            if (!shouldWrapException(th)) {
                this.val$defHandler.uncaughtException(thread, th);
                return;
            }
            android.content.res.Resources.NotFoundException notFoundException = new android.content.res.Resources.NotFoundException(th.getMessage() + androidx.appcompat.app.AppCompatDelegateImpl.EXCEPTION_HANDLER_MESSAGE_SUFFIX);
            notFoundException.initCause(th.getCause());
            notFoundException.setStackTrace(th.getStackTrace());
            this.val$defHandler.uncaughtException(thread, notFoundException);
        }
    }

    /* renamed from: androidx.appcompat.app.AppCompatDelegateImpl$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        public AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public void run() {
            androidx.appcompat.app.AppCompatDelegateImpl appCompatDelegateImpl = androidx.appcompat.app.AppCompatDelegateImpl.this;
            if ((appCompatDelegateImpl.mInvalidatePanelMenuFeatures & 1) != 0) {
                appCompatDelegateImpl.doInvalidatePanelMenu(0);
            }
            androidx.appcompat.app.AppCompatDelegateImpl appCompatDelegateImpl2 = androidx.appcompat.app.AppCompatDelegateImpl.this;
            if ((appCompatDelegateImpl2.mInvalidatePanelMenuFeatures & 4096) != 0) {
                appCompatDelegateImpl2.doInvalidatePanelMenu(108);
            }
            androidx.appcompat.app.AppCompatDelegateImpl appCompatDelegateImpl3 = androidx.appcompat.app.AppCompatDelegateImpl.this;
            appCompatDelegateImpl3.mInvalidatePanelMenuPosted = false;
            appCompatDelegateImpl3.mInvalidatePanelMenuFeatures = 0;
        }
    }

    /* renamed from: androidx.appcompat.app.AppCompatDelegateImpl$3, reason: invalid class name */
    public class AnonymousClass3 implements androidx.core.view.OnApplyWindowInsetsListener {
        public AnonymousClass3() {
        }

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public androidx.core.view.WindowInsetsCompat onApplyWindowInsets(android.view.View view, androidx.core.view.WindowInsetsCompat windowInsetsCompat) {
            int systemWindowInsetTop = windowInsetsCompat.getSystemWindowInsetTop();
            int updateStatusGuard = androidx.appcompat.app.AppCompatDelegateImpl.this.updateStatusGuard(windowInsetsCompat, null);
            if (systemWindowInsetTop != updateStatusGuard) {
                windowInsetsCompat = windowInsetsCompat.replaceSystemWindowInsets(windowInsetsCompat.getSystemWindowInsetLeft(), updateStatusGuard, windowInsetsCompat.getSystemWindowInsetRight(), windowInsetsCompat.getSystemWindowInsetBottom());
            }
            return androidx.core.view.ViewCompat.onApplyWindowInsets(view, windowInsetsCompat);
        }
    }

    /* renamed from: androidx.appcompat.app.AppCompatDelegateImpl$4, reason: invalid class name */
    public class AnonymousClass4 implements androidx.appcompat.widget.FitWindowsViewGroup.OnFitSystemWindowsListener {
        public AnonymousClass4() {
        }

        @Override // androidx.appcompat.widget.FitWindowsViewGroup.OnFitSystemWindowsListener
        public void onFitSystemWindows(android.graphics.Rect rect) {
            rect.top = androidx.appcompat.app.AppCompatDelegateImpl.this.updateStatusGuard(null, rect);
        }
    }

    /* renamed from: androidx.appcompat.app.AppCompatDelegateImpl$5, reason: invalid class name */
    public class AnonymousClass5 implements androidx.appcompat.widget.ContentFrameLayout.OnAttachListener {
        public AnonymousClass5() {
        }

        @Override // androidx.appcompat.widget.ContentFrameLayout.OnAttachListener
        public void onAttachedFromWindow() {
        }

        @Override // androidx.appcompat.widget.ContentFrameLayout.OnAttachListener
        public void onDetachedFromWindow() {
            androidx.appcompat.app.AppCompatDelegateImpl.this.dismissPopups();
        }
    }

    /* renamed from: androidx.appcompat.app.AppCompatDelegateImpl$6, reason: invalid class name */
    public class AnonymousClass6 implements java.lang.Runnable {

        /* renamed from: androidx.appcompat.app.AppCompatDelegateImpl$6$1, reason: invalid class name */
        public class AnonymousClass1 extends androidx.core.view.ViewPropertyAnimatorListenerAdapter {
            public AnonymousClass1() {
            }

            @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(android.view.View view) {
                androidx.appcompat.app.AppCompatDelegateImpl.this.mActionModeView.setAlpha(1.0f);
                androidx.appcompat.app.AppCompatDelegateImpl.this.mFadeAnim.setListener(null);
                androidx.appcompat.app.AppCompatDelegateImpl.this.mFadeAnim = null;
            }

            @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationStart(android.view.View view) {
                androidx.appcompat.app.AppCompatDelegateImpl.this.mActionModeView.setVisibility(0);
            }
        }

        public AnonymousClass6() {
        }

        @Override // java.lang.Runnable
        public void run() {
            androidx.appcompat.app.AppCompatDelegateImpl appCompatDelegateImpl = androidx.appcompat.app.AppCompatDelegateImpl.this;
            appCompatDelegateImpl.mActionModePopup.showAtLocation(appCompatDelegateImpl.mActionModeView, 55, 0, 0);
            androidx.appcompat.app.AppCompatDelegateImpl.this.endOnGoingFadeAnimation();
            if (!androidx.appcompat.app.AppCompatDelegateImpl.this.shouldAnimateActionModeView()) {
                androidx.appcompat.app.AppCompatDelegateImpl.this.mActionModeView.setAlpha(1.0f);
                androidx.appcompat.app.AppCompatDelegateImpl.this.mActionModeView.setVisibility(0);
            } else {
                androidx.appcompat.app.AppCompatDelegateImpl.this.mActionModeView.setAlpha(0.0f);
                androidx.appcompat.app.AppCompatDelegateImpl appCompatDelegateImpl2 = androidx.appcompat.app.AppCompatDelegateImpl.this;
                appCompatDelegateImpl2.mFadeAnim = androidx.core.view.ViewCompat.animate(appCompatDelegateImpl2.mActionModeView).alpha(1.0f);
                androidx.appcompat.app.AppCompatDelegateImpl.this.mFadeAnim.setListener(new androidx.appcompat.app.AppCompatDelegateImpl.AnonymousClass6.AnonymousClass1());
            }
        }
    }

    /* renamed from: androidx.appcompat.app.AppCompatDelegateImpl$7, reason: invalid class name */
    public class AnonymousClass7 extends androidx.core.view.ViewPropertyAnimatorListenerAdapter {
        public AnonymousClass7() {
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(android.view.View view) {
            androidx.appcompat.app.AppCompatDelegateImpl.this.mActionModeView.setAlpha(1.0f);
            androidx.appcompat.app.AppCompatDelegateImpl.this.mFadeAnim.setListener(null);
            androidx.appcompat.app.AppCompatDelegateImpl.this.mFadeAnim = null;
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationStart(android.view.View view) {
            androidx.appcompat.app.AppCompatDelegateImpl.this.mActionModeView.setVisibility(0);
            androidx.appcompat.app.AppCompatDelegateImpl.this.mActionModeView.sendAccessibilityEvent(32);
            if (androidx.appcompat.app.AppCompatDelegateImpl.this.mActionModeView.getParent() instanceof android.view.View) {
                androidx.core.view.ViewCompat.requestApplyInsets((android.view.View) androidx.appcompat.app.AppCompatDelegateImpl.this.mActionModeView.getParent());
            }
        }
    }

    public class ActionBarDrawableToggleImpl implements androidx.appcompat.app.ActionBarDrawerToggle.Delegate {
        public ActionBarDrawableToggleImpl() {
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public android.content.Context getActionBarThemedContext() {
            return androidx.appcompat.app.AppCompatDelegateImpl.this.getActionBarThemedContext();
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public android.graphics.drawable.Drawable getThemeUpIndicator() {
            androidx.appcompat.widget.TintTypedArray obtainStyledAttributes = androidx.appcompat.widget.TintTypedArray.obtainStyledAttributes(getActionBarThemedContext(), (android.util.AttributeSet) null, new int[]{androidx.appcompat.R.attr.homeAsUpIndicator});
            android.graphics.drawable.Drawable drawable = obtainStyledAttributes.getDrawable(0);
            obtainStyledAttributes.recycle();
            return drawable;
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public boolean isNavigationVisible() {
            androidx.appcompat.app.ActionBar supportActionBar = androidx.appcompat.app.AppCompatDelegateImpl.this.getSupportActionBar();
            return (supportActionBar == null || (supportActionBar.getDisplayOptions() & 4) == 0) ? false : true;
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public void setActionBarDescription(int i) {
            androidx.appcompat.app.ActionBar supportActionBar = androidx.appcompat.app.AppCompatDelegateImpl.this.getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.setHomeActionContentDescription(i);
            }
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public void setActionBarUpIndicator(android.graphics.drawable.Drawable drawable, int i) {
            androidx.appcompat.app.ActionBar supportActionBar = androidx.appcompat.app.AppCompatDelegateImpl.this.getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.setHomeAsUpIndicator(drawable);
                supportActionBar.setHomeActionContentDescription(i);
            }
        }
    }

    public final class ActionMenuPresenterCallback implements androidx.appcompat.view.menu.MenuPresenter.Callback {
        public ActionMenuPresenterCallback() {
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public void onCloseMenu(@androidx.annotation.NonNull androidx.appcompat.view.menu.MenuBuilder menuBuilder, boolean z) {
            androidx.appcompat.app.AppCompatDelegateImpl.this.checkCloseActionMenu(menuBuilder);
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public boolean onOpenSubMenu(@androidx.annotation.NonNull androidx.appcompat.view.menu.MenuBuilder menuBuilder) {
            android.view.Window.Callback windowCallback = androidx.appcompat.app.AppCompatDelegateImpl.this.getWindowCallback();
            if (windowCallback == null) {
                return true;
            }
            windowCallback.onMenuOpened(108, menuBuilder);
            return true;
        }
    }

    public class ActionModeCallbackWrapperV9 implements androidx.appcompat.view.ActionMode.Callback {
        private androidx.appcompat.view.ActionMode.Callback mWrapped;

        /* renamed from: androidx.appcompat.app.AppCompatDelegateImpl$ActionModeCallbackWrapperV9$1, reason: invalid class name */
        public class AnonymousClass1 extends androidx.core.view.ViewPropertyAnimatorListenerAdapter {
            public AnonymousClass1() {
            }

            @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(android.view.View view) {
                androidx.appcompat.app.AppCompatDelegateImpl.this.mActionModeView.setVisibility(8);
                androidx.appcompat.app.AppCompatDelegateImpl appCompatDelegateImpl = androidx.appcompat.app.AppCompatDelegateImpl.this;
                android.widget.PopupWindow popupWindow = appCompatDelegateImpl.mActionModePopup;
                if (popupWindow != null) {
                    popupWindow.dismiss();
                } else if (appCompatDelegateImpl.mActionModeView.getParent() instanceof android.view.View) {
                    androidx.core.view.ViewCompat.requestApplyInsets((android.view.View) androidx.appcompat.app.AppCompatDelegateImpl.this.mActionModeView.getParent());
                }
                androidx.appcompat.app.AppCompatDelegateImpl.this.mActionModeView.killMode();
                androidx.appcompat.app.AppCompatDelegateImpl.this.mFadeAnim.setListener(null);
                androidx.appcompat.app.AppCompatDelegateImpl appCompatDelegateImpl2 = androidx.appcompat.app.AppCompatDelegateImpl.this;
                appCompatDelegateImpl2.mFadeAnim = null;
                androidx.core.view.ViewCompat.requestApplyInsets(appCompatDelegateImpl2.mSubDecor);
            }
        }

        public ActionModeCallbackWrapperV9(androidx.appcompat.view.ActionMode.Callback callback) {
            this.mWrapped = callback;
        }

        @Override // androidx.appcompat.view.ActionMode.Callback
        public boolean onActionItemClicked(androidx.appcompat.view.ActionMode actionMode, android.view.MenuItem menuItem) {
            return this.mWrapped.onActionItemClicked(actionMode, menuItem);
        }

        @Override // androidx.appcompat.view.ActionMode.Callback
        public boolean onCreateActionMode(androidx.appcompat.view.ActionMode actionMode, android.view.Menu menu) {
            return this.mWrapped.onCreateActionMode(actionMode, menu);
        }

        @Override // androidx.appcompat.view.ActionMode.Callback
        public void onDestroyActionMode(androidx.appcompat.view.ActionMode actionMode) {
            this.mWrapped.onDestroyActionMode(actionMode);
            androidx.appcompat.app.AppCompatDelegateImpl appCompatDelegateImpl = androidx.appcompat.app.AppCompatDelegateImpl.this;
            if (appCompatDelegateImpl.mActionModePopup != null) {
                appCompatDelegateImpl.mWindow.getDecorView().removeCallbacks(androidx.appcompat.app.AppCompatDelegateImpl.this.mShowActionModePopup);
            }
            androidx.appcompat.app.AppCompatDelegateImpl appCompatDelegateImpl2 = androidx.appcompat.app.AppCompatDelegateImpl.this;
            if (appCompatDelegateImpl2.mActionModeView != null) {
                appCompatDelegateImpl2.endOnGoingFadeAnimation();
                androidx.appcompat.app.AppCompatDelegateImpl appCompatDelegateImpl3 = androidx.appcompat.app.AppCompatDelegateImpl.this;
                appCompatDelegateImpl3.mFadeAnim = androidx.core.view.ViewCompat.animate(appCompatDelegateImpl3.mActionModeView).alpha(0.0f);
                androidx.appcompat.app.AppCompatDelegateImpl.this.mFadeAnim.setListener(new androidx.appcompat.app.AppCompatDelegateImpl.ActionModeCallbackWrapperV9.AnonymousClass1());
            }
            androidx.appcompat.app.AppCompatDelegateImpl appCompatDelegateImpl4 = androidx.appcompat.app.AppCompatDelegateImpl.this;
            androidx.appcompat.app.AppCompatCallback appCompatCallback = appCompatDelegateImpl4.mAppCompatCallback;
            if (appCompatCallback != null) {
                appCompatCallback.onSupportActionModeFinished(appCompatDelegateImpl4.mActionMode);
            }
            androidx.appcompat.app.AppCompatDelegateImpl appCompatDelegateImpl5 = androidx.appcompat.app.AppCompatDelegateImpl.this;
            appCompatDelegateImpl5.mActionMode = null;
            androidx.core.view.ViewCompat.requestApplyInsets(appCompatDelegateImpl5.mSubDecor);
        }

        @Override // androidx.appcompat.view.ActionMode.Callback
        public boolean onPrepareActionMode(androidx.appcompat.view.ActionMode actionMode, android.view.Menu menu) {
            androidx.core.view.ViewCompat.requestApplyInsets(androidx.appcompat.app.AppCompatDelegateImpl.this.mSubDecor);
            return this.mWrapped.onPrepareActionMode(actionMode, menu);
        }
    }

    @androidx.annotation.RequiresApi(17)
    public static class Api17Impl {
        private Api17Impl() {
        }

        public static android.content.Context createConfigurationContext(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull android.content.res.Configuration configuration) {
            return context.createConfigurationContext(configuration);
        }

        public static void generateConfigDelta_densityDpi(@androidx.annotation.NonNull android.content.res.Configuration configuration, @androidx.annotation.NonNull android.content.res.Configuration configuration2, @androidx.annotation.NonNull android.content.res.Configuration configuration3) {
            int i = configuration.densityDpi;
            int i2 = configuration2.densityDpi;
            if (i != i2) {
                configuration3.densityDpi = i2;
            }
        }
    }

    @androidx.annotation.RequiresApi(21)
    public static class Api21Impl {
        private Api21Impl() {
        }

        public static boolean isPowerSaveMode(android.os.PowerManager powerManager) {
            return powerManager.isPowerSaveMode();
        }
    }

    @androidx.annotation.RequiresApi(24)
    public static class Api24Impl {
        private Api24Impl() {
        }

        public static void generateConfigDelta_locale(@androidx.annotation.NonNull android.content.res.Configuration configuration, @androidx.annotation.NonNull android.content.res.Configuration configuration2, @androidx.annotation.NonNull android.content.res.Configuration configuration3) {
            android.os.LocaleList locales;
            android.os.LocaleList locales2;
            boolean equals;
            locales = configuration.getLocales();
            locales2 = configuration2.getLocales();
            equals = locales.equals(locales2);
            if (equals) {
                return;
            }
            configuration3.setLocales(locales2);
            configuration3.locale = configuration2.locale;
        }
    }

    @androidx.annotation.RequiresApi(26)
    public static class Api26Impl {
        private Api26Impl() {
        }

        public static void generateConfigDelta_colorMode(@androidx.annotation.NonNull android.content.res.Configuration configuration, @androidx.annotation.NonNull android.content.res.Configuration configuration2, @androidx.annotation.NonNull android.content.res.Configuration configuration3) {
            int i;
            int i2;
            int i3;
            int i4;
            int i5;
            int i6;
            int i7;
            int i8;
            i = configuration.colorMode;
            int i9 = i & 3;
            i2 = configuration2.colorMode;
            if (i9 != (i2 & 3)) {
                i7 = configuration3.colorMode;
                i8 = configuration2.colorMode;
                configuration3.colorMode = i7 | (i8 & 3);
            }
            i3 = configuration.colorMode;
            int i10 = i3 & 12;
            i4 = configuration2.colorMode;
            if (i10 != (i4 & 12)) {
                i5 = configuration3.colorMode;
                i6 = configuration2.colorMode;
                configuration3.colorMode = i5 | (i6 & 12);
            }
        }
    }

    public class AppCompatWindowCallback extends androidx.appcompat.view.WindowCallbackWrapper {
        public AppCompatWindowCallback(android.view.Window.Callback callback) {
            super(callback);
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public boolean dispatchKeyEvent(android.view.KeyEvent keyEvent) {
            return androidx.appcompat.app.AppCompatDelegateImpl.this.dispatchKeyEvent(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public boolean dispatchKeyShortcutEvent(android.view.KeyEvent keyEvent) {
            return super.dispatchKeyShortcutEvent(keyEvent) || androidx.appcompat.app.AppCompatDelegateImpl.this.onKeyShortcut(keyEvent.getKeyCode(), keyEvent);
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public void onContentChanged() {
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public boolean onCreatePanelMenu(int i, android.view.Menu menu) {
            if (i != 0 || (menu instanceof androidx.appcompat.view.menu.MenuBuilder)) {
                return super.onCreatePanelMenu(i, menu);
            }
            return false;
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public boolean onMenuOpened(int i, android.view.Menu menu) {
            super.onMenuOpened(i, menu);
            androidx.appcompat.app.AppCompatDelegateImpl.this.onMenuOpened(i);
            return true;
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public void onPanelClosed(int i, android.view.Menu menu) {
            super.onPanelClosed(i, menu);
            androidx.appcompat.app.AppCompatDelegateImpl.this.onPanelClosed(i);
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public boolean onPreparePanel(int i, android.view.View view, android.view.Menu menu) {
            androidx.appcompat.view.menu.MenuBuilder menuBuilder = menu instanceof androidx.appcompat.view.menu.MenuBuilder ? (androidx.appcompat.view.menu.MenuBuilder) menu : null;
            if (i == 0 && menuBuilder == null) {
                return false;
            }
            if (menuBuilder != null) {
                menuBuilder.setOverrideVisibleItems(true);
            }
            boolean onPreparePanel = super.onPreparePanel(i, view, menu);
            if (menuBuilder != null) {
                menuBuilder.setOverrideVisibleItems(false);
            }
            return onPreparePanel;
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        @androidx.annotation.RequiresApi(24)
        public void onProvideKeyboardShortcuts(java.util.List<android.view.KeyboardShortcutGroup> list, android.view.Menu menu, int i) {
            androidx.appcompat.view.menu.MenuBuilder menuBuilder;
            androidx.appcompat.app.AppCompatDelegateImpl.PanelFeatureState panelState = androidx.appcompat.app.AppCompatDelegateImpl.this.getPanelState(0, true);
            if (panelState == null || (menuBuilder = panelState.menu) == null) {
                super.onProvideKeyboardShortcuts(list, menu, i);
            } else {
                super.onProvideKeyboardShortcuts(list, menuBuilder, i);
            }
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public android.view.ActionMode onWindowStartingActionMode(android.view.ActionMode.Callback callback) {
            if (android.os.Build.VERSION.SDK_INT >= 23) {
                return null;
            }
            return androidx.appcompat.app.AppCompatDelegateImpl.this.isHandleNativeActionModesEnabled() ? startAsSupportActionMode(callback) : super.onWindowStartingActionMode(callback);
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        @androidx.annotation.RequiresApi(23)
        public android.view.ActionMode onWindowStartingActionMode(android.view.ActionMode.Callback callback, int i) {
            return (androidx.appcompat.app.AppCompatDelegateImpl.this.isHandleNativeActionModesEnabled() && i == 0) ? startAsSupportActionMode(callback) : super.onWindowStartingActionMode(callback, i);
        }

        public final android.view.ActionMode startAsSupportActionMode(android.view.ActionMode.Callback callback) {
            androidx.appcompat.view.SupportActionModeWrapper.CallbackWrapper callbackWrapper = new androidx.appcompat.view.SupportActionModeWrapper.CallbackWrapper(androidx.appcompat.app.AppCompatDelegateImpl.this.mContext, callback);
            androidx.appcompat.view.ActionMode startSupportActionMode = androidx.appcompat.app.AppCompatDelegateImpl.this.startSupportActionMode(callbackWrapper);
            if (startSupportActionMode != null) {
                return callbackWrapper.getActionModeWrapper(startSupportActionMode);
            }
            return null;
        }
    }

    public class AutoBatteryNightModeManager extends androidx.appcompat.app.AppCompatDelegateImpl.AutoNightModeManager {
        private final android.os.PowerManager mPowerManager;

        public AutoBatteryNightModeManager(@androidx.annotation.NonNull android.content.Context context) {
            super();
            this.mPowerManager = (android.os.PowerManager) context.getApplicationContext().getSystemService("power");
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.AutoNightModeManager
        public android.content.IntentFilter createIntentFilterForBroadcastReceiver() {
            android.content.IntentFilter intentFilter = new android.content.IntentFilter();
            intentFilter.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
            return intentFilter;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.AutoNightModeManager
        public int getApplyableNightMode() {
            return androidx.appcompat.app.AppCompatDelegateImpl.Api21Impl.isPowerSaveMode(this.mPowerManager) ? 2 : 1;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.AutoNightModeManager
        public void onChange() {
            androidx.appcompat.app.AppCompatDelegateImpl.this.applyDayNight();
        }
    }

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
    @androidx.annotation.VisibleForTesting
    public abstract class AutoNightModeManager {
        private android.content.BroadcastReceiver mReceiver;

        /* renamed from: androidx.appcompat.app.AppCompatDelegateImpl$AutoNightModeManager$1, reason: invalid class name */
        public class AnonymousClass1 extends android.content.BroadcastReceiver {
            public AnonymousClass1() {
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(android.content.Context context, android.content.Intent intent) {
                androidx.appcompat.app.AppCompatDelegateImpl.AutoNightModeManager.this.onChange();
            }
        }

        public AutoNightModeManager() {
        }

        public void cleanup() {
            android.content.BroadcastReceiver broadcastReceiver = this.mReceiver;
            if (broadcastReceiver != null) {
                try {
                    androidx.appcompat.app.AppCompatDelegateImpl.this.mContext.unregisterReceiver(broadcastReceiver);
                } catch (java.lang.IllegalArgumentException unused) {
                }
                this.mReceiver = null;
            }
        }

        @androidx.annotation.Nullable
        public abstract android.content.IntentFilter createIntentFilterForBroadcastReceiver();

        public abstract int getApplyableNightMode();

        public boolean isListening() {
            return this.mReceiver != null;
        }

        public abstract void onChange();

        public void setup() {
            cleanup();
            android.content.IntentFilter createIntentFilterForBroadcastReceiver = createIntentFilterForBroadcastReceiver();
            if (createIntentFilterForBroadcastReceiver == null || createIntentFilterForBroadcastReceiver.countActions() == 0) {
                return;
            }
            if (this.mReceiver == null) {
                this.mReceiver = new androidx.appcompat.app.AppCompatDelegateImpl.AutoNightModeManager.AnonymousClass1();
            }
            androidx.appcompat.app.AppCompatDelegateImpl.this.mContext.registerReceiver(this.mReceiver, createIntentFilterForBroadcastReceiver);
        }
    }

    public class AutoTimeNightModeManager extends androidx.appcompat.app.AppCompatDelegateImpl.AutoNightModeManager {
        private final androidx.appcompat.app.TwilightManager mTwilightManager;

        public AutoTimeNightModeManager(@androidx.annotation.NonNull androidx.appcompat.app.TwilightManager twilightManager) {
            super();
            this.mTwilightManager = twilightManager;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.AutoNightModeManager
        public android.content.IntentFilter createIntentFilterForBroadcastReceiver() {
            android.content.IntentFilter intentFilter = new android.content.IntentFilter();
            intentFilter.addAction(com.igexin.push.core.b.M);
            intentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
            intentFilter.addAction("android.intent.action.TIME_TICK");
            return intentFilter;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.AutoNightModeManager
        public int getApplyableNightMode() {
            return this.mTwilightManager.isNight() ? 2 : 1;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.AutoNightModeManager
        public void onChange() {
            androidx.appcompat.app.AppCompatDelegateImpl.this.applyDayNight();
        }
    }

    @androidx.annotation.RequiresApi(17)
    public static class ContextThemeWrapperCompatApi17Impl {
        private ContextThemeWrapperCompatApi17Impl() {
        }

        public static void applyOverrideConfiguration(android.view.ContextThemeWrapper contextThemeWrapper, android.content.res.Configuration configuration) {
            contextThemeWrapper.applyOverrideConfiguration(configuration);
        }
    }

    public class ListMenuDecorView extends androidx.appcompat.widget.ContentFrameLayout {
        public ListMenuDecorView(android.content.Context context) {
            super(context);
        }

        private boolean isOutOfBounds(int i, int i2) {
            return i < -5 || i2 < -5 || i > getWidth() + 5 || i2 > getHeight() + 5;
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchKeyEvent(android.view.KeyEvent keyEvent) {
            return androidx.appcompat.app.AppCompatDelegateImpl.this.dispatchKeyEvent(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        @Override // android.view.ViewGroup
        public boolean onInterceptTouchEvent(android.view.MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0 || !isOutOfBounds((int) motionEvent.getX(), (int) motionEvent.getY())) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            androidx.appcompat.app.AppCompatDelegateImpl.this.closePanel(0);
            return true;
        }

        @Override // android.view.View
        public void setBackgroundResource(int i) {
            setBackgroundDrawable(androidx.appcompat.content.res.AppCompatResources.getDrawable(getContext(), i));
        }
    }

    public static final class PanelFeatureState {
        int background;
        android.view.View createdPanelView;
        android.view.ViewGroup decorView;
        int featureId;
        android.os.Bundle frozenActionViewState;
        android.os.Bundle frozenMenuState;
        int gravity;
        boolean isHandled;
        boolean isOpen;
        boolean isPrepared;
        androidx.appcompat.view.menu.ListMenuPresenter listMenuPresenter;
        android.content.Context listPresenterContext;
        androidx.appcompat.view.menu.MenuBuilder menu;
        public boolean qwertyMode;
        boolean refreshDecorView = false;
        boolean refreshMenuContent;
        android.view.View shownPanelView;
        boolean wasLastOpen;
        int windowAnimations;
        int x;
        int y;

        @android.annotation.SuppressLint({"BanParcelableUsage"})
        public static class SavedState implements android.os.Parcelable {
            public static final android.os.Parcelable.Creator<androidx.appcompat.app.AppCompatDelegateImpl.PanelFeatureState.SavedState> CREATOR = new androidx.appcompat.app.AppCompatDelegateImpl.PanelFeatureState.SavedState.AnonymousClass1();
            int featureId;
            boolean isOpen;
            android.os.Bundle menuState;

            /* renamed from: androidx.appcompat.app.AppCompatDelegateImpl$PanelFeatureState$SavedState$1, reason: invalid class name */
            public class AnonymousClass1 implements android.os.Parcelable.ClassLoaderCreator<androidx.appcompat.app.AppCompatDelegateImpl.PanelFeatureState.SavedState> {
                @Override // android.os.Parcelable.Creator
                public androidx.appcompat.app.AppCompatDelegateImpl.PanelFeatureState.SavedState createFromParcel(android.os.Parcel parcel) {
                    return androidx.appcompat.app.AppCompatDelegateImpl.PanelFeatureState.SavedState.readFromParcel(parcel, null);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.ClassLoaderCreator
                public androidx.appcompat.app.AppCompatDelegateImpl.PanelFeatureState.SavedState createFromParcel(android.os.Parcel parcel, java.lang.ClassLoader classLoader) {
                    return androidx.appcompat.app.AppCompatDelegateImpl.PanelFeatureState.SavedState.readFromParcel(parcel, classLoader);
                }

                @Override // android.os.Parcelable.Creator
                public androidx.appcompat.app.AppCompatDelegateImpl.PanelFeatureState.SavedState[] newArray(int i) {
                    return new androidx.appcompat.app.AppCompatDelegateImpl.PanelFeatureState.SavedState[i];
                }
            }

            public static androidx.appcompat.app.AppCompatDelegateImpl.PanelFeatureState.SavedState readFromParcel(android.os.Parcel parcel, java.lang.ClassLoader classLoader) {
                androidx.appcompat.app.AppCompatDelegateImpl.PanelFeatureState.SavedState savedState = new androidx.appcompat.app.AppCompatDelegateImpl.PanelFeatureState.SavedState();
                savedState.featureId = parcel.readInt();
                boolean z = parcel.readInt() == 1;
                savedState.isOpen = z;
                if (z) {
                    savedState.menuState = parcel.readBundle(classLoader);
                }
                return savedState;
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            @Override // android.os.Parcelable
            public void writeToParcel(android.os.Parcel parcel, int i) {
                parcel.writeInt(this.featureId);
                parcel.writeInt(this.isOpen ? 1 : 0);
                if (this.isOpen) {
                    parcel.writeBundle(this.menuState);
                }
            }
        }

        public PanelFeatureState(int i) {
            this.featureId = i;
        }

        public void applyFrozenState() {
            android.os.Bundle bundle;
            androidx.appcompat.view.menu.MenuBuilder menuBuilder = this.menu;
            if (menuBuilder == null || (bundle = this.frozenMenuState) == null) {
                return;
            }
            menuBuilder.restorePresenterStates(bundle);
            this.frozenMenuState = null;
        }

        public void clearMenuPresenters() {
            androidx.appcompat.view.menu.MenuBuilder menuBuilder = this.menu;
            if (menuBuilder != null) {
                menuBuilder.removeMenuPresenter(this.listMenuPresenter);
            }
            this.listMenuPresenter = null;
        }

        public androidx.appcompat.view.menu.MenuView getListMenuView(androidx.appcompat.view.menu.MenuPresenter.Callback callback) {
            if (this.menu == null) {
                return null;
            }
            if (this.listMenuPresenter == null) {
                androidx.appcompat.view.menu.ListMenuPresenter listMenuPresenter = new androidx.appcompat.view.menu.ListMenuPresenter(this.listPresenterContext, androidx.appcompat.R.layout.abc_list_menu_item_layout);
                this.listMenuPresenter = listMenuPresenter;
                listMenuPresenter.setCallback(callback);
                this.menu.addMenuPresenter(this.listMenuPresenter);
            }
            return this.listMenuPresenter.getMenuView(this.decorView);
        }

        public boolean hasPanelItems() {
            if (this.shownPanelView == null) {
                return false;
            }
            return this.createdPanelView != null || this.listMenuPresenter.getAdapter().getCount() > 0;
        }

        public void onRestoreInstanceState(android.os.Parcelable parcelable) {
            androidx.appcompat.app.AppCompatDelegateImpl.PanelFeatureState.SavedState savedState = (androidx.appcompat.app.AppCompatDelegateImpl.PanelFeatureState.SavedState) parcelable;
            this.featureId = savedState.featureId;
            this.wasLastOpen = savedState.isOpen;
            this.frozenMenuState = savedState.menuState;
            this.shownPanelView = null;
            this.decorView = null;
        }

        public android.os.Parcelable onSaveInstanceState() {
            androidx.appcompat.app.AppCompatDelegateImpl.PanelFeatureState.SavedState savedState = new androidx.appcompat.app.AppCompatDelegateImpl.PanelFeatureState.SavedState();
            savedState.featureId = this.featureId;
            savedState.isOpen = this.isOpen;
            if (this.menu != null) {
                android.os.Bundle bundle = new android.os.Bundle();
                savedState.menuState = bundle;
                this.menu.savePresenterStates(bundle);
            }
            return savedState;
        }

        public void setMenu(androidx.appcompat.view.menu.MenuBuilder menuBuilder) {
            androidx.appcompat.view.menu.ListMenuPresenter listMenuPresenter;
            androidx.appcompat.view.menu.MenuBuilder menuBuilder2 = this.menu;
            if (menuBuilder == menuBuilder2) {
                return;
            }
            if (menuBuilder2 != null) {
                menuBuilder2.removeMenuPresenter(this.listMenuPresenter);
            }
            this.menu = menuBuilder;
            if (menuBuilder == null || (listMenuPresenter = this.listMenuPresenter) == null) {
                return;
            }
            menuBuilder.addMenuPresenter(listMenuPresenter);
        }

        public void setStyle(android.content.Context context) {
            android.util.TypedValue typedValue = new android.util.TypedValue();
            android.content.res.Resources.Theme newTheme = context.getResources().newTheme();
            newTheme.setTo(context.getTheme());
            newTheme.resolveAttribute(androidx.appcompat.R.attr.actionBarPopupTheme, typedValue, true);
            int i = typedValue.resourceId;
            if (i != 0) {
                newTheme.applyStyle(i, true);
            }
            newTheme.resolveAttribute(androidx.appcompat.R.attr.panelMenuListTheme, typedValue, true);
            int i2 = typedValue.resourceId;
            if (i2 != 0) {
                newTheme.applyStyle(i2, true);
            } else {
                newTheme.applyStyle(androidx.appcompat.R.style.Theme_AppCompat_CompactMenu, true);
            }
            androidx.appcompat.view.ContextThemeWrapper contextThemeWrapper = new androidx.appcompat.view.ContextThemeWrapper(context, 0);
            contextThemeWrapper.getTheme().setTo(newTheme);
            this.listPresenterContext = contextThemeWrapper;
            android.content.res.TypedArray obtainStyledAttributes = contextThemeWrapper.obtainStyledAttributes(androidx.appcompat.R.styleable.AppCompatTheme);
            this.background = obtainStyledAttributes.getResourceId(androidx.appcompat.R.styleable.AppCompatTheme_panelBackground, 0);
            this.windowAnimations = obtainStyledAttributes.getResourceId(androidx.appcompat.R.styleable.AppCompatTheme_android_windowAnimationStyle, 0);
            obtainStyledAttributes.recycle();
        }
    }

    public final class PanelMenuPresenterCallback implements androidx.appcompat.view.menu.MenuPresenter.Callback {
        public PanelMenuPresenterCallback() {
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public void onCloseMenu(@androidx.annotation.NonNull androidx.appcompat.view.menu.MenuBuilder menuBuilder, boolean z) {
            androidx.appcompat.view.menu.MenuBuilder rootMenu = menuBuilder.getRootMenu();
            boolean z2 = rootMenu != menuBuilder;
            androidx.appcompat.app.AppCompatDelegateImpl appCompatDelegateImpl = androidx.appcompat.app.AppCompatDelegateImpl.this;
            if (z2) {
                menuBuilder = rootMenu;
            }
            androidx.appcompat.app.AppCompatDelegateImpl.PanelFeatureState findMenuPanel = appCompatDelegateImpl.findMenuPanel(menuBuilder);
            if (findMenuPanel != null) {
                if (!z2) {
                    androidx.appcompat.app.AppCompatDelegateImpl.this.closePanel(findMenuPanel, z);
                } else {
                    androidx.appcompat.app.AppCompatDelegateImpl.this.callOnPanelClosed(findMenuPanel.featureId, findMenuPanel, rootMenu);
                    androidx.appcompat.app.AppCompatDelegateImpl.this.closePanel(findMenuPanel, true);
                }
            }
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public boolean onOpenSubMenu(@androidx.annotation.NonNull androidx.appcompat.view.menu.MenuBuilder menuBuilder) {
            android.view.Window.Callback windowCallback;
            if (menuBuilder != menuBuilder.getRootMenu()) {
                return true;
            }
            androidx.appcompat.app.AppCompatDelegateImpl appCompatDelegateImpl = androidx.appcompat.app.AppCompatDelegateImpl.this;
            if (!appCompatDelegateImpl.mHasActionBar || (windowCallback = appCompatDelegateImpl.getWindowCallback()) == null || androidx.appcompat.app.AppCompatDelegateImpl.this.mIsDestroyed) {
                return true;
            }
            windowCallback.onMenuOpened(108, menuBuilder);
            return true;
        }
    }

    public AppCompatDelegateImpl(android.app.Activity activity, androidx.appcompat.app.AppCompatCallback appCompatCallback) {
        this(activity, null, appCompatCallback, activity);
    }

    public AppCompatDelegateImpl(android.app.Dialog dialog, androidx.appcompat.app.AppCompatCallback appCompatCallback) {
        this(dialog.getContext(), dialog.getWindow(), appCompatCallback, dialog);
    }

    public AppCompatDelegateImpl(android.content.Context context, android.app.Activity activity, androidx.appcompat.app.AppCompatCallback appCompatCallback) {
        this(context, null, appCompatCallback, activity);
    }

    public AppCompatDelegateImpl(android.content.Context context, android.view.Window window, androidx.appcompat.app.AppCompatCallback appCompatCallback) {
        this(context, window, appCompatCallback, context);
    }

    private AppCompatDelegateImpl(android.content.Context context, android.view.Window window, androidx.appcompat.app.AppCompatCallback appCompatCallback, java.lang.Object obj) {
        androidx.collection.SimpleArrayMap<java.lang.String, java.lang.Integer> simpleArrayMap;
        java.lang.Integer num;
        androidx.appcompat.app.AppCompatActivity tryUnwrapContext;
        this.mFadeAnim = null;
        this.mHandleNativeActionModes = true;
        this.mLocalNightMode = -100;
        this.mInvalidatePanelMenuRunnable = new androidx.appcompat.app.AppCompatDelegateImpl.AnonymousClass2();
        this.mContext = context;
        this.mAppCompatCallback = appCompatCallback;
        this.mHost = obj;
        if (this.mLocalNightMode == -100 && (obj instanceof android.app.Dialog) && (tryUnwrapContext = tryUnwrapContext()) != null) {
            this.mLocalNightMode = tryUnwrapContext.getDelegate().getLocalNightMode();
        }
        if (this.mLocalNightMode == -100 && (num = (simpleArrayMap = sLocalNightModes).get(obj.getClass().getName())) != null) {
            this.mLocalNightMode = num.intValue();
            simpleArrayMap.remove(obj.getClass().getName());
        }
        if (window != null) {
            attachToWindow(window);
        }
        androidx.appcompat.widget.AppCompatDrawableManager.preload();
    }

    private boolean applyDayNight(boolean z) {
        if (this.mIsDestroyed) {
            return false;
        }
        int calculateNightMode = calculateNightMode();
        boolean updateForNightMode = updateForNightMode(mapNightMode(this.mContext, calculateNightMode), z);
        if (calculateNightMode == 0) {
            getAutoTimeNightModeManager(this.mContext).setup();
        } else {
            androidx.appcompat.app.AppCompatDelegateImpl.AutoNightModeManager autoNightModeManager = this.mAutoTimeNightModeManager;
            if (autoNightModeManager != null) {
                autoNightModeManager.cleanup();
            }
        }
        if (calculateNightMode == 3) {
            getAutoBatteryNightModeManager(this.mContext).setup();
        } else {
            androidx.appcompat.app.AppCompatDelegateImpl.AutoNightModeManager autoNightModeManager2 = this.mAutoBatteryNightModeManager;
            if (autoNightModeManager2 != null) {
                autoNightModeManager2.cleanup();
            }
        }
        return updateForNightMode;
    }

    private void applyFixedSizeWindow() {
        androidx.appcompat.widget.ContentFrameLayout contentFrameLayout = (androidx.appcompat.widget.ContentFrameLayout) this.mSubDecor.findViewById(android.R.id.content);
        android.view.View decorView = this.mWindow.getDecorView();
        contentFrameLayout.setDecorPadding(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
        android.content.res.TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(androidx.appcompat.R.styleable.AppCompatTheme);
        obtainStyledAttributes.getValue(androidx.appcompat.R.styleable.AppCompatTheme_windowMinWidthMajor, contentFrameLayout.getMinWidthMajor());
        obtainStyledAttributes.getValue(androidx.appcompat.R.styleable.AppCompatTheme_windowMinWidthMinor, contentFrameLayout.getMinWidthMinor());
        int i = androidx.appcompat.R.styleable.AppCompatTheme_windowFixedWidthMajor;
        if (obtainStyledAttributes.hasValue(i)) {
            obtainStyledAttributes.getValue(i, contentFrameLayout.getFixedWidthMajor());
        }
        int i2 = androidx.appcompat.R.styleable.AppCompatTheme_windowFixedWidthMinor;
        if (obtainStyledAttributes.hasValue(i2)) {
            obtainStyledAttributes.getValue(i2, contentFrameLayout.getFixedWidthMinor());
        }
        int i3 = androidx.appcompat.R.styleable.AppCompatTheme_windowFixedHeightMajor;
        if (obtainStyledAttributes.hasValue(i3)) {
            obtainStyledAttributes.getValue(i3, contentFrameLayout.getFixedHeightMajor());
        }
        int i4 = androidx.appcompat.R.styleable.AppCompatTheme_windowFixedHeightMinor;
        if (obtainStyledAttributes.hasValue(i4)) {
            obtainStyledAttributes.getValue(i4, contentFrameLayout.getFixedHeightMinor());
        }
        obtainStyledAttributes.recycle();
        contentFrameLayout.requestLayout();
    }

    private void attachToWindow(@androidx.annotation.NonNull android.view.Window window) {
        if (this.mWindow != null) {
            throw new java.lang.IllegalStateException("AppCompat has already installed itself into the Window");
        }
        android.view.Window.Callback callback = window.getCallback();
        if (callback instanceof androidx.appcompat.app.AppCompatDelegateImpl.AppCompatWindowCallback) {
            throw new java.lang.IllegalStateException("AppCompat has already installed itself into the Window");
        }
        androidx.appcompat.app.AppCompatDelegateImpl.AppCompatWindowCallback appCompatWindowCallback = new androidx.appcompat.app.AppCompatDelegateImpl.AppCompatWindowCallback(callback);
        this.mAppCompatWindowCallback = appCompatWindowCallback;
        window.setCallback(appCompatWindowCallback);
        androidx.appcompat.widget.TintTypedArray obtainStyledAttributes = androidx.appcompat.widget.TintTypedArray.obtainStyledAttributes(this.mContext, (android.util.AttributeSet) null, sWindowBackgroundStyleable);
        android.graphics.drawable.Drawable drawableIfKnown = obtainStyledAttributes.getDrawableIfKnown(0);
        if (drawableIfKnown != null) {
            window.setBackgroundDrawable(drawableIfKnown);
        }
        obtainStyledAttributes.recycle();
        this.mWindow = window;
    }

    private int calculateNightMode() {
        int i = this.mLocalNightMode;
        return i != -100 ? i : androidx.appcompat.app.AppCompatDelegate.getDefaultNightMode();
    }

    private void cleanupAutoManagers() {
        androidx.appcompat.app.AppCompatDelegateImpl.AutoNightModeManager autoNightModeManager = this.mAutoTimeNightModeManager;
        if (autoNightModeManager != null) {
            autoNightModeManager.cleanup();
        }
        androidx.appcompat.app.AppCompatDelegateImpl.AutoNightModeManager autoNightModeManager2 = this.mAutoBatteryNightModeManager;
        if (autoNightModeManager2 != null) {
            autoNightModeManager2.cleanup();
        }
    }

    @androidx.annotation.NonNull
    private android.content.res.Configuration createOverrideConfigurationForDayNight(@androidx.annotation.NonNull android.content.Context context, int i, @androidx.annotation.Nullable android.content.res.Configuration configuration) {
        int i2 = i != 1 ? i != 2 ? context.getApplicationContext().getResources().getConfiguration().uiMode & 48 : 32 : 16;
        android.content.res.Configuration configuration2 = new android.content.res.Configuration();
        configuration2.fontScale = 0.0f;
        if (configuration != null) {
            configuration2.setTo(configuration);
        }
        configuration2.uiMode = i2 | (configuration2.uiMode & (-49));
        return configuration2;
    }

    private android.view.ViewGroup createSubDecor() {
        android.view.ViewGroup viewGroup;
        android.content.res.TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(androidx.appcompat.R.styleable.AppCompatTheme);
        int i = androidx.appcompat.R.styleable.AppCompatTheme_windowActionBar;
        if (!obtainStyledAttributes.hasValue(i)) {
            obtainStyledAttributes.recycle();
            throw new java.lang.IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
        }
        if (obtainStyledAttributes.getBoolean(androidx.appcompat.R.styleable.AppCompatTheme_windowNoTitle, false)) {
            requestWindowFeature(1);
        } else if (obtainStyledAttributes.getBoolean(i, false)) {
            requestWindowFeature(108);
        }
        if (obtainStyledAttributes.getBoolean(androidx.appcompat.R.styleable.AppCompatTheme_windowActionBarOverlay, false)) {
            requestWindowFeature(109);
        }
        if (obtainStyledAttributes.getBoolean(androidx.appcompat.R.styleable.AppCompatTheme_windowActionModeOverlay, false)) {
            requestWindowFeature(10);
        }
        this.mIsFloating = obtainStyledAttributes.getBoolean(androidx.appcompat.R.styleable.AppCompatTheme_android_windowIsFloating, false);
        obtainStyledAttributes.recycle();
        ensureWindow();
        this.mWindow.getDecorView();
        android.view.LayoutInflater from = android.view.LayoutInflater.from(this.mContext);
        if (this.mWindowNoTitle) {
            viewGroup = this.mOverlayActionMode ? (android.view.ViewGroup) from.inflate(androidx.appcompat.R.layout.abc_screen_simple_overlay_action_mode, (android.view.ViewGroup) null) : (android.view.ViewGroup) from.inflate(androidx.appcompat.R.layout.abc_screen_simple, (android.view.ViewGroup) null);
        } else if (this.mIsFloating) {
            viewGroup = (android.view.ViewGroup) from.inflate(androidx.appcompat.R.layout.abc_dialog_title_material, (android.view.ViewGroup) null);
            this.mOverlayActionBar = false;
            this.mHasActionBar = false;
        } else if (this.mHasActionBar) {
            android.util.TypedValue typedValue = new android.util.TypedValue();
            this.mContext.getTheme().resolveAttribute(androidx.appcompat.R.attr.actionBarTheme, typedValue, true);
            viewGroup = (android.view.ViewGroup) android.view.LayoutInflater.from(typedValue.resourceId != 0 ? new androidx.appcompat.view.ContextThemeWrapper(this.mContext, typedValue.resourceId) : this.mContext).inflate(androidx.appcompat.R.layout.abc_screen_toolbar, (android.view.ViewGroup) null);
            androidx.appcompat.widget.DecorContentParent decorContentParent = (androidx.appcompat.widget.DecorContentParent) viewGroup.findViewById(androidx.appcompat.R.id.decor_content_parent);
            this.mDecorContentParent = decorContentParent;
            decorContentParent.setWindowCallback(getWindowCallback());
            if (this.mOverlayActionBar) {
                this.mDecorContentParent.initFeature(109);
            }
            if (this.mFeatureProgress) {
                this.mDecorContentParent.initFeature(2);
            }
            if (this.mFeatureIndeterminateProgress) {
                this.mDecorContentParent.initFeature(5);
            }
        } else {
            viewGroup = null;
        }
        if (viewGroup == null) {
            throw new java.lang.IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.mHasActionBar + ", windowActionBarOverlay: " + this.mOverlayActionBar + ", android:windowIsFloating: " + this.mIsFloating + ", windowActionModeOverlay: " + this.mOverlayActionMode + ", windowNoTitle: " + this.mWindowNoTitle + " }");
        }
        androidx.core.view.ViewCompat.setOnApplyWindowInsetsListener(viewGroup, new androidx.appcompat.app.AppCompatDelegateImpl.AnonymousClass3());
        if (this.mDecorContentParent == null) {
            this.mTitleView = (android.widget.TextView) viewGroup.findViewById(androidx.appcompat.R.id.title);
        }
        androidx.appcompat.widget.ViewUtils.makeOptionalFitsSystemWindows(viewGroup);
        androidx.appcompat.widget.ContentFrameLayout contentFrameLayout = (androidx.appcompat.widget.ContentFrameLayout) viewGroup.findViewById(androidx.appcompat.R.id.action_bar_activity_content);
        android.view.ViewGroup viewGroup2 = (android.view.ViewGroup) this.mWindow.findViewById(android.R.id.content);
        if (viewGroup2 != null) {
            while (viewGroup2.getChildCount() > 0) {
                android.view.View childAt = viewGroup2.getChildAt(0);
                viewGroup2.removeViewAt(0);
                contentFrameLayout.addView(childAt);
            }
            viewGroup2.setId(-1);
            contentFrameLayout.setId(android.R.id.content);
            if (viewGroup2 instanceof android.widget.FrameLayout) {
                ((android.widget.FrameLayout) viewGroup2).setForeground(null);
            }
        }
        this.mWindow.setContentView(viewGroup);
        contentFrameLayout.setAttachListener(new androidx.appcompat.app.AppCompatDelegateImpl.AnonymousClass5());
        return viewGroup;
    }

    private void ensureSubDecor() {
        if (this.mSubDecorInstalled) {
            return;
        }
        this.mSubDecor = createSubDecor();
        java.lang.CharSequence title = getTitle();
        if (!android.text.TextUtils.isEmpty(title)) {
            androidx.appcompat.widget.DecorContentParent decorContentParent = this.mDecorContentParent;
            if (decorContentParent != null) {
                decorContentParent.setWindowTitle(title);
            } else if (peekSupportActionBar() != null) {
                peekSupportActionBar().setWindowTitle(title);
            } else {
                android.widget.TextView textView = this.mTitleView;
                if (textView != null) {
                    textView.setText(title);
                }
            }
        }
        applyFixedSizeWindow();
        onSubDecorInstalled(this.mSubDecor);
        this.mSubDecorInstalled = true;
        androidx.appcompat.app.AppCompatDelegateImpl.PanelFeatureState panelState = getPanelState(0, false);
        if (this.mIsDestroyed) {
            return;
        }
        if (panelState == null || panelState.menu == null) {
            invalidatePanelMenu(108);
        }
    }

    private void ensureWindow() {
        if (this.mWindow == null) {
            java.lang.Object obj = this.mHost;
            if (obj instanceof android.app.Activity) {
                attachToWindow(((android.app.Activity) obj).getWindow());
            }
        }
        if (this.mWindow == null) {
            throw new java.lang.IllegalStateException("We have not been given a Window");
        }
    }

    @androidx.annotation.NonNull
    private static android.content.res.Configuration generateConfigDelta(@androidx.annotation.NonNull android.content.res.Configuration configuration, @androidx.annotation.Nullable android.content.res.Configuration configuration2) {
        android.content.res.Configuration configuration3 = new android.content.res.Configuration();
        configuration3.fontScale = 0.0f;
        if (configuration2 != null && configuration.diff(configuration2) != 0) {
            float f = configuration.fontScale;
            float f2 = configuration2.fontScale;
            if (f != f2) {
                configuration3.fontScale = f2;
            }
            int i = configuration.mcc;
            int i2 = configuration2.mcc;
            if (i != i2) {
                configuration3.mcc = i2;
            }
            int i3 = configuration.mnc;
            int i4 = configuration2.mnc;
            if (i3 != i4) {
                configuration3.mnc = i4;
            }
            int i5 = android.os.Build.VERSION.SDK_INT;
            if (i5 >= 24) {
                androidx.appcompat.app.AppCompatDelegateImpl.Api24Impl.generateConfigDelta_locale(configuration, configuration2, configuration3);
            } else if (!androidx.core.util.ObjectsCompat.equals(configuration.locale, configuration2.locale)) {
                configuration3.locale = configuration2.locale;
            }
            int i6 = configuration.touchscreen;
            int i7 = configuration2.touchscreen;
            if (i6 != i7) {
                configuration3.touchscreen = i7;
            }
            int i8 = configuration.keyboard;
            int i9 = configuration2.keyboard;
            if (i8 != i9) {
                configuration3.keyboard = i9;
            }
            int i10 = configuration.keyboardHidden;
            int i11 = configuration2.keyboardHidden;
            if (i10 != i11) {
                configuration3.keyboardHidden = i11;
            }
            int i12 = configuration.navigation;
            int i13 = configuration2.navigation;
            if (i12 != i13) {
                configuration3.navigation = i13;
            }
            int i14 = configuration.navigationHidden;
            int i15 = configuration2.navigationHidden;
            if (i14 != i15) {
                configuration3.navigationHidden = i15;
            }
            int i16 = configuration.orientation;
            int i17 = configuration2.orientation;
            if (i16 != i17) {
                configuration3.orientation = i17;
            }
            int i18 = configuration.screenLayout & 15;
            int i19 = configuration2.screenLayout;
            if (i18 != (i19 & 15)) {
                configuration3.screenLayout |= i19 & 15;
            }
            int i20 = configuration.screenLayout & 192;
            int i21 = configuration2.screenLayout;
            if (i20 != (i21 & 192)) {
                configuration3.screenLayout |= i21 & 192;
            }
            int i22 = configuration.screenLayout & 48;
            int i23 = configuration2.screenLayout;
            if (i22 != (i23 & 48)) {
                configuration3.screenLayout |= i23 & 48;
            }
            int i24 = configuration.screenLayout & 768;
            int i25 = configuration2.screenLayout;
            if (i24 != (i25 & 768)) {
                configuration3.screenLayout |= i25 & 768;
            }
            if (i5 >= 26) {
                androidx.appcompat.app.AppCompatDelegateImpl.Api26Impl.generateConfigDelta_colorMode(configuration, configuration2, configuration3);
            }
            int i26 = configuration.uiMode & 15;
            int i27 = configuration2.uiMode;
            if (i26 != (i27 & 15)) {
                configuration3.uiMode |= i27 & 15;
            }
            int i28 = configuration.uiMode & 48;
            int i29 = configuration2.uiMode;
            if (i28 != (i29 & 48)) {
                configuration3.uiMode |= i29 & 48;
            }
            int i30 = configuration.screenWidthDp;
            int i31 = configuration2.screenWidthDp;
            if (i30 != i31) {
                configuration3.screenWidthDp = i31;
            }
            int i32 = configuration.screenHeightDp;
            int i33 = configuration2.screenHeightDp;
            if (i32 != i33) {
                configuration3.screenHeightDp = i33;
            }
            int i34 = configuration.smallestScreenWidthDp;
            int i35 = configuration2.smallestScreenWidthDp;
            if (i34 != i35) {
                configuration3.smallestScreenWidthDp = i35;
            }
            androidx.appcompat.app.AppCompatDelegateImpl.Api17Impl.generateConfigDelta_densityDpi(configuration, configuration2, configuration3);
        }
        return configuration3;
    }

    private androidx.appcompat.app.AppCompatDelegateImpl.AutoNightModeManager getAutoBatteryNightModeManager(@androidx.annotation.NonNull android.content.Context context) {
        if (this.mAutoBatteryNightModeManager == null) {
            this.mAutoBatteryNightModeManager = new androidx.appcompat.app.AppCompatDelegateImpl.AutoBatteryNightModeManager(context);
        }
        return this.mAutoBatteryNightModeManager;
    }

    private androidx.appcompat.app.AppCompatDelegateImpl.AutoNightModeManager getAutoTimeNightModeManager(@androidx.annotation.NonNull android.content.Context context) {
        if (this.mAutoTimeNightModeManager == null) {
            this.mAutoTimeNightModeManager = new androidx.appcompat.app.AppCompatDelegateImpl.AutoTimeNightModeManager(androidx.appcompat.app.TwilightManager.getInstance(context));
        }
        return this.mAutoTimeNightModeManager;
    }

    private void initWindowDecorActionBar() {
        ensureSubDecor();
        if (this.mHasActionBar && this.mActionBar == null) {
            java.lang.Object obj = this.mHost;
            if (obj instanceof android.app.Activity) {
                this.mActionBar = new androidx.appcompat.app.WindowDecorActionBar((android.app.Activity) this.mHost, this.mOverlayActionBar);
            } else if (obj instanceof android.app.Dialog) {
                this.mActionBar = new androidx.appcompat.app.WindowDecorActionBar((android.app.Dialog) this.mHost);
            }
            androidx.appcompat.app.ActionBar actionBar = this.mActionBar;
            if (actionBar != null) {
                actionBar.setDefaultDisplayHomeAsUpEnabled(this.mEnableDefaultActionBarUp);
            }
        }
    }

    private boolean initializePanelContent(androidx.appcompat.app.AppCompatDelegateImpl.PanelFeatureState panelFeatureState) {
        android.view.View view = panelFeatureState.createdPanelView;
        if (view != null) {
            panelFeatureState.shownPanelView = view;
            return true;
        }
        if (panelFeatureState.menu == null) {
            return false;
        }
        if (this.mPanelMenuPresenterCallback == null) {
            this.mPanelMenuPresenterCallback = new androidx.appcompat.app.AppCompatDelegateImpl.PanelMenuPresenterCallback();
        }
        android.view.View view2 = (android.view.View) panelFeatureState.getListMenuView(this.mPanelMenuPresenterCallback);
        panelFeatureState.shownPanelView = view2;
        return view2 != null;
    }

    private boolean initializePanelDecor(androidx.appcompat.app.AppCompatDelegateImpl.PanelFeatureState panelFeatureState) {
        panelFeatureState.setStyle(getActionBarThemedContext());
        panelFeatureState.decorView = new androidx.appcompat.app.AppCompatDelegateImpl.ListMenuDecorView(panelFeatureState.listPresenterContext);
        panelFeatureState.gravity = 81;
        return true;
    }

    private boolean initializePanelMenu(androidx.appcompat.app.AppCompatDelegateImpl.PanelFeatureState panelFeatureState) {
        android.content.res.Resources.Theme theme;
        android.content.Context context = this.mContext;
        int i = panelFeatureState.featureId;
        if ((i == 0 || i == 108) && this.mDecorContentParent != null) {
            android.util.TypedValue typedValue = new android.util.TypedValue();
            android.content.res.Resources.Theme theme2 = context.getTheme();
            theme2.resolveAttribute(androidx.appcompat.R.attr.actionBarTheme, typedValue, true);
            if (typedValue.resourceId != 0) {
                theme = context.getResources().newTheme();
                theme.setTo(theme2);
                theme.applyStyle(typedValue.resourceId, true);
                theme.resolveAttribute(androidx.appcompat.R.attr.actionBarWidgetTheme, typedValue, true);
            } else {
                theme2.resolveAttribute(androidx.appcompat.R.attr.actionBarWidgetTheme, typedValue, true);
                theme = null;
            }
            if (typedValue.resourceId != 0) {
                if (theme == null) {
                    theme = context.getResources().newTheme();
                    theme.setTo(theme2);
                }
                theme.applyStyle(typedValue.resourceId, true);
            }
            if (theme != null) {
                androidx.appcompat.view.ContextThemeWrapper contextThemeWrapper = new androidx.appcompat.view.ContextThemeWrapper(context, 0);
                contextThemeWrapper.getTheme().setTo(theme);
                context = contextThemeWrapper;
            }
        }
        androidx.appcompat.view.menu.MenuBuilder menuBuilder = new androidx.appcompat.view.menu.MenuBuilder(context);
        menuBuilder.setCallback(this);
        panelFeatureState.setMenu(menuBuilder);
        return true;
    }

    private void invalidatePanelMenu(int i) {
        this.mInvalidatePanelMenuFeatures = (1 << i) | this.mInvalidatePanelMenuFeatures;
        if (this.mInvalidatePanelMenuPosted) {
            return;
        }
        androidx.core.view.ViewCompat.postOnAnimation(this.mWindow.getDecorView(), this.mInvalidatePanelMenuRunnable);
        this.mInvalidatePanelMenuPosted = true;
    }

    private boolean isActivityManifestHandlingUiMode() {
        if (!this.mActivityHandlesUiModeChecked && (this.mHost instanceof android.app.Activity)) {
            android.content.pm.PackageManager packageManager = this.mContext.getPackageManager();
            if (packageManager == null) {
                return false;
            }
            try {
                int i = android.os.Build.VERSION.SDK_INT;
                android.content.pm.ActivityInfo activityInfo = packageManager.getActivityInfo(new android.content.ComponentName(this.mContext, this.mHost.getClass()), i >= 29 ? 269221888 : i >= 24 ? 786432 : 0);
                this.mActivityHandlesUiMode = (activityInfo == null || (activityInfo.configChanges & 512) == 0) ? false : true;
            } catch (android.content.pm.PackageManager.NameNotFoundException unused) {
                this.mActivityHandlesUiMode = false;
            }
        }
        this.mActivityHandlesUiModeChecked = true;
        return this.mActivityHandlesUiMode;
    }

    private boolean onKeyDownPanel(int i, android.view.KeyEvent keyEvent) {
        if (keyEvent.getRepeatCount() != 0) {
            return false;
        }
        androidx.appcompat.app.AppCompatDelegateImpl.PanelFeatureState panelState = getPanelState(i, true);
        if (panelState.isOpen) {
            return false;
        }
        return preparePanel(panelState, keyEvent);
    }

    private boolean onKeyUpPanel(int i, android.view.KeyEvent keyEvent) {
        boolean z;
        android.media.AudioManager audioManager;
        androidx.appcompat.widget.DecorContentParent decorContentParent;
        if (this.mActionMode != null) {
            return false;
        }
        boolean z2 = true;
        androidx.appcompat.app.AppCompatDelegateImpl.PanelFeatureState panelState = getPanelState(i, true);
        if (i != 0 || (decorContentParent = this.mDecorContentParent) == null || !decorContentParent.canShowOverflowMenu() || android.view.ViewConfiguration.get(this.mContext).hasPermanentMenuKey()) {
            boolean z3 = panelState.isOpen;
            if (z3 || panelState.isHandled) {
                closePanel(panelState, true);
                z2 = z3;
            } else {
                if (panelState.isPrepared) {
                    if (panelState.refreshMenuContent) {
                        panelState.isPrepared = false;
                        z = preparePanel(panelState, keyEvent);
                    } else {
                        z = true;
                    }
                    if (z) {
                        openPanel(panelState, keyEvent);
                    }
                }
                z2 = false;
            }
        } else if (this.mDecorContentParent.isOverflowMenuShowing()) {
            z2 = this.mDecorContentParent.hideOverflowMenu();
        } else {
            if (!this.mIsDestroyed && preparePanel(panelState, keyEvent)) {
                z2 = this.mDecorContentParent.showOverflowMenu();
            }
            z2 = false;
        }
        if (z2 && (audioManager = (android.media.AudioManager) this.mContext.getApplicationContext().getSystemService("audio")) != null) {
            audioManager.playSoundEffect(0);
        }
        return z2;
    }

    private void openPanel(androidx.appcompat.app.AppCompatDelegateImpl.PanelFeatureState panelFeatureState, android.view.KeyEvent keyEvent) {
        int i;
        android.view.ViewGroup.LayoutParams layoutParams;
        if (panelFeatureState.isOpen || this.mIsDestroyed) {
            return;
        }
        if (panelFeatureState.featureId == 0) {
            if ((this.mContext.getResources().getConfiguration().screenLayout & 15) == 4) {
                return;
            }
        }
        android.view.Window.Callback windowCallback = getWindowCallback();
        if (windowCallback != null && !windowCallback.onMenuOpened(panelFeatureState.featureId, panelFeatureState.menu)) {
            closePanel(panelFeatureState, true);
            return;
        }
        android.view.WindowManager windowManager = (android.view.WindowManager) this.mContext.getSystemService("window");
        if (windowManager != null && preparePanel(panelFeatureState, keyEvent)) {
            android.view.ViewGroup viewGroup = panelFeatureState.decorView;
            if (viewGroup == null || panelFeatureState.refreshDecorView) {
                if (viewGroup == null) {
                    if (!initializePanelDecor(panelFeatureState) || panelFeatureState.decorView == null) {
                        return;
                    }
                } else if (panelFeatureState.refreshDecorView && viewGroup.getChildCount() > 0) {
                    panelFeatureState.decorView.removeAllViews();
                }
                if (!initializePanelContent(panelFeatureState) || !panelFeatureState.hasPanelItems()) {
                    panelFeatureState.refreshDecorView = true;
                    return;
                }
                android.view.ViewGroup.LayoutParams layoutParams2 = panelFeatureState.shownPanelView.getLayoutParams();
                if (layoutParams2 == null) {
                    layoutParams2 = new android.view.ViewGroup.LayoutParams(-2, -2);
                }
                panelFeatureState.decorView.setBackgroundResource(panelFeatureState.background);
                android.view.ViewParent parent = panelFeatureState.shownPanelView.getParent();
                if (parent instanceof android.view.ViewGroup) {
                    ((android.view.ViewGroup) parent).removeView(panelFeatureState.shownPanelView);
                }
                panelFeatureState.decorView.addView(panelFeatureState.shownPanelView, layoutParams2);
                if (!panelFeatureState.shownPanelView.hasFocus()) {
                    panelFeatureState.shownPanelView.requestFocus();
                }
            } else {
                android.view.View view = panelFeatureState.createdPanelView;
                if (view != null && (layoutParams = view.getLayoutParams()) != null && layoutParams.width == -1) {
                    i = -1;
                    panelFeatureState.isHandled = false;
                    android.view.WindowManager.LayoutParams layoutParams3 = new android.view.WindowManager.LayoutParams(i, -2, panelFeatureState.x, panelFeatureState.y, 1002, 8519680, -3);
                    layoutParams3.gravity = panelFeatureState.gravity;
                    layoutParams3.windowAnimations = panelFeatureState.windowAnimations;
                    windowManager.addView(panelFeatureState.decorView, layoutParams3);
                    panelFeatureState.isOpen = true;
                }
            }
            i = -2;
            panelFeatureState.isHandled = false;
            android.view.WindowManager.LayoutParams layoutParams32 = new android.view.WindowManager.LayoutParams(i, -2, panelFeatureState.x, panelFeatureState.y, 1002, 8519680, -3);
            layoutParams32.gravity = panelFeatureState.gravity;
            layoutParams32.windowAnimations = panelFeatureState.windowAnimations;
            windowManager.addView(panelFeatureState.decorView, layoutParams32);
            panelFeatureState.isOpen = true;
        }
    }

    private boolean performPanelShortcut(androidx.appcompat.app.AppCompatDelegateImpl.PanelFeatureState panelFeatureState, int i, android.view.KeyEvent keyEvent, int i2) {
        androidx.appcompat.view.menu.MenuBuilder menuBuilder;
        boolean z = false;
        if (keyEvent.isSystem()) {
            return false;
        }
        if ((panelFeatureState.isPrepared || preparePanel(panelFeatureState, keyEvent)) && (menuBuilder = panelFeatureState.menu) != null) {
            z = menuBuilder.performShortcut(i, keyEvent, i2);
        }
        if (z && (i2 & 1) == 0 && this.mDecorContentParent == null) {
            closePanel(panelFeatureState, true);
        }
        return z;
    }

    private boolean preparePanel(androidx.appcompat.app.AppCompatDelegateImpl.PanelFeatureState panelFeatureState, android.view.KeyEvent keyEvent) {
        androidx.appcompat.widget.DecorContentParent decorContentParent;
        androidx.appcompat.widget.DecorContentParent decorContentParent2;
        androidx.appcompat.widget.DecorContentParent decorContentParent3;
        if (this.mIsDestroyed) {
            return false;
        }
        if (panelFeatureState.isPrepared) {
            return true;
        }
        androidx.appcompat.app.AppCompatDelegateImpl.PanelFeatureState panelFeatureState2 = this.mPreparedPanel;
        if (panelFeatureState2 != null && panelFeatureState2 != panelFeatureState) {
            closePanel(panelFeatureState2, false);
        }
        android.view.Window.Callback windowCallback = getWindowCallback();
        if (windowCallback != null) {
            panelFeatureState.createdPanelView = windowCallback.onCreatePanelView(panelFeatureState.featureId);
        }
        int i = panelFeatureState.featureId;
        boolean z = i == 0 || i == 108;
        if (z && (decorContentParent3 = this.mDecorContentParent) != null) {
            decorContentParent3.setMenuPrepared();
        }
        if (panelFeatureState.createdPanelView == null && (!z || !(peekSupportActionBar() instanceof androidx.appcompat.app.ToolbarActionBar))) {
            androidx.appcompat.view.menu.MenuBuilder menuBuilder = panelFeatureState.menu;
            if (menuBuilder == null || panelFeatureState.refreshMenuContent) {
                if (menuBuilder == null && (!initializePanelMenu(panelFeatureState) || panelFeatureState.menu == null)) {
                    return false;
                }
                if (z && this.mDecorContentParent != null) {
                    if (this.mActionMenuPresenterCallback == null) {
                        this.mActionMenuPresenterCallback = new androidx.appcompat.app.AppCompatDelegateImpl.ActionMenuPresenterCallback();
                    }
                    this.mDecorContentParent.setMenu(panelFeatureState.menu, this.mActionMenuPresenterCallback);
                }
                panelFeatureState.menu.stopDispatchingItemsChanged();
                if (!windowCallback.onCreatePanelMenu(panelFeatureState.featureId, panelFeatureState.menu)) {
                    panelFeatureState.setMenu(null);
                    if (z && (decorContentParent = this.mDecorContentParent) != null) {
                        decorContentParent.setMenu(null, this.mActionMenuPresenterCallback);
                    }
                    return false;
                }
                panelFeatureState.refreshMenuContent = false;
            }
            panelFeatureState.menu.stopDispatchingItemsChanged();
            android.os.Bundle bundle = panelFeatureState.frozenActionViewState;
            if (bundle != null) {
                panelFeatureState.menu.restoreActionViewStates(bundle);
                panelFeatureState.frozenActionViewState = null;
            }
            if (!windowCallback.onPreparePanel(0, panelFeatureState.createdPanelView, panelFeatureState.menu)) {
                if (z && (decorContentParent2 = this.mDecorContentParent) != null) {
                    decorContentParent2.setMenu(null, this.mActionMenuPresenterCallback);
                }
                panelFeatureState.menu.startDispatchingItemsChanged();
                return false;
            }
            boolean z2 = android.view.KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1;
            panelFeatureState.qwertyMode = z2;
            panelFeatureState.menu.setQwertyMode(z2);
            panelFeatureState.menu.startDispatchingItemsChanged();
        }
        panelFeatureState.isPrepared = true;
        panelFeatureState.isHandled = false;
        this.mPreparedPanel = panelFeatureState;
        return true;
    }

    private void reopenMenu(boolean z) {
        androidx.appcompat.widget.DecorContentParent decorContentParent = this.mDecorContentParent;
        if (decorContentParent == null || !decorContentParent.canShowOverflowMenu() || (android.view.ViewConfiguration.get(this.mContext).hasPermanentMenuKey() && !this.mDecorContentParent.isOverflowMenuShowPending())) {
            androidx.appcompat.app.AppCompatDelegateImpl.PanelFeatureState panelState = getPanelState(0, true);
            panelState.refreshDecorView = true;
            closePanel(panelState, false);
            openPanel(panelState, null);
            return;
        }
        android.view.Window.Callback windowCallback = getWindowCallback();
        if (this.mDecorContentParent.isOverflowMenuShowing() && z) {
            this.mDecorContentParent.hideOverflowMenu();
            if (this.mIsDestroyed) {
                return;
            }
            windowCallback.onPanelClosed(108, getPanelState(0, true).menu);
            return;
        }
        if (windowCallback == null || this.mIsDestroyed) {
            return;
        }
        if (this.mInvalidatePanelMenuPosted && (this.mInvalidatePanelMenuFeatures & 1) != 0) {
            this.mWindow.getDecorView().removeCallbacks(this.mInvalidatePanelMenuRunnable);
            this.mInvalidatePanelMenuRunnable.run();
        }
        androidx.appcompat.app.AppCompatDelegateImpl.PanelFeatureState panelState2 = getPanelState(0, true);
        androidx.appcompat.view.menu.MenuBuilder menuBuilder = panelState2.menu;
        if (menuBuilder == null || panelState2.refreshMenuContent || !windowCallback.onPreparePanel(0, panelState2.createdPanelView, menuBuilder)) {
            return;
        }
        windowCallback.onMenuOpened(108, panelState2.menu);
        this.mDecorContentParent.showOverflowMenu();
    }

    private int sanitizeWindowFeatureId(int i) {
        if (i == 8) {
            return 108;
        }
        if (i == 9) {
            return 109;
        }
        return i;
    }

    private boolean shouldInheritContext(android.view.ViewParent viewParent) {
        if (viewParent == null) {
            return false;
        }
        android.view.View decorView = this.mWindow.getDecorView();
        while (viewParent != null) {
            if (viewParent == decorView || !(viewParent instanceof android.view.View) || androidx.core.view.ViewCompat.isAttachedToWindow((android.view.View) viewParent)) {
                return false;
            }
            viewParent = viewParent.getParent();
        }
        return true;
    }

    private void throwFeatureRequestIfSubDecorInstalled() {
        if (this.mSubDecorInstalled) {
            throw new android.util.AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    @androidx.annotation.Nullable
    private androidx.appcompat.app.AppCompatActivity tryUnwrapContext() {
        for (android.content.Context context = this.mContext; context != null; context = ((android.content.ContextWrapper) context).getBaseContext()) {
            if (context instanceof androidx.appcompat.app.AppCompatActivity) {
                return (androidx.appcompat.app.AppCompatActivity) context;
            }
            if (!(context instanceof android.content.ContextWrapper)) {
                break;
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0053  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean updateForNightMode(int i, boolean z) {
        boolean z2;
        android.content.res.Configuration createOverrideConfigurationForDayNight = createOverrideConfigurationForDayNight(this.mContext, i, null);
        boolean isActivityManifestHandlingUiMode = isActivityManifestHandlingUiMode();
        int i2 = this.mContext.getResources().getConfiguration().uiMode & 48;
        int i3 = createOverrideConfigurationForDayNight.uiMode & 48;
        boolean z3 = true;
        if (i2 != i3 && z && !isActivityManifestHandlingUiMode && this.mBaseContextAttached && (sCanReturnDifferentContext || this.mCreated)) {
            java.lang.Object obj = this.mHost;
            if ((obj instanceof android.app.Activity) && !((android.app.Activity) obj).isChild()) {
                androidx.core.app.ActivityCompat.recreate((android.app.Activity) this.mHost);
                z2 = true;
                if (!z2 || i2 == i3) {
                    z3 = z2;
                } else {
                    updateResourcesConfigurationForNightMode(i3, isActivityManifestHandlingUiMode, null);
                }
                if (z3) {
                    java.lang.Object obj2 = this.mHost;
                    if (obj2 instanceof androidx.appcompat.app.AppCompatActivity) {
                        ((androidx.appcompat.app.AppCompatActivity) obj2).onNightModeChanged(i);
                    }
                }
                return z3;
            }
        }
        z2 = false;
        if (z2) {
        }
        z3 = z2;
        if (z3) {
        }
        return z3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void updateResourcesConfigurationForNightMode(int i, boolean z, @androidx.annotation.Nullable android.content.res.Configuration configuration) {
        android.content.res.Resources resources = this.mContext.getResources();
        android.content.res.Configuration configuration2 = new android.content.res.Configuration(resources.getConfiguration());
        if (configuration != null) {
            configuration2.updateFrom(configuration);
        }
        configuration2.uiMode = i | (resources.getConfiguration().uiMode & (-49));
        resources.updateConfiguration(configuration2, null);
        int i2 = android.os.Build.VERSION.SDK_INT;
        if (i2 < 26) {
            androidx.appcompat.app.ResourcesFlusher.flush(resources);
        }
        int i3 = this.mThemeResId;
        if (i3 != 0) {
            this.mContext.setTheme(i3);
            if (i2 >= 23) {
                this.mContext.getTheme().applyStyle(this.mThemeResId, true);
            }
        }
        if (z) {
            java.lang.Object obj = this.mHost;
            if (obj instanceof android.app.Activity) {
                android.app.Activity activity = (android.app.Activity) obj;
                if (activity instanceof androidx.lifecycle.LifecycleOwner) {
                    if (((androidx.lifecycle.LifecycleOwner) activity).getLifecycle().getCurrentState().isAtLeast(androidx.lifecycle.Lifecycle.State.STARTED)) {
                        activity.onConfigurationChanged(configuration2);
                    }
                } else if (this.mStarted) {
                    activity.onConfigurationChanged(configuration2);
                }
            }
        }
    }

    private void updateStatusGuardColor(android.view.View view) {
        view.setBackgroundColor((androidx.core.view.ViewCompat.getWindowSystemUiVisibility(view) & 8192) != 0 ? androidx.core.content.ContextCompat.getColor(this.mContext, androidx.appcompat.R.color.abc_decor_view_status_guard_light) : androidx.core.content.ContextCompat.getColor(this.mContext, androidx.appcompat.R.color.abc_decor_view_status_guard));
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void addContentView(android.view.View view, android.view.ViewGroup.LayoutParams layoutParams) {
        ensureSubDecor();
        ((android.view.ViewGroup) this.mSubDecor.findViewById(android.R.id.content)).addView(view, layoutParams);
        this.mAppCompatWindowCallback.getWrapped().onContentChanged();
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public boolean applyDayNight() {
        return applyDayNight(true);
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    @androidx.annotation.NonNull
    @androidx.annotation.CallSuper
    public android.content.Context attachBaseContext2(@androidx.annotation.NonNull android.content.Context context) {
        this.mBaseContextAttached = true;
        int mapNightMode = mapNightMode(context, calculateNightMode());
        if (sCanApplyOverrideConfiguration && (context instanceof android.view.ContextThemeWrapper)) {
            try {
                androidx.appcompat.app.AppCompatDelegateImpl.ContextThemeWrapperCompatApi17Impl.applyOverrideConfiguration((android.view.ContextThemeWrapper) context, createOverrideConfigurationForDayNight(context, mapNightMode, null));
                return context;
            } catch (java.lang.IllegalStateException unused) {
            }
        }
        if (context instanceof androidx.appcompat.view.ContextThemeWrapper) {
            try {
                ((androidx.appcompat.view.ContextThemeWrapper) context).applyOverrideConfiguration(createOverrideConfigurationForDayNight(context, mapNightMode, null));
                return context;
            } catch (java.lang.IllegalStateException unused2) {
            }
        }
        if (!sCanReturnDifferentContext) {
            return super.attachBaseContext2(context);
        }
        android.content.res.Configuration configuration = new android.content.res.Configuration();
        configuration.uiMode = -1;
        configuration.fontScale = 0.0f;
        android.content.res.Configuration configuration2 = androidx.appcompat.app.AppCompatDelegateImpl.Api17Impl.createConfigurationContext(context, configuration).getResources().getConfiguration();
        android.content.res.Configuration configuration3 = context.getResources().getConfiguration();
        configuration2.uiMode = configuration3.uiMode;
        android.content.res.Configuration createOverrideConfigurationForDayNight = createOverrideConfigurationForDayNight(context, mapNightMode, configuration2.equals(configuration3) ? null : generateConfigDelta(configuration2, configuration3));
        androidx.appcompat.view.ContextThemeWrapper contextThemeWrapper = new androidx.appcompat.view.ContextThemeWrapper(context, androidx.appcompat.R.style.Theme_AppCompat_Empty);
        contextThemeWrapper.applyOverrideConfiguration(createOverrideConfigurationForDayNight);
        boolean z = false;
        try {
            z = context.getTheme() != null;
        } catch (java.lang.NullPointerException unused3) {
        }
        if (z) {
            androidx.core.content.res.ResourcesCompat.ThemeCompat.rebase(contextThemeWrapper.getTheme());
        }
        return super.attachBaseContext2(contextThemeWrapper);
    }

    public void callOnPanelClosed(int i, androidx.appcompat.app.AppCompatDelegateImpl.PanelFeatureState panelFeatureState, android.view.Menu menu) {
        if (menu == null) {
            if (panelFeatureState == null && i >= 0) {
                androidx.appcompat.app.AppCompatDelegateImpl.PanelFeatureState[] panelFeatureStateArr = this.mPanels;
                if (i < panelFeatureStateArr.length) {
                    panelFeatureState = panelFeatureStateArr[i];
                }
            }
            if (panelFeatureState != null) {
                menu = panelFeatureState.menu;
            }
        }
        if ((panelFeatureState == null || panelFeatureState.isOpen) && !this.mIsDestroyed) {
            this.mAppCompatWindowCallback.getWrapped().onPanelClosed(i, menu);
        }
    }

    public void checkCloseActionMenu(@androidx.annotation.NonNull androidx.appcompat.view.menu.MenuBuilder menuBuilder) {
        if (this.mClosingActionMenu) {
            return;
        }
        this.mClosingActionMenu = true;
        this.mDecorContentParent.dismissPopups();
        android.view.Window.Callback windowCallback = getWindowCallback();
        if (windowCallback != null && !this.mIsDestroyed) {
            windowCallback.onPanelClosed(108, menuBuilder);
        }
        this.mClosingActionMenu = false;
    }

    public void closePanel(int i) {
        closePanel(getPanelState(i, true), true);
    }

    public void closePanel(androidx.appcompat.app.AppCompatDelegateImpl.PanelFeatureState panelFeatureState, boolean z) {
        android.view.ViewGroup viewGroup;
        androidx.appcompat.widget.DecorContentParent decorContentParent;
        if (z && panelFeatureState.featureId == 0 && (decorContentParent = this.mDecorContentParent) != null && decorContentParent.isOverflowMenuShowing()) {
            checkCloseActionMenu(panelFeatureState.menu);
            return;
        }
        android.view.WindowManager windowManager = (android.view.WindowManager) this.mContext.getSystemService("window");
        if (windowManager != null && panelFeatureState.isOpen && (viewGroup = panelFeatureState.decorView) != null) {
            windowManager.removeView(viewGroup);
            if (z) {
                callOnPanelClosed(panelFeatureState.featureId, panelFeatureState, null);
            }
        }
        panelFeatureState.isPrepared = false;
        panelFeatureState.isHandled = false;
        panelFeatureState.isOpen = false;
        panelFeatureState.shownPanelView = null;
        panelFeatureState.refreshDecorView = true;
        if (this.mPreparedPanel == panelFeatureState) {
            this.mPreparedPanel = null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.appcompat.app.AppCompatDelegate
    public android.view.View createView(android.view.View view, java.lang.String str, @androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull android.util.AttributeSet attributeSet) {
        boolean z;
        boolean z2 = false;
        if (this.mAppCompatViewInflater == null) {
            java.lang.String string = this.mContext.obtainStyledAttributes(androidx.appcompat.R.styleable.AppCompatTheme).getString(androidx.appcompat.R.styleable.AppCompatTheme_viewInflaterClass);
            if (string == null) {
                this.mAppCompatViewInflater = new androidx.appcompat.app.AppCompatViewInflater();
            } else {
                try {
                    this.mAppCompatViewInflater = (androidx.appcompat.app.AppCompatViewInflater) java.lang.Class.forName(string).getDeclaredConstructor(new java.lang.Class[0]).newInstance(new java.lang.Object[0]);
                } catch (java.lang.Throwable unused) {
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    sb.append("Failed to instantiate custom view inflater ");
                    sb.append(string);
                    sb.append(". Falling back to default.");
                    this.mAppCompatViewInflater = new androidx.appcompat.app.AppCompatViewInflater();
                }
            }
        }
        boolean z3 = IS_PRE_LOLLIPOP;
        if (z3) {
            if (this.mLayoutIncludeDetector == null) {
                this.mLayoutIncludeDetector = new androidx.appcompat.app.LayoutIncludeDetector();
            }
            if (this.mLayoutIncludeDetector.detect(attributeSet)) {
                z = true;
            } else {
                if (!(attributeSet instanceof org.xmlpull.v1.XmlPullParser)) {
                    z2 = shouldInheritContext((android.view.ViewParent) view);
                } else if (((org.xmlpull.v1.XmlPullParser) attributeSet).getDepth() > 1) {
                    z2 = true;
                }
                z = z2;
            }
        } else {
            z = false;
        }
        return this.mAppCompatViewInflater.createView(view, str, context, attributeSet, z, z3, true, androidx.appcompat.widget.VectorEnabledTintResources.shouldBeUsed());
    }

    public void dismissPopups() {
        androidx.appcompat.view.menu.MenuBuilder menuBuilder;
        androidx.appcompat.widget.DecorContentParent decorContentParent = this.mDecorContentParent;
        if (decorContentParent != null) {
            decorContentParent.dismissPopups();
        }
        if (this.mActionModePopup != null) {
            this.mWindow.getDecorView().removeCallbacks(this.mShowActionModePopup);
            if (this.mActionModePopup.isShowing()) {
                try {
                    this.mActionModePopup.dismiss();
                } catch (java.lang.IllegalArgumentException unused) {
                }
            }
            this.mActionModePopup = null;
        }
        endOnGoingFadeAnimation();
        androidx.appcompat.app.AppCompatDelegateImpl.PanelFeatureState panelState = getPanelState(0, false);
        if (panelState == null || (menuBuilder = panelState.menu) == null) {
            return;
        }
        menuBuilder.close();
    }

    public boolean dispatchKeyEvent(android.view.KeyEvent keyEvent) {
        android.view.View decorView;
        java.lang.Object obj = this.mHost;
        if (((obj instanceof androidx.core.view.KeyEventDispatcher.Component) || (obj instanceof androidx.appcompat.app.AppCompatDialog)) && (decorView = this.mWindow.getDecorView()) != null && androidx.core.view.KeyEventDispatcher.dispatchBeforeHierarchy(decorView, keyEvent)) {
            return true;
        }
        if (keyEvent.getKeyCode() == 82 && this.mAppCompatWindowCallback.getWrapped().dispatchKeyEvent(keyEvent)) {
            return true;
        }
        int keyCode = keyEvent.getKeyCode();
        return keyEvent.getAction() == 0 ? onKeyDown(keyCode, keyEvent) : onKeyUp(keyCode, keyEvent);
    }

    public void doInvalidatePanelMenu(int i) {
        androidx.appcompat.app.AppCompatDelegateImpl.PanelFeatureState panelState;
        androidx.appcompat.app.AppCompatDelegateImpl.PanelFeatureState panelState2 = getPanelState(i, true);
        if (panelState2.menu != null) {
            android.os.Bundle bundle = new android.os.Bundle();
            panelState2.menu.saveActionViewStates(bundle);
            if (bundle.size() > 0) {
                panelState2.frozenActionViewState = bundle;
            }
            panelState2.menu.stopDispatchingItemsChanged();
            panelState2.menu.clear();
        }
        panelState2.refreshMenuContent = true;
        panelState2.refreshDecorView = true;
        if ((i != 108 && i != 0) || this.mDecorContentParent == null || (panelState = getPanelState(0, false)) == null) {
            return;
        }
        panelState.isPrepared = false;
        preparePanel(panelState, null);
    }

    public void endOnGoingFadeAnimation() {
        androidx.core.view.ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = this.mFadeAnim;
        if (viewPropertyAnimatorCompat != null) {
            viewPropertyAnimatorCompat.cancel();
        }
    }

    public androidx.appcompat.app.AppCompatDelegateImpl.PanelFeatureState findMenuPanel(android.view.Menu menu) {
        androidx.appcompat.app.AppCompatDelegateImpl.PanelFeatureState[] panelFeatureStateArr = this.mPanels;
        int length = panelFeatureStateArr != null ? panelFeatureStateArr.length : 0;
        for (int i = 0; i < length; i++) {
            androidx.appcompat.app.AppCompatDelegateImpl.PanelFeatureState panelFeatureState = panelFeatureStateArr[i];
            if (panelFeatureState != null && panelFeatureState.menu == menu) {
                return panelFeatureState;
            }
        }
        return null;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    @androidx.annotation.Nullable
    public <T extends android.view.View> T findViewById(@androidx.annotation.IdRes int i) {
        ensureSubDecor();
        return (T) this.mWindow.findViewById(i);
    }

    public final android.content.Context getActionBarThemedContext() {
        androidx.appcompat.app.ActionBar supportActionBar = getSupportActionBar();
        android.content.Context themedContext = supportActionBar != null ? supportActionBar.getThemedContext() : null;
        return themedContext == null ? this.mContext : themedContext;
    }

    @androidx.annotation.NonNull
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
    @androidx.annotation.VisibleForTesting
    public final androidx.appcompat.app.AppCompatDelegateImpl.AutoNightModeManager getAutoTimeNightModeManager() {
        return getAutoTimeNightModeManager(this.mContext);
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public final androidx.appcompat.app.ActionBarDrawerToggle.Delegate getDrawerToggleDelegate() {
        return new androidx.appcompat.app.AppCompatDelegateImpl.ActionBarDrawableToggleImpl();
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public int getLocalNightMode() {
        return this.mLocalNightMode;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public android.view.MenuInflater getMenuInflater() {
        if (this.mMenuInflater == null) {
            initWindowDecorActionBar();
            androidx.appcompat.app.ActionBar actionBar = this.mActionBar;
            this.mMenuInflater = new androidx.appcompat.view.SupportMenuInflater(actionBar != null ? actionBar.getThemedContext() : this.mContext);
        }
        return this.mMenuInflater;
    }

    public androidx.appcompat.app.AppCompatDelegateImpl.PanelFeatureState getPanelState(int i, boolean z) {
        androidx.appcompat.app.AppCompatDelegateImpl.PanelFeatureState[] panelFeatureStateArr = this.mPanels;
        if (panelFeatureStateArr == null || panelFeatureStateArr.length <= i) {
            androidx.appcompat.app.AppCompatDelegateImpl.PanelFeatureState[] panelFeatureStateArr2 = new androidx.appcompat.app.AppCompatDelegateImpl.PanelFeatureState[i + 1];
            if (panelFeatureStateArr != null) {
                java.lang.System.arraycopy(panelFeatureStateArr, 0, panelFeatureStateArr2, 0, panelFeatureStateArr.length);
            }
            this.mPanels = panelFeatureStateArr2;
            panelFeatureStateArr = panelFeatureStateArr2;
        }
        androidx.appcompat.app.AppCompatDelegateImpl.PanelFeatureState panelFeatureState = panelFeatureStateArr[i];
        if (panelFeatureState != null) {
            return panelFeatureState;
        }
        androidx.appcompat.app.AppCompatDelegateImpl.PanelFeatureState panelFeatureState2 = new androidx.appcompat.app.AppCompatDelegateImpl.PanelFeatureState(i);
        panelFeatureStateArr[i] = panelFeatureState2;
        return panelFeatureState2;
    }

    public android.view.ViewGroup getSubDecor() {
        return this.mSubDecor;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public androidx.appcompat.app.ActionBar getSupportActionBar() {
        initWindowDecorActionBar();
        return this.mActionBar;
    }

    public final java.lang.CharSequence getTitle() {
        java.lang.Object obj = this.mHost;
        return obj instanceof android.app.Activity ? ((android.app.Activity) obj).getTitle() : this.mTitle;
    }

    public final android.view.Window.Callback getWindowCallback() {
        return this.mWindow.getCallback();
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public boolean hasWindowFeature(int i) {
        int sanitizeWindowFeatureId = sanitizeWindowFeatureId(i);
        return (sanitizeWindowFeatureId != 1 ? sanitizeWindowFeatureId != 2 ? sanitizeWindowFeatureId != 5 ? sanitizeWindowFeatureId != 10 ? sanitizeWindowFeatureId != 108 ? sanitizeWindowFeatureId != 109 ? false : this.mOverlayActionBar : this.mHasActionBar : this.mOverlayActionMode : this.mFeatureIndeterminateProgress : this.mFeatureProgress : this.mWindowNoTitle) || this.mWindow.hasFeature(i);
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void installViewFactory() {
        android.view.LayoutInflater from = android.view.LayoutInflater.from(this.mContext);
        if (from.getFactory() == null) {
            androidx.core.view.LayoutInflaterCompat.setFactory2(from, this);
        } else {
            boolean z = from.getFactory2() instanceof androidx.appcompat.app.AppCompatDelegateImpl;
        }
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void invalidateOptionsMenu() {
        androidx.appcompat.app.ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar == null || !supportActionBar.invalidateOptionsMenu()) {
            invalidatePanelMenu(0);
        }
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public boolean isHandleNativeActionModesEnabled() {
        return this.mHandleNativeActionModes;
    }

    public int mapNightMode(@androidx.annotation.NonNull android.content.Context context, int i) {
        if (i == -100) {
            return -1;
        }
        if (i != -1) {
            if (i == 0) {
                if (android.os.Build.VERSION.SDK_INT < 23 || ((android.app.UiModeManager) context.getApplicationContext().getSystemService("uimode")).getNightMode() != 0) {
                    return getAutoTimeNightModeManager(context).getApplyableNightMode();
                }
                return -1;
            }
            if (i != 1 && i != 2) {
                if (i == 3) {
                    return getAutoBatteryNightModeManager(context).getApplyableNightMode();
                }
                throw new java.lang.IllegalStateException("Unknown value set for night mode. Please use one of the MODE_NIGHT values from AppCompatDelegate.");
            }
        }
        return i;
    }

    public boolean onBackPressed() {
        androidx.appcompat.view.ActionMode actionMode = this.mActionMode;
        if (actionMode != null) {
            actionMode.finish();
            return true;
        }
        androidx.appcompat.app.ActionBar supportActionBar = getSupportActionBar();
        return supportActionBar != null && supportActionBar.collapseActionView();
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void onConfigurationChanged(android.content.res.Configuration configuration) {
        androidx.appcompat.app.ActionBar supportActionBar;
        if (this.mHasActionBar && this.mSubDecorInstalled && (supportActionBar = getSupportActionBar()) != null) {
            supportActionBar.onConfigurationChanged(configuration);
        }
        androidx.appcompat.widget.AppCompatDrawableManager.get().onConfigurationChanged(this.mContext);
        applyDayNight(false);
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void onCreate(android.os.Bundle bundle) {
        java.lang.String str;
        this.mBaseContextAttached = true;
        applyDayNight(false);
        ensureWindow();
        java.lang.Object obj = this.mHost;
        if (obj instanceof android.app.Activity) {
            try {
                str = androidx.core.app.NavUtils.getParentActivityName((android.app.Activity) obj);
            } catch (java.lang.IllegalArgumentException unused) {
                str = null;
            }
            if (str != null) {
                androidx.appcompat.app.ActionBar peekSupportActionBar = peekSupportActionBar();
                if (peekSupportActionBar == null) {
                    this.mEnableDefaultActionBarUp = true;
                } else {
                    peekSupportActionBar.setDefaultDisplayHomeAsUpEnabled(true);
                }
            }
            androidx.appcompat.app.AppCompatDelegate.addActiveDelegate(this);
        }
        this.mCreated = true;
    }

    @Override // android.view.LayoutInflater.Factory2
    public final android.view.View onCreateView(android.view.View view, java.lang.String str, android.content.Context context, android.util.AttributeSet attributeSet) {
        return createView(view, str, context, attributeSet);
    }

    @Override // android.view.LayoutInflater.Factory
    public android.view.View onCreateView(java.lang.String str, android.content.Context context, android.util.AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x005b  */
    @Override // androidx.appcompat.app.AppCompatDelegate
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onDestroy() {
        androidx.appcompat.app.ActionBar actionBar;
        if (this.mHost instanceof android.app.Activity) {
            androidx.appcompat.app.AppCompatDelegate.removeActivityDelegate(this);
        }
        if (this.mInvalidatePanelMenuPosted) {
            this.mWindow.getDecorView().removeCallbacks(this.mInvalidatePanelMenuRunnable);
        }
        this.mStarted = false;
        this.mIsDestroyed = true;
        if (this.mLocalNightMode != -100) {
            java.lang.Object obj = this.mHost;
            if ((obj instanceof android.app.Activity) && ((android.app.Activity) obj).isChangingConfigurations()) {
                sLocalNightModes.put(this.mHost.getClass().getName(), java.lang.Integer.valueOf(this.mLocalNightMode));
                actionBar = this.mActionBar;
                if (actionBar != null) {
                    actionBar.onDestroy();
                }
                cleanupAutoManagers();
            }
        }
        sLocalNightModes.remove(this.mHost.getClass().getName());
        actionBar = this.mActionBar;
        if (actionBar != null) {
        }
        cleanupAutoManagers();
    }

    public boolean onKeyDown(int i, android.view.KeyEvent keyEvent) {
        if (i == 4) {
            this.mLongPressBackDown = (keyEvent.getFlags() & 128) != 0;
        } else if (i == 82) {
            onKeyDownPanel(0, keyEvent);
            return true;
        }
        return false;
    }

    public boolean onKeyShortcut(int i, android.view.KeyEvent keyEvent) {
        androidx.appcompat.app.ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null && supportActionBar.onKeyShortcut(i, keyEvent)) {
            return true;
        }
        androidx.appcompat.app.AppCompatDelegateImpl.PanelFeatureState panelFeatureState = this.mPreparedPanel;
        if (panelFeatureState != null && performPanelShortcut(panelFeatureState, keyEvent.getKeyCode(), keyEvent, 1)) {
            androidx.appcompat.app.AppCompatDelegateImpl.PanelFeatureState panelFeatureState2 = this.mPreparedPanel;
            if (panelFeatureState2 != null) {
                panelFeatureState2.isHandled = true;
            }
            return true;
        }
        if (this.mPreparedPanel == null) {
            androidx.appcompat.app.AppCompatDelegateImpl.PanelFeatureState panelState = getPanelState(0, true);
            preparePanel(panelState, keyEvent);
            boolean performPanelShortcut = performPanelShortcut(panelState, keyEvent.getKeyCode(), keyEvent, 1);
            panelState.isPrepared = false;
            if (performPanelShortcut) {
                return true;
            }
        }
        return false;
    }

    public boolean onKeyUp(int i, android.view.KeyEvent keyEvent) {
        if (i == 4) {
            boolean z = this.mLongPressBackDown;
            this.mLongPressBackDown = false;
            androidx.appcompat.app.AppCompatDelegateImpl.PanelFeatureState panelState = getPanelState(0, false);
            if (panelState != null && panelState.isOpen) {
                if (!z) {
                    closePanel(panelState, true);
                }
                return true;
            }
            if (onBackPressed()) {
                return true;
            }
        } else if (i == 82) {
            onKeyUpPanel(0, keyEvent);
            return true;
        }
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
    public boolean onMenuItemSelected(@androidx.annotation.NonNull androidx.appcompat.view.menu.MenuBuilder menuBuilder, @androidx.annotation.NonNull android.view.MenuItem menuItem) {
        androidx.appcompat.app.AppCompatDelegateImpl.PanelFeatureState findMenuPanel;
        android.view.Window.Callback windowCallback = getWindowCallback();
        if (windowCallback == null || this.mIsDestroyed || (findMenuPanel = findMenuPanel(menuBuilder.getRootMenu())) == null) {
            return false;
        }
        return windowCallback.onMenuItemSelected(findMenuPanel.featureId, menuItem);
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
    public void onMenuModeChange(@androidx.annotation.NonNull androidx.appcompat.view.menu.MenuBuilder menuBuilder) {
        reopenMenu(true);
    }

    public void onMenuOpened(int i) {
        androidx.appcompat.app.ActionBar supportActionBar;
        if (i != 108 || (supportActionBar = getSupportActionBar()) == null) {
            return;
        }
        supportActionBar.dispatchMenuVisibilityChanged(true);
    }

    public void onPanelClosed(int i) {
        if (i == 108) {
            androidx.appcompat.app.ActionBar supportActionBar = getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.dispatchMenuVisibilityChanged(false);
                return;
            }
            return;
        }
        if (i == 0) {
            androidx.appcompat.app.AppCompatDelegateImpl.PanelFeatureState panelState = getPanelState(i, true);
            if (panelState.isOpen) {
                closePanel(panelState, false);
            }
        }
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void onPostCreate(android.os.Bundle bundle) {
        ensureSubDecor();
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void onPostResume() {
        androidx.appcompat.app.ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setShowHideAnimationEnabled(true);
        }
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void onSaveInstanceState(android.os.Bundle bundle) {
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void onStart() {
        this.mStarted = true;
        applyDayNight();
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void onStop() {
        this.mStarted = false;
        androidx.appcompat.app.ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setShowHideAnimationEnabled(false);
        }
    }

    public void onSubDecorInstalled(android.view.ViewGroup viewGroup) {
    }

    public final androidx.appcompat.app.ActionBar peekSupportActionBar() {
        return this.mActionBar;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public boolean requestWindowFeature(int i) {
        int sanitizeWindowFeatureId = sanitizeWindowFeatureId(i);
        if (this.mWindowNoTitle && sanitizeWindowFeatureId == 108) {
            return false;
        }
        if (this.mHasActionBar && sanitizeWindowFeatureId == 1) {
            this.mHasActionBar = false;
        }
        if (sanitizeWindowFeatureId == 1) {
            throwFeatureRequestIfSubDecorInstalled();
            this.mWindowNoTitle = true;
            return true;
        }
        if (sanitizeWindowFeatureId == 2) {
            throwFeatureRequestIfSubDecorInstalled();
            this.mFeatureProgress = true;
            return true;
        }
        if (sanitizeWindowFeatureId == 5) {
            throwFeatureRequestIfSubDecorInstalled();
            this.mFeatureIndeterminateProgress = true;
            return true;
        }
        if (sanitizeWindowFeatureId == 10) {
            throwFeatureRequestIfSubDecorInstalled();
            this.mOverlayActionMode = true;
            return true;
        }
        if (sanitizeWindowFeatureId == 108) {
            throwFeatureRequestIfSubDecorInstalled();
            this.mHasActionBar = true;
            return true;
        }
        if (sanitizeWindowFeatureId != 109) {
            return this.mWindow.requestFeature(sanitizeWindowFeatureId);
        }
        throwFeatureRequestIfSubDecorInstalled();
        this.mOverlayActionBar = true;
        return true;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void setContentView(int i) {
        ensureSubDecor();
        android.view.ViewGroup viewGroup = (android.view.ViewGroup) this.mSubDecor.findViewById(android.R.id.content);
        viewGroup.removeAllViews();
        android.view.LayoutInflater.from(this.mContext).inflate(i, viewGroup);
        this.mAppCompatWindowCallback.getWrapped().onContentChanged();
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void setContentView(android.view.View view) {
        ensureSubDecor();
        android.view.ViewGroup viewGroup = (android.view.ViewGroup) this.mSubDecor.findViewById(android.R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.mAppCompatWindowCallback.getWrapped().onContentChanged();
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void setContentView(android.view.View view, android.view.ViewGroup.LayoutParams layoutParams) {
        ensureSubDecor();
        android.view.ViewGroup viewGroup = (android.view.ViewGroup) this.mSubDecor.findViewById(android.R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.mAppCompatWindowCallback.getWrapped().onContentChanged();
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void setHandleNativeActionModesEnabled(boolean z) {
        this.mHandleNativeActionModes = z;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    @androidx.annotation.RequiresApi(17)
    public void setLocalNightMode(int i) {
        if (this.mLocalNightMode != i) {
            this.mLocalNightMode = i;
            if (this.mBaseContextAttached) {
                applyDayNight();
            }
        }
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void setSupportActionBar(androidx.appcompat.widget.Toolbar toolbar) {
        if (this.mHost instanceof android.app.Activity) {
            androidx.appcompat.app.ActionBar supportActionBar = getSupportActionBar();
            if (supportActionBar instanceof androidx.appcompat.app.WindowDecorActionBar) {
                throw new java.lang.IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
            }
            this.mMenuInflater = null;
            if (supportActionBar != null) {
                supportActionBar.onDestroy();
            }
            if (toolbar != null) {
                androidx.appcompat.app.ToolbarActionBar toolbarActionBar = new androidx.appcompat.app.ToolbarActionBar(toolbar, getTitle(), this.mAppCompatWindowCallback);
                this.mActionBar = toolbarActionBar;
                this.mWindow.setCallback(toolbarActionBar.getWrappedWindowCallback());
            } else {
                this.mActionBar = null;
                this.mWindow.setCallback(this.mAppCompatWindowCallback);
            }
            invalidateOptionsMenu();
        }
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void setTheme(@androidx.annotation.StyleRes int i) {
        this.mThemeResId = i;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public final void setTitle(java.lang.CharSequence charSequence) {
        this.mTitle = charSequence;
        androidx.appcompat.widget.DecorContentParent decorContentParent = this.mDecorContentParent;
        if (decorContentParent != null) {
            decorContentParent.setWindowTitle(charSequence);
            return;
        }
        if (peekSupportActionBar() != null) {
            peekSupportActionBar().setWindowTitle(charSequence);
            return;
        }
        android.widget.TextView textView = this.mTitleView;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public final boolean shouldAnimateActionModeView() {
        android.view.ViewGroup viewGroup;
        return this.mSubDecorInstalled && (viewGroup = this.mSubDecor) != null && androidx.core.view.ViewCompat.isLaidOut(viewGroup);
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public androidx.appcompat.view.ActionMode startSupportActionMode(@androidx.annotation.NonNull androidx.appcompat.view.ActionMode.Callback callback) {
        androidx.appcompat.app.AppCompatCallback appCompatCallback;
        if (callback == null) {
            throw new java.lang.IllegalArgumentException("ActionMode callback can not be null.");
        }
        androidx.appcompat.view.ActionMode actionMode = this.mActionMode;
        if (actionMode != null) {
            actionMode.finish();
        }
        androidx.appcompat.app.AppCompatDelegateImpl.ActionModeCallbackWrapperV9 actionModeCallbackWrapperV9 = new androidx.appcompat.app.AppCompatDelegateImpl.ActionModeCallbackWrapperV9(callback);
        androidx.appcompat.app.ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            androidx.appcompat.view.ActionMode startActionMode = supportActionBar.startActionMode(actionModeCallbackWrapperV9);
            this.mActionMode = startActionMode;
            if (startActionMode != null && (appCompatCallback = this.mAppCompatCallback) != null) {
                appCompatCallback.onSupportActionModeStarted(startActionMode);
            }
        }
        if (this.mActionMode == null) {
            this.mActionMode = startSupportActionModeFromWindow(actionModeCallbackWrapperV9);
        }
        return this.mActionMode;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public androidx.appcompat.view.ActionMode startSupportActionModeFromWindow(@androidx.annotation.NonNull androidx.appcompat.view.ActionMode.Callback callback) {
        androidx.appcompat.view.ActionMode actionMode;
        android.content.Context context;
        androidx.appcompat.view.ActionMode actionMode2;
        androidx.appcompat.app.AppCompatCallback appCompatCallback;
        endOnGoingFadeAnimation();
        androidx.appcompat.view.ActionMode actionMode3 = this.mActionMode;
        if (actionMode3 != null) {
            actionMode3.finish();
        }
        if (!(callback instanceof androidx.appcompat.app.AppCompatDelegateImpl.ActionModeCallbackWrapperV9)) {
            callback = new androidx.appcompat.app.AppCompatDelegateImpl.ActionModeCallbackWrapperV9(callback);
        }
        androidx.appcompat.app.AppCompatCallback appCompatCallback2 = this.mAppCompatCallback;
        if (appCompatCallback2 != null && !this.mIsDestroyed) {
            try {
                actionMode = appCompatCallback2.onWindowStartingSupportActionMode(callback);
            } catch (java.lang.AbstractMethodError unused) {
            }
            if (actionMode == null) {
                this.mActionMode = actionMode;
            } else {
                if (this.mActionModeView == null) {
                    if (this.mIsFloating) {
                        android.util.TypedValue typedValue = new android.util.TypedValue();
                        android.content.res.Resources.Theme theme = this.mContext.getTheme();
                        theme.resolveAttribute(androidx.appcompat.R.attr.actionBarTheme, typedValue, true);
                        if (typedValue.resourceId != 0) {
                            android.content.res.Resources.Theme newTheme = this.mContext.getResources().newTheme();
                            newTheme.setTo(theme);
                            newTheme.applyStyle(typedValue.resourceId, true);
                            context = new androidx.appcompat.view.ContextThemeWrapper(this.mContext, 0);
                            context.getTheme().setTo(newTheme);
                        } else {
                            context = this.mContext;
                        }
                        this.mActionModeView = new androidx.appcompat.widget.ActionBarContextView(context);
                        android.widget.PopupWindow popupWindow = new android.widget.PopupWindow(context, (android.util.AttributeSet) null, androidx.appcompat.R.attr.actionModePopupWindowStyle);
                        this.mActionModePopup = popupWindow;
                        androidx.core.widget.PopupWindowCompat.setWindowLayoutType(popupWindow, 2);
                        this.mActionModePopup.setContentView(this.mActionModeView);
                        this.mActionModePopup.setWidth(-1);
                        context.getTheme().resolveAttribute(androidx.appcompat.R.attr.actionBarSize, typedValue, true);
                        this.mActionModeView.setContentHeight(android.util.TypedValue.complexToDimensionPixelSize(typedValue.data, context.getResources().getDisplayMetrics()));
                        this.mActionModePopup.setHeight(-2);
                        this.mShowActionModePopup = new androidx.appcompat.app.AppCompatDelegateImpl.AnonymousClass6();
                    } else {
                        androidx.appcompat.widget.ViewStubCompat viewStubCompat = (androidx.appcompat.widget.ViewStubCompat) this.mSubDecor.findViewById(androidx.appcompat.R.id.action_mode_bar_stub);
                        if (viewStubCompat != null) {
                            viewStubCompat.setLayoutInflater(android.view.LayoutInflater.from(getActionBarThemedContext()));
                            this.mActionModeView = (androidx.appcompat.widget.ActionBarContextView) viewStubCompat.inflate();
                        }
                    }
                }
                if (this.mActionModeView != null) {
                    endOnGoingFadeAnimation();
                    this.mActionModeView.killMode();
                    androidx.appcompat.view.StandaloneActionMode standaloneActionMode = new androidx.appcompat.view.StandaloneActionMode(this.mActionModeView.getContext(), this.mActionModeView, callback, this.mActionModePopup == null);
                    if (callback.onCreateActionMode(standaloneActionMode, standaloneActionMode.getMenu())) {
                        standaloneActionMode.invalidate();
                        this.mActionModeView.initForMode(standaloneActionMode);
                        this.mActionMode = standaloneActionMode;
                        if (shouldAnimateActionModeView()) {
                            this.mActionModeView.setAlpha(0.0f);
                            androidx.core.view.ViewPropertyAnimatorCompat alpha = androidx.core.view.ViewCompat.animate(this.mActionModeView).alpha(1.0f);
                            this.mFadeAnim = alpha;
                            alpha.setListener(new androidx.appcompat.app.AppCompatDelegateImpl.AnonymousClass7());
                        } else {
                            this.mActionModeView.setAlpha(1.0f);
                            this.mActionModeView.setVisibility(0);
                            this.mActionModeView.sendAccessibilityEvent(32);
                            if (this.mActionModeView.getParent() instanceof android.view.View) {
                                androidx.core.view.ViewCompat.requestApplyInsets((android.view.View) this.mActionModeView.getParent());
                            }
                        }
                        if (this.mActionModePopup != null) {
                            this.mWindow.getDecorView().post(this.mShowActionModePopup);
                        }
                    } else {
                        this.mActionMode = null;
                    }
                }
            }
            actionMode2 = this.mActionMode;
            if (actionMode2 != null && (appCompatCallback = this.mAppCompatCallback) != null) {
                appCompatCallback.onSupportActionModeStarted(actionMode2);
            }
            return this.mActionMode;
        }
        actionMode = null;
        if (actionMode == null) {
        }
        actionMode2 = this.mActionMode;
        if (actionMode2 != null) {
            appCompatCallback.onSupportActionModeStarted(actionMode2);
        }
        return this.mActionMode;
    }

    public final int updateStatusGuard(@androidx.annotation.Nullable androidx.core.view.WindowInsetsCompat windowInsetsCompat, @androidx.annotation.Nullable android.graphics.Rect rect) {
        boolean z;
        boolean z2;
        int systemWindowInsetTop = windowInsetsCompat != null ? windowInsetsCompat.getSystemWindowInsetTop() : rect != null ? rect.top : 0;
        androidx.appcompat.widget.ActionBarContextView actionBarContextView = this.mActionModeView;
        if (actionBarContextView == null || !(actionBarContextView.getLayoutParams() instanceof android.view.ViewGroup.MarginLayoutParams)) {
            z = false;
        } else {
            android.view.ViewGroup.MarginLayoutParams marginLayoutParams = (android.view.ViewGroup.MarginLayoutParams) this.mActionModeView.getLayoutParams();
            if (this.mActionModeView.isShown()) {
                if (this.mTempRect1 == null) {
                    this.mTempRect1 = new android.graphics.Rect();
                    this.mTempRect2 = new android.graphics.Rect();
                }
                android.graphics.Rect rect2 = this.mTempRect1;
                android.graphics.Rect rect3 = this.mTempRect2;
                if (windowInsetsCompat == null) {
                    rect2.set(rect);
                } else {
                    rect2.set(windowInsetsCompat.getSystemWindowInsetLeft(), windowInsetsCompat.getSystemWindowInsetTop(), windowInsetsCompat.getSystemWindowInsetRight(), windowInsetsCompat.getSystemWindowInsetBottom());
                }
                androidx.appcompat.widget.ViewUtils.computeFitSystemWindows(this.mSubDecor, rect2, rect3);
                int i = rect2.top;
                int i2 = rect2.left;
                int i3 = rect2.right;
                androidx.core.view.WindowInsetsCompat rootWindowInsets = androidx.core.view.ViewCompat.getRootWindowInsets(this.mSubDecor);
                int systemWindowInsetLeft = rootWindowInsets == null ? 0 : rootWindowInsets.getSystemWindowInsetLeft();
                int systemWindowInsetRight = rootWindowInsets == null ? 0 : rootWindowInsets.getSystemWindowInsetRight();
                if (marginLayoutParams.topMargin == i && marginLayoutParams.leftMargin == i2 && marginLayoutParams.rightMargin == i3) {
                    z2 = false;
                } else {
                    marginLayoutParams.topMargin = i;
                    marginLayoutParams.leftMargin = i2;
                    marginLayoutParams.rightMargin = i3;
                    z2 = true;
                }
                if (i <= 0 || this.mStatusGuard != null) {
                    android.view.View view = this.mStatusGuard;
                    if (view != null) {
                        android.view.ViewGroup.MarginLayoutParams marginLayoutParams2 = (android.view.ViewGroup.MarginLayoutParams) view.getLayoutParams();
                        int i4 = marginLayoutParams2.height;
                        int i5 = marginLayoutParams.topMargin;
                        if (i4 != i5 || marginLayoutParams2.leftMargin != systemWindowInsetLeft || marginLayoutParams2.rightMargin != systemWindowInsetRight) {
                            marginLayoutParams2.height = i5;
                            marginLayoutParams2.leftMargin = systemWindowInsetLeft;
                            marginLayoutParams2.rightMargin = systemWindowInsetRight;
                            this.mStatusGuard.setLayoutParams(marginLayoutParams2);
                        }
                    }
                } else {
                    android.view.View view2 = new android.view.View(this.mContext);
                    this.mStatusGuard = view2;
                    view2.setVisibility(8);
                    android.widget.FrameLayout.LayoutParams layoutParams = new android.widget.FrameLayout.LayoutParams(-1, marginLayoutParams.topMargin, 51);
                    layoutParams.leftMargin = systemWindowInsetLeft;
                    layoutParams.rightMargin = systemWindowInsetRight;
                    this.mSubDecor.addView(this.mStatusGuard, -1, layoutParams);
                }
                android.view.View view3 = this.mStatusGuard;
                r5 = view3 != null;
                if (r5 && view3.getVisibility() != 0) {
                    updateStatusGuardColor(this.mStatusGuard);
                }
                if (!this.mOverlayActionMode && r5) {
                    systemWindowInsetTop = 0;
                }
                z = r5;
                r5 = z2;
            } else if (marginLayoutParams.topMargin != 0) {
                marginLayoutParams.topMargin = 0;
                z = false;
            } else {
                z = false;
                r5 = false;
            }
            if (r5) {
                this.mActionModeView.setLayoutParams(marginLayoutParams);
            }
        }
        android.view.View view4 = this.mStatusGuard;
        if (view4 != null) {
            view4.setVisibility(z ? 0 : 8);
        }
        return systemWindowInsetTop;
    }
}
