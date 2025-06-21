package com.google.common.util.concurrent;

@com.google.errorprone.annotations.CanIgnoreReturnValue
@com.google.common.annotations.Beta
@com.google.common.annotations.GwtIncompatible
/* loaded from: classes22.dex */
public class CycleDetectingLockFactory {
    public static final java.util.concurrent.ConcurrentMap<java.lang.Class<? extends java.lang.Enum>, java.util.Map<? extends java.lang.Enum, com.google.common.util.concurrent.CycleDetectingLockFactory.LockGraphNode>> b = new com.google.common.collect.MapMaker().weakKeys().makeMap();
    public static final java.util.logging.Logger c = java.util.logging.Logger.getLogger(com.google.common.util.concurrent.CycleDetectingLockFactory.class.getName());
    public static final java.lang.ThreadLocal<java.util.ArrayList<com.google.common.util.concurrent.CycleDetectingLockFactory.LockGraphNode>> d = new com.google.common.util.concurrent.CycleDetectingLockFactory.AnonymousClass1();
    public final com.google.common.util.concurrent.CycleDetectingLockFactory.Policy a;

    /* renamed from: com.google.common.util.concurrent.CycleDetectingLockFactory$1, reason: invalid class name */
    public static class AnonymousClass1 extends java.lang.ThreadLocal<java.util.ArrayList<com.google.common.util.concurrent.CycleDetectingLockFactory.LockGraphNode>> {
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public java.util.ArrayList<com.google.common.util.concurrent.CycleDetectingLockFactory.LockGraphNode> initialValue() {
            return com.google.common.collect.Lists.newArrayListWithCapacity(3);
        }
    }

    public interface CycleDetectingLock {
        com.google.common.util.concurrent.CycleDetectingLockFactory.LockGraphNode getLockGraphNode();

        boolean isAcquiredByCurrentThread();
    }

    public final class CycleDetectingReentrantLock extends java.util.concurrent.locks.ReentrantLock implements com.google.common.util.concurrent.CycleDetectingLockFactory.CycleDetectingLock {
        private final com.google.common.util.concurrent.CycleDetectingLockFactory.LockGraphNode lockGraphNode;

        private CycleDetectingReentrantLock(com.google.common.util.concurrent.CycleDetectingLockFactory.LockGraphNode lockGraphNode, boolean z) {
            super(z);
            this.lockGraphNode = (com.google.common.util.concurrent.CycleDetectingLockFactory.LockGraphNode) com.google.common.base.Preconditions.checkNotNull(lockGraphNode);
        }

        public /* synthetic */ CycleDetectingReentrantLock(com.google.common.util.concurrent.CycleDetectingLockFactory cycleDetectingLockFactory, com.google.common.util.concurrent.CycleDetectingLockFactory.LockGraphNode lockGraphNode, boolean z, com.google.common.util.concurrent.CycleDetectingLockFactory.AnonymousClass1 anonymousClass1) {
            this(lockGraphNode, z);
        }

        @Override // com.google.common.util.concurrent.CycleDetectingLockFactory.CycleDetectingLock
        public com.google.common.util.concurrent.CycleDetectingLockFactory.LockGraphNode getLockGraphNode() {
            return this.lockGraphNode;
        }

        @Override // com.google.common.util.concurrent.CycleDetectingLockFactory.CycleDetectingLock
        public boolean isAcquiredByCurrentThread() {
            return isHeldByCurrentThread();
        }

        @Override // java.util.concurrent.locks.ReentrantLock, java.util.concurrent.locks.Lock
        public void lock() {
            com.google.common.util.concurrent.CycleDetectingLockFactory.this.a(this);
            try {
                super.lock();
            } finally {
                com.google.common.util.concurrent.CycleDetectingLockFactory.h(this);
            }
        }

        @Override // java.util.concurrent.locks.ReentrantLock, java.util.concurrent.locks.Lock
        public void lockInterruptibly() throws java.lang.InterruptedException {
            com.google.common.util.concurrent.CycleDetectingLockFactory.this.a(this);
            try {
                super.lockInterruptibly();
            } finally {
                com.google.common.util.concurrent.CycleDetectingLockFactory.h(this);
            }
        }

