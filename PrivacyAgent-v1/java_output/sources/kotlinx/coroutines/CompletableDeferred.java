package kotlinx.coroutines;

@kotlin.Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0000\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH&¨\u0006\n"}, d2 = {"Lkotlinx/coroutines/CompletableDeferred;", androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/Deferred;", com.anythink.expressad.foundation.d.c.bX, "", "value", "(Ljava/lang/Object;)Z", "completeExceptionally", "exception", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes15.dex */
public interface CompletableDeferred<T> extends kotlinx.coroutines.Deferred<T> {

    @kotlin.Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class DefaultImpls {
        public static <T, R> R fold(@org.jetbrains.annotations.NotNull kotlinx.coroutines.CompletableDeferred<T> completableDeferred, R r, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super R, ? super kotlin.coroutines.CoroutineContext.Element, ? extends R> function2) {
            return (R) kotlinx.coroutines.Deferred.DefaultImpls.fold(completableDeferred, r, function2);
        }

        @org.jetbrains.annotations.Nullable
        public static <T, E extends kotlin.coroutines.CoroutineContext.Element> E get(@org.jetbrains.annotations.NotNull kotlinx.coroutines.CompletableDeferred<T> completableDeferred, @org.jetbrains.annotations.NotNull kotlin.coroutines.CoroutineContext.Key<E> key) {
            return (E) kotlinx.coroutines.Deferred.DefaultImpls.get(completableDeferred, key);
        }

        @org.jetbrains.annotations.NotNull
        public static <T> kotlin.coroutines.CoroutineContext minusKey(@org.jetbrains.annotations.NotNull kotlinx.coroutines.CompletableDeferred<T> completableDeferred, @org.jetbrains.annotations.NotNull kotlin.coroutines.CoroutineContext.Key<?> key) {
            return kotlinx.coroutines.Deferred.DefaultImpls.minusKey(completableDeferred, key);
        }

        @org.jetbrains.annotations.NotNull
        public static <T> kotlin.coroutines.CoroutineContext plus(@org.jetbrains.annotations.NotNull kotlinx.coroutines.CompletableDeferred<T> completableDeferred, @org.jetbrains.annotations.NotNull kotlin.coroutines.CoroutineContext coroutineContext) {
            return kotlinx.coroutines.Deferred.DefaultImpls.plus(completableDeferred, coroutineContext);
        }

        @kotlin.Deprecated(level = kotlin.DeprecationLevel.ERROR, message = "Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
        @org.jetbrains.annotations.NotNull
        public static <T> kotlinx.coroutines.Job plus(@org.jetbrains.annotations.NotNull kotlinx.coroutines.CompletableDeferred<T> completableDeferred, @org.jetbrains.annotations.NotNull kotlinx.coroutines.Job job) {
            return kotlinx.coroutines.Deferred.DefaultImpls.plus((kotlinx.coroutines.Deferred) completableDeferred, job);
        }
    }

    boolean complete(T value);

    boolean completeExceptionally(@org.jetbrains.annotations.NotNull java.lang.Throwable exception);
}
