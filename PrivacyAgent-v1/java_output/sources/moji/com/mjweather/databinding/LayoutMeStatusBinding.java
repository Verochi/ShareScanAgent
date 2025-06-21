package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class LayoutMeStatusBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final com.moji.multiplestatuslayout.MJMultipleStatusLayout meStatus;

    @androidx.annotation.NonNull
    public final com.moji.multiplestatuslayout.MJMultipleStatusLayout n;

    public LayoutMeStatusBinding(@androidx.annotation.NonNull com.moji.multiplestatuslayout.MJMultipleStatusLayout mJMultipleStatusLayout, @androidx.annotation.NonNull com.moji.multiplestatuslayout.MJMultipleStatusLayout mJMultipleStatusLayout2) {
        this.n = mJMultipleStatusLayout;
        this.meStatus = mJMultipleStatusLayout2;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.LayoutMeStatusBinding bind(@androidx.annotation.NonNull android.view.View view) {
        if (view == null) {
            throw new java.lang.NullPointerException("rootView");
        }
        com.moji.multiplestatuslayout.MJMultipleStatusLayout mJMultipleStatusLayout = (com.moji.multiplestatuslayout.MJMultipleStatusLayout) view;
        return new moji.com.mjweather.databinding.LayoutMeStatusBinding(mJMultipleStatusLayout, mJMultipleStatusLayout);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.LayoutMeStatusBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.LayoutMeStatusBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.layout_me_status, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @androidx.annotation.NonNull
    public com.moji.multiplestatuslayout.MJMultipleStatusLayout getRoot() {
        return this.n;
    }
}
