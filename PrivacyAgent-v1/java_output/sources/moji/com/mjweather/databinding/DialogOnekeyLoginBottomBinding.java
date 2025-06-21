package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class DialogOnekeyLoginBottomBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.CheckBox cbTreaty;

    @androidx.annotation.NonNull
    public final android.widget.ImageView mCloseView;

    @androidx.annotation.NonNull
    public final androidx.constraintlayout.widget.ConstraintLayout n;

    @androidx.annotation.NonNull
    public final com.moji.imageview.FourCornerImageView onekeyLoginBottomDialogBg;

    @androidx.annotation.NonNull
    public final com.moji.imageview.FourCornerImageView onekeyLoginBottomDialogCoverImg;

    @androidx.annotation.NonNull
    public final android.widget.TextView phoneNumber;

    @androidx.annotation.NonNull
    public final android.widget.RelativeLayout treatyLayout;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvLogBtn;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvOtherLogin;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvProtocolName;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvTreaty;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvTreatyTip;

    @androidx.annotation.NonNull
    public final android.widget.TextView welcomTv;

    public DialogOnekeyLoginBottomBinding(@androidx.annotation.NonNull androidx.constraintlayout.widget.ConstraintLayout constraintLayout, @androidx.annotation.NonNull android.widget.CheckBox checkBox, @androidx.annotation.NonNull android.widget.ImageView imageView, @androidx.annotation.NonNull com.moji.imageview.FourCornerImageView fourCornerImageView, @androidx.annotation.NonNull com.moji.imageview.FourCornerImageView fourCornerImageView2, @androidx.annotation.NonNull android.widget.TextView textView, @androidx.annotation.NonNull android.widget.RelativeLayout relativeLayout, @androidx.annotation.NonNull android.widget.TextView textView2, @androidx.annotation.NonNull android.widget.TextView textView3, @androidx.annotation.NonNull android.widget.TextView textView4, @androidx.annotation.NonNull android.widget.TextView textView5, @androidx.annotation.NonNull android.widget.TextView textView6, @androidx.annotation.NonNull android.widget.TextView textView7) {
        this.n = constraintLayout;
        this.cbTreaty = checkBox;
        this.mCloseView = imageView;
        this.onekeyLoginBottomDialogBg = fourCornerImageView;
        this.onekeyLoginBottomDialogCoverImg = fourCornerImageView2;
        this.phoneNumber = textView;
        this.treatyLayout = relativeLayout;
        this.tvLogBtn = textView2;
        this.tvOtherLogin = textView3;
        this.tvProtocolName = textView4;
        this.tvTreaty = textView5;
        this.tvTreatyTip = textView6;
        this.welcomTv = textView7;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.DialogOnekeyLoginBottomBinding bind(@androidx.annotation.NonNull android.view.View view) {
        com.moji.imageview.FourCornerImageView findChildViewById;
        com.moji.imageview.FourCornerImageView findChildViewById2;
        int i = moji.com.mjweather.R.id.cbTreaty;
        android.widget.CheckBox checkBox = (android.widget.CheckBox) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (checkBox != null) {
            i = moji.com.mjweather.R.id.mCloseView;
            android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (imageView != null && (findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.onekeyLoginBottomDialogBg))) != null && (findChildViewById2 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.onekeyLoginBottomDialogCoverImg))) != null) {
                i = moji.com.mjweather.R.id.phoneNumber;
                android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = moji.com.mjweather.R.id.treatyLayout;
                    android.widget.RelativeLayout relativeLayout = (android.widget.RelativeLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                    if (relativeLayout != null) {
                        i = moji.com.mjweather.R.id.tvLogBtn;
                        android.widget.TextView textView2 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                        if (textView2 != null) {
                            i = moji.com.mjweather.R.id.tvOtherLogin;
                            android.widget.TextView textView3 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                            if (textView3 != null) {
                                i = moji.com.mjweather.R.id.tvProtocolName;
                                android.widget.TextView textView4 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                if (textView4 != null) {
                                    i = moji.com.mjweather.R.id.tvTreaty;
                                    android.widget.TextView textView5 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                    if (textView5 != null) {
                                        i = moji.com.mjweather.R.id.tvTreatyTip;
                                        android.widget.TextView textView6 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                        if (textView6 != null) {
                                            i = moji.com.mjweather.R.id.welcomTv;
                                            android.widget.TextView textView7 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                            if (textView7 != null) {
                                                return new moji.com.mjweather.databinding.DialogOnekeyLoginBottomBinding((androidx.constraintlayout.widget.ConstraintLayout) view, checkBox, imageView, findChildViewById, findChildViewById2, textView, relativeLayout, textView2, textView3, textView4, textView5, textView6, textView7);
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
    public static moji.com.mjweather.databinding.DialogOnekeyLoginBottomBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.DialogOnekeyLoginBottomBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.dialog_onekey_login_bottom, viewGroup, false);
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
