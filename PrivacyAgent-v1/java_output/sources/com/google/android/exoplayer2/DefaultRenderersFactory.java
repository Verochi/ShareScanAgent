package com.google.android.exoplayer2;

/* loaded from: classes22.dex */
public class DefaultRenderersFactory implements com.google.android.exoplayer2.RenderersFactory {
    public static final long DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS = 5000;
    public static final int EXTENSION_RENDERER_MODE_OFF = 0;
    public static final int EXTENSION_RENDERER_MODE_ON = 1;
    public static final int EXTENSION_RENDERER_MODE_PREFER = 2;
    protected static final int MAX_DROPPED_VIDEO_FRAME_COUNT_TO_NOTIFY = 50;
    public final android.content.Context a;
    public int b;
    public long c;
    public boolean d;
    public com.google.android.exoplayer2.mediacodec.MediaCodecSelector e;
    public int f;
    public int g;
    public boolean h;
    public boolean i;
    public boolean j;

    @java.lang.annotation.Documented
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface ExtensionRendererMode {
    }

    public DefaultRenderersFactory(android.content.Context context) {
        this.a = context;
        this.b = 0;
        this.c = 5000L;
        this.e = com.google.android.exoplayer2.mediacodec.MediaCodecSelector.DEFAULT;
        this.f = 0;
        this.g = 0;
    }

    @java.lang.Deprecated
    public DefaultRenderersFactory(android.content.Context context, int i) {
        this(context, i, 5000L);
    }

    @java.lang.Deprecated
    public DefaultRenderersFactory(android.content.Context context, int i, long j) {
        this.a = context;
        this.b = i;
        this.c = j;
        this.e = com.google.android.exoplayer2.mediacodec.MediaCodecSelector.DEFAULT;
    }

    public void buildAudioRenderers(android.content.Context context, int i, com.google.android.exoplayer2.mediacodec.MediaCodecSelector mediaCodecSelector, boolean z, com.google.android.exoplayer2.audio.AudioSink audioSink, android.os.Handler handler, com.google.android.exoplayer2.audio.AudioRendererEventListener audioRendererEventListener, java.util.ArrayList<com.google.android.exoplayer2.Renderer> arrayList) {
        int i2;
        int i3;
        com.google.android.exoplayer2.audio.MediaCodecAudioRenderer mediaCodecAudioRenderer = new com.google.android.exoplayer2.audio.MediaCodecAudioRenderer(context, mediaCodecSelector, z, handler, audioRendererEventListener, audioSink);
        mediaCodecAudioRenderer.experimentalSetMediaCodecOperationMode(this.f);
        arrayList.add(mediaCodecAudioRenderer);
        if (i == 0) {
            return;
        }
        int size = arrayList.size();
        if (i == 2) {
            size--;
        }
        try {
            try {
                i2 = size + 1;
                try {
                    arrayList.add(size, (com.google.android.exoplayer2.Renderer) java.lang.Class.forName("com.google.android.exoplayer2.ext.opus.LibopusAudioRenderer").getConstructor(android.os.Handler.class, com.google.android.exoplayer2.audio.AudioRendererEventListener.class, com.google.android.exoplayer2.audio.AudioSink.class).newInstance(handler, audioRendererEventListener, audioSink));
                    com.google.android.exoplayer2.util.Log.i("DefaultRenderersFactory", "Loaded LibopusAudioRenderer.");
                } catch (java.lang.ClassNotFoundException unused) {
                    size = i2;
                    i2 = size;
                    try {
                        i3 = i2 + 1;
                        try {
                            arrayList.add(i2, (com.google.android.exoplayer2.Renderer) java.lang.Class.forName("com.google.android.exoplayer2.ext.flac.LibflacAudioRenderer").getConstructor(android.os.Handler.class, com.google.android.exoplayer2.audio.AudioRendererEventListener.class, com.google.android.exoplayer2.audio.AudioSink.class).newInstance(handler, audioRendererEventListener, audioSink));
                            com.google.android.exoplayer2.util.Log.i("DefaultRenderersFactory", "Loaded LibflacAudioRenderer.");
                        } catch (java.lang.ClassNotFoundException unused2) {
                            i2 = i3;
                            i3 = i2;
                            arrayList.add(i3, (com.google.android.exoplayer2.Renderer) java.lang.Class.forName("com.google.android.exoplayer2.ext.ffmpeg.FfmpegAudioRenderer").getConstructor(android.os.Handler.class, com.google.android.exoplayer2.audio.AudioRendererEventListener.class, com.google.android.exoplayer2.audio.AudioSink.class).newInstance(handler, audioRendererEventListener, audioSink));
                            com.google.android.exoplayer2.util.Log.i("DefaultRenderersFactory", "Loaded FfmpegAudioRenderer.");
                        }
                    } catch (java.lang.ClassNotFoundException unused3) {
                    }
                    arrayList.add(i3, (com.google.android.exoplayer2.Renderer) java.lang.Class.forName("com.google.android.exoplayer2.ext.ffmpeg.FfmpegAudioRenderer").getConstructor(android.os.Handler.class, com.google.android.exoplayer2.audio.AudioRendererEventListener.class, com.google.android.exoplayer2.audio.AudioSink.class).newInstance(handler, audioRendererEventListener, audioSink));
                    com.google.android.exoplayer2.util.Log.i("DefaultRenderersFactory", "Loaded FfmpegAudioRenderer.");
                }
            } catch (java.lang.ClassNotFoundException unused4) {
            }
            try {
                i3 = i2 + 1;
                arrayList.add(i2, (com.google.android.exoplayer2.Renderer) java.lang.Class.forName("com.google.android.exoplayer2.ext.flac.LibflacAudioRenderer").getConstructor(android.os.Handler.class, com.google.android.exoplayer2.audio.AudioRendererEventListener.class, com.google.android.exoplayer2.audio.AudioSink.class).newInstance(handler, audioRendererEventListener, audioSink));
                com.google.android.exoplayer2.util.Log.i("DefaultRenderersFactory", "Loaded LibflacAudioRenderer.");
                try {
                    arrayList.add(i3, (com.google.android.exoplayer2.Renderer) java.lang.Class.forName("com.google.android.exoplayer2.ext.ffmpeg.FfmpegAudioRenderer").getConstructor(android.os.Handler.class, com.google.android.exoplayer2.audio.AudioRendererEventListener.class, com.google.android.exoplayer2.audio.AudioSink.class).newInstance(handler, audioRendererEventListener, audioSink));
                    com.google.android.exoplayer2.util.Log.i("DefaultRenderersFactory", "Loaded FfmpegAudioRenderer.");
                } catch (java.lang.ClassNotFoundException unused5) {
                } catch (java.lang.Exception e) {
                    throw new java.lang.RuntimeException("Error instantiating FFmpeg extension", e);
                }
            } catch (java.lang.Exception e2) {
                throw new java.lang.RuntimeException("Error instantiating FLAC extension", e2);
            }
        } catch (java.lang.Exception e3) {
            throw new java.lang.RuntimeException("Error instantiating Opus extension", e3);
        }
    }

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.audio.AudioSink buildAudioSink(android.content.Context context, boolean z, boolean z2, boolean z3) {
        return new com.google.android.exoplayer2.audio.DefaultAudioSink(com.google.android.exoplayer2.audio.AudioCapabilities.getCapabilities(context), new com.google.android.exoplayer2.audio.DefaultAudioSink.DefaultAudioProcessorChain(new com.google.android.exoplayer2.audio.AudioProcessor[0]), z, z2, z3);
    }

