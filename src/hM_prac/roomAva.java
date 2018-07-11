package hM_prac;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.DefaultComboBoxModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Arrays;

public class roomAva extends JDialog {

	private final JPanel contentPanel = new JPanel();
	static roomAva dialog;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			dialog = new roomAva();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

private static Icon resizeIcon(ImageIcon icon, int resizedWidth, int resizedHeight) {
    Image img = icon.getImage();  
    Image resizedImage = img.getScaledInstance(resizedWidth, resizedHeight,  java.awt.Image.SCALE_SMOOTH);  
    return new ImageIcon(resizedImage);
}
	/**
	 * Create the dialog.
	 */
	public roomAva(){
		this(new int[5]);
		System.out.println("hh");
	}
	
	public roomAva(int[] a) {
		System.out.println("gg");
		String[] s=Arrays.toString(a).split("[\\[\\]]")[1].split(", "); 
		setBounds(100, 100, 311, 321);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JComboBox comboBox = new JComboBox();
			comboBox.setModel(new DefaultComboBoxModel(s));
			comboBox.setBounds(57, 83, 181, 26);
			contentPanel.add(comboBox);
		}
		{
			JLabel lblRoomsAvailabel = new JLabel("Rooms Available:");
			lblRoomsAvailabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblRoomsAvailabel.setBounds(80, 12, 129, 34);
			contentPanel.add(lblRoomsAvailabel);
		}
		{
			JLabel label = new JLabel("");
			label.setBounds(0, 0, 295, 281);
			label.setIcon(new ImageIcon(roomAva.class.getResource("/images/Double_Room-512.jpg")));
			label.setIcon(resizeIcon(new ImageIcon(roomAva.class.getResource("/images/Double_Room-512.jpg")),
			label.getWidth() - label.getInsets().left, label.getHeight() - label.getInsets().left));
			
			contentPanel.add(label);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//contentPanel.disable();
						//dialog.setVisible(false);
						setVisible(false);
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//contentPanel.disable();
						//dialog.setVisible(false);
						new booking().setVisible(true);
						
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
