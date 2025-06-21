package moji.com.mjwallet.databinding;

/* loaded from: classes31.dex */
public final class LayoutItemRechargeBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.TextView balance;

    @androidx.annotation.NonNull
    public final android.widget.TextView extractStatus;

    @androidx.annotation.NonNull
    public final android.view.View lineBottom;

    @androidx.annotation.NonNull
    public final android.view.View lineNormal;

    @androidx.annotation.NonNull
    public final androidx.constraintlayout.widget.ConstraintLayout n;

    @androidx.annotation.NonNull
    public final android.widget.TextView recordDate;

    @androidx.annotation.NonNull
    public final android.widget.TextView recordName;

    @androidx.annotation.NonNull
    public final android.widget.TextView recordNo;

    public LayoutItemRechargeBinding(@androidx.annotation.NonNull androidx.constraintlayout.widget.ConstraintLayout constraintLayout, @androidx.annotation.NonNull android.widget.TextView textView, @androidx.annotation.NonNull android.widget.TextView textView2, @androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull android.view.View view2, @androidx.annotation.NonNull android.widget.TextView textView3, @androidx.annotation.NonNull android.widget.TextView textView4, @androidx.annotation.NonNull android.widget.TextView textView5) {
        this.n = constraintLayout;
        this.balance = textView;
        this.extractStatus = textView2;
        this.lineBottom = view;
        this.lineNormal = view2;
        this.recordDate = textView3;
        this.recordName = textView4;
        this.recordNo = textView5;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjwallet.databinding.LayoutItemRechargeBinding bind(@androidx.annotation.NonNull android.view.View view) {
        android.view.View findChildViewById;
        android.view.View findChildViewById2;
        int i = moji.com.mjwallet.R.id.balance;
        android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = moji.com.mjwallet.R.id.extract_status;
            android.widget.TextView textView2 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (textView2 != null && (findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjwallet.R.id.line__bottom))) != null && (findChildViewById2 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjwallet.R.id.line_normal))) != null) {
                i = moji.com.mjwallet.R.id.record_date;
                android.widget.TextView textView3 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (textView3 != null) {
                    i = moji.com.mjwallet.R.id.record_name;
                    android.widget.TextView textView4 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                    if (textView4 != null) {
                        i = moji.com.mjwallet.R.id.record_no;
                        android.widget.TextView textView5 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                        if (textView5 != null) {
                            return new moji.com.mjwallet.databinding.LayoutItemRechargeBinding((androidx.constraintlayout.widget.ConstraintLayout) view, textView, textView2, findChildViewById, findChildViewById2, textView3, textView4, textView5);
                        }
                    }
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static moji.com.mjwallet.databinding.LayoutItemRechargeBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjwallet.databinding.LayoutItemRechargeBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjwallet.R.layout.layout_item_recharge, viewGroup, false);
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