        @Override // java.util.concurrent.locks.ReentrantLock, java.util.concurrent.locks.Lock
        public boolean tryLock() {
            com.google.common.util.concurrent.CycleDetectingLockFactory.this.a(this);
            try {
                return super.tryLock();
            } finally {
                com.google.common.util.concurrent.CycleDetectingLockFactory.h(this);
            }
        }

        @Override // java.util.concurrent.locks.ReentrantLock, java.util.concurrent.locks.Lock
        public boolean tryLock(long j, java.util.concurrent.TimeUnit timeUnit) throws java.lang.InterruptedException {
            com.google.common.util.concurrent.CycleDetectingLockFactory.this.a(this);
            try {
                return super.tryLock(j, timeUnit);
            } finally {
                com.google.common.util.concurrent.CycleDetectingLockFactory.h(this);
            }
        }

        @Override // java.util.concurrent.locks.ReentrantLock, java.util.concurrent.locks.Lock
        public void unlock() {
            try {
                super.unlock();
            } finally {
                com.google.common.util.concurrent.CycleDetectingLockFactory.h(this);
            }
        }
    }

    public class CycleDetectingReentrantReadLock extends java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock {

        @com.google.j2objc.annotations.Weak
        final com.google.common.util.concurrent.CycleDetectingLockFactory.CycleDetectingReentrantReadWriteLock readWriteLock;

