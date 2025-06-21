package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class ChatWelcomeItemListBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.RelativeLayout n;

    @androidx.annotation.NonNull
    public final android.widget.TextView question;

    @androidx.annotation.NonNull
    public final android.widget.ImageView rightArrow;

    @androidx.annotation.NonNull
    public final android.widget.RelativeLayout rlQuestion;

    public ChatWelcomeItemListBinding(@androidx.annotation.NonNull android.widget.RelativeLayout relativeLayout, @androidx.annotation.NonNull android.widget.TextView textView, @androidx.annotation.NonNull android.widget.ImageView imageView, @androidx.annotation.NonNull android.widget.RelativeLayout relativeLayout2) {
        this.n = relativeLayout;
        this.question = textView;
        this.rightArrow = imageView;
        this.rlQuestion = relativeLayout2;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ChatWelcomeItemListBinding bind(@androidx.annotation.NonNull android.view.View view) {
        int i = moji.com.mjweather.R.id.question;
        android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = moji.com.mjweather.R.id.rightArrow;
            android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                android.widget.RelativeLayout relativeLayout = (android.widget.RelativeLayout) view;
                return new moji.com.mjweather.databinding.ChatWelcomeItemListBinding(relativeLayout, textView, imageView, relativeLayout);
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ChatWelcomeItemListBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ChatWelcomeItemListBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.chat_welcome_item_list, viewGroup, false);
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
