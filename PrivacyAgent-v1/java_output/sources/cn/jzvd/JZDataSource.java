package cn.jzvd;

/* loaded from: classes.dex */
public class JZDataSource {
    public static final java.lang.String URL_KEY_DEFAULT = "URL_KEY_DEFAULT";
    public int currentUrlIndex;
    public java.util.HashMap<java.lang.String, java.lang.String> headerMap;
    public boolean looping;
    public java.lang.Object[] objects;
    public java.lang.String title;
    public java.util.LinkedHashMap urlsMap;

    public JZDataSource(java.lang.Object obj) {
        this.urlsMap = new java.util.LinkedHashMap();
        this.title = "";
        this.headerMap = new java.util.HashMap<>();
        this.looping = true;
        this.urlsMap.put(URL_KEY_DEFAULT, obj);
        this.currentUrlIndex = 0;
    }

    public JZDataSource(java.lang.String str) {
        this.urlsMap = new java.util.LinkedHashMap();
        this.title = "";
        this.headerMap = new java.util.HashMap<>();
        this.looping = true;
        this.urlsMap.put(URL_KEY_DEFAULT, str);
        this.currentUrlIndex = 0;
    }

    public JZDataSource(java.lang.String str, java.lang.String str2) {
        this.urlsMap = new java.util.LinkedHashMap();
        this.title = "";
        this.headerMap = new java.util.HashMap<>();
        this.looping = true;
        this.urlsMap.put(URL_KEY_DEFAULT, str);
        this.title = str2;
        this.currentUrlIndex = 0;
    }

    public JZDataSource(java.util.LinkedHashMap linkedHashMap) {
        this.urlsMap = new java.util.LinkedHashMap();
        this.title = "";
        this.headerMap = new java.util.HashMap<>();
        this.looping = true;
        this.urlsMap.clear();
        this.urlsMap.putAll(linkedHashMap);
        this.currentUrlIndex = 0;
    }

    public JZDataSource(java.util.LinkedHashMap linkedHashMap, java.lang.String str) {
        this.urlsMap = new java.util.LinkedHashMap();
        this.title = "";
        this.headerMap = new java.util.HashMap<>();
        this.looping = true;
        this.urlsMap.clear();
        this.urlsMap.putAll(linkedHashMap);
        this.title = str;
        this.currentUrlIndex = 0;
    }

    public cn.jzvd.JZDataSource cloneMe() {
        java.util.LinkedHashMap linkedHashMap = new java.util.LinkedHashMap();
        linkedHashMap.putAll(this.urlsMap);
        return new cn.jzvd.JZDataSource(linkedHashMap, this.title);
    }

    public boolean containsTheUrl(java.lang.Object obj) {
        if (obj != null) {
            return this.urlsMap.containsValue(obj);
        }
        return false;
    }

    public java.lang.Object getCurrentKey() {
        return getKeyFromDataSource(this.currentUrlIndex);
    }

    public java.lang.Object getCurrentUrl() {
        return getValueFromLinkedMap(this.currentUrlIndex);
    }

    public java.lang.String getKeyFromDataSource(int i) {
        int i2 = 0;
        for (java.lang.Object obj : this.urlsMap.keySet()) {
            if (i2 == i) {
                return obj.toString();
            }
            i2++;
        }
        return null;
    }

    public java.lang.Object getValueFromLinkedMap(int i) {
        int i2 = 0;
        for (java.lang.Object obj : this.urlsMap.keySet()) {
            if (i2 == i) {
                return this.urlsMap.get(obj);
            }
            i2++;
        }
        return null;
    }
}
