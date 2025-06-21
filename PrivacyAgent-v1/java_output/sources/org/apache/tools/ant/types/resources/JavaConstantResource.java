package org.apache.tools.ant.types.resources;

/* loaded from: classes26.dex */
public class JavaConstantResource extends org.apache.tools.ant.types.resources.AbstractClasspathResource {
    @Override // org.apache.tools.ant.types.resources.AbstractClasspathResource
    public java.io.InputStream openInputStream(java.lang.ClassLoader classLoader) throws java.io.IOException {
        java.lang.String name = getName();
        if (name == null) {
            throw new java.io.IOException("Attribute 'name' must be set.");
        }
        int lastIndexOf = name.lastIndexOf(46);
        if (lastIndexOf < 0) {
            throw new java.io.IOException("No class name in " + name);
        }
        java.lang.String substring = name.substring(0, lastIndexOf);
        java.lang.String substring2 = name.substring(lastIndexOf + 1, name.length());
        try {
            return new java.io.ByteArrayInputStream((classLoader != null ? java.lang.Class.forName(substring, true, classLoader) : java.lang.Class.forName(substring)).getField(substring2).get(null).toString().getBytes("UTF-8"));
        } catch (java.lang.ClassNotFoundException unused) {
            throw new java.io.IOException("Class not found:" + substring);
        } catch (java.lang.IllegalAccessException unused2) {
            throw new java.io.IOException("Illegal access to :" + substring2 + " in " + substring);
        } catch (java.lang.NoSuchFieldException unused3) {
            throw new java.io.IOException("Field not found:" + substring2 + " in " + substring);
        } catch (java.lang.NullPointerException unused4) {
            throw new java.io.IOException("Not a static field: " + substring2 + " in " + substring);
        }
    }
}
