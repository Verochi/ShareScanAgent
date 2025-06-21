package com.hihonor.push.sdk.tasks;

/* loaded from: classes22.dex */
public class TaskCompletionSource<TResult> {
    private final com.hihonor.push.sdk.v<TResult> task = new com.hihonor.push.sdk.v<>();

    public com.hihonor.push.sdk.tasks.Task<TResult> getTask() {
        return this.task;
    }

    public void setException(java.lang.Exception exc) {
        com.hihonor.push.sdk.v<TResult> vVar = this.task;
        synchronized (vVar.a) {
            if (!vVar.b) {
                vVar.b = true;
                vVar.e = exc;
                vVar.a.notifyAll();
                vVar.a();
            }
        }
    }

    public void setResult(TResult tresult) {
        com.hihonor.push.sdk.v<TResult> vVar = this.task;
        synchronized (vVar.a) {
            if (!vVar.b) {
                vVar.b = true;
                vVar.d = tresult;
                vVar.a.notifyAll();
                vVar.a();
            }
        }
    }
}
