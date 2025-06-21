package moji.com.mjwallet.databinding;

/* loaded from: classes31.dex */
public final class ExtractProgressItemBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final androidx.constraintlayout.widget.ConstraintLayout n;

    @androidx.annotation.NonNull
    public final android.widget.TextView progressTime1;

    @androidx.annotation.NonNull
    public final android.widget.TextView progressTime2;

    @androidx.annotation.NonNull
    public final android.widget.TextView progressTime3;

    @androidx.annotation.NonNull
    public final android.widget.TextView progressTime4;

    @androidx.annotation.NonNull
    public final moji.com.mjwallet.view.CashExtraceProgressView progressView;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvCashExtractAccountName;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvCashExtractAccountNameRight;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvCashExtractLeft;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvCashExtractOrderDate;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvCashExtractOrderDateRight;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvCashExtractOrderNo;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvCashExtractOrderNoRight;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvCashExtractOrderProgress;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvCashExtractReceivingAccount;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvCashExtractReceivingAccountRight;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvCashExtractReceivingBank;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvCashExtractReceivingBankRight;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvCashExtractRight;

    public ExtractProgressItemBinding(@androidx.annotation.NonNull androidx.constraintlayout.widget.ConstraintLayout constraintLayout, @androidx.annotation.NonNull android.widget.TextView textView, @androidx.annotation.NonNull android.widget.TextView textView2, @androidx.annotation.NonNull android.widget.TextView textView3, @androidx.annotation.NonNull android.widget.TextView textView4, @androidx.annotation.NonNull moji.com.mjwallet.view.CashExtraceProgressView cashExtraceProgressView, @androidx.annotation.NonNull android.widget.TextView textView5, @androidx.annotation.NonNull android.widget.TextView textView6, @androidx.annotation.NonNull android.widget.TextView textView7, @androidx.annotation.NonNull android.widget.TextView textView8, @androidx.annotation.NonNull android.widget.TextView textView9, @androidx.annotation.NonNull android.widget.TextView textView10, @androidx.annotation.NonNull android.widget.TextView textView11, @androidx.annotation.NonNull android.widget.TextView textView12, @androidx.annotation.NonNull android.widget.TextView textView13, @androidx.annotation.NonNull android.widget.TextView textView14, @androidx.annotation.NonNull android.widget.TextView textView15, @androidx.annotation.NonNull android.widget.TextView textView16, @androidx.annotation.NonNull android.widget.TextView textView17) {
        this.n = constraintLayout;
        this.progressTime1 = textView;
        this.progressTime2 = textView2;
        this.progressTime3 = textView3;
        this.progressTime4 = textView4;
        this.progressView = cashExtraceProgressView;
        this.tvCashExtractAccountName = textView5;
        this.tvCashExtractAccountNameRight = textView6;
        this.tvCashExtractLeft = textView7;
        this.tvCashExtractOrderDate = textView8;
        this.tvCashExtractOrderDateRight = textView9;
        this.tvCashExtractOrderNo = textView10;
        this.tvCashExtractOrderNoRight = textView11;
        this.tvCashExtractOrderProgress = textView12;
        this.tvCashExtractReceivingAccount = textView13;
        this.tvCashExtractReceivingAccountRight = textView14;
        this.tvCashExtractReceivingBank = textView15;
        this.tvCashExtractReceivingBankRight = textView16;
        this.tvCashExtractRight = textView17;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjwallet.databinding.ExtractProgressItemBinding bind(@androidx.annotation.NonNull android.view.View view) {
        int i = moji.com.mjwallet.R.id.progress_time_1;
        android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = moji.com.mjwallet.R.id.progress_time_2;
            android.widget.TextView textView2 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (textView2 != null) {
                i = moji.com.mjwallet.R.id.progress_time_3;
                android.widget.TextView textView3 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (textView3 != null) {
                    i = moji.com.mjwallet.R.id.progress_time_4;
                    android.widget.TextView textView4 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                    if (textView4 != null) {
                        i = moji.com.mjwallet.R.id.progress_view;
                        moji.com.mjwallet.view.CashExtraceProgressView cashExtraceProgressView = (moji.com.mjwallet.view.CashExtraceProgressView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                        if (cashExtraceProgressView != null) {
                            i = moji.com.mjwallet.R.id.tv_cash_extract_account_name;
                            android.widget.TextView textView5 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                            if (textView5 != null) {
                                i = moji.com.mjwallet.R.id.tv_cash_extract_account_name_right;
                                android.widget.TextView textView6 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                if (textView6 != null) {
                                    i = moji.com.mjwallet.R.id.tv_cash_extract_left;
                                    android.widget.TextView textView7 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                    if (textView7 != null) {
                                        i = moji.com.mjwallet.R.id.tv_cash_extract_order_date;
                                        android.widget.TextView textView8 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                        if (textView8 != null) {
                                            i = moji.com.mjwallet.R.id.tv_cash_extract_order_date_right;
                                            android.widget.TextView textView9 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                            if (textView9 != null) {
                                                i = moji.com.mjwallet.R.id.tv_cash_extract_order_no;
                                                android.widget.TextView textView10 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                                if (textView10 != null) {
                                                    i = moji.com.mjwallet.R.id.tv_cash_extract_order_no_right;
                                                    android.widget.TextView textView11 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                                    if (textView11 != null) {
                                                        i = moji.com.mjwallet.R.id.tv_cash_extract_order_progress;
                                                        android.widget.TextView textView12 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                                        if (textView12 != null) {
                                                            i = moji.com.mjwallet.R.id.tv_cash_extract_receiving_account;
                                                            android.widget.TextView textView13 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                                            if (textView13 != null) {
                                                                i = moji.com.mjwallet.R.id.tv_cash_extract_receiving_account_right;
                                                                android.widget.TextView textView14 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                                                if (textView14 != null) {
                                                                    i = moji.com.mjwallet.R.id.tv_cash_extract_receiving_bank;
                                                                    android.widget.TextView textView15 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                                                    if (textView15 != null) {
                                                                        i = moji.com.mjwallet.R.id.tv_cash_extract_receiving_bank_right;
                                                                        android.widget.TextView textView16 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                                                        if (textView16 != null) {
                                                                            i = moji.com.mjwallet.R.id.tv_cash_extract_right;
                                                                            android.widget.TextView textView17 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                                                            if (textView17 != null) {
                                                                                return new moji.com.mjwallet.databinding.ExtractProgressItemBinding((androidx.constraintlayout.widget.ConstraintLayout) view, textView, textView2, textView3, textView4, cashExtraceProgressView, textView5, textView6, textView7, textView8, textView9, textView10, textView11, textView12, textView13, textView14, textView15, textView16, textView17);
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
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static moji.com.mjwallet.databinding.ExtractProgressItemBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjwallet.databinding.ExtractProgressItemBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjwallet.R.layout.extract_progress_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @androidx.annotation.NonNull
    public androidx.constraintlayout.widget.ConstraintLayout getRoot() {
        return this.n;
    }
}
