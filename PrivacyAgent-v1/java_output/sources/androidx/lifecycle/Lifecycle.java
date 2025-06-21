package androidx.lifecycle;

/* loaded from: classes.dex */
public abstract class Lifecycle {

    @androidx.annotation.NonNull
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    java.util.concurrent.atomic.AtomicReference<java.lang.Object> mInternalScopeRef = new java.util.concurrent.atomic.AtomicReference<>();

    /* renamed from: androidx.lifecycle.Lifecycle$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$lifecycle$Lifecycle$Event;
        static final /* synthetic */ int[] $SwitchMap$androidx$lifecycle$Lifecycle$State;

        static {
            int[] iArr = new int[androidx.lifecycle.Lifecycle.Event.values().length];
            $SwitchMap$androidx$lifecycle$Lifecycle$Event = iArr;
            try {
                iArr[androidx.lifecycle.Lifecycle.Event.ON_CREATE.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$lifecycle$Lifecycle$Event[androidx.lifecycle.Lifecycle.Event.ON_STOP.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$androidx$lifecycle$Lifecycle$Event[androidx.lifecycle.Lifecycle.Event.ON_START.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$androidx$lifecycle$Lifecycle$Event[androidx.lifecycle.Lifecycle.Event.ON_PAUSE.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$androidx$lifecycle$Lifecycle$Event[androidx.lifecycle.Lifecycle.Event.ON_RESUME.ordinal()] = 5;
            } catch (java.lang.NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$androidx$lifecycle$Lifecycle$Event[androidx.lifecycle.Lifecycle.Event.ON_DESTROY.ordinal()] = 6;
            } catch (java.lang.NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$androidx$lifecycle$Lifecycle$Event[androidx.lifecycle.Lifecycle.Event.ON_ANY.ordinal()] = 7;
            } catch (java.lang.NoSuchFieldError unused7) {
            }
            int[] iArr2 = new int[androidx.lifecycle.Lifecycle.State.values().length];
            $SwitchMap$androidx$lifecycle$Lifecycle$State = iArr2;
            try {
                iArr2[androidx.lifecycle.Lifecycle.State.CREATED.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$androidx$lifecycle$Lifecycle$State[androidx.lifecycle.Lifecycle.State.STARTED.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$androidx$lifecycle$Lifecycle$State[androidx.lifecycle.Lifecycle.State.RESUMED.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$androidx$lifecycle$Lifecycle$State[androidx.lifecycle.Lifecycle.State.DESTROYED.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$androidx$lifecycle$Lifecycle$State[androidx.lifecycle.Lifecycle.State.INITIALIZED.ordinal()] = 5;
            } catch (java.lang.NoSuchFieldError unused12) {
            }
        }
    }

    public enum Event {
        ON_CREATE,
        ON_START,
        ON_RESUME,
        ON_PAUSE,
        ON_STOP,
        ON_DESTROY,
        ON_ANY;

        @androidx.annotation.Nullable
        public static androidx.lifecycle.Lifecycle.Event downFrom(@androidx.annotation.NonNull androidx.lifecycle.Lifecycle.State state) {
            int i = androidx.lifecycle.Lifecycle.AnonymousClass1.$SwitchMap$androidx$lifecycle$Lifecycle$State[state.ordinal()];
            if (i == 1) {
                return ON_DESTROY;
            }
            if (i == 2) {
                return ON_STOP;
            }
            if (i != 3) {
                return null;
            }
            return ON_PAUSE;
        }

        @androidx.annotation.Nullable
        public static androidx.lifecycle.Lifecycle.Event downTo(@androidx.annotation.NonNull androidx.lifecycle.Lifecycle.State state) {
            int i = androidx.lifecycle.Lifecycle.AnonymousClass1.$SwitchMap$androidx$lifecycle$Lifecycle$State[state.ordinal()];
            if (i == 1) {
                return ON_STOP;
            }
            if (i == 2) {
                return ON_PAUSE;
            }
            if (i != 4) {
                return null;
            }
            return ON_DESTROY;
        }

        @androidx.annotation.Nullable
        public static androidx.lifecycle.Lifecycle.Event upFrom(@androidx.annotation.NonNull androidx.lifecycle.Lifecycle.State state) {
            int i = androidx.lifecycle.Lifecycle.AnonymousClass1.$SwitchMap$androidx$lifecycle$Lifecycle$State[state.ordinal()];
            if (i == 1) {
                return ON_START;
            }
            if (i == 2) {
                return ON_RESUME;
            }
            if (i != 5) {
                return null;
            }
            return ON_CREATE;
        }

        @androidx.annotation.Nullable
        public static androidx.lifecycle.Lifecycle.Event upTo(@androidx.annotation.NonNull androidx.lifecycle.Lifecycle.State state) {
            int i = androidx.lifecycle.Lifecycle.AnonymousClass1.$SwitchMap$androidx$lifecycle$Lifecycle$State[state.ordinal()];
            if (i == 1) {
                return ON_CREATE;
            }
            if (i == 2) {
                return ON_START;
            }
            if (i != 3) {
                return null;
            }
            return ON_RESUME;
        }

        @androidx.annotation.NonNull
        public androidx.lifecycle.Lifecycle.State getTargetState() {
            switch (androidx.lifecycle.Lifecycle.AnonymousClass1.$SwitchMap$androidx$lifecycle$Lifecycle$Event[ordinal()]) {
                case 1:
                case 2:
                    return androidx.lifecycle.Lifecycle.State.CREATED;
                case 3:
                case 4:
                    return androidx.lifecycle.Lifecycle.State.STARTED;
                case 5:
                    return androidx.lifecycle.Lifecycle.State.RESUMED;
                case 6:
                    return androidx.lifecycle.Lifecycle.State.DESTROYED;
                default:
                    throw new java.lang.IllegalArgumentException(this + " has no target state");
            }
        }
    }

    public enum State {
        DESTROYED,
        INITIALIZED,
        CREATED,
        STARTED,
        RESUMED;

        public boolean isAtLeast(@androidx.annotation.NonNull androidx.lifecycle.Lifecycle.State state) {
            return compareTo(state) >= 0;
        }
    }

    @androidx.annotation.MainThread
    public abstract void addObserver(@androidx.annotation.NonNull androidx.lifecycle.LifecycleObserver lifecycleObserver);

    @androidx.annotation.NonNull
    @androidx.annotation.MainThread
    public abstract androidx.lifecycle.Lifecycle.State getCurrentState();

    @androidx.annotation.MainThread
    public abstract void removeObserver(@androidx.annotation.NonNull androidx.lifecycle.LifecycleObserver lifecycleObserver);
}
