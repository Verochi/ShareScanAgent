package com.badlogic.gdx.utils;

/* loaded from: classes12.dex */
public class Json {
    public com.badlogic.gdx.utils.JsonWriter a;
    public java.lang.String b;
    public boolean c;
    public com.badlogic.gdx.utils.JsonWriter.OutputType d;
    public boolean e;
    public boolean f;
    public boolean g;
    public boolean h;
    public com.badlogic.gdx.utils.Json.Serializer i;
    public final com.badlogic.gdx.utils.ObjectMap<java.lang.Class, com.badlogic.gdx.utils.OrderedMap<java.lang.String, com.badlogic.gdx.utils.Json.FieldMetadata>> j;
    public final com.badlogic.gdx.utils.ObjectMap<java.lang.String, java.lang.Class> k;
    public final com.badlogic.gdx.utils.ObjectMap<java.lang.Class, java.lang.String> l;
    public final com.badlogic.gdx.utils.ObjectMap<java.lang.Class, com.badlogic.gdx.utils.Json.Serializer> m;
    public final com.badlogic.gdx.utils.ObjectMap<java.lang.Class, java.lang.Object[]> n;
    public final java.lang.Object[] o;
    public final java.lang.Object[] p;

    public static class FieldMetadata {
        public com.badlogic.gdx.utils.reflect.Field a;
        public java.lang.Class b;

        public FieldMetadata(com.badlogic.gdx.utils.reflect.Field field) {
            this.a = field;
            this.b = field.getElementType((com.badlogic.gdx.utils.reflect.ClassReflection.isAssignableFrom(com.badlogic.gdx.utils.ObjectMap.class, field.getType()) || com.badlogic.gdx.utils.reflect.ClassReflection.isAssignableFrom(java.util.Map.class, field.getType())) ? 1 : 0);
        }
    }

    public static abstract class ReadOnlySerializer<T> implements com.badlogic.gdx.utils.Json.Serializer<T> {
        @Override // com.badlogic.gdx.utils.Json.Serializer
        public abstract T read(com.badlogic.gdx.utils.Json json, com.badlogic.gdx.utils.JsonValue jsonValue, java.lang.Class cls);

        @Override // com.badlogic.gdx.utils.Json.Serializer
        public void write(com.badlogic.gdx.utils.Json json, T t, java.lang.Class cls) {
        }
    }

    public interface Serializable {
        void read(com.badlogic.gdx.utils.Json json, com.badlogic.gdx.utils.JsonValue jsonValue);

        void write(com.badlogic.gdx.utils.Json json);
    }

    public interface Serializer<T> {
        T read(com.badlogic.gdx.utils.Json json, com.badlogic.gdx.utils.JsonValue jsonValue, java.lang.Class cls);

        void write(com.badlogic.gdx.utils.Json json, T t, java.lang.Class cls);
    }

    public Json() {
        this.b = "class";
        this.c = true;
        this.h = true;
        this.j = new com.badlogic.gdx.utils.ObjectMap<>();
        this.k = new com.badlogic.gdx.utils.ObjectMap<>();
        this.l = new com.badlogic.gdx.utils.ObjectMap<>();
        this.m = new com.badlogic.gdx.utils.ObjectMap<>();
        this.n = new com.badlogic.gdx.utils.ObjectMap<>();
        this.o = new java.lang.Object[]{null};
        this.p = new java.lang.Object[]{null};
        this.d = com.badlogic.gdx.utils.JsonWriter.OutputType.minimal;
    }

    public Json(com.badlogic.gdx.utils.JsonWriter.OutputType outputType) {
        this.b = "class";
        this.c = true;
        this.h = true;
        this.j = new com.badlogic.gdx.utils.ObjectMap<>();
        this.k = new com.badlogic.gdx.utils.ObjectMap<>();
        this.l = new com.badlogic.gdx.utils.ObjectMap<>();
        this.m = new com.badlogic.gdx.utils.ObjectMap<>();
        this.n = new com.badlogic.gdx.utils.ObjectMap<>();
        this.o = new java.lang.Object[]{null};
        this.p = new java.lang.Object[]{null};
        this.d = outputType;
    }

    public final java.lang.String a(java.lang.Enum r2) {
        return this.h ? r2.name() : r2.toString();
    }

    public void addClassTag(java.lang.String str, java.lang.Class cls) {
        this.k.put(str, cls);
        this.l.put(cls, str);
    }

    public final java.lang.String b(java.lang.Object obj) {
        return obj instanceof java.lang.Enum ? a((java.lang.Enum) obj) : obj instanceof java.lang.Class ? ((java.lang.Class) obj).getName() : java.lang.String.valueOf(obj);
    }

    public final java.lang.Object[] c(java.lang.Class cls) {
        if (!this.c) {
            return null;
        }
        if (this.n.containsKey(cls)) {
            return this.n.get(cls);
        }
        try {
            java.lang.Object newInstance = newInstance(cls);
            com.badlogic.gdx.utils.OrderedMap<java.lang.String, com.badlogic.gdx.utils.Json.FieldMetadata> d = d(cls);
            java.lang.Object[] objArr = new java.lang.Object[d.size];
            this.n.put(cls, objArr);
            com.badlogic.gdx.utils.ObjectMap.Values<com.badlogic.gdx.utils.Json.FieldMetadata> it = d.values().iterator();
            int i = 0;
            while (it.hasNext()) {
                com.badlogic.gdx.utils.reflect.Field field = it.next().a;
                int i2 = i + 1;
                try {
                    objArr[i] = field.get(newInstance);
                    i = i2;
                } catch (com.badlogic.gdx.utils.SerializationException e) {
                    e.addTrace(field + " (" + cls.getName() + ")");
                    throw e;
                } catch (com.badlogic.gdx.utils.reflect.ReflectionException e2) {
                    throw new com.badlogic.gdx.utils.SerializationException("Error accessing field: " + field.getName() + " (" + cls.getName() + ")", e2);
                } catch (java.lang.RuntimeException e3) {
                    com.badlogic.gdx.utils.SerializationException serializationException = new com.badlogic.gdx.utils.SerializationException(e3);
                    serializationException.addTrace(field + " (" + cls.getName() + ")");
                    throw serializationException;
                }
            }
            return objArr;
        } catch (java.lang.Exception unused) {
            this.n.put(cls, null);
            return null;
        }
    }

