package moji.com.mjweather.databinding;

/* loaded from: classes31.dex */
public final class ActivityFeedBackItemMsgTextLeftBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.ImageView ivSendFailed;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout llContent;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout llSendTime;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout n;

    @androidx.annotation.NonNull
    public final android.widget.ProgressBar pbFeebBack;

    @androidx.annotation.NonNull
    public final com.moji.imageview.FaceImageView rivUserhead;

    @androidx.annotation.NonNull
    public final android.widget.RelativeLayout rlContent;

    @androidx.annotation.NonNull
    public final android.widget.RelativeLayout rlLast;

    @androidx.annotation.NonNull
    public final androidx.recyclerview.widget.RecyclerView rvChatList;

    @androidx.annotation.NonNull
    public final android.view.View splitLine;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvChatcontent;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvHintContent;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvSendtime;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvUsername;

    public ActivityFeedBackItemMsgTextLeftBinding(@androidx.annotation.NonNull android.widget.LinearLayout linearLayout, @androidx.annotation.NonNull android.widget.ImageView imageView, @androidx.annotation.NonNull android.widget.LinearLayout linearLayout2, @androidx.annotation.NonNull android.widget.LinearLayout linearLayout3, @androidx.annotation.NonNull android.widget.ProgressBar progressBar, @androidx.annotation.NonNull com.moji.imageview.FaceImageView faceImageView, @androidx.annotation.NonNull android.widget.RelativeLayout relativeLayout, @androidx.annotation.NonNull android.widget.RelativeLayout relativeLayout2, @androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView recyclerView, @androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull android.widget.TextView textView, @androidx.annotation.NonNull android.widget.TextView textView2, @androidx.annotation.NonNull android.widget.TextView textView3, @androidx.annotation.NonNull android.widget.TextView textView4) {
        this.n = linearLayout;
        this.ivSendFailed = imageView;
        this.llContent = linearLayout2;
        this.llSendTime = linearLayout3;
        this.pbFeebBack = progressBar;
        this.rivUserhead = faceImageView;
        this.rlContent = relativeLayout;
        this.rlLast = relativeLayout2;
        this.rvChatList = recyclerView;
        this.splitLine = view;
        this.tvChatcontent = textView;
        this.tvHintContent = textView2;
        this.tvSendtime = textView3;
        this.tvUsername = textView4;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ActivityFeedBackItemMsgTextLeftBinding bind(@androidx.annotation.NonNull android.view.View view) {
        com.moji.imageview.FaceImageView findChildViewById;
        android.view.View findChildViewById2;
        int i = moji.com.mjweather.R.id.iv_send_failed;
        android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = moji.com.mjweather.R.id.ll_content;
            android.widget.LinearLayout linearLayout = (android.widget.LinearLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (linearLayout != null) {
                i = moji.com.mjweather.R.id.ll_send_time;
                android.widget.LinearLayout linearLayout2 = (android.widget.LinearLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (linearLayout2 != null) {
                    i = moji.com.mjweather.R.id.pb_feeb_back;
                    android.widget.ProgressBar progressBar = (android.widget.ProgressBar) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                    if (progressBar != null && (findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.riv_userhead))) != null) {
                        i = moji.com.mjweather.R.id.rl_content;
                        android.widget.RelativeLayout relativeLayout = (android.widget.RelativeLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                        if (relativeLayout != null) {
                            i = moji.com.mjweather.R.id.rl_last;
                            android.widget.RelativeLayout relativeLayout2 = (android.widget.RelativeLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                            if (relativeLayout2 != null) {
                                i = moji.com.mjweather.R.id.rv_chat_list;
                                androidx.recyclerview.widget.RecyclerView recyclerView = (androidx.recyclerview.widget.RecyclerView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                if (recyclerView != null && (findChildViewById2 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.split_line))) != null) {
                                    i = moji.com.mjweather.R.id.tv_chatcontent;
                                    android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                    if (textView != null) {
                                        i = moji.com.mjweather.R.id.tv_hint_content;
                                        android.widget.TextView textView2 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                        if (textView2 != null) {
                                            i = moji.com.mjweather.R.id.tv_sendtime;
                                            android.widget.TextView textView3 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                            if (textView3 != null) {
                                                i = moji.com.mjweather.R.id.tv_username;
                                                android.widget.TextView textView4 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                                if (textView4 != null) {
                                                    return new moji.com.mjweather.databinding.ActivityFeedBackItemMsgTextLeftBinding((android.widget.LinearLayout) view, imageView, linearLayout, linearLayout2, progressBar, findChildViewById, relativeLayout, relativeLayout2, recyclerView, findChildViewById2, textView, textView2, textView3, textView4);
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
    public static moji.com.mjweather.databinding.ActivityFeedBackItemMsgTextLeftBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ActivityFeedBackItemMsgTextLeftBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.activity_feed_back_item_msg_text_left, viewGroup, false);
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
