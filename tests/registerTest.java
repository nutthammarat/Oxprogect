/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author nutth
 */
public class registerTest {
    
    public registerTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    @Test
    public void checkpwdandcfpwdTrue(){
        Register regis = new Register();
        regis.passfield.setText("123456");
        regis.confirmpassfield.setText("123456");
        assertTrue(Registerservice.checkPass(regis.passfield.getText(),regis.confirmpassfield.getText()));
    }
    @Test
    public void checkpwdandcfpwdFalse(){
        Register regis = new Register();
        regis.passfield.setText("1234567");
        regis.confirmpassfield.setText("123456");
        assertFalse(Registerservice.checkPass(regis.passfield.getText(),regis.confirmpassfield.getText()));
    }
    @Test
    public void getnickname(){//output ตรงตาม input
        Register regis = new Register();
        regis.nicknamefield.setText("Nutty");
        assertEquals("Nutty", Registerservice.getnickname(regis.nicknamefield.getText()));
    }
    @Test
    public void checkFieldnotnullFalse(){//เติมครบทุกช่อง
        Register regis = new Register();
        regis.usernamefield.setText("Nutty");
        regis.passfield.setText("123456");
        regis.confirmpassfield.setText("123456");
        regis.nicknamefield.setText("Nutty");
        assertFalse(Registerservice.checkFieldnotnull(regis.usernamefield.getText(),regis.passfield.getText(),regis.confirmpassfield.getText(),regis.nicknamefield.getText()));
    }
    @Test
    public void checkFieldnotnullTrue(){//มีช่องที่ยังไม่ได้เติม
        Register regis = new Register();
        regis.usernamefield.setText("");
        regis.passfield.setText("123456");
        regis.confirmpassfield.setText("123456");
        regis.nicknamefield.setText("Nutty");
        assertTrue(Registerservice.checkFieldnotnull(regis.usernamefield.getText(),regis.passfield.getText(),regis.confirmpassfield.getText(),regis.nicknamefield.getText()));
    }

    
}
