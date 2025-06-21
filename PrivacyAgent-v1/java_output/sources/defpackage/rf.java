package defpackage;

/* loaded from: classes17.dex */
public final /* synthetic */ class rf implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.user.homepage.AvatarPendantSettingActivity n;

    public /* synthetic */ rf(com.moji.user.homepage.AvatarPendantSettingActivity avatarPendantSettingActivity) {
        this.n = avatarPendantSettingActivity;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.user.homepage.AvatarPendantSettingActivity.h(this.n, (com.moji.requestcore.entity.MJBaseRespRc) obj);
    }
}
