package com.badlogic.gdx.assets.loaders;

/* loaded from: classes12.dex */
public abstract class AssetLoader<T, P extends com.badlogic.gdx.assets.AssetLoaderParameters<T>> {
    public com.badlogic.gdx.assets.loaders.FileHandleResolver a;

    public AssetLoader(com.badlogic.gdx.assets.loaders.FileHandleResolver fileHandleResolver) {
        this.a = fileHandleResolver;
    }

    public abstract com.badlogic.gdx.utils.Array<com.badlogic.gdx.assets.AssetDescriptor> getDependencies(java.lang.String str, com.badlogic.gdx.files.FileHandle fileHandle, P p);

    public com.badlogic.gdx.files.FileHandle resolve(java.lang.String str) {
        return this.a.resolve(str);
    }
}
