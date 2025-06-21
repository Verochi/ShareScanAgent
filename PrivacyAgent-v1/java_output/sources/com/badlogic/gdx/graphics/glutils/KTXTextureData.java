package com.badlogic.gdx.graphics.glutils;

/* loaded from: classes12.dex */
public class KTXTextureData implements com.badlogic.gdx.graphics.TextureData, com.badlogic.gdx.graphics.CubemapData {
    public com.badlogic.gdx.files.FileHandle a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g = -1;
    public int h = -1;
    public int i = -1;
    public int j;
    public int k;
    public int l;
    public int m;
    public java.nio.ByteBuffer n;
    public boolean o;

    public KTXTextureData(com.badlogic.gdx.files.FileHandle fileHandle, boolean z) {
        this.a = fileHandle;
        this.o = z;
    }

    @Override // com.badlogic.gdx.graphics.CubemapData
    public void consumeCubemapData() {
        consumeCustomData(com.badlogic.gdx.graphics.GL20.GL_TEXTURE_CUBE_MAP);
    }

    @Override // com.badlogic.gdx.graphics.TextureData
    public void consumeCustomData(int i) {
        boolean z;
        int i2;
        int i3;
        int i4;
        int i5;
        boolean z2;
        if (this.n == null) {
            throw new com.badlogic.gdx.utils.GdxRuntimeException("Call prepare() before calling consumeCompressedData()");
        }
        java.nio.IntBuffer newIntBuffer = com.badlogic.gdx.utils.BufferUtils.newIntBuffer(16);
        int i6 = this.b;
        int i7 = 1;
        if (i6 != 0 && this.d != 0) {
            z = false;
        } else {
            if (i6 + this.d != 0) {
                throw new com.badlogic.gdx.utils.GdxRuntimeException("either both or none of glType, glFormat must be zero");
            }
            z = true;
        }
        if (this.h > 0) {
            i2 = 2;
            i3 = com.badlogic.gdx.graphics.GL20.GL_TEXTURE_2D;
        } else {
            i2 = 1;
            i3 = 4660;
        }
        if (this.i > 0) {
            i2 = 3;
            i3 = 4660;
        }
        int i8 = this.k;
        if (i8 == 6) {
            if (i2 != 2) {
                throw new com.badlogic.gdx.utils.GdxRuntimeException("cube map needs 2D faces");
            }
            i3 = com.badlogic.gdx.graphics.GL20.GL_TEXTURE_CUBE_MAP;
        } else if (i8 != 1) {
            throw new com.badlogic.gdx.utils.GdxRuntimeException("numberOfFaces must be either 1 or 6");
        }
        if (this.j > 0) {
            if (i3 != 4660 && i3 != 3553) {
                throw new com.badlogic.gdx.utils.GdxRuntimeException("No API for 3D and cube arrays yet");
            }
            i2++;
            i3 = 4660;
        }
        if (i3 == 4660) {
            throw new com.badlogic.gdx.utils.GdxRuntimeException("Unsupported texture format (only 2D texture are supported in LibGdx for the time being)");
        }
        int i9 = com.badlogic.gdx.graphics.GL20.GL_TEXTURE_CUBE_MAP_POSITIVE_X;
        if (i8 != 6 || i == 34067) {
            if (i8 != 6 || i != 34067) {
                if (i != i3 && (34069 > i || i > 34074 || i != 3553)) {
                    throw new com.badlogic.gdx.utils.GdxRuntimeException("Invalid target requested : 0x" + java.lang.Integer.toHexString(i) + ", expecting : 0x" + java.lang.Integer.toHexString(i3));
                }
                i9 = i;
            }
            i4 = -1;
        } else {
            if (34069 > i || i > 34074) {
                throw new com.badlogic.gdx.utils.GdxRuntimeException("You must specify either GL_TEXTURE_CUBE_MAP to bind all 6 faces of the cube or the requested face GL_TEXTURE_CUBE_MAP_POSITIVE_X and followings.");
            }
            i4 = i - com.badlogic.gdx.graphics.GL20.GL_TEXTURE_CUBE_MAP_POSITIVE_X;
        }
        com.badlogic.gdx.Gdx.gl.glGetIntegerv(com.badlogic.gdx.graphics.GL20.GL_UNPACK_ALIGNMENT, newIntBuffer);
        int i10 = newIntBuffer.get(0);
        int i11 = 4;
        if (i10 != 4) {
            com.badlogic.gdx.Gdx.gl.glPixelStorei(com.badlogic.gdx.graphics.GL20.GL_UNPACK_ALIGNMENT, 4);
        }
        int i12 = this.e;
        int i13 = this.d;
        int i14 = this.m;
        int i15 = 0;
        while (i15 < this.l) {
            int max = java.lang.Math.max(i7, this.g >> i15);
            int max2 = java.lang.Math.max(i7, this.h >> i15);
            java.lang.Math.max(i7, this.i >> i15);
            this.n.position(i14);
            int i16 = this.n.getInt();
            int i17 = (i16 + 3) & (-4);
            i14 += i11;
            int i18 = 0;
            while (i18 < this.k) {
                this.n.position(i14);
                i14 += i17;
                if (i4 == -1 || i4 == i18) {
                    java.nio.ByteBuffer slice = this.n.slice();
                    slice.limit(i17);
                    i5 = i4;
                    if (i2 != 1 && i2 == 2) {
                        int i19 = this.j;
                        if (i19 > 0) {
                            max2 = i19;
                        }
                        if (!z) {
                            z2 = z;
                            com.badlogic.gdx.Gdx.gl.glTexImage2D(i9 + i18, i15, i12, max, max2, 0, i13, this.b, slice);
                        } else if (i12 == com.badlogic.gdx.graphics.glutils.ETC1.ETC1_RGB8_OES) {
                            z2 = z;
                            if (com.badlogic.gdx.Gdx.graphics.supportsExtension("GL_OES_compressed_ETC1_RGB8_texture")) {
                                com.badlogic.gdx.Gdx.gl.glCompressedTexImage2D(i9 + i18, i15, i12, max, max2, 0, i16, slice);
                            } else {
                                com.badlogic.gdx.graphics.Pixmap decodeImage = com.badlogic.gdx.graphics.glutils.ETC1.decodeImage(new com.badlogic.gdx.graphics.glutils.ETC1.ETC1Data(max, max2, slice, 0), com.badlogic.gdx.graphics.Pixmap.Format.RGB888);
                                com.badlogic.gdx.Gdx.gl.glTexImage2D(i9 + i18, i15, decodeImage.getGLInternalFormat(), decodeImage.getWidth(), decodeImage.getHeight(), 0, decodeImage.getGLFormat(), decodeImage.getGLType(), decodeImage.getPixels());
                                decodeImage.dispose();
                            }
                        } else {
                            z2 = z;
                            com.badlogic.gdx.Gdx.gl.glCompressedTexImage2D(i9 + i18, i15, i12, max, max2, 0, i16, slice);
                        }
                        i18++;
                        i4 = i5;
                        z = z2;
                    }
                } else {
                    i5 = i4;
                }
                z2 = z;
                i18++;
                i4 = i5;
                z = z2;
            }
            i15++;
            i4 = i4;
            z = z;
            i7 = 1;
            i11 = 4;
        }
        if (i10 != 4) {
            com.badlogic.gdx.Gdx.gl.glPixelStorei(com.badlogic.gdx.graphics.GL20.GL_UNPACK_ALIGNMENT, i10);
        }
        if (useMipMaps()) {
            com.badlogic.gdx.Gdx.gl.glGenerateMipmap(i9);
        }
        disposePreparedData();
    }

