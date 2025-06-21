package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class AddcityBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.EditText EditText01;

    @androidx.annotation.NonNull
    public final android.widget.GridView GridDefaultCity;

    @androidx.annotation.NonNull
    public final android.widget.ImageButton ImageButton01;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout TextDefaultCity;

    @androidx.annotation.NonNull
    public final android.widget.TextView emptyView;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout llAddCity;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout llConfigNut;

    @androidx.annotation.NonNull
    public final android.widget.RelativeLayout n;

    @androidx.annotation.NonNull
    public final android.widget.ProgressBar pbAddCity;

    @androidx.annotation.NonNull
    public final android.widget.RelativeLayout rlAddAirNut;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvAddCity;

    public AddcityBinding(@androidx.annotation.NonNull android.widget.RelativeLayout relativeLayout, @androidx.annotation.NonNull android.widget.EditText editText, @androidx.annotation.NonNull android.widget.GridView gridView, @androidx.annotation.NonNull android.widget.ImageButton imageButton, @androidx.annotation.NonNull android.widget.LinearLayout linearLayout, @androidx.annotation.NonNull android.widget.TextView textView, @androidx.annotation.NonNull android.widget.LinearLayout linearLayout2, @androidx.annotation.NonNull android.widget.LinearLayout linearLayout3, @androidx.annotation.NonNull android.widget.ProgressBar progressBar, @androidx.annotation.NonNull android.widget.RelativeLayout relativeLayout2, @androidx.annotation.NonNull android.widget.TextView textView2) {
        this.n = relativeLayout;
        this.EditText01 = editText;
        this.GridDefaultCity = gridView;
        this.ImageButton01 = imageButton;
        this.TextDefaultCity = linearLayout;
        this.emptyView = textView;
        this.llAddCity = linearLayout2;
        this.llConfigNut = linearLayout3;
        this.pbAddCity = progressBar;
        this.rlAddAirNut = relativeLayout2;
        this.tvAddCity = textView2;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.AddcityBinding bind(@androidx.annotation.NonNull android.view.View view) {
        int i = moji.com.mjweather.R.id.EditText01;
        android.widget.EditText editText = (android.widget.EditText) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (editText != null) {
            i = moji.com.mjweather.R.id.GridDefaultCity;
            android.widget.GridView gridView = (android.widget.GridView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (gridView != null) {
                i = moji.com.mjweather.R.id.ImageButton01;
                android.widget.ImageButton imageButton = (android.widget.ImageButton) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (imageButton != null) {
                    i = moji.com.mjweather.R.id.TextDefaultCity;
                    android.widget.LinearLayout linearLayout = (android.widget.LinearLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                    if (linearLayout != null) {
                        i = moji.com.mjweather.R.id.emptyView;
                        android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                        if (textView != null) {
                            i = moji.com.mjweather.R.id.ll_add_city;
                            android.widget.LinearLayout linearLayout2 = (android.widget.LinearLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                            if (linearLayout2 != null) {
                                i = moji.com.mjweather.R.id.ll_config_nut;
                                android.widget.LinearLayout linearLayout3 = (android.widget.LinearLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                if (linearLayout3 != null) {
                                    i = moji.com.mjweather.R.id.pb_add_city;
                                    android.widget.ProgressBar progressBar = (android.widget.ProgressBar) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                    if (progressBar != null) {
                                        i = moji.com.mjweather.R.id.rl_add_air_nut;
                                        android.widget.RelativeLayout relativeLayout = (android.widget.RelativeLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                        if (relativeLayout != null) {
                                            i = moji.com.mjweather.R.id.tv_add_city;
                                            android.widget.TextView textView2 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                            if (textView2 != null) {
                                                return new moji.com.mjweather.databinding.AddcityBinding((android.widget.RelativeLayout) view, editText, gridView, imageButton, linearLayout, textView, linearLayout2, linearLayout3, progressBar, relativeLayout, textView2);
                                            }
                                        }
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
    public static moji.com.mjweather.databinding.AddcityBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.AddcityBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.addcity, viewGroup, false);
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
