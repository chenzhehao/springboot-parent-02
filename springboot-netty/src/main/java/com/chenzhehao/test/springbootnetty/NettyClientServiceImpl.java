package com.chenzhehao.test.springbootnetty;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.CharsetUtil;

public class NettyClientServiceImpl {

    public void clientTest() {
        // 创建一个EventLoopGroup，用于处理客户端连接
        EventLoopGroup group = new NioEventLoopGroup();

        try {
            // 创建Bootstrap实例
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(group)
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            // 在这里添加你的ChannelHandler
                            ch.pipeline().addLast(new EchoClientHandler());
                        }
                    });

            // 连接到服务器并启动客户端
            ChannelFuture channelFuture = bootstrap.connect("localhost", 8081).sync();
            System.out.println("客户端已启动，连接到服务器");

            // 获取Channel对象，用于发送消息
            Channel channel = channelFuture.channel();
            // 准备要发送的消息
            String message = "Hello, Netty!";
            ByteBuf byteBuf = Unpooled.copiedBuffer(message, CharsetUtil.UTF_8);
            // 发送消息到服务器
            channel.writeAndFlush(byteBuf);

//            Thread.sleep(10000);
//
//            // 准备要发送的消息
//            String message2 = "Hello, Netty2!";
//            ByteBuf byteBuf2 = Unpooled.copiedBuffer(message2, CharsetUtil.UTF_8);
//            // 发送消息到服务器
//            channel.writeAndFlush(byteBuf2);

            System.out.println("客户端已启动，已发送消息");
            // 等待客户端关闭
            channelFuture.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            // 优雅地关闭EventLoopGroup
            group.shutdownGracefully();
        }
    }

    private class EchoClientHandler extends ChannelInboundHandlerAdapter {
        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
            ByteBuf in = (ByteBuf) msg;
            byte[] req = new byte[in.readableBytes()];
            in.readBytes(req);
            String body = new String(req, "UTF-8");
            ;
            System.out.println("client received: " + body);
            //回写数据
            // 准备要发送的消息
            Thread.sleep(1000);
            String message = "Hello, Netty!";
            ByteBuf byteBuf = Unpooled.copiedBuffer(message, CharsetUtil.UTF_8);
            ctx.writeAndFlush(byteBuf);
        }
    }

}
