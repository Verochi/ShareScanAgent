package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class FragmentAvatarShopMoBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.GridView gvVoiceShop;

    @androidx.annotation.NonNull
    public final com.moji.multiplestatuslayout.MJMultipleStatusLayout mslAvatarShop;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout n;

    @androidx.annotation.NonNull
    public final com.moji.pulltorefresh.PullToFreshContainer ptfcVoiceShop;

    public FragmentAvatarShopMoBinding(@androidx.annotation.NonNull android.widget.LinearLayout linearLayout, @androidx.annotation.NonNull android.widget.GridView gridView, @androidx.annotation.NonNull com.moji.multiplestatuslayout.MJMultipleStatusLayout mJMultipleStatusLayout, @androidx.annotation.NonNull com.moji.pulltorefresh.PullToFreshContainer pullToFreshContainer) {
        this.n = linearLayout;
        this.gvVoiceShop = gridView;
        this.mslAvatarShop = mJMultipleStatusLayout;
        this.ptfcVoiceShop = pullToFreshContainer;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.FragmentAvatarShopMoBinding bind(@androidx.annotation.NonNull android.view.View view) {
        com.moji.multiplestatuslayout.MJMultipleStatusLayout findChildViewById;
        com.moji.pulltorefresh.PullToFreshContainer findChildViewById2;
        int i = moji.com.mjweather.R.id.gv_voice_shop;
        android.widget.GridView gridView = (android.widget.GridView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (gridView == null || (findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.msl_avatar_shop))) == null || (findChildViewById2 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.ptfc_voice_shop))) == null) {
            throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new moji.com.mjweather.databinding.FragmentAvatarShopMoBinding((android.widget.LinearLayout) view, gridView, findChildViewById, findChildViewById2);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.FragmentAvatarShopMoBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.FragmentAvatarShopMoBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.fragment_avatar_shop_mo, viewGroup, false);
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
