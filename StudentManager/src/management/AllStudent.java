package com.xfhy.management;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AllStudent {

	private JFrame jframe;
	private List<Object> list;
	Object[] os = new Object[8];
	int countpeople = 0;
	int current = 0;

	public AllStudent() {
		list = AddStudentInfo.selectStuSQL();
		countpeople = list.size(); // ������
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
		JPanel countpanel = new JPanel(); // ������
		JPanel controlpanel = new JPanel(); // �������

		/*-----��ǩ------*/
		JLabel idJlabel = new JLabel("ѧ  ��"); // ѧ�ű�ǩ
		JLabel nameJlabel = new JLabel("��  ��"); // ������ǩ
		JLabel passwdJlabel = new JLabel("��  ��"); // �����ǩ
		JLabel sexJlabel = new JLabel("��  ��"); // �Ա��ǩ
		JLabel adreJlabel = new JLabel("��  ַ"); // ��ַ��ǩ
		JLabel phoneJlabel = new JLabel("��  ��"); // �绰��ǩ
		JLabel dormJlabel = new JLabel("��  ��"); // �����ǩ
		JLabel scoreJlabel = new JLabel("��  ��"); // �ɼ���ǩ
		JLabel countJlabel = new JLabel("������");

		/*------��ť------*/
		JButton firstSt = new JButton("��һ��");
		JButton upSt = new JButton("��һ��");
		JButton nextSt = new JButton("��һ��");
		JButton lastSt = new JButton("���һ��");

		/*-------�ı���--------*/
		final JTextField idText = new JTextField(15);
		final JTextField nameText = new JTextField(15);
		final JTextField passwdText = new JTextField(15);
		final JTextField sexText = new JTextField(15);
		final JTextField adreText = new JTextField(15);
		final JTextField phoneText = new JTextField(15);
		final JTextField dormText = new JTextField(15);
		final JTextField scoreText = new JTextField(15);
		final JTextField countText = new JTextField(15);

		// ���ʱ,��ʾ��һ��ѧ������Ϣ

		os = (Object[]) list.get(0);
		idText.setText(os[0].toString());
		nameText.setText(os[1].toString());
		passwdText.setText(os[2].toString());
		sexText.setText(os[3].toString());
		adreText.setText(os[4].toString());
		phoneText.setText(os[5].toString());
		dormText.setText(os[6].toString());
		scoreText.setText(os[7].toString());
		countText.setText(list.size() + "");

		firstSt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				os = (Object[]) list.get(0);
				idText.setText(os[0].toString());
				nameText.setText(os[1].toString());
				passwdText.setText(os[2].toString());
				sexText.setText(os[3].toString());
				adreText.setText(os[4].toString());
				phoneText.setText(os[5].toString());
				dormText.setText(os[6].toString());
				scoreText.setText(os[7].toString());
				current = 0;
			}
		});

		upSt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// �ѵ����һ��
				if (current == 0) {
					JOptionPane.showMessageDialog(null, "�Ѿ��ǵ�һ����", "�����ʾ��Ϣ���",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					os = (Object[]) list.get(current - 1);
					idText.setText(os[0].toString());
					nameText.setText(os[1].toString());
					passwdText.setText(os[2].toString());
					sexText.setText(os[3].toString());
					adreText.setText(os[4].toString());
					phoneText.setText(os[5].toString());
					dormText.setText(os[6].toString());
					scoreText.setText(os[7].toString());
					current--;
				}
			}
		});

		nextSt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// �ѵ����һ��
				if (current == (list.size() - 1)) {
					JOptionPane.showMessageDialog(null, "�Ѿ������һ����", "�����ʾ��Ϣ���",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					os = (Object[]) list.get(current + 1);
					idText.setText(os[0].toString());
					nameText.setText(os[1].toString());
					passwdText.setText(os[2].toString());
					sexText.setText(os[3].toString());
					adreText.setText(os[4].toString());
					phoneText.setText(os[5].toString());
					dormText.setText(os[6].toString());
					scoreText.setText(os[7].toString());
					current++;
				}
			}
		});

		lastSt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				os = (Object[]) list.get(countpeople - 1);
				idText.setText(os[0].toString());
				nameText.setText(os[1].toString());
				passwdText.setText(os[2].toString());
				sexText.setText(os[3].toString());
				adreText.setText(os[4].toString());
				phoneText.setText(os[5].toString());
				dormText.setText(os[6].toString());
				scoreText.setText(os[7].toString());
				current = countpeople - 1;
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
		countpanel.add(countJlabel);
		countpanel.add(countText);
		controlpanel.add(firstSt);
		controlpanel.add(upSt);
		controlpanel.add(nextSt);
		controlpanel.add(lastSt);

		// �����嵽����
		jframe.add(idpanel);
		jframe.add(namepanel);
		jframe.add(passwdpanel);
		jframe.add(sexpanel);
		jframe.add(adrepanel);
		jframe.add(phonepanel);
		jframe.add(dormpanel);
		jframe.add(scorepanel);
		jframe.add(countpanel);
		jframe.add(controlpanel);
		jframe.setLayout(new GridLayout(10, 1)); // ���ò��ַ�ʽ

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
		AllStudent as = new AllStudent();
	}

}
