package com.alibaba.fastjson.parser;

/* loaded from: classes.dex */
class JavaBeanInfo {
    final java.lang.reflect.Constructor<?> creatorConstructor;
    public final java.lang.String[] creatorConstructorParameters;
    final java.lang.reflect.Constructor<?> defaultConstructor;
    final int defaultConstructorParameterSize;
    final java.lang.reflect.Method factoryMethod;
    final com.alibaba.fastjson.util.FieldInfo[] fields;
    final com.alibaba.fastjson.annotation.JSONType jsonType;
    boolean ordered = false;
    public final int parserFeatures;
    final com.alibaba.fastjson.util.FieldInfo[] sortedFields;
    final boolean supportBeanToArray;
    public final java.lang.String typeKey;
    public final long typeKeyHashCode;
    public final java.lang.String typeName;

    public JavaBeanInfo(java.lang.Class<?> cls, java.lang.reflect.Constructor<?> constructor, java.lang.reflect.Constructor<?> constructor2, java.lang.reflect.Method method, com.alibaba.fastjson.util.FieldInfo[] fieldInfoArr, com.alibaba.fastjson.util.FieldInfo[] fieldInfoArr2, com.alibaba.fastjson.annotation.JSONType jSONType, java.lang.String[] strArr) {
        int i;
        boolean z;
        int i2 = 0;
        this.defaultConstructor = constructor;
        this.creatorConstructor = constructor2;
        this.factoryMethod = method;
        this.fields = fieldInfoArr;
        this.jsonType = jSONType;
        if (strArr == null || strArr.length != fieldInfoArr.length) {
            this.creatorConstructorParameters = strArr;
        } else {
            this.creatorConstructorParameters = null;
        }
        if (jSONType != null) {
            java.lang.String typeName = jSONType.typeName();
            this.typeName = typeName.length() <= 0 ? cls.getName() : typeName;
            java.lang.String typeKey = jSONType.typeKey();
            this.typeKey = typeKey.length() > 0 ? typeKey : null;
            i = 0;
            for (com.alibaba.fastjson.parser.Feature feature : jSONType.parseFeatures()) {
                i |= feature.mask;
            }
        } else {
            this.typeName = cls.getName();
            this.typeKey = null;
            i = 0;
        }
        java.lang.String str = this.typeKey;
        if (str == null) {
            this.typeKeyHashCode = 0L;
        } else {
            this.typeKeyHashCode = com.alibaba.fastjson.util.TypeUtils.fnv_64_lower(str);
        }
        this.parserFeatures = i;
        if (jSONType != null) {
            com.alibaba.fastjson.parser.Feature[] parseFeatures = jSONType.parseFeatures();
            z = false;
            for (com.alibaba.fastjson.parser.Feature feature2 : parseFeatures) {
                if (feature2 == com.alibaba.fastjson.parser.Feature.SupportArrayToBean) {
                    z = true;
                }
            }
        } else {
            z = false;
        }
        this.supportBeanToArray = z;
        com.alibaba.fastjson.util.FieldInfo[] computeSortedFields = computeSortedFields(fieldInfoArr, fieldInfoArr2);
        this.sortedFields = java.util.Arrays.equals(fieldInfoArr, computeSortedFields) ? fieldInfoArr : computeSortedFields;
        if (constructor != null) {
            i2 = constructor.getParameterTypes().length;
        } else if (method != null) {
            i2 = method.getParameterTypes().length;
        }
        this.defaultConstructorParameterSize = i2;
    }

