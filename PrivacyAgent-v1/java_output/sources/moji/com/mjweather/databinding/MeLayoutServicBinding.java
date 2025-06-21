package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class MeLayoutServicBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final androidx.constraintlayout.widget.ConstraintLayout area;

    @androidx.annotation.NonNull
    public final com.moji.textview.MJTextView city;

    @androidx.annotation.NonNull
    public final com.moji.ExpandGridView gridview;

    @androidx.annotation.NonNull
    public final com.moji.textview.MJTextView label;

    @androidx.annotation.NonNull
    public final android.widget.ImageView locationIcon;

    @androidx.annotation.NonNull
    public final android.widget.FrameLayout n;

    public MeLayoutServicBinding(@androidx.annotation.NonNull android.widget.FrameLayout frameLayout, @androidx.annotation.NonNull androidx.constraintlayout.widget.ConstraintLayout constraintLayout, @androidx.annotation.NonNull com.moji.textview.MJTextView mJTextView, @androidx.annotation.NonNull com.moji.ExpandGridView expandGridView, @androidx.annotation.NonNull com.moji.textview.MJTextView mJTextView2, @androidx.annotation.NonNull android.widget.ImageView imageView) {
        this.n = frameLayout;
        this.area = constraintLayout;
        this.city = mJTextView;
        this.gridview = expandGridView;
        this.label = mJTextView2;
        this.locationIcon = imageView;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.MeLayoutServicBinding bind(@androidx.annotation.NonNull android.view.View view) {
        com.moji.textview.MJTextView findChildViewById;
        com.moji.ExpandGridView findChildViewById2;
        com.moji.textview.MJTextView findChildViewById3;
        int i = moji.com.mjweather.R.id.area;
        androidx.constraintlayout.widget.ConstraintLayout constraintLayout = (androidx.constraintlayout.widget.ConstraintLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (constraintLayout != null && (findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.city))) != null && (findChildViewById2 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.gridview))) != null && (findChildViewById3 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.label))) != null) {
            i = moji.com.mjweather.R.id.location_icon;
            android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                return new moji.com.mjweather.databinding.MeLayoutServicBinding((android.widget.FrameLayout) view, constraintLayout, findChildViewById, findChildViewById2, findChildViewById3, imageView);
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.MeLayoutServicBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.MeLayoutServicBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.me_layout_servic, viewGroup, false);
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
