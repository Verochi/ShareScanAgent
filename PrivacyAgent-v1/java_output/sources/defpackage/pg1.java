package defpackage;

/* loaded from: classes27.dex */
public final /* synthetic */ class pg1 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.member.MemberMyCodeDetailsActivity n;

    public /* synthetic */ pg1(com.moji.member.MemberMyCodeDetailsActivity memberMyCodeDetailsActivity) {
        this.n = memberMyCodeDetailsActivity;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.member.MemberMyCodeDetailsActivity.b(this.n, (kotlin.Unit) obj);
    }
}
