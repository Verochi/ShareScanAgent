package defpackage;

/* loaded from: classes8.dex */
public final /* synthetic */ class tj1 implements android.view.View.OnClickListener {
    public final /* synthetic */ int n;
    public final /* synthetic */ com.moji.http.member.entity.MemberTabResultNew.Operations t;

    public /* synthetic */ tj1(int i, com.moji.http.member.entity.MemberTabResultNew.Operations operations) {
        this.n = i;
        this.t = operations;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.newmember.newtab.adapter.MemberSeasonServiceAdapter.ItemHolder.a(this.n, this.t, view);
    }
}
