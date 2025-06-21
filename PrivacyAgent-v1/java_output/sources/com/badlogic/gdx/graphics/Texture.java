package com.badlogic.gdx.graphics;

/* loaded from: classes12.dex */
public class Texture extends com.badlogic.gdx.graphics.GLTexture {
    public static com.badlogic.gdx.assets.AssetManager b;
    public static final java.util.Map<com.badlogic.gdx.Application, com.badlogic.gdx.utils.Array<com.badlogic.gdx.graphics.Texture>> c = new java.util.HashMap();
    public com.badlogic.gdx.graphics.TextureData a;

    /* renamed from: com.badlogic.gdx.graphics.Texture$1, reason: invalid class name */
    public class AnonymousClass1 implements com.badlogic.gdx.assets.AssetLoaderParameters.LoadedCallback {
        public final /* synthetic */ int a;

        public AnonymousClass1(int i) {
            this.a = i;
        }

        @Override // com.badlogic.gdx.assets.AssetLoaderParameters.LoadedCallback
        public void finishedLoading(com.badlogic.gdx.assets.AssetManager assetManager, java.lang.String str, java.lang.Class cls) {
            assetManager.setReferenceCount(str, this.a);
        }
    }

    public enum TextureFilter {
        Nearest(com.badlogic.gdx.graphics.GL20.GL_NEAREST),
        Linear(com.badlogic.gdx.graphics.GL20.GL_LINEAR),
        MipMap(com.badlogic.gdx.graphics.GL20.GL_LINEAR_MIPMAP_LINEAR),
        MipMapNearestNearest(com.badlogic.gdx.graphics.GL20.GL_NEAREST_MIPMAP_NEAREST),
        MipMapLinearNearest(com.badlogic.gdx.graphics.GL20.GL_LINEAR_MIPMAP_NEAREST),
        MipMapNearestLinear(com.badlogic.gdx.graphics.GL20.GL_NEAREST_MIPMAP_LINEAR),
        MipMapLinearLinear(com.badlogic.gdx.graphics.GL20.GL_LINEAR_MIPMAP_LINEAR);

        final int glEnum;

        TextureFilter(int i) {
            this.glEnum = i;
        }

        public int getGLEnum() {
            return this.glEnum;
        }

        public boolean isMipMap() {
            int i = this.glEnum;
            return (i == 9728 || i == 9729) ? false : true;
        }
    }

    public enum TextureWrap {
        MirroredRepeat(com.badlogic.gdx.graphics.GL20.GL_MIRRORED_REPEAT),
        ClampToEdge(com.badlogic.gdx.graphics.GL20.GL_CLAMP_TO_EDGE),
        Repeat(com.badlogic.gdx.graphics.GL20.GL_REPEAT);

        final int glEnum;

        TextureWrap(int i) {
            this.glEnum = i;
        }

        public int getGLEnum() {
            return this.glEnum;
        }
    }

    public Texture(int i, int i2, com.badlogic.gdx.graphics.Pixmap.Format format) {
        this(new com.badlogic.gdx.graphics.glutils.PixmapTextureData(new com.badlogic.gdx.graphics.Pixmap(i, i2, format), null, false, true));
    }

    public Texture(int i, int i2, com.badlogic.gdx.graphics.TextureData textureData) {
        super(i, i2);
        load(textureData);
        if (textureData.isManaged()) {
            a(com.badlogic.gdx.Gdx.app, this);
        }
    }

    public Texture(com.badlogic.gdx.files.FileHandle fileHandle) {
        this(fileHandle, (com.badlogic.gdx.graphics.Pixmap.Format) null, false);
    }

    public Texture(com.badlogic.gdx.files.FileHandle fileHandle, com.badlogic.gdx.graphics.Pixmap.Format format, boolean z) {
        this(com.badlogic.gdx.graphics.TextureData.Factory.loadFromFile(fileHandle, format, z));
    }

    public Texture(com.badlogic.gdx.files.FileHandle fileHandle, boolean z) {
        this(fileHandle, (com.badlogic.gdx.graphics.Pixmap.Format) null, z);
    }

    public Texture(com.badlogic.gdx.graphics.Pixmap pixmap) {
        this(new com.badlogic.gdx.graphics.glutils.PixmapTextureData(pixmap, null, false, false));
    }

    public Texture(com.badlogic.gdx.graphics.Pixmap pixmap, com.badlogic.gdx.graphics.Pixmap.Format format, boolean z) {
        this(new com.badlogic.gdx.graphics.glutils.PixmapTextureData(pixmap, format, z, false));
    }

    public Texture(com.badlogic.gdx.graphics.Pixmap pixmap, boolean z) {
        this(new com.badlogic.gdx.graphics.glutils.PixmapTextureData(pixmap, null, z, false));
    }

    public Texture(com.badlogic.gdx.graphics.TextureData textureData) {
        this(com.badlogic.gdx.graphics.GL20.GL_TEXTURE_2D, com.badlogic.gdx.Gdx.gl.glGenTexture(), textureData);
    }

    public Texture(java.lang.String str) {
        this(com.badlogic.gdx.Gdx.files.internal(str));
    }

    public static void a(com.badlogic.gdx.Application application, com.badlogic.gdx.graphics.Texture texture) {
        java.util.Map<com.badlogic.gdx.Application, com.badlogic.gdx.utils.Array<com.badlogic.gdx.graphics.Texture>> map = c;
        com.badlogic.gdx.utils.Array<com.badlogic.gdx.graphics.Texture> array = map.get(application);
        if (array == null) {
            array = new com.badlogic.gdx.utils.Array<>();
        }
        array.add(texture);
        map.put(application, array);
    }

