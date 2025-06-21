package defpackage;

/* loaded from: classes25.dex */
public final /* synthetic */ class u7 implements android.text.InputFilter {
    public final /* synthetic */ com.moji.dangerousdrivingforecast.databinding.FragmentDrivingAddAreaBinding n;
    public final /* synthetic */ com.moji.dangerousdrivingforecast.AddAreaFragment t;

    public /* synthetic */ u7(com.moji.dangerousdrivingforecast.databinding.FragmentDrivingAddAreaBinding fragmentDrivingAddAreaBinding, com.moji.dangerousdrivingforecast.AddAreaFragment addAreaFragment) {
        this.n = fragmentDrivingAddAreaBinding;
        this.t = addAreaFragment;
    }

    @Override // android.text.InputFilter
    public final java.lang.CharSequence filter(java.lang.CharSequence charSequence, int i, int i2, android.text.Spanned spanned, int i3, int i4) {
        return com.moji.dangerousdrivingforecast.AddAreaFragment.e(this.n, this.t, charSequence, i, i2, spanned, i3, i4);
    }
}
