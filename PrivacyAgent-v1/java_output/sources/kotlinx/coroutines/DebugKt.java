package kotlinx.coroutines;

@kotlin.Metadata(d1 = {"\u0000\u001e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\b\u0010\u0001\u001a\u00020\u0000H\u0000\"\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004\"\u0014\u0010\u0005\u001a\u00020\u00028\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004\"\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004\"\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004\"\u0014\u0010\b\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\u0004\"\u001a\u0010\u000e\u001a\u00020\t8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u001a\u0010\u0011\u001a\u00020\t8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\r\"\u001a\u0010\u0014\u001a\u00020\t8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u000b\u001a\u0004\b\u0013\u0010\r\"\u001a\u0010\u001a\u001a\u00020\u00158\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001b"}, d2 = {"", "resetCoroutineId", "", "DEBUG_PROPERTY_NAME", "Ljava/lang/String;", "STACKTRACE_RECOVERY_PROPERTY_NAME", "DEBUG_PROPERTY_VALUE_AUTO", "DEBUG_PROPERTY_VALUE_ON", "DEBUG_PROPERTY_VALUE_OFF", "", "a", "Z", "getASSERTIONS_ENABLED", "()Z", "ASSERTIONS_ENABLED", "b", "getDEBUG", "DEBUG", "c", "getRECOVER_STACK_TRACES", "RECOVER_STACK_TRACES", "Ljava/util/concurrent/atomic/AtomicLong;", "d", "Ljava/util/concurrent/atomic/AtomicLong;", "getCOROUTINE_ID", "()Ljava/util/concurrent/atomic/AtomicLong;", "COROUTINE_ID", "kotlinx-coroutines-core"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes15.dex */
public final class DebugKt {

    @org.jetbrains.annotations.NotNull
    public static final java.lang.String DEBUG_PROPERTY_NAME = "kotlinx.coroutines.debug";

    @org.jetbrains.annotations.NotNull
    public static final java.lang.String DEBUG_PROPERTY_VALUE_AUTO = "auto";

    @org.jetbrains.annotations.NotNull
    public static final java.lang.String DEBUG_PROPERTY_VALUE_OFF = "off";

    @org.jetbrains.annotations.NotNull
    public static final java.lang.String DEBUG_PROPERTY_VALUE_ON = "on";

    @org.jetbrains.annotations.NotNull
    public static final java.lang.String STACKTRACE_RECOVERY_PROPERTY_NAME = "kotlinx.coroutines.stacktrace.recovery";
    public static final boolean a = false;
    public static final boolean b;
    public static final boolean c;

    @org.jetbrains.annotations.NotNull
    public static final java.util.concurrent.atomic.AtomicLong d;

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0036, code lost:
    
        if (r0.equals(kotlinx.coroutines.DebugKt.DEBUG_PROPERTY_VALUE_ON) != false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0041, code lost:
    
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x003f, code lost:
    
        if (r0.equals("") != false) goto L23;
     */
    static {
        java.lang.String systemProp = kotlinx.coroutines.internal.SystemPropsKt.systemProp(DEBUG_PROPERTY_NAME);
        if (systemProp != null) {
            int hashCode = systemProp.hashCode();
            if (hashCode != 0) {
                if (hashCode != 3551) {
                    if (hashCode == 109935) {
                    }
                }
                throw new java.lang.IllegalStateException(("System property 'kotlinx.coroutines.debug' has unrecognized value '" + ((java.lang.Object) systemProp) + '\'').toString());
            }
            b = r0;
            c = !r0 && kotlinx.coroutines.internal.SystemPropsKt.systemProp(STACKTRACE_RECOVERY_PROPERTY_NAME, true);
            d = new java.util.concurrent.atomic.AtomicLong(0L);
        }
        boolean z = false;
        b = z;
        c = !z && kotlinx.coroutines.internal.SystemPropsKt.systemProp(STACKTRACE_RECOVERY_PROPERTY_NAME, true);
        d = new java.util.concurrent.atomic.AtomicLong(0L);
    }

    public static final boolean getASSERTIONS_ENABLED() {
        return a;
    }

    @org.jetbrains.annotations.NotNull
    public static final java.util.concurrent.atomic.AtomicLong getCOROUTINE_ID() {
        return d;
    }

    public static final boolean getDEBUG() {
        return b;
    }

    public static final boolean getRECOVER_STACK_TRACES() {
        return c;
    }

    public static final void resetCoroutineId() {
        d.set(0L);
    }
}
