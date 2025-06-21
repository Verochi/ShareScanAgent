package moji.com.mjweatherservicebase.databinding;

/* loaded from: classes20.dex */
public final class RflowersItemLabelBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.TextView mLabelView;

    @androidx.annotation.NonNull
    public final android.widget.TextView n;

    public RflowersItemLabelBinding(@androidx.annotation.NonNull android.widget.TextView textView, @androidx.annotation.NonNull android.widget.TextView textView2) {
        this.n = textView;
        this.mLabelView = textView2;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweatherservicebase.databinding.RflowersItemLabelBinding bind(@androidx.annotation.NonNull android.view.View view) {
        if (view == null) {
            throw new java.lang.NullPointerException("rootView");
        }
        android.widget.TextView textView = (android.widget.TextView) view;
        return new moji.com.mjweatherservicebase.databinding.RflowersItemLabelBinding(textView, textView);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweatherservicebase.databinding.RflowersItemLabelBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweatherservicebase.databinding.RflowersItemLabelBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweatherservicebase.R.layout.rflowers_item_label, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @androidx.annotation.NonNull
    public android.widget.TextView getRoot() {
        return this.n;
    }
}
