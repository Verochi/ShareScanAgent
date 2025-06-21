package defpackage;

/* loaded from: classes23.dex */
public final /* synthetic */ class iv1 implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.card.view.OpCardLocationView n;
    public final /* synthetic */ android.content.Context t;

    public /* synthetic */ iv1(com.moji.card.view.OpCardLocationView opCardLocationView, android.content.Context context) {
        this.n = opCardLocationView;
        this.t = context;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.card.view.OpCardLocationView.f(this.n, this.t, view);
    }
}
