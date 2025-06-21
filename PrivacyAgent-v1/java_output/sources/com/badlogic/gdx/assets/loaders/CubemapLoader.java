package com.badlogic.gdx.assets.loaders;

/* loaded from: classes12.dex */
public class CubemapLoader extends com.badlogic.gdx.assets.loaders.AsynchronousAssetLoader<com.badlogic.gdx.graphics.Cubemap, com.badlogic.gdx.assets.loaders.CubemapLoader.CubemapParameter> {
    public com.badlogic.gdx.assets.loaders.CubemapLoader.CubemapLoaderInfo b;

    public static class CubemapLoaderInfo {
        public java.lang.String a;
        public com.badlogic.gdx.graphics.CubemapData b;
        public com.badlogic.gdx.graphics.Cubemap c;
    }

    public static class CubemapParameter extends com.badlogic.gdx.assets.AssetLoaderParameters<com.badlogic.gdx.graphics.Cubemap> {
        public com.badlogic.gdx.graphics.Texture.TextureFilter magFilter;
        public com.badlogic.gdx.graphics.Texture.TextureFilter minFilter;
        public com.badlogic.gdx.graphics.Texture.TextureWrap wrapU;
        public com.badlogic.gdx.graphics.Texture.TextureWrap wrapV;
        public com.badlogic.gdx.graphics.Pixmap.Format format = null;
        public com.badlogic.gdx.graphics.Cubemap cubemap = null;
        public com.badlogic.gdx.graphics.CubemapData cubemapData = null;

        public CubemapParameter() {
            com.badlogic.gdx.graphics.Texture.TextureFilter textureFilter = com.badlogic.gdx.graphics.Texture.TextureFilter.Nearest;
            this.minFilter = textureFilter;
            this.magFilter = textureFilter;
            com.badlogic.gdx.graphics.Texture.TextureWrap textureWrap = com.badlogic.gdx.graphics.Texture.TextureWrap.ClampToEdge;
            this.wrapU = textureWrap;
            this.wrapV = textureWrap;
        }
    }

    public CubemapLoader(com.badlogic.gdx.assets.loaders.FileHandleResolver fileHandleResolver) {
        super(fileHandleResolver);
        this.b = new com.badlogic.gdx.assets.loaders.CubemapLoader.CubemapLoaderInfo();
    }

    @Override // com.badlogic.gdx.assets.loaders.AssetLoader
    public com.badlogic.gdx.utils.Array<com.badlogic.gdx.assets.AssetDescriptor> getDependencies(java.lang.String str, com.badlogic.gdx.files.FileHandle fileHandle, com.badlogic.gdx.assets.loaders.CubemapLoader.CubemapParameter cubemapParameter) {
        return null;
    }

    @Override // com.badlogic.gdx.assets.loaders.AsynchronousAssetLoader
    public void loadAsync(com.badlogic.gdx.assets.AssetManager assetManager, java.lang.String str, com.badlogic.gdx.files.FileHandle fileHandle, com.badlogic.gdx.assets.loaders.CubemapLoader.CubemapParameter cubemapParameter) {
        com.badlogic.gdx.graphics.CubemapData cubemapData;
        com.badlogic.gdx.assets.loaders.CubemapLoader.CubemapLoaderInfo cubemapLoaderInfo = this.b;
        cubemapLoaderInfo.a = str;
        if (cubemapParameter == null || (cubemapData = cubemapParameter.cubemapData) == null) {
            cubemapLoaderInfo.c = null;
            if (cubemapParameter != null) {
                cubemapLoaderInfo.c = cubemapParameter.cubemap;
            }
            if (str.contains(".ktx") || str.contains(".zktx")) {
                this.b.b = new com.badlogic.gdx.graphics.glutils.KTXTextureData(fileHandle, false);
            }
        } else {
            cubemapLoaderInfo.b = cubemapData;
            cubemapLoaderInfo.c = cubemapParameter.cubemap;
        }
        if (this.b.b.isPrepared()) {
            return;
        }
        this.b.b.prepare();
    }

    @Override // com.badlogic.gdx.assets.loaders.AsynchronousAssetLoader
    public com.badlogic.gdx.graphics.Cubemap loadSync(com.badlogic.gdx.assets.AssetManager assetManager, java.lang.String str, com.badlogic.gdx.files.FileHandle fileHandle, com.badlogic.gdx.assets.loaders.CubemapLoader.CubemapParameter cubemapParameter) {
        com.badlogic.gdx.assets.loaders.CubemapLoader.CubemapLoaderInfo cubemapLoaderInfo = this.b;
        if (cubemapLoaderInfo == null) {
            return null;
        }
        com.badlogic.gdx.graphics.Cubemap cubemap = cubemapLoaderInfo.c;
        if (cubemap != null) {
            cubemap.load(cubemapLoaderInfo.b);
        } else {
            cubemap = new com.badlogic.gdx.graphics.Cubemap(this.b.b);
        }
        if (cubemapParameter != null) {
            cubemap.setFilter(cubemapParameter.minFilter, cubemapParameter.magFilter);
            cubemap.setWrap(cubemapParameter.wrapU, cubemapParameter.wrapV);
        }
        return cubemap;
    }
}
