package defpackage;

/* loaded from: classes6.dex */
public final /* synthetic */ class wu implements android.widget.PopupWindow.OnDismissListener {
    public final /* synthetic */ com.moji.mjweather.dailydetails.view.DailyDetailPopWindow n;

    public /* synthetic */ wu(com.moji.mjweather.dailydetails.view.DailyDetailPopWindow dailyDetailPopWindow) {
        this.n = dailyDetailPopWindow;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        com.moji.mjweather.dailydetails.view.DailyDetailPopWindow.a(this.n);
    }
}
