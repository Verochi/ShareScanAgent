package moji.com.mjwallet.databinding;

/* loaded from: classes31.dex */
public final class ActivityWalletAccountManageBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.TextView accountHint;

    @androidx.annotation.NonNull
    public final android.widget.TextView confirmSaveAccount;

    @androidx.annotation.NonNull
    public final android.widget.EditText etAccount;

    @androidx.annotation.NonNull
    public final android.widget.EditText etName;

    @androidx.annotation.NonNull
    public final android.widget.FrameLayout flZfb;

    @androidx.annotation.NonNull
    public final android.view.View line1;

    @androidx.annotation.NonNull
    public final android.view.View line2;

    @androidx.annotation.NonNull
    public final android.widget.FrameLayout llAccountName;

    @androidx.annotation.NonNull
    public final androidx.constraintlayout.widget.ConstraintLayout n;

    @androidx.annotation.NonNull
    public final com.moji.titlebar.MJTitleBar titleBar;

    @androidx.annotation.NonNull
    public final android.view.View topLine;

    @androidx.annotation.NonNull
    public final android.widget.TextView walletAccountName;

    @androidx.annotation.NonNull
    public final android.widget.TextView walletAccountZfb;

    public ActivityWalletAccountManageBinding(@androidx.annotation.NonNull androidx.constraintlayout.widget.ConstraintLayout constraintLayout, @androidx.annotation.NonNull android.widget.TextView textView, @androidx.annotation.NonNull android.widget.TextView textView2, @androidx.annotation.NonNull android.widget.EditText editText, @androidx.annotation.NonNull android.widget.EditText editText2, @androidx.annotation.NonNull android.widget.FrameLayout frameLayout, @androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull android.view.View view2, @androidx.annotation.NonNull android.widget.FrameLayout frameLayout2, @androidx.annotation.NonNull com.moji.titlebar.MJTitleBar mJTitleBar, @androidx.annotation.NonNull android.view.View view3, @androidx.annotation.NonNull android.widget.TextView textView3, @androidx.annotation.NonNull android.widget.TextView textView4) {
        this.n = constraintLayout;
        this.accountHint = textView;
        this.confirmSaveAccount = textView2;
        this.etAccount = editText;
        this.etName = editText2;
        this.flZfb = frameLayout;
        this.line1 = view;
        this.line2 = view2;
        this.llAccountName = frameLayout2;
        this.titleBar = mJTitleBar;
        this.topLine = view3;
        this.walletAccountName = textView3;
        this.walletAccountZfb = textView4;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjwallet.databinding.ActivityWalletAccountManageBinding bind(@androidx.annotation.NonNull android.view.View view) {
        android.view.View findChildViewById;
        android.view.View findChildViewById2;
        com.moji.titlebar.MJTitleBar findChildViewById3;
        android.view.View findChildViewById4;
        int i = moji.com.mjwallet.R.id.account_hint;
        android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = moji.com.mjwallet.R.id.confirm_save_account;
            android.widget.TextView textView2 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (textView2 != null) {
                i = moji.com.mjwallet.R.id.et_account;
                android.widget.EditText editText = (android.widget.EditText) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (editText != null) {
                    i = moji.com.mjwallet.R.id.et_name;
                    android.widget.EditText editText2 = (android.widget.EditText) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                    if (editText2 != null) {
                        i = moji.com.mjwallet.R.id.fl_zfb;
                        android.widget.FrameLayout frameLayout = (android.widget.FrameLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                        if (frameLayout != null && (findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjwallet.R.id.line1))) != null && (findChildViewById2 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjwallet.R.id.line2))) != null) {
                            i = moji.com.mjwallet.R.id.ll_account_name;
                            android.widget.FrameLayout frameLayout2 = (android.widget.FrameLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                            if (frameLayout2 != null && (findChildViewById3 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjwallet.R.id.title_bar))) != null && (findChildViewById4 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjwallet.R.id.top_line))) != null) {
                                i = moji.com.mjwallet.R.id.wallet_account_name;
                                android.widget.TextView textView3 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                if (textView3 != null) {
                                    i = moji.com.mjwallet.R.id.wallet_account_zfb;
                                    android.widget.TextView textView4 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                    if (textView4 != null) {
                                        return new moji.com.mjwallet.databinding.ActivityWalletAccountManageBinding((androidx.constraintlayout.widget.ConstraintLayout) view, textView, textView2, editText, editText2, frameLayout, findChildViewById, findChildViewById2, frameLayout2, findChildViewById3, findChildViewById4, textView3, textView4);
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
    public static moji.com.mjwallet.databinding.ActivityWalletAccountManageBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjwallet.databinding.ActivityWalletAccountManageBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjwallet.R.layout.activity_wallet_account_manage, viewGroup, false);
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
