package com.xter;


import java.util.concurrent.TimeUnit;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;

public class Main {

    public static void main(String[] args) {
	    EventLoopGroup group = new NioEventLoopGroup();

	    try {
		    Bootstrap bootstrap = new Bootstrap()
				    .group(group)
				    .channel(NioSocketChannel.class)
				    .handler(new ChannelInitializer<Channel>() {
					    @Override
					    protected void initChannel(Channel ch) {
						    System.out.println(ch.toString());
					    }
				    });

		    ChannelFuture channelFuture = bootstrap.connect("127.0.0.1", 8000).sync();

		    final long start = System.currentTimeMillis();
		    channelFuture.addListener(new GenericFutureListener<Future<? super Void>>() {
			    @Override
			    public void operationComplete(Future<? super Void> future) throws Exception {
				    System.out.println(System.currentTimeMillis()-start);
				    System.out.println("future="+future.isSuccess());
			    }
		    });

	    } catch (InterruptedException e) {
		    e.printStackTrace();
	    } finally {
		    group.shutdownGracefully();
		    try {
			    TimeUnit.SECONDS.sleep(30);
		    } catch (InterruptedException e) {
			    e.printStackTrace();
		    }
	    }
    }
}
