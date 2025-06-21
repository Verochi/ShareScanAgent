package kotlinx.coroutines.flow.internal;

@kotlinx.coroutines.InternalCoroutinesApi
@kotlin.Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002J,\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH&¨\u0006\n"}, d2 = {"Lkotlinx/coroutines/flow/internal/FusibleFlow;", androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/Flow;", "fuse", "context", "Lkotlin/coroutines/CoroutineContext;", "capacity", "", "onBufferOverflow", "Lkotlinx/coroutines/channels/BufferOverflow;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes16.dex */
public interface FusibleFlow<T> extends kotlinx.coroutines.flow.Flow<T> {

    @kotlin.Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ kotlinx.coroutines.flow.Flow fuse$default(kotlinx.coroutines.flow.internal.FusibleFlow fusibleFlow, kotlin.coroutines.CoroutineContext coroutineContext, int i, kotlinx.coroutines.channels.BufferOverflow bufferOverflow, int i2, java.lang.Object obj) {
            if (obj != null) {
                throw new java.lang.UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fuse");
            }
            if ((i2 & 1) != 0) {
                coroutineContext = kotlin.coroutines.EmptyCoroutineContext.INSTANCE;
            }
            if ((i2 & 2) != 0) {
                i = -3;
            }
            if ((i2 & 4) != 0) {
                bufferOverflow = kotlinx.coroutines.channels.BufferOverflow.SUSPEND;
            }
            return fusibleFlow.fuse(coroutineContext, i, bufferOverflow);
        }
    }

    @org.jetbrains.annotations.NotNull
    kotlinx.coroutines.flow.Flow<T> fuse(@org.jetbrains.annotations.NotNull kotlin.coroutines.CoroutineContext context, int capacity, @org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.BufferOverflow onBufferOverflow);
}
