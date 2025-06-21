package com.aliyun.common.whitelist;

/* loaded from: classes.dex */
public class PropertyValueExchanger {
    public static java.lang.String KEY_ENCODER_YUV420_FORMAT = "encoder-yuv420-format";
    private java.util.HashMap<java.lang.String, com.aliyun.common.whitelist.PropertyValueExchanger.Entry> mMap = new java.util.HashMap<>();

    public class Entry<T> {
        T mDeviceRightValue;
        T mOriginalValue;

        public Entry(T t, T t2) {
            this.mOriginalValue = t;
            this.mDeviceRightValue = t2;
        }

        public T replaceValue(T t) {
            return this.mOriginalValue.equals(t) ? this.mDeviceRightValue : t;
        }
    }

    public <T> void addPropertyEntry(java.lang.String str, T t, T t2) {
        this.mMap.put(str, new com.aliyun.common.whitelist.PropertyValueExchanger.Entry(t, t2));
    }

    public <T> com.aliyun.common.whitelist.PropertyValueExchanger.Entry<T> getPropertyEntry(java.lang.String str) {
        if (this.mMap.containsKey(str)) {
            return this.mMap.get(str);
        }
        return null;
    }

    public boolean hasProperty(java.lang.String str) {
        return this.mMap.containsKey(str);
    }
}
