package com.badlogic.gdx.graphics;

/* loaded from: classes12.dex */
public class Cubemap extends com.badlogic.gdx.graphics.GLTexture {
    public static com.badlogic.gdx.assets.AssetManager a;
    public static final java.util.Map<com.badlogic.gdx.Application, com.badlogic.gdx.utils.Array<com.badlogic.gdx.graphics.Cubemap>> b = new java.util.HashMap();
    protected com.badlogic.gdx.graphics.CubemapData data;

    /* renamed from: com.badlogic.gdx.graphics.Cubemap$1, reason: invalid class name */
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

    public enum CubemapSide {
        PositiveX(0, com.badlogic.gdx.graphics.GL20.GL_TEXTURE_CUBE_MAP_POSITIVE_X, 0.0f, -1.0f, 0.0f, 1.0f, 0.0f, 0.0f),
        NegativeX(1, com.badlogic.gdx.graphics.GL20.GL_TEXTURE_CUBE_MAP_NEGATIVE_X, 0.0f, -1.0f, 0.0f, -1.0f, 0.0f, 0.0f),
        PositiveY(2, com.badlogic.gdx.graphics.GL20.GL_TEXTURE_CUBE_MAP_POSITIVE_Y, 0.0f, 0.0f, 1.0f, 0.0f, 1.0f, 0.0f),
        NegativeY(3, com.badlogic.gdx.graphics.GL20.GL_TEXTURE_CUBE_MAP_NEGATIVE_Y, 0.0f, 0.0f, -1.0f, 0.0f, -1.0f, 0.0f),
        PositiveZ(4, com.badlogic.gdx.graphics.GL20.GL_TEXTURE_CUBE_MAP_POSITIVE_Z, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 1.0f),
        NegativeZ(5, com.badlogic.gdx.graphics.GL20.GL_TEXTURE_CUBE_MAP_NEGATIVE_Z, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, -1.0f);

        public final com.badlogic.gdx.math.Vector3 direction;
        public final int glEnum;
        public final int index;
        public final com.badlogic.gdx.math.Vector3 up;

        CubemapSide(int i, int i2, float f, float f2, float f3, float f4, float f5, float f6) {
            this.index = i;
            this.glEnum = i2;
            this.up = new com.badlogic.gdx.math.Vector3(f, f2, f3);
            this.direction = new com.badlogic.gdx.math.Vector3(f4, f5, f6);
        }

        public com.badlogic.gdx.math.Vector3 getDirection(com.badlogic.gdx.math.Vector3 vector3) {
            return vector3.set(this.direction);
        }

        public int getGLEnum() {
            return this.glEnum;
        }

        public com.badlogic.gdx.math.Vector3 getUp(com.badlogic.gdx.math.Vector3 vector3) {
            return vector3.set(this.up);
        }
    }

    public Cubemap(int i, int i2, int i3, com.badlogic.gdx.graphics.Pixmap.Format format) {
        this(new com.badlogic.gdx.graphics.glutils.PixmapTextureData(new com.badlogic.gdx.graphics.Pixmap(i3, i2, format), null, false, true), new com.badlogic.gdx.graphics.glutils.PixmapTextureData(new com.badlogic.gdx.graphics.Pixmap(i3, i2, format), null, false, true), new com.badlogic.gdx.graphics.glutils.PixmapTextureData(new com.badlogic.gdx.graphics.Pixmap(i, i3, format), null, false, true), new com.badlogic.gdx.graphics.glutils.PixmapTextureData(new com.badlogic.gdx.graphics.Pixmap(i, i3, format), null, false, true), new com.badlogic.gdx.graphics.glutils.PixmapTextureData(new com.badlogic.gdx.graphics.Pixmap(i, i2, format), null, false, true), new com.badlogic.gdx.graphics.glutils.PixmapTextureData(new com.badlogic.gdx.graphics.Pixmap(i, i2, format), null, false, true));
    }

    public Cubemap(com.badlogic.gdx.files.FileHandle fileHandle, com.badlogic.gdx.files.FileHandle fileHandle2, com.badlogic.gdx.files.FileHandle fileHandle3, com.badlogic.gdx.files.FileHandle fileHandle4, com.badlogic.gdx.files.FileHandle fileHandle5, com.badlogic.gdx.files.FileHandle fileHandle6) {
        this(fileHandle, fileHandle2, fileHandle3, fileHandle4, fileHandle5, fileHandle6, false);
    }

