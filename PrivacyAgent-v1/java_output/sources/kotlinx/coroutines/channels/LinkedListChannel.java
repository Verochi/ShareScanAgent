package kotlinx.coroutines.channels;

@kotlin.Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B'\u0012 \u0010\u0003\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u0006¢\u0006\u0002\u0010\u0007J\u0015\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010\u0011J!\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00028\u00002\n\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u0014H\u0014¢\u0006\u0002\u0010\u0015J/\u0010\u0016\u001a\u00020\u00052\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\n\u0010\u001a\u001a\u0006\u0012\u0002\b\u00030\u001bH\u0014ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001c\u0010\u001dR\u0014\u0010\b\u001a\u00020\t8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\nR\u0014\u0010\u000b\u001a\u00020\t8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\nR\u0014\u0010\f\u001a\u00020\t8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\nR\u0014\u0010\r\u001a\u00020\t8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\n\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u001e"}, d2 = {"Lkotlinx/coroutines/channels/LinkedListChannel;", androidx.exifinterface.media.ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/AbstractChannel;", "onUndeliveredElement", "Lkotlin/Function1;", "", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "(Lkotlin/jvm/functions/Function1;)V", "isBufferAlwaysEmpty", "", "()Z", "isBufferAlwaysFull", "isBufferEmpty", "isBufferFull", "offerInternal", "", "element", "(Ljava/lang/Object;)Ljava/lang/Object;", "offerSelectInternal", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "(Ljava/lang/Object;Lkotlinx/coroutines/selects/SelectInstance;)Ljava/lang/Object;", "onCancelIdempotentList", org.apache.tools.ant.taskdefs.optional.j2ee.HotDeploymentTool.ACTION_LIST, "Lkotlinx/coroutines/internal/InlineList;", "Lkotlinx/coroutines/channels/Send;", "closed", "Lkotlinx/coroutines/channels/Closed;", "onCancelIdempotentList-w-w6eGU", "(Ljava/lang/Object;Lkotlinx/coroutines/channels/Closed;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes16.dex */
public class LinkedListChannel<E> extends kotlinx.coroutines.channels.AbstractChannel<E> {
    public LinkedListChannel(@org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function1<? super E, kotlin.Unit> function1) {
        super(function1);
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    public final boolean isBufferAlwaysEmpty() {
        return true;
    }

    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    public final boolean isBufferAlwaysFull() {
        return false;
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    public final boolean isBufferEmpty() {
        return true;
    }

    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    public final boolean isBufferFull() {
        return false;
    }

    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    @org.jetbrains.annotations.NotNull
    public java.lang.Object offerInternal(E element) {
        kotlinx.coroutines.channels.ReceiveOrClosed<?> sendBuffered;
        do {
            java.lang.Object offerInternal = super.offerInternal(element);
            kotlinx.coroutines.internal.Symbol symbol = kotlinx.coroutines.channels.AbstractChannelKt.OFFER_SUCCESS;
            if (offerInternal == symbol) {
                return symbol;
            }
            if (offerInternal != kotlinx.coroutines.channels.AbstractChannelKt.OFFER_FAILED) {
                if (offerInternal instanceof kotlinx.coroutines.channels.Closed) {
                    return offerInternal;
                }
                throw new java.lang.IllegalStateException(kotlin.jvm.internal.Intrinsics.stringPlus("Invalid offerInternal result ", offerInternal).toString());
            }
            sendBuffered = sendBuffered(element);
            if (sendBuffered == null) {
                return symbol;
            }
        } while (!(sendBuffered instanceof kotlinx.coroutines.channels.Closed));
        return sendBuffered;
    }

    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    @org.jetbrains.annotations.NotNull
    public java.lang.Object offerSelectInternal(E element, @org.jetbrains.annotations.NotNull kotlinx.coroutines.selects.SelectInstance<?> select) {
        java.lang.Object performAtomicTrySelect;
        while (true) {
            if (getHasReceiveOrClosed()) {
                performAtomicTrySelect = super.offerSelectInternal(element, select);
            } else {
                performAtomicTrySelect = select.performAtomicTrySelect(describeSendBuffered(element));
                if (performAtomicTrySelect == null) {
                    performAtomicTrySelect = kotlinx.coroutines.channels.AbstractChannelKt.OFFER_SUCCESS;
                }
            }
            if (performAtomicTrySelect == kotlinx.coroutines.selects.SelectKt.getALREADY_SELECTED()) {
                return kotlinx.coroutines.selects.SelectKt.getALREADY_SELECTED();
            }
            kotlinx.coroutines.internal.Symbol symbol = kotlinx.coroutines.channels.AbstractChannelKt.OFFER_SUCCESS;
            if (performAtomicTrySelect == symbol) {
                return symbol;
            }
            if (performAtomicTrySelect != kotlinx.coroutines.channels.AbstractChannelKt.OFFER_FAILED && performAtomicTrySelect != kotlinx.coroutines.internal.AtomicKt.RETRY_ATOMIC) {
                if (performAtomicTrySelect instanceof kotlinx.coroutines.channels.Closed) {
                    return performAtomicTrySelect;
                }
                throw new java.lang.IllegalStateException(kotlin.jvm.internal.Intrinsics.stringPlus("Invalid result ", performAtomicTrySelect).toString());
            }
        }
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    /* renamed from: onCancelIdempotentList-w-w6eGU */
    public void mo763onCancelIdempotentListww6eGU(@org.jetbrains.annotations.NotNull java.lang.Object list, @org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.Closed<?> closed) {
        kotlinx.coroutines.internal.UndeliveredElementException undeliveredElementException = null;
        if (list != null) {
            if (list instanceof java.util.ArrayList) {
                java.util.ArrayList arrayList = (java.util.ArrayList) list;
                int size = arrayList.size() - 1;
                if (size >= 0) {
                    kotlinx.coroutines.internal.UndeliveredElementException undeliveredElementException2 = null;
                    while (true) {
                        int i = size - 1;
                        kotlinx.coroutines.channels.Send send = (kotlinx.coroutines.channels.Send) arrayList.get(size);
                        if (send instanceof kotlinx.coroutines.channels.AbstractSendChannel.SendBuffered) {
                            kotlin.jvm.functions.Function1<E, kotlin.Unit> function1 = this.onUndeliveredElement;
                            undeliveredElementException2 = function1 == null ? null : kotlinx.coroutines.internal.OnUndeliveredElementKt.callUndeliveredElementCatchingException(function1, ((kotlinx.coroutines.channels.AbstractSendChannel.SendBuffered) send).element, undeliveredElementException2);
                        } else {
                            send.resumeSendClosed(closed);
                        }
                        if (i < 0) {
                            break;
                        } else {
                            size = i;
                        }
                    }
                    undeliveredElementException = undeliveredElementException2;
                }
            } else {
                kotlinx.coroutines.channels.Send send2 = (kotlinx.coroutines.channels.Send) list;
                if (send2 instanceof kotlinx.coroutines.channels.AbstractSendChannel.SendBuffered) {
                    kotlin.jvm.functions.Function1<E, kotlin.Unit> function12 = this.onUndeliveredElement;
                    if (function12 != null) {
                        undeliveredElementException = kotlinx.coroutines.internal.OnUndeliveredElementKt.callUndeliveredElementCatchingException(function12, ((kotlinx.coroutines.channels.AbstractSendChannel.SendBuffered) send2).element, null);
                    }
                } else {
                    send2.resumeSendClosed(closed);
                }
            }
        }
        if (undeliveredElementException != null) {
            throw undeliveredElementException;
        }
    }
}
