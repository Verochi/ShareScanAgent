package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class ItemDailyDetail360ControlBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final com.moji.mjweather.dailydetails.view.Hour360ScrollControl hour360ScrollControl;

    @androidx.annotation.NonNull
    public final com.moji.mjweather.dailydetails.view.Hour360ScrollControl n;

    public ItemDailyDetail360ControlBinding(@androidx.annotation.NonNull com.moji.mjweather.dailydetails.view.Hour360ScrollControl hour360ScrollControl, @androidx.annotation.NonNull com.moji.mjweather.dailydetails.view.Hour360ScrollControl hour360ScrollControl2) {
        this.n = hour360ScrollControl;
        this.hour360ScrollControl = hour360ScrollControl2;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ItemDailyDetail360ControlBinding bind(@androidx.annotation.NonNull android.view.View view) {
        if (view == null) {
            throw new java.lang.NullPointerException("rootView");
        }
        com.moji.mjweather.dailydetails.view.Hour360ScrollControl hour360ScrollControl = (com.moji.mjweather.dailydetails.view.Hour360ScrollControl) view;
        return new moji.com.mjweather.databinding.ItemDailyDetail360ControlBinding(hour360ScrollControl, hour360ScrollControl);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ItemDailyDetail360ControlBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ItemDailyDetail360ControlBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.item_daily_detail_360_control, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @androidx.annotation.NonNull
    public com.moji.mjweather.dailydetails.view.Hour360ScrollControl getRoot() {
        return this.n;
    }
}
