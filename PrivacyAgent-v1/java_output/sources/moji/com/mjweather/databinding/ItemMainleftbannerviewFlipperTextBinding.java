package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class ItemMainleftbannerviewFlipperTextBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.TextView mTextView;

    @androidx.annotation.NonNull
    public final android.widget.TextView n;

    public ItemMainleftbannerviewFlipperTextBinding(@androidx.annotation.NonNull android.widget.TextView textView, @androidx.annotation.NonNull android.widget.TextView textView2) {
        this.n = textView;
        this.mTextView = textView2;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ItemMainleftbannerviewFlipperTextBinding bind(@androidx.annotation.NonNull android.view.View view) {
        if (view == null) {
            throw new java.lang.NullPointerException("rootView");
        }
        android.widget.TextView textView = (android.widget.TextView) view;
        return new moji.com.mjweather.databinding.ItemMainleftbannerviewFlipperTextBinding(textView, textView);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ItemMainleftbannerviewFlipperTextBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ItemMainleftbannerviewFlipperTextBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.item_mainleftbannerview_flipper_text, viewGroup, false);
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
