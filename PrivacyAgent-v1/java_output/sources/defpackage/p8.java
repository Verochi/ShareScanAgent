package defpackage;

/* loaded from: classes14.dex */
public final /* synthetic */ class p8 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.shorttime.ui.function.allergy.AllergyRadarMapFunction n;

    public /* synthetic */ p8(com.moji.shorttime.ui.function.allergy.AllergyRadarMapFunction allergyRadarMapFunction) {
        this.n = allergyRadarMapFunction;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.shorttime.ui.function.allergy.AllergyRadarMapFunction.j(this.n, (com.moji.shorttime.ui.RadarProgressBarStateWrapper) obj);
    }
}
