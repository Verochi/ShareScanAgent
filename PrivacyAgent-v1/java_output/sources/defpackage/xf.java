package defpackage;

/* loaded from: classes17.dex */
public final /* synthetic */ class xf implements com.moji.dialog.control.MJDialogDefaultControl.SingleButtonCallback {
    public final /* synthetic */ com.moji.user.homepage.AvatarPendantSettingActivity a;
    public final /* synthetic */ kotlin.jvm.internal.Ref.ObjectRef b;

    public /* synthetic */ xf(com.moji.user.homepage.AvatarPendantSettingActivity avatarPendantSettingActivity, kotlin.jvm.internal.Ref.ObjectRef objectRef) {
        this.a = avatarPendantSettingActivity;
        this.b = objectRef;
    }

    public final void onClick(com.moji.dialog.MJDialog mJDialog, com.moji.dialog.type.ETypeAction eTypeAction) {
        com.moji.user.homepage.AvatarPendantSettingActivity.j(this.a, this.b, mJDialog, eTypeAction);
    }
}
