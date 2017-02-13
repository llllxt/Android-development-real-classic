package com.xfhy.management;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * ��¼���Ǹ�����
 * @author XFHY
 *
 */
public class Login {

	private JLabel userlab = new JLabel("�û���:",JLabel.CENTER);   //������ǩ,����
	private JTextField usertext = new JTextField(15);   //��������Ϊ25���ı���
	private JLabel passwdlab = new JLabel("��   ��:",JLabel.CENTER);
	private JPasswordField passwdText = new JPasswordField(15);  //��������Ϊ25�������
	private JLabel loginlab = new JLabel("",JLabel.CENTER); //��ʾ�ڽ���������ĵ�¼״̬
	private final DefaultComboBoxModel loginType = new DefaultComboBoxModel();  //�����������
	private JComboBox loginTypeChan =null;
	
	public Login()
	{
		final JFrame jframe = new JFrame("��¼����");
		JPanel userPanel = new JPanel();    //����һ��user�����
		JPanel passwdPanel = new JPanel();  //����һ����������
		JPanel buttonPanel = new JPanel();  //����һ����ť�����
		JPanel labelPanel = new JPanel();   //����һ����¼״̬�����
		JButton submit = new JButton("��¼");
		JButton reset = new JButton("����");
		Font font = new Font("����",Font.BOLD,35);
		loginlab.setFont(font);
		loginlab.setForeground(Color.BLUE);
		labelPanel.add(loginlab);   //��ӵ�¼��Ϣ�����
		
		loginType.addElement("Student");
		loginType.addElement("Teacher");
		loginTypeChan = new JComboBox(loginType);
		
		//ע���¼��ť�¼�������
		submit.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				//�õ��û���¼������
				String loginPeople = loginTypeChan.getItemAt(loginTypeChan.getSelectedIndex()).
						toString();
				String user = usertext.getText();  //�û�id
				String passwd = new String(passwdText.getPassword());  //�������
				LoginCheck flag = new LoginCheck(loginPeople,user,passwd);
				flag.connDatabase();  //�������ݿ�
				if(flag.prepared())
				{
					loginlab.setForeground(Color.GREEN);
					loginlab.setText("��¼�ɹ�!");
					if(loginPeople.equals("Student"))
					{
						//JOptionPane ��һ����������ṩ�˱�׼�ķ���������һ����׼�ĶԻ��򣬻���֪ͨ�û��Ķ�����
						JOptionPane.showMessageDialog(null,"ѧ����¼�ɹ�������","�����ʾ��Ϣ���",
								JOptionPane.INFORMATION_MESSAGE);
						//jframe.setVisible(false);
						jframe.dispose();   //���ٸõ�¼����
						new StudentInfo(user);
					}
					else if(loginPeople.equals("Teacher"))
					{
						JOptionPane.showMessageDialog(null,"��ʦ��¼�ɹ�������","�����ʾ��Ϣ���",
								JOptionPane.INFORMATION_MESSAGE);
						jframe.dispose();   //���ٸõ�¼����
						new TeacherMenu();
					}
				}
				else
				{
					loginlab.setForeground(Color.RED);
					loginlab.setText("��¼ʧ��!");
				}
			}
		});
		
		reset.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				usertext.setText("");
				passwdText.setText("");
				loginlab.setForeground(Color.BLUE);
				loginlab.setText("�����µ�¼!");
			}
		});
		
		jframe.setLayout(new GridLayout(4,1));
		
		//�����Ե������ӵ������
		userPanel.add(userlab);
		userPanel.add(usertext);
		passwdPanel.add(passwdlab);
		passwdPanel.add(passwdText);
		buttonPanel.add(loginTypeChan);
		buttonPanel.add(submit);
		buttonPanel.add(reset);
		
		//�������ӵ�������
		jframe.add(userPanel);
		jframe.add(passwdPanel);
		jframe.add(buttonPanel);
		jframe.add(labelPanel);
		
        //���,�߶�
		Dimension d = new Dimension(300,200);  //����һ��Dimension����,�������ô��ڴ�С��
		Point p = new Point(100,100);          //����һ��Point,�������ô��ڵĳ�ʼλ��
		jframe.setSize(d);  //���ô����С
		jframe.setLocation(p);
		jframe.setResizable(false);   //���ô��ڴ�С���ɱ�
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   //���ô��ڹرշ�ʽ
		jframe.setVisible(true);  //���ô���ɼ�
	}
	
	public static void main(String[] args) {
		
		Login login = new Login();
	}

}
