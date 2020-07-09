import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
class History extends JFrame
{
    class Node
    {
        Node prev;
        JLabel l;
        Node next;
    }
    Node f,r;
    public History()
    {
        setLayout(null);
        Font s1=new Font("Arial Black",2,14);
        int x=0;File f1=new File("w.jpg");
        Encrypt.encrypt(f1);
        ImageIcon image=new ImageIcon("w.jpg");
        setContentPane(new JLabel(image));
        Encrypt.encrypt(f1);
        init();
        boolean NULL=false;
        while(!NULL)
        {
            try
            {
                JLabel l=output();
                l.setFont(s1);
                l.setForeground(Color.ORANGE);
                l.setBounds(10,(50*x)+70,500,40);
                x++;
                add(l);
            }
            catch(NullPointerException e)
            {
                NULL=true;
            }
        }
        setTitle("History");
        setSize(600,449);
        setResizable(false);
    }

    public void init()
    {
        try
        {
            File f=new File("hou.skp");
            String s1[];
            if(f.exists())
            {
                Encrypt.encrypt(f);
                FileInputStream fin=new FileInputStream(f);
                DataInputStream din=new DataInputStream(fin);
                boolean EOF=false;
                while(!EOF)
                {
                    try
                    {
                        input(din.readUTF());
                    }
                    catch(EOFException e)
                    {
                        EOF=true;
                    }
                }
                Encrypt.encrypt(f);
            }
            else
            {
                input("-----------------");
            }
        }
        catch(IOException e)
        {
        }
    }

    public void input(String s)
    {
        Node t=new Node();
        t.next=null;
        t.l=new JLabel(s);
        if(f==null)
        {
            t.prev=null;
            f=t;
            r=t;
        }
        else
        {
            Node ob=f;
            while(ob.next!=null)
            {
                ob=ob.next;
            }
            t.prev=ob;
            ob.next=t;
            r=t;
        }
    }

    public JLabel output()
    {
        if(r==null)
        {
            return null;
        }
        else if(r.prev==null)
        {
            JLabel a=r.l;
            r=null;
            f=null;
            return a;
        }
        else
        {
            JLabel a=r.l;
            r=r.prev;
            r.next=null;
            return a;
        }
    }
}