package com.otaliastudios.cameraview.video.encoding;

/* JADX INFO: Access modifiers changed from: package-private */
@androidx.annotation.RequiresApi(api = 18)
/* loaded from: classes19.dex */
public abstract class VideoMediaEncoder<C extends com.otaliastudios.cameraview.video.encoding.VideoConfig> extends com.otaliastudios.cameraview.video.encoding.MediaEncoder {
    public static final com.otaliastudios.cameraview.CameraLogger q = com.otaliastudios.cameraview.CameraLogger.create(com.otaliastudios.cameraview.video.encoding.VideoMediaEncoder.class.getSimpleName());
    protected C mConfig;
    protected int mFrameNumber;
    protected android.view.Surface mSurface;
    public boolean p;

    public VideoMediaEncoder(@androidx.annotation.NonNull C c) {
        super("VideoEncoder");
        this.mFrameNumber = -1;
        this.p = false;
        this.mConfig = c;
    }

    @Override // com.otaliastudios.cameraview.video.encoding.MediaEncoder
    public int getEncodedBitRate() {
        return this.mConfig.bitRate;
    }

    @Override // com.otaliastudios.cameraview.video.encoding.MediaEncoder
    @com.otaliastudios.cameraview.video.encoding.EncoderThread
    public void onPrepare(@androidx.annotation.NonNull com.otaliastudios.cameraview.video.encoding.MediaEncoderEngine.Controller controller, long j) {
        C c = this.mConfig;
        android.media.MediaFormat createVideoFormat = android.media.MediaFormat.createVideoFormat(c.mimeType, c.width, c.height);
        createVideoFormat.setInteger("color-format", 2130708361);
        createVideoFormat.setInteger(tv.danmaku.ijk.media.player.IjkMediaMeta.IJKM_KEY_BITRATE, this.mConfig.bitRate);
        createVideoFormat.setInteger("frame-rate", this.mConfig.frameRate);
        createVideoFormat.setInteger("i-frame-interval", 1);
        createVideoFormat.setInteger("rotation-degrees", this.mConfig.rotation);
        try {
            C c2 = this.mConfig;
            java.lang.String str = c2.encoder;
            if (str != null) {
                this.mMediaCodec = android.media.MediaCodec.createByCodecName(str);
            } else {
                this.mMediaCodec = android.media.MediaCodec.createEncoderByType(c2.mimeType);
            }
            this.mMediaCodec.configure(createVideoFormat, (android.view.Surface) null, (android.media.MediaCrypto) null, 1);
            this.mSurface = this.mMediaCodec.createInputSurface();
            this.mMediaCodec.start();
        } catch (java.io.IOException e) {
            throw new java.lang.RuntimeException(e);
        }
    }

    @Override // com.otaliastudios.cameraview.video.encoding.MediaEncoder
    @com.otaliastudios.cameraview.video.encoding.EncoderThread
    public void onStart() {
        this.mFrameNumber = 0;
    }

    @Override // com.otaliastudios.cameraview.video.encoding.MediaEncoder
    @com.otaliastudios.cameraview.video.encoding.EncoderThread
    public void onStop() {
        q.i("onStop", "setting mFrameNumber to 1 and signaling the end of input stream.");
        this.mFrameNumber = -1;
        this.mMediaCodec.signalEndOfInputStream();
        drainOutput(true);
    }

    @Override // com.otaliastudios.cameraview.video.encoding.MediaEncoder
    public void onWriteOutput(@androidx.annotation.NonNull com.otaliastudios.cameraview.video.encoding.OutputBufferPool outputBufferPool, @androidx.annotation.NonNull com.otaliastudios.cameraview.video.encoding.OutputBuffer outputBuffer) {
        if (this.p) {
            super.onWriteOutput(outputBufferPool, outputBuffer);
            return;
        }
        com.otaliastudios.cameraview.CameraLogger cameraLogger = q;
        cameraLogger.w("onWriteOutput:", "sync frame not found yet. Checking.");
        if ((outputBuffer.info.flags & 1) == 1) {
            cameraLogger.w("onWriteOutput:", "SYNC FRAME FOUND!");
            this.p = true;
            super.onWriteOutput(outputBufferPool, outputBuffer);
        } else {
            cameraLogger.w("onWriteOutput:", "DROPPING FRAME and requesting a sync frame soon.");
            android.os.Bundle bundle = new android.os.Bundle();
            bundle.putInt("request-sync", 0);
            this.mMediaCodec.setParameters(bundle);
            outputBufferPool.recycle(outputBuffer);
        }
    }

    public boolean shouldRenderFrame(long j) {
        if (j == 0 || this.mFrameNumber < 0 || hasReachedMaxLength()) {
            return false;
        }
        this.mFrameNumber++;
        return true;
    }
}
