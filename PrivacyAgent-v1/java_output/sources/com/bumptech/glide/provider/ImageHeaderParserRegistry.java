package com.bumptech.glide.provider;

/* loaded from: classes.dex */
public final class ImageHeaderParserRegistry {
    private final java.util.List<com.bumptech.glide.load.ImageHeaderParser> parsers = new java.util.ArrayList();

    public synchronized void add(@androidx.annotation.NonNull com.bumptech.glide.load.ImageHeaderParser imageHeaderParser) {
        this.parsers.add(imageHeaderParser);
    }

    @androidx.annotation.NonNull
    public synchronized java.util.List<com.bumptech.glide.load.ImageHeaderParser> getParsers() {
        return this.parsers;
    }
}