    @Override // com.badlogic.gdx.graphics.TextureData
    public com.badlogic.gdx.graphics.Pixmap consumePixmap() {
        throw new com.badlogic.gdx.utils.GdxRuntimeException("This TextureData implementation does not return a Pixmap");
    }

    @Override // com.badlogic.gdx.graphics.TextureData
    public boolean disposePixmap() {
        throw new com.badlogic.gdx.utils.GdxRuntimeException("This TextureData implementation does not return a Pixmap");
    }

    public void disposePreparedData() {
        java.nio.ByteBuffer byteBuffer = this.n;
        if (byteBuffer != null) {
            com.badlogic.gdx.utils.BufferUtils.disposeUnsafeByteBuffer(byteBuffer);
        }
        this.n = null;
    }

    public java.nio.ByteBuffer getData(int i, int i2) {
        int i3 = this.m;
        for (int i4 = 0; i4 < this.l; i4++) {
            int i5 = (this.n.getInt(i3) + 3) & (-4);
            i3 += 4;
            if (i4 == i) {
                for (int i6 = 0; i6 < this.k; i6++) {
                    if (i6 == i2) {
                        this.n.position(i3);
                        java.nio.ByteBuffer slice = this.n.slice();
                        slice.limit(i5);
                        return slice;
                    }
                    i3 += i5;
                }
            } else {
                i3 += i5 * this.k;
            }
        }
        return null;
    }

