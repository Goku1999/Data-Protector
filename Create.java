import java.io.*;
import java.util.*;
class Create
{
    File f;
    public Create(String name,String usr,String password,int n)
    {
        try
        {
            try
            {
                f=new File("dou.skp");
                FileOutputStream fout=new FileOutputStream(f);
                DataOutputStream dout=new DataOutputStream(fout);
                dout.writeUTF("Name : "+name);
                dout.writeUTF("Username : "+usr);
                dout.writeUTF("Password : "+password);
                dout.writeUTF(String.valueOf(n));
                dout.close();
                fout.close();
                Encrypt.encrypt(f);
            }
            catch(Exception e)
            {
            }
        }
        catch(Exception e)
        {
        }
    }

    public Create(int n)
    {
        try
        {
            f=new File("dou.skp");
            Encrypt.encrypt(f);
            FileInputStream fin=new FileInputStream(f);
            DataInputStream din=new DataInputStream(fin);
            File temp=new File("temp.skp");
            FileOutputStream fout=new FileOutputStream(temp);
            DataOutputStream dout=new DataOutputStream(fout);
            boolean EOF=false;
            while(!EOF)
            {
                try
                {
                    String s=din.readUTF();
                    try
                    {
                        int a=Integer.parseInt(s);
                        dout.writeUTF(String.valueOf(n));
                    }
                    catch(NumberFormatException e)
                    {
                        dout.writeUTF(s);
                    }
                }
                catch(EOFException e)
                {
                    EOF=true;
                }
            }
            dout.close();
            fout.close();
            din.close();
            fin.close();
            f.delete();
            temp.renameTo(f);
            Encrypt.encrypt(f);
        }
        catch(Exception e)
        {
        }
    }

    public Create(String dir)
    {

        try
        {
            Date d=new Date();
            f=new File("hou.skp");
            if(f.exists())
            {
                Encrypt.encrypt(f);
                FileInputStream fin=new FileInputStream(f);
                DataInputStream din=new DataInputStream(fin);
                File temp=new File("temp.skp");
                FileOutputStream fout=new FileOutputStream(temp);
                DataOutputStream dout=new DataOutputStream(fout);
                boolean EOF=false;
                while(!EOF)
                {
                    try
                    {
                        String s=din.readUTF();
                        dout.writeUTF(s);
                    }
                    catch(EOFException e)
                    {
                        EOF=true;
                    }
                }
                dout.writeUTF(dir+"\t"+d.getHours()+"/"+d.getMinutes()+"/"+d.getSeconds()+"\t"+d.getDate()+"/"+d.getMonth()+"/"+d.getYear());
                dout.close();
                fout.close();
                din.close();
                fin.close();
                f.delete();
                temp.renameTo(f);
                Encrypt.encrypt(f);
            }
            else
            {
                FileOutputStream fout=new FileOutputStream(f);
                DataOutputStream dout=new DataOutputStream(fout);
                dout.writeUTF(dir+"\t"+d.getHours()+"/"+d.getMinutes()+"/"+d.getSeconds()+"\t"+d.getDate()+"/"+d.getMonth()+"/"+d.getYear());
                dout.close();
                fout.close();
                Encrypt.encrypt(f);
            }
        }
        catch(Exception e)
        {
        }
    }
}