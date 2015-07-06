package test;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.test.mybatis.dao.StudentDao;
import com.test.mybatis.entity.Student;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:mybatis-context.xml"})
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
public class DaoTest extends AbstractTransactionalJUnit4SpringContextTests {
    private static Logger logger = Logger.getLogger(DaoTest.class);

    @Autowired
    private StudentDao studentDao;

    /**
     * create
     */
    @Test
    public void c_test1(){
        Student stu = new Student();
        stu.setName("zs");
        stu.setAge(999);
        studentDao.insertStudent(stu);

        logger.debug("create student:  " + stu);
    }
    
    /**
     * delete
     */
    @Test
    public void d_test1(){
    	Map<String,Integer> map = new HashMap<String, Integer>();
    	map.put("id", 15);
    	studentDao.deleteStudentById(map);
    }
    
    /**
     * update
     */
    @Test
    public void u_test1(){
        Student stu = new Student();
        stu.setId(12);
        stu.setAge(99);
    	studentDao.updateStudentById(stu);
    }
    
    /**
     * read
     */
    @Test
    public void r_test1(){
    	Map<String,Integer> key = new HashMap<String, Integer>();
    	key.put("id", 1);
    	Student stu = studentDao.selectStudentById(key);
    	logger.debug("create student:  " + stu);
    }
    

}
