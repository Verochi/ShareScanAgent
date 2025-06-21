package com.otaliastudios.cameraview.video.encoding;

/* loaded from: classes19.dex */
public class AudioConfig {
    public int bitRate;
    public java.lang.String encoder;
    public int channels = 1;
    public java.lang.String mimeType = "audio/mp4a-latm";
    public int samplingFrequency = 44100;
    public final int a = 2;
    public final int b = 2;
    public final int c = 44100 * 2;

    public int a() {
        int i = this.channels;
        if (i == 1) {
            return 16;
        }
        if (i == 2) {
            return 12;
        }
        throw new java.lang.RuntimeException("Invalid number of channels: " + this.channels);
    }

    public int b() {
        return 50;
    }

    public int c() {
        return 500;
    }

    public int d() {
        return this.c * this.channels;
    }

    @androidx.annotation.NonNull
    public com.otaliastudios.cameraview.video.encoding.AudioConfig e() {
        com.otaliastudios.cameraview.video.encoding.AudioConfig audioConfig = new com.otaliastudios.cameraview.video.encoding.AudioConfig();
        audioConfig.bitRate = this.bitRate;
        audioConfig.channels = this.channels;
        audioConfig.encoder = this.encoder;
        audioConfig.mimeType = this.mimeType;
        audioConfig.samplingFrequency = this.samplingFrequency;
        return audioConfig;
    }

    public int f() {
        return this.channels * 1024;
    }
}
