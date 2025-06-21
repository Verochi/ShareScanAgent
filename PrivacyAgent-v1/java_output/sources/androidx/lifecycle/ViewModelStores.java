package androidx.lifecycle;

@java.lang.Deprecated
/* loaded from: classes.dex */
public class ViewModelStores {
    private ViewModelStores() {
    }

    @androidx.annotation.NonNull
    @androidx.annotation.MainThread
    @java.lang.Deprecated
    public static androidx.lifecycle.ViewModelStore of(@androidx.annotation.NonNull androidx.fragment.app.Fragment fragment) {
        return fragment.getViewModelStore();
    }

    @androidx.annotation.NonNull
    @androidx.annotation.MainThread
    @java.lang.Deprecated
    public static androidx.lifecycle.ViewModelStore of(@androidx.annotation.NonNull androidx.fragment.app.FragmentActivity fragmentActivity) {
        return fragmentActivity.getViewModelStore();
    }
}
