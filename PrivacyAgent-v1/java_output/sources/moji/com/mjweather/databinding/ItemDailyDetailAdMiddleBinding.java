package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class ItemDailyDetailAdMiddleBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.RelativeLayout adContainer;

    @androidx.annotation.NonNull
    public final android.widget.RelativeLayout n;

    public ItemDailyDetailAdMiddleBinding(@androidx.annotation.NonNull android.widget.RelativeLayout relativeLayout, @androidx.annotation.NonNull android.widget.RelativeLayout relativeLayout2) {
        this.n = relativeLayout;
        this.adContainer = relativeLayout2;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ItemDailyDetailAdMiddleBinding bind(@androidx.annotation.NonNull android.view.View view) {
        if (view == null) {
            throw new java.lang.NullPointerException("rootView");
        }
        android.widget.RelativeLayout relativeLayout = (android.widget.RelativeLayout) view;
        return new moji.com.mjweather.databinding.ItemDailyDetailAdMiddleBinding(relativeLayout, relativeLayout);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ItemDailyDetailAdMiddleBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ItemDailyDetailAdMiddleBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.item_daily_detail_ad_middle, viewGroup, false);
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
