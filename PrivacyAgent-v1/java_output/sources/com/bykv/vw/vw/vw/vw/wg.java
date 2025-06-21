package com.bykv.vw.vw.vw.vw;

/* loaded from: classes.dex */
public class wg {
    public static final com.bykv.vk.openvk.api.proto.ValueSet vw = vw(0).wg();
    public static final com.bykv.vk.openvk.api.proto.Bridge wg = new com.bykv.vw.vw.vw.vw.wg.vw(null);
    public final android.util.SparseArray<java.lang.Object> a;
    public com.bykv.vk.openvk.api.proto.ValueSet b;

    public static final class vw implements com.bykv.vk.openvk.api.proto.Bridge {
        public vw() {
        }

        public /* synthetic */ vw(com.bykv.vw.vw.vw.vw.wg.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.bykv.vk.openvk.api.proto.Caller
        public <T> T call(int i, com.bykv.vk.openvk.api.proto.ValueSet valueSet, java.lang.Class<T> cls) {
            if (cls == java.lang.Boolean.class) {
                return (T) java.lang.Boolean.FALSE;
            }
            if (cls == java.lang.Integer.TYPE || cls == java.lang.Integer.class) {
                return (T) 0;
            }
            if (cls == java.lang.Long.TYPE || cls == java.lang.Long.class) {
                return (T) 0L;
            }
            if (cls == java.lang.Double.TYPE || cls == java.lang.Double.class) {
                return (T) java.lang.Double.valueOf(0.0d);
            }
            if (cls == java.lang.Float.TYPE || cls == java.lang.Float.class) {
                return (T) java.lang.Float.valueOf(0.0f);
            }
            return null;
        }

        @Override // com.bykv.vk.openvk.api.proto.Bridge
        public com.bykv.vk.openvk.api.proto.ValueSet values() {
            return com.bykv.vw.vw.vw.vw.wg.vw;
        }
    }

    /* renamed from: com.bykv.vw.vw.vw.vw.wg$wg, reason: collision with other inner class name */
    public static final class C0262wg implements com.bykv.vk.openvk.api.proto.ValueSet {
        public final android.util.SparseArray<java.lang.Object> a;
        public com.bykv.vk.openvk.api.proto.ValueSet b;
        public int c;

        public C0262wg(android.util.SparseArray<java.lang.Object> sparseArray, com.bykv.vk.openvk.api.proto.ValueSet valueSet) {
            this.c = -1;
            this.a = sparseArray;
            this.b = valueSet;
        }

