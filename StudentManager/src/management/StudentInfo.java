package com.xfhy.management;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.xfhy.sqlpackage.DatabaseConnect;

/**
 * ѧ����¼�ɹ�����,��ʾѧ����ȫ����Ϣ,���Ա༭(ѧ��,����,�ɼ����ɱ��༭)
 * 
 * @author XFHY
 * 
 */
public class StudentInfo {

	private String id = "";

	public StudentInfo() {
	}

	public StudentInfo(String id) {
		this.id = id;
		final Frame jframe = new JFrame("�ҵ�ȫ����Ϣ"); // ����һ����ʼʱ,���ɼ��Ĵ���,�����ô��ڱ���

		JPanel idpanel = new JPanel(); // ѧ�����
		JPanel namepanel = new JPanel(); // �������
		JPanel passwdpanel = new JPanel(); // �������
		JPanel sexpanel = new JPanel(); // �Ա����
		JPanel adrepanel = new JPanel(); // ��ַ���
		JPanel phonepanel = new JPanel(); // �绰���
		JPanel dormpanel = new JPanel(); // �������
		JPanel scorepanel = new JPanel(); // �ɼ����
		JPanel controlpanel = new JPanel(); // �������

		JLabel idJlabel = new JLabel("ѧ��"); // ѧ�ű�ǩ
		JLabel nameJlabel = new JLabel("����"); // ������ǩ
		JLabel passwdJlabel = new JLabel("����"); // �����ǩ
		JLabel sexJlabel = new JLabel("�Ա�"); // �Ա��ǩ
		JLabel adreJlabel = new JLabel("��ַ"); // ��ַ��ǩ
		JLabel phoneJlabel = new JLabel("�绰"); // �绰��ǩ
		JLabel dormJlabel = new JLabel("����"); // �����ǩ
		JLabel scoreJlabel = new JLabel("�ɼ�"); // �ɼ���ǩ
		JButton ok = new JButton("ȷ��");
		JButton edit = new JButton("�༭");
		JButton exit = new JButton("�˳�");

		// �ı���
		JTextField idText = new JTextField(15);
		final JTextField nameText = new JTextField(15);
		final JTextField passwdText = new JTextField(15);
		final JTextField sexText = new JTextField(15);
		final JTextField adreText = new JTextField(15);
		final JTextField phoneText = new JTextField(15);
		final JTextField dormText = new JTextField(15);
		final JTextField scoreText = new JTextField(15);

		// �ı����������,ͨ��StudentIdSelect���selectID()������ѯ��һ��ѧ��������,���浽Object[]������,��
		// һ��һ���ö������������
		Object[] os = StudentIdSelect.selectID(id);
		idText.setText((String) os[0]);
		nameText.setText((String) os[1]);
		passwdText.setText((String) os[2]);
		sexText.setText((String) os[3]);
		adreText.setText((String) os[4]);
		phoneText.setText((String) os[5]);
		dormText.setText((String) os[6]);
		scoreText.setText(os[7].toString());
		
		idText.setEditable(false);
		nameText.setEditable(false);
		passwdText.setEditable(false);
		sexText.setEditable(false);
		adreText.setEditable(false);
		phoneText.setEditable(false);
		dormText.setEditable(false);
		scoreText.setEditable(false);
		
		final String idd = this.id;
		

		ok.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				/*----��ȡ�ı����ڵ�����-----*/
				String name = nameText.getText();
				String passwd = passwdText.getText();
				String sex = sexText.getText();
				String adre = adreText.getText();
				String phone = phoneText.getText();
				String dorm = dormText.getText();
				if(AddStudentInfo.updateSQL(idd, name, passwd, sex, adre, phone, dorm))
				{
					JOptionPane.showMessageDialog(null, "�޸ĳɹ�!", "�����ʾ��Ϣ���",
							JOptionPane.INFORMATION_MESSAGE);		
				}
				else
				{
					JOptionPane.showMessageDialog(null, "�޸�ʧ��!", "�����ʾ��Ϣ���",
							JOptionPane.INFORMATION_MESSAGE);	
				}
				
			}
		});

		//ctrl+shift+f :�Զ������ʽ   �༭��ť
		edit.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				nameText.setEditable(true);
				passwdText.setEditable(true);
				sexText.setEditable(true);
				adreText.setEditable(true);
				phoneText.setEditable(true);
				dormText.setEditable(true);
			}
		});
		
		//�˳���ť
		exit.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				new Login();
				//System.exit(0);
				//jframe.setVisible(false);
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
		controlpanel.add(ok);
		controlpanel.add(edit);
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
		jframe.setLocation(p);

		jframe.setResizable(false); // ���ô��ڴ�С���ɱ�

		((JFrame) jframe).setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ���ô��ڹرշ�ʽ

		jframe.setVisible(true); // ���ô���ɼ�
	}

	public static void main(String[] args) {
		//StudentInfo si = new StudentInfo("1");
	}

}
