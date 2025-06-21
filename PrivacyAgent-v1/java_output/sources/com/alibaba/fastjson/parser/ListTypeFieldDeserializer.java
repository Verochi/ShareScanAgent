package com.alibaba.fastjson.parser;

/* loaded from: classes.dex */
class ListTypeFieldDeserializer extends com.alibaba.fastjson.parser.deserializer.FieldDeserializer {
    private final boolean array;
    private com.alibaba.fastjson.parser.deserializer.ObjectDeserializer deserializer;
    private final java.lang.reflect.Type itemType;

    public ListTypeFieldDeserializer(com.alibaba.fastjson.parser.ParserConfig parserConfig, java.lang.Class<?> cls, com.alibaba.fastjson.util.FieldInfo fieldInfo) {
        super(cls, fieldInfo, 14);
        java.lang.reflect.Type type = fieldInfo.fieldType;
        java.lang.Class<?> cls2 = fieldInfo.fieldClass;
        if (cls2.isArray()) {
            this.itemType = cls2.getComponentType();
            this.array = true;
        } else {
            this.itemType = com.alibaba.fastjson.util.TypeUtils.getCollectionItemType(type);
            this.array = false;
        }
    }

    public final void parseArray(com.alibaba.fastjson.parser.DefaultJSONParser defaultJSONParser, java.lang.reflect.Type type, java.util.Collection collection) {
        java.lang.Class cls;
        int i;
        int i2;
        java.lang.reflect.Type type2 = this.itemType;
        com.alibaba.fastjson.parser.deserializer.ObjectDeserializer objectDeserializer = this.deserializer;
        if (type instanceof java.lang.reflect.ParameterizedType) {
            if (type2 instanceof java.lang.reflect.TypeVariable) {
                java.lang.reflect.TypeVariable typeVariable = (java.lang.reflect.TypeVariable) type2;
                java.lang.reflect.ParameterizedType parameterizedType = (java.lang.reflect.ParameterizedType) type;
                cls = parameterizedType.getRawType() instanceof java.lang.Class ? (java.lang.Class) parameterizedType.getRawType() : null;
                if (cls != null) {
                    int length = cls.getTypeParameters().length;
                    i2 = 0;
                    while (i2 < length) {
                        if (cls.getTypeParameters()[i2].getName().equals(typeVariable.getName())) {
                            break;
                        } else {
                            i2++;
                        }
                    }
                }
                i2 = -1;
                if (i2 != -1) {
                    type2 = parameterizedType.getActualTypeArguments()[i2];
                    if (!type2.equals(this.itemType)) {
                        objectDeserializer = defaultJSONParser.config.getDeserializer(type2);
                    }
                }
            } else if (type2 instanceof java.lang.reflect.ParameterizedType) {
                java.lang.reflect.ParameterizedType parameterizedType2 = (java.lang.reflect.ParameterizedType) type2;
                java.lang.reflect.Type[] actualTypeArguments = parameterizedType2.getActualTypeArguments();
                if (actualTypeArguments.length == 1) {
                    java.lang.reflect.Type type3 = actualTypeArguments[0];
                    if (type3 instanceof java.lang.reflect.TypeVariable) {
                        java.lang.reflect.TypeVariable typeVariable2 = (java.lang.reflect.TypeVariable) type3;
                        java.lang.reflect.ParameterizedType parameterizedType3 = (java.lang.reflect.ParameterizedType) type;
                        cls = parameterizedType3.getRawType() instanceof java.lang.Class ? (java.lang.Class) parameterizedType3.getRawType() : null;
                        if (cls != null) {
                            int length2 = cls.getTypeParameters().length;
                            i = 0;
                            while (i < length2) {
                                if (cls.getTypeParameters()[i].getName().equals(typeVariable2.getName())) {
                                    break;
                                } else {
                                    i++;
                                }
                            }
                        }
                        i = -1;
                        if (i != -1) {
                            actualTypeArguments[0] = parameterizedType3.getActualTypeArguments()[i];
                            type2 = new com.alibaba.fastjson.util.ParameterizedTypeImpl(actualTypeArguments, parameterizedType2.getOwnerType(), parameterizedType2.getRawType());
                        }
                    }
                }
            }
        } else if ((type2 instanceof java.lang.reflect.TypeVariable) && (type instanceof java.lang.Class)) {
            java.lang.Class cls2 = (java.lang.Class) type;
            java.lang.reflect.TypeVariable typeVariable3 = (java.lang.reflect.TypeVariable) type2;
            cls2.getTypeParameters();
            int length3 = cls2.getTypeParameters().length;
            int i3 = 0;
            while (true) {
                if (i3 >= length3) {
                    break;
                }
                java.lang.reflect.TypeVariable typeVariable4 = cls2.getTypeParameters()[i3];
                if (typeVariable4.getName().equals(typeVariable3.getName())) {
                    java.lang.reflect.Type[] bounds = typeVariable4.getBounds();
                    if (bounds.length == 1) {
                        type2 = bounds[0];
                    }
                } else {
                    i3++;
                }
            }
        }
        com.alibaba.fastjson.parser.JSONLexer jSONLexer = defaultJSONParser.lexer;
        if (objectDeserializer == null) {
            objectDeserializer = defaultJSONParser.config.getDeserializer(type2);
            this.deserializer = objectDeserializer;
        }
        int i4 = jSONLexer.token;
        if (i4 != 14) {
            if (i4 == 12) {
                collection.add(objectDeserializer.deserialze(defaultJSONParser, type2, 0));
                return;
            }
            java.lang.String str = "exepct '[', but " + com.alibaba.fastjson.parser.JSONToken.name(jSONLexer.token);
            if (type != null) {
                str = str + ", type : " + type;
            }
            throw new com.alibaba.fastjson.JSONException(str);
        }
        int i5 = 0;
        char c = jSONLexer.ch;
        int i6 = 15;
        char c2 = com.alibaba.fastjson.parser.JSONLexer.EOI;
        if (c == '[') {
            int i7 = jSONLexer.bp + 1;
            jSONLexer.bp = i7;
            jSONLexer.ch = i7 >= jSONLexer.len ? com.alibaba.fastjson.parser.JSONLexer.EOI : jSONLexer.text.charAt(i7);
            jSONLexer.token = 14;
        } else if (c == '{') {
            int i8 = jSONLexer.bp + 1;
            jSONLexer.bp = i8;
            jSONLexer.ch = i8 >= jSONLexer.len ? com.alibaba.fastjson.parser.JSONLexer.EOI : jSONLexer.text.charAt(i8);
            jSONLexer.token = 12;
        } else if (c == '\"') {
            jSONLexer.scanString();
        } else if (c == ']') {
            int i9 = jSONLexer.bp + 1;
            jSONLexer.bp = i9;
            jSONLexer.ch = i9 >= jSONLexer.len ? com.alibaba.fastjson.parser.JSONLexer.EOI : jSONLexer.text.charAt(i9);
            jSONLexer.token = 15;
        } else {
            jSONLexer.nextToken();
        }
        while (true) {
            int i10 = jSONLexer.token;
            if (i10 == 16) {
                jSONLexer.nextToken();
            } else {
                if (i10 == i6) {
                    break;
                }
                collection.add(objectDeserializer.deserialze(defaultJSONParser, type2, java.lang.Integer.valueOf(i5)));
                if (defaultJSONParser.resolveStatus == 1) {
                    defaultJSONParser.checkListResolve(collection);
                }
                if (jSONLexer.token == 16) {
                    char c3 = jSONLexer.ch;
                    if (c3 == '[') {
                        int i11 = jSONLexer.bp + 1;
                        jSONLexer.bp = i11;
                        jSONLexer.ch = i11 >= jSONLexer.len ? com.alibaba.fastjson.parser.JSONLexer.EOI : jSONLexer.text.charAt(i11);
                        jSONLexer.token = 14;
                    } else if (c3 == '{') {
                        int i12 = jSONLexer.bp + 1;
                        jSONLexer.bp = i12;
                        jSONLexer.ch = i12 >= jSONLexer.len ? com.alibaba.fastjson.parser.JSONLexer.EOI : jSONLexer.text.charAt(i12);
                        jSONLexer.token = 12;
                    } else if (c3 == '\"') {
                        jSONLexer.scanString();
                    } else {
                        jSONLexer.nextToken();
                    }
                }
                i5++;
                i6 = 15;
            }
        }
        if (jSONLexer.ch != ',') {
            jSONLexer.nextToken();
            return;
        }
        int i13 = jSONLexer.bp + 1;
        jSONLexer.bp = i13;
        if (i13 < jSONLexer.len) {
            c2 = jSONLexer.text.charAt(i13);
        }
        jSONLexer.ch = c2;
        jSONLexer.token = 16;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.alibaba.fastjson.parser.deserializer.FieldDeserializer
    public void parseField(com.alibaba.fastjson.parser.DefaultJSONParser defaultJSONParser, java.lang.Object obj, java.lang.reflect.Type type, java.util.Map<java.lang.String, java.lang.Object> map) {
        java.util.ArrayList arrayList;
        com.alibaba.fastjson.JSONArray jSONArray;
        com.alibaba.fastjson.parser.JSONLexer jSONLexer = defaultJSONParser.lexer;
        int i = jSONLexer.token();
        if (i == 8 || (i == 4 && jSONLexer.stringVal().length() == 0)) {
            setValue(obj, (java.lang.Object) null);
            defaultJSONParser.lexer.nextToken();
            return;
        }
        if (this.array) {
            com.alibaba.fastjson.JSONArray jSONArray2 = new com.alibaba.fastjson.JSONArray();
            jSONArray2.setComponentType(this.itemType);
            jSONArray = jSONArray2;
            arrayList = jSONArray2;
        } else {
            arrayList = new java.util.ArrayList();
            jSONArray = null;
        }
        com.alibaba.fastjson.parser.ParseContext parseContext = defaultJSONParser.contex;
        defaultJSONParser.setContext(parseContext, obj, this.fieldInfo.name);
        parseArray(defaultJSONParser, type, arrayList);
        defaultJSONParser.setContext(parseContext);
        java.lang.Object obj2 = arrayList;
        if (this.array) {
            java.lang.Object array = arrayList.toArray((java.lang.Object[]) java.lang.reflect.Array.newInstance((java.lang.Class<?>) this.itemType, arrayList.size()));
            jSONArray.setRelatedArray(array);
            obj2 = array;
        }
        if (obj == null) {
            map.put(this.fieldInfo.name, obj2);
        } else {
            setValue(obj, obj2);
        }
    }
}
