package com.example.demo;

import com.alibaba.fastjson.JSON;
import com.example.demo.dao.BasClassDao;
import com.example.demo.dao.StudentDao;
import com.example.demo.entity.BasClass;
import com.example.demo.entity.Student;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.beans.PropertyDescriptor;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OracleHibernateApplicationTests {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private BasClassDao basClassDao;
    @Autowired
    private StudentDao studentDao;


    @Autowired
    private EntityManager em;

    @Test
    public void testJpa() {
        try {
            Query query = em.createQuery("from User p where p.id = ?1 and p.name=:name", User.class);
            query.setParameter(1, 1);
            query.setParameter("name", "毕胜");
            User info = (User) query.getSingleResult();
            System.out.println("id=" + info.getName() + ",age=" + info.getAge());
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Test
    public void saveBas() {
        List<Student> list = new ArrayList<>();
        BasClass bc = new BasClass();
        bc.setName("A班");
        //UUID.randomUUID().toString()
        for (int i = 1; i < 3; i++) {
            Student student = new Student();
            student.setClazz(bc);
            student.setName("同学" + i);
            student.setAge(i * 10 + 5);
            list.add(student);
        }
        bc.setStudents(list);
        bc = basClassDao.save(bc);
        System.out.println("id=" + bc.getId());
    }

    /**
     * 删除BasClass对象时，会自动删除StuInfo对象（即：父对象删除时子对象跟着删除）
     */
    @Test
    public void delete1() {
        BasClass bc = em.getReference(BasClass.class, "A班");
        em.remove(bc);
    }

    /**
     * 删除子对象时，父对象没影响
     */
    @Test
    public void delete2() {
        basClassDao.deleteById(1);
    }

    @Test
    public void main() {
        BasClass bc = new BasClass();
        bc.setName("B班");
        bc.setId(2);
        Student student = new Student();
        student.setId(7);
        student.setName("小明");
        Student target = studentDao.getById(student.getId());
        log.warn("student {}", JSON.toJSONString(target));
        BeanUtils.copyProperties(student, target);
        log.warn("copyProperties {}",target);
//        basClassDao.save(bc);
//        studentDao.saveUpdate(student.getName(),student.getId());
//        studentDao.save(student);
    }

    @Test
    public void find1() {
        BasClass bas = (BasClass) em.createQuery("select o from BasClass o").getSingleResult();
        System.out.println(bas.getId() + "\t" + bas.getName());
        List<Student> students = bas.getStudents();
        for (Student bc : students) {
            System.out.println("班级ID:--" + bc.getId() + "\t" + "班级名称:--" + bc.getName());
        }
        System.out.println("===============");
    }

    //运行结果为

    @Test
    public void find2() {
        List<Student> items = em.createQuery("select o from Student o").getResultList();
        for (Student item : items) {
            System.out.println("学员姓名:" + item.getName() + "，年龄:" + item.getAge());
            BasClass bas = item.getClazz();
            System.out.println("班级ID:" + bas.getId() + ", " + "，班级名称:" + bas.getName());
            System.out.println("============");
        }
    }

    public static String[] getNullPropertyNames(Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        PropertyDescriptor[] pds = src.getPropertyDescriptors();
        Set<String> emptyNames = new HashSet();
        for (PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null) emptyNames.add(pd.getName());
        }
        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }

    @Test
    public void contextLoads() {
        User u = userService.findByIdAndName(3, "测试");
        System.out.println(u.getName() + "\t" + u.getAge());
//		User user=new User();
//		user.setName("工程师");
//		user.setAge(28);
//		User rs=userService.save(user);
//		logger.info(rs.getName()+"\t"+rs.getId());
    }

}