    public void buildCameraMotionRenderers(android.content.Context context, int i, java.util.ArrayList<com.google.android.exoplayer2.Renderer> arrayList) {
        arrayList.add(new com.google.android.exoplayer2.video.spherical.CameraMotionRenderer());
    }

    public void buildMetadataRenderers(android.content.Context context, com.google.android.exoplayer2.metadata.MetadataOutput metadataOutput, android.os.Looper looper, int i, java.util.ArrayList<com.google.android.exoplayer2.Renderer> arrayList) {
        arrayList.add(new com.google.android.exoplayer2.metadata.MetadataRenderer(metadataOutput, looper));
    }

    public void buildMiscellaneousRenderers(android.content.Context context, android.os.Handler handler, int i, java.util.ArrayList<com.google.android.exoplayer2.Renderer> arrayList) {
    }

    public void buildTextRenderers(android.content.Context context, com.google.android.exoplayer2.text.TextOutput textOutput, android.os.Looper looper, int i, java.util.ArrayList<com.google.android.exoplayer2.Renderer> arrayList) {
        arrayList.add(new com.google.android.exoplayer2.text.TextRenderer(textOutput, looper));
    }

    public void buildVideoRenderers(android.content.Context context, int i, com.google.android.exoplayer2.mediacodec.MediaCodecSelector mediaCodecSelector, boolean z, android.os.Handler handler, com.google.android.exoplayer2.video.VideoRendererEventListener videoRendererEventListener, long j, java.util.ArrayList<com.google.android.exoplayer2.Renderer> arrayList) {
        int i2;
        com.google.android.exoplayer2.video.MediaCodecVideoRenderer mediaCodecVideoRenderer = new com.google.android.exoplayer2.video.MediaCodecVideoRenderer(context, mediaCodecSelector, j, z, handler, videoRendererEventListener, 50);
        mediaCodecVideoRenderer.experimentalSetMediaCodecOperationMode(this.g);
        arrayList.add(mediaCodecVideoRenderer);
        if (i == 0) {
            return;
        }
        int size = arrayList.size();
        if (i == 2) {
            size--;
        }
        try {
            try {
                i2 = size + 1;
                try {
                    arrayList.add(size, (com.google.android.exoplayer2.Renderer) java.lang.Class.forName("com.google.android.exoplayer2.ext.vp9.LibvpxVideoRenderer").getConstructor(java.lang.Long.TYPE, android.os.Handler.class, com.google.android.exoplayer2.video.VideoRendererEventListener.class, java.lang.Integer.TYPE).newInstance(java.lang.Long.valueOf(j), handler, videoRendererEventListener, 50));
                    com.google.android.exoplayer2.util.Log.i("DefaultRenderersFactory", "Loaded LibvpxVideoRenderer.");
                } catch (java.lang.ClassNotFoundException unused) {
                    size = i2;
                    i2 = size;
                    arrayList.add(i2, (com.google.android.exoplayer2.Renderer) java.lang.Class.forName("com.google.android.exoplayer2.ext.av1.Libgav1VideoRenderer").getConstructor(java.lang.Long.TYPE, android.os.Handler.class, com.google.android.exoplayer2.video.VideoRendererEventListener.class, java.lang.Integer.TYPE).newInstance(java.lang.Long.valueOf(j), handler, videoRendererEventListener, 50));
                    com.google.android.exoplayer2.util.Log.i("DefaultRenderersFactory", "Loaded Libgav1VideoRenderer.");
                }
            } catch (java.lang.ClassNotFoundException unused2) {
            }
            try {
                arrayList.add(i2, (com.google.android.exoplayer2.Renderer) java.lang.Class.forName("com.google.android.exoplayer2.ext.av1.Libgav1VideoRenderer").getConstructor(java.lang.Long.TYPE, android.os.Handler.class, com.google.android.exoplayer2.video.VideoRendererEventListener.class, java.lang.Integer.TYPE).newInstance(java.lang.Long.valueOf(j), handler, videoRendererEventListener, 50));
                com.google.android.exoplayer2.util.Log.i("DefaultRenderersFactory", "Loaded Libgav1VideoRenderer.");
            } catch (java.lang.ClassNotFoundException unused3) {
            } catch (java.lang.Exception e) {
                throw new java.lang.RuntimeException("Error instantiating AV1 extension", e);
            }
        } catch (java.lang.Exception e2) {
            throw new java.lang.RuntimeException("Error instantiating VP9 extension", e2);
        }
    }

