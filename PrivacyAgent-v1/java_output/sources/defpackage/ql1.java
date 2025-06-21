package defpackage;

/* loaded from: classes27.dex */
public final /* synthetic */ class ql1 implements java.lang.Runnable {
    public final /* synthetic */ com.moji.liveview_finalversion.ui.discover.ModuleAdapter.ViewHolder n;
    public final /* synthetic */ java.lang.String t;
    public final /* synthetic */ com.moji.textview.MJTextView u;
    public final /* synthetic */ com.moji.liveview_finalversion.ui.discover.ModuleAdapter v;
    public final /* synthetic */ boolean w;

    public /* synthetic */ ql1(com.moji.liveview_finalversion.ui.discover.ModuleAdapter.ViewHolder viewHolder, java.lang.String str, com.moji.textview.MJTextView mJTextView, com.moji.liveview_finalversion.ui.discover.ModuleAdapter moduleAdapter, boolean z) {
        this.n = viewHolder;
        this.t = str;
        this.u = mJTextView;
        this.v = moduleAdapter;
        this.w = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.liveview_finalversion.ui.discover.ModuleAdapter.ViewHolder.b(this.n, this.t, this.u, this.v, this.w);
    }
}
