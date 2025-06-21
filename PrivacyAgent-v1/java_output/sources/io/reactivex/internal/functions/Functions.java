package io.reactivex.internal.functions;

/* loaded from: classes9.dex */
public final class Functions {
    public static final io.reactivex.functions.Function<java.lang.Object, java.lang.Object> a = new io.reactivex.internal.functions.Functions.Identity();
    public static final java.lang.Runnable EMPTY_RUNNABLE = new io.reactivex.internal.functions.Functions.EmptyRunnable();
    public static final io.reactivex.functions.Action EMPTY_ACTION = new io.reactivex.internal.functions.Functions.EmptyAction();
    public static final io.reactivex.functions.Consumer<java.lang.Object> b = new io.reactivex.internal.functions.Functions.EmptyConsumer();
    public static final io.reactivex.functions.Consumer<java.lang.Throwable> ERROR_CONSUMER = new io.reactivex.internal.functions.Functions.ErrorConsumer();
    public static final io.reactivex.functions.Consumer<java.lang.Throwable> ON_ERROR_MISSING = new io.reactivex.internal.functions.Functions.OnErrorMissingConsumer();
    public static final io.reactivex.functions.LongConsumer EMPTY_LONG_CONSUMER = new io.reactivex.internal.functions.Functions.EmptyLongConsumer();
    public static final io.reactivex.functions.Predicate<java.lang.Object> c = new io.reactivex.internal.functions.Functions.TruePredicate();
    public static final io.reactivex.functions.Predicate<java.lang.Object> d = new io.reactivex.internal.functions.Functions.FalsePredicate();
    public static final java.util.concurrent.Callable<java.lang.Object> e = new io.reactivex.internal.functions.Functions.NullCallable();
    public static final java.util.Comparator<java.lang.Object> f = new io.reactivex.internal.functions.Functions.NaturalObjectComparator();
    public static final io.reactivex.functions.Consumer<org.reactivestreams.Subscription> REQUEST_MAX = new io.reactivex.internal.functions.Functions.MaxRequestSubscription();

    public static final class ActionConsumer<T> implements io.reactivex.functions.Consumer<T> {
        public final io.reactivex.functions.Action n;

        public ActionConsumer(io.reactivex.functions.Action action) {
            this.n = action;
        }

        @Override // io.reactivex.functions.Consumer
        public void accept(T t) throws java.lang.Exception {
            this.n.run();
        }
    }

    public static final class Array2Func<T1, T2, R> implements io.reactivex.functions.Function<java.lang.Object[], R> {
        public final io.reactivex.functions.BiFunction<? super T1, ? super T2, ? extends R> n;

        public Array2Func(io.reactivex.functions.BiFunction<? super T1, ? super T2, ? extends R> biFunction) {
            this.n = biFunction;
        }

        @Override // io.reactivex.functions.Function
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public R apply(java.lang.Object[] objArr) throws java.lang.Exception {
            if (objArr.length == 2) {
                return this.n.apply(objArr[0], objArr[1]);
            }
            throw new java.lang.IllegalArgumentException("Array of size 2 expected but got " + objArr.length);
        }
    }

    public static final class Array3Func<T1, T2, T3, R> implements io.reactivex.functions.Function<java.lang.Object[], R> {
        public final io.reactivex.functions.Function3<T1, T2, T3, R> n;

        public Array3Func(io.reactivex.functions.Function3<T1, T2, T3, R> function3) {
            this.n = function3;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Function
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public R apply(java.lang.Object[] objArr) throws java.lang.Exception {
            if (objArr.length == 3) {
                return (R) this.n.apply(objArr[0], objArr[1], objArr[2]);
            }
            throw new java.lang.IllegalArgumentException("Array of size 3 expected but got " + objArr.length);
        }
    }

    public static final class Array4Func<T1, T2, T3, T4, R> implements io.reactivex.functions.Function<java.lang.Object[], R> {
        public final io.reactivex.functions.Function4<T1, T2, T3, T4, R> n;

