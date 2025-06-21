package moji.com.mjwallet.databinding;

/* loaded from: classes20.dex */
public final class WallentBalanceBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.TextView balanceHint;

    @androidx.annotation.NonNull
    public final android.view.View n;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvBalance;

    @androidx.annotation.NonNull
    public final com.moji.imageview.MJImageView walletMainBg;

    public WallentBalanceBinding(@androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull android.widget.TextView textView, @androidx.annotation.NonNull android.widget.TextView textView2, @androidx.annotation.NonNull com.moji.imageview.MJImageView mJImageView) {
        this.n = view;
        this.balanceHint = textView;
        this.tvBalance = textView2;
        this.walletMainBg = mJImageView;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjwallet.databinding.WallentBalanceBinding bind(@androidx.annotation.NonNull android.view.View view) {
        com.moji.imageview.MJImageView findChildViewById;
        int i = moji.com.mjwallet.R.id.balance_hint;
        android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = moji.com.mjwallet.R.id.tv_balance;
            android.widget.TextView textView2 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (textView2 != null && (findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjwallet.R.id.wallet_main_bg))) != null) {
                return new moji.com.mjwallet.databinding.WallentBalanceBinding(view, textView, textView2, findChildViewById);
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static moji.com.mjwallet.databinding.WallentBalanceBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.NonNull android.view.ViewGroup viewGroup) {
        if (viewGroup == null) {
            throw new java.lang.NullPointerException("parent");
        }
        layoutInflater.inflate(moji.com.mjwallet.R.layout.wallent_balance, viewGroup);
        return bind(viewGroup);
    }

    @Override // androidx.viewbinding.ViewBinding
    @androidx.annotation.NonNull
    public android.view.View getRoot() {
        return this.n;
    }
}
