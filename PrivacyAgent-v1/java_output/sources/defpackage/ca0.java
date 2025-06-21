package defpackage;

/* loaded from: classes19.dex */
public final /* synthetic */ class ca0 implements android.view.View.OnClickListener {
    public final /* synthetic */ java.lang.String n;
    public final /* synthetic */ android.view.View t;

    public /* synthetic */ ca0(java.lang.String str, android.view.View view) {
        this.n = str;
        this.t = view;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.zodiac.adapter.EmptyHolder.a(this.n, this.t, view);
    }
}
