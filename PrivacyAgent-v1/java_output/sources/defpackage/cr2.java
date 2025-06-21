package defpackage;

/* loaded from: classes5.dex */
public final /* synthetic */ class cr2 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.mjstargaze.StarGazeOperationLiveData n;

    public /* synthetic */ cr2(com.moji.mjstargaze.StarGazeOperationLiveData starGazeOperationLiveData) {
        this.n = starGazeOperationLiveData;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.mjstargaze.StarGazeOperationLiveData.b(this.n, (com.moji.opevent.model.OperationEvent) obj);
    }
}
