package com.google.common.base;

@com.google.common.annotations.GwtIncompatible
/* loaded from: classes22.dex */
public class FinalizableReferenceQueue implements java.io.Closeable {
    public static final java.util.logging.Logger v = java.util.logging.Logger.getLogger(com.google.common.base.FinalizableReferenceQueue.class.getName());
    public static final java.lang.reflect.Method w = d(e(new com.google.common.base.FinalizableReferenceQueue.SystemLoader(), new com.google.common.base.FinalizableReferenceQueue.DecoupledLoader(), new com.google.common.base.FinalizableReferenceQueue.DirectLoader()));
    public final java.lang.ref.ReferenceQueue<java.lang.Object> n;
    public final java.lang.ref.PhantomReference<java.lang.Object> t;
    public final boolean u;

    public static class DecoupledLoader implements com.google.common.base.FinalizableReferenceQueue.FinalizerLoader {
        @Override // com.google.common.base.FinalizableReferenceQueue.FinalizerLoader
        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        public java.lang.Class<?> a() {
            try {
                return c(b()).loadClass("com.google.common.base.internal.Finalizer");
            } catch (java.lang.Exception e) {
                com.google.common.base.FinalizableReferenceQueue.v.log(java.util.logging.Level.WARNING, "Could not load Finalizer in its own class loader. Loading Finalizer in the current class loader instead. As a result, you will not be able to garbage collect this class loader. To support reclaiming this class loader, either resolve the underlying issue, or move Guava to your system class path.", (java.lang.Throwable) e);
                return null;
            }
        }

        public java.net.URL b() throws java.io.IOException {
            java.lang.String str = "com.google.common.base.internal.Finalizer".replace('.', '/') + ".class";
            java.net.URL resource = getClass().getClassLoader().getResource(str);
            if (resource == null) {
                throw new java.io.FileNotFoundException(str);
            }
            java.lang.String url = resource.toString();
            if (url.endsWith(str)) {
                return new java.net.URL(resource, url.substring(0, url.length() - str.length()));
            }
            throw new java.io.IOException("Unsupported path style: " + url);
        }

        public java.net.URLClassLoader c(java.net.URL url) {
            return new java.net.URLClassLoader(new java.net.URL[]{url}, null);
        }
    }

    public static class DirectLoader implements com.google.common.base.FinalizableReferenceQueue.FinalizerLoader {
        @Override // com.google.common.base.FinalizableReferenceQueue.FinalizerLoader
        public java.lang.Class<?> a() {
            try {
                java.util.logging.Logger logger = com.google.common.base.internal.Finalizer.v;
                return com.google.common.base.internal.Finalizer.class;
            } catch (java.lang.ClassNotFoundException e) {
                throw new java.lang.AssertionError(e);
            }
        }
    }

    public interface FinalizerLoader {
        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        java.lang.Class<?> a();
    }

    public static class SystemLoader implements com.google.common.base.FinalizableReferenceQueue.FinalizerLoader {

        @com.google.common.annotations.VisibleForTesting
        public static boolean a;

        @Override // com.google.common.base.FinalizableReferenceQueue.FinalizerLoader
        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        public java.lang.Class<?> a() {
            if (a) {
                return null;
            }
            try {
                java.lang.ClassLoader systemClassLoader = java.lang.ClassLoader.getSystemClassLoader();
                if (systemClassLoader != null) {
                    try {
                        return systemClassLoader.loadClass("com.google.common.base.internal.Finalizer");
                    } catch (java.lang.ClassNotFoundException unused) {
                    }
                }
                return null;
            } catch (java.lang.SecurityException unused2) {
                com.google.common.base.FinalizableReferenceQueue.v.info("Not allowed to access system class loader.");
                return null;
            }
        }
    }

    public FinalizableReferenceQueue() {
        java.lang.ref.ReferenceQueue<java.lang.Object> referenceQueue = new java.lang.ref.ReferenceQueue<>();
        this.n = referenceQueue;
        java.lang.ref.PhantomReference<java.lang.Object> phantomReference = new java.lang.ref.PhantomReference<>(this, referenceQueue);
        this.t = phantomReference;
        boolean z = false;
        try {
            w.invoke(null, com.google.common.base.FinalizableReference.class, referenceQueue, phantomReference);
            z = true;
        } catch (java.lang.IllegalAccessException e) {
            throw new java.lang.AssertionError(e);
        } catch (java.lang.Throwable th) {
            v.log(java.util.logging.Level.INFO, "Failed to start reference finalizer thread. Reference cleanup will only occur when new references are created.", th);
        }
        this.u = z;
    }

    public static java.lang.reflect.Method d(java.lang.Class<?> cls) {
        try {
            return cls.getMethod("startFinalizer", java.lang.Class.class, java.lang.ref.ReferenceQueue.class, java.lang.ref.PhantomReference.class);
        } catch (java.lang.NoSuchMethodException e) {
            throw new java.lang.AssertionError(e);
        }
    }

    public static java.lang.Class<?> e(com.google.common.base.FinalizableReferenceQueue.FinalizerLoader... finalizerLoaderArr) {
        for (com.google.common.base.FinalizableReferenceQueue.FinalizerLoader finalizerLoader : finalizerLoaderArr) {
            java.lang.Class<?> a = finalizerLoader.a();
            if (a != null) {
                return a;
            }
        }
        throw new java.lang.AssertionError();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void c() {
        if (this.u) {
            return;
        }
        while (true) {
            java.lang.ref.Reference<? extends java.lang.Object> poll = this.n.poll();
            if (poll == 0) {
                return;
            }
            poll.clear();
            try {
                ((com.google.common.base.FinalizableReference) poll).finalizeReferent();
            } catch (java.lang.Throwable th) {
                v.log(java.util.logging.Level.SEVERE, "Error cleaning up after reference.", th);
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.t.enqueue();
        c();
    }
}
