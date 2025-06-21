package defpackage;

/* loaded from: classes8.dex */
public final /* synthetic */ class i12 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.card.OperationCardViewModel n;
    public final /* synthetic */ kotlin.jvm.internal.Ref.ObjectRef t;
    public final /* synthetic */ com.moji.newliveview.detail.PictureDetailFragmentV2 u;

    public /* synthetic */ i12(com.moji.card.OperationCardViewModel operationCardViewModel, kotlin.jvm.internal.Ref.ObjectRef objectRef, com.moji.newliveview.detail.PictureDetailFragmentV2 pictureDetailFragmentV2) {
        this.n = operationCardViewModel;
        this.t = objectRef;
        this.u = pictureDetailFragmentV2;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.newliveview.detail.PictureDetailFragmentV2.e(this.n, this.t, this.u, (com.moji.card.event.OpCardChangeEvent) obj);
    }
}
