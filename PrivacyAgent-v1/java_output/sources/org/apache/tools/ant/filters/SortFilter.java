package org.apache.tools.ant.filters;

/* loaded from: classes25.dex */
public final class SortFilter extends org.apache.tools.ant.filters.BaseParamFilterReader implements org.apache.tools.ant.filters.ChainableReader {
    public java.util.Comparator<? super java.lang.String> v;
    public boolean w;
    public java.util.List<java.lang.String> x;
    public java.lang.String y;
    public java.util.Iterator<java.lang.String> z;

    /* renamed from: org.apache.tools.ant.filters.SortFilter$1, reason: invalid class name */
    public class AnonymousClass1 implements java.util.Comparator<java.lang.String> {
        public AnonymousClass1() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(java.lang.String str, java.lang.String str2) {
            return -str.compareTo(str2);
        }
    }

    public SortFilter() {
        this.v = null;
        this.y = null;
        this.z = null;
    }

    public SortFilter(java.io.Reader reader) {
        super(reader);
        this.v = null;
        this.y = null;
        this.z = null;
    }

    public final void a() throws java.io.IOException {
        org.apache.tools.ant.types.Parameter[] parameters = getParameters();
        if (parameters != null) {
            for (org.apache.tools.ant.types.Parameter parameter : parameters) {
                java.lang.String name = parameter.getName();
                if ("reverse".equals(name)) {
                    setReverse(java.lang.Boolean.valueOf(parameter.getValue()).booleanValue());
                } else if ("comparator".equals(name)) {
                    try {
                        setComparator((java.util.Comparator) java.lang.Class.forName(parameter.getValue()).newInstance());
                    } catch (java.lang.ClassCastException unused) {
                        throw new org.apache.tools.ant.BuildException("Value of comparator attribute should implement java.util.Comparator interface");
                    } catch (java.lang.ClassNotFoundException e) {
                        throw new org.apache.tools.ant.BuildException(e);
                    } catch (java.lang.IllegalAccessException e2) {
                        throw new org.apache.tools.ant.BuildException(e2);
                    } catch (java.lang.InstantiationException e3) {
                        throw new org.apache.tools.ant.BuildException(e3);
                    } catch (java.lang.Exception e4) {
                        throw new org.apache.tools.ant.BuildException(e4);
                    }
                } else {
                    continue;
                }
            }
        }
    }

    public void add(java.util.Comparator<? super java.lang.String> comparator) {
        if (this.v != null && comparator != null) {
            throw new org.apache.tools.ant.BuildException("can't have more than one comparator");
        }
        setComparator(comparator);
    }

    public final void c() {
        java.util.Comparator<? super java.lang.String> comparator = this.v;
        if (comparator != null) {
            java.util.Collections.sort(this.x, comparator);
        } else if (this.w) {
            java.util.Collections.sort(this.x, new org.apache.tools.ant.filters.SortFilter.AnonymousClass1());
        } else {
            java.util.Collections.sort(this.x);
        }
    }

    @Override // org.apache.tools.ant.filters.ChainableReader
    public java.io.Reader chain(java.io.Reader reader) {
        org.apache.tools.ant.filters.SortFilter sortFilter = new org.apache.tools.ant.filters.SortFilter(reader);
        sortFilter.setReverse(isReverse());
        sortFilter.setComparator(getComparator());
        sortFilter.setInitialized(true);
        return sortFilter;
    }

    public java.util.Comparator<? super java.lang.String> getComparator() {
        return this.v;
    }

    public boolean isReverse() {
        return this.w;
    }

    @Override // java.io.FilterReader, java.io.Reader
    public int read() throws java.io.IOException {
        if (!getInitialized()) {
            a();
            setInitialized(true);
        }
        java.lang.String str = this.y;
        if (str != null) {
            char charAt = str.charAt(0);
            if (this.y.length() == 1) {
                this.y = null;
                return charAt;
            }
            this.y = this.y.substring(1);
            return charAt;
        }
        if (this.x == null) {
            this.x = new java.util.ArrayList();
            while (true) {
                this.y = readLine();
                java.lang.String str2 = this.y;
                if (str2 == null) {
                    break;
                }
                this.x.add(str2);
            }
            c();
            this.z = this.x.iterator();
        }
        if (this.z.hasNext()) {
            this.y = this.z.next();
        } else {
            this.y = null;
            this.x = null;
            this.z = null;
        }
        if (this.y != null) {
            return read();
        }
        return -1;
    }

    public void setComparator(java.util.Comparator<? super java.lang.String> comparator) {
        this.v = comparator;
    }

    public void setReverse(boolean z) {
        this.w = z;
    }
}
