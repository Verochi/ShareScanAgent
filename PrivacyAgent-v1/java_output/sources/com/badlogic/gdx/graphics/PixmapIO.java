package com.badlogic.gdx.graphics;

/* loaded from: classes12.dex */
public class PixmapIO {

    public static class CIM {
        public static final byte[] a = new byte[com.uc.crashsdk.export.LogType.UNEXP_KNOWN_REASON];
        public static final byte[] b = new byte[com.uc.crashsdk.export.LogType.UNEXP_KNOWN_REASON];

        /* JADX WARN: Not initialized variable reg: 1, insn: 0x007e: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:26:0x007e */
        public static com.badlogic.gdx.graphics.Pixmap a(com.badlogic.gdx.files.FileHandle fileHandle) {
            java.lang.Exception e;
            java.io.Closeable closeable;
            java.io.Closeable closeable2 = null;
            try {
                try {
                    java.io.DataInputStream dataInputStream = new java.io.DataInputStream(new java.util.zip.InflaterInputStream(new java.io.BufferedInputStream(fileHandle.read())));
                    try {
                        com.badlogic.gdx.graphics.Pixmap pixmap = new com.badlogic.gdx.graphics.Pixmap(dataInputStream.readInt(), dataInputStream.readInt(), com.badlogic.gdx.graphics.Pixmap.Format.fromGdx2DPixmapFormat(dataInputStream.readInt()));
                        java.nio.ByteBuffer pixels = pixmap.getPixels();
                        pixels.position(0);
                        pixels.limit(pixels.capacity());
                        synchronized (b) {
                            while (true) {
                                byte[] bArr = b;
                                int read = dataInputStream.read(bArr);
                                if (read > 0) {
                                    pixels.put(bArr, 0, read);
                                }
                            }
                        }
                        pixels.position(0);
                        pixels.limit(pixels.capacity());
                        com.badlogic.gdx.utils.StreamUtils.closeQuietly(dataInputStream);
                        return pixmap;
                    } catch (java.lang.Exception e2) {
                        e = e2;
                        throw new com.badlogic.gdx.utils.GdxRuntimeException("Couldn't read Pixmap from file '" + fileHandle + "'", e);
                    }
                } catch (java.lang.Throwable th) {
                    th = th;
                    closeable2 = closeable;
                    com.badlogic.gdx.utils.StreamUtils.closeQuietly(closeable2);
                    throw th;
                }
            } catch (java.lang.Exception e3) {
                e = e3;
            } catch (java.lang.Throwable th2) {
                th = th2;
                com.badlogic.gdx.utils.StreamUtils.closeQuietly(closeable2);
                throw th;
            }
        }

        public static void b(com.badlogic.gdx.files.FileHandle fileHandle, com.badlogic.gdx.graphics.Pixmap pixmap) {
            java.io.DataOutputStream dataOutputStream;
            java.io.DataOutputStream dataOutputStream2 = null;
            try {
                try {
                    dataOutputStream = new java.io.DataOutputStream(new java.util.zip.DeflaterOutputStream(fileHandle.write(false)));
                } catch (java.lang.Throwable th) {
                    th = th;
                }
            } catch (java.lang.Exception e) {
                e = e;
            }
            try {
                dataOutputStream.writeInt(pixmap.getWidth());
                dataOutputStream.writeInt(pixmap.getHeight());
                dataOutputStream.writeInt(com.badlogic.gdx.graphics.Pixmap.Format.toGdx2DPixmapFormat(pixmap.getFormat()));
                java.nio.ByteBuffer pixels = pixmap.getPixels();
                pixels.position(0);
                pixels.limit(pixels.capacity());
                int capacity = pixels.capacity() % com.uc.crashsdk.export.LogType.UNEXP_KNOWN_REASON;
                int capacity2 = pixels.capacity() / com.uc.crashsdk.export.LogType.UNEXP_KNOWN_REASON;
                synchronized (a) {
                    for (int i = 0; i < capacity2; i++) {
                        byte[] bArr = a;
                        pixels.get(bArr);
                        dataOutputStream.write(bArr);
                    }
                    byte[] bArr2 = a;
                    pixels.get(bArr2, 0, capacity);
                    dataOutputStream.write(bArr2, 0, capacity);
                }
                pixels.position(0);
                pixels.limit(pixels.capacity());
                com.badlogic.gdx.utils.StreamUtils.closeQuietly(dataOutputStream);
            } catch (java.lang.Exception e2) {
                e = e2;
                throw new com.badlogic.gdx.utils.GdxRuntimeException("Couldn't write Pixmap to file '" + fileHandle + "'", e);
            } catch (java.lang.Throwable th2) {
                th = th2;
                dataOutputStream2 = dataOutputStream;
                com.badlogic.gdx.utils.StreamUtils.closeQuietly(dataOutputStream2);
                throw th;
            }
        }
    }