    public final com.badlogic.gdx.utils.OrderedMap<java.lang.String, com.badlogic.gdx.utils.Json.FieldMetadata> d(java.lang.Class cls) {
        com.badlogic.gdx.utils.OrderedMap<java.lang.String, com.badlogic.gdx.utils.Json.FieldMetadata> orderedMap = this.j.get(cls);
        if (orderedMap != null) {
            return orderedMap;
        }
        com.badlogic.gdx.utils.Array array = new com.badlogic.gdx.utils.Array();
        for (java.lang.Class cls2 = cls; cls2 != java.lang.Object.class; cls2 = cls2.getSuperclass()) {
            array.add(cls2);
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (int i = array.size - 1; i >= 0; i--) {
            java.util.Collections.addAll(arrayList, com.badlogic.gdx.utils.reflect.ClassReflection.getDeclaredFields((java.lang.Class) array.get(i)));
        }
        com.badlogic.gdx.utils.OrderedMap<java.lang.String, com.badlogic.gdx.utils.Json.FieldMetadata> orderedMap2 = new com.badlogic.gdx.utils.OrderedMap<>(arrayList.size());
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            com.badlogic.gdx.utils.reflect.Field field = (com.badlogic.gdx.utils.reflect.Field) arrayList.get(i2);
            if (!field.isTransient() && !field.isStatic() && !field.isSynthetic()) {
                if (!field.isAccessible()) {
                    try {
                        field.setAccessible(true);
                    } catch (java.security.AccessControlException unused) {
                    }
                }
                if (!this.g || !field.isAnnotationPresent(java.lang.Deprecated.class)) {
                    orderedMap2.put(field.getName(), new com.badlogic.gdx.utils.Json.FieldMetadata(field));
                }
            }
        }
        this.j.put(cls, orderedMap2);
        return orderedMap2;
    }

    public <T> T fromJson(java.lang.Class<T> cls, com.badlogic.gdx.files.FileHandle fileHandle) {
        try {
            return (T) readValue(cls, (java.lang.Class) null, new com.badlogic.gdx.utils.JsonReader().parse(fileHandle));
        } catch (java.lang.Exception e) {
            throw new com.badlogic.gdx.utils.SerializationException("Error reading file: " + fileHandle, e);
        }
    }

    public <T> T fromJson(java.lang.Class<T> cls, java.io.InputStream inputStream) {
        return (T) readValue(cls, (java.lang.Class) null, new com.badlogic.gdx.utils.JsonReader().parse(inputStream));
    }

    public <T> T fromJson(java.lang.Class<T> cls, java.io.Reader reader) {
        return (T) readValue(cls, (java.lang.Class) null, new com.badlogic.gdx.utils.JsonReader().parse(reader));
    }

    public <T> T fromJson(java.lang.Class<T> cls, java.lang.Class cls2, com.badlogic.gdx.files.FileHandle fileHandle) {
        try {
            return (T) readValue(cls, cls2, new com.badlogic.gdx.utils.JsonReader().parse(fileHandle));
        } catch (java.lang.Exception e) {
            throw new com.badlogic.gdx.utils.SerializationException("Error reading file: " + fileHandle, e);
        }
    }

    public <T> T fromJson(java.lang.Class<T> cls, java.lang.Class cls2, java.io.InputStream inputStream) {
        return (T) readValue(cls, cls2, new com.badlogic.gdx.utils.JsonReader().parse(inputStream));
    }

    public <T> T fromJson(java.lang.Class<T> cls, java.lang.Class cls2, java.io.Reader reader) {
        return (T) readValue(cls, cls2, new com.badlogic.gdx.utils.JsonReader().parse(reader));
    }

    public <T> T fromJson(java.lang.Class<T> cls, java.lang.Class cls2, java.lang.String str) {
        return (T) readValue(cls, cls2, new com.badlogic.gdx.utils.JsonReader().parse(str));
    }

    public <T> T fromJson(java.lang.Class<T> cls, java.lang.Class cls2, char[] cArr, int i, int i2) {
        return (T) readValue(cls, cls2, new com.badlogic.gdx.utils.JsonReader().parse(cArr, i, i2));
    }

    public <T> T fromJson(java.lang.Class<T> cls, java.lang.String str) {
        return (T) readValue(cls, (java.lang.Class) null, new com.badlogic.gdx.utils.JsonReader().parse(str));
    }

    public <T> T fromJson(java.lang.Class<T> cls, char[] cArr, int i, int i2) {
        return (T) readValue(cls, (java.lang.Class) null, new com.badlogic.gdx.utils.JsonReader().parse(cArr, i, i2));
    }

    public java.lang.Class getClass(java.lang.String str) {
        return this.k.get(str);
    }

    public <T> com.badlogic.gdx.utils.Json.Serializer<T> getSerializer(java.lang.Class<T> cls) {
        return this.m.get(cls);
    }

    public java.lang.String getTag(java.lang.Class cls) {
        return this.l.get(cls);
    }

    public com.badlogic.gdx.utils.JsonWriter getWriter() {
        return this.a;
    }

    public java.lang.Object newInstance(java.lang.Class cls) {
        try {
            return com.badlogic.gdx.utils.reflect.ClassReflection.newInstance(cls);
        } catch (java.lang.Exception e) {
            e = e;
            try {
                com.badlogic.gdx.utils.reflect.Constructor declaredConstructor = com.badlogic.gdx.utils.reflect.ClassReflection.getDeclaredConstructor(cls, new java.lang.Class[0]);
                declaredConstructor.setAccessible(true);
                return declaredConstructor.newInstance(new java.lang.Object[0]);
            } catch (com.badlogic.gdx.utils.reflect.ReflectionException unused) {
                if (com.badlogic.gdx.utils.reflect.ClassReflection.isAssignableFrom(java.lang.Enum.class, cls)) {
                    if (cls.getEnumConstants() == null) {
                        cls = cls.getSuperclass();
                    }
                    return cls.getEnumConstants()[0];
                }
                if (cls.isArray()) {
                    throw new com.badlogic.gdx.utils.SerializationException("Encountered JSON object when expected array of type: " + cls.getName(), e);
                }
                if (!com.badlogic.gdx.utils.reflect.ClassReflection.isMemberClass(cls) || com.badlogic.gdx.utils.reflect.ClassReflection.isStaticClass(cls)) {
                    throw new com.badlogic.gdx.utils.SerializationException("Class cannot be created (missing no-arg constructor): " + cls.getName(), e);
                }
                throw new com.badlogic.gdx.utils.SerializationException("Class cannot be created (non-static member class): " + cls.getName(), e);
            } catch (java.lang.SecurityException unused2) {
                throw new com.badlogic.gdx.utils.SerializationException("Error constructing instance of class: " + cls.getName(), e);
            } catch (java.lang.Exception e2) {
                e = e2;
                throw new com.badlogic.gdx.utils.SerializationException("Error constructing instance of class: " + cls.getName(), e);
            }
        }
    }

