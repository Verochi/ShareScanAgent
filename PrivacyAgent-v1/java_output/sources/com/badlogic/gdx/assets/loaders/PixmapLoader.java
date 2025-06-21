package com.badlogic.gdx.assets.loaders;

/* loaded from: classes12.dex */
public class PixmapLoader extends com.badlogic.gdx.assets.loaders.AsynchronousAssetLoader<com.badlogic.gdx.graphics.Pixmap, com.badlogic.gdx.assets.loaders.PixmapLoader.PixmapParameter> {
    public com.badlogic.gdx.graphics.Pixmap b;

    public static class PixmapParameter extends com.badlogic.gdx.assets.AssetLoaderParameters<com.badlogic.gdx.graphics.Pixmap> {
    }

    public PixmapLoader(com.badlogic.gdx.assets.loaders.FileHandleResolver fileHandleResolver) {
        super(fileHandleResolver);
    }

    @Override // com.badlogic.gdx.assets.loaders.AssetLoader
    public com.badlogic.gdx.utils.Array<com.badlogic.gdx.assets.AssetDescriptor> getDependencies(java.lang.String str, com.badlogic.gdx.files.FileHandle fileHandle, com.badlogic.gdx.assets.loaders.PixmapLoader.PixmapParameter pixmapParameter) {
        return null;
    }

    @Override // com.badlogic.gdx.assets.loaders.AsynchronousAssetLoader
    public void loadAsync(com.badlogic.gdx.assets.AssetManager assetManager, java.lang.String str, com.badlogic.gdx.files.FileHandle fileHandle, com.badlogic.gdx.assets.loaders.PixmapLoader.PixmapParameter pixmapParameter) {
        this.b = null;
        this.b = new com.badlogic.gdx.graphics.Pixmap(fileHandle);
    }

    @Override // com.badlogic.gdx.assets.loaders.AsynchronousAssetLoader
    public com.badlogic.gdx.graphics.Pixmap loadSync(com.badlogic.gdx.assets.AssetManager assetManager, java.lang.String str, com.badlogic.gdx.files.FileHandle fileHandle, com.badlogic.gdx.assets.loaders.PixmapLoader.PixmapParameter pixmapParameter) {
        com.badlogic.gdx.graphics.Pixmap pixmap = this.b;
        this.b = null;
        return pixmap;
    }
}
