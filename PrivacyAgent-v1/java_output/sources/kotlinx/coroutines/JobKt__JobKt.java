package kotlinx.coroutines;

/* JADX INFO: Access modifiers changed from: package-private */
@kotlin.Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\u001a\u0012\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010\u0000\u001a\u001b\u0010\u0004\u001a\u00020\u00002\n\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\u0007¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0019\u0010\n\u001a\u00020\t2\u000e\b\u0004\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0087\b\u001a\u0014\u0010\f\u001a\u00020\t*\u00020\u00002\u0006\u0010\u000b\u001a\u00020\tH\u0000\u001a\u0017\u0010\r\u001a\u00020\u0007*\u00020\u0000H\u0086@ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000e\u001a\u001c\u0010\u0012\u001a\u00020\u0007*\u00020\u00002\u0010\b\u0002\u0010\u0011\u001a\n\u0018\u00010\u000fj\u0004\u0018\u0001`\u0010\u001a\f\u0010\u0013\u001a\u00020\u0007*\u00020\u0000H\u0007\u001a\u0018\u0010\u0015\u001a\u00020\u0007*\u00020\u00002\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0014H\u0007\u001a\u001c\u0010\u0017\u001a\u00020\u0007*\u00020\u00162\u0010\b\u0002\u0010\u0011\u001a\n\u0018\u00010\u000fj\u0004\u0018\u0001`\u0010\u001a\f\u0010\u0018\u001a\u00020\u0007*\u00020\u0016H\u0007\u001a\n\u0010\u0019\u001a\u00020\u0007*\u00020\u0000\u001a\n\u0010\u001a\u001a\u00020\u0007*\u00020\u0016\u001a\u001e\u0010\u001d\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001b2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0014\u001a\u0018\u0010\u001f\u001a\u00020\u001e*\u00020\u00162\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0014H\u0007\u001a\u001c\u0010 \u001a\u00020\u0007*\u00020\u00162\u0010\b\u0002\u0010\u0011\u001a\n\u0018\u00010\u000fj\u0004\u0018\u0001`\u0010\u001a\f\u0010!\u001a\u00020\u0007*\u00020\u0016H\u0007\u001a\u0018\u0010\"\u001a\u00020\u0007*\u00020\u00162\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0014H\u0007\u001a\u001d\u0010$\u001a\u00020\u0014*\u0004\u0018\u00010\u00142\u0006\u0010#\u001a\u00020\u0000H\u0002¢\u0006\u0004\b$\u0010%\"\u0015\u0010(\u001a\u00020\u001e*\u00020\u00168F¢\u0006\u0006\u001a\u0004\b&\u0010'\"\u0015\u0010#\u001a\u00020\u0000*\u00020\u00168F¢\u0006\u0006\u001a\u0004\b)\u0010*\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006+"}, d2 = {"Lkotlinx/coroutines/Job;", "parent", "Lkotlinx/coroutines/CompletableJob;", "b", "c", "(Lkotlinx/coroutines/Job;)Lkotlinx/coroutines/Job;", "Lkotlin/Function0;", "", "block", "Lkotlinx/coroutines/DisposableHandle;", "a", "handle", "x", com.anythink.expressad.d.a.b.dH, "(Lkotlinx/coroutines/Job;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "cause", "s", "q", "", "r", "Lkotlin/coroutines/CoroutineContext;", "g", "f", com.umeng.analytics.pro.bo.aJ, "y", "", "message", "h", "", "i", "p", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.AD_COUNT, "o", "job", "C", "(Ljava/lang/Throwable;Lkotlinx/coroutines/Job;)Ljava/lang/Throwable;", "B", "(Lkotlin/coroutines/CoroutineContext;)Z", "isActive", androidx.exifinterface.media.ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/Job;", "kotlinx-coroutines-core"}, k = 5, mv = {1, 5, 1}, xs = "kotlinx/coroutines/JobKt")
/* loaded from: classes15.dex */
public final /* synthetic */ class JobKt__JobKt {
    @org.jetbrains.annotations.NotNull
    public static final kotlinx.coroutines.Job A(@org.jetbrains.annotations.NotNull kotlin.coroutines.CoroutineContext coroutineContext) {
        kotlinx.coroutines.Job job = (kotlinx.coroutines.Job) coroutineContext.get(kotlinx.coroutines.Job.INSTANCE);
        if (job != null) {
            return job;
        }
        throw new java.lang.IllegalStateException(kotlin.jvm.internal.Intrinsics.stringPlus("Current context doesn't contain Job in it: ", coroutineContext).toString());
    }

    public static final boolean B(@org.jetbrains.annotations.NotNull kotlin.coroutines.CoroutineContext coroutineContext) {
        kotlinx.coroutines.Job job = (kotlinx.coroutines.Job) coroutineContext.get(kotlinx.coroutines.Job.INSTANCE);
        return kotlin.jvm.internal.Intrinsics.areEqual(job == null ? null : java.lang.Boolean.valueOf(job.isActive()), java.lang.Boolean.TRUE);
    }

    public static final java.lang.Throwable C(java.lang.Throwable th, kotlinx.coroutines.Job job) {
        return th == null ? new kotlinx.coroutines.JobCancellationException("Job was cancelled", null, job) : th;
    }

    @kotlinx.coroutines.InternalCoroutinesApi
    @org.jetbrains.annotations.NotNull
    public static final kotlinx.coroutines.DisposableHandle a(@org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function0<kotlin.Unit> function0) {
        return new kotlinx.coroutines.JobKt__JobKt$DisposableHandle$1(function0);
    }

    @org.jetbrains.annotations.NotNull
    public static final kotlinx.coroutines.CompletableJob b(@org.jetbrains.annotations.Nullable kotlinx.coroutines.Job job) {
        return new kotlinx.coroutines.JobImpl(job);
    }

    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    @kotlin.jvm.JvmName(name = "Job")
    public static final /* synthetic */ kotlinx.coroutines.Job c(kotlinx.coroutines.Job job) {
        return kotlinx.coroutines.JobKt.Job(job);
    }

    public static /* synthetic */ kotlinx.coroutines.CompletableJob d(kotlinx.coroutines.Job job, int i, java.lang.Object obj) {
        if ((i & 1) != 0) {
            job = null;
        }
        return kotlinx.coroutines.JobKt.Job(job);
    }

    public static /* synthetic */ kotlinx.coroutines.Job e(kotlinx.coroutines.Job job, int i, java.lang.Object obj) {
        if ((i & 1) != 0) {
            job = null;
        }
        return c(job);
    }

    public static final void g(@org.jetbrains.annotations.NotNull kotlin.coroutines.CoroutineContext coroutineContext, @org.jetbrains.annotations.Nullable java.util.concurrent.CancellationException cancellationException) {
        kotlinx.coroutines.Job job = (kotlinx.coroutines.Job) coroutineContext.get(kotlinx.coroutines.Job.INSTANCE);
        if (job == null) {
            return;
        }
        job.cancel(cancellationException);
    }

    public static final void h(@org.jetbrains.annotations.NotNull kotlinx.coroutines.Job job, @org.jetbrains.annotations.NotNull java.lang.String str, @org.jetbrains.annotations.Nullable java.lang.Throwable th) {
        job.cancel(kotlinx.coroutines.ExceptionsKt.CancellationException(str, th));
    }

    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public static final /* synthetic */ boolean i(kotlin.coroutines.CoroutineContext coroutineContext, java.lang.Throwable th) {
        kotlin.coroutines.CoroutineContext.Element element = coroutineContext.get(kotlinx.coroutines.Job.INSTANCE);
        kotlinx.coroutines.JobSupport jobSupport = element instanceof kotlinx.coroutines.JobSupport ? (kotlinx.coroutines.JobSupport) element : null;
        if (jobSupport == null) {
            return false;
        }
        jobSupport.cancelInternal(C(th, jobSupport));
        return true;
    }

    public static /* synthetic */ void j(kotlin.coroutines.CoroutineContext coroutineContext, java.util.concurrent.CancellationException cancellationException, int i, java.lang.Object obj) {
        if ((i & 1) != 0) {
            cancellationException = null;
        }
        kotlinx.coroutines.JobKt.cancel(coroutineContext, cancellationException);
    }

    public static /* synthetic */ void k(kotlinx.coroutines.Job job, java.lang.String str, java.lang.Throwable th, int i, java.lang.Object obj) {
        if ((i & 2) != 0) {
            th = null;
        }
        kotlinx.coroutines.JobKt.cancel(job, str, th);
    }

    public static /* synthetic */ boolean l(kotlin.coroutines.CoroutineContext coroutineContext, java.lang.Throwable th, int i, java.lang.Object obj) {
        if ((i & 1) != 0) {
            th = null;
        }
        return i(coroutineContext, th);
    }

    @org.jetbrains.annotations.Nullable
    public static final java.lang.Object m(@org.jetbrains.annotations.NotNull kotlinx.coroutines.Job job, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        java.lang.Object coroutine_suspended;
        kotlinx.coroutines.Job.DefaultImpls.cancel$default(job, (java.util.concurrent.CancellationException) null, 1, (java.lang.Object) null);
        java.lang.Object join = job.join(continuation);
        coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return join == coroutine_suspended ? join : kotlin.Unit.INSTANCE;
    }

    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public static final /* synthetic */ void o(kotlin.coroutines.CoroutineContext coroutineContext, java.lang.Throwable th) {
        kotlinx.coroutines.Job job = (kotlinx.coroutines.Job) coroutineContext.get(kotlinx.coroutines.Job.INSTANCE);
        if (job == null) {
            return;
        }
        for (kotlinx.coroutines.Job job2 : job.getChildren()) {
            kotlinx.coroutines.JobSupport jobSupport = job2 instanceof kotlinx.coroutines.JobSupport ? (kotlinx.coroutines.JobSupport) job2 : null;
            if (jobSupport != null) {
                jobSupport.cancelInternal(C(th, job));
            }
        }
    }

    public static final void p(@org.jetbrains.annotations.NotNull kotlin.coroutines.CoroutineContext coroutineContext, @org.jetbrains.annotations.Nullable java.util.concurrent.CancellationException cancellationException) {
        kotlinx.coroutines.Job job = (kotlinx.coroutines.Job) coroutineContext.get(kotlinx.coroutines.Job.INSTANCE);
        if (job == null) {
            return;
        }
        java.util.Iterator<kotlinx.coroutines.Job> it = job.getChildren().iterator();
        while (it.hasNext()) {
            it.next().cancel(cancellationException);
        }
    }

    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public static final /* synthetic */ void r(kotlinx.coroutines.Job job, java.lang.Throwable th) {
        for (kotlinx.coroutines.Job job2 : job.getChildren()) {
            kotlinx.coroutines.JobSupport jobSupport = job2 instanceof kotlinx.coroutines.JobSupport ? (kotlinx.coroutines.JobSupport) job2 : null;
            if (jobSupport != null) {
                jobSupport.cancelInternal(C(th, job));
            }
        }
    }

    public static final void s(@org.jetbrains.annotations.NotNull kotlinx.coroutines.Job job, @org.jetbrains.annotations.Nullable java.util.concurrent.CancellationException cancellationException) {
        java.util.Iterator<kotlinx.coroutines.Job> it = job.getChildren().iterator();
        while (it.hasNext()) {
            it.next().cancel(cancellationException);
        }
    }

    public static /* synthetic */ void t(kotlin.coroutines.CoroutineContext coroutineContext, java.lang.Throwable th, int i, java.lang.Object obj) {
        if ((i & 1) != 0) {
            th = null;
        }
        o(coroutineContext, th);
    }

    public static /* synthetic */ void u(kotlin.coroutines.CoroutineContext coroutineContext, java.util.concurrent.CancellationException cancellationException, int i, java.lang.Object obj) {
        if ((i & 1) != 0) {
            cancellationException = null;
        }
        kotlinx.coroutines.JobKt.cancelChildren(coroutineContext, cancellationException);
    }

    public static /* synthetic */ void v(kotlinx.coroutines.Job job, java.lang.Throwable th, int i, java.lang.Object obj) {
        if ((i & 1) != 0) {
            th = null;
        }
        r(job, th);
    }

    public static /* synthetic */ void w(kotlinx.coroutines.Job job, java.util.concurrent.CancellationException cancellationException, int i, java.lang.Object obj) {
        if ((i & 1) != 0) {
            cancellationException = null;
        }
        kotlinx.coroutines.JobKt.cancelChildren(job, cancellationException);
    }

    @org.jetbrains.annotations.NotNull
    public static final kotlinx.coroutines.DisposableHandle x(@org.jetbrains.annotations.NotNull kotlinx.coroutines.Job job, @org.jetbrains.annotations.NotNull kotlinx.coroutines.DisposableHandle disposableHandle) {
        return job.invokeOnCompletion(new kotlinx.coroutines.DisposeOnCompletion(disposableHandle));
    }

    public static final void y(@org.jetbrains.annotations.NotNull kotlin.coroutines.CoroutineContext coroutineContext) {
        kotlinx.coroutines.Job job = (kotlinx.coroutines.Job) coroutineContext.get(kotlinx.coroutines.Job.INSTANCE);
        if (job == null) {
            return;
        }
        kotlinx.coroutines.JobKt.ensureActive(job);
    }

    public static final void z(@org.jetbrains.annotations.NotNull kotlinx.coroutines.Job job) {
        if (!job.isActive()) {
            throw job.getCancellationException();
        }
    }
}
