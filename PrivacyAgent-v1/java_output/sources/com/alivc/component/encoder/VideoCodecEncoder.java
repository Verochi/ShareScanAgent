package com.alivc.component.encoder;

@com.alivc.component.encoder.NativeUsed
/* loaded from: classes.dex */
public class VideoCodecEncoder {
    public static final int ERROR_API_LEVEL = 268448000;
    public static final int ERROR_INPUT_BUFFER_ERROR = 268448002;
    public static final int ERROR_NO_BUFFER_AVAILABLE = 268448003;
    public static final int ERROR_STATE = 268448001;
    public static final int OK = 0;
    private static final int STATE_ENCODING = 2;
    private static final int STATE_INITIALIZED = 1;
    private static final int STATE_UNINITIALIZED = 0;
    private android.media.MediaCodec mMediaCodec;
    private java.nio.ByteBuffer[] mOutputBuffers;
    public static final int[] SUPPORTED_COLOR_FORMATS = {21, 39, 19, 20, 2130706688};
    public static final java.lang.String VERSION = "1.2.2";
    private static final java.lang.String TAG = com.alivc.component.encoder.VideoCodecEncoder.class.getName() + " version" + VERSION;
    private int mState = 0;
    private int encodeFormat = -1;
    private int mOutputCount = 0;
    private android.view.Surface mSurface = null;

    private static boolean isRecognizedFormat(int i) {
        if (i == 39 || i == 2130706688) {
            return true;
        }
        switch (i) {
            case 19:
            case 20:
            case 21:
                return true;
            default:
                return false;
        }
    }

    private android.media.MediaCodecInfo selectCodecInfo(java.lang.String str) {
        int codecCount = android.media.MediaCodecList.getCodecCount();
        for (int i = 0; i < codecCount; i++) {
            android.media.MediaCodecInfo codecInfoAt = android.media.MediaCodecList.getCodecInfoAt(i);
            if (codecInfoAt.isEncoder()) {
                for (java.lang.String str2 : codecInfoAt.getSupportedTypes()) {
                    if (str2.equalsIgnoreCase(str)) {
                        return codecInfoAt;
                    }
                }
            }
        }
        return null;
    }

    private static int selectColorFormat(android.media.MediaCodecInfo mediaCodecInfo, boolean z, java.lang.String str) {
        if (z) {
            return 2130708361;
        }
        android.media.MediaCodecInfo.CodecCapabilities capabilitiesForType = mediaCodecInfo.getCapabilitiesForType(str);
        int i = 0;
        while (true) {
            int[] iArr = capabilitiesForType.colorFormats;
            if (i >= iArr.length) {
                return 0;
            }
            int i2 = iArr[i];
            if (isRecognizedFormat(i2)) {
                return i2;
            }
            i++;
        }
    }

    @com.alivc.component.encoder.NativeUsed
    public android.view.Surface createInputSurface() {
        android.media.MediaCodec mediaCodec = this.mMediaCodec;
        if (mediaCodec != null && this.mState == 1) {
            try {
                if (this.mSurface == null) {
                    this.mSurface = mediaCodec.createInputSurface();
                }
                return this.mSurface;
            } catch (java.lang.Exception e) {
                this.mSurface = null;
                e.printStackTrace();
            }
        }
        return null;
    }

