package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

import dialogWindows.ManageRentalDialog;
import enums.RegexP;
import managers.RentalManager;
import models.Admin;
import models.BookCopy;
import models.Employee;
import models.Librarian;
import models.Member;
import managers.AdminManager;
import managers.BookCopyManager;
import managers.BookManager;
import managers.LibrarianManager;
import managers.MemberManager;

public class CreateRentalController  {


	private RentalManager rentalModel;
	private ManageRentalDialog view;

	
	public CreateRentalController(ManageRentalDialog view) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException {
		this.view = view;
		this.rentalModel = RentalManager.getInstance();
		initRegistrationChecker();
		initCancelBtn();
	}
	
	public void initController() {
		this.view.setVisible(true);
	}
	
	private void initCancelBtn() {
		this.view.getCancelBtn().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				view.dispose();
				view.setVisible(false);
			}
		
		});
	}
	
	public void initRegistrationChecker() {
		this.view.getSubmitBtn().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				ArrayList<String> emptyCheckList = new ArrayList<String>();
				
				String id = view.getIdTextField().getText().trim();
				String rent = view.getRentDateField().getText();
				String due = view.getDueDateField().getText();
				
				String emp = view.getEmployeeBox().getSelectedItem().toString();
				
			
				String mem = view.getMemberBox().getSelectedItem().toString();
				
				int[] books = view.getBookBox().getSelectedIndices();
				String bookList = "";
				for (int bk: books) {
					try {
						bookList += BookCopyManager.getInstance().bookCopyStatusList(false).get(bk).getIdentification()+ ";";
					} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
							| IOException e1) {
			
						e1.printStackTrace();
					}
					
				}
				
				
				
				
				emptyCheckList.addAll(Arrays.asList(bookList, due, emp, id, "false", mem, rent));
				
				if (emptyCheckList.contains("")) {
					JOptionPane.showMessageDialog(null,"All fields are required.", "Error", JOptionPane.WARNING_MESSAGE);				
				} else {
					
					Pattern idPattern = Pattern.compile(RegexP.ID.pattern);

					
					if (!idPattern.matcher(id).find()){
						
						JOptionPane.showMessageDialog(null,"One or more type mismatches", "Error", JOptionPane.WARNING_MESSAGE);
					} else {
						StringBuilder sb = new StringBuilder();
						for (String s: emptyCheckList) {
							sb.append(s + "|");
						}
						try {
							if (rentalModel.createRental(sb.toString().split("\\|"))) {
								JOptionPane.showMessageDialog(null,"Congration, you done it", "Yay!", JOptionPane.INFORMATION_MESSAGE);

								view.dispose();
								view.setVisible(false);
								return;

							} else {
								JOptionPane.showMessageDialog(null,"Info collision", "Error", JOptionPane.WARNING_MESSAGE);

							}
						} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
								| IOException e1) {
							e1.printStackTrace();
						}
					}
				}
			}
			
		});
	}
}
