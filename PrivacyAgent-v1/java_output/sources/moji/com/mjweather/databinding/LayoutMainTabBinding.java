package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class LayoutMainTabBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final com.moji.mjfontsize.MJScaleTabImageView mainTabIv;

    @androidx.annotation.NonNull
    public final android.widget.TextView mainTabTag;

    @androidx.annotation.NonNull
    public final com.moji.textview.TabTextView mainTabTv;

    @androidx.annotation.NonNull
    public final android.widget.RelativeLayout n;

    @androidx.annotation.NonNull
    public final com.moji.mjweather.main.TabViewsContainer tabContainer;

    public LayoutMainTabBinding(@androidx.annotation.NonNull android.widget.RelativeLayout relativeLayout, @androidx.annotation.NonNull com.moji.mjfontsize.MJScaleTabImageView mJScaleTabImageView, @androidx.annotation.NonNull android.widget.TextView textView, @androidx.annotation.NonNull com.moji.textview.TabTextView tabTextView, @androidx.annotation.NonNull com.moji.mjweather.main.TabViewsContainer tabViewsContainer) {
        this.n = relativeLayout;
        this.mainTabIv = mJScaleTabImageView;
        this.mainTabTag = textView;
        this.mainTabTv = tabTextView;
        this.tabContainer = tabViewsContainer;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.LayoutMainTabBinding bind(@androidx.annotation.NonNull android.view.View view) {
        com.moji.textview.TabTextView findChildViewById;
        com.moji.mjweather.main.TabViewsContainer findChildViewById2;
        int i = moji.com.mjweather.R.id.main_tab_iv;
        com.moji.mjfontsize.MJScaleTabImageView findChildViewById3 = androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (findChildViewById3 != null) {
            i = moji.com.mjweather.R.id.main_tab_tag;
            android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (textView != null && (findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.main_tab_tv))) != null && (findChildViewById2 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.tab_container))) != null) {
                return new moji.com.mjweather.databinding.LayoutMainTabBinding((android.widget.RelativeLayout) view, findChildViewById3, textView, findChildViewById, findChildViewById2);
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.LayoutMainTabBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.LayoutMainTabBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.layout_main_tab, viewGroup, false);
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
