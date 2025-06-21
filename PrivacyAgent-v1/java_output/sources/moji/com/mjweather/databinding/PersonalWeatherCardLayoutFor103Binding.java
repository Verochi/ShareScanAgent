package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class PersonalWeatherCardLayoutFor103Binding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final androidx.constraintlayout.widget.ConstraintLayout indexRoot;

    @androidx.annotation.NonNull
    public final android.widget.TextView moreBg;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout n;

    @androidx.annotation.NonNull
    public final androidx.recyclerview.widget.RecyclerView personalRecycle;

    @androidx.annotation.NonNull
    public final com.moji.HorizontalMoreLayout vMoreLayout;

    @androidx.annotation.NonNull
    public final android.view.View vVerticalShadow;

    @androidx.annotation.NonNull
    public final android.widget.ImageView weatherLifeMore;

    public PersonalWeatherCardLayoutFor103Binding(@androidx.annotation.NonNull android.widget.LinearLayout linearLayout, @androidx.annotation.NonNull androidx.constraintlayout.widget.ConstraintLayout constraintLayout, @androidx.annotation.NonNull android.widget.TextView textView, @androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView recyclerView, @androidx.annotation.NonNull com.moji.HorizontalMoreLayout horizontalMoreLayout, @androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull android.widget.ImageView imageView) {
        this.n = linearLayout;
        this.indexRoot = constraintLayout;
        this.moreBg = textView;
        this.personalRecycle = recyclerView;
        this.vMoreLayout = horizontalMoreLayout;
        this.vVerticalShadow = view;
        this.weatherLifeMore = imageView;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.PersonalWeatherCardLayoutFor103Binding bind(@androidx.annotation.NonNull android.view.View view) {
        com.moji.HorizontalMoreLayout findChildViewById;
        android.view.View findChildViewById2;
        int i = moji.com.mjweather.R.id.index_root;
        androidx.constraintlayout.widget.ConstraintLayout constraintLayout = (androidx.constraintlayout.widget.ConstraintLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (constraintLayout != null) {
            i = moji.com.mjweather.R.id.more_bg;
            android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = moji.com.mjweather.R.id.personalRecycle;
                androidx.recyclerview.widget.RecyclerView recyclerView = (androidx.recyclerview.widget.RecyclerView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (recyclerView != null && (findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.v_more_layout))) != null && (findChildViewById2 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.v_vertical_shadow))) != null) {
                    i = moji.com.mjweather.R.id.weather_life_more;
                    android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                    if (imageView != null) {
                        return new moji.com.mjweather.databinding.PersonalWeatherCardLayoutFor103Binding((android.widget.LinearLayout) view, constraintLayout, textView, recyclerView, findChildViewById, findChildViewById2, imageView);
                    }
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.PersonalWeatherCardLayoutFor103Binding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.PersonalWeatherCardLayoutFor103Binding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.personal_weather_card_layout_for_10_3, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @androidx.annotation.NonNull
    public android.widget.LinearLayout getRoot() {
        return this.n;
    }
}
