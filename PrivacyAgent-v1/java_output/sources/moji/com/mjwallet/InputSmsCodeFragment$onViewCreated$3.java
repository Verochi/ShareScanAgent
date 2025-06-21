package moji.com.mjwallet;

@kotlin.Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J*\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J*\u0010\f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016¨\u0006\r"}, d2 = {"moji/com/mjwallet/InputSmsCodeFragment$onViewCreated$3", "Landroid/text/TextWatcher;", "afterTextChanged", "", "p0", "Landroid/text/Editable;", "beforeTextChanged", "", "p1", "", com.anythink.core.common.h.c.X, "p3", "onTextChanged", "MJWallet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes20.dex */
public final class InputSmsCodeFragment$onViewCreated$3 implements android.text.TextWatcher {
    public final /* synthetic */ moji.com.mjwallet.InputSmsCodeFragment n;

    public InputSmsCodeFragment$onViewCreated$3(moji.com.mjwallet.InputSmsCodeFragment inputSmsCodeFragment) {
        this.n = inputSmsCodeFragment;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(@org.jetbrains.annotations.Nullable android.text.Editable p0) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(@org.jetbrains.annotations.Nullable java.lang.CharSequence p0, int p1, int p2, int p3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(@org.jetbrains.annotations.Nullable java.lang.CharSequence p0, int p1, int p2, int p3) {
        moji.com.mjwallet.databinding.InputVerificationCodeDialogBinding inputVerificationCodeDialogBinding;
        moji.com.mjwallet.CashExtractInfoViewModel cashExtractInfoViewModel;
        int i;
        if (p0 == null || p0.length() != 4) {
            return;
        }
        if (android.text.TextUtils.isDigitsOnly(p0.toString())) {
            cashExtractInfoViewModel = this.n.viewModel;
            if (cashExtractInfoViewModel != null) {
                i = this.n.mExtractFee;
                cashExtractInfoViewModel.checkVerificationCode(i, java.lang.Integer.parseInt(p0.toString()));
                return;
            }
            return;
        }
        inputVerificationCodeDialogBinding = this.n.binding;
        if (inputVerificationCodeDialogBinding == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
            inputVerificationCodeDialogBinding = null;
        }
        inputVerificationCodeDialogBinding.editVerificationCode.getEditableText().clear();
        com.moji.tool.toast.PatchedToast.makeText(this.n.getContext(), this.n.getString(moji.com.mjwallet.R.string.wallet_verification_code_error), 1).show();
    }
}
