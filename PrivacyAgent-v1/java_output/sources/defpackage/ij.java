package defpackage;

/* loaded from: classes15.dex */
public final /* synthetic */ class ij implements android.widget.ViewSwitcher.ViewFactory {
    public final /* synthetic */ android.content.Context a;

    public /* synthetic */ ij(android.content.Context context) {
        this.a = context;
    }

    @Override // android.widget.ViewSwitcher.ViewFactory
    public final android.view.View makeView() {
        return com.moji.skywatchers.home.view.BroadcastView.a(this.a);
    }
}
