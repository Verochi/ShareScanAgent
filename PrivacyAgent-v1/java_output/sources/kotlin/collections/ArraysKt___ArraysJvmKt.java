package kotlin.collections;

/* JADX INFO: Access modifiers changed from: package-private */
@kotlin.Metadata(d1 = {"\u0000\u0092\u0001\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u001f\n\u0002\b\u0007\n\u0002\u0010\u0012\n\u0002\u0010\u0005\n\u0002\u0010\u0017\n\u0002\u0010\n\n\u0002\u0010\u0015\n\u0002\u0010\b\n\u0002\u0010\u0016\n\u0002\u0010\t\n\u0002\u0010\u0014\n\u0002\u0010\u0007\n\u0002\u0010\u0013\n\u0002\u0010\u0006\n\u0002\u0010\u0018\n\u0002\u0010\u000b\n\u0002\u0010\u0019\n\u0002\u0010\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\b\u0005\n\u0002\u0010\u000f\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0019\u001a/\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0000*\u0006\u0012\u0002\b\u00030\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0004\b\u0005\u0010\u0006\u001aC\u0010\n\u001a\u00028\u0000\"\u0010\b\u0000\u0010\b*\n\u0012\u0006\b\u0000\u0012\u00028\u00010\u0007\"\u0004\b\u0001\u0010\u0000*\u0006\u0012\u0002\b\u00030\u00012\u0006\u0010\t\u001a\u00028\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002¢\u0006\u0004\b\n\u0010\u000b\u001a%\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\f*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001¢\u0006\u0004\b\r\u0010\u000e\u001a\u0010\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00100\u0004*\u00020\u000f\u001a\u0010\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00120\u0004*\u00020\u0011\u001a\u0010\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00140\u0004*\u00020\u0013\u001a\u0010\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00160\u0004*\u00020\u0015\u001a\u0010\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00180\u0004*\u00020\u0017\u001a\u0010\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0004*\u00020\u0019\u001a\u0010\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0004*\u00020\u001b\u001a\u0010\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0004*\u00020\u001d\u001aW\u0010%\u001a\u00020\u0014\"\u0004\b\u0000\u0010\f*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00012\u0006\u0010\u001f\u001a\u00028\u00002\u001a\u0010\"\u001a\u0016\u0012\u0006\b\u0000\u0012\u00028\u00000 j\n\u0012\u0006\b\u0000\u0012\u00028\u0000`!2\b\b\u0002\u0010#\u001a\u00020\u00142\b\b\u0002\u0010$\u001a\u00020\u0014¢\u0006\u0004\b%\u0010&\u001a;\u0010%\u001a\u00020\u0014\"\u0004\b\u0000\u0010\f*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00012\u0006\u0010\u001f\u001a\u00028\u00002\b\b\u0002\u0010#\u001a\u00020\u00142\b\b\u0002\u0010$\u001a\u00020\u0014¢\u0006\u0004\b%\u0010'\u001a&\u0010%\u001a\u00020\u0014*\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\u00102\b\b\u0002\u0010#\u001a\u00020\u00142\b\b\u0002\u0010$\u001a\u00020\u0014\u001a&\u0010%\u001a\u00020\u0014*\u00020\u00112\u0006\u0010\u001f\u001a\u00020\u00122\b\b\u0002\u0010#\u001a\u00020\u00142\b\b\u0002\u0010$\u001a\u00020\u0014\u001a&\u0010%\u001a\u00020\u0014*\u00020\u00132\u0006\u0010\u001f\u001a\u00020\u00142\b\b\u0002\u0010#\u001a\u00020\u00142\b\b\u0002\u0010$\u001a\u00020\u0014\u001a&\u0010%\u001a\u00020\u0014*\u00020\u00152\u0006\u0010\u001f\u001a\u00020\u00162\b\b\u0002\u0010#\u001a\u00020\u00142\b\b\u0002\u0010$\u001a\u00020\u0014\u001a&\u0010%\u001a\u00020\u0014*\u00020\u00172\u0006\u0010\u001f\u001a\u00020\u00182\b\b\u0002\u0010#\u001a\u00020\u00142\b\b\u0002\u0010$\u001a\u00020\u0014\u001a&\u0010%\u001a\u00020\u0014*\u00020\u00192\u0006\u0010\u001f\u001a\u00020\u001a2\b\b\u0002\u0010#\u001a\u00020\u00142\b\b\u0002\u0010$\u001a\u00020\u0014\u001a&\u0010%\u001a\u00020\u0014*\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u001e2\b\b\u0002\u0010#\u001a\u00020\u00142\b\b\u0002\u0010$\u001a\u00020\u0014\u001aS\u0010+\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\f*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u00012\b\b\u0002\u0010(\u001a\u00020\u00142\b\b\u0002\u0010)\u001a\u00020\u00142\b\b\u0002\u0010*\u001a\u00020\u0014H\u0007¢\u0006\u0004\b+\u0010,\u001a2\u0010+\u001a\u00020\u000f*\u00020\u000f2\u0006\u0010\t\u001a\u00020\u000f2\b\b\u0002\u0010(\u001a\u00020\u00142\b\b\u0002\u0010)\u001a\u00020\u00142\b\b\u0002\u0010*\u001a\u00020\u0014H\u0007\u001a2\u0010+\u001a\u00020\u0011*\u00020\u00112\u0006\u0010\t\u001a\u00020\u00112\b\b\u0002\u0010(\u001a\u00020\u00142\b\b\u0002\u0010)\u001a\u00020\u00142\b\b\u0002\u0010*\u001a\u00020\u0014H\u0007\u001a2\u0010+\u001a\u00020\u0013*\u00020\u00132\u0006\u0010\t\u001a\u00020\u00132\b\b\u0002\u0010(\u001a\u00020\u00142\b\b\u0002\u0010)\u001a\u00020\u00142\b\b\u0002\u0010*\u001a\u00020\u0014H\u0007\u001a2\u0010+\u001a\u00020\u0015*\u00020\u00152\u0006\u0010\t\u001a\u00020\u00152\b\b\u0002\u0010(\u001a\u00020\u00142\b\b\u0002\u0010)\u001a\u00020\u00142\b\b\u0002\u0010*\u001a\u00020\u0014H\u0007\u001a2\u0010+\u001a\u00020\u0017*\u00020\u00172\u0006\u0010\t\u001a\u00020\u00172\b\b\u0002\u0010(\u001a\u00020\u00142\b\b\u0002\u0010)\u001a\u00020\u00142\b\b\u0002\u0010*\u001a\u00020\u0014H\u0007\u001a2\u0010+\u001a\u00020\u0019*\u00020\u00192\u0006\u0010\t\u001a\u00020\u00192\b\b\u0002\u0010(\u001a\u00020\u00142\b\b\u0002\u0010)\u001a\u00020\u00142\b\b\u0002\u0010*\u001a\u00020\u0014H\u0007\u001a2\u0010+\u001a\u00020\u001b*\u00020\u001b2\u0006\u0010\t\u001a\u00020\u001b2\b\b\u0002\u0010(\u001a\u00020\u00142\b\b\u0002\u0010)\u001a\u00020\u00142\b\b\u0002\u0010*\u001a\u00020\u0014H\u0007\u001a2\u0010+\u001a\u00020\u001d*\u00020\u001d2\u0006\u0010\t\u001a\u00020\u001d2\b\b\u0002\u0010(\u001a\u00020\u00142\b\b\u0002\u0010)\u001a\u00020\u00142\b\b\u0002\u0010*\u001a\u00020\u0014H\u0007\u001a5\u0010/\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010#\u001a\u00020\u00142\u0006\u0010$\u001a\u00020\u0014H\u0001¢\u0006\u0004\b-\u0010.\u001a#\u0010/\u001a\u00020\u000f*\u00020\u000f2\u0006\u0010#\u001a\u00020\u00142\u0006\u0010$\u001a\u00020\u0014H\u0001¢\u0006\u0004\b-\u00100\u001a#\u0010/\u001a\u00020\u0011*\u00020\u00112\u0006\u0010#\u001a\u00020\u00142\u0006\u0010$\u001a\u00020\u0014H\u0001¢\u0006\u0004\b-\u00101\u001a#\u0010/\u001a\u00020\u0013*\u00020\u00132\u0006\u0010#\u001a\u00020\u00142\u0006\u0010$\u001a\u00020\u0014H\u0001¢\u0006\u0004\b-\u00102\u001a#\u0010/\u001a\u00020\u0015*\u00020\u00152\u0006\u0010#\u001a\u00020\u00142\u0006\u0010$\u001a\u00020\u0014H\u0001¢\u0006\u0004\b-\u00103\u001a#\u0010/\u001a\u00020\u0017*\u00020\u00172\u0006\u0010#\u001a\u00020\u00142\u0006\u0010$\u001a\u00020\u0014H\u0001¢\u0006\u0004\b-\u00104\u001a#\u0010/\u001a\u00020\u0019*\u00020\u00192\u0006\u0010#\u001a\u00020\u00142\u0006\u0010$\u001a\u00020\u0014H\u0001¢\u0006\u0004\b-\u00105\u001a#\u0010/\u001a\u00020\u001b*\u00020\u001b2\u0006\u0010#\u001a\u00020\u00142\u0006\u0010$\u001a\u00020\u0014H\u0001¢\u0006\u0004\b-\u00106\u001a#\u0010/\u001a\u00020\u001d*\u00020\u001d2\u0006\u0010#\u001a\u00020\u00142\u0006\u0010$\u001a\u00020\u0014H\u0001¢\u0006\u0004\b-\u00107\u001a9\u00109\u001a\u000208\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u001f\u001a\u00028\u00002\b\b\u0002\u0010#\u001a\u00020\u00142\b\b\u0002\u0010$\u001a\u00020\u0014¢\u0006\u0004\b9\u0010:\u001a&\u00109\u001a\u000208*\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\u00102\b\b\u0002\u0010#\u001a\u00020\u00142\b\b\u0002\u0010$\u001a\u00020\u0014\u001a&\u00109\u001a\u000208*\u00020\u00112\u0006\u0010\u001f\u001a\u00020\u00122\b\b\u0002\u0010#\u001a\u00020\u00142\b\b\u0002\u0010$\u001a\u00020\u0014\u001a&\u00109\u001a\u000208*\u00020\u00132\u0006\u0010\u001f\u001a\u00020\u00142\b\b\u0002\u0010#\u001a\u00020\u00142\b\b\u0002\u0010$\u001a\u00020\u0014\u001a&\u00109\u001a\u000208*\u00020\u00152\u0006\u0010\u001f\u001a\u00020\u00162\b\b\u0002\u0010#\u001a\u00020\u00142\b\b\u0002\u0010$\u001a\u00020\u0014\u001a&\u00109\u001a\u000208*\u00020\u00172\u0006\u0010\u001f\u001a\u00020\u00182\b\b\u0002\u0010#\u001a\u00020\u00142\b\b\u0002\u0010$\u001a\u00020\u0014\u001a&\u00109\u001a\u000208*\u00020\u00192\u0006\u0010\u001f\u001a\u00020\u001a2\b\b\u0002\u0010#\u001a\u00020\u00142\b\b\u0002\u0010$\u001a\u00020\u0014\u001a&\u00109\u001a\u000208*\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u001c2\b\b\u0002\u0010#\u001a\u00020\u00142\b\b\u0002\u0010$\u001a\u00020\u0014\u001a&\u00109\u001a\u000208*\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u001e2\b\b\u0002\u0010#\u001a\u00020\u00142\b\b\u0002\u0010$\u001a\u00020\u0014\u001a.\u0010;\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u001f\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0004\b;\u0010<\u001a\u0015\u0010;\u001a\u00020\u000f*\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\u0010H\u0086\u0002\u001a\u0015\u0010;\u001a\u00020\u0011*\u00020\u00112\u0006\u0010\u001f\u001a\u00020\u0012H\u0086\u0002\u001a\u0015\u0010;\u001a\u00020\u0013*\u00020\u00132\u0006\u0010\u001f\u001a\u00020\u0014H\u0086\u0002\u001a\u0015\u0010;\u001a\u00020\u0015*\u00020\u00152\u0006\u0010\u001f\u001a\u00020\u0016H\u0086\u0002\u001a\u0015\u0010;\u001a\u00020\u0017*\u00020\u00172\u0006\u0010\u001f\u001a\u00020\u0018H\u0086\u0002\u001a\u0015\u0010;\u001a\u00020\u0019*\u00020\u00192\u0006\u0010\u001f\u001a\u00020\u001aH\u0086\u0002\u001a\u0015\u0010;\u001a\u00020\u001b*\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u001cH\u0086\u0002\u001a\u0015\u0010;\u001a\u00020\u001d*\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u001eH\u0086\u0002\u001a4\u0010;\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010>\u001a\b\u0012\u0004\u0012\u00028\u00000=H\u0086\u0002¢\u0006\u0004\b;\u0010?\u001a\u001b\u0010;\u001a\u00020\u000f*\u00020\u000f2\f\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00100=H\u0086\u0002\u001a\u001b\u0010;\u001a\u00020\u0011*\u00020\u00112\f\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00120=H\u0086\u0002\u001a\u001b\u0010;\u001a\u00020\u0013*\u00020\u00132\f\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00140=H\u0086\u0002\u001a\u001b\u0010;\u001a\u00020\u0015*\u00020\u00152\f\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00160=H\u0086\u0002\u001a\u001b\u0010;\u001a\u00020\u0017*\u00020\u00172\f\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00180=H\u0086\u0002\u001a\u001b\u0010;\u001a\u00020\u0019*\u00020\u00192\f\u0010>\u001a\b\u0012\u0004\u0012\u00020\u001a0=H\u0086\u0002\u001a\u001b\u0010;\u001a\u00020\u001b*\u00020\u001b2\f\u0010>\u001a\b\u0012\u0004\u0012\u00020\u001c0=H\u0086\u0002\u001a\u001b\u0010;\u001a\u00020\u001d*\u00020\u001d2\f\u0010>\u001a\b\u0012\u0004\u0012\u00020\u001e0=H\u0086\u0002\u001a6\u0010;\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u00028\u00000\u00012\u000e\u0010>\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001H\u0086\u0002¢\u0006\u0004\b;\u0010@\u001a\u0015\u0010;\u001a\u00020\u000f*\u00020\u000f2\u0006\u0010>\u001a\u00020\u000fH\u0086\u0002\u001a\u0015\u0010;\u001a\u00020\u0011*\u00020\u00112\u0006\u0010>\u001a\u00020\u0011H\u0086\u0002\u001a\u0015\u0010;\u001a\u00020\u0013*\u00020\u00132\u0006\u0010>\u001a\u00020\u0013H\u0086\u0002\u001a\u0015\u0010;\u001a\u00020\u0015*\u00020\u00152\u0006\u0010>\u001a\u00020\u0015H\u0086\u0002\u001a\u0015\u0010;\u001a\u00020\u0017*\u00020\u00172\u0006\u0010>\u001a\u00020\u0017H\u0086\u0002\u001a\u0015\u0010;\u001a\u00020\u0019*\u00020\u00192\u0006\u0010>\u001a\u00020\u0019H\u0086\u0002\u001a\u0015\u0010;\u001a\u00020\u001b*\u00020\u001b2\u0006\u0010>\u001a\u00020\u001bH\u0086\u0002\u001a\u0015\u0010;\u001a\u00020\u001d*\u00020\u001d2\u0006\u0010>\u001a\u00020\u001dH\u0086\u0002\u001a\n\u0010A\u001a\u000208*\u00020\u0013\u001a\n\u0010A\u001a\u000208*\u00020\u0015\u001a\n\u0010A\u001a\u000208*\u00020\u000f\u001a\n\u0010A\u001a\u000208*\u00020\u0011\u001a\n\u0010A\u001a\u000208*\u00020\u0019\u001a\n\u0010A\u001a\u000208*\u00020\u0017\u001a\n\u0010A\u001a\u000208*\u00020\u001d\u001a\u001f\u0010A\u001a\u000208\"\u0004\b\u0000\u0010\f*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001¢\u0006\u0004\bA\u0010B\u001a?\u0010A\u001a\u000208\"\u000e\b\u0000\u0010\f*\b\u0012\u0004\u0012\u00028\u00000C*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00012\b\b\u0002\u0010#\u001a\u00020\u00142\b\b\u0002\u0010$\u001a\u00020\u0014H\u0007¢\u0006\u0004\bA\u0010D\u001a\u001e\u0010A\u001a\u000208*\u00020\u000f2\b\b\u0002\u0010#\u001a\u00020\u00142\b\b\u0002\u0010$\u001a\u00020\u0014\u001a\u001e\u0010A\u001a\u000208*\u00020\u00112\b\b\u0002\u0010#\u001a\u00020\u00142\b\b\u0002\u0010$\u001a\u00020\u0014\u001a\u001e\u0010A\u001a\u000208*\u00020\u00132\b\b\u0002\u0010#\u001a\u00020\u00142\b\b\u0002\u0010$\u001a\u00020\u0014\u001a\u001e\u0010A\u001a\u000208*\u00020\u00152\b\b\u0002\u0010#\u001a\u00020\u00142\b\b\u0002\u0010$\u001a\u00020\u0014\u001a\u001e\u0010A\u001a\u000208*\u00020\u00172\b\b\u0002\u0010#\u001a\u00020\u00142\b\b\u0002\u0010$\u001a\u00020\u0014\u001a\u001e\u0010A\u001a\u000208*\u00020\u00192\b\b\u0002\u0010#\u001a\u00020\u00142\b\b\u0002\u0010$\u001a\u00020\u0014\u001a\u001e\u0010A\u001a\u000208*\u00020\u001d2\b\b\u0002\u0010#\u001a\u00020\u00142\b\b\u0002\u0010$\u001a\u00020\u0014\u001a3\u0010A\u001a\u000208\"\u0004\b\u0000\u0010\f*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00012\b\b\u0002\u0010#\u001a\u00020\u00142\b\b\u0002\u0010$\u001a\u00020\u0014¢\u0006\u0004\bA\u0010E\u001a;\u0010F\u001a\u000208\"\u0004\b\u0000\u0010\f*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00012\u001a\u0010\"\u001a\u0016\u0012\u0006\b\u0000\u0012\u00028\u00000 j\n\u0012\u0006\b\u0000\u0012\u00028\u0000`!¢\u0006\u0004\bF\u0010G\u001aO\u0010F\u001a\u000208\"\u0004\b\u0000\u0010\f*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00012\u001a\u0010\"\u001a\u0016\u0012\u0006\b\u0000\u0012\u00028\u00000 j\n\u0012\u0006\b\u0000\u0012\u00028\u0000`!2\b\b\u0002\u0010#\u001a\u00020\u00142\b\b\u0002\u0010$\u001a\u00020\u0014¢\u0006\u0004\bF\u0010H\u001a\u0017\u0010I\u001a\b\u0012\u0004\u0012\u00020\u00100\u0001*\u00020\u000f¢\u0006\u0004\bI\u0010J\u001a\u0017\u0010I\u001a\b\u0012\u0004\u0012\u00020\u00120\u0001*\u00020\u0011¢\u0006\u0004\bI\u0010K\u001a\u0017\u0010I\u001a\b\u0012\u0004\u0012\u00020\u00140\u0001*\u00020\u0013¢\u0006\u0004\bI\u0010L\u001a\u0017\u0010I\u001a\b\u0012\u0004\u0012\u00020\u00160\u0001*\u00020\u0015¢\u0006\u0004\bI\u0010M\u001a\u0017\u0010I\u001a\b\u0012\u0004\u0012\u00020\u00180\u0001*\u00020\u0017¢\u0006\u0004\bI\u0010N\u001a\u0017\u0010I\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0001*\u00020\u0019¢\u0006\u0004\bI\u0010O\u001a\u0017\u0010I\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0001*\u00020\u001b¢\u0006\u0004\bI\u0010P\u001a\u0017\u0010I\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0001*\u00020\u001d¢\u0006\u0004\bI\u0010Q\u001a/\u0010S\u001a\b\u0012\u0004\u0012\u00028\u00000R\"\u000e\b\u0000\u0010\f*\b\u0012\u0004\u0012\u00028\u00000C*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001¢\u0006\u0004\bS\u0010T\u001a\u0010\u0010S\u001a\b\u0012\u0004\u0012\u00020\u00100R*\u00020\u000f\u001a\u0010\u0010S\u001a\b\u0012\u0004\u0012\u00020\u00120R*\u00020\u0011\u001a\u0010\u0010S\u001a\b\u0012\u0004\u0012\u00020\u00140R*\u00020\u0013\u001a\u0010\u0010S\u001a\b\u0012\u0004\u0012\u00020\u00160R*\u00020\u0015\u001a\u0010\u0010S\u001a\b\u0012\u0004\u0012\u00020\u00180R*\u00020\u0017\u001a\u0010\u0010S\u001a\b\u0012\u0004\u0012\u00020\u001a0R*\u00020\u0019\u001a\u0010\u0010S\u001a\b\u0012\u0004\u0012\u00020\u001c0R*\u00020\u001b\u001a\u0010\u0010S\u001a\b\u0012\u0004\u0012\u00020\u001e0R*\u00020\u001d\u001aA\u0010S\u001a\b\u0012\u0004\u0012\u00028\u00000R\"\u0004\b\u0000\u0010\f*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00012\u001a\u0010\"\u001a\u0016\u0012\u0006\b\u0000\u0012\u00028\u00000 j\n\u0012\u0006\b\u0000\u0012\u00028\u0000`!¢\u0006\u0004\bS\u0010U\u001a\u001d\u0010V\u001a\u0004\u0018\u00010\u001a*\n\u0012\u0006\b\u0001\u0012\u00020\u001a0\u0001H\u0007¢\u0006\u0004\bV\u0010W\u001a\u001d\u0010V\u001a\u0004\u0018\u00010\u0018*\n\u0012\u0006\b\u0001\u0012\u00020\u00180\u0001H\u0007¢\u0006\u0004\bV\u0010X\u001a-\u0010V\u001a\u0004\u0018\u00018\u0000\"\u000e\b\u0000\u0010\f*\b\u0012\u0004\u0012\u00028\u00000C*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001H\u0007¢\u0006\u0004\bV\u0010Y\u001a\u0015\u0010V\u001a\u0004\u0018\u00010\u0010*\u00020\u000fH\u0007¢\u0006\u0004\bV\u0010Z\u001a\u0015\u0010V\u001a\u0004\u0018\u00010\u0012*\u00020\u0011H\u0007¢\u0006\u0004\bV\u0010[\u001a\u0015\u0010V\u001a\u0004\u0018\u00010\u0014*\u00020\u0013H\u0007¢\u0006\u0004\bV\u0010\\\u001a\u0015\u0010V\u001a\u0004\u0018\u00010\u0016*\u00020\u0015H\u0007¢\u0006\u0004\bV\u0010]\u001a\u0015\u0010V\u001a\u0004\u0018\u00010\u0018*\u00020\u0017H\u0007¢\u0006\u0004\bV\u0010^\u001a\u0015\u0010V\u001a\u0004\u0018\u00010\u001a*\u00020\u0019H\u0007¢\u0006\u0004\bV\u0010_\u001a\u0015\u0010V\u001a\u0004\u0018\u00010\u001e*\u00020\u001dH\u0007¢\u0006\u0004\bV\u0010`\u001aK\u0010c\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\f\"\u000e\b\u0001\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00010C*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00012\u0012\u0010b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010aH\u0087\bø\u0001\u0000¢\u0006\u0004\bc\u0010d\u001a=\u0010c\u001a\u0004\u0018\u00010\u0010\"\u000e\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000C*\u00020\u000f2\u0012\u0010b\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00028\u00000aH\u0087\bø\u0001\u0000¢\u0006\u0004\bc\u0010e\u001a=\u0010c\u001a\u0004\u0018\u00010\u0012\"\u000e\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000C*\u00020\u00112\u0012\u0010b\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00028\u00000aH\u0087\bø\u0001\u0000¢\u0006\u0004\bc\u0010f\u001a=\u0010c\u001a\u0004\u0018\u00010\u0014\"\u000e\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000C*\u00020\u00132\u0012\u0010b\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00028\u00000aH\u0087\bø\u0001\u0000¢\u0006\u0004\bc\u0010g\u001a=\u0010c\u001a\u0004\u0018\u00010\u0016\"\u000e\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000C*\u00020\u00152\u0012\u0010b\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00028\u00000aH\u0087\bø\u0001\u0000¢\u0006\u0004\bc\u0010h\u001a=\u0010c\u001a\u0004\u0018\u00010\u0018\"\u000e\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000C*\u00020\u00172\u0012\u0010b\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00028\u00000aH\u0087\bø\u0001\u0000¢\u0006\u0004\bc\u0010i\u001a=\u0010c\u001a\u0004\u0018\u00010\u001a\"\u000e\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000C*\u00020\u00192\u0012\u0010b\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00028\u00000aH\u0087\bø\u0001\u0000¢\u0006\u0004\bc\u0010j\u001a=\u0010c\u001a\u0004\u0018\u00010\u001c\"\u000e\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000C*\u00020\u001b2\u0012\u0010b\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00028\u00000aH\u0087\bø\u0001\u0000¢\u0006\u0004\bc\u0010k\u001a=\u0010c\u001a\u0004\u0018\u00010\u001e\"\u000e\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000C*\u00020\u001d2\u0012\u0010b\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00028\u00000aH\u0087\bø\u0001\u0000¢\u0006\u0004\bc\u0010l\u001a?\u0010m\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\f*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00012\u001a\u0010\"\u001a\u0016\u0012\u0006\b\u0000\u0012\u00028\u00000 j\n\u0012\u0006\b\u0000\u0012\u00028\u0000`!H\u0007¢\u0006\u0004\bm\u0010n\u001a1\u0010m\u001a\u0004\u0018\u00010\u0010*\u00020\u000f2\u001a\u0010\"\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\u00100 j\n\u0012\u0006\b\u0000\u0012\u00020\u0010`!H\u0007¢\u0006\u0004\bm\u0010o\u001a1\u0010m\u001a\u0004\u0018\u00010\u0012*\u00020\u00112\u001a\u0010\"\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\u00120 j\n\u0012\u0006\b\u0000\u0012\u00020\u0012`!H\u0007¢\u0006\u0004\bm\u0010p\u001a1\u0010m\u001a\u0004\u0018\u00010\u0014*\u00020\u00132\u001a\u0010\"\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\u00140 j\n\u0012\u0006\b\u0000\u0012\u00020\u0014`!H\u0007¢\u0006\u0004\bm\u0010q\u001a1\u0010m\u001a\u0004\u0018\u00010\u0016*\u00020\u00152\u001a\u0010\"\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\u00160 j\n\u0012\u0006\b\u0000\u0012\u00020\u0016`!H\u0007¢\u0006\u0004\bm\u0010r\u001a1\u0010m\u001a\u0004\u0018\u00010\u0018*\u00020\u00172\u001a\u0010\"\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\u00180 j\n\u0012\u0006\b\u0000\u0012\u00020\u0018`!H\u0007¢\u0006\u0004\bm\u0010s\u001a1\u0010m\u001a\u0004\u0018\u00010\u001a*\u00020\u00192\u001a\u0010\"\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\u001a0 j\n\u0012\u0006\b\u0000\u0012\u00020\u001a`!H\u0007¢\u0006\u0004\bm\u0010t\u001a1\u0010m\u001a\u0004\u0018\u00010\u001c*\u00020\u001b2\u001a\u0010\"\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\u001c0 j\n\u0012\u0006\b\u0000\u0012\u00020\u001c`!H\u0007¢\u0006\u0004\bm\u0010u\u001a1\u0010m\u001a\u0004\u0018\u00010\u001e*\u00020\u001d2\u001a\u0010\"\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\u001e0 j\n\u0012\u0006\b\u0000\u0012\u00020\u001e`!H\u0007¢\u0006\u0004\bm\u0010v\u001a\u001d\u0010w\u001a\u0004\u0018\u00010\u001a*\n\u0012\u0006\b\u0001\u0012\u00020\u001a0\u0001H\u0007¢\u0006\u0004\bw\u0010W\u001a\u001d\u0010w\u001a\u0004\u0018\u00010\u0018*\n\u0012\u0006\b\u0001\u0012\u00020\u00180\u0001H\u0007¢\u0006\u0004\bw\u0010X\u001a-\u0010w\u001a\u0004\u0018\u00018\u0000\"\u000e\b\u0000\u0010\f*\b\u0012\u0004\u0012\u00028\u00000C*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001H\u0007¢\u0006\u0004\bw\u0010Y\u001a\u0015\u0010w\u001a\u0004\u0018\u00010\u0010*\u00020\u000fH\u0007¢\u0006\u0004\bw\u0010Z\u001a\u0015\u0010w\u001a\u0004\u0018\u00010\u0012*\u00020\u0011H\u0007¢\u0006\u0004\bw\u0010[\u001a\u0015\u0010w\u001a\u0004\u0018\u00010\u0014*\u00020\u0013H\u0007¢\u0006\u0004\bw\u0010\\\u001a\u0015\u0010w\u001a\u0004\u0018\u00010\u0016*\u00020\u0015H\u0007¢\u0006\u0004\bw\u0010]\u001a\u0015\u0010w\u001a\u0004\u0018\u00010\u0018*\u00020\u0017H\u0007¢\u0006\u0004\bw\u0010^\u001a\u0015\u0010w\u001a\u0004\u0018\u00010\u001a*\u00020\u0019H\u0007¢\u0006\u0004\bw\u0010_\u001a\u0015\u0010w\u001a\u0004\u0018\u00010\u001e*\u00020\u001dH\u0007¢\u0006\u0004\bw\u0010`\u001aK\u0010x\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\f\"\u000e\b\u0001\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00010C*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00012\u0012\u0010b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010aH\u0087\bø\u0001\u0000¢\u0006\u0004\bx\u0010d\u001a=\u0010x\u001a\u0004\u0018\u00010\u0010\"\u000e\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000C*\u00020\u000f2\u0012\u0010b\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00028\u00000aH\u0087\bø\u0001\u0000¢\u0006\u0004\bx\u0010e\u001a=\u0010x\u001a\u0004\u0018\u00010\u0012\"\u000e\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000C*\u00020\u00112\u0012\u0010b\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00028\u00000aH\u0087\bø\u0001\u0000¢\u0006\u0004\bx\u0010f\u001a=\u0010x\u001a\u0004\u0018\u00010\u0014\"\u000e\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000C*\u00020\u00132\u0012\u0010b\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00028\u00000aH\u0087\bø\u0001\u0000¢\u0006\u0004\bx\u0010g\u001a=\u0010x\u001a\u0004\u0018\u00010\u0016\"\u000e\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000C*\u00020\u00152\u0012\u0010b\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00028\u00000aH\u0087\bø\u0001\u0000¢\u0006\u0004\bx\u0010h\u001a=\u0010x\u001a\u0004\u0018\u00010\u0018\"\u000e\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000C*\u00020\u00172\u0012\u0010b\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00028\u00000aH\u0087\bø\u0001\u0000¢\u0006\u0004\bx\u0010i\u001a=\u0010x\u001a\u0004\u0018\u00010\u001a\"\u000e\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000C*\u00020\u00192\u0012\u0010b\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00028\u00000aH\u0087\bø\u0001\u0000¢\u0006\u0004\bx\u0010j\u001a=\u0010x\u001a\u0004\u0018\u00010\u001c\"\u000e\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000C*\u00020\u001b2\u0012\u0010b\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00028\u00000aH\u0087\bø\u0001\u0000¢\u0006\u0004\bx\u0010k\u001a=\u0010x\u001a\u0004\u0018\u00010\u001e\"\u000e\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000C*\u00020\u001d2\u0012\u0010b\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00028\u00000aH\u0087\bø\u0001\u0000¢\u0006\u0004\bx\u0010l\u001a?\u0010y\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\f*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00012\u001a\u0010\"\u001a\u0016\u0012\u0006\b\u0000\u0012\u00028\u00000 j\n\u0012\u0006\b\u0000\u0012\u00028\u0000`!H\u0007¢\u0006\u0004\by\u0010n\u001a1\u0010y\u001a\u0004\u0018\u00010\u0010*\u00020\u000f2\u001a\u0010\"\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\u00100 j\n\u0012\u0006\b\u0000\u0012\u00020\u0010`!H\u0007¢\u0006\u0004\by\u0010o\u001a1\u0010y\u001a\u0004\u0018\u00010\u0012*\u00020\u00112\u001a\u0010\"\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\u00120 j\n\u0012\u0006\b\u0000\u0012\u00020\u0012`!H\u0007¢\u0006\u0004\by\u0010p\u001a1\u0010y\u001a\u0004\u0018\u00010\u0014*\u00020\u00132\u001a\u0010\"\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\u00140 j\n\u0012\u0006\b\u0000\u0012\u00020\u0014`!H\u0007¢\u0006\u0004\by\u0010q\u001a1\u0010y\u001a\u0004\u0018\u00010\u0016*\u00020\u00152\u001a\u0010\"\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\u00160 j\n\u0012\u0006\b\u0000\u0012\u00020\u0016`!H\u0007¢\u0006\u0004\by\u0010r\u001a1\u0010y\u001a\u0004\u0018\u00010\u0018*\u00020\u00172\u001a\u0010\"\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\u00180 j\n\u0012\u0006\b\u0000\u0012\u00020\u0018`!H\u0007¢\u0006\u0004\by\u0010s\u001a1\u0010y\u001a\u0004\u0018\u00010\u001a*\u00020\u00192\u001a\u0010\"\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\u001a0 j\n\u0012\u0006\b\u0000\u0012\u00020\u001a`!H\u0007¢\u0006\u0004\by\u0010t\u001a1\u0010y\u001a\u0004\u0018\u00010\u001c*\u00020\u001b2\u001a\u0010\"\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\u001c0 j\n\u0012\u0006\b\u0000\u0012\u00020\u001c`!H\u0007¢\u0006\u0004\by\u0010u\u001a1\u0010y\u001a\u0004\u0018\u00010\u001e*\u00020\u001d2\u001a\u0010\"\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\u001e0 j\n\u0012\u0006\b\u0000\u0012\u00020\u001e`!H\u0007¢\u0006\u0004\by\u0010v\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006z"}, d2 = {"R", "", "Ljava/lang/Class;", "klass", "", "filterIsInstance", "([Ljava/lang/Object;Ljava/lang/Class;)Ljava/util/List;", "", "C", "destination", "filterIsInstanceTo", "([Ljava/lang/Object;Ljava/util/Collection;Ljava/lang/Class;)Ljava/util/Collection;", androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "asList", "([Ljava/lang/Object;)Ljava/util/List;", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "element", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "comparator", "fromIndex", "toIndex", "binarySearch", "([Ljava/lang/Object;Ljava/lang/Object;Ljava/util/Comparator;II)I", "([Ljava/lang/Object;Ljava/lang/Object;II)I", "destinationOffset", "startIndex", "endIndex", "copyInto", "([Ljava/lang/Object;[Ljava/lang/Object;III)[Ljava/lang/Object;", "copyOfRange", "([Ljava/lang/Object;II)[Ljava/lang/Object;", "copyOfRangeImpl", "([BII)[B", "([SII)[S", "([III)[I", "([JII)[J", "([FII)[F", "([DII)[D", "([ZII)[Z", "([CII)[C", "", "fill", "([Ljava/lang/Object;Ljava/lang/Object;II)V", "plus", "([Ljava/lang/Object;Ljava/lang/Object;)[Ljava/lang/Object;", "", "elements", "([Ljava/lang/Object;Ljava/util/Collection;)[Ljava/lang/Object;", "([Ljava/lang/Object;[Ljava/lang/Object;)[Ljava/lang/Object;", com.aliyun.svideo.downloader.FileDownloaderModel.SORT, "([Ljava/lang/Object;)V", "", "([Ljava/lang/Comparable;II)V", "([Ljava/lang/Object;II)V", "sortWith", "([Ljava/lang/Object;Ljava/util/Comparator;)V", "([Ljava/lang/Object;Ljava/util/Comparator;II)V", "toTypedArray", "([B)[Ljava/lang/Byte;", "([S)[Ljava/lang/Short;", "([I)[Ljava/lang/Integer;", "([J)[Ljava/lang/Long;", "([F)[Ljava/lang/Float;", "([D)[Ljava/lang/Double;", "([Z)[Ljava/lang/Boolean;", "([C)[Ljava/lang/Character;", "Ljava/util/SortedSet;", "toSortedSet", "([Ljava/lang/Comparable;)Ljava/util/SortedSet;", "([Ljava/lang/Object;Ljava/util/Comparator;)Ljava/util/SortedSet;", org.apache.tools.ant.types.selectors.DepthSelector.MAX_KEY, "([Ljava/lang/Double;)Ljava/lang/Double;", "([Ljava/lang/Float;)Ljava/lang/Float;", "([Ljava/lang/Comparable;)Ljava/lang/Comparable;", "([B)Ljava/lang/Byte;", "([S)Ljava/lang/Short;", "([I)Ljava/lang/Integer;", "([J)Ljava/lang/Long;", "([F)Ljava/lang/Float;", "([D)Ljava/lang/Double;", "([C)Ljava/lang/Character;", "Lkotlin/Function1;", "selector", "maxBy", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "([BLkotlin/jvm/functions/Function1;)Ljava/lang/Byte;", "([SLkotlin/jvm/functions/Function1;)Ljava/lang/Short;", "([ILkotlin/jvm/functions/Function1;)Ljava/lang/Integer;", "([JLkotlin/jvm/functions/Function1;)Ljava/lang/Long;", "([FLkotlin/jvm/functions/Function1;)Ljava/lang/Float;", "([DLkotlin/jvm/functions/Function1;)Ljava/lang/Double;", "([ZLkotlin/jvm/functions/Function1;)Ljava/lang/Boolean;", "([CLkotlin/jvm/functions/Function1;)Ljava/lang/Character;", "maxWith", "([Ljava/lang/Object;Ljava/util/Comparator;)Ljava/lang/Object;", "([BLjava/util/Comparator;)Ljava/lang/Byte;", "([SLjava/util/Comparator;)Ljava/lang/Short;", "([ILjava/util/Comparator;)Ljava/lang/Integer;", "([JLjava/util/Comparator;)Ljava/lang/Long;", "([FLjava/util/Comparator;)Ljava/lang/Float;", "([DLjava/util/Comparator;)Ljava/lang/Double;", "([ZLjava/util/Comparator;)Ljava/lang/Boolean;", "([CLjava/util/Comparator;)Ljava/lang/Character;", org.apache.tools.ant.types.selectors.DepthSelector.MIN_KEY, "minBy", "minWith", "kotlin-stdlib"}, k = 5, mv = {1, 7, 1}, xs = "kotlin/collections/ArraysKt")
/* loaded from: classes14.dex */
public class ArraysKt___ArraysJvmKt extends kotlin.collections.ArraysKt__ArraysKt {
    @org.jetbrains.annotations.NotNull
    public static final java.util.List<java.lang.Byte> asList(@org.jetbrains.annotations.NotNull byte[] bArr) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(bArr, "<this>");
        return new kotlin.collections.ArraysKt___ArraysJvmKt$asList$1(bArr);
    }

    @org.jetbrains.annotations.NotNull
    public static final java.util.List<java.lang.Character> asList(@org.jetbrains.annotations.NotNull char[] cArr) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(cArr, "<this>");
        return new kotlin.collections.ArraysKt___ArraysJvmKt$asList$8(cArr);
    }

    @org.jetbrains.annotations.NotNull
    public static java.util.List<java.lang.Double> asList(@org.jetbrains.annotations.NotNull double[] dArr) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(dArr, "<this>");
        return new kotlin.collections.ArraysKt___ArraysJvmKt$asList$6(dArr);
    }

    @org.jetbrains.annotations.NotNull
    public static final java.util.List<java.lang.Float> asList(@org.jetbrains.annotations.NotNull float[] fArr) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(fArr, "<this>");
        return new kotlin.collections.ArraysKt___ArraysJvmKt$asList$5(fArr);
    }

    @org.jetbrains.annotations.NotNull
    public static java.util.List<java.lang.Integer> asList(@org.jetbrains.annotations.NotNull int[] iArr) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(iArr, "<this>");
        return new kotlin.collections.ArraysKt___ArraysJvmKt$asList$3(iArr);
    }

    @org.jetbrains.annotations.NotNull
    public static java.util.List<java.lang.Long> asList(@org.jetbrains.annotations.NotNull long[] jArr) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(jArr, "<this>");
        return new kotlin.collections.ArraysKt___ArraysJvmKt$asList$4(jArr);
    }

    @org.jetbrains.annotations.NotNull
    public static <T> java.util.List<T> asList(@org.jetbrains.annotations.NotNull T[] tArr) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(tArr, "<this>");
        java.util.List<T> a = kotlin.collections.ArraysUtilJVM.a(tArr);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(a, "asList(this)");
        return a;
    }

    @org.jetbrains.annotations.NotNull
    public static final java.util.List<java.lang.Short> asList(@org.jetbrains.annotations.NotNull short[] sArr) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(sArr, "<this>");
        return new kotlin.collections.ArraysKt___ArraysJvmKt$asList$2(sArr);
    }

    @org.jetbrains.annotations.NotNull
    public static final java.util.List<java.lang.Boolean> asList(@org.jetbrains.annotations.NotNull boolean[] zArr) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(zArr, "<this>");
        return new kotlin.collections.ArraysKt___ArraysJvmKt$asList$7(zArr);
    }

    public static final int binarySearch(@org.jetbrains.annotations.NotNull byte[] bArr, byte b, int i, int i2) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(bArr, "<this>");
        return java.util.Arrays.binarySearch(bArr, i, i2, b);
    }

    public static final int binarySearch(@org.jetbrains.annotations.NotNull char[] cArr, char c, int i, int i2) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(cArr, "<this>");
        return java.util.Arrays.binarySearch(cArr, i, i2, c);
    }

    public static final int binarySearch(@org.jetbrains.annotations.NotNull double[] dArr, double d, int i, int i2) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(dArr, "<this>");
        return java.util.Arrays.binarySearch(dArr, i, i2, d);
    }

    public static final int binarySearch(@org.jetbrains.annotations.NotNull float[] fArr, float f, int i, int i2) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(fArr, "<this>");
        return java.util.Arrays.binarySearch(fArr, i, i2, f);
    }

    public static final int binarySearch(@org.jetbrains.annotations.NotNull int[] iArr, int i, int i2, int i3) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(iArr, "<this>");
        return java.util.Arrays.binarySearch(iArr, i2, i3, i);
    }

    public static final int binarySearch(@org.jetbrains.annotations.NotNull long[] jArr, long j, int i, int i2) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(jArr, "<this>");
        return java.util.Arrays.binarySearch(jArr, i, i2, j);
    }

    public static final <T> int binarySearch(@org.jetbrains.annotations.NotNull T[] tArr, T t, int i, int i2) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(tArr, "<this>");
        return java.util.Arrays.binarySearch(tArr, i, i2, t);
    }

    public static final <T> int binarySearch(@org.jetbrains.annotations.NotNull T[] tArr, T t, @org.jetbrains.annotations.NotNull java.util.Comparator<? super T> comparator, int i, int i2) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(tArr, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(comparator, "comparator");
        return java.util.Arrays.binarySearch(tArr, i, i2, t, comparator);
    }

    public static final int binarySearch(@org.jetbrains.annotations.NotNull short[] sArr, short s2, int i, int i2) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(sArr, "<this>");
        return java.util.Arrays.binarySearch(sArr, i, i2, s2);
    }

    public static /* synthetic */ int binarySearch$default(byte[] bArr, byte b, int i, int i2, int i3, java.lang.Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = bArr.length;
        }
        return binarySearch(bArr, b, i, i2);
    }

    public static /* synthetic */ int binarySearch$default(char[] cArr, char c, int i, int i2, int i3, java.lang.Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = cArr.length;
        }
        return binarySearch(cArr, c, i, i2);
    }

    public static /* synthetic */ int binarySearch$default(double[] dArr, double d, int i, int i2, int i3, java.lang.Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = dArr.length;
        }
        return binarySearch(dArr, d, i, i2);
    }

    public static /* synthetic */ int binarySearch$default(float[] fArr, float f, int i, int i2, int i3, java.lang.Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = fArr.length;
        }
        return binarySearch(fArr, f, i, i2);
    }

    public static /* synthetic */ int binarySearch$default(int[] iArr, int i, int i2, int i3, int i4, java.lang.Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = iArr.length;
        }
        return binarySearch(iArr, i, i2, i3);
    }

    public static /* synthetic */ int binarySearch$default(long[] jArr, long j, int i, int i2, int i3, java.lang.Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = jArr.length;
        }
        return binarySearch(jArr, j, i, i2);
    }

    public static /* synthetic */ int binarySearch$default(java.lang.Object[] objArr, java.lang.Object obj, int i, int i2, int i3, java.lang.Object obj2) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = objArr.length;
        }
        return binarySearch(objArr, obj, i, i2);
    }

    public static /* synthetic */ int binarySearch$default(java.lang.Object[] objArr, java.lang.Object obj, java.util.Comparator comparator, int i, int i2, int i3, java.lang.Object obj2) {
        if ((i3 & 4) != 0) {
            i = 0;
        }
        if ((i3 & 8) != 0) {
            i2 = objArr.length;
        }
        return binarySearch(objArr, obj, comparator, i, i2);
    }

    public static /* synthetic */ int binarySearch$default(short[] sArr, short s2, int i, int i2, int i3, java.lang.Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = sArr.length;
        }
        return binarySearch(sArr, s2, i, i2);
    }

    @kotlin.SinceKotlin(version = "1.3")
    @org.jetbrains.annotations.NotNull
    public static byte[] copyInto(@org.jetbrains.annotations.NotNull byte[] bArr, @org.jetbrains.annotations.NotNull byte[] destination, int i, int i2, int i3) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(bArr, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(destination, "destination");
        java.lang.System.arraycopy(bArr, i2, destination, i, i3 - i2);
        return destination;
    }

    @kotlin.SinceKotlin(version = "1.3")
    @org.jetbrains.annotations.NotNull
    public static final char[] copyInto(@org.jetbrains.annotations.NotNull char[] cArr, @org.jetbrains.annotations.NotNull char[] destination, int i, int i2, int i3) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(cArr, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(destination, "destination");
        java.lang.System.arraycopy(cArr, i2, destination, i, i3 - i2);
        return destination;
    }

    @kotlin.SinceKotlin(version = "1.3")
    @org.jetbrains.annotations.NotNull
    public static final double[] copyInto(@org.jetbrains.annotations.NotNull double[] dArr, @org.jetbrains.annotations.NotNull double[] destination, int i, int i2, int i3) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(dArr, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(destination, "destination");
        java.lang.System.arraycopy(dArr, i2, destination, i, i3 - i2);
        return destination;
    }

    @kotlin.SinceKotlin(version = "1.3")
    @org.jetbrains.annotations.NotNull
    public static final float[] copyInto(@org.jetbrains.annotations.NotNull float[] fArr, @org.jetbrains.annotations.NotNull float[] destination, int i, int i2, int i3) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(fArr, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(destination, "destination");
        java.lang.System.arraycopy(fArr, i2, destination, i, i3 - i2);
        return destination;
    }

    @kotlin.SinceKotlin(version = "1.3")
    @org.jetbrains.annotations.NotNull
    public static final int[] copyInto(@org.jetbrains.annotations.NotNull int[] iArr, @org.jetbrains.annotations.NotNull int[] destination, int i, int i2, int i3) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(iArr, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(destination, "destination");
        java.lang.System.arraycopy(iArr, i2, destination, i, i3 - i2);
        return destination;
    }

    @kotlin.SinceKotlin(version = "1.3")
    @org.jetbrains.annotations.NotNull
    public static final long[] copyInto(@org.jetbrains.annotations.NotNull long[] jArr, @org.jetbrains.annotations.NotNull long[] destination, int i, int i2, int i3) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(jArr, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(destination, "destination");
        java.lang.System.arraycopy(jArr, i2, destination, i, i3 - i2);
        return destination;
    }

    @kotlin.SinceKotlin(version = "1.3")
    @org.jetbrains.annotations.NotNull
    public static <T> T[] copyInto(@org.jetbrains.annotations.NotNull T[] tArr, @org.jetbrains.annotations.NotNull T[] destination, int i, int i2, int i3) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(tArr, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(destination, "destination");
        java.lang.System.arraycopy(tArr, i2, destination, i, i3 - i2);
        return destination;
    }

    @kotlin.SinceKotlin(version = "1.3")
    @org.jetbrains.annotations.NotNull
    public static final short[] copyInto(@org.jetbrains.annotations.NotNull short[] sArr, @org.jetbrains.annotations.NotNull short[] destination, int i, int i2, int i3) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(sArr, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(destination, "destination");
        java.lang.System.arraycopy(sArr, i2, destination, i, i3 - i2);
        return destination;
    }

    @kotlin.SinceKotlin(version = "1.3")
    @org.jetbrains.annotations.NotNull
    public static final boolean[] copyInto(@org.jetbrains.annotations.NotNull boolean[] zArr, @org.jetbrains.annotations.NotNull boolean[] destination, int i, int i2, int i3) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(zArr, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(destination, "destination");
        java.lang.System.arraycopy(zArr, i2, destination, i, i3 - i2);
        return destination;
    }

    public static /* synthetic */ byte[] copyInto$default(byte[] bArr, byte[] bArr2, int i, int i2, int i3, int i4, java.lang.Object obj) {
        if ((i4 & 2) != 0) {
            i = 0;
        }
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = bArr.length;
        }
        return copyInto(bArr, bArr2, i, i2, i3);
    }

    public static /* synthetic */ char[] copyInto$default(char[] cArr, char[] cArr2, int i, int i2, int i3, int i4, java.lang.Object obj) {
        if ((i4 & 2) != 0) {
            i = 0;
        }
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = cArr.length;
        }
        return copyInto(cArr, cArr2, i, i2, i3);
    }

    public static /* synthetic */ double[] copyInto$default(double[] dArr, double[] dArr2, int i, int i2, int i3, int i4, java.lang.Object obj) {
        if ((i4 & 2) != 0) {
            i = 0;
        }
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = dArr.length;
        }
        return copyInto(dArr, dArr2, i, i2, i3);
    }

    public static /* synthetic */ float[] copyInto$default(float[] fArr, float[] fArr2, int i, int i2, int i3, int i4, java.lang.Object obj) {
        if ((i4 & 2) != 0) {
            i = 0;
        }
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = fArr.length;
        }
        return copyInto(fArr, fArr2, i, i2, i3);
    }

    public static /* synthetic */ int[] copyInto$default(int[] iArr, int[] iArr2, int i, int i2, int i3, int i4, java.lang.Object obj) {
        if ((i4 & 2) != 0) {
            i = 0;
        }
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = iArr.length;
        }
        return copyInto(iArr, iArr2, i, i2, i3);
    }

    public static /* synthetic */ long[] copyInto$default(long[] jArr, long[] jArr2, int i, int i2, int i3, int i4, java.lang.Object obj) {
        if ((i4 & 2) != 0) {
            i = 0;
        }
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = jArr.length;
        }
        return copyInto(jArr, jArr2, i, i2, i3);
    }

    public static /* synthetic */ java.lang.Object[] copyInto$default(java.lang.Object[] objArr, java.lang.Object[] objArr2, int i, int i2, int i3, int i4, java.lang.Object obj) {
        if ((i4 & 2) != 0) {
            i = 0;
        }
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = objArr.length;
        }
        return copyInto(objArr, objArr2, i, i2, i3);
    }

    public static /* synthetic */ short[] copyInto$default(short[] sArr, short[] sArr2, int i, int i2, int i3, int i4, java.lang.Object obj) {
        if ((i4 & 2) != 0) {
            i = 0;
        }
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = sArr.length;
        }
        return copyInto(sArr, sArr2, i, i2, i3);
    }

    public static /* synthetic */ boolean[] copyInto$default(boolean[] zArr, boolean[] zArr2, int i, int i2, int i3, int i4, java.lang.Object obj) {
        if ((i4 & 2) != 0) {
            i = 0;
        }
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = zArr.length;
        }
        return copyInto(zArr, zArr2, i, i2, i3);
    }

    @kotlin.SinceKotlin(version = "1.3")
    @kotlin.jvm.JvmName(name = "copyOfRange")
    @org.jetbrains.annotations.NotNull
    @kotlin.PublishedApi
    public static byte[] copyOfRange(@org.jetbrains.annotations.NotNull byte[] bArr, int i, int i2) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(bArr, "<this>");
        kotlin.collections.ArraysKt__ArraysJVMKt.copyOfRangeToIndexCheck(i2, bArr.length);
        byte[] copyOfRange = java.util.Arrays.copyOfRange(bArr, i, i2);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(copyOfRange, "copyOfRange(this, fromIndex, toIndex)");
        return copyOfRange;
    }

    @kotlin.SinceKotlin(version = "1.3")
    @kotlin.jvm.JvmName(name = "copyOfRange")
    @org.jetbrains.annotations.NotNull
    @kotlin.PublishedApi
    public static final char[] copyOfRange(@org.jetbrains.annotations.NotNull char[] cArr, int i, int i2) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(cArr, "<this>");
        kotlin.collections.ArraysKt__ArraysJVMKt.copyOfRangeToIndexCheck(i2, cArr.length);
        char[] copyOfRange = java.util.Arrays.copyOfRange(cArr, i, i2);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(copyOfRange, "copyOfRange(this, fromIndex, toIndex)");
        return copyOfRange;
    }

    @kotlin.SinceKotlin(version = "1.3")
    @kotlin.jvm.JvmName(name = "copyOfRange")
    @org.jetbrains.annotations.NotNull
    @kotlin.PublishedApi
    public static final double[] copyOfRange(@org.jetbrains.annotations.NotNull double[] dArr, int i, int i2) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(dArr, "<this>");
        kotlin.collections.ArraysKt__ArraysJVMKt.copyOfRangeToIndexCheck(i2, dArr.length);
        double[] copyOfRange = java.util.Arrays.copyOfRange(dArr, i, i2);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(copyOfRange, "copyOfRange(this, fromIndex, toIndex)");
        return copyOfRange;
    }

    @kotlin.SinceKotlin(version = "1.3")
    @kotlin.jvm.JvmName(name = "copyOfRange")
    @org.jetbrains.annotations.NotNull
    @kotlin.PublishedApi
    public static final float[] copyOfRange(@org.jetbrains.annotations.NotNull float[] fArr, int i, int i2) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(fArr, "<this>");
        kotlin.collections.ArraysKt__ArraysJVMKt.copyOfRangeToIndexCheck(i2, fArr.length);
        float[] copyOfRange = java.util.Arrays.copyOfRange(fArr, i, i2);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(copyOfRange, "copyOfRange(this, fromIndex, toIndex)");
        return copyOfRange;
    }

    @kotlin.SinceKotlin(version = "1.3")
    @kotlin.jvm.JvmName(name = "copyOfRange")
    @org.jetbrains.annotations.NotNull
    @kotlin.PublishedApi
    public static int[] copyOfRange(@org.jetbrains.annotations.NotNull int[] iArr, int i, int i2) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(iArr, "<this>");
        kotlin.collections.ArraysKt__ArraysJVMKt.copyOfRangeToIndexCheck(i2, iArr.length);
        int[] copyOfRange = java.util.Arrays.copyOfRange(iArr, i, i2);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(copyOfRange, "copyOfRange(this, fromIndex, toIndex)");
        return copyOfRange;
    }

    @kotlin.SinceKotlin(version = "1.3")
    @kotlin.jvm.JvmName(name = "copyOfRange")
    @org.jetbrains.annotations.NotNull
    @kotlin.PublishedApi
    public static long[] copyOfRange(@org.jetbrains.annotations.NotNull long[] jArr, int i, int i2) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(jArr, "<this>");
        kotlin.collections.ArraysKt__ArraysJVMKt.copyOfRangeToIndexCheck(i2, jArr.length);
        long[] copyOfRange = java.util.Arrays.copyOfRange(jArr, i, i2);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(copyOfRange, "copyOfRange(this, fromIndex, toIndex)");
        return copyOfRange;
    }

    @kotlin.SinceKotlin(version = "1.3")
    @kotlin.jvm.JvmName(name = "copyOfRange")
    @org.jetbrains.annotations.NotNull
    @kotlin.PublishedApi
    public static <T> T[] copyOfRange(@org.jetbrains.annotations.NotNull T[] tArr, int i, int i2) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(tArr, "<this>");
        kotlin.collections.ArraysKt__ArraysJVMKt.copyOfRangeToIndexCheck(i2, tArr.length);
        T[] tArr2 = (T[]) java.util.Arrays.copyOfRange(tArr, i, i2);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(tArr2, "copyOfRange(this, fromIndex, toIndex)");
        return tArr2;
    }

    @kotlin.SinceKotlin(version = "1.3")
    @kotlin.jvm.JvmName(name = "copyOfRange")
    @org.jetbrains.annotations.NotNull
    @kotlin.PublishedApi
    public static short[] copyOfRange(@org.jetbrains.annotations.NotNull short[] sArr, int i, int i2) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(sArr, "<this>");
        kotlin.collections.ArraysKt__ArraysJVMKt.copyOfRangeToIndexCheck(i2, sArr.length);
        short[] copyOfRange = java.util.Arrays.copyOfRange(sArr, i, i2);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(copyOfRange, "copyOfRange(this, fromIndex, toIndex)");
        return copyOfRange;
    }

    @kotlin.SinceKotlin(version = "1.3")
    @kotlin.jvm.JvmName(name = "copyOfRange")
    @org.jetbrains.annotations.NotNull
    @kotlin.PublishedApi
    public static final boolean[] copyOfRange(@org.jetbrains.annotations.NotNull boolean[] zArr, int i, int i2) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(zArr, "<this>");
        kotlin.collections.ArraysKt__ArraysJVMKt.copyOfRangeToIndexCheck(i2, zArr.length);
        boolean[] copyOfRange = java.util.Arrays.copyOfRange(zArr, i, i2);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(copyOfRange, "copyOfRange(this, fromIndex, toIndex)");
        return copyOfRange;
    }

    public static void fill(@org.jetbrains.annotations.NotNull byte[] bArr, byte b, int i, int i2) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(bArr, "<this>");
        java.util.Arrays.fill(bArr, i, i2, b);
    }

    public static final void fill(@org.jetbrains.annotations.NotNull char[] cArr, char c, int i, int i2) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(cArr, "<this>");
        java.util.Arrays.fill(cArr, i, i2, c);
    }

    public static final void fill(@org.jetbrains.annotations.NotNull double[] dArr, double d, int i, int i2) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(dArr, "<this>");
        java.util.Arrays.fill(dArr, i, i2, d);
    }

    public static final void fill(@org.jetbrains.annotations.NotNull float[] fArr, float f, int i, int i2) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(fArr, "<this>");
        java.util.Arrays.fill(fArr, i, i2, f);
    }

    public static void fill(@org.jetbrains.annotations.NotNull int[] iArr, int i, int i2, int i3) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(iArr, "<this>");
        java.util.Arrays.fill(iArr, i2, i3, i);
    }

    public static void fill(@org.jetbrains.annotations.NotNull long[] jArr, long j, int i, int i2) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(jArr, "<this>");
        java.util.Arrays.fill(jArr, i, i2, j);
    }

    public static <T> void fill(@org.jetbrains.annotations.NotNull T[] tArr, T t, int i, int i2) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(tArr, "<this>");
        java.util.Arrays.fill(tArr, i, i2, t);
    }

    public static void fill(@org.jetbrains.annotations.NotNull short[] sArr, short s2, int i, int i2) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(sArr, "<this>");
        java.util.Arrays.fill(sArr, i, i2, s2);
    }

    public static final void fill(@org.jetbrains.annotations.NotNull boolean[] zArr, boolean z, int i, int i2) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(zArr, "<this>");
        java.util.Arrays.fill(zArr, i, i2, z);
    }

    public static /* synthetic */ void fill$default(byte[] bArr, byte b, int i, int i2, int i3, java.lang.Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = bArr.length;
        }
        fill(bArr, b, i, i2);
    }

    public static /* synthetic */ void fill$default(char[] cArr, char c, int i, int i2, int i3, java.lang.Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = cArr.length;
        }
        fill(cArr, c, i, i2);
    }

    public static /* synthetic */ void fill$default(double[] dArr, double d, int i, int i2, int i3, java.lang.Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = dArr.length;
        }
        fill(dArr, d, i, i2);
    }

    public static /* synthetic */ void fill$default(float[] fArr, float f, int i, int i2, int i3, java.lang.Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = fArr.length;
        }
        fill(fArr, f, i, i2);
    }

    public static /* synthetic */ void fill$default(int[] iArr, int i, int i2, int i3, int i4, java.lang.Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = iArr.length;
        }
        fill(iArr, i, i2, i3);
    }

    public static /* synthetic */ void fill$default(long[] jArr, long j, int i, int i2, int i3, java.lang.Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = jArr.length;
        }
        fill(jArr, j, i, i2);
    }

    public static /* synthetic */ void fill$default(java.lang.Object[] objArr, java.lang.Object obj, int i, int i2, int i3, java.lang.Object obj2) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = objArr.length;
        }
        fill(objArr, obj, i, i2);
    }

    public static /* synthetic */ void fill$default(short[] sArr, short s2, int i, int i2, int i3, java.lang.Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = sArr.length;
        }
        fill(sArr, s2, i, i2);
    }

    public static /* synthetic */ void fill$default(boolean[] zArr, boolean z, int i, int i2, int i3, java.lang.Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = zArr.length;
        }
        fill(zArr, z, i, i2);
    }

    @org.jetbrains.annotations.NotNull
    public static final <R> java.util.List<R> filterIsInstance(@org.jetbrains.annotations.NotNull java.lang.Object[] objArr, @org.jetbrains.annotations.NotNull java.lang.Class<R> klass) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(objArr, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(klass, "klass");
        return (java.util.List) filterIsInstanceTo(objArr, new java.util.ArrayList(), klass);
    }

    @org.jetbrains.annotations.NotNull
    public static final <C extends java.util.Collection<? super R>, R> C filterIsInstanceTo(@org.jetbrains.annotations.NotNull java.lang.Object[] objArr, @org.jetbrains.annotations.NotNull C destination, @org.jetbrains.annotations.NotNull java.lang.Class<R> klass) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(objArr, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(destination, "destination");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(klass, "klass");
        for (java.lang.Object obj : objArr) {
            if (klass.isInstance(obj)) {
                destination.add(obj);
            }
        }
        return destination;
    }

    @kotlin.Deprecated(message = "Use maxOrNull instead.", replaceWith = @kotlin.ReplaceWith(expression = "this.maxOrNull()", imports = {}))
    @kotlin.DeprecatedSinceKotlin(errorSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5, hiddenSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_6, warningSince = "1.4")
    public static final /* synthetic */ java.lang.Byte max(byte[] bArr) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(bArr, "<this>");
        return kotlin.collections.ArraysKt___ArraysKt.maxOrNull(bArr);
    }

    @kotlin.Deprecated(message = "Use maxOrNull instead.", replaceWith = @kotlin.ReplaceWith(expression = "this.maxOrNull()", imports = {}))
    @kotlin.DeprecatedSinceKotlin(errorSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5, hiddenSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_6, warningSince = "1.4")
    public static final /* synthetic */ java.lang.Character max(char[] cArr) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(cArr, "<this>");
        return kotlin.collections.ArraysKt___ArraysKt.maxOrNull(cArr);
    }

    @kotlin.Deprecated(message = "Use maxOrNull instead.", replaceWith = @kotlin.ReplaceWith(expression = "this.maxOrNull()", imports = {}))
    @kotlin.DeprecatedSinceKotlin(errorSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5, hiddenSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_6, warningSince = "1.4")
    public static final /* synthetic */ java.lang.Comparable max(java.lang.Comparable[] comparableArr) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(comparableArr, "<this>");
        return kotlin.collections.ArraysKt___ArraysKt.maxOrNull(comparableArr);
    }

    @kotlin.Deprecated(message = "Use maxOrNull instead.", replaceWith = @kotlin.ReplaceWith(expression = "this.maxOrNull()", imports = {}))
    @kotlin.DeprecatedSinceKotlin(errorSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5, hiddenSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_6, warningSince = "1.4")
    public static final /* synthetic */ java.lang.Double max(double[] dArr) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(dArr, "<this>");
        return kotlin.collections.ArraysKt___ArraysKt.maxOrNull(dArr);
    }

    @kotlin.Deprecated(message = "Use maxOrNull instead.", replaceWith = @kotlin.ReplaceWith(expression = "this.maxOrNull()", imports = {}))
    @kotlin.SinceKotlin(version = "1.1")
    @kotlin.DeprecatedSinceKotlin(errorSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5, hiddenSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_6, warningSince = "1.4")
    public static final /* synthetic */ java.lang.Double max(java.lang.Double[] dArr) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(dArr, "<this>");
        return kotlin.collections.ArraysKt___ArraysKt.maxOrNull(dArr);
    }

    @kotlin.Deprecated(message = "Use maxOrNull instead.", replaceWith = @kotlin.ReplaceWith(expression = "this.maxOrNull()", imports = {}))
    @kotlin.DeprecatedSinceKotlin(errorSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5, hiddenSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_6, warningSince = "1.4")
    public static final /* synthetic */ java.lang.Float max(float[] fArr) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(fArr, "<this>");
        return kotlin.collections.ArraysKt___ArraysKt.maxOrNull(fArr);
    }

    @kotlin.Deprecated(message = "Use maxOrNull instead.", replaceWith = @kotlin.ReplaceWith(expression = "this.maxOrNull()", imports = {}))
    @kotlin.SinceKotlin(version = "1.1")
    @kotlin.DeprecatedSinceKotlin(errorSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5, hiddenSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_6, warningSince = "1.4")
    public static final /* synthetic */ java.lang.Float max(java.lang.Float[] fArr) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(fArr, "<this>");
        return kotlin.collections.ArraysKt___ArraysKt.maxOrNull(fArr);
    }

    @kotlin.Deprecated(message = "Use maxOrNull instead.", replaceWith = @kotlin.ReplaceWith(expression = "this.maxOrNull()", imports = {}))
    @kotlin.DeprecatedSinceKotlin(errorSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5, hiddenSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_6, warningSince = "1.4")
    public static final /* synthetic */ java.lang.Integer max(int[] iArr) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(iArr, "<this>");
        return kotlin.collections.ArraysKt___ArraysKt.maxOrNull(iArr);
    }

    @kotlin.Deprecated(message = "Use maxOrNull instead.", replaceWith = @kotlin.ReplaceWith(expression = "this.maxOrNull()", imports = {}))
    @kotlin.DeprecatedSinceKotlin(errorSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5, hiddenSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_6, warningSince = "1.4")
    public static final /* synthetic */ java.lang.Long max(long[] jArr) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(jArr, "<this>");
        return kotlin.collections.ArraysKt___ArraysKt.maxOrNull(jArr);
    }

    @kotlin.Deprecated(message = "Use maxOrNull instead.", replaceWith = @kotlin.ReplaceWith(expression = "this.maxOrNull()", imports = {}))
    @kotlin.DeprecatedSinceKotlin(errorSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5, hiddenSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_6, warningSince = "1.4")
    public static final /* synthetic */ java.lang.Short max(short[] sArr) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(sArr, "<this>");
        return kotlin.collections.ArraysKt___ArraysKt.maxOrNull(sArr);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @kotlin.Deprecated(message = "Use maxByOrNull instead.", replaceWith = @kotlin.ReplaceWith(expression = "this.maxByOrNull(selector)", imports = {}))
    @kotlin.DeprecatedSinceKotlin(errorSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5, hiddenSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_6, warningSince = "1.4")
    public static final /* synthetic */ <R extends java.lang.Comparable<? super R>> java.lang.Boolean maxBy(boolean[] zArr, kotlin.jvm.functions.Function1<? super java.lang.Boolean, ? extends R> selector) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(zArr, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(selector, "selector");
        if (zArr.length == 0) {
            return null;
        }
        boolean z = zArr[0];
        int lastIndex = kotlin.collections.ArraysKt___ArraysKt.getLastIndex(zArr);
        if (lastIndex == 0) {
            return java.lang.Boolean.valueOf(z);
        }
        R invoke = selector.invoke(java.lang.Boolean.valueOf(z));
        ?? it = new kotlin.ranges.IntRange(1, lastIndex).iterator();
        while (it.hasNext()) {
            boolean z2 = zArr[it.nextInt()];
            R invoke2 = selector.invoke(java.lang.Boolean.valueOf(z2));
            if (invoke.compareTo(invoke2) < 0) {
                z = z2;
                invoke = invoke2;
            }
        }
        return java.lang.Boolean.valueOf(z);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @kotlin.Deprecated(message = "Use maxByOrNull instead.", replaceWith = @kotlin.ReplaceWith(expression = "this.maxByOrNull(selector)", imports = {}))
    @kotlin.DeprecatedSinceKotlin(errorSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5, hiddenSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_6, warningSince = "1.4")
    public static final /* synthetic */ <R extends java.lang.Comparable<? super R>> java.lang.Byte maxBy(byte[] bArr, kotlin.jvm.functions.Function1<? super java.lang.Byte, ? extends R> selector) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(bArr, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(selector, "selector");
        if (bArr.length == 0) {
            return null;
        }
        byte b = bArr[0];
        int lastIndex = kotlin.collections.ArraysKt___ArraysKt.getLastIndex(bArr);
        if (lastIndex == 0) {
            return java.lang.Byte.valueOf(b);
        }
        R invoke = selector.invoke(java.lang.Byte.valueOf(b));
        ?? it = new kotlin.ranges.IntRange(1, lastIndex).iterator();
        while (it.hasNext()) {
            byte b2 = bArr[it.nextInt()];
            R invoke2 = selector.invoke(java.lang.Byte.valueOf(b2));
            if (invoke.compareTo(invoke2) < 0) {
                b = b2;
                invoke = invoke2;
            }
        }
        return java.lang.Byte.valueOf(b);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @kotlin.Deprecated(message = "Use maxByOrNull instead.", replaceWith = @kotlin.ReplaceWith(expression = "this.maxByOrNull(selector)", imports = {}))
    @kotlin.DeprecatedSinceKotlin(errorSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5, hiddenSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_6, warningSince = "1.4")
    public static final /* synthetic */ <R extends java.lang.Comparable<? super R>> java.lang.Character maxBy(char[] cArr, kotlin.jvm.functions.Function1<? super java.lang.Character, ? extends R> selector) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(cArr, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(selector, "selector");
        if (cArr.length == 0) {
            return null;
        }
        char c = cArr[0];
        int lastIndex = kotlin.collections.ArraysKt___ArraysKt.getLastIndex(cArr);
        if (lastIndex == 0) {
            return java.lang.Character.valueOf(c);
        }
        R invoke = selector.invoke(java.lang.Character.valueOf(c));
        ?? it = new kotlin.ranges.IntRange(1, lastIndex).iterator();
        while (it.hasNext()) {
            char c2 = cArr[it.nextInt()];
            R invoke2 = selector.invoke(java.lang.Character.valueOf(c2));
            if (invoke.compareTo(invoke2) < 0) {
                c = c2;
                invoke = invoke2;
            }
        }
        return java.lang.Character.valueOf(c);
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @kotlin.Deprecated(message = "Use maxByOrNull instead.", replaceWith = @kotlin.ReplaceWith(expression = "this.maxByOrNull(selector)", imports = {}))
    @kotlin.DeprecatedSinceKotlin(errorSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5, hiddenSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_6, warningSince = "1.4")
    public static final /* synthetic */ <R extends java.lang.Comparable<? super R>> java.lang.Double maxBy(double[] dArr, kotlin.jvm.functions.Function1<? super java.lang.Double, ? extends R> selector) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(dArr, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(selector, "selector");
        if (dArr.length == 0) {
            return null;
        }
        double d = dArr[0];
        int lastIndex = kotlin.collections.ArraysKt___ArraysKt.getLastIndex(dArr);
        if (lastIndex == 0) {
            return java.lang.Double.valueOf(d);
        }
        R invoke = selector.invoke(java.lang.Double.valueOf(d));
        ?? it = new kotlin.ranges.IntRange(1, lastIndex).iterator();
        while (it.hasNext()) {
            double d2 = dArr[it.nextInt()];
            R invoke2 = selector.invoke(java.lang.Double.valueOf(d2));
            if (invoke.compareTo(invoke2) < 0) {
                invoke = invoke2;
                d = d2;
            }
        }
        return java.lang.Double.valueOf(d);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @kotlin.Deprecated(message = "Use maxByOrNull instead.", replaceWith = @kotlin.ReplaceWith(expression = "this.maxByOrNull(selector)", imports = {}))
    @kotlin.DeprecatedSinceKotlin(errorSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5, hiddenSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_6, warningSince = "1.4")
    public static final /* synthetic */ <R extends java.lang.Comparable<? super R>> java.lang.Float maxBy(float[] fArr, kotlin.jvm.functions.Function1<? super java.lang.Float, ? extends R> selector) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(fArr, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(selector, "selector");
        if (fArr.length == 0) {
            return null;
        }
        float f = fArr[0];
        int lastIndex = kotlin.collections.ArraysKt___ArraysKt.getLastIndex(fArr);
        if (lastIndex == 0) {
            return java.lang.Float.valueOf(f);
        }
        R invoke = selector.invoke(java.lang.Float.valueOf(f));
        ?? it = new kotlin.ranges.IntRange(1, lastIndex).iterator();
        while (it.hasNext()) {
            float f2 = fArr[it.nextInt()];
            R invoke2 = selector.invoke(java.lang.Float.valueOf(f2));
            if (invoke.compareTo(invoke2) < 0) {
                f = f2;
                invoke = invoke2;
            }
        }
        return java.lang.Float.valueOf(f);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @kotlin.Deprecated(message = "Use maxByOrNull instead.", replaceWith = @kotlin.ReplaceWith(expression = "this.maxByOrNull(selector)", imports = {}))
    @kotlin.DeprecatedSinceKotlin(errorSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5, hiddenSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_6, warningSince = "1.4")
    public static final /* synthetic */ <R extends java.lang.Comparable<? super R>> java.lang.Integer maxBy(int[] iArr, kotlin.jvm.functions.Function1<? super java.lang.Integer, ? extends R> selector) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(iArr, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(selector, "selector");
        if (iArr.length == 0) {
            return null;
        }
        int i = iArr[0];
        int lastIndex = kotlin.collections.ArraysKt___ArraysKt.getLastIndex(iArr);
        if (lastIndex == 0) {
            return java.lang.Integer.valueOf(i);
        }
        R invoke = selector.invoke(java.lang.Integer.valueOf(i));
        ?? it = new kotlin.ranges.IntRange(1, lastIndex).iterator();
        while (it.hasNext()) {
            int i2 = iArr[it.nextInt()];
            R invoke2 = selector.invoke(java.lang.Integer.valueOf(i2));
            if (invoke.compareTo(invoke2) < 0) {
                i = i2;
                invoke = invoke2;
            }
        }
        return java.lang.Integer.valueOf(i);
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @kotlin.Deprecated(message = "Use maxByOrNull instead.", replaceWith = @kotlin.ReplaceWith(expression = "this.maxByOrNull(selector)", imports = {}))
    @kotlin.DeprecatedSinceKotlin(errorSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5, hiddenSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_6, warningSince = "1.4")
    public static final /* synthetic */ <R extends java.lang.Comparable<? super R>> java.lang.Long maxBy(long[] jArr, kotlin.jvm.functions.Function1<? super java.lang.Long, ? extends R> selector) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(jArr, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(selector, "selector");
        if (jArr.length == 0) {
            return null;
        }
        long j = jArr[0];
        int lastIndex = kotlin.collections.ArraysKt___ArraysKt.getLastIndex(jArr);
        if (lastIndex == 0) {
            return java.lang.Long.valueOf(j);
        }
        R invoke = selector.invoke(java.lang.Long.valueOf(j));
        ?? it = new kotlin.ranges.IntRange(1, lastIndex).iterator();
        while (it.hasNext()) {
            long j2 = jArr[it.nextInt()];
            R invoke2 = selector.invoke(java.lang.Long.valueOf(j2));
            if (invoke.compareTo(invoke2) < 0) {
                invoke = invoke2;
                j = j2;
            }
        }
        return java.lang.Long.valueOf(j);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @kotlin.Deprecated(message = "Use maxByOrNull instead.", replaceWith = @kotlin.ReplaceWith(expression = "this.maxByOrNull(selector)", imports = {}))
    @kotlin.DeprecatedSinceKotlin(errorSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5, hiddenSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_6, warningSince = "1.4")
    public static final /* synthetic */ <T, R extends java.lang.Comparable<? super R>> T maxBy(T[] tArr, kotlin.jvm.functions.Function1<? super T, ? extends R> selector) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(tArr, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(selector, "selector");
        if (tArr.length == 0) {
            return null;
        }
        T t = tArr[0];
        int lastIndex = kotlin.collections.ArraysKt___ArraysKt.getLastIndex(tArr);
        if (lastIndex != 0) {
            R invoke = selector.invoke(t);
            ?? it = new kotlin.ranges.IntRange(1, lastIndex).iterator();
            while (it.hasNext()) {
                T t2 = tArr[it.nextInt()];
                R invoke2 = selector.invoke(t2);
                if (invoke.compareTo(invoke2) < 0) {
                    t = t2;
                    invoke = invoke2;
                }
            }
        }
        return t;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @kotlin.Deprecated(message = "Use maxByOrNull instead.", replaceWith = @kotlin.ReplaceWith(expression = "this.maxByOrNull(selector)", imports = {}))
    @kotlin.DeprecatedSinceKotlin(errorSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5, hiddenSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_6, warningSince = "1.4")
    public static final /* synthetic */ <R extends java.lang.Comparable<? super R>> java.lang.Short maxBy(short[] sArr, kotlin.jvm.functions.Function1<? super java.lang.Short, ? extends R> selector) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(sArr, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(selector, "selector");
        if (sArr.length == 0) {
            return null;
        }
        short s2 = sArr[0];
        int lastIndex = kotlin.collections.ArraysKt___ArraysKt.getLastIndex(sArr);
        if (lastIndex == 0) {
            return java.lang.Short.valueOf(s2);
        }
        R invoke = selector.invoke(java.lang.Short.valueOf(s2));
        ?? it = new kotlin.ranges.IntRange(1, lastIndex).iterator();
        while (it.hasNext()) {
            short s3 = sArr[it.nextInt()];
            R invoke2 = selector.invoke(java.lang.Short.valueOf(s3));
            if (invoke.compareTo(invoke2) < 0) {
                s2 = s3;
                invoke = invoke2;
            }
        }
        return java.lang.Short.valueOf(s2);
    }

    @kotlin.Deprecated(message = "Use maxWithOrNull instead.", replaceWith = @kotlin.ReplaceWith(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @kotlin.DeprecatedSinceKotlin(errorSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5, hiddenSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_6, warningSince = "1.4")
    public static final /* synthetic */ java.lang.Boolean maxWith(boolean[] zArr, java.util.Comparator comparator) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(zArr, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(comparator, "comparator");
        return kotlin.collections.ArraysKt___ArraysKt.maxWithOrNull(zArr, (java.util.Comparator<? super java.lang.Boolean>) comparator);
    }

    @kotlin.Deprecated(message = "Use maxWithOrNull instead.", replaceWith = @kotlin.ReplaceWith(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @kotlin.DeprecatedSinceKotlin(errorSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5, hiddenSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_6, warningSince = "1.4")
    public static final /* synthetic */ java.lang.Byte maxWith(byte[] bArr, java.util.Comparator comparator) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(bArr, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(comparator, "comparator");
        return kotlin.collections.ArraysKt___ArraysKt.maxWithOrNull(bArr, (java.util.Comparator<? super java.lang.Byte>) comparator);
    }

    @kotlin.Deprecated(message = "Use maxWithOrNull instead.", replaceWith = @kotlin.ReplaceWith(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @kotlin.DeprecatedSinceKotlin(errorSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5, hiddenSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_6, warningSince = "1.4")
    public static final /* synthetic */ java.lang.Character maxWith(char[] cArr, java.util.Comparator comparator) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(cArr, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(comparator, "comparator");
        return kotlin.collections.ArraysKt___ArraysKt.maxWithOrNull(cArr, (java.util.Comparator<? super java.lang.Character>) comparator);
    }

    @kotlin.Deprecated(message = "Use maxWithOrNull instead.", replaceWith = @kotlin.ReplaceWith(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @kotlin.DeprecatedSinceKotlin(errorSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5, hiddenSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_6, warningSince = "1.4")
    public static final /* synthetic */ java.lang.Double maxWith(double[] dArr, java.util.Comparator comparator) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(dArr, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(comparator, "comparator");
        return kotlin.collections.ArraysKt___ArraysKt.maxWithOrNull(dArr, (java.util.Comparator<? super java.lang.Double>) comparator);
    }

    @kotlin.Deprecated(message = "Use maxWithOrNull instead.", replaceWith = @kotlin.ReplaceWith(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @kotlin.DeprecatedSinceKotlin(errorSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5, hiddenSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_6, warningSince = "1.4")
    public static final /* synthetic */ java.lang.Float maxWith(float[] fArr, java.util.Comparator comparator) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(fArr, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(comparator, "comparator");
        return kotlin.collections.ArraysKt___ArraysKt.maxWithOrNull(fArr, (java.util.Comparator<? super java.lang.Float>) comparator);
    }

    @kotlin.Deprecated(message = "Use maxWithOrNull instead.", replaceWith = @kotlin.ReplaceWith(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @kotlin.DeprecatedSinceKotlin(errorSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5, hiddenSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_6, warningSince = "1.4")
    public static final /* synthetic */ java.lang.Integer maxWith(int[] iArr, java.util.Comparator comparator) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(iArr, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(comparator, "comparator");
        return kotlin.collections.ArraysKt___ArraysKt.maxWithOrNull(iArr, (java.util.Comparator<? super java.lang.Integer>) comparator);
    }

    @kotlin.Deprecated(message = "Use maxWithOrNull instead.", replaceWith = @kotlin.ReplaceWith(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @kotlin.DeprecatedSinceKotlin(errorSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5, hiddenSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_6, warningSince = "1.4")
    public static final /* synthetic */ java.lang.Long maxWith(long[] jArr, java.util.Comparator comparator) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(jArr, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(comparator, "comparator");
        return kotlin.collections.ArraysKt___ArraysKt.maxWithOrNull(jArr, (java.util.Comparator<? super java.lang.Long>) comparator);
    }

    @kotlin.Deprecated(message = "Use maxWithOrNull instead.", replaceWith = @kotlin.ReplaceWith(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @kotlin.DeprecatedSinceKotlin(errorSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5, hiddenSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_6, warningSince = "1.4")
    public static final /* synthetic */ java.lang.Object maxWith(java.lang.Object[] objArr, java.util.Comparator comparator) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(objArr, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(comparator, "comparator");
        return kotlin.collections.ArraysKt___ArraysKt.maxWithOrNull(objArr, comparator);
    }

    @kotlin.Deprecated(message = "Use maxWithOrNull instead.", replaceWith = @kotlin.ReplaceWith(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @kotlin.DeprecatedSinceKotlin(errorSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5, hiddenSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_6, warningSince = "1.4")
    public static final /* synthetic */ java.lang.Short maxWith(short[] sArr, java.util.Comparator comparator) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(sArr, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(comparator, "comparator");
        return kotlin.collections.ArraysKt___ArraysKt.maxWithOrNull(sArr, (java.util.Comparator<? super java.lang.Short>) comparator);
    }

    @kotlin.Deprecated(message = "Use minOrNull instead.", replaceWith = @kotlin.ReplaceWith(expression = "this.minOrNull()", imports = {}))
    @kotlin.DeprecatedSinceKotlin(errorSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5, hiddenSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_6, warningSince = "1.4")
    public static final /* synthetic */ java.lang.Byte min(byte[] bArr) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(bArr, "<this>");
        return kotlin.collections.ArraysKt___ArraysKt.minOrNull(bArr);
    }

    @kotlin.Deprecated(message = "Use minOrNull instead.", replaceWith = @kotlin.ReplaceWith(expression = "this.minOrNull()", imports = {}))
    @kotlin.DeprecatedSinceKotlin(errorSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5, hiddenSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_6, warningSince = "1.4")
    public static final /* synthetic */ java.lang.Character min(char[] cArr) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(cArr, "<this>");
        return kotlin.collections.ArraysKt___ArraysKt.minOrNull(cArr);
    }

    @kotlin.Deprecated(message = "Use minOrNull instead.", replaceWith = @kotlin.ReplaceWith(expression = "this.minOrNull()", imports = {}))
    @kotlin.DeprecatedSinceKotlin(errorSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5, hiddenSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_6, warningSince = "1.4")
    public static final /* synthetic */ java.lang.Comparable min(java.lang.Comparable[] comparableArr) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(comparableArr, "<this>");
        return kotlin.collections.ArraysKt___ArraysKt.minOrNull(comparableArr);
    }

    @kotlin.Deprecated(message = "Use minOrNull instead.", replaceWith = @kotlin.ReplaceWith(expression = "this.minOrNull()", imports = {}))
    @kotlin.DeprecatedSinceKotlin(errorSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5, hiddenSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_6, warningSince = "1.4")
    public static final /* synthetic */ java.lang.Double min(double[] dArr) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(dArr, "<this>");
        return kotlin.collections.ArraysKt___ArraysKt.minOrNull(dArr);
    }

    @kotlin.Deprecated(message = "Use minOrNull instead.", replaceWith = @kotlin.ReplaceWith(expression = "this.minOrNull()", imports = {}))
    @kotlin.SinceKotlin(version = "1.1")
    @kotlin.DeprecatedSinceKotlin(errorSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5, hiddenSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_6, warningSince = "1.4")
    public static final /* synthetic */ java.lang.Double min(java.lang.Double[] dArr) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(dArr, "<this>");
        return kotlin.collections.ArraysKt___ArraysKt.minOrNull(dArr);
    }

    @kotlin.Deprecated(message = "Use minOrNull instead.", replaceWith = @kotlin.ReplaceWith(expression = "this.minOrNull()", imports = {}))
    @kotlin.DeprecatedSinceKotlin(errorSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5, hiddenSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_6, warningSince = "1.4")
    public static final /* synthetic */ java.lang.Float min(float[] fArr) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(fArr, "<this>");
        return kotlin.collections.ArraysKt___ArraysKt.minOrNull(fArr);
    }

    @kotlin.Deprecated(message = "Use minOrNull instead.", replaceWith = @kotlin.ReplaceWith(expression = "this.minOrNull()", imports = {}))
    @kotlin.SinceKotlin(version = "1.1")
    @kotlin.DeprecatedSinceKotlin(errorSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5, hiddenSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_6, warningSince = "1.4")
    public static final /* synthetic */ java.lang.Float min(java.lang.Float[] fArr) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(fArr, "<this>");
        return kotlin.collections.ArraysKt___ArraysKt.minOrNull(fArr);
    }

    @kotlin.Deprecated(message = "Use minOrNull instead.", replaceWith = @kotlin.ReplaceWith(expression = "this.minOrNull()", imports = {}))
    @kotlin.DeprecatedSinceKotlin(errorSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5, hiddenSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_6, warningSince = "1.4")
    public static final /* synthetic */ java.lang.Integer min(int[] iArr) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(iArr, "<this>");
        return kotlin.collections.ArraysKt___ArraysKt.minOrNull(iArr);
    }

    @kotlin.Deprecated(message = "Use minOrNull instead.", replaceWith = @kotlin.ReplaceWith(expression = "this.minOrNull()", imports = {}))
    @kotlin.DeprecatedSinceKotlin(errorSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5, hiddenSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_6, warningSince = "1.4")
    public static final /* synthetic */ java.lang.Long min(long[] jArr) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(jArr, "<this>");
        return kotlin.collections.ArraysKt___ArraysKt.minOrNull(jArr);
    }

    @kotlin.Deprecated(message = "Use minOrNull instead.", replaceWith = @kotlin.ReplaceWith(expression = "this.minOrNull()", imports = {}))
    @kotlin.DeprecatedSinceKotlin(errorSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5, hiddenSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_6, warningSince = "1.4")
    public static final /* synthetic */ java.lang.Short min(short[] sArr) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(sArr, "<this>");
        return kotlin.collections.ArraysKt___ArraysKt.minOrNull(sArr);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @kotlin.Deprecated(message = "Use minByOrNull instead.", replaceWith = @kotlin.ReplaceWith(expression = "this.minByOrNull(selector)", imports = {}))
    @kotlin.DeprecatedSinceKotlin(errorSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5, hiddenSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_6, warningSince = "1.4")
    public static final /* synthetic */ <R extends java.lang.Comparable<? super R>> java.lang.Boolean minBy(boolean[] zArr, kotlin.jvm.functions.Function1<? super java.lang.Boolean, ? extends R> selector) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(zArr, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(selector, "selector");
        if (zArr.length == 0) {
            return null;
        }
        boolean z = zArr[0];
        int lastIndex = kotlin.collections.ArraysKt___ArraysKt.getLastIndex(zArr);
        if (lastIndex == 0) {
            return java.lang.Boolean.valueOf(z);
        }
        R invoke = selector.invoke(java.lang.Boolean.valueOf(z));
        ?? it = new kotlin.ranges.IntRange(1, lastIndex).iterator();
        while (it.hasNext()) {
            boolean z2 = zArr[it.nextInt()];
            R invoke2 = selector.invoke(java.lang.Boolean.valueOf(z2));
            if (invoke.compareTo(invoke2) > 0) {
                z = z2;
                invoke = invoke2;
            }
        }
        return java.lang.Boolean.valueOf(z);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @kotlin.Deprecated(message = "Use minByOrNull instead.", replaceWith = @kotlin.ReplaceWith(expression = "this.minByOrNull(selector)", imports = {}))
    @kotlin.DeprecatedSinceKotlin(errorSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5, hiddenSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_6, warningSince = "1.4")
    public static final /* synthetic */ <R extends java.lang.Comparable<? super R>> java.lang.Byte minBy(byte[] bArr, kotlin.jvm.functions.Function1<? super java.lang.Byte, ? extends R> selector) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(bArr, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(selector, "selector");
        if (bArr.length == 0) {
            return null;
        }
        byte b = bArr[0];
        int lastIndex = kotlin.collections.ArraysKt___ArraysKt.getLastIndex(bArr);
        if (lastIndex == 0) {
            return java.lang.Byte.valueOf(b);
        }
        R invoke = selector.invoke(java.lang.Byte.valueOf(b));
        ?? it = new kotlin.ranges.IntRange(1, lastIndex).iterator();
        while (it.hasNext()) {
            byte b2 = bArr[it.nextInt()];
            R invoke2 = selector.invoke(java.lang.Byte.valueOf(b2));
            if (invoke.compareTo(invoke2) > 0) {
                b = b2;
                invoke = invoke2;
            }
        }
        return java.lang.Byte.valueOf(b);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @kotlin.Deprecated(message = "Use minByOrNull instead.", replaceWith = @kotlin.ReplaceWith(expression = "this.minByOrNull(selector)", imports = {}))
    @kotlin.DeprecatedSinceKotlin(errorSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5, hiddenSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_6, warningSince = "1.4")
    public static final /* synthetic */ <R extends java.lang.Comparable<? super R>> java.lang.Character minBy(char[] cArr, kotlin.jvm.functions.Function1<? super java.lang.Character, ? extends R> selector) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(cArr, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(selector, "selector");
        if (cArr.length == 0) {
            return null;
        }
        char c = cArr[0];
        int lastIndex = kotlin.collections.ArraysKt___ArraysKt.getLastIndex(cArr);
        if (lastIndex == 0) {
            return java.lang.Character.valueOf(c);
        }
        R invoke = selector.invoke(java.lang.Character.valueOf(c));
        ?? it = new kotlin.ranges.IntRange(1, lastIndex).iterator();
        while (it.hasNext()) {
            char c2 = cArr[it.nextInt()];
            R invoke2 = selector.invoke(java.lang.Character.valueOf(c2));
            if (invoke.compareTo(invoke2) > 0) {
                c = c2;
                invoke = invoke2;
            }
        }
        return java.lang.Character.valueOf(c);
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @kotlin.Deprecated(message = "Use minByOrNull instead.", replaceWith = @kotlin.ReplaceWith(expression = "this.minByOrNull(selector)", imports = {}))
    @kotlin.DeprecatedSinceKotlin(errorSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5, hiddenSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_6, warningSince = "1.4")
    public static final /* synthetic */ <R extends java.lang.Comparable<? super R>> java.lang.Double minBy(double[] dArr, kotlin.jvm.functions.Function1<? super java.lang.Double, ? extends R> selector) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(dArr, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(selector, "selector");
        if (dArr.length == 0) {
            return null;
        }
        double d = dArr[0];
        int lastIndex = kotlin.collections.ArraysKt___ArraysKt.getLastIndex(dArr);
        if (lastIndex == 0) {
            return java.lang.Double.valueOf(d);
        }
        R invoke = selector.invoke(java.lang.Double.valueOf(d));
        ?? it = new kotlin.ranges.IntRange(1, lastIndex).iterator();
        while (it.hasNext()) {
            double d2 = dArr[it.nextInt()];
            R invoke2 = selector.invoke(java.lang.Double.valueOf(d2));
            if (invoke.compareTo(invoke2) > 0) {
                invoke = invoke2;
                d = d2;
            }
        }
        return java.lang.Double.valueOf(d);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @kotlin.Deprecated(message = "Use minByOrNull instead.", replaceWith = @kotlin.ReplaceWith(expression = "this.minByOrNull(selector)", imports = {}))
    @kotlin.DeprecatedSinceKotlin(errorSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5, hiddenSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_6, warningSince = "1.4")
    public static final /* synthetic */ <R extends java.lang.Comparable<? super R>> java.lang.Float minBy(float[] fArr, kotlin.jvm.functions.Function1<? super java.lang.Float, ? extends R> selector) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(fArr, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(selector, "selector");
        if (fArr.length == 0) {
            return null;
        }
        float f = fArr[0];
        int lastIndex = kotlin.collections.ArraysKt___ArraysKt.getLastIndex(fArr);
        if (lastIndex == 0) {
            return java.lang.Float.valueOf(f);
        }
        R invoke = selector.invoke(java.lang.Float.valueOf(f));
        ?? it = new kotlin.ranges.IntRange(1, lastIndex).iterator();
        while (it.hasNext()) {
            float f2 = fArr[it.nextInt()];
            R invoke2 = selector.invoke(java.lang.Float.valueOf(f2));
            if (invoke.compareTo(invoke2) > 0) {
                f = f2;
                invoke = invoke2;
            }
        }
        return java.lang.Float.valueOf(f);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @kotlin.Deprecated(message = "Use minByOrNull instead.", replaceWith = @kotlin.ReplaceWith(expression = "this.minByOrNull(selector)", imports = {}))
    @kotlin.DeprecatedSinceKotlin(errorSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5, hiddenSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_6, warningSince = "1.4")
    public static final /* synthetic */ <R extends java.lang.Comparable<? super R>> java.lang.Integer minBy(int[] iArr, kotlin.jvm.functions.Function1<? super java.lang.Integer, ? extends R> selector) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(iArr, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(selector, "selector");
        if (iArr.length == 0) {
            return null;
        }
        int i = iArr[0];
        int lastIndex = kotlin.collections.ArraysKt___ArraysKt.getLastIndex(iArr);
        if (lastIndex == 0) {
            return java.lang.Integer.valueOf(i);
        }
        R invoke = selector.invoke(java.lang.Integer.valueOf(i));
        ?? it = new kotlin.ranges.IntRange(1, lastIndex).iterator();
        while (it.hasNext()) {
            int i2 = iArr[it.nextInt()];
            R invoke2 = selector.invoke(java.lang.Integer.valueOf(i2));
            if (invoke.compareTo(invoke2) > 0) {
                i = i2;
                invoke = invoke2;
            }
        }
        return java.lang.Integer.valueOf(i);
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @kotlin.Deprecated(message = "Use minByOrNull instead.", replaceWith = @kotlin.ReplaceWith(expression = "this.minByOrNull(selector)", imports = {}))
    @kotlin.DeprecatedSinceKotlin(errorSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5, hiddenSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_6, warningSince = "1.4")
    public static final /* synthetic */ <R extends java.lang.Comparable<? super R>> java.lang.Long minBy(long[] jArr, kotlin.jvm.functions.Function1<? super java.lang.Long, ? extends R> selector) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(jArr, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(selector, "selector");
        if (jArr.length == 0) {
            return null;
        }
        long j = jArr[0];
        int lastIndex = kotlin.collections.ArraysKt___ArraysKt.getLastIndex(jArr);
        if (lastIndex == 0) {
            return java.lang.Long.valueOf(j);
        }
        R invoke = selector.invoke(java.lang.Long.valueOf(j));
        ?? it = new kotlin.ranges.IntRange(1, lastIndex).iterator();
        while (it.hasNext()) {
            long j2 = jArr[it.nextInt()];
            R invoke2 = selector.invoke(java.lang.Long.valueOf(j2));
            if (invoke.compareTo(invoke2) > 0) {
                invoke = invoke2;
                j = j2;
            }
        }
        return java.lang.Long.valueOf(j);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @kotlin.Deprecated(message = "Use minByOrNull instead.", replaceWith = @kotlin.ReplaceWith(expression = "this.minByOrNull(selector)", imports = {}))
    @kotlin.DeprecatedSinceKotlin(errorSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5, hiddenSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_6, warningSince = "1.4")
    public static final /* synthetic */ <T, R extends java.lang.Comparable<? super R>> T minBy(T[] tArr, kotlin.jvm.functions.Function1<? super T, ? extends R> selector) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(tArr, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(selector, "selector");
        if (tArr.length == 0) {
            return null;
        }
        T t = tArr[0];
        int lastIndex = kotlin.collections.ArraysKt___ArraysKt.getLastIndex(tArr);
        if (lastIndex != 0) {
            R invoke = selector.invoke(t);
            ?? it = new kotlin.ranges.IntRange(1, lastIndex).iterator();
            while (it.hasNext()) {
                T t2 = tArr[it.nextInt()];
                R invoke2 = selector.invoke(t2);
                if (invoke.compareTo(invoke2) > 0) {
                    t = t2;
                    invoke = invoke2;
                }
            }
        }
        return t;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @kotlin.Deprecated(message = "Use minByOrNull instead.", replaceWith = @kotlin.ReplaceWith(expression = "this.minByOrNull(selector)", imports = {}))
    @kotlin.DeprecatedSinceKotlin(errorSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5, hiddenSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_6, warningSince = "1.4")
    public static final /* synthetic */ <R extends java.lang.Comparable<? super R>> java.lang.Short minBy(short[] sArr, kotlin.jvm.functions.Function1<? super java.lang.Short, ? extends R> selector) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(sArr, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(selector, "selector");
        if (sArr.length == 0) {
            return null;
        }
        short s2 = sArr[0];
        int lastIndex = kotlin.collections.ArraysKt___ArraysKt.getLastIndex(sArr);
        if (lastIndex == 0) {
            return java.lang.Short.valueOf(s2);
        }
        R invoke = selector.invoke(java.lang.Short.valueOf(s2));
        ?? it = new kotlin.ranges.IntRange(1, lastIndex).iterator();
        while (it.hasNext()) {
            short s3 = sArr[it.nextInt()];
            R invoke2 = selector.invoke(java.lang.Short.valueOf(s3));
            if (invoke.compareTo(invoke2) > 0) {
                s2 = s3;
                invoke = invoke2;
            }
        }
        return java.lang.Short.valueOf(s2);
    }

    @kotlin.Deprecated(message = "Use minWithOrNull instead.", replaceWith = @kotlin.ReplaceWith(expression = "this.minWithOrNull(comparator)", imports = {}))
    @kotlin.DeprecatedSinceKotlin(errorSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5, hiddenSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_6, warningSince = "1.4")
    public static final /* synthetic */ java.lang.Boolean minWith(boolean[] zArr, java.util.Comparator comparator) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(zArr, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(comparator, "comparator");
        return kotlin.collections.ArraysKt___ArraysKt.minWithOrNull(zArr, (java.util.Comparator<? super java.lang.Boolean>) comparator);
    }

    @kotlin.Deprecated(message = "Use minWithOrNull instead.", replaceWith = @kotlin.ReplaceWith(expression = "this.minWithOrNull(comparator)", imports = {}))
    @kotlin.DeprecatedSinceKotlin(errorSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5, hiddenSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_6, warningSince = "1.4")
    public static final /* synthetic */ java.lang.Byte minWith(byte[] bArr, java.util.Comparator comparator) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(bArr, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(comparator, "comparator");
        return kotlin.collections.ArraysKt___ArraysKt.minWithOrNull(bArr, (java.util.Comparator<? super java.lang.Byte>) comparator);
    }

    @kotlin.Deprecated(message = "Use minWithOrNull instead.", replaceWith = @kotlin.ReplaceWith(expression = "this.minWithOrNull(comparator)", imports = {}))
    @kotlin.DeprecatedSinceKotlin(errorSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5, hiddenSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_6, warningSince = "1.4")
    public static final /* synthetic */ java.lang.Character minWith(char[] cArr, java.util.Comparator comparator) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(cArr, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(comparator, "comparator");
        return kotlin.collections.ArraysKt___ArraysKt.minWithOrNull(cArr, (java.util.Comparator<? super java.lang.Character>) comparator);
    }

    @kotlin.Deprecated(message = "Use minWithOrNull instead.", replaceWith = @kotlin.ReplaceWith(expression = "this.minWithOrNull(comparator)", imports = {}))
    @kotlin.DeprecatedSinceKotlin(errorSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5, hiddenSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_6, warningSince = "1.4")
    public static final /* synthetic */ java.lang.Double minWith(double[] dArr, java.util.Comparator comparator) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(dArr, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(comparator, "comparator");
        return kotlin.collections.ArraysKt___ArraysKt.minWithOrNull(dArr, (java.util.Comparator<? super java.lang.Double>) comparator);
    }

    @kotlin.Deprecated(message = "Use minWithOrNull instead.", replaceWith = @kotlin.ReplaceWith(expression = "this.minWithOrNull(comparator)", imports = {}))
    @kotlin.DeprecatedSinceKotlin(errorSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5, hiddenSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_6, warningSince = "1.4")
    public static final /* synthetic */ java.lang.Float minWith(float[] fArr, java.util.Comparator comparator) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(fArr, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(comparator, "comparator");
        return kotlin.collections.ArraysKt___ArraysKt.minWithOrNull(fArr, (java.util.Comparator<? super java.lang.Float>) comparator);
    }

    @kotlin.Deprecated(message = "Use minWithOrNull instead.", replaceWith = @kotlin.ReplaceWith(expression = "this.minWithOrNull(comparator)", imports = {}))
    @kotlin.DeprecatedSinceKotlin(errorSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5, hiddenSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_6, warningSince = "1.4")
    public static final /* synthetic */ java.lang.Integer minWith(int[] iArr, java.util.Comparator comparator) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(iArr, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(comparator, "comparator");
        return kotlin.collections.ArraysKt___ArraysKt.minWithOrNull(iArr, (java.util.Comparator<? super java.lang.Integer>) comparator);
    }

    @kotlin.Deprecated(message = "Use minWithOrNull instead.", replaceWith = @kotlin.ReplaceWith(expression = "this.minWithOrNull(comparator)", imports = {}))
    @kotlin.DeprecatedSinceKotlin(errorSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5, hiddenSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_6, warningSince = "1.4")
    public static final /* synthetic */ java.lang.Long minWith(long[] jArr, java.util.Comparator comparator) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(jArr, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(comparator, "comparator");
        return kotlin.collections.ArraysKt___ArraysKt.minWithOrNull(jArr, (java.util.Comparator<? super java.lang.Long>) comparator);
    }

    @kotlin.Deprecated(message = "Use minWithOrNull instead.", replaceWith = @kotlin.ReplaceWith(expression = "this.minWithOrNull(comparator)", imports = {}))
    @kotlin.DeprecatedSinceKotlin(errorSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5, hiddenSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_6, warningSince = "1.4")
    public static final /* synthetic */ java.lang.Object minWith(java.lang.Object[] objArr, java.util.Comparator comparator) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(objArr, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(comparator, "comparator");
        return kotlin.collections.ArraysKt___ArraysKt.minWithOrNull(objArr, comparator);
    }

    @kotlin.Deprecated(message = "Use minWithOrNull instead.", replaceWith = @kotlin.ReplaceWith(expression = "this.minWithOrNull(comparator)", imports = {}))
    @kotlin.DeprecatedSinceKotlin(errorSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5, hiddenSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_6, warningSince = "1.4")
    public static final /* synthetic */ java.lang.Short minWith(short[] sArr, java.util.Comparator comparator) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(sArr, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(comparator, "comparator");
        return kotlin.collections.ArraysKt___ArraysKt.minWithOrNull(sArr, (java.util.Comparator<? super java.lang.Short>) comparator);
    }

    @org.jetbrains.annotations.NotNull
    public static final byte[] plus(@org.jetbrains.annotations.NotNull byte[] bArr, byte b) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(bArr, "<this>");
        int length = bArr.length;
        byte[] result = java.util.Arrays.copyOf(bArr, length + 1);
        result[length] = b;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(result, "result");
        return result;
    }

    @org.jetbrains.annotations.NotNull
    public static final byte[] plus(@org.jetbrains.annotations.NotNull byte[] bArr, @org.jetbrains.annotations.NotNull java.util.Collection<java.lang.Byte> elements) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(bArr, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(elements, "elements");
        int length = bArr.length;
        byte[] result = java.util.Arrays.copyOf(bArr, elements.size() + length);
        java.util.Iterator<java.lang.Byte> it = elements.iterator();
        while (it.hasNext()) {
            result[length] = it.next().byteValue();
            length++;
        }
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(result, "result");
        return result;
    }

    @org.jetbrains.annotations.NotNull
    public static final byte[] plus(@org.jetbrains.annotations.NotNull byte[] bArr, @org.jetbrains.annotations.NotNull byte[] elements) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(bArr, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(elements, "elements");
        int length = bArr.length;
        int length2 = elements.length;
        byte[] result = java.util.Arrays.copyOf(bArr, length + length2);
        java.lang.System.arraycopy(elements, 0, result, length, length2);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(result, "result");
        return result;
    }

    @org.jetbrains.annotations.NotNull
    public static final char[] plus(@org.jetbrains.annotations.NotNull char[] cArr, char c) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(cArr, "<this>");
        int length = cArr.length;
        char[] result = java.util.Arrays.copyOf(cArr, length + 1);
        result[length] = c;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(result, "result");
        return result;
    }

    @org.jetbrains.annotations.NotNull
    public static final char[] plus(@org.jetbrains.annotations.NotNull char[] cArr, @org.jetbrains.annotations.NotNull java.util.Collection<java.lang.Character> elements) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(cArr, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(elements, "elements");
        int length = cArr.length;
        char[] result = java.util.Arrays.copyOf(cArr, elements.size() + length);
        java.util.Iterator<java.lang.Character> it = elements.iterator();
        while (it.hasNext()) {
            result[length] = it.next().charValue();
            length++;
        }
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(result, "result");
        return result;
    }

    @org.jetbrains.annotations.NotNull
    public static final char[] plus(@org.jetbrains.annotations.NotNull char[] cArr, @org.jetbrains.annotations.NotNull char[] elements) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(cArr, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(elements, "elements");
        int length = cArr.length;
        int length2 = elements.length;
        char[] result = java.util.Arrays.copyOf(cArr, length + length2);
        java.lang.System.arraycopy(elements, 0, result, length, length2);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(result, "result");
        return result;
    }

    @org.jetbrains.annotations.NotNull
    public static final double[] plus(@org.jetbrains.annotations.NotNull double[] dArr, double d) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(dArr, "<this>");
        int length = dArr.length;
        double[] result = java.util.Arrays.copyOf(dArr, length + 1);
        result[length] = d;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(result, "result");
        return result;
    }

    @org.jetbrains.annotations.NotNull
    public static final double[] plus(@org.jetbrains.annotations.NotNull double[] dArr, @org.jetbrains.annotations.NotNull java.util.Collection<java.lang.Double> elements) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(dArr, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(elements, "elements");
        int length = dArr.length;
        double[] result = java.util.Arrays.copyOf(dArr, elements.size() + length);
        java.util.Iterator<java.lang.Double> it = elements.iterator();
        while (it.hasNext()) {
            result[length] = it.next().doubleValue();
            length++;
        }
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(result, "result");
        return result;
    }

    @org.jetbrains.annotations.NotNull
    public static final double[] plus(@org.jetbrains.annotations.NotNull double[] dArr, @org.jetbrains.annotations.NotNull double[] elements) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(dArr, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(elements, "elements");
        int length = dArr.length;
        int length2 = elements.length;
        double[] result = java.util.Arrays.copyOf(dArr, length + length2);
        java.lang.System.arraycopy(elements, 0, result, length, length2);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(result, "result");
        return result;
    }

    @org.jetbrains.annotations.NotNull
    public static final float[] plus(@org.jetbrains.annotations.NotNull float[] fArr, float f) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(fArr, "<this>");
        int length = fArr.length;
        float[] result = java.util.Arrays.copyOf(fArr, length + 1);
        result[length] = f;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(result, "result");
        return result;
    }

    @org.jetbrains.annotations.NotNull
    public static final float[] plus(@org.jetbrains.annotations.NotNull float[] fArr, @org.jetbrains.annotations.NotNull java.util.Collection<java.lang.Float> elements) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(fArr, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(elements, "elements");
        int length = fArr.length;
        float[] result = java.util.Arrays.copyOf(fArr, elements.size() + length);
        java.util.Iterator<java.lang.Float> it = elements.iterator();
        while (it.hasNext()) {
            result[length] = it.next().floatValue();
            length++;
        }
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(result, "result");
        return result;
    }

    @org.jetbrains.annotations.NotNull
    public static final float[] plus(@org.jetbrains.annotations.NotNull float[] fArr, @org.jetbrains.annotations.NotNull float[] elements) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(fArr, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(elements, "elements");
        int length = fArr.length;
        int length2 = elements.length;
        float[] result = java.util.Arrays.copyOf(fArr, length + length2);
        java.lang.System.arraycopy(elements, 0, result, length, length2);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(result, "result");
        return result;
    }

    @org.jetbrains.annotations.NotNull
    public static final int[] plus(@org.jetbrains.annotations.NotNull int[] iArr, int i) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(iArr, "<this>");
        int length = iArr.length;
        int[] result = java.util.Arrays.copyOf(iArr, length + 1);
        result[length] = i;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(result, "result");
        return result;
    }

    @org.jetbrains.annotations.NotNull
    public static final int[] plus(@org.jetbrains.annotations.NotNull int[] iArr, @org.jetbrains.annotations.NotNull java.util.Collection<java.lang.Integer> elements) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(iArr, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(elements, "elements");
        int length = iArr.length;
        int[] result = java.util.Arrays.copyOf(iArr, elements.size() + length);
        java.util.Iterator<java.lang.Integer> it = elements.iterator();
        while (it.hasNext()) {
            result[length] = it.next().intValue();
            length++;
        }
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(result, "result");
        return result;
    }

    @org.jetbrains.annotations.NotNull
    public static final int[] plus(@org.jetbrains.annotations.NotNull int[] iArr, @org.jetbrains.annotations.NotNull int[] elements) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(iArr, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(elements, "elements");
        int length = iArr.length;
        int length2 = elements.length;
        int[] result = java.util.Arrays.copyOf(iArr, length + length2);
        java.lang.System.arraycopy(elements, 0, result, length, length2);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(result, "result");
        return result;
    }

    @org.jetbrains.annotations.NotNull
    public static final long[] plus(@org.jetbrains.annotations.NotNull long[] jArr, long j) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(jArr, "<this>");
        int length = jArr.length;
        long[] result = java.util.Arrays.copyOf(jArr, length + 1);
        result[length] = j;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(result, "result");
        return result;
    }

    @org.jetbrains.annotations.NotNull
    public static final long[] plus(@org.jetbrains.annotations.NotNull long[] jArr, @org.jetbrains.annotations.NotNull java.util.Collection<java.lang.Long> elements) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(jArr, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(elements, "elements");
        int length = jArr.length;
        long[] result = java.util.Arrays.copyOf(jArr, elements.size() + length);
        java.util.Iterator<java.lang.Long> it = elements.iterator();
        while (it.hasNext()) {
            result[length] = it.next().longValue();
            length++;
        }
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(result, "result");
        return result;
    }

    @org.jetbrains.annotations.NotNull
    public static final long[] plus(@org.jetbrains.annotations.NotNull long[] jArr, @org.jetbrains.annotations.NotNull long[] elements) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(jArr, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(elements, "elements");
        int length = jArr.length;
        int length2 = elements.length;
        long[] result = java.util.Arrays.copyOf(jArr, length + length2);
        java.lang.System.arraycopy(elements, 0, result, length, length2);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(result, "result");
        return result;
    }

    @org.jetbrains.annotations.NotNull
    public static <T> T[] plus(@org.jetbrains.annotations.NotNull T[] tArr, T t) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(tArr, "<this>");
        int length = tArr.length;
        T[] result = (T[]) java.util.Arrays.copyOf(tArr, length + 1);
        result[length] = t;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(result, "result");
        return result;
    }

    @org.jetbrains.annotations.NotNull
    public static final <T> T[] plus(@org.jetbrains.annotations.NotNull T[] tArr, @org.jetbrains.annotations.NotNull java.util.Collection<? extends T> elements) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(tArr, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(elements, "elements");
        int length = tArr.length;
        T[] result = (T[]) java.util.Arrays.copyOf(tArr, elements.size() + length);
        java.util.Iterator<? extends T> it = elements.iterator();
        while (it.hasNext()) {
            result[length] = it.next();
            length++;
        }
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(result, "result");
        return result;
    }

    @org.jetbrains.annotations.NotNull
    public static final <T> T[] plus(@org.jetbrains.annotations.NotNull T[] tArr, @org.jetbrains.annotations.NotNull T[] elements) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(tArr, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(elements, "elements");
        int length = tArr.length;
        int length2 = elements.length;
        T[] result = (T[]) java.util.Arrays.copyOf(tArr, length + length2);
        java.lang.System.arraycopy(elements, 0, result, length, length2);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(result, "result");
        return result;
    }

    @org.jetbrains.annotations.NotNull
    public static final short[] plus(@org.jetbrains.annotations.NotNull short[] sArr, @org.jetbrains.annotations.NotNull java.util.Collection<java.lang.Short> elements) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(sArr, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(elements, "elements");
        int length = sArr.length;
        short[] result = java.util.Arrays.copyOf(sArr, elements.size() + length);
        java.util.Iterator<java.lang.Short> it = elements.iterator();
        while (it.hasNext()) {
            result[length] = it.next().shortValue();
            length++;
        }
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(result, "result");
        return result;
    }

    @org.jetbrains.annotations.NotNull
    public static final short[] plus(@org.jetbrains.annotations.NotNull short[] sArr, short s2) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(sArr, "<this>");
        int length = sArr.length;
        short[] result = java.util.Arrays.copyOf(sArr, length + 1);
        result[length] = s2;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(result, "result");
        return result;
    }

    @org.jetbrains.annotations.NotNull
    public static final short[] plus(@org.jetbrains.annotations.NotNull short[] sArr, @org.jetbrains.annotations.NotNull short[] elements) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(sArr, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(elements, "elements");
        int length = sArr.length;
        int length2 = elements.length;
        short[] result = java.util.Arrays.copyOf(sArr, length + length2);
        java.lang.System.arraycopy(elements, 0, result, length, length2);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(result, "result");
        return result;
    }

    @org.jetbrains.annotations.NotNull
    public static final boolean[] plus(@org.jetbrains.annotations.NotNull boolean[] zArr, @org.jetbrains.annotations.NotNull java.util.Collection<java.lang.Boolean> elements) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(zArr, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(elements, "elements");
        int length = zArr.length;
        boolean[] result = java.util.Arrays.copyOf(zArr, elements.size() + length);
        java.util.Iterator<java.lang.Boolean> it = elements.iterator();
        while (it.hasNext()) {
            result[length] = it.next().booleanValue();
            length++;
        }
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(result, "result");
        return result;
    }

    @org.jetbrains.annotations.NotNull
    public static final boolean[] plus(@org.jetbrains.annotations.NotNull boolean[] zArr, boolean z) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(zArr, "<this>");
        int length = zArr.length;
        boolean[] result = java.util.Arrays.copyOf(zArr, length + 1);
        result[length] = z;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(result, "result");
        return result;
    }

    @org.jetbrains.annotations.NotNull
    public static final boolean[] plus(@org.jetbrains.annotations.NotNull boolean[] zArr, @org.jetbrains.annotations.NotNull boolean[] elements) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(zArr, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(elements, "elements");
        int length = zArr.length;
        int length2 = elements.length;
        boolean[] result = java.util.Arrays.copyOf(zArr, length + length2);
        java.lang.System.arraycopy(elements, 0, result, length, length2);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(result, "result");
        return result;
    }

    public static final void sort(@org.jetbrains.annotations.NotNull byte[] bArr) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(bArr, "<this>");
        if (bArr.length > 1) {
            java.util.Arrays.sort(bArr);
        }
    }

    public static final void sort(@org.jetbrains.annotations.NotNull byte[] bArr, int i, int i2) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(bArr, "<this>");
        java.util.Arrays.sort(bArr, i, i2);
    }

    public static final void sort(@org.jetbrains.annotations.NotNull char[] cArr) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(cArr, "<this>");
        if (cArr.length > 1) {
            java.util.Arrays.sort(cArr);
        }
    }

    public static final void sort(@org.jetbrains.annotations.NotNull char[] cArr, int i, int i2) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(cArr, "<this>");
        java.util.Arrays.sort(cArr, i, i2);
    }

    public static final void sort(@org.jetbrains.annotations.NotNull double[] dArr) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(dArr, "<this>");
        if (dArr.length > 1) {
            java.util.Arrays.sort(dArr);
        }
    }

    public static final void sort(@org.jetbrains.annotations.NotNull double[] dArr, int i, int i2) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(dArr, "<this>");
        java.util.Arrays.sort(dArr, i, i2);
    }

    public static final void sort(@org.jetbrains.annotations.NotNull float[] fArr) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(fArr, "<this>");
        if (fArr.length > 1) {
            java.util.Arrays.sort(fArr);
        }
    }

    public static final void sort(@org.jetbrains.annotations.NotNull float[] fArr, int i, int i2) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(fArr, "<this>");
        java.util.Arrays.sort(fArr, i, i2);
    }

    public static final void sort(@org.jetbrains.annotations.NotNull int[] iArr) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(iArr, "<this>");
        if (iArr.length > 1) {
            java.util.Arrays.sort(iArr);
        }
    }

    public static final void sort(@org.jetbrains.annotations.NotNull int[] iArr, int i, int i2) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(iArr, "<this>");
        java.util.Arrays.sort(iArr, i, i2);
    }

    public static final void sort(@org.jetbrains.annotations.NotNull long[] jArr) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(jArr, "<this>");
        if (jArr.length > 1) {
            java.util.Arrays.sort(jArr);
        }
    }

    public static final void sort(@org.jetbrains.annotations.NotNull long[] jArr, int i, int i2) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(jArr, "<this>");
        java.util.Arrays.sort(jArr, i, i2);
    }

    @kotlin.SinceKotlin(version = "1.4")
    public static final <T extends java.lang.Comparable<? super T>> void sort(@org.jetbrains.annotations.NotNull T[] tArr, int i, int i2) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(tArr, "<this>");
        java.util.Arrays.sort(tArr, i, i2);
    }

    public static <T> void sort(@org.jetbrains.annotations.NotNull T[] tArr) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(tArr, "<this>");
        if (tArr.length > 1) {
            java.util.Arrays.sort(tArr);
        }
    }

    public static final <T> void sort(@org.jetbrains.annotations.NotNull T[] tArr, int i, int i2) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(tArr, "<this>");
        java.util.Arrays.sort(tArr, i, i2);
    }

    public static final void sort(@org.jetbrains.annotations.NotNull short[] sArr) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(sArr, "<this>");
        if (sArr.length > 1) {
            java.util.Arrays.sort(sArr);
        }
    }

    public static final void sort(@org.jetbrains.annotations.NotNull short[] sArr, int i, int i2) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(sArr, "<this>");
        java.util.Arrays.sort(sArr, i, i2);
    }

    public static /* synthetic */ void sort$default(byte[] bArr, int i, int i2, int i3, java.lang.Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = bArr.length;
        }
        sort(bArr, i, i2);
    }

    public static /* synthetic */ void sort$default(char[] cArr, int i, int i2, int i3, java.lang.Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = cArr.length;
        }
        sort(cArr, i, i2);
    }

    public static /* synthetic */ void sort$default(double[] dArr, int i, int i2, int i3, java.lang.Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = dArr.length;
        }
        sort(dArr, i, i2);
    }

    public static /* synthetic */ void sort$default(float[] fArr, int i, int i2, int i3, java.lang.Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = fArr.length;
        }
        sort(fArr, i, i2);
    }

    public static /* synthetic */ void sort$default(int[] iArr, int i, int i2, int i3, java.lang.Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = iArr.length;
        }
        sort(iArr, i, i2);
    }

    public static /* synthetic */ void sort$default(long[] jArr, int i, int i2, int i3, java.lang.Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = jArr.length;
        }
        sort(jArr, i, i2);
    }

    public static /* synthetic */ void sort$default(java.lang.Comparable[] comparableArr, int i, int i2, int i3, java.lang.Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = comparableArr.length;
        }
        sort(comparableArr, i, i2);
    }

    public static /* synthetic */ void sort$default(java.lang.Object[] objArr, int i, int i2, int i3, java.lang.Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = objArr.length;
        }
        sort(objArr, i, i2);
    }

    public static /* synthetic */ void sort$default(short[] sArr, int i, int i2, int i3, java.lang.Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = sArr.length;
        }
        sort(sArr, i, i2);
    }

    public static final <T> void sortWith(@org.jetbrains.annotations.NotNull T[] tArr, @org.jetbrains.annotations.NotNull java.util.Comparator<? super T> comparator) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(tArr, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (tArr.length > 1) {
            java.util.Arrays.sort(tArr, comparator);
        }
    }

    public static final <T> void sortWith(@org.jetbrains.annotations.NotNull T[] tArr, @org.jetbrains.annotations.NotNull java.util.Comparator<? super T> comparator, int i, int i2) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(tArr, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(comparator, "comparator");
        java.util.Arrays.sort(tArr, i, i2, comparator);
    }

    public static /* synthetic */ void sortWith$default(java.lang.Object[] objArr, java.util.Comparator comparator, int i, int i2, int i3, java.lang.Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = objArr.length;
        }
        sortWith(objArr, comparator, i, i2);
    }

    @org.jetbrains.annotations.NotNull
    public static final java.util.SortedSet<java.lang.Byte> toSortedSet(@org.jetbrains.annotations.NotNull byte[] bArr) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(bArr, "<this>");
        return (java.util.SortedSet) kotlin.collections.ArraysKt___ArraysKt.toCollection(bArr, new java.util.TreeSet());
    }

    @org.jetbrains.annotations.NotNull
    public static final java.util.SortedSet<java.lang.Character> toSortedSet(@org.jetbrains.annotations.NotNull char[] cArr) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(cArr, "<this>");
        return (java.util.SortedSet) kotlin.collections.ArraysKt___ArraysKt.toCollection(cArr, new java.util.TreeSet());
    }

    @org.jetbrains.annotations.NotNull
    public static final java.util.SortedSet<java.lang.Double> toSortedSet(@org.jetbrains.annotations.NotNull double[] dArr) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(dArr, "<this>");
        return (java.util.SortedSet) kotlin.collections.ArraysKt___ArraysKt.toCollection(dArr, new java.util.TreeSet());
    }

    @org.jetbrains.annotations.NotNull
    public static final java.util.SortedSet<java.lang.Float> toSortedSet(@org.jetbrains.annotations.NotNull float[] fArr) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(fArr, "<this>");
        return (java.util.SortedSet) kotlin.collections.ArraysKt___ArraysKt.toCollection(fArr, new java.util.TreeSet());
    }

    @org.jetbrains.annotations.NotNull
    public static final java.util.SortedSet<java.lang.Integer> toSortedSet(@org.jetbrains.annotations.NotNull int[] iArr) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(iArr, "<this>");
        return (java.util.SortedSet) kotlin.collections.ArraysKt___ArraysKt.toCollection(iArr, new java.util.TreeSet());
    }

    @org.jetbrains.annotations.NotNull
    public static final java.util.SortedSet<java.lang.Long> toSortedSet(@org.jetbrains.annotations.NotNull long[] jArr) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(jArr, "<this>");
        return (java.util.SortedSet) kotlin.collections.ArraysKt___ArraysKt.toCollection(jArr, new java.util.TreeSet());
    }

    @org.jetbrains.annotations.NotNull
    public static final <T extends java.lang.Comparable<? super T>> java.util.SortedSet<T> toSortedSet(@org.jetbrains.annotations.NotNull T[] tArr) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(tArr, "<this>");
        return (java.util.SortedSet) kotlin.collections.ArraysKt___ArraysKt.toCollection(tArr, new java.util.TreeSet());
    }

    @org.jetbrains.annotations.NotNull
    public static final <T> java.util.SortedSet<T> toSortedSet(@org.jetbrains.annotations.NotNull T[] tArr, @org.jetbrains.annotations.NotNull java.util.Comparator<? super T> comparator) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(tArr, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(comparator, "comparator");
        return (java.util.SortedSet) kotlin.collections.ArraysKt___ArraysKt.toCollection(tArr, new java.util.TreeSet(comparator));
    }

    @org.jetbrains.annotations.NotNull
    public static final java.util.SortedSet<java.lang.Short> toSortedSet(@org.jetbrains.annotations.NotNull short[] sArr) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(sArr, "<this>");
        return (java.util.SortedSet) kotlin.collections.ArraysKt___ArraysKt.toCollection(sArr, new java.util.TreeSet());
    }

    @org.jetbrains.annotations.NotNull
    public static final java.util.SortedSet<java.lang.Boolean> toSortedSet(@org.jetbrains.annotations.NotNull boolean[] zArr) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(zArr, "<this>");
        return (java.util.SortedSet) kotlin.collections.ArraysKt___ArraysKt.toCollection(zArr, new java.util.TreeSet());
    }

    @org.jetbrains.annotations.NotNull
    public static final java.lang.Boolean[] toTypedArray(@org.jetbrains.annotations.NotNull boolean[] zArr) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(zArr, "<this>");
        java.lang.Boolean[] boolArr = new java.lang.Boolean[zArr.length];
        int length = zArr.length;
        for (int i = 0; i < length; i++) {
            boolArr[i] = java.lang.Boolean.valueOf(zArr[i]);
        }
        return boolArr;
    }

    @org.jetbrains.annotations.NotNull
    public static final java.lang.Byte[] toTypedArray(@org.jetbrains.annotations.NotNull byte[] bArr) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(bArr, "<this>");
        java.lang.Byte[] bArr2 = new java.lang.Byte[bArr.length];
        int length = bArr.length;
        for (int i = 0; i < length; i++) {
            bArr2[i] = java.lang.Byte.valueOf(bArr[i]);
        }
        return bArr2;
    }

    @org.jetbrains.annotations.NotNull
    public static final java.lang.Character[] toTypedArray(@org.jetbrains.annotations.NotNull char[] cArr) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(cArr, "<this>");
        java.lang.Character[] chArr = new java.lang.Character[cArr.length];
        int length = cArr.length;
        for (int i = 0; i < length; i++) {
            chArr[i] = java.lang.Character.valueOf(cArr[i]);
        }
        return chArr;
    }

    @org.jetbrains.annotations.NotNull
    public static final java.lang.Double[] toTypedArray(@org.jetbrains.annotations.NotNull double[] dArr) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(dArr, "<this>");
        java.lang.Double[] dArr2 = new java.lang.Double[dArr.length];
        int length = dArr.length;
        for (int i = 0; i < length; i++) {
            dArr2[i] = java.lang.Double.valueOf(dArr[i]);
        }
        return dArr2;
    }

    @org.jetbrains.annotations.NotNull
    public static final java.lang.Float[] toTypedArray(@org.jetbrains.annotations.NotNull float[] fArr) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(fArr, "<this>");
        java.lang.Float[] fArr2 = new java.lang.Float[fArr.length];
        int length = fArr.length;
        for (int i = 0; i < length; i++) {
            fArr2[i] = java.lang.Float.valueOf(fArr[i]);
        }
        return fArr2;
    }

    @org.jetbrains.annotations.NotNull
    public static final java.lang.Integer[] toTypedArray(@org.jetbrains.annotations.NotNull int[] iArr) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(iArr, "<this>");
        java.lang.Integer[] numArr = new java.lang.Integer[iArr.length];
        int length = iArr.length;
        for (int i = 0; i < length; i++) {
            numArr[i] = java.lang.Integer.valueOf(iArr[i]);
        }
        return numArr;
    }

    @org.jetbrains.annotations.NotNull
    public static final java.lang.Long[] toTypedArray(@org.jetbrains.annotations.NotNull long[] jArr) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(jArr, "<this>");
        java.lang.Long[] lArr = new java.lang.Long[jArr.length];
        int length = jArr.length;
        for (int i = 0; i < length; i++) {
            lArr[i] = java.lang.Long.valueOf(jArr[i]);
        }
        return lArr;
    }

    @org.jetbrains.annotations.NotNull
    public static final java.lang.Short[] toTypedArray(@org.jetbrains.annotations.NotNull short[] sArr) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(sArr, "<this>");
        java.lang.Short[] shArr = new java.lang.Short[sArr.length];
        int length = sArr.length;
        for (int i = 0; i < length; i++) {
            shArr[i] = java.lang.Short.valueOf(sArr[i]);
        }
        return shArr;
    }
}
