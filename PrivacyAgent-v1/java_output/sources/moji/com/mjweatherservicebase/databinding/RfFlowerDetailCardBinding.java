package moji.com.mjweatherservicebase.databinding;

/* loaded from: classes20.dex */
public final class RfFlowerDetailCardBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.TextView btnHint;

    @androidx.annotation.NonNull
    public final android.view.View cardLine;

    @androidx.annotation.NonNull
    public final android.widget.TextView flowersDate1;

    @androidx.annotation.NonNull
    public final android.widget.TextView flowersDate2;

    @androidx.annotation.NonNull
    public final android.widget.TextView flowersDate3;

    @androidx.annotation.NonNull
    public final android.widget.ImageView flowersIcon;

    @androidx.annotation.NonNull
    public final moji.com.mjweatherservicebase.view.ShadowLayout n;

    @androidx.annotation.NonNull
    public final android.widget.TextView sakuraCurrentStat;

    @androidx.annotation.NonNull
    public final android.widget.TextView sakuraDetailBestDate;

    @androidx.annotation.NonNull
    public final android.widget.TextView sakuraDetailBlossomDate;

    @androidx.annotation.NonNull
    public final android.widget.TextView sakuraDetailBlossomFailDate;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout sakuraDetailStatus;

    @androidx.annotation.NonNull
    public final android.widget.TextView saturaDetailSubcribe;

    @androidx.annotation.NonNull
    public final moji.com.mjweatherservicebase.view.ShadowLayout shadowLay;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout statusDetailStateDate;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout statusDetailStateTime;

    public RfFlowerDetailCardBinding(@androidx.annotation.NonNull moji.com.mjweatherservicebase.view.ShadowLayout shadowLayout, @androidx.annotation.NonNull android.widget.TextView textView, @androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull android.widget.TextView textView2, @androidx.annotation.NonNull android.widget.TextView textView3, @androidx.annotation.NonNull android.widget.TextView textView4, @androidx.annotation.NonNull android.widget.ImageView imageView, @androidx.annotation.NonNull android.widget.TextView textView5, @androidx.annotation.NonNull android.widget.TextView textView6, @androidx.annotation.NonNull android.widget.TextView textView7, @androidx.annotation.NonNull android.widget.TextView textView8, @androidx.annotation.NonNull android.widget.LinearLayout linearLayout, @androidx.annotation.NonNull android.widget.TextView textView9, @androidx.annotation.NonNull moji.com.mjweatherservicebase.view.ShadowLayout shadowLayout2, @androidx.annotation.NonNull android.widget.LinearLayout linearLayout2, @androidx.annotation.NonNull android.widget.LinearLayout linearLayout3) {
        this.n = shadowLayout;
        this.btnHint = textView;
        this.cardLine = view;
        this.flowersDate1 = textView2;
        this.flowersDate2 = textView3;
        this.flowersDate3 = textView4;
        this.flowersIcon = imageView;
        this.sakuraCurrentStat = textView5;
        this.sakuraDetailBestDate = textView6;
        this.sakuraDetailBlossomDate = textView7;
        this.sakuraDetailBlossomFailDate = textView8;
        this.sakuraDetailStatus = linearLayout;
        this.saturaDetailSubcribe = textView9;
        this.shadowLay = shadowLayout2;
        this.statusDetailStateDate = linearLayout2;
        this.statusDetailStateTime = linearLayout3;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweatherservicebase.databinding.RfFlowerDetailCardBinding bind(@androidx.annotation.NonNull android.view.View view) {
        android.view.View findChildViewById;
        int i = moji.com.mjweatherservicebase.R.id.btn_hint;
        android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (textView != null && (findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweatherservicebase.R.id.card_line))) != null) {
            i = moji.com.mjweatherservicebase.R.id.flowers_date_1;
            android.widget.TextView textView2 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (textView2 != null) {
                i = moji.com.mjweatherservicebase.R.id.flowers_date_2;
                android.widget.TextView textView3 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (textView3 != null) {
                    i = moji.com.mjweatherservicebase.R.id.flowers_date_3;
                    android.widget.TextView textView4 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                    if (textView4 != null) {
                        i = moji.com.mjweatherservicebase.R.id.flowers_icon;
                        android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                        if (imageView != null) {
                            i = moji.com.mjweatherservicebase.R.id.sakura_current_stat;
                            android.widget.TextView textView5 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                            if (textView5 != null) {
                                i = moji.com.mjweatherservicebase.R.id.sakura_detail_best_date;
                                android.widget.TextView textView6 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                if (textView6 != null) {
                                    i = moji.com.mjweatherservicebase.R.id.sakura_detail_blossom_date;
                                    android.widget.TextView textView7 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                    if (textView7 != null) {
                                        i = moji.com.mjweatherservicebase.R.id.sakura_detail_blossom_fail_date;
                                        android.widget.TextView textView8 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                        if (textView8 != null) {
                                            i = moji.com.mjweatherservicebase.R.id.sakura_detail_status;
                                            android.widget.LinearLayout linearLayout = (android.widget.LinearLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                            if (linearLayout != null) {
                                                i = moji.com.mjweatherservicebase.R.id.satura_detail_subcribe;
                                                android.widget.TextView textView9 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                                if (textView9 != null) {
                                                    moji.com.mjweatherservicebase.view.ShadowLayout shadowLayout = (moji.com.mjweatherservicebase.view.ShadowLayout) view;
                                                    i = moji.com.mjweatherservicebase.R.id.status_detail_state_date;
                                                    android.widget.LinearLayout linearLayout2 = (android.widget.LinearLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                                    if (linearLayout2 != null) {
                                                        i = moji.com.mjweatherservicebase.R.id.status_detail_state_time;
                                                        android.widget.LinearLayout linearLayout3 = (android.widget.LinearLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                                        if (linearLayout3 != null) {
                                                            return new moji.com.mjweatherservicebase.databinding.RfFlowerDetailCardBinding(shadowLayout, textView, findChildViewById, textView2, textView3, textView4, imageView, textView5, textView6, textView7, textView8, linearLayout, textView9, shadowLayout, linearLayout2, linearLayout3);
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
    public static moji.com.mjweatherservicebase.databinding.RfFlowerDetailCardBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweatherservicebase.databinding.RfFlowerDetailCardBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweatherservicebase.R.layout.rf_flower_detail_card, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @androidx.annotation.NonNull
    public moji.com.mjweatherservicebase.view.ShadowLayout getRoot() {
        return this.n;
    }
}
