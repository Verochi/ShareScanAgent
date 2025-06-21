package defpackage;

/* loaded from: classes29.dex */
public final /* synthetic */ class ak2 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.tool.SingleLiveEvent n;
    public final /* synthetic */ androidx.lifecycle.Observer t;

    public /* synthetic */ ak2(com.moji.tool.SingleLiveEvent singleLiveEvent, androidx.lifecycle.Observer observer) {
        this.n = singleLiveEvent;
        this.t = observer;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.tool.SingleLiveEvent.a(this.n, this.t, obj);
    }
}
