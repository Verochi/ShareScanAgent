package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class ViewAccountSettingCenterEmailDialogBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.TextView n;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvDialogContent;

    public ViewAccountSettingCenterEmailDialogBinding(@androidx.annotation.NonNull android.widget.TextView textView, @androidx.annotation.NonNull android.widget.TextView textView2) {
        this.n = textView;
        this.tvDialogContent = textView2;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ViewAccountSettingCenterEmailDialogBinding bind(@androidx.annotation.NonNull android.view.View view) {
        if (view == null) {
            throw new java.lang.NullPointerException("rootView");
        }
        android.widget.TextView textView = (android.widget.TextView) view;
        return new moji.com.mjweather.databinding.ViewAccountSettingCenterEmailDialogBinding(textView, textView);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ViewAccountSettingCenterEmailDialogBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ViewAccountSettingCenterEmailDialogBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.view_account_setting_center_email_dialog, viewGroup, false);
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
