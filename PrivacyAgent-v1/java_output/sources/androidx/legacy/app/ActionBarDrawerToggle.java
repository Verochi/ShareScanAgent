package androidx.legacy.app;

@java.lang.Deprecated
/* loaded from: classes.dex */
public class ActionBarDrawerToggle implements androidx.drawerlayout.widget.DrawerLayout.DrawerListener {
    private static final int ID_HOME = 16908332;
    private static final java.lang.String TAG = "ActionBarDrawerToggle";
    private static final int[] THEME_ATTRS = {android.R.attr.homeAsUpIndicator};
    private static final float TOGGLE_DRAWABLE_OFFSET = 0.33333334f;
    final android.app.Activity mActivity;
    private final androidx.legacy.app.ActionBarDrawerToggle.Delegate mActivityImpl;
    private final int mCloseDrawerContentDescRes;
    private android.graphics.drawable.Drawable mDrawerImage;
    private final int mDrawerImageResource;
    private boolean mDrawerIndicatorEnabled;
    private final androidx.drawerlayout.widget.DrawerLayout mDrawerLayout;
    private boolean mHasCustomUpIndicator;
    private android.graphics.drawable.Drawable mHomeAsUpIndicator;
    private final int mOpenDrawerContentDescRes;
    private androidx.legacy.app.ActionBarDrawerToggle.SetIndicatorInfo mSetIndicatorInfo;
    private androidx.legacy.app.ActionBarDrawerToggle.SlideDrawable mSlider;

    @java.lang.Deprecated
    public interface Delegate {
        @androidx.annotation.Nullable
        android.graphics.drawable.Drawable getThemeUpIndicator();

        void setActionBarDescription(@androidx.annotation.StringRes int i);

        void setActionBarUpIndicator(android.graphics.drawable.Drawable drawable, @androidx.annotation.StringRes int i);
    }

    @java.lang.Deprecated
    public interface DelegateProvider {
        @androidx.annotation.Nullable
        androidx.legacy.app.ActionBarDrawerToggle.Delegate getDrawerToggleDelegate();
    }

    public static class SetIndicatorInfo {
        java.lang.reflect.Method mSetHomeActionContentDescription;
        java.lang.reflect.Method mSetHomeAsUpIndicator;
        android.widget.ImageView mUpIndicatorView;

        public SetIndicatorInfo(android.app.Activity activity) {
            try {
                this.mSetHomeAsUpIndicator = android.app.ActionBar.class.getDeclaredMethod("setHomeAsUpIndicator", android.graphics.drawable.Drawable.class);
                this.mSetHomeActionContentDescription = android.app.ActionBar.class.getDeclaredMethod("setHomeActionContentDescription", java.lang.Integer.TYPE);
            } catch (java.lang.NoSuchMethodException unused) {
                android.view.View findViewById = activity.findViewById(16908332);
                if (findViewById == null) {
                    return;
                }
                android.view.ViewGroup viewGroup = (android.view.ViewGroup) findViewById.getParent();
                if (viewGroup.getChildCount() != 2) {
                    return;
                }
                android.view.View childAt = viewGroup.getChildAt(0);
                childAt = childAt.getId() == 16908332 ? viewGroup.getChildAt(1) : childAt;
                if (childAt instanceof android.widget.ImageView) {
                    this.mUpIndicatorView = (android.widget.ImageView) childAt;
                }
            }
        }
    }

    public class SlideDrawable extends android.graphics.drawable.InsetDrawable implements android.graphics.drawable.Drawable.Callback {
        private final boolean mHasMirroring;
        private float mOffset;
        private float mPosition;
        private final android.graphics.Rect mTmpRect;

        public SlideDrawable(android.graphics.drawable.Drawable drawable) {
            super(drawable, 0);
            this.mHasMirroring = true;
            this.mTmpRect = new android.graphics.Rect();
        }

        @Override // android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
        public void draw(@androidx.annotation.NonNull android.graphics.Canvas canvas) {
            copyBounds(this.mTmpRect);
            canvas.save();
            boolean z = androidx.core.view.ViewCompat.getLayoutDirection(androidx.legacy.app.ActionBarDrawerToggle.this.mActivity.getWindow().getDecorView()) == 1;
            int i = z ? -1 : 1;
            float width = this.mTmpRect.width();
            canvas.translate((-this.mOffset) * width * this.mPosition * i, 0.0f);
            if (z && !this.mHasMirroring) {
                canvas.translate(width, 0.0f);
                canvas.scale(-1.0f, 1.0f);
            }
            super.draw(canvas);
            canvas.restore();
        }

        public float getPosition() {
            return this.mPosition;
        }

        public void setOffset(float f) {
            this.mOffset = f;
            invalidateSelf();
        }

        public void setPosition(float f) {
            this.mPosition = f;
            invalidateSelf();
        }
    }

