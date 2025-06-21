package com.bumptech.glide.load.model;

/* loaded from: classes.dex */
public class StreamEncoder implements com.bumptech.glide.load.Encoder<java.io.InputStream> {
    private static final java.lang.String TAG = "StreamEncoder";
    private final com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool byteArrayPool;

    public StreamEncoder(com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool arrayPool) {
        this.byteArrayPool = arrayPool;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v8 */
    @Override // com.bumptech.glide.load.Encoder
    public boolean encode(@androidx.annotation.NonNull java.io.InputStream inputStream, @androidx.annotation.NonNull java.io.File file, @androidx.annotation.NonNull com.bumptech.glide.load.Options options) {
        byte[] bArr = (byte[]) this.byteArrayPool.get(65536, byte[].class);
        boolean z = false;
        ?? r1 = 0;
        java.io.FileOutputStream fileOutputStream = null;
        try {
            try {
                java.io.FileOutputStream fileOutputStream2 = new java.io.FileOutputStream(file);
                while (true) {
                    try {
                        int read = inputStream.read(bArr);
                        r1 = -1;
                        if (read == -1) {
                            break;
                        }
                        fileOutputStream2.write(bArr, 0, read);
                    } catch (java.io.IOException unused) {
                        fileOutputStream = fileOutputStream2;
                        android.util.Log.isLoggable(TAG, 3);
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (java.io.IOException unused2) {
                            }
                        }
                        this.byteArrayPool.put(bArr);
                        r1 = fileOutputStream;
                        return z;
                    } catch (java.lang.Throwable th) {
                        th = th;
                        r1 = fileOutputStream2;
                        if (r1 != 0) {
                            try {
                                r1.close();
                            } catch (java.io.IOException unused3) {
                            }
                        }
                        this.byteArrayPool.put(bArr);
                        throw th;
                    }
                }
                fileOutputStream2.close();
                try {
                    fileOutputStream2.close();
                } catch (java.io.IOException unused4) {
                }
                this.byteArrayPool.put(bArr);
                z = true;
            } catch (java.lang.Throwable th2) {
                th = th2;
            }
        } catch (java.io.IOException unused5) {
        }
        return z;
    }
}
