import exception.SyntaxBeanException;
import org.junit.jupiter.api.Test;
import post_sale_ad.bean.LaptopInfoBean;

import static junit.framework.TestCase.assertEquals;

public class TestLaptopInfoBean {

@Test
    public void TestSetScreenSizeCorrect(){
    LaptopInfoBean bean=new LaptopInfoBean();
    try{
        bean.setScreenSize("14.4");//requires dot, not comma
        assert(true);
    } catch(SyntaxBeanException ex){assert false;}}
    @Test
    public void TestSetScreenSizeTooBigExceptionMessage(){
        LaptopInfoBean bean=new LaptopInfoBean();
        try{
            bean.setScreenSize("30");
            assert(false);
        } catch(SyntaxBeanException ex){
        assertEquals("Syntax error in ScreenSize, number too big",ex.getMessage());}}

    @Test
    public void TestSetScreenSizeWrongInputExMessage(){
        LaptopInfoBean bean=new LaptopInfoBean();
        try{
            bean.setScreenSize("14a");
            assert(false);
        } catch(SyntaxBeanException ex){assertEquals("Syntax error in ScreenSize",ex.getMessage());}
}
    @Test
    public void TestSetCpu(){
        LaptopInfoBean bean=new LaptopInfoBean();
        try{
            bean.setCpu("Ryzen 5 1600x");
            assertEquals("Ryzen 5 1600x",bean.getCpu());
        } catch(SyntaxBeanException ex){
            assert(false);}}
    @Test
    public void TestSetCpuTooLongInputExMessage(){
        LaptopInfoBean bean=new LaptopInfoBean();
        try{
            bean.setCpu("Ryzen 5---------- 1600 ------x -----------------");
            assert(false);
        } catch(SyntaxBeanException ex){
            assertEquals("Syntax error in PC configuration field",ex.getMessage());}}
    @Test
    public void TestSetCpuEmptyInputExMessage(){
        LaptopInfoBean bean=new LaptopInfoBean();
        try{
            bean.setCpu("");
            assert(false);
        } catch(SyntaxBeanException ex){
            assertEquals("Syntax error in PC configuration field",ex.getMessage());}}
}




