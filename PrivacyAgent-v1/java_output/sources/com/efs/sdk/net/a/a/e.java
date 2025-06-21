package com.efs.sdk.net.a.a;

/* loaded from: classes22.dex */
public final class e extends java.io.FilterOutputStream {
    private static final java.util.concurrent.ExecutorService b = java.util.concurrent.Executors.newCachedThreadPool();
    private final java.util.concurrent.Future<java.lang.Void> a;

    public static class a implements java.util.concurrent.Callable<java.lang.Void> {
        private final java.io.InputStream a;
        private final java.io.OutputStream b;

        public a(java.io.InputStream inputStream, java.io.OutputStream outputStream) {
            this.a = inputStream;
            this.b = outputStream;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public java.lang.Void call() {
            java.util.zip.GZIPInputStream gZIPInputStream = new java.util.zip.GZIPInputStream(this.a);
            try {
                com.efs.sdk.net.a.a.i.a(gZIPInputStream, this.b, new byte[1024]);
                gZIPInputStream.close();
                this.b.close();
                return null;
            } catch (java.lang.Throwable th) {
                gZIPInputStream.close();
                this.b.close();
                throw th;
            }
        }
    }

    private e(java.io.OutputStream outputStream, java.util.concurrent.Future<java.lang.Void> future) {
        super(outputStream);
        this.a = future;
    }

    public static com.efs.sdk.net.a.a.e a(java.io.OutputStream outputStream) {
        java.io.PipedInputStream pipedInputStream = new java.io.PipedInputStream();
        return new com.efs.sdk.net.a.a.e(new java.io.PipedOutputStream(pipedInputStream), b.submit(new com.efs.sdk.net.a.a.e.a(pipedInputStream, outputStream)));
    }

    private static <T> T a(java.util.concurrent.Future<T> future) {
        while (true) {
            try {
                return future.get();
            } catch (java.lang.InterruptedException unused) {
            } catch (java.util.concurrent.ExecutionException e) {
                java.lang.Throwable cause = e.getCause();
                com.efs.sdk.net.a.a.d.a(cause, java.io.IOException.class);
                com.efs.sdk.net.a.a.d.a(cause, java.lang.Error.class);
                com.efs.sdk.net.a.a.d.a(cause, java.lang.RuntimeException.class);
                throw new java.lang.RuntimeException(cause);
            }
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        try {
            super.close();
            try {
            } catch (java.io.IOException e) {
                throw e;
            }
        } finally {
            try {
                a(this.a);
            } catch (java.io.IOException unused) {
            }
        }
    }
}
