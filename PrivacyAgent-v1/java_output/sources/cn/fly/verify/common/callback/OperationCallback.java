package cn.fly.verify.common.callback;

/* loaded from: classes.dex */
public abstract class OperationCallback<T> {
    private java.util.concurrent.atomic.AtomicBoolean canceled;

    public boolean isCanceled() {
        java.util.concurrent.atomic.AtomicBoolean atomicBoolean = this.canceled;
        return atomicBoolean != null && atomicBoolean.get();
    }

    public abstract void onComplete(T t);

    public abstract void onFailure(cn.fly.verify.common.exception.VerifyException verifyException);

    public void setCanceled(boolean z) {
        this.canceled = new java.util.concurrent.atomic.AtomicBoolean(z);
    }
}
