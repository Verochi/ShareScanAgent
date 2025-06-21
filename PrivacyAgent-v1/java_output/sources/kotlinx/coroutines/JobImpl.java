package kotlinx.coroutines;

@kotlin.Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0010\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0003H\u0003R\u001a\u0010\r\u001a\u00020\u00038\u0010X\u0090\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u000f\u001a\u00020\u00038PX\u0090\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\f¨\u0006\u0014"}, d2 = {"Lkotlinx/coroutines/JobImpl;", "Lkotlinx/coroutines/JobSupport;", "Lkotlinx/coroutines/CompletableJob;", "", com.anythink.expressad.foundation.d.c.bX, "", "exception", "completeExceptionally", "D", "t", "Z", "getHandlesException$kotlinx_coroutines_core", "()Z", "handlesException", "getOnCancelComplete$kotlinx_coroutines_core", "onCancelComplete", "Lkotlinx/coroutines/Job;", "parent", "<init>", "(Lkotlinx/coroutines/Job;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes15.dex */
public class JobImpl extends kotlinx.coroutines.JobSupport implements kotlinx.coroutines.CompletableJob {

    /* renamed from: t, reason: from kotlin metadata */
    public final boolean handlesException;

    public JobImpl(@org.jetbrains.annotations.Nullable kotlinx.coroutines.Job job) {
        super(true);
        initParentJob(job);
        this.handlesException = D();
    }

    public final boolean D() {
        kotlinx.coroutines.ChildHandle parentHandle$kotlinx_coroutines_core = getParentHandle$kotlinx_coroutines_core();
        kotlinx.coroutines.ChildHandleNode childHandleNode = parentHandle$kotlinx_coroutines_core instanceof kotlinx.coroutines.ChildHandleNode ? (kotlinx.coroutines.ChildHandleNode) parentHandle$kotlinx_coroutines_core : null;
        if (childHandleNode == null) {
            return false;
        }
        kotlinx.coroutines.JobSupport job = childHandleNode.getJob();
        while (!job.getHandlesException()) {
            kotlinx.coroutines.ChildHandle parentHandle$kotlinx_coroutines_core2 = job.getParentHandle$kotlinx_coroutines_core();
            kotlinx.coroutines.ChildHandleNode childHandleNode2 = parentHandle$kotlinx_coroutines_core2 instanceof kotlinx.coroutines.ChildHandleNode ? (kotlinx.coroutines.ChildHandleNode) parentHandle$kotlinx_coroutines_core2 : null;
            if (childHandleNode2 == null) {
                return false;
            }
            job = childHandleNode2.getJob();
        }
        return true;
    }

    @Override // kotlinx.coroutines.CompletableJob
    public boolean complete() {
        return makeCompleting$kotlinx_coroutines_core(kotlin.Unit.INSTANCE);
    }

    @Override // kotlinx.coroutines.CompletableJob
    public boolean completeExceptionally(@org.jetbrains.annotations.NotNull java.lang.Throwable exception) {
        return makeCompleting$kotlinx_coroutines_core(new kotlinx.coroutines.CompletedExceptionally(exception, false, 2, null));
    }

    @Override // kotlinx.coroutines.JobSupport
    /* renamed from: getHandlesException$kotlinx_coroutines_core, reason: from getter */
    public boolean getHandlesException() {
        return this.handlesException;
    }

    @Override // kotlinx.coroutines.JobSupport
    public boolean getOnCancelComplete$kotlinx_coroutines_core() {
        return true;
    }
}
