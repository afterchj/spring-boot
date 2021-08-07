package com.example.demo;

import com.example.demo.entity.UserProperty;
import com.example.demo.utils.SpringUtil;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.Query;


/**
 * Created by hongjian.chen on 2019/5/31.
 */
public class MainTest {

    public static void main(String[] args) {

    }

//    @Test
//    public void testHibernate(){
//        EntityManager em = SpringUtil.getEntityManager().createEntityManager();
//        try {
////            Query query = em.createNativeQuery("select * from T_USER p where p.id = ?1",User.class);
//            Query query = em.createQuery("from User p where p.id = ?1 and p.name=:name",User.class);
//            query.setParameter(1, 1);
//            query.setParameter("name", "毕胜");
//            User info = (User) query.getSingleResult();
//            System.out.println("id="+info.getName()+",age="+info.getAge());
//        } finally {
//            if (em != null) {
//                em.close();
//            }
//        }
//    }
}
