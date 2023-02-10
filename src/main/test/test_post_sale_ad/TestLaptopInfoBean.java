package test_post_sale_ad;

import exception.SyntaxBeanException;
import org.junit.jupiter.api.Test;
import post_sale_ad.bean.LaptopInfoBean;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestLaptopInfoBean {

@Test
    public void testSetScreenSizeCorrect(){
    LaptopInfoBean bean=new LaptopInfoBean();
    try{
        bean.setScreenSize("14.4");//requires dot, not comma
        assert(true);
    } catch(SyntaxBeanException ex){assert false;}}
    @Test
    public void testSetScreenSizeTooBigExceptionMessage(){
        LaptopInfoBean bean=new LaptopInfoBean();
        try{
            bean.setScreenSize("30");
            assert(false);
        } catch(SyntaxBeanException ex){
        assertEquals("Syntax error in ScreenSize, number too big",ex.getMessage());}}

    @Test
    public void testSetScreenSizeWrongInputExMessage(){
        LaptopInfoBean bean=new LaptopInfoBean();
        try{
            bean.setScreenSize("14a");
            assert(false);
        } catch(SyntaxBeanException ex){assertEquals("Syntax error in ScreenSize",ex.getMessage());}
}
    @Test
    public void testSetCpuCorrectInput(){
        LaptopInfoBean bean=new LaptopInfoBean();
        try{
            bean.setCpu("Ryzen 5 1600x");
            assertEquals("Ryzen 5 1600x",bean.getCpu());
        } catch(SyntaxBeanException ex){
            assert(false);}}
    @Test
    public void testSetCpuTooLongInputExMessage(){
        LaptopInfoBean bean=new LaptopInfoBean();
        try{
            bean.setCpu("Ryzen 5---------- 1600 ------x -----------------");
            assert(false);
        } catch(SyntaxBeanException ex){
            assertEquals("Syntax error in PC configuration field",ex.getMessage());}}
    @Test
    public void testSetCpuEmptyInputExMessage(){
        LaptopInfoBean bean=new LaptopInfoBean();
        try{
            bean.setCpu("");
            assert(false);
        } catch(SyntaxBeanException ex){
            assertEquals("Syntax error in PC configuration field",ex.getMessage());}}
}




