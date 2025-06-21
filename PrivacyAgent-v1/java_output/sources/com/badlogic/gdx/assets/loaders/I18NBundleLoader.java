package com.badlogic.gdx.assets.loaders;

/* loaded from: classes12.dex */
public class I18NBundleLoader extends com.badlogic.gdx.assets.loaders.AsynchronousAssetLoader<com.badlogic.gdx.utils.I18NBundle, com.badlogic.gdx.assets.loaders.I18NBundleLoader.I18NBundleParameter> {
    public com.badlogic.gdx.utils.I18NBundle b;

    public static class I18NBundleParameter extends com.badlogic.gdx.assets.AssetLoaderParameters<com.badlogic.gdx.utils.I18NBundle> {
        public final java.lang.String encoding;
        public final java.util.Locale locale;

        public I18NBundleParameter() {
            this(null, null);
        }

        public I18NBundleParameter(java.util.Locale locale) {
            this(locale, null);
        }

        public I18NBundleParameter(java.util.Locale locale, java.lang.String str) {
            this.locale = locale;
            this.encoding = str;
        }
    }

    public I18NBundleLoader(com.badlogic.gdx.assets.loaders.FileHandleResolver fileHandleResolver) {
        super(fileHandleResolver);
    }

    @Override // com.badlogic.gdx.assets.loaders.AssetLoader
    public com.badlogic.gdx.utils.Array<com.badlogic.gdx.assets.AssetDescriptor> getDependencies(java.lang.String str, com.badlogic.gdx.files.FileHandle fileHandle, com.badlogic.gdx.assets.loaders.I18NBundleLoader.I18NBundleParameter i18NBundleParameter) {
        return null;
    }

    @Override // com.badlogic.gdx.assets.loaders.AsynchronousAssetLoader
    public void loadAsync(com.badlogic.gdx.assets.AssetManager assetManager, java.lang.String str, com.badlogic.gdx.files.FileHandle fileHandle, com.badlogic.gdx.assets.loaders.I18NBundleLoader.I18NBundleParameter i18NBundleParameter) {
        java.util.Locale locale;
        java.lang.String str2 = null;
        this.b = null;
        if (i18NBundleParameter == null) {
            locale = java.util.Locale.getDefault();
        } else {
            java.util.Locale locale2 = i18NBundleParameter.locale;
            if (locale2 == null) {
                locale2 = java.util.Locale.getDefault();
            }
            locale = locale2;
            str2 = i18NBundleParameter.encoding;
        }
        if (str2 == null) {
            this.b = com.badlogic.gdx.utils.I18NBundle.createBundle(fileHandle, locale);
        } else {
            this.b = com.badlogic.gdx.utils.I18NBundle.createBundle(fileHandle, locale, str2);
        }
    }

    @Override // com.badlogic.gdx.assets.loaders.AsynchronousAssetLoader
    public com.badlogic.gdx.utils.I18NBundle loadSync(com.badlogic.gdx.assets.AssetManager assetManager, java.lang.String str, com.badlogic.gdx.files.FileHandle fileHandle, com.badlogic.gdx.assets.loaders.I18NBundleLoader.I18NBundleParameter i18NBundleParameter) {
        com.badlogic.gdx.utils.I18NBundle i18NBundle = this.b;
        this.b = null;
        return i18NBundle;
    }
}
