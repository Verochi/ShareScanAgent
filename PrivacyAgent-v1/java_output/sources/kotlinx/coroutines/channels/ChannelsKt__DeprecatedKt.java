package kotlinx.coroutines.channels;

@kotlin.Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u001f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0010!\n\u0000\n\u0002\u0010\"\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010#\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u001aL\u0010\n\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0003j\u0002`\t2\u001a\u0010\u0002\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00010\u0000\"\u0006\u0012\u0002\b\u00030\u0001H\u0001¢\u0006\u0004\b\n\u0010\u000b\u001a+\u0010\u000f\u001a\u00028\u0000\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u000e\u001a\u00020\rH\u0087@ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001a-\u0010\u0011\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u000e\u001a\u00020\rH\u0087@ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0010\u001a#\u0010\u0012\u001a\u00028\u0000\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0087@ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013\u001a%\u0010\u0014\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0087@ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0013\u001a+\u0010\u0016\u001a\u00020\r\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0015\u001a\u00028\u0000H\u0087@ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u001a#\u0010\u0018\u001a\u00028\u0000\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0087@ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0013\u001a+\u0010\u0019\u001a\u00020\r\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0015\u001a\u00028\u0000H\u0087@ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u0017\u001a%\u0010\u001a\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0087@ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u0013\u001a#\u0010\u001b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0087@ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u0013\u001a%\u0010\u001c\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0087@ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u0013\u001a0\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u001d\u001a\u00020\r2\b\b\u0002\u0010\u001f\u001a\u00020\u001eH\u0007\u001aV\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\b\u0002\u0010\u001f\u001a\u00020\u001e2\"\u0010%\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\"\u0012\u0006\u0012\u0004\u0018\u00010$0!H\u0007ø\u0001\u0000¢\u0006\u0004\b&\u0010'\u001aV\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\b\u0002\u0010\u001f\u001a\u00020\u001e2\"\u0010%\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\"\u0012\u0006\u0012\u0004\u0018\u00010$0!H\u0001ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010'\u001ak\u0010)\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\b\u0002\u0010\u001f\u001a\u00020\u001e27\u0010%\u001a3\b\u0001\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\"\u0012\u0006\u0012\u0004\u0018\u00010$0(H\u0007ø\u0001\u0000¢\u0006\u0004\b)\u0010*\u001aV\u0010+\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\b\u0002\u0010\u001f\u001a\u00020\u001e2\"\u0010%\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\"\u0012\u0006\u0012\u0004\u0018\u00010$0!H\u0007ø\u0001\u0000¢\u0006\u0004\b+\u0010'\u001a$\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\b\b\u0000\u0010\f*\u00020$*\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0001H\u0001\u001aC\u0010/\u001a\u00028\u0001\"\b\b\u0000\u0010\f*\u00020$\"\u0010\b\u0001\u0010\u0019*\n\u0012\u0006\b\u0000\u0012\u00028\u00000-*\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u00012\u0006\u0010.\u001a\u00028\u0001H\u0087@ø\u0001\u0000¢\u0006\u0004\b/\u00100\u001aA\u00102\u001a\u00028\u0001\"\b\b\u0000\u0010\f*\u00020$\"\u000e\b\u0001\u0010\u0019*\b\u0012\u0004\u0012\u00028\u000001*\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u00012\u0006\u0010.\u001a\u00028\u0001H\u0087@ø\u0001\u0000¢\u0006\u0004\b2\u00103\u001a0\u00104\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u001d\u001a\u00020\r2\b\b\u0002\u0010\u001f\u001a\u00020\u001eH\u0007\u001aV\u00105\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\b\u0002\u0010\u001f\u001a\u00020\u001e2\"\u0010%\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\"\u0012\u0006\u0012\u0004\u0018\u00010$0!H\u0007ø\u0001\u0000¢\u0006\u0004\b5\u0010'\u001a;\u00106\u001a\u00028\u0001\"\u0004\b\u0000\u0010\f\"\u000e\b\u0001\u0010\u0019*\b\u0012\u0004\u0012\u00028\u000001*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010.\u001a\u00028\u0001H\u0081@ø\u0001\u0000¢\u0006\u0004\b6\u00103\u001a=\u00107\u001a\u00028\u0001\"\u0004\b\u0000\u0010\f\"\u0010\b\u0001\u0010\u0019*\n\u0012\u0006\b\u0000\u0012\u00028\u00000-*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010.\u001a\u00028\u0001H\u0081@ø\u0001\u0000¢\u0006\u0004\b7\u00100\u001aA\u0010<\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010;\"\u0004\b\u0000\u00108\"\u0004\b\u0001\u00109*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010:0\u0001H\u0087@ø\u0001\u0000¢\u0006\u0004\b<\u0010\u0013\u001aW\u0010?\u001a\u00028\u0002\"\u0004\b\u0000\u00108\"\u0004\b\u0001\u00109\"\u0018\b\u0002\u0010>*\u0012\u0012\u0006\b\u0000\u0012\u00028\u0000\u0012\u0006\b\u0000\u0012\u00028\u00010=*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010:0\u00012\u0006\u0010.\u001a\u00028\u0002H\u0081@ø\u0001\u0000¢\u0006\u0004\b?\u0010@\u001a)\u0010B\u001a\b\u0012\u0004\u0012\u00028\u00000A\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0087@ø\u0001\u0000¢\u0006\u0004\bB\u0010\u0013\u001a)\u0010D\u001a\b\u0012\u0004\u0012\u00028\u00000C\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0087@ø\u0001\u0000¢\u0006\u0004\bD\u0010\u0013\u001ab\u0010F\u001a\b\u0012\u0004\u0012\u00028\u00010\u0001\"\u0004\b\u0000\u0010\f\"\u0004\b\u0001\u0010\u001c*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\b\u0002\u0010\u001f\u001a\u00020\u001e2(\u0010E\u001a$\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00010\"\u0012\u0006\u0012\u0004\u0018\u00010$0!H\u0007ø\u0001\u0000¢\u0006\u0004\bF\u0010'\u001a\\\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00010\u0001\"\u0004\b\u0000\u0010\f\"\u0004\b\u0001\u0010\u001c*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\b\u0002\u0010\u001f\u001a\u00020\u001e2\"\u0010E\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\"\u0012\u0006\u0012\u0004\u0018\u00010$0!H\u0001ø\u0001\u0000¢\u0006\u0004\b\f\u0010'\u001aq\u0010G\u001a\b\u0012\u0004\u0012\u00028\u00010\u0001\"\u0004\b\u0000\u0010\f\"\u0004\b\u0001\u0010\u001c*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\b\u0002\u0010\u001f\u001a\u00020\u001e27\u0010E\u001a3\b\u0001\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\"\u0012\u0006\u0012\u0004\u0018\u00010$0(H\u0001ø\u0001\u0000¢\u0006\u0004\bG\u0010*\u001aw\u0010H\u001a\b\u0012\u0004\u0012\u00028\u00010\u0001\"\u0004\b\u0000\u0010\f\"\b\b\u0001\u0010\u001c*\u00020$*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\b\u0002\u0010\u001f\u001a\u00020\u001e29\u0010E\u001a5\b\u0001\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00028\u0000\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00018\u00010\"\u0012\u0006\u0012\u0004\u0018\u00010$0(H\u0007ø\u0001\u0000¢\u0006\u0004\bH\u0010*\u001ab\u00108\u001a\b\u0012\u0004\u0012\u00028\u00010\u0001\"\u0004\b\u0000\u0010\f\"\b\b\u0001\u0010\u001c*\u00020$*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\b\u0002\u0010\u001f\u001a\u00020\u001e2$\u0010E\u001a \b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00018\u00010\"\u0012\u0006\u0012\u0004\u0018\u00010$0!H\u0007ø\u0001\u0000¢\u0006\u0004\b8\u0010'\u001a.\u0010J\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000I0\u0001\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\b\u0002\u0010\u001f\u001a\u00020\u001eH\u0007\u001a\u001e\u0010K\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0007\u001a\\\u0010M\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\f\"\u0004\b\u0001\u00108*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\b\u0002\u0010\u001f\u001a\u00020\u001e2\"\u0010L\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\"\u0012\u0006\u0012\u0004\u0018\u00010$0!H\u0001ø\u0001\u0000¢\u0006\u0004\bM\u0010'\u001a)\u0010O\u001a\b\u0012\u0004\u0012\u00028\u00000N\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0081@ø\u0001\u0000¢\u0006\u0004\bO\u0010\u0013\u001a#\u0010P\u001a\u00020#\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0087@ø\u0001\u0000¢\u0006\u0004\bP\u0010\u0013\u001a#\u0010Q\u001a\u00020\r\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0087@ø\u0001\u0000¢\u0006\u0004\bQ\u0010\u0013\u001aA\u0010>\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u00028\u00000\u00012\u001a\u0010T\u001a\u0016\u0012\u0006\b\u0000\u0012\u00028\u00000Rj\n\u0012\u0006\b\u0000\u0012\u00028\u0000`SH\u0087@ø\u0001\u0000¢\u0006\u0004\b>\u0010U\u001aA\u0010V\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u00028\u00000\u00012\u001a\u0010T\u001a\u0016\u0012\u0006\b\u0000\u0012\u00028\u00000Rj\n\u0012\u0006\b\u0000\u0012\u00028\u0000`SH\u0087@ø\u0001\u0000¢\u0006\u0004\bV\u0010U\u001a#\u0010W\u001a\u00020#\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0087@ø\u0001\u0000¢\u0006\u0004\bW\u0010\u0013\u001a$\u0010X\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\b\b\u0000\u0010\f*\u00020$*\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0001H\u0007\u001a?\u0010Z\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010:0\u0001\"\u0004\b\u0000\u0010\f\"\u0004\b\u0001\u0010\u001c*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010Y\u001a\b\u0012\u0004\u0012\u00028\u00010\u0001H\u0087\u0004\u001az\u0010\\\u001a\b\u0012\u0004\u0012\u00028\u00020\u0001\"\u0004\b\u0000\u0010\f\"\u0004\b\u0001\u0010\u001c\"\u0004\b\u0002\u00109*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010Y\u001a\b\u0012\u0004\u0012\u00028\u00010\u00012\b\b\u0002\u0010\u001f\u001a\u00020\u001e26\u0010E\u001a2\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(P\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b([\u0012\u0004\u0012\u00028\u00020!H\u0001\u001a1\u0010[\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0003j\u0002`\t*\u0006\u0012\u0002\b\u00030\u0001H\u0001\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006]"}, d2 = {"", "Lkotlinx/coroutines/channels/ReceiveChannel;", "channels", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "", "Lkotlinx/coroutines/CompletionHandler;", "c", "([Lkotlinx/coroutines/channels/ReceiveChannel;)Lkotlin/jvm/functions/Function1;", androidx.exifinterface.media.ExifInterface.LONGITUDE_EAST, "", "index", "l", "(Lkotlinx/coroutines/channels/ReceiveChannel;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", com.anythink.expressad.d.a.b.dH, com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.WIDTH, "(Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "x", "element", androidx.exifinterface.media.ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Lkotlinx/coroutines/channels/ReceiveChannel;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "B", "C", "D", "Q", "R", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.AD_COUNT, "Lkotlin/coroutines/CoroutineContext;", "context", "h", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "", "predicate", "j", "(Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/channels/ReceiveChannel;", "Lkotlin/Function3;", "p", "(Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/channels/ReceiveChannel;", "r", "t", "", "destination", com.umeng.analytics.pro.bo.aN, "(Lkotlinx/coroutines/channels/ReceiveChannel;Ljava/util/Collection;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/SendChannel;", "v", "(Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlinx/coroutines/channels/SendChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", androidx.exifinterface.media.ExifInterface.LATITUDE_SOUTH, "U", androidx.exifinterface.media.ExifInterface.LONGITUDE_WEST, "X", "K", androidx.exifinterface.media.ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lkotlin/Pair;", "", "Z", "", "M", "Y", "(Lkotlinx/coroutines/channels/ReceiveChannel;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "a0", "", "c0", "transform", "y", "G", "I", "Lkotlin/collections/IndexedValue;", "d0", "e", "selector", "f", "", "b0", "a", "d", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "comparator", "(Lkotlinx/coroutines/channels/ReceiveChannel;Ljava/util/Comparator;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "N", "O", "P", "other", "f0", "b", "g0", "kotlinx-coroutines-core"}, k = 5, mv = {1, 5, 1}, xs = "kotlinx/coroutines/channels/ChannelsKt")
/* loaded from: classes16.dex */
final /* synthetic */ class ChannelsKt__DeprecatedKt {
    /* JADX WARN: Removed duplicated region for block: B:14:0x0070 A[Catch: all -> 0x0037, TryCatch #1 {all -> 0x0037, blocks: (B:11:0x0033, B:12:0x0067, B:14:0x0070, B:16:0x007a, B:20:0x0084, B:21:0x0053, B:25:0x008b), top: B:10:0x0033 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0063 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x008b A[Catch: all -> 0x0037, TRY_LEAVE, TryCatch #1 {all -> 0x0037, blocks: (B:11:0x0033, B:12:0x0067, B:14:0x0070, B:16:0x007a, B:20:0x0084, B:21:0x0053, B:25:0x008b), top: B:10:0x0033 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0064 -> B:12:0x0067). Please report as a decompilation issue!!! */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ java.lang.Object A(kotlinx.coroutines.channels.ReceiveChannel receiveChannel, java.lang.Object obj, kotlin.coroutines.Continuation continuation) {
        kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$indexOf$1 channelsKt__DeprecatedKt$indexOf$1;
        java.lang.Object coroutine_suspended;
        int i;
        kotlinx.coroutines.channels.ReceiveChannel receiveChannel2;
        java.lang.Throwable th;
        kotlinx.coroutines.channels.ChannelIterator it;
        kotlin.jvm.internal.Ref.IntRef intRef;
        java.lang.Object obj2;
        java.lang.Object hasNext;
        try {
            if (continuation instanceof kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$indexOf$1) {
                channelsKt__DeprecatedKt$indexOf$1 = (kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$indexOf$1) continuation;
                int i2 = channelsKt__DeprecatedKt$indexOf$1.label;
                if ((i2 & Integer.MIN_VALUE) != 0) {
                    channelsKt__DeprecatedKt$indexOf$1.label = i2 - Integer.MIN_VALUE;
                    java.lang.Object obj3 = channelsKt__DeprecatedKt$indexOf$1.result;
                    coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = channelsKt__DeprecatedKt$indexOf$1.label;
                    if (i != 0) {
                        kotlin.ResultKt.throwOnFailure(obj3);
                        kotlin.jvm.internal.Ref.IntRef intRef2 = new kotlin.jvm.internal.Ref.IntRef();
                        try {
                            receiveChannel2 = receiveChannel;
                            it = receiveChannel.iterator();
                            intRef = intRef2;
                            obj2 = obj;
                            channelsKt__DeprecatedKt$indexOf$1.L$0 = obj2;
                            channelsKt__DeprecatedKt$indexOf$1.L$1 = intRef;
                            channelsKt__DeprecatedKt$indexOf$1.L$2 = receiveChannel2;
                            channelsKt__DeprecatedKt$indexOf$1.L$3 = it;
                            channelsKt__DeprecatedKt$indexOf$1.label = 1;
                            hasNext = it.hasNext(channelsKt__DeprecatedKt$indexOf$1);
                            if (hasNext != coroutine_suspended) {
                            }
                        } catch (java.lang.Throwable th2) {
                            receiveChannel2 = receiveChannel;
                            th = th2;
                        }
                    } else {
                        if (i != 1) {
                            throw new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        it = (kotlinx.coroutines.channels.ChannelIterator) channelsKt__DeprecatedKt$indexOf$1.L$3;
                        receiveChannel2 = (kotlinx.coroutines.channels.ReceiveChannel) channelsKt__DeprecatedKt$indexOf$1.L$2;
                        intRef = (kotlin.jvm.internal.Ref.IntRef) channelsKt__DeprecatedKt$indexOf$1.L$1;
                        java.lang.Object obj4 = channelsKt__DeprecatedKt$indexOf$1.L$0;
                        try {
                            kotlin.ResultKt.throwOnFailure(obj3);
                            if (!((java.lang.Boolean) obj3).booleanValue()) {
                                kotlin.Unit unit = kotlin.Unit.INSTANCE;
                                kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(receiveChannel2, null);
                                return kotlin.coroutines.jvm.internal.Boxing.boxInt(-1);
                            }
                            if (kotlin.jvm.internal.Intrinsics.areEqual(obj4, it.next())) {
                                java.lang.Integer boxInt = kotlin.coroutines.jvm.internal.Boxing.boxInt(intRef.element);
                                kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(receiveChannel2, null);
                                return boxInt;
                            }
                            intRef.element++;
                            obj2 = obj4;
                            channelsKt__DeprecatedKt$indexOf$1.L$0 = obj2;
                            channelsKt__DeprecatedKt$indexOf$1.L$1 = intRef;
                            channelsKt__DeprecatedKt$indexOf$1.L$2 = receiveChannel2;
                            channelsKt__DeprecatedKt$indexOf$1.L$3 = it;
                            channelsKt__DeprecatedKt$indexOf$1.label = 1;
                            hasNext = it.hasNext(channelsKt__DeprecatedKt$indexOf$1);
                            if (hasNext != coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            obj4 = obj2;
                            obj3 = hasNext;
                            if (!((java.lang.Boolean) obj3).booleanValue()) {
                            }
                        } catch (java.lang.Throwable th3) {
                            th = th3;
                        }
                    }
                    throw th;
                }
            }
            throw th;
        } catch (java.lang.Throwable th4) {
            kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(receiveChannel2, th);
            throw th4;
        }
        channelsKt__DeprecatedKt$indexOf$1 = new kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$indexOf$1(continuation);
        java.lang.Object obj32 = channelsKt__DeprecatedKt$indexOf$1.result;
        coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__DeprecatedKt$indexOf$1.label;
        if (i != 0) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0092 A[Catch: all -> 0x0036, TRY_LEAVE, TryCatch #1 {all -> 0x0036, blocks: (B:12:0x0032, B:13:0x008a, B:15:0x0092), top: B:11:0x0032 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0085 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0070 A[Catch: all -> 0x004e, TRY_LEAVE, TryCatch #3 {all -> 0x004e, blocks: (B:40:0x004a, B:41:0x0068, B:43:0x0070, B:45:0x009d, B:46:0x00a4), top: B:39:0x004a }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x009d A[Catch: all -> 0x004e, TRY_ENTER, TryCatch #3 {all -> 0x004e, blocks: (B:40:0x004a, B:41:0x0068, B:43:0x0070, B:45:0x009d, B:46:0x00a4), top: B:39:0x004a }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0086 -> B:13:0x008a). Please report as a decompilation issue!!! */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ java.lang.Object B(kotlinx.coroutines.channels.ReceiveChannel receiveChannel, kotlin.coroutines.Continuation continuation) {
        kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$last$1 channelsKt__DeprecatedKt$last$1;
        java.lang.Object obj;
        java.lang.Object coroutine_suspended;
        int i;
        kotlinx.coroutines.channels.ReceiveChannel receiveChannel2;
        kotlinx.coroutines.channels.ChannelIterator channelIterator;
        java.lang.Object next;
        kotlinx.coroutines.channels.ChannelIterator channelIterator2;
        java.lang.Object hasNext;
        if (continuation instanceof kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$last$1) {
            channelsKt__DeprecatedKt$last$1 = (kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$last$1) continuation;
            int i2 = channelsKt__DeprecatedKt$last$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                channelsKt__DeprecatedKt$last$1.label = i2 - Integer.MIN_VALUE;
                obj = channelsKt__DeprecatedKt$last$1.result;
                coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelsKt__DeprecatedKt$last$1.label;
                if (i != 0) {
                    kotlin.ResultKt.throwOnFailure(obj);
                    try {
                        kotlinx.coroutines.channels.ChannelIterator it = receiveChannel.iterator();
                        channelsKt__DeprecatedKt$last$1.L$0 = receiveChannel;
                        channelsKt__DeprecatedKt$last$1.L$1 = it;
                        channelsKt__DeprecatedKt$last$1.label = 1;
                        java.lang.Object hasNext2 = it.hasNext(channelsKt__DeprecatedKt$last$1);
                        if (hasNext2 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        receiveChannel2 = receiveChannel;
                        channelIterator = it;
                        obj = hasNext2;
                    } catch (java.lang.Throwable th) {
                        receiveChannel2 = receiveChannel;
                        th = th;
                        throw th;
                    }
                } else if (i == 1) {
                    channelIterator = (kotlinx.coroutines.channels.ChannelIterator) channelsKt__DeprecatedKt$last$1.L$1;
                    receiveChannel2 = (kotlinx.coroutines.channels.ReceiveChannel) channelsKt__DeprecatedKt$last$1.L$0;
                    try {
                        kotlin.ResultKt.throwOnFailure(obj);
                    } catch (java.lang.Throwable th2) {
                        th = th2;
                        throw th;
                    }
                } else {
                    if (i != 2) {
                        throw new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    java.lang.Object obj2 = channelsKt__DeprecatedKt$last$1.L$2;
                    channelIterator2 = (kotlinx.coroutines.channels.ChannelIterator) channelsKt__DeprecatedKt$last$1.L$1;
                    kotlinx.coroutines.channels.ReceiveChannel receiveChannel3 = (kotlinx.coroutines.channels.ReceiveChannel) channelsKt__DeprecatedKt$last$1.L$0;
                    try {
                        kotlin.ResultKt.throwOnFailure(obj);
                        if (!((java.lang.Boolean) obj).booleanValue()) {
                            next = channelIterator2.next();
                            receiveChannel = receiveChannel3;
                            channelsKt__DeprecatedKt$last$1.L$0 = receiveChannel;
                            channelsKt__DeprecatedKt$last$1.L$1 = channelIterator2;
                            channelsKt__DeprecatedKt$last$1.L$2 = next;
                            channelsKt__DeprecatedKt$last$1.label = 2;
                            hasNext = channelIterator2.hasNext(channelsKt__DeprecatedKt$last$1);
                            if (hasNext != coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            receiveChannel3 = receiveChannel;
                            obj2 = next;
                            obj = hasNext;
                            if (!((java.lang.Boolean) obj).booleanValue()) {
                                kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(receiveChannel3, null);
                                return obj2;
                            }
                        }
                    } catch (java.lang.Throwable th3) {
                        th = th3;
                        receiveChannel2 = receiveChannel3;
                        try {
                            throw th;
                        } catch (java.lang.Throwable th4) {
                            kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(receiveChannel2, th);
                            throw th4;
                        }
                    }
                }
                if (((java.lang.Boolean) obj).booleanValue()) {
                    throw new java.util.NoSuchElementException("ReceiveChannel is empty.");
                }
                next = channelIterator.next();
                kotlinx.coroutines.channels.ReceiveChannel receiveChannel4 = receiveChannel2;
                channelIterator2 = channelIterator;
                receiveChannel = receiveChannel4;
                channelsKt__DeprecatedKt$last$1.L$0 = receiveChannel;
                channelsKt__DeprecatedKt$last$1.L$1 = channelIterator2;
                channelsKt__DeprecatedKt$last$1.L$2 = next;
                channelsKt__DeprecatedKt$last$1.label = 2;
                hasNext = channelIterator2.hasNext(channelsKt__DeprecatedKt$last$1);
                if (hasNext != coroutine_suspended) {
                }
            }
        }
        channelsKt__DeprecatedKt$last$1 = new kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$last$1(continuation);
        obj = channelsKt__DeprecatedKt$last$1.result;
        coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__DeprecatedKt$last$1.label;
        if (i != 0) {
        }
        if (((java.lang.Boolean) obj).booleanValue()) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x007d A[Catch: all -> 0x003b, TryCatch #1 {all -> 0x003b, blocks: (B:11:0x0037, B:12:0x0075, B:14:0x007d, B:16:0x0087, B:17:0x008b, B:18:0x005f, B:23:0x0092), top: B:10:0x0037 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0071 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0092 A[Catch: all -> 0x003b, TRY_LEAVE, TryCatch #1 {all -> 0x003b, blocks: (B:11:0x0037, B:12:0x0075, B:14:0x007d, B:16:0x0087, B:17:0x008b, B:18:0x005f, B:23:0x0092), top: B:10:0x0037 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0072 -> B:12:0x0075). Please report as a decompilation issue!!! */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ java.lang.Object C(kotlinx.coroutines.channels.ReceiveChannel receiveChannel, java.lang.Object obj, kotlin.coroutines.Continuation continuation) {
        kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$lastIndexOf$1 channelsKt__DeprecatedKt$lastIndexOf$1;
        java.lang.Object coroutine_suspended;
        int i;
        kotlin.jvm.internal.Ref.IntRef intRef;
        kotlinx.coroutines.channels.ReceiveChannel receiveChannel2;
        java.lang.Throwable th;
        kotlinx.coroutines.channels.ChannelIterator it;
        kotlin.jvm.internal.Ref.IntRef intRef2;
        java.lang.Object obj2;
        java.lang.Object hasNext;
        if (continuation instanceof kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$lastIndexOf$1) {
            channelsKt__DeprecatedKt$lastIndexOf$1 = (kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$lastIndexOf$1) continuation;
            int i2 = channelsKt__DeprecatedKt$lastIndexOf$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                channelsKt__DeprecatedKt$lastIndexOf$1.label = i2 - Integer.MIN_VALUE;
                java.lang.Object obj3 = channelsKt__DeprecatedKt$lastIndexOf$1.result;
                coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelsKt__DeprecatedKt$lastIndexOf$1.label;
                if (i != 0) {
                    kotlin.ResultKt.throwOnFailure(obj3);
                    kotlin.jvm.internal.Ref.IntRef intRef3 = new kotlin.jvm.internal.Ref.IntRef();
                    intRef3.element = -1;
                    intRef = new kotlin.jvm.internal.Ref.IntRef();
                    try {
                        receiveChannel2 = receiveChannel;
                        it = receiveChannel.iterator();
                        intRef2 = intRef3;
                        obj2 = obj;
                        channelsKt__DeprecatedKt$lastIndexOf$1.L$0 = obj2;
                        channelsKt__DeprecatedKt$lastIndexOf$1.L$1 = intRef2;
                        channelsKt__DeprecatedKt$lastIndexOf$1.L$2 = intRef;
                        channelsKt__DeprecatedKt$lastIndexOf$1.L$3 = receiveChannel2;
                        channelsKt__DeprecatedKt$lastIndexOf$1.L$4 = it;
                        channelsKt__DeprecatedKt$lastIndexOf$1.label = 1;
                        hasNext = it.hasNext(channelsKt__DeprecatedKt$lastIndexOf$1);
                        if (hasNext != coroutine_suspended) {
                        }
                    } catch (java.lang.Throwable th2) {
                        receiveChannel2 = receiveChannel;
                        th = th2;
                        throw th;
                    }
                } else {
                    if (i != 1) {
                        throw new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    it = (kotlinx.coroutines.channels.ChannelIterator) channelsKt__DeprecatedKt$lastIndexOf$1.L$4;
                    receiveChannel2 = (kotlinx.coroutines.channels.ReceiveChannel) channelsKt__DeprecatedKt$lastIndexOf$1.L$3;
                    intRef = (kotlin.jvm.internal.Ref.IntRef) channelsKt__DeprecatedKt$lastIndexOf$1.L$2;
                    intRef2 = (kotlin.jvm.internal.Ref.IntRef) channelsKt__DeprecatedKt$lastIndexOf$1.L$1;
                    java.lang.Object obj4 = channelsKt__DeprecatedKt$lastIndexOf$1.L$0;
                    try {
                        kotlin.ResultKt.throwOnFailure(obj3);
                        if (!((java.lang.Boolean) obj3).booleanValue()) {
                            kotlin.Unit unit = kotlin.Unit.INSTANCE;
                            kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(receiveChannel2, null);
                            return kotlin.coroutines.jvm.internal.Boxing.boxInt(intRef2.element);
                        }
                        if (kotlin.jvm.internal.Intrinsics.areEqual(obj4, it.next())) {
                            intRef2.element = intRef.element;
                        }
                        intRef.element++;
                        obj2 = obj4;
                        channelsKt__DeprecatedKt$lastIndexOf$1.L$0 = obj2;
                        channelsKt__DeprecatedKt$lastIndexOf$1.L$1 = intRef2;
                        channelsKt__DeprecatedKt$lastIndexOf$1.L$2 = intRef;
                        channelsKt__DeprecatedKt$lastIndexOf$1.L$3 = receiveChannel2;
                        channelsKt__DeprecatedKt$lastIndexOf$1.L$4 = it;
                        channelsKt__DeprecatedKt$lastIndexOf$1.label = 1;
                        hasNext = it.hasNext(channelsKt__DeprecatedKt$lastIndexOf$1);
                        if (hasNext != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        obj4 = obj2;
                        obj3 = hasNext;
                        if (!((java.lang.Boolean) obj3).booleanValue()) {
                        }
                    } catch (java.lang.Throwable th3) {
                        th = th3;
                        try {
                            throw th;
                        } catch (java.lang.Throwable th4) {
                            kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(receiveChannel2, th);
                            throw th4;
                        }
                    }
                }
            }
        }
        channelsKt__DeprecatedKt$lastIndexOf$1 = new kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$lastIndexOf$1(continuation);
        java.lang.Object obj32 = channelsKt__DeprecatedKt$lastIndexOf$1.result;
        coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__DeprecatedKt$lastIndexOf$1.label;
        if (i != 0) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0097 A[Catch: all -> 0x0037, TRY_LEAVE, TryCatch #2 {all -> 0x0037, blocks: (B:12:0x0033, B:13:0x008f, B:15:0x0097), top: B:11:0x0033 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x008a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0075 A[Catch: all -> 0x004f, TRY_ENTER, TRY_LEAVE, TryCatch #3 {all -> 0x004f, blocks: (B:40:0x004b, B:41:0x0069, B:45:0x0075), top: B:39:0x004b }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x008b -> B:13:0x008f). Please report as a decompilation issue!!! */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ java.lang.Object D(kotlinx.coroutines.channels.ReceiveChannel receiveChannel, kotlin.coroutines.Continuation continuation) {
        kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$lastOrNull$1 channelsKt__DeprecatedKt$lastOrNull$1;
        java.lang.Object obj;
        java.lang.Object coroutine_suspended;
        int i;
        kotlinx.coroutines.channels.ReceiveChannel receiveChannel2;
        kotlinx.coroutines.channels.ChannelIterator channelIterator;
        java.lang.Object next;
        kotlinx.coroutines.channels.ChannelIterator channelIterator2;
        java.lang.Object hasNext;
        if (continuation instanceof kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$lastOrNull$1) {
            channelsKt__DeprecatedKt$lastOrNull$1 = (kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$lastOrNull$1) continuation;
            int i2 = channelsKt__DeprecatedKt$lastOrNull$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                channelsKt__DeprecatedKt$lastOrNull$1.label = i2 - Integer.MIN_VALUE;
                obj = channelsKt__DeprecatedKt$lastOrNull$1.result;
                coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelsKt__DeprecatedKt$lastOrNull$1.label;
                if (i != 0) {
                    kotlin.ResultKt.throwOnFailure(obj);
                    try {
                        kotlinx.coroutines.channels.ChannelIterator it = receiveChannel.iterator();
                        channelsKt__DeprecatedKt$lastOrNull$1.L$0 = receiveChannel;
                        channelsKt__DeprecatedKt$lastOrNull$1.L$1 = it;
                        channelsKt__DeprecatedKt$lastOrNull$1.label = 1;
                        java.lang.Object hasNext2 = it.hasNext(channelsKt__DeprecatedKt$lastOrNull$1);
                        if (hasNext2 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        receiveChannel2 = receiveChannel;
                        channelIterator = it;
                        obj = hasNext2;
                    } catch (java.lang.Throwable th) {
                        receiveChannel2 = receiveChannel;
                        th = th;
                        throw th;
                    }
                } else if (i == 1) {
                    channelIterator = (kotlinx.coroutines.channels.ChannelIterator) channelsKt__DeprecatedKt$lastOrNull$1.L$1;
                    receiveChannel2 = (kotlinx.coroutines.channels.ReceiveChannel) channelsKt__DeprecatedKt$lastOrNull$1.L$0;
                    try {
                        kotlin.ResultKt.throwOnFailure(obj);
                    } catch (java.lang.Throwable th2) {
                        th = th2;
                        throw th;
                    }
                } else {
                    if (i != 2) {
                        throw new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    java.lang.Object obj2 = channelsKt__DeprecatedKt$lastOrNull$1.L$2;
                    channelIterator2 = (kotlinx.coroutines.channels.ChannelIterator) channelsKt__DeprecatedKt$lastOrNull$1.L$1;
                    kotlinx.coroutines.channels.ReceiveChannel receiveChannel3 = (kotlinx.coroutines.channels.ReceiveChannel) channelsKt__DeprecatedKt$lastOrNull$1.L$0;
                    try {
                        kotlin.ResultKt.throwOnFailure(obj);
                        if (!((java.lang.Boolean) obj).booleanValue()) {
                            next = channelIterator2.next();
                            receiveChannel = receiveChannel3;
                            channelsKt__DeprecatedKt$lastOrNull$1.L$0 = receiveChannel;
                            channelsKt__DeprecatedKt$lastOrNull$1.L$1 = channelIterator2;
                            channelsKt__DeprecatedKt$lastOrNull$1.L$2 = next;
                            channelsKt__DeprecatedKt$lastOrNull$1.label = 2;
                            hasNext = channelIterator2.hasNext(channelsKt__DeprecatedKt$lastOrNull$1);
                            if (hasNext != coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            receiveChannel3 = receiveChannel;
                            obj2 = next;
                            obj = hasNext;
                            if (!((java.lang.Boolean) obj).booleanValue()) {
                                kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(receiveChannel3, null);
                                return obj2;
                            }
                        }
                    } catch (java.lang.Throwable th3) {
                        th = th3;
                        receiveChannel2 = receiveChannel3;
                        try {
                            throw th;
                        } catch (java.lang.Throwable th4) {
                            kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(receiveChannel2, th);
                            throw th4;
                        }
                    }
                }
                if (((java.lang.Boolean) obj).booleanValue()) {
                    kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(receiveChannel2, null);
                    return null;
                }
                next = channelIterator.next();
                kotlinx.coroutines.channels.ReceiveChannel receiveChannel4 = receiveChannel2;
                channelIterator2 = channelIterator;
                receiveChannel = receiveChannel4;
                channelsKt__DeprecatedKt$lastOrNull$1.L$0 = receiveChannel;
                channelsKt__DeprecatedKt$lastOrNull$1.L$1 = channelIterator2;
                channelsKt__DeprecatedKt$lastOrNull$1.L$2 = next;
                channelsKt__DeprecatedKt$lastOrNull$1.label = 2;
                hasNext = channelIterator2.hasNext(channelsKt__DeprecatedKt$lastOrNull$1);
                if (hasNext != coroutine_suspended) {
                }
            }
        }
        channelsKt__DeprecatedKt$lastOrNull$1 = new kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$lastOrNull$1(continuation);
        obj = channelsKt__DeprecatedKt$lastOrNull$1.result;
        coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__DeprecatedKt$lastOrNull$1.label;
        if (i != 0) {
        }
        if (((java.lang.Boolean) obj).booleanValue()) {
        }
    }

    @kotlin.PublishedApi
    @org.jetbrains.annotations.NotNull
    public static final <E, R> kotlinx.coroutines.channels.ReceiveChannel<R> E(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.ReceiveChannel<? extends E> receiveChannel, @org.jetbrains.annotations.NotNull kotlin.coroutines.CoroutineContext coroutineContext, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super E, ? super kotlin.coroutines.Continuation<? super R>, ? extends java.lang.Object> function2) {
        return kotlinx.coroutines.channels.ProduceKt.produce$default(kotlinx.coroutines.GlobalScope.INSTANCE, coroutineContext, 0, null, kotlinx.coroutines.channels.ChannelsKt.consumes(receiveChannel), new kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$map$1(receiveChannel, function2, null), 6, null);
    }

    public static /* synthetic */ kotlinx.coroutines.channels.ReceiveChannel F(kotlinx.coroutines.channels.ReceiveChannel receiveChannel, kotlin.coroutines.CoroutineContext coroutineContext, kotlin.jvm.functions.Function2 function2, int i, java.lang.Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = kotlinx.coroutines.Dispatchers.getUnconfined();
        }
        return kotlinx.coroutines.channels.ChannelsKt.map(receiveChannel, coroutineContext, function2);
    }

    @kotlin.PublishedApi
    @org.jetbrains.annotations.NotNull
    public static final <E, R> kotlinx.coroutines.channels.ReceiveChannel<R> G(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.ReceiveChannel<? extends E> receiveChannel, @org.jetbrains.annotations.NotNull kotlin.coroutines.CoroutineContext coroutineContext, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function3<? super java.lang.Integer, ? super E, ? super kotlin.coroutines.Continuation<? super R>, ? extends java.lang.Object> function3) {
        return kotlinx.coroutines.channels.ProduceKt.produce$default(kotlinx.coroutines.GlobalScope.INSTANCE, coroutineContext, 0, null, kotlinx.coroutines.channels.ChannelsKt.consumes(receiveChannel), new kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$mapIndexed$1(receiveChannel, function3, null), 6, null);
    }

    public static /* synthetic */ kotlinx.coroutines.channels.ReceiveChannel H(kotlinx.coroutines.channels.ReceiveChannel receiveChannel, kotlin.coroutines.CoroutineContext coroutineContext, kotlin.jvm.functions.Function3 function3, int i, java.lang.Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = kotlinx.coroutines.Dispatchers.getUnconfined();
        }
        return kotlinx.coroutines.channels.ChannelsKt.mapIndexed(receiveChannel, coroutineContext, function3);
    }

    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ kotlinx.coroutines.channels.ReceiveChannel I(kotlinx.coroutines.channels.ReceiveChannel receiveChannel, kotlin.coroutines.CoroutineContext coroutineContext, kotlin.jvm.functions.Function3 function3) {
        return kotlinx.coroutines.channels.ChannelsKt.filterNotNull(kotlinx.coroutines.channels.ChannelsKt.mapIndexed(receiveChannel, coroutineContext, function3));
    }

    public static /* synthetic */ kotlinx.coroutines.channels.ReceiveChannel J(kotlinx.coroutines.channels.ReceiveChannel receiveChannel, kotlin.coroutines.CoroutineContext coroutineContext, kotlin.jvm.functions.Function3 function3, int i, java.lang.Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = kotlinx.coroutines.Dispatchers.getUnconfined();
        }
        return I(receiveChannel, coroutineContext, function3);
    }

    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ kotlinx.coroutines.channels.ReceiveChannel K(kotlinx.coroutines.channels.ReceiveChannel receiveChannel, kotlin.coroutines.CoroutineContext coroutineContext, kotlin.jvm.functions.Function2 function2) {
        return kotlinx.coroutines.channels.ChannelsKt.filterNotNull(kotlinx.coroutines.channels.ChannelsKt.map(receiveChannel, coroutineContext, function2));
    }

    public static /* synthetic */ kotlinx.coroutines.channels.ReceiveChannel L(kotlinx.coroutines.channels.ReceiveChannel receiveChannel, kotlin.coroutines.CoroutineContext coroutineContext, kotlin.jvm.functions.Function2 function2, int i, java.lang.Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = kotlinx.coroutines.Dispatchers.getUnconfined();
        }
        return K(receiveChannel, coroutineContext, function2);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x00ac A[Catch: all -> 0x00bf, TRY_LEAVE, TryCatch #3 {all -> 0x00bf, blocks: (B:15:0x00a4, B:17:0x00ac, B:21:0x008f, B:55:0x0063), top: B:54:0x0063 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x009f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0087 A[Catch: all -> 0x005d, TRY_ENTER, TRY_LEAVE, TryCatch #2 {all -> 0x005d, blocks: (B:44:0x0059, B:45:0x007b, B:49:0x0087), top: B:43:0x0059 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x00a0 -> B:14:0x003d). Please report as a decompilation issue!!! */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ java.lang.Object M(kotlinx.coroutines.channels.ReceiveChannel receiveChannel, java.util.Comparator comparator, kotlin.coroutines.Continuation continuation) {
        kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$maxWith$1 channelsKt__DeprecatedKt$maxWith$1;
        java.lang.Object obj;
        java.lang.Object coroutine_suspended;
        int i;
        kotlinx.coroutines.channels.ReceiveChannel receiveChannel2;
        kotlinx.coroutines.channels.ChannelIterator channelIterator;
        java.util.Comparator comparator2;
        java.lang.Object next;
        java.util.Comparator comparator3;
        kotlinx.coroutines.channels.ChannelIterator channelIterator2;
        java.lang.Object hasNext;
        if (continuation instanceof kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$maxWith$1) {
            channelsKt__DeprecatedKt$maxWith$1 = (kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$maxWith$1) continuation;
            int i2 = channelsKt__DeprecatedKt$maxWith$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                channelsKt__DeprecatedKt$maxWith$1.label = i2 - Integer.MIN_VALUE;
                obj = channelsKt__DeprecatedKt$maxWith$1.result;
                coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelsKt__DeprecatedKt$maxWith$1.label;
                if (i != 0) {
                    kotlin.ResultKt.throwOnFailure(obj);
                    try {
                        kotlinx.coroutines.channels.ChannelIterator it = receiveChannel.iterator();
                        channelsKt__DeprecatedKt$maxWith$1.L$0 = comparator;
                        channelsKt__DeprecatedKt$maxWith$1.L$1 = receiveChannel;
                        channelsKt__DeprecatedKt$maxWith$1.L$2 = it;
                        channelsKt__DeprecatedKt$maxWith$1.label = 1;
                        java.lang.Object hasNext2 = it.hasNext(channelsKt__DeprecatedKt$maxWith$1);
                        if (hasNext2 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        receiveChannel2 = receiveChannel;
                        channelIterator = it;
                        obj = hasNext2;
                        comparator2 = comparator;
                    } catch (java.lang.Throwable th) {
                        receiveChannel2 = receiveChannel;
                        th = th;
                        throw th;
                    }
                } else if (i == 1) {
                    channelIterator = (kotlinx.coroutines.channels.ChannelIterator) channelsKt__DeprecatedKt$maxWith$1.L$2;
                    receiveChannel2 = (kotlinx.coroutines.channels.ReceiveChannel) channelsKt__DeprecatedKt$maxWith$1.L$1;
                    comparator2 = (java.util.Comparator) channelsKt__DeprecatedKt$maxWith$1.L$0;
                    try {
                        kotlin.ResultKt.throwOnFailure(obj);
                    } catch (java.lang.Throwable th2) {
                        th = th2;
                        throw th;
                    }
                } else {
                    if (i != 2) {
                        throw new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    java.lang.Object obj2 = channelsKt__DeprecatedKt$maxWith$1.L$3;
                    channelIterator2 = (kotlinx.coroutines.channels.ChannelIterator) channelsKt__DeprecatedKt$maxWith$1.L$2;
                    kotlinx.coroutines.channels.ReceiveChannel receiveChannel3 = (kotlinx.coroutines.channels.ReceiveChannel) channelsKt__DeprecatedKt$maxWith$1.L$1;
                    comparator3 = (java.util.Comparator) channelsKt__DeprecatedKt$maxWith$1.L$0;
                    try {
                        kotlin.ResultKt.throwOnFailure(obj);
                        kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$maxWith$1 channelsKt__DeprecatedKt$maxWith$12 = channelsKt__DeprecatedKt$maxWith$1;
                        java.lang.Object obj3 = obj2;
                        receiveChannel = receiveChannel3;
                        java.lang.Object obj4 = coroutine_suspended;
                        kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$maxWith$1 channelsKt__DeprecatedKt$maxWith$13 = channelsKt__DeprecatedKt$maxWith$12;
                        if (!((java.lang.Boolean) obj).booleanValue()) {
                            next = channelIterator2.next();
                            if (comparator3.compare(obj3, next) >= 0) {
                                next = obj3;
                            }
                            channelsKt__DeprecatedKt$maxWith$1 = channelsKt__DeprecatedKt$maxWith$13;
                            coroutine_suspended = obj4;
                            channelsKt__DeprecatedKt$maxWith$1.L$0 = comparator3;
                            channelsKt__DeprecatedKt$maxWith$1.L$1 = receiveChannel;
                            channelsKt__DeprecatedKt$maxWith$1.L$2 = channelIterator2;
                            channelsKt__DeprecatedKt$maxWith$1.L$3 = next;
                            channelsKt__DeprecatedKt$maxWith$1.label = 2;
                            hasNext = channelIterator2.hasNext(channelsKt__DeprecatedKt$maxWith$1);
                            if (hasNext != coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            channelsKt__DeprecatedKt$maxWith$12 = channelsKt__DeprecatedKt$maxWith$1;
                            obj3 = next;
                            obj = hasNext;
                            java.lang.Object obj42 = coroutine_suspended;
                            kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$maxWith$1 channelsKt__DeprecatedKt$maxWith$132 = channelsKt__DeprecatedKt$maxWith$12;
                            if (!((java.lang.Boolean) obj).booleanValue()) {
                                kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(receiveChannel, null);
                                return obj3;
                            }
                        }
                    } catch (java.lang.Throwable th3) {
                        th = th3;
                        receiveChannel2 = receiveChannel3;
                        try {
                            throw th;
                        } catch (java.lang.Throwable th4) {
                            kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(receiveChannel2, th);
                            throw th4;
                        }
                    }
                }
                if (((java.lang.Boolean) obj).booleanValue()) {
                    kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(receiveChannel2, null);
                    return null;
                }
                next = channelIterator.next();
                comparator3 = comparator2;
                kotlinx.coroutines.channels.ReceiveChannel receiveChannel4 = receiveChannel2;
                channelIterator2 = channelIterator;
                receiveChannel = receiveChannel4;
                channelsKt__DeprecatedKt$maxWith$1.L$0 = comparator3;
                channelsKt__DeprecatedKt$maxWith$1.L$1 = receiveChannel;
                channelsKt__DeprecatedKt$maxWith$1.L$2 = channelIterator2;
                channelsKt__DeprecatedKt$maxWith$1.L$3 = next;
                channelsKt__DeprecatedKt$maxWith$1.label = 2;
                hasNext = channelIterator2.hasNext(channelsKt__DeprecatedKt$maxWith$1);
                if (hasNext != coroutine_suspended) {
                }
            }
        }
        channelsKt__DeprecatedKt$maxWith$1 = new kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$maxWith$1(continuation);
        obj = channelsKt__DeprecatedKt$maxWith$1.result;
        coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__DeprecatedKt$maxWith$1.label;
        if (i != 0) {
        }
        if (((java.lang.Boolean) obj).booleanValue()) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x00ac A[Catch: all -> 0x00bf, TRY_LEAVE, TryCatch #3 {all -> 0x00bf, blocks: (B:15:0x00a4, B:17:0x00ac, B:21:0x008f, B:55:0x0063), top: B:54:0x0063 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x009f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0087 A[Catch: all -> 0x005d, TRY_ENTER, TRY_LEAVE, TryCatch #2 {all -> 0x005d, blocks: (B:44:0x0059, B:45:0x007b, B:49:0x0087), top: B:43:0x0059 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x00a0 -> B:14:0x003d). Please report as a decompilation issue!!! */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ java.lang.Object N(kotlinx.coroutines.channels.ReceiveChannel receiveChannel, java.util.Comparator comparator, kotlin.coroutines.Continuation continuation) {
        kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$minWith$1 channelsKt__DeprecatedKt$minWith$1;
        java.lang.Object obj;
        java.lang.Object coroutine_suspended;
        int i;
        kotlinx.coroutines.channels.ReceiveChannel receiveChannel2;
        kotlinx.coroutines.channels.ChannelIterator channelIterator;
        java.util.Comparator comparator2;
        java.lang.Object next;
        java.util.Comparator comparator3;
        kotlinx.coroutines.channels.ChannelIterator channelIterator2;
        java.lang.Object hasNext;
        if (continuation instanceof kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$minWith$1) {
            channelsKt__DeprecatedKt$minWith$1 = (kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$minWith$1) continuation;
            int i2 = channelsKt__DeprecatedKt$minWith$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                channelsKt__DeprecatedKt$minWith$1.label = i2 - Integer.MIN_VALUE;
                obj = channelsKt__DeprecatedKt$minWith$1.result;
                coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelsKt__DeprecatedKt$minWith$1.label;
                if (i != 0) {
                    kotlin.ResultKt.throwOnFailure(obj);
                    try {
                        kotlinx.coroutines.channels.ChannelIterator it = receiveChannel.iterator();
                        channelsKt__DeprecatedKt$minWith$1.L$0 = comparator;
                        channelsKt__DeprecatedKt$minWith$1.L$1 = receiveChannel;
                        channelsKt__DeprecatedKt$minWith$1.L$2 = it;
                        channelsKt__DeprecatedKt$minWith$1.label = 1;
                        java.lang.Object hasNext2 = it.hasNext(channelsKt__DeprecatedKt$minWith$1);
                        if (hasNext2 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        receiveChannel2 = receiveChannel;
                        channelIterator = it;
                        obj = hasNext2;
                        comparator2 = comparator;
                    } catch (java.lang.Throwable th) {
                        receiveChannel2 = receiveChannel;
                        th = th;
                        throw th;
                    }
                } else if (i == 1) {
                    channelIterator = (kotlinx.coroutines.channels.ChannelIterator) channelsKt__DeprecatedKt$minWith$1.L$2;
                    receiveChannel2 = (kotlinx.coroutines.channels.ReceiveChannel) channelsKt__DeprecatedKt$minWith$1.L$1;
                    comparator2 = (java.util.Comparator) channelsKt__DeprecatedKt$minWith$1.L$0;
                    try {
                        kotlin.ResultKt.throwOnFailure(obj);
                    } catch (java.lang.Throwable th2) {
                        th = th2;
                        throw th;
                    }
                } else {
                    if (i != 2) {
                        throw new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    java.lang.Object obj2 = channelsKt__DeprecatedKt$minWith$1.L$3;
                    channelIterator2 = (kotlinx.coroutines.channels.ChannelIterator) channelsKt__DeprecatedKt$minWith$1.L$2;
                    kotlinx.coroutines.channels.ReceiveChannel receiveChannel3 = (kotlinx.coroutines.channels.ReceiveChannel) channelsKt__DeprecatedKt$minWith$1.L$1;
                    comparator3 = (java.util.Comparator) channelsKt__DeprecatedKt$minWith$1.L$0;
                    try {
                        kotlin.ResultKt.throwOnFailure(obj);
                        kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$minWith$1 channelsKt__DeprecatedKt$minWith$12 = channelsKt__DeprecatedKt$minWith$1;
                        java.lang.Object obj3 = obj2;
                        receiveChannel = receiveChannel3;
                        java.lang.Object obj4 = coroutine_suspended;
                        kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$minWith$1 channelsKt__DeprecatedKt$minWith$13 = channelsKt__DeprecatedKt$minWith$12;
                        if (!((java.lang.Boolean) obj).booleanValue()) {
                            next = channelIterator2.next();
                            if (comparator3.compare(obj3, next) <= 0) {
                                next = obj3;
                            }
                            channelsKt__DeprecatedKt$minWith$1 = channelsKt__DeprecatedKt$minWith$13;
                            coroutine_suspended = obj4;
                            channelsKt__DeprecatedKt$minWith$1.L$0 = comparator3;
                            channelsKt__DeprecatedKt$minWith$1.L$1 = receiveChannel;
                            channelsKt__DeprecatedKt$minWith$1.L$2 = channelIterator2;
                            channelsKt__DeprecatedKt$minWith$1.L$3 = next;
                            channelsKt__DeprecatedKt$minWith$1.label = 2;
                            hasNext = channelIterator2.hasNext(channelsKt__DeprecatedKt$minWith$1);
                            if (hasNext != coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            channelsKt__DeprecatedKt$minWith$12 = channelsKt__DeprecatedKt$minWith$1;
                            obj3 = next;
                            obj = hasNext;
                            java.lang.Object obj42 = coroutine_suspended;
                            kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$minWith$1 channelsKt__DeprecatedKt$minWith$132 = channelsKt__DeprecatedKt$minWith$12;
                            if (!((java.lang.Boolean) obj).booleanValue()) {
                                kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(receiveChannel, null);
                                return obj3;
                            }
                        }
                    } catch (java.lang.Throwable th3) {
                        th = th3;
                        receiveChannel2 = receiveChannel3;
                        try {
                            throw th;
                        } catch (java.lang.Throwable th4) {
                            kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(receiveChannel2, th);
                            throw th4;
                        }
                    }
                }
                if (((java.lang.Boolean) obj).booleanValue()) {
                    kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(receiveChannel2, null);
                    return null;
                }
                next = channelIterator.next();
                comparator3 = comparator2;
                kotlinx.coroutines.channels.ReceiveChannel receiveChannel4 = receiveChannel2;
                channelIterator2 = channelIterator;
                receiveChannel = receiveChannel4;
                channelsKt__DeprecatedKt$minWith$1.L$0 = comparator3;
                channelsKt__DeprecatedKt$minWith$1.L$1 = receiveChannel;
                channelsKt__DeprecatedKt$minWith$1.L$2 = channelIterator2;
                channelsKt__DeprecatedKt$minWith$1.L$3 = next;
                channelsKt__DeprecatedKt$minWith$1.label = 2;
                hasNext = channelIterator2.hasNext(channelsKt__DeprecatedKt$minWith$1);
                if (hasNext != coroutine_suspended) {
                }
            }
        }
        channelsKt__DeprecatedKt$minWith$1 = new kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$minWith$1(continuation);
        obj = channelsKt__DeprecatedKt$minWith$1.result;
        coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__DeprecatedKt$minWith$1.label;
        if (i != 0) {
        }
        if (((java.lang.Boolean) obj).booleanValue()) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0023  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ java.lang.Object O(kotlinx.coroutines.channels.ReceiveChannel receiveChannel, kotlin.coroutines.Continuation continuation) {
        kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$none$1 channelsKt__DeprecatedKt$none$1;
        java.lang.Object obj;
        java.lang.Object coroutine_suspended;
        int i;
        try {
            if (continuation instanceof kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$none$1) {
                channelsKt__DeprecatedKt$none$1 = (kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$none$1) continuation;
                int i2 = channelsKt__DeprecatedKt$none$1.label;
                if ((i2 & Integer.MIN_VALUE) != 0) {
                    channelsKt__DeprecatedKt$none$1.label = i2 - Integer.MIN_VALUE;
                    obj = channelsKt__DeprecatedKt$none$1.result;
                    coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = channelsKt__DeprecatedKt$none$1.label;
                    boolean z = true;
                    if (i != 0) {
                        kotlin.ResultKt.throwOnFailure(obj);
                        kotlinx.coroutines.channels.ChannelIterator it = receiveChannel.iterator();
                        channelsKt__DeprecatedKt$none$1.L$0 = receiveChannel;
                        channelsKt__DeprecatedKt$none$1.label = 1;
                        obj = it.hasNext(channelsKt__DeprecatedKt$none$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        receiveChannel = (kotlinx.coroutines.channels.ReceiveChannel) channelsKt__DeprecatedKt$none$1.L$0;
                        kotlin.ResultKt.throwOnFailure(obj);
                    }
                    if (!((java.lang.Boolean) obj).booleanValue()) {
                        z = false;
                    }
                    java.lang.Boolean boxBoolean = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(z);
                    kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(receiveChannel, null);
                    return boxBoolean;
                }
            }
            if (i != 0) {
            }
            if (!((java.lang.Boolean) obj).booleanValue()) {
            }
            java.lang.Boolean boxBoolean2 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(z);
            kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(receiveChannel, null);
            return boxBoolean2;
        } finally {
        }
        channelsKt__DeprecatedKt$none$1 = new kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$none$1(continuation);
        obj = channelsKt__DeprecatedKt$none$1.result;
        coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__DeprecatedKt$none$1.label;
        boolean z2 = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x008e A[Catch: all -> 0x0032, TRY_ENTER, TryCatch #1 {all -> 0x0032, blocks: (B:12:0x002e, B:13:0x0081, B:18:0x008e, B:19:0x0095), top: B:11:0x002e }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x006c A[Catch: all -> 0x004a, TRY_LEAVE, TryCatch #2 {all -> 0x004a, blocks: (B:33:0x0046, B:34:0x0064, B:36:0x006c, B:40:0x0096, B:41:0x009d), top: B:32:0x0046 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0096 A[Catch: all -> 0x004a, TRY_ENTER, TryCatch #2 {all -> 0x004a, blocks: (B:33:0x0046, B:34:0x0064, B:36:0x006c, B:40:0x0096, B:41:0x009d), top: B:32:0x0046 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ java.lang.Object Q(kotlinx.coroutines.channels.ReceiveChannel receiveChannel, kotlin.coroutines.Continuation continuation) {
        kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$single$1 channelsKt__DeprecatedKt$single$1;
        java.lang.Object obj;
        java.lang.Object coroutine_suspended;
        int i;
        kotlinx.coroutines.channels.ReceiveChannel receiveChannel2;
        java.lang.Throwable th;
        kotlinx.coroutines.channels.ChannelIterator channelIterator;
        kotlinx.coroutines.channels.ReceiveChannel receiveChannel3;
        java.lang.Object obj2;
        if (continuation instanceof kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$single$1) {
            channelsKt__DeprecatedKt$single$1 = (kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$single$1) continuation;
            int i2 = channelsKt__DeprecatedKt$single$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                channelsKt__DeprecatedKt$single$1.label = i2 - Integer.MIN_VALUE;
                obj = channelsKt__DeprecatedKt$single$1.result;
                coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelsKt__DeprecatedKt$single$1.label;
                if (i != 0) {
                    kotlin.ResultKt.throwOnFailure(obj);
                    try {
                        kotlinx.coroutines.channels.ChannelIterator it = receiveChannel.iterator();
                        channelsKt__DeprecatedKt$single$1.L$0 = receiveChannel;
                        channelsKt__DeprecatedKt$single$1.L$1 = it;
                        channelsKt__DeprecatedKt$single$1.label = 1;
                        java.lang.Object hasNext = it.hasNext(channelsKt__DeprecatedKt$single$1);
                        if (hasNext == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        receiveChannel2 = receiveChannel;
                        channelIterator = it;
                        obj = hasNext;
                    } catch (java.lang.Throwable th2) {
                        receiveChannel2 = receiveChannel;
                        th = th2;
                        throw th;
                    }
                } else {
                    if (i != 1) {
                        if (i != 2) {
                            throw new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        obj2 = channelsKt__DeprecatedKt$single$1.L$1;
                        receiveChannel3 = (kotlinx.coroutines.channels.ReceiveChannel) channelsKt__DeprecatedKt$single$1.L$0;
                        try {
                            kotlin.ResultKt.throwOnFailure(obj);
                            if (!((java.lang.Boolean) obj).booleanValue()) {
                                throw new java.lang.IllegalArgumentException("ReceiveChannel has more than one element.");
                            }
                            kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(receiveChannel3, null);
                            return obj2;
                        } catch (java.lang.Throwable th3) {
                            th = th3;
                            receiveChannel2 = receiveChannel3;
                            try {
                                throw th;
                            } catch (java.lang.Throwable th4) {
                                kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(receiveChannel2, th);
                                throw th4;
                            }
                        }
                    }
                    channelIterator = (kotlinx.coroutines.channels.ChannelIterator) channelsKt__DeprecatedKt$single$1.L$1;
                    receiveChannel2 = (kotlinx.coroutines.channels.ReceiveChannel) channelsKt__DeprecatedKt$single$1.L$0;
                    try {
                        kotlin.ResultKt.throwOnFailure(obj);
                    } catch (java.lang.Throwable th5) {
                        th = th5;
                        throw th;
                    }
                }
                if (((java.lang.Boolean) obj).booleanValue()) {
                    throw new java.util.NoSuchElementException("ReceiveChannel is empty.");
                }
                java.lang.Object next = channelIterator.next();
                channelsKt__DeprecatedKt$single$1.L$0 = receiveChannel2;
                channelsKt__DeprecatedKt$single$1.L$1 = next;
                channelsKt__DeprecatedKt$single$1.label = 2;
                java.lang.Object hasNext2 = channelIterator.hasNext(channelsKt__DeprecatedKt$single$1);
                if (hasNext2 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                receiveChannel3 = receiveChannel2;
                obj = hasNext2;
                obj2 = next;
                if (!((java.lang.Boolean) obj).booleanValue()) {
                }
            }
        }
        channelsKt__DeprecatedKt$single$1 = new kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$single$1(continuation);
        obj = channelsKt__DeprecatedKt$single$1.result;
        coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__DeprecatedKt$single$1.label;
        if (i != 0) {
        }
        if (((java.lang.Boolean) obj).booleanValue()) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0071 A[Catch: all -> 0x004b, TRY_ENTER, TRY_LEAVE, TryCatch #3 {all -> 0x004b, blocks: (B:33:0x0047, B:34:0x0065, B:38:0x0071), top: B:32:0x0047 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ java.lang.Object R(kotlinx.coroutines.channels.ReceiveChannel receiveChannel, kotlin.coroutines.Continuation continuation) {
        kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$singleOrNull$1 channelsKt__DeprecatedKt$singleOrNull$1;
        java.lang.Object obj;
        java.lang.Object coroutine_suspended;
        int i;
        kotlinx.coroutines.channels.ReceiveChannel receiveChannel2;
        java.lang.Throwable th;
        kotlinx.coroutines.channels.ChannelIterator channelIterator;
        kotlinx.coroutines.channels.ReceiveChannel receiveChannel3;
        java.lang.Object obj2;
        if (continuation instanceof kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$singleOrNull$1) {
            channelsKt__DeprecatedKt$singleOrNull$1 = (kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$singleOrNull$1) continuation;
            int i2 = channelsKt__DeprecatedKt$singleOrNull$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                channelsKt__DeprecatedKt$singleOrNull$1.label = i2 - Integer.MIN_VALUE;
                obj = channelsKt__DeprecatedKt$singleOrNull$1.result;
                coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelsKt__DeprecatedKt$singleOrNull$1.label;
                if (i != 0) {
                    kotlin.ResultKt.throwOnFailure(obj);
                    try {
                        kotlinx.coroutines.channels.ChannelIterator it = receiveChannel.iterator();
                        channelsKt__DeprecatedKt$singleOrNull$1.L$0 = receiveChannel;
                        channelsKt__DeprecatedKt$singleOrNull$1.L$1 = it;
                        channelsKt__DeprecatedKt$singleOrNull$1.label = 1;
                        java.lang.Object hasNext = it.hasNext(channelsKt__DeprecatedKt$singleOrNull$1);
                        if (hasNext == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        receiveChannel2 = receiveChannel;
                        channelIterator = it;
                        obj = hasNext;
                    } catch (java.lang.Throwable th2) {
                        receiveChannel2 = receiveChannel;
                        th = th2;
                        throw th;
                    }
                } else {
                    if (i != 1) {
                        if (i != 2) {
                            throw new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        obj2 = channelsKt__DeprecatedKt$singleOrNull$1.L$1;
                        receiveChannel3 = (kotlinx.coroutines.channels.ReceiveChannel) channelsKt__DeprecatedKt$singleOrNull$1.L$0;
                        try {
                            kotlin.ResultKt.throwOnFailure(obj);
                            if (((java.lang.Boolean) obj).booleanValue()) {
                                kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(receiveChannel3, null);
                                return obj2;
                            }
                            kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(receiveChannel3, null);
                            return null;
                        } catch (java.lang.Throwable th3) {
                            th = th3;
                            receiveChannel2 = receiveChannel3;
                            try {
                                throw th;
                            } catch (java.lang.Throwable th4) {
                                kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(receiveChannel2, th);
                                throw th4;
                            }
                        }
                    }
                    channelIterator = (kotlinx.coroutines.channels.ChannelIterator) channelsKt__DeprecatedKt$singleOrNull$1.L$1;
                    receiveChannel2 = (kotlinx.coroutines.channels.ReceiveChannel) channelsKt__DeprecatedKt$singleOrNull$1.L$0;
                    try {
                        kotlin.ResultKt.throwOnFailure(obj);
                    } catch (java.lang.Throwable th5) {
                        th = th5;
                        throw th;
                    }
                }
                if (((java.lang.Boolean) obj).booleanValue()) {
                    kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(receiveChannel2, null);
                    return null;
                }
                java.lang.Object next = channelIterator.next();
                channelsKt__DeprecatedKt$singleOrNull$1.L$0 = receiveChannel2;
                channelsKt__DeprecatedKt$singleOrNull$1.L$1 = next;
                channelsKt__DeprecatedKt$singleOrNull$1.label = 2;
                java.lang.Object hasNext2 = channelIterator.hasNext(channelsKt__DeprecatedKt$singleOrNull$1);
                if (hasNext2 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                receiveChannel3 = receiveChannel2;
                obj = hasNext2;
                obj2 = next;
                if (((java.lang.Boolean) obj).booleanValue()) {
                }
            }
        }
        channelsKt__DeprecatedKt$singleOrNull$1 = new kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$singleOrNull$1(continuation);
        obj = channelsKt__DeprecatedKt$singleOrNull$1.result;
        coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__DeprecatedKt$singleOrNull$1.label;
        if (i != 0) {
        }
        if (((java.lang.Boolean) obj).booleanValue()) {
        }
    }

    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ kotlinx.coroutines.channels.ReceiveChannel S(kotlinx.coroutines.channels.ReceiveChannel receiveChannel, int i, kotlin.coroutines.CoroutineContext coroutineContext) {
        return kotlinx.coroutines.channels.ProduceKt.produce$default(kotlinx.coroutines.GlobalScope.INSTANCE, coroutineContext, 0, null, kotlinx.coroutines.channels.ChannelsKt.consumes(receiveChannel), new kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$take$1(i, receiveChannel, null), 6, null);
    }

    public static /* synthetic */ kotlinx.coroutines.channels.ReceiveChannel T(kotlinx.coroutines.channels.ReceiveChannel receiveChannel, int i, kotlin.coroutines.CoroutineContext coroutineContext, int i2, java.lang.Object obj) {
        if ((i2 & 2) != 0) {
            coroutineContext = kotlinx.coroutines.Dispatchers.getUnconfined();
        }
        return S(receiveChannel, i, coroutineContext);
    }

    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ kotlinx.coroutines.channels.ReceiveChannel U(kotlinx.coroutines.channels.ReceiveChannel receiveChannel, kotlin.coroutines.CoroutineContext coroutineContext, kotlin.jvm.functions.Function2 function2) {
        return kotlinx.coroutines.channels.ProduceKt.produce$default(kotlinx.coroutines.GlobalScope.INSTANCE, coroutineContext, 0, null, kotlinx.coroutines.channels.ChannelsKt.consumes(receiveChannel), new kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$takeWhile$1(receiveChannel, function2, null), 6, null);
    }

    public static /* synthetic */ kotlinx.coroutines.channels.ReceiveChannel V(kotlinx.coroutines.channels.ReceiveChannel receiveChannel, kotlin.coroutines.CoroutineContext coroutineContext, kotlin.jvm.functions.Function2 function2, int i, java.lang.Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = kotlinx.coroutines.Dispatchers.getUnconfined();
        }
        return U(receiveChannel, coroutineContext, function2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:16:0x006a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0078 A[Catch: all -> 0x0053, TryCatch #1 {all -> 0x0053, blocks: (B:12:0x0034, B:19:0x0070, B:21:0x0078, B:24:0x008b, B:40:0x004f), top: B:7:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x008b A[Catch: all -> 0x0053, TRY_LEAVE, TryCatch #1 {all -> 0x0053, blocks: (B:12:0x0034, B:19:0x0070, B:21:0x0078, B:24:0x008b, B:40:0x004f), top: B:7:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0024  */
    /* JADX WARN: Type inference failed for: r7v0, types: [C extends kotlinx.coroutines.channels.SendChannel<? super E>] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v2, types: [kotlinx.coroutines.channels.ReceiveChannel] */
    /* JADX WARN: Type inference failed for: r7v25 */
    /* JADX WARN: Type inference failed for: r7v26 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5, types: [java.lang.Object, kotlinx.coroutines.channels.ReceiveChannel] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0088 -> B:13:0x0037). Please report as a decompilation issue!!! */
    @kotlin.PublishedApi
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <E, C extends kotlinx.coroutines.channels.SendChannel<? super E>> java.lang.Object W(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.ReceiveChannel<? extends E> receiveChannel, @org.jetbrains.annotations.NotNull C c, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super C> continuation) {
        kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$toChannel$1 channelsKt__DeprecatedKt$toChannel$1;
        java.lang.Object coroutine_suspended;
        int i;
        kotlinx.coroutines.channels.ChannelIterator<? extends E> it;
        kotlinx.coroutines.channels.ChannelIterator<? extends E> channelIterator;
        kotlinx.coroutines.channels.SendChannel sendChannel;
        kotlinx.coroutines.channels.SendChannel sendChannel2;
        java.lang.Object hasNext;
        try {
            if (continuation instanceof kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$toChannel$1) {
                channelsKt__DeprecatedKt$toChannel$1 = (kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$toChannel$1) continuation;
                int i2 = channelsKt__DeprecatedKt$toChannel$1.label;
                if ((i2 & Integer.MIN_VALUE) != 0) {
                    channelsKt__DeprecatedKt$toChannel$1.label = i2 - Integer.MIN_VALUE;
                    java.lang.Object obj = channelsKt__DeprecatedKt$toChannel$1.result;
                    coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = channelsKt__DeprecatedKt$toChannel$1.label;
                    if (i != 0) {
                        kotlin.ResultKt.throwOnFailure(obj);
                        try {
                            it = receiveChannel.iterator();
                            sendChannel2 = c;
                            channelsKt__DeprecatedKt$toChannel$1.L$0 = sendChannel2;
                            channelsKt__DeprecatedKt$toChannel$1.L$1 = receiveChannel;
                            channelsKt__DeprecatedKt$toChannel$1.L$2 = it;
                            channelsKt__DeprecatedKt$toChannel$1.label = 1;
                            hasNext = it.hasNext(channelsKt__DeprecatedKt$toChannel$1);
                            if (hasNext == coroutine_suspended) {
                            }
                        } catch (java.lang.Throwable th) {
                            c = receiveChannel;
                            th = th;
                            try {
                                throw th;
                            } catch (java.lang.Throwable th2) {
                                kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(c, th);
                                throw th2;
                            }
                        }
                    } else if (i == 1) {
                        channelIterator = (kotlinx.coroutines.channels.ChannelIterator) channelsKt__DeprecatedKt$toChannel$1.L$2;
                        boolean z = (C) ((kotlinx.coroutines.channels.ReceiveChannel) channelsKt__DeprecatedKt$toChannel$1.L$1);
                        sendChannel = (kotlinx.coroutines.channels.SendChannel) channelsKt__DeprecatedKt$toChannel$1.L$0;
                        kotlin.ResultKt.throwOnFailure(obj);
                        c = z;
                        if (((java.lang.Boolean) obj).booleanValue()) {
                        }
                    } else {
                        if (i != 2) {
                            throw new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        channelIterator = (kotlinx.coroutines.channels.ChannelIterator) channelsKt__DeprecatedKt$toChannel$1.L$2;
                        kotlinx.coroutines.channels.ReceiveChannel<? extends E> receiveChannel2 = (C) ((kotlinx.coroutines.channels.ReceiveChannel) channelsKt__DeprecatedKt$toChannel$1.L$1);
                        sendChannel = (kotlinx.coroutines.channels.SendChannel) channelsKt__DeprecatedKt$toChannel$1.L$0;
                        kotlin.ResultKt.throwOnFailure(obj);
                        kotlinx.coroutines.channels.ReceiveChannel<? extends E> receiveChannel3 = receiveChannel2;
                        it = channelIterator;
                        receiveChannel = receiveChannel3;
                        sendChannel2 = (C) sendChannel;
                        channelsKt__DeprecatedKt$toChannel$1.L$0 = sendChannel2;
                        channelsKt__DeprecatedKt$toChannel$1.L$1 = receiveChannel;
                        channelsKt__DeprecatedKt$toChannel$1.L$2 = it;
                        channelsKt__DeprecatedKt$toChannel$1.label = 1;
                        hasNext = it.hasNext(channelsKt__DeprecatedKt$toChannel$1);
                        if (hasNext == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        kotlinx.coroutines.channels.SendChannel sendChannel3 = sendChannel2;
                        boolean z2 = (C) receiveChannel;
                        channelIterator = it;
                        obj = hasNext;
                        sendChannel = sendChannel3;
                        c = z2;
                        if (((java.lang.Boolean) obj).booleanValue()) {
                            kotlin.Unit unit = kotlin.Unit.INSTANCE;
                            kotlinx.coroutines.channels.ChannelsKt.cancelConsumed((kotlinx.coroutines.channels.ReceiveChannel) c, null);
                            return sendChannel;
                        }
                        E next = channelIterator.next();
                        channelsKt__DeprecatedKt$toChannel$1.L$0 = sendChannel;
                        channelsKt__DeprecatedKt$toChannel$1.L$1 = (java.lang.Object) c;
                        channelsKt__DeprecatedKt$toChannel$1.L$2 = channelIterator;
                        channelsKt__DeprecatedKt$toChannel$1.label = 2;
                        receiveChannel3 = c;
                        if (sendChannel.send(next, channelsKt__DeprecatedKt$toChannel$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        it = channelIterator;
                        receiveChannel = receiveChannel3;
                        sendChannel2 = (C) sendChannel;
                        channelsKt__DeprecatedKt$toChannel$1.L$0 = sendChannel2;
                        channelsKt__DeprecatedKt$toChannel$1.L$1 = receiveChannel;
                        channelsKt__DeprecatedKt$toChannel$1.L$2 = it;
                        channelsKt__DeprecatedKt$toChannel$1.label = 1;
                        hasNext = it.hasNext(channelsKt__DeprecatedKt$toChannel$1);
                        if (hasNext == coroutine_suspended) {
                        }
                    }
                }
            }
            if (i != 0) {
            }
        } catch (java.lang.Throwable th3) {
            th = th3;
        }
        channelsKt__DeprecatedKt$toChannel$1 = new kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$toChannel$1(continuation);
        java.lang.Object obj2 = channelsKt__DeprecatedKt$toChannel$1.result;
        coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__DeprecatedKt$toChannel$1.label;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0064 A[Catch: all -> 0x0035, TryCatch #1 {all -> 0x0035, blocks: (B:11:0x0031, B:12:0x005c, B:14:0x0064, B:15:0x004a, B:20:0x006d), top: B:10:0x0031 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0058 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x006d A[Catch: all -> 0x0035, TRY_LEAVE, TryCatch #1 {all -> 0x0035, blocks: (B:11:0x0031, B:12:0x005c, B:14:0x0064, B:15:0x004a, B:20:0x006d), top: B:10:0x0031 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Object, java.util.Collection] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0059 -> B:12:0x005c). Please report as a decompilation issue!!! */
    @kotlin.PublishedApi
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <E, C extends java.util.Collection<? super E>> java.lang.Object X(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.ReceiveChannel<? extends E> receiveChannel, @org.jetbrains.annotations.NotNull C c, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super C> continuation) {
        kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$toCollection$1 channelsKt__DeprecatedKt$toCollection$1;
        java.lang.Object coroutine_suspended;
        int i;
        kotlinx.coroutines.channels.ReceiveChannel<? extends E> receiveChannel2;
        java.lang.Throwable th;
        kotlinx.coroutines.channels.ChannelIterator it;
        C c2;
        java.lang.Object hasNext;
        if (continuation instanceof kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$toCollection$1) {
            channelsKt__DeprecatedKt$toCollection$1 = (kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$toCollection$1) continuation;
            int i2 = channelsKt__DeprecatedKt$toCollection$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                channelsKt__DeprecatedKt$toCollection$1.label = i2 - Integer.MIN_VALUE;
                java.lang.Object obj = channelsKt__DeprecatedKt$toCollection$1.result;
                coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelsKt__DeprecatedKt$toCollection$1.label;
                if (i != 0) {
                    kotlin.ResultKt.throwOnFailure(obj);
                    try {
                        receiveChannel2 = receiveChannel;
                        it = receiveChannel.iterator();
                        c2 = c;
                        channelsKt__DeprecatedKt$toCollection$1.L$0 = c2;
                        channelsKt__DeprecatedKt$toCollection$1.L$1 = receiveChannel2;
                        channelsKt__DeprecatedKt$toCollection$1.L$2 = it;
                        channelsKt__DeprecatedKt$toCollection$1.label = 1;
                        hasNext = it.hasNext(channelsKt__DeprecatedKt$toCollection$1);
                        if (hasNext != coroutine_suspended) {
                        }
                    } catch (java.lang.Throwable th2) {
                        receiveChannel2 = receiveChannel;
                        th = th2;
                        throw th;
                    }
                } else {
                    if (i != 1) {
                        throw new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    it = (kotlinx.coroutines.channels.ChannelIterator) channelsKt__DeprecatedKt$toCollection$1.L$2;
                    receiveChannel2 = (kotlinx.coroutines.channels.ReceiveChannel) channelsKt__DeprecatedKt$toCollection$1.L$1;
                    java.util.Collection collection = (java.util.Collection) channelsKt__DeprecatedKt$toCollection$1.L$0;
                    try {
                        kotlin.ResultKt.throwOnFailure(obj);
                        ?? r2 = collection;
                        if (!((java.lang.Boolean) obj).booleanValue()) {
                            r2.add(it.next());
                            c2 = r2;
                            channelsKt__DeprecatedKt$toCollection$1.L$0 = c2;
                            channelsKt__DeprecatedKt$toCollection$1.L$1 = receiveChannel2;
                            channelsKt__DeprecatedKt$toCollection$1.L$2 = it;
                            channelsKt__DeprecatedKt$toCollection$1.label = 1;
                            hasNext = it.hasNext(channelsKt__DeprecatedKt$toCollection$1);
                            if (hasNext != coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            r2 = c2;
                            obj = hasNext;
                            if (!((java.lang.Boolean) obj).booleanValue()) {
                                kotlin.Unit unit = kotlin.Unit.INSTANCE;
                                kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(receiveChannel2, null);
                                return r2;
                            }
                        }
                    } catch (java.lang.Throwable th3) {
                        th = th3;
                        try {
                            throw th;
                        } catch (java.lang.Throwable th4) {
                            kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(receiveChannel2, th);
                            throw th4;
                        }
                    }
                }
            }
        }
        channelsKt__DeprecatedKt$toCollection$1 = new kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$toCollection$1(continuation);
        java.lang.Object obj2 = channelsKt__DeprecatedKt$toCollection$1.result;
        coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__DeprecatedKt$toCollection$1.label;
        if (i != 0) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0064 A[Catch: all -> 0x0035, TryCatch #1 {all -> 0x0035, blocks: (B:11:0x0031, B:12:0x005c, B:14:0x0064, B:15:0x004a, B:20:0x0077), top: B:10:0x0031 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0058 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0077 A[Catch: all -> 0x0035, TRY_LEAVE, TryCatch #1 {all -> 0x0035, blocks: (B:11:0x0031, B:12:0x005c, B:14:0x0064, B:15:0x004a, B:20:0x0077), top: B:10:0x0031 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Object, java.util.Map] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0059 -> B:12:0x005c). Please report as a decompilation issue!!! */
    @kotlin.PublishedApi
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <K, V, M extends java.util.Map<? super K, ? super V>> java.lang.Object Y(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.ReceiveChannel<? extends kotlin.Pair<? extends K, ? extends V>> receiveChannel, @org.jetbrains.annotations.NotNull M m, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super M> continuation) {
        kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$toMap$2 channelsKt__DeprecatedKt$toMap$2;
        java.lang.Object coroutine_suspended;
        int i;
        kotlinx.coroutines.channels.ReceiveChannel<? extends kotlin.Pair<? extends K, ? extends V>> receiveChannel2;
        java.lang.Throwable th;
        kotlinx.coroutines.channels.ChannelIterator it;
        M m2;
        java.lang.Object hasNext;
        if (continuation instanceof kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$toMap$2) {
            channelsKt__DeprecatedKt$toMap$2 = (kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$toMap$2) continuation;
            int i2 = channelsKt__DeprecatedKt$toMap$2.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                channelsKt__DeprecatedKt$toMap$2.label = i2 - Integer.MIN_VALUE;
                java.lang.Object obj = channelsKt__DeprecatedKt$toMap$2.result;
                coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelsKt__DeprecatedKt$toMap$2.label;
                if (i != 0) {
                    kotlin.ResultKt.throwOnFailure(obj);
                    try {
                        receiveChannel2 = receiveChannel;
                        it = receiveChannel.iterator();
                        m2 = m;
                        channelsKt__DeprecatedKt$toMap$2.L$0 = m2;
                        channelsKt__DeprecatedKt$toMap$2.L$1 = receiveChannel2;
                        channelsKt__DeprecatedKt$toMap$2.L$2 = it;
                        channelsKt__DeprecatedKt$toMap$2.label = 1;
                        hasNext = it.hasNext(channelsKt__DeprecatedKt$toMap$2);
                        if (hasNext != coroutine_suspended) {
                        }
                    } catch (java.lang.Throwable th2) {
                        receiveChannel2 = receiveChannel;
                        th = th2;
                        throw th;
                    }
                } else {
                    if (i != 1) {
                        throw new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    it = (kotlinx.coroutines.channels.ChannelIterator) channelsKt__DeprecatedKt$toMap$2.L$2;
                    receiveChannel2 = (kotlinx.coroutines.channels.ReceiveChannel) channelsKt__DeprecatedKt$toMap$2.L$1;
                    java.util.Map map = (java.util.Map) channelsKt__DeprecatedKt$toMap$2.L$0;
                    try {
                        kotlin.ResultKt.throwOnFailure(obj);
                        ?? r2 = map;
                        if (!((java.lang.Boolean) obj).booleanValue()) {
                            kotlin.Pair pair = (kotlin.Pair) it.next();
                            r2.put(pair.getFirst(), pair.getSecond());
                            m2 = r2;
                            channelsKt__DeprecatedKt$toMap$2.L$0 = m2;
                            channelsKt__DeprecatedKt$toMap$2.L$1 = receiveChannel2;
                            channelsKt__DeprecatedKt$toMap$2.L$2 = it;
                            channelsKt__DeprecatedKt$toMap$2.label = 1;
                            hasNext = it.hasNext(channelsKt__DeprecatedKt$toMap$2);
                            if (hasNext != coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            r2 = m2;
                            obj = hasNext;
                            if (!((java.lang.Boolean) obj).booleanValue()) {
                                kotlin.Unit unit = kotlin.Unit.INSTANCE;
                                kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(receiveChannel2, null);
                                return r2;
                            }
                        }
                    } catch (java.lang.Throwable th3) {
                        th = th3;
                        try {
                            throw th;
                        } catch (java.lang.Throwable th4) {
                            kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(receiveChannel2, th);
                            throw th4;
                        }
                    }
                }
            }
        }
        channelsKt__DeprecatedKt$toMap$2 = new kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$toMap$2(continuation);
        java.lang.Object obj2 = channelsKt__DeprecatedKt$toMap$2.result;
        coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__DeprecatedKt$toMap$2.label;
        if (i != 0) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0023  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ java.lang.Object a(kotlinx.coroutines.channels.ReceiveChannel receiveChannel, kotlin.coroutines.Continuation continuation) {
        kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$any$1 channelsKt__DeprecatedKt$any$1;
        java.lang.Object coroutine_suspended;
        int i;
        try {
            if (continuation instanceof kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$any$1) {
                channelsKt__DeprecatedKt$any$1 = (kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$any$1) continuation;
                int i2 = channelsKt__DeprecatedKt$any$1.label;
                if ((i2 & Integer.MIN_VALUE) != 0) {
                    channelsKt__DeprecatedKt$any$1.label = i2 - Integer.MIN_VALUE;
                    java.lang.Object obj = channelsKt__DeprecatedKt$any$1.result;
                    coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = channelsKt__DeprecatedKt$any$1.label;
                    if (i != 0) {
                        kotlin.ResultKt.throwOnFailure(obj);
                        kotlinx.coroutines.channels.ChannelIterator it = receiveChannel.iterator();
                        channelsKt__DeprecatedKt$any$1.L$0 = receiveChannel;
                        channelsKt__DeprecatedKt$any$1.label = 1;
                        obj = it.hasNext(channelsKt__DeprecatedKt$any$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        receiveChannel = (kotlinx.coroutines.channels.ReceiveChannel) channelsKt__DeprecatedKt$any$1.L$0;
                        kotlin.ResultKt.throwOnFailure(obj);
                    }
                    kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(receiveChannel, null);
                    return obj;
                }
            }
            if (i != 0) {
            }
            kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(receiveChannel, null);
            return obj;
        } finally {
        }
        channelsKt__DeprecatedKt$any$1 = new kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$any$1(continuation);
        java.lang.Object obj2 = channelsKt__DeprecatedKt$any$1.result;
        coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__DeprecatedKt$any$1.label;
    }

    @kotlin.PublishedApi
    @org.jetbrains.annotations.NotNull
    public static final kotlin.jvm.functions.Function1<java.lang.Throwable, kotlin.Unit> b(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.ReceiveChannel<?> receiveChannel) {
        return new kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$consumes$1(receiveChannel);
    }

    @kotlin.PublishedApi
    @org.jetbrains.annotations.Nullable
    public static final <E> java.lang.Object b0(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.ReceiveChannel<? extends E> receiveChannel, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.util.Set<E>> continuation) {
        return kotlinx.coroutines.channels.ChannelsKt.toCollection(receiveChannel, new java.util.LinkedHashSet(), continuation);
    }

    @kotlin.PublishedApi
    @org.jetbrains.annotations.NotNull
    public static final kotlin.jvm.functions.Function1<java.lang.Throwable, kotlin.Unit> c(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.ReceiveChannel<?>... receiveChannelArr) {
        return new kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$consumesAll$1(receiveChannelArr);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0068 A[Catch: all -> 0x0035, TryCatch #1 {all -> 0x0035, blocks: (B:11:0x0031, B:12:0x0060, B:14:0x0068, B:30:0x0072), top: B:10:0x0031 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x005c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0072 A[Catch: all -> 0x0035, TRY_LEAVE, TryCatch #1 {all -> 0x0035, blocks: (B:11:0x0031, B:12:0x0060, B:14:0x0068, B:30:0x0072), top: B:10:0x0031 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x005d -> B:12:0x0060). Please report as a decompilation issue!!! */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ java.lang.Object d(kotlinx.coroutines.channels.ReceiveChannel receiveChannel, kotlin.coroutines.Continuation continuation) {
        kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$count$1 channelsKt__DeprecatedKt$count$1;
        java.lang.Object coroutine_suspended;
        int i;
        kotlinx.coroutines.channels.ReceiveChannel receiveChannel2;
        java.lang.Throwable th;
        kotlin.jvm.internal.Ref.IntRef intRef;
        kotlinx.coroutines.channels.ReceiveChannel receiveChannel3;
        kotlinx.coroutines.channels.ChannelIterator it;
        java.lang.Object hasNext;
        if (continuation instanceof kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$count$1) {
            channelsKt__DeprecatedKt$count$1 = (kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$count$1) continuation;
            int i2 = channelsKt__DeprecatedKt$count$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                channelsKt__DeprecatedKt$count$1.label = i2 - Integer.MIN_VALUE;
                java.lang.Object obj = channelsKt__DeprecatedKt$count$1.result;
                coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelsKt__DeprecatedKt$count$1.label;
                if (i != 0) {
                    kotlin.ResultKt.throwOnFailure(obj);
                    try {
                        intRef = new kotlin.jvm.internal.Ref.IntRef();
                        receiveChannel3 = receiveChannel;
                        it = receiveChannel.iterator();
                        channelsKt__DeprecatedKt$count$1.L$0 = intRef;
                        channelsKt__DeprecatedKt$count$1.L$1 = receiveChannel3;
                        channelsKt__DeprecatedKt$count$1.L$2 = it;
                        channelsKt__DeprecatedKt$count$1.label = 1;
                        hasNext = it.hasNext(channelsKt__DeprecatedKt$count$1);
                        if (hasNext != coroutine_suspended) {
                        }
                    } catch (java.lang.Throwable th2) {
                        receiveChannel2 = receiveChannel;
                        th = th2;
                        throw th;
                    }
                } else {
                    if (i != 1) {
                        throw new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    it = (kotlinx.coroutines.channels.ChannelIterator) channelsKt__DeprecatedKt$count$1.L$2;
                    receiveChannel2 = (kotlinx.coroutines.channels.ReceiveChannel) channelsKt__DeprecatedKt$count$1.L$1;
                    intRef = (kotlin.jvm.internal.Ref.IntRef) channelsKt__DeprecatedKt$count$1.L$0;
                    try {
                        kotlin.ResultKt.throwOnFailure(obj);
                        if (!((java.lang.Boolean) obj).booleanValue()) {
                            it.next();
                            intRef.element++;
                            receiveChannel3 = receiveChannel2;
                            try {
                                channelsKt__DeprecatedKt$count$1.L$0 = intRef;
                                channelsKt__DeprecatedKt$count$1.L$1 = receiveChannel3;
                                channelsKt__DeprecatedKt$count$1.L$2 = it;
                                channelsKt__DeprecatedKt$count$1.label = 1;
                                hasNext = it.hasNext(channelsKt__DeprecatedKt$count$1);
                                if (hasNext != coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                receiveChannel2 = receiveChannel3;
                                obj = hasNext;
                                if (!((java.lang.Boolean) obj).booleanValue()) {
                                    kotlin.Unit unit = kotlin.Unit.INSTANCE;
                                    kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(receiveChannel2, null);
                                    return kotlin.coroutines.jvm.internal.Boxing.boxInt(intRef.element);
                                }
                            } catch (java.lang.Throwable th3) {
                                th = th3;
                                receiveChannel2 = receiveChannel3;
                                try {
                                    throw th;
                                } catch (java.lang.Throwable th4) {
                                    kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(receiveChannel2, th);
                                    throw th4;
                                }
                            }
                        }
                    } catch (java.lang.Throwable th5) {
                        th = th5;
                        throw th;
                    }
                }
            }
        }
        channelsKt__DeprecatedKt$count$1 = new kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$count$1(continuation);
        java.lang.Object obj2 = channelsKt__DeprecatedKt$count$1.result;
        coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__DeprecatedKt$count$1.label;
        if (i != 0) {
        }
    }

    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ kotlinx.coroutines.channels.ReceiveChannel d0(kotlinx.coroutines.channels.ReceiveChannel receiveChannel, kotlin.coroutines.CoroutineContext coroutineContext) {
        return kotlinx.coroutines.channels.ProduceKt.produce$default(kotlinx.coroutines.GlobalScope.INSTANCE, coroutineContext, 0, null, kotlinx.coroutines.channels.ChannelsKt.consumes(receiveChannel), new kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$withIndex$1(receiveChannel, null), 6, null);
    }

    public static /* synthetic */ kotlinx.coroutines.channels.ReceiveChannel e0(kotlinx.coroutines.channels.ReceiveChannel receiveChannel, kotlin.coroutines.CoroutineContext coroutineContext, int i, java.lang.Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = kotlinx.coroutines.Dispatchers.getUnconfined();
        }
        return d0(receiveChannel, coroutineContext);
    }

    @kotlin.PublishedApi
    @org.jetbrains.annotations.NotNull
    public static final <E, K> kotlinx.coroutines.channels.ReceiveChannel<E> f(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.ReceiveChannel<? extends E> receiveChannel, @org.jetbrains.annotations.NotNull kotlin.coroutines.CoroutineContext coroutineContext, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super E, ? super kotlin.coroutines.Continuation<? super K>, ? extends java.lang.Object> function2) {
        return kotlinx.coroutines.channels.ProduceKt.produce$default(kotlinx.coroutines.GlobalScope.INSTANCE, coroutineContext, 0, null, kotlinx.coroutines.channels.ChannelsKt.consumes(receiveChannel), new kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$distinctBy$1(receiveChannel, function2, null), 6, null);
    }

    public static /* synthetic */ kotlinx.coroutines.channels.ReceiveChannel g(kotlinx.coroutines.channels.ReceiveChannel receiveChannel, kotlin.coroutines.CoroutineContext coroutineContext, kotlin.jvm.functions.Function2 function2, int i, java.lang.Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = kotlinx.coroutines.Dispatchers.getUnconfined();
        }
        return kotlinx.coroutines.channels.ChannelsKt.distinctBy(receiveChannel, coroutineContext, function2);
    }

    @kotlin.PublishedApi
    @org.jetbrains.annotations.NotNull
    public static final <E, R, V> kotlinx.coroutines.channels.ReceiveChannel<V> g0(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.ReceiveChannel<? extends E> receiveChannel, @org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.ReceiveChannel<? extends R> receiveChannel2, @org.jetbrains.annotations.NotNull kotlin.coroutines.CoroutineContext coroutineContext, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super E, ? super R, ? extends V> function2) {
        return kotlinx.coroutines.channels.ProduceKt.produce$default(kotlinx.coroutines.GlobalScope.INSTANCE, coroutineContext, 0, null, kotlinx.coroutines.channels.ChannelsKt.consumesAll(receiveChannel, receiveChannel2), new kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$zip$2(receiveChannel2, receiveChannel, function2, null), 6, null);
    }

    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ kotlinx.coroutines.channels.ReceiveChannel h(kotlinx.coroutines.channels.ReceiveChannel receiveChannel, int i, kotlin.coroutines.CoroutineContext coroutineContext) {
        return kotlinx.coroutines.channels.ProduceKt.produce$default(kotlinx.coroutines.GlobalScope.INSTANCE, coroutineContext, 0, null, kotlinx.coroutines.channels.ChannelsKt.consumes(receiveChannel), new kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$drop$1(i, receiveChannel, null), 6, null);
    }

    public static /* synthetic */ kotlinx.coroutines.channels.ReceiveChannel h0(kotlinx.coroutines.channels.ReceiveChannel receiveChannel, kotlinx.coroutines.channels.ReceiveChannel receiveChannel2, kotlin.coroutines.CoroutineContext coroutineContext, kotlin.jvm.functions.Function2 function2, int i, java.lang.Object obj) {
        if ((i & 2) != 0) {
            coroutineContext = kotlinx.coroutines.Dispatchers.getUnconfined();
        }
        return kotlinx.coroutines.channels.ChannelsKt.zip(receiveChannel, receiveChannel2, coroutineContext, function2);
    }

    public static /* synthetic */ kotlinx.coroutines.channels.ReceiveChannel i(kotlinx.coroutines.channels.ReceiveChannel receiveChannel, int i, kotlin.coroutines.CoroutineContext coroutineContext, int i2, java.lang.Object obj) {
        if ((i2 & 2) != 0) {
            coroutineContext = kotlinx.coroutines.Dispatchers.getUnconfined();
        }
        return h(receiveChannel, i, coroutineContext);
    }

    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ kotlinx.coroutines.channels.ReceiveChannel j(kotlinx.coroutines.channels.ReceiveChannel receiveChannel, kotlin.coroutines.CoroutineContext coroutineContext, kotlin.jvm.functions.Function2 function2) {
        return kotlinx.coroutines.channels.ProduceKt.produce$default(kotlinx.coroutines.GlobalScope.INSTANCE, coroutineContext, 0, null, kotlinx.coroutines.channels.ChannelsKt.consumes(receiveChannel), new kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$dropWhile$1(receiveChannel, function2, null), 6, null);
    }

    public static /* synthetic */ kotlinx.coroutines.channels.ReceiveChannel k(kotlinx.coroutines.channels.ReceiveChannel receiveChannel, kotlin.coroutines.CoroutineContext coroutineContext, kotlin.jvm.functions.Function2 function2, int i, java.lang.Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = kotlinx.coroutines.Dispatchers.getUnconfined();
        }
        return j(receiveChannel, coroutineContext, function2);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x006c A[Catch: all -> 0x0039, TRY_LEAVE, TryCatch #2 {all -> 0x0039, blocks: (B:12:0x0035, B:13:0x0064, B:15:0x006c, B:26:0x007d, B:27:0x0094), top: B:11:0x0035 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x005e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x007d A[Catch: all -> 0x0039, TRY_ENTER, TryCatch #2 {all -> 0x0039, blocks: (B:12:0x0035, B:13:0x0064, B:15:0x006c, B:26:0x007d, B:27:0x0094), top: B:11:0x0035 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0027  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x005f -> B:13:0x0064). Please report as a decompilation issue!!! */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ java.lang.Object l(kotlinx.coroutines.channels.ReceiveChannel receiveChannel, int i, kotlin.coroutines.Continuation continuation) {
        kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$elementAt$1 channelsKt__DeprecatedKt$elementAt$1;
        java.lang.Object coroutine_suspended;
        int i2;
        kotlinx.coroutines.channels.ReceiveChannel receiveChannel2;
        java.lang.Throwable th;
        kotlinx.coroutines.channels.ChannelIterator it;
        int i3;
        java.lang.Object hasNext;
        try {
            if (continuation instanceof kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$elementAt$1) {
                channelsKt__DeprecatedKt$elementAt$1 = (kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$elementAt$1) continuation;
                int i4 = channelsKt__DeprecatedKt$elementAt$1.label;
                if ((i4 & Integer.MIN_VALUE) != 0) {
                    channelsKt__DeprecatedKt$elementAt$1.label = i4 - Integer.MIN_VALUE;
                    java.lang.Object obj = channelsKt__DeprecatedKt$elementAt$1.result;
                    coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i2 = channelsKt__DeprecatedKt$elementAt$1.label;
                    if (i2 != 0) {
                        kotlin.ResultKt.throwOnFailure(obj);
                        if (i < 0) {
                            throw new java.lang.IndexOutOfBoundsException("ReceiveChannel doesn't contain element at index " + i + '.');
                        }
                        it = receiveChannel.iterator();
                        i3 = 0;
                        channelsKt__DeprecatedKt$elementAt$1.L$0 = receiveChannel;
                        channelsKt__DeprecatedKt$elementAt$1.L$1 = it;
                        channelsKt__DeprecatedKt$elementAt$1.I$0 = i;
                        channelsKt__DeprecatedKt$elementAt$1.I$1 = i3;
                        channelsKt__DeprecatedKt$elementAt$1.label = 1;
                        hasNext = it.hasNext(channelsKt__DeprecatedKt$elementAt$1);
                        if (hasNext != coroutine_suspended) {
                        }
                    } else {
                        if (i2 != 1) {
                            throw new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        int i5 = channelsKt__DeprecatedKt$elementAt$1.I$1;
                        i = channelsKt__DeprecatedKt$elementAt$1.I$0;
                        kotlinx.coroutines.channels.ChannelIterator channelIterator = (kotlinx.coroutines.channels.ChannelIterator) channelsKt__DeprecatedKt$elementAt$1.L$1;
                        receiveChannel2 = (kotlinx.coroutines.channels.ReceiveChannel) channelsKt__DeprecatedKt$elementAt$1.L$0;
                        try {
                            kotlin.ResultKt.throwOnFailure(obj);
                            if (!((java.lang.Boolean) obj).booleanValue()) {
                                java.lang.Object next = channelIterator.next();
                                int i6 = i5 + 1;
                                if (i == i5) {
                                    kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(receiveChannel2, null);
                                    return next;
                                }
                                it = channelIterator;
                                receiveChannel = receiveChannel2;
                                i3 = i6;
                                channelsKt__DeprecatedKt$elementAt$1.L$0 = receiveChannel;
                                channelsKt__DeprecatedKt$elementAt$1.L$1 = it;
                                channelsKt__DeprecatedKt$elementAt$1.I$0 = i;
                                channelsKt__DeprecatedKt$elementAt$1.I$1 = i3;
                                channelsKt__DeprecatedKt$elementAt$1.label = 1;
                                hasNext = it.hasNext(channelsKt__DeprecatedKt$elementAt$1);
                                if (hasNext != coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                receiveChannel2 = receiveChannel;
                                i5 = i3;
                                channelIterator = it;
                                obj = hasNext;
                                if (!((java.lang.Boolean) obj).booleanValue()) {
                                    throw new java.lang.IndexOutOfBoundsException("ReceiveChannel doesn't contain element at index " + i + '.');
                                }
                            }
                        } catch (java.lang.Throwable th2) {
                            th = th2;
                            try {
                                throw th;
                            } catch (java.lang.Throwable th3) {
                                kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(receiveChannel2, th);
                                throw th3;
                            }
                        }
                    }
                }
            }
            if (i2 != 0) {
            }
        } catch (java.lang.Throwable th4) {
            receiveChannel2 = receiveChannel;
            th = th4;
        }
        channelsKt__DeprecatedKt$elementAt$1 = new kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$elementAt$1(continuation);
        java.lang.Object obj2 = channelsKt__DeprecatedKt$elementAt$1.result;
        coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i2 = channelsKt__DeprecatedKt$elementAt$1.label;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0072 A[Catch: all -> 0x0087, TRY_LEAVE, TryCatch #0 {all -> 0x0087, blocks: (B:13:0x006a, B:15:0x0072, B:22:0x0054, B:46:0x004f), top: B:45:0x004f }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0064 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0065 -> B:13:0x006a). Please report as a decompilation issue!!! */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ java.lang.Object m(kotlinx.coroutines.channels.ReceiveChannel receiveChannel, int i, kotlin.coroutines.Continuation continuation) {
        kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$elementAtOrNull$1 channelsKt__DeprecatedKt$elementAtOrNull$1;
        java.lang.Object coroutine_suspended;
        int i2;
        kotlinx.coroutines.channels.ChannelIterator it;
        int i3;
        java.lang.Throwable th;
        kotlinx.coroutines.channels.ReceiveChannel receiveChannel2;
        java.lang.Object hasNext;
        if (continuation instanceof kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$elementAtOrNull$1) {
            channelsKt__DeprecatedKt$elementAtOrNull$1 = (kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$elementAtOrNull$1) continuation;
            int i4 = channelsKt__DeprecatedKt$elementAtOrNull$1.label;
            if ((i4 & Integer.MIN_VALUE) != 0) {
                channelsKt__DeprecatedKt$elementAtOrNull$1.label = i4 - Integer.MIN_VALUE;
                java.lang.Object obj = channelsKt__DeprecatedKt$elementAtOrNull$1.result;
                coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i2 = channelsKt__DeprecatedKt$elementAtOrNull$1.label;
                if (i2 != 0) {
                    kotlin.ResultKt.throwOnFailure(obj);
                    if (i < 0) {
                        kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(receiveChannel, null);
                        return null;
                    }
                    try {
                        it = receiveChannel.iterator();
                        i3 = 0;
                        channelsKt__DeprecatedKt$elementAtOrNull$1.L$0 = receiveChannel;
                        channelsKt__DeprecatedKt$elementAtOrNull$1.L$1 = it;
                        channelsKt__DeprecatedKt$elementAtOrNull$1.I$0 = i;
                        channelsKt__DeprecatedKt$elementAtOrNull$1.I$1 = i3;
                        channelsKt__DeprecatedKt$elementAtOrNull$1.label = 1;
                        hasNext = it.hasNext(channelsKt__DeprecatedKt$elementAtOrNull$1);
                        if (hasNext != coroutine_suspended) {
                        }
                    } catch (java.lang.Throwable th2) {
                        receiveChannel2 = receiveChannel;
                        th = th2;
                        throw th;
                    }
                } else {
                    if (i2 != 1) {
                        throw new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    int i5 = channelsKt__DeprecatedKt$elementAtOrNull$1.I$1;
                    i = channelsKt__DeprecatedKt$elementAtOrNull$1.I$0;
                    kotlinx.coroutines.channels.ChannelIterator channelIterator = (kotlinx.coroutines.channels.ChannelIterator) channelsKt__DeprecatedKt$elementAtOrNull$1.L$1;
                    receiveChannel2 = (kotlinx.coroutines.channels.ReceiveChannel) channelsKt__DeprecatedKt$elementAtOrNull$1.L$0;
                    try {
                        kotlin.ResultKt.throwOnFailure(obj);
                        i3 = i5;
                        receiveChannel = receiveChannel2;
                        java.lang.Object obj2 = coroutine_suspended;
                        kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$elementAtOrNull$1 channelsKt__DeprecatedKt$elementAtOrNull$12 = channelsKt__DeprecatedKt$elementAtOrNull$1;
                        kotlinx.coroutines.channels.ChannelIterator channelIterator2 = channelIterator;
                        if (!((java.lang.Boolean) obj).booleanValue()) {
                            java.lang.Object next = channelIterator2.next();
                            int i6 = i3 + 1;
                            if (i == i3) {
                                kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(receiveChannel, null);
                                return next;
                            }
                            it = channelIterator2;
                            channelsKt__DeprecatedKt$elementAtOrNull$1 = channelsKt__DeprecatedKt$elementAtOrNull$12;
                            coroutine_suspended = obj2;
                            i3 = i6;
                            channelsKt__DeprecatedKt$elementAtOrNull$1.L$0 = receiveChannel;
                            channelsKt__DeprecatedKt$elementAtOrNull$1.L$1 = it;
                            channelsKt__DeprecatedKt$elementAtOrNull$1.I$0 = i;
                            channelsKt__DeprecatedKt$elementAtOrNull$1.I$1 = i3;
                            channelsKt__DeprecatedKt$elementAtOrNull$1.label = 1;
                            hasNext = it.hasNext(channelsKt__DeprecatedKt$elementAtOrNull$1);
                            if (hasNext != coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$elementAtOrNull$1 channelsKt__DeprecatedKt$elementAtOrNull$13 = channelsKt__DeprecatedKt$elementAtOrNull$1;
                            channelIterator2 = it;
                            obj = hasNext;
                            obj2 = coroutine_suspended;
                            channelsKt__DeprecatedKt$elementAtOrNull$12 = channelsKt__DeprecatedKt$elementAtOrNull$13;
                            if (!((java.lang.Boolean) obj).booleanValue()) {
                                kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(receiveChannel, null);
                                return null;
                            }
                        }
                    } catch (java.lang.Throwable th3) {
                        th = th3;
                        try {
                            throw th;
                        } catch (java.lang.Throwable th4) {
                            kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(receiveChannel2, th);
                            throw th4;
                        }
                    }
                }
            }
        }
        channelsKt__DeprecatedKt$elementAtOrNull$1 = new kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$elementAtOrNull$1(continuation);
        java.lang.Object obj3 = channelsKt__DeprecatedKt$elementAtOrNull$1.result;
        coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i2 = channelsKt__DeprecatedKt$elementAtOrNull$1.label;
        if (i2 != 0) {
        }
    }

    @kotlin.PublishedApi
    @org.jetbrains.annotations.NotNull
    public static final <E> kotlinx.coroutines.channels.ReceiveChannel<E> n(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.ReceiveChannel<? extends E> receiveChannel, @org.jetbrains.annotations.NotNull kotlin.coroutines.CoroutineContext coroutineContext, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super E, ? super kotlin.coroutines.Continuation<? super java.lang.Boolean>, ? extends java.lang.Object> function2) {
        return kotlinx.coroutines.channels.ProduceKt.produce$default(kotlinx.coroutines.GlobalScope.INSTANCE, coroutineContext, 0, null, kotlinx.coroutines.channels.ChannelsKt.consumes(receiveChannel), new kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filter$1(receiveChannel, function2, null), 6, null);
    }

    public static /* synthetic */ kotlinx.coroutines.channels.ReceiveChannel o(kotlinx.coroutines.channels.ReceiveChannel receiveChannel, kotlin.coroutines.CoroutineContext coroutineContext, kotlin.jvm.functions.Function2 function2, int i, java.lang.Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = kotlinx.coroutines.Dispatchers.getUnconfined();
        }
        return kotlinx.coroutines.channels.ChannelsKt.filter(receiveChannel, coroutineContext, function2);
    }

    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ kotlinx.coroutines.channels.ReceiveChannel p(kotlinx.coroutines.channels.ReceiveChannel receiveChannel, kotlin.coroutines.CoroutineContext coroutineContext, kotlin.jvm.functions.Function3 function3) {
        return kotlinx.coroutines.channels.ProduceKt.produce$default(kotlinx.coroutines.GlobalScope.INSTANCE, coroutineContext, 0, null, kotlinx.coroutines.channels.ChannelsKt.consumes(receiveChannel), new kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filterIndexed$1(receiveChannel, function3, null), 6, null);
    }

    public static /* synthetic */ kotlinx.coroutines.channels.ReceiveChannel q(kotlinx.coroutines.channels.ReceiveChannel receiveChannel, kotlin.coroutines.CoroutineContext coroutineContext, kotlin.jvm.functions.Function3 function3, int i, java.lang.Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = kotlinx.coroutines.Dispatchers.getUnconfined();
        }
        return p(receiveChannel, coroutineContext, function3);
    }

    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ kotlinx.coroutines.channels.ReceiveChannel r(kotlinx.coroutines.channels.ReceiveChannel receiveChannel, kotlin.coroutines.CoroutineContext coroutineContext, kotlin.jvm.functions.Function2 function2) {
        return kotlinx.coroutines.channels.ChannelsKt.filter(receiveChannel, coroutineContext, new kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filterNot$1(function2, null));
    }

    public static /* synthetic */ kotlinx.coroutines.channels.ReceiveChannel s(kotlinx.coroutines.channels.ReceiveChannel receiveChannel, kotlin.coroutines.CoroutineContext coroutineContext, kotlin.jvm.functions.Function2 function2, int i, java.lang.Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = kotlinx.coroutines.Dispatchers.getUnconfined();
        }
        return r(receiveChannel, coroutineContext, function2);
    }

    @kotlin.PublishedApi
    @org.jetbrains.annotations.NotNull
    public static final <E> kotlinx.coroutines.channels.ReceiveChannel<E> t(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.ReceiveChannel<? extends E> receiveChannel) {
        return o(receiveChannel, null, new kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filterNotNull$1(null), 1, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0064 A[Catch: all -> 0x0035, TryCatch #0 {all -> 0x0035, blocks: (B:11:0x0031, B:12:0x005c, B:14:0x0064, B:16:0x006a, B:18:0x004a, B:23:0x006f), top: B:10:0x0031 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0058 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x006f A[Catch: all -> 0x0035, TRY_LEAVE, TryCatch #0 {all -> 0x0035, blocks: (B:11:0x0031, B:12:0x005c, B:14:0x0064, B:16:0x006a, B:18:0x004a, B:23:0x006f), top: B:10:0x0031 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0059 -> B:12:0x005c). Please report as a decompilation issue!!! */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ java.lang.Object u(kotlinx.coroutines.channels.ReceiveChannel receiveChannel, java.util.Collection collection, kotlin.coroutines.Continuation continuation) {
        kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filterNotNullTo$1 channelsKt__DeprecatedKt$filterNotNullTo$1;
        java.lang.Object coroutine_suspended;
        int i;
        kotlinx.coroutines.channels.ReceiveChannel receiveChannel2;
        java.lang.Throwable th;
        kotlinx.coroutines.channels.ChannelIterator it;
        java.util.Collection collection2;
        java.lang.Object hasNext;
        if (continuation instanceof kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filterNotNullTo$1) {
            channelsKt__DeprecatedKt$filterNotNullTo$1 = (kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filterNotNullTo$1) continuation;
            int i2 = channelsKt__DeprecatedKt$filterNotNullTo$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                channelsKt__DeprecatedKt$filterNotNullTo$1.label = i2 - Integer.MIN_VALUE;
                java.lang.Object obj = channelsKt__DeprecatedKt$filterNotNullTo$1.result;
                coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelsKt__DeprecatedKt$filterNotNullTo$1.label;
                if (i != 0) {
                    kotlin.ResultKt.throwOnFailure(obj);
                    try {
                        receiveChannel2 = receiveChannel;
                        it = receiveChannel.iterator();
                        collection2 = collection;
                        channelsKt__DeprecatedKt$filterNotNullTo$1.L$0 = collection2;
                        channelsKt__DeprecatedKt$filterNotNullTo$1.L$1 = receiveChannel2;
                        channelsKt__DeprecatedKt$filterNotNullTo$1.L$2 = it;
                        channelsKt__DeprecatedKt$filterNotNullTo$1.label = 1;
                        hasNext = it.hasNext(channelsKt__DeprecatedKt$filterNotNullTo$1);
                        if (hasNext != coroutine_suspended) {
                        }
                    } catch (java.lang.Throwable th2) {
                        receiveChannel2 = receiveChannel;
                        th = th2;
                        throw th;
                    }
                } else {
                    if (i != 1) {
                        throw new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    it = (kotlinx.coroutines.channels.ChannelIterator) channelsKt__DeprecatedKt$filterNotNullTo$1.L$2;
                    receiveChannel2 = (kotlinx.coroutines.channels.ReceiveChannel) channelsKt__DeprecatedKt$filterNotNullTo$1.L$1;
                    java.util.Collection collection3 = (java.util.Collection) channelsKt__DeprecatedKt$filterNotNullTo$1.L$0;
                    try {
                        kotlin.ResultKt.throwOnFailure(obj);
                        if (!((java.lang.Boolean) obj).booleanValue()) {
                            kotlin.Unit unit = kotlin.Unit.INSTANCE;
                            kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(receiveChannel2, null);
                            return collection3;
                        }
                        java.lang.Object next = it.next();
                        if (next != null) {
                            collection3.add(next);
                        }
                        collection2 = collection3;
                        channelsKt__DeprecatedKt$filterNotNullTo$1.L$0 = collection2;
                        channelsKt__DeprecatedKt$filterNotNullTo$1.L$1 = receiveChannel2;
                        channelsKt__DeprecatedKt$filterNotNullTo$1.L$2 = it;
                        channelsKt__DeprecatedKt$filterNotNullTo$1.label = 1;
                        hasNext = it.hasNext(channelsKt__DeprecatedKt$filterNotNullTo$1);
                        if (hasNext != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        collection3 = collection2;
                        obj = hasNext;
                        if (!((java.lang.Boolean) obj).booleanValue()) {
                        }
                    } catch (java.lang.Throwable th3) {
                        th = th3;
                        try {
                            throw th;
                        } catch (java.lang.Throwable th4) {
                            kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(receiveChannel2, th);
                            throw th4;
                        }
                    }
                }
            }
        }
        channelsKt__DeprecatedKt$filterNotNullTo$1 = new kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filterNotNullTo$1(continuation);
        java.lang.Object obj2 = channelsKt__DeprecatedKt$filterNotNullTo$1.result;
        coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__DeprecatedKt$filterNotNullTo$1.label;
        if (i != 0) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0062, code lost:
    
        r8 = r0;
        r0 = r1;
        r1 = r2;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0070 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x007d A[Catch: all -> 0x009d, TryCatch #2 {all -> 0x009d, blocks: (B:11:0x0062, B:17:0x0075, B:19:0x007d, B:21:0x0083, B:26:0x0096, B:10:0x005e), top: B:9:0x005e }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0096 A[Catch: all -> 0x009d, TRY_LEAVE, TryCatch #2 {all -> 0x009d, blocks: (B:11:0x0062, B:17:0x0075, B:19:0x007d, B:21:0x0083, B:26:0x0096, B:10:0x005e), top: B:9:0x005e }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0024 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x005b  */
    /* JADX WARN: Type inference failed for: r7v0, types: [kotlinx.coroutines.channels.SendChannel] */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11, types: [java.lang.Object, kotlinx.coroutines.channels.SendChannel] */
    /* JADX WARN: Type inference failed for: r7v12, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v13 */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v8, types: [kotlinx.coroutines.channels.ReceiveChannel] */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ java.lang.Object v(kotlinx.coroutines.channels.ReceiveChannel receiveChannel, kotlinx.coroutines.channels.SendChannel sendChannel, kotlin.coroutines.Continuation continuation) {
        kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filterNotNullTo$3 channelsKt__DeprecatedKt$filterNotNullTo$3;
        java.lang.Object coroutine_suspended;
        int i;
        kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filterNotNullTo$3 channelsKt__DeprecatedKt$filterNotNullTo$32;
        kotlinx.coroutines.channels.ChannelIterator channelIterator;
        kotlinx.coroutines.channels.ChannelIterator channelIterator2;
        java.lang.Object hasNext;
        if (continuation instanceof kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filterNotNullTo$3) {
            channelsKt__DeprecatedKt$filterNotNullTo$3 = (kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filterNotNullTo$3) continuation;
            int i2 = channelsKt__DeprecatedKt$filterNotNullTo$3.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                channelsKt__DeprecatedKt$filterNotNullTo$3.label = i2 - Integer.MIN_VALUE;
                java.lang.Object obj = channelsKt__DeprecatedKt$filterNotNullTo$3.result;
                coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelsKt__DeprecatedKt$filterNotNullTo$3.label;
                if (i == 0) {
                    try {
                        if (i == 1) {
                            kotlinx.coroutines.channels.ChannelIterator channelIterator3 = (kotlinx.coroutines.channels.ChannelIterator) channelsKt__DeprecatedKt$filterNotNullTo$3.L$2;
                            kotlinx.coroutines.channels.ReceiveChannel receiveChannel2 = (kotlinx.coroutines.channels.ReceiveChannel) channelsKt__DeprecatedKt$filterNotNullTo$3.L$1;
                            kotlinx.coroutines.channels.SendChannel sendChannel2 = (kotlinx.coroutines.channels.SendChannel) channelsKt__DeprecatedKt$filterNotNullTo$3.L$0;
                            kotlin.ResultKt.throwOnFailure(obj);
                            channelsKt__DeprecatedKt$filterNotNullTo$32 = channelsKt__DeprecatedKt$filterNotNullTo$3;
                            channelIterator = channelIterator3;
                            receiveChannel = receiveChannel2;
                            sendChannel = sendChannel2;
                            java.lang.Object obj2 = coroutine_suspended;
                            kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filterNotNullTo$3 channelsKt__DeprecatedKt$filterNotNullTo$33 = channelsKt__DeprecatedKt$filterNotNullTo$32;
                            if (!((java.lang.Boolean) obj).booleanValue()) {
                                kotlin.Unit unit = kotlin.Unit.INSTANCE;
                                kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(receiveChannel, null);
                                return sendChannel;
                            }
                            java.lang.Object next = channelIterator.next();
                            if (next != null) {
                                channelsKt__DeprecatedKt$filterNotNullTo$33.L$0 = sendChannel;
                                channelsKt__DeprecatedKt$filterNotNullTo$33.L$1 = receiveChannel;
                                channelsKt__DeprecatedKt$filterNotNullTo$33.L$2 = channelIterator;
                                channelsKt__DeprecatedKt$filterNotNullTo$33.label = 2;
                                if (sendChannel.send(next, channelsKt__DeprecatedKt$filterNotNullTo$33) == obj2) {
                                    return obj2;
                                }
                            }
                            channelIterator2 = channelIterator;
                            channelsKt__DeprecatedKt$filterNotNullTo$3 = channelsKt__DeprecatedKt$filterNotNullTo$33;
                            coroutine_suspended = obj2;
                        } else {
                            if (i != 2) {
                                throw new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            kotlinx.coroutines.channels.ChannelIterator channelIterator4 = (kotlinx.coroutines.channels.ChannelIterator) channelsKt__DeprecatedKt$filterNotNullTo$3.L$2;
                            kotlinx.coroutines.channels.ReceiveChannel receiveChannel3 = (kotlinx.coroutines.channels.ReceiveChannel) channelsKt__DeprecatedKt$filterNotNullTo$3.L$1;
                            kotlinx.coroutines.channels.SendChannel sendChannel3 = (kotlinx.coroutines.channels.SendChannel) channelsKt__DeprecatedKt$filterNotNullTo$3.L$0;
                            kotlin.ResultKt.throwOnFailure(obj);
                            channelIterator2 = channelIterator4;
                            receiveChannel = receiveChannel3;
                            sendChannel = sendChannel3;
                        }
                    } catch (java.lang.Throwable th) {
                        th = th;
                        try {
                            throw th;
                        } catch (java.lang.Throwable th2) {
                            kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(sendChannel, th);
                            throw th2;
                        }
                    }
                } else {
                    kotlin.ResultKt.throwOnFailure(obj);
                    try {
                        channelIterator2 = receiveChannel.iterator();
                    } catch (java.lang.Throwable th3) {
                        sendChannel = receiveChannel;
                        th = th3;
                        throw th;
                    }
                }
                channelsKt__DeprecatedKt$filterNotNullTo$3.L$0 = sendChannel;
                channelsKt__DeprecatedKt$filterNotNullTo$3.L$1 = receiveChannel;
                channelsKt__DeprecatedKt$filterNotNullTo$3.L$2 = channelIterator2;
                channelsKt__DeprecatedKt$filterNotNullTo$3.label = 1;
                hasNext = channelIterator2.hasNext(channelsKt__DeprecatedKt$filterNotNullTo$3);
                if (hasNext != coroutine_suspended) {
                    return coroutine_suspended;
                }
                channelsKt__DeprecatedKt$filterNotNullTo$32 = channelsKt__DeprecatedKt$filterNotNullTo$3;
                channelIterator = channelIterator2;
                obj = hasNext;
                sendChannel = sendChannel;
                java.lang.Object obj22 = coroutine_suspended;
                kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filterNotNullTo$3 channelsKt__DeprecatedKt$filterNotNullTo$332 = channelsKt__DeprecatedKt$filterNotNullTo$32;
                if (!((java.lang.Boolean) obj).booleanValue()) {
                }
            }
        }
        channelsKt__DeprecatedKt$filterNotNullTo$3 = new kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filterNotNullTo$3(continuation);
        java.lang.Object obj3 = channelsKt__DeprecatedKt$filterNotNullTo$3.result;
        coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__DeprecatedKt$filterNotNullTo$3.label;
        if (i == 0) {
        }
        channelsKt__DeprecatedKt$filterNotNullTo$3.L$0 = sendChannel;
        channelsKt__DeprecatedKt$filterNotNullTo$3.L$1 = receiveChannel;
        channelsKt__DeprecatedKt$filterNotNullTo$3.L$2 = channelIterator2;
        channelsKt__DeprecatedKt$filterNotNullTo$3.label = 1;
        hasNext = channelIterator2.hasNext(channelsKt__DeprecatedKt$filterNotNullTo$3);
        if (hasNext != coroutine_suspended) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x005b A[Catch: all -> 0x0031, TRY_LEAVE, TryCatch #1 {all -> 0x0031, blocks: (B:11:0x002d, B:12:0x0053, B:14:0x005b, B:18:0x0064, B:19:0x006b), top: B:10:0x002d }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0064 A[Catch: all -> 0x0031, TRY_ENTER, TryCatch #1 {all -> 0x0031, blocks: (B:11:0x002d, B:12:0x0053, B:14:0x005b, B:18:0x0064, B:19:0x006b), top: B:10:0x002d }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ java.lang.Object w(kotlinx.coroutines.channels.ReceiveChannel receiveChannel, kotlin.coroutines.Continuation continuation) {
        kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$first$1 channelsKt__DeprecatedKt$first$1;
        java.lang.Object obj;
        java.lang.Object coroutine_suspended;
        int i;
        kotlinx.coroutines.channels.ReceiveChannel receiveChannel2;
        java.lang.Throwable th;
        kotlinx.coroutines.channels.ChannelIterator channelIterator;
        if (continuation instanceof kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$first$1) {
            channelsKt__DeprecatedKt$first$1 = (kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$first$1) continuation;
            int i2 = channelsKt__DeprecatedKt$first$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                channelsKt__DeprecatedKt$first$1.label = i2 - Integer.MIN_VALUE;
                obj = channelsKt__DeprecatedKt$first$1.result;
                coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelsKt__DeprecatedKt$first$1.label;
                if (i != 0) {
                    kotlin.ResultKt.throwOnFailure(obj);
                    try {
                        kotlinx.coroutines.channels.ChannelIterator it = receiveChannel.iterator();
                        channelsKt__DeprecatedKt$first$1.L$0 = receiveChannel;
                        channelsKt__DeprecatedKt$first$1.L$1 = it;
                        channelsKt__DeprecatedKt$first$1.label = 1;
                        java.lang.Object hasNext = it.hasNext(channelsKt__DeprecatedKt$first$1);
                        if (hasNext == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        receiveChannel2 = receiveChannel;
                        channelIterator = it;
                        obj = hasNext;
                    } catch (java.lang.Throwable th2) {
                        receiveChannel2 = receiveChannel;
                        th = th2;
                        throw th;
                    }
                } else {
                    if (i != 1) {
                        throw new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    channelIterator = (kotlinx.coroutines.channels.ChannelIterator) channelsKt__DeprecatedKt$first$1.L$1;
                    receiveChannel2 = (kotlinx.coroutines.channels.ReceiveChannel) channelsKt__DeprecatedKt$first$1.L$0;
                    try {
                        kotlin.ResultKt.throwOnFailure(obj);
                    } catch (java.lang.Throwable th3) {
                        th = th3;
                        try {
                            throw th;
                        } catch (java.lang.Throwable th4) {
                            kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(receiveChannel2, th);
                            throw th4;
                        }
                    }
                }
                if (((java.lang.Boolean) obj).booleanValue()) {
                    throw new java.util.NoSuchElementException("ReceiveChannel is empty.");
                }
                java.lang.Object next = channelIterator.next();
                kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(receiveChannel2, null);
                return next;
            }
        }
        channelsKt__DeprecatedKt$first$1 = new kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$first$1(continuation);
        obj = channelsKt__DeprecatedKt$first$1.result;
        coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__DeprecatedKt$first$1.label;
        if (i != 0) {
        }
        if (((java.lang.Boolean) obj).booleanValue()) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0060 A[Catch: all -> 0x0031, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x0031, blocks: (B:11:0x002d, B:12:0x0053, B:18:0x0060), top: B:10:0x002d }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ java.lang.Object x(kotlinx.coroutines.channels.ReceiveChannel receiveChannel, kotlin.coroutines.Continuation continuation) {
        kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$firstOrNull$1 channelsKt__DeprecatedKt$firstOrNull$1;
        java.lang.Object obj;
        java.lang.Object coroutine_suspended;
        int i;
        kotlinx.coroutines.channels.ReceiveChannel receiveChannel2;
        java.lang.Throwable th;
        kotlinx.coroutines.channels.ChannelIterator channelIterator;
        if (continuation instanceof kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$firstOrNull$1) {
            channelsKt__DeprecatedKt$firstOrNull$1 = (kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$firstOrNull$1) continuation;
            int i2 = channelsKt__DeprecatedKt$firstOrNull$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                channelsKt__DeprecatedKt$firstOrNull$1.label = i2 - Integer.MIN_VALUE;
                obj = channelsKt__DeprecatedKt$firstOrNull$1.result;
                coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelsKt__DeprecatedKt$firstOrNull$1.label;
                if (i != 0) {
                    kotlin.ResultKt.throwOnFailure(obj);
                    try {
                        kotlinx.coroutines.channels.ChannelIterator it = receiveChannel.iterator();
                        channelsKt__DeprecatedKt$firstOrNull$1.L$0 = receiveChannel;
                        channelsKt__DeprecatedKt$firstOrNull$1.L$1 = it;
                        channelsKt__DeprecatedKt$firstOrNull$1.label = 1;
                        java.lang.Object hasNext = it.hasNext(channelsKt__DeprecatedKt$firstOrNull$1);
                        if (hasNext == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        receiveChannel2 = receiveChannel;
                        channelIterator = it;
                        obj = hasNext;
                    } catch (java.lang.Throwable th2) {
                        receiveChannel2 = receiveChannel;
                        th = th2;
                        throw th;
                    }
                } else {
                    if (i != 1) {
                        throw new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    channelIterator = (kotlinx.coroutines.channels.ChannelIterator) channelsKt__DeprecatedKt$firstOrNull$1.L$1;
                    receiveChannel2 = (kotlinx.coroutines.channels.ReceiveChannel) channelsKt__DeprecatedKt$firstOrNull$1.L$0;
                    try {
                        kotlin.ResultKt.throwOnFailure(obj);
                    } catch (java.lang.Throwable th3) {
                        th = th3;
                        try {
                            throw th;
                        } catch (java.lang.Throwable th4) {
                            kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(receiveChannel2, th);
                            throw th4;
                        }
                    }
                }
                if (((java.lang.Boolean) obj).booleanValue()) {
                    kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(receiveChannel2, null);
                    return null;
                }
                java.lang.Object next = channelIterator.next();
                kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(receiveChannel2, null);
                return next;
            }
        }
        channelsKt__DeprecatedKt$firstOrNull$1 = new kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$firstOrNull$1(continuation);
        obj = channelsKt__DeprecatedKt$firstOrNull$1.result;
        coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__DeprecatedKt$firstOrNull$1.label;
        if (i != 0) {
        }
        if (((java.lang.Boolean) obj).booleanValue()) {
        }
    }

    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ kotlinx.coroutines.channels.ReceiveChannel y(kotlinx.coroutines.channels.ReceiveChannel receiveChannel, kotlin.coroutines.CoroutineContext coroutineContext, kotlin.jvm.functions.Function2 function2) {
        return kotlinx.coroutines.channels.ProduceKt.produce$default(kotlinx.coroutines.GlobalScope.INSTANCE, coroutineContext, 0, null, kotlinx.coroutines.channels.ChannelsKt.consumes(receiveChannel), new kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$flatMap$1(receiveChannel, function2, null), 6, null);
    }

    public static /* synthetic */ kotlinx.coroutines.channels.ReceiveChannel z(kotlinx.coroutines.channels.ReceiveChannel receiveChannel, kotlin.coroutines.CoroutineContext coroutineContext, kotlin.jvm.functions.Function2 function2, int i, java.lang.Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = kotlinx.coroutines.Dispatchers.getUnconfined();
        }
        return y(receiveChannel, coroutineContext, function2);
    }
}
