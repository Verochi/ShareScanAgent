package com.badlogic.gdx.utils.reflect;

/* loaded from: classes12.dex */
public final class ClassReflection {
    public static java.lang.Class forName(java.lang.String str) throws com.badlogic.gdx.utils.reflect.ReflectionException {
        try {
            return java.lang.Class.forName(str);
        } catch (java.lang.ClassNotFoundException e) {
            throw new com.badlogic.gdx.utils.reflect.ReflectionException(org.apache.tools.ant.taskdefs.rmic.RmicAdapterFactory.ERROR_UNKNOWN_COMPILER + str, e);
        }
    }

    public static com.badlogic.gdx.utils.reflect.Annotation getAnnotation(java.lang.Class cls, java.lang.Class<? extends java.lang.annotation.Annotation> cls2) {
        java.lang.annotation.Annotation annotation = cls.getAnnotation(cls2);
        if (annotation != null) {
            return new com.badlogic.gdx.utils.reflect.Annotation(annotation);
        }
        return null;
    }

    public static com.badlogic.gdx.utils.reflect.Annotation[] getAnnotations(java.lang.Class cls) {
        java.lang.annotation.Annotation[] annotations = cls.getAnnotations();
        com.badlogic.gdx.utils.reflect.Annotation[] annotationArr = new com.badlogic.gdx.utils.reflect.Annotation[annotations.length];
        for (int i = 0; i < annotations.length; i++) {
            annotationArr[i] = new com.badlogic.gdx.utils.reflect.Annotation(annotations[i]);
        }
        return annotationArr;
    }

    public static java.lang.Class getComponentType(java.lang.Class cls) {
        return cls.getComponentType();
    }

    public static com.badlogic.gdx.utils.reflect.Constructor getConstructor(java.lang.Class cls, java.lang.Class... clsArr) throws com.badlogic.gdx.utils.reflect.ReflectionException {
        try {
            return new com.badlogic.gdx.utils.reflect.Constructor(cls.getConstructor(clsArr));
        } catch (java.lang.NoSuchMethodException e) {
            throw new com.badlogic.gdx.utils.reflect.ReflectionException("Constructor not found for class: " + cls.getName(), e);
        } catch (java.lang.SecurityException e2) {
            throw new com.badlogic.gdx.utils.reflect.ReflectionException("Security violation occurred while getting constructor for class: '" + cls.getName() + "'.", e2);
        }
    }

    public static com.badlogic.gdx.utils.reflect.Constructor[] getConstructors(java.lang.Class cls) {
        java.lang.reflect.Constructor<?>[] constructors = cls.getConstructors();
        com.badlogic.gdx.utils.reflect.Constructor[] constructorArr = new com.badlogic.gdx.utils.reflect.Constructor[constructors.length];
        int length = constructors.length;
        for (int i = 0; i < length; i++) {
            constructorArr[i] = new com.badlogic.gdx.utils.reflect.Constructor(constructors[i]);
        }
        return constructorArr;
    }

    public static com.badlogic.gdx.utils.reflect.Annotation getDeclaredAnnotation(java.lang.Class cls, java.lang.Class<? extends java.lang.annotation.Annotation> cls2) {
        for (java.lang.annotation.Annotation annotation : cls.getDeclaredAnnotations()) {
            if (annotation.annotationType().equals(cls2)) {
                return new com.badlogic.gdx.utils.reflect.Annotation(annotation);
            }
        }
        return null;
    }

    public static com.badlogic.gdx.utils.reflect.Annotation[] getDeclaredAnnotations(java.lang.Class cls) {
        java.lang.annotation.Annotation[] declaredAnnotations = cls.getDeclaredAnnotations();
        com.badlogic.gdx.utils.reflect.Annotation[] annotationArr = new com.badlogic.gdx.utils.reflect.Annotation[declaredAnnotations.length];
        for (int i = 0; i < declaredAnnotations.length; i++) {
            annotationArr[i] = new com.badlogic.gdx.utils.reflect.Annotation(declaredAnnotations[i]);
        }
        return annotationArr;
    }

