package com.cicada.player.utils.media;

@com.cicada.player.utils.NativeUsed
/* loaded from: classes22.dex */
public class MediaCodecDecoder {
    private static int CODEC_CATEGORY_AUDIO = 1;
    private static int CODEC_CATEGORY_VIDEO = 0;
    private static final int ERROR = -1;
    private static final java.lang.String TAG = "MediaCodecDecoder";
    private static final int TRY_AGAIN = -11;
    private java.lang.String mDecoderName;
    private java.lang.String mMime;
    private static final java.lang.Object queLock = new java.lang.Object();
    static java.util.List<java.lang.String> blackCodecPrefix = new java.util.ArrayList();
    static java.util.List<java.lang.String> blackCodecSuffix = new java.util.ArrayList();
    private java.util.Map<java.lang.String, byte[]> mCodecSpecificDataMap = new java.util.LinkedHashMap();
    private int mCodecCateGory = CODEC_CATEGORY_VIDEO;
    private android.media.MediaCodec mMediaCodec = null;
    private android.media.MediaCrypto mediaCrypto = null;
    private boolean forceInsecureDecoder = false;
    private java.nio.ByteBuffer[] mInputBuffers = null;
    private java.nio.ByteBuffer[] mOutputBuffers = null;
    private android.media.MediaCodec.BufferInfo mBufferInfo = null;
    private boolean started = false;

    private android.media.MediaCodec.CryptoInfo createCryptoInfo(com.cicada.player.utils.media.EncryptionInfo encryptionInfo) {
        int i;
        android.media.MediaCodec.CryptoInfo cryptoInfo = new android.media.MediaCodec.CryptoInfo();
        cryptoInfo.key = encryptionInfo.key_id;
        cryptoInfo.iv = encryptionInfo.iv;
        java.util.List<com.cicada.player.utils.media.SubsampleEncryptionInfo> list = encryptionInfo.subsamples;
        if (list != null) {
            int size = list.size();
            cryptoInfo.numSubSamples = size;
            cryptoInfo.numBytesOfClearData = new int[size];
            cryptoInfo.numBytesOfEncryptedData = new int[size];
            for (int i2 = 0; i2 < encryptionInfo.subsamples.size(); i2++) {
                com.cicada.player.utils.media.SubsampleEncryptionInfo subsampleEncryptionInfo = encryptionInfo.subsamples.get(i2);
                cryptoInfo.numBytesOfClearData[i2] = subsampleEncryptionInfo.bytes_of_clear_data;
                cryptoInfo.numBytesOfEncryptedData[i2] = subsampleEncryptionInfo.bytes_of_protected_data;
            }
        }
        if (!"cenc".equals(encryptionInfo.scheme) && !"cens".equals(encryptionInfo.scheme)) {
            i = ("cbc1".equals(encryptionInfo.scheme) || "cbcs".equals(encryptionInfo.scheme)) ? 2 : 1;
            if (android.os.Build.VERSION.SDK_INT >= 24 && ("cens".equals(encryptionInfo.scheme) || "cbcs".equals(encryptionInfo.scheme))) {
                cryptoInfo.setPattern(new android.media.MediaCodec.CryptoInfo.Pattern(encryptionInfo.crypt_byte_block, encryptionInfo.skip_byte_block));
            }
            return cryptoInfo;
        }
        cryptoInfo.mode = i;
        if (android.os.Build.VERSION.SDK_INT >= 24) {
            cryptoInfo.setPattern(new android.media.MediaCodec.CryptoInfo.Pattern(encryptionInfo.crypt_byte_block, encryptionInfo.skip_byte_block));
        }
        return cryptoInfo;
    }

