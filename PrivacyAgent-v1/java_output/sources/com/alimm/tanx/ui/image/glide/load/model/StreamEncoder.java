package com.alimm.tanx.ui.image.glide.load.model;

/* loaded from: classes.dex */
public class StreamEncoder implements com.alimm.tanx.ui.image.glide.load.Encoder<java.io.InputStream> {
    private static final java.lang.String TAG = "StreamEncoder";

    @Override // com.alimm.tanx.ui.image.glide.load.Encoder
    public boolean encode(java.io.InputStream inputStream, java.io.OutputStream outputStream) {
        byte[] bytes = com.alimm.tanx.ui.image.glide.util.ByteArrayPool.get().getBytes();
        while (true) {
            try {
                try {
                    int read = inputStream.read(bytes);
                    if (read == -1) {
                        com.alimm.tanx.ui.image.glide.util.ByteArrayPool.get().releaseBytes(bytes);
                        return true;
                    }
                    outputStream.write(bytes, 0, read);
                } catch (java.io.IOException unused) {
                    android.util.Log.isLoggable(TAG, 3);
                    com.alimm.tanx.ui.image.glide.util.ByteArrayPool.get().releaseBytes(bytes);
                    return false;
                }
            } catch (java.lang.Throwable th) {
                com.alimm.tanx.ui.image.glide.util.ByteArrayPool.get().releaseBytes(bytes);
                throw th;
            }
        }
    }

    @Override // com.alimm.tanx.ui.image.glide.load.Encoder
    public java.lang.String getId() {
        return "";
    }
}
