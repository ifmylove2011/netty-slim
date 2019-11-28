package io.netty.util.internal.shaded.jctools.util;

@InternalAPI
public interface UnsafeJvmInfo {
    int PAGE_SIZE = UnsafeAccess.UNSAFE.pageSize();
}