    public static com.badlogic.gdx.utils.reflect.Constructor getDeclaredConstructor(java.lang.Class cls, java.lang.Class... clsArr) throws com.badlogic.gdx.utils.reflect.ReflectionException {
        try {
            return new com.badlogic.gdx.utils.reflect.Constructor(cls.getDeclaredConstructor(clsArr));
        } catch (java.lang.NoSuchMethodException e) {
            throw new com.badlogic.gdx.utils.reflect.ReflectionException("Constructor not found for class: " + cls.getName(), e);
        } catch (java.lang.SecurityException e2) {
            throw new com.badlogic.gdx.utils.reflect.ReflectionException("Security violation while getting constructor for class: " + cls.getName(), e2);
        }
    }

    public static com.badlogic.gdx.utils.reflect.Field getDeclaredField(java.lang.Class cls, java.lang.String str) throws com.badlogic.gdx.utils.reflect.ReflectionException {
        try {
            return new com.badlogic.gdx.utils.reflect.Field(cls.getDeclaredField(str));
        } catch (java.lang.NoSuchFieldException e) {
            throw new com.badlogic.gdx.utils.reflect.ReflectionException("Field not found: " + str + ", for class: " + cls.getName(), e);
        } catch (java.lang.SecurityException e2) {
            throw new com.badlogic.gdx.utils.reflect.ReflectionException("Security violation while getting field: " + str + ", for class: " + cls.getName(), e2);
        }
    }

    public static com.badlogic.gdx.utils.reflect.Field[] getDeclaredFields(java.lang.Class cls) {
        java.lang.reflect.Field[] declaredFields = cls.getDeclaredFields();
        com.badlogic.gdx.utils.reflect.Field[] fieldArr = new com.badlogic.gdx.utils.reflect.Field[declaredFields.length];
        int length = declaredFields.length;
        for (int i = 0; i < length; i++) {
            fieldArr[i] = new com.badlogic.gdx.utils.reflect.Field(declaredFields[i]);
        }
        return fieldArr;
    }

    public static com.badlogic.gdx.utils.reflect.Method getDeclaredMethod(java.lang.Class cls, java.lang.String str, java.lang.Class... clsArr) throws com.badlogic.gdx.utils.reflect.ReflectionException {
        try {
            return new com.badlogic.gdx.utils.reflect.Method(cls.getDeclaredMethod(str, clsArr));
        } catch (java.lang.NoSuchMethodException e) {
            throw new com.badlogic.gdx.utils.reflect.ReflectionException("Method not found: " + str + ", for class: " + cls.getName(), e);
        } catch (java.lang.SecurityException e2) {
            throw new com.badlogic.gdx.utils.reflect.ReflectionException("Security violation while getting method: " + str + ", for class: " + cls.getName(), e2);
        }
    }

    public static com.badlogic.gdx.utils.reflect.Method[] getDeclaredMethods(java.lang.Class cls) {
        java.lang.reflect.Method[] declaredMethods = cls.getDeclaredMethods();
        com.badlogic.gdx.utils.reflect.Method[] methodArr = new com.badlogic.gdx.utils.reflect.Method[declaredMethods.length];
        int length = declaredMethods.length;
        for (int i = 0; i < length; i++) {
            methodArr[i] = new com.badlogic.gdx.utils.reflect.Method(declaredMethods[i]);
        }
        return methodArr;
    }

    public static java.lang.Object[] getEnumConstants(java.lang.Class cls) {
        return cls.getEnumConstants();
    }

    public static com.badlogic.gdx.utils.reflect.Field getField(java.lang.Class cls, java.lang.String str) throws com.badlogic.gdx.utils.reflect.ReflectionException {
        try {
            return new com.badlogic.gdx.utils.reflect.Field(cls.getField(str));
        } catch (java.lang.NoSuchFieldException e) {
            throw new com.badlogic.gdx.utils.reflect.ReflectionException("Field not found: " + str + ", for class: " + cls.getName(), e);
        } catch (java.lang.SecurityException e2) {
            throw new com.badlogic.gdx.utils.reflect.ReflectionException("Security violation while getting field: " + str + ", for class: " + cls.getName(), e2);
        }
    }

