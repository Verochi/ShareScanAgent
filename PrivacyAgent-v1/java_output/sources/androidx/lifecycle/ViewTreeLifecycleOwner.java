package androidx.lifecycle;

/* loaded from: classes.dex */
public class ViewTreeLifecycleOwner {
    private ViewTreeLifecycleOwner() {
    }

    @androidx.annotation.Nullable
    public static androidx.lifecycle.LifecycleOwner get(@androidx.annotation.NonNull android.view.View view) {
        androidx.lifecycle.LifecycleOwner lifecycleOwner = (androidx.lifecycle.LifecycleOwner) view.getTag(androidx.lifecycle.runtime.R.id.view_tree_lifecycle_owner);
        if (lifecycleOwner != null) {
            return lifecycleOwner;
        }
        java.lang.Object parent = view.getParent();
        while (lifecycleOwner == null && (parent instanceof android.view.View)) {
            android.view.View view2 = (android.view.View) parent;
            lifecycleOwner = (androidx.lifecycle.LifecycleOwner) view2.getTag(androidx.lifecycle.runtime.R.id.view_tree_lifecycle_owner);
            parent = view2.getParent();
        }
        return lifecycleOwner;
    }

    public static void set(@androidx.annotation.NonNull android.view.View view, @androidx.annotation.Nullable androidx.lifecycle.LifecycleOwner lifecycleOwner) {
        view.setTag(androidx.lifecycle.runtime.R.id.view_tree_lifecycle_owner, lifecycleOwner);
    }
}