    public static boolean addField(java.util.List<com.alibaba.fastjson.util.FieldInfo> list, com.alibaba.fastjson.util.FieldInfo fieldInfo, boolean z) {
        if (!z) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                com.alibaba.fastjson.util.FieldInfo fieldInfo2 = list.get(i);
                if (fieldInfo2.name.equals(fieldInfo.name) && (!fieldInfo2.getOnly || fieldInfo.getOnly)) {
                    return false;
                }
            }
        }
        list.add(fieldInfo);
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:221:0x07fe, code lost:
    
        if (r1.length() > 0) goto L371;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:78:0x05b5  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0629  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0619  */
    /* JADX WARN: Type inference failed for: r0v10, types: [java.lang.reflect.Type[]] */
    /* JADX WARN: Type inference failed for: r0v34, types: [java.lang.reflect.Type[]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static com.alibaba.fastjson.parser.JavaBeanInfo build(java.lang.Class<?> cls, int i, java.lang.reflect.Type type, boolean z, boolean z2, boolean z3, boolean z4, com.alibaba.fastjson.PropertyNamingStrategy propertyNamingStrategy) {
        java.lang.reflect.Constructor<?> constructor;
        java.lang.Class<? super java.lang.Object> cls2;
        java.lang.reflect.Method[] methodArr;
        java.lang.reflect.Method method;
        java.lang.reflect.Constructor<?> constructor2;
        java.lang.reflect.Method[] methodArr2;
        java.lang.Class<? super java.lang.Object> cls3;
        java.lang.reflect.Constructor<?> constructor3;
        java.lang.Class<com.alibaba.fastjson.annotation.JSONType> cls4;
        java.lang.Object obj;
        java.lang.reflect.Field[] fieldArr;
        java.util.HashMap hashMap;
        com.alibaba.fastjson.annotation.JSONField jSONField;
        java.lang.reflect.Constructor<?> constructor4;
        java.lang.Object obj2;
        java.lang.String str;
        int i2;
        int i3;
        com.alibaba.fastjson.annotation.JSONField jSONField2;
        com.alibaba.fastjson.annotation.JSONField jSONField3;
        java.lang.reflect.Constructor<?> constructor5;
        java.lang.Object obj3;
        java.lang.Class<com.alibaba.fastjson.annotation.JSONType> cls5;
        java.lang.reflect.Method method2;
        java.lang.reflect.Field[] fieldArr2;
        java.lang.reflect.Method[] methodArr3;
        java.lang.Class<java.util.Map> cls6;
        int i4;
        int i5;
        java.lang.reflect.Method[] methodArr4;
        java.lang.Class<java.util.Map> cls7;
        java.lang.Object obj4;
        java.lang.String str2;
        com.alibaba.fastjson.PropertyNamingStrategy propertyNamingStrategy2;
        int i6;
        int i7;
        java.lang.Class<?> returnType;
        int i8;
        int i9;
        java.lang.reflect.Method[] methodArr5;
        java.lang.reflect.Constructor<?> constructor6;
        java.lang.Object obj5;
        java.lang.Class<com.alibaba.fastjson.annotation.JSONType> cls8;
        java.lang.reflect.Method method3;
        java.lang.reflect.Field[] fieldArr3;
        java.util.HashMap hashMap2;
        java.lang.reflect.Method method4;
        int i10;
        int i11;
        java.lang.String decapitalize;
        java.lang.reflect.Field[] fieldArr4;
        java.lang.reflect.Field field;
        java.lang.reflect.Field field2;
        java.util.HashMap hashMap3;
        java.lang.Object obj6;
        java.lang.reflect.Field[] fieldArr5;
        com.alibaba.fastjson.PropertyNamingStrategy propertyNamingStrategy3;
        int i12;
        com.alibaba.fastjson.annotation.JSONField jSONField4;
        java.lang.reflect.Constructor<?> constructor7;
        java.lang.Class<?> cls9 = cls;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.HashMap hashMap4 = new java.util.HashMap();
        java.lang.reflect.Constructor<?>[] declaredConstructors = cls.getDeclaredConstructors();
        boolean isKotlin = com.alibaba.fastjson.util.TypeUtils.isKotlin(cls);
        int i13 = i & 1024;
        if (i13 != 0 || (declaredConstructors.length != 1 && isKotlin)) {
            constructor = null;
        } else {
            try {
                constructor7 = cls9.getDeclaredConstructor(new java.lang.Class[0]);
            } catch (java.lang.Exception unused) {
                constructor7 = null;
            }
            if (constructor7 == null && cls.isMemberClass() && (i & 8) == 0) {
                int length = declaredConstructors.length;
                int i14 = 0;
                while (i14 < length) {
                    java.lang.reflect.Constructor<?> constructor8 = declaredConstructors[i14];
                    java.lang.Class<?>[] parameterTypes = constructor8.getParameterTypes();
                    java.lang.reflect.Constructor<?> constructor9 = constructor7;
                    if (parameterTypes.length == 1 && parameterTypes[0].equals(cls.getDeclaringClass())) {
                        constructor = constructor8;
                        break;
                    }
                    i14++;
                    constructor7 = constructor9;
                }
            }
            constructor = constructor7;
        }
        java.lang.String[] strArr = null;
        java.lang.Class<? super java.lang.Object> cls10 = java.lang.Object.class;
        if (z) {
            cls2 = cls10;
            methodArr = null;
            method = null;
        } else {
            java.util.ArrayList arrayList2 = new java.util.ArrayList();
            java.lang.Class<?> cls11 = cls9;
            java.lang.reflect.Method method5 = null;
            while (cls11 != null && cls11 != cls10) {
                java.lang.reflect.Method[] declaredMethods = cls11.getDeclaredMethods();
                int length2 = declaredMethods.length;
                java.lang.Class<? super java.lang.Object> cls12 = cls10;
                int i15 = 0;
                while (i15 < length2) {
                    int i16 = length2;
                    java.lang.reflect.Method method6 = declaredMethods[i15];
                    java.lang.reflect.Method[] methodArr6 = declaredMethods;
                    int modifiers = method6.getModifiers();
                    if ((modifiers & 8) != 0) {
                        if (!method6.isAnnotationPresent(com.alibaba.fastjson.annotation.JSONCreator.class)) {
                            continue;
                        } else {
                            if (method5 != null) {
                                throw new com.alibaba.fastjson.JSONException("multi-json creator");
                            }
                            method5 = method6;
                        }
                    } else if ((modifiers & 2) == 0 && (modifiers & 256) == 0 && (modifiers & 4) == 0) {
                        arrayList2.add(method6);
                    }
                    i15++;
                    length2 = i16;
                    declaredMethods = methodArr6;
                }
                cls11 = cls11.getSuperclass();
                cls10 = cls12;
            }
            cls2 = cls10;
            java.lang.reflect.Method[] methodArr7 = new java.lang.reflect.Method[arrayList2.size()];
            arrayList2.toArray(methodArr7);
            methodArr = methodArr7;
            method = method5;
        }
        java.lang.reflect.Field[] declaredFields = cls.getDeclaredFields();
        boolean z5 = cls.isInterface() || i13 != 0;
        java.lang.Class<com.alibaba.fastjson.annotation.JSONType> cls13 = com.alibaba.fastjson.annotation.JSONType.class;
        if (constructor == null || z5) {
            int length3 = declaredConstructors.length;
            java.lang.Object obj7 = com.alibaba.fastjson.annotation.JSONField.class;
            int i17 = 0;
            while (true) {
                if (i17 >= length3) {
                    constructor2 = null;
                    break;
                }
                int i18 = length3;
                java.lang.reflect.Constructor<?> constructor10 = declaredConstructors[i17];
                if (((com.alibaba.fastjson.annotation.JSONCreator) constructor10.getAnnotation(com.alibaba.fastjson.annotation.JSONCreator.class)) != null) {
                    constructor2 = constructor10;
                    break;
                }
                i17++;
                length3 = i18;
            }
            java.lang.String str3 = "illegal json creator";
            if (constructor2 != null) {
                com.alibaba.fastjson.util.TypeUtils.setAccessible(cls9, constructor2, i);
                java.lang.Class<?>[] parameterTypes2 = constructor2.getParameterTypes();
                java.lang.Class<?>[] genericParameterTypes = z4 ? constructor2.getGenericParameterTypes() : parameterTypes2;
                java.lang.annotation.Annotation[][] parameterAnnotations = constructor2.getParameterAnnotations();
                int i19 = 0;
                while (i19 < parameterTypes2.length) {
                    java.lang.annotation.Annotation[] annotationArr = parameterAnnotations[i19];
                    int length4 = annotationArr.length;
                    java.lang.String str4 = str3;
                    int i20 = 0;
                    while (true) {
                        if (i20 >= length4) {
                            jSONField3 = null;
                            break;
                        }
                        int i21 = length4;
                        java.lang.annotation.Annotation annotation = annotationArr[i20];
                        java.lang.annotation.Annotation[] annotationArr2 = annotationArr;
                        if (annotation instanceof com.alibaba.fastjson.annotation.JSONField) {
                            jSONField3 = (com.alibaba.fastjson.annotation.JSONField) annotation;
                            break;
                        }
                        i20++;
                        length4 = i21;
                        annotationArr = annotationArr2;
                    }
                    if (jSONField3 == null) {
                        throw new com.alibaba.fastjson.JSONException(str4);
                    }
                    java.lang.Class<?> cls14 = parameterTypes2[i19];
                    java.lang.Class<?> cls15 = genericParameterTypes[i19];
                    java.lang.reflect.Field field3 = com.alibaba.fastjson.util.TypeUtils.getField(cls9, jSONField3.name(), declaredFields, hashMap4);
                    if (field3 != null) {
                        com.alibaba.fastjson.util.TypeUtils.setAccessible(cls9, field3, i);
                    }
                    addField(arrayList, new com.alibaba.fastjson.util.FieldInfo(jSONField3.name(), cls, cls14, cls15, field3, jSONField3.ordinal(), com.alibaba.fastjson.serializer.SerializerFeature.of(jSONField3.serialzeFeatures())), z);
                    i19++;
                    str3 = str4;
                    cls13 = cls13;
                    constructor2 = constructor2;
                    hashMap4 = hashMap4;
                    methodArr = methodArr;
                    parameterTypes2 = parameterTypes2;
                    declaredFields = declaredFields;
                    obj7 = obj7;
                    cls2 = cls2;
                    constructor = constructor;
                }
                java.lang.reflect.Constructor<?> constructor11 = constructor;
                java.lang.reflect.Field[] fieldArr6 = declaredFields;
                methodArr2 = methodArr;
                java.lang.Object obj8 = obj7;
                cls3 = cls2;
                constructor3 = constructor2;
                java.util.HashMap hashMap5 = hashMap4;
                cls4 = cls13;
                int size = arrayList.size();
                com.alibaba.fastjson.util.FieldInfo[] fieldInfoArr = new com.alibaba.fastjson.util.FieldInfo[size];
                arrayList.toArray(fieldInfoArr);
                com.alibaba.fastjson.util.FieldInfo[] fieldInfoArr2 = new com.alibaba.fastjson.util.FieldInfo[size];
                java.lang.System.arraycopy(fieldInfoArr, 0, fieldInfoArr2, 0, size);
                java.util.Arrays.sort(fieldInfoArr2);
                if (z2) {
                }
                java.lang.String[] strArr2 = new java.lang.String[size];
                for (int i22 = 0; i22 < size; i22++) {
                    strArr2[i22] = fieldInfoArr[i22].name;
                }
                strArr = strArr2;
                hashMap = hashMap5;
                fieldArr = fieldArr6;
                obj = obj8;
                constructor = constructor11;
            } else {
                java.lang.reflect.Constructor<?> constructor12 = constructor;
                java.lang.reflect.Field[] fieldArr7 = declaredFields;
                methodArr2 = methodArr;
                java.lang.Object obj9 = obj7;
                cls3 = cls2;
                constructor3 = constructor2;
                java.util.HashMap hashMap6 = hashMap4;
                cls4 = cls13;
                if (method != null) {
                    com.alibaba.fastjson.util.TypeUtils.setAccessible(cls9, method, i);
                    java.lang.Class<?>[] parameterTypes3 = method.getParameterTypes();
                    if (parameterTypes3.length > 0) {
                        java.lang.Class<?>[] genericParameterTypes2 = z4 ? method.getGenericParameterTypes() : parameterTypes3;
                        java.lang.annotation.Annotation[][] parameterAnnotations2 = method.getParameterAnnotations();
                        int i23 = 0;
                        while (i23 < parameterTypes3.length) {
                            java.lang.annotation.Annotation[] annotationArr3 = parameterAnnotations2[i23];
                            int length5 = annotationArr3.length;
                            int i24 = 0;
                            while (true) {
                                if (i24 >= length5) {
                                    jSONField2 = null;
                                    break;
                                }
                                java.lang.annotation.Annotation annotation2 = annotationArr3[i24];
                                if (annotation2 instanceof com.alibaba.fastjson.annotation.JSONField) {
                                    jSONField2 = (com.alibaba.fastjson.annotation.JSONField) annotation2;
                                    break;
                                }
                                i24++;
                            }
                            if (jSONField2 == null) {
                                throw new com.alibaba.fastjson.JSONException("illegal json creator");
                            }
                            java.util.HashMap hashMap7 = hashMap6;
                            java.lang.reflect.Field[] fieldArr8 = fieldArr7;
                            addField(arrayList, new com.alibaba.fastjson.util.FieldInfo(jSONField2.name(), cls, parameterTypes3[i23], genericParameterTypes2[i23], com.alibaba.fastjson.util.TypeUtils.getField(cls9, jSONField2.name(), fieldArr8, hashMap7), jSONField2.ordinal(), com.alibaba.fastjson.serializer.SerializerFeature.of(jSONField2.serialzeFeatures())), z);
                            i23++;
                            parameterTypes3 = parameterTypes3;
                            fieldArr7 = fieldArr8;
                            hashMap6 = hashMap7;
                        }
                        int size2 = arrayList.size();
                        com.alibaba.fastjson.util.FieldInfo[] fieldInfoArr3 = new com.alibaba.fastjson.util.FieldInfo[size2];
                        arrayList.toArray(fieldInfoArr3);
                        com.alibaba.fastjson.util.FieldInfo[] fieldInfoArr4 = new com.alibaba.fastjson.util.FieldInfo[size2];
                        java.lang.System.arraycopy(fieldInfoArr3, 0, fieldInfoArr4, 0, size2);
                        java.util.Arrays.sort(fieldInfoArr4);
                        return new com.alibaba.fastjson.parser.JavaBeanInfo(cls, null, null, method, fieldInfoArr3, java.util.Arrays.equals(fieldInfoArr3, fieldInfoArr4) ? fieldInfoArr3 : fieldInfoArr4, z2 ? (com.alibaba.fastjson.annotation.JSONType) cls9.getAnnotation(cls4) : null, null);
                    }
                    hashMap = hashMap6;
                    fieldArr = fieldArr7;
                    obj = obj9;
                } else {
                    java.util.HashMap hashMap8 = hashMap6;
                    java.lang.reflect.Field[] fieldArr9 = fieldArr7;
                    if (z5) {
                        obj = obj9;
                        fieldArr = fieldArr9;
                        hashMap = hashMap8;
                    } else {
                        if (!isKotlin || declaredConstructors.length <= 0) {
                            throw new com.alibaba.fastjson.JSONException("default constructor not found. " + cls9);
                        }
                        java.lang.String[] koltinConstructorParameters = com.alibaba.fastjson.util.TypeUtils.getKoltinConstructorParameters(cls);
                        if (koltinConstructorParameters == null) {
                            throw new com.alibaba.fastjson.JSONException("default constructor not found. " + cls9);
                        }
                        java.lang.reflect.Constructor<?> constructor13 = constructor3;
                        for (java.lang.reflect.Constructor<?> constructor14 : declaredConstructors) {
                            java.lang.Class<?>[] parameterTypes4 = constructor14.getParameterTypes();
                            if ((parameterTypes4.length <= 0 || !parameterTypes4[parameterTypes4.length - 1].getName().equals("kotlin.jvm.internal.DefaultConstructorMarker")) && (constructor13 == null || constructor13.getParameterTypes().length < parameterTypes4.length)) {
                                constructor13 = constructor14;
                            }
                        }
                        constructor13.setAccessible(true);
                        com.alibaba.fastjson.util.TypeUtils.setAccessible(cls9, constructor13, i);
                        java.lang.Class<?>[] parameterTypes5 = constructor13.getParameterTypes();
                        java.lang.Class<?>[] genericParameterTypes3 = z4 ? constructor13.getGenericParameterTypes() : parameterTypes5;
                        java.lang.annotation.Annotation[][] parameterAnnotations3 = constructor13.getParameterAnnotations();
                        int i25 = 0;
                        while (i25 < parameterTypes5.length) {
                            java.lang.String str5 = koltinConstructorParameters[i25];
                            java.lang.annotation.Annotation[] annotationArr4 = parameterAnnotations3[i25];
                            int length6 = annotationArr4.length;
                            int i26 = 0;
                            while (true) {
                                if (i26 >= length6) {
                                    jSONField = null;
                                    break;
                                }
                                java.lang.annotation.Annotation annotation3 = annotationArr4[i26];
                                if (annotation3 instanceof com.alibaba.fastjson.annotation.JSONField) {
                                    jSONField = (com.alibaba.fastjson.annotation.JSONField) annotation3;
                                    break;
                                }
                                i26++;
                            }
                            java.lang.Class<?> cls16 = parameterTypes5[i25];
                            java.lang.Class<?> cls17 = genericParameterTypes3[i25];
                            int i27 = i25;
                            java.lang.reflect.Field[] fieldArr10 = fieldArr9;
                            java.util.HashMap hashMap9 = hashMap8;
                            java.lang.reflect.Field field4 = com.alibaba.fastjson.util.TypeUtils.getField(cls9, str5, fieldArr10, hashMap9);
                            if (field4 == null || jSONField != null) {
                                constructor4 = constructor13;
                                obj2 = obj9;
                            } else {
                                constructor4 = constructor13;
                                obj2 = obj9;
                                jSONField = (com.alibaba.fastjson.annotation.JSONField) field4.getAnnotation(obj2);
                            }
                            if (jSONField != null) {
                                i2 = jSONField.ordinal();
                                i3 = com.alibaba.fastjson.serializer.SerializerFeature.of(jSONField.serialzeFeatures());
                                java.lang.String name = jSONField.name();
                                if (name.length() != 0) {
                                    str5 = name;
                                }
                                str = str5;
                            } else {
                                str = str5;
                                i2 = 0;
                                i3 = 0;
                            }
                            addField(arrayList, new com.alibaba.fastjson.util.FieldInfo(str, cls, cls16, cls17, field4, i2, i3), z);
                            i25 = i27 + 1;
                            obj9 = obj2;
                            constructor13 = constructor4;
                            parameterTypes5 = parameterTypes5;
                            fieldArr9 = fieldArr10;
                            hashMap8 = hashMap9;
                        }
                        java.lang.reflect.Constructor<?> constructor15 = constructor13;
                        obj = obj9;
                        fieldArr = fieldArr9;
                        hashMap = hashMap8;
                        int size3 = arrayList.size();
                        com.alibaba.fastjson.util.FieldInfo[] fieldInfoArr5 = new com.alibaba.fastjson.util.FieldInfo[size3];
                        arrayList.toArray(fieldInfoArr5);
                        com.alibaba.fastjson.util.FieldInfo[] fieldInfoArr6 = new com.alibaba.fastjson.util.FieldInfo[size3];
                        java.lang.System.arraycopy(fieldInfoArr5, 0, fieldInfoArr6, 0, size3);
                        java.util.Arrays.sort(fieldInfoArr6);
                        java.lang.String[] strArr3 = new java.lang.String[size3];
                        for (int i28 = 0; i28 < size3; i28++) {
                            strArr3[i28] = fieldInfoArr5[i28].name;
                        }
                        strArr = strArr3;
                        constructor3 = constructor15;
                        constructor = constructor12;
                    }
                }
                constructor = constructor12;
            }
        } else {
            fieldArr = declaredFields;
            methodArr2 = methodArr;
            hashMap = hashMap4;
            constructor3 = null;
            cls3 = cls2;
            obj = com.alibaba.fastjson.annotation.JSONField.class;
            cls4 = cls13;
        }
        if (constructor != null) {
            com.alibaba.fastjson.util.TypeUtils.setAccessible(cls9, constructor, i);
        }
        int i29 = 4;
        if (z) {
            constructor5 = constructor;
            obj3 = obj;
            cls5 = cls4;
            method2 = method;
            fieldArr2 = fieldArr;
            methodArr3 = methodArr2;
        } else {
            java.lang.reflect.Method[] methodArr8 = methodArr2;
            int length7 = methodArr8.length;
            int i30 = 0;
            while (i30 < length7) {
                java.lang.reflect.Method method7 = methodArr8[i30];
                java.lang.String name2 = method7.getName();
                if (name2.length() >= i29 && (((returnType = method7.getReturnType()) == java.lang.Void.TYPE || returnType == method7.getDeclaringClass()) && method7.getParameterTypes().length == 1)) {
                    com.alibaba.fastjson.annotation.JSONField jSONField5 = z3 ? (com.alibaba.fastjson.annotation.JSONField) method7.getAnnotation(obj) : null;
                    if (jSONField5 == null && z3) {
                        jSONField5 = com.alibaba.fastjson.util.TypeUtils.getSupperMethodAnnotation(cls9, method7);
                    }
                    com.alibaba.fastjson.annotation.JSONField jSONField6 = jSONField5;
                    if (jSONField6 == null) {
                        i8 = i30;
                        i9 = length7;
                        methodArr5 = methodArr8;
                        constructor6 = constructor;
                        obj5 = obj;
                        cls8 = cls4;
                        method3 = method;
                        fieldArr3 = fieldArr;
                        hashMap2 = hashMap;
                        method4 = method7;
                        i10 = 0;
                        i11 = 0;
                    } else if (jSONField6.deserialize()) {
                        int ordinal = jSONField6.ordinal();
                        i11 = com.alibaba.fastjson.serializer.SerializerFeature.of(jSONField6.serialzeFeatures());
                        if (jSONField6.name().length() != 0) {
                            i8 = i30;
                            i9 = length7;
                            constructor6 = constructor;
                            fieldArr3 = fieldArr;
                            obj5 = obj;
                            methodArr5 = methodArr8;
                            cls8 = cls4;
                            method3 = method;
                            hashMap2 = hashMap;
                            addField(arrayList, new com.alibaba.fastjson.util.FieldInfo(jSONField6.name(), method7, null, cls, type, ordinal, i11, jSONField6, null, z4), z);
                            com.alibaba.fastjson.util.TypeUtils.setAccessible(cls9, method7, i);
                            hashMap3 = hashMap2;
                            obj6 = obj5;
                            i30 = i8 + 1;
                            method = method3;
                            constructor = constructor6;
                            length7 = i9;
                            obj = obj6;
                            hashMap = hashMap3;
                            fieldArr = fieldArr3;
                            methodArr8 = methodArr5;
                            cls4 = cls8;
                            i29 = 4;
                        } else {
                            i8 = i30;
                            i9 = length7;
                            methodArr5 = methodArr8;
                            constructor6 = constructor;
                            obj5 = obj;
                            cls8 = cls4;
                            method3 = method;
                            fieldArr3 = fieldArr;
                            hashMap2 = hashMap;
                            method4 = method7;
                            i10 = ordinal;
                        }
                    }
                    if (name2.startsWith("set")) {
                        char charAt = name2.charAt(3);
                        if (java.lang.Character.isUpperCase(charAt)) {
                            if (com.alibaba.fastjson.util.TypeUtils.compatibleWithJavaBean) {
                                decapitalize = com.alibaba.fastjson.util.TypeUtils.decapitalize(name2.substring(3));
                                fieldArr4 = fieldArr3;
                                field = com.alibaba.fastjson.util.TypeUtils.getField(cls9, decapitalize, fieldArr4, hashMap2);
                                if (field == null && method4.getParameterTypes()[0] == java.lang.Boolean.TYPE) {
                                    field = com.alibaba.fastjson.util.TypeUtils.getField(cls9, "is" + java.lang.Character.toUpperCase(decapitalize.charAt(0)) + decapitalize.substring(1), fieldArr4, hashMap2);
                                }
                                field2 = field;
                                if (field2 == null) {
                                    java.lang.Object obj10 = obj5;
                                    com.alibaba.fastjson.annotation.JSONField jSONField7 = z3 ? (com.alibaba.fastjson.annotation.JSONField) field2.getAnnotation(obj10) : null;
                                    if (jSONField7 != null) {
                                        i10 = jSONField7.ordinal();
                                        i11 = com.alibaba.fastjson.serializer.SerializerFeature.of(jSONField7.serialzeFeatures());
                                        if (jSONField7.name().length() != 0) {
                                            hashMap3 = hashMap2;
                                            obj6 = obj10;
                                            addField(arrayList, new com.alibaba.fastjson.util.FieldInfo(jSONField7.name(), method4, field2, cls, type, i10, i11, jSONField6, jSONField7, z4), z);
                                            fieldArr3 = fieldArr4;
                                            i30 = i8 + 1;
                                            method = method3;
                                            constructor = constructor6;
                                            length7 = i9;
                                            obj = obj6;
                                            hashMap = hashMap3;
                                            fieldArr = fieldArr3;
                                            methodArr8 = methodArr5;
                                            cls4 = cls8;
                                            i29 = 4;
                                        } else {
                                            obj6 = obj10;
                                            hashMap3 = hashMap2;
                                            fieldArr5 = fieldArr4;
                                            if (jSONField6 == null) {
                                                propertyNamingStrategy3 = propertyNamingStrategy;
                                                i12 = i10;
                                                jSONField4 = jSONField7;
                                                int i31 = i11;
                                                if (propertyNamingStrategy3 != null) {
                                                    decapitalize = propertyNamingStrategy3.translate(decapitalize);
                                                }
                                                fieldArr3 = fieldArr5;
                                                addField(arrayList, new com.alibaba.fastjson.util.FieldInfo(decapitalize, method4, null, cls, type, i12, i31, jSONField4, null, z4), z);
                                                com.alibaba.fastjson.util.TypeUtils.setAccessible(cls9, method4, i);
                                                i30 = i8 + 1;
                                                method = method3;
                                                constructor = constructor6;
                                                length7 = i9;
                                                obj = obj6;
                                                hashMap = hashMap3;
                                                fieldArr = fieldArr3;
                                                methodArr8 = methodArr5;
                                                cls4 = cls8;
                                                i29 = 4;
                                            }
                                            propertyNamingStrategy3 = propertyNamingStrategy;
                                            i12 = i10;
                                            jSONField4 = jSONField6;
                                            int i312 = i11;
                                            if (propertyNamingStrategy3 != null) {
                                            }
                                            fieldArr3 = fieldArr5;
                                            addField(arrayList, new com.alibaba.fastjson.util.FieldInfo(decapitalize, method4, null, cls, type, i12, i312, jSONField4, null, z4), z);
                                            com.alibaba.fastjson.util.TypeUtils.setAccessible(cls9, method4, i);
                                            i30 = i8 + 1;
                                            method = method3;
                                            constructor = constructor6;
                                            length7 = i9;
                                            obj = obj6;
                                            hashMap = hashMap3;
                                            fieldArr = fieldArr3;
                                            methodArr8 = methodArr5;
                                            cls4 = cls8;
                                            i29 = 4;
                                        }
                                    } else {
                                        obj6 = obj10;
                                        hashMap3 = hashMap2;
                                    }
                                } else {
                                    hashMap3 = hashMap2;
                                    obj6 = obj5;
                                }
                                fieldArr5 = fieldArr4;
                                propertyNamingStrategy3 = propertyNamingStrategy;
                                i12 = i10;
                                jSONField4 = jSONField6;
                                int i3122 = i11;
                                if (propertyNamingStrategy3 != null) {
                                }
                                fieldArr3 = fieldArr5;
                                addField(arrayList, new com.alibaba.fastjson.util.FieldInfo(decapitalize, method4, null, cls, type, i12, i3122, jSONField4, null, z4), z);
                                com.alibaba.fastjson.util.TypeUtils.setAccessible(cls9, method4, i);
                                i30 = i8 + 1;
                                method = method3;
                                constructor = constructor6;
                                length7 = i9;
                                obj = obj6;
                                hashMap = hashMap3;
                                fieldArr = fieldArr3;
                                methodArr8 = methodArr5;
                                cls4 = cls8;
                                i29 = 4;
                            } else {
                                decapitalize = java.lang.Character.toLowerCase(name2.charAt(3)) + name2.substring(4);
                            }
                        } else if (charAt == '_') {
                            decapitalize = name2.substring(4);
                        } else if (charAt == 'f') {
                            decapitalize = name2.substring(3);
                        } else if (name2.length() >= 5 && java.lang.Character.isUpperCase(name2.charAt(4))) {
                            decapitalize = com.alibaba.fastjson.util.TypeUtils.decapitalize(name2.substring(3));
                        }
                        fieldArr4 = fieldArr3;
                        field = com.alibaba.fastjson.util.TypeUtils.getField(cls9, decapitalize, fieldArr4, hashMap2);
                        if (field == null) {
                            field = com.alibaba.fastjson.util.TypeUtils.getField(cls9, "is" + java.lang.Character.toUpperCase(decapitalize.charAt(0)) + decapitalize.substring(1), fieldArr4, hashMap2);
                        }
                        field2 = field;
                        if (field2 == null) {
                        }
                        fieldArr5 = fieldArr4;
                        propertyNamingStrategy3 = propertyNamingStrategy;
                        i12 = i10;
                        jSONField4 = jSONField6;
                        int i31222 = i11;
                        if (propertyNamingStrategy3 != null) {
                        }
                        fieldArr3 = fieldArr5;
                        addField(arrayList, new com.alibaba.fastjson.util.FieldInfo(decapitalize, method4, null, cls, type, i12, i31222, jSONField4, null, z4), z);
                        com.alibaba.fastjson.util.TypeUtils.setAccessible(cls9, method4, i);
                        i30 = i8 + 1;
                        method = method3;
                        constructor = constructor6;
                        length7 = i9;
                        obj = obj6;
                        hashMap = hashMap3;
                        fieldArr = fieldArr3;
                        methodArr8 = methodArr5;
                        cls4 = cls8;
                        i29 = 4;
                    }
                    hashMap3 = hashMap2;
                    obj6 = obj5;
                    i30 = i8 + 1;
                    method = method3;
                    constructor = constructor6;
                    length7 = i9;
                    obj = obj6;
                    hashMap = hashMap3;
                    fieldArr = fieldArr3;
                    methodArr8 = methodArr5;
                    cls4 = cls8;
                    i29 = 4;
                }
                i8 = i30;
                i9 = length7;
                methodArr5 = methodArr8;
                constructor6 = constructor;
                obj6 = obj;
                cls8 = cls4;
                method3 = method;
                fieldArr3 = fieldArr;
                hashMap3 = hashMap;
                i30 = i8 + 1;
                method = method3;
                constructor = constructor6;
                length7 = i9;
                obj = obj6;
                hashMap = hashMap3;
                fieldArr = fieldArr3;
                methodArr8 = methodArr5;
                cls4 = cls8;
                i29 = 4;
            }
            methodArr3 = methodArr8;
            constructor5 = constructor;
            obj3 = obj;
            cls5 = cls4;
            method2 = method;
            fieldArr2 = fieldArr;
        }
        java.lang.reflect.Field[] fieldArr11 = fieldArr2;
        java.util.ArrayList<java.lang.reflect.Field> arrayList3 = new java.util.ArrayList(fieldArr11.length);
        int length8 = fieldArr11.length;
        int i32 = 0;
        while (true) {
            cls6 = java.util.Map.class;
            if (i32 >= length8) {
                break;
            }
            java.lang.reflect.Field field5 = fieldArr11[i32];
            int modifiers2 = field5.getModifiers();
            if ((modifiers2 & 8) == 0) {
                if ((modifiers2 & 16) != 0) {
                    java.lang.Class<?> type2 = field5.getType();
                    if (!(cls6.isAssignableFrom(type2) || java.util.Collection.class.isAssignableFrom(type2))) {
                    }
                }
                if ((field5.getModifiers() & 1) != 0) {
                    arrayList3.add(field5);
                }
            }
            i32++;
        }
        java.lang.Class<? super java.lang.Object> superclass = cls.getSuperclass();
        while (superclass != null) {
            java.lang.Class<? super java.lang.Object> cls18 = cls3;
            if (superclass == cls18) {
                break;
            }
            for (java.lang.reflect.Field field6 : superclass.getDeclaredFields()) {
                int modifiers3 = field6.getModifiers();
                if ((modifiers3 & 8) == 0) {
                    if ((modifiers3 & 16) != 0) {
                        java.lang.Class<?> type3 = field6.getType();
                        if (!(cls6.isAssignableFrom(type3) || java.util.Collection.class.isAssignableFrom(type3))) {
                        }
                    }
                    if ((modifiers3 & 1) != 0) {
                        arrayList3.add(field6);
                    }
                }
            }
            superclass = superclass.getSuperclass();
            cls3 = cls18;
        }
        for (java.lang.reflect.Field field7 : arrayList3) {
            java.lang.String name3 = field7.getName();
            int size4 = arrayList.size();
            boolean z6 = false;
            for (int i33 = 0; i33 < size4; i33++) {
                if (((com.alibaba.fastjson.util.FieldInfo) arrayList.get(i33)).name.equals(name3)) {
                    z6 = true;
                }
            }
            if (!z6) {
                java.lang.Object obj11 = obj3;
                com.alibaba.fastjson.annotation.JSONField jSONField8 = z3 ? (com.alibaba.fastjson.annotation.JSONField) field7.getAnnotation(obj11) : null;
                if (jSONField8 != null) {
                    int ordinal2 = jSONField8.ordinal();
                    int of = com.alibaba.fastjson.serializer.SerializerFeature.of(jSONField8.serialzeFeatures());
                    if (jSONField8.name().length() != 0) {
                        name3 = jSONField8.name();
                    }
                    propertyNamingStrategy2 = propertyNamingStrategy;
                    i6 = ordinal2;
                    i7 = of;
                } else {
                    propertyNamingStrategy2 = propertyNamingStrategy;
                    i6 = 0;
                    i7 = 0;
                }
                if (propertyNamingStrategy2 != null) {
                    name3 = propertyNamingStrategy2.translate(name3);
                }
                com.alibaba.fastjson.util.TypeUtils.setAccessible(cls9, field7, i);
                addField(arrayList, new com.alibaba.fastjson.util.FieldInfo(name3, null, field7, cls, type, i6, i7, null, jSONField8, z4), z);
                cls6 = cls6;
                obj3 = obj11;
                cls9 = cls;
            }
        }
        java.lang.Class<java.util.Map> cls19 = cls6;
        java.lang.Object obj12 = obj3;
        if (!z) {
            java.lang.reflect.Method[] methodArr9 = methodArr3;
            int length9 = methodArr9.length;
            int i34 = 0;
            while (i34 < length9) {
                java.lang.reflect.Method method8 = methodArr9[i34];
                java.lang.String name4 = method8.getName();
                if (name4.length() >= 4 && name4.startsWith(com.ss.android.socialbase.downloader.constants.MonitorConstants.CONNECT_TYPE_GET) && java.lang.Character.isUpperCase(name4.charAt(3)) && method8.getParameterTypes().length == 0) {
                    java.lang.Class<?> returnType2 = method8.getReturnType();
                    if (java.util.Collection.class.isAssignableFrom(returnType2) || cls19.isAssignableFrom(returnType2)) {
                        java.lang.Object obj13 = obj12;
                        com.alibaba.fastjson.annotation.JSONField jSONField9 = z3 ? (com.alibaba.fastjson.annotation.JSONField) method8.getAnnotation(obj13) : null;
                        if (jSONField9 != null) {
                            str2 = jSONField9.name();
                        }
                        str2 = java.lang.Character.toLowerCase(name4.charAt(3)) + name4.substring(4);
                        obj4 = obj13;
                        i4 = i34;
                        com.alibaba.fastjson.annotation.JSONField jSONField10 = jSONField9;
                        i5 = length9;
                        methodArr4 = methodArr9;
                        addField(arrayList, new com.alibaba.fastjson.util.FieldInfo(str2, method8, null, cls, type, 0, 0, jSONField10, null, z4), z);
                        cls7 = cls19;
                        com.alibaba.fastjson.util.TypeUtils.setAccessible(cls, method8, i);
                        i34 = i4 + 1;
                        cls19 = cls7;
                        length9 = i5;
                        obj12 = obj4;
                        methodArr9 = methodArr4;
                    }
                }
                i4 = i34;
                i5 = length9;
                methodArr4 = methodArr9;
                cls7 = cls19;
                obj4 = obj12;
                i34 = i4 + 1;
                cls19 = cls7;
                length9 = i5;
                obj12 = obj4;
                methodArr9 = methodArr4;
            }
        }
        int size5 = arrayList.size();
        com.alibaba.fastjson.util.FieldInfo[] fieldInfoArr7 = new com.alibaba.fastjson.util.FieldInfo[size5];
        arrayList.toArray(fieldInfoArr7);
        com.alibaba.fastjson.util.FieldInfo[] fieldInfoArr8 = new com.alibaba.fastjson.util.FieldInfo[size5];
        java.lang.System.arraycopy(fieldInfoArr7, 0, fieldInfoArr8, 0, size5);
        java.util.Arrays.sort(fieldInfoArr8);
        return new com.alibaba.fastjson.parser.JavaBeanInfo(cls, constructor5, constructor3, method2, fieldInfoArr7, fieldInfoArr8, z2 ? (com.alibaba.fastjson.annotation.JSONType) cls.getAnnotation(cls5) : null, strArr);
    }

    private com.alibaba.fastjson.util.FieldInfo[] computeSortedFields(com.alibaba.fastjson.util.FieldInfo[] fieldInfoArr, com.alibaba.fastjson.util.FieldInfo[] fieldInfoArr2) {
        java.lang.String[] orders;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        com.alibaba.fastjson.annotation.JSONType jSONType = this.jsonType;
        if (jSONType != null && (orders = jSONType.orders()) != null && orders.length != 0) {
            int i = 0;
            while (true) {
                if (i >= orders.length) {
                    z = true;
                    break;
                }
                int i2 = 0;
                while (true) {
                    if (i2 >= fieldInfoArr2.length) {
                        z4 = false;
                        break;
                    }
                    if (fieldInfoArr2[i2].name.equals(orders[i])) {
                        z4 = true;
                        break;
                    }
                    i2++;
                }
                if (!z4) {
                    z = false;
                    break;
                }
                i++;
            }
            if (!z) {
                return fieldInfoArr2;
            }
            if (orders.length == fieldInfoArr.length) {
                int i3 = 0;
                while (true) {
                    if (i3 >= orders.length) {
                        z3 = true;
                        break;
                    }
                    if (!fieldInfoArr2[i3].name.equals(orders[i3])) {
                        z3 = false;
                        break;
                    }
                    i3++;
                }
                if (z3) {
                    return fieldInfoArr2;
                }
                com.alibaba.fastjson.util.FieldInfo[] fieldInfoArr3 = new com.alibaba.fastjson.util.FieldInfo[fieldInfoArr2.length];
                for (int i4 = 0; i4 < orders.length; i4++) {
                    int i5 = 0;
                    while (true) {
                        if (i5 >= fieldInfoArr2.length) {
                            break;
                        }
                        if (fieldInfoArr2[i5].name.equals(orders[i4])) {
                            fieldInfoArr3[i4] = fieldInfoArr2[i5];
                            break;
                        }
                        i5++;
                    }
                }
                this.ordered = true;
                return fieldInfoArr3;
            }
            int length = fieldInfoArr2.length;
            com.alibaba.fastjson.util.FieldInfo[] fieldInfoArr4 = new com.alibaba.fastjson.util.FieldInfo[length];
            for (int i6 = 0; i6 < orders.length; i6++) {
                int i7 = 0;
                while (true) {
                    if (i7 >= fieldInfoArr2.length) {
                        break;
                    }
                    if (fieldInfoArr2[i7].name.equals(orders[i6])) {
                        fieldInfoArr4[i6] = fieldInfoArr2[i7];
                        break;
                    }
                    i7++;
                }
            }
            int length2 = orders.length;
            for (int i8 = 0; i8 < fieldInfoArr2.length; i8++) {
                for (int i9 = 0; i9 < length && i9 < length2; i9++) {
                    if (fieldInfoArr4[i8].equals(fieldInfoArr2[i9])) {
                        z2 = true;
                        break;
                    }
                }
                z2 = false;
                if (!z2) {
                    fieldInfoArr4[length2] = fieldInfoArr2[i8];
                    length2++;
                }
            }
            this.ordered = true;
        }
        return fieldInfoArr2;
    }
}
