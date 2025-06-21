package kotlin.time;

@kotlin.SinceKotlin(version = "1.3")
@kotlin.Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\b\u0087\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u001a\u0012\u0006\u0010\t\u001a\u00028\u0000\u0012\u0006\u0010\n\u001a\u00020\u0005ø\u0001\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0003\u001a\u00028\u0000HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\b\u001a\u00020\u0005HÆ\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0006\u0010\u0007J-\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\t\u001a\u00028\u00002\b\b\u0002\u0010\n\u001a\u00020\u0005HÆ\u0001ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u000f\u001a\u00020\u000eHÖ\u0001J\t\u0010\u0011\u001a\u00020\u0010HÖ\u0001J\u0013\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002HÖ\u0003R\u0017\u0010\t\u001a\u00028\u00008\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004R\u001d\u0010\n\u001a\u00020\u00058\u0006ø\u0001\u0001ø\u0001\u0000¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u0007\u0082\u0002\b\n\u0002\b!\n\u0002\b\u0019¨\u0006\u001d"}, d2 = {"Lkotlin/time/TimedValue;", androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "", "component1", "()Ljava/lang/Object;", "Lkotlin/time/Duration;", "component2-UwyO8pc", "()J", "component2", "value", "duration", "copy-RFiDyg4", "(Ljava/lang/Object;J)Lkotlin/time/TimedValue;", com.sensorsdata.sf.ui.view.UIProperty.action_type_copy, "", "toString", "", com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_HASHCODE, "other", "", "equals", "a", "Ljava/lang/Object;", "getValue", "b", "J", "getDuration-UwyO8pc", "<init>", "(Ljava/lang/Object;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
@kotlin.time.ExperimentalTime
/* loaded from: classes14.dex */
public final /* data */ class TimedValue<T> {

    /* renamed from: a, reason: from kotlin metadata and from toString */
    public final T value;

    /* renamed from: b, reason: from kotlin metadata and from toString */
    public final long duration;

    public TimedValue(T t, long j) {
        this.value = t;
        this.duration = j;
    }

    public /* synthetic */ TimedValue(java.lang.Object obj, long j, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this(obj, j);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: copy-RFiDyg4$default, reason: not valid java name */
    public static /* synthetic */ kotlin.time.TimedValue m751copyRFiDyg4$default(kotlin.time.TimedValue timedValue, java.lang.Object obj, long j, int i, java.lang.Object obj2) {
        if ((i & 1) != 0) {
            obj = timedValue.value;
        }
        if ((i & 2) != 0) {
            j = timedValue.duration;
        }
        return timedValue.m753copyRFiDyg4(obj, j);
    }

    public final T component1() {
        return this.value;
    }

    /* renamed from: component2-UwyO8pc, reason: not valid java name and from getter */
    public final long getDuration() {
        return this.duration;
    }

    @org.jetbrains.annotations.NotNull
    /* renamed from: copy-RFiDyg4, reason: not valid java name */
    public final kotlin.time.TimedValue<T> m753copyRFiDyg4(T value, long duration) {
        return new kotlin.time.TimedValue<>(value, duration, null);
    }

    public boolean equals(@org.jetbrains.annotations.Nullable java.lang.Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof kotlin.time.TimedValue)) {
            return false;
        }
        kotlin.time.TimedValue timedValue = (kotlin.time.TimedValue) other;
        return kotlin.jvm.internal.Intrinsics.areEqual(this.value, timedValue.value) && kotlin.time.Duration.m635equalsimpl0(this.duration, timedValue.duration);
    }

    /* renamed from: getDuration-UwyO8pc, reason: not valid java name */
    public final long m754getDurationUwyO8pc() {
        return this.duration;
    }

    public final T getValue() {
        return this.value;
    }

    public int hashCode() {
        T t = this.value;
        return ((t == null ? 0 : t.hashCode()) * 31) + kotlin.time.Duration.m655hashCodeimpl(this.duration);
    }

    @org.jetbrains.annotations.NotNull
    public java.lang.String toString() {
        return "TimedValue(value=" + this.value + ", duration=" + ((java.lang.Object) kotlin.time.Duration.m674toStringimpl(this.duration)) + ')';
    }
}
