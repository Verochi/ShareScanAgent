package defpackage;

/* loaded from: classes8.dex */
public final /* synthetic */ class hj1 implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.newmember.personal.adapter.MemberRemindUnVipAdapter.MiddleMemberCommodityHolder n;
    public final /* synthetic */ com.moji.http.member.entity.MemberRemindUnVipResult t;
    public final /* synthetic */ kotlin.jvm.internal.Ref.ObjectRef u;
    public final /* synthetic */ kotlin.jvm.internal.Ref.ObjectRef v;

    public /* synthetic */ hj1(com.moji.newmember.personal.adapter.MemberRemindUnVipAdapter.MiddleMemberCommodityHolder middleMemberCommodityHolder, com.moji.http.member.entity.MemberRemindUnVipResult memberRemindUnVipResult, kotlin.jvm.internal.Ref.ObjectRef objectRef, kotlin.jvm.internal.Ref.ObjectRef objectRef2) {
        this.n = middleMemberCommodityHolder;
        this.t = memberRemindUnVipResult;
        this.u = objectRef;
        this.v = objectRef2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.newmember.personal.adapter.MemberRemindUnVipAdapter.MiddleMemberCommodityHolder.a(this.n, this.t, this.u, this.v, view);
    }
}
