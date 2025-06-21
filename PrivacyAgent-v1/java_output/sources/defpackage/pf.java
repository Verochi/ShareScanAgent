package defpackage;

/* loaded from: classes17.dex */
public final /* synthetic */ class pf implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.user.homepage.AvatarPendantSettingActivity n;

    public /* synthetic */ pf(com.moji.user.homepage.AvatarPendantSettingActivity avatarPendantSettingActivity) {
        this.n = avatarPendantSettingActivity;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.user.homepage.AvatarPendantSettingActivity.c(this.n, (com.moji.http.credit.entity.AvatarPendantListResp) obj);
    }
}
