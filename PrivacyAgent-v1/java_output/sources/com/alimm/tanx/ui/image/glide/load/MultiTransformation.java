package com.alimm.tanx.ui.image.glide.load;

/* loaded from: classes.dex */
public class MultiTransformation<T> implements com.alimm.tanx.ui.image.glide.load.Transformation<T> {
    private java.lang.String id;
    private final java.util.Collection<? extends com.alimm.tanx.ui.image.glide.load.Transformation<T>> transformations;

    public MultiTransformation(java.util.Collection<? extends com.alimm.tanx.ui.image.glide.load.Transformation<T>> collection) {
        if (collection.size() < 1) {
            throw new java.lang.IllegalArgumentException("MultiTransformation must contain at least one Transformation");
        }
        this.transformations = collection;
    }

    @java.lang.SafeVarargs
    public MultiTransformation(com.alimm.tanx.ui.image.glide.load.Transformation<T>... transformationArr) {
        if (transformationArr.length < 1) {
            throw new java.lang.IllegalArgumentException("MultiTransformation must contain at least one Transformation");
        }
        this.transformations = java.util.Arrays.asList(transformationArr);
    }

    @Override // com.alimm.tanx.ui.image.glide.load.Transformation
    public java.lang.String getId() {
        if (this.id == null) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            java.util.Iterator<? extends com.alimm.tanx.ui.image.glide.load.Transformation<T>> it = this.transformations.iterator();
            while (it.hasNext()) {
                sb.append(it.next().getId());
            }
            this.id = sb.toString();
        }
        return this.id;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.Transformation
    public com.alimm.tanx.ui.image.glide.load.engine.Resource<T> transform(com.alimm.tanx.ui.image.glide.load.engine.Resource<T> resource, int i, int i2) {
        java.util.Iterator<? extends com.alimm.tanx.ui.image.glide.load.Transformation<T>> it = this.transformations.iterator();
        com.alimm.tanx.ui.image.glide.load.engine.Resource<T> resource2 = resource;
        while (it.hasNext()) {
            com.alimm.tanx.ui.image.glide.load.engine.Resource<T> transform = it.next().transform(resource2, i, i2);
            if (resource2 != null && !resource2.equals(resource) && !resource2.equals(transform)) {
                resource2.recycle();
            }
            resource2 = transform;
        }
        return resource2;
    }
}
