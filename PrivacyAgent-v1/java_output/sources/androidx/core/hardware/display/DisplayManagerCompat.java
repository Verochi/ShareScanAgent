package androidx.core.hardware.display;

/* loaded from: classes.dex */
public final class DisplayManagerCompat {
    public static final java.lang.String DISPLAY_CATEGORY_PRESENTATION = "android.hardware.display.category.PRESENTATION";
    private static final java.util.WeakHashMap<android.content.Context, androidx.core.hardware.display.DisplayManagerCompat> sInstances = new java.util.WeakHashMap<>();
    private final android.content.Context mContext;

    private DisplayManagerCompat(android.content.Context context) {
        this.mContext = context;
    }

    @androidx.annotation.NonNull
    public static androidx.core.hardware.display.DisplayManagerCompat getInstance(@androidx.annotation.NonNull android.content.Context context) {
        androidx.core.hardware.display.DisplayManagerCompat displayManagerCompat;
        java.util.WeakHashMap<android.content.Context, androidx.core.hardware.display.DisplayManagerCompat> weakHashMap = sInstances;
        synchronized (weakHashMap) {
            displayManagerCompat = weakHashMap.get(context);
            if (displayManagerCompat == null) {
                displayManagerCompat = new androidx.core.hardware.display.DisplayManagerCompat(context);
                weakHashMap.put(context, displayManagerCompat);
            }
        }
        return displayManagerCompat;
    }

    @androidx.annotation.Nullable
    public android.view.Display getDisplay(int i) {
        return ((android.hardware.display.DisplayManager) this.mContext.getSystemService("display")).getDisplay(i);
    }

    @androidx.annotation.NonNull
    public android.view.Display[] getDisplays() {
        return ((android.hardware.display.DisplayManager) this.mContext.getSystemService("display")).getDisplays();
    }

    @androidx.annotation.NonNull
    public android.view.Display[] getDisplays(@androidx.annotation.Nullable java.lang.String str) {
        return ((android.hardware.display.DisplayManager) this.mContext.getSystemService("display")).getDisplays(str);
    }
}
