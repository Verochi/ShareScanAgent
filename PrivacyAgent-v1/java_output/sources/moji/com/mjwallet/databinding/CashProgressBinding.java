package moji.com.mjwallet.databinding;

/* loaded from: classes20.dex */
public final class CashProgressBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final androidx.constraintlayout.widget.ConstraintLayout n;

    public CashProgressBinding(@androidx.annotation.NonNull androidx.constraintlayout.widget.ConstraintLayout constraintLayout) {
        this.n = constraintLayout;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjwallet.databinding.CashProgressBinding bind(@androidx.annotation.NonNull android.view.View view) {
        if (view != null) {
            return new moji.com.mjwallet.databinding.CashProgressBinding((androidx.constraintlayout.widget.ConstraintLayout) view);
        }
        throw new java.lang.NullPointerException("rootView");
    }

    @androidx.annotation.NonNull
    public static moji.com.mjwallet.databinding.CashProgressBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjwallet.databinding.CashProgressBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjwallet.R.layout.cash_progress, viewGroup, false);
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
