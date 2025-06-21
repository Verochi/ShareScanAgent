package org.apache.tools.ant.types.selectors.modifiedselector;

/* loaded from: classes26.dex */
public class PropertiesfileCache implements org.apache.tools.ant.types.selectors.modifiedselector.Cache {
    public java.io.File a;
    public java.util.Properties b;
    public boolean c;
    public boolean d;

    public PropertiesfileCache() {
        this.a = null;
        this.b = new java.util.Properties();
        this.c = false;
        this.d = true;
    }

    public PropertiesfileCache(java.io.File file) {
        this.a = null;
        this.b = new java.util.Properties();
        this.c = false;
        this.d = true;
        this.a = file;
    }

    @Override // org.apache.tools.ant.types.selectors.modifiedselector.Cache
    public void delete() {
        this.b = new java.util.Properties();
        this.a.delete();
        this.c = true;
        this.d = false;
    }

    @Override // org.apache.tools.ant.types.selectors.modifiedselector.Cache
    public java.lang.Object get(java.lang.Object obj) {
        if (!this.c) {
            load();
        }
        try {
            return this.b.getProperty(java.lang.String.valueOf(obj));
        } catch (java.lang.ClassCastException unused) {
            return null;
        }
    }

    public java.io.File getCachefile() {
        return this.a;
    }

    @Override // org.apache.tools.ant.types.selectors.modifiedselector.Cache
    public boolean isValid() {
        return this.a != null;
    }

    @Override // org.apache.tools.ant.types.selectors.modifiedselector.Cache
    public java.util.Iterator<java.lang.String> iterator() {
        java.util.Vector vector = new java.util.Vector();
        java.util.Enumeration<?> propertyNames = this.b.propertyNames();
        while (propertyNames.hasMoreElements()) {
            vector.add(propertyNames.nextElement().toString());
        }
        return vector.iterator();
    }

    @Override // org.apache.tools.ant.types.selectors.modifiedselector.Cache
    public void load() {
        java.io.File file = this.a;
        if (file != null && file.isFile() && this.a.canRead()) {
            try {
                java.io.BufferedInputStream bufferedInputStream = new java.io.BufferedInputStream(new java.io.FileInputStream(this.a));
                this.b.load(bufferedInputStream);
                bufferedInputStream.close();
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
        this.c = true;
        this.d = false;
    }

    @Override // org.apache.tools.ant.types.selectors.modifiedselector.Cache
    public void put(java.lang.Object obj, java.lang.Object obj2) {
        this.b.put(java.lang.String.valueOf(obj), java.lang.String.valueOf(obj2));
        this.d = true;
    }

    @Override // org.apache.tools.ant.types.selectors.modifiedselector.Cache
    public void save() {
        if (this.d) {
            if (this.a != null && this.b.propertyNames().hasMoreElements()) {
                try {
                    java.io.BufferedOutputStream bufferedOutputStream = new java.io.BufferedOutputStream(new java.io.FileOutputStream(this.a));
                    this.b.store(bufferedOutputStream, (java.lang.String) null);
                    bufferedOutputStream.flush();
                    bufferedOutputStream.close();
                } catch (java.lang.Exception e) {
                    e.printStackTrace();
                }
            }
            this.d = false;
        }
    }

    public void setCachefile(java.io.File file) {
        this.a = file;
    }

    public java.lang.String toString() {
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        stringBuffer.append("<PropertiesfileCache:");
        stringBuffer.append("cachefile=");
        stringBuffer.append(this.a);
        stringBuffer.append(";noOfEntries=");
        stringBuffer.append(this.b.size());
        stringBuffer.append(">");
        return stringBuffer.toString();
    }
}
