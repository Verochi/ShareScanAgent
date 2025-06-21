package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class FragmentDailyDetailBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final com.moji.multiplestatuslayout.MJMultipleStatusLayout n;

    @androidx.annotation.NonNull
    public final androidx.recyclerview.widget.RecyclerView recyclerView;

    @androidx.annotation.NonNull
    public final com.moji.multiplestatuslayout.MJMultipleStatusLayout statusLayout;

    public FragmentDailyDetailBinding(@androidx.annotation.NonNull com.moji.multiplestatuslayout.MJMultipleStatusLayout mJMultipleStatusLayout, @androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView recyclerView, @androidx.annotation.NonNull com.moji.multiplestatuslayout.MJMultipleStatusLayout mJMultipleStatusLayout2) {
        this.n = mJMultipleStatusLayout;
        this.recyclerView = recyclerView;
        this.statusLayout = mJMultipleStatusLayout2;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.FragmentDailyDetailBinding bind(@androidx.annotation.NonNull android.view.View view) {
        int i = moji.com.mjweather.R.id.recycler_view;
        androidx.recyclerview.widget.RecyclerView recyclerView = (androidx.recyclerview.widget.RecyclerView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (recyclerView == null) {
            throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        com.moji.multiplestatuslayout.MJMultipleStatusLayout mJMultipleStatusLayout = (com.moji.multiplestatuslayout.MJMultipleStatusLayout) view;
        return new moji.com.mjweather.databinding.FragmentDailyDetailBinding(mJMultipleStatusLayout, recyclerView, mJMultipleStatusLayout);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.FragmentDailyDetailBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.FragmentDailyDetailBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.fragment_daily_detail, viewGroup, false);
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
