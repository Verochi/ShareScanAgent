package androidx.core.widget;

/* loaded from: classes.dex */
public final class PopupMenuCompat {
    private PopupMenuCompat() {
    }

    @androidx.annotation.Nullable
    public static android.view.View.OnTouchListener getDragToOpenListener(@androidx.annotation.NonNull java.lang.Object obj) {
        return ((android.widget.PopupMenu) obj).getDragToOpenListener();
    }
}
