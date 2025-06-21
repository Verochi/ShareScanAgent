package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class ActivitySettingPoiBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.RadioButton locationPoi;

    @androidx.annotation.NonNull
    public final android.widget.RadioButton locationStreet;

    @androidx.annotation.NonNull
    public final android.widget.RelativeLayout n;

    @androidx.annotation.NonNull
    public final com.moji.titlebar.MJTitleBar titleBar;

    public ActivitySettingPoiBinding(@androidx.annotation.NonNull android.widget.RelativeLayout relativeLayout, @androidx.annotation.NonNull android.widget.RadioButton radioButton, @androidx.annotation.NonNull android.widget.RadioButton radioButton2, @androidx.annotation.NonNull com.moji.titlebar.MJTitleBar mJTitleBar) {
        this.n = relativeLayout;
        this.locationPoi = radioButton;
        this.locationStreet = radioButton2;
        this.titleBar = mJTitleBar;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ActivitySettingPoiBinding bind(@androidx.annotation.NonNull android.view.View view) {
        com.moji.titlebar.MJTitleBar findChildViewById;
        int i = moji.com.mjweather.R.id.location_poi;
        android.widget.RadioButton radioButton = (android.widget.RadioButton) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (radioButton != null) {
            i = moji.com.mjweather.R.id.location_street;
            android.widget.RadioButton radioButton2 = (android.widget.RadioButton) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (radioButton2 != null && (findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.title_bar))) != null) {
                return new moji.com.mjweather.databinding.ActivitySettingPoiBinding((android.widget.RelativeLayout) view, radioButton, radioButton2, findChildViewById);
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ActivitySettingPoiBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ActivitySettingPoiBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.activity_setting_poi, viewGroup, false);
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
