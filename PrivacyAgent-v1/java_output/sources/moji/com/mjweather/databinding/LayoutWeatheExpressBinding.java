package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class LayoutWeatheExpressBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.view.View divider;

    @androidx.annotation.NonNull
    public final android.view.View n;

    @androidx.annotation.NonNull
    public final androidx.recyclerview.widget.RecyclerView rv;

    @androidx.annotation.NonNull
    public final com.moji.HorizontalMoreLayout vMoreLayout;

    public LayoutWeatheExpressBinding(@androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull android.view.View view2, @androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView recyclerView, @androidx.annotation.NonNull com.moji.HorizontalMoreLayout horizontalMoreLayout) {
        this.n = view;
        this.divider = view2;
        this.rv = recyclerView;
        this.vMoreLayout = horizontalMoreLayout;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.LayoutWeatheExpressBinding bind(@androidx.annotation.NonNull android.view.View view) {
        com.moji.HorizontalMoreLayout findChildViewById;
        int i = moji.com.mjweather.R.id.divider;
        android.view.View findChildViewById2 = androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (findChildViewById2 != null) {
            i = moji.com.mjweather.R.id.rv;
            androidx.recyclerview.widget.RecyclerView recyclerView = (androidx.recyclerview.widget.RecyclerView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (recyclerView != null && (findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.v_more_layout))) != null) {
                return new moji.com.mjweather.databinding.LayoutWeatheExpressBinding(view, findChildViewById2, recyclerView, findChildViewById);
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.LayoutWeatheExpressBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.NonNull android.view.ViewGroup viewGroup) {
        if (viewGroup == null) {
            throw new java.lang.NullPointerException("parent");
        }
        layoutInflater.inflate(moji.com.mjweather.R.layout.layout_weathe_express, viewGroup);
        return bind(viewGroup);
    }

    @Override // androidx.viewbinding.ViewBinding
    @androidx.annotation.NonNull
    public android.view.View getRoot() {
        return this.n;
    }
}
