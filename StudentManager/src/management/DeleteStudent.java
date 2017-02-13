package com.xfhy.management;

import java.awt.Dimension;
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

/**
 * ɾ��ѧ��(����ѧ��ɾ��) 2016��7��16��13:09:10
 * 
 * @author XFHY
 * 
 */
public class DeleteStudent {
	private String id;
	private JFrame jframe;
	private JLabel idJlabel;
	final JTextField idText = new JTextField(15);

	public DeleteStudent() {
		jframe = new JFrame("ɾ��ѧ������");
		idJlabel = new JLabel("ѧ��:");

		JPanel idpanel = new JPanel(); // ѧ�����
		JPanel controlpanel = new JPanel(); // �������

		// ���ѧ�ź�ѧ�������idpanel���
		idpanel.add(idJlabel);
		idpanel.add(idText);

		JButton delete = new JButton("ɾ��ѧ��");
		JButton reset = new JButton("����");
		JButton exit = new JButton("�˳�");

		// ɾ��ѧ��
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				id = idText.getText();
				if (!id.equals("")) {
					if (AddStudentInfo.deleteStuSQL(id)) {
						JOptionPane.showMessageDialog(null, "ɾ���ɹ�������",
								"�����ʾ��Ϣ���", JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null, "ɾ��ʧ�ܣ�����",
								"�����ʾ��Ϣ���", JOptionPane.INFORMATION_MESSAGE);
					}
				}
				else{
					JOptionPane.showMessageDialog(null, "������ϢΪ�գ�����",
							"�����ʾ��Ϣ���", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});

		// ���õ�ǰ��������������Ϣ
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				idText.setText("");
			}
		});

		exit.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				// ���ﷵ����ʦ�Ĺ���˵�����
				new TeacherMenu();
				jframe.dispose();
			}
		});

		controlpanel.add(delete);
		controlpanel.add(reset);
		controlpanel.add(exit);

		jframe.add(idpanel);
		jframe.add(controlpanel);
		jframe.setLayout(new GridLayout(2, 1));

		// ���,�߶�
		Dimension d = new Dimension(300, 200); // ����һ��Dimension����,�������ô��ڴ�С��
		Point p = new Point(100, 100); // ����һ��Point,�������ô��ڵĳ�ʼλ��
		jframe.setSize(d); // ���ô����С
		jframe.setLocation(p); // ��ʼλ��
		jframe.setResizable(false); // ���ô��ڴ�С���ɱ�
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ���ô��ڹرշ�ʽ
		jframe.setVisible(true); // ���ô���ɼ�
	}

	public static void main(String[] args) {
		DeleteStudent ds = new DeleteStudent();
	}

}
