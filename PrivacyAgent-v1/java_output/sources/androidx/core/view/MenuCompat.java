package androidx.core.view;

/* loaded from: classes.dex */
public final class MenuCompat {
    private MenuCompat() {
    }

    @android.annotation.SuppressLint({"NewApi"})
    public static void setGroupDividerEnabled(android.view.Menu menu, boolean z) {
        if (menu instanceof androidx.core.internal.view.SupportMenu) {
            ((androidx.core.internal.view.SupportMenu) menu).setGroupDividerEnabled(z);
        } else if (android.os.Build.VERSION.SDK_INT >= 28) {
            menu.setGroupDividerEnabled(z);
        }
    }

    @java.lang.Deprecated
    public static void setShowAsAction(android.view.MenuItem menuItem, int i) {
        menuItem.setShowAsAction(i);
    }
}
