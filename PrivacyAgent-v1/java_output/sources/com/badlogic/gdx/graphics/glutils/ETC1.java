package com.badlogic.gdx.graphics.glutils;

/* loaded from: classes12.dex */
public class ETC1 {
    public static int ETC1_RGB8_OES = 36196;
    public static int PKM_HEADER_SIZE = 16;

    public static final class ETC1Data implements com.badlogic.gdx.utils.Disposable {
        public final java.nio.ByteBuffer compressedData;
        public final int dataOffset;
        public final int height;
        public final int width;

        public ETC1Data(int i, int i2, java.nio.ByteBuffer byteBuffer, int i3) {
            this.width = i;
            this.height = i2;
            this.compressedData = byteBuffer;
            this.dataOffset = i3;
            a();
        }

        public ETC1Data(com.badlogic.gdx.files.FileHandle fileHandle) {
            java.io.DataInputStream dataInputStream;
            byte[] bArr = new byte[10240];
            java.io.DataInputStream dataInputStream2 = null;
            try {
                try {
                    dataInputStream = new java.io.DataInputStream(new java.io.BufferedInputStream(new java.util.zip.GZIPInputStream(fileHandle.read())));
                } catch (java.lang.Exception e) {
                    e = e;
                }
            } catch (java.lang.Throwable th) {
                th = th;
            }
            try {
                this.compressedData = com.badlogic.gdx.utils.BufferUtils.newUnsafeByteBuffer(dataInputStream.readInt());
                while (true) {
                    int read = dataInputStream.read(bArr);
                    if (read == -1) {
                        this.compressedData.position(0);
                        java.nio.ByteBuffer byteBuffer = this.compressedData;
                        byteBuffer.limit(byteBuffer.capacity());
                        com.badlogic.gdx.utils.StreamUtils.closeQuietly(dataInputStream);
                        this.width = com.badlogic.gdx.graphics.glutils.ETC1.getWidthPKM(this.compressedData, 0);
                        this.height = com.badlogic.gdx.graphics.glutils.ETC1.getHeightPKM(this.compressedData, 0);
                        int i = com.badlogic.gdx.graphics.glutils.ETC1.PKM_HEADER_SIZE;
                        this.dataOffset = i;
                        this.compressedData.position(i);
                        a();
                        return;
                    }
                    this.compressedData.put(bArr, 0, read);
                }
            } catch (java.lang.Exception e2) {
                e = e2;
                dataInputStream2 = dataInputStream;
                throw new com.badlogic.gdx.utils.GdxRuntimeException("Couldn't load pkm file '" + fileHandle + "'", e);
            } catch (java.lang.Throwable th2) {
                th = th2;
                dataInputStream2 = dataInputStream;
                com.badlogic.gdx.utils.StreamUtils.closeQuietly(dataInputStream2);
                throw th;
            }
        }

        public final void a() {
            if (com.badlogic.gdx.math.MathUtils.isPowerOfTwo(this.width) && com.badlogic.gdx.math.MathUtils.isPowerOfTwo(this.height)) {
                return;
            }
            java.lang.System.out.println("ETC1Data warning: non-power-of-two ETC1 textures may crash the driver of PowerVR GPUs");
        }

        @Override // com.badlogic.gdx.utils.Disposable
        public void dispose() {
            com.badlogic.gdx.utils.BufferUtils.disposeUnsafeByteBuffer(this.compressedData);
        }

        public boolean hasPKMHeader() {
            return this.dataOffset == 16;
        }

        public java.lang.String toString() {
            if (!hasPKMHeader()) {
                return "raw [" + this.width + "x" + this.height + "], compressed: " + (this.compressedData.capacity() - com.badlogic.gdx.graphics.glutils.ETC1.PKM_HEADER_SIZE);
            }
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(com.badlogic.gdx.graphics.glutils.ETC1.isValidPKM(this.compressedData, 0) ? "valid" : "invalid");
            sb.append(" pkm [");
            sb.append(com.badlogic.gdx.graphics.glutils.ETC1.getWidthPKM(this.compressedData, 0));
            sb.append("x");
            sb.append(com.badlogic.gdx.graphics.glutils.ETC1.getHeightPKM(this.compressedData, 0));
            sb.append("], compressed: ");
            sb.append(this.compressedData.capacity() - com.badlogic.gdx.graphics.glutils.ETC1.PKM_HEADER_SIZE);
            return sb.toString();
        }

