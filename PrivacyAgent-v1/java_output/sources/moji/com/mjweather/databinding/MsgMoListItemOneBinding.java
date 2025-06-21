package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class MsgMoListItemOneBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.ImageView ivBottomLine;

    @androidx.annotation.NonNull
    public final android.widget.ImageView ivMsgMoPicture;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout llMoMsgTop;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout llMsgBottomDetail;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout llMsgMoCheckDetail;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout n;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvMsgMoContent;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvMsgMoDetail;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvMsgMoTime;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvMsgMoTitle;

    public MsgMoListItemOneBinding(@androidx.annotation.NonNull android.widget.LinearLayout linearLayout, @androidx.annotation.NonNull android.widget.ImageView imageView, @androidx.annotation.NonNull android.widget.ImageView imageView2, @androidx.annotation.NonNull android.widget.LinearLayout linearLayout2, @androidx.annotation.NonNull android.widget.LinearLayout linearLayout3, @androidx.annotation.NonNull android.widget.LinearLayout linearLayout4, @androidx.annotation.NonNull android.widget.TextView textView, @androidx.annotation.NonNull android.widget.TextView textView2, @androidx.annotation.NonNull android.widget.TextView textView3, @androidx.annotation.NonNull android.widget.TextView textView4) {
        this.n = linearLayout;
        this.ivBottomLine = imageView;
        this.ivMsgMoPicture = imageView2;
        this.llMoMsgTop = linearLayout2;
        this.llMsgBottomDetail = linearLayout3;
        this.llMsgMoCheckDetail = linearLayout4;
        this.tvMsgMoContent = textView;
        this.tvMsgMoDetail = textView2;
        this.tvMsgMoTime = textView3;
        this.tvMsgMoTitle = textView4;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.MsgMoListItemOneBinding bind(@androidx.annotation.NonNull android.view.View view) {
        int i = moji.com.mjweather.R.id.iv_bottom_line;
        android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = moji.com.mjweather.R.id.iv_msg_mo_picture;
            android.widget.ImageView imageView2 = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (imageView2 != null) {
                i = moji.com.mjweather.R.id.ll_mo_msg_top;
                android.widget.LinearLayout linearLayout = (android.widget.LinearLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (linearLayout != null) {
                    i = moji.com.mjweather.R.id.ll_msg_bottom_detail;
                    android.widget.LinearLayout linearLayout2 = (android.widget.LinearLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                    if (linearLayout2 != null) {
                        i = moji.com.mjweather.R.id.ll_msg_mo_check_detail;
                        android.widget.LinearLayout linearLayout3 = (android.widget.LinearLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                        if (linearLayout3 != null) {
                            i = moji.com.mjweather.R.id.tv_msg_mo_content;
                            android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                            if (textView != null) {
                                i = moji.com.mjweather.R.id.tv_msg_mo_detail;
                                android.widget.TextView textView2 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                if (textView2 != null) {
                                    i = moji.com.mjweather.R.id.tv_msg_mo_time;
                                    android.widget.TextView textView3 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                    if (textView3 != null) {
                                        i = moji.com.mjweather.R.id.tv_msg_mo_title;
                                        android.widget.TextView textView4 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                        if (textView4 != null) {
                                            return new moji.com.mjweather.databinding.MsgMoListItemOneBinding((android.widget.LinearLayout) view, imageView, imageView2, linearLayout, linearLayout2, linearLayout3, textView, textView2, textView3, textView4);
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
    public static moji.com.mjweather.databinding.MsgMoListItemOneBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.MsgMoListItemOneBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.msg_mo_list_item_one, viewGroup, false);
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
