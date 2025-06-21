package kotlin.reflect;

@kotlin.Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0013¢\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\u0015\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u000b\u001a\u00020\u0004H\u0016J\u0013\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0096\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0012\u001a\u00020\u0004H\u0016R\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lkotlin/reflect/TypeVariableImpl;", "Ljava/lang/reflect/TypeVariable;", "Ljava/lang/reflect/GenericDeclaration;", "Lkotlin/reflect/TypeImpl;", "", "getName", "getGenericDeclaration", "", "Ljava/lang/reflect/Type;", "getBounds", "()[Ljava/lang/reflect/Type;", "getTypeName", "", "other", "", "equals", "", com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_HASHCODE, "toString", "Lkotlin/reflect/KTypeParameter;", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.AD_COUNT, "Lkotlin/reflect/KTypeParameter;", "typeParameter", "<init>", "(Lkotlin/reflect/KTypeParameter;)V", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
@kotlin.ExperimentalStdlibApi
/* loaded from: classes14.dex */
final class TypeVariableImpl implements java.lang.reflect.TypeVariable<java.lang.reflect.GenericDeclaration>, kotlin.reflect.TypeImpl {

    /* renamed from: n, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public final kotlin.reflect.KTypeParameter typeParameter;

    public TypeVariableImpl(@org.jetbrains.annotations.NotNull kotlin.reflect.KTypeParameter typeParameter) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(typeParameter, "typeParameter");
        this.typeParameter = typeParameter;
    }

    public boolean equals(@org.jetbrains.annotations.Nullable java.lang.Object other) {
        if (other instanceof java.lang.reflect.TypeVariable) {
            java.lang.reflect.TypeVariable typeVariable = (java.lang.reflect.TypeVariable) other;
            if (kotlin.jvm.internal.Intrinsics.areEqual(getName(), typeVariable.getName()) && kotlin.jvm.internal.Intrinsics.areEqual(getGenericDeclaration(), typeVariable.getGenericDeclaration())) {
                return true;
            }
        }
        return false;
    }

    @Override // java.lang.reflect.TypeVariable
    @org.jetbrains.annotations.NotNull
    public java.lang.reflect.Type[] getBounds() {
        java.lang.reflect.Type a;
        java.util.List<kotlin.reflect.KType> upperBounds = this.typeParameter.getUpperBounds();
        java.util.ArrayList arrayList = new java.util.ArrayList(kotlin.collections.CollectionsKt__IterablesKt.collectionSizeOrDefault(upperBounds, 10));
        java.util.Iterator<T> it = upperBounds.iterator();
        while (it.hasNext()) {
            a = kotlin.reflect.TypesJVMKt.a((kotlin.reflect.KType) it.next(), true);
            arrayList.add(a);
        }
        java.lang.Object[] array = arrayList.toArray(new java.lang.reflect.Type[0]);
        kotlin.jvm.internal.Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return (java.lang.reflect.Type[]) array;
    }

    @Override // java.lang.reflect.TypeVariable
    @org.jetbrains.annotations.NotNull
    public java.lang.reflect.GenericDeclaration getGenericDeclaration() {
        throw new kotlin.NotImplementedError("An operation is not implemented: " + ("getGenericDeclaration() is not yet supported for type variables created from KType: " + this.typeParameter));
    }

    @Override // java.lang.reflect.TypeVariable
    @org.jetbrains.annotations.NotNull
    public java.lang.String getName() {
        return this.typeParameter.getName();
    }

    @Override // java.lang.reflect.Type
    @org.jetbrains.annotations.NotNull
    public java.lang.String getTypeName() {
        return getName();
    }

    public int hashCode() {
        return getName().hashCode() ^ getGenericDeclaration().hashCode();
    }

    @org.jetbrains.annotations.NotNull
    public java.lang.String toString() {
        return getTypeName();
    }
}