        public CycleDetectingReentrantReadLock(com.google.common.util.concurrent.CycleDetectingLockFactory.CycleDetectingReentrantReadWriteLock cycleDetectingReentrantReadWriteLock) {
            super(cycleDetectingReentrantReadWriteLock);
            this.readWriteLock = cycleDetectingReentrantReadWriteLock;
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock, java.util.concurrent.locks.Lock
        public void lock() {
            com.google.common.util.concurrent.CycleDetectingLockFactory.this.a(this.readWriteLock);
            try {
                super.lock();
            } finally {
                com.google.common.util.concurrent.CycleDetectingLockFactory.h(this.readWriteLock);
            }
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock, java.util.concurrent.locks.Lock
        public void lockInterruptibly() throws java.lang.InterruptedException {
            com.google.common.util.concurrent.CycleDetectingLockFactory.this.a(this.readWriteLock);
            try {
                super.lockInterruptibly();
            } finally {
                com.google.common.util.concurrent.CycleDetectingLockFactory.h(this.readWriteLock);
            }
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock, java.util.concurrent.locks.Lock
        public boolean tryLock() {
            com.google.common.util.concurrent.CycleDetectingLockFactory.this.a(this.readWriteLock);
            try {
                return super.tryLock();
            } finally {
                com.google.common.util.concurrent.CycleDetectingLockFactory.h(this.readWriteLock);
            }
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock, java.util.concurrent.locks.Lock
        public boolean tryLock(long j, java.util.concurrent.TimeUnit timeUnit) throws java.lang.InterruptedException {
            com.google.common.util.concurrent.CycleDetectingLockFactory.this.a(this.readWriteLock);
            try {
                return super.tryLock(j, timeUnit);
            } finally {
                com.google.common.util.concurrent.CycleDetectingLockFactory.h(this.readWriteLock);
            }
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock, java.util.concurrent.locks.Lock
        public void unlock() {
            try {
                super.unlock();
            } finally {
                com.google.common.util.concurrent.CycleDetectingLockFactory.h(this.readWriteLock);
            }
        }
    }

    public final class CycleDetectingReentrantReadWriteLock extends java.util.concurrent.locks.ReentrantReadWriteLock implements com.google.common.util.concurrent.CycleDetectingLockFactory.CycleDetectingLock {
        private final com.google.common.util.concurrent.CycleDetectingLockFactory.LockGraphNode lockGraphNode;
        private final com.google.common.util.concurrent.CycleDetectingLockFactory.CycleDetectingReentrantReadLock readLock;
        private final com.google.common.util.concurrent.CycleDetectingLockFactory.CycleDetectingReentrantWriteLock writeLock;

        private CycleDetectingReentrantReadWriteLock(com.google.common.util.concurrent.CycleDetectingLockFactory.LockGraphNode lockGraphNode, boolean z) {
            super(z);
            this.readLock = com.google.common.util.concurrent.CycleDetectingLockFactory.this.new CycleDetectingReentrantReadLock(this);
            this.writeLock = com.google.common.util.concurrent.CycleDetectingLockFactory.this.new CycleDetectingReentrantWriteLock(this);
            this.lockGraphNode = (com.google.common.util.concurrent.CycleDetectingLockFactory.LockGraphNode) com.google.common.base.Preconditions.checkNotNull(lockGraphNode);
        }

        public /* synthetic */ CycleDetectingReentrantReadWriteLock(com.google.common.util.concurrent.CycleDetectingLockFactory cycleDetectingLockFactory, com.google.common.util.concurrent.CycleDetectingLockFactory.LockGraphNode lockGraphNode, boolean z, com.google.common.util.concurrent.CycleDetectingLockFactory.AnonymousClass1 anonymousClass1) {
            this(lockGraphNode, z);
        }

        @Override // com.google.common.util.concurrent.CycleDetectingLockFactory.CycleDetectingLock
        public com.google.common.util.concurrent.CycleDetectingLockFactory.LockGraphNode getLockGraphNode() {
            return this.lockGraphNode;
        }

        @Override // com.google.common.util.concurrent.CycleDetectingLockFactory.CycleDetectingLock
        public boolean isAcquiredByCurrentThread() {
            return isWriteLockedByCurrentThread() || getReadHoldCount() > 0;
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock, java.util.concurrent.locks.ReadWriteLock
        public java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock readLock() {
            return this.readLock;
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock, java.util.concurrent.locks.ReadWriteLock
        public java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock writeLock() {
            return this.writeLock;
        }
    }

    public class CycleDetectingReentrantWriteLock extends java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock {

        @com.google.j2objc.annotations.Weak
        final com.google.common.util.concurrent.CycleDetectingLockFactory.CycleDetectingReentrantReadWriteLock readWriteLock;

        public CycleDetectingReentrantWriteLock(com.google.common.util.concurrent.CycleDetectingLockFactory.CycleDetectingReentrantReadWriteLock cycleDetectingReentrantReadWriteLock) {
            super(cycleDetectingReentrantReadWriteLock);
            this.readWriteLock = cycleDetectingReentrantReadWriteLock;
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock, java.util.concurrent.locks.Lock
        public void lock() {
            com.google.common.util.concurrent.CycleDetectingLockFactory.this.a(this.readWriteLock);
            try {
                super.lock();
            } finally {
                com.google.common.util.concurrent.CycleDetectingLockFactory.h(this.readWriteLock);
            }
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock, java.util.concurrent.locks.Lock
        public void lockInterruptibly() throws java.lang.InterruptedException {
            com.google.common.util.concurrent.CycleDetectingLockFactory.this.a(this.readWriteLock);
            try {
                super.lockInterruptibly();
            } finally {
                com.google.common.util.concurrent.CycleDetectingLockFactory.h(this.readWriteLock);
            }
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock, java.util.concurrent.locks.Lock
        public boolean tryLock() {
            com.google.common.util.concurrent.CycleDetectingLockFactory.this.a(this.readWriteLock);
            try {
                return super.tryLock();
            } finally {
                com.google.common.util.concurrent.CycleDetectingLockFactory.h(this.readWriteLock);
            }
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock, java.util.concurrent.locks.Lock
        public boolean tryLock(long j, java.util.concurrent.TimeUnit timeUnit) throws java.lang.InterruptedException {
            com.google.common.util.concurrent.CycleDetectingLockFactory.this.a(this.readWriteLock);
            try {
                return super.tryLock(j, timeUnit);
            } finally {
                com.google.common.util.concurrent.CycleDetectingLockFactory.h(this.readWriteLock);
            }
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock, java.util.concurrent.locks.Lock
        public void unlock() {
            try {
                super.unlock();
            } finally {
                com.google.common.util.concurrent.CycleDetectingLockFactory.h(this.readWriteLock);
            }
        }
    }

    public static class ExampleStackTrace extends java.lang.IllegalStateException {
        static final java.lang.StackTraceElement[] EMPTY_STACK_TRACE = new java.lang.StackTraceElement[0];
        static final com.google.common.collect.ImmutableSet<java.lang.String> EXCLUDED_CLASS_NAMES = com.google.common.collect.ImmutableSet.of(com.google.common.util.concurrent.CycleDetectingLockFactory.class.getName(), com.google.common.util.concurrent.CycleDetectingLockFactory.ExampleStackTrace.class.getName(), com.google.common.util.concurrent.CycleDetectingLockFactory.LockGraphNode.class.getName());

        public ExampleStackTrace(com.google.common.util.concurrent.CycleDetectingLockFactory.LockGraphNode lockGraphNode, com.google.common.util.concurrent.CycleDetectingLockFactory.LockGraphNode lockGraphNode2) {
            super(lockGraphNode.d() + " -> " + lockGraphNode2.d());
            java.lang.StackTraceElement[] stackTrace = getStackTrace();
            int length = stackTrace.length;
            for (int i = 0; i < length; i++) {
                if (com.google.common.util.concurrent.CycleDetectingLockFactory.WithExplicitOrdering.class.getName().equals(stackTrace[i].getClassName())) {
                    setStackTrace(EMPTY_STACK_TRACE);
                    return;
                } else {
                    if (!EXCLUDED_CLASS_NAMES.contains(stackTrace[i].getClassName())) {
                        setStackTrace((java.lang.StackTraceElement[]) java.util.Arrays.copyOfRange(stackTrace, i, length));
                        return;
                    }
                }
            }
        }
    }

    public static class LockGraphNode {
        public final java.util.Map<com.google.common.util.concurrent.CycleDetectingLockFactory.LockGraphNode, com.google.common.util.concurrent.CycleDetectingLockFactory.ExampleStackTrace> a = new com.google.common.collect.MapMaker().weakKeys().makeMap();
        public final java.util.Map<com.google.common.util.concurrent.CycleDetectingLockFactory.LockGraphNode, com.google.common.util.concurrent.CycleDetectingLockFactory.PotentialDeadlockException> b = new com.google.common.collect.MapMaker().weakKeys().makeMap();
        public final java.lang.String c;

        public LockGraphNode(java.lang.String str) {
            this.c = (java.lang.String) com.google.common.base.Preconditions.checkNotNull(str);
        }

        public void a(com.google.common.util.concurrent.CycleDetectingLockFactory.Policy policy, com.google.common.util.concurrent.CycleDetectingLockFactory.LockGraphNode lockGraphNode) {
            com.google.common.base.Preconditions.checkState(this != lockGraphNode, "Attempted to acquire multiple locks with the same rank %s", lockGraphNode.d());
            if (this.a.containsKey(lockGraphNode)) {
                return;
            }
            com.google.common.util.concurrent.CycleDetectingLockFactory.PotentialDeadlockException potentialDeadlockException = this.b.get(lockGraphNode);
            if (potentialDeadlockException != null) {
                policy.handlePotentialDeadlock(new com.google.common.util.concurrent.CycleDetectingLockFactory.PotentialDeadlockException(lockGraphNode, this, potentialDeadlockException.getConflictingStackTrace(), null));
                return;
            }
            com.google.common.util.concurrent.CycleDetectingLockFactory.ExampleStackTrace c = lockGraphNode.c(this, com.google.common.collect.Sets.newIdentityHashSet());
            if (c == null) {
                this.a.put(lockGraphNode, new com.google.common.util.concurrent.CycleDetectingLockFactory.ExampleStackTrace(lockGraphNode, this));
                return;
            }
            com.google.common.util.concurrent.CycleDetectingLockFactory.PotentialDeadlockException potentialDeadlockException2 = new com.google.common.util.concurrent.CycleDetectingLockFactory.PotentialDeadlockException(lockGraphNode, this, c, null);
            this.b.put(lockGraphNode, potentialDeadlockException2);
            policy.handlePotentialDeadlock(potentialDeadlockException2);
        }

        public void b(com.google.common.util.concurrent.CycleDetectingLockFactory.Policy policy, java.util.List<com.google.common.util.concurrent.CycleDetectingLockFactory.LockGraphNode> list) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                a(policy, list.get(i));
            }
        }

        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        public final com.google.common.util.concurrent.CycleDetectingLockFactory.ExampleStackTrace c(com.google.common.util.concurrent.CycleDetectingLockFactory.LockGraphNode lockGraphNode, java.util.Set<com.google.common.util.concurrent.CycleDetectingLockFactory.LockGraphNode> set) {
            if (!set.add(this)) {
                return null;
            }
            com.google.common.util.concurrent.CycleDetectingLockFactory.ExampleStackTrace exampleStackTrace = this.a.get(lockGraphNode);
            if (exampleStackTrace != null) {
                return exampleStackTrace;
            }
            for (java.util.Map.Entry<com.google.common.util.concurrent.CycleDetectingLockFactory.LockGraphNode, com.google.common.util.concurrent.CycleDetectingLockFactory.ExampleStackTrace> entry : this.a.entrySet()) {
                com.google.common.util.concurrent.CycleDetectingLockFactory.LockGraphNode key = entry.getKey();
                com.google.common.util.concurrent.CycleDetectingLockFactory.ExampleStackTrace c = key.c(lockGraphNode, set);
                if (c != null) {
                    com.google.common.util.concurrent.CycleDetectingLockFactory.ExampleStackTrace exampleStackTrace2 = new com.google.common.util.concurrent.CycleDetectingLockFactory.ExampleStackTrace(key, this);
                    exampleStackTrace2.setStackTrace(entry.getValue().getStackTrace());
                    exampleStackTrace2.initCause(c);
                    return exampleStackTrace2;
                }
            }
            return null;
        }

        public java.lang.String d() {
            return this.c;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @com.google.common.annotations.Beta
    public static abstract class Policies implements com.google.common.util.concurrent.CycleDetectingLockFactory.Policy {
        private static final /* synthetic */ com.google.common.util.concurrent.CycleDetectingLockFactory.Policies[] $VALUES;
        public static final com.google.common.util.concurrent.CycleDetectingLockFactory.Policies DISABLED;
        public static final com.google.common.util.concurrent.CycleDetectingLockFactory.Policies THROW;
        public static final com.google.common.util.concurrent.CycleDetectingLockFactory.Policies WARN;

        /* renamed from: com.google.common.util.concurrent.CycleDetectingLockFactory$Policies$1, reason: invalid class name */
        public enum AnonymousClass1 extends com.google.common.util.concurrent.CycleDetectingLockFactory.Policies {
            public AnonymousClass1(java.lang.String str, int i) {
                super(str, i, null);
            }

            @Override // com.google.common.util.concurrent.CycleDetectingLockFactory.Policy
            public void handlePotentialDeadlock(com.google.common.util.concurrent.CycleDetectingLockFactory.PotentialDeadlockException potentialDeadlockException) {
                throw potentialDeadlockException;
            }
        }

        /* renamed from: com.google.common.util.concurrent.CycleDetectingLockFactory$Policies$2, reason: invalid class name */
        public enum AnonymousClass2 extends com.google.common.util.concurrent.CycleDetectingLockFactory.Policies {
            public AnonymousClass2(java.lang.String str, int i) {
                super(str, i, null);
            }

            @Override // com.google.common.util.concurrent.CycleDetectingLockFactory.Policy
            public void handlePotentialDeadlock(com.google.common.util.concurrent.CycleDetectingLockFactory.PotentialDeadlockException potentialDeadlockException) {
                com.google.common.util.concurrent.CycleDetectingLockFactory.c.log(java.util.logging.Level.SEVERE, "Detected potential deadlock", (java.lang.Throwable) potentialDeadlockException);
            }
        }

        /* renamed from: com.google.common.util.concurrent.CycleDetectingLockFactory$Policies$3, reason: invalid class name */
        public enum AnonymousClass3 extends com.google.common.util.concurrent.CycleDetectingLockFactory.Policies {
            public AnonymousClass3(java.lang.String str, int i) {
                super(str, i, null);
            }

            @Override // com.google.common.util.concurrent.CycleDetectingLockFactory.Policy
            public void handlePotentialDeadlock(com.google.common.util.concurrent.CycleDetectingLockFactory.PotentialDeadlockException potentialDeadlockException) {
            }
        }

        static {
            com.google.common.util.concurrent.CycleDetectingLockFactory.Policies.AnonymousClass1 anonymousClass1 = new com.google.common.util.concurrent.CycleDetectingLockFactory.Policies.AnonymousClass1("THROW", 0);
            THROW = anonymousClass1;
            com.google.common.util.concurrent.CycleDetectingLockFactory.Policies.AnonymousClass2 anonymousClass2 = new com.google.common.util.concurrent.CycleDetectingLockFactory.Policies.AnonymousClass2("WARN", 1);
            WARN = anonymousClass2;
            com.google.common.util.concurrent.CycleDetectingLockFactory.Policies.AnonymousClass3 anonymousClass3 = new com.google.common.util.concurrent.CycleDetectingLockFactory.Policies.AnonymousClass3("DISABLED", 2);
            DISABLED = anonymousClass3;
            $VALUES = new com.google.common.util.concurrent.CycleDetectingLockFactory.Policies[]{anonymousClass1, anonymousClass2, anonymousClass3};
        }

        private Policies(java.lang.String str, int i) {
        }

        public /* synthetic */ Policies(java.lang.String str, int i, com.google.common.util.concurrent.CycleDetectingLockFactory.AnonymousClass1 anonymousClass1) {
            this(str, i);
        }

        public static com.google.common.util.concurrent.CycleDetectingLockFactory.Policies valueOf(java.lang.String str) {
            return (com.google.common.util.concurrent.CycleDetectingLockFactory.Policies) java.lang.Enum.valueOf(com.google.common.util.concurrent.CycleDetectingLockFactory.Policies.class, str);
        }

        public static com.google.common.util.concurrent.CycleDetectingLockFactory.Policies[] values() {
            return (com.google.common.util.concurrent.CycleDetectingLockFactory.Policies[]) $VALUES.clone();
        }
    }

    @com.google.common.annotations.Beta
    public interface Policy {
        void handlePotentialDeadlock(com.google.common.util.concurrent.CycleDetectingLockFactory.PotentialDeadlockException potentialDeadlockException);
    }

    @com.google.common.annotations.Beta
    public static final class PotentialDeadlockException extends com.google.common.util.concurrent.CycleDetectingLockFactory.ExampleStackTrace {
        private final com.google.common.util.concurrent.CycleDetectingLockFactory.ExampleStackTrace conflictingStackTrace;

        private PotentialDeadlockException(com.google.common.util.concurrent.CycleDetectingLockFactory.LockGraphNode lockGraphNode, com.google.common.util.concurrent.CycleDetectingLockFactory.LockGraphNode lockGraphNode2, com.google.common.util.concurrent.CycleDetectingLockFactory.ExampleStackTrace exampleStackTrace) {
            super(lockGraphNode, lockGraphNode2);
            this.conflictingStackTrace = exampleStackTrace;
            initCause(exampleStackTrace);
        }

        public /* synthetic */ PotentialDeadlockException(com.google.common.util.concurrent.CycleDetectingLockFactory.LockGraphNode lockGraphNode, com.google.common.util.concurrent.CycleDetectingLockFactory.LockGraphNode lockGraphNode2, com.google.common.util.concurrent.CycleDetectingLockFactory.ExampleStackTrace exampleStackTrace, com.google.common.util.concurrent.CycleDetectingLockFactory.AnonymousClass1 anonymousClass1) {
            this(lockGraphNode, lockGraphNode2, exampleStackTrace);
        }

        public com.google.common.util.concurrent.CycleDetectingLockFactory.ExampleStackTrace getConflictingStackTrace() {
            return this.conflictingStackTrace;
        }

        @Override // java.lang.Throwable
        public java.lang.String getMessage() {
            java.lang.StringBuilder sb = new java.lang.StringBuilder(super.getMessage());
            for (java.lang.Throwable th = this.conflictingStackTrace; th != null; th = th.getCause()) {
                sb.append(", ");
                sb.append(th.getMessage());
            }
            return sb.toString();
        }
    }

    @com.google.common.annotations.Beta
    public static final class WithExplicitOrdering<E extends java.lang.Enum<E>> extends com.google.common.util.concurrent.CycleDetectingLockFactory {
        public final java.util.Map<E, com.google.common.util.concurrent.CycleDetectingLockFactory.LockGraphNode> e;

        @com.google.common.annotations.VisibleForTesting
        public WithExplicitOrdering(com.google.common.util.concurrent.CycleDetectingLockFactory.Policy policy, java.util.Map<E, com.google.common.util.concurrent.CycleDetectingLockFactory.LockGraphNode> map) {
            super(policy, null);
            this.e = map;
        }

        public java.util.concurrent.locks.ReentrantLock newReentrantLock(E e) {
            return newReentrantLock((com.google.common.util.concurrent.CycleDetectingLockFactory.WithExplicitOrdering<E>) e, false);
        }

        public java.util.concurrent.locks.ReentrantLock newReentrantLock(E e, boolean z) {
            return this.a == com.google.common.util.concurrent.CycleDetectingLockFactory.Policies.DISABLED ? new java.util.concurrent.locks.ReentrantLock(z) : new com.google.common.util.concurrent.CycleDetectingLockFactory.CycleDetectingReentrantLock(this, this.e.get(e), z, null);
        }

        public java.util.concurrent.locks.ReentrantReadWriteLock newReentrantReadWriteLock(E e) {
            return newReentrantReadWriteLock((com.google.common.util.concurrent.CycleDetectingLockFactory.WithExplicitOrdering<E>) e, false);
        }

        public java.util.concurrent.locks.ReentrantReadWriteLock newReentrantReadWriteLock(E e, boolean z) {
            return this.a == com.google.common.util.concurrent.CycleDetectingLockFactory.Policies.DISABLED ? new java.util.concurrent.locks.ReentrantReadWriteLock(z) : new com.google.common.util.concurrent.CycleDetectingLockFactory.CycleDetectingReentrantReadWriteLock(this, this.e.get(e), z, null);
        }
    }

    public CycleDetectingLockFactory(com.google.common.util.concurrent.CycleDetectingLockFactory.Policy policy) {
        this.a = (com.google.common.util.concurrent.CycleDetectingLockFactory.Policy) com.google.common.base.Preconditions.checkNotNull(policy);
    }

    public /* synthetic */ CycleDetectingLockFactory(com.google.common.util.concurrent.CycleDetectingLockFactory.Policy policy, com.google.common.util.concurrent.CycleDetectingLockFactory.AnonymousClass1 anonymousClass1) {
        this(policy);
    }

    @com.google.common.annotations.VisibleForTesting
    public static <E extends java.lang.Enum<E>> java.util.Map<E, com.google.common.util.concurrent.CycleDetectingLockFactory.LockGraphNode> e(java.lang.Class<E> cls) {
        java.util.EnumMap newEnumMap = com.google.common.collect.Maps.newEnumMap(cls);
        E[] enumConstants = cls.getEnumConstants();
        int length = enumConstants.length;
        java.util.ArrayList newArrayListWithCapacity = com.google.common.collect.Lists.newArrayListWithCapacity(length);
        int i = 0;
        for (E e : enumConstants) {
            com.google.common.util.concurrent.CycleDetectingLockFactory.LockGraphNode lockGraphNode = new com.google.common.util.concurrent.CycleDetectingLockFactory.LockGraphNode(f(e));
            newArrayListWithCapacity.add(lockGraphNode);
            newEnumMap.put((java.util.EnumMap) e, (E) lockGraphNode);
        }
        for (int i2 = 1; i2 < length; i2++) {
            ((com.google.common.util.concurrent.CycleDetectingLockFactory.LockGraphNode) newArrayListWithCapacity.get(i2)).b(com.google.common.util.concurrent.CycleDetectingLockFactory.Policies.THROW, newArrayListWithCapacity.subList(0, i2));
        }
        while (i < length - 1) {
            i++;
            ((com.google.common.util.concurrent.CycleDetectingLockFactory.LockGraphNode) newArrayListWithCapacity.get(i)).b(com.google.common.util.concurrent.CycleDetectingLockFactory.Policies.DISABLED, newArrayListWithCapacity.subList(i, length));
        }
        return java.util.Collections.unmodifiableMap(newEnumMap);
    }

    public static java.lang.String f(java.lang.Enum<?> r2) {
        return r2.getDeclaringClass().getSimpleName() + "." + r2.name();
    }

    public static java.util.Map<? extends java.lang.Enum, com.google.common.util.concurrent.CycleDetectingLockFactory.LockGraphNode> g(java.lang.Class<? extends java.lang.Enum> cls) {
        java.util.concurrent.ConcurrentMap<java.lang.Class<? extends java.lang.Enum>, java.util.Map<? extends java.lang.Enum, com.google.common.util.concurrent.CycleDetectingLockFactory.LockGraphNode>> concurrentMap = b;
        java.util.Map<? extends java.lang.Enum, com.google.common.util.concurrent.CycleDetectingLockFactory.LockGraphNode> map = concurrentMap.get(cls);
        if (map != null) {
            return map;
        }
        java.util.Map<? extends java.lang.Enum, com.google.common.util.concurrent.CycleDetectingLockFactory.LockGraphNode> e = e(cls);
        return (java.util.Map) com.google.common.base.MoreObjects.firstNonNull(concurrentMap.putIfAbsent(cls, e), e);
    }

    public static void h(com.google.common.util.concurrent.CycleDetectingLockFactory.CycleDetectingLock cycleDetectingLock) {
        if (cycleDetectingLock.isAcquiredByCurrentThread()) {
            return;
        }
        java.util.ArrayList<com.google.common.util.concurrent.CycleDetectingLockFactory.LockGraphNode> arrayList = d.get();
        com.google.common.util.concurrent.CycleDetectingLockFactory.LockGraphNode lockGraphNode = cycleDetectingLock.getLockGraphNode();
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size) == lockGraphNode) {
                arrayList.remove(size);
                return;
            }
        }
    }

    public static com.google.common.util.concurrent.CycleDetectingLockFactory newInstance(com.google.common.util.concurrent.CycleDetectingLockFactory.Policy policy) {
        return new com.google.common.util.concurrent.CycleDetectingLockFactory(policy);
    }

    public static <E extends java.lang.Enum<E>> com.google.common.util.concurrent.CycleDetectingLockFactory.WithExplicitOrdering<E> newInstanceWithExplicitOrdering(java.lang.Class<E> cls, com.google.common.util.concurrent.CycleDetectingLockFactory.Policy policy) {
        com.google.common.base.Preconditions.checkNotNull(cls);
        com.google.common.base.Preconditions.checkNotNull(policy);
        return new com.google.common.util.concurrent.CycleDetectingLockFactory.WithExplicitOrdering<>(policy, g(cls));
    }

    public final void a(com.google.common.util.concurrent.CycleDetectingLockFactory.CycleDetectingLock cycleDetectingLock) {
        if (cycleDetectingLock.isAcquiredByCurrentThread()) {
            return;
        }
        java.util.ArrayList<com.google.common.util.concurrent.CycleDetectingLockFactory.LockGraphNode> arrayList = d.get();
        com.google.common.util.concurrent.CycleDetectingLockFactory.LockGraphNode lockGraphNode = cycleDetectingLock.getLockGraphNode();
        lockGraphNode.b(this.a, arrayList);
        arrayList.add(lockGraphNode);
    }

    public java.util.concurrent.locks.ReentrantLock newReentrantLock(java.lang.String str) {
        return newReentrantLock(str, false);
    }

    public java.util.concurrent.locks.ReentrantLock newReentrantLock(java.lang.String str, boolean z) {
        return this.a == com.google.common.util.concurrent.CycleDetectingLockFactory.Policies.DISABLED ? new java.util.concurrent.locks.ReentrantLock(z) : new com.google.common.util.concurrent.CycleDetectingLockFactory.CycleDetectingReentrantLock(this, new com.google.common.util.concurrent.CycleDetectingLockFactory.LockGraphNode(str), z, null);
    }

    public java.util.concurrent.locks.ReentrantReadWriteLock newReentrantReadWriteLock(java.lang.String str) {
        return newReentrantReadWriteLock(str, false);
    }

    public java.util.concurrent.locks.ReentrantReadWriteLock newReentrantReadWriteLock(java.lang.String str, boolean z) {
        return this.a == com.google.common.util.concurrent.CycleDetectingLockFactory.Policies.DISABLED ? new java.util.concurrent.locks.ReentrantReadWriteLock(z) : new com.google.common.util.concurrent.CycleDetectingLockFactory.CycleDetectingReentrantReadWriteLock(this, new com.google.common.util.concurrent.CycleDetectingLockFactory.LockGraphNode(str), z, null);
    }
}
