package ex3f;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class EmpoyeeForm extends JFrame {

	private JPanel contentPane;
	private JTextField empIdTextField;
	private JTextField empNameTextField;
	private JTextField positionTextField;
	private JList employeeList;
	private DefaultListModel employeeListModel;
	private JComboBox deptComboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmpoyeeForm frame = new EmpoyeeForm();
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
	public EmpoyeeForm() {
		setTitle("Exercise 3F: Overloaded Constructors");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 605, 322);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 548, 120);
		contentPane.add(scrollPane);
		
		//Create list model object. When we want to add items to the JList we add them to the model
		// that will, in turn, add them to the model since we are using the model as a parameter in the JList.
		employeeListModel = new DefaultListModel();// added manually
		
		JLabel lblEmployeeId = new JLabel("Employee Id:");
		lblEmployeeId.setBounds(20, 142, 83, 14);
		contentPane.add(lblEmployeeId);
		
		empIdTextField = new JTextField();
		empIdTextField.setText("101");
		lblEmployeeId.setLabelFor(empIdTextField);
		empIdTextField.setBounds(153, 142, 100, 20);
		contentPane.add(empIdTextField);
		empIdTextField.setColumns(10);
		
		JLabel lblEmployeeName = new JLabel("Employee Name:");
		lblEmployeeName.setBounds(20, 167, 89, 17);
		contentPane.add(lblEmployeeName);
		
		empNameTextField = new JTextField();
		empNameTextField.setText("Jason R. Johnson");
		lblEmployeeName.setLabelFor(empNameTextField);
		empNameTextField.setBounds(153, 165, 133, 20);
		contentPane.add(empNameTextField);
		empNameTextField.setColumns(10);
		
		JLabel lblDepartment = new JLabel("Department:");
		lblDepartment.setBounds(20, 195, 83, 14);
		contentPane.add(lblDepartment);
		
		deptComboBox = new JComboBox();
		deptComboBox.setModel(new DefaultComboBoxModel(new String[] {"Business Office", "Human Resources", "Maintenance", "Manufacturing", "Shipping"}));
		lblDepartment.setLabelFor(deptComboBox);
		deptComboBox.setBounds(153, 192, 150, 20);
		contentPane.add(deptComboBox);
		
		JLabel lblPosition = new JLabel("Position:");
		lblPosition.setBounds(20, 220, 83, 14);
		contentPane.add(lblPosition);
		
		positionTextField = new JTextField();
		positionTextField.setText("Software Engineer");
		lblPosition.setLabelFor(positionTextField);
		positionTextField.setBounds(153, 217, 133, 20);
		contentPane.add(positionTextField);
		positionTextField.setColumns(10);
		
		JButton noArgConstructorButton = new JButton("No Arg");
		noArgConstructorButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_noArgConstructorButton_actionPerformed(arg0);
			}
		});
		noArgConstructorButton.setBounds(20, 248, 89, 23);
		contentPane.add(noArgConstructorButton);
		
		JButton twoArgConstructorButton = new JButton("2 Arg");
		twoArgConstructorButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_twoArgConstructorButton_actionPerformed(e);
			}
		});
		twoArgConstructorButton.setBounds(247, 248, 89, 23);
		contentPane.add(twoArgConstructorButton);
		
		JButton fourArgConstructorButton = new JButton("4 Arg");
		fourArgConstructorButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_fourArgConstructorButton_actionPerformed(e);
			}
		});
		fourArgConstructorButton.setBounds(469, 248, 89, 23);
		contentPane.add(fourArgConstructorButton);
		//employeeList = new JList(); 
		employeeList = new JList(employeeListModel);
		employeeList.setBounds(10, 12, 548, 119);
		contentPane.add(employeeList);
	}
	protected void do_noArgConstructorButton_actionPerformed(ActionEvent arg0) {
		//Create employee object, and call 0 Arg Constructor by not passing any arguments
		Employee emp = new Employee();
		//Add employee object to employeeListModel
		employeeListModel.addElement(emp);
	}
	
	protected void do_twoArgConstructorButton_actionPerformed(ActionEvent e) {
		//Get String from empNameTextField.
		String name = empNameTextField.getText();
		//Get int from empIDTextField, convert to int
		int id = Integer.parseInt(empIdTextField.getText());
		//Create employee object, and call 2 Arg Constructor by passing two arguments
		Employee emp = new Employee(name, id);
		//Add employee object to employeeListModel
		employeeListModel.addElement(emp);
	}
	
	protected void do_fourArgConstructorButton_actionPerformed(ActionEvent e) {
		//Get String from form empNameTextField.
		String name = empNameTextField.getText();
		//Get int from empIDTextField, convert to int
		int id = Integer.parseInt(empIdTextField.getText());
		//Get String from Combo box
		String dept = (String) deptComboBox.getSelectedItem();	
		//Get position from textField
		String position = positionTextField.getText();
		//Create employee object, and call 4 Arg Constructor by passing four arguments
		Employee emp = new Employee(name, id, dept, position);
		//Add employee object to employeeListModel
		employeeListModel.addElement(emp);
	}
}
