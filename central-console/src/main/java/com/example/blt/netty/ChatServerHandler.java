package com.example.blt.netty;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.blt.entity.HostInfo;
import com.example.blt.service.ConsoleService;
import com.example.blt.utils.ConsoleUtil;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.SocketAddress;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 服务器主要的业务逻辑
 */
@ChannelHandler.Sharable
public class ChatServerHandler extends SimpleChannelInboundHandler<String> {

    private static Logger logger = LoggerFactory.getLogger(ChatServerHandler.class);
    //保存所有活动的用户
    public static final ChannelGroup group = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    @Override
    protected void channelRead0(ChannelHandlerContext arg0, String arg1) throws Exception {
//        CopyOnWriteArrayList hosts = new CopyOnWriteArrayList();
//        MemCachedClient memCachedClient = new MemCachedClient();
        Channel channel = arg0.channel();
        //当有用户发送消息的时候，对其他用户发送信息
        for (Channel ch : group) {
            SocketAddress address = ch.remoteAddress();
            if (address != null) {
                String str = address.toString();
                String ip = str.substring(1, str.indexOf(":"));
                try {
                    JSONObject jsonObject = JSON.parseObject(arg1);
                    String cmd = jsonObject.getString("cmd");
                    String to = jsonObject.getString("to");
                    if (to.equals(ip)) {
                        ch.writeAndFlush(cmd);
                    } else {
                        ch.writeAndFlush(cmd);
                    }
                    logger.info("[" + ip + "/" + channel.id() + "] cmd: " + arg1);
                } catch (Exception e) {
                    int index = arg1.indexOf(":");
                    if (index != -1) {
                        String to = arg1.substring(0, index);
                        String cmd = arg1.substring(index + 1);
                        if (ip.equals(to)) {
                            ch.writeAndFlush(cmd);
                        } else {
                            ch.writeAndFlush(cmd);
                        }
                        logger.info("[" + ip + "/" + channel.id() + "] receive cmd:" + arg1);
                    } else {
                        ch.writeAndFlush(arg1);
                        logger.info("[" + ip + "/" + channel.id() + "] receive heartbeat:" + arg1);
                    }
                }
            }
        }
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        CopyOnWriteArrayList hosts = new CopyOnWriteArrayList();
        Channel channel = ctx.channel();
        group.add(channel);
        SocketAddress address = channel.remoteAddress();
        if (address != null) {
            String str = address.toString();
            String ip = str.substring(1, str.indexOf(":"));
            HostInfo info = new HostInfo();
            info.setIp(ip);
            info.setStatus(channel.isOpen());
            hosts.add(info);
            ConsoleUtil.saveHosts(hosts);
        }
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        group.remove(channel);
    }

    //在建立链接时发送信息
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        logger.info("[" + channel.remoteAddress() + "]:" + channel.id() + " online");
    }

    //退出链接
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        group.remove(channel);
        logger.info("[" + channel.remoteAddress() + "]:" + channel.id() + " offline");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close().sync();
        Channel channel = ctx.channel();
        group.remove(channel);
        logger.info("[" + channel.remoteAddress() + "]:" + channel.id() + " exit the room size " + group.size());
    }
}
