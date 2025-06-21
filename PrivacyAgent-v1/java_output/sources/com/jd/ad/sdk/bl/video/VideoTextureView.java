package com.jd.ad.sdk.bl.video;

/* loaded from: classes23.dex */
public class VideoTextureView extends android.view.TextureView implements com.jd.ad.sdk.bl.video.jad_an {
    public com.jd.ad.sdk.bl.video.jad_an.InterfaceC0375jad_an jad_an;
    public android.graphics.SurfaceTexture jad_bo;
    public boolean jad_cp;
    public int jad_dq;
    public int jad_er;
    public android.view.Surface jad_fs;

    public static final class jad_bo implements com.jd.ad.sdk.bl.video.jad_an.jad_bo {
        public java.lang.ref.WeakReference<android.view.Surface> jad_an;
        public java.lang.ref.WeakReference<com.jd.ad.sdk.bl.video.VideoTextureView> jad_bo;

        public jad_bo(com.jd.ad.sdk.bl.video.VideoTextureView videoTextureView, android.graphics.SurfaceTexture surfaceTexture) {
            this.jad_bo = new java.lang.ref.WeakReference<>(videoTextureView);
            this.jad_an = new java.lang.ref.WeakReference<>(new android.view.Surface(surfaceTexture));
        }
    }

    public class jad_cp implements android.view.TextureView.SurfaceTextureListener {
        public jad_cp() {
        }

