package com.alimm.tanx.core.ad.interaction;

/* loaded from: classes.dex */
public class AdClickHandler implements com.alimm.tanx.core.utils.NotConfused {
    private static final java.lang.String TAG = "AdClickHandler";

    private void openWebActivity(android.content.Context context, java.lang.String str, com.alimm.tanx.core.ad.interaction.AdClickInfo adClickInfo) {
        if (adClickInfo == null) {
            com.alimm.tanx.core.utils.LogUtils.e(TAG, "openWebActivity 时adClickInfo 为空");
        } else {
            com.alimm.tanx.core.ad.browser.TanxBrowserActivity.tanxc_do(context, str, new com.alimm.tanx.core.bridge.JsBridgeBean(adClickInfo.getPid(), adClickInfo.getReqId(), adClickInfo.getRawJsonStr(), adClickInfo.getEventTrack(), adClickInfo.getTemplateId(), adClickInfo.getCreativeId(), adClickInfo.getOpenType(), adClickInfo.getDeepLinkUrl(), adClickInfo.getClickThroughUrl()));
        }
    }

    public boolean handleClickAndUt(android.content.Context context, com.alimm.tanx.core.ad.interaction.AdClickInfo adClickInfo, boolean z) {
        return handleClickAndUt(context, adClickInfo, false, z);
    }

    public boolean handleClickAndUt(android.content.Context context, com.alimm.tanx.core.ad.interaction.AdClickInfo adClickInfo, boolean z, boolean z2) {
        com.alimm.tanx.core.ad.interaction.tanxc_for tanxc_forVar;
        java.lang.String str;
        com.alimm.tanx.core.utils.LogUtils.d("DeepLinkManager", "handleClickAndUt..");
        java.lang.String pid = adClickInfo.getPid();
        java.lang.String reqId = adClickInfo.getReqId();
        java.lang.String deepLinkUrl = (android.text.TextUtils.isEmpty(adClickInfo.getWebClickThroughUrl()) && android.text.TextUtils.isEmpty(adClickInfo.getWebDeepLinkUrl())) ? adClickInfo.getDeepLinkUrl() : adClickInfo.getWebDeepLinkUrl();
        com.alimm.tanx.core.utils.LogUtils.d("DeepLinkManager", "deepLinkUrl: " + deepLinkUrl);
        tanxc_forVar = com.alimm.tanx.core.ad.interaction.tanxc_for.tanxc_do.tanxc_do;
        boolean tanxc_do = tanxc_forVar.tanxc_do(context, deepLinkUrl, reqId, pid);
        com.alimm.tanx.core.utils.LogUtils.d("DeepLinkManager", "handle: " + tanxc_do);
        java.lang.String clickThroughUrl = (android.text.TextUtils.isEmpty(adClickInfo.getWebClickThroughUrl()) && android.text.TextUtils.isEmpty(adClickInfo.getWebDeepLinkUrl())) ? adClickInfo.getClickThroughUrl() : adClickInfo.getWebClickThroughUrl();
        if (tanxc_do || z) {
            str = deepLinkUrl;
        } else {
            com.alimm.tanx.core.utils.LogUtils.d("DeepLinkManager", "ClickThroughUrl: " + clickThroughUrl);
            if (!android.text.TextUtils.isEmpty(clickThroughUrl)) {
                openWebActivity(context, clickThroughUrl, adClickInfo);
                com.alimm.tanx.core.ad.interaction.tanxc_do.C0023tanxc_do.tanxc_do.tanxc_do(clickThroughUrl, "h5");
            }
            str = clickThroughUrl;
        }
        if (z2) {
            com.alimm.tanx.core.ut.impl.TanxBaseUt.utNavigate(adClickInfo, tanxc_do ? "deepLink" : "throughUrl", str, deepLinkUrl, clickThroughUrl);
        }
        com.alimm.tanx.core.ut.impl.TanxBaseUt.utClick(adClickInfo, tanxc_do, str, deepLinkUrl, clickThroughUrl);
        com.alimm.tanx.core.utils.LogUtils.d("TanxSDK-DoClick", "TanxSDK落地页唤端跳转 reqId：" + adClickInfo.getReqId());
        com.alimm.tanx.core.utils.TanxTestLog.sendLog("点击url", str);
        return tanxc_do;
    }
}