    public static void clearAllTextures(com.badlogic.gdx.Application application) {
        c.remove(application);
    }

    public static java.lang.String getManagedStatus() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("Managed textures/app: { ");
        java.util.Iterator<com.badlogic.gdx.Application> it = c.keySet().iterator();
        while (it.hasNext()) {
            sb.append(c.get(it.next()).size);
            sb.append(" ");
        }
        sb.append(com.alipay.sdk.m.u.i.d);
        return sb.toString();
    }

    public static int getNumManagedTextures() {
        return c.get(com.badlogic.gdx.Gdx.app).size;
    }

    public static void invalidateAllTextures(com.badlogic.gdx.Application application) {
        com.badlogic.gdx.utils.Array<com.badlogic.gdx.graphics.Texture> array = c.get(application);
        if (array == null) {
            return;
        }
        com.badlogic.gdx.assets.AssetManager assetManager = b;
        if (assetManager == null) {
            for (int i = 0; i < array.size; i++) {
                array.get(i).reload();
            }
            return;
        }
        assetManager.finishLoading();
        com.badlogic.gdx.utils.Array<? extends com.badlogic.gdx.graphics.Texture> array2 = new com.badlogic.gdx.utils.Array<>(array);
        java.util.Iterator<? extends com.badlogic.gdx.graphics.Texture> it = array2.iterator();
        while (it.hasNext()) {
            com.badlogic.gdx.graphics.Texture next = it.next();
            java.lang.String assetFileName = b.getAssetFileName(next);
            if (assetFileName == null) {
                next.reload();
            } else {
                int referenceCount = b.getReferenceCount(assetFileName);
                b.setReferenceCount(assetFileName, 0);
                next.glHandle = 0;
                com.badlogic.gdx.assets.loaders.TextureLoader.TextureParameter textureParameter = new com.badlogic.gdx.assets.loaders.TextureLoader.TextureParameter();
                textureParameter.textureData = next.getTextureData();
                textureParameter.minFilter = next.getMinFilter();
                textureParameter.magFilter = next.getMagFilter();
                textureParameter.wrapU = next.getUWrap();
                textureParameter.wrapV = next.getVWrap();
                textureParameter.genMipMaps = next.a.useMipMaps();
                textureParameter.texture = next;
                textureParameter.loadedCallback = new com.badlogic.gdx.graphics.Texture.AnonymousClass1(referenceCount);
                b.unload(assetFileName);
                next.glHandle = com.badlogic.gdx.Gdx.gl.glGenTexture();
                b.load(assetFileName, com.badlogic.gdx.graphics.Texture.class, textureParameter);
            }
        }
        array.clear();
        array.addAll(array2);
    }

    public static void setAssetManager(com.badlogic.gdx.assets.AssetManager assetManager) {
        b = assetManager;
    }

    @Override // com.badlogic.gdx.graphics.GLTexture, com.badlogic.gdx.utils.Disposable
    public void dispose() {
        if (this.glHandle == 0) {
            return;
        }
        delete();
        if (this.a.isManaged()) {
            java.util.Map<com.badlogic.gdx.Application, com.badlogic.gdx.utils.Array<com.badlogic.gdx.graphics.Texture>> map = c;
            if (map.get(com.badlogic.gdx.Gdx.app) != null) {
                map.get(com.badlogic.gdx.Gdx.app).removeValue(this, true);
            }
        }
    }

    public void draw(com.badlogic.gdx.graphics.Pixmap pixmap, int i, int i2) {
        if (this.a.isManaged()) {
            throw new com.badlogic.gdx.utils.GdxRuntimeException("can't draw to a managed texture");
        }
        bind();
        com.badlogic.gdx.Gdx.gl.glTexSubImage2D(this.glTarget, 0, i, i2, pixmap.getWidth(), pixmap.getHeight(), pixmap.getGLFormat(), pixmap.getGLType(), pixmap.getPixels());
    }

    @Override // com.badlogic.gdx.graphics.GLTexture
    public int getDepth() {
        return 0;
    }

    @Override // com.badlogic.gdx.graphics.GLTexture
    public int getHeight() {
        return this.a.getHeight();
    }

    public com.badlogic.gdx.graphics.TextureData getTextureData() {
        return this.a;
    }

    @Override // com.badlogic.gdx.graphics.GLTexture
    public int getWidth() {
        return this.a.getWidth();
    }

    @Override // com.badlogic.gdx.graphics.GLTexture
    public boolean isManaged() {
        return this.a.isManaged();
    }

    public void load(com.badlogic.gdx.graphics.TextureData textureData) {
        if (this.a != null && textureData.isManaged() != this.a.isManaged()) {
            throw new com.badlogic.gdx.utils.GdxRuntimeException("New data must have the same managed status as the old data");
        }
        this.a = textureData;
        if (!textureData.isPrepared()) {
            textureData.prepare();
        }
        bind();
        com.badlogic.gdx.graphics.GLTexture.uploadImageData(com.badlogic.gdx.graphics.GL20.GL_TEXTURE_2D, textureData);
        setFilter(this.minFilter, this.magFilter);
        setWrap(this.uWrap, this.vWrap);
        com.badlogic.gdx.Gdx.gl.glBindTexture(this.glTarget, 0);
    }

    @Override // com.badlogic.gdx.graphics.GLTexture
    public void reload() {
        if (!isManaged()) {
            throw new com.badlogic.gdx.utils.GdxRuntimeException("Tried to reload unmanaged Texture");
        }
        this.glHandle = com.badlogic.gdx.Gdx.gl.glGenTexture();
        load(this.a);
    }
}
