package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class wr implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.mjweather.ipc.view.CommonPopupWindow n;
    public final /* synthetic */ com.moji.mjweather.ipc.view.CommonPopupWindow.Menu t;

    public /* synthetic */ wr(com.moji.mjweather.ipc.view.CommonPopupWindow commonPopupWindow, com.moji.mjweather.ipc.view.CommonPopupWindow.Menu menu) {
        this.n = commonPopupWindow;
        this.t = menu;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.mjweather.ipc.view.CommonPopupWindow.b(this.n, this.t, view);
    }
}
