package io.netty.util.internal.shaded.jctools.queues;

import io.netty.util.internal.shaded.jctools.util.InternalAPI;

import static io.netty.util.internal.shaded.jctools.util.UnsafeRefArrayAccess.REF_ARRAY_BASE;
import static io.netty.util.internal.shaded.jctools.util.UnsafeRefArrayAccess.REF_ELEMENT_SHIFT;

@InternalAPI
public final class CircularArrayOffsetCalculator
{
    @SuppressWarnings("unchecked")
    public static <E> E[] allocate(int capacity)
    {
        return (E[]) new Object[capacity];
    }

    /**
     * @param index desirable element index
     * @param mask (length - 1)
     * @return the offset in bytes within the array for a given index.
     */
    public static long calcElementOffset(long index, long mask)
    {
        return REF_ARRAY_BASE + ((index & mask) << REF_ELEMENT_SHIFT);
    }
}
