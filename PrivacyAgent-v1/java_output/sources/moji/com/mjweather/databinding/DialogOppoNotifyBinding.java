package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class DialogOppoNotifyBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final androidx.constraintlayout.widget.ConstraintLayout n;

    @androidx.annotation.NonNull
    public final android.widget.ImageView notifyImage;

    @androidx.annotation.NonNull
    public final android.widget.TextView notifySlogan;

    @androidx.annotation.NonNull
    public final android.widget.TextView notifyText;

    @androidx.annotation.NonNull
    public final android.widget.TextView oppoNotifyNegative;

    @androidx.annotation.NonNull
    public final android.widget.TextView oppoNotifyPositive;

    public DialogOppoNotifyBinding(@androidx.annotation.NonNull androidx.constraintlayout.widget.ConstraintLayout constraintLayout, @androidx.annotation.NonNull android.widget.ImageView imageView, @androidx.annotation.NonNull android.widget.TextView textView, @androidx.annotation.NonNull android.widget.TextView textView2, @androidx.annotation.NonNull android.widget.TextView textView3, @androidx.annotation.NonNull android.widget.TextView textView4) {
        this.n = constraintLayout;
        this.notifyImage = imageView;
        this.notifySlogan = textView;
        this.notifyText = textView2;
        this.oppoNotifyNegative = textView3;
        this.oppoNotifyPositive = textView4;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.DialogOppoNotifyBinding bind(@androidx.annotation.NonNull android.view.View view) {
        int i = moji.com.mjweather.R.id.notify_image;
        android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = moji.com.mjweather.R.id.notify_slogan;
            android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = moji.com.mjweather.R.id.notify_text;
                android.widget.TextView textView2 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (textView2 != null) {
                    i = moji.com.mjweather.R.id.oppo_notify_negative;
                    android.widget.TextView textView3 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                    if (textView3 != null) {
                        i = moji.com.mjweather.R.id.oppo_notify_positive;
                        android.widget.TextView textView4 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                        if (textView4 != null) {
                            return new moji.com.mjweather.databinding.DialogOppoNotifyBinding((androidx.constraintlayout.widget.ConstraintLayout) view, imageView, textView, textView2, textView3, textView4);
                        }
                    }
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.DialogOppoNotifyBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.DialogOppoNotifyBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.dialog_oppo_notify, viewGroup, false);
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
