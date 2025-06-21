package pad.aqi.cnemc.com.mjallergymodule.databinding;

/* loaded from: classes21.dex */
public final class PopwindowAllergyMapMarkerNewBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.ImageButton ivTitleClose;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout llPop;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout n;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvTitleDetail;

    public PopwindowAllergyMapMarkerNewBinding(@androidx.annotation.NonNull android.widget.LinearLayout linearLayout, @androidx.annotation.NonNull android.widget.ImageButton imageButton, @androidx.annotation.NonNull android.widget.LinearLayout linearLayout2, @androidx.annotation.NonNull android.widget.TextView textView) {
        this.n = linearLayout;
        this.ivTitleClose = imageButton;
        this.llPop = linearLayout2;
        this.tvTitleDetail = textView;
    }

    @androidx.annotation.NonNull
    public static pad.aqi.cnemc.com.mjallergymodule.databinding.PopwindowAllergyMapMarkerNewBinding bind(@androidx.annotation.NonNull android.view.View view) {
        int i = pad.aqi.cnemc.com.mjallergymodule.R.id.iv_title_close;
        android.widget.ImageButton imageButton = (android.widget.ImageButton) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (imageButton != null) {
            android.widget.LinearLayout linearLayout = (android.widget.LinearLayout) view;
            int i2 = pad.aqi.cnemc.com.mjallergymodule.R.id.tv_title_detail;
            android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i2);
            if (textView != null) {
                return new pad.aqi.cnemc.com.mjallergymodule.databinding.PopwindowAllergyMapMarkerNewBinding(linearLayout, imageButton, linearLayout, textView);
            }
            i = i2;
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static pad.aqi.cnemc.com.mjallergymodule.databinding.PopwindowAllergyMapMarkerNewBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static pad.aqi.cnemc.com.mjallergymodule.databinding.PopwindowAllergyMapMarkerNewBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(pad.aqi.cnemc.com.mjallergymodule.R.layout.popwindow_allergy_map_marker_new, viewGroup, false);
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
