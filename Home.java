import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
class Home extends JFrame implements ActionListener
{
    //First Screen
    JButton b1,b2,b3;
    JLabel l1,l2,l3;

    //Second Screen
    JButton b4,b;
    JLabel l4,l5,l6,l7;
    JTextField t1,t2;
    JPasswordField t3;

    //Third Screen
    JButton h,e;
    JLabel t,hl,el;
    JLabel[] ar,v;
    String st;

    int n=0;
    String f;
    String s="w.png";
    boolean first=true;
    boolean fhis=true;;
    public Home()
    {
        setLayout(null);
        File f1=new File(s);
        Encrypt.encrypt(f1);
        ImageIcon image=new ImageIcon(s);
        setContentPane(new JLabel(image));
        Encrypt.encrypt(f1);
        initialize();
        if(first)
        {
            f="Sign Up";
            l4=new JLabel("SIGN UP");
            n++;
        }
        else
        {
            f="Sign in";
            l4=new JLabel("SIGN IN");
            n=Encrypt.getCount();
        }
        init();
        b1=new JButton();
        File i=new File("b.png");
        Encrypt.encrypt(i);
        ImageIcon img=new ImageIcon("b.png");
        b1.setIcon(img);
        l1=new JLabel(f);
        b1.setBounds(245,165,100,20);
        b2=new JButton();
        b2.setIcon(img);
        l2=new JLabel("About");
        b2.setBounds(245,200,100,20);
        b3=new JButton();
        b3.setIcon(img);
        l3=new JLabel("Contact");
        b3.setBounds(245,235,100,20);
        b4=new JButton();
        b4.setIcon(img);
        b4.setBounds(245,235,100,20);
        Encrypt.encrypt(i);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        add(b1);
        b1.add(l1);
        add(b2);
        b2.add(l2);
        add(b3);
        b3.add(l3);
        add(b4);
        b4.add(l4);
        b4.setVisible(false);

        l5=new JLabel("First Name");
        l6=new JLabel("Login ID");
        l7=new JLabel("Password");
        t1=new JTextField();
        t2=new JTextField();
        t3=new JPasswordField();

        l5.setBounds(225,150,100,20);
        add(l5);
        l5.setVisible(false);

        l6.setBounds(225,175,100,20);
        add(l6);
        l6.setVisible(false);

        l7.setBounds(225,200,100,20);
        add(l7);
        l7.setVisible(false);

        t1.setBounds(310,150,100,20);
        add(t1);
        t1.setVisible(false);

        t2.setBounds(310,175,100,20);
        add(t2);
        t2.setVisible(false);

        t3.setBounds(310,200,100,20);
        add(t3);
        t3.setVisible(false);

        i=new File("back.png");
        Encrypt.encrypt(i);
        b=new JButton();
        img=new ImageIcon("back.png");
        b.setIcon(img);
        Encrypt.encrypt(i);
        b.setBounds(5,30,30,30);
        b.addActionListener(this);
        add(b);
        b.setVisible(false);

        h=new JButton();
        i=new File("b.png");
        Encrypt.encrypt(i);
        img=new ImageIcon("b.png");
        h.setIcon(img);
        hl=new JLabel("History");
        h.setBounds(425,200,100,30);
        h.addActionListener(this);
        h.add(hl);
        add(h);
        h.setVisible(false);

        e=new JButton();
        Encrypt.encrypt(i);
        img=new ImageIcon("b.png");
        e.setIcon(img);
        el=new JLabel("Encrypt/Decrypt");
        e.setBounds(425,265,100,30);
        e.addActionListener(this);
        e.add(el);
        add(e);
        e.setVisible(false);
        t=new JLabel(st);
        Font s=new Font("Segoe Script",3,18);
        t.setFont(s);
        t.setForeground(Color.GREEN);
        t.setBounds(40,60,400,50);
        add(t);
        t.setVisible(false);

        Font s1=new Font("Arial Black",2,12);
        for(int x=0;x<ar.length;x++)
        {
            ar[x].setFont(s1);
            ar[x].setForeground(Color.YELLOW);
            ar[x].setBounds(40,(50*x)+90,200,50);
            add(ar[x]);
            ar[x].setVisible(false);
        }

        for(int x=0;x<v.length;x++)
        {
            v[x].setFont(s1);
            v[x].setForeground(Color.ORANGE);
            v[x].setBounds(390,(50*x)+80,200,50);
            add(v[x]);
            v[x].setVisible(false);
        }

        setTitle("Skull Data Protector");
        setSize(600,449);
        setResizable(false);
    }

