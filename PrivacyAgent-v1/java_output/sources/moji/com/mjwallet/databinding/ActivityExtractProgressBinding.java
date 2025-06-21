package moji.com.mjwallet.databinding;

/* loaded from: classes20.dex */
public final class ActivityExtractProgressBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final androidx.recyclerview.widget.RecyclerView extractProgressList;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout n;

    @androidx.annotation.NonNull
    public final android.widget.TextView progressTip;

    @androidx.annotation.NonNull
    public final com.moji.multiplestatuslayout.MJMultipleStatusLayout statusLayout;

    public ActivityExtractProgressBinding(@androidx.annotation.NonNull android.widget.LinearLayout linearLayout, @androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView recyclerView, @androidx.annotation.NonNull android.widget.TextView textView, @androidx.annotation.NonNull com.moji.multiplestatuslayout.MJMultipleStatusLayout mJMultipleStatusLayout) {
        this.n = linearLayout;
        this.extractProgressList = recyclerView;
        this.progressTip = textView;
        this.statusLayout = mJMultipleStatusLayout;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjwallet.databinding.ActivityExtractProgressBinding bind(@androidx.annotation.NonNull android.view.View view) {
        com.moji.multiplestatuslayout.MJMultipleStatusLayout findChildViewById;
        int i = moji.com.mjwallet.R.id.extract_progress_list;
        androidx.recyclerview.widget.RecyclerView recyclerView = (androidx.recyclerview.widget.RecyclerView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (recyclerView != null) {
            i = moji.com.mjwallet.R.id.progress_tip;
            android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (textView != null && (findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjwallet.R.id.status_layout))) != null) {
                return new moji.com.mjwallet.databinding.ActivityExtractProgressBinding((android.widget.LinearLayout) view, recyclerView, textView, findChildViewById);
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static moji.com.mjwallet.databinding.ActivityExtractProgressBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjwallet.databinding.ActivityExtractProgressBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjwallet.R.layout.activity_extract_progress, viewGroup, false);
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
