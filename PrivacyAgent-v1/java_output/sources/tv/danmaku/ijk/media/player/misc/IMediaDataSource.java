package tv.danmaku.ijk.media.player.misc;

/* loaded from: classes21.dex */
public interface IMediaDataSource {
    void close() throws java.io.IOException;

    long getSize() throws java.io.IOException;

    int readAt(long j, byte[] bArr, int i, int i2) throws java.io.IOException;
}
