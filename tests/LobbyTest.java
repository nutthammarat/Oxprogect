/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.*;
import javax.swing.JList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.bson.*;

/**
 *
 * @author nutth
 */
public class LobbyTest {
    @Test
    public void joinRoom(){
       List<Document> list = new ArrayList<>();
        LobbyDao db = new LobbyDao();
        if(db.joinRoom("Test"))
            System.out.println("You can Join this Room");
        else
            System.out.println("Please Join Another Room");
 }
    @Test
    public void showRoom(){
        List<Document> list = new ArrayList<>();
        LobbyDao db = new LobbyDao();
        list = LobbyDao.getRoom();
        //showroom
        for(int i = 0 ; i<list.size() ; i++) {
            System.out.println(list.get(i).get("_id") + " " +list.get(i).get("name") + "\n" + list.get(i).get("units"));
        }
    }
    @Test
    public void createRoom(){
       /* JList<String> listname=null;
        JList<String> listunit=null;
        List<Document> list = new ArrayList<>();
        LobbyDao.createRoom("Wait");
        list = Lobbyservice.showList(listname, listunit);
        //showroom
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).get("_id") + " " + list.get(i).get("name") + "\n" + list.get(i).get("units"));
        }*/
    }
  }
    

