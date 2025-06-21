package kotlin.jvm.internal;

@kotlin.SinceKotlin(version = "1.4")
@kotlin.Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0012\n\u0002\u0010\u001b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 32\u00020\u0001:\u00013B1\b\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\f0\u0014\u0012\b\u0010 \u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010&\u001a\u00020\u0006¢\u0006\u0004\b0\u00101B'\b\u0016\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\f0\u0014\u0012\u0006\u0010*\u001a\u00020\u0004¢\u0006\u0004\b0\u00102J\u0013\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0004H\u0002J\f\u0010\r\u001a\u00020\b*\u00020\fH\u0002R\u001a\u0010\u0013\u001a\u00020\u000e8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R \u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\f0\u00148\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\"\u0010 \u001a\u0004\u0018\u00010\u00018\u0000X\u0081\u0004¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u0012\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001c\u0010\u001dR \u0010&\u001a\u00020\u00068\u0000X\u0081\u0004¢\u0006\u0012\n\u0004\b!\u0010\"\u0012\u0004\b%\u0010\u001f\u001a\u0004\b#\u0010$R\u001a\u0010)\u001a\b\u0012\u0004\u0012\u00020'0\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b(\u0010\u0018R\u0014\u0010*\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b*\u0010+R\u001c\u0010/\u001a\u00020\b*\u0006\u0012\u0002\b\u00030,8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b-\u0010.¨\u00064"}, d2 = {"Lkotlin/jvm/internal/TypeReference;", "Lkotlin/reflect/KType;", "", "other", "", "equals", "", com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_HASHCODE, "", "toString", "convertPrimitiveToWrapper", "b", "Lkotlin/reflect/KTypeProjection;", "a", "Lkotlin/reflect/KClassifier;", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.AD_COUNT, "Lkotlin/reflect/KClassifier;", "getClassifier", "()Lkotlin/reflect/KClassifier;", "classifier", "", "t", "Ljava/util/List;", "getArguments", "()Ljava/util/List;", "arguments", com.umeng.analytics.pro.bo.aN, "Lkotlin/reflect/KType;", "getPlatformTypeUpperBound$kotlin_stdlib", "()Lkotlin/reflect/KType;", "getPlatformTypeUpperBound$kotlin_stdlib$annotations", "()V", "platformTypeUpperBound", "v", "I", "getFlags$kotlin_stdlib", "()I", "getFlags$kotlin_stdlib$annotations", "flags", "", "getAnnotations", "annotations", "isMarkedNullable", "()Z", "Ljava/lang/Class;", "c", "(Ljava/lang/Class;)Ljava/lang/String;", "arrayClassName", "<init>", "(Lkotlin/reflect/KClassifier;Ljava/util/List;Lkotlin/reflect/KType;I)V", "(Lkotlin/reflect/KClassifier;Ljava/util/List;Z)V", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class TypeReference implements kotlin.reflect.KType {
    public static final int IS_MARKED_NULLABLE = 1;
    public static final int IS_MUTABLE_COLLECTION_TYPE = 2;
    public static final int IS_NOTHING_TYPE = 4;

    /* renamed from: n, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public final kotlin.reflect.KClassifier classifier;

    /* renamed from: t, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public final java.util.List<kotlin.reflect.KTypeProjection> arguments;

    /* renamed from: u, reason: from kotlin metadata */
    @org.jetbrains.annotations.Nullable
    public final kotlin.reflect.KType platformTypeUpperBound;

    /* renamed from: v, reason: from kotlin metadata */
    public final int flags;

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

    @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_6)
    public TypeReference(@org.jetbrains.annotations.NotNull kotlin.reflect.KClassifier classifier, @org.jetbrains.annotations.NotNull java.util.List<kotlin.reflect.KTypeProjection> arguments, @org.jetbrains.annotations.Nullable kotlin.reflect.KType kType, int i) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(classifier, "classifier");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(arguments, "arguments");
        this.classifier = classifier;
        this.arguments = arguments;
        this.platformTypeUpperBound = kType;
        this.flags = i;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TypeReference(@org.jetbrains.annotations.NotNull kotlin.reflect.KClassifier classifier, @org.jetbrains.annotations.NotNull java.util.List<kotlin.reflect.KTypeProjection> arguments, boolean z) {
        this(classifier, arguments, null, z ? 1 : 0);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(classifier, "classifier");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(arguments, "arguments");
    }

    @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_6)
    public static /* synthetic */ void getFlags$kotlin_stdlib$annotations() {
    }

    @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_6)
    public static /* synthetic */ void getPlatformTypeUpperBound$kotlin_stdlib$annotations() {
    }

    public final java.lang.String a(kotlin.reflect.KTypeProjection kTypeProjection) {
        java.lang.String valueOf;
        if (kTypeProjection.getVariance() == null) {
            return "*";
        }
        kotlin.reflect.KType type = kTypeProjection.getType();
        kotlin.jvm.internal.TypeReference typeReference = type instanceof kotlin.jvm.internal.TypeReference ? (kotlin.jvm.internal.TypeReference) type : null;
        if (typeReference == null || (valueOf = typeReference.b(true)) == null) {
            valueOf = java.lang.String.valueOf(kTypeProjection.getType());
        }
        int i = kotlin.jvm.internal.TypeReference.WhenMappings.$EnumSwitchMapping$0[kTypeProjection.getVariance().ordinal()];
        if (i == 1) {
            return valueOf;
        }
        if (i == 2) {
            return "in " + valueOf;
        }
        if (i != 3) {
            throw new kotlin.NoWhenBranchMatchedException();
        }
        return "out " + valueOf;
    }

    public final java.lang.String b(boolean convertPrimitiveToWrapper) {
        java.lang.String name;
        kotlin.reflect.KClassifier classifier = getClassifier();
        kotlin.reflect.KClass kClass = classifier instanceof kotlin.reflect.KClass ? (kotlin.reflect.KClass) classifier : null;
        java.lang.Class<?> javaClass = kClass != null ? kotlin.jvm.JvmClassMappingKt.getJavaClass(kClass) : null;
        if (javaClass == null) {
            name = getClassifier().toString();
        } else if ((this.flags & 4) != 0) {
            name = "kotlin.Nothing";
        } else if (javaClass.isArray()) {
            name = c(javaClass);
        } else if (convertPrimitiveToWrapper && javaClass.isPrimitive()) {
            kotlin.reflect.KClassifier classifier2 = getClassifier();
            kotlin.jvm.internal.Intrinsics.checkNotNull(classifier2, "null cannot be cast to non-null type kotlin.reflect.KClass<*>");
            name = kotlin.jvm.JvmClassMappingKt.getJavaObjectType((kotlin.reflect.KClass) classifier2).getName();
        } else {
            name = javaClass.getName();
        }
        java.lang.String str = name + (getArguments().isEmpty() ? "" : kotlin.collections.CollectionsKt___CollectionsKt.joinToString$default(getArguments(), ", ", "<", ">", 0, null, new kotlin.jvm.internal.TypeReference$asString$args$1(this), 24, null)) + (isMarkedNullable() ? "?" : "");
        kotlin.reflect.KType kType = this.platformTypeUpperBound;
        if (!(kType instanceof kotlin.jvm.internal.TypeReference)) {
            return str;
        }
        java.lang.String b = ((kotlin.jvm.internal.TypeReference) kType).b(true);
        if (kotlin.jvm.internal.Intrinsics.areEqual(b, str)) {
            return str;
        }
        if (kotlin.jvm.internal.Intrinsics.areEqual(b, str + '?')) {
            return str + '!';
        }
        return '(' + str + ".." + b + ')';
    }

    public final java.lang.String c(java.lang.Class<?> cls) {
        return kotlin.jvm.internal.Intrinsics.areEqual(cls, boolean[].class) ? "kotlin.BooleanArray" : kotlin.jvm.internal.Intrinsics.areEqual(cls, char[].class) ? "kotlin.CharArray" : kotlin.jvm.internal.Intrinsics.areEqual(cls, byte[].class) ? "kotlin.ByteArray" : kotlin.jvm.internal.Intrinsics.areEqual(cls, short[].class) ? "kotlin.ShortArray" : kotlin.jvm.internal.Intrinsics.areEqual(cls, int[].class) ? "kotlin.IntArray" : kotlin.jvm.internal.Intrinsics.areEqual(cls, float[].class) ? "kotlin.FloatArray" : kotlin.jvm.internal.Intrinsics.areEqual(cls, long[].class) ? "kotlin.LongArray" : kotlin.jvm.internal.Intrinsics.areEqual(cls, double[].class) ? "kotlin.DoubleArray" : "kotlin.Array";
    }

    public boolean equals(@org.jetbrains.annotations.Nullable java.lang.Object other) {
        if (other instanceof kotlin.jvm.internal.TypeReference) {
            kotlin.jvm.internal.TypeReference typeReference = (kotlin.jvm.internal.TypeReference) other;
            if (kotlin.jvm.internal.Intrinsics.areEqual(getClassifier(), typeReference.getClassifier()) && kotlin.jvm.internal.Intrinsics.areEqual(getArguments(), typeReference.getArguments()) && kotlin.jvm.internal.Intrinsics.areEqual(this.platformTypeUpperBound, typeReference.platformTypeUpperBound) && this.flags == typeReference.flags) {
                return true;
            }
        }
        return false;
    }

    @Override // kotlin.reflect.KAnnotatedElement
    @org.jetbrains.annotations.NotNull
    public java.util.List<java.lang.annotation.Annotation> getAnnotations() {
        return kotlin.collections.CollectionsKt__CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.KType
    @org.jetbrains.annotations.NotNull
    public java.util.List<kotlin.reflect.KTypeProjection> getArguments() {
        return this.arguments;
    }

    @Override // kotlin.reflect.KType
    @org.jetbrains.annotations.NotNull
    public kotlin.reflect.KClassifier getClassifier() {
        return this.classifier;
    }

    /* renamed from: getFlags$kotlin_stdlib, reason: from getter */
    public final int getFlags() {
        return this.flags;
    }

    @org.jetbrains.annotations.Nullable
    /* renamed from: getPlatformTypeUpperBound$kotlin_stdlib, reason: from getter */
    public final kotlin.reflect.KType getPlatformTypeUpperBound() {
        return this.platformTypeUpperBound;
    }

    public int hashCode() {
        return (((getClassifier().hashCode() * 31) + getArguments().hashCode()) * 31) + java.lang.Integer.valueOf(this.flags).hashCode();
    }

    @Override // kotlin.reflect.KType
    public boolean isMarkedNullable() {
        return (this.flags & 1) != 0;
    }

    @org.jetbrains.annotations.NotNull
    public java.lang.String toString() {
        return b(false) + " (Kotlin reflection is not available)";
    }
}
