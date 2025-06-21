package defpackage;

/* loaded from: classes14.dex */
public final /* synthetic */ class yl0 implements io.reactivex.functions.Consumer {
    public final /* synthetic */ com.moji.share.databinding.FragmentGraphicBinding n;

    public /* synthetic */ yl0(com.moji.share.databinding.FragmentGraphicBinding fragmentGraphicBinding) {
        this.n = fragmentGraphicBinding;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(java.lang.Object obj) {
        com.moji.share.fragment.GraphShareFragment.d(this.n, (android.graphics.Bitmap) obj);
    }
}
