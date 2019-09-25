package cn.itcast.test;

import cn.itcast.dao.CustomerDao;
import cn.itcast.domain.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class CustomerDaogetTest {
    @Autowired
    private CustomerDao customerDao;

    @Test
    public void findOne(){
        //根据命名查询
        Customer customer = customerDao.findByCustName("黄冈");
        System.out.println("customer = " + customer);
    }
    @Test
    public void findByCustNameLike(){
        //模糊查询
        List<Customer> custNameLike = customerDao.findByCustNameLike("传智播客2");

        custNameLike.forEach(customer -> System.out.println(customer));
    }
    @Test
    public void findByCustNameLikeAndCustIndustry(){
        //根据id删除
        Customer custIndustry = customerDao.findByCustNameLikeAndCustIndustry("传智黑马", "教育1");
        System.out.println(custIndustry);

    }
}
