package com.aliyun.player.source;

/* loaded from: classes.dex */
public class BitStreamSource extends com.aliyun.player.source.SourceBase {
    public static final int EINVAL = 22;
    public static final int EIO = 5;
    public static final int SEEK_CUR = 1;
    public static final int SEEK_END = 2;
    public static final int SEEK_SET = 0;
    public static final int SEEK_SIZE = 65536;
    private com.aliyun.player.source.BitStreamSource.ReadCallback mReadCallback = null;
    private com.aliyun.player.source.BitStreamSource.SeekCallback mSeekCallback = null;

    public interface ReadCallback {
        int read(byte[] bArr);
    }

    public interface SeekCallback {
        long seek(long j, int i);
    }

    public BitStreamSource() {
        this.mQuality = "AUTO";
        this.mForceQuality = true;
    }

    public com.aliyun.player.source.BitStreamSource.ReadCallback getReadCallback() {
        return this.mReadCallback;
    }

    public com.aliyun.player.source.BitStreamSource.SeekCallback getSeekCallback() {
        return this.mSeekCallback;
    }

    public void setReadCallback(com.aliyun.player.source.BitStreamSource.ReadCallback readCallback) {
        this.mReadCallback = readCallback;
    }

    public void setSeekCallback(com.aliyun.player.source.BitStreamSource.SeekCallback seekCallback) {
        this.mSeekCallback = seekCallback;
    }
}
