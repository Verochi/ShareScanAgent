package org.apache.tools.ant.filters.util;

/* loaded from: classes25.dex */
public final class ChainReaderHelper {
    public java.io.Reader primaryReader;
    public int bufferSize = 8192;
    public java.util.Vector<org.apache.tools.ant.types.FilterChain> filterChains = new java.util.Vector<>();
    public org.apache.tools.ant.Project a = null;

    /* renamed from: org.apache.tools.ant.filters.util.ChainReaderHelper$1, reason: invalid class name */
    public class AnonymousClass1 extends java.io.FilterReader {
        public final /* synthetic */ java.util.ArrayList n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(java.io.Reader reader, java.util.ArrayList arrayList) {
            super(reader);
            this.n = arrayList;
        }

        @Override // java.io.FilterReader, java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws java.io.IOException {
            org.apache.tools.ant.util.FileUtils.close(((java.io.FilterReader) this).in);
            org.apache.tools.ant.filters.util.ChainReaderHelper.b(this.n);
        }

        public void finalize() throws java.lang.Throwable {
            try {
                close();
            } finally {
                super.finalize();
            }
        }
    }

    public static void b(java.util.List<org.apache.tools.ant.AntClassLoader> list) {
        java.util.Iterator<org.apache.tools.ant.AntClassLoader> it = list.iterator();
        while (it.hasNext()) {
            it.next().cleanup();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final java.io.Reader c(org.apache.tools.ant.types.AntFilterReader antFilterReader, java.io.Reader reader, java.util.List<org.apache.tools.ant.AntClassLoader> list) {
        java.lang.Class<?> cls;
        boolean z;
        java.lang.String className = antFilterReader.getClassName();
        org.apache.tools.ant.types.Path classpath = antFilterReader.getClasspath();
        org.apache.tools.ant.Project project = antFilterReader.getProject();
        if (className != null) {
            try {
                if (classpath == null) {
                    cls = java.lang.Class.forName(className);
                } else {
                    org.apache.tools.ant.AntClassLoader createClassLoader = project.createClassLoader(classpath);
                    list.add(createClassLoader);
                    cls = java.lang.Class.forName(className, true, createClassLoader);
                }
                if (cls != null) {
                    if (!java.io.FilterReader.class.isAssignableFrom(cls)) {
                        throw new org.apache.tools.ant.BuildException(className + " does not extend java.io.FilterReader");
                    }
                    java.lang.reflect.Constructor<?>[] constructors = cls.getConstructors();
                    int i = 0;
                    while (true) {
                        if (i >= constructors.length) {
                            z = false;
                            break;
                        }
                        java.lang.Class<?>[] parameterTypes = constructors[i].getParameterTypes();
                        if (parameterTypes.length == 1 && parameterTypes[0].isAssignableFrom(java.io.Reader.class)) {
                            z = true;
                            break;
                        }
                        i++;
                    }
                    if (!z) {
                        throw new org.apache.tools.ant.BuildException(className + " does not define a public constructor that takes in a Reader as its single argument.");
                    }
                    java.io.Reader reader2 = (java.io.Reader) constructors[i].newInstance(reader);
                    d(reader2);
                    if (org.apache.tools.ant.types.Parameterizable.class.isAssignableFrom(cls)) {
                        ((org.apache.tools.ant.types.Parameterizable) reader2).setParameters(antFilterReader.getParams());
                    }
                    return reader2;
                }
            } catch (java.lang.ClassNotFoundException e) {
                throw new org.apache.tools.ant.BuildException(e);
            } catch (java.lang.IllegalAccessException e2) {
                throw new org.apache.tools.ant.BuildException(e2);
            } catch (java.lang.InstantiationException e3) {
                throw new org.apache.tools.ant.BuildException(e3);
            } catch (java.lang.reflect.InvocationTargetException e4) {
                throw new org.apache.tools.ant.BuildException(e4);
            }
        }
        return reader;
    }

    public final void d(java.lang.Object obj) {
        org.apache.tools.ant.Project project = this.a;
        if (project == null) {
            return;
        }
        if (obj instanceof org.apache.tools.ant.filters.BaseFilterReader) {
            ((org.apache.tools.ant.filters.BaseFilterReader) obj).setProject(project);
        } else {
            project.setProjectReference(obj);
        }
    }

    public java.io.Reader getAssembledReader() throws org.apache.tools.ant.BuildException {
        java.io.Reader reader = this.primaryReader;
        if (reader == null) {
            throw new org.apache.tools.ant.BuildException("primaryReader must not be null.");
        }
        int size = this.filterChains.size();
        java.util.Vector vector = new java.util.Vector();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (int i = 0; i < size; i++) {
            java.util.Vector<java.lang.Object> filterReaders = this.filterChains.elementAt(i).getFilterReaders();
            int size2 = filterReaders.size();
            for (int i2 = 0; i2 < size2; i2++) {
                vector.addElement(filterReaders.elementAt(i2));
            }
        }
        int size3 = vector.size();
        if (size3 > 0) {
            for (int i3 = 0; i3 < size3; i3++) {
                try {
                    java.lang.Object elementAt = vector.elementAt(i3);
                    if (elementAt instanceof org.apache.tools.ant.types.AntFilterReader) {
                        reader = c((org.apache.tools.ant.types.AntFilterReader) vector.elementAt(i3), reader, arrayList);
                    } else if (elementAt instanceof org.apache.tools.ant.filters.ChainableReader) {
                        d(elementAt);
                        reader = ((org.apache.tools.ant.filters.ChainableReader) elementAt).chain(reader);
                        d(reader);
                    }
                } catch (java.lang.Throwable th) {
                    if (arrayList.size() > 0) {
                        b(arrayList);
                    }
                    throw th;
                }
            }
        }
        return arrayList.size() == 0 ? reader : new org.apache.tools.ant.filters.util.ChainReaderHelper.AnonymousClass1(reader, arrayList);
    }

    public org.apache.tools.ant.Project getProject() {
        return this.a;
    }

    public java.lang.String readFully(java.io.Reader reader) throws java.io.IOException {
        return org.apache.tools.ant.util.FileUtils.readFully(reader, this.bufferSize);
    }

    public void setBufferSize(int i) {
        this.bufferSize = i;
    }

    public void setFilterChains(java.util.Vector<org.apache.tools.ant.types.FilterChain> vector) {
        this.filterChains = vector;
    }

    public void setPrimaryReader(java.io.Reader reader) {
        this.primaryReader = reader;
    }

    public void setProject(org.apache.tools.ant.Project project) {
        this.a = project;
    }
}
