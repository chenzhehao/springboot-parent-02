package com.chenzhehao.test.springbootnetty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.util.CharsetUtil;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NettyTestServiceImpl {
    private final int port;

    public NettyTestServiceImpl(int port) {
        this.port = port;
    }

    public void run() throws Exception {
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        public void initChannel(SocketChannel ch) throws Exception {
                            ChannelPipeline pipeline = ch.pipeline();
                            pipeline.addLast(new EchoServerHandler());
                        }
                    });

            Channel ch = b.bind(port).sync().channel();
            System.out.println("Netty server start success, port1:" + port);
            ch.closeFuture().sync();
            System.out.println("Netty server start success, port2:" + port);
        } finally {
            System.out.println("Netty server start success, port3:" + port);
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }

    static ExecutorService execuserService = Executors.newFixedThreadPool(1);
    public static void main(String[] args) throws Exception {
        int port = 8081;
        //将下数代码加入异步线程中
        execuserService.submit(() -> {
            try {
                System.out.println("启动Netty服务端");
                new NettyTestServiceImpl(port).run();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        Thread.sleep(3000);
        new NettyClientServiceImpl().clientTest();
    }

    private class EchoServerHandler extends ChannelInboundHandlerAdapter {
        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
            //异常处理
            try {
                ByteBuf in = (ByteBuf) msg;
                byte[] req = new byte[in.readableBytes()];
                in.readBytes(req);
                String body = new String(req, "UTF-8");
                System.out.println("Server received: " + body);
                //回写数据
                Thread.sleep(1500);
                String message = "Hello, client!";
                ByteBuf byteBuf = Unpooled.copiedBuffer(message, CharsetUtil.UTF_8);
                ctx.writeAndFlush(byteBuf);
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }


}
