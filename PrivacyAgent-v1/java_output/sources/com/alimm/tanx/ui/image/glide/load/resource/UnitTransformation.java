package com.alimm.tanx.ui.image.glide.load.resource;

/* loaded from: classes.dex */
public class UnitTransformation<T> implements com.alimm.tanx.ui.image.glide.load.Transformation<T> {
    private static final com.alimm.tanx.ui.image.glide.load.Transformation<?> TRANSFORMATION = new com.alimm.tanx.ui.image.glide.load.resource.UnitTransformation();

    public static <T> com.alimm.tanx.ui.image.glide.load.resource.UnitTransformation<T> get() {
        return (com.alimm.tanx.ui.image.glide.load.resource.UnitTransformation) TRANSFORMATION;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.Transformation
    public java.lang.String getId() {
        return "";
    }

    @Override // com.alimm.tanx.ui.image.glide.load.Transformation
    public com.alimm.tanx.ui.image.glide.load.engine.Resource<T> transform(com.alimm.tanx.ui.image.glide.load.engine.Resource<T> resource, int i, int i2) {
        return resource;
    }
}
