package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class MeLayoutFunctionSettingsBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final androidx.constraintlayout.widget.ConstraintLayout clWidgetBanner;

    @androidx.annotation.NonNull
    public final com.moji.ExpandGridView gridview;

    @androidx.annotation.NonNull
    public final com.moji.imageview.FourCornerImageView ivClickMask;

    @androidx.annotation.NonNull
    public final com.moji.imageview.FourCornerImageView ivWidgetIcon;

    @androidx.annotation.NonNull
    public final com.moji.textview.MJTextView label;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout n;

    @androidx.annotation.NonNull
    public final com.moji.textview.MJTextView tvGoToAdd;

    @androidx.annotation.NonNull
    public final com.moji.textview.MJTextView tvWidgetDesc;

    @androidx.annotation.NonNull
    public final com.moji.textview.MJTextView tvWidgetTitle;

    public MeLayoutFunctionSettingsBinding(@androidx.annotation.NonNull android.widget.LinearLayout linearLayout, @androidx.annotation.NonNull androidx.constraintlayout.widget.ConstraintLayout constraintLayout, @androidx.annotation.NonNull com.moji.ExpandGridView expandGridView, @androidx.annotation.NonNull com.moji.imageview.FourCornerImageView fourCornerImageView, @androidx.annotation.NonNull com.moji.imageview.FourCornerImageView fourCornerImageView2, @androidx.annotation.NonNull com.moji.textview.MJTextView mJTextView, @androidx.annotation.NonNull com.moji.textview.MJTextView mJTextView2, @androidx.annotation.NonNull com.moji.textview.MJTextView mJTextView3, @androidx.annotation.NonNull com.moji.textview.MJTextView mJTextView4) {
        this.n = linearLayout;
        this.clWidgetBanner = constraintLayout;
        this.gridview = expandGridView;
        this.ivClickMask = fourCornerImageView;
        this.ivWidgetIcon = fourCornerImageView2;
        this.label = mJTextView;
        this.tvGoToAdd = mJTextView2;
        this.tvWidgetDesc = mJTextView3;
        this.tvWidgetTitle = mJTextView4;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.MeLayoutFunctionSettingsBinding bind(@androidx.annotation.NonNull android.view.View view) {
        com.moji.ExpandGridView findChildViewById;
        com.moji.imageview.FourCornerImageView findChildViewById2;
        com.moji.imageview.FourCornerImageView findChildViewById3;
        com.moji.textview.MJTextView findChildViewById4;
        com.moji.textview.MJTextView findChildViewById5;
        com.moji.textview.MJTextView findChildViewById6;
        com.moji.textview.MJTextView findChildViewById7;
        int i = moji.com.mjweather.R.id.cl_widget_banner;
        androidx.constraintlayout.widget.ConstraintLayout constraintLayout = (androidx.constraintlayout.widget.ConstraintLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (constraintLayout == null || (findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.gridview))) == null || (findChildViewById2 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.iv_click_mask))) == null || (findChildViewById3 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.iv_widget_icon))) == null || (findChildViewById4 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.label))) == null || (findChildViewById5 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.tv_go_to_add))) == null || (findChildViewById6 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.tv_widget_desc))) == null || (findChildViewById7 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.tv_widget_title))) == null) {
            throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new moji.com.mjweather.databinding.MeLayoutFunctionSettingsBinding((android.widget.LinearLayout) view, constraintLayout, findChildViewById, findChildViewById2, findChildViewById3, findChildViewById4, findChildViewById5, findChildViewById6, findChildViewById7);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.MeLayoutFunctionSettingsBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.MeLayoutFunctionSettingsBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.me_layout_function_settings, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @androidx.annotation.NonNull
    public android.widget.LinearLayout getRoot() {
        return this.n;
    }
}
