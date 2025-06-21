package com.badlogic.gdx.assets.loaders;

/* loaded from: classes12.dex */
public abstract class SynchronousAssetLoader<T, P extends com.badlogic.gdx.assets.AssetLoaderParameters<T>> extends com.badlogic.gdx.assets.loaders.AssetLoader<T, P> {
    public SynchronousAssetLoader(com.badlogic.gdx.assets.loaders.FileHandleResolver fileHandleResolver) {
        super(fileHandleResolver);
    }

    public abstract T load(com.badlogic.gdx.assets.AssetManager assetManager, java.lang.String str, com.badlogic.gdx.files.FileHandle fileHandle, P p);
}
