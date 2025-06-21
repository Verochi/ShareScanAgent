package moji.com.mjwallet.databinding;

/* loaded from: classes31.dex */
public final class ActivityWalletWithDrawalBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.view.View bottomLine;

    @androidx.annotation.NonNull
    public final moji.com.mjwallet.databinding.CashExtractSuccessBinding cashSuccessLayout;

    @androidx.annotation.NonNull
    public final android.widget.TextView confirmCashExtract;

    @androidx.annotation.NonNull
    public final android.widget.EditText inputAmount;

    @androidx.annotation.NonNull
    public final android.view.View line2;

    @androidx.annotation.NonNull
    public final android.view.View line4;

    @androidx.annotation.NonNull
    public final android.widget.TextView mjWalletList;

    @androidx.annotation.NonNull
    public final android.widget.TextView mjWalletQa;

    @androidx.annotation.NonNull
    public final android.view.View money;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout n;

    @androidx.annotation.NonNull
    public final android.widget.ImageView right01;

    @androidx.annotation.NonNull
    public final android.widget.ImageView right02;

    @androidx.annotation.NonNull
    public final com.moji.multiplestatuslayout.MJMultipleStatusLayout statusLayout;

    @androidx.annotation.NonNull
    public final com.moji.titlebar.MJTitleBar titleBar;

    @androidx.annotation.NonNull
    public final android.view.View topMargin;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvAccount;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvBalance;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvMoney;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvName;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvUserAccount;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvUserName;

    @androidx.annotation.NonNull
    public final android.view.View userAccount;

    @androidx.annotation.NonNull
    public final androidx.constraintlayout.widget.ConstraintLayout userName;

    @androidx.annotation.NonNull
    public final android.widget.TextView walletCashHint;

    @androidx.annotation.NonNull
    public final android.widget.TextView walletCashHintContent;

    public ActivityWalletWithDrawalBinding(@androidx.annotation.NonNull android.widget.LinearLayout linearLayout, @androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull moji.com.mjwallet.databinding.CashExtractSuccessBinding cashExtractSuccessBinding, @androidx.annotation.NonNull android.widget.TextView textView, @androidx.annotation.NonNull android.widget.EditText editText, @androidx.annotation.NonNull android.view.View view2, @androidx.annotation.NonNull android.view.View view3, @androidx.annotation.NonNull android.widget.TextView textView2, @androidx.annotation.NonNull android.widget.TextView textView3, @androidx.annotation.NonNull android.view.View view4, @androidx.annotation.NonNull android.widget.ImageView imageView, @androidx.annotation.NonNull android.widget.ImageView imageView2, @androidx.annotation.NonNull com.moji.multiplestatuslayout.MJMultipleStatusLayout mJMultipleStatusLayout, @androidx.annotation.NonNull com.moji.titlebar.MJTitleBar mJTitleBar, @androidx.annotation.NonNull android.view.View view5, @androidx.annotation.NonNull android.widget.TextView textView4, @androidx.annotation.NonNull android.widget.TextView textView5, @androidx.annotation.NonNull android.widget.TextView textView6, @androidx.annotation.NonNull android.widget.TextView textView7, @androidx.annotation.NonNull android.widget.TextView textView8, @androidx.annotation.NonNull android.widget.TextView textView9, @androidx.annotation.NonNull android.view.View view6, @androidx.annotation.NonNull androidx.constraintlayout.widget.ConstraintLayout constraintLayout, @androidx.annotation.NonNull android.widget.TextView textView10, @androidx.annotation.NonNull android.widget.TextView textView11) {
        this.n = linearLayout;
        this.bottomLine = view;
        this.cashSuccessLayout = cashExtractSuccessBinding;
        this.confirmCashExtract = textView;
        this.inputAmount = editText;
        this.line2 = view2;
        this.line4 = view3;
        this.mjWalletList = textView2;
        this.mjWalletQa = textView3;
        this.money = view4;
        this.right01 = imageView;
        this.right02 = imageView2;
        this.statusLayout = mJMultipleStatusLayout;
        this.titleBar = mJTitleBar;
        this.topMargin = view5;
        this.tvAccount = textView4;
        this.tvBalance = textView5;
        this.tvMoney = textView6;
        this.tvName = textView7;
        this.tvUserAccount = textView8;
        this.tvUserName = textView9;
        this.userAccount = view6;
        this.userName = constraintLayout;
        this.walletCashHint = textView10;
        this.walletCashHintContent = textView11;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjwallet.databinding.ActivityWalletWithDrawalBinding bind(@androidx.annotation.NonNull android.view.View view) {
        android.view.View findChildViewById;
        android.view.View findChildViewById2;
        android.view.View findChildViewById3;
        android.view.View findChildViewById4;
        com.moji.multiplestatuslayout.MJMultipleStatusLayout findChildViewById5;
        com.moji.titlebar.MJTitleBar findChildViewById6;
        android.view.View findChildViewById7;
        android.view.View findChildViewById8;
        int i = moji.com.mjwallet.R.id.bottom_line;
        android.view.View findChildViewById9 = androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (findChildViewById9 != null && (findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjwallet.R.id.cash_success_layout))) != null) {
            moji.com.mjwallet.databinding.CashExtractSuccessBinding bind = moji.com.mjwallet.databinding.CashExtractSuccessBinding.bind(findChildViewById);
            i = moji.com.mjwallet.R.id.confirm_cash_extract;
            android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = moji.com.mjwallet.R.id.input_amount;
                android.widget.EditText editText = (android.widget.EditText) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (editText != null && (findChildViewById2 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjwallet.R.id.line2))) != null && (findChildViewById3 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjwallet.R.id.line4))) != null) {
                    i = moji.com.mjwallet.R.id.mj_wallet_list;
                    android.widget.TextView textView2 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        i = moji.com.mjwallet.R.id.mj_wallet_qa;
                        android.widget.TextView textView3 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                        if (textView3 != null && (findChildViewById4 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjwallet.R.id.money))) != null) {
                            i = moji.com.mjwallet.R.id.right_01;
                            android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                            if (imageView != null) {
                                i = moji.com.mjwallet.R.id.right_02;
                                android.widget.ImageView imageView2 = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                if (imageView2 != null && (findChildViewById5 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjwallet.R.id.status_layout))) != null && (findChildViewById6 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjwallet.R.id.title_bar))) != null && (findChildViewById7 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjwallet.R.id.top_margin))) != null) {
                                    i = moji.com.mjwallet.R.id.tv_account;
                                    android.widget.TextView textView4 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                    if (textView4 != null) {
                                        i = moji.com.mjwallet.R.id.tv_balance;
                                        android.widget.TextView textView5 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                        if (textView5 != null) {
                                            i = moji.com.mjwallet.R.id.tv_money;
                                            android.widget.TextView textView6 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                            if (textView6 != null) {
                                                i = moji.com.mjwallet.R.id.tv_name;
                                                android.widget.TextView textView7 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                                if (textView7 != null) {
                                                    i = moji.com.mjwallet.R.id.tv_user_account;
                                                    android.widget.TextView textView8 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                                    if (textView8 != null) {
                                                        i = moji.com.mjwallet.R.id.tv_user_name;
                                                        android.widget.TextView textView9 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                                        if (textView9 != null && (findChildViewById8 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjwallet.R.id.user_account))) != null) {
                                                            i = moji.com.mjwallet.R.id.user_name;
                                                            androidx.constraintlayout.widget.ConstraintLayout constraintLayout = (androidx.constraintlayout.widget.ConstraintLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                                            if (constraintLayout != null) {
                                                                i = moji.com.mjwallet.R.id.wallet_cash_hint;
                                                                android.widget.TextView textView10 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                                                if (textView10 != null) {
                                                                    i = moji.com.mjwallet.R.id.wallet_cash_hint_content;
                                                                    android.widget.TextView textView11 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                                                    if (textView11 != null) {
                                                                        return new moji.com.mjwallet.databinding.ActivityWalletWithDrawalBinding((android.widget.LinearLayout) view, findChildViewById9, bind, textView, editText, findChildViewById2, findChildViewById3, textView2, textView3, findChildViewById4, imageView, imageView2, findChildViewById5, findChildViewById6, findChildViewById7, textView4, textView5, textView6, textView7, textView8, textView9, findChildViewById8, constraintLayout, textView10, textView11);
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
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
    public static moji.com.mjwallet.databinding.ActivityWalletWithDrawalBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjwallet.databinding.ActivityWalletWithDrawalBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjwallet.R.layout.activity_wallet_with_drawal, viewGroup, false);
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
