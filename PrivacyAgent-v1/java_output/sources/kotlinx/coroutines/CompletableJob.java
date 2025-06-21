package kotlinx.coroutines;

@kotlin.Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&¨\u0006\u0007"}, d2 = {"Lkotlinx/coroutines/CompletableJob;", "Lkotlinx/coroutines/Job;", com.anythink.expressad.foundation.d.c.bX, "", "completeExceptionally", "exception", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes15.dex */
public interface CompletableJob extends kotlinx.coroutines.Job {

    @kotlin.Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class DefaultImpls {
        public static <R> R fold(@org.jetbrains.annotations.NotNull kotlinx.coroutines.CompletableJob completableJob, R r, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super R, ? super kotlin.coroutines.CoroutineContext.Element, ? extends R> function2) {
            return (R) kotlinx.coroutines.Job.DefaultImpls.fold(completableJob, r, function2);
        }

        @org.jetbrains.annotations.Nullable
        public static <E extends kotlin.coroutines.CoroutineContext.Element> E get(@org.jetbrains.annotations.NotNull kotlinx.coroutines.CompletableJob completableJob, @org.jetbrains.annotations.NotNull kotlin.coroutines.CoroutineContext.Key<E> key) {
            return (E) kotlinx.coroutines.Job.DefaultImpls.get(completableJob, key);
        }

        @org.jetbrains.annotations.NotNull
        public static kotlin.coroutines.CoroutineContext minusKey(@org.jetbrains.annotations.NotNull kotlinx.coroutines.CompletableJob completableJob, @org.jetbrains.annotations.NotNull kotlin.coroutines.CoroutineContext.Key<?> key) {
            return kotlinx.coroutines.Job.DefaultImpls.minusKey(completableJob, key);
        }

        @org.jetbrains.annotations.NotNull
        public static kotlin.coroutines.CoroutineContext plus(@org.jetbrains.annotations.NotNull kotlinx.coroutines.CompletableJob completableJob, @org.jetbrains.annotations.NotNull kotlin.coroutines.CoroutineContext coroutineContext) {
            return kotlinx.coroutines.Job.DefaultImpls.plus(completableJob, coroutineContext);
        }

        @kotlin.Deprecated(level = kotlin.DeprecationLevel.ERROR, message = "Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
        @org.jetbrains.annotations.NotNull
        public static kotlinx.coroutines.Job plus(@org.jetbrains.annotations.NotNull kotlinx.coroutines.CompletableJob completableJob, @org.jetbrains.annotations.NotNull kotlinx.coroutines.Job job) {
            return kotlinx.coroutines.Job.DefaultImpls.plus((kotlinx.coroutines.Job) completableJob, job);
        }
    }

    boolean complete();

    boolean completeExceptionally(@org.jetbrains.annotations.NotNull java.lang.Throwable exception);
}
