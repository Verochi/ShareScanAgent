package moji.com.mjwallet.databinding;

/* loaded from: classes20.dex */
public final class FragmentBillListBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final com.moji.multiplestatuslayout.MJMultipleStatusLayout n;

    @androidx.annotation.NonNull
    public final androidx.recyclerview.widget.RecyclerView recyclerView;

    @androidx.annotation.NonNull
    public final com.moji.multiplestatuslayout.MJMultipleStatusLayout statusLayout;

    public FragmentBillListBinding(@androidx.annotation.NonNull com.moji.multiplestatuslayout.MJMultipleStatusLayout mJMultipleStatusLayout, @androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView recyclerView, @androidx.annotation.NonNull com.moji.multiplestatuslayout.MJMultipleStatusLayout mJMultipleStatusLayout2) {
        this.n = mJMultipleStatusLayout;
        this.recyclerView = recyclerView;
        this.statusLayout = mJMultipleStatusLayout2;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjwallet.databinding.FragmentBillListBinding bind(@androidx.annotation.NonNull android.view.View view) {
        int i = moji.com.mjwallet.R.id.recycler_view;
        androidx.recyclerview.widget.RecyclerView recyclerView = (androidx.recyclerview.widget.RecyclerView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (recyclerView == null) {
            throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        com.moji.multiplestatuslayout.MJMultipleStatusLayout mJMultipleStatusLayout = (com.moji.multiplestatuslayout.MJMultipleStatusLayout) view;
        return new moji.com.mjwallet.databinding.FragmentBillListBinding(mJMultipleStatusLayout, recyclerView, mJMultipleStatusLayout);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjwallet.databinding.FragmentBillListBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjwallet.databinding.FragmentBillListBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjwallet.R.layout.fragment_bill_list, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @androidx.annotation.NonNull
    public com.moji.multiplestatuslayout.MJMultipleStatusLayout getRoot() {
        return this.n;
    }
}
