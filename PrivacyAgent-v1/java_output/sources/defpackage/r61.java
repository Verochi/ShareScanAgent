package defpackage;

/* loaded from: classes23.dex */
public final /* synthetic */ class r61 implements java.lang.Runnable {
    public final /* synthetic */ com.moji.appwidget.core.MJWidgetManager n;
    public final /* synthetic */ android.content.Context t;
    public final /* synthetic */ java.lang.String u;
    public final /* synthetic */ com.moji.appwidget.core.ELayer v;
    public final /* synthetic */ com.moji.appwidget.activity.WidgetConfigListener w;
    public final /* synthetic */ android.appwidget.AppWidgetManager x;
    public final /* synthetic */ int y;
    public final /* synthetic */ com.moji.appwidget.core.EWidgetSize[] z;

    public /* synthetic */ r61(com.moji.appwidget.core.MJWidgetManager mJWidgetManager, android.content.Context context, java.lang.String str, com.moji.appwidget.core.ELayer eLayer, com.moji.appwidget.activity.WidgetConfigListener widgetConfigListener, android.appwidget.AppWidgetManager appWidgetManager, int i, com.moji.appwidget.core.EWidgetSize[] eWidgetSizeArr) {
        this.n = mJWidgetManager;
        this.t = context;
        this.u = str;
        this.v = eLayer;
        this.w = widgetConfigListener;
        this.x = appWidgetManager;
        this.y = i;
        this.z = eWidgetSizeArr;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.appwidget.core.MJWidgetManager.a(this.n, this.t, this.u, this.v, this.w, this.x, this.y, this.z);
    }
}
