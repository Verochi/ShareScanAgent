package com.alibaba.fastjson.serializer;

/* loaded from: classes.dex */
public class JSONSerializer {
    protected java.util.List<com.alibaba.fastjson.serializer.AfterFilter> afterFilters;
    protected java.util.List<com.alibaba.fastjson.serializer.BeforeFilter> beforeFilters;
    public final com.alibaba.fastjson.serializer.SerializeConfig config;
    protected com.alibaba.fastjson.serializer.SerialContext context;
    private java.text.DateFormat dateFormat;
    private java.lang.String dateFormatPattern;
    private int indentCount;
    public java.util.Locale locale;
    protected java.util.List<com.alibaba.fastjson.serializer.NameFilter> nameFilters;
    public final com.alibaba.fastjson.serializer.SerializeWriter out;
    protected java.util.List<com.alibaba.fastjson.serializer.PropertyFilter> propertyFilters;
    protected java.util.List<com.alibaba.fastjson.serializer.PropertyPreFilter> propertyPreFilters;
    protected java.util.IdentityHashMap<java.lang.Object, com.alibaba.fastjson.serializer.SerialContext> references;
    public java.util.TimeZone timeZone;
    protected java.util.List<com.alibaba.fastjson.serializer.ValueFilter> valueFilters;

    public JSONSerializer() {
        this(new com.alibaba.fastjson.serializer.SerializeWriter(null, com.alibaba.fastjson.JSON.DEFAULT_GENERATE_FEATURE, com.alibaba.fastjson.serializer.SerializerFeature.EMPTY), com.alibaba.fastjson.serializer.SerializeConfig.globalInstance);
    }

    public JSONSerializer(com.alibaba.fastjson.serializer.SerializeConfig serializeConfig) {
        this(new com.alibaba.fastjson.serializer.SerializeWriter(null, com.alibaba.fastjson.JSON.DEFAULT_GENERATE_FEATURE, com.alibaba.fastjson.serializer.SerializerFeature.EMPTY), serializeConfig);
    }

    public JSONSerializer(com.alibaba.fastjson.serializer.SerializeWriter serializeWriter) {
        this(serializeWriter, com.alibaba.fastjson.serializer.SerializeConfig.globalInstance);
    }

    public JSONSerializer(com.alibaba.fastjson.serializer.SerializeWriter serializeWriter, com.alibaba.fastjson.serializer.SerializeConfig serializeConfig) {
        this.beforeFilters = null;
        this.afterFilters = null;
        this.propertyFilters = null;
        this.valueFilters = null;
        this.nameFilters = null;
        this.propertyPreFilters = null;
        this.indentCount = 0;
        this.references = null;
        this.timeZone = com.alibaba.fastjson.JSON.defaultTimeZone;
        this.locale = com.alibaba.fastjson.JSON.defaultLocale;
        this.out = serializeWriter;
        this.config = serializeConfig;
        this.timeZone = com.alibaba.fastjson.JSON.defaultTimeZone;
    }

    public static java.lang.Object processValue(com.alibaba.fastjson.serializer.JSONSerializer jSONSerializer, java.lang.Object obj, java.lang.Object obj2, java.lang.Object obj3) {
        java.util.List<com.alibaba.fastjson.serializer.ValueFilter> list = jSONSerializer.valueFilters;
        if (list != null) {
            if (obj2 != null && !(obj2 instanceof java.lang.String)) {
                obj2 = com.alibaba.fastjson.JSON.toJSONString(obj2);
            }
            java.util.Iterator<com.alibaba.fastjson.serializer.ValueFilter> it = list.iterator();
            while (it.hasNext()) {
                obj3 = it.next().process(obj, (java.lang.String) obj2, obj3);
            }
        }
        return obj3;
    }

    public static final void write(com.alibaba.fastjson.serializer.SerializeWriter serializeWriter, java.lang.Object obj) {
        new com.alibaba.fastjson.serializer.JSONSerializer(serializeWriter, com.alibaba.fastjson.serializer.SerializeConfig.globalInstance).write(obj);
    }

    public static final void write(java.io.Writer writer, java.lang.Object obj) {
        com.alibaba.fastjson.serializer.SerializeWriter serializeWriter = new com.alibaba.fastjson.serializer.SerializeWriter(null, com.alibaba.fastjson.JSON.DEFAULT_GENERATE_FEATURE, com.alibaba.fastjson.serializer.SerializerFeature.EMPTY);
        try {
            try {
                new com.alibaba.fastjson.serializer.JSONSerializer(serializeWriter, com.alibaba.fastjson.serializer.SerializeConfig.globalInstance).write(obj);
                serializeWriter.writeTo(writer);
            } catch (java.io.IOException e) {
                throw new com.alibaba.fastjson.JSONException(e.getMessage(), e);
            }
        } finally {
            serializeWriter.close();
        }
    }

