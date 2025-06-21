package defpackage;

/* loaded from: classes14.dex */
public final /* synthetic */ class i53 implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.shorttime.ui.view.TyphoonBottomDialogView n;
    public final /* synthetic */ com.moji.http.member.entity.ShortMemberDialogResult.Config t;

    public /* synthetic */ i53(com.moji.shorttime.ui.view.TyphoonBottomDialogView typhoonBottomDialogView, com.moji.http.member.entity.ShortMemberDialogResult.Config config) {
        this.n = typhoonBottomDialogView;
        this.t = config;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.shorttime.ui.view.TyphoonBottomDialogView.b(this.n, this.t, view);
    }
}
