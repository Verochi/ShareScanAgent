package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class LayoutFirstPermissionDialogBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.view.View bottomSpace;

    @androidx.annotation.NonNull
    public final android.widget.TextView btnFirstPermissionClose;

    @androidx.annotation.NonNull
    public final android.widget.TextView btnFirstPermissionReady;

    @androidx.annotation.NonNull
    public final android.widget.ImageView ivLogo;

    @androidx.annotation.NonNull
    public final android.widget.TextView mojiWeather;

    @androidx.annotation.NonNull
    public final androidx.constraintlayout.widget.ConstraintLayout n;

    @androidx.annotation.NonNull
    public final android.widget.ScrollView scrollviewServiceAndPrivacy;

    @androidx.annotation.NonNull
    public final android.view.View serviceAndPrivacyBottomMask;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvServiceAndPrivacy;

    public LayoutFirstPermissionDialogBinding(@androidx.annotation.NonNull androidx.constraintlayout.widget.ConstraintLayout constraintLayout, @androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull android.widget.TextView textView, @androidx.annotation.NonNull android.widget.TextView textView2, @androidx.annotation.NonNull android.widget.ImageView imageView, @androidx.annotation.NonNull android.widget.TextView textView3, @androidx.annotation.NonNull android.widget.ScrollView scrollView, @androidx.annotation.NonNull android.view.View view2, @androidx.annotation.NonNull android.widget.TextView textView4) {
        this.n = constraintLayout;
        this.bottomSpace = view;
        this.btnFirstPermissionClose = textView;
        this.btnFirstPermissionReady = textView2;
        this.ivLogo = imageView;
        this.mojiWeather = textView3;
        this.scrollviewServiceAndPrivacy = scrollView;
        this.serviceAndPrivacyBottomMask = view2;
        this.tvServiceAndPrivacy = textView4;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.LayoutFirstPermissionDialogBinding bind(@androidx.annotation.NonNull android.view.View view) {
        android.view.View findChildViewById;
        int i = moji.com.mjweather.R.id.bottom_space;
        android.view.View findChildViewById2 = androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (findChildViewById2 != null) {
            i = moji.com.mjweather.R.id.btn_first_permission_close;
            android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = moji.com.mjweather.R.id.btn_first_permission_ready;
                android.widget.TextView textView2 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (textView2 != null) {
                    i = moji.com.mjweather.R.id.iv_logo;
                    android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                    if (imageView != null) {
                        i = moji.com.mjweather.R.id.moji_weather;
                        android.widget.TextView textView3 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                        if (textView3 != null) {
                            i = moji.com.mjweather.R.id.scrollview_service_and_privacy;
                            android.widget.ScrollView scrollView = (android.widget.ScrollView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                            if (scrollView != null && (findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.service_and_privacy_bottom_mask))) != null) {
                                i = moji.com.mjweather.R.id.tv_service_and_privacy;
                                android.widget.TextView textView4 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                if (textView4 != null) {
                                    return new moji.com.mjweather.databinding.LayoutFirstPermissionDialogBinding((androidx.constraintlayout.widget.ConstraintLayout) view, findChildViewById2, textView, textView2, imageView, textView3, scrollView, findChildViewById, textView4);
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
    public static moji.com.mjweather.databinding.LayoutFirstPermissionDialogBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.LayoutFirstPermissionDialogBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.layout_first_permission_dialog, viewGroup, false);
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
