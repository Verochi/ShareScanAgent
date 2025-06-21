package com.alibaba.fastjson.parser.deserializer;

/* loaded from: classes.dex */
public interface FieldTypeResolver extends com.alibaba.fastjson.parser.deserializer.ParseProcess {
    java.lang.reflect.Type resolve(java.lang.Object obj, java.lang.String str);
}
