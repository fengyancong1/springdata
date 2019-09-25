package cn.itcast.test;

import cn.itcast.dao.CustomerDao;
import cn.itcast.domain.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.EmptyStackException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class CustomerDaoTest {
    @Autowired
    private CustomerDao customerDao;
    @Test
    public void save(){
        //增加
        Customer customer = new Customer();
        customer.setCustId(1L);
        customer.setCustAddress("武汉");
        customer.setCustName("黄冈");
        customerDao.save(customer);
    }
    @Test
    public void findOne(){
        //根据id查询
        Customer customer = customerDao.findOne(2l);
        System.out.println("customer = " + customer);
    }
    @Test
    public void update(){
        //先查询在修改
        Customer customer = customerDao.findOne(3l);
        customer.setCustAddress("北京");
        System.out.println("customer = " + customer);
    }
    @Test
    public void delete(){
        //根据id删除
        customerDao.delete(2l);

    }
}
