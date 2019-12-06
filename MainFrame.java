package WindowBuilder.views;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.UIManager;
import javax.swing.GroupLayout;
import javax.swing.JFileChooser;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Font;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.border.BevelBorder;
import java.awt.SystemColor;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileFilter;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {
	private JPanel ctpMain;
	private JPanel ViewerPanel;
	private JPanel DisplayPanel;
	private JMenuItem mntmExit;
	private JMenuItem mntmRasters;
	private JMenuItem mntmContactSupport;
	private JMenuItem mntmLocalOperation;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField txtTypeToLocate;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() 
	{
		setFont(new Font("Adobe Caslon Pro", Font.BOLD, 15));
		initComponents();
		createEvents();
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////// This method contains all the code for creating and initializing components
	///////////////////////////////////////////////////////////////////////////////////////////////////////////
	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 777, 505);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		mnFile.setFont(new Font("Dialog", Font.BOLD, 14));
		menuBar.add(mnFile);
		
		JMenuItem mntmNewProject = new JMenuItem("New Project");
		mnFile.add(mntmNewProject);
		
		JMenu mnOpen = new JMenu("Open");
		mnFile.add(mnOpen);
		
		
		mntmRasters = new JMenuItem("Rasters");
		mnOpen.add(mntmRasters);
		

		JMenuItem mntmSave = new JMenuItem("Save");
		mnFile.add(mntmSave);
		
		JMenuItem mntmSaveAs = new JMenuItem("Save as");
		mnFile.add(mntmSaveAs);
		
		mntmExit = new JMenuItem("Exit");
		mntmExit.setIcon(new ImageIcon(MainFrame.class.getResource("/WindowBuilder/resources/glove_16.png")));
		mnFile.add(mntmExit);
		
		JMenu mnOperations = new JMenu("Operations");
		mnOperations.setFont(new Font("Dialog", Font.BOLD, 14));
		menuBar.add(mnOperations);
		
		mntmLocalOperation = new JMenuItem("Local Operations");
		mnOperations.add(mntmLocalOperation);
		
		JMenuItem mntmFocalOperations = new JMenuItem("Focal Operations");
		mnOperations.add(mntmFocalOperations);
		
		JMenuItem mntmZonalOperations = new JMenuItem("Zonal Operations");
		mnOperations.add(mntmZonalOperations);
		
		JMenu mnHelp = new JMenu("Help");
		mnHelp.setFont(new Font("Dialog", Font.BOLD, 14));
		menuBar.add(mnHelp);
		
		mntmContactSupport = new JMenuItem("Contact support");
		mnHelp.add(mntmContactSupport);
		
		JMenuItem mntmHelpManual = new JMenuItem("Help Manual");
		mnHelp.add(mntmHelpManual);
		ctpMain = new JPanel();
		ctpMain.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(ctpMain);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.menu);
		panel.setBorder(new TitledBorder(null, "Contents", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setName("Contents");
		
		ViewerPanel = new JPanel();
		ViewerPanel.setBorder(new TitledBorder(null, "Viewer", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JPanel pnlcoordinates = new JPanel();
		pnlcoordinates.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		JPanel panel_1 = new JPanel();
		panel_1.setName("Contents");
		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Preview", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));
		panel_1.setBackground(SystemColor.menu);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 169, Short.MAX_VALUE)
				.addComponent(scrollPane_2, GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGap(0, 407, Short.MAX_VALUE)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addComponent(scrollPane_2, GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel_1.setLayout(gl_panel_1);
		GroupLayout gl_ctpMain = new GroupLayout(ctpMain);
		gl_ctpMain.setHorizontalGroup(
			gl_ctpMain.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_ctpMain.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(ViewerPanel, GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE))
				.addComponent(pnlcoordinates, GroupLayout.DEFAULT_SIZE, 751, Short.MAX_VALUE)
		);
		gl_ctpMain.setVerticalGroup(
			gl_ctpMain.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_ctpMain.createSequentialGroup()
					.addGroup(gl_ctpMain.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(ViewerPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 407, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(pnlcoordinates, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
		);
		
		JLabel lblCoordinatesxY = new JLabel("Coordinates (x, y):");
		
		JLabel lblCoordinatesrc = new JLabel("Coordinates (r, c):");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		txtTypeToLocate = new JTextField();
		txtTypeToLocate.setFont(new Font("Tahoma", Font.ITALIC, 11));
		txtTypeToLocate.setText(" Type to locate");
		txtTypeToLocate.setColumns(10);
		
		JLabel lblReady = new JLabel("Ready!");
		GroupLayout gl_pnlcoordinates = new GroupLayout(pnlcoordinates);
		gl_pnlcoordinates.setHorizontalGroup(
			gl_pnlcoordinates.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlcoordinates.createSequentialGroup()
					.addComponent(txtTypeToLocate, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
					.addGap(2)
					.addComponent(lblReady)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblCoordinatesxY)
					.addGap(12)
					.addComponent(textField, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblCoordinatesrc, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
					.addGap(197))
		);
		gl_pnlcoordinates.setVerticalGroup(
			gl_pnlcoordinates.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlcoordinates.createSequentialGroup()
					.addGap(0, 0, Short.MAX_VALUE)
					.addGroup(gl_pnlcoordinates.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCoordinatesrc)
						.addComponent(lblCoordinatesxY)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtTypeToLocate, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblReady)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		pnlcoordinates.setLayout(gl_pnlcoordinates);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_ViewerPanel = new GroupLayout(ViewerPanel);
		gl_ViewerPanel.setHorizontalGroup(
			gl_ViewerPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_ViewerPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_ViewerPanel.setVerticalGroup(
			gl_ViewerPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_ViewerPanel.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		DisplayPanel = new JPanel();
		DisplayPanel.setForeground(Color.BLACK);
		DisplayPanel.setBackground(Color.BLACK);
		DisplayPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		scrollPane.setViewportView(DisplayPanel);
		ViewerPanel.setLayout(gl_ViewerPanel);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		ctpMain.setLayout(gl_ctpMain);
		setTitle("Kringle 1.0");
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainFrame.class.getResource("/WindowBuilder/resources/Santa_260.png")));
		
	}

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////// This method contains all the code for creating events 
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////
	private void createEvents() {
		// The Local Operations window
		mntmLocalOperation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LocalOperations localoperation = new LocalOperations ();
				localoperation.setModal(true);
				localoperation.setVisible(true);
			}
			
		});
		
		// The Contact Support window launch
		mntmContactSupport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ContactSupport contactsupport = new ContactSupport();
				contactsupport.setModal(true);
				contactsupport.setVisible(true);
			}
		});
		
		//importing and displaying the image on the viewer
		int scale = 3;
		final JFileChooser fileChooser = new JFileChooser();
		fileChooser.addChoosableFileFilter(new FileFilter() {
			public String getDescription() {
				return "ASCII (*.txt)";		}

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
				
		mntmRasters.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = fileChooser.showOpenDialog(MainFrame.this);
				if (result == JFileChooser.APPROVE_OPTION) {
					File[] selectedFiles = fileChooser.getSelectedFiles();
					for (int i = 0; i < selectedFiles.length; i++) {
						System.out.println("Selected file: " + selectedFiles[i].getAbsolutePath());
						Layer layer = new Layer("layer", selectedFiles[i].getAbsolutePath());
						BufferedImage layerImage;
						layerImage = layer.toImage();
						MapPanel mapPanel = new MapPanel(layerImage, scale);
						DisplayPanel.add(mapPanel, BorderLayout.CENTER);
						mapPanel.setBounds(i * 500, 1, 500, 500);
					}
				}
			}
		});
		
		//Exit software
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ret = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?");
				if (ret == JOptionPane.YES_NO_OPTION)
				{int ret1 = JOptionPane.showConfirmDialog(null, "Did you save your work?");
				if (ret1 == JOptionPane.YES_NO_OPTION)
				System.exit(0);}
			}
		});
	}
}