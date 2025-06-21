package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class ActivityActivityCenterBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.ListView lvActivityCenter;

    @androidx.annotation.NonNull
    public final com.moji.titlebar.MJTitleBar mjTitleBar;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout n;

    @androidx.annotation.NonNull
    public final com.moji.multiplestatuslayout.MJMultipleStatusLayout statusLayout;

    public ActivityActivityCenterBinding(@androidx.annotation.NonNull android.widget.LinearLayout linearLayout, @androidx.annotation.NonNull android.widget.ListView listView, @androidx.annotation.NonNull com.moji.titlebar.MJTitleBar mJTitleBar, @androidx.annotation.NonNull com.moji.multiplestatuslayout.MJMultipleStatusLayout mJMultipleStatusLayout) {
        this.n = linearLayout;
        this.lvActivityCenter = listView;
        this.mjTitleBar = mJTitleBar;
        this.statusLayout = mJMultipleStatusLayout;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ActivityActivityCenterBinding bind(@androidx.annotation.NonNull android.view.View view) {
        com.moji.titlebar.MJTitleBar findChildViewById;
        com.moji.multiplestatuslayout.MJMultipleStatusLayout findChildViewById2;
        int i = moji.com.mjweather.R.id.lv_activity_center;
        android.widget.ListView listView = (android.widget.ListView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (listView == null || (findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.mj_title_bar))) == null || (findChildViewById2 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.status_layout))) == null) {
            throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new moji.com.mjweather.databinding.ActivityActivityCenterBinding((android.widget.LinearLayout) view, listView, findChildViewById, findChildViewById2);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ActivityActivityCenterBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ActivityActivityCenterBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.activity_activity_center, viewGroup, false);
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
