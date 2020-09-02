package test5;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.RenderingHints;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.TextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.sql.*;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.event.TextListener;
import java.awt.event.TextEvent;

import javax.swing.border.*;

import javax.swing.UIManager.*;
import javax.swing.UnsupportedLookAndFeelException;


public class login1 extends JFrame {
	
	static final String JDBC_DRIVER="com.mysql.cj.jdbc.Driver";
	static final String DB_URL="jdbc:mysql://localhost:3306/test1?serverTimezone=GMT%2B8&useSSL=false" ;
	
	static final String USER = "root";
	static final String PASS = "mylove6.6";
	
	String t_name=null;
	String t_password=null;

	private JPanel contentPane;
	private JPasswordField pwdTpassword;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		// 主题1 
//		try {
//		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
//		        if ("Nimbus".equals(info.getName())) {
//		            UIManager.setLookAndFeel(info.getClassName());
//		            break;
//		        }
//		    }
//		} catch (Exception e) {
//		    // If Nimbus is not available, you can set the GUI to another look and feel.
//		}
		
		
		//主题2
		/*com.jtattoo.plaf.noire.NoireLookAndFeel 柔和黑
		com.jtattoo.plaf.smart.SmartLookAndFeel 木质感+xp风格
		com.jtattoo.plaf.mint.MintLookAndFeel 椭圆按钮+黄色按钮背景
		com.jtattoo.plaf.mcwin.McWinLookAndFeel 椭圆按钮+绿色按钮背景
		com.jtattoo.plaf.luna.LunaLookAndFeel 纯XP风格
		com.jtattoo.plaf.hifi.HiFiLookAndFeel 黑色风格
		com.jtattoo.plaf.fast.FastLookAndFeel 普通swing风格+蓝色边框
		com.jtattoo.plaf.bernstein.BernsteinLookAndFeel 黄色风格
		com.jtattoo.plaf.aluminium.AluminiumLookAndFeel 椭圆按钮+翠绿色按钮背景+金属质感
		com.jtattoo.plaf.aero.AeroLookAndFeel xp清新风格
		com.jtattoo.plafacryl.AcrylLookAndFeel 布质感+swing纯风格
		com.jtattoo.plaf.graphite.GraphiteLookAndFeel*/
		
//	    try {
//	    	// 加载主题， 如果要更换主题只需要更改这一行代码
//	    				UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
//	    			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException| UnsupportedLookAndFeelException e) {
//	    				e.printStackTrace();
//	    			}
	    			
	    			

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login1 frame = new login1();
//					frame.dispose();				// 这里使用的顺序要注意 配合主题2
//					frame.setUndecorated(true);		//取消边框
					frame.setVisible(true);
//	设置窗口居中		Dimension screenSize=java.awt.Toolkit.getDefaultToolkit().getScreenSize();
//					Dimension frameSize=frame.getSize();
//					frame.setLocation((screenSize.width-frameSize.width)/2,(screenSize.height-frameSize.height)/2);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				

			}
		});
	}

	/**
	 * Create the frame.
	 */
	public login1() {
		setTitle("\u5B66\u751F\u7BA1\u7406\u7CFB\u7EDF1.0--\u767B\u9646");
		
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 431, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		Color color = new Color(255,250,250);
		contentPane.setBackground(color);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUser = new JLabel("User");
		lblUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblUser.setFont(new Font("宋体", Font.PLAIN, 26));
		lblUser.setBounds(34, 45, 75, 20);
		contentPane.add(lblUser);
		
		JLabel lblPassword = new JLabel("Password");
		
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("宋体", Font.PLAIN, 26));
		lblPassword.setBounds(26, 113, 142, 36);
		contentPane.add(lblPassword);
		
		
		JButton btnLogin = new JButton("Login");
		//btnLogin.setBorderPainted(false);
		btnLogin.setBackground(color);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection conn = null;
				Statement stmt = null;
				try {
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					//System.out.println("连接数据库中");
					conn = DriverManager.getConnection(DB_URL,USER,PASS);
					//System.out.println("实例化Statement对象...");
					stmt=conn.createStatement();
					String sql;
					t_name = textField.getText();
					sql ="SELECT Password,permissions FROM login where User='"+t_name+"'";
					//System.out.println("查询中..");
					ResultSet rs = stmt.executeQuery(sql);
					if(rs.next()) {
							String g_password = rs.getString("Password");
								t_password = pwdTpassword.getText();
								if (g_password.equals(t_password)==false) {
										JOptionPane.showMessageDialog(null,"密码错误，请重输", null, JOptionPane.PLAIN_MESSAGE);
								}else {
									lianjie a = new lianjie(t_name);
							        
								}
					}else {
						JOptionPane.showMessageDialog(null,"用户名不存在，请重新输入", null, JOptionPane.PLAIN_MESSAGE);
					}
				
					
					
					 rs.close();
			         stmt.close();
			         conn.close();
			         
			         
				}catch(Exception e1){
		            // 处理 Class.forName 错误
		            e1.printStackTrace();
		        }
				finally{
		            // 关闭资源
		            try{
		                if(stmt!=null) stmt.close();
		            }catch(SQLException se2){
		            }// 什么都不做
		            try{
		                if(conn!=null) conn.close();
		            }catch(SQLException se){
		                se.printStackTrace();
		            }
		        }
			}
		});
		btnLogin.setFont(new Font("宋体", Font.PLAIN, 20));
		btnLogin.setBounds(53, 194, 97, 23);
		contentPane.add(btnLogin);
		
		JButton btnExist = new JButton("Exit");
		btnExist.setBackground(color);
		btnExist.setFont(new Font("宋体", Font.PLAIN, 20));
		btnExist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExist.setBounds(236, 194, 97, 23);
		contentPane.add(btnExist);
		
		pwdTpassword = new JPasswordField();
		pwdTpassword.setBounds(164, 126, 180, 20);
		contentPane.add(pwdTpassword);
		
//    	TextBorderUtlis border = new TextBorderUtlis(new Color(0,0,0), 3,true);
		
		textField = new JTextField();

//		textField.setBorder(border);
		textField.setBounds(164, 50, 180, 21);
		contentPane.add(textField);
		textField.setColumns(10);
	}
	
	
}


class TextBorderUtlis extends LineBorder {

	private static final long serialVersionUID = 1L;

	public TextBorderUtlis(Color color, int thickness, boolean roundedCorners) 
	{
		super(color, thickness, roundedCorners);
	}

	public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) 
	{

		RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		Color oldColor = g.getColor();
		Graphics2D g2 = (Graphics2D) g;
		int i;
		g2.setRenderingHints(rh);
		g2.setColor(lineColor);
		for (i = 0; i < thickness; i++) 
		{
			if (!roundedCorners){
				g2.drawRect(x + i, y + i, width - i - i - 1, height - i - i - 1);
			}else{
				g2.drawRoundRect(x + i, y + i, width - i - i - 1, height - i - i - 1, 5, 5);}
		}
		g2.setColor(oldColor);
	
	}

}


