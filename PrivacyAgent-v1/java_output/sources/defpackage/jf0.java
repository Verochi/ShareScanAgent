package defpackage;

/* loaded from: classes3.dex */
public final /* synthetic */ class jf0 implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.account.data.UserInfo n;
    public final /* synthetic */ com.moji.mjfloatball.FloatBallDetailActivity t;

    public /* synthetic */ jf0(com.moji.account.data.UserInfo userInfo, com.moji.mjfloatball.FloatBallDetailActivity floatBallDetailActivity) {
        this.n = userInfo;
        this.t = floatBallDetailActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.mjfloatball.FloatBallDetailActivity.f(this.n, this.t, view);
    }
}
