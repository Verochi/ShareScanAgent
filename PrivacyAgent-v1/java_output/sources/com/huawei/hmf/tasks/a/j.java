package com.huawei.hmf.tasks.a;

/* loaded from: classes22.dex */
public final class j {

    /* renamed from: com.huawei.hmf.tasks.a.j$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        public final /* synthetic */ com.huawei.hmf.tasks.TaskCompletionSource n;
        public final /* synthetic */ java.util.concurrent.Callable t;

        public AnonymousClass1(com.huawei.hmf.tasks.TaskCompletionSource taskCompletionSource, java.util.concurrent.Callable callable) {
            this.n = taskCompletionSource;
            this.t = callable;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                this.n.setResult(this.t.call());
            } catch (java.lang.Exception e) {
                this.n.setException(e);
            }
        }
    }

    /* renamed from: com.huawei.hmf.tasks.a.j$2, reason: invalid class name */
    public static class AnonymousClass2 implements com.huawei.hmf.tasks.Continuation<java.lang.Void, java.util.List<com.huawei.hmf.tasks.Task<?>>> {
        public final /* synthetic */ java.util.Collection a;

        public AnonymousClass2(java.util.Collection collection) {
            this.a = collection;
        }

        @Override // com.huawei.hmf.tasks.Continuation
        public final /* synthetic */ java.util.List<com.huawei.hmf.tasks.Task<?>> then(com.huawei.hmf.tasks.Task<java.lang.Void> task) throws java.lang.Exception {
            java.util.ArrayList arrayList = new java.util.ArrayList(this.a.size());
            arrayList.addAll(this.a);
            return arrayList;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [TResult] */
    /* renamed from: com.huawei.hmf.tasks.a.j$3, reason: invalid class name */
    public static class AnonymousClass3<TResult> implements com.huawei.hmf.tasks.Continuation<java.lang.Void, java.util.List<TResult>> {
        public final /* synthetic */ java.util.Collection a;

        public AnonymousClass3(java.util.Collection collection) {
            this.a = collection;
        }

        @Override // com.huawei.hmf.tasks.Continuation
        public final /* synthetic */ java.lang.Object then(com.huawei.hmf.tasks.Task<java.lang.Void> task) throws java.lang.Exception {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            java.util.Iterator it = this.a.iterator();
            while (it.hasNext()) {
                arrayList.add(((com.huawei.hmf.tasks.Task) it.next()).getResult());
            }
            return arrayList;
        }
    }

    public static class a<TResult> implements com.huawei.hmf.tasks.OnCanceledListener, com.huawei.hmf.tasks.OnFailureListener, com.huawei.hmf.tasks.OnSuccessListener<TResult> {
        public final java.util.concurrent.CountDownLatch a = new java.util.concurrent.CountDownLatch(1);

        @Override // com.huawei.hmf.tasks.OnCanceledListener
        public final void onCanceled() {
            this.a.countDown();
        }

        @Override // com.huawei.hmf.tasks.OnFailureListener
        public final void onFailure(java.lang.Exception exc) {
            this.a.countDown();
        }

        @Override // com.huawei.hmf.tasks.OnSuccessListener
        public final void onSuccess(TResult tresult) {
            this.a.countDown();
        }
    }

    public static <TResult> com.huawei.hmf.tasks.Task<TResult> a(TResult tresult) {
        com.huawei.hmf.tasks.TaskCompletionSource taskCompletionSource = new com.huawei.hmf.tasks.TaskCompletionSource();
        taskCompletionSource.setResult(tresult);
        return taskCompletionSource.getTask();
    }

    public static com.huawei.hmf.tasks.Task<java.util.List<com.huawei.hmf.tasks.Task<?>>> a(java.util.Collection<? extends com.huawei.hmf.tasks.Task<?>> collection) {
        return c(collection).continueWith(new com.huawei.hmf.tasks.a.j.AnonymousClass2(collection));
    }

    public static <TResult> TResult a(com.huawei.hmf.tasks.Task<TResult> task) throws java.util.concurrent.ExecutionException {
        if (task.isSuccessful()) {
            return task.getResult();
        }
        throw new java.util.concurrent.ExecutionException(task.getException());
    }

    public static void a(java.lang.String str) {
        if (android.os.Looper.myLooper() == android.os.Looper.getMainLooper()) {
            throw new java.lang.IllegalStateException(str);
        }
    }

    public static <TResult> com.huawei.hmf.tasks.Task<java.util.List<TResult>> b(java.util.Collection<? extends com.huawei.hmf.tasks.Task<?>> collection) {
        return (com.huawei.hmf.tasks.Task<java.util.List<TResult>>) c(collection).continueWith(new com.huawei.hmf.tasks.a.j.AnonymousClass3(collection));
    }

    public static com.huawei.hmf.tasks.Task<java.lang.Void> c(java.util.Collection<? extends com.huawei.hmf.tasks.Task<?>> collection) {
        if (collection.isEmpty()) {
            return a((java.lang.Object) null);
        }
        java.util.Iterator<? extends com.huawei.hmf.tasks.Task<?>> it = collection.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                throw new java.lang.NullPointerException("task can not is null");
            }
        }
        com.huawei.hmf.tasks.a.i iVar = new com.huawei.hmf.tasks.a.i();
        com.huawei.hmf.tasks.a.e eVar = new com.huawei.hmf.tasks.a.e(collection.size(), iVar);
        for (com.huawei.hmf.tasks.Task<?> task : collection) {
            task.addOnSuccessListener(com.huawei.hmf.tasks.TaskExecutors.immediate(), eVar);
            task.addOnFailureListener(com.huawei.hmf.tasks.TaskExecutors.immediate(), eVar);
            task.addOnCanceledListener(com.huawei.hmf.tasks.TaskExecutors.immediate(), eVar);
        }
        return iVar;
    }

    public final <TResult> com.huawei.hmf.tasks.Task<TResult> a(java.util.concurrent.Executor executor, java.util.concurrent.Callable<TResult> callable) {
        com.huawei.hmf.tasks.TaskCompletionSource taskCompletionSource = new com.huawei.hmf.tasks.TaskCompletionSource();
        try {
            executor.execute(new com.huawei.hmf.tasks.a.j.AnonymousClass1(taskCompletionSource, callable));
        } catch (java.lang.Exception e) {
            taskCompletionSource.setException(e);
        }
        return taskCompletionSource.getTask();
    }
}
