package kotlinx.coroutines.channels;

@kotlin.Metadata(d1 = {"\u0000&\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a4\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u0007\u001a1\u0010\f\u001a\u00020\b2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\nH\u0082@ø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u001a1\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\nH\u0082@ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\r\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000f"}, d2 = {"", "delayMillis", "initialDelayMillis", "Lkotlin/coroutines/CoroutineContext;", "context", "Lkotlinx/coroutines/channels/TickerMode;", "mode", "Lkotlinx/coroutines/channels/ReceiveChannel;", "", com.huawei.hms.push.constant.RemoteMessageConst.Notification.TICKER, "Lkotlinx/coroutines/channels/SendChannel;", "channel", "b", "(JJLkotlinx/coroutines/channels/SendChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "a", "kotlinx-coroutines-core"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes16.dex */
public final class TickerChannelsKt {
    /* JADX WARN: Removed duplicated region for block: B:15:0x0071 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x007f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x007d -> B:12:0x0034). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final java.lang.Object a(long j, long j2, kotlinx.coroutines.channels.SendChannel<? super kotlin.Unit> sendChannel, kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        kotlinx.coroutines.channels.TickerChannelsKt$fixedDelayTicker$1 tickerChannelsKt$fixedDelayTicker$1;
        java.lang.Object coroutine_suspended;
        int i;
        kotlinx.coroutines.channels.SendChannel<? super kotlin.Unit> sendChannel2;
        kotlin.Unit unit;
        if (continuation instanceof kotlinx.coroutines.channels.TickerChannelsKt$fixedDelayTicker$1) {
            tickerChannelsKt$fixedDelayTicker$1 = (kotlinx.coroutines.channels.TickerChannelsKt$fixedDelayTicker$1) continuation;
            int i2 = tickerChannelsKt$fixedDelayTicker$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                tickerChannelsKt$fixedDelayTicker$1.label = i2 - Integer.MIN_VALUE;
                java.lang.Object obj = tickerChannelsKt$fixedDelayTicker$1.result;
                coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = tickerChannelsKt$fixedDelayTicker$1.label;
                if (i != 0) {
                    kotlin.ResultKt.throwOnFailure(obj);
                    tickerChannelsKt$fixedDelayTicker$1.L$0 = sendChannel;
                    tickerChannelsKt$fixedDelayTicker$1.J$0 = j;
                    tickerChannelsKt$fixedDelayTicker$1.label = 1;
                    if (kotlinx.coroutines.DelayKt.delay(j2, tickerChannelsKt$fixedDelayTicker$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i == 1) {
                    j = tickerChannelsKt$fixedDelayTicker$1.J$0;
                    sendChannel = (kotlinx.coroutines.channels.SendChannel) tickerChannelsKt$fixedDelayTicker$1.L$0;
                    kotlin.ResultKt.throwOnFailure(obj);
                } else if (i == 2) {
                    j = tickerChannelsKt$fixedDelayTicker$1.J$0;
                    sendChannel2 = (kotlinx.coroutines.channels.SendChannel) tickerChannelsKt$fixedDelayTicker$1.L$0;
                    kotlin.ResultKt.throwOnFailure(obj);
                    tickerChannelsKt$fixedDelayTicker$1.L$0 = sendChannel2;
                    tickerChannelsKt$fixedDelayTicker$1.J$0 = j;
                    tickerChannelsKt$fixedDelayTicker$1.label = 3;
                    if (kotlinx.coroutines.DelayKt.delay(j, tickerChannelsKt$fixedDelayTicker$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    sendChannel = sendChannel2;
                } else {
                    if (i != 3) {
                        throw new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    j = tickerChannelsKt$fixedDelayTicker$1.J$0;
                    sendChannel2 = (kotlinx.coroutines.channels.SendChannel) tickerChannelsKt$fixedDelayTicker$1.L$0;
                    kotlin.ResultKt.throwOnFailure(obj);
                    sendChannel = sendChannel2;
                }
                unit = kotlin.Unit.INSTANCE;
                tickerChannelsKt$fixedDelayTicker$1.L$0 = sendChannel;
                tickerChannelsKt$fixedDelayTicker$1.J$0 = j;
                tickerChannelsKt$fixedDelayTicker$1.label = 2;
                if (sendChannel.send(unit, tickerChannelsKt$fixedDelayTicker$1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                sendChannel2 = sendChannel;
                tickerChannelsKt$fixedDelayTicker$1.L$0 = sendChannel2;
                tickerChannelsKt$fixedDelayTicker$1.J$0 = j;
                tickerChannelsKt$fixedDelayTicker$1.label = 3;
                if (kotlinx.coroutines.DelayKt.delay(j, tickerChannelsKt$fixedDelayTicker$1) == coroutine_suspended) {
                }
                sendChannel = sendChannel2;
                unit = kotlin.Unit.INSTANCE;
                tickerChannelsKt$fixedDelayTicker$1.L$0 = sendChannel;
                tickerChannelsKt$fixedDelayTicker$1.J$0 = j;
                tickerChannelsKt$fixedDelayTicker$1.label = 2;
                if (sendChannel.send(unit, tickerChannelsKt$fixedDelayTicker$1) == coroutine_suspended) {
                }
            }
        }
        tickerChannelsKt$fixedDelayTicker$1 = new kotlinx.coroutines.channels.TickerChannelsKt$fixedDelayTicker$1(continuation);
        java.lang.Object obj2 = tickerChannelsKt$fixedDelayTicker$1.result;
        coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = tickerChannelsKt$fixedDelayTicker$1.label;
        if (i != 0) {
        }
        unit = kotlin.Unit.INSTANCE;
        tickerChannelsKt$fixedDelayTicker$1.L$0 = sendChannel;
        tickerChannelsKt$fixedDelayTicker$1.J$0 = j;
        tickerChannelsKt$fixedDelayTicker$1.label = 2;
        if (sendChannel.send(unit, tickerChannelsKt$fixedDelayTicker$1) == coroutine_suspended) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x00b5 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x010e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0028  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x00f3 -> B:13:0x0052). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x010c -> B:13:0x0052). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final java.lang.Object b(long j, long j2, kotlinx.coroutines.channels.SendChannel<? super kotlin.Unit> sendChannel, kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        kotlinx.coroutines.channels.TickerChannelsKt$fixedPeriodTicker$1 tickerChannelsKt$fixedPeriodTicker$1;
        java.lang.Object coroutine_suspended;
        int i;
        kotlinx.coroutines.channels.SendChannel sendChannel2;
        long j3;
        long j4;
        long delayToNanos;
        long j5;
        long j6;
        kotlinx.coroutines.channels.SendChannel sendChannel3;
        long coerceAtLeast;
        long delayNanosToMillis;
        kotlin.Unit unit;
        if (continuation instanceof kotlinx.coroutines.channels.TickerChannelsKt$fixedPeriodTicker$1) {
            tickerChannelsKt$fixedPeriodTicker$1 = (kotlinx.coroutines.channels.TickerChannelsKt$fixedPeriodTicker$1) continuation;
            int i2 = tickerChannelsKt$fixedPeriodTicker$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                tickerChannelsKt$fixedPeriodTicker$1.label = i2 - Integer.MIN_VALUE;
                java.lang.Object obj = tickerChannelsKt$fixedPeriodTicker$1.result;
                coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = tickerChannelsKt$fixedPeriodTicker$1.label;
                if (i != 0) {
                    kotlin.ResultKt.throwOnFailure(obj);
                    kotlinx.coroutines.AbstractTimeSource timeSource = kotlinx.coroutines.AbstractTimeSourceKt.getTimeSource();
                    long nanoTime = (timeSource == null ? java.lang.System.nanoTime() : timeSource.nanoTime()) + kotlinx.coroutines.EventLoop_commonKt.delayToNanos(j2);
                    sendChannel2 = sendChannel;
                    tickerChannelsKt$fixedPeriodTicker$1.L$0 = sendChannel2;
                    j3 = j;
                    tickerChannelsKt$fixedPeriodTicker$1.J$0 = j3;
                    tickerChannelsKt$fixedPeriodTicker$1.J$1 = nanoTime;
                    tickerChannelsKt$fixedPeriodTicker$1.label = 1;
                    if (kotlinx.coroutines.DelayKt.delay(j2, tickerChannelsKt$fixedPeriodTicker$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    j4 = nanoTime;
                } else if (i == 1) {
                    j4 = tickerChannelsKt$fixedPeriodTicker$1.J$1;
                    long j7 = tickerChannelsKt$fixedPeriodTicker$1.J$0;
                    kotlinx.coroutines.channels.SendChannel sendChannel4 = (kotlinx.coroutines.channels.SendChannel) tickerChannelsKt$fixedPeriodTicker$1.L$0;
                    kotlin.ResultKt.throwOnFailure(obj);
                    sendChannel2 = sendChannel4;
                    j3 = j7;
                } else if (i != 2) {
                    if (i == 3) {
                        j6 = tickerChannelsKt$fixedPeriodTicker$1.J$1;
                        j5 = tickerChannelsKt$fixedPeriodTicker$1.J$0;
                        sendChannel3 = (kotlinx.coroutines.channels.SendChannel) tickerChannelsKt$fixedPeriodTicker$1.L$0;
                        kotlin.ResultKt.throwOnFailure(obj);
                    } else {
                        if (i != 4) {
                            throw new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        j6 = tickerChannelsKt$fixedPeriodTicker$1.J$1;
                        j5 = tickerChannelsKt$fixedPeriodTicker$1.J$0;
                        sendChannel3 = (kotlinx.coroutines.channels.SendChannel) tickerChannelsKt$fixedPeriodTicker$1.L$0;
                        kotlin.ResultKt.throwOnFailure(obj);
                    }
                    long j8 = j6;
                    j4 = j5;
                    delayToNanos = j8;
                    sendChannel2 = sendChannel3;
                    long j9 = j4 + delayToNanos;
                    unit = kotlin.Unit.INSTANCE;
                    tickerChannelsKt$fixedPeriodTicker$1.L$0 = sendChannel2;
                    tickerChannelsKt$fixedPeriodTicker$1.J$0 = j9;
                    tickerChannelsKt$fixedPeriodTicker$1.J$1 = delayToNanos;
                    tickerChannelsKt$fixedPeriodTicker$1.label = 2;
                    if (sendChannel2.send(unit, tickerChannelsKt$fixedPeriodTicker$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    sendChannel3 = sendChannel2;
                    j6 = delayToNanos;
                    j5 = j9;
                    kotlinx.coroutines.AbstractTimeSource timeSource2 = kotlinx.coroutines.AbstractTimeSourceKt.getTimeSource();
                    long nanoTime2 = timeSource2 != null ? java.lang.System.nanoTime() : timeSource2.nanoTime();
                    coerceAtLeast = kotlin.ranges.RangesKt___RangesKt.coerceAtLeast(j5 - nanoTime2, 0L);
                    if (coerceAtLeast == 0 || j6 == 0) {
                        delayNanosToMillis = kotlinx.coroutines.EventLoop_commonKt.delayNanosToMillis(coerceAtLeast);
                        tickerChannelsKt$fixedPeriodTicker$1.L$0 = sendChannel3;
                        tickerChannelsKt$fixedPeriodTicker$1.J$0 = j5;
                        tickerChannelsKt$fixedPeriodTicker$1.J$1 = j6;
                        tickerChannelsKt$fixedPeriodTicker$1.label = 4;
                        if (kotlinx.coroutines.DelayKt.delay(delayNanosToMillis, tickerChannelsKt$fixedPeriodTicker$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        long j10 = j6 - ((nanoTime2 - j5) % j6);
                        j5 = nanoTime2 + j10;
                        long delayNanosToMillis2 = kotlinx.coroutines.EventLoop_commonKt.delayNanosToMillis(j10);
                        tickerChannelsKt$fixedPeriodTicker$1.L$0 = sendChannel3;
                        tickerChannelsKt$fixedPeriodTicker$1.J$0 = j5;
                        tickerChannelsKt$fixedPeriodTicker$1.J$1 = j6;
                        tickerChannelsKt$fixedPeriodTicker$1.label = 3;
                        if (kotlinx.coroutines.DelayKt.delay(delayNanosToMillis2, tickerChannelsKt$fixedPeriodTicker$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    long j82 = j6;
                    j4 = j5;
                    delayToNanos = j82;
                    sendChannel2 = sendChannel3;
                    long j92 = j4 + delayToNanos;
                    unit = kotlin.Unit.INSTANCE;
                    tickerChannelsKt$fixedPeriodTicker$1.L$0 = sendChannel2;
                    tickerChannelsKt$fixedPeriodTicker$1.J$0 = j92;
                    tickerChannelsKt$fixedPeriodTicker$1.J$1 = delayToNanos;
                    tickerChannelsKt$fixedPeriodTicker$1.label = 2;
                    if (sendChannel2.send(unit, tickerChannelsKt$fixedPeriodTicker$1) == coroutine_suspended) {
                    }
                } else {
                    j6 = tickerChannelsKt$fixedPeriodTicker$1.J$1;
                    j5 = tickerChannelsKt$fixedPeriodTicker$1.J$0;
                    sendChannel3 = (kotlinx.coroutines.channels.SendChannel) tickerChannelsKt$fixedPeriodTicker$1.L$0;
                    kotlin.ResultKt.throwOnFailure(obj);
                    kotlinx.coroutines.AbstractTimeSource timeSource22 = kotlinx.coroutines.AbstractTimeSourceKt.getTimeSource();
                    if (timeSource22 != null) {
                    }
                    coerceAtLeast = kotlin.ranges.RangesKt___RangesKt.coerceAtLeast(j5 - nanoTime2, 0L);
                    if (coerceAtLeast == 0) {
                    }
                    delayNanosToMillis = kotlinx.coroutines.EventLoop_commonKt.delayNanosToMillis(coerceAtLeast);
                    tickerChannelsKt$fixedPeriodTicker$1.L$0 = sendChannel3;
                    tickerChannelsKt$fixedPeriodTicker$1.J$0 = j5;
                    tickerChannelsKt$fixedPeriodTicker$1.J$1 = j6;
                    tickerChannelsKt$fixedPeriodTicker$1.label = 4;
                    if (kotlinx.coroutines.DelayKt.delay(delayNanosToMillis, tickerChannelsKt$fixedPeriodTicker$1) == coroutine_suspended) {
                    }
                    long j822 = j6;
                    j4 = j5;
                    delayToNanos = j822;
                    sendChannel2 = sendChannel3;
                    long j922 = j4 + delayToNanos;
                    unit = kotlin.Unit.INSTANCE;
                    tickerChannelsKt$fixedPeriodTicker$1.L$0 = sendChannel2;
                    tickerChannelsKt$fixedPeriodTicker$1.J$0 = j922;
                    tickerChannelsKt$fixedPeriodTicker$1.J$1 = delayToNanos;
                    tickerChannelsKt$fixedPeriodTicker$1.label = 2;
                    if (sendChannel2.send(unit, tickerChannelsKt$fixedPeriodTicker$1) == coroutine_suspended) {
                    }
                }
                delayToNanos = kotlinx.coroutines.EventLoop_commonKt.delayToNanos(j3);
                long j9222 = j4 + delayToNanos;
                unit = kotlin.Unit.INSTANCE;
                tickerChannelsKt$fixedPeriodTicker$1.L$0 = sendChannel2;
                tickerChannelsKt$fixedPeriodTicker$1.J$0 = j9222;
                tickerChannelsKt$fixedPeriodTicker$1.J$1 = delayToNanos;
                tickerChannelsKt$fixedPeriodTicker$1.label = 2;
                if (sendChannel2.send(unit, tickerChannelsKt$fixedPeriodTicker$1) == coroutine_suspended) {
                }
            }
        }
        tickerChannelsKt$fixedPeriodTicker$1 = new kotlinx.coroutines.channels.TickerChannelsKt$fixedPeriodTicker$1(continuation);
        java.lang.Object obj2 = tickerChannelsKt$fixedPeriodTicker$1.result;
        coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = tickerChannelsKt$fixedPeriodTicker$1.label;
        if (i != 0) {
        }
        delayToNanos = kotlinx.coroutines.EventLoop_commonKt.delayToNanos(j3);
        long j92222 = j4 + delayToNanos;
        unit = kotlin.Unit.INSTANCE;
        tickerChannelsKt$fixedPeriodTicker$1.L$0 = sendChannel2;
        tickerChannelsKt$fixedPeriodTicker$1.J$0 = j92222;
        tickerChannelsKt$fixedPeriodTicker$1.J$1 = delayToNanos;
        tickerChannelsKt$fixedPeriodTicker$1.label = 2;
        if (sendChannel2.send(unit, tickerChannelsKt$fixedPeriodTicker$1) == coroutine_suspended) {
        }
    }

    @kotlinx.coroutines.ObsoleteCoroutinesApi
    @org.jetbrains.annotations.NotNull
    public static final kotlinx.coroutines.channels.ReceiveChannel<kotlin.Unit> ticker(long j, long j2, @org.jetbrains.annotations.NotNull kotlin.coroutines.CoroutineContext coroutineContext, @org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.TickerMode tickerMode) {
        if (!(j >= 0)) {
            throw new java.lang.IllegalArgumentException(("Expected non-negative delay, but has " + j + " ms").toString());
        }
        if (j2 >= 0) {
            return kotlinx.coroutines.channels.ProduceKt.produce(kotlinx.coroutines.GlobalScope.INSTANCE, kotlinx.coroutines.Dispatchers.getUnconfined().plus(coroutineContext), 0, new kotlinx.coroutines.channels.TickerChannelsKt$ticker$3(tickerMode, j, j2, null));
        }
        throw new java.lang.IllegalArgumentException(("Expected non-negative initial delay, but has " + j2 + " ms").toString());
    }

    public static /* synthetic */ kotlinx.coroutines.channels.ReceiveChannel ticker$default(long j, long j2, kotlin.coroutines.CoroutineContext coroutineContext, kotlinx.coroutines.channels.TickerMode tickerMode, int i, java.lang.Object obj) {
        if ((i & 2) != 0) {
            j2 = j;
        }
        if ((i & 4) != 0) {
            coroutineContext = kotlin.coroutines.EmptyCoroutineContext.INSTANCE;
        }
        if ((i & 8) != 0) {
            tickerMode = kotlinx.coroutines.channels.TickerMode.FIXED_PERIOD;
        }
        return ticker(j, j2, coroutineContext, tickerMode);
    }
}
