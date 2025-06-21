package defpackage;

/* loaded from: classes19.dex */
public final /* synthetic */ class v7 implements android.text.InputFilter {
    public final /* synthetic */ com.mojiweather.area.databinding.FragmentAddAreaBinding n;
    public final /* synthetic */ com.mojiweather.area.AddAreaFragment t;

    public /* synthetic */ v7(com.mojiweather.area.databinding.FragmentAddAreaBinding fragmentAddAreaBinding, com.mojiweather.area.AddAreaFragment addAreaFragment) {
        this.n = fragmentAddAreaBinding;
        this.t = addAreaFragment;
    }

    @Override // android.text.InputFilter
    public final java.lang.CharSequence filter(java.lang.CharSequence charSequence, int i, int i2, android.text.Spanned spanned, int i3, int i4) {
        return com.mojiweather.area.AddAreaFragment.e(this.n, this.t, charSequence, i, i2, spanned, i3, i4);
    }
}
