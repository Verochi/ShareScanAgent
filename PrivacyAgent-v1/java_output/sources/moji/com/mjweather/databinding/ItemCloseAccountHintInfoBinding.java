package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class ItemCloseAccountHintInfoBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final androidx.constraintlayout.widget.ConstraintLayout n;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvDesc;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvNum;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvTitle;

    public ItemCloseAccountHintInfoBinding(@androidx.annotation.NonNull androidx.constraintlayout.widget.ConstraintLayout constraintLayout, @androidx.annotation.NonNull android.widget.TextView textView, @androidx.annotation.NonNull android.widget.TextView textView2, @androidx.annotation.NonNull android.widget.TextView textView3) {
        this.n = constraintLayout;
        this.tvDesc = textView;
        this.tvNum = textView2;
        this.tvTitle = textView3;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ItemCloseAccountHintInfoBinding bind(@androidx.annotation.NonNull android.view.View view) {
        int i = moji.com.mjweather.R.id.tv_desc;
        android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = moji.com.mjweather.R.id.tv_num;
            android.widget.TextView textView2 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (textView2 != null) {
                i = moji.com.mjweather.R.id.tv_title;
                android.widget.TextView textView3 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (textView3 != null) {
                    return new moji.com.mjweather.databinding.ItemCloseAccountHintInfoBinding((androidx.constraintlayout.widget.ConstraintLayout) view, textView, textView2, textView3);
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ItemCloseAccountHintInfoBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ItemCloseAccountHintInfoBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.item_close_account_hint_info, viewGroup, false);
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
