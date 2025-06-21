package moji.com.mjweatherservicebase.databinding;

/* loaded from: classes20.dex */
public final class FlowersDetailLiveVerticalViewBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final com.moji.recyclerview.NearMomentRecyclerView detailVerticalRecyclerView;

    @androidx.annotation.NonNull
    public final com.moji.recyclerview.NearMomentRecyclerView n;

    public FlowersDetailLiveVerticalViewBinding(@androidx.annotation.NonNull com.moji.recyclerview.NearMomentRecyclerView nearMomentRecyclerView, @androidx.annotation.NonNull com.moji.recyclerview.NearMomentRecyclerView nearMomentRecyclerView2) {
        this.n = nearMomentRecyclerView;
        this.detailVerticalRecyclerView = nearMomentRecyclerView2;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweatherservicebase.databinding.FlowersDetailLiveVerticalViewBinding bind(@androidx.annotation.NonNull android.view.View view) {
        if (view == null) {
            throw new java.lang.NullPointerException("rootView");
        }
        com.moji.recyclerview.NearMomentRecyclerView nearMomentRecyclerView = (com.moji.recyclerview.NearMomentRecyclerView) view;
        return new moji.com.mjweatherservicebase.databinding.FlowersDetailLiveVerticalViewBinding(nearMomentRecyclerView, nearMomentRecyclerView);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweatherservicebase.databinding.FlowersDetailLiveVerticalViewBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweatherservicebase.databinding.FlowersDetailLiveVerticalViewBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweatherservicebase.R.layout.flowers_detail_live_vertical_view, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @androidx.annotation.NonNull
    public com.moji.recyclerview.NearMomentRecyclerView getRoot() {
        return this.n;
    }
}
