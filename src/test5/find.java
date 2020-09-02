package test5;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.text.*;
import javax.swing.text.html.*;
import javax.swing.text.html.parser.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.SQLException;

import javax.swing.JScrollPane;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;

import javax.script.ScriptEngineManager;
import javax.swing.JButton;

import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

public class find extends JFrame {
	
	private JPanel contentPane;
	private JTextField textField;
	private HTMLDocument text_html;
	private HTMLEditorKit htmledit;
	private JTextPane txtpnidifgdiderg;
	private JScrollPane scrollPane;
	private int scom=0;
	private String stf=null;
	private JPanel panel;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JButton btnNewButton_4;
	private JComboBox comboBox;
	private JLabel lblNewLabel_1;
	private boolean A;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					find frame = new find();
//					frame.setLocation(60, 174);
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
	public find(String name) {
		
		lianjie a = new lianjie(name);
		if(a.getper()==0) {
			A=true;
		}else {
			A=false;
		}
		
		
		this.setLocation(50, 174);
		
		Color color = new Color(255,250,250);
	
		
		setTitle("\u67E5\u627E");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 847, 525);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		contentPane.setBackground(color);
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{202, 212, 130, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 13, 0, -17, 84, 158, 22, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		String []box= {"全部","姓名","性别","学号","语文","数学","英语"};
		comboBox = new JComboBox(box);
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				scom=comboBox.getSelectedIndex();
				System.out.println(scom);
			}
		});
		
		lblNewLabel_1 = new JLabel(" ");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.gridwidth = 3;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.gridheight = 4;
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 0;
		gbc_comboBox.gridy = 2;
		contentPane.add(comboBox, gbc_comboBox);
		
		textField = new JTextField();
		
		
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridheight = 4;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 2;
		contentPane.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel label = new JLabel("\u67E5\u627E");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 0);
		gbc_label.gridx = 2;
		gbc_label.gridy = 3;
		contentPane.add(label, gbc_label);
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				stf=textField.getText();
				System.out.println(stf);
				if(scom==0) {
					xs1();
				}
				else {
					
					xs();
					
				}
			}
		});
		label.setFont(new Font("宋体", Font.PLAIN, 20));
		
		JLabel lblNewLabel = new JLabel("");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridwidth = 3;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 5;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		
		
		htmledit = new HTMLEditorKit();
		text_html=(HTMLDocument) htmledit.createDefaultDocument();
		
		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.gridheight = 2;
		gbc_scrollPane.gridwidth = 3;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 6;
		contentPane.add(scrollPane, gbc_scrollPane);
		
		
		 txtpnidifgdiderg = new JTextPane();
		 txtpnidifgdiderg.setEditable(false);
		 scrollPane.setViewportView(txtpnidifgdiderg);
		 txtpnidifgdiderg.setEditorKit(htmledit);
		 txtpnidifgdiderg.setContentType("text/html");
		 txtpnidifgdiderg.setDocument(text_html);
		 
		 
		 panel = new JPanel();
		 panel.setLayout(null);
		 panel.setBackground(color);
		 GridBagConstraints gbc_panel = new GridBagConstraints();
		 gbc_panel.gridwidth = 3;
		 gbc_panel.fill = GridBagConstraints.BOTH;
		 gbc_panel.gridx = 0;
		 gbc_panel.gridy = 8;
		 contentPane.add(panel, gbc_panel);
		 
		 btnNewButton_1 = new JButton("\u589E\u52A0");
		 btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 16));
		 btnNewButton_1.setBackground(color);
		 btnNewButton_1.addMouseListener(new MouseAdapter() {
		 	@Override
		 	public void mouseClicked(MouseEvent e) {
		 		add a1=new add();
		 		a1.setLocation(896, 279);
		 		a1.setVisible(true);
		 		Timer tim = new Timer();
		 		MyTimerTask mtt = new MyTimerTask("1",find.this,a1);
		 		tim.schedule(mtt, 1000,1000);
		 	}
		 });
		 btnNewButton_1.setBounds(22, 0, 125, 40);
		 panel.add(btnNewButton_1);
		 
		 btnNewButton_2 = new JButton("\u5220\u9664");
		 btnNewButton_2.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		delete a1 = new delete();
		 		a1.setLocation(896, 279);
		 		a1.setVisible(true);
		 		Timer tim = new Timer();
		 		MyTimerTask mtt = new MyTimerTask("2",find.this,a1);
		 		tim.schedule(mtt, 1000,1000);
		 	}
		 });
		 btnNewButton_2.setEnabled(A);
		 btnNewButton_2.setFont(new Font("宋体", Font.PLAIN, 16));
		 btnNewButton_2.setBackground(color);
		 btnNewButton_2.addMouseListener(new MouseAdapter() {
		 	@Override
		 	public void mouseClicked(MouseEvent e) {
		 	}
		 });
		 btnNewButton_2.setBounds(232, 0, 125, 40);
		 panel.add(btnNewButton_2);
		 
		 btnNewButton_3 = new JButton("\u4FEE\u6539");
		 btnNewButton_3.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		alter a1 = new alter();
		 		a1.setLocation(896, 279);
		 		a1.setVisible(true);
		 		Timer tim = new Timer();
		 		MyTimerTask mtt = new MyTimerTask("3",find.this,a1);
		 		tim.schedule(mtt, 1000,1000);
		 	}
		 });
		 btnNewButton_3.setFont(new Font("宋体", Font.PLAIN, 16));
		 btnNewButton_3.setEnabled(A);
		 btnNewButton_3.setBackground(color);
		 btnNewButton_3.addMouseListener(new MouseAdapter() {
		 	@Override
		 	public void mouseClicked(MouseEvent e) {
		 		
		 	}
		 });
		 btnNewButton_3.setBounds(450, 0, 125, 40);
		 panel.add(btnNewButton_3);
		 
		 btnNewButton_4 = new JButton("\u8FD4\u56DE");
		 btnNewButton_4.setFont(new Font("宋体", Font.PLAIN, 16));
		 btnNewButton_4.setBackground(color);
		 btnNewButton_4.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		mdis();
		 		login a1 = new login();
				a1.setVisible(true);
		 	}
		 });
		 btnNewButton_4.setBounds(668, 0, 125, 40);
		 panel.add(btnNewButton_4);
		try {
		htmledit.insertHTML(text_html, txtpnidifgdiderg.getCaretPosition(),"",0,0,HTML.Tag.TABLE);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	private void mdis() {
		this.dispose();
	}
	public void xs() {
		stf=textField.getText();
		lianjie a= new lianjie();
		a.getinformation(scom, stf);
		htmledit = new HTMLEditorKit();
		text_html=(HTMLDocument) htmledit.createDefaultDocument();
		txtpnidifgdiderg.setEditorKit(htmledit);
		txtpnidifgdiderg.setContentType("text/html");
		txtpnidifgdiderg.setDocument(text_html);
		
		try {
			String html="<html>\r\n" + 
					"<body>\r\n" + 
					"<table>\r\n" + 
					"<tr>\r\n" + 
					"<th>姓名</th>\r\n" + 
					"<th>性别</th>\r\n" + 
					"<th>学号</th>\r\n" + 
					"<th>语文</th>\r\n" + 
					"<th>数学</th>\r\n" + 
					"<th>英语</th>\r\n" + 
					"</tr>\r\n" +
					"";
			for (int i=0;i<a.a1.size();i++) {
					html=html+
							"<tr>\r\n" + 
							"<td>"+a.a1.get(i).name+"</td>\r\n" + 
							"<td>"+a.a1.get(i).sex+"</td>\r\n" + 
							"<td>"+a.a1.get(i).number+"</td>\r\n" + 
							"<td>"+a.a1.get(i).yuwen+"</td>\r\n" + 
							"<td>"+a.a1.get(i).shuxue+"</td>\r\n" + 
							"<td>"+a.a1.get(i).yingyu+"</td>\r\n" + 
							"</tr>\r\n" + 
							"";
			
			}
			html=html+"</table>\r\n" + 
					"</body>\r\n" + 
					"</html>\r\n" + 
					"";
			htmledit.insertHTML(text_html, txtpnidifgdiderg.getCaretPosition(),html,0,0,HTML.Tag.TABLE);
			
			
		}catch(Exception e1) {
			e1.printStackTrace();
		}
	}
	public void xs1() {
		
		lianjie a= new lianjie();
		a.getall();
		htmledit = new HTMLEditorKit();
		text_html=(HTMLDocument) htmledit.createDefaultDocument();
		txtpnidifgdiderg.setEditorKit(htmledit);
		txtpnidifgdiderg.setContentType("text/html");
		txtpnidifgdiderg.setDocument(text_html);
		
		try {
			String html="<html>\r\n" + 
					"<body>\r\n" + 
					"<table>\r\n" + 
					"<tr>\r\n" + 
					"<th>姓名</th>\r\n" + 
					"<th>性别</th>\r\n" + 
					"<th>学号</th>\r\n" + 
					"<th>语文</th>\r\n" + 
					"<th>数学</th>\r\n" + 
					"<th>英语</th>\r\n" + 
					"</tr>\r\n" +
					"";
					
			
			for (int i=0;i<a.a1.size();i++) {
					html=html+
							"<tr>\r\n" + 
							"<td>"+a.a1.get(i).name+"</td>\r\n" + 
							"<td>"+a.a1.get(i).sex+"</td>\r\n" + 
							"<td>"+a.a1.get(i).number+"</td>\r\n" + 
							"<td>"+a.a1.get(i).yuwen+"</td>\r\n" + 
							"<td>"+a.a1.get(i).shuxue+"</td>\r\n" + 
							"<td>"+a.a1.get(i).yingyu+"</td>\r\n" + 
							"</tr>\r\n" + 
							"";
			
			}
			html=html+"</table>\r\n" + 
					"</body>\r\n" + 
					"</html>\r\n" + 
					"";
			htmledit.insertHTML(text_html, txtpnidifgdiderg.getCaretPosition(),html,0,0,HTML.Tag.TABLE);
			
			
		}catch(Exception e1) {
			e1.printStackTrace();
		}
	}
	
}


