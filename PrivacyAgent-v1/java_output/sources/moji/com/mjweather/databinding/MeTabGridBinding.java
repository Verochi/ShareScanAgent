package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class MeTabGridBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final com.moji.imageview.MJImageView ivEmptyIcon;

    @androidx.annotation.NonNull
    public final android.widget.RelativeLayout n;

    @androidx.annotation.NonNull
    public final android.widget.GridView tabGrid;

    @androidx.annotation.NonNull
    public final androidx.constraintlayout.widget.ConstraintLayout tabNoDataView;

    @androidx.annotation.NonNull
    public final com.moji.textview.MJTextView tvEmptyText;

    public MeTabGridBinding(@androidx.annotation.NonNull android.widget.RelativeLayout relativeLayout, @androidx.annotation.NonNull com.moji.imageview.MJImageView mJImageView, @androidx.annotation.NonNull android.widget.GridView gridView, @androidx.annotation.NonNull androidx.constraintlayout.widget.ConstraintLayout constraintLayout, @androidx.annotation.NonNull com.moji.textview.MJTextView mJTextView) {
        this.n = relativeLayout;
        this.ivEmptyIcon = mJImageView;
        this.tabGrid = gridView;
        this.tabNoDataView = constraintLayout;
        this.tvEmptyText = mJTextView;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.MeTabGridBinding bind(@androidx.annotation.NonNull android.view.View view) {
        com.moji.textview.MJTextView findChildViewById;
        int i = moji.com.mjweather.R.id.iv_empty_icon;
        com.moji.imageview.MJImageView findChildViewById2 = androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (findChildViewById2 != null) {
            i = moji.com.mjweather.R.id.tab_grid;
            android.widget.GridView gridView = (android.widget.GridView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (gridView != null) {
                i = moji.com.mjweather.R.id.tab_no_data_view;
                androidx.constraintlayout.widget.ConstraintLayout constraintLayout = (androidx.constraintlayout.widget.ConstraintLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (constraintLayout != null && (findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.tv_empty_text))) != null) {
                    return new moji.com.mjweather.databinding.MeTabGridBinding((android.widget.RelativeLayout) view, findChildViewById2, gridView, constraintLayout, findChildViewById);
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.MeTabGridBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.MeTabGridBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.me_tab_grid, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @androidx.annotation.NonNull
    public android.widget.RelativeLayout getRoot() {
        return this.n;
    }
}
