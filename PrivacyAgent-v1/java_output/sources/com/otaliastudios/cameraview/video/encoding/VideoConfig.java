package com.otaliastudios.cameraview.video.encoding;

/* loaded from: classes19.dex */
public class VideoConfig {
    public int bitRate;
    public java.lang.String encoder;
    public int frameRate;
    public int height;
    public java.lang.String mimeType;
    public int rotation;
    public int width;

    public <C extends com.otaliastudios.cameraview.video.encoding.VideoConfig> void copy(@androidx.annotation.NonNull C c) {
        c.width = this.width;
        c.height = this.height;
        c.bitRate = this.bitRate;
        c.frameRate = this.frameRate;
        c.rotation = this.rotation;
        c.mimeType = this.mimeType;
        c.encoder = this.encoder;
    }
}
