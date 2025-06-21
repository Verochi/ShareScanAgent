package pad.aqi.cnemc.com.mjallergymodule.databinding;

/* loaded from: classes21.dex */
public final class ActivityAllergyMainBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final com.moji.scrollview.ScrollViewWithListener allergyScrollerContainer;

    @androidx.annotation.NonNull
    public final com.moji.titlebar.MJTitleBar allergyTitleBar;

    @androidx.annotation.NonNull
    public final android.widget.FrameLayout flPickerLayout;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout llContainer;

    @androidx.annotation.NonNull
    public final androidx.constraintlayout.widget.ConstraintLayout n;

    @androidx.annotation.NonNull
    public final com.moji.mjcitypicker.CityPickerView pickerView;

    @androidx.annotation.NonNull
    public final androidx.constraintlayout.widget.ConstraintLayout shareContainer;

    @androidx.annotation.NonNull
    public final com.moji.titlebar.MJTitleBar shareTitleBar;

    @androidx.annotation.NonNull
    public final com.moji.multiplestatuslayout.MJMultipleStatusLayout statusLayout;

    @androidx.annotation.NonNull
    public final android.view.View vPickerShadow;

    public ActivityAllergyMainBinding(@androidx.annotation.NonNull androidx.constraintlayout.widget.ConstraintLayout constraintLayout, @androidx.annotation.NonNull com.moji.scrollview.ScrollViewWithListener scrollViewWithListener, @androidx.annotation.NonNull com.moji.titlebar.MJTitleBar mJTitleBar, @androidx.annotation.NonNull android.widget.FrameLayout frameLayout, @androidx.annotation.NonNull android.widget.LinearLayout linearLayout, @androidx.annotation.NonNull com.moji.mjcitypicker.CityPickerView cityPickerView, @androidx.annotation.NonNull androidx.constraintlayout.widget.ConstraintLayout constraintLayout2, @androidx.annotation.NonNull com.moji.titlebar.MJTitleBar mJTitleBar2, @androidx.annotation.NonNull com.moji.multiplestatuslayout.MJMultipleStatusLayout mJMultipleStatusLayout, @androidx.annotation.NonNull android.view.View view) {
        this.n = constraintLayout;
        this.allergyScrollerContainer = scrollViewWithListener;
        this.allergyTitleBar = mJTitleBar;
        this.flPickerLayout = frameLayout;
        this.llContainer = linearLayout;
        this.pickerView = cityPickerView;
        this.shareContainer = constraintLayout2;
        this.shareTitleBar = mJTitleBar2;
        this.statusLayout = mJMultipleStatusLayout;
        this.vPickerShadow = view;
    }

    @androidx.annotation.NonNull
    public static pad.aqi.cnemc.com.mjallergymodule.databinding.ActivityAllergyMainBinding bind(@androidx.annotation.NonNull android.view.View view) {
        com.moji.titlebar.MJTitleBar findChildViewById;
        com.moji.mjcitypicker.CityPickerView findChildViewById2;
        com.moji.titlebar.MJTitleBar findChildViewById3;
        com.moji.multiplestatuslayout.MJMultipleStatusLayout findChildViewById4;
        android.view.View findChildViewById5;
        int i = pad.aqi.cnemc.com.mjallergymodule.R.id.allergy_scroller_container;
        com.moji.scrollview.ScrollViewWithListener findChildViewById6 = androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (findChildViewById6 != null && (findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = pad.aqi.cnemc.com.mjallergymodule.R.id.allergy_title_bar))) != null) {
            i = pad.aqi.cnemc.com.mjallergymodule.R.id.fl_picker_layout;
            android.widget.FrameLayout frameLayout = (android.widget.FrameLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (frameLayout != null) {
                i = pad.aqi.cnemc.com.mjallergymodule.R.id.ll_container;
                android.widget.LinearLayout linearLayout = (android.widget.LinearLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (linearLayout != null && (findChildViewById2 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = pad.aqi.cnemc.com.mjallergymodule.R.id.picker_view))) != null) {
                    i = pad.aqi.cnemc.com.mjallergymodule.R.id.share_container;
                    androidx.constraintlayout.widget.ConstraintLayout constraintLayout = (androidx.constraintlayout.widget.ConstraintLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                    if (constraintLayout != null && (findChildViewById3 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = pad.aqi.cnemc.com.mjallergymodule.R.id.share_title_bar))) != null && (findChildViewById4 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = pad.aqi.cnemc.com.mjallergymodule.R.id.status_layout))) != null && (findChildViewById5 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = pad.aqi.cnemc.com.mjallergymodule.R.id.v_picker_shadow))) != null) {
                        return new pad.aqi.cnemc.com.mjallergymodule.databinding.ActivityAllergyMainBinding((androidx.constraintlayout.widget.ConstraintLayout) view, findChildViewById6, findChildViewById, frameLayout, linearLayout, findChildViewById2, constraintLayout, findChildViewById3, findChildViewById4, findChildViewById5);
                    }
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static pad.aqi.cnemc.com.mjallergymodule.databinding.ActivityAllergyMainBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static pad.aqi.cnemc.com.mjallergymodule.databinding.ActivityAllergyMainBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(pad.aqi.cnemc.com.mjallergymodule.R.layout.activity_allergy_main, viewGroup, false);
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
