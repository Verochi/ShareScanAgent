package androidx.appcompat.app;

/* loaded from: classes.dex */
public class ActionBarDrawerToggle implements androidx.drawerlayout.widget.DrawerLayout.DrawerListener {
    private final androidx.appcompat.app.ActionBarDrawerToggle.Delegate mActivityImpl;
    private final int mCloseDrawerContentDescRes;
    boolean mDrawerIndicatorEnabled;
    private final androidx.drawerlayout.widget.DrawerLayout mDrawerLayout;
    private boolean mDrawerSlideAnimationEnabled;
    private boolean mHasCustomUpIndicator;
    private android.graphics.drawable.Drawable mHomeAsUpIndicator;
    private final int mOpenDrawerContentDescRes;
    private androidx.appcompat.graphics.drawable.DrawerArrowDrawable mSlider;
    android.view.View.OnClickListener mToolbarNavigationClickListener;
    private boolean mWarnedForDisplayHomeAsUp;

    /* renamed from: androidx.appcompat.app.ActionBarDrawerToggle$1, reason: invalid class name */
    public class AnonymousClass1 implements android.view.View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(android.view.View view) {
            androidx.appcompat.app.ActionBarDrawerToggle actionBarDrawerToggle = androidx.appcompat.app.ActionBarDrawerToggle.this;
            if (actionBarDrawerToggle.mDrawerIndicatorEnabled) {
                actionBarDrawerToggle.toggle();
                return;
            }
            android.view.View.OnClickListener onClickListener = actionBarDrawerToggle.mToolbarNavigationClickListener;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
        }
    }

    public interface Delegate {
        android.content.Context getActionBarThemedContext();

        android.graphics.drawable.Drawable getThemeUpIndicator();

        boolean isNavigationVisible();

        void setActionBarDescription(@androidx.annotation.StringRes int i);

        void setActionBarUpIndicator(android.graphics.drawable.Drawable drawable, @androidx.annotation.StringRes int i);
    }

    public interface DelegateProvider {
        @androidx.annotation.Nullable
        androidx.appcompat.app.ActionBarDrawerToggle.Delegate getDrawerToggleDelegate();
    }

    public static class FrameworkActionBarDelegate implements androidx.appcompat.app.ActionBarDrawerToggle.Delegate {
        private final android.app.Activity mActivity;
        private androidx.appcompat.app.ActionBarDrawerToggleHoneycomb.SetIndicatorInfo mSetIndicatorInfo;

        public FrameworkActionBarDelegate(android.app.Activity activity) {
            this.mActivity = activity;
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public android.content.Context getActionBarThemedContext() {
            android.app.ActionBar actionBar = this.mActivity.getActionBar();
            return actionBar != null ? actionBar.getThemedContext() : this.mActivity;
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public android.graphics.drawable.Drawable getThemeUpIndicator() {
            android.content.res.TypedArray obtainStyledAttributes = getActionBarThemedContext().obtainStyledAttributes(null, new int[]{android.R.attr.homeAsUpIndicator}, android.R.attr.actionBarStyle, 0);
            android.graphics.drawable.Drawable drawable = obtainStyledAttributes.getDrawable(0);
            obtainStyledAttributes.recycle();
            return drawable;
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public boolean isNavigationVisible() {
            android.app.ActionBar actionBar = this.mActivity.getActionBar();
            return (actionBar == null || (actionBar.getDisplayOptions() & 4) == 0) ? false : true;
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public void setActionBarDescription(int i) {
            android.app.ActionBar actionBar = this.mActivity.getActionBar();
            if (actionBar != null) {
                actionBar.setHomeActionContentDescription(i);
            }
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public void setActionBarUpIndicator(android.graphics.drawable.Drawable drawable, int i) {
            android.app.ActionBar actionBar = this.mActivity.getActionBar();
            if (actionBar != null) {
                actionBar.setHomeAsUpIndicator(drawable);
                actionBar.setHomeActionContentDescription(i);
            }
        }
    }

    public static class ToolbarCompatDelegate implements androidx.appcompat.app.ActionBarDrawerToggle.Delegate {
        final java.lang.CharSequence mDefaultContentDescription;
        final android.graphics.drawable.Drawable mDefaultUpIndicator;
        final androidx.appcompat.widget.Toolbar mToolbar;

        public ToolbarCompatDelegate(androidx.appcompat.widget.Toolbar toolbar) {
            this.mToolbar = toolbar;
            this.mDefaultUpIndicator = toolbar.getNavigationIcon();
            this.mDefaultContentDescription = toolbar.getNavigationContentDescription();
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public android.content.Context getActionBarThemedContext() {
            return this.mToolbar.getContext();
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public android.graphics.drawable.Drawable getThemeUpIndicator() {
            return this.mDefaultUpIndicator;
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public boolean isNavigationVisible() {
            return true;
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public void setActionBarDescription(@androidx.annotation.StringRes int i) {
            if (i == 0) {
                this.mToolbar.setNavigationContentDescription(this.mDefaultContentDescription);
            } else {
                this.mToolbar.setNavigationContentDescription(i);
            }
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public void setActionBarUpIndicator(android.graphics.drawable.Drawable drawable, @androidx.annotation.StringRes int i) {
            this.mToolbar.setNavigationIcon(drawable);
            setActionBarDescription(i);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ActionBarDrawerToggle(android.app.Activity activity, androidx.appcompat.widget.Toolbar toolbar, androidx.drawerlayout.widget.DrawerLayout drawerLayout, androidx.appcompat.graphics.drawable.DrawerArrowDrawable drawerArrowDrawable, @androidx.annotation.StringRes int i, @androidx.annotation.StringRes int i2) {
        this.mDrawerSlideAnimationEnabled = true;
        this.mDrawerIndicatorEnabled = true;
        this.mWarnedForDisplayHomeAsUp = false;
        if (toolbar != null) {
            this.mActivityImpl = new androidx.appcompat.app.ActionBarDrawerToggle.ToolbarCompatDelegate(toolbar);
            toolbar.setNavigationOnClickListener(new androidx.appcompat.app.ActionBarDrawerToggle.AnonymousClass1());
        } else if (activity instanceof androidx.appcompat.app.ActionBarDrawerToggle.DelegateProvider) {
            this.mActivityImpl = ((androidx.appcompat.app.ActionBarDrawerToggle.DelegateProvider) activity).getDrawerToggleDelegate();
        } else {
            this.mActivityImpl = new androidx.appcompat.app.ActionBarDrawerToggle.FrameworkActionBarDelegate(activity);
        }
        this.mDrawerLayout = drawerLayout;
        this.mOpenDrawerContentDescRes = i;
        this.mCloseDrawerContentDescRes = i2;
        if (drawerArrowDrawable == null) {
            this.mSlider = new androidx.appcompat.graphics.drawable.DrawerArrowDrawable(this.mActivityImpl.getActionBarThemedContext());
        } else {
            this.mSlider = drawerArrowDrawable;
        }
        this.mHomeAsUpIndicator = getThemeUpIndicator();
    }

    public ActionBarDrawerToggle(android.app.Activity activity, androidx.drawerlayout.widget.DrawerLayout drawerLayout, @androidx.annotation.StringRes int i, @androidx.annotation.StringRes int i2) {
        this(activity, null, drawerLayout, null, i, i2);
    }

    public ActionBarDrawerToggle(android.app.Activity activity, androidx.drawerlayout.widget.DrawerLayout drawerLayout, androidx.appcompat.widget.Toolbar toolbar, @androidx.annotation.StringRes int i, @androidx.annotation.StringRes int i2) {
        this(activity, toolbar, drawerLayout, null, i, i2);
    }

    private void setPosition(float f) {
        if (f == 1.0f) {
            this.mSlider.setVerticalMirror(true);
        } else if (f == 0.0f) {
            this.mSlider.setVerticalMirror(false);
        }
        this.mSlider.setProgress(f);
    }

    @androidx.annotation.NonNull
    public androidx.appcompat.graphics.drawable.DrawerArrowDrawable getDrawerArrowDrawable() {
        return this.mSlider;
    }

    public android.graphics.drawable.Drawable getThemeUpIndicator() {
        return this.mActivityImpl.getThemeUpIndicator();
    }

    public android.view.View.OnClickListener getToolbarNavigationClickListener() {
        return this.mToolbarNavigationClickListener;
    }

    public boolean isDrawerIndicatorEnabled() {
        return this.mDrawerIndicatorEnabled;
    }

    public boolean isDrawerSlideAnimationEnabled() {
        return this.mDrawerSlideAnimationEnabled;
    }

    public void onConfigurationChanged(android.content.res.Configuration configuration) {
        if (!this.mHasCustomUpIndicator) {
            this.mHomeAsUpIndicator = getThemeUpIndicator();
        }
        syncState();
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onDrawerClosed(android.view.View view) {
        setPosition(0.0f);
        if (this.mDrawerIndicatorEnabled) {
            setActionBarDescription(this.mOpenDrawerContentDescRes);
        }
        com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackDrawerClosed(view);
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onDrawerOpened(android.view.View view) {
        setPosition(1.0f);
        if (this.mDrawerIndicatorEnabled) {
            setActionBarDescription(this.mCloseDrawerContentDescRes);
        }
        com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackDrawerOpened(view);
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
    public void onDrawerSlide(android.view.View view, float f) {
        if (this.mDrawerSlideAnimationEnabled) {
            setPosition(java.lang.Math.min(1.0f, java.lang.Math.max(0.0f, f)));
        } else {
            setPosition(0.0f);
        }
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
    public void onDrawerStateChanged(int i) {
    }

    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public boolean onOptionsItemSelected(android.view.MenuItem menuItem) {
        if (menuItem == null || menuItem.getItemId() != 16908332 || !this.mDrawerIndicatorEnabled) {
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackMenuItem(this, menuItem);
            return false;
        }
        toggle();
        com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackMenuItem(this, menuItem);
        return true;
    }

    public void setActionBarDescription(int i) {
        this.mActivityImpl.setActionBarDescription(i);
    }

    public void setActionBarUpIndicator(android.graphics.drawable.Drawable drawable, int i) {
        if (!this.mWarnedForDisplayHomeAsUp && !this.mActivityImpl.isNavigationVisible()) {
            this.mWarnedForDisplayHomeAsUp = true;
        }
        this.mActivityImpl.setActionBarUpIndicator(drawable, i);
    }

    public void setDrawerArrowDrawable(@androidx.annotation.NonNull androidx.appcompat.graphics.drawable.DrawerArrowDrawable drawerArrowDrawable) {
        this.mSlider = drawerArrowDrawable;
        syncState();
    }

    public void setDrawerIndicatorEnabled(boolean z) {
        if (z != this.mDrawerIndicatorEnabled) {
            if (z) {
                setActionBarUpIndicator(this.mSlider, this.mDrawerLayout.isDrawerOpen(androidx.core.view.GravityCompat.START) ? this.mCloseDrawerContentDescRes : this.mOpenDrawerContentDescRes);
            } else {
                setActionBarUpIndicator(this.mHomeAsUpIndicator, 0);
            }
            this.mDrawerIndicatorEnabled = z;
        }
    }

    public void setDrawerSlideAnimationEnabled(boolean z) {
        this.mDrawerSlideAnimationEnabled = z;
        if (z) {
            return;
        }
        setPosition(0.0f);
    }

    public void setHomeAsUpIndicator(int i) {
        setHomeAsUpIndicator(i != 0 ? this.mDrawerLayout.getResources().getDrawable(i) : null);
    }

    public void setHomeAsUpIndicator(android.graphics.drawable.Drawable drawable) {
        if (drawable == null) {
            this.mHomeAsUpIndicator = getThemeUpIndicator();
            this.mHasCustomUpIndicator = false;
        } else {
            this.mHomeAsUpIndicator = drawable;
            this.mHasCustomUpIndicator = true;
        }
        if (this.mDrawerIndicatorEnabled) {
            return;
        }
        setActionBarUpIndicator(this.mHomeAsUpIndicator, 0);
    }

    public void setToolbarNavigationClickListener(android.view.View.OnClickListener onClickListener) {
        this.mToolbarNavigationClickListener = onClickListener;
    }

    public void syncState() {
        if (this.mDrawerLayout.isDrawerOpen(androidx.core.view.GravityCompat.START)) {
            setPosition(1.0f);
        } else {
            setPosition(0.0f);
        }
        if (this.mDrawerIndicatorEnabled) {
            setActionBarUpIndicator(this.mSlider, this.mDrawerLayout.isDrawerOpen(androidx.core.view.GravityCompat.START) ? this.mCloseDrawerContentDescRes : this.mOpenDrawerContentDescRes);
        }
    }

    public void toggle() {
        int drawerLockMode = this.mDrawerLayout.getDrawerLockMode(androidx.core.view.GravityCompat.START);
        if (this.mDrawerLayout.isDrawerVisible(androidx.core.view.GravityCompat.START) && drawerLockMode != 2) {
            this.mDrawerLayout.closeDrawer(androidx.core.view.GravityCompat.START);
        } else if (drawerLockMode != 1) {
            this.mDrawerLayout.openDrawer(androidx.core.view.GravityCompat.START);
        }
    }
}
