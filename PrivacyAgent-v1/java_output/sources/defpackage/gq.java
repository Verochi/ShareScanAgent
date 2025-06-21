package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class gq implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.mjweather.me.activity.CommentBindMobileActivity n;

    public /* synthetic */ gq(com.moji.mjweather.me.activity.CommentBindMobileActivity commentBindMobileActivity) {
        this.n = commentBindMobileActivity;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.mjweather.me.activity.CommentBindMobileActivity.b(this.n, (com.moji.http.ugc.bean.account.OneKeyBindMobileBean) obj);
    }
}
