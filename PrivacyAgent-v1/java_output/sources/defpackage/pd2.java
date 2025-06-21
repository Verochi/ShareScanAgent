package defpackage;

/* loaded from: classes14.dex */
public final /* synthetic */ class pd2 implements com.moji.dialog.control.MJDialogDefaultControl.SingleButtonCallback {
    public final /* synthetic */ com.moji.sence.scenestore.model.SceneSwitchHelper a;

    public /* synthetic */ pd2(com.moji.sence.scenestore.model.SceneSwitchHelper sceneSwitchHelper) {
        this.a = sceneSwitchHelper;
    }

    public final void onClick(com.moji.dialog.MJDialog mJDialog, com.moji.dialog.type.ETypeAction eTypeAction) {
        com.moji.sence.scenestore.model.SceneSwitchHelper.a(this.a, mJDialog, eTypeAction);
    }
}
