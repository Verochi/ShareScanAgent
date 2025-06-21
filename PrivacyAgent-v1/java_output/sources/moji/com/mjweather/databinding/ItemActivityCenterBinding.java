package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class ItemActivityCenterBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.ImageView ivActivityImage;

    @androidx.annotation.NonNull
    public final android.widget.FrameLayout n;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvActivityAttendNum;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvActivityDescription;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvActivityTag;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvActivityTime;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvActivityTitle;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvActivityType;

    public ItemActivityCenterBinding(@androidx.annotation.NonNull android.widget.FrameLayout frameLayout, @androidx.annotation.NonNull android.widget.ImageView imageView, @androidx.annotation.NonNull android.widget.TextView textView, @androidx.annotation.NonNull android.widget.TextView textView2, @androidx.annotation.NonNull android.widget.TextView textView3, @androidx.annotation.NonNull android.widget.TextView textView4, @androidx.annotation.NonNull android.widget.TextView textView5, @androidx.annotation.NonNull android.widget.TextView textView6) {
        this.n = frameLayout;
        this.ivActivityImage = imageView;
        this.tvActivityAttendNum = textView;
        this.tvActivityDescription = textView2;
        this.tvActivityTag = textView3;
        this.tvActivityTime = textView4;
        this.tvActivityTitle = textView5;
        this.tvActivityType = textView6;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ItemActivityCenterBinding bind(@androidx.annotation.NonNull android.view.View view) {
        int i = moji.com.mjweather.R.id.iv_activity_image;
        android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = moji.com.mjweather.R.id.tv_activity_attend_num;
            android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = moji.com.mjweather.R.id.tv_activity_description;
                android.widget.TextView textView2 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (textView2 != null) {
                    i = moji.com.mjweather.R.id.tv_activity_tag;
                    android.widget.TextView textView3 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                    if (textView3 != null) {
                        i = moji.com.mjweather.R.id.tv_activity_time;
                        android.widget.TextView textView4 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                        if (textView4 != null) {
                            i = moji.com.mjweather.R.id.tv_activity_title;
                            android.widget.TextView textView5 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                            if (textView5 != null) {
                                i = moji.com.mjweather.R.id.tv_activity_type;
                                android.widget.TextView textView6 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                if (textView6 != null) {
                                    return new moji.com.mjweather.databinding.ItemActivityCenterBinding((android.widget.FrameLayout) view, imageView, textView, textView2, textView3, textView4, textView5, textView6);
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
    public static moji.com.mjweather.databinding.ItemActivityCenterBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ItemActivityCenterBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.item_activity_center, viewGroup, false);
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
