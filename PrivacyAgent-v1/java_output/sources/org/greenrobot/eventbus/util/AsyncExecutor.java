package org.greenrobot.eventbus.util;

/* loaded from: classes26.dex */
public class AsyncExecutor {
    public final java.util.concurrent.Executor a;
    public final java.lang.reflect.Constructor<?> b;
    public final org.greenrobot.eventbus.EventBus c;
    public final java.lang.Object d;

    /* renamed from: org.greenrobot.eventbus.util.AsyncExecutor$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        public final /* synthetic */ org.greenrobot.eventbus.util.AsyncExecutor.RunnableEx n;

        public AnonymousClass1(org.greenrobot.eventbus.util.AsyncExecutor.RunnableEx runnableEx) {
            this.n = runnableEx;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.n.run();
            } catch (java.lang.Exception e) {
                try {
                    java.lang.Object newInstance = org.greenrobot.eventbus.util.AsyncExecutor.this.b.newInstance(e);
                    if (newInstance instanceof org.greenrobot.eventbus.util.HasExecutionScope) {
                        ((org.greenrobot.eventbus.util.HasExecutionScope) newInstance).setExecutionScope(org.greenrobot.eventbus.util.AsyncExecutor.this.d);
                    }
                    org.greenrobot.eventbus.util.AsyncExecutor.this.c.post(newInstance);
                } catch (java.lang.Exception e2) {
                    org.greenrobot.eventbus.util.AsyncExecutor.this.c.getLogger().log(java.util.logging.Level.SEVERE, "Original exception:", e);
                    throw new java.lang.RuntimeException("Could not create failure event", e2);
                }
            }
        }
    }

    public static class Builder {
        public java.util.concurrent.Executor a;
        public java.lang.Class<?> b;
        public org.greenrobot.eventbus.EventBus c;

        public Builder() {
        }

        public /* synthetic */ Builder(org.greenrobot.eventbus.util.AsyncExecutor.AnonymousClass1 anonymousClass1) {
            this();
        }

        public org.greenrobot.eventbus.util.AsyncExecutor build() {
            return buildForScope(null);
        }

        public org.greenrobot.eventbus.util.AsyncExecutor buildForScope(java.lang.Object obj) {
            if (this.c == null) {
                this.c = org.greenrobot.eventbus.EventBus.getDefault();
            }
            if (this.a == null) {
                this.a = java.util.concurrent.Executors.newCachedThreadPool();
            }
            if (this.b == null) {
                this.b = org.greenrobot.eventbus.util.ThrowableFailureEvent.class;
            }
            return new org.greenrobot.eventbus.util.AsyncExecutor(this.a, this.c, this.b, obj, null);
        }

        public org.greenrobot.eventbus.util.AsyncExecutor.Builder eventBus(org.greenrobot.eventbus.EventBus eventBus) {
            this.c = eventBus;
            return this;
        }

        public org.greenrobot.eventbus.util.AsyncExecutor.Builder failureEventType(java.lang.Class<?> cls) {
            this.b = cls;
            return this;
        }

        public org.greenrobot.eventbus.util.AsyncExecutor.Builder threadPool(java.util.concurrent.Executor executor) {
            this.a = executor;
            return this;
        }
    }

    public interface RunnableEx {
        void run() throws java.lang.Exception;
    }

    public AsyncExecutor(java.util.concurrent.Executor executor, org.greenrobot.eventbus.EventBus eventBus, java.lang.Class<?> cls, java.lang.Object obj) {
        this.a = executor;
        this.c = eventBus;
        this.d = obj;
        try {
            this.b = cls.getConstructor(java.lang.Throwable.class);
        } catch (java.lang.NoSuchMethodException e) {
            throw new java.lang.RuntimeException("Failure event class must have a constructor with one parameter of type Throwable", e);
        }
    }

    public /* synthetic */ AsyncExecutor(java.util.concurrent.Executor executor, org.greenrobot.eventbus.EventBus eventBus, java.lang.Class cls, java.lang.Object obj, org.greenrobot.eventbus.util.AsyncExecutor.AnonymousClass1 anonymousClass1) {
        this(executor, eventBus, cls, obj);
    }

    public static org.greenrobot.eventbus.util.AsyncExecutor.Builder builder() {
        return new org.greenrobot.eventbus.util.AsyncExecutor.Builder(null);
    }

    public static org.greenrobot.eventbus.util.AsyncExecutor create() {
        return new org.greenrobot.eventbus.util.AsyncExecutor.Builder(null).build();
    }

    public void execute(org.greenrobot.eventbus.util.AsyncExecutor.RunnableEx runnableEx) {
        this.a.execute(new org.greenrobot.eventbus.util.AsyncExecutor.AnonymousClass1(runnableEx));
    }
}
