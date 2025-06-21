package moji.com.mjwallet.databinding;

/* loaded from: classes31.dex */
public final class ActivityWalletMainBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final moji.com.mjwallet.WalletBalanceLayout balanceLayout;

    @androidx.annotation.NonNull
    public final android.widget.ImageView bill;

    @androidx.annotation.NonNull
    public final androidx.constraintlayout.widget.ConstraintLayout contentLayout;

    @androidx.annotation.NonNull
    public final moji.com.mjwallet.databinding.BalenceItem1Binding item1;

    @androidx.annotation.NonNull
    public final androidx.constraintlayout.widget.ConstraintLayout item2;

    @androidx.annotation.NonNull
    public final androidx.constraintlayout.widget.ConstraintLayout item3;

    @androidx.annotation.NonNull
    public final androidx.constraintlayout.widget.ConstraintLayout item4;

    @androidx.annotation.NonNull
    public final android.widget.ImageView memberTicket;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout n;

    @androidx.annotation.NonNull
    public final com.moji.multiplestatuslayout.MJMultipleStatusLayout statusLayout;

    @androidx.annotation.NonNull
    public final android.widget.TextView ticketCount;

    @androidx.annotation.NonNull
    public final android.widget.ImageView withdrawalSchedule;

    public ActivityWalletMainBinding(@androidx.annotation.NonNull android.widget.LinearLayout linearLayout, @androidx.annotation.NonNull moji.com.mjwallet.WalletBalanceLayout walletBalanceLayout, @androidx.annotation.NonNull android.widget.ImageView imageView, @androidx.annotation.NonNull androidx.constraintlayout.widget.ConstraintLayout constraintLayout, @androidx.annotation.NonNull moji.com.mjwallet.databinding.BalenceItem1Binding balenceItem1Binding, @androidx.annotation.NonNull androidx.constraintlayout.widget.ConstraintLayout constraintLayout2, @androidx.annotation.NonNull androidx.constraintlayout.widget.ConstraintLayout constraintLayout3, @androidx.annotation.NonNull androidx.constraintlayout.widget.ConstraintLayout constraintLayout4, @androidx.annotation.NonNull android.widget.ImageView imageView2, @androidx.annotation.NonNull com.moji.multiplestatuslayout.MJMultipleStatusLayout mJMultipleStatusLayout, @androidx.annotation.NonNull android.widget.TextView textView, @androidx.annotation.NonNull android.widget.ImageView imageView3) {
        this.n = linearLayout;
        this.balanceLayout = walletBalanceLayout;
        this.bill = imageView;
        this.contentLayout = constraintLayout;
        this.item1 = balenceItem1Binding;
        this.item2 = constraintLayout2;
        this.item3 = constraintLayout3;
        this.item4 = constraintLayout4;
        this.memberTicket = imageView2;
        this.statusLayout = mJMultipleStatusLayout;
        this.ticketCount = textView;
        this.withdrawalSchedule = imageView3;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjwallet.databinding.ActivityWalletMainBinding bind(@androidx.annotation.NonNull android.view.View view) {
        android.view.View findChildViewById;
        com.moji.multiplestatuslayout.MJMultipleStatusLayout findChildViewById2;
        int i = moji.com.mjwallet.R.id.balance_layout;
        moji.com.mjwallet.WalletBalanceLayout walletBalanceLayout = (moji.com.mjwallet.WalletBalanceLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (walletBalanceLayout != null) {
            i = moji.com.mjwallet.R.id.bill;
            android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = moji.com.mjwallet.R.id.content_layout;
                androidx.constraintlayout.widget.ConstraintLayout constraintLayout = (androidx.constraintlayout.widget.ConstraintLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (constraintLayout != null && (findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjwallet.R.id.item1))) != null) {
                    moji.com.mjwallet.databinding.BalenceItem1Binding bind = moji.com.mjwallet.databinding.BalenceItem1Binding.bind(findChildViewById);
                    i = moji.com.mjwallet.R.id.item2;
                    androidx.constraintlayout.widget.ConstraintLayout constraintLayout2 = (androidx.constraintlayout.widget.ConstraintLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                    if (constraintLayout2 != null) {
                        i = moji.com.mjwallet.R.id.item3;
                        androidx.constraintlayout.widget.ConstraintLayout constraintLayout3 = (androidx.constraintlayout.widget.ConstraintLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                        if (constraintLayout3 != null) {
                            i = moji.com.mjwallet.R.id.item4;
                            androidx.constraintlayout.widget.ConstraintLayout constraintLayout4 = (androidx.constraintlayout.widget.ConstraintLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                            if (constraintLayout4 != null) {
                                i = moji.com.mjwallet.R.id.member_ticket;
                                android.widget.ImageView imageView2 = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                if (imageView2 != null && (findChildViewById2 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjwallet.R.id.status_layout))) != null) {
                                    i = moji.com.mjwallet.R.id.ticketCount;
                                    android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                    if (textView != null) {
                                        i = moji.com.mjwallet.R.id.withdrawal_schedule;
                                        android.widget.ImageView imageView3 = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                        if (imageView3 != null) {
                                            return new moji.com.mjwallet.databinding.ActivityWalletMainBinding((android.widget.LinearLayout) view, walletBalanceLayout, imageView, constraintLayout, bind, constraintLayout2, constraintLayout3, constraintLayout4, imageView2, findChildViewById2, textView, imageView3);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static moji.com.mjwallet.databinding.ActivityWalletMainBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjwallet.databinding.ActivityWalletMainBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjwallet.R.layout.activity_wallet_main, viewGroup, false);
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
