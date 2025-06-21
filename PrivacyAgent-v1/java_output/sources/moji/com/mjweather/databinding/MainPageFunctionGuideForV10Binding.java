package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class MainPageFunctionGuideForV10Binding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final com.moji.mjweather.weather.dialog.MainPageFunctionGuideBg clBg;

    @androidx.annotation.NonNull
    public final androidx.constraintlayout.widget.ConstraintLayout clRoot;

    @androidx.annotation.NonNull
    public final androidx.constraintlayout.widget.ConstraintLayout clStep1;

    @androidx.annotation.NonNull
    public final androidx.constraintlayout.widget.ConstraintLayout clStep2;

    @androidx.annotation.NonNull
    public final androidx.constraintlayout.widget.ConstraintLayout clStep2Tip;

    @androidx.annotation.NonNull
    public final androidx.constraintlayout.widget.ConstraintLayout clStep3;

    @androidx.annotation.NonNull
    public final com.moji.imageview.MJImageView ivArrowStep1;

    @androidx.annotation.NonNull
    public final com.moji.imageview.MJImageView ivArrowStep2;

    @androidx.annotation.NonNull
    public final com.moji.imageview.MJImageView ivArrowStep3;

    @androidx.annotation.NonNull
    public final com.moji.imageview.MJImageView ivStep2;

    @androidx.annotation.NonNull
    public final com.airbnb.lottie.LottieAnimationView ivStep3;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout llStep1;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout llStep3;

    @androidx.annotation.NonNull
    public final androidx.constraintlayout.widget.ConstraintLayout n;

    @androidx.annotation.NonNull
    public final com.moji.textview.MJTextView tvStep;

    @androidx.annotation.NonNull
    public final com.moji.textview.MJTextView tvStep2Desc;

    @androidx.annotation.NonNull
    public final com.moji.textview.MJTextView tvStep2Title;

    public MainPageFunctionGuideForV10Binding(@androidx.annotation.NonNull androidx.constraintlayout.widget.ConstraintLayout constraintLayout, @androidx.annotation.NonNull com.moji.mjweather.weather.dialog.MainPageFunctionGuideBg mainPageFunctionGuideBg, @androidx.annotation.NonNull androidx.constraintlayout.widget.ConstraintLayout constraintLayout2, @androidx.annotation.NonNull androidx.constraintlayout.widget.ConstraintLayout constraintLayout3, @androidx.annotation.NonNull androidx.constraintlayout.widget.ConstraintLayout constraintLayout4, @androidx.annotation.NonNull androidx.constraintlayout.widget.ConstraintLayout constraintLayout5, @androidx.annotation.NonNull androidx.constraintlayout.widget.ConstraintLayout constraintLayout6, @androidx.annotation.NonNull com.moji.imageview.MJImageView mJImageView, @androidx.annotation.NonNull com.moji.imageview.MJImageView mJImageView2, @androidx.annotation.NonNull com.moji.imageview.MJImageView mJImageView3, @androidx.annotation.NonNull com.moji.imageview.MJImageView mJImageView4, @androidx.annotation.NonNull com.airbnb.lottie.LottieAnimationView lottieAnimationView, @androidx.annotation.NonNull android.widget.LinearLayout linearLayout, @androidx.annotation.NonNull android.widget.LinearLayout linearLayout2, @androidx.annotation.NonNull com.moji.textview.MJTextView mJTextView, @androidx.annotation.NonNull com.moji.textview.MJTextView mJTextView2, @androidx.annotation.NonNull com.moji.textview.MJTextView mJTextView3) {
        this.n = constraintLayout;
        this.clBg = mainPageFunctionGuideBg;
        this.clRoot = constraintLayout2;
        this.clStep1 = constraintLayout3;
        this.clStep2 = constraintLayout4;
        this.clStep2Tip = constraintLayout5;
        this.clStep3 = constraintLayout6;
        this.ivArrowStep1 = mJImageView;
        this.ivArrowStep2 = mJImageView2;
        this.ivArrowStep3 = mJImageView3;
        this.ivStep2 = mJImageView4;
        this.ivStep3 = lottieAnimationView;
        this.llStep1 = linearLayout;
        this.llStep3 = linearLayout2;
        this.tvStep = mJTextView;
        this.tvStep2Desc = mJTextView2;
        this.tvStep2Title = mJTextView3;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.MainPageFunctionGuideForV10Binding bind(@androidx.annotation.NonNull android.view.View view) {
        com.moji.imageview.MJImageView findChildViewById;
        com.moji.imageview.MJImageView findChildViewById2;
        com.moji.imageview.MJImageView findChildViewById3;
        com.moji.imageview.MJImageView findChildViewById4;
        com.moji.textview.MJTextView findChildViewById5;
        com.moji.textview.MJTextView findChildViewById6;
        com.moji.textview.MJTextView findChildViewById7;
        int i = moji.com.mjweather.R.id.cl_bg;
        com.moji.mjweather.weather.dialog.MainPageFunctionGuideBg findChildViewById8 = androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (findChildViewById8 != null) {
            androidx.constraintlayout.widget.ConstraintLayout constraintLayout = (androidx.constraintlayout.widget.ConstraintLayout) view;
            i = moji.com.mjweather.R.id.cl_step1;
            androidx.constraintlayout.widget.ConstraintLayout constraintLayout2 = (androidx.constraintlayout.widget.ConstraintLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (constraintLayout2 != null) {
                i = moji.com.mjweather.R.id.cl_step2;
                androidx.constraintlayout.widget.ConstraintLayout constraintLayout3 = (androidx.constraintlayout.widget.ConstraintLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (constraintLayout3 != null) {
                    i = moji.com.mjweather.R.id.cl_step2_tip;
                    androidx.constraintlayout.widget.ConstraintLayout constraintLayout4 = (androidx.constraintlayout.widget.ConstraintLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                    if (constraintLayout4 != null) {
                        i = moji.com.mjweather.R.id.cl_step3;
                        androidx.constraintlayout.widget.ConstraintLayout constraintLayout5 = (androidx.constraintlayout.widget.ConstraintLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                        if (constraintLayout5 != null && (findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.iv_arrow_step1))) != null && (findChildViewById2 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.iv_arrow_step2))) != null && (findChildViewById3 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.iv_arrow_step3))) != null && (findChildViewById4 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.iv_step2))) != null) {
                            i = moji.com.mjweather.R.id.iv_step3;
                            com.airbnb.lottie.LottieAnimationView lottieAnimationView = (com.airbnb.lottie.LottieAnimationView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                            if (lottieAnimationView != null) {
                                i = moji.com.mjweather.R.id.ll_step1;
                                android.widget.LinearLayout linearLayout = (android.widget.LinearLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                if (linearLayout != null) {
                                    i = moji.com.mjweather.R.id.ll_step3;
                                    android.widget.LinearLayout linearLayout2 = (android.widget.LinearLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                    if (linearLayout2 != null && (findChildViewById5 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.tv_step))) != null && (findChildViewById6 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.tv_step2_desc))) != null && (findChildViewById7 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.tv_step2_title))) != null) {
                                        return new moji.com.mjweather.databinding.MainPageFunctionGuideForV10Binding(constraintLayout, findChildViewById8, constraintLayout, constraintLayout2, constraintLayout3, constraintLayout4, constraintLayout5, findChildViewById, findChildViewById2, findChildViewById3, findChildViewById4, lottieAnimationView, linearLayout, linearLayout2, findChildViewById5, findChildViewById6, findChildViewById7);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.MainPageFunctionGuideForV10Binding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.MainPageFunctionGuideForV10Binding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.main_page_function_guide_for_v10, viewGroup, false);
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
