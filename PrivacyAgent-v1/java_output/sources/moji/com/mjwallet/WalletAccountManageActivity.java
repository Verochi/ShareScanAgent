package moji.com.mjwallet;

@com.moji.router.annotation.Router(path = "wallet/account")
@kotlin.Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0007¢\u0006\u0004\b!\u0010\"J\b\u0010\u0004\u001a\u00020\u0003H\u0014J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0014J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0003H\u0016J\u001a\u0010\u000f\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002J\u001a\u0010\u0010\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002J*\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002R$\u0010\u001c\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006#"}, d2 = {"Lmoji/com/mjwallet/WalletAccountManageActivity;", "Lcom/moji/base/MJActivity;", "Landroidx/lifecycle/Observer;", "", "needTransparentStatusBar", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "success", "onChanged", "Lmoji/com/mjwallet/WalletAccountViewModel;", "viewModel", "Lcom/moji/http/pcd/AccountInfo;", "accountInfo", "d", "f", "", "name", "account", "g", "Landroid/app/Dialog;", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.AD_COUNT, "Landroid/app/Dialog;", "getDialog", "()Landroid/app/Dialog;", "setDialog", "(Landroid/app/Dialog;)V", "dialog", "Lmoji/com/mjwallet/databinding/ActivityWalletAccountManageBinding;", "t", "Lmoji/com/mjwallet/databinding/ActivityWalletAccountManageBinding;", "binding", "<init>", "()V", "MJWallet_release"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes30.dex */
public final class WalletAccountManageActivity extends com.moji.base.MJActivity implements androidx.lifecycle.Observer<java.lang.Boolean> {

    /* renamed from: n, reason: from kotlin metadata */
    @org.jetbrains.annotations.Nullable
    public android.app.Dialog dialog;

    /* renamed from: t, reason: from kotlin metadata */
    public moji.com.mjwallet.databinding.ActivityWalletAccountManageBinding binding;

    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public static final void e(moji.com.mjwallet.WalletAccountManageActivity this$0, moji.com.mjwallet.WalletAccountViewModel viewModel, com.moji.http.pcd.AccountInfo accountInfo, android.view.View view) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(this$0, "this$0");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(viewModel, "$viewModel");
        this$0.d(viewModel, accountInfo);
        com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public static final void h(moji.com.mjwallet.WalletAccountManageActivity this$0, moji.com.mjwallet.WalletAccountViewModel viewModel, com.moji.http.pcd.AccountInfo accountInfo, com.moji.dialog.MJDialog mJDialog, com.moji.dialog.type.ETypeAction eTypeAction) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(this$0, "this$0");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(viewModel, "$viewModel");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(mJDialog, "<anonymous parameter 0>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(eTypeAction, "<anonymous parameter 1>");
        this$0.f(viewModel, accountInfo);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void d(moji.com.mjwallet.WalletAccountViewModel viewModel, com.moji.http.pcd.AccountInfo accountInfo) {
        moji.com.mjwallet.databinding.ActivityWalletAccountManageBinding activityWalletAccountManageBinding = this.binding;
        moji.com.mjwallet.databinding.ActivityWalletAccountManageBinding activityWalletAccountManageBinding2 = null;
        if (activityWalletAccountManageBinding == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityWalletAccountManageBinding = null;
        }
        java.lang.String obj = activityWalletAccountManageBinding.etName.getText().toString();
        moji.com.mjwallet.databinding.ActivityWalletAccountManageBinding activityWalletAccountManageBinding3 = this.binding;
        if (activityWalletAccountManageBinding3 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityWalletAccountManageBinding2 = activityWalletAccountManageBinding3;
        }
        java.lang.String obj2 = activityWalletAccountManageBinding2.etAccount.getText().toString();
        if (!viewModel.checkName(obj)) {
            new com.moji.tool.toast.MJTipView.Builder(this).message(moji.com.mjwallet.R.string.correct_name).showMode(com.moji.tool.toast.MJTipView.TipMode.FAIL).show();
        } else if (viewModel.checkAccount(obj2)) {
            g(obj, obj2, viewModel, accountInfo);
        } else {
            new com.moji.tool.toast.MJTipView.Builder(this).message(moji.com.mjwallet.R.string.correct_zfb).showMode(com.moji.tool.toast.MJTipView.TipMode.FAIL).show();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void f(moji.com.mjwallet.WalletAccountViewModel viewModel, com.moji.http.pcd.AccountInfo accountInfo) {
        moji.com.mjwallet.databinding.ActivityWalletAccountManageBinding activityWalletAccountManageBinding = null;
        java.lang.Long valueOf = accountInfo != null ? java.lang.Long.valueOf(accountInfo.getAccount_id()) : null;
        moji.com.mjwallet.databinding.ActivityWalletAccountManageBinding activityWalletAccountManageBinding2 = this.binding;
        if (activityWalletAccountManageBinding2 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityWalletAccountManageBinding2 = null;
        }
        java.lang.String obj = activityWalletAccountManageBinding2.etName.getText().toString();
        moji.com.mjwallet.databinding.ActivityWalletAccountManageBinding activityWalletAccountManageBinding3 = this.binding;
        if (activityWalletAccountManageBinding3 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityWalletAccountManageBinding = activityWalletAccountManageBinding3;
        }
        viewModel.saveAccount(valueOf, obj, activityWalletAccountManageBinding.etAccount.getText().toString());
        com.moji.dialog.MJDialog build = new com.moji.dialog.control.MJDialogLoadingControl.Builder(this).build();
        this.dialog = build;
        if (build != null) {
            build.show();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void g(java.lang.String name, java.lang.String account, moji.com.mjwallet.WalletAccountViewModel viewModel, com.moji.http.pcd.AccountInfo accountInfo) {
        java.lang.String string = getString(moji.com.mjwallet.R.string.confirm_account, account, name);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.confirm_account, account, name)");
        new com.moji.dialog.control.MJDialogDefaultControl.Builder(this).content(string).onPositive(new defpackage.wd3(this, viewModel, accountInfo)).positiveText(getString(moji.com.mjwallet.R.string.account_ok)).negativeText(getString(moji.com.mjwallet.R.string.account_cancel)).contentGravity(17).build().show();
    }

    @org.jetbrains.annotations.Nullable
    public final android.app.Dialog getDialog() {
        return this.dialog;
    }

    public boolean needTransparentStatusBar() {
        return false;
    }

    @Override // androidx.lifecycle.Observer
    public /* bridge */ /* synthetic */ void onChanged(java.lang.Boolean bool) {
        onChanged(bool.booleanValue());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onChanged(boolean success) {
        android.app.Dialog dialog = this.dialog;
        if (dialog != null) {
            dialog.dismiss();
        }
        if (!success) {
            new com.moji.tool.toast.MJTipView.Builder(this).message(moji.com.mjwallet.R.string.add_account_fail).showMode(com.moji.tool.toast.MJTipView.TipMode.FAIL).show();
            return;
        }
        new com.moji.tool.toast.MJTipView.Builder(this).message(moji.com.mjwallet.R.string.add_account_success).showMode(com.moji.tool.toast.MJTipView.TipMode.SUCCESS).show();
        setResult(-1);
        finish();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onCreate(@org.jetbrains.annotations.Nullable android.os.Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        moji.com.mjwallet.databinding.ActivityWalletAccountManageBinding inflate = moji.com.mjwallet.databinding.ActivityWalletAccountManageBinding.inflate(getLayoutInflater());
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(inflate, "inflate(layoutInflater)");
        this.binding = inflate;
        moji.com.mjwallet.databinding.ActivityWalletAccountManageBinding activityWalletAccountManageBinding = null;
        if (inflate == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
            inflate = null;
        }
        setContentView(inflate.getRoot());
        setStatusBarDarkText();
        com.moji.http.pcd.AccountInfo parcelableExtra = getIntent().getParcelableExtra("account");
        moji.com.mjwallet.WalletAccountViewModel walletAccountViewModel = (moji.com.mjwallet.WalletAccountViewModel) androidx.lifecycle.ViewModelProviders.of((androidx.fragment.app.FragmentActivity) this).get(moji.com.mjwallet.WalletAccountViewModel.class);
        moji.com.mjwallet.databinding.ActivityWalletAccountManageBinding activityWalletAccountManageBinding2 = this.binding;
        if (activityWalletAccountManageBinding2 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityWalletAccountManageBinding2 = null;
        }
        activityWalletAccountManageBinding2.confirmSaveAccount.setOnClickListener(new defpackage.vd3(this, walletAccountViewModel, parcelableExtra));
        walletAccountViewModel.getStatusLiveData().observe(this, this);
        moji.com.mjwallet.databinding.ActivityWalletAccountManageBinding activityWalletAccountManageBinding3 = this.binding;
        if (activityWalletAccountManageBinding3 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityWalletAccountManageBinding = activityWalletAccountManageBinding3;
        }
        activityWalletAccountManageBinding.etName.setFilters(new moji.com.mjwallet.WalletAccountManageActivity$onCreate$2[]{new moji.com.mjwallet.WalletAccountManageActivity$onCreate$2()});
    }

    public final void setDialog(@org.jetbrains.annotations.Nullable android.app.Dialog dialog) {
        this.dialog = dialog;
    }
}
