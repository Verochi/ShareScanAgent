package pad.aqi.cnemc.com.mjallergymodule.databinding;

/* loaded from: classes21.dex */
public final class ViewAllergyMapBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final com.moji.imageview.RoundCornerImageView ivAllergyPic;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout llAllergyMapDetail;

    @androidx.annotation.NonNull
    public final android.widget.ImageButton llLocaion;

    @androidx.annotation.NonNull
    public final android.widget.ScrollView n;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout plantDistingBtn;

    @androidx.annotation.NonNull
    public final android.widget.ImageView shareMapImage;

    @androidx.annotation.NonNull
    public final android.widget.ScrollView slAllergy;

    @androidx.annotation.NonNull
    public final com.moji.CatchParentEventView spreadLayout;

    @androidx.annotation.NonNull
    public final com.amap.api.maps.TextureMapView spreadMap;

    @androidx.annotation.NonNull
    public final android.widget.ImageView trendImage;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvAllergyBrowserCount;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvAllergyDistance;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvAllergyPicCount;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvAllergyPraiseCount;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvAllergyTitleName;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvSpread;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvTitle;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvTrend;

    public ViewAllergyMapBinding(@androidx.annotation.NonNull android.widget.ScrollView scrollView, @androidx.annotation.NonNull com.moji.imageview.RoundCornerImageView roundCornerImageView, @androidx.annotation.NonNull android.widget.LinearLayout linearLayout, @androidx.annotation.NonNull android.widget.ImageButton imageButton, @androidx.annotation.NonNull android.widget.LinearLayout linearLayout2, @androidx.annotation.NonNull android.widget.ImageView imageView, @androidx.annotation.NonNull android.widget.ScrollView scrollView2, @androidx.annotation.NonNull com.moji.CatchParentEventView catchParentEventView, @androidx.annotation.NonNull com.amap.api.maps.TextureMapView textureMapView, @androidx.annotation.NonNull android.widget.ImageView imageView2, @androidx.annotation.NonNull android.widget.TextView textView, @androidx.annotation.NonNull android.widget.TextView textView2, @androidx.annotation.NonNull android.widget.TextView textView3, @androidx.annotation.NonNull android.widget.TextView textView4, @androidx.annotation.NonNull android.widget.TextView textView5, @androidx.annotation.NonNull android.widget.TextView textView6, @androidx.annotation.NonNull android.widget.TextView textView7, @androidx.annotation.NonNull android.widget.TextView textView8) {
        this.n = scrollView;
        this.ivAllergyPic = roundCornerImageView;
        this.llAllergyMapDetail = linearLayout;
        this.llLocaion = imageButton;
        this.plantDistingBtn = linearLayout2;
        this.shareMapImage = imageView;
        this.slAllergy = scrollView2;
        this.spreadLayout = catchParentEventView;
        this.spreadMap = textureMapView;
        this.trendImage = imageView2;
        this.tvAllergyBrowserCount = textView;
        this.tvAllergyDistance = textView2;
        this.tvAllergyPicCount = textView3;
        this.tvAllergyPraiseCount = textView4;
        this.tvAllergyTitleName = textView5;
        this.tvSpread = textView6;
        this.tvTitle = textView7;
        this.tvTrend = textView8;
    }

    @androidx.annotation.NonNull
    public static pad.aqi.cnemc.com.mjallergymodule.databinding.ViewAllergyMapBinding bind(@androidx.annotation.NonNull android.view.View view) {
        int i = pad.aqi.cnemc.com.mjallergymodule.R.id.iv_allergy_pic;
        com.moji.imageview.RoundCornerImageView findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (findChildViewById != null) {
            i = pad.aqi.cnemc.com.mjallergymodule.R.id.ll_allergy_map_detail;
            android.widget.LinearLayout linearLayout = (android.widget.LinearLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (linearLayout != null) {
                i = pad.aqi.cnemc.com.mjallergymodule.R.id.ll_locaion;
                android.widget.ImageButton imageButton = (android.widget.ImageButton) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (imageButton != null) {
                    i = pad.aqi.cnemc.com.mjallergymodule.R.id.plant_disting_btn;
                    android.widget.LinearLayout linearLayout2 = (android.widget.LinearLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                    if (linearLayout2 != null) {
                        i = pad.aqi.cnemc.com.mjallergymodule.R.id.share_map_image;
                        android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                        if (imageView != null) {
                            android.widget.ScrollView scrollView = (android.widget.ScrollView) view;
                            i = pad.aqi.cnemc.com.mjallergymodule.R.id.spread_layout;
                            com.moji.CatchParentEventView findChildViewById2 = androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                            if (findChildViewById2 != null) {
                                i = pad.aqi.cnemc.com.mjallergymodule.R.id.spread_map;
                                com.amap.api.maps.TextureMapView textureMapView = (com.amap.api.maps.TextureMapView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                if (textureMapView != null) {
                                    i = pad.aqi.cnemc.com.mjallergymodule.R.id.trend_image;
                                    android.widget.ImageView imageView2 = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                    if (imageView2 != null) {
                                        i = pad.aqi.cnemc.com.mjallergymodule.R.id.tv_allergy_browser_count;
                                        android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                        if (textView != null) {
                                            i = pad.aqi.cnemc.com.mjallergymodule.R.id.tv_allergy_distance;
                                            android.widget.TextView textView2 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                            if (textView2 != null) {
                                                i = pad.aqi.cnemc.com.mjallergymodule.R.id.tv_allergy_pic_count;
                                                android.widget.TextView textView3 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                                if (textView3 != null) {
                                                    i = pad.aqi.cnemc.com.mjallergymodule.R.id.tv_allergy_praise_count;
                                                    android.widget.TextView textView4 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                                    if (textView4 != null) {
                                                        i = pad.aqi.cnemc.com.mjallergymodule.R.id.tv_allergy_title_name;
                                                        android.widget.TextView textView5 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                                        if (textView5 != null) {
                                                            i = pad.aqi.cnemc.com.mjallergymodule.R.id.tv_spread;
                                                            android.widget.TextView textView6 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                                            if (textView6 != null) {
                                                                i = pad.aqi.cnemc.com.mjallergymodule.R.id.tv_title;
                                                                android.widget.TextView textView7 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                                                if (textView7 != null) {
                                                                    i = pad.aqi.cnemc.com.mjallergymodule.R.id.tv_trend;
                                                                    android.widget.TextView textView8 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                                                    if (textView8 != null) {
                                                                        return new pad.aqi.cnemc.com.mjallergymodule.databinding.ViewAllergyMapBinding(scrollView, findChildViewById, linearLayout, imageButton, linearLayout2, imageView, scrollView, findChildViewById2, textureMapView, imageView2, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8);
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
    public static pad.aqi.cnemc.com.mjallergymodule.databinding.ViewAllergyMapBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static pad.aqi.cnemc.com.mjallergymodule.databinding.ViewAllergyMapBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(pad.aqi.cnemc.com.mjallergymodule.R.layout.view_allergy_map, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @androidx.annotation.NonNull
    public android.widget.ScrollView getRoot() {
        return this.n;
    }
}