class MyTimerTask extends TimerTask{
	private String name;
	private find a;
	private add b=null;
	private delete c=null;
	private alter d=null;

	public MyTimerTask(String inputName,find a1,add b1) {
		name = inputName;
		a=a1;
		b=b1;
	}
	public MyTimerTask(String inputName,find a1,delete b1) {
		name = inputName;
		a=a1;
		c=b1;
	}
	public MyTimerTask(String inputName,find a1,alter b1) {
		name = inputName;
		a=a1;
		d=b1;
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	@Override
	public void run() {
		if(b!=null) {
			if(b.isShowing()==false) {
				a.xs1();
				this.cancel();
			}
		} 
		if(c!=null) {
			if(c.isShowing()==false) {
				a.xs1();
				this.cancel();
			}
		}
		if(d!=null) {
			if(d.isShowing()==false) {
				a.xs1();
				this.cancel();
			}
		}
		
	}
//	public String makeReport() {
//		String html = "<html><head><title>学生管理系统 1.0</title><script src=\"https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js\">\r\n" + 
//				"</script>\r\n" + 
//				"<script>\r\n" + 
//				"$(document).ready(function(){\r\n" + 
//				"	$.get(\"https://v1.hitokoto.cn/\",function(data,status){\r\n" + 
//				"		$(\"#div1\").text(data.hitokoto+'——'+data.from);\r\n" + 
//				"	});\r\n" + 
//				"});\r\n" + 
//				"</script></head><body><h1>成绩报告</h1><div id=\"div1\"><h2>使用 jQuery AJAX 修改文本内容</h2></div><table>\r\n" + 
//				"<tr>\r\n" + 
//				"<th>姓名</th>\r\n" + 
//				"<th>性别</th>\r\n" + 
//				"<th>学号</th>\r\n" + 
//				"<th>语文</th>\r\n" + 
//				"<th>数学</th>\r\n" + 
//				"<th>英语</th>\r\n" + 
//				"</tr>\r\n" +
//				"";
//		
//		lianjie a= new lianjie();
//		a.getall();
//		
//		for (int i=0;i<a.a1.size();i++) {
//			html=html+
//					"<tr>\r\n" + 
//					"<td>"+a.a1.get(i).name+"</td>\r\n" + 
//					"<td>"+a.a1.get(i).sex+"</td>\r\n" + 
//					"<td>"+a.a1.get(i).number+"</td>\r\n" + 
//					"<td>"+a.a1.get(i).yuwen+"</td>\r\n" + 
//					"<td>"+a.a1.get(i).shuxue+"</td>\r\n" + 
//					"<td>"+a.a1.get(i).yingyu+"</td>\r\n" + 
//					"</tr>\r\n" + 
//					"";
//	
//	}
//	html=html+"</table>\r\n" + 
//			"</body>\r\n" + 
//			"</html>\r\n" + 
//			"";
//		html += "</table></body></html>";
//		return html;
//	}
//	public void actionPerformed(ActionEvent e) {
//		saveTxtFile(makeReport(), "report.html");
//		File directory = new File("");//设定为当前文件夹 
////		try{ 
////		    System.out.println(directory.getCanonicalPath());//获取标准的路径 
////		    System.out.println(directory.getAbsolutePath());//获取绝对路径 
////		}catch(Exception e1){} 
//
//		Desktop desktop = Desktop.getDesktop();   
//		URI uri = null;
//		try {
//			uri = new File(directory.getCanonicalPath()+"\\report.html").toURI();
//			desktop.browse(uri);
//		} catch (Exception e1) {
//			// TODO 自动生成的 catch 块
//			e1.printStackTrace();
//		} //使用默认浏览器打开超链接
//
//	}

}
