package defpackage;

/* loaded from: classes14.dex */
public final /* synthetic */ class ah2 implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.opevent.model.OperationEvent n;
    public final /* synthetic */ com.moji.shorttime.ui.ShortTimeActivity t;

    public /* synthetic */ ah2(com.moji.opevent.model.OperationEvent operationEvent, com.moji.shorttime.ui.ShortTimeActivity shortTimeActivity) {
        this.n = operationEvent;
        this.t = shortTimeActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.shorttime.ui.ShortTimeActivity.b(this.n, this.t, view);
    }
}