        public Array4Func(io.reactivex.functions.Function4<T1, T2, T3, T4, R> function4) {
            this.n = function4;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Function
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public R apply(java.lang.Object[] objArr) throws java.lang.Exception {
            if (objArr.length == 4) {
                return (R) this.n.apply(objArr[0], objArr[1], objArr[2], objArr[3]);
            }
            throw new java.lang.IllegalArgumentException("Array of size 4 expected but got " + objArr.length);
        }
    }

    public static final class Array5Func<T1, T2, T3, T4, T5, R> implements io.reactivex.functions.Function<java.lang.Object[], R> {
        public final io.reactivex.functions.Function5<T1, T2, T3, T4, T5, R> n;

        public Array5Func(io.reactivex.functions.Function5<T1, T2, T3, T4, T5, R> function5) {
            this.n = function5;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Function
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public R apply(java.lang.Object[] objArr) throws java.lang.Exception {
            if (objArr.length == 5) {
                return (R) this.n.apply(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4]);
            }
            throw new java.lang.IllegalArgumentException("Array of size 5 expected but got " + objArr.length);
        }
    }

    public static final class Array6Func<T1, T2, T3, T4, T5, T6, R> implements io.reactivex.functions.Function<java.lang.Object[], R> {
        public final io.reactivex.functions.Function6<T1, T2, T3, T4, T5, T6, R> n;

        public Array6Func(io.reactivex.functions.Function6<T1, T2, T3, T4, T5, T6, R> function6) {
            this.n = function6;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Function
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public R apply(java.lang.Object[] objArr) throws java.lang.Exception {
            if (objArr.length == 6) {
                return (R) this.n.apply(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4], objArr[5]);
            }
            throw new java.lang.IllegalArgumentException("Array of size 6 expected but got " + objArr.length);
        }
    }

    public static final class Array7Func<T1, T2, T3, T4, T5, T6, T7, R> implements io.reactivex.functions.Function<java.lang.Object[], R> {
        public final io.reactivex.functions.Function7<T1, T2, T3, T4, T5, T6, T7, R> n;

        public Array7Func(io.reactivex.functions.Function7<T1, T2, T3, T4, T5, T6, T7, R> function7) {
            this.n = function7;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Function
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public R apply(java.lang.Object[] objArr) throws java.lang.Exception {
            if (objArr.length == 7) {
                return (R) this.n.apply(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4], objArr[5], objArr[6]);
            }
            throw new java.lang.IllegalArgumentException("Array of size 7 expected but got " + objArr.length);
        }
    }

    public static final class Array8Func<T1, T2, T3, T4, T5, T6, T7, T8, R> implements io.reactivex.functions.Function<java.lang.Object[], R> {
        public final io.reactivex.functions.Function8<T1, T2, T3, T4, T5, T6, T7, T8, R> n;

        public Array8Func(io.reactivex.functions.Function8<T1, T2, T3, T4, T5, T6, T7, T8, R> function8) {
            this.n = function8;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Function
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public R apply(java.lang.Object[] objArr) throws java.lang.Exception {
            if (objArr.length == 8) {
                return (R) this.n.apply(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4], objArr[5], objArr[6], objArr[7]);
            }
            throw new java.lang.IllegalArgumentException("Array of size 8 expected but got " + objArr.length);
        }
    }

    public static final class Array9Func<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> implements io.reactivex.functions.Function<java.lang.Object[], R> {
        public final io.reactivex.functions.Function9<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> n;

        public Array9Func(io.reactivex.functions.Function9<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> function9) {
            this.n = function9;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Function
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public R apply(java.lang.Object[] objArr) throws java.lang.Exception {
            if (objArr.length == 9) {
                return (R) this.n.apply(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4], objArr[5], objArr[6], objArr[7], objArr[8]);
            }
            throw new java.lang.IllegalArgumentException("Array of size 9 expected but got " + objArr.length);
        }
    }

