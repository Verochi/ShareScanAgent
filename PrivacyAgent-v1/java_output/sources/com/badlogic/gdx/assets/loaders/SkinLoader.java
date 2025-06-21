package com.badlogic.gdx.assets.loaders;

/* loaded from: classes12.dex */
public class SkinLoader extends com.badlogic.gdx.assets.loaders.AsynchronousAssetLoader<com.badlogic.gdx.scenes.scene2d.ui.Skin, com.badlogic.gdx.assets.loaders.SkinLoader.SkinParameter> {

    public static class SkinParameter extends com.badlogic.gdx.assets.AssetLoaderParameters<com.badlogic.gdx.scenes.scene2d.ui.Skin> {
        public final com.badlogic.gdx.utils.ObjectMap<java.lang.String, java.lang.Object> resources;
        public final java.lang.String textureAtlasPath;

        public SkinParameter() {
            this(null, null);
        }

        public SkinParameter(com.badlogic.gdx.utils.ObjectMap<java.lang.String, java.lang.Object> objectMap) {
            this(null, objectMap);
        }

        public SkinParameter(java.lang.String str) {
            this(str, null);
        }

        public SkinParameter(java.lang.String str, com.badlogic.gdx.utils.ObjectMap<java.lang.String, java.lang.Object> objectMap) {
            this.textureAtlasPath = str;
            this.resources = objectMap;
        }
    }

    public SkinLoader(com.badlogic.gdx.assets.loaders.FileHandleResolver fileHandleResolver) {
        super(fileHandleResolver);
    }

    @Override // com.badlogic.gdx.assets.loaders.AssetLoader
    public com.badlogic.gdx.utils.Array<com.badlogic.gdx.assets.AssetDescriptor> getDependencies(java.lang.String str, com.badlogic.gdx.files.FileHandle fileHandle, com.badlogic.gdx.assets.loaders.SkinLoader.SkinParameter skinParameter) {
        java.lang.String str2;
        com.badlogic.gdx.utils.Array<com.badlogic.gdx.assets.AssetDescriptor> array = new com.badlogic.gdx.utils.Array<>();
        if (skinParameter == null || (str2 = skinParameter.textureAtlasPath) == null) {
            array.add(new com.badlogic.gdx.assets.AssetDescriptor(fileHandle.pathWithoutExtension() + ".atlas", com.badlogic.gdx.graphics.g2d.TextureAtlas.class));
        } else if (str2 != null) {
            array.add(new com.badlogic.gdx.assets.AssetDescriptor(str2, com.badlogic.gdx.graphics.g2d.TextureAtlas.class));
        }
        return array;
    }

    @Override // com.badlogic.gdx.assets.loaders.AsynchronousAssetLoader
    public void loadAsync(com.badlogic.gdx.assets.AssetManager assetManager, java.lang.String str, com.badlogic.gdx.files.FileHandle fileHandle, com.badlogic.gdx.assets.loaders.SkinLoader.SkinParameter skinParameter) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.badlogic.gdx.assets.loaders.AsynchronousAssetLoader
    public com.badlogic.gdx.scenes.scene2d.ui.Skin loadSync(com.badlogic.gdx.assets.AssetManager assetManager, java.lang.String str, com.badlogic.gdx.files.FileHandle fileHandle, com.badlogic.gdx.assets.loaders.SkinLoader.SkinParameter skinParameter) {
        java.lang.String str2 = fileHandle.pathWithoutExtension() + ".atlas";
        com.badlogic.gdx.utils.ObjectMap<java.lang.String, java.lang.Object> objectMap = null;
        if (skinParameter != null) {
            java.lang.String str3 = skinParameter.textureAtlasPath;
            if (str3 != null) {
                str2 = str3;
            }
            com.badlogic.gdx.utils.ObjectMap<java.lang.String, java.lang.Object> objectMap2 = skinParameter.resources;
            if (objectMap2 != null) {
                objectMap = objectMap2;
            }
        }
        com.badlogic.gdx.scenes.scene2d.ui.Skin skin = new com.badlogic.gdx.scenes.scene2d.ui.Skin((com.badlogic.gdx.graphics.g2d.TextureAtlas) assetManager.get(str2, com.badlogic.gdx.graphics.g2d.TextureAtlas.class));
        if (objectMap != null) {
            com.badlogic.gdx.utils.ObjectMap.Entries<java.lang.String, java.lang.Object> it = objectMap.entries().iterator();
            while (it.hasNext()) {
                com.badlogic.gdx.utils.ObjectMap.Entry next = it.next();
                skin.add((java.lang.String) next.key, next.value);
            }
        }
        skin.load(fileHandle);
        return skin;
    }
}
