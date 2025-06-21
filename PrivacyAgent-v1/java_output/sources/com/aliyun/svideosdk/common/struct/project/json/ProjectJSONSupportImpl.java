package com.aliyun.svideosdk.common.struct.project.json;

/* loaded from: classes12.dex */
public class ProjectJSONSupportImpl extends com.aliyun.common.jasonparse.JSONSupport {
    public static final com.google.gson.Gson mGson = new com.google.gson.GsonBuilder().registerTypeAdapterFactory(new com.aliyun.svideosdk.common.struct.project.json.EnumAdapterFactory()).registerTypeAdapter(java.util.List.class, new com.aliyun.svideosdk.common.struct.project.json.ListJsonDeserializer()).registerTypeAdapter(com.aliyun.svideosdk.common.struct.project.VideoTrackClip.class, new com.aliyun.svideosdk.common.struct.project.json.VideoTrackClipJsonDeserializer()).registerTypeAdapter(com.aliyun.svideosdk.common.struct.project.Effect.class, new com.aliyun.svideosdk.common.struct.project.json.EffectJsonDeserializer()).registerTypeAdapter(com.aliyun.svideosdk.common.struct.project.EffectTrack.class, new com.aliyun.svideosdk.common.struct.project.json.FilterJsonDeserializer()).registerTypeAdapter(com.aliyun.svideosdk.common.struct.effect.ActionBase.class, new com.aliyun.svideosdk.common.struct.project.json.ActionJsonDeserializer()).registerTypeAdapter(com.aliyun.svideosdk.common.struct.project.GlobalTrack.class, new com.aliyun.svideosdk.common.struct.project.json.GlobalJsonDeserializer()).registerTypeAdapter(com.aliyun.svideosdk.common.struct.project.PasterTrack.class, new com.aliyun.svideosdk.common.struct.project.json.PasterJsonDeserializer()).enableComplexMapKeySerialization().serializeSpecialFloatingPointValues().setPrettyPrinting().setVersion(1.0d).create();
    public final com.google.gson.Gson mGsonWrite = new com.google.gson.GsonBuilder().registerTypeAdapterFactory(new com.aliyun.svideosdk.common.struct.project.json.EnumAdapterFactory()).enableComplexMapKeySerialization().serializeSpecialFloatingPointValues().setPrettyPrinting().setVersion(1.0d).create();

    @Override // com.aliyun.common.jasonparse.JSONSupport
    public <T> T readListValue(java.lang.String str, java.lang.reflect.Type type) throws java.lang.Exception {
        return (T) mGson.fromJson(str, type);
    }

    @Override // com.aliyun.common.jasonparse.JSONSupport
    public <T> T readValue(java.io.File file, java.lang.Class<? extends T> cls) throws java.lang.Exception {
        return (T) readValue(new java.io.FileInputStream(file), cls);
    }

    @Override // com.aliyun.common.jasonparse.JSONSupport
    public <T> T readValue(java.io.InputStream inputStream, java.lang.Class<? extends T> cls) throws java.lang.Exception {
        com.google.gson.stream.JsonReader jsonReader = new com.google.gson.stream.JsonReader(new java.io.InputStreamReader(inputStream, "UTF-8"));
        jsonReader.setLenient(true);
        try {
            try {
                return (T) mGson.fromJson(jsonReader, cls);
            } catch (java.lang.Exception e) {
                throw e;
            }
        } finally {
            try {
                jsonReader.close();
            } catch (java.io.IOException unused) {
            }
        }
    }

    @Override // com.aliyun.common.jasonparse.JSONSupport
    public <T> T readValue(java.lang.String str, java.lang.Class<? extends T> cls) throws java.lang.Exception {
        return (T) mGson.fromJson(str, (java.lang.Class) cls);
    }

    @Override // com.aliyun.common.jasonparse.JSONSupport
    public <T> java.lang.String writeValue(T t) throws java.lang.Exception {
        return this.mGsonWrite.toJson(t);
    }

    @Override // com.aliyun.common.jasonparse.JSONSupport
    public <T> void writeValue(java.io.File file, T t) throws java.lang.Exception {
        writeValue((java.io.OutputStream) new java.io.FileOutputStream(file), (java.io.FileOutputStream) t);
    }

    @Override // com.aliyun.common.jasonparse.JSONSupport
    public <T> void writeValue(java.io.OutputStream outputStream, T t) throws java.lang.Exception {
        com.google.gson.stream.JsonWriter jsonWriter = new com.google.gson.stream.JsonWriter(new java.io.OutputStreamWriter(outputStream, "UTF-8"));
        try {
            try {
                this.mGsonWrite.toJson(t, t.getClass(), jsonWriter);
                try {
                    jsonWriter.flush();
                } catch (java.io.IOException unused) {
                }
                try {
                    jsonWriter.close();
                } catch (java.io.IOException unused2) {
                }
            } catch (java.lang.Exception e) {
                throw e;
            }
        } finally {
        }
    }
}
