package cn.fly.verify;

/* loaded from: classes.dex */
public class fh {

    public interface a {
        void a(cn.fly.verify.fh.b bVar) throws java.lang.Throwable;
    }

    public static class b {
        private java.lang.String A;
        private java.lang.Object C;
        private java.util.ArrayList<java.util.HashMap<java.lang.String, java.lang.Object>> D;
        private java.lang.String E;
        private java.util.HashMap<java.lang.String, java.lang.Object> F;
        private java.util.HashMap<java.lang.String, java.lang.Object> H;
        private java.util.ArrayList<java.util.ArrayList<java.lang.String>> I;
        private java.lang.String J;
        private java.util.HashMap<java.lang.String, java.util.HashMap<java.lang.String, java.lang.Long>> K;
        private java.util.HashMap<java.lang.String, java.lang.Long> L;
        private java.lang.String M;
        private boolean N;
        private boolean O;
        private boolean P;
        private boolean Q;
        private boolean R;
        private boolean S;
        private boolean T;
        private boolean U;
        private java.lang.String V;
        private java.lang.String W;
        private java.lang.String X;
        private java.lang.String Y;
        private int Z;
        private boolean a;
        private java.lang.String aA;
        private int aB;
        private java.util.HashMap<java.lang.String, java.lang.Object> aD;
        private java.util.ArrayList<java.util.HashMap<java.lang.String, java.lang.Object>> aF;
        private java.lang.String aG;
        private java.lang.String aI;
        private boolean aK;
        private java.util.ArrayList<java.util.HashMap<java.lang.String, java.lang.Object>> aL;
        private boolean aP;
        private java.lang.String aQ;
        private java.lang.String af;
        private java.lang.String ag;
        private java.lang.String ah;
        private long ai;
        private java.lang.String aj;
        private java.lang.String ak;
        private java.lang.String al;
        private java.lang.String am;
        private java.lang.String an;
        private java.util.HashMap<java.lang.String, java.lang.Object> ao;
        private android.content.pm.ApplicationInfo ap;
        private long as;
        private double at;
        private int au;
        private boolean av;
        private java.lang.String aw;
        private java.lang.String ax;
        private int ay;
        private int az;
        private java.lang.String b;
        private java.lang.String d;
        private java.lang.String g;
        private java.lang.String h;
        private java.lang.String j;
        private java.lang.String l;
        private java.lang.String n;
        private java.lang.String o;
        private boolean q;
        private java.lang.String r;

        /* renamed from: s, reason: collision with root package name */
        private java.lang.String f71s;
        private java.lang.String t;
        private java.lang.String v;
        private java.util.ArrayList<java.util.HashMap<java.lang.String, java.lang.String>> z;
        private java.util.LinkedList<java.lang.String> c = new java.util.LinkedList<>();
        private java.util.LinkedList<java.lang.String> e = new java.util.LinkedList<>();
        private java.util.LinkedList<java.lang.String> f = new java.util.LinkedList<>();
        private java.util.LinkedList<java.lang.String> i = new java.util.LinkedList<>();
        private java.util.LinkedList<java.lang.String> k = new java.util.LinkedList<>();
        private java.util.LinkedList<java.lang.String> m = new java.util.LinkedList<>();
        private java.util.LinkedList<java.lang.String> p = new java.util.LinkedList<>();
        private java.util.LinkedList<java.lang.String> u = new java.util.LinkedList<>();
        private java.util.LinkedList<java.lang.String> w = new java.util.LinkedList<>();
        private java.util.LinkedList<java.util.ArrayList<java.util.HashMap<java.lang.String, java.lang.String>>> x = new java.util.LinkedList<>();
        private java.util.LinkedList<java.util.ArrayList<java.util.HashMap<java.lang.String, java.lang.String>>> y = new java.util.LinkedList<>();
        private java.util.LinkedList<android.location.Location> B = new java.util.LinkedList<>();
        private java.util.LinkedList<java.lang.Boolean> G = new java.util.LinkedList<>();
        private java.util.LinkedList<java.util.List<android.content.pm.ResolveInfo>> aa = new java.util.LinkedList<>();
        private java.util.LinkedList<android.content.pm.ResolveInfo> ab = new java.util.LinkedList<>();
        private java.util.LinkedList<android.content.pm.PackageInfo> ac = new java.util.LinkedList<>();
        private java.util.LinkedList<android.content.pm.PackageInfo> ad = new java.util.LinkedList<>();
        private java.util.LinkedList<android.content.pm.PackageInfo> ae = new java.util.LinkedList<>();
        private java.util.LinkedList<android.content.pm.ApplicationInfo> aq = new java.util.LinkedList<>();
        private java.util.LinkedList<android.content.pm.ApplicationInfo> ar = new java.util.LinkedList<>();
        private java.util.LinkedList<java.lang.Object> aC = new java.util.LinkedList<>();
        private java.util.LinkedList<java.util.HashMap<java.lang.String, java.lang.Object>> aE = new java.util.LinkedList<>();
        private java.util.LinkedList<java.lang.String> aH = new java.util.LinkedList<>();
        private java.util.LinkedList<java.lang.String> aJ = new java.util.LinkedList<>();
        private java.util.LinkedList<java.lang.Object> aM = new java.util.LinkedList<>();
        private java.util.LinkedList<java.lang.Object> aN = new java.util.LinkedList<>();
        private java.util.LinkedList<java.lang.Object> aO = new java.util.LinkedList<>();
        private java.util.LinkedList<java.lang.Long> aR = new java.util.LinkedList<>();

        private static <T> T a(java.util.LinkedList<T> linkedList, T t, int... iArr) {
            if (linkedList != null) {
                try {
                    if (iArr.length == 0) {
                        return linkedList.get(0);
                    }
                    if (iArr[0] < linkedList.size()) {
                        return linkedList.get(iArr[0]);
                    }
                    cn.fly.verify.ed.a().b("WARNING: " + iArr[0] + " out of bound, size: " + linkedList.size());
                } catch (java.lang.Throwable th) {
                    cn.fly.verify.ed.a().a(th);
                }
            }
            return t;
        }

        public java.lang.String A() {
            return this.an;
        }

        public java.lang.String B() {
            return this.aA;
        }

        public int C() {
            return this.aB;
        }

        public boolean D() {
            return this.aK;
        }

        public boolean E() {
            return this.aP;
        }

        public java.lang.String F() {
            return this.aQ;
        }

        public java.lang.String a(int... iArr) {
            return (java.lang.String) a(this.i, "-1", iArr);
        }

        public void a(java.lang.String str, java.lang.Object obj) throws java.lang.Throwable {
            a(str, obj, false);
        }

