package kotlin.reflect;

@kotlin.Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00020\u0004:\u0001\u000eJ\u001d\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00028\u00002\u0006\u0010\f\u001a\u00028\u0001H&¢\u0006\u0002\u0010\rR\u001e\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u000f"}, d2 = {"Lkotlin/reflect/KMutableProperty1;", androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, androidx.exifinterface.media.ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lkotlin/reflect/KProperty1;", "Lkotlin/reflect/KMutableProperty;", "setter", "Lkotlin/reflect/KMutableProperty1$Setter;", "getSetter", "()Lkotlin/reflect/KMutableProperty1$Setter;", "set", "", com.tencent.open.SocialConstants.PARAM_RECEIVER, "value", "(Ljava/lang/Object;Ljava/lang/Object;)V", "Setter", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
public interface KMutableProperty1<T, V> extends kotlin.reflect.KProperty1<T, V>, kotlin.reflect.KMutableProperty<V> {

    @kotlin.Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\bf\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0014\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00050\u0004¨\u0006\u0006"}, d2 = {"Lkotlin/reflect/KMutableProperty1$Setter;", androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, androidx.exifinterface.media.ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lkotlin/reflect/KMutableProperty$Setter;", "Lkotlin/Function2;", "", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface Setter<T, V> extends kotlin.reflect.KMutableProperty.Setter<V>, kotlin.jvm.functions.Function2<T, V, kotlin.Unit> {
    }

    @Override // kotlin.reflect.KMutableProperty
    @org.jetbrains.annotations.NotNull
    kotlin.reflect.KMutableProperty1.Setter<T, V> getSetter();

    void set(T receiver, V value);
}
