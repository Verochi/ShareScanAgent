package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class ActivityInternalTestApplicationBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.ImageView btnInternalApply;

    @androidx.annotation.NonNull
    public final android.widget.ListView lvImageview;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout n;

    @androidx.annotation.NonNull
    public final com.moji.titlebar.MJTitleBar titleLayout;

    @androidx.annotation.NonNull
    public final com.moji.multiplestatuslayout.MJMultipleStatusLayout viewStatusLayout;

    public ActivityInternalTestApplicationBinding(@androidx.annotation.NonNull android.widget.LinearLayout linearLayout, @androidx.annotation.NonNull android.widget.ImageView imageView, @androidx.annotation.NonNull android.widget.ListView listView, @androidx.annotation.NonNull com.moji.titlebar.MJTitleBar mJTitleBar, @androidx.annotation.NonNull com.moji.multiplestatuslayout.MJMultipleStatusLayout mJMultipleStatusLayout) {
        this.n = linearLayout;
        this.btnInternalApply = imageView;
        this.lvImageview = listView;
        this.titleLayout = mJTitleBar;
        this.viewStatusLayout = mJMultipleStatusLayout;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ActivityInternalTestApplicationBinding bind(@androidx.annotation.NonNull android.view.View view) {
        com.moji.titlebar.MJTitleBar findChildViewById;
        com.moji.multiplestatuslayout.MJMultipleStatusLayout findChildViewById2;
        int i = moji.com.mjweather.R.id.btn_internal_apply;
        android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = moji.com.mjweather.R.id.lv_imageview;
            android.widget.ListView listView = (android.widget.ListView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (listView != null && (findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.title_layout))) != null && (findChildViewById2 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.view_status_layout))) != null) {
                return new moji.com.mjweather.databinding.ActivityInternalTestApplicationBinding((android.widget.LinearLayout) view, imageView, listView, findChildViewById, findChildViewById2);
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ActivityInternalTestApplicationBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ActivityInternalTestApplicationBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.activity_internal_test_application, viewGroup, false);
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
