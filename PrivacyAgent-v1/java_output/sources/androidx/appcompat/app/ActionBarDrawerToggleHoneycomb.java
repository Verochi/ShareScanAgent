package androidx.appcompat.app;

/* loaded from: classes.dex */
class ActionBarDrawerToggleHoneycomb {
    private static final java.lang.String TAG = "ActionBarDrawerToggleHC";
    private static final int[] THEME_ATTRS = {android.R.attr.homeAsUpIndicator};

    public static class SetIndicatorInfo {
        public java.lang.reflect.Method setHomeActionContentDescription;
        public java.lang.reflect.Method setHomeAsUpIndicator;
        public android.widget.ImageView upIndicatorView;

        public SetIndicatorInfo(android.app.Activity activity) {
            try {
                this.setHomeAsUpIndicator = android.app.ActionBar.class.getDeclaredMethod("setHomeAsUpIndicator", android.graphics.drawable.Drawable.class);
                this.setHomeActionContentDescription = android.app.ActionBar.class.getDeclaredMethod("setHomeActionContentDescription", java.lang.Integer.TYPE);
            } catch (java.lang.NoSuchMethodException unused) {
                android.view.View findViewById = activity.findViewById(android.R.id.home);
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
                    this.upIndicatorView = (android.widget.ImageView) childAt;
                }
            }
        }
    }

    private ActionBarDrawerToggleHoneycomb() {
    }

    public static android.graphics.drawable.Drawable getThemeUpIndicator(android.app.Activity activity) {
        android.content.res.TypedArray obtainStyledAttributes = activity.obtainStyledAttributes(THEME_ATTRS);
        android.graphics.drawable.Drawable drawable = obtainStyledAttributes.getDrawable(0);
        obtainStyledAttributes.recycle();
        return drawable;
    }

    public static androidx.appcompat.app.ActionBarDrawerToggleHoneycomb.SetIndicatorInfo setActionBarDescription(androidx.appcompat.app.ActionBarDrawerToggleHoneycomb.SetIndicatorInfo setIndicatorInfo, android.app.Activity activity, int i) {
        if (setIndicatorInfo == null) {
            setIndicatorInfo = new androidx.appcompat.app.ActionBarDrawerToggleHoneycomb.SetIndicatorInfo(activity);
        }
        if (setIndicatorInfo.setHomeAsUpIndicator != null) {
            try {
                setIndicatorInfo.setHomeActionContentDescription.invoke(activity.getActionBar(), java.lang.Integer.valueOf(i));
            } catch (java.lang.Exception unused) {
            }
        }
        return setIndicatorInfo;
    }

    public static androidx.appcompat.app.ActionBarDrawerToggleHoneycomb.SetIndicatorInfo setActionBarUpIndicator(android.app.Activity activity, android.graphics.drawable.Drawable drawable, int i) {
        androidx.appcompat.app.ActionBarDrawerToggleHoneycomb.SetIndicatorInfo setIndicatorInfo = new androidx.appcompat.app.ActionBarDrawerToggleHoneycomb.SetIndicatorInfo(activity);
        if (setIndicatorInfo.setHomeAsUpIndicator != null) {
            try {
                android.app.ActionBar actionBar = activity.getActionBar();
                setIndicatorInfo.setHomeAsUpIndicator.invoke(actionBar, drawable);
                setIndicatorInfo.setHomeActionContentDescription.invoke(actionBar, java.lang.Integer.valueOf(i));
            } catch (java.lang.Exception unused) {
            }
        } else {
            android.widget.ImageView imageView = setIndicatorInfo.upIndicatorView;
            if (imageView != null) {
                imageView.setImageDrawable(drawable);
            }
        }
        return setIndicatorInfo;
    }
}
