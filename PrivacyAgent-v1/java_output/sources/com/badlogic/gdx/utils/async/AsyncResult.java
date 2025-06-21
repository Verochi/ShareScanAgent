package com.badlogic.gdx.utils.async;

/* loaded from: classes12.dex */
public class AsyncResult<T> {
    public final java.util.concurrent.Future<T> a;

    public AsyncResult(java.util.concurrent.Future<T> future) {
        this.a = future;
    }

    public T get() {
        try {
            return this.a.get();
        } catch (java.lang.InterruptedException unused) {
            return null;
        } catch (java.util.concurrent.ExecutionException e) {
            throw new com.badlogic.gdx.utils.GdxRuntimeException(e.getCause());
        }
    }

    public boolean isDone() {
        return this.a.isDone();
    }
}
