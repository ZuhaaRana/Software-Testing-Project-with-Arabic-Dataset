package pl;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import dal.HadithDAO;
import dal.IDAL;
import to.HadithTO;

public class Delete extends JFrame{
	
	private JPanel contentPane;
	private JTextField NUM;
	private JTextField NAME;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try 
				{
					Delete frame = new Delete();
					frame.setVisible(true);
				} catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

public Delete() throws SQLException, ClassNotFoundException 
{
	IDAL iDAL = new HadithDAO();
	
	setTitle("Delete Hadith");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 571, 580);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	JLabel lblNewLabel_1 = new JLabel("Delete Hadith");
	lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
	lblNewLabel_1.setBounds(218, 46, 166, 29);
	contentPane.add(lblNewLabel_1);
	
	JLabel search_by_number = new JLabel("Enter Hadith number");
	search_by_number.setBounds(43, 117, 120, 29);
	contentPane.add(search_by_number);
	
	NUM = new JTextField();
	NUM.setBounds(173, 117, 322, 29);
	contentPane.add(NUM);
	NUM.setColumns(10);
	
	JLabel search_by_name = new JLabel("Enter Book name");
	search_by_name.setBounds(43, 203, 120, 29);
	contentPane.add(search_by_name);
	
	NAME = new JTextField();
	NAME.setBounds(173, 203, 322, 29);
	contentPane.add(NAME);
	NAME.setColumns(10);
	
	
	JButton btnNewButton = new JButton("Delete Hadith");

	btnNewButton.addActionListener(new ActionListener() 
	{
		public void actionPerformed(ActionEvent e) 
		{
			String num = NUM.getText();
			String book_name = NAME.getText();
			iDAL.DeleteHadith(num, book_name);
			if(iDAL.DeleteHadith(num, book_name))
			{	
				JOptionPane.showMessageDialog(null,"Hadith Deleted");
			}
			else
			{
				JOptionPane.showMessageDialog(null,"Error!");
			} 
		}
	});
	btnNewButton.setBounds(218, 281, 120, 29);
	contentPane.add(btnNewButton);
}
}