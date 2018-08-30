
import com.tp.demo.MyMvcConfig;
import com.tp.demo.dao.UserDao;
import com.tp.demo.model.User;
import com.tp.demo.service.DemoService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by hongjian.chen on 2018/8/24.
 */


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MyMvcConfig.class)
@WebAppConfiguration("src/main/resource")
public class TestMybatis {
    private MockMvc mockMvc;
    @Autowired
    private UserDao userDao;

    @Autowired
    private DemoService demoService;

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private MockHttpServletRequest request;
    @Autowired
    private MockHttpSession session;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context).build();
    }

    @Test
    public void testNormalController() throws Exception {
        mockMvc.perform(get("/normal"))
                .andExpect(status().isOk())
                .andExpect(view().name("test"))
                .andExpect(forwardedUrl("/WEB-INF/classes/views/test.jsp"))
                .andExpect(model().attribute("msg", demoService.sayHello()));
    }

    @Test
    public void testRestController() throws Exception {
        mockMvc.perform(get("/testRest"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("text/plain;charset=UTF-8"))
                .andExpect(content().string(demoService.sayHello()));
    }

    @Test
    public void getUserList() {
        System.out.println("success...");
        System.out.println("userDao=" + userDao);
        List<User> list = userDao.getAll();
        for (User user : list) {
            System.out.println(user.getLoginName());
        }
    }
}