    public java.lang.String prettyPrint(java.lang.Object obj) {
        return prettyPrint(obj, 0);
    }

    public java.lang.String prettyPrint(java.lang.Object obj, int i) {
        return prettyPrint(toJson(obj), i);
    }

    public java.lang.String prettyPrint(java.lang.Object obj, com.badlogic.gdx.utils.JsonValue.PrettyPrintSettings prettyPrintSettings) {
        return prettyPrint(toJson(obj), prettyPrintSettings);
    }

    public java.lang.String prettyPrint(java.lang.String str) {
        return prettyPrint(str, 0);
    }

    public java.lang.String prettyPrint(java.lang.String str, int i) {
        return new com.badlogic.gdx.utils.JsonReader().parse(str).prettyPrint(this.d, i);
    }

    public java.lang.String prettyPrint(java.lang.String str, com.badlogic.gdx.utils.JsonValue.PrettyPrintSettings prettyPrintSettings) {
        return new com.badlogic.gdx.utils.JsonReader().parse(str).prettyPrint(prettyPrintSettings);
    }

    public void readField(java.lang.Object obj, com.badlogic.gdx.utils.reflect.Field field, java.lang.String str, java.lang.Class cls, com.badlogic.gdx.utils.JsonValue jsonValue) {
        com.badlogic.gdx.utils.JsonValue jsonValue2 = jsonValue.get(str);
        if (jsonValue2 == null) {
            return;
        }
        try {
            field.set(obj, readValue(field.getType(), cls, jsonValue2));
        } catch (com.badlogic.gdx.utils.SerializationException e) {
            e.addTrace(field.getName() + " (" + field.getDeclaringClass().getName() + ")");
            throw e;
        } catch (com.badlogic.gdx.utils.reflect.ReflectionException e2) {
            throw new com.badlogic.gdx.utils.SerializationException("Error accessing field: " + field.getName() + " (" + field.getDeclaringClass().getName() + ")", e2);
        } catch (java.lang.RuntimeException e3) {
            com.badlogic.gdx.utils.SerializationException serializationException = new com.badlogic.gdx.utils.SerializationException(e3);
            serializationException.addTrace(jsonValue2.trace());
            serializationException.addTrace(field.getName() + " (" + field.getDeclaringClass().getName() + ")");
            throw serializationException;
        }
    }

    public void readField(java.lang.Object obj, java.lang.String str, com.badlogic.gdx.utils.JsonValue jsonValue) {
        readField(obj, str, str, (java.lang.Class) null, jsonValue);
    }

    public void readField(java.lang.Object obj, java.lang.String str, java.lang.Class cls, com.badlogic.gdx.utils.JsonValue jsonValue) {
        readField(obj, str, str, cls, jsonValue);
    }

    public void readField(java.lang.Object obj, java.lang.String str, java.lang.String str2, com.badlogic.gdx.utils.JsonValue jsonValue) {
        readField(obj, str, str2, (java.lang.Class) null, jsonValue);
    }

    public void readField(java.lang.Object obj, java.lang.String str, java.lang.String str2, java.lang.Class cls, com.badlogic.gdx.utils.JsonValue jsonValue) {
        java.lang.Class<?> cls2 = obj.getClass();
        com.badlogic.gdx.utils.Json.FieldMetadata fieldMetadata = d(cls2).get(str);
        if (fieldMetadata != null) {
            com.badlogic.gdx.utils.reflect.Field field = fieldMetadata.a;
            if (cls == null) {
                cls = fieldMetadata.b;
            }
            readField(obj, field, str2, cls, jsonValue);
            return;
        }
        throw new com.badlogic.gdx.utils.SerializationException("Field not found: " + str + " (" + cls2.getName() + ")");
    }

    public void readFields(java.lang.Object obj, com.badlogic.gdx.utils.JsonValue jsonValue) {
        java.lang.Class<?> cls = obj.getClass();
        com.badlogic.gdx.utils.OrderedMap<java.lang.String, com.badlogic.gdx.utils.Json.FieldMetadata> d = d(cls);
        for (com.badlogic.gdx.utils.JsonValue jsonValue2 = jsonValue.child; jsonValue2 != null; jsonValue2 = jsonValue2.next) {
            com.badlogic.gdx.utils.Json.FieldMetadata fieldMetadata = d.get(jsonValue2.name);
            if (fieldMetadata != null) {
                com.badlogic.gdx.utils.reflect.Field field = fieldMetadata.a;
                try {
                    field.set(obj, readValue(field.getType(), fieldMetadata.b, jsonValue2));
                } catch (com.badlogic.gdx.utils.SerializationException e) {
                    e.addTrace(field.getName() + " (" + cls.getName() + ")");
                    throw e;
                } catch (com.badlogic.gdx.utils.reflect.ReflectionException e2) {
                    throw new com.badlogic.gdx.utils.SerializationException("Error accessing field: " + field.getName() + " (" + cls.getName() + ")", e2);
                } catch (java.lang.RuntimeException e3) {
                    com.badlogic.gdx.utils.SerializationException serializationException = new com.badlogic.gdx.utils.SerializationException(e3);
                    serializationException.addTrace(jsonValue2.trace());
                    serializationException.addTrace(field.getName() + " (" + cls.getName() + ")");
                    throw serializationException;
                }
            } else if (!jsonValue2.name.equals(this.b) && !this.f) {
                com.badlogic.gdx.utils.SerializationException serializationException2 = new com.badlogic.gdx.utils.SerializationException("Field not found: " + jsonValue2.name + " (" + cls.getName() + ")");
                serializationException2.addTrace(jsonValue2.trace());
                throw serializationException2;
            }
        }
    }

    public <T> T readValue(java.lang.Class<T> cls, com.badlogic.gdx.utils.JsonValue jsonValue) {
        return (T) readValue(cls, (java.lang.Class) null, jsonValue);
    }

