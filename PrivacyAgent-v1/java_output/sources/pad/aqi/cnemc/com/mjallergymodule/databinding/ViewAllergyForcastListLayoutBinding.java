package pad.aqi.cnemc.com.mjallergymodule.databinding;

/* loaded from: classes21.dex */
public final class ViewAllergyForcastListLayoutBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout allergyOpenVipLayout;

    @androidx.annotation.NonNull
    public final android.widget.TextView allergyOpenvipButton;

    @androidx.annotation.NonNull
    public final android.widget.TextView allergyOpenvipText;

    @androidx.annotation.NonNull
    public final androidx.constraintlayout.widget.ConstraintLayout fl24Hour;

    @androidx.annotation.NonNull
    public final android.widget.FrameLayout flFiveDay;

    @androidx.annotation.NonNull
    public final androidx.recyclerview.widget.RecyclerView forcastListView;

    @androidx.annotation.NonNull
    public final android.widget.ImageView ivEmptyIcon;

    @androidx.annotation.NonNull
    public final android.widget.ImageView ivVipFire;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout llEmpty;

    @androidx.annotation.NonNull
    public final androidx.constraintlayout.widget.ConstraintLayout n;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvAlleryDesc;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvAlleryLevel;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvAllerySource;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvAllerySourceTitle;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvEmptyText;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvHourText;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvWeekText;

    @androidx.annotation.NonNull
    public final android.view.View vHourIndicator;

    @androidx.annotation.NonNull
    public final android.view.View vWeekIndicator;

    public ViewAllergyForcastListLayoutBinding(@androidx.annotation.NonNull androidx.constraintlayout.widget.ConstraintLayout constraintLayout, @androidx.annotation.NonNull android.widget.LinearLayout linearLayout, @androidx.annotation.NonNull android.widget.TextView textView, @androidx.annotation.NonNull android.widget.TextView textView2, @androidx.annotation.NonNull androidx.constraintlayout.widget.ConstraintLayout constraintLayout2, @androidx.annotation.NonNull android.widget.FrameLayout frameLayout, @androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView recyclerView, @androidx.annotation.NonNull android.widget.ImageView imageView, @androidx.annotation.NonNull android.widget.ImageView imageView2, @androidx.annotation.NonNull android.widget.LinearLayout linearLayout2, @androidx.annotation.NonNull android.widget.TextView textView3, @androidx.annotation.NonNull android.widget.TextView textView4, @androidx.annotation.NonNull android.widget.TextView textView5, @androidx.annotation.NonNull android.widget.TextView textView6, @androidx.annotation.NonNull android.widget.TextView textView7, @androidx.annotation.NonNull android.widget.TextView textView8, @androidx.annotation.NonNull android.widget.TextView textView9, @androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull android.view.View view2) {
        this.n = constraintLayout;
        this.allergyOpenVipLayout = linearLayout;
        this.allergyOpenvipButton = textView;
        this.allergyOpenvipText = textView2;
        this.fl24Hour = constraintLayout2;
        this.flFiveDay = frameLayout;
        this.forcastListView = recyclerView;
        this.ivEmptyIcon = imageView;
        this.ivVipFire = imageView2;
        this.llEmpty = linearLayout2;
        this.tvAlleryDesc = textView3;
        this.tvAlleryLevel = textView4;
        this.tvAllerySource = textView5;
        this.tvAllerySourceTitle = textView6;
        this.tvEmptyText = textView7;
        this.tvHourText = textView8;
        this.tvWeekText = textView9;
        this.vHourIndicator = view;
        this.vWeekIndicator = view2;
    }

    @androidx.annotation.NonNull
    public static pad.aqi.cnemc.com.mjallergymodule.databinding.ViewAllergyForcastListLayoutBinding bind(@androidx.annotation.NonNull android.view.View view) {
        android.view.View findChildViewById;
        android.view.View findChildViewById2;
        int i = pad.aqi.cnemc.com.mjallergymodule.R.id.allergy_open_vip_layout;
        android.widget.LinearLayout linearLayout = (android.widget.LinearLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (linearLayout != null) {
            i = pad.aqi.cnemc.com.mjallergymodule.R.id.allergy_openvip_button;
            android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = pad.aqi.cnemc.com.mjallergymodule.R.id.allergy_openvip_text;
                android.widget.TextView textView2 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (textView2 != null) {
                    i = pad.aqi.cnemc.com.mjallergymodule.R.id.fl_24_hour;
                    androidx.constraintlayout.widget.ConstraintLayout constraintLayout = (androidx.constraintlayout.widget.ConstraintLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                    if (constraintLayout != null) {
                        i = pad.aqi.cnemc.com.mjallergymodule.R.id.fl_five_day;
                        android.widget.FrameLayout frameLayout = (android.widget.FrameLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                        if (frameLayout != null) {
                            i = pad.aqi.cnemc.com.mjallergymodule.R.id.forcast_listView;
                            androidx.recyclerview.widget.RecyclerView recyclerView = (androidx.recyclerview.widget.RecyclerView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                            if (recyclerView != null) {
                                i = pad.aqi.cnemc.com.mjallergymodule.R.id.iv_empty_icon;
                                android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                if (imageView != null) {
                                    i = pad.aqi.cnemc.com.mjallergymodule.R.id.iv_vip_fire;
                                    android.widget.ImageView imageView2 = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                    if (imageView2 != null) {
                                        i = pad.aqi.cnemc.com.mjallergymodule.R.id.ll_empty;
                                        android.widget.LinearLayout linearLayout2 = (android.widget.LinearLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                        if (linearLayout2 != null) {
                                            i = pad.aqi.cnemc.com.mjallergymodule.R.id.tv_allery_desc;
                                            android.widget.TextView textView3 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                            if (textView3 != null) {
                                                i = pad.aqi.cnemc.com.mjallergymodule.R.id.tv_allery_level;
                                                android.widget.TextView textView4 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                                if (textView4 != null) {
                                                    i = pad.aqi.cnemc.com.mjallergymodule.R.id.tv_allery_source;
                                                    android.widget.TextView textView5 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                                    if (textView5 != null) {
                                                        i = pad.aqi.cnemc.com.mjallergymodule.R.id.tv_allery_source_title;
                                                        android.widget.TextView textView6 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                                        if (textView6 != null) {
                                                            i = pad.aqi.cnemc.com.mjallergymodule.R.id.tv_empty_text;
                                                            android.widget.TextView textView7 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                                            if (textView7 != null) {
                                                                i = pad.aqi.cnemc.com.mjallergymodule.R.id.tv_hour_text;
                                                                android.widget.TextView textView8 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                                                if (textView8 != null) {
                                                                    i = pad.aqi.cnemc.com.mjallergymodule.R.id.tv_week_text;
                                                                    android.widget.TextView textView9 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                                                    if (textView9 != null && (findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = pad.aqi.cnemc.com.mjallergymodule.R.id.v_hour_indicator))) != null && (findChildViewById2 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = pad.aqi.cnemc.com.mjallergymodule.R.id.v_week_indicator))) != null) {
                                                                        return new pad.aqi.cnemc.com.mjallergymodule.databinding.ViewAllergyForcastListLayoutBinding((androidx.constraintlayout.widget.ConstraintLayout) view, linearLayout, textView, textView2, constraintLayout, frameLayout, recyclerView, imageView, imageView2, linearLayout2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, findChildViewById, findChildViewById2);
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
    public static pad.aqi.cnemc.com.mjallergymodule.databinding.ViewAllergyForcastListLayoutBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static pad.aqi.cnemc.com.mjallergymodule.databinding.ViewAllergyForcastListLayoutBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(pad.aqi.cnemc.com.mjallergymodule.R.layout.view_allergy_forcast_list_layout, viewGroup, false);
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
