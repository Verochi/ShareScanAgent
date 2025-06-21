package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class ChatTextItemListBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.RelativeLayout n;

    @androidx.annotation.NonNull
    public final android.widget.RelativeLayout rlQuestion;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvText;

    public ChatTextItemListBinding(@androidx.annotation.NonNull android.widget.RelativeLayout relativeLayout, @androidx.annotation.NonNull android.widget.RelativeLayout relativeLayout2, @androidx.annotation.NonNull android.widget.TextView textView) {
        this.n = relativeLayout;
        this.rlQuestion = relativeLayout2;
        this.tvText = textView;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ChatTextItemListBinding bind(@androidx.annotation.NonNull android.view.View view) {
        android.widget.RelativeLayout relativeLayout = (android.widget.RelativeLayout) view;
        int i = moji.com.mjweather.R.id.tv_text;
        android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            return new moji.com.mjweather.databinding.ChatTextItemListBinding(relativeLayout, relativeLayout, textView);
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ChatTextItemListBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ChatTextItemListBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.chat_text_item_list, viewGroup, false);
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
