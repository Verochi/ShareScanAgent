package moji.com.mjweatherservicebase.databinding;

/* loaded from: classes20.dex */
public final class LayoutHomepageRegionItemBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.TextView mRegionName;

    @androidx.annotation.NonNull
    public final android.widget.TextView mRegionNum;

    @androidx.annotation.NonNull
    public final androidx.constraintlayout.widget.ConstraintLayout n;

    public LayoutHomepageRegionItemBinding(@androidx.annotation.NonNull androidx.constraintlayout.widget.ConstraintLayout constraintLayout, @androidx.annotation.NonNull android.widget.TextView textView, @androidx.annotation.NonNull android.widget.TextView textView2) {
        this.n = constraintLayout;
        this.mRegionName = textView;
        this.mRegionNum = textView2;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweatherservicebase.databinding.LayoutHomepageRegionItemBinding bind(@androidx.annotation.NonNull android.view.View view) {
        int i = moji.com.mjweatherservicebase.R.id.mRegionName;
        android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = moji.com.mjweatherservicebase.R.id.mRegionNum;
            android.widget.TextView textView2 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (textView2 != null) {
                return new moji.com.mjweatherservicebase.databinding.LayoutHomepageRegionItemBinding((androidx.constraintlayout.widget.ConstraintLayout) view, textView, textView2);
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweatherservicebase.databinding.LayoutHomepageRegionItemBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweatherservicebase.databinding.LayoutHomepageRegionItemBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweatherservicebase.R.layout.layout_homepage_region_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @androidx.annotation.NonNull
    public androidx.constraintlayout.widget.ConstraintLayout getRoot() {
        return this.n;
    }
}
