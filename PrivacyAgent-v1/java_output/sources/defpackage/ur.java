package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class ur implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.mjweather.ipc.view.CommonPopupWindow n;
    public final /* synthetic */ com.moji.mjweather.ipc.view.CommonPopupWindow.Menu t;

    public /* synthetic */ ur(com.moji.mjweather.ipc.view.CommonPopupWindow commonPopupWindow, com.moji.mjweather.ipc.view.CommonPopupWindow.Menu menu) {
        this.n = commonPopupWindow;
        this.t = menu;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.mjweather.ipc.view.CommonPopupWindow.a(this.n, this.t, view);
    }
}
