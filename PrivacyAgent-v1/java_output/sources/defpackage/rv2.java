package defpackage;

/* loaded from: classes5.dex */
public final /* synthetic */ class rv2 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.mjtabme.fragment.TabMeUserInfoFragment n;

    public /* synthetic */ rv2(com.moji.mjtabme.fragment.TabMeUserInfoFragment tabMeUserInfoFragment) {
        this.n = tabMeUserInfoFragment;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.mjtabme.fragment.TabMeUserInfoFragment.c(this.n, (com.moji.account.data.UserInfo) obj);
    }
}
