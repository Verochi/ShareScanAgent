package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class LayoutTeamIntroduceTextBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout n;

    public LayoutTeamIntroduceTextBinding(@androidx.annotation.NonNull android.widget.LinearLayout linearLayout) {
        this.n = linearLayout;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.LayoutTeamIntroduceTextBinding bind(@androidx.annotation.NonNull android.view.View view) {
        if (view != null) {
            return new moji.com.mjweather.databinding.LayoutTeamIntroduceTextBinding((android.widget.LinearLayout) view);
        }
        throw new java.lang.NullPointerException("rootView");
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.LayoutTeamIntroduceTextBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.LayoutTeamIntroduceTextBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.layout_team_introduce_text, viewGroup, false);
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
