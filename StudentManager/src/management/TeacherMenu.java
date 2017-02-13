package com.xfhy.management;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Label;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class TeacherMenu {
	JFrame jframe = new JFrame("��ʦ�������");
	JLabel scoreLabel = new JLabel("",JLabel.CENTER);

	public TeacherMenu() {
		
		JMenuBar mb = new JMenuBar();  //�˵���    �˵���ֻ��һ��
		
		JMenu stuMenu = new JMenu("ѧ��");//�˵����ϵĲ˵�,���ǵ�һ����Ҫ��ʾ�Ķ���
		JMenu scoreMenu = new JMenu("�ɼ�");
		
		JMenuItem addItem = new JMenuItem("���ѧ��");  //�Ӳ˵�
		JMenuItem deleteItem = new JMenuItem("ɾ��ѧ��");
		JMenu findItem = new JMenu("��ѯѧ��");   //�����Ҫ������Ӳ˵��Ĳ˵���,����Ū��JMenu���ͼ���
		JMenuItem findNameItem = new JMenuItem("������ѯ");   //�����Ӳ˵���Ĳ˵���
		JMenuItem findAllItem = new JMenuItem("ȫ����ѯ");
		JMenuItem aveScore = new JMenuItem("ƽ���ɼ�");
		
		
		//���ѧ��    �˵����,�����¼�
		addItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new AddStudent();
				//jframe.setVisible(false);
				jframe.dispose();
			}
		});
		
		//ɾ��ѧ��
		deleteItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new DeleteStudent();
				jframe.dispose();
			}
		});
		
		//��������ѧ��
		findNameItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new FindStudent();
				jframe.dispose();
			}
		});
		
		//��ѯȫ��ѧ��
		findAllItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new AllStudent();
				jframe.dispose();
			}
		});
		
		//��ʾ�ɼ�
		aveScore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				double score = AddStudentInfo.aveScoreStu();  //��ƽ���ɼ�
				Font font = new Font("����",Font.BOLD,35);
				scoreLabel.setFont(font);
				scoreLabel.setText("ƽ���ɼ���"+Double.toString(score));
			}
		});
		
		stuMenu.add(addItem);      //����Ӳ˵�
		stuMenu.addSeparator();   //��Ӻ���
		stuMenu.add(deleteItem);
		stuMenu.addSeparator();
		stuMenu.add(findItem);
		scoreMenu.add(aveScore);
		
		findItem.add(findNameItem);  //�Ӳ˵���Ĳ˵���
		findItem.addSeparator();
		findItem.add(findAllItem);
		
		mb.add(stuMenu);  //�˵����ϵ����˵�
		mb.add(scoreMenu);
		jframe.setJMenuBar(mb);   //���ò˵���
		jframe.add(scoreLabel);
		
		// ���,�߶�
		Dimension d = new Dimension(400, 300); // ����һ��Dimension����,�������ô��ڴ�С��
		Point p = new Point(100, 100); // ����һ��Point,�������ô��ڵĳ�ʼλ��
		jframe.setSize(d); // ���ô����С
		jframe.setLocation(p);
		jframe.setResizable(false); // ���ô��ڴ�С���ɱ�
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ���ô��ڹرշ�ʽ
		jframe.setVisible(true); // ���ô���ɼ�
	}

	public static void main(String[] args) {
		TeacherMenu tm = new TeacherMenu();
	}

}
