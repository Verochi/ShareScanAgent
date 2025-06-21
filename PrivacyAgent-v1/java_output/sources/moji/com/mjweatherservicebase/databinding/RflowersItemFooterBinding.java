package moji.com.mjweatherservicebase.databinding;

/* loaded from: classes20.dex */
public final class RflowersItemFooterBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.view.View mDividerView;

    @androidx.annotation.NonNull
    public final com.moji.FooterView mFooterView;

    @androidx.annotation.NonNull
    public final android.widget.TextView mMoreView;

    @androidx.annotation.NonNull
    public final android.widget.FrameLayout n;

    public RflowersItemFooterBinding(@androidx.annotation.NonNull android.widget.FrameLayout frameLayout, @androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull com.moji.FooterView footerView, @androidx.annotation.NonNull android.widget.TextView textView) {
        this.n = frameLayout;
        this.mDividerView = view;
        this.mFooterView = footerView;
        this.mMoreView = textView;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweatherservicebase.databinding.RflowersItemFooterBinding bind(@androidx.annotation.NonNull android.view.View view) {
        com.moji.FooterView findChildViewById;
        int i = moji.com.mjweatherservicebase.R.id.mDividerView;
        android.view.View findChildViewById2 = androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (findChildViewById2 != null && (findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweatherservicebase.R.id.mFooterView))) != null) {
            i = moji.com.mjweatherservicebase.R.id.mMoreView;
            android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                return new moji.com.mjweatherservicebase.databinding.RflowersItemFooterBinding((android.widget.FrameLayout) view, findChildViewById2, findChildViewById, textView);
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweatherservicebase.databinding.RflowersItemFooterBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweatherservicebase.databinding.RflowersItemFooterBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweatherservicebase.R.layout.rflowers_item_footer, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @androidx.annotation.NonNull
    public android.widget.FrameLayout getRoot() {
        return this.n;
    }
}
