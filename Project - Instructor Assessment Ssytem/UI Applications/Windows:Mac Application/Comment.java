import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class Comment extends JFrame {

	private JPanel contentPane;
	private JTable table;
	Object[] ob=new Object[4];
	

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public Comment(int pid) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));
		DefaultTableModel tm=new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Clarity", "Helpfulness", "Easiness", "Comments"
				}
			);
		table = new JTable(tm);
		contentPane.add(table);
		String q="select * from comment where pid="+pid+";";
		
		
		Connection con=null;
		Statement st=null;
		try{
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/rating","root","root");
			st=con.createStatement();
			
			
			ResultSet x=st.executeQuery(q);
			
			while(x.next()){
				ob[0]=x.getInt("clarity");
				ob[1]=x.getInt("helfulness");
				ob[2]=x.getInt("easiness");
				ob[3]=x.getString("comment");
				
				tm.addRow(ob);
				
			
			}
	}catch(SQLException e){
		
	}

	}
}
