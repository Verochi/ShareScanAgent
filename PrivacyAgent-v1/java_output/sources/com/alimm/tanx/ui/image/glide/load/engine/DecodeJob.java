package com.alimm.tanx.ui.image.glide.load.engine;

/* loaded from: classes.dex */
class DecodeJob<A, T, Z> {
    private static final com.alimm.tanx.ui.image.glide.load.engine.DecodeJob.FileOpener DEFAULT_FILE_OPENER = new com.alimm.tanx.ui.image.glide.load.engine.DecodeJob.FileOpener();
    private static final java.lang.String TAG = "DecodeJob";
    private final com.alimm.tanx.ui.image.glide.load.engine.DecodeJob.DiskCacheProvider diskCacheProvider;
    private final com.alimm.tanx.ui.image.glide.load.engine.DiskCacheStrategy diskCacheStrategy;
    private final com.alimm.tanx.ui.image.glide.load.data.DataFetcher<A> fetcher;
    private final com.alimm.tanx.ui.image.glide.load.engine.DecodeJob.FileOpener fileOpener;
    private final int height;
    private volatile boolean isCancelled;
    private final com.alimm.tanx.ui.image.glide.provider.DataLoadProvider<A, T> loadProvider;
    private final com.alimm.tanx.ui.image.glide.Priority priority;
    private final com.alimm.tanx.ui.image.glide.load.engine.EngineKey resultKey;
    private final com.alimm.tanx.ui.image.glide.load.resource.transcode.ResourceTranscoder<T, Z> transcoder;
    private final com.alimm.tanx.ui.image.glide.load.Transformation<T> transformation;
    private final int width;

    public interface DiskCacheProvider {
        com.alimm.tanx.ui.image.glide.load.engine.cache.DiskCache getDiskCache();
    }

    public static class FileOpener {
        public java.io.OutputStream open(java.io.File file) throws java.io.FileNotFoundException {
            return new java.io.BufferedOutputStream(new java.io.FileOutputStream(file));
        }
    }

    public class SourceWriter<DataType> implements com.alimm.tanx.ui.image.glide.load.engine.cache.DiskCache.Writer {
        private final DataType data;
        private final com.alimm.tanx.ui.image.glide.load.Encoder<DataType> encoder;

        public SourceWriter(com.alimm.tanx.ui.image.glide.load.Encoder<DataType> encoder, DataType datatype) {
            this.encoder = encoder;
            this.data = datatype;
        }

