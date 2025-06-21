package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class ActivityAccountResetPassResultBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout n;

    @androidx.annotation.NonNull
    public final com.moji.titlebar.MJTitleBar titleBar;

    public ActivityAccountResetPassResultBinding(@androidx.annotation.NonNull android.widget.LinearLayout linearLayout, @androidx.annotation.NonNull com.moji.titlebar.MJTitleBar mJTitleBar) {
        this.n = linearLayout;
        this.titleBar = mJTitleBar;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ActivityAccountResetPassResultBinding bind(@androidx.annotation.NonNull android.view.View view) {
        int i = moji.com.mjweather.R.id.title_bar;
        com.moji.titlebar.MJTitleBar findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (findChildViewById != null) {
            return new moji.com.mjweather.databinding.ActivityAccountResetPassResultBinding((android.widget.LinearLayout) view, findChildViewById);
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ActivityAccountResetPassResultBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ActivityAccountResetPassResultBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.activity_account_reset_pass_result, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @androidx.annotation.NonNull
    public android.widget.LinearLayout getRoot() {
        return this.n;
    }
}
