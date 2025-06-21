package defpackage;

/* loaded from: classes27.dex */
public final /* synthetic */ class og1 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.member.MemberMyCodeDetailsActivity n;

    public /* synthetic */ og1(com.moji.member.MemberMyCodeDetailsActivity memberMyCodeDetailsActivity) {
        this.n = memberMyCodeDetailsActivity;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.member.MemberMyCodeDetailsActivity.c(this.n, (android.graphics.Bitmap) obj);
    }
}
