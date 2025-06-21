package kotlin.ranges;

/* JADX INFO: Access modifiers changed from: package-private */
@kotlin.Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\n\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u001e\n\u0002\u0010\u000f\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\f\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0007\u001a\f\u0010\u0002\u001a\u00020\u0004*\u00020\u0003H\u0007\u001a\f\u0010\u0002\u001a\u00020\u0006*\u00020\u0005H\u0007\u001a\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u0007¢\u0006\u0004\b\u0007\u0010\b\u001a\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0004*\u00020\u0003H\u0007¢\u0006\u0004\b\u0007\u0010\t\u001a\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0006*\u00020\u0005H\u0007¢\u0006\u0004\b\u0007\u0010\n\u001a\f\u0010\u000b\u001a\u00020\u0001*\u00020\u0000H\u0007\u001a\f\u0010\u000b\u001a\u00020\u0004*\u00020\u0003H\u0007\u001a\f\u0010\u000b\u001a\u00020\u0006*\u00020\u0005H\u0007\u001a\u0015\u0010\f\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u0007¢\u0006\u0004\b\f\u0010\b\u001a\u0015\u0010\f\u001a\u0004\u0018\u00010\u0004*\u00020\u0003H\u0007¢\u0006\u0004\b\f\u0010\t\u001a\u0015\u0010\f\u001a\u0004\u0018\u00010\u0006*\u00020\u0005H\u0007¢\u0006\u0004\b\f\u0010\n\u001a\u0014\u0010\u000f\u001a\u00020\u0001*\u00020\r2\u0006\u0010\u000f\u001a\u00020\u000eH\u0007\u001a\u0014\u0010\u000f\u001a\u00020\u0004*\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0007\u001a\u0014\u0010\u000f\u001a\u00020\u0006*\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u000eH\u0007\u001a\u001d\u0010\u0012\u001a\u0004\u0018\u00010\u0001*\u00020\r2\u0006\u0010\u000f\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u001d\u0010\u0012\u001a\u0004\u0018\u00010\u0004*\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u0012\u0010\u0014\u001a\u001d\u0010\u0012\u001a\u0004\u0018\u00010\u0006*\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u0012\u0010\u0015\u001a\"\u0010\u001c\u001a\u00020\u0019*\b\u0012\u0004\u0012\u00020\u00010\u00162\u0006\u0010\u0018\u001a\u00020\u0017H\u0087\u0002¢\u0006\u0004\b\u001a\u0010\u001b\u001a\"\u0010\u001c\u001a\u00020\u0019*\b\u0012\u0004\u0012\u00020\u00040\u00162\u0006\u0010\u0018\u001a\u00020\u0017H\u0087\u0002¢\u0006\u0004\b\u001d\u0010\u001b\u001a\"\u0010\u001c\u001a\u00020\u0019*\b\u0012\u0004\u0012\u00020\u001e0\u00162\u0006\u0010\u0018\u001a\u00020\u0017H\u0087\u0002¢\u0006\u0004\b\u001f\u0010\u001b\u001a\"\u0010\u001c\u001a\u00020\u0019*\b\u0012\u0004\u0012\u00020 0\u00162\u0006\u0010\u0018\u001a\u00020\u0017H\u0087\u0002¢\u0006\u0004\b!\u0010\u001b\u001a\"\u0010\u001c\u001a\u00020\u0019*\b\u0012\u0004\u0012\u00020\"0\u00162\u0006\u0010\u0018\u001a\u00020\u0017H\u0087\u0002¢\u0006\u0004\b#\u0010\u001b\u001a\"\u0010\u001c\u001a\u00020\u0019*\b\u0012\u0004\u0012\u00020\u00010\u00162\u0006\u0010\u0018\u001a\u00020 H\u0087\u0002¢\u0006\u0004\b\u001a\u0010$\u001a\"\u0010\u001c\u001a\u00020\u0019*\b\u0012\u0004\u0012\u00020\u00040\u00162\u0006\u0010\u0018\u001a\u00020 H\u0087\u0002¢\u0006\u0004\b\u001d\u0010$\u001a\"\u0010\u001c\u001a\u00020\u0019*\b\u0012\u0004\u0012\u00020\u00170\u00162\u0006\u0010\u0018\u001a\u00020 H\u0087\u0002¢\u0006\u0004\b%\u0010$\u001a\"\u0010\u001c\u001a\u00020\u0019*\b\u0012\u0004\u0012\u00020\u001e0\u00162\u0006\u0010\u0018\u001a\u00020 H\u0087\u0002¢\u0006\u0004\b\u001f\u0010$\u001a\"\u0010\u001c\u001a\u00020\u0019*\b\u0012\u0004\u0012\u00020\"0\u00162\u0006\u0010\u0018\u001a\u00020 H\u0087\u0002¢\u0006\u0004\b#\u0010$\u001a\"\u0010\u001c\u001a\u00020\u0019*\b\u0012\u0004\u0012\u00020\u00010\u00162\u0006\u0010\u0018\u001a\u00020\"H\u0087\u0002¢\u0006\u0004\b\u001a\u0010&\u001a\"\u0010\u001c\u001a\u00020\u0019*\b\u0012\u0004\u0012\u00020\u00040\u00162\u0006\u0010\u0018\u001a\u00020\"H\u0087\u0002¢\u0006\u0004\b\u001d\u0010&\u001a\"\u0010\u001c\u001a\u00020\u0019*\b\u0012\u0004\u0012\u00020\u00170\u00162\u0006\u0010\u0018\u001a\u00020\"H\u0087\u0002¢\u0006\u0004\b%\u0010&\u001a\"\u0010\u001c\u001a\u00020\u0019*\b\u0012\u0004\u0012\u00020\u001e0\u00162\u0006\u0010\u0018\u001a\u00020\"H\u0087\u0002¢\u0006\u0004\b\u001f\u0010&\u001a\"\u0010\u001c\u001a\u00020\u0019*\b\u0012\u0004\u0012\u00020 0\u00162\u0006\u0010\u0018\u001a\u00020\"H\u0087\u0002¢\u0006\u0004\b!\u0010&\u001a\"\u0010\u001c\u001a\u00020\u0019*\b\u0012\u0004\u0012\u00020\u00040\u00162\u0006\u0010\u0018\u001a\u00020\u0001H\u0087\u0002¢\u0006\u0004\b\u001d\u0010'\u001a\"\u0010\u001c\u001a\u00020\u0019*\b\u0012\u0004\u0012\u00020\u00170\u00162\u0006\u0010\u0018\u001a\u00020\u0001H\u0087\u0002¢\u0006\u0004\b%\u0010'\u001a\"\u0010\u001c\u001a\u00020\u0019*\b\u0012\u0004\u0012\u00020\u001e0\u00162\u0006\u0010\u0018\u001a\u00020\u0001H\u0087\u0002¢\u0006\u0004\b\u001f\u0010'\u001a\"\u0010\u001c\u001a\u00020\u0019*\b\u0012\u0004\u0012\u00020 0\u00162\u0006\u0010\u0018\u001a\u00020\u0001H\u0087\u0002¢\u0006\u0004\b!\u0010'\u001a\"\u0010\u001c\u001a\u00020\u0019*\b\u0012\u0004\u0012\u00020\"0\u00162\u0006\u0010\u0018\u001a\u00020\u0001H\u0087\u0002¢\u0006\u0004\b#\u0010'\u001a\"\u0010\u001c\u001a\u00020\u0019*\b\u0012\u0004\u0012\u00020\u00010\u00162\u0006\u0010\u0018\u001a\u00020\u0004H\u0087\u0002¢\u0006\u0004\b\u001a\u0010(\u001a\"\u0010\u001c\u001a\u00020\u0019*\b\u0012\u0004\u0012\u00020\u00170\u00162\u0006\u0010\u0018\u001a\u00020\u0004H\u0087\u0002¢\u0006\u0004\b%\u0010(\u001a\"\u0010\u001c\u001a\u00020\u0019*\b\u0012\u0004\u0012\u00020\u001e0\u00162\u0006\u0010\u0018\u001a\u00020\u0004H\u0087\u0002¢\u0006\u0004\b\u001f\u0010(\u001a\"\u0010\u001c\u001a\u00020\u0019*\b\u0012\u0004\u0012\u00020 0\u00162\u0006\u0010\u0018\u001a\u00020\u0004H\u0087\u0002¢\u0006\u0004\b!\u0010(\u001a\"\u0010\u001c\u001a\u00020\u0019*\b\u0012\u0004\u0012\u00020\"0\u00162\u0006\u0010\u0018\u001a\u00020\u0004H\u0087\u0002¢\u0006\u0004\b#\u0010(\u001a\"\u0010\u001c\u001a\u00020\u0019*\b\u0012\u0004\u0012\u00020\u00010\u00162\u0006\u0010\u0018\u001a\u00020\u001eH\u0087\u0002¢\u0006\u0004\b\u001a\u0010)\u001a\"\u0010\u001c\u001a\u00020\u0019*\b\u0012\u0004\u0012\u00020\u00040\u00162\u0006\u0010\u0018\u001a\u00020\u001eH\u0087\u0002¢\u0006\u0004\b\u001d\u0010)\u001a\"\u0010\u001c\u001a\u00020\u0019*\b\u0012\u0004\u0012\u00020\u00170\u00162\u0006\u0010\u0018\u001a\u00020\u001eH\u0087\u0002¢\u0006\u0004\b%\u0010)\u001a\"\u0010\u001c\u001a\u00020\u0019*\b\u0012\u0004\u0012\u00020 0\u00162\u0006\u0010\u0018\u001a\u00020\u001eH\u0087\u0002¢\u0006\u0004\b!\u0010)\u001a\"\u0010\u001c\u001a\u00020\u0019*\b\u0012\u0004\u0012\u00020\"0\u00162\u0006\u0010\u0018\u001a\u00020\u001eH\u0087\u0002¢\u0006\u0004\b#\u0010)\u001a\u0015\u0010+\u001a\u00020\u0000*\u00020\u00012\u0006\u0010*\u001a\u00020\u0017H\u0086\u0004\u001a\u0015\u0010+\u001a\u00020\u0003*\u00020\u00042\u0006\u0010*\u001a\u00020\u0017H\u0086\u0004\u001a\u0015\u0010+\u001a\u00020\u0000*\u00020\u00172\u0006\u0010*\u001a\u00020\u0017H\u0086\u0004\u001a\u0015\u0010+\u001a\u00020\u0000*\u00020\u001e2\u0006\u0010*\u001a\u00020\u0017H\u0086\u0004\u001a\u0015\u0010+\u001a\u00020\u0005*\u00020\u00062\u0006\u0010*\u001a\u00020\u0006H\u0086\u0004\u001a\u0015\u0010+\u001a\u00020\u0000*\u00020\u00012\u0006\u0010*\u001a\u00020\u0001H\u0086\u0004\u001a\u0015\u0010+\u001a\u00020\u0003*\u00020\u00042\u0006\u0010*\u001a\u00020\u0001H\u0086\u0004\u001a\u0015\u0010+\u001a\u00020\u0000*\u00020\u00172\u0006\u0010*\u001a\u00020\u0001H\u0086\u0004\u001a\u0015\u0010+\u001a\u00020\u0000*\u00020\u001e2\u0006\u0010*\u001a\u00020\u0001H\u0086\u0004\u001a\u0015\u0010+\u001a\u00020\u0003*\u00020\u00012\u0006\u0010*\u001a\u00020\u0004H\u0086\u0004\u001a\u0015\u0010+\u001a\u00020\u0003*\u00020\u00042\u0006\u0010*\u001a\u00020\u0004H\u0086\u0004\u001a\u0015\u0010+\u001a\u00020\u0003*\u00020\u00172\u0006\u0010*\u001a\u00020\u0004H\u0086\u0004\u001a\u0015\u0010+\u001a\u00020\u0003*\u00020\u001e2\u0006\u0010*\u001a\u00020\u0004H\u0086\u0004\u001a\u0015\u0010+\u001a\u00020\u0000*\u00020\u00012\u0006\u0010*\u001a\u00020\u001eH\u0086\u0004\u001a\u0015\u0010+\u001a\u00020\u0003*\u00020\u00042\u0006\u0010*\u001a\u00020\u001eH\u0086\u0004\u001a\u0015\u0010+\u001a\u00020\u0000*\u00020\u00172\u0006\u0010*\u001a\u00020\u001eH\u0086\u0004\u001a\u0015\u0010+\u001a\u00020\u0000*\u00020\u001e2\u0006\u0010*\u001a\u00020\u001eH\u0086\u0004\u001a\n\u0010,\u001a\u00020\u0000*\u00020\u0000\u001a\n\u0010,\u001a\u00020\u0003*\u00020\u0003\u001a\n\u0010,\u001a\u00020\u0005*\u00020\u0005\u001a\u0015\u0010-\u001a\u00020\u0000*\u00020\u00002\u0006\u0010-\u001a\u00020\u0001H\u0086\u0004\u001a\u0015\u0010-\u001a\u00020\u0003*\u00020\u00032\u0006\u0010-\u001a\u00020\u0004H\u0086\u0004\u001a\u0015\u0010-\u001a\u00020\u0005*\u00020\u00052\u0006\u0010-\u001a\u00020\u0001H\u0086\u0004\u001a\u0015\u0010.\u001a\u0004\u0018\u00010\u0017*\u00020\u0001H\u0000¢\u0006\u0004\b.\u0010/\u001a\u0015\u0010.\u001a\u0004\u0018\u00010\u0017*\u00020\u0004H\u0000¢\u0006\u0004\b.\u00100\u001a\u0015\u0010.\u001a\u0004\u0018\u00010\u0017*\u00020\u001eH\u0000¢\u0006\u0004\b.\u00101\u001a\u0015\u0010.\u001a\u0004\u0018\u00010\u0017*\u00020 H\u0000¢\u0006\u0004\b.\u00102\u001a\u0015\u0010.\u001a\u0004\u0018\u00010\u0017*\u00020\"H\u0000¢\u0006\u0004\b.\u00103\u001a\u0015\u00104\u001a\u0004\u0018\u00010\u0001*\u00020\u0004H\u0000¢\u0006\u0004\b4\u00105\u001a\u0015\u00104\u001a\u0004\u0018\u00010\u0001*\u00020 H\u0000¢\u0006\u0004\b4\u00106\u001a\u0015\u00104\u001a\u0004\u0018\u00010\u0001*\u00020\"H\u0000¢\u0006\u0004\b4\u00107\u001a\u0015\u00108\u001a\u0004\u0018\u00010\u0004*\u00020 H\u0000¢\u0006\u0004\b8\u00109\u001a\u0015\u00108\u001a\u0004\u0018\u00010\u0004*\u00020\"H\u0000¢\u0006\u0004\b8\u0010:\u001a\u0015\u0010;\u001a\u0004\u0018\u00010\u001e*\u00020\u0001H\u0000¢\u0006\u0004\b;\u0010<\u001a\u0015\u0010;\u001a\u0004\u0018\u00010\u001e*\u00020\u0004H\u0000¢\u0006\u0004\b;\u0010=\u001a\u0015\u0010;\u001a\u0004\u0018\u00010\u001e*\u00020 H\u0000¢\u0006\u0004\b;\u0010>\u001a\u0015\u0010;\u001a\u0004\u0018\u00010\u001e*\u00020\"H\u0000¢\u0006\u0004\b;\u0010?\u001a\u0015\u0010@\u001a\u00020\r*\u00020\u00012\u0006\u0010*\u001a\u00020\u0017H\u0086\u0004\u001a\u0015\u0010@\u001a\u00020\u0010*\u00020\u00042\u0006\u0010*\u001a\u00020\u0017H\u0086\u0004\u001a\u0015\u0010@\u001a\u00020\r*\u00020\u00172\u0006\u0010*\u001a\u00020\u0017H\u0086\u0004\u001a\u0015\u0010@\u001a\u00020\r*\u00020\u001e2\u0006\u0010*\u001a\u00020\u0017H\u0086\u0004\u001a\u0015\u0010@\u001a\u00020\u0011*\u00020\u00062\u0006\u0010*\u001a\u00020\u0006H\u0086\u0004\u001a\u0015\u0010@\u001a\u00020\r*\u00020\u00012\u0006\u0010*\u001a\u00020\u0001H\u0086\u0004\u001a\u0015\u0010@\u001a\u00020\u0010*\u00020\u00042\u0006\u0010*\u001a\u00020\u0001H\u0086\u0004\u001a\u0015\u0010@\u001a\u00020\r*\u00020\u00172\u0006\u0010*\u001a\u00020\u0001H\u0086\u0004\u001a\u0015\u0010@\u001a\u00020\r*\u00020\u001e2\u0006\u0010*\u001a\u00020\u0001H\u0086\u0004\u001a\u0015\u0010@\u001a\u00020\u0010*\u00020\u00012\u0006\u0010*\u001a\u00020\u0004H\u0086\u0004\u001a\u0015\u0010@\u001a\u00020\u0010*\u00020\u00042\u0006\u0010*\u001a\u00020\u0004H\u0086\u0004\u001a\u0015\u0010@\u001a\u00020\u0010*\u00020\u00172\u0006\u0010*\u001a\u00020\u0004H\u0086\u0004\u001a\u0015\u0010@\u001a\u00020\u0010*\u00020\u001e2\u0006\u0010*\u001a\u00020\u0004H\u0086\u0004\u001a\u0015\u0010@\u001a\u00020\r*\u00020\u00012\u0006\u0010*\u001a\u00020\u001eH\u0086\u0004\u001a\u0015\u0010@\u001a\u00020\u0010*\u00020\u00042\u0006\u0010*\u001a\u00020\u001eH\u0086\u0004\u001a\u0015\u0010@\u001a\u00020\r*\u00020\u00172\u0006\u0010*\u001a\u00020\u001eH\u0086\u0004\u001a\u0015\u0010@\u001a\u00020\r*\u00020\u001e2\u0006\u0010*\u001a\u00020\u001eH\u0086\u0004\u001a)\u0010D\u001a\u00028\u0000\"\u000e\b\u0000\u0010B*\b\u0012\u0004\u0012\u00028\u00000A*\u00028\u00002\u0006\u0010C\u001a\u00028\u0000¢\u0006\u0004\bD\u0010E\u001a\u0012\u0010D\u001a\u00020\u0017*\u00020\u00172\u0006\u0010C\u001a\u00020\u0017\u001a\u0012\u0010D\u001a\u00020\u001e*\u00020\u001e2\u0006\u0010C\u001a\u00020\u001e\u001a\u0012\u0010D\u001a\u00020\u0001*\u00020\u00012\u0006\u0010C\u001a\u00020\u0001\u001a\u0012\u0010D\u001a\u00020\u0004*\u00020\u00042\u0006\u0010C\u001a\u00020\u0004\u001a\u0012\u0010D\u001a\u00020\"*\u00020\"2\u0006\u0010C\u001a\u00020\"\u001a\u0012\u0010D\u001a\u00020 *\u00020 2\u0006\u0010C\u001a\u00020 \u001a)\u0010G\u001a\u00028\u0000\"\u000e\b\u0000\u0010B*\b\u0012\u0004\u0012\u00028\u00000A*\u00028\u00002\u0006\u0010F\u001a\u00028\u0000¢\u0006\u0004\bG\u0010E\u001a\u0012\u0010G\u001a\u00020\u0017*\u00020\u00172\u0006\u0010F\u001a\u00020\u0017\u001a\u0012\u0010G\u001a\u00020\u001e*\u00020\u001e2\u0006\u0010F\u001a\u00020\u001e\u001a\u0012\u0010G\u001a\u00020\u0001*\u00020\u00012\u0006\u0010F\u001a\u00020\u0001\u001a\u0012\u0010G\u001a\u00020\u0004*\u00020\u00042\u0006\u0010F\u001a\u00020\u0004\u001a\u0012\u0010G\u001a\u00020\"*\u00020\"2\u0006\u0010F\u001a\u00020\"\u001a\u0012\u0010G\u001a\u00020 *\u00020 2\u0006\u0010F\u001a\u00020 \u001a5\u0010H\u001a\u00028\u0000\"\u000e\b\u0000\u0010B*\b\u0012\u0004\u0012\u00028\u00000A*\u00028\u00002\b\u0010C\u001a\u0004\u0018\u00018\u00002\b\u0010F\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\bH\u0010I\u001a\u001a\u0010H\u001a\u00020\u0017*\u00020\u00172\u0006\u0010C\u001a\u00020\u00172\u0006\u0010F\u001a\u00020\u0017\u001a\u001a\u0010H\u001a\u00020\u001e*\u00020\u001e2\u0006\u0010C\u001a\u00020\u001e2\u0006\u0010F\u001a\u00020\u001e\u001a\u001a\u0010H\u001a\u00020\u0001*\u00020\u00012\u0006\u0010C\u001a\u00020\u00012\u0006\u0010F\u001a\u00020\u0001\u001a\u001a\u0010H\u001a\u00020\u0004*\u00020\u00042\u0006\u0010C\u001a\u00020\u00042\u0006\u0010F\u001a\u00020\u0004\u001a\u001a\u0010H\u001a\u00020\"*\u00020\"2\u0006\u0010C\u001a\u00020\"2\u0006\u0010F\u001a\u00020\"\u001a\u001a\u0010H\u001a\u00020 *\u00020 2\u0006\u0010C\u001a\u00020 2\u0006\u0010F\u001a\u00020 \u001a1\u0010H\u001a\u00028\u0000\"\u000e\b\u0000\u0010B*\b\u0012\u0004\u0012\u00028\u00000A*\u00028\u00002\f\u0010K\u001a\b\u0012\u0004\u0012\u00028\u00000JH\u0007¢\u0006\u0004\bH\u0010L\u001a/\u0010H\u001a\u00028\u0000\"\u000e\b\u0000\u0010B*\b\u0012\u0004\u0012\u00028\u00000A*\u00028\u00002\f\u0010K\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016¢\u0006\u0004\bH\u0010M\u001a\u0018\u0010H\u001a\u00020\u0001*\u00020\u00012\f\u0010K\u001a\b\u0012\u0004\u0012\u00020\u00010\u0016\u001a\u0018\u0010H\u001a\u00020\u0004*\u00020\u00042\f\u0010K\u001a\b\u0012\u0004\u0012\u00020\u00040\u0016¨\u0006N"}, d2 = {"Lkotlin/ranges/IntProgression;", "", "first", "Lkotlin/ranges/LongProgression;", "", "Lkotlin/ranges/CharProgression;", "", "firstOrNull", "(Lkotlin/ranges/IntProgression;)Ljava/lang/Integer;", "(Lkotlin/ranges/LongProgression;)Ljava/lang/Long;", "(Lkotlin/ranges/CharProgression;)Ljava/lang/Character;", "last", "lastOrNull", "Lkotlin/ranges/IntRange;", "Lkotlin/random/Random;", "random", "Lkotlin/ranges/LongRange;", "Lkotlin/ranges/CharRange;", "randomOrNull", "(Lkotlin/ranges/IntRange;Lkotlin/random/Random;)Ljava/lang/Integer;", "(Lkotlin/ranges/LongRange;Lkotlin/random/Random;)Ljava/lang/Long;", "(Lkotlin/ranges/CharRange;Lkotlin/random/Random;)Ljava/lang/Character;", "Lkotlin/ranges/ClosedRange;", "", "value", "", "intRangeContains", "(Lkotlin/ranges/ClosedRange;B)Z", "contains", "longRangeContains", "", "shortRangeContains", "", "doubleRangeContains", "", "floatRangeContains", "(Lkotlin/ranges/ClosedRange;D)Z", "byteRangeContains", "(Lkotlin/ranges/ClosedRange;F)Z", "(Lkotlin/ranges/ClosedRange;I)Z", "(Lkotlin/ranges/ClosedRange;J)Z", "(Lkotlin/ranges/ClosedRange;S)Z", com.huawei.hms.push.constant.RemoteMessageConst.TO, "downTo", "reversed", "step", "toByteExactOrNull", "(I)Ljava/lang/Byte;", "(J)Ljava/lang/Byte;", "(S)Ljava/lang/Byte;", "(D)Ljava/lang/Byte;", "(F)Ljava/lang/Byte;", "toIntExactOrNull", "(J)Ljava/lang/Integer;", "(D)Ljava/lang/Integer;", "(F)Ljava/lang/Integer;", "toLongExactOrNull", "(D)Ljava/lang/Long;", "(F)Ljava/lang/Long;", "toShortExactOrNull", "(I)Ljava/lang/Short;", "(J)Ljava/lang/Short;", "(D)Ljava/lang/Short;", "(F)Ljava/lang/Short;", "until", "", androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "minimumValue", "coerceAtLeast", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)Ljava/lang/Comparable;", "maximumValue", "coerceAtMost", "coerceIn", "(Ljava/lang/Comparable;Ljava/lang/Comparable;Ljava/lang/Comparable;)Ljava/lang/Comparable;", "Lkotlin/ranges/ClosedFloatingPointRange;", "range", "(Ljava/lang/Comparable;Lkotlin/ranges/ClosedFloatingPointRange;)Ljava/lang/Comparable;", "(Ljava/lang/Comparable;Lkotlin/ranges/ClosedRange;)Ljava/lang/Comparable;", "kotlin-stdlib"}, k = 5, mv = {1, 7, 1}, xs = "kotlin/ranges/RangesKt")
/* loaded from: classes14.dex */
public class RangesKt___RangesKt extends kotlin.ranges.RangesKt__RangesKt {
    @kotlin.Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @kotlin.DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5, warningSince = "1.3")
    @kotlin.jvm.JvmName(name = "byteRangeContains")
    public static final /* synthetic */ boolean byteRangeContains(kotlin.ranges.ClosedRange closedRange, double d) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(closedRange, "<this>");
        java.lang.Byte byteExactOrNull = toByteExactOrNull(d);
        if (byteExactOrNull != null) {
            return closedRange.contains(byteExactOrNull);
        }
        return false;
    }

    @kotlin.Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @kotlin.DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5, warningSince = "1.3")
    @kotlin.jvm.JvmName(name = "byteRangeContains")
    public static final /* synthetic */ boolean byteRangeContains(kotlin.ranges.ClosedRange closedRange, float f) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(closedRange, "<this>");
        java.lang.Byte byteExactOrNull = toByteExactOrNull(f);
        if (byteExactOrNull != null) {
            return closedRange.contains(byteExactOrNull);
        }
        return false;
    }

    @kotlin.jvm.JvmName(name = "byteRangeContains")
    public static final boolean byteRangeContains(@org.jetbrains.annotations.NotNull kotlin.ranges.ClosedRange<java.lang.Byte> closedRange, int i) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(closedRange, "<this>");
        java.lang.Byte byteExactOrNull = toByteExactOrNull(i);
        if (byteExactOrNull != null) {
            return closedRange.contains(byteExactOrNull);
        }
        return false;
    }

    @kotlin.jvm.JvmName(name = "byteRangeContains")
    public static final boolean byteRangeContains(@org.jetbrains.annotations.NotNull kotlin.ranges.ClosedRange<java.lang.Byte> closedRange, long j) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(closedRange, "<this>");
        java.lang.Byte byteExactOrNull = toByteExactOrNull(j);
        if (byteExactOrNull != null) {
            return closedRange.contains(byteExactOrNull);
        }
        return false;
    }

    @kotlin.jvm.JvmName(name = "byteRangeContains")
    public static final boolean byteRangeContains(@org.jetbrains.annotations.NotNull kotlin.ranges.ClosedRange<java.lang.Byte> closedRange, short s2) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(closedRange, "<this>");
        java.lang.Byte byteExactOrNull = toByteExactOrNull(s2);
        if (byteExactOrNull != null) {
            return closedRange.contains(byteExactOrNull);
        }
        return false;
    }

    public static final byte coerceAtLeast(byte b, byte b2) {
        return b < b2 ? b2 : b;
    }

    public static final double coerceAtLeast(double d, double d2) {
        return d < d2 ? d2 : d;
    }

    public static float coerceAtLeast(float f, float f2) {
        return f < f2 ? f2 : f;
    }

    public static int coerceAtLeast(int i, int i2) {
        return i < i2 ? i2 : i;
    }

    public static long coerceAtLeast(long j, long j2) {
        return j < j2 ? j2 : j;
    }

    @org.jetbrains.annotations.NotNull
    public static final <T extends java.lang.Comparable<? super T>> T coerceAtLeast(@org.jetbrains.annotations.NotNull T t, @org.jetbrains.annotations.NotNull T minimumValue) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(t, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(minimumValue, "minimumValue");
        return t.compareTo(minimumValue) < 0 ? minimumValue : t;
    }

    public static final short coerceAtLeast(short s2, short s3) {
        return s2 < s3 ? s3 : s2;
    }

    public static final byte coerceAtMost(byte b, byte b2) {
        return b > b2 ? b2 : b;
    }

    public static double coerceAtMost(double d, double d2) {
        return d > d2 ? d2 : d;
    }

    public static float coerceAtMost(float f, float f2) {
        return f > f2 ? f2 : f;
    }

    public static int coerceAtMost(int i, int i2) {
        return i > i2 ? i2 : i;
    }

    public static long coerceAtMost(long j, long j2) {
        return j > j2 ? j2 : j;
    }

    @org.jetbrains.annotations.NotNull
    public static final <T extends java.lang.Comparable<? super T>> T coerceAtMost(@org.jetbrains.annotations.NotNull T t, @org.jetbrains.annotations.NotNull T maximumValue) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(t, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(maximumValue, "maximumValue");
        return t.compareTo(maximumValue) > 0 ? maximumValue : t;
    }

    public static final short coerceAtMost(short s2, short s3) {
        return s2 > s3 ? s3 : s2;
    }

    public static final byte coerceIn(byte b, byte b2, byte b3) {
        if (b2 <= b3) {
            return b < b2 ? b2 : b > b3 ? b3 : b;
        }
        throw new java.lang.IllegalArgumentException("Cannot coerce value to an empty range: maximum " + ((int) b3) + " is less than minimum " + ((int) b2) + '.');
    }

    public static final double coerceIn(double d, double d2, double d3) {
        if (d2 <= d3) {
            return d < d2 ? d2 : d > d3 ? d3 : d;
        }
        throw new java.lang.IllegalArgumentException("Cannot coerce value to an empty range: maximum " + d3 + " is less than minimum " + d2 + '.');
    }

    public static final float coerceIn(float f, float f2, float f3) {
        if (f2 <= f3) {
            return f < f2 ? f2 : f > f3 ? f3 : f;
        }
        throw new java.lang.IllegalArgumentException("Cannot coerce value to an empty range: maximum " + f3 + " is less than minimum " + f2 + '.');
    }

    public static int coerceIn(int i, int i2, int i3) {
        if (i2 <= i3) {
            return i < i2 ? i2 : i > i3 ? i3 : i;
        }
        throw new java.lang.IllegalArgumentException("Cannot coerce value to an empty range: maximum " + i3 + " is less than minimum " + i2 + '.');
    }

    public static final int coerceIn(int i, @org.jetbrains.annotations.NotNull kotlin.ranges.ClosedRange<java.lang.Integer> range) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(range, "range");
        if (range instanceof kotlin.ranges.ClosedFloatingPointRange) {
            return ((java.lang.Number) coerceIn(java.lang.Integer.valueOf(i), (kotlin.ranges.ClosedFloatingPointRange<java.lang.Integer>) range)).intValue();
        }
        if (!range.isEmpty()) {
            return i < range.getStart().intValue() ? range.getStart().intValue() : i > range.getEndInclusive().intValue() ? range.getEndInclusive().intValue() : i;
        }
        throw new java.lang.IllegalArgumentException("Cannot coerce value to an empty range: " + range + '.');
    }

    public static long coerceIn(long j, long j2, long j3) {
        if (j2 <= j3) {
            return j < j2 ? j2 : j > j3 ? j3 : j;
        }
        throw new java.lang.IllegalArgumentException("Cannot coerce value to an empty range: maximum " + j3 + " is less than minimum " + j2 + '.');
    }

    public static long coerceIn(long j, @org.jetbrains.annotations.NotNull kotlin.ranges.ClosedRange<java.lang.Long> range) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(range, "range");
        if (range instanceof kotlin.ranges.ClosedFloatingPointRange) {
            return ((java.lang.Number) coerceIn(java.lang.Long.valueOf(j), (kotlin.ranges.ClosedFloatingPointRange<java.lang.Long>) range)).longValue();
        }
        if (!range.isEmpty()) {
            return j < range.getStart().longValue() ? range.getStart().longValue() : j > range.getEndInclusive().longValue() ? range.getEndInclusive().longValue() : j;
        }
        throw new java.lang.IllegalArgumentException("Cannot coerce value to an empty range: " + range + '.');
    }

    @org.jetbrains.annotations.NotNull
    public static final <T extends java.lang.Comparable<? super T>> T coerceIn(@org.jetbrains.annotations.NotNull T t, @org.jetbrains.annotations.Nullable T t2, @org.jetbrains.annotations.Nullable T t3) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(t, "<this>");
        if (t2 == null || t3 == null) {
            if (t2 != null && t.compareTo(t2) < 0) {
                return t2;
            }
            if (t3 != null && t.compareTo(t3) > 0) {
                return t3;
            }
        } else {
            if (t2.compareTo(t3) > 0) {
                throw new java.lang.IllegalArgumentException("Cannot coerce value to an empty range: maximum " + t3 + " is less than minimum " + t2 + '.');
            }
            if (t.compareTo(t2) < 0) {
                return t2;
            }
            if (t.compareTo(t3) > 0) {
                return t3;
            }
        }
        return t;
    }

    @kotlin.SinceKotlin(version = "1.1")
    @org.jetbrains.annotations.NotNull
    public static final <T extends java.lang.Comparable<? super T>> T coerceIn(@org.jetbrains.annotations.NotNull T t, @org.jetbrains.annotations.NotNull kotlin.ranges.ClosedFloatingPointRange<T> range) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(t, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(range, "range");
        if (!range.isEmpty()) {
            return (!range.lessThanOrEquals(t, range.getStart()) || range.lessThanOrEquals(range.getStart(), t)) ? (!range.lessThanOrEquals(range.getEndInclusive(), t) || range.lessThanOrEquals(t, range.getEndInclusive())) ? t : range.getEndInclusive() : range.getStart();
        }
        throw new java.lang.IllegalArgumentException("Cannot coerce value to an empty range: " + range + '.');
    }

    @org.jetbrains.annotations.NotNull
    public static final <T extends java.lang.Comparable<? super T>> T coerceIn(@org.jetbrains.annotations.NotNull T t, @org.jetbrains.annotations.NotNull kotlin.ranges.ClosedRange<T> range) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(t, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(range, "range");
        if (range instanceof kotlin.ranges.ClosedFloatingPointRange) {
            return (T) coerceIn((java.lang.Comparable) t, (kotlin.ranges.ClosedFloatingPointRange) range);
        }
        if (!range.isEmpty()) {
            return t.compareTo(range.getStart()) < 0 ? range.getStart() : t.compareTo(range.getEndInclusive()) > 0 ? range.getEndInclusive() : t;
        }
        throw new java.lang.IllegalArgumentException("Cannot coerce value to an empty range: " + range + '.');
    }

    public static final short coerceIn(short s2, short s3, short s4) {
        if (s3 <= s4) {
            return s2 < s3 ? s3 : s2 > s4 ? s4 : s2;
        }
        throw new java.lang.IllegalArgumentException("Cannot coerce value to an empty range: maximum " + ((int) s4) + " is less than minimum " + ((int) s3) + '.');
    }

    @kotlin.Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @kotlin.DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5, warningSince = "1.3")
    @kotlin.jvm.JvmName(name = "doubleRangeContains")
    public static final /* synthetic */ boolean doubleRangeContains(kotlin.ranges.ClosedRange closedRange, byte b) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(closedRange, "<this>");
        return closedRange.contains(java.lang.Double.valueOf(b));
    }

    @kotlin.jvm.JvmName(name = "doubleRangeContains")
    public static final boolean doubleRangeContains(@org.jetbrains.annotations.NotNull kotlin.ranges.ClosedRange<java.lang.Double> closedRange, float f) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(closedRange, "<this>");
        return closedRange.contains(java.lang.Double.valueOf(f));
    }

    @kotlin.Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @kotlin.DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5, warningSince = "1.3")
    @kotlin.jvm.JvmName(name = "doubleRangeContains")
    public static final /* synthetic */ boolean doubleRangeContains(kotlin.ranges.ClosedRange closedRange, int i) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(closedRange, "<this>");
        return closedRange.contains(java.lang.Double.valueOf(i));
    }

    @kotlin.Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @kotlin.DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5, warningSince = "1.3")
    @kotlin.jvm.JvmName(name = "doubleRangeContains")
    public static final /* synthetic */ boolean doubleRangeContains(kotlin.ranges.ClosedRange closedRange, long j) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(closedRange, "<this>");
        return closedRange.contains(java.lang.Double.valueOf(j));
    }

    @kotlin.Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @kotlin.DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5, warningSince = "1.3")
    @kotlin.jvm.JvmName(name = "doubleRangeContains")
    public static final /* synthetic */ boolean doubleRangeContains(kotlin.ranges.ClosedRange closedRange, short s2) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(closedRange, "<this>");
        return closedRange.contains(java.lang.Double.valueOf(s2));
    }

    @org.jetbrains.annotations.NotNull
    public static final kotlin.ranges.CharProgression downTo(char c, char c2) {
        return kotlin.ranges.CharProgression.INSTANCE.fromClosedRange(c, c2, -1);
    }

    @org.jetbrains.annotations.NotNull
    public static final kotlin.ranges.IntProgression downTo(byte b, byte b2) {
        return kotlin.ranges.IntProgression.INSTANCE.fromClosedRange(b, b2, -1);
    }

    @org.jetbrains.annotations.NotNull
    public static final kotlin.ranges.IntProgression downTo(byte b, int i) {
        return kotlin.ranges.IntProgression.INSTANCE.fromClosedRange(b, i, -1);
    }

    @org.jetbrains.annotations.NotNull
    public static final kotlin.ranges.IntProgression downTo(byte b, short s2) {
        return kotlin.ranges.IntProgression.INSTANCE.fromClosedRange(b, s2, -1);
    }

    @org.jetbrains.annotations.NotNull
    public static final kotlin.ranges.IntProgression downTo(int i, byte b) {
        return kotlin.ranges.IntProgression.INSTANCE.fromClosedRange(i, b, -1);
    }

    @org.jetbrains.annotations.NotNull
    public static kotlin.ranges.IntProgression downTo(int i, int i2) {
        return kotlin.ranges.IntProgression.INSTANCE.fromClosedRange(i, i2, -1);
    }

    @org.jetbrains.annotations.NotNull
    public static final kotlin.ranges.IntProgression downTo(int i, short s2) {
        return kotlin.ranges.IntProgression.INSTANCE.fromClosedRange(i, s2, -1);
    }

    @org.jetbrains.annotations.NotNull
    public static final kotlin.ranges.IntProgression downTo(short s2, byte b) {
        return kotlin.ranges.IntProgression.INSTANCE.fromClosedRange(s2, b, -1);
    }

    @org.jetbrains.annotations.NotNull
    public static final kotlin.ranges.IntProgression downTo(short s2, int i) {
        return kotlin.ranges.IntProgression.INSTANCE.fromClosedRange(s2, i, -1);
    }

    @org.jetbrains.annotations.NotNull
    public static final kotlin.ranges.IntProgression downTo(short s2, short s3) {
        return kotlin.ranges.IntProgression.INSTANCE.fromClosedRange(s2, s3, -1);
    }

    @org.jetbrains.annotations.NotNull
    public static final kotlin.ranges.LongProgression downTo(byte b, long j) {
        return kotlin.ranges.LongProgression.INSTANCE.fromClosedRange(b, j, -1L);
    }

    @org.jetbrains.annotations.NotNull
    public static final kotlin.ranges.LongProgression downTo(int i, long j) {
        return kotlin.ranges.LongProgression.INSTANCE.fromClosedRange(i, j, -1L);
    }

    @org.jetbrains.annotations.NotNull
    public static final kotlin.ranges.LongProgression downTo(long j, byte b) {
        return kotlin.ranges.LongProgression.INSTANCE.fromClosedRange(j, b, -1L);
    }

    @org.jetbrains.annotations.NotNull
    public static final kotlin.ranges.LongProgression downTo(long j, int i) {
        return kotlin.ranges.LongProgression.INSTANCE.fromClosedRange(j, i, -1L);
    }

    @org.jetbrains.annotations.NotNull
    public static final kotlin.ranges.LongProgression downTo(long j, long j2) {
        return kotlin.ranges.LongProgression.INSTANCE.fromClosedRange(j, j2, -1L);
    }

    @org.jetbrains.annotations.NotNull
    public static final kotlin.ranges.LongProgression downTo(long j, short s2) {
        return kotlin.ranges.LongProgression.INSTANCE.fromClosedRange(j, s2, -1L);
    }

    @org.jetbrains.annotations.NotNull
    public static final kotlin.ranges.LongProgression downTo(short s2, long j) {
        return kotlin.ranges.LongProgression.INSTANCE.fromClosedRange(s2, j, -1L);
    }

    @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_7)
    public static final char first(@org.jetbrains.annotations.NotNull kotlin.ranges.CharProgression charProgression) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charProgression, "<this>");
        if (!charProgression.isEmpty()) {
            return charProgression.getFirst();
        }
        throw new java.util.NoSuchElementException("Progression " + charProgression + " is empty.");
    }

    @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_7)
    public static final int first(@org.jetbrains.annotations.NotNull kotlin.ranges.IntProgression intProgression) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(intProgression, "<this>");
        if (!intProgression.isEmpty()) {
            return intProgression.getFirst();
        }
        throw new java.util.NoSuchElementException("Progression " + intProgression + " is empty.");
    }

    @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_7)
    public static final long first(@org.jetbrains.annotations.NotNull kotlin.ranges.LongProgression longProgression) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(longProgression, "<this>");
        if (!longProgression.isEmpty()) {
            return longProgression.getFirst();
        }
        throw new java.util.NoSuchElementException("Progression " + longProgression + " is empty.");
    }

    @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_7)
    @org.jetbrains.annotations.Nullable
    public static final java.lang.Character firstOrNull(@org.jetbrains.annotations.NotNull kotlin.ranges.CharProgression charProgression) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charProgression, "<this>");
        if (charProgression.isEmpty()) {
            return null;
        }
        return java.lang.Character.valueOf(charProgression.getFirst());
    }

    @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_7)
    @org.jetbrains.annotations.Nullable
    public static final java.lang.Integer firstOrNull(@org.jetbrains.annotations.NotNull kotlin.ranges.IntProgression intProgression) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(intProgression, "<this>");
        if (intProgression.isEmpty()) {
            return null;
        }
        return java.lang.Integer.valueOf(intProgression.getFirst());
    }

    @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_7)
    @org.jetbrains.annotations.Nullable
    public static final java.lang.Long firstOrNull(@org.jetbrains.annotations.NotNull kotlin.ranges.LongProgression longProgression) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(longProgression, "<this>");
        if (longProgression.isEmpty()) {
            return null;
        }
        return java.lang.Long.valueOf(longProgression.getFirst());
    }

    @kotlin.Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @kotlin.DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5, warningSince = "1.3")
    @kotlin.jvm.JvmName(name = "floatRangeContains")
    public static final /* synthetic */ boolean floatRangeContains(kotlin.ranges.ClosedRange closedRange, byte b) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(closedRange, "<this>");
        return closedRange.contains(java.lang.Float.valueOf(b));
    }

    @kotlin.jvm.JvmName(name = "floatRangeContains")
    public static final boolean floatRangeContains(@org.jetbrains.annotations.NotNull kotlin.ranges.ClosedRange<java.lang.Float> closedRange, double d) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(closedRange, "<this>");
        return closedRange.contains(java.lang.Float.valueOf((float) d));
    }

    @kotlin.Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @kotlin.DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5, warningSince = "1.3")
    @kotlin.jvm.JvmName(name = "floatRangeContains")
    public static final /* synthetic */ boolean floatRangeContains(kotlin.ranges.ClosedRange closedRange, int i) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(closedRange, "<this>");
        return closedRange.contains(java.lang.Float.valueOf(i));
    }

    @kotlin.Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @kotlin.DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5, warningSince = "1.3")
    @kotlin.jvm.JvmName(name = "floatRangeContains")
    public static final /* synthetic */ boolean floatRangeContains(kotlin.ranges.ClosedRange closedRange, long j) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(closedRange, "<this>");
        return closedRange.contains(java.lang.Float.valueOf(j));
    }

    @kotlin.Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @kotlin.DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5, warningSince = "1.3")
    @kotlin.jvm.JvmName(name = "floatRangeContains")
    public static final /* synthetic */ boolean floatRangeContains(kotlin.ranges.ClosedRange closedRange, short s2) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(closedRange, "<this>");
        return closedRange.contains(java.lang.Float.valueOf(s2));
    }

    @kotlin.jvm.JvmName(name = "intRangeContains")
    public static final boolean intRangeContains(@org.jetbrains.annotations.NotNull kotlin.ranges.ClosedRange<java.lang.Integer> closedRange, byte b) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(closedRange, "<this>");
        return closedRange.contains(java.lang.Integer.valueOf(b));
    }

    @kotlin.Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @kotlin.DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5, warningSince = "1.3")
    @kotlin.jvm.JvmName(name = "intRangeContains")
    public static final /* synthetic */ boolean intRangeContains(kotlin.ranges.ClosedRange closedRange, double d) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(closedRange, "<this>");
        java.lang.Integer intExactOrNull = toIntExactOrNull(d);
        if (intExactOrNull != null) {
            return closedRange.contains(intExactOrNull);
        }
        return false;
    }

    @kotlin.Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @kotlin.DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5, warningSince = "1.3")
    @kotlin.jvm.JvmName(name = "intRangeContains")
    public static final /* synthetic */ boolean intRangeContains(kotlin.ranges.ClosedRange closedRange, float f) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(closedRange, "<this>");
        java.lang.Integer intExactOrNull = toIntExactOrNull(f);
        if (intExactOrNull != null) {
            return closedRange.contains(intExactOrNull);
        }
        return false;
    }

    @kotlin.jvm.JvmName(name = "intRangeContains")
    public static final boolean intRangeContains(@org.jetbrains.annotations.NotNull kotlin.ranges.ClosedRange<java.lang.Integer> closedRange, long j) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(closedRange, "<this>");
        java.lang.Integer intExactOrNull = toIntExactOrNull(j);
        if (intExactOrNull != null) {
            return closedRange.contains(intExactOrNull);
        }
        return false;
    }

    @kotlin.jvm.JvmName(name = "intRangeContains")
    public static final boolean intRangeContains(@org.jetbrains.annotations.NotNull kotlin.ranges.ClosedRange<java.lang.Integer> closedRange, short s2) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(closedRange, "<this>");
        return closedRange.contains(java.lang.Integer.valueOf(s2));
    }

    @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_7)
    public static final char last(@org.jetbrains.annotations.NotNull kotlin.ranges.CharProgression charProgression) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charProgression, "<this>");
        if (!charProgression.isEmpty()) {
            return charProgression.getLast();
        }
        throw new java.util.NoSuchElementException("Progression " + charProgression + " is empty.");
    }

    @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_7)
    public static final int last(@org.jetbrains.annotations.NotNull kotlin.ranges.IntProgression intProgression) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(intProgression, "<this>");
        if (!intProgression.isEmpty()) {
            return intProgression.getLast();
        }
        throw new java.util.NoSuchElementException("Progression " + intProgression + " is empty.");
    }

    @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_7)
    public static final long last(@org.jetbrains.annotations.NotNull kotlin.ranges.LongProgression longProgression) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(longProgression, "<this>");
        if (!longProgression.isEmpty()) {
            return longProgression.getLast();
        }
        throw new java.util.NoSuchElementException("Progression " + longProgression + " is empty.");
    }

    @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_7)
    @org.jetbrains.annotations.Nullable
    public static final java.lang.Character lastOrNull(@org.jetbrains.annotations.NotNull kotlin.ranges.CharProgression charProgression) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charProgression, "<this>");
        if (charProgression.isEmpty()) {
            return null;
        }
        return java.lang.Character.valueOf(charProgression.getLast());
    }

    @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_7)
    @org.jetbrains.annotations.Nullable
    public static final java.lang.Integer lastOrNull(@org.jetbrains.annotations.NotNull kotlin.ranges.IntProgression intProgression) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(intProgression, "<this>");
        if (intProgression.isEmpty()) {
            return null;
        }
        return java.lang.Integer.valueOf(intProgression.getLast());
    }

    @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_7)
    @org.jetbrains.annotations.Nullable
    public static final java.lang.Long lastOrNull(@org.jetbrains.annotations.NotNull kotlin.ranges.LongProgression longProgression) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(longProgression, "<this>");
        if (longProgression.isEmpty()) {
            return null;
        }
        return java.lang.Long.valueOf(longProgression.getLast());
    }

    @kotlin.jvm.JvmName(name = "longRangeContains")
    public static final boolean longRangeContains(@org.jetbrains.annotations.NotNull kotlin.ranges.ClosedRange<java.lang.Long> closedRange, byte b) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(closedRange, "<this>");
        return closedRange.contains(java.lang.Long.valueOf(b));
    }

    @kotlin.Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @kotlin.DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5, warningSince = "1.3")
    @kotlin.jvm.JvmName(name = "longRangeContains")
    public static final /* synthetic */ boolean longRangeContains(kotlin.ranges.ClosedRange closedRange, double d) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(closedRange, "<this>");
        java.lang.Long longExactOrNull = toLongExactOrNull(d);
        if (longExactOrNull != null) {
            return closedRange.contains(longExactOrNull);
        }
        return false;
    }

    @kotlin.Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @kotlin.DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5, warningSince = "1.3")
    @kotlin.jvm.JvmName(name = "longRangeContains")
    public static final /* synthetic */ boolean longRangeContains(kotlin.ranges.ClosedRange closedRange, float f) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(closedRange, "<this>");
        java.lang.Long longExactOrNull = toLongExactOrNull(f);
        if (longExactOrNull != null) {
            return closedRange.contains(longExactOrNull);
        }
        return false;
    }

    @kotlin.jvm.JvmName(name = "longRangeContains")
    public static final boolean longRangeContains(@org.jetbrains.annotations.NotNull kotlin.ranges.ClosedRange<java.lang.Long> closedRange, int i) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(closedRange, "<this>");
        return closedRange.contains(java.lang.Long.valueOf(i));
    }

    @kotlin.jvm.JvmName(name = "longRangeContains")
    public static final boolean longRangeContains(@org.jetbrains.annotations.NotNull kotlin.ranges.ClosedRange<java.lang.Long> closedRange, short s2) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(closedRange, "<this>");
        return closedRange.contains(java.lang.Long.valueOf(s2));
    }

    @kotlin.SinceKotlin(version = "1.3")
    public static final char random(@org.jetbrains.annotations.NotNull kotlin.ranges.CharRange charRange, @org.jetbrains.annotations.NotNull kotlin.random.Random random) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charRange, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(random, "random");
        try {
            return (char) random.nextInt(charRange.getFirst(), charRange.getLast() + 1);
        } catch (java.lang.IllegalArgumentException e) {
            throw new java.util.NoSuchElementException(e.getMessage());
        }
    }

    @kotlin.SinceKotlin(version = "1.3")
    public static final int random(@org.jetbrains.annotations.NotNull kotlin.ranges.IntRange intRange, @org.jetbrains.annotations.NotNull kotlin.random.Random random) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(intRange, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(random, "random");
        try {
            return kotlin.random.RandomKt.nextInt(random, intRange);
        } catch (java.lang.IllegalArgumentException e) {
            throw new java.util.NoSuchElementException(e.getMessage());
        }
    }

    @kotlin.SinceKotlin(version = "1.3")
    public static final long random(@org.jetbrains.annotations.NotNull kotlin.ranges.LongRange longRange, @org.jetbrains.annotations.NotNull kotlin.random.Random random) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(longRange, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(random, "random");
        try {
            return kotlin.random.RandomKt.nextLong(random, longRange);
        } catch (java.lang.IllegalArgumentException e) {
            throw new java.util.NoSuchElementException(e.getMessage());
        }
    }

    @kotlin.SinceKotlin(version = "1.4")
    @kotlin.WasExperimental(markerClass = {kotlin.ExperimentalStdlibApi.class})
    @org.jetbrains.annotations.Nullable
    public static final java.lang.Character randomOrNull(@org.jetbrains.annotations.NotNull kotlin.ranges.CharRange charRange, @org.jetbrains.annotations.NotNull kotlin.random.Random random) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charRange, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(random, "random");
        if (charRange.isEmpty()) {
            return null;
        }
        return java.lang.Character.valueOf((char) random.nextInt(charRange.getFirst(), charRange.getLast() + 1));
    }

    @kotlin.SinceKotlin(version = "1.4")
    @kotlin.WasExperimental(markerClass = {kotlin.ExperimentalStdlibApi.class})
    @org.jetbrains.annotations.Nullable
    public static final java.lang.Integer randomOrNull(@org.jetbrains.annotations.NotNull kotlin.ranges.IntRange intRange, @org.jetbrains.annotations.NotNull kotlin.random.Random random) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(intRange, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(random, "random");
        if (intRange.isEmpty()) {
            return null;
        }
        return java.lang.Integer.valueOf(kotlin.random.RandomKt.nextInt(random, intRange));
    }

    @kotlin.SinceKotlin(version = "1.4")
    @kotlin.WasExperimental(markerClass = {kotlin.ExperimentalStdlibApi.class})
    @org.jetbrains.annotations.Nullable
    public static final java.lang.Long randomOrNull(@org.jetbrains.annotations.NotNull kotlin.ranges.LongRange longRange, @org.jetbrains.annotations.NotNull kotlin.random.Random random) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(longRange, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(random, "random");
        if (longRange.isEmpty()) {
            return null;
        }
        return java.lang.Long.valueOf(kotlin.random.RandomKt.nextLong(random, longRange));
    }

    @org.jetbrains.annotations.NotNull
    public static final kotlin.ranges.CharProgression reversed(@org.jetbrains.annotations.NotNull kotlin.ranges.CharProgression charProgression) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charProgression, "<this>");
        return kotlin.ranges.CharProgression.INSTANCE.fromClosedRange(charProgression.getLast(), charProgression.getFirst(), -charProgression.getStep());
    }

    @org.jetbrains.annotations.NotNull
    public static final kotlin.ranges.IntProgression reversed(@org.jetbrains.annotations.NotNull kotlin.ranges.IntProgression intProgression) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(intProgression, "<this>");
        return kotlin.ranges.IntProgression.INSTANCE.fromClosedRange(intProgression.getLast(), intProgression.getFirst(), -intProgression.getStep());
    }

    @org.jetbrains.annotations.NotNull
    public static final kotlin.ranges.LongProgression reversed(@org.jetbrains.annotations.NotNull kotlin.ranges.LongProgression longProgression) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(longProgression, "<this>");
        return kotlin.ranges.LongProgression.INSTANCE.fromClosedRange(longProgression.getLast(), longProgression.getFirst(), -longProgression.getStep());
    }

    @kotlin.jvm.JvmName(name = "shortRangeContains")
    public static final boolean shortRangeContains(@org.jetbrains.annotations.NotNull kotlin.ranges.ClosedRange<java.lang.Short> closedRange, byte b) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(closedRange, "<this>");
        return closedRange.contains(java.lang.Short.valueOf(b));
    }

    @kotlin.Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @kotlin.DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5, warningSince = "1.3")
    @kotlin.jvm.JvmName(name = "shortRangeContains")
    public static final /* synthetic */ boolean shortRangeContains(kotlin.ranges.ClosedRange closedRange, double d) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(closedRange, "<this>");
        java.lang.Short shortExactOrNull = toShortExactOrNull(d);
        if (shortExactOrNull != null) {
            return closedRange.contains(shortExactOrNull);
        }
        return false;
    }

    @kotlin.Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @kotlin.DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5, warningSince = "1.3")
    @kotlin.jvm.JvmName(name = "shortRangeContains")
    public static final /* synthetic */ boolean shortRangeContains(kotlin.ranges.ClosedRange closedRange, float f) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(closedRange, "<this>");
        java.lang.Short shortExactOrNull = toShortExactOrNull(f);
        if (shortExactOrNull != null) {
            return closedRange.contains(shortExactOrNull);
        }
        return false;
    }

    @kotlin.jvm.JvmName(name = "shortRangeContains")
    public static final boolean shortRangeContains(@org.jetbrains.annotations.NotNull kotlin.ranges.ClosedRange<java.lang.Short> closedRange, int i) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(closedRange, "<this>");
        java.lang.Short shortExactOrNull = toShortExactOrNull(i);
        if (shortExactOrNull != null) {
            return closedRange.contains(shortExactOrNull);
        }
        return false;
    }

    @kotlin.jvm.JvmName(name = "shortRangeContains")
    public static final boolean shortRangeContains(@org.jetbrains.annotations.NotNull kotlin.ranges.ClosedRange<java.lang.Short> closedRange, long j) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(closedRange, "<this>");
        java.lang.Short shortExactOrNull = toShortExactOrNull(j);
        if (shortExactOrNull != null) {
            return closedRange.contains(shortExactOrNull);
        }
        return false;
    }

    @org.jetbrains.annotations.NotNull
    public static final kotlin.ranges.CharProgression step(@org.jetbrains.annotations.NotNull kotlin.ranges.CharProgression charProgression, int i) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charProgression, "<this>");
        kotlin.ranges.RangesKt__RangesKt.checkStepIsPositive(i > 0, java.lang.Integer.valueOf(i));
        kotlin.ranges.CharProgression.Companion companion = kotlin.ranges.CharProgression.INSTANCE;
        char first = charProgression.getFirst();
        char last = charProgression.getLast();
        if (charProgression.getStep() <= 0) {
            i = -i;
        }
        return companion.fromClosedRange(first, last, i);
    }

    @org.jetbrains.annotations.NotNull
    public static kotlin.ranges.IntProgression step(@org.jetbrains.annotations.NotNull kotlin.ranges.IntProgression intProgression, int i) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(intProgression, "<this>");
        kotlin.ranges.RangesKt__RangesKt.checkStepIsPositive(i > 0, java.lang.Integer.valueOf(i));
        kotlin.ranges.IntProgression.Companion companion = kotlin.ranges.IntProgression.INSTANCE;
        int first = intProgression.getFirst();
        int last = intProgression.getLast();
        if (intProgression.getStep() <= 0) {
            i = -i;
        }
        return companion.fromClosedRange(first, last, i);
    }

    @org.jetbrains.annotations.NotNull
    public static final kotlin.ranges.LongProgression step(@org.jetbrains.annotations.NotNull kotlin.ranges.LongProgression longProgression, long j) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(longProgression, "<this>");
        kotlin.ranges.RangesKt__RangesKt.checkStepIsPositive(j > 0, java.lang.Long.valueOf(j));
        kotlin.ranges.LongProgression.Companion companion = kotlin.ranges.LongProgression.INSTANCE;
        long first = longProgression.getFirst();
        long last = longProgression.getLast();
        if (longProgression.getStep() <= 0) {
            j = -j;
        }
        return companion.fromClosedRange(first, last, j);
    }

    @org.jetbrains.annotations.Nullable
    public static final java.lang.Byte toByteExactOrNull(double d) {
        boolean z = false;
        if (d <= 127.0d && -128.0d <= d) {
            z = true;
        }
        if (z) {
            return java.lang.Byte.valueOf((byte) d);
        }
        return null;
    }

    @org.jetbrains.annotations.Nullable
    public static final java.lang.Byte toByteExactOrNull(float f) {
        boolean z = false;
        if (f <= 127.0f && -128.0f <= f) {
            z = true;
        }
        if (z) {
            return java.lang.Byte.valueOf((byte) f);
        }
        return null;
    }

    @org.jetbrains.annotations.Nullable
    public static final java.lang.Byte toByteExactOrNull(int i) {
        if (new kotlin.ranges.IntRange(com.alipay.sdk.m.n.a.g, 127).contains(i)) {
            return java.lang.Byte.valueOf((byte) i);
        }
        return null;
    }

    @org.jetbrains.annotations.Nullable
    public static final java.lang.Byte toByteExactOrNull(long j) {
        if (new kotlin.ranges.LongRange(-128L, 127L).contains(j)) {
            return java.lang.Byte.valueOf((byte) j);
        }
        return null;
    }

    @org.jetbrains.annotations.Nullable
    public static final java.lang.Byte toByteExactOrNull(short s2) {
        if (intRangeContains((kotlin.ranges.ClosedRange<java.lang.Integer>) new kotlin.ranges.IntRange(com.alipay.sdk.m.n.a.g, 127), s2)) {
            return java.lang.Byte.valueOf((byte) s2);
        }
        return null;
    }

    @org.jetbrains.annotations.Nullable
    public static final java.lang.Integer toIntExactOrNull(double d) {
        boolean z = false;
        if (d <= 2.147483647E9d && -2.147483648E9d <= d) {
            z = true;
        }
        if (z) {
            return java.lang.Integer.valueOf((int) d);
        }
        return null;
    }

    @org.jetbrains.annotations.Nullable
    public static final java.lang.Integer toIntExactOrNull(float f) {
        boolean z = false;
        if (f <= 2.1474836E9f && -2.1474836E9f <= f) {
            z = true;
        }
        if (z) {
            return java.lang.Integer.valueOf((int) f);
        }
        return null;
    }

    @org.jetbrains.annotations.Nullable
    public static final java.lang.Integer toIntExactOrNull(long j) {
        if (new kotlin.ranges.LongRange(-2147483648L, 2147483647L).contains(j)) {
            return java.lang.Integer.valueOf((int) j);
        }
        return null;
    }

    @org.jetbrains.annotations.Nullable
    public static final java.lang.Long toLongExactOrNull(double d) {
        boolean z = false;
        if (d <= 9.223372036854776E18d && -9.223372036854776E18d <= d) {
            z = true;
        }
        if (z) {
            return java.lang.Long.valueOf((long) d);
        }
        return null;
    }

    @org.jetbrains.annotations.Nullable
    public static final java.lang.Long toLongExactOrNull(float f) {
        boolean z = false;
        if (f <= 9.223372E18f && -9.223372E18f <= f) {
            z = true;
        }
        if (z) {
            return java.lang.Long.valueOf((long) f);
        }
        return null;
    }

    @org.jetbrains.annotations.Nullable
    public static final java.lang.Short toShortExactOrNull(double d) {
        boolean z = false;
        if (d <= 32767.0d && -32768.0d <= d) {
            z = true;
        }
        if (z) {
            return java.lang.Short.valueOf((short) d);
        }
        return null;
    }

    @org.jetbrains.annotations.Nullable
    public static final java.lang.Short toShortExactOrNull(float f) {
        boolean z = false;
        if (f <= 32767.0f && -32768.0f <= f) {
            z = true;
        }
        if (z) {
            return java.lang.Short.valueOf((short) f);
        }
        return null;
    }

    @org.jetbrains.annotations.Nullable
    public static final java.lang.Short toShortExactOrNull(int i) {
        if (new kotlin.ranges.IntRange(-32768, 32767).contains(i)) {
            return java.lang.Short.valueOf((short) i);
        }
        return null;
    }

    @org.jetbrains.annotations.Nullable
    public static final java.lang.Short toShortExactOrNull(long j) {
        if (new kotlin.ranges.LongRange(-32768L, 32767L).contains(j)) {
            return java.lang.Short.valueOf((short) j);
        }
        return null;
    }

    @org.jetbrains.annotations.NotNull
    public static final kotlin.ranges.CharRange until(char c, char c2) {
        return kotlin.jvm.internal.Intrinsics.compare((int) c2, 0) <= 0 ? kotlin.ranges.CharRange.INSTANCE.getEMPTY() : new kotlin.ranges.CharRange(c, (char) (c2 - 1));
    }

    @org.jetbrains.annotations.NotNull
    public static final kotlin.ranges.IntRange until(byte b, byte b2) {
        return new kotlin.ranges.IntRange(b, b2 - 1);
    }

    @org.jetbrains.annotations.NotNull
    public static final kotlin.ranges.IntRange until(byte b, int i) {
        return i <= Integer.MIN_VALUE ? kotlin.ranges.IntRange.INSTANCE.getEMPTY() : new kotlin.ranges.IntRange(b, i - 1);
    }

    @org.jetbrains.annotations.NotNull
    public static final kotlin.ranges.IntRange until(byte b, short s2) {
        return new kotlin.ranges.IntRange(b, s2 - 1);
    }

    @org.jetbrains.annotations.NotNull
    public static final kotlin.ranges.IntRange until(int i, byte b) {
        return new kotlin.ranges.IntRange(i, b - 1);
    }

    @org.jetbrains.annotations.NotNull
    public static kotlin.ranges.IntRange until(int i, int i2) {
        return i2 <= Integer.MIN_VALUE ? kotlin.ranges.IntRange.INSTANCE.getEMPTY() : new kotlin.ranges.IntRange(i, i2 - 1);
    }

    @org.jetbrains.annotations.NotNull
    public static final kotlin.ranges.IntRange until(int i, short s2) {
        return new kotlin.ranges.IntRange(i, s2 - 1);
    }

    @org.jetbrains.annotations.NotNull
    public static final kotlin.ranges.IntRange until(short s2, byte b) {
        return new kotlin.ranges.IntRange(s2, b - 1);
    }

    @org.jetbrains.annotations.NotNull
    public static final kotlin.ranges.IntRange until(short s2, int i) {
        return i <= Integer.MIN_VALUE ? kotlin.ranges.IntRange.INSTANCE.getEMPTY() : new kotlin.ranges.IntRange(s2, i - 1);
    }

    @org.jetbrains.annotations.NotNull
    public static final kotlin.ranges.IntRange until(short s2, short s3) {
        return new kotlin.ranges.IntRange(s2, s3 - 1);
    }

    @org.jetbrains.annotations.NotNull
    public static final kotlin.ranges.LongRange until(byte b, long j) {
        return j <= Long.MIN_VALUE ? kotlin.ranges.LongRange.INSTANCE.getEMPTY() : new kotlin.ranges.LongRange(b, j - 1);
    }

    @org.jetbrains.annotations.NotNull
    public static final kotlin.ranges.LongRange until(int i, long j) {
        return j <= Long.MIN_VALUE ? kotlin.ranges.LongRange.INSTANCE.getEMPTY() : new kotlin.ranges.LongRange(i, j - 1);
    }

    @org.jetbrains.annotations.NotNull
    public static final kotlin.ranges.LongRange until(long j, byte b) {
        return new kotlin.ranges.LongRange(j, b - 1);
    }

    @org.jetbrains.annotations.NotNull
    public static final kotlin.ranges.LongRange until(long j, int i) {
        return new kotlin.ranges.LongRange(j, i - 1);
    }

    @org.jetbrains.annotations.NotNull
    public static final kotlin.ranges.LongRange until(long j, long j2) {
        return j2 <= Long.MIN_VALUE ? kotlin.ranges.LongRange.INSTANCE.getEMPTY() : new kotlin.ranges.LongRange(j, j2 - 1);
    }

    @org.jetbrains.annotations.NotNull
    public static final kotlin.ranges.LongRange until(long j, short s2) {
        return new kotlin.ranges.LongRange(j, s2 - 1);
    }

    @org.jetbrains.annotations.NotNull
    public static final kotlin.ranges.LongRange until(short s2, long j) {
        return j <= Long.MIN_VALUE ? kotlin.ranges.LongRange.INSTANCE.getEMPTY() : new kotlin.ranges.LongRange(s2, j - 1);
    }
}
