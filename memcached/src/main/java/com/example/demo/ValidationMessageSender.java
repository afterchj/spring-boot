package com.example.demo;

import com.example.demo.entity.MNumValidation;
import com.example.demo.utils.BasicMessageSender;
import org.mockito.Mockito;

/**
 * Created by hongjian.chen on 2018/12/12.
 */
public class ValidationMessageSender {

    private static MNumValidation invitation = Mockito.mock(MNumValidation.class);
    private static BasicMessageSender messageSender;

    //	@Before
    public static void init(){
        Mockito.when(invitation.getValue()).thenReturn("12345");
        Mockito.when(invitation.getKey()).thenReturn("register_18170756879");
        Mockito.when(invitation.getFormatter()).thenReturn("%s（天天锁屏手机动态验证码）为了您的账号安全，验证码请勿转发给他人。");
        messageSender = new BasicMessageSender(invitation);
    }

    public static void show() throws Exception {
        init();
        messageSender.call();
    }

    public static void main(String[] args) throws Exception {
        show();
    }
    //	@Test
    public void test() throws Exception {
        boolean result = messageSender.call();
//		assertThat(result, equalTo(true));
    }
}
