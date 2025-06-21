package moji.com.mjweatherservicebase;

@kotlin.Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u0016¨\u0006\u0007"}, d2 = {"moji/com/mjweatherservicebase/BaseHomePageActivity$prepareShare$1", "Lmoji/com/mjweatherservicebase/card/ShareCallback;", com.alipay.sdk.m.x.d.n, "", "bitmaps", "Ljava/util/ArrayList;", "Landroid/graphics/Bitmap;", "MJWeatherServiceBase_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes20.dex */
public final class BaseHomePageActivity$prepareShare$1 implements moji.com.mjweatherservicebase.card.ShareCallback {
    public final /* synthetic */ moji.com.mjweatherservicebase.BaseHomePageActivity a;

    public BaseHomePageActivity$prepareShare$1(moji.com.mjweatherservicebase.BaseHomePageActivity baseHomePageActivity) {
        this.a = baseHomePageActivity;
    }

    @Override // moji.com.mjweatherservicebase.card.ShareCallback
    public void onBack(@org.jetbrains.annotations.Nullable java.util.ArrayList<android.graphics.Bitmap> bitmaps) {
        moji.com.mjweatherservicebase.card.ModuleFeatureCustom j;
        moji.com.mjweatherservicebase.card.ModuleFeatureCustom j2;
        com.moji.share.MJThirdShareManager k;
        moji.com.mjweatherservicebase.card.ModuleFeatureCustom j3;
        if (bitmaps == null) {
            com.moji.tool.ToastTool.showToast(moji.com.mjweatherservicebase.R.string.share_data_failed);
            return;
        }
        j = this.a.j();
        com.moji.share.entity.ShareContentConfig.Builder builder = new com.moji.share.entity.ShareContentConfig.Builder(j.getShareTitle(), com.moji.tool.DeviceTool.getStringById(moji.com.mjweatherservicebase.R.string.mojitalk));
        j2 = this.a.j();
        com.moji.share.entity.ShareContentConfig build = builder.localImagePath(j2.getGraphicSharePath()).removeShareType(com.moji.share.entity.ShareChannelType.MESSAGE).putShareType(com.moji.share.entity.ShareChannelType.WX_FRIEND, com.moji.share.entity.ShareContentType.PIC).build();
        k = this.a.k();
        j3 = this.a.j();
        k.doShare(j3.getShareFrom(), build, true);
        this.a.opFinalShareBit(bitmaps);
    }
}
