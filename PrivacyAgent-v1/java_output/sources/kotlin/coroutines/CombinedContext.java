package kotlin.coroutines;

@kotlin.SinceKotlin(version = "1.3")
@kotlin.Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u00012\u00060\u0002j\u0002`\u0003:\u0001!B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0001\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0000H\u0002J\u0013\u0010\f\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0096\u0002J5\u0010\u000f\u001a\u0002H\u0010\"\u0004\b\u0000\u0010\u00102\u0006\u0010\u0011\u001a\u0002H\u00102\u0018\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u0002H\u00100\u0013H\u0016¢\u0006\u0002\u0010\u0014J(\u0010\u0015\u001a\u0004\u0018\u0001H\u0016\"\b\b\u0000\u0010\u0016*\u00020\u00062\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00160\u0018H\u0096\u0002¢\u0006\u0002\u0010\u0019J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\u0014\u0010\u001c\u001a\u00020\u00012\n\u0010\u0017\u001a\u0006\u0012\u0002\b\u00030\u0018H\u0016J\b\u0010\u001d\u001a\u00020\u001bH\u0002J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020\u000eH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lkotlin/coroutines/CombinedContext;", "Lkotlin/coroutines/CoroutineContext;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", com.sensorsdata.sf.ui.view.UIProperty.left, "element", "Lkotlin/coroutines/CoroutineContext$Element;", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/CoroutineContext$Element;)V", "contains", "", "containsAll", "context", "equals", "other", "", "fold", "R", "initial", "operation", "Lkotlin/Function2;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", com.ss.android.socialbase.downloader.constants.MonitorConstants.CONNECT_TYPE_GET, androidx.exifinterface.media.ExifInterface.LONGITUDE_EAST, "key", "Lkotlin/coroutines/CoroutineContext$Key;", "(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;", com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_HASHCODE, "", "minusKey", com.anythink.core.api.ATAdConst.NETWORK_REQUEST_PARAMS_KEY.BANNER_SIZE, "toString", "", "writeReplace", "Serialized", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
public final class CombinedContext implements kotlin.coroutines.CoroutineContext, java.io.Serializable {

    @org.jetbrains.annotations.NotNull
    private final kotlin.coroutines.CoroutineContext.Element element;

    @org.jetbrains.annotations.NotNull
    private final kotlin.coroutines.CoroutineContext left;

    @kotlin.Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0002\u0018\u0000 \f2\u00060\u0001j\u0002`\u0002:\u0001\fB\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0006J\b\u0010\n\u001a\u00020\u000bH\u0002R\u0019\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\b¨\u0006\r"}, d2 = {"Lkotlin/coroutines/CombinedContext$Serialized;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "elements", "", "Lkotlin/coroutines/CoroutineContext;", "([Lkotlin/coroutines/CoroutineContext;)V", "getElements", "()[Lkotlin/coroutines/CoroutineContext;", "[Lkotlin/coroutines/CoroutineContext;", "readResolve", "", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Serialized implements java.io.Serializable {
        private static final long serialVersionUID = 0;

        @org.jetbrains.annotations.NotNull
        private final kotlin.coroutines.CoroutineContext[] elements;

        public Serialized(@org.jetbrains.annotations.NotNull kotlin.coroutines.CoroutineContext[] elements) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(elements, "elements");
            this.elements = elements;
        }

        private final java.lang.Object readResolve() {
            kotlin.coroutines.CoroutineContext[] coroutineContextArr = this.elements;
            kotlin.coroutines.CoroutineContext coroutineContext = kotlin.coroutines.EmptyCoroutineContext.INSTANCE;
            for (kotlin.coroutines.CoroutineContext coroutineContext2 : coroutineContextArr) {
                coroutineContext = coroutineContext.plus(coroutineContext2);
            }
            return coroutineContext;
        }

        @org.jetbrains.annotations.NotNull
        public final kotlin.coroutines.CoroutineContext[] getElements() {
            return this.elements;
        }
    }

    public CombinedContext(@org.jetbrains.annotations.NotNull kotlin.coroutines.CoroutineContext left, @org.jetbrains.annotations.NotNull kotlin.coroutines.CoroutineContext.Element element) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(left, "left");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(element, "element");
        this.left = left;
        this.element = element;
    }

    private final boolean contains(kotlin.coroutines.CoroutineContext.Element element) {
        return kotlin.jvm.internal.Intrinsics.areEqual(get(element.getKey()), element);
    }

    private final boolean containsAll(kotlin.coroutines.CombinedContext context) {
        while (contains(context.element)) {
            kotlin.coroutines.CoroutineContext coroutineContext = context.left;
            if (!(coroutineContext instanceof kotlin.coroutines.CombinedContext)) {
                kotlin.jvm.internal.Intrinsics.checkNotNull(coroutineContext, "null cannot be cast to non-null type kotlin.coroutines.CoroutineContext.Element");
                return contains((kotlin.coroutines.CoroutineContext.Element) coroutineContext);
            }
            context = (kotlin.coroutines.CombinedContext) coroutineContext;
        }
        return false;
    }

    private final int size() {
        int i = 2;
        kotlin.coroutines.CombinedContext combinedContext = this;
        while (true) {
            kotlin.coroutines.CoroutineContext coroutineContext = combinedContext.left;
            combinedContext = coroutineContext instanceof kotlin.coroutines.CombinedContext ? (kotlin.coroutines.CombinedContext) coroutineContext : null;
            if (combinedContext == null) {
                return i;
            }
            i++;
        }
    }

    private final java.lang.Object writeReplace() {
        int size = size();
        kotlin.coroutines.CoroutineContext[] coroutineContextArr = new kotlin.coroutines.CoroutineContext[size];
        kotlin.jvm.internal.Ref.IntRef intRef = new kotlin.jvm.internal.Ref.IntRef();
        fold(kotlin.Unit.INSTANCE, new kotlin.coroutines.CombinedContext$writeReplace$1(coroutineContextArr, intRef));
        if (intRef.element == size) {
            return new kotlin.coroutines.CombinedContext.Serialized(coroutineContextArr);
        }
        throw new java.lang.IllegalStateException("Check failed.".toString());
    }

    public boolean equals(@org.jetbrains.annotations.Nullable java.lang.Object other) {
        if (this != other) {
            if (other instanceof kotlin.coroutines.CombinedContext) {
                kotlin.coroutines.CombinedContext combinedContext = (kotlin.coroutines.CombinedContext) other;
                if (combinedContext.size() != size() || !combinedContext.containsAll(this)) {
                }
            }
            return false;
        }
        return true;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public <R> R fold(R initial, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super R, ? super kotlin.coroutines.CoroutineContext.Element, ? extends R> operation) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(operation, "operation");
        return operation.mo5invoke((java.lang.Object) this.left.fold(initial, operation), this.element);
    }

    @Override // kotlin.coroutines.CoroutineContext
    @org.jetbrains.annotations.Nullable
    public <E extends kotlin.coroutines.CoroutineContext.Element> E get(@org.jetbrains.annotations.NotNull kotlin.coroutines.CoroutineContext.Key<E> key) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(key, "key");
        kotlin.coroutines.CombinedContext combinedContext = this;
        while (true) {
            E e = (E) combinedContext.element.get(key);
            if (e != null) {
                return e;
            }
            kotlin.coroutines.CoroutineContext coroutineContext = combinedContext.left;
            if (!(coroutineContext instanceof kotlin.coroutines.CombinedContext)) {
                return (E) coroutineContext.get(key);
            }
            combinedContext = (kotlin.coroutines.CombinedContext) coroutineContext;
        }
    }

    public int hashCode() {
        return this.left.hashCode() + this.element.hashCode();
    }

    @Override // kotlin.coroutines.CoroutineContext
    @org.jetbrains.annotations.NotNull
    public kotlin.coroutines.CoroutineContext minusKey(@org.jetbrains.annotations.NotNull kotlin.coroutines.CoroutineContext.Key<?> key) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(key, "key");
        if (this.element.get(key) != null) {
            return this.left;
        }
        kotlin.coroutines.CoroutineContext minusKey = this.left.minusKey(key);
        return minusKey == this.left ? this : minusKey == kotlin.coroutines.EmptyCoroutineContext.INSTANCE ? this.element : new kotlin.coroutines.CombinedContext(minusKey, this.element);
    }

    @Override // kotlin.coroutines.CoroutineContext
    @org.jetbrains.annotations.NotNull
    public kotlin.coroutines.CoroutineContext plus(@org.jetbrains.annotations.NotNull kotlin.coroutines.CoroutineContext coroutineContext) {
        return kotlin.coroutines.CoroutineContext.DefaultImpls.plus(this, coroutineContext);
    }

    @org.jetbrains.annotations.NotNull
    public java.lang.String toString() {
        return '[' + ((java.lang.String) fold("", kotlin.coroutines.CombinedContext$toString$1.INSTANCE)) + ']';
    }
}
