package com.badlogic.gdx.utils.reflect;

/* loaded from: classes12.dex */
public final class Field {
    public final java.lang.reflect.Field a;

    public Field(java.lang.reflect.Field field) {
        this.a = field;
    }

    public java.lang.Object get(java.lang.Object obj) throws com.badlogic.gdx.utils.reflect.ReflectionException {
        try {
            return this.a.get(obj);
        } catch (java.lang.IllegalAccessException e) {
            throw new com.badlogic.gdx.utils.reflect.ReflectionException("Illegal access to field: " + getName(), e);
        } catch (java.lang.IllegalArgumentException e2) {
            throw new com.badlogic.gdx.utils.reflect.ReflectionException("Object is not an instance of " + getDeclaringClass(), e2);
        }
    }

    public com.badlogic.gdx.utils.reflect.Annotation getDeclaredAnnotation(java.lang.Class<? extends java.lang.annotation.Annotation> cls) {
        java.lang.annotation.Annotation[] declaredAnnotations = this.a.getDeclaredAnnotations();
        if (declaredAnnotations == null) {
            return null;
        }
        for (java.lang.annotation.Annotation annotation : declaredAnnotations) {
            if (annotation.annotationType().equals(cls)) {
                return new com.badlogic.gdx.utils.reflect.Annotation(annotation);
            }
        }
        return null;
    }

    public com.badlogic.gdx.utils.reflect.Annotation[] getDeclaredAnnotations() {
        java.lang.annotation.Annotation[] declaredAnnotations = this.a.getDeclaredAnnotations();
        com.badlogic.gdx.utils.reflect.Annotation[] annotationArr = new com.badlogic.gdx.utils.reflect.Annotation[declaredAnnotations.length];
        for (int i = 0; i < declaredAnnotations.length; i++) {
            annotationArr[i] = new com.badlogic.gdx.utils.reflect.Annotation(declaredAnnotations[i]);
        }
        return annotationArr;
    }

    public java.lang.Class getDeclaringClass() {
        return this.a.getDeclaringClass();
    }

    public java.lang.Class getElementType(int i) {
        java.lang.reflect.Type genericType = this.a.getGenericType();
        if (!(genericType instanceof java.lang.reflect.ParameterizedType)) {
            return null;
        }
        java.lang.reflect.Type[] actualTypeArguments = ((java.lang.reflect.ParameterizedType) genericType).getActualTypeArguments();
        if (actualTypeArguments.length - 1 < i) {
            return null;
        }
        java.lang.reflect.Type type = actualTypeArguments[i];
        if (type instanceof java.lang.Class) {
            return (java.lang.Class) type;
        }
        if (type instanceof java.lang.reflect.ParameterizedType) {
            return (java.lang.Class) ((java.lang.reflect.ParameterizedType) type).getRawType();
        }
        if (!(type instanceof java.lang.reflect.GenericArrayType)) {
            return null;
        }
        java.lang.reflect.Type genericComponentType = ((java.lang.reflect.GenericArrayType) type).getGenericComponentType();
        if (genericComponentType instanceof java.lang.Class) {
            return com.badlogic.gdx.utils.reflect.ArrayReflection.newInstance((java.lang.Class) genericComponentType, 0).getClass();
        }
        return null;
    }

    public java.lang.String getName() {
        return this.a.getName();
    }

    public java.lang.Class getType() {
        return this.a.getType();
    }

    public boolean isAccessible() {
        return this.a.isAccessible();
    }

    public boolean isAnnotationPresent(java.lang.Class<? extends java.lang.annotation.Annotation> cls) {
        return this.a.isAnnotationPresent(cls);
    }

    public boolean isDefaultAccess() {
        return (isPrivate() || isProtected() || isPublic()) ? false : true;
    }

    public boolean isFinal() {
        return java.lang.reflect.Modifier.isFinal(this.a.getModifiers());
    }

    public boolean isPrivate() {
        return java.lang.reflect.Modifier.isPrivate(this.a.getModifiers());
    }

    public boolean isProtected() {
        return java.lang.reflect.Modifier.isProtected(this.a.getModifiers());
    }

    public boolean isPublic() {
        return java.lang.reflect.Modifier.isPublic(this.a.getModifiers());
    }

    public boolean isStatic() {
        return java.lang.reflect.Modifier.isStatic(this.a.getModifiers());
    }

    public boolean isSynthetic() {
        return this.a.isSynthetic();
    }

    public boolean isTransient() {
        return java.lang.reflect.Modifier.isTransient(this.a.getModifiers());
    }

    public boolean isVolatile() {
        return java.lang.reflect.Modifier.isVolatile(this.a.getModifiers());
    }

    public void set(java.lang.Object obj, java.lang.Object obj2) throws com.badlogic.gdx.utils.reflect.ReflectionException {
        try {
            this.a.set(obj, obj2);
        } catch (java.lang.IllegalAccessException e) {
            throw new com.badlogic.gdx.utils.reflect.ReflectionException("Illegal access to field: " + getName(), e);
        } catch (java.lang.IllegalArgumentException e2) {
            throw new com.badlogic.gdx.utils.reflect.ReflectionException("Argument not valid for field: " + getName(), e2);
        }
    }

    public void setAccessible(boolean z) {
        this.a.setAccessible(z);
    }
}
