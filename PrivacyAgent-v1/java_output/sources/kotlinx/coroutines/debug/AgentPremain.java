package kotlinx.coroutines.debug;

@kotlin.Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\bÁ\u0002\u0018\u00002\u00020\u0001:\u0001\u0013B\t\b\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\b\u0010\b\u001a\u00020\u0006H\u0002R\"\u0010\u000b\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\n¨\u0006\u0014"}, d2 = {"Lkotlinx/coroutines/debug/AgentPremain;", "", "", "args", "Ljava/lang/instrument/Instrumentation;", "instrumentation", "", "premain", "a", "", "Z", "isInstalledStatically", "()Z", "setInstalledStatically", "(Z)V", "b", "enableCreationStackTraces", "<init>", "()V", "DebugProbesTransformer", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1})
@android.annotation.SuppressLint({"all"})
/* loaded from: classes16.dex */
public final class AgentPremain {

    @org.jetbrains.annotations.NotNull
    public static final kotlinx.coroutines.debug.AgentPremain INSTANCE = new kotlinx.coroutines.debug.AgentPremain();

    /* renamed from: a, reason: from kotlin metadata */
    public static boolean isInstalledStatically;

    /* renamed from: b, reason: from kotlin metadata */
    public static final boolean enableCreationStackTraces;

    @kotlin.Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J:\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0002\b\u0003\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0004H\u0016¨\u0006\u000e"}, d2 = {"Lkotlinx/coroutines/debug/AgentPremain$DebugProbesTransformer;", "Ljava/lang/instrument/ClassFileTransformer;", "()V", "transform", "", "loader", "Ljava/lang/ClassLoader;", com.vivo.push.PushClientConstants.TAG_CLASS_NAME, "", "classBeingRedefined", "Ljava/lang/Class;", "protectionDomain", "Ljava/security/ProtectionDomain;", "classfileBuffer", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class DebugProbesTransformer implements java.lang.instrument.ClassFileTransformer {

        @org.jetbrains.annotations.NotNull
        public static final kotlinx.coroutines.debug.AgentPremain.DebugProbesTransformer INSTANCE = new kotlinx.coroutines.debug.AgentPremain.DebugProbesTransformer();

        @org.jetbrains.annotations.Nullable
        public byte[] transform(@org.jetbrains.annotations.NotNull java.lang.ClassLoader loader, @org.jetbrains.annotations.NotNull java.lang.String className, @org.jetbrains.annotations.Nullable java.lang.Class<?> classBeingRedefined, @org.jetbrains.annotations.NotNull java.security.ProtectionDomain protectionDomain, @org.jetbrains.annotations.Nullable byte[] classfileBuffer) {
            if (!kotlin.jvm.internal.Intrinsics.areEqual(className, "kotlin/coroutines/jvm/internal/DebugProbesKt")) {
                return null;
            }
            kotlinx.coroutines.debug.AgentPremain.INSTANCE.setInstalledStatically(true);
            return kotlin.io.ByteStreamsKt.readBytes(loader.getResourceAsStream("DebugProbesKt.bin"));
        }
    }

    static {
        java.lang.Object m156constructorimpl;
        try {
            kotlin.Result.Companion companion = kotlin.Result.INSTANCE;
            java.lang.String property = java.lang.System.getProperty("kotlinx.coroutines.debug.enable.creation.stack.trace");
            m156constructorimpl = kotlin.Result.m156constructorimpl(property == null ? null : java.lang.Boolean.valueOf(java.lang.Boolean.parseBoolean(property)));
        } catch (java.lang.Throwable th) {
            kotlin.Result.Companion companion2 = kotlin.Result.INSTANCE;
            m156constructorimpl = kotlin.Result.m156constructorimpl(kotlin.ResultKt.createFailure(th));
        }
        java.lang.Boolean bool = (java.lang.Boolean) (kotlin.Result.m162isFailureimpl(m156constructorimpl) ? null : m156constructorimpl);
        enableCreationStackTraces = bool == null ? kotlinx.coroutines.debug.internal.DebugProbesImpl.INSTANCE.getEnableCreationStackTraces() : bool.booleanValue();
    }

    @kotlin.jvm.JvmStatic
    public static final void premain(@org.jetbrains.annotations.Nullable java.lang.String args, @org.jetbrains.annotations.NotNull java.lang.instrument.Instrumentation instrumentation) {
        isInstalledStatically = true;
        instrumentation.addTransformer(kotlinx.coroutines.debug.AgentPremain.DebugProbesTransformer.INSTANCE);
        kotlinx.coroutines.debug.internal.DebugProbesImpl debugProbesImpl = kotlinx.coroutines.debug.internal.DebugProbesImpl.INSTANCE;
        debugProbesImpl.setEnableCreationStackTraces(enableCreationStackTraces);
        debugProbesImpl.install();
        INSTANCE.a();
    }

    public final void a() {
        try {
            sun.misc.Signal.handle(new sun.misc.Signal("TRAP"), new defpackage.a8());
        } catch (java.lang.Throwable unused) {
        }
    }

    public final boolean isInstalledStatically() {
        return isInstalledStatically;
    }

    public final void setInstalledStatically(boolean z) {
        isInstalledStatically = z;
    }
}
