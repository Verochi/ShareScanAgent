package kotlin.reflect;

@kotlin.Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\u001a\u0016\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0001H\u0003\u001a\"\u0010\n\u001a\u00020\u00032\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0003\u001a\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0003H\u0002\"\u001e\u0010\u0012\u001a\u00020\u0003*\u00020\u00008FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000f\"\u001e\u0010\u0012\u001a\u00020\u0003*\u00020\b8BX\u0083\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Lkotlin/reflect/KType;", "", "forceWrapper", "Ljava/lang/reflect/Type;", "a", "Ljava/lang/Class;", "jClass", "", "Lkotlin/reflect/KTypeProjection;", "arguments", "c", "type", "", "e", "getJavaType", "(Lkotlin/reflect/KType;)Ljava/lang/reflect/Type;", "getJavaType$annotations", "(Lkotlin/reflect/KType;)V", "javaType", "d", "(Lkotlin/reflect/KTypeProjection;)Ljava/lang/reflect/Type;", "(Lkotlin/reflect/KTypeProjection;)V", "kotlin-stdlib"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class TypesJVMKt {

    @kotlin.Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[kotlin.reflect.KVariance.values().length];
            iArr[kotlin.reflect.KVariance.IN.ordinal()] = 1;
            iArr[kotlin.reflect.KVariance.INVARIANT.ordinal()] = 2;
            iArr[kotlin.reflect.KVariance.OUT.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @kotlin.ExperimentalStdlibApi
    public static final java.lang.reflect.Type a(kotlin.reflect.KType kType, boolean z) {
        java.lang.Object singleOrNull;
        kotlin.reflect.KClassifier classifier = kType.getClassifier();
        if (classifier instanceof kotlin.reflect.KTypeParameter) {
            return new kotlin.reflect.TypeVariableImpl((kotlin.reflect.KTypeParameter) classifier);
        }
        if (!(classifier instanceof kotlin.reflect.KClass)) {
            throw new java.lang.UnsupportedOperationException("Unsupported type classifier: " + kType);
        }
        kotlin.reflect.KClass kClass = (kotlin.reflect.KClass) classifier;
        java.lang.Class javaObjectType = z ? kotlin.jvm.JvmClassMappingKt.getJavaObjectType(kClass) : kotlin.jvm.JvmClassMappingKt.getJavaClass(kClass);
        java.util.List<kotlin.reflect.KTypeProjection> arguments = kType.getArguments();
        if (arguments.isEmpty()) {
            return javaObjectType;
        }
        if (!javaObjectType.isArray()) {
            return c(javaObjectType, arguments);
        }
        if (javaObjectType.getComponentType().isPrimitive()) {
            return javaObjectType;
        }
        singleOrNull = kotlin.collections.CollectionsKt___CollectionsKt.singleOrNull((java.util.List<? extends java.lang.Object>) arguments);
        kotlin.reflect.KTypeProjection kTypeProjection = (kotlin.reflect.KTypeProjection) singleOrNull;
        if (kTypeProjection == null) {
            throw new java.lang.IllegalArgumentException("kotlin.Array must have exactly one type argument: " + kType);
        }
        kotlin.reflect.KVariance variance = kTypeProjection.getVariance();
        kotlin.reflect.KType type = kTypeProjection.getType();
        int i = variance == null ? -1 : kotlin.reflect.TypesJVMKt.WhenMappings.$EnumSwitchMapping$0[variance.ordinal()];
        if (i == -1 || i == 1) {
            return javaObjectType;
        }
        if (i != 2 && i != 3) {
            throw new kotlin.NoWhenBranchMatchedException();
        }
        kotlin.jvm.internal.Intrinsics.checkNotNull(type);
        java.lang.reflect.Type b = b(type, false, 1, null);
        return b instanceof java.lang.Class ? javaObjectType : new kotlin.reflect.GenericArrayTypeImpl(b);
    }

    public static /* synthetic */ java.lang.reflect.Type b(kotlin.reflect.KType kType, boolean z, int i, java.lang.Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return a(kType, z);
    }

    @kotlin.ExperimentalStdlibApi
    public static final java.lang.reflect.Type c(java.lang.Class<?> cls, java.util.List<kotlin.reflect.KTypeProjection> list) {
        java.lang.Class<?> declaringClass = cls.getDeclaringClass();
        if (declaringClass == null) {
            java.util.List<kotlin.reflect.KTypeProjection> list2 = list;
            java.util.ArrayList arrayList = new java.util.ArrayList(kotlin.collections.CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10));
            java.util.Iterator<T> it = list2.iterator();
            while (it.hasNext()) {
                arrayList.add(d((kotlin.reflect.KTypeProjection) it.next()));
            }
            return new kotlin.reflect.ParameterizedTypeImpl(cls, null, arrayList);
        }
        if (java.lang.reflect.Modifier.isStatic(cls.getModifiers())) {
            java.util.List<kotlin.reflect.KTypeProjection> list3 = list;
            java.util.ArrayList arrayList2 = new java.util.ArrayList(kotlin.collections.CollectionsKt__IterablesKt.collectionSizeOrDefault(list3, 10));
            java.util.Iterator<T> it2 = list3.iterator();
            while (it2.hasNext()) {
                arrayList2.add(d((kotlin.reflect.KTypeProjection) it2.next()));
            }
            return new kotlin.reflect.ParameterizedTypeImpl(cls, declaringClass, arrayList2);
        }
        int length = cls.getTypeParameters().length;
        java.lang.reflect.Type c = c(declaringClass, list.subList(length, list.size()));
        java.util.List<kotlin.reflect.KTypeProjection> subList = list.subList(0, length);
        java.util.ArrayList arrayList3 = new java.util.ArrayList(kotlin.collections.CollectionsKt__IterablesKt.collectionSizeOrDefault(subList, 10));
        java.util.Iterator<T> it3 = subList.iterator();
        while (it3.hasNext()) {
            arrayList3.add(d((kotlin.reflect.KTypeProjection) it3.next()));
        }
        return new kotlin.reflect.ParameterizedTypeImpl(cls, c, arrayList3);
    }

    public static final java.lang.reflect.Type d(kotlin.reflect.KTypeProjection kTypeProjection) {
        kotlin.reflect.KVariance variance = kTypeProjection.getVariance();
        if (variance == null) {
            return kotlin.reflect.WildcardTypeImpl.u.getSTAR();
        }
        kotlin.reflect.KType type = kTypeProjection.getType();
        kotlin.jvm.internal.Intrinsics.checkNotNull(type);
        int i = kotlin.reflect.TypesJVMKt.WhenMappings.$EnumSwitchMapping$0[variance.ordinal()];
        if (i == 1) {
            return new kotlin.reflect.WildcardTypeImpl(null, a(type, true));
        }
        if (i == 2) {
            return a(type, true);
        }
        if (i == 3) {
            return new kotlin.reflect.WildcardTypeImpl(a(type, true), null);
        }
        throw new kotlin.NoWhenBranchMatchedException();
    }

    public static final java.lang.String e(java.lang.reflect.Type type) {
        java.lang.String name;
        kotlin.sequences.Sequence generateSequence;
        java.lang.Object last;
        int count;
        java.lang.String repeat;
        if (!(type instanceof java.lang.Class)) {
            return type.toString();
        }
        java.lang.Class cls = (java.lang.Class) type;
        if (cls.isArray()) {
            generateSequence = kotlin.sequences.SequencesKt__SequencesKt.generateSequence(type, (kotlin.jvm.functions.Function1<? super java.lang.reflect.Type, ? extends java.lang.reflect.Type>) ((kotlin.jvm.functions.Function1<? super java.lang.Object, ? extends java.lang.Object>) kotlin.reflect.TypesJVMKt$typeToString$unwrap$1.INSTANCE));
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            last = kotlin.sequences.SequencesKt___SequencesKt.last(generateSequence);
            sb.append(((java.lang.Class) last).getName());
            count = kotlin.sequences.SequencesKt___SequencesKt.count(generateSequence);
            repeat = kotlin.text.StringsKt__StringsJVMKt.repeat("[]", count);
            sb.append(repeat);
            name = sb.toString();
        } else {
            name = cls.getName();
        }
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(name, "{\n        if (type.isArr…   } else type.name\n    }");
        return name;
    }

    @org.jetbrains.annotations.NotNull
    public static final java.lang.reflect.Type getJavaType(@org.jetbrains.annotations.NotNull kotlin.reflect.KType kType) {
        java.lang.reflect.Type javaType;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kType, "<this>");
        return (!(kType instanceof kotlin.jvm.internal.KTypeBase) || (javaType = ((kotlin.jvm.internal.KTypeBase) kType).getJavaType()) == null) ? b(kType, false, 1, null) : javaType;
    }

    @kotlin.internal.LowPriorityInOverloadResolution
    @kotlin.SinceKotlin(version = "1.4")
    @kotlin.ExperimentalStdlibApi
    public static /* synthetic */ void getJavaType$annotations(kotlin.reflect.KType kType) {
    }
}
