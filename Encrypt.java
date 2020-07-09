import java.io.*;
class Encrypt
{
    static int a;
    static int n;
    public static void encrypt(File f)
    {
        try
        {
            FileInputStream fin=new FileInputStream(f);
            DataInputStream din=new DataInputStream(fin);
            byte ar[]=new byte[(int)f.length()];
            din.readFully(ar);
            din.close();
            fin.close();
            f.delete();
            String s=f.getPath();
            if(n==0)
            {
                n=13;
            }
            for(int x=0;x<ar.length;x++)
            {
                ar[x]=(byte)(ar[x]^n);
            }
            FileOutputStream fout=new FileOutputStream(f);
            fout.write(ar);
            fout.close();
        }
        catch(Exception e)
        {
        }
    }

    public static int getCount()
    {
        File f1=new File("dou.skp");
        Encrypt.encrypt(f1);
        String l="";
        int n=0;
        try
        {
            FileInputStream fin=new FileInputStream(f1);
            DataInputStream din=new DataInputStream(fin);
            boolean EOF=false;
            while(!EOF)
            {
                try
                {
                    String temp=din.readUTF();
                    try
                    {
                        a=Integer.parseInt(temp);
                    }
                    catch(NumberFormatException e)
                    {                  
                    }
                }
                catch(EOFException e)
                {
                    EOF=true;
                }
            }
            din.close();
            fin.close();
        }
        catch(Exception e)
        {
        }
        n=l.trim().length();
        Encrypt.encrypt(f1);
        return a;
    }

    public static String getName()
    {
        File f1=new File("dou.skp");
        Encrypt.encrypt(f1);
        int n=0;
        String temp="";
        try
        {
            FileInputStream fin=new FileInputStream(f1);
            DataInputStream din=new DataInputStream(fin);
            boolean EOF=false;
            while(!EOF)
            {
                try
                {
                    temp=din.readUTF();
                    if(temp.length()!=0)
                    {
                        break;
                    }
                }
                catch(EOFException e)
                {
                    EOF=true;
                }
            }
            din.close();
            fin.close();
            Encrypt.encrypt(f1);
        }
        catch(Exception e)
        {
        }
        if(temp.length()>0)
        {
            temp=temp.substring(temp.indexOf(":")+1);
        }
        return temp;
    }

    public static String getID()
    {
        File f1=new File("dou.skp");
        Encrypt.encrypt(f1);
        int n=0;
        String temp="";
        try
        {
            FileInputStream fin=new FileInputStream(f1);
            DataInputStream din=new DataInputStream(fin);
            boolean EOF=false;
            int count=0;
            while(!EOF)
            {
                try
                {
                    temp=din.readUTF();
                    if(temp.length()!=0)
                    {
                        count++;
                        if(count>1)
                        {
                            break;
                        }
                    }
                }
                catch(EOFException e)
                {
                    EOF=true;
                }
            }
            din.close();
            fin.close();
            Encrypt.encrypt(f1);
        }
        catch(Exception e)
        {
        }
        if(temp.length()>0)
        {
            temp=temp.substring(temp.indexOf(":")+1);
        }
        return temp;
    }
    public static String getPassword()
    {
        File f1=new File("dou.skp");
        Encrypt.encrypt(f1);
        int n=0;
        String temp="";
        try
        {
            FileInputStream fin=new FileInputStream(f1);
            DataInputStream din=new DataInputStream(fin);
            boolean EOF=false;
            int count=0;
            while(!EOF)
            {
                try
                {
                    temp=din.readUTF();
                    if(temp.length()!=0)
                    {
                        count++;
                        if(count>2)
                        {
                            break;
                        }
                    }
                }
                catch(EOFException e)
                {
                    EOF=true;
                }
            }
            din.close();
            fin.close();
            Encrypt.encrypt(f1);
        }
        catch(Exception e)
        {
        }
        if(temp.length()>0)
        {
            temp=temp.substring(temp.indexOf(":")+1);
        }
        return temp;
    }
}