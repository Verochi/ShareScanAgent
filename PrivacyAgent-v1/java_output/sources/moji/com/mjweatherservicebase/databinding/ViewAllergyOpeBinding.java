package moji.com.mjweatherservicebase.databinding;

/* loaded from: classes20.dex */
public final class ViewAllergyOpeBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final moji.com.mjweatherservicebase.view.sliderbanner.MJAutoSlideBannerView bannerView;

    @androidx.annotation.NonNull
    public final com.moji.imageview.FourCornerImageView ivFeedbackItem1;

    @androidx.annotation.NonNull
    public final com.moji.imageview.FourCornerImageView ivFeedbackItem2;

    @androidx.annotation.NonNull
    public final androidx.constraintlayout.widget.ConstraintLayout n;

    @androidx.annotation.NonNull
    public final androidx.constraintlayout.widget.ConstraintLayout parent;

    public ViewAllergyOpeBinding(@androidx.annotation.NonNull androidx.constraintlayout.widget.ConstraintLayout constraintLayout, @androidx.annotation.NonNull moji.com.mjweatherservicebase.view.sliderbanner.MJAutoSlideBannerView mJAutoSlideBannerView, @androidx.annotation.NonNull com.moji.imageview.FourCornerImageView fourCornerImageView, @androidx.annotation.NonNull com.moji.imageview.FourCornerImageView fourCornerImageView2, @androidx.annotation.NonNull androidx.constraintlayout.widget.ConstraintLayout constraintLayout2) {
        this.n = constraintLayout;
        this.bannerView = mJAutoSlideBannerView;
        this.ivFeedbackItem1 = fourCornerImageView;
        this.ivFeedbackItem2 = fourCornerImageView2;
        this.parent = constraintLayout2;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweatherservicebase.databinding.ViewAllergyOpeBinding bind(@androidx.annotation.NonNull android.view.View view) {
        com.moji.imageview.FourCornerImageView findChildViewById;
        com.moji.imageview.FourCornerImageView findChildViewById2;
        int i = moji.com.mjweatherservicebase.R.id.bannerView;
        moji.com.mjweatherservicebase.view.sliderbanner.MJAutoSlideBannerView mJAutoSlideBannerView = (moji.com.mjweatherservicebase.view.sliderbanner.MJAutoSlideBannerView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (mJAutoSlideBannerView == null || (findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweatherservicebase.R.id.iv_feedback_item1))) == null || (findChildViewById2 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweatherservicebase.R.id.iv_feedback_item2))) == null) {
            throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        androidx.constraintlayout.widget.ConstraintLayout constraintLayout = (androidx.constraintlayout.widget.ConstraintLayout) view;
        return new moji.com.mjweatherservicebase.databinding.ViewAllergyOpeBinding(constraintLayout, mJAutoSlideBannerView, findChildViewById, findChildViewById2, constraintLayout);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweatherservicebase.databinding.ViewAllergyOpeBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweatherservicebase.databinding.ViewAllergyOpeBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweatherservicebase.R.layout.view_allergy_ope, viewGroup, false);
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
