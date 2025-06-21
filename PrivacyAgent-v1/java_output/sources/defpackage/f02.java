package defpackage;

/* loaded from: classes4.dex */
public final /* synthetic */ class f02 implements com.moji.mjlunarphase.calender.YearAdapter.onYearItemChangeLisener {
    public final /* synthetic */ com.moji.mjlunarphase.calender.PhaseCalenderActivity a;

    public /* synthetic */ f02(com.moji.mjlunarphase.calender.PhaseCalenderActivity phaseCalenderActivity) {
        this.a = phaseCalenderActivity;
    }

    public final void onPositionChange(int i) {
        com.moji.mjlunarphase.calender.PhaseCalenderActivity.d(this.a, i);
    }
}
