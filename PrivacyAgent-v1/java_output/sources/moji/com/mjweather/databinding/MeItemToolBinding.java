package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class MeItemToolBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final com.moji.imageview.MJImageView adtag;

    @androidx.annotation.NonNull
    public final com.moji.mjtabme.widget.TabMeGridIconView ivTool;

    @androidx.annotation.NonNull
    public final com.moji.mjad.common.view.CommonAdView meAdView;

    @androidx.annotation.NonNull
    public final androidx.constraintlayout.widget.ConstraintLayout n;

    @androidx.annotation.NonNull
    public final android.widget.RelativeLayout rlTool;

    @androidx.annotation.NonNull
    public final com.moji.textview.MJTextView tvTool;

    public MeItemToolBinding(@androidx.annotation.NonNull androidx.constraintlayout.widget.ConstraintLayout constraintLayout, @androidx.annotation.NonNull com.moji.imageview.MJImageView mJImageView, @androidx.annotation.NonNull com.moji.mjtabme.widget.TabMeGridIconView tabMeGridIconView, @androidx.annotation.NonNull com.moji.mjad.common.view.CommonAdView commonAdView, @androidx.annotation.NonNull android.widget.RelativeLayout relativeLayout, @androidx.annotation.NonNull com.moji.textview.MJTextView mJTextView) {
        this.n = constraintLayout;
        this.adtag = mJImageView;
        this.ivTool = tabMeGridIconView;
        this.meAdView = commonAdView;
        this.rlTool = relativeLayout;
        this.tvTool = mJTextView;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.MeItemToolBinding bind(@androidx.annotation.NonNull android.view.View view) {
        com.moji.mjtabme.widget.TabMeGridIconView findChildViewById;
        com.moji.mjad.common.view.CommonAdView findChildViewById2;
        com.moji.textview.MJTextView findChildViewById3;
        int i = moji.com.mjweather.R.id.adtag;
        com.moji.imageview.MJImageView findChildViewById4 = androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (findChildViewById4 != null && (findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.iv_tool))) != null && (findChildViewById2 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.me_ad_view))) != null) {
            i = moji.com.mjweather.R.id.rl_tool;
            android.widget.RelativeLayout relativeLayout = (android.widget.RelativeLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (relativeLayout != null && (findChildViewById3 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.tv_tool))) != null) {
                return new moji.com.mjweather.databinding.MeItemToolBinding((androidx.constraintlayout.widget.ConstraintLayout) view, findChildViewById4, findChildViewById, findChildViewById2, relativeLayout, findChildViewById3);
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.MeItemToolBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.MeItemToolBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.me_item_tool, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @androidx.annotation.NonNull
    public androidx.constraintlayout.widget.ConstraintLayout getRoot() {
        return this.n;
    }
}
