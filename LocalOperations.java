package WindowBuilder.views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileFilter;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JProgressBar;
import javax.swing.UIManager;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class LocalOperations extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JButton btnBrowse;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		try {
			LocalOperations dialog = new LocalOperations();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public LocalOperations() {
		setTitle("Local Operations");
		setBounds(100, 100, 450, 275);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);

		JLabel lblRaster = new JLabel("Raster 1:");
		JLabel lblRaster_1 = new JLabel("Raster 2:");

		textField = new JTextField();
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setColumns(10);

		final JFileChooser fileChooser = new JFileChooser();
		fileChooser.addChoosableFileFilter(new FileFilter() {
			public String getDescription() {
				return "ASCII(.txt)";
			}
			
			public boolean accept(File f) {
				if (f.isDirectory()) {
					return true;
				} else {
					return f.getName().toLowerCase().endsWith(".txt");
				} 
		}
		});
		fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
		fileChooser.setMultiSelectionEnabled(true);	
		
		JButton btnBrowse = new JButton("Browse");
		btnBrowse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = fileChooser.showOpenDialog(LocalOperations.this);
				if (result == JFileChooser.APPROVE_OPTION) {
					File selectedFile = fileChooser.getSelectedFile();
					System.out.print("Selected file: "+ selectedFile.getAbsolutePath());
					
					textField.setText(selectedFile.getAbsoluteFile().toString());
				}
			}
		});
		
		btnBrowse = new JButton("Browse");
		JButton button = new JButton("Browse");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = fileChooser.showOpenDialog(LocalOperations.this);
				if (result == JFileChooser.APPROVE_OPTION) {
					File selectedFile = fileChooser.getSelectedFile();
					System.out.print("Selected file: "+ selectedFile.getAbsolutePath());
					Layer layer2 = new Layer("layer",selectedFile.getAbsolutePath());
					textField_1.setText(selectedFile.getAbsoluteFile().toString());
				}
			}
			});

		JLabel lblLocalOperations = new JLabel("Local Operations: ");
		lblLocalOperations.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Local Rating", "Local Maximum", "Local Minimum",
				"Local Sum", "Local Mean", "Local Difference", "Local Product", "Local Ratio", "Local Sine",
				"Local Cosine", "Local Tangent", "Local Variety" }));

		JProgressBar progressBar = new JProgressBar();

		JLabel lblProgressBar = new JLabel("Progress Bar: ");
		
		JLabel lblSaveAs = new JLabel("Save as:");
		lblSaveAs.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		JButton button_1 = new JButton("Browse");
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblRaster_1, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblRaster)
						.addComponent(lblProgressBar)
						.addComponent(lblSaveAs, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
								.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
								.addComponent(textField, GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
								.addComponent(textField_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
								.addGroup(Alignment.LEADING, gl_contentPanel.createSequentialGroup()
									.addComponent(lblLocalOperations)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(comboBox, 0, 149, Short.MAX_VALUE)))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
									.addComponent(button, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(btnBrowse, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
						.addComponent(progressBar, GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnBrowse)
						.addComponent(lblRaster))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(button)
						.addComponent(lblRaster_1))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
								.addComponent(button_1)
								.addComponent(lblSaveAs))
							.addGap(18)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblLocalOperations))
							.addGap(28)
							.addComponent(progressBar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addComponent(lblProgressBar, Alignment.TRAILING))
					.addContainerGap())
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
			JButton btnRun = new JButton("Run");
			btnRun.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e){
					Layer layer1 = new Layer("layer1",textField.getText());
					Layer layer2 = new Layer("layer2",textField_1.getText());
					String operations = (String)comboBox.getSelectedItem();
					Layer layer_sum = layer1.localSum(layer2, "sumlayer");
					layer_sum.save("./result/sum.txt");
				}
			});
			btnRun.setActionCommand("OK");
			buttonPane.add(btnRun);
			{
				JButton okButton = new JButton("Cancel");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Help");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
