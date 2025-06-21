package moji.com.mjweatherservicebase.databinding;

/* loaded from: classes20.dex */
public final class ActivityRflowersSpotBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.TextView mLabelView;

    @androidx.annotation.NonNull
    public final androidx.recyclerview.widget.RecyclerView mRecyclerView;

    @androidx.annotation.NonNull
    public final com.moji.multiplestatuslayout.MJMultipleStatusLayout mStatusView;

    @androidx.annotation.NonNull
    public final com.moji.titlebar.MJTitleBar mTitle;

    @androidx.annotation.NonNull
    public final android.widget.RelativeLayout n;

    public ActivityRflowersSpotBinding(@androidx.annotation.NonNull android.widget.RelativeLayout relativeLayout, @androidx.annotation.NonNull android.widget.TextView textView, @androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView recyclerView, @androidx.annotation.NonNull com.moji.multiplestatuslayout.MJMultipleStatusLayout mJMultipleStatusLayout, @androidx.annotation.NonNull com.moji.titlebar.MJTitleBar mJTitleBar) {
        this.n = relativeLayout;
        this.mLabelView = textView;
        this.mRecyclerView = recyclerView;
        this.mStatusView = mJMultipleStatusLayout;
        this.mTitle = mJTitleBar;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweatherservicebase.databinding.ActivityRflowersSpotBinding bind(@androidx.annotation.NonNull android.view.View view) {
        com.moji.multiplestatuslayout.MJMultipleStatusLayout findChildViewById;
        com.moji.titlebar.MJTitleBar findChildViewById2;
        int i = moji.com.mjweatherservicebase.R.id.mLabelView;
        android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = moji.com.mjweatherservicebase.R.id.mRecyclerView;
            androidx.recyclerview.widget.RecyclerView recyclerView = (androidx.recyclerview.widget.RecyclerView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (recyclerView != null && (findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweatherservicebase.R.id.mStatusView))) != null && (findChildViewById2 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweatherservicebase.R.id.mTitle))) != null) {
                return new moji.com.mjweatherservicebase.databinding.ActivityRflowersSpotBinding((android.widget.RelativeLayout) view, textView, recyclerView, findChildViewById, findChildViewById2);
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweatherservicebase.databinding.ActivityRflowersSpotBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweatherservicebase.databinding.ActivityRflowersSpotBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweatherservicebase.R.layout.activity_rflowers_spot, viewGroup, false);
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