    /* JADX WARN: Code restructure failed: missing block: B:171:0x0297, code lost:
    
        if (r4 == r3) goto L268;
     */
    /* JADX WARN: Code restructure failed: missing block: B:206:0x0234, code lost:
    
        if (r4 != r0) goto L179;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0374 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:174:0x02b3  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x028f  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x02bb  */
    /* JADX WARN: Type inference failed for: r0v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r2v0, types: [T, com.badlogic.gdx.utils.JsonValue] */
    /* JADX WARN: Type inference failed for: r3v51, types: [T, java.util.Map] */
    /* JADX WARN: Type inference failed for: r3v52, types: [T, com.badlogic.gdx.utils.ArrayMap] */
    /* JADX WARN: Type inference failed for: r3v53, types: [T, com.badlogic.gdx.utils.ObjectMap] */
    /* JADX WARN: Type inference failed for: r7v2, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r9v1, types: [T, java.lang.Enum] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public <T> T readValue(java.lang.Class<T> cls, java.lang.Class cls2, com.badlogic.gdx.utils.JsonValue jsonValue) {
        java.lang.Class<T> cls3;
        com.badlogic.gdx.utils.JsonValue jsonValue2;
        ?? isNumber;
        com.badlogic.gdx.utils.JsonValue jsonValue3;
        java.lang.Class<T> cls4;
        java.lang.Class<T> cls5;
        com.badlogic.gdx.utils.JsonValue jsonValue4;
        java.lang.Class cls6 = cls2;
        ?? r2 = (T) jsonValue;
        if (r2 == 0) {
            return null;
        }
        if (jsonValue.isObject()) {
            java.lang.String str = this.b;
            java.lang.String string = str == null ? null : r2.getString(str, null);
            if (string != null) {
                java.lang.Class<T> cls7 = getClass(string);
                if (cls7 == null) {
                    try {
                        cls3 = com.badlogic.gdx.utils.reflect.ClassReflection.forName(string);
                    } catch (com.badlogic.gdx.utils.reflect.ReflectionException e) {
                        throw new com.badlogic.gdx.utils.SerializationException(e);
                    }
                } else {
                    cls3 = cls7;
                }
            } else {
                cls3 = cls;
            }
            if (cls3 == null) {
                com.badlogic.gdx.utils.Json.Serializer serializer = this.i;
                return serializer != 0 ? (T) serializer.read(this, r2, cls3) : r2;
            }
            if (this.b == null || !com.badlogic.gdx.utils.reflect.ClassReflection.isAssignableFrom(java.util.Collection.class, cls3)) {
                com.badlogic.gdx.utils.Json.Serializer serializer2 = this.m.get(cls3);
                if (serializer2 != 0) {
                    return (T) serializer2.read(this, r2, cls3);
                }
                if (cls3 == java.lang.String.class || cls3 == java.lang.Integer.class || cls3 == java.lang.Boolean.class || cls3 == java.lang.Float.class || cls3 == java.lang.Long.class || cls3 == java.lang.Double.class || cls3 == java.lang.Short.class || cls3 == java.lang.Byte.class || cls3 == java.lang.Character.class || com.badlogic.gdx.utils.reflect.ClassReflection.isAssignableFrom(java.lang.Enum.class, cls3)) {
                    return (T) readValue("value", cls3, (com.badlogic.gdx.utils.JsonValue) r2);
                }
                T t = (T) newInstance(cls3);
                if (t instanceof com.badlogic.gdx.utils.Json.Serializable) {
                    ((com.badlogic.gdx.utils.Json.Serializable) t).read(this, r2);
                    return t;
                }
                if (t instanceof com.badlogic.gdx.utils.ObjectMap) {
                    ?? r3 = (T) ((com.badlogic.gdx.utils.ObjectMap) t);
                    for (com.badlogic.gdx.utils.JsonValue jsonValue5 = r2.child; jsonValue5 != null; jsonValue5 = jsonValue5.next) {
                        r3.put(jsonValue5.name, readValue(cls6, (java.lang.Class) null, jsonValue5));
                    }
                    return r3;
                }
                if (t instanceof com.badlogic.gdx.utils.ArrayMap) {
                    ?? r32 = (T) ((com.badlogic.gdx.utils.ArrayMap) t);
                    for (com.badlogic.gdx.utils.JsonValue jsonValue6 = r2.child; jsonValue6 != null; jsonValue6 = jsonValue6.next) {
                        r32.put(jsonValue6.name, readValue(cls6, (java.lang.Class) null, jsonValue6));
                    }
                    return r32;
                }
                if (!(t instanceof java.util.Map)) {
                    readFields(t, r2);
                    return t;
                }
                ?? r33 = (T) ((java.util.Map) t);
                for (com.badlogic.gdx.utils.JsonValue jsonValue7 = r2.child; jsonValue7 != null; jsonValue7 = jsonValue7.next) {
                    if (!jsonValue7.name.equals(this.b)) {
                        r33.put(jsonValue7.name, readValue(cls6, (java.lang.Class) null, jsonValue7));
                    }
                }
                return r33;
            }
            jsonValue2 = (T) r2.get("items");
        } else {
            cls3 = cls;
            jsonValue2 = r2;
        }
        if (cls3 != null) {
            com.badlogic.gdx.utils.Json.Serializer serializer3 = this.m.get(cls3);
            if (serializer3 != null) {
                return (T) serializer3.read(this, jsonValue2, cls3);
            }
            if (com.badlogic.gdx.utils.reflect.ClassReflection.isAssignableFrom(com.badlogic.gdx.utils.Json.Serializable.class, cls3)) {
                T t2 = (T) newInstance(cls3);
                ((com.badlogic.gdx.utils.Json.Serializable) t2).read(this, jsonValue2);
                return t2;
            }
        }
        int i = 0;
        if (jsonValue2.isArray()) {
            if (cls3 == null || cls3 == java.lang.Object.class) {
                cls3 = com.badlogic.gdx.utils.Array.class;
            }
            if (com.badlogic.gdx.utils.reflect.ClassReflection.isAssignableFrom(com.badlogic.gdx.utils.Array.class, cls3)) {
                java.lang.Object obj = cls3 == com.badlogic.gdx.utils.Array.class ? (T) new com.badlogic.gdx.utils.Array() : (T) ((com.badlogic.gdx.utils.Array) newInstance(cls3));
                for (com.badlogic.gdx.utils.JsonValue jsonValue8 = jsonValue2.child; jsonValue8 != null; jsonValue8 = jsonValue8.next) {
                    ((com.badlogic.gdx.utils.Array) obj).add(readValue(cls6, (java.lang.Class) null, jsonValue8));
                }
                return (T) obj;
            }
            if (com.badlogic.gdx.utils.reflect.ClassReflection.isAssignableFrom(com.badlogic.gdx.utils.Queue.class, cls3)) {
                java.lang.Object obj2 = cls3 == com.badlogic.gdx.utils.Queue.class ? (T) new com.badlogic.gdx.utils.Queue() : (T) ((com.badlogic.gdx.utils.Queue) newInstance(cls3));
                for (com.badlogic.gdx.utils.JsonValue jsonValue9 = jsonValue2.child; jsonValue9 != null; jsonValue9 = jsonValue9.next) {
                    ((com.badlogic.gdx.utils.Queue) obj2).addLast(readValue(cls6, (java.lang.Class) null, jsonValue9));
                }
                return (T) obj2;
            }
            if (com.badlogic.gdx.utils.reflect.ClassReflection.isAssignableFrom(java.util.Collection.class, cls3)) {
                T t3 = cls3.isInterface() ? (T) new java.util.ArrayList() : (T) ((java.util.Collection) newInstance(cls3));
                for (com.badlogic.gdx.utils.JsonValue jsonValue10 = jsonValue2.child; jsonValue10 != null; jsonValue10 = jsonValue10.next) {
                    ((java.util.Collection) t3).add(readValue(cls6, (java.lang.Class) null, jsonValue10));
                }
                return t3;
            }
            if (!cls3.isArray()) {
                throw new com.badlogic.gdx.utils.SerializationException("Unable to convert value to required type: " + jsonValue2 + " (" + cls3.getName() + ")");
            }
            java.lang.Class<?> componentType = cls3.getComponentType();
            if (cls6 == null) {
                cls6 = componentType;
            }
            T t4 = (T) com.badlogic.gdx.utils.reflect.ArrayReflection.newInstance(componentType, jsonValue2.size);
            com.badlogic.gdx.utils.JsonValue jsonValue11 = jsonValue2.child;
            while (jsonValue11 != null) {
                com.badlogic.gdx.utils.reflect.ArrayReflection.set(t4, i, readValue(cls6, (java.lang.Class) null, jsonValue11));
                jsonValue11 = jsonValue11.next;
                i++;
            }
            return t4;
        }
        isNumber = jsonValue2.isNumber();
        if (isNumber != 0) {
            try {
                if (cls3 != null) {
                    try {
                        if (cls3 != java.lang.Float.TYPE && cls3 != java.lang.Float.class) {
                            if (cls3 != java.lang.Integer.TYPE && cls3 != java.lang.Integer.class) {
                                if (cls3 != java.lang.Long.TYPE && cls3 != java.lang.Long.class) {
                                    if (cls3 != java.lang.Double.TYPE && cls3 != java.lang.Double.class) {
                                        if (cls3 == java.lang.String.class) {
                                            return (T) jsonValue2.asString();
                                        }
                                        if (cls3 != java.lang.Short.TYPE && cls3 != java.lang.Short.class) {
                                            if (cls3 != java.lang.Byte.TYPE) {
                                                isNumber = java.lang.Byte.class;
                                            }
                                            return (T) java.lang.Byte.valueOf(jsonValue2.asByte());
                                        }
                                        return (T) java.lang.Short.valueOf(jsonValue2.asShort());
                                    }
                                    return (T) java.lang.Double.valueOf(jsonValue2.asDouble());
                                }
                                return (T) java.lang.Long.valueOf(jsonValue2.asLong());
                            }
                            return (T) java.lang.Integer.valueOf(jsonValue2.asInt());
                        }
                    } catch (java.lang.NumberFormatException unused) {
                        isNumber = java.lang.Byte.class;
                    }
                }
                return (T) java.lang.Float.valueOf(jsonValue2.asFloat());
            } catch (java.lang.NumberFormatException unused2) {
            }
        } else {
            cls4 = java.lang.Byte.class;
            jsonValue3 = jsonValue2;
        }
        if (jsonValue3.isBoolean()) {
            cls5 = java.lang.Boolean.class;
            jsonValue4 = jsonValue3;
        } else {
            if (cls3 != null) {
                try {
                    if (cls3 != java.lang.Boolean.TYPE) {
                        cls5 = java.lang.Boolean.class;
                    }
                } catch (java.lang.NumberFormatException unused3) {
                    cls5 = java.lang.Boolean.class;
                }
            }
            cls5 = java.lang.Boolean.class;
            try {
                return (T) java.lang.Boolean.valueOf(jsonValue3.asBoolean());
            } catch (java.lang.NumberFormatException unused4) {
                jsonValue4 = new com.badlogic.gdx.utils.JsonValue(jsonValue3.asString());
                if (!jsonValue4.isString()) {
                }
            }
        }
        if (!jsonValue4.isString()) {
            return null;
        }
        ?? r7 = (T) jsonValue4.asString();
        if (cls3 == null || cls3 == java.lang.String.class) {
            return r7;
        }
        if (cls3 != java.lang.Integer.TYPE && cls3 != java.lang.Integer.class) {
            if (cls3 != java.lang.Float.TYPE && cls3 != java.lang.Float.class) {
                if (cls3 != java.lang.Long.TYPE && cls3 != java.lang.Long.class) {
                    if (cls3 != java.lang.Double.TYPE && cls3 != java.lang.Double.class) {
                        if (cls3 != java.lang.Short.TYPE && cls3 != java.lang.Short.class) {
                            if (cls3 == java.lang.Byte.TYPE || cls3 == cls4) {
                                return (T) java.lang.Byte.valueOf((java.lang.String) r7);
                            }
                            if (cls3 == java.lang.Boolean.TYPE || cls3 == cls5) {
                                return (T) java.lang.Boolean.valueOf((java.lang.String) r7);
                            }
                            if (cls3 == java.lang.Character.TYPE || cls3 == java.lang.Character.class) {
                                return (T) java.lang.Character.valueOf(r7.charAt(0));
                            }
                            if (com.badlogic.gdx.utils.reflect.ClassReflection.isAssignableFrom(java.lang.Enum.class, cls3)) {
                                java.lang.Object[] objArr = (java.lang.Enum[]) cls3.getEnumConstants();
                                int length = objArr.length;
                                while (i < length) {
                                    ?? r9 = (T) objArr[i];
                                    if (r7.equals(a(r9))) {
                                        return r9;
                                    }
                                    i++;
                                }
                            }
                            if (cls3 == java.lang.CharSequence.class) {
                                return r7;
                            }
                            throw new com.badlogic.gdx.utils.SerializationException("Unable to convert value to required type: " + jsonValue4 + " (" + cls3.getName() + ")");
                        }
                        return (T) java.lang.Short.valueOf((java.lang.String) r7);
                    }
                    return (T) java.lang.Double.valueOf((java.lang.String) r7);
                }
                return (T) java.lang.Long.valueOf((java.lang.String) r7);
            }
            return (T) java.lang.Float.valueOf((java.lang.String) r7);
        }
        return (T) java.lang.Integer.valueOf((java.lang.String) r7);
        jsonValue3 = new com.badlogic.gdx.utils.JsonValue(jsonValue2.asString());
        cls4 = isNumber;
        if (jsonValue3.isBoolean()) {
        }
        if (!jsonValue4.isString()) {
        }
    }

    public <T> T readValue(java.lang.Class<T> cls, java.lang.Class cls2, T t, com.badlogic.gdx.utils.JsonValue jsonValue) {
        return jsonValue == null ? t : (T) readValue(cls, cls2, jsonValue);
    }

    public <T> T readValue(java.lang.String str, java.lang.Class<T> cls, com.badlogic.gdx.utils.JsonValue jsonValue) {
        return (T) readValue(cls, (java.lang.Class) null, jsonValue.get(str));
    }

    public <T> T readValue(java.lang.String str, java.lang.Class<T> cls, java.lang.Class cls2, com.badlogic.gdx.utils.JsonValue jsonValue) {
        return (T) readValue(cls, cls2, jsonValue.get(str));
    }

    public <T> T readValue(java.lang.String str, java.lang.Class<T> cls, java.lang.Class cls2, T t, com.badlogic.gdx.utils.JsonValue jsonValue) {
        return (T) readValue((java.lang.Class<java.lang.Class>) cls, cls2, (java.lang.Class) t, jsonValue.get(str));
    }

    public <T> T readValue(java.lang.String str, java.lang.Class<T> cls, T t, com.badlogic.gdx.utils.JsonValue jsonValue) {
        com.badlogic.gdx.utils.JsonValue jsonValue2 = jsonValue.get(str);
        return jsonValue2 == null ? t : (T) readValue(cls, (java.lang.Class) null, jsonValue2);
    }

    public void setDefaultSerializer(com.badlogic.gdx.utils.Json.Serializer serializer) {
        this.i = serializer;
    }

    public void setElementType(java.lang.Class cls, java.lang.String str, java.lang.Class cls2) {
        com.badlogic.gdx.utils.Json.FieldMetadata fieldMetadata = d(cls).get(str);
        if (fieldMetadata != null) {
            fieldMetadata.b = cls2;
            return;
        }
        throw new com.badlogic.gdx.utils.SerializationException("Field not found: " + str + " (" + cls.getName() + ")");
    }

    public void setEnumNames(boolean z) {
        this.h = z;
    }

    public void setIgnoreDeprecated(boolean z) {
        this.g = z;
    }

    public void setIgnoreUnknownFields(boolean z) {
        this.f = z;
    }

    public void setOutputType(com.badlogic.gdx.utils.JsonWriter.OutputType outputType) {
        this.d = outputType;
    }

    public void setQuoteLongValues(boolean z) {
        this.e = z;
    }

    public <T> void setSerializer(java.lang.Class<T> cls, com.badlogic.gdx.utils.Json.Serializer<T> serializer) {
        this.m.put(cls, serializer);
    }

    public void setTypeName(java.lang.String str) {
        this.b = str;
    }

    public void setUsePrototypes(boolean z) {
        this.c = z;
    }

    public void setWriter(java.io.Writer writer) {
        if (!(writer instanceof com.badlogic.gdx.utils.JsonWriter)) {
            writer = new com.badlogic.gdx.utils.JsonWriter(writer);
        }
        com.badlogic.gdx.utils.JsonWriter jsonWriter = (com.badlogic.gdx.utils.JsonWriter) writer;
        this.a = jsonWriter;
        jsonWriter.setOutputType(this.d);
        this.a.setQuoteLongValues(this.e);
    }

    public java.lang.String toJson(java.lang.Object obj) {
        return toJson(obj, obj == null ? null : obj.getClass(), (java.lang.Class) null);
    }

    public java.lang.String toJson(java.lang.Object obj, java.lang.Class cls) {
        return toJson(obj, cls, (java.lang.Class) null);
    }

    public java.lang.String toJson(java.lang.Object obj, java.lang.Class cls, java.lang.Class cls2) {
        java.io.StringWriter stringWriter = new java.io.StringWriter();
        toJson(obj, cls, cls2, stringWriter);
        return stringWriter.toString();
    }

    public void toJson(java.lang.Object obj, com.badlogic.gdx.files.FileHandle fileHandle) {
        toJson(obj, obj == null ? null : obj.getClass(), (java.lang.Class) null, fileHandle);
    }

    public void toJson(java.lang.Object obj, java.io.Writer writer) {
        toJson(obj, obj == null ? null : obj.getClass(), (java.lang.Class) null, writer);
    }

    public void toJson(java.lang.Object obj, java.lang.Class cls, com.badlogic.gdx.files.FileHandle fileHandle) {
        toJson(obj, cls, (java.lang.Class) null, fileHandle);
    }

    public void toJson(java.lang.Object obj, java.lang.Class cls, java.io.Writer writer) {
        toJson(obj, cls, (java.lang.Class) null, writer);
    }

    public void toJson(java.lang.Object obj, java.lang.Class cls, java.lang.Class cls2, com.badlogic.gdx.files.FileHandle fileHandle) {
        java.io.Writer writer = null;
        try {
            try {
                writer = fileHandle.writer(false, "UTF-8");
                toJson(obj, cls, cls2, writer);
            } catch (java.lang.Exception e) {
                throw new com.badlogic.gdx.utils.SerializationException("Error writing file: " + fileHandle, e);
            }
        } finally {
            com.badlogic.gdx.utils.StreamUtils.closeQuietly(writer);
        }
    }

    public void toJson(java.lang.Object obj, java.lang.Class cls, java.lang.Class cls2, java.io.Writer writer) {
        setWriter(writer);
        try {
            writeValue(obj, cls, cls2);
        } finally {
            com.badlogic.gdx.utils.StreamUtils.closeQuietly(this.a);
            this.a = null;
        }
    }

    public void writeArrayEnd() {
        try {
            this.a.pop();
        } catch (java.io.IOException e) {
            throw new com.badlogic.gdx.utils.SerializationException(e);
        }
    }

    public void writeArrayStart() {
        try {
            this.a.array();
        } catch (java.io.IOException e) {
            throw new com.badlogic.gdx.utils.SerializationException(e);
        }
    }

    public void writeArrayStart(java.lang.String str) {
        try {
            this.a.name(str);
            this.a.array();
        } catch (java.io.IOException e) {
            throw new com.badlogic.gdx.utils.SerializationException(e);
        }
    }

    public void writeField(java.lang.Object obj, java.lang.String str) {
        writeField(obj, str, str, null);
    }

    public void writeField(java.lang.Object obj, java.lang.String str, java.lang.Class cls) {
        writeField(obj, str, str, cls);
    }

    public void writeField(java.lang.Object obj, java.lang.String str, java.lang.String str2) {
        writeField(obj, str, str2, null);
    }

    public void writeField(java.lang.Object obj, java.lang.String str, java.lang.String str2, java.lang.Class cls) {
        java.lang.Class<?> cls2 = obj.getClass();
        com.badlogic.gdx.utils.Json.FieldMetadata fieldMetadata = d(cls2).get(str);
        if (fieldMetadata == null) {
            throw new com.badlogic.gdx.utils.SerializationException("Field not found: " + str + " (" + cls2.getName() + ")");
        }
        com.badlogic.gdx.utils.reflect.Field field = fieldMetadata.a;
        if (cls == null) {
            cls = fieldMetadata.b;
        }
        try {
            this.a.name(str2);
            writeValue(field.get(obj), field.getType(), cls);
        } catch (com.badlogic.gdx.utils.SerializationException e) {
            e.addTrace(field + " (" + cls2.getName() + ")");
            throw e;
        } catch (com.badlogic.gdx.utils.reflect.ReflectionException e2) {
            throw new com.badlogic.gdx.utils.SerializationException("Error accessing field: " + field.getName() + " (" + cls2.getName() + ")", e2);
        } catch (java.lang.Exception e3) {
            com.badlogic.gdx.utils.SerializationException serializationException = new com.badlogic.gdx.utils.SerializationException(e3);
            serializationException.addTrace(field + " (" + cls2.getName() + ")");
            throw serializationException;
        }
    }

    public void writeFields(java.lang.Object obj) {
        java.lang.Class<?> cls = obj.getClass();
        java.lang.Object[] c = c(cls);
        java.util.Iterator it = new com.badlogic.gdx.utils.OrderedMap.OrderedMapValues(d(cls)).iterator();
        int i = 0;
        while (it.hasNext()) {
            com.badlogic.gdx.utils.Json.FieldMetadata fieldMetadata = (com.badlogic.gdx.utils.Json.FieldMetadata) it.next();
            com.badlogic.gdx.utils.reflect.Field field = fieldMetadata.a;
            try {
                java.lang.Object obj2 = field.get(obj);
                if (c != null) {
                    int i2 = i + 1;
                    java.lang.Object obj3 = c[i];
                    if (obj2 != null || obj3 != null) {
                        if (obj2 != null && obj3 != null) {
                            if (!obj2.equals(obj3)) {
                                if (obj2.getClass().isArray() && obj3.getClass().isArray()) {
                                    java.lang.Object[] objArr = this.o;
                                    objArr[0] = obj2;
                                    java.lang.Object[] objArr2 = this.p;
                                    objArr2[0] = obj3;
                                    if (java.util.Arrays.deepEquals(objArr, objArr2)) {
                                    }
                                }
                            }
                        }
                        i = i2;
                    }
                    i = i2;
                }
                this.a.name(field.getName());
                writeValue(obj2, field.getType(), fieldMetadata.b);
            } catch (com.badlogic.gdx.utils.SerializationException e) {
                e.addTrace(field + " (" + cls.getName() + ")");
                throw e;
            } catch (com.badlogic.gdx.utils.reflect.ReflectionException e2) {
                throw new com.badlogic.gdx.utils.SerializationException("Error accessing field: " + field.getName() + " (" + cls.getName() + ")", e2);
            } catch (java.lang.Exception e3) {
                com.badlogic.gdx.utils.SerializationException serializationException = new com.badlogic.gdx.utils.SerializationException(e3);
                serializationException.addTrace(field + " (" + cls.getName() + ")");
                throw serializationException;
            }
        }
    }

    public void writeObjectEnd() {
        try {
            this.a.pop();
        } catch (java.io.IOException e) {
            throw new com.badlogic.gdx.utils.SerializationException(e);
        }
    }

    public void writeObjectStart() {
        try {
            this.a.object();
        } catch (java.io.IOException e) {
            throw new com.badlogic.gdx.utils.SerializationException(e);
        }
    }

    public void writeObjectStart(java.lang.Class cls, java.lang.Class cls2) {
        try {
            this.a.object();
            if (cls2 == null || cls2 != cls) {
                writeType(cls);
            }
        } catch (java.io.IOException e) {
            throw new com.badlogic.gdx.utils.SerializationException(e);
        }
    }

    public void writeObjectStart(java.lang.String str) {
        try {
            this.a.name(str);
            writeObjectStart();
        } catch (java.io.IOException e) {
            throw new com.badlogic.gdx.utils.SerializationException(e);
        }
    }

    public void writeObjectStart(java.lang.String str, java.lang.Class cls, java.lang.Class cls2) {
        try {
            this.a.name(str);
            writeObjectStart(cls, cls2);
        } catch (java.io.IOException e) {
            throw new com.badlogic.gdx.utils.SerializationException(e);
        }
    }

    public void writeType(java.lang.Class cls) {
        if (this.b == null) {
            return;
        }
        java.lang.String tag = getTag(cls);
        if (tag == null) {
            tag = cls.getName();
        }
        try {
            this.a.set(this.b, tag);
        } catch (java.io.IOException e) {
            throw new com.badlogic.gdx.utils.SerializationException(e);
        }
    }

    public void writeValue(java.lang.Object obj) {
        if (obj == null) {
            writeValue(obj, (java.lang.Class) null, (java.lang.Class) null);
        } else {
            writeValue(obj, obj.getClass(), (java.lang.Class) null);
        }
    }

    public void writeValue(java.lang.Object obj, java.lang.Class cls) {
        writeValue(obj, cls, (java.lang.Class) null);
    }

    public void writeValue(java.lang.Object obj, java.lang.Class cls, java.lang.Class cls2) {
        java.lang.Class cls3 = cls;
        try {
            if (obj == null) {
                this.a.value(null);
                return;
            }
            if ((cls3 != null && cls.isPrimitive()) || cls3 == java.lang.String.class || cls3 == java.lang.Integer.class || cls3 == java.lang.Boolean.class || cls3 == java.lang.Float.class || cls3 == java.lang.Long.class || cls3 == java.lang.Double.class || cls3 == java.lang.Short.class || cls3 == java.lang.Byte.class || cls3 == java.lang.Character.class) {
                this.a.value(obj);
                return;
            }
            java.lang.Class<?> cls4 = obj.getClass();
            if (cls4.isPrimitive() || cls4 == java.lang.String.class || cls4 == java.lang.Integer.class || cls4 == java.lang.Boolean.class || cls4 == java.lang.Float.class || cls4 == java.lang.Long.class || cls4 == java.lang.Double.class || cls4 == java.lang.Short.class || cls4 == java.lang.Byte.class || cls4 == java.lang.Character.class) {
                writeObjectStart(cls4, null);
                writeValue("value", obj);
                writeObjectEnd();
                return;
            }
            if (obj instanceof com.badlogic.gdx.utils.Json.Serializable) {
                writeObjectStart(cls4, cls3);
                ((com.badlogic.gdx.utils.Json.Serializable) obj).write(this);
                writeObjectEnd();
                return;
            }
            com.badlogic.gdx.utils.Json.Serializer serializer = this.m.get(cls4);
            if (serializer != null) {
                serializer.write(this, obj, cls3);
                return;
            }
            int i = 0;
            if (obj instanceof com.badlogic.gdx.utils.Array) {
                if (cls3 != null && cls4 != cls3 && cls4 != com.badlogic.gdx.utils.Array.class) {
                    throw new com.badlogic.gdx.utils.SerializationException("Serialization of an Array other than the known type is not supported.\nKnown type: " + cls3 + "\nActual type: " + cls4);
                }
                writeArrayStart();
                com.badlogic.gdx.utils.Array array = (com.badlogic.gdx.utils.Array) obj;
                int i2 = array.size;
                while (i < i2) {
                    writeValue(array.get(i), cls2, (java.lang.Class) null);
                    i++;
                }
                writeArrayEnd();
                return;
            }
            if (obj instanceof com.badlogic.gdx.utils.Queue) {
                if (cls3 != null && cls4 != cls3 && cls4 != com.badlogic.gdx.utils.Queue.class) {
                    throw new com.badlogic.gdx.utils.SerializationException("Serialization of a Queue other than the known type is not supported.\nKnown type: " + cls3 + "\nActual type: " + cls4);
                }
                writeArrayStart();
                com.badlogic.gdx.utils.Queue queue = (com.badlogic.gdx.utils.Queue) obj;
                int i3 = queue.size;
                while (i < i3) {
                    writeValue(queue.get(i), cls2, (java.lang.Class) null);
                    i++;
                }
                writeArrayEnd();
                return;
            }
            if (obj instanceof java.util.Collection) {
                if (this.b == null || cls4 == java.util.ArrayList.class || (cls3 != null && cls3 == cls4)) {
                    writeArrayStart();
                    java.util.Iterator it = ((java.util.Collection) obj).iterator();
                    while (it.hasNext()) {
                        writeValue(it.next(), cls2, (java.lang.Class) null);
                    }
                    writeArrayEnd();
                    return;
                }
                writeObjectStart(cls4, cls3);
                writeArrayStart("items");
                java.util.Iterator it2 = ((java.util.Collection) obj).iterator();
                while (it2.hasNext()) {
                    writeValue(it2.next(), cls2, (java.lang.Class) null);
                }
                writeArrayEnd();
                writeObjectEnd();
                return;
            }
            if (cls4.isArray()) {
                java.lang.Class componentType = cls2 == null ? cls4.getComponentType() : cls2;
                int length = com.badlogic.gdx.utils.reflect.ArrayReflection.getLength(obj);
                writeArrayStart();
                while (i < length) {
                    writeValue(com.badlogic.gdx.utils.reflect.ArrayReflection.get(obj, i), componentType, (java.lang.Class) null);
                    i++;
                }
                writeArrayEnd();
                return;
            }
            if (obj instanceof com.badlogic.gdx.utils.ObjectMap) {
                if (cls3 == null) {
                    cls3 = com.badlogic.gdx.utils.ObjectMap.class;
                }
                writeObjectStart(cls4, cls3);
                com.badlogic.gdx.utils.ObjectMap.Entries it3 = ((com.badlogic.gdx.utils.ObjectMap) obj).entries().iterator();
                while (it3.hasNext()) {
                    com.badlogic.gdx.utils.ObjectMap.Entry next = it3.next();
                    this.a.name(b(next.key));
                    writeValue(next.value, cls2, (java.lang.Class) null);
                }
                writeObjectEnd();
                return;
            }
            if (obj instanceof com.badlogic.gdx.utils.ArrayMap) {
                if (cls3 == null) {
                    cls3 = com.badlogic.gdx.utils.ArrayMap.class;
                }
                writeObjectStart(cls4, cls3);
                com.badlogic.gdx.utils.ArrayMap arrayMap = (com.badlogic.gdx.utils.ArrayMap) obj;
                int i4 = arrayMap.size;
                while (i < i4) {
                    this.a.name(b(arrayMap.keys[i]));
                    writeValue(arrayMap.values[i], cls2, (java.lang.Class) null);
                    i++;
                }
                writeObjectEnd();
                return;
            }
            if (obj instanceof java.util.Map) {
                if (cls3 == null) {
                    cls3 = java.util.HashMap.class;
                }
                writeObjectStart(cls4, cls3);
                for (java.util.Map.Entry entry : ((java.util.Map) obj).entrySet()) {
                    this.a.name(b(entry.getKey()));
                    writeValue(entry.getValue(), cls2, (java.lang.Class) null);
                }
                writeObjectEnd();
                return;
            }
            if (!com.badlogic.gdx.utils.reflect.ClassReflection.isAssignableFrom(java.lang.Enum.class, cls4)) {
                writeObjectStart(cls4, cls3);
                writeFields(obj);
                writeObjectEnd();
            } else {
                if (this.b == null || (cls3 != null && cls3 == cls4)) {
                    this.a.value(a((java.lang.Enum) obj));
                    return;
                }
                if (cls4.getEnumConstants() == null) {
                    cls4 = cls4.getSuperclass();
                }
                writeObjectStart(cls4, null);
                this.a.name("value");
                this.a.value(a((java.lang.Enum) obj));
                writeObjectEnd();
            }
        } catch (java.io.IOException e) {
            throw new com.badlogic.gdx.utils.SerializationException(e);
        }
    }

    public void writeValue(java.lang.String str, java.lang.Object obj) {
        try {
            this.a.name(str);
            if (obj == null) {
                writeValue(obj, (java.lang.Class) null, (java.lang.Class) null);
            } else {
                writeValue(obj, obj.getClass(), (java.lang.Class) null);
            }
        } catch (java.io.IOException e) {
            throw new com.badlogic.gdx.utils.SerializationException(e);
        }
    }

    public void writeValue(java.lang.String str, java.lang.Object obj, java.lang.Class cls) {
        try {
            this.a.name(str);
            writeValue(obj, cls, (java.lang.Class) null);
        } catch (java.io.IOException e) {
            throw new com.badlogic.gdx.utils.SerializationException(e);
        }
    }

    public void writeValue(java.lang.String str, java.lang.Object obj, java.lang.Class cls, java.lang.Class cls2) {
        try {
            this.a.name(str);
            writeValue(obj, cls, cls2);
        } catch (java.io.IOException e) {
            throw new com.badlogic.gdx.utils.SerializationException(e);
        }
    }
}
