package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class DialogMemberTabGuideBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final com.moji.mjweather.weather.view.MemberTabGuideView animatLayout;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout llRoot;

    @androidx.annotation.NonNull
    public final com.airbnb.lottie.LottieAnimationView lottieView;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout n;

    @androidx.annotation.NonNull
    public final android.view.View vTemp;

    public DialogMemberTabGuideBinding(@androidx.annotation.NonNull android.widget.LinearLayout linearLayout, @androidx.annotation.NonNull com.moji.mjweather.weather.view.MemberTabGuideView memberTabGuideView, @androidx.annotation.NonNull android.widget.LinearLayout linearLayout2, @androidx.annotation.NonNull com.airbnb.lottie.LottieAnimationView lottieAnimationView, @androidx.annotation.NonNull android.view.View view) {
        this.n = linearLayout;
        this.animatLayout = memberTabGuideView;
        this.llRoot = linearLayout2;
        this.lottieView = lottieAnimationView;
        this.vTemp = view;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.DialogMemberTabGuideBinding bind(@androidx.annotation.NonNull android.view.View view) {
        android.view.View findChildViewById;
        int i = moji.com.mjweather.R.id.animat_layout;
        com.moji.mjweather.weather.view.MemberTabGuideView findChildViewById2 = androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (findChildViewById2 != null) {
            android.widget.LinearLayout linearLayout = (android.widget.LinearLayout) view;
            i = moji.com.mjweather.R.id.lottieView;
            com.airbnb.lottie.LottieAnimationView lottieAnimationView = (com.airbnb.lottie.LottieAnimationView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (lottieAnimationView != null && (findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.vTemp))) != null) {
                return new moji.com.mjweather.databinding.DialogMemberTabGuideBinding(linearLayout, findChildViewById2, linearLayout, lottieAnimationView, findChildViewById);
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.DialogMemberTabGuideBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.DialogMemberTabGuideBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.dialog_member_tab_guide, viewGroup, false);
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
