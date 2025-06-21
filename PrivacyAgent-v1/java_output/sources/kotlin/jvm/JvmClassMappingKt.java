package kotlin.jvm;

@kotlin.Metadata(d1 = {"\u0000&\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u001b\n\u0002\b\u0004\u001a!\u0010\u0004\u001a\u00020\u0003\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\u0006\u0012\u0002\b\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005\"-\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00068G¢\u0006\f\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t\"-\u0010\u000e\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0007\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00068F¢\u0006\u0006\u001a\u0004\b\r\u0010\t\"+\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00068F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\t\"+\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00078G¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012\"&\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u00028\u00008Æ\u0002¢\u0006\u0006\u001a\u0004\b\b\u0010\u0014\";\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00060\u0007\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00068Ç\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\u000b\u001a\u0004\b\u0016\u0010\t\"'\u0010\u001b\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0006\"\b\b\u0000\u0010\u0001*\u00020\u0018*\u00028\u00008F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001c"}, d2 = {"", androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "", "", "isArrayOf", "([Ljava/lang/Object;)Z", "Lkotlin/reflect/KClass;", "Ljava/lang/Class;", "getJavaClass", "(Lkotlin/reflect/KClass;)Ljava/lang/Class;", "getJavaClass$annotations", "(Lkotlin/reflect/KClass;)V", com.uc.crashsdk.export.LogType.JAVA_TYPE, "getJavaPrimitiveType", "javaPrimitiveType", "getJavaObjectType", "javaObjectType", "getKotlinClass", "(Ljava/lang/Class;)Lkotlin/reflect/KClass;", "kotlin", "(Ljava/lang/Object;)Ljava/lang/Class;", "javaClass", "getRuntimeClassOfKClassInstance", "getRuntimeClassOfKClassInstance$annotations", "", "getAnnotationClass", "(Ljava/lang/annotation/Annotation;)Lkotlin/reflect/KClass;", "annotationClass", "kotlin-stdlib"}, k = 2, mv = {1, 7, 1})
@kotlin.jvm.JvmName(name = "JvmClassMappingKt")
/* loaded from: classes14.dex */
public final class JvmClassMappingKt {
    @org.jetbrains.annotations.NotNull
    public static final <T extends java.lang.annotation.Annotation> kotlin.reflect.KClass<? extends T> getAnnotationClass(@org.jetbrains.annotations.NotNull T t) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(t, "<this>");
        java.lang.Class<? extends java.lang.annotation.Annotation> annotationType = t.annotationType();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(annotationType, "this as java.lang.annota…otation).annotationType()");
        kotlin.reflect.KClass<? extends T> kotlinClass = getKotlinClass(annotationType);
        kotlin.jvm.internal.Intrinsics.checkNotNull(kotlinClass, "null cannot be cast to non-null type kotlin.reflect.KClass<out T of kotlin.jvm.JvmClassMappingKt.<get-annotationClass>>");
        return kotlinClass;
    }

    @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_7)
    @kotlin.internal.InlineOnly
    public static /* synthetic */ void getDeclaringJavaClass$annotations(java.lang.Enum r0) {
    }

    @org.jetbrains.annotations.NotNull
    public static final <T> java.lang.Class<T> getJavaClass(@org.jetbrains.annotations.NotNull T t) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(t, "<this>");
        java.lang.Class<T> cls = (java.lang.Class<T>) t.getClass();
        kotlin.jvm.internal.Intrinsics.checkNotNull(cls, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-javaClass>>");
        return cls;
    }

    @kotlin.jvm.JvmName(name = "getJavaClass")
    @org.jetbrains.annotations.NotNull
    public static final <T> java.lang.Class<T> getJavaClass(@org.jetbrains.annotations.NotNull kotlin.reflect.KClass<T> kClass) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kClass, "<this>");
        java.lang.Class<T> cls = (java.lang.Class<T>) ((kotlin.jvm.internal.ClassBasedDeclarationContainer) kClass).getJClass();
        kotlin.jvm.internal.Intrinsics.checkNotNull(cls, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-java>>");
        return cls;
    }

    public static /* synthetic */ void getJavaClass$annotations(kotlin.reflect.KClass kClass) {
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    @org.jetbrains.annotations.NotNull
    public static final <T> java.lang.Class<T> getJavaObjectType(@org.jetbrains.annotations.NotNull kotlin.reflect.KClass<T> kClass) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kClass, "<this>");
        java.lang.Class<T> cls = (java.lang.Class<T>) ((kotlin.jvm.internal.ClassBasedDeclarationContainer) kClass).getJClass();
        if (!cls.isPrimitive()) {
            kotlin.jvm.internal.Intrinsics.checkNotNull(cls, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-javaObjectType>>");
            return cls;
        }
        java.lang.String name = cls.getName();
        switch (name.hashCode()) {
            case -1325958191:
                if (name.equals("double")) {
                    cls = (java.lang.Class<T>) java.lang.Double.class;
                    break;
                }
                break;
            case 104431:
                if (name.equals(com.baidu.mobads.sdk.api.IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL)) {
                    cls = (java.lang.Class<T>) java.lang.Integer.class;
                    break;
                }
                break;
            case 3039496:
                if (name.equals("byte")) {
                    cls = (java.lang.Class<T>) java.lang.Byte.class;
                    break;
                }
                break;
            case 3052374:
                if (name.equals("char")) {
                    cls = (java.lang.Class<T>) java.lang.Character.class;
                    break;
                }
                break;
            case 3327612:
                if (name.equals("long")) {
                    cls = (java.lang.Class<T>) java.lang.Long.class;
                    break;
                }
                break;
            case 3625364:
                if (name.equals("void")) {
                    cls = (java.lang.Class<T>) java.lang.Void.class;
                    break;
                }
                break;
            case 64711720:
                if (name.equals("boolean")) {
                    cls = (java.lang.Class<T>) java.lang.Boolean.class;
                    break;
                }
                break;
            case 97526364:
                if (name.equals("float")) {
                    cls = (java.lang.Class<T>) java.lang.Float.class;
                    break;
                }
                break;
            case 109413500:
                if (name.equals("short")) {
                    cls = (java.lang.Class<T>) java.lang.Short.class;
                    break;
                }
                break;
        }
        kotlin.jvm.internal.Intrinsics.checkNotNull(cls, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-javaObjectType>>");
        return cls;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @org.jetbrains.annotations.Nullable
    public static final <T> java.lang.Class<T> getJavaPrimitiveType(@org.jetbrains.annotations.NotNull kotlin.reflect.KClass<T> kClass) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kClass, "<this>");
        java.lang.Class<T> cls = (java.lang.Class<T>) ((kotlin.jvm.internal.ClassBasedDeclarationContainer) kClass).getJClass();
        if (cls.isPrimitive()) {
            kotlin.jvm.internal.Intrinsics.checkNotNull(cls, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-javaPrimitiveType>>");
            return cls;
        }
        java.lang.String name = cls.getName();
        switch (name.hashCode()) {
            case -2056817302:
                if (name.equals("java.lang.Integer")) {
                    return java.lang.Integer.TYPE;
                }
                return null;
            case -527879800:
                if (name.equals("java.lang.Float")) {
                    return java.lang.Float.TYPE;
                }
                return null;
            case -515992664:
                if (name.equals("java.lang.Short")) {
                    return java.lang.Short.TYPE;
                }
                return null;
            case 155276373:
                if (name.equals("java.lang.Character")) {
                    return java.lang.Character.TYPE;
                }
                return null;
            case 344809556:
                if (name.equals("java.lang.Boolean")) {
                    return java.lang.Boolean.TYPE;
                }
                return null;
            case 398507100:
                if (name.equals("java.lang.Byte")) {
                    return java.lang.Byte.TYPE;
                }
                return null;
            case 398795216:
                if (name.equals("java.lang.Long")) {
                    return java.lang.Long.TYPE;
                }
                return null;
            case 399092968:
                if (name.equals("java.lang.Void")) {
                    return java.lang.Void.TYPE;
                }
                return null;
            case 761287205:
                if (name.equals("java.lang.Double")) {
                    return java.lang.Double.TYPE;
                }
                return null;
            default:
                return null;
        }
    }

    @kotlin.jvm.JvmName(name = "getKotlinClass")
    @org.jetbrains.annotations.NotNull
    public static final <T> kotlin.reflect.KClass<T> getKotlinClass(@org.jetbrains.annotations.NotNull java.lang.Class<T> cls) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(cls, "<this>");
        return kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(cls);
    }

    @kotlin.jvm.JvmName(name = "getRuntimeClassOfKClassInstance")
    @org.jetbrains.annotations.NotNull
    public static final <T> java.lang.Class<kotlin.reflect.KClass<T>> getRuntimeClassOfKClassInstance(@org.jetbrains.annotations.NotNull kotlin.reflect.KClass<T> kClass) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kClass, "<this>");
        java.lang.Class<kotlin.reflect.KClass<T>> cls = (java.lang.Class<kotlin.reflect.KClass<T>>) kClass.getClass();
        kotlin.jvm.internal.Intrinsics.checkNotNull(cls, "null cannot be cast to non-null type java.lang.Class<kotlin.reflect.KClass<T of kotlin.jvm.JvmClassMappingKt.<get-javaClass>>>");
        return cls;
    }

    @kotlin.Deprecated(level = kotlin.DeprecationLevel.ERROR, message = "Use 'java' property to get Java class corresponding to this Kotlin class or cast this instance to Any if you really want to get the runtime Java class of this implementation of KClass.", replaceWith = @kotlin.ReplaceWith(expression = "(this as Any).javaClass", imports = {}))
    public static /* synthetic */ void getRuntimeClassOfKClassInstance$annotations(kotlin.reflect.KClass kClass) {
    }

    public static final /* synthetic */ boolean isArrayOf(java.lang.Object[] objArr) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(objArr, "<this>");
        kotlin.jvm.internal.Intrinsics.reifiedOperationMarker(4, androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE);
        return java.lang.Object.class.isAssignableFrom(objArr.getClass().getComponentType());
    }
}