    @com.alivc.component.encoder.NativeUsed
    public int init(java.lang.String str, android.media.MediaFormat mediaFormat, boolean z, int i) {
        int i2;
        java.lang.reflect.InvocationTargetException invocationTargetException;
        int i3;
        java.lang.NoSuchMethodException noSuchMethodException;
        int i4;
        java.lang.IllegalAccessException illegalAccessException;
        int i5;
        java.io.IOException iOException;
        android.media.MediaCodecInfo mediaCodecInfo;
        java.lang.String str2;
        java.lang.String str3;
        java.lang.String str4;
        java.lang.String str5;
        java.lang.String str6;
        if (this.mState != 0) {
            return ERROR_STATE;
        }
        try {
            try {
                this.mOutputCount = 0;
                try {
                    android.media.MediaCodecInfo selectCodecInfo = selectCodecInfo(str);
                    if (selectCodecInfo == null) {
                        java.lang.StringBuilder sb = new java.lang.StringBuilder();
                        sb.append("not supported mime type (");
                        sb.append(str);
                        sb.append(")");
                        return -1;
                    }
                    java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                    sb2.append("Create MediaCodec ");
                    sb2.append(selectCodecInfo.getName());
                    this.mMediaCodec = android.media.MediaCodec.createByCodecName(selectCodecInfo.getName());
                    android.media.MediaCodecInfo.CodecCapabilities capabilitiesForType = selectCodecInfo.getCapabilitiesForType(str);
                    java.util.Arrays.toString(capabilitiesForType.colorFormats);
                    int selectColorFormat = selectColorFormat(selectCodecInfo, z, str);
                    this.encodeFormat = selectColorFormat;
                    if (selectColorFormat == 0) {
                        return -1;
                    }
                    java.lang.StringBuilder sb3 = new java.lang.StringBuilder();
                    sb3.append("selected format ");
                    sb3.append(this.encodeFormat);
                    mediaFormat.setInteger("color-format", this.encodeFormat);
                    mediaFormat.getInteger("frame-rate");
                    mediaFormat.setInteger("i-frame-interval", i);
                    mediaFormat.setInteger(com.google.android.gms.common.Scopes.PROFILE, 1);
                    mediaFormat.setInteger(com.aliyun.svideo.downloader.FileDownloaderModel.LEVEL, 512);
                    int i6 = android.os.Build.VERSION.SDK_INT;
                    if (i6 < 29) {
                        try {
                            mediaCodecInfo = selectCodecInfo;
                            android.media.MediaCodecInfo.VideoCapabilities videoCapabilities = (android.media.MediaCodecInfo.VideoCapabilities) android.media.MediaCodecInfo.VideoCapabilities.class.getMethod("create", android.media.MediaFormat.class, android.media.MediaCodecInfo.CodecCapabilities.class).invoke(null, mediaFormat, capabilitiesForType);
                            android.util.Range<java.lang.Integer> bitrateRange = videoCapabilities.getBitrateRange();
                            int widthAlignment = videoCapabilities.getWidthAlignment();
                            int heightAlignment = videoCapabilities.getHeightAlignment();
                            android.util.Range<java.lang.Integer> supportedWidths = videoCapabilities.getSupportedWidths();
                            android.util.Range<java.lang.Integer> supportedHeights = videoCapabilities.getSupportedHeights();
                            int integer = mediaFormat.getInteger("width");
                            str2 = "width";
                            int integer2 = mediaFormat.getInteger("height");
                            str3 = "height";
                            int integer3 = mediaFormat.getInteger("frame-rate");
                            str4 = com.aliyun.svideo.downloader.FileDownloaderModel.LEVEL;
                            boolean isSizeSupported = videoCapabilities.isSizeSupported(integer, integer2);
                            str5 = com.google.android.gms.common.Scopes.PROFILE;
                            java.lang.StringBuilder sb4 = new java.lang.StringBuilder();
                            str6 = "frame-rate";
                            sb4.append("bitrateRange [");
                            sb4.append(bitrateRange.getLower());
                            sb4.append(",");
                            sb4.append(bitrateRange.getUpper());
                            sb4.append("], widthAlignment = ");
                            sb4.append(widthAlignment);
                            sb4.append(", heightAlignment = ");
                            sb4.append(heightAlignment);
                            sb4.append(", widthRange [");
                            sb4.append(supportedWidths.getLower());
                            sb4.append(",");
                            sb4.append(supportedWidths.getUpper());
                            sb4.append("], heightRange [");
                            sb4.append(supportedHeights.getLower());
                            sb4.append(",");
                            sb4.append(supportedHeights.getUpper());
                            sb4.append("], isSizeSupport = ");
                            sb4.append(isSizeSupported);
                            sb4.append(", sizeAndRateSupport = ");
                            sb4.append(videoCapabilities.areSizeAndRateSupported(integer, integer2, integer3));
                            if (i6 >= 23) {
                                mediaFormat.setInteger("stride", integer);
                                mediaFormat.setInteger("slice-height", integer2);
                            }
                        } catch (java.io.IOException e) {
                            e = e;
                            iOException = e;
                            i5 = ERROR_STATE;
                            iOException.printStackTrace();
                            return i5;
                        } catch (java.lang.IllegalAccessException e2) {
                            e = e2;
                            illegalAccessException = e;
                            i4 = ERROR_STATE;
                            illegalAccessException.printStackTrace();
                            return i4;
                        } catch (java.lang.NoSuchMethodException e3) {
                            e = e3;
                            noSuchMethodException = e;
                            i3 = ERROR_STATE;
                            noSuchMethodException.printStackTrace();
                            return i3;
                        } catch (java.lang.reflect.InvocationTargetException e4) {
                            e = e4;
                            invocationTargetException = e;
                            i2 = ERROR_STATE;
                            invocationTargetException.printStackTrace();
                            return i2;
                        } catch (java.lang.Exception e5) {
                            e = e5;
                            e.printStackTrace();
                            return ERROR_STATE;
                        }
                    } else {
                        str4 = com.aliyun.svideo.downloader.FileDownloaderModel.LEVEL;
                        str5 = com.google.android.gms.common.Scopes.PROFILE;
                        str6 = "frame-rate";
                        str2 = "width";
                        mediaCodecInfo = selectCodecInfo;
                        str3 = "height";
                    }
                    java.lang.StringBuilder sb5 = new java.lang.StringBuilder();
                    sb5.append("encoder bitrate = ");
                    sb5.append(mediaFormat.getInteger(tv.danmaku.ijk.media.player.IjkMediaMeta.IJKM_KEY_BITRATE));
                    sb5.append(", encoder i frame interval = ");
                    sb5.append(mediaFormat.getInteger("i-frame-interval"));
                    sb5.append(", encoder frame rate = ");
                    sb5.append(mediaFormat.getInteger(str6));
                    sb5.append(", encoder profile = ");
                    sb5.append(mediaFormat.getInteger(str5));
                    sb5.append(", encoder level = ");
                    sb5.append(mediaFormat.getInteger(str4));
                    sb5.append(", encoder width = ");
                    sb5.append(mediaFormat.getInteger(str2));
                    sb5.append(", encoder height = ");
                    sb5.append(mediaFormat.getInteger(str3));
                    this.mMediaCodec.configure(mediaFormat, (android.view.Surface) null, (android.media.MediaCrypto) null, 1);
                    this.mState = 1;
                    if ("OMX.IMG.TOPAZ.VIDEO.Encoder".equals(mediaCodecInfo.getName())) {
                        java.lang.StringBuilder sb6 = new java.lang.StringBuilder();
                        sb6.append("Product:");
                        sb6.append(android.os.Build.PRODUCT);
                        int i7 = this.encodeFormat;
                        if (i7 != 39) {
                            switch (i7) {
                                case 19:
                                    this.encodeFormat = 20;
                                    break;
                                case 20:
                                    this.encodeFormat = 19;
                                    break;
                                case 21:
                                    this.encodeFormat = 39;
                                    break;
                            }
                        } else {
                            this.encodeFormat = 21;
                        }
                    }
                    return this.encodeFormat;
                } catch (java.io.IOException e6) {
                    e = e6;
                } catch (java.lang.IllegalAccessException e7) {
                    e = e7;
                } catch (java.lang.NoSuchMethodException e8) {
                    e = e8;
                } catch (java.lang.reflect.InvocationTargetException e9) {
                    e = e9;
                }
            } catch (java.lang.Exception e10) {
                e = e10;
            }
        } catch (java.io.IOException e11) {
            i5 = ERROR_STATE;
            iOException = e11;
        } catch (java.lang.IllegalAccessException e12) {
            i4 = ERROR_STATE;
            illegalAccessException = e12;
        } catch (java.lang.NoSuchMethodException e13) {
            i3 = ERROR_STATE;
            noSuchMethodException = e13;
        } catch (java.lang.reflect.InvocationTargetException e14) {
            i2 = ERROR_STATE;
            invocationTargetException = e14;
        }
    }

