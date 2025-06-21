package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class IncludeLoginBottomBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.ImageView ivLoginQq;

    @androidx.annotation.NonNull
    public final android.widget.ImageView ivLoginWechat;

    @androidx.annotation.NonNull
    public final android.widget.ImageView ivLoginWeibo;

    @androidx.annotation.NonNull
    public final android.view.View leftLine;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout llLoginQq;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout llLoginWechat;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout llLoginWeibo;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout n;

    @androidx.annotation.NonNull
    public final android.view.View rightLine;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout thirdPartLoginLayout;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvIndicate;

    public IncludeLoginBottomBinding(@androidx.annotation.NonNull android.widget.LinearLayout linearLayout, @androidx.annotation.NonNull android.widget.ImageView imageView, @androidx.annotation.NonNull android.widget.ImageView imageView2, @androidx.annotation.NonNull android.widget.ImageView imageView3, @androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull android.widget.LinearLayout linearLayout2, @androidx.annotation.NonNull android.widget.LinearLayout linearLayout3, @androidx.annotation.NonNull android.widget.LinearLayout linearLayout4, @androidx.annotation.NonNull android.view.View view2, @androidx.annotation.NonNull android.widget.LinearLayout linearLayout5, @androidx.annotation.NonNull android.widget.TextView textView) {
        this.n = linearLayout;
        this.ivLoginQq = imageView;
        this.ivLoginWechat = imageView2;
        this.ivLoginWeibo = imageView3;
        this.leftLine = view;
        this.llLoginQq = linearLayout2;
        this.llLoginWechat = linearLayout3;
        this.llLoginWeibo = linearLayout4;
        this.rightLine = view2;
        this.thirdPartLoginLayout = linearLayout5;
        this.tvIndicate = textView;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.IncludeLoginBottomBinding bind(@androidx.annotation.NonNull android.view.View view) {
        android.view.View findChildViewById;
        android.view.View findChildViewById2;
        int i = moji.com.mjweather.R.id.iv_login_qq;
        android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = moji.com.mjweather.R.id.iv_login_wechat;
            android.widget.ImageView imageView2 = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (imageView2 != null) {
                i = moji.com.mjweather.R.id.iv_login_weibo;
                android.widget.ImageView imageView3 = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (imageView3 != null && (findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.left_line))) != null) {
                    i = moji.com.mjweather.R.id.ll_login_qq;
                    android.widget.LinearLayout linearLayout = (android.widget.LinearLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                    if (linearLayout != null) {
                        i = moji.com.mjweather.R.id.ll_login_wechat;
                        android.widget.LinearLayout linearLayout2 = (android.widget.LinearLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                        if (linearLayout2 != null) {
                            i = moji.com.mjweather.R.id.ll_login_weibo;
                            android.widget.LinearLayout linearLayout3 = (android.widget.LinearLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                            if (linearLayout3 != null && (findChildViewById2 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.right_line))) != null) {
                                android.widget.LinearLayout linearLayout4 = (android.widget.LinearLayout) view;
                                i = moji.com.mjweather.R.id.tv_indicate;
                                android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                if (textView != null) {
                                    return new moji.com.mjweather.databinding.IncludeLoginBottomBinding(linearLayout4, imageView, imageView2, imageView3, findChildViewById, linearLayout, linearLayout2, linearLayout3, findChildViewById2, linearLayout4, textView);
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
    public static moji.com.mjweather.databinding.IncludeLoginBottomBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.IncludeLoginBottomBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.include_login_bottom, viewGroup, false);
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
