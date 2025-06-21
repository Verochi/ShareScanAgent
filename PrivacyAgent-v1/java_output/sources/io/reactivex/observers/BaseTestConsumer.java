package io.reactivex.observers;

/* loaded from: classes13.dex */
public abstract class BaseTestConsumer<T, U extends io.reactivex.observers.BaseTestConsumer<T, U>> implements io.reactivex.disposables.Disposable {
    protected boolean checkSubscriptionOnce;
    protected long completions;
    protected int establishedFusionMode;
    protected int initialFusionMode;
    protected java.lang.Thread lastThread;
    protected java.lang.CharSequence tag;
    protected boolean timeout;
    protected final java.util.List<T> values = new io.reactivex.internal.util.VolatileSizeArrayList();
    protected final java.util.List<java.lang.Throwable> errors = new io.reactivex.internal.util.VolatileSizeArrayList();
    protected final java.util.concurrent.CountDownLatch done = new java.util.concurrent.CountDownLatch(1);

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static abstract class TestWaitStrategy implements java.lang.Runnable {
        private static final /* synthetic */ io.reactivex.observers.BaseTestConsumer.TestWaitStrategy[] $VALUES;
        public static final io.reactivex.observers.BaseTestConsumer.TestWaitStrategy SLEEP_1000MS;
        public static final io.reactivex.observers.BaseTestConsumer.TestWaitStrategy SLEEP_100MS;
        public static final io.reactivex.observers.BaseTestConsumer.TestWaitStrategy SLEEP_10MS;
        public static final io.reactivex.observers.BaseTestConsumer.TestWaitStrategy SLEEP_1MS;
        public static final io.reactivex.observers.BaseTestConsumer.TestWaitStrategy SPIN;
        public static final io.reactivex.observers.BaseTestConsumer.TestWaitStrategy YIELD;

        /* renamed from: io.reactivex.observers.BaseTestConsumer$TestWaitStrategy$1, reason: invalid class name */
        public enum AnonymousClass1 extends io.reactivex.observers.BaseTestConsumer.TestWaitStrategy {
            public AnonymousClass1(java.lang.String str, int i) {
                super(str, i, null);
            }

            @Override // io.reactivex.observers.BaseTestConsumer.TestWaitStrategy, java.lang.Runnable
            public void run() {
            }
        }

        /* renamed from: io.reactivex.observers.BaseTestConsumer$TestWaitStrategy$2, reason: invalid class name */
        public enum AnonymousClass2 extends io.reactivex.observers.BaseTestConsumer.TestWaitStrategy {
            public AnonymousClass2(java.lang.String str, int i) {
                super(str, i, null);
            }

            @Override // io.reactivex.observers.BaseTestConsumer.TestWaitStrategy, java.lang.Runnable
            public void run() {
                java.lang.Thread.yield();
            }
        }

        /* renamed from: io.reactivex.observers.BaseTestConsumer$TestWaitStrategy$3, reason: invalid class name */
        public enum AnonymousClass3 extends io.reactivex.observers.BaseTestConsumer.TestWaitStrategy {
            public AnonymousClass3(java.lang.String str, int i) {
                super(str, i, null);
            }

            @Override // io.reactivex.observers.BaseTestConsumer.TestWaitStrategy, java.lang.Runnable
            public void run() {
                io.reactivex.observers.BaseTestConsumer.TestWaitStrategy.sleep(1);
            }
        }

        /* renamed from: io.reactivex.observers.BaseTestConsumer$TestWaitStrategy$4, reason: invalid class name */
        public enum AnonymousClass4 extends io.reactivex.observers.BaseTestConsumer.TestWaitStrategy {
            public AnonymousClass4(java.lang.String str, int i) {
                super(str, i, null);
            }

            @Override // io.reactivex.observers.BaseTestConsumer.TestWaitStrategy, java.lang.Runnable
            public void run() {
                io.reactivex.observers.BaseTestConsumer.TestWaitStrategy.sleep(10);
            }
        }

        /* renamed from: io.reactivex.observers.BaseTestConsumer$TestWaitStrategy$5, reason: invalid class name */
        public enum AnonymousClass5 extends io.reactivex.observers.BaseTestConsumer.TestWaitStrategy {
            public AnonymousClass5(java.lang.String str, int i) {
                super(str, i, null);
            }

            @Override // io.reactivex.observers.BaseTestConsumer.TestWaitStrategy, java.lang.Runnable
            public void run() {
                io.reactivex.observers.BaseTestConsumer.TestWaitStrategy.sleep(100);
            }
        }

        /* renamed from: io.reactivex.observers.BaseTestConsumer$TestWaitStrategy$6, reason: invalid class name */
        public enum AnonymousClass6 extends io.reactivex.observers.BaseTestConsumer.TestWaitStrategy {
            public AnonymousClass6(java.lang.String str, int i) {
                super(str, i, null);
            }

            @Override // io.reactivex.observers.BaseTestConsumer.TestWaitStrategy, java.lang.Runnable
            public void run() {
                io.reactivex.observers.BaseTestConsumer.TestWaitStrategy.sleep(1000);
            }
        }

        static {
            io.reactivex.observers.BaseTestConsumer.TestWaitStrategy.AnonymousClass1 anonymousClass1 = new io.reactivex.observers.BaseTestConsumer.TestWaitStrategy.AnonymousClass1("SPIN", 0);
            SPIN = anonymousClass1;
            io.reactivex.observers.BaseTestConsumer.TestWaitStrategy.AnonymousClass2 anonymousClass2 = new io.reactivex.observers.BaseTestConsumer.TestWaitStrategy.AnonymousClass2("YIELD", 1);
            YIELD = anonymousClass2;
            io.reactivex.observers.BaseTestConsumer.TestWaitStrategy.AnonymousClass3 anonymousClass3 = new io.reactivex.observers.BaseTestConsumer.TestWaitStrategy.AnonymousClass3("SLEEP_1MS", 2);
            SLEEP_1MS = anonymousClass3;
            io.reactivex.observers.BaseTestConsumer.TestWaitStrategy.AnonymousClass4 anonymousClass4 = new io.reactivex.observers.BaseTestConsumer.TestWaitStrategy.AnonymousClass4("SLEEP_10MS", 3);
            SLEEP_10MS = anonymousClass4;
            io.reactivex.observers.BaseTestConsumer.TestWaitStrategy.AnonymousClass5 anonymousClass5 = new io.reactivex.observers.BaseTestConsumer.TestWaitStrategy.AnonymousClass5("SLEEP_100MS", 4);
            SLEEP_100MS = anonymousClass5;
            io.reactivex.observers.BaseTestConsumer.TestWaitStrategy.AnonymousClass6 anonymousClass6 = new io.reactivex.observers.BaseTestConsumer.TestWaitStrategy.AnonymousClass6("SLEEP_1000MS", 5);
            SLEEP_1000MS = anonymousClass6;
            $VALUES = new io.reactivex.observers.BaseTestConsumer.TestWaitStrategy[]{anonymousClass1, anonymousClass2, anonymousClass3, anonymousClass4, anonymousClass5, anonymousClass6};
        }

        private TestWaitStrategy(java.lang.String str, int i) {
        }

        public /* synthetic */ TestWaitStrategy(java.lang.String str, int i, io.reactivex.observers.BaseTestConsumer.AnonymousClass1 anonymousClass1) {
            this(str, i);
        }

        public static void sleep(int i) {
            try {
                java.lang.Thread.sleep(i);
            } catch (java.lang.InterruptedException e) {
                throw new java.lang.RuntimeException(e);
            }
        }

        public static io.reactivex.observers.BaseTestConsumer.TestWaitStrategy valueOf(java.lang.String str) {
            return (io.reactivex.observers.BaseTestConsumer.TestWaitStrategy) java.lang.Enum.valueOf(io.reactivex.observers.BaseTestConsumer.TestWaitStrategy.class, str);
        }

        public static io.reactivex.observers.BaseTestConsumer.TestWaitStrategy[] values() {
            return (io.reactivex.observers.BaseTestConsumer.TestWaitStrategy[]) $VALUES.clone();
        }

        @Override // java.lang.Runnable
        public abstract void run();
    }