    public static class PNG implements com.badlogic.gdx.utils.Disposable {
        public static final byte[] h = {-119, 80, 78, 71, 13, 10, com.google.common.base.Ascii.SUB, 10};
        public final com.badlogic.gdx.graphics.PixmapIO.PNG.ChunkBuffer a;
        public final java.util.zip.Deflater b;
        public com.badlogic.gdx.utils.ByteArray c;
        public com.badlogic.gdx.utils.ByteArray d;
        public com.badlogic.gdx.utils.ByteArray e;
        public boolean f;
        public int g;

        public static class ChunkBuffer extends java.io.DataOutputStream {
            public final java.io.ByteArrayOutputStream n;
            public final java.util.zip.CRC32 t;

            public ChunkBuffer(int i) {
                this(new java.io.ByteArrayOutputStream(i), new java.util.zip.CRC32());
            }

            public ChunkBuffer(java.io.ByteArrayOutputStream byteArrayOutputStream, java.util.zip.CRC32 crc32) {
                super(new java.util.zip.CheckedOutputStream(byteArrayOutputStream, crc32));
                this.n = byteArrayOutputStream;
                this.t = crc32;
            }

            public void a(java.io.DataOutputStream dataOutputStream) throws java.io.IOException {
                flush();
                dataOutputStream.writeInt(this.n.size() - 4);
                this.n.writeTo(dataOutputStream);
                dataOutputStream.writeInt((int) this.t.getValue());
                this.n.reset();
                this.t.reset();
            }
        }

        public PNG() {
            this(16384);
        }

        public PNG(int i) {
            this.f = true;
            this.a = new com.badlogic.gdx.graphics.PixmapIO.PNG.ChunkBuffer(i);
            this.b = new java.util.zip.Deflater();
        }

        @Override // com.badlogic.gdx.utils.Disposable
        public void dispose() {
            this.b.end();
        }

        public void setCompression(int i) {
            this.b.setLevel(i);
        }

        public void setFlipY(boolean z) {
            this.f = z;
        }

