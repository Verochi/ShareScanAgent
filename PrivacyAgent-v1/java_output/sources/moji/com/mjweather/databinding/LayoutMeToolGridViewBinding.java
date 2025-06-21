package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class LayoutMeToolGridViewBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final com.moji.ExpandGridView gvTool;

    @androidx.annotation.NonNull
    public final com.moji.ExpandGridView n;

    public LayoutMeToolGridViewBinding(@androidx.annotation.NonNull com.moji.ExpandGridView expandGridView, @androidx.annotation.NonNull com.moji.ExpandGridView expandGridView2) {
        this.n = expandGridView;
        this.gvTool = expandGridView2;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.LayoutMeToolGridViewBinding bind(@androidx.annotation.NonNull android.view.View view) {
        if (view == null) {
            throw new java.lang.NullPointerException("rootView");
        }
        com.moji.ExpandGridView expandGridView = (com.moji.ExpandGridView) view;
        return new moji.com.mjweather.databinding.LayoutMeToolGridViewBinding(expandGridView, expandGridView);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.LayoutMeToolGridViewBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.LayoutMeToolGridViewBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.layout_me_tool_grid_view, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @androidx.annotation.NonNull
    public com.moji.ExpandGridView getRoot() {
        return this.n;
    }
}
