package com.otaliastudios.cameraview.video.encoding;

/* loaded from: classes19.dex */
public class TextureConfig extends com.otaliastudios.cameraview.video.encoding.VideoConfig {
    public android.opengl.EGLContext eglContext;
    public com.otaliastudios.cameraview.overlay.OverlayDrawer overlayDrawer;
    public int overlayRotation;
    public com.otaliastudios.cameraview.overlay.Overlay.Target overlayTarget;
    public float scaleX;
    public float scaleY;
    public int textureId;

    @androidx.annotation.NonNull
    public com.otaliastudios.cameraview.video.encoding.TextureConfig a() {
        com.otaliastudios.cameraview.video.encoding.TextureConfig textureConfig = new com.otaliastudios.cameraview.video.encoding.TextureConfig();
        copy(textureConfig);
        textureConfig.textureId = this.textureId;
        textureConfig.overlayDrawer = this.overlayDrawer;
        textureConfig.overlayTarget = this.overlayTarget;
        textureConfig.overlayRotation = this.overlayRotation;
        textureConfig.scaleX = this.scaleX;
        textureConfig.scaleY = this.scaleY;
        textureConfig.eglContext = this.eglContext;
        return textureConfig;
    }

    public boolean b() {
        return this.overlayDrawer != null;
    }
}
