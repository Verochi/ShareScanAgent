package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class FragmentAvatarShopStarBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout llLoadFail;

    @androidx.annotation.NonNull
    public final android.widget.ListView lvStar;

    @androidx.annotation.NonNull
    public final com.moji.multiplestatuslayout.MJMultipleStatusLayout mslAvatarShop;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout n;

    @androidx.annotation.NonNull
    public final com.moji.pulltorefresh.PullToFreshContainer ptfcAvatarStar;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvReload;

    public FragmentAvatarShopStarBinding(@androidx.annotation.NonNull android.widget.LinearLayout linearLayout, @androidx.annotation.NonNull android.widget.LinearLayout linearLayout2, @androidx.annotation.NonNull android.widget.ListView listView, @androidx.annotation.NonNull com.moji.multiplestatuslayout.MJMultipleStatusLayout mJMultipleStatusLayout, @androidx.annotation.NonNull com.moji.pulltorefresh.PullToFreshContainer pullToFreshContainer, @androidx.annotation.NonNull android.widget.TextView textView) {
        this.n = linearLayout;
        this.llLoadFail = linearLayout2;
        this.lvStar = listView;
        this.mslAvatarShop = mJMultipleStatusLayout;
        this.ptfcAvatarStar = pullToFreshContainer;
        this.tvReload = textView;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.FragmentAvatarShopStarBinding bind(@androidx.annotation.NonNull android.view.View view) {
        com.moji.multiplestatuslayout.MJMultipleStatusLayout findChildViewById;
        com.moji.pulltorefresh.PullToFreshContainer findChildViewById2;
        int i = moji.com.mjweather.R.id.ll_load_fail;
        android.widget.LinearLayout linearLayout = (android.widget.LinearLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (linearLayout != null) {
            i = moji.com.mjweather.R.id.lv_star;
            android.widget.ListView listView = (android.widget.ListView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (listView != null && (findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.msl_avatar_shop))) != null && (findChildViewById2 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.ptfc_avatar_star))) != null) {
                i = moji.com.mjweather.R.id.tv_reload;
                android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    return new moji.com.mjweather.databinding.FragmentAvatarShopStarBinding((android.widget.LinearLayout) view, linearLayout, listView, findChildViewById, findChildViewById2, textView);
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.FragmentAvatarShopStarBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.FragmentAvatarShopStarBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.fragment_avatar_shop_star, viewGroup, false);
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
