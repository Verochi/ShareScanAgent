package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class WeatherPageSkeletonBottomViewBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final com.moji.multiplestatuslayout.SkeletonItemView item1;

    @androidx.annotation.NonNull
    public final com.moji.multiplestatuslayout.SkeletonItemView item2;

    @androidx.annotation.NonNull
    public final com.moji.multiplestatuslayout.SkeletonItemView item3;

    @androidx.annotation.NonNull
    public final com.moji.multiplestatuslayout.SkeletonItemView item4;

    @androidx.annotation.NonNull
    public final com.moji.multiplestatuslayout.SkeletonItemView item5;

    @androidx.annotation.NonNull
    public final com.moji.multiplestatuslayout.SkeletonItemView item6;

    @androidx.annotation.NonNull
    public final androidx.constraintlayout.widget.ConstraintLayout n;

    @androidx.annotation.NonNull
    public final android.view.View spaceView;

    public WeatherPageSkeletonBottomViewBinding(@androidx.annotation.NonNull androidx.constraintlayout.widget.ConstraintLayout constraintLayout, @androidx.annotation.NonNull com.moji.multiplestatuslayout.SkeletonItemView skeletonItemView, @androidx.annotation.NonNull com.moji.multiplestatuslayout.SkeletonItemView skeletonItemView2, @androidx.annotation.NonNull com.moji.multiplestatuslayout.SkeletonItemView skeletonItemView3, @androidx.annotation.NonNull com.moji.multiplestatuslayout.SkeletonItemView skeletonItemView4, @androidx.annotation.NonNull com.moji.multiplestatuslayout.SkeletonItemView skeletonItemView5, @androidx.annotation.NonNull com.moji.multiplestatuslayout.SkeletonItemView skeletonItemView6, @androidx.annotation.NonNull android.view.View view) {
        this.n = constraintLayout;
        this.item1 = skeletonItemView;
        this.item2 = skeletonItemView2;
        this.item3 = skeletonItemView3;
        this.item4 = skeletonItemView4;
        this.item5 = skeletonItemView5;
        this.item6 = skeletonItemView6;
        this.spaceView = view;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.WeatherPageSkeletonBottomViewBinding bind(@androidx.annotation.NonNull android.view.View view) {
        com.moji.multiplestatuslayout.SkeletonItemView findChildViewById;
        com.moji.multiplestatuslayout.SkeletonItemView findChildViewById2;
        com.moji.multiplestatuslayout.SkeletonItemView findChildViewById3;
        com.moji.multiplestatuslayout.SkeletonItemView findChildViewById4;
        com.moji.multiplestatuslayout.SkeletonItemView findChildViewById5;
        android.view.View findChildViewById6;
        int i = moji.com.mjweather.R.id.item1;
        com.moji.multiplestatuslayout.SkeletonItemView findChildViewById7 = androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (findChildViewById7 == null || (findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.item2))) == null || (findChildViewById2 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.item3))) == null || (findChildViewById3 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.item4))) == null || (findChildViewById4 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.item5))) == null || (findChildViewById5 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.item6))) == null || (findChildViewById6 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.spaceView))) == null) {
            throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new moji.com.mjweather.databinding.WeatherPageSkeletonBottomViewBinding((androidx.constraintlayout.widget.ConstraintLayout) view, findChildViewById7, findChildViewById, findChildViewById2, findChildViewById3, findChildViewById4, findChildViewById5, findChildViewById6);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.WeatherPageSkeletonBottomViewBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.WeatherPageSkeletonBottomViewBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.weather_page_skeleton_bottom_view, viewGroup, false);
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
