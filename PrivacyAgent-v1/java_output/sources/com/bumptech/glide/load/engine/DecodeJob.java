package com.bumptech.glide.load.engine;

/* loaded from: classes.dex */
class DecodeJob<R> implements com.bumptech.glide.load.engine.DataFetcherGenerator.FetcherReadyCallback, java.lang.Runnable, java.lang.Comparable<com.bumptech.glide.load.engine.DecodeJob<?>>, com.bumptech.glide.util.pool.FactoryPools.Poolable {
    private static final java.lang.String TAG = "DecodeJob";
    private com.bumptech.glide.load.engine.DecodeJob.Callback<R> callback;
    private com.bumptech.glide.load.Key currentAttemptingKey;
    private java.lang.Object currentData;
    private com.bumptech.glide.load.DataSource currentDataSource;
    private com.bumptech.glide.load.data.DataFetcher<?> currentFetcher;
    private volatile com.bumptech.glide.load.engine.DataFetcherGenerator currentGenerator;
    private com.bumptech.glide.load.Key currentSourceKey;
    private java.lang.Thread currentThread;
    private final com.bumptech.glide.load.engine.DecodeJob.DiskCacheProvider diskCacheProvider;
    private com.bumptech.glide.load.engine.DiskCacheStrategy diskCacheStrategy;
    private com.bumptech.glide.GlideContext glideContext;
    private int height;
    private volatile boolean isCallbackNotified;
    private volatile boolean isCancelled;
    private com.bumptech.glide.load.engine.EngineKey loadKey;
    private java.lang.Object model;
    private boolean onlyRetrieveFromCache;
    private com.bumptech.glide.load.Options options;
    private int order;
    private final androidx.core.util.Pools.Pool<com.bumptech.glide.load.engine.DecodeJob<?>> pool;
    private com.bumptech.glide.Priority priority;
    private com.bumptech.glide.load.engine.DecodeJob.RunReason runReason;
    private com.bumptech.glide.load.Key signature;
    private com.bumptech.glide.load.engine.DecodeJob.Stage stage;
    private long startFetchTime;
    private int width;
    private final com.bumptech.glide.load.engine.DecodeHelper<R> decodeHelper = new com.bumptech.glide.load.engine.DecodeHelper<>();
    private final java.util.List<java.lang.Throwable> throwables = new java.util.ArrayList();
    private final com.bumptech.glide.util.pool.StateVerifier stateVerifier = com.bumptech.glide.util.pool.StateVerifier.newInstance();
    private final com.bumptech.glide.load.engine.DecodeJob.DeferredEncodeManager<?> deferredEncodeManager = new com.bumptech.glide.load.engine.DecodeJob.DeferredEncodeManager<>();
    private final com.bumptech.glide.load.engine.DecodeJob.ReleaseManager releaseManager = new com.bumptech.glide.load.engine.DecodeJob.ReleaseManager();

    /* renamed from: com.bumptech.glide.load.engine.DecodeJob$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$bumptech$glide$load$EncodeStrategy;
        static final /* synthetic */ int[] $SwitchMap$com$bumptech$glide$load$engine$DecodeJob$RunReason;
        static final /* synthetic */ int[] $SwitchMap$com$bumptech$glide$load$engine$DecodeJob$Stage;

