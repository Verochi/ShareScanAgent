package com.aliyun.svideosdk.multirecorder;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public interface AliyunIVideoRecorder {
    int addWaterMark(com.aliyun.svideosdk.common.struct.effect.EffectImage effectImage);

    void cancelRecording();

    int clearBackground();

    void destroy();

    int finishRecording();

    android.net.Uri finishRecordingForEdit();

    com.aliyun.svideosdk.recorder.AliyunIClipManager getClipManager();

    com.aliyun.svideosdk.multirecorder.AliyunIVideoCapture getVideoCapture();

    void prepare();

    void removeMusic();

    int removeWaterMark(com.aliyun.svideosdk.common.struct.effect.EffectImage effectImage);

    int setBackgroundColor(int i);

    int setBackgroundDisplayMode(int i);

    int setBackgroundImage(android.graphics.Bitmap bitmap);

    int setBackgroundImage(java.lang.String str);

    void setEncoderInfoCallback(com.aliyun.svideosdk.recorder.EncoderInfoCallback encoderInfoCallback);

    void setIsAutoClearClipVideos(boolean z);

    int setMicDenoiseWeight(int i);

    void setMixAudioWeight(int i, int i2);

    int setMusic(java.lang.String str, long j, long j2);

    void setMute(boolean z);

    void setOnAudioCallback(com.aliyun.svideosdk.common.callback.recorder.OnAudioCallBack onAudioCallBack);

    void setOnRecordListener(com.aliyun.svideosdk.multirecorder.OnVideoRecordListener onVideoRecordListener);

    void setOpenMicAEC(boolean z);

    void setOpenMixAudioMode(boolean z);

    void setRate(float f);

    int startPreview();

    int startRecording();

    void stopPreview();

    int stopRecording();

    int updateVideoSize(int i, int i2);

    java.lang.String version();
}
