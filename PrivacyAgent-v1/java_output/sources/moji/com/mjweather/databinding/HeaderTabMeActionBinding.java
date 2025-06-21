package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class HeaderTabMeActionBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout llFriendMessage;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout llMyMessage;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout llOffline;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout llOnline;

    @androidx.annotation.NonNull
    public final android.widget.FrameLayout n;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvFriendMomentIcon;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvFriendMomentTitle;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvMeMoMessage;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvMsgCount;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvNewMsg;

    public HeaderTabMeActionBinding(@androidx.annotation.NonNull android.widget.FrameLayout frameLayout, @androidx.annotation.NonNull android.widget.LinearLayout linearLayout, @androidx.annotation.NonNull android.widget.LinearLayout linearLayout2, @androidx.annotation.NonNull android.widget.LinearLayout linearLayout3, @androidx.annotation.NonNull android.widget.LinearLayout linearLayout4, @androidx.annotation.NonNull android.widget.TextView textView, @androidx.annotation.NonNull android.widget.TextView textView2, @androidx.annotation.NonNull android.widget.TextView textView3, @androidx.annotation.NonNull android.widget.TextView textView4, @androidx.annotation.NonNull android.widget.TextView textView5) {
        this.n = frameLayout;
        this.llFriendMessage = linearLayout;
        this.llMyMessage = linearLayout2;
        this.llOffline = linearLayout3;
        this.llOnline = linearLayout4;
        this.tvFriendMomentIcon = textView;
        this.tvFriendMomentTitle = textView2;
        this.tvMeMoMessage = textView3;
        this.tvMsgCount = textView4;
        this.tvNewMsg = textView5;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.HeaderTabMeActionBinding bind(@androidx.annotation.NonNull android.view.View view) {
        int i = moji.com.mjweather.R.id.ll_friend_message;
        android.widget.LinearLayout linearLayout = (android.widget.LinearLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (linearLayout != null) {
            i = moji.com.mjweather.R.id.ll_my_message;
            android.widget.LinearLayout linearLayout2 = (android.widget.LinearLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (linearLayout2 != null) {
                i = moji.com.mjweather.R.id.ll_offline;
                android.widget.LinearLayout linearLayout3 = (android.widget.LinearLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (linearLayout3 != null) {
                    i = moji.com.mjweather.R.id.ll_online;
                    android.widget.LinearLayout linearLayout4 = (android.widget.LinearLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                    if (linearLayout4 != null) {
                        i = moji.com.mjweather.R.id.tv_friend_moment_icon;
                        android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                        if (textView != null) {
                            i = moji.com.mjweather.R.id.tv_friend_moment_title;
                            android.widget.TextView textView2 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                            if (textView2 != null) {
                                i = moji.com.mjweather.R.id.tv_me_mo_message;
                                android.widget.TextView textView3 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                if (textView3 != null) {
                                    i = moji.com.mjweather.R.id.tv_msg_count;
                                    android.widget.TextView textView4 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                    if (textView4 != null) {
                                        i = moji.com.mjweather.R.id.tv_new_msg;
                                        android.widget.TextView textView5 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                        if (textView5 != null) {
                                            return new moji.com.mjweather.databinding.HeaderTabMeActionBinding((android.widget.FrameLayout) view, linearLayout, linearLayout2, linearLayout3, linearLayout4, textView, textView2, textView3, textView4, textView5);
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
    public static moji.com.mjweather.databinding.HeaderTabMeActionBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.HeaderTabMeActionBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.header_tab_me_action, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @androidx.annotation.NonNull
    public android.widget.FrameLayout getRoot() {
        return this.n;
    }
}
