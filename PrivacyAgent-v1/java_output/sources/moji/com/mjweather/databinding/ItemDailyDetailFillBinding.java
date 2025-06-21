package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class ItemDailyDetailFillBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final com.moji.mjweather.dailydetails.view.FillHelperView n;

    public ItemDailyDetailFillBinding(@androidx.annotation.NonNull com.moji.mjweather.dailydetails.view.FillHelperView fillHelperView) {
        this.n = fillHelperView;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ItemDailyDetailFillBinding bind(@androidx.annotation.NonNull android.view.View view) {
        if (view != null) {
            return new moji.com.mjweather.databinding.ItemDailyDetailFillBinding((com.moji.mjweather.dailydetails.view.FillHelperView) view);
        }
        throw new java.lang.NullPointerException("rootView");
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ItemDailyDetailFillBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ItemDailyDetailFillBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.item_daily_detail_fill, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @androidx.annotation.NonNull
    public com.moji.mjweather.dailydetails.view.FillHelperView getRoot() {
        return this.n;
    }
}
