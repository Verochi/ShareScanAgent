package androidx.appcompat.widget;

/* loaded from: classes.dex */
public class TooltipCompat {
    private TooltipCompat() {
    }

    public static void setTooltipText(@androidx.annotation.NonNull android.view.View view, @androidx.annotation.Nullable java.lang.CharSequence charSequence) {
        if (android.os.Build.VERSION.SDK_INT >= 26) {
            view.setTooltipText(charSequence);
        } else {
            androidx.appcompat.widget.TooltipCompatHandler.setTooltipText(view, charSequence);
        }
    }
}