    @Override // com.google.android.exoplayer2.RenderersFactory
    public com.google.android.exoplayer2.Renderer[] createRenderers(android.os.Handler handler, com.google.android.exoplayer2.video.VideoRendererEventListener videoRendererEventListener, com.google.android.exoplayer2.audio.AudioRendererEventListener audioRendererEventListener, com.google.android.exoplayer2.text.TextOutput textOutput, com.google.android.exoplayer2.metadata.MetadataOutput metadataOutput) {
        java.util.ArrayList<com.google.android.exoplayer2.Renderer> arrayList = new java.util.ArrayList<>();
        buildVideoRenderers(this.a, this.b, this.e, this.d, handler, videoRendererEventListener, this.c, arrayList);
        com.google.android.exoplayer2.audio.AudioSink buildAudioSink = buildAudioSink(this.a, this.h, this.i, this.j);
        if (buildAudioSink != null) {
            buildAudioRenderers(this.a, this.b, this.e, this.d, buildAudioSink, handler, audioRendererEventListener, arrayList);
        }
        buildTextRenderers(this.a, textOutput, handler.getLooper(), this.b, arrayList);
        buildMetadataRenderers(this.a, metadataOutput, handler.getLooper(), this.b, arrayList);
        buildCameraMotionRenderers(this.a, this.b, arrayList);
        buildMiscellaneousRenderers(this.a, handler, this.b, arrayList);
        return (com.google.android.exoplayer2.Renderer[]) arrayList.toArray(new com.google.android.exoplayer2.Renderer[0]);
    }

    public com.google.android.exoplayer2.DefaultRenderersFactory experimentalSetAudioMediaCodecOperationMode(int i) {
        this.f = i;
        return this;
    }

    public com.google.android.exoplayer2.DefaultRenderersFactory experimentalSetMediaCodecOperationMode(int i) {
        experimentalSetAudioMediaCodecOperationMode(i);
        experimentalSetVideoMediaCodecOperationMode(i);
        return this;
    }

    public com.google.android.exoplayer2.DefaultRenderersFactory experimentalSetVideoMediaCodecOperationMode(int i) {
        this.g = i;
        return this;
    }

    public com.google.android.exoplayer2.DefaultRenderersFactory setAllowedVideoJoiningTimeMs(long j) {
        this.c = j;
        return this;
    }

    public com.google.android.exoplayer2.DefaultRenderersFactory setEnableAudioFloatOutput(boolean z) {
        this.h = z;
        return this;
    }

    public com.google.android.exoplayer2.DefaultRenderersFactory setEnableAudioOffload(boolean z) {
        this.j = z;
        return this;
    }

    public com.google.android.exoplayer2.DefaultRenderersFactory setEnableAudioTrackPlaybackParams(boolean z) {
        this.i = z;
        return this;
    }

    public com.google.android.exoplayer2.DefaultRenderersFactory setEnableDecoderFallback(boolean z) {
        this.d = z;
        return this;
    }

    public com.google.android.exoplayer2.DefaultRenderersFactory setExtensionRendererMode(int i) {
        this.b = i;
        return this;
    }

    public com.google.android.exoplayer2.DefaultRenderersFactory setMediaCodecSelector(com.google.android.exoplayer2.mediacodec.MediaCodecSelector mediaCodecSelector) {
        this.e = mediaCodecSelector;
        return this;
    }
}
