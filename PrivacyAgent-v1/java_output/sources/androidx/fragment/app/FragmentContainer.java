package androidx.fragment.app;

/* loaded from: classes.dex */
public abstract class FragmentContainer {
    @androidx.annotation.NonNull
    @java.lang.Deprecated
    public androidx.fragment.app.Fragment instantiate(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull java.lang.String str, @androidx.annotation.Nullable android.os.Bundle bundle) {
        return androidx.fragment.app.Fragment.instantiate(context, str, bundle);
    }

    @androidx.annotation.Nullable
    public abstract android.view.View onFindViewById(@androidx.annotation.IdRes int i);

    public abstract boolean onHasView();
}
