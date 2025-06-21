package com.aliyun.svideosdk.common.struct.project.json;

/* loaded from: classes12.dex */
public class EnumAdapterFactory implements com.google.gson.TypeAdapterFactory {

    public class EnumTypeAdapter<T> extends com.google.gson.TypeAdapter<T> {
        com.google.gson.reflect.TypeToken<T> type;

        public EnumTypeAdapter(com.google.gson.reflect.TypeToken<T> typeToken) {
            this.type = typeToken;
        }

        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public T read2(com.google.gson.stream.JsonReader jsonReader) {
            try {
                return (T) ((java.lang.Object[]) this.type.getRawType().getMethod("values", new java.lang.Class[0]).invoke(null, new java.lang.Object[0]))[jsonReader.nextInt()];
            } catch (java.lang.Exception unused) {
                return null;
            }
        }

        @Override // com.google.gson.TypeAdapter
        public void write(com.google.gson.stream.JsonWriter jsonWriter, T t) throws java.io.IOException {
            if (t == null) {
                jsonWriter.nullValue();
            } else {
                jsonWriter.value(java.lang.Enum.valueOf(t.getClass().asSubclass(java.lang.Enum.class), t.toString()).ordinal());
            }
        }
    }

    @Override // com.google.gson.TypeAdapterFactory
    public <T> com.google.gson.TypeAdapter<T> create(com.google.gson.Gson gson, com.google.gson.reflect.TypeToken<T> typeToken) {
        java.lang.Class<? super T> rawType = typeToken.getRawType();
        if (rawType.equals(com.aliyun.svideosdk.common.struct.project.GlobalTrack.Type.class) || rawType.equals(com.aliyun.svideosdk.common.struct.project.PasterTrack.Type.class) || rawType.equals(com.aliyun.svideosdk.common.struct.effect.ActionBase.Type.class) || rawType.equals(com.aliyun.svideosdk.common.struct.project.EffectTrack.Type.class) || rawType.equals(com.aliyun.svideosdk.common.struct.project.Effect.Type.class) || !rawType.isEnum()) {
            return null;
        }
        return new com.aliyun.svideosdk.common.struct.project.json.EnumAdapterFactory.EnumTypeAdapter(typeToken);
    }
}
