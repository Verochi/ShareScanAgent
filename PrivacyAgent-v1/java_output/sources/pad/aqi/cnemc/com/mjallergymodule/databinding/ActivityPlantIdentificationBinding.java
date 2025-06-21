package pad.aqi.cnemc.com.mjallergymodule.databinding;

/* loaded from: classes21.dex */
public final class ActivityPlantIdentificationBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final com.airbnb.lottie.LottieAnimationView cloudIdentificationAnimation;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout llBg;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout n;

    @androidx.annotation.NonNull
    public final com.moji.titlebar.MJTitleBar titleBar;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvCloudIdentificationProgress;

    @androidx.annotation.NonNull
    public final com.moji.multiplestatuslayout.MJMultipleStatusLayout viewStatusLayout;

    public ActivityPlantIdentificationBinding(@androidx.annotation.NonNull android.widget.LinearLayout linearLayout, @androidx.annotation.NonNull com.airbnb.lottie.LottieAnimationView lottieAnimationView, @androidx.annotation.NonNull android.widget.LinearLayout linearLayout2, @androidx.annotation.NonNull com.moji.titlebar.MJTitleBar mJTitleBar, @androidx.annotation.NonNull android.widget.TextView textView, @androidx.annotation.NonNull com.moji.multiplestatuslayout.MJMultipleStatusLayout mJMultipleStatusLayout) {
        this.n = linearLayout;
        this.cloudIdentificationAnimation = lottieAnimationView;
        this.llBg = linearLayout2;
        this.titleBar = mJTitleBar;
        this.tvCloudIdentificationProgress = textView;
        this.viewStatusLayout = mJMultipleStatusLayout;
    }

    @androidx.annotation.NonNull
    public static pad.aqi.cnemc.com.mjallergymodule.databinding.ActivityPlantIdentificationBinding bind(@androidx.annotation.NonNull android.view.View view) {
        com.moji.titlebar.MJTitleBar findChildViewById;
        com.moji.multiplestatuslayout.MJMultipleStatusLayout findChildViewById2;
        int i = pad.aqi.cnemc.com.mjallergymodule.R.id.cloud_identification_animation;
        com.airbnb.lottie.LottieAnimationView lottieAnimationView = (com.airbnb.lottie.LottieAnimationView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (lottieAnimationView != null) {
            i = pad.aqi.cnemc.com.mjallergymodule.R.id.ll_bg;
            android.widget.LinearLayout linearLayout = (android.widget.LinearLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (linearLayout != null && (findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = pad.aqi.cnemc.com.mjallergymodule.R.id.title_bar))) != null) {
                i = pad.aqi.cnemc.com.mjallergymodule.R.id.tv_cloud_identification_progress;
                android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (textView != null && (findChildViewById2 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = pad.aqi.cnemc.com.mjallergymodule.R.id.view_status_layout))) != null) {
                    return new pad.aqi.cnemc.com.mjallergymodule.databinding.ActivityPlantIdentificationBinding((android.widget.LinearLayout) view, lottieAnimationView, linearLayout, findChildViewById, textView, findChildViewById2);
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static pad.aqi.cnemc.com.mjallergymodule.databinding.ActivityPlantIdentificationBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static pad.aqi.cnemc.com.mjallergymodule.databinding.ActivityPlantIdentificationBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(pad.aqi.cnemc.com.mjallergymodule.R.layout.activity_plant_identification, viewGroup, false);
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
