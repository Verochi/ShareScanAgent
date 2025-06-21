package moji.com.mjweatherservicebase.databinding;

/* loaded from: classes20.dex */
public final class LayoutRflowersMapBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.RadioGroup mapRadioGroup;

    @androidx.annotation.NonNull
    public final android.widget.RadioButton mapTypeSpot;

    @androidx.annotation.NonNull
    public final android.widget.RadioButton mapTypeTrend;

    @androidx.annotation.NonNull
    public final android.widget.FrameLayout mapView;

    @androidx.annotation.NonNull
    public final android.widget.RelativeLayout n;

    public LayoutRflowersMapBinding(@androidx.annotation.NonNull android.widget.RelativeLayout relativeLayout, @androidx.annotation.NonNull android.widget.RadioGroup radioGroup, @androidx.annotation.NonNull android.widget.RadioButton radioButton, @androidx.annotation.NonNull android.widget.RadioButton radioButton2, @androidx.annotation.NonNull android.widget.FrameLayout frameLayout) {
        this.n = relativeLayout;
        this.mapRadioGroup = radioGroup;
        this.mapTypeSpot = radioButton;
        this.mapTypeTrend = radioButton2;
        this.mapView = frameLayout;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweatherservicebase.databinding.LayoutRflowersMapBinding bind(@androidx.annotation.NonNull android.view.View view) {
        int i = moji.com.mjweatherservicebase.R.id.map_radio_group;
        android.widget.RadioGroup radioGroup = (android.widget.RadioGroup) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (radioGroup != null) {
            i = moji.com.mjweatherservicebase.R.id.map_type_spot;
            android.widget.RadioButton radioButton = (android.widget.RadioButton) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (radioButton != null) {
                i = moji.com.mjweatherservicebase.R.id.map_type_trend;
                android.widget.RadioButton radioButton2 = (android.widget.RadioButton) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (radioButton2 != null) {
                    i = moji.com.mjweatherservicebase.R.id.map_view;
                    android.widget.FrameLayout frameLayout = (android.widget.FrameLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                    if (frameLayout != null) {
                        return new moji.com.mjweatherservicebase.databinding.LayoutRflowersMapBinding((android.widget.RelativeLayout) view, radioGroup, radioButton, radioButton2, frameLayout);
                    }
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweatherservicebase.databinding.LayoutRflowersMapBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweatherservicebase.databinding.LayoutRflowersMapBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweatherservicebase.R.layout.layout_rflowers_map, viewGroup, false);
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