    @com.alivc.component.encoder.NativeUsed
    public int initWithColorSpace(java.lang.String str, android.media.MediaFormat mediaFormat, boolean z, int i, int i2, int i3) {
        int i4;
        java.lang.reflect.InvocationTargetException invocationTargetException;
        int i5;
        java.lang.NoSuchMethodException noSuchMethodException;
        int i6;
        java.lang.IllegalAccessException illegalAccessException;
        int i7;
        java.io.IOException iOException;
        android.media.MediaCodecInfo mediaCodecInfo;
        java.lang.String str2;
        java.lang.String str3;
        java.lang.String str4;
        java.lang.String str5;
        int i8;
        int i9;
        if (this.mState != 0) {
            return ERROR_STATE;
        }
        try {
            try {
                this.mOutputCount = 0;
                try {
                    android.media.MediaCodecInfo selectCodecInfo = selectCodecInfo(str);
                    if (selectCodecInfo == null) {
                        java.lang.StringBuilder sb = new java.lang.StringBuilder();
                        sb.append("not supported mime type (");
                        sb.append(str);
                        sb.append(")");
                        return -1;
                    }
                    java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                    sb2.append("Create MediaCodec ");
                    sb2.append(selectCodecInfo.getName());
                    sb2.append(" version ");
                    sb2.append(VERSION);
                    this.mMediaCodec = android.media.MediaCodec.createByCodecName(selectCodecInfo.getName());
                    android.media.MediaCodecInfo.CodecCapabilities capabilitiesForType = selectCodecInfo.getCapabilitiesForType(str);
                    java.util.Arrays.toString(capabilitiesForType.colorFormats);
                    int selectColorFormat = selectColorFormat(selectCodecInfo, z, str);
                    this.encodeFormat = selectColorFormat;
                    if (selectColorFormat == 0) {
                        return -1;
                    }
                    java.lang.StringBuilder sb3 = new java.lang.StringBuilder();
                    sb3.append("selected format ");
                    sb3.append(this.encodeFormat);
                    mediaFormat.setInteger("color-format", this.encodeFormat);
                    mediaFormat.getInteger("frame-rate");
                    mediaFormat.setInteger("i-frame-interval", i);
                    mediaFormat.setInteger(com.google.android.gms.common.Scopes.PROFILE, 1);
                    mediaFormat.setInteger(com.aliyun.svideo.downloader.FileDownloaderModel.LEVEL, 512);
                    int i10 = android.os.Build.VERSION.SDK_INT;
                    if (i10 < 29) {
                        try {
                            mediaCodecInfo = selectCodecInfo;
                            android.media.MediaCodecInfo.VideoCapabilities videoCapabilities = (android.media.MediaCodecInfo.VideoCapabilities) android.media.MediaCodecInfo.VideoCapabilities.class.getMethod("create", android.media.MediaFormat.class, android.media.MediaCodecInfo.CodecCapabilities.class).invoke(null, mediaFormat, capabilitiesForType);
                            android.util.Range<java.lang.Integer> bitrateRange = videoCapabilities.getBitrateRange();
                            int widthAlignment = videoCapabilities.getWidthAlignment();
                            int heightAlignment = videoCapabilities.getHeightAlignment();
                            android.util.Range<java.lang.Integer> supportedWidths = videoCapabilities.getSupportedWidths();
                            android.util.Range<java.lang.Integer> supportedHeights = videoCapabilities.getSupportedHeights();
                            int integer = mediaFormat.getInteger("width");
                            int integer2 = mediaFormat.getInteger("height");
                            str2 = "height";
                            int integer3 = mediaFormat.getInteger("frame-rate");
                            str3 = "width";
                            boolean isSizeSupported = videoCapabilities.isSizeSupported(integer, integer2);
                            str4 = com.aliyun.svideo.downloader.FileDownloaderModel.LEVEL;
                            java.lang.StringBuilder sb4 = new java.lang.StringBuilder();
                            str5 = com.google.android.gms.common.Scopes.PROFILE;
                            sb4.append("bitrateRange [");
                            sb4.append(bitrateRange.getLower());
                            sb4.append(",");
                            sb4.append(bitrateRange.getUpper());
                            sb4.append("], widthAlignment = ");
                            sb4.append(widthAlignment);
                            sb4.append(", heightAlignment = ");
                            sb4.append(heightAlignment);
                            sb4.append(", widthRange [");
                            sb4.append(supportedWidths.getLower());
                            sb4.append(",");
                            sb4.append(supportedWidths.getUpper());
                            sb4.append("], heightRange [");
                            sb4.append(supportedHeights.getLower());
                            sb4.append(",");
                            sb4.append(supportedHeights.getUpper());
                            sb4.append("], isSizeSupport = ");
                            sb4.append(isSizeSupported);
                            sb4.append(", sizeAndRateSupport = ");
                            sb4.append(videoCapabilities.areSizeAndRateSupported(integer, integer2, integer3));
                            if (i10 >= 23) {
                                mediaFormat.setInteger("stride", integer);
                                mediaFormat.setInteger("slice-height", integer2);
                            }
                        } catch (java.io.IOException e) {
                            e = e;
                            iOException = e;
                            i7 = ERROR_STATE;
                            iOException.printStackTrace();
                            return i7;
                        } catch (java.lang.IllegalAccessException e2) {
                            e = e2;
                            illegalAccessException = e;
                            i6 = ERROR_STATE;
                            illegalAccessException.printStackTrace();
                            return i6;
                        } catch (java.lang.NoSuchMethodException e3) {
                            e = e3;
                            noSuchMethodException = e;
                            i5 = ERROR_STATE;
                            noSuchMethodException.printStackTrace();
                            return i5;
                        } catch (java.lang.reflect.InvocationTargetException e4) {
                            e = e4;
                            invocationTargetException = e;
                            i4 = ERROR_STATE;
                            invocationTargetException.printStackTrace();
                            return i4;
                        } catch (java.lang.Exception e5) {
                            e = e5;
                            e.printStackTrace();
                            return ERROR_STATE;
                        }
                    } else {
                        str4 = com.aliyun.svideo.downloader.FileDownloaderModel.LEVEL;
                        str5 = com.google.android.gms.common.Scopes.PROFILE;
                        str3 = "width";
                        mediaCodecInfo = selectCodecInfo;
                        str2 = "height";
                    }
                    if (i10 >= 24) {
                        i8 = i2 == 0 ? 2 : i2;
                        i9 = i3 == 0 ? 2 : i3;
                        if (1 != i8) {
                            if (2 != i8) {
                                if (6 == i8) {
                                }
                                if (1 != i9 || 2 == i9) {
                                    mediaFormat.setInteger("color-range", i9);
                                }
                            }
                        }
                        mediaFormat.setInteger("color-standard", i8);
                        mediaFormat.setInteger("color-transfer", 3);
                        if (1 != i9) {
                        }
                        mediaFormat.setInteger("color-range", i9);
                    } else {
                        java.lang.StringBuilder sb5 = new java.lang.StringBuilder();
                        sb5.append("Build.VERSION.SDK_INT = ");
                        sb5.append(i10);
                        sb5.append(" is lower than 24");
                        i8 = i2;
                        i9 = i3;
                    }
                    java.lang.StringBuilder sb6 = new java.lang.StringBuilder();
                    sb6.append("encoder bitrate = ");
                    sb6.append(mediaFormat.getInteger(tv.danmaku.ijk.media.player.IjkMediaMeta.IJKM_KEY_BITRATE));
                    sb6.append(", encoder i frame interval = ");
                    sb6.append(mediaFormat.getInteger("i-frame-interval"));
                    sb6.append(", encoder frame rate = ");
                    sb6.append(mediaFormat.getInteger("frame-rate"));
                    sb6.append(", encoder profile = ");
                    sb6.append(mediaFormat.getInteger(str5));
                    sb6.append(", encoder level = ");
                    sb6.append(mediaFormat.getInteger(str4));
                    sb6.append(", encoder width = ");
                    sb6.append(mediaFormat.getInteger(str3));
                    sb6.append(", encoder height = ");
                    sb6.append(mediaFormat.getInteger(str2));
                    sb6.append(", colorStand = ");
                    sb6.append(i8);
                    sb6.append(", colorRange = ");
                    sb6.append(i9);
                    this.mMediaCodec.configure(mediaFormat, (android.view.Surface) null, (android.media.MediaCrypto) null, 1);
                    this.mState = 1;
                    if ("OMX.IMG.TOPAZ.VIDEO.Encoder".equals(mediaCodecInfo.getName())) {
                        java.lang.StringBuilder sb7 = new java.lang.StringBuilder();
                        sb7.append("Product:");
                        sb7.append(android.os.Build.PRODUCT);
                        int i11 = this.encodeFormat;
                        if (i11 != 39) {
                            switch (i11) {
                                case 19:
                                    this.encodeFormat = 20;
                                    break;
                                case 20:
                                    this.encodeFormat = 19;
                                    break;
                                case 21:
                                    this.encodeFormat = 39;
                                    break;
                            }
                        } else {
                            this.encodeFormat = 21;
                        }
                    }
                    return this.encodeFormat;
                } catch (java.io.IOException e6) {
                    e = e6;
                } catch (java.lang.IllegalAccessException e7) {
                    e = e7;
                } catch (java.lang.NoSuchMethodException e8) {
                    e = e8;
                } catch (java.lang.reflect.InvocationTargetException e9) {
                    e = e9;
                }
            } catch (java.lang.Exception e10) {
                e = e10;
            }
        } catch (java.io.IOException e11) {
            i7 = ERROR_STATE;
            iOException = e11;
        } catch (java.lang.IllegalAccessException e12) {
            i6 = ERROR_STATE;
            illegalAccessException = e12;
        } catch (java.lang.NoSuchMethodException e13) {
            i5 = ERROR_STATE;
            noSuchMethodException = e13;
        } catch (java.lang.reflect.InvocationTargetException e14) {
            i4 = ERROR_STATE;
            invocationTargetException = e14;
        }
    }

