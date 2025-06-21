package com.airbnb.lottie.model.content;

/* loaded from: classes.dex */
public class ShapeGroup implements com.airbnb.lottie.model.content.ContentModel {
    public final java.lang.String a;
    public final java.util.List<com.airbnb.lottie.model.content.ContentModel> b;
    public final boolean c;

    public ShapeGroup(java.lang.String str, java.util.List<com.airbnb.lottie.model.content.ContentModel> list, boolean z) {
        this.a = str;
        this.b = list;
        this.c = z;
    }

    public java.util.List<com.airbnb.lottie.model.content.ContentModel> getItems() {
        return this.b;
    }

    public java.lang.String getName() {
        return this.a;
    }

    public boolean isHidden() {
        return this.c;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    public com.airbnb.lottie.animation.content.Content toContent(com.airbnb.lottie.LottieDrawable lottieDrawable, com.airbnb.lottie.model.layer.BaseLayer baseLayer) {
        return new com.airbnb.lottie.animation.content.ContentGroup(lottieDrawable, baseLayer, this);
    }

    public java.lang.String toString() {
        return "ShapeGroup{name='" + this.a + "' Shapes: " + java.util.Arrays.toString(this.b.toArray()) + '}';
    }
}