    @Override // com.badlogic.gdx.graphics.TextureData
    public com.badlogic.gdx.graphics.Pixmap.Format getFormat() {
        throw new com.badlogic.gdx.utils.GdxRuntimeException("This TextureData implementation directly handles texture formats.");
    }

    public int getGlInternalFormat() {
        return this.e;
    }

    @Override // com.badlogic.gdx.graphics.TextureData
    public int getHeight() {
        return this.h;
    }

    public int getNumberOfFaces() {
        return this.k;
    }

    public int getNumberOfMipMapLevels() {
        return this.l;
    }

    @Override // com.badlogic.gdx.graphics.TextureData
    public com.badlogic.gdx.graphics.TextureData.TextureDataType getType() {
        return com.badlogic.gdx.graphics.TextureData.TextureDataType.Custom;
    }

    @Override // com.badlogic.gdx.graphics.TextureData
    public int getWidth() {
        return this.g;
    }

    @Override // com.badlogic.gdx.graphics.TextureData
    public boolean isManaged() {
        return true;
    }

    @Override // com.badlogic.gdx.graphics.TextureData
    public boolean isPrepared() {
        return this.n != null;
    }

    @Override // com.badlogic.gdx.graphics.TextureData
    public void prepare() {
        java.io.DataInputStream dataInputStream;
        if (this.n != null) {
            throw new com.badlogic.gdx.utils.GdxRuntimeException("Already prepared");
        }
        com.badlogic.gdx.files.FileHandle fileHandle = this.a;
        if (fileHandle == null) {
            throw new com.badlogic.gdx.utils.GdxRuntimeException("Need a file to load from");
        }
        if (fileHandle.name().endsWith(".zktx")) {
            byte[] bArr = new byte[10240];
            java.io.DataInputStream dataInputStream2 = null;
            try {
                try {
                    dataInputStream = new java.io.DataInputStream(new java.io.BufferedInputStream(new java.util.zip.GZIPInputStream(this.a.read())));
                } catch (java.lang.Exception e) {
                    e = e;
                }
            } catch (java.lang.Throwable th) {
                th = th;
            }
            try {
                this.n = com.badlogic.gdx.utils.BufferUtils.newUnsafeByteBuffer(dataInputStream.readInt());
                while (true) {
                    int read = dataInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    } else {
                        this.n.put(bArr, 0, read);
                    }
                }
                this.n.position(0);
                java.nio.ByteBuffer byteBuffer = this.n;
                byteBuffer.limit(byteBuffer.capacity());
                com.badlogic.gdx.utils.StreamUtils.closeQuietly(dataInputStream);
            } catch (java.lang.Exception e2) {
                e = e2;
                dataInputStream2 = dataInputStream;
                throw new com.badlogic.gdx.utils.GdxRuntimeException("Couldn't load zktx file '" + this.a + "'", e);
            } catch (java.lang.Throwable th2) {
                th = th2;
                dataInputStream2 = dataInputStream;
                com.badlogic.gdx.utils.StreamUtils.closeQuietly(dataInputStream2);
                throw th;
            }
        } else {
            this.n = java.nio.ByteBuffer.wrap(this.a.readBytes());
        }
        if (this.n.get() != -85) {
            throw new com.badlogic.gdx.utils.GdxRuntimeException("Invalid KTX Header");
        }
        if (this.n.get() != 75) {
            throw new com.badlogic.gdx.utils.GdxRuntimeException("Invalid KTX Header");
        }
        if (this.n.get() != 84) {
            throw new com.badlogic.gdx.utils.GdxRuntimeException("Invalid KTX Header");
        }
        if (this.n.get() != 88) {
            throw new com.badlogic.gdx.utils.GdxRuntimeException("Invalid KTX Header");
        }
        if (this.n.get() != 32) {
            throw new com.badlogic.gdx.utils.GdxRuntimeException("Invalid KTX Header");
        }
        if (this.n.get() != 49) {
            throw new com.badlogic.gdx.utils.GdxRuntimeException("Invalid KTX Header");
        }
        if (this.n.get() != 49) {
            throw new com.badlogic.gdx.utils.GdxRuntimeException("Invalid KTX Header");
        }
        if (this.n.get() != -69) {
            throw new com.badlogic.gdx.utils.GdxRuntimeException("Invalid KTX Header");
        }
        if (this.n.get() != 13) {
            throw new com.badlogic.gdx.utils.GdxRuntimeException("Invalid KTX Header");
        }
        if (this.n.get() != 10) {
            throw new com.badlogic.gdx.utils.GdxRuntimeException("Invalid KTX Header");
        }
        if (this.n.get() != 26) {
            throw new com.badlogic.gdx.utils.GdxRuntimeException("Invalid KTX Header");
        }
        if (this.n.get() != 10) {
            throw new com.badlogic.gdx.utils.GdxRuntimeException("Invalid KTX Header");
        }
        int i = this.n.getInt();
        if (i != 67305985 && i != 16909060) {
            throw new com.badlogic.gdx.utils.GdxRuntimeException("Invalid KTX Header");
        }
        if (i != 67305985) {
            java.nio.ByteBuffer byteBuffer2 = this.n;
            java.nio.ByteOrder order = byteBuffer2.order();
            java.nio.ByteOrder byteOrder = java.nio.ByteOrder.BIG_ENDIAN;
            if (order == byteOrder) {
                byteOrder = java.nio.ByteOrder.LITTLE_ENDIAN;
            }
            byteBuffer2.order(byteOrder);
        }
        this.b = this.n.getInt();
        this.c = this.n.getInt();
        this.d = this.n.getInt();
        this.e = this.n.getInt();
        this.f = this.n.getInt();
        this.g = this.n.getInt();
        this.h = this.n.getInt();
        this.i = this.n.getInt();
        this.j = this.n.getInt();
        this.k = this.n.getInt();
        int i2 = this.n.getInt();
        this.l = i2;
        if (i2 == 0) {
            this.l = 1;
            this.o = true;
        }
        this.m = this.n.position() + this.n.getInt();
        if (this.n.isDirect()) {
            return;
        }
        int i3 = this.m;
        for (int i4 = 0; i4 < this.l; i4++) {
            i3 += (((this.n.getInt(i3) + 3) & (-4)) * this.k) + 4;
        }
        this.n.limit(i3);
        this.n.position(0);
        java.nio.ByteBuffer newUnsafeByteBuffer = com.badlogic.gdx.utils.BufferUtils.newUnsafeByteBuffer(i3);
        newUnsafeByteBuffer.order(this.n.order());
        newUnsafeByteBuffer.put(this.n);
        this.n = newUnsafeByteBuffer;
    }

    @Override // com.badlogic.gdx.graphics.TextureData
    public boolean useMipMaps() {
        return this.o;
    }
}
