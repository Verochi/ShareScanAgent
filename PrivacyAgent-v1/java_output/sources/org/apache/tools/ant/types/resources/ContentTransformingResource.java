package org.apache.tools.ant.types.resources;

/* loaded from: classes26.dex */
public abstract class ContentTransformingResource extends org.apache.tools.ant.types.resources.ResourceDecorator {

    /* renamed from: org.apache.tools.ant.types.resources.ContentTransformingResource$1, reason: invalid class name */
    public class AnonymousClass1 implements org.apache.tools.ant.types.resources.Appendable {
        public final /* synthetic */ org.apache.tools.ant.types.resources.Appendable n;

        public AnonymousClass1(org.apache.tools.ant.types.resources.Appendable appendable) {
            this.n = appendable;
        }

        @Override // org.apache.tools.ant.types.resources.Appendable
        public java.io.OutputStream getAppendOutputStream() throws java.io.IOException {
            java.io.OutputStream appendOutputStream = this.n.getAppendOutputStream();
            return appendOutputStream != null ? org.apache.tools.ant.types.resources.ContentTransformingResource.this.wrapStream(appendOutputStream) : appendOutputStream;
        }
    }

    public ContentTransformingResource() {
    }

    public ContentTransformingResource(org.apache.tools.ant.types.ResourceCollection resourceCollection) {
        super(resourceCollection);
    }

    @Override // org.apache.tools.ant.types.resources.ResourceDecorator, org.apache.tools.ant.types.Resource
    public <T> T as(java.lang.Class<T> cls) {
        org.apache.tools.ant.types.resources.Appendable appendable;
        if (!org.apache.tools.ant.types.resources.Appendable.class.isAssignableFrom(cls)) {
            if (org.apache.tools.ant.types.resources.FileProvider.class.isAssignableFrom(cls)) {
                return null;
            }
            return (T) getResource().as(cls);
        }
        if (!isAppendSupported() || (appendable = (org.apache.tools.ant.types.resources.Appendable) getResource().as(org.apache.tools.ant.types.resources.Appendable.class)) == null) {
            return null;
        }
        return cls.cast(new org.apache.tools.ant.types.resources.ContentTransformingResource.AnonymousClass1(appendable));
    }

    @Override // org.apache.tools.ant.types.resources.ResourceDecorator, org.apache.tools.ant.types.Resource
    public java.io.InputStream getInputStream() throws java.io.IOException {
        java.io.InputStream inputStream = getResource().getInputStream();
        return inputStream != null ? wrapStream(inputStream) : inputStream;
    }

    @Override // org.apache.tools.ant.types.resources.ResourceDecorator, org.apache.tools.ant.types.Resource
    public java.io.OutputStream getOutputStream() throws java.io.IOException {
        java.io.OutputStream outputStream = getResource().getOutputStream();
        return outputStream != null ? wrapStream(outputStream) : outputStream;
    }

    @Override // org.apache.tools.ant.types.resources.ResourceDecorator, org.apache.tools.ant.types.Resource
    public long getSize() {
        if (!isExists()) {
            return 0L;
        }
        java.io.InputStream inputStream = null;
        try {
            try {
                inputStream = getInputStream();
                byte[] bArr = new byte[8192];
                int i = 0;
                while (true) {
                    int read = inputStream.read(bArr, 0, 8192);
                    if (read <= 0) {
                        return i;
                    }
                    i += read;
                }
            } catch (java.io.IOException e) {
                throw new org.apache.tools.ant.BuildException("caught exception while reading " + getName(), e);
            }
        } finally {
            org.apache.tools.ant.util.FileUtils.close(inputStream);
        }
    }

    public boolean isAppendSupported() {
        return false;
    }

    public abstract java.io.InputStream wrapStream(java.io.InputStream inputStream) throws java.io.IOException;

    public abstract java.io.OutputStream wrapStream(java.io.OutputStream outputStream) throws java.io.IOException;
}
