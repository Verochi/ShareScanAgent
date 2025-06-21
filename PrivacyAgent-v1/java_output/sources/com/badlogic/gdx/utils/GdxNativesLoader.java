package com.badlogic.gdx.utils;

/* loaded from: classes12.dex */
public class GdxNativesLoader {
    public static boolean disableNativesLoading;

    public static synchronized void load() {
        synchronized (com.badlogic.gdx.utils.GdxNativesLoader.class) {
            if (disableNativesLoading) {
                return;
            }
            new com.badlogic.gdx.utils.SharedLibraryLoader().load("gdx");
        }
    }
}