    public void actionPerformed(ActionEvent evt)
    {
        if(evt.getSource()==b1)
        {
            b1.setVisible(false);
            b2.setVisible(false);
            b3.setVisible(false);
            b.setVisible(true);
            l6.setVisible(true);
            l7.setVisible(true);
            b4.setVisible(true);
            t3.setVisible(true);
            t2.setVisible(true);
            if(first)
            {
                t1.setVisible(true);
                l5.setVisible(true);
            }
        }
        else if(evt.getSource()==b2)
        {
            try
            {
                Runtime r=Runtime.getRuntime();
                r.exec("notepad.exe about.txt");
            }
            catch(IOException e)
            {
            }
        }
        else if(evt.getSource()==b3)
        {
            Runtime r=Runtime.getRuntime();
            try
            {
                r.exec("iexplore.exe mail.google.com");
            }
            catch(Exception e)
            {
            }
        }
        else if(evt.getSource()==b4||evt.getSource()==t3)
        {
            String s1=t1.getText().trim();
            String s2=t2.getText().trim();
            String s3=t3.getText().trim();
            if(first)
            {
                if(s1.length()==0||s2.length()==0||s3.length()==0)
                {
                    JOptionPane.showMessageDialog(this,"Enter Complete Detail");
                }
                else
                {
                    Create ob=new Create(t1.getText(),t2.getText(),t3.getText(),n);
                    JOptionPane.showMessageDialog(this,f+" Successful");
                    t1.setText("");
                    t2.setText("");
                    t3.setText("");
                    first=false;
                    switchWindow();
                }
            }
            else
            {
                String a=Encrypt.getPassword().trim();
                String b=Encrypt.getID().trim();
                if(s2.equalsIgnoreCase(b)&&s3.equalsIgnoreCase(a))
                {
                    Create ob=new Create(n+1);
                    t2.setText("");
                    t3.setText("");
                    switchWindow();
                }
                else
                {
                    JOptionPane.showMessageDialog(this,"Enter Correct Login Id and Pasword");
                }
            }
        }
        else if(evt.getSource()==b)
        {
            b1.setVisible(true);
            b2.setVisible(true);
            b3.setVisible(true);
            b.setVisible(false);
            b4.setVisible(false);
            l6.setVisible(false);
            l7.setVisible(false);
            if(first)
            {
                t1.setVisible(false);
                l5.setVisible(false);
            }
            t3.setVisible(false);
            t2.setVisible(false);
            h.setVisible(false);
            e.setVisible(false);
            t.setVisible(false);
            hl.setVisible(false);
            el.setVisible(false);

            for(int x=0;x<ar.length;x++)
            {
                ar[x].setVisible(false);
            }

            for(int x=0;x<v.length;x++)
            {
                v[x].setVisible(false);
            }
        }
        else if(evt.getSource()==h)
        {
            History ob=new History();
            ob.setVisible(true);
        }
        else if(evt.getSource()==e)
        {
            encryption();
        }
    }

    public void initialize()
    {
        File f=new File("dou.skp");
        if(f.exists())
        {
            first=false;
        }
        else
        {
            first=true;
        }
    }

    public void init()
    {
        try
        {
            String s=Encrypt.getName();
            st="Welcome, "+s;
            File f=new File("hou.skp");
            int count=0;
            String s1[];
            if(f.exists())
            {
                s1=new String[5];
                Encrypt.encrypt(f);
                int i=1;
                s1[0]="Recent Activities";
                FileInputStream fin=new FileInputStream(f);
                DataInputStream din=new DataInputStream(fin);
                boolean EOF=false;
                while(!EOF)
                {
                    try
                    {
                        s1[i]=din.readUTF();
                        i++;
                        count++;
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
                s1=new String[2];
                count=2;
                s1[0]="Recent Activities";
                s1[1]="-----------------";
            }
            ar=new JLabel[count];
            for(int x=0;x<5;x++)
            {                
                if(x>=count)
                {
                    break;
                }
                ar[x]=new JLabel(s1[x]);
            }
        }
        catch(IOException e)
        {
        }
        v=new JLabel[2];
        v[0]=new JLabel("Number of Login");
        v[1]=new JLabel(String.valueOf(Encrypt.getCount()+1));
    }

    public void switchWindow()
    {    
        b1.setVisible(false);
        b2.setVisible(false);
        b3.setVisible(false);
        b.setVisible(true);
        b4.setVisible(false);
        l6.setVisible(false);
        l7.setVisible(false);
        t1.setVisible(false);
        l5.setVisible(false);
        t3.setVisible(false);
        t2.setVisible(false);

        h.setVisible(true);
        e.setVisible(true);
        t.setVisible(true);
        hl.setVisible(true);
        el.setVisible(true);

        for(int x=0;x<ar.length;x++)
        {
            ar[x].setVisible(true);
        }

        for(int x=0;x<v.length;x++)
        {
            v[x].setVisible(true);
        }
    }

    public void encryption()
    {
        JFileChooser ob=new JFileChooser();
        File f1=new File("w.png");
        Encrypt.encrypt(f1);
        ImageIcon img=new ImageIcon("w.png");
        Encrypt.encrypt(f1);
        ob.showOpenDialog(null);
        File f=ob.getSelectedFile();
        Encrypt.encrypt(f);
        Create c=new Create(f.getPath());
        for(int x=0;x<ar.length;x++)
        {
            ar[x].setVisible(false);
        }

        for(int x=0;x<v.length;x++)
        {
            v[x].setVisible(false);
        }
        init();
        switchWindow();
    }
}