package defpackage;

/* loaded from: classes17.dex */
public final /* synthetic */ class k73 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.user.homepage.fragment.UserCenterDynamicFragment n;

    public /* synthetic */ k73(com.moji.user.homepage.fragment.UserCenterDynamicFragment userCenterDynamicFragment) {
        this.n = userCenterDynamicFragment;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.user.homepage.fragment.UserCenterDynamicFragment.e(this.n, (com.moji.http.snsforum.entity.PictureDynamicListResult) obj);
    }
}
