package kotlinx.coroutines.debug.internal;

@kotlin.Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\b\u0003\n\u0002\u0010'\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u00012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004:\u0003()*B\u0011\u0012\b\b\u0002\u0010\u0019\u001a\u00020%¢\u0006\u0004\b&\u0010'J\u001a\u0010\u0006\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0005\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\u0006\u0010\u0007J!\u0010\t\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0005\u001a\u00028\u00002\u0006\u0010\b\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\u000b\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0005\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u000b\u0010\u0007J\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0010\u0010\u000eJ#\u0010\u0011\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0005\u001a\u00028\u00002\b\u0010\b\u001a\u0004\u0018\u00018\u0001H\u0002¢\u0006\u0004\b\u0011\u0010\nJ\u001b\u0010\u0014\u001a\u00020\f2\n\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0019\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001d\u001a\u00020\u001a8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000\u001e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R&\u0010$\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\"0\u001e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b#\u0010 ¨\u0006+"}, d2 = {"Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap;", "", "K", androidx.exifinterface.media.ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lkotlin/collections/AbstractMutableMap;", "key", com.ss.android.socialbase.downloader.constants.MonitorConstants.CONNECT_TYPE_GET, "(Ljava/lang/Object;)Ljava/lang/Object;", "value", "put", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "remove", "", "clear", "()V", "runWeakRefQueueCleaningLoopUntilInterrupted", "b", "d", "Lkotlinx/coroutines/debug/internal/HashedWeakRef;", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.WIDTH, "a", "(Lkotlinx/coroutines/debug/internal/HashedWeakRef;)V", "Ljava/lang/ref/ReferenceQueue;", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.AD_COUNT, "Ljava/lang/ref/ReferenceQueue;", "weakRefQueue", "", "getSize", "()I", com.anythink.core.api.ATAdConst.NETWORK_REQUEST_PARAMS_KEY.BANNER_SIZE, "", "getKeys", "()Ljava/util/Set;", "keys", "", "getEntries", "entries", "", "<init>", "(Z)V", "Core", "Entry", "KeyValueSet", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes16.dex */
public final class ConcurrentWeakMap<K, V> extends kotlin.collections.AbstractMutableMap<K, V> {
    public static final /* synthetic */ java.util.concurrent.atomic.AtomicIntegerFieldUpdater t = java.util.concurrent.atomic.AtomicIntegerFieldUpdater.newUpdater(kotlinx.coroutines.debug.internal.ConcurrentWeakMap.class, "_size");

    @org.jetbrains.annotations.NotNull
    private volatile /* synthetic */ int _size;

    @org.jetbrains.annotations.NotNull
    volatile /* synthetic */ java.lang.Object core;

    /* renamed from: n, reason: from kotlin metadata */
    @org.jetbrains.annotations.Nullable
    public final java.lang.ref.ReferenceQueue<K> weakRefQueue;