    public boolean apply(java.lang.Object obj, java.lang.Object obj2, java.lang.Object obj3) {
        java.util.List<com.alibaba.fastjson.serializer.PropertyFilter> list = this.propertyFilters;
        if (list == null) {
            return true;
        }
        if (obj2 != null && !(obj2 instanceof java.lang.String)) {
            obj2 = com.alibaba.fastjson.JSON.toJSONString(obj2);
        }
        java.util.Iterator<com.alibaba.fastjson.serializer.PropertyFilter> it = list.iterator();
        while (it.hasNext()) {
            if (!it.next().apply(obj, (java.lang.String) obj2, obj3)) {
                return false;
            }
        }
        return true;
    }

    public boolean applyName(java.lang.Object obj, java.lang.Object obj2) {
        java.util.List<com.alibaba.fastjson.serializer.PropertyPreFilter> list = this.propertyPreFilters;
        if (list == null) {
            return true;
        }
        for (com.alibaba.fastjson.serializer.PropertyPreFilter propertyPreFilter : list) {
            if (obj2 != null && !(obj2 instanceof java.lang.String)) {
                obj2 = com.alibaba.fastjson.JSON.toJSONString(obj2);
            }
            if (!propertyPreFilter.apply(this, obj, (java.lang.String) obj2)) {
                return false;
            }
        }
        return true;
    }

    public void close() {
        this.out.close();
    }

    public void config(com.alibaba.fastjson.serializer.SerializerFeature serializerFeature, boolean z) {
        this.out.config(serializerFeature, z);
    }

    public void decrementIdent() {
        this.indentCount--;
    }

    public java.util.List<com.alibaba.fastjson.serializer.AfterFilter> getAfterFilters() {
        if (this.afterFilters == null) {
            this.afterFilters = new java.util.ArrayList();
        }
        return this.afterFilters;
    }

    public java.util.List<com.alibaba.fastjson.serializer.BeforeFilter> getBeforeFilters() {
        if (this.beforeFilters == null) {
            this.beforeFilters = new java.util.ArrayList();
        }
        return this.beforeFilters;
    }

    public com.alibaba.fastjson.serializer.SerialContext getContext() {
        return this.context;
    }

    public java.text.DateFormat getDateFormat() {
        if (this.dateFormat == null && this.dateFormatPattern != null) {
            java.text.SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat(this.dateFormatPattern, this.locale);
            this.dateFormat = simpleDateFormat;
            simpleDateFormat.setTimeZone(this.timeZone);
        }
        return this.dateFormat;
    }

    public java.lang.String getDateFormatPattern() {
        java.text.DateFormat dateFormat = this.dateFormat;
        return dateFormat instanceof java.text.SimpleDateFormat ? ((java.text.SimpleDateFormat) dateFormat).toPattern() : this.dateFormatPattern;
    }

    public java.util.List<com.alibaba.fastjson.serializer.NameFilter> getNameFilters() {
        if (this.nameFilters == null) {
            this.nameFilters = new java.util.ArrayList();
        }
        return this.nameFilters;
    }

    public java.util.List<com.alibaba.fastjson.serializer.PropertyFilter> getPropertyFilters() {
        if (this.propertyFilters == null) {
            this.propertyFilters = new java.util.ArrayList();
        }
        return this.propertyFilters;
    }

    public java.util.List<com.alibaba.fastjson.serializer.PropertyPreFilter> getPropertyPreFilters() {
        if (this.propertyPreFilters == null) {
            this.propertyPreFilters = new java.util.ArrayList();
        }
        return this.propertyPreFilters;
    }

    public java.util.List<com.alibaba.fastjson.serializer.ValueFilter> getValueFilters() {
        if (this.valueFilters == null) {
            this.valueFilters = new java.util.ArrayList();
        }
        return this.valueFilters;
    }

    public com.alibaba.fastjson.serializer.SerializeWriter getWriter() {
        return this.out;
    }

    public void incrementIndent() {
        this.indentCount++;
    }

    public void println() {
        this.out.write(10);
        for (int i = 0; i < this.indentCount; i++) {
            this.out.write(9);
        }
    }

    public java.lang.Object processKey(java.lang.Object obj, java.lang.Object obj2, java.lang.Object obj3) {
        java.util.List<com.alibaba.fastjson.serializer.NameFilter> list = this.nameFilters;
        if (list != null) {
            if (obj2 != null && !(obj2 instanceof java.lang.String)) {
                obj2 = com.alibaba.fastjson.JSON.toJSONString(obj2);
            }
            java.util.Iterator<com.alibaba.fastjson.serializer.NameFilter> it = list.iterator();
            while (it.hasNext()) {
                obj2 = it.next().process(obj, (java.lang.String) obj2, obj3);
            }
        }
        return obj2;
    }

