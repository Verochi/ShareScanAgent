package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class d32 implements java.lang.Runnable {
    public final /* synthetic */ android.view.View n;
    public final /* synthetic */ android.widget.EditText t;

    public /* synthetic */ d32(android.view.View view, android.widget.EditText editText) {
        this.n = view;
        this.t = editText;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.mjweather.feed.newvideo.adapter.PlayFeedbackHolder.a(this.n, this.t);
    }
}
