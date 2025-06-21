package defpackage;

/* loaded from: classes11.dex */
public final /* synthetic */ class f20 implements com.moji.dialog.control.MJDialogDefaultControl.SingleButtonCallback {
    public final /* synthetic */ com.moji.rainclould.DisasterActivity a;
    public final /* synthetic */ com.moji.http.rainclould.entity.AddRemindCityResult b;

    public /* synthetic */ f20(com.moji.rainclould.DisasterActivity disasterActivity, com.moji.http.rainclould.entity.AddRemindCityResult addRemindCityResult) {
        this.a = disasterActivity;
        this.b = addRemindCityResult;
    }

    public final void onClick(com.moji.dialog.MJDialog mJDialog, com.moji.dialog.type.ETypeAction eTypeAction) {
        com.moji.rainclould.DisasterActivity.e(this.a, this.b, mJDialog, eTypeAction);
    }
}
