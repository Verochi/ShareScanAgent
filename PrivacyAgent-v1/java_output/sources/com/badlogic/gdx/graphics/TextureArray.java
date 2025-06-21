package com.badlogic.gdx.graphics;

/* loaded from: classes12.dex */
public class TextureArray extends com.badlogic.gdx.graphics.GLTexture {
    public static final java.util.Map<com.badlogic.gdx.Application, com.badlogic.gdx.utils.Array<com.badlogic.gdx.graphics.TextureArray>> b = new java.util.HashMap();
    public com.badlogic.gdx.graphics.TextureArrayData a;

    public TextureArray(com.badlogic.gdx.graphics.TextureArrayData textureArrayData) {
        super(com.badlogic.gdx.graphics.GL30.GL_TEXTURE_2D_ARRAY, com.badlogic.gdx.Gdx.gl.glGenTexture());
        if (com.badlogic.gdx.Gdx.gl30 == null) {
            throw new com.badlogic.gdx.utils.GdxRuntimeException("TextureArray requires a device running with GLES 3.0 compatibilty");
        }
        c(textureArrayData);
        if (textureArrayData.isManaged()) {
            a(com.badlogic.gdx.Gdx.app, this);
        }
    }

    public TextureArray(boolean z, com.badlogic.gdx.graphics.Pixmap.Format format, com.badlogic.gdx.files.FileHandle... fileHandleArr) {
        this(com.badlogic.gdx.graphics.TextureArrayData.Factory.loadFromFiles(format, z, fileHandleArr));
    }

    public TextureArray(boolean z, com.badlogic.gdx.files.FileHandle... fileHandleArr) {
        this(z, com.badlogic.gdx.graphics.Pixmap.Format.RGBA8888, fileHandleArr);
    }

    public TextureArray(com.badlogic.gdx.files.FileHandle... fileHandleArr) {
        this(false, fileHandleArr);
    }

    public TextureArray(java.lang.String... strArr) {
        this(b(strArr));
    }

    public static void a(com.badlogic.gdx.Application application, com.badlogic.gdx.graphics.TextureArray textureArray) {
        java.util.Map<com.badlogic.gdx.Application, com.badlogic.gdx.utils.Array<com.badlogic.gdx.graphics.TextureArray>> map = b;
        com.badlogic.gdx.utils.Array<com.badlogic.gdx.graphics.TextureArray> array = map.get(application);
        if (array == null) {
            array = new com.badlogic.gdx.utils.Array<>();
        }
        array.add(textureArray);
        map.put(application, array);
    }

    public static com.badlogic.gdx.files.FileHandle[] b(java.lang.String... strArr) {
        com.badlogic.gdx.files.FileHandle[] fileHandleArr = new com.badlogic.gdx.files.FileHandle[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            fileHandleArr[i] = com.badlogic.gdx.Gdx.files.internal(strArr[i]);
        }
        return fileHandleArr;
    }

    public static void clearAllTextureArrays(com.badlogic.gdx.Application application) {
        b.remove(application);
    }

    public static java.lang.String getManagedStatus() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("Managed TextureArrays/app: { ");
        java.util.Iterator<com.badlogic.gdx.Application> it = b.keySet().iterator();
        while (it.hasNext()) {
            sb.append(b.get(it.next()).size);
            sb.append(" ");
        }
        sb.append(com.alipay.sdk.m.u.i.d);
        return sb.toString();
    }

    public static int getNumManagedTextureArrays() {
        return b.get(com.badlogic.gdx.Gdx.app).size;
    }

    public static void invalidateAllTextureArrays(com.badlogic.gdx.Application application) {
        com.badlogic.gdx.utils.Array<com.badlogic.gdx.graphics.TextureArray> array = b.get(application);
        if (array == null) {
            return;
        }
        for (int i = 0; i < array.size; i++) {
            array.get(i).reload();
        }
    }

    public final void c(com.badlogic.gdx.graphics.TextureArrayData textureArrayData) {
        if (this.a != null && textureArrayData.isManaged() != this.a.isManaged()) {
            throw new com.badlogic.gdx.utils.GdxRuntimeException("New data must have the same managed status as the old data");
        }
        this.a = textureArrayData;
        bind();
        com.badlogic.gdx.Gdx.gl30.glTexImage3D(com.badlogic.gdx.graphics.GL30.GL_TEXTURE_2D_ARRAY, 0, textureArrayData.getInternalFormat(), textureArrayData.getWidth(), textureArrayData.getHeight(), textureArrayData.getDepth(), 0, textureArrayData.getInternalFormat(), textureArrayData.getGLType(), (java.nio.Buffer) null);
        if (!textureArrayData.isPrepared()) {
            textureArrayData.prepare();
        }
        textureArrayData.consumeTextureArrayData();
        setFilter(this.minFilter, this.magFilter);
        setWrap(this.uWrap, this.vWrap);
        com.badlogic.gdx.Gdx.gl.glBindTexture(this.glTarget, 0);
    }

    @Override // com.badlogic.gdx.graphics.GLTexture
    public int getDepth() {
        return this.a.getDepth();
    }

    @Override // com.badlogic.gdx.graphics.GLTexture
    public int getHeight() {
        return this.a.getHeight();
    }

    @Override // com.badlogic.gdx.graphics.GLTexture
    public int getWidth() {
        return this.a.getWidth();
    }

    @Override // com.badlogic.gdx.graphics.GLTexture
    public boolean isManaged() {
        return this.a.isManaged();
    }

    @Override // com.badlogic.gdx.graphics.GLTexture
    public void reload() {
        if (!isManaged()) {
            throw new com.badlogic.gdx.utils.GdxRuntimeException("Tried to reload an unmanaged TextureArray");
        }
        this.glHandle = com.badlogic.gdx.Gdx.gl.glGenTexture();
        c(this.a);
    }
}
