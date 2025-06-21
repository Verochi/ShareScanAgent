package kotlinx.coroutines.debug.internal;

@kotlin.Metadata(d1 = {"\u0000Æ\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\"\n\u0002\b\u000b\bÀ\u0002\u0018\u00002\u00020\u0001:\u0002\u008b\u0001B\n\b\u0002¢\u0006\u0005\b\u008a\u0001\u0010\u0004J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\u0015\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u0013\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0013\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000b¢\u0006\u0004\b\u0010\u0010\u000eJ\u0015\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J)\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00160\u000b2\u0006\u0010\u0015\u001a\u00020\f2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u000b¢\u0006\u0004\b\u0018\u0010\u0019J\u001b\u0010\u001e\u001a\u00020\u00022\n\u0010\u001b\u001a\u0006\u0012\u0002\b\u00030\u001aH\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ\u001b\u0010 \u001a\u00020\u00022\n\u0010\u001b\u001a\u0006\u0012\u0002\b\u00030\u001aH\u0000¢\u0006\u0004\b\u001f\u0010\u001dJ)\u0010%\u001a\b\u0012\u0004\u0012\u00028\u00000\u001a\"\u0004\b\u0000\u0010!2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000\u001aH\u0000¢\u0006\u0004\b#\u0010$J\u001d\u0010(\u001a\u0010\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u0002\u0018\u00010&H\u0002¢\u0006\u0004\b(\u0010)J\u000f\u0010*\u001a\u00020\u0002H\u0002¢\u0006\u0004\b*\u0010\u0004J\u000f\u0010+\u001a\u00020\u0002H\u0002¢\u0006\u0004\b+\u0010\u0004J;\u00103\u001a\u00020\u0002*\u00020\u00062\u0012\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020-0,2\n\u00101\u001a\u00060/j\u0002`02\u0006\u00102\u001a\u00020\bH\u0002¢\u0006\u0004\b3\u00104J\u0017\u00106\u001a\u00020'*\u0006\u0012\u0002\b\u000305H\u0002¢\u0006\u0004\b6\u00107J\u0017\u00108\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b8\u0010\u0014J%\u0010:\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00112\f\u00109\u001a\b\u0012\u0004\u0012\u00020\u00160\u000bH\u0002¢\u0006\u0004\b:\u0010;J5\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00160\u000b2\u0006\u0010<\u001a\u00020\b2\b\u0010>\u001a\u0004\u0018\u00010=2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u000bH\u0002¢\u0006\u0004\b?\u0010@J?\u0010F\u001a\u000e\u0012\u0004\u0012\u00020A\u0012\u0004\u0012\u00020A0E2\u0006\u0010B\u001a\u00020A2\f\u0010D\u001a\b\u0012\u0004\u0012\u00020\u00160C2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u000bH\u0002¢\u0006\u0004\bF\u0010GJ3\u0010I\u001a\u00020A2\u0006\u0010H\u001a\u00020A2\f\u0010D\u001a\b\u0012\u0004\u0012\u00020\u00160C2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u000bH\u0002¢\u0006\u0004\bI\u0010JJ#\u0010K\u001a\u00020\u00022\n\u0010\u001b\u001a\u0006\u0012\u0002\b\u00030\u001a2\u0006\u0010<\u001a\u00020\bH\u0002¢\u0006\u0004\bK\u0010LJ\u001f\u0010N\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020M2\u0006\u0010<\u001a\u00020\bH\u0002¢\u0006\u0004\bN\u0010OJ\u0016\u0010P\u001a\u0004\u0018\u00010M*\u00020MH\u0082\u0010¢\u0006\u0004\bP\u0010QJ/\u0010S\u001a\u00020\u00022\n\u0010R\u001a\u0006\u0012\u0002\b\u0003052\n\u0010\u001b\u001a\u0006\u0012\u0002\b\u00030\u001a2\u0006\u0010<\u001a\u00020\bH\u0002¢\u0006\u0004\bS\u0010TJ\u001d\u0010U\u001a\b\u0012\u0002\b\u0003\u0018\u000105*\u0006\u0012\u0002\b\u00030\u001aH\u0002¢\u0006\u0004\bU\u0010VJ\u001a\u0010W\u001a\b\u0012\u0002\b\u0003\u0018\u000105*\u00020MH\u0082\u0010¢\u0006\u0004\bW\u0010XJ\u001b\u0010Z\u001a\u0004\u0018\u00010Y*\b\u0012\u0004\u0012\u00020\u00160\u000bH\u0002¢\u0006\u0004\bZ\u0010[J3\u0010\\\u001a\b\u0012\u0004\u0012\u00028\u00000\u001a\"\u0004\b\u0000\u0010!2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010YH\u0002¢\u0006\u0004\b\\\u0010]J\u001b\u0010^\u001a\u00020\u00022\n\u0010R\u001a\u0006\u0012\u0002\b\u000305H\u0002¢\u0006\u0004\b^\u0010_J'\u0010b\u001a\b\u0012\u0004\u0012\u00020\u00160\u000b\"\b\b\u0000\u0010!*\u00020`2\u0006\u0010a\u001a\u00028\u0000H\u0002¢\u0006\u0004\bb\u0010cR\u0014\u0010f\u001a\u00020d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u0010eR\u0018\u0010h\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\\\u0010gR$\u0010k\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u000305\u0012\u0004\u0012\u00020'0i8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u0010jR\u0016\u0010l\u001a\u00020A8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bl\u0010mR\u0014\u0010p\u001a\u00020n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bI\u0010oR\"\u0010w\u001a\u00020'8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bq\u0010r\u001a\u0004\bs\u0010t\"\u0004\bu\u0010vR\"\u0010{\u001a\u00020'8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bx\u0010r\u001a\u0004\by\u0010t\"\u0004\bz\u0010vR\"\u0010}\u001a\u0010\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u0002\u0018\u00010&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010|R \u0010~\u001a\u000e\u0012\u0004\u0012\u00020M\u0012\u0004\u0012\u00020-0i8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u0010jR\u0015\u0010\u0080\u0001\u001a\u00020'8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u007f\u0010tR!\u0010\u0083\u0001\u001a\r\u0012\b\u0012\u0006\u0012\u0002\b\u0003050\u0081\u00018BX\u0082\u0004¢\u0006\u0007\u001a\u0005\bq\u0010\u0082\u0001R!\u0010\u0086\u0001\u001a\u00020\b*\u00020\u00068BX\u0082\u0004¢\u0006\u000e\u0012\u0006\b\u0084\u0001\u0010\u0085\u0001\u001a\u0004\bx\u0010\nR\u001b\u0010\u0089\u0001\u001a\u00020'*\u00020\u00168BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u0087\u0001\u0010\u0088\u0001¨\u0006\u008c\u0001"}, d2 = {"Lkotlinx/coroutines/debug/internal/DebugProbesImpl;", "", "", "install", "()V", "uninstall", "Lkotlinx/coroutines/Job;", "job", "", "hierarchyToString", "(Lkotlinx/coroutines/Job;)Ljava/lang/String;", "", "Lkotlinx/coroutines/debug/internal/DebugCoroutineInfo;", "dumpCoroutinesInfo", "()Ljava/util/List;", "Lkotlinx/coroutines/debug/internal/DebuggerInfo;", "dumpDebuggerInfo", "Ljava/io/PrintStream;", "out", "dumpCoroutines", "(Ljava/io/PrintStream;)V", "info", "Ljava/lang/StackTraceElement;", "coroutineTrace", "enhanceStackTraceWithThreadDump", "(Lkotlinx/coroutines/debug/internal/DebugCoroutineInfo;Ljava/util/List;)Ljava/util/List;", "Lkotlin/coroutines/Continuation;", com.otaliastudios.cameraview.video.encoding.TextureMediaEncoder.FRAME_EVENT, "probeCoroutineResumed$kotlinx_coroutines_core", "(Lkotlin/coroutines/Continuation;)V", "probeCoroutineResumed", "probeCoroutineSuspended$kotlinx_coroutines_core", "probeCoroutineSuspended", androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "completion", "probeCoroutineCreated$kotlinx_coroutines_core", "(Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;", "probeCoroutineCreated", "Lkotlin/Function1;", "", "i", "()Lkotlin/jvm/functions/Function1;", "r", "s", "", "Lkotlinx/coroutines/debug/internal/DebugCoroutineInfoImpl;", "map", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "builder", "indent", "a", "(Lkotlinx/coroutines/Job;Ljava/util/Map;Ljava/lang/StringBuilder;Ljava/lang/String;)V", "Lkotlinx/coroutines/debug/internal/DebugProbesImpl$CoroutineOwner;", "j", "(Lkotlinx/coroutines/debug/internal/DebugProbesImpl$CoroutineOwner;)Z", "c", com.anythink.expressad.foundation.d.d.j, com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.AD_COUNT, "(Ljava/io/PrintStream;Ljava/util/List;)V", com.anythink.expressad.atsignalcommon.mraid.CallMraidJS.b, "Ljava/lang/Thread;", "thread", "d", "(Ljava/lang/String;Ljava/lang/Thread;Ljava/util/List;)Ljava/util/List;", "", "indexOfResumeWith", "", "actualTrace", "Lkotlin/Pair;", "e", "(I[Ljava/lang/StackTraceElement;Ljava/util/List;)Lkotlin/Pair;", "frameIndex", "f", "(I[Ljava/lang/StackTraceElement;Ljava/util/List;)I", "v", "(Lkotlin/coroutines/Continuation;Ljava/lang/String;)V", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", com.umeng.analytics.pro.bo.aN, "(Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;Ljava/lang/String;)V", "p", "(Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;)Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "owner", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.WIDTH, "(Lkotlinx/coroutines/debug/internal/DebugProbesImpl$CoroutineOwner;Lkotlin/coroutines/Continuation;Ljava/lang/String;)V", "l", "(Lkotlin/coroutines/Continuation;)Lkotlinx/coroutines/debug/internal/DebugProbesImpl$CoroutineOwner;", com.anythink.expressad.d.a.b.dH, "(Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;)Lkotlinx/coroutines/debug/internal/DebugProbesImpl$CoroutineOwner;", "Lkotlinx/coroutines/debug/internal/StackTraceFrame;", "t", "(Ljava/util/List;)Lkotlinx/coroutines/debug/internal/StackTraceFrame;", "b", "(Lkotlin/coroutines/Continuation;Lkotlinx/coroutines/debug/internal/StackTraceFrame;)Lkotlin/coroutines/Continuation;", "o", "(Lkotlinx/coroutines/debug/internal/DebugProbesImpl$CoroutineOwner;)V", "", "throwable", "q", "(Ljava/lang/Throwable;)Ljava/util/List;", "Ljava/text/SimpleDateFormat;", "Ljava/text/SimpleDateFormat;", "dateFormat", "Ljava/lang/Thread;", "weakRefCleanerThread", "Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap;", "Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap;", "capturedCoroutinesMap", "installations", "I", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "coroutineStateLock", "g", "Z", "getSanitizeStackTraces", "()Z", "setSanitizeStackTraces", "(Z)V", "sanitizeStackTraces", "h", "getEnableCreationStackTraces", "setEnableCreationStackTraces", "enableCreationStackTraces", "Lkotlin/jvm/functions/Function1;", "dynamicAttach", "callerInfoCache", "isInstalled$kotlinx_coroutines_core", "isInstalled", "", "()Ljava/util/Set;", "capturedCoroutines", "getDebugString$annotations", "(Lkotlinx/coroutines/Job;)V", "debugString", "k", "(Ljava/lang/StackTraceElement;)Z", "isInternalMethod", "<init>", "CoroutineOwner", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes16.dex */
public final class DebugProbesImpl {

    @org.jetbrains.annotations.NotNull
    public static final kotlinx.coroutines.debug.internal.DebugProbesImpl INSTANCE;

    /* renamed from: a, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public static final java.text.SimpleDateFormat dateFormat;

    /* renamed from: b, reason: from kotlin metadata */
    @org.jetbrains.annotations.Nullable
    public static java.lang.Thread weakRefCleanerThread;

    /* renamed from: c, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public static final kotlinx.coroutines.debug.internal.ConcurrentWeakMap<kotlinx.coroutines.debug.internal.DebugProbesImpl.CoroutineOwner<?>, java.lang.Boolean> capturedCoroutinesMap;

    @org.jetbrains.annotations.NotNull
    public static final /* synthetic */ kotlinx.coroutines.debug.internal.DebugProbesImpl.SequenceNumberRefVolatile d;
    public static final /* synthetic */ java.util.concurrent.atomic.AtomicLongFieldUpdater e;

    /* renamed from: f, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public static final java.util.concurrent.locks.ReentrantReadWriteLock coroutineStateLock;

    /* renamed from: g, reason: from kotlin metadata */
    public static boolean sanitizeStackTraces;

    /* renamed from: h, reason: from kotlin metadata */
    public static boolean enableCreationStackTraces;

    /* renamed from: i, reason: from kotlin metadata */
    @org.jetbrains.annotations.Nullable
    public static final kotlin.jvm.functions.Function1<java.lang.Boolean, kotlin.Unit> dynamicAttach;
    private static volatile int installations;

    /* renamed from: j, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public static final kotlinx.coroutines.debug.internal.ConcurrentWeakMap<kotlin.coroutines.jvm.internal.CoroutineStackFrame, kotlinx.coroutines.debug.internal.DebugCoroutineInfo> callerInfoCache;

    @kotlin.Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\u00020\u0003B'\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u001e\u0010\u001fJ\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J \u0010\t\u001a\u00020\b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0016ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ\b\u0010\f\u001a\u00020\u000bH\u0016R\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\u00108\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0016\u001a\u0004\u0018\u00010\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u00178\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001d\u001a\u0004\u0018\u00010\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006 "}, d2 = {"Lkotlinx/coroutines/debug/internal/DebugProbesImpl$CoroutineOwner;", androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/coroutines/Continuation;", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Ljava/lang/StackTraceElement;", "getStackTraceElement", "Lkotlin/Result;", "result", "", "resumeWith", "(Ljava/lang/Object;)V", "", "toString", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.AD_COUNT, "Lkotlin/coroutines/Continuation;", "delegate", "Lkotlinx/coroutines/debug/internal/DebugCoroutineInfoImpl;", "t", "Lkotlinx/coroutines/debug/internal/DebugCoroutineInfoImpl;", "info", com.umeng.analytics.pro.bo.aN, "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", com.otaliastudios.cameraview.video.encoding.TextureMediaEncoder.FRAME_EVENT, "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "context", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "callerFrame", "<init>", "(Lkotlin/coroutines/Continuation;Lkotlinx/coroutines/debug/internal/DebugCoroutineInfoImpl;Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1})
    public static final class CoroutineOwner<T> implements kotlin.coroutines.Continuation<T>, kotlin.coroutines.jvm.internal.CoroutineStackFrame {

        /* renamed from: n, reason: from kotlin metadata */
        @kotlin.jvm.JvmField
        @org.jetbrains.annotations.NotNull
        public final kotlin.coroutines.Continuation<T> delegate;

        /* renamed from: t, reason: from kotlin metadata */
        @kotlin.jvm.JvmField
        @org.jetbrains.annotations.NotNull
        public final kotlinx.coroutines.debug.internal.DebugCoroutineInfo info;

        /* renamed from: u, reason: from kotlin metadata */
        @org.jetbrains.annotations.Nullable
        public final kotlin.coroutines.jvm.internal.CoroutineStackFrame frame;

        /* JADX WARN: Multi-variable type inference failed */
        public CoroutineOwner(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super T> continuation, @org.jetbrains.annotations.NotNull kotlinx.coroutines.debug.internal.DebugCoroutineInfo debugCoroutineInfo, @org.jetbrains.annotations.Nullable kotlin.coroutines.jvm.internal.CoroutineStackFrame coroutineStackFrame) {
            this.delegate = continuation;
            this.info = debugCoroutineInfo;
            this.frame = coroutineStackFrame;
        }

        @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
        @org.jetbrains.annotations.Nullable
        public kotlin.coroutines.jvm.internal.CoroutineStackFrame getCallerFrame() {
            kotlin.coroutines.jvm.internal.CoroutineStackFrame coroutineStackFrame = this.frame;
            if (coroutineStackFrame == null) {
                return null;
            }
            return coroutineStackFrame.getCallerFrame();
        }

        @Override // kotlin.coroutines.Continuation
        @org.jetbrains.annotations.NotNull
        public kotlin.coroutines.CoroutineContext getContext() {
            return this.delegate.getContext();
        }

        @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
        @org.jetbrains.annotations.Nullable
        public java.lang.StackTraceElement getStackTraceElement() {
            kotlin.coroutines.jvm.internal.CoroutineStackFrame coroutineStackFrame = this.frame;
            if (coroutineStackFrame == null) {
                return null;
            }
            return coroutineStackFrame.getStackTraceElement();
        }

        @Override // kotlin.coroutines.Continuation
        public void resumeWith(@org.jetbrains.annotations.NotNull java.lang.Object result) {
            kotlinx.coroutines.debug.internal.DebugProbesImpl.INSTANCE.o(this);
            this.delegate.resumeWith(result);
        }

        @org.jetbrains.annotations.NotNull
        public java.lang.String toString() {
            return this.delegate.toString();
        }
    }

    /* synthetic */ class SequenceNumberRefVolatile {
        volatile long sequenceNumber;

        public SequenceNumberRefVolatile(long j) {
            this.sequenceNumber = j;
        }
    }

    static {
        kotlinx.coroutines.debug.internal.DebugProbesImpl debugProbesImpl = new kotlinx.coroutines.debug.internal.DebugProbesImpl();
        INSTANCE = debugProbesImpl;
        dateFormat = new java.text.SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        capturedCoroutinesMap = new kotlinx.coroutines.debug.internal.ConcurrentWeakMap<>(false, 1, null);
        d = new kotlinx.coroutines.debug.internal.DebugProbesImpl.SequenceNumberRefVolatile(0L);
        coroutineStateLock = new java.util.concurrent.locks.ReentrantReadWriteLock();
        sanitizeStackTraces = true;
        enableCreationStackTraces = true;
        dynamicAttach = debugProbesImpl.i();
        callerInfoCache = new kotlinx.coroutines.debug.internal.ConcurrentWeakMap<>(true);
        e = java.util.concurrent.atomic.AtomicLongFieldUpdater.newUpdater(kotlinx.coroutines.debug.internal.DebugProbesImpl.SequenceNumberRefVolatile.class, "sequenceNumber");
    }

    public final void a(kotlinx.coroutines.Job job, java.util.Map<kotlinx.coroutines.Job, kotlinx.coroutines.debug.internal.DebugCoroutineInfo> map, java.lang.StringBuilder sb, java.lang.String str) {
        java.lang.Object firstOrNull;
        kotlinx.coroutines.debug.internal.DebugCoroutineInfo debugCoroutineInfo = map.get(job);
        if (debugCoroutineInfo != null) {
            firstOrNull = kotlin.collections.CollectionsKt___CollectionsKt.firstOrNull((java.util.List<? extends java.lang.Object>) debugCoroutineInfo.lastObservedStackTrace());
            sb.append(str + h(job) + ", continuation is " + debugCoroutineInfo.get_state() + " at line " + ((java.lang.StackTraceElement) firstOrNull) + '\n');
            str = kotlin.jvm.internal.Intrinsics.stringPlus(str, "\t");
        } else if (!(job instanceof kotlinx.coroutines.internal.ScopeCoroutine)) {
            sb.append(str + h(job) + '\n');
            str = kotlin.jvm.internal.Intrinsics.stringPlus(str, "\t");
        }
        java.util.Iterator<kotlinx.coroutines.Job> it = job.getChildren().iterator();
        while (it.hasNext()) {
            a(it.next(), map, sb, str);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T> kotlin.coroutines.Continuation<T> b(kotlin.coroutines.Continuation<? super T> completion, kotlinx.coroutines.debug.internal.StackTraceFrame frame) {
        if (!isInstalled$kotlinx_coroutines_core()) {
            return completion;
        }
        kotlinx.coroutines.debug.internal.DebugProbesImpl.CoroutineOwner<?> coroutineOwner = new kotlinx.coroutines.debug.internal.DebugProbesImpl.CoroutineOwner<>(completion, new kotlinx.coroutines.debug.internal.DebugCoroutineInfo(completion.getContext(), frame, e.incrementAndGet(d)), frame);
        kotlinx.coroutines.debug.internal.ConcurrentWeakMap<kotlinx.coroutines.debug.internal.DebugProbesImpl.CoroutineOwner<?>, java.lang.Boolean> concurrentWeakMap = capturedCoroutinesMap;
        concurrentWeakMap.put(coroutineOwner, java.lang.Boolean.TRUE);
        if (!isInstalled$kotlinx_coroutines_core()) {
            concurrentWeakMap.clear();
        }
        return coroutineOwner;
    }

    public final void c(java.io.PrintStream out) {
        java.util.concurrent.locks.ReentrantReadWriteLock reentrantReadWriteLock = coroutineStateLock;
        java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
        int i = 0;
        int readHoldCount = reentrantReadWriteLock.getWriteHoldCount() == 0 ? reentrantReadWriteLock.getReadHoldCount() : 0;
        for (int i2 = 0; i2 < readHoldCount; i2++) {
            readLock.unlock();
        }
        java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
        writeLock.lock();
        try {
            kotlinx.coroutines.debug.internal.DebugProbesImpl debugProbesImpl = INSTANCE;
            if (!debugProbesImpl.isInstalled$kotlinx_coroutines_core()) {
                throw new java.lang.IllegalStateException("Debug probes are not installed".toString());
            }
            out.print(kotlin.jvm.internal.Intrinsics.stringPlus("Coroutines dump ", dateFormat.format(java.lang.Long.valueOf(java.lang.System.currentTimeMillis()))));
            for (kotlinx.coroutines.debug.internal.DebugProbesImpl.CoroutineOwner coroutineOwner : kotlin.sequences.SequencesKt___SequencesKt.sortedWith(kotlin.sequences.SequencesKt___SequencesKt.filter(kotlin.collections.CollectionsKt___CollectionsKt.asSequence(debugProbesImpl.g()), kotlinx.coroutines.debug.internal.DebugProbesImpl$dumpCoroutinesSynchronized$1$2.INSTANCE), new kotlinx.coroutines.debug.internal.DebugProbesImpl$dumpCoroutinesSynchronized$lambda21$$inlined$sortedBy$1())) {
                kotlinx.coroutines.debug.internal.DebugCoroutineInfo debugCoroutineInfo = coroutineOwner.info;
                java.util.List<java.lang.StackTraceElement> lastObservedStackTrace = debugCoroutineInfo.lastObservedStackTrace();
                kotlinx.coroutines.debug.internal.DebugProbesImpl debugProbesImpl2 = INSTANCE;
                java.util.List<java.lang.StackTraceElement> d2 = debugProbesImpl2.d(debugCoroutineInfo.get_state(), debugCoroutineInfo.lastObservedThread, lastObservedStackTrace);
                out.print("\n\nCoroutine " + coroutineOwner.delegate + ", state: " + ((kotlin.jvm.internal.Intrinsics.areEqual(debugCoroutineInfo.get_state(), kotlinx.coroutines.debug.internal.DebugCoroutineInfoImplKt.RUNNING) && d2 == lastObservedStackTrace) ? kotlin.jvm.internal.Intrinsics.stringPlus(debugCoroutineInfo.get_state(), " (Last suspension stacktrace, not an actual stacktrace)") : debugCoroutineInfo.get_state()));
                if (lastObservedStackTrace.isEmpty()) {
                    out.print(kotlin.jvm.internal.Intrinsics.stringPlus("\n\tat ", kotlinx.coroutines.internal.StackTraceRecoveryKt.artificialFrame("Coroutine creation stacktrace")));
                    debugProbesImpl2.n(out, debugCoroutineInfo.getCreationStackTrace());
                } else {
                    debugProbesImpl2.n(out, d2);
                }
            }
            kotlin.Unit unit = kotlin.Unit.INSTANCE;
        } finally {
            while (i < readHoldCount) {
                readLock.lock();
                i++;
            }
            writeLock.unlock();
        }
    }

    public final java.util.List<java.lang.StackTraceElement> d(java.lang.String state, java.lang.Thread thread, java.util.List<java.lang.StackTraceElement> coroutineTrace) {
        java.lang.Object m156constructorimpl;
        if (!kotlin.jvm.internal.Intrinsics.areEqual(state, kotlinx.coroutines.debug.internal.DebugCoroutineInfoImplKt.RUNNING) || thread == null) {
            return coroutineTrace;
        }
        try {
            kotlin.Result.Companion companion = kotlin.Result.INSTANCE;
            m156constructorimpl = kotlin.Result.m156constructorimpl(thread.getStackTrace());
        } catch (java.lang.Throwable th) {
            kotlin.Result.Companion companion2 = kotlin.Result.INSTANCE;
            m156constructorimpl = kotlin.Result.m156constructorimpl(kotlin.ResultKt.createFailure(th));
        }
        if (kotlin.Result.m162isFailureimpl(m156constructorimpl)) {
            m156constructorimpl = null;
        }
        java.lang.StackTraceElement[] stackTraceElementArr = (java.lang.StackTraceElement[]) m156constructorimpl;
        if (stackTraceElementArr == null) {
            return coroutineTrace;
        }
        int length = stackTraceElementArr.length;
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                i2 = -1;
                break;
            }
            java.lang.StackTraceElement stackTraceElement = stackTraceElementArr[i2];
            if (kotlin.jvm.internal.Intrinsics.areEqual(stackTraceElement.getClassName(), "kotlin.coroutines.jvm.internal.BaseContinuationImpl") && kotlin.jvm.internal.Intrinsics.areEqual(stackTraceElement.getMethodName(), "resumeWith") && kotlin.jvm.internal.Intrinsics.areEqual(stackTraceElement.getFileName(), "ContinuationImpl.kt")) {
                break;
            }
            i2++;
        }
        kotlin.Pair<java.lang.Integer, java.lang.Integer> e2 = e(i2, stackTraceElementArr, coroutineTrace);
        int intValue = e2.component1().intValue();
        int intValue2 = e2.component2().intValue();
        if (intValue == -1) {
            return coroutineTrace;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList((((coroutineTrace.size() + i2) - intValue) - 1) - intValue2);
        int i3 = i2 - intValue2;
        if (i3 > 0) {
            while (true) {
                int i4 = i + 1;
                arrayList.add(stackTraceElementArr[i]);
                if (i4 >= i3) {
                    break;
                }
                i = i4;
            }
        }
        int i5 = intValue + 1;
        int size = coroutineTrace.size();
        if (i5 < size) {
            while (true) {
                int i6 = i5 + 1;
                arrayList.add(coroutineTrace.get(i5));
                if (i6 >= size) {
                    break;
                }
                i5 = i6;
            }
        }
        return arrayList;
    }

    public final void dumpCoroutines(@org.jetbrains.annotations.NotNull java.io.PrintStream out) {
        synchronized (out) {
            INSTANCE.c(out);
            kotlin.Unit unit = kotlin.Unit.INSTANCE;
        }
    }

    @org.jetbrains.annotations.NotNull
    public final java.util.List<kotlinx.coroutines.debug.internal.DebugCoroutineInfo> dumpCoroutinesInfo() {
        kotlin.coroutines.CoroutineContext context;
        java.util.concurrent.locks.ReentrantReadWriteLock reentrantReadWriteLock = coroutineStateLock;
        java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
        int i = 0;
        int readHoldCount = reentrantReadWriteLock.getWriteHoldCount() == 0 ? reentrantReadWriteLock.getReadHoldCount() : 0;
        for (int i2 = 0; i2 < readHoldCount; i2++) {
            readLock.unlock();
        }
        java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
        writeLock.lock();
        try {
            kotlinx.coroutines.debug.internal.DebugProbesImpl debugProbesImpl = INSTANCE;
            if (!debugProbesImpl.isInstalled$kotlinx_coroutines_core()) {
                throw new java.lang.IllegalStateException("Debug probes are not installed".toString());
            }
            java.util.List<kotlinx.coroutines.debug.internal.DebugProbesImpl.CoroutineOwner> sortedWith = kotlin.collections.CollectionsKt___CollectionsKt.sortedWith(debugProbesImpl.g(), new kotlinx.coroutines.debug.internal.DebugProbesImpl$dumpCoroutinesInfoImpl$lambda14$$inlined$sortedBy$1());
            java.util.ArrayList arrayList = new java.util.ArrayList();
            for (kotlinx.coroutines.debug.internal.DebugProbesImpl.CoroutineOwner coroutineOwner : sortedWith) {
                kotlinx.coroutines.debug.internal.DebugCoroutineInfo debugCoroutineInfo = null;
                if (!INSTANCE.j(coroutineOwner) && (context = coroutineOwner.info.getContext()) != null) {
                    debugCoroutineInfo = new kotlinx.coroutines.debug.internal.DebugCoroutineInfo(coroutineOwner.info, context);
                }
                if (debugCoroutineInfo != null) {
                    arrayList.add(debugCoroutineInfo);
                }
            }
            return arrayList;
        } finally {
            while (i < readHoldCount) {
                readLock.lock();
                i++;
            }
            writeLock.unlock();
        }
    }

    @org.jetbrains.annotations.NotNull
    public final java.util.List<kotlinx.coroutines.debug.internal.DebuggerInfo> dumpDebuggerInfo() {
        kotlin.coroutines.CoroutineContext context;
        java.util.concurrent.locks.ReentrantReadWriteLock reentrantReadWriteLock = coroutineStateLock;
        java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
        int i = 0;
        int readHoldCount = reentrantReadWriteLock.getWriteHoldCount() == 0 ? reentrantReadWriteLock.getReadHoldCount() : 0;
        for (int i2 = 0; i2 < readHoldCount; i2++) {
            readLock.unlock();
        }
        java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
        writeLock.lock();
        try {
            kotlinx.coroutines.debug.internal.DebugProbesImpl debugProbesImpl = INSTANCE;
            if (!debugProbesImpl.isInstalled$kotlinx_coroutines_core()) {
                throw new java.lang.IllegalStateException("Debug probes are not installed".toString());
            }
            java.util.List<kotlinx.coroutines.debug.internal.DebugProbesImpl.CoroutineOwner> sortedWith = kotlin.collections.CollectionsKt___CollectionsKt.sortedWith(debugProbesImpl.g(), new kotlinx.coroutines.debug.internal.DebugProbesImpl$dumpCoroutinesInfoImpl$lambda14$$inlined$sortedBy$1());
            java.util.ArrayList arrayList = new java.util.ArrayList();
            for (kotlinx.coroutines.debug.internal.DebugProbesImpl.CoroutineOwner coroutineOwner : sortedWith) {
                kotlinx.coroutines.debug.internal.DebuggerInfo debuggerInfo = null;
                if (!INSTANCE.j(coroutineOwner) && (context = coroutineOwner.info.getContext()) != null) {
                    debuggerInfo = new kotlinx.coroutines.debug.internal.DebuggerInfo(coroutineOwner.info, context);
                }
                if (debuggerInfo != null) {
                    arrayList.add(debuggerInfo);
                }
            }
            return arrayList;
        } finally {
            while (i < readHoldCount) {
                readLock.lock();
                i++;
            }
            writeLock.unlock();
        }
    }

    public final kotlin.Pair<java.lang.Integer, java.lang.Integer> e(int indexOfResumeWith, java.lang.StackTraceElement[] actualTrace, java.util.List<java.lang.StackTraceElement> coroutineTrace) {
        for (int i = 0; i < 3; i++) {
            int f = INSTANCE.f((indexOfResumeWith - 1) - i, actualTrace, coroutineTrace);
            if (f != -1) {
                return kotlin.TuplesKt.to(java.lang.Integer.valueOf(f), java.lang.Integer.valueOf(i));
            }
        }
        return kotlin.TuplesKt.to(-1, 0);
    }

    @org.jetbrains.annotations.NotNull
    public final java.util.List<java.lang.StackTraceElement> enhanceStackTraceWithThreadDump(@org.jetbrains.annotations.NotNull kotlinx.coroutines.debug.internal.DebugCoroutineInfo info, @org.jetbrains.annotations.NotNull java.util.List<java.lang.StackTraceElement> coroutineTrace) {
        return d(info.getCom.anythink.expressad.atsignalcommon.mraid.CallMraidJS.b java.lang.String(), info.getLastObservedThread(), coroutineTrace);
    }

    public final int f(int frameIndex, java.lang.StackTraceElement[] actualTrace, java.util.List<java.lang.StackTraceElement> coroutineTrace) {
        java.lang.Object orNull;
        orNull = kotlin.collections.ArraysKt___ArraysKt.getOrNull(actualTrace, frameIndex);
        java.lang.StackTraceElement stackTraceElement = (java.lang.StackTraceElement) orNull;
        if (stackTraceElement == null) {
            return -1;
        }
        int i = 0;
        for (java.lang.StackTraceElement stackTraceElement2 : coroutineTrace) {
            if (kotlin.jvm.internal.Intrinsics.areEqual(stackTraceElement2.getFileName(), stackTraceElement.getFileName()) && kotlin.jvm.internal.Intrinsics.areEqual(stackTraceElement2.getClassName(), stackTraceElement.getClassName()) && kotlin.jvm.internal.Intrinsics.areEqual(stackTraceElement2.getMethodName(), stackTraceElement.getMethodName())) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public final java.util.Set<kotlinx.coroutines.debug.internal.DebugProbesImpl.CoroutineOwner<?>> g() {
        return capturedCoroutinesMap.keySet();
    }

    public final boolean getEnableCreationStackTraces() {
        return enableCreationStackTraces;
    }

    public final boolean getSanitizeStackTraces() {
        return sanitizeStackTraces;
    }

    public final java.lang.String h(kotlinx.coroutines.Job job) {
        return job instanceof kotlinx.coroutines.JobSupport ? ((kotlinx.coroutines.JobSupport) job).toDebugString() : job.toString();
    }

    @org.jetbrains.annotations.NotNull
    public final java.lang.String hierarchyToString(@org.jetbrains.annotations.NotNull kotlinx.coroutines.Job job) {
        int mapCapacity;
        int coerceAtLeast;
        java.util.concurrent.locks.ReentrantReadWriteLock reentrantReadWriteLock = coroutineStateLock;
        java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
        int i = 0;
        int readHoldCount = reentrantReadWriteLock.getWriteHoldCount() == 0 ? reentrantReadWriteLock.getReadHoldCount() : 0;
        for (int i2 = 0; i2 < readHoldCount; i2++) {
            readLock.unlock();
        }
        java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
        writeLock.lock();
        try {
            kotlinx.coroutines.debug.internal.DebugProbesImpl debugProbesImpl = INSTANCE;
            if (!debugProbesImpl.isInstalled$kotlinx_coroutines_core()) {
                throw new java.lang.IllegalStateException("Debug probes are not installed".toString());
            }
            java.util.Set<kotlinx.coroutines.debug.internal.DebugProbesImpl.CoroutineOwner<?>> g = debugProbesImpl.g();
            java.util.ArrayList arrayList = new java.util.ArrayList();
            for (java.lang.Object obj : g) {
                if (((kotlinx.coroutines.debug.internal.DebugProbesImpl.CoroutineOwner) obj).delegate.getContext().get(kotlinx.coroutines.Job.INSTANCE) != null) {
                    arrayList.add(obj);
                }
            }
            mapCapacity = kotlin.collections.MapsKt__MapsJVMKt.mapCapacity(kotlin.collections.CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10));
            coerceAtLeast = kotlin.ranges.RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
            java.util.LinkedHashMap linkedHashMap = new java.util.LinkedHashMap(coerceAtLeast);
            for (java.lang.Object obj2 : arrayList) {
                linkedHashMap.put(kotlinx.coroutines.JobKt.getJob(((kotlinx.coroutines.debug.internal.DebugProbesImpl.CoroutineOwner) obj2).delegate.getContext()), ((kotlinx.coroutines.debug.internal.DebugProbesImpl.CoroutineOwner) obj2).info);
            }
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            INSTANCE.a(job, linkedHashMap, sb, "");
            java.lang.String sb2 = sb.toString();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
            return sb2;
        } finally {
            while (i < readHoldCount) {
                readLock.lock();
                i++;
            }
            writeLock.unlock();
        }
    }

    public final kotlin.jvm.functions.Function1<java.lang.Boolean, kotlin.Unit> i() {
        java.lang.Object m156constructorimpl;
        java.lang.Object newInstance;
        try {
            kotlin.Result.Companion companion = kotlin.Result.INSTANCE;
            newInstance = java.lang.Class.forName("kotlinx.coroutines.debug.internal.ByteBuddyDynamicAttach").getConstructors()[0].newInstance(new java.lang.Object[0]);
        } catch (java.lang.Throwable th) {
            kotlin.Result.Companion companion2 = kotlin.Result.INSTANCE;
            m156constructorimpl = kotlin.Result.m156constructorimpl(kotlin.ResultKt.createFailure(th));
        }
        if (newInstance == null) {
            throw new java.lang.NullPointerException("null cannot be cast to non-null type kotlin.Function1<kotlin.Boolean, kotlin.Unit>");
        }
        m156constructorimpl = kotlin.Result.m156constructorimpl((kotlin.jvm.functions.Function1) kotlin.jvm.internal.TypeIntrinsics.beforeCheckcastToFunctionOfArity(newInstance, 1));
        if (kotlin.Result.m162isFailureimpl(m156constructorimpl)) {
            m156constructorimpl = null;
        }
        return (kotlin.jvm.functions.Function1) m156constructorimpl;
    }

    public final void install() {
        java.util.concurrent.locks.ReentrantReadWriteLock reentrantReadWriteLock = coroutineStateLock;
        java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
        int i = 0;
        int readHoldCount = reentrantReadWriteLock.getWriteHoldCount() == 0 ? reentrantReadWriteLock.getReadHoldCount() : 0;
        for (int i2 = 0; i2 < readHoldCount; i2++) {
            readLock.unlock();
        }
        java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
        writeLock.lock();
        try {
            installations++;
            if (installations > 1) {
                return;
            }
            INSTANCE.r();
            if (kotlinx.coroutines.debug.AgentPremain.INSTANCE.isInstalledStatically()) {
                while (i < readHoldCount) {
                    readLock.lock();
                    i++;
                }
                writeLock.unlock();
                return;
            }
            kotlin.jvm.functions.Function1<java.lang.Boolean, kotlin.Unit> function1 = dynamicAttach;
            if (function1 != null) {
                function1.invoke(java.lang.Boolean.TRUE);
            }
            kotlin.Unit unit = kotlin.Unit.INSTANCE;
            while (i < readHoldCount) {
                readLock.lock();
                i++;
            }
            writeLock.unlock();
        } finally {
            while (i < readHoldCount) {
                readLock.lock();
                i++;
            }
            writeLock.unlock();
        }
    }

    public final boolean isInstalled$kotlinx_coroutines_core() {
        return installations > 0;
    }

    public final boolean j(kotlinx.coroutines.debug.internal.DebugProbesImpl.CoroutineOwner<?> coroutineOwner) {
        kotlin.coroutines.CoroutineContext context = coroutineOwner.info.getContext();
        kotlinx.coroutines.Job job = context == null ? null : (kotlinx.coroutines.Job) context.get(kotlinx.coroutines.Job.INSTANCE);
        if (job == null || !job.isCompleted()) {
            return false;
        }
        capturedCoroutinesMap.remove(coroutineOwner);
        return true;
    }

    public final boolean k(java.lang.StackTraceElement stackTraceElement) {
        return kotlin.text.StringsKt__StringsJVMKt.startsWith$default(stackTraceElement.getClassName(), "kotlinx.coroutines", false, 2, null);
    }

    public final kotlinx.coroutines.debug.internal.DebugProbesImpl.CoroutineOwner<?> l(kotlin.coroutines.Continuation<?> continuation) {
        kotlin.coroutines.jvm.internal.CoroutineStackFrame coroutineStackFrame = continuation instanceof kotlin.coroutines.jvm.internal.CoroutineStackFrame ? (kotlin.coroutines.jvm.internal.CoroutineStackFrame) continuation : null;
        if (coroutineStackFrame == null) {
            return null;
        }
        return m(coroutineStackFrame);
    }

    public final kotlinx.coroutines.debug.internal.DebugProbesImpl.CoroutineOwner<?> m(kotlin.coroutines.jvm.internal.CoroutineStackFrame coroutineStackFrame) {
        while (!(coroutineStackFrame instanceof kotlinx.coroutines.debug.internal.DebugProbesImpl.CoroutineOwner)) {
            coroutineStackFrame = coroutineStackFrame.getCallerFrame();
            if (coroutineStackFrame == null) {
                return null;
            }
        }
        return (kotlinx.coroutines.debug.internal.DebugProbesImpl.CoroutineOwner) coroutineStackFrame;
    }

    public final void n(java.io.PrintStream out, java.util.List<java.lang.StackTraceElement> frames) {
        java.util.Iterator<T> it = frames.iterator();
        while (it.hasNext()) {
            out.print(kotlin.jvm.internal.Intrinsics.stringPlus("\n\tat ", (java.lang.StackTraceElement) it.next()));
        }
    }

    public final void o(kotlinx.coroutines.debug.internal.DebugProbesImpl.CoroutineOwner<?> owner) {
        capturedCoroutinesMap.remove(owner);
        kotlin.coroutines.jvm.internal.CoroutineStackFrame lastObservedFrame$kotlinx_coroutines_core = owner.info.getLastObservedFrame$kotlinx_coroutines_core();
        kotlin.coroutines.jvm.internal.CoroutineStackFrame p = lastObservedFrame$kotlinx_coroutines_core == null ? null : p(lastObservedFrame$kotlinx_coroutines_core);
        if (p == null) {
            return;
        }
        callerInfoCache.remove(p);
    }

    public final kotlin.coroutines.jvm.internal.CoroutineStackFrame p(kotlin.coroutines.jvm.internal.CoroutineStackFrame coroutineStackFrame) {
        do {
            coroutineStackFrame = coroutineStackFrame.getCallerFrame();
            if (coroutineStackFrame == null) {
                return null;
            }
        } while (coroutineStackFrame.getStackTraceElement() == null);
        return coroutineStackFrame;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @org.jetbrains.annotations.NotNull
    public final <T> kotlin.coroutines.Continuation<T> probeCoroutineCreated$kotlinx_coroutines_core(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super T> completion) {
        if (isInstalled$kotlinx_coroutines_core() && l(completion) == null) {
            return b(completion, enableCreationStackTraces ? t(q(new java.lang.Exception())) : null);
        }
        return completion;
    }

    public final void probeCoroutineResumed$kotlinx_coroutines_core(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<?> frame) {
        v(frame, kotlinx.coroutines.debug.internal.DebugCoroutineInfoImplKt.RUNNING);
    }

    public final void probeCoroutineSuspended$kotlinx_coroutines_core(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<?> frame) {
        v(frame, kotlinx.coroutines.debug.internal.DebugCoroutineInfoImplKt.SUSPENDED);
    }

    public final <T extends java.lang.Throwable> java.util.List<java.lang.StackTraceElement> q(T throwable) {
        java.lang.StackTraceElement[] stackTrace = throwable.getStackTrace();
        int length = stackTrace.length;
        int i = -1;
        int length2 = stackTrace.length - 1;
        while (true) {
            if (length2 < 0) {
                break;
            }
            if (kotlin.jvm.internal.Intrinsics.areEqual(stackTrace[length2].getClassName(), "kotlin.coroutines.jvm.internal.DebugProbesKt")) {
                i = length2;
                break;
            }
            length2--;
        }
        if (!sanitizeStackTraces) {
            int i2 = length - i;
            java.util.ArrayList arrayList = new java.util.ArrayList(i2);
            int i3 = 0;
            while (i3 < i2) {
                arrayList.add(i3 == 0 ? kotlinx.coroutines.internal.StackTraceRecoveryKt.artificialFrame("Coroutine creation stacktrace") : stackTrace[i3 + i]);
                i3++;
            }
            return arrayList;
        }
        java.util.ArrayList arrayList2 = new java.util.ArrayList((length - i) + 1);
        arrayList2.add(kotlinx.coroutines.internal.StackTraceRecoveryKt.artificialFrame("Coroutine creation stacktrace"));
        while (true) {
            i++;
            while (i < length) {
                if (k(stackTrace[i])) {
                    arrayList2.add(stackTrace[i]);
                    int i4 = i + 1;
                    while (i4 < length && k(stackTrace[i4])) {
                        i4++;
                    }
                    int i5 = i4 - 1;
                    int i6 = i5;
                    while (i6 > i && stackTrace[i6].getFileName() == null) {
                        i6--;
                    }
                    if (i6 > i && i6 < i5) {
                        arrayList2.add(stackTrace[i6]);
                    }
                    arrayList2.add(stackTrace[i5]);
                    i = i4;
                }
            }
            return arrayList2;
            arrayList2.add(stackTrace[i]);
        }
    }

    public final void r() {
        java.lang.Thread thread;
        thread = kotlin.concurrent.ThreadsKt.thread((r12 & 1) != 0, (r12 & 2) != 0 ? false : true, (r12 & 4) != 0 ? null : null, (r12 & 8) != 0 ? null : "Coroutines Debugger Cleaner", (r12 & 16) != 0 ? -1 : 0, kotlinx.coroutines.debug.internal.DebugProbesImpl$startWeakRefCleanerThread$1.INSTANCE);
        weakRefCleanerThread = thread;
    }

    public final void s() {
        java.lang.Thread thread = weakRefCleanerThread;
        if (thread != null) {
            thread.interrupt();
        }
        weakRefCleanerThread = null;
    }

    public final void setEnableCreationStackTraces(boolean z) {
        enableCreationStackTraces = z;
    }

    public final void setSanitizeStackTraces(boolean z) {
        sanitizeStackTraces = z;
    }

    public final kotlinx.coroutines.debug.internal.StackTraceFrame t(java.util.List<java.lang.StackTraceElement> list) {
        kotlinx.coroutines.debug.internal.StackTraceFrame stackTraceFrame = null;
        if (!list.isEmpty()) {
            java.util.ListIterator<java.lang.StackTraceElement> listIterator = list.listIterator(list.size());
            while (listIterator.hasPrevious()) {
                stackTraceFrame = new kotlinx.coroutines.debug.internal.StackTraceFrame(stackTraceFrame, listIterator.previous());
            }
        }
        return stackTraceFrame;
    }

    public final void u(kotlin.coroutines.jvm.internal.CoroutineStackFrame frame, java.lang.String state) {
        java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock readLock = coroutineStateLock.readLock();
        readLock.lock();
        try {
            kotlinx.coroutines.debug.internal.DebugProbesImpl debugProbesImpl = INSTANCE;
            if (debugProbesImpl.isInstalled$kotlinx_coroutines_core()) {
                kotlinx.coroutines.debug.internal.ConcurrentWeakMap<kotlin.coroutines.jvm.internal.CoroutineStackFrame, kotlinx.coroutines.debug.internal.DebugCoroutineInfo> concurrentWeakMap = callerInfoCache;
                kotlinx.coroutines.debug.internal.DebugCoroutineInfo remove = concurrentWeakMap.remove(frame);
                if (remove == null) {
                    kotlinx.coroutines.debug.internal.DebugProbesImpl.CoroutineOwner<?> m = debugProbesImpl.m(frame);
                    kotlin.coroutines.jvm.internal.CoroutineStackFrame coroutineStackFrame = null;
                    remove = m == null ? null : m.info;
                    if (remove == null) {
                        return;
                    }
                    kotlin.coroutines.jvm.internal.CoroutineStackFrame lastObservedFrame$kotlinx_coroutines_core = remove.getLastObservedFrame$kotlinx_coroutines_core();
                    if (lastObservedFrame$kotlinx_coroutines_core != null) {
                        coroutineStackFrame = debugProbesImpl.p(lastObservedFrame$kotlinx_coroutines_core);
                    }
                    if (coroutineStackFrame != null) {
                        concurrentWeakMap.remove(coroutineStackFrame);
                    }
                }
                remove.updateState$kotlinx_coroutines_core(state, (kotlin.coroutines.Continuation) frame);
                kotlin.coroutines.jvm.internal.CoroutineStackFrame p = debugProbesImpl.p(frame);
                if (p == null) {
                    return;
                }
                concurrentWeakMap.put(p, remove);
                kotlin.Unit unit = kotlin.Unit.INSTANCE;
            }
        } finally {
            readLock.unlock();
        }
    }

    public final void uninstall() {
        java.util.concurrent.locks.ReentrantReadWriteLock reentrantReadWriteLock = coroutineStateLock;
        java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
        int i = 0;
        int readHoldCount = reentrantReadWriteLock.getWriteHoldCount() == 0 ? reentrantReadWriteLock.getReadHoldCount() : 0;
        for (int i2 = 0; i2 < readHoldCount; i2++) {
            readLock.unlock();
        }
        java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
        writeLock.lock();
        try {
            kotlinx.coroutines.debug.internal.DebugProbesImpl debugProbesImpl = INSTANCE;
            if (!debugProbesImpl.isInstalled$kotlinx_coroutines_core()) {
                throw new java.lang.IllegalStateException("Agent was not installed".toString());
            }
            installations--;
            if (installations != 0) {
                return;
            }
            debugProbesImpl.s();
            capturedCoroutinesMap.clear();
            callerInfoCache.clear();
            if (kotlinx.coroutines.debug.AgentPremain.INSTANCE.isInstalledStatically()) {
                while (i < readHoldCount) {
                    readLock.lock();
                    i++;
                }
                writeLock.unlock();
                return;
            }
            kotlin.jvm.functions.Function1<java.lang.Boolean, kotlin.Unit> function1 = dynamicAttach;
            if (function1 != null) {
                function1.invoke(java.lang.Boolean.FALSE);
            }
            kotlin.Unit unit = kotlin.Unit.INSTANCE;
            while (i < readHoldCount) {
                readLock.lock();
                i++;
            }
            writeLock.unlock();
        } finally {
            while (i < readHoldCount) {
                readLock.lock();
                i++;
            }
            writeLock.unlock();
        }
    }

    public final void v(kotlin.coroutines.Continuation<?> frame, java.lang.String state) {
        if (isInstalled$kotlinx_coroutines_core()) {
            if (kotlin.jvm.internal.Intrinsics.areEqual(state, kotlinx.coroutines.debug.internal.DebugCoroutineInfoImplKt.RUNNING) && kotlin.KotlinVersion.CURRENT.isAtLeast(1, 3, 30)) {
                kotlin.coroutines.jvm.internal.CoroutineStackFrame coroutineStackFrame = frame instanceof kotlin.coroutines.jvm.internal.CoroutineStackFrame ? (kotlin.coroutines.jvm.internal.CoroutineStackFrame) frame : null;
                if (coroutineStackFrame == null) {
                    return;
                }
                u(coroutineStackFrame, state);
                return;
            }
            kotlinx.coroutines.debug.internal.DebugProbesImpl.CoroutineOwner<?> l = l(frame);
            if (l == null) {
                return;
            }
            w(l, frame, state);
        }
    }

    public final void w(kotlinx.coroutines.debug.internal.DebugProbesImpl.CoroutineOwner<?> owner, kotlin.coroutines.Continuation<?> frame, java.lang.String state) {
        java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock readLock = coroutineStateLock.readLock();
        readLock.lock();
        try {
            if (INSTANCE.isInstalled$kotlinx_coroutines_core()) {
                owner.info.updateState$kotlinx_coroutines_core(state, frame);
                kotlin.Unit unit = kotlin.Unit.INSTANCE;
            }
        } finally {
            readLock.unlock();
        }
    }
}
