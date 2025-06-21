package com.airbnb.lottie.model.layer;

/* loaded from: classes.dex */
public class Layer {
    public final java.util.List<com.airbnb.lottie.model.content.ContentModel> a;
    public final com.airbnb.lottie.LottieComposition b;
    public final java.lang.String c;
    public final long d;
    public final com.airbnb.lottie.model.layer.Layer.LayerType e;
    public final long f;

    @androidx.annotation.Nullable
    public final java.lang.String g;
    public final java.util.List<com.airbnb.lottie.model.content.Mask> h;
    public final com.airbnb.lottie.model.animatable.AnimatableTransform i;
    public final int j;
    public final int k;
    public final int l;
    public final float m;
    public final float n;
    public final int o;
    public final int p;

    @androidx.annotation.Nullable
    public final com.airbnb.lottie.model.animatable.AnimatableTextFrame q;

    @androidx.annotation.Nullable
    public final com.airbnb.lottie.model.animatable.AnimatableTextProperties r;

    /* renamed from: s, reason: collision with root package name */
    @androidx.annotation.Nullable
    public final com.airbnb.lottie.model.animatable.AnimatableFloatValue f78s;
    public final java.util.List<com.airbnb.lottie.value.Keyframe<java.lang.Float>> t;
    public final com.airbnb.lottie.model.layer.Layer.MatteType u;
    public final boolean v;

    public enum LayerType {
        PRE_COMP,
        SOLID,
        IMAGE,
        NULL,
        SHAPE,
        TEXT,
        UNKNOWN
    }

    public enum MatteType {
        NONE,
        ADD,
        INVERT,
        LUMA,
        LUMA_INVERTED,
        UNKNOWN
    }

    public Layer(java.util.List<com.airbnb.lottie.model.content.ContentModel> list, com.airbnb.lottie.LottieComposition lottieComposition, java.lang.String str, long j, com.airbnb.lottie.model.layer.Layer.LayerType layerType, long j2, @androidx.annotation.Nullable java.lang.String str2, java.util.List<com.airbnb.lottie.model.content.Mask> list2, com.airbnb.lottie.model.animatable.AnimatableTransform animatableTransform, int i, int i2, int i3, float f, float f2, int i4, int i5, @androidx.annotation.Nullable com.airbnb.lottie.model.animatable.AnimatableTextFrame animatableTextFrame, @androidx.annotation.Nullable com.airbnb.lottie.model.animatable.AnimatableTextProperties animatableTextProperties, java.util.List<com.airbnb.lottie.value.Keyframe<java.lang.Float>> list3, com.airbnb.lottie.model.layer.Layer.MatteType matteType, @androidx.annotation.Nullable com.airbnb.lottie.model.animatable.AnimatableFloatValue animatableFloatValue, boolean z) {
        this.a = list;
        this.b = lottieComposition;
        this.c = str;
        this.d = j;
        this.e = layerType;
        this.f = j2;
        this.g = str2;
        this.h = list2;
        this.i = animatableTransform;
        this.j = i;
        this.k = i2;
        this.l = i3;
        this.m = f;
        this.n = f2;
        this.o = i4;
        this.p = i5;
        this.q = animatableTextFrame;
        this.r = animatableTextProperties;
        this.t = list3;
        this.u = matteType;
        this.f78s = animatableFloatValue;
        this.v = z;
    }

    public com.airbnb.lottie.LottieComposition a() {
        return this.b;
    }

    public java.util.List<com.airbnb.lottie.value.Keyframe<java.lang.Float>> b() {
        return this.t;
    }

    public java.util.List<com.airbnb.lottie.model.content.Mask> c() {
        return this.h;
    }

    public com.airbnb.lottie.model.layer.Layer.MatteType d() {
        return this.u;
    }

    public java.lang.String e() {
        return this.c;
    }

    public long f() {
        return this.f;
    }

    public int g() {
        return this.p;
    }

    public long getId() {
        return this.d;
    }

    public com.airbnb.lottie.model.layer.Layer.LayerType getLayerType() {
        return this.e;
    }

    public int h() {
        return this.o;
    }

    @androidx.annotation.Nullable
    public java.lang.String i() {
        return this.g;
    }

    public boolean isHidden() {
        return this.v;
    }

    public java.util.List<com.airbnb.lottie.model.content.ContentModel> j() {
        return this.a;
    }

    public int k() {
        return this.l;
    }

    public int l() {
        return this.k;
    }

    public int m() {
        return this.j;
    }

    public float n() {
        return this.n / this.b.getDurationFrames();
    }

    @androidx.annotation.Nullable
    public com.airbnb.lottie.model.animatable.AnimatableTextFrame o() {
        return this.q;
    }

    @androidx.annotation.Nullable
    public com.airbnb.lottie.model.animatable.AnimatableTextProperties p() {
        return this.r;
    }

    @androidx.annotation.Nullable
    public com.airbnb.lottie.model.animatable.AnimatableFloatValue q() {
        return this.f78s;
    }

    public float r() {
        return this.m;
    }

    public com.airbnb.lottie.model.animatable.AnimatableTransform s() {
        return this.i;
    }

    public java.lang.String toString() {
        return toString("");
    }

    public java.lang.String toString(java.lang.String str) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(str);
        sb.append(e());
        sb.append("\n");
        com.airbnb.lottie.model.layer.Layer layerModelForId = this.b.layerModelForId(f());
        if (layerModelForId != null) {
            sb.append("\t\tParents: ");
            sb.append(layerModelForId.e());
            com.airbnb.lottie.model.layer.Layer layerModelForId2 = this.b.layerModelForId(layerModelForId.f());
            while (layerModelForId2 != null) {
                sb.append("->");
                sb.append(layerModelForId2.e());
                layerModelForId2 = this.b.layerModelForId(layerModelForId2.f());
            }
            sb.append(str);
            sb.append("\n");
        }
        if (!c().isEmpty()) {
            sb.append(str);
            sb.append("\tMasks: ");
            sb.append(c().size());
            sb.append("\n");
        }
        if (m() != 0 && l() != 0) {
            sb.append(str);
            sb.append("\tBackground: ");
            sb.append(java.lang.String.format(java.util.Locale.US, "%dx%d %X\n", java.lang.Integer.valueOf(m()), java.lang.Integer.valueOf(l()), java.lang.Integer.valueOf(k())));
        }
        if (!this.a.isEmpty()) {
            sb.append(str);
            sb.append("\tShapes:\n");
            for (com.airbnb.lottie.model.content.ContentModel contentModel : this.a) {
                sb.append(str);
                sb.append("\t\t");
                sb.append(contentModel);
                sb.append("\n");
            }
        }
        return sb.toString();
    }
}
