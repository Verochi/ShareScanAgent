package cn.jzvd;

/* loaded from: classes.dex */
public abstract class JZMediaInterface implements android.view.TextureView.SurfaceTextureListener {
    public android.graphics.SurfaceTexture SAVED_SURFACE;
    public android.os.Handler handler;
    public cn.jzvd.Jzvd jzvd;
    public android.os.Handler mMediaHandler;
    public android.os.HandlerThread mMediaHandlerThread;

    public JZMediaInterface(cn.jzvd.Jzvd jzvd) {
        this.jzvd = jzvd;
    }

    public abstract long getCurrentPosition();

    public abstract long getDuration();

    public abstract boolean isMute();

    public abstract boolean isPlaying();

    public abstract void pause();

    public abstract void pause(boolean z);

    public abstract void prepare();

    public abstract void release();

    public abstract void seekTo(long j);

    public abstract void setMute(boolean z);

    public abstract void setSpeed(float f);

    public abstract void setSurface(android.view.Surface surface);

    public abstract void setVolume(float f, float f2);

    public abstract void start();
}
