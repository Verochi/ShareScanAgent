package kotlin.jvm.internal;

@kotlin.SinceKotlin(version = "1.4")
@kotlin.Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0014\b\u0007\u0018\u0000 *2\u00020\u0001:\u0001*B)\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\u0016\u001a\u00020\r\u0012\u0006\u0010\u001c\u001a\u00020\u0017\u0012\u0006\u0010\u001f\u001a\u00020\t¢\u0006\u0004\b(\u0010)J\u0014\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\u0013\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0096\u0002J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016R\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0016\u001a\u00020\r8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u001c\u001a\u00020\u00178\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001f\u001a\u00020\t8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001e\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028VX\u0096\u0004¢\u0006\f\u0012\u0004\b&\u0010'\u001a\u0004\b$\u0010%¨\u0006+"}, d2 = {"Lkotlin/jvm/internal/TypeParameterReference;", "Lkotlin/reflect/KTypeParameter;", "", "Lkotlin/reflect/KType;", "upperBounds", "", "setUpperBounds", "", "other", "", "equals", "", com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_HASHCODE, "", "toString", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.AD_COUNT, "Ljava/lang/Object;", "container", "t", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "name", "Lkotlin/reflect/KVariance;", com.umeng.analytics.pro.bo.aN, "Lkotlin/reflect/KVariance;", "getVariance", "()Lkotlin/reflect/KVariance;", "variance", "v", "Z", "isReified", "()Z", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.WIDTH, "Ljava/util/List;", "bounds", "getUpperBounds", "()Ljava/util/List;", "getUpperBounds$annotations", "()V", "<init>", "(Ljava/lang/Object;Ljava/lang/String;Lkotlin/reflect/KVariance;Z)V", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class TypeParameterReference implements kotlin.reflect.KTypeParameter {

    /* renamed from: Companion, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public static final kotlin.jvm.internal.TypeParameterReference.Companion INSTANCE = new kotlin.jvm.internal.TypeParameterReference.Companion(null);

    /* renamed from: n, reason: from kotlin metadata */
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object container;

    /* renamed from: t, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public final java.lang.String name;

    /* renamed from: u, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public final kotlin.reflect.KVariance variance;

    /* renamed from: v, reason: from kotlin metadata */
    public final boolean isReified;

    /* renamed from: w, reason: from kotlin metadata */
    @org.jetbrains.annotations.Nullable
    public volatile java.util.List<? extends kotlin.reflect.KType> bounds;

    @kotlin.Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lkotlin/jvm/internal/TypeParameterReference$Companion;", "", "()V", "toString", "", "typeParameter", "Lkotlin/reflect/KTypeParameter;", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {

        @kotlin.Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[kotlin.reflect.KVariance.values().length];
                iArr[kotlin.reflect.KVariance.INVARIANT.ordinal()] = 1;
                iArr[kotlin.reflect.KVariance.IN.ordinal()] = 2;
                iArr[kotlin.reflect.KVariance.OUT.ordinal()] = 3;
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public Companion() {
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @org.jetbrains.annotations.NotNull
        public final java.lang.String toString(@org.jetbrains.annotations.NotNull kotlin.reflect.KTypeParameter typeParameter) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(typeParameter, "typeParameter");
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            int i = kotlin.jvm.internal.TypeParameterReference.Companion.WhenMappings.$EnumSwitchMapping$0[typeParameter.getVariance().ordinal()];
            if (i == 2) {
                sb.append("in ");
            } else if (i == 3) {
                sb.append("out ");
            }
            sb.append(typeParameter.getName());
            java.lang.String sb2 = sb.toString();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
            return sb2;
        }
    }

    public TypeParameterReference(@org.jetbrains.annotations.Nullable java.lang.Object obj, @org.jetbrains.annotations.NotNull java.lang.String name, @org.jetbrains.annotations.NotNull kotlin.reflect.KVariance variance, boolean z) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(variance, "variance");
        this.container = obj;
        this.name = name;
        this.variance = variance;
        this.isReified = z;
    }

    public static /* synthetic */ void getUpperBounds$annotations() {
    }

    public boolean equals(@org.jetbrains.annotations.Nullable java.lang.Object other) {
        if (other instanceof kotlin.jvm.internal.TypeParameterReference) {
            kotlin.jvm.internal.TypeParameterReference typeParameterReference = (kotlin.jvm.internal.TypeParameterReference) other;
            if (kotlin.jvm.internal.Intrinsics.areEqual(this.container, typeParameterReference.container) && kotlin.jvm.internal.Intrinsics.areEqual(getName(), typeParameterReference.getName())) {
                return true;
            }
        }
        return false;
    }

    @Override // kotlin.reflect.KTypeParameter
    @org.jetbrains.annotations.NotNull
    public java.lang.String getName() {
        return this.name;
    }

    @Override // kotlin.reflect.KTypeParameter
    @org.jetbrains.annotations.NotNull
    public java.util.List<kotlin.reflect.KType> getUpperBounds() {
        java.util.List list = this.bounds;
        if (list != null) {
            return list;
        }
        java.util.List<kotlin.reflect.KType> listOf = kotlin.collections.CollectionsKt__CollectionsJVMKt.listOf(kotlin.jvm.internal.Reflection.nullableTypeOf(java.lang.Object.class));
        this.bounds = listOf;
        return listOf;
    }

    @Override // kotlin.reflect.KTypeParameter
    @org.jetbrains.annotations.NotNull
    public kotlin.reflect.KVariance getVariance() {
        return this.variance;
    }

    public int hashCode() {
        java.lang.Object obj = this.container;
        return ((obj != null ? obj.hashCode() : 0) * 31) + getName().hashCode();
    }

    @Override // kotlin.reflect.KTypeParameter
    /* renamed from: isReified, reason: from getter */
    public boolean getIsReified() {
        return this.isReified;
    }

    public final void setUpperBounds(@org.jetbrains.annotations.NotNull java.util.List<? extends kotlin.reflect.KType> upperBounds) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(upperBounds, "upperBounds");
        if (this.bounds == null) {
            this.bounds = upperBounds;
            return;
        }
        throw new java.lang.IllegalStateException(("Upper bounds of type parameter '" + this + "' have already been initialized.").toString());
    }

    @org.jetbrains.annotations.NotNull
    public java.lang.String toString() {
        return INSTANCE.toString(this);
    }
}
