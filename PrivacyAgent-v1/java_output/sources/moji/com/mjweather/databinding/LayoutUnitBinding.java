package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class LayoutUnitBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.RelativeLayout n;

    @androidx.annotation.NonNull
    public final com.moji.textview.MJTextView reset;

    @androidx.annotation.NonNull
    public final com.moji.textview.MJTextView titleUnitPressure;

    @androidx.annotation.NonNull
    public final com.moji.textview.MJTextView titleUnitSpeed;

    @androidx.annotation.NonNull
    public final com.moji.textview.MJTextView titleUnitTemp;

    @androidx.annotation.NonNull
    public final android.widget.RadioGroup unitRgPressure;

    @androidx.annotation.NonNull
    public final android.widget.RadioButton unitRgPressureHPa;

    @androidx.annotation.NonNull
    public final android.widget.RadioButton unitRgPressureInHg;

    @androidx.annotation.NonNull
    public final android.widget.RadioButton unitRgPressureMbar;

    @androidx.annotation.NonNull
    public final android.widget.RadioButton unitRgPressureMmHg;

    @androidx.annotation.NonNull
    public final android.widget.RadioGroup unitRgTemp;

    @androidx.annotation.NonNull
    public final android.widget.RadioButton unitRgTempCentigrade;

    @androidx.annotation.NonNull
    public final android.widget.RadioButton unitRgTempF;

    @androidx.annotation.NonNull
    public final android.widget.RadioGroup unitRgWind;

    @androidx.annotation.NonNull
    public final android.widget.RadioButton unitRgWindBeau;

    @androidx.annotation.NonNull
    public final android.widget.RadioButton unitRgWindHk;

    @androidx.annotation.NonNull
    public final android.widget.RadioButton unitRgWindKm;

    @androidx.annotation.NonNull
    public final android.widget.RadioButton unitRgWindKt;

    @androidx.annotation.NonNull
    public final android.widget.RadioButton unitRgWindMeter;

    @androidx.annotation.NonNull
    public final android.widget.RadioButton unitRgWindMile;

    @androidx.annotation.NonNull
    public final com.moji.titlebar.MJTitleBar unitTitleBar;

    public LayoutUnitBinding(@androidx.annotation.NonNull android.widget.RelativeLayout relativeLayout, @androidx.annotation.NonNull com.moji.textview.MJTextView mJTextView, @androidx.annotation.NonNull com.moji.textview.MJTextView mJTextView2, @androidx.annotation.NonNull com.moji.textview.MJTextView mJTextView3, @androidx.annotation.NonNull com.moji.textview.MJTextView mJTextView4, @androidx.annotation.NonNull android.widget.RadioGroup radioGroup, @androidx.annotation.NonNull android.widget.RadioButton radioButton, @androidx.annotation.NonNull android.widget.RadioButton radioButton2, @androidx.annotation.NonNull android.widget.RadioButton radioButton3, @androidx.annotation.NonNull android.widget.RadioButton radioButton4, @androidx.annotation.NonNull android.widget.RadioGroup radioGroup2, @androidx.annotation.NonNull android.widget.RadioButton radioButton5, @androidx.annotation.NonNull android.widget.RadioButton radioButton6, @androidx.annotation.NonNull android.widget.RadioGroup radioGroup3, @androidx.annotation.NonNull android.widget.RadioButton radioButton7, @androidx.annotation.NonNull android.widget.RadioButton radioButton8, @androidx.annotation.NonNull android.widget.RadioButton radioButton9, @androidx.annotation.NonNull android.widget.RadioButton radioButton10, @androidx.annotation.NonNull android.widget.RadioButton radioButton11, @androidx.annotation.NonNull android.widget.RadioButton radioButton12, @androidx.annotation.NonNull com.moji.titlebar.MJTitleBar mJTitleBar) {
        this.n = relativeLayout;
        this.reset = mJTextView;
        this.titleUnitPressure = mJTextView2;
        this.titleUnitSpeed = mJTextView3;
        this.titleUnitTemp = mJTextView4;
        this.unitRgPressure = radioGroup;
        this.unitRgPressureHPa = radioButton;
        this.unitRgPressureInHg = radioButton2;
        this.unitRgPressureMbar = radioButton3;
        this.unitRgPressureMmHg = radioButton4;
        this.unitRgTemp = radioGroup2;
        this.unitRgTempCentigrade = radioButton5;
        this.unitRgTempF = radioButton6;
        this.unitRgWind = radioGroup3;
        this.unitRgWindBeau = radioButton7;
        this.unitRgWindHk = radioButton8;
        this.unitRgWindKm = radioButton9;
        this.unitRgWindKt = radioButton10;
        this.unitRgWindMeter = radioButton11;
        this.unitRgWindMile = radioButton12;
        this.unitTitleBar = mJTitleBar;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.LayoutUnitBinding bind(@androidx.annotation.NonNull android.view.View view) {
        com.moji.textview.MJTextView findChildViewById;
        com.moji.textview.MJTextView findChildViewById2;
        com.moji.textview.MJTextView findChildViewById3;
        com.moji.titlebar.MJTitleBar findChildViewById4;
        int i = moji.com.mjweather.R.id.reset;
        com.moji.textview.MJTextView findChildViewById5 = androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (findChildViewById5 != null && (findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.title_unit_pressure))) != null && (findChildViewById2 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.title_unit_speed))) != null && (findChildViewById3 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.title_unit_temp))) != null) {
            i = moji.com.mjweather.R.id.unit_rg_pressure;
            android.widget.RadioGroup radioGroup = (android.widget.RadioGroup) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (radioGroup != null) {
                i = moji.com.mjweather.R.id.unit_rg_pressure_hPa;
                android.widget.RadioButton radioButton = (android.widget.RadioButton) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (radioButton != null) {
                    i = moji.com.mjweather.R.id.unit_rg_pressure_inHg;
                    android.widget.RadioButton radioButton2 = (android.widget.RadioButton) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                    if (radioButton2 != null) {
                        i = moji.com.mjweather.R.id.unit_rg_pressure_mbar;
                        android.widget.RadioButton radioButton3 = (android.widget.RadioButton) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                        if (radioButton3 != null) {
                            i = moji.com.mjweather.R.id.unit_rg_pressure_mmHg;
                            android.widget.RadioButton radioButton4 = (android.widget.RadioButton) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                            if (radioButton4 != null) {
                                i = moji.com.mjweather.R.id.unit_rg_temp;
                                android.widget.RadioGroup radioGroup2 = (android.widget.RadioGroup) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                if (radioGroup2 != null) {
                                    i = moji.com.mjweather.R.id.unit_rg_temp_centigrade;
                                    android.widget.RadioButton radioButton5 = (android.widget.RadioButton) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                    if (radioButton5 != null) {
                                        i = moji.com.mjweather.R.id.unit_rg_temp_f;
                                        android.widget.RadioButton radioButton6 = (android.widget.RadioButton) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                        if (radioButton6 != null) {
                                            i = moji.com.mjweather.R.id.unit_rg_wind;
                                            android.widget.RadioGroup radioGroup3 = (android.widget.RadioGroup) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                            if (radioGroup3 != null) {
                                                i = moji.com.mjweather.R.id.unit_rg_wind_beau;
                                                android.widget.RadioButton radioButton7 = (android.widget.RadioButton) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                                if (radioButton7 != null) {
                                                    i = moji.com.mjweather.R.id.unit_rg_wind_hk;
                                                    android.widget.RadioButton radioButton8 = (android.widget.RadioButton) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                                    if (radioButton8 != null) {
                                                        i = moji.com.mjweather.R.id.unit_rg_wind_km;
                                                        android.widget.RadioButton radioButton9 = (android.widget.RadioButton) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                                        if (radioButton9 != null) {
                                                            i = moji.com.mjweather.R.id.unit_rg_wind_kt;
                                                            android.widget.RadioButton radioButton10 = (android.widget.RadioButton) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                                            if (radioButton10 != null) {
                                                                i = moji.com.mjweather.R.id.unit_rg_wind_meter;
                                                                android.widget.RadioButton radioButton11 = (android.widget.RadioButton) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                                                if (radioButton11 != null) {
                                                                    i = moji.com.mjweather.R.id.unit_rg_wind_mile;
                                                                    android.widget.RadioButton radioButton12 = (android.widget.RadioButton) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                                                    if (radioButton12 != null && (findChildViewById4 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.unit_title_bar))) != null) {
                                                                        return new moji.com.mjweather.databinding.LayoutUnitBinding((android.widget.RelativeLayout) view, findChildViewById5, findChildViewById, findChildViewById2, findChildViewById3, radioGroup, radioButton, radioButton2, radioButton3, radioButton4, radioGroup2, radioButton5, radioButton6, radioGroup3, radioButton7, radioButton8, radioButton9, radioButton10, radioButton11, radioButton12, findChildViewById4);
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.LayoutUnitBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.LayoutUnitBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.layout_unit, viewGroup, false);
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
