package com.badlogic.gdx.assets;

/* loaded from: classes12.dex */
public class AssetLoaderParameters<T> {
    public com.badlogic.gdx.assets.AssetLoaderParameters.LoadedCallback loadedCallback;

    public interface LoadedCallback {
        void finishedLoading(com.badlogic.gdx.assets.AssetManager assetManager, java.lang.String str, java.lang.Class cls);
    }
}