        public void write(com.badlogic.gdx.files.FileHandle fileHandle) {
            java.io.DataOutputStream dataOutputStream;
            byte[] bArr = new byte[10240];
            this.compressedData.position(0);
            java.nio.ByteBuffer byteBuffer = this.compressedData;
            byteBuffer.limit(byteBuffer.capacity());
            java.io.DataOutputStream dataOutputStream2 = null;
            try {
                try {
                    dataOutputStream = new java.io.DataOutputStream(new java.util.zip.GZIPOutputStream(fileHandle.write(false)));
                } catch (java.lang.Throwable th) {
                    th = th;
                }
            } catch (java.lang.Exception e) {
                e = e;
            }
            try {
                dataOutputStream.writeInt(this.compressedData.capacity());
                int i = 0;
                while (i != this.compressedData.capacity()) {
                    int min = java.lang.Math.min(this.compressedData.remaining(), 10240);
                    this.compressedData.get(bArr, 0, min);
                    dataOutputStream.write(bArr, 0, min);
                    i += min;
                }
                com.badlogic.gdx.utils.StreamUtils.closeQuietly(dataOutputStream);
                this.compressedData.position(this.dataOffset);
                java.nio.ByteBuffer byteBuffer2 = this.compressedData;
                byteBuffer2.limit(byteBuffer2.capacity());
            } catch (java.lang.Exception e2) {
                e = e2;
                throw new com.badlogic.gdx.utils.GdxRuntimeException("Couldn't write PKM file to '" + fileHandle + "'", e);
            } catch (java.lang.Throwable th2) {
                th = th2;
                dataOutputStream2 = dataOutputStream;
                com.badlogic.gdx.utils.StreamUtils.closeQuietly(dataOutputStream2);
                throw th;
            }
        }
    }

    public static int a(com.badlogic.gdx.graphics.Pixmap.Format format) {
        if (format == com.badlogic.gdx.graphics.Pixmap.Format.RGB565) {
            return 2;
        }
        if (format == com.badlogic.gdx.graphics.Pixmap.Format.RGB888) {
            return 3;
        }
        throw new com.badlogic.gdx.utils.GdxRuntimeException("Can only handle RGB565 or RGB888 images");
    }

    public static com.badlogic.gdx.graphics.Pixmap decodeImage(com.badlogic.gdx.graphics.glutils.ETC1.ETC1Data eTC1Data, com.badlogic.gdx.graphics.Pixmap.Format format) {
        int i;
        int i2;
        int i3;
        if (eTC1Data.hasPKMHeader()) {
            i = getWidthPKM(eTC1Data.compressedData, 0);
            i2 = getHeightPKM(eTC1Data.compressedData, 0);
            i3 = 16;
        } else {
            i = eTC1Data.width;
            i2 = eTC1Data.height;
            i3 = 0;
        }
        int a = a(format);
        com.badlogic.gdx.graphics.Pixmap pixmap = new com.badlogic.gdx.graphics.Pixmap(i, i2, format);
        decodeImage(eTC1Data.compressedData, i3, pixmap.getPixels(), 0, i, i2, a);
        return pixmap;
    }

    private static native void decodeImage(java.nio.ByteBuffer byteBuffer, int i, java.nio.ByteBuffer byteBuffer2, int i2, int i3, int i4, int i5);

    public static com.badlogic.gdx.graphics.glutils.ETC1.ETC1Data encodeImage(com.badlogic.gdx.graphics.Pixmap pixmap) {
        java.nio.ByteBuffer encodeImage = encodeImage(pixmap.getPixels(), 0, pixmap.getWidth(), pixmap.getHeight(), a(pixmap.getFormat()));
        com.badlogic.gdx.utils.BufferUtils.newUnsafeByteBuffer(encodeImage);
        return new com.badlogic.gdx.graphics.glutils.ETC1.ETC1Data(pixmap.getWidth(), pixmap.getHeight(), encodeImage, 0);
    }

    private static native java.nio.ByteBuffer encodeImage(java.nio.ByteBuffer byteBuffer, int i, int i2, int i3, int i4);

    public static com.badlogic.gdx.graphics.glutils.ETC1.ETC1Data encodeImagePKM(com.badlogic.gdx.graphics.Pixmap pixmap) {
        java.nio.ByteBuffer encodeImagePKM = encodeImagePKM(pixmap.getPixels(), 0, pixmap.getWidth(), pixmap.getHeight(), a(pixmap.getFormat()));
        com.badlogic.gdx.utils.BufferUtils.newUnsafeByteBuffer(encodeImagePKM);
        return new com.badlogic.gdx.graphics.glutils.ETC1.ETC1Data(pixmap.getWidth(), pixmap.getHeight(), encodeImagePKM, 16);
    }

    private static native java.nio.ByteBuffer encodeImagePKM(java.nio.ByteBuffer byteBuffer, int i, int i2, int i3, int i4);

    public static native void formatHeader(java.nio.ByteBuffer byteBuffer, int i, int i2, int i3);

    public static native int getCompressedDataSize(int i, int i2);

    public static native int getHeightPKM(java.nio.ByteBuffer byteBuffer, int i);

    public static native int getWidthPKM(java.nio.ByteBuffer byteBuffer, int i);

    public static native boolean isValidPKM(java.nio.ByteBuffer byteBuffer, int i);
}
