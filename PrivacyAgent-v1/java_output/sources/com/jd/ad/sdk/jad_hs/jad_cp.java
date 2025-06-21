package com.jd.ad.sdk.jad_hs;

/* loaded from: classes23.dex */
public final class jad_cp {
    public static final java.nio.charset.Charset jad_an = java.nio.charset.Charset.forName("US-ASCII");

    static {
        java.nio.charset.Charset.forName("UTF-8");
    }

    public static void jad_an(java.io.File file) {
        java.io.File[] listFiles = file.listFiles();
        if (listFiles == null) {
            throw new java.io.IOException("not a readable directory: " + file);
        }
        for (java.io.File file2 : listFiles) {
            if (file2.isDirectory()) {
                jad_an(file2);
            }
            if (!file2.delete()) {
                throw new java.io.IOException("failed to delete file: " + file2);
            }
        }
    }
}
