package com.example.demo;

import com.example.demo.entity.MNumValidation;
import com.example.demo.service.MsgSendService;
import com.example.demo.utils.BasicMessageSender;
import com.example.demo.utils.Constants;
import org.mockito.Mockito;

/**
 * Created by hongjian.chen on 2018/12/12.
 */
public class ValidationMessageSender {

    private static MNumValidation invitation = Mockito.mock(MNumValidation.class);
    private static BasicMessageSender messageSender;

    //	@Before
    public static void init(){
        Mockito.when(invitation.getValue()).thenReturn("123456");
        Mockito.when(invitation.getKey()).thenReturn("register_18170756879");
        Mockito.when(invitation.getFormatter()).thenReturn("%s（熊猫心选手机动态验证码）为了您的账号安全，验证码请勿转发给他人。");
        messageSender = new BasicMessageSender(invitation);
    }

    public static void show() throws Exception {
        init();
        messageSender.call();
    }

    public static void main(String[] args) throws Exception {
//        String content = String.format("%s（熊猫心选手机动态验证码）为了您的账号安全，验证码请勿转发给他人。","123456");
        System.out.println("format="+ String.format(Constants.APPID_MSG, "123456"));
        new MsgSendService().sendMessage("","000000","18550791817");

//        show();
    }
    //	@Test
    public void test() throws Exception {
        boolean result = messageSender.call();
//		assertThat(result, equalTo(true));
    }
}
