package com.google.android.exoplayer2;

/* loaded from: classes22.dex */
public final class Format implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<com.google.android.exoplayer2.Format> CREATOR = new com.google.android.exoplayer2.Format.AnonymousClass1();
    public static final int NO_VALUE = -1;
    public static final long OFFSET_SAMPLE_RELATIVE = Long.MAX_VALUE;
    public final int accessibilityChannel;
    public final int averageBitrate;
    public final int bitrate;
    public final int channelCount;

    @androidx.annotation.Nullable
    public final java.lang.String codecs;

    @androidx.annotation.Nullable
    public final com.google.android.exoplayer2.video.ColorInfo colorInfo;

    @androidx.annotation.Nullable
    public final java.lang.String containerMimeType;

    @androidx.annotation.Nullable
    public final com.google.android.exoplayer2.drm.DrmInitData drmInitData;
    public final int encoderDelay;
    public final int encoderPadding;

    @androidx.annotation.Nullable
    public final java.lang.Class<? extends com.google.android.exoplayer2.drm.ExoMediaCrypto> exoMediaCryptoType;
    public final float frameRate;
    private int hashCode;
    public final int height;

    @androidx.annotation.Nullable
    public final java.lang.String id;
    public final java.util.List<byte[]> initializationData;

    @androidx.annotation.Nullable
    public final java.lang.String label;

    @androidx.annotation.Nullable
    public final java.lang.String language;
    public final int maxInputSize;

    @androidx.annotation.Nullable
    public final com.google.android.exoplayer2.metadata.Metadata metadata;
    public final int pcmEncoding;
    public final int peakBitrate;
    public final float pixelWidthHeightRatio;

    @androidx.annotation.Nullable
    public final byte[] projectionData;
    public final int roleFlags;
    public final int rotationDegrees;

    @androidx.annotation.Nullable
    public final java.lang.String sampleMimeType;
    public final int sampleRate;
    public final int selectionFlags;
    public final int stereoMode;
    public final long subsampleOffsetUs;
    public final int width;

    /* renamed from: com.google.android.exoplayer2.Format$1, reason: invalid class name */
    public class AnonymousClass1 implements android.os.Parcelable.Creator<com.google.android.exoplayer2.Format> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.google.android.exoplayer2.Format createFromParcel(android.os.Parcel parcel) {
            return new com.google.android.exoplayer2.Format(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public com.google.android.exoplayer2.Format[] newArray(int i) {
            return new com.google.android.exoplayer2.Format[i];
        }
    }

    public static final class Builder {
        public int A;
        public int B;
        public int C;

        @androidx.annotation.Nullable
        public java.lang.Class<? extends com.google.android.exoplayer2.drm.ExoMediaCrypto> D;

        @androidx.annotation.Nullable
        public java.lang.String a;

        @androidx.annotation.Nullable
        public java.lang.String b;

        @androidx.annotation.Nullable
        public java.lang.String c;
        public int d;
        public int e;
        public int f;
        public int g;

        @androidx.annotation.Nullable
        public java.lang.String h;

        @androidx.annotation.Nullable
        public com.google.android.exoplayer2.metadata.Metadata i;

        @androidx.annotation.Nullable
        public java.lang.String j;

        @androidx.annotation.Nullable
        public java.lang.String k;
        public int l;

        @androidx.annotation.Nullable
        public java.util.List<byte[]> m;

        @androidx.annotation.Nullable
        public com.google.android.exoplayer2.drm.DrmInitData n;
        public long o;
        public int p;
        public int q;
        public float r;

        /* renamed from: s, reason: collision with root package name */
        public int f337s;
        public float t;

        @androidx.annotation.Nullable
        public byte[] u;
        public int v;

        @androidx.annotation.Nullable
        public com.google.android.exoplayer2.video.ColorInfo w;
        public int x;
        public int y;
        public int z;

        public Builder() {
            this.f = -1;
            this.g = -1;
            this.l = -1;
            this.o = Long.MAX_VALUE;
            this.p = -1;
            this.q = -1;
            this.r = -1.0f;
            this.t = 1.0f;
            this.v = -1;
            this.x = -1;
            this.y = -1;
            this.z = -1;
            this.C = -1;
        }

        public Builder(com.google.android.exoplayer2.Format format) {
            this.a = format.id;
            this.b = format.label;
            this.c = format.language;
            this.d = format.selectionFlags;
            this.e = format.roleFlags;
            this.f = format.averageBitrate;
            this.g = format.peakBitrate;
            this.h = format.codecs;
            this.i = format.metadata;
            this.j = format.containerMimeType;
            this.k = format.sampleMimeType;
            this.l = format.maxInputSize;
            this.m = format.initializationData;
            this.n = format.drmInitData;
            this.o = format.subsampleOffsetUs;
            this.p = format.width;
            this.q = format.height;
            this.r = format.frameRate;
            this.f337s = format.rotationDegrees;
            this.t = format.pixelWidthHeightRatio;
            this.u = format.projectionData;
            this.v = format.stereoMode;
            this.w = format.colorInfo;
            this.x = format.channelCount;
            this.y = format.sampleRate;
            this.z = format.pcmEncoding;
            this.A = format.encoderDelay;
            this.B = format.encoderPadding;
            this.C = format.accessibilityChannel;
            this.D = format.exoMediaCryptoType;
        }

        public /* synthetic */ Builder(com.google.android.exoplayer2.Format format, com.google.android.exoplayer2.Format.AnonymousClass1 anonymousClass1) {
            this(format);
        }

        public com.google.android.exoplayer2.Format build() {
            return new com.google.android.exoplayer2.Format(this, null);
        }

        public com.google.android.exoplayer2.Format.Builder setAccessibilityChannel(int i) {
            this.C = i;
            return this;
        }

        public com.google.android.exoplayer2.Format.Builder setAverageBitrate(int i) {
            this.f = i;
            return this;
        }

        public com.google.android.exoplayer2.Format.Builder setChannelCount(int i) {
            this.x = i;
            return this;
        }

        public com.google.android.exoplayer2.Format.Builder setCodecs(@androidx.annotation.Nullable java.lang.String str) {
            this.h = str;
            return this;
        }

        public com.google.android.exoplayer2.Format.Builder setColorInfo(@androidx.annotation.Nullable com.google.android.exoplayer2.video.ColorInfo colorInfo) {
            this.w = colorInfo;
            return this;
        }

        public com.google.android.exoplayer2.Format.Builder setContainerMimeType(@androidx.annotation.Nullable java.lang.String str) {
            this.j = str;
            return this;
        }

        public com.google.android.exoplayer2.Format.Builder setDrmInitData(@androidx.annotation.Nullable com.google.android.exoplayer2.drm.DrmInitData drmInitData) {
            this.n = drmInitData;
            return this;
        }

        public com.google.android.exoplayer2.Format.Builder setEncoderDelay(int i) {
            this.A = i;
            return this;
        }

        public com.google.android.exoplayer2.Format.Builder setEncoderPadding(int i) {
            this.B = i;
            return this;
        }

        public com.google.android.exoplayer2.Format.Builder setExoMediaCryptoType(@androidx.annotation.Nullable java.lang.Class<? extends com.google.android.exoplayer2.drm.ExoMediaCrypto> cls) {
            this.D = cls;
            return this;
        }

        public com.google.android.exoplayer2.Format.Builder setFrameRate(float f) {
            this.r = f;
            return this;
        }

        public com.google.android.exoplayer2.Format.Builder setHeight(int i) {
            this.q = i;
            return this;
        }

        public com.google.android.exoplayer2.Format.Builder setId(int i) {
            this.a = java.lang.Integer.toString(i);
            return this;
        }

        public com.google.android.exoplayer2.Format.Builder setId(@androidx.annotation.Nullable java.lang.String str) {
            this.a = str;
            return this;
        }

        public com.google.android.exoplayer2.Format.Builder setInitializationData(@androidx.annotation.Nullable java.util.List<byte[]> list) {
            this.m = list;
            return this;
        }

        public com.google.android.exoplayer2.Format.Builder setLabel(@androidx.annotation.Nullable java.lang.String str) {
            this.b = str;
            return this;
        }

        public com.google.android.exoplayer2.Format.Builder setLanguage(@androidx.annotation.Nullable java.lang.String str) {
            this.c = str;
            return this;
        }

        public com.google.android.exoplayer2.Format.Builder setMaxInputSize(int i) {
            this.l = i;
            return this;
        }

        public com.google.android.exoplayer2.Format.Builder setMetadata(@androidx.annotation.Nullable com.google.android.exoplayer2.metadata.Metadata metadata) {
            this.i = metadata;
            return this;
        }

        public com.google.android.exoplayer2.Format.Builder setPcmEncoding(int i) {
            this.z = i;
            return this;
        }

        public com.google.android.exoplayer2.Format.Builder setPeakBitrate(int i) {
            this.g = i;
            return this;
        }

        public com.google.android.exoplayer2.Format.Builder setPixelWidthHeightRatio(float f) {
            this.t = f;
            return this;
        }

        public com.google.android.exoplayer2.Format.Builder setProjectionData(@androidx.annotation.Nullable byte[] bArr) {
            this.u = bArr;
            return this;
        }

        public com.google.android.exoplayer2.Format.Builder setRoleFlags(int i) {
            this.e = i;
            return this;
        }

        public com.google.android.exoplayer2.Format.Builder setRotationDegrees(int i) {
            this.f337s = i;
            return this;
        }

        public com.google.android.exoplayer2.Format.Builder setSampleMimeType(@androidx.annotation.Nullable java.lang.String str) {
            this.k = str;
            return this;
        }

        public com.google.android.exoplayer2.Format.Builder setSampleRate(int i) {
            this.y = i;
            return this;
        }

        public com.google.android.exoplayer2.Format.Builder setSelectionFlags(int i) {
            this.d = i;
            return this;
        }

        public com.google.android.exoplayer2.Format.Builder setStereoMode(int i) {
            this.v = i;
            return this;
        }

        public com.google.android.exoplayer2.Format.Builder setSubsampleOffsetUs(long j) {
            this.o = j;
            return this;
        }

        public com.google.android.exoplayer2.Format.Builder setWidth(int i) {
            this.p = i;
            return this;
        }
    }

    public Format(android.os.Parcel parcel) {
        this.id = parcel.readString();
        this.label = parcel.readString();
        this.language = parcel.readString();
        this.selectionFlags = parcel.readInt();
        this.roleFlags = parcel.readInt();
        int readInt = parcel.readInt();
        this.averageBitrate = readInt;
        int readInt2 = parcel.readInt();
        this.peakBitrate = readInt2;
        this.bitrate = readInt2 != -1 ? readInt2 : readInt;
        this.codecs = parcel.readString();
        this.metadata = (com.google.android.exoplayer2.metadata.Metadata) parcel.readParcelable(com.google.android.exoplayer2.metadata.Metadata.class.getClassLoader());
        this.containerMimeType = parcel.readString();
        this.sampleMimeType = parcel.readString();
        this.maxInputSize = parcel.readInt();
        int readInt3 = parcel.readInt();
        this.initializationData = new java.util.ArrayList(readInt3);
        for (int i = 0; i < readInt3; i++) {
            this.initializationData.add((byte[]) com.google.android.exoplayer2.util.Assertions.checkNotNull(parcel.createByteArray()));
        }
        com.google.android.exoplayer2.drm.DrmInitData drmInitData = (com.google.android.exoplayer2.drm.DrmInitData) parcel.readParcelable(com.google.android.exoplayer2.drm.DrmInitData.class.getClassLoader());
        this.drmInitData = drmInitData;
        this.subsampleOffsetUs = parcel.readLong();
        this.width = parcel.readInt();
        this.height = parcel.readInt();
        this.frameRate = parcel.readFloat();
        this.rotationDegrees = parcel.readInt();
        this.pixelWidthHeightRatio = parcel.readFloat();
        this.projectionData = com.google.android.exoplayer2.util.Util.readBoolean(parcel) ? parcel.createByteArray() : null;
        this.stereoMode = parcel.readInt();
        this.colorInfo = (com.google.android.exoplayer2.video.ColorInfo) parcel.readParcelable(com.google.android.exoplayer2.video.ColorInfo.class.getClassLoader());
        this.channelCount = parcel.readInt();
        this.sampleRate = parcel.readInt();
        this.pcmEncoding = parcel.readInt();
        this.encoderDelay = parcel.readInt();
        this.encoderPadding = parcel.readInt();
        this.accessibilityChannel = parcel.readInt();
        this.exoMediaCryptoType = drmInitData != null ? com.google.android.exoplayer2.drm.UnsupportedMediaCrypto.class : null;
    }

    private Format(com.google.android.exoplayer2.Format.Builder builder) {
        this.id = builder.a;
        this.label = builder.b;
        this.language = com.google.android.exoplayer2.util.Util.normalizeLanguageCode(builder.c);
        this.selectionFlags = builder.d;
        this.roleFlags = builder.e;
        int i = builder.f;
        this.averageBitrate = i;
        int i2 = builder.g;
        this.peakBitrate = i2;
        this.bitrate = i2 != -1 ? i2 : i;
        this.codecs = builder.h;
        this.metadata = builder.i;
        this.containerMimeType = builder.j;
        this.sampleMimeType = builder.k;
        this.maxInputSize = builder.l;
        this.initializationData = builder.m == null ? java.util.Collections.emptyList() : builder.m;
        com.google.android.exoplayer2.drm.DrmInitData drmInitData = builder.n;
        this.drmInitData = drmInitData;
        this.subsampleOffsetUs = builder.o;
        this.width = builder.p;
        this.height = builder.q;
        this.frameRate = builder.r;
        this.rotationDegrees = builder.f337s == -1 ? 0 : builder.f337s;
        this.pixelWidthHeightRatio = builder.t == -1.0f ? 1.0f : builder.t;
        this.projectionData = builder.u;
        this.stereoMode = builder.v;
        this.colorInfo = builder.w;
        this.channelCount = builder.x;
        this.sampleRate = builder.y;
        this.pcmEncoding = builder.z;
        this.encoderDelay = builder.A == -1 ? 0 : builder.A;
        this.encoderPadding = builder.B != -1 ? builder.B : 0;
        this.accessibilityChannel = builder.C;
        if (builder.D != null || drmInitData == null) {
            this.exoMediaCryptoType = builder.D;
        } else {
            this.exoMediaCryptoType = com.google.android.exoplayer2.drm.UnsupportedMediaCrypto.class;
        }
    }

    public /* synthetic */ Format(com.google.android.exoplayer2.Format.Builder builder, com.google.android.exoplayer2.Format.AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    @java.lang.Deprecated
    public static com.google.android.exoplayer2.Format createAudioContainerFormat(@androidx.annotation.Nullable java.lang.String str, @androidx.annotation.Nullable java.lang.String str2, @androidx.annotation.Nullable java.lang.String str3, @androidx.annotation.Nullable java.lang.String str4, @androidx.annotation.Nullable java.lang.String str5, @androidx.annotation.Nullable com.google.android.exoplayer2.metadata.Metadata metadata, int i, int i2, int i3, @androidx.annotation.Nullable java.util.List<byte[]> list, int i4, int i5, @androidx.annotation.Nullable java.lang.String str6) {
        return new com.google.android.exoplayer2.Format.Builder().setId(str).setLabel(str2).setLanguage(str6).setSelectionFlags(i4).setRoleFlags(i5).setAverageBitrate(i).setPeakBitrate(i).setCodecs(str5).setMetadata(metadata).setContainerMimeType(str3).setSampleMimeType(str4).setInitializationData(list).setChannelCount(i2).setSampleRate(i3).build();
    }

    @java.lang.Deprecated
    public static com.google.android.exoplayer2.Format createAudioSampleFormat(@androidx.annotation.Nullable java.lang.String str, @androidx.annotation.Nullable java.lang.String str2, @androidx.annotation.Nullable java.lang.String str3, int i, int i2, int i3, int i4, int i5, int i6, int i7, @androidx.annotation.Nullable java.util.List<byte[]> list, @androidx.annotation.Nullable com.google.android.exoplayer2.drm.DrmInitData drmInitData, int i8, @androidx.annotation.Nullable java.lang.String str4, @androidx.annotation.Nullable com.google.android.exoplayer2.metadata.Metadata metadata) {
        return new com.google.android.exoplayer2.Format.Builder().setId(str).setLanguage(str4).setSelectionFlags(i8).setAverageBitrate(i).setPeakBitrate(i).setCodecs(str3).setMetadata(metadata).setSampleMimeType(str2).setMaxInputSize(i2).setInitializationData(list).setDrmInitData(drmInitData).setChannelCount(i3).setSampleRate(i4).setPcmEncoding(i5).setEncoderDelay(i6).setEncoderPadding(i7).build();
    }

    @java.lang.Deprecated
    public static com.google.android.exoplayer2.Format createAudioSampleFormat(@androidx.annotation.Nullable java.lang.String str, @androidx.annotation.Nullable java.lang.String str2, @androidx.annotation.Nullable java.lang.String str3, int i, int i2, int i3, int i4, int i5, @androidx.annotation.Nullable java.util.List<byte[]> list, @androidx.annotation.Nullable com.google.android.exoplayer2.drm.DrmInitData drmInitData, int i6, @androidx.annotation.Nullable java.lang.String str4) {
        return new com.google.android.exoplayer2.Format.Builder().setId(str).setLanguage(str4).setSelectionFlags(i6).setAverageBitrate(i).setPeakBitrate(i).setCodecs(str3).setSampleMimeType(str2).setMaxInputSize(i2).setInitializationData(list).setDrmInitData(drmInitData).setChannelCount(i3).setSampleRate(i4).setPcmEncoding(i5).build();
    }

    @java.lang.Deprecated
    public static com.google.android.exoplayer2.Format createAudioSampleFormat(@androidx.annotation.Nullable java.lang.String str, @androidx.annotation.Nullable java.lang.String str2, @androidx.annotation.Nullable java.lang.String str3, int i, int i2, int i3, int i4, @androidx.annotation.Nullable java.util.List<byte[]> list, @androidx.annotation.Nullable com.google.android.exoplayer2.drm.DrmInitData drmInitData, int i5, @androidx.annotation.Nullable java.lang.String str4) {
        return new com.google.android.exoplayer2.Format.Builder().setId(str).setLanguage(str4).setSelectionFlags(i5).setAverageBitrate(i).setPeakBitrate(i).setCodecs(str3).setSampleMimeType(str2).setMaxInputSize(i2).setInitializationData(list).setDrmInitData(drmInitData).setChannelCount(i3).setSampleRate(i4).build();
    }

    @java.lang.Deprecated
    public static com.google.android.exoplayer2.Format createContainerFormat(@androidx.annotation.Nullable java.lang.String str, @androidx.annotation.Nullable java.lang.String str2, @androidx.annotation.Nullable java.lang.String str3, @androidx.annotation.Nullable java.lang.String str4, @androidx.annotation.Nullable java.lang.String str5, int i, int i2, int i3, @androidx.annotation.Nullable java.lang.String str6) {
        return new com.google.android.exoplayer2.Format.Builder().setId(str).setLabel(str2).setLanguage(str6).setSelectionFlags(i2).setRoleFlags(i3).setAverageBitrate(i).setPeakBitrate(i).setCodecs(str5).setContainerMimeType(str3).setSampleMimeType(str4).build();
    }

    @java.lang.Deprecated
    public static com.google.android.exoplayer2.Format createImageSampleFormat(@androidx.annotation.Nullable java.lang.String str, @androidx.annotation.Nullable java.lang.String str2, int i, @androidx.annotation.Nullable java.util.List<byte[]> list, @androidx.annotation.Nullable java.lang.String str3) {
        return new com.google.android.exoplayer2.Format.Builder().setId(str).setLanguage(str3).setSelectionFlags(i).setSampleMimeType(str2).setInitializationData(list).build();
    }

    @java.lang.Deprecated
    public static com.google.android.exoplayer2.Format createSampleFormat(@androidx.annotation.Nullable java.lang.String str, @androidx.annotation.Nullable java.lang.String str2) {
        return new com.google.android.exoplayer2.Format.Builder().setId(str).setSampleMimeType(str2).build();
    }

    @java.lang.Deprecated
    public static com.google.android.exoplayer2.Format createTextContainerFormat(@androidx.annotation.Nullable java.lang.String str, @androidx.annotation.Nullable java.lang.String str2, @androidx.annotation.Nullable java.lang.String str3, @androidx.annotation.Nullable java.lang.String str4, @androidx.annotation.Nullable java.lang.String str5, int i, int i2, int i3, @androidx.annotation.Nullable java.lang.String str6) {
        return new com.google.android.exoplayer2.Format.Builder().setId(str).setLabel(str2).setLanguage(str6).setSelectionFlags(i2).setRoleFlags(i3).setAverageBitrate(i).setPeakBitrate(i).setCodecs(str5).setContainerMimeType(str3).setSampleMimeType(str4).build();
    }

    @java.lang.Deprecated
    public static com.google.android.exoplayer2.Format createTextContainerFormat(@androidx.annotation.Nullable java.lang.String str, @androidx.annotation.Nullable java.lang.String str2, @androidx.annotation.Nullable java.lang.String str3, @androidx.annotation.Nullable java.lang.String str4, @androidx.annotation.Nullable java.lang.String str5, int i, int i2, int i3, @androidx.annotation.Nullable java.lang.String str6, int i4) {
        return new com.google.android.exoplayer2.Format.Builder().setId(str).setLabel(str2).setLanguage(str6).setSelectionFlags(i2).setRoleFlags(i3).setAverageBitrate(i).setPeakBitrate(i).setCodecs(str5).setContainerMimeType(str3).setSampleMimeType(str4).setAccessibilityChannel(i4).build();
    }

    @java.lang.Deprecated
    public static com.google.android.exoplayer2.Format createTextSampleFormat(@androidx.annotation.Nullable java.lang.String str, @androidx.annotation.Nullable java.lang.String str2, int i, @androidx.annotation.Nullable java.lang.String str3) {
        return new com.google.android.exoplayer2.Format.Builder().setId(str).setLanguage(str3).setSelectionFlags(i).setSampleMimeType(str2).build();
    }

    @java.lang.Deprecated
    public static com.google.android.exoplayer2.Format createTextSampleFormat(@androidx.annotation.Nullable java.lang.String str, @androidx.annotation.Nullable java.lang.String str2, int i, @androidx.annotation.Nullable java.lang.String str3, int i2, long j, @androidx.annotation.Nullable java.util.List<byte[]> list) {
        return new com.google.android.exoplayer2.Format.Builder().setId(str).setLanguage(str3).setSelectionFlags(i).setSampleMimeType(str2).setInitializationData(list).setSubsampleOffsetUs(j).setAccessibilityChannel(i2).build();
    }

    @java.lang.Deprecated
    public static com.google.android.exoplayer2.Format createVideoContainerFormat(@androidx.annotation.Nullable java.lang.String str, @androidx.annotation.Nullable java.lang.String str2, @androidx.annotation.Nullable java.lang.String str3, @androidx.annotation.Nullable java.lang.String str4, @androidx.annotation.Nullable java.lang.String str5, @androidx.annotation.Nullable com.google.android.exoplayer2.metadata.Metadata metadata, int i, int i2, int i3, float f, @androidx.annotation.Nullable java.util.List<byte[]> list, int i4, int i5) {
        return new com.google.android.exoplayer2.Format.Builder().setId(str).setLabel(str2).setSelectionFlags(i4).setRoleFlags(i5).setAverageBitrate(i).setPeakBitrate(i).setCodecs(str5).setMetadata(metadata).setContainerMimeType(str3).setSampleMimeType(str4).setInitializationData(list).setWidth(i2).setHeight(i3).setFrameRate(f).build();
    }

    @java.lang.Deprecated
    public static com.google.android.exoplayer2.Format createVideoSampleFormat(@androidx.annotation.Nullable java.lang.String str, @androidx.annotation.Nullable java.lang.String str2, @androidx.annotation.Nullable java.lang.String str3, int i, int i2, int i3, int i4, float f, @androidx.annotation.Nullable java.util.List<byte[]> list, int i5, float f2, @androidx.annotation.Nullable com.google.android.exoplayer2.drm.DrmInitData drmInitData) {
        return new com.google.android.exoplayer2.Format.Builder().setId(str).setAverageBitrate(i).setPeakBitrate(i).setCodecs(str3).setSampleMimeType(str2).setMaxInputSize(i2).setInitializationData(list).setDrmInitData(drmInitData).setWidth(i3).setHeight(i4).setFrameRate(f).setRotationDegrees(i5).setPixelWidthHeightRatio(f2).build();
    }

    @java.lang.Deprecated
    public static com.google.android.exoplayer2.Format createVideoSampleFormat(@androidx.annotation.Nullable java.lang.String str, @androidx.annotation.Nullable java.lang.String str2, @androidx.annotation.Nullable java.lang.String str3, int i, int i2, int i3, int i4, float f, @androidx.annotation.Nullable java.util.List<byte[]> list, int i5, float f2, @androidx.annotation.Nullable byte[] bArr, int i6, @androidx.annotation.Nullable com.google.android.exoplayer2.video.ColorInfo colorInfo, @androidx.annotation.Nullable com.google.android.exoplayer2.drm.DrmInitData drmInitData) {
        return new com.google.android.exoplayer2.Format.Builder().setId(str).setAverageBitrate(i).setPeakBitrate(i).setCodecs(str3).setSampleMimeType(str2).setMaxInputSize(i2).setInitializationData(list).setDrmInitData(drmInitData).setWidth(i3).setHeight(i4).setFrameRate(f).setRotationDegrees(i5).setPixelWidthHeightRatio(f2).setProjectionData(bArr).setStereoMode(i6).setColorInfo(colorInfo).build();
    }

    @java.lang.Deprecated
    public static com.google.android.exoplayer2.Format createVideoSampleFormat(@androidx.annotation.Nullable java.lang.String str, @androidx.annotation.Nullable java.lang.String str2, @androidx.annotation.Nullable java.lang.String str3, int i, int i2, int i3, int i4, float f, @androidx.annotation.Nullable java.util.List<byte[]> list, @androidx.annotation.Nullable com.google.android.exoplayer2.drm.DrmInitData drmInitData) {
        return new com.google.android.exoplayer2.Format.Builder().setId(str).setAverageBitrate(i).setPeakBitrate(i).setCodecs(str3).setSampleMimeType(str2).setMaxInputSize(i2).setInitializationData(list).setDrmInitData(drmInitData).setWidth(i3).setHeight(i4).setFrameRate(f).build();
    }

    public static java.lang.String toLogString(@androidx.annotation.Nullable com.google.android.exoplayer2.Format format) {
        if (format == null) {
            return com.igexin.push.core.b.m;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("id=");
        sb.append(format.id);
        sb.append(", mimeType=");
        sb.append(format.sampleMimeType);
        if (format.bitrate != -1) {
            sb.append(", bitrate=");
            sb.append(format.bitrate);
        }
        if (format.codecs != null) {
            sb.append(", codecs=");
            sb.append(format.codecs);
        }
        if (format.width != -1 && format.height != -1) {
            sb.append(", res=");
            sb.append(format.width);
            sb.append("x");
            sb.append(format.height);
        }
        if (format.frameRate != -1.0f) {
            sb.append(", fps=");
            sb.append(format.frameRate);
        }
        if (format.channelCount != -1) {
            sb.append(", channels=");
            sb.append(format.channelCount);
        }
        if (format.sampleRate != -1) {
            sb.append(", sample_rate=");
            sb.append(format.sampleRate);
        }
        if (format.language != null) {
            sb.append(", language=");
            sb.append(format.language);
        }
        if (format.label != null) {
            sb.append(", label=");
            sb.append(format.label);
        }
        return sb.toString();
    }

    public com.google.android.exoplayer2.Format.Builder buildUpon() {
        return new com.google.android.exoplayer2.Format.Builder(this, null);
    }

    @java.lang.Deprecated
    public com.google.android.exoplayer2.Format copyWithBitrate(int i) {
        return buildUpon().setAverageBitrate(i).setPeakBitrate(i).build();
    }

    @java.lang.Deprecated
    public com.google.android.exoplayer2.Format copyWithDrmInitData(@androidx.annotation.Nullable com.google.android.exoplayer2.drm.DrmInitData drmInitData) {
        return buildUpon().setDrmInitData(drmInitData).build();
    }

    public com.google.android.exoplayer2.Format copyWithExoMediaCryptoType(@androidx.annotation.Nullable java.lang.Class<? extends com.google.android.exoplayer2.drm.ExoMediaCrypto> cls) {
        return buildUpon().setExoMediaCryptoType(cls).build();
    }

    @java.lang.Deprecated
    public com.google.android.exoplayer2.Format copyWithFrameRate(float f) {
        return buildUpon().setFrameRate(f).build();
    }

    @java.lang.Deprecated
    public com.google.android.exoplayer2.Format copyWithGaplessInfo(int i, int i2) {
        return buildUpon().setEncoderDelay(i).setEncoderPadding(i2).build();
    }

    @java.lang.Deprecated
    public com.google.android.exoplayer2.Format copyWithLabel(@androidx.annotation.Nullable java.lang.String str) {
        return buildUpon().setLabel(str).build();
    }

    @java.lang.Deprecated
    public com.google.android.exoplayer2.Format copyWithManifestFormatInfo(com.google.android.exoplayer2.Format format) {
        return withManifestFormatInfo(format);
    }

    @java.lang.Deprecated
    public com.google.android.exoplayer2.Format copyWithMaxInputSize(int i) {
        return buildUpon().setMaxInputSize(i).build();
    }

    @java.lang.Deprecated
    public com.google.android.exoplayer2.Format copyWithMetadata(@androidx.annotation.Nullable com.google.android.exoplayer2.metadata.Metadata metadata) {
        return buildUpon().setMetadata(metadata).build();
    }

    @java.lang.Deprecated
    public com.google.android.exoplayer2.Format copyWithSubsampleOffsetUs(long j) {
        return buildUpon().setSubsampleOffsetUs(j).build();
    }

    @java.lang.Deprecated
    public com.google.android.exoplayer2.Format copyWithVideoSize(int i, int i2) {
        return buildUpon().setWidth(i).setHeight(i2).build();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@androidx.annotation.Nullable java.lang.Object obj) {
        int i;
        if (this == obj) {
            return true;
        }
        if (obj == null || com.google.android.exoplayer2.Format.class != obj.getClass()) {
            return false;
        }
        com.google.android.exoplayer2.Format format = (com.google.android.exoplayer2.Format) obj;
        int i2 = this.hashCode;
        return (i2 == 0 || (i = format.hashCode) == 0 || i2 == i) && this.selectionFlags == format.selectionFlags && this.roleFlags == format.roleFlags && this.averageBitrate == format.averageBitrate && this.peakBitrate == format.peakBitrate && this.maxInputSize == format.maxInputSize && this.subsampleOffsetUs == format.subsampleOffsetUs && this.width == format.width && this.height == format.height && this.rotationDegrees == format.rotationDegrees && this.stereoMode == format.stereoMode && this.channelCount == format.channelCount && this.sampleRate == format.sampleRate && this.pcmEncoding == format.pcmEncoding && this.encoderDelay == format.encoderDelay && this.encoderPadding == format.encoderPadding && this.accessibilityChannel == format.accessibilityChannel && java.lang.Float.compare(this.frameRate, format.frameRate) == 0 && java.lang.Float.compare(this.pixelWidthHeightRatio, format.pixelWidthHeightRatio) == 0 && com.google.android.exoplayer2.util.Util.areEqual(this.exoMediaCryptoType, format.exoMediaCryptoType) && com.google.android.exoplayer2.util.Util.areEqual(this.id, format.id) && com.google.android.exoplayer2.util.Util.areEqual(this.label, format.label) && com.google.android.exoplayer2.util.Util.areEqual(this.codecs, format.codecs) && com.google.android.exoplayer2.util.Util.areEqual(this.containerMimeType, format.containerMimeType) && com.google.android.exoplayer2.util.Util.areEqual(this.sampleMimeType, format.sampleMimeType) && com.google.android.exoplayer2.util.Util.areEqual(this.language, format.language) && java.util.Arrays.equals(this.projectionData, format.projectionData) && com.google.android.exoplayer2.util.Util.areEqual(this.metadata, format.metadata) && com.google.android.exoplayer2.util.Util.areEqual(this.colorInfo, format.colorInfo) && com.google.android.exoplayer2.util.Util.areEqual(this.drmInitData, format.drmInitData) && initializationDataEquals(format);
    }

    public int getPixelCount() {
        int i;
        int i2 = this.width;
        if (i2 == -1 || (i = this.height) == -1) {
            return -1;
        }
        return i2 * i;
    }

    public int hashCode() {
        if (this.hashCode == 0) {
            java.lang.String str = this.id;
            int hashCode = (527 + (str == null ? 0 : str.hashCode())) * 31;
            java.lang.String str2 = this.label;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            java.lang.String str3 = this.language;
            int hashCode3 = (((((((((hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.selectionFlags) * 31) + this.roleFlags) * 31) + this.averageBitrate) * 31) + this.peakBitrate) * 31;
            java.lang.String str4 = this.codecs;
            int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
            com.google.android.exoplayer2.metadata.Metadata metadata = this.metadata;
            int hashCode5 = (hashCode4 + (metadata == null ? 0 : metadata.hashCode())) * 31;
            java.lang.String str5 = this.containerMimeType;
            int hashCode6 = (hashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
            java.lang.String str6 = this.sampleMimeType;
            int hashCode7 = (((((((((((((((((((((((((((((hashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31) + this.maxInputSize) * 31) + ((int) this.subsampleOffsetUs)) * 31) + this.width) * 31) + this.height) * 31) + java.lang.Float.floatToIntBits(this.frameRate)) * 31) + this.rotationDegrees) * 31) + java.lang.Float.floatToIntBits(this.pixelWidthHeightRatio)) * 31) + this.stereoMode) * 31) + this.channelCount) * 31) + this.sampleRate) * 31) + this.pcmEncoding) * 31) + this.encoderDelay) * 31) + this.encoderPadding) * 31) + this.accessibilityChannel) * 31;
            java.lang.Class<? extends com.google.android.exoplayer2.drm.ExoMediaCrypto> cls = this.exoMediaCryptoType;
            this.hashCode = hashCode7 + (cls != null ? cls.hashCode() : 0);
        }
        return this.hashCode;
    }

    public boolean initializationDataEquals(com.google.android.exoplayer2.Format format) {
        if (this.initializationData.size() != format.initializationData.size()) {
            return false;
        }
        for (int i = 0; i < this.initializationData.size(); i++) {
            if (!java.util.Arrays.equals(this.initializationData.get(i), format.initializationData.get(i))) {
                return false;
            }
        }
        return true;
    }

    public java.lang.String toString() {
        java.lang.String str = this.id;
        java.lang.String str2 = this.label;
        java.lang.String str3 = this.containerMimeType;
        java.lang.String str4 = this.sampleMimeType;
        java.lang.String str5 = this.codecs;
        int i = this.bitrate;
        java.lang.String str6 = this.language;
        int i2 = this.width;
        int i3 = this.height;
        float f = this.frameRate;
        int i4 = this.channelCount;
        int i5 = this.sampleRate;
        java.lang.StringBuilder sb = new java.lang.StringBuilder(java.lang.String.valueOf(str).length() + 104 + java.lang.String.valueOf(str2).length() + java.lang.String.valueOf(str3).length() + java.lang.String.valueOf(str4).length() + java.lang.String.valueOf(str5).length() + java.lang.String.valueOf(str6).length());
        sb.append("Format(");
        sb.append(str);
        sb.append(", ");
        sb.append(str2);
        sb.append(", ");
        sb.append(str3);
        sb.append(", ");
        sb.append(str4);
        sb.append(", ");
        sb.append(str5);
        sb.append(", ");
        sb.append(i);
        sb.append(", ");
        sb.append(str6);
        sb.append(", [");
        sb.append(i2);
        sb.append(", ");
        sb.append(i3);
        sb.append(", ");
        sb.append(f);
        sb.append("], [");
        sb.append(i4);
        sb.append(", ");
        sb.append(i5);
        sb.append("])");
        return sb.toString();
    }

    public com.google.android.exoplayer2.Format withManifestFormatInfo(com.google.android.exoplayer2.Format format) {
        java.lang.String str;
        if (this == format) {
            return this;
        }
        int trackType = com.google.android.exoplayer2.util.MimeTypes.getTrackType(this.sampleMimeType);
        java.lang.String str2 = format.id;
        java.lang.String str3 = format.label;
        if (str3 == null) {
            str3 = this.label;
        }
        java.lang.String str4 = this.language;
        if ((trackType == 3 || trackType == 1) && (str = format.language) != null) {
            str4 = str;
        }
        int i = this.averageBitrate;
        if (i == -1) {
            i = format.averageBitrate;
        }
        int i2 = this.peakBitrate;
        if (i2 == -1) {
            i2 = format.peakBitrate;
        }
        java.lang.String str5 = this.codecs;
        if (str5 == null) {
            java.lang.String codecsOfType = com.google.android.exoplayer2.util.Util.getCodecsOfType(format.codecs, trackType);
            if (com.google.android.exoplayer2.util.Util.splitCodecs(codecsOfType).length == 1) {
                str5 = codecsOfType;
            }
        }
        com.google.android.exoplayer2.metadata.Metadata metadata = this.metadata;
        com.google.android.exoplayer2.metadata.Metadata copyWithAppendedEntriesFrom = metadata == null ? format.metadata : metadata.copyWithAppendedEntriesFrom(format.metadata);
        float f = this.frameRate;
        if (f == -1.0f && trackType == 2) {
            f = format.frameRate;
        }
        return buildUpon().setId(str2).setLabel(str3).setLanguage(str4).setSelectionFlags(this.selectionFlags | format.selectionFlags).setRoleFlags(this.roleFlags | format.roleFlags).setAverageBitrate(i).setPeakBitrate(i2).setCodecs(str5).setMetadata(copyWithAppendedEntriesFrom).setDrmInitData(com.google.android.exoplayer2.drm.DrmInitData.createSessionCreationData(format.drmInitData, this.drmInitData)).setFrameRate(f).build();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeString(this.id);
        parcel.writeString(this.label);
        parcel.writeString(this.language);
        parcel.writeInt(this.selectionFlags);
        parcel.writeInt(this.roleFlags);
        parcel.writeInt(this.averageBitrate);
        parcel.writeInt(this.peakBitrate);
        parcel.writeString(this.codecs);
        parcel.writeParcelable(this.metadata, 0);
        parcel.writeString(this.containerMimeType);
        parcel.writeString(this.sampleMimeType);
        parcel.writeInt(this.maxInputSize);
        int size = this.initializationData.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            parcel.writeByteArray(this.initializationData.get(i2));
        }
        parcel.writeParcelable(this.drmInitData, 0);
        parcel.writeLong(this.subsampleOffsetUs);
        parcel.writeInt(this.width);
        parcel.writeInt(this.height);
        parcel.writeFloat(this.frameRate);
        parcel.writeInt(this.rotationDegrees);
        parcel.writeFloat(this.pixelWidthHeightRatio);
        com.google.android.exoplayer2.util.Util.writeBoolean(parcel, this.projectionData != null);
        byte[] bArr = this.projectionData;
        if (bArr != null) {
            parcel.writeByteArray(bArr);
        }
        parcel.writeInt(this.stereoMode);
        parcel.writeParcelable(this.colorInfo, i);
        parcel.writeInt(this.channelCount);
        parcel.writeInt(this.sampleRate);
        parcel.writeInt(this.pcmEncoding);
        parcel.writeInt(this.encoderDelay);
        parcel.writeInt(this.encoderPadding);
        parcel.writeInt(this.accessibilityChannel);
    }
}
