package pad.aqi.cnemc.com.mjallergymodule.databinding;

/* loaded from: classes21.dex */
public final class ItemAllergyDayForcastBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final com.moji.imageview.MJImageView currentItemStatusIcon;

    @androidx.annotation.NonNull
    public final android.widget.TextView currentItemStatusText;

    @androidx.annotation.NonNull
    public final android.widget.TextView currentItemText1;

    @androidx.annotation.NonNull
    public final android.widget.TextView currentItemText2;

    @androidx.annotation.NonNull
    public final android.widget.RelativeLayout n;

    public ItemAllergyDayForcastBinding(@androidx.annotation.NonNull android.widget.RelativeLayout relativeLayout, @androidx.annotation.NonNull com.moji.imageview.MJImageView mJImageView, @androidx.annotation.NonNull android.widget.TextView textView, @androidx.annotation.NonNull android.widget.TextView textView2, @androidx.annotation.NonNull android.widget.TextView textView3) {
        this.n = relativeLayout;
        this.currentItemStatusIcon = mJImageView;
        this.currentItemStatusText = textView;
        this.currentItemText1 = textView2;
        this.currentItemText2 = textView3;
    }

    @androidx.annotation.NonNull
    public static pad.aqi.cnemc.com.mjallergymodule.databinding.ItemAllergyDayForcastBinding bind(@androidx.annotation.NonNull android.view.View view) {
        int i = pad.aqi.cnemc.com.mjallergymodule.R.id.current_item_status_icon;
        com.moji.imageview.MJImageView findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (findChildViewById != null) {
            i = pad.aqi.cnemc.com.mjallergymodule.R.id.current_item_status_text;
            android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = pad.aqi.cnemc.com.mjallergymodule.R.id.current_item_text1;
                android.widget.TextView textView2 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (textView2 != null) {
                    i = pad.aqi.cnemc.com.mjallergymodule.R.id.current_item_text2;
                    android.widget.TextView textView3 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                    if (textView3 != null) {
                        return new pad.aqi.cnemc.com.mjallergymodule.databinding.ItemAllergyDayForcastBinding((android.widget.RelativeLayout) view, findChildViewById, textView, textView2, textView3);
                    }
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static pad.aqi.cnemc.com.mjallergymodule.databinding.ItemAllergyDayForcastBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static pad.aqi.cnemc.com.mjallergymodule.databinding.ItemAllergyDayForcastBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(pad.aqi.cnemc.com.mjallergymodule.R.layout.item_allergy_day_forcast, viewGroup, false);
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
