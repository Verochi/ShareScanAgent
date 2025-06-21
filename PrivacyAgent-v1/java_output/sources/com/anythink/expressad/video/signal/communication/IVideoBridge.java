package com.anythink.expressad.video.signal.communication;

/* loaded from: classes12.dex */
public interface IVideoBridge {
    public static final int A_ = 1;
    public static final int z_ = 0;

    void appendSubView(java.lang.Object obj, java.lang.String str);

    void appendViewTo(java.lang.Object obj, java.lang.String str);

    void bringViewToFront(java.lang.Object obj, java.lang.String str);

    void broadcast(java.lang.Object obj, java.lang.String str);

    void cai(java.lang.Object obj, java.lang.String str);

    void clearAllCache(java.lang.Object obj, java.lang.String str);

    void click(java.lang.Object obj, java.lang.String str);

    void closeAd(java.lang.Object obj, java.lang.String str);

    void closeVideoOperte(java.lang.Object obj, java.lang.String str);

    void closeWeb(java.lang.Object obj, java.lang.String str);

    void createNativeEC(java.lang.Object obj, java.lang.String str);

    void createPlayerView(java.lang.Object obj, java.lang.String str);

    void createSubPlayTemplateView(java.lang.Object obj, java.lang.String str);

    void createView(java.lang.Object obj, java.lang.String str);

    void createWebview(java.lang.Object obj, java.lang.String str);

    void destroyComponent(java.lang.Object obj, java.lang.String str);

    void getAllCache(java.lang.Object obj, java.lang.String str);

    void getAppSetting(java.lang.Object obj, java.lang.String str);

    void getComponentOptions(java.lang.Object obj, java.lang.String str);

    void getCurrentProgress(java.lang.Object obj, java.lang.String str);

    void getCutout(java.lang.Object obj, java.lang.String str);

    void getEncryptPrice(java.lang.Object obj, java.lang.String str);

    void getFileInfo(java.lang.Object obj, java.lang.String str);

    void getRewardSetting(java.lang.Object obj, java.lang.String str);

    void getRewardUnitSetting(java.lang.Object obj, java.lang.String str);

    void getSDKInfo(java.lang.Object obj, java.lang.String str);

    void getUnitSetting(java.lang.Object obj, java.lang.String str);

    void gial(java.lang.Object obj, java.lang.String str);

    void handleNativeObject(java.lang.Object obj, java.lang.String str);

    void handlerH5Exception(java.lang.Object obj, java.lang.String str);

    void hideView(java.lang.Object obj, java.lang.String str);

    void increaseOfferFrequence(java.lang.Object obj, java.lang.String str);

    void init(java.lang.Object obj, java.lang.String str);

    void insertViewAbove(java.lang.Object obj, java.lang.String str);

    void insertViewBelow(java.lang.Object obj, java.lang.String str);

    void isSystemResume(java.lang.Object obj, java.lang.String str);

    void ivRewardAdsWithoutVideo(java.lang.Object obj, java.lang.String str);

    void loadads(java.lang.Object obj, java.lang.String str);

    void loadingResourceStatus(java.lang.Object obj, java.lang.String str);

    void notifyCloseBtn(java.lang.Object obj, java.lang.String str);

    void onlyAppendSubView(java.lang.Object obj, java.lang.String str);

    void onlyAppendViewTo(java.lang.Object obj, java.lang.String str);

    void onlyInsertViewAbove(java.lang.Object obj, java.lang.String str);

    void onlyInsertViewBelow(java.lang.Object obj, java.lang.String str);

    void openURL(java.lang.Object obj, java.lang.String str);

    void playVideoFinishOperate(java.lang.Object obj, java.lang.String str);

    void playerGetMuteState(java.lang.Object obj, java.lang.String str);

    void playerMute(java.lang.Object obj, java.lang.String str);

    void playerPause(java.lang.Object obj, java.lang.String str);

    void playerPlay(java.lang.Object obj, java.lang.String str);

    void playerResume(java.lang.Object obj, java.lang.String str);

    void playerSetRenderType(java.lang.Object obj, java.lang.String str);

    void playerSetSource(java.lang.Object obj, java.lang.String str);

    void playerStop(java.lang.Object obj, java.lang.String str);

    void playerUnmute(java.lang.Object obj, java.lang.String str);

    void playerUpdateFrame(java.lang.Object obj, java.lang.String str);

    void preloadSubPlayTemplateView(java.lang.Object obj, java.lang.String str);

    void progressBarOperate(java.lang.Object obj, java.lang.String str);

    void progressOperate(java.lang.Object obj, java.lang.String str);

    void reactDeveloper(java.lang.Object obj, java.lang.String str);

    void readyStatus(java.lang.Object obj, java.lang.String str);

    void removeCacheItem(java.lang.Object obj, java.lang.String str);

    void removeFromSuperView(java.lang.Object obj, java.lang.String str);

    void reportUrls(java.lang.Object obj, java.lang.String str);

    void setCacheItem(java.lang.Object obj, java.lang.String str);

    void setScaleFitXY(java.lang.Object obj, java.lang.String str);

    void setSubPlayTemplateInfo(java.lang.Object obj, java.lang.String str);

    void setViewAlpha(java.lang.Object obj, java.lang.String str);

    void setViewBgColor(java.lang.Object obj, java.lang.String str);

    void setViewRect(java.lang.Object obj, java.lang.String str);

    void setViewScale(java.lang.Object obj, java.lang.String str);

    void showAlertView(java.lang.Object obj, java.lang.String str);

    void showVideoClickView(java.lang.Object obj, java.lang.String str);

    void showVideoLocation(java.lang.Object obj, java.lang.String str);

    void showView(java.lang.Object obj, java.lang.String str);

    void soundOperate(java.lang.Object obj, java.lang.String str);

    void statistics(java.lang.Object obj, java.lang.String str);

    void toggleCloseBtn(java.lang.Object obj, java.lang.String str);

    void triggerCloseBtn(java.lang.Object obj, java.lang.String str);

    void videoOperate(java.lang.Object obj, java.lang.String str);

    void webviewFireEvent(java.lang.Object obj, java.lang.String str);

    void webviewGoBack(java.lang.Object obj, java.lang.String str);

    void webviewGoForward(java.lang.Object obj, java.lang.String str);

    void webviewLoad(java.lang.Object obj, java.lang.String str);

    void webviewReload(java.lang.Object obj, java.lang.String str);
}
