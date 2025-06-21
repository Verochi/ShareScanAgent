package com.badlogic.gdx.assets.loaders;

/* loaded from: classes12.dex */
public class TextureAtlasLoader extends com.badlogic.gdx.assets.loaders.SynchronousAssetLoader<com.badlogic.gdx.graphics.g2d.TextureAtlas, com.badlogic.gdx.assets.loaders.TextureAtlasLoader.TextureAtlasParameter> {
    public com.badlogic.gdx.graphics.g2d.TextureAtlas.TextureAtlasData b;

    public static class TextureAtlasParameter extends com.badlogic.gdx.assets.AssetLoaderParameters<com.badlogic.gdx.graphics.g2d.TextureAtlas> {
        public boolean flip;

        public TextureAtlasParameter() {
            this.flip = false;
        }

        public TextureAtlasParameter(boolean z) {
            this.flip = z;
        }
    }

    public TextureAtlasLoader(com.badlogic.gdx.assets.loaders.FileHandleResolver fileHandleResolver) {
        super(fileHandleResolver);
    }

    @Override // com.badlogic.gdx.assets.loaders.AssetLoader
    public com.badlogic.gdx.utils.Array<com.badlogic.gdx.assets.AssetDescriptor> getDependencies(java.lang.String str, com.badlogic.gdx.files.FileHandle fileHandle, com.badlogic.gdx.assets.loaders.TextureAtlasLoader.TextureAtlasParameter textureAtlasParameter) {
        com.badlogic.gdx.files.FileHandle parent = fileHandle.parent();
        if (textureAtlasParameter != null) {
            this.b = new com.badlogic.gdx.graphics.g2d.TextureAtlas.TextureAtlasData(fileHandle, parent, textureAtlasParameter.flip);
        } else {
            this.b = new com.badlogic.gdx.graphics.g2d.TextureAtlas.TextureAtlasData(fileHandle, parent, false);
        }
        com.badlogic.gdx.utils.Array<com.badlogic.gdx.assets.AssetDescriptor> array = new com.badlogic.gdx.utils.Array<>();
        java.util.Iterator<com.badlogic.gdx.graphics.g2d.TextureAtlas.TextureAtlasData.Page> it = this.b.getPages().iterator();
        while (it.hasNext()) {
            com.badlogic.gdx.graphics.g2d.TextureAtlas.TextureAtlasData.Page next = it.next();
            com.badlogic.gdx.assets.loaders.TextureLoader.TextureParameter textureParameter = new com.badlogic.gdx.assets.loaders.TextureLoader.TextureParameter();
            textureParameter.format = next.format;
            textureParameter.genMipMaps = next.useMipMaps;
            textureParameter.minFilter = next.minFilter;
            textureParameter.magFilter = next.magFilter;
            array.add(new com.badlogic.gdx.assets.AssetDescriptor(next.textureFile, com.badlogic.gdx.graphics.Texture.class, textureParameter));
        }
        return array;
    }

    @Override // com.badlogic.gdx.assets.loaders.SynchronousAssetLoader
    public com.badlogic.gdx.graphics.g2d.TextureAtlas load(com.badlogic.gdx.assets.AssetManager assetManager, java.lang.String str, com.badlogic.gdx.files.FileHandle fileHandle, com.badlogic.gdx.assets.loaders.TextureAtlasLoader.TextureAtlasParameter textureAtlasParameter) {
        java.util.Iterator<com.badlogic.gdx.graphics.g2d.TextureAtlas.TextureAtlasData.Page> it = this.b.getPages().iterator();
        while (it.hasNext()) {
            com.badlogic.gdx.graphics.g2d.TextureAtlas.TextureAtlasData.Page next = it.next();
            next.texture = (com.badlogic.gdx.graphics.Texture) assetManager.get(next.textureFile.path().replaceAll("\\\\", net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR), com.badlogic.gdx.graphics.Texture.class);
        }
        return new com.badlogic.gdx.graphics.g2d.TextureAtlas(this.b);
    }
}
