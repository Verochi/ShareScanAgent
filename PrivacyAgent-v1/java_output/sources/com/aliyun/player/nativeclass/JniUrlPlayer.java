package com.aliyun.player.nativeclass;

/* loaded from: classes.dex */
public class JniUrlPlayer extends com.aliyun.player.nativeclass.NativePlayerBase {
    private static final java.lang.String TAG = "JniUrlPlayer";
    private com.aliyun.player.source.BitStreamSource.ReadCallback mReadCallback;
    private com.aliyun.player.source.BitStreamSource.SeekCallback mSeekCallback;

    static {
        com.aliyun.utils.f.f();
    }

    public JniUrlPlayer(android.content.Context context) {
        super(context);
        this.mReadCallback = null;
        this.mSeekCallback = null;
    }

    public static void loadClass() {
    }

    private native void nEnableDowngrade(com.aliyun.player.source.UrlSource urlSource, com.aliyun.player.nativeclass.PlayerConfig playerConfig);

    @com.cicada.player.utils.NativeUsed
    private int nRead(byte[] bArr) {
        com.aliyun.player.source.BitStreamSource.ReadCallback readCallback = this.mReadCallback;
        if (readCallback != null) {
            return readCallback.read(bArr);
        }
        return -22;
    }

    @com.cicada.player.utils.NativeUsed
    private long nSeek(long j, int i) {
        com.aliyun.player.source.BitStreamSource.SeekCallback seekCallback = this.mSeekCallback;
        if (seekCallback != null) {
            return seekCallback.seek(j, i);
        }
        return -22L;
    }

    private native void nSetDataSource(com.aliyun.player.source.BitStreamSource bitStreamSource);

    private native void nSetDataSource(com.aliyun.player.source.UrlSource urlSource);

    public void enableDowngrade(com.aliyun.player.source.UrlSource urlSource, com.aliyun.player.nativeclass.PlayerConfig playerConfig) {
        if (com.aliyun.utils.f.b()) {
            nEnableDowngrade(urlSource, playerConfig);
        }
    }

    public void setDataSource(com.aliyun.player.source.BitStreamSource bitStreamSource) {
        if (com.aliyun.utils.f.b()) {
            this.mReadCallback = bitStreamSource.getReadCallback();
            this.mSeekCallback = bitStreamSource.getSeekCallback();
            nSetDataSource(bitStreamSource);
        }
    }

    public void setDataSource(com.aliyun.player.source.UrlSource urlSource) {
        if (com.aliyun.utils.f.b()) {
            nSetDataSource(urlSource);
        }
    }
}