        static {
            int[] iArr = new int[com.bumptech.glide.load.EncodeStrategy.values().length];
            $SwitchMap$com$bumptech$glide$load$EncodeStrategy = iArr;
            try {
                iArr[com.bumptech.glide.load.EncodeStrategy.SOURCE.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$bumptech$glide$load$EncodeStrategy[com.bumptech.glide.load.EncodeStrategy.TRANSFORMED.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[com.bumptech.glide.load.engine.DecodeJob.Stage.values().length];
            $SwitchMap$com$bumptech$glide$load$engine$DecodeJob$Stage = iArr2;
            try {
                iArr2[com.bumptech.glide.load.engine.DecodeJob.Stage.RESOURCE_CACHE.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$bumptech$glide$load$engine$DecodeJob$Stage[com.bumptech.glide.load.engine.DecodeJob.Stage.DATA_CACHE.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$bumptech$glide$load$engine$DecodeJob$Stage[com.bumptech.glide.load.engine.DecodeJob.Stage.SOURCE.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$bumptech$glide$load$engine$DecodeJob$Stage[com.bumptech.glide.load.engine.DecodeJob.Stage.FINISHED.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$bumptech$glide$load$engine$DecodeJob$Stage[com.bumptech.glide.load.engine.DecodeJob.Stage.INITIALIZE.ordinal()] = 5;
            } catch (java.lang.NoSuchFieldError unused7) {
            }
            int[] iArr3 = new int[com.bumptech.glide.load.engine.DecodeJob.RunReason.values().length];
            $SwitchMap$com$bumptech$glide$load$engine$DecodeJob$RunReason = iArr3;
            try {
                iArr3[com.bumptech.glide.load.engine.DecodeJob.RunReason.INITIALIZE.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$bumptech$glide$load$engine$DecodeJob$RunReason[com.bumptech.glide.load.engine.DecodeJob.RunReason.SWITCH_TO_SOURCE_SERVICE.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$bumptech$glide$load$engine$DecodeJob$RunReason[com.bumptech.glide.load.engine.DecodeJob.RunReason.DECODE_DATA.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused10) {
            }
        }
    }

    public interface Callback<R> {
        void onLoadFailed(com.bumptech.glide.load.engine.GlideException glideException);

        void onResourceReady(com.bumptech.glide.load.engine.Resource<R> resource, com.bumptech.glide.load.DataSource dataSource);

        void reschedule(com.bumptech.glide.load.engine.DecodeJob<?> decodeJob);
    }

    public final class DecodeCallback<Z> implements com.bumptech.glide.load.engine.DecodePath.DecodeCallback<Z> {
        private final com.bumptech.glide.load.DataSource dataSource;

        public DecodeCallback(com.bumptech.glide.load.DataSource dataSource) {
            this.dataSource = dataSource;
        }

        @Override // com.bumptech.glide.load.engine.DecodePath.DecodeCallback
        @androidx.annotation.NonNull
        public com.bumptech.glide.load.engine.Resource<Z> onResourceDecoded(@androidx.annotation.NonNull com.bumptech.glide.load.engine.Resource<Z> resource) {
            return com.bumptech.glide.load.engine.DecodeJob.this.onResourceDecoded(this.dataSource, resource);
        }
    }

    public static class DeferredEncodeManager<Z> {
        private com.bumptech.glide.load.ResourceEncoder<Z> encoder;
        private com.bumptech.glide.load.Key key;
        private com.bumptech.glide.load.engine.LockedResource<Z> toEncode;

        public void clear() {
            this.key = null;
            this.encoder = null;
            this.toEncode = null;
        }

        public void encode(com.bumptech.glide.load.engine.DecodeJob.DiskCacheProvider diskCacheProvider, com.bumptech.glide.load.Options options) {
            com.bumptech.glide.util.pool.GlideTrace.beginSection("DecodeJob.encode");
            try {
                diskCacheProvider.getDiskCache().put(this.key, new com.bumptech.glide.load.engine.DataCacheWriter(this.encoder, this.toEncode, options));
            } finally {
                this.toEncode.unlock();
                com.bumptech.glide.util.pool.GlideTrace.endSection();
            }
        }

        public boolean hasResourceToEncode() {
            return this.toEncode != null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public <X> void init(com.bumptech.glide.load.Key key, com.bumptech.glide.load.ResourceEncoder<X> resourceEncoder, com.bumptech.glide.load.engine.LockedResource<X> lockedResource) {
            this.key = key;
            this.encoder = resourceEncoder;
            this.toEncode = lockedResource;
        }
    }

    public interface DiskCacheProvider {
        com.bumptech.glide.load.engine.cache.DiskCache getDiskCache();
    }

    public static class ReleaseManager {
        private boolean isEncodeComplete;
        private boolean isFailed;
        private boolean isReleased;

        private boolean isComplete(boolean z) {
            return (this.isFailed || z || this.isEncodeComplete) && this.isReleased;
        }

        public synchronized boolean onEncodeComplete() {
            this.isEncodeComplete = true;
            return isComplete(false);
        }

        public synchronized boolean onFailed() {
            this.isFailed = true;
            return isComplete(false);
        }

        public synchronized boolean release(boolean z) {
            this.isReleased = true;
            return isComplete(z);
        }

        public synchronized void reset() {
            this.isEncodeComplete = false;
            this.isReleased = false;
            this.isFailed = false;
        }
    }

    public enum RunReason {
        INITIALIZE,
        SWITCH_TO_SOURCE_SERVICE,
        DECODE_DATA
    }

    public enum Stage {
        INITIALIZE,
        RESOURCE_CACHE,
        DATA_CACHE,
        SOURCE,
        ENCODE,
        FINISHED
    }

    public DecodeJob(com.bumptech.glide.load.engine.DecodeJob.DiskCacheProvider diskCacheProvider, androidx.core.util.Pools.Pool<com.bumptech.glide.load.engine.DecodeJob<?>> pool) {
        this.diskCacheProvider = diskCacheProvider;
        this.pool = pool;
    }

    private <Data> com.bumptech.glide.load.engine.Resource<R> decodeFromData(com.bumptech.glide.load.data.DataFetcher<?> dataFetcher, Data data, com.bumptech.glide.load.DataSource dataSource) throws com.bumptech.glide.load.engine.GlideException {
        if (data == null) {
            dataFetcher.cleanup();
            return null;
        }
        try {
            long logTime = com.bumptech.glide.util.LogTime.getLogTime();
            com.bumptech.glide.load.engine.Resource<R> decodeFromFetcher = decodeFromFetcher(data, dataSource);
            if (android.util.Log.isLoggable(TAG, 2)) {
                logWithTimeAndKey("Decoded result " + decodeFromFetcher, logTime);
            }
            return decodeFromFetcher;
        } finally {
            dataFetcher.cleanup();
        }
    }

    private <Data> com.bumptech.glide.load.engine.Resource<R> decodeFromFetcher(Data data, com.bumptech.glide.load.DataSource dataSource) throws com.bumptech.glide.load.engine.GlideException {
        return runLoadPath(data, dataSource, this.decodeHelper.getLoadPath(data.getClass()));
    }

    private void decodeFromRetrievedData() {
        com.bumptech.glide.load.engine.Resource<R> resource;
        if (android.util.Log.isLoggable(TAG, 2)) {
            logWithTimeAndKey("Retrieved data", this.startFetchTime, "data: " + this.currentData + ", cache key: " + this.currentSourceKey + ", fetcher: " + this.currentFetcher);
        }
        try {
            resource = decodeFromData(this.currentFetcher, this.currentData, this.currentDataSource);
        } catch (com.bumptech.glide.load.engine.GlideException e) {
            e.setLoggingDetails(this.currentAttemptingKey, this.currentDataSource);
            this.throwables.add(e);
            resource = null;
        }
        if (resource != null) {
            notifyEncodeAndRelease(resource, this.currentDataSource);
        } else {
            runGenerators();
        }
    }

    private com.bumptech.glide.load.engine.DataFetcherGenerator getNextGenerator() {
        int i = com.bumptech.glide.load.engine.DecodeJob.AnonymousClass1.$SwitchMap$com$bumptech$glide$load$engine$DecodeJob$Stage[this.stage.ordinal()];
        if (i == 1) {
            return new com.bumptech.glide.load.engine.ResourceCacheGenerator(this.decodeHelper, this);
        }
        if (i == 2) {
            return new com.bumptech.glide.load.engine.DataCacheGenerator(this.decodeHelper, this);
        }
        if (i == 3) {
            return new com.bumptech.glide.load.engine.SourceGenerator(this.decodeHelper, this);
        }
        if (i == 4) {
            return null;
        }
        throw new java.lang.IllegalStateException("Unrecognized stage: " + this.stage);
    }

    private com.bumptech.glide.load.engine.DecodeJob.Stage getNextStage(com.bumptech.glide.load.engine.DecodeJob.Stage stage) {
        int i = com.bumptech.glide.load.engine.DecodeJob.AnonymousClass1.$SwitchMap$com$bumptech$glide$load$engine$DecodeJob$Stage[stage.ordinal()];
        if (i == 1) {
            return this.diskCacheStrategy.decodeCachedData() ? com.bumptech.glide.load.engine.DecodeJob.Stage.DATA_CACHE : getNextStage(com.bumptech.glide.load.engine.DecodeJob.Stage.DATA_CACHE);
        }
        if (i == 2) {
            return this.onlyRetrieveFromCache ? com.bumptech.glide.load.engine.DecodeJob.Stage.FINISHED : com.bumptech.glide.load.engine.DecodeJob.Stage.SOURCE;
        }
        if (i == 3 || i == 4) {
            return com.bumptech.glide.load.engine.DecodeJob.Stage.FINISHED;
        }
        if (i == 5) {
            return this.diskCacheStrategy.decodeCachedResource() ? com.bumptech.glide.load.engine.DecodeJob.Stage.RESOURCE_CACHE : getNextStage(com.bumptech.glide.load.engine.DecodeJob.Stage.RESOURCE_CACHE);
        }
        throw new java.lang.IllegalArgumentException("Unrecognized stage: " + stage);
    }

    @androidx.annotation.NonNull
    private com.bumptech.glide.load.Options getOptionsWithHardwareConfig(com.bumptech.glide.load.DataSource dataSource) {
        com.bumptech.glide.load.Options options = this.options;
        if (android.os.Build.VERSION.SDK_INT < 26) {
            return options;
        }
        boolean z = dataSource == com.bumptech.glide.load.DataSource.RESOURCE_DISK_CACHE || this.decodeHelper.isScaleOnlyOrNoTransform();
        com.bumptech.glide.load.Option<java.lang.Boolean> option = com.bumptech.glide.load.resource.bitmap.Downsampler.ALLOW_HARDWARE_CONFIG;
        java.lang.Boolean bool = (java.lang.Boolean) options.get(option);
        if (bool != null && (!bool.booleanValue() || z)) {
            return options;
        }
        com.bumptech.glide.load.Options options2 = new com.bumptech.glide.load.Options();
        options2.putAll(this.options);
        options2.set(option, java.lang.Boolean.valueOf(z));
        return options2;
    }

    private int getPriority() {
        return this.priority.ordinal();
    }

    private void logWithTimeAndKey(java.lang.String str, long j) {
        logWithTimeAndKey(str, j, null);
    }

    private void logWithTimeAndKey(java.lang.String str, long j, java.lang.String str2) {
        java.lang.String str3;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(str);
        sb.append(" in ");
        sb.append(com.bumptech.glide.util.LogTime.getElapsedMillis(j));
        sb.append(", load key: ");
        sb.append(this.loadKey);
        if (str2 != null) {
            str3 = ", " + str2;
        } else {
            str3 = "";
        }
        sb.append(str3);
        sb.append(", thread: ");
        sb.append(java.lang.Thread.currentThread().getName());
    }

    private void notifyComplete(com.bumptech.glide.load.engine.Resource<R> resource, com.bumptech.glide.load.DataSource dataSource) {
        setNotifiedOrThrow();
        this.callback.onResourceReady(resource, dataSource);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void notifyEncodeAndRelease(com.bumptech.glide.load.engine.Resource<R> resource, com.bumptech.glide.load.DataSource dataSource) {
        com.bumptech.glide.load.engine.LockedResource lockedResource;
        if (resource instanceof com.bumptech.glide.load.engine.Initializable) {
            ((com.bumptech.glide.load.engine.Initializable) resource).initialize();
        }
        if (this.deferredEncodeManager.hasResourceToEncode()) {
            resource = com.bumptech.glide.load.engine.LockedResource.obtain(resource);
            lockedResource = resource;
        } else {
            lockedResource = 0;
        }
        notifyComplete(resource, dataSource);
        this.stage = com.bumptech.glide.load.engine.DecodeJob.Stage.ENCODE;
        try {
            if (this.deferredEncodeManager.hasResourceToEncode()) {
                this.deferredEncodeManager.encode(this.diskCacheProvider, this.options);
            }
            onEncodeComplete();
        } finally {
            if (lockedResource != 0) {
                lockedResource.unlock();
            }
        }
    }

    private void notifyFailed() {
        setNotifiedOrThrow();
        this.callback.onLoadFailed(new com.bumptech.glide.load.engine.GlideException("Failed to load resource", new java.util.ArrayList(this.throwables)));
        onLoadFailed();
    }

    private void onEncodeComplete() {
        if (this.releaseManager.onEncodeComplete()) {
            releaseInternal();
        }
    }

    private void onLoadFailed() {
        if (this.releaseManager.onFailed()) {
            releaseInternal();
        }
    }

    private void releaseInternal() {
        this.releaseManager.reset();
        this.deferredEncodeManager.clear();
        this.decodeHelper.clear();
        this.isCallbackNotified = false;
        this.glideContext = null;
        this.signature = null;
        this.options = null;
        this.priority = null;
        this.loadKey = null;
        this.callback = null;
        this.stage = null;
        this.currentGenerator = null;
        this.currentThread = null;
        this.currentSourceKey = null;
        this.currentData = null;
        this.currentDataSource = null;
        this.currentFetcher = null;
        this.startFetchTime = 0L;
        this.isCancelled = false;
        this.model = null;
        this.throwables.clear();
        this.pool.release(this);
    }

    private void runGenerators() {
        this.currentThread = java.lang.Thread.currentThread();
        this.startFetchTime = com.bumptech.glide.util.LogTime.getLogTime();
        boolean z = false;
        while (!this.isCancelled && this.currentGenerator != null && !(z = this.currentGenerator.startNext())) {
            this.stage = getNextStage(this.stage);
            this.currentGenerator = getNextGenerator();
            if (this.stage == com.bumptech.glide.load.engine.DecodeJob.Stage.SOURCE) {
                reschedule();
                return;
            }
        }
        if ((this.stage == com.bumptech.glide.load.engine.DecodeJob.Stage.FINISHED || this.isCancelled) && !z) {
            notifyFailed();
        }
    }

    private <Data, ResourceType> com.bumptech.glide.load.engine.Resource<R> runLoadPath(Data data, com.bumptech.glide.load.DataSource dataSource, com.bumptech.glide.load.engine.LoadPath<Data, ResourceType, R> loadPath) throws com.bumptech.glide.load.engine.GlideException {
        com.bumptech.glide.load.Options optionsWithHardwareConfig = getOptionsWithHardwareConfig(dataSource);
        com.bumptech.glide.load.data.DataRewinder<Data> rewinder = this.glideContext.getRegistry().getRewinder(data);
        try {
            return loadPath.load(rewinder, optionsWithHardwareConfig, this.width, this.height, new com.bumptech.glide.load.engine.DecodeJob.DecodeCallback(dataSource));
        } finally {
            rewinder.cleanup();
        }
    }

    private void runWrapped() {
        int i = com.bumptech.glide.load.engine.DecodeJob.AnonymousClass1.$SwitchMap$com$bumptech$glide$load$engine$DecodeJob$RunReason[this.runReason.ordinal()];
        if (i == 1) {
            this.stage = getNextStage(com.bumptech.glide.load.engine.DecodeJob.Stage.INITIALIZE);
            this.currentGenerator = getNextGenerator();
            runGenerators();
        } else if (i == 2) {
            runGenerators();
        } else {
            if (i == 3) {
                decodeFromRetrievedData();
                return;
            }
            throw new java.lang.IllegalStateException("Unrecognized run reason: " + this.runReason);
        }
    }

    private void setNotifiedOrThrow() {
        java.lang.Throwable th;
        this.stateVerifier.throwIfRecycled();
        if (!this.isCallbackNotified) {
            this.isCallbackNotified = true;
            return;
        }
        if (this.throwables.isEmpty()) {
            th = null;
        } else {
            java.util.List<java.lang.Throwable> list = this.throwables;
            th = list.get(list.size() - 1);
        }
        throw new java.lang.IllegalStateException("Already notified", th);
    }

    public void cancel() {
        this.isCancelled = true;
        com.bumptech.glide.load.engine.DataFetcherGenerator dataFetcherGenerator = this.currentGenerator;
        if (dataFetcherGenerator != null) {
            dataFetcherGenerator.cancel();
        }
    }

    @Override // java.lang.Comparable
    public int compareTo(@androidx.annotation.NonNull com.bumptech.glide.load.engine.DecodeJob<?> decodeJob) {
        int priority = getPriority() - decodeJob.getPriority();
        return priority == 0 ? this.order - decodeJob.order : priority;
    }

    @Override // com.bumptech.glide.util.pool.FactoryPools.Poolable
    @androidx.annotation.NonNull
    public com.bumptech.glide.util.pool.StateVerifier getVerifier() {
        return this.stateVerifier;
    }

    public com.bumptech.glide.load.engine.DecodeJob<R> init(com.bumptech.glide.GlideContext glideContext, java.lang.Object obj, com.bumptech.glide.load.engine.EngineKey engineKey, com.bumptech.glide.load.Key key, int i, int i2, java.lang.Class<?> cls, java.lang.Class<R> cls2, com.bumptech.glide.Priority priority, com.bumptech.glide.load.engine.DiskCacheStrategy diskCacheStrategy, java.util.Map<java.lang.Class<?>, com.bumptech.glide.load.Transformation<?>> map, boolean z, boolean z2, boolean z3, com.bumptech.glide.load.Options options, com.bumptech.glide.load.engine.DecodeJob.Callback<R> callback, int i3) {
        this.decodeHelper.init(glideContext, obj, key, i, i2, diskCacheStrategy, cls, cls2, priority, options, map, z, z2, this.diskCacheProvider);
        this.glideContext = glideContext;
        this.signature = key;
        this.priority = priority;
        this.loadKey = engineKey;
        this.width = i;
        this.height = i2;
        this.diskCacheStrategy = diskCacheStrategy;
        this.onlyRetrieveFromCache = z3;
        this.options = options;
        this.callback = callback;
        this.order = i3;
        this.runReason = com.bumptech.glide.load.engine.DecodeJob.RunReason.INITIALIZE;
        this.model = obj;
        return this;
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator.FetcherReadyCallback
    public void onDataFetcherFailed(com.bumptech.glide.load.Key key, java.lang.Exception exc, com.bumptech.glide.load.data.DataFetcher<?> dataFetcher, com.bumptech.glide.load.DataSource dataSource) {
        dataFetcher.cleanup();
        com.bumptech.glide.load.engine.GlideException glideException = new com.bumptech.glide.load.engine.GlideException("Fetching data failed", exc);
        glideException.setLoggingDetails(key, dataSource, dataFetcher.getDataClass());
        this.throwables.add(glideException);
        if (java.lang.Thread.currentThread() == this.currentThread) {
            runGenerators();
        } else {
            this.runReason = com.bumptech.glide.load.engine.DecodeJob.RunReason.SWITCH_TO_SOURCE_SERVICE;
            this.callback.reschedule(this);
        }
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator.FetcherReadyCallback
    public void onDataFetcherReady(com.bumptech.glide.load.Key key, java.lang.Object obj, com.bumptech.glide.load.data.DataFetcher<?> dataFetcher, com.bumptech.glide.load.DataSource dataSource, com.bumptech.glide.load.Key key2) {
        this.currentSourceKey = key;
        this.currentData = obj;
        this.currentFetcher = dataFetcher;
        this.currentDataSource = dataSource;
        this.currentAttemptingKey = key2;
        if (java.lang.Thread.currentThread() != this.currentThread) {
            this.runReason = com.bumptech.glide.load.engine.DecodeJob.RunReason.DECODE_DATA;
            this.callback.reschedule(this);
        } else {
            com.bumptech.glide.util.pool.GlideTrace.beginSection("DecodeJob.decodeFromRetrievedData");
            try {
                decodeFromRetrievedData();
            } finally {
                com.bumptech.glide.util.pool.GlideTrace.endSection();
            }
        }
    }

    @androidx.annotation.NonNull
    public <Z> com.bumptech.glide.load.engine.Resource<Z> onResourceDecoded(com.bumptech.glide.load.DataSource dataSource, @androidx.annotation.NonNull com.bumptech.glide.load.engine.Resource<Z> resource) {
        com.bumptech.glide.load.engine.Resource<Z> resource2;
        com.bumptech.glide.load.Transformation<Z> transformation;
        com.bumptech.glide.load.EncodeStrategy encodeStrategy;
        com.bumptech.glide.load.Key dataCacheKey;
        java.lang.Class<?> cls = resource.get().getClass();
        com.bumptech.glide.load.ResourceEncoder<Z> resourceEncoder = null;
        if (dataSource != com.bumptech.glide.load.DataSource.RESOURCE_DISK_CACHE) {
            com.bumptech.glide.load.Transformation<Z> transformation2 = this.decodeHelper.getTransformation(cls);
            transformation = transformation2;
            resource2 = transformation2.transform(this.glideContext, resource, this.width, this.height);
        } else {
            resource2 = resource;
            transformation = null;
        }
        if (!resource.equals(resource2)) {
            resource.recycle();
        }
        if (this.decodeHelper.isResourceEncoderAvailable(resource2)) {
            resourceEncoder = this.decodeHelper.getResultEncoder(resource2);
            encodeStrategy = resourceEncoder.getEncodeStrategy(this.options);
        } else {
            encodeStrategy = com.bumptech.glide.load.EncodeStrategy.NONE;
        }
        com.bumptech.glide.load.ResourceEncoder resourceEncoder2 = resourceEncoder;
        if (!this.diskCacheStrategy.isResourceCacheable(!this.decodeHelper.isSourceKey(this.currentSourceKey), dataSource, encodeStrategy)) {
            return resource2;
        }
        if (resourceEncoder2 == null) {
            throw new com.bumptech.glide.Registry.NoResultEncoderAvailableException(resource2.get().getClass());
        }
        int i = com.bumptech.glide.load.engine.DecodeJob.AnonymousClass1.$SwitchMap$com$bumptech$glide$load$EncodeStrategy[encodeStrategy.ordinal()];
        if (i == 1) {
            dataCacheKey = new com.bumptech.glide.load.engine.DataCacheKey(this.currentSourceKey, this.signature);
        } else {
            if (i != 2) {
                throw new java.lang.IllegalArgumentException("Unknown strategy: " + encodeStrategy);
            }
            dataCacheKey = new com.bumptech.glide.load.engine.ResourceCacheKey(this.decodeHelper.getArrayPool(), this.currentSourceKey, this.signature, this.width, this.height, transformation, cls, this.options);
        }
        com.bumptech.glide.load.engine.LockedResource obtain = com.bumptech.glide.load.engine.LockedResource.obtain(resource2);
        this.deferredEncodeManager.init(dataCacheKey, resourceEncoder2, obtain);
        return obtain;
    }

    public void release(boolean z) {
        if (this.releaseManager.release(z)) {
            releaseInternal();
        }
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator.FetcherReadyCallback
    public void reschedule() {
        this.runReason = com.bumptech.glide.load.engine.DecodeJob.RunReason.SWITCH_TO_SOURCE_SERVICE;
        this.callback.reschedule(this);
    }

    @Override // java.lang.Runnable
    public void run() {
        com.bumptech.glide.util.pool.GlideTrace.beginSectionFormat("DecodeJob#run(model=%s)", this.model);
        com.bumptech.glide.load.data.DataFetcher<?> dataFetcher = this.currentFetcher;
        try {
            try {
                if (this.isCancelled) {
                    notifyFailed();
                    return;
                }
                runWrapped();
                if (dataFetcher != null) {
                    dataFetcher.cleanup();
                }
                com.bumptech.glide.util.pool.GlideTrace.endSection();
            } finally {
                if (dataFetcher != null) {
                    dataFetcher.cleanup();
                }
                com.bumptech.glide.util.pool.GlideTrace.endSection();
            }
        } catch (com.bumptech.glide.load.engine.CallbackException e) {
            throw e;
        } catch (java.lang.Throwable th) {
            if (android.util.Log.isLoggable(TAG, 3)) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("DecodeJob threw unexpectedly, isCancelled: ");
                sb.append(this.isCancelled);
                sb.append(", stage: ");
                sb.append(this.stage);
            }
            if (this.stage != com.bumptech.glide.load.engine.DecodeJob.Stage.ENCODE) {
                this.throwables.add(th);
                notifyFailed();
            }
            if (!this.isCancelled) {
                throw th;
            }
            throw th;
        }
    }

    public boolean willDecodeFromCache() {
        com.bumptech.glide.load.engine.DecodeJob.Stage nextStage = getNextStage(com.bumptech.glide.load.engine.DecodeJob.Stage.INITIALIZE);
        return nextStage == com.bumptech.glide.load.engine.DecodeJob.Stage.RESOURCE_CACHE || nextStage == com.bumptech.glide.load.engine.DecodeJob.Stage.DATA_CACHE;
    }
}
