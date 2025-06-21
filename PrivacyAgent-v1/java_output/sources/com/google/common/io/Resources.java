package com.google.common.io;

@com.google.common.annotations.Beta
@com.google.common.annotations.GwtIncompatible
/* loaded from: classes22.dex */
public final class Resources {

    /* renamed from: com.google.common.io.Resources$1, reason: invalid class name */
    public static class AnonymousClass1 implements com.google.common.io.LineProcessor<java.util.List<java.lang.String>> {
        public final java.util.List<java.lang.String> a = com.google.common.collect.Lists.newArrayList();

        @Override // com.google.common.io.LineProcessor
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public java.util.List<java.lang.String> getResult() {
            return this.a;
        }

        @Override // com.google.common.io.LineProcessor
        public boolean processLine(java.lang.String str) {
            this.a.add(str);
            return true;
        }
    }

    public static final class UrlByteSource extends com.google.common.io.ByteSource {
        public final java.net.URL a;

        public UrlByteSource(java.net.URL url) {
            this.a = (java.net.URL) com.google.common.base.Preconditions.checkNotNull(url);
        }

        public /* synthetic */ UrlByteSource(java.net.URL url, com.google.common.io.Resources.AnonymousClass1 anonymousClass1) {
            this(url);
        }

        @Override // com.google.common.io.ByteSource
        public java.io.InputStream openStream() throws java.io.IOException {
            return this.a.openStream();
        }

        public java.lang.String toString() {
            return "Resources.asByteSource(" + this.a + ")";
        }
    }

    public static com.google.common.io.ByteSource asByteSource(java.net.URL url) {
        return new com.google.common.io.Resources.UrlByteSource(url, null);
    }

    public static com.google.common.io.CharSource asCharSource(java.net.URL url, java.nio.charset.Charset charset) {
        return asByteSource(url).asCharSource(charset);
    }

    public static void copy(java.net.URL url, java.io.OutputStream outputStream) throws java.io.IOException {
        asByteSource(url).copyTo(outputStream);
    }

    public static java.net.URL getResource(java.lang.Class<?> cls, java.lang.String str) {
        java.net.URL resource = cls.getResource(str);
        com.google.common.base.Preconditions.checkArgument(resource != null, "resource %s relative to %s not found.", str, cls.getName());
        return resource;
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public static java.net.URL getResource(java.lang.String str) {
        java.net.URL resource = ((java.lang.ClassLoader) com.google.common.base.MoreObjects.firstNonNull(java.lang.Thread.currentThread().getContextClassLoader(), com.google.common.io.Resources.class.getClassLoader())).getResource(str);
        com.google.common.base.Preconditions.checkArgument(resource != null, "resource %s not found.", str);
        return resource;
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public static <T> T readLines(java.net.URL url, java.nio.charset.Charset charset, com.google.common.io.LineProcessor<T> lineProcessor) throws java.io.IOException {
        return (T) asCharSource(url, charset).readLines(lineProcessor);
    }

    public static java.util.List<java.lang.String> readLines(java.net.URL url, java.nio.charset.Charset charset) throws java.io.IOException {
        return (java.util.List) readLines(url, charset, new com.google.common.io.Resources.AnonymousClass1());
    }

    public static byte[] toByteArray(java.net.URL url) throws java.io.IOException {
        return asByteSource(url).read();
    }

    public static java.lang.String toString(java.net.URL url, java.nio.charset.Charset charset) throws java.io.IOException {
        return asCharSource(url, charset).read();
    }
}
