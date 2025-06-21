package com.badlogic.gdx.assets.loaders;

/* loaded from: classes12.dex */
public class ParticleEffectLoader extends com.badlogic.gdx.assets.loaders.SynchronousAssetLoader<com.badlogic.gdx.graphics.g2d.ParticleEffect, com.badlogic.gdx.assets.loaders.ParticleEffectLoader.ParticleEffectParameter> {

    public static class ParticleEffectParameter extends com.badlogic.gdx.assets.AssetLoaderParameters<com.badlogic.gdx.graphics.g2d.ParticleEffect> {
        public java.lang.String atlasFile;
        public java.lang.String atlasPrefix;
        public com.badlogic.gdx.files.FileHandle imagesDir;
    }

    public ParticleEffectLoader(com.badlogic.gdx.assets.loaders.FileHandleResolver fileHandleResolver) {
        super(fileHandleResolver);
    }

    @Override // com.badlogic.gdx.assets.loaders.AssetLoader
    public com.badlogic.gdx.utils.Array<com.badlogic.gdx.assets.AssetDescriptor> getDependencies(java.lang.String str, com.badlogic.gdx.files.FileHandle fileHandle, com.badlogic.gdx.assets.loaders.ParticleEffectLoader.ParticleEffectParameter particleEffectParameter) {
        if (particleEffectParameter == null || particleEffectParameter.atlasFile == null) {
            return null;
        }
        com.badlogic.gdx.utils.Array<com.badlogic.gdx.assets.AssetDescriptor> array = new com.badlogic.gdx.utils.Array<>();
        array.add(new com.badlogic.gdx.assets.AssetDescriptor(particleEffectParameter.atlasFile, com.badlogic.gdx.graphics.g2d.TextureAtlas.class));
        return array;
    }

    @Override // com.badlogic.gdx.assets.loaders.SynchronousAssetLoader
    public com.badlogic.gdx.graphics.g2d.ParticleEffect load(com.badlogic.gdx.assets.AssetManager assetManager, java.lang.String str, com.badlogic.gdx.files.FileHandle fileHandle, com.badlogic.gdx.assets.loaders.ParticleEffectLoader.ParticleEffectParameter particleEffectParameter) {
        com.badlogic.gdx.files.FileHandle fileHandle2;
        java.lang.String str2;
        com.badlogic.gdx.graphics.g2d.ParticleEffect particleEffect = new com.badlogic.gdx.graphics.g2d.ParticleEffect();
        if (particleEffectParameter != null && (str2 = particleEffectParameter.atlasFile) != null) {
            particleEffect.load(fileHandle, (com.badlogic.gdx.graphics.g2d.TextureAtlas) assetManager.get(str2, com.badlogic.gdx.graphics.g2d.TextureAtlas.class), particleEffectParameter.atlasPrefix);
        } else if (particleEffectParameter == null || (fileHandle2 = particleEffectParameter.imagesDir) == null) {
            particleEffect.load(fileHandle, fileHandle.parent());
        } else {
            particleEffect.load(fileHandle, fileHandle2);
        }
        return particleEffect;
    }
}
