package androidx.appcompat.app;

/* loaded from: classes.dex */
public abstract class ActionBar {
    public static final int DISPLAY_HOME_AS_UP = 4;
    public static final int DISPLAY_SHOW_CUSTOM = 16;
    public static final int DISPLAY_SHOW_HOME = 2;
    public static final int DISPLAY_SHOW_TITLE = 8;
    public static final int DISPLAY_USE_LOGO = 1;

    @java.lang.Deprecated
    public static final int NAVIGATION_MODE_LIST = 1;

    @java.lang.Deprecated
    public static final int NAVIGATION_MODE_STANDARD = 0;

    @java.lang.Deprecated
    public static final int NAVIGATION_MODE_TABS = 2;

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface DisplayOptions {
    }

    public static class LayoutParams extends android.view.ViewGroup.MarginLayoutParams {
        public int gravity;

        public LayoutParams(int i) {
            this(-2, -1, i);
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.gravity = 8388627;
        }

        public LayoutParams(int i, int i2, int i3) {
            super(i, i2);
            this.gravity = i3;
        }

        public LayoutParams(@androidx.annotation.NonNull android.content.Context context, android.util.AttributeSet attributeSet) {
            super(context, attributeSet);
            this.gravity = 0;
            android.content.res.TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, androidx.appcompat.R.styleable.ActionBarLayout);
            this.gravity = obtainStyledAttributes.getInt(androidx.appcompat.R.styleable.ActionBarLayout_android_layout_gravity, 0);
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.gravity = 0;
        }

        public LayoutParams(androidx.appcompat.app.ActionBar.LayoutParams layoutParams) {
            super((android.view.ViewGroup.MarginLayoutParams) layoutParams);
            this.gravity = 0;
            this.gravity = layoutParams.gravity;
        }
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface NavigationMode {
    }

    public interface OnMenuVisibilityListener {
        void onMenuVisibilityChanged(boolean z);
    }

    @java.lang.Deprecated
    public interface OnNavigationListener {
        boolean onNavigationItemSelected(int i, long j);
    }

    @java.lang.Deprecated
    public static abstract class Tab {
        public static final int INVALID_POSITION = -1;

        public abstract java.lang.CharSequence getContentDescription();

        public abstract android.view.View getCustomView();

        public abstract android.graphics.drawable.Drawable getIcon();

        public abstract int getPosition();

        public abstract java.lang.Object getTag();

        public abstract java.lang.CharSequence getText();

        public abstract void select();

        public abstract androidx.appcompat.app.ActionBar.Tab setContentDescription(@androidx.annotation.StringRes int i);

        public abstract androidx.appcompat.app.ActionBar.Tab setContentDescription(java.lang.CharSequence charSequence);

        public abstract androidx.appcompat.app.ActionBar.Tab setCustomView(int i);

        public abstract androidx.appcompat.app.ActionBar.Tab setCustomView(android.view.View view);

        public abstract androidx.appcompat.app.ActionBar.Tab setIcon(@androidx.annotation.DrawableRes int i);

        public abstract androidx.appcompat.app.ActionBar.Tab setIcon(android.graphics.drawable.Drawable drawable);

        public abstract androidx.appcompat.app.ActionBar.Tab setTabListener(androidx.appcompat.app.ActionBar.TabListener tabListener);

        public abstract androidx.appcompat.app.ActionBar.Tab setTag(java.lang.Object obj);

        public abstract androidx.appcompat.app.ActionBar.Tab setText(int i);

        public abstract androidx.appcompat.app.ActionBar.Tab setText(java.lang.CharSequence charSequence);
    }

    @java.lang.Deprecated
    public interface TabListener {
        void onTabReselected(androidx.appcompat.app.ActionBar.Tab tab, androidx.fragment.app.FragmentTransaction fragmentTransaction);

        void onTabSelected(androidx.appcompat.app.ActionBar.Tab tab, androidx.fragment.app.FragmentTransaction fragmentTransaction);

        void onTabUnselected(androidx.appcompat.app.ActionBar.Tab tab, androidx.fragment.app.FragmentTransaction fragmentTransaction);
    }

    public abstract void addOnMenuVisibilityListener(androidx.appcompat.app.ActionBar.OnMenuVisibilityListener onMenuVisibilityListener);

    @java.lang.Deprecated
    public abstract void addTab(androidx.appcompat.app.ActionBar.Tab tab);

    @java.lang.Deprecated
    public abstract void addTab(androidx.appcompat.app.ActionBar.Tab tab, int i);

    @java.lang.Deprecated
    public abstract void addTab(androidx.appcompat.app.ActionBar.Tab tab, int i, boolean z);

    @java.lang.Deprecated
    public abstract void addTab(androidx.appcompat.app.ActionBar.Tab tab, boolean z);

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean closeOptionsMenu() {
        return false;
    }

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean collapseActionView() {
        return false;
    }

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void dispatchMenuVisibilityChanged(boolean z) {
    }

    public abstract android.view.View getCustomView();

    public abstract int getDisplayOptions();

    public float getElevation() {
        return 0.0f;
    }

    public abstract int getHeight();

    public int getHideOffset() {
        return 0;
    }

    @java.lang.Deprecated
    public abstract int getNavigationItemCount();

    @java.lang.Deprecated
    public abstract int getNavigationMode();

    @java.lang.Deprecated
    public abstract int getSelectedNavigationIndex();

