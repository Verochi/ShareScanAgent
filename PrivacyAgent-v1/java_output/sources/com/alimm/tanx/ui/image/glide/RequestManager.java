package com.alimm.tanx.ui.image.glide;

/* loaded from: classes.dex */
public class RequestManager implements com.alimm.tanx.ui.image.glide.manager.LifecycleListener {
    private final android.content.Context context;
    private final com.alimm.tanx.ui.image.glide.Glide glide;
    private final com.alimm.tanx.ui.image.glide.manager.Lifecycle lifecycle;
    private com.alimm.tanx.ui.image.glide.RequestManager.DefaultOptions options;
    private final com.alimm.tanx.ui.image.glide.RequestManager.OptionsApplier optionsApplier;
    private final com.alimm.tanx.ui.image.glide.manager.RequestTracker requestTracker;
    private final com.alimm.tanx.ui.image.glide.manager.RequestManagerTreeNode treeNode;

    /* renamed from: com.alimm.tanx.ui.image.glide.RequestManager$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ com.alimm.tanx.ui.image.glide.manager.Lifecycle val$lifecycle;

        public AnonymousClass1(com.alimm.tanx.ui.image.glide.manager.Lifecycle lifecycle) {
            this.val$lifecycle = lifecycle;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.val$lifecycle.addListener(com.alimm.tanx.ui.image.glide.RequestManager.this);
        }
    }

    public interface DefaultOptions {
        <T> void apply(com.alimm.tanx.ui.image.glide.GenericRequestBuilder<T, ?, ?, ?> genericRequestBuilder);
    }

    public final class GenericModelRequest<A, T> {
        private final java.lang.Class<T> dataClass;
        private final com.alimm.tanx.ui.image.glide.load.model.ModelLoader<A, T> modelLoader;

        public final class GenericTypeRequest {
            private final A model;
            private final java.lang.Class<A> modelClass;
            private final boolean providedModel;

            public GenericTypeRequest(java.lang.Class<A> cls) {
                this.providedModel = false;
                this.model = null;
                this.modelClass = cls;
            }

            public GenericTypeRequest(A a) {
                this.providedModel = true;
                this.model = a;
                this.modelClass = com.alimm.tanx.ui.image.glide.RequestManager.getSafeClass(a);
            }

            public <Z> com.alimm.tanx.ui.image.glide.GenericTranscodeRequest<A, T, Z> as(java.lang.Class<Z> cls) {
                com.alimm.tanx.ui.image.glide.GenericTranscodeRequest<A, T, Z> genericTranscodeRequest = (com.alimm.tanx.ui.image.glide.GenericTranscodeRequest) com.alimm.tanx.ui.image.glide.RequestManager.this.optionsApplier.apply(new com.alimm.tanx.ui.image.glide.GenericTranscodeRequest(com.alimm.tanx.ui.image.glide.RequestManager.this.context, com.alimm.tanx.ui.image.glide.RequestManager.this.glide, this.modelClass, com.alimm.tanx.ui.image.glide.RequestManager.GenericModelRequest.this.modelLoader, com.alimm.tanx.ui.image.glide.RequestManager.GenericModelRequest.this.dataClass, cls, com.alimm.tanx.ui.image.glide.RequestManager.this.requestTracker, com.alimm.tanx.ui.image.glide.RequestManager.this.lifecycle, com.alimm.tanx.ui.image.glide.RequestManager.this.optionsApplier));
                if (this.providedModel) {
                    genericTranscodeRequest.load(this.model);
                }
                return genericTranscodeRequest;
            }
        }

        public GenericModelRequest(com.alimm.tanx.ui.image.glide.load.model.ModelLoader<A, T> modelLoader, java.lang.Class<T> cls) {
            this.modelLoader = modelLoader;
            this.dataClass = cls;
        }

        public com.alimm.tanx.ui.image.glide.RequestManager.GenericModelRequest<A, T>.GenericTypeRequest from(java.lang.Class<A> cls) {
            return new com.alimm.tanx.ui.image.glide.RequestManager.GenericModelRequest.GenericTypeRequest((java.lang.Class) cls);
        }

        public com.alimm.tanx.ui.image.glide.RequestManager.GenericModelRequest<A, T>.GenericTypeRequest load(A a) {
            return new com.alimm.tanx.ui.image.glide.RequestManager.GenericModelRequest.GenericTypeRequest(a);
        }
    }

    public final class ImageModelRequest<T> {
        private final com.alimm.tanx.ui.image.glide.load.model.ModelLoader<T, java.io.InputStream> loader;

        public ImageModelRequest(com.alimm.tanx.ui.image.glide.load.model.ModelLoader<T, java.io.InputStream> modelLoader) {
            this.loader = modelLoader;
        }

        public com.alimm.tanx.ui.image.glide.DrawableTypeRequest<T> from(java.lang.Class<T> cls) {
            return (com.alimm.tanx.ui.image.glide.DrawableTypeRequest) com.alimm.tanx.ui.image.glide.RequestManager.this.optionsApplier.apply(new com.alimm.tanx.ui.image.glide.DrawableTypeRequest(cls, this.loader, null, com.alimm.tanx.ui.image.glide.RequestManager.this.context, com.alimm.tanx.ui.image.glide.RequestManager.this.glide, com.alimm.tanx.ui.image.glide.RequestManager.this.requestTracker, com.alimm.tanx.ui.image.glide.RequestManager.this.lifecycle, com.alimm.tanx.ui.image.glide.RequestManager.this.optionsApplier));
        }

        public com.alimm.tanx.ui.image.glide.DrawableTypeRequest<T> load(T t) {
            return (com.alimm.tanx.ui.image.glide.DrawableTypeRequest) from(com.alimm.tanx.ui.image.glide.RequestManager.getSafeClass(t)).load((com.alimm.tanx.ui.image.glide.DrawableTypeRequest<T>) t);
        }
    }

    public class OptionsApplier {
        public OptionsApplier() {
        }

        public <A, X extends com.alimm.tanx.ui.image.glide.GenericRequestBuilder<A, ?, ?, ?>> X apply(X x) {
            if (com.alimm.tanx.ui.image.glide.RequestManager.this.options != null) {
                com.alimm.tanx.ui.image.glide.RequestManager.this.options.apply(x);
            }
            return x;
        }
    }

    public static class RequestManagerConnectivityListener implements com.alimm.tanx.ui.image.glide.manager.ConnectivityMonitor.ConnectivityListener {
        private final com.alimm.tanx.ui.image.glide.manager.RequestTracker requestTracker;

        public RequestManagerConnectivityListener(com.alimm.tanx.ui.image.glide.manager.RequestTracker requestTracker) {
            this.requestTracker = requestTracker;
        }

        @Override // com.alimm.tanx.ui.image.glide.manager.ConnectivityMonitor.ConnectivityListener
        public void onConnectivityChanged(boolean z) {
            if (z) {
                this.requestTracker.restartRequests();
            }
        }
    }

    public final class VideoModelRequest<T> {
        private final com.alimm.tanx.ui.image.glide.load.model.ModelLoader<T, android.os.ParcelFileDescriptor> loader;

        public VideoModelRequest(com.alimm.tanx.ui.image.glide.load.model.ModelLoader<T, android.os.ParcelFileDescriptor> modelLoader) {
            this.loader = modelLoader;
        }

        public com.alimm.tanx.ui.image.glide.DrawableTypeRequest<T> load(T t) {
            return (com.alimm.tanx.ui.image.glide.DrawableTypeRequest) ((com.alimm.tanx.ui.image.glide.DrawableTypeRequest) com.alimm.tanx.ui.image.glide.RequestManager.this.optionsApplier.apply(new com.alimm.tanx.ui.image.glide.DrawableTypeRequest(com.alimm.tanx.ui.image.glide.RequestManager.getSafeClass(t), null, this.loader, com.alimm.tanx.ui.image.glide.RequestManager.this.context, com.alimm.tanx.ui.image.glide.RequestManager.this.glide, com.alimm.tanx.ui.image.glide.RequestManager.this.requestTracker, com.alimm.tanx.ui.image.glide.RequestManager.this.lifecycle, com.alimm.tanx.ui.image.glide.RequestManager.this.optionsApplier))).load((com.alimm.tanx.ui.image.glide.DrawableTypeRequest) t);
        }
    }

    public RequestManager(android.content.Context context, com.alimm.tanx.ui.image.glide.manager.Lifecycle lifecycle, com.alimm.tanx.ui.image.glide.manager.RequestManagerTreeNode requestManagerTreeNode) {
        this(context, lifecycle, requestManagerTreeNode, new com.alimm.tanx.ui.image.glide.manager.RequestTracker(), new com.alimm.tanx.ui.image.glide.manager.ConnectivityMonitorFactory());
    }

    public RequestManager(android.content.Context context, com.alimm.tanx.ui.image.glide.manager.Lifecycle lifecycle, com.alimm.tanx.ui.image.glide.manager.RequestManagerTreeNode requestManagerTreeNode, com.alimm.tanx.ui.image.glide.manager.RequestTracker requestTracker, com.alimm.tanx.ui.image.glide.manager.ConnectivityMonitorFactory connectivityMonitorFactory) {
        this.context = context.getApplicationContext();
        this.lifecycle = lifecycle;
        this.treeNode = requestManagerTreeNode;
        this.requestTracker = requestTracker;
        this.glide = com.alimm.tanx.ui.image.glide.Glide.get(context);
        this.optionsApplier = new com.alimm.tanx.ui.image.glide.RequestManager.OptionsApplier();
        com.alimm.tanx.ui.image.glide.manager.ConnectivityMonitor build = connectivityMonitorFactory.build(context, new com.alimm.tanx.ui.image.glide.RequestManager.RequestManagerConnectivityListener(requestTracker));
        if (com.alimm.tanx.ui.image.glide.util.Util.isOnBackgroundThread()) {
            new android.os.Handler(android.os.Looper.getMainLooper()).post(new com.alimm.tanx.ui.image.glide.RequestManager.AnonymousClass1(lifecycle));
        } else {
            lifecycle.addListener(this);
        }
        lifecycle.addListener(build);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T> java.lang.Class<T> getSafeClass(T t) {
        if (t != null) {
            return (java.lang.Class<T>) t.getClass();
        }
        return null;
    }

    private <T> com.alimm.tanx.ui.image.glide.DrawableTypeRequest<T> loadGeneric(java.lang.Class<T> cls) {
        com.alimm.tanx.ui.image.glide.load.model.ModelLoader buildStreamModelLoader = com.alimm.tanx.ui.image.glide.Glide.buildStreamModelLoader((java.lang.Class) cls, this.context);
        com.alimm.tanx.ui.image.glide.load.model.ModelLoader buildFileDescriptorModelLoader = com.alimm.tanx.ui.image.glide.Glide.buildFileDescriptorModelLoader((java.lang.Class) cls, this.context);
        if (cls == null || buildStreamModelLoader != null || buildFileDescriptorModelLoader != null) {
            com.alimm.tanx.ui.image.glide.RequestManager.OptionsApplier optionsApplier = this.optionsApplier;
            return (com.alimm.tanx.ui.image.glide.DrawableTypeRequest) optionsApplier.apply(new com.alimm.tanx.ui.image.glide.DrawableTypeRequest(cls, buildStreamModelLoader, buildFileDescriptorModelLoader, this.context, this.glide, this.requestTracker, this.lifecycle, optionsApplier));
        }
        throw new java.lang.IllegalArgumentException("Unknown type " + cls + ". You must provide a Model of a type for which there is a registered ModelLoader, if you are using a custom model, you must first call Glide#register with a ModelLoaderFactory for your custom model class");
    }

    public <T> com.alimm.tanx.ui.image.glide.DrawableTypeRequest<T> from(java.lang.Class<T> cls) {
        return loadGeneric(cls);
    }

    public com.alimm.tanx.ui.image.glide.DrawableTypeRequest<byte[]> fromBytes() {
        return (com.alimm.tanx.ui.image.glide.DrawableTypeRequest) loadGeneric(byte[].class).signature((com.alimm.tanx.ui.image.glide.load.Key) new com.alimm.tanx.ui.image.glide.signature.StringSignature(java.util.UUID.randomUUID().toString())).diskCacheStrategy(com.alimm.tanx.ui.image.glide.load.engine.DiskCacheStrategy.NONE).skipMemoryCache(true);
    }

    public com.alimm.tanx.ui.image.glide.DrawableTypeRequest<java.io.File> fromFile() {
        return loadGeneric(java.io.File.class);
    }

    public com.alimm.tanx.ui.image.glide.DrawableTypeRequest<android.net.Uri> fromMediaStore() {
        com.alimm.tanx.ui.image.glide.load.model.stream.MediaStoreStreamLoader mediaStoreStreamLoader = new com.alimm.tanx.ui.image.glide.load.model.stream.MediaStoreStreamLoader(this.context, com.alimm.tanx.ui.image.glide.Glide.buildStreamModelLoader(android.net.Uri.class, this.context));
        com.alimm.tanx.ui.image.glide.load.model.ModelLoader buildFileDescriptorModelLoader = com.alimm.tanx.ui.image.glide.Glide.buildFileDescriptorModelLoader(android.net.Uri.class, this.context);
        com.alimm.tanx.ui.image.glide.RequestManager.OptionsApplier optionsApplier = this.optionsApplier;
        return (com.alimm.tanx.ui.image.glide.DrawableTypeRequest) optionsApplier.apply(new com.alimm.tanx.ui.image.glide.DrawableTypeRequest(android.net.Uri.class, mediaStoreStreamLoader, buildFileDescriptorModelLoader, this.context, this.glide, this.requestTracker, this.lifecycle, optionsApplier));
    }

    public com.alimm.tanx.ui.image.glide.DrawableTypeRequest<java.lang.Integer> fromResource() {
        return (com.alimm.tanx.ui.image.glide.DrawableTypeRequest) loadGeneric(java.lang.Integer.class).signature(com.alimm.tanx.ui.image.glide.signature.ApplicationVersionSignature.obtain(this.context));
    }

    public com.alimm.tanx.ui.image.glide.DrawableTypeRequest<java.lang.String> fromString() {
        return loadGeneric(java.lang.String.class);
    }

    public com.alimm.tanx.ui.image.glide.DrawableTypeRequest<android.net.Uri> fromUri() {
        return loadGeneric(android.net.Uri.class);
    }

    @java.lang.Deprecated
    public com.alimm.tanx.ui.image.glide.DrawableTypeRequest<java.net.URL> fromUrl() {
        return loadGeneric(java.net.URL.class);
    }

    public boolean isPaused() {
        com.alimm.tanx.ui.image.glide.util.Util.assertMainThread();
        return this.requestTracker.isPaused();
    }

    public com.alimm.tanx.ui.image.glide.DrawableTypeRequest<android.net.Uri> load(android.net.Uri uri) {
        return (com.alimm.tanx.ui.image.glide.DrawableTypeRequest) fromUri().load((com.alimm.tanx.ui.image.glide.DrawableTypeRequest<android.net.Uri>) uri);
    }

    public com.alimm.tanx.ui.image.glide.DrawableTypeRequest<java.io.File> load(java.io.File file) {
        return (com.alimm.tanx.ui.image.glide.DrawableTypeRequest) fromFile().load((com.alimm.tanx.ui.image.glide.DrawableTypeRequest<java.io.File>) file);
    }

    public com.alimm.tanx.ui.image.glide.DrawableTypeRequest<java.lang.Integer> load(java.lang.Integer num) {
        return (com.alimm.tanx.ui.image.glide.DrawableTypeRequest) fromResource().load((com.alimm.tanx.ui.image.glide.DrawableTypeRequest<java.lang.Integer>) num);
    }

    public <T> com.alimm.tanx.ui.image.glide.DrawableTypeRequest<T> load(T t) {
        return (com.alimm.tanx.ui.image.glide.DrawableTypeRequest) loadGeneric(getSafeClass(t)).load((com.alimm.tanx.ui.image.glide.DrawableTypeRequest<T>) t);
    }

    public com.alimm.tanx.ui.image.glide.DrawableTypeRequest<java.lang.String> load(java.lang.String str) {
        return (com.alimm.tanx.ui.image.glide.DrawableTypeRequest) fromString().load((com.alimm.tanx.ui.image.glide.DrawableTypeRequest<java.lang.String>) str);
    }

    @java.lang.Deprecated
    public com.alimm.tanx.ui.image.glide.DrawableTypeRequest<java.net.URL> load(java.net.URL url) {
        return (com.alimm.tanx.ui.image.glide.DrawableTypeRequest) fromUrl().load((com.alimm.tanx.ui.image.glide.DrawableTypeRequest<java.net.URL>) url);
    }

    public com.alimm.tanx.ui.image.glide.DrawableTypeRequest<byte[]> load(byte[] bArr) {
        return (com.alimm.tanx.ui.image.glide.DrawableTypeRequest) fromBytes().load((com.alimm.tanx.ui.image.glide.DrawableTypeRequest<byte[]>) bArr);
    }

    @java.lang.Deprecated
    public com.alimm.tanx.ui.image.glide.DrawableTypeRequest<byte[]> load(byte[] bArr, java.lang.String str) {
        return (com.alimm.tanx.ui.image.glide.DrawableTypeRequest) load(bArr).signature((com.alimm.tanx.ui.image.glide.load.Key) new com.alimm.tanx.ui.image.glide.signature.StringSignature(str));
    }

    public com.alimm.tanx.ui.image.glide.DrawableTypeRequest<android.net.Uri> loadFromMediaStore(android.net.Uri uri) {
        return (com.alimm.tanx.ui.image.glide.DrawableTypeRequest) fromMediaStore().load((com.alimm.tanx.ui.image.glide.DrawableTypeRequest<android.net.Uri>) uri);
    }

    @java.lang.Deprecated
    public com.alimm.tanx.ui.image.glide.DrawableTypeRequest<android.net.Uri> loadFromMediaStore(android.net.Uri uri, java.lang.String str, long j, int i) {
        return (com.alimm.tanx.ui.image.glide.DrawableTypeRequest) loadFromMediaStore(uri).signature((com.alimm.tanx.ui.image.glide.load.Key) new com.alimm.tanx.ui.image.glide.signature.MediaStoreSignature(str, j, i));
    }

    @Override // com.alimm.tanx.ui.image.glide.manager.LifecycleListener
    public void onDestroy() {
        this.requestTracker.clearRequests();
    }

    public void onLowMemory() {
        this.glide.clearMemory();
    }

    @Override // com.alimm.tanx.ui.image.glide.manager.LifecycleListener
    public void onStart() {
        resumeRequests();
    }

    @Override // com.alimm.tanx.ui.image.glide.manager.LifecycleListener
    public void onStop() {
        pauseRequests();
    }

    public void onTrimMemory(int i) {
        this.glide.trimMemory(i);
    }

    public void pauseRequests() {
        com.alimm.tanx.ui.image.glide.util.Util.assertMainThread();
        this.requestTracker.pauseRequests();
    }

    public void pauseRequestsRecursive() {
        com.alimm.tanx.ui.image.glide.util.Util.assertMainThread();
        pauseRequests();
        java.util.Iterator<com.alimm.tanx.ui.image.glide.RequestManager> it = this.treeNode.getDescendants().iterator();
        while (it.hasNext()) {
            it.next().pauseRequests();
        }
    }

    public void resumeRequests() {
        com.alimm.tanx.ui.image.glide.util.Util.assertMainThread();
        this.requestTracker.resumeRequests();
    }

    public void resumeRequestsRecursive() {
        com.alimm.tanx.ui.image.glide.util.Util.assertMainThread();
        resumeRequests();
        java.util.Iterator<com.alimm.tanx.ui.image.glide.RequestManager> it = this.treeNode.getDescendants().iterator();
        while (it.hasNext()) {
            it.next().resumeRequests();
        }
    }

    public void setDefaultOptions(com.alimm.tanx.ui.image.glide.RequestManager.DefaultOptions defaultOptions) {
        this.options = defaultOptions;
    }

    public <A, T> com.alimm.tanx.ui.image.glide.RequestManager.GenericModelRequest<A, T> using(com.alimm.tanx.ui.image.glide.load.model.ModelLoader<A, T> modelLoader, java.lang.Class<T> cls) {
        return new com.alimm.tanx.ui.image.glide.RequestManager.GenericModelRequest<>(modelLoader, cls);
    }

    public com.alimm.tanx.ui.image.glide.RequestManager.ImageModelRequest<byte[]> using(com.alimm.tanx.ui.image.glide.load.model.stream.StreamByteArrayLoader streamByteArrayLoader) {
        return new com.alimm.tanx.ui.image.glide.RequestManager.ImageModelRequest<>(streamByteArrayLoader);
    }

    public <T> com.alimm.tanx.ui.image.glide.RequestManager.ImageModelRequest<T> using(com.alimm.tanx.ui.image.glide.load.model.stream.StreamModelLoader<T> streamModelLoader) {
        return new com.alimm.tanx.ui.image.glide.RequestManager.ImageModelRequest<>(streamModelLoader);
    }

    public <T> com.alimm.tanx.ui.image.glide.RequestManager.VideoModelRequest<T> using(com.alimm.tanx.ui.image.glide.load.model.file_descriptor.FileDescriptorModelLoader<T> fileDescriptorModelLoader) {
        return new com.alimm.tanx.ui.image.glide.RequestManager.VideoModelRequest<>(fileDescriptorModelLoader);
    }
}