        /* JADX WARN: Code restructure failed: missing block: B:101:0x0135, code lost:
        
            if (r8 != false) goto L36;
         */
        /* JADX WARN: Code restructure failed: missing block: B:129:0x018e, code lost:
        
            if (r8 != false) goto L36;
         */
        /* JADX WARN: Code restructure failed: missing block: B:12:0x001d, code lost:
        
            if (r8 != false) goto L6;
         */
        /* JADX WARN: Code restructure failed: missing block: B:139:0x01ae, code lost:
        
            if (r8 != false) goto L36;
         */
        /* JADX WARN: Code restructure failed: missing block: B:143:0x01bc, code lost:
        
            if (r8 != false) goto L36;
         */
        /* JADX WARN: Code restructure failed: missing block: B:144:0x01c0, code lost:
        
            r1 = (java.util.ArrayList) r7;
         */
        /* JADX WARN: Code restructure failed: missing block: B:148:0x01cf, code lost:
        
            if (r8 != false) goto L36;
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x002a, code lost:
        
            if (r8 != false) goto L6;
         */
        /* JADX WARN: Code restructure failed: missing block: B:323:0x040c, code lost:
        
            if (r8 != false) goto L36;
         */
        /* JADX WARN: Code restructure failed: missing block: B:324:0x0410, code lost:
        
            r1 = (android.content.pm.PackageInfo) r7;
         */
        /* JADX WARN: Code restructure failed: missing block: B:328:0x041f, code lost:
        
            if (r8 != false) goto L36;
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x005f, code lost:
        
            if (r8 != false) goto L36;
         */
        /* JADX WARN: Code restructure failed: missing block: B:332:0x042d, code lost:
        
            if (r8 != false) goto L36;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x0062, code lost:
        
            r1 = (java.lang.String) r7;
         */
        /* JADX WARN: Code restructure failed: missing block: B:402:0x0506, code lost:
        
            if (r8 != false) goto L36;
         */
        /* JADX WARN: Code restructure failed: missing block: B:403:0x050a, code lost:
        
            r1 = (android.content.pm.ApplicationInfo) r7;
         */
        /* JADX WARN: Code restructure failed: missing block: B:407:0x0519, code lost:
        
            if (r8 != false) goto L36;
         */
        /* JADX WARN: Code restructure failed: missing block: B:45:0x0086, code lost:
        
            if (r8 != false) goto L36;
         */
        /* JADX WARN: Code restructure failed: missing block: B:472:0x05f3, code lost:
        
            if (r8 != false) goto L6;
         */
        /* JADX WARN: Code restructure failed: missing block: B:499:0x064b, code lost:
        
            if (r8 != false) goto L36;
         */
        /* JADX WARN: Code restructure failed: missing block: B:49:0x0093, code lost:
        
            if (r8 != false) goto L36;
         */
        /* JADX WARN: Code restructure failed: missing block: B:4:0x000b, code lost:
        
            if (r8 != false) goto L6;
         */
        /* JADX WARN: Code restructure failed: missing block: B:509:0x066b, code lost:
        
            if (r8 != false) goto L36;
         */
        /* JADX WARN: Code restructure failed: missing block: B:5:0x000d, code lost:
        
            r7 = null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:65:0x00c4, code lost:
        
            if (r8 != false) goto L36;
         */
        /* JADX WARN: Code restructure failed: missing block: B:75:0x00e3, code lost:
        
            if (r8 != false) goto L36;
         */
        /* JADX WARN: Code restructure failed: missing block: B:85:0x0103, code lost:
        
            if (r8 != false) goto L36;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v109, types: [android.location.Location] */
        /* JADX WARN: Type inference failed for: r1v117, types: [java.util.ArrayList] */
        /* JADX WARN: Type inference failed for: r1v153, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r1v32, types: [android.content.pm.ApplicationInfo] */
        /* JADX WARN: Type inference failed for: r1v64, types: [android.content.pm.PackageInfo] */
        /* JADX WARN: Type inference failed for: r1v66, types: [android.content.pm.ResolveInfo] */
        /* JADX WARN: Type inference failed for: r1v68, types: [java.util.List] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void a(java.lang.String str, java.lang.Object obj, boolean z) throws java.lang.Throwable {
            java.util.LinkedList linkedList;
            java.util.LinkedList linkedList2;
            r1 = null;
            r1 = null;
            r1 = null;
            r1 = null;
            r1 = null;
            r1 = null;
            r1 = null;
            r1 = null;
            r1 = null;
            r1 = null;
            r1 = null;
            r1 = null;
            r1 = null;
            r1 = null;
            r1 = null;
            r1 = null;
            r1 = null;
            r1 = null;
            r1 = null;
            r1 = null;
            r1 = null;
            java.util.HashMap hashMap = null;
            if ("gmpfo".equals(str)) {
                linkedList = this.aM;
            } else if ("gmpfofce".equals(str)) {
                linkedList = this.aN;
            } else if ("getMpfos".equals(str)) {
                linkedList = this.aO;
            } else {
                boolean z2 = false;
                z2 = false;
                if ("cird".equals(str)) {
                    this.a = z ? false : ((java.lang.Boolean) obj).booleanValue();
                    return;
                }
                if ("gsimt".equals(str)) {
                    this.b = z ? null : (java.lang.String) obj;
                    return;
                }
                if ("gsimtfce".equals(str)) {
                    linkedList2 = this.c;
                } else {
                    if ("gbsi".equals(str)) {
                        this.d = z ? null : (java.lang.String) obj;
                        return;
                    }
                    if ("gbsifce".equals(str)) {
                        linkedList2 = this.e;
                    } else if ("gstmpts".equals(str)) {
                        linkedList2 = this.f;
                    } else {
                        if ("gscsz".equals(str)) {
                            this.g = z ? null : (java.lang.String) obj;
                            return;
                        }
                        if ("gcrie".equals(str)) {
                            this.h = z ? null : (java.lang.String) obj;
                            return;
                        }
                        if ("gcriefce".equals(str)) {
                            linkedList2 = this.i;
                        } else {
                            if ("gcrnm".equals(str)) {
                                this.j = z ? null : (java.lang.String) obj;
                                return;
                            }
                            if ("gcrnmfce".equals(str)) {
                                linkedList2 = this.k;
                            } else {
                                if ("gsnmd".equals(str)) {
                                    this.l = z ? null : (java.lang.String) obj;
                                    return;
                                }
                                if ("gsnmdfp".equals(str)) {
                                    linkedList2 = this.m;
                                } else {
                                    if ("gneyp".equals(str)) {
                                        this.n = z ? null : (java.lang.String) obj;
                                        return;
                                    }
                                    if ("gneypnw".equals(str)) {
                                        this.o = z ? null : (java.lang.String) obj;
                                        return;
                                    }
                                    if ("gneypfce".equals(str)) {
                                        linkedList2 = this.p;
                                    } else {
                                        if ("cknavbl".equals(str)) {
                                            this.q = z ? false : ((java.lang.Boolean) obj).booleanValue();
                                            return;
                                        }
                                        if ("gnktpfs".equals(str)) {
                                            this.r = z ? null : (java.lang.String) obj;
                                            return;
                                        }
                                        if ("gdtlnktpfs".equals(str)) {
                                            this.f71s = z ? null : (java.lang.String) obj;
                                            return;
                                        }
                                        if ("gdvk".equals(str)) {
                                            this.t = z ? null : (java.lang.String) obj;
                                            return;
                                        }
                                        if ("gdvkfc".equals(str)) {
                                            linkedList2 = this.u;
                                        } else {
                                            if ("gpnmmt".equals(str)) {
                                                this.v = z ? null : (java.lang.String) obj;
                                                return;
                                            }
                                            if (!"gpnmfp".equals(str)) {
                                                if ("gia".equals(str)) {
                                                    linkedList2 = this.x;
                                                } else if ("giafce".equals(str)) {
                                                    linkedList2 = this.y;
                                                } else {
                                                    if ("gsl".equals(str)) {
                                                        this.z = z ? null : (java.util.ArrayList) obj;
                                                        return;
                                                    }
                                                    if ("gavti".equals(str)) {
                                                        this.A = z ? null : (java.lang.String) obj;
                                                        return;
                                                    }
                                                    if (!"glctn".equals(str)) {
                                                        if ("gtecloc".equals(str)) {
                                                            if (z) {
                                                                obj = null;
                                                            }
                                                            this.C = obj;
                                                            return;
                                                        }
                                                        if ("gnbclin".equals(str)) {
                                                            this.D = z ? null : (java.util.ArrayList) obj;
                                                            return;
                                                        }
                                                        if ("gdvtp".equals(str)) {
                                                            this.E = z ? null : (java.lang.String) obj;
                                                            return;
                                                        }
                                                        if ("wmcwi".equals(str)) {
                                                            this.F = z ? null : (java.util.HashMap) obj;
                                                            return;
                                                        }
                                                        if ("ipgist".equals(str)) {
                                                            linkedList = this.G;
                                                            obj = java.lang.Boolean.valueOf(z ? false : ((java.lang.Boolean) obj).booleanValue());
                                                        } else {
                                                            if ("gcuin".equals(str)) {
                                                                this.H = z ? null : (java.util.HashMap) obj;
                                                                return;
                                                            }
                                                            if ("gtydvin".equals(str)) {
                                                                this.I = z ? null : (java.util.ArrayList) obj;
                                                                return;
                                                            }
                                                            if ("gqmkn".equals(str)) {
                                                                this.J = z ? null : (java.lang.String) obj;
                                                                return;
                                                            }
                                                            if ("gszin".equals(str)) {
                                                                this.K = z ? null : (java.util.HashMap) obj;
                                                                return;
                                                            }
                                                            if ("gmrin".equals(str)) {
                                                                this.L = z ? null : (java.util.HashMap) obj;
                                                                return;
                                                            }
                                                            if ("gmivsn".equals(str)) {
                                                                this.M = z ? null : (java.lang.String) obj;
                                                                return;
                                                            }
                                                            if ("cx".equals(str)) {
                                                                this.N = z ? false : ((java.lang.Boolean) obj).booleanValue();
                                                                return;
                                                            }
                                                            if ("ckpd".equals(str)) {
                                                                this.O = z ? false : ((java.lang.Boolean) obj).booleanValue();
                                                                return;
                                                            }
                                                            if ("ubenbl".equals(str)) {
                                                                this.P = z ? false : ((java.lang.Boolean) obj).booleanValue();
                                                                return;
                                                            }
                                                            if ("dvenbl".equals(str)) {
                                                                this.Q = z ? false : ((java.lang.Boolean) obj).booleanValue();
                                                                return;
                                                            }
                                                            if ("ckua".equals(str)) {
                                                                this.R = z ? false : ((java.lang.Boolean) obj).booleanValue();
                                                                return;
                                                            }
                                                            if ("vnmt".equals(str)) {
                                                                this.S = z ? false : ((java.lang.Boolean) obj).booleanValue();
                                                                return;
                                                            }
                                                            if ("degb".equals(str)) {
                                                                this.T = z ? false : ((java.lang.Boolean) obj).booleanValue();
                                                                return;
                                                            }
                                                            if ("iwpxy".equals(str)) {
                                                                this.U = z ? false : ((java.lang.Boolean) obj).booleanValue();
                                                                return;
                                                            }
                                                            if ("gflv".equals(str)) {
                                                                this.V = z ? null : (java.lang.String) obj;
                                                                return;
                                                            }
                                                            if ("gbsbd".equals(str)) {
                                                                this.W = z ? null : (java.lang.String) obj;
                                                                return;
                                                            }
                                                            if ("gbfspy".equals(str)) {
                                                                this.X = z ? null : (java.lang.String) obj;
                                                                return;
                                                            }
                                                            if ("gbplfo".equals(str)) {
                                                                this.Y = z ? null : (java.lang.String) obj;
                                                                return;
                                                            }
                                                            if ("gdntp".equals(str)) {
                                                                this.Z = z ? 0 : ((java.lang.Integer) obj).intValue();
                                                                return;
                                                            }
                                                            if ("qritsvc".equals(str)) {
                                                                linkedList2 = this.aa;
                                                                if (!z) {
                                                                    hashMap = (java.util.List) obj;
                                                                }
                                                            } else if ("rsaciy".equals(str)) {
                                                                linkedList2 = this.ab;
                                                                if (!z) {
                                                                    hashMap = (android.content.pm.ResolveInfo) obj;
                                                                }
                                                            } else if ("gpgif".equals(str)) {
                                                                linkedList2 = this.ac;
                                                            } else if ("gpgiffcin".equals(str)) {
                                                                linkedList2 = this.ad;
                                                            } else if ("gpgifstrg".equals(str)) {
                                                                linkedList2 = this.ae;
                                                            } else {
                                                                if ("giads".equals(str)) {
                                                                    this.af = z ? null : (java.lang.String) obj;
                                                                    return;
                                                                }
                                                                if ("gdvda".equals(str)) {
                                                                    this.ag = z ? null : (java.lang.String) obj;
                                                                    return;
                                                                }
                                                                if ("gdvdtnas".equals(str)) {
                                                                    this.ah = z ? null : (java.lang.String) obj;
                                                                    return;
                                                                }
                                                                if ("galtut".equals(str)) {
                                                                    this.ai = z ? 0L : ((java.lang.Long) obj).longValue();
                                                                    return;
                                                                }
                                                                if ("gdvme".equals(str)) {
                                                                    this.aj = z ? null : (java.lang.String) obj;
                                                                    return;
                                                                }
                                                                if ("gcrup".equals(str)) {
                                                                    this.ak = z ? null : (java.lang.String) obj;
                                                                    return;
                                                                }
                                                                if ("gcifm".equals(str)) {
                                                                    this.al = z ? null : (java.lang.String) obj;
                                                                    return;
                                                                }
                                                                if ("godm".equals(str)) {
                                                                    this.am = z ? null : (java.lang.String) obj;
                                                                    return;
                                                                }
                                                                if ("godhm".equals(str)) {
                                                                    this.an = z ? null : (java.lang.String) obj;
                                                                    return;
                                                                }
                                                                if ("galdm".equals(str)) {
                                                                    this.ao = z ? null : (java.util.HashMap) obj;
                                                                    return;
                                                                }
                                                                if ("gtaif".equals(str)) {
                                                                    this.ap = z ? null : (android.content.pm.ApplicationInfo) obj;
                                                                    return;
                                                                }
                                                                if ("gtaifprm".equals(str)) {
                                                                    linkedList2 = this.aq;
                                                                } else if ("gtaifprmfce".equals(str)) {
                                                                    linkedList2 = this.ar;
                                                                } else {
                                                                    if ("gtbdt".equals(str)) {
                                                                        this.as = z ? 0L : ((java.lang.Long) obj).longValue();
                                                                        return;
                                                                    }
                                                                    if ("gtscnin".equals(str)) {
                                                                        this.at = z ? 0.0d : ((java.lang.Double) obj).doubleValue();
                                                                        return;
                                                                    }
                                                                    if ("gtscnppi".equals(str)) {
                                                                        this.au = z ? 0 : ((java.lang.Integer) obj).intValue();
                                                                        return;
                                                                    }
                                                                    if ("ishmos".equals(str)) {
                                                                        this.av = z ? false : ((java.lang.Boolean) obj).booleanValue();
                                                                        return;
                                                                    }
                                                                    if ("gthmosv".equals(str)) {
                                                                        this.aw = z ? null : (java.lang.String) obj;
                                                                        return;
                                                                    }
                                                                    if ("gthmosdtlv".equals(str)) {
                                                                        this.ax = z ? null : (java.lang.String) obj;
                                                                        return;
                                                                    }
                                                                    if ("gthmpmst".equals(str)) {
                                                                        this.ay = z ? -1 : ((java.lang.Integer) obj).intValue();
                                                                        return;
                                                                    }
                                                                    if ("gthmepmst".equals(str)) {
                                                                        this.az = z ? -1 : ((java.lang.Integer) obj).intValue();
                                                                        return;
                                                                    }
                                                                    if ("gtinnerlangmt".equals(str)) {
                                                                        this.aA = z ? null : (java.lang.String) obj;
                                                                        return;
                                                                    }
                                                                    if ("gtgramgendt".equals(str)) {
                                                                        this.aB = z ? 0 : ((java.lang.Integer) obj).intValue();
                                                                        return;
                                                                    }
                                                                    if ("gtelcmefce".equals(str)) {
                                                                        linkedList = this.aC;
                                                                    } else {
                                                                        if ("gtmwfo".equals(str)) {
                                                                            this.aD = z ? null : (java.util.HashMap) obj;
                                                                            return;
                                                                        }
                                                                        if ("wmcwifce".equals(str)) {
                                                                            linkedList2 = this.aE;
                                                                            if (!z) {
                                                                                hashMap = (java.util.HashMap) obj;
                                                                            }
                                                                        } else {
                                                                            if ("gtaifok".equals(str)) {
                                                                                this.aF = z ? null : (java.util.ArrayList) obj;
                                                                                return;
                                                                            }
                                                                            if ("gtmcdi".equals(str)) {
                                                                                this.aG = z ? null : (java.lang.String) obj;
                                                                                return;
                                                                            }
                                                                            if ("gtmcdifce".equals(str)) {
                                                                                linkedList2 = this.aH;
                                                                            } else {
                                                                                if ("gtmbcdi".equals(str)) {
                                                                                    this.aI = z ? null : (java.lang.String) obj;
                                                                                    return;
                                                                                }
                                                                                if ("gtmbcdifce".equals(str)) {
                                                                                    linkedList2 = this.aJ;
                                                                                } else {
                                                                                    if ("miwpy".equals(str)) {
                                                                                        this.aK = z ? false : ((java.lang.Boolean) obj).booleanValue();
                                                                                        return;
                                                                                    }
                                                                                    if ("gtmnbclfo".equals(str)) {
                                                                                        this.aL = z ? null : (java.util.ArrayList) obj;
                                                                                        return;
                                                                                    }
                                                                                    if ("ctedebbing".equals(str)) {
                                                                                        if (!z && ((java.lang.Boolean) obj).booleanValue()) {
                                                                                            z2 = true;
                                                                                        }
                                                                                        this.aP = z2;
                                                                                        return;
                                                                                    }
                                                                                    if ("gtdm".equals(str)) {
                                                                                        this.aQ = z ? null : (java.lang.String) obj;
                                                                                        return;
                                                                                    }
                                                                                    if (!"gtlstactme".equals(str)) {
                                                                                        throw new java.lang.Throwable("Unknown name to set: " + str + ", value: " + obj);
                                                                                    }
                                                                                    linkedList = this.aR;
                                                                                    obj = java.lang.Long.valueOf(z ? -1L : ((java.lang.Long) obj).longValue());
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                        linkedList.add(obj);
                                                        return;
                                                    }
                                                    linkedList2 = this.B;
                                                    if (!z) {
                                                        hashMap = (android.location.Location) obj;
                                                    }
                                                }
                                                linkedList2.add(hashMap);
                                                return;
                                            }
                                            linkedList2 = this.w;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        public boolean a() {
            return this.a;
        }

        public java.lang.String b() {
            return null;
        }

        public java.lang.String b(int... iArr) {
            return (java.lang.String) a(this.p, cn.fly.verify.dn.a("004c8cb,cd"), iArr);
        }

        public java.lang.String c() {
            return this.g;
        }

        public java.lang.String c(int... iArr) {
            return (java.lang.String) a(this.u, (java.lang.Object) null, iArr);
        }

        public java.lang.String d() {
            return this.h;
        }

        public java.util.ArrayList<java.util.HashMap<java.lang.String, java.lang.String>> d(int... iArr) {
            return (java.util.ArrayList) a(this.y, new java.util.ArrayList(), iArr);
        }

        public java.lang.String e() {
            return null;
        }

        public boolean e(int... iArr) {
            return ((java.lang.Boolean) a(this.G, java.lang.Boolean.FALSE, iArr)).booleanValue();
        }

        public java.lang.String f() {
            return this.l;
        }

        public java.util.List<android.content.pm.ResolveInfo> f(int... iArr) {
            return (java.util.List) a(this.aa, (java.lang.Object) null, iArr);
        }

        public android.content.pm.PackageInfo g(int... iArr) {
            return (android.content.pm.PackageInfo) a(this.ac, (java.lang.Object) null, iArr);
        }

        public java.lang.String g() {
            return this.f71s;
        }

        public android.content.pm.ApplicationInfo h(int... iArr) {
            return (android.content.pm.ApplicationInfo) a(this.aq, (java.lang.Object) null, iArr);
        }

        public java.lang.String h() {
            return this.t;
        }

        public java.lang.Object i(int... iArr) {
            return a(this.aC, (java.lang.Object) null, iArr);
        }

        public java.lang.String i() {
            return this.v;
        }

        public java.lang.Object j(int... iArr) {
            return a(this.aM, (java.lang.Object) null, iArr);
        }

        public java.util.ArrayList<java.util.HashMap<java.lang.String, java.lang.String>> j() {
            return this.z;
        }

        public long k(int... iArr) {
            return ((java.lang.Long) a((java.util.LinkedList<long>) this.aR, -1L, iArr)).longValue();
        }

        public java.lang.String k() {
            return this.A;
        }

        public java.lang.String l() {
            return null;
        }

        public java.lang.String m() {
            return this.E;
        }

        public java.util.HashMap<java.lang.String, java.util.HashMap<java.lang.String, java.lang.Long>> n() {
            return this.K;
        }

        public java.util.HashMap<java.lang.String, java.lang.Long> o() {
            return this.L;
        }

        public java.lang.String p() {
            return this.M;
        }

        public boolean q() {
            return this.N;
        }

        public boolean r() {
            return this.O;
        }

        public boolean s() {
            return this.P;
        }

        public boolean t() {
            return this.R;
        }

        public boolean u() {
            return this.S;
        }

        public boolean v() {
            return this.T;
        }

        public int w() {
            return this.Z;
        }

        public java.lang.String x() {
            return this.af;
        }

        public java.lang.String y() {
            return this.aj;
        }

        public java.lang.String z() {
            return this.am;
        }
    }

    public static class c {
        private final android.content.Context a;
        private final java.util.LinkedList<cn.fly.verify.fh.c.a> b;

        /* renamed from: cn.fly.verify.fh$c$1, reason: invalid class name */
        public class AnonymousClass1 implements java.lang.Runnable {
            final /* synthetic */ java.lang.Boolean a;
            final /* synthetic */ java.lang.Boolean b;
            final /* synthetic */ cn.fly.verify.fh.a c;
            final /* synthetic */ boolean d;

