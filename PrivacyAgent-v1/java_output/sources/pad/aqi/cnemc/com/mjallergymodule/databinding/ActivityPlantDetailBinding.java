package pad.aqi.cnemc.com.mjallergymodule.databinding;

/* loaded from: classes21.dex */
public final class ActivityPlantDetailBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.ImageView ivPicture;

    @androidx.annotation.NonNull
    public final android.widget.ImageView ivSymptom;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout layoutSymptom;

    @androidx.annotation.NonNull
    public final androidx.constraintlayout.widget.ConstraintLayout n;

    @androidx.annotation.NonNull
    public final com.moji.titlebar.MJTitleBar titleBar;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvDesc;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvName;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvSymptom;

    public ActivityPlantDetailBinding(@androidx.annotation.NonNull androidx.constraintlayout.widget.ConstraintLayout constraintLayout, @androidx.annotation.NonNull android.widget.ImageView imageView, @androidx.annotation.NonNull android.widget.ImageView imageView2, @androidx.annotation.NonNull android.widget.LinearLayout linearLayout, @androidx.annotation.NonNull com.moji.titlebar.MJTitleBar mJTitleBar, @androidx.annotation.NonNull android.widget.TextView textView, @androidx.annotation.NonNull android.widget.TextView textView2, @androidx.annotation.NonNull android.widget.TextView textView3) {
        this.n = constraintLayout;
        this.ivPicture = imageView;
        this.ivSymptom = imageView2;
        this.layoutSymptom = linearLayout;
        this.titleBar = mJTitleBar;
        this.tvDesc = textView;
        this.tvName = textView2;
        this.tvSymptom = textView3;
    }

    @androidx.annotation.NonNull
    public static pad.aqi.cnemc.com.mjallergymodule.databinding.ActivityPlantDetailBinding bind(@androidx.annotation.NonNull android.view.View view) {
        com.moji.titlebar.MJTitleBar findChildViewById;
        int i = pad.aqi.cnemc.com.mjallergymodule.R.id.iv_picture;
        android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = pad.aqi.cnemc.com.mjallergymodule.R.id.iv_symptom;
            android.widget.ImageView imageView2 = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (imageView2 != null) {
                i = pad.aqi.cnemc.com.mjallergymodule.R.id.layout_symptom;
                android.widget.LinearLayout linearLayout = (android.widget.LinearLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (linearLayout != null && (findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = pad.aqi.cnemc.com.mjallergymodule.R.id.title_bar))) != null) {
                    i = pad.aqi.cnemc.com.mjallergymodule.R.id.tv_desc;
                    android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                    if (textView != null) {
                        i = pad.aqi.cnemc.com.mjallergymodule.R.id.tv_name;
                        android.widget.TextView textView2 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                        if (textView2 != null) {
                            i = pad.aqi.cnemc.com.mjallergymodule.R.id.tv_symptom;
                            android.widget.TextView textView3 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                            if (textView3 != null) {
                                return new pad.aqi.cnemc.com.mjallergymodule.databinding.ActivityPlantDetailBinding((androidx.constraintlayout.widget.ConstraintLayout) view, imageView, imageView2, linearLayout, findChildViewById, textView, textView2, textView3);
                            }
                        }
                    }
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static pad.aqi.cnemc.com.mjallergymodule.databinding.ActivityPlantDetailBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static pad.aqi.cnemc.com.mjallergymodule.databinding.ActivityPlantDetailBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(pad.aqi.cnemc.com.mjallergymodule.R.layout.activity_plant_detail, viewGroup, false);
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
