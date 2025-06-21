package defpackage;

/* loaded from: classes22.dex */
public final /* synthetic */ class tg implements android.view.View.OnLongClickListener {
    public final /* synthetic */ com.chad.library.adapter.base.module.BaseDraggableModule n;

    public /* synthetic */ tg(com.chad.library.adapter.base.module.BaseDraggableModule baseDraggableModule) {
        this.n = baseDraggableModule;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(android.view.View view) {
        boolean c;
        c = com.chad.library.adapter.base.module.BaseDraggableModule.c(this.n, view);
        return c;
    }
}
