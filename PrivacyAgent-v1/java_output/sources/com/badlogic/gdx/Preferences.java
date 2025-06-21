package com.badlogic.gdx;

/* loaded from: classes12.dex */
public interface Preferences {
    void clear();

    boolean contains(java.lang.String str);

    void flush();

    java.util.Map<java.lang.String, ?> get();

    boolean getBoolean(java.lang.String str);

    boolean getBoolean(java.lang.String str, boolean z);

    float getFloat(java.lang.String str);

    float getFloat(java.lang.String str, float f);

    int getInteger(java.lang.String str);

    int getInteger(java.lang.String str, int i);

    long getLong(java.lang.String str);

    long getLong(java.lang.String str, long j);

    java.lang.String getString(java.lang.String str);

    java.lang.String getString(java.lang.String str, java.lang.String str2);

    com.badlogic.gdx.Preferences put(java.util.Map<java.lang.String, ?> map);

    com.badlogic.gdx.Preferences putBoolean(java.lang.String str, boolean z);

    com.badlogic.gdx.Preferences putFloat(java.lang.String str, float f);

    com.badlogic.gdx.Preferences putInteger(java.lang.String str, int i);

    com.badlogic.gdx.Preferences putLong(java.lang.String str, long j);

    com.badlogic.gdx.Preferences putString(java.lang.String str, java.lang.String str2);

    void remove(java.lang.String str);
}