        public void write(com.badlogic.gdx.files.FileHandle fileHandle, com.badlogic.gdx.graphics.Pixmap pixmap) throws java.io.IOException {
            java.io.OutputStream write = fileHandle.write(false);
            try {
                write(write, pixmap);
            } finally {
                com.badlogic.gdx.utils.StreamUtils.closeQuietly(write);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void write(java.io.OutputStream outputStream, com.badlogic.gdx.graphics.Pixmap pixmap) throws java.io.IOException {
            byte[] ensureCapacity;
            byte[] ensureCapacity2;
            byte[] ensureCapacity3;
            java.util.zip.DeflaterOutputStream deflaterOutputStream = new java.util.zip.DeflaterOutputStream(this.a, this.b);
            java.io.DataOutputStream dataOutputStream = new java.io.DataOutputStream(outputStream);
            dataOutputStream.write(h);
            this.a.writeInt(1229472850);
            this.a.writeInt(pixmap.getWidth());
            this.a.writeInt(pixmap.getHeight());
            this.a.writeByte(8);
            this.a.writeByte(6);
            int i = 0;
            this.a.writeByte(0);
            this.a.writeByte(0);
            this.a.writeByte(0);
            this.a.a(dataOutputStream);
            this.a.writeInt(1229209940);
            this.b.reset();
            int width = pixmap.getWidth() * 4;
            com.badlogic.gdx.utils.ByteArray byteArray = this.c;
            if (byteArray == null) {
                com.badlogic.gdx.utils.ByteArray byteArray2 = new com.badlogic.gdx.utils.ByteArray(width);
                this.c = byteArray2;
                ensureCapacity = byteArray2.items;
                com.badlogic.gdx.utils.ByteArray byteArray3 = new com.badlogic.gdx.utils.ByteArray(width);
                this.d = byteArray3;
                ensureCapacity2 = byteArray3.items;
                com.badlogic.gdx.utils.ByteArray byteArray4 = new com.badlogic.gdx.utils.ByteArray(width);
                this.e = byteArray4;
                ensureCapacity3 = byteArray4.items;
            } else {
                ensureCapacity = byteArray.ensureCapacity(width);
                ensureCapacity2 = this.d.ensureCapacity(width);
                ensureCapacity3 = this.e.ensureCapacity(width);
                int i2 = this.g;
                for (int i3 = 0; i3 < i2; i3++) {
                    ensureCapacity3[i3] = 0;
                }
            }
            this.g = width;
            java.nio.ByteBuffer pixels = pixmap.getPixels();
            int position = pixels.position();
            int i4 = 1;
            boolean z = pixmap.getFormat() == com.badlogic.gdx.graphics.Pixmap.Format.RGBA8888;
            int height = pixmap.getHeight();
            int i5 = 0;
            while (i5 < height) {
                int i6 = this.f ? (height - i5) - i4 : i5;
                if (z) {
                    pixels.position(i6 * width);
                    pixels.get(ensureCapacity2, i, width);
                } else {
                    int i7 = 0;
                    int i8 = 0;
                    while (i7 < pixmap.getWidth()) {
                        int pixel = pixmap.getPixel(i7, i6);
                        int i9 = i8 + 1;
                        ensureCapacity2[i8] = (byte) ((pixel >> 24) & 255);
                        int i10 = i9 + 1;
                        int i11 = i6;
                        ensureCapacity2[i9] = (byte) ((pixel >> 16) & 255);
                        int i12 = i10 + 1;
                        ensureCapacity2[i10] = (byte) ((pixel >> 8) & 255);
                        int i13 = i12 + 1;
                        ensureCapacity2[i12] = (byte) (pixel & 255);
                        i7++;
                        i6 = i11;
                        z = z;
                        i8 = i13;
                    }
                }
                boolean z2 = z;
                ensureCapacity[0] = (byte) (ensureCapacity2[0] - ensureCapacity3[0]);
                ensureCapacity[1] = (byte) (ensureCapacity2[1] - ensureCapacity3[1]);
                ensureCapacity[2] = (byte) (ensureCapacity2[2] - ensureCapacity3[2]);
                ensureCapacity[3] = (byte) (ensureCapacity2[3] - ensureCapacity3[3]);
                int i14 = 4;
                while (i14 < width) {
                    int i15 = i14 - 4;
                    boolean z3 = ensureCapacity2[i15] & 255;
                    boolean z4 = ensureCapacity3[i14] & 255;
                    boolean z5 = ensureCapacity3[i15] & 255;
                    int i16 = ((z3 ? 1 : 0) + (z4 ? 1 : 0)) - (z5 ? 1 : 0);
                    int i17 = i16 - (z3 ? 1 : 0);
                    if (i17 < 0) {
                        i17 = -i17;
                    }
                    byte[] bArr = ensureCapacity3;
                    int i18 = i16 - (z4 ? 1 : 0);
                    if (i18 < 0) {
                        i18 = -i18;
                    }
                    int i19 = i16 - (z5 ? 1 : 0);
                    if (i19 < 0) {
                        i19 = -i19;
                    }
                    ensureCapacity[i14] = (byte) (ensureCapacity2[i14] - ((i17 > i18 || i17 > i19) ? i18 <= i19 ? z4 ? 1 : 0 : z5 ? 1 : 0 : z3 ? 1 : 0));
                    i14++;
                    ensureCapacity3 = bArr;
                }
                byte[] bArr2 = ensureCapacity3;
                deflaterOutputStream.write(4);
                i = 0;
                deflaterOutputStream.write(ensureCapacity, 0, width);
                i5++;
                ensureCapacity3 = ensureCapacity2;
                z = z2;
                ensureCapacity2 = bArr2;
                i4 = 1;
            }
            pixels.position(position);
            deflaterOutputStream.finish();
            this.a.a(dataOutputStream);
            this.a.writeInt(1229278788);
            this.a.a(dataOutputStream);
            outputStream.flush();
        }
    }

    public static com.badlogic.gdx.graphics.Pixmap readCIM(com.badlogic.gdx.files.FileHandle fileHandle) {
        return com.badlogic.gdx.graphics.PixmapIO.CIM.a(fileHandle);
    }

    public static void writeCIM(com.badlogic.gdx.files.FileHandle fileHandle, com.badlogic.gdx.graphics.Pixmap pixmap) {
        com.badlogic.gdx.graphics.PixmapIO.CIM.b(fileHandle, pixmap);
    }

    public static void writePNG(com.badlogic.gdx.files.FileHandle fileHandle, com.badlogic.gdx.graphics.Pixmap pixmap) {
        try {
            com.badlogic.gdx.graphics.PixmapIO.PNG png = new com.badlogic.gdx.graphics.PixmapIO.PNG((int) (pixmap.getWidth() * pixmap.getHeight() * 1.5f));
            try {
                png.setFlipY(false);
                png.write(fileHandle, pixmap);
            } finally {
                png.dispose();
            }
        } catch (java.io.IOException e) {
            throw new com.badlogic.gdx.utils.GdxRuntimeException("Error writing PNG: " + fileHandle, e);
        }
    }
}