    @kotlin.Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010)\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\b\u0082\u0004\u0018\u00002\u00020\u0001:\u0001%B\u000f\u0012\u0006\u0010 \u001a\u00020\u0017¢\u0006\u0004\b#\u0010$J\u0017\u0010\u0003\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0002\u001a\u00028\u0000¢\u0006\u0004\b\u0003\u0010\u0004J3\u0010\b\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00028\u00002\b\u0010\u0005\u001a\u0004\u0018\u00018\u00012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\u000b\u001a\u00120\u0000R\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\n¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u000f\u001a\u00020\u000e2\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\u0006¢\u0006\u0004\b\u000f\u0010\u0010J3\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00020\u0014\"\u0004\b\u0002\u0010\u00112\u0018\u0010\u0013\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0012¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u001c\u0010\u001dR\u0014\u0010 \u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010!\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u001fR\u0014\u0010\"\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001f¨\u0006&"}, d2 = {"Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap$Core;", "", "key", "c", "(Ljava/lang/Object;)Ljava/lang/Object;", "value", "Lkotlinx/coroutines/debug/internal/HashedWeakRef;", "weakKey0", "f", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlinx/coroutines/debug/internal/HashedWeakRef;)Ljava/lang/Object;", "Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap;", "h", "()Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap$Core;", "weakRef", "", "b", "(Lkotlinx/coroutines/debug/internal/HashedWeakRef;)V", androidx.exifinterface.media.ExifInterface.LONGITUDE_EAST, "Lkotlin/Function2;", "factory", "", "e", "(Lkotlin/jvm/functions/Function2;)Ljava/util/Iterator;", "", "hash", "d", "(I)I", "index", "i", "(I)V", "a", "I", "allocated", "shift", "threshold", "<init>", "(Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap;I)V", "KeyValueIterator", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1})
    public final class Core {
        public static final /* synthetic */ java.util.concurrent.atomic.AtomicIntegerFieldUpdater g = java.util.concurrent.atomic.AtomicIntegerFieldUpdater.newUpdater(kotlinx.coroutines.debug.internal.ConcurrentWeakMap.Core.class, "load");

        /* renamed from: a, reason: from kotlin metadata */
        public final int allocated;

        /* renamed from: b, reason: from kotlin metadata */
        public final int shift;

        /* renamed from: c, reason: from kotlin metadata */
        public final int threshold;

        @org.jetbrains.annotations.NotNull
        public /* synthetic */ java.util.concurrent.atomic.AtomicReferenceArray d;

        @org.jetbrains.annotations.NotNull
        public /* synthetic */ java.util.concurrent.atomic.AtomicReferenceArray e;

        @org.jetbrains.annotations.NotNull
        private volatile /* synthetic */ int load = 0;

        @kotlin.Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010)\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\b\u0082\u0004\u0018\u0000*\u0004\b\u0002\u0010\u00012\b\u0012\u0004\u0012\u00028\u00020\u0002B!\u0012\u0018\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u000b¢\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u0004\u001a\u00020\u0003H\u0096\u0002J\u0010\u0010\u0005\u001a\u00028\u0002H\u0096\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\tH\u0002R&\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0015\u001a\u00028\u00008\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0017\u001a\u00028\u00018\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0016\u0010\u0014¨\u0006\u001a"}, d2 = {"Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap$Core$KeyValueIterator;", androidx.exifinterface.media.ExifInterface.LONGITUDE_EAST, "", "", "hasNext", "next", "()Ljava/lang/Object;", "", "b", "", "a", "Lkotlin/Function2;", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.AD_COUNT, "Lkotlin/jvm/functions/Function2;", "factory", "", "t", "I", "index", com.umeng.analytics.pro.bo.aN, "Ljava/lang/Object;", "key", "v", "value", "<init>", "(Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap$Core;Lkotlin/jvm/functions/Function2;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1})
        public final class KeyValueIterator<E> implements java.util.Iterator<E>, kotlin.jvm.internal.markers.KMutableIterator {

            /* renamed from: n, reason: from kotlin metadata */
            @org.jetbrains.annotations.NotNull
            public final kotlin.jvm.functions.Function2<K, V, E> factory;

            /* renamed from: t, reason: from kotlin metadata */
            public int index = -1;

            /* renamed from: u, reason: from kotlin metadata */
            public K key;

            /* renamed from: v, reason: from kotlin metadata */
            public V value;

            /* JADX WARN: Multi-variable type inference failed */
            public KeyValueIterator(@org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super K, ? super V, ? extends E> function2) {
                this.factory = function2;
                a();
            }

            public final void a() {
                while (true) {
                    int i = this.index + 1;
                    this.index = i;
                    if (i >= kotlinx.coroutines.debug.internal.ConcurrentWeakMap.Core.this.allocated) {
                        return;
                    }
                    kotlinx.coroutines.debug.internal.HashedWeakRef hashedWeakRef = (kotlinx.coroutines.debug.internal.HashedWeakRef) kotlinx.coroutines.debug.internal.ConcurrentWeakMap.Core.this.d.get(this.index);
                    K k = hashedWeakRef == null ? null : (K) hashedWeakRef.get();
                    if (k != null) {
                        this.key = k;
                        java.lang.Object obj = (V) kotlinx.coroutines.debug.internal.ConcurrentWeakMap.Core.this.e.get(this.index);
                        if (obj instanceof kotlinx.coroutines.debug.internal.Marked) {
                            obj = (V) ((kotlinx.coroutines.debug.internal.Marked) obj).ref;
                        }
                        if (obj != null) {
                            this.value = (V) obj;
                            return;
                        }
                    }
                }
            }

            @Override // java.util.Iterator
            @org.jetbrains.annotations.NotNull
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public java.lang.Void remove() {
                kotlinx.coroutines.debug.internal.ConcurrentWeakMapKt.b();
                throw new kotlin.KotlinNothingValueException();
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < kotlinx.coroutines.debug.internal.ConcurrentWeakMap.Core.this.allocated;
            }

            @Override // java.util.Iterator
            public E next() {
                if (this.index >= kotlinx.coroutines.debug.internal.ConcurrentWeakMap.Core.this.allocated) {
                    throw new java.util.NoSuchElementException();
                }
                kotlin.jvm.functions.Function2<K, V, E> function2 = this.factory;
                K k = this.key;
                if (k == null) {
                    kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("key");
                    throw null;
                }
                V v = this.value;
                if (v == null) {
                    kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("value");
                    throw null;
                }
                E mo5invoke = function2.mo5invoke(k, v);
                a();
                return mo5invoke;
            }
        }

        public Core(int i) {
            this.allocated = i;
            this.shift = java.lang.Integer.numberOfLeadingZeros(i) + 1;
            this.threshold = (i * 2) / 3;
            this.d = new java.util.concurrent.atomic.AtomicReferenceArray(i);
            this.e = new java.util.concurrent.atomic.AtomicReferenceArray(i);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ java.lang.Object g(kotlinx.coroutines.debug.internal.ConcurrentWeakMap.Core core, java.lang.Object obj, java.lang.Object obj2, kotlinx.coroutines.debug.internal.HashedWeakRef hashedWeakRef, int i, java.lang.Object obj3) {
            if ((i & 4) != 0) {
                hashedWeakRef = null;
            }
            return core.f(obj, obj2, hashedWeakRef);
        }

        public final void b(@org.jetbrains.annotations.NotNull kotlinx.coroutines.debug.internal.HashedWeakRef<?> weakRef) {
            int d = d(weakRef.hash);
            while (true) {
                kotlinx.coroutines.debug.internal.HashedWeakRef<?> hashedWeakRef = (kotlinx.coroutines.debug.internal.HashedWeakRef) this.d.get(d);
                if (hashedWeakRef == null) {
                    return;
                }
                if (hashedWeakRef == weakRef) {
                    i(d);
                    return;
                } else {
                    if (d == 0) {
                        d = this.allocated;
                    }
                    d--;
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @org.jetbrains.annotations.Nullable
        public final V c(@org.jetbrains.annotations.NotNull K key) {
            int d = d(key.hashCode());
            while (true) {
                kotlinx.coroutines.debug.internal.HashedWeakRef hashedWeakRef = (kotlinx.coroutines.debug.internal.HashedWeakRef) this.d.get(d);
                if (hashedWeakRef == null) {
                    return null;
                }
                T t = hashedWeakRef.get();
                if (kotlin.jvm.internal.Intrinsics.areEqual(key, t)) {
                    V v = (V) this.e.get(d);
                    return v instanceof kotlinx.coroutines.debug.internal.Marked ? (V) ((kotlinx.coroutines.debug.internal.Marked) v).ref : v;
                }
                if (t == 0) {
                    i(d);
                }
                if (d == 0) {
                    d = this.allocated;
                }
                d--;
            }
        }

        public final int d(int hash) {
            return (hash * (-1640531527)) >>> this.shift;
        }

        @org.jetbrains.annotations.NotNull
        public final <E> java.util.Iterator<E> e(@org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super K, ? super V, ? extends E> factory) {
            return new kotlinx.coroutines.debug.internal.ConcurrentWeakMap.Core.KeyValueIterator(factory);
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x0056, code lost:
        
            r6 = r5.e.get(r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x005e, code lost:
        
            if ((r6 instanceof kotlinx.coroutines.debug.internal.Marked) == false) goto L29;
         */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x006b, code lost:
        
            if (defpackage.es2.a(r5.e, r0, r6, r7) == false) goto L49;
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x006d, code lost:
        
            return r6;
         */
        /* JADX WARN: Code restructure failed: missing block: B:27:0x0060, code lost:
        
            r6 = kotlinx.coroutines.debug.internal.ConcurrentWeakMapKt.a;
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x0064, code lost:
        
            return r6;
         */
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final java.lang.Object f(@org.jetbrains.annotations.NotNull K key, @org.jetbrains.annotations.Nullable V value, @org.jetbrains.annotations.Nullable kotlinx.coroutines.debug.internal.HashedWeakRef<K> weakKey0) {
            int i;
            kotlinx.coroutines.internal.Symbol symbol;
            int d = d(key.hashCode());
            boolean z = false;
            while (true) {
                kotlinx.coroutines.debug.internal.HashedWeakRef hashedWeakRef = (kotlinx.coroutines.debug.internal.HashedWeakRef) this.d.get(d);
                if (hashedWeakRef != null) {
                    T t = hashedWeakRef.get();
                    if (!kotlin.jvm.internal.Intrinsics.areEqual(key, t)) {
                        if (t == 0) {
                            i(d);
                        }
                        if (d == 0) {
                            d = this.allocated;
                        }
                        d--;
                    } else if (z) {
                        g.decrementAndGet(this);
                    }
                } else {
                    if (value == null) {
                        return null;
                    }
                    if (!z) {
                        do {
                            i = this.load;
                            if (i >= this.threshold) {
                                symbol = kotlinx.coroutines.debug.internal.ConcurrentWeakMapKt.a;
                                return symbol;
                            }
                        } while (!g.compareAndSet(this, i, i + 1));
                        z = true;
                    }
                    if (weakKey0 == null) {
                        weakKey0 = new kotlinx.coroutines.debug.internal.HashedWeakRef<>(key, kotlinx.coroutines.debug.internal.ConcurrentWeakMap.this.weakRefQueue);
                    }
                    if (defpackage.es2.a(this.d, d, null, weakKey0)) {
                        break;
                    }
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @org.jetbrains.annotations.NotNull
        public final kotlinx.coroutines.debug.internal.ConcurrentWeakMap<K, V>.Core h() {
            int coerceAtLeast;
            kotlinx.coroutines.debug.internal.ConcurrentWeakMap<K, V>.Core core;
            java.lang.Object obj;
            kotlinx.coroutines.internal.Symbol symbol;
            kotlinx.coroutines.debug.internal.Marked a;
            loop0: while (true) {
                coerceAtLeast = kotlin.ranges.RangesKt___RangesKt.coerceAtLeast(kotlinx.coroutines.debug.internal.ConcurrentWeakMap.this.size(), 4);
                core = (kotlinx.coroutines.debug.internal.ConcurrentWeakMap<K, V>.Core) kotlinx.coroutines.debug.internal.ConcurrentWeakMap.this.new Core(java.lang.Integer.highestOneBit(coerceAtLeast) * 4);
                int i = this.allocated;
                if (i <= 0) {
                    break;
                }
                int i2 = 0;
                while (true) {
                    int i3 = i2 + 1;
                    kotlinx.coroutines.debug.internal.HashedWeakRef hashedWeakRef = (kotlinx.coroutines.debug.internal.HashedWeakRef) this.d.get(i2);
                    java.lang.Object obj2 = hashedWeakRef == null ? null : hashedWeakRef.get();
                    if (hashedWeakRef != null && obj2 == null) {
                        i(i2);
                    }
                    while (true) {
                        obj = this.e.get(i2);
                        if (obj instanceof kotlinx.coroutines.debug.internal.Marked) {
                            obj = ((kotlinx.coroutines.debug.internal.Marked) obj).ref;
                            break;
                        }
                        java.util.concurrent.atomic.AtomicReferenceArray atomicReferenceArray = this.e;
                        a = kotlinx.coroutines.debug.internal.ConcurrentWeakMapKt.a(obj);
                        if (defpackage.es2.a(atomicReferenceArray, i2, obj, a)) {
                            break;
                        }
                    }
                    if (obj2 != null && obj != null) {
                        java.lang.Object f = core.f(obj2, obj, hashedWeakRef);
                        symbol = kotlinx.coroutines.debug.internal.ConcurrentWeakMapKt.a;
                        if (f == symbol) {
                            break;
                        }
                    }
                    if (i3 >= i) {
                        break loop0;
                    }
                    i2 = i3;
                }
            }
            return core;
        }

        public final void i(int index) {
            java.lang.Object obj;
            do {
                obj = this.e.get(index);
                if (obj == null || (obj instanceof kotlinx.coroutines.debug.internal.Marked)) {
                    return;
                }
            } while (!defpackage.es2.a(this.e, index, obj, null));
            kotlinx.coroutines.debug.internal.ConcurrentWeakMap.this.b();
        }
    }

    @kotlin.Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010'\n\u0002\b\u000e\b\u0002\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0003B\u0017\u0012\u0006\u0010\u000b\u001a\u00028\u0002\u0012\u0006\u0010\u000e\u001a\u00028\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0005\u001a\u00028\u00032\u0006\u0010\u0004\u001a\u00028\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u001a\u0010\u000b\u001a\u00028\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000e\u001a\u00028\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\f\u0010\b\u001a\u0004\b\r\u0010\n¨\u0006\u0011"}, d2 = {"Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap$Entry;", "K", androidx.exifinterface.media.ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "newValue", "setValue", "(Ljava/lang/Object;)Ljava/lang/Object;", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.AD_COUNT, "Ljava/lang/Object;", "getKey", "()Ljava/lang/Object;", "key", "t", "getValue", "value", "<init>", "(Ljava/lang/Object;Ljava/lang/Object;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1})
    public static final class Entry<K, V> implements java.util.Map.Entry<K, V>, kotlin.jvm.internal.markers.KMutableMap.Entry {

        /* renamed from: n, reason: from kotlin metadata */
        public final K key;

        /* renamed from: t, reason: from kotlin metadata */
        public final V value;

        public Entry(K k, V v) {
            this.key = k;
            this.value = v;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.key;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.value;
        }

        @Override // java.util.Map.Entry
        public V setValue(V newValue) {
            kotlinx.coroutines.debug.internal.ConcurrentWeakMapKt.b();
            throw new kotlin.KotlinNothingValueException();
        }
    }

    @kotlin.Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010)\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\b\u0082\u0004\u0018\u0000*\u0004\b\u0002\u0010\u00012\b\u0012\u0004\u0012\u00028\u00020\u0002B!\u0012\u0018\u0010\f\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\t¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00020\u0007H\u0096\u0002R&\u0010\f\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap$KeyValueSet;", androidx.exifinterface.media.ExifInterface.LONGITUDE_EAST, "Lkotlin/collections/AbstractMutableSet;", "element", "", com.anythink.expressad.d.a.b.ay, "(Ljava/lang/Object;)Z", "", "iterator", "Lkotlin/Function2;", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.AD_COUNT, "Lkotlin/jvm/functions/Function2;", "factory", "", "getSize", "()I", com.anythink.core.api.ATAdConst.NETWORK_REQUEST_PARAMS_KEY.BANNER_SIZE, "<init>", "(Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap;Lkotlin/jvm/functions/Function2;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1})
    public final class KeyValueSet<E> extends kotlin.collections.AbstractMutableSet<E> {

        /* renamed from: n, reason: from kotlin metadata */
        @org.jetbrains.annotations.NotNull
        public final kotlin.jvm.functions.Function2<K, V, E> factory;

        /* JADX WARN: Multi-variable type inference failed */
        public KeyValueSet(@org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super K, ? super V, ? extends E> function2) {
            this.factory = function2;
        }

        @Override // kotlin.collections.AbstractMutableSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean add(E element) {
            kotlinx.coroutines.debug.internal.ConcurrentWeakMapKt.b();
            throw new kotlin.KotlinNothingValueException();
        }

        @Override // kotlin.collections.AbstractMutableSet
        public int getSize() {
            return kotlinx.coroutines.debug.internal.ConcurrentWeakMap.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        @org.jetbrains.annotations.NotNull
        public java.util.Iterator<E> iterator() {
            return ((kotlinx.coroutines.debug.internal.ConcurrentWeakMap.Core) kotlinx.coroutines.debug.internal.ConcurrentWeakMap.this.core).e(this.factory);
        }
    }

    public ConcurrentWeakMap() {
        this(false, 1, null);
    }

    public ConcurrentWeakMap(boolean z) {
        this._size = 0;
        this.core = new kotlinx.coroutines.debug.internal.ConcurrentWeakMap.Core(16);
        this.weakRefQueue = z ? new java.lang.ref.ReferenceQueue<>() : null;
    }

    public /* synthetic */ ConcurrentWeakMap(boolean z, int i, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z);
    }

    public final void a(kotlinx.coroutines.debug.internal.HashedWeakRef<?> w) {
        ((kotlinx.coroutines.debug.internal.ConcurrentWeakMap.Core) this.core).b(w);
    }

    public final void b() {
        t.decrementAndGet(this);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        java.util.Iterator<K> it = keySet().iterator();
        while (it.hasNext()) {
            remove(it.next());
        }
    }

    public final synchronized V d(K key, V value) {
        V v;
        kotlinx.coroutines.internal.Symbol symbol;
        kotlinx.coroutines.debug.internal.ConcurrentWeakMap.Core core = (kotlinx.coroutines.debug.internal.ConcurrentWeakMap.Core) this.core;
        while (true) {
            v = (V) kotlinx.coroutines.debug.internal.ConcurrentWeakMap.Core.g(core, key, value, null, 4, null);
            symbol = kotlinx.coroutines.debug.internal.ConcurrentWeakMapKt.a;
            if (v == symbol) {
                core = core.h();
                this.core = core;
            }
        }
        return v;
    }

    @Override // java.util.AbstractMap, java.util.Map
    @org.jetbrains.annotations.Nullable
    public V get(@org.jetbrains.annotations.Nullable java.lang.Object key) {
        if (key == null) {
            return null;
        }
        return (V) ((kotlinx.coroutines.debug.internal.ConcurrentWeakMap.Core) this.core).c(key);
    }

    @Override // kotlin.collections.AbstractMutableMap
    @org.jetbrains.annotations.NotNull
    public java.util.Set<java.util.Map.Entry<K, V>> getEntries() {
        return new kotlinx.coroutines.debug.internal.ConcurrentWeakMap.KeyValueSet(kotlinx.coroutines.debug.internal.ConcurrentWeakMap$entries$1.INSTANCE);
    }

    @Override // kotlin.collections.AbstractMutableMap
    @org.jetbrains.annotations.NotNull
    public java.util.Set<K> getKeys() {
        return new kotlinx.coroutines.debug.internal.ConcurrentWeakMap.KeyValueSet(kotlinx.coroutines.debug.internal.ConcurrentWeakMap$keys$1.INSTANCE);
    }

    @Override // kotlin.collections.AbstractMutableMap
    /* renamed from: getSize, reason: from getter */
    public int get_size() {
        return this._size;
    }

    @Override // kotlin.collections.AbstractMutableMap, java.util.AbstractMap, java.util.Map
    @org.jetbrains.annotations.Nullable
    public V put(@org.jetbrains.annotations.NotNull K key, @org.jetbrains.annotations.NotNull V value) {
        kotlinx.coroutines.internal.Symbol symbol;
        V v = (V) kotlinx.coroutines.debug.internal.ConcurrentWeakMap.Core.g((kotlinx.coroutines.debug.internal.ConcurrentWeakMap.Core) this.core, key, value, null, 4, null);
        symbol = kotlinx.coroutines.debug.internal.ConcurrentWeakMapKt.a;
        if (v == symbol) {
            v = d(key, value);
        }
        if (v == null) {
            t.incrementAndGet(this);
        }
        return v;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    @org.jetbrains.annotations.Nullable
    public V remove(@org.jetbrains.annotations.Nullable java.lang.Object key) {
        kotlinx.coroutines.internal.Symbol symbol;
        if (key == 0) {
            return null;
        }
        V v = (V) kotlinx.coroutines.debug.internal.ConcurrentWeakMap.Core.g((kotlinx.coroutines.debug.internal.ConcurrentWeakMap.Core) this.core, key, null, null, 4, null);
        symbol = kotlinx.coroutines.debug.internal.ConcurrentWeakMapKt.a;
        if (v == symbol) {
            v = d(key, null);
        }
        if (v != null) {
            t.decrementAndGet(this);
        }
        return v;
    }

    public final void runWeakRefQueueCleaningLoopUntilInterrupted() {
        if (!(this.weakRefQueue != null)) {
            throw new java.lang.IllegalStateException("Must be created with weakRefQueue = true".toString());
        }
        while (true) {
            try {
                java.lang.ref.Reference<? extends K> remove = this.weakRefQueue.remove();
                if (remove == null) {
                    throw new java.lang.NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.debug.internal.HashedWeakRef<*>");
                }
                a((kotlinx.coroutines.debug.internal.HashedWeakRef) remove);
            } catch (java.lang.InterruptedException unused) {
                java.lang.Thread.currentThread().interrupt();
                return;
            }
        }
    }
}
