package defpackage;

/* loaded from: classes19.dex */
public final /* synthetic */ class v6 implements android.text.InputFilter {
    public final /* synthetic */ com.mojiweather.area.databinding.FragmentAddAreaFirstRunWithHotcityBinding n;
    public final /* synthetic */ com.mojiweather.area.AddAreaFirstRunWithHotCityFragment t;

    public /* synthetic */ v6(com.mojiweather.area.databinding.FragmentAddAreaFirstRunWithHotcityBinding fragmentAddAreaFirstRunWithHotcityBinding, com.mojiweather.area.AddAreaFirstRunWithHotCityFragment addAreaFirstRunWithHotCityFragment) {
        this.n = fragmentAddAreaFirstRunWithHotcityBinding;
        this.t = addAreaFirstRunWithHotCityFragment;
    }

    @Override // android.text.InputFilter
    public final java.lang.CharSequence filter(java.lang.CharSequence charSequence, int i, int i2, android.text.Spanned spanned, int i3, int i4) {
        return com.mojiweather.area.AddAreaFirstRunWithHotCityFragment.h(this.n, this.t, charSequence, i, i2, spanned, i3, i4);
    }
}
