package org.apache.tools.ant.types.resources;

/* loaded from: classes26.dex */
public class BZip2Resource extends org.apache.tools.ant.types.resources.CompressedResource {
    public static final char[] z = {'B', 'Z'};

    public BZip2Resource() {
    }

    public BZip2Resource(org.apache.tools.ant.types.ResourceCollection resourceCollection) {
        super(resourceCollection);
    }

    @Override // org.apache.tools.ant.types.resources.CompressedResource
    public java.lang.String getCompressionName() {
        return "Bzip2";
    }

    @Override // org.apache.tools.ant.types.resources.ContentTransformingResource
    public java.io.InputStream wrapStream(java.io.InputStream inputStream) throws java.io.IOException {
        for (char c : z) {
            if (inputStream.read() != c) {
                throw new java.io.IOException("Invalid bz2 stream.");
            }
        }
        return new org.apache.tools.bzip2.CBZip2InputStream(inputStream);
    }

    @Override // org.apache.tools.ant.types.resources.ContentTransformingResource
    public java.io.OutputStream wrapStream(java.io.OutputStream outputStream) throws java.io.IOException {
        for (char c : z) {
            outputStream.write(c);
        }
        return new org.apache.tools.bzip2.CBZip2OutputStream(outputStream);
    }
}
