package com.bookstore.springtest.ws;

import com.bookstore.springtest.entity.Message;
import com.bookstore.springtest.utils.MessageUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@ServerEndpoint(value ="/chat",configurator = GetHttpSessionConfigurator.class)
@Component
public class ChatEndpoint {

    //用来存储每个用户客户端对象的ChatEndpoint对象
    static  private  Map<String,ChatEndpoint> onlineUsers = new ConcurrentHashMap<>();

    //声明session对象，通过对象可以发送消息给指定的用户
    private Session session;

    //声明HttpSession对象，我们之前在HttpSession对象中存储了用户名
    private HttpSession httpSession;

    //连接建立
    @OnOpen
    public void onOpen(Session session, EndpointConfig config){
        this.session = session;
        HttpSession httpSession = (HttpSession) config.getUserProperties().get(HttpSession.class.getName());
        this.httpSession = httpSession;
        //存储登陆的对象
        String username = (String)httpSession.getAttribute("user");
        onlineUsers.put(username,this);
        Set<String> names = onlineUsers.keySet();
            //将当前在线用户的用户名推送给所有的客户端
            //1 获取消息
            String message = MessageUtils.getMessage(true, null, getNames());
            //2 调用方法进行系统消息的推送
            broadcastAllUsers(message);
    }

    private void broadcastAllUsers(String message){
        try {
            //将消息推送给所有的客户端
            Set<String> names = onlineUsers.keySet();
            System.out.println(names);
            for (String name : names) {
                ChatEndpoint chatEndpoint = onlineUsers.get(name);
                chatEndpoint.session.getBasicRemote().sendText(message);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //返回在线用户名
    private Set<String> getNames(){
        return onlineUsers.keySet();
    }

    //收到消息
    @OnMessage
    public void onMessage(String message,Session session){
        //将数据转换成对象
        try {
            ObjectMapper mapper =new ObjectMapper();
            Message mess = mapper.readValue(message, Message.class);
            String data = mess.getMessage();
            String username = (String) httpSession.getAttribute("user");
            String resultMessage = MessageUtils.getMessage(false, username, data);
            //发送数据
            broadcastAllUsers(resultMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    //关闭
    @OnClose
    public void onClose(Session session) {
        String username = (String) httpSession.getAttribute("user");
        //从容器中删除指定的用户
        onlineUsers.remove(username);
        String message = MessageUtils.getMessage(true,username,getNames());
        broadcastAllUsers(message);
    }}
