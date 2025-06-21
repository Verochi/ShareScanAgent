package moji.com.mjweatherservicebase.databinding;

/* loaded from: classes20.dex */
public final class RflowersItemSpotBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.TextView currStateTitle;

    @androidx.annotation.NonNull
    public final android.widget.FrameLayout flRight;

    @androidx.annotation.NonNull
    public final android.widget.TextView mCurrState;

    @androidx.annotation.NonNull
    public final android.widget.TextView mDistView;

    @androidx.annotation.NonNull
    public final android.view.View mDividerView;

    @androidx.annotation.NonNull
    public final com.moji.imageview.FourCornerImageView mImageView;

    @androidx.annotation.NonNull
    public final android.widget.TextView mLocView;

    @androidx.annotation.NonNull
    public final android.widget.TextView mNameView;

    @androidx.annotation.NonNull
    public final android.widget.TextView mNextState;

    @androidx.annotation.NonNull
    public final android.widget.TextView mVipView;

    @androidx.annotation.NonNull
    public final android.widget.RelativeLayout n;

    @androidx.annotation.NonNull
    public final android.widget.TextView nextStateTitle;

    public RflowersItemSpotBinding(@androidx.annotation.NonNull android.widget.RelativeLayout relativeLayout, @androidx.annotation.NonNull android.widget.TextView textView, @androidx.annotation.NonNull android.widget.FrameLayout frameLayout, @androidx.annotation.NonNull android.widget.TextView textView2, @androidx.annotation.NonNull android.widget.TextView textView3, @androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull com.moji.imageview.FourCornerImageView fourCornerImageView, @androidx.annotation.NonNull android.widget.TextView textView4, @androidx.annotation.NonNull android.widget.TextView textView5, @androidx.annotation.NonNull android.widget.TextView textView6, @androidx.annotation.NonNull android.widget.TextView textView7, @androidx.annotation.NonNull android.widget.TextView textView8) {
        this.n = relativeLayout;
        this.currStateTitle = textView;
        this.flRight = frameLayout;
        this.mCurrState = textView2;
        this.mDistView = textView3;
        this.mDividerView = view;
        this.mImageView = fourCornerImageView;
        this.mLocView = textView4;
        this.mNameView = textView5;
        this.mNextState = textView6;
        this.mVipView = textView7;
        this.nextStateTitle = textView8;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweatherservicebase.databinding.RflowersItemSpotBinding bind(@androidx.annotation.NonNull android.view.View view) {
        android.view.View findChildViewById;
        com.moji.imageview.FourCornerImageView findChildViewById2;
        int i = moji.com.mjweatherservicebase.R.id.currStateTitle;
        android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = moji.com.mjweatherservicebase.R.id.fl_right;
            android.widget.FrameLayout frameLayout = (android.widget.FrameLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (frameLayout != null) {
                i = moji.com.mjweatherservicebase.R.id.mCurrState;
                android.widget.TextView textView2 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (textView2 != null) {
                    i = moji.com.mjweatherservicebase.R.id.mDistView;
                    android.widget.TextView textView3 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                    if (textView3 != null && (findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweatherservicebase.R.id.mDividerView))) != null && (findChildViewById2 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweatherservicebase.R.id.mImageView))) != null) {
                        i = moji.com.mjweatherservicebase.R.id.mLocView;
                        android.widget.TextView textView4 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                        if (textView4 != null) {
                            i = moji.com.mjweatherservicebase.R.id.mNameView;
                            android.widget.TextView textView5 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                            if (textView5 != null) {
                                i = moji.com.mjweatherservicebase.R.id.mNextState;
                                android.widget.TextView textView6 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                if (textView6 != null) {
                                    i = moji.com.mjweatherservicebase.R.id.mVipView;
                                    android.widget.TextView textView7 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                    if (textView7 != null) {
                                        i = moji.com.mjweatherservicebase.R.id.nextStateTitle;
                                        android.widget.TextView textView8 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                        if (textView8 != null) {
                                            return new moji.com.mjweatherservicebase.databinding.RflowersItemSpotBinding((android.widget.RelativeLayout) view, textView, frameLayout, textView2, textView3, findChildViewById, findChildViewById2, textView4, textView5, textView6, textView7, textView8);
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
    public static moji.com.mjweatherservicebase.databinding.RflowersItemSpotBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweatherservicebase.databinding.RflowersItemSpotBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweatherservicebase.R.layout.rflowers_item_spot, viewGroup, false);
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
