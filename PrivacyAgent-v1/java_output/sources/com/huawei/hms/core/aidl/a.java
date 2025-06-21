package com.huawei.hms.core.aidl;

/* loaded from: classes22.dex */
public class a extends com.huawei.hms.core.aidl.MessageCodec {
    @Override // com.huawei.hms.core.aidl.MessageCodec
    public java.util.List<java.lang.Object> readList(java.lang.reflect.Type type, android.os.Bundle bundle) throws java.lang.InstantiationException, java.lang.IllegalAccessException {
        int i = bundle.getInt("_list_size_");
        java.util.ArrayList arrayList = new java.util.ArrayList(i);
        for (int i2 = 0; i2 < i; i2++) {
            java.lang.Object obj = bundle.get("_list_item_" + i2);
            if (obj.getClass().isPrimitive() || (obj instanceof java.lang.String) || (obj instanceof java.io.Serializable)) {
                arrayList.add(obj);
            } else if (obj instanceof android.os.Bundle) {
                android.os.Bundle bundle2 = (android.os.Bundle) obj;
                int i3 = bundle2.getInt("_val_type_", -1);
                if (i3 == 1) {
                    throw new java.lang.InstantiationException("Nested List can not be supported");
                }
                if (i3 != 0) {
                    throw new java.lang.InstantiationException("Unknown type can not be supported");
                }
                arrayList.add(decode(bundle2, (com.huawei.hms.core.aidl.IMessageEntity) ((java.lang.Class) ((java.lang.reflect.ParameterizedType) type).getActualTypeArguments()[0]).newInstance()));
            } else {
                continue;
            }
        }
        return arrayList;
    }

    @Override // com.huawei.hms.core.aidl.MessageCodec
    public void writeList(java.lang.String str, java.util.List list, android.os.Bundle bundle) {
        android.os.Bundle bundle2 = new android.os.Bundle();
        bundle2.putInt("_val_type_", 1);
        bundle2.putInt("_list_size_", list.size());
        for (int i = 0; i < list.size(); i++) {
            writeValue("_list_item_" + i, list.get(i), bundle2);
        }
        bundle.putBundle(str, bundle2);
    }
}
