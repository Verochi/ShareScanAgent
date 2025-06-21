package com.aliyun.svideosdk.editor;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public abstract class EditorCallBack {
    public static final int RENDER_CALLBACK_CUSTOM = 1;
    public static final int RENDER_CALLBACK_NONE = 0;
    public static final int RENDER_CALLBACK_TEXTURE = 2;
    public int mNeedRenderCallback = 0;
    public boolean mNeedPacketCallback = false;

    public abstract int onCustomRender(int i, int i2, int i3);

    public abstract void onDataReady();

    public abstract void onEnd(int i);

    public abstract void onError(int i);

    public void onPacketSeek(long j, int i) {
    }

    public abstract void onPlayProgress(long j, long j2);

    public abstract int onTextureRender(int i, int i2, int i3);

    public void onWritePacket(java.nio.ByteBuffer byteBuffer, int i) {
    }
}
