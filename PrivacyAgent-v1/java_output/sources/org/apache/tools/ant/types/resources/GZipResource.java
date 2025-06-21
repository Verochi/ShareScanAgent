package org.apache.tools.ant.types.resources;

/* loaded from: classes26.dex */
public class GZipResource extends org.apache.tools.ant.types.resources.CompressedResource {
    public GZipResource() {
    }

    public GZipResource(org.apache.tools.ant.types.ResourceCollection resourceCollection) {
        super(resourceCollection);
    }

    @Override // org.apache.tools.ant.types.resources.CompressedResource
    public java.lang.String getCompressionName() {
        return "GZip";
    }

    @Override // org.apache.tools.ant.types.resources.ContentTransformingResource
    public java.io.InputStream wrapStream(java.io.InputStream inputStream) throws java.io.IOException {
        return new java.util.zip.GZIPInputStream(inputStream);
    }

    @Override // org.apache.tools.ant.types.resources.ContentTransformingResource
    public java.io.OutputStream wrapStream(java.io.OutputStream outputStream) throws java.io.IOException {
        return new java.util.zip.GZIPOutputStream(outputStream);
    }
}
