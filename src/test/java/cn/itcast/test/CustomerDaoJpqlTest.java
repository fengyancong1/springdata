package cn.itcast.test;

import cn.itcast.dao.CustomerDao;
import cn.itcast.domain.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class CustomerDaoJpqlTest {
    @Autowired
    private CustomerDao customerDao;
    @Test
    @Transactional
    @Rollback(value = false)
    public void save(){

        customerDao.updateCustomer(3L,"传智黑马");
    }
    @Test
    public void findOne(){
        Customer customer = customerDao.findJpql("传智黑马");
        System.out.println("customer = " + customer);
    }
    @Test
    public void findOneJpql(){
        List<Object[]> objects = customerDao.findSql("传智黑马");
        objects.forEach(objects1 -> System.out.println(objects1));
    }
    @Test
    public void find(){
        Customer nameAndId = customerDao.findCustNameAndId(4l, "传智播客2");
        System.out.println("nameAndId = " + nameAndId);
    }
    @Test
    public void delete(){
        customerDao.delete(2l);

    }
}
