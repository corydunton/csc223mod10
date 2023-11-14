package edu.vwcc.binarytree;

import javax.swing.*;
import java.awt.*;

/*
 * A GUI class that displays a simple visualization of a binary tree in new window
 */

public class TreeGUI<T> {

	/*
	 * GUI method to visualize binary tree in new window
	 * 
	 * @param requires reference to root node of the binary tree
	 */
	
	public static <T> void displayTree(Node<T> rootNode) {
		JFrame bFrame = new JFrame("Graphical Display of Binary Tree");
		bFrame.setMinimumSize(new Dimension(300, 200)); // Set minimum window size
		bFrame.add(new BTreeDisplay<>(rootNode));
		bFrame.pack();
		bFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		bFrame.setLocationRelativeTo(null); // Center the frame
		bFrame.setVisible(true);
	}

	// HELPER GUI CLASSES AND METHODS
	private static class BTreeDisplay<T> extends JPanel {
		BTreeDisplay(Node<T> tree) {
			setBorder(BorderFactory.createEtchedBorder());
			setLayout(new BorderLayout());
			if (tree != null) {
				String labelText = "<html><div style='border:2px solid gray; padding:4px;'>" + tree.value
						+ "</div></html>";
				JLabel rootLabel = new JLabel(labelText, SwingConstants.CENTER);
				rootLabel.setPreferredSize(new Dimension(30, 30));
				rootLabel.setHorizontalAlignment(JLabel.CENTER);
				rootLabel.setVerticalAlignment(JLabel.CENTER);
				add(rootLabel, BorderLayout.NORTH);

				JPanel panel = new JPanel(new GridLayout(1, 2));
				panel.add(new BTreeDisplay<>(tree.left));
				panel.add(new BTreeDisplay<>(tree.right));
				add(panel, BorderLayout.CENTER);
			} else {
				// Optionally, display an empty placeholder for better spacing
				setPreferredSize(new Dimension(15, 15)); // Empty node placeholder size
			}
		}
	}
}
