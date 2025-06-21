package defpackage;

/* loaded from: classes4.dex */
public final /* synthetic */ class e02 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.mjlunarphase.calender.PhaseCalenderActivity n;

    public /* synthetic */ e02(com.moji.mjlunarphase.calender.PhaseCalenderActivity phaseCalenderActivity) {
        this.n = phaseCalenderActivity;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.mjlunarphase.calender.PhaseCalenderActivity.f(this.n, (android.graphics.Bitmap) obj);
    }
}
