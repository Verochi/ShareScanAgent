package com.alivc.component.encoder;

@com.alivc.component.encoder.NativeUsed
/* loaded from: classes.dex */
public class MediaCodecData {
    public static final int DATA_KEY_FRAME = 3;
    public static final int DATA_NORMAL_FRAME = 2;
    public static final int DATA_TYPE_SPECIFIC = 1;
    public static final int ERROR_CODE_OK = 0;
    public static final int ERROR_CODE_TRY_AGAIN = 1;
    public static final int ERROR_UNKNOWN = -1;
    private boolean isEos;
    private int mCode;
    private java.nio.ByteBuffer mCodecData;
    private int mDataType;
    private long mDts;
    private android.media.MediaCodec mMediaCodec;
    private int mOutputBufferId;
    private long mPts;

    @com.alivc.component.encoder.NativeUsed
    public int getCode() {
        return this.mCode;
    }

    @com.alivc.component.encoder.NativeUsed
    public java.nio.ByteBuffer getCodecData() {
        return this.mCodecData;
    }

    @com.alivc.component.encoder.NativeUsed
    public int getDataType() {
        return this.mDataType;
    }

    @com.alivc.component.encoder.NativeUsed
    public long getDts() {
        return this.mDts;
    }

    public int getPosition() {
        java.nio.ByteBuffer byteBuffer = this.mCodecData;
        if (byteBuffer == null) {
            return 0;
        }
        return byteBuffer.limit();
    }

    @com.alivc.component.encoder.NativeUsed
    public long getPts() {
        return this.mPts;
    }

    @com.alivc.component.encoder.NativeUsed
    public boolean isEOS() {
        return this.isEos;
    }

    @com.alivc.component.encoder.NativeUsed
    public void release() {
        int i;
        try {
            android.media.MediaCodec mediaCodec = this.mMediaCodec;
            if (mediaCodec != null && (i = this.mOutputBufferId) > 0) {
                mediaCodec.releaseOutputBuffer(i, false);
                this.mMediaCodec = null;
                this.mOutputBufferId = 0;
            }
        } catch (java.lang.Exception e) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("releaseOutputBuffer error");
            sb.append(e.getMessage());
            e.printStackTrace();
        }
        this.mCodecData = null;
    }

    public void setCode(int i) {
        this.mCode = i;
    }

    public void setCodecData(java.nio.ByteBuffer byteBuffer, android.media.MediaCodec mediaCodec, int i) {
        this.mCodecData = byteBuffer;
        this.mMediaCodec = mediaCodec;
        this.mOutputBufferId = i;
    }

    public void setDataType(int i) {
        this.mDataType = i;
    }

    public void setDts(long j) {
        this.mDts = j;
    }

    public void setEos(boolean z) {
        this.isEos = z;
    }

    public void setPts(long j) {
        this.mPts = j;
    }

    public java.lang.String toString() {
        return "MediaCodecData{mDataType=" + this.mDataType + ", mCode=" + this.mCode + ", mPts=" + this.mPts + ", mDts=" + this.mDts + '}';
    }
}
