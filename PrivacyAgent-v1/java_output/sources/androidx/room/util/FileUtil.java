package androidx.room.util;

@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class FileUtil {
    private FileUtil() {
    }

    @android.annotation.SuppressLint({"LambdaLast"})
    public static void copy(@androidx.annotation.NonNull java.nio.channels.ReadableByteChannel readableByteChannel, @androidx.annotation.NonNull java.nio.channels.FileChannel fileChannel) throws java.io.IOException {
        try {
            if (android.os.Build.VERSION.SDK_INT <= 23) {
                java.io.InputStream newInputStream = java.nio.channels.Channels.newInputStream(readableByteChannel);
                java.io.OutputStream newOutputStream = java.nio.channels.Channels.newOutputStream(fileChannel);
                byte[] bArr = new byte[4096];
                while (true) {
                    int read = newInputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    } else {
                        newOutputStream.write(bArr, 0, read);
                    }
                }
            } else {
                fileChannel.transferFrom(readableByteChannel, 0L, Long.MAX_VALUE);
            }
            fileChannel.force(false);
        } finally {
            readableByteChannel.close();
            fileChannel.close();
        }
    }
}
