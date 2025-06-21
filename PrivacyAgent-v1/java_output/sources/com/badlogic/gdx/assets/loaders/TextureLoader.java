package com.badlogic.gdx.assets.loaders;

/* loaded from: classes12.dex */
public class TextureLoader extends com.badlogic.gdx.assets.loaders.AsynchronousAssetLoader<com.badlogic.gdx.graphics.Texture, com.badlogic.gdx.assets.loaders.TextureLoader.TextureParameter> {
    public com.badlogic.gdx.assets.loaders.TextureLoader.TextureLoaderInfo b;

    public static class TextureLoaderInfo {
        public java.lang.String a;
        public com.badlogic.gdx.graphics.TextureData b;
        public com.badlogic.gdx.graphics.Texture c;
    }

    public static class TextureParameter extends com.badlogic.gdx.assets.AssetLoaderParameters<com.badlogic.gdx.graphics.Texture> {
        public com.badlogic.gdx.graphics.Texture.TextureFilter magFilter;
        public com.badlogic.gdx.graphics.Texture.TextureFilter minFilter;
        public com.badlogic.gdx.graphics.Texture.TextureWrap wrapU;
        public com.badlogic.gdx.graphics.Texture.TextureWrap wrapV;
        public com.badlogic.gdx.graphics.Pixmap.Format format = null;
        public boolean genMipMaps = false;
        public com.badlogic.gdx.graphics.Texture texture = null;
        public com.badlogic.gdx.graphics.TextureData textureData = null;

        public TextureParameter() {
            com.badlogic.gdx.graphics.Texture.TextureFilter textureFilter = com.badlogic.gdx.graphics.Texture.TextureFilter.Nearest;
            this.minFilter = textureFilter;
            this.magFilter = textureFilter;
            com.badlogic.gdx.graphics.Texture.TextureWrap textureWrap = com.badlogic.gdx.graphics.Texture.TextureWrap.ClampToEdge;
            this.wrapU = textureWrap;
            this.wrapV = textureWrap;
        }
    }

    public TextureLoader(com.badlogic.gdx.assets.loaders.FileHandleResolver fileHandleResolver) {
        super(fileHandleResolver);
        this.b = new com.badlogic.gdx.assets.loaders.TextureLoader.TextureLoaderInfo();
    }

    @Override // com.badlogic.gdx.assets.loaders.AssetLoader
    public com.badlogic.gdx.utils.Array<com.badlogic.gdx.assets.AssetDescriptor> getDependencies(java.lang.String str, com.badlogic.gdx.files.FileHandle fileHandle, com.badlogic.gdx.assets.loaders.TextureLoader.TextureParameter textureParameter) {
        return null;
    }

    @Override // com.badlogic.gdx.assets.loaders.AsynchronousAssetLoader
    public void loadAsync(com.badlogic.gdx.assets.AssetManager assetManager, java.lang.String str, com.badlogic.gdx.files.FileHandle fileHandle, com.badlogic.gdx.assets.loaders.TextureLoader.TextureParameter textureParameter) {
        boolean z;
        com.badlogic.gdx.graphics.TextureData textureData;
        com.badlogic.gdx.assets.loaders.TextureLoader.TextureLoaderInfo textureLoaderInfo = this.b;
        textureLoaderInfo.a = str;
        if (textureParameter == null || (textureData = textureParameter.textureData) == null) {
            com.badlogic.gdx.graphics.Pixmap.Format format = null;
            textureLoaderInfo.c = null;
            if (textureParameter != null) {
                format = textureParameter.format;
                z = textureParameter.genMipMaps;
                textureLoaderInfo.c = textureParameter.texture;
            } else {
                z = false;
            }
            textureLoaderInfo.b = com.badlogic.gdx.graphics.TextureData.Factory.loadFromFile(fileHandle, format, z);
        } else {
            textureLoaderInfo.b = textureData;
            textureLoaderInfo.c = textureParameter.texture;
        }
        if (this.b.b.isPrepared()) {
            return;
        }
        this.b.b.prepare();
    }

    @Override // com.badlogic.gdx.assets.loaders.AsynchronousAssetLoader
    public com.badlogic.gdx.graphics.Texture loadSync(com.badlogic.gdx.assets.AssetManager assetManager, java.lang.String str, com.badlogic.gdx.files.FileHandle fileHandle, com.badlogic.gdx.assets.loaders.TextureLoader.TextureParameter textureParameter) {
        com.badlogic.gdx.assets.loaders.TextureLoader.TextureLoaderInfo textureLoaderInfo = this.b;
        if (textureLoaderInfo == null) {
            return null;
        }
        com.badlogic.gdx.graphics.Texture texture = textureLoaderInfo.c;
        if (texture != null) {
            texture.load(textureLoaderInfo.b);
        } else {
            texture = new com.badlogic.gdx.graphics.Texture(this.b.b);
        }
        if (textureParameter != null) {
            texture.setFilter(textureParameter.minFilter, textureParameter.magFilter);
            texture.setWrap(textureParameter.wrapU, textureParameter.wrapV);
        }
        return texture;
    }
}
