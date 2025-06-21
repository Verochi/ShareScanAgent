package org.apache.tools.ant.types.resources;

/* loaded from: classes26.dex */
public abstract class CompressedResource extends org.apache.tools.ant.types.resources.ContentTransformingResource {
    public CompressedResource() {
    }

    public CompressedResource(org.apache.tools.ant.types.ResourceCollection resourceCollection) {
        addConfigured(resourceCollection);
    }

    public abstract java.lang.String getCompressionName();

    @Override // org.apache.tools.ant.types.Resource, org.apache.tools.ant.types.DataType
    public java.lang.String toString() {
        return getCompressionName() + " compressed " + super.toString();
    }
}
