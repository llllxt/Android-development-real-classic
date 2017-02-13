package com.xfhy.management;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * ���ѧ����Ϣ 2016��7��15��20:53:34
 * 
 * @author XFHY
 * 
 */
public class AddStudent {

	private JFrame jframe;

	public AddStudent() {
		jframe = new JFrame("���ѧ������");
		/*-----���Ķ���-----*/
		JPanel idpanel = new JPanel(); // ѧ�����
		JPanel namepanel = new JPanel(); // �������
		JPanel passwdpanel = new JPanel(); // �������
		JPanel sexpanel = new JPanel(); // �Ա����
		JPanel adrepanel = new JPanel(); // ��ַ���
		JPanel phonepanel = new JPanel(); // �绰���
		JPanel dormpanel = new JPanel(); // �������
		JPanel scorepanel = new JPanel(); // �ɼ����
		JPanel controlpanel = new JPanel(); // �������

		/*-----��ǩ------*/
		JLabel idJlabel = new JLabel("*ѧ��"); // ѧ�ű�ǩ
		JLabel nameJlabel = new JLabel("*����"); // ������ǩ
		JLabel passwdJlabel = new JLabel("*����"); // �����ǩ
		JLabel sexJlabel = new JLabel("�Ա�"); // �Ա��ǩ
		JLabel adreJlabel = new JLabel("��ַ"); // ��ַ��ǩ
		JLabel phoneJlabel = new JLabel("�绰"); // �绰��ǩ
		JLabel dormJlabel = new JLabel("����"); // �����ǩ
		JLabel scoreJlabel = new JLabel("�ɼ�"); // �ɼ���ǩ

		/*------��ť------*/
		JButton addSt = new JButton("���ѧ��");
		JButton reset = new JButton("����");
		JButton exit = new JButton("�˳�");

		/*-------�ı���--------*/
		final JTextField idText = new JTextField(15);
		final JTextField nameText = new JTextField(15);
		final JTextField passwdText = new JTextField(15);
		final JTextField sexText = new JTextField(15);
		final JTextField adreText = new JTextField(15);
		final JTextField phoneText = new JTextField(15);
		final JTextField dormText = new JTextField(15);
		final JTextField scoreText = new JTextField(15);

		// ���ѧ����Ϣ�����ݿⰴť ������
		addSt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String id = idText.getText();
				String sname = nameText.getText();
				String passwrd = passwdText.getText();
				String sex = sexText.getText();
				String haddress = adreText.getText();
				String phone = phoneText.getText();
				String dorm = dormText.getText();
				String result = scoreText.getText();
				if (!id.equals("") && !sname.equals("") && !passwrd.equals("")) {
					if (AddStudentInfo.addStuSQL(id, sname, passwrd, sex, haddress,
							phone, dorm, result)) {
						JOptionPane.showMessageDialog(null, "���ѧ����Ϣ�ɹ�~",
								"�����ʾ��Ϣ���", JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null, "���ѧ����Ϣʱ�����쳣",
								"�����ʾ��Ϣ���", JOptionPane.INFORMATION_MESSAGE); // ��ʾ�޸�ָ���û���Ϣʱ�����쳣
					}
				}
				else{
					JOptionPane.showMessageDialog(null, "����*�Ĳ���Ϊ��",
							"�����ʾ��Ϣ���", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});

		// ���õ�ǰ��������������Ϣ
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				idText.setText("");
				nameText.setText("");
				passwdText.setText("");
				sexText.setText("");
				adreText.setText("");
				phoneText.setText("");
				dormText.setText("");
				scoreText.setText("");
			}
		});

		exit.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				// ���ﷵ����ʦ�Ĺ���˵�����
				new TeacherMenu();
				jframe.dispose();
			}
		});

		// �����������
		idpanel.add(idJlabel);
		idpanel.add(idText);
		namepanel.add(nameJlabel);
		namepanel.add(nameText);
		passwdpanel.add(passwdJlabel);
		passwdpanel.add(passwdText);
		sexpanel.add(sexJlabel);
		sexpanel.add(sexText);
		adrepanel.add(adreJlabel);
		adrepanel.add(adreText);
		phonepanel.add(phoneJlabel);
		phonepanel.add(phoneText);
		dormpanel.add(dormJlabel);
		dormpanel.add(dormText);
		scorepanel.add(scoreJlabel);
		scorepanel.add(scoreText);
		controlpanel.add(addSt);
		controlpanel.add(reset);
		controlpanel.add(exit);

		// �����嵽����
		jframe.add(idpanel);
		jframe.add(namepanel);
		jframe.add(passwdpanel);
		jframe.add(sexpanel);
		jframe.add(adrepanel);
		jframe.add(phonepanel);
		jframe.add(dormpanel);
		jframe.add(scorepanel);
		jframe.add(controlpanel);
		jframe.setLayout(new GridLayout(9, 1)); // ���ò��ַ�ʽ

		// ���,�߶�
		Dimension d = new Dimension(400, 300); // ����һ��Dimension����,�������ô��ڴ�С��
		Point p = new Point(100, 100); // ����һ��Point,�������ô��ڵĳ�ʼλ��
		jframe.setSize(d); // ���ô����С
		jframe.setLocation(p); // ��ʼλ��
		jframe.setResizable(false); // ���ô��ڴ�С���ɱ�
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ���ô��ڹرշ�ʽ
		jframe.setVisible(true); // ���ô���ɼ�
	}

	public static void main(String[] args) {
		AddStudent addStudent = new AddStudent();
	}

}
