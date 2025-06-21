package androidx.appcompat.app;

/* loaded from: classes.dex */
public abstract class AppCompatDelegate {
    static final boolean DEBUG = false;
    public static final int FEATURE_ACTION_MODE_OVERLAY = 10;
    public static final int FEATURE_SUPPORT_ACTION_BAR = 108;
    public static final int FEATURE_SUPPORT_ACTION_BAR_OVERLAY = 109;

    @java.lang.Deprecated
    public static final int MODE_NIGHT_AUTO = 0;
    public static final int MODE_NIGHT_AUTO_BATTERY = 3;

    @java.lang.Deprecated
    public static final int MODE_NIGHT_AUTO_TIME = 0;
    public static final int MODE_NIGHT_FOLLOW_SYSTEM = -1;
    public static final int MODE_NIGHT_NO = 1;
    public static final int MODE_NIGHT_UNSPECIFIED = -100;
    public static final int MODE_NIGHT_YES = 2;
    static final java.lang.String TAG = "AppCompatDelegate";
    private static final androidx.collection.ArraySet<java.lang.ref.WeakReference<androidx.appcompat.app.AppCompatDelegate>> sActivityDelegates = new androidx.collection.ArraySet<>();
    private static final java.lang.Object sActivityDelegatesLock = new java.lang.Object();
    private static int sDefaultNightMode = -100;

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface NightMode {
    }

    public static void addActiveDelegate(@androidx.annotation.NonNull androidx.appcompat.app.AppCompatDelegate appCompatDelegate) {
        synchronized (sActivityDelegatesLock) {
            removeDelegateFromActives(appCompatDelegate);
            sActivityDelegates.add(new java.lang.ref.WeakReference<>(appCompatDelegate));
        }
    }

    private static void applyDayNightToActiveDelegates() {
        synchronized (sActivityDelegatesLock) {
            java.util.Iterator<java.lang.ref.WeakReference<androidx.appcompat.app.AppCompatDelegate>> it = sActivityDelegates.iterator();
            while (it.hasNext()) {
                androidx.appcompat.app.AppCompatDelegate appCompatDelegate = it.next().get();
                if (appCompatDelegate != null) {
                    appCompatDelegate.applyDayNight();
                }
            }
        }
    }

    @androidx.annotation.NonNull
    public static androidx.appcompat.app.AppCompatDelegate create(@androidx.annotation.NonNull android.app.Activity activity, @androidx.annotation.Nullable androidx.appcompat.app.AppCompatCallback appCompatCallback) {
        return new androidx.appcompat.app.AppCompatDelegateImpl(activity, appCompatCallback);
    }

    @androidx.annotation.NonNull
    public static androidx.appcompat.app.AppCompatDelegate create(@androidx.annotation.NonNull android.app.Dialog dialog, @androidx.annotation.Nullable androidx.appcompat.app.AppCompatCallback appCompatCallback) {
        return new androidx.appcompat.app.AppCompatDelegateImpl(dialog, appCompatCallback);
    }

    @androidx.annotation.NonNull
    public static androidx.appcompat.app.AppCompatDelegate create(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull android.app.Activity activity, @androidx.annotation.Nullable androidx.appcompat.app.AppCompatCallback appCompatCallback) {
        return new androidx.appcompat.app.AppCompatDelegateImpl(context, activity, appCompatCallback);
    }

    @androidx.annotation.NonNull
    public static androidx.appcompat.app.AppCompatDelegate create(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull android.view.Window window, @androidx.annotation.Nullable androidx.appcompat.app.AppCompatCallback appCompatCallback) {
        return new androidx.appcompat.app.AppCompatDelegateImpl(context, window, appCompatCallback);
    }

    public static int getDefaultNightMode() {
        return sDefaultNightMode;
    }

    public static boolean isCompatVectorFromResourcesEnabled() {
        return androidx.appcompat.widget.VectorEnabledTintResources.isCompatVectorFromResourcesEnabled();
    }

