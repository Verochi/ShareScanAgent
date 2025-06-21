package okhttp3.internal.cache2;

/* loaded from: classes23.dex */
final class FileOperator {
    public final java.nio.channels.FileChannel a;

    public FileOperator(java.nio.channels.FileChannel fileChannel) {
        this.a = fileChannel;
    }

    public void a(long j, okio.Buffer buffer, long j2) throws java.io.IOException {
        if (j2 < 0) {
            throw new java.lang.IndexOutOfBoundsException();
        }
        while (j2 > 0) {
            long transferTo = this.a.transferTo(j, j2, buffer);
            j += transferTo;
            j2 -= transferTo;
        }
    }

    public void b(long j, okio.Buffer buffer, long j2) throws java.io.IOException {
        if (j2 < 0 || j2 > buffer.size()) {
            throw new java.lang.IndexOutOfBoundsException();
        }
        long j3 = j;
        long j4 = j2;
        while (j4 > 0) {
            long transferFrom = this.a.transferFrom(buffer, j3, j4);
            j3 += transferFrom;
            j4 -= transferFrom;
        }
    }
}
