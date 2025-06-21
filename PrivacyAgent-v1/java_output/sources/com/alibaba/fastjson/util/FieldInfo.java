package com.alibaba.fastjson.util;

/* loaded from: classes.dex */
public class FieldInfo implements java.lang.Comparable<com.alibaba.fastjson.util.FieldInfo> {
    public final java.lang.String[] alternateNames;
    public final java.lang.Class<?> declaringClass;
    public final java.lang.reflect.Field field;
    public final boolean fieldAccess;
    private final com.alibaba.fastjson.annotation.JSONField fieldAnnotation;
    public final java.lang.Class<?> fieldClass;
    public final boolean fieldTransient;
    public final java.lang.reflect.Type fieldType;
    public final java.lang.String format;
    public final boolean getOnly;
    public final boolean isEnum;
    public final java.lang.reflect.Method method;
    private final com.alibaba.fastjson.annotation.JSONField methodAnnotation;
    public final java.lang.String name;
    public final long nameHashCode;
    private int ordinal;
    public final int serialzeFeatures;

    public FieldInfo(java.lang.String str, java.lang.Class<?> cls, java.lang.Class<?> cls2, java.lang.reflect.Type type, java.lang.reflect.Field field, int i, int i2) {
        this.ordinal = 0;
        i = i < 0 ? 0 : i;
        this.name = str;
        this.declaringClass = cls;
        this.fieldClass = cls2;
        this.fieldType = type;
        this.method = null;
        this.field = field;
        this.ordinal = i;
        this.serialzeFeatures = i2;
        this.isEnum = cls2.isEnum() && !com.alibaba.fastjson.JSONAware.class.isAssignableFrom(cls2);
        this.fieldAnnotation = null;
        this.methodAnnotation = null;
        if (field != null) {
            int modifiers = field.getModifiers();
            int i3 = modifiers & 1;
            this.fieldAccess = true;
            this.fieldTransient = java.lang.reflect.Modifier.isTransient(modifiers);
        } else {
            this.fieldAccess = false;
            this.fieldTransient = false;
        }
        this.getOnly = false;
        long j = -3750763034362895579L;
        for (int i4 = 0; i4 < str.length(); i4++) {
            j = (j ^ str.charAt(i4)) * 1099511628211L;
        }
        this.nameHashCode = j;
        this.format = null;
        this.alternateNames = new java.lang.String[0];
    }

