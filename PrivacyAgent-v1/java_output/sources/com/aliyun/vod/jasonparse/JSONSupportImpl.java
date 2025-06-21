package com.aliyun.vod.jasonparse;

/* loaded from: classes12.dex */
public class JSONSupportImpl extends com.aliyun.vod.jasonparse.JSONSupport {
    private final com.google.gson.Gson mGson = new com.google.gson.Gson();

    public static java.lang.String fileToStr(java.io.InputStream inputStream) throws java.io.IOException {
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return byteArrayOutputStream.toString();
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    private byte[] getByteFromInputStream(java.io.InputStream inputStream) {
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        byte[] bArr = new byte[16384];
        while (true) {
            try {
                int read = inputStream.read(bArr, 0, 16384);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            } catch (java.io.IOException e) {
                e.printStackTrace();
            }
        }
        byteArrayOutputStream.flush();
        return bArr;
    }

    @Override // com.aliyun.vod.jasonparse.JSONSupport
    public <T> T readListValue(java.lang.String str, java.lang.reflect.Type type) throws java.lang.Exception {
        return (T) this.mGson.fromJson(str, type);
    }

    @Override // com.aliyun.vod.jasonparse.JSONSupport
    public <T> T readValue(java.io.File file, java.lang.Class<? extends T> cls) throws java.lang.Exception {
        return (T) readValue(new java.io.FileInputStream(file), cls);
    }

    @Override // com.aliyun.vod.jasonparse.JSONSupport
    public <T> T readValue(java.io.InputStream inputStream, java.lang.Class<? extends T> cls) throws java.lang.Exception {
        com.google.gson.stream.JsonReader jsonReader = new com.google.gson.stream.JsonReader(new java.io.InputStreamReader(inputStream, "UTF-8"));
        jsonReader.setLenient(true);
        T t = (T) this.mGson.fromJson(jsonReader, cls);
        jsonReader.close();
        return t;
    }

    @Override // com.aliyun.vod.jasonparse.JSONSupport
    public <T> T readValue(java.lang.String str, java.lang.Class<? extends T> cls) throws java.lang.Exception {
        return (T) this.mGson.fromJson(str, (java.lang.Class) cls);
    }

    @Override // com.aliyun.vod.jasonparse.JSONSupport
    public <T> java.lang.String writeValue(T t) throws java.lang.Exception {
        return this.mGson.toJson(t);
    }

    @Override // com.aliyun.vod.jasonparse.JSONSupport
    public <T> void writeValue(java.io.File file, T t) throws java.lang.Exception {
        writeValue((java.io.OutputStream) new java.io.FileOutputStream(file), (java.io.FileOutputStream) t);
    }

    @Override // com.aliyun.vod.jasonparse.JSONSupport
    public <T> void writeValue(java.io.OutputStream outputStream, T t) throws java.lang.Exception {
        com.google.gson.stream.JsonWriter jsonWriter = new com.google.gson.stream.JsonWriter(new java.io.OutputStreamWriter(outputStream, "UTF-8"));
        this.mGson.toJson(t, t.getClass(), jsonWriter);
        jsonWriter.flush();
        jsonWriter.close();
    }
}