    public ActionBarDrawerToggle(android.app.Activity activity, androidx.drawerlayout.widget.DrawerLayout drawerLayout, @androidx.annotation.DrawableRes int i, @androidx.annotation.StringRes int i2, @androidx.annotation.StringRes int i3) {
        this(activity, drawerLayout, !assumeMaterial(activity), i, i2, i3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ActionBarDrawerToggle(android.app.Activity activity, androidx.drawerlayout.widget.DrawerLayout drawerLayout, boolean z, @androidx.annotation.DrawableRes int i, @androidx.annotation.StringRes int i2, @androidx.annotation.StringRes int i3) {
        this.mDrawerIndicatorEnabled = true;
        this.mActivity = activity;
        if (activity instanceof androidx.legacy.app.ActionBarDrawerToggle.DelegateProvider) {
            this.mActivityImpl = ((androidx.legacy.app.ActionBarDrawerToggle.DelegateProvider) activity).getDrawerToggleDelegate();
        } else {
            this.mActivityImpl = null;
        }
        this.mDrawerLayout = drawerLayout;
        this.mDrawerImageResource = i;
        this.mOpenDrawerContentDescRes = i2;
        this.mCloseDrawerContentDescRes = i3;
        this.mHomeAsUpIndicator = getThemeUpIndicator();
        this.mDrawerImage = androidx.core.content.ContextCompat.getDrawable(activity, i);
        androidx.legacy.app.ActionBarDrawerToggle.SlideDrawable slideDrawable = new androidx.legacy.app.ActionBarDrawerToggle.SlideDrawable(this.mDrawerImage);
        this.mSlider = slideDrawable;
        slideDrawable.setOffset(z ? TOGGLE_DRAWABLE_OFFSET : 0.0f);
    }

    private static boolean assumeMaterial(android.content.Context context) {
        return context.getApplicationInfo().targetSdkVersion >= 21;
    }

    private android.graphics.drawable.Drawable getThemeUpIndicator() {
        androidx.legacy.app.ActionBarDrawerToggle.Delegate delegate = this.mActivityImpl;
        if (delegate != null) {
            return delegate.getThemeUpIndicator();
        }
        android.app.ActionBar actionBar = this.mActivity.getActionBar();
        android.content.res.TypedArray obtainStyledAttributes = (actionBar != null ? actionBar.getThemedContext() : this.mActivity).obtainStyledAttributes(null, THEME_ATTRS, android.R.attr.actionBarStyle, 0);
        android.graphics.drawable.Drawable drawable = obtainStyledAttributes.getDrawable(0);
        obtainStyledAttributes.recycle();
        return drawable;
    }

    private void setActionBarDescription(int i) {
        androidx.legacy.app.ActionBarDrawerToggle.Delegate delegate = this.mActivityImpl;
        if (delegate != null) {
            delegate.setActionBarDescription(i);
            return;
        }
        android.app.ActionBar actionBar = this.mActivity.getActionBar();
        if (actionBar != null) {
            actionBar.setHomeActionContentDescription(i);
        }
    }

    private void setActionBarUpIndicator(android.graphics.drawable.Drawable drawable, int i) {
        androidx.legacy.app.ActionBarDrawerToggle.Delegate delegate = this.mActivityImpl;
        if (delegate != null) {
            delegate.setActionBarUpIndicator(drawable, i);
            return;
        }
        android.app.ActionBar actionBar = this.mActivity.getActionBar();
        if (actionBar != null) {
            actionBar.setHomeAsUpIndicator(drawable);
            actionBar.setHomeActionContentDescription(i);
        }
    }

    public boolean isDrawerIndicatorEnabled() {
        return this.mDrawerIndicatorEnabled;
    }

    public void onConfigurationChanged(android.content.res.Configuration configuration) {
        if (!this.mHasCustomUpIndicator) {
            this.mHomeAsUpIndicator = getThemeUpIndicator();
        }
        this.mDrawerImage = androidx.core.content.ContextCompat.getDrawable(this.mActivity, this.mDrawerImageResource);
        syncState();
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
    public void onDrawerClosed(android.view.View view) {
        this.mSlider.setPosition(0.0f);
        if (this.mDrawerIndicatorEnabled) {
            setActionBarDescription(this.mOpenDrawerContentDescRes);
        }
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
    public void onDrawerOpened(android.view.View view) {
        this.mSlider.setPosition(1.0f);
        if (this.mDrawerIndicatorEnabled) {
            setActionBarDescription(this.mCloseDrawerContentDescRes);
        }
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
    public void onDrawerSlide(android.view.View view, float f) {
        float position = this.mSlider.getPosition();
        this.mSlider.setPosition(f > 0.5f ? java.lang.Math.max(position, java.lang.Math.max(0.0f, f - 0.5f) * 2.0f) : java.lang.Math.min(position, f * 2.0f));
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
    public void onDrawerStateChanged(int i) {
    }

    public boolean onOptionsItemSelected(android.view.MenuItem menuItem) {
        if (menuItem == null || menuItem.getItemId() != 16908332 || !this.mDrawerIndicatorEnabled) {
            return false;
        }
        if (this.mDrawerLayout.isDrawerVisible(androidx.core.view.GravityCompat.START)) {
            this.mDrawerLayout.closeDrawer(androidx.core.view.GravityCompat.START);
            return true;
        }
        this.mDrawerLayout.openDrawer(androidx.core.view.GravityCompat.START);
        return true;
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

    public void setHomeAsUpIndicator(int i) {
        setHomeAsUpIndicator(i != 0 ? androidx.core.content.ContextCompat.getDrawable(this.mActivity, i) : null);
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

    public void syncState() {
        if (this.mDrawerLayout.isDrawerOpen(androidx.core.view.GravityCompat.START)) {
            this.mSlider.setPosition(1.0f);
        } else {
            this.mSlider.setPosition(0.0f);
        }
        if (this.mDrawerIndicatorEnabled) {
            setActionBarUpIndicator(this.mSlider, this.mDrawerLayout.isDrawerOpen(androidx.core.view.GravityCompat.START) ? this.mCloseDrawerContentDescRes : this.mOpenDrawerContentDescRes);
        }
    }
}
