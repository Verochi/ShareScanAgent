package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class FeedBackItemMsgPicBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.ImageView ivChatcontent;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout llContent;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout llSendTime;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout n;

    @androidx.annotation.NonNull
    public final com.moji.imageview.FaceImageView rivUserhead;

    @androidx.annotation.NonNull
    public final android.widget.RelativeLayout rlContent;

    @androidx.annotation.NonNull
    public final android.widget.RelativeLayout rlLast;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvSendtime;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvUsername;

    public FeedBackItemMsgPicBinding(@androidx.annotation.NonNull android.widget.LinearLayout linearLayout, @androidx.annotation.NonNull android.widget.ImageView imageView, @androidx.annotation.NonNull android.widget.LinearLayout linearLayout2, @androidx.annotation.NonNull android.widget.LinearLayout linearLayout3, @androidx.annotation.NonNull com.moji.imageview.FaceImageView faceImageView, @androidx.annotation.NonNull android.widget.RelativeLayout relativeLayout, @androidx.annotation.NonNull android.widget.RelativeLayout relativeLayout2, @androidx.annotation.NonNull android.widget.TextView textView, @androidx.annotation.NonNull android.widget.TextView textView2) {
        this.n = linearLayout;
        this.ivChatcontent = imageView;
        this.llContent = linearLayout2;
        this.llSendTime = linearLayout3;
        this.rivUserhead = faceImageView;
        this.rlContent = relativeLayout;
        this.rlLast = relativeLayout2;
        this.tvSendtime = textView;
        this.tvUsername = textView2;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.FeedBackItemMsgPicBinding bind(@androidx.annotation.NonNull android.view.View view) {
        com.moji.imageview.FaceImageView findChildViewById;
        int i = moji.com.mjweather.R.id.iv_chatcontent;
        android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = moji.com.mjweather.R.id.ll_content;
            android.widget.LinearLayout linearLayout = (android.widget.LinearLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (linearLayout != null) {
                i = moji.com.mjweather.R.id.ll_send_time;
                android.widget.LinearLayout linearLayout2 = (android.widget.LinearLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (linearLayout2 != null && (findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.riv_userhead))) != null) {
                    i = moji.com.mjweather.R.id.rl_content;
                    android.widget.RelativeLayout relativeLayout = (android.widget.RelativeLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                    if (relativeLayout != null) {
                        i = moji.com.mjweather.R.id.rl_last;
                        android.widget.RelativeLayout relativeLayout2 = (android.widget.RelativeLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                        if (relativeLayout2 != null) {
                            i = moji.com.mjweather.R.id.tv_sendtime;
                            android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                            if (textView != null) {
                                i = moji.com.mjweather.R.id.tv_username;
                                android.widget.TextView textView2 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                if (textView2 != null) {
                                    return new moji.com.mjweather.databinding.FeedBackItemMsgPicBinding((android.widget.LinearLayout) view, imageView, linearLayout, linearLayout2, findChildViewById, relativeLayout, relativeLayout2, textView, textView2);
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
    public static moji.com.mjweather.databinding.FeedBackItemMsgPicBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.FeedBackItemMsgPicBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.feed_back_item_msg_pic, viewGroup, false);
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
