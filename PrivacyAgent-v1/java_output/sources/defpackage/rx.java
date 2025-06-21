package defpackage;

/* loaded from: classes28.dex */
public final /* synthetic */ class rx implements android.view.View.OnClickListener {
    public final /* synthetic */ boolean n;
    public final /* synthetic */ boolean t;
    public final /* synthetic */ com.moji.http.member.entity.MemberRemindUnVipResult.Config u;
    public final /* synthetic */ java.lang.String v;
    public final /* synthetic */ com.moji.mj40dayforecast.fragment.Days40CurveFragment w;

    public /* synthetic */ rx(boolean z, boolean z2, com.moji.http.member.entity.MemberRemindUnVipResult.Config config, java.lang.String str, com.moji.mj40dayforecast.fragment.Days40CurveFragment days40CurveFragment) {
        this.n = z;
        this.t = z2;
        this.u = config;
        this.v = str;
        this.w = days40CurveFragment;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.mj40dayforecast.fragment.Days40CurveFragment.a(this.n, this.t, this.u, this.v, this.w, view);
    }
}
