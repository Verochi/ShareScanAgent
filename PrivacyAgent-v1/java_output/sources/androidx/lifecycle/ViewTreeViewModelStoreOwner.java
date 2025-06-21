package androidx.lifecycle;

/* loaded from: classes.dex */
public class ViewTreeViewModelStoreOwner {
    private ViewTreeViewModelStoreOwner() {
    }

    @androidx.annotation.Nullable
    public static androidx.lifecycle.ViewModelStoreOwner get(@androidx.annotation.NonNull android.view.View view) {
        androidx.lifecycle.ViewModelStoreOwner viewModelStoreOwner = (androidx.lifecycle.ViewModelStoreOwner) view.getTag(androidx.lifecycle.viewmodel.R.id.view_tree_view_model_store_owner);
        if (viewModelStoreOwner != null) {
            return viewModelStoreOwner;
        }
        java.lang.Object parent = view.getParent();
        while (viewModelStoreOwner == null && (parent instanceof android.view.View)) {
            android.view.View view2 = (android.view.View) parent;
            viewModelStoreOwner = (androidx.lifecycle.ViewModelStoreOwner) view2.getTag(androidx.lifecycle.viewmodel.R.id.view_tree_view_model_store_owner);
            parent = view2.getParent();
        }
        return viewModelStoreOwner;
    }

    public static void set(@androidx.annotation.NonNull android.view.View view, @androidx.annotation.Nullable androidx.lifecycle.ViewModelStoreOwner viewModelStoreOwner) {
        view.setTag(androidx.lifecycle.viewmodel.R.id.view_tree_view_model_store_owner, viewModelStoreOwner);
    }
}
