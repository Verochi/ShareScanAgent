package tv.danmaku.ijk.media.player;

@android.annotation.TargetApi(14)
/* loaded from: classes21.dex */
public class TextureMediaPlayer extends tv.danmaku.ijk.media.player.MediaPlayerProxy implements tv.danmaku.ijk.media.player.ISurfaceTextureHolder {
    private android.graphics.SurfaceTexture mSurfaceTexture;
    private tv.danmaku.ijk.media.player.ISurfaceTextureHost mSurfaceTextureHost;

    public TextureMediaPlayer(tv.danmaku.ijk.media.player.IMediaPlayer iMediaPlayer) {
        super(iMediaPlayer);
    }

    @Override // tv.danmaku.ijk.media.player.ISurfaceTextureHolder
    public android.graphics.SurfaceTexture getSurfaceTexture() {
        return this.mSurfaceTexture;
    }

    @Override // tv.danmaku.ijk.media.player.MediaPlayerProxy, tv.danmaku.ijk.media.player.IMediaPlayer
    public void release() {
        super.release();
        releaseSurfaceTexture();
    }

    public void releaseSurfaceTexture() {
        android.graphics.SurfaceTexture surfaceTexture = this.mSurfaceTexture;
        if (surfaceTexture != null) {
            tv.danmaku.ijk.media.player.ISurfaceTextureHost iSurfaceTextureHost = this.mSurfaceTextureHost;
            if (iSurfaceTextureHost != null) {
                iSurfaceTextureHost.releaseSurfaceTexture(surfaceTexture);
            } else {
                surfaceTexture.release();
            }
            this.mSurfaceTexture = null;
        }
    }

    @Override // tv.danmaku.ijk.media.player.MediaPlayerProxy, tv.danmaku.ijk.media.player.IMediaPlayer
    public void reset() {
        super.reset();
        releaseSurfaceTexture();
    }

    @Override // tv.danmaku.ijk.media.player.MediaPlayerProxy, tv.danmaku.ijk.media.player.IMediaPlayer
    public void setDisplay(android.view.SurfaceHolder surfaceHolder) {
        if (this.mSurfaceTexture == null) {
            super.setDisplay(surfaceHolder);
        }
    }

    @Override // tv.danmaku.ijk.media.player.MediaPlayerProxy, tv.danmaku.ijk.media.player.IMediaPlayer
    public void setSurface(android.view.Surface surface) {
        if (this.mSurfaceTexture == null) {
            super.setSurface(surface);
        }
    }

    @Override // tv.danmaku.ijk.media.player.ISurfaceTextureHolder
    public void setSurfaceTexture(android.graphics.SurfaceTexture surfaceTexture) {
        if (this.mSurfaceTexture == surfaceTexture) {
            return;
        }
        releaseSurfaceTexture();
        this.mSurfaceTexture = surfaceTexture;
        if (surfaceTexture == null) {
            super.setSurface(null);
        } else {
            super.setSurface(new android.view.Surface(surfaceTexture));
        }
    }

    @Override // tv.danmaku.ijk.media.player.ISurfaceTextureHolder
    public void setSurfaceTextureHost(tv.danmaku.ijk.media.player.ISurfaceTextureHost iSurfaceTextureHost) {
        this.mSurfaceTextureHost = iSurfaceTextureHost;
    }
}