        public /* synthetic */ C0262wg(android.util.SparseArray sparseArray, com.bykv.vk.openvk.api.proto.ValueSet valueSet, com.bykv.vw.vw.vw.vw.wg.AnonymousClass1 anonymousClass1) {
            this(sparseArray, valueSet);
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public <T> T[] arrayValue(int i, java.lang.Class<T> cls) {
            java.lang.Object obj = this.a.get(i);
            if (obj == null) {
                com.bykv.vk.openvk.api.proto.ValueSet valueSet = this.b;
                if (valueSet != null) {
                    return (T[]) valueSet.arrayValue(i, cls);
                }
                return null;
            }
            java.lang.Class<?> cls2 = obj.getClass();
            if (cls2.isArray() && cls.isAssignableFrom(cls2.getComponentType())) {
                return (T[]) ((java.lang.Object[]) obj);
            }
            return null;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public boolean booleanValue(int i) {
            return booleanValue(i, false);
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public boolean booleanValue(int i, boolean z) {
            com.bykv.vk.openvk.api.proto.ValueSet valueSet;
            java.lang.Object obj = this.a.get(i);
            if (obj == null && (valueSet = this.b) != null) {
                return valueSet.booleanValue(i, z);
            }
            if (obj instanceof com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter) {
                obj = ((com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter) obj).get();
            }
            return obj instanceof java.lang.Boolean ? ((java.lang.Boolean) obj).booleanValue() : z;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public boolean containsKey(int i) {
            com.bykv.vk.openvk.api.proto.ValueSet valueSet;
            int indexOfKey = this.a.indexOfKey(i);
            return (indexOfKey >= 0 || (valueSet = this.b) == null) ? indexOfKey >= 0 : valueSet.containsKey(i);
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public double doubleValue(int i) {
            com.bykv.vk.openvk.api.proto.ValueSet valueSet;
            java.lang.Object obj = this.a.get(i);
            if (obj == null && (valueSet = this.b) != null) {
                return valueSet.doubleValue(i);
            }
            if (obj instanceof com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter) {
                obj = ((com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter) obj).get();
            }
            if (obj instanceof java.lang.Double) {
                return ((java.lang.Double) obj).doubleValue();
            }
            return 0.0d;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public float floatValue(int i) {
            return floatValue(i, 0.0f);
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public float floatValue(int i, float f) {
            com.bykv.vk.openvk.api.proto.ValueSet valueSet;
            java.lang.Object obj = this.a.get(i);
            if (obj == null && (valueSet = this.b) != null) {
                return valueSet.floatValue(i, f);
            }
            if (obj instanceof com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter) {
                obj = ((com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter) obj).get();
            }
            return obj instanceof java.lang.Float ? ((java.lang.Float) obj).floatValue() : f;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public int intValue(int i) {
            return intValue(i, 0);
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public int intValue(int i, int i2) {
            com.bykv.vk.openvk.api.proto.ValueSet valueSet;
            java.lang.Object obj = this.a.get(i);
            if (obj == null && (valueSet = this.b) != null) {
                return valueSet.intValue(i, i2);
            }
            if (obj instanceof com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter) {
                obj = ((com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter) obj).get();
            }
            return obj instanceof java.lang.Integer ? ((java.lang.Integer) obj).intValue() : i2;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public boolean isEmpty() {
            return size() <= 0;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public java.util.Set<java.lang.Integer> keys() {
            int size = this.a.size();
            java.util.HashSet hashSet = new java.util.HashSet();
            for (int i = 0; i < size; i++) {
                hashSet.add(java.lang.Integer.valueOf(this.a.keyAt(i)));
            }
            com.bykv.vk.openvk.api.proto.ValueSet valueSet = this.b;
            if (valueSet != null) {
                hashSet.addAll(valueSet.keys());
            }
            this.c = hashSet.size();
            return hashSet;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public long longValue(int i) {
            return longValue(i, 0L);
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public long longValue(int i, long j) {
            com.bykv.vk.openvk.api.proto.ValueSet valueSet;
            java.lang.Object obj = this.a.get(i);
            if (obj == null && (valueSet = this.b) != null) {
                return valueSet.longValue(i, j);
            }
            if (obj instanceof com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter) {
                obj = ((com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter) obj).get();
            }
            return obj instanceof java.lang.Long ? ((java.lang.Long) obj).longValue() : j;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public <T> T objectValue(int i, java.lang.Class<T> cls) {
            com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter valueGetter = (T) this.a.get(i);
            if (valueGetter == null) {
                com.bykv.vk.openvk.api.proto.ValueSet valueSet = this.b;
                if (valueSet != null) {
                    return (T) valueSet.objectValue(i, cls);
                }
                return null;
            }
            if (valueGetter instanceof com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter) {
                valueGetter = (T) valueGetter.get();
            }
            if (cls.isInstance(valueGetter)) {
                return (T) valueGetter;
            }
            return null;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public int size() {
            if (this.c < 0) {
                keys();
            }
            return this.c;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public java.lang.String stringValue(int i) {
            return stringValue(i, null);
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public java.lang.String stringValue(int i, java.lang.String str) {
            com.bykv.vk.openvk.api.proto.ValueSet valueSet;
            java.lang.Object obj = this.a.get(i);
            if (obj != null || (valueSet = this.b) == null) {
                return (obj instanceof com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter ? ((com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter) obj).get() : obj) instanceof java.lang.String ? obj.toString() : str;
            }
            return valueSet.stringValue(i, str);
        }
    }

    public wg(android.util.SparseArray<java.lang.Object> sparseArray) {
        this.a = sparseArray;
    }

    public wg(android.util.SparseArray<java.lang.Object> sparseArray, com.bykv.vk.openvk.api.proto.ValueSet valueSet) {
        this.a = sparseArray;
        this.b = valueSet;
    }

    public static final com.bykv.vw.vw.vw.vw.wg vw() {
        return new com.bykv.vw.vw.vw.vw.wg(new android.util.SparseArray());
    }

    public static final com.bykv.vw.vw.vw.vw.wg vw(int i) {
        return new com.bykv.vw.vw.vw.vw.wg(new android.util.SparseArray(i));
    }

    public static final com.bykv.vw.vw.vw.vw.wg vw(com.bykv.vk.openvk.api.proto.ValueSet valueSet) {
        return new com.bykv.vw.vw.vw.vw.wg(new android.util.SparseArray(), valueSet);
    }

    public com.bykv.vw.vw.vw.vw.wg vw(int i, double d) {
        this.a.put(i, java.lang.Double.valueOf(d));
        return this;
    }

    public com.bykv.vw.vw.vw.vw.wg vw(int i, float f) {
        this.a.put(i, java.lang.Float.valueOf(f));
        return this;
    }

    public com.bykv.vw.vw.vw.vw.wg vw(int i, int i2) {
        this.a.put(i, java.lang.Integer.valueOf(i2));
        return this;
    }

    public com.bykv.vw.vw.vw.vw.wg vw(int i, long j) {
        this.a.put(i, java.lang.Long.valueOf(j));
        return this;
    }

    public com.bykv.vw.vw.vw.vw.wg vw(int i, java.lang.Object obj) {
        this.a.put(i, obj);
        return this;
    }

    public com.bykv.vw.vw.vw.vw.wg vw(int i, java.lang.String str) {
        this.a.put(i, str);
        return this;
    }

    public com.bykv.vw.vw.vw.vw.wg vw(int i, boolean z) {
        this.a.put(i, java.lang.Boolean.valueOf(z));
        return this;
    }

    public com.bykv.vk.openvk.api.proto.ValueSet wg() {
        return new com.bykv.vw.vw.vw.vw.wg.C0262wg(this.a, this.b, null);
    }
}
