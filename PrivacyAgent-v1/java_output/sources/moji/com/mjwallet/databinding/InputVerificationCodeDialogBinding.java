package moji.com.mjwallet.databinding;

/* loaded from: classes31.dex */
public final class InputVerificationCodeDialogBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final androidx.constraintlayout.widget.ConstraintLayout contentLayout;

    @androidx.annotation.NonNull
    public final android.widget.EditText editVerificationCode;

    @androidx.annotation.NonNull
    public final android.view.View guideLine4;

    @androidx.annotation.NonNull
    public final android.view.View guideLine5;

    @androidx.annotation.NonNull
    public final android.view.View line;

    @androidx.annotation.NonNull
    public final android.widget.ImageView mCloseView;

    @androidx.annotation.NonNull
    public final androidx.constraintlayout.widget.ConstraintLayout n;

    @androidx.annotation.NonNull
    public final android.widget.TextView sendCode;

    @androidx.annotation.NonNull
    public final android.widget.TextView verificationCodeHint;

    @androidx.annotation.NonNull
    public final android.widget.TextView walletVerificationCode;

    public InputVerificationCodeDialogBinding(@androidx.annotation.NonNull androidx.constraintlayout.widget.ConstraintLayout constraintLayout, @androidx.annotation.NonNull androidx.constraintlayout.widget.ConstraintLayout constraintLayout2, @androidx.annotation.NonNull android.widget.EditText editText, @androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull android.view.View view2, @androidx.annotation.NonNull android.view.View view3, @androidx.annotation.NonNull android.widget.ImageView imageView, @androidx.annotation.NonNull android.widget.TextView textView, @androidx.annotation.NonNull android.widget.TextView textView2, @androidx.annotation.NonNull android.widget.TextView textView3) {
        this.n = constraintLayout;
        this.contentLayout = constraintLayout2;
        this.editVerificationCode = editText;
        this.guideLine4 = view;
        this.guideLine5 = view2;
        this.line = view3;
        this.mCloseView = imageView;
        this.sendCode = textView;
        this.verificationCodeHint = textView2;
        this.walletVerificationCode = textView3;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjwallet.databinding.InputVerificationCodeDialogBinding bind(@androidx.annotation.NonNull android.view.View view) {
        android.view.View findChildViewById;
        android.view.View findChildViewById2;
        android.view.View findChildViewById3;
        int i = moji.com.mjwallet.R.id.content_layout;
        androidx.constraintlayout.widget.ConstraintLayout constraintLayout = (androidx.constraintlayout.widget.ConstraintLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (constraintLayout != null) {
            i = moji.com.mjwallet.R.id.edit_verification_code;
            android.widget.EditText editText = (android.widget.EditText) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (editText != null && (findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjwallet.R.id.guide_line4))) != null && (findChildViewById2 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjwallet.R.id.guide_line5))) != null && (findChildViewById3 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjwallet.R.id.line))) != null) {
                i = moji.com.mjwallet.R.id.mCloseView;
                android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (imageView != null) {
                    i = moji.com.mjwallet.R.id.send_code;
                    android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                    if (textView != null) {
                        i = moji.com.mjwallet.R.id.verification_code_hint;
                        android.widget.TextView textView2 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                        if (textView2 != null) {
                            i = moji.com.mjwallet.R.id.wallet_verification_code;
                            android.widget.TextView textView3 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                            if (textView3 != null) {
                                return new moji.com.mjwallet.databinding.InputVerificationCodeDialogBinding((androidx.constraintlayout.widget.ConstraintLayout) view, constraintLayout, editText, findChildViewById, findChildViewById2, findChildViewById3, imageView, textView, textView2, textView3);
                            }
                        }
                    }
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static moji.com.mjwallet.databinding.InputVerificationCodeDialogBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjwallet.databinding.InputVerificationCodeDialogBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjwallet.R.layout.input_verification_code_dialog, viewGroup, false);
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
