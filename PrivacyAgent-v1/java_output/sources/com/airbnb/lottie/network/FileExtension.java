package com.airbnb.lottie.network;

/* loaded from: classes.dex */
public enum FileExtension {
    JSON(".json"),
    ZIP(".zip");

    public final java.lang.String extension;

    FileExtension(java.lang.String str) {
        this.extension = str;
    }

    public static com.airbnb.lottie.network.FileExtension forFile(java.lang.String str) {
        for (com.airbnb.lottie.network.FileExtension fileExtension : values()) {
            if (str.endsWith(fileExtension.extension)) {
                return fileExtension;
            }
        }
        com.airbnb.lottie.utils.Logger.warning("Unable to find correct extension for " + str);
        return JSON;
    }

    public java.lang.String tempExtension() {
        return com.anythink.china.common.a.a.e + this.extension;
    }

    @Override // java.lang.Enum
    public java.lang.String toString() {
        return this.extension;
    }
}
