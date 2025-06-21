package kotlin.collections;

@kotlin.Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0004\u001a\u00020\u0003H\u0096\u0002J\u0010\u0010\u0005\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\b\u001a\u00020\u0007H$J\u0017\u0010\n\u001a\u00020\u00072\u0006\u0010\t\u001a\u00028\u0000H\u0004¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\f\u001a\u00020\u0007H\u0004J\b\u0010\r\u001a\u00020\u0003H\u0002R\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0014\u001a\u0004\u0018\u00018\u00008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lkotlin/collections/AbstractIterator;", androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "", "", "hasNext", "next", "()Ljava/lang/Object;", "", "computeNext", "value", "setNext", "(Ljava/lang/Object;)V", "done", "a", "Lkotlin/collections/State;", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.AD_COUNT, "Lkotlin/collections/State;", com.anythink.expressad.atsignalcommon.mraid.CallMraidJS.b, "t", "Ljava/lang/Object;", "nextValue", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public abstract class AbstractIterator<T> implements java.util.Iterator<T>, kotlin.jvm.internal.markers.KMappedMarker {

    /* renamed from: n, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public kotlin.collections.State state = kotlin.collections.State.NotReady;

    /* renamed from: t, reason: from kotlin metadata */
    @org.jetbrains.annotations.Nullable
    public T nextValue;

    @kotlin.Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[kotlin.collections.State.values().length];
            iArr[kotlin.collections.State.Done.ordinal()] = 1;
            iArr[kotlin.collections.State.Ready.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public final boolean a() {
        this.state = kotlin.collections.State.Failed;
        computeNext();
        return this.state == kotlin.collections.State.Ready;
    }

    public abstract void computeNext();

    public final void done() {
        this.state = kotlin.collections.State.Done;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        kotlin.collections.State state = this.state;
        if (!(state != kotlin.collections.State.Failed)) {
            throw new java.lang.IllegalArgumentException("Failed requirement.".toString());
        }
        int i = kotlin.collections.AbstractIterator.WhenMappings.$EnumSwitchMapping$0[state.ordinal()];
        if (i == 1) {
            return false;
        }
        if (i != 2) {
            return a();
        }
        return true;
    }

    @Override // java.util.Iterator
    public T next() {
        if (!hasNext()) {
            throw new java.util.NoSuchElementException();
        }
        this.state = kotlin.collections.State.NotReady;
        return this.nextValue;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new java.lang.UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final void setNext(T value) {
        this.nextValue = value;
        this.state = kotlin.collections.State.Ready;
    }
}