    private com.cicada.player.utils.media.OutputBufferInfo fillDecodeBufferInfo(int i) {
        com.cicada.player.utils.media.OutputBufferInfo outputBufferInfo = new com.cicada.player.utils.media.OutputBufferInfo();
        outputBufferInfo.type = 0;
        outputBufferInfo.index = i;
        android.media.MediaCodec.BufferInfo bufferInfo = this.mBufferInfo;
        outputBufferInfo.pts = bufferInfo.presentationTimeUs;
        outputBufferInfo.eos = (bufferInfo.flags & 4) != 0;
        outputBufferInfo.bufferSize = bufferInfo.size;
        outputBufferInfo.bufferOffset = bufferInfo.offset;
        return outputBufferInfo;
    }

    private com.cicada.player.utils.media.OutputBufferInfo fillFormatOutputBufferInfo() {
        try {
            android.media.MediaFormat outputFormat = this.mMediaCodec.getOutputFormat();
            com.cicada.player.utils.media.OutputBufferInfo outputBufferInfo = new com.cicada.player.utils.media.OutputBufferInfo();
            outputBufferInfo.type = 1;
            outputBufferInfo.eos = false;
            if (this.mCodecCateGory == CODEC_CATEGORY_VIDEO) {
                outputBufferInfo.videoCropBottom = getFormatInteger(outputFormat, "crop-bottom");
                outputBufferInfo.videoCropLeft = getFormatInteger(outputFormat, "crop-left");
                outputBufferInfo.videoCropRight = getFormatInteger(outputFormat, "crop-right");
                outputBufferInfo.videoCropTop = getFormatInteger(outputFormat, "crop-top");
                outputBufferInfo.videoHeight = getFormatInteger(outputFormat, "width");
                outputBufferInfo.videoWidth = getFormatInteger(outputFormat, "height");
                outputBufferInfo.videoPixelFormat = getFormatInteger(outputFormat, "color-format");
                outputBufferInfo.videoSliceHeight = getFormatInteger(outputFormat, "slice-height");
                outputBufferInfo.videoStride = getFormatInteger(outputFormat, "stride");
            } else {
                outputBufferInfo.audioChannelCount = getFormatInteger(outputFormat, "channel-count");
                outputBufferInfo.audioChannelMask = getFormatInteger(outputFormat, "channel-mask");
                outputBufferInfo.audioSampleRate = getFormatInteger(outputFormat, "sample-rate");
                outputBufferInfo.audioFormat = getFormatInteger(outputFormat, "pcm-encoding");
            }
            return outputBufferInfo;
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    private java.lang.String findDecoderName(android.media.MediaFormat mediaFormat) {
        android.media.MediaCrypto mediaCrypto = this.mediaCrypto;
        boolean z = false;
        if (mediaCrypto != null && !this.forceInsecureDecoder && mediaCrypto.requiresSecureDecoderComponent(this.mMime)) {
            z = true;
        }
        java.lang.String decoderName = getDecoderName(mediaFormat, z);
        com.cicada.player.utils.Logger.i(TAG, "findDecoderName : " + decoderName + " , secure = " + z);
        return decoderName;
    }

    private java.lang.String getDecoderName(android.media.MediaFormat mediaFormat, boolean z) {
        java.util.List<android.media.MediaCodecInfo> codecInfos = com.cicada.player.utils.media.MediaCodecUtils.getCodecInfos(this.mMime, z, mediaFormat);
        java.lang.String notBlackCodecName = getNotBlackCodecName(codecInfos);
        return (this.mediaCrypto == null || !android.text.TextUtils.isEmpty(notBlackCodecName) || codecInfos.isEmpty()) ? notBlackCodecName : codecInfos.get(0).getName();
    }

    private static int getFormatInteger(android.media.MediaFormat mediaFormat, java.lang.String str) {
        if (mediaFormat.containsKey(str)) {
            return mediaFormat.getInteger(str);
        }
        return -1;
    }

    private java.nio.ByteBuffer getInputBuffer(int i) {
        try {
            return this.mMediaCodec.getInputBuffer(i);
        } catch (java.lang.Exception e) {
            com.cicada.player.utils.Logger.e(TAG, "getInputBuffer fail " + e.getMessage());
            return null;
        }
    }

    private java.lang.String getNotBlackCodecName(java.util.List<android.media.MediaCodecInfo> list) {
        if (!list.isEmpty()) {
            for (android.media.MediaCodecInfo mediaCodecInfo : list) {
                if (!isBlackCodec(mediaCodecInfo)) {
                    return mediaCodecInfo.getName();
                }
            }
        }
        return null;
    }

    private static boolean isBlackCodec(android.media.MediaCodecInfo mediaCodecInfo) {
        if (blackCodecPrefix.isEmpty()) {
            blackCodecPrefix.add("OMX.PV.");
            blackCodecPrefix.add("OMX.google.");
            blackCodecPrefix.add("OMX.ARICENT.");
            blackCodecPrefix.add("OMX.SEC.WMV.Decoder");
            blackCodecPrefix.add("OMX.SEC.MP3.Decoder");
            blackCodecPrefix.add("OMX.MTK.VIDEO.DECODER.VC1");
            blackCodecPrefix.add("OMX.SEC.vp8.dec");
        }
        if (blackCodecSuffix.isEmpty()) {
            blackCodecSuffix.add(".sw.dec");
            blackCodecSuffix.add(".hevcswvdec");
        }
        java.lang.String name = mediaCodecInfo.getName();
        java.util.Iterator<java.lang.String> it = blackCodecPrefix.iterator();
        while (it.hasNext()) {
            if (name.startsWith(it.next())) {
                return true;
            }
        }
        java.util.Iterator<java.lang.String> it2 = blackCodecSuffix.iterator();
        while (it2.hasNext()) {
            if (name.endsWith(it2.next())) {
                return true;
            }
        }
        return false;
    }

    private int queueInputBufferInner(int i, byte[] bArr, long j, boolean z, boolean z2, java.lang.Object obj) {
        java.nio.ByteBuffer inputBuffer;
        if (this.mMediaCodec == null || (inputBuffer = getInputBuffer(i)) == null) {
            return -1;
        }
        inputBuffer.clear();
        if (bArr != null) {
            inputBuffer.put(bArr, 0, bArr.length);
            inputBuffer.flip();
        }
        int i2 = z ? 2 : 0;
        if (bArr == null) {
            i2 |= 4;
        }
        int i3 = i2;
        try {
            if (z2 && bArr != null) {
                android.media.MediaCodec.CryptoInfo createCryptoInfo = createCryptoInfo((com.cicada.player.utils.media.EncryptionInfo) obj);
                synchronized (queLock) {
                    this.mMediaCodec.queueSecureInputBuffer(i, 0, createCryptoInfo, j, i3);
                }
            } else if ((i3 & 4) == 4) {
                this.mMediaCodec.queueInputBuffer(i, 0, 0, 0L, i3);
            } else {
                this.mMediaCodec.queueInputBuffer(i, 0, inputBuffer.limit(), j, i3);
            }
            return 0;
        } catch (java.lang.Exception e) {
            com.cicada.player.utils.Logger.e(TAG, "queueInputBufferInner  fail " + e.getLocalizedMessage());
            return -1;
        }
    }

    @com.cicada.player.utils.NativeUsed
    public int configureAudio(java.lang.String str, int i, int i2, int i3) {
        java.lang.String str2 = TAG;
        com.cicada.player.utils.Logger.i(str2, "--> configureAudio start " + str + i + " , " + i2);
        this.mCodecCateGory = CODEC_CATEGORY_AUDIO;
        this.mMime = str;
        android.media.MediaFormat createAudioFormat = android.media.MediaFormat.createAudioFormat(str, i, i2);
        createAudioFormat.setInteger("is-adts", i3);
        java.lang.String findDecoderName = findDecoderName(createAudioFormat);
        if (android.text.TextUtils.isEmpty(findDecoderName)) {
            com.cicada.player.utils.Logger.e(str2, "not found codec : " + str);
            return -12;
        }
        try {
            this.mMediaCodec = android.media.MediaCodec.createByCodecName(findDecoderName);
        } catch (java.io.IOException unused) {
        }
        android.media.MediaCodec mediaCodec = this.mMediaCodec;
        if (mediaCodec == null) {
            com.cicada.player.utils.Logger.e(TAG, "createByCodecName fail : " + findDecoderName);
            return -13;
        }
        try {
            mediaCodec.configure(createAudioFormat, (android.view.Surface) null, this.mediaCrypto, 0);
            return 0;
        } catch (java.lang.Exception e) {
            com.cicada.player.utils.Logger.e(TAG, "configure fail : " + e.getMessage());
            return -14;
        }
    }

    @com.cicada.player.utils.NativeUsed
    public int configureVideo(java.lang.String str, int i, int i2, int i3, boolean z, java.lang.Object obj) {
        android.media.MediaCrypto mediaCrypto;
        android.view.Surface surface;
        com.cicada.player.utils.Logger.i(TAG, "--> configureVideo start " + str + ", " + i + ", " + i2 + ", " + i3 + ", " + z + ", " + obj);
        this.mCodecCateGory = CODEC_CATEGORY_VIDEO;
        this.mMime = str;
        int i4 = z ? 2 : 1;
        while (true) {
            int i5 = i4 - 1;
            if (i4 <= 0) {
                return 0;
            }
            android.media.MediaFormat createVideoFormat = android.media.MediaFormat.createVideoFormat(str, i, i2);
            if (i3 != 0) {
                createVideoFormat.setInteger("rotation-degrees", i3);
            }
            java.lang.String findDecoderName = findDecoderName(createVideoFormat);
            this.mDecoderName = findDecoderName;
            if (android.text.TextUtils.isEmpty(findDecoderName)) {
                com.cicada.player.utils.Logger.e(TAG, "not found video codec : " + str);
                return -12;
            }
            if (z) {
                if (findDecoderName.toLowerCase().startsWith("omx.hisi")) {
                    if (android.os.Build.VERSION.SDK_INT >= 29) {
                        createVideoFormat.setInteger("vendor.hisi-ext-low-latency-video-dec.video-scene-for-low-latency-req", 1);
                        createVideoFormat.setInteger("vendor.hisi-ext-low-latency-video-dec.video-scene-for-low-latency-rdy", -1);
                    }
                } else if (android.os.Build.VERSION.SDK_INT >= 30) {
                    createVideoFormat.setInteger("low-latency", 1);
                }
            }
            try {
                this.mMediaCodec = android.media.MediaCodec.createByCodecName(findDecoderName);
            } catch (java.io.IOException e) {
                com.cicada.player.utils.Logger.e(TAG, "MediaCodec.createByCodecName fail:" + e.getMessage());
            }
            android.media.MediaCodec mediaCodec = this.mMediaCodec;
            if (mediaCodec == null) {
                com.cicada.player.utils.Logger.e(TAG, "createByCodecName fail : " + findDecoderName);
                return -13;
            }
            try {
                if (obj instanceof android.view.Surface) {
                    surface = (android.view.Surface) obj;
                    mediaCrypto = this.mediaCrypto;
                } else {
                    mediaCrypto = this.mediaCrypto;
                    surface = null;
                }
                mediaCodec.configure(createVideoFormat, surface, mediaCrypto, 0);
                return 0;
            } catch (java.lang.Exception e2) {
                java.lang.String str2 = TAG;
                com.cicada.player.utils.Logger.e(str2, "configure fail : " + e2.getMessage());
                if (!z) {
                    return -14;
                }
                com.cicada.player.utils.Logger.e(str2, "try configure again with lowLatency=false");
                i4 = i5;
                z = false;
            }
        }
    }

    @com.cicada.player.utils.NativeUsed
    public int dequeueInputBufferIndex(long j) {
        java.nio.ByteBuffer inputBuffer;
        if (this.mMediaCodec == null) {
            return -1;
        }
        try {
            if (!this.mCodecSpecificDataMap.isEmpty()) {
                for (java.lang.String str : this.mCodecSpecificDataMap.keySet()) {
                    int dequeueInputBuffer = this.mMediaCodec.dequeueInputBuffer(j);
                    if (dequeueInputBuffer < 0 || (inputBuffer = getInputBuffer(dequeueInputBuffer)) == null) {
                        return -11;
                    }
                    byte[] bArr = this.mCodecSpecificDataMap.get(str);
                    if (bArr != null) {
                        java.nio.ByteBuffer allocate = java.nio.ByteBuffer.allocate(bArr.length);
                        allocate.put(bArr);
                        allocate.flip();
                        inputBuffer.put(allocate);
                        this.mMediaCodec.queueInputBuffer(dequeueInputBuffer, 0, allocate.limit(), 0L, 2);
                    }
                }
                this.mCodecSpecificDataMap.clear();
            }
            int dequeueInputBuffer2 = this.mMediaCodec.dequeueInputBuffer(j);
            if (dequeueInputBuffer2 >= 0) {
                return dequeueInputBuffer2;
            }
            return -11;
        } catch (java.lang.Exception e) {
            com.cicada.player.utils.Logger.e(TAG, "dequeueInputBufferIndex fail " + e.getMessage());
            return -1;
        }
    }

    @com.cicada.player.utils.NativeUsed
    public int dequeueOutputBufferIndex(long j) {
        android.media.MediaCodec mediaCodec = this.mMediaCodec;
        if (mediaCodec == null) {
            return -1;
        }
        try {
            int dequeueOutputBuffer = mediaCodec.dequeueOutputBuffer(this.mBufferInfo, j);
            if (dequeueOutputBuffer >= 0) {
                return dequeueOutputBuffer;
            }
            if (dequeueOutputBuffer == -1) {
                return -11;
            }
            if (dequeueOutputBuffer == -2 || dequeueOutputBuffer == -3) {
                return dequeueOutputBuffer;
            }
            return -1;
        } catch (java.lang.Exception e) {
            com.cicada.player.utils.Logger.e(TAG, "dequeueOutputBufferIndex fail " + e.getMessage());
            return -1;
        }
    }

    @com.cicada.player.utils.NativeUsed
    public int flush() {
        java.lang.String str = TAG;
        com.cicada.player.utils.Logger.i(str, "--> flush start");
        android.media.MediaCodec mediaCodec = this.mMediaCodec;
        if (mediaCodec == null) {
            com.cicada.player.utils.Logger.e(str, "mMediaCodec  null ");
            return -1;
        }
        try {
            mediaCodec.flush();
            return 0;
        } catch (java.lang.Exception e) {
            com.cicada.player.utils.Logger.e(TAG, "flush  fail " + e.getMessage());
            return 0;
        }
    }

    @com.cicada.player.utils.NativeUsed
    public java.lang.Object getDecoderName() {
        return this.mDecoderName;
    }

    @com.cicada.player.utils.NativeUsed
    public java.lang.Object getOutBuffer(int i) {
        if (i < 0) {
            return null;
        }
        try {
            return this.mMediaCodec.getOutputBuffer(i);
        } catch (java.lang.Exception e) {
            com.cicada.player.utils.Logger.e(TAG, "getOutBuffer fail " + e.getMessage());
            return null;
        }
    }

    @com.cicada.player.utils.NativeUsed
    public java.lang.Object getOutputBufferInfo(int i) {
        if (i == -2) {
            return fillFormatOutputBufferInfo();
        }
        if (i >= 0) {
            return fillDecodeBufferInfo(i);
        }
        return null;
    }

    @com.cicada.player.utils.NativeUsed
    public int queueInputBuffer(int i, byte[] bArr, long j, boolean z) {
        return queueInputBufferInner(i, bArr, j, z, false, null);
    }

    @com.cicada.player.utils.NativeUsed
    public int queueSecureInputBuffer(int i, byte[] bArr, java.lang.Object obj, long j, boolean z) {
        return queueInputBufferInner(i, bArr, j, z, true, obj);
    }

    @com.cicada.player.utils.NativeUsed
    public int release() {
        com.cicada.player.utils.Logger.i(TAG, "--> release ");
        android.media.MediaCodec mediaCodec = this.mMediaCodec;
        if (mediaCodec == null) {
            return -1;
        }
        mediaCodec.release();
        this.mMediaCodec = null;
        android.media.MediaCrypto mediaCrypto = this.mediaCrypto;
        if (mediaCrypto == null) {
            return 0;
        }
        mediaCrypto.release();
        return 0;
    }

    @com.cicada.player.utils.NativeUsed
    public int releaseOutputBuffer(int i, boolean z) {
        android.media.MediaCodec mediaCodec = this.mMediaCodec;
        if (mediaCodec == null) {
            return -1;
        }
        try {
            mediaCodec.releaseOutputBuffer(i, z);
            return 0;
        } catch (java.lang.Exception e) {
            com.cicada.player.utils.Logger.e(TAG, "releaseOutputBuffer fail index=" + i + " render=" + z + " " + e.getMessage());
            return -1;
        }
    }

    @com.cicada.player.utils.NativeUsed
    public void setCodecSpecificData(java.lang.Object obj) {
        com.cicada.player.utils.Logger.d(TAG, "--> setCodecSpecificData datas " + obj);
        this.mCodecSpecificDataMap.clear();
        if (obj == null) {
            return;
        }
        this.mCodecSpecificDataMap.putAll((java.util.LinkedHashMap) obj);
    }

    @com.cicada.player.utils.NativeUsed
    public boolean setDrmInfo(java.lang.String str, byte[] bArr) {
        com.cicada.player.utils.Logger.d(TAG, "--> setDrmInfo uuid " + str);
        try {
            this.mediaCrypto = new android.media.MediaCrypto(java.util.UUID.fromString(str), bArr);
            return true;
        } catch (java.lang.Exception e) {
            com.cicada.player.utils.Logger.e(TAG, "createMediaCrypto failed: " + e.getMessage());
            return false;
        }
    }

    @com.cicada.player.utils.NativeUsed
    public void setForceInsecureDecoder(boolean z) {
        com.cicada.player.utils.Logger.d(TAG, "--> setForceInsecureDecoder  " + z);
        this.forceInsecureDecoder = z;
    }

    @com.cicada.player.utils.NativeUsed
    public int start() {
        java.lang.String str = TAG;
        com.cicada.player.utils.Logger.i(str, "--> start ");
        android.media.MediaCodec mediaCodec = this.mMediaCodec;
        if (mediaCodec == null) {
            com.cicada.player.utils.Logger.e(str, "mMediaCodec  null ");
            return -1;
        }
        try {
            mediaCodec.start();
            this.started = true;
            this.mBufferInfo = new android.media.MediaCodec.BufferInfo();
            return 0;
        } catch (java.lang.Exception e) {
            com.cicada.player.utils.Logger.e(TAG, this.mMediaCodec.getName() + " start fail : " + e.getMessage());
            return -1;
        }
    }

    public int stop() {
        com.cicada.player.utils.Logger.i(TAG, "--> stop start");
        android.media.MediaCodec mediaCodec = this.mMediaCodec;
        if (mediaCodec == null) {
            return -1;
        }
        if (!this.started) {
            return 0;
        }
        try {
            mediaCodec.stop();
            return 0;
        } catch (java.lang.Exception e) {
            com.cicada.player.utils.Logger.e(TAG, "stop fail " + e.getMessage());
            return -1;
        }
    }
}
