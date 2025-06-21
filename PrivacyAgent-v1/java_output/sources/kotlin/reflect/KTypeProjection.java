package kotlin.reflect;

@kotlin.SinceKotlin(version = "1.1")
@kotlin.Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\b\u0087\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u001b\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u000b\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003J!\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\t\u0010\f\u001a\u00020\u000bHÖ\u0001J\u0013\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0019\u0010\t\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"Lkotlin/reflect/KTypeProjection;", "", "", "toString", "Lkotlin/reflect/KVariance;", "component1", "Lkotlin/reflect/KType;", "component2", "variance", "type", com.sensorsdata.sf.ui.view.UIProperty.action_type_copy, "", com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_HASHCODE, "other", "", "equals", "a", "Lkotlin/reflect/KVariance;", "getVariance", "()Lkotlin/reflect/KVariance;", "b", "Lkotlin/reflect/KType;", "getType", "()Lkotlin/reflect/KType;", "<init>", "(Lkotlin/reflect/KVariance;Lkotlin/reflect/KType;)V", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final /* data */ class KTypeProjection {

    /* renamed from: Companion, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public static final kotlin.reflect.KTypeProjection.Companion INSTANCE = new kotlin.reflect.KTypeProjection.Companion(null);

    @kotlin.jvm.JvmField
    @org.jetbrains.annotations.NotNull
    public static final kotlin.reflect.KTypeProjection star = new kotlin.reflect.KTypeProjection(null, null);

    /* renamed from: a, reason: from kotlin metadata */
    @org.jetbrains.annotations.Nullable
    public final kotlin.reflect.KVariance variance;

    /* renamed from: b, reason: from kotlin metadata */
    @org.jetbrains.annotations.Nullable
    public final kotlin.reflect.KType type;

    @kotlin.Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0007R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u00020\u00048\u0000X\u0081\u0004¢\u0006\b\n\u0000\u0012\u0004\b\b\u0010\u0002¨\u0006\u000e"}, d2 = {"Lkotlin/reflect/KTypeProjection$Companion;", "", "()V", "STAR", "Lkotlin/reflect/KTypeProjection;", "getSTAR", "()Lkotlin/reflect/KTypeProjection;", "star", "getStar$annotations", "contravariant", "type", "Lkotlin/reflect/KType;", "covariant", "invariant", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @kotlin.PublishedApi
        public static /* synthetic */ void getStar$annotations() {
        }

        @kotlin.jvm.JvmStatic
        @org.jetbrains.annotations.NotNull
        public final kotlin.reflect.KTypeProjection contravariant(@org.jetbrains.annotations.NotNull kotlin.reflect.KType type) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(type, "type");
            return new kotlin.reflect.KTypeProjection(kotlin.reflect.KVariance.IN, type);
        }

        @kotlin.jvm.JvmStatic
        @org.jetbrains.annotations.NotNull
        public final kotlin.reflect.KTypeProjection covariant(@org.jetbrains.annotations.NotNull kotlin.reflect.KType type) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(type, "type");
            return new kotlin.reflect.KTypeProjection(kotlin.reflect.KVariance.OUT, type);
        }

        @org.jetbrains.annotations.NotNull
        public final kotlin.reflect.KTypeProjection getSTAR() {
            return kotlin.reflect.KTypeProjection.star;
        }

        @kotlin.jvm.JvmStatic
        @org.jetbrains.annotations.NotNull
        public final kotlin.reflect.KTypeProjection invariant(@org.jetbrains.annotations.NotNull kotlin.reflect.KType type) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(type, "type");
            return new kotlin.reflect.KTypeProjection(kotlin.reflect.KVariance.INVARIANT, type);
        }
    }

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

    public KTypeProjection(@org.jetbrains.annotations.Nullable kotlin.reflect.KVariance kVariance, @org.jetbrains.annotations.Nullable kotlin.reflect.KType kType) {
        java.lang.String str;
        this.variance = kVariance;
        this.type = kType;
        if ((kVariance == null) == (kType == null)) {
            return;
        }
        if (kVariance == null) {
            str = "Star projection must have no type specified.";
        } else {
            str = "The projection variance " + kVariance + " requires type to be specified.";
        }
        throw new java.lang.IllegalArgumentException(str.toString());
    }

    @kotlin.jvm.JvmStatic
    @org.jetbrains.annotations.NotNull
    public static final kotlin.reflect.KTypeProjection contravariant(@org.jetbrains.annotations.NotNull kotlin.reflect.KType kType) {
        return INSTANCE.contravariant(kType);
    }

    public static /* synthetic */ kotlin.reflect.KTypeProjection copy$default(kotlin.reflect.KTypeProjection kTypeProjection, kotlin.reflect.KVariance kVariance, kotlin.reflect.KType kType, int i, java.lang.Object obj) {
        if ((i & 1) != 0) {
            kVariance = kTypeProjection.variance;
        }
        if ((i & 2) != 0) {
            kType = kTypeProjection.type;
        }
        return kTypeProjection.copy(kVariance, kType);
    }

    @kotlin.jvm.JvmStatic
    @org.jetbrains.annotations.NotNull
    public static final kotlin.reflect.KTypeProjection covariant(@org.jetbrains.annotations.NotNull kotlin.reflect.KType kType) {
        return INSTANCE.covariant(kType);
    }

    @kotlin.jvm.JvmStatic
    @org.jetbrains.annotations.NotNull
    public static final kotlin.reflect.KTypeProjection invariant(@org.jetbrains.annotations.NotNull kotlin.reflect.KType kType) {
        return INSTANCE.invariant(kType);
    }

    @org.jetbrains.annotations.Nullable
    /* renamed from: component1, reason: from getter */
    public final kotlin.reflect.KVariance getVariance() {
        return this.variance;
    }

    @org.jetbrains.annotations.Nullable
    /* renamed from: component2, reason: from getter */
    public final kotlin.reflect.KType getType() {
        return this.type;
    }

    @org.jetbrains.annotations.NotNull
    public final kotlin.reflect.KTypeProjection copy(@org.jetbrains.annotations.Nullable kotlin.reflect.KVariance variance, @org.jetbrains.annotations.Nullable kotlin.reflect.KType type) {
        return new kotlin.reflect.KTypeProjection(variance, type);
    }

    public boolean equals(@org.jetbrains.annotations.Nullable java.lang.Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof kotlin.reflect.KTypeProjection)) {
            return false;
        }
        kotlin.reflect.KTypeProjection kTypeProjection = (kotlin.reflect.KTypeProjection) other;
        return this.variance == kTypeProjection.variance && kotlin.jvm.internal.Intrinsics.areEqual(this.type, kTypeProjection.type);
    }

    @org.jetbrains.annotations.Nullable
    public final kotlin.reflect.KType getType() {
        return this.type;
    }

    @org.jetbrains.annotations.Nullable
    public final kotlin.reflect.KVariance getVariance() {
        return this.variance;
    }

    public int hashCode() {
        kotlin.reflect.KVariance kVariance = this.variance;
        int hashCode = (kVariance == null ? 0 : kVariance.hashCode()) * 31;
        kotlin.reflect.KType kType = this.type;
        return hashCode + (kType != null ? kType.hashCode() : 0);
    }

    @org.jetbrains.annotations.NotNull
    public java.lang.String toString() {
        kotlin.reflect.KVariance kVariance = this.variance;
        int i = kVariance == null ? -1 : kotlin.reflect.KTypeProjection.WhenMappings.$EnumSwitchMapping$0[kVariance.ordinal()];
        if (i == -1) {
            return "*";
        }
        if (i == 1) {
            return java.lang.String.valueOf(this.type);
        }
        if (i == 2) {
            return "in " + this.type;
        }
        if (i != 3) {
            throw new kotlin.NoWhenBranchMatchedException();
        }
        return "out " + this.type;
    }
}
