package defpackage;

/* loaded from: classes17.dex */
public final /* synthetic */ class j73 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.user.homepage.fragment.UserCenterDynamicFragment n;

    public /* synthetic */ j73(com.moji.user.homepage.fragment.UserCenterDynamicFragment userCenterDynamicFragment) {
        this.n = userCenterDynamicFragment;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.user.homepage.fragment.UserCenterDynamicFragment.b(this.n, (com.moji.user.homepage.mode.DeleteDynamicResult) obj);
    }
}
