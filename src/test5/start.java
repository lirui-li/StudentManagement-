package test5;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.Timer;
import java.util.TimerTask;

public class start extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					start frame = new start();
					frame.setVisible(true);
					Dimension screenSize=java.awt.Toolkit.getDefaultToolkit().getScreenSize();
					Dimension frameSize=frame.getSize();
					frame.setLocation((screenSize.width-frameSize.width)/2,(screenSize.height-frameSize.height)/2);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public start() {
		
		this.setUndecorated(true);
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 295);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u5B66\u751F\u7BA1\u7406\u7CFB\u7EDF");
		lblNewLabel.setFont(new Font("华文楷体", Font.PLAIN, 31));
		lblNewLabel.setBounds(405, 90, 281, 78);
		contentPane.add(lblNewLabel);
		
//		设置背景
		
		//背景图片的路径。（相对路径或者绝对路径。本例图片放于"java项目名"的文件下）
		String path = "back\\start1.jpg";
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
		
		Timer tim = new Timer();
		tim.schedule(new TimerTask() {public void run(){start.this.dispose(); login a1 = new login(); Dimension screenSize=java.awt.Toolkit.getDefaultToolkit().getScreenSize();Dimension frameSize=a1.getSize();a1.setLocation((screenSize.width-frameSize.width)/2,(screenSize.height-frameSize.height)/2);a1.setVisible(true);}}, 3500);
		
	}

}