    public static final class ArrayListCapacityCallable<T> implements java.util.concurrent.Callable<java.util.List<T>> {
        public final int n;

        public ArrayListCapacityCallable(int i) {
            this.n = i;
        }

        @Override // java.util.concurrent.Callable
        public java.util.List<T> call() throws java.lang.Exception {
            return new java.util.ArrayList(this.n);
        }
    }

    public static final class BooleanSupplierPredicateReverse<T> implements io.reactivex.functions.Predicate<T> {
        public final io.reactivex.functions.BooleanSupplier n;

        public BooleanSupplierPredicateReverse(io.reactivex.functions.BooleanSupplier booleanSupplier) {
            this.n = booleanSupplier;
        }

        @Override // io.reactivex.functions.Predicate
        public boolean test(T t) throws java.lang.Exception {
            return !this.n.getAsBoolean();
        }
    }

    public static class BoundedConsumer implements io.reactivex.functions.Consumer<org.reactivestreams.Subscription> {
        public final int n;

        public BoundedConsumer(int i) {
            this.n = i;
        }

        @Override // io.reactivex.functions.Consumer
        public void accept(org.reactivestreams.Subscription subscription) throws java.lang.Exception {
            subscription.request(this.n);
        }
    }

    public static final class CastToClass<T, U> implements io.reactivex.functions.Function<T, U> {
        public final java.lang.Class<U> n;

        public CastToClass(java.lang.Class<U> cls) {
            this.n = cls;
        }

        @Override // io.reactivex.functions.Function
        public U apply(T t) throws java.lang.Exception {
            return this.n.cast(t);
        }
    }

    public static final class ClassFilter<T, U> implements io.reactivex.functions.Predicate<T> {
        public final java.lang.Class<U> n;

        public ClassFilter(java.lang.Class<U> cls) {
            this.n = cls;
        }

        @Override // io.reactivex.functions.Predicate
        public boolean test(T t) throws java.lang.Exception {
            return this.n.isInstance(t);
        }
    }

    public static final class EmptyAction implements io.reactivex.functions.Action {
        @Override // io.reactivex.functions.Action
        public void run() {
        }

        public java.lang.String toString() {
            return "EmptyAction";
        }
    }

    public static final class EmptyConsumer implements io.reactivex.functions.Consumer<java.lang.Object> {
        @Override // io.reactivex.functions.Consumer
        public void accept(java.lang.Object obj) {
        }

        public java.lang.String toString() {
            return "EmptyConsumer";
        }
    }

    public static final class EmptyLongConsumer implements io.reactivex.functions.LongConsumer {
        @Override // io.reactivex.functions.LongConsumer
        public void accept(long j) {
        }
    }

    public static final class EmptyRunnable implements java.lang.Runnable {
        @Override // java.lang.Runnable
        public void run() {
        }

        public java.lang.String toString() {
            return "EmptyRunnable";
        }
    }

    public static final class EqualsPredicate<T> implements io.reactivex.functions.Predicate<T> {
        public final T n;

        public EqualsPredicate(T t) {
            this.n = t;
        }

        @Override // io.reactivex.functions.Predicate
        public boolean test(T t) throws java.lang.Exception {
            return io.reactivex.internal.functions.ObjectHelper.equals(t, this.n);
        }
    }

    public static final class ErrorConsumer implements io.reactivex.functions.Consumer<java.lang.Throwable> {
        @Override // io.reactivex.functions.Consumer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(java.lang.Throwable th) {
            io.reactivex.plugins.RxJavaPlugins.onError(th);
        }
    }

    public static final class FalsePredicate implements io.reactivex.functions.Predicate<java.lang.Object> {
        @Override // io.reactivex.functions.Predicate
        public boolean test(java.lang.Object obj) {
            return false;
        }
    }

    public static final class FutureAction implements io.reactivex.functions.Action {
        public final java.util.concurrent.Future<?> n;

        public FutureAction(java.util.concurrent.Future<?> future) {
            this.n = future;
        }

