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
		lblNewLabel.setFont(new Font("���Ŀ���", Font.PLAIN, 31));
		lblNewLabel.setBounds(405, 90, 281, 78);
		contentPane.add(lblNewLabel);
		
//		���ñ���
		
		//����ͼƬ��·���������·�����߾���·��������ͼƬ����"java��Ŀ��"���ļ��£�
		String path = "back\\start1.jpg";
		// ����ͼƬ
		ImageIcon background = new ImageIcon(path);
		// �ѱ���ͼƬ��ʾ��һ����ǩ����
		JLabel label = new JLabel(background);
		// �ѱ�ǩ�Ĵ�Сλ������ΪͼƬ�պ�����������
		label.setBounds(0, 0,this.getWidth(),this.getHeight());
		// �����ݴ���ת��ΪJPanel���������÷���setOpaque()��ʹ���ݴ���͸��
		JPanel imagePanel = (JPanel) this.getContentPane();
		imagePanel.setOpaque(false);
		// �ѱ���ͼƬ��ӵ��ֲ㴰�����ײ���Ϊ����
		this.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));
		//���ÿɼ�
//		setVisible(true);
		//��رհ�ťʱ�˳�
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Timer tim = new Timer();
		tim.schedule(new TimerTask() {public void run(){start.this.dispose(); login a1 = new login(); Dimension screenSize=java.awt.Toolkit.getDefaultToolkit().getScreenSize();Dimension frameSize=a1.getSize();a1.setLocation((screenSize.width-frameSize.width)/2,(screenSize.height-frameSize.height)/2);a1.setVisible(true);}}, 3500);
		
	}

}