    public static void removeActivityDelegate(@androidx.annotation.NonNull androidx.appcompat.app.AppCompatDelegate appCompatDelegate) {
        synchronized (sActivityDelegatesLock) {
            removeDelegateFromActives(appCompatDelegate);
        }
    }

    private static void removeDelegateFromActives(@androidx.annotation.NonNull androidx.appcompat.app.AppCompatDelegate appCompatDelegate) {
        synchronized (sActivityDelegatesLock) {
            java.util.Iterator<java.lang.ref.WeakReference<androidx.appcompat.app.AppCompatDelegate>> it = sActivityDelegates.iterator();
            while (it.hasNext()) {
                androidx.appcompat.app.AppCompatDelegate appCompatDelegate2 = it.next().get();
                if (appCompatDelegate2 == appCompatDelegate || appCompatDelegate2 == null) {
                    it.remove();
                }
            }
        }
    }

    public static void setCompatVectorFromResourcesEnabled(boolean z) {
        androidx.appcompat.widget.VectorEnabledTintResources.setCompatVectorFromResourcesEnabled(z);
    }

    public static void setDefaultNightMode(int i) {
        if ((i == -1 || i == 0 || i == 1 || i == 2 || i == 3) && sDefaultNightMode != i) {
            sDefaultNightMode = i;
            applyDayNightToActiveDelegates();
        }
    }

    public abstract void addContentView(android.view.View view, android.view.ViewGroup.LayoutParams layoutParams);

    public abstract boolean applyDayNight();

    @java.lang.Deprecated
    public void attachBaseContext(android.content.Context context) {
    }

    @androidx.annotation.NonNull
    @androidx.annotation.CallSuper
    public android.content.Context attachBaseContext2(@androidx.annotation.NonNull android.content.Context context) {
        attachBaseContext(context);
        return context;
    }

    public abstract android.view.View createView(@androidx.annotation.Nullable android.view.View view, java.lang.String str, @androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull android.util.AttributeSet attributeSet);

    @androidx.annotation.Nullable
    public abstract <T extends android.view.View> T findViewById(@androidx.annotation.IdRes int i);

    @androidx.annotation.Nullable
    public abstract androidx.appcompat.app.ActionBarDrawerToggle.Delegate getDrawerToggleDelegate();

    public int getLocalNightMode() {
        return -100;
    }

    public abstract android.view.MenuInflater getMenuInflater();

    @androidx.annotation.Nullable
    public abstract androidx.appcompat.app.ActionBar getSupportActionBar();

    public abstract boolean hasWindowFeature(int i);

    public abstract void installViewFactory();

    public abstract void invalidateOptionsMenu();

    public abstract boolean isHandleNativeActionModesEnabled();

    public abstract void onConfigurationChanged(android.content.res.Configuration configuration);

    public abstract void onCreate(android.os.Bundle bundle);

    public abstract void onDestroy();

    public abstract void onPostCreate(android.os.Bundle bundle);

    public abstract void onPostResume();

    public abstract void onSaveInstanceState(android.os.Bundle bundle);

    public abstract void onStart();

    public abstract void onStop();

    public abstract boolean requestWindowFeature(int i);

    public abstract void setContentView(@androidx.annotation.LayoutRes int i);

    public abstract void setContentView(android.view.View view);

    public abstract void setContentView(android.view.View view, android.view.ViewGroup.LayoutParams layoutParams);

    public abstract void setHandleNativeActionModesEnabled(boolean z);

    @androidx.annotation.RequiresApi(17)
    public abstract void setLocalNightMode(int i);

    public abstract void setSupportActionBar(@androidx.annotation.Nullable androidx.appcompat.widget.Toolbar toolbar);

    public void setTheme(@androidx.annotation.StyleRes int i) {
    }

    public abstract void setTitle(@androidx.annotation.Nullable java.lang.CharSequence charSequence);

    @androidx.annotation.Nullable
    public abstract androidx.appcompat.view.ActionMode startSupportActionMode(@androidx.annotation.NonNull androidx.appcompat.view.ActionMode.Callback callback);
}