    public static com.badlogic.gdx.utils.reflect.Field[] getFields(java.lang.Class cls) {
        java.lang.reflect.Field[] fields = cls.getFields();
        com.badlogic.gdx.utils.reflect.Field[] fieldArr = new com.badlogic.gdx.utils.reflect.Field[fields.length];
        int length = fields.length;
        for (int i = 0; i < length; i++) {
            fieldArr[i] = new com.badlogic.gdx.utils.reflect.Field(fields[i]);
        }
        return fieldArr;
    }

    public static java.lang.Class[] getInterfaces(java.lang.Class cls) {
        return cls.getInterfaces();
    }

    public static com.badlogic.gdx.utils.reflect.Method getMethod(java.lang.Class cls, java.lang.String str, java.lang.Class... clsArr) throws com.badlogic.gdx.utils.reflect.ReflectionException {
        try {
            return new com.badlogic.gdx.utils.reflect.Method(cls.getMethod(str, clsArr));
        } catch (java.lang.NoSuchMethodException e) {
            throw new com.badlogic.gdx.utils.reflect.ReflectionException("Method not found: " + str + ", for class: " + cls.getName(), e);
        } catch (java.lang.SecurityException e2) {
            throw new com.badlogic.gdx.utils.reflect.ReflectionException("Security violation while getting method: " + str + ", for class: " + cls.getName(), e2);
        }
    }

    public static com.badlogic.gdx.utils.reflect.Method[] getMethods(java.lang.Class cls) {
        java.lang.reflect.Method[] methods = cls.getMethods();
        com.badlogic.gdx.utils.reflect.Method[] methodArr = new com.badlogic.gdx.utils.reflect.Method[methods.length];
        int length = methods.length;
        for (int i = 0; i < length; i++) {
            methodArr[i] = new com.badlogic.gdx.utils.reflect.Method(methods[i]);
        }
        return methodArr;
    }

    public static java.lang.String getSimpleName(java.lang.Class cls) {
        return cls.getSimpleName();
    }

    public static boolean isAbstract(java.lang.Class cls) {
        return java.lang.reflect.Modifier.isAbstract(cls.getModifiers());
    }

    public static boolean isAnnotation(java.lang.Class cls) {
        return cls.isAnnotation();
    }

    public static boolean isAnnotationPresent(java.lang.Class cls, java.lang.Class<? extends java.lang.annotation.Annotation> cls2) {
        return cls.isAnnotationPresent(cls2);
    }

    public static boolean isArray(java.lang.Class cls) {
        return cls.isArray();
    }

    public static boolean isAssignableFrom(java.lang.Class cls, java.lang.Class cls2) {
        return cls.isAssignableFrom(cls2);
    }

    public static boolean isEnum(java.lang.Class cls) {
        return cls.isEnum();
    }

    public static boolean isInstance(java.lang.Class cls, java.lang.Object obj) {
        return cls.isInstance(obj);
    }

    public static boolean isInterface(java.lang.Class cls) {
        return cls.isInterface();
    }

    public static boolean isMemberClass(java.lang.Class cls) {
        return cls.isMemberClass();
    }

    public static boolean isPrimitive(java.lang.Class cls) {
        return cls.isPrimitive();
    }

    public static boolean isStaticClass(java.lang.Class cls) {
        return java.lang.reflect.Modifier.isStatic(cls.getModifiers());
    }

    public static <T> T newInstance(java.lang.Class<T> cls) throws com.badlogic.gdx.utils.reflect.ReflectionException {
        try {
            return cls.newInstance();
        } catch (java.lang.IllegalAccessException e) {
            throw new com.badlogic.gdx.utils.reflect.ReflectionException("Could not instantiate instance of class: " + cls.getName(), e);
        } catch (java.lang.InstantiationException e2) {
            throw new com.badlogic.gdx.utils.reflect.ReflectionException("Could not instantiate instance of class: " + cls.getName(), e2);
        }
    }
}
