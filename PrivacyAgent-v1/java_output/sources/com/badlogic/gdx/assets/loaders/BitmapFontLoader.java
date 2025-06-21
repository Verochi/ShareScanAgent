package com.badlogic.gdx.assets.loaders;

/* loaded from: classes12.dex */
public class BitmapFontLoader extends com.badlogic.gdx.assets.loaders.AsynchronousAssetLoader<com.badlogic.gdx.graphics.g2d.BitmapFont, com.badlogic.gdx.assets.loaders.BitmapFontLoader.BitmapFontParameter> {
    public com.badlogic.gdx.graphics.g2d.BitmapFont.BitmapFontData b;

    public static class BitmapFontParameter extends com.badlogic.gdx.assets.AssetLoaderParameters<com.badlogic.gdx.graphics.g2d.BitmapFont> {
        public java.lang.String atlasName;
        public com.badlogic.gdx.graphics.g2d.BitmapFont.BitmapFontData bitmapFontData;
        public boolean flip = false;
        public boolean genMipMaps = false;
        public com.badlogic.gdx.graphics.Texture.TextureFilter magFilter;
        public com.badlogic.gdx.graphics.Texture.TextureFilter minFilter;

        public BitmapFontParameter() {
            com.badlogic.gdx.graphics.Texture.TextureFilter textureFilter = com.badlogic.gdx.graphics.Texture.TextureFilter.Nearest;
            this.minFilter = textureFilter;
            this.magFilter = textureFilter;
            this.bitmapFontData = null;
            this.atlasName = null;
        }
    }

    public BitmapFontLoader(com.badlogic.gdx.assets.loaders.FileHandleResolver fileHandleResolver) {
        super(fileHandleResolver);
    }

    @Override // com.badlogic.gdx.assets.loaders.AssetLoader
    public com.badlogic.gdx.utils.Array<com.badlogic.gdx.assets.AssetDescriptor> getDependencies(java.lang.String str, com.badlogic.gdx.files.FileHandle fileHandle, com.badlogic.gdx.assets.loaders.BitmapFontLoader.BitmapFontParameter bitmapFontParameter) {
        java.lang.String str2;
        com.badlogic.gdx.graphics.g2d.BitmapFont.BitmapFontData bitmapFontData;
        com.badlogic.gdx.utils.Array<com.badlogic.gdx.assets.AssetDescriptor> array = new com.badlogic.gdx.utils.Array<>();
        if (bitmapFontParameter != null && (bitmapFontData = bitmapFontParameter.bitmapFontData) != null) {
            this.b = bitmapFontData;
            return array;
        }
        this.b = new com.badlogic.gdx.graphics.g2d.BitmapFont.BitmapFontData(fileHandle, bitmapFontParameter != null ? bitmapFontParameter.flip : false);
        if (bitmapFontParameter == null || (str2 = bitmapFontParameter.atlasName) == null) {
            for (int i = 0; i < this.b.getImagePaths().length; i++) {
                com.badlogic.gdx.files.FileHandle resolve = resolve(this.b.getImagePath(i));
                com.badlogic.gdx.assets.loaders.TextureLoader.TextureParameter textureParameter = new com.badlogic.gdx.assets.loaders.TextureLoader.TextureParameter();
                if (bitmapFontParameter != null) {
                    textureParameter.genMipMaps = bitmapFontParameter.genMipMaps;
                    textureParameter.minFilter = bitmapFontParameter.minFilter;
                    textureParameter.magFilter = bitmapFontParameter.magFilter;
                }
                array.add(new com.badlogic.gdx.assets.AssetDescriptor(resolve, com.badlogic.gdx.graphics.Texture.class, textureParameter));
            }
        } else {
            array.add(new com.badlogic.gdx.assets.AssetDescriptor(str2, com.badlogic.gdx.graphics.g2d.TextureAtlas.class));
        }
        return array;
    }

    @Override // com.badlogic.gdx.assets.loaders.AsynchronousAssetLoader
    public void loadAsync(com.badlogic.gdx.assets.AssetManager assetManager, java.lang.String str, com.badlogic.gdx.files.FileHandle fileHandle, com.badlogic.gdx.assets.loaders.BitmapFontLoader.BitmapFontParameter bitmapFontParameter) {
    }

    @Override // com.badlogic.gdx.assets.loaders.AsynchronousAssetLoader
    public com.badlogic.gdx.graphics.g2d.BitmapFont loadSync(com.badlogic.gdx.assets.AssetManager assetManager, java.lang.String str, com.badlogic.gdx.files.FileHandle fileHandle, com.badlogic.gdx.assets.loaders.BitmapFontLoader.BitmapFontParameter bitmapFontParameter) {
        java.lang.String str2;
        if (bitmapFontParameter == null || (str2 = bitmapFontParameter.atlasName) == null) {
            int length = this.b.getImagePaths().length;
            com.badlogic.gdx.utils.Array array = new com.badlogic.gdx.utils.Array(length);
            for (int i = 0; i < length; i++) {
                array.add(new com.badlogic.gdx.graphics.g2d.TextureRegion((com.badlogic.gdx.graphics.Texture) assetManager.get(this.b.getImagePath(i), com.badlogic.gdx.graphics.Texture.class)));
            }
            return new com.badlogic.gdx.graphics.g2d.BitmapFont(this.b, (com.badlogic.gdx.utils.Array<com.badlogic.gdx.graphics.g2d.TextureRegion>) array, true);
        }
        com.badlogic.gdx.graphics.g2d.TextureAtlas textureAtlas = (com.badlogic.gdx.graphics.g2d.TextureAtlas) assetManager.get(str2, com.badlogic.gdx.graphics.g2d.TextureAtlas.class);
        java.lang.String str3 = fileHandle.sibling(this.b.imagePaths[0]).nameWithoutExtension().toString();
        com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion findRegion = textureAtlas.findRegion(str3);
        if (findRegion != null) {
            return new com.badlogic.gdx.graphics.g2d.BitmapFont(fileHandle, findRegion);
        }
        throw new com.badlogic.gdx.utils.GdxRuntimeException("Could not find font region " + str3 + " in atlas " + bitmapFontParameter.atlasName);
    }
}
