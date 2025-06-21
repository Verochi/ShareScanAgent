package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class LayoutBigLabelBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.TextView labelTitle;

    @androidx.annotation.NonNull
    public final com.moji.mjweather.weather.view.PicassoLinearLayout n;

    public LayoutBigLabelBinding(@androidx.annotation.NonNull com.moji.mjweather.weather.view.PicassoLinearLayout picassoLinearLayout, @androidx.annotation.NonNull android.widget.TextView textView) {
        this.n = picassoLinearLayout;
        this.labelTitle = textView;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.LayoutBigLabelBinding bind(@androidx.annotation.NonNull android.view.View view) {
        int i = moji.com.mjweather.R.id.label_title;
        android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            return new moji.com.mjweather.databinding.LayoutBigLabelBinding((com.moji.mjweather.weather.view.PicassoLinearLayout) view, textView);
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.LayoutBigLabelBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.LayoutBigLabelBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.layout_big_label, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @androidx.annotation.NonNull
    public com.moji.mjweather.weather.view.PicassoLinearLayout getRoot() {
        return this.n;
    }
}