    @com.alivc.component.encoder.NativeUsed
    public int inputFrame(byte[] bArr, long j, long j2, boolean z) {
        try {
            java.nio.ByteBuffer[] inputBuffers = this.mMediaCodec.getInputBuffers();
            int dequeueInputBuffer = this.mMediaCodec.dequeueInputBuffer(j2);
            if (dequeueInputBuffer < 0) {
                return ERROR_NO_BUFFER_AVAILABLE;
            }
            inputBuffers[dequeueInputBuffer].clear();
            if (bArr != null) {
                inputBuffers[dequeueInputBuffer].put(bArr, 0, bArr.length);
            }
            if (z) {
                android.os.Bundle bundle = new android.os.Bundle();
                bundle.putInt("request-sync", 0);
                this.mMediaCodec.setParameters(bundle);
            }
            this.mMediaCodec.queueInputBuffer(dequeueInputBuffer, 0, inputBuffers[dequeueInputBuffer].position(), j, z ? 1 : 0);
            return 0;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @com.alivc.component.encoder.NativeUsed
    public int release() {
        if (this.mState != 1) {
            return ERROR_STATE;
        }
        this.mMediaCodec.release();
        this.mMediaCodec = null;
        android.view.Surface surface = this.mSurface;
        if (surface != null) {
            surface.release();
            this.mSurface = null;
        }
        this.mState = 0;
        return 0;
    }

    @com.alivc.component.encoder.NativeUsed
    @androidx.annotation.RequiresApi(api = 23)
    public int setInputSurface(android.view.Surface surface) {
        android.media.MediaCodec mediaCodec = this.mMediaCodec;
        if (mediaCodec == null || this.mState != 1) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("error state codec ");
            sb.append(this.mMediaCodec);
            return -1;
        }
        try {
            mediaCodec.setInputSurface(surface);
            return 0;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @com.alivc.component.encoder.NativeUsed
    public int signalEndOfInput() {
        try {
            this.mMediaCodec.signalEndOfInputStream();
            return 0;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @com.alivc.component.encoder.NativeUsed
    public int start() {
        android.media.MediaCodec mediaCodec = this.mMediaCodec;
        if (mediaCodec != null && this.mState == 1) {
            try {
                mediaCodec.start();
                this.mOutputBuffers = this.mMediaCodec.getOutputBuffers();
                this.mState = 2;
                return 0;
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
        return ERROR_STATE;
    }

    @com.alivc.component.encoder.NativeUsed
    public int stop() {
        android.media.MediaCodec mediaCodec;
        if (this.mState == 2 && (mediaCodec = this.mMediaCodec) != null) {
            try {
                if (this.mOutputCount > 0) {
                    mediaCodec.flush();
                }
                this.mMediaCodec.stop();
                this.mState = 1;
                return 0;
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
        return ERROR_STATE;
    }

    @com.alivc.component.encoder.NativeUsed
    public com.alivc.component.encoder.MediaCodecData tryRead(long j) {
        android.media.MediaCodec.BufferInfo bufferInfo = new android.media.MediaCodec.BufferInfo();
        com.alivc.component.encoder.MediaCodecData mediaCodecData = new com.alivc.component.encoder.MediaCodecData();
        try {
            int dequeueOutputBuffer = this.mMediaCodec.dequeueOutputBuffer(bufferInfo, j);
            if (dequeueOutputBuffer >= 0) {
                java.nio.ByteBuffer byteBuffer = this.mOutputBuffers[dequeueOutputBuffer];
                if (bufferInfo.size != 0) {
                    byteBuffer.position(bufferInfo.offset);
                    byteBuffer.limit(bufferInfo.offset + bufferInfo.size);
                }
                mediaCodecData.setCodecData(byteBuffer, this.mMediaCodec, dequeueOutputBuffer);
                int i = bufferInfo.flags;
                if ((i & 2) > 0) {
                    mediaCodecData.setDataType(1);
                } else if ((i & 1) > 0) {
                    mediaCodecData.setDataType(3);
                    this.mOutputCount++;
                } else {
                    mediaCodecData.setDataType(2);
                    this.mOutputCount++;
                }
                mediaCodecData.setPts(bufferInfo.presentationTimeUs);
                mediaCodecData.setDts(bufferInfo.presentationTimeUs);
                if ((bufferInfo.flags & 4) > 0) {
                    mediaCodecData.setEos(true);
                } else {
                    mediaCodecData.setEos(false);
                }
            } else if (dequeueOutputBuffer == -2) {
                this.mOutputBuffers = this.mMediaCodec.getOutputBuffers();
                mediaCodecData.setCode(1);
            } else if (dequeueOutputBuffer == -1) {
                mediaCodecData.setCode(1);
            } else if (dequeueOutputBuffer == -3) {
                this.mOutputBuffers = this.mMediaCodec.getOutputBuffers();
                mediaCodecData.setCode(1);
            } else {
                mediaCodecData.setCode(-1);
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        return mediaCodecData;
    }

    @com.alivc.component.encoder.NativeUsed
    public int updateBitrate(int i) {
        if (this.mState != 2 || this.mMediaCodec == null) {
            return ERROR_STATE;
        }
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putInt("video-bitrate", i * 1000);
        try {
            this.mMediaCodec.setParameters(bundle);
            return 0;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
