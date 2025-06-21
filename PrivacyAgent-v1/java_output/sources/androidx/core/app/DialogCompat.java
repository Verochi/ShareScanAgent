package androidx.core.app;

/* loaded from: classes.dex */
public class DialogCompat {
    private DialogCompat() {
    }

    @androidx.annotation.NonNull
    public static android.view.View requireViewById(@androidx.annotation.NonNull android.app.Dialog dialog, int i) {
        android.view.View requireViewById;
        if (android.os.Build.VERSION.SDK_INT >= 28) {
            requireViewById = dialog.requireViewById(i);
            return requireViewById;
        }
        android.view.View findViewById = dialog.findViewById(i);
        if (findViewById != null) {
            return findViewById;
        }
        throw new java.lang.IllegalArgumentException("ID does not reference a View inside this Dialog");
    }
}