            /* renamed from: cn.fly.verify.fh$c$1$1, reason: invalid class name and collision with other inner class name */
            public class C00101 implements android.os.Handler.Callback {
                final /* synthetic */ cn.fly.verify.fh.b a;

                public C00101(cn.fly.verify.fh.b bVar) {
                    this.a = bVar;
                }

                @Override // android.os.Handler.Callback
                public boolean handleMessage(android.os.Message message) {
                    try {
                        cn.fly.verify.fh.c.AnonymousClass1.this.c.a(this.a);
                    } catch (java.lang.Throwable th) {
                        cn.fly.verify.ed.a().a(th, "Error from caller", new java.lang.Object[0]);
                    }
                    return false;
                }
            }

            public AnonymousClass1(java.lang.Boolean bool, java.lang.Boolean bool2, cn.fly.verify.fh.a aVar, boolean z) {
                this.a = bool;
                this.b = bool2;
                this.c = aVar;
                this.d = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    cn.fly.verify.er.a.set(java.lang.Boolean.TRUE);
                    cn.fly.verify.er.b.set(this.a);
                    cn.fly.verify.er.c.set(this.b);
                    cn.fly.verify.fh.b G = cn.fly.verify.fh.c.this.G();
                    cn.fly.verify.fh.a aVar = this.c;
                    if (aVar != null) {
                        if (this.d) {
                            cn.fly.verify.ft.a(0, new cn.fly.verify.fh.c.AnonymousClass1.C00101(G));
                        } else {
                            try {
                                aVar.a(G);
                            } catch (java.lang.Throwable th) {
                                cn.fly.verify.ed.a().a(th, "Error from caller", new java.lang.Object[0]);
                            }
                        }
                    }
                    java.lang.ThreadLocal<java.lang.Boolean> threadLocal = cn.fly.verify.er.a;
                    java.lang.Boolean bool = java.lang.Boolean.FALSE;
                    threadLocal.set(bool);
                    cn.fly.verify.er.b.set(bool);
                    cn.fly.verify.er.c.set(bool);
                } catch (java.lang.Throwable th2) {
                    cn.fly.verify.ed.a().a(th2);
                    cn.fly.verify.fh.c.this.b(this.c);
                }
            }
        }

