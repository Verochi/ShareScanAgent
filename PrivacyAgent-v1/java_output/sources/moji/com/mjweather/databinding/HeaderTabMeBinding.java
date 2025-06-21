package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class HeaderTabMeBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final com.moji.imageview.FaceImageView ivHead;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout llAction;

    @androidx.annotation.NonNull
    public final android.widget.FrameLayout n;

    @androidx.annotation.NonNull
    public final android.widget.RelativeLayout rlOffline;

    @androidx.annotation.NonNull
    public final android.widget.RelativeLayout rlOnline;

    @androidx.annotation.NonNull
    public final android.widget.ImageView tvLoginPhone;

    @androidx.annotation.NonNull
    public final android.widget.ImageView tvLoginQq;

    @androidx.annotation.NonNull
    public final android.widget.ImageView tvLoginWechat;

    @androidx.annotation.NonNull
    public final android.widget.ImageView tvLoginWeibo;

    @androidx.annotation.NonNull
    public final android.widget.ImageView tvLoginXiaomi;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvMoreInfo;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvNick;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvSign;

    public HeaderTabMeBinding(@androidx.annotation.NonNull android.widget.FrameLayout frameLayout, @androidx.annotation.NonNull com.moji.imageview.FaceImageView faceImageView, @androidx.annotation.NonNull android.widget.LinearLayout linearLayout, @androidx.annotation.NonNull android.widget.RelativeLayout relativeLayout, @androidx.annotation.NonNull android.widget.RelativeLayout relativeLayout2, @androidx.annotation.NonNull android.widget.ImageView imageView, @androidx.annotation.NonNull android.widget.ImageView imageView2, @androidx.annotation.NonNull android.widget.ImageView imageView3, @androidx.annotation.NonNull android.widget.ImageView imageView4, @androidx.annotation.NonNull android.widget.ImageView imageView5, @androidx.annotation.NonNull android.widget.TextView textView, @androidx.annotation.NonNull android.widget.TextView textView2, @androidx.annotation.NonNull android.widget.TextView textView3) {
        this.n = frameLayout;
        this.ivHead = faceImageView;
        this.llAction = linearLayout;
        this.rlOffline = relativeLayout;
        this.rlOnline = relativeLayout2;
        this.tvLoginPhone = imageView;
        this.tvLoginQq = imageView2;
        this.tvLoginWechat = imageView3;
        this.tvLoginWeibo = imageView4;
        this.tvLoginXiaomi = imageView5;
        this.tvMoreInfo = textView;
        this.tvNick = textView2;
        this.tvSign = textView3;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.HeaderTabMeBinding bind(@androidx.annotation.NonNull android.view.View view) {
        int i = moji.com.mjweather.R.id.iv_head;
        com.moji.imageview.FaceImageView findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (findChildViewById != null) {
            i = moji.com.mjweather.R.id.ll_action;
            android.widget.LinearLayout linearLayout = (android.widget.LinearLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (linearLayout != null) {
                i = moji.com.mjweather.R.id.rl_offline;
                android.widget.RelativeLayout relativeLayout = (android.widget.RelativeLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (relativeLayout != null) {
                    i = moji.com.mjweather.R.id.rl_online;
                    android.widget.RelativeLayout relativeLayout2 = (android.widget.RelativeLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                    if (relativeLayout2 != null) {
                        i = moji.com.mjweather.R.id.tv_login_phone;
                        android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                        if (imageView != null) {
                            i = moji.com.mjweather.R.id.tv_login_qq;
                            android.widget.ImageView imageView2 = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                            if (imageView2 != null) {
                                i = moji.com.mjweather.R.id.tv_login_wechat;
                                android.widget.ImageView imageView3 = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                if (imageView3 != null) {
                                    i = moji.com.mjweather.R.id.tv_login_weibo;
                                    android.widget.ImageView imageView4 = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                    if (imageView4 != null) {
                                        i = moji.com.mjweather.R.id.tv_login_xiaomi;
                                        android.widget.ImageView imageView5 = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                        if (imageView5 != null) {
                                            i = moji.com.mjweather.R.id.tv_more_info;
                                            android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                            if (textView != null) {
                                                i = moji.com.mjweather.R.id.tv_nick;
                                                android.widget.TextView textView2 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                                if (textView2 != null) {
                                                    i = moji.com.mjweather.R.id.tv_sign;
                                                    android.widget.TextView textView3 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                                    if (textView3 != null) {
                                                        return new moji.com.mjweather.databinding.HeaderTabMeBinding((android.widget.FrameLayout) view, findChildViewById, linearLayout, relativeLayout, relativeLayout2, imageView, imageView2, imageView3, imageView4, imageView5, textView, textView2, textView3);
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
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.HeaderTabMeBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.HeaderTabMeBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.header_tab_me, viewGroup, false);
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
