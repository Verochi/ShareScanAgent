package moji.com.mjwallet;

@com.moji.router.annotation.Router(path = "wallet/cash_extract_info")
@kotlin.Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0007¢\u0006\u0004\b8\u00109J\b\u0010\u0005\u001a\u00020\u0004H\u0014J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0003H\u0016J\"\u0010\u0011\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0014J\u000e\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\fJ\u0010\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\b\u0010\u0017\u001a\u00020\bH\u0002J\u0010\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J!\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00142\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001f\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\fH\u0002J\b\u0010 \u001a\u00020\bH\u0002J\u0010\u0010\"\u001a\u00020\b2\u0006\u0010!\u001a\u00020\fH\u0002J\u0018\u0010%\u001a\u00020\b2\u0006\u0010$\u001a\u00020#2\u0006\u0010\u0015\u001a\u00020\fH\u0002R\u0014\u0010(\u001a\u00020\f8\u0002X\u0082D¢\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010*\u001a\u00020\f8\u0002X\u0082D¢\u0006\u0006\n\u0004\b)\u0010'R\u0018\u0010-\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010\u0015\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010.R\u001b\u00103\u001a\u00020/8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u00100\u001a\u0004\b1\u00102R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b5\u00106¨\u0006:"}, d2 = {"Lmoji/com/mjwallet/CashExtractInfoActivity;", "Lcom/moji/base/MJActivity;", "Landroidx/lifecycle/Observer;", "Lmoji/com/mjwallet/CashExtractInfoViewModel$RequestResult;", "", "needTransparentStatusBar", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "requestResult", "onChanged", "", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "mExtractFee", "showSuccessPage", "", "balance", "r", "k", "j", "totalMoney", "", "inputAmount", "i", "(JLjava/lang/Float;)Z", "toast", "v", "s", "errorCode", "showErrorView", "", "bindMobile", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.WIDTH, com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.AD_COUNT, "I", "requestCodeBindMobile", "t", "requestCodeEditCount", com.umeng.analytics.pro.bo.aN, "Ljava/lang/String;", "mOldUserSnsId", "J", "Lmoji/com/mjwallet/CashExtractInfoViewModel;", "Lkotlin/Lazy;", "l", "()Lmoji/com/mjwallet/CashExtractInfoViewModel;", "viewModel", "Lmoji/com/mjwallet/databinding/ActivityWalletWithDrawalBinding;", "x", "Lmoji/com/mjwallet/databinding/ActivityWalletWithDrawalBinding;", "binding", "<init>", "()V", "MJWallet_release"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes30.dex */
public final class CashExtractInfoActivity extends com.moji.base.MJActivity implements androidx.lifecycle.Observer<moji.com.mjwallet.CashExtractInfoViewModel.RequestResult> {

    /* renamed from: n, reason: from kotlin metadata */
    public final int requestCodeBindMobile = 3456;

    /* renamed from: t, reason: from kotlin metadata */
    public final int requestCodeEditCount = 3457;

    /* renamed from: u, reason: from kotlin metadata */
    @org.jetbrains.annotations.Nullable
    public java.lang.String mOldUserSnsId = com.moji.account.data.AccountProvider.getInstance().getSnsId();

    /* renamed from: v, reason: from kotlin metadata */
    public long balance;

    /* renamed from: w, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public final kotlin.Lazy viewModel;

    /* renamed from: x, reason: from kotlin metadata */
    public moji.com.mjwallet.databinding.ActivityWalletWithDrawalBinding binding;

    public CashExtractInfoActivity() {
        kotlin.Lazy lazy;
        lazy = kotlin.LazyKt__LazyJVMKt.lazy(new moji.com.mjwallet.CashExtractInfoActivity$viewModel$2(this));
        this.viewModel = lazy;
    }

    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public static final void m(moji.com.mjwallet.CashExtractInfoActivity this$0, android.view.View view) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.k();
        com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public static final void n(moji.com.mjwallet.CashExtractInfoActivity this$0, android.view.View view) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.k();
        com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public static final void o(moji.com.mjwallet.CashExtractInfoActivity this$0, android.view.View view) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.j(this$0.balance);
        com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public static final void p(moji.com.mjwallet.CashExtractInfoActivity this$0, android.view.View view) {
        com.moji.http.pcd.CashExtractInfoResp cashExtractInfoResp;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(this$0, "this$0");
        moji.com.mjwallet.CashExtractInfoViewModel.RequestResult value = this$0.l().getMCashLiveData().getValue();
        com.moji.router.MJRouter.getInstance().build("wallet/qa").withString("announcement", (value == null || (cashExtractInfoResp = value.getCashExtractInfoResp()) == null) ? null : cashExtractInfoResp.getMessage_content()).start(this$0);
        com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public static final void q(android.view.View view) {
        com.moji.router.MJRouter.getInstance().build("wallet/bill_list").start();
        com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void t(moji.com.mjwallet.CashExtractInfoActivity this$0, com.moji.dialog.MJDialog mJDialog, com.moji.dialog.type.ETypeAction eTypeAction) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(this$0, "this$0");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(mJDialog, "<anonymous parameter 0>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(eTypeAction, "<anonymous parameter 1>");
        com.moji.router.MJRouter.getInstance().build("login/bindMobile").withBoolean("close_after_bind", true).start(this$0, this$0.requestCodeBindMobile);
    }

    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public static final void u(moji.com.mjwallet.CashExtractInfoActivity this$0, android.view.View view) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(this$0, "this$0");
        moji.com.mjwallet.databinding.ActivityWalletWithDrawalBinding activityWalletWithDrawalBinding = this$0.binding;
        if (activityWalletWithDrawalBinding == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityWalletWithDrawalBinding = null;
        }
        activityWalletWithDrawalBinding.statusLayout.showLoadingView();
        this$0.l().loadAccountData();
        com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final boolean i(long totalMoney, java.lang.Float inputAmount) {
        if (inputAmount == null) {
            return false;
        }
        float floatValue = inputAmount.floatValue();
        if (floatValue > totalMoney / 100.0f) {
            v(moji.com.mjwallet.R.string.cash_beyond);
            return false;
        }
        if (floatValue < 10.0f) {
            v(moji.com.mjwallet.R.string.cash_min);
            return false;
        }
        if (floatValue < 50.0f) {
            return true;
        }
        v(moji.com.mjwallet.R.string.cash_max);
        return false;
    }

    public final void j(long balance) {
        java.lang.Float floatOrNull;
        java.lang.String bindMobile = com.moji.account.data.AccountProvider.getInstance().getBindMobile();
        moji.com.mjwallet.databinding.ActivityWalletWithDrawalBinding activityWalletWithDrawalBinding = this.binding;
        if (activityWalletWithDrawalBinding == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityWalletWithDrawalBinding = null;
        }
        floatOrNull = kotlin.text.StringsKt__StringNumberConversionsJVMKt.toFloatOrNull(activityWalletWithDrawalBinding.inputAmount.getText().toString());
        if (floatOrNull == null || !i(balance, floatOrNull)) {
            return;
        }
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(bindMobile, "bindMobile");
        w(bindMobile, (int) (floatOrNull.floatValue() * 100));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void k() {
        com.moji.http.pcd.CashExtractInfoResp cashExtractInfoResp;
        if (android.text.TextUtils.isEmpty(com.moji.account.data.AccountProvider.getInstance().getBindMobile())) {
            s();
            return;
        }
        moji.com.mjwallet.CashExtractInfoViewModel.RequestResult value = l().getMCashLiveData().getValue();
        com.moji.http.pcd.AccountInfo account_info = (value == null || (cashExtractInfoResp = value.getCashExtractInfoResp()) == null) ? null : cashExtractInfoResp.getAccount_info();
        com.moji.router.Postcard build = com.moji.router.MJRouter.getInstance().build("wallet/account");
        if (account_info != null) {
            build.withParcelable("account", account_info);
        }
        build.start(this, this.requestCodeEditCount);
    }

    public final moji.com.mjwallet.CashExtractInfoViewModel l() {
        return (moji.com.mjwallet.CashExtractInfoViewModel) this.viewModel.getValue();
    }

    public boolean needTransparentStatusBar() {
        return false;
    }

    public void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable android.content.Intent data) {
        boolean equals$default;
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode != this.requestCodeBindMobile) {
            if (requestCode == this.requestCodeEditCount) {
                l().loadAccountData();
                return;
            }
            return;
        }
        java.lang.String bindMobile = com.moji.account.data.AccountProvider.getInstance().getBindMobile();
        java.lang.String snsId = com.moji.account.data.AccountProvider.getInstance().getSnsId();
        moji.com.mjwallet.databinding.ActivityWalletWithDrawalBinding activityWalletWithDrawalBinding = null;
        equals$default = kotlin.text.StringsKt__StringsJVMKt.equals$default(this.mOldUserSnsId, snsId, false, 2, null);
        if (equals$default) {
            if (android.text.TextUtils.isEmpty(bindMobile)) {
                return;
            }
            k();
            return;
        }
        l().loadAccountData();
        this.mOldUserSnsId = snsId;
        moji.com.mjwallet.databinding.ActivityWalletWithDrawalBinding activityWalletWithDrawalBinding2 = this.binding;
        if (activityWalletWithDrawalBinding2 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityWalletWithDrawalBinding = activityWalletWithDrawalBinding2;
        }
        activityWalletWithDrawalBinding.statusLayout.showLoadingView();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.lifecycle.Observer
    public void onChanged(@org.jetbrains.annotations.NotNull moji.com.mjwallet.CashExtractInfoViewModel.RequestResult requestResult) {
        java.lang.String message_content;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(requestResult, "requestResult");
        if (!requestResult.success()) {
            showErrorView(requestResult.getErrorCode());
            return;
        }
        java.lang.Long balance = requestResult.getBalance();
        if (balance != null) {
            long longValue = balance.longValue();
            this.balance = longValue;
            r(longValue);
        }
        moji.com.mjwallet.databinding.ActivityWalletWithDrawalBinding activityWalletWithDrawalBinding = this.binding;
        moji.com.mjwallet.databinding.ActivityWalletWithDrawalBinding activityWalletWithDrawalBinding2 = null;
        if (activityWalletWithDrawalBinding == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityWalletWithDrawalBinding = null;
        }
        activityWalletWithDrawalBinding.statusLayout.showContentView();
        com.moji.http.pcd.CashExtractInfoResp cashExtractInfoResp = requestResult.getCashExtractInfoResp();
        com.moji.http.pcd.AccountInfo account_info = cashExtractInfoResp != null ? cashExtractInfoResp.getAccount_info() : null;
        java.lang.Object findFragmentById = getSupportFragmentManager().findFragmentById(moji.com.mjwallet.R.id.wallet_announcement);
        if (findFragmentById == null) {
            throw new java.lang.NullPointerException("null cannot be cast to non-null type moji.com.mjwallet.WalletAnnouncementFragment");
        }
        moji.com.mjwallet.WalletAnnouncementFragment walletAnnouncementFragment = (moji.com.mjwallet.WalletAnnouncementFragment) findFragmentById;
        com.moji.http.pcd.CashExtractInfoResp cashExtractInfoResp2 = requestResult.getCashExtractInfoResp();
        if (cashExtractInfoResp2 != null && (message_content = cashExtractInfoResp2.getMessage_content()) != null) {
            walletAnnouncementFragment.update(message_content);
            moji.com.mjwallet.databinding.ActivityWalletWithDrawalBinding activityWalletWithDrawalBinding3 = this.binding;
            if (activityWalletWithDrawalBinding3 == null) {
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityWalletWithDrawalBinding3 = null;
            }
            activityWalletWithDrawalBinding3.topMargin.setVisibility(8);
        }
        if (account_info == null) {
            moji.com.mjwallet.databinding.ActivityWalletWithDrawalBinding activityWalletWithDrawalBinding4 = this.binding;
            if (activityWalletWithDrawalBinding4 == null) {
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                activityWalletWithDrawalBinding2 = activityWalletWithDrawalBinding4;
            }
            activityWalletWithDrawalBinding2.userName.setVisibility(8);
            return;
        }
        moji.com.mjwallet.databinding.ActivityWalletWithDrawalBinding activityWalletWithDrawalBinding5 = this.binding;
        if (activityWalletWithDrawalBinding5 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityWalletWithDrawalBinding5 = null;
        }
        activityWalletWithDrawalBinding5.tvUserAccount.setText(account_info.getAccount_number());
        moji.com.mjwallet.databinding.ActivityWalletWithDrawalBinding activityWalletWithDrawalBinding6 = this.binding;
        if (activityWalletWithDrawalBinding6 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityWalletWithDrawalBinding6 = null;
        }
        activityWalletWithDrawalBinding6.tvUserName.setText(account_info.getReal_name());
        moji.com.mjwallet.databinding.ActivityWalletWithDrawalBinding activityWalletWithDrawalBinding7 = this.binding;
        if (activityWalletWithDrawalBinding7 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityWalletWithDrawalBinding7 = null;
        }
        activityWalletWithDrawalBinding7.inputAmount.setEnabled(true);
        moji.com.mjwallet.databinding.ActivityWalletWithDrawalBinding activityWalletWithDrawalBinding8 = this.binding;
        if (activityWalletWithDrawalBinding8 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityWalletWithDrawalBinding2 = activityWalletWithDrawalBinding8;
        }
        activityWalletWithDrawalBinding2.userName.setVisibility(0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onCreate(@org.jetbrains.annotations.Nullable android.os.Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        moji.com.mjwallet.databinding.ActivityWalletWithDrawalBinding inflate = moji.com.mjwallet.databinding.ActivityWalletWithDrawalBinding.inflate(getLayoutInflater());
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(inflate, "inflate(layoutInflater)");
        this.binding = inflate;
        moji.com.mjwallet.databinding.ActivityWalletWithDrawalBinding activityWalletWithDrawalBinding = null;
        if (inflate == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
            inflate = null;
        }
        setContentView(inflate.getRoot());
        setStatusBarDarkText();
        moji.com.mjwallet.databinding.ActivityWalletWithDrawalBinding activityWalletWithDrawalBinding2 = this.binding;
        if (activityWalletWithDrawalBinding2 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityWalletWithDrawalBinding2 = null;
        }
        activityWalletWithDrawalBinding2.statusLayout.showLoadingView();
        moji.com.mjwallet.main.WalletBean walletBean = (moji.com.mjwallet.main.WalletBean) getIntent().getParcelableExtra("balance");
        if (walletBean != null) {
            r(walletBean.getBalance());
            this.balance = walletBean.getBalance();
        }
        l().getMCashLiveData().observe(this, this);
        l().loadAccountData();
        moji.com.mjwallet.databinding.ActivityWalletWithDrawalBinding activityWalletWithDrawalBinding3 = this.binding;
        if (activityWalletWithDrawalBinding3 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityWalletWithDrawalBinding3 = null;
        }
        activityWalletWithDrawalBinding3.userAccount.setOnClickListener(new defpackage.qk(this));
        moji.com.mjwallet.databinding.ActivityWalletWithDrawalBinding activityWalletWithDrawalBinding4 = this.binding;
        if (activityWalletWithDrawalBinding4 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityWalletWithDrawalBinding4 = null;
        }
        activityWalletWithDrawalBinding4.userName.setOnClickListener(new defpackage.rk(this));
        moji.com.mjwallet.databinding.ActivityWalletWithDrawalBinding activityWalletWithDrawalBinding5 = this.binding;
        if (activityWalletWithDrawalBinding5 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityWalletWithDrawalBinding5 = null;
        }
        activityWalletWithDrawalBinding5.confirmCashExtract.setOnClickListener(new defpackage.sk(this));
        moji.com.mjwallet.databinding.ActivityWalletWithDrawalBinding activityWalletWithDrawalBinding6 = this.binding;
        if (activityWalletWithDrawalBinding6 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityWalletWithDrawalBinding6 = null;
        }
        activityWalletWithDrawalBinding6.mjWalletQa.setOnClickListener(new defpackage.tk(this));
        moji.com.mjwallet.databinding.ActivityWalletWithDrawalBinding activityWalletWithDrawalBinding7 = this.binding;
        if (activityWalletWithDrawalBinding7 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityWalletWithDrawalBinding7 = null;
        }
        activityWalletWithDrawalBinding7.mjWalletList.setOnClickListener(new defpackage.uk());
        moji.com.mjwallet.databinding.ActivityWalletWithDrawalBinding activityWalletWithDrawalBinding8 = this.binding;
        if (activityWalletWithDrawalBinding8 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityWalletWithDrawalBinding8 = null;
        }
        activityWalletWithDrawalBinding8.inputAmount.setCustomSelectionActionModeCallback(new moji.com.mjwallet.CashExtractInfoActivity$onCreate$7());
        moji.com.mjwallet.databinding.ActivityWalletWithDrawalBinding activityWalletWithDrawalBinding9 = this.binding;
        if (activityWalletWithDrawalBinding9 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityWalletWithDrawalBinding = activityWalletWithDrawalBinding9;
        }
        activityWalletWithDrawalBinding.inputAmount.addTextChangedListener(new moji.com.mjwallet.CashExtractInfoActivity$onCreate$8(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void r(long balance) {
        java.lang.String format = new java.text.DecimalFormat("0.00").format(java.lang.Float.valueOf(balance / 100.0f));
        moji.com.mjwallet.databinding.ActivityWalletWithDrawalBinding activityWalletWithDrawalBinding = this.binding;
        if (activityWalletWithDrawalBinding == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityWalletWithDrawalBinding = null;
        }
        activityWalletWithDrawalBinding.tvBalance.setText(getString(moji.com.mjwallet.R.string.balance_str, format));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void s() {
        new com.moji.dialog.control.MJDialogDefaultControl.Builder(this).content(getString(moji.com.mjwallet.R.string.bind_mobile_account)).positiveText(moji.com.mjwallet.R.string.wallet_confirm_bind).negativeText(moji.com.mjwallet.R.string.wallet_cancel).onPositive(new defpackage.pk(this)).show();
    }

    public final void showErrorView(int errorCode) {
        moji.com.mjwallet.databinding.ActivityWalletWithDrawalBinding activityWalletWithDrawalBinding = this.binding;
        moji.com.mjwallet.databinding.ActivityWalletWithDrawalBinding activityWalletWithDrawalBinding2 = null;
        if (activityWalletWithDrawalBinding == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityWalletWithDrawalBinding = null;
        }
        activityWalletWithDrawalBinding.statusLayout.setOnRetryClickListener(new defpackage.vk(this));
        if (errorCode == 1001 || errorCode == 1002) {
            moji.com.mjwallet.databinding.ActivityWalletWithDrawalBinding activityWalletWithDrawalBinding3 = this.binding;
            if (activityWalletWithDrawalBinding3 == null) {
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                activityWalletWithDrawalBinding2 = activityWalletWithDrawalBinding3;
            }
            activityWalletWithDrawalBinding2.statusLayout.showNetworkUnaviable();
        }
        switch (errorCode) {
            case 600:
            case 601:
            case 602:
                moji.com.mjwallet.databinding.ActivityWalletWithDrawalBinding activityWalletWithDrawalBinding4 = this.binding;
                if (activityWalletWithDrawalBinding4 == null) {
                    kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
                } else {
                    activityWalletWithDrawalBinding2 = activityWalletWithDrawalBinding4;
                }
                activityWalletWithDrawalBinding2.statusLayout.showServerErrorView();
                break;
            default:
                moji.com.mjwallet.databinding.ActivityWalletWithDrawalBinding activityWalletWithDrawalBinding5 = this.binding;
                if (activityWalletWithDrawalBinding5 == null) {
                    kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
                } else {
                    activityWalletWithDrawalBinding2 = activityWalletWithDrawalBinding5;
                }
                activityWalletWithDrawalBinding2.statusLayout.showNoNetworkView();
                break;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void showSuccessPage(int mExtractFee) {
        moji.com.mjwallet.databinding.ActivityWalletWithDrawalBinding activityWalletWithDrawalBinding = this.binding;
        moji.com.mjwallet.databinding.ActivityWalletWithDrawalBinding activityWalletWithDrawalBinding2 = null;
        if (activityWalletWithDrawalBinding == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityWalletWithDrawalBinding = null;
        }
        activityWalletWithDrawalBinding.cashSuccessLayout.getRoot().setVisibility(0);
        setResult(-1);
        com.moji.statistics.EventManager.getInstance().notifEvent(com.moji.statistics.EVENT_TAG2.MAIN_WALLET_CASHSUCC_PAGE_SW);
        com.moji.statistics.EVENT_TAG_SENSORS event_tag_sensors = com.moji.statistics.EVENT_TAG_SENSORS.MAIN_WALLET_CASHSUCC_PAGE_SW;
        com.moji.statistics.EventManager.getInstance().notifEvent(event_tag_sensors, new com.moji.tool.SensorParams.Builder(event_tag_sensors.name()).addExtra("is_all", java.lang.Boolean.valueOf(this.balance == ((long) mExtractFee))).addExtra("amount_num", java.lang.Double.valueOf(mExtractFee / 100)).build());
        moji.com.mjwallet.databinding.ActivityWalletWithDrawalBinding activityWalletWithDrawalBinding3 = this.binding;
        if (activityWalletWithDrawalBinding3 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityWalletWithDrawalBinding2 = activityWalletWithDrawalBinding3;
        }
        com.moji.tool.DeviceTool.hideKeyboard(activityWalletWithDrawalBinding2.cashSuccessLayout.getRoot());
        android.view.View currentFocus = getCurrentFocus();
        if (currentFocus != null) {
            java.lang.Object systemService = getSystemService("input_method");
            if (systemService == null) {
                throw new java.lang.NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            }
            ((android.view.inputmethod.InputMethodManager) systemService).hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void v(int toast) {
        new com.moji.tool.toast.MJTipView.Builder(this).message(toast).showMode(com.moji.tool.toast.MJTipView.TipMode.FAIL).show();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void w(java.lang.String bindMobile, int balance) {
        moji.com.mjwallet.databinding.ActivityWalletWithDrawalBinding activityWalletWithDrawalBinding = this.binding;
        if (activityWalletWithDrawalBinding == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityWalletWithDrawalBinding = null;
        }
        activityWalletWithDrawalBinding.inputAmount.clearFocus();
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putInt(moji.com.mjwallet.InputSmsCodeFragmentKt.EXTRACT_FEE, balance);
        bundle.putString(moji.com.mjwallet.InputSmsCodeFragmentKt.MOBILE, bindMobile);
        moji.com.mjwallet.InputSmsCodeFragment inputSmsCodeFragment = new moji.com.mjwallet.InputSmsCodeFragment();
        inputSmsCodeFragment.setArguments(bundle);
        inputSmsCodeFragment.show(getSupportFragmentManager(), "code");
    }
}
