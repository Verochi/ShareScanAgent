package com.badlogic.gdx.assets;

/* loaded from: classes12.dex */
public class AssetDescriptor<T> {
    public com.badlogic.gdx.files.FileHandle file;
    public final java.lang.String fileName;
    public final com.badlogic.gdx.assets.AssetLoaderParameters params;
    public final java.lang.Class<T> type;

    public AssetDescriptor(com.badlogic.gdx.files.FileHandle fileHandle, java.lang.Class<T> cls) {
        this(fileHandle, cls, (com.badlogic.gdx.assets.AssetLoaderParameters) null);
    }

    public AssetDescriptor(com.badlogic.gdx.files.FileHandle fileHandle, java.lang.Class<T> cls, com.badlogic.gdx.assets.AssetLoaderParameters<T> assetLoaderParameters) {
        this.fileName = fileHandle.path().replaceAll("\\\\", net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR);
        this.file = fileHandle;
        this.type = cls;
        this.params = assetLoaderParameters;
    }

    public AssetDescriptor(java.lang.String str, java.lang.Class<T> cls) {
        this(str, cls, (com.badlogic.gdx.assets.AssetLoaderParameters) null);
    }

    public AssetDescriptor(java.lang.String str, java.lang.Class<T> cls, com.badlogic.gdx.assets.AssetLoaderParameters<T> assetLoaderParameters) {
        this.fileName = str.replaceAll("\\\\", net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR);
        this.type = cls;
        this.params = assetLoaderParameters;
    }

    public java.lang.String toString() {
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        stringBuffer.append(this.fileName);
        stringBuffer.append(", ");
        stringBuffer.append(this.type.getName());
        return stringBuffer.toString();
    }
}
