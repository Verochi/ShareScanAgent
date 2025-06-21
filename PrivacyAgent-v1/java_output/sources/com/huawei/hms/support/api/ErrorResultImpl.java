package com.huawei.hms.support.api;

/* loaded from: classes22.dex */
public abstract class ErrorResultImpl<R extends com.huawei.hms.support.api.client.Result> extends com.huawei.hms.support.api.client.PendingResult<R> {
    private R a = null;
    private int b;

    public class a implements java.lang.Runnable {
        final /* synthetic */ com.huawei.hms.support.api.client.ResultCallback a;
        final /* synthetic */ com.huawei.hms.support.api.ErrorResultImpl b;

        public a(com.huawei.hms.support.api.client.ResultCallback resultCallback, com.huawei.hms.support.api.ErrorResultImpl errorResultImpl) {
            this.a = resultCallback;
            this.b = errorResultImpl;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.huawei.hms.support.api.client.ResultCallback resultCallback = this.a;
            com.huawei.hms.support.api.ErrorResultImpl errorResultImpl = com.huawei.hms.support.api.ErrorResultImpl.this;
            resultCallback.onResult(errorResultImpl.a(errorResultImpl.b, this.b));
        }
    }

    public ErrorResultImpl(int i) {
        this.b = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public R a(int i, com.huawei.hms.support.api.ErrorResultImpl errorResultImpl) {
        java.lang.reflect.Type genericSuperclass = errorResultImpl.getClass().getGenericSuperclass();
        if (genericSuperclass == null) {
            return null;
        }
        try {
            R r = (R) com.huawei.hms.support.gentyref.GenericTypeReflector.getType(((java.lang.reflect.ParameterizedType) genericSuperclass).getActualTypeArguments()[0]).newInstance();
            this.a = r;
            r.setStatus(new com.huawei.hms.support.api.client.Status(i));
        } catch (java.lang.IllegalAccessException unused) {
            com.huawei.hms.support.log.HMSLog.e("ErrorResultImpl", "IllegalAccessException");
        } catch (java.lang.InstantiationException unused2) {
            com.huawei.hms.support.log.HMSLog.e("ErrorResultImpl", "InstantiationException");
        }
        return this.a;
    }

    @Override // com.huawei.hms.support.api.client.PendingResult
    public final R await() {
        return await(0L, null);
    }

    @Override // com.huawei.hms.support.api.client.PendingResult
    public R await(long j, java.util.concurrent.TimeUnit timeUnit) {
        if (android.os.Looper.myLooper() != android.os.Looper.getMainLooper()) {
            return a(this.b, this);
        }
        throw new java.lang.IllegalStateException("await must not be called on the UI thread");
    }

    @Override // com.huawei.hms.support.api.client.PendingResult
    @java.lang.Deprecated
    public void cancel() {
    }

    @Override // com.huawei.hms.support.api.client.PendingResult
    @java.lang.Deprecated
    public boolean isCanceled() {
        return false;
    }

    public void postRunnable(android.os.Looper looper, com.huawei.hms.support.api.client.ResultCallback<R> resultCallback, com.huawei.hms.support.api.ErrorResultImpl errorResultImpl) {
        if (looper == null) {
            looper = android.os.Looper.myLooper();
        }
        new android.os.Handler(looper).post(new com.huawei.hms.support.api.ErrorResultImpl.a(resultCallback, errorResultImpl));
    }

    @Override // com.huawei.hms.support.api.client.PendingResult
    public final void setResultCallback(android.os.Looper looper, com.huawei.hms.support.api.client.ResultCallback<R> resultCallback) {
        postRunnable(looper, resultCallback, this);
    }

    @Override // com.huawei.hms.support.api.client.PendingResult
    public final void setResultCallback(com.huawei.hms.support.api.client.ResultCallback<R> resultCallback) {
        setResultCallback(android.os.Looper.getMainLooper(), resultCallback);
    }

    @Override // com.huawei.hms.support.api.client.PendingResult
    @java.lang.Deprecated
    public void setResultCallback(com.huawei.hms.support.api.client.ResultCallback<R> resultCallback, long j, java.util.concurrent.TimeUnit timeUnit) {
        setResultCallback(resultCallback);
    }
}
