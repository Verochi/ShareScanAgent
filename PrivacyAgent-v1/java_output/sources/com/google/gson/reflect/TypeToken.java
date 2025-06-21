package com.google.gson.reflect;

/* loaded from: classes22.dex */
public class TypeToken<T> {
    final int hashCode;
    final java.lang.Class<? super T> rawType;
    final java.lang.reflect.Type type;

    public TypeToken() {
        java.lang.reflect.Type superclassTypeParameter = getSuperclassTypeParameter(getClass());
        this.type = superclassTypeParameter;
        this.rawType = (java.lang.Class<? super T>) com.google.gson.internal.C$Gson$Types.getRawType(superclassTypeParameter);
        this.hashCode = superclassTypeParameter.hashCode();
    }

    public TypeToken(java.lang.reflect.Type type) {
        java.lang.reflect.Type canonicalize = com.google.gson.internal.C$Gson$Types.canonicalize((java.lang.reflect.Type) com.google.gson.internal.C$Gson$Preconditions.checkNotNull(type));
        this.type = canonicalize;
        this.rawType = (java.lang.Class<? super T>) com.google.gson.internal.C$Gson$Types.getRawType(canonicalize);
        this.hashCode = canonicalize.hashCode();
    }

    private static java.lang.AssertionError buildUnexpectedTypeError(java.lang.reflect.Type type, java.lang.Class<?>... clsArr) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("Unexpected type. Expected one of: ");
        for (java.lang.Class<?> cls : clsArr) {
            sb.append(cls.getName());
            sb.append(", ");
        }
        sb.append("but got: ");
        sb.append(type.getClass().getName());
        sb.append(", for type token: ");
        sb.append(type.toString());
        sb.append('.');
        return new java.lang.AssertionError(sb.toString());
    }

    public static <T> com.google.gson.reflect.TypeToken<T> get(java.lang.Class<T> cls) {
        return new com.google.gson.reflect.TypeToken<>(cls);
    }

    public static com.google.gson.reflect.TypeToken<?> get(java.lang.reflect.Type type) {
        return new com.google.gson.reflect.TypeToken<>(type);
    }

    public static com.google.gson.reflect.TypeToken<?> getArray(java.lang.reflect.Type type) {
        return new com.google.gson.reflect.TypeToken<>(com.google.gson.internal.C$Gson$Types.arrayOf(type));
    }

    public static com.google.gson.reflect.TypeToken<?> getParameterized(java.lang.reflect.Type type, java.lang.reflect.Type... typeArr) {
        return new com.google.gson.reflect.TypeToken<>(com.google.gson.internal.C$Gson$Types.newParameterizedTypeWithOwner(null, type, typeArr));
    }

    public static java.lang.reflect.Type getSuperclassTypeParameter(java.lang.Class<?> cls) {
        java.lang.reflect.Type genericSuperclass = cls.getGenericSuperclass();
        if (genericSuperclass instanceof java.lang.Class) {
            throw new java.lang.RuntimeException("Missing type parameter.");
        }
        return com.google.gson.internal.C$Gson$Types.canonicalize(((java.lang.reflect.ParameterizedType) genericSuperclass).getActualTypeArguments()[0]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.reflect.Type] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.Class] */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.lang.reflect.Type] */
    /* JADX WARN: Type inference failed for: r1v8, types: [java.lang.reflect.Type] */
    /* JADX WARN: Type inference failed for: r1v9 */
    private static boolean isAssignableFrom(java.lang.reflect.Type type, java.lang.reflect.GenericArrayType genericArrayType) {
        java.lang.reflect.Type genericComponentType = genericArrayType.getGenericComponentType();
        if (!(genericComponentType instanceof java.lang.reflect.ParameterizedType)) {
            return true;
        }
        if (type instanceof java.lang.reflect.GenericArrayType) {
            type = ((java.lang.reflect.GenericArrayType) type).getGenericComponentType();
        } else if (type instanceof java.lang.Class) {
            type = (java.lang.Class) type;
            while (type.isArray()) {
                type = type.getComponentType();
            }
        }
        return isAssignableFrom(type, (java.lang.reflect.ParameterizedType) genericComponentType, new java.util.HashMap());
    }

    private static boolean isAssignableFrom(java.lang.reflect.Type type, java.lang.reflect.ParameterizedType parameterizedType, java.util.Map<java.lang.String, java.lang.reflect.Type> map) {
        if (type == null) {
            return false;
        }
        if (parameterizedType.equals(type)) {
            return true;
        }
        java.lang.Class<?> rawType = com.google.gson.internal.C$Gson$Types.getRawType(type);
        java.lang.reflect.ParameterizedType parameterizedType2 = type instanceof java.lang.reflect.ParameterizedType ? (java.lang.reflect.ParameterizedType) type : null;
        if (parameterizedType2 != null) {
            java.lang.reflect.Type[] actualTypeArguments = parameterizedType2.getActualTypeArguments();
            java.lang.reflect.TypeVariable<java.lang.Class<?>>[] typeParameters = rawType.getTypeParameters();
            for (int i = 0; i < actualTypeArguments.length; i++) {
                java.lang.reflect.Type type2 = actualTypeArguments[i];
                java.lang.reflect.TypeVariable<java.lang.Class<?>> typeVariable = typeParameters[i];
                while (type2 instanceof java.lang.reflect.TypeVariable) {
                    type2 = map.get(((java.lang.reflect.TypeVariable) type2).getName());
                }
                map.put(typeVariable.getName(), type2);
            }
            if (typeEquals(parameterizedType2, parameterizedType, map)) {
                return true;
            }
        }
        for (java.lang.reflect.Type type3 : rawType.getGenericInterfaces()) {
            if (isAssignableFrom(type3, parameterizedType, new java.util.HashMap(map))) {
                return true;
            }
        }
        return isAssignableFrom(rawType.getGenericSuperclass(), parameterizedType, new java.util.HashMap(map));
    }

    private static boolean matches(java.lang.reflect.Type type, java.lang.reflect.Type type2, java.util.Map<java.lang.String, java.lang.reflect.Type> map) {
        return type2.equals(type) || ((type instanceof java.lang.reflect.TypeVariable) && type2.equals(map.get(((java.lang.reflect.TypeVariable) type).getName())));
    }

    private static boolean typeEquals(java.lang.reflect.ParameterizedType parameterizedType, java.lang.reflect.ParameterizedType parameterizedType2, java.util.Map<java.lang.String, java.lang.reflect.Type> map) {
        if (!parameterizedType.getRawType().equals(parameterizedType2.getRawType())) {
            return false;
        }
        java.lang.reflect.Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        java.lang.reflect.Type[] actualTypeArguments2 = parameterizedType2.getActualTypeArguments();
        for (int i = 0; i < actualTypeArguments.length; i++) {
            if (!matches(actualTypeArguments[i], actualTypeArguments2[i], map)) {
                return false;
            }
        }
        return true;
    }

    public final boolean equals(java.lang.Object obj) {
        return (obj instanceof com.google.gson.reflect.TypeToken) && com.google.gson.internal.C$Gson$Types.equals(this.type, ((com.google.gson.reflect.TypeToken) obj).type);
    }

    public final java.lang.Class<? super T> getRawType() {
        return this.rawType;
    }

    public final java.lang.reflect.Type getType() {
        return this.type;
    }

    public final int hashCode() {
        return this.hashCode;
    }

    @java.lang.Deprecated
    public boolean isAssignableFrom(com.google.gson.reflect.TypeToken<?> typeToken) {
        return isAssignableFrom(typeToken.getType());
    }

    @java.lang.Deprecated
    public boolean isAssignableFrom(java.lang.Class<?> cls) {
        return isAssignableFrom((java.lang.reflect.Type) cls);
    }

    @java.lang.Deprecated
    public boolean isAssignableFrom(java.lang.reflect.Type type) {
        if (type == null) {
            return false;
        }
        if (this.type.equals(type)) {
            return true;
        }
        java.lang.reflect.Type type2 = this.type;
        if (type2 instanceof java.lang.Class) {
            return this.rawType.isAssignableFrom(com.google.gson.internal.C$Gson$Types.getRawType(type));
        }
        if (type2 instanceof java.lang.reflect.ParameterizedType) {
            return isAssignableFrom(type, (java.lang.reflect.ParameterizedType) type2, new java.util.HashMap());
        }
        if (type2 instanceof java.lang.reflect.GenericArrayType) {
            return this.rawType.isAssignableFrom(com.google.gson.internal.C$Gson$Types.getRawType(type)) && isAssignableFrom(type, (java.lang.reflect.GenericArrayType) this.type);
        }
        throw buildUnexpectedTypeError(type2, java.lang.Class.class, java.lang.reflect.ParameterizedType.class, java.lang.reflect.GenericArrayType.class);
    }

    public final java.lang.String toString() {
        return com.google.gson.internal.C$Gson$Types.typeToString(this.type);
    }
}
