package com.google.android.exoplayer2.upstream;

/* loaded from: classes22.dex */
public interface HttpDataSource extends com.google.android.exoplayer2.upstream.DataSource {
    public static final com.google.common.base.Predicate<java.lang.String> REJECT_PAYWALL_TYPES = new defpackage.rp0();

    public static abstract class BaseFactory implements com.google.android.exoplayer2.upstream.HttpDataSource.Factory {
        public final com.google.android.exoplayer2.upstream.HttpDataSource.RequestProperties a = new com.google.android.exoplayer2.upstream.HttpDataSource.RequestProperties();

        @Override // com.google.android.exoplayer2.upstream.HttpDataSource.Factory
        @java.lang.Deprecated
        public final void clearAllDefaultRequestProperties() {
            this.a.clear();
        }

        @Override // com.google.android.exoplayer2.upstream.HttpDataSource.Factory
        @java.lang.Deprecated
        public final void clearDefaultRequestProperty(java.lang.String str) {
            this.a.remove(str);
        }

        @Override // com.google.android.exoplayer2.upstream.HttpDataSource.Factory, com.google.android.exoplayer2.upstream.DataSource.Factory
        public final com.google.android.exoplayer2.upstream.HttpDataSource createDataSource() {
            return createDataSourceInternal(this.a);
        }

        public abstract com.google.android.exoplayer2.upstream.HttpDataSource createDataSourceInternal(com.google.android.exoplayer2.upstream.HttpDataSource.RequestProperties requestProperties);

        @Override // com.google.android.exoplayer2.upstream.HttpDataSource.Factory
        public final com.google.android.exoplayer2.upstream.HttpDataSource.RequestProperties getDefaultRequestProperties() {
            return this.a;
        }

        @Override // com.google.android.exoplayer2.upstream.HttpDataSource.Factory
        @java.lang.Deprecated
        public final void setDefaultRequestProperty(java.lang.String str, java.lang.String str2) {
            this.a.set(str, str2);
        }
    }

    public interface Factory extends com.google.android.exoplayer2.upstream.DataSource.Factory {
        @java.lang.Deprecated
        void clearAllDefaultRequestProperties();

        @java.lang.Deprecated
        void clearDefaultRequestProperty(java.lang.String str);

        @Override // com.google.android.exoplayer2.upstream.DataSource.Factory
        /* bridge */ /* synthetic */ com.google.android.exoplayer2.upstream.DataSource createDataSource();

        @Override // com.google.android.exoplayer2.upstream.DataSource.Factory
        com.google.android.exoplayer2.upstream.HttpDataSource createDataSource();

        com.google.android.exoplayer2.upstream.HttpDataSource.RequestProperties getDefaultRequestProperties();

        @java.lang.Deprecated
        void setDefaultRequestProperty(java.lang.String str, java.lang.String str2);
    }

    public static class HttpDataSourceException extends java.io.IOException {
        public static final int TYPE_CLOSE = 3;
        public static final int TYPE_OPEN = 1;
        public static final int TYPE_READ = 2;
        public final com.google.android.exoplayer2.upstream.DataSpec dataSpec;
        public final int type;

        @java.lang.annotation.Documented
        @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
        public @interface Type {
        }

        public HttpDataSourceException(com.google.android.exoplayer2.upstream.DataSpec dataSpec, int i) {
            this.dataSpec = dataSpec;
            this.type = i;
        }

        public HttpDataSourceException(java.io.IOException iOException, com.google.android.exoplayer2.upstream.DataSpec dataSpec, int i) {
            super(iOException);
            this.dataSpec = dataSpec;
            this.type = i;
        }

        public HttpDataSourceException(java.lang.String str, com.google.android.exoplayer2.upstream.DataSpec dataSpec, int i) {
            super(str);
            this.dataSpec = dataSpec;
            this.type = i;
        }

        public HttpDataSourceException(java.lang.String str, java.io.IOException iOException, com.google.android.exoplayer2.upstream.DataSpec dataSpec, int i) {
            super(str, iOException);
            this.dataSpec = dataSpec;
            this.type = i;
        }
    }

