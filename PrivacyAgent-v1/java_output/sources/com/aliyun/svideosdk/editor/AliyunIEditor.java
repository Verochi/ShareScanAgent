package com.aliyun.svideosdk.editor;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public interface AliyunIEditor {
    @java.lang.Deprecated
    int addAnimationFilter(com.aliyun.svideosdk.common.struct.effect.EffectFilter effectFilter);

    int addAnimationFilter(com.aliyun.svideosdk.common.struct.effect.TrackEffectFilter trackEffectFilter);

    int addFrameAnimation(com.aliyun.svideosdk.common.struct.effect.ActionBase actionBase);

    @java.lang.Deprecated
    int addImage(com.aliyun.svideosdk.common.struct.effect.EffectPicture effectPicture);

    @java.lang.Deprecated
    int addRunningDisplayMode(com.aliyun.svideosdk.common.struct.common.VideoDisplayMode videoDisplayMode, int i, long j, long j2);

    int addTailWaterMark(com.aliyun.svideosdk.common.struct.effect.TrackEffectWaterMark trackEffectWaterMark, long j, java.util.concurrent.TimeUnit timeUnit);

    int addTailWaterMark(java.lang.String str, float f, float f2, float f3, float f4, long j);

    int applyAudioEffect(int i, com.aliyun.svideosdk.editor.AudioEffectType audioEffectType, int i2);

    int applyBlurBackground(int i, long j, long j2, float f);

    @java.lang.Deprecated
    int applyDub(com.aliyun.svideosdk.common.struct.effect.EffectBean effectBean);

    int applyDub(com.aliyun.svideosdk.common.struct.effect.TrackAudioStream trackAudioStream);

    @java.lang.Deprecated
    int applyFilter(com.aliyun.svideosdk.common.struct.effect.EffectBean effectBean);

    int applyFilter(com.aliyun.svideosdk.common.struct.effect.TrackEffectFilter trackEffectFilter);

    int applyLutFilter(com.aliyun.svideosdk.common.struct.effect.LUTEffectBean lUTEffectBean);

    @java.lang.Deprecated
    int applyMV(com.aliyun.svideosdk.common.struct.effect.EffectBean effectBean);

    int applyMV(com.aliyun.svideosdk.common.struct.effect.TrackEffectMV trackEffectMV);

    @java.lang.Deprecated
    int applyMusic(com.aliyun.svideosdk.common.struct.effect.EffectBean effectBean);

    int applyMusic(com.aliyun.svideosdk.common.struct.effect.TrackAudioStream trackAudioStream);

    int applyMusicMixWeight(int i, int i2);

    int applyMusicWeight(int i, int i2);

    int applySourceChange();

    int applyWaterMark(com.aliyun.svideosdk.common.struct.effect.TrackEffectWaterMark trackEffectWaterMark);

    int applyWaterMark(java.lang.String str, float f, float f2, float f3, float f4);

    @java.lang.Deprecated
    int audioEffect(int i, com.aliyun.svideosdk.editor.AudioEffectType audioEffectType, int i2);

    int cancelCompose();

    void clearAllAnimationFilter();

    int compose(com.aliyun.svideosdk.common.struct.common.AliyunVideoParam aliyunVideoParam, java.lang.String str, com.aliyun.svideosdk.editor.AliyunIComposeCallBack aliyunIComposeCallBack);

    @java.lang.Deprecated
    com.aliyun.svideosdk.editor.AliyunPasterManager createPasterManager();

    com.aliyun.svideosdk.editor.AliyunRollCaptionComposer createRollCaptionComposer();

    int deleteBlurBackground(int i, int i2);

    int deleteTimeEffect(int i);

    int denoise(int i, int i2);

    @java.lang.Deprecated
    int denoise(int i, boolean z);

    int draw(long j);

    int draw(long j, java.util.concurrent.TimeUnit timeUnit);

    com.aliyun.common.log.struct.AliyunLogInfo getAliyunLogInfo();

    long getClipStartTime(int i);

    android.graphics.Bitmap getCurrentFrame();

    long getCurrentPlayPosition();

    long getCurrentStreamPosition();

    long getDuration();

    com.aliyun.svideosdk.common.struct.project.AliyunEditorProject getEditorProject();

    int getFilterLastApplyId();

    int getMVLastApplyId();

    int getMusicLastApplyId();

    android.graphics.Paint getPaintLastApply();

    com.aliyun.svideosdk.editor.AliyunPasterManager getPasterManager();

    @java.lang.Deprecated
    com.aliyun.svideosdk.editor.AliyunPasterRender getPasterRender();

    com.aliyun.svideosdk.editor.AliyunIPipManager getPipManager();

    com.aliyun.svideosdk.editor.AliyunIPlayerController getPlayerController();

    com.aliyun.svideosdk.common.struct.project.AliyunIProjectInfo getProjectInfo();

    int getRotation();

    com.aliyun.svideosdk.editor.AliyunISourcePartManager getSourcePartManager();

    long getStreamDuration();

    com.aliyun.svideosdk.editor.TimeEffectType getTimeEffect();

    int getVideoHeight();

    int getVideoWidth();

    int init(android.view.SurfaceView surfaceView, android.content.Context context);

    int init(android.view.SurfaceView surfaceView, android.content.Context context, int i, int i2);

    int invert();

    boolean isAudioSilence();

    boolean isPaused();

    boolean isPlaying();

    com.aliyun.svideosdk.editor.AliyunICanvasController obtainCanvasController(android.content.Context context, int i, int i2);

    void onDestroy();

    int pause();

    int play();

    int rate(float f, long j, long j2, boolean z);

    @java.lang.Deprecated
    void removeAnimationFilter(com.aliyun.svideosdk.common.struct.effect.EffectFilter effectFilter);

    void removeAnimationFilter(com.aliyun.svideosdk.common.struct.effect.TrackEffectFilter trackEffectFilter);

    int removeAudioEffect(int i, com.aliyun.svideosdk.editor.AudioEffectType audioEffectType);

    int removeAudioFadeIn(int i);

    int removeAudioFadeOut(int i);

    @java.lang.Deprecated
    int removeDub(com.aliyun.svideosdk.common.struct.effect.EffectBean effectBean);

    int removeDub(com.aliyun.svideosdk.common.struct.effect.TrackAudioStream trackAudioStream);

    int removeFilter();

    int removeFrameAnimation(com.aliyun.svideosdk.common.struct.effect.ActionBase actionBase);

    @java.lang.Deprecated
    void removeImage(com.aliyun.svideosdk.common.struct.effect.EffectPicture effectPicture);

    @java.lang.Deprecated
    int removeMusic(com.aliyun.svideosdk.common.struct.effect.EffectBean effectBean);

    int removeMusic(com.aliyun.svideosdk.common.struct.effect.TrackAudioStream trackAudioStream);

    @java.lang.Deprecated
    int removeRunningDisplayMode(int i, int i2);

    int repeat(int i, long j, long j2, boolean z);

    int replay();

    int resetEffect(com.aliyun.svideosdk.editor.EffectType effectType);

    int resetVideoAugmentation(int i, com.aliyun.svideosdk.common.internal.videoaugment.VideoAugmentationType videoAugmentationType);

    int resume();

    int saveEffectToLocal();

    int seek(long j);

    int seek(long j, java.util.concurrent.TimeUnit timeUnit);

    @java.lang.Deprecated
    void setAnimationRestoredListener(com.aliyun.svideosdk.editor.OnAnimationFilterRestored onAnimationFilterRestored);

    int setAudioFadeIn(int i, com.aliyun.svideosdk.editor.ShapeType shapeType, long j);

    int setAudioFadeOut(int i, com.aliyun.svideosdk.editor.ShapeType shapeType, long j);

    void setAudioSilence(boolean z);

    int setDisplayMode(com.aliyun.svideosdk.common.struct.common.VideoDisplayMode videoDisplayMode);

    int setDisplayView(android.view.SurfaceView surfaceView);

    int setDisplayView(android.view.TextureView textureView);

    int setFillBackgroundColor(int i);

    int setHorizontalFlip(int i, boolean z);

    void setMonitorSurfaceChange(boolean z);

    void setOnAnimationRestoredListener(com.aliyun.svideosdk.editor.OnAnimationFilterRestoredListener onAnimationFilterRestoredListener);

    void setOutputPath(java.lang.String str);

    int setTransition(int i, com.aliyun.svideosdk.common.struct.effect.TransitionBase transitionBase);

    int setTransition(java.util.Map<java.lang.Integer, com.aliyun.svideosdk.common.struct.effect.TransitionBase> map);

    int setVideoAugmentation(int i, com.aliyun.svideosdk.common.internal.videoaugment.VideoAugmentationType videoAugmentationType, float f);

    int setVolume(int i);

    int stop();

    @java.lang.Deprecated
    int updateAnimationFilter(com.aliyun.svideosdk.common.struct.effect.EffectFilter effectFilter);

    int updateAnimationFilter(com.aliyun.svideosdk.common.struct.effect.TrackEffectFilter trackEffectFilter);

    int updateCaption(com.aliyun.svideosdk.common.AliyunCaption aliyunCaption);

    void updateCover(com.aliyun.svideosdk.common.struct.project.Source source);

    int updateTransition(int i, com.aliyun.svideosdk.common.struct.effect.TransitionBase transitionBase);

    java.lang.String version();
}
