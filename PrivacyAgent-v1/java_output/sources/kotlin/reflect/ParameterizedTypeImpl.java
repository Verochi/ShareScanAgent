package kotlin.reflect;

@kotlin.Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B+\u0012\n\u0010\u0015\u001a\u0006\u0012\u0002\b\u00030\u0012\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00030\u001c¢\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0004\u001a\u00020\u0003H\u0016J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0003H\u0016J\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\n\u001a\u00020\tH\u0016J\u0013\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0096\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0011\u001a\u00020\tH\u0016R\u0018\u0010\u0015\u001a\u0006\u0012\u0002\b\u00030\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0018\u001a\u0004\u0018\u00010\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001f"}, d2 = {"Lkotlin/reflect/ParameterizedTypeImpl;", "Ljava/lang/reflect/ParameterizedType;", "Lkotlin/reflect/TypeImpl;", "Ljava/lang/reflect/Type;", "getRawType", "getOwnerType", "", "getActualTypeArguments", "()[Ljava/lang/reflect/Type;", "", "getTypeName", "", "other", "", "equals", "", com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_HASHCODE, "toString", "Ljava/lang/Class;", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.AD_COUNT, "Ljava/lang/Class;", "rawType", "t", "Ljava/lang/reflect/Type;", "ownerType", com.umeng.analytics.pro.bo.aN, "[Ljava/lang/reflect/Type;", "typeArguments", "", "<init>", "(Ljava/lang/Class;Ljava/lang/reflect/Type;Ljava/util/List;)V", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
@kotlin.ExperimentalStdlibApi
/* loaded from: classes14.dex */
final class ParameterizedTypeImpl implements java.lang.reflect.ParameterizedType, kotlin.reflect.TypeImpl {

    /* renamed from: n, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public final java.lang.Class<?> rawType;

    /* renamed from: t, reason: from kotlin metadata */
    @org.jetbrains.annotations.Nullable
    public final java.lang.reflect.Type ownerType;

    /* renamed from: u, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public final java.lang.reflect.Type[] typeArguments;

    public ParameterizedTypeImpl(@org.jetbrains.annotations.NotNull java.lang.Class<?> rawType, @org.jetbrains.annotations.Nullable java.lang.reflect.Type type, @org.jetbrains.annotations.NotNull java.util.List<? extends java.lang.reflect.Type> typeArguments) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(rawType, "rawType");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(typeArguments, "typeArguments");
        this.rawType = rawType;
        this.ownerType = type;
        java.lang.Object[] array = typeArguments.toArray(new java.lang.reflect.Type[0]);
        kotlin.jvm.internal.Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        this.typeArguments = (java.lang.reflect.Type[]) array;
    }

    public boolean equals(@org.jetbrains.annotations.Nullable java.lang.Object other) {
        if (other instanceof java.lang.reflect.ParameterizedType) {
            java.lang.reflect.ParameterizedType parameterizedType = (java.lang.reflect.ParameterizedType) other;
            if (kotlin.jvm.internal.Intrinsics.areEqual(this.rawType, parameterizedType.getRawType()) && kotlin.jvm.internal.Intrinsics.areEqual(this.ownerType, parameterizedType.getOwnerType()) && java.util.Arrays.equals(getActualTypeArguments(), parameterizedType.getActualTypeArguments())) {
                return true;
            }
        }
        return false;
    }

    @Override // java.lang.reflect.ParameterizedType
    @org.jetbrains.annotations.NotNull
    public java.lang.reflect.Type[] getActualTypeArguments() {
        return this.typeArguments;
    }

    @Override // java.lang.reflect.ParameterizedType
    @org.jetbrains.annotations.Nullable
    public java.lang.reflect.Type getOwnerType() {
        return this.ownerType;
    }

    @Override // java.lang.reflect.ParameterizedType
    @org.jetbrains.annotations.NotNull
    public java.lang.reflect.Type getRawType() {
        return this.rawType;
    }

    @Override // java.lang.reflect.Type
    @org.jetbrains.annotations.NotNull
    public java.lang.String getTypeName() {
        java.lang.String e;
        java.lang.String e2;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        java.lang.reflect.Type type = this.ownerType;
        if (type != null) {
            e2 = kotlin.reflect.TypesJVMKt.e(type);
            sb.append(e2);
            sb.append("$");
            sb.append(this.rawType.getSimpleName());
        } else {
            e = kotlin.reflect.TypesJVMKt.e(this.rawType);
            sb.append(e);
        }
        java.lang.reflect.Type[] typeArr = this.typeArguments;
        if (!(typeArr.length == 0)) {
            kotlin.collections.ArraysKt.joinTo$default(typeArr, sb, (java.lang.CharSequence) null, "<", ">", 0, (java.lang.CharSequence) null, kotlin.reflect.ParameterizedTypeImpl$getTypeName$1$1.INSTANCE, 50, (java.lang.Object) null);
        }
        java.lang.String sb2 = sb.toString();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public int hashCode() {
        int hashCode = this.rawType.hashCode();
        java.lang.reflect.Type type = this.ownerType;
        return (hashCode ^ (type != null ? type.hashCode() : 0)) ^ java.util.Arrays.hashCode(getActualTypeArguments());
    }

    @org.jetbrains.annotations.NotNull
    public java.lang.String toString() {
        return getTypeName();
    }
}
