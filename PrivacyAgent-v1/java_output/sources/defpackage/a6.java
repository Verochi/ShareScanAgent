package defpackage;

/* loaded from: classes28.dex */
public final /* synthetic */ class a6 implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.mjad.common.view.creater.style.AdStyleDoubleFeedTextCreater n;
    public final /* synthetic */ com.moji.mjad.common.data.AdCommon t;
    public final /* synthetic */ com.moji.mjad.databinding.MojiAdDoubleFeedTextStyleBinding u;

    public /* synthetic */ a6(com.moji.mjad.common.view.creater.style.AdStyleDoubleFeedTextCreater adStyleDoubleFeedTextCreater, com.moji.mjad.common.data.AdCommon adCommon, com.moji.mjad.databinding.MojiAdDoubleFeedTextStyleBinding mojiAdDoubleFeedTextStyleBinding) {
        this.n = adStyleDoubleFeedTextCreater;
        this.t = adCommon;
        this.u = mojiAdDoubleFeedTextStyleBinding;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.mjad.common.view.creater.style.AdStyleDoubleFeedTextCreater.m(this.n, this.t, this.u, view);
    }
}
