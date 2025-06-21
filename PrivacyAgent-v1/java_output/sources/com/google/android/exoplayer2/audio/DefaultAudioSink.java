package com.google.android.exoplayer2.audio;

/* loaded from: classes22.dex */
public final class DefaultAudioSink implements com.google.android.exoplayer2.audio.AudioSink {
    public static final float DEFAULT_PLAYBACK_SPEED = 1.0f;
    public static final float MAX_PITCH = 8.0f;
    public static final float MAX_PLAYBACK_SPEED = 8.0f;
    public static final float MIN_PITCH = 0.1f;
    public static final float MIN_PLAYBACK_SPEED = 0.1f;
    public static boolean enablePreV21AudioSessionWorkaround;
    public static boolean failOnSpuriousAudioTimestamp;
    public long A;
    public long B;
    public int C;
    public boolean D;
    public boolean E;
    public long F;
    public float G;
    public com.google.android.exoplayer2.audio.AudioProcessor[] H;
    public java.nio.ByteBuffer[] I;

    @androidx.annotation.Nullable
    public java.nio.ByteBuffer J;
    public int K;

    @androidx.annotation.Nullable
    public java.nio.ByteBuffer L;
    public byte[] M;
    public int N;
    public int O;
    public boolean P;
    public boolean Q;
    public boolean R;
    public int S;
    public com.google.android.exoplayer2.audio.AuxEffectInfo T;
    public boolean U;
    public long V;
    public boolean W;
    public boolean X;

    @androidx.annotation.Nullable
    public final com.google.android.exoplayer2.audio.AudioCapabilities a;
    public final com.google.android.exoplayer2.audio.DefaultAudioSink.AudioProcessorChain b;
    public final boolean c;
    public final com.google.android.exoplayer2.audio.ChannelMappingAudioProcessor d;
    public final com.google.android.exoplayer2.audio.TrimmingAudioProcessor e;
    public final com.google.android.exoplayer2.audio.AudioProcessor[] f;
    public final com.google.android.exoplayer2.audio.AudioProcessor[] g;
    public final android.os.ConditionVariable h;
    public final com.google.android.exoplayer2.audio.AudioTrackPositionTracker i;
    public final java.util.ArrayDeque<com.google.android.exoplayer2.audio.DefaultAudioSink.MediaPositionParameters> j;
    public final boolean k;
    public final boolean l;
    public com.google.android.exoplayer2.audio.DefaultAudioSink.StreamEventCallbackV29 m;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.audio.AudioSink.Listener n;

    @androidx.annotation.Nullable
    public android.media.AudioTrack o;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.audio.DefaultAudioSink.Configuration p;
    public com.google.android.exoplayer2.audio.DefaultAudioSink.Configuration q;

    @androidx.annotation.Nullable
    public android.media.AudioTrack r;

    /* renamed from: s, reason: collision with root package name */
    public com.google.android.exoplayer2.audio.AudioAttributes f343s;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.audio.DefaultAudioSink.MediaPositionParameters t;
    public com.google.android.exoplayer2.audio.DefaultAudioSink.MediaPositionParameters u;
    public com.google.android.exoplayer2.PlaybackParameters v;

    @androidx.annotation.Nullable
    public java.nio.ByteBuffer w;
    public int x;
    public long y;
    public long z;

