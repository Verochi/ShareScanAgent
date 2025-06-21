package kotlinx.coroutines.channels;

@kotlin.Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b \u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0007UVWXYZ[B)\u0012 \u0010R\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0013\u0018\u00010Pj\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`Q¢\u0006\u0004\bS\u0010TJ!\u0010\u0007\u001a\u00028\u0001\"\u0004\b\u0001\u0010\u00042\u0006\u0010\u0006\u001a\u00020\u0005H\u0082@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\f\u001a\u00020\u000b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0002JT\u0010\u0014\u001a\u00020\u0013\"\u0004\b\u0001\u0010\u00042\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\r2\u0006\u0010\u0006\u001a\u00020\u00052$\u0010\u0012\u001a \b\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000fH\u0002ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015JZ\u0010\u0017\u001a\u00020\u0013\"\u0004\b\u0001\u0010\u0004* \b\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\r2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u0010H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018JT\u0010\u0019\u001a\u00020\u000b\"\u0004\b\u0001\u0010\u00042\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\r2$\u0010\u0012\u001a \b\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000f2\u0006\u0010\u0006\u001a\u00020\u0005H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001aJ \u0010\u001d\u001a\u00020\u00132\n\u0010\u001c\u001a\u0006\u0012\u0002\b\u00030\u001b2\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\tH\u0002J\n\u0010\u001e\u001a\u0004\u0018\u00010\u0010H\u0014J\u0016\u0010\u001f\u001a\u0004\u0018\u00010\u00102\n\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\rH\u0014J\u0013\u0010\n\u001a\u00028\u0000H\u0086@ø\u0001\u0000¢\u0006\u0004\b\n\u0010 J\u0016\u0010!\u001a\u00020\u000b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0014J\"\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000\"H\u0086@ø\u0001\u0000ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b#\u0010 J\u001c\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00000\"ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b%\u0010&J\u0012\u0010*\u001a\u00020\u000b2\b\u0010)\u001a\u0004\u0018\u00010(H\u0007J\u0016\u0010*\u001a\u00020\u00132\u000e\u0010)\u001a\n\u0018\u00010+j\u0004\u0018\u0001`,J\u0019\u0010/\u001a\u00020\u000b2\b\u0010)\u001a\u0004\u0018\u00010(H\u0000¢\u0006\u0004\b-\u0010.J\u0010\u00101\u001a\u00020\u00132\u0006\u00100\u001a\u00020\u000bH\u0014J/\u00109\u001a\u00020\u00132\f\u00104\u001a\b\u0012\u0004\u0012\u000203022\n\u00106\u001a\u0006\u0012\u0002\b\u000305H\u0014ø\u0001\u0000ø\u0001\u0002¢\u0006\u0004\b7\u00108J\u000f\u0010;\u001a\b\u0012\u0004\u0012\u00028\u00000:H\u0086\u0002J\u000e\u0010=\u001a\b\u0012\u0004\u0012\u00028\u00000<H\u0004J\u0010\u0010?\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010>H\u0014J\b\u0010@\u001a\u00020\u0013H\u0014J\b\u0010A\u001a\u00020\u0013H\u0014R\u0014\u0010B\u001a\u00020\u000b8$X¤\u0004¢\u0006\u0006\u001a\u0004\bB\u0010CR\u0014\u0010D\u001a\u00020\u000b8$X¤\u0004¢\u0006\u0006\u001a\u0004\bD\u0010CR\u0014\u0010F\u001a\u00020\u000b8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\bE\u0010CR\u0014\u0010G\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bG\u0010CR\u0014\u0010H\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bH\u0010CR\u0014\u0010I\u001a\u00020\u000b8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\bI\u0010CR\u0017\u0010M\u001a\b\u0012\u0004\u0012\u00028\u00000J8F¢\u0006\u0006\u001a\u0004\bK\u0010LR \u0010O\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\"0J8Fø\u0001\u0000¢\u0006\u0006\u001a\u0004\bN\u0010L\u0082\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\\"}, d2 = {"Lkotlinx/coroutines/channels/AbstractChannel;", androidx.exifinterface.media.ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/AbstractSendChannel;", "Lkotlinx/coroutines/channels/Channel;", "R", "", "receiveMode", com.anythink.expressad.d.a.b.dH, "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/Receive;", "receive", "", "k", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "Lkotlin/Function2;", "", "Lkotlin/coroutines/Continuation;", "block", "", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.AD_COUNT, "(Lkotlinx/coroutines/selects/SelectInstance;ILkotlin/jvm/functions/Function2;)V", "value", "p", "(Lkotlin/jvm/functions/Function2;Lkotlinx/coroutines/selects/SelectInstance;ILjava/lang/Object;)V", "l", "(Lkotlinx/coroutines/selects/SelectInstance;Lkotlin/jvm/functions/Function2;I)Z", "Lkotlinx/coroutines/CancellableContinuation;", "cont", "o", "pollInternal", "pollSelectInternal", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "enqueueReceiveInternal", "Lkotlinx/coroutines/channels/ChannelResult;", "receiveCatching-JP2dKIU", "receiveCatching", "tryReceive-PtdJZtk", "()Ljava/lang/Object;", "tryReceive", "", "cause", com.anythink.expressad.d.a.b.dO, "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "cancelInternal$kotlinx_coroutines_core", "(Ljava/lang/Throwable;)Z", "cancelInternal", "wasClosed", "onCancelIdempotent", "Lkotlinx/coroutines/internal/InlineList;", "Lkotlinx/coroutines/channels/Send;", org.apache.tools.ant.taskdefs.optional.j2ee.HotDeploymentTool.ACTION_LIST, "Lkotlinx/coroutines/channels/Closed;", "closed", "onCancelIdempotentList-w-w6eGU", "(Ljava/lang/Object;Lkotlinx/coroutines/channels/Closed;)V", "onCancelIdempotentList", "Lkotlinx/coroutines/channels/ChannelIterator;", "iterator", "Lkotlinx/coroutines/channels/AbstractChannel$TryPollDesc;", "describeTryPoll", "Lkotlinx/coroutines/channels/ReceiveOrClosed;", "takeFirstReceiveOrPeekClosed", "onReceiveEnqueued", "onReceiveDequeued", "isBufferAlwaysEmpty", "()Z", "isBufferEmpty", "getHasReceiveOrClosed", "hasReceiveOrClosed", "isClosedForReceive", "isEmpty", "isEmptyImpl", "Lkotlinx/coroutines/selects/SelectClause1;", "getOnReceive", "()Lkotlinx/coroutines/selects/SelectClause1;", "onReceive", "getOnReceiveCatching", "onReceiveCatching", "Lkotlin/Function1;", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "onUndeliveredElement", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "Itr", "ReceiveElement", "ReceiveElementWithUndeliveredHandler", "ReceiveHasNext", "ReceiveSelect", "RemoveReceiveOnCancel", "TryPollDesc", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes16.dex */
public abstract class AbstractChannel<E> extends kotlinx.coroutines.channels.AbstractSendChannel<E> implements kotlinx.coroutines.channels.Channel<E> {

    @kotlin.Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u00028\u00010\u0002B\u0015\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00010\f¢\u0006\u0004\b\u0013\u0010\u0014J\u0013\u0010\u0004\u001a\u00020\u0003H\u0096Bø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00028\u0001H\u0096\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\n\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\u0013\u0010\u000b\u001a\u00020\u0003H\u0082@ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\u0005R\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00010\f8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR$\u0010\t\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0010\u001a\u0004\b\r\u0010\u0007\"\u0004\b\u0011\u0010\u0012\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0015"}, d2 = {"Lkotlinx/coroutines/channels/AbstractChannel$Itr;", androidx.exifinterface.media.ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/ChannelIterator;", "", "hasNext", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "next", "()Ljava/lang/Object;", "", "result", "b", "c", "Lkotlinx/coroutines/channels/AbstractChannel;", "a", "Lkotlinx/coroutines/channels/AbstractChannel;", "channel", "Ljava/lang/Object;", "setResult", "(Ljava/lang/Object;)V", "<init>", "(Lkotlinx/coroutines/channels/AbstractChannel;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1})
    public static final class Itr<E> implements kotlinx.coroutines.channels.ChannelIterator<E> {

        /* renamed from: a, reason: from kotlin metadata */
        @kotlin.jvm.JvmField
        @org.jetbrains.annotations.NotNull
        public final kotlinx.coroutines.channels.AbstractChannel<E> channel;

        /* renamed from: b, reason: from kotlin metadata */
        @org.jetbrains.annotations.Nullable
        public java.lang.Object result = kotlinx.coroutines.channels.AbstractChannelKt.POLL_FAILED;

        public Itr(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.AbstractChannel<E> abstractChannel) {
            this.channel = abstractChannel;
        }

        @org.jetbrains.annotations.Nullable
        /* renamed from: a, reason: from getter */
        public final java.lang.Object getResult() {
            return this.result;
        }

        public final boolean b(java.lang.Object result) {
            if (!(result instanceof kotlinx.coroutines.channels.Closed)) {
                return true;
            }
            kotlinx.coroutines.channels.Closed closed = (kotlinx.coroutines.channels.Closed) result;
            if (closed.closeCause == null) {
                return false;
            }
            throw kotlinx.coroutines.internal.StackTraceRecoveryKt.recoverStackTrace(closed.getReceiveException());
        }

        public final java.lang.Object c(kotlin.coroutines.Continuation<? super java.lang.Boolean> continuation) {
            kotlin.coroutines.Continuation intercepted;
            java.lang.Object coroutine_suspended;
            intercepted = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
            kotlinx.coroutines.CancellableContinuationImpl orCreateCancellableContinuation = kotlinx.coroutines.CancellableContinuationKt.getOrCreateCancellableContinuation(intercepted);
            kotlinx.coroutines.channels.AbstractChannel.ReceiveHasNext receiveHasNext = new kotlinx.coroutines.channels.AbstractChannel.ReceiveHasNext(this, orCreateCancellableContinuation);
            while (true) {
                if (this.channel.k(receiveHasNext)) {
                    this.channel.o(orCreateCancellableContinuation, receiveHasNext);
                    break;
                }
                java.lang.Object pollInternal = this.channel.pollInternal();
                setResult(pollInternal);
                if (pollInternal instanceof kotlinx.coroutines.channels.Closed) {
                    kotlinx.coroutines.channels.Closed closed = (kotlinx.coroutines.channels.Closed) pollInternal;
                    if (closed.closeCause == null) {
                        orCreateCancellableContinuation.resumeWith(kotlin.Result.m156constructorimpl(kotlin.coroutines.jvm.internal.Boxing.boxBoolean(false)));
                    } else {
                        java.lang.Throwable receiveException = closed.getReceiveException();
                        kotlin.Result.Companion companion = kotlin.Result.INSTANCE;
                        orCreateCancellableContinuation.resumeWith(kotlin.Result.m156constructorimpl(kotlin.ResultKt.createFailure(receiveException)));
                    }
                } else if (pollInternal != kotlinx.coroutines.channels.AbstractChannelKt.POLL_FAILED) {
                    java.lang.Boolean boxBoolean = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(true);
                    kotlin.jvm.functions.Function1<E, kotlin.Unit> function1 = this.channel.onUndeliveredElement;
                    orCreateCancellableContinuation.resume(boxBoolean, function1 == null ? null : kotlinx.coroutines.internal.OnUndeliveredElementKt.bindCancellationFun(function1, pollInternal, orCreateCancellableContinuation.getContext()));
                }
            }
            java.lang.Object result = orCreateCancellableContinuation.getResult();
            coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (result == coroutine_suspended) {
                kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            return result;
        }

        @Override // kotlinx.coroutines.channels.ChannelIterator
        @org.jetbrains.annotations.Nullable
        public java.lang.Object hasNext(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.lang.Boolean> continuation) {
            java.lang.Object result = getResult();
            kotlinx.coroutines.internal.Symbol symbol = kotlinx.coroutines.channels.AbstractChannelKt.POLL_FAILED;
            if (result != symbol) {
                return kotlin.coroutines.jvm.internal.Boxing.boxBoolean(b(getResult()));
            }
            setResult(this.channel.pollInternal());
            return getResult() != symbol ? kotlin.coroutines.jvm.internal.Boxing.boxBoolean(b(getResult())) : c(continuation);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlinx.coroutines.channels.ChannelIterator
        public E next() {
            E e = (E) this.result;
            if (e instanceof kotlinx.coroutines.channels.Closed) {
                throw kotlinx.coroutines.internal.StackTraceRecoveryKt.recoverStackTrace(((kotlinx.coroutines.channels.Closed) e).getReceiveException());
            }
            kotlinx.coroutines.internal.Symbol symbol = kotlinx.coroutines.channels.AbstractChannelKt.POLL_FAILED;
            if (e == symbol) {
                throw new java.lang.IllegalStateException("'hasNext' should be called prior to 'next' invocation");
            }
            this.result = symbol;
            return e;
        }

        @Override // kotlinx.coroutines.channels.ChannelIterator
        @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Since 1.3.0, binary compatibility with versions <= 1.2.x")
        @kotlin.jvm.JvmName(name = "next")
        public /* synthetic */ java.lang.Object next(kotlin.coroutines.Continuation continuation) {
            return kotlinx.coroutines.channels.ChannelIterator.DefaultImpls.next(this, continuation);
        }

        public final void setResult(@org.jetbrains.annotations.Nullable java.lang.Object obj) {
            this.result = obj;
        }
    }

    @kotlin.Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\b\u0012\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u00002\b\u0012\u0004\u0012\u00028\u00010\u0002B\u001f\u0012\u000e\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0014\u0012\u0006\u0010\u001b\u001a\u00020\u0018¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00028\u0001¢\u0006\u0004\b\u0005\u0010\u0006J#\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0003\u001a\u00028\u00012\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0014\u0010\u0011\u001a\u00020\f2\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u000fH\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016R\u001c\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00148\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001b\u001a\u00020\u00188\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001e"}, d2 = {"Lkotlinx/coroutines/channels/AbstractChannel$ReceiveElement;", androidx.exifinterface.media.ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/Receive;", "value", "", "e", "(Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "otherOp", "Lkotlinx/coroutines/internal/Symbol;", "tryResumeReceive", "(Ljava/lang/Object;Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;)Lkotlinx/coroutines/internal/Symbol;", "", "completeResumeReceive", "(Ljava/lang/Object;)V", "Lkotlinx/coroutines/channels/Closed;", "closed", "resumeReceiveClosed", "", "toString", "Lkotlinx/coroutines/CancellableContinuation;", "v", "Lkotlinx/coroutines/CancellableContinuation;", "cont", "", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.WIDTH, "I", "receiveMode", "<init>", "(Lkotlinx/coroutines/CancellableContinuation;I)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1})
    public static class ReceiveElement<E> extends kotlinx.coroutines.channels.Receive<E> {

        /* renamed from: v, reason: from kotlin metadata */
        @kotlin.jvm.JvmField
        @org.jetbrains.annotations.NotNull
        public final kotlinx.coroutines.CancellableContinuation<java.lang.Object> cont;

        /* renamed from: w, reason: from kotlin metadata */
        @kotlin.jvm.JvmField
        public final int receiveMode;

        public ReceiveElement(@org.jetbrains.annotations.NotNull kotlinx.coroutines.CancellableContinuation<java.lang.Object> cancellableContinuation, int i) {
            this.cont = cancellableContinuation;
            this.receiveMode = i;
        }

        @Override // kotlinx.coroutines.channels.ReceiveOrClosed
        public void completeResumeReceive(E value) {
            this.cont.completeResume(kotlinx.coroutines.CancellableContinuationImplKt.RESUME_TOKEN);
        }

        @org.jetbrains.annotations.Nullable
        public final java.lang.Object e(E value) {
            return this.receiveMode == 1 ? kotlinx.coroutines.channels.ChannelResult.m771boximpl(kotlinx.coroutines.channels.ChannelResult.INSTANCE.m786successJP2dKIU(value)) : value;
        }

        @Override // kotlinx.coroutines.channels.Receive
        public void resumeReceiveClosed(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.Closed<?> closed) {
            if (this.receiveMode == 1) {
                this.cont.resumeWith(kotlin.Result.m156constructorimpl(kotlinx.coroutines.channels.ChannelResult.m771boximpl(kotlinx.coroutines.channels.ChannelResult.INSTANCE.m784closedJP2dKIU(closed.closeCause))));
                return;
            }
            kotlinx.coroutines.CancellableContinuation<java.lang.Object> cancellableContinuation = this.cont;
            java.lang.Throwable receiveException = closed.getReceiveException();
            kotlin.Result.Companion companion = kotlin.Result.INSTANCE;
            cancellableContinuation.resumeWith(kotlin.Result.m156constructorimpl(kotlin.ResultKt.createFailure(receiveException)));
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
        @org.jetbrains.annotations.NotNull
        public java.lang.String toString() {
            return "ReceiveElement@" + kotlinx.coroutines.DebugStringsKt.getHexAddress(this) + "[receiveMode=" + this.receiveMode + ']';
        }

        @Override // kotlinx.coroutines.channels.ReceiveOrClosed
        @org.jetbrains.annotations.Nullable
        public kotlinx.coroutines.internal.Symbol tryResumeReceive(E value, @org.jetbrains.annotations.Nullable kotlinx.coroutines.internal.LockFreeLinkedListNode.PrepareOp otherOp) {
            if (this.cont.tryResume(e(value), otherOp == null ? null : otherOp.desc, resumeOnCancellationFun(value)) == null) {
                return null;
            }
            if (otherOp != null) {
                otherOp.finishPrepare();
            }
            return kotlinx.coroutines.CancellableContinuationImplKt.RESUME_TOKEN;
        }
    }

    @kotlin.Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0002\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u00002\b\u0012\u0004\u0012\u00028\u00010\u0002B=\u0012\u000e\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\r\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u001c\u0010\f\u001a\u0018\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u00060\u0004j\b\u0012\u0004\u0012\u00028\u0001`\t¢\u0006\u0004\b\u0012\u0010\u0013J%\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u0007\u0010\bR*\u0010\f\u001a\u0018\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u00060\u0004j\b\u0012\u0004\u0012\u00028\u0001`\t8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lkotlinx/coroutines/channels/AbstractChannel$ReceiveElementWithUndeliveredHandler;", androidx.exifinterface.media.ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/AbstractChannel$ReceiveElement;", "value", "Lkotlin/Function1;", "", "", "resumeOnCancellationFun", "(Ljava/lang/Object;)Lkotlin/jvm/functions/Function1;", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "x", "Lkotlin/jvm/functions/Function1;", "onUndeliveredElement", "Lkotlinx/coroutines/CancellableContinuation;", "", "cont", "", "receiveMode", "<init>", "(Lkotlinx/coroutines/CancellableContinuation;ILkotlin/jvm/functions/Function1;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1})
    public static final class ReceiveElementWithUndeliveredHandler<E> extends kotlinx.coroutines.channels.AbstractChannel.ReceiveElement<E> {

        /* renamed from: x, reason: from kotlin metadata */
        @kotlin.jvm.JvmField
        @org.jetbrains.annotations.NotNull
        public final kotlin.jvm.functions.Function1<E, kotlin.Unit> onUndeliveredElement;

        /* JADX WARN: Multi-variable type inference failed */
        public ReceiveElementWithUndeliveredHandler(@org.jetbrains.annotations.NotNull kotlinx.coroutines.CancellableContinuation<java.lang.Object> cancellableContinuation, int i, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super E, kotlin.Unit> function1) {
            super(cancellableContinuation, i);
            this.onUndeliveredElement = function1;
        }

        @Override // kotlinx.coroutines.channels.Receive
        @org.jetbrains.annotations.Nullable
        public kotlin.jvm.functions.Function1<java.lang.Throwable, kotlin.Unit> resumeOnCancellationFun(E value) {
            return kotlinx.coroutines.internal.OnUndeliveredElementKt.bindCancellationFun(this.onUndeliveredElement, value, this.cont.getContext());
        }
    }

    @kotlin.Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0012\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u00028\u00010\u0002B#\u0012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00010\u0015\u0012\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019¢\u0006\u0004\b\u001e\u0010\u001fJ#\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00028\u00012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0014\u0010\u000e\u001a\u00020\t2\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\fH\u0016J%\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\t\u0018\u00010\u000f2\u0006\u0010\u0003\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0014\u001a\u00020\u0013H\u0016R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00010\u00158\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00198\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006 "}, d2 = {"Lkotlinx/coroutines/channels/AbstractChannel$ReceiveHasNext;", androidx.exifinterface.media.ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/Receive;", "value", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "otherOp", "Lkotlinx/coroutines/internal/Symbol;", "tryResumeReceive", "(Ljava/lang/Object;Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;)Lkotlinx/coroutines/internal/Symbol;", "", "completeResumeReceive", "(Ljava/lang/Object;)V", "Lkotlinx/coroutines/channels/Closed;", "closed", "resumeReceiveClosed", "Lkotlin/Function1;", "", "resumeOnCancellationFun", "(Ljava/lang/Object;)Lkotlin/jvm/functions/Function1;", "", "toString", "Lkotlinx/coroutines/channels/AbstractChannel$Itr;", "v", "Lkotlinx/coroutines/channels/AbstractChannel$Itr;", "iterator", "Lkotlinx/coroutines/CancellableContinuation;", "", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.WIDTH, "Lkotlinx/coroutines/CancellableContinuation;", "cont", "<init>", "(Lkotlinx/coroutines/channels/AbstractChannel$Itr;Lkotlinx/coroutines/CancellableContinuation;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1})
    public static class ReceiveHasNext<E> extends kotlinx.coroutines.channels.Receive<E> {

        /* renamed from: v, reason: from kotlin metadata */
        @kotlin.jvm.JvmField
        @org.jetbrains.annotations.NotNull
        public final kotlinx.coroutines.channels.AbstractChannel.Itr<E> iterator;

        /* renamed from: w, reason: from kotlin metadata */
        @kotlin.jvm.JvmField
        @org.jetbrains.annotations.NotNull
        public final kotlinx.coroutines.CancellableContinuation<java.lang.Boolean> cont;

        /* JADX WARN: Multi-variable type inference failed */
        public ReceiveHasNext(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.AbstractChannel.Itr<E> itr, @org.jetbrains.annotations.NotNull kotlinx.coroutines.CancellableContinuation<? super java.lang.Boolean> cancellableContinuation) {
            this.iterator = itr;
            this.cont = cancellableContinuation;
        }

        @Override // kotlinx.coroutines.channels.ReceiveOrClosed
        public void completeResumeReceive(E value) {
            this.iterator.setResult(value);
            this.cont.completeResume(kotlinx.coroutines.CancellableContinuationImplKt.RESUME_TOKEN);
        }

        @Override // kotlinx.coroutines.channels.Receive
        @org.jetbrains.annotations.Nullable
        public kotlin.jvm.functions.Function1<java.lang.Throwable, kotlin.Unit> resumeOnCancellationFun(E value) {
            kotlin.jvm.functions.Function1<E, kotlin.Unit> function1 = this.iterator.channel.onUndeliveredElement;
            if (function1 == null) {
                return null;
            }
            return kotlinx.coroutines.internal.OnUndeliveredElementKt.bindCancellationFun(function1, value, this.cont.getContext());
        }

        @Override // kotlinx.coroutines.channels.Receive
        public void resumeReceiveClosed(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.Closed<?> closed) {
            java.lang.Object tryResume$default = closed.closeCause == null ? kotlinx.coroutines.CancellableContinuation.DefaultImpls.tryResume$default(this.cont, java.lang.Boolean.FALSE, null, 2, null) : this.cont.tryResumeWithException(closed.getReceiveException());
            if (tryResume$default != null) {
                this.iterator.setResult(closed);
                this.cont.completeResume(tryResume$default);
            }
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
        @org.jetbrains.annotations.NotNull
        public java.lang.String toString() {
            return kotlin.jvm.internal.Intrinsics.stringPlus("ReceiveHasNext@", kotlinx.coroutines.DebugStringsKt.getHexAddress(this));
        }

        @Override // kotlinx.coroutines.channels.ReceiveOrClosed
        @org.jetbrains.annotations.Nullable
        public kotlinx.coroutines.internal.Symbol tryResumeReceive(E value, @org.jetbrains.annotations.Nullable kotlinx.coroutines.internal.LockFreeLinkedListNode.PrepareOp otherOp) {
            if (this.cont.tryResume(java.lang.Boolean.TRUE, otherOp == null ? null : otherOp.desc, resumeOnCancellationFun(value)) == null) {
                return null;
            }
            if (otherOp != null) {
                otherOp.finishPrepare();
            }
            return kotlinx.coroutines.CancellableContinuationImplKt.RESUME_TOKEN;
        }
    }

    @kotlin.Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u0001*\u0004\b\u0002\u0010\u00022\b\u0012\u0004\u0012\u00028\u00020\u00032\u00020\u0004BT\u0012\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00020\u0018\u0012\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00010\u001c\u0012$\u0010%\u001a \b\u0001\u0012\u0006\u0012\u0004\u0018\u00010!\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\"\u0012\u0006\u0012\u0004\u0018\u00010!0 \u0012\u0006\u0010)\u001a\u00020&ø\u0001\u0000¢\u0006\u0004\b*\u0010+J#\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00028\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00028\u0002H\u0016¢\u0006\u0004\b\f\u0010\rJ\u0014\u0010\u0010\u001a\u00020\u000b2\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u000bH\u0016J%\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00122\u0006\u0010\u0005\u001a\u00028\u0002H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0017\u001a\u00020\u0016H\u0016R\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00020\u00188\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00010\u001c8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR5\u0010%\u001a \b\u0001\u0012\u0006\u0012\u0004\u0018\u00010!\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\"\u0012\u0006\u0012\u0004\u0018\u00010!0 8\u0006X\u0087\u0004ø\u0001\u0000¢\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010)\u001a\u00020&8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b'\u0010(\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006,"}, d2 = {"Lkotlinx/coroutines/channels/AbstractChannel$ReceiveSelect;", "R", androidx.exifinterface.media.ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/Receive;", "Lkotlinx/coroutines/DisposableHandle;", "value", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "otherOp", "Lkotlinx/coroutines/internal/Symbol;", "tryResumeReceive", "(Ljava/lang/Object;Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;)Lkotlinx/coroutines/internal/Symbol;", "", "completeResumeReceive", "(Ljava/lang/Object;)V", "Lkotlinx/coroutines/channels/Closed;", "closed", "resumeReceiveClosed", "dispose", "Lkotlin/Function1;", "", "resumeOnCancellationFun", "(Ljava/lang/Object;)Lkotlin/jvm/functions/Function1;", "", "toString", "Lkotlinx/coroutines/channels/AbstractChannel;", "v", "Lkotlinx/coroutines/channels/AbstractChannel;", "channel", "Lkotlinx/coroutines/selects/SelectInstance;", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.WIDTH, "Lkotlinx/coroutines/selects/SelectInstance;", "select", "Lkotlin/Function2;", "", "Lkotlin/coroutines/Continuation;", "x", "Lkotlin/jvm/functions/Function2;", "block", "", "y", "I", "receiveMode", "<init>", "(Lkotlinx/coroutines/channels/AbstractChannel;Lkotlinx/coroutines/selects/SelectInstance;Lkotlin/jvm/functions/Function2;I)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1})
    public static final class ReceiveSelect<R, E> extends kotlinx.coroutines.channels.Receive<E> implements kotlinx.coroutines.DisposableHandle {

        /* renamed from: v, reason: from kotlin metadata */
        @kotlin.jvm.JvmField
        @org.jetbrains.annotations.NotNull
        public final kotlinx.coroutines.channels.AbstractChannel<E> channel;

        /* renamed from: w, reason: from kotlin metadata */
        @kotlin.jvm.JvmField
        @org.jetbrains.annotations.NotNull
        public final kotlinx.coroutines.selects.SelectInstance<R> select;

        /* renamed from: x, reason: from kotlin metadata */
        @kotlin.jvm.JvmField
        @org.jetbrains.annotations.NotNull
        public final kotlin.jvm.functions.Function2<java.lang.Object, kotlin.coroutines.Continuation<? super R>, java.lang.Object> block;

        /* renamed from: y, reason: from kotlin metadata */
        @kotlin.jvm.JvmField
        public final int receiveMode;

        /* JADX WARN: Multi-variable type inference failed */
        public ReceiveSelect(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.AbstractChannel<E> abstractChannel, @org.jetbrains.annotations.NotNull kotlinx.coroutines.selects.SelectInstance<? super R> selectInstance, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<java.lang.Object, ? super kotlin.coroutines.Continuation<? super R>, ? extends java.lang.Object> function2, int i) {
            this.channel = abstractChannel;
            this.select = selectInstance;
            this.block = function2;
            this.receiveMode = i;
        }

        @Override // kotlinx.coroutines.channels.ReceiveOrClosed
        public void completeResumeReceive(E value) {
            kotlinx.coroutines.intrinsics.CancellableKt.startCoroutineCancellable(this.block, this.receiveMode == 1 ? kotlinx.coroutines.channels.ChannelResult.m771boximpl(kotlinx.coroutines.channels.ChannelResult.INSTANCE.m786successJP2dKIU(value)) : value, this.select.getCompletion(), resumeOnCancellationFun(value));
        }

        @Override // kotlinx.coroutines.DisposableHandle
        public void dispose() {
            if (remove()) {
                this.channel.onReceiveDequeued();
            }
        }

        @Override // kotlinx.coroutines.channels.Receive
        @org.jetbrains.annotations.Nullable
        public kotlin.jvm.functions.Function1<java.lang.Throwable, kotlin.Unit> resumeOnCancellationFun(E value) {
            kotlin.jvm.functions.Function1<E, kotlin.Unit> function1 = this.channel.onUndeliveredElement;
            if (function1 == null) {
                return null;
            }
            return kotlinx.coroutines.internal.OnUndeliveredElementKt.bindCancellationFun(function1, value, this.select.getCompletion().getContext());
        }

        @Override // kotlinx.coroutines.channels.Receive
        public void resumeReceiveClosed(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.Closed<?> closed) {
            if (this.select.trySelect()) {
                int i = this.receiveMode;
                if (i == 0) {
                    this.select.resumeSelectWithException(closed.getReceiveException());
                } else {
                    if (i != 1) {
                        return;
                    }
                    kotlinx.coroutines.intrinsics.CancellableKt.startCoroutineCancellable$default(this.block, kotlinx.coroutines.channels.ChannelResult.m771boximpl(kotlinx.coroutines.channels.ChannelResult.INSTANCE.m784closedJP2dKIU(closed.closeCause)), this.select.getCompletion(), null, 4, null);
                }
            }
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
        @org.jetbrains.annotations.NotNull
        public java.lang.String toString() {
            return "ReceiveSelect@" + kotlinx.coroutines.DebugStringsKt.getHexAddress(this) + '[' + this.select + ",receiveMode=" + this.receiveMode + ']';
        }

        @Override // kotlinx.coroutines.channels.ReceiveOrClosed
        @org.jetbrains.annotations.Nullable
        public kotlinx.coroutines.internal.Symbol tryResumeReceive(E value, @org.jetbrains.annotations.Nullable kotlinx.coroutines.internal.LockFreeLinkedListNode.PrepareOp otherOp) {
            return (kotlinx.coroutines.internal.Symbol) this.select.trySelectOther(otherOp);
        }
    }

    @kotlin.Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\b¢\u0006\u0004\b\f\u0010\rJ\u0013\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016R\u0018\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lkotlinx/coroutines/channels/AbstractChannel$RemoveReceiveOnCancel;", "Lkotlinx/coroutines/BeforeResumeCancelHandler;", "", "cause", "", "invoke", "", "toString", "Lkotlinx/coroutines/channels/Receive;", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.AD_COUNT, "Lkotlinx/coroutines/channels/Receive;", "receive", "<init>", "(Lkotlinx/coroutines/channels/AbstractChannel;Lkotlinx/coroutines/channels/Receive;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1})
    public final class RemoveReceiveOnCancel extends kotlinx.coroutines.BeforeResumeCancelHandler {

        /* renamed from: n, reason: from kotlin metadata */
        @org.jetbrains.annotations.NotNull
        public final kotlinx.coroutines.channels.Receive<?> receive;

        public RemoveReceiveOnCancel(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.Receive<?> receive) {
            this.receive = receive;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ kotlin.Unit invoke(java.lang.Throwable th) {
            invoke2(th);
            return kotlin.Unit.INSTANCE;
        }

        @Override // kotlinx.coroutines.CancelHandlerBase
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public void invoke2(@org.jetbrains.annotations.Nullable java.lang.Throwable cause) {
            if (this.receive.remove()) {
                kotlinx.coroutines.channels.AbstractChannel.this.onReceiveDequeued();
            }
        }

        @org.jetbrains.annotations.NotNull
        public java.lang.String toString() {
            return "RemoveReceiveOnCancel[" + this.receive + ']';
        }
    }

    @kotlin.Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0004\u0018\u0000*\u0004\b\u0001\u0010\u00012\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH\u0014J\u0016\u0010\f\u001a\u0004\u0018\u00010\t2\n\u0010\r\u001a\u00060\u000ej\u0002`\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\u0012"}, d2 = {"Lkotlinx/coroutines/channels/AbstractChannel$TryPollDesc;", androidx.exifinterface.media.ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$RemoveFirstDesc;", "Lkotlinx/coroutines/channels/Send;", "Lkotlinx/coroutines/internal/RemoveFirstDesc;", "queue", "Lkotlinx/coroutines/internal/LockFreeLinkedListHead;", "(Lkotlinx/coroutines/internal/LockFreeLinkedListHead;)V", "failure", "", "affected", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "onPrepare", "prepareOp", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "Lkotlinx/coroutines/internal/PrepareOp;", "onRemoved", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class TryPollDesc<E> extends kotlinx.coroutines.internal.LockFreeLinkedListNode.RemoveFirstDesc<kotlinx.coroutines.channels.Send> {
        public TryPollDesc(@org.jetbrains.annotations.NotNull kotlinx.coroutines.internal.LockFreeLinkedListHead lockFreeLinkedListHead) {
            super(lockFreeLinkedListHead);
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.RemoveFirstDesc, kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        @org.jetbrains.annotations.Nullable
        public java.lang.Object failure(@org.jetbrains.annotations.NotNull kotlinx.coroutines.internal.LockFreeLinkedListNode affected) {
            if (affected instanceof kotlinx.coroutines.channels.Closed) {
                return affected;
            }
            if (affected instanceof kotlinx.coroutines.channels.Send) {
                return null;
            }
            return kotlinx.coroutines.channels.AbstractChannelKt.POLL_FAILED;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        @org.jetbrains.annotations.Nullable
        public java.lang.Object onPrepare(@org.jetbrains.annotations.NotNull kotlinx.coroutines.internal.LockFreeLinkedListNode.PrepareOp prepareOp) {
            kotlinx.coroutines.internal.Symbol tryResumeSend = ((kotlinx.coroutines.channels.Send) prepareOp.affected).tryResumeSend(prepareOp);
            if (tryResumeSend == null) {
                return kotlinx.coroutines.internal.LockFreeLinkedList_commonKt.REMOVE_PREPARED;
            }
            java.lang.Object obj = kotlinx.coroutines.internal.AtomicKt.RETRY_ATOMIC;
            if (tryResumeSend == obj) {
                return obj;
            }
            return null;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        public void onRemoved(@org.jetbrains.annotations.NotNull kotlinx.coroutines.internal.LockFreeLinkedListNode affected) {
            ((kotlinx.coroutines.channels.Send) affected).undeliveredElement();
        }
    }

    public AbstractChannel(@org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function1<? super E, kotlin.Unit> function1) {
        super(function1);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public /* synthetic */ void cancel() {
        cancel((java.util.concurrent.CancellationException) null);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final void cancel(@org.jetbrains.annotations.Nullable java.util.concurrent.CancellationException cause) {
        if (isClosedForReceive()) {
            return;
        }
        if (cause == null) {
            cause = new java.util.concurrent.CancellationException(kotlin.jvm.internal.Intrinsics.stringPlus(kotlinx.coroutines.DebugStringsKt.getClassSimpleName(this), " was cancelled"));
        }
        cancel(cause);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    /* renamed from: cancelInternal$kotlinx_coroutines_core, reason: merged with bridge method [inline-methods] */
    public final boolean cancel(@org.jetbrains.annotations.Nullable java.lang.Throwable cause) {
        boolean cancel = cancel(cause);
        onCancelIdempotent(cancel);
        return cancel;
    }

    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.channels.AbstractChannel.TryPollDesc<E> describeTryPoll() {
        return new kotlinx.coroutines.channels.AbstractChannel.TryPollDesc<>(getQueue());
    }

    public boolean enqueueReceiveInternal(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.Receive<? super E> receive) {
        int tryCondAddNext;
        kotlinx.coroutines.internal.LockFreeLinkedListNode prevNode;
        if (!isBufferAlwaysEmpty()) {
            kotlinx.coroutines.internal.LockFreeLinkedListNode queue = getQueue();
            kotlinx.coroutines.channels.AbstractChannel$enqueueReceiveInternal$$inlined$addLastIfPrevAndIf$1 abstractChannel$enqueueReceiveInternal$$inlined$addLastIfPrevAndIf$1 = new kotlinx.coroutines.channels.AbstractChannel$enqueueReceiveInternal$$inlined$addLastIfPrevAndIf$1(receive, this);
            do {
                kotlinx.coroutines.internal.LockFreeLinkedListNode prevNode2 = queue.getPrevNode();
                if (!(!(prevNode2 instanceof kotlinx.coroutines.channels.Send))) {
                    return false;
                }
                tryCondAddNext = prevNode2.tryCondAddNext(receive, queue, abstractChannel$enqueueReceiveInternal$$inlined$addLastIfPrevAndIf$1);
                if (tryCondAddNext != 1) {
                }
            } while (tryCondAddNext != 2);
            return false;
        }
        kotlinx.coroutines.internal.LockFreeLinkedListNode queue2 = getQueue();
        do {
            prevNode = queue2.getPrevNode();
            if (!(!(prevNode instanceof kotlinx.coroutines.channels.Send))) {
                return false;
            }
        } while (!prevNode.addNext(receive, queue2));
        return true;
    }

    public final boolean getHasReceiveOrClosed() {
        return getQueue().getNextNode() instanceof kotlinx.coroutines.channels.ReceiveOrClosed;
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.selects.SelectClause1<E> getOnReceive() {
        return new kotlinx.coroutines.channels.AbstractChannel$onReceive$1(this);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.selects.SelectClause1<kotlinx.coroutines.channels.ChannelResult<E>> getOnReceiveCatching() {
        return new kotlinx.coroutines.channels.AbstractChannel$onReceiveCatching$1(this);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @org.jetbrains.annotations.NotNull
    public kotlinx.coroutines.selects.SelectClause1<E> getOnReceiveOrNull() {
        return kotlinx.coroutines.channels.Channel.DefaultImpls.getOnReceiveOrNull(this);
    }

    public abstract boolean isBufferAlwaysEmpty();

    public abstract boolean isBufferEmpty();

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public boolean isClosedForReceive() {
        return getClosedForReceive() != null && isBufferEmpty();
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public boolean isEmpty() {
        return isEmptyImpl();
    }

    public final boolean isEmptyImpl() {
        return !(getQueue().getNextNode() instanceof kotlinx.coroutines.channels.Send) && isBufferEmpty();
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.channels.ChannelIterator<E> iterator() {
        return new kotlinx.coroutines.channels.AbstractChannel.Itr(this);
    }

    public final boolean k(kotlinx.coroutines.channels.Receive<? super E> receive) {
        boolean enqueueReceiveInternal = enqueueReceiveInternal(receive);
        if (enqueueReceiveInternal) {
            onReceiveEnqueued();
        }
        return enqueueReceiveInternal;
    }

    public final <R> boolean l(kotlinx.coroutines.selects.SelectInstance<? super R> select, kotlin.jvm.functions.Function2<java.lang.Object, ? super kotlin.coroutines.Continuation<? super R>, ? extends java.lang.Object> block, int receiveMode) {
        kotlinx.coroutines.channels.AbstractChannel.ReceiveSelect receiveSelect = new kotlinx.coroutines.channels.AbstractChannel.ReceiveSelect(this, select, block, receiveMode);
        boolean k = k(receiveSelect);
        if (k) {
            select.disposeOnSelect(receiveSelect);
        }
        return k;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <R> java.lang.Object m(int i, kotlin.coroutines.Continuation<? super R> continuation) {
        kotlin.coroutines.Continuation intercepted;
        java.lang.Object coroutine_suspended;
        intercepted = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        kotlinx.coroutines.CancellableContinuationImpl orCreateCancellableContinuation = kotlinx.coroutines.CancellableContinuationKt.getOrCreateCancellableContinuation(intercepted);
        kotlinx.coroutines.channels.AbstractChannel.ReceiveElement receiveElement = this.onUndeliveredElement == null ? new kotlinx.coroutines.channels.AbstractChannel.ReceiveElement(orCreateCancellableContinuation, i) : new kotlinx.coroutines.channels.AbstractChannel.ReceiveElementWithUndeliveredHandler(orCreateCancellableContinuation, i, this.onUndeliveredElement);
        while (true) {
            if (k(receiveElement)) {
                o(orCreateCancellableContinuation, receiveElement);
                break;
            }
            java.lang.Object pollInternal = pollInternal();
            if (pollInternal instanceof kotlinx.coroutines.channels.Closed) {
                receiveElement.resumeReceiveClosed((kotlinx.coroutines.channels.Closed) pollInternal);
                break;
            }
            if (pollInternal != kotlinx.coroutines.channels.AbstractChannelKt.POLL_FAILED) {
                orCreateCancellableContinuation.resume(receiveElement.e(pollInternal), receiveElement.resumeOnCancellationFun(pollInternal));
                break;
            }
        }
        java.lang.Object result = orCreateCancellableContinuation.getResult();
        coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    public final <R> void n(kotlinx.coroutines.selects.SelectInstance<? super R> select, int receiveMode, kotlin.jvm.functions.Function2<java.lang.Object, ? super kotlin.coroutines.Continuation<? super R>, ? extends java.lang.Object> block) {
        while (!select.isSelected()) {
            if (!isEmptyImpl()) {
                java.lang.Object pollSelectInternal = pollSelectInternal(select);
                if (pollSelectInternal == kotlinx.coroutines.selects.SelectKt.getALREADY_SELECTED()) {
                    return;
                }
                if (pollSelectInternal != kotlinx.coroutines.channels.AbstractChannelKt.POLL_FAILED && pollSelectInternal != kotlinx.coroutines.internal.AtomicKt.RETRY_ATOMIC) {
                    p(block, select, receiveMode, pollSelectInternal);
                }
            } else if (l(select, block, receiveMode)) {
                return;
            }
        }
    }

    public final void o(kotlinx.coroutines.CancellableContinuation<?> cont, kotlinx.coroutines.channels.Receive<?> receive) {
        cont.invokeOnCancellation(new kotlinx.coroutines.channels.AbstractChannel.RemoveReceiveOnCancel(receive));
    }

    public void onCancelIdempotent(boolean wasClosed) {
        kotlinx.coroutines.channels.Closed<?> closedForSend = getClosedForSend();
        if (closedForSend == null) {
            throw new java.lang.IllegalStateException("Cannot happen".toString());
        }
        java.lang.Object m797constructorimpl$default = kotlinx.coroutines.internal.InlineList.m797constructorimpl$default(null, 1, null);
        while (true) {
            kotlinx.coroutines.internal.LockFreeLinkedListNode prevNode = closedForSend.getPrevNode();
            if (prevNode instanceof kotlinx.coroutines.internal.LockFreeLinkedListHead) {
                mo763onCancelIdempotentListww6eGU(m797constructorimpl$default, closedForSend);
                return;
            } else if (prevNode.remove()) {
                m797constructorimpl$default = kotlinx.coroutines.internal.InlineList.m802plusFjFbRPM(m797constructorimpl$default, (kotlinx.coroutines.channels.Send) prevNode);
            } else {
                prevNode.helpRemove();
            }
        }
    }

    /* renamed from: onCancelIdempotentList-w-w6eGU, reason: not valid java name */
    public void mo763onCancelIdempotentListww6eGU(@org.jetbrains.annotations.NotNull java.lang.Object list, @org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.Closed<?> closed) {
        if (list == null) {
            return;
        }
        if (!(list instanceof java.util.ArrayList)) {
            ((kotlinx.coroutines.channels.Send) list).resumeSendClosed(closed);
            return;
        }
        java.util.ArrayList arrayList = (java.util.ArrayList) list;
        int size = arrayList.size() - 1;
        if (size < 0) {
            return;
        }
        while (true) {
            int i = size - 1;
            ((kotlinx.coroutines.channels.Send) arrayList.get(size)).resumeSendClosed(closed);
            if (i < 0) {
                return;
            } else {
                size = i;
            }
        }
    }

    public void onReceiveDequeued() {
    }

    public void onReceiveEnqueued() {
    }

    public final <R> void p(kotlin.jvm.functions.Function2<java.lang.Object, ? super kotlin.coroutines.Continuation<? super R>, ? extends java.lang.Object> function2, kotlinx.coroutines.selects.SelectInstance<? super R> selectInstance, int i, java.lang.Object obj) {
        boolean z = obj instanceof kotlinx.coroutines.channels.Closed;
        if (!z) {
            if (i != 1) {
                kotlinx.coroutines.intrinsics.UndispatchedKt.startCoroutineUnintercepted(function2, obj, selectInstance.getCompletion());
                return;
            } else {
                kotlinx.coroutines.channels.ChannelResult.Companion companion = kotlinx.coroutines.channels.ChannelResult.INSTANCE;
                kotlinx.coroutines.intrinsics.UndispatchedKt.startCoroutineUnintercepted(function2, kotlinx.coroutines.channels.ChannelResult.m771boximpl(z ? companion.m784closedJP2dKIU(((kotlinx.coroutines.channels.Closed) obj).closeCause) : companion.m786successJP2dKIU(obj)), selectInstance.getCompletion());
                return;
            }
        }
        if (i == 0) {
            throw kotlinx.coroutines.internal.StackTraceRecoveryKt.recoverStackTrace(((kotlinx.coroutines.channels.Closed) obj).getReceiveException());
        }
        if (i == 1 && selectInstance.trySelect()) {
            kotlinx.coroutines.intrinsics.UndispatchedKt.startCoroutineUnintercepted(function2, kotlinx.coroutines.channels.ChannelResult.m771boximpl(kotlinx.coroutines.channels.ChannelResult.INSTANCE.m784closedJP2dKIU(((kotlinx.coroutines.channels.Closed) obj).closeCause)), selectInstance.getCompletion());
        }
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.WARNING, message = "Deprecated in the favour of 'tryReceive'. Please note that the provided replacement does not rethrow channel's close cause as 'poll' did, for the precise replacement please refer to the 'poll' documentation", replaceWith = @kotlin.ReplaceWith(expression = "tryReceive().getOrNull()", imports = {}))
    @org.jetbrains.annotations.Nullable
    public E poll() {
        return (E) kotlinx.coroutines.channels.Channel.DefaultImpls.poll(this);
    }

    @org.jetbrains.annotations.Nullable
    public java.lang.Object pollInternal() {
        while (true) {
            kotlinx.coroutines.channels.Send takeFirstSendOrPeekClosed = takeFirstSendOrPeekClosed();
            if (takeFirstSendOrPeekClosed == null) {
                return kotlinx.coroutines.channels.AbstractChannelKt.POLL_FAILED;
            }
            if (takeFirstSendOrPeekClosed.tryResumeSend(null) != null) {
                takeFirstSendOrPeekClosed.completeResumeSend();
                return takeFirstSendOrPeekClosed.getElement();
            }
            takeFirstSendOrPeekClosed.undeliveredElement();
        }
    }

    @org.jetbrains.annotations.Nullable
    public java.lang.Object pollSelectInternal(@org.jetbrains.annotations.NotNull kotlinx.coroutines.selects.SelectInstance<?> select) {
        kotlinx.coroutines.channels.AbstractChannel.TryPollDesc<E> describeTryPoll = describeTryPoll();
        java.lang.Object performAtomicTrySelect = select.performAtomicTrySelect(describeTryPoll);
        if (performAtomicTrySelect != null) {
            return performAtomicTrySelect;
        }
        describeTryPoll.getResult().completeResumeSend();
        return describeTryPoll.getResult().getElement();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object receive(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super E> continuation) {
        java.lang.Object pollInternal = pollInternal();
        return (pollInternal == kotlinx.coroutines.channels.AbstractChannelKt.POLL_FAILED || (pollInternal instanceof kotlinx.coroutines.channels.Closed)) ? m(0, continuation) : pollInternal;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @org.jetbrains.annotations.Nullable
    /* renamed from: receiveCatching-JP2dKIU, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final java.lang.Object mo764receiveCatchingJP2dKIU(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlinx.coroutines.channels.ChannelResult<? extends E>> continuation) {
        kotlinx.coroutines.channels.AbstractChannel$receiveCatching$1 abstractChannel$receiveCatching$1;
        java.lang.Object coroutine_suspended;
        int i;
        if (continuation instanceof kotlinx.coroutines.channels.AbstractChannel$receiveCatching$1) {
            abstractChannel$receiveCatching$1 = (kotlinx.coroutines.channels.AbstractChannel$receiveCatching$1) continuation;
            int i2 = abstractChannel$receiveCatching$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                abstractChannel$receiveCatching$1.label = i2 - Integer.MIN_VALUE;
                java.lang.Object obj = abstractChannel$receiveCatching$1.result;
                coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = abstractChannel$receiveCatching$1.label;
                if (i != 0) {
                    kotlin.ResultKt.throwOnFailure(obj);
                    java.lang.Object pollInternal = pollInternal();
                    if (pollInternal != kotlinx.coroutines.channels.AbstractChannelKt.POLL_FAILED) {
                        return pollInternal instanceof kotlinx.coroutines.channels.Closed ? kotlinx.coroutines.channels.ChannelResult.INSTANCE.m784closedJP2dKIU(((kotlinx.coroutines.channels.Closed) pollInternal).closeCause) : kotlinx.coroutines.channels.ChannelResult.INSTANCE.m786successJP2dKIU(pollInternal);
                    }
                    abstractChannel$receiveCatching$1.label = 1;
                    obj = m(1, abstractChannel$receiveCatching$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    kotlin.ResultKt.throwOnFailure(obj);
                }
                return ((kotlinx.coroutines.channels.ChannelResult) obj).getHolder();
            }
        }
        abstractChannel$receiveCatching$1 = new kotlinx.coroutines.channels.AbstractChannel$receiveCatching$1(this, continuation);
        java.lang.Object obj2 = abstractChannel$receiveCatching$1.result;
        coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = abstractChannel$receiveCatching$1.label;
        if (i != 0) {
        }
        return ((kotlinx.coroutines.channels.ChannelResult) obj2).getHolder();
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.ERROR, message = "Deprecated in favor of 'receiveCatching'. Please note that the provided replacement does not rethrow channel's close cause as 'receiveOrNull' did, for the detailed replacement please refer to the 'receiveOrNull' documentation", replaceWith = @kotlin.ReplaceWith(expression = "receiveCatching().getOrNull()", imports = {}))
    @kotlin.internal.LowPriorityInOverloadResolution
    @org.jetbrains.annotations.Nullable
    public java.lang.Object receiveOrNull(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super E> continuation) {
        return kotlinx.coroutines.channels.Channel.DefaultImpls.receiveOrNull(this, continuation);
    }

    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    @org.jetbrains.annotations.Nullable
    public kotlinx.coroutines.channels.ReceiveOrClosed<E> takeFirstReceiveOrPeekClosed() {
        kotlinx.coroutines.channels.ReceiveOrClosed<E> takeFirstReceiveOrPeekClosed = super.takeFirstReceiveOrPeekClosed();
        if (takeFirstReceiveOrPeekClosed != null && !(takeFirstReceiveOrPeekClosed instanceof kotlinx.coroutines.channels.Closed)) {
            onReceiveDequeued();
        }
        return takeFirstReceiveOrPeekClosed;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @org.jetbrains.annotations.NotNull
    /* renamed from: tryReceive-PtdJZtk, reason: not valid java name */
    public final java.lang.Object mo765tryReceivePtdJZtk() {
        java.lang.Object pollInternal = pollInternal();
        return pollInternal == kotlinx.coroutines.channels.AbstractChannelKt.POLL_FAILED ? kotlinx.coroutines.channels.ChannelResult.INSTANCE.m785failurePtdJZtk() : pollInternal instanceof kotlinx.coroutines.channels.Closed ? kotlinx.coroutines.channels.ChannelResult.INSTANCE.m784closedJP2dKIU(((kotlinx.coroutines.channels.Closed) pollInternal).closeCause) : kotlinx.coroutines.channels.ChannelResult.INSTANCE.m786successJP2dKIU(pollInternal);
    }
}
