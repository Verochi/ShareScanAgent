package defpackage;

/* loaded from: classes25.dex */
public final /* synthetic */ class d21 implements android.view.View.OnClickListener {
    public final /* synthetic */ kotlin.jvm.internal.Ref.ObjectRef n;
    public final /* synthetic */ com.moji.dialog.control.MJDialogMultipleChoiceControl.ItemAdapter.ItemHolder t;

    public /* synthetic */ d21(kotlin.jvm.internal.Ref.ObjectRef objectRef, com.moji.dialog.control.MJDialogMultipleChoiceControl.ItemAdapter.ItemHolder itemHolder) {
        this.n = objectRef;
        this.t = itemHolder;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.dialog.control.MJDialogMultipleChoiceControl.ItemAdapter.ItemHolder.a(this.n, this.t, view);
    }
}
