package com.alibaba.fastjson.serializer;

/* loaded from: classes.dex */
public interface PropertyPreFilter extends com.alibaba.fastjson.serializer.SerializeFilter {
    boolean apply(com.alibaba.fastjson.serializer.JSONSerializer jSONSerializer, java.lang.Object obj, java.lang.String str);
}
