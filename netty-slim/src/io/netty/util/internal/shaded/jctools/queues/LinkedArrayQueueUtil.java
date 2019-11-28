package io.netty.util.internal.shaded.jctools.queues;

import static io.netty.util.internal.shaded.jctools.util.UnsafeRefArrayAccess.REF_ARRAY_BASE;
import static io.netty.util.internal.shaded.jctools.util.UnsafeRefArrayAccess.REF_ELEMENT_SHIFT;

/**
 * This is used for method substitution in the LinkedArray classes code generation.
 */
final class LinkedArrayQueueUtil
{
    private LinkedArrayQueueUtil()
    {
    }

    static int length(Object[] buf)
    {
        return buf.length;
    }

    /**
     * This method assumes index is actually (index << 1) because lower bit is
     * used for resize. This is compensated for by reducing the element shift.
     * The computation is constant folded, so there's no cost.
     */
    static long modifiedCalcElementOffset(long index, long mask)
    {
        return REF_ARRAY_BASE + ((index & mask) << (REF_ELEMENT_SHIFT - 1));
    }

    static long nextArrayOffset(Object[] curr)
    {
        return REF_ARRAY_BASE + ((long) (length(curr) - 1) << REF_ELEMENT_SHIFT);
    }
}
