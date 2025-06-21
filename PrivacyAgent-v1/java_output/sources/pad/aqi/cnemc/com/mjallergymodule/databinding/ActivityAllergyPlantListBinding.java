package pad.aqi.cnemc.com.mjallergymodule.databinding;

/* loaded from: classes21.dex */
public final class ActivityAllergyPlantListBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout n;

    @androidx.annotation.NonNull
    public final androidx.recyclerview.widget.RecyclerView recyclerView;

    @androidx.annotation.NonNull
    public final com.moji.multiplestatuslayout.MJMultipleStatusLayout statusLayout;

    @androidx.annotation.NonNull
    public final com.moji.titlebar.MJTitleBar titleLayout;

    public ActivityAllergyPlantListBinding(@androidx.annotation.NonNull android.widget.LinearLayout linearLayout, @androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView recyclerView, @androidx.annotation.NonNull com.moji.multiplestatuslayout.MJMultipleStatusLayout mJMultipleStatusLayout, @androidx.annotation.NonNull com.moji.titlebar.MJTitleBar mJTitleBar) {
        this.n = linearLayout;
        this.recyclerView = recyclerView;
        this.statusLayout = mJMultipleStatusLayout;
        this.titleLayout = mJTitleBar;
    }

    @androidx.annotation.NonNull
    public static pad.aqi.cnemc.com.mjallergymodule.databinding.ActivityAllergyPlantListBinding bind(@androidx.annotation.NonNull android.view.View view) {
        com.moji.multiplestatuslayout.MJMultipleStatusLayout findChildViewById;
        com.moji.titlebar.MJTitleBar findChildViewById2;
        int i = pad.aqi.cnemc.com.mjallergymodule.R.id.recyclerView;
        androidx.recyclerview.widget.RecyclerView recyclerView = (androidx.recyclerview.widget.RecyclerView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (recyclerView == null || (findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = pad.aqi.cnemc.com.mjallergymodule.R.id.status_layout))) == null || (findChildViewById2 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = pad.aqi.cnemc.com.mjallergymodule.R.id.title_layout))) == null) {
            throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new pad.aqi.cnemc.com.mjallergymodule.databinding.ActivityAllergyPlantListBinding((android.widget.LinearLayout) view, recyclerView, findChildViewById, findChildViewById2);
    }

    @androidx.annotation.NonNull
    public static pad.aqi.cnemc.com.mjallergymodule.databinding.ActivityAllergyPlantListBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static pad.aqi.cnemc.com.mjallergymodule.databinding.ActivityAllergyPlantListBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(pad.aqi.cnemc.com.mjallergymodule.R.layout.activity_allergy_plant_list, viewGroup, false);
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
