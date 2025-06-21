package moji.com.mjweatherservicebase.databinding;

/* loaded from: classes20.dex */
public final class LayoutHomepageNearspotBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.TextView label;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout mEmptyView;

    @androidx.annotation.NonNull
    public final android.widget.ImageView mMoreView;

    @androidx.annotation.NonNull
    public final com.moji.recyclerview.HorizontalRecyclerView mRecyclerView;

    @androidx.annotation.NonNull
    public final android.widget.RelativeLayout n;

    public LayoutHomepageNearspotBinding(@androidx.annotation.NonNull android.widget.RelativeLayout relativeLayout, @androidx.annotation.NonNull android.widget.TextView textView, @androidx.annotation.NonNull android.widget.LinearLayout linearLayout, @androidx.annotation.NonNull android.widget.ImageView imageView, @androidx.annotation.NonNull com.moji.recyclerview.HorizontalRecyclerView horizontalRecyclerView) {
        this.n = relativeLayout;
        this.label = textView;
        this.mEmptyView = linearLayout;
        this.mMoreView = imageView;
        this.mRecyclerView = horizontalRecyclerView;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweatherservicebase.databinding.LayoutHomepageNearspotBinding bind(@androidx.annotation.NonNull android.view.View view) {
        com.moji.recyclerview.HorizontalRecyclerView findChildViewById;
        int i = moji.com.mjweatherservicebase.R.id.label;
        android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = moji.com.mjweatherservicebase.R.id.mEmptyView;
            android.widget.LinearLayout linearLayout = (android.widget.LinearLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (linearLayout != null) {
                i = moji.com.mjweatherservicebase.R.id.mMoreView;
                android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (imageView != null && (findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweatherservicebase.R.id.mRecyclerView))) != null) {
                    return new moji.com.mjweatherservicebase.databinding.LayoutHomepageNearspotBinding((android.widget.RelativeLayout) view, textView, linearLayout, imageView, findChildViewById);
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweatherservicebase.databinding.LayoutHomepageNearspotBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweatherservicebase.databinding.LayoutHomepageNearspotBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweatherservicebase.R.layout.layout_homepage_nearspot, viewGroup, false);
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
