package defpackage;

/* loaded from: classes9.dex */
public final /* synthetic */ class ex1 implements androidx.lifecycle.Observer {
    public final /* synthetic */ kotlin.jvm.internal.Ref.ObjectRef n;

    public /* synthetic */ ex1(kotlin.jvm.internal.Ref.ObjectRef objectRef) {
        this.n = objectRef;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.novice.feature.guide.PageFragment.a(this.n, (android.graphics.Bitmap) obj);
    }
}
