package androidx.viewbinding;

/* loaded from: classes.dex */
public class ViewBindings {
    private ViewBindings() {
    }

    @androidx.annotation.Nullable
    public static <T extends android.view.View> T findChildViewById(android.view.View view, @androidx.annotation.IdRes int i) {
        if (!(view instanceof android.view.ViewGroup)) {
            return null;
        }
        android.view.ViewGroup viewGroup = (android.view.ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            T t = (T) viewGroup.getChildAt(i2).findViewById(i);
            if (t != null) {
                return t;
            }
        }
        return null;
    }
}
