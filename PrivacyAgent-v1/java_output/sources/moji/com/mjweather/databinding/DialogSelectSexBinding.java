package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class DialogSelectSexBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.TextView btnSave;

    @androidx.annotation.NonNull
    public final android.widget.ImageView ivSelectMan;

    @androidx.annotation.NonNull
    public final android.widget.ImageView ivSelectWoman;

    @androidx.annotation.NonNull
    public final android.widget.ImageView ivSexMan;

    @androidx.annotation.NonNull
    public final android.widget.ImageView ivSexWoman;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout n;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvSelectMan;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvSelectWoman;

    @androidx.annotation.NonNull
    public final android.widget.RelativeLayout viewMan;

    @androidx.annotation.NonNull
    public final android.widget.RelativeLayout viewWoman;

    public DialogSelectSexBinding(@androidx.annotation.NonNull android.widget.LinearLayout linearLayout, @androidx.annotation.NonNull android.widget.TextView textView, @androidx.annotation.NonNull android.widget.ImageView imageView, @androidx.annotation.NonNull android.widget.ImageView imageView2, @androidx.annotation.NonNull android.widget.ImageView imageView3, @androidx.annotation.NonNull android.widget.ImageView imageView4, @androidx.annotation.NonNull android.widget.TextView textView2, @androidx.annotation.NonNull android.widget.TextView textView3, @androidx.annotation.NonNull android.widget.RelativeLayout relativeLayout, @androidx.annotation.NonNull android.widget.RelativeLayout relativeLayout2) {
        this.n = linearLayout;
        this.btnSave = textView;
        this.ivSelectMan = imageView;
        this.ivSelectWoman = imageView2;
        this.ivSexMan = imageView3;
        this.ivSexWoman = imageView4;
        this.tvSelectMan = textView2;
        this.tvSelectWoman = textView3;
        this.viewMan = relativeLayout;
        this.viewWoman = relativeLayout2;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.DialogSelectSexBinding bind(@androidx.annotation.NonNull android.view.View view) {
        int i = moji.com.mjweather.R.id.btn_save;
        android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = moji.com.mjweather.R.id.iv_select_man;
            android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = moji.com.mjweather.R.id.iv_select_woman;
                android.widget.ImageView imageView2 = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (imageView2 != null) {
                    i = moji.com.mjweather.R.id.iv_sex_man;
                    android.widget.ImageView imageView3 = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                    if (imageView3 != null) {
                        i = moji.com.mjweather.R.id.iv_sex_woman;
                        android.widget.ImageView imageView4 = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                        if (imageView4 != null) {
                            i = moji.com.mjweather.R.id.tv_select_man;
                            android.widget.TextView textView2 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                            if (textView2 != null) {
                                i = moji.com.mjweather.R.id.tv_select_woman;
                                android.widget.TextView textView3 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                if (textView3 != null) {
                                    i = moji.com.mjweather.R.id.view_man;
                                    android.widget.RelativeLayout relativeLayout = (android.widget.RelativeLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                    if (relativeLayout != null) {
                                        i = moji.com.mjweather.R.id.view_woman;
                                        android.widget.RelativeLayout relativeLayout2 = (android.widget.RelativeLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                        if (relativeLayout2 != null) {
                                            return new moji.com.mjweather.databinding.DialogSelectSexBinding((android.widget.LinearLayout) view, textView, imageView, imageView2, imageView3, imageView4, textView2, textView3, relativeLayout, relativeLayout2);
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
    public static moji.com.mjweather.databinding.DialogSelectSexBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.DialogSelectSexBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.dialog_select_sex, viewGroup, false);
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
