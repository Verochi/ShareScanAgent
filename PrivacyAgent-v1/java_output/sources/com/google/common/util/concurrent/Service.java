package com.google.common.util.concurrent;

@com.google.common.annotations.Beta
@com.google.common.annotations.GwtIncompatible
/* loaded from: classes22.dex */
public interface Service {

    @com.google.common.annotations.Beta
    public static abstract class Listener {
        public void failed(com.google.common.util.concurrent.Service.State state, java.lang.Throwable th) {
        }

        public void running() {
        }

        public void starting() {
        }

        public void stopping(com.google.common.util.concurrent.Service.State state) {
        }

        public void terminated(com.google.common.util.concurrent.Service.State state) {
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @com.google.common.annotations.Beta
    public static abstract class State {
        private static final /* synthetic */ com.google.common.util.concurrent.Service.State[] $VALUES;
        public static final com.google.common.util.concurrent.Service.State FAILED;
        public static final com.google.common.util.concurrent.Service.State NEW;
        public static final com.google.common.util.concurrent.Service.State RUNNING;
        public static final com.google.common.util.concurrent.Service.State STARTING;
        public static final com.google.common.util.concurrent.Service.State STOPPING;
        public static final com.google.common.util.concurrent.Service.State TERMINATED;

        /* renamed from: com.google.common.util.concurrent.Service$State$1, reason: invalid class name */
        public enum AnonymousClass1 extends com.google.common.util.concurrent.Service.State {
            public AnonymousClass1(java.lang.String str, int i) {
                super(str, i, null);
            }

            @Override // com.google.common.util.concurrent.Service.State
            public boolean isTerminal() {
                return false;
            }
        }

        /* renamed from: com.google.common.util.concurrent.Service$State$2, reason: invalid class name */
        public enum AnonymousClass2 extends com.google.common.util.concurrent.Service.State {
            public AnonymousClass2(java.lang.String str, int i) {
                super(str, i, null);
            }

            @Override // com.google.common.util.concurrent.Service.State
            public boolean isTerminal() {
                return false;
            }
        }

        /* renamed from: com.google.common.util.concurrent.Service$State$3, reason: invalid class name */
        public enum AnonymousClass3 extends com.google.common.util.concurrent.Service.State {
            public AnonymousClass3(java.lang.String str, int i) {
                super(str, i, null);
            }

            @Override // com.google.common.util.concurrent.Service.State
            public boolean isTerminal() {
                return false;
            }
        }

        /* renamed from: com.google.common.util.concurrent.Service$State$4, reason: invalid class name */
        public enum AnonymousClass4 extends com.google.common.util.concurrent.Service.State {
            public AnonymousClass4(java.lang.String str, int i) {
                super(str, i, null);
            }

            @Override // com.google.common.util.concurrent.Service.State
            public boolean isTerminal() {
                return false;
            }
        }

        /* renamed from: com.google.common.util.concurrent.Service$State$5, reason: invalid class name */
        public enum AnonymousClass5 extends com.google.common.util.concurrent.Service.State {
            public AnonymousClass5(java.lang.String str, int i) {
                super(str, i, null);
            }

            @Override // com.google.common.util.concurrent.Service.State
            public boolean isTerminal() {
                return true;
            }
        }

        /* renamed from: com.google.common.util.concurrent.Service$State$6, reason: invalid class name */
        public enum AnonymousClass6 extends com.google.common.util.concurrent.Service.State {
            public AnonymousClass6(java.lang.String str, int i) {
                super(str, i, null);
            }

            @Override // com.google.common.util.concurrent.Service.State
            public boolean isTerminal() {
                return true;
            }
        }

        static {
            com.google.common.util.concurrent.Service.State.AnonymousClass1 anonymousClass1 = new com.google.common.util.concurrent.Service.State.AnonymousClass1("NEW", 0);
            NEW = anonymousClass1;
            com.google.common.util.concurrent.Service.State.AnonymousClass2 anonymousClass2 = new com.google.common.util.concurrent.Service.State.AnonymousClass2("STARTING", 1);
            STARTING = anonymousClass2;
            com.google.common.util.concurrent.Service.State.AnonymousClass3 anonymousClass3 = new com.google.common.util.concurrent.Service.State.AnonymousClass3(kotlinx.coroutines.debug.internal.DebugCoroutineInfoImplKt.RUNNING, 2);
            RUNNING = anonymousClass3;
            com.google.common.util.concurrent.Service.State.AnonymousClass4 anonymousClass4 = new com.google.common.util.concurrent.Service.State.AnonymousClass4("STOPPING", 3);
            STOPPING = anonymousClass4;
            com.google.common.util.concurrent.Service.State.AnonymousClass5 anonymousClass5 = new com.google.common.util.concurrent.Service.State.AnonymousClass5("TERMINATED", 4);
            TERMINATED = anonymousClass5;
            com.google.common.util.concurrent.Service.State.AnonymousClass6 anonymousClass6 = new com.google.common.util.concurrent.Service.State.AnonymousClass6("FAILED", 5);
            FAILED = anonymousClass6;
            $VALUES = new com.google.common.util.concurrent.Service.State[]{anonymousClass1, anonymousClass2, anonymousClass3, anonymousClass4, anonymousClass5, anonymousClass6};
        }

        private State(java.lang.String str, int i) {
        }

        public /* synthetic */ State(java.lang.String str, int i, com.google.common.util.concurrent.Service.AnonymousClass1 anonymousClass1) {
            this(str, i);
        }

        public static com.google.common.util.concurrent.Service.State valueOf(java.lang.String str) {
            return (com.google.common.util.concurrent.Service.State) java.lang.Enum.valueOf(com.google.common.util.concurrent.Service.State.class, str);
        }

        public static com.google.common.util.concurrent.Service.State[] values() {
            return (com.google.common.util.concurrent.Service.State[]) $VALUES.clone();
        }

        public abstract boolean isTerminal();
    }

    void addListener(com.google.common.util.concurrent.Service.Listener listener, java.util.concurrent.Executor executor);

    void awaitRunning();

    void awaitRunning(long j, java.util.concurrent.TimeUnit timeUnit) throws java.util.concurrent.TimeoutException;

    void awaitTerminated();

    void awaitTerminated(long j, java.util.concurrent.TimeUnit timeUnit) throws java.util.concurrent.TimeoutException;

    java.lang.Throwable failureCause();

    boolean isRunning();

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    com.google.common.util.concurrent.Service startAsync();

    com.google.common.util.concurrent.Service.State state();

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    com.google.common.util.concurrent.Service stopAsync();
}