    public static final class InvalidContentTypeException extends com.google.android.exoplayer2.upstream.HttpDataSource.HttpDataSourceException {
        public final java.lang.String contentType;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public InvalidContentTypeException(java.lang.String str, com.google.android.exoplayer2.upstream.DataSpec dataSpec) {
            super(r0.length() != 0 ? "Invalid content type: ".concat(r0) : new java.lang.String("Invalid content type: "), dataSpec, 1);
            java.lang.String valueOf = java.lang.String.valueOf(str);
            this.contentType = str;
        }
    }

    public static final class InvalidResponseCodeException extends com.google.android.exoplayer2.upstream.HttpDataSource.HttpDataSourceException {
        public final java.util.Map<java.lang.String, java.util.List<java.lang.String>> headerFields;
        public final byte[] responseBody;
        public final int responseCode;

        @androidx.annotation.Nullable
        public final java.lang.String responseMessage;

        @java.lang.Deprecated
        public InvalidResponseCodeException(int i, @androidx.annotation.Nullable java.lang.String str, java.util.Map<java.lang.String, java.util.List<java.lang.String>> map, com.google.android.exoplayer2.upstream.DataSpec dataSpec) {
            this(i, str, map, dataSpec, com.google.android.exoplayer2.util.Util.EMPTY_BYTE_ARRAY);
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public InvalidResponseCodeException(int i, @androidx.annotation.Nullable java.lang.String str, java.util.Map<java.lang.String, java.util.List<java.lang.String>> map, com.google.android.exoplayer2.upstream.DataSpec dataSpec, byte[] bArr) {
            super(r0.toString(), dataSpec, 1);
            java.lang.StringBuilder sb = new java.lang.StringBuilder(26);
            sb.append("Response code: ");
            sb.append(i);
            this.responseCode = i;
            this.responseMessage = str;
            this.headerFields = map;
            this.responseBody = bArr;
        }

        @java.lang.Deprecated
        public InvalidResponseCodeException(int i, java.util.Map<java.lang.String, java.util.List<java.lang.String>> map, com.google.android.exoplayer2.upstream.DataSpec dataSpec) {
            this(i, null, map, dataSpec, com.google.android.exoplayer2.util.Util.EMPTY_BYTE_ARRAY);
        }
    }

    public static final class RequestProperties {
        public final java.util.Map<java.lang.String, java.lang.String> a = new java.util.HashMap();

        @androidx.annotation.Nullable
        public java.util.Map<java.lang.String, java.lang.String> b;

        public synchronized void clear() {
            this.b = null;
            this.a.clear();
        }

        public synchronized void clearAndSet(java.util.Map<java.lang.String, java.lang.String> map) {
            this.b = null;
            this.a.clear();
            this.a.putAll(map);
        }

        public synchronized java.util.Map<java.lang.String, java.lang.String> getSnapshot() {
            if (this.b == null) {
                this.b = java.util.Collections.unmodifiableMap(new java.util.HashMap(this.a));
            }
            return this.b;
        }

        public synchronized void remove(java.lang.String str) {
            this.b = null;
            this.a.remove(str);
        }

        public synchronized void set(java.lang.String str, java.lang.String str2) {
            this.b = null;
            this.a.put(str, str2);
        }

        public synchronized void set(java.util.Map<java.lang.String, java.lang.String> map) {
            this.b = null;
            this.a.putAll(map);
        }
    }

    void clearAllRequestProperties();

    void clearRequestProperty(java.lang.String str);

    @Override // com.google.android.exoplayer2.upstream.DataSource
    void close() throws com.google.android.exoplayer2.upstream.HttpDataSource.HttpDataSourceException;

    int getResponseCode();

    @Override // com.google.android.exoplayer2.upstream.DataSource
    java.util.Map<java.lang.String, java.util.List<java.lang.String>> getResponseHeaders();

    @Override // com.google.android.exoplayer2.upstream.DataSource
    long open(com.google.android.exoplayer2.upstream.DataSpec dataSpec) throws com.google.android.exoplayer2.upstream.HttpDataSource.HttpDataSourceException;

    @Override // com.google.android.exoplayer2.upstream.DataReader
    int read(byte[] bArr, int i, int i2) throws com.google.android.exoplayer2.upstream.HttpDataSource.HttpDataSourceException;

    void setRequestProperty(java.lang.String str, java.lang.String str2);
}
