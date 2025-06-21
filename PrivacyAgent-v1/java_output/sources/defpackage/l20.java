package defpackage;

/* loaded from: classes11.dex */
public final /* synthetic */ class l20 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.rainclould.DisasterActivity n;

    public /* synthetic */ l20(com.moji.rainclould.DisasterActivity disasterActivity) {
        this.n = disasterActivity;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.rainclould.DisasterActivity.g(this.n, (com.moji.http.rainclould.entity.AddRemindCityResult) obj);
    }
}
