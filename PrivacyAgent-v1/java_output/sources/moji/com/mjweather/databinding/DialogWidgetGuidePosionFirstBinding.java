package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class DialogWidgetGuidePosionFirstBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.TextView addWidget;

    @androidx.annotation.NonNull
    public final android.widget.TextView descFirstRow;

    @androidx.annotation.NonNull
    public final android.widget.TextView descSecondRow;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout llLayout;

    @androidx.annotation.NonNull
    public final android.widget.ImageView mCloseView;

    @androidx.annotation.NonNull
    public final android.widget.RelativeLayout n;

    public DialogWidgetGuidePosionFirstBinding(@androidx.annotation.NonNull android.widget.RelativeLayout relativeLayout, @androidx.annotation.NonNull android.widget.TextView textView, @androidx.annotation.NonNull android.widget.TextView textView2, @androidx.annotation.NonNull android.widget.TextView textView3, @androidx.annotation.NonNull android.widget.LinearLayout linearLayout, @androidx.annotation.NonNull android.widget.ImageView imageView) {
        this.n = relativeLayout;
        this.addWidget = textView;
        this.descFirstRow = textView2;
        this.descSecondRow = textView3;
        this.llLayout = linearLayout;
        this.mCloseView = imageView;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.DialogWidgetGuidePosionFirstBinding bind(@androidx.annotation.NonNull android.view.View view) {
        int i = moji.com.mjweather.R.id.addWidget;
        android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = moji.com.mjweather.R.id.desc_first_row;
            android.widget.TextView textView2 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (textView2 != null) {
                i = moji.com.mjweather.R.id.desc_second_row;
                android.widget.TextView textView3 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (textView3 != null) {
                    i = moji.com.mjweather.R.id.ll_layout;
                    android.widget.LinearLayout linearLayout = (android.widget.LinearLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                    if (linearLayout != null) {
                        i = moji.com.mjweather.R.id.mCloseView;
                        android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                        if (imageView != null) {
                            return new moji.com.mjweather.databinding.DialogWidgetGuidePosionFirstBinding((android.widget.RelativeLayout) view, textView, textView2, textView3, linearLayout, imageView);
                        }
                    }
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.DialogWidgetGuidePosionFirstBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.DialogWidgetGuidePosionFirstBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.dialog_widget_guide_posion_first, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @androidx.annotation.NonNull
    public android.widget.RelativeLayout getRoot() {
        return this.n;
    }
}
