package kotlin.collections;

@kotlin.SinceKotlin(version = "1.4")
@kotlin.Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0010\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b!\b\u0007\u0018\u0000 R*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002:\u0001RB\u0011\b\u0016\u0012\u0006\u0010M\u001a\u00020\u0015¢\u0006\u0004\bN\u0010OB\t\b\u0016¢\u0006\u0004\bN\u0010PB\u0017\b\u0016\u0012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018¢\u0006\u0004\bN\u0010QJ\b\u0010\u0004\u001a\u00020\u0003H\u0016J\r\u0010\u0005\u001a\u00028\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u0007\u0010\u0006J\r\u0010\b\u001a\u00028\u0000¢\u0006\u0004\b\b\u0010\u0006J\u000f\u0010\t\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\t\u0010\u0006J\u0015\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00028\u0000¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00028\u0000¢\u0006\u0004\b\u000e\u0010\rJ\r\u0010\u000f\u001a\u00028\u0000¢\u0006\u0004\b\u000f\u0010\u0006J\u000f\u0010\u0010\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u0010\u0010\u0006J\r\u0010\u0011\u001a\u00028\u0000¢\u0006\u0004\b\u0011\u0010\u0006J\u000f\u0010\u0012\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u0012\u0010\u0006J\u0017\u0010\u0013\u001a\u00020\u00032\u0006\u0010\n\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\n\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0013\u0010\u0017J\u0016\u0010\u001a\u001a\u00020\u00032\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018H\u0016J\u001e\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00152\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018H\u0016J\u0018\u0010\u001b\u001a\u00028\u00002\u0006\u0010\u0016\u001a\u00020\u0015H\u0096\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ \u0010\u001d\u001a\u00028\u00002\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\n\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0018\u0010\u001f\u001a\u00020\u00032\u0006\u0010\n\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\u001f\u0010\u0014J\u0017\u0010 \u001a\u00020\u00152\u0006\u0010\n\u001a\u00028\u0000H\u0016¢\u0006\u0004\b \u0010!J\u0017\u0010\"\u001a\u00020\u00152\u0006\u0010\n\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\"\u0010!J\u0017\u0010#\u001a\u00020\u00032\u0006\u0010\n\u001a\u00028\u0000H\u0016¢\u0006\u0004\b#\u0010\u0014J\u0017\u0010$\u001a\u00028\u00002\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b$\u0010\u001cJ\u0016\u0010%\u001a\u00020\u00032\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018H\u0016J\u0016\u0010&\u001a\u00020\u00032\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018H\u0016J\b\u0010'\u001a\u00020\u000bH\u0016J)\u0010+\u001a\b\u0012\u0004\u0012\u00028\u00010)\"\u0004\b\u0001\u0010(2\f\u0010*\u001a\b\u0012\u0004\u0012\u00028\u00010)H\u0016¢\u0006\u0004\b+\u0010,J\u0017\u0010+\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010-0)H\u0016¢\u0006\u0004\b+\u0010.J)\u00100\u001a\b\u0012\u0004\u0012\u00028\u00010)\"\u0004\b\u0001\u0010(2\f\u0010*\u001a\b\u0012\u0004\u0012\u00028\u00010)H\u0000¢\u0006\u0004\b/\u0010,J\u0017\u00100\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010-0)H\u0000¢\u0006\u0004\b/\u0010.JO\u00108\u001a\u00020\u000b2>\u00105\u001a:\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(4\u0012\u001b\u0012\u0019\u0012\u0006\u0012\u0004\u0018\u00010-0)¢\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u000b01H\u0000¢\u0006\u0004\b6\u00107J\u0010\u0010:\u001a\u00020\u000b2\u0006\u00109\u001a\u00020\u0015H\u0002J\u0010\u0010<\u001a\u00020\u000b2\u0006\u0010;\u001a\u00020\u0015H\u0002J\u0010\u0010=\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\u0010\u0010>\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\u0010\u0010?\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\u0010\u0010@\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\u001e\u0010B\u001a\u00020\u000b2\u0006\u0010A\u001a\u00020\u00152\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018H\u0002R\u0016\u00104\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bC\u0010DR\u001e\u0010G\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010-0)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010FR$\u0010L\u001a\u00020\u00152\u0006\u0010H\u001a\u00020\u00158\u0016@RX\u0096\u000e¢\u0006\f\n\u0004\bI\u0010D\u001a\u0004\bJ\u0010K¨\u0006S"}, d2 = {"Lkotlin/collections/ArrayDeque;", androidx.exifinterface.media.ExifInterface.LONGITUDE_EAST, "Lkotlin/collections/AbstractMutableList;", "", "isEmpty", "first", "()Ljava/lang/Object;", "firstOrNull", "last", "lastOrNull", "element", "", "addFirst", "(Ljava/lang/Object;)V", "addLast", "removeFirst", "removeFirstOrNull", "removeLast", "removeLastOrNull", com.anythink.expressad.d.a.b.ay, "(Ljava/lang/Object;)Z", "", "index", "(ILjava/lang/Object;)V", "", "elements", "addAll", com.ss.android.socialbase.downloader.constants.MonitorConstants.CONNECT_TYPE_GET, "(I)Ljava/lang/Object;", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "contains", "indexOf", "(Ljava/lang/Object;)I", "lastIndexOf", "remove", "removeAt", "removeAll", "retainAll", "clear", androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "", "array", "toArray", "([Ljava/lang/Object;)[Ljava/lang/Object;", "", "()[Ljava/lang/Object;", "testToArray$kotlin_stdlib", "testToArray", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", com.ss.android.socialbase.downloader.constants.MonitorConstants.CONNECT_TYPE_HEAD, "structure", "internalStructure$kotlin_stdlib", "(Lkotlin/jvm/functions/Function2;)V", "internalStructure", "minCapacity", "ensureCapacity", "newCapacity", "b", "g", "f", "e", "d", "internalIndex", "a", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.AD_COUNT, "I", "t", "[Ljava/lang/Object;", "elementData", "<set-?>", com.umeng.analytics.pro.bo.aN, "getSize", "()I", com.anythink.core.api.ATAdConst.NETWORK_REQUEST_PARAMS_KEY.BANNER_SIZE, "initialCapacity", "<init>", "(I)V", "()V", "(Ljava/util/Collection;)V", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
@kotlin.WasExperimental(markerClass = {kotlin.ExperimentalStdlibApi.class})
/* loaded from: classes14.dex */
public final class ArrayDeque<E> extends kotlin.collections.AbstractMutableList<E> {

    /* renamed from: Companion, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public static final kotlin.collections.ArrayDeque.Companion INSTANCE = new kotlin.collections.ArrayDeque.Companion(null);

    @org.jetbrains.annotations.NotNull
    public static final java.lang.Object[] v = new java.lang.Object[0];

    /* renamed from: n, reason: from kotlin metadata */
    public int head;

    /* renamed from: t, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public java.lang.Object[] elementData;

    /* renamed from: u, reason: from kotlin metadata */
    public int size;

    @kotlin.Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0007\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001d\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0018\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0007R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lkotlin/collections/ArrayDeque$Companion;", "", "()V", "defaultMinCapacity", "", "emptyElementData", "", "[Ljava/lang/Object;", "maxArraySize", "newCapacity", "oldCapacity", "minCapacity", "newCapacity$kotlin_stdlib", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int newCapacity$kotlin_stdlib(int oldCapacity, int minCapacity) {
            int i = oldCapacity + (oldCapacity >> 1);
            if (i - minCapacity < 0) {
                i = minCapacity;
            }
            return i - 2147483639 > 0 ? minCapacity > 2147483639 ? Integer.MAX_VALUE : 2147483639 : i;
        }
    }

    public ArrayDeque() {
        this.elementData = v;
    }

    public ArrayDeque(int i) {
        java.lang.Object[] objArr;
        if (i == 0) {
            objArr = v;
        } else {
            if (i <= 0) {
                throw new java.lang.IllegalArgumentException("Illegal Capacity: " + i);
            }
            objArr = new java.lang.Object[i];
        }
        this.elementData = objArr;
    }

    public ArrayDeque(@org.jetbrains.annotations.NotNull java.util.Collection<? extends E> elements) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(elements, "elements");
        java.lang.Object[] array = elements.toArray(new java.lang.Object[0]);
        kotlin.jvm.internal.Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        this.elementData = array;
        this.size = array.length;
        if (array.length == 0) {
            this.elementData = v;
        }
    }

    public final void a(int internalIndex, java.util.Collection<? extends E> elements) {
        java.util.Iterator<? extends E> it = elements.iterator();
        int length = this.elementData.length;
        while (internalIndex < length && it.hasNext()) {
            this.elementData[internalIndex] = it.next();
            internalIndex++;
        }
        int i = this.head;
        for (int i2 = 0; i2 < i && it.hasNext(); i2++) {
            this.elementData[i2] = it.next();
        }
        this.size = size() + elements.size();
    }

    @Override // kotlin.collections.AbstractMutableList, java.util.AbstractList, java.util.List
    public void add(int index, E element) {
        kotlin.collections.AbstractList.INSTANCE.checkPositionIndex$kotlin_stdlib(index, size());
        if (index == size()) {
            addLast(element);
            return;
        }
        if (index == 0) {
            addFirst(element);
            return;
        }
        ensureCapacity(size() + 1);
        int g = g(this.head + index);
        if (index < ((size() + 1) >> 1)) {
            int d = d(g);
            int d2 = d(this.head);
            int i = this.head;
            if (d >= i) {
                java.lang.Object[] objArr = this.elementData;
                objArr[d2] = objArr[i];
                kotlin.collections.ArraysKt___ArraysJvmKt.copyInto(objArr, objArr, i, i + 1, d + 1);
            } else {
                java.lang.Object[] objArr2 = this.elementData;
                kotlin.collections.ArraysKt___ArraysJvmKt.copyInto(objArr2, objArr2, i - 1, i, objArr2.length);
                java.lang.Object[] objArr3 = this.elementData;
                objArr3[objArr3.length - 1] = objArr3[0];
                kotlin.collections.ArraysKt___ArraysJvmKt.copyInto(objArr3, objArr3, 0, 1, d + 1);
            }
            this.elementData[d] = element;
            this.head = d2;
        } else {
            int g2 = g(this.head + size());
            if (g < g2) {
                java.lang.Object[] objArr4 = this.elementData;
                kotlin.collections.ArraysKt___ArraysJvmKt.copyInto(objArr4, objArr4, g + 1, g, g2);
            } else {
                java.lang.Object[] objArr5 = this.elementData;
                kotlin.collections.ArraysKt___ArraysJvmKt.copyInto(objArr5, objArr5, 1, 0, g2);
                java.lang.Object[] objArr6 = this.elementData;
                objArr6[0] = objArr6[objArr6.length - 1];
                kotlin.collections.ArraysKt___ArraysJvmKt.copyInto(objArr6, objArr6, g + 1, g, objArr6.length - 1);
            }
            this.elementData[g] = element;
        }
        this.size = size() + 1;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(E element) {
        addLast(element);
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int index, @org.jetbrains.annotations.NotNull java.util.Collection<? extends E> elements) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(elements, "elements");
        kotlin.collections.AbstractList.INSTANCE.checkPositionIndex$kotlin_stdlib(index, size());
        if (elements.isEmpty()) {
            return false;
        }
        if (index == size()) {
            return addAll(elements);
        }
        ensureCapacity(size() + elements.size());
        int g = g(this.head + size());
        int g2 = g(this.head + index);
        int size = elements.size();
        if (index < ((size() + 1) >> 1)) {
            int i = this.head;
            int i2 = i - size;
            if (g2 < i) {
                java.lang.Object[] objArr = this.elementData;
                kotlin.collections.ArraysKt___ArraysJvmKt.copyInto(objArr, objArr, i2, i, objArr.length);
                if (size >= g2) {
                    java.lang.Object[] objArr2 = this.elementData;
                    kotlin.collections.ArraysKt___ArraysJvmKt.copyInto(objArr2, objArr2, objArr2.length - size, 0, g2);
                } else {
                    java.lang.Object[] objArr3 = this.elementData;
                    kotlin.collections.ArraysKt___ArraysJvmKt.copyInto(objArr3, objArr3, objArr3.length - size, 0, size);
                    java.lang.Object[] objArr4 = this.elementData;
                    kotlin.collections.ArraysKt___ArraysJvmKt.copyInto(objArr4, objArr4, 0, size, g2);
                }
            } else if (i2 >= 0) {
                java.lang.Object[] objArr5 = this.elementData;
                kotlin.collections.ArraysKt___ArraysJvmKt.copyInto(objArr5, objArr5, i2, i, g2);
            } else {
                java.lang.Object[] objArr6 = this.elementData;
                i2 += objArr6.length;
                int i3 = g2 - i;
                int length = objArr6.length - i2;
                if (length >= i3) {
                    kotlin.collections.ArraysKt___ArraysJvmKt.copyInto(objArr6, objArr6, i2, i, g2);
                } else {
                    kotlin.collections.ArraysKt___ArraysJvmKt.copyInto(objArr6, objArr6, i2, i, i + length);
                    java.lang.Object[] objArr7 = this.elementData;
                    kotlin.collections.ArraysKt___ArraysJvmKt.copyInto(objArr7, objArr7, 0, this.head + length, g2);
                }
            }
            this.head = i2;
            a(f(g2 - size), elements);
        } else {
            int i4 = g2 + size;
            if (g2 < g) {
                int i5 = size + g;
                java.lang.Object[] objArr8 = this.elementData;
                if (i5 <= objArr8.length) {
                    kotlin.collections.ArraysKt___ArraysJvmKt.copyInto(objArr8, objArr8, i4, g2, g);
                } else if (i4 >= objArr8.length) {
                    kotlin.collections.ArraysKt___ArraysJvmKt.copyInto(objArr8, objArr8, i4 - objArr8.length, g2, g);
                } else {
                    int length2 = g - (i5 - objArr8.length);
                    kotlin.collections.ArraysKt___ArraysJvmKt.copyInto(objArr8, objArr8, 0, length2, g);
                    java.lang.Object[] objArr9 = this.elementData;
                    kotlin.collections.ArraysKt___ArraysJvmKt.copyInto(objArr9, objArr9, i4, g2, length2);
                }
            } else {
                java.lang.Object[] objArr10 = this.elementData;
                kotlin.collections.ArraysKt___ArraysJvmKt.copyInto(objArr10, objArr10, size, 0, g);
                java.lang.Object[] objArr11 = this.elementData;
                if (i4 >= objArr11.length) {
                    kotlin.collections.ArraysKt___ArraysJvmKt.copyInto(objArr11, objArr11, i4 - objArr11.length, g2, objArr11.length);
                } else {
                    kotlin.collections.ArraysKt___ArraysJvmKt.copyInto(objArr11, objArr11, 0, objArr11.length - size, objArr11.length);
                    java.lang.Object[] objArr12 = this.elementData;
                    kotlin.collections.ArraysKt___ArraysJvmKt.copyInto(objArr12, objArr12, i4, g2, objArr12.length - size);
                }
            }
            a(g2, elements);
        }
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(@org.jetbrains.annotations.NotNull java.util.Collection<? extends E> elements) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(elements, "elements");
        if (elements.isEmpty()) {
            return false;
        }
        ensureCapacity(size() + elements.size());
        a(g(this.head + size()), elements);
        return true;
    }

    public final void addFirst(E element) {
        ensureCapacity(size() + 1);
        int d = d(this.head);
        this.head = d;
        this.elementData[d] = element;
        this.size = size() + 1;
    }

    public final void addLast(E element) {
        ensureCapacity(size() + 1);
        this.elementData[g(this.head + size())] = element;
        this.size = size() + 1;
    }

    public final void b(int newCapacity) {
        java.lang.Object[] objArr = new java.lang.Object[newCapacity];
        java.lang.Object[] objArr2 = this.elementData;
        kotlin.collections.ArraysKt___ArraysJvmKt.copyInto(objArr2, objArr, 0, this.head, objArr2.length);
        java.lang.Object[] objArr3 = this.elementData;
        int length = objArr3.length;
        int i = this.head;
        kotlin.collections.ArraysKt___ArraysJvmKt.copyInto(objArr3, objArr, length - i, 0, i);
        this.head = 0;
        this.elementData = objArr;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        int g = g(this.head + size());
        int i = this.head;
        if (i < g) {
            kotlin.collections.ArraysKt___ArraysJvmKt.fill(this.elementData, (java.lang.Object) null, i, g);
        } else if (!isEmpty()) {
            java.lang.Object[] objArr = this.elementData;
            kotlin.collections.ArraysKt___ArraysJvmKt.fill(objArr, (java.lang.Object) null, this.head, objArr.length);
            kotlin.collections.ArraysKt___ArraysJvmKt.fill(this.elementData, (java.lang.Object) null, 0, g);
        }
        this.head = 0;
        this.size = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(java.lang.Object element) {
        return indexOf(element) != -1;
    }

    public final int d(int index) {
        return index == 0 ? kotlin.collections.ArraysKt___ArraysKt.getLastIndex(this.elementData) : index - 1;
    }

    public final int e(int index) {
        if (index == kotlin.collections.ArraysKt___ArraysKt.getLastIndex(this.elementData)) {
            return 0;
        }
        return index + 1;
    }

    public final void ensureCapacity(int minCapacity) {
        int coerceAtLeast;
        if (minCapacity < 0) {
            throw new java.lang.IllegalStateException("Deque is too big.");
        }
        java.lang.Object[] objArr = this.elementData;
        if (minCapacity <= objArr.length) {
            return;
        }
        if (objArr != v) {
            b(INSTANCE.newCapacity$kotlin_stdlib(objArr.length, minCapacity));
        } else {
            coerceAtLeast = kotlin.ranges.RangesKt___RangesKt.coerceAtLeast(minCapacity, 10);
            this.elementData = new java.lang.Object[coerceAtLeast];
        }
    }

    public final int f(int index) {
        return index < 0 ? index + this.elementData.length : index;
    }

    public final E first() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException("ArrayDeque is empty.");
        }
        return (E) this.elementData[this.head];
    }

    @org.jetbrains.annotations.Nullable
    public final E firstOrNull() {
        if (isEmpty()) {
            return null;
        }
        return (E) this.elementData[this.head];
    }

    public final int g(int index) {
        java.lang.Object[] objArr = this.elementData;
        return index >= objArr.length ? index - objArr.length : index;
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int index) {
        kotlin.collections.AbstractList.INSTANCE.checkElementIndex$kotlin_stdlib(index, size());
        return (E) this.elementData[g(this.head + index)];
    }

    @Override // kotlin.collections.AbstractMutableList
    public int getSize() {
        return this.size;
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(java.lang.Object element) {
        int i;
        int g = g(this.head + size());
        int i2 = this.head;
        if (i2 < g) {
            while (i2 < g) {
                if (kotlin.jvm.internal.Intrinsics.areEqual(element, this.elementData[i2])) {
                    i = this.head;
                } else {
                    i2++;
                }
            }
            return -1;
        }
        if (i2 < g) {
            return -1;
        }
        int length = this.elementData.length;
        while (true) {
            if (i2 >= length) {
                for (int i3 = 0; i3 < g; i3++) {
                    if (kotlin.jvm.internal.Intrinsics.areEqual(element, this.elementData[i3])) {
                        i2 = i3 + this.elementData.length;
                        i = this.head;
                    }
                }
                return -1;
            }
            if (kotlin.jvm.internal.Intrinsics.areEqual(element, this.elementData[i2])) {
                i = this.head;
                break;
            }
            i2++;
        }
        return i2 - i;
    }

    public final void internalStructure$kotlin_stdlib(@org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super java.lang.Integer, ? super java.lang.Object[], kotlin.Unit> structure) {
        int i;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(structure, "structure");
        structure.mo5invoke(java.lang.Integer.valueOf((isEmpty() || (i = this.head) < g(this.head + size())) ? this.head : i - this.elementData.length), toArray());
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        return size() == 0;
    }

    public final E last() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException("ArrayDeque is empty.");
        }
        return (E) this.elementData[g(this.head + kotlin.collections.CollectionsKt__CollectionsKt.getLastIndex(this))];
    }

    @Override // java.util.AbstractList, java.util.List
    public int lastIndexOf(java.lang.Object element) {
        int lastIndex;
        int i;
        int g = g(this.head + size());
        int i2 = this.head;
        if (i2 < g) {
            lastIndex = g - 1;
            if (i2 <= lastIndex) {
                while (!kotlin.jvm.internal.Intrinsics.areEqual(element, this.elementData[lastIndex])) {
                    if (lastIndex != i2) {
                        lastIndex--;
                    }
                }
                i = this.head;
                return lastIndex - i;
            }
            return -1;
        }
        if (i2 > g) {
            int i3 = g - 1;
            while (true) {
                if (-1 >= i3) {
                    lastIndex = kotlin.collections.ArraysKt___ArraysKt.getLastIndex(this.elementData);
                    int i4 = this.head;
                    if (i4 <= lastIndex) {
                        while (!kotlin.jvm.internal.Intrinsics.areEqual(element, this.elementData[lastIndex])) {
                            if (lastIndex != i4) {
                                lastIndex--;
                            }
                        }
                        i = this.head;
                    }
                } else {
                    if (kotlin.jvm.internal.Intrinsics.areEqual(element, this.elementData[i3])) {
                        lastIndex = i3 + this.elementData.length;
                        i = this.head;
                        break;
                    }
                    i3--;
                }
            }
        }
        return -1;
    }

    @org.jetbrains.annotations.Nullable
    public final E lastOrNull() {
        if (isEmpty()) {
            return null;
        }
        return (E) this.elementData[g(this.head + kotlin.collections.CollectionsKt__CollectionsKt.getLastIndex(this))];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(java.lang.Object element) {
        int indexOf = indexOf(element);
        if (indexOf == -1) {
            return false;
        }
        remove(indexOf);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(@org.jetbrains.annotations.NotNull java.util.Collection<? extends java.lang.Object> elements) {
        int g;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(elements, "elements");
        boolean z = false;
        z = false;
        z = false;
        if (!isEmpty()) {
            if (!(this.elementData.length == 0)) {
                int g2 = g(this.head + size());
                int i = this.head;
                if (i < g2) {
                    g = i;
                    while (i < g2) {
                        java.lang.Object obj = this.elementData[i];
                        if (!elements.contains(obj)) {
                            this.elementData[g] = obj;
                            g++;
                        } else {
                            z = true;
                        }
                        i++;
                    }
                    kotlin.collections.ArraysKt___ArraysJvmKt.fill(this.elementData, (java.lang.Object) null, g, g2);
                } else {
                    int length = this.elementData.length;
                    int i2 = i;
                    boolean z2 = false;
                    while (i < length) {
                        java.lang.Object[] objArr = this.elementData;
                        java.lang.Object obj2 = objArr[i];
                        objArr[i] = null;
                        if (!elements.contains(obj2)) {
                            this.elementData[i2] = obj2;
                            i2++;
                        } else {
                            z2 = true;
                        }
                        i++;
                    }
                    g = g(i2);
                    for (int i3 = 0; i3 < g2; i3++) {
                        java.lang.Object[] objArr2 = this.elementData;
                        java.lang.Object obj3 = objArr2[i3];
                        objArr2[i3] = null;
                        if (!elements.contains(obj3)) {
                            this.elementData[g] = obj3;
                            g = e(g);
                        } else {
                            z2 = true;
                        }
                    }
                    z = z2;
                }
                if (z) {
                    this.size = f(g - this.head);
                }
            }
        }
        return z;
    }

    @Override // kotlin.collections.AbstractMutableList
    public E removeAt(int index) {
        kotlin.collections.AbstractList.INSTANCE.checkElementIndex$kotlin_stdlib(index, size());
        if (index == kotlin.collections.CollectionsKt__CollectionsKt.getLastIndex(this)) {
            return removeLast();
        }
        if (index == 0) {
            return removeFirst();
        }
        int g = g(this.head + index);
        E e = (E) this.elementData[g];
        if (index < (size() >> 1)) {
            int i = this.head;
            if (g >= i) {
                java.lang.Object[] objArr = this.elementData;
                kotlin.collections.ArraysKt___ArraysJvmKt.copyInto(objArr, objArr, i + 1, i, g);
            } else {
                java.lang.Object[] objArr2 = this.elementData;
                kotlin.collections.ArraysKt___ArraysJvmKt.copyInto(objArr2, objArr2, 1, 0, g);
                java.lang.Object[] objArr3 = this.elementData;
                objArr3[0] = objArr3[objArr3.length - 1];
                int i2 = this.head;
                kotlin.collections.ArraysKt___ArraysJvmKt.copyInto(objArr3, objArr3, i2 + 1, i2, objArr3.length - 1);
            }
            java.lang.Object[] objArr4 = this.elementData;
            int i3 = this.head;
            objArr4[i3] = null;
            this.head = e(i3);
        } else {
            int g2 = g(this.head + kotlin.collections.CollectionsKt__CollectionsKt.getLastIndex(this));
            if (g <= g2) {
                java.lang.Object[] objArr5 = this.elementData;
                kotlin.collections.ArraysKt___ArraysJvmKt.copyInto(objArr5, objArr5, g, g + 1, g2 + 1);
            } else {
                java.lang.Object[] objArr6 = this.elementData;
                kotlin.collections.ArraysKt___ArraysJvmKt.copyInto(objArr6, objArr6, g, g + 1, objArr6.length);
                java.lang.Object[] objArr7 = this.elementData;
                objArr7[objArr7.length - 1] = objArr7[0];
                kotlin.collections.ArraysKt___ArraysJvmKt.copyInto(objArr7, objArr7, 0, 1, g2 + 1);
            }
            this.elementData[g2] = null;
        }
        this.size = size() - 1;
        return e;
    }

    public final E removeFirst() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException("ArrayDeque is empty.");
        }
        java.lang.Object[] objArr = this.elementData;
        int i = this.head;
        E e = (E) objArr[i];
        objArr[i] = null;
        this.head = e(i);
        this.size = size() - 1;
        return e;
    }

    @org.jetbrains.annotations.Nullable
    public final E removeFirstOrNull() {
        if (isEmpty()) {
            return null;
        }
        return removeFirst();
    }

    public final E removeLast() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException("ArrayDeque is empty.");
        }
        int g = g(this.head + kotlin.collections.CollectionsKt__CollectionsKt.getLastIndex(this));
        java.lang.Object[] objArr = this.elementData;
        E e = (E) objArr[g];
        objArr[g] = null;
        this.size = size() - 1;
        return e;
    }

    @org.jetbrains.annotations.Nullable
    public final E removeLastOrNull() {
        if (isEmpty()) {
            return null;
        }
        return removeLast();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean retainAll(@org.jetbrains.annotations.NotNull java.util.Collection<? extends java.lang.Object> elements) {
        int g;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(elements, "elements");
        boolean z = false;
        z = false;
        z = false;
        if (!isEmpty()) {
            if (!(this.elementData.length == 0)) {
                int g2 = g(this.head + size());
                int i = this.head;
                if (i < g2) {
                    g = i;
                    while (i < g2) {
                        java.lang.Object obj = this.elementData[i];
                        if (elements.contains(obj)) {
                            this.elementData[g] = obj;
                            g++;
                        } else {
                            z = true;
                        }
                        i++;
                    }
                    kotlin.collections.ArraysKt___ArraysJvmKt.fill(this.elementData, (java.lang.Object) null, g, g2);
                } else {
                    int length = this.elementData.length;
                    int i2 = i;
                    boolean z2 = false;
                    while (i < length) {
                        java.lang.Object[] objArr = this.elementData;
                        java.lang.Object obj2 = objArr[i];
                        objArr[i] = null;
                        if (elements.contains(obj2)) {
                            this.elementData[i2] = obj2;
                            i2++;
                        } else {
                            z2 = true;
                        }
                        i++;
                    }
                    g = g(i2);
                    for (int i3 = 0; i3 < g2; i3++) {
                        java.lang.Object[] objArr2 = this.elementData;
                        java.lang.Object obj3 = objArr2[i3];
                        objArr2[i3] = null;
                        if (elements.contains(obj3)) {
                            this.elementData[g] = obj3;
                            g = e(g);
                        } else {
                            z2 = true;
                        }
                    }
                    z = z2;
                }
                if (z) {
                    this.size = f(g - this.head);
                }
            }
        }
        return z;
    }

    @Override // kotlin.collections.AbstractMutableList, java.util.AbstractList, java.util.List
    public E set(int index, E element) {
        kotlin.collections.AbstractList.INSTANCE.checkElementIndex$kotlin_stdlib(index, size());
        int g = g(this.head + index);
        java.lang.Object[] objArr = this.elementData;
        E e = (E) objArr[g];
        objArr[g] = element;
        return e;
    }

    @org.jetbrains.annotations.NotNull
    public final java.lang.Object[] testToArray$kotlin_stdlib() {
        return toArray();
    }

    @org.jetbrains.annotations.NotNull
    public final <T> T[] testToArray$kotlin_stdlib(@org.jetbrains.annotations.NotNull T[] array) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(array, "array");
        return (T[]) toArray(array);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    @org.jetbrains.annotations.NotNull
    public java.lang.Object[] toArray() {
        return toArray(new java.lang.Object[size()]);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    @org.jetbrains.annotations.NotNull
    public <T> T[] toArray(@org.jetbrains.annotations.NotNull T[] array) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(array, "array");
        if (array.length < size()) {
            array = (T[]) kotlin.collections.ArraysKt__ArraysJVMKt.arrayOfNulls(array, size());
        }
        kotlin.jvm.internal.Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        int g = g(this.head + size());
        int i = this.head;
        if (i < g) {
            kotlin.collections.ArraysKt___ArraysJvmKt.copyInto$default(this.elementData, array, 0, i, g, 2, (java.lang.Object) null);
        } else if (!isEmpty()) {
            java.lang.Object[] objArr = this.elementData;
            kotlin.collections.ArraysKt___ArraysJvmKt.copyInto(objArr, array, 0, this.head, objArr.length);
            java.lang.Object[] objArr2 = this.elementData;
            kotlin.collections.ArraysKt___ArraysJvmKt.copyInto(objArr2, array, objArr2.length - this.head, 0, g);
        }
        if (array.length > size()) {
            array[size()] = null;
        }
        return array;
    }
}
