package test5;

import java.sql.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

class student{
	String name;
	String sex;
	int number;
	double yuwen;
	double shuxue;
	double yingyu;
	int id;
	
	student(String a, String b,int c,double d, double e,double f,int g){
		name = a;
		sex = b;
		number = c;
		yuwen = d ;
		shuxue = e;
		yingyu = f;
		id=g;
	}
}
public class lianjie {
	
	ArrayList <student> a1 = new ArrayList<>();
	static final String JDBC_DRIVER="com.mysql.cj.jdbc.Driver";
	static final String DB_URL="jdbc:mysql://localhost:3306/test1?serverTimezone=GMT%2B8&useSSL=false" ;
	
	static final String USER = "root";
	static final String PASS = "mylove6.6";
	private String name=null;
	private String password=null;
	private int permissions;
	
	Connection conn = null;
	Statement stmt = null;
	//�������ݿ�
	public lianjie() {
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
			stmt = conn.createStatement();
		}catch(Exception e){
            // ���� Class.forName ����
            e.printStackTrace();
        }
		
	}
	//��½
	public lianjie(String name1){
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//System.out.println("�������ݿ���");
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
			//System.out.println("ʵ����Statement����...");
			stmt = conn.createStatement();
			String sql;
			sql="SELECT User,Password,permissions FROM login where User='"+name1+"'";
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()) {
				name=rs.getString("User");
				password=rs.getString("Password");
				permissions=rs.getInt("permissions");
	            }
	            // ��ɺ�ر�
	            rs.close();
	            stmt.close();
	            conn.close();
			
		}catch(SQLException se){
            // ���� JDBC ����
            //se.printStackTrace();
        }catch(Exception e){
            // ���� Class.forName ����
            //e.printStackTrace();
        }finally{
            // �ر���Դ
            try{
                if(stmt!=null) stmt.close();
            }catch(SQLException se2){
            }// ʲô������
            try{
                if(conn!=null) conn.close();
            }catch(SQLException se){
                //se.printStackTrace();
            }
        }
	}
	//��ʱû��
	public void cx(String sql1) {
		try {
			String sql;
			sql="SELECT User,Password,permissions FROM login where User='"+sql1+"'";
			stmt=conn.createStatement();
		}catch(SQLException se){
            // ���� JDBC ����
            se.printStackTrace();
        }
		
	};
	//��ѯ���ݿ�������е���Ϣ
	public void getall() {
		try {
			String sql;
			sql="SELECT * FROM student";
			stmt=conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				a1.add(new student(rs.getString("name"),rs.getString("sex"),rs.getInt("number"),rs.getDouble("yuwen"),rs.getDouble("shuxue"),rs.getDouble("yingyu"),rs.getInt("id")));
			}
			rs.close();
            stmt.close();
            conn.close();
		}catch(SQLException se){
            // ���� JDBC ����
            //se.printStackTrace();
        }catch(Exception e){
            // ���� Class.forName ����
           // e.printStackTrace();
        }finally{
            // �ر���Դ
            try{
                if(stmt!=null) stmt.close();
            }catch(SQLException se2){
            }// ʲô������
            try{
                if(conn!=null) conn.close();
            }catch(SQLException se){
               // se.printStackTrace();
            }
        }
	}
	
	//������ѯ
	public void getinformation(int a,String b) {
		try {
			String sql;
			sql="SELECT sort FROM match1 WHERE id="+a+"";
			stmt=conn.createStatement();
			String select=null;
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				select=rs.getString("sort");
				System.out.println(select);
			}
			b=b.replace(' ', '%');
			sql="SELECT * FROM student WHERE "+select+" LIKE '%"+b+"%'";
			//System.out.println(sql);
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				a1.add(new student(rs.getString("name"),rs.getString("sex"),rs.getInt("number"),rs.getDouble("yuwen"),rs.getDouble("shuxue"),rs.getDouble("yingyu"),rs.getInt("id")));
			}
			rs.close();
            stmt.close();
            conn.close();
			
		}catch(SQLException se){
            // ���� JDBC ����
           // se.printStackTrace();
        }catch(Exception e){
            // ���� Class.forName ����
            //e.printStackTrace();
        }finally{
            // �ر���Դ
            try{
                if(stmt!=null) stmt.close();
            }catch(SQLException se2){
            }// ʲô������
            try{
                if(conn!=null) conn.close();
            }catch(SQLException se){
                //se.printStackTrace();
            }
        }
		
		
	}
	//���Ӽ�¼
	public void add(String a,String b,int c,double d,double e,double f,int g) {
		try{
			
			String sql;
			if(g==0) {
				sql="INSERT INTO student(name,sex,number,yuwen,shuxue,yingyu) VALUES('"+a+"',"+"'"+b+"',"+c+","+d+","+e+","+f+")";
			}else {
				sql="INSERT INTO student VALUES('"+a+"',"+"'"+b+"',"+c+","+d+","+e+","+f+","+g+")";
			}
			//System.out.println(sql);
			stmt.execute(sql);
		}catch(Exception e1){
            // ���� Class.forName ����
			JOptionPane.showMessageDialog(null,"�������Ŵ��ڻ�������Ϣ����������������ȷ����Ϣ", null, JOptionPane.PLAIN_MESSAGE);
			add a2=new add();
			a2.sett(a, b, c, d, e, f, g);
			a2.setVisible(true);
//            e1.printStackTrace();
        }
		
	};
	
	//ɾ����¼
	public void delete(int a) {
		
		try{
			
			String sql;
			sql="DELETE FROM student WHERE number = "+a;
			//System.out.println(sql);
			stmt.execute(sql);
		}catch(Exception e1){
            // ���� Class.forName ����
			JOptionPane.showMessageDialog(null,"�������Ŵ��ڻ�������Ϣ����������������ȷ����Ϣ", null, JOptionPane.PLAIN_MESSAGE);
        }
		
	}
	
	//�޸ļ�¼
	public void alter(int a,String b,String c) {
		try{
			String sql;
			sql="SELECT sort FROM match1 WHERE id="+a+"";
			stmt=conn.createStatement();
			String select=null;
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				select=rs.getString("sort");
				System.out.println(select);
			}
			sql ="UPDATE student SET "+select+" = "+b+" WHERE number ='"+c+"'";
			
			//System.out.println(sql);
			stmt.execute(sql);
		}catch(Exception e1){
           
			
        }
	}
	public String getname() {
		return name;
	};
	public String getpa() {
		return password;
	};
	public int getper() {
		return permissions;
	};
	
}
