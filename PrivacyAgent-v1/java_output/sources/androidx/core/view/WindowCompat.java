package androidx.core.view;

/* loaded from: classes.dex */
public final class WindowCompat {
    public static final int FEATURE_ACTION_BAR = 8;
    public static final int FEATURE_ACTION_BAR_OVERLAY = 9;
    public static final int FEATURE_ACTION_MODE_OVERLAY = 10;

    @androidx.annotation.RequiresApi(16)
    public static class Impl16 {
        private Impl16() {
        }

        public static void setDecorFitsSystemWindows(@androidx.annotation.NonNull android.view.Window window, boolean z) {
            android.view.View decorView = window.getDecorView();
            int systemUiVisibility = decorView.getSystemUiVisibility();
            decorView.setSystemUiVisibility(z ? systemUiVisibility & (-1793) : systemUiVisibility | 1792);
        }
    }

    @androidx.annotation.RequiresApi(30)
    public static class Impl30 {
        private Impl30() {
        }

        public static androidx.core.view.WindowInsetsControllerCompat getInsetsController(@androidx.annotation.NonNull android.view.Window window) {
            android.view.WindowInsetsController insetsController;
            insetsController = window.getInsetsController();
            if (insetsController != null) {
                return androidx.core.view.WindowInsetsControllerCompat.toWindowInsetsControllerCompat(insetsController);
            }
            return null;
        }

        public static void setDecorFitsSystemWindows(@androidx.annotation.NonNull android.view.Window window, boolean z) {
            window.setDecorFitsSystemWindows(z);
        }
    }

    private WindowCompat() {
    }

    @androidx.annotation.Nullable
    public static androidx.core.view.WindowInsetsControllerCompat getInsetsController(@androidx.annotation.NonNull android.view.Window window, @androidx.annotation.NonNull android.view.View view) {
        return android.os.Build.VERSION.SDK_INT >= 30 ? androidx.core.view.WindowCompat.Impl30.getInsetsController(window) : new androidx.core.view.WindowInsetsControllerCompat(window, view);
    }

    @androidx.annotation.NonNull
    public static <T extends android.view.View> T requireViewById(@androidx.annotation.NonNull android.view.Window window, @androidx.annotation.IdRes int i) {
        android.view.View requireViewById;
        if (android.os.Build.VERSION.SDK_INT >= 28) {
            requireViewById = window.requireViewById(i);
            return (T) requireViewById;
        }
        T t = (T) window.findViewById(i);
        if (t != null) {
            return t;
        }
        throw new java.lang.IllegalArgumentException("ID does not reference a View inside this Window");
    }

    public static void setDecorFitsSystemWindows(@androidx.annotation.NonNull android.view.Window window, boolean z) {
        if (android.os.Build.VERSION.SDK_INT >= 30) {
            androidx.core.view.WindowCompat.Impl30.setDecorFitsSystemWindows(window, z);
        } else {
            androidx.core.view.WindowCompat.Impl16.setDecorFitsSystemWindows(window, z);
        }
    }
}