        public /* synthetic */ jad_cp(com.jd.ad.sdk.bl.video.VideoTextureView videoTextureView, com.jd.ad.sdk.bl.video.VideoTextureView.jad_an jad_anVar) {
            this();
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(android.graphics.SurfaceTexture surfaceTexture, int i, int i2) {
            com.jd.ad.sdk.bl.video.VideoTextureView videoTextureView = com.jd.ad.sdk.bl.video.VideoTextureView.this;
            com.jd.ad.sdk.bl.video.jad_an.InterfaceC0375jad_an interfaceC0375jad_an = videoTextureView.jad_an;
            if (interfaceC0375jad_an != null) {
                com.jd.ad.sdk.bl.video.VideoTextureView.jad_bo jad_boVar = new com.jd.ad.sdk.bl.video.VideoTextureView.jad_bo(videoTextureView, surfaceTexture);
                com.jd.ad.sdk.bl.video.VideoRenderView videoRenderView = ((com.jd.ad.sdk.bl.video.jad_cp) interfaceC0375jad_an).jad_an;
                videoRenderView.jad_jt = jad_boVar;
                android.media.MediaPlayer mediaPlayer = videoRenderView.jad_an;
                java.lang.ref.WeakReference<com.jd.ad.sdk.bl.video.VideoTextureView> weakReference = jad_boVar.jad_bo;
                com.jd.ad.sdk.bl.video.VideoTextureView videoTextureView2 = weakReference != null ? weakReference.get() : null;
                if (mediaPlayer == null || jad_boVar.jad_an == null || videoTextureView2 == null) {
                    return;
                }
                android.graphics.SurfaceTexture ownSurfaceTexture = videoTextureView2.getOwnSurfaceTexture();
                android.graphics.SurfaceTexture surfaceTexture2 = videoTextureView2.getSurfaceTexture();
                boolean z = false;
                boolean isReleased = (ownSurfaceTexture == null || android.os.Build.VERSION.SDK_INT < 26) ? false : ownSurfaceTexture.isReleased();
                if (ownSurfaceTexture != null && !isReleased) {
                    z = true;
                }
                if (!videoTextureView2.jad_cp || !z) {
                    android.view.Surface surface = jad_boVar.jad_an.get();
                    if (surface != null) {
                        mediaPlayer.setSurface(surface);
                        videoTextureView2.setSurface(surface);
                        return;
                    }
                    return;
                }
                if (!ownSurfaceTexture.equals(surfaceTexture2)) {
                    videoTextureView2.setSurfaceTexture(ownSurfaceTexture);
                    return;
                }
                android.view.Surface surface2 = videoTextureView2.getSurface();
                if (surface2 != null) {
                    surface2.release();
                }
                android.view.Surface surface3 = new android.view.Surface(ownSurfaceTexture);
                mediaPlayer.setSurface(surface3);
                videoTextureView2.setSurface(surface3);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(android.graphics.SurfaceTexture surfaceTexture) {
            com.jd.ad.sdk.bl.video.VideoTextureView videoTextureView = com.jd.ad.sdk.bl.video.VideoTextureView.this;
            com.jd.ad.sdk.bl.video.jad_an.InterfaceC0375jad_an interfaceC0375jad_an = videoTextureView.jad_an;
            if (interfaceC0375jad_an != null) {
                new java.lang.ref.WeakReference(videoTextureView);
                new java.lang.ref.WeakReference(new android.view.Surface(surfaceTexture));
                ((com.jd.ad.sdk.bl.video.jad_cp) interfaceC0375jad_an).jad_an.jad_jt = null;
            }
            com.jd.ad.sdk.bl.video.VideoTextureView videoTextureView2 = com.jd.ad.sdk.bl.video.VideoTextureView.this;
            boolean z = videoTextureView2.jad_cp;
            if (z) {
                videoTextureView2.jad_bo = surfaceTexture;
            }
            return !z;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(android.graphics.SurfaceTexture surfaceTexture, int i, int i2) {
            com.jd.ad.sdk.bl.video.VideoTextureView videoTextureView = com.jd.ad.sdk.bl.video.VideoTextureView.this;
            if (videoTextureView.jad_an != null) {
                new java.lang.ref.WeakReference(videoTextureView);
                new java.lang.ref.WeakReference(new android.view.Surface(surfaceTexture));
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(android.graphics.SurfaceTexture surfaceTexture) {
        }
    }

    public VideoTextureView(android.content.Context context) {
        this(context, null);
    }

    public VideoTextureView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VideoTextureView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setSurfaceTextureListener(new com.jd.ad.sdk.bl.video.VideoTextureView.jad_cp(this, null));
    }

    public android.graphics.SurfaceTexture getOwnSurfaceTexture() {
        return this.jad_bo;
    }

    public android.view.View getRenderView() {
        return this;
    }

    public android.view.Surface getSurface() {
        return this.jad_fs;
    }

    @Override // com.jd.ad.sdk.bl.video.jad_an
    public void jad_an() {
        android.graphics.SurfaceTexture surfaceTexture = this.jad_bo;
        if (surfaceTexture != null) {
            surfaceTexture.release();
            this.jad_bo = null;
        }
        android.view.Surface surface = this.jad_fs;
        if (surface != null) {
            surface.release();
            this.jad_fs = null;
        }
        setSurfaceTextureListener(null);
    }

    @Override // com.jd.ad.sdk.bl.video.jad_an
    public void jad_an(int i, int i2) {
        this.jad_dq = i;
        this.jad_er = i2;
        requestLayout();
    }

    @Override // android.view.TextureView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int mode = android.view.View.MeasureSpec.getMode(i);
        int size = android.view.View.MeasureSpec.getSize(i);
        int mode2 = android.view.View.MeasureSpec.getMode(i2);
        int size2 = android.view.View.MeasureSpec.getSize(i2);
        if (this.jad_dq > 0 && this.jad_er > 0) {
            if (mode == 0 || mode2 == 0) {
                if (mode == 0) {
                    i = (int) (size2 * 0.5625f);
                } else if (mode2 == 0) {
                    i2 = (int) (size / 0.5625f);
                    i = size;
                } else {
                    i = size;
                }
                i2 = size2;
            } else {
                float f = size;
                float f2 = size2;
                if (f / f2 > 0.5625f) {
                    i2 = (int) (f / 0.5625f);
                    i = size;
                } else {
                    i = (int) (f2 * 0.5625f);
                    i2 = size2;
                }
            }
        }
        setMeasuredDimension(i, i2);
    }

    @Override // com.jd.ad.sdk.bl.video.jad_an
    public void setRenderCallback(com.jd.ad.sdk.bl.video.jad_an.InterfaceC0375jad_an interfaceC0375jad_an) {
        this.jad_an = interfaceC0375jad_an;
    }

    public void setSurface(android.view.Surface surface) {
        this.jad_fs = surface;
    }

    public void setTakeOverSurfaceTexture(boolean z) {
        this.jad_cp = z;
    }
}
