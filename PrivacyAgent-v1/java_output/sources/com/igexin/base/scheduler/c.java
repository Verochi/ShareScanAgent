package com.igexin.base.scheduler;

/* loaded from: classes22.dex */
public interface c<T extends com.igexin.base.scheduler.BaseTask> {
    void execute(T t);

    void submit(T t);
}
