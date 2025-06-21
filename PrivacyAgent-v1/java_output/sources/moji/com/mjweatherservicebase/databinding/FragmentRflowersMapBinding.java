package moji.com.mjweatherservicebase.databinding;

/* loaded from: classes20.dex */
public final class FragmentRflowersMapBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.TextView checkOutSpot;

    @androidx.annotation.NonNull
    public final android.widget.TextView countrySpot;

    @androidx.annotation.NonNull
    public final moji.com.mjweatherservicebase.view.FlowersMapView flowersMap;

    @androidx.annotation.NonNull
    public final android.widget.ImageView ivMyLocation;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout llRedLeavesSceneMapTip;

    @androidx.annotation.NonNull
    public final android.view.View mapMask;

    @androidx.annotation.NonNull
    public final android.widget.ImageView mapSymbolIcon;

    @androidx.annotation.NonNull
    public final android.widget.FrameLayout n;

    public FragmentRflowersMapBinding(@androidx.annotation.NonNull android.widget.FrameLayout frameLayout, @androidx.annotation.NonNull android.widget.TextView textView, @androidx.annotation.NonNull android.widget.TextView textView2, @androidx.annotation.NonNull moji.com.mjweatherservicebase.view.FlowersMapView flowersMapView, @androidx.annotation.NonNull android.widget.ImageView imageView, @androidx.annotation.NonNull android.widget.LinearLayout linearLayout, @androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull android.widget.ImageView imageView2) {
        this.n = frameLayout;
        this.checkOutSpot = textView;
        this.countrySpot = textView2;
        this.flowersMap = flowersMapView;
        this.ivMyLocation = imageView;
        this.llRedLeavesSceneMapTip = linearLayout;
        this.mapMask = view;
        this.mapSymbolIcon = imageView2;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweatherservicebase.databinding.FragmentRflowersMapBinding bind(@androidx.annotation.NonNull android.view.View view) {
        android.view.View findChildViewById;
        int i = moji.com.mjweatherservicebase.R.id.check_out_spot;
        android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = moji.com.mjweatherservicebase.R.id.country_spot;
            android.widget.TextView textView2 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (textView2 != null) {
                i = moji.com.mjweatherservicebase.R.id.flowers_map;
                moji.com.mjweatherservicebase.view.FlowersMapView flowersMapView = (moji.com.mjweatherservicebase.view.FlowersMapView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (flowersMapView != null) {
                    i = moji.com.mjweatherservicebase.R.id.iv_my_location;
                    android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                    if (imageView != null) {
                        i = moji.com.mjweatherservicebase.R.id.ll_red_leaves_scene_map_tip;
                        android.widget.LinearLayout linearLayout = (android.widget.LinearLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                        if (linearLayout != null && (findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweatherservicebase.R.id.map_mask))) != null) {
                            i = moji.com.mjweatherservicebase.R.id.map_symbol_icon;
                            android.widget.ImageView imageView2 = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                            if (imageView2 != null) {
                                return new moji.com.mjweatherservicebase.databinding.FragmentRflowersMapBinding((android.widget.FrameLayout) view, textView, textView2, flowersMapView, imageView, linearLayout, findChildViewById, imageView2);
                            }
                        }
                    }
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweatherservicebase.databinding.FragmentRflowersMapBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweatherservicebase.databinding.FragmentRflowersMapBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweatherservicebase.R.layout.fragment_rflowers_map, viewGroup, false);
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
