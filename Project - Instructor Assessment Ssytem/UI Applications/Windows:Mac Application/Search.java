import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JList;
import java.awt.List;
import javax.swing.JDesktopPane;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.GridLayout;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.TextArea;
import javax.swing.SwingConstants;
import java.awt.Dimension;


public class Search extends JFrame {

	private JPanel contentPane,search;
	private JTextField textField;
	String name,select;
	JComboBox c1,c2,c3;
	JLabel lb,lbn,lbd,lbo,lbh,lbe,lbc,lbo2;
	List lt;
	private TextArea textArea;
	Connection con=null;
	Statement st=null;
	int id=0,n=0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Search frame = new Search();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Search() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 792, 565);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 5, 0));
		
		
		List list = new List();
		list.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				select=lt.getSelectedItem();
				
				String q="select * from prof where name like '"+select+"';";
				try{
					
					try {
						Class.forName("com.mysql.jdbc.Driver");
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
					con=DriverManager.getConnection("jdbc:mysql://localhost:3306/rating","root","root");
					st=con.createStatement();
					
					
					ResultSet x=st.executeQuery(q);
					
					while(x.next()){
						
						id=x.getInt("pid");
						lbn.setText(x.getString("name"));
						lbd.setText(x.getString("dept"));
						lbo.setText(x.getString("overall"));
						lbe.setText(x.getString("easiness"));
						lbh.setText(x.getString("helfulness"));
						lbc.setText(x.getString("clarity"));
						n=x.getInt("no");
						
					
					}
					
					con.close();
			
			}catch(SQLException e){
				System.out.println(e);
			}
				
			}
		});
		lt=list;
		list.setMultipleSelections(false);
		contentPane.add(list);
		
		
		
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				name=textField.getText();
				con=null;
				st = null;
				
				try{
				
					try {
						Class.forName("com.mysql.jdbc.Driver");
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
					con=DriverManager.getConnection("jdbc:mysql://localhost:3306/rating","root","root");
				
				String query="select * from prof where name like '%" +name+"%';";
				
				
					st=con.createStatement();
				
				
					ResultSet x=st.executeQuery(query);
					
					while(x.next()){
						String a=x.getString("name");
						
						lt.addItem(a);
						
					
					}
					
					con.close();
			
			}catch(SQLException e){
				System.out.println(e);
			}
			}
		});
		
		JPanel panel = new JPanel();
		search=panel;
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 1, 5, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 1, 5, 0));
		
		JLabel lblEnterProfessorsName = new JLabel("Enter Professor's Name");
		panel_1.add(lblEnterProfessorsName);
		
		textField = new JTextField();
		panel_1.add(textField);
		textField.setColumns(10);
		
		
		panel_1.add(btnNewButton);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(new GridLayout(1, 0, 5, 0));
		
		JPanel panel_4 = new JPanel();
		panel_2.add(panel_4);
		panel_4.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblName = new JLabel("Name");
		panel_4.add(lblName);
		
		JLabel lblname = new JLabel("(name)");
		panel_4.add(lblname);
		lbn=lblname;
		
		JLabel lblDepartment = new JLabel("Department");
		panel_4.add(lblDepartment);
		
		JLabel lbldept = new JLabel("(dept.)");
		panel_4.add(lbldept);
		lbd=lbldept;
		
		JLabel lblOverall_1 = new JLabel("OverAll");
		panel_4.add(lblOverall_1);
		
		JLabel label_4 = new JLabel("0.0");
		panel_4.add(label_4);
		lbo=label_4;
		
		JPanel panel_5 = new JPanel();
		panel_2.add(panel_5);
		panel_5.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel label_1 = new JLabel("Helpfulness");
		panel_5.add(label_1);
		
		JLabel label_5 = new JLabel("0.0");
		panel_5.add(label_5);
		lbh=label_5;
		
		JLabel label_2 = new JLabel("Clarity");
		panel_5.add(label_2);
		
		JLabel label_6 = new JLabel("0.0");
		panel_5.add(label_6);
		lbc=label_6;
		
		JLabel label_3 = new JLabel("Easiness");
		panel_5.add(label_3);
		
		JLabel label_7 = new JLabel("0.0");
		panel_5.add(label_7);
		lbe=label_7;
		
		JLabel lblMore = new JLabel("More");
		panel_5.add(lblMore);
		
		JButton btnMore = new JButton("Click Here");
		btnMore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Comment frame = new Comment(id);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		panel_5.add(btnMore);
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		panel_3.setLayout(new GridLayout(1, 0, 5, 0));
		
		JPanel panel_6 = new JPanel();
		panel_3.add(panel_6);
		panel_6.setLayout(new GridLayout(0, 2, 5, 0));
		
		JLabel lblHelpfulness = new JLabel("Helpfulness");
		panel_6.add(lblHelpfulness);
		
		JComboBox comboBox = new JComboBox();
		panel_6.add(comboBox);
		comboBox.addItem("1");
		comboBox.addItem("2");
		comboBox.addItem("3");
		comboBox.addItem("4");
		comboBox.addItem("5");
		c1=comboBox;
		
		JLabel lblClarity = new JLabel("Clarity");
		panel_6.add(lblClarity);
		
		JComboBox comboBox_1 = new JComboBox();
		panel_6.add(comboBox_1);
		comboBox_1.addItem("1");
		comboBox_1.addItem("2");
		comboBox_1.addItem("3");
		comboBox_1.addItem("4");
		comboBox_1.addItem("5");
		c2=comboBox_1;
		
		JLabel lblEasiness = new JLabel("Easiness");
		panel_6.add(lblEasiness);
		
		JComboBox comboBox_2 = new JComboBox();
		panel_6.add(comboBox_2);
		comboBox_2.addItem("1");
		comboBox_2.addItem("2");
		comboBox_2.addItem("3");
		comboBox_2.addItem("4");
		comboBox_2.addItem("5");
		c3=comboBox_2;
		
		JLabel lblOverall = new JLabel("OverAll");
		panel_6.add(lblOverall);
		
		JLabel label = new JLabel("0.0");
		panel_6.add(label);
		lbo2=label;
		
		JPanel panel_7 = new JPanel();
		panel_3.add(panel_7);
		panel_7.setLayout(new GridLayout(0, 1, 5, 0));
		
		JLabel lblComment = new JLabel("Comment(No inappropriate words are allowed)");
		panel_7.add(lblComment);
		
		textArea = new TextArea();
		panel_7.add(textArea);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			 int cid=0;	
			 int h=Integer.parseInt(c1.getSelectedItem().toString());
			 int c=Integer.parseInt(c2.getSelectedItem().toString());
			 int e=Integer.parseInt(c3.getSelectedItem().toString());
			 float o=(float)(h+c+e)/3;
			 lbo2.setText(Float.toString(o));
			 String comment=textArea.getText();
			 String q1="select cid from comment";
			 
				try{
					
					try {
						Class.forName("com.mysql.jdbc.Driver");
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
					con=DriverManager.getConnection("jdbc:mysql://localhost:3306/rating","root","root");
					st=con.createStatement();
					
					
					ResultSet x=st.executeQuery(q1);
					
					while(x.next()){
						
						
						cid=x.getInt("cid");
						
						
					
					}
					cid++;
					String q="insert into comment values("+id+","+cid+",'"+comment+"',"+h+","+c+","+e+");";
					st.executeUpdate(q);
					float h1=((n*Float.parseFloat(lbh.getText()))+h)/(n+1);
					float e1=((n*Float.parseFloat(lbe.getText()))+e)/(n+1);
					float c1=((n*Float.parseFloat(lbc.getText()))+c)/(n+1);
					o=(h1+e1+c1)/3;
					n++;
					q="update prof set overall="+o+",easiness="+e1+",helfulness="+h1+",clarity="+c1+",no="+n+" where pid="+id+";";
					st.executeUpdate(q);
					
					con.close();
			
			}catch(SQLException e1){
				System.out.println(e1);
			}
			 
			}
		});
		btnSubmit.setSize(new Dimension(100, 50));
		panel_7.add(btnSubmit);
	}
}
