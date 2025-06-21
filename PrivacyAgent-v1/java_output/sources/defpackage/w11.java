package defpackage;

/* loaded from: classes24.dex */
public final /* synthetic */ class w11 implements io.reactivex.ObservableOnSubscribe {
    public final /* synthetic */ com.moji.common.area.AreaInfo a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ boolean c;

    public /* synthetic */ w11(com.moji.common.area.AreaInfo areaInfo, boolean z, boolean z2) {
        this.a = areaInfo;
        this.b = z;
        this.c = z2;
    }

    @Override // io.reactivex.ObservableOnSubscribe
    public final void subscribe(io.reactivex.ObservableEmitter observableEmitter) {
        com.moji.areamanagement.MJAreaManager.a(this.a, this.b, this.c, observableEmitter);
    }
}
