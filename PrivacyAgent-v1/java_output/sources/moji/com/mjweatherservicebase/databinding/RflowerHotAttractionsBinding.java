package moji.com.mjweatherservicebase.databinding;

/* loaded from: classes20.dex */
public final class RflowerHotAttractionsBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.TextView label;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout mItemContainer;

    @androidx.annotation.NonNull
    public final android.widget.TextView mTopArea;

    @androidx.annotation.NonNull
    public final android.widget.ImageView mTopImageView;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout mTopInfoView;

    @androidx.annotation.NonNull
    public final android.widget.TextView mTopName;

    @androidx.annotation.NonNull
    public final android.widget.TextView mTopState;

    @androidx.annotation.NonNull
    public final android.widget.RelativeLayout n;

    public RflowerHotAttractionsBinding(@androidx.annotation.NonNull android.widget.RelativeLayout relativeLayout, @androidx.annotation.NonNull android.widget.TextView textView, @androidx.annotation.NonNull android.widget.LinearLayout linearLayout, @androidx.annotation.NonNull android.widget.TextView textView2, @androidx.annotation.NonNull android.widget.ImageView imageView, @androidx.annotation.NonNull android.widget.LinearLayout linearLayout2, @androidx.annotation.NonNull android.widget.TextView textView3, @androidx.annotation.NonNull android.widget.TextView textView4) {
        this.n = relativeLayout;
        this.label = textView;
        this.mItemContainer = linearLayout;
        this.mTopArea = textView2;
        this.mTopImageView = imageView;
        this.mTopInfoView = linearLayout2;
        this.mTopName = textView3;
        this.mTopState = textView4;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweatherservicebase.databinding.RflowerHotAttractionsBinding bind(@androidx.annotation.NonNull android.view.View view) {
        int i = moji.com.mjweatherservicebase.R.id.label;
        android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = moji.com.mjweatherservicebase.R.id.mItemContainer;
            android.widget.LinearLayout linearLayout = (android.widget.LinearLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (linearLayout != null) {
                i = moji.com.mjweatherservicebase.R.id.mTopArea;
                android.widget.TextView textView2 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (textView2 != null) {
                    i = moji.com.mjweatherservicebase.R.id.mTopImageView;
                    android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                    if (imageView != null) {
                        i = moji.com.mjweatherservicebase.R.id.mTopInfoView;
                        android.widget.LinearLayout linearLayout2 = (android.widget.LinearLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                        if (linearLayout2 != null) {
                            i = moji.com.mjweatherservicebase.R.id.mTopName;
                            android.widget.TextView textView3 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                            if (textView3 != null) {
                                i = moji.com.mjweatherservicebase.R.id.mTopState;
                                android.widget.TextView textView4 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                if (textView4 != null) {
                                    return new moji.com.mjweatherservicebase.databinding.RflowerHotAttractionsBinding((android.widget.RelativeLayout) view, textView, linearLayout, textView2, imageView, linearLayout2, textView3, textView4);
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
    public static moji.com.mjweatherservicebase.databinding.RflowerHotAttractionsBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweatherservicebase.databinding.RflowerHotAttractionsBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweatherservicebase.R.layout.rflower_hot_attractions, viewGroup, false);
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
