package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class FragmentFontSetV9Binding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.view.View bottomArea;

    @androidx.annotation.NonNull
    public final android.widget.TextView fontSizeBig;

    @androidx.annotation.NonNull
    public final android.widget.TextView fontSizeNormal;

    @androidx.annotation.NonNull
    public final android.widget.ImageView fontSizePreview;

    @androidx.annotation.NonNull
    public final android.view.View lineLeft;

    @androidx.annotation.NonNull
    public final android.view.View lineRight;

    @androidx.annotation.NonNull
    public final androidx.constraintlayout.widget.ConstraintLayout n;

    @androidx.annotation.NonNull
    public final android.widget.SeekBar seekView;

    public FragmentFontSetV9Binding(@androidx.annotation.NonNull androidx.constraintlayout.widget.ConstraintLayout constraintLayout, @androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull android.widget.TextView textView, @androidx.annotation.NonNull android.widget.TextView textView2, @androidx.annotation.NonNull android.widget.ImageView imageView, @androidx.annotation.NonNull android.view.View view2, @androidx.annotation.NonNull android.view.View view3, @androidx.annotation.NonNull android.widget.SeekBar seekBar) {
        this.n = constraintLayout;
        this.bottomArea = view;
        this.fontSizeBig = textView;
        this.fontSizeNormal = textView2;
        this.fontSizePreview = imageView;
        this.lineLeft = view2;
        this.lineRight = view3;
        this.seekView = seekBar;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.FragmentFontSetV9Binding bind(@androidx.annotation.NonNull android.view.View view) {
        android.view.View findChildViewById;
        android.view.View findChildViewById2;
        int i = moji.com.mjweather.R.id.bottom_area;
        android.view.View findChildViewById3 = androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (findChildViewById3 != null) {
            i = moji.com.mjweather.R.id.font_size_big;
            android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = moji.com.mjweather.R.id.font_size_normal;
                android.widget.TextView textView2 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (textView2 != null) {
                    i = moji.com.mjweather.R.id.font_size_preview;
                    android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                    if (imageView != null && (findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.line_left))) != null && (findChildViewById2 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.line_right))) != null) {
                        i = moji.com.mjweather.R.id.seek_view;
                        android.widget.SeekBar seekBar = (android.widget.SeekBar) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                        if (seekBar != null) {
                            return new moji.com.mjweather.databinding.FragmentFontSetV9Binding((androidx.constraintlayout.widget.ConstraintLayout) view, findChildViewById3, textView, textView2, imageView, findChildViewById, findChildViewById2, seekBar);
                        }
                    }
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.FragmentFontSetV9Binding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.FragmentFontSetV9Binding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.fragment_font_set_v9, viewGroup, false);
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
