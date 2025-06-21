package pad.aqi.cnemc.com.mjallergymodule.databinding;

/* loaded from: classes21.dex */
public final class LayoutAllergyFeedDialogGroupBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.TextView mGroupView;

    @androidx.annotation.NonNull
    public final android.widget.TextView n;

    public LayoutAllergyFeedDialogGroupBinding(@androidx.annotation.NonNull android.widget.TextView textView, @androidx.annotation.NonNull android.widget.TextView textView2) {
        this.n = textView;
        this.mGroupView = textView2;
    }

    @androidx.annotation.NonNull
    public static pad.aqi.cnemc.com.mjallergymodule.databinding.LayoutAllergyFeedDialogGroupBinding bind(@androidx.annotation.NonNull android.view.View view) {
        if (view == null) {
            throw new java.lang.NullPointerException("rootView");
        }
        android.widget.TextView textView = (android.widget.TextView) view;
        return new pad.aqi.cnemc.com.mjallergymodule.databinding.LayoutAllergyFeedDialogGroupBinding(textView, textView);
    }

    @androidx.annotation.NonNull
    public static pad.aqi.cnemc.com.mjallergymodule.databinding.LayoutAllergyFeedDialogGroupBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static pad.aqi.cnemc.com.mjallergymodule.databinding.LayoutAllergyFeedDialogGroupBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(pad.aqi.cnemc.com.mjallergymodule.R.layout.layout_allergy_feed_dialog_group, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @androidx.annotation.NonNull
    public android.widget.TextView getRoot() {
        return this.n;
    }
}