        @Override // io.reactivex.functions.Action
        public void run() throws java.lang.Exception {
            this.n.get();
        }
    }

    public enum HashSetCallable implements java.util.concurrent.Callable<java.util.Set<java.lang.Object>> {
        INSTANCE;

        @Override // java.util.concurrent.Callable
        public java.util.Set<java.lang.Object> call() throws java.lang.Exception {
            return new java.util.HashSet();
        }
    }

    public static final class Identity implements io.reactivex.functions.Function<java.lang.Object, java.lang.Object> {
        @Override // io.reactivex.functions.Function
        public java.lang.Object apply(java.lang.Object obj) {
            return obj;
        }

        public java.lang.String toString() {
            return "IdentityFunction";
        }
    }

    public static final class JustValue<T, U> implements java.util.concurrent.Callable<U>, io.reactivex.functions.Function<T, U> {
        public final U n;

        public JustValue(U u) {
            this.n = u;
        }

        @Override // io.reactivex.functions.Function
        public U apply(T t) throws java.lang.Exception {
            return this.n;
        }

        @Override // java.util.concurrent.Callable
        public U call() throws java.lang.Exception {
            return this.n;
        }
    }

    public static final class ListSorter<T> implements io.reactivex.functions.Function<java.util.List<T>, java.util.List<T>> {
        public final java.util.Comparator<? super T> n;

        public ListSorter(java.util.Comparator<? super T> comparator) {
            this.n = comparator;
        }

        @Override // io.reactivex.functions.Function
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public java.util.List<T> apply(java.util.List<T> list) {
            java.util.Collections.sort(list, this.n);
            return list;
        }
    }

    public static final class MaxRequestSubscription implements io.reactivex.functions.Consumer<org.reactivestreams.Subscription> {
        @Override // io.reactivex.functions.Consumer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(org.reactivestreams.Subscription subscription) throws java.lang.Exception {
            subscription.request(Long.MAX_VALUE);
        }
    }

    public enum NaturalComparator implements java.util.Comparator<java.lang.Object> {
        INSTANCE;

        @Override // java.util.Comparator
        public int compare(java.lang.Object obj, java.lang.Object obj2) {
            return ((java.lang.Comparable) obj).compareTo(obj2);
        }
    }

    public static final class NaturalObjectComparator implements java.util.Comparator<java.lang.Object> {
        @Override // java.util.Comparator
        public int compare(java.lang.Object obj, java.lang.Object obj2) {
            return ((java.lang.Comparable) obj).compareTo(obj2);
        }
    }

    public static final class NotificationOnComplete<T> implements io.reactivex.functions.Action {
        public final io.reactivex.functions.Consumer<? super io.reactivex.Notification<T>> n;

        public NotificationOnComplete(io.reactivex.functions.Consumer<? super io.reactivex.Notification<T>> consumer) {
            this.n = consumer;
        }

        @Override // io.reactivex.functions.Action
        public void run() throws java.lang.Exception {
            this.n.accept(io.reactivex.Notification.createOnComplete());
        }
    }

    public static final class NotificationOnError<T> implements io.reactivex.functions.Consumer<java.lang.Throwable> {
        public final io.reactivex.functions.Consumer<? super io.reactivex.Notification<T>> n;

        public NotificationOnError(io.reactivex.functions.Consumer<? super io.reactivex.Notification<T>> consumer) {
            this.n = consumer;
        }

