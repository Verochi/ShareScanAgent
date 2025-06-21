package com.huawei.agconnect;

/* loaded from: classes22.dex */
public final class JsonProcessingFactory {
    public static final java.util.Map<java.lang.String, com.huawei.agconnect.JsonProcessingFactory.JsonProcessor> a = new java.util.HashMap();

    public interface JsonProcessor {
        java.lang.String processOption(com.huawei.agconnect.AGConnectOptions aGConnectOptions);
    }

    public static java.util.Map<java.lang.String, com.huawei.agconnect.JsonProcessingFactory.JsonProcessor> getProcessors() {
        return a;
    }

    public static void registerProcessor(java.lang.String str, com.huawei.agconnect.JsonProcessingFactory.JsonProcessor jsonProcessor) {
        a.put(str, jsonProcessor);
    }
}
