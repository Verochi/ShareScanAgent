package com.badlogic.gdx.assets.loaders.resolvers;

/* loaded from: classes12.dex */
public class ExternalFileHandleResolver implements com.badlogic.gdx.assets.loaders.FileHandleResolver {
    @Override // com.badlogic.gdx.assets.loaders.FileHandleResolver
    public com.badlogic.gdx.files.FileHandle resolve(java.lang.String str) {
        return com.badlogic.gdx.Gdx.files.external(str);
    }
}