        @Override // io.reactivex.functions.Consumer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(java.lang.Throwable th) throws java.lang.Exception {
            this.n.accept(io.reactivex.Notification.createOnError(th));
        }
    }

    public static final class NotificationOnNext<T> implements io.reactivex.functions.Consumer<T> {
        public final io.reactivex.functions.Consumer<? super io.reactivex.Notification<T>> n;

        public NotificationOnNext(io.reactivex.functions.Consumer<? super io.reactivex.Notification<T>> consumer) {
            this.n = consumer;
        }

        @Override // io.reactivex.functions.Consumer
        public void accept(T t) throws java.lang.Exception {
            this.n.accept(io.reactivex.Notification.createOnNext(t));
        }
    }

    public static final class NullCallable implements java.util.concurrent.Callable<java.lang.Object> {
        @Override // java.util.concurrent.Callable
        public java.lang.Object call() {
            return null;
        }
    }

    public static final class OnErrorMissingConsumer implements io.reactivex.functions.Consumer<java.lang.Throwable> {
        @Override // io.reactivex.functions.Consumer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(java.lang.Throwable th) {
            io.reactivex.plugins.RxJavaPlugins.onError(new io.reactivex.exceptions.OnErrorNotImplementedException(th));
        }
    }

    public static final class TimestampFunction<T> implements io.reactivex.functions.Function<T, io.reactivex.schedulers.Timed<T>> {
        public final java.util.concurrent.TimeUnit n;
        public final io.reactivex.Scheduler t;

        public TimestampFunction(java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler) {
            this.n = timeUnit;
            this.t = scheduler;
        }

        @Override // io.reactivex.functions.Function
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public io.reactivex.schedulers.Timed<T> apply(T t) throws java.lang.Exception {
            return new io.reactivex.schedulers.Timed<>(t, this.t.now(this.n), this.n);
        }
    }

    public static final class ToMapKeySelector<K, T> implements io.reactivex.functions.BiConsumer<java.util.Map<K, T>, T> {
        public final io.reactivex.functions.Function<? super T, ? extends K> a;

        public ToMapKeySelector(io.reactivex.functions.Function<? super T, ? extends K> function) {
            this.a = function;
        }

        @Override // io.reactivex.functions.BiConsumer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(java.util.Map<K, T> map, T t) throws java.lang.Exception {
            map.put(this.a.apply(t), t);
        }
    }

    public static final class ToMapKeyValueSelector<K, V, T> implements io.reactivex.functions.BiConsumer<java.util.Map<K, V>, T> {
        public final io.reactivex.functions.Function<? super T, ? extends V> a;
        public final io.reactivex.functions.Function<? super T, ? extends K> b;

        public ToMapKeyValueSelector(io.reactivex.functions.Function<? super T, ? extends V> function, io.reactivex.functions.Function<? super T, ? extends K> function2) {
            this.a = function;
            this.b = function2;
        }

        @Override // io.reactivex.functions.BiConsumer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(java.util.Map<K, V> map, T t) throws java.lang.Exception {
            map.put(this.b.apply(t), this.a.apply(t));
        }
    }

    public static final class ToMultimapKeyValueSelector<K, V, T> implements io.reactivex.functions.BiConsumer<java.util.Map<K, java.util.Collection<V>>, T> {
        public final io.reactivex.functions.Function<? super K, ? extends java.util.Collection<? super V>> a;
        public final io.reactivex.functions.Function<? super T, ? extends V> b;
        public final io.reactivex.functions.Function<? super T, ? extends K> c;

        public ToMultimapKeyValueSelector(io.reactivex.functions.Function<? super K, ? extends java.util.Collection<? super V>> function, io.reactivex.functions.Function<? super T, ? extends V> function2, io.reactivex.functions.Function<? super T, ? extends K> function3) {
            this.a = function;
            this.b = function2;
            this.c = function3;
        }

        @Override // io.reactivex.functions.BiConsumer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(java.util.Map<K, java.util.Collection<V>> map, T t) throws java.lang.Exception {
            K apply = this.c.apply(t);
            java.util.Collection<? super V> collection = (java.util.Collection) map.get(apply);
            if (collection == null) {
                collection = this.a.apply(apply);
                map.put(apply, collection);
            }
            collection.add(this.b.apply(t));
        }
    }

    public static final class TruePredicate implements io.reactivex.functions.Predicate<java.lang.Object> {
        @Override // io.reactivex.functions.Predicate
        public boolean test(java.lang.Object obj) {
            return true;
        }
    }

    public Functions() {
        throw new java.lang.IllegalStateException("No instances!");
    }

    public static <T> io.reactivex.functions.Consumer<T> actionConsumer(io.reactivex.functions.Action action) {
        return new io.reactivex.internal.functions.Functions.ActionConsumer(action);
    }

    public static <T> io.reactivex.functions.Predicate<T> alwaysFalse() {
        return (io.reactivex.functions.Predicate<T>) d;
    }

    public static <T> io.reactivex.functions.Predicate<T> alwaysTrue() {
        return (io.reactivex.functions.Predicate<T>) c;
    }

    public static <T> io.reactivex.functions.Consumer<T> boundedConsumer(int i) {
        return new io.reactivex.internal.functions.Functions.BoundedConsumer(i);
    }

    public static <T, U> io.reactivex.functions.Function<T, U> castFunction(java.lang.Class<U> cls) {
        return new io.reactivex.internal.functions.Functions.CastToClass(cls);
    }

    public static <T> java.util.concurrent.Callable<java.util.List<T>> createArrayList(int i) {
        return new io.reactivex.internal.functions.Functions.ArrayListCapacityCallable(i);
    }

    public static <T> java.util.concurrent.Callable<java.util.Set<T>> createHashSet() {
        return io.reactivex.internal.functions.Functions.HashSetCallable.INSTANCE;
    }

    public static <T> io.reactivex.functions.Consumer<T> emptyConsumer() {
        return (io.reactivex.functions.Consumer<T>) b;
    }

    public static <T> io.reactivex.functions.Predicate<T> equalsWith(T t) {
        return new io.reactivex.internal.functions.Functions.EqualsPredicate(t);
    }

    public static io.reactivex.functions.Action futureAction(java.util.concurrent.Future<?> future) {
        return new io.reactivex.internal.functions.Functions.FutureAction(future);
    }

    public static <T> io.reactivex.functions.Function<T, T> identity() {
        return (io.reactivex.functions.Function<T, T>) a;
    }

    public static <T, U> io.reactivex.functions.Predicate<T> isInstanceOf(java.lang.Class<U> cls) {
        return new io.reactivex.internal.functions.Functions.ClassFilter(cls);
    }

    public static <T> java.util.concurrent.Callable<T> justCallable(T t) {
        return new io.reactivex.internal.functions.Functions.JustValue(t);
    }

    public static <T, U> io.reactivex.functions.Function<T, U> justFunction(U u) {
        return new io.reactivex.internal.functions.Functions.JustValue(u);
    }

    public static <T> io.reactivex.functions.Function<java.util.List<T>, java.util.List<T>> listSorter(java.util.Comparator<? super T> comparator) {
        return new io.reactivex.internal.functions.Functions.ListSorter(comparator);
    }

    public static <T> java.util.Comparator<T> naturalComparator() {
        return io.reactivex.internal.functions.Functions.NaturalComparator.INSTANCE;
    }

    public static <T> java.util.Comparator<T> naturalOrder() {
        return (java.util.Comparator<T>) f;
    }

    public static <T> io.reactivex.functions.Action notificationOnComplete(io.reactivex.functions.Consumer<? super io.reactivex.Notification<T>> consumer) {
        return new io.reactivex.internal.functions.Functions.NotificationOnComplete(consumer);
    }

    public static <T> io.reactivex.functions.Consumer<java.lang.Throwable> notificationOnError(io.reactivex.functions.Consumer<? super io.reactivex.Notification<T>> consumer) {
        return new io.reactivex.internal.functions.Functions.NotificationOnError(consumer);
    }

    public static <T> io.reactivex.functions.Consumer<T> notificationOnNext(io.reactivex.functions.Consumer<? super io.reactivex.Notification<T>> consumer) {
        return new io.reactivex.internal.functions.Functions.NotificationOnNext(consumer);
    }

    public static <T> java.util.concurrent.Callable<T> nullSupplier() {
        return (java.util.concurrent.Callable<T>) e;
    }

    public static <T> io.reactivex.functions.Predicate<T> predicateReverseFor(io.reactivex.functions.BooleanSupplier booleanSupplier) {
        return new io.reactivex.internal.functions.Functions.BooleanSupplierPredicateReverse(booleanSupplier);
    }

    public static <T> io.reactivex.functions.Function<T, io.reactivex.schedulers.Timed<T>> timestampWith(java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler) {
        return new io.reactivex.internal.functions.Functions.TimestampFunction(timeUnit, scheduler);
    }

    public static <T1, T2, R> io.reactivex.functions.Function<java.lang.Object[], R> toFunction(io.reactivex.functions.BiFunction<? super T1, ? super T2, ? extends R> biFunction) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(biFunction, "f is null");
        return new io.reactivex.internal.functions.Functions.Array2Func(biFunction);
    }

    public static <T1, T2, T3, R> io.reactivex.functions.Function<java.lang.Object[], R> toFunction(io.reactivex.functions.Function3<T1, T2, T3, R> function3) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function3, "f is null");
        return new io.reactivex.internal.functions.Functions.Array3Func(function3);
    }

    public static <T1, T2, T3, T4, R> io.reactivex.functions.Function<java.lang.Object[], R> toFunction(io.reactivex.functions.Function4<T1, T2, T3, T4, R> function4) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function4, "f is null");
        return new io.reactivex.internal.functions.Functions.Array4Func(function4);
    }

    public static <T1, T2, T3, T4, T5, R> io.reactivex.functions.Function<java.lang.Object[], R> toFunction(io.reactivex.functions.Function5<T1, T2, T3, T4, T5, R> function5) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function5, "f is null");
        return new io.reactivex.internal.functions.Functions.Array5Func(function5);
    }

    public static <T1, T2, T3, T4, T5, T6, R> io.reactivex.functions.Function<java.lang.Object[], R> toFunction(io.reactivex.functions.Function6<T1, T2, T3, T4, T5, T6, R> function6) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function6, "f is null");
        return new io.reactivex.internal.functions.Functions.Array6Func(function6);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, R> io.reactivex.functions.Function<java.lang.Object[], R> toFunction(io.reactivex.functions.Function7<T1, T2, T3, T4, T5, T6, T7, R> function7) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function7, "f is null");
        return new io.reactivex.internal.functions.Functions.Array7Func(function7);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> io.reactivex.functions.Function<java.lang.Object[], R> toFunction(io.reactivex.functions.Function8<T1, T2, T3, T4, T5, T6, T7, T8, R> function8) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function8, "f is null");
        return new io.reactivex.internal.functions.Functions.Array8Func(function8);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> io.reactivex.functions.Function<java.lang.Object[], R> toFunction(io.reactivex.functions.Function9<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> function9) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function9, "f is null");
        return new io.reactivex.internal.functions.Functions.Array9Func(function9);
    }

    public static <T, K> io.reactivex.functions.BiConsumer<java.util.Map<K, T>, T> toMapKeySelector(io.reactivex.functions.Function<? super T, ? extends K> function) {
        return new io.reactivex.internal.functions.Functions.ToMapKeySelector(function);
    }

    public static <T, K, V> io.reactivex.functions.BiConsumer<java.util.Map<K, V>, T> toMapKeyValueSelector(io.reactivex.functions.Function<? super T, ? extends K> function, io.reactivex.functions.Function<? super T, ? extends V> function2) {
        return new io.reactivex.internal.functions.Functions.ToMapKeyValueSelector(function2, function);
    }

    public static <T, K, V> io.reactivex.functions.BiConsumer<java.util.Map<K, java.util.Collection<V>>, T> toMultimapKeyValueSelector(io.reactivex.functions.Function<? super T, ? extends K> function, io.reactivex.functions.Function<? super T, ? extends V> function2, io.reactivex.functions.Function<? super K, ? extends java.util.Collection<? super V>> function3) {
        return new io.reactivex.internal.functions.Functions.ToMultimapKeyValueSelector(function3, function2, function);
    }
}