        public static class a {
            public final java.lang.String a;
            public final java.lang.Object[] b;

            private a(java.lang.String str, java.lang.Object... objArr) {
                this.a = str;
                this.b = objArr;
            }

            public /* synthetic */ a(java.lang.String str, java.lang.Object[] objArr, cn.fly.verify.fh.AnonymousClass1 anonymousClass1) {
                this(str, objArr);
            }
        }

        private c(android.content.Context context) {
            this.b = new java.util.LinkedList<>();
            this.a = context;
        }

        public /* synthetic */ c(android.content.Context context, cn.fly.verify.fh.AnonymousClass1 anonymousClass1) {
            this(context);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public cn.fly.verify.fh.b G() {
            cn.fly.verify.fh.b bVar = new cn.fly.verify.fh.b();
            for (int i = 0; i < this.b.size(); i++) {
                cn.fly.verify.fh.c.a aVar = this.b.get(i);
                try {
                    java.lang.String str = aVar.a;
                    bVar.a(str, a(str, aVar.b));
                } catch (java.lang.Throwable th) {
                    try {
                        cn.fly.verify.ed.a().a(th);
                        bVar.a(aVar.a, (java.lang.Object) null, true);
                    } catch (java.lang.Throwable th2) {
                        cn.fly.verify.ed.a().a(th2);
                    }
                }
            }
            return bVar;
        }

        private java.lang.Object a(java.lang.String str, java.lang.Object[] objArr) throws java.lang.Throwable {
            if ("gmpfo".equals(str)) {
                if (objArr != null && objArr.length == 2) {
                    return cn.fly.verify.eh.a(this.a).d().b(false, 0, (java.lang.String) objArr[0], ((java.lang.Integer) objArr[1]).intValue());
                }
                throw new java.lang.Throwable("params illegal: " + objArr);
            }
            if ("gmpfofce".equals(str)) {
                if (objArr == null || objArr.length != 3) {
                    throw new java.lang.Throwable("params illegal: " + objArr);
                }
                return cn.fly.verify.eh.a(this.a).d().b(((java.lang.Boolean) objArr[0]).booleanValue(), 0, (java.lang.String) objArr[1], ((java.lang.Integer) objArr[2]).intValue());
            }
            if ("getMpfos".equals(str)) {
                if (objArr == null || objArr.length != 3) {
                    throw new java.lang.Throwable("params illegal: " + objArr);
                }
                return cn.fly.verify.eh.a(this.a).d().b(false, ((java.lang.Integer) objArr[0]).intValue(), (java.lang.String) objArr[1], ((java.lang.Integer) objArr[2]).intValue());
            }
            if ("cird".equals(str)) {
                return java.lang.Boolean.valueOf(cn.fly.verify.eh.a(this.a).d().a());
            }
            if ("gsimt".equals(str)) {
                return cn.fly.verify.eh.a(this.a).d().a(false);
            }
            if ("gsimtfce".equals(str)) {
                if (objArr != null && objArr.length == 1) {
                    return cn.fly.verify.eh.a(this.a).d().a(((java.lang.Boolean) objArr[0]).booleanValue());
                }
                throw new java.lang.Throwable("params illegal: " + objArr);
            }
            if ("gbsi".equals(str)) {
                return cn.fly.verify.eh.a(this.a).d().b(false);
            }
            if ("gbsifce".equals(str)) {
                if (objArr != null && objArr.length == 1) {
                    return cn.fly.verify.eh.a(this.a).d().b(((java.lang.Boolean) objArr[0]).booleanValue());
                }
                throw new java.lang.Throwable("params illegal: " + objArr);
            }
            if ("gstmpts".equals(str)) {
                if (objArr != null && objArr.length == 1) {
                    return cn.fly.verify.eh.a(this.a).d().a((java.lang.String) objArr[0]);
                }
                throw new java.lang.Throwable("params illegal: " + objArr);
            }
            if ("gscsz".equals(str)) {
                return cn.fly.verify.eh.a(this.a).d().C();
            }
            if ("gcrie".equals(str)) {
                return cn.fly.verify.eh.a(this.a).d().c(false);
            }
            if ("gcriefce".equals(str)) {
                if (objArr != null && objArr.length == 1) {
                    return cn.fly.verify.eh.a(this.a).d().c(((java.lang.Boolean) objArr[0]).booleanValue());
                }
                throw new java.lang.Throwable("params illegal: " + objArr);
            }
            if ("gcrnm".equals(str)) {
                return cn.fly.verify.eh.a(this.a).d().d(false);
            }
            if ("gcrnmfce".equals(str)) {
                if (objArr != null && objArr.length == 1) {
                    return cn.fly.verify.eh.a(this.a).d().d(((java.lang.Boolean) objArr[0]).booleanValue());
                }
                throw new java.lang.Throwable("params illegal: " + objArr);
            }
            if ("gsnmd".equals(str)) {
                return cn.fly.verify.eh.a(this.a).d().S();
            }
            if ("gsnmdfp".equals(str)) {
                if (objArr != null && objArr.length == 1) {
                    return cn.fly.verify.eh.a(this.a).d().c((java.lang.String) objArr[0]);
                }
                throw new java.lang.Throwable("params illegal: " + objArr);
            }
            if ("gneyp".equals(str)) {
                return cn.fly.verify.eh.a(this.a).d().f(false);
            }
            if ("gneypnw".equals(str)) {
                return cn.fly.verify.eh.a(this.a).d().D();
            }
            if ("gneypfce".equals(str)) {
                if (objArr != null && objArr.length == 1) {
                    return cn.fly.verify.eh.a(this.a).d().f(((java.lang.Boolean) objArr[0]).booleanValue());
                }
                throw new java.lang.Throwable("params illegal: " + objArr);
            }
            if ("cknavbl".equals(str)) {
                return java.lang.Boolean.valueOf(cn.fly.verify.eh.a(this.a).d().G());
            }
            if ("gnktpfs".equals(str)) {
                return cn.fly.verify.eh.a(this.a).d().E();
            }
            if ("gdtlnktpfs".equals(str)) {
                return cn.fly.verify.eh.a(this.a).d().F();
            }
            if ("gdvk".equals(str)) {
                return cn.fly.verify.eh.a(this.a).d().Q();
            }
            if ("gdvkfc".equals(str)) {
                if (objArr != null && objArr.length == 1) {
                    return cn.fly.verify.eh.a(this.a).d().g(((java.lang.Boolean) objArr[0]).booleanValue());
                }
                throw new java.lang.Throwable("params illegal: " + objArr);
            }
            if ("gpnmmt".equals(str)) {
                return cn.fly.verify.eh.a(this.a).d().U();
            }
            if ("gpnmfp".equals(str)) {
                if (objArr != null && objArr.length == 1) {
                    return cn.fly.verify.eh.a(this.a).d().d((java.lang.String) objArr[0]);
                }
                throw new java.lang.Throwable("params illegal: " + objArr);
            }
            if ("gia".equals(str)) {
                if (objArr != null && objArr.length == 1) {
                    return cn.fly.verify.eh.a(this.a).d().a(((java.lang.Boolean) objArr[0]).booleanValue(), false);
                }
                throw new java.lang.Throwable("params illegal: " + objArr);
            }
            if ("giafce".equals(str)) {
                if (objArr != null && objArr.length == 2) {
                    return cn.fly.verify.eh.a(this.a).d().a(((java.lang.Boolean) objArr[0]).booleanValue(), ((java.lang.Boolean) objArr[1]).booleanValue());
                }
                throw new java.lang.Throwable("params illegal: " + objArr);
            }
            if ("gsl".equals(str)) {
                return cn.fly.verify.eh.a(this.a).d().P();
            }
            if ("gscpt".equals(str)) {
                return cn.fly.verify.eh.a(this.a).d().R();
            }
            if ("gavti".equals(str)) {
                return cn.fly.verify.eh.a(this.a).d().j();
            }
            if ("glctn".equals(str)) {
                if (objArr == null || objArr.length != 3) {
                    throw new java.lang.Throwable("params illegal: " + objArr);
                }
                return cn.fly.verify.eh.a(this.a).d().a(((java.lang.Integer) objArr[0]).intValue(), ((java.lang.Integer) objArr[1]).intValue(), ((java.lang.Boolean) objArr[2]).booleanValue());
            }
            if ("gtecloc".equals(str)) {
                return cn.fly.verify.eh.a(this.a).d().p();
            }
            if ("gnbclin".equals(str)) {
                return cn.fly.verify.eh.a(this.a).d().q();
            }
            if ("gdvtp".equals(str)) {
                return cn.fly.verify.eh.a(this.a).d().o();
            }
            if ("wmcwi".equals(str)) {
                return cn.fly.verify.eh.a(this.a).d().r();
            }
            if ("ipgist".equals(str)) {
                if (objArr != null && objArr.length == 1) {
                    return java.lang.Boolean.valueOf(cn.fly.verify.eh.a(this.a).d().b((java.lang.String) objArr[0]));
                }
                throw new java.lang.Throwable("params illegal: " + objArr);
            }
            if ("gcuin".equals(str)) {
                return cn.fly.verify.eh.a(this.a).d().w();
            }
            if ("gtydvin".equals(str)) {
                return cn.fly.verify.eh.a(this.a).d().x();
            }
            if ("gqmkn".equals(str)) {
                return cn.fly.verify.eh.a(this.a).d().y();
            }
            if ("gszin".equals(str)) {
                return cn.fly.verify.eh.a(this.a).d().z();
            }
            if ("gmrin".equals(str)) {
                return cn.fly.verify.eh.a(this.a).d().A();
            }
            if ("gmivsn".equals(str)) {
                return cn.fly.verify.eh.a(this.a).d().k();
            }
            if ("cx".equals(str)) {
                return java.lang.Boolean.valueOf(cn.fly.verify.eh.a(this.a).d().b());
            }
            if ("ckpd".equals(str)) {
                return java.lang.Boolean.valueOf(cn.fly.verify.eh.a(this.a).d().c());
            }
            if ("ubenbl".equals(str)) {
                return java.lang.Boolean.valueOf(cn.fly.verify.eh.a(this.a).d().h());
            }
            if ("dvenbl".equals(str)) {
                return java.lang.Boolean.valueOf(cn.fly.verify.eh.a(this.a).d().g());
            }
            if ("ckua".equals(str)) {
                return java.lang.Boolean.valueOf(cn.fly.verify.eh.a(this.a).d().f());
            }
            if ("vnmt".equals(str)) {
                return java.lang.Boolean.valueOf(cn.fly.verify.eh.a(this.a).d().e());
            }
            if ("degb".equals(str)) {
                return java.lang.Boolean.valueOf(cn.fly.verify.eh.a(this.a).d().d());
            }
            if ("iwpxy".equals(str)) {
                return java.lang.Boolean.valueOf(cn.fly.verify.eh.a(this.a).d().i());
            }
            if ("gflv".equals(str)) {
                return cn.fly.verify.eh.a(this.a).d().J();
            }
            if ("gbsbd".equals(str)) {
                return cn.fly.verify.eh.a(this.a).d().K();
            }
            if ("gbfspy".equals(str)) {
                return cn.fly.verify.eh.a(this.a).d().L();
            }
            if ("gbplfo".equals(str)) {
                return cn.fly.verify.eh.a(this.a).d().M();
            }
            if ("gdntp".equals(str)) {
                return java.lang.Integer.valueOf(cn.fly.verify.eh.a(this.a).d().H());
            }
            if ("qritsvc".equals(str)) {
                if (objArr != null && objArr.length == 2) {
                    return cn.fly.verify.eh.a(this.a).d().a((android.content.Intent) objArr[0], ((java.lang.Integer) objArr[1]).intValue());
                }
                throw new java.lang.Throwable("params illegal: " + objArr);
            }
            if ("rsaciy".equals(str)) {
                if (objArr != null && objArr.length == 2) {
                    return cn.fly.verify.eh.a(this.a).d().b((android.content.Intent) objArr[0], ((java.lang.Integer) objArr[1]).intValue());
                }
                throw new java.lang.Throwable("params illegal: " + objArr);
            }
            if ("gpgif".equals(str)) {
                if (objArr != null && objArr.length == 2) {
                    return cn.fly.verify.eh.a(this.a).d().a(false, 0, (java.lang.String) objArr[0], ((java.lang.Integer) objArr[1]).intValue());
                }
                throw new java.lang.Throwable("params illegal: " + objArr);
            }
            if ("gpgiffcin".equals(str)) {
                if (objArr == null || objArr.length != 3) {
                    throw new java.lang.Throwable("params illegal: " + objArr);
                }
                return cn.fly.verify.eh.a(this.a).d().a(((java.lang.Boolean) objArr[0]).booleanValue(), 0, (java.lang.String) objArr[1], ((java.lang.Integer) objArr[2]).intValue());
            }
            if ("gpgifstrg".equals(str)) {
                if (objArr == null || objArr.length != 3) {
                    throw new java.lang.Throwable("params illegal: " + objArr);
                }
                return cn.fly.verify.eh.a(this.a).d().a(false, ((java.lang.Integer) objArr[0]).intValue(), (java.lang.String) objArr[1], ((java.lang.Integer) objArr[2]).intValue());
            }
            if ("giads".equals(str)) {
                return cn.fly.verify.eh.a(this.a).d().N();
            }
            if ("gdvda".equals(str)) {
                return cn.fly.verify.eh.a(this.a).d().ab();
            }
            if ("gdvdtnas".equals(str)) {
                return cn.fly.verify.eh.a(this.a).d().ac();
            }
            if ("galtut".equals(str)) {
                return java.lang.Long.valueOf(cn.fly.verify.eh.a(this.a).d().ad());
            }
            if ("gdvme".equals(str)) {
                return cn.fly.verify.eh.a(this.a).d().ae();
            }
            if ("gcrup".equals(str)) {
                return cn.fly.verify.eh.a(this.a).d().af();
            }
            if ("gcifm".equals(str)) {
                return cn.fly.verify.eh.a(this.a).d().ag();
            }
            if ("godm".equals(str)) {
                return cn.fly.verify.eh.a(this.a).d().ah();
            }
            if ("godhm".equals(str)) {
                return cn.fly.verify.eh.a(this.a).d().ai();
            }
            if ("galdm".equals(str)) {
                return cn.fly.verify.eh.a(this.a).d().aj();
            }
            if ("gtaif".equals(str)) {
                return cn.fly.verify.eh.a(this.a).d().ak();
            }
            if ("gtaifprm".equals(str)) {
                if (objArr != null && objArr.length == 2) {
                    return cn.fly.verify.eh.a(this.a).d().a((java.lang.String) objArr[0], ((java.lang.Integer) objArr[1]).intValue());
                }
                throw new java.lang.Throwable("params illegal: " + objArr);
            }
            if ("gtaifprmfce".equals(str)) {
                if (objArr == null || objArr.length != 3) {
                    throw new java.lang.Throwable("params illegal: " + objArr);
                }
                return cn.fly.verify.eh.a(this.a).d().a(((java.lang.Boolean) objArr[0]).booleanValue(), (java.lang.String) objArr[1], ((java.lang.Integer) objArr[2]).intValue());
            }
            if ("gtbdt".equals(str)) {
                return java.lang.Long.valueOf(cn.fly.verify.eh.a(this.a).d().am());
            }
            if ("gtscnin".equals(str)) {
                return java.lang.Double.valueOf(cn.fly.verify.eh.a(this.a).d().an());
            }
            if ("gtscnppi".equals(str)) {
                return java.lang.Integer.valueOf(cn.fly.verify.eh.a(this.a).d().ao());
            }
            if ("ishmos".equals(str)) {
                return java.lang.Boolean.valueOf(cn.fly.verify.eh.a(this.a).d().ap());
            }
            if ("gthmosv".equals(str)) {
                return cn.fly.verify.eh.a(this.a).d().aq();
            }
            if ("gthmosdtlv".equals(str)) {
                return cn.fly.verify.eh.a(this.a).d().ar();
            }
            if ("gthmpmst".equals(str)) {
                return java.lang.Integer.valueOf(cn.fly.verify.eh.a(this.a).d().as());
            }
            if ("gthmepmst".equals(str)) {
                return java.lang.Integer.valueOf(cn.fly.verify.eh.a(this.a).d().at());
            }
            if ("gtinnerlangmt".equals(str)) {
                return cn.fly.verify.eh.a(this.a).d().au();
            }
            if ("gtgramgendt".equals(str)) {
                return java.lang.Integer.valueOf(cn.fly.verify.eh.a(this.a).d().av());
            }
            if ("gtelcmefce".equals(str)) {
                return cn.fly.verify.eh.a(this.a).d().a(((java.lang.Integer) objArr[0]).intValue(), ((java.lang.Integer) objArr[1]).intValue(), ((java.lang.Boolean) objArr[2]).booleanValue(), ((java.lang.Boolean) objArr[3]).booleanValue());
            }
            if ("gtmwfo".equals(str)) {
                return cn.fly.verify.eh.a(this.a).d().e(false);
            }
            if ("wmcwifce".equals(str)) {
                if (objArr != null && objArr.length == 1) {
                    return cn.fly.verify.eh.a(this.a).d().e(((java.lang.Boolean) objArr[0]).booleanValue());
                }
                throw new java.lang.Throwable("params illegal: " + objArr);
            }
            if ("gtaifok".equals(str)) {
                return cn.fly.verify.eh.a(this.a).d().al();
            }
            if ("gtmcdi".equals(str)) {
                return cn.fly.verify.eh.a(this.a).d().a(false);
            }
            if ("gtmcdifce".equals(str)) {
                if (objArr != null && objArr.length == 1) {
                    return cn.fly.verify.eh.a(this.a).d().a(((java.lang.Boolean) objArr[0]).booleanValue());
                }
                throw new java.lang.Throwable("params illegal: " + objArr);
            }
            if ("gtmbcdi".equals(str)) {
                return cn.fly.verify.eh.a(this.a).d().b(false);
            }
            if ("gtmbcdifce".equals(str)) {
                if (objArr != null && objArr.length == 1) {
                    return cn.fly.verify.eh.a(this.a).d().b(((java.lang.Boolean) objArr[0]).booleanValue());
                }
                throw new java.lang.Throwable("params illegal: " + objArr);
            }
            if ("miwpy".equals(str)) {
                return java.lang.Boolean.valueOf(cn.fly.verify.eh.a(this.a).d().i());
            }
            if ("gtmnbclfo".equals(str)) {
                return cn.fly.verify.eh.a(this.a).d().q();
            }
            if ("ctedebbing".equals(str)) {
                return java.lang.Boolean.valueOf(cn.fly.verify.eh.a(this.a).d().aw());
            }
            if ("gtdm".equals(str)) {
                if (objArr != null && objArr.length == 1) {
                    return cn.fly.verify.eh.a(this.a).d().h(((java.lang.Boolean) objArr[0]).booleanValue());
                }
                throw new java.lang.Throwable("params illegal: " + objArr);
            }
            if (!"gtlstactme".equals(str)) {
                return null;
            }
            if (objArr != null && objArr.length == 1) {
                return java.lang.Long.valueOf(cn.fly.verify.eh.a(this.a).d().f((java.lang.String) objArr[0]));
            }
            throw new java.lang.Throwable("params illegal: " + objArr);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(cn.fly.verify.fh.a aVar) {
            if (aVar != null) {
                try {
                    aVar.a(new cn.fly.verify.fh.b());
                } catch (java.lang.Throwable th) {
                    cn.fly.verify.ed.a().a(th, "Error from caller", new java.lang.Object[0]);
                }
            }
        }

        public cn.fly.verify.fh.c A() {
            this.b.add(new cn.fly.verify.fh.c.a("godm", new java.lang.Object[0], null));
            return this;
        }

        public cn.fly.verify.fh.c B() {
            this.b.add(new cn.fly.verify.fh.c.a("godhm", new java.lang.Object[0], null));
            return this;
        }

        public cn.fly.verify.fh.c C() {
            this.b.add(new cn.fly.verify.fh.c.a("gtinnerlangmt", new java.lang.Object[0], null));
            return this;
        }

        public cn.fly.verify.fh.c D() {
            this.b.add(new cn.fly.verify.fh.c.a("gtgramgendt", new java.lang.Object[0], null));
            return this;
        }

        public cn.fly.verify.fh.c E() {
            this.b.add(new cn.fly.verify.fh.c.a("miwpy", new java.lang.Object[0], null));
            return this;
        }

        public cn.fly.verify.fh.c F() {
            this.b.add(new cn.fly.verify.fh.c.a("ctedebbing", new java.lang.Object[0], null));
            return this;
        }

        public cn.fly.verify.fh.c a() {
            this.b.add(new cn.fly.verify.fh.c.a("cird", new java.lang.Object[0], null));
            return this;
        }

        public cn.fly.verify.fh.c a(int i, int i2, boolean z, boolean z2) {
            this.b.add(new cn.fly.verify.fh.c.a("gtelcmefce", new java.lang.Object[]{java.lang.Integer.valueOf(i), java.lang.Integer.valueOf(i2), java.lang.Boolean.valueOf(z), java.lang.Boolean.valueOf(z2)}, null));
            return this;
        }

        public cn.fly.verify.fh.c a(android.content.Intent intent, int i) {
            this.b.add(new cn.fly.verify.fh.c.a("qritsvc", new java.lang.Object[]{intent, java.lang.Integer.valueOf(i)}, null));
            return this;
        }

        public cn.fly.verify.fh.c a(java.lang.String str) {
            this.b.add(new cn.fly.verify.fh.c.a("ipgist", new java.lang.Object[]{str}, null));
            return this;
        }

        public cn.fly.verify.fh.c a(java.lang.String str, int i) {
            this.b.add(new cn.fly.verify.fh.c.a("gpgif", new java.lang.Object[]{str, java.lang.Integer.valueOf(i)}, null));
            return this;
        }

        public cn.fly.verify.fh.c a(boolean z) {
            this.b.add(new cn.fly.verify.fh.c.a("gcriefce", new java.lang.Object[]{java.lang.Boolean.valueOf(z)}, null));
            return this;
        }

        public cn.fly.verify.fh.c a(boolean z, boolean z2) {
            this.b.add(new cn.fly.verify.fh.c.a("giafce", new java.lang.Object[]{java.lang.Boolean.valueOf(z), java.lang.Boolean.valueOf(z2)}, null));
            return this;
        }

        public void a(cn.fly.verify.fh.a aVar) {
            try {
                boolean z = android.os.Looper.getMainLooper() == android.os.Looper.myLooper();
                cn.fly.verify.fh.c.AnonymousClass1 anonymousClass1 = new cn.fly.verify.fh.c.AnonymousClass1(cn.fly.verify.er.b.get(), cn.fly.verify.er.c.get(), aVar, z);
                if (z) {
                    cn.fly.verify.ea.g.execute(anonymousClass1);
                } else {
                    anonymousClass1.run();
                }
            } catch (java.lang.Throwable th) {
                cn.fly.verify.ed.a().a(th);
                if (aVar != null) {
                    b(aVar);
                }
            }
        }

        public cn.fly.verify.fh.c b() {
            return this;
        }

        public cn.fly.verify.fh.c b(java.lang.String str) {
            this.b.add(new cn.fly.verify.fh.c.a("gtlstactme", new java.lang.Object[]{str}, null));
            return this;
        }

        public cn.fly.verify.fh.c b(java.lang.String str, int i) {
            this.b.add(new cn.fly.verify.fh.c.a("gtaifprm", new java.lang.Object[]{str, java.lang.Integer.valueOf(i)}, null));
            return this;
        }

        public cn.fly.verify.fh.c b(boolean z) {
            this.b.add(new cn.fly.verify.fh.c.a("gneypfce", new java.lang.Object[]{java.lang.Boolean.valueOf(z)}, null));
            return this;
        }

        public cn.fly.verify.fh.c c() {
            this.b.add(new cn.fly.verify.fh.c.a("gscsz", new java.lang.Object[0], null));
            return this;
        }

        public cn.fly.verify.fh.c c(java.lang.String str, int i) {
            this.b.add(new cn.fly.verify.fh.c.a("gmpfo", new java.lang.Object[]{str, java.lang.Integer.valueOf(i)}, null));
            return this;
        }

        public cn.fly.verify.fh.c c(boolean z) {
            this.b.add(new cn.fly.verify.fh.c.a("gdvkfc", new java.lang.Object[]{java.lang.Boolean.valueOf(z)}, null));
            return this;
        }

        public cn.fly.verify.fh.c d() {
            this.b.add(new cn.fly.verify.fh.c.a("gcrie", new java.lang.Object[0], null));
            return this;
        }

        public cn.fly.verify.fh.c d(boolean z) {
            this.b.add(new cn.fly.verify.fh.c.a("gtdm", new java.lang.Object[]{java.lang.Boolean.valueOf(z)}, null));
            return this;
        }

        public cn.fly.verify.fh.c e() {
            return this;
        }

        public cn.fly.verify.fh.c f() {
            this.b.add(new cn.fly.verify.fh.c.a("gsnmd", new java.lang.Object[0], null));
            return this;
        }

        public cn.fly.verify.fh.c g() {
            this.b.add(new cn.fly.verify.fh.c.a("gdtlnktpfs", new java.lang.Object[0], null));
            return this;
        }

        public cn.fly.verify.fh.c h() {
            this.b.add(new cn.fly.verify.fh.c.a("gdvk", new java.lang.Object[0], null));
            return this;
        }

        public cn.fly.verify.fh.c i() {
            this.b.add(new cn.fly.verify.fh.c.a("gpnmmt", new java.lang.Object[0], null));
            return this;
        }

        public cn.fly.verify.fh.c j() {
            this.b.add(new cn.fly.verify.fh.c.a("gsl", new java.lang.Object[0], null));
            return this;
        }

        public cn.fly.verify.fh.c k() {
            this.b.add(new cn.fly.verify.fh.c.a("gavti", new java.lang.Object[0], null));
            return this;
        }

        public cn.fly.verify.fh.c l() {
            return this;
        }

        public cn.fly.verify.fh.c m() {
            this.b.add(new cn.fly.verify.fh.c.a("gdvtp", new java.lang.Object[0], null));
            return this;
        }

        public cn.fly.verify.fh.c n() {
            this.b.add(new cn.fly.verify.fh.c.a("gszin", new java.lang.Object[0], null));
            return this;
        }

        public cn.fly.verify.fh.c o() {
            this.b.add(new cn.fly.verify.fh.c.a("gmrin", new java.lang.Object[0], null));
            return this;
        }

        public cn.fly.verify.fh.c p() {
            this.b.add(new cn.fly.verify.fh.c.a("gmivsn", new java.lang.Object[0], null));
            return this;
        }

        public cn.fly.verify.fh.c q() {
            this.b.add(new cn.fly.verify.fh.c.a("cx", new java.lang.Object[0], null));
            return this;
        }

        public cn.fly.verify.fh.c r() {
            this.b.add(new cn.fly.verify.fh.c.a("ckpd", new java.lang.Object[0], null));
            return this;
        }

        public cn.fly.verify.fh.c s() {
            this.b.add(new cn.fly.verify.fh.c.a("ubenbl", new java.lang.Object[0], null));
            return this;
        }

        public cn.fly.verify.fh.c t() {
            this.b.add(new cn.fly.verify.fh.c.a("ckua", new java.lang.Object[0], null));
            return this;
        }

        public cn.fly.verify.fh.c u() {
            this.b.add(new cn.fly.verify.fh.c.a("vnmt", new java.lang.Object[0], null));
            return this;
        }

        public cn.fly.verify.fh.c v() {
            this.b.add(new cn.fly.verify.fh.c.a("degb", new java.lang.Object[0], null));
            return this;
        }

        public cn.fly.verify.fh.c w() {
            this.b.add(new cn.fly.verify.fh.c.a("gdntp", new java.lang.Object[0], null));
            return this;
        }

        public cn.fly.verify.fh.c x() {
            this.b.add(new cn.fly.verify.fh.c.a("giads", new java.lang.Object[0], null));
            return this;
        }

        public cn.fly.verify.fh.c y() {
            this.b.add(new cn.fly.verify.fh.c.a("galtut", new java.lang.Object[0], null));
            return this;
        }

        public cn.fly.verify.fh.c z() {
            this.b.add(new cn.fly.verify.fh.c.a("gdvme", new java.lang.Object[0], null));
            return this;
        }
    }

    public static final class d {
        public static <T> T a(java.lang.Object obj, java.lang.String str, java.lang.Object... objArr) {
            return (T) cn.fly.verify.fp.a(obj, str, (java.lang.Object) null, objArr);
        }

        public static <T> T a(java.lang.Object obj, java.lang.String str, java.lang.Object[] objArr, java.lang.Class<?>[] clsArr) {
            try {
                return (T) cn.fly.verify.fp.a(obj, str, objArr, clsArr);
            } catch (java.lang.Throwable th) {
                if (!(th instanceof java.lang.reflect.InvocationTargetException)) {
                    if (!(th instanceof android.content.pm.PackageManager.NameNotFoundException)) {
                        cn.fly.verify.ed.a().a(th);
                        return null;
                    }
                    cn.fly.verify.ed.a().a("Exception: " + th.getClass().getName() + ": " + th.getMessage(), new java.lang.Object[0]);
                    return null;
                }
                java.lang.String name = th.getClass().getName();
                java.lang.String message = th.getMessage();
                java.lang.Throwable cause = th.getCause();
                if (cause != null) {
                    name = cause.getClass().getName();
                    message = cause.getMessage();
                }
                cn.fly.verify.ed.a().a("Exception: " + name + ": " + message, new java.lang.Object[0]);
                return null;
            }
        }

        public static java.lang.Object a(java.lang.String str) {
            return cn.fly.verify.dw.d(str);
        }

        public static java.lang.String a() {
            return cn.fly.verify.eh.a(cn.fly.verify.ax.g()).d().R();
        }

        public static boolean b() {
            return cn.fly.verify.eh.a(cn.fly.verify.ax.g()).d().X();
        }

        public static boolean b(java.lang.String str) {
            return cn.fly.verify.eh.a(cn.fly.verify.ax.g()).d().e(str);
        }

        public static java.lang.String c() {
            return cn.fly.verify.eh.a(cn.fly.verify.ax.g()).d().T();
        }

        public static java.lang.String c(java.lang.String str) {
            return cn.fly.verify.eh.a(cn.fly.verify.ax.g()).d().a(str);
        }

        public static java.lang.String d() {
            return cn.fly.verify.eh.a(cn.fly.verify.ax.g()).d().Y();
        }

        public static int e() {
            return 1;
        }

        public static java.lang.String f() {
            return cn.fly.verify.eh.a(cn.fly.verify.ax.g()).d().W();
        }

        public static int g() {
            return cn.fly.verify.eh.a(cn.fly.verify.ax.g()).d().s();
        }

        public static java.lang.String h() {
            return cn.fly.verify.eh.a(cn.fly.verify.ax.g()).d().t();
        }

        public static java.lang.String i() {
            return cn.fly.verify.eh.a(cn.fly.verify.ax.g()).d().I();
        }

        public static java.lang.String j() {
            return cn.fly.verify.eh.a(cn.fly.verify.ax.g()).d().l();
        }

        public static java.lang.String k() {
            return cn.fly.verify.eh.a(cn.fly.verify.ax.g()).d().m();
        }

        public static java.lang.String l() {
            return cn.fly.verify.eh.a(cn.fly.verify.ax.g()).d().n();
        }

        public static int m() {
            return cn.fly.verify.eh.a(cn.fly.verify.ax.g()).d().V();
        }
    }

    public static cn.fly.verify.fh.c a(android.content.Context context) {
        return new cn.fly.verify.fh.c(context, null);
    }
}
