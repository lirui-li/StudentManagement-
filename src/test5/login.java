package test5;

import java.awt.AWTEvent;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;


import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.KeyEventPostProcessor;
import java.awt.KeyboardFocusManager;
import java.awt.Toolkit;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

import java.awt.event.AWTEventListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class login extends JFrame {
	
	static final String JDBC_DRIVER="com.mysql.cj.jdbc.Driver";
	static final String DB_URL="jdbc:mysql://localhost:3306/test1?serverTimezone=GMT%2B8&useSSL=false" ;
	
	static final String USER = "root";
	static final String PASS = "mylove6.6";
	
	String t_name=null;
	String t_password=null;

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	protected int xOld;
	protected int yOld;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					login frame = new login();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public login() {
		
		//无标题
		this.setUndecorated(true);
		
		
	
		

        
		//窗口拖动
		addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int xOnScreen = e.getXOnScreen();
				int yOnScreen = e.getYOnScreen();
				int xx = xOnScreen - xOld;
				int yy = yOnScreen - yOld;
				login.this.setLocation(xx, yy);// 设置拖拽后，窗口的位置
			}
		});
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				xOld = e.getX();// 记录鼠标按下时的坐标
				yOld = e.getY();
			}
		});
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 635);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setFocusable(true);
		contentPane.setBackground(new Color(255,255,255));
		
		//设置快捷退出
		Toolkit.getDefaultToolkit().addAWTEventListener(new AWTEventListener() {
			
			@Override
			public void eventDispatched(AWTEvent event) {
				// TODO Auto-generated method stub
				if(((KeyEvent)event).getID()==KeyEvent.KEY_PRESSED){
					if(((KeyEvent)event).getKeyCode()==KeyEvent.VK_ESCAPE) {
						//System.out.println("esc");
						System.exit(0);
					}
				}
			}
		}, AWTEvent.KEY_EVENT_MASK);
//		设置背景
		
		//背景图片的路径。（相对路径或者绝对路径。本例图片放于"java项目名"的文件下）
		String path = "back\\login.jpg";
		// 背景图片
		ImageIcon background = new ImageIcon(path);
		// 把背景图片显示在一个标签里面
		JLabel label = new JLabel(background);
		// 把标签的大小位置设置为图片刚好填充整个面板
		label.setBounds(0, 0,this.getWidth(),this.getHeight());
		// 把内容窗格转化为JPanel，否则不能用方法setOpaque()来使内容窗格透明
		JPanel imagePanel = (JPanel) this.getContentPane();
		imagePanel.setOpaque(false);
		// 把背景图片添加到分层窗格的最底层作为背景
		this.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));
		//设置可见
//		setVisible(true);
		//点关闭按钮时退出
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	     
		
		
		JLabel lblNewLabel = new JLabel("\u5B66\u751F\u7BA1\u7406\u7CFB\u7EDF");
		lblNewLabel.setFont(new Font("华文楷体", Font.BOLD, 25));
		lblNewLabel.setBounds(414, 97, 159, 51);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setOpaque(false);
		textField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				String temp = textField.getText();
				if(temp.equals("请输入用户名")) {
					textField.setText("");
					textField.setForeground(Color.BLACK);
				}

			}
			@Override
			public void focusLost(FocusEvent e) {
				String temp = textField.getText();
				if(temp.equals("")) {
					textField.setForeground(Color.GRAY);
					textField.setText("请输入用户名");
				}

			}
		});
		textField.setText("请输入用户名");
		textField.setForeground(Color.GRAY);
	
		textField.setFont(new Font("华文楷体", Font.PLAIN, 20));
		textField.setBounds(326, 176, 331, 36);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setOpaque(false);
		passwordField.setFont(new Font("华文楷体", Font.PLAIN, 20));
		passwordField.setBounds(326, 250, 331, 36);
		contentPane.add(passwordField);
		
		passwordField.addKeyListener(new KeyListener()
		{
			public void keyTyped(KeyEvent e) {}
			public void keyReleased(KeyEvent e){}
			public void keyPressed(KeyEvent e){
				if(e.getKeyChar() == KeyEvent.VK_ENTER )
				{
					loginn();
				}
			}
		});
		
		JButton btnNewButton = new JButton("\u767B\u9646");
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setIcon(new ImageIcon(""));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				loginn();
			}
		});
		btnNewButton.setFont(new Font("华文楷体", Font.BOLD, 25));
		btnNewButton.setBounds(326, 324, 331, 36);
		contentPane.add(btnNewButton);
		
		Dimension screenSize=java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize=this.getSize();
		this.setLocation((screenSize.width-frameSize.width)/2,(screenSize.height-frameSize.height)/2);
		
	}
	
	
	    public void loginn() {
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
						t_password = passwordField.getText();
						if (g_password.equals(t_password)==false) {
								JOptionPane.showMessageDialog(null,"密码错误，请重输", null, JOptionPane.PLAIN_MESSAGE);
						}else {
							
					        dispose();
					        find a1= new find(t_name);
					        a1.setLocation(60, 174);
					        a1.setVisible(true);
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
	
}
