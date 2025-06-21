package kotlin.reflect;

@kotlin.Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0003\u0018\u0000 \u00182\u00020\u00012\u00020\u0002:\u0001\u0019B\u001b\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\b\u0010\t\u001a\u00020\bH\u0016J\u0013\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0096\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0010\u001a\u00020\bH\u0016R\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0012¨\u0006\u001a"}, d2 = {"Lkotlin/reflect/WildcardTypeImpl;", "Ljava/lang/reflect/WildcardType;", "Lkotlin/reflect/TypeImpl;", "", "Ljava/lang/reflect/Type;", "getUpperBounds", "()[Ljava/lang/reflect/Type;", "getLowerBounds", "", "getTypeName", "", "other", "", "equals", "", com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_HASHCODE, "toString", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.AD_COUNT, "Ljava/lang/reflect/Type;", "upperBound", "t", "lowerBound", "<init>", "(Ljava/lang/reflect/Type;Ljava/lang/reflect/Type;)V", com.umeng.analytics.pro.bo.aN, "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
@kotlin.ExperimentalStdlibApi
/* loaded from: classes14.dex */
final class WildcardTypeImpl implements java.lang.reflect.WildcardType, kotlin.reflect.TypeImpl {

    /* renamed from: u, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public static final kotlin.reflect.WildcardTypeImpl.Companion INSTANCE = new kotlin.reflect.WildcardTypeImpl.Companion(null);

    @org.jetbrains.annotations.NotNull
    public static final kotlin.reflect.WildcardTypeImpl v = new kotlin.reflect.WildcardTypeImpl(null, null);

    /* renamed from: n, reason: from kotlin metadata */
    @org.jetbrains.annotations.Nullable
    public final java.lang.reflect.Type upperBound;

    /* renamed from: t, reason: from kotlin metadata */
    @org.jetbrains.annotations.Nullable
    public final java.lang.reflect.Type lowerBound;

    @kotlin.Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lkotlin/reflect/WildcardTypeImpl$Companion;", "", "()V", "STAR", "Lkotlin/reflect/WildcardTypeImpl;", "getSTAR", "()Lkotlin/reflect/WildcardTypeImpl;", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @org.jetbrains.annotations.NotNull
        public final kotlin.reflect.WildcardTypeImpl getSTAR() {
            return kotlin.reflect.WildcardTypeImpl.v;
        }
    }

    public WildcardTypeImpl(@org.jetbrains.annotations.Nullable java.lang.reflect.Type type, @org.jetbrains.annotations.Nullable java.lang.reflect.Type type2) {
        this.upperBound = type;
        this.lowerBound = type2;
    }

    public boolean equals(@org.jetbrains.annotations.Nullable java.lang.Object other) {
        if (other instanceof java.lang.reflect.WildcardType) {
            java.lang.reflect.WildcardType wildcardType = (java.lang.reflect.WildcardType) other;
            if (java.util.Arrays.equals(getUpperBounds(), wildcardType.getUpperBounds()) && java.util.Arrays.equals(getLowerBounds(), wildcardType.getLowerBounds())) {
                return true;
            }
        }
        return false;
    }

    @Override // java.lang.reflect.WildcardType
    @org.jetbrains.annotations.NotNull
    public java.lang.reflect.Type[] getLowerBounds() {
        java.lang.reflect.Type type = this.lowerBound;
        return type == null ? new java.lang.reflect.Type[0] : new java.lang.reflect.Type[]{type};
    }

    @Override // java.lang.reflect.Type
    @org.jetbrains.annotations.NotNull
    public java.lang.String getTypeName() {
        java.lang.String e;
        java.lang.String e2;
        if (this.lowerBound != null) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("? super ");
            e2 = kotlin.reflect.TypesJVMKt.e(this.lowerBound);
            sb.append(e2);
            return sb.toString();
        }
        java.lang.reflect.Type type = this.upperBound;
        if (type == null || kotlin.jvm.internal.Intrinsics.areEqual(type, java.lang.Object.class)) {
            return "?";
        }
        java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
        sb2.append("? extends ");
        e = kotlin.reflect.TypesJVMKt.e(this.upperBound);
        sb2.append(e);
        return sb2.toString();
    }

    @Override // java.lang.reflect.WildcardType
    @org.jetbrains.annotations.NotNull
    public java.lang.reflect.Type[] getUpperBounds() {
        java.lang.reflect.Type[] typeArr = new java.lang.reflect.Type[1];
        java.lang.reflect.Type type = this.upperBound;
        if (type == null) {
            type = java.lang.Object.class;
        }
        typeArr[0] = type;
        return typeArr;
    }

    public int hashCode() {
        return java.util.Arrays.hashCode(getUpperBounds()) ^ java.util.Arrays.hashCode(getLowerBounds());
    }

    @org.jetbrains.annotations.NotNull
    public java.lang.String toString() {
        return getTypeName();
    }
}
