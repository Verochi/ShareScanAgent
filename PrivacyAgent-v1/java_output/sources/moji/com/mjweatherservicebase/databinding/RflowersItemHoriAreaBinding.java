package moji.com.mjweatherservicebase.databinding;

/* loaded from: classes20.dex */
public final class RflowersItemHoriAreaBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.TextView mAreaView;

    @androidx.annotation.NonNull
    public final android.widget.TextView mDistanceView;

    @androidx.annotation.NonNull
    public final com.moji.imageview.RoundCornerImageView mImageView;

    @androidx.annotation.NonNull
    public final com.moji.outline.RoundRectOutLineLayout mMoreView;

    @androidx.annotation.NonNull
    public final android.view.View mParentLayout;

    @androidx.annotation.NonNull
    public final android.widget.FrameLayout n;

    public RflowersItemHoriAreaBinding(@androidx.annotation.NonNull android.widget.FrameLayout frameLayout, @androidx.annotation.NonNull android.widget.TextView textView, @androidx.annotation.NonNull android.widget.TextView textView2, @androidx.annotation.NonNull com.moji.imageview.RoundCornerImageView roundCornerImageView, @androidx.annotation.NonNull com.moji.outline.RoundRectOutLineLayout roundRectOutLineLayout, @androidx.annotation.NonNull android.view.View view) {
        this.n = frameLayout;
        this.mAreaView = textView;
        this.mDistanceView = textView2;
        this.mImageView = roundCornerImageView;
        this.mMoreView = roundRectOutLineLayout;
        this.mParentLayout = view;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweatherservicebase.databinding.RflowersItemHoriAreaBinding bind(@androidx.annotation.NonNull android.view.View view) {
        com.moji.imageview.RoundCornerImageView findChildViewById;
        com.moji.outline.RoundRectOutLineLayout findChildViewById2;
        android.view.View findChildViewById3;
        int i = moji.com.mjweatherservicebase.R.id.mAreaView;
        android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = moji.com.mjweatherservicebase.R.id.mDistanceView;
            android.widget.TextView textView2 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (textView2 != null && (findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweatherservicebase.R.id.mImageView))) != null && (findChildViewById2 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweatherservicebase.R.id.mMoreView))) != null && (findChildViewById3 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweatherservicebase.R.id.mParentLayout))) != null) {
                return new moji.com.mjweatherservicebase.databinding.RflowersItemHoriAreaBinding((android.widget.FrameLayout) view, textView, textView2, findChildViewById, findChildViewById2, findChildViewById3);
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweatherservicebase.databinding.RflowersItemHoriAreaBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweatherservicebase.databinding.RflowersItemHoriAreaBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweatherservicebase.R.layout.rflowers_item_hori_area, viewGroup, false);
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
