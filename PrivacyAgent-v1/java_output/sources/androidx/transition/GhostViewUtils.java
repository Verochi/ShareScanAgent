package androidx.transition;

/* loaded from: classes.dex */
class GhostViewUtils {
    private GhostViewUtils() {
    }

    @androidx.annotation.Nullable
    public static androidx.transition.GhostView addGhost(@androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull android.view.ViewGroup viewGroup, @androidx.annotation.Nullable android.graphics.Matrix matrix) {
        return android.os.Build.VERSION.SDK_INT == 28 ? androidx.transition.GhostViewPlatform.addGhost(view, viewGroup, matrix) : androidx.transition.GhostViewPort.addGhost(view, viewGroup, matrix);
    }

    public static void removeGhost(android.view.View view) {
        if (android.os.Build.VERSION.SDK_INT == 28) {
            androidx.transition.GhostViewPlatform.removeGhost(view);
        } else {
            androidx.transition.GhostViewPort.removeGhost(view);
        }
    }
}