    public void setContext(com.alibaba.fastjson.serializer.SerialContext serialContext, java.lang.Object obj, java.lang.Object obj2, int i) {
        if ((this.out.features & com.alibaba.fastjson.serializer.SerializerFeature.DisableCircularReferenceDetect.mask) == 0) {
            this.context = new com.alibaba.fastjson.serializer.SerialContext(serialContext, obj, obj2, i);
            if (this.references == null) {
                this.references = new java.util.IdentityHashMap<>();
            }
            this.references.put(obj, this.context);
        }
    }

    public void setDateFormat(java.lang.String str) {
        this.dateFormatPattern = str;
        if (this.dateFormat != null) {
            this.dateFormat = null;
        }
    }

    public void setDateFormat(java.text.DateFormat dateFormat) {
        this.dateFormat = dateFormat;
        if (this.dateFormatPattern != null) {
            this.dateFormatPattern = null;
        }
    }

    public java.lang.String toString() {
        return this.out.toString();
    }

    public final void write(java.lang.Object obj) {
        if (obj == null) {
            this.out.writeNull();
            return;
        }
        try {
            this.config.get(obj.getClass()).write(this, obj, null, null);
        } catch (java.io.IOException e) {
            throw new com.alibaba.fastjson.JSONException(e.getMessage(), e);
        }
    }

    public final void write(java.lang.String str) {
        if (str == null) {
            com.alibaba.fastjson.serializer.SerializeWriter serializeWriter = this.out;
            if ((serializeWriter.features & com.alibaba.fastjson.serializer.SerializerFeature.WriteNullStringAsEmpty.mask) != 0) {
                serializeWriter.writeString("");
                return;
            } else {
                serializeWriter.writeNull();
                return;
            }
        }
        com.alibaba.fastjson.serializer.SerializeWriter serializeWriter2 = this.out;
        if ((serializeWriter2.features & com.alibaba.fastjson.serializer.SerializerFeature.UseSingleQuotes.mask) != 0) {
            serializeWriter2.writeStringWithSingleQuote(str);
        } else {
            serializeWriter2.writeStringWithDoubleQuote(str, (char) 0, true);
        }
    }

    public final void writeKeyValue(char c, java.lang.String str, java.lang.Object obj) {
        if (c != 0) {
            this.out.write(c);
        }
        this.out.writeFieldName(str, true);
        write(obj);
    }

    public void writeReference(java.lang.Object obj) {
        com.alibaba.fastjson.serializer.SerialContext serialContext = this.context;
        if (obj == serialContext.object) {
            this.out.write("{\"$ref\":\"@\"}");
            return;
        }
        com.alibaba.fastjson.serializer.SerialContext serialContext2 = serialContext.parent;
        if (serialContext2 != null && obj == serialContext2.object) {
            this.out.write("{\"$ref\":\"..\"}");
            return;
        }
        while (true) {
            com.alibaba.fastjson.serializer.SerialContext serialContext3 = serialContext.parent;
            if (serialContext3 == null) {
                break;
            } else {
                serialContext = serialContext3;
            }
        }
        if (obj == serialContext.object) {
            this.out.write("{\"$ref\":\"$\"}");
            return;
        }
        java.lang.String serialContext4 = this.references.get(obj).toString();
        this.out.write("{\"$ref\":\"");
        this.out.write(serialContext4);
        this.out.write("\"}");
    }

    public final void writeWithFieldName(java.lang.Object obj, java.lang.Object obj2) {
        writeWithFieldName(obj, obj2, null, 0);
    }

    public final void writeWithFieldName(java.lang.Object obj, java.lang.Object obj2, java.lang.reflect.Type type, int i) {
        try {
            if (obj == null) {
                this.out.writeNull();
            } else {
                this.config.get(obj.getClass()).write(this, obj, obj2, type);
            }
        } catch (java.io.IOException e) {
            throw new com.alibaba.fastjson.JSONException(e.getMessage(), e);
        }
    }

    public final void writeWithFormat(java.lang.Object obj, java.lang.String str) {
        if (!(obj instanceof java.util.Date)) {
            write(obj);
            return;
        }
        java.text.DateFormat dateFormat = getDateFormat();
        if (dateFormat == null) {
            dateFormat = new java.text.SimpleDateFormat(str, this.locale);
            dateFormat.setTimeZone(this.timeZone);
        }
        this.out.writeString(dateFormat.format((java.util.Date) obj));
    }
}
