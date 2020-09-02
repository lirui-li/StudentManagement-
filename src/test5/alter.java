package test5;

import java.awt.AWTEvent;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.Font;
import javax.swing.JButton;

import java.awt.event.AWTEventListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.*;
import java.awt.event.ActionListener;

public class alter extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JButton btnNewButton;
	String name;
	String sex;
	double yuwen;
	double shuxue;
	double yingyu;
	private JButton btnNewButton_1;


	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					alter frame = new alter();
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
	public alter() {
		
		this.setUndecorated(true);
		
		JOptionPane.showMessageDialog(null,"单击确认，查询需要修改的学生信息，双击确认，提交修改的学生信息", "提示", JOptionPane.PLAIN_MESSAGE);
		
		setTitle("\u4FEE\u6539");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 206);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		Color color = new Color(255,250,250);
		contentPane.setBackground(color);
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{120, 113, 149, 132, 134, 0};
		gbl_contentPane.rowHeights = new int[]{35, 0, 0, 36, 36, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNewLabel_1 = new JLabel(" ");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.gridwidth = 5;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 0;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("\u5B66\u53F7");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridwidth = 2;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 1;
		contentPane.add(textField, gbc_textField);
		textField.setColumns(10);
		
		btnNewButton = new JButton("\u786E\u8BA4");
		btnNewButton.setBackground(color);
		btnNewButton.addMouseListener(new MouseAdapter() {
			
			private  boolean flag = false;
			private  int clickNum = 1;	
			@Override
			public void mouseClicked(MouseEvent e) {
				final MouseEvent me = e;
				flag= false;
				if (clickNum==2) {
					this.mouseClickedTwice(me);
					clickNum=1;
					flag=true;
					return;
				}
		
				Timer timer = new Timer();
				
				timer.schedule(new TimerTask() {
					
					int num = 0;
					@Override
					public void run() {
						
						if(flag) {
							num=0;
							clickNum=1;
							this.cancel();
							return;
						}
						
						if (num==1) {
							mouseClickedOnce(me);
							flag=true;
							clickNum=1;
							num=0;
							this.cancel();
							return;
						}
						clickNum++;
						num++;
					}
				},new Date(), 500);
			}
			protected void mouseClickedOnce(MouseEvent me) {
				
				lianjie a= new lianjie();
				String number = textField.getText();
				a.getinformation(3, number);
				textField_1.setText(a.a1.get(0).name);
				//System.out.println(a.a1.get(0).name);
				textField_2.setText(a.a1.get(0).sex);
				textField_3.setText(String.valueOf(a.a1.get(0).yuwen));
				textField_4.setText(String.valueOf(a.a1.get(0).shuxue));
				textField_5.setText(String.valueOf(a.a1.get(0).yingyu));
				name = textField_1.getText();
				sex = textField_2.getText();
				yuwen = Double.parseDouble(textField_3.getText());
			    shuxue = Double.parseDouble(textField_4.getText());
				yingyu = Double.parseDouble(textField_5.getText());
				
			}
			private void mouseClickedTwice(MouseEvent me) {
				lianjie a1 = new lianjie();
				String number = textField.getText();
				String name1 = textField_1.getText();
				String sex1 = textField_2.getText();
				double yuwen1 = Double.parseDouble(textField_3.getText());
				double shuxue1 = Double.parseDouble(textField_4.getText());
				double yingyu1 = Double.parseDouble(textField_5.getText());
				int i=-1;
				if(name != name1) {
					i=1;
					a1.alter(i, name1, number);
				}
				if(sex != sex1) {
					i=2;
					a1.alter(i, sex1, number);
				}
				if(yuwen != yuwen1) {
					i=4;
					a1.alter(i, textField_3.getText(), number);
				}
				if(shuxue != shuxue1) {
					i=5;
					a1.alter(i, textField_4.getText(), number);
				}
				if (yingyu != yingyu1) {
					i=6;
					a1.alter(i, textField_5.getText(), number);
				}
				mdis();
				
			}
		});
		
		
		
		
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 18));
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 3;
		gbc_btnNewButton.gridy = 1;
		contentPane.add(btnNewButton, gbc_btnNewButton);
		
		btnNewButton_1 = new JButton("\u53D6\u6D88");
		btnNewButton_1.setBackground(color);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mdis();
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 18));
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_1.gridx = 4;
		gbc_btnNewButton_1.gridy = 1;
		contentPane.add(btnNewButton_1, gbc_btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u59D3\u540D");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 3;
		contentPane.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JLabel lblNewLabel_7 = new JLabel("\u6027\u522B");
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_7.gridx = 1;
		gbc_lblNewLabel_7.gridy = 3;
		contentPane.add(lblNewLabel_7, gbc_lblNewLabel_7);
		
		JLabel lblNewLabel_3 = new JLabel("\u8BED\u6587");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 2;
		gbc_lblNewLabel_3.gridy = 3;
		contentPane.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		JLabel lblNewLabel_6 = new JLabel("\u6570\u5B66");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 3;
		gbc_lblNewLabel_6.gridy = 3;
		contentPane.add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		JLabel lblNewLabel_4 = new JLabel("\u82F1\u8BED");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_4.gridx = 4;
		gbc_lblNewLabel_4.gridy = 3;
		contentPane.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 0, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 0;
		gbc_textField_1.gridy = 4;
		contentPane.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 0, 5);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 1;
		gbc_textField_2.gridy = 4;
		contentPane.add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.insets = new Insets(0, 0, 0, 5);
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.gridx = 2;
		gbc_textField_3.gridy = 4;
		contentPane.add(textField_3, gbc_textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.insets = new Insets(0, 0, 0, 5);
		gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_4.gridx = 3;
		gbc_textField_4.gridy = 4;
		contentPane.add(textField_4, gbc_textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		GridBagConstraints gbc_textField_5 = new GridBagConstraints();
		gbc_textField_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_5.gridx = 4;
		gbc_textField_5.gridy = 4;
		contentPane.add(textField_5, gbc_textField_5);
		textField_5.setColumns(10);
	}
	
	private void mdis() {
		this.dispose();
	}
}



