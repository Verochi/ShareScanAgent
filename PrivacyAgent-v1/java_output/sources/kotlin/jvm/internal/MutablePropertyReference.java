package kotlin.jvm.internal;

/* loaded from: classes14.dex */
public abstract class MutablePropertyReference extends kotlin.jvm.internal.PropertyReference implements kotlin.reflect.KMutableProperty {
    public MutablePropertyReference() {
    }

    @kotlin.SinceKotlin(version = "1.1")
    public MutablePropertyReference(java.lang.Object obj) {
        super(obj);
    }

    @kotlin.SinceKotlin(version = "1.4")
    public MutablePropertyReference(java.lang.Object obj, java.lang.Class cls, java.lang.String str, java.lang.String str2, int i) {
        super(obj, cls, str, str2, i);
    }
}
