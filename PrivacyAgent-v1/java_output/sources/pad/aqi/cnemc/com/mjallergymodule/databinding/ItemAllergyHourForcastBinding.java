package pad.aqi.cnemc.com.mjallergymodule.databinding;

/* loaded from: classes21.dex */
public final class ItemAllergyHourForcastBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout allergyContentLayout;

    @androidx.annotation.NonNull
    public final com.moji.imageview.MJImageView currentHourStatusIcon;

    @androidx.annotation.NonNull
    public final android.widget.TextView currentHourStatusText;

    @androidx.annotation.NonNull
    public final android.widget.TextView currentHourText1;

    @androidx.annotation.NonNull
    public final android.widget.TextView currentHourText2;

    @androidx.annotation.NonNull
    public final android.widget.RelativeLayout n;

    public ItemAllergyHourForcastBinding(@androidx.annotation.NonNull android.widget.RelativeLayout relativeLayout, @androidx.annotation.NonNull android.widget.LinearLayout linearLayout, @androidx.annotation.NonNull com.moji.imageview.MJImageView mJImageView, @androidx.annotation.NonNull android.widget.TextView textView, @androidx.annotation.NonNull android.widget.TextView textView2, @androidx.annotation.NonNull android.widget.TextView textView3) {
        this.n = relativeLayout;
        this.allergyContentLayout = linearLayout;
        this.currentHourStatusIcon = mJImageView;
        this.currentHourStatusText = textView;
        this.currentHourText1 = textView2;
        this.currentHourText2 = textView3;
    }

    @androidx.annotation.NonNull
    public static pad.aqi.cnemc.com.mjallergymodule.databinding.ItemAllergyHourForcastBinding bind(@androidx.annotation.NonNull android.view.View view) {
        com.moji.imageview.MJImageView findChildViewById;
        int i = pad.aqi.cnemc.com.mjallergymodule.R.id.allergy_content_layout;
        android.widget.LinearLayout linearLayout = (android.widget.LinearLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (linearLayout != null && (findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = pad.aqi.cnemc.com.mjallergymodule.R.id.current_hour_status_icon))) != null) {
            i = pad.aqi.cnemc.com.mjallergymodule.R.id.current_hour_status_text;
            android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = pad.aqi.cnemc.com.mjallergymodule.R.id.current_hour_text1;
                android.widget.TextView textView2 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (textView2 != null) {
                    i = pad.aqi.cnemc.com.mjallergymodule.R.id.current_hour_text2;
                    android.widget.TextView textView3 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                    if (textView3 != null) {
                        return new pad.aqi.cnemc.com.mjallergymodule.databinding.ItemAllergyHourForcastBinding((android.widget.RelativeLayout) view, linearLayout, findChildViewById, textView, textView2, textView3);
                    }
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static pad.aqi.cnemc.com.mjallergymodule.databinding.ItemAllergyHourForcastBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static pad.aqi.cnemc.com.mjallergymodule.databinding.ItemAllergyHourForcastBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(pad.aqi.cnemc.com.mjallergymodule.R.layout.item_allergy_hour_forcast, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @androidx.annotation.NonNull
    public android.widget.RelativeLayout getRoot() {
        return this.n;
    }
}
