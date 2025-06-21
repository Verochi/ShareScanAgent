package pad.aqi.cnemc.com.mjallergymodule.databinding;

/* loaded from: classes21.dex */
public final class PopwindowAllergyMapMarkerBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final com.moji.imageview.MJImageView ivPicture;

    @androidx.annotation.NonNull
    public final androidx.constraintlayout.widget.ConstraintLayout n;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvDesc;

    public PopwindowAllergyMapMarkerBinding(@androidx.annotation.NonNull androidx.constraintlayout.widget.ConstraintLayout constraintLayout, @androidx.annotation.NonNull com.moji.imageview.MJImageView mJImageView, @androidx.annotation.NonNull android.widget.TextView textView) {
        this.n = constraintLayout;
        this.ivPicture = mJImageView;
        this.tvDesc = textView;
    }

    @androidx.annotation.NonNull
    public static pad.aqi.cnemc.com.mjallergymodule.databinding.PopwindowAllergyMapMarkerBinding bind(@androidx.annotation.NonNull android.view.View view) {
        int i = pad.aqi.cnemc.com.mjallergymodule.R.id.iv_picture;
        com.moji.imageview.MJImageView findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (findChildViewById != null) {
            i = pad.aqi.cnemc.com.mjallergymodule.R.id.tv_desc;
            android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                return new pad.aqi.cnemc.com.mjallergymodule.databinding.PopwindowAllergyMapMarkerBinding((androidx.constraintlayout.widget.ConstraintLayout) view, findChildViewById, textView);
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static pad.aqi.cnemc.com.mjallergymodule.databinding.PopwindowAllergyMapMarkerBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static pad.aqi.cnemc.com.mjallergymodule.databinding.PopwindowAllergyMapMarkerBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(pad.aqi.cnemc.com.mjallergymodule.R.layout.popwindow_allergy_map_marker, viewGroup, false);
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
