package pad.aqi.cnemc.com.mjallergymodule.databinding;

/* loaded from: classes21.dex */
public final class ViewAlleryReportBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.ImageView ivStatusIcon;

    @androidx.annotation.NonNull
    public final android.widget.FrameLayout n;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvAllergyName;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvAllergySource;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvAllergyTotalNum;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvAllergyYearNum;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvDoctorReport;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvGetMyReport;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvName;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvSource;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvStatusText;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvTotalNum;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvYearNum;

    public ViewAlleryReportBinding(@androidx.annotation.NonNull android.widget.FrameLayout frameLayout, @androidx.annotation.NonNull android.widget.ImageView imageView, @androidx.annotation.NonNull android.widget.TextView textView, @androidx.annotation.NonNull android.widget.TextView textView2, @androidx.annotation.NonNull android.widget.TextView textView3, @androidx.annotation.NonNull android.widget.TextView textView4, @androidx.annotation.NonNull android.widget.TextView textView5, @androidx.annotation.NonNull android.widget.TextView textView6, @androidx.annotation.NonNull android.widget.TextView textView7, @androidx.annotation.NonNull android.widget.TextView textView8, @androidx.annotation.NonNull android.widget.TextView textView9, @androidx.annotation.NonNull android.widget.TextView textView10, @androidx.annotation.NonNull android.widget.TextView textView11) {
        this.n = frameLayout;
        this.ivStatusIcon = imageView;
        this.tvAllergyName = textView;
        this.tvAllergySource = textView2;
        this.tvAllergyTotalNum = textView3;
        this.tvAllergyYearNum = textView4;
        this.tvDoctorReport = textView5;
        this.tvGetMyReport = textView6;
        this.tvName = textView7;
        this.tvSource = textView8;
        this.tvStatusText = textView9;
        this.tvTotalNum = textView10;
        this.tvYearNum = textView11;
    }

    @androidx.annotation.NonNull
    public static pad.aqi.cnemc.com.mjallergymodule.databinding.ViewAlleryReportBinding bind(@androidx.annotation.NonNull android.view.View view) {
        int i = pad.aqi.cnemc.com.mjallergymodule.R.id.iv_status_icon;
        android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = pad.aqi.cnemc.com.mjallergymodule.R.id.tv_allergy_name;
            android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = pad.aqi.cnemc.com.mjallergymodule.R.id.tv_allergy_source;
                android.widget.TextView textView2 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (textView2 != null) {
                    i = pad.aqi.cnemc.com.mjallergymodule.R.id.tv_allergy_total_num;
                    android.widget.TextView textView3 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                    if (textView3 != null) {
                        i = pad.aqi.cnemc.com.mjallergymodule.R.id.tv_allergy_year_num;
                        android.widget.TextView textView4 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                        if (textView4 != null) {
                            i = pad.aqi.cnemc.com.mjallergymodule.R.id.tv_doctor_report;
                            android.widget.TextView textView5 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                            if (textView5 != null) {
                                i = pad.aqi.cnemc.com.mjallergymodule.R.id.tv_get_my_report;
                                android.widget.TextView textView6 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                if (textView6 != null) {
                                    i = pad.aqi.cnemc.com.mjallergymodule.R.id.tv_name;
                                    android.widget.TextView textView7 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                    if (textView7 != null) {
                                        i = pad.aqi.cnemc.com.mjallergymodule.R.id.tv_source;
                                        android.widget.TextView textView8 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                        if (textView8 != null) {
                                            i = pad.aqi.cnemc.com.mjallergymodule.R.id.tv_status_text;
                                            android.widget.TextView textView9 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                            if (textView9 != null) {
                                                i = pad.aqi.cnemc.com.mjallergymodule.R.id.tv_total_num;
                                                android.widget.TextView textView10 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                                if (textView10 != null) {
                                                    i = pad.aqi.cnemc.com.mjallergymodule.R.id.tv_year_num;
                                                    android.widget.TextView textView11 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                                    if (textView11 != null) {
                                                        return new pad.aqi.cnemc.com.mjallergymodule.databinding.ViewAlleryReportBinding((android.widget.FrameLayout) view, imageView, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11);
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
    public static pad.aqi.cnemc.com.mjallergymodule.databinding.ViewAlleryReportBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static pad.aqi.cnemc.com.mjallergymodule.databinding.ViewAlleryReportBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(pad.aqi.cnemc.com.mjallergymodule.R.layout.view_allery_report, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @androidx.annotation.NonNull
    public android.widget.FrameLayout getRoot() {
        return this.n;
    }
}