        @Override // com.alimm.tanx.ui.image.glide.load.engine.cache.DiskCache.Writer
        public boolean write(java.io.File file) {
            boolean z;
            java.io.OutputStream outputStream = null;
            try {
                try {
                    outputStream = com.alimm.tanx.ui.image.glide.load.engine.DecodeJob.this.fileOpener.open(file);
                    z = this.encoder.encode(this.data, outputStream);
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (java.io.IOException unused) {
                        }
                    }
                } catch (java.lang.Throwable th) {
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (java.io.IOException unused2) {
                        }
                    }
                    throw th;
                }
            } catch (java.io.FileNotFoundException unused3) {
                android.util.Log.isLoggable(com.alimm.tanx.ui.image.glide.load.engine.DecodeJob.TAG, 3);
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (java.io.IOException unused4) {
                    }
                }
                z = false;
            }
            return z;
        }
    }

    public DecodeJob(com.alimm.tanx.ui.image.glide.load.engine.EngineKey engineKey, int i, int i2, com.alimm.tanx.ui.image.glide.load.data.DataFetcher<A> dataFetcher, com.alimm.tanx.ui.image.glide.provider.DataLoadProvider<A, T> dataLoadProvider, com.alimm.tanx.ui.image.glide.load.Transformation<T> transformation, com.alimm.tanx.ui.image.glide.load.resource.transcode.ResourceTranscoder<T, Z> resourceTranscoder, com.alimm.tanx.ui.image.glide.load.engine.DecodeJob.DiskCacheProvider diskCacheProvider, com.alimm.tanx.ui.image.glide.load.engine.DiskCacheStrategy diskCacheStrategy, com.alimm.tanx.ui.image.glide.Priority priority) {
        this(engineKey, i, i2, dataFetcher, dataLoadProvider, transformation, resourceTranscoder, diskCacheProvider, diskCacheStrategy, priority, DEFAULT_FILE_OPENER);
    }

    public DecodeJob(com.alimm.tanx.ui.image.glide.load.engine.EngineKey engineKey, int i, int i2, com.alimm.tanx.ui.image.glide.load.data.DataFetcher<A> dataFetcher, com.alimm.tanx.ui.image.glide.provider.DataLoadProvider<A, T> dataLoadProvider, com.alimm.tanx.ui.image.glide.load.Transformation<T> transformation, com.alimm.tanx.ui.image.glide.load.resource.transcode.ResourceTranscoder<T, Z> resourceTranscoder, com.alimm.tanx.ui.image.glide.load.engine.DecodeJob.DiskCacheProvider diskCacheProvider, com.alimm.tanx.ui.image.glide.load.engine.DiskCacheStrategy diskCacheStrategy, com.alimm.tanx.ui.image.glide.Priority priority, com.alimm.tanx.ui.image.glide.load.engine.DecodeJob.FileOpener fileOpener) {
        this.resultKey = engineKey;
        this.width = i;
        this.height = i2;
        this.fetcher = dataFetcher;
        this.loadProvider = dataLoadProvider;
        this.transformation = transformation;
        this.transcoder = resourceTranscoder;
        this.diskCacheProvider = diskCacheProvider;
        this.diskCacheStrategy = diskCacheStrategy;
        this.priority = priority;
        this.fileOpener = fileOpener;
    }

    private com.alimm.tanx.ui.image.glide.load.engine.Resource<T> cacheAndDecodeSourceData(A a) throws java.io.IOException {
        long logTime = com.alimm.tanx.ui.image.glide.util.LogTime.getLogTime();
        this.diskCacheProvider.getDiskCache().put(this.resultKey.getOriginalKey(), new com.alimm.tanx.ui.image.glide.load.engine.DecodeJob.SourceWriter(this.loadProvider.getSourceEncoder(), a));
        if (android.util.Log.isLoggable(TAG, 2)) {
            logWithTimeAndKey("Wrote source to cache", logTime);
        }
        long logTime2 = com.alimm.tanx.ui.image.glide.util.LogTime.getLogTime();
        com.alimm.tanx.ui.image.glide.load.engine.Resource<T> loadFromCache = loadFromCache(this.resultKey.getOriginalKey());
        if (android.util.Log.isLoggable(TAG, 2) && loadFromCache != null) {
            logWithTimeAndKey("Decoded source from cache", logTime2);
        }
        return loadFromCache;
    }

    private com.alimm.tanx.ui.image.glide.load.engine.Resource<T> decodeFromSourceData(A a) throws java.io.IOException {
        if (this.diskCacheStrategy.cacheSource()) {
            return cacheAndDecodeSourceData(a);
        }
        long logTime = com.alimm.tanx.ui.image.glide.util.LogTime.getLogTime();
        com.alimm.tanx.ui.image.glide.load.engine.Resource<T> decode = this.loadProvider.getSourceDecoder().decode(a, this.width, this.height);
        if (!android.util.Log.isLoggable(TAG, 2)) {
            return decode;
        }
        logWithTimeAndKey("Decoded from source", logTime);
        return decode;
    }

    private com.alimm.tanx.ui.image.glide.load.engine.Resource<T> decodeSource() throws java.lang.Exception {
        try {
            long logTime = com.alimm.tanx.ui.image.glide.util.LogTime.getLogTime();
            A loadData = this.fetcher.loadData(this.priority);
            if (android.util.Log.isLoggable(TAG, 2)) {
                logWithTimeAndKey("Fetched data", logTime);
            }
            if (!this.isCancelled) {
                return decodeFromSourceData(loadData);
            }
            this.fetcher.cleanup();
            return null;
        } finally {
            this.fetcher.cleanup();
        }
    }

    private com.alimm.tanx.ui.image.glide.load.engine.Resource<T> loadFromCache(com.alimm.tanx.ui.image.glide.load.Key key) throws java.io.IOException {
        java.io.File file = this.diskCacheProvider.getDiskCache().get(key);
        if (file == null) {
            return null;
        }
        try {
            com.alimm.tanx.ui.image.glide.load.engine.Resource<T> decode = this.loadProvider.getCacheDecoder().decode(file, this.width, this.height);
            if (decode == null) {
            }
            return decode;
        } finally {
            this.diskCacheProvider.getDiskCache().delete(key);
        }
    }

    private void logWithTimeAndKey(java.lang.String str, long j) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(str);
        sb.append(" in ");
        sb.append(com.alimm.tanx.ui.image.glide.util.LogTime.getElapsedMillis(j));
        sb.append(", key: ");
        sb.append(this.resultKey);
    }

    private com.alimm.tanx.ui.image.glide.load.engine.Resource<Z> transcode(com.alimm.tanx.ui.image.glide.load.engine.Resource<T> resource) {
        if (resource == null) {
            return null;
        }
        return this.transcoder.transcode(resource);
    }

    private com.alimm.tanx.ui.image.glide.load.engine.Resource<T> transform(com.alimm.tanx.ui.image.glide.load.engine.Resource<T> resource) {
        if (resource == null) {
            return null;
        }
        com.alimm.tanx.ui.image.glide.load.engine.Resource<T> transform = this.transformation.transform(resource, this.width, this.height);
        if (!resource.equals(transform)) {
            resource.recycle();
        }
        return transform;
    }

    private com.alimm.tanx.ui.image.glide.load.engine.Resource<Z> transformEncodeAndTranscode(com.alimm.tanx.ui.image.glide.load.engine.Resource<T> resource) {
        long logTime = com.alimm.tanx.ui.image.glide.util.LogTime.getLogTime();
        com.alimm.tanx.ui.image.glide.load.engine.Resource<T> transform = transform(resource);
        if (android.util.Log.isLoggable(TAG, 2)) {
            logWithTimeAndKey("Transformed resource from source", logTime);
        }
        writeTransformedToCache(transform);
        long logTime2 = com.alimm.tanx.ui.image.glide.util.LogTime.getLogTime();
        com.alimm.tanx.ui.image.glide.load.engine.Resource<Z> transcode = transcode(transform);
        if (android.util.Log.isLoggable(TAG, 2)) {
            logWithTimeAndKey("Transcoded transformed from source", logTime2);
        }
        return transcode;
    }

    private void writeTransformedToCache(com.alimm.tanx.ui.image.glide.load.engine.Resource<T> resource) {
        if (resource == null || !this.diskCacheStrategy.cacheResult()) {
            return;
        }
        long logTime = com.alimm.tanx.ui.image.glide.util.LogTime.getLogTime();
        this.diskCacheProvider.getDiskCache().put(this.resultKey, new com.alimm.tanx.ui.image.glide.load.engine.DecodeJob.SourceWriter(this.loadProvider.getEncoder(), resource));
        if (android.util.Log.isLoggable(TAG, 2)) {
            logWithTimeAndKey("Wrote transformed from source to cache", logTime);
        }
    }

    public void cancel() {
        this.isCancelled = true;
        this.fetcher.cancel();
    }

    public com.alimm.tanx.ui.image.glide.load.engine.Resource<Z> decodeFromSource() throws java.lang.Exception {
        return transformEncodeAndTranscode(decodeSource());
    }

    public com.alimm.tanx.ui.image.glide.load.engine.Resource<Z> decodeResultFromCache() throws java.lang.Exception {
        if (!this.diskCacheStrategy.cacheResult()) {
            return null;
        }
        long logTime = com.alimm.tanx.ui.image.glide.util.LogTime.getLogTime();
        com.alimm.tanx.ui.image.glide.load.engine.Resource<T> loadFromCache = loadFromCache(this.resultKey);
        if (android.util.Log.isLoggable(TAG, 2)) {
            logWithTimeAndKey("Decoded transformed from cache", logTime);
        }
        long logTime2 = com.alimm.tanx.ui.image.glide.util.LogTime.getLogTime();
        com.alimm.tanx.ui.image.glide.load.engine.Resource<Z> transcode = transcode(loadFromCache);
        if (android.util.Log.isLoggable(TAG, 2)) {
            logWithTimeAndKey("Transcoded transformed from cache", logTime2);
        }
        return transcode;
    }

    public com.alimm.tanx.ui.image.glide.load.engine.Resource<Z> decodeSourceFromCache() throws java.lang.Exception {
        if (!this.diskCacheStrategy.cacheSource()) {
            return null;
        }
        long logTime = com.alimm.tanx.ui.image.glide.util.LogTime.getLogTime();
        com.alimm.tanx.ui.image.glide.load.engine.Resource<T> loadFromCache = loadFromCache(this.resultKey.getOriginalKey());
        if (android.util.Log.isLoggable(TAG, 2)) {
            logWithTimeAndKey("Decoded source from cache", logTime);
        }
        return transformEncodeAndTranscode(loadFromCache);
    }
}