    public Cubemap(com.badlogic.gdx.files.FileHandle fileHandle, com.badlogic.gdx.files.FileHandle fileHandle2, com.badlogic.gdx.files.FileHandle fileHandle3, com.badlogic.gdx.files.FileHandle fileHandle4, com.badlogic.gdx.files.FileHandle fileHandle5, com.badlogic.gdx.files.FileHandle fileHandle6, boolean z) {
        this(com.badlogic.gdx.graphics.TextureData.Factory.loadFromFile(fileHandle, z), com.badlogic.gdx.graphics.TextureData.Factory.loadFromFile(fileHandle2, z), com.badlogic.gdx.graphics.TextureData.Factory.loadFromFile(fileHandle3, z), com.badlogic.gdx.graphics.TextureData.Factory.loadFromFile(fileHandle4, z), com.badlogic.gdx.graphics.TextureData.Factory.loadFromFile(fileHandle5, z), com.badlogic.gdx.graphics.TextureData.Factory.loadFromFile(fileHandle6, z));
    }

    public Cubemap(com.badlogic.gdx.graphics.CubemapData cubemapData) {
        super(com.badlogic.gdx.graphics.GL20.GL_TEXTURE_CUBE_MAP);
        this.data = cubemapData;
        load(cubemapData);
    }

    public Cubemap(com.badlogic.gdx.graphics.Pixmap pixmap, com.badlogic.gdx.graphics.Pixmap pixmap2, com.badlogic.gdx.graphics.Pixmap pixmap3, com.badlogic.gdx.graphics.Pixmap pixmap4, com.badlogic.gdx.graphics.Pixmap pixmap5, com.badlogic.gdx.graphics.Pixmap pixmap6) {
        this(pixmap, pixmap2, pixmap3, pixmap4, pixmap5, pixmap6, false);
    }

    public Cubemap(com.badlogic.gdx.graphics.Pixmap pixmap, com.badlogic.gdx.graphics.Pixmap pixmap2, com.badlogic.gdx.graphics.Pixmap pixmap3, com.badlogic.gdx.graphics.Pixmap pixmap4, com.badlogic.gdx.graphics.Pixmap pixmap5, com.badlogic.gdx.graphics.Pixmap pixmap6, boolean z) {
        this(pixmap == null ? null : new com.badlogic.gdx.graphics.glutils.PixmapTextureData(pixmap, null, z, false), pixmap2 == null ? null : new com.badlogic.gdx.graphics.glutils.PixmapTextureData(pixmap2, null, z, false), pixmap3 == null ? null : new com.badlogic.gdx.graphics.glutils.PixmapTextureData(pixmap3, null, z, false), pixmap4 == null ? null : new com.badlogic.gdx.graphics.glutils.PixmapTextureData(pixmap4, null, z, false), pixmap5 == null ? null : new com.badlogic.gdx.graphics.glutils.PixmapTextureData(pixmap5, null, z, false), pixmap6 == null ? null : new com.badlogic.gdx.graphics.glutils.PixmapTextureData(pixmap6, null, z, false));
    }

    public Cubemap(com.badlogic.gdx.graphics.TextureData textureData, com.badlogic.gdx.graphics.TextureData textureData2, com.badlogic.gdx.graphics.TextureData textureData3, com.badlogic.gdx.graphics.TextureData textureData4, com.badlogic.gdx.graphics.TextureData textureData5, com.badlogic.gdx.graphics.TextureData textureData6) {
        super(com.badlogic.gdx.graphics.GL20.GL_TEXTURE_CUBE_MAP);
        com.badlogic.gdx.graphics.Texture.TextureFilter textureFilter = com.badlogic.gdx.graphics.Texture.TextureFilter.Nearest;
        this.minFilter = textureFilter;
        this.magFilter = textureFilter;
        com.badlogic.gdx.graphics.Texture.TextureWrap textureWrap = com.badlogic.gdx.graphics.Texture.TextureWrap.ClampToEdge;
        this.uWrap = textureWrap;
        this.vWrap = textureWrap;
        com.badlogic.gdx.graphics.glutils.FacedCubemapData facedCubemapData = new com.badlogic.gdx.graphics.glutils.FacedCubemapData(textureData, textureData2, textureData3, textureData4, textureData5, textureData6);
        this.data = facedCubemapData;
        load(facedCubemapData);
    }

    public static void clearAllCubemaps(com.badlogic.gdx.Application application) {
        b.remove(application);
    }

