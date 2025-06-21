package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class Day15LayoutPopBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final com.moji.mjweather.weather.view.Days15PopContainerView containerView;

    @androidx.annotation.NonNull
    public final com.moji.imageview.MJImageView curveIcon;

    @androidx.annotation.NonNull
    public final com.moji.textview.MJTextView curveText;

    @androidx.annotation.NonNull
    public final android.view.View day15PopDivider;

    @androidx.annotation.NonNull
    public final com.moji.imageview.MJImageView lineIcon;

    @androidx.annotation.NonNull
    public final com.moji.textview.MJTextView lineText;

    @androidx.annotation.NonNull
    public final android.view.View maskView;

    @androidx.annotation.NonNull
    public final androidx.constraintlayout.widget.ConstraintLayout n;

    public Day15LayoutPopBinding(@androidx.annotation.NonNull androidx.constraintlayout.widget.ConstraintLayout constraintLayout, @androidx.annotation.NonNull com.moji.mjweather.weather.view.Days15PopContainerView days15PopContainerView, @androidx.annotation.NonNull com.moji.imageview.MJImageView mJImageView, @androidx.annotation.NonNull com.moji.textview.MJTextView mJTextView, @androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull com.moji.imageview.MJImageView mJImageView2, @androidx.annotation.NonNull com.moji.textview.MJTextView mJTextView2, @androidx.annotation.NonNull android.view.View view2) {
        this.n = constraintLayout;
        this.containerView = days15PopContainerView;
        this.curveIcon = mJImageView;
        this.curveText = mJTextView;
        this.day15PopDivider = view;
        this.lineIcon = mJImageView2;
        this.lineText = mJTextView2;
        this.maskView = view2;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.Day15LayoutPopBinding bind(@androidx.annotation.NonNull android.view.View view) {
        com.moji.imageview.MJImageView findChildViewById;
        com.moji.textview.MJTextView findChildViewById2;
        android.view.View findChildViewById3;
        com.moji.imageview.MJImageView findChildViewById4;
        com.moji.textview.MJTextView findChildViewById5;
        android.view.View findChildViewById6;
        int i = moji.com.mjweather.R.id.containerView;
        com.moji.mjweather.weather.view.Days15PopContainerView findChildViewById7 = androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (findChildViewById7 == null || (findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.curve_icon))) == null || (findChildViewById2 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.curve_text))) == null || (findChildViewById3 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.day15_pop_divider))) == null || (findChildViewById4 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.line_icon))) == null || (findChildViewById5 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.line_text))) == null || (findChildViewById6 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.maskView))) == null) {
            throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new moji.com.mjweather.databinding.Day15LayoutPopBinding((androidx.constraintlayout.widget.ConstraintLayout) view, findChildViewById7, findChildViewById, findChildViewById2, findChildViewById3, findChildViewById4, findChildViewById5, findChildViewById6);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.Day15LayoutPopBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.Day15LayoutPopBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.day15_layout_pop, viewGroup, false);
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
