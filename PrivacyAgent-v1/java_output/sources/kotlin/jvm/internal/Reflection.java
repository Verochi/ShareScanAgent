package kotlin.jvm.internal;

/* loaded from: classes14.dex */
public class Reflection {
    public static final kotlin.jvm.internal.ReflectionFactory a;
    public static final kotlin.reflect.KClass[] b;

    static {
        kotlin.jvm.internal.ReflectionFactory reflectionFactory = null;
        try {
            reflectionFactory = (kotlin.jvm.internal.ReflectionFactory) java.lang.Class.forName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl").newInstance();
        } catch (java.lang.ClassCastException | java.lang.ClassNotFoundException | java.lang.IllegalAccessException | java.lang.InstantiationException unused) {
        }
        if (reflectionFactory == null) {
            reflectionFactory = new kotlin.jvm.internal.ReflectionFactory();
        }
        a = reflectionFactory;
        b = new kotlin.reflect.KClass[0];
    }

    public static kotlin.reflect.KClass createKotlinClass(java.lang.Class cls) {
        return a.createKotlinClass(cls);
    }

    public static kotlin.reflect.KClass createKotlinClass(java.lang.Class cls, java.lang.String str) {
        return a.createKotlinClass(cls, str);
    }

    public static kotlin.reflect.KFunction function(kotlin.jvm.internal.FunctionReference functionReference) {
        return a.function(functionReference);
    }

    public static kotlin.reflect.KClass getOrCreateKotlinClass(java.lang.Class cls) {
        return a.getOrCreateKotlinClass(cls);
    }

    public static kotlin.reflect.KClass getOrCreateKotlinClass(java.lang.Class cls, java.lang.String str) {
        return a.getOrCreateKotlinClass(cls, str);
    }

    public static kotlin.reflect.KClass[] getOrCreateKotlinClasses(java.lang.Class[] clsArr) {
        int length = clsArr.length;
        if (length == 0) {
            return b;
        }
        kotlin.reflect.KClass[] kClassArr = new kotlin.reflect.KClass[length];
        for (int i = 0; i < length; i++) {
            kClassArr[i] = getOrCreateKotlinClass(clsArr[i]);
        }
        return kClassArr;
    }

    @kotlin.SinceKotlin(version = "1.4")
    public static kotlin.reflect.KDeclarationContainer getOrCreateKotlinPackage(java.lang.Class cls) {
        return a.getOrCreateKotlinPackage(cls, "");
    }

    public static kotlin.reflect.KDeclarationContainer getOrCreateKotlinPackage(java.lang.Class cls, java.lang.String str) {
        return a.getOrCreateKotlinPackage(cls, str);
    }

