package com.google.gson;

/* loaded from: classes22.dex */
final class DefaultDateTypeAdapter extends com.google.gson.TypeAdapter<java.util.Date> {
    private static final java.lang.String SIMPLE_NAME = "DefaultDateTypeAdapter";
    private final java.util.List<java.text.DateFormat> dateFormats;
    private final java.lang.Class<? extends java.util.Date> dateType;

    public DefaultDateTypeAdapter(int i, int i2) {
        this(java.util.Date.class, i, i2);
    }

    public DefaultDateTypeAdapter(java.lang.Class<? extends java.util.Date> cls) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        this.dateFormats = arrayList;
        this.dateType = verifyDateType(cls);
        java.util.Locale locale = java.util.Locale.US;
        arrayList.add(java.text.DateFormat.getDateTimeInstance(2, 2, locale));
        if (!java.util.Locale.getDefault().equals(locale)) {
            arrayList.add(java.text.DateFormat.getDateTimeInstance(2, 2));
        }
        if (com.google.gson.internal.JavaVersion.isJava9OrLater()) {
            arrayList.add(com.google.gson.internal.PreJava9DateFormatProvider.getUSDateTimeFormat(2, 2));
        }
    }

    public DefaultDateTypeAdapter(java.lang.Class<? extends java.util.Date> cls, int i) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        this.dateFormats = arrayList;
        this.dateType = verifyDateType(cls);
        java.util.Locale locale = java.util.Locale.US;
        arrayList.add(java.text.DateFormat.getDateInstance(i, locale));
        if (!java.util.Locale.getDefault().equals(locale)) {
            arrayList.add(java.text.DateFormat.getDateInstance(i));
        }
        if (com.google.gson.internal.JavaVersion.isJava9OrLater()) {
            arrayList.add(com.google.gson.internal.PreJava9DateFormatProvider.getUSDateFormat(i));
        }
    }

    public DefaultDateTypeAdapter(java.lang.Class<? extends java.util.Date> cls, int i, int i2) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        this.dateFormats = arrayList;
        this.dateType = verifyDateType(cls);
        java.util.Locale locale = java.util.Locale.US;
        arrayList.add(java.text.DateFormat.getDateTimeInstance(i, i2, locale));
        if (!java.util.Locale.getDefault().equals(locale)) {
            arrayList.add(java.text.DateFormat.getDateTimeInstance(i, i2));
        }
        if (com.google.gson.internal.JavaVersion.isJava9OrLater()) {
            arrayList.add(com.google.gson.internal.PreJava9DateFormatProvider.getUSDateTimeFormat(i, i2));
        }
    }

    public DefaultDateTypeAdapter(java.lang.Class<? extends java.util.Date> cls, java.lang.String str) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        this.dateFormats = arrayList;
        this.dateType = verifyDateType(cls);
        java.util.Locale locale = java.util.Locale.US;
        arrayList.add(new java.text.SimpleDateFormat(str, locale));
        if (java.util.Locale.getDefault().equals(locale)) {
            return;
        }
        arrayList.add(new java.text.SimpleDateFormat(str));
    }

    private java.util.Date deserializeToDate(java.lang.String str) {
        synchronized (this.dateFormats) {
            java.util.Iterator<java.text.DateFormat> it = this.dateFormats.iterator();
            while (it.hasNext()) {
                try {
                    return it.next().parse(str);
                } catch (java.text.ParseException unused) {
                }
            }
            try {
                return com.google.gson.internal.bind.util.ISO8601Utils.parse(str, new java.text.ParsePosition(0));
            } catch (java.text.ParseException e) {
                throw new com.google.gson.JsonSyntaxException(str, e);
            }
        }
    }

    private static java.lang.Class<? extends java.util.Date> verifyDateType(java.lang.Class<? extends java.util.Date> cls) {
        if (cls == java.util.Date.class || cls == java.sql.Date.class || cls == java.sql.Timestamp.class) {
            return cls;
        }
        throw new java.lang.IllegalArgumentException("Date type must be one of " + java.util.Date.class + ", " + java.sql.Timestamp.class + ", or " + java.sql.Date.class + " but was " + cls);
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read, reason: avoid collision after fix types in other method */
    public java.util.Date read2(com.google.gson.stream.JsonReader jsonReader) throws java.io.IOException {
        if (jsonReader.peek() == com.google.gson.stream.JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        java.util.Date deserializeToDate = deserializeToDate(jsonReader.nextString());
        java.lang.Class<? extends java.util.Date> cls = this.dateType;
        if (cls == java.util.Date.class) {
            return deserializeToDate;
        }
        if (cls == java.sql.Timestamp.class) {
            return new java.sql.Timestamp(deserializeToDate.getTime());
        }
        if (cls == java.sql.Date.class) {
            return new java.sql.Date(deserializeToDate.getTime());
        }
        throw new java.lang.AssertionError();
    }

    public java.lang.String toString() {
        java.text.DateFormat dateFormat = this.dateFormats.get(0);
        if (dateFormat instanceof java.text.SimpleDateFormat) {
            return "DefaultDateTypeAdapter(" + ((java.text.SimpleDateFormat) dateFormat).toPattern() + ')';
        }
        return "DefaultDateTypeAdapter(" + dateFormat.getClass().getSimpleName() + ')';
    }

    @Override // com.google.gson.TypeAdapter
    public void write(com.google.gson.stream.JsonWriter jsonWriter, java.util.Date date) throws java.io.IOException {
        if (date == null) {
            jsonWriter.nullValue();
            return;
        }
        synchronized (this.dateFormats) {
            jsonWriter.value(this.dateFormats.get(0).format(date));
        }
    }
}