    public static java.lang.String getManagedStatus() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("Managed cubemap/app: { ");
        java.util.Iterator<com.badlogic.gdx.Application> it = b.keySet().iterator();
        while (it.hasNext()) {
            sb.append(b.get(it.next()).size);
            sb.append(" ");
        }
        sb.append(com.alipay.sdk.m.u.i.d);
        return sb.toString();
    }

    public static int getNumManagedCubemaps() {
        return b.get(com.badlogic.gdx.Gdx.app).size;
    }

    public static void invalidateAllCubemaps(com.badlogic.gdx.Application application) {
        com.badlogic.gdx.utils.Array<com.badlogic.gdx.graphics.Cubemap> array = b.get(application);
        if (array == null) {
            return;
        }
        com.badlogic.gdx.assets.AssetManager assetManager = a;
        if (assetManager == null) {
            for (int i = 0; i < array.size; i++) {
                array.get(i).reload();
            }
            return;
        }
        assetManager.finishLoading();
        com.badlogic.gdx.utils.Array<? extends com.badlogic.gdx.graphics.Cubemap> array2 = new com.badlogic.gdx.utils.Array<>(array);
        java.util.Iterator<? extends com.badlogic.gdx.graphics.Cubemap> it = array2.iterator();
        while (it.hasNext()) {
            com.badlogic.gdx.graphics.Cubemap next = it.next();
            java.lang.String assetFileName = a.getAssetFileName(next);
            if (assetFileName == null) {
                next.reload();
            } else {
                int referenceCount = a.getReferenceCount(assetFileName);
                a.setReferenceCount(assetFileName, 0);
                next.glHandle = 0;
                com.badlogic.gdx.assets.loaders.CubemapLoader.CubemapParameter cubemapParameter = new com.badlogic.gdx.assets.loaders.CubemapLoader.CubemapParameter();
                cubemapParameter.cubemapData = next.getCubemapData();
                cubemapParameter.minFilter = next.getMinFilter();
                cubemapParameter.magFilter = next.getMagFilter();
                cubemapParameter.wrapU = next.getUWrap();
                cubemapParameter.wrapV = next.getVWrap();
                cubemapParameter.cubemap = next;
                cubemapParameter.loadedCallback = new com.badlogic.gdx.graphics.Cubemap.AnonymousClass1(referenceCount);
                a.unload(assetFileName);
                next.glHandle = com.badlogic.gdx.Gdx.gl.glGenTexture();
                a.load(assetFileName, com.badlogic.gdx.graphics.Cubemap.class, cubemapParameter);
            }
        }
        array.clear();
        array.addAll(array2);
    }

    public static void setAssetManager(com.badlogic.gdx.assets.AssetManager assetManager) {
        a = assetManager;
    }

    @Override // com.badlogic.gdx.graphics.GLTexture, com.badlogic.gdx.utils.Disposable
    public void dispose() {
        if (this.glHandle == 0) {
            return;
        }
        delete();
        if (this.data.isManaged()) {
            java.util.Map<com.badlogic.gdx.Application, com.badlogic.gdx.utils.Array<com.badlogic.gdx.graphics.Cubemap>> map = b;
            if (map.get(com.badlogic.gdx.Gdx.app) != null) {
                map.get(com.badlogic.gdx.Gdx.app).removeValue(this, true);
            }
        }
    }

    public com.badlogic.gdx.graphics.CubemapData getCubemapData() {
        return this.data;
    }

    @Override // com.badlogic.gdx.graphics.GLTexture
    public int getDepth() {
        return 0;
    }

    @Override // com.badlogic.gdx.graphics.GLTexture
    public int getHeight() {
        return this.data.getHeight();
    }

    @Override // com.badlogic.gdx.graphics.GLTexture
    public int getWidth() {
        return this.data.getWidth();
    }

    @Override // com.badlogic.gdx.graphics.GLTexture
    public boolean isManaged() {
        return this.data.isManaged();
    }

    public void load(com.badlogic.gdx.graphics.CubemapData cubemapData) {
        if (!cubemapData.isPrepared()) {
            cubemapData.prepare();
        }
        bind();
        unsafeSetFilter(this.minFilter, this.magFilter, true);
        unsafeSetWrap(this.uWrap, this.vWrap, true);
        cubemapData.consumeCubemapData();
        com.badlogic.gdx.Gdx.gl.glBindTexture(this.glTarget, 0);
    }

    @Override // com.badlogic.gdx.graphics.GLTexture
    public void reload() {
        if (!isManaged()) {
            throw new com.badlogic.gdx.utils.GdxRuntimeException("Tried to reload an unmanaged Cubemap");
        }
        this.glHandle = com.badlogic.gdx.Gdx.gl.glGenTexture();
        load(this.data);
    }
}