    @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_6)
    public static kotlin.reflect.KType mutableCollectionType(kotlin.reflect.KType kType) {
        return a.mutableCollectionType(kType);
    }

    public static kotlin.reflect.KMutableProperty0 mutableProperty0(kotlin.jvm.internal.MutablePropertyReference0 mutablePropertyReference0) {
        return a.mutableProperty0(mutablePropertyReference0);
    }

    public static kotlin.reflect.KMutableProperty1 mutableProperty1(kotlin.jvm.internal.MutablePropertyReference1 mutablePropertyReference1) {
        return a.mutableProperty1(mutablePropertyReference1);
    }

    public static kotlin.reflect.KMutableProperty2 mutableProperty2(kotlin.jvm.internal.MutablePropertyReference2 mutablePropertyReference2) {
        return a.mutableProperty2(mutablePropertyReference2);
    }

    @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_6)
    public static kotlin.reflect.KType nothingType(kotlin.reflect.KType kType) {
        return a.nothingType(kType);
    }

    @kotlin.SinceKotlin(version = "1.4")
    public static kotlin.reflect.KType nullableTypeOf(java.lang.Class cls) {
        return a.typeOf(getOrCreateKotlinClass(cls), java.util.Collections.emptyList(), true);
    }

    @kotlin.SinceKotlin(version = "1.4")
    public static kotlin.reflect.KType nullableTypeOf(java.lang.Class cls, kotlin.reflect.KTypeProjection kTypeProjection) {
        return a.typeOf(getOrCreateKotlinClass(cls), java.util.Collections.singletonList(kTypeProjection), true);
    }

    @kotlin.SinceKotlin(version = "1.4")
    public static kotlin.reflect.KType nullableTypeOf(java.lang.Class cls, kotlin.reflect.KTypeProjection kTypeProjection, kotlin.reflect.KTypeProjection kTypeProjection2) {
        return a.typeOf(getOrCreateKotlinClass(cls), java.util.Arrays.asList(kTypeProjection, kTypeProjection2), true);
    }

    @kotlin.SinceKotlin(version = "1.4")
    public static kotlin.reflect.KType nullableTypeOf(java.lang.Class cls, kotlin.reflect.KTypeProjection... kTypeProjectionArr) {
        return a.typeOf(getOrCreateKotlinClass(cls), kotlin.collections.ArraysKt___ArraysKt.toList(kTypeProjectionArr), true);
    }

    @kotlin.SinceKotlin(version = "1.4")
    public static kotlin.reflect.KType nullableTypeOf(kotlin.reflect.KClassifier kClassifier) {
        return a.typeOf(kClassifier, java.util.Collections.emptyList(), true);
    }

    @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_6)
    public static kotlin.reflect.KType platformType(kotlin.reflect.KType kType, kotlin.reflect.KType kType2) {
        return a.platformType(kType, kType2);
    }

    public static kotlin.reflect.KProperty0 property0(kotlin.jvm.internal.PropertyReference0 propertyReference0) {
        return a.property0(propertyReference0);
    }

    public static kotlin.reflect.KProperty1 property1(kotlin.jvm.internal.PropertyReference1 propertyReference1) {
        return a.property1(propertyReference1);
    }

    public static kotlin.reflect.KProperty2 property2(kotlin.jvm.internal.PropertyReference2 propertyReference2) {
        return a.property2(propertyReference2);
    }

    @kotlin.SinceKotlin(version = "1.3")
    public static java.lang.String renderLambdaToString(kotlin.jvm.internal.FunctionBase functionBase) {
        return a.renderLambdaToString(functionBase);
    }

    @kotlin.SinceKotlin(version = "1.1")
    public static java.lang.String renderLambdaToString(kotlin.jvm.internal.Lambda lambda) {
        return a.renderLambdaToString(lambda);
    }

    @kotlin.SinceKotlin(version = "1.4")
    public static void setUpperBounds(kotlin.reflect.KTypeParameter kTypeParameter, kotlin.reflect.KType kType) {
        a.setUpperBounds(kTypeParameter, java.util.Collections.singletonList(kType));
    }

    @kotlin.SinceKotlin(version = "1.4")
    public static void setUpperBounds(kotlin.reflect.KTypeParameter kTypeParameter, kotlin.reflect.KType... kTypeArr) {
        a.setUpperBounds(kTypeParameter, kotlin.collections.ArraysKt___ArraysKt.toList(kTypeArr));
    }

    @kotlin.SinceKotlin(version = "1.4")
    public static kotlin.reflect.KType typeOf(java.lang.Class cls) {
        return a.typeOf(getOrCreateKotlinClass(cls), java.util.Collections.emptyList(), false);
    }

    @kotlin.SinceKotlin(version = "1.4")
    public static kotlin.reflect.KType typeOf(java.lang.Class cls, kotlin.reflect.KTypeProjection kTypeProjection) {
        return a.typeOf(getOrCreateKotlinClass(cls), java.util.Collections.singletonList(kTypeProjection), false);
    }

    @kotlin.SinceKotlin(version = "1.4")
    public static kotlin.reflect.KType typeOf(java.lang.Class cls, kotlin.reflect.KTypeProjection kTypeProjection, kotlin.reflect.KTypeProjection kTypeProjection2) {
        return a.typeOf(getOrCreateKotlinClass(cls), java.util.Arrays.asList(kTypeProjection, kTypeProjection2), false);
    }

    @kotlin.SinceKotlin(version = "1.4")
    public static kotlin.reflect.KType typeOf(java.lang.Class cls, kotlin.reflect.KTypeProjection... kTypeProjectionArr) {
        return a.typeOf(getOrCreateKotlinClass(cls), kotlin.collections.ArraysKt___ArraysKt.toList(kTypeProjectionArr), false);
    }

    @kotlin.SinceKotlin(version = "1.4")
    public static kotlin.reflect.KType typeOf(kotlin.reflect.KClassifier kClassifier) {
        return a.typeOf(kClassifier, java.util.Collections.emptyList(), false);
    }

    @kotlin.SinceKotlin(version = "1.4")
    public static kotlin.reflect.KTypeParameter typeParameter(java.lang.Object obj, java.lang.String str, kotlin.reflect.KVariance kVariance, boolean z) {
        return a.typeParameter(obj, str, kVariance, z);
    }
}
