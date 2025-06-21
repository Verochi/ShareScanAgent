package defpackage;

/* loaded from: classes8.dex */
public final /* synthetic */ class bi1 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.newmember.membermanager.MemberPayManagerActivity n;

    public /* synthetic */ bi1(com.moji.newmember.membermanager.MemberPayManagerActivity memberPayManagerActivity) {
        this.n = memberPayManagerActivity;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.newmember.membermanager.MemberPayManagerActivity.n(this.n, (com.moji.requestcore.entity.MJBaseRespRc) obj);
    }
}
