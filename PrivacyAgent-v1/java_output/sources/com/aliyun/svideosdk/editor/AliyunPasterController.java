package com.aliyun.svideosdk.editor;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public interface AliyunPasterController extends com.aliyun.svideosdk.editor.AliyunIPasterController {
    com.aliyun.svideosdk.editor.pplayer.AnimPlayerView createPasterPlayer(android.view.TextureView textureView);

    int editCompleted();

    void editStart();

    int getConfigTextColor();

    int getConfigTextStrokeColor();

    com.aliyun.svideosdk.common.struct.effect.EffectBase getEffect();

    float getPasterCenterX();

    float getPasterCenterY();

    long getPasterDuration();

    long getPasterDuration(java.util.concurrent.TimeUnit timeUnit);

    int getPasterHeight();

    java.lang.String getPasterIconPath();

    float getPasterRotation();

    long getPasterStartTime();

    long getPasterStartTime(java.util.concurrent.TimeUnit timeUnit);

    @java.lang.Deprecated
    java.lang.String getPasterTextFont();

    com.aliyun.svideosdk.common.struct.project.Source getPasterTextFontSource();

    int getPasterTextHeight();

    int getPasterTextOffsetX();

    int getPasterTextOffsetY();

    float getPasterTextRotation();

    int getPasterTextWidth();

    int getPasterType();

    int getPasterWidth();

    java.lang.String getText();

    int getTextBgLabelColor();

    int getTextColor();

    int getTextStrokeColor();

    boolean isOnlyApplyUI();

    boolean isPasterExists();

    boolean isPasterMirrored();

    boolean isRevert();

    boolean isTextHasStroke();

    @java.lang.Deprecated
    int removePaster();

    void setEffect(com.aliyun.svideosdk.common.struct.effect.EffectBase effectBase);

    void setOnlyApplyUI(boolean z);

    void setPasterDuration(long j);

    void setPasterDuration(long j, java.util.concurrent.TimeUnit timeUnit);

    void setPasterStartTime(long j);

    void setPasterStartTime(long j, java.util.concurrent.TimeUnit timeUnit);

    void setPasterView(com.aliyun.svideosdk.editor.AliyunPasterBaseView aliyunPasterBaseView);

    void setRevert(boolean z);
}