    /* renamed from: com.google.android.exoplayer2.audio.DefaultAudioSink$1, reason: invalid class name */
    public class AnonymousClass1 extends java.lang.Thread {
        public final /* synthetic */ android.media.AudioTrack n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(java.lang.String str, android.media.AudioTrack audioTrack) {
            super(str);
            this.n = audioTrack;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                this.n.flush();
                this.n.release();
            } finally {
                com.google.android.exoplayer2.audio.DefaultAudioSink.this.h.open();
            }
        }
    }

    /* renamed from: com.google.android.exoplayer2.audio.DefaultAudioSink$2, reason: invalid class name */
    public class AnonymousClass2 extends java.lang.Thread {
        public final /* synthetic */ android.media.AudioTrack n;

        public AnonymousClass2(com.google.android.exoplayer2.audio.DefaultAudioSink defaultAudioSink, android.media.AudioTrack audioTrack) {
            this.n = audioTrack;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            this.n.release();
        }
    }

    public interface AudioProcessorChain {
        com.google.android.exoplayer2.PlaybackParameters applyPlaybackParameters(com.google.android.exoplayer2.PlaybackParameters playbackParameters);

        boolean applySkipSilenceEnabled(boolean z);

        com.google.android.exoplayer2.audio.AudioProcessor[] getAudioProcessors();

        long getMediaDuration(long j);

        long getSkippedOutputFrameCount();
    }

    public static final class Configuration {
        public final com.google.android.exoplayer2.Format a;
        public final int b;
        public final int c;
        public final int d;
        public final int e;
        public final int f;
        public final int g;
        public final int h;
        public final boolean i;
        public final com.google.android.exoplayer2.audio.AudioProcessor[] j;

        public Configuration(com.google.android.exoplayer2.Format format, int i, int i2, int i3, int i4, int i5, int i6, int i7, boolean z, boolean z2, com.google.android.exoplayer2.audio.AudioProcessor[] audioProcessorArr) {
            this.a = format;
            this.b = i;
            this.c = i2;
            this.d = i3;
            this.e = i4;
            this.f = i5;
            this.g = i6;
            this.i = z2;
            this.j = audioProcessorArr;
            this.h = c(i7, z);
        }

        @androidx.annotation.RequiresApi(21)
        public static android.media.AudioAttributes j(com.google.android.exoplayer2.audio.AudioAttributes audioAttributes, boolean z) {
            return z ? k() : audioAttributes.getAudioAttributesV21();
        }

        @androidx.annotation.RequiresApi(21)
        public static android.media.AudioAttributes k() {
            return new android.media.AudioAttributes.Builder().setContentType(3).setFlags(16).setUsage(1).build();
        }

        public android.media.AudioTrack a(boolean z, com.google.android.exoplayer2.audio.AudioAttributes audioAttributes, int i) throws com.google.android.exoplayer2.audio.AudioSink.InitializationException {
            try {
                android.media.AudioTrack d = d(z, audioAttributes, i);
                int state = d.getState();
                if (state == 1) {
                    return d;
                }
                try {
                    d.release();
                } catch (java.lang.Exception unused) {
                }
                throw new com.google.android.exoplayer2.audio.AudioSink.InitializationException(state, this.e, this.f, this.h);
            } catch (java.lang.UnsupportedOperationException unused2) {
                throw new com.google.android.exoplayer2.audio.AudioSink.InitializationException(0, this.e, this.f, this.h);
            }
        }

        public boolean b(com.google.android.exoplayer2.audio.DefaultAudioSink.Configuration configuration) {
            return configuration.c == this.c && configuration.g == this.g && configuration.e == this.e && configuration.f == this.f && configuration.d == this.d;
        }

        public final int c(int i, boolean z) {
            if (i != 0) {
                return i;
            }
            int i2 = this.c;
            if (i2 == 0) {
                return m(z ? 8.0f : 1.0f);
            }
            if (i2 == 1) {
                return l(50000000L);
            }
            if (i2 == 2) {
                return l(250000L);
            }
            throw new java.lang.IllegalStateException();
        }

        public final android.media.AudioTrack d(boolean z, com.google.android.exoplayer2.audio.AudioAttributes audioAttributes, int i) {
            int i2 = com.google.android.exoplayer2.util.Util.SDK_INT;
            return i2 >= 29 ? f(z, audioAttributes, i) : i2 >= 21 ? e(z, audioAttributes, i) : g(audioAttributes, i);
        }

        @androidx.annotation.RequiresApi(21)
        public final android.media.AudioTrack e(boolean z, com.google.android.exoplayer2.audio.AudioAttributes audioAttributes, int i) {
            return new android.media.AudioTrack(j(audioAttributes, z), com.google.android.exoplayer2.audio.DefaultAudioSink.p(this.e, this.f, this.g), this.h, 1, i);
        }

        @androidx.annotation.RequiresApi(29)
        public final android.media.AudioTrack f(boolean z, com.google.android.exoplayer2.audio.AudioAttributes audioAttributes, int i) {
            android.media.AudioTrack.Builder audioAttributes2;
            android.media.AudioTrack.Builder audioFormat;
            android.media.AudioTrack.Builder transferMode;
            android.media.AudioTrack.Builder bufferSizeInBytes;
            android.media.AudioTrack.Builder sessionId;
            android.media.AudioTrack.Builder offloadedPlayback;
            android.media.AudioTrack build;
            android.media.AudioFormat p = com.google.android.exoplayer2.audio.DefaultAudioSink.p(this.e, this.f, this.g);
            audioAttributes2 = new android.media.AudioTrack.Builder().setAudioAttributes(j(audioAttributes, z));
            audioFormat = audioAttributes2.setAudioFormat(p);
            transferMode = audioFormat.setTransferMode(1);
            bufferSizeInBytes = transferMode.setBufferSizeInBytes(this.h);
            sessionId = bufferSizeInBytes.setSessionId(i);
            offloadedPlayback = sessionId.setOffloadedPlayback(this.c == 1);
            build = offloadedPlayback.build();
            return build;
        }

        public final android.media.AudioTrack g(com.google.android.exoplayer2.audio.AudioAttributes audioAttributes, int i) {
            int streamTypeForAudioUsage = com.google.android.exoplayer2.util.Util.getStreamTypeForAudioUsage(audioAttributes.usage);
            return i == 0 ? new android.media.AudioTrack(streamTypeForAudioUsage, this.e, this.f, this.g, this.h, 1) : new android.media.AudioTrack(streamTypeForAudioUsage, this.e, this.f, this.g, this.h, 1, i);
        }

        public long h(long j) {
            return (j * this.e) / 1000000;
        }

        public long i(long j) {
            return (j * 1000000) / this.e;
        }

        public final int l(long j) {
            int u = com.google.android.exoplayer2.audio.DefaultAudioSink.u(this.g);
            if (this.g == 5) {
                u *= 2;
            }
            return (int) ((j * u) / 1000000);
        }

        public final int m(float f) {
            int minBufferSize = android.media.AudioTrack.getMinBufferSize(this.e, this.f, this.g);
            com.google.android.exoplayer2.util.Assertions.checkState(minBufferSize != -2);
            int constrainValue = com.google.android.exoplayer2.util.Util.constrainValue(minBufferSize * 4, ((int) h(250000L)) * this.d, java.lang.Math.max(minBufferSize, ((int) h(750000L)) * this.d));
            return f != 1.0f ? java.lang.Math.round(constrainValue * f) : constrainValue;
        }

        public long n(long j) {
            return (j * 1000000) / this.a.sampleRate;
        }

        public boolean o() {
            return this.c == 1;
        }
    }

    public static class DefaultAudioProcessorChain implements com.google.android.exoplayer2.audio.DefaultAudioSink.AudioProcessorChain {
        public final com.google.android.exoplayer2.audio.AudioProcessor[] a;
        public final com.google.android.exoplayer2.audio.SilenceSkippingAudioProcessor b;
        public final com.google.android.exoplayer2.audio.SonicAudioProcessor c;

        public DefaultAudioProcessorChain(com.google.android.exoplayer2.audio.AudioProcessor... audioProcessorArr) {
            this(audioProcessorArr, new com.google.android.exoplayer2.audio.SilenceSkippingAudioProcessor(), new com.google.android.exoplayer2.audio.SonicAudioProcessor());
        }

        public DefaultAudioProcessorChain(com.google.android.exoplayer2.audio.AudioProcessor[] audioProcessorArr, com.google.android.exoplayer2.audio.SilenceSkippingAudioProcessor silenceSkippingAudioProcessor, com.google.android.exoplayer2.audio.SonicAudioProcessor sonicAudioProcessor) {
            com.google.android.exoplayer2.audio.AudioProcessor[] audioProcessorArr2 = new com.google.android.exoplayer2.audio.AudioProcessor[audioProcessorArr.length + 2];
            this.a = audioProcessorArr2;
            java.lang.System.arraycopy(audioProcessorArr, 0, audioProcessorArr2, 0, audioProcessorArr.length);
            this.b = silenceSkippingAudioProcessor;
            this.c = sonicAudioProcessor;
            audioProcessorArr2[audioProcessorArr.length] = silenceSkippingAudioProcessor;
            audioProcessorArr2[audioProcessorArr.length + 1] = sonicAudioProcessor;
        }

        @Override // com.google.android.exoplayer2.audio.DefaultAudioSink.AudioProcessorChain
        public com.google.android.exoplayer2.PlaybackParameters applyPlaybackParameters(com.google.android.exoplayer2.PlaybackParameters playbackParameters) {
            return new com.google.android.exoplayer2.PlaybackParameters(this.c.setSpeed(playbackParameters.speed), this.c.setPitch(playbackParameters.pitch));
        }

        @Override // com.google.android.exoplayer2.audio.DefaultAudioSink.AudioProcessorChain
        public boolean applySkipSilenceEnabled(boolean z) {
            this.b.setEnabled(z);
            return z;
        }

        @Override // com.google.android.exoplayer2.audio.DefaultAudioSink.AudioProcessorChain
        public com.google.android.exoplayer2.audio.AudioProcessor[] getAudioProcessors() {
            return this.a;
        }

        @Override // com.google.android.exoplayer2.audio.DefaultAudioSink.AudioProcessorChain
        public long getMediaDuration(long j) {
            return this.c.scaleDurationForSpeedup(j);
        }

        @Override // com.google.android.exoplayer2.audio.DefaultAudioSink.AudioProcessorChain
        public long getSkippedOutputFrameCount() {
            return this.b.getSkippedFrames();
        }
    }

    public static final class InvalidAudioTrackTimestampException extends java.lang.RuntimeException {
        private InvalidAudioTrackTimestampException(java.lang.String str) {
            super(str);
        }

        public /* synthetic */ InvalidAudioTrackTimestampException(java.lang.String str, com.google.android.exoplayer2.audio.DefaultAudioSink.AnonymousClass1 anonymousClass1) {
            this(str);
        }
    }

    public static final class MediaPositionParameters {
        public final com.google.android.exoplayer2.PlaybackParameters a;
        public final boolean b;
        public final long c;
        public final long d;

        public MediaPositionParameters(com.google.android.exoplayer2.PlaybackParameters playbackParameters, boolean z, long j, long j2) {
            this.a = playbackParameters;
            this.b = z;
            this.c = j;
            this.d = j2;
        }

        public /* synthetic */ MediaPositionParameters(com.google.android.exoplayer2.PlaybackParameters playbackParameters, boolean z, long j, long j2, com.google.android.exoplayer2.audio.DefaultAudioSink.AnonymousClass1 anonymousClass1) {
            this(playbackParameters, z, j, j2);
        }
    }

    public final class PositionTrackerListener implements com.google.android.exoplayer2.audio.AudioTrackPositionTracker.Listener {
        public PositionTrackerListener() {
        }

        public /* synthetic */ PositionTrackerListener(com.google.android.exoplayer2.audio.DefaultAudioSink defaultAudioSink, com.google.android.exoplayer2.audio.DefaultAudioSink.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.google.android.exoplayer2.audio.AudioTrackPositionTracker.Listener
        public void onInvalidLatency(long j) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder(61);
            sb.append("Ignoring impossibly large audio latency: ");
            sb.append(j);
            com.google.android.exoplayer2.util.Log.w("AudioTrack", sb.toString());
        }

        @Override // com.google.android.exoplayer2.audio.AudioTrackPositionTracker.Listener
        public void onPositionAdvancing(long j) {
            if (com.google.android.exoplayer2.audio.DefaultAudioSink.this.n != null) {
                com.google.android.exoplayer2.audio.DefaultAudioSink.this.n.onPositionAdvancing(j);
            }
        }

        @Override // com.google.android.exoplayer2.audio.AudioTrackPositionTracker.Listener
        public void onPositionFramesMismatch(long j, long j2, long j3, long j4) {
            long w = com.google.android.exoplayer2.audio.DefaultAudioSink.this.w();
            long x = com.google.android.exoplayer2.audio.DefaultAudioSink.this.x();
            java.lang.StringBuilder sb = new java.lang.StringBuilder(182);
            sb.append("Spurious audio timestamp (frame position mismatch): ");
            sb.append(j);
            sb.append(", ");
            sb.append(j2);
            sb.append(", ");
            sb.append(j3);
            sb.append(", ");
            sb.append(j4);
            sb.append(", ");
            sb.append(w);
            sb.append(", ");
            sb.append(x);
            java.lang.String sb2 = sb.toString();
            if (com.google.android.exoplayer2.audio.DefaultAudioSink.failOnSpuriousAudioTimestamp) {
                throw new com.google.android.exoplayer2.audio.DefaultAudioSink.InvalidAudioTrackTimestampException(sb2, null);
            }
            com.google.android.exoplayer2.util.Log.w("AudioTrack", sb2);
        }

        @Override // com.google.android.exoplayer2.audio.AudioTrackPositionTracker.Listener
        public void onSystemTimeUsMismatch(long j, long j2, long j3, long j4) {
            long w = com.google.android.exoplayer2.audio.DefaultAudioSink.this.w();
            long x = com.google.android.exoplayer2.audio.DefaultAudioSink.this.x();
            java.lang.StringBuilder sb = new java.lang.StringBuilder(180);
            sb.append("Spurious audio timestamp (system clock mismatch): ");
            sb.append(j);
            sb.append(", ");
            sb.append(j2);
            sb.append(", ");
            sb.append(j3);
            sb.append(", ");
            sb.append(j4);
            sb.append(", ");
            sb.append(w);
            sb.append(", ");
            sb.append(x);
            java.lang.String sb2 = sb.toString();
            if (com.google.android.exoplayer2.audio.DefaultAudioSink.failOnSpuriousAudioTimestamp) {
                throw new com.google.android.exoplayer2.audio.DefaultAudioSink.InvalidAudioTrackTimestampException(sb2, null);
            }
            com.google.android.exoplayer2.util.Log.w("AudioTrack", sb2);
        }

        @Override // com.google.android.exoplayer2.audio.AudioTrackPositionTracker.Listener
        public void onUnderrun(int i, long j) {
            if (com.google.android.exoplayer2.audio.DefaultAudioSink.this.n != null) {
                com.google.android.exoplayer2.audio.DefaultAudioSink.this.n.onUnderrun(i, j, android.os.SystemClock.elapsedRealtime() - com.google.android.exoplayer2.audio.DefaultAudioSink.this.V);
            }
        }
    }

    @androidx.annotation.RequiresApi(29)
    public final class StreamEventCallbackV29 {
        public final android.os.Handler a = new android.os.Handler();
        public final android.media.AudioTrack.StreamEventCallback b;

        /* renamed from: com.google.android.exoplayer2.audio.DefaultAudioSink$StreamEventCallbackV29$1, reason: invalid class name */
        public class AnonymousClass1 extends android.media.AudioTrack.StreamEventCallback {
            public final /* synthetic */ com.google.android.exoplayer2.audio.DefaultAudioSink a;

            public AnonymousClass1(com.google.android.exoplayer2.audio.DefaultAudioSink defaultAudioSink) {
                this.a = defaultAudioSink;
            }

            @Override // android.media.AudioTrack.StreamEventCallback
            public void onDataRequest(android.media.AudioTrack audioTrack, int i) {
                com.google.android.exoplayer2.util.Assertions.checkState(audioTrack == com.google.android.exoplayer2.audio.DefaultAudioSink.this.r);
                if (com.google.android.exoplayer2.audio.DefaultAudioSink.this.n != null) {
                    com.google.android.exoplayer2.audio.DefaultAudioSink.this.n.onOffloadBufferEmptying();
                }
            }

            @Override // android.media.AudioTrack.StreamEventCallback
            public void onTearDown(@androidx.annotation.NonNull android.media.AudioTrack audioTrack) {
                if (com.google.android.exoplayer2.audio.DefaultAudioSink.this.n == null || !com.google.android.exoplayer2.audio.DefaultAudioSink.this.R) {
                    return;
                }
                com.google.android.exoplayer2.audio.DefaultAudioSink.this.n.onOffloadBufferEmptying();
            }
        }

        public StreamEventCallbackV29() {
            this.b = new com.google.android.exoplayer2.audio.DefaultAudioSink.StreamEventCallbackV29.AnonymousClass1(com.google.android.exoplayer2.audio.DefaultAudioSink.this);
        }

        public void a(android.media.AudioTrack audioTrack) {
            android.os.Handler handler = this.a;
            java.util.Objects.requireNonNull(handler);
            audioTrack.registerStreamEventCallback(new defpackage.hz(handler), this.b);
        }

        public void b(android.media.AudioTrack audioTrack) {
            audioTrack.unregisterStreamEventCallback(this.b);
            this.a.removeCallbacksAndMessages(null);
        }
    }

    public DefaultAudioSink(@androidx.annotation.Nullable com.google.android.exoplayer2.audio.AudioCapabilities audioCapabilities, com.google.android.exoplayer2.audio.DefaultAudioSink.AudioProcessorChain audioProcessorChain, boolean z, boolean z2, boolean z3) {
        this.a = audioCapabilities;
        this.b = (com.google.android.exoplayer2.audio.DefaultAudioSink.AudioProcessorChain) com.google.android.exoplayer2.util.Assertions.checkNotNull(audioProcessorChain);
        int i = com.google.android.exoplayer2.util.Util.SDK_INT;
        this.c = i >= 21 && z;
        this.k = i >= 23 && z2;
        this.l = i >= 29 && z3;
        this.h = new android.os.ConditionVariable(true);
        this.i = new com.google.android.exoplayer2.audio.AudioTrackPositionTracker(new com.google.android.exoplayer2.audio.DefaultAudioSink.PositionTrackerListener(this, null));
        com.google.android.exoplayer2.audio.ChannelMappingAudioProcessor channelMappingAudioProcessor = new com.google.android.exoplayer2.audio.ChannelMappingAudioProcessor();
        this.d = channelMappingAudioProcessor;
        com.google.android.exoplayer2.audio.TrimmingAudioProcessor trimmingAudioProcessor = new com.google.android.exoplayer2.audio.TrimmingAudioProcessor();
        this.e = trimmingAudioProcessor;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.Collections.addAll(arrayList, new com.google.android.exoplayer2.audio.ResamplingAudioProcessor(), channelMappingAudioProcessor, trimmingAudioProcessor);
        java.util.Collections.addAll(arrayList, audioProcessorChain.getAudioProcessors());
        this.f = (com.google.android.exoplayer2.audio.AudioProcessor[]) arrayList.toArray(new com.google.android.exoplayer2.audio.AudioProcessor[0]);
        this.g = new com.google.android.exoplayer2.audio.AudioProcessor[]{new com.google.android.exoplayer2.audio.FloatResamplingAudioProcessor()};
        this.G = 1.0f;
        this.f343s = com.google.android.exoplayer2.audio.AudioAttributes.DEFAULT;
        this.S = 0;
        this.T = new com.google.android.exoplayer2.audio.AuxEffectInfo(0, 0.0f);
        com.google.android.exoplayer2.PlaybackParameters playbackParameters = com.google.android.exoplayer2.PlaybackParameters.DEFAULT;
        this.u = new com.google.android.exoplayer2.audio.DefaultAudioSink.MediaPositionParameters(playbackParameters, false, 0L, 0L, null);
        this.v = playbackParameters;
        this.O = -1;
        this.H = new com.google.android.exoplayer2.audio.AudioProcessor[0];
        this.I = new java.nio.ByteBuffer[0];
        this.j = new java.util.ArrayDeque<>();
    }

    public DefaultAudioSink(@androidx.annotation.Nullable com.google.android.exoplayer2.audio.AudioCapabilities audioCapabilities, com.google.android.exoplayer2.audio.AudioProcessor[] audioProcessorArr) {
        this(audioCapabilities, audioProcessorArr, false);
    }

    public DefaultAudioSink(@androidx.annotation.Nullable com.google.android.exoplayer2.audio.AudioCapabilities audioCapabilities, com.google.android.exoplayer2.audio.AudioProcessor[] audioProcessorArr, boolean z) {
        this(audioCapabilities, new com.google.android.exoplayer2.audio.DefaultAudioSink.DefaultAudioProcessorChain(audioProcessorArr), z, false, false);
    }

    public static boolean A(int i) {
        return com.google.android.exoplayer2.util.Util.SDK_INT >= 24 && i == -6;
    }

    public static boolean C() {
        return com.google.android.exoplayer2.util.Util.SDK_INT >= 30 && com.google.android.exoplayer2.util.Util.MODEL.startsWith("Pixel");
    }

    public static boolean D(android.media.AudioTrack audioTrack) {
        boolean isOffloadedPlayback;
        if (com.google.android.exoplayer2.util.Util.SDK_INT >= 29) {
            isOffloadedPlayback = audioTrack.isOffloadedPlayback();
            if (isOffloadedPlayback) {
                return true;
            }
        }
        return false;
    }

    public static boolean E(com.google.android.exoplayer2.Format format, com.google.android.exoplayer2.audio.AudioAttributes audioAttributes) {
        int encoding;
        int audioTrackChannelConfig;
        boolean isOffloadedPlaybackSupported;
        if (com.google.android.exoplayer2.util.Util.SDK_INT < 29 || (encoding = com.google.android.exoplayer2.util.MimeTypes.getEncoding((java.lang.String) com.google.android.exoplayer2.util.Assertions.checkNotNull(format.sampleMimeType), format.codecs)) == 0 || (audioTrackChannelConfig = com.google.android.exoplayer2.util.Util.getAudioTrackChannelConfig(format.channelCount)) == 0) {
            return false;
        }
        isOffloadedPlaybackSupported = android.media.AudioManager.isOffloadedPlaybackSupported(p(format.sampleRate, audioTrackChannelConfig, encoding), audioAttributes.getAudioAttributesV21());
        if (isOffloadedPlaybackSupported) {
            return (format.encoderDelay == 0 && format.encoderPadding == 0) || C();
        }
        return false;
    }

    public static boolean F(com.google.android.exoplayer2.Format format, @androidx.annotation.Nullable com.google.android.exoplayer2.audio.AudioCapabilities audioCapabilities) {
        return s(format, audioCapabilities) != null;
    }

    @androidx.annotation.RequiresApi(21)
    public static void P(android.media.AudioTrack audioTrack, float f) {
        audioTrack.setVolume(f);
    }

    public static void Q(android.media.AudioTrack audioTrack, float f) {
        audioTrack.setStereoVolume(f, f);
    }

    @androidx.annotation.RequiresApi(21)
    public static int T(android.media.AudioTrack audioTrack, java.nio.ByteBuffer byteBuffer, int i) {
        return audioTrack.write(byteBuffer, i, 1);
    }

    @androidx.annotation.RequiresApi(21)
    public static android.media.AudioFormat p(int i, int i2, int i3) {
        return new android.media.AudioFormat.Builder().setSampleRate(i).setChannelMask(i2).setEncoding(i3).build();
    }

    public static int r(int i) {
        int i2 = com.google.android.exoplayer2.util.Util.SDK_INT;
        if (i2 <= 28) {
            if (i == 7) {
                i = 8;
            } else if (i == 3 || i == 4 || i == 5) {
                i = 6;
            }
        }
        if (i2 <= 26 && "fugu".equals(com.google.android.exoplayer2.util.Util.DEVICE) && i == 1) {
            i = 2;
        }
        return com.google.android.exoplayer2.util.Util.getAudioTrackChannelConfig(i);
    }

    @androidx.annotation.Nullable
    public static android.util.Pair<java.lang.Integer, java.lang.Integer> s(com.google.android.exoplayer2.Format format, @androidx.annotation.Nullable com.google.android.exoplayer2.audio.AudioCapabilities audioCapabilities) {
        int r;
        if (audioCapabilities == null) {
            return null;
        }
        int encoding = com.google.android.exoplayer2.util.MimeTypes.getEncoding((java.lang.String) com.google.android.exoplayer2.util.Assertions.checkNotNull(format.sampleMimeType), format.codecs);
        if (!(encoding == 5 || encoding == 6 || encoding == 18 || encoding == 17 || encoding == 7 || encoding == 8 || encoding == 14)) {
            return null;
        }
        int i = encoding == 18 ? 6 : format.channelCount;
        if (i > audioCapabilities.getMaxChannelCount() || (r = r(i)) == 0) {
            return null;
        }
        if (audioCapabilities.supportsEncoding(encoding)) {
            return android.util.Pair.create(java.lang.Integer.valueOf(encoding), java.lang.Integer.valueOf(r));
        }
        if (encoding == 18 && audioCapabilities.supportsEncoding(6)) {
            return android.util.Pair.create(6, java.lang.Integer.valueOf(r));
        }
        return null;
    }

    public static int t(int i, java.nio.ByteBuffer byteBuffer) {
        switch (i) {
            case 5:
            case 6:
            case 18:
                return com.google.android.exoplayer2.audio.Ac3Util.parseAc3SyncframeAudioSampleCount(byteBuffer);
            case 7:
            case 8:
                return com.google.android.exoplayer2.audio.DtsUtil.parseDtsAudioSampleCount(byteBuffer);
            case 9:
                int parseMpegAudioFrameSampleCount = com.google.android.exoplayer2.audio.MpegAudioUtil.parseMpegAudioFrameSampleCount(com.google.android.exoplayer2.util.Util.getBigEndianInt(byteBuffer, byteBuffer.position()));
                if (parseMpegAudioFrameSampleCount != -1) {
                    return parseMpegAudioFrameSampleCount;
                }
                throw new java.lang.IllegalArgumentException();
            case 10:
                return 1024;
            case 11:
            case 12:
                return 2048;
            case 13:
            default:
                java.lang.StringBuilder sb = new java.lang.StringBuilder(38);
                sb.append("Unexpected audio encoding: ");
                sb.append(i);
                throw new java.lang.IllegalStateException(sb.toString());
            case 14:
                int findTrueHdSyncframeOffset = com.google.android.exoplayer2.audio.Ac3Util.findTrueHdSyncframeOffset(byteBuffer);
                if (findTrueHdSyncframeOffset == -1) {
                    return 0;
                }
                return com.google.android.exoplayer2.audio.Ac3Util.parseTrueHdSyncframeAudioSampleCount(byteBuffer, findTrueHdSyncframeOffset) * 16;
            case 15:
                return 512;
            case 16:
                return 1024;
            case 17:
                return com.google.android.exoplayer2.audio.Ac4Util.parseAc4SyncframeAudioSampleCount(byteBuffer);
        }
    }

    public static int u(int i) {
        switch (i) {
            case 5:
                return 80000;
            case 6:
            case 18:
                return com.google.android.exoplayer2.audio.Ac3Util.E_AC3_MAX_RATE_BYTES_PER_SECOND;
            case 7:
                return com.google.android.exoplayer2.audio.DtsUtil.DTS_MAX_RATE_BYTES_PER_SECOND;
            case 8:
                return com.google.android.exoplayer2.audio.DtsUtil.DTS_HD_MAX_RATE_BYTES_PER_SECOND;
            case 9:
                return com.google.android.exoplayer2.audio.MpegAudioUtil.MAX_RATE_BYTES_PER_SECOND;
            case 10:
                return 100000;
            case 11:
                return com.google.android.exoplayer2.audio.AacUtil.AAC_HE_V1_MAX_RATE_BYTES_PER_SECOND;
            case 12:
                return com.google.android.exoplayer2.audio.AacUtil.AAC_HE_V2_MAX_RATE_BYTES_PER_SECOND;
            case 13:
            default:
                throw new java.lang.IllegalArgumentException();
            case 14:
                return com.google.android.exoplayer2.audio.Ac3Util.TRUEHD_MAX_RATE_BYTES_PER_SECOND;
            case 15:
                return 8000;
            case 16:
                return com.google.android.exoplayer2.audio.AacUtil.AAC_XHE_MAX_RATE_BYTES_PER_SECOND;
            case 17:
                return com.google.android.exoplayer2.audio.Ac4Util.MAX_RATE_BYTES_PER_SECOND;
        }
    }

    public static android.media.AudioTrack z(int i) {
        return new android.media.AudioTrack(3, 4000, 4, 2, 2, 0, i);
    }

    public final boolean B() {
        return this.r != null;
    }

    public final void G() {
        if (this.q.o()) {
            this.W = true;
        }
    }

    public final void H() {
        if (this.Q) {
            return;
        }
        this.Q = true;
        this.i.h(x());
        this.r.stop();
        this.x = 0;
    }

    public final void I(long j) throws com.google.android.exoplayer2.audio.AudioSink.WriteException {
        java.nio.ByteBuffer byteBuffer;
        int length = this.H.length;
        int i = length;
        while (i >= 0) {
            if (i > 0) {
                byteBuffer = this.I[i - 1];
            } else {
                byteBuffer = this.J;
                if (byteBuffer == null) {
                    byteBuffer = com.google.android.exoplayer2.audio.AudioProcessor.EMPTY_BUFFER;
                }
            }
            if (i == length) {
                S(byteBuffer, j);
            } else {
                com.google.android.exoplayer2.audio.AudioProcessor audioProcessor = this.H[i];
                audioProcessor.queueInput(byteBuffer);
                java.nio.ByteBuffer output = audioProcessor.getOutput();
                this.I[i] = output;
                if (output.hasRemaining()) {
                    i++;
                }
            }
            if (byteBuffer.hasRemaining()) {
                return;
            } else {
                i--;
            }
        }
    }

    @androidx.annotation.RequiresApi(29)
    public final void J(android.media.AudioTrack audioTrack) {
        if (this.m == null) {
            this.m = new com.google.android.exoplayer2.audio.DefaultAudioSink.StreamEventCallbackV29();
        }
        this.m.a(audioTrack);
    }

    public final void K() {
        android.media.AudioTrack audioTrack = this.o;
        if (audioTrack == null) {
            return;
        }
        this.o = null;
        new com.google.android.exoplayer2.audio.DefaultAudioSink.AnonymousClass2(this, audioTrack).start();
    }

    public final void L() {
        this.y = 0L;
        this.z = 0L;
        this.A = 0L;
        this.B = 0L;
        this.X = false;
        this.C = 0;
        this.u = new com.google.android.exoplayer2.audio.DefaultAudioSink.MediaPositionParameters(q(), getSkipSilenceEnabled(), 0L, 0L, null);
        this.F = 0L;
        this.t = null;
        this.j.clear();
        this.J = null;
        this.K = 0;
        this.L = null;
        this.Q = false;
        this.P = false;
        this.O = -1;
        this.w = null;
        this.x = 0;
        this.e.b();
        o();
    }

    public final void M(com.google.android.exoplayer2.PlaybackParameters playbackParameters, boolean z) {
        com.google.android.exoplayer2.audio.DefaultAudioSink.MediaPositionParameters v = v();
        if (playbackParameters.equals(v.a) && z == v.b) {
            return;
        }
        com.google.android.exoplayer2.audio.DefaultAudioSink.MediaPositionParameters mediaPositionParameters = new com.google.android.exoplayer2.audio.DefaultAudioSink.MediaPositionParameters(playbackParameters, z, -9223372036854775807L, -9223372036854775807L, null);
        if (B()) {
            this.t = mediaPositionParameters;
        } else {
            this.u = mediaPositionParameters;
        }
    }

    @androidx.annotation.RequiresApi(23)
    public final void N(com.google.android.exoplayer2.PlaybackParameters playbackParameters) {
        android.media.PlaybackParams allowDefaults;
        android.media.PlaybackParams speed;
        android.media.PlaybackParams pitch;
        android.media.PlaybackParams audioFallbackMode;
        android.media.PlaybackParams playbackParams;
        float speed2;
        android.media.PlaybackParams playbackParams2;
        float pitch2;
        if (B()) {
            allowDefaults = new android.media.PlaybackParams().allowDefaults();
            speed = allowDefaults.setSpeed(playbackParameters.speed);
            pitch = speed.setPitch(playbackParameters.pitch);
            audioFallbackMode = pitch.setAudioFallbackMode(2);
            try {
                this.r.setPlaybackParams(audioFallbackMode);
            } catch (java.lang.IllegalArgumentException e) {
                com.google.android.exoplayer2.util.Log.w("AudioTrack", "Failed to set playback params", e);
            }
            playbackParams = this.r.getPlaybackParams();
            speed2 = playbackParams.getSpeed();
            playbackParams2 = this.r.getPlaybackParams();
            pitch2 = playbackParams2.getPitch();
            playbackParameters = new com.google.android.exoplayer2.PlaybackParameters(speed2, pitch2);
            this.i.u(playbackParameters.speed);
        }
        this.v = playbackParameters;
    }

    public final void O() {
        if (B()) {
            if (com.google.android.exoplayer2.util.Util.SDK_INT >= 21) {
                P(this.r, this.G);
            } else {
                Q(this.r, this.G);
            }
        }
    }

    public final void R() {
        com.google.android.exoplayer2.audio.AudioProcessor[] audioProcessorArr = this.q.j;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (com.google.android.exoplayer2.audio.AudioProcessor audioProcessor : audioProcessorArr) {
            if (audioProcessor.isActive()) {
                arrayList.add(audioProcessor);
            } else {
                audioProcessor.flush();
            }
        }
        int size = arrayList.size();
        this.H = (com.google.android.exoplayer2.audio.AudioProcessor[]) arrayList.toArray(new com.google.android.exoplayer2.audio.AudioProcessor[size]);
        this.I = new java.nio.ByteBuffer[size];
        o();
    }

    public final void S(java.nio.ByteBuffer byteBuffer, long j) throws com.google.android.exoplayer2.audio.AudioSink.WriteException {
        int T;
        if (byteBuffer.hasRemaining()) {
            java.nio.ByteBuffer byteBuffer2 = this.L;
            if (byteBuffer2 != null) {
                com.google.android.exoplayer2.util.Assertions.checkArgument(byteBuffer2 == byteBuffer);
            } else {
                this.L = byteBuffer;
                if (com.google.android.exoplayer2.util.Util.SDK_INT < 21) {
                    int remaining = byteBuffer.remaining();
                    byte[] bArr = this.M;
                    if (bArr == null || bArr.length < remaining) {
                        this.M = new byte[remaining];
                    }
                    int position = byteBuffer.position();
                    byteBuffer.get(this.M, 0, remaining);
                    byteBuffer.position(position);
                    this.N = 0;
                }
            }
            int remaining2 = byteBuffer.remaining();
            if (com.google.android.exoplayer2.util.Util.SDK_INT < 21) {
                int c = this.i.c(this.A);
                if (c > 0) {
                    T = this.r.write(this.M, this.N, java.lang.Math.min(remaining2, c));
                    if (T > 0) {
                        this.N += T;
                        byteBuffer.position(byteBuffer.position() + T);
                    }
                } else {
                    T = 0;
                }
            } else if (this.U) {
                com.google.android.exoplayer2.util.Assertions.checkState(j != -9223372036854775807L);
                T = U(this.r, byteBuffer, remaining2, j);
            } else {
                T = T(this.r, byteBuffer, remaining2);
            }
            this.V = android.os.SystemClock.elapsedRealtime();
            if (T < 0) {
                if (A(T)) {
                    G();
                }
                throw new com.google.android.exoplayer2.audio.AudioSink.WriteException(T);
            }
            if (D(this.r)) {
                long j2 = this.B;
                if (j2 > 0) {
                    this.X = false;
                }
                if (this.R && this.n != null && T < remaining2 && !this.X) {
                    this.n.onOffloadBufferFull(this.i.e(j2));
                }
            }
            int i = this.q.c;
            if (i == 0) {
                this.A += T;
            }
            if (T == remaining2) {
                if (i != 0) {
                    com.google.android.exoplayer2.util.Assertions.checkState(byteBuffer == this.J);
                    this.B += this.C * this.K;
                }
                this.L = null;
            }
        }
    }

    @androidx.annotation.RequiresApi(21)
    public final int U(android.media.AudioTrack audioTrack, java.nio.ByteBuffer byteBuffer, int i, long j) {
        int write;
        if (com.google.android.exoplayer2.util.Util.SDK_INT >= 26) {
            write = audioTrack.write(byteBuffer, i, 1, j * 1000);
            return write;
        }
        if (this.w == null) {
            java.nio.ByteBuffer allocate = java.nio.ByteBuffer.allocate(16);
            this.w = allocate;
            allocate.order(java.nio.ByteOrder.BIG_ENDIAN);
            this.w.putInt(1431633921);
        }
        if (this.x == 0) {
            this.w.putInt(4, i);
            this.w.putLong(8, j * 1000);
            this.w.position(0);
            this.x = i;
        }
        int remaining = this.w.remaining();
        if (remaining > 0) {
            int write2 = audioTrack.write(this.w, remaining, 1);
            if (write2 < 0) {
                this.x = 0;
                return write2;
            }
            if (write2 < remaining) {
                return 0;
            }
        }
        int T = T(audioTrack, byteBuffer, i);
        if (T < 0) {
            this.x = 0;
            return T;
        }
        this.x -= T;
        return T;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void configure(com.google.android.exoplayer2.Format format, int i, @androidx.annotation.Nullable int[] iArr) throws com.google.android.exoplayer2.audio.AudioSink.ConfigurationException {
        int i2;
        com.google.android.exoplayer2.audio.AudioProcessor[] audioProcessorArr;
        int intValue;
        int i3;
        int i4;
        int i5;
        int i6;
        boolean z;
        int[] iArr2;
        if ("audio/raw".equals(format.sampleMimeType)) {
            com.google.android.exoplayer2.util.Assertions.checkArgument(com.google.android.exoplayer2.util.Util.isEncodingLinearPcm(format.pcmEncoding));
            int pcmFrameSize = com.google.android.exoplayer2.util.Util.getPcmFrameSize(format.pcmEncoding, format.channelCount);
            boolean z2 = this.c && com.google.android.exoplayer2.util.Util.isEncodingHighResolutionPcm(format.pcmEncoding);
            com.google.android.exoplayer2.audio.AudioProcessor[] audioProcessorArr2 = z2 ? this.g : this.f;
            boolean z3 = true ^ z2;
            this.e.c(format.encoderDelay, format.encoderPadding);
            if (com.google.android.exoplayer2.util.Util.SDK_INT < 21 && format.channelCount == 8 && iArr == null) {
                iArr2 = new int[6];
                for (int i7 = 0; i7 < 6; i7++) {
                    iArr2[i7] = i7;
                }
            } else {
                iArr2 = iArr;
            }
            this.d.a(iArr2);
            com.google.android.exoplayer2.audio.AudioProcessor.AudioFormat audioFormat = new com.google.android.exoplayer2.audio.AudioProcessor.AudioFormat(format.sampleRate, format.channelCount, format.pcmEncoding);
            for (com.google.android.exoplayer2.audio.AudioProcessor audioProcessor : audioProcessorArr2) {
                try {
                    com.google.android.exoplayer2.audio.AudioProcessor.AudioFormat configure = audioProcessor.configure(audioFormat);
                    if (audioProcessor.isActive()) {
                        audioFormat = configure;
                    }
                } catch (com.google.android.exoplayer2.audio.AudioProcessor.UnhandledAudioFormatException e) {
                    throw new com.google.android.exoplayer2.audio.AudioSink.ConfigurationException(e);
                }
            }
            int i8 = audioFormat.encoding;
            i3 = audioFormat.sampleRate;
            intValue = com.google.android.exoplayer2.util.Util.getAudioTrackChannelConfig(audioFormat.channelCount);
            int pcmFrameSize2 = com.google.android.exoplayer2.util.Util.getPcmFrameSize(i8, audioFormat.channelCount);
            z = z3;
            audioProcessorArr = audioProcessorArr2;
            i4 = i8;
            i2 = pcmFrameSize;
            i6 = pcmFrameSize2;
            i5 = 0;
        } else {
            com.google.android.exoplayer2.audio.AudioProcessor[] audioProcessorArr3 = new com.google.android.exoplayer2.audio.AudioProcessor[0];
            int i9 = format.sampleRate;
            i2 = -1;
            if (this.l && E(format, this.f343s)) {
                audioProcessorArr = audioProcessorArr3;
                i4 = com.google.android.exoplayer2.util.MimeTypes.getEncoding((java.lang.String) com.google.android.exoplayer2.util.Assertions.checkNotNull(format.sampleMimeType), format.codecs);
                intValue = com.google.android.exoplayer2.util.Util.getAudioTrackChannelConfig(format.channelCount);
                i6 = -1;
                z = false;
                i3 = i9;
                i5 = 1;
            } else {
                android.util.Pair<java.lang.Integer, java.lang.Integer> s2 = s(format, this.a);
                if (s2 == null) {
                    java.lang.String valueOf = java.lang.String.valueOf(format);
                    java.lang.StringBuilder sb = new java.lang.StringBuilder(valueOf.length() + 37);
                    sb.append("Unable to configure passthrough for: ");
                    sb.append(valueOf);
                    throw new com.google.android.exoplayer2.audio.AudioSink.ConfigurationException(sb.toString());
                }
                int intValue2 = ((java.lang.Integer) s2.first).intValue();
                audioProcessorArr = audioProcessorArr3;
                intValue = ((java.lang.Integer) s2.second).intValue();
                i3 = i9;
                i4 = intValue2;
                i5 = 2;
                i6 = -1;
                z = false;
            }
        }
        if (i4 == 0) {
            java.lang.String valueOf2 = java.lang.String.valueOf(format);
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder(valueOf2.length() + 48);
            sb2.append("Invalid output encoding (mode=");
            sb2.append(i5);
            sb2.append(") for: ");
            sb2.append(valueOf2);
            throw new com.google.android.exoplayer2.audio.AudioSink.ConfigurationException(sb2.toString());
        }
        if (intValue != 0) {
            this.W = false;
            com.google.android.exoplayer2.audio.DefaultAudioSink.Configuration configuration = new com.google.android.exoplayer2.audio.DefaultAudioSink.Configuration(format, i2, i5, i6, i3, intValue, i4, i, this.k, z, audioProcessorArr);
            if (B()) {
                this.p = configuration;
                return;
            } else {
                this.q = configuration;
                return;
            }
        }
        java.lang.String valueOf3 = java.lang.String.valueOf(format);
        java.lang.StringBuilder sb3 = new java.lang.StringBuilder(valueOf3.length() + 54);
        sb3.append("Invalid output channel config (mode=");
        sb3.append(i5);
        sb3.append(") for: ");
        sb3.append(valueOf3);
        throw new com.google.android.exoplayer2.audio.AudioSink.ConfigurationException(sb3.toString());
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void disableTunneling() {
        if (this.U) {
            this.U = false;
            this.S = 0;
            flush();
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void enableTunnelingV21(int i) {
        com.google.android.exoplayer2.util.Assertions.checkState(com.google.android.exoplayer2.util.Util.SDK_INT >= 21);
        if (this.U && this.S == i) {
            return;
        }
        this.U = true;
        this.S = i;
        flush();
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void experimentalFlushWithoutAudioTrackRelease() {
        if (com.google.android.exoplayer2.util.Util.SDK_INT < 25) {
            flush();
            return;
        }
        if (B()) {
            L();
            if (this.i.j()) {
                this.r.pause();
            }
            this.r.flush();
            this.i.r();
            com.google.android.exoplayer2.audio.AudioTrackPositionTracker audioTrackPositionTracker = this.i;
            android.media.AudioTrack audioTrack = this.r;
            com.google.android.exoplayer2.audio.DefaultAudioSink.Configuration configuration = this.q;
            audioTrackPositionTracker.t(audioTrack, configuration.c == 2, configuration.g, configuration.d, configuration.h);
            this.E = true;
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void flush() {
        if (B()) {
            L();
            if (this.i.j()) {
                this.r.pause();
            }
            if (D(this.r)) {
                ((com.google.android.exoplayer2.audio.DefaultAudioSink.StreamEventCallbackV29) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.m)).b(this.r);
            }
            android.media.AudioTrack audioTrack = this.r;
            this.r = null;
            com.google.android.exoplayer2.audio.DefaultAudioSink.Configuration configuration = this.p;
            if (configuration != null) {
                this.q = configuration;
                this.p = null;
            }
            this.i.r();
            this.h.close();
            new com.google.android.exoplayer2.audio.DefaultAudioSink.AnonymousClass1("ExoPlayer:AudioTrackReleaseThread", audioTrack).start();
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public long getCurrentPositionUs(boolean z) {
        if (!B() || this.E) {
            return Long.MIN_VALUE;
        }
        return l(k(java.lang.Math.min(this.i.d(z), this.q.i(x()))));
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public int getFormatSupport(com.google.android.exoplayer2.Format format) {
        if (!"audio/raw".equals(format.sampleMimeType)) {
            return ((this.l && !this.W && E(format, this.f343s)) || F(format, this.a)) ? 2 : 0;
        }
        if (com.google.android.exoplayer2.util.Util.isEncodingLinearPcm(format.pcmEncoding)) {
            int i = format.pcmEncoding;
            return (i == 2 || (this.c && i == 4)) ? 2 : 1;
        }
        int i2 = format.pcmEncoding;
        java.lang.StringBuilder sb = new java.lang.StringBuilder(33);
        sb.append("Invalid PCM encoding: ");
        sb.append(i2);
        com.google.android.exoplayer2.util.Log.w("AudioTrack", sb.toString());
        return 0;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public com.google.android.exoplayer2.PlaybackParameters getPlaybackParameters() {
        return this.k ? this.v : q();
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public boolean getSkipSilenceEnabled() {
        return v().b;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public boolean handleBuffer(java.nio.ByteBuffer byteBuffer, long j, int i) throws com.google.android.exoplayer2.audio.AudioSink.InitializationException, com.google.android.exoplayer2.audio.AudioSink.WriteException {
        java.nio.ByteBuffer byteBuffer2 = this.J;
        com.google.android.exoplayer2.util.Assertions.checkArgument(byteBuffer2 == null || byteBuffer == byteBuffer2);
        if (this.p != null) {
            if (!n()) {
                return false;
            }
            if (this.p.b(this.q)) {
                this.q = this.p;
                this.p = null;
                if (D(this.r)) {
                    this.r.setOffloadEndOfStream();
                    android.media.AudioTrack audioTrack = this.r;
                    com.google.android.exoplayer2.Format format = this.q.a;
                    audioTrack.setOffloadDelayPadding(format.encoderDelay, format.encoderPadding);
                    this.X = true;
                }
            } else {
                H();
                if (hasPendingData()) {
                    return false;
                }
                flush();
            }
            j(j);
        }
        if (!B()) {
            y();
        }
        if (this.E) {
            this.F = java.lang.Math.max(0L, j);
            this.D = false;
            this.E = false;
            if (this.k && com.google.android.exoplayer2.util.Util.SDK_INT >= 23) {
                N(this.v);
            }
            j(j);
            if (this.R) {
                play();
            }
        }
        if (!this.i.l(x())) {
            return false;
        }
        if (this.J == null) {
            com.google.android.exoplayer2.util.Assertions.checkArgument(byteBuffer.order() == java.nio.ByteOrder.LITTLE_ENDIAN);
            if (!byteBuffer.hasRemaining()) {
                return true;
            }
            com.google.android.exoplayer2.audio.DefaultAudioSink.Configuration configuration = this.q;
            if (configuration.c != 0 && this.C == 0) {
                int t = t(configuration.g, byteBuffer);
                this.C = t;
                if (t == 0) {
                    return true;
                }
            }
            if (this.t != null) {
                if (!n()) {
                    return false;
                }
                j(j);
                this.t = null;
            }
            long n = this.F + this.q.n(w() - this.e.a());
            if (!this.D && java.lang.Math.abs(n - j) > 200000) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder(80);
                sb.append("Discontinuity detected [expected ");
                sb.append(n);
                sb.append(", got ");
                sb.append(j);
                sb.append("]");
                com.google.android.exoplayer2.util.Log.e("AudioTrack", sb.toString());
                this.D = true;
            }
            if (this.D) {
                if (!n()) {
                    return false;
                }
                long j2 = j - n;
                this.F += j2;
                this.D = false;
                j(j);
                com.google.android.exoplayer2.audio.AudioSink.Listener listener = this.n;
                if (listener != null && j2 != 0) {
                    listener.onPositionDiscontinuity();
                }
            }
            if (this.q.c == 0) {
                this.y += byteBuffer.remaining();
            } else {
                this.z += this.C * i;
            }
            this.J = byteBuffer;
            this.K = i;
        }
        I(j);
        if (!this.J.hasRemaining()) {
            this.J = null;
            this.K = 0;
            return true;
        }
        if (!this.i.k(x())) {
            return false;
        }
        com.google.android.exoplayer2.util.Log.w("AudioTrack", "Resetting stalled audio track");
        flush();
        return true;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void handleDiscontinuity() {
        this.D = true;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public boolean hasPendingData() {
        return B() && this.i.i(x());
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public boolean isEnded() {
        return !B() || (this.P && !hasPendingData());
    }

    public final void j(long j) {
        com.google.android.exoplayer2.PlaybackParameters applyPlaybackParameters = this.q.i ? this.b.applyPlaybackParameters(q()) : com.google.android.exoplayer2.PlaybackParameters.DEFAULT;
        boolean applySkipSilenceEnabled = this.q.i ? this.b.applySkipSilenceEnabled(getSkipSilenceEnabled()) : false;
        this.j.add(new com.google.android.exoplayer2.audio.DefaultAudioSink.MediaPositionParameters(applyPlaybackParameters, applySkipSilenceEnabled, java.lang.Math.max(0L, j), this.q.i(x()), null));
        R();
        com.google.android.exoplayer2.audio.AudioSink.Listener listener = this.n;
        if (listener != null) {
            listener.onSkipSilenceEnabledChanged(applySkipSilenceEnabled);
        }
    }

    public final long k(long j) {
        while (!this.j.isEmpty() && j >= this.j.getFirst().d) {
            this.u = this.j.remove();
        }
        com.google.android.exoplayer2.audio.DefaultAudioSink.MediaPositionParameters mediaPositionParameters = this.u;
        long j2 = j - mediaPositionParameters.d;
        if (!mediaPositionParameters.a.equals(com.google.android.exoplayer2.PlaybackParameters.DEFAULT)) {
            j2 = this.j.isEmpty() ? this.b.getMediaDuration(j2) : com.google.android.exoplayer2.util.Util.getMediaDurationForPlayoutDuration(j2, this.u.a.speed);
        }
        return this.u.c + j2;
    }

    public final long l(long j) {
        return j + this.q.i(this.b.getSkippedOutputFrameCount());
    }

    public final android.media.AudioTrack m() throws com.google.android.exoplayer2.audio.AudioSink.InitializationException {
        try {
            return ((com.google.android.exoplayer2.audio.DefaultAudioSink.Configuration) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.q)).a(this.U, this.f343s, this.S);
        } catch (com.google.android.exoplayer2.audio.AudioSink.InitializationException e) {
            G();
            throw e;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x0029 -> B:4:0x0009). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean n() throws com.google.android.exoplayer2.audio.AudioSink.WriteException {
        boolean z;
        int i;
        com.google.android.exoplayer2.audio.AudioProcessor[] audioProcessorArr;
        if (this.O == -1) {
            this.O = 0;
            z = true;
            i = this.O;
            audioProcessorArr = this.H;
            if (i < audioProcessorArr.length) {
                com.google.android.exoplayer2.audio.AudioProcessor audioProcessor = audioProcessorArr[i];
                if (z) {
                    audioProcessor.queueEndOfStream();
                }
                I(-9223372036854775807L);
                if (!audioProcessor.isEnded()) {
                    return false;
                }
                this.O++;
                z = true;
                i = this.O;
                audioProcessorArr = this.H;
                if (i < audioProcessorArr.length) {
                    java.nio.ByteBuffer byteBuffer = this.L;
                    if (byteBuffer != null) {
                        S(byteBuffer, -9223372036854775807L);
                        if (this.L != null) {
                            return false;
                        }
                    }
                    this.O = -1;
                    return true;
                }
            }
        } else {
            z = false;
            i = this.O;
            audioProcessorArr = this.H;
            if (i < audioProcessorArr.length) {
            }
        }
    }

    public final void o() {
        int i = 0;
        while (true) {
            com.google.android.exoplayer2.audio.AudioProcessor[] audioProcessorArr = this.H;
            if (i >= audioProcessorArr.length) {
                return;
            }
            com.google.android.exoplayer2.audio.AudioProcessor audioProcessor = audioProcessorArr[i];
            audioProcessor.flush();
            this.I[i] = audioProcessor.getOutput();
            i++;
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void pause() {
        this.R = false;
        if (B() && this.i.q()) {
            this.r.pause();
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void play() {
        this.R = true;
        if (B()) {
            this.i.v();
            this.r.play();
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void playToEndOfStream() throws com.google.android.exoplayer2.audio.AudioSink.WriteException {
        if (!this.P && B() && n()) {
            H();
            this.P = true;
        }
    }

    public final com.google.android.exoplayer2.PlaybackParameters q() {
        return v().a;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void reset() {
        flush();
        K();
        for (com.google.android.exoplayer2.audio.AudioProcessor audioProcessor : this.f) {
            audioProcessor.reset();
        }
        for (com.google.android.exoplayer2.audio.AudioProcessor audioProcessor2 : this.g) {
            audioProcessor2.reset();
        }
        this.S = 0;
        this.R = false;
        this.W = false;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void setAudioAttributes(com.google.android.exoplayer2.audio.AudioAttributes audioAttributes) {
        if (this.f343s.equals(audioAttributes)) {
            return;
        }
        this.f343s = audioAttributes;
        if (this.U) {
            return;
        }
        flush();
        this.S = 0;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void setAudioSessionId(int i) {
        if (this.S != i) {
            this.S = i;
            flush();
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void setAuxEffectInfo(com.google.android.exoplayer2.audio.AuxEffectInfo auxEffectInfo) {
        if (this.T.equals(auxEffectInfo)) {
            return;
        }
        int i = auxEffectInfo.effectId;
        float f = auxEffectInfo.sendLevel;
        android.media.AudioTrack audioTrack = this.r;
        if (audioTrack != null) {
            if (this.T.effectId != i) {
                audioTrack.attachAuxEffect(i);
            }
            if (i != 0) {
                this.r.setAuxEffectSendLevel(f);
            }
        }
        this.T = auxEffectInfo;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void setListener(com.google.android.exoplayer2.audio.AudioSink.Listener listener) {
        this.n = listener;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void setPlaybackParameters(com.google.android.exoplayer2.PlaybackParameters playbackParameters) {
        com.google.android.exoplayer2.PlaybackParameters playbackParameters2 = new com.google.android.exoplayer2.PlaybackParameters(com.google.android.exoplayer2.util.Util.constrainValue(playbackParameters.speed, 0.1f, 8.0f), com.google.android.exoplayer2.util.Util.constrainValue(playbackParameters.pitch, 0.1f, 8.0f));
        if (!this.k || com.google.android.exoplayer2.util.Util.SDK_INT < 23) {
            M(playbackParameters2, getSkipSilenceEnabled());
        } else {
            N(playbackParameters2);
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void setSkipSilenceEnabled(boolean z) {
        M(q(), z);
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void setVolume(float f) {
        if (this.G != f) {
            this.G = f;
            O();
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public boolean supportsFormat(com.google.android.exoplayer2.Format format) {
        return getFormatSupport(format) != 0;
    }

    public final com.google.android.exoplayer2.audio.DefaultAudioSink.MediaPositionParameters v() {
        com.google.android.exoplayer2.audio.DefaultAudioSink.MediaPositionParameters mediaPositionParameters = this.t;
        return mediaPositionParameters != null ? mediaPositionParameters : !this.j.isEmpty() ? this.j.getLast() : this.u;
    }

    public final long w() {
        return this.q.c == 0 ? this.y / r0.b : this.z;
    }

    public final long x() {
        return this.q.c == 0 ? this.A / r0.d : this.B;
    }

    public final void y() throws com.google.android.exoplayer2.audio.AudioSink.InitializationException {
        this.h.block();
        android.media.AudioTrack m = m();
        this.r = m;
        if (D(m)) {
            J(this.r);
            android.media.AudioTrack audioTrack = this.r;
            com.google.android.exoplayer2.Format format = this.q.a;
            audioTrack.setOffloadDelayPadding(format.encoderDelay, format.encoderPadding);
        }
        int audioSessionId = this.r.getAudioSessionId();
        if (enablePreV21AudioSessionWorkaround && com.google.android.exoplayer2.util.Util.SDK_INT < 21) {
            android.media.AudioTrack audioTrack2 = this.o;
            if (audioTrack2 != null && audioSessionId != audioTrack2.getAudioSessionId()) {
                K();
            }
            if (this.o == null) {
                this.o = z(audioSessionId);
            }
        }
        if (this.S != audioSessionId) {
            this.S = audioSessionId;
            com.google.android.exoplayer2.audio.AudioSink.Listener listener = this.n;
            if (listener != null) {
                listener.onAudioSessionId(audioSessionId);
            }
        }
        com.google.android.exoplayer2.audio.AudioTrackPositionTracker audioTrackPositionTracker = this.i;
        android.media.AudioTrack audioTrack3 = this.r;
        com.google.android.exoplayer2.audio.DefaultAudioSink.Configuration configuration = this.q;
        audioTrackPositionTracker.t(audioTrack3, configuration.c == 2, configuration.g, configuration.d, configuration.h);
        O();
        int i = this.T.effectId;
        if (i != 0) {
            this.r.attachAuxEffect(i);
            this.r.setAuxEffectSendLevel(this.T.sendLevel);
        }
        this.E = true;
    }
}