    public static java.lang.String valueAndClass(java.lang.Object obj) {
        if (obj == null) {
            return com.igexin.push.core.b.m;
        }
        return obj + " (class: " + obj.getClass().getSimpleName() + ")";
    }

    public final U assertComplete() {
        long j = this.completions;
        if (j == 0) {
            throw fail("Not completed");
        }
        if (j <= 1) {
            return this;
        }
        throw fail("Multiple completions: " + j);
    }

    public final U assertEmpty() {
        return (U) assertSubscribed().assertNoValues().assertNoErrors().assertNotComplete();
    }

    public final U assertError(io.reactivex.functions.Predicate<java.lang.Throwable> predicate) {
        boolean z;
        int size = this.errors.size();
        if (size == 0) {
            throw fail("No errors");
        }
        java.util.Iterator<java.lang.Throwable> it = this.errors.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            try {
                if (predicate.test(it.next())) {
                    z = true;
                    break;
                }
            } catch (java.lang.Exception e) {
                throw io.reactivex.internal.util.ExceptionHelper.wrapOrThrow(e);
            }
        }
        if (!z) {
            throw fail("Error not present");
        }
        if (size == 1) {
            return this;
        }
        throw fail("Error present but other errors as well");
    }

    public final U assertError(java.lang.Class<? extends java.lang.Throwable> cls) {
        return assertError(io.reactivex.internal.functions.Functions.isInstanceOf(cls));
    }

    public final U assertError(java.lang.Throwable th) {
        return assertError(io.reactivex.internal.functions.Functions.equalsWith(th));
    }

    public final U assertErrorMessage(java.lang.String str) {
        int size = this.errors.size();
        if (size == 0) {
            throw fail("No errors");
        }
        if (size != 1) {
            throw fail("Multiple errors");
        }
        java.lang.String message = this.errors.get(0).getMessage();
        if (io.reactivex.internal.functions.ObjectHelper.equals(str, message)) {
            return this;
        }
        throw fail("Error message differs; exptected: " + str + " but was: " + message);
    }

    public final U assertFailure(io.reactivex.functions.Predicate<java.lang.Throwable> predicate, T... tArr) {
        return (U) assertSubscribed().assertValues(tArr).assertError(predicate).assertNotComplete();
    }

    public final U assertFailure(java.lang.Class<? extends java.lang.Throwable> cls, T... tArr) {
        return (U) assertSubscribed().assertValues(tArr).assertError(cls).assertNotComplete();
    }

    public final U assertFailureAndMessage(java.lang.Class<? extends java.lang.Throwable> cls, java.lang.String str, T... tArr) {
        return (U) assertSubscribed().assertValues(tArr).assertError(cls).assertErrorMessage(str).assertNotComplete();
    }

    public final U assertNever(io.reactivex.functions.Predicate<? super T> predicate) {
        int size = this.values.size();
        for (int i = 0; i < size; i++) {
            try {
                if (predicate.test(this.values.get(i))) {
                    throw fail("Value at position " + i + " matches predicate " + predicate.toString() + ", which was not expected.");
                }
            } catch (java.lang.Exception e) {
                throw io.reactivex.internal.util.ExceptionHelper.wrapOrThrow(e);
            }
        }
        return this;
    }

    public final U assertNever(T t) {
        int size = this.values.size();
        for (int i = 0; i < size; i++) {
            if (io.reactivex.internal.functions.ObjectHelper.equals(this.values.get(i), t)) {
                throw fail("Value at position " + i + " is equal to " + valueAndClass(t) + "; Expected them to be different");
            }
        }
        return this;
    }

    public final U assertNoErrors() {
        if (this.errors.size() == 0) {
            return this;
        }
        throw fail("Error(s) present: " + this.errors);
    }

    public final U assertNoTimeout() {
        if (this.timeout) {
            throw fail("Timeout?!");
        }
        return this;
    }

    public final U assertNoValues() {
        return assertValueCount(0);
    }

    public final U assertNotComplete() {
        long j = this.completions;
        if (j == 1) {
            throw fail("Completed!");
        }
        if (j <= 1) {
            return this;
        }
        throw fail("Multiple completions: " + j);
    }

    public abstract U assertNotSubscribed();

    public final U assertNotTerminated() {
        if (this.done.getCount() != 0) {
            return this;
        }
        throw fail("Subscriber terminated!");
    }

    public final U assertResult(T... tArr) {
        return (U) assertSubscribed().assertValues(tArr).assertNoErrors().assertComplete();
    }

    public abstract U assertSubscribed();

    public final U assertTerminated() {
        if (this.done.getCount() != 0) {
            throw fail("Subscriber still running!");
        }
        long j = this.completions;
        if (j > 1) {
            throw fail("Terminated with multiple completions: " + j);
        }
        int size = this.errors.size();
        if (size > 1) {
            throw fail("Terminated with multiple errors: " + size);
        }
        if (j == 0 || size == 0) {
            return this;
        }
        throw fail("Terminated with multiple completions and errors: " + j);
    }

    public final U assertTimeout() {
        if (this.timeout) {
            return this;
        }
        throw fail("No timeout?!");
    }

    public final U assertValue(io.reactivex.functions.Predicate<T> predicate) {
        assertValueAt(0, (io.reactivex.functions.Predicate) predicate);
        if (this.values.size() <= 1) {
            return this;
        }
        throw fail("Value present but other values as well");
    }

    public final U assertValue(T t) {
        if (this.values.size() != 1) {
            throw fail("expected: " + valueAndClass(t) + " but was: " + this.values);
        }
        T t2 = this.values.get(0);
        if (io.reactivex.internal.functions.ObjectHelper.equals(t, t2)) {
            return this;
        }
        throw fail("expected: " + valueAndClass(t) + " but was: " + valueAndClass(t2));
    }

    public final U assertValueAt(int i, io.reactivex.functions.Predicate<T> predicate) {
        if (this.values.size() == 0) {
            throw fail("No values");
        }
        if (i >= this.values.size()) {
            throw fail("Invalid index: " + i);
        }
        try {
            if (predicate.test(this.values.get(i))) {
                return this;
            }
            throw fail("Value not present");
        } catch (java.lang.Exception e) {
            throw io.reactivex.internal.util.ExceptionHelper.wrapOrThrow(e);
        }
    }

    public final U assertValueAt(int i, T t) {
        int size = this.values.size();
        if (size == 0) {
            throw fail("No values");
        }
        if (i >= size) {
            throw fail("Invalid index: " + i);
        }
        T t2 = this.values.get(i);
        if (io.reactivex.internal.functions.ObjectHelper.equals(t, t2)) {
            return this;
        }
        throw fail("expected: " + valueAndClass(t) + " but was: " + valueAndClass(t2));
    }

    public final U assertValueCount(int i) {
        int size = this.values.size();
        if (size == i) {
            return this;
        }
        throw fail("Value counts differ; expected: " + i + " but was: " + size);
    }

    public final U assertValueSequence(java.lang.Iterable<? extends T> iterable) {
        boolean hasNext;
        boolean hasNext2;
        java.util.Iterator<T> it = this.values.iterator();
        java.util.Iterator<? extends T> it2 = iterable.iterator();
        int i = 0;
        while (true) {
            hasNext = it2.hasNext();
            hasNext2 = it.hasNext();
            if (!hasNext2 || !hasNext) {
                break;
            }
            T next = it2.next();
            T next2 = it.next();
            if (!io.reactivex.internal.functions.ObjectHelper.equals(next, next2)) {
                throw fail("Values at position " + i + " differ; expected: " + valueAndClass(next) + " but was: " + valueAndClass(next2));
            }
            i++;
        }
        if (hasNext2) {
            throw fail("More values received than expected (" + i + ")");
        }
        if (!hasNext) {
            return this;
        }
        throw fail("Fewer values received than expected (" + i + ")");
    }

    public final U assertValueSequenceOnly(java.lang.Iterable<? extends T> iterable) {
        return (U) assertSubscribed().assertValueSequence(iterable).assertNoErrors().assertNotComplete();
    }

    public final U assertValueSet(java.util.Collection<? extends T> collection) {
        if (collection.isEmpty()) {
            assertNoValues();
            return this;
        }
        for (T t : this.values) {
            if (!collection.contains(t)) {
                throw fail("Value not in the expected collection: " + valueAndClass(t));
            }
        }
        return this;
    }

    public final U assertValueSetOnly(java.util.Collection<? extends T> collection) {
        return (U) assertSubscribed().assertValueSet(collection).assertNoErrors().assertNotComplete();
    }

    public final U assertValues(T... tArr) {
        int size = this.values.size();
        if (size != tArr.length) {
            throw fail("Value count differs; expected: " + tArr.length + " " + java.util.Arrays.toString(tArr) + " but was: " + size + " " + this.values);
        }
        for (int i = 0; i < size; i++) {
            T t = this.values.get(i);
            T t2 = tArr[i];
            if (!io.reactivex.internal.functions.ObjectHelper.equals(t2, t)) {
                throw fail("Values at position " + i + " differ; expected: " + valueAndClass(t2) + " but was: " + valueAndClass(t));
            }
        }
        return this;
    }

    public final U assertValuesOnly(T... tArr) {
        return (U) assertSubscribed().assertValues(tArr).assertNoErrors().assertNotComplete();
    }

    public final U await() throws java.lang.InterruptedException {
        if (this.done.getCount() == 0) {
            return this;
        }
        this.done.await();
        return this;
    }

    public final boolean await(long j, java.util.concurrent.TimeUnit timeUnit) throws java.lang.InterruptedException {
        boolean z = this.done.getCount() == 0 || this.done.await(j, timeUnit);
        this.timeout = !z;
        return z;
    }

    public final U awaitCount(int i) {
        return awaitCount(i, io.reactivex.observers.BaseTestConsumer.TestWaitStrategy.SLEEP_10MS, 5000L);
    }

    public final U awaitCount(int i, java.lang.Runnable runnable) {
        return awaitCount(i, runnable, 5000L);
    }

    public final U awaitCount(int i, java.lang.Runnable runnable, long j) {
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        while (true) {
            if (j > 0 && java.lang.System.currentTimeMillis() - currentTimeMillis >= j) {
                this.timeout = true;
                break;
            }
            if (this.done.getCount() == 0 || this.values.size() >= i) {
                break;
            }
            runnable.run();
        }
        return this;
    }

    public final U awaitDone(long j, java.util.concurrent.TimeUnit timeUnit) {
        try {
            if (!this.done.await(j, timeUnit)) {
                this.timeout = true;
                dispose();
            }
            return this;
        } catch (java.lang.InterruptedException e) {
            dispose();
            throw io.reactivex.internal.util.ExceptionHelper.wrapOrThrow(e);
        }
    }

    public final boolean awaitTerminalEvent() {
        try {
            await();
            return true;
        } catch (java.lang.InterruptedException unused) {
            java.lang.Thread.currentThread().interrupt();
            return false;
        }
    }

    public final boolean awaitTerminalEvent(long j, java.util.concurrent.TimeUnit timeUnit) {
        try {
            return await(j, timeUnit);
        } catch (java.lang.InterruptedException unused) {
            java.lang.Thread.currentThread().interrupt();
            return false;
        }
    }

    public final U clearTimeout() {
        this.timeout = false;
        return this;
    }

    public final long completions() {
        return this.completions;
    }

    public final int errorCount() {
        return this.errors.size();
    }

    public final java.util.List<java.lang.Throwable> errors() {
        return this.errors;
    }

    public final java.lang.AssertionError fail(java.lang.String str) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder(str.length() + 64);
        sb.append(str);
        sb.append(" (");
        sb.append("latch = ");
        sb.append(this.done.getCount());
        sb.append(", ");
        sb.append("values = ");
        sb.append(this.values.size());
        sb.append(", ");
        sb.append("errors = ");
        sb.append(this.errors.size());
        sb.append(", ");
        sb.append("completions = ");
        sb.append(this.completions);
        if (this.timeout) {
            sb.append(", timeout!");
        }
        if (isDisposed()) {
            sb.append(", disposed!");
        }
        java.lang.CharSequence charSequence = this.tag;
        if (charSequence != null) {
            sb.append(", tag = ");
            sb.append(charSequence);
        }
        sb.append(')');
        java.lang.AssertionError assertionError = new java.lang.AssertionError(sb.toString());
        if (!this.errors.isEmpty()) {
            if (this.errors.size() == 1) {
                assertionError.initCause(this.errors.get(0));
            } else {
                assertionError.initCause(new io.reactivex.exceptions.CompositeException(this.errors));
            }
        }
        return assertionError;
    }

    public final java.util.List<java.util.List<java.lang.Object>> getEvents() {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        arrayList.add(values());
        arrayList.add(errors());
        java.util.ArrayList arrayList2 = new java.util.ArrayList();
        for (long j = 0; j < this.completions; j++) {
            arrayList2.add(io.reactivex.Notification.createOnComplete());
        }
        arrayList.add(arrayList2);
        return arrayList;
    }

    public final boolean isTerminated() {
        return this.done.getCount() == 0;
    }

    public final boolean isTimeout() {
        return this.timeout;
    }

    public final java.lang.Thread lastThread() {
        return this.lastThread;
    }

    public final int valueCount() {
        return this.values.size();
    }

    public final java.util.List<T> values() {
        return this.values;
    }

    public final U withTag(java.lang.CharSequence charSequence) {
        this.tag = charSequence;
        return this;
    }
}
