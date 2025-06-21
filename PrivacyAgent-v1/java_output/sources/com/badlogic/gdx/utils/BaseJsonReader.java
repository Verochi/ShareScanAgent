package com.badlogic.gdx.utils;

/* loaded from: classes12.dex */
public interface BaseJsonReader {
    com.badlogic.gdx.utils.JsonValue parse(com.badlogic.gdx.files.FileHandle fileHandle);

    com.badlogic.gdx.utils.JsonValue parse(java.io.InputStream inputStream);
}
