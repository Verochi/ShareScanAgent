package pad.aqi.cnemc.com.mjallergymodule.databinding;

/* loaded from: classes21.dex */
public final class ViewAlleryFeedbackBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.RelativeLayout loadingView;

    @androidx.annotation.NonNull
    public final android.widget.FrameLayout n;

    @androidx.annotation.NonNull
    public final android.widget.RadioGroup symptomGroup;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvAllergyDescText;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvAllergySource;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvAllergySourceTitle;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvGotoReport;

    @androidx.annotation.NonNull
    public final android.widget.RadioButton vSymptom1;

    @androidx.annotation.NonNull
    public final android.widget.RadioButton vSymptom2;

    @androidx.annotation.NonNull
    public final android.widget.RadioButton vSymptom3;

    @androidx.annotation.NonNull
    public final android.widget.RadioButton vSymptom4;

    public ViewAlleryFeedbackBinding(@androidx.annotation.NonNull android.widget.FrameLayout frameLayout, @androidx.annotation.NonNull android.widget.RelativeLayout relativeLayout, @androidx.annotation.NonNull android.widget.RadioGroup radioGroup, @androidx.annotation.NonNull android.widget.TextView textView, @androidx.annotation.NonNull android.widget.TextView textView2, @androidx.annotation.NonNull android.widget.TextView textView3, @androidx.annotation.NonNull android.widget.TextView textView4, @androidx.annotation.NonNull android.widget.RadioButton radioButton, @androidx.annotation.NonNull android.widget.RadioButton radioButton2, @androidx.annotation.NonNull android.widget.RadioButton radioButton3, @androidx.annotation.NonNull android.widget.RadioButton radioButton4) {
        this.n = frameLayout;
        this.loadingView = relativeLayout;
        this.symptomGroup = radioGroup;
        this.tvAllergyDescText = textView;
        this.tvAllergySource = textView2;
        this.tvAllergySourceTitle = textView3;
        this.tvGotoReport = textView4;
        this.vSymptom1 = radioButton;
        this.vSymptom2 = radioButton2;
        this.vSymptom3 = radioButton3;
        this.vSymptom4 = radioButton4;
    }

    @androidx.annotation.NonNull
    public static pad.aqi.cnemc.com.mjallergymodule.databinding.ViewAlleryFeedbackBinding bind(@androidx.annotation.NonNull android.view.View view) {
        int i = pad.aqi.cnemc.com.mjallergymodule.R.id.loading_view;
        android.widget.RelativeLayout relativeLayout = (android.widget.RelativeLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (relativeLayout != null) {
            i = pad.aqi.cnemc.com.mjallergymodule.R.id.symptom_group;
            android.widget.RadioGroup radioGroup = (android.widget.RadioGroup) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (radioGroup != null) {
                i = pad.aqi.cnemc.com.mjallergymodule.R.id.tv_allergy_desc_text;
                android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = pad.aqi.cnemc.com.mjallergymodule.R.id.tv_allergy_source;
                    android.widget.TextView textView2 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        i = pad.aqi.cnemc.com.mjallergymodule.R.id.tv_allergy_source_title;
                        android.widget.TextView textView3 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                        if (textView3 != null) {
                            i = pad.aqi.cnemc.com.mjallergymodule.R.id.tv_goto_report;
                            android.widget.TextView textView4 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                            if (textView4 != null) {
                                i = pad.aqi.cnemc.com.mjallergymodule.R.id.v_symptom_1;
                                android.widget.RadioButton radioButton = (android.widget.RadioButton) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                if (radioButton != null) {
                                    i = pad.aqi.cnemc.com.mjallergymodule.R.id.v_symptom_2;
                                    android.widget.RadioButton radioButton2 = (android.widget.RadioButton) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                    if (radioButton2 != null) {
                                        i = pad.aqi.cnemc.com.mjallergymodule.R.id.v_symptom_3;
                                        android.widget.RadioButton radioButton3 = (android.widget.RadioButton) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                        if (radioButton3 != null) {
                                            i = pad.aqi.cnemc.com.mjallergymodule.R.id.v_symptom_4;
                                            android.widget.RadioButton radioButton4 = (android.widget.RadioButton) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                            if (radioButton4 != null) {
                                                return new pad.aqi.cnemc.com.mjallergymodule.databinding.ViewAlleryFeedbackBinding((android.widget.FrameLayout) view, relativeLayout, radioGroup, textView, textView2, textView3, textView4, radioButton, radioButton2, radioButton3, radioButton4);
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
    public static pad.aqi.cnemc.com.mjallergymodule.databinding.ViewAlleryFeedbackBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static pad.aqi.cnemc.com.mjallergymodule.databinding.ViewAlleryFeedbackBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(pad.aqi.cnemc.com.mjallergymodule.R.layout.view_allery_feedback, viewGroup, false);
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
