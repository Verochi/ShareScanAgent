package defpackage;

/* loaded from: classes23.dex */
public final /* synthetic */ class yn1 implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.card.dialog.MorePopWindow n;
    public final /* synthetic */ android.widget.PopupWindow t;

    public /* synthetic */ yn1(com.moji.card.dialog.MorePopWindow morePopWindow, android.widget.PopupWindow popupWindow) {
        this.n = morePopWindow;
        this.t = popupWindow;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.card.dialog.MorePopWindow.a(this.n, this.t, view);
    }
}
