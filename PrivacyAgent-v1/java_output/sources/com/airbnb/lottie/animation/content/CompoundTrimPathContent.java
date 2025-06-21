package com.airbnb.lottie.animation.content;

/* loaded from: classes.dex */
public class CompoundTrimPathContent {
    public java.util.List<com.airbnb.lottie.animation.content.TrimPathContent> a = new java.util.ArrayList();

    public void a(com.airbnb.lottie.animation.content.TrimPathContent trimPathContent) {
        this.a.add(trimPathContent);
    }

    public void apply(android.graphics.Path path) {
        for (int size = this.a.size() - 1; size >= 0; size--) {
            com.airbnb.lottie.utils.Utils.applyTrimPathIfNeeded(path, this.a.get(size));
        }
    }
}
