package com.badlogic.gdx;

/* loaded from: classes12.dex */
public interface Files {

    public enum FileType {
        Classpath,
        Internal,
        External,
        Absolute,
        Local
    }

    com.badlogic.gdx.files.FileHandle absolute(java.lang.String str);

    com.badlogic.gdx.files.FileHandle classpath(java.lang.String str);

    com.badlogic.gdx.files.FileHandle external(java.lang.String str);

    java.lang.String getExternalStoragePath();

    com.badlogic.gdx.files.FileHandle getFileHandle(java.lang.String str, com.badlogic.gdx.Files.FileType fileType);

    java.lang.String getLocalStoragePath();

    com.badlogic.gdx.files.FileHandle internal(java.lang.String str);

    boolean isExternalStorageAvailable();

    boolean isLocalStorageAvailable();

    com.badlogic.gdx.files.FileHandle local(java.lang.String str);
}
