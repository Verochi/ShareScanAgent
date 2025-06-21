package com.igexin.base.scheduler;

/* loaded from: classes22.dex */
public final class a implements com.igexin.base.scheduler.b.InterfaceC0367b, com.igexin.base.scheduler.c {
    private com.igexin.base.scheduler.b a;
    private java.util.Map<com.igexin.base.scheduler.BaseTask, java.util.concurrent.ScheduledFuture> b = new java.util.concurrent.ConcurrentHashMap();
    private final java.util.Set<java.lang.String> c = new java.util.HashSet();
    private final java.util.Map<java.lang.String, java.util.concurrent.LinkedBlockingQueue<com.igexin.base.scheduler.BaseTask>> d = new java.util.HashMap();

    public a() {
        com.igexin.base.scheduler.b bVar = new com.igexin.base.scheduler.b();
        this.a = bVar;
        bVar.a = this;
    }

    private java.util.concurrent.ScheduledFuture b(com.igexin.base.scheduler.BaseTask baseTask) {
        java.util.concurrent.ScheduledFuture<?> schedule;
        java.util.concurrent.ScheduledFuture scheduledFuture = this.b.get(baseTask);
        if (scheduledFuture != null) {
            if (scheduledFuture.cancel(false)) {
                this.b.remove(baseTask);
            }
            java.util.concurrent.BlockingQueue<java.lang.Runnable> queue = this.a.getQueue();
            if (queue != null) {
                queue.remove(scheduledFuture);
            }
        }
        long initDelay = baseTask.getInitDelay();
        if (baseTask.isPeriodic()) {
            long period = baseTask.getPeriod();
            schedule = period > 0 ? this.a.scheduleAtFixedRate(baseTask, initDelay, period, java.util.concurrent.TimeUnit.MILLISECONDS) : this.a.scheduleWithFixedDelay(baseTask, initDelay, -period, java.util.concurrent.TimeUnit.MILLISECONDS);
        } else {
            schedule = this.a.schedule(baseTask, initDelay, java.util.concurrent.TimeUnit.MILLISECONDS);
        }
        this.b.put(baseTask, schedule);
        return schedule;
    }

    @Override // com.igexin.base.scheduler.b.InterfaceC0367b
    public final synchronized void a(com.igexin.base.scheduler.BaseTask baseTask) {
        try {
            this.b.remove(baseTask);
            java.lang.String groupName = baseTask.getGroupName();
            if (!android.text.TextUtils.isEmpty(groupName)) {
                java.util.concurrent.LinkedBlockingQueue<com.igexin.base.scheduler.BaseTask> linkedBlockingQueue = this.d.get(groupName);
                if (linkedBlockingQueue != null && linkedBlockingQueue.size() > 0) {
                    b(linkedBlockingQueue.poll());
                    return;
                }
                this.c.remove(groupName);
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.igexin.base.scheduler.c
    public final void execute(com.igexin.base.scheduler.BaseTask baseTask) {
        try {
            baseTask.onRunTask();
            baseTask.done();
        } catch (java.lang.Throwable th) {
            baseTask.onException(th);
        }
    }

    @Override // com.igexin.base.scheduler.c
    public final synchronized void submit(com.igexin.base.scheduler.BaseTask baseTask) {
        try {
            java.lang.String groupName = baseTask.getGroupName();
            boolean z = false;
            if (!android.text.TextUtils.isEmpty(groupName)) {
                if (this.c.contains(groupName)) {
                    if (this.d.get(groupName) == null) {
                        this.d.put(groupName, new java.util.concurrent.LinkedBlockingQueue<>());
                    }
                    z = this.d.get(groupName).offer(baseTask);
                } else {
                    this.c.add(groupName);
                }
            }
            if (z) {
                return;
            }
            b(baseTask);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }
}
