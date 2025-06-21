package com.aliyun.common.jasonparse;

/* loaded from: classes.dex */
public class JSONSupportImpl extends com.aliyun.common.jasonparse.JSONSupport {
    private final com.google.gson.Gson mGson = new com.google.gson.Gson();

    @Override // com.aliyun.common.jasonparse.JSONSupport
    public <T> T readListValue(java.lang.String str, java.lang.reflect.Type type) throws java.lang.Exception {
        return (T) this.mGson.fromJson(str, type);
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
                return (T) this.mGson.fromJson(jsonReader, cls);
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
        return (T) this.mGson.fromJson(str, (java.lang.Class) cls);
    }

    @Override // com.aliyun.common.jasonparse.JSONSupport
    public <T> java.lang.String writeValue(T t) throws java.lang.Exception {
        return this.mGson.toJson(t);
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
                this.mGson.toJson(t, t.getClass(), jsonWriter);
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
