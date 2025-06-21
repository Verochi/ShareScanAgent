package com.otaliastudios.cameraview.video;

@androidx.annotation.RequiresApi(api = 18)
/* loaded from: classes19.dex */
public class SnapshotVideoRecorder extends com.otaliastudios.cameraview.video.VideoRecorder implements com.otaliastudios.cameraview.preview.RendererFrameCallback, com.otaliastudios.cameraview.video.encoding.MediaEncoderEngine.Listener {
    public static final com.otaliastudios.cameraview.CameraLogger p = com.otaliastudios.cameraview.CameraLogger.create(com.otaliastudios.cameraview.video.SnapshotVideoRecorder.class.getSimpleName());
    public com.otaliastudios.cameraview.video.encoding.MediaEncoderEngine f;
    public final java.lang.Object g;
    public com.otaliastudios.cameraview.preview.RendererCameraPreview h;
    public int i;
    public int j;
    public int k;
    public com.otaliastudios.cameraview.overlay.Overlay l;
    public com.otaliastudios.cameraview.overlay.OverlayDrawer m;
    public boolean n;
    public com.otaliastudios.cameraview.filter.Filter o;

    /* renamed from: com.otaliastudios.cameraview.video.SnapshotVideoRecorder$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[com.otaliastudios.cameraview.controls.AudioCodec.values().length];
            b = iArr;
            try {
                iArr[com.otaliastudios.cameraview.controls.AudioCodec.AAC.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                b[com.otaliastudios.cameraview.controls.AudioCodec.HE_AAC.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                b[com.otaliastudios.cameraview.controls.AudioCodec.AAC_ELD.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                b[com.otaliastudios.cameraview.controls.AudioCodec.DEVICE_DEFAULT.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[com.otaliastudios.cameraview.controls.VideoCodec.values().length];
            a = iArr2;
            try {
                iArr2[com.otaliastudios.cameraview.controls.VideoCodec.H_263.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused5) {
            }
            try {
                a[com.otaliastudios.cameraview.controls.VideoCodec.H_264.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused6) {
            }
            try {
                a[com.otaliastudios.cameraview.controls.VideoCodec.DEVICE_DEFAULT.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused7) {
            }
        }
    }

    public SnapshotVideoRecorder(@androidx.annotation.NonNull com.otaliastudios.cameraview.engine.CameraEngine cameraEngine, @androidx.annotation.NonNull com.otaliastudios.cameraview.preview.RendererCameraPreview rendererCameraPreview, @androidx.annotation.Nullable com.otaliastudios.cameraview.overlay.Overlay overlay) {
        super(cameraEngine);
        this.g = new java.lang.Object();
        this.i = 1;
        this.j = 1;
        this.k = 0;
        this.h = rendererCameraPreview;
        this.l = overlay;
        this.n = overlay != null && overlay.drawsOn(com.otaliastudios.cameraview.overlay.Overlay.Target.VIDEO_SNAPSHOT);
    }

    public static int a(@androidx.annotation.NonNull com.otaliastudios.cameraview.size.Size size, int i) {
        return (int) (size.getWidth() * 0.07f * size.getHeight() * i);
    }

    @Override // com.otaliastudios.cameraview.video.encoding.MediaEncoderEngine.Listener
    @com.otaliastudios.cameraview.video.encoding.EncoderThread
    public void onEncodingEnd(int i, @androidx.annotation.Nullable java.lang.Exception exc) {
        if (exc != null) {
            p.e("Error onEncodingEnd", exc);
            this.a = null;
            this.mError = exc;
        } else if (i == 1) {
            p.i("onEncodingEnd because of max duration.");
            this.a.endReason = 2;
        } else if (i == 2) {
            p.i("onEncodingEnd because of max size.");
            this.a.endReason = 1;
        } else {
            p.i("onEncodingEnd because of user.");
        }
        this.i = 1;
        this.j = 1;
        this.h.removeRendererFrameCallback(this);
        this.h = null;
        com.otaliastudios.cameraview.overlay.OverlayDrawer overlayDrawer = this.m;
        if (overlayDrawer != null) {
            overlayDrawer.release();
            this.m = null;
        }
        synchronized (this.g) {
            this.f = null;
        }
        dispatchResult();
    }

    @Override // com.otaliastudios.cameraview.video.encoding.MediaEncoderEngine.Listener
    public void onEncodingStart() {
    }

    @Override // com.otaliastudios.cameraview.video.encoding.MediaEncoderEngine.Listener
    public void onEncodingStop() {
        dispatchVideoRecordingEnd();
    }

    @Override // com.otaliastudios.cameraview.preview.RendererFrameCallback
    @com.otaliastudios.cameraview.preview.RendererThread
    public void onRendererFilterChanged(@androidx.annotation.NonNull com.otaliastudios.cameraview.filter.Filter filter) {
        com.otaliastudios.cameraview.filter.Filter copy = filter.copy();
        this.o = copy;
        copy.setSize(this.a.size.getWidth(), this.a.size.getHeight());
        synchronized (this.g) {
            com.otaliastudios.cameraview.video.encoding.MediaEncoderEngine mediaEncoderEngine = this.f;
            if (mediaEncoderEngine != null) {
                mediaEncoderEngine.notify("filter", this.o);
            }
        }
    }

    @Override // com.otaliastudios.cameraview.preview.RendererFrameCallback
    @com.otaliastudios.cameraview.preview.RendererThread
    public void onRendererFrame(@androidx.annotation.NonNull android.graphics.SurfaceTexture surfaceTexture, int i, float f, float f2) {
        com.otaliastudios.cameraview.size.Size size;
        int i2;
        int i3;
        int i4;
        com.otaliastudios.cameraview.video.encoding.AudioMediaEncoder audioMediaEncoder;
        if (this.i == 1 && this.j == 0) {
            p.i("Starting the encoder engine.");
            com.otaliastudios.cameraview.VideoResult.Stub stub = this.a;
            if (stub.videoFrameRate <= 0) {
                stub.videoFrameRate = 30;
            }
            if (stub.videoBitRate <= 0) {
                stub.videoBitRate = a(stub.size, stub.videoFrameRate);
            }
            com.otaliastudios.cameraview.VideoResult.Stub stub2 = this.a;
            if (stub2.audioBitRate <= 0) {
                stub2.audioBitRate = 64000;
            }
            java.lang.String str = "";
            int i5 = com.otaliastudios.cameraview.video.SnapshotVideoRecorder.AnonymousClass1.a[stub2.videoCodec.ordinal()];
            char c = 3;
            if (i5 == 1) {
                str = "video/3gpp";
            } else if (i5 == 2) {
                str = "video/avc";
            } else if (i5 == 3) {
                str = "video/avc";
            }
            java.lang.String str2 = "";
            int i6 = com.otaliastudios.cameraview.video.SnapshotVideoRecorder.AnonymousClass1.b[this.a.audioCodec.ordinal()];
            char c2 = 4;
            if (i6 == 1 || i6 == 2 || i6 == 3) {
                str2 = "audio/mp4a-latm";
            } else if (i6 == 4) {
                str2 = "audio/mp4a-latm";
            }
            java.lang.String str3 = str2;
            com.otaliastudios.cameraview.video.encoding.TextureConfig textureConfig = new com.otaliastudios.cameraview.video.encoding.TextureConfig();
            com.otaliastudios.cameraview.video.encoding.AudioConfig audioConfig = new com.otaliastudios.cameraview.video.encoding.AudioConfig();
            com.otaliastudios.cameraview.controls.Audio audio = this.a.audio;
            int i7 = audio == com.otaliastudios.cameraview.controls.Audio.ON ? audioConfig.channels : audio == com.otaliastudios.cameraview.controls.Audio.MONO ? 1 : audio == com.otaliastudios.cameraview.controls.Audio.STEREO ? 2 : 0;
            boolean z = i7 > 0;
            com.otaliastudios.cameraview.internal.DeviceEncoders deviceEncoders = null;
            com.otaliastudios.cameraview.size.Size size2 = null;
            boolean z2 = false;
            int i8 = 0;
            int i9 = 0;
            int i10 = 0;
            int i11 = 0;
            int i12 = 0;
            while (!z2) {
                com.otaliastudios.cameraview.CameraLogger cameraLogger = p;
                java.lang.Object[] objArr = new java.lang.Object[5];
                objArr[0] = "Checking DeviceEncoders...";
                objArr[1] = "videoOffset:";
                objArr[2] = java.lang.Integer.valueOf(i8);
                objArr[c] = "audioOffset:";
                objArr[c2] = java.lang.Integer.valueOf(i9);
                cameraLogger.i(objArr);
                try {
                    new com.otaliastudios.cameraview.internal.DeviceEncoders(0, str, str3, i8, i9);
                    com.otaliastudios.cameraview.internal.DeviceEncoders deviceEncoders2 = new com.otaliastudios.cameraview.internal.DeviceEncoders(1, str, str3, i8, i9);
                    try {
                        com.otaliastudios.cameraview.size.Size supportedVideoSize = deviceEncoders2.getSupportedVideoSize(this.a.size);
                        try {
                            int supportedVideoBitRate = deviceEncoders2.getSupportedVideoBitRate(this.a.videoBitRate);
                            try {
                                int supportedVideoFrameRate = deviceEncoders2.getSupportedVideoFrameRate(supportedVideoSize, this.a.videoFrameRate);
                                try {
                                    deviceEncoders2.tryConfigureVideo(str, supportedVideoSize, supportedVideoFrameRate, supportedVideoBitRate);
                                    if (z) {
                                        int supportedAudioBitRate = deviceEncoders2.getSupportedAudioBitRate(this.a.audioBitRate);
                                        try {
                                            deviceEncoders2.tryConfigureAudio(str3, supportedAudioBitRate, audioConfig.samplingFrequency, i7);
                                            i11 = supportedAudioBitRate;
                                        } catch (com.otaliastudios.cameraview.internal.DeviceEncoders.AudioException e) {
                                            e = e;
                                            i11 = supportedAudioBitRate;
                                            size2 = supportedVideoSize;
                                            i10 = supportedVideoBitRate;
                                            i12 = supportedVideoFrameRate;
                                            p.i("Got AudioException:", e.getMessage());
                                            i9++;
                                            deviceEncoders = deviceEncoders2;
                                            c = 3;
                                            c2 = 4;
                                        } catch (com.otaliastudios.cameraview.internal.DeviceEncoders.VideoException e2) {
                                            e = e2;
                                            i11 = supportedAudioBitRate;
                                            size2 = supportedVideoSize;
                                            i10 = supportedVideoBitRate;
                                            i12 = supportedVideoFrameRate;
                                            p.i("Got VideoException:", e.getMessage());
                                            i8++;
                                            deviceEncoders = deviceEncoders2;
                                            c = 3;
                                            c2 = 4;
                                        }
                                    }
                                    deviceEncoders = deviceEncoders2;
                                    size2 = supportedVideoSize;
                                    i10 = supportedVideoBitRate;
                                    i12 = supportedVideoFrameRate;
                                    c = 3;
                                    c2 = 4;
                                    z2 = true;
                                } catch (com.otaliastudios.cameraview.internal.DeviceEncoders.AudioException e3) {
                                    e = e3;
                                } catch (com.otaliastudios.cameraview.internal.DeviceEncoders.VideoException e4) {
                                    e = e4;
                                }
                            } catch (com.otaliastudios.cameraview.internal.DeviceEncoders.AudioException e5) {
                                e = e5;
                                size2 = supportedVideoSize;
                                i10 = supportedVideoBitRate;
                            } catch (com.otaliastudios.cameraview.internal.DeviceEncoders.VideoException e6) {
                                e = e6;
                                size2 = supportedVideoSize;
                                i10 = supportedVideoBitRate;
                            }
                        } catch (com.otaliastudios.cameraview.internal.DeviceEncoders.AudioException e7) {
                            e = e7;
                            size2 = supportedVideoSize;
                        } catch (com.otaliastudios.cameraview.internal.DeviceEncoders.VideoException e8) {
                            e = e8;
                            size2 = supportedVideoSize;
                        }
                    } catch (com.otaliastudios.cameraview.internal.DeviceEncoders.AudioException e9) {
                        e = e9;
                    } catch (com.otaliastudios.cameraview.internal.DeviceEncoders.VideoException e10) {
                        e = e10;
                    }
                } catch (java.lang.RuntimeException unused) {
                    p.w("Could not respect encoders parameters.", "Going on again without checking encoders, possibly failing.");
                    com.otaliastudios.cameraview.VideoResult.Stub stub3 = this.a;
                    size = stub3.size;
                    i2 = stub3.videoBitRate;
                    i4 = stub3.videoFrameRate;
                    i3 = stub3.audioBitRate;
                }
            }
            size = size2;
            i2 = i10;
            i3 = i11;
            i4 = i12;
            com.otaliastudios.cameraview.VideoResult.Stub stub4 = this.a;
            stub4.size = size;
            stub4.videoBitRate = i2;
            stub4.audioBitRate = i3;
            stub4.videoFrameRate = i4;
            textureConfig.width = size.getWidth();
            textureConfig.height = this.a.size.getHeight();
            com.otaliastudios.cameraview.VideoResult.Stub stub5 = this.a;
            textureConfig.bitRate = stub5.videoBitRate;
            textureConfig.frameRate = stub5.videoFrameRate;
            textureConfig.rotation = i + stub5.rotation;
            textureConfig.mimeType = str;
            textureConfig.encoder = deviceEncoders.getVideoEncoder();
            textureConfig.textureId = this.k;
            textureConfig.scaleX = f;
            textureConfig.scaleY = f2;
            textureConfig.eglContext = android.opengl.EGL14.eglGetCurrentContext();
            if (this.n) {
                textureConfig.overlayTarget = com.otaliastudios.cameraview.overlay.Overlay.Target.VIDEO_SNAPSHOT;
                textureConfig.overlayDrawer = this.m;
                textureConfig.overlayRotation = this.a.rotation;
            }
            com.otaliastudios.cameraview.video.encoding.TextureMediaEncoder textureMediaEncoder = new com.otaliastudios.cameraview.video.encoding.TextureMediaEncoder(textureConfig);
            com.otaliastudios.cameraview.VideoResult.Stub stub6 = this.a;
            stub6.rotation = 0;
            this.o.setSize(stub6.size.getWidth(), this.a.size.getWidth());
            if (z) {
                audioConfig.bitRate = this.a.audioBitRate;
                audioConfig.channels = i7;
                audioConfig.encoder = deviceEncoders.getAudioEncoder();
                audioMediaEncoder = new com.otaliastudios.cameraview.video.encoding.AudioMediaEncoder(audioConfig);
            } else {
                audioMediaEncoder = null;
            }
            synchronized (this.g) {
                com.otaliastudios.cameraview.VideoResult.Stub stub7 = this.a;
                com.otaliastudios.cameraview.video.encoding.MediaEncoderEngine mediaEncoderEngine = new com.otaliastudios.cameraview.video.encoding.MediaEncoderEngine(stub7.file, textureMediaEncoder, audioMediaEncoder, stub7.maxDuration, stub7.maxSize, this);
                this.f = mediaEncoderEngine;
                mediaEncoderEngine.notify("filter", this.o);
                this.f.start();
            }
            this.i = 0;
        }
        if (this.i == 0) {
            com.otaliastudios.cameraview.CameraLogger cameraLogger2 = p;
            cameraLogger2.i("scheduling frame.");
            synchronized (this.g) {
                if (this.f != null) {
                    cameraLogger2.i("dispatching frame.");
                    com.otaliastudios.cameraview.video.encoding.TextureMediaEncoder.Frame acquireFrame = ((com.otaliastudios.cameraview.video.encoding.TextureMediaEncoder) this.f.getVideoEncoder()).acquireFrame();
                    acquireFrame.timestampNanos = surfaceTexture.getTimestamp();
                    acquireFrame.timestampMillis = java.lang.System.currentTimeMillis();
                    surfaceTexture.getTransformMatrix(acquireFrame.transform);
                    this.f.notify(com.otaliastudios.cameraview.video.encoding.TextureMediaEncoder.FRAME_EVENT, acquireFrame);
                }
            }
        }
        if (this.i == 0 && this.j == 1) {
            p.i("Stopping the encoder engine.");
            this.i = 1;
            synchronized (this.g) {
                com.otaliastudios.cameraview.video.encoding.MediaEncoderEngine mediaEncoderEngine2 = this.f;
                if (mediaEncoderEngine2 != null) {
                    mediaEncoderEngine2.stop();
                    this.f = null;
                }
            }
        }
    }

    @Override // com.otaliastudios.cameraview.preview.RendererFrameCallback
    @com.otaliastudios.cameraview.preview.RendererThread
    public void onRendererTextureCreated(int i) {
        this.k = i;
        if (this.n) {
            this.m = new com.otaliastudios.cameraview.overlay.OverlayDrawer(this.l, this.a.size);
        }
    }

    @Override // com.otaliastudios.cameraview.video.VideoRecorder
    public void onStart() {
        this.h.addRendererFrameCallback(this);
        this.j = 0;
        dispatchVideoRecordingStart();
    }

    @Override // com.otaliastudios.cameraview.video.VideoRecorder
    public void onStop(boolean z) {
        if (!z) {
            this.j = 1;
            return;
        }
        p.i("Stopping the encoder engine from isCameraShutdown.");
        this.j = 1;
        this.i = 1;
        synchronized (this.g) {
            com.otaliastudios.cameraview.video.encoding.MediaEncoderEngine mediaEncoderEngine = this.f;
            if (mediaEncoderEngine != null) {
                mediaEncoderEngine.stop();
                this.f = null;
            }
        }
    }
}
