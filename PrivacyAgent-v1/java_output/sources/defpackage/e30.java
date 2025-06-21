package defpackage;

/* loaded from: classes11.dex */
public final /* synthetic */ class e30 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.rainclould.DisasterNoticeActivity n;

    public /* synthetic */ e30(com.moji.rainclould.DisasterNoticeActivity disasterNoticeActivity) {
        this.n = disasterNoticeActivity;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.rainclould.DisasterNoticeActivity.c(this.n, (com.moji.http.rainclould.entity.DisasterNoticeResult) obj);
    }
}
