package com.google.gson.internal.bind;

/* loaded from: classes22.dex */
public final class TimeTypeAdapter extends com.google.gson.TypeAdapter<java.sql.Time> {
    public static final com.google.gson.TypeAdapterFactory FACTORY = new com.google.gson.internal.bind.TimeTypeAdapter.AnonymousClass1();
    private final java.text.DateFormat format = new java.text.SimpleDateFormat("hh:mm:ss a");

    /* renamed from: com.google.gson.internal.bind.TimeTypeAdapter$1, reason: invalid class name */
    public class AnonymousClass1 implements com.google.gson.TypeAdapterFactory {
        @Override // com.google.gson.TypeAdapterFactory
        public <T> com.google.gson.TypeAdapter<T> create(com.google.gson.Gson gson, com.google.gson.reflect.TypeToken<T> typeToken) {
            if (typeToken.getRawType() == java.sql.Time.class) {
                return new com.google.gson.internal.bind.TimeTypeAdapter();
            }
            return null;
        }
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read, reason: avoid collision after fix types in other method */
    public synchronized java.sql.Time read2(com.google.gson.stream.JsonReader jsonReader) throws java.io.IOException {
        if (jsonReader.peek() == com.google.gson.stream.JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        try {
            return new java.sql.Time(this.format.parse(jsonReader.nextString()).getTime());
        } catch (java.text.ParseException e) {
            throw new com.google.gson.JsonSyntaxException(e);
        }
    }

    @Override // com.google.gson.TypeAdapter
    public synchronized void write(com.google.gson.stream.JsonWriter jsonWriter, java.sql.Time time) throws java.io.IOException {
        jsonWriter.value(time == null ? null : this.format.format((java.util.Date) time));
    }
}
