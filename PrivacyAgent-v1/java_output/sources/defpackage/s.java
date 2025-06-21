package defpackage;

/* loaded from: classes28.dex */
public final /* synthetic */ class s implements com.baidu.mobads.sdk.api.NativeResponse.AdShakeViewListener {
    public final /* synthetic */ com.moji.mjad.common.view.creater.style.AbsAdBaiDuVideoCreater a;

    public /* synthetic */ s(com.moji.mjad.common.view.creater.style.AbsAdBaiDuVideoCreater absAdBaiDuVideoCreater) {
        this.a = absAdBaiDuVideoCreater;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse.AdShakeViewListener
    public final void onDismiss() {
        com.moji.mjad.common.view.creater.style.AbsAdBaiDuVideoCreater.m(this.a);
    }
}