    @androidx.annotation.Nullable
    @java.lang.Deprecated
    public abstract androidx.appcompat.app.ActionBar.Tab getSelectedTab();

    @androidx.annotation.Nullable
    public abstract java.lang.CharSequence getSubtitle();

    @java.lang.Deprecated
    public abstract androidx.appcompat.app.ActionBar.Tab getTabAt(int i);

    @java.lang.Deprecated
    public abstract int getTabCount();

    public android.content.Context getThemedContext() {
        return null;
    }

    @androidx.annotation.Nullable
    public abstract java.lang.CharSequence getTitle();

    public abstract void hide();

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean invalidateOptionsMenu() {
        return false;
    }

    public boolean isHideOnContentScrollEnabled() {
        return false;
    }

    public abstract boolean isShowing();

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean isTitleTruncated() {
        return false;
    }

    @java.lang.Deprecated
    public abstract androidx.appcompat.app.ActionBar.Tab newTab();

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void onConfigurationChanged(android.content.res.Configuration configuration) {
    }

    public void onDestroy() {
    }

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean onKeyShortcut(int i, android.view.KeyEvent keyEvent) {
        return false;
    }

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean onMenuKeyEvent(android.view.KeyEvent keyEvent) {
        return false;
    }

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean openOptionsMenu() {
        return false;
    }

    @java.lang.Deprecated
    public abstract void removeAllTabs();

    public abstract void removeOnMenuVisibilityListener(androidx.appcompat.app.ActionBar.OnMenuVisibilityListener onMenuVisibilityListener);

    @java.lang.Deprecated
    public abstract void removeTab(androidx.appcompat.app.ActionBar.Tab tab);

    @java.lang.Deprecated
    public abstract void removeTabAt(int i);

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean requestFocus() {
        return false;
    }

    @java.lang.Deprecated
    public abstract void selectTab(androidx.appcompat.app.ActionBar.Tab tab);

    public abstract void setBackgroundDrawable(@androidx.annotation.Nullable android.graphics.drawable.Drawable drawable);

    public abstract void setCustomView(int i);

    public abstract void setCustomView(android.view.View view);

    public abstract void setCustomView(android.view.View view, androidx.appcompat.app.ActionBar.LayoutParams layoutParams);

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setDefaultDisplayHomeAsUpEnabled(boolean z) {
    }

    public abstract void setDisplayHomeAsUpEnabled(boolean z);

    public abstract void setDisplayOptions(int i);

    public abstract void setDisplayOptions(int i, int i2);

    public abstract void setDisplayShowCustomEnabled(boolean z);

    public abstract void setDisplayShowHomeEnabled(boolean z);

    public abstract void setDisplayShowTitleEnabled(boolean z);

    public abstract void setDisplayUseLogoEnabled(boolean z);

    public void setElevation(float f) {
        if (f != 0.0f) {
            throw new java.lang.UnsupportedOperationException("Setting a non-zero elevation is not supported in this action bar configuration.");
        }
    }

    public void setHideOffset(int i) {
        if (i != 0) {
            throw new java.lang.UnsupportedOperationException("Setting an explicit action bar hide offset is not supported in this action bar configuration.");
        }
    }

    public void setHideOnContentScrollEnabled(boolean z) {
        if (z) {
            throw new java.lang.UnsupportedOperationException("Hide on content scroll is not supported in this action bar configuration.");
        }
    }

    public void setHomeActionContentDescription(@androidx.annotation.StringRes int i) {
    }

    public void setHomeActionContentDescription(@androidx.annotation.Nullable java.lang.CharSequence charSequence) {
    }

    public void setHomeAsUpIndicator(@androidx.annotation.DrawableRes int i) {
    }

    public void setHomeAsUpIndicator(@androidx.annotation.Nullable android.graphics.drawable.Drawable drawable) {
    }

    public void setHomeButtonEnabled(boolean z) {
    }

    public abstract void setIcon(@androidx.annotation.DrawableRes int i);

    public abstract void setIcon(android.graphics.drawable.Drawable drawable);

    @java.lang.Deprecated
    public abstract void setListNavigationCallbacks(android.widget.SpinnerAdapter spinnerAdapter, androidx.appcompat.app.ActionBar.OnNavigationListener onNavigationListener);

    public abstract void setLogo(@androidx.annotation.DrawableRes int i);

    public abstract void setLogo(android.graphics.drawable.Drawable drawable);

    @java.lang.Deprecated
    public abstract void setNavigationMode(int i);

    @java.lang.Deprecated
    public abstract void setSelectedNavigationItem(int i);

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setShowHideAnimationEnabled(boolean z) {
    }

    public void setSplitBackgroundDrawable(android.graphics.drawable.Drawable drawable) {
    }

    public void setStackedBackgroundDrawable(android.graphics.drawable.Drawable drawable) {
    }

    public abstract void setSubtitle(int i);

    public abstract void setSubtitle(java.lang.CharSequence charSequence);

    public abstract void setTitle(@androidx.annotation.StringRes int i);

    public abstract void setTitle(java.lang.CharSequence charSequence);

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setWindowTitle(java.lang.CharSequence charSequence) {
    }

    public abstract void show();

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public androidx.appcompat.view.ActionMode startActionMode(androidx.appcompat.view.ActionMode.Callback callback) {
        return null;
    }
}
