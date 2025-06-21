package com.alipay.android.phone.mrpc.core;

/* loaded from: classes.dex */
public final class m extends java.util.concurrent.FutureTask<com.alipay.android.phone.mrpc.core.u> {
    public final /* synthetic */ com.alipay.android.phone.mrpc.core.q a;
    public final /* synthetic */ com.alipay.android.phone.mrpc.core.l b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(com.alipay.android.phone.mrpc.core.l lVar, java.util.concurrent.Callable callable, com.alipay.android.phone.mrpc.core.q qVar) {
        super(callable);
        this.b = lVar;
        this.a = qVar;
    }

    @Override // java.util.concurrent.FutureTask
    public final void done() {
        com.alipay.android.phone.mrpc.core.o a = this.a.a();
        if (a.f() == null) {
            super.done();
            return;
        }
        try {
            get();
            if (isCancelled() || a.h()) {
                a.g();
                if (isCancelled() && isDone()) {
                    return;
                }
                cancel(false);
            }
        } catch (java.lang.InterruptedException e) {
            e.toString();
        } catch (java.util.concurrent.CancellationException unused) {
            a.g();
        } catch (java.util.concurrent.ExecutionException e2) {
            if (e2.getCause() == null || !(e2.getCause() instanceof com.alipay.android.phone.mrpc.core.HttpException)) {
                e2.toString();
                return;
            }
            com.alipay.android.phone.mrpc.core.HttpException httpException = (com.alipay.android.phone.mrpc.core.HttpException) e2.getCause();
            httpException.getCode();
            httpException.getMsg();
        } catch (java.lang.Throwable th) {
            throw new java.lang.RuntimeException("An error occured while executing http request", th);
        }
    }
}
