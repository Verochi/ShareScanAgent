package moji.com.mjwallet;

@kotlin.Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0007¢\u0006\u0004\b \u0010!J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J&\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\u000f\u001a\u00020\u0005H\u0016J\u001a\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010\u0014\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001f\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006\""}, d2 = {"Lmoji/com/mjwallet/InputSmsCodeFragment;", "Landroidx/fragment/app/DialogFragment;", "Landroidx/lifecycle/Observer;", "", "leftTime", "", "onChanged", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "onPause", com.anythink.expressad.a.B, "onViewCreated", "Lmoji/com/mjwallet/CheckCodeResult;", "checkResult", "d", "Lmoji/com/mjwallet/CashExtractInfoViewModel;", "t", "Lmoji/com/mjwallet/CashExtractInfoViewModel;", "viewModel", "Lmoji/com/mjwallet/databinding/InputVerificationCodeDialogBinding;", com.umeng.analytics.pro.bo.aN, "Lmoji/com/mjwallet/databinding/InputVerificationCodeDialogBinding;", "binding", "v", "I", "mExtractFee", "<init>", "()V", "MJWallet_release"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes20.dex */
public final class InputSmsCodeFragment extends androidx.fragment.app.DialogFragment implements androidx.lifecycle.Observer<java.lang.Integer> {

    /* renamed from: t, reason: from kotlin metadata */
    @org.jetbrains.annotations.Nullable
    public moji.com.mjwallet.CashExtractInfoViewModel viewModel;

    /* renamed from: u, reason: from kotlin metadata */
    public moji.com.mjwallet.databinding.InputVerificationCodeDialogBinding binding;

    /* renamed from: v, reason: from kotlin metadata */
    public int mExtractFee;

    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public static final void e(moji.com.mjwallet.InputSmsCodeFragment this$0, android.view.View view) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
        com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public static final void f(moji.com.mjwallet.InputSmsCodeFragment this$0, android.view.View view) {
        androidx.lifecycle.MutableLiveData<java.lang.Integer> mTimeCountLiveData;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(this$0, "this$0");
        moji.com.mjwallet.CashExtractInfoViewModel cashExtractInfoViewModel = this$0.viewModel;
        if (cashExtractInfoViewModel != null) {
            cashExtractInfoViewModel.requestVerificationCode();
        }
        moji.com.mjwallet.CashExtractInfoViewModel cashExtractInfoViewModel2 = this$0.viewModel;
        if (cashExtractInfoViewModel2 != null) {
            cashExtractInfoViewModel2.startTimer();
        }
        moji.com.mjwallet.databinding.InputVerificationCodeDialogBinding inputVerificationCodeDialogBinding = this$0.binding;
        moji.com.mjwallet.databinding.InputVerificationCodeDialogBinding inputVerificationCodeDialogBinding2 = null;
        if (inputVerificationCodeDialogBinding == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
            inputVerificationCodeDialogBinding = null;
        }
        inputVerificationCodeDialogBinding.sendCode.setEnabled(false);
        moji.com.mjwallet.CashExtractInfoViewModel cashExtractInfoViewModel3 = this$0.viewModel;
        if (cashExtractInfoViewModel3 != null && (mTimeCountLiveData = cashExtractInfoViewModel3.getMTimeCountLiveData()) != null) {
            mTimeCountLiveData.observe(this$0, this$0);
        }
        moji.com.mjwallet.databinding.InputVerificationCodeDialogBinding inputVerificationCodeDialogBinding3 = this$0.binding;
        if (inputVerificationCodeDialogBinding3 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
            inputVerificationCodeDialogBinding3 = null;
        }
        inputVerificationCodeDialogBinding3.editVerificationCode.setEnabled(true);
        moji.com.mjwallet.databinding.InputVerificationCodeDialogBinding inputVerificationCodeDialogBinding4 = this$0.binding;
        if (inputVerificationCodeDialogBinding4 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            inputVerificationCodeDialogBinding2 = inputVerificationCodeDialogBinding4;
        }
        inputVerificationCodeDialogBinding2.editVerificationCode.requestFocus();
        com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public static final void g(moji.com.mjwallet.InputSmsCodeFragment this$0, moji.com.mjwallet.CheckCodeResult checkCodeResult) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.d(checkCodeResult);
    }

    public final void d(moji.com.mjwallet.CheckCodeResult checkResult) {
        androidx.lifecycle.MutableLiveData<moji.com.mjwallet.CheckCodeResult> mCheckVerificationViewModel;
        if (checkResult == null) {
            return;
        }
        if (checkResult.getSuccess()) {
            dismissAllowingStateLoss();
            java.lang.Object activity = getActivity();
            if (activity == null) {
                throw new java.lang.NullPointerException("null cannot be cast to non-null type moji.com.mjwallet.CashExtractInfoActivity");
            }
            ((moji.com.mjwallet.CashExtractInfoActivity) activity).showSuccessPage(this.mExtractFee);
            return;
        }
        moji.com.mjwallet.databinding.InputVerificationCodeDialogBinding inputVerificationCodeDialogBinding = this.binding;
        if (inputVerificationCodeDialogBinding == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
            inputVerificationCodeDialogBinding = null;
        }
        inputVerificationCodeDialogBinding.editVerificationCode.getEditableText().clear();
        com.moji.tool.toast.PatchedToast.makeText(getContext(), checkResult.getP(), 1).show();
        moji.com.mjwallet.CashExtractInfoViewModel cashExtractInfoViewModel = this.viewModel;
        if (cashExtractInfoViewModel == null || (mCheckVerificationViewModel = cashExtractInfoViewModel.getMCheckVerificationViewModel()) == null) {
            return;
        }
        mCheckVerificationViewModel.postValue(null);
    }

    public void onChanged(int leftTime) {
        moji.com.mjwallet.databinding.InputVerificationCodeDialogBinding inputVerificationCodeDialogBinding = null;
        if (leftTime > 0) {
            moji.com.mjwallet.databinding.InputVerificationCodeDialogBinding inputVerificationCodeDialogBinding2 = this.binding;
            if (inputVerificationCodeDialogBinding2 == null) {
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                inputVerificationCodeDialogBinding = inputVerificationCodeDialogBinding2;
            }
            inputVerificationCodeDialogBinding.sendCode.setText(getString(moji.com.mjwallet.R.string.re_send_code, java.lang.Integer.valueOf(leftTime)));
            return;
        }
        moji.com.mjwallet.databinding.InputVerificationCodeDialogBinding inputVerificationCodeDialogBinding3 = this.binding;
        if (inputVerificationCodeDialogBinding3 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
            inputVerificationCodeDialogBinding3 = null;
        }
        inputVerificationCodeDialogBinding3.sendCode.setEnabled(true);
        moji.com.mjwallet.databinding.InputVerificationCodeDialogBinding inputVerificationCodeDialogBinding4 = this.binding;
        if (inputVerificationCodeDialogBinding4 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            inputVerificationCodeDialogBinding = inputVerificationCodeDialogBinding4;
        }
        inputVerificationCodeDialogBinding.sendCode.setText(moji.com.mjwallet.R.string.send_verification_code);
    }

    @Override // androidx.lifecycle.Observer
    public /* bridge */ /* synthetic */ void onChanged(java.lang.Integer num) {
        onChanged(num.intValue());
    }

    @Override // androidx.fragment.app.Fragment
    @org.jetbrains.annotations.Nullable
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable android.view.ViewGroup container, @org.jetbrains.annotations.Nullable android.os.Bundle savedInstanceState) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(inflater, "inflater");
        moji.com.mjwallet.databinding.InputVerificationCodeDialogBinding inflate = moji.com.mjwallet.databinding.InputVerificationCodeDialogBinding.inflate(inflater, container, false);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater, container, false)");
        this.binding = inflate;
        android.app.Dialog dialog = getDialog();
        moji.com.mjwallet.databinding.InputVerificationCodeDialogBinding inputVerificationCodeDialogBinding = null;
        android.view.Window window = dialog != null ? dialog.getWindow() : null;
        if (window != null) {
            window.requestFeature(1);
            android.view.ViewGroup viewGroup = (android.view.ViewGroup) window.getDecorView();
            viewGroup.setClipChildren(false);
            viewGroup.setClipToPadding(false);
            window.setBackgroundDrawable(new android.graphics.drawable.ColorDrawable(0));
            window.setLayout(-1, -1);
        }
        moji.com.mjwallet.databinding.InputVerificationCodeDialogBinding inputVerificationCodeDialogBinding2 = this.binding;
        if (inputVerificationCodeDialogBinding2 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            inputVerificationCodeDialogBinding = inputVerificationCodeDialogBinding2;
        }
        return inputVerificationCodeDialogBinding.getRoot();
    }

    @Override // androidx.fragment.app.Fragment
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        com.sensorsdata.analytics.android.autotrack.aop.FragmentTrackHelper.trackOnHiddenChanged(this, z);
    }

    @Override // androidx.fragment.app.Fragment
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onPause() {
        super.onPause();
        moji.com.mjwallet.databinding.InputVerificationCodeDialogBinding inputVerificationCodeDialogBinding = this.binding;
        if (inputVerificationCodeDialogBinding == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
            inputVerificationCodeDialogBinding = null;
        }
        com.moji.tool.DeviceTool.hideKeyboard(inputVerificationCodeDialogBinding.editVerificationCode);
        com.sensorsdata.analytics.android.autotrack.aop.FragmentTrackHelper.trackFragmentPause(this);
    }

    @Override // androidx.fragment.app.Fragment
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onResume() {
        super.onResume();
        com.sensorsdata.analytics.android.autotrack.aop.FragmentTrackHelper.trackFragmentResume(this);
    }

    @Override // androidx.fragment.app.Fragment
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onViewCreated(@org.jetbrains.annotations.NotNull android.view.View view, @org.jetbrains.annotations.Nullable android.os.Bundle savedInstanceState) {
        android.content.Context context;
        androidx.lifecycle.MutableLiveData<moji.com.mjwallet.CheckCodeResult> mCheckVerificationViewModel;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        android.os.Bundle arguments = getArguments();
        moji.com.mjwallet.databinding.InputVerificationCodeDialogBinding inputVerificationCodeDialogBinding = null;
        java.lang.String string = arguments != null ? arguments.getString(moji.com.mjwallet.InputSmsCodeFragmentKt.MOBILE) : null;
        android.os.Bundle arguments2 = getArguments();
        java.lang.Integer valueOf = arguments2 != null ? java.lang.Integer.valueOf(arguments2.getInt(moji.com.mjwallet.InputSmsCodeFragmentKt.EXTRACT_FEE)) : null;
        if (valueOf != null) {
            this.mExtractFee = valueOf.intValue();
        }
        android.content.Context context2 = getContext();
        if (context2 == null) {
            java.lang.NullPointerException nullPointerException = new java.lang.NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
            com.sensorsdata.analytics.android.autotrack.aop.FragmentTrackHelper.onFragmentViewCreated(this, view, savedInstanceState);
            throw nullPointerException;
        }
        this.viewModel = (moji.com.mjwallet.CashExtractInfoViewModel) androidx.lifecycle.ViewModelProviders.of((androidx.fragment.app.FragmentActivity) context2).get(moji.com.mjwallet.CashExtractInfoViewModel.class);
        moji.com.mjwallet.databinding.InputVerificationCodeDialogBinding inputVerificationCodeDialogBinding2 = this.binding;
        if (inputVerificationCodeDialogBinding2 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
            inputVerificationCodeDialogBinding2 = null;
        }
        inputVerificationCodeDialogBinding2.mCloseView.setOnClickListener(new defpackage.ls0(this));
        moji.com.mjwallet.databinding.InputVerificationCodeDialogBinding inputVerificationCodeDialogBinding3 = this.binding;
        if (inputVerificationCodeDialogBinding3 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
            inputVerificationCodeDialogBinding3 = null;
        }
        inputVerificationCodeDialogBinding3.sendCode.setOnClickListener(new defpackage.ms0(this));
        moji.com.mjwallet.databinding.InputVerificationCodeDialogBinding inputVerificationCodeDialogBinding4 = this.binding;
        if (inputVerificationCodeDialogBinding4 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
            inputVerificationCodeDialogBinding4 = null;
        }
        inputVerificationCodeDialogBinding4.editVerificationCode.addTextChangedListener(new moji.com.mjwallet.InputSmsCodeFragment$onViewCreated$3(this));
        moji.com.mjwallet.CashExtractInfoViewModel cashExtractInfoViewModel = this.viewModel;
        if (cashExtractInfoViewModel != null && (mCheckVerificationViewModel = cashExtractInfoViewModel.getMCheckVerificationViewModel()) != null) {
            mCheckVerificationViewModel.observe(this, new defpackage.ns0(this));
        }
        if (string != null && (context = getContext()) != null) {
            java.lang.String string2 = context.getString(moji.com.mjwallet.R.string.sms_code_hint, string);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(string2, "it.getString(R.string.sms_code_hint, mobile)");
            moji.com.mjwallet.databinding.InputVerificationCodeDialogBinding inputVerificationCodeDialogBinding5 = this.binding;
            if (inputVerificationCodeDialogBinding5 == null) {
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                inputVerificationCodeDialogBinding = inputVerificationCodeDialogBinding5;
            }
            inputVerificationCodeDialogBinding.verificationCodeHint.setText(string2);
        }
        com.sensorsdata.analytics.android.autotrack.aop.FragmentTrackHelper.onFragmentViewCreated(this, view, savedInstanceState);
    }

    @Override // androidx.fragment.app.Fragment
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        com.sensorsdata.analytics.android.autotrack.aop.FragmentTrackHelper.trackFragmentSetUserVisibleHint(this, z);
    }
}