    /* JADX WARN: Code restructure failed: missing block: B:63:0x0130, code lost:
    
        r12 = r4.declaringClass.getTypeParameters();
        r1 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0138, code lost:
    
        if (r1 >= r12.length) goto L129;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0140, code lost:
    
        if (r13.equals(r12[r1]) == false) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0145, code lost:
    
        r1 = r1 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0142, code lost:
    
        r11 = r14[r1];
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public FieldInfo(java.lang.String str, java.lang.reflect.Method method, java.lang.reflect.Field field, java.lang.Class<?> cls, java.lang.reflect.Type type, int i, int i2, com.alibaba.fastjson.annotation.JSONField jSONField, com.alibaba.fastjson.annotation.JSONField jSONField2, boolean z) {
        java.lang.String str2;
        java.lang.reflect.Type genericType;
        java.lang.Class<?> cls2;
        boolean z2 = false;
        this.ordinal = 0;
        i = i < 0 ? 0 : i;
        this.name = str;
        this.method = method;
        this.field = field;
        this.ordinal = i;
        this.methodAnnotation = jSONField;
        this.fieldAnnotation = jSONField2;
        this.serialzeFeatures = i2;
        com.alibaba.fastjson.annotation.JSONField annotation = getAnnotation();
        java.lang.reflect.Type type2 = null;
        if (annotation != null) {
            str2 = annotation.format();
            str2 = str2.trim().length() == 0 ? null : str2;
            this.alternateNames = annotation.alternateNames();
        } else {
            this.alternateNames = new java.lang.String[0];
            str2 = null;
        }
        this.format = str2;
        if (field != null) {
            int modifiers = field.getModifiers();
            this.fieldAccess = method == null || ((modifiers & 1) != 0 && method.getReturnType() == field.getType());
            this.fieldTransient = (modifiers & 128) != 0;
        } else {
            this.fieldAccess = false;
            this.fieldTransient = false;
        }
        long j = -3750763034362895579L;
        for (int i3 = 0; i3 < str.length(); i3++) {
            j = (j ^ str.charAt(i3)) * 1099511628211L;
        }
        this.nameHashCode = j;
        if (method != null) {
            java.lang.Class<?>[] parameterTypes = method.getParameterTypes();
            if (parameterTypes.length == 1) {
                cls2 = parameterTypes[0];
                genericType = (cls2 == java.lang.Class.class || cls2 == java.lang.String.class || cls2.isPrimitive() || !z) ? cls2 : method.getGenericParameterTypes()[0];
                this.getOnly = false;
            } else {
                cls2 = method.getReturnType();
                genericType = (cls2 != java.lang.Class.class && z) ? method.getGenericReturnType() : cls2;
                this.getOnly = true;
            }
            this.declaringClass = method.getDeclaringClass();
        } else {
            java.lang.Class<?> type3 = field.getType();
            genericType = (type3.isPrimitive() || type3 == java.lang.String.class || type3.isEnum() || !z) ? type3 : field.getGenericType();
            this.declaringClass = field.getDeclaringClass();
            this.getOnly = java.lang.reflect.Modifier.isFinal(field.getModifiers());
            cls2 = type3;
        }
        if (cls != null && cls2 == java.lang.Object.class && (genericType instanceof java.lang.reflect.TypeVariable)) {
            java.lang.reflect.TypeVariable typeVariable = (java.lang.reflect.TypeVariable) genericType;
            java.lang.reflect.Type[] actualTypeArguments = type instanceof java.lang.reflect.ParameterizedType ? ((java.lang.reflect.ParameterizedType) type).getActualTypeArguments() : null;
            for (java.lang.Class<?> cls3 = cls; cls3 != null && cls3 != java.lang.Object.class && cls3 != this.declaringClass; cls3 = cls3.getSuperclass()) {
                java.lang.reflect.Type genericSuperclass = cls3.getGenericSuperclass();
                if (genericSuperclass instanceof java.lang.reflect.ParameterizedType) {
                    java.lang.reflect.Type[] actualTypeArguments2 = ((java.lang.reflect.ParameterizedType) genericSuperclass).getActualTypeArguments();
                    com.alibaba.fastjson.util.TypeUtils.getArgument(actualTypeArguments2, cls3.getTypeParameters(), actualTypeArguments);
                    actualTypeArguments = actualTypeArguments2;
                }
            }
            if (type2 != null) {
                this.fieldClass = com.alibaba.fastjson.util.TypeUtils.getClass(type2);
                this.fieldType = type2;
                if (cls2.isEnum() && !com.alibaba.fastjson.JSONAware.class.isAssignableFrom(cls2)) {
                    z2 = true;
                }
                this.isEnum = z2;
                return;
            }
        }
        if (!(genericType instanceof java.lang.Class)) {
            java.lang.reflect.Type fieldType = getFieldType(cls, type == null ? cls : type, genericType);
            if (fieldType != genericType) {
                if (fieldType instanceof java.lang.reflect.ParameterizedType) {
                    cls2 = com.alibaba.fastjson.util.TypeUtils.getClass(fieldType);
                } else if (fieldType instanceof java.lang.Class) {
                    cls2 = com.alibaba.fastjson.util.TypeUtils.getClass(fieldType);
                }
            }
            genericType = fieldType;
        }
        this.fieldType = genericType;
        this.fieldClass = cls2;
        if (!cls2.isArray() && cls2.isEnum() && !com.alibaba.fastjson.JSONAware.class.isAssignableFrom(cls2)) {
            z2 = true;
        }
        this.isEnum = z2;
    }

    public static java.lang.reflect.Type getFieldType(java.lang.Class<?> cls, java.lang.reflect.Type type, java.lang.reflect.Type type2) {
        java.lang.reflect.TypeVariable<java.lang.Class<? super java.lang.Object>>[] typeVariableArr;
        java.lang.reflect.ParameterizedType parameterizedType;
        if (cls != null && type != null) {
            if (type2 instanceof java.lang.reflect.GenericArrayType) {
                java.lang.reflect.Type genericComponentType = ((java.lang.reflect.GenericArrayType) type2).getGenericComponentType();
                java.lang.reflect.Type fieldType = getFieldType(cls, type, genericComponentType);
                return genericComponentType != fieldType ? java.lang.reflect.Array.newInstance(com.alibaba.fastjson.util.TypeUtils.getClass(fieldType), 0).getClass() : type2;
            }
            if (!com.alibaba.fastjson.util.TypeUtils.isGenericParamType(type)) {
                return type2;
            }
            if (type2 instanceof java.lang.reflect.TypeVariable) {
                java.lang.reflect.ParameterizedType parameterizedType2 = (java.lang.reflect.ParameterizedType) com.alibaba.fastjson.util.TypeUtils.getGenericParamType(type);
                java.lang.Class<?> cls2 = com.alibaba.fastjson.util.TypeUtils.getClass(parameterizedType2);
                java.lang.reflect.TypeVariable typeVariable = (java.lang.reflect.TypeVariable) type2;
                for (int i = 0; i < cls2.getTypeParameters().length; i++) {
                    if (cls2.getTypeParameters()[i].getName().equals(typeVariable.getName())) {
                        return parameterizedType2.getActualTypeArguments()[i];
                    }
                }
            }
            if (type2 instanceof java.lang.reflect.ParameterizedType) {
                java.lang.reflect.ParameterizedType parameterizedType3 = (java.lang.reflect.ParameterizedType) type2;
                java.lang.reflect.Type[] actualTypeArguments = parameterizedType3.getActualTypeArguments();
                java.lang.reflect.Type[] typeArr = null;
                if (type instanceof java.lang.reflect.ParameterizedType) {
                    parameterizedType = (java.lang.reflect.ParameterizedType) type;
                    typeVariableArr = cls.getTypeParameters();
                } else if (cls.getGenericSuperclass() instanceof java.lang.reflect.ParameterizedType) {
                    parameterizedType = (java.lang.reflect.ParameterizedType) cls.getGenericSuperclass();
                    typeVariableArr = cls.getSuperclass().getTypeParameters();
                } else {
                    typeVariableArr = null;
                    parameterizedType = null;
                }
                boolean z = false;
                for (int i2 = 0; i2 < actualTypeArguments.length && parameterizedType != null; i2++) {
                    java.lang.reflect.Type type3 = actualTypeArguments[i2];
                    if (type3 instanceof java.lang.reflect.TypeVariable) {
                        java.lang.reflect.TypeVariable typeVariable2 = (java.lang.reflect.TypeVariable) type3;
                        for (int i3 = 0; i3 < typeVariableArr.length; i3++) {
                            if (typeVariableArr[i3].getName().equals(typeVariable2.getName())) {
                                if (typeArr == null) {
                                    typeArr = parameterizedType.getActualTypeArguments();
                                }
                                actualTypeArguments[i2] = typeArr[i3];
                                z = true;
                            }
                        }
                    }
                }
                if (z) {
                    return new com.alibaba.fastjson.util.ParameterizedTypeImpl(actualTypeArguments, parameterizedType3.getOwnerType(), parameterizedType3.getRawType());
                }
            }
        }
        return type2;
    }

    @Override // java.lang.Comparable
    public int compareTo(com.alibaba.fastjson.util.FieldInfo fieldInfo) {
        int i = this.ordinal;
        int i2 = fieldInfo.ordinal;
        if (i < i2) {
            return -1;
        }
        if (i > i2) {
            return 1;
        }
        return this.name.compareTo(fieldInfo.name);
    }

    public boolean equals(com.alibaba.fastjson.util.FieldInfo fieldInfo) {
        return fieldInfo == this || compareTo(fieldInfo) == 0;
    }

    public java.lang.Object get(java.lang.Object obj) throws java.lang.IllegalAccessException, java.lang.reflect.InvocationTargetException {
        return this.fieldAccess ? this.field.get(obj) : this.method.invoke(obj, new java.lang.Object[0]);
    }

    public com.alibaba.fastjson.annotation.JSONField getAnnotation() {
        com.alibaba.fastjson.annotation.JSONField jSONField = this.fieldAnnotation;
        return jSONField != null ? jSONField : this.methodAnnotation;
    }

    public void set(java.lang.Object obj, java.lang.Object obj2) throws java.lang.IllegalAccessException, java.lang.reflect.InvocationTargetException {
        java.lang.reflect.Method method = this.method;
        if (method != null) {
            method.invoke(obj, obj2);
        } else {
            this.field.set(obj, obj2);
        }
    }

    public java.lang.String toString() {
        return this.name;
    }
}
