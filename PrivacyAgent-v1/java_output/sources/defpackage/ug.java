package defpackage;

/* loaded from: classes22.dex */
public final /* synthetic */ class ug implements android.view.View.OnTouchListener {
    public final /* synthetic */ com.chad.library.adapter.base.module.BaseDraggableModule n;

    public /* synthetic */ ug(com.chad.library.adapter.base.module.BaseDraggableModule baseDraggableModule) {
        this.n = baseDraggableModule;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(android.view.View view, android.view.MotionEvent motionEvent) {
        boolean d;
        d = com.chad.library.adapter.base.module.BaseDraggableModule.d(this.n, view, motionEvent);
        return d;
    }
}
