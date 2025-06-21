package com.badlogic.gdx.assets.loaders;

/* loaded from: classes12.dex */
public abstract class AsynchronousAssetLoader<T, P extends com.badlogic.gdx.assets.AssetLoaderParameters<T>> extends com.badlogic.gdx.assets.loaders.AssetLoader<T, P> {
    public AsynchronousAssetLoader(com.badlogic.gdx.assets.loaders.FileHandleResolver fileHandleResolver) {
        super(fileHandleResolver);
    }

    public abstract void loadAsync(com.badlogic.gdx.assets.AssetManager assetManager, java.lang.String str, com.badlogic.gdx.files.FileHandle fileHandle, P p);

    public abstract T loadSync(com.badlogic.gdx.assets.AssetManager assetManager, java.lang.String str, com.badlogic.gdx.files.FileHandle fileHandle, P p);
}
