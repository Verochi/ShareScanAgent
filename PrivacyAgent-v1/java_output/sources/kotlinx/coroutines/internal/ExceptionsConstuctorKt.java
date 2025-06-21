package kotlinx.coroutines.internal;

@kotlin.Metadata(d1 = {"\u00004\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a#\u0010\u0003\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00028\u0000H\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a*\u0010\t\u001a\u0018\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u0000\u0018\u00010\u0007j\u0004\u0018\u0001`\b2\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0005H\u0002\u001a\u0018\u0010\r\u001a\u00020\u000b*\u0006\u0012\u0002\b\u00030\n2\u0006\u0010\f\u001a\u00020\u000bH\u0002\u001a\u001b\u0010\u000f\u001a\u00020\u000b*\u0006\u0012\u0002\b\u00030\n2\b\b\u0002\u0010\u000e\u001a\u00020\u000bH\u0082\u0010\"\u0014\u0010\u0011\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0010\"\u0014\u0010\u0014\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0013\":\u0010\u0018\u001a(\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00000\n\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u0007j\u0002`\b0\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017*(\b\u0002\u0010\u0019\"\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u00072\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u0007¨\u0006\u001a"}, d2 = {"", androidx.exifinterface.media.ExifInterface.LONGITUDE_EAST, "exception", "tryCopyException", "(Ljava/lang/Throwable;)Ljava/lang/Throwable;", "Ljava/lang/reflect/Constructor;", "constructor", "Lkotlin/Function1;", "Lkotlinx/coroutines/internal/Ctor;", "a", "Ljava/lang/Class;", "", "defaultValue", "d", "accumulator", "b", "I", "throwableFields", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "cacheLock", "Ljava/util/WeakHashMap;", "c", "Ljava/util/WeakHashMap;", "exceptionCtors", "Ctor", "kotlinx-coroutines-core"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes16.dex */
public final class ExceptionsConstuctorKt {
    public static final int a = d(java.lang.Throwable.class, -1);

    @org.jetbrains.annotations.NotNull
    public static final java.util.concurrent.locks.ReentrantReadWriteLock b = new java.util.concurrent.locks.ReentrantReadWriteLock();

    @org.jetbrains.annotations.NotNull
    public static final java.util.WeakHashMap<java.lang.Class<? extends java.lang.Throwable>, kotlin.jvm.functions.Function1<java.lang.Throwable, java.lang.Throwable>> c = new java.util.WeakHashMap<>();

    public static final kotlin.jvm.functions.Function1<java.lang.Throwable, java.lang.Throwable> a(java.lang.reflect.Constructor<?> constructor) {
        java.lang.Class<?>[] parameterTypes = constructor.getParameterTypes();
        int length = parameterTypes.length;
        if (length == 0) {
            return new kotlinx.coroutines.internal.ExceptionsConstuctorKt$createConstructor$$inlined$safeCtor$4(constructor);
        }
        if (length != 1) {
            if (length == 2 && kotlin.jvm.internal.Intrinsics.areEqual(parameterTypes[0], java.lang.String.class) && kotlin.jvm.internal.Intrinsics.areEqual(parameterTypes[1], java.lang.Throwable.class)) {
                return new kotlinx.coroutines.internal.ExceptionsConstuctorKt$createConstructor$$inlined$safeCtor$1(constructor);
            }
            return null;
        }
        java.lang.Class<?> cls = parameterTypes[0];
        if (kotlin.jvm.internal.Intrinsics.areEqual(cls, java.lang.Throwable.class)) {
            return new kotlinx.coroutines.internal.ExceptionsConstuctorKt$createConstructor$$inlined$safeCtor$2(constructor);
        }
        if (kotlin.jvm.internal.Intrinsics.areEqual(cls, java.lang.String.class)) {
            return new kotlinx.coroutines.internal.ExceptionsConstuctorKt$createConstructor$$inlined$safeCtor$3(constructor);
        }
        return null;
    }

    public static final int b(java.lang.Class<?> cls, int i) {
        do {
            int length = cls.getDeclaredFields().length;
            int i2 = 0;
            for (int i3 = 0; i3 < length; i3++) {
                if (!java.lang.reflect.Modifier.isStatic(r0[i3].getModifiers())) {
                    i2++;
                }
            }
            i += i2;
            cls = cls.getSuperclass();
        } while (cls != null);
        return i;
    }

    public static /* synthetic */ int c(java.lang.Class cls, int i, int i2, java.lang.Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        return b(cls, i);
    }

    public static final int d(java.lang.Class<?> cls, int i) {
        java.lang.Object m156constructorimpl;
        kotlin.jvm.JvmClassMappingKt.getKotlinClass(cls);
        try {
            kotlin.Result.Companion companion = kotlin.Result.INSTANCE;
            m156constructorimpl = kotlin.Result.m156constructorimpl(java.lang.Integer.valueOf(c(cls, 0, 1, null)));
        } catch (java.lang.Throwable th) {
            kotlin.Result.Companion companion2 = kotlin.Result.INSTANCE;
            m156constructorimpl = kotlin.Result.m156constructorimpl(kotlin.ResultKt.createFailure(th));
        }
        java.lang.Integer valueOf = java.lang.Integer.valueOf(i);
        if (kotlin.Result.m162isFailureimpl(m156constructorimpl)) {
            m156constructorimpl = valueOf;
        }
        return ((java.lang.Number) m156constructorimpl).intValue();
    }

    @org.jetbrains.annotations.Nullable
    public static final <E extends java.lang.Throwable> E tryCopyException(@org.jetbrains.annotations.NotNull E e) {
        java.lang.Object m156constructorimpl;
        java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock readLock;
        int readHoldCount;
        java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock writeLock;
        if (e instanceof kotlinx.coroutines.CopyableThrowable) {
            try {
                kotlin.Result.Companion companion = kotlin.Result.INSTANCE;
                m156constructorimpl = kotlin.Result.m156constructorimpl(((kotlinx.coroutines.CopyableThrowable) e).createCopy());
            } catch (java.lang.Throwable th) {
                kotlin.Result.Companion companion2 = kotlin.Result.INSTANCE;
                m156constructorimpl = kotlin.Result.m156constructorimpl(kotlin.ResultKt.createFailure(th));
            }
            return (E) (kotlin.Result.m162isFailureimpl(m156constructorimpl) ? null : m156constructorimpl);
        }
        java.util.concurrent.locks.ReentrantReadWriteLock reentrantReadWriteLock = b;
        java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock readLock2 = reentrantReadWriteLock.readLock();
        readLock2.lock();
        try {
            kotlin.jvm.functions.Function1<java.lang.Throwable, java.lang.Throwable> function1 = c.get(e.getClass());
            if (function1 != null) {
                return (E) function1.invoke(e);
            }
            int i = 0;
            if (a != d(e.getClass(), 0)) {
                readLock = reentrantReadWriteLock.readLock();
                readHoldCount = reentrantReadWriteLock.getWriteHoldCount() == 0 ? reentrantReadWriteLock.getReadHoldCount() : 0;
                for (int i2 = 0; i2 < readHoldCount; i2++) {
                    readLock.unlock();
                }
                writeLock = reentrantReadWriteLock.writeLock();
                writeLock.lock();
                try {
                    c.put(e.getClass(), kotlinx.coroutines.internal.ExceptionsConstuctorKt$tryCopyException$4$1.INSTANCE);
                    kotlin.Unit unit = kotlin.Unit.INSTANCE;
                    return null;
                } finally {
                    while (i < readHoldCount) {
                        readLock.lock();
                        i++;
                    }
                    writeLock.unlock();
                }
            }
            java.util.Iterator it = kotlin.collections.ArraysKt___ArraysKt.sortedWith(e.getClass().getConstructors(), new kotlinx.coroutines.internal.ExceptionsConstuctorKt$tryCopyException$$inlined$sortedByDescending$1()).iterator();
            kotlin.jvm.functions.Function1<java.lang.Throwable, java.lang.Throwable> function12 = null;
            while (it.hasNext() && (function12 = a((java.lang.reflect.Constructor) it.next())) == null) {
            }
            java.util.concurrent.locks.ReentrantReadWriteLock reentrantReadWriteLock2 = b;
            readLock = reentrantReadWriteLock2.readLock();
            readHoldCount = reentrantReadWriteLock2.getWriteHoldCount() == 0 ? reentrantReadWriteLock2.getReadHoldCount() : 0;
            for (int i3 = 0; i3 < readHoldCount; i3++) {
                readLock.unlock();
            }
            writeLock = reentrantReadWriteLock2.writeLock();
            writeLock.lock();
            try {
                c.put(e.getClass(), function12 == null ? kotlinx.coroutines.internal.ExceptionsConstuctorKt$tryCopyException$5$1.INSTANCE : function12);
                kotlin.Unit unit2 = kotlin.Unit.INSTANCE;
                while (i < readHoldCount) {
                    readLock.lock();
                    i++;
                }
                writeLock.unlock();
                if (function12 == null) {
                    return null;
                }
                return (E) function12.invoke(e);
            } finally {
                while (i < readHoldCount) {
                    readLock.lock();
                    i++;
                }
                writeLock.unlock();
            }
        } finally {
            readLock2.unlock();
        }
    }
}
