package com.xfhy.management;

import java.awt.Dimension;
import java.awt.FlowLayout;
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

public class FindStudent {

	private JFrame jframe;
	Object[] os = new Object[8];

	public FindStudent() {
		jframe = new JFrame("����ѧ������");

		/*-----���Ķ���-----*/
		JPanel findIdpanel = new JPanel(); // ����ѧ�����
		JPanel findBtnpanel = new JPanel(); // ����ѧ�����
		JPanel idpanel = new JPanel(); // ѧ�����
		JPanel namepanel = new JPanel(); // �������
		JPanel passwdpanel = new JPanel(); // �������
		JPanel sexpanel = new JPanel(); // �Ա����
		JPanel adrepanel = new JPanel(); // ��ַ���
		JPanel phonepanel = new JPanel(); // �绰���
		JPanel dormpanel = new JPanel(); // �������
		JPanel scorepanel = new JPanel(); // �ɼ����
		JButton find = new JButton("��ѯѧ��");

		/*-----��ǩ------*/
		JLabel findidJlabel = new JLabel("����ѧ������"); // ��ǩ
		JLabel idJlabel = new JLabel("ѧ��"); // ѧ�ű�ǩ
		JLabel nameJlabel = new JLabel("����"); // ������ǩ
		JLabel passwdJlabel = new JLabel("����"); // �����ǩ
		JLabel sexJlabel = new JLabel("�Ա�"); // �Ա��ǩ
		JLabel adreJlabel = new JLabel("��ַ"); // ��ַ��ǩ
		JLabel phoneJlabel = new JLabel("�绰"); // �绰��ǩ
		JLabel dormJlabel = new JLabel("����"); // �����ǩ
		JLabel scoreJlabel = new JLabel("�ɼ�"); // �ɼ���ǩ

		/*-------�ı���--------*/
		final JTextField findnameText = new JTextField(15);
		final JTextField idText = new JTextField(15);
		final JTextField nameText = new JTextField(15);
		final JTextField passwdText = new JTextField(15);
		final JTextField sexText = new JTextField(15);
		final JTextField adreText = new JTextField(15);
		final JTextField phoneText = new JTextField(15);
		final JTextField dormText = new JTextField(15);
		final JTextField scoreText = new JTextField(15);

		find.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				String sname = findnameText.getText();
				os = StudentIdSelect.selectName(sname);
				//�ж��û�������Ƿ��ǿ�ֵ,    ���ݿ��ѯ���ص��Ƿ��ǿ�ֵ
				if (!sname.equals("") && os[7] != null) {
					idText.setText((String) os[0]);
					nameText.setText((String) os[1]);
					passwdText.setText((String) os[2]);
					sexText.setText((String) os[3]);
					adreText.setText((String) os[4]);
					phoneText.setText((String) os[5]);
					dormText.setText((String) os[6]);
					scoreText.setText(os[7].toString());
				} else {
					JOptionPane.showMessageDialog(null, "�Ҳ�����ѧ��!!!",
							"�����ʾ��Ϣ���", JOptionPane.INFORMATION_MESSAGE); // ��ʾ��ѯָ���û���Ϣʱ�����쳣
				}
			}
		});

		// �����������
		findIdpanel.add(findidJlabel);
		findIdpanel.add(findnameText);
		findBtnpanel.add(find);
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

		// �����嵽����
		jframe.add(findIdpanel);
		jframe.add(findBtnpanel);
		jframe.add(idpanel);
		jframe.add(namepanel);
		jframe.add(passwdpanel);
		jframe.add(sexpanel);
		jframe.add(adrepanel);
		jframe.add(phonepanel);
		jframe.add(dormpanel);
		jframe.add(scorepanel);
		jframe.setLayout(new GridLayout(10, 1)); // ���ò��ַ�ʽ

		// ���,�߶�
		Dimension d = new Dimension(400, 500); // ����һ��Dimension����,�������ô��ڴ�С��
		Point p = new Point(100, 100); // ����һ��Point,�������ô��ڵĳ�ʼλ��
		jframe.setSize(d); // ���ô����С
		jframe.setLocation(p); // ��ʼλ��
		jframe.setResizable(false); // ���ô��ڴ�С���ɱ�
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ���ô��ڹرշ�ʽ
		jframe.setVisible(true); // ���ô���ɼ�
	}

	public static void main(String[] args) {
		FindStudent fs = new FindStudent();
	}

}
