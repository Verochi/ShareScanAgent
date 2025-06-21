package kotlin.reflect;

@kotlin.Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u0013\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0096\u0002J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\r\u001a\u00020\u0005H\u0016R\u0014\u0010\u0010\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lkotlin/reflect/GenericArrayTypeImpl;", "Ljava/lang/reflect/GenericArrayType;", "Lkotlin/reflect/TypeImpl;", "Ljava/lang/reflect/Type;", "getGenericComponentType", "", "getTypeName", "", "other", "", "equals", "", com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_HASHCODE, "toString", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.AD_COUNT, "Ljava/lang/reflect/Type;", "elementType", "<init>", "(Ljava/lang/reflect/Type;)V", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
@kotlin.ExperimentalStdlibApi
/* loaded from: classes14.dex */
final class GenericArrayTypeImpl implements java.lang.reflect.GenericArrayType, kotlin.reflect.TypeImpl {

    /* renamed from: n, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public final java.lang.reflect.Type elementType;

    public GenericArrayTypeImpl(@org.jetbrains.annotations.NotNull java.lang.reflect.Type elementType) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(elementType, "elementType");
        this.elementType = elementType;
    }

    public boolean equals(@org.jetbrains.annotations.Nullable java.lang.Object other) {
        return (other instanceof java.lang.reflect.GenericArrayType) && kotlin.jvm.internal.Intrinsics.areEqual(getGenericComponentType(), ((java.lang.reflect.GenericArrayType) other).getGenericComponentType());
    }

    @Override // java.lang.reflect.GenericArrayType
    @org.jetbrains.annotations.NotNull
    public java.lang.reflect.Type getGenericComponentType() {
        return this.elementType;
    }

    @Override // java.lang.reflect.Type
    @org.jetbrains.annotations.NotNull
    public java.lang.String getTypeName() {
        java.lang.String e;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        e = kotlin.reflect.TypesJVMKt.e(this.elementType);
        sb.append(e);
        sb.append("[]");
        return sb.toString();
    }

    public int hashCode() {
        return getGenericComponentType().hashCode();
    }

    @org.jetbrains.annotations.NotNull
    public java.lang.String toString() {
        return getTypeName();
    }
}
