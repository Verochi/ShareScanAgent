package androidx.core.widget;

/* loaded from: classes.dex */
public final class ListPopupWindowCompat {
    private ListPopupWindowCompat() {
    }

    @androidx.annotation.Nullable
    public static android.view.View.OnTouchListener createDragToOpenListener(@androidx.annotation.NonNull android.widget.ListPopupWindow listPopupWindow, @androidx.annotation.NonNull android.view.View view) {
        return listPopupWindow.createDragToOpenListener(view);
    }

    @java.lang.Deprecated
    public static android.view.View.OnTouchListener createDragToOpenListener(java.lang.Object obj, android.view.View view) {
        return createDragToOpenListener((android.widget.ListPopupWindow) obj, view);
    }
}
